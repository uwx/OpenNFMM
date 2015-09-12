package stagemaker;

/* Madness - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
public class Madness extends Panel
{
    static Frame frame;
    static GameSparker applet;
    static CarMaker cm;
    static StageMaker sm;
    static int testdrive = 0;
    static String testcar = "";
    static int textid = 0;
    
    public static void main(String[] strings) {
        System.runFinalizersOnExit(true);
        frame = new Frame("Need for Madness");
        frame.setBackground(new Color(0, 0, 0));
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage("data/icon.gif"));
        applet = new GameSparker();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowevent) {
                exitsequance();
            }
        });
        frame.add("Center", applet);
        settings = applet.settings;
        settings.initMenu(frame);
        frame.show();
        frame.setSize(800, 586);
        frame.setExtendedState(6);
        applet.init();
        applet.start();
        
    }
    
    public static void exitsequance() {
        applet.stop();
        frame.removeAll();
        try {
            Thread.sleep(200L);
        } catch (Exception exception) {
            /* empty */
        }
        applet.destroy();
        applet = null;
        System.exit(0);
    }
    
    public static void carmaker() {
    	try {
    		applet.stop();
    	} catch (Exception ex) {}
    	try {
    		cm.stop();
    	} catch (Exception ex) {}
    	try {
    		sm.stop();
    	} catch (Exception ex) {}
        frame.removeAll();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
            /* empty */
        }
        try {
    		applet.destroy();
    	} catch (Exception ex) {}
        try {
    		cm.destroy();
    	} catch (Exception ex) {}
        try {
    		sm.destroy();
    	} catch (Exception ex) {}
        try {
    		applet = null;
    	} catch (Exception ex) {}
        try {
    		cm = null;
    	} catch (Exception ex) {}
        try {
    		sm = null;
    	} catch (Exception ex) {}
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
            /* empty */
        }
        cm = new CarMaker();
        frame.add("Center", cm);
        frame.show();
        cm.init();
        cm.start();
    }
    
    public static void stagemaker() {
    	try {
    		applet.stop();
    	} catch (Exception ex) {}
    	try {
    		cm.stop();
    	} catch (Exception ex) {}
    	try {
    		sm.stop();
    	} catch (Exception ex) {}
        frame.removeAll();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
            /* empty */
        }
        try {
    		applet.destroy();
    	} catch (Exception ex) {}
        try {
    		cm.destroy();
    	} catch (Exception ex) {}
        try {
    		sm.destroy();
    	} catch (Exception ex) {}
        try {
    		applet = null;
    	} catch (Exception ex) {}
        try {
    		cm = null;
    	} catch (Exception ex) {}
        try {
    		sm = null;
    	} catch (Exception ex) {}
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
            /* empty */
        }
        sm = new StageMaker();
        frame.add("Center", sm);
        frame.show();
        sm.init();
        sm.start();
    }
    
    public static void game() {
    	try {
    		applet.stop();
    	} catch (Exception ex) {}
    	try {
    		cm.stop();
    	} catch (Exception ex) {}
    	try {
    		sm.stop();
    	} catch (Exception ex) {}
        frame.removeAll();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
            /* empty */
        }
        try {
    		applet.destroy();
    	} catch (Exception ex) {}
        try {
    		cm.destroy();
    	} catch (Exception ex) {}
        try {
    		sm.destroy();
    	} catch (Exception ex) {}
        try {
    		applet = null;
    	} catch (Exception ex) {}
        try {
    		cm = null;
    	} catch (Exception ex) {}
        try {
    		sm = null;
    	} catch (Exception ex) {}
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
            /* empty */
        }
        applet = new GameSparker();
        frame.add("Center", applet);
        frame.show();
        settings.initMenu(frame);
        applet.init();
        applet.start();
    }
    
	//RunApp runapp;
    static Settings settings;
    
    public static String urlopen() {
        String string = "explorer";
        String string_0_ = System.getProperty("os.name").toLowerCase();
        if (string_0_.indexOf("linux") != -1 || string_0_.indexOf("unix") != -1 || string_0_.equals("aix"))
            string = "xdg-open";
        if (string_0_.indexOf("mac") != -1)
            string = "open";
        return string;
    }
    
    public static void openurl(String string) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(string));
            } catch (Exception exception) {
                /* empty */
            }
        } else {
            try {
                Runtime.getRuntime().exec(new StringBuilder().append("").append(urlopen()).append(" ").append(string).append("").toString());
            } catch (Exception exception) {
                /* empty */
            }
        }
    }
}
