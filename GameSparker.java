
/* GameSparker - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.AlphaComposite;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Event;
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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

class GameSparker extends JPanel implements KeyListener, MouseListener, MouseMotionListener, ActionListener, FocusListener {
    /**
     *
     */
    private static final long serialVersionUID = -5976860556958716653L;
    private float apmult = 1.0F;
    boolean applejava = false;
    private int apx = 0;
    private int apy = 0;
    private Image blb;
    private Image[] carmaker = new Image[2];
    private Image[] chkbx = new Image[2];
    private Smenu clanlev = new Smenu(8);
    private Smenu clcars = new Smenu(707);
    TextField cmsg;
    private Smenu datat = new Smenu(26);
    private boolean exwist = false;
    private int fcscnt = 0;
    private Image fulls;
    Smenu gmode = new Smenu(3);
    private Smenu icars = new Smenu(5);
    private Smenu ilaps = new Smenu(18);
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
    private Smenu proitem = new Smenu(707);
    Graphics2D rd;
    private float reqmult = 0.0F;
    Smenu rooms = new Smenu(7);
    Smenu scars = new Smenu(4);
    Smenu sclass = new Smenu(7);
    private Smenu senditem = new Smenu(707);
    private Smenu sendtyp = new Smenu(6);
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
    private Image[] stagemaker = new Image[2];
    Smenu swait = new Smenu(6);
    TextField temail;
    TextField tnick;
    TextField tpass;
    private Control[] u = new Control[8];
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
                if (mouses == 2)
                    openurl("http://www.radicalplay.com/");
            } else
                setCursor(new Cursor(0));
    }

    private void checkmemory(final xtGraphics xtgraphics) {
        if (applejava || Runtime.getRuntime().freeMemory() / 1048576L < 50L)
            xtgraphics.badmac = true;
    }

    private void cropit(final Graphics2D graphics2d, final int i, final int i98) {
        if (i != 0 || i98 != 0) {
            graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
            graphics2d.setColor(new Color(0, 0, 0));
        }
        if (i != 0)
            if (i < 0)
                graphics2d.fillRect(apx + i, apy - (int) (25.0F * apmult), Math.abs(i), (int) (500.0F * apmult));
            else
                graphics2d.fillRect(apx + (int) (800.0F * apmult), apy - (int) (25.0F * apmult), i,
                        (int) (500.0F * apmult));
        if (i98 != 0)
            if (i98 < 0)
                graphics2d.fillRect(apx - (int) (25.0F * apmult), apy + i98, (int) (850.0F * apmult), Math.abs(i98));
            else
                graphics2d.fillRect(apx - (int) (25.0F * apmult), apy + (int) (450.0F * apmult),
                        (int) (850.0F * apmult), i98);
    }

    void drawms() {
        openm = false;
        if (gmode.draw(rd, xm, ym, moused, 450, true))
            openm = true;
        if (swait.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (slaps.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (snpls.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (snbts.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (scars.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (sgame.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        //if (snfm1.draw(rd, xm, ym, moused, 450, false))
        //	openm = true;
        //if (snfm2.draw(rd, xm, ym, moused, 450, false))
        //	openm = true;
        if (snfmm.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (mstgs.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (mcars.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (pgame.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (vnpls.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (vtyp.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (warb.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (wgame.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (rooms.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (sendtyp.draw(rd, xm, ym, moused, 450, true))
            openm = true;
        if (senditem.draw(rd, xm, ym, moused, 450, true))
            openm = true;
        if (datat.draw(rd, xm, ym, moused, 450, true))
            openm = true;
        if (clanlev.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (clcars.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (ilaps.draw(rd, xm, ym, moused, 450, true))
            openm = true;
        if (icars.draw(rd, xm, ym, moused, 450, true))
            openm = true;
        if (proitem.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (sfix.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (sclass.draw(rd, xm, ym, moused, 450, false))
            openm = true;
    }

    void editlink(final String string, final boolean bool) {
        String string208 = "";
        if (bool)
            string208 = "?display=upgrade";
        openurl(new StringBuilder().append("http://multiplayer.needformadness.com/edit.pl").append(string208)
                .append("#").append(string).append("").toString());
    }

    private int getint(final String string, final String string181, final int i) {
        int i182 = 0;
        String string183 = "";
        for (int i184 = string.length() + 1; i184 < string181.length(); i184++) {
            final String string185 = new StringBuilder().append("").append(string181.charAt(i184)).toString();
            if (string185.equals(",") || string185.equals(")")) {
                i182++;
                i184++;
            }
            if (i182 == i)
                string183 = new StringBuilder().append(string183).append(string181.charAt(i184)).toString();
        }
        return Integer.valueOf(string183).intValue();
    }

    private String getstring(final String string, final String string186, final int i) {
        int i187 = 0;
        String string188 = "";
        for (int i189 = string.length() + 1; i189 < string186.length(); i189++) {
            final String string190 = new StringBuilder().append("").append(string186.charAt(i189)).toString();
            if (string190.equals(",") || string190.equals(")")) {
                i187++;
                i189++;
            }
            if (i187 == i)
                string188 = new StringBuilder().append(string188).append(string186.charAt(i189)).toString();
        }
        return string188;
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
        if (System.getProperty("java.vendor").toLowerCase().indexOf("oracle") != -1)
            cmsg.addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(final KeyEvent arg0) {
                    if (arg0.getKeyCode() == 10 && u[0] != null)
                        u[0].enter = true;
                }

                @Override
                public void keyReleased(final KeyEvent arg0) {
                }

                @Override
                public void keyTyped(final KeyEvent arg0) {
                }
            });
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
     * List of car .rad files.<br/>
     * <strong>ALL CAR MODELS IN THE ZIP FILE SHOULD BE PUT HERE OR THINGS WILL GO WRONG!</strong><br/>
     * (Additional info: when a .rad file is found and it has no index here or in stageRads it will be assigned to index 0 - Tornado Shark)<br/>
     */
    private final String[] carRads = {
            "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter",
            "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster"
    };
    /**
     * List of track part .rad files.<br/>
     * <strong>ALL NON-CAR MODELS IN THE ZIP FILE SHOULD BE PUT HERE OR THINGS WILL GO WRONG!</strong><br/>
     * (Additional info: when a .rad file is found and it has no index here or in carRads it will be assigned to index 0 - Tornado Shark)<br/>
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

    private void loadbase(final ContO[] contos, final Medium medium, final Trackers trackers,
            final xtGraphics xtgraphics, final boolean bool) {
        if (carRads.length < xtGraphics.nCars)
            throw new RuntimeException("too many cars and not enough rad files!");
        int i = 0;
        xtgraphics.dnload += 6;
        try {
            ZipInputStream zipinputstream;
            if (!bool) {
                final File file = new File(
                        new StringBuilder().append("").append(Madness.fpath).append("data/models.zip").toString());
                zipinputstream = new ZipInputStream(new FileInputStream(file));
            } else {
                final URL url = new URL("http://multiplayer.needformadness.com/data/models.zip");
                zipinputstream = new ZipInputStream(url.openStream());
            }
            ZipEntry zipentry = zipinputstream.getNextEntry();
            for (; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i175 = 0;
                for (int i176 = 0; i176 < carRads.length; i176++)
                    if (zipentry.getName().startsWith(carRads[i176]))
                        i175 = i176;
                for (int i177 = 0; i177 < stageRads.length; i177++)
                    if (zipentry.getName().startsWith(stageRads[i177]))
                        i175 = i177 + partskips;
                int i178 = (int) zipentry.getSize();
                i += i178;
                final byte[] is = new byte[i178];
                int i179 = 0;
                int i180;
                for (; i178 > 0; i178 -= i180) {
                    i180 = zipinputstream.read(is, i179, i178);
                    i179 += i180;
                }
                contos[i175] = new ContO(is, medium, trackers);
                xtgraphics.dnload++;
            }
            zipinputstream.close();
        } catch (final Exception exception) {
            System.out.println(new StringBuilder().append("Error Reading Models: ").append(exception).toString());
        }
        System.gc();
        if (mload != -1 && i != 615671)
            mload = 2;
    }

    private void loadstage(final ContO[] contos, final ContO[] contos108, final Medium medium, final Trackers trackers,
            final CheckPoints checkpoints, final xtGraphics xtgraphics, final Mad[] mads, final Record record) {
        if (xtgraphics.testdrive == 2 || xtgraphics.testdrive == 4)
            xtgraphics.nplayers = 1;
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
        int i109 = 100;
        int i110 = 0;
        int i111 = 100;
        xtgraphics.newparts = false;
        String string = "";
        try {
            BufferedReader stageDataReader;
            if (xtgraphics.multion == 0 && checkpoints.stage != -2) {
                String customStagePath = new StringBuilder().append("stages/").append(checkpoints.stage).append("")
                        .toString();
                if (checkpoints.stage == -1)
                    customStagePath = new StringBuilder().append("mystages/").append(checkpoints.name).append("")
                            .toString();
                final File customStageFile = new File(new StringBuilder().append("").append(Madness.fpath).append("")
                        .append(customStagePath).append(".txt").toString());
                stageDataReader = new BufferedReader(
                        new InputStreamReader(new DataInputStream(new FileInputStream(customStageFile))));
            } else if (checkpoints.stage > 0) {
                final URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/stages/")
                        .append(checkpoints.stage).append(".txt").toString());
                stageDataReader = new BufferedReader(new InputStreamReader(new DataInputStream(url.openStream())));
            } else {
                String string113 = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/")
                        .append(checkpoints.name).append(".radq").toString();
                string113 = string113.replace(' ', '_');
                final URL url = new URL(string113);
                final int i114 = url.openConnection().getContentLength();
                final DataInputStream datainputstream115 = new DataInputStream(url.openStream());
                final byte[] is = new byte[i114];
                datainputstream115.readFully(is);
                ZipInputStream zipinputstream;
                if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                else {
                    final byte[] is116 = new byte[i114 - 40];
                    for (int i117 = 0; i117 < i114 - 40; i117++) {
                        int i118 = 20;
                        if (i117 >= 500)
                            i118 = 40;
                        is116[i117] = is[i117 + i118];
                    }
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is116));
                }
                final ZipEntry zipentry = zipinputstream.getNextEntry();
                int i119 = Integer.valueOf(zipentry.getName()).intValue();
                final byte[] is120 = new byte[i119];
                int i121 = 0;
                int i122;
                for (; i119 > 0; i119 -= i122) {
                    i122 = zipinputstream.read(is120, i121, i119);
                    i121 += i122;
                }
                zipinputstream.close();
                datainputstream115.close();
                stageDataReader = new BufferedReader(
                        new InputStreamReader(new DataInputStream(new ByteArrayInputStream(is120))));
            }
            String string123;
            while ((string123 = stageDataReader.readLine()) != null) {
                string = new StringBuilder().append("").append(string123.trim()).toString();
                if (string.startsWith("snap"))
                    medium.setsnap(getint("snap", string, 0), getint("snap", string, 1), getint("snap", string, 2));
                if (string.startsWith("sky")) {
                    medium.setsky(getint("sky", string, 0), getint("sky", string, 1), getint("sky", string, 2));
                    xtgraphics.snap(checkpoints.stage);
                }
                if (string.startsWith("ground"))
                    medium.setgrnd(getint("ground", string, 0), getint("ground", string, 1),
                            getint("ground", string, 2));
                if (string.startsWith("polys"))
                    medium.setpolys(getint("polys", string, 0), getint("polys", string, 1), getint("polys", string, 2));
                if (string.startsWith("fog"))
                    medium.setfade(getint("fog", string, 0), getint("fog", string, 1), getint("fog", string, 2));
                if (string.startsWith("texture"))
                    medium.setexture(getint("texture", string, 0), getint("texture", string, 1),
                            getint("texture", string, 2), getint("texture", string, 3));
                if (string.startsWith("clouds"))
                    medium.setcloads(getint("clouds", string, 0), getint("clouds", string, 1),
                            getint("clouds", string, 2), getint("clouds", string, 3), getint("clouds", string, 4));
                if (string.startsWith("density")) {
                    medium.fogd = (getint("density", string, 0) + 1) * 2 - 1;
                    if (medium.fogd < 1)
                        medium.fogd = 1;
                    if (medium.fogd > 30)
                        medium.fogd = 30;
                }
                if (string.startsWith("fadefrom"))
                    medium.fadfrom(getint("fadefrom", string, 0));
                if (string.startsWith("lightson"))
                    medium.lightson = true;
                if (string.startsWith("mountains"))
                    medium.mgen = getint("mountains", string, 0);
                if (string.startsWith("set")) {
                    int i124 = getint("set", string, 0);
                    if (xtgraphics.nplayers == 8) {
                        if (i124 == 47)
                            i124 = 76;
                        if (i124 == 48)
                            i124 = 77;
                    }
                    boolean bool = true;
                    if (i124 >= 65 && i124 <= 75 && checkpoints.notb)
                        bool = false;
                    if (bool) {
                        if (i124 == 49 || i124 == 64 || i124 >= 56 && i124 <= 61)
                            xtgraphics.newparts = true;
                        if ((checkpoints.stage < 0 || checkpoints.stage >= 28) && i124 >= 10 && i124 <= 25)
                            medium.loadnew = true;
                        i124 += partskips - 10;
                        contos[nob] = new ContO(contos108[i124], getint("set", string, 1),
                                medium.ground - contos108[i124].grat, getint("set", string, 2),
                                getint("set", string, 3));
                        if (string.indexOf(")p") != -1) {
                            checkpoints.x[checkpoints.n] = getint("set", string, 1);
                            checkpoints.z[checkpoints.n] = getint("set", string, 2);
                            checkpoints.y[checkpoints.n] = 0;
                            checkpoints.typ[checkpoints.n] = 0;
                            if (string.indexOf(")pt") != -1)
                                checkpoints.typ[checkpoints.n] = -1;
                            if (string.indexOf(")pr") != -1)
                                checkpoints.typ[checkpoints.n] = -2;
                            if (string.indexOf(")po") != -1)
                                checkpoints.typ[checkpoints.n] = -3;
                            if (string.indexOf(")ph") != -1)
                                checkpoints.typ[checkpoints.n] = -4;
                            if (string.indexOf("out") != -1)
                                System.out
                                        .println(new StringBuilder().append("out: ").append(checkpoints.n).toString());
                            checkpoints.n++;
                            notb = nob + 1;
                        }
                        nob++;
                        if (medium.loadnew)
                            medium.loadnew = false;
                    }
                }
                if (string.startsWith("chk")) {
                    int i125 = getint("chk", string, 0);
                    i125 += partskips - 10;
                    int i126 = medium.ground - contos108[i125].grat;
                    if (i125 == 110)
                        i126 = getint("chk", string, 4);
                    contos[nob] = new ContO(contos108[i125], getint("chk", string, 1), i126, getint("chk", string, 2),
                            getint("chk", string, 3));
                    checkpoints.x[checkpoints.n] = getint("chk", string, 1);
                    checkpoints.z[checkpoints.n] = getint("chk", string, 2);
                    checkpoints.y[checkpoints.n] = i126;
                    if (getint("chk", string, 3) == 0)
                        checkpoints.typ[checkpoints.n] = 1;
                    else
                        checkpoints.typ[checkpoints.n] = 2;
                    checkpoints.pcs = checkpoints.n;
                    checkpoints.n++;
                    contos[nob].checkpoint = checkpoints.nsp + 1;
                    checkpoints.nsp++;
                    nob++;
                    notb = nob;
                }
                if (checkpoints.nfix != 5 && string.startsWith("fix")) {
                    int i127 = getint("fix", string, 0);
                    i127 += partskips - 10;
                    contos[nob] = new ContO(contos108[i127], getint("fix", string, 1), getint("fix", string, 3),
                            getint("fix", string, 2), getint("fix", string, 4));
                    checkpoints.fx[checkpoints.fn] = getint("fix", string, 1);
                    checkpoints.fz[checkpoints.fn] = getint("fix", string, 2);
                    checkpoints.fy[checkpoints.fn] = getint("fix", string, 3);
                    contos[nob].elec = true;
                    if (getint("fix", string, 4) != 0) {
                        checkpoints.roted[checkpoints.fn] = true;
                        contos[nob].roted = true;
                    } else
                        checkpoints.roted[checkpoints.fn] = false;
                    if (string.indexOf(")s") != -1)
                        checkpoints.special[checkpoints.fn] = true;
                    else
                        checkpoints.special[checkpoints.fn] = false;
                    checkpoints.fn++;
                    nob++;
                    notb = nob;
                }
                if (!checkpoints.notb && string.startsWith("pile")) {
                    contos[nob] = new ContO(getint("pile", string, 0), getint("pile", string, 1),
                            getint("pile", string, 2), medium, trackers, getint("pile", string, 3),
                            getint("pile", string, 4), medium.ground);
                    nob++;
                }
                if (xtgraphics.multion == 0 && string.startsWith("nlaps"))
                    checkpoints.nlaps = getint("nlaps", string, 0);
                //if (checkpoints.nlaps < 1)
                //	checkpoints.nlaps = 1;
                //if (checkpoints.nlaps > 15)
                //	checkpoints.nlaps = 15;
                if (checkpoints.stage > 0 && string.startsWith("name"))
                    checkpoints.name = getstring("name", string, 0).replace('|', ',');
                if (string.startsWith("stagemaker"))
                    checkpoints.maker = getstring("stagemaker", string, 0);
                if (string.startsWith("publish"))
                    checkpoints.pubt = getint("publish", string, 0);
                if (string.startsWith("soundtrack")) {
                    checkpoints.trackname = getstring("soundtrack", string, 0);
                    checkpoints.trackvol = getint("soundtrack", string, 1);
                    if (checkpoints.trackvol < 50)
                        checkpoints.trackvol = 50;
                    if (checkpoints.trackvol > 300)
                        checkpoints.trackvol = 300;
                    xtgraphics.sndsize[32] = getint("soundtrack", string, 2);
                }
                if (string.startsWith("maxr")) {
                    final int i128 = getint("maxr", string, 0);
                    final int i129 = getint("maxr", string, 1);
                    i = i129;
                    final int i130 = getint("maxr", string, 2);
                    for (int i131 = 0; i131 < i128; i131++) {
                        contos[nob] = new ContO(contos108[29 + partskips], i129,
                                medium.ground - contos108[29 + partskips].grat, //29 may need to be 85 or xtgraphics.nCars - 16
                                i131 * 4800 + i130, 0);
                        nob++;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = i129 + 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = i128 * 4800 / 2 + i130 - 2400;
                    trackers.radz[trackers.nt] = i128 * 4800 / 2;
                    trackers.xy[trackers.nt] = 90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 167;
                    trackers.decor[trackers.nt] = false;
                    trackers.skd[trackers.nt] = 0;
                    trackers.nt++;
                }
                if (string.startsWith("maxl")) {
                    final int i132 = getint("maxl", string, 0);
                    final int i133 = getint("maxl", string, 1);
                    i109 = i133;
                    final int i134 = getint("maxl", string, 2);
                    for (int i135 = 0; i135 < i132; i135++) {
                        contos[nob] = new ContO(contos108[29 + partskips], i133,
                                medium.ground - contos108[29 + partskips].grat, i135 * 4800 + i134, 180);
                        nob++;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.x[trackers.nt] = i133 - 500;
                    trackers.radx[trackers.nt] = 600;
                    trackers.z[trackers.nt] = i132 * 4800 / 2 + i134 - 2400;
                    trackers.radz[trackers.nt] = i132 * 4800 / 2;
                    trackers.xy[trackers.nt] = -90;
                    trackers.zy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 167;
                    trackers.decor[trackers.nt] = false;
                    trackers.skd[trackers.nt] = 0;
                    trackers.nt++;
                }
                if (string.startsWith("maxt")) {
                    final int i136 = getint("maxt", string, 0);
                    final int i137 = getint("maxt", string, 1);
                    i110 = i137;
                    final int i138 = getint("maxt", string, 2);
                    for (int i139 = 0; i139 < i136; i139++) {
                        contos[nob] = new ContO(contos108[29 + partskips], i139 * 4800 + i138,
                                medium.ground - contos108[29 + partskips].grat, i137, 90);
                        nob++;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = i137 + 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = i136 * 4800 / 2 + i138 - 2400;
                    trackers.radx[trackers.nt] = i136 * 4800 / 2;
                    trackers.zy[trackers.nt] = 90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 167;
                    trackers.decor[trackers.nt] = false;
                    trackers.skd[trackers.nt] = 0;
                    trackers.nt++;
                }
                if (string.startsWith("maxb")) {
                    final int i140 = getint("maxb", string, 0);
                    final int i141 = getint("maxb", string, 1);
                    i111 = i141;
                    final int i142 = getint("maxb", string, 2);
                    for (int i143 = 0; i143 < i140; i143++) {
                        contos[nob] = new ContO(contos108[29 + partskips], i143 * 4800 + i142,
                                medium.ground - contos108[29 + partskips].grat, i141, -90);
                        nob++;
                    }
                    trackers.y[trackers.nt] = -5000;
                    trackers.rady[trackers.nt] = 7100;
                    trackers.z[trackers.nt] = i141 - 500;
                    trackers.radz[trackers.nt] = 600;
                    trackers.x[trackers.nt] = i140 * 4800 / 2 + i142 - 2400;
                    trackers.radx[trackers.nt] = i140 * 4800 / 2;
                    trackers.zy[trackers.nt] = -90;
                    trackers.xy[trackers.nt] = 0;
                    trackers.dam[trackers.nt] = 167;
                    trackers.decor[trackers.nt] = false;
                    trackers.skd[trackers.nt] = 0;
                    trackers.nt++;
                }
            }
            stageDataReader.close();
            medium.newpolys(i109, i - i109, i111, i110 - i111, trackers, notb);
            medium.newclouds(i109, i, i111, i110);
            medium.newmountains(i109, i, i111, i110);
            medium.newstars();
            trackers.devidetrackers(i109, i - i109, i111, i110 - i111);
        } catch (final Exception exception) {
            checkpoints.stage = -3;
            System.out.println(new StringBuilder().append("Error in stage ").append(checkpoints.stage).toString());
            System.out.println(new StringBuilder().append("").append(exception).toString());
            System.out.println(new StringBuilder().append("At line: ").append(string).toString());
        }
        if (checkpoints.nsp < 2)
            checkpoints.stage = -3;
        if (medium.nrw * medium.ncl >= 16000)
            checkpoints.stage = -3;
        if (checkpoints.stage != -3) {
            checkpoints.top20 = Math.abs(checkpoints.top20);
            if (checkpoints.stage == 26)
                medium.lightn = 0;
            else
                medium.lightn = -1;
            if (checkpoints.stage == 1 || checkpoints.stage == 11)
                medium.nochekflk = false;
            else
                medium.nochekflk = true;
            for (int i144 = 0; i144 < xtgraphics.nplayers; i144++)
                u[i144].reset(checkpoints, xtgraphics.sc[i144]);
            xtgraphics.resetstat(checkpoints.stage);
            checkpoints.calprox();
            for (int i145 = 0; i145 < xtgraphics.nplayers; i145++) {
                if (xtgraphics.fase == 22)
                    xtgraphics.colorCar(contos108[xtgraphics.sc[i145]], i145);
                contos[i145] = new ContO(contos108[xtgraphics.sc[i145]], xtgraphics.xstart[i145],
                        250 - contos108[xtgraphics.sc[i145]].grat, xtgraphics.zstart[i145], 0);
                mads[i145].reseto(xtgraphics.sc[i145], contos[i145], checkpoints);
            }
            if (xtgraphics.fase == 2 || xtgraphics.fase == -22) {
                medium.trx = (i109 + i) / 2;
                medium.trz = (i110 + i111) / 2;
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
                int i146 = checkpoints.stage;
                if (i146 > 27)
                    i146 -= 27;
                else if (i146 > 10)
                    i146 -= 10;
                xtgraphics.asay = new StringBuilder().append("Stage ").append(i146).append(":  ")
                        .append(checkpoints.name).append(" ").toString();
            } else
                xtgraphics.asay = new StringBuilder().append("Custom Stage:  ").append(checkpoints.name).append(" ")
                        .toString();
            record.reset(contos);
        } else if (xtgraphics.fase == 2)
            xtgraphics.fase = 1;
        System.gc();
    }

    private boolean loadstagePreview(final int i, final String string, final ContO[] contos, final ContO[] contos147,
            final Medium medium, final CheckPoints checkpoints) {
        boolean bool = true;
        if (i < 100) {
            checkpoints.stage = i;
            if (checkpoints.stage < 0)
                checkpoints.name = string;
        } else {
            checkpoints.stage = -2;
            if (sgame.getSelectedIndex() == 3 || sgame.getSelectedIndex() == 4)
                checkpoints.name = mstgs.getSelectedItem();
            else {
                final int i148 = mstgs.getSelectedItem().indexOf(" ") + 1;
                if (i148 > 0)
                    checkpoints.name = mstgs.getSelectedItem().substring(i148);
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
                final URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/stages/")
                        .append(checkpoints.stage).append(".txt").toString());
                datainputstream = new DataInputStream(url.openStream());
            } else {
                String string154 = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/")
                        .append(checkpoints.name).append(".radq").toString();
                string154 = string154.replace(' ', '_');
                final URL url = new URL(string154);
                final int i155 = url.openConnection().getContentLength();
                final DataInputStream datainputstream156 = new DataInputStream(url.openStream());
                final byte[] is = new byte[i155];
                datainputstream156.readFully(is);
                ZipInputStream zipinputstream;
                if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                else {
                    final byte[] is157 = new byte[i155 - 40];
                    for (int i158 = 0; i158 < i155 - 40; i158++) {
                        int i159 = 20;
                        if (i158 >= 500)
                            i159 = 40;
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
                string153 = new StringBuilder().append("").append(string164.trim()).toString();
                if (string153.startsWith("snap"))
                    medium.setsnap(getint("snap", string153, 0), getint("snap", string153, 1),
                            getint("snap", string153, 2));
                if (string153.startsWith("sky"))
                    medium.setsky(getint("sky", string153, 0), getint("sky", string153, 1),
                            getint("sky", string153, 2));
                if (string153.startsWith("ground"))
                    medium.setgrnd(getint("ground", string153, 0), getint("ground", string153, 1),
                            getint("ground", string153, 2));
                if (string153.startsWith("polys"))
                    medium.setpolys(getint("polys", string153, 0), getint("polys", string153, 1),
                            getint("polys", string153, 2));
                if (string153.startsWith("fog"))
                    medium.setfade(getint("fog", string153, 0), getint("fog", string153, 1),
                            getint("fog", string153, 2));
                if (string153.startsWith("texture"))
                    medium.setexture(getint("texture", string153, 0), getint("texture", string153, 1),
                            getint("texture", string153, 2), getint("texture", string153, 3));
                if (string153.startsWith("clouds"))
                    medium.setcloads(getint("clouds", string153, 0), getint("clouds", string153, 1),
                            getint("clouds", string153, 2), getint("clouds", string153, 3),
                            getint("clouds", string153, 4));
                if (string153.startsWith("density")) {
                    medium.fogd = (getint("density", string153, 0) + 1) * 2 - 1;
                    if (medium.fogd < 1)
                        medium.fogd = 1;
                    if (medium.fogd > 30)
                        medium.fogd = 30;
                }
                if (string153.startsWith("fadefrom"))
                    medium.fadfrom(getint("fadefrom", string153, 0));
                if (string153.startsWith("lightson"))
                    medium.lightson = true;
                if (string153.startsWith("mountains"))
                    medium.mgen = getint("mountains", string153, 0);
                if (string153.startsWith("soundtrack")) {
                    checkpoints.trackname = getstring("soundtrack", string153, 0);
                    checkpoints.trackvol = getint("soundtrack", string153, 1);
                    if (checkpoints.trackvol < 50)
                        checkpoints.trackvol = 50;
                    if (checkpoints.trackvol > 300)
                        checkpoints.trackvol = 300;
                }
                if (string153.startsWith("set")) {
                    int i165 = getint("set", string153, 0);
                    i165 += partskips - 10;
                    contos[nob] = new ContO(contos147[i165], getint("set", string153, 1),
                            medium.ground - contos147[i165].grat, getint("set", string153, 2),
                            getint("set", string153, 3));
                    contos[nob].t.nt = 0;
                    if (string153.indexOf(")p") != -1) {
                        checkpoints.x[checkpoints.n] = getint("chk", string153, 1);
                        checkpoints.z[checkpoints.n] = getint("chk", string153, 2);
                        checkpoints.y[checkpoints.n] = 0;
                        checkpoints.typ[checkpoints.n] = 0;
                        if (string153.indexOf(")pt") != -1)
                            checkpoints.typ[checkpoints.n] = -1;
                        if (string153.indexOf(")pr") != -1)
                            checkpoints.typ[checkpoints.n] = -2;
                        if (string153.indexOf(")po") != -1)
                            checkpoints.typ[checkpoints.n] = -3;
                        if (string153.indexOf(")ph") != -1)
                            checkpoints.typ[checkpoints.n] = -4;
                        if (string153.indexOf("out") != -1)
                            System.out.println(new StringBuilder().append("out: ").append(checkpoints.n).toString());
                        checkpoints.n++;
                    }
                    nob++;
                }
                if (string153.startsWith("chk")) {
                    int i166 = getint("chk", string153, 0);
                    i166 += partskips - 10;
                    int i167 = medium.ground - contos147[i166].grat;
                    if (i166 == 110)
                        i167 = getint("chk", string153, 4);
                    contos[nob] = new ContO(contos147[i166], getint("chk", string153, 1), i167,
                            getint("chk", string153, 2), getint("chk", string153, 3));
                    checkpoints.x[checkpoints.n] = getint("chk", string153, 1);
                    checkpoints.z[checkpoints.n] = getint("chk", string153, 2);
                    checkpoints.y[checkpoints.n] = i167;
                    if (getint("chk", string153, 3) == 0)
                        checkpoints.typ[checkpoints.n] = 1;
                    else
                        checkpoints.typ[checkpoints.n] = 2;
                    checkpoints.pcs = checkpoints.n;
                    checkpoints.n++;
                    contos[nob].checkpoint = checkpoints.nsp + 1;
                    checkpoints.nsp++;
                    nob++;
                }
                if (string153.startsWith("fix")) {
                    int i168 = getint("fix", string153, 0);
                    i168 += partskips - 10;
                    contos[nob] = new ContO(contos147[i168], getint("fix", string153, 1), getint("fix", string153, 3),
                            getint("fix", string153, 2), getint("fix", string153, 4));
                    checkpoints.fx[checkpoints.fn] = getint("fix", string153, 1);
                    checkpoints.fz[checkpoints.fn] = getint("fix", string153, 2);
                    checkpoints.fy[checkpoints.fn] = getint("fix", string153, 3);
                    contos[nob].elec = true;
                    if (getint("fix", string153, 4) != 0) {
                        checkpoints.roted[checkpoints.fn] = true;
                        contos[nob].roted = true;
                    } else
                        checkpoints.roted[checkpoints.fn] = false;
                    if (string153.indexOf(")s") != -1)
                        checkpoints.special[checkpoints.fn] = true;
                    else
                        checkpoints.special[checkpoints.fn] = false;
                    checkpoints.fn++;
                    nob++;
                }
                if (string153.startsWith("nlaps")) {
                    checkpoints.nlaps = getint("nlaps", string153, 0);
                    if (checkpoints.nlaps < 1)
                        checkpoints.nlaps = 1;
                    if (checkpoints.nlaps > 15)
                        checkpoints.nlaps = 15;
                }
                if (checkpoints.stage > 0 && string153.startsWith("name"))
                    checkpoints.name = getstring("name", string153, 0).replace('|', ',');
                if (string153.startsWith("stagemaker"))
                    checkpoints.maker = getstring("stagemaker", string153, 0);
                if (string153.startsWith("publish"))
                    checkpoints.pubt = getint("publish", string153, 0);
                if (string153.startsWith("maxr"))
                    i149 = getint("maxr", string153, 1);
                //i149 = i169;
                if (string153.startsWith("maxl"))
                    i150 = getint("maxl", string153, 1);
                //i150 = i170;
                if (string153.startsWith("maxt"))
                    i151 = getint("maxt", string153, 1);
                //i151 = i171;
                if (string153.startsWith("maxb"))
                    i152 = getint("maxb", string153, 1);
                //i152 = i172;
            }
            datainputstream.close();
            medium.newpolys(i150, i149 - i150, i152, i151 - i152, null, notb);
            medium.newclouds(i150, i149, i152, i151);
            medium.newmountains(i150, i149, i152, i151);
            medium.newstars();
        } catch (final Exception exception) {
            bool = false;
            System.out.println(new StringBuilder().append("Error in stage ").append(checkpoints.stage).toString());
            System.out.println(new StringBuilder().append("").append(exception).toString());
            System.out.println(new StringBuilder().append("At line: ").append(string153).toString());
        }
        if (checkpoints.nsp < 2)
            bool = false;
        if (medium.nrw * medium.ncl >= 16000)
            bool = false;
        medium.trx = (i150 + i149) / 2;
        medium.trz = (i151 + i152) / 2;
        System.gc();
        return bool;
    }

    void madlink() {
        openurl("http://www.needformadness.com/");
    }

    public void mouseW(final int i) {
        if (!exwist)
            mousew += i * 4;
    }

    void movefield(final Component component, int i, int i99, final int i100, final int i101) {
        if (i100 == 360 || i100 == 576) {
            i = (int) (i * apmult + apx + component.getWidth() / 2 * (apmult - 1.0F));
            i99 = (int) (i99 * apmult + apy + 12.0F * (apmult - 1.0F));
        } else {
            i = (int) (i * apmult + apx);
            i99 = (int) (i99 * apmult + apy + 12.0F * (apmult - 1.0F));
        }
        if (component.getX() != i || component.getY() != i99)
            component.setBounds(i, i99, i100, i101);
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
                if (textarea.getX() != i || textarea.getY() != i105)
                    textarea.setBounds(i, i105, i106, i107);
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
            if (!textarea.isShowing())
                textarea.setVisible(true);
            movefield(textarea, i, i105, i106, i107);
        }
    }

    void movefieldd(final TextField textfield, int i, int i102, final int i103, final int i104,
            final boolean bool) {
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
                    if (textfield.getX() != i || textfield.getY() != i102)
                        textfield.setBounds(i, i102, i103, i104);
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
            if (bool && !textfield.isShowing())
                textfield.setVisible(true);
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
        if (Desktop.isDesktopSupported())
            try {
                Desktop.getDesktop().browse(new URI(string));
            } catch (final Exception exception) {

            }
        else
            try {
                Runtime.getRuntime().exec(new StringBuilder().append("").append(Madness.urlopen()).append(" ")
                        .append(string).append("").toString());
            } catch (final Exception exception) {

            }
    }

    private void trash() {
        rd.dispose();
        xtgraphics.stopallnow();
        //cardefine.stopallnow();
        //udpmistro.UDPquit();
        System.gc();
        if (Madness.endadv == 2)
            Madness.advopen();
        //if (gamer != null)
        //  gamer.interrupt();
        //gamer = null;
    }

    private byte loadpaintick = 50;

    @Override
    public void paintComponent(final Graphics graphics) {
        final Graphics2D graphics2d = (Graphics2D) graphics;
        if (moto == 0 || loadpaintick > 0) { //REQUIRED
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, getWidth(), getHeight());
            if (loadpaintick > 0)
                loadpaintick--;
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
            if (lastw <= 800 || lasth <= 550)
                reqmult = 0.0F;
            if (Madness.fullscreen) {
                apx = (int) (getWidth() / 2 - 400.0F * apmult);
                apy = (int) (getHeight() / 2 - 225.0F * apmult);
            }
        }
        int i = 0;
        int i97 = 0;
        if (moto == 1 && shaka > 0) {
            i = (int) ((shaka * 2 * Math.random() - shaka) * apmult);
            i97 = (int) ((shaka * 2 * Math.random() - shaka) * apmult);
            shaka--;
        }
        if (!Madness.fullscreen) {
            if (showsize != 0) {
                if (showsize == 100 || showsize == 70)
                    graphics2d.clearRect(0, 0, getWidth(), getHeight());
                float f = (getWidth() - 40) / 800.0F - 1.0F;
                if (f > (getHeight() - 70) / 450.0F - 1.0F)
                    f = (getHeight() - 70) / 450.0F - 1.0F;
                if (f > 1.0F)
                    f = 1.0F;
                if (f < 0.0F)
                    f = 0.0F;
                apmult = 1.0F + f * reqmult;
                if (!oncarm)
                    graphics2d.drawImage(carmaker[0], 50, 14, this);
                else
                    graphics2d.drawImage(carmaker[1], 50, 14, this);
                if (!onstgm)
                    graphics2d.drawImage(stagemaker[0], getWidth() - 208, 14, this);
                else
                    graphics2d.drawImage(stagemaker[1], getWidth() - 208, 14, this);
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
                String string = new StringBuilder().append("").append((int) (apmult * 100.0F)).append("%").toString();
                if (reqmult == 0.0F)
                    string = "Original";
                if (reqmult == 1.0F)
                    string = "Maximum";
                graphics2d.drawString(string, getWidth() / 2 - 150, 17);
                if (!oncarm && !onstgm)
                    showsize--;
                if (showsize == 0) {
                    graphics2d.setColor(new Color(0, 0, 0));
                    graphics2d.fillRect(getWidth() / 2 - 260, 0, 520, 40);
                    graphics2d.fillRect(50, 14, 142, 23);
                    graphics2d.fillRect(getWidth() - 208, 14, 158, 23);
                }
            }
            apx = (int) (getWidth() / 2 - 400.0F * apmult);
            apy = (int) (getHeight() / 2 - 225.0F * apmult - 50.0F);
            if (apy < 50)
                apy = 50;
            if (apmult > 1.0F) {
                if (smooth == 1) {
                    graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    if (moto == 1) {
                        graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
                        rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                                RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                        graphics2d.drawImage(offImage, apx + i, apy + i97, (int) (800.0F * apmult),
                                (int) (450.0F * apmult), this);
                        cropit(graphics2d, i, i97);
                    } else
                        graphics2d.drawImage(offImage, apx, apy, (int) (800.0F * apmult), (int) (450.0F * apmult),
                                this);
                } else if (moto == 1) {
                    graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
                    rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                            RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                    graphics2d.drawImage(offImage, apx + i, apy + i97, (int) (800.0F * apmult), (int) (450.0F * apmult),
                            this);
                    cropit(graphics2d, i, i97);
                } else
                    graphics2d.drawImage(offImage, apx, apy, (int) (800.0F * apmult), (int) (450.0F * apmult), this);
            } else if (moto == 1) {
                graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
                rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
                        RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                graphics2d.drawImage(offImage, apx + i, apy + i97, this);
                cropit(graphics2d, i, i97);
            } else
                graphics2d.drawImage(offImage, apx, apy, this);
        } else if (moto == 1) {
            graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
            rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            graphics2d.drawImage(offImage, apx + i, apy + i97, this);
            cropit(graphics2d, i, i97);
        } else
            graphics2d.drawImage(offImage, apx, apy, this);
    }

    private void readcookies(final xtGraphics xtgraphics, final CarDefine cardefine, final ContO[] contos) {
        xtgraphics.nickname = "";
        try {
            final File file = new File(
                    new StringBuilder().append("").append(Madness.fpath).append("data/user.data").toString());
            final String[] strings = {
                    "", "", "", "", ""
            };
            if (file.exists()) {
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string;
                for (int i = 0; (string = bufferedreader.readLine()) != null && i < 5; i++)
                    strings[i] = string;
                bufferedreader.close();
            }
            if (strings[0].startsWith("lastuser")) {
                xtgraphics.nickname = getstring("lastuser", strings[0], 0);
                if (!xtgraphics.nickname.equals(""))
                    xtgraphics.opselect = 1;
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
                if (i >= 1 && i <= xtGraphics.nTracks)
                    xtgraphics.unlocked = i;
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
                if (i >= 0 && i <= 1)
                    moto = i;
                i = getint("graphics", strings[4], 1);
                if (i >= 0 && i <= 1)
                    Madness.anti = i;
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
                    final Color color = Color.getHSBColor(xtgraphics.arnp[0], xtgraphics.arnp[1],
                            1.0F - xtgraphics.arnp[2]);
                    final Color color200 = Color.getHSBColor(xtgraphics.arnp[3], xtgraphics.arnp[4],
                            1.0F - xtgraphics.arnp[5]);
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
        for (int i = 0; i < xtGraphics.nTracks; i++)
            snfmm.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());
        /*for (int i = 0; i < 10; i++)
        	snfm1.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());
        for (int i = 0; i < 17; i++)
        	snfm2.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());*/
        for (int i = 0; i < 7; i++)
            snpls.add(rd, new StringBuilder().append("    ").append(i + 2).append("").toString());
        for (int i = 0; i < 7; i++)
            snbts.add(rd, new StringBuilder().append("    ").append(i).append("    ").toString());
        for (int i = 0; i < 2; i++)
            swait.add(rd, new StringBuilder().append("").append(i + 2).append(" Minutes").toString());
        for (int i = 0; i < 15; i++)
            slaps.add(rd, new StringBuilder().append("").append(i + 1).append("").toString());
        for (int i = 0; i < 14; i++)
            ilaps.add(rd, new StringBuilder().append("").append(i + 2).append(" Laps").toString());
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
        for (int i = 0; i < 6; i++)
            clanlev.add(rd, new StringBuilder().append("").append(i + 1).append("").toString());
        clanlev.add(rd, "7 - Admin");
        hidefields();
    }

    public GameSparker() {
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
        if (offImage != null)
            rd = offImage.createGraphics();
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
        final Timer timer = new Timer(40, this);
        timer.start();
        /*Timer counter = new Timer(1, count);
        counter.start();*/
        //timer.setDelay(delay);
    }

    //allan please remove this soon
    private Date date;
    private int i7;
    private xtGraphics xtgraphics;
    private ContO[] contos;
    private ContO[] contos0;
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
    private int i6;
    private int i8;
    private int i9;
    private boolean bool10;
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
        if (System.getProperty("java.vendor").toLowerCase().indexOf("apple") != -1)
            applejava = true;
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
        contos0 = new ContO[10000];
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
                if (xtgraphics.sc[0] != -1)
                    xtgraphics.fase = -9;
                else {
                    Madness.testcar = "Failx12";
                    Madness.carmaker();
                }
            } else {
                checkpoints.name = Madness.testcar;
                xtgraphics.fase = -9;
            }
        xtgraphics.stoploading();
        requestFocus();
        if (xtgraphics.testdrive == 0 && xtgraphics.firstime)
            setupini();
        System.gc();
        date = new Date();
        l1 = date.getTime();
        f2 = 30.0F;
        bool3 = false;
        i4 = 530;
        i5 = 0;
        i6 = 0;
        i7 = 0;
        i8 = 0;
        i9 = 0;
        bool10 = false;

        //while (!Thread.currentThread().isInterrupted()) {}
    }

    private void gameTick() {

        date = new Date();
        date.getTime();
        if (xtgraphics.fase == 111) {
            if (mouses == 1)
                i7 = 800;
            if (i7 < 800) {
                xtgraphics.clicknow();
                i7++;
            } else {
                i7 = 0;
                if (!exwist)
                    xtgraphics.fase = 9;
                mouses = 0;
                lostfcs = false;
            }
        }
        if (xtgraphics.fase == 9)
            if (i7 < 76) {
                xtgraphics.rad(i7);
                catchlink();
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
                i7++;
            } else {
                i7 = 0;
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
            if (i7 < 2) {
                xtgraphics.mainbg(-101);
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(65, 25, 670, 400);
                i7++;
            } else {
                checkmemory(xtgraphics);
                xtgraphics.inishcarselect(contos);
                i7 = 0;
                xtgraphics.fase = 7;
                mvect = 50;
                mouses = 0;
            }
        }
        if (xtgraphics.fase == 8) {
            xtgraphics.credits(u[0], xm, ym, mouses);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (xtgraphics.flipo <= 100)
                catchlink();
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
        }
        if (xtgraphics.fase == 10) {
            mvect = 100;
            xtgraphics.maini(u[0]);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
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
            if (xtgraphics.testdrive == 1 || xtgraphics.testdrive == 2)
                Madness.carmaker();
            if (xtgraphics.testdrive == 3 || xtgraphics.testdrive == 4)
                Madness.stagemaker();
            xtgraphics.maini(u[0]);
            xtgraphics.fase = 10;
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
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
            if (xtgraphics.testdrive == 1 || xtgraphics.testdrive == 2)
                Madness.carmaker();
            if (xtgraphics.testdrive == 3 || xtgraphics.testdrive == 4)
                Madness.stagemaker();
            xtgraphics.maini2(u[0], xm, ym, mouses);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
        }
        if (xtgraphics.fase == -22) {
            checkpoints.name = Madness.testcar;
            checkpoints.stage = -1;
            loadstage(contos0, contos, medium, trackers, checkpoints, xtgraphics, mads, record);
            if (checkpoints.stage == -3) {
                Madness.testcar = "Failx12";
                Madness.stagemaker();
            }
        }
        if (xtgraphics.fase == 11) {
            xtgraphics.inst(u[0]);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
        }
        if (xtgraphics.fase == -5) {
            mvect = 100;
            xtgraphics.finish(checkpoints, contos, u[0], xm, ym, moused);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
        }
        if (xtgraphics.fase == 7) {
            xtgraphics.carselect(u[0], contos, mads[0], xm, ym, moused);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
            drawms();
        }
        if (xtgraphics.fase == 6) {
            xtgraphics.musicomp(checkpoints.stage, u[0]);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
        }
        if (xtgraphics.fase == 5) {
            mvect = 100;
            xtgraphics.loadmusic(checkpoints.stage, checkpoints.trackname, checkpoints.trackvol);
        }
        if (xtgraphics.fase == 4) {
            xtgraphics.cantgo(u[0]);
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
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
            loadstage(contos0, contos, medium, trackers, checkpoints, xtgraphics, mads, record);
            u[0].falseo(0);
            udpmistro.freg = 0.0F;
            mvect = 20;
        }
        if (xtgraphics.fase == 1) {
            xtgraphics.trackbg(false);
            rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            if (checkpoints.stage != -3) {
                medium.aroundtrack(checkpoints);
                if (medium.hit == 5000 && mvect < 40)
                    mvect++;
                int i12 = 0;
                final int[] is = new int[1000];
                for (int i13 = xtgraphics.nplayers; i13 < notb; i13++)
                    if (contos0[i13].dist != 0) {
                        is[i12] = i13;
                        i12++;
                    } else
                        contos0[i13].d(rd);
                final int[] is14 = new int[i12];
                for (int i15 = 0; i15 < i12; i15++)
                    is14[i15] = 0;
                for (int i16 = 0; i16 < i12; i16++)
                    for (int i17 = i16 + 1; i17 < i12; i17++)
                        if (contos0[is[i16]].dist != contos0[is[i17]].dist) {
                            if (contos0[is[i16]].dist < contos0[is[i17]].dist)
                                is14[i16]++;
                            else
                                is14[i17]++;
                        } else if (i17 > i16)
                            is14[i16]++;
                        else
                            is14[i17]++;
                for (int i18 = 0; i18 < i12; i18++)
                    for (int i19 = 0; i19 < i12; i19++)
                        if (is14[i19] == i18)
                            contos0[is[i19]].d(rd);
            }
            if (!openm)
                xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
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
                if (mload > 0)
                    rd.drawImage(xtgraphics.mload, 259, 195, this);
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
                if (login.fase == 0)
                    login.inishmulti();
                if (login.fase >= 1 && login.fase <= 11)
                    login.multistart(contos, xm, ym, moused);
                if (login.fase >= 12 && login.fase <= 17)
                    //if (globe.open != 452)
                    login.multimode(contos);
                //else
                //	bool20 = true;
                //globe.dome(0, xm, ym, moused, u[0]);
                if (login.justlog)
                    //if (!xtgraphics.clan.equals(""))
                    //	globe.itab = 2;
                    login.justlog = false;
                if (!bool20) {
                    login.ctachm(xm, ym, mouses, u[0], lobby);
                    mvect = 50;
                } else {
                    drawms();
                    mvect = 100;
                }
                if (mouses == 1)
                    mouses = 11;
                if (mouses <= -1) {
                    mouses--;
                    if (mouses == -4)
                        mouses = 0;
                }
                if (mousew != 0)
                    if (mousew > 0)
                        mousew--;
                    else
                        mousew++;
            } else {
                final boolean bool21 = false;
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
                        if (loadstagePreview(lobby.loadstage, "", contos0, contos, medium, checkpoints)) {
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
                        if (lobby.msload == 1)
                            cardefine.loadmystages(checkpoints);
                        if (lobby.msload == 7)
                            cardefine.loadclanstages(xtgraphics.clan);
                        if (lobby.msload == 3 || lobby.msload == 4)
                            cardefine.loadtop20(lobby.msload);
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
                    int i22 = 0;
                    final int[] is = new int[1000];
                    for (int i23 = 0; i23 < nob; i23++)
                        if (contos0[i23].dist != 0) {
                            is[i22] = i23;
                            i22++;
                        } else
                            contos0[i23].d(rd);
                    final int[] is24 = new int[i22];
                    for (int i25 = 0; i25 < i22; i25++)
                        is24[i25] = 0;
                    for (int i26 = 0; i26 < i22; i26++)
                        for (int i27 = i26 + 1; i27 < i22; i27++)
                            if (contos0[is[i26]].dist != contos0[is[i27]].dist) {
                                if (contos0[is[i26]].dist < contos0[is[i27]].dist)
                                    is24[i26]++;
                                else
                                    is24[i27]++;
                            } else if (i27 > i26)
                                is24[i26]++;
                            else
                                is24[i27]++;
                    for (int i28 = 0; i28 < i22; i28++)
                        for (int i29 = 0; i29 < i22; i29++)
                            if (is24[i29] == i28)
                                contos0[is[i29]].d(rd);
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
                    int i30 = 0;
                    for (int i31 = 0; i31 < lobby.ngm; i31++)
                        if (lobby.ongame == lobby.gnum[i31])
                            i30 = i31;
                    boolean bool32 = false;
                    if (lobby.gstgn[i30] > 0) {
                        if (lobby.gstgn[i30] == -lobby.loadstage)
                            bool32 = true;
                    } else if (lobby.gstages[i30].equals(checkpoints.name))
                        bool32 = true;
                    if (bool32) {
                        lobby.fase = 4;
                        lobby.addstage = 0;
                    } else {
                        xtgraphics.loadingstage(lobby.gstgn[i30], false);
                        trackers.nt = 0;
                        if (loadstagePreview(lobby.gstgn[i30], lobby.gstages[i30], contos0, contos, medium,
                                checkpoints)) {
                            lobby.loadstage = -lobby.gstgn[i30];
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
                    if (!bool21)
                        lobby.ctachm(xm, ym, mouses, u[0]);
                    /*if (mouses == 2)
                    	mouses = 0;
                    if (mouses == 1)
                    	mouses = 2;*/
                } else
                    mouses = 0;
                drawms();
                if (lobby.fase == 1)
                    lobby.preforma(xm, ym);
                if (lobby.loadwarb)
                    //repaint();
                    //globe.loadwarb();
                    lobby.loadwarb = false;
                /*if (globe.loadwbgames == 1) {
                	//repaint();
                	globe.loadwgames();
                }*/
                if (mouses == 1)
                    mouses = 11;
                if (mouses <= -1) {
                    mouses--;
                    if (mouses == -4)
                        mouses = 0;
                }
                if (mousew != 0) {
                    if (mousew > 0)
                        mousew--;
                    else
                        mousew++;
                    if (!lobby.zeromsw)
                        mousew = 0;
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
            if (login.fase == 18)
                xtgraphics.playingame = -101;
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
            loadstage(contos0, contos, medium, trackers, checkpoints, xtgraphics, mads, record);
            if (checkpoints.stage != -3) {
                if (xtgraphics.lan && xtgraphics.im == 0)
                    udpmistro.UDPLanServer(xtgraphics.nplayers, xtgraphics.server, xtgraphics.servport,
                            xtgraphics.playingame);
                u[0].falseo(2);
                requestFocus();
            } else
                xtgraphics.fase = 1177;
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
            for (int i33 = 0; i33 < xtgraphics.nplayers; i33++)
                if (mads[i33].newcar) {
                    final int i34 = contos0[i33].xz;
                    final int i35 = contos0[i33].xy;
                    final int i36 = contos0[i33].zy;
                    contos0[i33] = new ContO(contos[mads[i33].cn], contos0[i33].x, contos0[i33].y, contos0[i33].z, 0);
                    contos0[i33].xz = i34;
                    contos0[i33].xy = i35;
                    contos0[i33].zy = i36;
                    mads[i33].newcar = false;
                }
            medium.d(rd);
            int i37 = 0;
            final int[] is = new int[10000];
            for (int i38 = 0; i38 < nob; i38++)
                if (contos0[i38].dist != 0) {
                    is[i37] = i38;
                    i37++;
                } else
                    contos0[i38].d(rd);
            final int[] is39 = new int[i37];
            final int[] is40 = new int[i37];
            for (int i41 = 0; i41 < i37; i41++)
                is39[i41] = 0;
            for (int i42 = 0; i42 < i37; i42++) {
                for (int i43 = i42 + 1; i43 < i37; i43++)
                    if (contos0[is[i42]].dist < contos0[is[i43]].dist)
                        is39[i42]++;
                    else
                        is39[i43]++;
                is40[is39[i42]] = i42;
            }
            for (int i44 = 0; i44 < i37; i44++)
                contos0[is[is40[i44]]].d(rd);
            if (xtgraphics.starcnt == 0) {
                for (int i45 = 0; i45 < xtgraphics.nplayers; i45++)
                    for (int i46 = 0; i46 < xtgraphics.nplayers; i46++)
                        if (i46 != i45)
                            mads[i45].colide(contos0[i45], mads[i46], contos0[i46]);
                for (int i47 = 0; i47 < xtgraphics.nplayers; i47++)
                    mads[i47].drive(u[i47], contos0[i47], trackers, checkpoints);
                for (int i48 = 0; i48 < xtgraphics.nplayers; i48++)
                    record.rec(contos0[i48], i48, mads[i48].squash, mads[i48].lastcolido, mads[i48].cntdest, 0);
                checkpoints.checkstat(mads, contos0, record, xtgraphics.nplayers, xtgraphics.im, 0);
                for (int i49 = 1; i49 < xtgraphics.nplayers; i49++)
                    u[i49].preform(mads[i49], contos0[i49], checkpoints, trackers);
            } else {
                if (xtgraphics.starcnt == 130) {
                    medium.adv = 1900;
                    medium.zy = 40;
                    medium.vxz = 70;
                    rd.setColor(new Color(255, 255, 255));
                    rd.fillRect(0, 0, 800, 450);
                }
                if (xtgraphics.starcnt != 0)
                    xtgraphics.starcnt--;
            }
            if (xtgraphics.starcnt < 38) {
                if (view == 0) {
                    medium.follow(contos0[0], mads[0].cxz, u[0].lookback);
                    xtgraphics.stat(mads[0], contos0[0], checkpoints, u[0], true);
                    if (mads[0].outshakedam > 0) {
                        shaka = mads[0].outshakedam / 20;
                        if (shaka > 25)
                            shaka = 25;
                    }
                    mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                    if (mvect > 90)
                        mvect = 90;
                    lmxz = medium.xz;
                }
                if (view == 1) {
                    medium.around(contos0[0], false);
                    xtgraphics.stat(mads[0], contos0[0], checkpoints, u[0], false);
                    mvect = 80;
                }
                if (view == 2) {
                    medium.watch(contos0[0], mads[0].mxz);
                    xtgraphics.stat(mads[0], contos0[0], checkpoints, u[0], false);
                    mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                    if (mvect > 90)
                        mvect = 90;
                    lmxz = medium.xz;
                }
                if (mouses == 1) {
                    u[0].enter = true;
                    mouses = 0;
                }
            } else {
                int i50 = 3;
                if (xtgraphics.nplayers == 1)
                    i50 = 0;
                medium.around(contos0[i50], true);
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
                    checkpoints.checkstat(mads, contos0, record, xtgraphics.nplayers, xtgraphics.im, 0);
                    medium.follow(contos0[0], mads[0].cxz, 0);
                    xtgraphics.stat(mads[0], contos0[0], checkpoints, u[0], true);
                    rd.setColor(new Color(255, 255, 255));
                    rd.fillRect(0, 0, 800, 450);
                }
            }
        }
        if (xtgraphics.fase == 7001) {
            for (int i51 = 0; i51 < xtgraphics.nplayers; i51++)
                if (mads[i51].newedcar == 0 && mads[i51].newcar) {
                    final int i52 = contos0[i51].xz;
                    final int i53 = contos0[i51].xy;
                    final int i54 = contos0[i51].zy;
                    xtgraphics.colorCar(contos[mads[i51].cn], i51);
                    contos0[i51] = new ContO(contos[mads[i51].cn], contos0[i51].x, contos0[i51].y, contos0[i51].z, 0);
                    contos0[i51].xz = i52;
                    contos0[i51].xy = i53;
                    contos0[i51].zy = i54;
                    mads[i51].newedcar = 20;
                }
            medium.d(rd);
            int i55 = 0;
            final int[] is = new int[10000];
            for (int i56 = 0; i56 < nob; i56++)
                if (contos0[i56].dist != 0) {
                    is[i55] = i56;
                    i55++;
                } else
                    contos0[i56].d(rd);
            final int[] is57 = new int[i55];
            final int[] is58 = new int[i55];
            for (int i59 = 0; i59 < i55; i59++)
                is57[i59] = 0;
            for (int i60 = 0; i60 < i55; i60++) {
                for (int i61 = i60 + 1; i61 < i55; i61++)
                    if (contos0[is[i60]].dist < contos0[is[i61]].dist)
                        is57[i60]++;
                    else
                        is57[i61]++;
                is58[is57[i60]] = i60;
            }
            for (int i62 = 0; i62 < i55; i62++) {
                if (is[is58[i62]] < xtgraphics.nplayers && is[is58[i62]] != xtgraphics.im)
                    udpmistro.readContOinfo(contos0[is[is58[i62]]], is[is58[i62]]);
                contos0[is[is58[i62]]].d(rd);
            }
            if (xtgraphics.starcnt == 0) {
                if (xtgraphics.multion == 1) {
                    int i63 = 1;
                    for (int i64 = 0; i64 < xtgraphics.nplayers; i64++)
                        if (xtgraphics.im != i64) {
                            udpmistro.readinfo(mads[i64], contos0[i64], u[i63], i64, checkpoints.dested);
                            i63++;
                        }
                } else
                    for (int i65 = 0; i65 < xtgraphics.nplayers; i65++)
                        udpmistro.readinfo(mads[i65], contos0[i65], u[i65], i65, checkpoints.dested);
                for (int i66 = 0; i66 < xtgraphics.nplayers; i66++)
                    for (int i67 = 0; i67 < xtgraphics.nplayers; i67++)
                        if (i67 != i66)
                            mads[i66].colide(contos0[i66], mads[i67], contos0[i67]);
                if (xtgraphics.multion == 1) {
                    int i68 = 1;
                    for (int i69 = 0; i69 < xtgraphics.nplayers; i69++)
                        if (xtgraphics.im != i69) {
                            mads[i69].drive(u[i68], contos0[i69], trackers, checkpoints);
                            i68++;
                        } else
                            mads[i69].drive(u[0], contos0[i69], trackers, checkpoints);
                    for (int i70 = 0; i70 < xtgraphics.nplayers; i70++)
                        record.rec(contos0[i70], i70, mads[i70].squash, mads[i70].lastcolido, mads[i70].cntdest,
                                xtgraphics.im);
                } else
                    for (int i71 = 0; i71 < xtgraphics.nplayers; i71++)
                        mads[i71].drive(u[i71], contos0[i71], trackers, checkpoints);
                checkpoints.checkstat(mads, contos0, record, xtgraphics.nplayers, xtgraphics.im, xtgraphics.multion);
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
                        if (xtgraphics.im == 0)
                            xtgraphics.setbots(udpmistro.isbot, udpmistro.frame);
                    } else
                        udpmistro.UDPConnectOnline(xtgraphics.server, xtgraphics.gameport, xtgraphics.nplayers,
                                xtgraphics.im);
                    if (xtgraphics.multion >= 2) {
                        xtgraphics.im = (int) (Math.random() * xtgraphics.nplayers);
                        xtgraphics.starcnt = 0;
                    }
                }
                if (xtgraphics.starcnt == 50)
                    udpmistro.frame[udpmistro.im][0] = 0;
                if (xtgraphics.starcnt != 39 && xtgraphics.starcnt != 0)
                    xtgraphics.starcnt--;
                if (udpmistro.go && xtgraphics.starcnt >= 39) {
                    xtgraphics.starcnt = 38;
                    if (xtgraphics.lan) {
                        int i72 = checkpoints.stage;
                        if (i72 < 0)
                            i72 = 33;
                        if (xtgraphics.loadedt)
                            xtgraphics.strack.play();
                    }
                }
            }
            if (xtgraphics.lan && udpmistro.im == 0)
                for (int i73 = 2; i73 < xtgraphics.nplayers; i73++)
                    if (udpmistro.isbot[i73]) {
                        u[i73].preform(mads[i73], contos0[i73], checkpoints, trackers);
                        udpmistro.setinfo(mads[i73], contos0[i73], u[i73], checkpoints.pos[i73],
                                checkpoints.magperc[i73], false, i73);
                    }
            if (xtgraphics.starcnt < 38) {
                if (xtgraphics.multion == 1) {
                    udpmistro.setinfo(mads[xtgraphics.im], contos0[xtgraphics.im], u[0], checkpoints.pos[xtgraphics.im],
                            checkpoints.magperc[xtgraphics.im], xtgraphics.holdit, xtgraphics.im);
                    if (view == 0) {
                        medium.follow(contos0[xtgraphics.im], mads[xtgraphics.im].cxz, u[0].lookback);
                        xtgraphics.stat(mads[xtgraphics.im], contos0[xtgraphics.im], checkpoints, u[0], true);
                        if (mads[xtgraphics.im].outshakedam > 0) {
                            shaka = mads[xtgraphics.im].outshakedam / 20;
                            if (shaka > 25)
                                shaka = 25;
                        }
                        mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                        if (mvect > 90)
                            mvect = 90;
                        lmxz = medium.xz;
                    }
                    if (view == 1) {
                        medium.around(contos0[xtgraphics.im], false);
                        xtgraphics.stat(mads[xtgraphics.im], contos0[xtgraphics.im], checkpoints, u[0], false);
                        mvect = 80;
                    }
                    if (view == 2) {
                        medium.watch(contos0[xtgraphics.im], mads[xtgraphics.im].mxz);
                        xtgraphics.stat(mads[xtgraphics.im], contos0[xtgraphics.im], checkpoints, u[0], false);
                        mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                        if (mvect > 90)
                            mvect = 90;
                        lmxz = medium.xz;
                    }
                } else {
                    if (view == 0) {
                        medium.getaround(contos0[xtgraphics.im]);
                        mvect = 80;
                    }
                    if (view == 1) {
                        medium.getfollow(contos0[xtgraphics.im], mads[xtgraphics.im].cxz, u[0].lookback);
                        mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                        if (mvect > 90)
                            mvect = 90;
                        lmxz = medium.xz;
                    }
                    if (view == 2) {
                        medium.watch(contos0[xtgraphics.im], mads[xtgraphics.im].mxz);
                        mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
                        if (mvect > 90)
                            mvect = 90;
                        lmxz = medium.xz;
                    }
                    xtgraphics.stat(mads[xtgraphics.im], contos0[xtgraphics.im], checkpoints, u[0], true);
                }
                if (mouses == 1) {
                    if (xtgraphics.holdit && xtgraphics.exitm != 4 && xtgraphics.multion == 1)
                        u[0].enter = true;
                    mouses = 0;
                }
            } else {
                medium.around(contos0[xtgraphics.im], true);
                mvect = 80;
                if (xtgraphics.starcnt == 39)
                    xtgraphics.waitenter();
                if (xtgraphics.starcnt == 38) {
                    xtgraphics.forstart = 0;
                    mouses = 0;
                    medium.vert = false;
                    medium.adv = 900;
                    medium.vxz = 180;
                    checkpoints.checkstat(mads, contos0, record, xtgraphics.nplayers, xtgraphics.im,
                            xtgraphics.multion);
                    medium.follow(contos0[xtgraphics.im], mads[xtgraphics.im].cxz, 0);
                    xtgraphics.stat(mads[xtgraphics.im], contos0[xtgraphics.im], checkpoints, u[0], true);
                    rd.setColor(new Color(255, 255, 255));
                    rd.fillRect(0, 0, 800, 450);
                }
            }
            xtgraphics.multistat(u[0], checkpoints, xm, ym, moused, udpmistro);
        }
        if (xtgraphics.fase == -1) {
            if (i6 == 0)
                for (int i74 = 0; i74 < xtgraphics.nplayers; i74++) {
                    record.ocar[i74] = new ContO(contos0[i74], 0, 0, 0, 0);
                    contos0[i74] = new ContO(record.car[0][i74], 0, 0, 0, 0);
                }
            medium.d(rd);
            int i75 = 0;
            final int[] is = new int[10000];
            for (int i76 = 0; i76 < nob; i76++)
                if (contos0[i76].dist != 0) {
                    is[i75] = i76;
                    i75++;
                } else
                    contos0[i76].d(rd);
            final int[] is77 = new int[i75];
            for (int i78 = 0; i78 < i75; i78++)
                is77[i78] = 0;
            for (int i79 = 0; i79 < i75; i79++)
                for (int i80 = i79 + 1; i80 < i75; i80++)
                    if (contos0[is[i79]].dist != contos0[is[i80]].dist) {
                        if (contos0[is[i79]].dist < contos0[is[i80]].dist)
                            is77[i79]++;
                        else
                            is77[i80]++;
                    } else if (i80 > i79)
                        is77[i79]++;
                    else
                        is77[i80]++;
            for (int i81 = 0; i81 < i75; i81++)
                for (int i82 = 0; i82 < i75; i82++)
                    if (is77[i82] == i81)
                        contos0[is[i82]].d(rd);
            if (u[0].enter || u[0].handb || mouses == 1) {
                i6 = 299;
                u[0].enter = false;
                u[0].handb = false;
                mouses = 0;
            }
            for (int i83 = 0; i83 < xtgraphics.nplayers; i83++) {
                if (record.fix[i83] == i6)
                    if (contos0[i83].dist == 0)
                        contos0[i83].fcnt = 8;
                    else
                        contos0[i83].fix = true;
                if (contos0[i83].fcnt == 7 || contos0[i83].fcnt == 8) {
                    contos0[i83] = new ContO(contos[mads[i83].cn], 0, 0, 0, 0);
                    record.cntdest[i83] = 0;
                }
                if (i6 == 299)
                    contos0[i83] = new ContO(record.ocar[i83], 0, 0, 0, 0);
                record.play(contos0[i83], mads[i83], i83, i6);
            }
            if (++i6 == 300) {
                i6 = 0;
                xtgraphics.fase = -6;
            } else
                xtgraphics.replyn();
            medium.around(contos0[0], false);
        }
        if (xtgraphics.fase == -2) {
            if (xtgraphics.multion >= 2)
                record.hcaught = false;
            u[0].falseo(3);
            if (record.hcaught && record.wasted == 0 && record.whenwasted != 229
                    && (checkpoints.stage == 1 || checkpoints.stage == 2) && xtgraphics.looped != 0)
                record.hcaught = false;
            if (record.hcaught) {
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(0, 0, 800, 450);
                //repaint();
            }
            if (xtgraphics.multion != 0) {
                udpmistro.UDPquit();
                xtgraphics.stopchat();
                if (cmsg.isShowing())
                    cmsg.setVisible(false);
                cmsg.setText("");
                requestFocus();
            }
            if (record.hcaught) {
                if (medium.random() > 0.45)
                    medium.vert = false;
                else
                    medium.vert = true;
                medium.adv = (int) (900.0F * medium.random());
                medium.vxz = (int) (360.0F * medium.random());
                i6 = 0;
                xtgraphics.fase = -3;
                i7 = 0;
                i8 = 0;
            } else {
                i6 = -2;
                xtgraphics.fase = -4;
            }
        }
        if (xtgraphics.fase == -3) {
            if (i6 == 0) {
                if (record.wasted == 0) {
                    if (record.whenwasted == 229) {
                        i9 = 67;
                        medium.vxz += 90;
                    } else {
                        i9 = (int) (medium.random() * 4.0F);
                        if (i9 == 1 || i9 == 3)
                            i9 = 69;
                        if (i9 == 2 || i9 == 4)
                            i9 = 30;
                    }
                } else if (record.closefinish != 0 && i8 != 0)
                    medium.vxz += 90;
                for (int i84 = 0; i84 < xtgraphics.nplayers; i84++)
                    contos0[i84] = new ContO(record.starcar[i84], 0, 0, 0, 0);
            }
            medium.d(rd);
            int i85 = 0;
            final int[] is = new int[10000];
            for (int i86 = 0; i86 < nob; i86++)
                if (contos0[i86].dist != 0) {
                    is[i85] = i86;
                    i85++;
                } else
                    contos0[i86].d(rd);
            final int[] is87 = new int[i85];
            for (int i88 = 0; i88 < i85; i88++)
                is87[i88] = 0;
            for (int i89 = 0; i89 < i85; i89++)
                for (int i90 = i89 + 1; i90 < i85; i90++)
                    if (contos0[is[i89]].dist != contos0[is[i90]].dist) {
                        if (contos0[is[i89]].dist < contos0[is[i90]].dist)
                            is87[i89]++;
                        else
                            is87[i90]++;
                    } else if (i90 > i89)
                        is87[i89]++;
                    else
                        is87[i90]++;
            for (int i91 = 0; i91 < i85; i91++)
                for (int i92 = 0; i92 < i85; i92++)
                    if (is87[i92] == i91)
                        contos0[is[i92]].d(rd);
            for (int i93 = 0; i93 < xtgraphics.nplayers; i93++) {
                if (record.hfix[i93] == i6)
                    if (contos0[i93].dist == 0)
                        contos0[i93].fcnt = 8;
                    else
                        contos0[i93].fix = true;
                if (contos0[i93].fcnt == 7 || contos0[i93].fcnt == 8) {
                    contos0[i93] = new ContO(contos[mads[i93].cn], 0, 0, 0, 0);
                    record.cntdest[i93] = 0;
                }
                record.playh(contos0[i93], mads[i93], i93, i6, xtgraphics.im);
            }
            if (i8 == 2 && i6 == 299)
                u[0].enter = true;
            if (u[0].enter || u[0].handb) {
                xtgraphics.fase = -4;
                u[0].enter = false;
                u[0].handb = false;
                i6 = -7;
            } else {
                xtgraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, i6, checkpoints.stage);
                if (i6 == 0 || i6 == 1 || i6 == 2) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 800, 450);
                }
                if (record.wasted != xtgraphics.im) {
                    if (record.closefinish == 0) {
                        if (i7 == 9 || i7 == 11) {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 800, 450);
                        }
                        if (i7 == 0)
                            medium.around(contos0[xtgraphics.im], false);
                        if (i7 > 0 && i7 < 20)
                            medium.transaround(contos0[xtgraphics.im], contos0[record.wasted], i7);
                        if (i7 == 20)
                            medium.around(contos0[record.wasted], false);
                        if (i6 > record.whenwasted && i7 != 20)
                            i7++;
                        if ((i7 == 0 || i7 == 20) && ++i6 == 300) {
                            i6 = 0;
                            i7 = 0;
                            i8++;
                        }
                    } else if (record.closefinish == 1) {
                        if (i7 == 0)
                            medium.around(contos0[xtgraphics.im], false);
                        if (i7 > 0 && i7 < 20)
                            medium.transaround(contos0[xtgraphics.im], contos0[record.wasted], i7);
                        if (i7 == 20)
                            medium.around(contos0[record.wasted], false);
                        if (i7 > 20 && i7 < 40)
                            medium.transaround(contos0[record.wasted], contos0[xtgraphics.im], i7 - 20);
                        if (i7 == 40)
                            medium.around(contos0[xtgraphics.im], false);
                        if (i7 > 40 && i7 < 60)
                            medium.transaround(contos0[xtgraphics.im], contos0[record.wasted], i7 - 40);
                        if (i7 == 60)
                            medium.around(contos0[record.wasted], false);
                        if (i6 > 160 && i7 < 20)
                            i7++;
                        if (i6 > 230 && i7 < 40)
                            i7++;
                        if (i6 > 280 && i7 < 60)
                            i7++;
                        if ((i7 == 0 || i7 == 20 || i7 == 40 || i7 == 60) && ++i6 == 300) {
                            i6 = 0;
                            i7 = 0;
                            i8++;
                        }
                    } else {
                        if (i7 == 0)
                            medium.around(contos0[xtgraphics.im], false);
                        if (i7 > 0 && i7 < 20)
                            medium.transaround(contos0[xtgraphics.im], contos0[record.wasted], i7);
                        if (i7 == 20)
                            medium.around(contos0[record.wasted], false);
                        if (i7 > 20 && i7 < 40)
                            medium.transaround(contos0[record.wasted], contos0[xtgraphics.im], i7 - 20);
                        if (i7 == 40)
                            medium.around(contos0[xtgraphics.im], false);
                        if (i7 > 40 && i7 < 60)
                            medium.transaround(contos0[xtgraphics.im], contos0[record.wasted], i7 - 40);
                        if (i7 == 60)
                            medium.around(contos0[record.wasted], false);
                        if (i7 > 60 && i7 < 80)
                            medium.transaround(contos0[record.wasted], contos0[xtgraphics.im], i7 - 60);
                        if (i7 == 80)
                            medium.around(contos0[xtgraphics.im], false);
                        if (i6 > 90 && i7 < 20)
                            i7++;
                        if (i6 > 160 && i7 < 40)
                            i7++;
                        if (i6 > 230 && i7 < 60)
                            i7++;
                        if (i6 > 280 && i7 < 80)
                            i7++;
                        if ((i7 == 0 || i7 == 20 || i7 == 40 || i7 == 60 || i7 == 80) && ++i6 == 300) {
                            i6 = 0;
                            i7 = 0;
                            i8++;
                        }
                    }
                } else {
                    if (i9 == 67 && (i7 == 3 || i7 == 31 || i7 == 66)) {
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                    }
                    if (i9 == 69 && (i7 == 3 || i7 == 5 || i7 == 31 || i7 == 33 || i7 == 66 || i7 == 68)) {
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                    }
                    if (i9 == 30 && i7 >= 1 && i7 < 30)
                        if (i7 % (int) (2.0F + medium.random() * 3.0F) == 0 && !bool10) {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 800, 450);
                            bool10 = true;
                        } else
                            bool10 = false;
                    if (i6 > record.whenwasted && i7 != i9)
                        i7++;
                    medium.around(contos0[xtgraphics.im], false);
                    if ((i7 == 0 || i7 == i9) && ++i6 == 300) {
                        i6 = 0;
                        i7 = 0;
                        i8++;
                    }
                }
            }
        }
        if (xtgraphics.fase == -4) {
            if (i6 == 0) {
                xtgraphics.sendwin(checkpoints);
                if (xtgraphics.winner && xtgraphics.multion == 0 && xtgraphics.gmode != 0
                        && checkpoints.stage != xtGraphics.nTracks && checkpoints.stage == xtgraphics.unlocked) {
                    xtgraphics.unlocked++;
                    setcarcookie(xtgraphics.sc[0], cardefine.names[xtgraphics.sc[0]], xtgraphics.arnp, xtgraphics.gmode,
                            xtgraphics.unlocked, false);
                    xtgraphics.unlocked--;
                }
            }
            if (i6 <= 0) {
                rd.drawImage(xtgraphics.mdness, 289, 30, null);
                rd.drawImage(xtgraphics.dude[0], 135, 10, null);
            }
            if (i6 >= 0)
                xtgraphics.fleximage(offImage, i6, checkpoints.stage);
            if (++i6 == 7) {
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
            if (i6 != 0)
                i6 = 0;
            xtgraphics.ctachm(xm, ym, mouses, u[0]);
            if (mouses == 2)
                mouses = 0;
            if (mouses == 1)
                mouses = 2;
        }
        if (xtgraphics.fase == -8) {
            xtgraphics.cantreply();
            if (++i6 == 150 || u[0].enter || u[0].handb || mouses == 1) {
                xtgraphics.fase = -7;
                mouses = 0;
                u[0].enter = false;
                u[0].handb = false;
            }
        }
        if (lostfcs && xtgraphics.fase == 7001)
            if (fcscnt == 0) {
                if (u[0].chatup == 0)
                    requestFocus();
                fcscnt = 10;
            } else
                fcscnt--;
        //repaint();
        if (xtgraphics.im > -1 && xtgraphics.im < 8) {
            int i94 = 0;
            if (xtgraphics.multion == 2 || xtgraphics.multion == 3) {
                i94 = xtgraphics.im;
                u[i94].mutem = u[0].mutem;
                u[i94].mutes = u[0].mutes;
            }
            xtgraphics.playsounds(mads[xtgraphics.im], u[i94], checkpoints.stage);
        }
        date = new Date();
        final long l95 = date.getTime();
        if (xtgraphics.fase == 0 || xtgraphics.fase == -1 || xtgraphics.fase == -3 || xtgraphics.fase == 7001) {
            if (!bool3) {
                f2 = f;
                if (f2 < 30.0F)
                    f2 = 30.0F;
                bool3 = true;
                i5 = 0;
            }
            if (i5 == 10) {
                float f96 = (i4 + udpmistro.freg - (l95 - l1)) / 20.0F;
                if (f96 > 40.0F)
                    f96 = 40.0F;
                if (f96 < -40.0F)
                    f96 = -40.0F;
                f2 += f96;
                if (f2 < 5.0F)
                    f2 = 5.0F;
                medium.adjstfade(f2, f96, xtgraphics.starcnt, this);
                l1 = l95;
                i5 = 0;
            } else
                i5++;
        } else {
            if (bool3) {
                f = f2;
                bool3 = false;
                i5 = 0;
            }
            if (i5 == 10) {
                if (l95 - l1 < 400L)
                    f2 += 3.5;
                else {
                    f2 -= 3.5;
                    if (f2 < 5.0F)
                        f2 = 5.0F;
                }
                l1 = l95;
                i5 = 0;
            } else
                i5++;
        }
        if (exwist)
            trash();

    }

    void setcarcookie(final int i, final String string, final float[] fs, final int i191, final int is,
            final boolean bool) {
        try {
            final File file = new File(
                    new StringBuilder().append("").append(Madness.fpath).append("data/user.data").toString());
            final String[] strings = {
                    "", "", "", "", ""
            };
            if (file.exists()) {
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string192;
                for (int i193 = 0; (string192 = bufferedreader.readLine()) != null && i193 < 5; i193++)
                    strings[i193] = string192;
                bufferedreader.close();
            }
            if (i191 == 0)
                strings[1] = new StringBuilder().append("lastcar(").append(i).append(",").append((int) (fs[0] * 100.0F))
                        .append(",").append((int) (fs[1] * 100.0F)).append(",").append((int) (fs[2] * 100.0F))
                        .append(",").append((int) (fs[3] * 100.0F)).append(",").append((int) (fs[4] * 100.0F))
                        .append(",").append((int) (fs[5] * 100.0F)).append(",").append(string).append(")").toString();
            if (i191 == 1 || i191 == 2)
                strings[2] = new StringBuilder().append("saved(").append(i).append(",").append(is).append(")")
                        .toString();
            //if (i191 == 2)
            //	strings[3] = new StringBuilder().append("NFM2(").append(i).append(")")
            //			.toString();
            strings[4] = new StringBuilder().append("graphics(").append(moto).append(",").append(Madness.anti)
                    .append(")").toString();
            final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            for (int i195 = 0; i195 < 5; i195++) {
                bufferedwriter.write(strings[i195]);
                bufferedwriter.newLine();
            }
            bufferedwriter.close();
        } catch (final Exception exception) {

        }
    }

    void setloggedcookie() {
        try {
            final File file = new File(
                    new StringBuilder().append("").append(Madness.fpath).append("data/user.data").toString());
            final String[] strings = {
                    "", "", "", "", ""
            };
            if (file.exists()) {
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string;
                for (int i = 0; (string = bufferedreader.readLine()) != null && i < 5; i++)
                    strings[i] = string;
                bufferedreader.close();
            }
            if (keplo.getState())
                strings[0] = new StringBuilder().append("lastuser(").append(tnick.getText()).append(",")
                        .append(tpass.getText()).append(")").toString();
            else
                strings[0] = new StringBuilder().append("lastuser(").append(tnick.getText()).append(")").toString();
            final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < 5; i++) {
                bufferedwriter.write(strings[i]);
                bufferedwriter.newLine();
            }
            bufferedwriter.close();
        } catch (final Exception exception) {

        }
    }

    private void setupini() {
        Madness.inisetup = true;
        try {
            final File file = new File(
                    new StringBuilder().append("").append(Madness.fpath).append("Madness.ini").toString());
            if (file.exists()) {
                final String[] strings = new String[40];
                int i = 0;
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string;
                for (; (string = bufferedreader.readLine()) != null && i < 40; i++) {
                    strings[i] = string;
                    if (strings[i].startsWith("Class Path"))
                        if (strings[i].indexOf("madapps.jar") != -1)
                            strings[i] = "Class Path=\\data\\madapps.jar;";
                        else
                            strings[i] = "Class Path=\\data\\madapp.jar;";
                    if (strings[i].startsWith("JRE Path"))
                        strings[i] = "JRE Path=data\\jre\\";
                }
                bufferedreader.close();
                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                for (int i210 = 0; i210 < i; i210++) {
                    bufferedwriter.write(strings[i210]);
                    bufferedwriter.newLine();
                }
                bufferedwriter.close();
            }
        } catch (final Exception exception) {

        }
        Madness.inisetup = false;
    }

    private void sizescreen(final int i, final int i207) {
        if (i > getWidth() / 2 - 230 && i < getWidth() / 2 - 68 && i207 > 21 && i207 < 39 || onbar) {
            reqmult = (i - (getWidth() / 2 - 222)) / 141.0F;
            if (reqmult < 0.1)
                reqmult = 0.0F;
            if (reqmult > 1.0F)
                reqmult = 1.0F;
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
            if (e.getKeyCode() == KeyEvent.VK_UP)
                u[0].up = true;
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                u[0].down = true;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                u[0].right = true;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                u[0].left = true;
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
                u[0].handb = true;
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
                u[0].enter = true;
            if (e.getKeyCode() == KeyEvent.VK_Z)
                u[0].lookback = -1;
            if (e.getKeyCode() == KeyEvent.VK_X)
                u[0].lookback = 1;
            if (e.getKeyCode() == KeyEvent.VK_M)
                if (u[0].mutem)
                    u[0].mutem = false;
                else
                    u[0].mutem = true;
            if (e.getKeyCode() == KeyEvent.VK_N)
                if (u[0].mutes)
                    u[0].mutes = false;
                else
                    u[0].mutes = true;
            if (e.getKeyCode() == KeyEvent.VK_A)
                if (u[0].arrace)
                    u[0].arrace = false;
                else
                    u[0].arrace = true;
            if (e.getKeyCode() == KeyEvent.VK_S)
                if (u[0].radar)
                    u[0].radar = false;
                else
                    u[0].radar = true;
            if (e.getKeyCode() == KeyEvent.VK_V) {
                view++;
                if (view == 3)
                    view = 0;
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        if (!exwist) {
            if (u[0].multion < 2) {
                if (e.getKeyCode() == KeyEvent.VK_UP)
                    u[0].up = false;
                if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    u[0].down = false;
                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                    u[0].right = false;
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    u[0].left = false;
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                    u[0].handb = false;
            }
            if (e.getKeyCode() == 27) {
                u[0].exit = false;
                if (Madness.fullscreen)
                    Madness.exitfullscreen();
            }
            if (e.getKeyCode() == KeyEvent.VK_X || e.getKeyCode() == KeyEvent.VK_Z)
                u[0].lookback = 0;
        }
    }

    @Override
    public void mouseDragged(final MouseEvent e) {
        final int i = e.getX();
        final int i206 = e.getY();
        if (!exwist && !lostfcs) {
            xm = (int) ((i - apx) / apmult);
            ym = (int) ((i206 - apy) / apmult);
        }
        if (!Madness.fullscreen)
            sizescreen(i, i206);
    }

    @Override
    public void mouseMoved(final MouseEvent e) {
        final int i = e.getX();
        final int i205 = e.getY();
        if (!exwist && !lostfcs) {
            xm = (int) ((i - apx) / apmult);
            ym = (int) ((i205 - apy) / apmult);
        }
        if (!Madness.fullscreen) {
            if (showsize < 20)
                showsize = 20;
            if (i > 50 && i < 192 && i205 > 14 && i205 < 37) {
                if (!oncarm) {
                    oncarm = true;
                    setCursor(new Cursor(12));
                }
            } else if (oncarm) {
                oncarm = false;
                setCursor(new Cursor(0));
            }
            if (i > getWidth() - 208 && i < getWidth() - 50 && i205 > 14 && i205 < 37) {
                if (!onstgm) {
                    onstgm = true;
                    setCursor(new Cursor(12));
                }
            } else if (onstgm) {
                onstgm = false;
                setCursor(new Cursor(0));
            }
            if (i > getWidth() / 2 + 22 && i < getWidth() / 2 + 122 && i205 > 14 && i205 < 37) {
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
        final int i = e.getX();
        final int i204 = e.getY();
        requestFocus();
        if (!exwist) {
            if (mouses == 0) {
                xm = (int) ((i - apx) / apmult);
                ym = (int) ((i204 - apy) / apmult);
                mouses = 1;
            }
            moused = true;
        }
        if (!Madness.fullscreen)
            sizescreen(i, i204);
    }

    @Override
    public void mouseReleased(final MouseEvent e) {
        final int i = e.getX();
        final int i203 = e.getY();
        if (!exwist) {
            if (mouses == 11) {
                xm = (int) ((i - apx) / apmult);
                ym = (int) ((i203 - apy) / apmult);
                mouses = -1;
            }
            moused = false;
        }
        if (!Madness.fullscreen) {
            if (i > getWidth() / 2 - 55 && i < getWidth() / 2 + 7 && i203 > 21 && i203 < 38 && !onbar) {
                if (smooth == 1)
                    smooth = 0;
                else
                    smooth = 1;
                showsize = 60;
            }
            if (i > getWidth() / 2 + 133 && i < getWidth() / 2 + 231 && i203 > 7 && i203 < 24 && !onbar) {
                if (Madness.anti == 0)
                    Madness.anti = 1;
                else
                    Madness.anti = 0;
                showsize = 60;
            }
            if (i > getWidth() / 2 + 133 && i < getWidth() / 2 + 231 && i203 > 24 && i203 < 41 && !onbar) {
                if (moto == 0)
                    moto = 1;
                else
                    moto = 0;
                showsize = 60;
            }
            if (onfulls)
                Madness.gofullscreen();
            if (oncarm)
                Madness.carmaker();
            if (onstgm)
                Madness.stagemaker();
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
    public void focusGained(FocusEvent e) {
        if (!exwist && lostfcs)
            lostfcs = false;
   }

    @Override
    public void focusLost(FocusEvent e) {
        if (!exwist && !lostfcs) {
            lostfcs = true;
            fcscnt = 10;
            if (u[0] != null) {
                if (u[0].multion == 0)
                    u[0].falseo(1);
                else if (u[0].chatup == 0)
                    requestFocus();
                setCursor(new Cursor(0));
            }
        }
    }

}
