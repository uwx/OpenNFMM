package nfm.open;
/* nfm.open.Mod - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.io.DataInputStream;
import java.io.IOException;

class Mod {
    /*private static final int voice_28ch = FOURCC("28CH");
    private static final int voice_6chn = FOURCC("6CHN");
    private static final int voice_8chn = FOURCC("8CHN");
    private static final int voiceFlt4 = FOURCC("FLT4");
    private static final int voiceFlt8 = FOURCC("FLT8");
    private static final int voiceMk = FOURCC("M.K.");
    private static final int voiceMk2 = FOURCC("M!K!");
    private static final int voiceMk3 = FOURCC("M&K!");*/

    private ModInstrument[] insts;
    private String name;
    private int numpatterns;
    private int numtracks;

    private byte[][] patterns;

    private byte[] positions;

    boolean s3m;

    private int songLengthPatterns;

    private int songRepeatPatterns;

    int trackShift;

    static int FOURCC(final String string) {
        return string.charAt(3) & 0xff | (string.charAt(2) & 0xff) << 8 | (string.charAt(1) & 0xff) << 16 | (string.charAt(0) & 0xff) << 24;
    }

    private static int readu8(final DataInputStream datainputstream) throws IOException {
        return datainputstream.readByte() & 0xff;
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
        if (songRepeatPatterns > songLengthPatterns) {
            songRepeatPatterns = songLengthPatterns;
        }
        numpatterns = 0;
        for (final byte position : positions)
            if (position > numpatterns) {
                numpatterns = position;
            }
        numpatterns++;
    }

    @Override
    public String toString() {
        return "" + name + " (" + numtracks + " tracks, " + numpatterns + " patterns, " + insts.length + " samples)";
    }
}
