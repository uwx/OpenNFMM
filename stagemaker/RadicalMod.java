package stagemaker;

/* RadicalMod - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.net.URL;

public class RadicalMod
{
    SuperClip sClip;
    boolean playing = false;
    int loaded = 0;
    int rvol = 0;
    String imod = "";
    String pmod = "";
    
    public RadicalMod() {
        this.loaded = 0;
        System.gc();
    }
    
    public RadicalMod(String string, int i, int i_0_, int i_1_, boolean bool, boolean bool_2_) {
        int i_3_ = 22000;
        i_0_ = (int) ((float) i_0_ / 8000.0F * 2.0F * (float) i_3_);
        i *= 0.8F;
        try {
            Object object = null;
            Mod mod;
            if (!bool_2_)
                mod = new Mod(string);
            else {
                string = string.replace(' ', '_');
                URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/tracks/music/").append(string).append(".zip").toString());
                mod = new Mod(url);
            }
            if ((mod).loaded) {
                ModSlayer modslayer = new ModSlayer(mod, i_0_, i, i_1_);
                byte[] is = modslayer.turnbytesNorm(bool);
                if (bool)
                    this.rvol = (modslayer).olav;
                this.sClip = new SuperClip(is, (modslayer).oln, i_3_);
                Object object_4_ = null;
                object = null;
                Object object_5_ = null;
                this.loaded = 2;
            }
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Error downloading and making Mod: ").append(exception).toString());
            this.loaded = 0;
        }
        System.runFinalization();
        System.gc();
    }
    
    public RadicalMod(String string) {
        this.loaded = 1;
        this.imod = string;
    }
    
    public void loadimod(boolean bool) {
        if (this.loaded == 1) {
            int i = 44000;
            int i_6_ = 160;
            if (bool)
                i_6_ = 300;
            int i_7_ = 125;
            Mod mod = new Mod(this.imod);
            try {
                if ((mod).loaded) {
                    ModSlayer modslayer = new ModSlayer(mod, i, i_6_, i_7_);
                    byte[] is = modslayer.turnbytesNorm(bool);
                    if (bool)
                        this.rvol = (modslayer).olav;
                    this.sClip = new SuperClip(is, (modslayer).oln, 22000);
                    Object object = null;
                    Object object_8_ = null;
                    Object object_9_ = null;
                    this.loaded = 2;
                }
            } catch (Exception exception) {
                System.out.println(new StringBuilder().append("Error making a imod: ").append(exception).toString());
                this.loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }
    
    public void loadpmod(boolean bool) {
        if (this.loaded == 1) {
            int i = 44000;
            int i_10_ = 160;
            if (bool)
                i_10_ = 300;
            int i_11_ = 125;
            Mod mod = new Mod(this.pmod);
            try {
                if ((mod).loaded) {
                    ModSlayer modslayer = new ModSlayer(mod, i, i_10_, i_11_);
                    byte[] is = modslayer.turnbytesNorm(bool);
                    if (bool)
                        this.rvol = (modslayer).olav;
                    this.sClip = new SuperClip(is, (modslayer).oln, 22000);
                    Object object = null;
                    Object object_12_ = null;
                    Object object_13_ = null;
                    this.loaded = 2;
                }
            } catch (Exception exception) {
                System.out.println(new StringBuilder().append("Error making a imod: ").append(exception).toString());
                this.loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }
    
    public RadicalMod(String string, boolean bool) {
        this.loaded = 1;
        this.pmod = string;
        loadpmod(true);
    }
    
    public void play() {
        if (!this.playing && this.loaded == 2) {
            this.sClip.play();
            if ((this.sClip).stoped == 0)
                this.playing = true;
        }
    }
    
    public void resume() {
        if (!this.playing && this.loaded == 2) {
            this.sClip.resume();
            if ((this.sClip).stoped == 0)
                this.playing = true;
        }
    }
    
    public void stop() {
        if (this.playing && this.loaded == 2) {
            this.sClip.stop();
            this.playing = false;
        }
    }
    
    protected void unloadimod() {
        if (this.loaded == 2) {
            if (this.playing) {
                this.sClip.stop();
                this.playing = false;
            }
            try {
                this.sClip.close();
                this.sClip = null;
            } catch (Exception exception) {
                /* empty */
            }
            System.gc();
            this.loaded = 1;
        }
    }
    
    protected void unload() {
        if (this.playing && this.loaded == 2) {
            this.sClip.stop();
            this.playing = false;
        }
        try {
            this.sClip.close();
            this.sClip = null;
        } catch (Exception exception) {
            /* empty */
        }
        try {
            this.imod = null;
        } catch (Exception exception) {
            /* empty */
        }
        System.gc();
        this.loaded = 0;
    }
}
