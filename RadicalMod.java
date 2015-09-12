// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RadicalMod.java

import java.net.URL;

public class RadicalMod
{

    public RadicalMod()
    {
        playing = false;
        loaded = 0;
        rvol = 0;
        imod = "";
        pmod = "";
        loaded = 0;
        System.gc();
    }

    public RadicalMod(String string, int i, int i_0_, int i_1_, boolean bool, boolean bool_2_)
    {
        playing = false;
        loaded = 0;
        rvol = 0;
        imod = "";
        pmod = "";
        int i_3_ = 22000;
        i_0_ = (int)(((float)i_0_ / 8000F) * 2.0F * (float)i_3_);
        i = (int)((float)i * 0.8F);
        try
        {
            Mod mod;
            if(!bool_2_)
            {
                mod = new Mod(string);
            } else
            {
                string = string.replace(' ', '_');
                URL url = new URL((new StringBuilder()).append("http://multiplayer.needformadness.com/tracks/music/").append(string).append(".zip").toString());
                mod = new Mod(url);
            }
            if(mod.loaded)
            {
                ModSlayer modslayer = new ModSlayer(mod, i_0_, i, i_1_);
                byte is[] = modslayer.turnbytesNorm(bool);
                if(bool)
                    rvol = modslayer.olav;
                sClip = new SuperClip(is, modslayer.oln, i_3_);
                loaded = 2;
            }
        }
        catch(Exception exception)
        {
            System.out.println((new StringBuilder()).append("Error downloading and making Mod: ").append(exception).toString());
            loaded = 0;
        }
        System.runFinalization();
        System.gc();
    }

    public RadicalMod(String string)
    {
        playing = false;
        loaded = 0;
        rvol = 0;
        imod = "";
        pmod = "";
        loaded = 1;
        imod = string;
    }

    public void loadimod(boolean bool)
    {
        if(loaded == 1)
        {
            int i = 44000;
            int i_6_ = 160;
            if(bool)
                i_6_ = 300;
            int i_7_ = 125;
            Mod mod = new Mod(imod);
            try
            {
                if(mod.loaded)
                {
                    ModSlayer modslayer = new ModSlayer(mod, i, i_6_, i_7_);
                    byte is[] = modslayer.turnbytesNorm(bool);
                    if(bool)
                        rvol = modslayer.olav;
                    sClip = new SuperClip(is, modslayer.oln, 22000);
                    loaded = 2;
                }
            }
            catch(Exception exception)
            {
                System.out.println((new StringBuilder()).append("Error making a imod: ").append(exception).toString());
                loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }

    public void loadpmod(boolean bool)
    {
        if(loaded == 1)
        {
            int i = 44000;
            int i_10_ = 160;
            if(bool)
                i_10_ = 300;
            int i_11_ = 125;
            Mod mod = new Mod(pmod);
            try
            {
                if(mod.loaded)
                {
                    ModSlayer modslayer = new ModSlayer(mod, i, i_10_, i_11_);
                    byte is[] = modslayer.turnbytesNorm(bool);
                    if(bool)
                        rvol = modslayer.olav;
                    sClip = new SuperClip(is, modslayer.oln, 22000);
                    loaded = 2;
                }
            }
            catch(Exception exception)
            {
                System.out.println((new StringBuilder()).append("Error making a imod: ").append(exception).toString());
                loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }

    public RadicalMod(String string, boolean bool)
    {
        playing = false;
        loaded = 0;
        rvol = 0;
        imod = "";
        pmod = "";
        loaded = 1;
        pmod = string;
        loadpmod(true);
    }

    public void play()
    {
        if(!playing && loaded == 2)
        {
            sClip.play();
            if(sClip.stoped == 0)
                playing = true;
        }
    }

    public void resume()
    {
        if(!playing && loaded == 2)
        {
            sClip.resume();
            if(sClip.stoped == 0)
                playing = true;
        }
    }

    public void stop()
    {
        if(playing && loaded == 2)
        {
            sClip.stop();
            playing = false;
        }
    }

    protected void unloadimod()
    {
        if(loaded == 2)
        {
            if(playing)
            {
                sClip.stop();
                playing = false;
            }
            try
            {
                sClip.close();
                sClip = null;
            }
            catch(Exception _ex) { }
            System.gc();
            loaded = 1;
        }
    }

    protected void unload()
    {
        if(playing && loaded == 2)
        {
            sClip.stop();
            playing = false;
        }
        try
        {
            sClip.close();
            sClip = null;
        }
        catch(Exception _ex) { }
        try
        {
            imod = null;
        }
        catch(Exception _ex) { }
        System.gc();
        loaded = 0;
    }

    SuperClip sClip;
    boolean playing;
    int loaded;
    int rvol;
    String imod;
    String pmod;
}
