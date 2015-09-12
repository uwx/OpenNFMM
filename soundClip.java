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
            sound = AudioSystem.getAudioInputStream(bytearrayinputstream);
            sound.mark(is.length);
            clip = AudioSystem.getClip();
            loaded = true;
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Loading Clip error: ").append(exception).toString());
            loaded = false;
        }
    }
    
    public void play() {
        if (loaded) {
            if (!clip.isOpen()) {
                try {
                    clip.open(sound);
                } catch (Exception exception) {
                    /* empty */
                }
                clip.loop(0);
            } else
                clip.loop(1);
            lfrpo = -1;
            cntcheck = 5;
        }
    }
    
    public void loop() {
        if (loaded) {
            if (!clip.isOpen()) {
                try {
                    clip.open(sound);
                } catch (Exception exception) {
                    /* empty */
                }
            }
            clip.loop(70);
            lfrpo = -2;
            cntcheck = 0;
        }
    }
    
    public void stop() {
        if (loaded) {
            clip.stop();
            lfrpo = -1;
        }
    }
    
    public void checkopen() {
        if (loaded && clip.isOpen() && lfrpo != -2) {
            if (cntcheck == 0) {
                int i = clip.getFramePosition();
                if (lfrpo == i && !clip.isRunning()) {
                    try {
                        clip.close();
                        sound.reset();
                    } catch (Exception exception) {
                        /* empty */
                    }
                    lfrpo = -1;
                } else
                    lfrpo = i;
            } else
                cntcheck--;
        }
    }
}
