
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
    static final int voice_28ch = FOURCC("28CH");
    static final int voice_6chn = FOURCC("6CHN");
    static final int voice_8chn = FOURCC("8CHN");
    static final int voiceFlt4 = FOURCC("FLT4");
    static final int voiceFlt8 = FOURCC("FLT8");
    static final int voiceMk = FOURCC("M.K.");
    static final int voiceMk2 = FOURCC("M!K!");
    static final int voiceMk3 = FOURCC("M&K!");
    static final int[] voice_31List = {
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
        for (int i_12_ = i - 1; i_12_ >= 0; i_12_--)
            if (is[i_12_] != 0)
                return new String(is, 0, 0, i_12_ + 1);
        return "";
    }

    static final int readu16(final DataInputStream datainputstream) throws IOException {
        return datainputstream.readShort() & 0xffff;
    }

    static final int readu8(final DataInputStream datainputstream) throws IOException {
        return datainputstream.readByte() & 0xff;
    }

    ModInstrument[] insts;
    boolean loaded = false;
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
            final byte[] is_4_ = new byte[i];
            int i_5_ = 0;
            int i_6_;
            for (/**/; i > 0; i -= i_6_) {
                i_6_ = zipinputstream.read(is_4_, i_5_, i);
                i_5_ += i_6_;
            }
            LoadMod(new ByteArrayInputStream(is_4_));
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
            int i_0_ = 0;
            int i_1_;
            for (/**/; i > 0; i -= i_1_) {
                i_1_ = zipinputstream.read(is, i_0_, i);
                i_0_ += i_1_;
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
            int i_2_ = 0;
            int i_3_;
            for (/**/; i > 0; i -= i_3_) {
                i_3_ = zipinputstream.read(is, i_2_, i);
                i_2_ += i_3_;
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
        final int i_7_ = datainputstream.readInt();
        datainputstream.reset();
        for (int i_8_ = 0; i_8_ < voice_31List.length; i_8_++)
            if (i_7_ == voice_31List[i_8_]) {
                i = 31;
                break;
            }
        if (i == 31)
            if (i_7_ == voice_8chn)
                numtracks = 8;
            else if (i_7_ == voice_6chn)
                numtracks = 6;
            else if (i_7_ == voice_28ch)
                numtracks = 28;
        insts = new ModInstrument[i];
        for (int i_9_ = 0; i_9_ < i; i_9_++)
            insts[i_9_] = readInstrument(datainputstream);
        readSequence(datainputstream);
        datainputstream.skipBytes(4);
        readPatterns(datainputstream);
        try {
            for (int i_10_ = 0; i_10_ < i; i_10_++)
                readSampleData(datainputstream, insts[i_10_]);
        } catch (final EOFException eofexception) {
            System.out.println("Warning: EOF on MOD file");
        }
        datainputstream.close();
        inputstream.close();
    }

    void readPatterns(final DataInputStream datainputstream) throws IOException {
        final int i = numtracks * 4 * 64;
        patterns = new byte[numpatterns][];
        for (int i_11_ = 0; i_11_ < numpatterns; i_11_++) {
            patterns[i_11_] = new byte[i];
            datainputstream.readFully(patterns[i_11_], 0, i);
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
