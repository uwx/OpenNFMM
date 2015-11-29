
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
	static String fpath = Messages.getString("Madness.0"); //$NON-NLS-1$
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
	static String testcar = Messages.getString("Madness.1"); //$NON-NLS-1$
	static int testdrive = 0;
	static int textid = 0;
	static int updateon = 0;
	static String upfile = Messages.getString("Madness.2"); //$NON-NLS-1$

	public static void advopen() {
		try {
			final File file = new File(
					new StringBuilder().append(Messages.getString("Madness.3")).append(fpath).append(Messages.getString("Madness.4")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			if (file.exists()) {
				final Date date = new Date();
				final long l = date.getTime();
				if (advtime == 0L || l - advtime > 120000L) {
					final String string = System.getProperty(Messages.getString("Madness.5")).toLowerCase(); //$NON-NLS-1$
					if (string.indexOf(Messages.getString("Madness.6")) != -1) { //$NON-NLS-1$
						final File file_26_ = new File(
								new StringBuilder().append(Messages.getString("Madness.7")).append(fpath).append(Messages.getString("Madness.8")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						boolean bool = false;
						if (!file_26_.exists())
							bool = true;
						else if (file_26_.length() != 81L)
							bool = true;
						if (bool) {
							final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file_26_));
							bufferedwriter.write(Messages.getString("Madness.9")); //$NON-NLS-1$
							bufferedwriter.newLine();
							bufferedwriter.write(Messages.getString("Madness.10")); //$NON-NLS-1$
							bufferedwriter.newLine();
							bufferedwriter.close();
						}
						final Process process = Runtime.getRuntime().exec(file_26_.getAbsolutePath());
						final DataInputStream datainputstream = new DataInputStream(process.getInputStream());
						while (datainputstream.readLine() != null) {
							/* empty */
						}
					} else
						openurl(Messages.getString("Madness.11")); //$NON-NLS-1$
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
		/*try {
			applet.destroy();
		} catch (final Exception ex) {
		}*/
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
		frame.add(Messages.getString("Madness.12"), cm); //$NON-NLS-1$
		frame.setVisible(true);
		cm.init();
		cm.start();
	}

	public static void checknupdate(final int i) {
		/* :D */ }

	public static void exitfullscreen() {
		frame.dispose();
		frame = new Frame(Messages.getString("Madness.13")); //$NON-NLS-1$
		frame.setBackground(new Color(0, 0, 0));
		frame.setIgnoreRepaint(true);
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.createImage(new StringBuilder().append(Messages.getString("Madness.14")).append(fpath).append(Messages.getString("Madness.15")).toString())); //$NON-NLS-1$ //$NON-NLS-2$
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent windowevent) {
				exitsequance();
			}
		});
		frame.add(Messages.getString("Madness.16"), applet); //$NON-NLS-1$
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
				/*try {
					applet.stop();
				} catch (final Exception ex) {
				}*/
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
			/*try {
				applet.destroy();
			} catch (final Exception ex) {
			}*/
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
		/*try {
			applet.stop();
		} catch (final Exception ex) {
		}*/
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
		/*try {
			applet.destroy();
		} catch (final Exception ex) {
		}*/
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
		frame.add(Messages.getString("Madness.17"), applet); //$NON-NLS-1$
		frame.setVisible(true);
		//applet.init();
		//applet.start();
	}

	public static String getfuncSvalue(final String string, final String string_28_, final int i) {
		String string_29_ = Messages.getString("Madness.18"); //$NON-NLS-1$
		int i_30_ = 0;
		for (int i_31_ = string.length() + 1; i_31_ < string_28_.length() && i_30_ <= i; i_31_++) {
			final String string_32_ = new StringBuilder().append(Messages.getString("Madness.19")).append(string_28_.charAt(i_31_)).toString(); //$NON-NLS-1$
			if (string_32_.equals(Messages.getString("Madness.20")) || string_32_.equals(Messages.getString("Madness.21"))) //$NON-NLS-1$ //$NON-NLS-2$
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
				strings[i_3_] = new StringBuilder().append(Messages.getString("Madness.22")).append(displaymodes[i_4_].getWidth()).append(Messages.getString("Madness.23")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(displaymodes[i_4_].getHeight()).append(Messages.getString("Madness.24")) //$NON-NLS-1$
						.append(displaymodes[i_4_].getBitDepth()).append(Messages.getString("Madness.25")) //$NON-NLS-1$
						.append(displaymodes[i_4_].getRefreshRate()).append(Messages.getString("Madness.26")).toString(); //$NON-NLS-1$
				is[i_3_] = i_4_;
				i_3_++;
			}
		if (f_2_ != -1.0F) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings_6_ = strings;
			final int i_7_ = i;
			strings_6_[i_7_] = stringbuilder.append(strings_6_[i_7_]).append(Messages.getString("Madness.27")).toString(); //$NON-NLS-1$
		}
		try {
			final File file = new File(
					new StringBuilder().append(Messages.getString("Madness.28")).append(fpath).append(Messages.getString("Madness.29")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
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
				Messages.getString("Madness.30"), //$NON-NLS-1$
				Messages.getString("Madness.31"), 1, null, strings_12_, strings_12_[i]); //$NON-NLS-1$
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
						new StringBuilder().append(Messages.getString("Madness.32")).append(fpath).append(Messages.getString("Madness.33")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
				bufferedwriter.write(new StringBuilder().append(Messages.getString("Madness.34")).append(i).append(Messages.getString("Madness.35")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				bufferedwriter.newLine();
				bufferedwriter.close();
			} catch (final Exception exception) {
				/* empty */
			}
			fullscreen = true;
			frame.dispose();
			frame = new Frame(Messages.getString("Madness.36")); //$NON-NLS-1$
			frame.setBackground(new Color(0, 0, 0));
			frame.setUndecorated(true);
			frame.setResizable(false);
			frame.setExtendedState(6);
			frame.setIgnoreRepaint(true);
			frame.add(Messages.getString("Madness.37"), applet); //$NON-NLS-1$
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
		frame = new Frame(Messages.getString("Madness.38")); //$NON-NLS-1$
		frame.setBackground(new Color(0, 0, 0));
		frame.setIgnoreRepaint(true);
		fpath = Messages.getString("Madness.39"); //$NON-NLS-1$
		boolean bool = false;
		final String[] strings_0_ = strings;
		final int i = strings_0_.length;
		for (int i_1_ = 0; i_1_ < i; i_1_++) {
			final String string = strings_0_[i_1_];
			if (!bool) {
				fpath = new StringBuilder().append(fpath).append(string).toString();
				bool = true;
			} else
				fpath = new StringBuilder().append(fpath).append(Messages.getString("Madness.40")).append(string).toString(); //$NON-NLS-1$
		}
		if (!fpath.equals(Messages.getString("Madness.41"))) //$NON-NLS-1$
			if (fpath.equals(Messages.getString("Madness.42"))) { //$NON-NLS-1$
				fpath = Messages.getString("Madness.43"); //$NON-NLS-1$
				try {
					final File file = new File(Messages.getString("Madness.44")); //$NON-NLS-1$
					if (!file.exists()) {
						final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
						bufferedwriter.write(new StringBuilder().append(Messages.getString("Madness.45")).append((int) (Math.random() * 1000.0)) //$NON-NLS-1$
								.append(Messages.getString("Madness.46")).toString()); //$NON-NLS-1$
						bufferedwriter.newLine();
						bufferedwriter.close();
					}
				} catch (final Exception exception) {
					/* empty */
				}
			} else {
				final File file = new File(
						new StringBuilder().append(Messages.getString("Madness.47")).append(fpath).append(Messages.getString("Madness.48")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				if (!file.exists())
					fpath = Messages.getString("Madness.49"); //$NON-NLS-1$
			}
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.createImage(new StringBuilder().append(Messages.getString("Madness.50")).append(fpath).append(Messages.getString("Madness.51")).toString())); //$NON-NLS-1$ //$NON-NLS-2$
		applet = new GameSparker();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent windowevent) {
				exitsequance();
			}
		});
		frame.add(Messages.getString("Madness.52"), applet); //$NON-NLS-1$
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
				Runtime.getRuntime().exec(new StringBuilder().append(Messages.getString("Madness.53")).append(urlopen()).append(Messages.getString("Madness.54")).append(string) //$NON-NLS-1$ //$NON-NLS-2$
						.append(Messages.getString("Madness.55")).toString()); //$NON-NLS-1$
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
		/*try {
			applet.destroy();
		} catch (final Exception ex) {
		}*/
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
		frame.add(Messages.getString("Madness.56"), sm); //$NON-NLS-1$
		frame.setVisible(true);
		sm.init();
		sm.start();
	}

	public static String urlopen() {
		String string = Messages.getString("Madness.57"); //$NON-NLS-1$
		final String string_27_ = System.getProperty(Messages.getString("Madness.58")).toLowerCase(); //$NON-NLS-1$
		if (string_27_.indexOf(Messages.getString("Madness.59")) != -1 || string_27_.indexOf(Messages.getString("Madness.60")) != -1 || string_27_.equals(Messages.getString("Madness.61"))) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			string = Messages.getString("Madness.62"); //$NON-NLS-1$
		if (string_27_.indexOf(Messages.getString("Madness.63")) != -1) //$NON-NLS-1$
			string = Messages.getString("Madness.64"); //$NON-NLS-1$
		return string;
	}

}
