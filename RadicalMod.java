
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3)
// Source File Name:   RadicalMod.java

import java.net.URL;

public class RadicalMod {

	String imod;

	int loaded;

	boolean playing;

	String pmod;

	int rvol;

	SuperClip sClip;

	public RadicalMod() {
		playing = false;
		loaded = 0;
		rvol = 0;
		imod = "";
		pmod = "";
		loaded = 0;
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

	public RadicalMod(String string, int i, int i_0_, final int i_1_, final boolean bool, final boolean bool_2_) {
		playing = false;
		loaded = 0;
		rvol = 0;
		imod = "";
		pmod = "";
		final int i_3_ = 22000;
		i_0_ = (int) (i_0_ / 8000F * 2.0F * i_3_);
		i = (int) (i * 0.8F);
		try {
			Mod mod;
			if (!bool_2_)
				mod = new Mod(string);
			else {
				string = string.replace(' ', '_');
				final URL url = new URL(
						new StringBuilder().append("http://multiplayer.needformadness.com/tracks/music/").append(string)
								.append(".zip").toString());
				mod = new Mod(url);
			}
			if (mod.loaded) {
				final ModSlayer modslayer = new ModSlayer(mod, i_0_, i, i_1_);
				final byte is[] = modslayer.turnbytesNorm(bool);
				if (bool)
					rvol = modslayer.olav;
				sClip = new SuperClip(is, modslayer.oln, i_3_);
				loaded = 2;
			}
		} catch (final Exception exception) {
			System.out.println(
					new StringBuilder().append("Error downloading and making Mod: ").append(exception).toString());
			loaded = 0;
		}
		System.runFinalization();
		System.gc();
	}

	public void loadimod(final boolean bool) {
		if (loaded == 1) {
			final int i = 44000;
			int i_6_ = 160;
			if (bool)
				i_6_ = 300;
			final int i_7_ = 125;
			final Mod mod = new Mod(imod);
			try {
				if (mod.loaded) {
					final ModSlayer modslayer = new ModSlayer(mod, i, i_6_, i_7_);
					final byte is[] = modslayer.turnbytesNorm(bool);
					if (bool)
						rvol = modslayer.olav;
					sClip = new SuperClip(is, modslayer.oln, 22000);
					loaded = 2;
				}
			} catch (final Exception exception) {
				System.out.println(new StringBuilder().append("Error making a imod: ").append(exception).toString());
				exception.printStackTrace();
				loaded = 0;
			}
			System.runFinalization();
			System.gc();
		}
	}

	public void loadpmod(final boolean bool) {
		if (loaded == 1) {
			final int i = 44000;
			int i_10_ = 160;
			if (bool)
				i_10_ = 300;
			final int i_11_ = 125;
			final Mod mod = new Mod(pmod);
			try {
				if (mod.loaded) {
					final ModSlayer modslayer = new ModSlayer(mod, i, i_10_, i_11_);
					final byte is[] = modslayer.turnbytesNorm(bool);
					if (bool)
						rvol = modslayer.olav;
					sClip = new SuperClip(is, modslayer.oln, 22000);
					loaded = 2;
				}
			} catch (final Exception exception) {
				System.out.println(new StringBuilder().append("Error making a imod: ").append(exception).toString());
				exception.printStackTrace();
				loaded = 0;
			}
			System.runFinalization();
			System.gc();
		}
	}

	public void play() {
		if (!playing && loaded == 2) {
			sClip.play();
			if (sClip.stoped == 0)
				playing = true;
		}
	}

	public void resume() {
		if (!playing && loaded == 2) {
			sClip.resume();
			if (sClip.stoped == 0)
				playing = true;
		}
	}

	public void stop() {
		if (playing && loaded == 2) {
			sClip.stop();
			playing = false;
		}
	}

	protected void unload() {
		if (playing && loaded == 2) {
			sClip.stop();
			playing = false;
		}
		try {
			sClip.close();
			sClip = null;
		} catch (final Exception _ex) {
		}
		try {
			imod = null;
		} catch (final Exception _ex) {
		}
		System.gc();
		loaded = 0;
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
			} catch (final Exception _ex) {
			}
			System.gc();
			loaded = 1;
		}
	}
}
