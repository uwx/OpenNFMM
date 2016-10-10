package nfm.open;

/* Madness - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Madness extends Panel {
    static int anti = 1;
    private static GameSparker applet;
    private static CarMaker cm;
    private static DisplayMode defdisp;
    static String fpath = "";
    public static JFrame frame;
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

    static void carmaker() {
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
        } catch (final Exception ignored) {

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
        } catch (final Exception ignored) {

        }
        cm = new CarMaker();
        frame.add("Center", cm);
        frame.setVisible(true);
        cm.init();
        cm.start();
    }

    static void exitfullscreen() {
        frame.dispose();
        frame = new JFrame("Need for Madness");
        frame.setBackground(new Color(0, 0, 0));
        frame.setIgnoreRepaint(true);
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + fpath + "data/icon.gif"));
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
            } catch (final Exception ignored) {

            }
            if (myDevice.isDisplayChangeSupported()) {
                try {
                    myDevice.setFullScreenWindow(null);
                } catch (final Exception ignored) {

                }
            }
        }
        frame.setMinimumSize(new Dimension(930, 586));
        frame.setSize(800, 586);
        frame.setExtendedState(6);
        applet.requestFocus();
        fullscreen = false;
    }

    private static void exitsequance() {
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
        } catch (final Exception ignored) {

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

    static void game() {
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
        } catch (final Exception ignored) {

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
        } catch (final Exception ignored) {

        }
        applet = GameSparker.create();
        frame.add("Center", applet);
        frame.setVisible(true);
        //applet.init();
        //applet.start();
    }

    static void gofullscreen() {
        final DisplayMode[] displaymodes = myDevice.getDisplayModes();
        final String[] strings = new String[100];
        final int[] is = new int[100];
        int i = 0;
        final float f = (float) defdisp.getWidth() / (float) defdisp.getHeight();
        float f2 = -1.0F;
        int i3 = 0;
        for (int i4 = 0; i4 < displaymodes.length; i4++)
            if (displaymodes[i4].getWidth() >= 800 && displaymodes[i4].getBitDepth() >= 16 && i3 < 100) {
                if (displaymodes[i4].getWidth() < 900) {
                    float f5 = (float) displaymodes[i4].getWidth() / (float) displaymodes[i4].getHeight();
                    f5 = Math.abs(f - f5);
                    if (f5 <= f2 || f2 == -1.0F) {
                        i = i3;
                        f2 = f5;
                    }
                }
                strings[i3] = "" + displaymodes[i4].getWidth() + " x " + displaymodes[i4].getHeight() + " Resolution   -   " + displaymodes[i4].getBitDepth() + " Bits   -   " + displaymodes[i4].getRefreshRate() + " Refresh Rate";
                is[i3] = i4;
                i3++;
            }
        if (f2 != -1.0F) {
            strings[i] = strings[i] + "     <  Recommended";
        }
        try {
            final File file = new File("" + fpath + "data/fullScreen.data");
            if (file.exists()) {
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string;
                for (boolean bool = false; (string = bufferedreader.readLine()) != null && !bool; bool = true) {
                    string = string.trim();
                    int i8;
                    try {
                        i8 = Integer.parseInt(string);
                    } catch (final Exception exception) {
                        i8 = i;
                    }
                    i = i8;
                    if (i < 0) {
                        i = 0;
                    }
                    if (i > i3 - 1) {
                        i = i3 - 1;
                    }
                }
                bufferedreader.close();
            }
        } catch (final Exception ignored) {

        }
        final String[] strings10 = new String[i3];
        System.arraycopy(strings, 0, strings10, 0, i3);
        final Object object = JOptionPane.showInputDialog(null, "Choose a screen resolution setting below and click OK to try it.\nExit Fullscreen by pressing [Esc].\n\nIMPORTANT: If the game does not display properly in Fullscreen press [Esc]      \nand try a different resolution setting below,", "Fullscreen Options", 1, null, strings10, strings10[i]);
        int i13 = -1;
        if (object != null) {
            for (int i14 = 0; i14 < i3; i14++)
                if (object.equals(strings10[i14])) {
                    i13 = is[i14];
                    i = i14;
                    break;
                }
        }
        if (i13 != -1) {
            try {
                final File file = new File("" + fpath + "data/fullScreen.data");
                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write("" + i + "");
                bufferedwriter.newLine();
                bufferedwriter.close();
            } catch (final Exception ignored) {

            }
            fullscreen = true;
            frame.dispose();
            frame = new JFrame("Fullscreen Need for Madness");
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
                } catch (final Exception ignored) {

                }
                if (myDevice.isDisplayChangeSupported()) {
                    try {
                        myDevice.setDisplayMode(displaymodes[i13]);
                    } catch (final Exception ignored) {

                    }
                }
            }
            applet.requestFocus();
        }
    }

    public static void main(final String[] strings) {
        System.runFinalizersOnExit(true);
        frame = new JFrame("Need for Madness");
        frame.setBackground(Color.black);
        frame.setIgnoreRepaint(true);
        setFilePath(strings);
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage(fpath + "data/icon.png"));

        applet = GameSparker.create();
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
        // frame.setExtendedState(6); - maximize
        final GraphicsEnvironment graphicsenvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        myDevice = graphicsenvironment.getDefaultScreenDevice();
        defdisp = myDevice.getDisplayMode();
        try {
            Thread.sleep(1000L);
        } catch (final InterruptedException ignored) {
        }
    }

    private static void setFilePath(final String[] strings) {
        fpath = "";
        boolean bool = false;
        for (final String string : strings) {
            if (!bool) {
                fpath = "" + fpath + string;
                bool = true;
            } else {
                fpath = "" + fpath + " " + string;
            }
        }
        if (!fpath.equals(""))
            if (fpath.equals("manar")) {
                fpath = "";
                try {
                    final File file = new File("data/manar.ok");
                    if (!file.exists()) {
                        final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                        bufferedwriter.write("" + (int) (ThreadLocalRandom.current().nextDouble() * 1000.0) + "");
                        bufferedwriter.newLine();
                        bufferedwriter.close();
                    }
                } catch (final Exception ignored) {

                }
            } else {
                final File file = new File("" + fpath + "data/models.zip");
                if (!file.exists()) {
                    fpath = "";
                }
            }
    }

    static void openurl(final String string) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(string));
            } catch (final Exception ignored) {

            }
        } else {
            try {
                Runtime.getRuntime().exec("" + urlopen() + " " + string + "");
            } catch (final Exception ignored) {

            }
        }
    }

    static void stagemaker() {
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
        } catch (final Exception ignored) {

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
        } catch (final Exception ignored) {

        }
        sm = new StageMaker();
        frame.add("Center", sm);
        frame.setVisible(true);
        sm.init();
        sm.start();
    }

    static String urlopen() {
        String string = "explorer";
        final String string27 = System.getProperty("os.name").toLowerCase();
        if (string27.contains("linux") || string27.contains("unix") || string27.equals("aix")) {
            string = "xdg-open";
        }
        if (string27.contains("mac")) {
            string = "open";
        }
        return string;
    }

}
