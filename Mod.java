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
public class Mod
{
    String name;
    int numtracks;
    int track_shift;
    int numpatterns;
    byte[][] patterns;
    ModInstrument[] insts;
    byte[] positions;
    int song_length_patterns;
    int song_repeat_patterns;
    boolean s3m;
    static final int voice_mk = FOURCC("M.K.");
    static final int voice_mk2 = FOURCC("M!K!");
    static final int voice_mk3 = FOURCC("M&K!");
    static final int voice_flt4 = FOURCC("FLT4");
    static final int voice_flt8 = FOURCC("FLT8");
    static final int voice_28ch = FOURCC("28CH");
    static final int voice_8chn = FOURCC("8CHN");
    static final int voice_6chn = FOURCC("6CHN");
    static final int[] voice_31_list = { voice_mk, voice_mk2, voice_mk3, voice_flt4, voice_flt8, voice_8chn, voice_6chn, voice_28ch };
    boolean loaded = false;
    
    public Mod(String string) {
        try {
            File file = new File(string);
            ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));
            ZipEntry zipentry = zipinputstream.getNextEntry();
            int i = (int) zipentry.getSize();
            byte[] is = new byte[i];
            int i_0_ = 0;
            int i_1_;
            for (/**/; i > 0; i -= i_1_) {
                i_1_ = zipinputstream.read(is, i_0_, i);
                i_0_ += i_1_;
            }
            LoadMod(new ByteArrayInputStream(is));
            zipinputstream.close();
            Object object = null;
            loaded = true;
        } catch (Exception exception) {
            loaded = false;
        }
    }
    
    public Mod(URL url) {
        try {
            ZipInputStream zipinputstream = new ZipInputStream(new DataInputStream(url.openStream()));
            ZipEntry zipentry = zipinputstream.getNextEntry();
            int i = (int) zipentry.getSize();
            byte[] is = new byte[i];
            int i_2_ = 0;
            int i_3_;
            for (/**/; i > 0; i -= i_3_) {
                i_3_ = zipinputstream.read(is, i_2_, i);
                i_2_ += i_3_;
            }
            LoadMod(new ByteArrayInputStream(is));
            zipinputstream.close();
            Object object = null;
            loaded = true;
        } catch (Exception exception) {
            loaded = false;
        }
    }
    
    public Mod(byte[] is) {
        try {
            ZipInputStream zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
            ZipEntry zipentry = zipinputstream.getNextEntry();
            int i = (int) zipentry.getSize();
            byte[] is_4_ = new byte[i];
            int i_5_ = 0;
            int i_6_;
            for (/**/; i > 0; i -= i_6_) {
                i_6_ = zipinputstream.read(is_4_, i_5_, i);
                i_5_ += i_6_;
            }
            LoadMod(new ByteArrayInputStream(is_4_));
            loaded = true;
        } catch (Exception exception) {
            loaded = false;
        }
    }
    
    static final int FOURCC(String string) {
        return string.charAt(3) & 0xff | (string.charAt(2) & 0xff) << 8 | (string.charAt(1) & 0xff) << 16 | (string.charAt(0) & 0xff) << 24;
    }
    
    public void LoadMod(InputStream inputstream) throws IOException {
        DataInputStream datainputstream = new DataInputStream(inputstream);
        int i = 15;
        numtracks = 4;
        name = readText(datainputstream, 20);
        datainputstream.mark(1068);
        datainputstream.skip(1060L);
        int i_7_ = datainputstream.readInt();
        datainputstream.reset();
        for (int i_8_ = 0; i_8_ < voice_31_list.length; i_8_++) {
            if (i_7_ == voice_31_list[i_8_]) {
                i = 31;
                break;
            }
        }
        if (i == 31) {
            if (i_7_ == voice_8chn)
                numtracks = 8;
            else if (i_7_ == voice_6chn)
                numtracks = 6;
            else if (i_7_ == voice_28ch)
                numtracks = 28;
        }
        insts = new ModInstrument[i];
        for (int i_9_ = 0; i_9_ < i; i_9_++)
            insts[i_9_] = readInstrument(datainputstream);
        readSequence(datainputstream);
        datainputstream.skipBytes(4);
        readPatterns(datainputstream);
        try {
            for (int i_10_ = 0; i_10_ < i; i_10_++)
                readSampleData(datainputstream, insts[i_10_]);
        } catch (EOFException eofexception) {
            System.out.println("Warning: EOF on MOD file");
        }
        datainputstream.close();
        inputstream.close();
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
    
    static ModInstrument readInstrument(DataInputStream datainputstream) throws IOException {
        ModInstrument modinstrument = new ModInstrument();
        (modinstrument).name = readText(datainputstream, 22);
        (modinstrument).sample_length = readu16(datainputstream) << 1;
        (modinstrument).samples = new byte[(modinstrument).sample_length + 8];
        (modinstrument).finetune_value = (byte) (readu8(datainputstream) << 4);
        (modinstrument).volume = readu8(datainputstream);
        (modinstrument).repeat_point = readu16(datainputstream) << 1;
        (modinstrument).repeat_length = readu16(datainputstream) << 1;
        if ((modinstrument).repeat_point > (modinstrument).sample_length)
            (modinstrument).repeat_point = (modinstrument).sample_length;
        if ((modinstrument).repeat_point + (modinstrument).repeat_length > (modinstrument).sample_length)
            (modinstrument).repeat_length = (modinstrument).sample_length - (modinstrument).repeat_point;
        return modinstrument;
    }
    
    void readPatterns(DataInputStream datainputstream) throws IOException {
        int i = numtracks * 4 * 64;
        patterns = new byte[numpatterns][];
        for (int i_11_ = 0; i_11_ < numpatterns; i_11_++) {
            patterns[i_11_] = new byte[i];
            datainputstream.readFully(patterns[i_11_], 0, i);
        }
    }
    
    static void readSampleData(DataInputStream datainputstream, ModInstrument modinstrument) throws IOException {
        datainputstream.readFully((modinstrument).samples, 0, (modinstrument).sample_length);
        if ((modinstrument).repeat_length > 3)
            System.arraycopy((modinstrument).samples, (modinstrument).repeat_point, (modinstrument).samples, (modinstrument).sample_length, 8);
    }
    
    void readSequence(DataInputStream datainputstream) throws IOException {
        positions = new byte[128];
        song_length_patterns = readu8(datainputstream);
        song_repeat_patterns = readu8(datainputstream);
        datainputstream.readFully(positions, 0, 128);
        if (song_repeat_patterns > song_length_patterns)
            song_repeat_patterns = song_length_patterns;
        numpatterns = 0;
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] > numpatterns)
                numpatterns = positions[i];
        }
        numpatterns++;
    }
    
    static final String readText(DataInputStream datainputstream, int i) throws IOException {
        byte[] is = new byte[i];
        datainputstream.readFully(is, 0, i);
        for (int i_12_ = i - 1; i_12_ >= 0; i_12_--) {
            if (is[i_12_] != 0)
                return new String(is, 0, 0, i_12_ + 1);
        }
        return "";
    }
    
    static final int readu16(DataInputStream datainputstream) throws IOException {
        return datainputstream.readShort() & 0xffff;
    }
    
    static final int readu8(DataInputStream datainputstream) throws IOException {
        return datainputstream.readByte() & 0xff;
    }
    
    public String toString() {
        return new StringBuilder().append(name).append(" (").append(numtracks).append(" tracks, ").append(numpatterns).append(" patterns, ").append(insts.length).append(" samples)").toString();
    }
}
