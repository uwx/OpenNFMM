
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

class Madness extends Panel {
    private static long advtime = 0L;
    static int anti = 1;
    private static GameSparker applet;
    private static CarMaker cm;
    private static DisplayMode defdisp;
    static int endadv = 0;
    static String fpath = "";
    private static Frame frame;
    static DisplayMode fulldisp;
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
    private static int updateon = 0;
    static String upfile = "";

    static void advopen() {
        try {
            final File file = new File(
                    new StringBuilder().append("").append(fpath).append("data/user.data").toString());
            if (file.exists()) {
                final Date date = new Date();
                final long l = date.getTime();
                if (advtime == 0L || l - advtime > 120000L) {
                    final String string = System.getProperty("os.name").toLowerCase();
                    if (string.indexOf("win") != -1) {
                        final File file26 = new File(
                                new StringBuilder().append("").append(fpath).append("data/adv.bat").toString());
                        boolean bool = false;
                        if (!file26.exists())
                            bool = true;
                        else if (file26.length() != 81L)
                            bool = true;
                        if (bool) {
                            final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file26));
                            bufferedwriter.write("cd %programfiles%\\Internet Explorer");
                            bufferedwriter.newLine();
                            bufferedwriter.write("iexplore -k http://www.needformadness.com/");
                            bufferedwriter.newLine();
                            bufferedwriter.close();
                        }
                        final Process process = Runtime.getRuntime().exec(file26.getAbsolutePath());
                        final DataInputStream datainputstream = new DataInputStream(process.getInputStream());
                        while (datainputstream.readLine() != null) {
                            
                        }
                    } else
                        openurl("http://www.needformadness.com/");
                    advtime = l;
                    endadv = 1;
                }
            }
        } catch (final Exception exception) {
            
        }
    }

    static void carmaker() {
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
            
        }
        cm = new CarMaker();
        frame.add("Center", cm);
        frame.setVisible(true);
        cm.init();
        cm.start();
    }

    private static void checknupdate(final int i) {
        /* :D */ }

    static void exitfullscreen() {
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
                
            }
            if (myDevice.isDisplayChangeSupported())
                try {
                    myDevice.setFullScreenWindow(null);
                } catch (final Exception exception) {
                    
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

    static void game() {
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
            
        }
        applet = new GameSparker();
        frame.add("Center", applet);
        frame.setVisible(true);
        //applet.init();
        //applet.start();
    }

    public static String getfuncSvalue(final String string, final String string28, final int i) {
        String string29 = "";
        int i30 = 0;
        for (int i31 = string.length() + 1; i31 < string28.length() && i30 <= i; i31++) {
            final String string32 = new StringBuilder().append("").append(string28.charAt(i31)).toString();
            if (string32.equals(",") || string32.equals(")"))
                i30++;
            else if (i30 == i)
                string29 = new StringBuilder().append(string29).append(string32).toString();
        }
        return string29;
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
                strings[i3] = new StringBuilder().append("").append(displaymodes[i4].getWidth()).append(" x ")
                        .append(displaymodes[i4].getHeight()).append(" Resolution   -   ")
                        .append(displaymodes[i4].getBitDepth()).append(" Bits   -   ")
                        .append(displaymodes[i4].getRefreshRate()).append(" Refresh Rate").toString();
                is[i3] = i4;
                i3++;
            }
        if (f2 != -1.0F) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings6 = strings;
            final int i7 = i;
            strings6[i7] = stringbuilder.append(strings6[i7]).append("     <  Recommended").toString();
        }
        try {
            final File file = new File(
                    new StringBuilder().append("").append(fpath).append("data/fullScreen.data").toString());
            if (file.exists()) {
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string;
                for (boolean bool = false; (string = bufferedreader.readLine()) != null && !bool; bool = true) {
                    string = string.trim();
                    int i8 = i;
                    try {
                        i8 = Integer.valueOf(string).intValue();
                    } catch (final Exception exception) {
                        i8 = i;
                    }
                    i = i8;
                    if (i < 0)
                        i = 0;
                    if (i > i3 - 1)
                        i = i3 - 1;
                }
                bufferedreader.close();
            }
        } catch (final Exception exception) {
            
        }
        final String[] strings10 = new String[i3];
        for (int i11 = 0; i11 < i3; i11++)
            strings10[i11] = strings[i11];
        final String[] strings12 = strings10;
        final Object object = JOptionPane.showInputDialog(null,
                "Choose a screen resolution setting below and click OK to try it.\nExit Fullscreen by pressing [Esc].\n\nIMPORTANT: If the game does not display properly in Fullscreen press [Esc]      \nand try a different resolution setting below,",
                "Fullscreen Options", 1, null, strings12, strings12[i]);
        int i13 = -1;
        if (object != null)
            for (int i14 = 0; i14 < i3; i14++)
                if (object.equals(strings12[i14])) {
                    i13 = is[i14];
                    i = i14;
                    break;
                }
        if (i13 != -1) {
            try {
                final File file = new File(
                        new StringBuilder().append("").append(fpath).append("data/fullScreen.data").toString());
                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(new StringBuilder().append("").append(i).append("").toString());
                bufferedwriter.newLine();
                bufferedwriter.close();
            } catch (final Exception exception) {
                
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
                    
                }
                if (myDevice.isDisplayChangeSupported())
                    try {
                        myDevice.setDisplayMode(displaymodes[i13]);
                    } catch (final Exception exception) {
                        
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
        final String[] strings0 = strings;
        final int i = strings0.length;
        for (int i1 = 0; i1 < i; i1++) {
            final String string = strings0[i1];
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

    static void openurl(final String string) {
        if (Desktop.isDesktopSupported())
            try {
                Desktop.getDesktop().browse(new URI(string));
            } catch (final Exception exception) {
                
            }
        else
            try {
                Runtime.getRuntime().exec(new StringBuilder().append("").append(urlopen()).append(" ").append(string)
                        .append("").toString());
            } catch (final Exception exception) {
                
            }
    }

    static void stagemaker() {
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
        if (string27.indexOf("linux") != -1 || string27.indexOf("unix") != -1 || string27.equals("aix"))
            string = "xdg-open";
        if (string27.indexOf("mac") != -1)
            string = "open";
        return string;
    }

}
