// Credits to DragShot
// for his shit

import java.net.URL;

import ds.nfm.Module;
import ds.nfm.ModuleLoader;
import ds.nfm.ModuleSlayer;

class RadicalMod implements RadicalMusic {
    private static String name = "";
    SuperClip sClip;
    boolean playing;
    int loaded;
    int rvol;
    private String imod;
    private String pmod;

    public RadicalMod() {
        playing = false;
        loaded = 0;
        rvol = 0;
        imod = "";
        pmod = "";
        loaded = 0;
        System.gc();
    }

    public RadicalMod(String string, int i, int i_0, final int i_1, final boolean bool, final boolean bool_2) {
        playing = false;
        loaded = 0;
        rvol = 0;
        imod = "";
        pmod = "";
        final int i_3 = 22000;
        i_0 = (int) (i_0 / 8000F * 2.0F * i_3);
        i = (int) (i * 0.8F);
        try {
            Module module;
            if (!bool_2) {
                module = ModuleLoader.loadMod(string);
            } else {
                string = string.replace(' ', '_');
                final URL url = new URL("http://multiplayer.needformadness.com/tracks/music/" + string + ".zip");
                module = ModuleLoader.loadMod(url);
            }
            if (module.isLoaded()) {
                name = module.getName();
                if ("".equals(name.trim())) {
                    name = "Untitled";
                }
                final ModuleSlayer moduleslayer = ModuleLoader.prepareSlayer(module, i_0, i, i_1);
                final byte is[] = moduleslayer.turnbytesNorm(bool);
                if (bool) {
                    rvol = moduleslayer.olav;
                }
                sClip = new SuperClip(is, moduleslayer.oln, i_3);
                sClip.rollBackPos = moduleslayer.rollBackPos;
                sClip.rollBackTrig = moduleslayer.oln - moduleslayer.rollBackTrig;
                loaded = 2;
            }
        } catch (final Exception exception) {
            exception.printStackTrace();
            System.out.println("Error downloading and making Mod: " + exception);
            loaded = 0;
        }
        System.runFinalization();
        System.gc();
    }

    public RadicalMod(final String string) {
        playing = false;
        loaded = 0;
        rvol = 0;
        imod = "";
        pmod = "";
        loaded = 1;
        imod = string;
        loadimod(false);
    }

    String getTimer(int secs) {
        final int mins = secs / 60;
        secs %= 60;
        if (secs >= 10) {
            return "" + mins + ":" + secs;
        } else {
            return "" + mins + ":0" + secs;
        }
    }

    private void loadimod(final boolean bool) {
        if (loaded == 1) {
            final int i = 44000;
            int i_6 = 160;
            if (bool) {
                i_6 = 300;
            }
            final int i_7 = 125;
            try {
                final Module module = ModuleLoader.loadMod(imod);
                if (module.isLoaded()) {
                    name = module.getName();
                    if ("".equals(name.trim())) {
                        name = "Untitled";
                    }
                    final ModuleSlayer moduleslayer = ModuleLoader.prepareSlayer(module, i, i_6, i_7);
                    final byte is[] = moduleslayer.turnbytesNorm(bool);
                    if (bool) {
                        rvol = moduleslayer.olav;
                    }
                    sClip = new SuperClip(is, moduleslayer.oln, 22000);
                    sClip.rollBackPos = moduleslayer.rollBackPos;
                    sClip.rollBackTrig = moduleslayer.oln - moduleslayer.rollBackTrig;
                    loaded = 2;
                }
            } catch (final Exception exception) {
                System.out.println("Error making a imod: " + exception);
                loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }

    private void loadpmod(final boolean bool) {
        if (loaded == 1) {
            final int i = 44000;
            int i_10 = 160;
            if (bool) {
                i_10 = 300;
            }
            final int i_11 = 125;
            try {
                final Module module = ModuleLoader.loadMod(pmod);
                if (module.isLoaded()) {
                    name = module.getName();
                    if ("".equals(name.trim())) {
                        name = "Untitled";
                    }
                    final ModuleSlayer moduleslayer = ModuleLoader.prepareSlayer(module, i, i_10, i_11);
                    final byte is[] = moduleslayer.turnbytesNorm(bool);
                    if (bool) {
                        rvol = moduleslayer.olav;
                    }
                    sClip = new SuperClip(is, moduleslayer.oln, 22000);
                    sClip.rollBackPos = moduleslayer.rollBackPos;
                    sClip.rollBackTrig = moduleslayer.oln - moduleslayer.rollBackTrig;
                    loaded = 2;
                }
            } catch (final Exception exception) {
                System.out.println("Error making a imod: " + exception);
                loaded = 0;
            }
            System.runFinalization();
            System.gc();
        }
    }

    public RadicalMod(final String string, final boolean bool) {
        playing = false;
        loaded = 0;
        rvol = 0;
        imod = "";
        pmod = "";
        loaded = 1;
        pmod = string;
        loadpmod(true);
    }

    @Override
    public void play() {
        if (!playing && loaded == 2) {
            sClip.play();
            if (sClip.stoped == 0) {
                playing = true;
            }
        }
    }

    protected void unloadimod() {
        if (loaded == 2) {
            if (playing) {
                sClip.stop();
                playing = false;
            }
            try {
                sClip.close();
                sClip = null;
            } catch (final Exception exception) {
            }
            System.gc();
            loaded = 1;
        }
    }

    @Override
    public void unload() {
        if (playing && loaded == 2) {
            sClip.stop();
            playing = false;
        }
        try {
            sClip.close();
            sClip = null;
        } catch (final Exception exception) {
        }
        try {
            imod = null;
        } catch (final Exception exception) {
        }
        System.gc();
        loaded = 0;
    }

    @Override
    @Deprecated
    public void resume() {
        if (!playing && loaded == 2) {
            sClip.resume();
            if (sClip.stoped == 0) {
                playing = true;
            }
        }
    }

    @Override
    @Deprecated
    public void stop() {
        if (playing && loaded == 2) {
            sClip.stop();
            playing = false;
        }
    }

    @Override
    public void setPaused(final boolean pause) {
        if (pause) {
            if (playing && loaded == 2) {
                sClip.stop();
                playing = false;
            }
        } else if (!playing && loaded == 2) {
            sClip.resume();
            if (sClip.stoped == 0) {
                playing = true;
            }
        }
    }

    @Override
    public boolean isPaused() {
        return !playing;
    }

    @Override
    public int getType() {
        return RadicalMusic.TYPE_MOD;
    }
}
