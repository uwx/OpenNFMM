package stagemaker;

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
        this.stoped = 2;
        this.skiprate = i_0_;
        this.stream = new ByteArrayInputStream(is, 0, i);
    }
    
    public void run() {
        boolean bool = false;
        try {
            AudioFormat audioformat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, (float) this.skiprate, 16, 1, 2, (float) this.skiprate, false);
            DataLine.Info info = new DataLine.Info(null, audioformat);
            this.source = (SourceDataLine) AudioSystem.getLine(info);
            this.source.open(audioformat);
            this.source.start();
        } catch (Exception exception) {
            this.stoped = 1;
        }
        while (this.stoped == 0) {
            try {
                if (this.source.available() < this.skiprate || !bool) {
                    byte[] is = new byte[this.skiprate * 2];
                    int i = this.stream.read(is, 0, is.length);
                    if (i == -1) {
                        this.stream.reset();
                        this.stream.read(is, 0, is.length);
                    }
                    this.source.write(is, 0, is.length);
                    bool = true;
                }
            } catch (Exception exception) {
                System.out.println(new StringBuilder().append("Play error: ").append(exception).toString());
                this.stoped = 1;
            }
            try {
                if (this.cliper != null) {
                    /* empty */
                }
                Thread.sleep(200L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        this.source.stop();
        this.source.close();
        this.source = null;
        this.stoped = 2;
    }
    
    public void play() {
        if (this.stoped == 2) {
            this.stoped = 0;
            try {
                this.stream.reset();
            } catch (Exception exception) {
                /* empty */
            }
            this.cliper = new Thread(this);
            this.cliper.start();
        }
    }
    
    public void resume() {
        if (this.stoped == 2) {
            this.stoped = 0;
            this.cliper = new Thread(this);
            this.cliper.start();
        }
    }
    
    public void stop() {
        if (this.stoped == 0) {
            this.stoped = 1;
            if (this.source != null)
                this.source.stop();
        }
    }
    
    public void close() {
        try {
            this.stream.close();
            this.stream = null;
        } catch (Exception exception) {
            /* empty */
        }
    }
}
