package stagemaker;

/* xtGraphics - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
public class xtGraphics extends Panel implements Runnable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2461918784700689955L;
	Graphics2D rd;
    Medium m;
    CarDefine cd;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker app;
    int fase = 111;
    int oldfase = 0;
    int starcnt = 0;
    boolean mtop = false;
    int opselect = 1;
    int dropf = 0;
    int cfase = 0;
    boolean firstime = true;
    boolean shaded = false;
    int flipo = 0;
    int nextc = 0;
    int multion = 0;
    int gmode = 0;
    int[] unlocked = { 1, 1 };
    int[] scm = { 0, 0 };
    int looped = 1;
    int warning = 0;
    boolean newparts = false;
    boolean logged = false;
    boolean gotlog = false;
    boolean autolog = false;
    boolean nofull = false;
    int nfreeplays = 0;
    int ndisco = 0;
    int hours = 8;
    int playingame = -1;
    int onjoin = -1;
    int ontyp = 0;
    boolean lan = false;
    float[] arnp = { 0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F };
    String nickname = "";
    String nickey = "";
    String backlog = "";
    String server = "multiplayer.needformadness.com";
    String localserver = "";
    String servername = "Madness";
    int servport = 7071;
    int gameport = 7001;
    int acexp = 0;
    int discon = 0;
    int cntptrys = 5;
    int[] delays = { 600, 600, 600, 600 };
    int nplayers = 7;
    int im = 0;
    String[] plnames = { "", "", "", "", "", "", "" };
    int osc = 10;
    int minsl = 0;
    int maxsl = 15;
    int[] sc = { 0, 0, 0, 0, 0, 0, 0 };
    int[] xstart = { 0, -350, 350, 0, -350, 350, 0 };
    int[] zstart = { -760, -380, -380, 0, 380, 380, 760 };
    float[][] allrnp = new float[7][6];
    boolean[] isbot = new boolean[7];
    int testdrive = 0;
    boolean holdit = false;
    int holdcnt = 0;
    boolean winner = true;
    int[] flexpix = null;
    int[] smokey = new int[94132];
    Image fleximg;
    int flatrstart = 0;
    Thread runner;
    int runtyp = 0;
    int forstart = 0;
    int exitm = 0;
    Image odmg;
    Image opwr;
    Image opos;
    Image owas;
    Image olap;
    Image oyourwasted;
    Image odisco;
    Image ogamefinished;
    Image oyoulost;
    Image oyouwon;
    Image oyouwastedem;
    Image ogameh;
    Image owgame;
    Image oloadingmusic;
    Image oflaot;
    Image oexitgame;
    Image mload;
    Image dmg;
    Image pwr;
    Image pos;
    Image was;
    Image lap;
    Image br;
    Image select;
    Image loadingmusic;
    Image yourwasted;
    Image disco;
    Image gamefinished;
    Image youlost;
    Image youwon;
    Image youwastedem;
    Image gameh;
    Image wgame;
    Image congrd;
    Image gameov;
    Image carsbg;
    Image carsbgc;
    Image selectcar;
    Image statb;
    Image statbo;
    Image mdness;
    Image paused;
    Image radicalplay;
    Image logocars;
    Image logomadnes;
    Image logomadbg;
    Image byrd;
    Image byrd2;
    Image opback;
    Image nfmcoms;
    Image nfmcoms2;
    Image opti;
    Image opti2;
    Image bgmain;
    Image rpro;
    Image nfmcom;
    Image flaot;
    Image brt;
    Image arn;
    Image mrc;
    Image exitgame;
    Image pgate;
    Image fixhoop;
    Image sarrow;
    Image stunts;
    Image racing;
    Image wasting;
    Image plus;
    Image space;
    Image arrows;
    Image chil;
    Image ory;
    Image kz;
    Image kx;
    Image kv;
    Image km;
    Image kn;
    Image kenter;
    Image nfm;
    Image login;
    Image register;
    Image play;
    Image sdets;
    Image cancel;
    Image multim;
    Image bob;
    Image bot;
    Image bol;
    Image bolp;
    Image bor;
    Image borp;
    Image logout;
    Image change;
    Image pln;
    Image pon;
    Image filb;
    Image dome;
    Image upgrade;
    Image bols;
    Image bolps;
    Image bors;
    Image borps;
    Image games;
    Image exit;
    Image chat;
    Image players;
    Image cgame;
    Image ccar;
    Image lanm;
    Image asu;
    Image asd;
    Image pls;
    Image sts;
    Image gmc;
    Image stg;
    Image crd;
    Image roomp;
    Image myfr;
    Image mycl;
    Image cnmc;
    Image[] bcl = new Image[2];
    Image[] bcr = new Image[2];
    Image[] bc = new Image[2];
    Image cmc;
    Image myc;
    Image gac;
    Image yac;
    Image ycmc;
    Image[] trackbg = new Image[2];
    Image[] dude = new Image[3];
    int duds = 0;
    int dudo = 0;
    Image[] next = new Image[2];
    Image[] back = new Image[2];
    Image[] contin = new Image[2];
    Image[] ostar = new Image[2];
    Image[] star = new Image[3];
    int pcontin = 0;
    int pnext = 0;
    int pback = 0;
    int pstar = 0;
    Image[] orank = new Image[7];
    Image[] rank = new Image[7];
    Image[] ocntdn = new Image[4];
    Image[] cntdn = new Image[4];
    int gocnt = 0;
    soundClip[][] engs = new soundClip[5][5];
    boolean[] pengs = new boolean[5];
    soundClip[] air = new soundClip[6];
    boolean aird = false;
    boolean grrd = false;
    soundClip[] crash = new soundClip[3];
    soundClip[] lowcrash = new soundClip[3];
    soundClip tires;
    soundClip checkpoint;
    soundClip carfixed;
    soundClip powerup;
    soundClip three;
    soundClip two;
    soundClip one;
    soundClip go;
    soundClip wastd;
    soundClip firewasted;
    boolean pwastd = false;
    soundClip[] skid = new soundClip[3];
    soundClip[] dustskid = new soundClip[3];
    soundClip[] scrape = new soundClip[4];
    boolean mutes = false;
    RadicalMod intertrack;
    RadicalMod strack;
    boolean loadedt = false;
    boolean mutem = false;
    boolean macn = false;
    boolean badmac = false;
    boolean arrace = false;
    int alocked = -1;
    int lalocked = -1;
    int cntflock = 0;
    boolean onlock = false;
    int ana = 0;
    int cntan = 0;
    int cntovn = 0;
    boolean flk = false;
    int tcnt = 30;
    boolean tflk = false;
    String say = "";
    boolean wasay = false;
    int clear = 0;
    int posit = 0;
    int wasted = 0;
    int laps = 0;
    int[] dested = { 0, 0, 0, 0, 0, 0, 0 };
    int dmcnt = 0;
    boolean dmflk = false;
    int pwcnt = 0;
    boolean pwflk = false;
    String[][] adj = { { "Cool", "Alright", "Nice" }, { "Wicked", "Amazing", "Super" }, { "Awesome", "Ripping", "Radical" }, { "What the...?", "You're a super star!!!!", "Who are you again...?" }, { "surf style", "off the lip", "bounce back" } };
    String[] exlm = { "!", "!!", "!!!" };
    String loop = "";
    String spin = "";
    String asay = "";
    int auscnt = 45;
    boolean aflk = false;
    int[] sndsize = { 39, 128, 23, 58, 106, 140, 81, 135, 38, 141, 106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129, 80, 44, 57, 123, 202, 210, 111 };
    Image hello;
    Image sign;
    Image loadbar;
    int kbload = 0;
    int dnload = 0;
    float shload = 0.0F;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    int brl = 10;
    boolean fbrl = false;
    int radpx = 212;
    int pin = 60;
    int[] trkx = { 65, 735 };
    int trkl = 0;
    int trklim = (int) (Math.random() * 40.0);
    int lmode = 0;
    int[] bgmy = { 0, 400 };
    float bgf = 0.0F;
    boolean bgup = false;
    int[] ovx = { 0, 0, 0, 0 };
    int[] ovy = { 0, 0, 0, 0 };
    int[] ovw = { 0, 0, 0, 0 };
    int[] ovh = { 0, 0, 0, 0 };
    int[] ovsx = { 0, 0, 0, 0 };
    int removeds = 0;
    int nfmtab = 0;
    boolean justwon1 = false;
    boolean justwon2 = false;
    int lockcnt = 0;
    int ransay = 0;
    String[] cnames = { "", "", "", "", "", "", "No Messages  " };
    String[] sentn = { "", "", "", "", "", "", "" };
    int updatec = -1;
    int movepos = 0;
    int pointc = 6;
    int floater = 0;
    int cntchatp = 0;
    int msgflk = 0;
    String lcmsg = "";
    int flkat = (int) (60.0 + 140.0 * Math.random());
    int movly = (int) (100.0 + 100.0 * Math.random());
    int xdu = 337;
    int ydu = 27;
    int gxdu = 0;
    int gydu = 0;
    int muhi = 0;
    int lsc = -1;
    int mouson = -1;
    int onmsc = -1;
    boolean remi = false;
    int lfrom = 0;
    boolean noclass = false;
    int gatey = 300;
    int[] pgatx = { 211, 240, 280, 332, 399, 466, 517, 558, 586 };
    int[] pgaty = { 193, 213, 226, 237, 244, 239, 228, 214, 196 };
    int[] pgady = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    boolean[] pgas = { false, false, false, false, false, false, false, false, false };
    int waitlink = 0;
    int lxm = -10;
    int lym = -10;
    int pwait = 7;
    int stopcnt = 0;
    int cntwis = 0;
    int lcn = 0;
    int crshturn = 0;
    int bfcrash = 0;
    int bfskid = 0;
    boolean crashup = false;
    boolean skidup = false;
    int skflg = 0;
    int dskflg = 0;
    int bfscrape = 0;
    int sturn0 = 0;
    int sturn1 = 0;
    int bfsc1 = 0;
    int bfsc2 = 0;
    int flatr = 0;
    int flyr = 0;
    int flyrdest = 0;
    int flang = 0;
    
    public xtGraphics(Medium medium, CarDefine cardefine, Graphics2D graphics2d, GameSparker gamesparker) {
        m = medium;
        cd = cardefine;
        app = gamesparker;
        rd = graphics2d;
        hello = getImage("data/hello.gif");
        sign = getImage("data/sign.gif");
        loadbar = getImage("data/loadbar.gif");
        for (int i = 0; i < 5; i++)
            pengs[i] = false;
        nofull = false;
        SecurityManager securitymanager = System.getSecurityManager();
        if (securitymanager != null) {
            try {
                securitymanager.checkConnect("needformadness.com", -1);
            } catch (Exception exception) {
                String string = new StringBuilder().append("").append(exception).toString();
                if (string.indexOf("access denied") != -1)
                    nofull = true;
            }
        }
        macn = false;
        badmac = false;
        if (System.getProperty("os.name").indexOf("Mac") != -1)
            macn = true;
        if (macn) {
            String string = System.getProperty("os.version");
            if (string.startsWith("10.5") || string.startsWith("10.4") || string.startsWith("10.3") || string.startsWith("10.2"))
                badmac = true;
        }
    }
    
    public void loaddata() {
        kbload = 637;
        runtyp = 176;
        runner = new Thread(this);
        runner.start();
        loadimages();
        intertrack = new RadicalMod("music/interface.zip");
        dnload += 44;
        loadsounds();
    }
    
    public void loadsounds() {
        dnload += 3;
        try {
            File file = new File("data/sounds.zip");
            FileInputStream fileinputstream = new FileInputStream(file);
            ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
            for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = (int) zipentry.getSize();
                String string = zipentry.getName();
                byte[] is = new byte[i];
                int i_0_ = 0;
                int i_1_;
                for (/**/; i > 0; i -= i_1_) {
                    i_1_ = zipinputstream.read(is, i_0_, i);
                    i_0_ += i_1_;
                }
                for (int i_2_ = 0; i_2_ < 5; i_2_++) {
                    for (int i_3_ = 0; i_3_ < 5; i_3_++) {
                        if (string.equals(new StringBuilder().append("").append(i_3_).append("").append(i_2_).append(".wav").toString()))
                            engs[i_3_][i_2_] = new soundClip(is);
                    }
                }
                for (int i_4_ = 0; i_4_ < 6; i_4_++) {
                    if (string.equals(new StringBuilder().append("air").append(i_4_).append(".wav").toString()))
                        air[i_4_] = new soundClip(is);
                }
                for (int i_5_ = 0; i_5_ < 3; i_5_++) {
                    if (string.equals(new StringBuilder().append("crash").append(i_5_ + 1).append(".wav").toString()))
                        crash[i_5_] = new soundClip(is);
                }
                for (int i_6_ = 0; i_6_ < 3; i_6_++) {
                    if (string.equals(new StringBuilder().append("lowcrash").append(i_6_ + 1).append(".wav").toString()))
                        lowcrash[i_6_] = new soundClip(is);
                }
                for (int i_7_ = 0; i_7_ < 3; i_7_++) {
                    if (string.equals(new StringBuilder().append("skid").append(i_7_ + 1).append(".wav").toString()))
                        skid[i_7_] = new soundClip(is);
                }
                for (int i_8_ = 0; i_8_ < 3; i_8_++) {
                    if (string.equals(new StringBuilder().append("dustskid").append(i_8_ + 1).append(".wav").toString()))
                        dustskid[i_8_] = new soundClip(is);
                }
                for (int i_9_ = 0; i_9_ < 3; i_9_++) {
                    if (string.equals(new StringBuilder().append("scrape").append(i_9_ + 1).append(".wav").toString())) {
                        scrape[i_9_] = new soundClip(is);
                        if (i_9_ == 2)
                            scrape[3] = new soundClip(is);
                    }
                }
                if (string.equals("powerup.wav"))
                    powerup = new soundClip(is);
                if (string.equals("tires.wav"))
                    tires = new soundClip(is);
                if (string.equals("checkpoint.wav"))
                    checkpoint = new soundClip(is);
                if (string.equals("carfixed.wav"))
                    carfixed = new soundClip(is);
                if (string.equals("three.wav"))
                    three = new soundClip(is);
                if (string.equals("two.wav"))
                    two = new soundClip(is);
                if (string.equals("one.wav"))
                    one = new soundClip(is);
                if (string.equals("go.wav"))
                    go = new soundClip(is);
                if (string.equals("wasted.wav"))
                    wastd = new soundClip(is);
                if (string.equals("firewasted.wav"))
                    firewasted = new soundClip(is);
                dnload += 5;
            }
            fileinputstream.close();
            zipinputstream.close();
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Error Loading Sounds: ").append(exception).toString());
        }
        System.gc();
    }
    
    public void loadimages() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediatracker = new MediaTracker(app);
        Image image = null;
        Image image_10_ = null;
        dnload += 8;
        try {
            File file = new File("data/images.zip");
            FileInputStream fileinputstream = new FileInputStream(file);
            ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
            for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = (int) zipentry.getSize();
                String string = zipentry.getName();
                byte[] is = new byte[i];
                int i_11_ = 0;
                int i_12_;
                for (/**/; i > 0; i -= i_12_) {
                    i_12_ = zipinputstream.read(is, i_11_, i);
                    i_11_ += i_12_;
                }
                if (string.equals("cars.gif"))
                    carsbg = loadBimage(is, mediatracker, toolkit, 1);
                if (string.equals("color.gif"))
                    image = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("class.gif"))
                    image_10_ = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("smokey.gif"))
                    smokeypix(is, mediatracker, toolkit);
                if (string.equals("1.gif"))
                    orank[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("gameh.gif"))
                    ogameh = loadimage(is, mediatracker, toolkit);
                if (string.equals("wgame.gif"))
                    owgame = loadimage(is, mediatracker, toolkit);
                if (string.equals("gameov.gif"))
                    gameov = loadimage(is, mediatracker, toolkit);
                if (string.equals("lap.gif"))
                    olap = loadimage(is, mediatracker, toolkit);
                if (string.equals("paused.gif"))
                    paused = loadimage(is, mediatracker, toolkit);
                if (string.equals("select.gif"))
                    select = loadimage(is, mediatracker, toolkit);
                if (string.equals("yourwasted.gif"))
                    oyourwasted = loadimage(is, mediatracker, toolkit);
                if (string.equals("disco.gif"))
                    odisco = loadimage(is, mediatracker, toolkit);
                if (string.equals("youwastedem.gif"))
                    oyouwastedem = loadimage(is, mediatracker, toolkit);
                if (string.equals("gamefinished.gif"))
                    ogamefinished = loadimage(is, mediatracker, toolkit);
                if (string.equals("exitgame.gif"))
                    oexitgame = loadimage(is, mediatracker, toolkit);
                if (string.equals("pgate.gif"))
                    pgate = loadimage(is, mediatracker, toolkit);
                if (string.equals("d1.gif"))
                    dude[0] = loadude(is, mediatracker, toolkit);
                if (string.equals("d2.gif"))
                    dude[1] = loadude(is, mediatracker, toolkit);
                if (string.equals("d3.gif"))
                    dude[2] = loadude(is, mediatracker, toolkit);
                if (string.equals("float.gif"))
                    oflaot = loadimage(is, mediatracker, toolkit);
                if (string.equals("1c.gif"))
                    ocntdn[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("2c.gif"))
                    ocntdn[2] = loadimage(is, mediatracker, toolkit);
                if (string.equals("3c.gif"))
                    ocntdn[3] = loadimage(is, mediatracker, toolkit);
                if (string.equals("2.gif"))
                    orank[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("3.gif"))
                    orank[2] = loadimage(is, mediatracker, toolkit);
                if (string.equals("4.gif"))
                    orank[3] = loadimage(is, mediatracker, toolkit);
                if (string.equals("5.gif"))
                    orank[4] = loadimage(is, mediatracker, toolkit);
                if (string.equals("6.gif"))
                    orank[5] = loadimage(is, mediatracker, toolkit);
                if (string.equals("7.gif"))
                    orank[6] = loadimage(is, mediatracker, toolkit);
                if (string.equals("bgmain.jpg"))
                    bgmain = loadBimage(is, mediatracker, toolkit, 2);
                if (string.equals("br.gif"))
                    br = loadimage(is, mediatracker, toolkit);
                if (string.equals("loadingmusic.gif"))
                    oloadingmusic = loadimage(is, mediatracker, toolkit);
                if (string.equals("radicalplay.gif"))
                    radicalplay = loadimage(is, mediatracker, toolkit);
                if (string.equals("back.gif")) {
                    back[0] = loadimage(is, mediatracker, toolkit);
                    back[1] = bressed(back[0]);
                }
                if (string.equals("continue.gif")) {
                    contin[0] = loadimage(is, mediatracker, toolkit);
                    contin[1] = bressed(contin[0]);
                }
                if (string.equals("next.gif")) {
                    next[0] = loadimage(is, mediatracker, toolkit);
                    next[1] = bressed(next[0]);
                }
                if (string.equals("rpro.gif"))
                    rpro = loadimage(is, mediatracker, toolkit);
                if (string.equals("selectcar.gif"))
                    selectcar = loadimage(is, mediatracker, toolkit);
                if (string.equals("track.jpg")) {
                    trackbg[0] = loadBimage(is, mediatracker, toolkit, 3);
                    trackbg[1] = dodgen(trackbg[0]);
                }
                if (string.equals("youlost.gif"))
                    oyoulost = loadimage(is, mediatracker, toolkit);
                if (string.equals("youwon.gif"))
                    oyouwon = loadimage(is, mediatracker, toolkit);
                if (string.equals("0c.gif"))
                    ocntdn[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("damage.gif"))
                    odmg = loadimage(is, mediatracker, toolkit);
                if (string.equals("power.gif"))
                    opwr = loadimage(is, mediatracker, toolkit);
                if (string.equals("position.gif"))
                    opos = loadimage(is, mediatracker, toolkit);
                if (string.equals("wasted.gif"))
                    owas = loadimage(is, mediatracker, toolkit);
                if (string.equals("start1.gif"))
                    ostar[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("start2.gif")) {
                    ostar[1] = loadimage(is, mediatracker, toolkit);
                    star[2] = pressed(ostar[1]);
                }
                if (string.equals("congrad.gif"))
                    congrd = loadimage(is, mediatracker, toolkit);
                if (string.equals("statb.gif"))
                    statb = loadimage(is, mediatracker, toolkit);
                if (string.equals("statbo.gif"))
                    statbo = loadimage(is, mediatracker, toolkit);
                if (string.equals("madness.gif"))
                    mdness = loadude(is, mediatracker, toolkit);
                if (string.equals("mrc.gif"))
                    mrc = loadimage(is, mediatracker, toolkit);
                if (string.equals("fixhoop.gif"))
                    fixhoop = loadimage(is, mediatracker, toolkit);
                if (string.equals("arrow.gif"))
                    sarrow = loadimage(is, mediatracker, toolkit);
                if (string.equals("stunts.gif"))
                    stunts = loadimage(is, mediatracker, toolkit);
                if (string.equals("racing.gif"))
                    racing = loadimage(is, mediatracker, toolkit);
                if (string.equals("wasting.gif"))
                    wasting = loadimage(is, mediatracker, toolkit);
                if (string.equals("plus.gif"))
                    plus = loadimage(is, mediatracker, toolkit);
                if (string.equals("space.gif"))
                    space = loadimage(is, mediatracker, toolkit);
                if (string.equals("arrows.gif"))
                    arrows = loadimage(is, mediatracker, toolkit);
                if (string.equals("chil.gif"))
                    chil = loadimage(is, mediatracker, toolkit);
                if (string.equals("ory.gif"))
                    ory = loadimage(is, mediatracker, toolkit);
                if (string.equals("kz.gif"))
                    kz = loadimage(is, mediatracker, toolkit);
                if (string.equals("kx.gif"))
                    kx = loadimage(is, mediatracker, toolkit);
                if (string.equals("kv.gif"))
                    kv = loadimage(is, mediatracker, toolkit);
                if (string.equals("km.gif"))
                    km = loadimage(is, mediatracker, toolkit);
                if (string.equals("kn.gif"))
                    kn = loadimage(is, mediatracker, toolkit);
                if (string.equals("kenter.gif"))
                    kenter = loadimage(is, mediatracker, toolkit);
                if (string.equals("nfm.gif"))
                    nfm = loadimage(is, mediatracker, toolkit);
                if (string.equals("options.gif"))
                    opti = loadimage(is, mediatracker, toolkit);
                if (string.equals("options2.gif"))
                    opti2 = loadimage(is, mediatracker, toolkit);
                if (string.equals("opback.gif"))
                    opback = loadimage(is, mediatracker, toolkit);
                if (string.equals("logocars.gif"))
                    logocars = loadimage(is, mediatracker, toolkit);
                if (string.equals("logomadmess.gif"))
                    logomadnes = loadimage(is, mediatracker, toolkit);
                if (string.equals("logomadbg.gif"))
                    logomadbg = loadimage(is, mediatracker, toolkit);
                if (string.equals("byrd.gif"))
                    byrd = loadimage(is, mediatracker, toolkit);
                if (string.equals("byrd2.gif"))
                    byrd2 = loadimage(is, mediatracker, toolkit);
                if (string.equals("nfmcoms.gif"))
                    nfmcoms = loadimage(is, mediatracker, toolkit);
                if (string.equals("nfmcoms2.gif"))
                    nfmcoms2 = loadimage(is, mediatracker, toolkit);
                if (string.equals("nfmcom.gif"))
                    nfmcom = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("brit.gif"))
                    brt = loadimage(is, mediatracker, toolkit);
                if (string.equals("arn.gif"))
                    arn = loadimage(is, mediatracker, toolkit);
                if (string.equals("mload.gif"))
                    mload = loadimage(is, mediatracker, toolkit);
                if (string.equals("login.gif"))
                    login = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("play.gif"))
                    play = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("cancel.gif"))
                    cancel = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("multi.gif"))
                    multim = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("dome.gif"))
                    dome = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("register.gif"))
                    register = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("upgrade.gif"))
                    upgrade = loadimage(is, mediatracker, toolkit);
                if (string.equals("sdets.gif"))
                    sdets = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bob.gif"))
                    bob = loadBimage(is, mediatracker, toolkit, 1);
                if (string.equals("bot.gif"))
                    bot = loadBimage(is, mediatracker, toolkit, 1);
                if (string.equals("bol.gif"))
                    bol = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bolp.gif"))
                    bolp = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bor.gif"))
                    bor = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("borp.gif"))
                    borp = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("logout.gif"))
                    logout = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("change.gif"))
                    change = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("pln.gif"))
                    pln = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("pon.gif"))
                    pon = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("filb.gif"))
                    filb = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bols.gif"))
                    bols = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bolps.gif"))
                    bolps = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bors.gif"))
                    bors = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("borps.gif"))
                    borps = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("games.gif"))
                    games = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("exit.gif"))
                    exit = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("chat.gif"))
                    chat = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("players.gif"))
                    players = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("roomp.gif"))
                    roomp = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("myfr.gif"))
                    myfr = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("mycl.gif"))
                    mycl = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("cnmc.gif"))
                    cnmc = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("cgame.gif"))
                    cgame = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("ccar.gif"))
                    ccar = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("lanm.gif"))
                    lanm = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("asu.gif"))
                    asu = loadimage(is, mediatracker, toolkit);
                if (string.equals("asd.gif"))
                    asd = loadimage(is, mediatracker, toolkit);
                if (string.equals("pls.gif"))
                    pls = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("sts.gif"))
                    sts = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("gmc.gif"))
                    gmc = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("stg.gif"))
                    stg = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("crd.gif"))
                    crd = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bcl.gif"))
                    bcl[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("bcr.gif"))
                    bcr[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("bc.gif"))
                    bc[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("pbcl.gif"))
                    bcl[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("pbcr.gif"))
                    bcr[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("pbc.gif"))
                    bc[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("cmc.gif"))
                    cmc = loadimage(is, mediatracker, toolkit);
                if (string.equals("myc.gif"))
                    myc = loadimage(is, mediatracker, toolkit);
                if (string.equals("gac.gif"))
                    gac = loadimage(is, mediatracker, toolkit);
                if (string.equals("yac.gif"))
                    yac = loadimage(is, mediatracker, toolkit);
                if (string.equals("ycmc.gif"))
                    ycmc = loadimage(is, mediatracker, toolkit);
                dnload += 2;
            }
            fileinputstream.close();
            zipinputstream.close();
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Error Loading Images: ").append(exception).toString());
        }
        makecarsbgc(image, image_10_);
        System.gc();
    }
    
    public void run() {
        while (runtyp > 0) {
            if (runtyp >= 1 && runtyp <= 140)
                hipnoload(runtyp, false);
            if (runtyp == 176)
                loading();
            app.repaint();
            try {
                if (runner != null) {
                    /* empty */
                }
                Thread.sleep(20L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        boolean bool = true;
        while (runtyp == -101 && !lan) {
            String string = new StringBuilder().append("3|").append(playingame).append("|").append(updatec).append("|").toString();
            if (updatec <= -11) {
                for (int i = 0; i < -updatec - 10; i++)
                    string = new StringBuilder().append(string).append("").append(cnames[6 - i]).append("|").append(sentn[6 - i]).append("|").toString();
                updatec = -2;
            }
            String string_13_ = "";
            boolean bool_14_ = false;
            try {
                dout.println(string);
                string_13_ = din.readLine();
                if (string_13_ == null)
                    bool_14_ = true;
            } catch (Exception exception) {
                bool_14_ = true;
            }
            if (bool_14_) {
                try {
                    socket.close();
                    socket = null;
                    din.close();
                    din = null;
                    dout.close();
                    dout = null;
                } catch (Exception exception) {
                    /* empty */
                }
                try {
                    socket = new Socket(server, servport);
                    din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    dout = new PrintWriter(socket.getOutputStream(), true);
                    dout.println(string);
                    string_13_ = din.readLine();
                    if (string_13_ != null)
                        bool_14_ = false;
                } catch (Exception exception) {
                    /* empty */
                }
            }
            if (bool_14_) {
                try {
                    socket.close();
                    socket = null;
                } catch (Exception exception) {
                    /* empty */
                }
                runtyp = 0;
                if ((app).cmsg.isShowing()) {
                    (app).cmsg.hide();
                    app.requestFocus();
                }
                runner.stop();
            }
            int i = getvalue(string_13_, 0);
            if (updatec != i && updatec >= -2) {
                for (int i_15_ = 0; i_15_ < 7; i_15_++) {
                    cnames[i_15_] = getSvalue(string_13_, 1 + i_15_ * 2);
                    sentn[i_15_] = getSvalue(string_13_, 2 + i_15_ * 2);
                }
                if (cnames[6].equals(""))
                    cnames[6] = "No Messages  ";
                if (updatec != -2) {
                    if (pointc != 6) {
                        pointc = 6;
                        floater = 1;
                    }
                    if (bool) {
                        msgflk = 67;
                        bool = false;
                    } else
                        msgflk = 110;
                }
                updatec = i;
            }
            try {
                if (runner != null) {
                    /* empty */
                }
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        if (runtyp == -167 || runtyp == -168) {
            try {
                socket = new Socket("multiplayer.needformadness.com", 7061);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
                dout.println(new StringBuilder().append("101|").append(runtyp + 174).append("|").append((app).tnick.getText()).append("|").append((app).tpass.getText()).append("|").toString());
                din.readLine();
                socket.close();
                socket = null;
                din.close();
                din = null;
                dout.close();
                dout = null;
            } catch (Exception exception) {
                /* empty */
            }
            runtyp = 0;
        }
    }
    
    public void sendwin(CheckPoints checkpoints) {
        if (logged && multion == 1 && winner) {
            if ((checkpoints).wasted == nplayers - 1)
                runtyp = -167;
            else
                runtyp = -168;
            runner = new Thread(this);
            runner.start();
        }
    }
    
    public void loading() {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 800, 450);
        rd.drawImage(sign, 362, 35, this);
        rd.drawImage(hello, 125, 105, this);
        rd.setColor(new Color(198, 214, 255));
        rd.fillRoundRect(250, 340, 300, 80, 30, 70);
        rd.setColor(new Color(128, 167, 255));
        rd.drawRoundRect(250, 340, 300, 80, 30, 70);
        rd.drawImage(loadbar, 281, 365, this);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(358, "Loading game, please wait.", 0, 0, 0, 3);
        rd.setColor(new Color(255, 255, 255));
        rd.fillRect(295, 398, 210, 17);
        shload += ((float) dnload + 10.0F - shload) / 100.0F;
        if (shload > (float) kbload)
            shload = (float) kbload;
        if (dnload == kbload)
            shload = (float) kbload;
        drawcs(410, new StringBuilder().append("").append((int) ((26.0F + shload / (float) kbload * 200.0F) / 226.0F * 100.0F)).append(" % loaded    |    ").append(kbload - (int) shload).append(" KB remaining").toString(), 32, 64, 128, 3);
        rd.setColor(new Color(32, 64, 128));
        rd.fillRect(287, 371, 26 + (int) (shload / (float) kbload * 200.0F), 10);
    }
    
    public void stoploading() {
        loading();
        app.repaint();
        runner.stop();
        runner = null;
        runtyp = 0;
    }
    
    public void clicknow() {
        rd.setColor(new Color(198, 214, 255));
        rd.fillRoundRect(250, 340, 300, 80, 30, 70);
        rd.setColor(new Color(128, 167, 255));
        rd.drawRoundRect(250, 340, 300, 80, 30, 70);
        if (aflk) {
            drawcs(380, "Click here to Start", 0, 0, 0, 3);
            aflk = false;
        } else {
            drawcs(380, "Click here to Start", 0, 67, 200, 3);
            aflk = true;
        }
    }
    
    public void stopallnow() {
        if (runner != null) {
            runner.stop();
            runner = null;
        }
        runtyp = 0;
        if (loadedt) {
            strack.unload();
            strack = null;
            loadedt = false;
        }
        for (int i = 0; i < 5; i++) {
            for (int i_16_ = 0; i_16_ < 5; i_16_++) {
                engs[i][i_16_].stop();
                engs[i][i_16_] = null;
            }
        }
        for (int i = 0; i < 6; i++) {
            air[i].stop();
            air[i] = null;
        }
        wastd.stop();
        intertrack.unload();
        intertrack = null;
    }
    
    public void resetstat(int i) {
        arrace = false;
        alocked = -1;
        lalocked = -1;
        cntflock = 90;
        onlock = false;
        ana = 0;
        cntan = 0;
        cntovn = 0;
        tcnt = 30;
        wasay = false;
        clear = 0;
        dmcnt = 0;
        pwcnt = 0;
        auscnt = 45;
        pnext = 0;
        pback = 0;
        starcnt = 130;
        gocnt = 3;
        grrd = true;
        aird = true;
        bfcrash = 0;
        bfscrape = 0;
        cntwis = 0;
        bfskid = 0;
        pwait = 7;
        forstart = 200;
        exitm = 0;
        holdcnt = 0;
        holdit = false;
        winner = false;
        wasted = 0;
        for (int i_17_ = 0; i_17_ < 7; i_17_++) {
            dested[i_17_] = 0;
            isbot[i_17_] = false;
        }
        runtyp = 0;
        discon = 0;
        dnload = 0;
        if (fase == 2 || fase == -22)
            sortcars(i);
        if (fase == 22) {
            for (int i_18_ = 0; i_18_ < 7; i_18_++) {
                cnames[i_18_] = "";
                sentn[i_18_] = "";
            }
            cnames[6] = "No Messages  ";
            updatec = -1;
            movepos = 0;
            pointc = 6;
            floater = 0;
            cntchatp = 0;
            msgflk = 0;
            lcmsg = "";
            if (multion == 3)
                ransay = 4;
            else
                ransay = 1 + (int) (Math.random() * 3.0);
        }
    }
    
    public void setbots(boolean[] bools, int[][] is) {
        for (int i = 0; i < nplayers; i++) {
            if (plnames[i].indexOf("MadBot") != -1) {
                bools[i] = true;
                isbot[i] = true;
            }
        }
    }
    
    public void rad(int i) {
        if (i == 0) {
            powerup.play();
            radpx = 212;
            pin = 0;
        }
        trackbg(false);
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(65, 135, 670, 59);
        if (pin != 0)
            rd.drawImage(radicalplay, radpx + (int) (8.0 * Math.random() - 4.0), 135, null);
        else
            rd.drawImage(radicalplay, 212, 135, null);
        if (radpx != 212) {
            radpx += 40;
            if (radpx > 735)
                radpx = -388;
        } else if (pin != 0)
            pin--;
        if (i == 40) {
            radpx = 213;
            pin = 7;
        }
        if (radpx == 212) {
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(185 + (int) (5.0F * m.random()), "Radicalplay.com", 112, 120, 143, 3);
        }
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        if (aflk) {
            drawcs(215, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            aflk = false;
        } else {
            drawcs(217, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            aflk = true;
        }
        rd.drawImage(rpro, 275, 265, null);
        brl = 10;
        fbrl = false;
        rd.setColor(new Color(brl * 2, brl, 0));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }
    
    public void credits(Control control, int i, int i_19_, int i_20_) {
        if (flipo == 0) {
            powerup.play();
            flipo = 1;
        }
        if (flipo >= 1 && flipo <= 100) {
            rad(flipo);
            flipo++;
            if (flipo == 100)
                flipo = 1;
        }
        if (flipo == 101) {
            mainbg(-1);
            rd.drawImage(mdness, 283, 32, null);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(90, "At Radicalplay.com", 0, 0, 0, 3);
            drawcs(165, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            drawcs(185, "Everything By Omar Waly", 40, 60, 0, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(245, "Special Thanks!", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(265, "Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.", 66, 98, 0, 3);
            drawcs(280, "Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.", 66, 98, 0, 3);
            drawcs(295, "Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.", 66, 98, 0, 3);
            drawcs(310, "A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!", 66, 98, 0, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(365, "Most of the tracks where remixed by Omar Waly to match the game.", 66, 98, 0, 3);
            drawcs(380, "More details about the tracks and their original composers at:", 66, 98, 0, 3);
            drawcs(395, "http://multiplayer.needformadness.com/music.html", 33, 49, 0, 3);
            rd.drawLine(400 - ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2, 396, ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2 + 400, 396);
            if (i > 258 && i < 542 && i_19_ > 385 && i_19_ < 399) {
                app.setCursor(new Cursor(12));
                if (i_20_ == 2)
                    app.musiclink();
            } else
                app.setCursor(new Cursor(0));
        }
        if (flipo == 102) {
            mainbg(0);
            rd.drawImage(nfmcom, 190, 195, null);
            if (i > 190 && i < 609 && i_19_ > 195 && i_19_ < 216) {
                app.setCursor(new Cursor(12));
                if (i_20_ == 2)
                    app.madlink();
            } else
                app.setCursor(new Cursor(0));
        }
        if (flipo == 103) {
            mainbg(-1);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(90, "At Radicalplay.com", 0, 0, 0, 3);
            drawcs(165, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            drawcs(185, "Everything By Omar Waly", 40, 60, 0, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(245, "Special Thanks!", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(265, "Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.", 66, 98, 0, 3);
            drawcs(280, "Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.", 66, 98, 0, 3);
            drawcs(295, "Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.", 66, 98, 0, 3);
            drawcs(310, "A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!", 66, 98, 0, 3);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            drawcs(365, "Most of the tracks where remixed by Omar Waly to match the game.", 66, 98, 0, 3);
            drawcs(380, "More details about the tracks and their original composers at:", 66, 98, 0, 3);
            drawcs(395, "http://multiplayer.needformadness.com/music.html", 33, 49, 0, 3);
            rd.drawLine(400 - ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2, 396, ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2 + 400, 396);
        }
        rd.drawImage(next[pnext], 665, 395, null);
        if ((control).enter || (control).handb || (control).right) {
            if (flipo >= 1 && flipo <= 100) {
                flipo = 101;
                app.setCursor(new Cursor(0));
            } else
                flipo++;
            if (flipo == 104) {
                flipo = 0;
                fase = 10;
            }
            (control).enter = false;
            (control).handb = false;
            (control).right = false;
        }
    }
    
    public void trackbg(boolean bool) {
        int i = 0;
        trkl++;
        if (trkl > trklim) {
            i = 1;
            trklim = (int) (Math.random() * 40.0);
            trkl = 0;
        }
        if (bool)
            i = 0;
        for (int i_21_ = 0; i_21_ < 2; i_21_++) {
            rd.drawImage(trackbg[i], trkx[i_21_], 25, null);
            trkx[i_21_] -= 10;
            if (trkx[i_21_] <= -605)
                trkx[i_21_] = 735;
        }
        if (!fbrl) {
            brl++;
            if (brl >= 50) {
                brl = 50;
                fbrl = true;
            }
        } else {
            brl--;
            if (brl <= 10) {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(brl * 2, brl, 0));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }
    
    public void mainbg(int i) {
        int i_22_ = 2;
        rd.setColor(new Color(191, 184, 124));
        if (i == -1) {
            if (i != lmode) {
                bgmy[0] = 0;
                bgmy[1] = 400;
                bgup = false;
                bgf = 0.0F;
                lmode = i;
            }
            rd.setColor(new Color(144, 222, 9));
            i_22_ = 8;
        }
        if (i == 0) {
            if (i != lmode) {
                bgmy[0] = 0;
                bgmy[1] = 400;
                bgup = false;
                bgf = 0.0F;
                lmode = i;
            }
            int i_23_ = (int) (255.0F * bgf + 191.0F * (1.0F - bgf));
            int i_24_ = (int) (176.0F * bgf + 184.0F * (1.0F - bgf));
            int i_25_ = (int) (67.0F * bgf + 124.0F * (1.0F - bgf));
            if (!bgup) {
                bgf += 0.02F;
                if (bgf > 0.9F) {
                    bgf = 0.9F;
                    bgup = true;
                }
            } else {
                bgf -= 0.02F;
                if (bgf < 0.2F) {
                    bgf = 0.2F;
                    bgup = false;
                }
            }
            rd.setColor(new Color(i_23_, i_24_, i_25_));
            i_22_ = 4;
        }
        if (i == 1) {
            if (i != lmode) {
                bgmy[0] = 0;
                bgmy[1] = 400;
                lmode = i;
            }
            rd.setColor(new Color(255, 176, 67));
            i_22_ = 8;
        }
        if (i == 2) {
            if (i != lmode) {
                bgmy[0] = 0;
                bgmy[1] = 400;
                lmode = i;
                bgf = 0.2F;
            }
            rd.setColor(new Color(188, 170, 122));
            if (flipo == 16) {
                int i_26_ = (int) (176.0F * bgf + 191.0F * (1.0F - bgf));
                int i_27_ = (int) (202.0F * bgf + 184.0F * (1.0F - bgf));
                int i_28_ = (int) (255.0F * bgf + 124.0F * (1.0F - bgf));
                rd.setColor(new Color(i_26_, i_27_, i_28_));
                bgf += 0.025F;
                if (bgf > 0.85F)
                    bgf = 0.85F;
            } else
                bgf = 0.2F;
            i_22_ = 2;
        }
        if (i == 3) {
            if (i != lmode) {
                bgmy[0] = 0;
                bgmy[1] = 400;
                bgup = false;
                bgf = 0.0F;
                lmode = i;
            }
            int i_29_ = (int) (255.0F * bgf + 191.0F * (1.0F - bgf));
            int i_30_ = (int) (176.0F * bgf + 184.0F * (1.0F - bgf));
            int i_31_ = (int) (67.0F * bgf + 124.0F * (1.0F - bgf));
            if (!bgup) {
                bgf += 0.02F;
                if (bgf > 0.9F) {
                    bgf = 0.9F;
                    bgup = true;
                }
            } else {
                bgf -= 0.02F;
                if (bgf < 0.2F) {
                    bgf = 0.2F;
                    bgup = false;
                }
            }
            rd.setColor(new Color(i_29_, i_30_, i_31_));
            i_22_ = 2;
        }
        rd.fillRect(65, 25, 670, 400);
        if (i == 4) {
            if (i != lmode) {
                bgmy[0] = 0;
                bgmy[1] = 400;
                for (int i_32_ = 0; i_32_ < 4; i_32_++) {
                    ovw[i_32_] = (int) (50.0 + 150.0 * Math.random());
                    ovh[i_32_] = (int) (50.0 + 150.0 * Math.random());
                    ovy[i_32_] = (int) (400.0 * Math.random());
                    ovx[i_32_] = (int) (Math.random() * 670.0);
                    ovsx[i_32_] = (int) (5.0 + Math.random() * 10.0);
                }
                lmode = i;
            }
            for (int i_33_ = 0; i_33_ < 4; i_33_++) {
                rd.setColor(new Color(223, 180, 95));
                rd.fillOval((int) ((double) (65 + ovx[i_33_]) - (double) ovw[i_33_] * 1.5 / 2.0), (int) ((double) (25 + ovy[i_33_]) - (double) ovh[i_33_] * 1.5 / 2.0), (int) ((double) ovw[i_33_] * 1.5), (int) ((double) ovh[i_33_] * 1.5));
                rd.setColor(new Color(255, 176, 67));
                rd.fillOval(65 + ovx[i_33_] - ovh[i_33_] / 2, 25 + ovy[i_33_] - ovh[i_33_] / 2, ovw[i_33_], ovh[i_33_]);
                ovx[i_33_] -= ovsx[i_33_];
                if ((double) ovx[i_33_] + (double) ovw[i_33_] * 1.5 / 2.0 < 0.0) {
                    ovw[i_33_] = (int) (50.0 + 150.0 * Math.random());
                    ovh[i_33_] = (int) (50.0 + 150.0 * Math.random());
                    ovy[i_33_] = (int) (400.0 * Math.random());
                    ovx[i_33_] = (int) (670.0 + (double) ovw[i_33_] * 1.5 / 2.0);
                    ovsx[i_33_] = (int) (5.0 + Math.random() * 10.0);
                }
            }
            i_22_ = 4;
        }
        for (int i_34_ = 0; i_34_ < 2; i_34_++) {
            if (i != 2 || flipo != 16)
                rd.drawImage(bgmain, 65, 25 + bgmy[i_34_], null);
            bgmy[i_34_] -= i_22_;
            if (bgmy[i_34_] <= -400)
                bgmy[i_34_] = 400;
        }
        if (!fbrl) {
            brl++;
            if (brl >= 50) {
                brl = 50;
                fbrl = true;
            }
        } else {
            brl--;
            if (brl <= 10) {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(brl * 2, brl, 0));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
    }
    
    public void inishstageselect(CheckPoints checkpoints) {
        if ((checkpoints).stage == -2 && ((cd).msloaded != 1 || !logged)) {
            (checkpoints).stage = (int) (Math.random() * 27.0) + 1;
            (checkpoints).top20 = 0;
        }
        if ((checkpoints).stage > 27)
            (checkpoints).stage = (int) (Math.random() * 27.0) + 1;
        if ((checkpoints).stage == -2) {
            boolean bool = false;
            for (int i = 1; i < (app).mstgs.getItemCount(); i++) {
                if ((app).mstgs.getItem(i).equals((checkpoints).name))
                    bool = true;
            }
            if (!bool)
                (checkpoints).stage = (int) (Math.random() * 27.0) + 1;
        }
        if (gmode == 1) {
            if (unlocked[0] != 11 || justwon1)
                (checkpoints).stage = unlocked[0];
            else if (winner || (checkpoints).stage > 11)
                (checkpoints).stage = (int) (Math.random() * 11.0) + 1;
            if ((checkpoints).stage == 11)
                (checkpoints).stage = 27;
        }
        if (gmode == 2) {
            if (unlocked[0] != 17 || justwon2)
                (checkpoints).stage = unlocked[1] + 10;
            else if (winner || (checkpoints).stage < 11)
                (checkpoints).stage = (int) (Math.random() * 17.0) + 11;
        }
        (app).sgame.setBackground(new Color(0, 0, 0));
        (app).sgame.setForeground(new Color(47, 179, 255));
        (app).snfm1.setBackground(new Color(0, 0, 0));
        (app).snfm1.setForeground(new Color(47, 179, 255));
        (app).snfm2.setBackground(new Color(0, 0, 0));
        (app).snfm2.setForeground(new Color(47, 179, 255));
        (app).mstgs.setBackground(new Color(0, 0, 0));
        (app).mstgs.setForeground(new Color(47, 179, 255));
        (app).gmode.setBackground(new Color(49, 49, 0));
        (app).gmode.setForeground(new Color(148, 167, 0));
        (app).sgame.removeAll();
        (app).sgame.add(rd, " NFM 1     ");
        (app).sgame.add(rd, " NFM 2     ");
        (app).sgame.add(rd, " My Stages ");
        (app).sgame.add(rd, " Weekly Top20 ");
        (app).sgame.add(rd, " Monthly Top20 ");
        (app).sgame.add(rd, " All Time Top20 ");
        (app).sgame.add(rd, " Stage Maker ");
        if ((checkpoints).stage > 0 && (checkpoints).stage <= 10) {
            (app).sgame.select(0);
            nfmtab = 0;
        }
        if ((checkpoints).stage > 10) {
            (app).sgame.select(1);
            nfmtab = 1;
        }
        if ((checkpoints).stage == -2) {
            (app).sgame.select(2);
            nfmtab = 2;
        }
        if ((checkpoints).stage == -1) {
            (app).sgame.select(6);
            nfmtab = 6;
        }
        removeds = 0;
        lfrom = 0;
        (cd).staction = 0;
        fase = 2;
    }
    
    public void loadingstage(int i, boolean bool) {
        trackbg(true);
        rd.drawImage(br, 65, 25, null);
        rd.setColor(new Color(212, 214, 138));
        rd.fillRoundRect(265, 201, 270, 26, 20, 40);
        rd.setColor(new Color(57, 64, 8));
        rd.drawRoundRect(265, 201, 270, 26, 20, 40);
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        drawcs(219, "Loading, please wait...", 58, 61, 17, 3);
        if (bool)
            rd.drawImage(select, 338, 35, null);
        rd.drawImage(byrd2, 72, 408, null);
        rd.drawImage(nfmcoms2, 532, 408, null);
        app.repaint();
        if ((cd).staction != 0) {
            (app).tnick.hide();
            (app).tpass.hide();
            (cd).staction = 0;
        }
        removeds = 0;
    }
    
    public void cantgo(Control control) {
        pnext = 0;
        trackbg(false);
        rd.drawImage(br, 65, 25, null);
        rd.drawImage(select, 338, 35, null);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(130, new StringBuilder().append("This stage will be unlocked when stage ").append(unlocked[gmode - 1]).append(" is complete!").toString(), 177, 177, 177, 3);
        for (int i = 0; i < 9; i++)
            rd.drawImage(pgate, 277 + i * 30, 215, null);
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        if (aflk) {
            drawcs(185, new StringBuilder().append("[ Stage ").append(unlocked[gmode - 1] + 1).append(" Locked ]").toString(), 255, 128, 0, 3);
            aflk = false;
        } else {
            drawcs(185, new StringBuilder().append("[ Stage ").append(unlocked[gmode - 1] + 1).append(" Locked ]").toString(), 255, 0, 0, 3);
            aflk = true;
        }
        rd.drawImage(back[pback], 370, 345, null);
        rd.drawImage(byrd2, 72, 408, null);
        rd.drawImage(nfmcoms2, 532, 408, null);
        lockcnt--;
        if (lockcnt == 0 || (control).enter || (control).handb || (control).left) {
            (control).left = false;
            (control).handb = false;
            (control).enter = false;
            fase = 1;
        }
    }
    
    public void stageselect(CheckPoints checkpoints, Control control, int i, int i_35_, boolean bool) {
        rd.drawImage(br, 65, 25, null);
        rd.drawImage(select, 338, 35, null);
        if (testdrive != 3 && testdrive != 4) {
            if ((checkpoints).stage > 0 && (cd).staction == 0) {
                if ((checkpoints).stage != 1 && ((checkpoints).stage != 11 || gmode != 2))
                    rd.drawImage(back[pback], 115, 135, null);
                if ((checkpoints).stage != 27)
                    rd.drawImage(next[pnext], 625, 135, null);
            }
            if (gmode == 0) {
                boolean bool_36_ = false;
                int i_37_ = 0;
                if (nfmtab != (app).sgame.getSelectedIndex()) {
                    nfmtab = (app).sgame.getSelectedIndex();
                    (app).snfm1.select(0);
                    (app).snfm2.select(0);
                    (app).mstgs.select(0);
                    app.requestFocus();
                    bool_36_ = true;
                }
                if ((cd).staction == 5) {
                    if (lfrom == 0) {
                        (cd).staction = 0;
                        removeds = 1;
                        bool_36_ = true;
                    } else {
                        (cd).onstage = (checkpoints).name;
                        (cd).staction = 2;
                        dnload = 2;
                    }
                    nickname = (app).tnick.getText();
                    nickey = (cd).tnickey;
                    app.setloggedcookie();
                    logged = true;
                    if ((cd).reco == 0)
                        acexp = 0;
                    if ((cd).reco > 10)
                        acexp = (cd).reco - 10;
                    if ((cd).reco == 3)
                        acexp = -1;
                }
                if (nfmtab == 2 && (cd).staction == 0 && removeds == 1)
                    (checkpoints).stage = -3;
                if ((app).openm && (cd).staction == 3) {
                    (app).tnick.hide();
                    (app).tpass.hide();
                    (cd).staction = 0;
                }
                int i_38_ = 0;
                (app).sgame.setSize(131, 22);
                if ((app).sgame.getSelectedIndex() == 0)
                    i_38_ = 400 - ((app).sgame.getWidth() + 6 + (app).snfm1.getWidth()) / 2;
                if ((app).sgame.getSelectedIndex() == 1)
                    i_38_ = 400 - ((app).sgame.getWidth() + 6 + (app).snfm2.getWidth()) / 2;
                if ((app).sgame.getSelectedIndex() == 2) {
                    (app).mstgs.setSize(338, 22);
                    if (bool_36_) {
                        if (logged) {
                            if ((cd).msloaded != 1) {
                                (app).mstgs.removeAll();
                                (app).mstgs.add(rd, "Loading your stages now, please wait...");
                                (app).mstgs.select(0);
                                i_37_ = 1;
                            }
                        } else {
                            (app).mstgs.removeAll();
                            (app).mstgs.add(rd, "Please login first to load your stages...");
                            (app).mstgs.select(0);
                            (cd).msloaded = 0;
                            lfrom = 0;
                            (cd).staction = 3;
                            tcnt = 0;
                            cntflock = 0;
                            (cd).reco = -2;
                        }
                    }
                    i_38_ = 400 - ((app).sgame.getWidth() + 6 + (app).mstgs.getWidth()) / 2;
                }
                if ((app).sgame.getSelectedIndex() == 3) {
                    (app).mstgs.setSize(338, 22);
                    if (bool_36_ && (cd).msloaded != 3) {
                        (app).mstgs.removeAll();
                        (app).mstgs.add(rd, "Loading Top20 list, please wait...");
                        (app).mstgs.select(0);
                        i_37_ = 3;
                    }
                    i_38_ = 400 - ((app).sgame.getWidth() + 6 + (app).mstgs.getWidth()) / 2;
                }
                if ((app).sgame.getSelectedIndex() == 4) {
                    (app).mstgs.setSize(338, 22);
                    if (bool_36_ && (cd).msloaded != 4) {
                        (app).mstgs.removeAll();
                        (app).mstgs.add(rd, "Loading Top20 list, please wait...");
                        (app).mstgs.select(0);
                        i_37_ = 4;
                    }
                    i_38_ = 400 - ((app).sgame.getWidth() + 6 + (app).mstgs.getWidth()) / 2;
                }
                if ((app).sgame.getSelectedIndex() == 5) {
                    (app).mstgs.setSize(338, 22);
                    if (bool_36_ && (cd).msloaded != 5) {
                        (app).mstgs.removeAll();
                        (app).mstgs.add(rd, "Loading Top20 list, please wait...");
                        (app).mstgs.select(0);
                        i_37_ = 5;
                    }
                    i_38_ = 400 - ((app).sgame.getWidth() + 6 + (app).mstgs.getWidth()) / 2;
                }
                if ((app).sgame.getSelectedIndex() == 6) {
                    if ((cd).staction != 0) {
                        (app).tnick.hide();
                        (app).tpass.hide();
                        (cd).staction = 0;
                    }
                    (app).mstgs.setSize(338, 22);
                    if (bool_36_ && (cd).msloaded != 2) {
                        (app).mstgs.removeAll();
                        (app).mstgs.add(rd, "Loading Stage Maker stages, please wait...");
                        (app).mstgs.select(0);
                        i_37_ = 2;
                    }
                    i_38_ = 400 - ((app).sgame.getWidth() + 6 + (app).mstgs.getWidth()) / 2;
                }
                if (!(app).sgame.isShowing())
                    (app).sgame.show();
                (app).sgame.move(i_38_, 62);
                i_38_ += (app).sgame.getWidth() + 6;
                if (nfmtab == 0) {
                    if (!(app).snfm1.isShowing()) {
                        (app).snfm1.show();
                        if (!bool_36_ && (checkpoints).stage > 0)
                            (app).snfm1.select((checkpoints).stage);
                    }
                    (app).snfm1.move(i_38_, 62);
                    if ((app).snfm2.isShowing())
                        (app).snfm2.hide();
                    if ((app).mstgs.isShowing())
                        (app).mstgs.hide();
                }
                if (nfmtab == 1) {
                    if (!(app).snfm2.isShowing()) {
                        (app).snfm2.show();
                        if (!bool_36_ && (checkpoints).stage > 10)
                            (app).snfm2.select((checkpoints).stage - 10);
                    }
                    (app).snfm2.move(i_38_, 62);
                    if ((app).snfm1.isShowing())
                        (app).snfm1.hide();
                    if ((app).mstgs.isShowing())
                        (app).mstgs.hide();
                }
                if (nfmtab == 2 || nfmtab == 3 || nfmtab == 4 || nfmtab == 5 || nfmtab == 6) {
                    if (!(app).mstgs.isShowing()) {
                        (app).mstgs.show();
                        if (!bool_36_)
                            (app).mstgs.select((checkpoints).name);
                    }
                    (app).mstgs.move(i_38_, 62);
                    if ((app).snfm1.isShowing())
                        (app).snfm1.hide();
                    if ((app).snfm2.isShowing())
                        (app).snfm2.hide();
                }
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if ((cd).staction == 0 || (cd).staction == 6) {
                    if ((checkpoints).stage != -3) {
                        String string = "";
                        if ((checkpoints).top20 >= 3)
                            string = new StringBuilder().append("N#").append((checkpoints).nto).append("  ").toString();
                        if (aflk) {
                            drawcs(132, new StringBuilder().append(string).append((checkpoints).name).toString(), 240, 240, 240, 3);
                            aflk = false;
                        } else {
                            drawcs(132, new StringBuilder().append(string).append((checkpoints).name).toString(), 176, 176, 176, 3);
                            aflk = true;
                        }
                        if ((checkpoints).stage == -2 && (cd).staction == 0) {
                            rd.setFont(new Font("Arial", 1, 11));
                            ftm = rd.getFontMetrics();
                            rd.setColor(new Color(255, 176, 85));
                            if ((checkpoints).maker.equals(nickname))
                                rd.drawString("Created by You", 70, 115);
                            else
                                rd.drawString(new StringBuilder().append("Created by :  ").append((checkpoints).maker).append("").toString(), 70, 115);
                            if ((checkpoints).top20 >= 3)
                                rd.drawString(new StringBuilder().append("Added by :  ").append((cd).top20adds[(checkpoints).nto - 1]).append(" Players").toString(), 70, 135);
                        }
                    } else if (removeds != 1) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        drawcs(132, "Failed to load stage...", 255, 138, 0, 3);
                        rd.setFont(new Font("Arial", 1, 11));
                        ftm = rd.getFontMetrics();
                        if (nfmtab == 6)
                            drawcs(155, "Please Test Drive this stage in the Stage Maker to make sure it can be loaded!", 255, 138, 0, 3);
                        if (nfmtab == 2 || nfmtab == 3 || nfmtab == 4 || nfmtab == 5)
                            drawcs(155, "It could be a connection error, please try again later.", 255, 138, 0, 3);
                        if (nfmtab == 1 || nfmtab == 0) {
                            drawcs(155, "Will try to load another stage...", 255, 138, 0, 3);
                            app.repaint();
                            try {
                                Thread.sleep(5000L);
                            } catch (InterruptedException interruptedexception) {
                                /* empty */
                            }
                            if (nfmtab == 0)
                                (app).snfm1.select(1 + (int) (Math.random() * 10.0));
                            if (nfmtab == 1)
                                (app).snfm2.select(1 + (int) (Math.random() * 17.0));
                        }
                    }
                }
                if ((cd).staction == 3) {
                    drawdprom(145, 170);
                    if ((cd).reco == -2) {
                        if (lfrom == 0)
                            drawcs(171, "Login to Retrieve your Account Stages", 0, 0, 0, 3);
                        else
                            drawcs(171, "Login to add this stage to your account.", 0, 0, 0, 3);
                    }
                    if ((cd).reco == -1)
                        drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                    if ((cd).reco == 1)
                        drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                    if ((cd).reco == 2)
                        drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                    if ((cd).reco == -167 || (cd).reco == -177) {
                        if ((cd).reco == -167) {
                            nickname = (app).tnick.getText();
                            (cd).reco = -177;
                        }
                        drawcs(171, "You need to have a full account to access your stages!", 0, 0, 0, 3);
                    }
                    if ((cd).reco == -3 && (tcnt % 3 != 0 || tcnt > 20))
                        drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                    if ((cd).reco == -4 && (tcnt % 3 != 0 || tcnt > 20))
                        drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                    if (!(app).tnick.isShowing()) {
                        (app).tnick.show();
                        (app).tnick.setBackground(new Color(206, 237, 255));
                        if ((cd).reco != 1) {
                            if ((cd).reco != 2)
                                (app).tnick.setText(nickname);
                            (app).tnick.setForeground(new Color(0, 0, 0));
                        } else
                            (app).tnick.setForeground(new Color(255, 0, 0));
                        (app).tnick.requestFocus();
                    }
                    rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 201);
                    app.movefield((app).tnick, 376, 185, 129, 23);
                    if (!(app).tpass.isShowing()) {
                        (app).tpass.show();
                        (app).tpass.setBackground(new Color(206, 237, 255));
                        if ((cd).reco != 2) {
                            if (!autolog)
                                (app).tpass.setText("");
                            (app).tpass.setForeground(new Color(0, 0, 0));
                        } else
                            (app).tpass.setForeground(new Color(255, 0, 0));
                        if (!(app).tnick.getText().equals("") && (cd).reco != 1)
                            (app).tpass.requestFocus();
                    }
                    rd.drawString("Password:", 376 - ftm.stringWidth("Password:") - 14, 231);
                    app.movefield((app).tpass, 376, 215, 129, 23);
                    if (tcnt < 30) {
                        tcnt++;
                        if (tcnt == 30) {
                            if ((cd).reco == 2)
                                (app).tpass.setText("");
                            (app).tnick.setForeground(new Color(0, 0, 0));
                            (app).tpass.setForeground(new Color(0, 0, 0));
                        }
                    }
                    if ((cd).reco != -177) {
                        if ((drawcarb(true, null, "       Login       ", 347, 247, i, i_35_, bool) || (control).handb || (control).enter) && tcnt > 5) {
                            tcnt = 0;
                            if (!(app).tnick.getText().equals("") && !(app).tpass.getText().equals("")) {
                                autolog = false;
                                (app).tnick.hide();
                                (app).tpass.hide();
                                app.requestFocus();
                                (cd).staction = 4;
                                cd.sparkstageaction();
                            } else {
                                if ((app).tpass.getText().equals(""))
                                    (cd).reco = -4;
                                if ((app).tnick.getText().equals(""))
                                    (cd).reco = -3;
                            }
                        }
                    } else if (drawcarb(true, null, "  Upgrade your account to have full access  ", 254, 247, i, i_35_, bool) && cntflock == 0) {
                        app.editlink(nickname);
                        cntflock = 100;
                    }
                    if (drawcarb(true, null, "  Cancel  ", 409, 282, i, i_35_, bool)) {
                        (app).tnick.hide();
                        (app).tpass.hide();
                        app.requestFocus();
                        (cd).staction = 0;
                    }
                    if (drawcarb(true, null, "  Register!  ", 316, 282, i, i_35_, bool)) {
                        if (cntflock == 0) {
                            app.reglink();
                            cntflock = 100;
                        }
                    } else if (cntflock != 0)
                        cntflock--;
                }
                if ((cd).staction == 4) {
                    drawdprom(145, 170);
                    drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                }
                if ((checkpoints).stage == -2 && (cd).msloaded == 1 && (checkpoints).top20 < 3 && drawcarb(true, null, "X", 609, 113, i, i_35_, bool))
                    (cd).staction = 6;
                if ((cd).staction == -1 && (checkpoints).top20 < 3) {
                    removeds = 0;
                    drawdprom(145, 95);
                    drawcs(175, "Failed to remove stage from your account, try again later.", 0, 0, 0, 3);
                    if (drawcarb(true, null, " OK ", 379, 195, i, i_35_, bool))
                        (cd).staction = 0;
                }
                if ((cd).staction == 1) {
                    drawdprom(145, 95);
                    drawcs(195, "Removing stage from your account...", 0, 0, 0, 3);
                    removeds = 1;
                }
                if ((cd).staction == 6) {
                    drawdprom(145, 95);
                    drawcs(175, "Remove this stage from your account?", 0, 0, 0, 3);
                    if (drawcarb(true, null, " Yes ", 354, 195, i, i_35_, bool)) {
                        (cd).onstage = (app).mstgs.getSelectedItem();
                        (cd).staction = 1;
                        cd.sparkstageaction();
                    }
                    if (drawcarb(true, null, " No ", 408, 195, i, i_35_, bool))
                        (cd).staction = 0;
                }
                if (i_37_ == 1) {
                    app.drawms();
                    app.repaint();
                    cd.loadmystages(checkpoints);
                }
                if (i_37_ >= 3) {
                    app.drawms();
                    app.repaint();
                    cd.loadtop20(i_37_);
                }
                if (i_37_ == 2) {
                    app.drawms();
                    app.repaint();
                    cd.loadstagemaker();
                }
                if ((checkpoints).stage != -3 && (cd).staction == 0 && (checkpoints).top20 < 3)
                    rd.drawImage(contin[pcontin], 355, 360, null);
                else
                    pcontin = 0;
                if ((checkpoints).top20 >= 3 && (cd).staction != 3 && (cd).staction != 4) {
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    if (dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 355, i, i_35_, bool)) {
                        if (logged) {
                            (cd).onstage = (checkpoints).name;
                            (cd).staction = 2;
                            cd.sparkstageaction();
                            dnload = 2;
                        } else {
                            lfrom = 1;
                            (cd).staction = 3;
                            tcnt = 0;
                            cntflock = 0;
                            (cd).reco = -2;
                        }
                    }
                    if (dnload == 2) {
                        drawcs(370, "Adding stage please wait...", 193, 106, 0, 3);
                        if ((cd).staction == 0)
                            dnload = 3;
                        if ((cd).staction == -2)
                            dnload = 4;
                        if ((cd).staction == -3)
                            dnload = 5;
                        if ((cd).staction == -1)
                            dnload = 6;
                        if (dnload != 2)
                            (cd).staction = 0;
                    }
                    if (dnload == 3)
                        drawcs(370, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                    if (dnload == 4)
                        drawcs(370, "You already have this stage!", 193, 106, 0, 3);
                    if (dnload == 5)
                        drawcs(370, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                    if (dnload == 6)
                        drawcs(370, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
                }
                if (testdrive == 0 && (checkpoints).top20 < 3) {
                    if (!(app).gmode.isShowing()) {
                        (app).gmode.select(0);
                        (app).gmode.show();
                    }
                    (app).gmode.move(400 - (app).gmode.getWidth() / 2, 395);
                    if ((app).gmode.getSelectedIndex() == 0 && nplayers != 7) {
                        nplayers = 7;
                        fase = 2;
                        app.requestFocus();
                    }
                    if ((app).gmode.getSelectedIndex() == 1 && nplayers != 1) {
                        nplayers = 1;
                        fase = 2;
                        app.requestFocus();
                    }
                } else if ((app).gmode.isShowing())
                    (app).gmode.hide();
                if (nfmtab == 0 && (app).snfm1.getSelectedIndex() != (checkpoints).stage && (app).snfm1.getSelectedIndex() != 0) {
                    (checkpoints).stage = (app).snfm1.getSelectedIndex();
                    (checkpoints).top20 = 0;
                    (checkpoints).nto = 0;
                    hidos();
                    fase = 2;
                    app.requestFocus();
                }
                if (nfmtab == 1 && (app).snfm2.getSelectedIndex() != (checkpoints).stage - 10 && (app).snfm2.getSelectedIndex() != 0) {
                    (checkpoints).stage = (app).snfm2.getSelectedIndex() + 10;
                    (checkpoints).top20 = 0;
                    (checkpoints).nto = 0;
                    hidos();
                    fase = 2;
                    app.requestFocus();
                }
                if ((nfmtab == 2 || nfmtab == 6) && !(app).mstgs.getSelectedItem().equals((checkpoints).name) && (app).mstgs.getSelectedIndex() != 0) {
                    if (nfmtab == 2)
                        (checkpoints).stage = -2;
                    else
                        (checkpoints).stage = -1;
                    (checkpoints).name = (app).mstgs.getSelectedItem();
                    (checkpoints).top20 = 0;
                    (checkpoints).nto = 0;
                    hidos();
                    fase = 2;
                    app.requestFocus();
                }
                if (nfmtab == 3 || nfmtab == 4 || nfmtab == 5) {
                    String string = "";
                    int i_39_ = (app).mstgs.getSelectedItem().indexOf(" ") + 1;
                    if (i_39_ > 0)
                        string = (app).mstgs.getSelectedItem().substring(i_39_);
                    if (!string.equals("") && !string.equals((checkpoints).name) && (app).mstgs.getSelectedIndex() != 0) {
                        (checkpoints).stage = -2;
                        (checkpoints).name = string;
                        (checkpoints).top20 = -(cd).msloaded;
                        (checkpoints).nto = (app).mstgs.getSelectedIndex();
                        hidos();
                        fase = 2;
                        app.requestFocus();
                    }
                }
            } else {
                rd.setFont(new Font("SansSerif", 1, 13));
                ftm = rd.getFontMetrics();
                if ((checkpoints).stage != 27) {
                    int i_40_ = (checkpoints).stage;
                    if (i_40_ > 10)
                        i_40_ -= 10;
                    drawcs(80, new StringBuilder().append("Stage ").append(i_40_).append("  >").toString(), 255, 128, 0, 3);
                } else
                    drawcs(80, "Final Party Stage  >", 255, 128, 0, 3);
                if (aflk) {
                    drawcs(100, new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(), 240, 240, 240, 3);
                    aflk = false;
                } else {
                    drawcs(100, new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(), 176, 176, 176, 3);
                    aflk = true;
                }
                if ((checkpoints).stage != -3)
                    rd.drawImage(contin[pcontin], 355, 360, null);
                else
                    pcontin = 0;
            }
            rd.drawImage(byrd2, 72, 408, null);
            rd.drawImage(nfmcoms2, 532, 408, null);
            if ((cd).staction == 0) {
                if (((control).handb || (control).enter) && (checkpoints).stage != -3 && (checkpoints).top20 < 3) {
                    (app).gmode.hide();
                    hidos();
                    dudo = 150;
                    fase = 5;
                    (control).handb = false;
                    (control).enter = false;
                    intertrack.stop();
                    intertrack.unloadimod();
                }
                if ((checkpoints).stage > 0) {
                    if ((control).right) {
                        if (gmode == 0 || gmode == 1 && (checkpoints).stage != unlocked[0] || gmode == 2 && (checkpoints).stage != unlocked[1] + 10 || (checkpoints).stage == 27) {
                            if ((checkpoints).stage != 27) {
                                hidos();
                                (checkpoints).stage++;
                                if (gmode == 1 && (checkpoints).stage == 11)
                                    (checkpoints).stage = 27;
                                if ((checkpoints).stage > 10) {
                                    (app).sgame.select(1);
                                    nfmtab = 1;
                                } else {
                                    (app).sgame.select(0);
                                    nfmtab = 0;
                                }
                                fase = 2;
                            }
                        } else {
                            fase = 4;
                            lockcnt = 100;
                        }
                        (control).right = false;
                    }
                    if ((control).left && (checkpoints).stage != 1 && ((checkpoints).stage != 11 || gmode != 2)) {
                        hidos();
                        (checkpoints).stage--;
                        if (gmode == 1 && (checkpoints).stage == 26)
                            (checkpoints).stage = 10;
                        if ((checkpoints).stage > 10) {
                            (app).sgame.select(1);
                            nfmtab = 1;
                        } else {
                            (app).sgame.select(0);
                            nfmtab = 0;
                        }
                        fase = 2;
                        (control).left = false;
                    }
                }
            }
        } else {
            if (aflk) {
                drawcs(132, (checkpoints).name, 240, 240, 240, 3);
                aflk = false;
            } else {
                drawcs(132, (checkpoints).name, 176, 176, 176, 3);
                aflk = true;
            }
            rd.drawImage(contin[pcontin], 355, 360, null);
            if ((control).handb || (control).enter) {
                dudo = 150;
                fase = 5;
                (control).handb = false;
                (control).enter = false;
                intertrack.stop();
                intertrack.unloadimod();
            }
        }
        if (drawcarb(true, null, " Exit X ", 670, 30, i, i_35_, bool)) {
            fase = 102;
            if (gmode == 0)
                opselect = 3;
            if (gmode == 1)
                opselect = 0;
            if (gmode == 2)
                opselect = 1;
            (app).gmode.hide();
            hidos();
            (app).tnick.hide();
            (app).tpass.hide();
            intertrack.stop();
        }
    }
    
    public void hidos() {
        (app).sgame.hide();
        (app).snfm1.hide();
        (app).snfm2.hide();
        (app).mstgs.hide();
    }
    
    public void hipnoload(int i, boolean bool) {
        int[] is = { (m).snap[0], (m).snap[1], (m).snap[2] };
        while (is[0] + is[1] + is[2] < -30) {
            for (int i_41_ = 0; i_41_ < 3; i_41_++) {
                if (is[i_41_] < 50)
                    is[i_41_]++;
            }
        }
        int i_42_ = (int) (115.0F - 115.0F * ((float) is[0] / 100.0F));
        if (i_42_ > 255)
            i_42_ = 255;
        if (i_42_ < 0)
            i_42_ = 0;
        int i_43_ = (int) (115.0F - 115.0F * ((float) is[1] / 100.0F));
        if (i_43_ > 255)
            i_43_ = 255;
        if (i_43_ < 0)
            i_43_ = 0;
        int i_44_ = (int) (115.0F - 115.0F * ((float) is[2] / 100.0F));
        if (i_44_ > 255)
            i_44_ = 255;
        if (i_44_ < 0)
            i_44_ = 0;
        rd.setColor(new Color(i_42_, i_43_, i_44_));
        rd.fillRect(0, 0, 800, 450);
        i_42_ = (int) (230.0F - 230.0F * ((float) is[0] / 100.0F));
        if (i_42_ > 255)
            i_42_ = 255;
        if (i_42_ < 0)
            i_42_ = 0;
        i_43_ = (int) (230.0F - 230.0F * ((float) is[1] / 100.0F));
        if (i_43_ > 255)
            i_43_ = 255;
        if (i_43_ < 0)
            i_43_ = 0;
        i_44_ = (int) (230.0F - 230.0F * ((float) is[2] / 100.0F));
        if (i_44_ > 255)
            i_44_ = 255;
        if (i_44_ < 0)
            i_44_ = 0;
        rd.setColor(new Color(i_42_, i_43_, i_44_));
        rd.fillRect(65, 25, 670, 400);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        drawcs(50, asay, 0, 0, 0, 3);
        int i_45_ = -90;
        if (multion == 0) {
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 10)
                i_45_ = 0;
            if (i == 11 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20 || i == 22 || i == 23 || i == 26)
                i_45_ = 0;
            if (i < 0 && nplayers != 1 && newparts)
                i_45_ = 0;
        } else if (ransay == 1 || ransay == 2 || ransay == 4 || i == 10)
            i_45_ = 0;
        if (i_45_ == 0) {
            if (dudo > 0) {
                if (aflk) {
                    if (Math.random() > Math.random())
                        duds = (int) (Math.random() * 3.0);
                    else
                        duds = (int) (Math.random() * 2.0);
                    aflk = false;
                } else
                    aflk = true;
                dudo--;
            } else
                duds = 0;
            rd.drawImage(dude[duds], 95, 35, null);
            rd.drawImage(flaot, 192, 67, null);
            i_42_ = (int) (80.0F - 80.0F * ((float) is[0] / 100.0F));
            if (i_42_ > 255)
                i_42_ = 255;
            if (i_42_ < 0)
                i_42_ = 0;
            i_43_ = (int) (80.0F - 80.0F * ((float) is[1] / 100.0F));
            if (i_43_ > 255)
                i_43_ = 255;
            if (i_43_ < 0)
                i_43_ = 0;
            i_44_ = (int) (80.0F - 80.0F * ((float) is[2] / 100.0F));
            if (i_44_ > 255)
                i_44_ = 255;
            if (i_44_ < 0)
                i_44_ = 0;
            rd.setColor(new Color(i_42_, i_43_, i_44_));
            rd.setFont(new Font("Arial", 1, 13));
            if (multion != 0) {
                if (ransay == 1 && i != 10)
                    rd.drawString("Multiplayer Tip:  Press [ C ] to access chat quickly during the game!", 262, 92);
                if (ransay == 2 && i != 10) {
                    rd.drawString("Multiplayer Tip:  Press [ A ] to make Guidance Arrow point to cars and", 262, 92);
                    rd.drawString("click any of the players listed on the right to lock the Arrow on!", 262, 112);
                }
                if (ransay == 4) {
                    rd.drawString("When watching a game, click any player listed on the right of the", 262, 92);
                    rd.drawString("screen to follow and watch.", 262, 112);
                    rd.drawString("Press [ V ] to change the viewing mode!", 262, 132);
                }
                if (i == 10 && ransay != 4) {
                    if (tflk) {
                        rd.setColor(new Color(200, i_43_, i_44_));
                        tflk = false;
                    } else
                        tflk = true;
                    rd.drawString("NOTE: Guidance Arrow and opponent status is disabled in this stage!", 262, 92);
                }
            } else {
                if (i < 0 && nplayers != 1 && newparts) {
                    rd.drawString("Please note, the computer car's AI has not yet been trained to handle", 262, 92);
                    rd.drawString("some of the new stage parts such as the 'Rollercoaster Road' and the", 262, 112);
                    rd.drawString("'Tunnel Side Ramp'.", 262, 132);
                    rd.drawString("(Those new parts where mostly designed for the multiplayer game.)", 262, 152);
                    rd.drawString("The AI will be trained and ready in the future releases of the game!", 262, 172);
                }
                if (i == 1 || i == 11) {
                    rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 262, 92);
                    rd.drawString("all checkpoints in the track!", 262, 112);
                }
                if (i == 2 || i == 12)
                    rd.drawString("Remember, the more power you have the faster your car will be!", 262, 92);
                if (i == 3) {
                    rd.drawString("> Hint: its easier to waste the other cars then to race in this stage!", 262, 92);
                    rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 112);
                    rd.drawString("the track.", 262, 132);
                }
                if (i == 4)
                    rd.drawString("Remember, the better the stunt you perform the more power you get!", 262, 92);
                if (i == 5)
                    rd.drawString("Remember, the more power you have the stronger your car is!", 262, 92);
                if (i == 10) {
                    if (tflk) {
                        rd.setColor(new Color(200, i_43_, i_44_));
                        tflk = false;
                    } else
                        tflk = true;
                    rd.drawString("NOTE: Guidance Arrow is disabled in this stage!", 262, 92);
                }
                if (i == 13) {
                    rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 262, 92);
                    rd.drawString("Don't upset him or you'll be arrested!", 262, 112);
                    rd.drawString("Better run, run, run.", 262, 152);
                }
                if (i == 14) {
                    rd.drawString("Don't waste your time.  Waste them instead!", 262, 92);
                    rd.drawString("Try a taste of sweet revenge here (if you can)!", 262, 112);
                    rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 152);
                    rd.drawString("the track.", 262, 172);
                }
                if (i == 17) {
                    rd.drawString("Welcome to the realm of the king...", 262, 92);
                    rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 262, 132);
                    rd.drawString("and STRONGER you car will be!", 262, 152);
                }
                if (i == 18) {
                    rd.drawString("Watch out, EL KING is out to get you now!", 262, 92);
                    rd.drawString("He seems to be seeking revenge?", 262, 112);
                    rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 262, 152);
                    rd.drawString("before take off).", 262, 172);
                }
                if (i == 19)
                    rd.drawString("It\u2019s good to be the king!", 262, 92);
                if (i == 20) {
                    rd.drawString("Remember, forward loops give your car a push forwards in the air", 262, 92);
                    rd.drawString("and help in racing.", 262, 112);
                    rd.drawString("(You may need to do more forward loops here.  Also try keeping", 262, 152);
                    rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 262, 172);
                }
                if (i == 22) {
                    rd.drawString("Watch out!  Beware!  Take care!", 262, 92);
                    rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 262, 112);
                }
                if (i == 23) {
                    rd.drawString("Anyone for a game of Digger?!", 262, 92);
                    rd.drawString("You can have fun using MASHEEN here!", 262, 112);
                }
                if (i == 26) {
                    rd.drawString("This is it!  This is the toughest stage in the game!", 262, 92);
                    rd.drawString("This track is actually a 4D object projected onto the 3D world.", 262, 132);
                    rd.drawString("It's been broken down, separated and, in many ways, it is also a", 262, 152);
                    rd.drawString("maze!  GOOD LUCK!", 262, 172);
                }
            }
        }
        rd.drawImage(loadingmusic, 289, 205 + i_45_, null);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        int i_46_ = i - 1;
        if (i_46_ < 0)
            i_46_ = 32;
        if (!bool) {
            drawcs(340 + i_45_, new StringBuilder().append("").append(sndsize[i_46_]).append(" KB").toString(), 0, 0, 0, 3);
            drawcs(375 + i_45_, " Please Wait...", 0, 0, 0, 3);
        } else {
            drawcs(365 + i_45_, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            rd.drawImage(star[pstar], 359, 385 + i_45_, null);
            if (pstar != 2) {
                if (pstar == 0)
                    pstar = 1;
                else
                    pstar = 0;
            }
            if (multion != 0)
                drawcs(380 + i_45_, new StringBuilder().append("").append(forstart / 20).toString(), 0, 0, 0, 3);
        }
    }
    
    public void loadmusic(int i, String string, int i_47_) {
        hipnoload(i, false);
        app.setCursor(new Cursor(3));
        app.repaint();
        boolean bool = false;
        if (multion == 0) {
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 10)
                bool = true;
            if (i == 11 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20 || i == 22 || i == 23 || i == 26)
                bool = true;
            if (i < 0 && nplayers != 1 && newparts)
                bool = true;
        } else if (ransay == 1 || ransay == 2 || ransay == 4 || i == 10)
            bool = true;
        if (bool) {
            runtyp = i;
            runner = new Thread(this);
            runner.start();
        }
        if (i == 1)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 240, 8400, 135, false, false);
        if (i == 2)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 190, 9000, 145, false, false);
        if (i == 3)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 170, 8500, 145, false, false);
        if (i == 4)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 205, 7500, 125, false, false);
        if (i == 5)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 170, 7900, 125, false, false);
        if (i == 6)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 370, 7900, 125, false, false);
        if (i == 7)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 205, 7500, 125, false, false);
        if (i == 8)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 230, 7900, 125, false, false);
        if (i == 9)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 180, 7900, 125, false, false);
        if (i == 10)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 280, 8100, 145, false, false);
        if (i == 11)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 120, 8000, 125, false, false);
        if (i == 12)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 260, 7200, 125, false, false);
        if (i == 13)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 270, 8000, 125, false, false);
        if (i == 14)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 190, 8000, 125, false, false);
        if (i == 15)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 162, 7800, 125, false, false);
        if (i == 16)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220, 7600, 125, false, false);
        if (i == 17)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 300, 7500, 125, false, false);
        if (i == 18)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200, 7900, 125, false, false);
        if (i == 19)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200, 7900, 125, false, false);
        if (i == 20)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 232, 7300, 125, false, false);
        if (i == 21)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 370, 7900, 125, false, false);
        if (i == 22)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 290, 7900, 125, false, false);
        if (i == 23)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 222, 7600, 125, false, false);
        if (i == 24)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 230, 8000, 125, false, false);
        if (i == 25)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220, 8000, 125, false, false);
        if (i == 26)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 261, 8000, 125, false, false);
        if (i == 27) {
            if (gmode == 2)
                strack = new RadicalMod("music/party.zip", 400, 7600, 125, false, false);
            else
                strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 276, 8800, 145, false, false);
        }
        if (i == 28)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 182, 8000, 125, false, false);
        if (i == 29)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220, 8000, 125, false, false);
        if (i == 30)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200, 8000, 125, false, false);
        if (i == 31)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 350, 7900, 125, false, false);
        if (i == 32)
            strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 310, 8000, 125, false, false);
        if (i < 0) {
            if (!string.equals("")) {
                if (i != -2)
                    strack = new RadicalMod(new StringBuilder().append("mystages/mymusic/").append(string).append(".zip").toString(), i_47_, 8000, 125, false, false);
                else
                    strack = new RadicalMod(string, i_47_, 8000, 125, false, true);
            } else
                strack = new RadicalMod();
        }
        loadedt = true;
        if (bool) {
            runner.stop();
            runner = null;
            runtyp = 0;
        }
        System.gc();
        if (multion == 0 && macn) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        if (!lan)
            strack.play();
        else if (im != 0) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        app.setCursor(new Cursor(0));
        pcontin = 0;
        mutem = false;
        mutes = false;
        fase = 6;
    }
    
    public void musicomp(int i, Control control) {
        hipnoload(i, true);
        if (multion != 0) {
            forstart--;
            if (lan && im == 0)
                forstart = 0;
        }
        if ((control).handb || (control).enter || forstart == 0) {
            System.gc();
            (m).trk = 0;
            (m).crs = false;
            (m).ih = 0;
            (m).iw = 0;
            (m).h = 450;
            (m).w = 800;
            (m).focus_point = 400;
            (m).cx = 400;
            (m).cy = 225;
            (m).cz = 50;
            rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            if (multion == 0)
                fase = 0;
            else {
                fase = 7001;
                forstart = 0;
                if (!lan) {
                    try {
                        socket = new Socket(server, servport);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        runtyp = -101;
                        runner = new Thread(this);
                        runner.start();
                    } catch (Exception exception) {
                        /* empty */
                    }
                }
            }
            if (Math.random() > Math.random())
                dudo = 250;
            else
                dudo = 428;
            (control).handb = false;
            (control).enter = false;
        }
    }
    
    public void waitenter() {
        if (forstart < 690) {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(70, "Waiting for all players to finish loading!", 0, 0, 0, 0);
            if (forstart <= 640)
                drawcs(90, new StringBuilder().append("").append((640 - forstart) / 32).append("").toString(), 0, 0, 0, 0);
            else
                drawcs(90, "Your connection to game may have been lost...", 0, 0, 0, 0);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            if (tflk) {
                drawcs(125, "Get Ready!", 0, 0, 0, 0);
                tflk = false;
            } else {
                drawcs(125, "Get Ready!", 0, 128, 255, 0);
                tflk = true;
            }
        }
        forstart++;
        if (forstart == 700) {
            fase = -2;
            winner = false;
        }
    }
    
    public void multistat(Control control, CheckPoints checkpoints, int i, int i_48_, boolean bool, UDPMistro udpmistro) {
        boolean bool_49_ = false;
        if (fase != -2) {
            if (exitm != 0 && !holdit) {
                if (!lan || im != 0) {
                    if (bool) {
                        if (i > 357 && i < 396 && i_48_ > 162 && i_48_ < 179)
                            exitm = 2;
                        else
                            exitm = 0;
                    }
                    float[] fs = new float[3];
                    Color.RGBtoHSB((m).cgrnd[0], (m).cgrnd[1], (m).cgrnd[2], fs);
                    fs[1] -= 0.15;
                    if (fs[1] < 0.0F)
                        fs[1] = 0.0F;
                    fs[2] += 0.15;
                    if (fs[2] > 1.0F)
                        fs[2] = 1.0F;
                    rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                    rd.fillRect(357, 169, 39, 10);
                    rd.fillRect(403, 169, 39, 10);
                    fs[1] -= 0.07;
                    if (fs[1] < 0.0F)
                        fs[1] = 0.0F;
                    fs[2] += 0.07;
                    if (fs[2] > 1.0F)
                        fs[2] = 1.0F;
                    rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                    rd.fillRect(357, 162, 39, 7);
                    rd.fillRect(403, 162, 39, 7);
                    drawhi(exitgame, 116);
                    if (i > 357 && i < 396 && i_48_ > 162 && i_48_ < 179) {
                        rd.setColor(new Color((m).csky[0], (m).csky[1], (m).csky[2]));
                        rd.fillRect(357, 162, 39, 17);
                    }
                    if (i > 403 && i < 442 && i_48_ > 162 && i_48_ < 179) {
                        rd.setColor(new Color((m).csky[0], (m).csky[1], (m).csky[2]));
                        rd.fillRect(403, 162, 39, 17);
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Yes", 366, 175);
                    rd.drawString("No", 416, 175);
                    rd.setColor(new Color((m).csky[0] / 2, (m).csky[1] / 2, (m).csky[2] / 2));
                    rd.drawRect(403, 162, 39, 17);
                    rd.drawRect(357, 162, 39, 17);
                } else {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    drawcs(125, "You cannot exit game.  Your computer is the LAN server!", 0, 0, 0, 0);
                    msgflk++;
                    if (msgflk == 67 || bool) {
                        msgflk = 0;
                        exitm = 0;
                    }
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                }
            } else if (exitm == 4) {
                if (bool) {
                    if (i > 357 && i < 396 && i_48_ > 362 && i_48_ < 379) {
                        alocked = -1;
                        lalocked = -1;
                        multion = 2;
                        (control).multion = multion;
                        holdit = false;
                        exitm = 0;
                        (control).chatup = false;
                    }
                    if ((!lan || im != 0) && i > 403 && i < 442 && i_48_ > 362 && i_48_ < 379) {
                        holdcnt = 600;
                        exitm = 0;
                        (control).chatup = false;
                    }
                }
                float[] fs = new float[3];
                Color.RGBtoHSB((m).cgrnd[0], (m).cgrnd[1], (m).cgrnd[2], fs);
                fs[1] -= 0.15;
                if (fs[1] < 0.0F)
                    fs[1] = 0.0F;
                fs[2] += 0.15;
                if (fs[2] > 1.0F)
                    fs[2] = 1.0F;
                rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                rd.fillRect(357, 369, 39, 10);
                if (!lan || im != 0)
                    rd.fillRect(403, 369, 39, 10);
                fs[1] -= 0.07;
                if (fs[1] < 0.0F)
                    fs[1] = 0.0F;
                fs[2] += 0.07;
                if (fs[2] > 1.0F)
                    fs[2] = 1.0F;
                rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                rd.fillRect(357, 362, 39, 7);
                if (!lan || im != 0)
                    rd.fillRect(403, 362, 39, 7);
                rd.setColor(new Color(0, 0, 0));
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if (lan && im == 0)
                    drawcs(140, "(You cannot exit game.  Your computer is the LAN server... )", 0, 0, 0, 0);
                rd.drawString("Continue watching this game?", 155, 375);
                if (i > 357 && i < 396 && i_48_ > 362 && i_48_ < 379) {
                    rd.setColor(new Color((m).csky[0], (m).csky[1], (m).csky[2]));
                    rd.fillRect(357, 362, 39, 17);
                }
                if ((!lan || im != 0) && i > 403 && i < 442 && i_48_ > 362 && i_48_ < 379) {
                    rd.setColor(new Color((m).csky[0], (m).csky[1], (m).csky[2]));
                    rd.fillRect(403, 362, 39, 17);
                }
                rd.setFont(new Font("Arial", 1, 11));
                ftm = rd.getFontMetrics();
                rd.setColor(new Color(0, 0, 0));
                rd.drawString("Yes", 366, 375);
                if (!lan || im != 0)
                    rd.drawString("No", 416, 375);
                rd.setColor(new Color((m).csky[0] / 2, (m).csky[1] / 2, (m).csky[2] / 2));
                if (!lan || im != 0)
                    rd.drawRoundRect(147, 357, 301, 27, 7, 20);
                else
                    rd.drawRoundRect(147, 357, 262, 27, 7, 20);
                rd.drawRect(357, 362, 39, 17);
                if (!lan || im != 0)
                    rd.drawRect(403, 362, 39, 17);
            }
            if (runtyp == -101 && !lan) {
                if (warning == 0 || warning == 210) {
                    boolean bool_50_ = false;
                    if (i > 5 && i < 90 && i_48_ > 423 && i_48_ < 446) {
                        bool_50_ = true;
                        if ((control).chatup)
                            (control).chatup = false;
                    } else if (pointc != 6) {
                        pointc = 6;
                        floater = 1;
                    }
                    if (i > 90 && i < 666 && i_48_ > 423 && i_48_ < 446 && lxm != i && i_48_ != lym && lxm != -100 && !(control).chatup) {
                        (control).chatup = true;
                        cntchatp = 0;
                    }
                    lxm = i;
                    lym = i_48_;
                    if (exitm != 0 && exitm != 4)
                        (control).chatup = false;
                    boolean bool_51_ = false;
                    if ((control).enter && (control).chatup) {
                        bool_51_ = true;
                        (control).chatup = false;
                        (control).enter = false;
                        lxm = -100;
                    }
                    if (bool) {
                        if (mouson == 0) {
                            if (i > 676 && i < 785 && i_48_ > 426 && i_48_ < 443 && (control).chatup)
                                bool_51_ = true;
                            if (bool_50_ && pointc > 0) {
                                pointc--;
                                floater = 1;
                            }
                            mouson = 1;
                        }
                        (control).chatup = false;
                    } else if (mouson != 0)
                        mouson = 0;
                    if (bool_51_) {
                        String string = "";
                        int i_52_ = 0;
                        int i_53_ = 1;
                        for (/**/; i_52_ < lcmsg.length(); i_52_++) {
                            String string_54_ = new StringBuilder().append("").append(lcmsg.charAt(i_52_)).toString();
                            if (string_54_.equals(" "))
                                i_53_++;
                            else
                                i_53_ = 0;
                            if (i_53_ < 2)
                                string = new StringBuilder().append(string).append(string_54_).toString();
                        }
                        if (!string.equals("")) {
                            string = string.replace('|', ':');
                            if (string.toLowerCase().indexOf((app).tpass.getText().toLowerCase()) != -1)
                                string = " ";
                            if (!msgcheck(string) && updatec > -12) {
                                if (cnames[6].equals("No Messages  "))
                                    cnames[6] = "";
                                for (int i_55_ = 0; i_55_ < 6; i_55_++) {
                                    sentn[i_55_] = sentn[i_55_ + 1];
                                    cnames[i_55_] = cnames[i_55_ + 1];
                                }
                                sentn[6] = string;
                                cnames[6] = nickname;
                                if (pointc != 6) {
                                    pointc = 6;
                                    floater = 1;
                                }
                                msgflk = 110;
                                if (updatec > -11)
                                    updatec = -11;
                                else
                                    updatec--;
                            } else
                                warning++;
                        }
                    }
                    if (bool_50_ || floater != 0 || (control).chatup || msgflk != 0) {
                        float[] fs = new float[3];
                        Color.RGBtoHSB((m).cgrnd[0], (m).cgrnd[1], (m).cgrnd[2], fs);
                        fs[1] -= 0.15;
                        if (fs[1] < 0.0F)
                            fs[1] = 0.0F;
                        fs[2] += 0.15;
                        if (fs[2] > 1.0F)
                            fs[2] = 1.0F;
                        rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                        rd.fillRect(90, 423, 704, 23);
                    }
                    if (!(control).chatup) {
                        if ((app).cmsg.isShowing()) {
                            (app).cmsg.hide();
                            app.requestFocus();
                        }
                        int i_56_ = 0;
                        int i_57_ = (int) (48.0F + 48.0F * ((float) (m).snap[1] / 100.0F));
                        if (i_57_ > 255)
                            i_57_ = 255;
                        if (i_57_ < 0)
                            i_57_ = 0;
                        int i_58_ = (int) (96.0F + 96.0F * ((float) (m).snap[2] / 100.0F));
                        if (i_58_ > 255)
                            i_58_ = 255;
                        if (i_58_ < 0)
                            i_58_ = 0;
                        if (floater != 0) {
                            for (int i_59_ = 6; i_59_ >= 0; i_59_--) {
                                if (pointc == i_59_) {
                                    if (Math.abs(i_56_ + movepos) > 10) {
                                        floater = (movepos + i_56_) / 4;
                                        if (floater > -5 && floater < 0)
                                            floater = -5;
                                        if (floater < 10 && floater > 0)
                                            floater = 10;
                                        movepos -= floater;
                                    } else {
                                        movepos = -i_56_;
                                        floater = 0;
                                    }
                                }
                                if (pointc >= i_59_) {
                                    rd.setColor(new Color(0, i_57_, i_58_));
                                    rd.setFont(new Font("Tahoma", 1, 11));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(new StringBuilder().append(cnames[i_59_]).append(": ").toString(), 96 + i_56_ + movepos, 439);
                                    i_56_ += ftm.stringWidth(new StringBuilder().append(cnames[i_59_]).append(": ").toString());
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Tahoma", 0, 11));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(new StringBuilder().append(sentn[i_59_]).append("   ").toString(), 96 + i_56_ + movepos, 439);
                                    i_56_ += ftm.stringWidth(new StringBuilder().append(sentn[i_59_]).append("   ").toString());
                                } else {
                                    i_56_ += ftm.stringWidth(new StringBuilder().append(cnames[i_59_]).append(": ").toString());
                                    i_56_ += ftm.stringWidth(new StringBuilder().append(sentn[i_59_]).append("   ").toString());
                                }
                            }
                            rd.setColor(new Color(0, 0, 0));
                            rd.fillRect(0, 423, 5, 24);
                            rd.fillRect(794, 423, 6, 24);
                        } else {
                            for (int i_60_ = pointc; i_60_ >= 0; i_60_--) {
                                if (i_60_ == 6 && msgflk != 0)
                                    msgflk--;
                                rd.setColor(new Color(0, i_57_, i_58_));
                                rd.setFont(new Font("Tahoma", 1, 11));
                                ftm = rd.getFontMetrics();
                                if (ftm.stringWidth(new StringBuilder().append(cnames[i_60_]).append(": ").toString()) + 96 + i_56_ < 775) {
                                    if (i_60_ != 6 || msgflk < 67 || msgflk % 3 != 0)
                                        rd.drawString(new StringBuilder().append(cnames[i_60_]).append(": ").toString(), 96 + i_56_, 439);
                                    i_56_ += ftm.stringWidth(new StringBuilder().append(cnames[i_60_]).append(": ").toString());
                                } else {
                                    String string = "";
                                    for (int i_61_ = 0; ftm.stringWidth(string) + 96 + i_56_ < 775 && i_61_ < cnames[i_60_].length(); i_61_++)
                                        string = new StringBuilder().append(string).append(cnames[i_60_].charAt(i_61_)).toString();
                                    string = new StringBuilder().append(string).append("...").toString();
                                    if (i_60_ != 6 || msgflk < 67 || msgflk % 3 != 0)
                                        rd.drawString(string, 96 + i_56_, 439);
                                    break;
                                }
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Tahoma", 0, 11));
                                ftm = rd.getFontMetrics();
                                if (ftm.stringWidth(sentn[i_60_]) + 96 + i_56_ < 775) {
                                    if (i_60_ != 6 || msgflk < 67 || msgflk % 3 != 0)
                                        rd.drawString(new StringBuilder().append(sentn[i_60_]).append("   ").toString(), 96 + i_56_, 439);
                                    i_56_ += ftm.stringWidth(new StringBuilder().append(sentn[i_60_]).append("   ").toString());
                                } else {
                                    String string = "";
                                    for (int i_62_ = 0; ftm.stringWidth(string) + 96 + i_56_ < 775 && i_62_ < sentn[i_60_].length(); i_62_++)
                                        string = new StringBuilder().append(string).append(sentn[i_60_].charAt(i_62_)).toString();
                                    string = new StringBuilder().append(string).append("...").toString();
                                    if (i_60_ != 6 || msgflk < 67 || msgflk % 3 != 0)
                                        rd.drawString(string, 96 + i_56_, 439);
                                    break;
                                }
                            }
                        }
                    } else {
                        msgflk = 0;
                        bool_49_ = true;
                    }
                    if (bool_50_ || floater != 0) {
                        float[] fs = new float[3];
                        Color.RGBtoHSB((m).cgrnd[0], (m).cgrnd[1], (m).cgrnd[2], fs);
                        fs[1] -= 0.076;
                        if (fs[1] < 0.0F)
                            fs[1] = 0.0F;
                        fs[2] += 0.076;
                        if (fs[2] > 1.0F)
                            fs[2] = 1.0F;
                        rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                        rd.fillRect(5, 423, 85, 23);
                    }
                    if (bool_50_) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawLine(36, 440, 65, 440);
                    } else
                        rd.setColor(new Color((int) ((float) (m).cgrnd[0] / 2.5F), (int) ((float) (m).cgrnd[1] / 2.5F), (int) ((float) (m).cgrnd[2] / 2.5F)));
                    rd.setFont(new Font("Tahoma", 1, 11));
                    rd.drawString("<<   Scroll", 9, 439);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawRect(5, 423, 789, 23);
                    rd.drawLine(90, 423, 90, 446);
                    if (i > 775 && i < 794 && i_48_ > 409 && i_48_ < 423) {
                        rd.drawRect(775, 409, 19, 14);
                        rd.setColor(new Color(200, 0, 0));
                        if (bool) {
                            (control).chatup = false;
                            if ((app).cmsg.isShowing()) {
                                (app).cmsg.hide();
                                app.requestFocus();
                            }
                            runtyp = 0;
                            try {
                                socket.close();
                                socket = null;
                                din.close();
                                din = null;
                                dout.close();
                                dout = null;
                            } catch (Exception exception) {
                                /* empty */
                            }
                        }
                    }
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.drawString("x", 782, 420);
                } else {
                    drawWarning();
                    if ((app).cmsg.isShowing()) {
                        (app).cmsg.hide();
                        app.requestFocus();
                    }
                    warning++;
                }
                rd.setFont(new Font("Arial", 1, 11));
                ftm = rd.getFontMetrics();
            } else if ((control).chatup) {
                (control).chatup = false;
                if (!lan) {
                    runtyp = -101;
                    if (runner != null)
                        runner.stop();
                    runner = new Thread(this);
                    runner.start();
                }
            }
            if ((control).arrace && starcnt < 38 && !holdit && (checkpoints).stage != 10 || multion >= 2) {
                if (alocked != -1 && (checkpoints).dested[alocked] != 0) {
                    alocked = -1;
                    lalocked = -1;
                }
                if (multion >= 2) {
                    if (alocked == -1 || holdit) {
                        if (cntflock == 100) {
                            for (int i_63_ = 0; i_63_ < nplayers; i_63_++) {
                                if (holdit) {
                                    if ((checkpoints).pos[i_63_] == 0) {
                                        alocked = i_63_;
                                        im = i_63_;
                                    }
                                } else if ((checkpoints).dested[i_63_] == 0) {
                                    alocked = i_63_;
                                    im = i_63_;
                                }
                            }
                        }
                        cntflock++;
                    } else
                        cntflock = 0;
                    if (lan) {
                        boolean bool_64_ = true;
                        for (int i_65_ = 0; i_65_ < nplayers; i_65_++) {
                            if (dested[i_65_] == 0 && plnames[i_65_].indexOf("MadBot") == -1)
                                bool_64_ = false;
                        }
                        if (bool_64_)
                            exitm = 2;
                    }
                }
                int i_66_ = nplayers;
                for (int i_67_ = 0; i_67_ < i_66_; i_67_++) {
                    boolean bool_68_ = false;
                    for (int i_69_ = 0; i_69_ < nplayers; i_69_++) {
                        if ((checkpoints).pos[i_69_] == i_67_ && (checkpoints).dested[i_69_] == 0 && !bool_68_) {
                            rd.setColor(new Color(0, 0, 100));
                            if (i_67_ == 0)
                                rd.drawString("1st", 673, 76 + 30 * i_67_);
                            if (i_67_ == 1)
                                rd.drawString("2nd", 671, 76 + 30 * i_67_);
                            if (i_67_ == 2)
                                rd.drawString("3rd", 671, 76 + 30 * i_67_);
                            if (i_67_ >= 3)
                                rd.drawString(new StringBuilder().append("").append(i_67_ + 1).append("th").toString(), 671, 76 + 30 * i_67_);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawString(plnames[i_69_], 730 - ftm.stringWidth(plnames[i_69_]) / 2, 70 + 30 * i_67_);
                            int i_70_ = (int) (60.0F * (checkpoints).magperc[i_69_]);
                            int i_71_ = 244;
                            int i_72_ = 244;
                            int i_73_ = 11;
                            if (i_70_ > 20)
                                i_72_ = (int) (244.0F - 233.0F * ((float) (i_70_ - 20) / 40.0F));
                            i_71_ += (float) i_71_ * ((float) (m).snap[0] / 100.0F);
                            if (i_71_ > 255)
                                i_71_ = 255;
                            if (i_71_ < 0)
                                i_71_ = 0;
                            i_72_ += (float) i_72_ * ((float) (m).snap[1] / 100.0F);
                            if (i_72_ > 255)
                                i_72_ = 255;
                            if (i_72_ < 0)
                                i_72_ = 0;
                            i_73_ += (float) i_73_ * ((float) (m).snap[2] / 100.0F);
                            if (i_73_ > 255)
                                i_73_ = 255;
                            if (i_73_ < 0)
                                i_73_ = 0;
                            rd.setColor(new Color(i_71_, i_72_, i_73_));
                            rd.fillRect(700, 74 + 30 * i_67_, i_70_, 5);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRect(700, 74 + 30 * i_67_, 60, 5);
                            boolean bool_74_ = false;
                            if ((im != i_69_ || multion >= 2) && i > 661 && i < 775 && i_48_ > 58 + 30 * i_67_ && i_48_ < 83 + 30 * i_67_) {
                                bool_74_ = true;
                                if (bool) {
                                    if (!onlock) {
                                        if (alocked != i_69_ || multion >= 2) {
                                            alocked = i_69_;
                                            if (multion >= 2)
                                                im = i_69_;
                                        } else
                                            alocked = -1;
                                    }
                                    onlock = true;
                                } else if (onlock)
                                    onlock = false;
                            }
                            if (alocked == i_69_) {
                                i_71_ = (int) (159.0F + 159.0F * ((float) (m).snap[0] / 100.0F));
                                if (i_71_ > 255)
                                    i_71_ = 255;
                                if (i_71_ < 0)
                                    i_71_ = 0;
                                i_72_ = (int) (207.0F + 207.0F * ((float) (m).snap[1] / 100.0F));
                                if (i_72_ > 255)
                                    i_72_ = 255;
                                if (i_72_ < 0)
                                    i_72_ = 0;
                                i_73_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 100.0F));
                                if (i_73_ > 255)
                                    i_73_ = 255;
                                if (i_73_ < 0)
                                    i_73_ = 0;
                                rd.setColor(new Color(i_71_, i_72_, i_73_));
                                rd.drawRect(661, 58 + 30 * i_67_, 114, 25);
                                rd.drawRect(662, 59 + 30 * i_67_, 112, 23);
                            }
                            if (bool_74_ && !onlock) {
                                if (alocked == i_69_) {
                                    i_71_ = (int) (120.0F + 120.0F * ((float) (m).snap[0] / 100.0F));
                                    if (i_71_ > 255)
                                        i_71_ = 255;
                                    if (i_71_ < 0)
                                        i_71_ = 0;
                                    i_72_ = (int) (114.0F + 114.0F * ((float) (m).snap[1] / 100.0F));
                                    if (i_72_ > 255)
                                        i_72_ = 255;
                                    if (i_72_ < 0)
                                        i_72_ = 0;
                                    i_73_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 100.0F));
                                    if (i_73_ > 255)
                                        i_73_ = 255;
                                    if (i_73_ < 0)
                                        i_73_ = 0;
                                } else {
                                    i_71_ = (int) (140.0F + 140.0F * ((float) (m).snap[0] / 100.0F));
                                    if (i_71_ > 255)
                                        i_71_ = 255;
                                    if (i_71_ < 0)
                                        i_71_ = 0;
                                    i_72_ = (int) (160.0F + 160.0F * ((float) (m).snap[1] / 100.0F));
                                    if (i_72_ > 255)
                                        i_72_ = 255;
                                    if (i_72_ < 0)
                                        i_72_ = 0;
                                    i_73_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 100.0F));
                                    if (i_73_ > 255)
                                        i_73_ = 255;
                                    if (i_73_ < 0)
                                        i_73_ = 0;
                                }
                                rd.setColor(new Color(i_71_, i_72_, i_73_));
                                rd.drawRect(660, 57 + 30 * i_67_, 116, 27);
                            }
                            bool_68_ = true;
                        }
                    }
                }
            }
            if ((udpmistro).go && (udpmistro).runon == 1 && !holdit) {
                int i_75_ = 0;
                int i_76_ = 0;
                for (int i_77_ = 0; i_77_ < nplayers; i_77_++) {
                    if (i_77_ != (udpmistro).im) {
                        i_76_++;
                        if ((udpmistro).lframe[i_77_] == (udpmistro).lcframe[i_77_] || (udpmistro).force[i_77_] == 7)
                            i_75_++;
                        else
                            (udpmistro).lcframe[i_77_] = (udpmistro).lframe[i_77_];
                    }
                }
                if (i_75_ == i_76_)
                    discon++;
                else if (discon != 0)
                    discon = 0;
                if (discon == 240)
                    (udpmistro).runon = 2;
            }
        }
        if (bool_49_) {
            float[] fs = new float[3];
            Color.RGBtoHSB((m).cgrnd[0], (m).cgrnd[1], (m).cgrnd[2], fs);
            fs[1] -= 0.22;
            if (fs[1] < 0.0F)
                fs[1] = 0.0F;
            fs[2] += 0.22;
            if (fs[2] > 1.0F)
                fs[2] = 1.0F;
            Color color = Color.getHSBColor(fs[0], fs[1], fs[2]);
            if (!(app).cmsg.isShowing()) {
                (app).cmsg.show();
                (app).cmsg.requestFocus();
                lcmsg = "";
                (app).cmsg.setText("");
                (app).cmsg.setBackground(color);
            }
            app.movefield((app).cmsg, 91, 424, 576, 22);
            rd.setColor(color);
            rd.fillRect(676, 426, 109, 7);
            rd.setColor(new Color(0, 0, 0));
            rd.setFont(new Font("Tahoma", 1, 11));
            rd.drawString("Send Message  >", 684, 439);
            rd.drawRect(676, 426, 109, 17);
            if ((app).cmsg.getText().equals(lcmsg))
                cntchatp++;
            else
                cntchatp = -200;
            lcmsg = new StringBuilder().append("").append((app).cmsg.getText()).toString();
            if (cntchatp == 67)
                (control).chatup = false;
            if ((app).cmsg.getText().length() > 100) {
                (app).cmsg.setText((app).cmsg.getText().substring(0, 100));
                (app).cmsg.select(100, 100);
            }
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
        }
    }
    
    public void stopchat() {
        if (runtyp == -101) {
            runtyp = 0;
            try {
                socket.close();
                socket = null;
                din.close();
                din = null;
                dout.close();
                dout = null;
            } catch (Exception exception) {
                /* empty */
            }
        }
    }
    
    public void levelhigh(int i, int i_78_, int i_79_, int i_80_, int i_81_) {
        rd.drawImage(gameh, 301, 20, null);
        int i_82_ = 16;
        int i_83_ = 48;
        int i_84_ = 96;
        if (i_80_ < 50) {
            if (aflk) {
                i_82_ = 106;
                i_83_ = 176;
                i_84_ = 255;
                aflk = false;
            } else
                aflk = true;
        }
        if (i != im) {
            if (i_79_ == 0)
                drawcs(60, "You Wasted 'em!", i_82_, i_83_, i_84_, 0);
            else if (i_79_ == 1)
                drawcs(60, "Close Finish!", i_82_, i_83_, i_84_, 0);
            else
                drawcs(60, "Close Finish!  Almost got it!", i_82_, i_83_, i_84_, 0);
        } else if (i_78_ == 229) {
            if (discon != 240)
                drawcs(60, "Wasted!", i_82_, i_83_, i_84_, 0);
            else
                drawcs(60, "Disconnected!", i_82_, i_83_, i_84_, 0);
        } else if (i_81_ > 2 || i_81_ < 0)
            drawcs(60, "Stunts!", i_82_, i_83_, i_84_, 0);
        else
            drawcs(60, "Best Stunt!", i_82_, i_83_, i_84_, 0);
        drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
    }
    
    public void inst(Control control) {
        if (flipo == 0)
            flipo = 1;
        if (flipo == 2) {
            flipo = 3;
            dudo = 200;
        }
        if (flipo == 4) {
            flipo = 5;
            dudo = 250;
        }
        if (flipo == 6) {
            flipo = 7;
            dudo = 200;
        }
        if (flipo == 8) {
            flipo = 9;
            dudo = 250;
        }
        if (flipo == 10) {
            flipo = 11;
            dudo = 200;
        }
        if (flipo == 12) {
            flipo = 13;
            dudo = 200;
        }
        if (flipo == 14) {
            flipo = 15;
            dudo = 100;
        }
        mainbg(2);
        if (aflk)
            aflk = false;
        else
            aflk = true;
        if (flipo != 1 && flipo != 16) {
            if (dudo > 0) {
                if (aflk) {
                    if (Math.random() > Math.random())
                        duds = (int) (Math.random() * 3.0);
                    else
                        duds = (int) (Math.random() * 2.0);
                }
                dudo--;
            } else
                duds = 0;
            rd.drawImage(dude[duds], 95, 15, null);
            rd.drawImage(oflaot, 192, 42, null);
        }
        rd.setColor(new Color(0, 64, 128));
        rd.setFont(new Font("Arial", 1, 13));
        if (flipo == 3 || flipo == 5) {
            if (flipo == 3) {
                rd.drawString("Hello!  Welcome to the world of", 262, 67);
                rd.drawString("!", 657, 67);
                rd.drawImage(nfm, 469, 55, null);
                rd.drawString("In this game there are two ways to complete a stage.", 262, 107);
                rd.drawString("One is by racing and finishing in first place, the other is by", 262, 127);
                rd.drawString("wasting and crashing all the other cars in the stage!", 262, 147);
            } else {
                rd.setColor(new Color(0, 128, 255));
                rd.drawString("While racing, you will need to focus on going fast and passing", 262, 67);
                rd.drawString("through all the checkpoints in the track. To complete a lap, you", 262, 87);
                rd.drawString("must not miss a checkpoint.", 262, 107);
                rd.drawString("While wasting, you will just need to chase the other cars and", 262, 127);
                rd.drawString("crash into them (without worrying about track and checkpoints).", 262, 147);
            }
            rd.setColor(new Color(0, 0, 0));
            rd.drawImage(racing, 165, 185, null);
            rd.drawImage(ory, 429, 235, null);
            rd.drawImage(wasting, 492, 185, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("Checkpoint", 392, 189);
            rd.setFont(new Font("Arial", 1, 13));
            rd.drawString("Drive your car using the Arrow Keys and Spacebar", 125, 320);
            rd.drawImage(space, 171, 355, null);
            rd.drawImage(arrows, 505, 323, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 125, 341);
            rd.drawString("Accelerate", 515, 319);
            rd.drawString("Brake/Reverse", 506, 397);
            rd.drawString("Turn left", 454, 375);
            rd.drawString("Turn right", 590, 375);
            rd.drawString("Handbrake", 247, 374);
        }
        if (flipo == 7 || flipo == 9) {
            if (flipo == 7) {
                rd.drawString("Whether you are racing or wasting the other cars you will need", 262, 67);
                rd.drawString("to power up your car.", 262, 87);
                rd.drawString("=> More 'Power' makes your car become faster and stronger!", 262, 107);
                rd.drawString("To power up your car (and keep it powered up) you will need to", 262, 127);
                rd.drawString("perform stunts!", 262, 147);
                rd.drawImage(chil, 167, 295, null);
            } else {
                rd.drawString("The better the stunt the more power you get!", 262, 67);
                rd.setColor(new Color(0, 128, 255));
                rd.drawString("Forward looping pushes your car forwards in the air and helps", 262, 87);
                rd.drawString("when racing. Backward looping pushes your car upwards giving it", 262, 107);
                rd.drawString("more hang time in the air making it easier to control its landing.", 262, 127);
                rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 262, 147);
                if (aflk || dudo < 150)
                    rd.drawImage(chil, 167, 295, null);
            }
            rd.setColor(new Color(0, 0, 0));
            rd.drawImage(stunts, 105, 175, null);
            rd.drawImage(opwr, 540, 253, null);
            rd.setFont(new Font("Arial", 1, 13));
            rd.drawString("To perform stunts. When your car is in the AIR:", 125, 310);
            rd.drawString("Press combo Spacebar + Arrow Keys", 125, 330);
            rd.drawImage(space, 185, 355, null);
            rd.drawImage(plus, 405, 358, null);
            rd.drawImage(arrows, 491, 323, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Forward Loop", 492, 319);
            rd.drawString("Backward Loop", 490, 397);
            rd.drawString("Left Roll", 443, 375);
            rd.drawString("Right Roll", 576, 375);
            rd.drawString("Spacebar", 266, 374);
            rd.setColor(new Color(140, 243, 244));
            rd.fillRect(602, 257, 76, 9);
        }
        if (flipo == 11 || flipo == 13) {
            if (flipo == 11) {
                rd.drawString("When wasting cars, to help you find the other cars in the stage,", 262, 67);
                rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 262, 87);
                rd.drawString("to pointing to the cars.", 262, 107);
                rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 262, 127);
                rd.drawString("jumping through the electrified hoop.", 262, 147);
            } else {
                rd.setColor(new Color(0, 128, 255));
                rd.drawString("You will find that in some stages it's easier to waste the other cars", 262, 67);
                rd.drawString("and in some others it's easier to race and finish in first place.", 262, 87);
                rd.drawString("It is up to you to decide when to waste and when to race.", 262, 107);
                rd.drawString("And remember, 'Power' is an important factor in the game. You", 262, 127);
                rd.drawString("will need it whether you are racing or wasting!", 262, 147);
            }
            rd.setColor(new Color(0, 0, 0));
            rd.drawImage(fixhoop, 185, 218, null);
            rd.drawImage(sarrow, 385, 228, null);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawString("The Electrified Hoop", 192, 216);
            rd.drawString("Jumping through it fixes your car.", 158, 338);
            rd.drawString("Make guidance arrow point to cars.", 385, 216);
        }
        if (flipo == 15) {
            rd.drawString("And if you don\u2019t know who I am,", 262, 67);
            rd.drawString("I am Coach Insano, I am the coach and narrator of this game!", 262, 87);
            rd.drawString("I recommended to starting with NFM 1, if it\u2019s your first time to play.", 262, 127);
            rd.drawString("Good Luck & Have Fun!", 262, 147);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Other Controls :", 155, 205);
            rd.setFont(new Font("Arial", 1, 11));
            rd.drawImage(kz, 169, 229, null);
            rd.drawString("OR", 206, 251);
            rd.drawImage(kx, 229, 229, null);
            rd.drawString("To look behind you while driving.", 267, 251);
            rd.drawImage(kv, 169, 279, null);
            rd.drawString("Change Views", 207, 301);
            rd.drawImage(kenter, 169, 329, null);
            rd.drawString("Navigate & Pause Game", 275, 351);
            rd.drawImage(km, 489, 229, null);
            rd.drawString("Mute Music", 527, 251);
            rd.drawImage(kn, 489, 279, null);
            rd.drawString("Mute Sound Effects", 527, 301);
        }
        if (flipo == 1 || flipo == 16) {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            if (flipo == 16) {
                rd.drawImage(mrc, 268, 32, null);
                rd.drawString("Once Again!", 455, 49);
            } else
                rd.drawImage(mrc, 310, 32, null);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Drive your car using the Arrow Keys:", 125, 80);
            rd.drawString("On the GROUND Spacebar is for Handbrake", 125, 101);
            rd.drawImage(space, 171, 115, null);
            rd.drawImage(arrows, 505, 83, null);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.drawString("Accelerate", 515, 79);
            rd.drawString("Brake/Reverse", 506, 157);
            rd.drawString("Turn left", 454, 135);
            rd.drawString("Turn right", 590, 135);
            rd.drawString("Handbrake", 247, 134);
            drawcs(175, "----------------------------------------------------------------------------------------------------------------------------------------------------", 0, 64, 128, 3);
            rd.setColor(new Color(0, 0, 0));
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            rd.drawString("To perform STUNTS:", 125, 200);
            rd.drawString("In the AIR press combo Spacebar + Arrow Keys", 125, 220);
            rd.drawImage(space, 185, 245, null);
            rd.drawImage(plus, 405, 248, null);
            rd.drawImage(arrows, 491, 213, null);
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Forward Loop", 492, 209);
            rd.drawString("Backward Loop", 490, 287);
            rd.drawString("Left Roll", 443, 265);
            rd.drawString("Right Roll", 576, 265);
            rd.drawString("Spacebar", 266, 264);
            rd.drawImage(stunts, 125, 285, null);
        }
        if (flipo >= 1 && flipo <= 15)
            rd.drawImage(next[pnext], 665, 395, null);
        if (flipo >= 3 && flipo <= 16)
            rd.drawImage(back[pback], 75, 395, null);
        if (flipo == 16)
            rd.drawImage(contin[pcontin], 565, 395, null);
        if ((control).enter || (control).right) {
            if ((control).enter && flipo == 16) {
                flipo = 0;
                fase = oldfase;
                rd.setFont(new Font("Arial", 1, 11));
                ftm = rd.getFontMetrics();
            }
            (control).enter = false;
            (control).right = false;
            if (flipo >= 1 && flipo <= 15)
                flipo++;
        }
        if ((control).left) {
            if (flipo >= 3 && flipo <= 15)
                flipo -= 3;
            if (flipo == 16)
                flipo--;
            (control).left = false;
        }
    }
    
    public void maini(Control control) {
        if (flipo == 0)
            app.setCursor(new Cursor(0));
        mainbg(1);
        if (flipo > flkat)
            rd.drawImage(logomadbg, 132 + (int) (4.0 - Math.random() * 8.0), 168 + (int) (4.0 - Math.random() * 8.0), null);
        else
            rd.drawImage(logomadbg, 132, 168, null);
        rd.drawImage(dude[0], xdu, ydu, null);
        rd.drawImage(logocars, 77, 53, null);
        if (flipo > flkat)
            rd.drawImage(logomadnes, 164 + (int) (4.0 - Math.random() * 8.0), 173 + (int) (4.0 - Math.random() * 8.0), null);
        else
            rd.drawImage(logomadnes, 164, 173, null);
        flipo++;
        if (flipo > flkat + 36) {
            flipo = 1;
            flkat = (int) (60.0 + 140.0 * Math.random());
        }
        if (movly <= 10) {
            if (movly == 10 || movly == 8 || movly == 6 || movly == 4 || movly == 2) {
                gxdu = (int) ((double) (xdu + 200) - 400.0 * Math.random());
                gydu = (int) ((double) (ydu + 200) - 400.0 * Math.random());
                if (movly == 2) {
                    gxdu = 337;
                    gydu = 27;
                }
                movly--;
            }
            xdu += (gxdu - xdu) / 15;
            ydu += (gydu - ydu) / 15;
            if (movly != 1) {
                if (pys(xdu, gxdu, ydu, gydu) < 20.0F)
                    movly--;
            } else {
                if (xdu > gxdu)
                    xdu--;
                else
                    xdu++;
                if (ydu > gydu)
                    ydu--;
                else
                    ydu++;
                if (pys(xdu, gxdu, ydu, gydu) < 2.0F)
                    movly--;
            }
            if (movly == 0) {
                xdu = 337;
                ydu = 27;
                movly = (int) (100.0 + 100.0 * Math.random());
            }
        } else if (flipo >= movly)
            movly = 10;
        rd.drawImage(opback, 247, 237, null);
        if (muhi < 0) {
            rd.setColor(new Color(140, 70, 0));
            rd.fillRoundRect(335, 293, 114, 19, 7, 20);
        }
        muhi--;
        if (muhi < -5)
            muhi = 50;
        if ((control).up) {
            opselect--;
            if (opselect == -1)
                opselect = 3;
            (control).up = false;
        }
        if ((control).down) {
            opselect++;
            if (opselect == 4)
                opselect = 0;
            (control).down = false;
        }
        if (opselect == 0) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(343, 261, 110, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 255, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(343, 261, 110, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(343, 261, 110, 22, 7, 20);
        }
        if (opselect == 1) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(288, 291, 221, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 191, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 95, 0));
                aflk = true;
            }
            rd.drawRoundRect(288, 291, 221, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(288, 291, 221, 22, 7, 20);
        }
        if (opselect == 2) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(301, 321, 196, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 128, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(301, 321, 196, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(301, 321, 196, 22, 7, 20);
        }
        if (opselect == 3) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(357, 351, 85, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 0, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(357, 351, 85, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(357, 351, 85, 22, 7, 20);
        }
        rd.drawImage(opti, 294, 265, null);
        if ((control).enter || (control).handb) {
            if (opselect == 1) {
                mtop = true;
                multion = 1;
                gmode = 0;
                if (firstime) {
                    oldfase = -9;
                    fase = 11;
                    firstime = false;
                } else
                    fase = -9;
            }
            if (opselect == 2) {
                oldfase = 10;
                fase = 11;
                firstime = false;
            }
            if (opselect == 3)
                fase = 8;
            if (opselect == 0) {
                if (unlocked[0] == 11) {
                    if (unlocked[1] != 17)
                        opselect = 1;
                    else
                        opselect = 2;
                }
                if (firstime) {
                    oldfase = 102;
                    fase = 11;
                    firstime = false;
                } else
                    fase = 102;
            }
            flipo = 0;
            (control).enter = false;
            (control).handb = false;
        }
        rd.drawImage(byrd, 72, 408, null);
        rd.drawImage(nfmcoms, 532, 408, null);
        if (shaded) {
            app.repaint();
            try {
                Thread.sleep(200L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
    }
    
    public void maini2(Control control, int i, int i_85_, int i_86_) {
        mainbg(1);
        if (flipo > flkat)
            rd.drawImage(logomadbg, 132 + (int) (4.0 - Math.random() * 8.0), 168 + (int) (4.0 - Math.random() * 8.0), null);
        else
            rd.drawImage(logomadbg, 132, 168, null);
        rd.drawImage(dude[0], xdu, ydu, null);
        rd.drawImage(logocars, 77, 53, null);
        if (flipo > flkat)
            rd.drawImage(logomadnes, 164 + (int) (4.0 - Math.random() * 8.0), 173 + (int) (4.0 - Math.random() * 8.0), null);
        else
            rd.drawImage(logomadnes, 164, 173, null);
        flipo++;
        if (flipo > flkat + 36) {
            flipo = 1;
            flkat = (int) (60.0 + 140.0 * Math.random());
        }
        if (movly <= 10) {
            if (movly == 10 || movly == 8 || movly == 6 || movly == 4 || movly == 2) {
                gxdu = (int) ((double) (xdu + 200) - 400.0 * Math.random());
                gydu = (int) ((double) (ydu + 200) - 400.0 * Math.random());
                if (movly == 2) {
                    gxdu = 337;
                    gydu = 27;
                }
                movly--;
            }
            xdu += (gxdu - xdu) / 15;
            ydu += (gydu - ydu) / 15;
            if (movly != 1) {
                if (pys(xdu, gxdu, ydu, gydu) < 20.0F)
                    movly--;
            } else {
                if (xdu > gxdu)
                    xdu--;
                else
                    xdu++;
                if (ydu > gydu)
                    ydu--;
                else
                    ydu++;
                if (pys(xdu, gxdu, ydu, gydu) < 2.0F)
                    movly--;
            }
            if (movly == 0) {
                xdu = 337;
                ydu = 27;
                movly = (int) (100.0 + 100.0 * Math.random());
            }
        } else if (flipo >= movly)
            movly = 10;
        rd.drawImage(opback, 247, 237, null);
        if ((control).up) {
            opselect--;
            if (opselect == -1)
                opselect = 3 - dropf / 15;
            (control).up = false;
        }
        if ((control).down) {
            opselect++;
            if (opselect == 4 - dropf / 15)
                opselect = 0;
            (control).down = false;
        }
        if (opselect == 0) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(358, 262 + dropf, 82, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 64, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(358, 262 + dropf, 82, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(358, 262 + dropf, 82, 22, 7, 20);
        }
        if (opselect == 1) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(358, 290 + dropf, 82, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 64, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 95, 0));
                aflk = true;
            }
            rd.drawRoundRect(358, 290 + dropf, 82, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(358, 290 + dropf, 82, 22, 7, 20);
        }
        if (opselect == 2) {
            if (shaded) {
                rd.setColor(new Color(140, 70, 0));
                rd.fillRect(333, 318 + dropf, 132, 22);
                aflk = false;
            }
            if (aflk) {
                rd.setColor(new Color(200, 255, 0));
                aflk = false;
            } else {
                rd.setColor(new Color(255, 128, 0));
                aflk = true;
            }
            rd.drawRoundRect(333, 318 + dropf, 132, 22, 7, 20);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.drawRoundRect(333, 318 + dropf, 132, 22, 7, 20);
        }
        if (dropf == 0) {
            if (opselect == 3) {
                if (shaded) {
                    rd.setColor(new Color(140, 70, 0));
                    rd.fillRect(348, 346, 102, 22);
                    aflk = false;
                }
                if (aflk) {
                    rd.setColor(new Color(200, 64, 0));
                    aflk = false;
                } else {
                    rd.setColor(new Color(255, 128, 0));
                    aflk = true;
                }
                rd.drawRoundRect(348, 346, 102, 22, 7, 20);
            } else {
                rd.setColor(new Color(0, 0, 0));
                rd.drawRoundRect(348, 346, 102, 22, 7, 20);
            }
        }
        rd.drawImage(opti2, 346, 265 + dropf, null);
        if (dropf != 0) {
            rd.setColor(new Color(58, 30, 8));
            rd.fillRect(357, 365, 87, 15);
        }
        if ((control).enter || (control).handb) {
            mtop = false;
            if (opselect == 0) {
                multion = 0;
                gmode = 1;
                fase = -9;
            }
            if (opselect == 1) {
                multion = 0;
                gmode = 2;
                fase = -9;
                opselect = 0;
            }
            if (dropf == 0 && opselect == 3) {
                multion = 0;
                gmode = 0;
                fase = -9;
                opselect = 0;
            }
            if (opselect == 2) {
                multion = 1;
                gmode = 0;
                if (firstime) {
                    oldfase = -9;
                    fase = 11;
                    firstime = false;
                } else
                    fase = -9;
            }
            flipo = 0;
            (control).enter = false;
            (control).handb = false;
        }
        rd.drawImage(byrd, 72, 408, null);
        rd.drawImage(nfmcoms, 532, 408, null);
        boolean bool = false;
        if (i_86_ == 2)
            bool = true;
        if (drawcarb(true, null, "   < Back   ", 161, 313, i, i_85_, bool)) {
            opselect = 0;
            fase = 10;
        }
        if (shaded) {
            app.repaint();
            try {
                Thread.sleep(200L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
    }
    
    public void pausedgame(int i, Control control, Record record) {
        if (!badmac)
            rd.drawImage(fleximg, 0, 0, null);
        else {
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(0, 0, 800, 450);
            rd.setColor(new Color(30, 67, 110));
            rd.fillRect(281, 8, 237, 188);
        }
        if ((control).up) {
            opselect--;
            if (opselect == -1)
                opselect = 3;
            (control).up = false;
        }
        if ((control).down) {
            opselect++;
            if (opselect == 4)
                opselect = 0;
            (control).down = false;
        }
        if (opselect == 0) {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(329, 45, 137, 22, 7, 20);
            if (shaded)
                rd.setColor(new Color(225, 200, 255));
            else
                rd.setColor(new Color(0, 89, 223));
            rd.drawRoundRect(329, 45, 137, 22, 7, 20);
        }
        if (opselect == 1) {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(320, 73, 155, 22, 7, 20);
            if (shaded)
                rd.setColor(new Color(225, 200, 255));
            else
                rd.setColor(new Color(0, 89, 223));
            rd.drawRoundRect(320, 73, 155, 22, 7, 20);
        }
        if (opselect == 2) {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(303, 99, 190, 22, 7, 20);
            if (shaded)
                rd.setColor(new Color(225, 200, 255));
            else
                rd.setColor(new Color(0, 89, 223));
            rd.drawRoundRect(303, 99, 190, 22, 7, 20);
        }
        if (opselect == 3) {
            rd.setColor(new Color(64, 143, 223));
            rd.fillRoundRect(341, 125, 109, 22, 7, 20);
            if (shaded)
                rd.setColor(new Color(225, 200, 255));
            else
                rd.setColor(new Color(0, 89, 223));
            rd.drawRoundRect(341, 125, 109, 22, 7, 20);
        }
        rd.drawImage(paused, 281, 8, null);
        if ((control).enter || (control).handb) {
            if (opselect == 0) {
                if (loadedt && !mutem)
                    strack.resume();
                fase = 0;
            }
            if (opselect == 1) {
                if ((record).caught >= 300) {
                    if (loadedt && !mutem)
                        strack.resume();
                    fase = -1;
                } else
                    fase = -8;
            }
            if (opselect == 2) {
                if (loadedt)
                    strack.stop();
                oldfase = -7;
                fase = 11;
            }
            if (opselect == 3) {
                if (loadedt)
                    strack.unload();
                fase = 102;
                if (gmode == 0)
                    opselect = 3;
                if (gmode == 1)
                    opselect = 0;
                if (gmode == 2)
                    opselect = 1;
                rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            }
            (control).enter = false;
            (control).handb = false;
        }
    }
    
    public void replyn() {
        if (aflk) {
            drawcs(30, "Replay  > ", 0, 0, 0, 0);
            aflk = false;
        } else {
            drawcs(30, "Replay  >>", 0, 128, 255, 0);
            aflk = true;
        }
    }
    
    public void cantreply() {
        rd.setColor(new Color(64, 143, 223));
        rd.fillRoundRect(200, 73, 400, 23, 7, 20);
        rd.setColor(new Color(0, 89, 223));
        rd.drawRoundRect(200, 73, 400, 23, 7, 20);
        drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }
    
    public void nofocus() {
        rd.setColor(new Color(255, 255, 255));
        rd.fillRect(0, 0, 800, 20);
        rd.fillRect(0, 0, 20, 450);
        rd.fillRect(0, 430, 800, 20);
        rd.fillRect(780, 0, 20, 450);
        rd.setColor(new Color(192, 192, 192));
        rd.drawRect(20, 20, 760, 410);
        rd.setColor(new Color(0, 0, 0));
        rd.drawRect(22, 22, 756, 406);
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        drawcs(14, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
        drawcs(445, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
    }
    
    public void inishcarselect(ContO[] contos) {
        nplayers = 7;
        im = 0;
        xstart[0] = 0;
        xstart[1] = -350;
        xstart[2] = 350;
        xstart[3] = 0;
        xstart[4] = -350;
        xstart[5] = 350;
        xstart[6] = 0;
        zstart[0] = -760;
        zstart[1] = -380;
        zstart[2] = -380;
        zstart[3] = 0;
        zstart[4] = 380;
        zstart[5] = 380;
        zstart[6] = 760;
        onmsc = -1;
        remi = false;
        lfrom = 0;
        noclass = false;
        if (testdrive != 1 && testdrive != 2) {
            if (gmode != 0) {
                cfase = 0;
                sc[0] = scm[gmode - 1];
            }
            if (gmode == 0)
                sc[0] = osc;
            if (cfase == 0 && sc[0] > 15) {
                onmsc = sc[0];
                sc[0] = 15;
                if (multion != 0)
                    cfase = -1;
            }
            if (onjoin != -1 && multion != 0) {
                if (ontyp <= -2)
                    cfase = 0;
                if (ontyp >= 20) {
                    ontyp -= 20;
                    cfase = 0;
                }
                if (ontyp >= 10) {
                    ontyp -= 10;
                    if ((cd).lastload != 2) {
                        cfase = -1;
                        onjoin = -1;
                    } else
                        cfase = 3;
                }
            }
            if (cfase == 3) {
                if (multion != 0 && (cd).lastload == 1) {
                    sc[0] = 15;
                    minsl = 0;
                    maxsl = 15;
                    cfase = 0;
                }
                if ((cd).lastload == 0) {
                    sc[0] = 15;
                    minsl = 0;
                    maxsl = 15;
                    cfase = 0;
                }
                if ((cd).lastload == 2) {
                    minsl = 16;
                    maxsl = (cd).nlocars - 1;
                    if (sc[0] < minsl)
                        sc[0] = minsl;
                    if (sc[0] > maxsl)
                        sc[0] = maxsl;
                    if (onjoin != -1 && multion != 0 && ontyp > 0 && ontyp <= 5) {
                        boolean bool = false;
                        for (int i = 16; i < (cd).nlocars; i++) {
                            if (Math.abs((cd).cclass[i] - (ontyp - 1)) <= 1) {
                                if (!bool) {
                                    minsl = i;
                                    bool = true;
                                }
                                if (bool)
                                    maxsl = i;
                            }
                        }
                        if (!bool) {
                            onjoin = -1;
                            noclass = true;
                        } else {
                            if (sc[0] < minsl)
                                sc[0] = minsl;
                            if (sc[0] > maxsl)
                                sc[0] = maxsl;
                            if (Math.abs((cd).cclass[sc[0]] - (ontyp - 1)) > 1)
                                sc[0] = minsl;
                        }
                    }
                }
            }
            if (cfase == 0) {
                minsl = 0;
                maxsl = 15;
                if (onjoin != -1 && multion != 0) {
                    if (ontyp == 1) {
                        minsl = 0;
                        maxsl = 5;
                    }
                    if (ontyp == 2) {
                        minsl = 0;
                        maxsl = 9;
                    }
                    if (ontyp == 3) {
                        minsl = 5;
                        maxsl = 10;
                    }
                    if (ontyp == 4) {
                        minsl = 6;
                        maxsl = 15;
                    }
                    if (ontyp == 5) {
                        minsl = 10;
                        maxsl = 15;
                    }
                    if (ontyp <= -2) {
                        minsl = Math.abs(ontyp + 2);
                        maxsl = Math.abs(ontyp + 2);
                    }
                }
                if (sc[0] < minsl)
                    sc[0] = minsl;
                if (sc[0] > maxsl)
                    sc[0] = maxsl;
            }
        } else {
            minsl = sc[0];
            maxsl = sc[0];
        }
        carsbginflex();
        flatrstart = 0;
        (m).lightson = false;
        pnext = 0;
        pback = 0;
        lsc = -1;
        mouson = -1;
        if (multion == 0) {
            (app).mycar.setLabel(" Include in this game.");
            (app).mycar.setBackground(new Color(198, 179, 129));
            (app).mycar.setForeground(new Color(0, 0, 0));
            int i = 16;
            if ((cd).lastload == 2)
                i = (cd).nlocars;
            for (int i_87_ = 0; i_87_ < i; i_87_++) {
                float[] fs = new float[3];
                Color.RGBtoHSB((contos[i_87_]).fcol[0], (contos[i_87_]).fcol[1], (contos[i_87_]).fcol[2], fs);
                for (int i_88_ = 0; i_88_ < (contos[i_87_]).npl; i_88_++) {
                    if (((contos[i_87_]).p[i_88_]).colnum == 1) {
                        ((contos[i_87_]).p[i_88_]).hsb[0] = fs[0];
                        ((contos[i_87_]).p[i_88_]).hsb[1] = fs[1];
                        ((contos[i_87_]).p[i_88_]).hsb[2] = fs[2];
                        ((contos[i_87_]).p[i_88_]).oc[0] = (contos[i_87_]).fcol[0];
                        ((contos[i_87_]).p[i_88_]).oc[1] = (contos[i_87_]).fcol[1];
                        ((contos[i_87_]).p[i_88_]).oc[2] = (contos[i_87_]).fcol[2];
                    }
                }
                Color.RGBtoHSB((contos[i_87_]).scol[0], (contos[i_87_]).scol[1], (contos[i_87_]).scol[2], fs);
                for (int i_89_ = 0; i_89_ < (contos[i_87_]).npl; i_89_++) {
                    if (((contos[i_87_]).p[i_89_]).colnum == 2) {
                        ((contos[i_87_]).p[i_89_]).hsb[0] = fs[0];
                        ((contos[i_87_]).p[i_89_]).hsb[1] = fs[1];
                        ((contos[i_87_]).p[i_89_]).hsb[2] = fs[2];
                        ((contos[i_87_]).p[i_89_]).oc[0] = (contos[i_87_]).scol[0];
                        ((contos[i_87_]).p[i_89_]).oc[1] = (contos[i_87_]).scol[1];
                        ((contos[i_87_]).p[i_89_]).oc[2] = (contos[i_87_]).scol[2];
                    }
                }
                (contos[i_87_]).xy = 0;
            }
            for (int i_90_ = 0; i_90_ < 6; i_90_++)
                arnp[i_90_] = -1.0F;
        }
        (m).trk = 0;
        (m).crs = true;
        (m).x = -400;
        (m).y = -525;
        (m).z = -50;
        (m).xz = 0;
        (m).zy = 10;
        (m).ground = 495;
        (m).ih = 0;
        (m).iw = 0;
        (m).h = 450;
        (m).w = 800;
        (m).focus_point = 400;
        (m).cx = 400;
        (m).cy = 225;
        (m).cz = 50;
        intertrack.loadimod(false);
        intertrack.play();
    }
    
    public void carselect(Control control, ContO[] contos, Mad mad, int i, int i_91_, boolean bool) {
        if (!fbrl) {
            brl++;
            if (brl >= 50) {
                brl = 50;
                fbrl = true;
            }
        } else {
            brl--;
            if (brl <= 10) {
                brl = 10;
                fbrl = false;
            }
        }
        rd.setColor(new Color(brl * 2, brl, 0));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
        if (flatrstart == 6) {
            if (multion != 0 || testdrive == 1 || testdrive == 2)
                rd.drawImage(carsbgc, 65, 25, null);
            else
                rd.drawImage(carsbg, 65, 25, null);
        } else if (flatrstart <= 1)
            drawSmokeCarsbg();
        else {
            rd.setColor(new Color(255, 255, 255));
            rd.fillRect(65, 25, 670, 400);
            carsbginflex();
            flatrstart = 6;
        }
        rd.drawImage(selectcar, 321, 37, null);
        if (cfase == 3 || cfase == 7 || remi) {
            if ((cd).lastload == 1)
                rd.drawImage(ycmc, 337, 58, null);
            if ((cd).lastload == 2)
                rd.drawImage(yac, 323, 58, null);
        }
        if (cfase == 11) {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            String string = "Top 20 Cars";
            int i_92_ = (cd).lastload - 2;
            String string_93_ = "Weekly";
            while (i_92_ > 6) {
                i_92_ -= 6;
                if (string_93_.equals("Monthly"))
                    string_93_ = "All Time";
                if (string_93_.equals("Weekly"))
                    string_93_ = "Monthly";
            }
            if (i_92_ == 1)
                string = new StringBuilder().append("").append(string_93_).append(" Top 20 Cars").toString();
            if (i_92_ == 2)
                string = new StringBuilder().append("").append(string_93_).append(" Top 20 Class A Cars").toString();
            if (i_92_ == 3)
                string = new StringBuilder().append("").append(string_93_).append(" Top 20 Class A & B Cars").toString();
            if (i_92_ == 4)
                string = new StringBuilder().append("").append(string_93_).append(" Top 20 Class B Cars").toString();
            if (i_92_ == 5)
                string = new StringBuilder().append("").append(string_93_).append(" Top 20 Class B & C Cars").toString();
            if (i_92_ == 6)
                string = new StringBuilder().append("").append(string_93_).append(" Top 20 Class C Cars").toString();
            drawcs(69, string, 120, 176, 255, 3);
        }
        if (!remi)
            contos[sc[0]].d(rd);
        if (cfase == 8) {
            drawprom(150, 85);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            drawcs(195, "Removing Car...", 0, 0, 0, 3);
            if ((cd).action != 10) {
                if ((cd).action != -10)
                    cfase = 5;
                else
                    cfase = 9;
            }
        }
        if ((multion != 0 || testdrive == 1 || testdrive == 2) && lsc != sc[0]) {
            if ((contos[sc[0]]).xy != 0)
                (contos[sc[0]]).xy = 0;
            boolean bool_94_ = false;
            for (int i_95_ = 0; i_95_ < (contos[sc[0]]).npl && !bool_94_; i_95_++) {
                if (((contos[sc[0]]).p[i_95_]).colnum == 1) {
                    float[] fs = new float[3];
                    Color.RGBtoHSB(((contos[sc[0]]).p[i_95_]).c[0], ((contos[sc[0]]).p[i_95_]).c[1], ((contos[sc[0]]).p[i_95_]).c[2], fs);
                    arnp[0] = fs[0];
                    arnp[1] = fs[1];
                    arnp[2] = 1.0F - fs[2];
                    bool_94_ = true;
                }
            }
            bool_94_ = false;
            for (int i_96_ = 0; i_96_ < (contos[sc[0]]).npl && !bool_94_; i_96_++) {
                if (((contos[sc[0]]).p[i_96_]).colnum == 2) {
                    float[] fs = new float[3];
                    Color.RGBtoHSB(((contos[sc[0]]).p[i_96_]).c[0], ((contos[sc[0]]).p[i_96_]).c[1], ((contos[sc[0]]).p[i_96_]).c[2], fs);
                    arnp[3] = fs[0];
                    arnp[4] = fs[1];
                    arnp[5] = 1.0F - fs[2];
                    bool_94_ = true;
                }
            }
            Color color = Color.getHSBColor(arnp[0], arnp[1], 1.0F - arnp[2]);
            Color color_97_ = Color.getHSBColor(arnp[3], arnp[4], 1.0F - arnp[5]);
            for (int i_98_ = 0; i_98_ < (contos[sc[0]]).npl; i_98_++) {
                if (((contos[sc[0]]).p[i_98_]).colnum == 1) {
                    ((contos[sc[0]]).p[i_98_]).hsb[0] = arnp[0];
                    ((contos[sc[0]]).p[i_98_]).hsb[1] = arnp[1];
                    ((contos[sc[0]]).p[i_98_]).hsb[2] = 1.0F - arnp[2];
                    ((contos[sc[0]]).p[i_98_]).c[0] = color.getRed();
                    ((contos[sc[0]]).p[i_98_]).c[1] = color.getGreen();
                    ((contos[sc[0]]).p[i_98_]).c[2] = color.getBlue();
                    ((contos[sc[0]]).p[i_98_]).oc[0] = color.getRed();
                    ((contos[sc[0]]).p[i_98_]).oc[1] = color.getGreen();
                    ((contos[sc[0]]).p[i_98_]).oc[2] = color.getBlue();
                }
                if (((contos[sc[0]]).p[i_98_]).colnum == 2) {
                    ((contos[sc[0]]).p[i_98_]).hsb[0] = arnp[3];
                    ((contos[sc[0]]).p[i_98_]).hsb[1] = arnp[4];
                    ((contos[sc[0]]).p[i_98_]).hsb[2] = 1.0F - arnp[5];
                    ((contos[sc[0]]).p[i_98_]).c[0] = color_97_.getRed();
                    ((contos[sc[0]]).p[i_98_]).c[1] = color_97_.getGreen();
                    ((contos[sc[0]]).p[i_98_]).c[2] = color_97_.getBlue();
                    ((contos[sc[0]]).p[i_98_]).oc[0] = color_97_.getRed();
                    ((contos[sc[0]]).p[i_98_]).oc[1] = color_97_.getGreen();
                    ((contos[sc[0]]).p[i_98_]).oc[2] = color_97_.getBlue();
                }
            }
            lsc = sc[0];
        }
        int i_99_ = -1;
        int i_100_ = 0;
        if (flipo == 0) {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            int i_101_ = 0;
            if (flatrstart < 6)
                i_101_ = 2;
            if (!remi && (cfase != 10 || (cd).action != 0 && (cd).action < 14)) {
                String string = "";
                if (cfase == 11)
                    string = new StringBuilder().append("N#").append(sc[0] - 15).append("  ").toString();
                if (aflk) {
                    drawcs(95 + i_101_, new StringBuilder().append(string).append((cd).names[sc[0]]).toString(), 240, 240, 240, 3);
                    aflk = false;
                } else {
                    drawcs(95, new StringBuilder().append(string).append((cd).names[sc[0]]).toString(), 176, 176, 176, 3);
                    aflk = true;
                }
            }
            (contos[sc[0]]).z = 950;
            if (sc[0] == 13)
                (contos[sc[0]]).z = 1000;
            (contos[sc[0]]).y = -34 - (contos[sc[0]]).grat;
            (contos[sc[0]]).x = 0;
            if (mouson >= 0 && mouson <= 3)
                (contos[sc[0]]).xz += 2;
            else
                (contos[sc[0]]).xz += 5;
            if ((contos[sc[0]]).xz > 360)
                (contos[sc[0]]).xz -= 360;
            (contos[sc[0]]).zy = 0;
            (contos[sc[0]]).wzy -= 10;
            if ((contos[sc[0]]).wzy < -30)
                (contos[sc[0]]).wzy += 30;
            if (!remi) {
                if (sc[0] != minsl)
                    rd.drawImage(back[pback], 95, 275, null);
                if (sc[0] != maxsl)
                    rd.drawImage(next[pnext], 645, 275, null);
            }
            if (gmode == 1) {
                if (sc[0] == 5 && unlocked[0] <= 2)
                    i_100_ = 2;
                if (sc[0] == 6 && unlocked[0] <= 4)
                    i_100_ = 4;
                if (sc[0] == 11 && unlocked[0] <= 6)
                    i_100_ = 6;
                if (sc[0] == 14 && unlocked[0] <= 8)
                    i_100_ = 8;
                if (sc[0] == 15 && unlocked[0] <= 10)
                    i_100_ = 10;
            }
            if (gmode == 2 && sc[0] >= 8 && unlocked[1] <= (sc[0] - 7) * 2)
                i_100_ = (sc[0] - 7) * 2;
            if (i_100_ != 0) {
                if (gatey == 300) {
                    for (int i_102_ = 0; i_102_ < 9; i_102_++) {
                        pgas[i_102_] = false;
                        pgady[i_102_] = 0;
                    }
                    pgas[0] = true;
                }
                for (int i_103_ = 0; i_103_ < 9; i_103_++) {
                    rd.drawImage(pgate, pgatx[i_103_], pgaty[i_103_] + pgady[i_103_] - gatey, null);
                    if (flatrstart == 6) {
                        if (pgas[i_103_]) {
                            pgady[i_103_] -= (80 + 100 / (i_103_ + 1) - Math.abs(pgady[i_103_])) / 3;
                            if (pgady[i_103_] < -(70 + 100 / (i_103_ + 1))) {
                                pgas[i_103_] = false;
                                if (i_103_ != 8)
                                    pgas[i_103_ + 1] = true;
                            }
                        } else {
                            pgady[i_103_] += (80 + 100 / (i_103_ + 1) - Math.abs(pgady[i_103_])) / 3;
                            if (pgady[i_103_] > 0)
                                pgady[i_103_] = 0;
                        }
                    }
                }
                if (gatey != 0)
                    gatey -= 100;
                if (flatrstart == 6) {
                    drawcs(355, "[ Car Locked ]", 210, 210, 210, 3);
                    drawcs(375, new StringBuilder().append("This car unlocks when stage ").append(i_100_).append(" is completed...").toString(), 255, 96, 0, 3);
                }
            } else {
                if (flatrstart == 6) {
                    if (cfase == 10) {
                        if ((cd).action == 13) {
                            minsl = 16;
                            maxsl = (cd).nlocars - 1;
                            i_99_ = 16;
                            (cd).action = 0;
                            cfase = 11;
                        }
                        if ((cd).action == 12) {
                            int i_104_ = (cd).loadlist;
                            String string = "Top 20 Cars";
                            String string_105_ = "Weekly";
                            while (i_104_ > 6) {
                                i_104_ -= 6;
                                if (string_105_.equals("Monthly"))
                                    string_105_ = "All Time";
                                if (string_105_.equals("Weekly"))
                                    string_105_ = "Monthly";
                            }
                            if (i_104_ == 1)
                                string = new StringBuilder().append("").append(string_105_).append(" Top 20 Cars").toString();
                            if (i_104_ == 2)
                                string = new StringBuilder().append("").append(string_105_).append(" Top 20 Class A Cars").toString();
                            if (i_104_ == 3)
                                string = new StringBuilder().append("").append(string_105_).append(" Top 20 Class A & B Cars").toString();
                            if (i_104_ == 4)
                                string = new StringBuilder().append("").append(string_105_).append(" Top 20 Class B Cars").toString();
                            if (i_104_ == 5)
                                string = new StringBuilder().append("").append(string_105_).append(" Top 20 Class B & C Cars").toString();
                            if (i_104_ == 6)
                                string = new StringBuilder().append("").append(string_105_).append(" Top 20 Class C Cars").toString();
                            drawprom(145, 170);
                            drawcs(195, new StringBuilder().append("[  Loading ").append(string).append("  ]").toString(), 0, 0, 0, 3);
                            if ((cd).nl > 0 && (cd).nl <= 20)
                                drawcs(235, new StringBuilder().append("Loading :  ").append((cd).loadnames[(cd).nl - 1]).append("").toString(), 0, 0, 0, 3);
                        }
                        if ((cd).action == 11) {
                            drawprom(145, 170);
                            drawcs(195, "Loading List, Please Wait...", 0, 0, 0, 3);
                        }
                        if ((cd).action == -1) {
                            drawprom(145, 170);
                            drawcs(195, "Failed to Load List", 0, 0, 0, 3);
                            drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, i, i_91_, bool)) {
                                if (lfrom <= 2) {
                                    if (lfrom == 2)
                                        cfase = 3;
                                    else
                                        cfase = 0;
                                    lfrom = 0;
                                } else {
                                    lfrom -= 2;
                                    (cd).action = 0;
                                    cfase = 11;
                                }
                            }
                        }
                        if ((cd).action == 0 || (cd).action == 14 || (cd).action == 15 || (cd).action == 16) {
                            drawprom(65, 250);
                            if (drawcarb(true, null, " X ", 557, 70, i, i_91_, bool)) {
                                if (lfrom <= 2) {
                                    if (lfrom == 2)
                                        cfase = 3;
                                    else
                                        cfase = 0;
                                    lfrom = 0;
                                } else {
                                    lfrom -= 2;
                                    (cd).action = 0;
                                    cfase = 11;
                                }
                            }
                            drawcs(305, "The lists get updated every 24 hours!", 0, 0, 0, 3);
                            if ((cd).action == 14 || (cd).action == 15 || (cd).action == 16) {
                                if (!bool && cntflock == 20)
                                    cntflock = 0;
                                if ((cd).action == 14)
                                    drawcs(91, "Weekly Top 20 Cars", 0, 0, 0, 3);
                                if ((cd).action == 15)
                                    drawcs(91, "Monthly Top 20 Cars", 0, 0, 0, 3);
                                if ((cd).action == 16)
                                    drawcs(91, "All Time Top 20 Cars", 0, 0, 0, 3);
                                if (drawcarb(true, null, "   All Cars, All Classes   ", 318, 105, i, i_91_, bool) && cntflock == 0) {
                                    if (lfrom > 2)
                                        lfrom -= 2;
                                    (cd).loadlist = 1 + ((cd).action - 14) * 6;
                                    (cd).action = 11;
                                    cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class A Cars", 337, 135, i, i_91_, bool) && cntflock == 0) {
                                    if (lfrom > 2)
                                        lfrom -= 2;
                                    (cd).loadlist = 2 + ((cd).action - 14) * 6;
                                    (cd).action = 11;
                                    cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class A & B Cars", 337, 165, i, i_91_, bool) && cntflock == 0) {
                                    if (lfrom > 2)
                                        lfrom -= 2;
                                    (cd).loadlist = 3 + ((cd).action - 14) * 6;
                                    (cd).action = 11;
                                    cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class B Cars", 337, 195, i, i_91_, bool) && cntflock == 0) {
                                    if (lfrom > 2)
                                        lfrom -= 2;
                                    (cd).loadlist = 4 + ((cd).action - 14) * 6;
                                    (cd).action = 11;
                                    cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class B & C Cars", 337, 225, i, i_91_, bool) && cntflock == 0) {
                                    if (lfrom > 2)
                                        lfrom -= 2;
                                    (cd).loadlist = 5 + ((cd).action - 14) * 6;
                                    (cd).action = 11;
                                    cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class C Cars", 337, 255, i, i_91_, bool) && cntflock == 0) {
                                    if (lfrom > 2)
                                        lfrom -= 2;
                                    (cd).loadlist = 6 + ((cd).action - 14) * 6;
                                    (cd).action = 11;
                                    cd.sparkactionloader();
                                }
                            }
                            if ((cd).action == 0) {
                                drawcs(91, "Top 20 Most Added Public Cars", 0, 0, 0, 3);
                                if (drawcarb(true, null, "  Weekly Top 20  ", 338, 125, i, i_91_, bool))
                                    (cd).action = 14;
                                if (drawcarb(true, null, "  Monthly Top 20  ", 337, 165, i, i_91_, bool))
                                    (cd).action = 15;
                                if (drawcarb(true, null, "  All Time Top 20  ", 335, 205, i, i_91_, bool))
                                    (cd).action = 16;
                                if (cntflock != 20)
                                    cntflock = 20;
                            }
                        }
                    }
                    if (cfase == 0 && testdrive != 1 && testdrive != 2 && gmode == 0) {
                        int i_106_ = 95;
                        if (multion != 0)
                            i_106_ = 185;
                        if (multion == 0 && drawcarb(false, cmc, "", 95, 65, i, i_91_, bool)) {
                            if ((cd).lastload != 1)
                                cfase = 1;
                            else {
                                minsl = 16;
                                maxsl = (cd).nlcars - 1;
                                i_99_ = 16;
                                cfase = 3;
                            }
                        }
                        if (drawcarb(false, myc, "", i_106_, 105, i, i_91_, bool)) {
                            if ((cd).lastload != 2) {
                                cfase = 5;
                                if (!logged) {
                                    (cd).action = 0;
                                    (cd).reco = -2;
                                    tcnt = 5;
                                    cntflock = 0;
                                } else {
                                    (cd).action = 3;
                                    cd.sparkactionloader();
                                }
                            } else {
                                minsl = 16;
                                maxsl = (cd).nlocars - 1;
                                if (onmsc >= minsl && onmsc <= maxsl)
                                    i_99_ = onmsc;
                                else
                                    i_99_ = 16;
                                cfase = 3;
                            }
                        }
                        if ((multion == 0 || onjoin == -1) && drawcarb(true, null, " Top 20 Lists ", i_106_, (i_106_ - 95) / 7 + 25, i, i_91_, bool)) {
                            lfrom = 1;
                            (cd).action = 0;
                            cfase = 10;
                        }
                        if (remi)
                            remi = false;
                    }
                    if (cfase == -1) {
                        if ((cd).lastload != 2) {
                            cfase = 5;
                            if (!logged) {
                                (cd).action = 0;
                                (cd).reco = -2;
                                tcnt = 5;
                                cntflock = 0;
                            } else {
                                (cd).action = 3;
                                cd.sparkactionloader();
                            }
                        } else {
                            minsl = 16;
                            maxsl = (cd).nlocars - 1;
                            if (onmsc >= minsl && onmsc <= maxsl)
                                i_99_ = onmsc;
                            else
                                i_99_ = 16;
                            cfase = 3;
                        }
                    }
                    if (cfase == 9) {
                        drawprom(145, 95);
                        drawcs(175, "Failed to remove car.  Unkown Error.  Try again laster.", 0, 0, 0, 3);
                        if (drawcarb(true, null, "   OK   ", 371, 195, i, i_91_, bool)) {
                            minsl = 16;
                            maxsl = (cd).nlocars - 1;
                            if (onmsc >= minsl && onmsc <= maxsl)
                                i_99_ = onmsc;
                            else
                                i_99_ = 16;
                            cfase = 3;
                        }
                    }
                    if (cfase == 7) {
                        if ((app).mycar.isShowing())
                            (app).mycar.hide();
                        drawprom(145, 95);
                        drawcs(175, "Remove this car from your account?", 0, 0, 0, 3);
                        if (drawcarb(true, null, " Yes ", 354, 195, i, i_91_, bool)) {
                            remi = true;
                            minsl = 0;
                            maxsl = 15;
                            i_99_ = 15;
                            cfase = 8;
                            onmsc = sc[0];
                            (cd).ac = sc[0];
                            (cd).action = 10;
                            cd.sparkactionloader();
                        }
                        if (drawcarb(true, null, " No ", 408, 195, i, i_91_, bool))
                            cfase = 3;
                    }
                    if (cfase == 3 && i_99_ == -1) {
                        int i_107_ = 95;
                        if (multion != 0)
                            i_107_ = 185;
                        if (drawcarb(false, gac, "", i_107_, 105, i, i_91_, bool)) {
                            minsl = 0;
                            maxsl = 15;
                            i_99_ = 15;
                            cfase = 0;
                        }
                        if (multion == 0) {
                            if (!(app).mycar.isShowing()) {
                                (app).mycar.show();
                                (app).mycar.setState((cd).include[sc[0] - 16]);
                            }
                            rd.setColor(new Color(198, 179, 129));
                            rd.fillRoundRect(305, 302, 190, 24, 7, 20);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRoundRect(305, 302, 190, 24, 7, 20);
                            app.movefield((app).mycar, 334, 306, 150, 17);
                            if ((app).mycar.getState() != (cd).include[sc[0] - 16]) {
                                (cd).include[sc[0] - 16] = (app).mycar.getState();
                                app.requestFocus();
                            }
                        }
                        if ((multion == 0 || onjoin == -1) && drawcarb(true, null, " Top 20 Lists ", i_107_, (i_107_ - 95) / 7 + 25, i, i_91_, bool)) {
                            lfrom = 2;
                            (cd).action = 0;
                            cfase = 10;
                            if ((app).mycar.isShowing())
                                (app).mycar.hide();
                        }
                        if ((cd).lastload == 2) {
                            if (drawcarb(true, null, "X", 567, 135, i, i_91_, bool))
                                cfase = 7;
                            rd.setFont(new Font("Arial", 1, 11));
                            rd.setColor(new Color(0, 0, 0));
                            if (!(cd).createdby[sc[0] - 16].equals(nickname))
                                rd.drawString(new StringBuilder().append("Created by :  ").append((cd).createdby[sc[0] - 16]).append("").toString(), 241, 165);
                            else
                                rd.drawString("Created by You", 241, 165);
                        }
                        if (remi)
                            remi = false;
                        if (noclass) {
                            drawprom(200, 95);
                            rd.setFont(new Font("Arial", 1, 13));
                            ftm = rd.getFontMetrics();
                            String string = "Class C";
                            if (ontyp == 2)
                                string = "Class B or C";
                            if (ontyp == 3)
                                string = "Class B";
                            if (ontyp == 4)
                                string = "Class A or B";
                            if (ontyp == 5)
                                string = "Class A";
                            drawcs(230, new StringBuilder().append("You do not have a ").append(string).append(" car in your account cars.").toString(), 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 250, i, i_91_, bool))
                                noclass = false;
                        }
                    }
                    if (cfase == 11 && i_99_ == -1) {
                        if ((cd).action == -9) {
                            drawprom(145, 95);
                            drawcs(175, "Unknown error!  Failed to add car.  Try again later.", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, i, i_91_, bool))
                                (cd).action = 0;
                        }
                        if ((cd).action == -8) {
                            drawprom(145, 95);
                            drawcs(175, "Failed.  You already have 20 cars in your account!", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, i, i_91_, bool))
                                (cd).action = 0;
                        }
                        if ((cd).action == -7) {
                            drawprom(145, 95);
                            drawcs(175, "You already have this car!", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, i, i_91_, bool))
                                (cd).action = 0;
                        }
                        if ((cd).action == 7) {
                            drawprom(145, 95);
                            drawcs(175, new StringBuilder().append("").append((cd).names[(cd).ac]).append(" has been successfully added to your cars!").toString(), 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, i, i_91_, bool))
                                (cd).action = 0;
                        }
                        if ((cd).action == 6) {
                            drawprom(145, 95);
                            drawcs(195, new StringBuilder().append("Adding ").append((cd).names[(cd).ac]).append(" to your cars...").toString(), 0, 0, 0, 3);
                        }
                        int i_108_ = 95;
                        if (multion != 0)
                            i_108_ = 185;
                        if (lfrom == 2 && multion != 0) {
                            if (drawcarb(false, myc, "", i_108_, 105, i, i_91_, bool)) {
                                if ((cd).lastload != 2) {
                                    cfase = 5;
                                    if (!logged) {
                                        (cd).action = 0;
                                        (cd).reco = -2;
                                        tcnt = 5;
                                        cntflock = 0;
                                    } else {
                                        (cd).action = 3;
                                        cd.sparkactionloader();
                                    }
                                } else {
                                    (cd).action = 0;
                                    minsl = 16;
                                    maxsl = (cd).nlocars - 1;
                                    if (onmsc >= minsl && onmsc <= maxsl)
                                        i_99_ = onmsc;
                                    else
                                        i_99_ = 16;
                                    cfase = 3;
                                }
                                (app).moused = false;
                                lfrom = 0;
                            }
                        } else if (drawcarb(false, gac, "", i_108_, 105, i, i_91_, bool)) {
                            (cd).action = 0;
                            minsl = 0;
                            maxsl = 15;
                            i_99_ = 15;
                            cfase = 0;
                            (app).moused = false;
                            lfrom = 0;
                        }
                        if (drawcarb(true, null, " Top 20 Lists ", i_108_, (i_108_ - 95) / 7 + 25, i, i_91_, bool)) {
                            lfrom += 2;
                            (cd).action = 0;
                            cfase = 10;
                        }
                        if ((cd).action == 0) {
                            rd.setFont(new Font("Arial", 1, 11));
                            rd.setColor(new Color(0, 0, 0));
                            if (!(cd).createdby[sc[0] - 16].equals(nickname))
                                rd.drawString(new StringBuilder().append("Created by :  ").append((cd).createdby[sc[0] - 16]).append("").toString(), 241, 165);
                            else
                                rd.drawString("Created by You", 241, 165);
                            rd.drawString(new StringBuilder().append("Added by :  ").append((cd).adds[sc[0] - 16]).append(" Players").toString(), 241, 182);
                        }
                    }
                    if (cfase == 5) {
                        drawprom(145, 170);
                        if ((cd).action == 5) {
                            minsl = 16;
                            maxsl = (cd).nlocars - 1;
                            if (onmsc >= minsl && onmsc <= maxsl)
                                i_99_ = onmsc;
                            else
                                i_99_ = 16;
                            cfase = 3;
                        }
                        if ((cd).action == 4) {
                            drawcs(195, "[  Loading Cars  ]", 0, 0, 0, 3);
                            if ((cd).nl > 0 && (cd).nl <= 20)
                                drawcs(235, new StringBuilder().append("Loading :  ").append((cd).loadnames[(cd).nl - 1]).append("").toString(), 0, 0, 0, 3);
                        }
                        if ((cd).action == -2) {
                            drawcs(195, "Unknown Connection Error", 0, 0, 0, 3);
                            drawcs(225, "Failed to connect to server, try again later!", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, i, i_91_, bool))
                                cfase = 0;
                        }
                        if ((cd).action == -1) {
                            drawcs(195, "No published cars found...", 0, 0, 0, 3);
                            drawcs(225, "You have no added cars to your account yet!", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, i, i_91_, bool))
                                cfase = 0;
                        }
                        if ((cd).action == 2 || (cd).action == 3) {
                            drawcs(195, "Loading your Account Cars list...", 0, 0, 0, 3);
                            if ((cd).action == 2) {
                                nickname = (app).tnick.getText();
                                nickey = (cd).tnickey;
                                app.setloggedcookie();
                                logged = true;
                                if ((cd).reco == 0)
                                    acexp = 0;
                                if ((cd).reco > 10)
                                    acexp = (cd).reco - 10;
                                if ((cd).reco == 3)
                                    acexp = -1;
                                if (lfrom == 0)
                                    (cd).action = 3;
                                else {
                                    (cd).action = 6;
                                    cfase = 11;
                                }
                            }
                        }
                        if ((cd).action == 1)
                            drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                        if ((cd).action == 0) {
                            if ((cd).reco == -5)
                                drawcs(171, "Login to Add this Car to your Account", 0, 0, 0, 3);
                            if ((cd).reco == -2)
                                drawcs(171, "Login to Retrieve your Account Cars", 0, 0, 0, 3);
                            if ((cd).reco == -1)
                                drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                            if ((cd).reco == 1)
                                drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                            if ((cd).reco == 2)
                                drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                            if ((cd).reco == -167 || (cd).reco == -177) {
                                if ((cd).reco == -167) {
                                    nickname = (app).tnick.getText();
                                    (cd).reco = -177;
                                }
                                drawcs(171, "You need to have a full account to access your cars!", 0, 0, 0, 3);
                            }
                            if ((cd).reco == -3 && (tcnt % 3 != 0 || tcnt > 20))
                                drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                            if ((cd).reco == -4 && (tcnt % 3 != 0 || tcnt > 20))
                                drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                            if (!(app).tnick.isShowing()) {
                                (app).tnick.show();
                                (app).tnick.setBackground(new Color(206, 237, 255));
                                if ((cd).reco != 1) {
                                    if ((cd).reco != 2)
                                        (app).tnick.setText(nickname);
                                    (app).tnick.setForeground(new Color(0, 0, 0));
                                } else
                                    (app).tnick.setForeground(new Color(255, 0, 0));
                                (app).tnick.requestFocus();
                            }
                            rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 201);
                            app.movefield((app).tnick, 376, 185, 129, 23);
                            if (!(app).tpass.isShowing()) {
                                (app).tpass.show();
                                (app).tpass.setBackground(new Color(206, 237, 255));
                                if ((cd).reco != 2) {
                                    if (!autolog)
                                        (app).tpass.setText("");
                                    (app).tpass.setForeground(new Color(0, 0, 0));
                                } else
                                    (app).tpass.setForeground(new Color(255, 0, 0));
                                if (!(app).tnick.getText().equals("") && (cd).reco != 1)
                                    (app).tpass.requestFocus();
                            }
                            rd.drawString("Password:", 376 - ftm.stringWidth("Password:") - 14, 231);
                            app.movefield((app).tpass, 376, 215, 129, 23);
                            if (tcnt < 30) {
                                tcnt++;
                                if (tcnt == 30) {
                                    if ((cd).reco == 2)
                                        (app).tpass.setText("");
                                    (app).tnick.setForeground(new Color(0, 0, 0));
                                    (app).tpass.setForeground(new Color(0, 0, 0));
                                }
                            }
                            if ((cd).reco != -177) {
                                if (drawcarb(true, null, "       Login       ", 347, 247, i, i_91_, bool) && tcnt > 5) {
                                    tcnt = 0;
                                    if (!(app).tnick.getText().equals("") && !(app).tpass.getText().equals("")) {
                                        autolog = false;
                                        (app).tnick.hide();
                                        (app).tpass.hide();
                                        app.requestFocus();
                                        (cd).action = 1;
                                        cd.sparkactionloader();
                                    } else {
                                        if ((app).tpass.getText().equals(""))
                                            (cd).reco = -4;
                                        if ((app).tnick.getText().equals(""))
                                            (cd).reco = -3;
                                    }
                                }
                            } else if (drawcarb(true, null, "  Upgrade your account to have full access  ", 254, 247, i, i_91_, bool) && cntflock == 0) {
                                app.editlink(nickname);
                                cntflock = 100;
                            }
                            if (drawcarb(true, null, "  Cancel  ", 409, 282, i, i_91_, bool)) {
                                (app).tnick.hide();
                                (app).tpass.hide();
                                app.requestFocus();
                                if (lfrom == 0)
                                    cfase = 0;
                                else
                                    cfase = 11;
                            }
                            if (drawcarb(true, null, "  Register!  ", 316, 282, i, i_91_, bool)) {
                                if (cntflock == 0) {
                                    app.reglink();
                                    cntflock = 100;
                                }
                            } else if (cntflock != 0)
                                cntflock--;
                        }
                    }
                    if (cfase == 4) {
                        drawprom(145, 150);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("Failed to find any ready car in your \u2018mycars\u2019 folder!", 215, 175);
                        rd.drawString("Please \u2018Test Drive\u2019 your cars in the Car Maker to make", 215, 215);
                        rd.drawString("sure they are ready.", 215, 235);
                        if (drawcarb(true, null, "   OK   ", 371, 255, i, i_91_, bool))
                            cfase = 0;
                    }
                    if (cfase == 2) {
                        drawprom(165, 70);
                        drawcs(205, "Loading Car Maker Cars...", 0, 0, 0, 3);
                        app.repaint();
                        cd.loadcarmaker();
                        if ((cd).nlcars > 16) {
                            minsl = 16;
                            maxsl = (cd).nlcars - 1;
                            i_99_ = 16;
                            cfase = 3;
                        } else
                            cfase = 4;
                    }
                    if (cfase == 1) {
                        drawprom(145, 170);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("The game will now load all the cars that can be loaded", 215, 170);
                        rd.drawString("from your \u2018mycars\u2019 folder.", 215, 190);
                        rd.drawString("If a car is not loaded, then it is not ready (not finished).", 215, 210);
                        rd.drawString("Perform a \u2018Test Drive\u2019 on any car to see if it is ready or not.", 215, 230);
                        rd.drawString("The maximum number of cars that can be loaded is  40 !", 215, 260);
                        if (drawcarb(true, null, "   OK   ", 371, 275, i, i_91_, bool))
                            cfase = 2;
                    }
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(181, 120, 40));
                    rd.drawString("Top Speed:", 98, 343);
                    rd.drawImage(statb, 162, 337, null);
                    rd.drawString("Acceleration:", 88, 358);
                    rd.drawImage(statb, 162, 352, null);
                    rd.drawString("Handling:", 110, 373);
                    rd.drawImage(statb, 162, 367, null);
                    rd.drawString("Stunts:", 495, 343);
                    rd.drawImage(statb, 536, 337, null);
                    rd.drawString("Strength:", 483, 358);
                    rd.drawImage(statb, 536, 352, null);
                    rd.drawString("Endurance:", 473, 373);
                    rd.drawImage(statb, 536, 367, null);
                    rd.setColor(new Color(0, 0, 0));
                    float f = (float) ((cd).swits[sc[0]][2] - 220) / 90.0F;
                    if ((double) f < 0.2)
                        f = 0.2F;
                    rd.fillRect((int) (162.0F + 156.0F * f), 337, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    f = (cd).acelf[sc[0]][1] * (cd).acelf[sc[0]][0] * (cd).acelf[sc[0]][2] * (cd).grip[sc[0]] / 7700.0F;
                    if (f > 1.0F)
                        f = 1.0F;
                    rd.fillRect((int) (162.0F + 156.0F * f), 352, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    f = (cd).dishandle[sc[0]];
                    rd.fillRect((int) (162.0F + 156.0F * f), 367, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    f = ((float) (cd).airc[sc[0]] * (cd).airs[sc[0]] * (cd).bounce[sc[0]] + 28.0F) / 139.0F;
                    if (f > 1.0F)
                        f = 1.0F;
                    rd.fillRect((int) (536.0F + 156.0F * f), 337, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    float f_109_ = 0.5F;
                    f = ((cd).moment[sc[0]] + f_109_) / 2.6F;
                    if (f > 1.0F)
                        f = 1.0F;
                    rd.fillRect((int) (536.0F + 156.0F * f), 352, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    f = (cd).outdam[sc[0]];
                    rd.fillRect((int) (536.0F + 156.0F * f), 367, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    rd.drawImage(statbo, 162, 337, null);
                    rd.drawImage(statbo, 162, 352, null);
                    rd.drawImage(statbo, 162, 367, null);
                    rd.drawImage(statbo, 536, 337, null);
                    rd.drawImage(statbo, 536, 352, null);
                    rd.drawImage(statbo, 536, 367, null);
                    if (multion != 0 || testdrive == 1 || testdrive == 2) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        String string = "Class C";
                        if ((cd).cclass[sc[0]] == 1)
                            string = "Class B & C";
                        if ((cd).cclass[sc[0]] == 2)
                            string = "Class B";
                        if ((cd).cclass[sc[0]] == 3)
                            string = "Class A & B";
                        if ((cd).cclass[sc[0]] == 4)
                            string = "Class A";
                        if (kbload < 7) {
                            rd.setColor(new Color(0, 0, 0));
                            kbload++;
                        } else {
                            rd.setColor(new Color(176, 41, 0));
                            kbload = 0;
                        }
                        if (cfase != 10 || (cd).action != 0 && (cd).action < 14)
                            rd.drawString(string, 549 - ftm.stringWidth(string) / 2, 95);
                        rd.setFont(new Font("Arial", 1, 12));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("1st Color", 100, 55);
                        rd.drawString("2nd Color", 649, 55);
                        rd.setFont(new Font("Arial", 1, 10));
                        ftm = rd.getFontMetrics();
                        rd.drawString("Hue  | ", 97, 70);
                        rd.drawImage(brt, 137, 63, null);
                        rd.drawString("Hue  | ", 647, 70);
                        rd.drawImage(brt, 687, 63, null);
                        rd.drawString("Intensity", 121, 219);
                        rd.drawString("Intensity", 671, 219);
                        rd.drawString("Reset", 110, 257);
                        rd.drawString("Reset", 660, 257);
                        for (int i_110_ = 0; i_110_ < 161; i_110_++) {
                            rd.setColor(Color.getHSBColor((float) ((double) (float) i_110_ * 0.00625), 1.0F, 1.0F));
                            rd.drawLine(102, 75 + i_110_, 110, 75 + i_110_);
                            if (i_110_ <= 128) {
                                rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0 - (double) (float) i_110_ * 0.00625)));
                                rd.drawLine(137, 75 + i_110_, 145, 75 + i_110_);
                            }
                            rd.setColor(Color.getHSBColor((float) ((double) (float) i_110_ * 0.00625), 1.0F, 1.0F));
                            rd.drawLine(652, 75 + i_110_, 660, 75 + i_110_);
                            if (i_110_ <= 128) {
                                rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0 - (double) (float) i_110_ * 0.00625)));
                                rd.drawLine(687, 75 + i_110_, 695, 75 + i_110_);
                            }
                        }
                        for (int i_111_ = 0; i_111_ < 40; i_111_++) {
                            rd.setColor(Color.getHSBColor(arnp[0], (float) ((double) (float) i_111_ * 0.025), 1.0F - arnp[2]));
                            rd.drawLine(121 + i_111_, 224, 121 + i_111_, 230);
                            rd.setColor(Color.getHSBColor(arnp[3], (float) ((double) (float) i_111_ * 0.025), 1.0F - arnp[5]));
                            rd.drawLine(671 + i_111_, 224, 671 + i_111_, 230);
                        }
                        rd.drawImage(arn, 110, 71 + (int) (arnp[0] * 160.0F), null);
                        rd.drawImage(arn, 145, 71 + (int) (arnp[2] * 160.0F), null);
                        rd.drawImage(arn, 660, 71 + (int) (arnp[3] * 160.0F), null);
                        rd.drawImage(arn, 695, 71 + (int) (arnp[5] * 160.0F), null);
                        rd.setColor(new Color(0, 0, 0));
                        rd.fillRect(120 + (int) (arnp[1] * 40.0F), 222, 3, 3);
                        rd.drawLine(121 + (int) (arnp[1] * 40.0F), 224, 121 + (int) (arnp[1] * 40.0F), 230);
                        rd.fillRect(120 + (int) (arnp[1] * 40.0F), 230, 3, 3);
                        rd.fillRect(670 + (int) (arnp[4] * 40.0F), 222, 3, 3);
                        rd.drawLine(671 + (int) (arnp[4] * 40.0F), 224, 671 + (int) (arnp[4] * 40.0F), 230);
                        rd.fillRect(670 + (int) (arnp[4] * 40.0F), 230, 3, 3);
                        if (bool) {
                            if (mouson == -1) {
                                if (i > 96 && i < 152 && i_91_ > 248 && i_91_ < 258) {
                                    float[] fs = new float[3];
                                    Color.RGBtoHSB((contos[sc[0]]).fcol[0], (contos[sc[0]]).fcol[1], (contos[sc[0]]).fcol[2], fs);
                                    arnp[0] = fs[0];
                                    arnp[1] = fs[1];
                                    arnp[2] = 1.0F - fs[2];
                                }
                                if (i > 646 && i < 702 && i_91_ > 248 && i_91_ < 258) {
                                    float[] fs = new float[3];
                                    Color.RGBtoHSB((contos[sc[0]]).scol[0], (contos[sc[0]]).scol[1], (contos[sc[0]]).scol[2], fs);
                                    arnp[3] = fs[0];
                                    arnp[4] = fs[1];
                                    arnp[5] = 1.0F - fs[2];
                                }
                                mouson = -2;
                                if (i > 119 && i < 163 && i_91_ > 222 && i_91_ < 232)
                                    mouson = 1;
                                if (i > 669 && i < 713 && i_91_ > 222 && i_91_ < 232)
                                    mouson = 4;
                                if (i > 98 && i < 122 && i_91_ > 69 && i_91_ < 241 && mouson == -2)
                                    mouson = 0;
                                if (i > 133 && i < 157 && i_91_ > 69 && i_91_ < 209 && mouson == -2)
                                    mouson = 2;
                                if (i > 648 && i < 672 && i_91_ > 69 && i_91_ < 241 && mouson == -2)
                                    mouson = 3;
                                if (i > 683 && i < 707 && i_91_ > 69 && i_91_ < 209 && mouson == -2)
                                    mouson = 5;
                            }
                        } else if (mouson != -1)
                            mouson = -1;
                        if (mouson == 0 || mouson == 2 || mouson == 3 || mouson == 5) {
                            arnp[mouson] = (float) ((double) ((float) i_91_ - 75.0F) * 0.00625);
                            if (mouson == 2 || mouson == 5) {
                                if ((double) arnp[mouson] > 0.8)
                                    arnp[mouson] = 0.8F;
                            } else if (arnp[mouson] > 1.0F)
                                arnp[mouson] = 1.0F;
                            if (arnp[mouson] < 0.0F)
                                arnp[mouson] = 0.0F;
                        }
                        if (mouson == 1) {
                            arnp[mouson] = (float) ((double) ((float) i - 121.0F) * 0.025);
                            if (arnp[mouson] > 1.0F)
                                arnp[mouson] = 1.0F;
                            if (arnp[mouson] < 0.0F)
                                arnp[mouson] = 0.0F;
                        }
                        if (mouson == 4) {
                            arnp[mouson] = (float) ((double) ((float) i - 671.0F) * 0.025);
                            if (arnp[mouson] > 1.0F)
                                arnp[mouson] = 1.0F;
                            if (arnp[mouson] < 0.0F)
                                arnp[mouson] = 0.0F;
                        }
                        if (cfase != 10 && cfase != 5 && i_99_ == -1) {
                            Color color = Color.getHSBColor(arnp[0], arnp[1], 1.0F - arnp[2]);
                            Color color_112_ = Color.getHSBColor(arnp[3], arnp[4], 1.0F - arnp[5]);
                            for (int i_113_ = 0; i_113_ < (contos[sc[0]]).npl; i_113_++) {
                                if (((contos[sc[0]]).p[i_113_]).colnum == 1) {
                                    ((contos[sc[0]]).p[i_113_]).hsb[0] = arnp[0];
                                    ((contos[sc[0]]).p[i_113_]).hsb[1] = arnp[1];
                                    ((contos[sc[0]]).p[i_113_]).hsb[2] = 1.0F - arnp[2];
                                    ((contos[sc[0]]).p[i_113_]).c[0] = color.getRed();
                                    ((contos[sc[0]]).p[i_113_]).c[1] = color.getGreen();
                                    ((contos[sc[0]]).p[i_113_]).c[2] = color.getBlue();
                                    ((contos[sc[0]]).p[i_113_]).oc[0] = color.getRed();
                                    ((contos[sc[0]]).p[i_113_]).oc[1] = color.getGreen();
                                    ((contos[sc[0]]).p[i_113_]).oc[2] = color.getBlue();
                                }
                                if (((contos[sc[0]]).p[i_113_]).colnum == 2) {
                                    ((contos[sc[0]]).p[i_113_]).hsb[0] = arnp[3];
                                    ((contos[sc[0]]).p[i_113_]).hsb[1] = arnp[4];
                                    ((contos[sc[0]]).p[i_113_]).hsb[2] = 1.0F - arnp[5];
                                    ((contos[sc[0]]).p[i_113_]).c[0] = color_112_.getRed();
                                    ((contos[sc[0]]).p[i_113_]).c[1] = color_112_.getGreen();
                                    ((contos[sc[0]]).p[i_113_]).c[2] = color_112_.getBlue();
                                    ((contos[sc[0]]).p[i_113_]).oc[0] = color_112_.getRed();
                                    ((contos[sc[0]]).p[i_113_]).oc[1] = color_112_.getGreen();
                                    ((contos[sc[0]]).p[i_113_]).oc[2] = color_112_.getBlue();
                                }
                            }
                        }
                    }
                }
                if (!remi && cfase != 10 && cfase != 11)
                    rd.drawImage(contin[pcontin], 355, 385, null);
                else if (cfase == 11 && drawcarb(true, null, "Add to My Cars", 345, 385, i, i_91_, bool) && (cd).action == 0) {
                    (cd).ac = sc[0];
                    if (logged) {
                        (cd).action = 6;
                        cd.sparkactionloader();
                    } else {
                        (cd).reco = -5;
                        cfase = 5;
                    }
                }
            }
        } else {
            if (cfase == 11)
                (cd).action = 0;
            if ((app).mycar.isShowing())
                (app).mycar.hide();
            pback = 0;
            pnext = 0;
            gatey = 300;
            if (flipo > 10) {
                (contos[sc[0]]).y -= 100;
                if (nextc == 1)
                    (contos[sc[0]]).zy += 20;
                if (nextc == -1)
                    (contos[sc[0]]).zy -= 20;
            } else {
                if (flipo == 10) {
                    if (nextc >= 15) {
                        sc[0] = nextc;
                        lsc = -1;
                    }
                    if (nextc == 1) {
                        sc[0]++;
                        if (gmode == 1) {
                            if (sc[0] == 7)
                                sc[0] = 11;
                            if (sc[0] == 12)
                                sc[0] = 14;
                        }
                        if (multion != 0 && onjoin != -1 && ontyp > 0 && ontyp <= 5) {
                            for (/**/; sc[0] < maxsl && Math.abs((cd).cclass[sc[0]] - (ontyp - 1)) > 1; sc[0]++) {
                                /* empty */
                            }
                        }
                    }
                    if (nextc == -1) {
                        sc[0]--;
                        if (gmode == 1) {
                            if (sc[0] == 13)
                                sc[0] = 11;
                            if (sc[0] == 10)
                                sc[0] = 6;
                        }
                        if (multion != 0 && onjoin != -1 && ontyp > 0 && ontyp <= 5) {
                            for (/**/; sc[0] > minsl && Math.abs((cd).cclass[sc[0]] - (ontyp - 1)) > 1; sc[0]--) {
                                /* empty */
                            }
                        }
                    }
                    (contos[sc[0]]).z = 950;
                    (contos[sc[0]]).y = -34 - (contos[sc[0]]).grat - 1100;
                    (contos[sc[0]]).x = 0;
                    (contos[sc[0]]).zy = 0;
                }
                (contos[sc[0]]).y += 100;
            }
            flipo--;
        }
        rd.drawImage(byrd2, 72, 408, null);
        rd.drawImage(nfmcoms2, 532, 408, null);
        if (cfase == 0 || cfase == 3 || cfase == 11) {
            if (i_99_ != -1) {
                if (flatrstart > 1)
                    flatrstart = 0;
                nextc = i_99_;
                flipo = 20;
            }
            if ((control).right) {
                (control).right = false;
                if (sc[0] != maxsl && flipo == 0) {
                    if (flatrstart > 1)
                        flatrstart = 0;
                    nextc = 1;
                    flipo = 20;
                }
            }
            if ((control).left) {
                (control).left = false;
                if (sc[0] != minsl && flipo == 0) {
                    if (flatrstart > 1)
                        flatrstart = 0;
                    nextc = -1;
                    flipo = 20;
                }
            }
            if (cfase != 11 && i_100_ == 0) {
                if ((control).handb || (control).enter) {
                    (m).crs = false;
                    if (multion != 0) {
                        fase = 1177;
                        intertrack.stop();
                    } else if (testdrive != 3 && testdrive != 4)
                        fase = 3;
                    else
                        fase = -22;
                    if (sc[0] < 16 || (cd).lastload == 2)
                        app.setcarcookie(sc[0], arnp, gmode, unlocked, mtop);
                    if (gmode == 0)
                        osc = sc[0];
                    if (gmode == 1)
                        scm[0] = sc[0];
                    if (gmode == 2)
                        scm[1] = sc[0];
                    if ((app).mycar.isShowing())
                        (app).mycar.hide();
                    flexpix = null;
                    (control).handb = false;
                    (control).enter = false;
                }
            } else if ((control).handb || (control).enter) {
                (control).handb = false;
                (control).enter = false;
            }
        } else {
            pback = 0;
            pnext = 0;
            pcontin = 0;
            if (cfase == 8 && i_99_ != -1) {
                if (flatrstart > 1)
                    flatrstart = 0;
                nextc = i_99_;
                flipo = 20;
            }
            if (cfase == 5 && (cd).action == 0 && (control).enter) {
                tcnt = 0;
                if (!(app).tnick.getText().equals("") && !(app).tpass.getText().equals("")) {
                    (app).tnick.hide();
                    (app).tpass.hide();
                    app.requestFocus();
                    (cd).action = 1;
                    cd.sparkactionloader();
                } else {
                    if ((app).tpass.getText().equals(""))
                        (cd).reco = -4;
                    if ((app).tnick.getText().equals(""))
                        (cd).reco = -3;
                }
                (control).enter = false;
            }
        }
    }
    
    public void colorCar(ContO conto, int i) {
        if (plnames[i].indexOf("MadBot") == -1) {
            for (int i_114_ = 0; i_114_ < (conto).npl; i_114_++) {
                if (((conto).p[i_114_]).colnum == 1) {
                    Color color = Color.getHSBColor(allrnp[i][0], allrnp[i][1], 1.0F - allrnp[i][2]);
                    ((conto).p[i_114_]).oc[0] = color.getRed();
                    ((conto).p[i_114_]).oc[1] = color.getGreen();
                    ((conto).p[i_114_]).oc[2] = color.getBlue();
                }
                if (((conto).p[i_114_]).colnum == 2) {
                    Color color = Color.getHSBColor(allrnp[i][3], allrnp[i][4], 1.0F - allrnp[i][5]);
                    ((conto).p[i_114_]).oc[0] = color.getRed();
                    ((conto).p[i_114_]).oc[1] = color.getGreen();
                    ((conto).p[i_114_]).oc[2] = color.getBlue();
                }
            }
        } else {
            for (int i_115_ = 0; i_115_ < (conto).npl; i_115_++) {
                if (((conto).p[i_115_]).colnum == 1) {
                    ((conto).p[i_115_]).oc[0] = (conto).fcol[0];
                    ((conto).p[i_115_]).oc[1] = (conto).fcol[1];
                    ((conto).p[i_115_]).oc[2] = (conto).fcol[2];
                }
                if (((conto).p[i_115_]).colnum == 2) {
                    ((conto).p[i_115_]).oc[0] = (conto).scol[0];
                    ((conto).p[i_115_]).oc[1] = (conto).scol[1];
                    ((conto).p[i_115_]).oc[2] = (conto).scol[2];
                }
            }
        }
    }
    
    public void drawprom(int i, int i_116_) {
        rd.setComposite(AlphaComposite.getInstance(3, 0.76F));
        rd.setColor(new Color(129, 203, 237));
        rd.fillRoundRect(205, i, 390, i_116_, 30, 30);
        rd.setColor(new Color(0, 0, 0));
        rd.drawRoundRect(205, i, 390, i_116_, 30, 30);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }
    
    public void drawdprom(int i, int i_117_) {
        rd.setComposite(AlphaComposite.getInstance(3, 0.9F));
        rd.setColor(new Color(129, 203, 237));
        rd.fillRoundRect(205, i, 390, i_117_, 30, 30);
        rd.setColor(new Color(0, 0, 0));
        rd.drawRoundRect(205, i, 390, i_117_, 30, 30);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }
    
    public void drawlprom(int i, int i_118_) {
        rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
        rd.setColor(new Color(129, 203, 237));
        rd.fillRoundRect(277, i, 390, i_118_, 30, 30);
        rd.setColor(new Color(0, 0, 0));
        rd.drawRoundRect(277, i, 390, i_118_, 30, 30);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }
    
    public void finish(CheckPoints checkpoints, ContO[] contos, Control control, int i, int i_119_, boolean bool) {
        if (!badmac)
            rd.drawImage(fleximg, 0, 0, null);
        else {
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(0, 0, 800, 450);
        }
        rd.setFont(new Font("Arial", 1, 11));
        ftm = rd.getFontMetrics();
        int i_120_ = 0;
        String string = ":";
        if ((checkpoints).stage > 0) {
            int i_121_ = (checkpoints).stage;
            if (i_121_ > 10)
                i_121_ -= 10;
            string = new StringBuilder().append(" ").append(i_121_).append("!").toString();
        }
        if (multion < 3) {
            if (winner) {
                rd.drawImage(congrd, 265, 87, null);
                drawcs(137, new StringBuilder().append("You Won!  At Stage").append(string).append("").toString(), 255, 161, 85, 3);
                drawcs(154, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
                i_120_ = 154;
            } else {
                rd.drawImage(gameov, 315, 117, null);
                if (multion != 0 && (forstart == 700 || discon == 240)) {
                    drawcs(167, "Sorry, You where Disconnected from Game!", 255, 161, 85, 3);
                    drawcs(184, "Please check your connection!", 255, 115, 0, 3);
                } else {
                    drawcs(167, new StringBuilder().append("You Lost!  At Stage").append(string).append("").toString(), 255, 161, 85, 3);
                    drawcs(184, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
                    i_120_ = 184;
                }
            }
        } else {
            rd.drawImage(gameov, 315, 117, null);
            drawcs(167, new StringBuilder().append("Finished Watching Game!  At Stage").append(string).append("").toString(), 255, 161, 85, 3);
            drawcs(184, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
            i_120_ = 184;
        }
        if (winner && multion == 0 && gmode != 0 && ((checkpoints).stage == unlocked[gmode - 1] + (gmode - 1) * 10 || (checkpoints).stage == 27)) {
            int i_122_ = 0;
            int i_123_ = 0;
            pin = 60;
            if (gmode == 1) {
                if ((checkpoints).stage == 2) {
                    i_122_ = 5;
                    i_123_ = 365;
                    pin = -20;
                    scm[0] = 5;
                }
                if ((checkpoints).stage == 4) {
                    i_122_ = 6;
                    i_123_ = 320;
                    pin = -20;
                    scm[0] = 6;
                }
                if ((checkpoints).stage == 6) {
                    i_122_ = 11;
                    i_123_ = 326;
                    pin = -20;
                    scm[0] = 11;
                }
                if ((checkpoints).stage == 8) {
                    i_122_ = 14;
                    i_123_ = 350;
                    pin = -20;
                    scm[0] = 14;
                }
                if ((checkpoints).stage == 10) {
                    i_122_ = 15;
                    i_123_ = 370;
                    pin = -20;
                    scm[0] = 15;
                }
            }
            if (gmode == 2) {
                if ((checkpoints).stage == 12) {
                    i_122_ = 8;
                    i_123_ = 365;
                    pin = -20;
                    scm[1] = 8;
                }
                if ((checkpoints).stage == 14) {
                    i_122_ = 9;
                    i_123_ = 320;
                    pin = -20;
                    scm[1] = 9;
                }
                if ((checkpoints).stage == 16) {
                    i_122_ = 10;
                    i_123_ = 370;
                    pin = -20;
                    scm[1] = 10;
                }
                if ((checkpoints).stage == 18) {
                    i_122_ = 11;
                    i_123_ = 326;
                    pin = -20;
                    scm[1] = 11;
                }
                if ((checkpoints).stage == 20) {
                    i_122_ = 12;
                    i_123_ = 310;
                    pin = -20;
                    scm[1] = 12;
                }
                if ((checkpoints).stage == 22) {
                    i_122_ = 13;
                    i_123_ = 310;
                    pin = -20;
                    scm[1] = 13;
                }
                if ((checkpoints).stage == 24) {
                    i_122_ = 14;
                    i_123_ = 350;
                    pin = -20;
                    scm[1] = 14;
                }
                if ((checkpoints).stage == 26) {
                    i_122_ = 15;
                    i_123_ = 370;
                    pin = -20;
                    scm[1] = 15;
                }
            }
            if ((checkpoints).stage != 27) {
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if (aflk)
                    drawcs(200 + pin, new StringBuilder().append("Stage ").append((checkpoints).stage + 1 - (gmode - 1) * 10).append(" is now unlocked!").toString(), 196, 176, 0, 3);
                else
                    drawcs(200 + pin, new StringBuilder().append("Stage ").append((checkpoints).stage + 1 - (gmode - 1) * 10).append(" is now unlocked!").toString(), 255, 247, 165, 3);
                if (i_122_ != 0) {
                    if (aflk)
                        drawcs(200, "And:", 196, 176, 0, 3);
                    else
                        drawcs(200, "And:", 255, 247, 165, 3);
                    rd.setColor(new Color(236, 226, 202));
                    if (Math.random() > 0.5) {
                        rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
                        rd.fillRect(226, 211, 344, 125);
                        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(226, 211, 348, 4);
                    rd.fillRect(226, 211, 4, 125);
                    rd.fillRect(226, 332, 348, 4);
                    rd.fillRect(570, 211, 4, 125);
                    (contos[i_122_]).y = i_123_;
                    (m).crs = true;
                    (m).x = -400;
                    (m).y = 0;
                    (m).z = -50;
                    (m).xz = 0;
                    (m).zy = 0;
                    (m).ground = 2470;
                    (contos[i_122_]).z = 1000;
                    (contos[i_122_]).x = 0;
                    (contos[i_122_]).xz += 5;
                    (contos[i_122_]).zy = 0;
                    (contos[i_122_]).wzy -= 10;
                    contos[i_122_].d(rd);
                    if (Math.random() < 0.5) {
                        rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        rd.setColor(new Color(236, 226, 202));
                        for (int i_124_ = 0; i_124_ < 30; i_124_++)
                            rd.drawLine(230, 215 + 4 * i_124_, 569, 215 + 4 * i_124_);
                        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    String string_125_ = "";
                    if (i_122_ == 13)
                        string_125_ = " ";
                    if (aflk)
                        drawcs(320, new StringBuilder().append("").append((cd).names[i_122_]).append("").append(string_125_).append(" has been unlocked!").toString(), 196, 176, 0, 3);
                    else
                        drawcs(320, new StringBuilder().append("").append((cd).names[i_122_]).append("").append(string_125_).append(" has been unlocked!").toString(), 255, 247, 165, 3);
                    pin = 140;
                }
                rd.setFont(new Font("Arial", 1, 11));
                ftm = rd.getFontMetrics();
                drawcs(220 + pin, "GAME SAVED", 230, 167, 0, 3);
                if (pin == 60)
                    pin = 30;
                else
                    pin = 0;
            } else {
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if (aflk)
                    drawcs(180, new StringBuilder().append("Woohoooo you finished NFM").append(gmode).append(" !!!").toString(), 144, 167, 255, 3);
                else
                    drawcs(180, new StringBuilder().append("Woohoooo you finished NFM").append(gmode).append(" !!!").toString(), 228, 240, 255, 3);
                if (aflk)
                    drawcs(210, "You're Awesome!", 144, 167, 255, 3);
                else
                    drawcs(212, "You're Awesome!", 228, 240, 255, 3);
                if (aflk)
                    drawcs(240, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
                else
                    drawcs(240, "You're truly a RADICAL GAMER!", 255, 100, 100, 3);
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(0, 255, 800, 62);
                rd.drawImage(radicalplay, radpx + (int) (8.0 * Math.random() - 4.0), 255, null);
                if (radpx != 212) {
                    radpx += 40;
                    if (radpx > 800)
                        radpx = -468;
                }
                if (flipo == 40)
                    radpx = 213;
                flipo++;
                if (flipo == 70)
                    flipo = 0;
                if (radpx == 212) {
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    if (aflk)
                        drawcs(309, "A Game by Radicalplay.com", 144, 167, 255, 3);
                    else
                        drawcs(309, "A Game by Radicalplay.com", 228, 240, 255, 3);
                }
                if (aflk)
                    drawcs(350, "Now get up and dance!", 144, 167, 255, 3);
                else
                    drawcs(350, "Now get up and dance!", 228, 240, 255, 3);
                pin = 0;
            }
            if (aflk)
                aflk = false;
            else
                aflk = true;
        }
        if (multion != 0 && (checkpoints).stage == -2 && i_120_ != 0) {
            drawcs(i_120_ + 17, new StringBuilder().append("Created by: ").append((checkpoints).maker).append("").toString(), 255, 161, 85, 3);
            if ((checkpoints).pubt > 0) {
                if ((checkpoints).pubt == 2)
                    drawcs(310, "Super Public Stage", 41, 177, 255, 3);
                else
                    drawcs(310, "Public Stage", 41, 177, 255, 3);
                if (dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 317, i, i_119_, bool)) {
                    if (logged) {
                        (cd).onstage = (checkpoints).name;
                        (cd).staction = 2;
                        cd.sparkstageaction();
                        dnload = 2;
                    } else {
                        dnload = 1;
                        waitlink = 20;
                    }
                }
                if (dnload == 1) {
                    rd.setColor(new Color(193, 106, 0));
                    String string_126_ = "Upgrade to a full account to add custom stages!";
                    int i_127_ = 400 - ftm.stringWidth(string_126_) / 2;
                    int i_128_ = i_127_ + ftm.stringWidth(string_126_);
                    rd.drawString(string_126_, i_127_, 332);
                    if (waitlink != -1)
                        rd.drawLine(i_127_, 334, i_128_, 334);
                    if (i > i_127_ && i < i_128_ && i_119_ > 321 && i_119_ < 334) {
                        if (waitlink != -1)
                            app.setCursor(new Cursor(12));
                        if (bool && waitlink == 0) {
                            app.editlink(nickname);
                            waitlink = -1;
                        }
                    } else
                        app.setCursor(new Cursor(0));
                    if (waitlink > 0)
                        waitlink--;
                }
                if (dnload == 2) {
                    drawcs(332, "Adding stage please wait...", 193, 106, 0, 3);
                    if ((cd).staction == 0)
                        dnload = 3;
                    if ((cd).staction == -2)
                        dnload = 4;
                    if ((cd).staction == -3)
                        dnload = 5;
                    if ((cd).staction == -1)
                        dnload = 6;
                }
                if (dnload == 3)
                    drawcs(332, "Stager has been successfully added to your stages!", 193, 106, 0, 3);
                if (dnload == 4)
                    drawcs(332, "You already have this stage!", 193, 106, 0, 3);
                if (dnload == 5)
                    drawcs(332, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                if (dnload == 6)
                    drawcs(332, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
            } else
                drawcs(342, "Private Stage", 193, 106, 0, 3);
        }
        rd.drawImage(contin[pcontin], 355, 380, null);
        if ((control).enter || (control).handb) {
            if (loadedt)
                strack.unload();
            if (multion == 0) {
                opselect = 3;
                if (gmode == 1) {
                    opselect = 0;
                    if (winner && (checkpoints).stage == unlocked[gmode - 1] + (gmode - 1) * 10 && (checkpoints).stage != 27) {
                        unlocked[gmode - 1]++;
                        justwon1 = true;
                    } else
                        justwon1 = false;
                }
                if (gmode == 2) {
                    opselect = 1;
                    if (winner && (checkpoints).stage == unlocked[gmode - 1] + (gmode - 1) * 10 && (checkpoints).stage != 27) {
                        unlocked[gmode - 1]++;
                        justwon2 = true;
                    } else
                        justwon2 = false;
                }
                if ((checkpoints).stage == 27 && gmode == 0)
                    (checkpoints).stage = (int) (Math.random() * 27.0) + 1;
                fase = 102;
            } else if (!mtop || nfreeplays >= 5 && !logged) {
                opselect = 2;
                fase = 102;
            } else
                fase = -9;
            if (multion == 0 && winner && (checkpoints).stage != 27 && (checkpoints).stage > 0)
                (checkpoints).stage++;
            if (!winner && multion != 0 && (forstart == 700 || discon == 240) && ndisco < 5)
                ndisco++;
            flipo = 0;
            (control).enter = false;
            (control).handb = false;
        }
    }
    
    public void sortcars(int i) {
        if (i != 0) {
            for (int i_129_ = 1; i_129_ < 7; i_129_++)
                sc[i_129_] = -1;
            boolean[] bools = new boolean[7];
            if (i < 0)
                i = 27;
            int i_130_ = 7;
            if (gmode == 1)
                i_130_ = 5;
            boolean bool = false;
            if (i <= 10) {
                int i_131_ = 6;
                if (gmode == 1)
                    i_131_ = 4;
                if ((i == 1 || i == 2) && sc[0] != 5) {
                    sc[i_131_] = 5;
                    i_130_ = i_131_;
                }
                if ((i == 3 || i == 4) && sc[0] != 6) {
                    sc[i_131_] = 6;
                    i_130_ = i_131_;
                }
                if ((i == 5 || i == 6) && sc[0] != 11) {
                    sc[i_131_] = 11;
                    i_130_ = i_131_;
                }
                if ((i == 7 || i == 8) && sc[0] != 14) {
                    sc[i_131_] = 14;
                    i_130_ = i_131_;
                }
                if ((i == 9 || i == 10) && sc[0] != 15) {
                    sc[i_131_] = 15;
                    i_130_ = i_131_;
                }
            } else {
                i -= 10;
                bool = true;
                if (sc[0] != 7 + (i + 1) / 2 && i != 17) {
                    sc[6] = 7 + (i + 1) / 2;
                    i_130_ = 6;
                }
            }
            int i_132_ = 16;
            int i_133_ = 1;
            int i_134_ = 2;
            for (int i_135_ = 1; i_135_ < i_130_; i_135_++) {
                bools[i_135_] = false;
                while (!bools[i_135_]) {
                    float f = 10.0F;
                    if (bool)
                        f = 17.0F;
                    sc[i_135_] = (int) (Math.random() * (double) (24.0F + 8.0F * ((float) i / f)));
                    if (sc[i_135_] >= 16)
                        sc[i_135_] -= 16;
                    bools[i_135_] = true;
                    for (int i_136_ = 0; i_136_ < 7; i_136_++) {
                        if (i_135_ != i_136_ && sc[i_135_] == sc[i_136_])
                            bools[i_135_] = false;
                    }
                    if (bool)
                        f = 16.0F;
                    float f_137_ = (float) (15 - sc[i_135_]) / 15.0F * ((float) i / f);
                    if ((double) f_137_ > 0.8)
                        f_137_ = 0.8F;
                    if (i == 17 && (double) f_137_ > 0.5)
                        f_137_ = 0.5F;
                    if ((double) f_137_ > Math.random())
                        bools[i_135_] = false;
                    if (gmode == 1) {
                        if (sc[i_135_] >= 7 && sc[i_135_] <= 10)
                            bools[i_135_] = false;
                        if (sc[i_135_] == 12 || sc[i_135_] == 13)
                            bools[i_135_] = false;
                        if (sc[i_135_] > 5 && unlocked[0] <= 2)
                            bools[i_135_] = false;
                        if (sc[i_135_] > 6 && unlocked[0] <= 4)
                            bools[i_135_] = false;
                        if (sc[i_135_] > 11 && unlocked[0] <= 6)
                            bools[i_135_] = false;
                        if (sc[i_135_] > 14 && unlocked[0] <= 8)
                            bools[i_135_] = false;
                    }
                    if (gmode == 2) {
                        if ((sc[i_135_] - 7) * 2 > unlocked[1])
                            bools[i_135_] = false;
                        if (i == 16 && unlocked[1] == 16 && sc[i_135_] < 9)
                            bools[i_135_] = false;
                    }
                }
                if (sc[i_135_] < i_132_) {
                    i_132_ = sc[i_135_];
                    if (i_133_ != i_135_) {
                        i_134_ = i_133_;
                        i_133_ = i_135_;
                    }
                }
            }
            if (!bool && i == 10) {
                boolean bool_138_ = false;
                for (int i_139_ = 0; i_139_ < 7; i_139_++) {
                    if (sc[i_139_] == 11)
                        bool_138_ = true;
                }
                if (!bool_138_ && (Math.random() > Math.random() || gmode != 0))
                    sc[i_133_] = 11;
                bool_138_ = false;
                for (int i_140_ = 0; i_140_ < 7; i_140_++) {
                    if (sc[i_140_] == 14)
                        bool_138_ = true;
                }
                if (!bool_138_ && (Math.random() > Math.random() || gmode != 0))
                    sc[i_134_] = 14;
            }
            if (i == 12) {
                boolean bool_141_ = false;
                for (int i_142_ = 0; i_142_ < 7; i_142_++) {
                    if (sc[i_142_] == 11)
                        bool_141_ = true;
                }
                if (!bool_141_)
                    sc[i_133_] = 11;
            }
            if (i == 14) {
                boolean bool_143_ = false;
                for (int i_144_ = 0; i_144_ < 7; i_144_++) {
                    if (sc[i_144_] == 12)
                        bool_143_ = true;
                }
                if (!bool_143_ && (Math.random() > Math.random() || gmode != 0))
                    sc[i_133_] = 12;
                bool_143_ = false;
                for (int i_145_ = 0; i_145_ < 7; i_145_++) {
                    if (sc[i_145_] == 10)
                        bool_143_ = true;
                }
                if (!bool_143_ && (Math.random() > Math.random() || gmode != 0))
                    sc[i_134_] = 10;
            }
            if (i == 15) {
                boolean bool_146_ = false;
                for (int i_147_ = 0; i_147_ < 7; i_147_++) {
                    if (sc[i_147_] == 11)
                        bool_146_ = true;
                }
                if (!bool_146_ && (Math.random() > Math.random() || gmode != 0))
                    sc[i_133_] = 11;
                bool_146_ = false;
                for (int i_148_ = 0; i_148_ < 7; i_148_++) {
                    if (sc[i_148_] == 13)
                        bool_146_ = true;
                }
                if (!bool_146_ && (Math.random() > Math.random() || gmode != 0))
                    sc[i_134_] = 13;
            }
            if (i == 16) {
                boolean bool_149_ = false;
                for (int i_150_ = 0; i_150_ < 7; i_150_++) {
                    if (sc[i_150_] == 13)
                        bool_149_ = true;
                }
                if (!bool_149_ && (Math.random() > Math.random() || gmode != 0))
                    sc[i_133_] = 13;
                bool_149_ = false;
                for (int i_151_ = 0; i_151_ < 7; i_151_++) {
                    if (sc[i_151_] == 12)
                        bool_149_ = true;
                }
                if (!bool_149_ && (Math.random() > Math.random() || gmode != 0))
                    sc[i_134_] = 12;
            }
            if ((cd).lastload == 1) {
                int i_152_ = 0;
                for (int i_153_ = 0; i_153_ < (cd).nlcars - 16; i_153_++) {
                    if (i_152_ == 0) {
                        for (int i_154_ = 1; i_154_ < i_130_; i_154_++)
                            bools[i_154_] = false;
                    }
                    if ((cd).include[i_153_] && sc[0] != i_153_ + 16) {
                        int i_155_;
                        for (i_155_ = (int) (1.0 + Math.random() * (double) (i_130_ - 1)); bools[i_155_]; i_155_ = (int) (1.0 + Math.random() * (double) (i_130_ - 1))) {
                            /* empty */
                        }
                        bools[i_155_] = true;
                        sc[i_155_] = i_153_ + 16;
                        if (++i_152_ == i_130_ - 1)
                            i_152_ = 0;
                    }
                }
            }
            if ((cd).lastload == 2) {
                int i_156_ = 0;
                for (int i_157_ = 0; i_157_ < (cd).nlocars - 16; i_157_++) {
                    if (i_156_ == 0) {
                        for (int i_158_ = 1; i_158_ < i_130_; i_158_++)
                            bools[i_158_] = false;
                    }
                    if ((cd).include[i_157_] && sc[0] != i_157_ + 16) {
                        int i_159_;
                        for (i_159_ = (int) (1.0 + Math.random() * (double) (i_130_ - 1)); bools[i_159_]; i_159_ = (int) (1.0 + Math.random() * (double) (i_130_ - 1))) {
                            /* empty */
                        }
                        bools[i_159_] = true;
                        sc[i_159_] = i_157_ + 16;
                        if (++i_156_ == i_130_ - 1)
                            i_156_ = 0;
                    }
                }
            }
        }
    }
    
    public void ctachm(int i, int i_160_, int i_161_, Control control) {
        if (fase == 1) {
            if (i_161_ == 1) {
                if (over(next[0], i, i_160_, 625, 135))
                    pnext = 1;
                if (over(back[0], i, i_160_, 115, 135))
                    pback = 1;
                if (over(contin[0], i, i_160_, 355, 360))
                    pcontin = 1;
            }
            if (i_161_ == 2) {
                if (pnext == 1)
                    (control).right = true;
                if (pback == 1)
                    (control).left = true;
                if (pcontin == 1)
                    (control).enter = true;
            }
        }
        if (fase == 3) {
            if (i_161_ == 1 && over(contin[0], i, i_160_, 355, 350))
                pcontin = 1;
            if (i_161_ == 2 && pcontin == 1) {
                (control).enter = true;
                pcontin = 0;
            }
        }
        if (fase == 4) {
            if (i_161_ == 1 && over(back[0], i, i_160_, 370, 345))
                pback = 1;
            if (i_161_ == 2 && pback == 1) {
                (control).enter = true;
                pback = 0;
            }
        }
        if (fase == 6) {
            if (i_161_ == 1 && (over(star[0], i, i_160_, 359, 385) || over(star[0], i, i_160_, 359, 295)))
                pstar = 2;
            if (i_161_ == 2 && pstar == 2) {
                (control).enter = true;
                pstar = 1;
            }
        }
        if (fase == 7) {
            if (i_161_ == 1) {
                if (over(next[0], i, i_160_, 645, 275))
                    pnext = 1;
                if (over(back[0], i, i_160_, 95, 275))
                    pback = 1;
                if (over(contin[0], i, i_160_, 355, 385))
                    pcontin = 1;
            }
            if (i_161_ == 2) {
                if (pnext == 1)
                    (control).right = true;
                if (pback == 1)
                    (control).left = true;
                if (pcontin == 1) {
                    (control).enter = true;
                    pcontin = 0;
                }
            }
        }
        if (fase == -5) {
            lxm = i;
            lym = i_160_;
            if (i_161_ == 1 && over(contin[0], i, i_160_, 355, 380))
                pcontin = 1;
            if (i_161_ == 2 && pcontin == 1) {
                (control).enter = true;
                pcontin = 0;
            }
        }
        if (fase == -7) {
            if (i_161_ == 1) {
                if (overon(329, 45, 137, 22, i, i_160_)) {
                    opselect = 0;
                    shaded = true;
                }
                if (overon(320, 73, 155, 22, i, i_160_)) {
                    opselect = 1;
                    shaded = true;
                }
                if (overon(303, 99, 190, 22, i, i_160_)) {
                    opselect = 2;
                    shaded = true;
                }
                if (overon(341, 125, 109, 22, i, i_160_)) {
                    opselect = 3;
                    shaded = true;
                }
            }
            if (i_161_ == 2 && shaded) {
                (control).enter = true;
                shaded = false;
            }
            if (i_161_ == 0 && (i != lxm || i_160_ != lym)) {
                if (overon(329, 45, 137, 22, i, i_160_))
                    opselect = 0;
                if (overon(320, 73, 155, 22, i, i_160_))
                    opselect = 1;
                if (overon(303, 99, 190, 22, i, i_160_))
                    opselect = 2;
                if (overon(341, 125, 109, 22, i, i_160_))
                    opselect = 3;
                lxm = i;
                lym = i_160_;
            }
        }
        if (fase == 10) {
            if (i_161_ == 1) {
                if (overon(343, 261, 110, 22, i, i_160_)) {
                    opselect = 0;
                    shaded = true;
                }
                if (overon(288, 291, 221, 22, i, i_160_)) {
                    opselect = 1;
                    shaded = true;
                }
                if (overon(301, 321, 196, 22, i, i_160_)) {
                    opselect = 2;
                    shaded = true;
                }
                if (overon(357, 351, 85, 22, i, i_160_)) {
                    opselect = 3;
                    shaded = true;
                }
            }
            if (i_161_ == 2 && shaded) {
                (control).enter = true;
                shaded = false;
            }
            if (i_161_ == 0 && (i != lxm || i_160_ != lym)) {
                if (overon(343, 261, 110, 22, i, i_160_))
                    opselect = 0;
                if (overon(288, 291, 221, 22, i, i_160_))
                    opselect = 1;
                if (overon(301, 321, 196, 22, i, i_160_))
                    opselect = 2;
                if (overon(357, 351, 85, 22, i, i_160_))
                    opselect = 3;
                lxm = i;
                lym = i_160_;
            }
        }
        if (fase == 102) {
            if (i_161_ == 1) {
                if (overon(358, 262 + dropf, 82, 22, i, i_160_)) {
                    opselect = 0;
                    shaded = true;
                }
                if (overon(358, 290 + dropf, 82, 22, i, i_160_)) {
                    opselect = 1;
                    shaded = true;
                }
                if (overon(333, 318 + dropf, 132, 22, i, i_160_)) {
                    opselect = 2;
                    shaded = true;
                }
                if (dropf == 0 && overon(348, 346, 102, 22, i, i_160_)) {
                    opselect = 3;
                    shaded = true;
                }
            }
            if (i_161_ == 2 && shaded) {
                (control).enter = true;
                shaded = false;
            }
            if (i_161_ == 0 && (i != lxm || i_160_ != lym)) {
                if (overon(358, 262 + dropf, 82, 22, i, i_160_))
                    opselect = 0;
                if (overon(358, 290 + dropf, 82, 22, i, i_160_))
                    opselect = 1;
                if (overon(333, 318 + dropf, 132, 22, i, i_160_))
                    opselect = 2;
                if (dropf == 0 && overon(348, 346, 102, 22, i, i_160_))
                    opselect = 3;
                lxm = i;
                lym = i_160_;
            }
        }
        if (fase == 11) {
            if (flipo >= 1 && flipo <= 15) {
                if (i_161_ == 1 && over(next[0], i, i_160_, 665, 395))
                    pnext = 1;
                if (i_161_ == 2 && pnext == 1) {
                    (control).right = true;
                    pnext = 0;
                }
            }
            if (flipo >= 3 && flipo <= 16) {
                if (i_161_ == 1 && over(back[0], i, i_160_, 75, 395))
                    pback = 1;
                if (i_161_ == 2 && pback == 1) {
                    (control).left = true;
                    pback = 0;
                }
            }
            if (flipo == 16) {
                if (i_161_ == 1 && over(contin[0], i, i_160_, 565, 395))
                    pcontin = 1;
                if (i_161_ == 2 && pcontin == 1) {
                    (control).enter = true;
                    pcontin = 0;
                }
            }
        }
        if (fase == 8) {
            if (i_161_ == 1 && over(next[0], i, i_160_, 665, 395))
                pnext = 1;
            if (i_161_ == 2 && pnext == 1) {
                (control).enter = true;
                pnext = 0;
            }
        }
    }
    
    public void stat(Mad mad, CheckPoints checkpoints, Control control, boolean bool) {
        if (holdit) {
            int i = 250;
            if (fase == 7001) {
                if (exitm != 4) {
                    exitm = 0;
                    i = 600;
                } else
                    i = 1200;
            }
            if (exitm != 4 || !lan || im != 0) {
                holdcnt++;
                if (((control).enter || holdcnt > i) && (!(control).chatup || fase != 7001)) {
                    fase = -2;
                    (control).enter = false;
                }
            } else if ((control).enter)
                (control).enter = false;
        } else {
            if (holdcnt != 0)
                holdcnt = 0;
            if ((control).enter || (control).exit) {
                if (fase == 0) {
                    if (loadedt)
                        strack.stop();
                    fase = -6;
                } else if (starcnt == 0 && !(control).chatup && (multion < 2 || !lan)) {
                    if (exitm == 0)
                        exitm = 1;
                    else
                        exitm = 0;
                }
                if (!(control).chatup || fase != 7001)
                    (control).enter = false;
                (control).exit = false;
            }
        }
        if (exitm == 2) {
            fase = -2;
            winner = false;
        }
        if (fase != -2) {
            if (multion < 2) {
                holdit = false;
                if ((checkpoints).wasted == nplayers - 1 && nplayers != 1) {
                    drawhi(youwastedem, 70);
                    if (aflk) {
                        drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                        aflk = false;
                    } else {
                        drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                        aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    (checkpoints).haltall = true;
                    holdit = true;
                    winner = true;
                }
                if (!holdit && (mad).dest && cntwis == 8) {
                    if (discon != 240)
                        drawhi(yourwasted, 70);
                    else {
                        drawhi(disco, 70);
                        stopchat();
                    }
                    boolean bool_162_ = false;
                    if (lan) {
                        bool_162_ = true;
                        for (int i = 0; i < nplayers; i++) {
                            if (i != im && dested[i] == 0 && plnames[i].indexOf("MadBot") == -1)
                                bool_162_ = false;
                        }
                    }
                    if (fase == 7001 && nplayers - ((checkpoints).wasted + 1) >= 2 && discon != 240 && !bool_162_)
                        exitm = 4;
                    else {
                        if (exitm == 4)
                            exitm = 0;
                        drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    }
                    holdit = true;
                    winner = false;
                }
                if (!holdit) {
                    for (int i = 0; i < nplayers; i++) {
                        if ((checkpoints).clear[i] == (checkpoints).nlaps * (checkpoints).nsp && (checkpoints).pos[i] == 0) {
                            if (i == im) {
                                drawhi(youwon, 70);
                                if (aflk) {
                                    drawcs(120, "You finished first, nice job!", 0, 0, 0, 0);
                                    aflk = false;
                                } else {
                                    drawcs(120, "You finished first, nice job!", 0, 128, 255, 0);
                                    aflk = true;
                                }
                                winner = true;
                            } else {
                                drawhi(youlost, 70);
                                if (fase != 7001) {
                                    if (aflk) {
                                        drawcs(120, new StringBuilder().append("").append((cd).names[sc[i]]).append(" finished first, race over!").toString(), 0, 0, 0, 0);
                                        aflk = false;
                                    } else {
                                        drawcs(120, new StringBuilder().append("").append((cd).names[sc[i]]).append(" finished first, race over!").toString(), 0, 128, 255, 0);
                                        aflk = true;
                                    }
                                } else if (aflk) {
                                    drawcs(120, new StringBuilder().append("").append(plnames[i]).append(" finished first, race over!").toString(), 0, 0, 0, 0);
                                    aflk = false;
                                } else {
                                    drawcs(120, new StringBuilder().append("").append(plnames[i]).append(" finished first, race over!").toString(), 0, 128, 255, 0);
                                    aflk = true;
                                }
                                winner = false;
                            }
                            drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                            (checkpoints).haltall = true;
                            holdit = true;
                        }
                    }
                }
            } else {
                holdit = false;
                if ((checkpoints).wasted >= nplayers - 1) {
                    String string = "Someone";
                    for (int i = 0; i < nplayers; i++) {
                        if ((checkpoints).dested[i] == 0)
                            string = plnames[i];
                    }
                    drawhi(gamefinished, 70);
                    if (aflk) {
                        drawcs(120, new StringBuilder().append("").append(string).append(" has wasted all the cars!").toString(), 0, 0, 0, 0);
                        aflk = false;
                    } else {
                        drawcs(120, new StringBuilder().append("").append(string).append(" has wasted all the cars!").toString(), 0, 128, 255, 0);
                        aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    (checkpoints).haltall = true;
                    holdit = true;
                    winner = false;
                }
                if (!holdit) {
                    for (int i = 0; i < nplayers; i++) {
                        if ((checkpoints).clear[i] == (checkpoints).nlaps * (checkpoints).nsp && (checkpoints).pos[i] == 0) {
                            drawhi(gamefinished, 70);
                            if (aflk) {
                                drawcs(120, new StringBuilder().append("").append(plnames[i]).append(" finished first, race over!").toString(), 0, 0, 0, 0);
                                aflk = false;
                            } else {
                                drawcs(120, new StringBuilder().append("").append(plnames[i]).append(" finished first, race over!").toString(), 0, 128, 255, 0);
                                aflk = true;
                            }
                            drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                            (checkpoints).haltall = true;
                            holdit = true;
                            winner = false;
                        }
                    }
                }
                if (!holdit && discon == 240) {
                    drawhi(gamefinished, 70);
                    if (aflk) {
                        drawcs(120, "Game got disconnected!", 0, 0, 0, 0);
                        aflk = false;
                    } else {
                        drawcs(120, "Game got disconnected!", 0, 128, 255, 0);
                        aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    (checkpoints).haltall = true;
                    holdit = true;
                    winner = false;
                }
                if (!holdit) {
                    rd.drawImage(wgame, 311, 20, null);
                    drawcs(397, "Click any player on the right to follow!", 0, 0, 0, 0);
                    if (!lan)
                        drawcs(412, "Press [V] to change view.  Press [Enter] to exit.", 0, 0, 0, 0);
                    else
                        drawcs(412, "Press [V] to change view.", 0, 0, 0, 0);
                }
            }
            if (bool) {
                if ((checkpoints).stage != 10 && multion < 2 && nplayers != 1 && arrace != (control).arrace) {
                    arrace = (control).arrace;
                    if (arrace) {
                        wasay = true;
                        say = " Arrow now pointing at  Cars  <";
                        tcnt = -5;
                    }
                    if (!arrace) {
                        wasay = false;
                        say = " Arrow now pointing at  Track  <";
                        tcnt = -5;
                        cntan = 20;
                        alocked = -1;
                        alocked = -1;
                    }
                }
                if (!holdit && fase != -6 && starcnt == 0 && multion < 2 && (checkpoints).stage != 10) {
                    arrow((mad).point, (mad).missedcp, checkpoints, arrace);
                    if (!arrace) {
                        if (auscnt == 45 && (mad).capcnt == 0 && exitm == 0) {
                            if ((mad).missedcp > 0) {
                                if ((mad).missedcp > 15 && (mad).missedcp < 50) {
                                    if (flk)
                                        drawcs(70, "Checkpoint Missed!", 255, 0, 0, 0);
                                    else
                                        drawcs(70, "Checkpoint Missed!", 255, 150, 0, 2);
                                }
                                (mad).missedcp++;
                                if ((mad).missedcp == 70)
                                    (mad).missedcp = -2;
                            } else if ((mad).mtouch && cntovn < 70) {
                                if (Math.abs(ana) > 100)
                                    cntan++;
                                else if (cntan != 0)
                                    cntan--;
                                if (cntan > 40) {
                                    cntovn++;
                                    cntan = 40;
                                    if (flk) {
                                        drawcs(70, "Wrong Way!", 255, 150, 0, 0);
                                        flk = false;
                                    } else {
                                        drawcs(70, "Wrong Way!", 255, 0, 0, 2);
                                        flk = true;
                                    }
                                }
                            }
                        }
                    } else if (alocked != lalocked) {
                        if (alocked != -1) {
                            wasay = true;
                            say = new StringBuilder().append(" Arrow Locked on   ").append(plnames[alocked]).append("   <").toString();
                            tcnt = -5;
                        } else {
                            wasay = true;
                            say = "Arrow Unlocked!";
                            tcnt = 10;
                        }
                        lalocked = alocked;
                    }
                }
                if ((m).darksky) {
                    Color color = new Color((m).csky[0], (m).csky[1], (m).csky[2]);
                    float[] fs = new float[3];
                    Color.RGBtoHSB((m).csky[0], (m).csky[1], (m).csky[2], fs);
                    fs[2] = 0.6F;
                    color = Color.getHSBColor(fs[0], fs[1], fs[2]);
                    rd.setColor(color);
                    rd.fillRect(602, 9, 54, 14);
                    rd.drawLine(601, 10, 601, 21);
                    rd.drawLine(600, 12, 600, 19);
                    rd.fillRect(607, 29, 49, 14);
                    rd.drawLine(606, 30, 606, 41);
                    rd.drawLine(605, 32, 605, 39);
                    rd.fillRect(18, 6, 155, 14);
                    rd.drawLine(17, 7, 17, 18);
                    rd.drawLine(16, 9, 16, 16);
                    rd.drawLine(173, 7, 173, 18);
                    rd.drawLine(174, 9, 174, 16);
                    rd.fillRect(40, 26, 107, 21);
                    rd.drawLine(39, 27, 39, 45);
                    rd.drawLine(38, 29, 38, 43);
                    rd.drawLine(147, 27, 147, 45);
                    rd.drawLine(148, 29, 148, 43);
                }
                rd.drawImage(dmg, 600, 7, null);
                rd.drawImage(pwr, 600, 27, null);
                rd.drawImage(lap, 19, 7, null);
                rd.setColor(new Color(0, 0, 100));
                rd.drawString(new StringBuilder().append("").append((mad).nlaps + 1).append(" / ").append((checkpoints).nlaps).append("").toString(), 51, 18);
                rd.drawImage(was, 92, 7, null);
                rd.setColor(new Color(0, 0, 100));
                rd.drawString(new StringBuilder().append("").append((checkpoints).wasted).append(" / ").append(nplayers - 1).append("").toString(), 150, 18);
                rd.drawImage(pos, 42, 27, null);
                rd.drawImage(rank[(checkpoints).pos[(mad).im]], 110, 28, null);
                drawstat((cd).maxmag[(mad).cn], (mad).hitmag, (mad).newcar, (mad).power);
            }
            if (!holdit) {
                if (starcnt != 0 && starcnt <= 35) {
                    if (starcnt == 35 && !mutes)
                        three.play();
                    if (starcnt == 24) {
                        gocnt = 2;
                        if (!mutes)
                            two.play();
                    }
                    if (starcnt == 13) {
                        gocnt = 1;
                        if (!mutes)
                            one.play();
                    }
                    if (starcnt == 2) {
                        gocnt = 0;
                        if (!mutes)
                            go.play();
                    }
                    duds = 0;
                    if (starcnt <= 37 && starcnt > 32)
                        duds = 1;
                    if (starcnt <= 26 && starcnt > 21)
                        duds = 1;
                    if (starcnt <= 15 && starcnt > 10)
                        duds = 1;
                    if (starcnt <= 4)
                        duds = 2;
                    if (dudo != -1) {
                        rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        rd.drawImage(dude[duds], dudo, 0, null);
                        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    if (gocnt != 0)
                        rd.drawImage(cntdn[gocnt], 385, 50, null);
                    else
                        rd.drawImage(cntdn[gocnt], 363, 50, null);
                }
                if (looped != 0 && (mad).loop == 2)
                    looped = 0;
                if ((mad).power < 45.0F) {
                    if (tcnt == 30 && auscnt == 45 && (mad).mtouch && (mad).capcnt == 0 && exitm == 0) {
                        if (looped != 2) {
                            if (pwcnt < 70 || pwcnt < 100 && looped != 0) {
                                if (pwflk) {
                                    drawcs(110, "Power low, perform stunt!", 0, 0, 200, 0);
                                    pwflk = false;
                                } else {
                                    drawcs(110, "Power low, perform stunt!", 255, 100, 0, 0);
                                    pwflk = true;
                                }
                            }
                        } else if (pwcnt < 100) {
                            String string = "";
                            if (multion == 0)
                                string = "  (Press Enter)";
                            if (pwflk) {
                                drawcs(110, new StringBuilder().append("Please read the Game Instructions!").append(string).append("").toString(), 0, 0, 200, 0);
                                pwflk = false;
                            } else {
                                drawcs(110, new StringBuilder().append("Please read the Game Instructions!").append(string).append("").toString(), 255, 100, 0, 0);
                                pwflk = true;
                            }
                        }
                        pwcnt++;
                        if (pwcnt == 300) {
                            pwcnt = 0;
                            if (looped != 0) {
                                looped++;
                                if (looped == 4)
                                    looped = 2;
                            }
                        }
                    }
                } else if (pwcnt != 0)
                    pwcnt = 0;
                if ((mad).capcnt == 0) {
                    if (tcnt < 30) {
                        if (exitm == 0) {
                            if (tflk) {
                                if (!wasay)
                                    drawcs(105, say, 0, 0, 0, 0);
                                else
                                    drawcs(105, say, 0, 0, 0, 0);
                                tflk = false;
                            } else {
                                if (!wasay)
                                    drawcs(105, say, 0, 128, 255, 0);
                                else
                                    drawcs(105, say, 255, 128, 0, 0);
                                tflk = true;
                            }
                        }
                        tcnt++;
                    } else if (wasay)
                        wasay = false;
                    if (auscnt < 45) {
                        if (exitm == 0) {
                            if (aflk) {
                                drawcs(85, asay, 98, 176, 255, 0);
                                aflk = false;
                            } else {
                                drawcs(85, asay, 0, 128, 255, 0);
                                aflk = true;
                            }
                        }
                        auscnt++;
                    }
                } else if (exitm == 0) {
                    if (tflk) {
                        drawcs(110, "Bad Landing!", 0, 0, 200, 0);
                        tflk = false;
                    } else {
                        drawcs(110, "Bad Landing!", 255, 100, 0, 0);
                        tflk = true;
                    }
                }
                if ((mad).trcnt == 10) {
                    loop = "";
                    spin = "";
                    asay = "";
                    int i = 0;
                    while ((mad).travzy > 225) {
                        (mad).travzy -= 360;
                        i++;
                    }
                    while ((mad).travzy < -225) {
                        (mad).travzy += 360;
                        i--;
                    }
                    if (i == 1)
                        loop = "Forward loop";
                    if (i == 2)
                        loop = "double Forward";
                    if (i == 3)
                        loop = "triple Forward";
                    if (i >= 4)
                        loop = "massive Forward looping";
                    if (i == -1)
                        loop = "Backloop";
                    if (i == -2)
                        loop = "double Back";
                    if (i == -3)
                        loop = "triple Back";
                    if (i <= -4)
                        loop = "massive Back looping";
                    if (i == 0) {
                        if ((mad).ftab && (mad).btab)
                            loop = "Tabletop and reversed Tabletop";
                        else if ((mad).ftab || (mad).btab)
                            loop = "Tabletop";
                    }
                    if (i > 0 && (mad).btab)
                        loop = new StringBuilder().append("Hanged ").append(loop).toString();
                    if (i < 0 && (mad).ftab)
                        loop = new StringBuilder().append("Hanged ").append(loop).toString();
                    if (loop != "") {
                        StringBuilder stringbuilder = new StringBuilder();
                        xtGraphics var_xtGraphics_163_ = this;
                        (var_xtGraphics_163_).asay = stringbuilder.append((var_xtGraphics_163_).asay).append(" ").append(loop).toString();
                    }
                    i = 0;
                    (mad).travxy = Math.abs((mad).travxy);
                    while ((mad).travxy > 270) {
                        (mad).travxy -= 360;
                        i++;
                    }
                    if (i == 0 && (mad).rtab) {
                        if (loop == "")
                            spin = "Tabletop";
                        else
                            spin = "Flipside";
                    }
                    if (i == 1)
                        spin = "Rollspin";
                    if (i == 2)
                        spin = "double Rollspin";
                    if (i == 3)
                        spin = "triple Rollspin";
                    if (i >= 4)
                        spin = "massive Roll spinning";
                    i = 0;
                    boolean bool_164_ = false;
                    (mad).travxz = Math.abs((mad).travxz);
                    while ((mad).travxz > 90) {
                        (mad).travxz -= 180;
                        i += 180;
                        if (i > 900) {
                            i = 900;
                            bool_164_ = true;
                        }
                    }
                    if (i != 0) {
                        if (loop == "" && spin == "") {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics_165_ = this;
                            (var_xtGraphics_165_).asay = stringbuilder.append((var_xtGraphics_165_).asay).append(" ").append(i).toString();
                            if (bool_164_) {
                                StringBuilder stringbuilder_166_ = new StringBuilder();
                                xtGraphics var_xtGraphics_167_ = this;
                                (var_xtGraphics_167_).asay = stringbuilder_166_.append((var_xtGraphics_167_).asay).append(" and beyond").toString();
                            }
                        } else {
                            if (spin != "") {
                                if (loop == "") {
                                    StringBuilder stringbuilder = new StringBuilder();
                                    xtGraphics var_xtGraphics_168_ = this;
                                    (var_xtGraphics_168_).asay = stringbuilder.append((var_xtGraphics_168_).asay).append(" ").append(spin).toString();
                                } else {
                                    StringBuilder stringbuilder = new StringBuilder();
                                    xtGraphics var_xtGraphics_169_ = this;
                                    (var_xtGraphics_169_).asay = stringbuilder.append((var_xtGraphics_169_).asay).append(" with ").append(spin).toString();
                                }
                            }
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics_170_ = this;
                            (var_xtGraphics_170_).asay = stringbuilder.append((var_xtGraphics_170_).asay).append(" by ").append(i).toString();
                            if (bool_164_) {
                                StringBuilder stringbuilder_171_ = new StringBuilder();
                                xtGraphics var_xtGraphics_172_ = this;
                                (var_xtGraphics_172_).asay = stringbuilder_171_.append((var_xtGraphics_172_).asay).append(" and beyond").toString();
                            }
                        }
                    } else if (spin != "") {
                        if (loop == "") {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics_173_ = this;
                            (var_xtGraphics_173_).asay = stringbuilder.append((var_xtGraphics_173_).asay).append(" ").append(spin).toString();
                        } else {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics_174_ = this;
                            (var_xtGraphics_174_).asay = stringbuilder.append((var_xtGraphics_174_).asay).append(" by ").append(spin).toString();
                        }
                    }
                    if (asay != "")
                        auscnt -= 15;
                    if (loop != "")
                        auscnt -= 25;
                    if (spin != "")
                        auscnt -= 25;
                    if (i != 0)
                        auscnt -= 25;
                    if (auscnt < 45) {
                        if (!mutes)
                            powerup.play();
                        if (auscnt < -20)
                            auscnt = -20;
                        int i_175_ = 0;
                        if ((mad).powerup > 20.0F)
                            i_175_ = 1;
                        if ((mad).powerup > 40.0F)
                            i_175_ = 2;
                        if ((mad).powerup > 150.0F)
                            i_175_ = 3;
                        if ((mad).surfer)
                            asay = new StringBuilder().append(" ").append(adj[4][(int) (m.random() * 3.0F)]).append(asay).toString();
                        if (i_175_ != 3)
                            asay = new StringBuilder().append(adj[i_175_][(int) (m.random() * 3.0F)]).append(asay).append(exlm[i_175_]).toString();
                        else
                            asay = adj[i_175_][(int) (m.random() * 3.0F)];
                        if (!wasay) {
                            tcnt = auscnt;
                            if ((mad).power != 98.0F)
                                say = new StringBuilder().append("Power Up ").append((int) (100.0F * (mad).powerup / 98.0F)).append("%").toString();
                            else
                                say = "Power To The MAX";
                            if (skidup)
                                skidup = false;
                            else
                                skidup = true;
                        }
                    }
                }
                if ((mad).newcar) {
                    if (!wasay) {
                        say = "Car Fixed";
                        tcnt = 0;
                    }
                    if (crashup)
                        crashup = false;
                    else
                        crashup = true;
                }
                for (int i = 0; i < nplayers; i++) {
                    if (dested[i] != (checkpoints).dested[i] && i != im) {
                        dested[i] = (checkpoints).dested[i];
                        if (fase != 7001) {
                            if (dested[i] == 1) {
                                wasay = true;
                                say = new StringBuilder().append("").append((cd).names[sc[i]]).append(" has been wasted!").toString();
                                tcnt = -15;
                            }
                            if (dested[i] == 2) {
                                wasay = true;
                                say = new StringBuilder().append("You wasted ").append((cd).names[sc[i]]).append("!").toString();
                                tcnt = -15;
                            }
                        } else {
                            if (dested[i] == 1) {
                                wasay = true;
                                say = new StringBuilder().append("").append(plnames[i]).append(" has been wasted!").toString();
                                tcnt = -15;
                            }
                            if (dested[i] == 2) {
                                wasay = true;
                                if (multion < 2)
                                    say = new StringBuilder().append("You wasted ").append(plnames[i]).append("!").toString();
                                else
                                    say = new StringBuilder().append("").append(plnames[im]).append(" wasted ").append(plnames[i]).append("!").toString();
                                tcnt = -15;
                            }
                            if (dested[i] == 3) {
                                wasay = true;
                                say = new StringBuilder().append("").append(plnames[i]).append(" has been wasted! (Disconnected)").toString();
                                tcnt = -15;
                            }
                        }
                    }
                }
                if (multion >= 2 && alocked != lalocked) {
                    if (alocked != -1) {
                        wasay = false;
                        say = new StringBuilder().append("Now following ").append(plnames[alocked]).append("!").toString();
                        tcnt = -15;
                    }
                    lalocked = alocked;
                    clear = (mad).clear;
                }
                if (clear != (mad).clear && (mad).clear != 0) {
                    if (!wasay) {
                        say = "Checkpoint!";
                        tcnt = 15;
                    }
                    clear = (mad).clear;
                    if (!mutes)
                        checkpoint.play();
                    cntovn = 0;
                    if (cntan != 0)
                        cntan = 0;
                }
            }
        }
        if ((m).lightn != -1) {
            int i = ((strack).sClip).stream.available();
            (m).lton = false;
            if (i <= 6380001 && i > 5368001)
                (m).lton = true;
            if (i <= 2992001 && i > 1320001)
                (m).lton = true;
        }
    }
    
    public void drawstat(int i, int i_176_, boolean bool, float f) {
        int[] is = new int[4];
        int[] is_177_ = new int[4];
        if (i_176_ > i)
            i_176_ = i;
        int i_178_ = (int) (98.0F * ((float) i_176_ / (float) i));
        is[0] = 662;
        is_177_[0] = 11;
        is[1] = 662;
        is_177_[1] = 20;
        is[2] = 662 + i_178_;
        is_177_[2] = 20;
        is[3] = 662 + i_178_;
        is_177_[3] = 11;
        int i_179_ = 244;
        int i_180_ = 244;
        int i_181_ = 11;
        if (i_178_ > 33)
            i_180_ = (int) (244.0F - 233.0F * ((float) (i_178_ - 33) / 65.0F));
        if (i_178_ > 70) {
            if (dmcnt < 10) {
                if (dmflk) {
                    i_180_ = 170;
                    dmflk = false;
                } else
                    dmflk = true;
            }
            dmcnt++;
            if ((double) dmcnt > 167.0 - (double) i_178_ * 1.5)
                dmcnt = 0;
        }
        i_179_ += (float) i_179_ * ((float) (m).snap[0] / 100.0F);
        if (i_179_ > 255)
            i_179_ = 255;
        if (i_179_ < 0)
            i_179_ = 0;
        i_180_ += (float) i_180_ * ((float) (m).snap[1] / 100.0F);
        if (i_180_ > 255)
            i_180_ = 255;
        if (i_180_ < 0)
            i_180_ = 0;
        i_181_ += (float) i_181_ * ((float) (m).snap[2] / 100.0F);
        if (i_181_ > 255)
            i_181_ = 255;
        if (i_181_ < 0)
            i_181_ = 0;
        rd.setColor(new Color(i_179_, i_180_, i_181_));
        rd.fillPolygon(is, is_177_, 4);
        is[0] = 662;
        is_177_[0] = 31;
        is[1] = 662;
        is_177_[1] = 40;
        is[2] = (int) (662.0F + f);
        is_177_[2] = 40;
        is[3] = (int) (662.0F + f);
        is_177_[3] = 31;
        i_179_ = 128;
        if (f == 98.0F)
            i_179_ = 64;
        i_180_ = (int) (190.0 + (double) f * 0.37);
        i_181_ = 244;
        if (auscnt < 45 && aflk) {
            i_179_ = 128;
            i_180_ = 244;
            i_181_ = 244;
        }
        i_179_ += (float) i_179_ * ((float) (m).snap[0] / 100.0F);
        if (i_179_ > 255)
            i_179_ = 255;
        if (i_179_ < 0)
            i_179_ = 0;
        i_180_ += (float) i_180_ * ((float) (m).snap[1] / 100.0F);
        if (i_180_ > 255)
            i_180_ = 255;
        if (i_180_ < 0)
            i_180_ = 0;
        i_181_ += (float) i_181_ * ((float) (m).snap[2] / 100.0F);
        if (i_181_ > 255)
            i_181_ = 255;
        if (i_181_ < 0)
            i_181_ = 0;
        rd.setColor(new Color(i_179_, i_180_, i_181_));
        rd.fillPolygon(is, is_177_, 4);
    }
    
    public void drawhi(Image image, int i) {
        if ((m).darksky) {
            Color color = new Color((m).csky[0], (m).csky[1], (m).csky[2]);
            float[] fs = new float[3];
            Color.RGBtoHSB((m).csky[0], (m).csky[1], (m).csky[2], fs);
            fs[2] = 0.6F;
            color = Color.getHSBColor(fs[0], fs[1], fs[2]);
            rd.setColor(color);
            rd.fillRoundRect(390 - image.getWidth(ob) / 2, i - 2, image.getWidth(ob) + 20, image.getHeight(ob) + 2, 7, 20);
            rd.setColor(new Color((int) ((double) color.getRed() / 1.1), (int) ((double) color.getGreen() / 1.1), (int) ((double) color.getBlue() / 1.1)));
            rd.drawRoundRect(390 - image.getWidth(ob) / 2, i - 2, image.getWidth(ob) + 20, image.getHeight(ob) + 2, 7, 20);
        }
        rd.drawImage(image, 400 - image.getWidth(ob) / 2, i, null);
    }
    
    public void drawcs(int i, String string, int i_182_, int i_183_, int i_184_, int i_185_) {
        if (i_185_ != 3 && i_185_ != 4) {
            i_182_ += (float) i_182_ * ((float) (m).snap[0] / 100.0F);
            if (i_182_ > 255)
                i_182_ = 255;
            if (i_182_ < 0)
                i_182_ = 0;
            i_183_ += (float) i_183_ * ((float) (m).snap[1] / 100.0F);
            if (i_183_ > 255)
                i_183_ = 255;
            if (i_183_ < 0)
                i_183_ = 0;
            i_184_ += (float) i_184_ * ((float) (m).snap[2] / 100.0F);
            if (i_184_ > 255)
                i_184_ = 255;
            if (i_184_ < 0)
                i_184_ = 0;
        }
        if (i_185_ == 4) {
            i_182_ -= (float) i_182_ * ((float) (m).snap[0] / 100.0F);
            if (i_182_ > 255)
                i_182_ = 255;
            if (i_182_ < 0)
                i_182_ = 0;
            i_183_ -= (float) i_183_ * ((float) (m).snap[1] / 100.0F);
            if (i_183_ > 255)
                i_183_ = 255;
            if (i_183_ < 0)
                i_183_ = 0;
            i_184_ -= (float) i_184_ * ((float) (m).snap[2] / 100.0F);
            if (i_184_ > 255)
                i_184_ = 255;
            if (i_184_ < 0)
                i_184_ = 0;
        }
        if (i_185_ == 1) {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, 400 - ftm.stringWidth(string) / 2 + 1, i + 1);
        }
        if (i_185_ == 2) {
            i_182_ = (i_182_ * 2 + (m).csky[0] * 1) / 3;
            if (i_182_ > 255)
                i_182_ = 255;
            if (i_182_ < 0)
                i_182_ = 0;
            i_183_ = (i_183_ * 2 + (m).csky[1] * 1) / 3;
            if (i_183_ > 255)
                i_183_ = 255;
            if (i_183_ < 0)
                i_183_ = 0;
            i_184_ = (i_184_ * 2 + (m).csky[2] * 1) / 3;
            if (i_184_ > 255)
                i_184_ = 255;
            if (i_184_ < 0)
                i_184_ = 0;
        }
        rd.setColor(new Color(i_182_, i_183_, i_184_));
        rd.drawString(string, 400 - ftm.stringWidth(string) / 2, i);
    }
    
    public void arrow(int i, int i_186_, CheckPoints checkpoints, boolean bool) {
        int[] is = new int[7];
        int[] is_187_ = new int[7];
        int[] is_188_ = new int[7];
        int i_189_ = 400;
        int i_190_ = -90;
        int i_191_ = 700;
        for (int i_192_ = 0; i_192_ < 7; i_192_++)
            is_187_[i_192_] = i_190_;
        is[0] = i_189_;
        is_188_[0] = i_191_ + 110;
        is[1] = i_189_ - 35;
        is_188_[1] = i_191_ + 50;
        is[2] = i_189_ - 15;
        is_188_[2] = i_191_ + 50;
        is[3] = i_189_ - 15;
        is_188_[3] = i_191_ - 50;
        is[4] = i_189_ + 15;
        is_188_[4] = i_191_ - 50;
        is[5] = i_189_ + 15;
        is_188_[5] = i_191_ + 50;
        is[6] = i_189_ + 35;
        is_188_[6] = i_191_ + 50;
        int i_194_;
        if (!bool) {
            int i_195_ = 0;
            if ((checkpoints).x[i] - (checkpoints).opx[im] >= 0)
                i_195_ = 180;
            i_194_ = (int) ((double) (90 + i_195_) + Math.atan((double) ((checkpoints).z[i] - (checkpoints).opz[im]) / (double) ((checkpoints).x[i] - (checkpoints).opx[im])) / 0.017453292519943295);
        } else {
            int i_196_ = 0;
            if (multion == 0 || alocked == -1) {
                int i_197_ = -1;
                boolean bool_198_ = false;
                for (int i_199_ = 0; i_199_ < nplayers; i_199_++) {
                    if (i_199_ != im && (py((checkpoints).opx[im] / 100, (checkpoints).opx[i_199_] / 100, (checkpoints).opz[im] / 100, (checkpoints).opz[i_199_] / 100) < i_197_ || i_197_ == -1) && (!bool_198_ || (checkpoints).onscreen[i_199_] != 0) && (checkpoints).dested[i_199_] == 0) {
                        i_196_ = i_199_;
                        i_197_ = py((checkpoints).opx[im] / 100, (checkpoints).opx[i_199_] / 100, (checkpoints).opz[im] / 100, (checkpoints).opz[i_199_] / 100);
                        if ((checkpoints).onscreen[i_199_] != 0)
                            bool_198_ = true;
                    }
                }
            } else
                i_196_ = alocked;
            int i_200_ = 0;
            if ((checkpoints).opx[i_196_] - (checkpoints).opx[im] >= 0)
                i_200_ = 180;
            i_194_ = (int) ((double) (90 + i_200_) + Math.atan((double) ((checkpoints).opz[i_196_] - (checkpoints).opz[im]) / (double) ((checkpoints).opx[i_196_] - (checkpoints).opx[im])) / 0.017453292519943295);
            if (multion == 0) {
                drawcs(13, "[                                ]", 76, 67, 240, 0);
                drawcs(13, (cd).names[sc[i_196_]], 0, 0, 0, 0);
            } else {
                rd.setFont(new Font("Arial", 1, 12));
                ftm = rd.getFontMetrics();
                drawcs(17, "[                                ]", 76, 67, 240, 0);
                drawcs(12, plnames[i_196_], 0, 0, 0, 0);
                rd.setFont(new Font("Arial", 0, 10));
                ftm = rd.getFontMetrics();
                drawcs(24, (cd).names[sc[i_196_]], 0, 0, 0, 0);
                rd.setFont(new Font("Arial", 1, 11));
                ftm = rd.getFontMetrics();
            }
        }
        for (i_194_ += (m).xz; i_194_ < 0; i_194_ += 360) {
            /* empty */
        }
        for (/**/; i_194_ > 180; i_194_ -= 360) {
            /* empty */
        }
        if (!bool) {
            if (i_194_ > 130)
                i_194_ = 130;
            if (i_194_ < -130)
                i_194_ = -130;
        } else {
            if (i_194_ > 100)
                i_194_ = 100;
            if (i_194_ < -100)
                i_194_ = -100;
        }
        if (Math.abs(ana - i_194_) < 180) {
            if (Math.abs(ana - i_194_) < 10)
                ana = i_194_;
            else if (ana < i_194_)
                ana += 10;
            else
                ana -= 10;
        } else {
            if (i_194_ < 0) {
                ana += 15;
                if (ana > 180)
                    ana -= 360;
            }
            if (i_194_ > 0) {
                ana -= 15;
                if (ana < -180)
                    ana += 360;
            }
        }
        rot(is, is_188_, i_189_, i_191_, ana, 7);
        i_194_ = Math.abs(ana);
        if (!bool) {
            if (i_194_ > 7 || i_186_ > 0 || i_186_ == -2 || cntan != 0) {
                for (int i_201_ = 0; i_201_ < 7; i_201_++) {
                    is[i_201_] = xs(is[i_201_], is_188_[i_201_]);
                    is_187_[i_201_] = ys(is_187_[i_201_], is_188_[i_201_]);
                }
                int i_202_ = (int) (190.0F + 190.0F * ((float) (m).snap[0] / 100.0F));
                if (i_202_ > 255)
                    i_202_ = 255;
                if (i_202_ < 0)
                    i_202_ = 0;
                int i_203_ = (int) (255.0F + 255.0F * ((float) (m).snap[1] / 100.0F));
                if (i_203_ > 255)
                    i_203_ = 255;
                if (i_203_ < 0)
                    i_203_ = 0;
                int i_204_ = 0;
                if (i_186_ <= 0) {
                    if (i_194_ <= 45 && i_186_ != -2 && cntan == 0) {
                        i_202_ = (i_202_ * i_194_ + (m).csky[0] * (45 - i_194_)) / 45;
                        i_203_ = (i_203_ * i_194_ + (m).csky[1] * (45 - i_194_)) / 45;
                        i_204_ = (i_204_ * i_194_ + (m).csky[2] * (45 - i_194_)) / 45;
                    }
                    if (i_194_ >= 90) {
                        int i_205_ = (int) (255.0F + 255.0F * ((float) (m).snap[0] / 100.0F));
                        if (i_205_ > 255)
                            i_205_ = 255;
                        if (i_205_ < 0)
                            i_205_ = 0;
                        i_202_ = (i_202_ * (140 - i_194_) + i_205_ * (i_194_ - 90)) / 50;
                        if (i_202_ > 255)
                            i_202_ = 255;
                    }
                } else if (flk) {
                    i_202_ = (int) (255.0F + 255.0F * ((float) (m).snap[0] / 100.0F));
                    if (i_202_ > 255)
                        i_202_ = 255;
                    if (i_202_ < 0)
                        i_202_ = 0;
                    flk = false;
                } else {
                    i_202_ = (int) (255.0F + 255.0F * ((float) (m).snap[0] / 100.0F));
                    if (i_202_ > 255)
                        i_202_ = 255;
                    if (i_202_ < 0)
                        i_202_ = 0;
                    i_203_ = (int) (220.0F + 220.0F * ((float) (m).snap[1] / 100.0F));
                    if (i_203_ > 255)
                        i_203_ = 255;
                    if (i_203_ < 0)
                        i_203_ = 0;
                    flk = true;
                }
                rd.setColor(new Color(i_202_, i_203_, i_204_));
                rd.fillPolygon(is, is_187_, 7);
                i_202_ = (int) (115.0F + 115.0F * ((float) (m).snap[0] / 100.0F));
                if (i_202_ > 255)
                    i_202_ = 255;
                if (i_202_ < 0)
                    i_202_ = 0;
                i_203_ = (int) (170.0F + 170.0F * ((float) (m).snap[1] / 100.0F));
                if (i_203_ > 255)
                    i_203_ = 255;
                if (i_203_ < 0)
                    i_203_ = 0;
                i_204_ = 0;
                if (i_186_ <= 0) {
                    if (i_194_ <= 45 && i_186_ != -2 && cntan == 0) {
                        i_202_ = (i_202_ * i_194_ + (m).csky[0] * (45 - i_194_)) / 45;
                        i_203_ = (i_203_ * i_194_ + (m).csky[1] * (45 - i_194_)) / 45;
                        i_204_ = (i_204_ * i_194_ + (m).csky[2] * (45 - i_194_)) / 45;
                    }
                } else if (flk) {
                    i_202_ = (int) (255.0F + 255.0F * ((float) (m).snap[0] / 100.0F));
                    if (i_202_ > 255)
                        i_202_ = 255;
                    if (i_202_ < 0)
                        i_202_ = 0;
                    i_203_ = 0;
                }
                rd.setColor(new Color(i_202_, i_203_, i_204_));
                rd.drawPolygon(is, is_187_, 7);
            }
        } else {
            int i_206_ = 0;
            if (multion != 0)
                i_206_ = 8;
            for (int i_207_ = 0; i_207_ < 7; i_207_++) {
                is[i_207_] = xs(is[i_207_], is_188_[i_207_]);
                is_187_[i_207_] = ys(is_187_[i_207_], is_188_[i_207_]) + i_206_;
            }
            int i_208_ = (int) (159.0F + 159.0F * ((float) (m).snap[0] / 100.0F));
            if (i_208_ > 255)
                i_208_ = 255;
            if (i_208_ < 0)
                i_208_ = 0;
            int i_209_ = (int) (207.0F + 207.0F * ((float) (m).snap[1] / 100.0F));
            if (i_209_ > 255)
                i_209_ = 255;
            if (i_209_ < 0)
                i_209_ = 0;
            int i_210_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 100.0F));
            if (i_210_ > 255)
                i_210_ = 255;
            if (i_210_ < 0)
                i_210_ = 0;
            rd.setColor(new Color(i_208_, i_209_, i_210_));
            rd.fillPolygon(is, is_187_, 7);
            i_208_ = (int) (120.0F + 120.0F * ((float) (m).snap[0] / 100.0F));
            if (i_208_ > 255)
                i_208_ = 255;
            if (i_208_ < 0)
                i_208_ = 0;
            i_209_ = (int) (114.0F + 114.0F * ((float) (m).snap[1] / 100.0F));
            if (i_209_ > 255)
                i_209_ = 255;
            if (i_209_ < 0)
                i_209_ = 0;
            i_210_ = (int) (255.0F + 255.0F * ((float) (m).snap[2] / 100.0F));
            if (i_210_ > 255)
                i_210_ = 255;
            if (i_210_ < 0)
                i_210_ = 0;
            rd.setColor(new Color(i_208_, i_209_, i_210_));
            rd.drawPolygon(is, is_187_, 7);
        }
    }
    
    public void playsounds(Mad mad, Control control, int i) {
        if ((fase == 0 || fase == 7001) && starcnt < 35 && cntwis != 8 && !mutes) {
            boolean bool = (control).up && (mad).speed > 0.0F || (control).down && (mad).speed < 10.0F;
            boolean bool_211_ = (mad).skid == 1 && (control).handb || Math.abs((mad).scz[0] - ((mad).scz[1] + (mad).scz[0] + (mad).scz[2] + (mad).scz[3]) / 4.0F) > 1.0F || Math.abs((mad).scx[0] - ((mad).scx[1] + (mad).scx[0] + (mad).scx[2] + (mad).scx[3]) / 4.0F) > 1.0F;
            boolean bool_212_ = false;
            if ((control).up && (mad).speed < 10.0F) {
                bool_211_ = true;
                bool = true;
                bool_212_ = true;
            }
            if (bool && (mad).mtouch) {
                if (!(mad).capsized) {
                    if (!bool_211_) {
                        if ((mad).power != 98.0F) {
                            if (Math.abs((mad).speed) > 0.0F && Math.abs((mad).speed) <= (float) (cd).swits[(mad).cn][0]) {
                                int i_213_ = (int) (3.0F * Math.abs((mad).speed) / (float) (cd).swits[(mad).cn][0]);
                                if (i_213_ == 2) {
                                    if (pwait == 0)
                                        i_213_ = 0;
                                    else
                                        pwait--;
                                } else
                                    pwait = 7;
                                sparkeng(i_213_, (mad).cn);
                            }
                            if (Math.abs((mad).speed) > (float) (cd).swits[(mad).cn][0] && Math.abs((mad).speed) <= (float) (cd).swits[(mad).cn][1]) {
                                int i_214_ = (int) (3.0F * (Math.abs((mad).speed) - (float) (cd).swits[(mad).cn][0]) / (float) ((cd).swits[(mad).cn][1] - (cd).swits[(mad).cn][0]));
                                if (i_214_ == 2) {
                                    if (pwait == 0)
                                        i_214_ = 0;
                                    else
                                        pwait--;
                                } else
                                    pwait = 7;
                                sparkeng(i_214_, (mad).cn);
                            }
                            if (Math.abs((mad).speed) > (float) (cd).swits[(mad).cn][1] && Math.abs((mad).speed) <= (float) (cd).swits[(mad).cn][2]) {
                                int i_215_ = (int) (3.0F * (Math.abs((mad).speed) - (float) (cd).swits[(mad).cn][1]) / (float) ((cd).swits[(mad).cn][2] - (cd).swits[(mad).cn][1]));
                                sparkeng(i_215_, (mad).cn);
                            }
                        } else {
                            int i_216_ = 2;
                            if (pwait == 0) {
                                if (Math.abs((mad).speed) > (float) (cd).swits[(mad).cn][1])
                                    i_216_ = 3;
                            } else
                                pwait--;
                            sparkeng(i_216_, (mad).cn);
                        }
                    } else {
                        sparkeng(-1, (mad).cn);
                        if (bool_212_) {
                            if (stopcnt <= 0) {
                                air[5].loop();
                                stopcnt = 10;
                            }
                        } else if (stopcnt <= -2) {
                            air[2 + (int) (m.random() * 3.0F)].loop();
                            stopcnt = 7;
                        }
                    }
                } else
                    sparkeng(3, (mad).cn);
                grrd = false;
                aird = false;
            } else {
                pwait = 15;
                if (!(mad).mtouch && !grrd && (double) m.random() > 0.4) {
                    air[(int) (m.random() * 4.0F)].loop();
                    stopcnt = 5;
                    grrd = true;
                }
                if (!(mad).wtouch && !aird) {
                    stopairs();
                    air[(int) (m.random() * 4.0F)].loop();
                    stopcnt = 10;
                    aird = true;
                }
                sparkeng(-1, (mad).cn);
            }
            if ((mad).cntdest != 0 && cntwis < 7) {
                if (!pwastd) {
                    wastd.loop();
                    pwastd = true;
                }
            } else {
                if (pwastd) {
                    wastd.stop();
                    pwastd = false;
                }
                if (cntwis == 7 && !mutes)
                    firewasted.play();
            }
        } else {
            sparkeng(-2, (mad).cn);
            if (pwastd) {
                wastd.stop();
                pwastd = false;
            }
        }
        if (stopcnt != -20) {
            if (stopcnt == 1)
                stopairs();
            stopcnt--;
        }
        if (bfcrash != 0)
            bfcrash--;
        if (bfscrape != 0)
            bfscrape--;
        if (bfsc1 != 0)
            bfsc1--;
        if (bfsc2 != 0)
            bfsc2--;
        if (bfskid != 0)
            bfskid--;
        if ((mad).newcar)
            cntwis = 0;
        if (fase == 0 || fase == 7001 || fase == 6 || fase == -1 || fase == -2 || fase == -3 || fase == -4 || fase == -5) {
            if (mutes != (control).mutes)
                mutes = (control).mutes;
            if ((control).mutem != mutem) {
                mutem = (control).mutem;
                if (mutem) {
                    if (loadedt)
                        strack.stop();
                } else if (loadedt)
                    strack.resume();
            }
        }
        if ((mad).cntdest != 0 && cntwis < 7) {
            if ((mad).dest)
                cntwis++;
        } else {
            if ((mad).cntdest == 0)
                cntwis = 0;
            if (cntwis == 7)
                cntwis = 8;
        }
        if (macn)
            closesounds();
    }
    
    public void stopairs() {
        for (int i = 0; i < 6; i++)
            air[i].stop();
    }
    
    public void sparkeng(int i, int i_217_) {
        if (lcn != i_217_) {
            for (int i_218_ = 0; i_218_ < 5; i_218_++) {
                if (pengs[i_218_]) {
                    engs[(cd).enginsignature[lcn]][i_218_].stop();
                    pengs[i_218_] = false;
                }
            }
            lcn = i_217_;
        }
        i++;
        for (int i_219_ = 0; i_219_ < 5; i_219_++) {
            if (i == i_219_) {
                if (!pengs[i_219_]) {
                    engs[(cd).enginsignature[i_217_]][i_219_].loop();
                    pengs[i_219_] = true;
                }
            } else if (pengs[i_219_]) {
                engs[(cd).enginsignature[i_217_]][i_219_].stop();
                pengs[i_219_] = false;
            }
        }
    }
    
    public void crash(float f, int i) {
        if (bfcrash == 0) {
            if (i == 0) {
                if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F) {
                    if (!mutes)
                        lowcrash[crshturn].play();
                    bfcrash = 2;
                }
                if (Math.abs(f) >= 170.0F) {
                    if (!mutes)
                        crash[crshturn].play();
                    bfcrash = 2;
                }
                if (Math.abs(f) > 25.0F) {
                    if (crashup)
                        crshturn--;
                    else
                        crshturn++;
                    if (crshturn == -1)
                        crshturn = 2;
                    if (crshturn == 3)
                        crshturn = 0;
                }
            }
            if (i == -1) {
                if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F) {
                    if (!mutes)
                        lowcrash[2].play();
                    bfcrash = 2;
                }
                if (Math.abs(f) > 170.0F) {
                    if (!mutes)
                        crash[2].play();
                    bfcrash = 2;
                }
            }
            if (i == 1) {
                if (!mutes)
                    tires.play();
                bfcrash = 3;
            }
        }
    }
    
    public void skid(int i, float f) {
        if (bfcrash == 0 && bfskid == 0 && f > 150.0F) {
            if (i == 0) {
                if (!mutes)
                    skid[skflg].play();
                if (skidup)
                    skflg++;
                else
                    skflg--;
                if (skflg == 3)
                    skflg = 0;
                if (skflg == -1)
                    skflg = 2;
            } else {
                if (!mutes)
                    dustskid[dskflg].play();
                if (skidup)
                    dskflg++;
                else
                    dskflg--;
                if (dskflg == 3)
                    dskflg = 0;
                if (dskflg == -1)
                    dskflg = 2;
            }
            bfskid = 35;
        }
    }
    
    public void scrape(int i, int i_220_, int i_221_) {
        if (bfscrape == 0 && Math.sqrt((double) (i * i + i_220_ * i_220_ + i_221_ * i_221_)) / 10.0 > 10.0) {
            int i_222_ = 0;
            if (m.random() > m.random())
                i_222_ = 1;
            if (i_222_ == 0) {
                sturn1 = 0;
                sturn0++;
                if (sturn0 == 3) {
                    i_222_ = 1;
                    sturn1 = 1;
                    sturn0 = 0;
                }
            } else {
                sturn0 = 0;
                sturn1++;
                if (sturn1 == 3) {
                    i_222_ = 0;
                    sturn0 = 1;
                    sturn1 = 0;
                }
            }
            if (!mutes)
                scrape[i_222_].play();
            bfscrape = 5;
        }
    }
    
    public void gscrape(int i, int i_223_, int i_224_) {
        if ((bfsc1 == 0 || bfsc2 == 0) && Math.sqrt((double) (i * i + i_223_ * i_223_ + i_224_ * i_224_)) / 10.0 > 15.0) {
            if (bfsc1 == 0) {
                if (!mutes) {
                    scrape[2].stop();
                    scrape[2].play();
                }
                bfsc1 = 12;
                bfsc2 = 6;
            } else {
                if (!mutes) {
                    scrape[3].stop();
                    scrape[3].play();
                }
                bfsc2 = 12;
                bfsc1 = 6;
            }
        }
    }
    
    public void closesounds() {
        for (int i = 0; i < 5; i++) {
            for (int i_225_ = 0; i_225_ < 5; i_225_++)
                engs[i][i_225_].checkopen();
        }
        for (int i = 0; i < 6; i++)
            air[i].checkopen();
        tires.checkopen();
        checkpoint.checkopen();
        carfixed.checkopen();
        powerup.checkopen();
        three.checkopen();
        two.checkopen();
        one.checkopen();
        go.checkopen();
        wastd.checkopen();
        firewasted.checkopen();
        for (int i = 0; i < 3; i++) {
            skid[i].checkopen();
            dustskid[i].checkopen();
            crash[i].checkopen();
            lowcrash[i].checkopen();
            scrape[i].checkopen();
        }
    }
    
    public void rot(int[] is, int[] is_226_, int i, int i_227_, int i_228_, int i_229_) {
        if (i_228_ != 0) {
            for (int i_230_ = 0; i_230_ < i_229_; i_230_++) {
                int i_231_ = is[i_230_];
                int i_232_ = is_226_[i_230_];
                is[i_230_] = i + (int) ((float) (i_231_ - i) * m.cos(i_228_) - (float) (i_232_ - i_227_) * m.sin(i_228_));
                is_226_[i_230_] = i_227_ + (int) ((float) (i_231_ - i) * m.sin(i_228_) + (float) (i_232_ - i_227_) * m.cos(i_228_));
            }
        }
    }
    
    public int xs(int i, int i_233_) {
        if (i_233_ < 50)
            i_233_ = 50;
        return (i_233_ - (m).focus_point) * ((m).cx - i) / i_233_ + i;
    }
    
    public int ys(int i, int i_234_) {
        if (i_234_ < 50)
            i_234_ = 50;
        return (i_234_ - (m).focus_point) * ((m).cy - i) / i_234_ + i;
    }
    
    public int py(int i, int i_235_, int i_236_, int i_237_) {
        return (i - i_235_) * (i - i_235_) + (i_236_ - i_237_) * (i_236_ - i_237_);
    }
    
    public float pys(int i, int i_238_, int i_239_, int i_240_) {
        return (float) Math.sqrt((double) ((i - i_238_) * (i - i_238_) + (i_239_ - i_240_) * (i_239_ - i_240_)));
    }
    
    public void snap(int i) {
        dmg = loadsnap(odmg);
        pwr = loadsnap(opwr);
        was = loadsnap(owas);
        lap = loadsnap(olap);
        pos = loadsnap(opos);
        for (int i_241_ = 0; i_241_ < 7; i_241_++)
            rank[i_241_] = loadsnap(orank[i_241_]);
        for (int i_242_ = 0; i_242_ < 4; i_242_++)
            cntdn[i_242_] = loadsnap(ocntdn[i_242_]);
        if (multion != 0) {
            wgame = loadsnap(owgame);
            exitgame = loadsnap(oexitgame);
            gamefinished = loadsnap(ogamefinished);
            disco = loadsnap(odisco);
        }
        yourwasted = loadsnap(oyourwasted);
        youlost = loadsnap(oyoulost);
        youwon = loadsnap(oyouwon);
        youwastedem = loadsnap(oyouwastedem);
        gameh = loadsnap(ogameh);
        loadingmusic = loadopsnap(oloadingmusic, i, 76);
        star[0] = loadopsnap(ostar[0], i, 0);
        star[1] = loadopsnap(ostar[1], i, 0);
        flaot = loadopsnap(oflaot, i, 1);
    }
    
    public boolean overon(int i, int i_243_, int i_244_, int i_245_, int i_246_, int i_247_) {
        return i_246_ > i && i_246_ < i + i_244_ && i_247_ > i_243_ && i_247_ < i_243_ + i_245_;
    }
    
    public boolean over(Image image, int i, int i_248_, int i_249_, int i_250_) {
        int i_251_ = image.getHeight(ob);
        int i_252_ = image.getWidth(ob);
        return i > i_249_ - 5 && i < i_249_ + i_252_ + 5 && i_248_ > i_250_ - 5 && i_248_ < i_250_ + i_251_ + 5;
    }
    
    public void fleximage(Image image, int i, int i_253_) {
        if (!badmac) {
            if (i == 0) {
                flexpix = new int[360000];
                PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, flexpix, 0, 800);
                try {
                    pixelgrabber.grabPixels();
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
            }
            int i_254_ = 0;
            int i_255_ = 0;
            int i_256_ = 0;
            int i_257_ = 0;
            int i_258_ = (int) (Math.random() * 128.0);
            int i_259_ = (int) (5.0 + Math.random() * 15.0);
            for (int i_260_ = 0; i_260_ < 360000; i_260_++) {
                Color color = new Color(flexpix[i_260_]);
                int i_263_;
                int i_264_;
                int i_265_;
                if (i_254_ == 0) {
                    i_263_ = color.getRed();
                    i_255_ = i_263_;
                    i_264_ = color.getGreen();
                    i_256_ = i_264_;
                    i_265_ = color.getBlue();
                    i_257_ = i_265_;
                } else {
                    i_263_ = (int) (((float) color.getRed() + (float) i_255_ * 0.38F * (float) i) / (1.0F + 0.38F * (float) i));
                    i_255_ = i_263_;
                    i_264_ = (int) (((float) color.getGreen() + (float) i_256_ * 0.38F * (float) i) / (1.0F + 0.38F * (float) i));
                    i_256_ = i_264_;
                    i_265_ = (int) (((float) color.getBlue() + (float) i_257_ * 0.38F * (float) i) / (1.0F + 0.38F * (float) i));
                    i_257_ = i_265_;
                }
                if (++i_254_ == 800)
                    i_254_ = 0;
                int i_266_ = (int) ((float) (i_263_ * 17 + i_264_ + i_265_ + i_258_) / 21.0F);
                int i_267_ = (int) ((float) (i_264_ * 17 + i_263_ + i_265_ + i_258_) / 22.0F);
                int i_268_ = (int) ((float) (i_265_ * 17 + i_263_ + i_264_ + i_258_) / 24.0F);
                if (--i_259_ == 0) {
                    i_258_ = (int) (Math.random() * 128.0);
                    i_259_ = (int) (5.0 + Math.random() * 15.0);
                }
                Color color_269_ = new Color(i_266_, i_267_, i_268_);
                flexpix[i_260_] = color_269_.getRGB();
            }
            fleximg = createImage(new MemoryImageSource(800, 450, flexpix, 0, 800));
            rd.drawImage(fleximg, 0, 0, null);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(0, 0, 800, 450);
        }
    }
    
    private Image loadsnap(Image image) {
        int i = image.getHeight(ob);
        int i_270_ = image.getWidth(ob);
        int[] is = new int[i_270_ * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_270_, i, is, 0, i_270_);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        for (int i_271_ = 0; i_271_ < i_270_ * i; i_271_++) {
            Color color = new Color(is[i_270_ * i - 1]);
            Color color_272_ = new Color(is[i_271_]);
            if (color_272_.getRed() != color_272_.getGreen() && color_272_.getGreen() != color_272_.getBlue()) {
                int i_273_ = (int) ((float) color_272_.getRed() + (float) color_272_.getRed() * ((float) (m).snap[0] / 100.0F));
                if (i_273_ > 255)
                    i_273_ = 255;
                if (i_273_ < 0)
                    i_273_ = 0;
                int i_274_ = (int) ((float) color_272_.getGreen() + (float) color_272_.getGreen() * ((float) (m).snap[1] / 100.0F));
                if (i_274_ > 255)
                    i_274_ = 255;
                if (i_274_ < 0)
                    i_274_ = 0;
                int i_275_ = (int) ((float) color_272_.getBlue() + (float) color_272_.getBlue() * ((float) (m).snap[2] / 100.0F));
                if (i_275_ > 255)
                    i_275_ = 255;
                if (i_275_ < 0)
                    i_275_ = 0;
                is[i_271_] = ~0xffffff | i_273_ << 16 | i_274_ << 8 | i_275_;
            } else {
                int i_276_ = (int) ((float) (color.getRed() - color_272_.getRed()) / (float) color.getRed() * 255.0F);
                if (i_276_ > 255)
                    i_276_ = 255;
                if (i_276_ < 0)
                    i_276_ = 0;
                is[i_271_] = i_276_ << 24 | 0x0 | 0x0 | 0x0;
            }
        }
        BufferedImage bufferedimage = new BufferedImage(i_270_, i, 2);
        bufferedimage.setRGB(0, 0, i_270_, i, is, 0, i_270_);
        return bufferedimage;
    }
    
    private Image loadopsnap(Image image, int i, int i_277_) {
        int i_278_ = image.getHeight(ob);
        int i_279_ = image.getWidth(ob);
        int[] is = new int[i_279_ * i_278_];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_279_, i_278_, is, 0, i_279_);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        if (i < 0)
            i = 33;
        int i_280_ = 0;
        if (i_277_ == 1)
            i_280_ = is[61993];
        int[] is_281_ = { (m).snap[0], (m).snap[1], (m).snap[2] };
        while (is_281_[0] + is_281_[1] + is_281_[2] < -30) {
            for (int i_282_ = 0; i_282_ < 3; i_282_++) {
                if (is_281_[i_282_] < 50)
                    is_281_[i_282_]++;
            }
        }
        for (int i_283_ = 0; i_283_ < i_279_ * i_278_; i_283_++) {
            if (is[i_283_] != is[i_277_]) {
                Color color = new Color(is[i_283_]);
                int i_286_;
                int i_287_;
                int i_288_;
                if (i_277_ == 1 && is[i_283_] == i_280_) {
                    i_286_ = (int) (237.0F - 237.0F * ((float) is_281_[0] / 150.0F));
                    if (i_286_ > 255)
                        i_286_ = 255;
                    if (i_286_ < 0)
                        i_286_ = 0;
                    i_287_ = (int) (237.0F - 237.0F * ((float) is_281_[1] / 150.0F));
                    if (i_287_ > 255)
                        i_287_ = 255;
                    if (i_287_ < 0)
                        i_287_ = 0;
                    i_288_ = (int) (237.0F - 237.0F * ((float) is_281_[2] / 150.0F));
                    if (i_288_ > 255)
                        i_288_ = 255;
                    if (i_288_ < 0)
                        i_288_ = 0;
                    if (i == 11) {
                        i_286_ = 250;
                        i_287_ = 250;
                        i_288_ = 250;
                    }
                } else {
                    i_286_ = (int) ((float) color.getRed() - (float) color.getRed() * ((float) is_281_[0] / 100.0F));
                    if (i_286_ > 255)
                        i_286_ = 255;
                    if (i_286_ < 0)
                        i_286_ = 0;
                    i_287_ = (int) ((float) color.getGreen() - (float) color.getGreen() * ((float) is_281_[1] / 100.0F));
                    if (i_287_ > 255)
                        i_287_ = 255;
                    if (i_287_ < 0)
                        i_287_ = 0;
                    i_288_ = (int) ((float) color.getBlue() - (float) color.getBlue() * ((float) is_281_[2] / 100.0F));
                    if (i_288_ > 255)
                        i_288_ = 255;
                    if (i_288_ < 0)
                        i_288_ = 0;
                }
                Color color_289_ = new Color(i_286_, i_287_, i_288_);
                is[i_283_] = color_289_.getRGB();
            }
        }
        Image image_290_ = createImage(new MemoryImageSource(i_279_, i_278_, is, 0, i_279_));
        return image_290_;
    }
    
    private Image pressed(Image image) {
        int i = image.getHeight(ob);
        int i_291_ = image.getWidth(ob);
        int[] is = new int[i_291_ * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_291_, i, is, 0, i_291_);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        for (int i_292_ = 0; i_292_ < i_291_ * i; i_292_++) {
            if (is[i_292_] != is[i_291_ * i - 1])
                is[i_292_] = -16777216;
        }
        Image image_293_ = createImage(new MemoryImageSource(i_291_, i, is, 0, i_291_));
        return image_293_;
    }
    
    private Image bressed(Image image) {
        int i = image.getHeight(ob);
        int i_294_ = image.getWidth(ob);
        int[] is = new int[i_294_ * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_294_, i, is, 0, i_294_);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        Color color = new Color(247, 255, 165);
        for (int i_295_ = 0; i_295_ < i_294_ * i; i_295_++) {
            if (is[i_295_] != is[i_294_ * i - 1])
                is[i_295_] = color.getRGB();
        }
        Image image_296_ = createImage(new MemoryImageSource(i_294_, i, is, 0, i_294_));
        return image_296_;
    }
    
    public void pauseimage(Image image) {
        if (!badmac) {
            int[] is = new int[360000];
            PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, is, 0, 800);
            try {
                pixelgrabber.grabPixels();
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
            int i = 0;
            int i_297_ = 0;
            int i_298_ = 0;
            int i_299_ = 0;
            for (int i_300_ = 0; i_300_ < 360000; i_300_++) {
                Color color = new Color(is[i_300_]);
                int i_301_;
                if (i_299_ == 0) {
                    i_301_ = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                    i_298_ = i_301_;
                } else {
                    i_301_ = (color.getRed() + color.getGreen() + color.getBlue() + i_298_ * 30) / 33;
                    i_298_ = i_301_;
                }
                if (++i_299_ == 800)
                    i_299_ = 0;
                if (i_300_ > 800 * (8 + i_297_) + 281 && i_297_ < 188) {
                    int i_302_ = (i_301_ + 60) / 3;
                    int i_303_ = (i_301_ + 135) / 3;
                    int i_304_ = (i_301_ + 220) / 3;
                    if (++i == 237) {
                        i_297_++;
                        i = 0;
                    }
                    Color color_305_ = new Color(i_302_, i_303_, i_304_);
                    is[i_300_] = color_305_.getRGB();
                } else {
                    Color color_306_ = new Color(i_301_, i_301_, i_301_);
                    is[i_300_] = color_306_.getRGB();
                }
            }
            fleximg = createImage(new MemoryImageSource(800, 450, is, 0, 800));
            rd.drawImage(fleximg, 0, 0, null);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(0, 0, 800, 450);
        }
    }
    
    public void jflexo() {
        if (!badmac) {
            int[] is = new int[268000];
            PixelGrabber pixelgrabber = new PixelGrabber((app).offImage, 65, 25, 670, 400, is, 0, 670);
            try {
                pixelgrabber.grabPixels();
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
            int i = 0;
            int i_307_ = 0;
            int i_308_ = 0;
            int i_309_ = 0;
            for (int i_310_ = 0; i_310_ < 268000; i_310_++) {
                Color color = new Color(is[i_310_]);
                int i_313_;
                int i_314_;
                int i_315_;
                if (i_309_ == 0) {
                    i_313_ = color.getRed();
                    i = i_313_;
                    i_314_ = color.getGreen();
                    i_308_ = i_314_;
                    i_315_ = color.getBlue();
                    i_307_ = i_315_;
                } else {
                    i_313_ = (color.getRed() + i * 10) / 11;
                    i = i_313_;
                    i_314_ = (color.getGreen() + i_308_ * 10) / 11;
                    i_308_ = i_314_;
                    i_315_ = (color.getBlue() + i_307_ * 10) / 11;
                    i_307_ = i_315_;
                }
                if (++i_309_ == 670)
                    i_309_ = 0;
                Color color_316_ = new Color(i_313_, i_314_, i_315_);
                is[i_310_] = color_316_.getRGB();
            }
            Image image = createImage(new MemoryImageSource(670, 400, is, 0, 670));
            rd.drawImage(image, 65, 25, null);
        } else {
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(0, 0, 670, 400);
        }
    }
    
    public Image getImage(String string) {
        Image image = Toolkit.getDefaultToolkit().createImage(string);
        MediaTracker mediatracker = new MediaTracker(app);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception exception) {
            /* empty */
        }
        return image;
    }
    
    private Image loadimage(byte[] is, MediaTracker mediatracker, Toolkit toolkit) {
        Image image = toolkit.createImage(is);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception exception) {
            /* empty */
        }
        return image;
    }
    
    private Image loadude(byte[] is, MediaTracker mediatracker, Toolkit toolkit) {
        Image image = toolkit.createImage(is);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception exception) {
            /* empty */
        }
        int i = image.getHeight(ob);
        int i_317_ = image.getWidth(ob);
        int[] is_318_ = new int[i_317_ * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_317_, i, is_318_, 0, i_317_);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        for (int i_319_ = 0; i_319_ < i_317_ * i; i_319_++) {
            Color color = new Color(is_318_[i_319_]);
            if (color.getGreen() > color.getRed() && color.getGreen() > color.getBlue()) {
                int i_320_ = (int) (255.0F - (float) (color.getGreen() - (color.getRed() + color.getBlue()) / 2) * 1.5F);
                if (i_320_ > 255)
                    i_320_ = 255;
                if (i_320_ < 0)
                    i_320_ = 0;
                is_318_[i_319_] = i_320_ << 24 | 0x0 | 0x0 | 0x0;
            }
        }
        BufferedImage bufferedimage = new BufferedImage(i_317_, i, 2);
        bufferedimage.setRGB(0, 0, i_317_, i, is_318_, 0, i_317_);
        return bufferedimage;
    }
    
    private Image loadBimage(byte[] is, MediaTracker mediatracker, Toolkit toolkit, int i) {
        Image image = toolkit.createImage(is);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception exception) {
            /* empty */
        }
        int i_321_ = image.getHeight(ob);
        int i_322_ = image.getWidth(ob);
        int[] is_323_ = new int[i_322_ * i_321_];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_322_, i_321_, is_323_, 0, i_322_);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        for (int i_324_ = 0; i_324_ < i_322_ * i_321_; i_324_++) {
            if (is_323_[i_324_] != is_323_[0] || i != 0) {
                Color color = new Color(is_323_[i_324_]);
                float[] fs = new float[3];
                Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
                fs[0] = 0.12F;
                fs[1] = 0.45F;
                if (i == 3) {
                    fs[0] = 0.13F;
                    fs[1] = 0.45F;
                }
                Color color_325_ = Color.getHSBColor(fs[0], fs[1], fs[2]);
                is_323_[i_324_] = color_325_.getRGB();
            }
        }
        if (i == 2) {
            Color color = new Color(is_323_[0]);
            int i_326_ = 0x40000000 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
            color = new Color(is_323_[1]);
            int i_327_ = ~0x7fffffff | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
            for (int i_328_ = 2; i_328_ < i_322_ * i_321_; i_328_++) {
                if (is_323_[i_328_] == is_323_[0])
                    is_323_[i_328_] = i_326_;
                if (is_323_[i_328_] == is_323_[1])
                    is_323_[i_328_] = i_327_;
            }
            is_323_[0] = i_326_;
            is_323_[1] = i_327_;
        }
        Image image_329_;
        if (i == 2) {
            BufferedImage bufferedimage = new BufferedImage(i_322_, i_321_, 2);
            bufferedimage.setRGB(0, 0, i_322_, i_321_, is_323_, 0, i_322_);
            image_329_ = bufferedimage;
        } else
            image_329_ = createImage(new MemoryImageSource(i_322_, i_321_, is_323_, 0, i_322_));
        return image_329_;
    }
    
    private Image dodgen(Image image) {
        int i = image.getHeight(ob);
        int i_331_ = image.getWidth(ob);
        int[] is = new int[i_331_ * i];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_331_, i, is, 0, i_331_);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        for (int i_332_ = 0; i_332_ < i_331_ * i; i_332_++) {
            Color color = new Color(is[i_332_]);
            int i_333_ = color.getRed() * 4 + 90;
            if (i_333_ > 255)
                i_333_ = 255;
            if (i_333_ < 0)
                i_333_ = 0;
            int i_334_ = color.getGreen() * 4 + 90;
            if (i_334_ > 255)
                i_334_ = 255;
            if (i_334_ < 0)
                i_334_ = 0;
            int i_335_ = color.getBlue() * 4 + 90;
            if (i_335_ > 255)
                i_335_ = 255;
            if (i_335_ < 0)
                i_335_ = 0;
            Color color_336_ = new Color(i_333_, i_334_, i_335_);
            is[i_332_] = color_336_.getRGB();
        }
        Image image_337_ = createImage(new MemoryImageSource(i_331_, i, is, 0, i_331_));
        return image_337_;
    }
    
    private void smokeypix(byte[] is, MediaTracker mediatracker, Toolkit toolkit) {
        Image image = toolkit.createImage(is);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception exception) {
            /* empty */
        }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, smokey, 0, 466);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        for (int i = 0; i < 94132; i++) {
            if (smokey[i] != smokey[0]) {
                Color color = new Color(smokey[i]);
                float[] fs = new float[3];
                Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
                fs[0] = 0.11F;
                fs[1] = 0.45F;
                Color color_338_ = Color.getHSBColor(fs[0], fs[1], fs[2]);
                smokey[i] = color_338_.getRGB();
            }
        }
    }
    
    private void makecarsbgc(Image image, Image image_339_) {
        int[] is = new int[268000];
        PixelGrabber pixelgrabber = new PixelGrabber(carsbg, 0, 0, 670, 400, is, 0, 670);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        int[] is_340_ = new int[20700];
        PixelGrabber pixelgrabber_341_ = new PixelGrabber(image, 0, 0, 92, 225, is_340_, 0, 92);
        try {
            pixelgrabber_341_.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        int[] is_342_ = new int[2112];
        PixelGrabber pixelgrabber_343_ = new PixelGrabber(image_339_, 0, 0, 88, 24, is_342_, 0, 88);
        try {
            pixelgrabber_343_.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        for (int i = 0; i < 670; i++) {
            for (int i_344_ = 0; i_344_ < 400; i_344_++) {
                if (i > 14 && i < 106 && i_344_ > 11 && i_344_ < 236 && is_340_[i - 14 + (i_344_ - 11) * 92] != is_340_[0]) {
                    Color color = new Color(is[i + i_344_ * 670]);
                    Color color_345_ = new Color(is_340_[i - 14 + (i_344_ - 11) * 92]);
                    int i_346_ = (int) ((double) color.getRed() * 0.33 + (double) color_345_.getRed() * 0.67);
                    if (i_346_ > 255)
                        i_346_ = 255;
                    if (i_346_ < 0)
                        i_346_ = 0;
                    int i_347_ = (int) ((double) color.getGreen() * 0.33 + (double) color_345_.getGreen() * 0.67);
                    if (i_347_ > 255)
                        i_347_ = 255;
                    if (i_347_ < 0)
                        i_347_ = 0;
                    int i_348_ = (int) ((double) color.getBlue() * 0.33 + (double) color_345_.getBlue() * 0.67);
                    if (i_348_ > 255)
                        i_348_ = 255;
                    if (i_348_ < 0)
                        i_348_ = 0;
                    Color color_349_ = new Color(i_346_, i_347_, i_348_);
                    is[i + i_344_ * 670] = color_349_.getRGB();
                }
                if (i > 564 && i < 656 && i_344_ > 11 && i_344_ < 236 && is_340_[i - 564 + (i_344_ - 11) * 92] != is_340_[0]) {
                    Color color = new Color(is[i + i_344_ * 670]);
                    Color color_350_ = new Color(is_340_[i - 564 + (i_344_ - 11) * 92]);
                    int i_351_ = (int) ((double) color.getRed() * 0.33 + (double) color_350_.getRed() * 0.67);
                    if (i_351_ > 255)
                        i_351_ = 255;
                    if (i_351_ < 0)
                        i_351_ = 0;
                    int i_352_ = (int) ((double) color.getGreen() * 0.33 + (double) color_350_.getGreen() * 0.67);
                    if (i_352_ > 255)
                        i_352_ = 255;
                    if (i_352_ < 0)
                        i_352_ = 0;
                    int i_353_ = (int) ((double) color.getBlue() * 0.33 + (double) color_350_.getBlue() * 0.67);
                    if (i_353_ > 255)
                        i_353_ = 255;
                    if (i_353_ < 0)
                        i_353_ = 0;
                    Color color_354_ = new Color(i_351_, i_352_, i_353_);
                    is[i + i_344_ * 670] = color_354_.getRGB();
                }
                if (i > 440 && i < 528 && i_344_ > 53 && i_344_ < 77 && is_342_[i - 440 + (i_344_ - 53) * 88] != is_342_[0]) {
                    Color color = new Color(is[i + i_344_ * 670]);
                    Color color_355_ = new Color(is_342_[i - 440 + (i_344_ - 53) * 88]);
                    int i_356_ = (int) ((double) color.getRed() * 0.33 + (double) color_355_.getRed() * 0.67);
                    if (i_356_ > 255)
                        i_356_ = 255;
                    if (i_356_ < 0)
                        i_356_ = 0;
                    int i_357_ = (int) ((double) color.getGreen() * 0.33 + (double) color_355_.getGreen() * 0.67);
                    if (i_357_ > 255)
                        i_357_ = 255;
                    if (i_357_ < 0)
                        i_357_ = 0;
                    int i_358_ = (int) ((double) color.getBlue() * 0.33 + (double) color_355_.getBlue() * 0.67);
                    if (i_358_ > 255)
                        i_358_ = 255;
                    if (i_358_ < 0)
                        i_358_ = 0;
                    Color color_359_ = new Color(i_356_, i_357_, i_358_);
                    is[i + i_344_ * 670] = color_359_.getRGB();
                }
            }
        }
        carsbgc = createImage(new MemoryImageSource(670, 400, is, 0, 670));
    }
    
    public void carsbginflex() {
        flatr = 0;
        flyr = (int) (m.random() * 160.0F - 80.0F);
        flyrdest = (int) ((float) flyr + m.random() * 160.0F - 80.0F);
        flang = 1;
        flexpix = new int[268000];
        PixelGrabber pixelgrabber = new PixelGrabber(carsbg, 0, 0, 670, 400, flexpix, 0, 670);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
    }
    
    public void drawSmokeCarsbg() {
        if (Math.abs(flyr - flyrdest) > 20) {
            if (flyr > flyrdest)
                flyr -= 20;
            else
                flyr += 20;
        } else {
            flyr = flyrdest;
            flyrdest = (int) ((float) flyr + m.random() * 160.0F - 80.0F);
        }
        if (flyr > 160)
            flyr = 160;
        if (flatr > 170) {
            flatrstart++;
            flatr = flatrstart * 3;
            flyr = (int) (m.random() * 160.0F - 80.0F);
            flyrdest = (int) ((float) flyr + m.random() * 160.0F - 80.0F);
            flang = 1;
        }
        for (int i = 0; i < 466; i++) {
            for (int i_360_ = 0; i_360_ < 202; i_360_++) {
                if (smokey[i + i_360_ * 466] != smokey[0]) {
                    float f = pys(i, 233, i_360_, flyr);
                    int i_361_ = (int) ((float) (i - 233) / f * (float) flatr);
                    int i_362_ = (int) ((float) (i_360_ - flyr) / f * (float) flatr);
                    int i_363_ = i + i_361_ + 100 + (i_360_ + i_362_ + 110) * 670;
                    if (i + i_361_ + 100 < 670 && i + i_361_ + 100 > 0 && i_360_ + i_362_ + 110 < 400 && i_360_ + i_362_ + 110 > 0 && i_363_ < 268000 && i_363_ >= 0) {
                        Color color = new Color(flexpix[i_363_]);
                        Color color_364_ = new Color(smokey[i + i_360_ * 466]);
                        float f_365_ = (255.0F - (float) color_364_.getRed()) / 255.0F;
                        float f_366_ = (255.0F - (float) color_364_.getGreen()) / 255.0F;
                        float f_367_ = (255.0F - (float) color_364_.getBlue()) / 255.0F;
                        int i_368_ = (int) (((float) color.getRed() * ((float) flang * f_365_) + (float) color_364_.getRed() * (1.0F - f_365_)) / ((float) flang * f_365_ + (1.0F - f_365_)));
                        int i_369_ = (int) (((float) color.getGreen() * ((float) flang * f_366_) + (float) color_364_.getGreen() * (1.0F - f_366_)) / ((float) flang * f_366_ + (1.0F - f_366_)));
                        int i_370_ = (int) (((float) color.getBlue() * ((float) flang * f_367_) + (float) color_364_.getBlue() * (1.0F - f_367_)) / ((float) flang * f_367_ + (1.0F - f_367_)));
                        if (i_368_ > 255)
                            i_368_ = 255;
                        if (i_368_ < 0)
                            i_368_ = 0;
                        if (i_369_ > 255)
                            i_369_ = 255;
                        if (i_369_ < 0)
                            i_369_ = 0;
                        if (i_370_ > 255)
                            i_370_ = 255;
                        if (i_370_ < 0)
                            i_370_ = 0;
                        Color color_371_ = new Color(i_368_, i_369_, i_370_);
                        flexpix[i_363_] = color_371_.getRGB();
                    }
                }
            }
        }
        flang += 2;
        flatr += 10 + flatrstart * 2;
        Image image = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
        rd.drawImage(image, 65, 25, null);
    }
    
    public boolean msgcheck(String string) {
        boolean bool = false;
        string = string.toLowerCase();
        String[] strings = { "fu ", " rape", "slut ", "screw ", "redtube", "fuck", "fuk", "f*ck", "fu*k", "f**k", "ass hole", "asshole", "dick", "dik", "cock", "cok ", "shit", "damn", "sex", "anal", "whore", "bitch", "biatch", "bich", " ass", "bastard", "cunt", "dildo", "fag", "homo", "mothaf", "motherf", "negro", "nigga", "nigger", "pussy", "gay", "homo", "you punk", "i will kill you" };
        for (int i = 0; i < strings.length; i++) {
            if (string.indexOf(strings[i]) != -1)
                bool = true;
        }
        if (string.startsWith("ass "))
            bool = true;
        if (string.equals("ass"))
            bool = true;
        if (string.equals("rape"))
            bool = true;
        if (string.equals("fu"))
            bool = true;
        String string_372_ = "";
        String string_373_ = "";
        int i = 0;
        boolean bool_374_ = false;
        boolean bool_375_;
        for (bool_375_ = false; i < string.length() && !bool_375_; i++) {
            if (!bool_374_) {
                string_372_ = new StringBuilder().append(string_372_).append("").append(string.charAt(i)).toString();
                bool_374_ = true;
            } else {
                bool_374_ = false;
                if (!string_373_.equals("") && !string_373_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
                    bool_375_ = true;
                string_373_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            }
        }
        if (!bool_375_) {
            for (int i_376_ = 0; i_376_ < strings.length; i_376_++) {
                if (string_372_.indexOf(strings[i_376_]) != -1)
                    bool = true;
            }
        }
        string_372_ = "";
        string_373_ = "";
        i = 0;
        bool_374_ = true;
        for (bool_375_ = false; i < string.length() && !bool_375_; i++) {
            if (!bool_374_) {
                string_372_ = new StringBuilder().append(string_372_).append("").append(string.charAt(i)).toString();
                bool_374_ = true;
            } else {
                bool_374_ = false;
                if (!string_373_.equals("") && !string_373_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
                    bool_375_ = true;
                string_373_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            }
        }
        if (!bool_375_) {
            for (int i_377_ = 0; i_377_ < strings.length; i_377_++) {
                if (string_372_.indexOf(strings[i_377_]) != -1)
                    bool = true;
            }
        }
        string_372_ = "";
        string_373_ = "";
        i = 0;
        int i_378_ = 0;
        for (bool_375_ = false; i < string.length() && !bool_375_; i++) {
            if (i_378_ == 0) {
                string_372_ = new StringBuilder().append(string_372_).append("").append(string.charAt(i)).toString();
                i_378_ = 2;
            } else {
                i_378_--;
                if (!string_373_.equals("") && !string_373_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
                    bool_375_ = true;
                string_373_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            }
        }
        if (!bool_375_) {
            for (int i_379_ = 0; i_379_ < strings.length; i_379_++) {
                if (string_372_.indexOf(strings[i_379_]) != -1)
                    bool = true;
            }
        }
        string_372_ = "";
        string_373_ = "";
        i = 0;
        i_378_ = 1;
        for (bool_375_ = false; i < string.length() && !bool_375_; i++) {
            if (i_378_ == 0) {
                string_372_ = new StringBuilder().append(string_372_).append("").append(string.charAt(i)).toString();
                i_378_ = 2;
            } else {
                i_378_--;
                if (!string_373_.equals("") && !string_373_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
                    bool_375_ = true;
                string_373_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            }
        }
        if (!bool_375_) {
            for (int i_380_ = 0; i_380_ < strings.length; i_380_++) {
                if (string_372_.indexOf(strings[i_380_]) != -1)
                    bool = true;
            }
        }
        string_372_ = "";
        string_373_ = "";
        i = 0;
        i_378_ = 2;
        for (bool_375_ = false; i < string.length() && !bool_375_; i++) {
            if (i_378_ == 0) {
                string_372_ = new StringBuilder().append(string_372_).append("").append(string.charAt(i)).toString();
                i_378_ = 2;
            } else {
                i_378_--;
                if (!string_373_.equals("") && !string_373_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
                    bool_375_ = true;
                string_373_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            }
        }
        if (!bool_375_) {
            for (int i_381_ = 0; i_381_ < strings.length; i_381_++) {
                if (string_372_.indexOf(strings[i_381_]) != -1)
                    bool = true;
            }
        }
        return bool;
    }
    
    public boolean drawcarb(boolean bool, Image image, String string, int i, int i_382_, int i_383_, int i_384_, boolean bool_385_) {
        boolean bool_386_ = false;
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        int i_388_;
        if (bool) {
            i_388_ = ftm.stringWidth(string);
            if (string.startsWith("Class"))
                i_388_ = 112;
        } else
            i_388_ = image.getWidth(ob);
        int i_389_ = 0;
        if (i_383_ > i && i_383_ < i + i_388_ + 14 && i_384_ > i_382_ && i_384_ < i_382_ + 28) {
            i_389_ = 1;
            if (bool_385_)
                bool_386_ = true;
        }
        if (cfase != 11) {
            if (bool && string.equals(" Top 20 Lists ") && i_389_ == 0)
                rd.setComposite(AlphaComposite.getInstance(3, 0.67F));
            if (bool && string.equals(" Top 20 Lists ") && i_389_ == 1)
                rd.setComposite(AlphaComposite.getInstance(3, 0.9F));
        }
        rd.drawImage(bcl[i_389_], i, i_382_, null);
        rd.drawImage(bc[i_389_], i + 4, i_382_, i_388_ + 6, 28, null);
        rd.drawImage(bcr[i_389_], i + i_388_ + 10, i_382_, null);
        if (bool) {
            if (string.equals("X") && i_389_ == 1)
                rd.setColor(new Color(255, 0, 0));
            else
                rd.setColor(new Color(0, 0, 0));
            if (string.startsWith("Class"))
                rd.drawString(string, 400 - ftm.stringWidth(string) / 2, i_382_ + 19);
            else
                rd.drawString(string, i + 7, i_382_ + 19);
        } else
            rd.drawImage(image, i + 7, i_382_ + 7, null);
        if (bool && string.equals(" Top 20 Lists "))
            rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        return bool_386_;
    }
    
    public void drawWarning() {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 800, 450);
        rd.setFont(new Font("Arial", 1, 22));
        ftm = rd.getFontMetrics();
        drawcs(100, "Warning!", 255, 0, 0, 3);
        rd.setFont(new Font("Arial", 1, 18));
        ftm = rd.getFontMetrics();
        drawcs(150, "Bad language and flooding is strictly prohibited in this game!", 255, 255, 255, 3);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        if (warning < 210)
            drawcs(200, "If you continue typing bad language or flooding your game will shut down.", 200, 200, 200, 3);
        if (warning > 210)
            drawcs(200, "Sorry. This was your second warring your game has shut down.", 200, 200, 200, 3);
        if (warning > 250) {
            stopallnow();
            runtyp = 0;
            app.repaint();
            (app).gamer.stop();
        }
    }
    
    public int getvalue(String string, int i) {
        int i_390_ = -1;
        try {
            int i_391_ = 0;
            int i_392_ = 0;
            int i_393_ = 0;
            String string_394_ = "";
            String string_395_ = "";
            for (/**/; i_391_ < string.length() && i_393_ != 2; i_391_++) {
                string_394_ = new StringBuilder().append("").append(string.charAt(i_391_)).toString();
                if (string_394_.equals("|")) {
                    i_392_++;
                    if (i_393_ == 1 || i_392_ > i)
                        i_393_ = 2;
                } else if (i_392_ == i) {
                    string_395_ = new StringBuilder().append(string_395_).append(string_394_).toString();
                    i_393_ = 1;
                }
            }
            if (string_395_.equals(""))
                string_395_ = "-1";
            i_390_ = Integer.valueOf(string_395_).intValue();
        } catch (Exception exception) {
            /* empty */
        }
        return i_390_;
    }
    
    public String getSvalue(String string, int i) {
        String string_396_ = "";
        try {
            int i_397_ = 0;
            int i_398_ = 0;
            int i_399_ = 0;
            String string_400_ = "";
            String string_401_ = "";
            for (/**/; i_397_ < string.length() && i_399_ != 2; i_397_++) {
                string_400_ = new StringBuilder().append("").append(string.charAt(i_397_)).toString();
                if (string_400_.equals("|")) {
                    i_398_++;
                    if (i_399_ == 1 || i_398_ > i)
                        i_399_ = 2;
                } else if (i_398_ == i) {
                    string_401_ = new StringBuilder().append(string_401_).append(string_400_).toString();
                    i_399_ = 1;
                }
            }
            string_396_ = string_401_;
        } catch (Exception exception) {
            /* empty */
        }
        return string_396_;
    }
}
