
/* Madness - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.util.Date;

import javax.swing.JOptionPane;

public class Madness extends Panel {
	static long advtime = 0L;
	static int anti = 1;
	static GameSparker applet;
	static CarMaker cm;
	static DisplayMode defdisp;
	static int endadv = 0;
	static String fpath = "";
	static Frame frame;
	static DisplayMode fulldisp;
	static boolean fullscreen = false;
	static boolean inisetup = false;
	static GraphicsDevice myDevice;
	/**
	 *
	 */
	private static final long serialVersionUID = 8881840450218558380L;
	static StageMaker sm;
	static String testcar = "";
	static int testdrive = 0;
	static int textid = 0;
	static int updateon = 0;
	static String upfile = "";

	public static void advopen() {
		try {
			final File file = new File(
					new StringBuilder().append("").append(fpath).append("data/user.data").toString());
			if (file.exists()) {
				final Date date = new Date();
				final long l = date.getTime();
				if (advtime == 0L || l - advtime > 120000L) {
					final String string = System.getProperty("os.name").toLowerCase();
					if (string.indexOf("win") != -1) {
						final File file_26_ = new File(
								new StringBuilder().append("").append(fpath).append("data/adv.bat").toString());
						boolean bool = false;
						if (!file_26_.exists())
							bool = true;
						else if (file_26_.length() != 81L)
							bool = true;
						if (bool) {
							final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file_26_));
							bufferedwriter.write("cd %programfiles%\\Internet Explorer");
							bufferedwriter.newLine();
							bufferedwriter.write("iexplore -k http://www.needformadness.com/");
							bufferedwriter.newLine();
							bufferedwriter.close();
						}
						final Process process = Runtime.getRuntime().exec(file_26_.getAbsolutePath());
						final DataInputStream datainputstream = new DataInputStream(process.getInputStream());
						while (datainputstream.readLine() != null) {
							/* empty */
						}
					} else
						openurl("http://www.needformadness.com/");
					advtime = l;
					endadv = 1;
				}
			}
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public static void carmaker() {
		try {
			applet.stop();
		} catch (final Exception ex) {
		}
		try {
			cm.stop();
		} catch (final Exception ex) {
		}
		try {
			sm.stop();
		} catch (final Exception ex) {
		}
		frame.removeAll();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		try {
			applet.destroy();
		} catch (final Exception ex) {
		}
		try {
			cm.destroy();
		} catch (final Exception ex) {
		}
		try {
			sm.destroy();
		} catch (final Exception ex) {
		}
		try {
			applet = null;
		} catch (final Exception ex) {
		}
		try {
			cm = null;
		} catch (final Exception ex) {
		}
		try {
			sm = null;
		} catch (final Exception ex) {
		}
		System.gc();
		System.runFinalization();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		cm = new CarMaker();
		frame.add("Center", cm);
		frame.setVisible(true);
		cm.init();
		cm.start();
	}

	public static void checknupdate(final int i) {
		/* :D */ }

	public static void exitfullscreen() {
		frame.dispose();
		frame = new Frame("Need for Madness");
		frame.setBackground(new Color(0, 0, 0));
		frame.setIgnoreRepaint(true);
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.createImage(new StringBuilder().append("").append(fpath).append("data/icon.gif").toString()));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent windowevent) {
				exitsequance();
			}
		});
		frame.add("Center", applet);
		frame.setVisible(true);
		if (myDevice.isFullScreenSupported()) {
			try {
				myDevice.setDisplayMode(defdisp);
			} catch (final Exception exception) {
				/* empty */
			}
			if (myDevice.isDisplayChangeSupported())
				try {
					myDevice.setFullScreenWindow(null);
				} catch (final Exception exception) {
					/* empty */
				}
		}
		frame.setMinimumSize(new Dimension(930, 586));
		frame.setSize(800, 586);
		frame.setExtendedState(6);
		applet.requestFocus();
		fullscreen = false;
	}

	public static void exitsequance() {
		if (updateon == 0 || updateon == 3) {
			if (endadv == 1)
				endadv = 2;
			if (updateon != 3)
				try {
					applet.stop();
				} catch (final Exception ex) {
				}
			try {
				sm.stop();
			} catch (final Exception ex) {
			}
			try {
				cm.stop();
			} catch (final Exception ex) {
			}
			frame.removeAll();
			try {
				Thread.sleep(200L);
			} catch (final Exception exception) {
				/* empty */
			}
			try {
				applet.destroy();
			} catch (final Exception ex) {
			}
			try {
				cm.destroy();
			} catch (final Exception ex) {
			}
			try {
				sm.destroy();
			} catch (final Exception ex) {
			}
			try {
				applet = null;
			} catch (final Exception ex) {
			}
			try {
				cm = null;
			} catch (final Exception ex) {
			}
			try {
				sm = null;
			} catch (final Exception ex) {
			}
			System.exit(0);
		}
	}

	public static void game() {
		try {
			applet.stop();
		} catch (final Exception ex) {
		}
		try {
			cm.stop();
		} catch (final Exception ex) {
		}
		try {
			sm.stop();
		} catch (final Exception ex) {
		}
		frame.removeAll();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		try {
			applet.destroy();
		} catch (final Exception ex) {
		}
		try {
			cm.destroy();
		} catch (final Exception ex) {
		}
		try {
			sm.destroy();
		} catch (final Exception ex) {
		}
		try {
			applet = null;
		} catch (final Exception ex) {
		}
		try {
			cm = null;
		} catch (final Exception ex) {
		}
		try {
			sm = null;
		} catch (final Exception ex) {
		}
		System.gc();
		System.runFinalization();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		applet = new GameSparker();
		frame.add("Center", applet);
		frame.setVisible(true);
		applet.init();
		applet.start();
	}

	public static String getfuncSvalue(final String string, final String string_28_, final int i) {
		String string_29_ = "";
		int i_30_ = 0;
		for (int i_31_ = string.length() + 1; i_31_ < string_28_.length() && i_30_ <= i; i_31_++) {
			final String string_32_ = new StringBuilder().append("").append(string_28_.charAt(i_31_)).toString();
			if (string_32_.equals(",") || string_32_.equals(")"))
				i_30_++;
			else if (i_30_ == i)
				string_29_ = new StringBuilder().append(string_29_).append(string_32_).toString();
		}
		return string_29_;
	}

	public static void gofullscreen() {
		final DisplayMode[] displaymodes = myDevice.getDisplayModes();
		final String[] strings = new String[100];
		final int[] is = new int[100];
		int i = 0;
		final float f = (float) defdisp.getWidth() / (float) defdisp.getHeight();
		float f_2_ = -1.0F;
		int i_3_ = 0;
		for (int i_4_ = 0; i_4_ < displaymodes.length; i_4_++)
			if (displaymodes[i_4_].getWidth() >= 800 && displaymodes[i_4_].getBitDepth() >= 16 && i_3_ < 100) {
				if (displaymodes[i_4_].getWidth() < 900) {
					float f_5_ = (float) displaymodes[i_4_].getWidth() / (float) displaymodes[i_4_].getHeight();
					f_5_ = Math.abs(f - f_5_);
					if (f_5_ <= f_2_ || f_2_ == -1.0F) {
						i = i_3_;
						f_2_ = f_5_;
					}
				}
				strings[i_3_] = new StringBuilder().append("").append(displaymodes[i_4_].getWidth()).append(" x ")
						.append(displaymodes[i_4_].getHeight()).append(" Resolution   -   ")
						.append(displaymodes[i_4_].getBitDepth()).append(" Bits   -   ")
						.append(displaymodes[i_4_].getRefreshRate()).append(" Refresh Rate").toString();
				is[i_3_] = i_4_;
				i_3_++;
			}
		if (f_2_ != -1.0F) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings_6_ = strings;
			final int i_7_ = i;
			strings_6_[i_7_] = stringbuilder.append(strings_6_[i_7_]).append("     <  Recommended").toString();
		}
		try {
			final File file = new File(
					new StringBuilder().append("").append(fpath).append("data/full_screen.data").toString());
			if (file.exists()) {
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string;
				for (boolean bool = false; (string = bufferedreader.readLine()) != null && !bool; bool = true) {
					string = string.trim();
					int i_8_ = i;
					try {
						i_8_ = Integer.valueOf(string).intValue();
					} catch (final Exception exception) {
						i_8_ = i;
					}
					i = i_8_;
					if (i < 0)
						i = 0;
					if (i > i_3_ - 1)
						i = i_3_ - 1;
				}
				bufferedreader.close();
			}
		} catch (final Exception exception) {
			/* empty */
		}
		final String[] strings_10_ = new String[i_3_];
		for (int i_11_ = 0; i_11_ < i_3_; i_11_++)
			strings_10_[i_11_] = strings[i_11_];
		final String[] strings_12_ = strings_10_;
		final Object object = JOptionPane.showInputDialog(null,
				"Choose a screen resolution setting below and click OK to try it.\nExit Fullscreen by pressing [Esc].\n\nIMPORTANT: If the game does not display properly in Fullscreen press [Esc]      \nand try a different resolution setting below,",
				"Fullscreen Options", 1, null, strings_12_, strings_12_[i]);
		int i_13_ = -1;
		if (object != null)
			for (int i_14_ = 0; i_14_ < i_3_; i_14_++)
				if (object.equals(strings_12_[i_14_])) {
					i_13_ = is[i_14_];
					i = i_14_;
					break;
				}
		if (i_13_ != -1) {
			try {
				final File file = new File(
						new StringBuilder().append("").append(fpath).append("data/full_screen.data").toString());
				final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
				bufferedwriter.write(new StringBuilder().append("").append(i).append("").toString());
				bufferedwriter.newLine();
				bufferedwriter.close();
			} catch (final Exception exception) {
				/* empty */
			}
			fullscreen = true;
			frame.dispose();
			frame = new Frame("Fullscreen Need for Madness");
			frame.setBackground(new Color(0, 0, 0));
			frame.setUndecorated(true);
			frame.setResizable(false);
			frame.setExtendedState(6);
			frame.setIgnoreRepaint(true);
			frame.add("Center", applet);
			frame.setVisible(true);
			if (myDevice.isFullScreenSupported()) {
				try {
					myDevice.setFullScreenWindow(frame);
				} catch (final Exception exception) {
					/* empty */
				}
				if (myDevice.isDisplayChangeSupported())
					try {
						myDevice.setDisplayMode(displaymodes[i_13_]);
					} catch (final Exception exception) {
						/* empty */
					}
			}
			applet.requestFocus();
		}
	}

	public static void main(final String[] strings) {
		System.runFinalizersOnExit(true);
		frame = new Frame("Need for Madness");
		frame.setBackground(new Color(0, 0, 0));
		frame.setIgnoreRepaint(true);
		fpath = "";
		boolean bool = false;
		final String[] strings_0_ = strings;
		final int i = strings_0_.length;
		for (int i_1_ = 0; i_1_ < i; i_1_++) {
			final String string = strings_0_[i_1_];
			if (!bool) {
				fpath = new StringBuilder().append(fpath).append(string).toString();
				bool = true;
			} else
				fpath = new StringBuilder().append(fpath).append(" ").append(string).toString();
		}
		if (!fpath.equals(""))
			if (fpath.equals("manar")) {
				fpath = "";
				try {
					final File file = new File("data/manar.ok");
					if (!file.exists()) {
						final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
						bufferedwriter.write(new StringBuilder().append("").append((int) (Math.random() * 1000.0))
								.append("").toString());
						bufferedwriter.newLine();
						bufferedwriter.close();
					}
				} catch (final Exception exception) {
					/* empty */
				}
			} else {
				final File file = new File(
						new StringBuilder().append("").append(fpath).append("data/models.zip").toString());
				if (!file.exists())
					fpath = "";
			}
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.createImage(new StringBuilder().append("").append(fpath).append("data/icon.png").toString()));
		applet = new GameSparker();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent windowevent) {
				exitsequance();
			}
		});
		frame.add("Center", applet);
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(930, 586));
		frame.setSize(930, 586);
		frame.setExtendedState(6);
		applet.init();
		applet.start();
		final GraphicsEnvironment graphicsenvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		myDevice = graphicsenvironment.getDefaultScreenDevice();
		defdisp = myDevice.getDisplayMode();
		try {
			Thread.sleep(1000L);
		} catch (final InterruptedException e) {
		}
		checknupdate(36);
	}

	public static void openurl(final String string) {
		if (Desktop.isDesktopSupported())
			try {
				Desktop.getDesktop().browse(new URI(string));
			} catch (final Exception exception) {
				/* empty */
			}
		else
			try {
				Runtime.getRuntime().exec(new StringBuilder().append("").append(urlopen()).append(" ").append(string)
						.append("").toString());
			} catch (final Exception exception) {
				/* empty */
			}
	}

	public static void stagemaker() {
		try {
			applet.stop();
		} catch (final Exception ex) {
		}
		try {
			cm.stop();
		} catch (final Exception ex) {
		}
		try {
			sm.stop();
		} catch (final Exception ex) {
		}
		frame.removeAll();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		try {
			applet.destroy();
		} catch (final Exception ex) {
		}
		try {
			cm.destroy();
		} catch (final Exception ex) {
		}
		try {
			sm.destroy();
		} catch (final Exception ex) {
		}
		try {
			applet = null;
		} catch (final Exception ex) {
		}
		try {
			cm = null;
		} catch (final Exception ex) {
		}
		try {
			sm = null;
		} catch (final Exception ex) {
		}
		System.gc();
		System.runFinalization();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		sm = new StageMaker();
		frame.add("Center", sm);
		frame.setVisible(true);
		sm.init();
		sm.start();
	}

	public static String urlopen() {
		String string = "explorer";
		final String string_27_ = System.getProperty("os.name").toLowerCase();
		if (string_27_.indexOf("linux") != -1 || string_27_.indexOf("unix") != -1 || string_27_.equals("aix"))
			string = "xdg-open";
		if (string_27_.indexOf("mac") != -1)
			string = "open";
		return string;
	}

}