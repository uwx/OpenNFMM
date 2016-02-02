
/* GameSparker - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.AlphaComposite;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

class GameSparker extends JPanel
        implements KeyListener, MouseListener, MouseMotionListener, ActionListener, FocusListener {
    /**
     *
     */
    private static final long serialVersionUID = -5976860556958716653L;
    private float apmult = 1.0F;
    boolean applejava = false;
    private int apx = 0;
    private int apy = 0;
    private Image blb;
    private final Image[] carmaker = new Image[2];
    private final Image[] chkbx = new Image[2];
    private final Smenu clanlev = new Smenu(8);
    private final Smenu clcars = new Smenu(707);
    TextField cmsg;
    private final Smenu datat = new Smenu(26);
    private boolean exwist = false;
    private int fcscnt = 0;
    private Image fulls;
    Smenu gmode = new Smenu(3);
    private final Smenu icars = new Smenu(5);
    private final Smenu ilaps = new Smenu(18);
    Checkbox keplo;
    private int lasth = 0;
    private int lastw = 0;
    private int lmxz = 0;
    private boolean lostfcs = false;
    Smenu mcars = new Smenu(707);
    private int mload = 1;
    private TextArea mmsg;
    int moto = 1;
    private boolean moused = false;
    int mouses = 0;
    private int mousew = 0;
    Smenu mstgs = new Smenu(707);
    /**
     * Applies transparency to every polygon (20 is 20% opacity, 100 is 100% opacity)
     */
    private int mvect = 100;
    Checkbox mycar;
    private int nob = 0;
    private int notb = 0;
    Checkbox notp;
    BufferedImage offImage;
    private boolean onbar = false;
    private boolean oncarm = false;
    private boolean onfulls = false;
    private boolean onstgm = false;
    boolean openm = false;
    Smenu pgame = new Smenu(11);
    private final Smenu proitem = new Smenu(707);
    Graphics2D rd;
    private float reqmult = 0.0F;
    Smenu rooms = new Smenu(7);
    Smenu scars = new Smenu(4);
    Smenu sclass = new Smenu(7);
    private final Smenu senditem = new Smenu(707);
    private final Smenu sendtyp = new Smenu(6);
    Smenu sfix = new Smenu(7);
    Smenu sgame = new Smenu(8);
    private int shaka = 0;
    private int showsize = 0;
    private Image sizebar;
    Smenu slaps = new Smenu(17);
    private int smooth = 1;
    Smenu snbts = new Smenu(8);
    //Smenu snfm1 = new Smenu(12);
    //Smenu snfm2 = new Smenu(19);
    Smenu snfmm = new Smenu(xtGraphics.nTracks + 2);
    Smenu snpls = new Smenu(9);
    private final Image[] stagemaker = new Image[2];
    Smenu swait = new Smenu(6);
    TextField temail;
    TextField tnick;
    TextField tpass;
    private final Control[] u = new Control[8];
    private int view = 0;
    Smenu vnpls = new Smenu(5);
    Smenu vtyp = new Smenu(6);
    Smenu warb = new Smenu(102);
    Smenu wgame = new Smenu(4);
    private int xm = 0;
    private int ym = 0;

    private void catchlink() {
        if (!lostfcs)
            if (xm > 65 && xm < 735 && ym > 135 && ym < 194 || xm > 275 && xm < 525 && ym > 265 && ym < 284) {
                setCursor(new Cursor(12));
                if (mouses == 2) {
                    openurl("http://www.radicalplay.com/");
                }
            } else {
                setCursor(new Cursor(0));
            }
    }

    private void checkmemory(final xtGraphics xtgraphics) {
        if (applejava || Runtime.getRuntime().freeMemory() / 1048576L < 50L) {
            xtgraphics.badmac = true;
        }
    }

    private void cropit(final Graphics2D graphics2d, final int x, final int y) {
        if (x != 0 || y != 0) {
            graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
            graphics2d.setColor(new Color(0, 0, 0));
        }
        if (x != 0)
            if (x < 0) {
                graphics2d.fillRect(apx + x, apy - (int) (25.0F * apmult), Math.abs(x), (int) (500.0F * apmult));
            } else {
                graphics2d.fillRect(apx + (int) (800.0F * apmult), apy
                        - (int) (25.0F * apmult), x, (int) (500.0F * apmult));
            }
        if (y != 0)
            if (y < 0) {
                graphics2d.fillRect(apx - (int) (25.0F * apmult), apy + y, (int) (850.0F * apmult), Math.abs(y));
            } else {
                graphics2d.fillRect(apx - (int) (25.0F * apmult), apy
                        + (int) (450.0F * apmult), (int) (850.0F * apmult), y);
            }
    }

    void drawms() {
        openm = false;
        if (gmode.draw(rd, xm, ym, moused, 450, true)) {
            openm = true;
        }
        if (swait.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (slaps.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (snpls.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (snbts.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (scars.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (sgame.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        //if (snfm1.draw(rd, xm, ym, moused, 450, false))
        //	openm = true;
        //if (snfm2.draw(rd, xm, ym, moused, 450, false))
        //	openm = true;
        if (snfmm.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (mstgs.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (mcars.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (pgame.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (vnpls.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (vtyp.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (warb.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (wgame.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (rooms.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (sendtyp.draw(rd, xm, ym, moused, 450, true)) {
            openm = true;
        }
        if (senditem.draw(rd, xm, ym, moused, 450, true)) {
            openm = true;
        }
        if (datat.draw(rd, xm, ym, moused, 450, true)) {
            openm = true;
        }
        if (clanlev.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (clcars.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (ilaps.draw(rd, xm, ym, moused, 450, true)) {
            openm = true;
        }
        if (icars.draw(rd, xm, ym, moused, 450, true)) {
            openm = true;
        }
        if (proitem.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (sfix.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
        if (sclass.draw(rd, xm, ym, moused, 450, false)) {
            openm = true;
        }
    }

    void editlink(final String accountid, final boolean isLogged) {
        String logged = "";
        if (isLogged) {
            logged = "?display=upgrade";
        }
        openurl("http://multiplayer.needformadness.com/edit.pl" + logged + "#" + accountid + "");
    }

    private int getint(final String string, final String string4, final int i) {
        int j = 0;
        String string2 = "";
        for (int k = string.length() + 1; k < string4.length(); k++) {
            final String string3 = "" + string4.charAt(k);
            if (string3.equals(",") || string3.equals(")")) {
                j++;
                k++;
            }
            if (j == i) {
                string2 = string2 + string4.charAt(k);
            }
        }
        return Integer.valueOf(string2).intValue();
    }

    private String getstring(final String string, final String string2, final int i) {
        int j = 0;
        String string3 = "";
        for (int k = string.length() + 1; k < string2.length(); k++) {
            final String string4 = "" + string2.charAt(k);
            if (string4.equals(",") || string4.equals(")")) {
                j++;
                k++;
            }
            if (j == i) {
                string3 = string3 + string2.charAt(k);
            }
        }
        return string3;
    }

    private void hidefields() {
        ilaps.setVisible(false);
        icars.setVisible(false);
        proitem.setVisible(false);
        clcars.setVisible(false);
        clanlev.setVisible(false);
        mmsg.setVisible(false);
        datat.setVisible(false);
        senditem.setVisible(false);
        sendtyp.setVisible(false);
        rooms.setVisible(false);
        mcars.setVisible(false);
        mstgs.setVisible(false);
        gmode.setVisible(false);
        sclass.setVisible(false);
        scars.setVisible(false);
        sfix.setVisible(false);
        mycar.setVisible(false);
        notp.setVisible(false);
        keplo.setVisible(false);
        tnick.setVisible(false);
        tpass.setVisible(false);
        temail.setVisible(false);
        cmsg.setVisible(false);
        sgame.setVisible(false);
        wgame.setVisible(false);
        pgame.setVisible(false);
        vnpls.setVisible(false);
        vtyp.setVisible(false);
        warb.setVisible(false);
        slaps.setVisible(false);
        //snfm1.setVisible(false);
        snfmm.setVisible(false);
        //snfm2.setVisible(false);
        snpls.setVisible(false);
        snbts.setVisible(false);
        swait.setVisible(false);
    }

    //@Override
    private void initApplet() {
        setBackground(new Color(0, 0, 0));
        //offImage = createImage(800, 450);
        //if (offImage != null)
        //	rd = (Graphics2D) offImage.getGraphics();
        setLayout(null);
        tnick = new TextField("Nickbname");
        tnick.setFont(new Font("Arial", 1, 13));
        tpass = new TextField("");
        tpass.setFont(new Font("Arial", 1, 13));
        tpass.setEchoChar('*');
        temail = new TextField("");
        temail.setFont(new Font("Arial", 1, 13));
        cmsg = new TextField("");
        if (System.getProperty("java.vendor").toLowerCase().indexOf("oracle") != -1) {
            cmsg.addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(final KeyEvent e) {
                    if (e.getKeyCode() == 10 && u[0] != null) {
                        u[0].enter = true;
                    }
                }

                @Override
                public void keyReleased(final KeyEvent e) {
                }

                @Override
                public void keyTyped(final KeyEvent e) {
                }
            });
        }
        mmsg = new TextArea("", 200, 20, 3);
        cmsg.setFont(new Font("Tahoma", 0, 11));
        mmsg.setFont(new Font("Tahoma", 0, 11));
        mycar = new Checkbox("Sword of Justice Game!");
        notp = new Checkbox("No Trees & Piles");
        keplo = new Checkbox("Stay logged in");
        keplo.setState(true);
        add(tnick);
        add(tpass);
        add(temail);
        add(cmsg);
        add(mmsg);
        add(mycar);
        add(notp);
        add(keplo);
        sgame.setFont(new Font("Arial", 1, 13));
        wgame.setFont(new Font("Arial", 1, 13));
        warb.setFont(new Font("Arial", 1, 13));
        pgame.setFont(new Font("Arial", 1, 12));
        vnpls.setFont(new Font("Arial", 1, 13));
        vtyp.setFont(new Font("Arial", 1, 13));
        snfmm.setFont(new Font("Arial", 1, 13));
        //snfm1.setFont(new Font("Arial", 1, 13));
        //snfm2.setFont(new Font("Arial", 1, 13));
        mstgs.setFont(new Font("Arial", 1, 13));
        mcars.setFont(new Font("Arial", 1, 13));
        slaps.setFont(new Font("Arial", 1, 13));
        snpls.setFont(new Font("Arial", 0, 13));
        snbts.setFont(new Font("Arial", 0, 13));
        swait.setFont(new Font("Arial", 0, 12));
        sclass.setFont(new Font("Arial", 1, 12));
        scars.setFont(new Font("Arial", 1, 12));
        sfix.setFont(new Font("Arial", 1, 12));
        mycar.setFont(new Font("Arial", 1, 12));
        notp.setFont(new Font("Arial", 1, 12));
        keplo.setFont(new Font("Arial", 1, 12));
        gmode.setFont(new Font("Arial", 1, 13));
        rooms.setFont(new Font("Arial", 1, 13));
        sendtyp.setFont(new Font("Arial", 1, 12));
        senditem.setFont(new Font("Arial", 1, 12));
        datat.setFont(new Font("Arial", 1, 12));
        clanlev.setFont(new Font("Arial", 1, 12));
        clcars.setFont(new Font("Arial", 1, 12));
        clcars.alphad = true;
        ilaps.setFont(new Font("Arial", 1, 13));
        icars.setFont(new Font("Arial", 1, 12));
        proitem.setFont(new Font("Arial", 1, 12));
    }

    /**
     * List of car .rad files.<br>
     * <strong>ALL CAR MODELS IN THE ZIP FILE SHOULD BE PUT HERE OR THINGS WILL GO WRONG!</strong><br>
     * (Additional info: when a .rad file is found and it has no index here or in stageRads it will be assigned to index 0 - Tornado Shark)<br>
     */
    private final String[] carRads = {
            "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter",
            "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster"
    };
    /**
     * List of track part .rad files.<br>
     * <strong>ALL NON-CAR MODELS IN THE ZIP FILE SHOULD BE PUT HERE OR THINGS WILL GO WRONG!</strong><br>
     * (Additional info: when a .rad file is found and it has no index here or in carRads it will be assigned to index 0 - Tornado Shark)<br>
     */
    private final String[] stageRads = {
            "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn",
            "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15",
            "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail",
            "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad",
            "soffroad", "tside", "launchpad", "thenet", "speedramp", "offhill", "slider", "uphill", "roll1", "roll2",
            "roll3", "roll4", "roll5", "roll6", "opile1", "opile2", "aircheckpoint", "tree1", "tree2", "tree3", "tree4",
            "tree5", "tree6", "tree7", "tree8", "cac1", "cac2", "cac3", "8sroad", "8soffroad"
    };
    /**
     * The ContO index which track parts start at. Raise this number if you want to have 99 cars or more.
     */
    static private final int partskips = 100;//was 56

    private void loadbase(final ContO[] contos, final Medium medium, final Trackers trackers, final xtGraphics xtgraphics, final boolean bool) {
        if (carRads.length < xtGraphics.nCars)
            throw new RuntimeException("too many cars and not enough rad files!");
        int i = 0;
        xtgraphics.dnload += 6;
        try {
            ZipInputStream zipinputstream;
            if (!bool) {
                final File file = new File("" + Madness.fpath + "data/models.zip");
                zipinputstream = new ZipInputStream(new FileInputStream(file));
            } else {
                final URL url = new URL("http://multiplayer.needformadness.com/data/models.zip");
                zipinputstream = new ZipInputStream(url.openStream());
            }
            ZipEntry zipentry = zipinputstream.getNextEntry();
            for (; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i175 = 0;
                for (int i176 = 0; i176 < carRads.length; i176++)
                    if (zipentry.getName().startsWith(carRads[i176])) {
                        i175 = i176;
                    }
                for (int i177 = 0; i177 < stageRads.length; i177++)
                    if (zipentry.getName().startsWith(stageRads[i177])) {
                        i175 = i177 + partskips;
                    }
                int size = (int) zipentry.getSize();
                i += size;
                final byte[] is = new byte[size];
                int offset = 0;
                int numbytesread;
                for (; size > 0; size -= numbytesread) {
                    numbytesread = zipinputstream.read(is, offset, size);
                    offset += numbytesread;
                }
                contos[i175] = new ContO(is, medium, trackers);
                if (i175 < xtGraphics.nCars && !contos[i175].shadow)
                    throw new RuntimeException("car " + cardefine.names[i175] + " does not have a shadow");
                xtgraphics.dnload++;
            }
            zipinputstream.close();

        } catch (final Exception exception) {
            if (exception instanceof RuntimeException)
                throw new RuntimeException(exception);
            else {
                System.out.println("Error Reading Models: " + exception);
            }
        }
        System.gc();
        if (mload != -1 && i != 615671) {
            mload = 2;
        }
    }

    private void loadstage(final ContO[] stageContos, final ContO[] baseContos, final Medium medium, final Trackers trackers, final CheckPoints checkpoints, final xtGraphics xtgraphics, final Mad[] mads, final Record record) {
        if (xtgraphics.testdrive == 2 || xtgraphics.testdrive == 4) {
            xtgraphics.nplayers = 1;
        }
        /*if (xtgraphics.gmode == 1) {
        	xtgraphics.nplayers = 5;
        	xtgraphics.xstart[4] = 0;
        	xtgraphics.zstart[4] = 760;
        }*/
        trackers.nt = 0;
        nob = xtgraphics.nplayers;
        notb = 0;
        checkpoints.n = 0;
        checkpoints.nsp = 0;
        checkpoints.fn = 0;
        checkpoints.trackname = "";
        checkpoints.haltall = false;
        checkpoints.wasted = 0;
        checkpoints.catchfin = 0;
        medium.resdown = 0;
        medium.rescnt = 5;
        medium.lightson = false;
        medium.noelec = 0;
        medium.ground = 250;
        medium.trk = 0;
        view = 0;
        int i = 0;
        int k = 100;
        int l = 0;
        int m = 100;
        xtgraphics.newparts = false;
        String string = "";
        try {
            BufferedReader stageDataReader;
            if (xtgraphics.multion == 0 && checkpoints.stage != -2) {
                String customStagePath = "stages/" + checkpoints.stage + "";
                if (checkpoints.stage == -1) {
                    customStagePath = "mystages/" + checkpoints.name + "";
                }
                final File customStageFile = new File("" + Madness.fpath + "" + customStagePath + ".txt");
                stageDataReader = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(customStageFile))));
            } else if (checkpoints.stage > 0) {
                final URL url = new URL("http://multiplayer.needformadness.com/stages/" + checkpoints.stage
                        + ".txt");
                stageDataReader = new BufferedReader(new InputStreamReader(new DataInputStream(url.openStream())));
            } else {
                String stagelink = "http://multiplayer.needformadness.com/tracks/" + checkpoints.name + ".radq";
                stagelink = stagelink.replace(' ', '_');
                final URL url = new URL(stagelink);
                final int connectionlength = url.openConnection().getContentLength();
                final DataInputStream datainputstream = new DataInputStream(url.openStream());
                final byte[] is = new byte[connectionlength];
                datainputstream.readFully(is);
                ZipInputStream zipinputstream;
                if (is[0] == 80 && is[1] == 75 && is[2] == 3) {
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                } else {
                    final byte[] is2 = new byte[connectionlength - 40];
                    for (int n = 0; n < connectionlength - 40; n++) {
                        int o = 20;
                        if (n >= 500) {
                            o = 40;
                        }
                        is2[n] = is[n + o];
                    }
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is2));
                }
                final ZipEntry zipentry = zipinputstream.getNextEntry();
                int n = Integer.valueOf(zipentry.getName()).intValue();
                final byte[] is2 = new byte[n];
                int o = 0;
                int p;
                for (; n > 0; n -= p) {
                    p = zipinputstream.read(is2, o, n);
                    o += p;
                }
                zipinputstream.close();
                datainputstream.close();
                stageDataReader = new BufferedReader(new InputStreamReader(new DataInputStream(new ByteArrayInputStream(is2))));
            }
            String line;
            while ((line = stageDataReader.readLine()) != null) {
                string = "" + line.trim();
                if (string.startsWith("snap")) {
                    medium.setsnap(getint("snap", string, 0), getint("snap", string, 1), getint("snap", string, 2));
                }
                if (string.startsWith("sky")) {
                    medium.setsky(getint("sky", string, 0), getint("sky", string, 1), getint("sky", string, 2));
                    xtgraphics.snap(checkpoints.stage);
                }
                if (string.startsWith("ground")) {
                    medium.setgrnd(getint("ground", string, 0), getint("ground", string, 1), getint("ground", string, 2));
                }
                if (string.startsWith("polys")) {
                    medium.setpolys(getint("polys", string, 0), getint("polys", string, 1), getint("polys", string, 2));
                }
                if (string.startsWith("fog")) {
                    medium.setfade(getint("fog", string, 0), getint("fog", string, 1), getint("fog", string, 2));
                }
                if (string.startsWith("texture")) {
                    medium.setexture(getint("texture", string, 0), getint("texture", string, 1), getint("texture", string, 2), getint("texture", string, 3));
                }
                if (string.startsWith("clouds")) {
                    medium.setcloads(getint("clouds", string, 0), getint("clouds", string, 1), getint("clouds", string, 2), getint("clouds", string, 3), getint("clouds", string, 4));
                }
                if (string.startsWith("density")) {
                    medium.fogd = (getint("density", string, 0) + 1) * 2 - 1;
                    if (medium.fogd < 1) {
                        medium.fogd = 1;
                    }
                    if (medium.fogd > 30) {
                        medium.fogd = 30;
                    }
                }
                if (string.startsWith("fadefrom")) {
                    medium.fadfrom(getint("fadefrom", string, 0));
                }
                if (string.startsWith("lightson")) {
                    medium.lightson = true;
                }
                if (string.startsWith("mountains")) {
                    medium.mgen = getint("mountains", string, 0);
                }
                if (string.startsWith("set")) {
                    int setindex = getint("set", string, 0);
                    if (xtgraphics.nplayers == 8) {
                        if (setindex == 47) {
                            setindex = 76;
                        }
                        if (setindex == 48) {
                            setindex = 77;
                        }
                    }
                    boolean bool = true;
                    if (setindex >= 65 && setindex <= 75 && checkpoints.notb) {
                        bool = false;
                    }
                    if (bool) {
                        if (setindex == 49 || setindex == 64 || setindex >= 56 && setindex <= 61) {
                            xtgraphics.newparts = true;
                        }
                        if ((checkpoints.stage < 0 || checkpoints.stage >= 28) && setindex >= 10 && setindex <= 25) {
                            medium.loadnew = true;
                        }
                        setindex += partskips - 10;
                        stageContos[nob] = new ContO(baseContos[setindex], getint("set", string, 1), medium.ground
                                - baseContos[setindex].grat, getint("set", string, 2), getint("set", string, 3));
                        if (string.indexOf(")p") != -1) {
                            checkpoints.x[checkpoints.n] = getint("set", string, 1);
                            checkpoints.z[checkpoints.n] = getint("set", string, 2);
                            checkpoints.y[checkpoints.n] = 0;
                            checkpoints.typ[checkpoints.n] = 0;
                            if (string.indexOf(")pt") != -1) {
                                checkpoints.typ[checkpoints.n] = -1;
                            }
                            if (string.indexOf(")pr") != -1) {
                                checkpoints.typ[checkpoints.n] = -2;
                            }
                            if (string.indexOf(")po") != -1) {
                                checkpoints.typ[checkpoints.n] = -3;
                            }
                            if (string.indexOf(")ph") != -1) {
                                checkpoints.typ[checkpoints.n] = -4;
                            }
                            if (string.indexOf("out") != -1) {
                                System.out.println("out: " + checkpoints.n);
                            }
                            checkpoints.n++;
                            notb = nob + 1;
                        }
                        nob++;
                        if (medium.loadnew) {
                            medium.loadnew = false;
                        }
                    }
                }
                if (string.startsWith("chk")) {
                    int chkindex = getint("chk", string, 0);
                    chkindex += partskips - 10;
                    int chkheight = medium.ground - baseContos[chkindex].grat;
                    if (chkindex == 110) {
                        chkheight = getint("chk", string, 4);
                    }
                    stageContos[nob] = new ContO(baseContos[chkindex], getint("chk", string, 1), chkheight, getint("chk", string, 2), getint("chk", string, 3));
                    checkpoints.x[checkpoints.n] = getint("chk", string, 1);
                    checkpoints.z[checkpoints.n] = getint("chk", string, 2);
                    checkpoints.y[checkpoints.n] = chkheight;
                    if (getint("chk", string, 3) == 0) {
                        checkpoints.typ[checkpoints.n] = 1;
                    } else {
                        checkpoints.typ[checkpoints.n] = 2;
                    }
                    checkpoints.pcs = checkpoints.n;
                    checkpoints.n++;
                    stageContos[nob].checkpoint = checkpoints.nsp + 1;
                    checkpoints.nsp++;
                    nob++;
                    notb = nob;
                }
                if (checkpoints.nfix != 5 && string.startsWith("fix")) {
                    int fixindex = getint("fix", string, 0);
                    fixindex += partskips - 10;
                    stageContos[nob] = new ContO(baseContos[fixindex], getint("fix", string, 1), getint("fix", string, 3), getint("fix", string, 2), getint("fix", string, 4));
                    checkpoints.fx[checkpoints.fn] = getint("fix", string, 1);
                    checkpoints.fz[checkpoints.fn] = getint("fix", string, 2);
                    checkpoints.fy[checkpoints.fn] = getint("fix", string, 3);
                    stageContos[nob].elec = true;
                    if (getint("fix", string, 4) != 0) {
                        checkpoints.roted[checkpoints.fn] = true;
                        stageContos[nob].roted = true;
                    } else {
                        checkpoints.roted[checkpoints.fn] = false;
                    }
                    if (string.indexOf(")s") != -1) {
                        checkpoints.special[checkpoints.fn] = true;
                    } else {
                        checkpoints.special[checkpoints.fn] = false;
                    }
                    checkpoints.fn++;
                    nob++;
                    notb = nob;
                }
                if (!checkpoints.notb && string.startsWith("pile")) {
                    stageContos[nob] = new ContO(getint("pile", string, 0), getint("pile", string, 1), getint("pile", string, 2), medium, trackers, getint("pile", string, 3), getint("pile", string, 4), medium.ground);
                    nob++;
                }
                if (xtgraphics.multion == 0 && string.startsWith("nlaps")) {
                    checkpoints.nlaps = getint("nlaps", string, 0);
                }
                //if (checkpoints.nlaps < 1)
                //	checkpoints.nlaps = 1;
                //if (checkpoints.nlaps > 15)
                //	checkpoints.nlaps = 15;
                if (checkpoints.stage > 0 && string.startsWith("name")) {
                    checkpoints.name = getstring("name", string, 0).replace('|', ',');
                }
                if (string.startsWith("stagemaker")) {
                    checkpoints.maker = getstring("stagemaker", string, 0);
                }
                if (string.startsWith("publish")) {
                    checkpoints.pubt = getint("publish", string, 0);
                }
                if (string.startsWith("soundtrack")) {
                    checkpoints.trackname = getstring("soundtrack", string, 0);
                    checkpoints.trackvol = getint("soundtrack", string, 1);
                    if (checkpoints.trackvol < 50) {
                        checkpoints.trackvol = 50;
                    }
                    if (checkpoints.trackvol > 300) {
                        checkpoints.trackvol = 300;
                    }
                    xtgraphics.sndsize[32] = getint("soundtrack", string, 2);
                }
                if (string.startsWith("maxr")) {
                    final int n = getint("maxr", string, 0);
                    final int o = getint("maxr", string, 1);
                    i = o;
                    final int p = getint("maxr", string, 2);
                    for (int q = 0; q < n; q++) {
                        stageContos[nob] = new ContO(baseContos[29 + partskips], o, medium.ground
                                - baseContos[29 + partskips].grat, //29 may need to be 85 or xtgraphics.nCars - 16
                                q * 4800 + p, 0);
                        nob++;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = o + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = n * 4800 / 2 + p - 2400;
                    trackers.radz[trackers.nt] = n * 4800 / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 167;
                    trackers.decor[trackers.nt] = false;
                    trackers.skd[trackers.nt] = 0;
                    trackers.nt++;
                }
                if (string.startsWith("maxl")) {
                    final int n = getint("maxl", string, 0);
                    final int o = getint("maxl", string, 1);
                    k = o;
                    final int p = getint("maxl", string, 2);
                    for (int q = 0; q < n; q++) {
                        stageContos[nob] = new ContO(baseContos[29 + partskips], o, medium.ground
                                - baseContos[29 + partskips].grat, q * 4800 + p, 180);
                        nob++;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = o - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = n * 4800 / 2 + p - 2400;
                    trackers.radz[trackers.nt] = n * 4800 / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 167;
                    trackers.decor[trackers.nt] = false;
                    trackers.skd[trackers.nt] = 0;
                    trackers.nt++;
                }
                if (string.startsWith("maxt")) {
                    final int n = getint("maxt", string, 0);
                    final int o = getint("maxt", string, 1);
                    l = o;
                    final int p = getint("maxt", string, 2);
                    for (int q = 0; q < n; q++) {
                        stageContos[nob] = new ContO(baseContos[29 + partskips], q * 4800 + p, medium.ground
                                - baseContos[29 + partskips].grat, o, 90);
                        nob++;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = o + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = n * 4800 / 2 + p - 2400;
                    trackers.radx[trackers.nt] = n * 4800 / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 167;
                    trackers.decor[trackers.nt] = false;
                    trackers.skd[trackers.nt] = 0;
                    trackers.nt++;
                }
                if (string.startsWith("maxb")) {
                    final int n = getint("maxb", string, 0);
                    final int o = getint("maxb", string, 1);
                    m = o;
                    final int p = getint("maxb", string, 2);
                    for (int q = 0; q < n; q++) {
                        stageContos[nob] = new ContO(baseContos[29 + partskips], q * 4800 + p, medium.ground
                                - baseContos[29 + partskips].grat, o, -90);
                        nob++;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = o - 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = n * 4800 / 2 + p - 2400;
                    trackers.radx[trackers.nt] = n * 4800 / 2;
                    trackers.zy[trackers.nt] = -90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 167;
                    trackers.decor[trackers.nt] = false;
                    trackers.skd[trackers.nt] = 0;
                    trackers.nt++;
                }
            }
            stageDataReader.close();
            medium.newpolys(k, i - k, m, l - m, trackers, notb);
            medium.newclouds(k, i, m, l);
            medium.newmountains(k, i, m, l);
            medium.newstars();
            trackers.devidetrackers(k, i - k, m, l - m);
        } catch (final Exception exception) {
            checkpoints.stage = -3;
            System.out.println("Error in stage " + checkpoints.stage);
            System.out.println("" + exception);
            System.out.println("At line: " + string);
        }
        if (checkpoints.nsp < 2) {
            checkpoints.stage = -3;
        }
        if (medium.nrw * medium.ncl >= 16000) {
            checkpoints.stage = -3;
        }
        if (checkpoints.stage != -3) {
            checkpoints.top20 = Math.abs(checkpoints.top20);
            if (checkpoints.stage == 26) {
                medium.lightn = 0;
            } else {
                medium.lightn = -1;
            }
            if (checkpoints.stage == 1 || checkpoints.stage == 11) {
                medium.nochekflk = false;
            } else {
                medium.nochekflk = true;
            }
            for (int n = 0; n < xtgraphics.nplayers; n++) {
                u[n].reset(checkpoints, xtgraphics.sc[n]);
            }
            xtgraphics.resetstat(checkpoints.stage);
            checkpoints.calprox();

            for (int j = 0; j < xtgraphics.nplayers; j++) {

                System.out.println(j);
                System.out.println(xtgraphics.sc[j]);
                System.out.println(baseContos[j]);
                System.out.println(stageContos[xtgraphics.sc[j]]);
                System.out.println("cps " + baseContos[partskips]);

                if (xtgraphics.fase == 22) {
                    xtgraphics.colorCar(baseContos[xtgraphics.sc[j]], j);
                }
                stageContos[j] = new ContO(baseContos[xtgraphics.sc[j]], xtgraphics.xstart[j], 250
                        - baseContos[xtgraphics.sc[j]].grat, xtgraphics.zstart[j], 0);
                mads[j].reseto(xtgraphics.sc[j], stageContos[j], checkpoints);
            }
            if (xtgraphics.fase == 2 || xtgraphics.fase == -22) {
                medium.trx = (k + i) / 2;
                medium.trz = (l + m) / 2;
                medium.ptr = 0;
                medium.ptcnt = -10;
                medium.hit = 45000;
                medium.fallen = 0;
                medium.nrnd = 0;
                medium.trk = 1;
                medium.ih = 25;
                medium.iw = 65;
                medium.h = 425;
                medium.w = 735;
                xtgraphics.fase = 1;
                mouses = 0;
            }
            if (xtgraphics.fase == 22) {
                medium.crs = false;
                xtgraphics.fase = 5;
            }
            if (checkpoints.stage > 0) {
                xtgraphics.asay = "Stage " + checkpoints.stage + ":  " + checkpoints.name + " ";
            } else {
                xtgraphics.asay = "Custom Stage:  " + checkpoints.name + " ";
            }
            record.reset(stageContos);
        } else if (xtgraphics.fase == 2) {
            xtgraphics.fase = 1;
        }
        System.gc();
    }

    private boolean loadstagePreview(final int i, final String string, final ContO[] contos, final ContO[] contos147, final Medium medium, final CheckPoints checkpoints) {
        boolean bool = true;
        if (i < 100) {
            checkpoints.stage = i;
            if (checkpoints.stage < 0) {
                checkpoints.name = string;
            }
        } else {
            checkpoints.stage = -2;
            if (sgame.getSelectedIndex() == 3 || sgame.getSelectedIndex() == 4) {
                checkpoints.name = mstgs.getSelectedItem();
            } else {
                final int i148 = mstgs.getSelectedItem().indexOf(" ") + 1;
                if (i148 > 0) {
                    checkpoints.name = mstgs.getSelectedItem().substring(i148);
                }
            }
        }
        nob = 0;
        checkpoints.n = 0;
        checkpoints.nsp = 0;
        checkpoints.fn = 0;
        checkpoints.haltall = false;
        checkpoints.wasted = 0;
        checkpoints.catchfin = 0;
        medium.ground = 250;
        view = 0;
        medium.trx = 0L;
        medium.trz = 0L;
        int i149 = 0;
        int i150 = 100;
        int i151 = 0;
        int i152 = 100;
        String string153 = "";
        try {
            DataInputStream datainputstream;
            if (checkpoints.stage > 0) {
                final URL url = new URL("http://multiplayer.needformadness.com/stages/" + checkpoints.stage
                        + ".txt");
                datainputstream = new DataInputStream(url.openStream());
            } else {
                String string154 = "http://multiplayer.needformadness.com/tracks/" + checkpoints.name + ".radq";
                string154 = string154.replace(' ', '_');
                final URL url = new URL(string154);
                final int i155 = url.openConnection().getContentLength();
                final DataInputStream datainputstream156 = new DataInputStream(url.openStream());
                final byte[] is = new byte[i155];
                datainputstream156.readFully(is);
                ZipInputStream zipinputstream;
                if (is[0] == 80 && is[1] == 75 && is[2] == 3) {
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                } else {
                    final byte[] is157 = new byte[i155 - 40];
                    for (int i158 = 0; i158 < i155 - 40; i158++) {
                        int i159 = 20;
                        if (i158 >= 500) {
                            i159 = 40;
                        }
                        is157[i158] = is[i158 + i159];
                    }
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is157));
                }
                final ZipEntry zipentry = zipinputstream.getNextEntry();
                int i160 = Integer.valueOf(zipentry.getName()).intValue();
                final byte[] is161 = new byte[i160];
                int i162 = 0;
                int i163;
                for (; i160 > 0; i160 -= i163) {
                    i163 = zipinputstream.read(is161, i162, i160);
                    i162 += i163;
                }
                zipinputstream.close();
                datainputstream156.close();
                datainputstream = new DataInputStream(new ByteArrayInputStream(is161));
            }
            String string164;
            while ((string164 = datainputstream.readLine()) != null) {
                string153 = "" + string164.trim();
                if (string153.startsWith("snap")) {
                    medium.setsnap(getint("snap", string153, 0), getint("snap", string153, 1), getint("snap", string153, 2));
                }
                if (string153.startsWith("sky")) {
                    medium.setsky(getint("sky", string153, 0), getint("sky", string153, 1), getint("sky", string153, 2));
                }
                if (string153.startsWith("ground")) {
                    medium.setgrnd(getint("ground", string153, 0), getint("ground", string153, 1), getint("ground", string153, 2));
                }
                if (string153.startsWith("polys")) {
                    medium.setpolys(getint("polys", string153, 0), getint("polys", string153, 1), getint("polys", string153, 2));
                }
                if (string153.startsWith("fog")) {
                    medium.setfade(getint("fog", string153, 0), getint("fog", string153, 1), getint("fog", string153, 2));
                }
                if (string153.startsWith("texture")) {
                    medium.setexture(getint("texture", string153, 0), getint("texture", string153, 1), getint("texture", string153, 2), getint("texture", string153, 3));
                }
                if (string153.startsWith("clouds")) {
                    medium.setcloads(getint("clouds", string153, 0), getint("clouds", string153, 1), getint("clouds", string153, 2), getint("clouds", string153, 3), getint("clouds", string153, 4));
                }
                if (string153.startsWith("density")) {
                    medium.fogd = (getint("density", string153, 0) + 1) * 2 - 1;
                    if (medium.fogd < 1) {
                        medium.fogd = 1;
                    }
                    if (medium.fogd > 30) {
                        medium.fogd = 30;
                    }
                }
                if (string153.startsWith("fadefrom")) {
                    medium.fadfrom(getint("fadefrom", string153, 0));
                }
                if (string153.startsWith("lightson")) {
                    medium.lightson = true;
                }
                if (string153.startsWith("mountains")) {
                    medium.mgen = getint("mountains", string153, 0);
                }
                if (string153.startsWith("soundtrack")) {
                    checkpoints.trackname = getstring("soundtrack", string153, 0);
                    checkpoints.trackvol = getint("soundtrack", string153, 1);
                    if (checkpoints.trackvol < 50) {
                        checkpoints.trackvol = 50;
                    }
                    if (checkpoints.trackvol > 300) {
                        checkpoints.trackvol = 300;
                    }
                }
                if (string153.startsWith("set")) {
                    int i165 = getint("set", string153, 0);
                    i165 += partskips - 10;
                    contos[nob] = new ContO(contos147[i165], getint("set", string153, 1), medium.ground
                            - contos147[i165].grat, getint("set", string153, 2), getint("set", string153, 3));
                    contos[nob].t.nt = 0;
                    if (string153.indexOf(")p") != -1) {
                        checkpoints.x[checkpoints.n] = getint("chk", string153, 1);
                        checkpoints.z[checkpoints.n] = getint("chk", string153, 2);
                        checkpoints.y[checkpoints.n] = 0;
                        checkpoints.typ[checkpoints.n] = 0;
                        if (string153.indexOf(")pt") != -1) {
                            checkpoints.typ[checkpoints.n] = -1;
                        }
                        if (string153.indexOf(")pr") != -1) {
                            checkpoints.typ[checkpoints.n] = -2;
                        }
                        if (string153.indexOf(")po") != -1) {
                            checkpoints.typ[checkpoints.n] = -3;
                        }
                        if (string153.indexOf(")ph") != -1) {
                            checkpoints.typ[checkpoints.n] = -4;
                        }
                        if (string153.indexOf("out") != -1) {
                            System.out.println("out: " + checkpoints.n);
                        }
                        checkpoints.n++;
                    }
                    nob++;
                }
                if (string153.startsWith("chk")) {
                    int i166 = getint("chk", string153, 0);
                    i166 += partskips - 10;
                    int i167 = medium.ground - contos147[i166].grat;
                    if (i166 == 110) {
                        i167 = getint("chk", string153, 4);
                    }
                    contos[nob] = new ContO(contos147[i166], getint("chk", string153, 1), i167, getint("chk", string153, 2), getint("chk", string153, 3));
                    checkpoints.x[checkpoints.n] = getint("chk", string153, 1);
                    checkpoints.z[checkpoints.n] = getint("chk", string153, 2);
                    checkpoints.y[checkpoints.n] = i167;
                    if (getint("chk", string153, 3) == 0) {
                        checkpoints.typ[checkpoints.n] = 1;
                    } else {
                        checkpoints.typ[checkpoints.n] = 2;
                    }
                    checkpoints.pcs = checkpoints.n;
                    checkpoints.n++;
                    contos[nob].checkpoint = checkpoints.nsp + 1;
                    checkpoints.nsp++;
                    nob++;
                }
                if (string153.startsWith("fix")) {
                    int i168 = getint("fix", string153, 0);
                    i168 += partskips - 10;
                    contos[nob] = new ContO(contos147[i168], getint("fix", string153, 1), getint("fix", string153, 3), getint("fix", string153, 2), getint("fix", string153, 4));
                    checkpoints.fx[checkpoints.fn] = getint("fix", string153, 1);
                    checkpoints.fz[checkpoints.fn] = getint("fix", string153, 2);
                    checkpoints.fy[checkpoints.fn] = getint("fix", string153, 3);
                    contos[nob].elec = true;
                    if (getint("fix", string153, 4) != 0) {
                        checkpoints.roted[checkpoints.fn] = true;
                        contos[nob].roted = true;
                    } else {
                        checkpoints.roted[checkpoints.fn] = false;
                    }
                    if (string153.indexOf(")s") != -1) {
                        checkpoints.special[checkpoints.fn] = true;
                    } else {
                        checkpoints.special[checkpoints.fn] = false;
                    }
                    checkpoints.fn++;
                    nob++;
                }
                if (string153.startsWith("nlaps")) {
                    checkpoints.nlaps = getint("nlaps", string153, 0);
                    if (checkpoints.nlaps < 1) {
                        checkpoints.nlaps = 1;
                    }
                    if (checkpoints.nlaps > 15) {
                        checkpoints.nlaps = 15;
                    }
                }
                if (checkpoints.stage > 0 && string153.startsWith("name")) {
                    checkpoints.name = getstring("name", string153, 0).replace('|', ',');
                }
                if (string153.startsWith("stagemaker")) {
                    checkpoints.maker = getstring("stagemaker", string153, 0);
                }
                if (string153.startsWith("publish")) {
                    checkpoints.pubt = getint("publish", string153, 0);
                }
                if (string153.startsWith("maxr")) {
                    i149 = getint("maxr", string153, 1);
                }
                //i149 = i169;
                if (string153.startsWith("maxl")) {
                    i150 = getint("maxl", string153, 1);
                }
                //i150 = i170;
                if (string153.startsWith("maxt")) {
                    i151 = getint("maxt", string153, 1);
                }
                //i151 = i171;
                if (string153.startsWith("maxb")) {
                    i152 = getint("maxb", string153, 1);
                    //i152 = i172;
                }
            }
            datainputstream.close();
            medium.newpolys(i150, i149 - i150, i152, i151 - i152, null, notb);
            medium.newclouds(i150, i149, i152, i151);
            medium.newmountains(i150, i149, i152, i151);
            medium.newstars();
        } catch (final Exception exception) {
            bool = false;
            System.out.println("Error in stage " + checkpoints.stage);
            System.out.println("" + exception);
            System.out.println("At line: " + string153);
        }
        if (checkpoints.nsp < 2) {
            bool = false;
        }
        if (medium.nrw * medium.ncl >= 16000) {
            bool = false;
        }
        medium.trx = (i150 + i149) / 2;
        medium.trz = (i151 + i152) / 2;
        System.gc();
        return bool;
    }

    void madlink() {
        openurl("http://www.needformadness.com/");
    }

    public void mouseW(final int i) {
        if (!exwist) {
            mousew += i * 4;
        }
    }

    void movefield(final Component component, int i, int i99, final int i100, final int i101) {
        if (i100 == 360 || i100 == 576) {
            i = (int) (i * apmult + apx + component.getWidth() / 2 * (apmult - 1.0F));
            i99 = (int) (i99 * apmult + apy + 12.0F * (apmult - 1.0F));
        } else {
            i = (int) (i * apmult + apx);
            i99 = (int) (i99 * apmult + apy + 12.0F * (apmult - 1.0F));
        }
        if (component.getX() != i || component.getY() != i99) {
            component.setBounds(i, i99, i100, i101);
        }
    }

    public void movefielda(final TextArea textarea, int i, int i105, final int i106, final int i107) {
        if (applejava) {
            if (xm > i && xm < i + i106 && ym > i105 && ym < i105 + i107 || !textarea.getText().equals(" ")) {
                if (!textarea.isShowing()) {
                    textarea.setVisible(true);
                    textarea.requestFocus();
                }
                if (i106 == 360 || i106 == 576) {
                    i = (int) (i * apmult + apx + textarea.getWidth() / 2 * (apmult - 1.0F));
                    i105 = (int) (i105 * apmult + apy + 12.0F * (apmult - 1.0F));
                } else {
                    i = (int) (i * apmult + apx);
                    i105 = (int) (i105 * apmult + apy + 12.0F * (apmult - 1.0F));
                }
                if (textarea.getX() != i || textarea.getY() != i105) {
                    textarea.setBounds(i, i105, i106, i107);
                }
            } else {
                if (textarea.isShowing()) {
                    textarea.setVisible(false);
                    requestFocus();
                }
                rd.setColor(textarea.getBackground());
                rd.fillRect(i, i105, i106 - 1, i107 - 1);
                rd.setColor(textarea.getBackground().darker());
                rd.drawRect(i, i105, i106 - 1, i107 - 1);
            }
        } else {
            if (!textarea.isShowing()) {
                textarea.setVisible(true);
            }
            movefield(textarea, i, i105, i106, i107);
        }
    }

    void movefieldd(final TextField textfield, int i, int i102, final int i103, final int i104, final boolean bool) {
        if (applejava) {
            if (bool)
                if (xm > i && xm < i + i103 && ym > i102 && ym < i102 + i104 || !textfield.getText().equals("")) {
                    if (!textfield.isShowing()) {
                        textfield.setVisible(true);
                        textfield.requestFocus();
                    }
                    if (i103 == 360 || i103 == 576) {
                        i = (int) (i * apmult + apx + textfield.getWidth() / 2 * (apmult - 1.0F));
                        i102 = (int) (i102 * apmult + apy + 12.0F * (apmult - 1.0F));
                    } else {
                        i = (int) (i * apmult + apx);
                        i102 = (int) (i102 * apmult + apy + 12.0F * (apmult - 1.0F));
                    }
                    if (textfield.getX() != i || textfield.getY() != i102) {
                        textfield.setBounds(i, i102, i103, i104);
                    }
                } else {
                    if (textfield.isShowing()) {
                        textfield.setVisible(false);
                        requestFocus();
                    }
                    rd.setColor(textfield.getBackground());
                    rd.fillRect(i, i102, i103 - 1, i104 - 1);
                    rd.setColor(textfield.getBackground().darker());
                    rd.drawRect(i, i102, i103 - 1, i104 - 1);
                }
        } else {
            if (bool && !textfield.isShowing()) {
                textfield.setVisible(true);
            }
            movefield(textfield, i, i102, i103, i104);
        }
    }

    void multlink() {
        openurl("http://multiplayer.needformadness.com/");
    }

    void musiclink() {
        openurl("http://multiplayer.needformadness.com/music.html");
    }

    void onfmmlink() {
        openurl("https://github.com/chrishansen69/OpenNFMM");
    }

    private void openurl(final String string) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(string));
            } catch (final Exception exception) {

            }
        } else {
            try {
                Runtime.getRuntime().exec("" + Madness.urlopen() + " " + string + "");
            } catch (final Exception exception) {

            }
        }
    }

    private void trash() {
        rd.dispose();
        xtgraphics.stopallnow();
        //cardefine.stopallnow();
        //udpmistro.UDPquit();
        System.gc();
    }

    private byte loadpaintick = 50;

    @Override
    public void paintComponent(final Graphics graphics) {
        final Graphics2D graphics2d = (Graphics2D) graphics;
        if (moto == 0 || loadpaintick > 0) { //REQUIRED
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, getWidth(), getHeight());
            if (loadpaintick > 0) {
                loadpaintick--;
            }
        }
        try {
            gameTick();
        } catch (final Exception e) {
            e.printStackTrace();
            exwist = true;
            trash();
            System.exit(3);
        }
        if (lastw != getWidth() || lasth != getHeight()) {
            lastw = getWidth();
            lasth = getHeight();
            showsize = 100;
            if (lastw <= 800 || lasth <= 550) {
                reqmult = 0.0F;
            }
            if (Madness.fullscreen) {
                apx = (int) (getWidth() / 2 - 400.0F * apmult);
                apy = (int) (getHeight() / 2 - 225.0F * apmult);
            }
        }
        int i = 0;
        int i97 = 0;
        if (moto == 1 && shaka > 0) {
            i = (int) ((shaka * 2 * ThreadLocalRandom.current().nextDouble() - shaka) * apmult);
            i97 = (int) ((shaka * 2 * ThreadLocalRandom.current().nextDouble() - shaka) * apmult);
            shaka--;
        }
        if (!Madness.fullscreen) {
            if (showsize != 0) {
                if (showsize == 100 || showsize == 70) {
                    graphics2d.clearRect(0, 0, getWidth(), getHeight());
                }
                float f = (getWidth() - 40) / 800.0F - 1.0F;
                if (f > (getHeight() - 70) / 450.0F - 1.0F) {
                    f = (getHeight() - 70) / 450.0F - 1.0F;
                }
                if (f > 1.0F) {
                    f = 1.0F;
                }
                if (f < 0.0F) {
                    f = 0.0F;
                }
                apmult = 1.0F + f * reqmult;
                if (!oncarm) {
                    graphics2d.drawImage(carmaker[0], 50, 14, this);
                } else {
                    graphics2d.drawImage(carmaker[1], 50, 14, this);
                }
                if (!onstgm) {
                    graphics2d.drawImage(stagemaker[0], getWidth() - 208, 14, this);
                } else {
                    graphics2d.drawImage(stagemaker[1], getWidth() - 208, 14, this);
                }
                graphics2d.drawImage(sizebar, getWidth() / 2 - 230, 23, this);
                graphics2d.drawImage(blb, (int) (getWidth() / 2 - 222 + 141.0F * reqmult), 23, this);
                graphics2d.drawImage(chkbx[smooth], getWidth() / 2 - 53, 23, this);
                graphics2d.setFont(new Font("Arial", 1, 11));
                graphics2d.setColor(new Color(74, 99, 125));
                graphics2d.drawString("Screen Size:", getWidth() / 2 - 224, 17);
                graphics2d.drawString("Smooth", getWidth() / 2 - 36, 34);
                graphics2d.drawImage(fulls, getWidth() / 2 + 27, 15, this);
                graphics2d.setColor(new Color(94, 126, 159));
                graphics2d.drawString("Fullscreen", getWidth() / 2 + 63, 30);
                graphics2d.drawImage(chkbx[Madness.anti], getWidth() / 2 + 135, 9, this);
                graphics2d.drawString("Antialiasing", getWidth() / 2 + 152, 20);
                graphics2d.drawImage(chkbx[moto], getWidth() / 2 + 135, 26, this);
                graphics2d.drawString("Motion Effects", getWidth() / 2 + 152, 37);
                graphics2d.setColor(new Color(0, 0, 0));
                graphics2d.fillRect(getWidth() / 2 - 153, 5, 80, 16);
                graphics2d.setColor(new Color(121, 135, 152));
                String string = "" + (int) (apmult * 100.0F) + "%";
                if (reqmult == 0.0F) {
                    string = "Original";
                }
                if (reqmult == 1.0F) {
                    string = "Maximum";
                }
                graphics2d.drawString(string, getWidth() / 2 - 150, 17);
                if (!oncarm && !onstgm) {
                    showsize--;
                }
                if (showsize == 0) {
                    graphics2d.setColor(new Color(0, 0, 0));
                    graphics2d.fillRect(getWidth() / 2 - 260, 0, 520, 40);
                    graphics2d.fillRect(50, 14, 142, 23);
                    graphics2d.fillRect(getWidth() - 208, 14, 158, 23);
                }
            }
            apx = (int) (getWidth() / 2 - 400.0F * apmult);
            apy = (int) (getHeight() / 2 - 225.0F * apmult - 50.0F);
            if (apy < 50) {
                apy = 50;
            }
            if (apmult > 1.0F) {
                if (smooth == 1) {
                    graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    if (moto == 1) {
                        graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
                        rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                        graphics2d.drawImage(offImage, apx + i, apy
                                + i97, (int) (800.0F * apmult), (int) (450.0F * apmult), this);
                        cropit(graphics2d, i, i97);
                    } else {
                        graphics2d.drawImage(offImage, apx, apy, (int) (800.0F * apmult), (int) (450.0F
                                * apmult), this);
                    }
                } else if (moto == 1) {
                    graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
                    rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                    graphics2d.drawImage(offImage, apx + i, apy
                            + i97, (int) (800.0F * apmult), (int) (450.0F * apmult), this);
                    cropit(graphics2d, i, i97);
                } else {
                    graphics2d.drawImage(offImage, apx, apy, (int) (800.0F * apmult), (int) (450.0F * apmult), this);
                }
            } else if (moto == 1) {
                graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
                rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                graphics2d.drawImage(offImage, apx + i, apy + i97, this);
                cropit(graphics2d, i, i97);
            } else {
                graphics2d.drawImage(offImage, apx, apy, this);
            }
        } else if (moto == 1) {
            graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
            rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            graphics2d.drawImage(offImage, apx + i, apy + i97, this);
            cropit(graphics2d, i, i97);
        } else {
            graphics2d.drawImage(offImage, apx, apy, this);
        }
    }

    private void readcookies(final xtGraphics xtgraphics, final CarDefine cardefine, final ContO[] contos) {
        xtgraphics.nickname = "";
        try {
            final File file = new File("" + Madness.fpath + "data/user.data");
            final String[] strings = {
                    "", "", "", "", ""
            };
            if (file.exists()) {
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string;
                for (int i = 0; (string = bufferedreader.readLine()) != null && i < 5; i++) {
                    strings[i] = string;
                }
                bufferedreader.close();
            }
            if (strings[0].startsWith("lastuser")) {
                xtgraphics.nickname = getstring("lastuser", strings[0], 0);
                if (!xtgraphics.nickname.equals("")) {
                    xtgraphics.opselect = 1;
                }
                String string = "";
                try {
                    string = getstring("lastuser", strings[0], 1);
                } catch (final Exception exception) {
                    string = "";
                }
                if (!string.equals("")) {
                    tnick.setText(xtgraphics.nickname);
                    tpass.setText(string);
                    xtgraphics.autolog = true;
                }
            }
            if (strings[2].startsWith("saved")) {
                int i = getint("saved", strings[2], 0);
                if (i >= 0 && i < xtGraphics.nCars) {
                    xtgraphics.scm = i;
                    xtgraphics.firstime = false;
                }
                i = getint("saved", strings[2], 1);
                if (i >= 1 && i <= xtGraphics.nTracks) {
                    xtgraphics.unlocked = i;
                }
            }
            /*if (strings[3].startsWith("NFM2")) {
            	int i = getint("NFM2", strings[3], 0);
            	if (i >= 0 && i < 16) {
            		xtgraphics.scm[1] = i;
            		xtgraphics.firstime = false;
            	}
            	i = getint("NFM2", strings[3], 1);
            }*/
            if (strings[4].startsWith("graphics")) {
                int i = getint("graphics", strings[4], 0);
                if (i >= 0 && i <= 1) {
                    moto = i;
                }
                i = getint("graphics", strings[4], 1);
                if (i >= 0 && i <= 1) {
                    Madness.anti = i;
                }
            }
            if (strings[1].startsWith("lastcar")) {
                int i = getint("lastcar", strings[1], 0);
                cardefine.lastcar = getstring("lastcar", strings[1], 7);
                if (i >= 0 && i < 36) {
                    xtgraphics.osc = i;
                    xtgraphics.firstime = false;
                }
                int i198 = 0;
                for (int i199 = 0; i199 < 6; i199++) {
                    i = getint("lastcar", strings[1], i199 + 1);
                    if (i >= 0 && i <= 100) {
                        xtgraphics.arnp[i199] = i / 100.0F;
                        i198++;
                    }
                }
                if (i198 == 6 && xtgraphics.osc >= 0 && xtgraphics.osc <= 15) {
                    final Color color = Color.getHSBColor(xtgraphics.arnp[0], xtgraphics.arnp[1], 1.0F
                            - xtgraphics.arnp[2]);
                    final Color color200 = Color.getHSBColor(xtgraphics.arnp[3], xtgraphics.arnp[4], 1.0F
                            - xtgraphics.arnp[5]);
                    for (int i201 = 0; i201 < contos[xtgraphics.osc].npl; i201++)
                        if (contos[xtgraphics.osc].p[i201].colnum == 1) {
                            contos[xtgraphics.osc].p[i201].c[0] = color.getRed();
                            contos[xtgraphics.osc].p[i201].c[1] = color.getGreen();
                            contos[xtgraphics.osc].p[i201].c[2] = color.getBlue();
                        }
                    for (int i202 = 0; i202 < contos[xtgraphics.osc].npl; i202++)
                        if (contos[xtgraphics.osc].p[i202].colnum == 2) {
                            contos[xtgraphics.osc].p[i202].c[0] = color200.getRed();
                            contos[xtgraphics.osc].p[i202].c[1] = color200.getGreen();
                            contos[xtgraphics.osc].p[i202].c[2] = color200.getBlue();
                        }
                }
            }
        } catch (final Exception exception) {

        }
    }

    void reglink() {
        openurl("http://multiplayer.needformadness.com/register.html?ref=game");
    }

    void regnew() {
        openurl("http://multiplayer.needformadness.com/registernew.pl");
    }

    public void regprom() {

    }

    private void makeMenus() {
        rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        sgame.add(rd, " NFM 1     ");
        sgame.add(rd, " NFM 2     ");
        sgame.add(rd, " My Stages ");
        sgame.add(rd, " Weekly Top20 ");
        sgame.add(rd, " Monthly Top20 ");
        sgame.add(rd, " All Time Top20 ");
        sgame.add(rd, " Stage Maker ");
        wgame.add(rd, " Normal Game");
        wgame.add(rd, " War / Battle");
        wgame.add(rd, " War / Battle - Practice");
        warb.add(rd, " Loading your clan's wars and battles, please wait...");
        pgame.add(rd, " Select the game you want to practice");
        vnpls.add(rd, "Players");
        vnpls.add(rd, " 2 VS 2");
        vnpls.add(rd, " 3 VS 3");
        vnpls.add(rd, " 4 VS 4");
        vtyp.add(rd, "Normal clan game");
        vtyp.add(rd, "Racing only");
        vtyp.add(rd, "Wasting only");
        vtyp.add(rd, "Racers VS Wasters - my clan wastes");
        vtyp.add(rd, "Racers VS Wasters - my clan races");
        snfmm.add(rd, "Select Stage");
        //snfm1.add(rd, "Select Stage");
        //snfm2.add(rd, "Select Stage");
        mstgs.add(rd, "Suddenly the King becomes Santa's Little Helper");
        mcars.add(rd, "Sword of Justice");
        snpls.add(rd, "Select");
        swait.add(rd, "1 Minute");
        ilaps.add(rd, "Laps");
        ilaps.add(rd, "1 Lap");
        for (int i = 0; i < xtGraphics.nTracks; i++) {
            snfmm.add(rd, " Stage " + (i + 1) + "");
        }
        /*for (int i = 0; i < 10; i++)
        	snfm1.add(rd, "" + (" Stage ") + (i + 1) + (""));
        for (int i = 0; i < 17; i++)
        	snfm2.add(rd, "" + (" Stage ") + (i + 1) + (""));*/
        for (int i = 0; i < 7; i++) {
            snpls.add(rd, "    " + (i + 2) + "");
        }
        for (int i = 0; i < 7; i++) {
            snbts.add(rd, "    " + i + "    ");
        }
        for (int i = 0; i < 2; i++) {
            swait.add(rd, "" + (i + 2) + " Minutes");
        }
        for (int i = 0; i < 15; i++) {
            slaps.add(rd, "" + (i + 1) + "");
        }
        for (int i = 0; i < 14; i++) {
            ilaps.add(rd, "" + (i + 2) + " Laps");
        }
        sclass.add(rd, "All Classes");
        sclass.add(rd, "Class C Cars");
        sclass.add(rd, "Class B & C Cars");
        sclass.add(rd, "Class B Cars");
        sclass.add(rd, "Class A & B Cars");
        sclass.add(rd, "Class A Cars");
        scars.add(rd, "All Cars");
        scars.add(rd, "Custom Cars");
        scars.add(rd, "Game Cars");
        sfix.add(rd, "Unlimited Fixing");
        sfix.add(rd, "4 Fixes");
        sfix.add(rd, "3 Fixes");
        sfix.add(rd, "2 Fixes");
        sfix.add(rd, "1 Fix");
        sfix.add(rd, "No Fixing");
        icars.add(rd, "Type of Cars");
        icars.add(rd, "All Cars");
        icars.add(rd, "Clan Cars");
        icars.add(rd, "Game Cars");
        icars.w = 140;
        gmode.add(rd, " Normal Game ");
        gmode.add(rd, " Practice Game ");
        rooms.rooms = true;
        rooms.add(rd, "Ghostrider :: 1");
        sendtyp.add(rd, "Write a Message");
        sendtyp.add(rd, "Share a Custom Car");
        sendtyp.add(rd, "Share a Custom Stage");
        sendtyp.add(rd, "Send a Clan Invitation");
        sendtyp.add(rd, "Share a Relative Date");
        senditem.add(rd, "Suddenly the King becomes Santa's Little Helper");
        for (int i = 0; i < 6; i++) {
            clanlev.add(rd, "" + (i + 1) + "");
        }
        clanlev.add(rd, "7 - Admin");
        hidefields();
    }

    public GameSparker() {
        BASSLoader.initializeBASS();
        initApplet();
        setBorder(BorderFactory.createLineBorder(Color.black));
        //
        setBackground(new Color(0, 0, 0));

        //rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setLayout(null);
        //dr = new DebugRunner();
        //dr.start();

        offImage = new BufferedImage(800, 450, BufferedImage.TYPE_INT_ARGB);
        if (offImage != null) {
            rd = offImage.createGraphics();
        }
        makeMenus();
        initialize();
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        addFocusListener(this);
        setFocusable(true);
        requestFocusInWindow();
        //ActionListener animate =
        /*ActionListener count = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                counted++;
            }
        };*/
        // 40 - 25 fps (fast)
        // 33 - 30 fps (faster)
        // 25 - 40 fps (fastest)
        final Timer timer = new Timer(46, this);
        timer.start();
        /*Timer counter = new Timer(1, count);
        counter.start();*/
        //timer.setDelay(delay);
    }

    //allan please remove this soon
    private Date date;
    private int clicknowtime;
    private xtGraphics xtgraphics;
    private ContO[] contos;
    private ContO[] stageContos;
    private Mad[] mads;
    private Medium medium;
    private Trackers trackers;
    private CheckPoints checkpoints;
    private CarDefine cardefine;
    private Login login = null;
    private Lobby lobby = null;
    //private Globe globe = null;
    private final UDPMistro udpmistro = new UDPMistro();
    private boolean bool = false;
    private Record record;
    private int recordtime;
    private int finishrecording;
    private int wastedpoint;
    private boolean flashingscreen;
    private long l1;
    private float f2;
    private boolean bool3;
    private int i4;
    private int i5;
    private float f;

    //@Override
    private void initialize() {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 800, 450);
        //repaint();
        requestFocus();
        if (System.getProperty("java.vendor").toLowerCase().indexOf("apple") != -1) {
            applejava = true;
        }
        medium = new Medium();
        trackers = new Trackers();
        checkpoints = new CheckPoints();
        contos = new ContO[carRads.length + partskips + stageRads.length];
        cardefine = new CarDefine(contos, medium, trackers, this);
        xtgraphics = new xtGraphics(medium, cardefine, rd, this);
        sizebar = xtgraphics.getImage("data/sizebar.gif");
        blb = xtgraphics.getImage("data/b.gif");
        fulls = xtgraphics.getImage("data/fullscreen.gif");
        chkbx[0] = xtgraphics.getImage("data/checkbox1.gif");
        chkbx[1] = xtgraphics.getImage("data/checkbox2.gif");
        carmaker[0] = xtgraphics.getImage("data/carmaker1.gif");
        carmaker[1] = xtgraphics.getImage("data/carmaker2.gif");
        stagemaker[0] = xtgraphics.getImage("data/stagemaker1.gif");
        stagemaker[1] = xtgraphics.getImage("data/stagemaker2.gif");
        xtgraphics.loaddata();
        //login = null;
        //lobby = null;
        //globe = null;
        //boolean bool = false;
        //final UDPMistro udpmistro = new UDPMistro();
        record = new Record(medium);
        loadbase(contos, medium, trackers, xtgraphics, false);
        stageContos = new ContO[10000];
        mads = new Mad[8];
        for (int i = 0; i < 8; i++) {
            mads[i] = new Mad(cardefine, medium, record, xtgraphics, i);
            u[i] = new Control(medium);
        }
        f = 47.0F;
        readcookies(xtgraphics, cardefine, contos);
        xtgraphics.testdrive = Madness.testdrive;
        if (xtgraphics.testdrive != 0)
            if (xtgraphics.testdrive <= 2) {
                xtgraphics.sc[0] = cardefine.loadcar(Madness.testcar, 16);
                if (xtgraphics.sc[0] != -1) {
                    xtgraphics.fase = -9;
                } else {
                    Madness.testcar = "Failx12";
                    Madness.carmaker();
                }
            } else {
                checkpoints.name = Madness.testcar;
                xtgraphics.fase = -9;
            }
        xtgraphics.stoploading();
        requestFocus();
        if (xtgraphics.testdrive == 0 && xtgraphics.firstime) {
            setupini();
        }
        System.gc();
        date = new Date();
        l1 = date.getTime();
        f2 = 30.0F;
        bool3 = false;
        i4 = 530;
        i5 = 0;
        recordtime = 0;
        clicknowtime = 0;
        finishrecording = 0;
        wastedpoint = 0;
        flashingscreen = false;

        //while (!Thread.currentThread().isInterrupted()) {}
    }

    private void gameTick() {

        date = new Date();
        date.getTime();
        if (xtgraphics.fase == 111) {
            if (mouses == 1) {
                clicknowtime = 800;
            }
            if (clicknowtime < 800) {
                xtgraphics.clicknow();
                clicknowtime++;
            } else {
                clicknowtime = 0;
                if (!exwist) {
                    xtgraphics.fase = 9;
                }
                mouses = 0;
                lostfcs = false;
            }
        }
        if (xtgraphics.fase == 9)
            if (clicknowtime < 76) {
                xtgraphics.rad(clicknowtime);
                catchlink();
                if (mouses == 2) {
                    mouses = 0;
                }
                if (mouses == 1) {
                    mouses = 2;
                }
                clicknowtime++;
            } else {
                clicknowtime = 0;
                xtgraphics.fase = 10;
                mouses = 0;
                u[0].falseo(0);
            }
        if (xtgraphics.fase == -9) {
            if (xtgraphics.loadedt) {
                xtgraphics.mainbg(-101);
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(0, 0, 800, 450);
                //repaint();
                xtgraphics.strack.unload();
                xtgraphics.strack = null;
                xtgraphics.flexpix = null;
                xtgraphics.fleximg = null;
                System.gc();
                xtgraphics.loadedt = false;
            }
            if (clicknowtime < 2) {
                xtgraphics.mainbg(-101);
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(65, 25, 670, 400);
                clicknowtime++;
            } else {
                checkmemory(xtgraphics);
                xtgraphics.inishcarselect(contos);
                clicknowtime = 0;
                xtgraphics.fase = 7;
                mvect = 50;
                mouses = 0;
            }
        }
        if (xtgraphics.fase == 8) {
            xtgraphics.credits(u[0], xm, ym, mouses);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (xtgraphics.flipo <= 100) {
                catchlink();
            }
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == 10) {
            mvect = 100;
            xtgraphics.maini(u[0]);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == 103) {
            mvect = 100;
            if (xtgraphics.loadedt) {
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(0, 0, 800, 450);
                //repaint();
                checkmemory(xtgraphics);
                xtgraphics.strack.unload();
                xtgraphics.strack = null;
                xtgraphics.flexpix = null;
                xtgraphics.fleximg = null;
                System.gc();
                xtgraphics.loadedt = false;
            }
            if (xtgraphics.testdrive == 1 || xtgraphics.testdrive == 2) {
                Madness.carmaker();
            }
            if (xtgraphics.testdrive == 3 || xtgraphics.testdrive == 4) {
                Madness.stagemaker();
            }
            xtgraphics.maini(u[0]);
            xtgraphics.fase = 10;
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == 102) {
            mvect = 100;
            if (xtgraphics.loadedt) {
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(0, 0, 800, 450);
                //repaint();
                checkmemory(xtgraphics);
                xtgraphics.strack.unload();
                xtgraphics.strack = null;
                xtgraphics.flexpix = null;
                xtgraphics.fleximg = null;
                System.gc();
                xtgraphics.loadedt = false;
            }
            if (xtgraphics.testdrive == 1 || xtgraphics.testdrive == 2) {
                Madness.carmaker();
            }
            if (xtgraphics.testdrive == 3 || xtgraphics.testdrive == 4) {
                Madness.stagemaker();
            }
            xtgraphics.maini2(u[0], xm, ym, mouses);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == -22) {
            checkpoints.name = Madness.testcar;
            checkpoints.stage = -1;
            loadstage(stageContos, contos, medium, trackers, checkpoints, xtgraphics, mads, record);
            if (checkpoints.stage == -3) {
                Madness.testcar = "Failx12";
                Madness.stagemaker();
            }
        }
        if (xtgraphics.fase == 11) {
            xtgraphics.inst(u[0]);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == -5) {
            mvect = 100;
            xtgraphics.finish(checkpoints, contos, u[0], xm, ym, moused);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == 7) {
            xtgraphics.carselect(u[0], contos, mads[0], xm, ym, moused);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
            drawms();
        }
        if (xtgraphics.fase == 6) {
            xtgraphics.musicomp(checkpoints.stage, u[0]);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == 5) {
            mvect = 100;
            xtgraphics.loadmusic(checkpoints.stage, checkpoints.trackname, checkpoints.trackvol);
        }
        if (xtgraphics.fase == 4) {
            xtgraphics.cantgo(u[0]);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == 3) {
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(65, 25, 670, 400);
            //repaint();
            xtgraphics.inishstageselect(checkpoints);
        }
        if (xtgraphics.fase == 2) {
            mvect = 100;
            xtgraphics.loadingstage(checkpoints.stage, true);
            checkpoints.nfix = 0;
            checkpoints.notb = false;
            loadstage(stageContos, contos, medium, trackers, checkpoints, xtgraphics, mads, record);
            u[0].falseo(0);
            udpmistro.freg = 0.0F;
            mvect = 20;
        }
        if (xtgraphics.fase == 1) {
            xtgraphics.trackbg(false);
            rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            if (checkpoints.stage != -3) {
                medium.aroundtrack(checkpoints);
                if (medium.hit == 5000 && mvect < 40) {
                    mvect++;
                }
                int j = 0;
                final int[] is = new int[1000];
                for (int k = xtgraphics.nplayers; k < notb; k++)
                    if (stageContos[k].dist != 0) {
                        is[j] = k;
                        j++;
                    } else {
                        stageContos[k].d(rd);
                    }
                final int[] is2 = new int[j];
                for (int k = 0; k < j; k++) {
                    is2[k] = 0;
                }
                for (int k = 0; k < j; k++) {
                    for (int l = k + 1; l < j; l++)
                        if (stageContos[is[k]].dist != stageContos[is[l]].dist) {
                            if (stageContos[is[k]].dist < stageContos[is[l]].dist) {
                                is2[k]++;
                            } else {
                                is2[l]++;
                            }
                        } else if (l > k) {
                            is2[k]++;
                        } else {
                            is2[l]++;
                        }
                }
                for (int k = 0; k < j; k++) {
                    for (int l = 0; l < j; l++)
                        if (is2[l] == k) {
                            stageContos[is[l]].d(rd);
                        }
                }
            }
            if (!openm) {
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
            }
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
            rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            xtgraphics.stageselect(checkpoints, u[0], xm, ym, moused);
            drawms();
        }
        if (xtgraphics.fase == 1177) {
            mvect = 100;
            if (!bool) {
                if (xtgraphics.loadedt) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 800, 450);
                    //repaint();
                    checkmemory(xtgraphics);
                    xtgraphics.strack.unload();
                    xtgraphics.strack = null;
                    xtgraphics.flexpix = null;
                    xtgraphics.fleximg = null;
                    System.gc();
                    xtgraphics.loadedt = false;
                }
                xtgraphics.intertrack.unload();
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(65, 25, 670, 400);
                if (mload > 0) {
                    rd.drawImage(xtgraphics.mload, 259, 195, this);
                }
                //repaint();
                if (mload == 2) {
                    cardefine.loadready();
                    loadbase(contos, medium, trackers, xtgraphics, true);
                    readcookies(xtgraphics, cardefine, contos);
                    mload = -1;
                }
                System.gc();
                login = new Login(medium, rd, xtgraphics, this);
                //globe = new Globe(rd, xtgraphics, medium, login, cardefine, checkpoints, contos, contos0,
                //		this);
                lobby = new Lobby(medium, rd, login, xtgraphics, cardefine, this);
                bool = true;
            }
            if (login.fase != 18) {
                final boolean bool20 = false;
                if (login.fase == 0) {
                    login.inishmulti();
                }
                if (login.fase >= 1 && login.fase <= 11) {
                    login.multistart(contos, xm, ym, moused);
                }
                if (login.fase >= 12 && login.fase <= 17) {
                    //if (globe.open != 452)
                    login.multimode(contos);
                }
                //else
                //	bool20 = true;
                //globe.dome(0, xm, ym, moused, u[0]);
                if (login.justlog) {
                    //if (!xtgraphics.clan.equals(""))
                    //	globe.itab = 2;
                    login.justlog = false;
                }
                if (!bool20) {
                    login.ctachm(xm, ym, mouses, u[0], lobby);
                    mvect = 50;
                } else {
                    drawms();
                    mvect = 100;
                }
                if (mouses == 1) {
                    mouses = 11;
                }
                if (mouses <= -1) {
                    mouses--;
                    if (mouses == -4) {
                        mouses = 0;
                    }
                }
                if (mousew != 0)
                    if (mousew > 0) {
                        mousew--;
                    } else {
                        mousew++;
                    }
            } else {
                if (lobby.fase == 0) {
                    lobby.inishlobby();
                    mvect = 100;
                }
                if (lobby.fase == 1) {
                    /*if (globe.open >= 2 && globe.open < 452)
                    	openm = true;
                    if (globe.open != 452)*/
                    lobby.lobby(xm, ym, moused, mousew, checkpoints, u[0], contos);
                    /*else
                    	bool21 = true;
                    globe.dome(lobby.conon, xm, ym, moused, u[0]);*/
                    if (lobby.loadstage > 0) {
                        setCursor(new Cursor(3));
                        drawms();
                        //repaint();
                        trackers.nt = 0;
                        if (loadstagePreview(lobby.loadstage, "", stageContos, contos, medium, checkpoints)) {
                            lobby.gstagename = checkpoints.name;
                            lobby.gstagelaps = checkpoints.nlaps;
                            lobby.loadstage = -lobby.loadstage;
                        } else {
                            lobby.loadstage = 0;
                            checkpoints.name = "";
                        }
                        setCursor(new Cursor(0));
                    }
                    if (lobby.msload != 0) {
                        setCursor(new Cursor(3));
                        drawms();
                        //repaint();
                        if (lobby.msload == 1) {
                            cardefine.loadmystages(checkpoints);
                        }
                        if (lobby.msload == 7) {
                            cardefine.loadclanstages(xtgraphics.clan);
                        }
                        if (lobby.msload == 3 || lobby.msload == 4) {
                            cardefine.loadtop20(lobby.msload);
                        }
                        lobby.msload = 0;
                        setCursor(new Cursor(0));
                    }
                }
                if (lobby.fase == 3) {
                    xtgraphics.trackbg(false);
                    medium.trk = 0;
                    medium.focusPoint = 400;
                    medium.crs = true;
                    medium.x = -335;
                    medium.y = 0;
                    medium.z = -50;
                    medium.xz = 0;
                    medium.zy = 20;
                    medium.ground = -2000;
                    mvect = 100;
                    lobby.fase = 1;
                }
                if (lobby.fase == 4) {
                    mvect = 50;
                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                    medium.d(rd);
                    medium.aroundtrack(checkpoints);
                    int j = 0;
                    final int[] is = new int[1000];
                    for (int k = 0; k < nob; k++)
                        if (stageContos[k].dist != 0) {
                            is[j] = k;
                            j++;
                        } else {
                            stageContos[k].d(rd);
                        }
                    final int[] is2 = new int[j];
                    for (int k = 0; k < j; k++) {
                        is2[k] = 0;
                    }
                    for (int k = 0; k < j; k++) {
                        for (int l = k + 1; l < j; l++)
                            if (stageContos[is[k]].dist != stageContos[is[l]].dist) {
                                if (stageContos[is[k]].dist < stageContos[is[l]].dist) {
                                    is2[k]++;
                                } else {
                                    is2[l]++;
                                }
                            } else if (l > k) {
                                is2[k]++;
                            } else {
                                is2[l]++;
                            }
                    }
                    for (int k = 0; k < j; k++) {
                        for (int l = 0; l < j; l++)
                            if (is2[l] == k) {
                                stageContos[is[l]].d(rd);
                            }
                    }
                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    lobby.stageselect(checkpoints, u[0], xm, ym, moused);
                    if (lobby.plsndt == 1) {
                        mvect = 70;
                        //repaint();
                        setCursor(new Cursor(3));
                        xtgraphics.loadstrack(checkpoints.stage, checkpoints.trackname, checkpoints.trackvol);
                        xtgraphics.strack.play();
                        lobby.plsndt = 2;
                        moused = false;
                        mouses = 0;
                    }
                }
                if (lobby.fase == 2) {
                    int j = 0;
                    for (int k = 0; k < lobby.ngm; k++)
                        if (lobby.ongame == lobby.gnum[k]) {
                            j = k;
                        }
                    boolean flag = false;
                    if (lobby.gstgn[j] > 0) {
                        if (lobby.gstgn[j] == -lobby.loadstage) {
                            flag = true;
                        }
                    } else if (lobby.gstages[j].equals(checkpoints.name)) {
                        flag = true;
                    }
                    if (flag) {
                        lobby.fase = 4;
                        lobby.addstage = 0;
                    } else {
                        xtgraphics.loadingstage(lobby.gstgn[j], false);
                        trackers.nt = 0;
                        if (loadstagePreview(lobby.gstgn[j], lobby.gstages[j], stageContos, contos, medium, checkpoints)) {
                            lobby.loadstage = -lobby.gstgn[j];
                            lobby.fase = 4;
                            lobby.addstage = 0;
                        } else {
                            lobby.loadstage = 0;
                            checkpoints.name = "";
                            lobby.fase = 3;
                        }
                    }
                }
                if (lobby.fase == 76) {
                    checkpoints.nlaps = lobby.laps;
                    checkpoints.stage = lobby.stage;
                    checkpoints.name = lobby.stagename;
                    checkpoints.nfix = lobby.nfix;
                    checkpoints.notb = lobby.notb;
                    xtgraphics.fase = 21;
                    u[0].multion = xtgraphics.multion;
                }
                /*if (globe.loadwbgames == 7) {
                	//repaint();
                	globe.redogame();
                }*/
                if (!openm) {
                    lobby.ctachm(xm, ym, mouses, u[0]);
                } else {
                    mouses = 0;
                }
                drawms();
                if (lobby.fase == 1) {
                    lobby.preforma(xm, ym);
                }
                if (lobby.loadwarb) {
                    //repaint();
                    //globe.loadwarb();
                    lobby.loadwarb = false;
                }
                /*if (globe.loadwbgames == 1) {
                	//repaint();
                	globe.loadwgames();
                }*/
                if (mouses == 1) {
                    mouses = 11;
                }
                if (mouses <= -1) {
                    mouses--;
                    if (mouses == -4) {
                        mouses = 0;
                    }
                }
                if (mousew != 0) {
                    if (mousew > 0) {
                        mousew--;
                    } else {
                        mousew++;
                    }
                    if (!lobby.zeromsw) {
                        mousew = 0;
                    }
                }
            }
        }
        if (xtgraphics.fase == 24) {
            login.endcons();
            login = null;
            lobby = null;
            //globe = null;
            bool = false;
            System.gc();
            System.runFinalization();
            if (!xtgraphics.mtop) {
                xtgraphics.fase = 102;
                xtgraphics.opselect = 2;
            } else {
                xtgraphics.fase = 10;
                xtgraphics.opselect = 1;
            }
        }
        if (xtgraphics.fase == 23) {
            if (login.fase == 18) {
                xtgraphics.playingame = -101;
            }
            login.stopallnow();
            lobby.stopallnow();
            //globe.stopallnow();
            login = null;
            lobby = null;
            //globe = null;
            hidefields();
            bool = false;
            System.gc();
            System.runFinalization();
            xtgraphics.fase = -9;
        }
        if (xtgraphics.fase == 22) {
            loadstage(stageContos, contos, medium, trackers, checkpoints, xtgraphics, mads, record);
            if (checkpoints.stage != -3) {
                if (xtgraphics.lan && xtgraphics.im == 0) {
                    udpmistro.UDPLanServer(xtgraphics.nplayers, xtgraphics.server, xtgraphics.servport, xtgraphics.playingame);
                }
                u[0].falseo(2);
                requestFocus();
            } else {
                xtgraphics.fase = 1177;
            }
        }
        if (xtgraphics.fase == 21) {
            login.endcons();
            login = null;
            lobby = null;
            //globe = null;
            bool = false;
            System.gc();
            System.runFinalization();
            xtgraphics.fase = 22;
        }
        if (xtgraphics.fase == 0) {
            for (int player = 0; player < xtgraphics.nplayers; player++)
                if (mads[player].newcar) {
                    final int i34 = stageContos[player].xz;
                    final int i35 = stageContos[player].xy;
                    final int i36 = stageContos[player].zy;
                    stageContos[player] = new ContO(contos[mads[player].cn], stageContos[player].x, stageContos[player].y, stageContos[player].z, 0);
                    stageContos[player].xz = i34;
                    stageContos[player].xy = i35;
                    stageContos[player].zy = i36;
                    mads[player].newcar = false;
                }
            medium.d(rd);
            int j = 0;
            final int[] is = new int[10000];
            for (int k = 0; k < nob; k++)
                if (stageContos[k].dist != 0) {
                    is[j] = k;
                    j++;
                } else {
                    stageContos[k].d(rd);
                }
            final int[] is2 = new int[j];
            final int[] is3 = new int[j];
            for (int k = 0; k < j; k++) {
                is2[k] = 0;
            }
            for (int k = 0; k < j; k++) {
                for (int l = k + 1; l < j; l++)
                    if (stageContos[is[k]].dist < stageContos[is[l]].dist) {
                        is2[k]++;
                    } else {
                        is2[l]++;
                    }
                is3[is2[k]] = k;
            }
            for (int k = 0; k < j; k++) {
                stageContos[is[is3[k]]].d(rd);
            }
            if (xtgraphics.starcnt == 0) {
                for (int k = 0; k < xtgraphics.nplayers; k++) {
                    for (int l = 0; l < xtgraphics.nplayers; l++)
                        if (l != k) {
                            mads[k].colide(stageContos[k], mads[l], stageContos[l]);
                        }
                }
                for (int k = 0; k < xtgraphics.nplayers; k++) {
                    mads[k].drive(u[k], stageContos[k], trackers, checkpoints);
                }
                for (int k = 0; k < xtgraphics.nplayers; k++) {
                    record.rec(stageContos[k], k, mads[k].squash, mads[k].lastcolido, mads[k].cntdest, 0);
                }
                checkpoints.checkstat(mads, stageContos, record, xtgraphics.nplayers, xtgraphics.im, 0);
                for (int k = 1; k < xtgraphics.nplayers; k++) {
                    u[k].preform(mads[k], stageContos[k], checkpoints, trackers);
                }
            } else {
                if (xtgraphics.starcnt == 130) {
                    medium.adv = 1900;
                    medium.zy = 40;
                    medium.vxz = 70;
                    rd.setColor(new Color(255, 255, 255));
                    rd.fillRect(0, 0, 800, 450);
                }
                if (xtgraphics.starcnt != 0) {
                    xtgraphics.starcnt--;
                }
            }
            if (xtgraphics.starcnt < 38) {
                if (view == 0) {
                    medium.follow(stageContos[0], mads[0].cxz, u[0].lookback);
                    xtgraphics.stat(mads[0], stageContos[0], checkpoints, u[0], true);
                    if (mads[0].outshakedam > 0) {
                        shaka = mads[0].outshakedam / 20;
                        if (shaka > 25) {
                            shaka = 25;
                        }
                    }
                    mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                    if (mvect > 90) {
                        mvect = 90;
                    }
                    lmxz = medium.xz;
                }
                if (view == 1) {
                    medium.around(stageContos[0], false);
                    xtgraphics.stat(mads[0], stageContos[0], checkpoints, u[0], false);
                    mvect = 80;
                }
                if (view == 2) {
                    medium.watch(stageContos[0], mads[0].mxz);
                    xtgraphics.stat(mads[0], stageContos[0], checkpoints, u[0], false);
                    mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                    if (mvect > 90) {
                        mvect = 90;
                    }
                    lmxz = medium.xz;
                }
                if (mouses == 1) {
                    u[0].enter = true;
                    mouses = 0;
                }
            } else {
                int k = 3;
                if (xtgraphics.nplayers == 1) {
                    k = 0;
                }
                medium.around(stageContos[k], true);
                mvect = 80;
                if (u[0].enter || u[0].handb) {
                    xtgraphics.starcnt = 38;
                    u[0].enter = false;
                    u[0].handb = false;
                }
                if (xtgraphics.starcnt == 38) {
                    mouses = 0;
                    medium.vert = false;
                    medium.adv = 900;
                    medium.vxz = 180;
                    checkpoints.checkstat(mads, stageContos, record, xtgraphics.nplayers, xtgraphics.im, 0);
                    medium.follow(stageContos[0], mads[0].cxz, 0);
                    xtgraphics.stat(mads[0], stageContos[0], checkpoints, u[0], true);
                    rd.setColor(new Color(255, 255, 255));
                    rd.fillRect(0, 0, 800, 450);
                }
            }
        }
        if (xtgraphics.fase == 7001) {
            for (int player = 0; player < xtgraphics.nplayers; player++)
                if (mads[player].newedcar == 0 && mads[player].newcar) {
                    final int i52 = stageContos[player].xz;
                    final int i53 = stageContos[player].xy;
                    final int i54 = stageContos[player].zy;
                    xtgraphics.colorCar(contos[mads[player].cn], player);
                    stageContos[player] = new ContO(contos[mads[player].cn], stageContos[player].x, stageContos[player].y, stageContos[player].z, 0);
                    stageContos[player].xz = i52;
                    stageContos[player].xy = i53;
                    stageContos[player].zy = i54;
                    mads[player].newedcar = 20;
                }
            medium.d(rd);
            int j = 0;
            final int[] is = new int[10000];
            for (int k = 0; k < nob; k++)
                if (stageContos[k].dist != 0) {
                    is[j] = k;
                    j++;
                } else {
                    stageContos[k].d(rd);
                }
            final int[] is2 = new int[j];
            final int[] is3 = new int[j];
            for (int k = 0; k < j; k++) {
                is2[k] = 0;
            }
            for (int k = 0; k < j; k++) {
                for (int l = k + 1; l < j; l++)
                    if (stageContos[is[k]].dist < stageContos[is[l]].dist) {
                        is2[k]++;
                    } else {
                        is2[l]++;
                    }
                is3[is2[k]] = k;
            }
            for (int k = 0; k < j; k++) {
                if (is[is3[k]] < xtgraphics.nplayers && is[is3[k]] != xtgraphics.im) {
                    udpmistro.readContOinfo(stageContos[is[is3[k]]], is[is3[k]]);
                }
                stageContos[is[is3[k]]].d(rd);
            }
            if (xtgraphics.starcnt == 0) {
                if (xtgraphics.multion == 1) {
                    int k = 1;
                    for (int l = 0; l < xtgraphics.nplayers; l++)
                        if (xtgraphics.im != l) {
                            udpmistro.readinfo(mads[l], stageContos[l], u[k], l, checkpoints.dested);
                            k++;
                        }
                } else {
                    for (int l = 0; l < xtgraphics.nplayers; l++) {
                        udpmistro.readinfo(mads[l], stageContos[l], u[l], l, checkpoints.dested);
                    }
                }
                for (int k = 0; k < xtgraphics.nplayers; k++) {
                    for (int l = 0; l < xtgraphics.nplayers; l++)
                        if (l != k) {
                            mads[k].colide(stageContos[k], mads[l], stageContos[l]);
                        }
                }
                if (xtgraphics.multion == 1) {
                    int k = 1;
                    for (int l = 0; l < xtgraphics.nplayers; l++)
                        if (xtgraphics.im != l) {
                            mads[l].drive(u[k], stageContos[l], trackers, checkpoints);
                            k++;
                        } else {
                            mads[l].drive(u[0], stageContos[l], trackers, checkpoints);
                        }
                    for (int l = 0; l < xtgraphics.nplayers; l++) {
                        record.rec(stageContos[l], l, mads[l].squash, mads[l].lastcolido, mads[l].cntdest, xtgraphics.im);
                    }
                } else {
                    for (int k = 0; k < xtgraphics.nplayers; k++) {
                        mads[k].drive(u[k], stageContos[k], trackers, checkpoints);
                    }
                }
                checkpoints.checkstat(mads, stageContos, record, xtgraphics.nplayers, xtgraphics.im, xtgraphics.multion);
            } else {
                if (xtgraphics.starcnt == 130) {
                    medium.adv = 1900;
                    medium.zy = 40;
                    medium.vxz = 70;
                    rd.setColor(new Color(255, 255, 255));
                    rd.fillRect(0, 0, 800, 450);
                    //repaint();
                    if (xtgraphics.lan) {
                        udpmistro.UDPConnectLan(xtgraphics.localserver, xtgraphics.nplayers, xtgraphics.im);
                        if (xtgraphics.im == 0) {
                            xtgraphics.setbots(udpmistro.isbot, udpmistro.frame);
                        }
                    } else {
                        udpmistro.UDPConnectOnline(xtgraphics.server, xtgraphics.gameport, xtgraphics.nplayers, xtgraphics.im);
                    }
                    if (xtgraphics.multion >= 2) {
                        xtgraphics.im = (int) (ThreadLocalRandom.current().nextDouble() * xtgraphics.nplayers);
                        xtgraphics.starcnt = 0;
                    }
                }
                if (xtgraphics.starcnt == 50) {
                    udpmistro.frame[udpmistro.im][0] = 0;
                }
                if (xtgraphics.starcnt != 39 && xtgraphics.starcnt != 0) {
                    xtgraphics.starcnt--;
                }
                if (udpmistro.go && xtgraphics.starcnt >= 39) {
                    xtgraphics.starcnt = 38;
                    if (xtgraphics.lan) {
                        int k = checkpoints.stage;
                        if (k < 0) {
                            k = 33;
                        }
                        if (xtgraphics.loadedt) {
                            xtgraphics.strack.play();
                        }
                    }
                }
            }
            if (xtgraphics.lan && udpmistro.im == 0) {
                for (int k = 2; k < xtgraphics.nplayers; k++)
                    if (udpmistro.isbot[k]) {
                        u[k].preform(mads[k], stageContos[k], checkpoints, trackers);
                        udpmistro.setinfo(mads[k], stageContos[k], u[k], checkpoints.pos[k], checkpoints.magperc[k], false, k);
                    }
            }
            if (xtgraphics.starcnt < 38) {
                if (xtgraphics.multion == 1) {
                    udpmistro.setinfo(mads[xtgraphics.im], stageContos[xtgraphics.im], u[0], checkpoints.pos[xtgraphics.im], checkpoints.magperc[xtgraphics.im], xtgraphics.holdit, xtgraphics.im);
                    if (view == 0) {
                        medium.follow(stageContos[xtgraphics.im], mads[xtgraphics.im].cxz, u[0].lookback);
                        xtgraphics.stat(mads[xtgraphics.im], stageContos[xtgraphics.im], checkpoints, u[0], true);
                        if (mads[xtgraphics.im].outshakedam > 0) {
                            shaka = mads[xtgraphics.im].outshakedam / 20;
                            if (shaka > 25) {
                                shaka = 25;
                            }
                        }
                        mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                        if (mvect > 90) {
                            mvect = 90;
                        }
                        lmxz = medium.xz;
                    }
                    if (view == 1) {
                        medium.around(stageContos[xtgraphics.im], false);
                        xtgraphics.stat(mads[xtgraphics.im], stageContos[xtgraphics.im], checkpoints, u[0], false);
                        mvect = 80;
                    }
                    if (view == 2) {
                        medium.watch(stageContos[xtgraphics.im], mads[xtgraphics.im].mxz);
                        xtgraphics.stat(mads[xtgraphics.im], stageContos[xtgraphics.im], checkpoints, u[0], false);
                        mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                        if (mvect > 90) {
                            mvect = 90;
                        }
                        lmxz = medium.xz;
                    }
                } else {
                    if (view == 0) {
                        medium.getaround(stageContos[xtgraphics.im]);
                        mvect = 80;
                    }
                    if (view == 1) {
                        medium.getfollow(stageContos[xtgraphics.im], mads[xtgraphics.im].cxz, u[0].lookback);
                        mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                        if (mvect > 90) {
                            mvect = 90;
                        }
                        lmxz = medium.xz;
                    }
                    if (view == 2) {
                        medium.watch(stageContos[xtgraphics.im], mads[xtgraphics.im].mxz);
                        mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                        if (mvect > 90) {
                            mvect = 90;
                        }
                        lmxz = medium.xz;
                    }
                    xtgraphics.stat(mads[xtgraphics.im], stageContos[xtgraphics.im], checkpoints, u[0], true);
                }
                if (mouses == 1) {
                    if (xtgraphics.holdit && xtgraphics.exitm != 4 && xtgraphics.multion == 1) {
                        u[0].enter = true;
                    }
                    mouses = 0;
                }
            } else {
                medium.around(stageContos[xtgraphics.im], true);
                mvect = 80;
                if (xtgraphics.starcnt == 39) {
                    xtgraphics.waitenter();
                }
                if (xtgraphics.starcnt == 38) {
                    xtgraphics.forstart = 0;
                    mouses = 0;
                    medium.vert = false;
                    medium.adv = 900;
                    medium.vxz = 180;
                    checkpoints.checkstat(mads, stageContos, record, xtgraphics.nplayers, xtgraphics.im, xtgraphics.multion);
                    medium.follow(stageContos[xtgraphics.im], mads[xtgraphics.im].cxz, 0);
                    xtgraphics.stat(mads[xtgraphics.im], stageContos[xtgraphics.im], checkpoints, u[0], true);
                    rd.setColor(new Color(255, 255, 255));
                    rd.fillRect(0, 0, 800, 450);
                }
            }
            xtgraphics.multistat(u[0], checkpoints, xm, ym, moused, udpmistro);
        }
        if (xtgraphics.fase == -1) {
            if (recordtime == 0) {
                for (int j = 0; j < xtgraphics.nplayers; j++) {
                    record.ocar[j] = new ContO(stageContos[j], 0, 0, 0, 0);
                    stageContos[j] = new ContO(record.car[0][j], 0, 0, 0, 0);
                }
            }
            medium.d(rd);
            int j = 0;
            final int[] is = new int[10000];
            for (int k = 0; k < nob; k++)
                if (stageContos[k].dist != 0) {
                    is[j] = k;
                    j++;
                } else {
                    stageContos[k].d(rd);
                }
            final int[] is2 = new int[j];
            for (int k = 0; k < j; k++) {
                is2[k] = 0;
            }
            for (int k = 0; k < j; k++) {
                for (int l = k + 1; l < j; l++)
                    if (stageContos[is[k]].dist != stageContos[is[l]].dist) {
                        if (stageContos[is[k]].dist < stageContos[is[l]].dist) {
                            is2[k]++;
                        } else {
                            is2[l]++;
                        }
                    } else if (l > k) {
                        is2[k]++;
                    } else {
                        is2[l]++;
                    }
            }
            for (int k = 0; k < j; k++) {
                for (int l = 0; l < j; l++)
                    if (is2[l] == k) {
                        stageContos[is[l]].d(rd);
                    }
            }
            if (u[0].enter || u[0].handb || mouses == 1) {
                recordtime = 299;
                u[0].enter = false;
                u[0].handb = false;
                mouses = 0;
            }
            for (int k = 0; k < xtgraphics.nplayers; k++) {
                if (record.fix[k] == recordtime)
                    if (stageContos[k].dist == 0) {
                        stageContos[k].fcnt = 8;
                    } else {
                        stageContos[k].fix = true;
                    }
                if (stageContos[k].fcnt == 7 || stageContos[k].fcnt == 8) {
                    stageContos[k] = new ContO(contos[mads[k].cn], 0, 0, 0, 0);
                    record.cntdest[k] = 0;
                }
                if (recordtime == 299) {
                    stageContos[k] = new ContO(record.ocar[k], 0, 0, 0, 0);
                }
                record.play(stageContos[k], mads[k], k, recordtime);
            }
            if (++recordtime == 300) {
                recordtime = 0;
                xtgraphics.fase = -6;
            } else {
                xtgraphics.replyn();
            }
            medium.around(stageContos[0], false);
        }
        if (xtgraphics.fase == -2) {
            if (xtgraphics.multion >= 2) {
                record.hcaught = false;
            }
            u[0].falseo(3);
            if (record.hcaught && record.wasted == 0 && record.whenwasted != 229
                    && (checkpoints.stage == 1 || checkpoints.stage == 2) && xtgraphics.looped != 0) {
                record.hcaught = false;
            }
            if (record.hcaught) {
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(0, 0, 800, 450);
                //repaint();
            }
            if (xtgraphics.multion != 0) {
                udpmistro.UDPquit();
                xtgraphics.stopchat();
                if (cmsg.isShowing()) {
                    cmsg.setVisible(false);
                }
                cmsg.setText("");
                requestFocus();
            }
            if (record.hcaught) {
                if (medium.random() > 0.45) {
                    medium.vert = false;
                } else {
                    medium.vert = true;
                }
                medium.adv = (int) (900.0F * medium.random());
                medium.vxz = (int) (360.0F * medium.random());
                recordtime = 0;
                xtgraphics.fase = -3;
                clicknowtime = 0;
                finishrecording = 0;
            } else {
                recordtime = -2;
                xtgraphics.fase = -4;
            }
        }
        if (xtgraphics.fase == -3) {
            if (recordtime == 0) {
                if (record.wasted == 0) {
                    if (record.whenwasted == 229) {
                        wastedpoint = 67;
                        medium.vxz += 90;
                    } else {
                        wastedpoint = (int) (medium.random() * 4.0F);
                        if (wastedpoint == 1 || wastedpoint == 3) {
                            wastedpoint = 69;
                        }
                        if (wastedpoint == 2 || wastedpoint == 4) {
                            wastedpoint = 30;
                        }
                    }
                } else if (record.closefinish != 0 && finishrecording != 0) {
                    medium.vxz += 90;
                }
                for (int j = 0; j < xtgraphics.nplayers; j++) {
                    stageContos[j] = new ContO(record.starcar[j], 0, 0, 0, 0);
                }
            }
            medium.d(rd);
            int j = 0;
            final int[] is = new int[10000];
            for (int k = 0; k < nob; k++)
                if (stageContos[k].dist != 0) {
                    is[j] = k;
                    j++;
                } else {
                    stageContos[k].d(rd);
                }
            final int[] is2 = new int[j];
            for (int k = 0; k < j; k++) {
                is2[k] = 0;
            }
            for (int k = 0; k < j; k++) {
                for (int l = k + 1; l < j; l++)
                    if (stageContos[is[k]].dist != stageContos[is[l]].dist) {
                        if (stageContos[is[k]].dist < stageContos[is[l]].dist) {
                            is2[k]++;
                        } else {
                            is2[l]++;
                        }
                    } else if (l > k) {
                        is2[k]++;
                    } else {
                        is2[l]++;
                    }
            }
            for (int k = 0; k < j; k++) {
                for (int l = 0; l < j; l++)
                    if (is2[l] == k) {
                        stageContos[is[l]].d(rd);
                    }
            }
            for (int k = 0; k < xtgraphics.nplayers; k++) {
                if (record.hfix[k] == recordtime)
                    if (stageContos[k].dist == 0) {
                        stageContos[k].fcnt = 8;
                    } else {
                        stageContos[k].fix = true;
                    }
                if (stageContos[k].fcnt == 7 || stageContos[k].fcnt == 8) {
                    stageContos[k] = new ContO(contos[mads[k].cn], 0, 0, 0, 0);
                    record.cntdest[k] = 0;
                }
                record.playh(stageContos[k], mads[k], k, recordtime, xtgraphics.im);
            }
            if (finishrecording == 2 && recordtime == 299) {
                u[0].enter = true;
            }
            if (u[0].enter || u[0].handb) {
                xtgraphics.fase = -4;
                u[0].enter = false;
                u[0].handb = false;
                recordtime = -7;
            } else {
                xtgraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, recordtime, checkpoints.stage);
                if (recordtime == 0 || recordtime == 1 || recordtime == 2) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 800, 450);
                }
                if (record.wasted != xtgraphics.im) {
                    if (record.closefinish == 0) {
                        if (clicknowtime == 9 || clicknowtime == 11) {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 800, 450);
                        }
                        if (clicknowtime == 0) {
                            medium.around(stageContos[xtgraphics.im], false);
                        }
                        if (clicknowtime > 0 && clicknowtime < 20) {
                            medium.transaround(stageContos[xtgraphics.im], stageContos[record.wasted], clicknowtime);
                        }
                        if (clicknowtime == 20) {
                            medium.around(stageContos[record.wasted], false);
                        }
                        if (recordtime > record.whenwasted && clicknowtime != 20) {
                            clicknowtime++;
                        }
                        if ((clicknowtime == 0 || clicknowtime == 20) && ++recordtime == 300) {
                            recordtime = 0;
                            clicknowtime = 0;
                            finishrecording++;
                        }
                    } else if (record.closefinish == 1) {
                        if (clicknowtime == 0) {
                            medium.around(stageContos[xtgraphics.im], false);
                        }
                        if (clicknowtime > 0 && clicknowtime < 20) {
                            medium.transaround(stageContos[xtgraphics.im], stageContos[record.wasted], clicknowtime);
                        }
                        if (clicknowtime == 20) {
                            medium.around(stageContos[record.wasted], false);
                        }
                        if (clicknowtime > 20 && clicknowtime < 40) {
                            medium.transaround(stageContos[record.wasted], stageContos[xtgraphics.im], clicknowtime - 20);
                        }
                        if (clicknowtime == 40) {
                            medium.around(stageContos[xtgraphics.im], false);
                        }
                        if (clicknowtime > 40 && clicknowtime < 60) {
                            medium.transaround(stageContos[xtgraphics.im], stageContos[record.wasted], clicknowtime - 40);
                        }
                        if (clicknowtime == 60) {
                            medium.around(stageContos[record.wasted], false);
                        }
                        if (recordtime > 160 && clicknowtime < 20) {
                            clicknowtime++;
                        }
                        if (recordtime > 230 && clicknowtime < 40) {
                            clicknowtime++;
                        }
                        if (recordtime > 280 && clicknowtime < 60) {
                            clicknowtime++;
                        }
                        if ((clicknowtime == 0 || clicknowtime == 20 || clicknowtime == 40 || clicknowtime == 60) && ++recordtime == 300) {
                            recordtime = 0;
                            clicknowtime = 0;
                            finishrecording++;
                        }
                    } else {
                        if (clicknowtime == 0) {
                            medium.around(stageContos[xtgraphics.im], false);
                        }
                        if (clicknowtime > 0 && clicknowtime < 20) {
                            medium.transaround(stageContos[xtgraphics.im], stageContos[record.wasted], clicknowtime);
                        }
                        if (clicknowtime == 20) {
                            medium.around(stageContos[record.wasted], false);
                        }
                        if (clicknowtime > 20 && clicknowtime < 40) {
                            medium.transaround(stageContos[record.wasted], stageContos[xtgraphics.im], clicknowtime - 20);
                        }
                        if (clicknowtime == 40) {
                            medium.around(stageContos[xtgraphics.im], false);
                        }
                        if (clicknowtime > 40 && clicknowtime < 60) {
                            medium.transaround(stageContos[xtgraphics.im], stageContos[record.wasted], clicknowtime - 40);
                        }
                        if (clicknowtime == 60) {
                            medium.around(stageContos[record.wasted], false);
                        }
                        if (clicknowtime > 60 && clicknowtime < 80) {
                            medium.transaround(stageContos[record.wasted], stageContos[xtgraphics.im], clicknowtime - 60);
                        }
                        if (clicknowtime == 80) {
                            medium.around(stageContos[xtgraphics.im], false);
                        }
                        if (recordtime > 90 && clicknowtime < 20) {
                            clicknowtime++;
                        }
                        if (recordtime > 160 && clicknowtime < 40) {
                            clicknowtime++;
                        }
                        if (recordtime > 230 && clicknowtime < 60) {
                            clicknowtime++;
                        }
                        if (recordtime > 280 && clicknowtime < 80) {
                            clicknowtime++;
                        }
                        if ((clicknowtime == 0 || clicknowtime == 20 || clicknowtime == 40 || clicknowtime == 60 || clicknowtime == 80) && ++recordtime == 300) {
                            recordtime = 0;
                            clicknowtime = 0;
                            finishrecording++;
                        }
                    }
                } else {
                    if (wastedpoint == 67 && (clicknowtime == 3 || clicknowtime == 31 || clicknowtime == 66)) {
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                    }
                    if (wastedpoint == 69 && (clicknowtime == 3 || clicknowtime == 5 || clicknowtime == 31 || clicknowtime == 33 || clicknowtime == 66 || clicknowtime == 68)) {
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                    }
                    if (wastedpoint == 30 && clicknowtime >= 1 && clicknowtime < 30)
                        if (clicknowtime % (int) (2.0F + medium.random() * 3.0F) == 0 && !flashingscreen) {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 800, 450);
                            flashingscreen = true;
                        } else {
                            flashingscreen = false;
                        }
                    if (recordtime > record.whenwasted && clicknowtime != wastedpoint) {
                        clicknowtime++;
                    }
                    medium.around(stageContos[xtgraphics.im], false);
                    if ((clicknowtime == 0 || clicknowtime == wastedpoint) && ++recordtime == 300) {
                        recordtime = 0;
                        clicknowtime = 0;
                        finishrecording++;
                    }
                }
            }
        }
        if (xtgraphics.fase == -4) {
            if (recordtime == 0) {
                xtgraphics.sendwin(checkpoints);
                if (xtgraphics.winner && xtgraphics.multion == 0 && xtgraphics.gmode != 0
                        && checkpoints.stage != xtGraphics.nTracks && checkpoints.stage == xtgraphics.unlocked) {
                    xtgraphics.unlocked++;
                    setcarcookie(xtgraphics.sc[0], cardefine.names[xtgraphics.sc[0]], xtgraphics.arnp, xtgraphics.gmode, xtgraphics.unlocked, false);
                    xtgraphics.unlocked--;
                }
            }
            if (recordtime <= 0) {
                rd.drawImage(xtgraphics.mdness, 289, 30, null);
                rd.drawImage(xtgraphics.dude[0], 135, 10, null);
            }
            if (recordtime >= 0) {
                xtgraphics.fleximage(offImage, recordtime, checkpoints.stage);
            }
            if (++recordtime == 7) {
                xtgraphics.fase = -5;
                rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }
        }
        if (xtgraphics.fase == -6) {
            //repaint();
            xtgraphics.pauseimage(offImage);
            xtgraphics.fase = -7;
            mouses = 0;
        }
        if (xtgraphics.fase == -7) {
            xtgraphics.pausedgame(checkpoints.stage, u[0], record);
            if (recordtime != 0) {
                recordtime = 0;
            }
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2) {
                mouses = 0;
            }
            if (mouses == 1) {
                mouses = 2;
            }
        }
        if (xtgraphics.fase == -8) {
            xtgraphics.cantreply();
            if (++recordtime == 150 || u[0].enter || u[0].handb || mouses == 1) {
                xtgraphics.fase = -7;
                mouses = 0;
                u[0].enter = false;
                u[0].handb = false;
            }
        }
        if (lostfcs && xtgraphics.fase == 7001)
            if (fcscnt == 0) {
                if (u[0].chatup == 0) {
                    requestFocus();
                }
                fcscnt = 10;
            } else {
                fcscnt--;
            }
        //repaint();
        if (xtgraphics.im > -1 && xtgraphics.im < 8) {
            int j = 0;
            if (xtgraphics.multion == 2 || xtgraphics.multion == 3) {
                j = xtgraphics.im;
                u[j].mutem = u[0].mutem;
                u[j].mutes = u[0].mutes;
            }
            xtgraphics.playsounds(mads[xtgraphics.im], u[j], checkpoints.stage);
        }
        date = new Date();
        final long l = date.getTime();
        if (xtgraphics.fase == 0 || xtgraphics.fase == -1 || xtgraphics.fase == -3 || xtgraphics.fase == 7001) {
            if (!bool3) {
                f2 = f;
                if (f2 < 30.0F) {
                    f2 = 30.0F;
                }
                bool3 = true;
                i5 = 0;
            }
            if (i5 == 10) {
                float f = (i4 + udpmistro.freg - (l - l1)) / 20.0F;
                if (f > 40.0F) {
                    f = 40.0F;
                }
                if (f < -40.0F) {
                    f = -40.0F;
                }
                f2 += f;
                if (f2 < 5.0F) {
                    f2 = 5.0F;
                }
                medium.adjstfade(f2, f, xtgraphics.starcnt, this);
                l1 = l;
                i5 = 0;
            } else {
                i5++;
            }
        } else {
            if (bool3) {
                f = f2;
                bool3 = false;
                i5 = 0;
            }
            if (i5 == 10) {
                if (l - l1 < 400L) {
                    f2 += 3.5;
                } else {
                    f2 -= 3.5;
                    if (f2 < 5.0F) {
                        f2 = 5.0F;
                    }
                }
                l1 = l;
                i5 = 0;
            } else {
                i5++;
            }
        }
        if (exwist) {
            trash();
        }

    }

    void setcarcookie(final int i, final String string, final float[] fs, final int gamemode, final int is, final boolean bool) {
        try {
            final File file = new File("" + Madness.fpath + "data/user.data");
            final String[] lines = {
                    "", "", "", "", ""
            };
            if (file.exists()) {
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String line;
                for (int j = 0; (line = bufferedreader.readLine()) != null && j < 5; j++) {
                    lines[j] = line;
                }
                bufferedreader.close();
            }
            if (gamemode == 0) {
                lines[1] = "lastcar(" + i + "," + (int) (fs[0] * 100.0F) + "," + (int) (fs[1] * 100.0F) + ","
                        + (int) (fs[2] * 100.0F) + "," + (int) (fs[3] * 100.0F) + "," + (int) (fs[4] * 100.0F) + ","
                        + (int) (fs[5] * 100.0F) + "," + string + ")";
            }
            if (gamemode == 1 || gamemode == 2) {
                lines[2] = "saved(" + i + "," + is + ")";
            }
            //if (i191 == 2)
            //	strings[3] = "" + ("NFM2(") + (i) + (")")
            //			;
            lines[4] = "graphics(" + moto + "," + Madness.anti + ")";
            final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            for (int j = 0; j < 5; j++) {
                bufferedwriter.write(lines[j]);
                bufferedwriter.newLine();
            }
            bufferedwriter.close();
        } catch (final Exception exception) {

        }
    }

    void setloggedcookie() {
        try {
            final File file = new File("" + Madness.fpath + "data/user.data");
            final String[] lines = {
                    "", "", "", "", ""
            };
            if (file.exists()) {
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String line;
                for (int i = 0; (line = bufferedreader.readLine()) != null && i < 5; i++) {
                    lines[i] = line;
                }
                bufferedreader.close();
            }
            if (keplo.getState()) {
                lines[0] = "lastuser(" + tnick.getText() + "," + tpass.getText() + ")";
            } else {
                lines[0] = "lastuser(" + tnick.getText() + ")";
            }
            final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < 5; i++) {
                bufferedwriter.write(lines[i]);
                bufferedwriter.newLine();
            }
            bufferedwriter.close();
        } catch (final Exception exception) {

        }
    }

    private void setupini() {
        Madness.inisetup = true;
        try {
            final File file = new File("" + Madness.fpath + "Madness.ini");
            if (file.exists()) {
                final String[] liness = new String[40];
                int i = 0;
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String line;
                for (; (line = bufferedreader.readLine()) != null && i < 40; i++) {
                    liness[i] = line;
                    if (liness[i].startsWith("Class Path"))
                        if (liness[i].indexOf("madapps.jar") != -1) {
                            liness[i] = "Class Path=\\data\\madapps.jar;";
                        } else {
                            liness[i] = "Class Path=\\data\\madapp.jar;";
                        }
                    if (liness[i].startsWith("JRE Path")) {
                        liness[i] = "JRE Path=data\\jre\\";
                    }
                }
                bufferedreader.close();
                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                for (int j = 0; j < i; j++) {
                    bufferedwriter.write(liness[j]);
                    bufferedwriter.newLine();
                }
                bufferedwriter.close();
            }
        } catch (final Exception exception) {

        }
        Madness.inisetup = false;
    }

    private void sizescreen(final int x, final int y) {
        if (x > getWidth() / 2 - 230 && x < getWidth() / 2 - 68 && y > 21 && y < 39 || onbar) {
            reqmult = (x - (getWidth() / 2 - 222)) / 141.0F;
            if (reqmult < 0.1) {
                reqmult = 0.0F;
            }
            if (reqmult > 1.0F) {
                reqmult = 1.0F;
            }
            onbar = true;
            showsize = 100;
        }
    }

    /*-@Override
    public void start() {
    	if (gamer == null)
    		gamer = new Thread(this);
    	gamer.start();
    }

    @Override
    public void stop() {
    	if (exwist && gamer != null) {
    		System.gc();
    		gamer.interrupt();
    		gamer = null;
    	}
    	exwist = true;
    }*/

    /*@Override
    public void update(final Graphics graphics) {
    	paint(graphics);
    }*/

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (!exwist) {
            //115 114 99
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                u[0].up = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                u[0].down = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                u[0].right = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                u[0].left = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                u[0].handb = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                u[0].enter = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_Z) {
                u[0].lookback = -1;
            }
            if (e.getKeyCode() == KeyEvent.VK_X) {
                u[0].lookback = 1;
            }
            if (e.getKeyCode() == KeyEvent.VK_M)
                if (u[0].mutem) {
                    u[0].mutem = false;
                } else {
                    u[0].mutem = true;
                }
            if (e.getKeyCode() == KeyEvent.VK_N)
                if (u[0].mutes) {
                    u[0].mutes = false;
                } else {
                    u[0].mutes = true;
                }
            if (e.getKeyCode() == KeyEvent.VK_A)
                if (u[0].arrace) {
                    u[0].arrace = false;
                } else {
                    u[0].arrace = true;
                }
            if (e.getKeyCode() == KeyEvent.VK_S)
                if (u[0].radar) {
                    u[0].radar = false;
                } else {
                    u[0].radar = true;
                }
            if (e.getKeyCode() == KeyEvent.VK_V) {
                view++;
                if (view == 3) {
                    view = 0;
                }
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        if (!exwist) {
            if (u[0].multion < 2) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    u[0].up = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    u[0].down = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    u[0].right = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    u[0].left = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    u[0].handb = false;
                }
            }
            if (e.getKeyCode() == 27) {
                u[0].exit = false;
                if (Madness.fullscreen) {
                    Madness.exitfullscreen();
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_X || e.getKeyCode() == KeyEvent.VK_Z) {
                u[0].lookback = 0;
            }
        }
    }

    @Override
    public void mouseDragged(final MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        if (!exwist && !lostfcs) {
            xm = (int) ((x - apx) / apmult);
            ym = (int) ((y - apy) / apmult);
        }
        if (!Madness.fullscreen) {
            sizescreen(x, y);
        }
    }

    @Override
    public void mouseMoved(final MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        if (!exwist && !lostfcs) {
            xm = (int) ((x - apx) / apmult);
            ym = (int) ((y - apy) / apmult);
        }
        if (!Madness.fullscreen) {
            if (showsize < 20) {
                showsize = 20;
            }
            if (x > 50 && x < 192 && y > 14 && y < 37) {
                if (!oncarm) {
                    oncarm = true;
                    setCursor(new Cursor(12));
                }
            } else if (oncarm) {
                oncarm = false;
                setCursor(new Cursor(0));
            }
            if (x > getWidth() - 208 && x < getWidth() - 50 && y > 14 && y < 37) {
                if (!onstgm) {
                    onstgm = true;
                    setCursor(new Cursor(12));
                }
            } else if (onstgm) {
                onstgm = false;
                setCursor(new Cursor(0));
            }
            if (x > getWidth() / 2 + 22 && x < getWidth() / 2 + 122 && y > 14 && y < 37) {
                if (!onfulls) {
                    onfulls = true;
                    setCursor(new Cursor(12));
                }
            } else if (onfulls) {
                onfulls = false;
                setCursor(new Cursor(0));
            }
        }
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        requestFocus();
        if (!exwist) {
            if (mouses == 0) {
                xm = (int) ((x - apx) / apmult);
                ym = (int) ((y - apy) / apmult);
                mouses = 1;
            }
            moused = true;
        }
        if (!Madness.fullscreen) {
            sizescreen(x, y);
        }
    }

    @Override
    public void mouseReleased(final MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        if (!exwist) {
            if (mouses == 11) {
                xm = (int) ((x - apx) / apmult);
                ym = (int) ((y - apy) / apmult);
                mouses = -1;
            }
            moused = false;
        }
        if (!Madness.fullscreen) {
            if (x > getWidth() / 2 - 55 && x < getWidth() / 2 + 7 && y > 21 && y < 38 && !onbar) {
                if (smooth == 1) {
                    smooth = 0;
                } else {
                    smooth = 1;
                }
                showsize = 60;
            }
            if (x > getWidth() / 2 + 133 && x < getWidth() / 2 + 231 && y > 7 && y < 24 && !onbar) {
                if (Madness.anti == 0) {
                    Madness.anti = 1;
                } else {
                    Madness.anti = 0;
                }
                showsize = 60;
            }
            if (x > getWidth() / 2 + 133 && x < getWidth() / 2 + 231 && y > 24 && y < 41 && !onbar) {
                if (moto == 0) {
                    moto = 1;
                } else {
                    moto = 0;
                }
                showsize = 60;
            }
            if (onfulls) {
                Madness.gofullscreen();
            }
            if (oncarm) {
                Madness.carmaker();
            }
            if (onstgm) {
                Madness.stagemaker();
            }
            onbar = false;
        }
    }

    @Override
    public void mouseEntered(final MouseEvent e) {
    }

    @Override
    public void mouseExited(final MouseEvent e) {
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        repaint();
    }

    @Override
    public void focusGained(final FocusEvent e) {
        if (!exwist && lostfcs) {
            lostfcs = false;
        }
    }

    @Override
    public void focusLost(final FocusEvent e) {
        if (!exwist && !lostfcs) {
            lostfcs = true;
            fcscnt = 10;
            if (u[0] != null) {
                if (u[0].multion == 0) {
                    u[0].falseo(1);
                } else if (u[0].chatup == 0) {
                    requestFocus();
                }
                setCursor(new Cursor(0));
            }
        }
    }

}
