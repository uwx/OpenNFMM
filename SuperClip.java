/* SuperClip - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.io.ByteArrayInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
public class SuperClip implements Runnable
{
    int skiprate = 0;
    Thread cliper;
    int stoped = 1;
    SourceDataLine source = null;
    ByteArrayInputStream stream;
    
    public SuperClip(byte[] is, int i, int i_0_) {
        stoped = 2;
        skiprate = i_0_;
        stream = new ByteArrayInputStream(is, 0, i);
    }
    
    public void run() {
        boolean bool = false;
        try {
            AudioFormat audioformat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, (float) skiprate, 16, 1, 2, (float) skiprate, false);
            DataLine.Info info = new DataLine.Info(null, audioformat);
            source = (SourceDataLine) AudioSystem.getLine(info);
            source.open(audioformat);
            source.start();
        } catch (Exception exception) {
            stoped = 1;
        }
        while (stoped == 0) {
            try {
                if (source.available() < skiprate || !bool) {
                    byte[] is = new byte[skiprate * 2];
                    int i = stream.read(is, 0, is.length);
                    if (i == -1) {
                        stream.reset();
                        stream.read(is, 0, is.length);
                    }
                    source.write(is, 0, is.length);
                    bool = true;
                }
            } catch (Exception exception) {
                System.out.println(new StringBuilder().append("Play error: ").append(exception).toString());
                stoped = 1;
            }
            try {
                if (cliper != null) {
                    /* empty */
                }
                Thread.sleep(200L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        source.stop();
        source.close();
        source = null;
        stoped = 2;
    }
    
    public void play() {
        if (stoped == 2) {
            stoped = 0;
            try {
                stream.reset();
            } catch (Exception exception) {
                /* empty */
            }
            cliper = new Thread(this);
            cliper.start();
        }
    }
    
    public void resume() {
        if (stoped == 2) {
            stoped = 0;
            cliper = new Thread(this);
            cliper.start();
        }
    }
    
    public void stop() {
        if (stoped == 0) {
            stoped = 1;
            if (source != null)
                source.stop();
        }
    }
    
    public void close() {
        try {
            stream.close();
            stream = null;
        } catch (Exception exception) {
            /* empty */
        }
    }
}
