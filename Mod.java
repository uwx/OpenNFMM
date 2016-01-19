
/* Mod - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Mod {
    private static final int voice_28ch = FOURCC("28CH");
    private static final int voice_6chn = FOURCC("6CHN");
    private static final int voice_8chn = FOURCC("8CHN");
    private static final int voiceFlt4 = FOURCC("FLT4");
    private static final int voiceFlt8 = FOURCC("FLT8");
    private static final int voiceMk = FOURCC("M.K.");
    private static final int voiceMk2 = FOURCC("M!K!");
    private static final int voiceMk3 = FOURCC("M&K!");
    private static final int[] voice_31List = {
            voiceMk, voiceMk2, voiceMk3, voiceFlt4, voiceFlt8, voice_8chn, voice_6chn, voice_28ch
    };

    static final int FOURCC(final String string) {
        return string.charAt(3) & 0xff | (string.charAt(2) & 0xff) << 8 | (string.charAt(1) & 0xff) << 16
                | (string.charAt(0) & 0xff) << 24;
    }

    static ModInstrument readInstrument(final DataInputStream datainputstream) throws IOException {
        final ModInstrument modinstrument = new ModInstrument();
        modinstrument.name = readText(datainputstream, 22);
        modinstrument.sampleLength = readu16(datainputstream) << 1;
        modinstrument.samples = new byte[modinstrument.sampleLength + 8];
        modinstrument.finetuneValue = (byte) (readu8(datainputstream) << 4);
        modinstrument.volume = readu8(datainputstream);
        modinstrument.repeatPoint = readu16(datainputstream) << 1;
        modinstrument.repeatLength = readu16(datainputstream) << 1;
        if (modinstrument.repeatPoint > modinstrument.sampleLength)
            modinstrument.repeatPoint = modinstrument.sampleLength;
        if (modinstrument.repeatPoint + modinstrument.repeatLength > modinstrument.sampleLength)
            modinstrument.repeatLength = modinstrument.sampleLength - modinstrument.repeatPoint;
        return modinstrument;
    }

    static void readSampleData(final DataInputStream datainputstream, final ModInstrument modinstrument)
            throws IOException {
        datainputstream.readFully(modinstrument.samples, 0, modinstrument.sampleLength);
        if (modinstrument.repeatLength > 3)
            System.arraycopy(modinstrument.samples, modinstrument.repeatPoint, modinstrument.samples,
                    modinstrument.sampleLength, 8);
    }

    static final String readText(final DataInputStream datainputstream, final int i) throws IOException {
        final byte[] is = new byte[i];
        datainputstream.readFully(is, 0, i);
        for (int i12 = i - 1; i12 >= 0; i12--)
            if (is[i12] != 0)
                return new String(is, 0, 0, i12 + 1);
        return "";
    }

    static final int readu16(final DataInputStream datainputstream) throws IOException {
        return datainputstream.readShort() & 0xffff;
    }

    static final int readu8(final DataInputStream datainputstream) throws IOException {
        return datainputstream.readByte() & 0xff;
    }

    ModInstrument[] insts;
    private boolean loaded = false;
    String name;
    int numpatterns;
    int numtracks;

    byte[][] patterns;

    byte[] positions;

    boolean s3m;

    int songLengthPatterns;

    int songRepeatPatterns;

    int trackShift;

    public Mod(final byte[] is) {
        try {
            final ZipInputStream zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
            final ZipEntry zipentry = zipinputstream.getNextEntry();
            int i = (int) zipentry.getSize();
            final byte[] is4 = new byte[i];
            int i5 = 0;
            int i6;
            for (/**/; i > 0; i -= i6) {
                i6 = zipinputstream.read(is4, i5, i);
                i5 += i6;
            }
            LoadMod(new ByteArrayInputStream(is4));
            loaded = true;
        } catch (final Exception exception) {
            loaded = false;
        }
    }

    public Mod(final String string) {
        try {
            final File file = new File(string);
            final ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));
            final ZipEntry zipentry = zipinputstream.getNextEntry();
            int i = (int) zipentry.getSize();
            final byte[] is = new byte[i];
            int i0 = 0;
            int i1;
            for (/**/; i > 0; i -= i1) {
                i1 = zipinputstream.read(is, i0, i);
                i0 += i1;
            }
            LoadMod(new ByteArrayInputStream(is));
            zipinputstream.close();
            loaded = true;
        } catch (final Exception exception) {
            loaded = false;
        }
    }

    public Mod(final URL url) {
        try {
            final ZipInputStream zipinputstream = new ZipInputStream(new DataInputStream(url.openStream()));
            final ZipEntry zipentry = zipinputstream.getNextEntry();
            int i = (int) zipentry.getSize();
            final byte[] is = new byte[i];
            int i2 = 0;
            int i3;
            for (/**/; i > 0; i -= i3) {
                i3 = zipinputstream.read(is, i2, i);
                i2 += i3;
            }
            LoadMod(new ByteArrayInputStream(is));
            zipinputstream.close();
            loaded = true;
        } catch (final Exception exception) {
            loaded = false;
        }
    }

    public String getName() {
        return name;
    }

    public int getNumPatterns() {
        return numpatterns;
    }

    public int getNumTracks() {
        return numtracks;
    }

    public void LoadMod(final InputStream inputstream) throws IOException {
        final DataInputStream datainputstream = new DataInputStream(inputstream);
        int i = 15;
        numtracks = 4;
        name = readText(datainputstream, 20);
        datainputstream.mark(1068);
        datainputstream.skip(1060L);
        final int i7 = datainputstream.readInt();
        datainputstream.reset();
        for (int i8 = 0; i8 < voice_31List.length; i8++)
            if (i7 == voice_31List[i8]) {
                i = 31;
                break;
            }
        if (i == 31)
            if (i7 == voice_8chn)
                numtracks = 8;
            else if (i7 == voice_6chn)
                numtracks = 6;
            else if (i7 == voice_28ch)
                numtracks = 28;
        insts = new ModInstrument[i];
        for (int i9 = 0; i9 < i; i9++)
            insts[i9] = readInstrument(datainputstream);
        readSequence(datainputstream);
        datainputstream.skipBytes(4);
        readPatterns(datainputstream);
        try {
            for (int i10 = 0; i10 < i; i10++)
                readSampleData(datainputstream, insts[i10]);
        } catch (final EOFException eofexception) {
            System.out.println("Warning: EOF on MOD file");
        }
        datainputstream.close();
        inputstream.close();
    }

    void readPatterns(final DataInputStream datainputstream) throws IOException {
        final int i = numtracks * 4 * 64;
        patterns = new byte[numpatterns][];
        for (int i11 = 0; i11 < numpatterns; i11++) {
            patterns[i11] = new byte[i];
            datainputstream.readFully(patterns[i11], 0, i);
        }
    }

    void readSequence(final DataInputStream datainputstream) throws IOException {
        positions = new byte[128];
        songLengthPatterns = readu8(datainputstream);
        songRepeatPatterns = readu8(datainputstream);
        datainputstream.readFully(positions, 0, 128);
        if (songRepeatPatterns > songLengthPatterns)
            songRepeatPatterns = songLengthPatterns;
        numpatterns = 0;
        for (int i = 0; i < positions.length; i++)
            if (positions[i] > numpatterns)
                numpatterns = positions[i];
        numpatterns++;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append(" (").append(numtracks).append(" tracks, ").append(numpatterns)
                .append(" patterns, ").append(insts.length).append(" samples)").toString();
    }
}
