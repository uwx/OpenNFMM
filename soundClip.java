/* soundClip - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.io.ByteArrayInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class soundClip
{
    Clip clip = null;
    AudioInputStream sound;
    boolean loaded = false;
    int lfrpo = -1;
    int cntcheck = 0;
    int rollBackPos;
    int rollBackTrig;
    
    public soundClip(byte[] is) {
        try {
            ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(is);
            this.sound = AudioSystem.getAudioInputStream(bytearrayinputstream);
            this.sound.mark(is.length);
            this.clip = AudioSystem.getClip();
            this.loaded = true;
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Loading Clip error: ").append(exception).toString());
            this.loaded = false;
        }
    }
    
    public void play() {
        if (this.loaded) {
            if (!this.clip.isOpen()) {
                try {
                    this.clip.open(this.sound);
                } catch (Exception exception) {
                    /* empty */
                }
                this.clip.loop(0);
            } else
                this.clip.loop(1);
            this.lfrpo = -1;
            this.cntcheck = 5;
        }
    }
    
    public void loop() {
        if (this.loaded) {
            if (!this.clip.isOpen()) {
                try {
                    this.clip.open(this.sound);
                } catch (Exception exception) {
                    /* empty */
                }
            }
            this.clip.loop(70);
            this.lfrpo = -2;
            this.cntcheck = 0;
        }
    }
    
    public void stop() {
        if (this.loaded) {
            this.clip.stop();
            this.lfrpo = -1;
        }
    }
    
    public void checkopen() {
        if (this.loaded && this.clip.isOpen() && this.lfrpo != -2) {
            if (this.cntcheck == 0) {
                int i = this.clip.getFramePosition();
                if (this.lfrpo == i && !this.clip.isRunning()) {
                    try {
                        this.clip.close();
                        this.sound.reset();
                    } catch (Exception exception) {
                        /* empty */
                    }
                    this.lfrpo = -1;
                } else
                    this.lfrpo = i;
            } else
                this.cntcheck--;
        }
    }
}
