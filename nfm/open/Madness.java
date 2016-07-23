package nfm.open;
/* nfm.open.Madness - Decompiled by JODE
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

class Madness extends Panel {
	private static long advtime = 0L;
	static int anti = 1;
	private static GameSparker applet;
	private static CarMaker cm;
	private static DisplayMode defdisp;
	static int endadv = 0;
	static String fpath = "";
	private static Frame frame;
	static boolean fullscreen = false;
	static boolean inisetup = false;
	private static GraphicsDevice myDevice;
	/**
	 *
	 */
	private static final long serialVersionUID = 8881840450218558380L;
	private static StageMaker sm;
	static String testcar = "";
	static int testdrive = 0;
	static int textid = 0;
	private static final int updateon = 0;

	public static void advopen() {
		try {
			final File file = new File(
					"" + fpath + "data/user.data");
			if (file.exists()) {
				final Date date = new Date();
				final long l = date.getTime();
				if (advtime == 0L || l - advtime > 120000L) {
					final String string = System.getProperty("os.name").toLowerCase();
					if (string.contains("win")) {
						final File file_26_ = new File(
								"" + fpath + "data/adv.bat");
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
		/*try {
			applet.stop();
		} catch (final Exception ex) {
		}*/
		try {
			cm.stop();
		} catch (final Exception ignored) {
		}
		try {
			sm.stop();
		} catch (final Exception ignored) {
		}
		frame.removeAll();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		/*try {
			applet.destroy();
		} catch (final Exception ex) {
		}*/
		try {
			cm.destroy();
		} catch (final Exception ignored) {
		}
		try {
			sm.destroy();
		} catch (final Exception ignored) {
		}
		try {
			applet = null;
		} catch (final Exception ignored) {
		}
		try {
			cm = null;
		} catch (final Exception ignored) {
		}
		try {
			sm = null;
		} catch (final Exception ignored) {
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

	public static void exitfullscreen() {
		frame.dispose();
		frame = new Frame("Need for nfm.open.Madness");
		frame.setBackground(new Color(0, 0, 0));
		frame.setIgnoreRepaint(true);
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.createImage("" + fpath + "data/icon.gif"));
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

	private static void exitsequance() {
		if (updateon == 0 || updateon == 3) {
			if (endadv == 1)
				endadv = 2;
			//if (updateon != 3)
				/*try {
					applet.stop();
				} catch (final Exception ex) {
				}*/
			try {
				sm.stop();
			} catch (final Exception ignored) {
			}
			try {
				cm.stop();
			} catch (final Exception ignored) {
			}
			frame.removeAll();
			try {
				Thread.sleep(200L);
			} catch (final Exception exception) {
				/* empty */
			}
			/*try {
				applet.destroy();
			} catch (final Exception ex) {
			}*/
			try {
				cm.destroy();
			} catch (final Exception ignored) {
			}
			try {
				sm.destroy();
			} catch (final Exception ignored) {
			}
			try {
				applet = null;
			} catch (final Exception ignored) {
			}
			try {
				cm = null;
			} catch (final Exception ignored) {
			}
			try {
				sm = null;
			} catch (final Exception ignored) {
			}
			System.exit(0);
		}
	}

	public static void game() {
		/*try {
			applet.stop();
		} catch (final Exception ex) {
		}*/
		try {
			cm.stop();
		} catch (final Exception ignored) {
		}
		try {
			sm.stop();
		} catch (final Exception ignored) {
		}
		frame.removeAll();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		/*try {
			applet.destroy();
		} catch (final Exception ex) {
		}*/
		try {
			cm.destroy();
		} catch (final Exception ignored) {
		}
		try {
			sm.destroy();
		} catch (final Exception ignored) {
		}
		try {
			applet = null;
		} catch (final Exception ignored) {
		}
		try {
			cm = null;
		} catch (final Exception ignored) {
		}
		try {
			sm = null;
		} catch (final Exception ignored) {
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
		//applet.init();
		//applet.start();
	}

	public static String getfuncSvalue(final String string, final String string_28_, final int i) {
		String string_29_ = "";
		int i_30_ = 0;
		for (int i_31_ = string.length() + 1; i_31_ < string_28_.length() && i_30_ <= i; i_31_++) {
			final String string_32_ = "" + string_28_.charAt(i_31_);
			if (string_32_.equals(",") || string_32_.equals(")"))
				i_30_++;
			else if (i_30_ == i)
				string_29_ = string_29_ + string_32_;
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
				strings[i_3_] = "" + displaymodes[i_4_].getWidth() + " x " +
						displaymodes[i_4_].getHeight() + " Resolution   -   " +
						displaymodes[i_4_].getBitDepth() + " Bits   -   " +
						displaymodes[i_4_].getRefreshRate() + " Refresh Rate";
				is[i_3_] = i_4_;
				i_3_++;
			}
		if (f_2_ != -1.0F) {
			strings[i] = strings[i] + "     <  Recommended";
		}
		try {
			final File file = new File(
					"" + fpath + "data/full_screen.data");
			if (file.exists()) {
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string;
				for (boolean bool = false; (string = bufferedreader.readLine()) != null && !bool; bool = true) {
					string = string.trim();
					int i_8_;
					try {
						i_8_ = Integer.parseInt(string);
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
		System.arraycopy(strings, 0, strings_10_, 0, i_3_);
		final Object object = JOptionPane.showInputDialog(null,
				"Choose a screen resolution setting below and click OK to try it.\nExit Fullscreen by pressing [Esc].\n\nIMPORTANT: If the game does not display properly in Fullscreen press [Esc]      \nand try a different resolution setting below,",
				"Fullscreen Options", 1, null, strings_10_, strings_10_[i]);
		int i_13_ = -1;
		if (object != null)
			for (int i_14_ = 0; i_14_ < i_3_; i_14_++)
				if (object.equals(strings_10_[i_14_])) {
					i_13_ = is[i_14_];
					i = i_14_;
					break;
				}
		if (i_13_ != -1) {
			try {
				final File file = new File(
						"" + fpath + "data/full_screen.data");
				final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
				bufferedwriter.write("" + i + "");
				bufferedwriter.newLine();
				bufferedwriter.close();
			} catch (final Exception exception) {
				/* empty */
			}
			fullscreen = true;
			frame.dispose();
			frame = new Frame("Fullscreen Need for nfm.open.Madness");
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
		frame = new Frame("Need for nfm.open.Madness");
		frame.setBackground(new Color(0, 0, 0));
		frame.setIgnoreRepaint(true);
		fpath = "";
		boolean bool = false;
		final int i = strings.length;
		for (final String string : strings) {
			if (!bool) {
				fpath = fpath + string;
				bool = true;
			} else
				fpath = fpath + " " + string;
		}
		if (!fpath.equals(""))
			if (fpath.equals("manar")) {
				fpath = "";
				try {
					final File file = new File("data/manar.ok");
					if (!file.exists()) {
						final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
						bufferedwriter.write("" + (int) (Math.random() * 1000.0) +
								"");
						bufferedwriter.newLine();
						bufferedwriter.close();
					}
				} catch (final Exception exception) {
					/* empty */
				}
			} else {
				final File file = new File(
						"" + fpath + "data/models.zip");
				if (!file.exists())
					fpath = "";
			}
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.createImage("" + fpath + "data/icon.png"));
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
		//applet.init();
		//applet.start();
		final GraphicsEnvironment graphicsenvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		myDevice = graphicsenvironment.getDefaultScreenDevice();
		defdisp = myDevice.getDisplayMode();
		try {
			Thread.sleep(1000L);
		} catch (final InterruptedException ignored) {
		}
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
				Runtime.getRuntime().exec("" + urlopen() + " " + string +
						"");
			} catch (final Exception exception) {
				/* empty */
			}
	}

	public static void stagemaker() {
		/*try {
			applet.stop();
		} catch (final Exception ex) {
		}*/
		try {
			cm.stop();
		} catch (final Exception ignored) {
		}
		try {
			sm.stop();
		} catch (final Exception ignored) {
		}
		frame.removeAll();
		try {
			Thread.sleep(400L);
		} catch (final Exception exception) {
			/* empty */
		}
		/*try {
			applet.destroy();
		} catch (final Exception ex) {
		}*/
		try {
			cm.destroy();
		} catch (final Exception ignored) {
		}
		try {
			sm.destroy();
		} catch (final Exception ignored) {
		}
		try {
			applet = null;
		} catch (final Exception ignored) {
		}
		try {
			cm = null;
		} catch (final Exception ignored) {
		}
		try {
			sm = null;
		} catch (final Exception ignored) {
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
		if (string_27_.contains("linux") || string_27_.contains("unix") || string_27_.equals("aix"))
			string = "xdg-open";
		if (string_27_.contains("mac"))
			string = "open";
		return string;
	}

}
