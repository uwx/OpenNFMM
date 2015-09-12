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
        this.m = medium;
        this.cd = cardefine;
        this.app = gamesparker;
        this.rd = graphics2d;
        this.hello = getImage("data/hello.gif");
        this.sign = getImage("data/sign.gif");
        this.loadbar = getImage("data/loadbar.gif");
        for (int i = 0; i < 5; i++)
            this.pengs[i] = false;
        this.nofull = false;
        SecurityManager securitymanager = System.getSecurityManager();
        if (securitymanager != null) {
            try {
                securitymanager.checkConnect("needformadness.com", -1);
            } catch (Exception exception) {
                String string = new StringBuilder().append("").append(exception).toString();
                if (string.indexOf("access denied") != -1)
                    this.nofull = true;
            }
        }
        this.macn = false;
        this.badmac = false;
        if (System.getProperty("os.name").indexOf("Mac") != -1)
            this.macn = true;
        if (this.macn) {
            String string = System.getProperty("os.version");
            if (string.startsWith("10.5") || string.startsWith("10.4") || string.startsWith("10.3") || string.startsWith("10.2"))
                this.badmac = true;
        }
    }
    
    public void loaddata() {
        this.kbload = 637;
        this.runtyp = 176;
        this.runner = new Thread(this);
        this.runner.start();
        loadimages();
        this.intertrack = new RadicalMod("music/interface.zip");
        this.dnload += 44;
        loadsounds();
    }
    
    public void loadsounds() {
        this.dnload += 3;
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
                            this.engs[i_3_][i_2_] = new soundClip(is);
                    }
                }
                for (int i_4_ = 0; i_4_ < 6; i_4_++) {
                    if (string.equals(new StringBuilder().append("air").append(i_4_).append(".wav").toString()))
                        this.air[i_4_] = new soundClip(is);
                }
                for (int i_5_ = 0; i_5_ < 3; i_5_++) {
                    if (string.equals(new StringBuilder().append("crash").append(i_5_ + 1).append(".wav").toString()))
                        this.crash[i_5_] = new soundClip(is);
                }
                for (int i_6_ = 0; i_6_ < 3; i_6_++) {
                    if (string.equals(new StringBuilder().append("lowcrash").append(i_6_ + 1).append(".wav").toString()))
                        this.lowcrash[i_6_] = new soundClip(is);
                }
                for (int i_7_ = 0; i_7_ < 3; i_7_++) {
                    if (string.equals(new StringBuilder().append("skid").append(i_7_ + 1).append(".wav").toString()))
                        this.skid[i_7_] = new soundClip(is);
                }
                for (int i_8_ = 0; i_8_ < 3; i_8_++) {
                    if (string.equals(new StringBuilder().append("dustskid").append(i_8_ + 1).append(".wav").toString()))
                        this.dustskid[i_8_] = new soundClip(is);
                }
                for (int i_9_ = 0; i_9_ < 3; i_9_++) {
                    if (string.equals(new StringBuilder().append("scrape").append(i_9_ + 1).append(".wav").toString())) {
                        this.scrape[i_9_] = new soundClip(is);
                        if (i_9_ == 2)
                            this.scrape[3] = new soundClip(is);
                    }
                }
                if (string.equals("powerup.wav"))
                    this.powerup = new soundClip(is);
                if (string.equals("tires.wav"))
                    this.tires = new soundClip(is);
                if (string.equals("checkpoint.wav"))
                    this.checkpoint = new soundClip(is);
                if (string.equals("carfixed.wav"))
                    this.carfixed = new soundClip(is);
                if (string.equals("three.wav"))
                    this.three = new soundClip(is);
                if (string.equals("two.wav"))
                    this.two = new soundClip(is);
                if (string.equals("one.wav"))
                    this.one = new soundClip(is);
                if (string.equals("go.wav"))
                    this.go = new soundClip(is);
                if (string.equals("wasted.wav"))
                    this.wastd = new soundClip(is);
                if (string.equals("firewasted.wav"))
                    this.firewasted = new soundClip(is);
                this.dnload += 5;
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
        MediaTracker mediatracker = new MediaTracker(this.app);
        Image image = null;
        Image image_10_ = null;
        this.dnload += 8;
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
                    this.carsbg = loadBimage(is, mediatracker, toolkit, 1);
                if (string.equals("color.gif"))
                    image = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("class.gif"))
                    image_10_ = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("smokey.gif"))
                    smokeypix(is, mediatracker, toolkit);
                if (string.equals("1.gif"))
                    this.orank[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("gameh.gif"))
                    this.ogameh = loadimage(is, mediatracker, toolkit);
                if (string.equals("wgame.gif"))
                    this.owgame = loadimage(is, mediatracker, toolkit);
                if (string.equals("gameov.gif"))
                    this.gameov = loadimage(is, mediatracker, toolkit);
                if (string.equals("lap.gif"))
                    this.olap = loadimage(is, mediatracker, toolkit);
                if (string.equals("paused.gif"))
                    this.paused = loadimage(is, mediatracker, toolkit);
                if (string.equals("select.gif"))
                    this.select = loadimage(is, mediatracker, toolkit);
                if (string.equals("yourwasted.gif"))
                    this.oyourwasted = loadimage(is, mediatracker, toolkit);
                if (string.equals("disco.gif"))
                    this.odisco = loadimage(is, mediatracker, toolkit);
                if (string.equals("youwastedem.gif"))
                    this.oyouwastedem = loadimage(is, mediatracker, toolkit);
                if (string.equals("gamefinished.gif"))
                    this.ogamefinished = loadimage(is, mediatracker, toolkit);
                if (string.equals("exitgame.gif"))
                    this.oexitgame = loadimage(is, mediatracker, toolkit);
                if (string.equals("pgate.gif"))
                    this.pgate = loadimage(is, mediatracker, toolkit);
                if (string.equals("d1.gif"))
                    this.dude[0] = loadude(is, mediatracker, toolkit);
                if (string.equals("d2.gif"))
                    this.dude[1] = loadude(is, mediatracker, toolkit);
                if (string.equals("d3.gif"))
                    this.dude[2] = loadude(is, mediatracker, toolkit);
                if (string.equals("float.gif"))
                    this.oflaot = loadimage(is, mediatracker, toolkit);
                if (string.equals("1c.gif"))
                    this.ocntdn[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("2c.gif"))
                    this.ocntdn[2] = loadimage(is, mediatracker, toolkit);
                if (string.equals("3c.gif"))
                    this.ocntdn[3] = loadimage(is, mediatracker, toolkit);
                if (string.equals("2.gif"))
                    this.orank[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("3.gif"))
                    this.orank[2] = loadimage(is, mediatracker, toolkit);
                if (string.equals("4.gif"))
                    this.orank[3] = loadimage(is, mediatracker, toolkit);
                if (string.equals("5.gif"))
                    this.orank[4] = loadimage(is, mediatracker, toolkit);
                if (string.equals("6.gif"))
                    this.orank[5] = loadimage(is, mediatracker, toolkit);
                if (string.equals("7.gif"))
                    this.orank[6] = loadimage(is, mediatracker, toolkit);
                if (string.equals("bgmain.jpg"))
                    this.bgmain = loadBimage(is, mediatracker, toolkit, 2);
                if (string.equals("br.gif"))
                    this.br = loadimage(is, mediatracker, toolkit);
                if (string.equals("loadingmusic.gif"))
                    this.oloadingmusic = loadimage(is, mediatracker, toolkit);
                if (string.equals("radicalplay.gif"))
                    this.radicalplay = loadimage(is, mediatracker, toolkit);
                if (string.equals("back.gif")) {
                    this.back[0] = loadimage(is, mediatracker, toolkit);
                    this.back[1] = bressed(this.back[0]);
                }
                if (string.equals("continue.gif")) {
                    this.contin[0] = loadimage(is, mediatracker, toolkit);
                    this.contin[1] = bressed(this.contin[0]);
                }
                if (string.equals("next.gif")) {
                    this.next[0] = loadimage(is, mediatracker, toolkit);
                    this.next[1] = bressed(this.next[0]);
                }
                if (string.equals("rpro.gif"))
                    this.rpro = loadimage(is, mediatracker, toolkit);
                if (string.equals("selectcar.gif"))
                    this.selectcar = loadimage(is, mediatracker, toolkit);
                if (string.equals("track.jpg")) {
                    this.trackbg[0] = loadBimage(is, mediatracker, toolkit, 3);
                    this.trackbg[1] = dodgen(this.trackbg[0]);
                }
                if (string.equals("youlost.gif"))
                    this.oyoulost = loadimage(is, mediatracker, toolkit);
                if (string.equals("youwon.gif"))
                    this.oyouwon = loadimage(is, mediatracker, toolkit);
                if (string.equals("0c.gif"))
                    this.ocntdn[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("damage.gif"))
                    this.odmg = loadimage(is, mediatracker, toolkit);
                if (string.equals("power.gif"))
                    this.opwr = loadimage(is, mediatracker, toolkit);
                if (string.equals("position.gif"))
                    this.opos = loadimage(is, mediatracker, toolkit);
                if (string.equals("wasted.gif"))
                    this.owas = loadimage(is, mediatracker, toolkit);
                if (string.equals("start1.gif"))
                    this.ostar[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("start2.gif")) {
                    this.ostar[1] = loadimage(is, mediatracker, toolkit);
                    this.star[2] = pressed(this.ostar[1]);
                }
                if (string.equals("congrad.gif"))
                    this.congrd = loadimage(is, mediatracker, toolkit);
                if (string.equals("statb.gif"))
                    this.statb = loadimage(is, mediatracker, toolkit);
                if (string.equals("statbo.gif"))
                    this.statbo = loadimage(is, mediatracker, toolkit);
                if (string.equals("madness.gif"))
                    this.mdness = loadude(is, mediatracker, toolkit);
                if (string.equals("mrc.gif"))
                    this.mrc = loadimage(is, mediatracker, toolkit);
                if (string.equals("fixhoop.gif"))
                    this.fixhoop = loadimage(is, mediatracker, toolkit);
                if (string.equals("arrow.gif"))
                    this.sarrow = loadimage(is, mediatracker, toolkit);
                if (string.equals("stunts.gif"))
                    this.stunts = loadimage(is, mediatracker, toolkit);
                if (string.equals("racing.gif"))
                    this.racing = loadimage(is, mediatracker, toolkit);
                if (string.equals("wasting.gif"))
                    this.wasting = loadimage(is, mediatracker, toolkit);
                if (string.equals("plus.gif"))
                    this.plus = loadimage(is, mediatracker, toolkit);
                if (string.equals("space.gif"))
                    this.space = loadimage(is, mediatracker, toolkit);
                if (string.equals("arrows.gif"))
                    this.arrows = loadimage(is, mediatracker, toolkit);
                if (string.equals("chil.gif"))
                    this.chil = loadimage(is, mediatracker, toolkit);
                if (string.equals("ory.gif"))
                    this.ory = loadimage(is, mediatracker, toolkit);
                if (string.equals("kz.gif"))
                    this.kz = loadimage(is, mediatracker, toolkit);
                if (string.equals("kx.gif"))
                    this.kx = loadimage(is, mediatracker, toolkit);
                if (string.equals("kv.gif"))
                    this.kv = loadimage(is, mediatracker, toolkit);
                if (string.equals("km.gif"))
                    this.km = loadimage(is, mediatracker, toolkit);
                if (string.equals("kn.gif"))
                    this.kn = loadimage(is, mediatracker, toolkit);
                if (string.equals("kenter.gif"))
                    this.kenter = loadimage(is, mediatracker, toolkit);
                if (string.equals("nfm.gif"))
                    this.nfm = loadimage(is, mediatracker, toolkit);
                if (string.equals("options.gif"))
                    this.opti = loadimage(is, mediatracker, toolkit);
                if (string.equals("options2.gif"))
                    this.opti2 = loadimage(is, mediatracker, toolkit);
                if (string.equals("opback.gif"))
                    this.opback = loadimage(is, mediatracker, toolkit);
                if (string.equals("logocars.gif"))
                    this.logocars = loadimage(is, mediatracker, toolkit);
                if (string.equals("logomadmess.gif"))
                    this.logomadnes = loadimage(is, mediatracker, toolkit);
                if (string.equals("logomadbg.gif"))
                    this.logomadbg = loadimage(is, mediatracker, toolkit);
                if (string.equals("byrd.gif"))
                    this.byrd = loadimage(is, mediatracker, toolkit);
                if (string.equals("byrd2.gif"))
                    this.byrd2 = loadimage(is, mediatracker, toolkit);
                if (string.equals("nfmcoms.gif"))
                    this.nfmcoms = loadimage(is, mediatracker, toolkit);
                if (string.equals("nfmcoms2.gif"))
                    this.nfmcoms2 = loadimage(is, mediatracker, toolkit);
                if (string.equals("nfmcom.gif"))
                    this.nfmcom = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("brit.gif"))
                    this.brt = loadimage(is, mediatracker, toolkit);
                if (string.equals("arn.gif"))
                    this.arn = loadimage(is, mediatracker, toolkit);
                if (string.equals("mload.gif"))
                    this.mload = loadimage(is, mediatracker, toolkit);
                if (string.equals("login.gif"))
                    this.login = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("play.gif"))
                    this.play = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("cancel.gif"))
                    this.cancel = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("multi.gif"))
                    this.multim = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("dome.gif"))
                    this.dome = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("register.gif"))
                    this.register = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("upgrade.gif"))
                    this.upgrade = loadimage(is, mediatracker, toolkit);
                if (string.equals("sdets.gif"))
                    this.sdets = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bob.gif"))
                    this.bob = loadBimage(is, mediatracker, toolkit, 1);
                if (string.equals("bot.gif"))
                    this.bot = loadBimage(is, mediatracker, toolkit, 1);
                if (string.equals("bol.gif"))
                    this.bol = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bolp.gif"))
                    this.bolp = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bor.gif"))
                    this.bor = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("borp.gif"))
                    this.borp = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("logout.gif"))
                    this.logout = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("change.gif"))
                    this.change = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("pln.gif"))
                    this.pln = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("pon.gif"))
                    this.pon = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("filb.gif"))
                    this.filb = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bols.gif"))
                    this.bols = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bolps.gif"))
                    this.bolps = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bors.gif"))
                    this.bors = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("borps.gif"))
                    this.borps = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("games.gif"))
                    this.games = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("exit.gif"))
                    this.exit = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("chat.gif"))
                    this.chat = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("players.gif"))
                    this.players = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("roomp.gif"))
                    this.roomp = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("myfr.gif"))
                    this.myfr = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("mycl.gif"))
                    this.mycl = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("cnmc.gif"))
                    this.cnmc = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("cgame.gif"))
                    this.cgame = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("ccar.gif"))
                    this.ccar = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("lanm.gif"))
                    this.lanm = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("asu.gif"))
                    this.asu = loadimage(is, mediatracker, toolkit);
                if (string.equals("asd.gif"))
                    this.asd = loadimage(is, mediatracker, toolkit);
                if (string.equals("pls.gif"))
                    this.pls = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("sts.gif"))
                    this.sts = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("gmc.gif"))
                    this.gmc = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("stg.gif"))
                    this.stg = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("crd.gif"))
                    this.crd = loadBimage(is, mediatracker, toolkit, 0);
                if (string.equals("bcl.gif"))
                    this.bcl[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("bcr.gif"))
                    this.bcr[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("bc.gif"))
                    this.bc[0] = loadimage(is, mediatracker, toolkit);
                if (string.equals("pbcl.gif"))
                    this.bcl[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("pbcr.gif"))
                    this.bcr[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("pbc.gif"))
                    this.bc[1] = loadimage(is, mediatracker, toolkit);
                if (string.equals("cmc.gif"))
                    this.cmc = loadimage(is, mediatracker, toolkit);
                if (string.equals("myc.gif"))
                    this.myc = loadimage(is, mediatracker, toolkit);
                if (string.equals("gac.gif"))
                    this.gac = loadimage(is, mediatracker, toolkit);
                if (string.equals("yac.gif"))
                    this.yac = loadimage(is, mediatracker, toolkit);
                if (string.equals("ycmc.gif"))
                    this.ycmc = loadimage(is, mediatracker, toolkit);
                this.dnload += 2;
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
        while (this.runtyp > 0) {
            if (this.runtyp >= 1 && this.runtyp <= 140)
                hipnoload(this.runtyp, false);
            if (this.runtyp == 176)
                loading();
            this.app.repaint();
            try {
                if (this.runner != null) {
                    /* empty */
                }
                Thread.sleep(20L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        boolean bool = true;
        while (this.runtyp == -101 && !this.lan) {
            String string = new StringBuilder().append("3|").append(this.playingame).append("|").append(this.updatec).append("|").toString();
            if (this.updatec <= -11) {
                for (int i = 0; i < -this.updatec - 10; i++)
                    string = new StringBuilder().append(string).append("").append(this.cnames[6 - i]).append("|").append(this.sentn[6 - i]).append("|").toString();
                this.updatec = -2;
            }
            String string_13_ = "";
            boolean bool_14_ = false;
            try {
                this.dout.println(string);
                string_13_ = this.din.readLine();
                if (string_13_ == null)
                    bool_14_ = true;
            } catch (Exception exception) {
                bool_14_ = true;
            }
            if (bool_14_) {
                try {
                    this.socket.close();
                    this.socket = null;
                    this.din.close();
                    this.din = null;
                    this.dout.close();
                    this.dout = null;
                } catch (Exception exception) {
                    /* empty */
                }
                try {
                    this.socket = new Socket(this.server, this.servport);
                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                    this.dout.println(string);
                    string_13_ = this.din.readLine();
                    if (string_13_ != null)
                        bool_14_ = false;
                } catch (Exception exception) {
                    /* empty */
                }
            }
            if (bool_14_) {
                try {
                    this.socket.close();
                    this.socket = null;
                } catch (Exception exception) {
                    /* empty */
                }
                this.runtyp = 0;
                if ((this.app).cmsg.isShowing()) {
                    (this.app).cmsg.hide();
                    this.app.requestFocus();
                }
                this.runner.stop();
            }
            int i = getvalue(string_13_, 0);
            if (this.updatec != i && this.updatec >= -2) {
                for (int i_15_ = 0; i_15_ < 7; i_15_++) {
                    this.cnames[i_15_] = getSvalue(string_13_, 1 + i_15_ * 2);
                    this.sentn[i_15_] = getSvalue(string_13_, 2 + i_15_ * 2);
                }
                if (this.cnames[6].equals(""))
                    this.cnames[6] = "No Messages  ";
                if (this.updatec != -2) {
                    if (this.pointc != 6) {
                        this.pointc = 6;
                        this.floater = 1;
                    }
                    if (bool) {
                        this.msgflk = 67;
                        bool = false;
                    } else
                        this.msgflk = 110;
                }
                this.updatec = i;
            }
            try {
                if (this.runner != null) {
                    /* empty */
                }
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        if (this.runtyp == -167 || this.runtyp == -168) {
            try {
                this.socket = new Socket("multiplayer.needformadness.com", 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                this.dout.println(new StringBuilder().append("101|").append(this.runtyp + 174).append("|").append((this.app).tnick.getText()).append("|").append((this.app).tpass.getText()).append("|").toString());
                String string = this.din.readLine();
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            } catch (Exception exception) {
                /* empty */
            }
            this.runtyp = 0;
        }
    }
    
    public void sendwin(CheckPoints checkpoints) {
        if (this.logged && this.multion == 1 && this.winner) {
            if ((checkpoints).wasted == this.nplayers - 1)
                this.runtyp = -167;
            else
                this.runtyp = -168;
            this.runner = new Thread(this);
            this.runner.start();
        }
    }
    
    public void loading() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        this.rd.drawImage(this.sign, 362, 35, this);
        this.rd.drawImage(this.hello, 125, 105, this);
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.drawImage(this.loadbar, 281, 365, this);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        drawcs(358, "Loading game, please wait.", 0, 0, 0, 3);
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(295, 398, 210, 17);
        this.shload += ((float) this.dnload + 10.0F - this.shload) / 100.0F;
        if (this.shload > (float) this.kbload)
            this.shload = (float) this.kbload;
        if (this.dnload == this.kbload)
            this.shload = (float) this.kbload;
        drawcs(410, new StringBuilder().append("").append((int) ((26.0F + this.shload / (float) this.kbload * 200.0F) / 226.0F * 100.0F)).append(" % loaded    |    ").append(this.kbload - (int) this.shload).append(" KB remaining").toString(), 32, 64, 128, 3);
        this.rd.setColor(new Color(32, 64, 128));
        this.rd.fillRect(287, 371, 26 + (int) (this.shload / (float) this.kbload * 200.0F), 10);
    }
    
    public void stoploading() {
        loading();
        this.app.repaint();
        this.runner.stop();
        this.runner = null;
        this.runtyp = 0;
    }
    
    public void clicknow() {
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
        if (this.aflk) {
            drawcs(380, "Click here to Start", 0, 0, 0, 3);
            this.aflk = false;
        } else {
            drawcs(380, "Click here to Start", 0, 67, 200, 3);
            this.aflk = true;
        }
    }
    
    public void stopallnow() {
        if (this.runner != null) {
            this.runner.stop();
            this.runner = null;
        }
        this.runtyp = 0;
        if (this.loadedt) {
            this.strack.unload();
            this.strack = null;
            this.loadedt = false;
        }
        for (int i = 0; i < 5; i++) {
            for (int i_16_ = 0; i_16_ < 5; i_16_++) {
                this.engs[i][i_16_].stop();
                this.engs[i][i_16_] = null;
            }
        }
        for (int i = 0; i < 6; i++) {
            this.air[i].stop();
            this.air[i] = null;
        }
        this.wastd.stop();
        this.intertrack.unload();
        this.intertrack = null;
    }
    
    public void resetstat(int i) {
        this.arrace = false;
        this.alocked = -1;
        this.lalocked = -1;
        this.cntflock = 90;
        this.onlock = false;
        this.ana = 0;
        this.cntan = 0;
        this.cntovn = 0;
        this.tcnt = 30;
        this.wasay = false;
        this.clear = 0;
        this.dmcnt = 0;
        this.pwcnt = 0;
        this.auscnt = 45;
        this.pnext = 0;
        this.pback = 0;
        this.starcnt = 130;
        this.gocnt = 3;
        this.grrd = true;
        this.aird = true;
        this.bfcrash = 0;
        this.bfscrape = 0;
        this.cntwis = 0;
        this.bfskid = 0;
        this.pwait = 7;
        this.forstart = 200;
        this.exitm = 0;
        this.holdcnt = 0;
        this.holdit = false;
        this.winner = false;
        this.wasted = 0;
        for (int i_17_ = 0; i_17_ < 7; i_17_++) {
            this.dested[i_17_] = 0;
            this.isbot[i_17_] = false;
        }
        this.runtyp = 0;
        this.discon = 0;
        this.dnload = 0;
        if (this.fase == 2 || this.fase == -22)
            sortcars(i);
        if (this.fase == 22) {
            for (int i_18_ = 0; i_18_ < 7; i_18_++) {
                this.cnames[i_18_] = "";
                this.sentn[i_18_] = "";
            }
            this.cnames[6] = "No Messages  ";
            this.updatec = -1;
            this.movepos = 0;
            this.pointc = 6;
            this.floater = 0;
            this.cntchatp = 0;
            this.msgflk = 0;
            this.lcmsg = "";
            if (this.multion == 3)
                this.ransay = 4;
            else
                this.ransay = 1 + (int) (Math.random() * 3.0);
        }
    }
    
    public void setbots(boolean[] bools, int[][] is) {
        for (int i = 0; i < this.nplayers; i++) {
            if (this.plnames[i].indexOf("MadBot") != -1) {
                bools[i] = true;
                this.isbot[i] = true;
            }
        }
    }
    
    public void rad(int i) {
        if (i == 0) {
            this.powerup.play();
            this.radpx = 212;
            this.pin = 0;
        }
        trackbg(false);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(65, 135, 670, 59);
        if (this.pin != 0)
            this.rd.drawImage(this.radicalplay, this.radpx + (int) (8.0 * Math.random() - 4.0), 135, null);
        else
            this.rd.drawImage(this.radicalplay, 212, 135, null);
        if (this.radpx != 212) {
            this.radpx += 40;
            if (this.radpx > 735)
                this.radpx = -388;
        } else if (this.pin != 0)
            this.pin--;
        if (i == 40) {
            this.radpx = 213;
            this.pin = 7;
        }
        if (this.radpx == 212) {
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            drawcs(185 + (int) (5.0F * this.m.random()), "Radicalplay.com", 112, 120, 143, 3);
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            drawcs(215, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            this.aflk = false;
        } else {
            drawcs(217, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.rpro, 275, 265, null);
        this.brl = 10;
        this.fbrl = false;
        this.rd.setColor(new Color(this.brl * 2, this.brl, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }
    
    public void credits(Control control, int i, int i_19_, int i_20_) {
        if (this.flipo == 0) {
            this.powerup.play();
            this.flipo = 1;
        }
        if (this.flipo >= 1 && this.flipo <= 100) {
            rad(this.flipo);
            this.flipo++;
            if (this.flipo == 100)
                this.flipo = 1;
        }
        if (this.flipo == 101) {
            mainbg(-1);
            this.rd.drawImage(this.mdness, 283, 32, null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(90, "At Radicalplay.com", 0, 0, 0, 3);
            drawcs(165, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            drawcs(185, "Everything By Omar Waly", 40, 60, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(245, "Special Thanks!", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            drawcs(265, "Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.", 66, 98, 0, 3);
            drawcs(280, "Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.", 66, 98, 0, 3);
            drawcs(295, "Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.", 66, 98, 0, 3);
            drawcs(310, "A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!", 66, 98, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            drawcs(365, "Most of the tracks where remixed by Omar Waly to match the game.", 66, 98, 0, 3);
            drawcs(380, "More details about the tracks and their original composers at:", 66, 98, 0, 3);
            drawcs(395, "http://multiplayer.needformadness.com/music.html", 33, 49, 0, 3);
            this.rd.drawLine(400 - this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2, 396, this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2 + 400, 396);
            if (i > 258 && i < 542 && i_19_ > 385 && i_19_ < 399) {
                this.app.setCursor(new Cursor(12));
                if (i_20_ == 2)
                    this.app.musiclink();
            } else
                this.app.setCursor(new Cursor(0));
        }
        if (this.flipo == 102) {
            mainbg(0);
            this.rd.drawImage(this.nfmcom, 190, 195, null);
            if (i > 190 && i < 609 && i_19_ > 195 && i_19_ < 216) {
                this.app.setCursor(new Cursor(12));
                if (i_20_ == 2)
                    this.app.madlink();
            } else
                this.app.setCursor(new Cursor(0));
        }
        if (this.flipo == 103) {
            mainbg(-1);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(90, "At Radicalplay.com", 0, 0, 0, 3);
            drawcs(165, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            drawcs(185, "Everything By Omar Waly", 40, 60, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(245, "Special Thanks!", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            drawcs(265, "Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.", 66, 98, 0, 3);
            drawcs(280, "Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.", 66, 98, 0, 3);
            drawcs(295, "Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.", 66, 98, 0, 3);
            drawcs(310, "A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!", 66, 98, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            drawcs(365, "Most of the tracks where remixed by Omar Waly to match the game.", 66, 98, 0, 3);
            drawcs(380, "More details about the tracks and their original composers at:", 66, 98, 0, 3);
            drawcs(395, "http://multiplayer.needformadness.com/music.html", 33, 49, 0, 3);
            this.rd.drawLine(400 - this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2, 396, this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2 + 400, 396);
        }
        this.rd.drawImage(this.next[this.pnext], 665, 395, null);
        if ((control).enter || (control).handb || (control).right) {
            if (this.flipo >= 1 && this.flipo <= 100) {
                this.flipo = 101;
                this.app.setCursor(new Cursor(0));
            } else
                this.flipo++;
            if (this.flipo == 104) {
                this.flipo = 0;
                this.fase = 10;
            }
            (control).enter = false;
            (control).handb = false;
            (control).right = false;
        }
    }
    
    public void trackbg(boolean bool) {
        int i = 0;
        this.trkl++;
        if (this.trkl > this.trklim) {
            i = 1;
            this.trklim = (int) (Math.random() * 40.0);
            this.trkl = 0;
        }
        if (bool)
            i = 0;
        for (int i_21_ = 0; i_21_ < 2; i_21_++) {
            this.rd.drawImage(this.trackbg[i], this.trkx[i_21_], 25, null);
            this.trkx[i_21_] -= 10;
            if (this.trkx[i_21_] <= -605)
                this.trkx[i_21_] = 735;
        }
        if (!this.fbrl) {
            this.brl++;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            this.brl--;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(this.brl * 2, this.brl, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }
    
    public void mainbg(int i) {
        int i_22_ = 2;
        this.rd.setColor(new Color(191, 184, 124));
        if (i == -1) {
            if (i != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = 400;
                this.bgup = false;
                this.bgf = 0.0F;
                this.lmode = i;
            }
            this.rd.setColor(new Color(144, 222, 9));
            i_22_ = 8;
        }
        if (i == 0) {
            if (i != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = 400;
                this.bgup = false;
                this.bgf = 0.0F;
                this.lmode = i;
            }
            int i_23_ = (int) (255.0F * this.bgf + 191.0F * (1.0F - this.bgf));
            int i_24_ = (int) (176.0F * this.bgf + 184.0F * (1.0F - this.bgf));
            int i_25_ = (int) (67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
            if (!this.bgup) {
                this.bgf += 0.02F;
                if (this.bgf > 0.9F) {
                    this.bgf = 0.9F;
                    this.bgup = true;
                }
            } else {
                this.bgf -= 0.02F;
                if (this.bgf < 0.2F) {
                    this.bgf = 0.2F;
                    this.bgup = false;
                }
            }
            this.rd.setColor(new Color(i_23_, i_24_, i_25_));
            i_22_ = 4;
        }
        if (i == 1) {
            if (i != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = 400;
                this.lmode = i;
            }
            this.rd.setColor(new Color(255, 176, 67));
            i_22_ = 8;
        }
        if (i == 2) {
            if (i != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = 400;
                this.lmode = i;
                this.bgf = 0.2F;
            }
            this.rd.setColor(new Color(188, 170, 122));
            if (this.flipo == 16) {
                int i_26_ = (int) (176.0F * this.bgf + 191.0F * (1.0F - this.bgf));
                int i_27_ = (int) (202.0F * this.bgf + 184.0F * (1.0F - this.bgf));
                int i_28_ = (int) (255.0F * this.bgf + 124.0F * (1.0F - this.bgf));
                this.rd.setColor(new Color(i_26_, i_27_, i_28_));
                this.bgf += 0.025F;
                if (this.bgf > 0.85F)
                    this.bgf = 0.85F;
            } else
                this.bgf = 0.2F;
            i_22_ = 2;
        }
        if (i == 3) {
            if (i != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = 400;
                this.bgup = false;
                this.bgf = 0.0F;
                this.lmode = i;
            }
            int i_29_ = (int) (255.0F * this.bgf + 191.0F * (1.0F - this.bgf));
            int i_30_ = (int) (176.0F * this.bgf + 184.0F * (1.0F - this.bgf));
            int i_31_ = (int) (67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
            if (!this.bgup) {
                this.bgf += 0.02F;
                if (this.bgf > 0.9F) {
                    this.bgf = 0.9F;
                    this.bgup = true;
                }
            } else {
                this.bgf -= 0.02F;
                if (this.bgf < 0.2F) {
                    this.bgf = 0.2F;
                    this.bgup = false;
                }
            }
            this.rd.setColor(new Color(i_29_, i_30_, i_31_));
            i_22_ = 2;
        }
        this.rd.fillRect(65, 25, 670, 400);
        if (i == 4) {
            if (i != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = 400;
                for (int i_32_ = 0; i_32_ < 4; i_32_++) {
                    this.ovw[i_32_] = (int) (50.0 + 150.0 * Math.random());
                    this.ovh[i_32_] = (int) (50.0 + 150.0 * Math.random());
                    this.ovy[i_32_] = (int) (400.0 * Math.random());
                    this.ovx[i_32_] = (int) (Math.random() * 670.0);
                    this.ovsx[i_32_] = (int) (5.0 + Math.random() * 10.0);
                }
                this.lmode = i;
            }
            for (int i_33_ = 0; i_33_ < 4; i_33_++) {
                this.rd.setColor(new Color(223, 180, 95));
                this.rd.fillOval((int) ((double) (65 + this.ovx[i_33_]) - (double) this.ovw[i_33_] * 1.5 / 2.0), (int) ((double) (25 + this.ovy[i_33_]) - (double) this.ovh[i_33_] * 1.5 / 2.0), (int) ((double) this.ovw[i_33_] * 1.5), (int) ((double) this.ovh[i_33_] * 1.5));
                this.rd.setColor(new Color(255, 176, 67));
                this.rd.fillOval(65 + this.ovx[i_33_] - this.ovh[i_33_] / 2, 25 + this.ovy[i_33_] - this.ovh[i_33_] / 2, this.ovw[i_33_], this.ovh[i_33_]);
                this.ovx[i_33_] -= this.ovsx[i_33_];
                if ((double) this.ovx[i_33_] + (double) this.ovw[i_33_] * 1.5 / 2.0 < 0.0) {
                    this.ovw[i_33_] = (int) (50.0 + 150.0 * Math.random());
                    this.ovh[i_33_] = (int) (50.0 + 150.0 * Math.random());
                    this.ovy[i_33_] = (int) (400.0 * Math.random());
                    this.ovx[i_33_] = (int) (670.0 + (double) this.ovw[i_33_] * 1.5 / 2.0);
                    this.ovsx[i_33_] = (int) (5.0 + Math.random() * 10.0);
                }
            }
            i_22_ = 4;
        }
        for (int i_34_ = 0; i_34_ < 2; i_34_++) {
            if (i != 2 || this.flipo != 16)
                this.rd.drawImage(this.bgmain, 65, 25 + this.bgmy[i_34_], null);
            this.bgmy[i_34_] -= i_22_;
            if (this.bgmy[i_34_] <= -400)
                this.bgmy[i_34_] = 400;
        }
        if (!this.fbrl) {
            this.brl++;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            this.brl--;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(this.brl * 2, this.brl, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }
    
    public void inishstageselect(CheckPoints checkpoints) {
        if ((checkpoints).stage == -2 && ((this.cd).msloaded != 1 || !this.logged)) {
            (checkpoints).stage = (int) (Math.random() * 27.0) + 1;
            (checkpoints).top20 = 0;
        }
        if ((checkpoints).stage > 27)
            (checkpoints).stage = (int) (Math.random() * 27.0) + 1;
        if ((checkpoints).stage == -2) {
            boolean bool = false;
            for (int i = 1; i < (this.app).mstgs.getItemCount(); i++) {
                if ((this.app).mstgs.getItem(i).equals((checkpoints).name))
                    bool = true;
            }
            if (!bool)
                (checkpoints).stage = (int) (Math.random() * 27.0) + 1;
        }
        if (this.gmode == 1) {
            if (this.unlocked[0] != 11 || this.justwon1)
                (checkpoints).stage = this.unlocked[0];
            else if (this.winner || (checkpoints).stage > 11)
                (checkpoints).stage = (int) (Math.random() * 11.0) + 1;
            if ((checkpoints).stage == 11)
                (checkpoints).stage = 27;
        }
        if (this.gmode == 2) {
            if (this.unlocked[0] != 17 || this.justwon2)
                (checkpoints).stage = this.unlocked[1] + 10;
            else if (this.winner || (checkpoints).stage < 11)
                (checkpoints).stage = (int) (Math.random() * 17.0) + 11;
        }
        (this.app).sgame.setBackground(new Color(0, 0, 0));
        (this.app).sgame.setForeground(new Color(47, 179, 255));
        (this.app).snfm1.setBackground(new Color(0, 0, 0));
        (this.app).snfm1.setForeground(new Color(47, 179, 255));
        (this.app).snfm2.setBackground(new Color(0, 0, 0));
        (this.app).snfm2.setForeground(new Color(47, 179, 255));
        (this.app).mstgs.setBackground(new Color(0, 0, 0));
        (this.app).mstgs.setForeground(new Color(47, 179, 255));
        (this.app).gmode.setBackground(new Color(49, 49, 0));
        (this.app).gmode.setForeground(new Color(148, 167, 0));
        (this.app).sgame.removeAll();
        (this.app).sgame.add(this.rd, " NFM 1     ");
        (this.app).sgame.add(this.rd, " NFM 2     ");
        (this.app).sgame.add(this.rd, " My Stages ");
        (this.app).sgame.add(this.rd, " Weekly Top20 ");
        (this.app).sgame.add(this.rd, " Monthly Top20 ");
        (this.app).sgame.add(this.rd, " All Time Top20 ");
        (this.app).sgame.add(this.rd, " Stage Maker ");
        if ((checkpoints).stage > 0 && (checkpoints).stage <= 10) {
            (this.app).sgame.select(0);
            this.nfmtab = 0;
        }
        if ((checkpoints).stage > 10) {
            (this.app).sgame.select(1);
            this.nfmtab = 1;
        }
        if ((checkpoints).stage == -2) {
            (this.app).sgame.select(2);
            this.nfmtab = 2;
        }
        if ((checkpoints).stage == -1) {
            (this.app).sgame.select(6);
            this.nfmtab = 6;
        }
        this.removeds = 0;
        this.lfrom = 0;
        (this.cd).staction = 0;
        this.fase = 2;
    }
    
    public void loadingstage(int i, boolean bool) {
        trackbg(true);
        this.rd.drawImage(this.br, 65, 25, null);
        this.rd.setColor(new Color(212, 214, 138));
        this.rd.fillRoundRect(265, 201, 270, 26, 20, 40);
        this.rd.setColor(new Color(57, 64, 8));
        this.rd.drawRoundRect(265, 201, 270, 26, 20, 40);
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        drawcs(219, "Loading, please wait...", 58, 61, 17, 3);
        if (bool)
            this.rd.drawImage(this.select, 338, 35, null);
        this.rd.drawImage(this.byrd2, 72, 408, null);
        this.rd.drawImage(this.nfmcoms2, 532, 408, null);
        this.app.repaint();
        if ((this.cd).staction != 0) {
            (this.app).tnick.hide();
            (this.app).tpass.hide();
            (this.cd).staction = 0;
        }
        this.removeds = 0;
    }
    
    public void cantgo(Control control) {
        this.pnext = 0;
        trackbg(false);
        this.rd.drawImage(this.br, 65, 25, null);
        this.rd.drawImage(this.select, 338, 35, null);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        drawcs(130, new StringBuilder().append("This stage will be unlocked when stage ").append(this.unlocked[this.gmode - 1]).append(" is complete!").toString(), 177, 177, 177, 3);
        for (int i = 0; i < 9; i++)
            this.rd.drawImage(this.pgate, 277 + i * 30, 215, null);
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            drawcs(185, new StringBuilder().append("[ Stage ").append(this.unlocked[this.gmode - 1] + 1).append(" Locked ]").toString(), 255, 128, 0, 3);
            this.aflk = false;
        } else {
            drawcs(185, new StringBuilder().append("[ Stage ").append(this.unlocked[this.gmode - 1] + 1).append(" Locked ]").toString(), 255, 0, 0, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.back[this.pback], 370, 345, null);
        this.rd.drawImage(this.byrd2, 72, 408, null);
        this.rd.drawImage(this.nfmcoms2, 532, 408, null);
        this.lockcnt--;
        if (this.lockcnt == 0 || (control).enter || (control).handb || (control).left) {
            (control).left = false;
            (control).handb = false;
            (control).enter = false;
            this.fase = 1;
        }
    }
    
    public void stageselect(CheckPoints checkpoints, Control control, int i, int i_35_, boolean bool) {
        this.rd.drawImage(this.br, 65, 25, null);
        this.rd.drawImage(this.select, 338, 35, null);
        if (this.testdrive != 3 && this.testdrive != 4) {
            if ((checkpoints).stage > 0 && (this.cd).staction == 0) {
                if ((checkpoints).stage != 1 && ((checkpoints).stage != 11 || this.gmode != 2))
                    this.rd.drawImage(this.back[this.pback], 115, 135, null);
                if ((checkpoints).stage != 27)
                    this.rd.drawImage(this.next[this.pnext], 625, 135, null);
            }
            if (this.gmode == 0) {
                boolean bool_36_ = false;
                int i_37_ = 0;
                if (this.nfmtab != (this.app).sgame.getSelectedIndex()) {
                    this.nfmtab = (this.app).sgame.getSelectedIndex();
                    (this.app).snfm1.select(0);
                    (this.app).snfm2.select(0);
                    (this.app).mstgs.select(0);
                    this.app.requestFocus();
                    bool_36_ = true;
                }
                if ((this.cd).staction == 5) {
                    if (this.lfrom == 0) {
                        (this.cd).staction = 0;
                        this.removeds = 1;
                        bool_36_ = true;
                    } else {
                        (this.cd).onstage = (checkpoints).name;
                        (this.cd).staction = 2;
                        this.dnload = 2;
                    }
                    this.nickname = (this.app).tnick.getText();
                    this.nickey = (this.cd).tnickey;
                    this.app.setloggedcookie();
                    this.logged = true;
                    if ((this.cd).reco == 0)
                        this.acexp = 0;
                    if ((this.cd).reco > 10)
                        this.acexp = (this.cd).reco - 10;
                    if ((this.cd).reco == 3)
                        this.acexp = -1;
                }
                if (this.nfmtab == 2 && (this.cd).staction == 0 && this.removeds == 1)
                    (checkpoints).stage = -3;
                if ((this.app).openm && (this.cd).staction == 3) {
                    (this.app).tnick.hide();
                    (this.app).tpass.hide();
                    (this.cd).staction = 0;
                }
                int i_38_ = 0;
                (this.app).sgame.setSize(131, 22);
                if ((this.app).sgame.getSelectedIndex() == 0)
                    i_38_ = 400 - ((this.app).sgame.getWidth() + 6 + (this.app).snfm1.getWidth()) / 2;
                if ((this.app).sgame.getSelectedIndex() == 1)
                    i_38_ = 400 - ((this.app).sgame.getWidth() + 6 + (this.app).snfm2.getWidth()) / 2;
                if ((this.app).sgame.getSelectedIndex() == 2) {
                    (this.app).mstgs.setSize(338, 22);
                    if (bool_36_) {
                        if (this.logged) {
                            if ((this.cd).msloaded != 1) {
                                (this.app).mstgs.removeAll();
                                (this.app).mstgs.add(this.rd, "Loading your stages now, please wait...");
                                (this.app).mstgs.select(0);
                                i_37_ = 1;
                            }
                        } else {
                            (this.app).mstgs.removeAll();
                            (this.app).mstgs.add(this.rd, "Please login first to load your stages...");
                            (this.app).mstgs.select(0);
                            (this.cd).msloaded = 0;
                            this.lfrom = 0;
                            (this.cd).staction = 3;
                            this.tcnt = 0;
                            this.cntflock = 0;
                            (this.cd).reco = -2;
                        }
                    }
                    i_38_ = 400 - ((this.app).sgame.getWidth() + 6 + (this.app).mstgs.getWidth()) / 2;
                }
                if ((this.app).sgame.getSelectedIndex() == 3) {
                    (this.app).mstgs.setSize(338, 22);
                    if (bool_36_ && (this.cd).msloaded != 3) {
                        (this.app).mstgs.removeAll();
                        (this.app).mstgs.add(this.rd, "Loading Top20 list, please wait...");
                        (this.app).mstgs.select(0);
                        i_37_ = 3;
                    }
                    i_38_ = 400 - ((this.app).sgame.getWidth() + 6 + (this.app).mstgs.getWidth()) / 2;
                }
                if ((this.app).sgame.getSelectedIndex() == 4) {
                    (this.app).mstgs.setSize(338, 22);
                    if (bool_36_ && (this.cd).msloaded != 4) {
                        (this.app).mstgs.removeAll();
                        (this.app).mstgs.add(this.rd, "Loading Top20 list, please wait...");
                        (this.app).mstgs.select(0);
                        i_37_ = 4;
                    }
                    i_38_ = 400 - ((this.app).sgame.getWidth() + 6 + (this.app).mstgs.getWidth()) / 2;
                }
                if ((this.app).sgame.getSelectedIndex() == 5) {
                    (this.app).mstgs.setSize(338, 22);
                    if (bool_36_ && (this.cd).msloaded != 5) {
                        (this.app).mstgs.removeAll();
                        (this.app).mstgs.add(this.rd, "Loading Top20 list, please wait...");
                        (this.app).mstgs.select(0);
                        i_37_ = 5;
                    }
                    i_38_ = 400 - ((this.app).sgame.getWidth() + 6 + (this.app).mstgs.getWidth()) / 2;
                }
                if ((this.app).sgame.getSelectedIndex() == 6) {
                    if ((this.cd).staction != 0) {
                        (this.app).tnick.hide();
                        (this.app).tpass.hide();
                        (this.cd).staction = 0;
                    }
                    (this.app).mstgs.setSize(338, 22);
                    if (bool_36_ && (this.cd).msloaded != 2) {
                        (this.app).mstgs.removeAll();
                        (this.app).mstgs.add(this.rd, "Loading Stage Maker stages, please wait...");
                        (this.app).mstgs.select(0);
                        i_37_ = 2;
                    }
                    i_38_ = 400 - ((this.app).sgame.getWidth() + 6 + (this.app).mstgs.getWidth()) / 2;
                }
                if (!(this.app).sgame.isShowing())
                    (this.app).sgame.show();
                (this.app).sgame.move(i_38_, 62);
                i_38_ += (this.app).sgame.getWidth() + 6;
                if (this.nfmtab == 0) {
                    if (!(this.app).snfm1.isShowing()) {
                        (this.app).snfm1.show();
                        if (!bool_36_ && (checkpoints).stage > 0)
                            (this.app).snfm1.select((checkpoints).stage);
                    }
                    (this.app).snfm1.move(i_38_, 62);
                    if ((this.app).snfm2.isShowing())
                        (this.app).snfm2.hide();
                    if ((this.app).mstgs.isShowing())
                        (this.app).mstgs.hide();
                }
                if (this.nfmtab == 1) {
                    if (!(this.app).snfm2.isShowing()) {
                        (this.app).snfm2.show();
                        if (!bool_36_ && (checkpoints).stage > 10)
                            (this.app).snfm2.select((checkpoints).stage - 10);
                    }
                    (this.app).snfm2.move(i_38_, 62);
                    if ((this.app).snfm1.isShowing())
                        (this.app).snfm1.hide();
                    if ((this.app).mstgs.isShowing())
                        (this.app).mstgs.hide();
                }
                if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4 || this.nfmtab == 5 || this.nfmtab == 6) {
                    if (!(this.app).mstgs.isShowing()) {
                        (this.app).mstgs.show();
                        if (!bool_36_)
                            (this.app).mstgs.select((checkpoints).name);
                    }
                    (this.app).mstgs.move(i_38_, 62);
                    if ((this.app).snfm1.isShowing())
                        (this.app).snfm1.hide();
                    if ((this.app).snfm2.isShowing())
                        (this.app).snfm2.hide();
                }
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if ((this.cd).staction == 0 || (this.cd).staction == 6) {
                    if ((checkpoints).stage != -3) {
                        String string = "";
                        if ((checkpoints).top20 >= 3)
                            string = new StringBuilder().append("N#").append((checkpoints).nto).append("  ").toString();
                        if (this.aflk) {
                            drawcs(132, new StringBuilder().append(string).append((checkpoints).name).toString(), 240, 240, 240, 3);
                            this.aflk = false;
                        } else {
                            drawcs(132, new StringBuilder().append(string).append((checkpoints).name).toString(), 176, 176, 176, 3);
                            this.aflk = true;
                        }
                        if ((checkpoints).stage == -2 && (this.cd).staction == 0) {
                            this.rd.setFont(new Font("Arial", 1, 11));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(255, 176, 85));
                            if ((checkpoints).maker.equals(this.nickname))
                                this.rd.drawString("Created by You", 70, 115);
                            else
                                this.rd.drawString(new StringBuilder().append("Created by :  ").append((checkpoints).maker).append("").toString(), 70, 115);
                            if ((checkpoints).top20 >= 3)
                                this.rd.drawString(new StringBuilder().append("Added by :  ").append((this.cd).top20adds[(checkpoints).nto - 1]).append(" Players").toString(), 70, 135);
                        }
                    } else if (this.removeds != 1) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        drawcs(132, "Failed to load stage...", 255, 138, 0, 3);
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.nfmtab == 6)
                            drawcs(155, "Please Test Drive this stage in the Stage Maker to make sure it can be loaded!", 255, 138, 0, 3);
                        if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4 || this.nfmtab == 5)
                            drawcs(155, "It could be a connection error, please try again later.", 255, 138, 0, 3);
                        if (this.nfmtab == 1 || this.nfmtab == 0) {
                            drawcs(155, "Will try to load another stage...", 255, 138, 0, 3);
                            this.app.repaint();
                            try {
                                Thread.sleep(5000L);
                            } catch (InterruptedException interruptedexception) {
                                /* empty */
                            }
                            if (this.nfmtab == 0)
                                (this.app).snfm1.select(1 + (int) (Math.random() * 10.0));
                            if (this.nfmtab == 1)
                                (this.app).snfm2.select(1 + (int) (Math.random() * 17.0));
                        }
                    }
                }
                if ((this.cd).staction == 3) {
                    drawdprom(145, 170);
                    if ((this.cd).reco == -2) {
                        if (this.lfrom == 0)
                            drawcs(171, "Login to Retrieve your Account Stages", 0, 0, 0, 3);
                        else
                            drawcs(171, "Login to add this stage to your account.", 0, 0, 0, 3);
                    }
                    if ((this.cd).reco == -1)
                        drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                    if ((this.cd).reco == 1)
                        drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                    if ((this.cd).reco == 2)
                        drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                    if ((this.cd).reco == -167 || (this.cd).reco == -177) {
                        if ((this.cd).reco == -167) {
                            this.nickname = (this.app).tnick.getText();
                            (this.cd).reco = -177;
                        }
                        drawcs(171, "You need to have a full account to access your stages!", 0, 0, 0, 3);
                    }
                    if ((this.cd).reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20))
                        drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                    if ((this.cd).reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20))
                        drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                    if (!(this.app).tnick.isShowing()) {
                        (this.app).tnick.show();
                        (this.app).tnick.setBackground(new Color(206, 237, 255));
                        if ((this.cd).reco != 1) {
                            if ((this.cd).reco != 2)
                                (this.app).tnick.setText(this.nickname);
                            (this.app).tnick.setForeground(new Color(0, 0, 0));
                        } else
                            (this.app).tnick.setForeground(new Color(255, 0, 0));
                        (this.app).tnick.requestFocus();
                    }
                    this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 201);
                    this.app.movefield((this.app).tnick, 376, 185, 129, 23);
                    if (!(this.app).tpass.isShowing()) {
                        (this.app).tpass.show();
                        (this.app).tpass.setBackground(new Color(206, 237, 255));
                        if ((this.cd).reco != 2) {
                            if (!this.autolog)
                                (this.app).tpass.setText("");
                            (this.app).tpass.setForeground(new Color(0, 0, 0));
                        } else
                            (this.app).tpass.setForeground(new Color(255, 0, 0));
                        if (!(this.app).tnick.getText().equals("") && (this.cd).reco != 1)
                            (this.app).tpass.requestFocus();
                    }
                    this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 231);
                    this.app.movefield((this.app).tpass, 376, 215, 129, 23);
                    if (this.tcnt < 30) {
                        this.tcnt++;
                        if (this.tcnt == 30) {
                            if ((this.cd).reco == 2)
                                (this.app).tpass.setText("");
                            (this.app).tnick.setForeground(new Color(0, 0, 0));
                            (this.app).tpass.setForeground(new Color(0, 0, 0));
                        }
                    }
                    if ((this.cd).reco != -177) {
                        if ((drawcarb(true, null, "       Login       ", 347, 247, i, i_35_, bool) || (control).handb || (control).enter) && this.tcnt > 5) {
                            this.tcnt = 0;
                            if (!(this.app).tnick.getText().equals("") && !(this.app).tpass.getText().equals("")) {
                                this.autolog = false;
                                (this.app).tnick.hide();
                                (this.app).tpass.hide();
                                this.app.requestFocus();
                                (this.cd).staction = 4;
                                this.cd.sparkstageaction();
                            } else {
                                if ((this.app).tpass.getText().equals(""))
                                    (this.cd).reco = -4;
                                if ((this.app).tnick.getText().equals(""))
                                    (this.cd).reco = -3;
                            }
                        }
                    } else if (drawcarb(true, null, "  Upgrade your account to have full access  ", 254, 247, i, i_35_, bool) && this.cntflock == 0) {
                        this.app.editlink(this.nickname);
                        this.cntflock = 100;
                    }
                    if (drawcarb(true, null, "  Cancel  ", 409, 282, i, i_35_, bool)) {
                        (this.app).tnick.hide();
                        (this.app).tpass.hide();
                        this.app.requestFocus();
                        (this.cd).staction = 0;
                    }
                    if (drawcarb(true, null, "  Register!  ", 316, 282, i, i_35_, bool)) {
                        if (this.cntflock == 0) {
                            this.app.reglink();
                            this.cntflock = 100;
                        }
                    } else if (this.cntflock != 0)
                        this.cntflock--;
                }
                if ((this.cd).staction == 4) {
                    drawdprom(145, 170);
                    drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                }
                if ((checkpoints).stage == -2 && (this.cd).msloaded == 1 && (checkpoints).top20 < 3 && drawcarb(true, null, "X", 609, 113, i, i_35_, bool))
                    (this.cd).staction = 6;
                if ((this.cd).staction == -1 && (checkpoints).top20 < 3) {
                    this.removeds = 0;
                    drawdprom(145, 95);
                    drawcs(175, "Failed to remove stage from your account, try again later.", 0, 0, 0, 3);
                    if (drawcarb(true, null, " OK ", 379, 195, i, i_35_, bool))
                        (this.cd).staction = 0;
                }
                if ((this.cd).staction == 1) {
                    drawdprom(145, 95);
                    drawcs(195, "Removing stage from your account...", 0, 0, 0, 3);
                    this.removeds = 1;
                }
                if ((this.cd).staction == 6) {
                    drawdprom(145, 95);
                    drawcs(175, "Remove this stage from your account?", 0, 0, 0, 3);
                    if (drawcarb(true, null, " Yes ", 354, 195, i, i_35_, bool)) {
                        (this.cd).onstage = (this.app).mstgs.getSelectedItem();
                        (this.cd).staction = 1;
                        this.cd.sparkstageaction();
                    }
                    if (drawcarb(true, null, " No ", 408, 195, i, i_35_, bool))
                        (this.cd).staction = 0;
                }
                if (i_37_ == 1) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadmystages(checkpoints);
                }
                if (i_37_ >= 3) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadtop20(i_37_);
                }
                if (i_37_ == 2) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadstagemaker();
                }
                if ((checkpoints).stage != -3 && (this.cd).staction == 0 && (checkpoints).top20 < 3)
                    this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
                else
                    this.pcontin = 0;
                if ((checkpoints).top20 >= 3 && (this.cd).staction != 3 && (this.cd).staction != 4) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 355, i, i_35_, bool)) {
                        if (this.logged) {
                            (this.cd).onstage = (checkpoints).name;
                            (this.cd).staction = 2;
                            this.cd.sparkstageaction();
                            this.dnload = 2;
                        } else {
                            this.lfrom = 1;
                            (this.cd).staction = 3;
                            this.tcnt = 0;
                            this.cntflock = 0;
                            (this.cd).reco = -2;
                        }
                    }
                    if (this.dnload == 2) {
                        drawcs(370, "Adding stage please wait...", 193, 106, 0, 3);
                        if ((this.cd).staction == 0)
                            this.dnload = 3;
                        if ((this.cd).staction == -2)
                            this.dnload = 4;
                        if ((this.cd).staction == -3)
                            this.dnload = 5;
                        if ((this.cd).staction == -1)
                            this.dnload = 6;
                        if (this.dnload != 2)
                            (this.cd).staction = 0;
                    }
                    if (this.dnload == 3)
                        drawcs(370, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                    if (this.dnload == 4)
                        drawcs(370, "You already have this stage!", 193, 106, 0, 3);
                    if (this.dnload == 5)
                        drawcs(370, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                    if (this.dnload == 6)
                        drawcs(370, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
                }
                if (this.testdrive == 0 && (checkpoints).top20 < 3) {
                    if (!(this.app).gmode.isShowing()) {
                        (this.app).gmode.select(0);
                        (this.app).gmode.show();
                    }
                    (this.app).gmode.move(400 - (this.app).gmode.getWidth() / 2, 395);
                    if ((this.app).gmode.getSelectedIndex() == 0 && this.nplayers != 7) {
                        this.nplayers = 7;
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                    if ((this.app).gmode.getSelectedIndex() == 1 && this.nplayers != 1) {
                        this.nplayers = 1;
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                } else if ((this.app).gmode.isShowing())
                    (this.app).gmode.hide();
                if (this.nfmtab == 0 && (this.app).snfm1.getSelectedIndex() != (checkpoints).stage && (this.app).snfm1.getSelectedIndex() != 0) {
                    (checkpoints).stage = (this.app).snfm1.getSelectedIndex();
                    (checkpoints).top20 = 0;
                    (checkpoints).nto = 0;
                    hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if (this.nfmtab == 1 && (this.app).snfm2.getSelectedIndex() != (checkpoints).stage - 10 && (this.app).snfm2.getSelectedIndex() != 0) {
                    (checkpoints).stage = (this.app).snfm2.getSelectedIndex() + 10;
                    (checkpoints).top20 = 0;
                    (checkpoints).nto = 0;
                    hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if ((this.nfmtab == 2 || this.nfmtab == 6) && !(this.app).mstgs.getSelectedItem().equals((checkpoints).name) && (this.app).mstgs.getSelectedIndex() != 0) {
                    if (this.nfmtab == 2)
                        (checkpoints).stage = -2;
                    else
                        (checkpoints).stage = -1;
                    (checkpoints).name = (this.app).mstgs.getSelectedItem();
                    (checkpoints).top20 = 0;
                    (checkpoints).nto = 0;
                    hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if (this.nfmtab == 3 || this.nfmtab == 4 || this.nfmtab == 5) {
                    String string = "";
                    int i_39_ = (this.app).mstgs.getSelectedItem().indexOf(" ") + 1;
                    if (i_39_ > 0)
                        string = (this.app).mstgs.getSelectedItem().substring(i_39_);
                    if (!string.equals("") && !string.equals((checkpoints).name) && (this.app).mstgs.getSelectedIndex() != 0) {
                        (checkpoints).stage = -2;
                        (checkpoints).name = string;
                        (checkpoints).top20 = -(this.cd).msloaded;
                        (checkpoints).nto = (this.app).mstgs.getSelectedIndex();
                        hidos();
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                }
            } else {
                this.rd.setFont(new Font("SansSerif", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if ((checkpoints).stage != 27) {
                    int i_40_ = (checkpoints).stage;
                    if (i_40_ > 10)
                        i_40_ -= 10;
                    drawcs(80, new StringBuilder().append("Stage ").append(i_40_).append("  >").toString(), 255, 128, 0, 3);
                } else
                    drawcs(80, "Final Party Stage  >", 255, 128, 0, 3);
                if (this.aflk) {
                    drawcs(100, new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(), 240, 240, 240, 3);
                    this.aflk = false;
                } else {
                    drawcs(100, new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(), 176, 176, 176, 3);
                    this.aflk = true;
                }
                if ((checkpoints).stage != -3)
                    this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
                else
                    this.pcontin = 0;
            }
            this.rd.drawImage(this.byrd2, 72, 408, null);
            this.rd.drawImage(this.nfmcoms2, 532, 408, null);
            if ((this.cd).staction == 0) {
                if (((control).handb || (control).enter) && (checkpoints).stage != -3 && (checkpoints).top20 < 3) {
                    (this.app).gmode.hide();
                    hidos();
                    this.dudo = 150;
                    this.fase = 5;
                    (control).handb = false;
                    (control).enter = false;
                    this.intertrack.stop();
                    this.intertrack.unloadimod();
                }
                if ((checkpoints).stage > 0) {
                    if ((control).right) {
                        if (this.gmode == 0 || this.gmode == 1 && (checkpoints).stage != this.unlocked[0] || this.gmode == 2 && (checkpoints).stage != this.unlocked[1] + 10 || (checkpoints).stage == 27) {
                            if ((checkpoints).stage != 27) {
                                hidos();
                                (checkpoints).stage++;
                                if (this.gmode == 1 && (checkpoints).stage == 11)
                                    (checkpoints).stage = 27;
                                if ((checkpoints).stage > 10) {
                                    (this.app).sgame.select(1);
                                    this.nfmtab = 1;
                                } else {
                                    (this.app).sgame.select(0);
                                    this.nfmtab = 0;
                                }
                                this.fase = 2;
                            }
                        } else {
                            this.fase = 4;
                            this.lockcnt = 100;
                        }
                        (control).right = false;
                    }
                    if ((control).left && (checkpoints).stage != 1 && ((checkpoints).stage != 11 || this.gmode != 2)) {
                        hidos();
                        (checkpoints).stage--;
                        if (this.gmode == 1 && (checkpoints).stage == 26)
                            (checkpoints).stage = 10;
                        if ((checkpoints).stage > 10) {
                            (this.app).sgame.select(1);
                            this.nfmtab = 1;
                        } else {
                            (this.app).sgame.select(0);
                            this.nfmtab = 0;
                        }
                        this.fase = 2;
                        (control).left = false;
                    }
                }
            }
        } else {
            if (this.aflk) {
                drawcs(132, (checkpoints).name, 240, 240, 240, 3);
                this.aflk = false;
            } else {
                drawcs(132, (checkpoints).name, 176, 176, 176, 3);
                this.aflk = true;
            }
            this.rd.drawImage(this.contin[this.pcontin], 355, 360, null);
            if ((control).handb || (control).enter) {
                this.dudo = 150;
                this.fase = 5;
                (control).handb = false;
                (control).enter = false;
                this.intertrack.stop();
                this.intertrack.unloadimod();
            }
        }
        if (drawcarb(true, null, " Exit X ", 670, 30, i, i_35_, bool)) {
            this.fase = 102;
            if (this.gmode == 0)
                this.opselect = 3;
            if (this.gmode == 1)
                this.opselect = 0;
            if (this.gmode == 2)
                this.opselect = 1;
            (this.app).gmode.hide();
            hidos();
            (this.app).tnick.hide();
            (this.app).tpass.hide();
            this.intertrack.stop();
        }
    }
    
    public void hidos() {
        (this.app).sgame.hide();
        (this.app).snfm1.hide();
        (this.app).snfm2.hide();
        (this.app).mstgs.hide();
    }
    
    public void hipnoload(int i, boolean bool) {
        int[] is = { (this.m).snap[0], (this.m).snap[1], (this.m).snap[2] };
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
        this.rd.setColor(new Color(i_42_, i_43_, i_44_));
        this.rd.fillRect(0, 0, 800, 450);
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
        this.rd.setColor(new Color(i_42_, i_43_, i_44_));
        this.rd.fillRect(65, 25, 670, 400);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        drawcs(50, this.asay, 0, 0, 0, 3);
        int i_45_ = -90;
        if (this.multion == 0) {
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 10)
                i_45_ = 0;
            if (i == 11 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20 || i == 22 || i == 23 || i == 26)
                i_45_ = 0;
            if (i < 0 && this.nplayers != 1 && this.newparts)
                i_45_ = 0;
        } else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 4 || i == 10)
            i_45_ = 0;
        if (i_45_ == 0) {
            if (this.dudo > 0) {
                if (this.aflk) {
                    if (Math.random() > Math.random())
                        this.duds = (int) (Math.random() * 3.0);
                    else
                        this.duds = (int) (Math.random() * 2.0);
                    this.aflk = false;
                } else
                    this.aflk = true;
                this.dudo--;
            } else
                this.duds = 0;
            this.rd.drawImage(this.dude[this.duds], 95, 35, null);
            this.rd.drawImage(this.flaot, 192, 67, null);
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
            this.rd.setColor(new Color(i_42_, i_43_, i_44_));
            this.rd.setFont(new Font("Arial", 1, 13));
            if (this.multion != 0) {
                if (this.ransay == 1 && i != 10)
                    this.rd.drawString("Multiplayer Tip:  Press [ C ] to access chat quickly during the game!", 262, 92);
                if (this.ransay == 2 && i != 10) {
                    this.rd.drawString("Multiplayer Tip:  Press [ A ] to make Guidance Arrow point to cars and", 262, 92);
                    this.rd.drawString("click any of the players listed on the right to lock the Arrow on!", 262, 112);
                }
                if (this.ransay == 4) {
                    this.rd.drawString("When watching a game, click any player listed on the right of the", 262, 92);
                    this.rd.drawString("screen to follow and watch.", 262, 112);
                    this.rd.drawString("Press [ V ] to change the viewing mode!", 262, 132);
                }
                if (i == 10 && this.ransay != 4) {
                    if (this.tflk) {
                        this.rd.setColor(new Color(200, i_43_, i_44_));
                        this.tflk = false;
                    } else
                        this.tflk = true;
                    this.rd.drawString("NOTE: Guidance Arrow and opponent status is disabled in this stage!", 262, 92);
                }
            } else {
                if (i < 0 && this.nplayers != 1 && this.newparts) {
                    this.rd.drawString("Please note, the computer car's AI has not yet been trained to handle", 262, 92);
                    this.rd.drawString("some of the new stage parts such as the 'Rollercoaster Road' and the", 262, 112);
                    this.rd.drawString("'Tunnel Side Ramp'.", 262, 132);
                    this.rd.drawString("(Those new parts where mostly designed for the multiplayer game.)", 262, 152);
                    this.rd.drawString("The AI will be trained and ready in the future releases of the game!", 262, 172);
                }
                if (i == 1 || i == 11) {
                    this.rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 262, 92);
                    this.rd.drawString("all checkpoints in the track!", 262, 112);
                }
                if (i == 2 || i == 12)
                    this.rd.drawString("Remember, the more power you have the faster your car will be!", 262, 92);
                if (i == 3) {
                    this.rd.drawString("> Hint: its easier to waste the other cars then to race in this stage!", 262, 92);
                    this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 112);
                    this.rd.drawString("the track.", 262, 132);
                }
                if (i == 4)
                    this.rd.drawString("Remember, the better the stunt you perform the more power you get!", 262, 92);
                if (i == 5)
                    this.rd.drawString("Remember, the more power you have the stronger your car is!", 262, 92);
                if (i == 10) {
                    if (this.tflk) {
                        this.rd.setColor(new Color(200, i_43_, i_44_));
                        this.tflk = false;
                    } else
                        this.tflk = true;
                    this.rd.drawString("NOTE: Guidance Arrow is disabled in this stage!", 262, 92);
                }
                if (i == 13) {
                    this.rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 262, 92);
                    this.rd.drawString("Don't upset him or you'll be arrested!", 262, 112);
                    this.rd.drawString("Better run, run, run.", 262, 152);
                }
                if (i == 14) {
                    this.rd.drawString("Don't waste your time.  Waste them instead!", 262, 92);
                    this.rd.drawString("Try a taste of sweet revenge here (if you can)!", 262, 112);
                    this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 152);
                    this.rd.drawString("the track.", 262, 172);
                }
                if (i == 17) {
                    this.rd.drawString("Welcome to the realm of the king...", 262, 92);
                    this.rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 262, 132);
                    this.rd.drawString("and STRONGER you car will be!", 262, 152);
                }
                if (i == 18) {
                    this.rd.drawString("Watch out, EL KING is out to get you now!", 262, 92);
                    this.rd.drawString("He seems to be seeking revenge?", 262, 112);
                    this.rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 262, 152);
                    this.rd.drawString("before take off).", 262, 172);
                }
                if (i == 19)
                    this.rd.drawString("It\u2019s good to be the king!", 262, 92);
                if (i == 20) {
                    this.rd.drawString("Remember, forward loops give your car a push forwards in the air", 262, 92);
                    this.rd.drawString("and help in racing.", 262, 112);
                    this.rd.drawString("(You may need to do more forward loops here.  Also try keeping", 262, 152);
                    this.rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 262, 172);
                }
                if (i == 22) {
                    this.rd.drawString("Watch out!  Beware!  Take care!", 262, 92);
                    this.rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 262, 112);
                }
                if (i == 23) {
                    this.rd.drawString("Anyone for a game of Digger?!", 262, 92);
                    this.rd.drawString("You can have fun using MASHEEN here!", 262, 112);
                }
                if (i == 26) {
                    this.rd.drawString("This is it!  This is the toughest stage in the game!", 262, 92);
                    this.rd.drawString("This track is actually a 4D object projected onto the 3D world.", 262, 132);
                    this.rd.drawString("It's been broken down, separated and, in many ways, it is also a", 262, 152);
                    this.rd.drawString("maze!  GOOD LUCK!", 262, 172);
                }
            }
        }
        this.rd.drawImage(this.loadingmusic, 289, 205 + i_45_, null);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        int i_46_ = i - 1;
        if (i_46_ < 0)
            i_46_ = 32;
        if (!bool) {
            drawcs(340 + i_45_, new StringBuilder().append("").append(this.sndsize[i_46_]).append(" KB").toString(), 0, 0, 0, 3);
            drawcs(375 + i_45_, " Please Wait...", 0, 0, 0, 3);
        } else {
            drawcs(365 + i_45_, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            this.rd.drawImage(this.star[this.pstar], 359, 385 + i_45_, null);
            if (this.pstar != 2) {
                if (this.pstar == 0)
                    this.pstar = 1;
                else
                    this.pstar = 0;
            }
            if (this.multion != 0)
                drawcs(380 + i_45_, new StringBuilder().append("").append(this.forstart / 20).toString(), 0, 0, 0, 3);
        }
    }
    
    public void loadmusic(int i, String string, int i_47_) {
        hipnoload(i, false);
        this.app.setCursor(new Cursor(3));
        this.app.repaint();
        boolean bool = false;
        if (this.multion == 0) {
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 10)
                bool = true;
            if (i == 11 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20 || i == 22 || i == 23 || i == 26)
                bool = true;
            if (i < 0 && this.nplayers != 1 && this.newparts)
                bool = true;
        } else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 4 || i == 10)
            bool = true;
        if (bool) {
            this.runtyp = i;
            this.runner = new Thread(this);
            this.runner.start();
        }
        if (i == 1)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 240, 8400, 135, false, false);
        if (i == 2)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 190, 9000, 145, false, false);
        if (i == 3)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 170, 8500, 145, false, false);
        if (i == 4)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 205, 7500, 125, false, false);
        if (i == 5)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 170, 7900, 125, false, false);
        if (i == 6)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 370, 7900, 125, false, false);
        if (i == 7)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 205, 7500, 125, false, false);
        if (i == 8)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 230, 7900, 125, false, false);
        if (i == 9)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 180, 7900, 125, false, false);
        if (i == 10)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 280, 8100, 145, false, false);
        if (i == 11)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 120, 8000, 125, false, false);
        if (i == 12)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 260, 7200, 125, false, false);
        if (i == 13)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 270, 8000, 125, false, false);
        if (i == 14)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 190, 8000, 125, false, false);
        if (i == 15)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 162, 7800, 125, false, false);
        if (i == 16)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220, 7600, 125, false, false);
        if (i == 17)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 300, 7500, 125, false, false);
        if (i == 18)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200, 7900, 125, false, false);
        if (i == 19)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200, 7900, 125, false, false);
        if (i == 20)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 232, 7300, 125, false, false);
        if (i == 21)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 370, 7900, 125, false, false);
        if (i == 22)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 290, 7900, 125, false, false);
        if (i == 23)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 222, 7600, 125, false, false);
        if (i == 24)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 230, 8000, 125, false, false);
        if (i == 25)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220, 8000, 125, false, false);
        if (i == 26)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 261, 8000, 125, false, false);
        if (i == 27) {
            if (this.gmode == 2)
                this.strack = new RadicalMod("music/party.zip", 400, 7600, 125, false, false);
            else
                this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 276, 8800, 145, false, false);
        }
        if (i == 28)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 182, 8000, 125, false, false);
        if (i == 29)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220, 8000, 125, false, false);
        if (i == 30)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200, 8000, 125, false, false);
        if (i == 31)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 350, 7900, 125, false, false);
        if (i == 32)
            this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 310, 8000, 125, false, false);
        if (i < 0) {
            if (!string.equals("")) {
                if (i != -2)
                    this.strack = new RadicalMod(new StringBuilder().append("mystages/mymusic/").append(string).append(".zip").toString(), i_47_, 8000, 125, false, false);
                else
                    this.strack = new RadicalMod(string, i_47_, 8000, 125, false, true);
            } else
                this.strack = new RadicalMod();
        }
        this.loadedt = true;
        if (bool) {
            this.runner.stop();
            this.runner = null;
            this.runtyp = 0;
        }
        System.gc();
        if (this.multion == 0 && this.macn) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        if (!this.lan)
            this.strack.play();
        else if (this.im != 0) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        this.app.setCursor(new Cursor(0));
        this.pcontin = 0;
        this.mutem = false;
        this.mutes = false;
        this.fase = 6;
    }
    
    public void musicomp(int i, Control control) {
        hipnoload(i, true);
        if (this.multion != 0) {
            this.forstart--;
            if (this.lan && this.im == 0)
                this.forstart = 0;
        }
        if ((control).handb || (control).enter || this.forstart == 0) {
            System.gc();
            (this.m).trk = 0;
            (this.m).crs = false;
            (this.m).ih = 0;
            (this.m).iw = 0;
            (this.m).h = 450;
            (this.m).w = 800;
            (this.m).focus_point = 400;
            (this.m).cx = 400;
            (this.m).cy = 225;
            (this.m).cz = 50;
            this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            if (this.multion == 0)
                this.fase = 0;
            else {
                this.fase = 7001;
                this.forstart = 0;
                if (!this.lan) {
                    try {
                        this.socket = new Socket(this.server, this.servport);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                        this.runtyp = -101;
                        this.runner = new Thread(this);
                        this.runner.start();
                    } catch (Exception exception) {
                        /* empty */
                    }
                }
            }
            if (Math.random() > Math.random())
                this.dudo = 250;
            else
                this.dudo = 428;
            (control).handb = false;
            (control).enter = false;
        }
    }
    
    public void waitenter() {
        if (this.forstart < 690) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(70, "Waiting for all players to finish loading!", 0, 0, 0, 0);
            if (this.forstart <= 640)
                drawcs(90, new StringBuilder().append("").append((640 - this.forstart) / 32).append("").toString(), 0, 0, 0, 0);
            else
                drawcs(90, "Your connection to game may have been lost...", 0, 0, 0, 0);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            if (this.tflk) {
                drawcs(125, "Get Ready!", 0, 0, 0, 0);
                this.tflk = false;
            } else {
                drawcs(125, "Get Ready!", 0, 128, 255, 0);
                this.tflk = true;
            }
        }
        this.forstart++;
        if (this.forstart == 700) {
            this.fase = -2;
            this.winner = false;
        }
    }
    
    public void multistat(Control control, CheckPoints checkpoints, int i, int i_48_, boolean bool, UDPMistro udpmistro) {
        boolean bool_49_ = false;
        if (this.fase != -2) {
            if (this.exitm != 0 && !this.holdit) {
                if (!this.lan || this.im != 0) {
                    if (bool) {
                        if (i > 357 && i < 396 && i_48_ > 162 && i_48_ < 179)
                            this.exitm = 2;
                        else
                            this.exitm = 0;
                    }
                    float[] fs = new float[3];
                    Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2], fs);
                    fs[1] -= 0.15;
                    if (fs[1] < 0.0F)
                        fs[1] = 0.0F;
                    fs[2] += 0.15;
                    if (fs[2] > 1.0F)
                        fs[2] = 1.0F;
                    this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                    this.rd.fillRect(357, 169, 39, 10);
                    this.rd.fillRect(403, 169, 39, 10);
                    fs[1] -= 0.07;
                    if (fs[1] < 0.0F)
                        fs[1] = 0.0F;
                    fs[2] += 0.07;
                    if (fs[2] > 1.0F)
                        fs[2] = 1.0F;
                    this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                    this.rd.fillRect(357, 162, 39, 7);
                    this.rd.fillRect(403, 162, 39, 7);
                    drawhi(this.exitgame, 116);
                    if (i > 357 && i < 396 && i_48_ > 162 && i_48_ < 179) {
                        this.rd.setColor(new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]));
                        this.rd.fillRect(357, 162, 39, 17);
                    }
                    if (i > 403 && i < 442 && i_48_ > 162 && i_48_ < 179) {
                        this.rd.setColor(new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]));
                        this.rd.fillRect(403, 162, 39, 17);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Yes", 366, 175);
                    this.rd.drawString("No", 416, 175);
                    this.rd.setColor(new Color((this.m).csky[0] / 2, (this.m).csky[1] / 2, (this.m).csky[2] / 2));
                    this.rd.drawRect(403, 162, 39, 17);
                    this.rd.drawRect(357, 162, 39, 17);
                } else {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    drawcs(125, "You cannot exit game.  Your computer is the LAN server!", 0, 0, 0, 0);
                    this.msgflk++;
                    if (this.msgflk == 67 || bool) {
                        this.msgflk = 0;
                        this.exitm = 0;
                    }
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                }
            } else if (this.exitm == 4) {
                if (bool) {
                    if (i > 357 && i < 396 && i_48_ > 362 && i_48_ < 379) {
                        this.alocked = -1;
                        this.lalocked = -1;
                        this.multion = 2;
                        (control).multion = this.multion;
                        this.holdit = false;
                        this.exitm = 0;
                        (control).chatup = false;
                    }
                    if ((!this.lan || this.im != 0) && i > 403 && i < 442 && i_48_ > 362 && i_48_ < 379) {
                        this.holdcnt = 600;
                        this.exitm = 0;
                        (control).chatup = false;
                    }
                }
                float[] fs = new float[3];
                Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2], fs);
                fs[1] -= 0.15;
                if (fs[1] < 0.0F)
                    fs[1] = 0.0F;
                fs[2] += 0.15;
                if (fs[2] > 1.0F)
                    fs[2] = 1.0F;
                this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                this.rd.fillRect(357, 369, 39, 10);
                if (!this.lan || this.im != 0)
                    this.rd.fillRect(403, 369, 39, 10);
                fs[1] -= 0.07;
                if (fs[1] < 0.0F)
                    fs[1] = 0.0F;
                fs[2] += 0.07;
                if (fs[2] > 1.0F)
                    fs[2] = 1.0F;
                this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                this.rd.fillRect(357, 362, 39, 7);
                if (!this.lan || this.im != 0)
                    this.rd.fillRect(403, 362, 39, 7);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.lan && this.im == 0)
                    drawcs(140, "(You cannot exit game.  Your computer is the LAN server... )", 0, 0, 0, 0);
                this.rd.drawString("Continue watching this game?", 155, 375);
                if (i > 357 && i < 396 && i_48_ > 362 && i_48_ < 379) {
                    this.rd.setColor(new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]));
                    this.rd.fillRect(357, 362, 39, 17);
                }
                if ((!this.lan || this.im != 0) && i > 403 && i < 442 && i_48_ > 362 && i_48_ < 379) {
                    this.rd.setColor(new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]));
                    this.rd.fillRect(403, 362, 39, 17);
                }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("Yes", 366, 375);
                if (!this.lan || this.im != 0)
                    this.rd.drawString("No", 416, 375);
                this.rd.setColor(new Color((this.m).csky[0] / 2, (this.m).csky[1] / 2, (this.m).csky[2] / 2));
                if (!this.lan || this.im != 0)
                    this.rd.drawRoundRect(147, 357, 301, 27, 7, 20);
                else
                    this.rd.drawRoundRect(147, 357, 262, 27, 7, 20);
                this.rd.drawRect(357, 362, 39, 17);
                if (!this.lan || this.im != 0)
                    this.rd.drawRect(403, 362, 39, 17);
            }
            if (this.runtyp == -101 && !this.lan) {
                if (this.warning == 0 || this.warning == 210) {
                    boolean bool_50_ = false;
                    if (i > 5 && i < 90 && i_48_ > 423 && i_48_ < 446) {
                        bool_50_ = true;
                        if ((control).chatup)
                            (control).chatup = false;
                    } else if (this.pointc != 6) {
                        this.pointc = 6;
                        this.floater = 1;
                    }
                    if (i > 90 && i < 666 && i_48_ > 423 && i_48_ < 446 && this.lxm != i && i_48_ != this.lym && this.lxm != -100 && !(control).chatup) {
                        (control).chatup = true;
                        this.cntchatp = 0;
                    }
                    this.lxm = i;
                    this.lym = i_48_;
                    if (this.exitm != 0 && this.exitm != 4)
                        (control).chatup = false;
                    boolean bool_51_ = false;
                    if ((control).enter && (control).chatup) {
                        bool_51_ = true;
                        (control).chatup = false;
                        (control).enter = false;
                        this.lxm = -100;
                    }
                    if (bool) {
                        if (this.mouson == 0) {
                            if (i > 676 && i < 785 && i_48_ > 426 && i_48_ < 443 && (control).chatup)
                                bool_51_ = true;
                            if (bool_50_ && this.pointc > 0) {
                                this.pointc--;
                                this.floater = 1;
                            }
                            this.mouson = 1;
                        }
                        (control).chatup = false;
                    } else if (this.mouson != 0)
                        this.mouson = 0;
                    if (bool_51_) {
                        String string = "";
                        int i_52_ = 0;
                        int i_53_ = 1;
                        for (/**/; i_52_ < this.lcmsg.length(); i_52_++) {
                            String string_54_ = new StringBuilder().append("").append(this.lcmsg.charAt(i_52_)).toString();
                            if (string_54_.equals(" "))
                                i_53_++;
                            else
                                i_53_ = 0;
                            if (i_53_ < 2)
                                string = new StringBuilder().append(string).append(string_54_).toString();
                        }
                        if (!string.equals("")) {
                            string = string.replace('|', ':');
                            if (string.toLowerCase().indexOf((this.app).tpass.getText().toLowerCase()) != -1)
                                string = " ";
                            if (!msgcheck(string) && this.updatec > -12) {
                                if (this.cnames[6].equals("No Messages  "))
                                    this.cnames[6] = "";
                                for (int i_55_ = 0; i_55_ < 6; i_55_++) {
                                    this.sentn[i_55_] = this.sentn[i_55_ + 1];
                                    this.cnames[i_55_] = this.cnames[i_55_ + 1];
                                }
                                this.sentn[6] = string;
                                this.cnames[6] = this.nickname;
                                if (this.pointc != 6) {
                                    this.pointc = 6;
                                    this.floater = 1;
                                }
                                this.msgflk = 110;
                                if (this.updatec > -11)
                                    this.updatec = -11;
                                else
                                    this.updatec--;
                            } else
                                this.warning++;
                        }
                    }
                    if (bool_50_ || this.floater != 0 || (control).chatup || this.msgflk != 0) {
                        float[] fs = new float[3];
                        Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2], fs);
                        fs[1] -= 0.15;
                        if (fs[1] < 0.0F)
                            fs[1] = 0.0F;
                        fs[2] += 0.15;
                        if (fs[2] > 1.0F)
                            fs[2] = 1.0F;
                        this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                        this.rd.fillRect(90, 423, 704, 23);
                    }
                    if (!(control).chatup) {
                        if ((this.app).cmsg.isShowing()) {
                            (this.app).cmsg.hide();
                            this.app.requestFocus();
                        }
                        int i_56_ = 0;
                        int i_57_ = (int) (48.0F + 48.0F * ((float) (this.m).snap[1] / 100.0F));
                        if (i_57_ > 255)
                            i_57_ = 255;
                        if (i_57_ < 0)
                            i_57_ = 0;
                        int i_58_ = (int) (96.0F + 96.0F * ((float) (this.m).snap[2] / 100.0F));
                        if (i_58_ > 255)
                            i_58_ = 255;
                        if (i_58_ < 0)
                            i_58_ = 0;
                        if (this.floater != 0) {
                            for (int i_59_ = 6; i_59_ >= 0; i_59_--) {
                                if (this.pointc == i_59_) {
                                    if (Math.abs(i_56_ + this.movepos) > 10) {
                                        this.floater = (this.movepos + i_56_) / 4;
                                        if (this.floater > -5 && this.floater < 0)
                                            this.floater = -5;
                                        if (this.floater < 10 && this.floater > 0)
                                            this.floater = 10;
                                        this.movepos -= this.floater;
                                    } else {
                                        this.movepos = -i_56_;
                                        this.floater = 0;
                                    }
                                }
                                if (this.pointc >= i_59_) {
                                    this.rd.setColor(new Color(0, i_57_, i_58_));
                                    this.rd.setFont(new Font("Tahoma", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(new StringBuilder().append(this.cnames[i_59_]).append(": ").toString(), 96 + i_56_ + this.movepos, 439);
                                    i_56_ += this.ftm.stringWidth(new StringBuilder().append(this.cnames[i_59_]).append(": ").toString());
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(new StringBuilder().append(this.sentn[i_59_]).append("   ").toString(), 96 + i_56_ + this.movepos, 439);
                                    i_56_ += this.ftm.stringWidth(new StringBuilder().append(this.sentn[i_59_]).append("   ").toString());
                                } else {
                                    i_56_ += this.ftm.stringWidth(new StringBuilder().append(this.cnames[i_59_]).append(": ").toString());
                                    i_56_ += this.ftm.stringWidth(new StringBuilder().append(this.sentn[i_59_]).append("   ").toString());
                                }
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.fillRect(0, 423, 5, 24);
                            this.rd.fillRect(794, 423, 6, 24);
                        } else {
                            for (int i_60_ = this.pointc; i_60_ >= 0; i_60_--) {
                                if (i_60_ == 6 && this.msgflk != 0)
                                    this.msgflk--;
                                this.rd.setColor(new Color(0, i_57_, i_58_));
                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.ftm.stringWidth(new StringBuilder().append(this.cnames[i_60_]).append(": ").toString()) + 96 + i_56_ < 775) {
                                    if (i_60_ != 6 || this.msgflk < 67 || this.msgflk % 3 != 0)
                                        this.rd.drawString(new StringBuilder().append(this.cnames[i_60_]).append(": ").toString(), 96 + i_56_, 439);
                                    i_56_ += this.ftm.stringWidth(new StringBuilder().append(this.cnames[i_60_]).append(": ").toString());
                                } else {
                                    String string = "";
                                    for (int i_61_ = 0; this.ftm.stringWidth(string) + 96 + i_56_ < 775 && i_61_ < this.cnames[i_60_].length(); i_61_++)
                                        string = new StringBuilder().append(string).append(this.cnames[i_60_].charAt(i_61_)).toString();
                                    string = new StringBuilder().append(string).append("...").toString();
                                    if (i_60_ != 6 || this.msgflk < 67 || this.msgflk % 3 != 0)
                                        this.rd.drawString(string, 96 + i_56_, 439);
                                    break;
                                }
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.ftm.stringWidth(this.sentn[i_60_]) + 96 + i_56_ < 775) {
                                    if (i_60_ != 6 || this.msgflk < 67 || this.msgflk % 3 != 0)
                                        this.rd.drawString(new StringBuilder().append(this.sentn[i_60_]).append("   ").toString(), 96 + i_56_, 439);
                                    i_56_ += this.ftm.stringWidth(new StringBuilder().append(this.sentn[i_60_]).append("   ").toString());
                                } else {
                                    String string = "";
                                    for (int i_62_ = 0; this.ftm.stringWidth(string) + 96 + i_56_ < 775 && i_62_ < this.sentn[i_60_].length(); i_62_++)
                                        string = new StringBuilder().append(string).append(this.sentn[i_60_].charAt(i_62_)).toString();
                                    string = new StringBuilder().append(string).append("...").toString();
                                    if (i_60_ != 6 || this.msgflk < 67 || this.msgflk % 3 != 0)
                                        this.rd.drawString(string, 96 + i_56_, 439);
                                    break;
                                }
                            }
                        }
                    } else {
                        this.msgflk = 0;
                        bool_49_ = true;
                    }
                    if (bool_50_ || this.floater != 0) {
                        float[] fs = new float[3];
                        Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2], fs);
                        fs[1] -= 0.076;
                        if (fs[1] < 0.0F)
                            fs[1] = 0.0F;
                        fs[2] += 0.076;
                        if (fs[2] > 1.0F)
                            fs[2] = 1.0F;
                        this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
                        this.rd.fillRect(5, 423, 85, 23);
                    }
                    if (bool_50_) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawLine(36, 440, 65, 440);
                    } else
                        this.rd.setColor(new Color((int) ((float) (this.m).cgrnd[0] / 2.5F), (int) ((float) (this.m).cgrnd[1] / 2.5F), (int) ((float) (this.m).cgrnd[2] / 2.5F)));
                    this.rd.setFont(new Font("Tahoma", 1, 11));
                    this.rd.drawString("<<   Scroll", 9, 439);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRect(5, 423, 789, 23);
                    this.rd.drawLine(90, 423, 90, 446);
                    if (i > 775 && i < 794 && i_48_ > 409 && i_48_ < 423) {
                        this.rd.drawRect(775, 409, 19, 14);
                        this.rd.setColor(new Color(200, 0, 0));
                        if (bool) {
                            (control).chatup = false;
                            if ((this.app).cmsg.isShowing()) {
                                (this.app).cmsg.hide();
                                this.app.requestFocus();
                            }
                            this.runtyp = 0;
                            try {
                                this.socket.close();
                                this.socket = null;
                                this.din.close();
                                this.din = null;
                                this.dout.close();
                                this.dout = null;
                            } catch (Exception exception) {
                                /* empty */
                            }
                        }
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("x", 782, 420);
                } else {
                    drawWarning();
                    if ((this.app).cmsg.isShowing()) {
                        (this.app).cmsg.hide();
                        this.app.requestFocus();
                    }
                    this.warning++;
                }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            } else if ((control).chatup) {
                (control).chatup = false;
                if (!this.lan) {
                    this.runtyp = -101;
                    if (this.runner != null)
                        this.runner.stop();
                    this.runner = new Thread(this);
                    this.runner.start();
                }
            }
            if ((control).arrace && this.starcnt < 38 && !this.holdit && (checkpoints).stage != 10 || this.multion >= 2) {
                if (this.alocked != -1 && (checkpoints).dested[this.alocked] != 0) {
                    this.alocked = -1;
                    this.lalocked = -1;
                }
                if (this.multion >= 2) {
                    if (this.alocked == -1 || this.holdit) {
                        if (this.cntflock == 100) {
                            for (int i_63_ = 0; i_63_ < this.nplayers; i_63_++) {
                                if (this.holdit) {
                                    if ((checkpoints).pos[i_63_] == 0) {
                                        this.alocked = i_63_;
                                        this.im = i_63_;
                                    }
                                } else if ((checkpoints).dested[i_63_] == 0) {
                                    this.alocked = i_63_;
                                    this.im = i_63_;
                                }
                            }
                        }
                        this.cntflock++;
                    } else
                        this.cntflock = 0;
                    if (this.lan) {
                        boolean bool_64_ = true;
                        for (int i_65_ = 0; i_65_ < this.nplayers; i_65_++) {
                            if (this.dested[i_65_] == 0 && this.plnames[i_65_].indexOf("MadBot") == -1)
                                bool_64_ = false;
                        }
                        if (bool_64_)
                            this.exitm = 2;
                    }
                }
                int i_66_ = this.nplayers;
                for (int i_67_ = 0; i_67_ < i_66_; i_67_++) {
                    boolean bool_68_ = false;
                    for (int i_69_ = 0; i_69_ < this.nplayers; i_69_++) {
                        if ((checkpoints).pos[i_69_] == i_67_ && (checkpoints).dested[i_69_] == 0 && !bool_68_) {
                            this.rd.setColor(new Color(0, 0, 100));
                            if (i_67_ == 0)
                                this.rd.drawString("1st", 673, 76 + 30 * i_67_);
                            if (i_67_ == 1)
                                this.rd.drawString("2nd", 671, 76 + 30 * i_67_);
                            if (i_67_ == 2)
                                this.rd.drawString("3rd", 671, 76 + 30 * i_67_);
                            if (i_67_ >= 3)
                                this.rd.drawString(new StringBuilder().append("").append(i_67_ + 1).append("th").toString(), 671, 76 + 30 * i_67_);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString(this.plnames[i_69_], 730 - this.ftm.stringWidth(this.plnames[i_69_]) / 2, 70 + 30 * i_67_);
                            int i_70_ = (int) (60.0F * (checkpoints).magperc[i_69_]);
                            int i_71_ = 244;
                            int i_72_ = 244;
                            int i_73_ = 11;
                            if (i_70_ > 20)
                                i_72_ = (int) (244.0F - 233.0F * ((float) (i_70_ - 20) / 40.0F));
                            i_71_ += (float) i_71_ * ((float) (this.m).snap[0] / 100.0F);
                            if (i_71_ > 255)
                                i_71_ = 255;
                            if (i_71_ < 0)
                                i_71_ = 0;
                            i_72_ += (float) i_72_ * ((float) (this.m).snap[1] / 100.0F);
                            if (i_72_ > 255)
                                i_72_ = 255;
                            if (i_72_ < 0)
                                i_72_ = 0;
                            i_73_ += (float) i_73_ * ((float) (this.m).snap[2] / 100.0F);
                            if (i_73_ > 255)
                                i_73_ = 255;
                            if (i_73_ < 0)
                                i_73_ = 0;
                            this.rd.setColor(new Color(i_71_, i_72_, i_73_));
                            this.rd.fillRect(700, 74 + 30 * i_67_, i_70_, 5);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRect(700, 74 + 30 * i_67_, 60, 5);
                            boolean bool_74_ = false;
                            if ((this.im != i_69_ || this.multion >= 2) && i > 661 && i < 775 && i_48_ > 58 + 30 * i_67_ && i_48_ < 83 + 30 * i_67_) {
                                bool_74_ = true;
                                if (bool) {
                                    if (!this.onlock) {
                                        if (this.alocked != i_69_ || this.multion >= 2) {
                                            this.alocked = i_69_;
                                            if (this.multion >= 2)
                                                this.im = i_69_;
                                        } else
                                            this.alocked = -1;
                                    }
                                    this.onlock = true;
                                } else if (this.onlock)
                                    this.onlock = false;
                            }
                            if (this.alocked == i_69_) {
                                i_71_ = (int) (159.0F + 159.0F * ((float) (this.m).snap[0] / 100.0F));
                                if (i_71_ > 255)
                                    i_71_ = 255;
                                if (i_71_ < 0)
                                    i_71_ = 0;
                                i_72_ = (int) (207.0F + 207.0F * ((float) (this.m).snap[1] / 100.0F));
                                if (i_72_ > 255)
                                    i_72_ = 255;
                                if (i_72_ < 0)
                                    i_72_ = 0;
                                i_73_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 100.0F));
                                if (i_73_ > 255)
                                    i_73_ = 255;
                                if (i_73_ < 0)
                                    i_73_ = 0;
                                this.rd.setColor(new Color(i_71_, i_72_, i_73_));
                                this.rd.drawRect(661, 58 + 30 * i_67_, 114, 25);
                                this.rd.drawRect(662, 59 + 30 * i_67_, 112, 23);
                            }
                            if (bool_74_ && !this.onlock) {
                                if (this.alocked == i_69_) {
                                    i_71_ = (int) (120.0F + 120.0F * ((float) (this.m).snap[0] / 100.0F));
                                    if (i_71_ > 255)
                                        i_71_ = 255;
                                    if (i_71_ < 0)
                                        i_71_ = 0;
                                    i_72_ = (int) (114.0F + 114.0F * ((float) (this.m).snap[1] / 100.0F));
                                    if (i_72_ > 255)
                                        i_72_ = 255;
                                    if (i_72_ < 0)
                                        i_72_ = 0;
                                    i_73_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 100.0F));
                                    if (i_73_ > 255)
                                        i_73_ = 255;
                                    if (i_73_ < 0)
                                        i_73_ = 0;
                                } else {
                                    i_71_ = (int) (140.0F + 140.0F * ((float) (this.m).snap[0] / 100.0F));
                                    if (i_71_ > 255)
                                        i_71_ = 255;
                                    if (i_71_ < 0)
                                        i_71_ = 0;
                                    i_72_ = (int) (160.0F + 160.0F * ((float) (this.m).snap[1] / 100.0F));
                                    if (i_72_ > 255)
                                        i_72_ = 255;
                                    if (i_72_ < 0)
                                        i_72_ = 0;
                                    i_73_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 100.0F));
                                    if (i_73_ > 255)
                                        i_73_ = 255;
                                    if (i_73_ < 0)
                                        i_73_ = 0;
                                }
                                this.rd.setColor(new Color(i_71_, i_72_, i_73_));
                                this.rd.drawRect(660, 57 + 30 * i_67_, 116, 27);
                            }
                            bool_68_ = true;
                        }
                    }
                }
            }
            if ((udpmistro).go && (udpmistro).runon == 1 && !this.holdit) {
                int i_75_ = 0;
                int i_76_ = 0;
                for (int i_77_ = 0; i_77_ < this.nplayers; i_77_++) {
                    if (i_77_ != (udpmistro).im) {
                        i_76_++;
                        if ((udpmistro).lframe[i_77_] == (udpmistro).lcframe[i_77_] || (udpmistro).force[i_77_] == 7)
                            i_75_++;
                        else
                            (udpmistro).lcframe[i_77_] = (udpmistro).lframe[i_77_];
                    }
                }
                if (i_75_ == i_76_)
                    this.discon++;
                else if (this.discon != 0)
                    this.discon = 0;
                if (this.discon == 240)
                    (udpmistro).runon = 2;
            }
        }
        if (bool_49_) {
            float[] fs = new float[3];
            Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2], fs);
            fs[1] -= 0.22;
            if (fs[1] < 0.0F)
                fs[1] = 0.0F;
            fs[2] += 0.22;
            if (fs[2] > 1.0F)
                fs[2] = 1.0F;
            Color color = Color.getHSBColor(fs[0], fs[1], fs[2]);
            if (!(this.app).cmsg.isShowing()) {
                (this.app).cmsg.show();
                (this.app).cmsg.requestFocus();
                this.lcmsg = "";
                (this.app).cmsg.setText("");
                (this.app).cmsg.setBackground(color);
            }
            this.app.movefield((this.app).cmsg, 91, 424, 576, 22);
            this.rd.setColor(color);
            this.rd.fillRect(676, 426, 109, 7);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Tahoma", 1, 11));
            this.rd.drawString("Send Message  >", 684, 439);
            this.rd.drawRect(676, 426, 109, 17);
            if ((this.app).cmsg.getText().equals(this.lcmsg))
                this.cntchatp++;
            else
                this.cntchatp = -200;
            this.lcmsg = new StringBuilder().append("").append((this.app).cmsg.getText()).toString();
            if (this.cntchatp == 67)
                (control).chatup = false;
            if ((this.app).cmsg.getText().length() > 100) {
                (this.app).cmsg.setText((this.app).cmsg.getText().substring(0, 100));
                (this.app).cmsg.select(100, 100);
            }
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
        }
    }
    
    public void stopchat() {
        if (this.runtyp == -101) {
            this.runtyp = 0;
            try {
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            } catch (Exception exception) {
                /* empty */
            }
        }
    }
    
    public void levelhigh(int i, int i_78_, int i_79_, int i_80_, int i_81_) {
        this.rd.drawImage(this.gameh, 301, 20, null);
        int i_82_ = 16;
        int i_83_ = 48;
        int i_84_ = 96;
        if (i_80_ < 50) {
            if (this.aflk) {
                i_82_ = 106;
                i_83_ = 176;
                i_84_ = 255;
                this.aflk = false;
            } else
                this.aflk = true;
        }
        if (i != this.im) {
            if (i_79_ == 0)
                drawcs(60, "You Wasted 'em!", i_82_, i_83_, i_84_, 0);
            else if (i_79_ == 1)
                drawcs(60, "Close Finish!", i_82_, i_83_, i_84_, 0);
            else
                drawcs(60, "Close Finish!  Almost got it!", i_82_, i_83_, i_84_, 0);
        } else if (i_78_ == 229) {
            if (this.discon != 240)
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
        if (this.flipo == 0)
            this.flipo = 1;
        if (this.flipo == 2) {
            this.flipo = 3;
            this.dudo = 200;
        }
        if (this.flipo == 4) {
            this.flipo = 5;
            this.dudo = 250;
        }
        if (this.flipo == 6) {
            this.flipo = 7;
            this.dudo = 200;
        }
        if (this.flipo == 8) {
            this.flipo = 9;
            this.dudo = 250;
        }
        if (this.flipo == 10) {
            this.flipo = 11;
            this.dudo = 200;
        }
        if (this.flipo == 12) {
            this.flipo = 13;
            this.dudo = 200;
        }
        if (this.flipo == 14) {
            this.flipo = 15;
            this.dudo = 100;
        }
        mainbg(2);
        if (this.aflk)
            this.aflk = false;
        else
            this.aflk = true;
        if (this.flipo != 1 && this.flipo != 16) {
            if (this.dudo > 0) {
                if (this.aflk) {
                    if (Math.random() > Math.random())
                        this.duds = (int) (Math.random() * 3.0);
                    else
                        this.duds = (int) (Math.random() * 2.0);
                }
                this.dudo--;
            } else
                this.duds = 0;
            this.rd.drawImage(this.dude[this.duds], 95, 15, null);
            this.rd.drawImage(this.oflaot, 192, 42, null);
        }
        this.rd.setColor(new Color(0, 64, 128));
        this.rd.setFont(new Font("Arial", 1, 13));
        if (this.flipo == 3 || this.flipo == 5) {
            if (this.flipo == 3) {
                this.rd.drawString("Hello!  Welcome to the world of", 262, 67);
                this.rd.drawString("!", 657, 67);
                this.rd.drawImage(this.nfm, 469, 55, null);
                this.rd.drawString("In this game there are two ways to complete a stage.", 262, 107);
                this.rd.drawString("One is by racing and finishing in first place, the other is by", 262, 127);
                this.rd.drawString("wasting and crashing all the other cars in the stage!", 262, 147);
            } else {
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("While racing, you will need to focus on going fast and passing", 262, 67);
                this.rd.drawString("through all the checkpoints in the track. To complete a lap, you", 262, 87);
                this.rd.drawString("must not miss a checkpoint.", 262, 107);
                this.rd.drawString("While wasting, you will just need to chase the other cars and", 262, 127);
                this.rd.drawString("crash into them (without worrying about track and checkpoints).", 262, 147);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.racing, 165, 185, null);
            this.rd.drawImage(this.ory, 429, 235, null);
            this.rd.drawImage(this.wasting, 492, 185, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("Checkpoint", 392, 189);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString("Drive your car using the Arrow Keys and Spacebar", 125, 320);
            this.rd.drawImage(this.space, 171, 355, null);
            this.rd.drawImage(this.arrows, 505, 323, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 125, 341);
            this.rd.drawString("Accelerate", 515, 319);
            this.rd.drawString("Brake/Reverse", 506, 397);
            this.rd.drawString("Turn left", 454, 375);
            this.rd.drawString("Turn right", 590, 375);
            this.rd.drawString("Handbrake", 247, 374);
        }
        if (this.flipo == 7 || this.flipo == 9) {
            if (this.flipo == 7) {
                this.rd.drawString("Whether you are racing or wasting the other cars you will need", 262, 67);
                this.rd.drawString("to power up your car.", 262, 87);
                this.rd.drawString("=> More 'Power' makes your car become faster and stronger!", 262, 107);
                this.rd.drawString("To power up your car (and keep it powered up) you will need to", 262, 127);
                this.rd.drawString("perform stunts!", 262, 147);
                this.rd.drawImage(this.chil, 167, 295, null);
            } else {
                this.rd.drawString("The better the stunt the more power you get!", 262, 67);
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("Forward looping pushes your car forwards in the air and helps", 262, 87);
                this.rd.drawString("when racing. Backward looping pushes your car upwards giving it", 262, 107);
                this.rd.drawString("more hang time in the air making it easier to control its landing.", 262, 127);
                this.rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 262, 147);
                if (this.aflk || this.dudo < 150)
                    this.rd.drawImage(this.chil, 167, 295, null);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.stunts, 105, 175, null);
            this.rd.drawImage(this.opwr, 540, 253, null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString("To perform stunts. When your car is in the AIR:", 125, 310);
            this.rd.drawString("Press combo Spacebar + Arrow Keys", 125, 330);
            this.rd.drawImage(this.space, 185, 355, null);
            this.rd.drawImage(this.plus, 405, 358, null);
            this.rd.drawImage(this.arrows, 491, 323, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 492, 319);
            this.rd.drawString("Backward Loop", 490, 397);
            this.rd.drawString("Left Roll", 443, 375);
            this.rd.drawString("Right Roll", 576, 375);
            this.rd.drawString("Spacebar", 266, 374);
            this.rd.setColor(new Color(140, 243, 244));
            this.rd.fillRect(602, 257, 76, 9);
        }
        if (this.flipo == 11 || this.flipo == 13) {
            if (this.flipo == 11) {
                this.rd.drawString("When wasting cars, to help you find the other cars in the stage,", 262, 67);
                this.rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 262, 87);
                this.rd.drawString("to pointing to the cars.", 262, 107);
                this.rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 262, 127);
                this.rd.drawString("jumping through the electrified hoop.", 262, 147);
            } else {
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("You will find that in some stages it's easier to waste the other cars", 262, 67);
                this.rd.drawString("and in some others it's easier to race and finish in first place.", 262, 87);
                this.rd.drawString("It is up to you to decide when to waste and when to race.", 262, 107);
                this.rd.drawString("And remember, 'Power' is an important factor in the game. You", 262, 127);
                this.rd.drawString("will need it whether you are racing or wasting!", 262, 147);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.fixhoop, 185, 218, null);
            this.rd.drawImage(this.sarrow, 385, 228, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("The Electrified Hoop", 192, 216);
            this.rd.drawString("Jumping through it fixes your car.", 158, 338);
            this.rd.drawString("Make guidance arrow point to cars.", 385, 216);
        }
        if (this.flipo == 15) {
            this.rd.drawString("And if you don\u2019t know who I am,", 262, 67);
            this.rd.drawString("I am Coach Insano, I am the coach and narrator of this game!", 262, 87);
            this.rd.drawString("I recommended to starting with NFM 1, if it\u2019s your first time to play.", 262, 127);
            this.rd.drawString("Good Luck & Have Fun!", 262, 147);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Other Controls :", 155, 205);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawImage(this.kz, 169, 229, null);
            this.rd.drawString("OR", 206, 251);
            this.rd.drawImage(this.kx, 229, 229, null);
            this.rd.drawString("To look behind you while driving.", 267, 251);
            this.rd.drawImage(this.kv, 169, 279, null);
            this.rd.drawString("Change Views", 207, 301);
            this.rd.drawImage(this.kenter, 169, 329, null);
            this.rd.drawString("Navigate & Pause Game", 275, 351);
            this.rd.drawImage(this.km, 489, 229, null);
            this.rd.drawString("Mute Music", 527, 251);
            this.rd.drawImage(this.kn, 489, 279, null);
            this.rd.drawString("Mute Sound Effects", 527, 301);
        }
        if (this.flipo == 1 || this.flipo == 16) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.flipo == 16) {
                this.rd.drawImage(this.mrc, 268, 32, null);
                this.rd.drawString("Once Again!", 455, 49);
            } else
                this.rd.drawImage(this.mrc, 310, 32, null);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Drive your car using the Arrow Keys:", 125, 80);
            this.rd.drawString("On the GROUND Spacebar is for Handbrake", 125, 101);
            this.rd.drawImage(this.space, 171, 115, null);
            this.rd.drawImage(this.arrows, 505, 83, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Accelerate", 515, 79);
            this.rd.drawString("Brake/Reverse", 506, 157);
            this.rd.drawString("Turn left", 454, 135);
            this.rd.drawString("Turn right", 590, 135);
            this.rd.drawString("Handbrake", 247, 134);
            drawcs(175, "----------------------------------------------------------------------------------------------------------------------------------------------------", 0, 64, 128, 3);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("To perform STUNTS:", 125, 200);
            this.rd.drawString("In the AIR press combo Spacebar + Arrow Keys", 125, 220);
            this.rd.drawImage(this.space, 185, 245, null);
            this.rd.drawImage(this.plus, 405, 248, null);
            this.rd.drawImage(this.arrows, 491, 213, null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 492, 209);
            this.rd.drawString("Backward Loop", 490, 287);
            this.rd.drawString("Left Roll", 443, 265);
            this.rd.drawString("Right Roll", 576, 265);
            this.rd.drawString("Spacebar", 266, 264);
            this.rd.drawImage(this.stunts, 125, 285, null);
        }
        if (this.flipo >= 1 && this.flipo <= 15)
            this.rd.drawImage(this.next[this.pnext], 665, 395, null);
        if (this.flipo >= 3 && this.flipo <= 16)
            this.rd.drawImage(this.back[this.pback], 75, 395, null);
        if (this.flipo == 16)
            this.rd.drawImage(this.contin[this.pcontin], 565, 395, null);
        if ((control).enter || (control).right) {
            if ((control).enter && this.flipo == 16) {
                this.flipo = 0;
                this.fase = this.oldfase;
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
            (control).enter = false;
            (control).right = false;
            if (this.flipo >= 1 && this.flipo <= 15)
                this.flipo++;
        }
        if ((control).left) {
            if (this.flipo >= 3 && this.flipo <= 15)
                this.flipo -= 3;
            if (this.flipo == 16)
                this.flipo--;
            (control).left = false;
        }
    }
    
    public void maini(Control control) {
        if (this.flipo == 0)
            this.app.setCursor(new Cursor(0));
        mainbg(1);
        if (this.flipo > this.flkat)
            this.rd.drawImage(this.logomadbg, 132 + (int) (4.0 - Math.random() * 8.0), 168 + (int) (4.0 - Math.random() * 8.0), null);
        else
            this.rd.drawImage(this.logomadbg, 132, 168, null);
        this.rd.drawImage(this.dude[0], this.xdu, this.ydu, null);
        this.rd.drawImage(this.logocars, 77, 53, null);
        if (this.flipo > this.flkat)
            this.rd.drawImage(this.logomadnes, 164 + (int) (4.0 - Math.random() * 8.0), 173 + (int) (4.0 - Math.random() * 8.0), null);
        else
            this.rd.drawImage(this.logomadnes, 164, 173, null);
        this.flipo++;
        if (this.flipo > this.flkat + 36) {
            this.flipo = 1;
            this.flkat = (int) (60.0 + 140.0 * Math.random());
        }
        if (this.movly <= 10) {
            if (this.movly == 10 || this.movly == 8 || this.movly == 6 || this.movly == 4 || this.movly == 2) {
                this.gxdu = (int) ((double) (this.xdu + 200) - 400.0 * Math.random());
                this.gydu = (int) ((double) (this.ydu + 200) - 400.0 * Math.random());
                if (this.movly == 2) {
                    this.gxdu = 337;
                    this.gydu = 27;
                }
                this.movly--;
            }
            this.xdu += (this.gxdu - this.xdu) / 15;
            this.ydu += (this.gydu - this.ydu) / 15;
            if (this.movly != 1) {
                if (pys(this.xdu, this.gxdu, this.ydu, this.gydu) < 20.0F)
                    this.movly--;
            } else {
                if (this.xdu > this.gxdu)
                    this.xdu--;
                else
                    this.xdu++;
                if (this.ydu > this.gydu)
                    this.ydu--;
                else
                    this.ydu++;
                if (pys(this.xdu, this.gxdu, this.ydu, this.gydu) < 2.0F)
                    this.movly--;
            }
            if (this.movly == 0) {
                this.xdu = 337;
                this.ydu = 27;
                this.movly = (int) (100.0 + 100.0 * Math.random());
            }
        } else if (this.flipo >= this.movly)
            this.movly = 10;
        this.rd.drawImage(this.opback, 247, 237, null);
        if (this.muhi < 0) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRoundRect(335, 293, 114, 19, 7, 20);
        }
        this.muhi--;
        if (this.muhi < -5)
            this.muhi = 50;
        if ((control).up) {
            this.opselect--;
            if (this.opselect == -1)
                this.opselect = 3;
            (control).up = false;
        }
        if ((control).down) {
            this.opselect++;
            if (this.opselect == 4)
                this.opselect = 0;
            (control).down = false;
        }
        if (this.opselect == 0) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(343, 261, 110, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 255, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(343, 261, 110, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(343, 261, 110, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(288, 291, 221, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 191, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 95, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(288, 291, 221, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(288, 291, 221, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(301, 321, 196, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 128, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(301, 321, 196, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(301, 321, 196, 22, 7, 20);
        }
        if (this.opselect == 3) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(357, 351, 85, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 0, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(357, 351, 85, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(357, 351, 85, 22, 7, 20);
        }
        this.rd.drawImage(this.opti, 294, 265, null);
        if ((control).enter || (control).handb) {
            if (this.opselect == 1) {
                this.mtop = true;
                this.multion = 1;
                this.gmode = 0;
                if (this.firstime) {
                    this.oldfase = -9;
                    this.fase = 11;
                    this.firstime = false;
                } else
                    this.fase = -9;
            }
            if (this.opselect == 2) {
                this.oldfase = 10;
                this.fase = 11;
                this.firstime = false;
            }
            if (this.opselect == 3)
                this.fase = 8;
            if (this.opselect == 0) {
                if (this.unlocked[0] == 11) {
                    if (this.unlocked[1] != 17)
                        this.opselect = 1;
                    else
                        this.opselect = 2;
                }
                if (this.firstime) {
                    this.oldfase = 102;
                    this.fase = 11;
                    this.firstime = false;
                } else
                    this.fase = 102;
            }
            this.flipo = 0;
            (control).enter = false;
            (control).handb = false;
        }
        this.rd.drawImage(this.byrd, 72, 408, null);
        this.rd.drawImage(this.nfmcoms, 532, 408, null);
        if (this.shaded) {
            this.app.repaint();
            try {
                Thread.sleep(200L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
    }
    
    public void maini2(Control control, int i, int i_85_, int i_86_) {
        mainbg(1);
        if (this.flipo > this.flkat)
            this.rd.drawImage(this.logomadbg, 132 + (int) (4.0 - Math.random() * 8.0), 168 + (int) (4.0 - Math.random() * 8.0), null);
        else
            this.rd.drawImage(this.logomadbg, 132, 168, null);
        this.rd.drawImage(this.dude[0], this.xdu, this.ydu, null);
        this.rd.drawImage(this.logocars, 77, 53, null);
        if (this.flipo > this.flkat)
            this.rd.drawImage(this.logomadnes, 164 + (int) (4.0 - Math.random() * 8.0), 173 + (int) (4.0 - Math.random() * 8.0), null);
        else
            this.rd.drawImage(this.logomadnes, 164, 173, null);
        this.flipo++;
        if (this.flipo > this.flkat + 36) {
            this.flipo = 1;
            this.flkat = (int) (60.0 + 140.0 * Math.random());
        }
        if (this.movly <= 10) {
            if (this.movly == 10 || this.movly == 8 || this.movly == 6 || this.movly == 4 || this.movly == 2) {
                this.gxdu = (int) ((double) (this.xdu + 200) - 400.0 * Math.random());
                this.gydu = (int) ((double) (this.ydu + 200) - 400.0 * Math.random());
                if (this.movly == 2) {
                    this.gxdu = 337;
                    this.gydu = 27;
                }
                this.movly--;
            }
            this.xdu += (this.gxdu - this.xdu) / 15;
            this.ydu += (this.gydu - this.ydu) / 15;
            if (this.movly != 1) {
                if (pys(this.xdu, this.gxdu, this.ydu, this.gydu) < 20.0F)
                    this.movly--;
            } else {
                if (this.xdu > this.gxdu)
                    this.xdu--;
                else
                    this.xdu++;
                if (this.ydu > this.gydu)
                    this.ydu--;
                else
                    this.ydu++;
                if (pys(this.xdu, this.gxdu, this.ydu, this.gydu) < 2.0F)
                    this.movly--;
            }
            if (this.movly == 0) {
                this.xdu = 337;
                this.ydu = 27;
                this.movly = (int) (100.0 + 100.0 * Math.random());
            }
        } else if (this.flipo >= this.movly)
            this.movly = 10;
        this.rd.drawImage(this.opback, 247, 237, null);
        if ((control).up) {
            this.opselect--;
            if (this.opselect == -1)
                this.opselect = 3 - this.dropf / 15;
            (control).up = false;
        }
        if ((control).down) {
            this.opselect++;
            if (this.opselect == 4 - this.dropf / 15)
                this.opselect = 0;
            (control).down = false;
        }
        if (this.opselect == 0) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(358, 262 + this.dropf, 82, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 64, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(358, 262 + this.dropf, 82, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(358, 262 + this.dropf, 82, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(358, 290 + this.dropf, 82, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 64, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 95, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(358, 290 + this.dropf, 82, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(358, 290 + this.dropf, 82, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(333, 318 + this.dropf, 132, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 255, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(333, 318 + this.dropf, 132, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(333, 318 + this.dropf, 132, 22, 7, 20);
        }
        if (this.dropf == 0) {
            if (this.opselect == 3) {
                if (this.shaded) {
                    this.rd.setColor(new Color(140, 70, 0));
                    this.rd.fillRect(348, 346, 102, 22);
                    this.aflk = false;
                }
                if (this.aflk) {
                    this.rd.setColor(new Color(200, 64, 0));
                    this.aflk = false;
                } else {
                    this.rd.setColor(new Color(255, 128, 0));
                    this.aflk = true;
                }
                this.rd.drawRoundRect(348, 346, 102, 22, 7, 20);
            } else {
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(348, 346, 102, 22, 7, 20);
            }
        }
        this.rd.drawImage(this.opti2, 346, 265 + this.dropf, null);
        if (this.dropf != 0) {
            this.rd.setColor(new Color(58, 30, 8));
            this.rd.fillRect(357, 365, 87, 15);
        }
        if ((control).enter || (control).handb) {
            this.mtop = false;
            if (this.opselect == 0) {
                this.multion = 0;
                this.gmode = 1;
                this.fase = -9;
            }
            if (this.opselect == 1) {
                this.multion = 0;
                this.gmode = 2;
                this.fase = -9;
                this.opselect = 0;
            }
            if (this.dropf == 0 && this.opselect == 3) {
                this.multion = 0;
                this.gmode = 0;
                this.fase = -9;
                this.opselect = 0;
            }
            if (this.opselect == 2) {
                this.multion = 1;
                this.gmode = 0;
                if (this.firstime) {
                    this.oldfase = -9;
                    this.fase = 11;
                    this.firstime = false;
                } else
                    this.fase = -9;
            }
            this.flipo = 0;
            (control).enter = false;
            (control).handb = false;
        }
        this.rd.drawImage(this.byrd, 72, 408, null);
        this.rd.drawImage(this.nfmcoms, 532, 408, null);
        boolean bool = false;
        if (i_86_ == 2)
            bool = true;
        if (drawcarb(true, null, "   < Back   ", 161, 313, i, i_85_, bool)) {
            this.opselect = 0;
            this.fase = 10;
        }
        if (this.shaded) {
            this.app.repaint();
            try {
                Thread.sleep(200L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
    }
    
    public void pausedgame(int i, Control control, Record record) {
        if (!this.badmac)
            this.rd.drawImage(this.fleximg, 0, 0, null);
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setColor(new Color(30, 67, 110));
            this.rd.fillRect(281, 8, 237, 188);
        }
        if ((control).up) {
            this.opselect--;
            if (this.opselect == -1)
                this.opselect = 3;
            (control).up = false;
        }
        if ((control).down) {
            this.opselect++;
            if (this.opselect == 4)
                this.opselect = 0;
            (control).down = false;
        }
        if (this.opselect == 0) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(329, 45, 137, 22, 7, 20);
            if (this.shaded)
                this.rd.setColor(new Color(225, 200, 255));
            else
                this.rd.setColor(new Color(0, 89, 223));
            this.rd.drawRoundRect(329, 45, 137, 22, 7, 20);
        }
        if (this.opselect == 1) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(320, 73, 155, 22, 7, 20);
            if (this.shaded)
                this.rd.setColor(new Color(225, 200, 255));
            else
                this.rd.setColor(new Color(0, 89, 223));
            this.rd.drawRoundRect(320, 73, 155, 22, 7, 20);
        }
        if (this.opselect == 2) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(303, 99, 190, 22, 7, 20);
            if (this.shaded)
                this.rd.setColor(new Color(225, 200, 255));
            else
                this.rd.setColor(new Color(0, 89, 223));
            this.rd.drawRoundRect(303, 99, 190, 22, 7, 20);
        }
        if (this.opselect == 3) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(341, 125, 109, 22, 7, 20);
            if (this.shaded)
                this.rd.setColor(new Color(225, 200, 255));
            else
                this.rd.setColor(new Color(0, 89, 223));
            this.rd.drawRoundRect(341, 125, 109, 22, 7, 20);
        }
        this.rd.drawImage(this.paused, 281, 8, null);
        if ((control).enter || (control).handb) {
            if (this.opselect == 0) {
                if (this.loadedt && !this.mutem)
                    this.strack.resume();
                this.fase = 0;
            }
            if (this.opselect == 1) {
                if ((record).caught >= 300) {
                    if (this.loadedt && !this.mutem)
                        this.strack.resume();
                    this.fase = -1;
                } else
                    this.fase = -8;
            }
            if (this.opselect == 2) {
                if (this.loadedt)
                    this.strack.stop();
                this.oldfase = -7;
                this.fase = 11;
            }
            if (this.opselect == 3) {
                if (this.loadedt)
                    this.strack.unload();
                this.fase = 102;
                if (this.gmode == 0)
                    this.opselect = 3;
                if (this.gmode == 1)
                    this.opselect = 0;
                if (this.gmode == 2)
                    this.opselect = 1;
                this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            }
            (control).enter = false;
            (control).handb = false;
        }
    }
    
    public void replyn() {
        if (this.aflk) {
            drawcs(30, "Replay  > ", 0, 0, 0, 0);
            this.aflk = false;
        } else {
            drawcs(30, "Replay  >>", 0, 128, 255, 0);
            this.aflk = true;
        }
    }
    
    public void cantreply() {
        this.rd.setColor(new Color(64, 143, 223));
        this.rd.fillRoundRect(200, 73, 400, 23, 7, 20);
        this.rd.setColor(new Color(0, 89, 223));
        this.rd.drawRoundRect(200, 73, 400, 23, 7, 20);
        drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }
    
    public void nofocus() {
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(0, 0, 800, 20);
        this.rd.fillRect(0, 0, 20, 450);
        this.rd.fillRect(0, 430, 800, 20);
        this.rd.fillRect(780, 0, 20, 450);
        this.rd.setColor(new Color(192, 192, 192));
        this.rd.drawRect(20, 20, 760, 410);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRect(22, 22, 756, 406);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        drawcs(14, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
        drawcs(445, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
    }
    
    public void inishcarselect(ContO[] contos) {
        this.nplayers = 7;
        this.im = 0;
        this.xstart[0] = 0;
        this.xstart[1] = -350;
        this.xstart[2] = 350;
        this.xstart[3] = 0;
        this.xstart[4] = -350;
        this.xstart[5] = 350;
        this.xstart[6] = 0;
        this.zstart[0] = -760;
        this.zstart[1] = -380;
        this.zstart[2] = -380;
        this.zstart[3] = 0;
        this.zstart[4] = 380;
        this.zstart[5] = 380;
        this.zstart[6] = 760;
        this.onmsc = -1;
        this.remi = false;
        this.lfrom = 0;
        this.noclass = false;
        if (this.testdrive != 1 && this.testdrive != 2) {
            if (this.gmode != 0) {
                this.cfase = 0;
                this.sc[0] = this.scm[this.gmode - 1];
            }
            if (this.gmode == 0)
                this.sc[0] = this.osc;
            if (this.cfase == 0 && this.sc[0] > 15) {
                this.onmsc = this.sc[0];
                this.sc[0] = 15;
                if (this.multion != 0)
                    this.cfase = -1;
            }
            if (this.onjoin != -1 && this.multion != 0) {
                if (this.ontyp <= -2)
                    this.cfase = 0;
                if (this.ontyp >= 20) {
                    this.ontyp -= 20;
                    this.cfase = 0;
                }
                if (this.ontyp >= 10) {
                    this.ontyp -= 10;
                    if ((this.cd).lastload != 2) {
                        this.cfase = -1;
                        this.onjoin = -1;
                    } else
                        this.cfase = 3;
                }
            }
            if (this.cfase == 3) {
                if (this.multion != 0 && (this.cd).lastload == 1) {
                    this.sc[0] = 15;
                    this.minsl = 0;
                    this.maxsl = 15;
                    this.cfase = 0;
                }
                if ((this.cd).lastload == 0) {
                    this.sc[0] = 15;
                    this.minsl = 0;
                    this.maxsl = 15;
                    this.cfase = 0;
                }
                if ((this.cd).lastload == 2) {
                    this.minsl = 16;
                    this.maxsl = (this.cd).nlocars - 1;
                    if (this.sc[0] < this.minsl)
                        this.sc[0] = this.minsl;
                    if (this.sc[0] > this.maxsl)
                        this.sc[0] = this.maxsl;
                    if (this.onjoin != -1 && this.multion != 0 && this.ontyp > 0 && this.ontyp <= 5) {
                        boolean bool = false;
                        for (int i = 16; i < (this.cd).nlocars; i++) {
                            if (Math.abs((this.cd).cclass[i] - (this.ontyp - 1)) <= 1) {
                                if (!bool) {
                                    this.minsl = i;
                                    bool = true;
                                }
                                if (bool)
                                    this.maxsl = i;
                            }
                        }
                        if (!bool) {
                            this.onjoin = -1;
                            this.noclass = true;
                        } else {
                            if (this.sc[0] < this.minsl)
                                this.sc[0] = this.minsl;
                            if (this.sc[0] > this.maxsl)
                                this.sc[0] = this.maxsl;
                            if (Math.abs((this.cd).cclass[this.sc[0]] - (this.ontyp - 1)) > 1)
                                this.sc[0] = this.minsl;
                        }
                    }
                }
            }
            if (this.cfase == 0) {
                this.minsl = 0;
                this.maxsl = 15;
                if (this.onjoin != -1 && this.multion != 0) {
                    if (this.ontyp == 1) {
                        this.minsl = 0;
                        this.maxsl = 5;
                    }
                    if (this.ontyp == 2) {
                        this.minsl = 0;
                        this.maxsl = 9;
                    }
                    if (this.ontyp == 3) {
                        this.minsl = 5;
                        this.maxsl = 10;
                    }
                    if (this.ontyp == 4) {
                        this.minsl = 6;
                        this.maxsl = 15;
                    }
                    if (this.ontyp == 5) {
                        this.minsl = 10;
                        this.maxsl = 15;
                    }
                    if (this.ontyp <= -2) {
                        this.minsl = Math.abs(this.ontyp + 2);
                        this.maxsl = Math.abs(this.ontyp + 2);
                    }
                }
                if (this.sc[0] < this.minsl)
                    this.sc[0] = this.minsl;
                if (this.sc[0] > this.maxsl)
                    this.sc[0] = this.maxsl;
            }
        } else {
            this.minsl = this.sc[0];
            this.maxsl = this.sc[0];
        }
        carsbginflex();
        this.flatrstart = 0;
        (this.m).lightson = false;
        this.pnext = 0;
        this.pback = 0;
        this.lsc = -1;
        this.mouson = -1;
        if (this.multion == 0) {
            (this.app).mycar.setLabel(" Include in this game.");
            (this.app).mycar.setBackground(new Color(198, 179, 129));
            (this.app).mycar.setForeground(new Color(0, 0, 0));
            int i = 16;
            if ((this.cd).lastload == 2)
                i = (this.cd).nlocars;
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
                this.arnp[i_90_] = -1.0F;
        }
        (this.m).trk = 0;
        (this.m).crs = true;
        (this.m).x = -400;
        (this.m).y = -525;
        (this.m).z = -50;
        (this.m).xz = 0;
        (this.m).zy = 10;
        (this.m).ground = 495;
        (this.m).ih = 0;
        (this.m).iw = 0;
        (this.m).h = 450;
        (this.m).w = 800;
        (this.m).focus_point = 400;
        (this.m).cx = 400;
        (this.m).cy = 225;
        (this.m).cz = 50;
        this.intertrack.loadimod(false);
        this.intertrack.play();
    }
    
    public void carselect(Control control, ContO[] contos, Mad mad, int i, int i_91_, boolean bool) {
        if (!this.fbrl) {
            this.brl++;
            if (this.brl >= 50) {
                this.brl = 50;
                this.fbrl = true;
            }
        } else {
            this.brl--;
            if (this.brl <= 10) {
                this.brl = 10;
                this.fbrl = false;
            }
        }
        this.rd.setColor(new Color(this.brl * 2, this.brl, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
        if (this.flatrstart == 6) {
            if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2)
                this.rd.drawImage(this.carsbgc, 65, 25, null);
            else
                this.rd.drawImage(this.carsbg, 65, 25, null);
        } else if (this.flatrstart <= 1)
            drawSmokeCarsbg();
        else {
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.fillRect(65, 25, 670, 400);
            carsbginflex();
            this.flatrstart = 6;
        }
        this.rd.drawImage(this.selectcar, 321, 37, null);
        if (this.cfase == 3 || this.cfase == 7 || this.remi) {
            if ((this.cd).lastload == 1)
                this.rd.drawImage(this.ycmc, 337, 58, null);
            if ((this.cd).lastload == 2)
                this.rd.drawImage(this.yac, 323, 58, null);
        }
        if (this.cfase == 11) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            String string = "Top 20 Cars";
            int i_92_ = (this.cd).lastload - 2;
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
        if (!this.remi)
            contos[this.sc[0]].d(this.rd);
        if (this.cfase == 8) {
            drawprom(150, 85);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(195, "Removing Car...", 0, 0, 0, 3);
            if ((this.cd).action != 10) {
                if ((this.cd).action != -10)
                    this.cfase = 5;
                else
                    this.cfase = 9;
            }
        }
        if ((this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) && this.lsc != this.sc[0]) {
            if ((contos[this.sc[0]]).xy != 0)
                (contos[this.sc[0]]).xy = 0;
            boolean bool_94_ = false;
            for (int i_95_ = 0; i_95_ < (contos[this.sc[0]]).npl && !bool_94_; i_95_++) {
                if (((contos[this.sc[0]]).p[i_95_]).colnum == 1) {
                    float[] fs = new float[3];
                    Color.RGBtoHSB(((contos[this.sc[0]]).p[i_95_]).c[0], ((contos[this.sc[0]]).p[i_95_]).c[1], ((contos[this.sc[0]]).p[i_95_]).c[2], fs);
                    this.arnp[0] = fs[0];
                    this.arnp[1] = fs[1];
                    this.arnp[2] = 1.0F - fs[2];
                    bool_94_ = true;
                }
            }
            bool_94_ = false;
            for (int i_96_ = 0; i_96_ < (contos[this.sc[0]]).npl && !bool_94_; i_96_++) {
                if (((contos[this.sc[0]]).p[i_96_]).colnum == 2) {
                    float[] fs = new float[3];
                    Color.RGBtoHSB(((contos[this.sc[0]]).p[i_96_]).c[0], ((contos[this.sc[0]]).p[i_96_]).c[1], ((contos[this.sc[0]]).p[i_96_]).c[2], fs);
                    this.arnp[3] = fs[0];
                    this.arnp[4] = fs[1];
                    this.arnp[5] = 1.0F - fs[2];
                    bool_94_ = true;
                }
            }
            Color color = Color.getHSBColor(this.arnp[0], this.arnp[1], 1.0F - this.arnp[2]);
            Color color_97_ = Color.getHSBColor(this.arnp[3], this.arnp[4], 1.0F - this.arnp[5]);
            for (int i_98_ = 0; i_98_ < (contos[this.sc[0]]).npl; i_98_++) {
                if (((contos[this.sc[0]]).p[i_98_]).colnum == 1) {
                    ((contos[this.sc[0]]).p[i_98_]).hsb[0] = this.arnp[0];
                    ((contos[this.sc[0]]).p[i_98_]).hsb[1] = this.arnp[1];
                    ((contos[this.sc[0]]).p[i_98_]).hsb[2] = 1.0F - this.arnp[2];
                    ((contos[this.sc[0]]).p[i_98_]).c[0] = color.getRed();
                    ((contos[this.sc[0]]).p[i_98_]).c[1] = color.getGreen();
                    ((contos[this.sc[0]]).p[i_98_]).c[2] = color.getBlue();
                    ((contos[this.sc[0]]).p[i_98_]).oc[0] = color.getRed();
                    ((contos[this.sc[0]]).p[i_98_]).oc[1] = color.getGreen();
                    ((contos[this.sc[0]]).p[i_98_]).oc[2] = color.getBlue();
                }
                if (((contos[this.sc[0]]).p[i_98_]).colnum == 2) {
                    ((contos[this.sc[0]]).p[i_98_]).hsb[0] = this.arnp[3];
                    ((contos[this.sc[0]]).p[i_98_]).hsb[1] = this.arnp[4];
                    ((contos[this.sc[0]]).p[i_98_]).hsb[2] = 1.0F - this.arnp[5];
                    ((contos[this.sc[0]]).p[i_98_]).c[0] = color_97_.getRed();
                    ((contos[this.sc[0]]).p[i_98_]).c[1] = color_97_.getGreen();
                    ((contos[this.sc[0]]).p[i_98_]).c[2] = color_97_.getBlue();
                    ((contos[this.sc[0]]).p[i_98_]).oc[0] = color_97_.getRed();
                    ((contos[this.sc[0]]).p[i_98_]).oc[1] = color_97_.getGreen();
                    ((contos[this.sc[0]]).p[i_98_]).oc[2] = color_97_.getBlue();
                }
            }
            this.lsc = this.sc[0];
        }
        int i_99_ = -1;
        int i_100_ = 0;
        if (this.flipo == 0) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            int i_101_ = 0;
            if (this.flatrstart < 6)
                i_101_ = 2;
            if (!this.remi && (this.cfase != 10 || (this.cd).action != 0 && (this.cd).action < 14)) {
                String string = "";
                if (this.cfase == 11)
                    string = new StringBuilder().append("N#").append(this.sc[0] - 15).append("  ").toString();
                if (this.aflk) {
                    drawcs(95 + i_101_, new StringBuilder().append(string).append((this.cd).names[this.sc[0]]).toString(), 240, 240, 240, 3);
                    this.aflk = false;
                } else {
                    drawcs(95, new StringBuilder().append(string).append((this.cd).names[this.sc[0]]).toString(), 176, 176, 176, 3);
                    this.aflk = true;
                }
            }
            (contos[this.sc[0]]).z = 950;
            if (this.sc[0] == 13)
                (contos[this.sc[0]]).z = 1000;
            (contos[this.sc[0]]).y = -34 - (contos[this.sc[0]]).grat;
            (contos[this.sc[0]]).x = 0;
            if (this.mouson >= 0 && this.mouson <= 3)
                (contos[this.sc[0]]).xz += 2;
            else
                (contos[this.sc[0]]).xz += 5;
            if ((contos[this.sc[0]]).xz > 360)
                (contos[this.sc[0]]).xz -= 360;
            (contos[this.sc[0]]).zy = 0;
            (contos[this.sc[0]]).wzy -= 10;
            if ((contos[this.sc[0]]).wzy < -30)
                (contos[this.sc[0]]).wzy += 30;
            if (!this.remi) {
                if (this.sc[0] != this.minsl)
                    this.rd.drawImage(this.back[this.pback], 95, 275, null);
                if (this.sc[0] != this.maxsl)
                    this.rd.drawImage(this.next[this.pnext], 645, 275, null);
            }
            if (this.gmode == 1) {
                if (this.sc[0] == 5 && this.unlocked[0] <= 2)
                    i_100_ = 2;
                if (this.sc[0] == 6 && this.unlocked[0] <= 4)
                    i_100_ = 4;
                if (this.sc[0] == 11 && this.unlocked[0] <= 6)
                    i_100_ = 6;
                if (this.sc[0] == 14 && this.unlocked[0] <= 8)
                    i_100_ = 8;
                if (this.sc[0] == 15 && this.unlocked[0] <= 10)
                    i_100_ = 10;
            }
            if (this.gmode == 2 && this.sc[0] >= 8 && this.unlocked[1] <= (this.sc[0] - 7) * 2)
                i_100_ = (this.sc[0] - 7) * 2;
            if (i_100_ != 0) {
                if (this.gatey == 300) {
                    for (int i_102_ = 0; i_102_ < 9; i_102_++) {
                        this.pgas[i_102_] = false;
                        this.pgady[i_102_] = 0;
                    }
                    this.pgas[0] = true;
                }
                for (int i_103_ = 0; i_103_ < 9; i_103_++) {
                    this.rd.drawImage(this.pgate, this.pgatx[i_103_], this.pgaty[i_103_] + this.pgady[i_103_] - this.gatey, null);
                    if (this.flatrstart == 6) {
                        if (this.pgas[i_103_]) {
                            this.pgady[i_103_] -= (80 + 100 / (i_103_ + 1) - Math.abs(this.pgady[i_103_])) / 3;
                            if (this.pgady[i_103_] < -(70 + 100 / (i_103_ + 1))) {
                                this.pgas[i_103_] = false;
                                if (i_103_ != 8)
                                    this.pgas[i_103_ + 1] = true;
                            }
                        } else {
                            this.pgady[i_103_] += (80 + 100 / (i_103_ + 1) - Math.abs(this.pgady[i_103_])) / 3;
                            if (this.pgady[i_103_] > 0)
                                this.pgady[i_103_] = 0;
                        }
                    }
                }
                if (this.gatey != 0)
                    this.gatey -= 100;
                if (this.flatrstart == 6) {
                    drawcs(355, "[ Car Locked ]", 210, 210, 210, 3);
                    drawcs(375, new StringBuilder().append("This car unlocks when stage ").append(i_100_).append(" is completed...").toString(), 255, 96, 0, 3);
                }
            } else {
                if (this.flatrstart == 6) {
                    if (this.cfase == 10) {
                        if ((this.cd).action == 13) {
                            this.minsl = 16;
                            this.maxsl = (this.cd).nlocars - 1;
                            i_99_ = 16;
                            (this.cd).action = 0;
                            this.cfase = 11;
                        }
                        if ((this.cd).action == 12) {
                            int i_104_ = (this.cd).loadlist;
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
                            if ((this.cd).nl > 0 && (this.cd).nl <= 20)
                                drawcs(235, new StringBuilder().append("Loading :  ").append((this.cd).loadnames[(this.cd).nl - 1]).append("").toString(), 0, 0, 0, 3);
                        }
                        if ((this.cd).action == 11) {
                            drawprom(145, 170);
                            drawcs(195, "Loading List, Please Wait...", 0, 0, 0, 3);
                        }
                        if ((this.cd).action == -1) {
                            drawprom(145, 170);
                            drawcs(195, "Failed to Load List", 0, 0, 0, 3);
                            drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, i, i_91_, bool)) {
                                if (this.lfrom <= 2) {
                                    if (this.lfrom == 2)
                                        this.cfase = 3;
                                    else
                                        this.cfase = 0;
                                    this.lfrom = 0;
                                } else {
                                    this.lfrom -= 2;
                                    (this.cd).action = 0;
                                    this.cfase = 11;
                                }
                            }
                        }
                        if ((this.cd).action == 0 || (this.cd).action == 14 || (this.cd).action == 15 || (this.cd).action == 16) {
                            drawprom(65, 250);
                            if (drawcarb(true, null, " X ", 557, 70, i, i_91_, bool)) {
                                if (this.lfrom <= 2) {
                                    if (this.lfrom == 2)
                                        this.cfase = 3;
                                    else
                                        this.cfase = 0;
                                    this.lfrom = 0;
                                } else {
                                    this.lfrom -= 2;
                                    (this.cd).action = 0;
                                    this.cfase = 11;
                                }
                            }
                            drawcs(305, "The lists get updated every 24 hours!", 0, 0, 0, 3);
                            if ((this.cd).action == 14 || (this.cd).action == 15 || (this.cd).action == 16) {
                                if (!bool && this.cntflock == 20)
                                    this.cntflock = 0;
                                if ((this.cd).action == 14)
                                    drawcs(91, "Weekly Top 20 Cars", 0, 0, 0, 3);
                                if ((this.cd).action == 15)
                                    drawcs(91, "Monthly Top 20 Cars", 0, 0, 0, 3);
                                if ((this.cd).action == 16)
                                    drawcs(91, "All Time Top 20 Cars", 0, 0, 0, 3);
                                if (drawcarb(true, null, "   All Cars, All Classes   ", 318, 105, i, i_91_, bool) && this.cntflock == 0) {
                                    if (this.lfrom > 2)
                                        this.lfrom -= 2;
                                    (this.cd).loadlist = 1 + ((this.cd).action - 14) * 6;
                                    (this.cd).action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class A Cars", 337, 135, i, i_91_, bool) && this.cntflock == 0) {
                                    if (this.lfrom > 2)
                                        this.lfrom -= 2;
                                    (this.cd).loadlist = 2 + ((this.cd).action - 14) * 6;
                                    (this.cd).action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class A & B Cars", 337, 165, i, i_91_, bool) && this.cntflock == 0) {
                                    if (this.lfrom > 2)
                                        this.lfrom -= 2;
                                    (this.cd).loadlist = 3 + ((this.cd).action - 14) * 6;
                                    (this.cd).action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class B Cars", 337, 195, i, i_91_, bool) && this.cntflock == 0) {
                                    if (this.lfrom > 2)
                                        this.lfrom -= 2;
                                    (this.cd).loadlist = 4 + ((this.cd).action - 14) * 6;
                                    (this.cd).action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class B & C Cars", 337, 225, i, i_91_, bool) && this.cntflock == 0) {
                                    if (this.lfrom > 2)
                                        this.lfrom -= 2;
                                    (this.cd).loadlist = 5 + ((this.cd).action - 14) * 6;
                                    (this.cd).action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class C Cars", 337, 255, i, i_91_, bool) && this.cntflock == 0) {
                                    if (this.lfrom > 2)
                                        this.lfrom -= 2;
                                    (this.cd).loadlist = 6 + ((this.cd).action - 14) * 6;
                                    (this.cd).action = 11;
                                    this.cd.sparkactionloader();
                                }
                            }
                            if ((this.cd).action == 0) {
                                drawcs(91, "Top 20 Most Added Public Cars", 0, 0, 0, 3);
                                if (drawcarb(true, null, "  Weekly Top 20  ", 338, 125, i, i_91_, bool))
                                    (this.cd).action = 14;
                                if (drawcarb(true, null, "  Monthly Top 20  ", 337, 165, i, i_91_, bool))
                                    (this.cd).action = 15;
                                if (drawcarb(true, null, "  All Time Top 20  ", 335, 205, i, i_91_, bool))
                                    (this.cd).action = 16;
                                if (this.cntflock != 20)
                                    this.cntflock = 20;
                            }
                        }
                    }
                    if (this.cfase == 0 && this.testdrive != 1 && this.testdrive != 2 && this.gmode == 0) {
                        int i_106_ = 95;
                        if (this.multion != 0)
                            i_106_ = 185;
                        if (this.multion == 0 && drawcarb(false, this.cmc, "", 95, 65, i, i_91_, bool)) {
                            if ((this.cd).lastload != 1)
                                this.cfase = 1;
                            else {
                                this.minsl = 16;
                                this.maxsl = (this.cd).nlcars - 1;
                                i_99_ = 16;
                                this.cfase = 3;
                            }
                        }
                        if (drawcarb(false, this.myc, "", i_106_, 105, i, i_91_, bool)) {
                            if ((this.cd).lastload != 2) {
                                this.cfase = 5;
                                if (!this.logged) {
                                    (this.cd).action = 0;
                                    (this.cd).reco = -2;
                                    this.tcnt = 5;
                                    this.cntflock = 0;
                                } else {
                                    (this.cd).action = 3;
                                    this.cd.sparkactionloader();
                                }
                            } else {
                                this.minsl = 16;
                                this.maxsl = (this.cd).nlocars - 1;
                                if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl)
                                    i_99_ = this.onmsc;
                                else
                                    i_99_ = 16;
                                this.cfase = 3;
                            }
                        }
                        if ((this.multion == 0 || this.onjoin == -1) && drawcarb(true, null, " Top 20 Lists ", i_106_, (i_106_ - 95) / 7 + 25, i, i_91_, bool)) {
                            this.lfrom = 1;
                            (this.cd).action = 0;
                            this.cfase = 10;
                        }
                        if (this.remi)
                            this.remi = false;
                    }
                    if (this.cfase == -1) {
                        if ((this.cd).lastload != 2) {
                            this.cfase = 5;
                            if (!this.logged) {
                                (this.cd).action = 0;
                                (this.cd).reco = -2;
                                this.tcnt = 5;
                                this.cntflock = 0;
                            } else {
                                (this.cd).action = 3;
                                this.cd.sparkactionloader();
                            }
                        } else {
                            this.minsl = 16;
                            this.maxsl = (this.cd).nlocars - 1;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl)
                                i_99_ = this.onmsc;
                            else
                                i_99_ = 16;
                            this.cfase = 3;
                        }
                    }
                    if (this.cfase == 9) {
                        drawprom(145, 95);
                        drawcs(175, "Failed to remove car.  Unkown Error.  Try again laster.", 0, 0, 0, 3);
                        if (drawcarb(true, null, "   OK   ", 371, 195, i, i_91_, bool)) {
                            this.minsl = 16;
                            this.maxsl = (this.cd).nlocars - 1;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl)
                                i_99_ = this.onmsc;
                            else
                                i_99_ = 16;
                            this.cfase = 3;
                        }
                    }
                    if (this.cfase == 7) {
                        if ((this.app).mycar.isShowing())
                            (this.app).mycar.hide();
                        drawprom(145, 95);
                        drawcs(175, "Remove this car from your account?", 0, 0, 0, 3);
                        if (drawcarb(true, null, " Yes ", 354, 195, i, i_91_, bool)) {
                            this.remi = true;
                            this.minsl = 0;
                            this.maxsl = 15;
                            i_99_ = 15;
                            this.cfase = 8;
                            this.onmsc = this.sc[0];
                            (this.cd).ac = this.sc[0];
                            (this.cd).action = 10;
                            this.cd.sparkactionloader();
                        }
                        if (drawcarb(true, null, " No ", 408, 195, i, i_91_, bool))
                            this.cfase = 3;
                    }
                    if (this.cfase == 3 && i_99_ == -1) {
                        int i_107_ = 95;
                        if (this.multion != 0)
                            i_107_ = 185;
                        if (drawcarb(false, this.gac, "", i_107_, 105, i, i_91_, bool)) {
                            this.minsl = 0;
                            this.maxsl = 15;
                            i_99_ = 15;
                            this.cfase = 0;
                        }
                        if (this.multion == 0) {
                            if (!(this.app).mycar.isShowing()) {
                                (this.app).mycar.show();
                                (this.app).mycar.setState((this.cd).include[this.sc[0] - 16]);
                            }
                            this.rd.setColor(new Color(198, 179, 129));
                            this.rd.fillRoundRect(305, 302, 190, 24, 7, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(305, 302, 190, 24, 7, 20);
                            this.app.movefield((this.app).mycar, 334, 306, 150, 17);
                            if ((this.app).mycar.getState() != (this.cd).include[this.sc[0] - 16]) {
                                (this.cd).include[this.sc[0] - 16] = (this.app).mycar.getState();
                                this.app.requestFocus();
                            }
                        }
                        if ((this.multion == 0 || this.onjoin == -1) && drawcarb(true, null, " Top 20 Lists ", i_107_, (i_107_ - 95) / 7 + 25, i, i_91_, bool)) {
                            this.lfrom = 2;
                            (this.cd).action = 0;
                            this.cfase = 10;
                            if ((this.app).mycar.isShowing())
                                (this.app).mycar.hide();
                        }
                        if ((this.cd).lastload == 2) {
                            if (drawcarb(true, null, "X", 567, 135, i, i_91_, bool))
                                this.cfase = 7;
                            this.rd.setFont(new Font("Arial", 1, 11));
                            this.rd.setColor(new Color(0, 0, 0));
                            if (!(this.cd).createdby[this.sc[0] - 16].equals(this.nickname))
                                this.rd.drawString(new StringBuilder().append("Created by :  ").append((this.cd).createdby[this.sc[0] - 16]).append("").toString(), 241, 165);
                            else
                                this.rd.drawString("Created by You", 241, 165);
                        }
                        if (this.remi)
                            this.remi = false;
                        if (this.noclass) {
                            drawprom(200, 95);
                            this.rd.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rd.getFontMetrics();
                            String string = "Class C";
                            if (this.ontyp == 2)
                                string = "Class B or C";
                            if (this.ontyp == 3)
                                string = "Class B";
                            if (this.ontyp == 4)
                                string = "Class A or B";
                            if (this.ontyp == 5)
                                string = "Class A";
                            drawcs(230, new StringBuilder().append("You do not have a ").append(string).append(" car in your account cars.").toString(), 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 250, i, i_91_, bool))
                                this.noclass = false;
                        }
                    }
                    if (this.cfase == 11 && i_99_ == -1) {
                        if ((this.cd).action == -9) {
                            drawprom(145, 95);
                            drawcs(175, "Unknown error!  Failed to add car.  Try again later.", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, i, i_91_, bool))
                                (this.cd).action = 0;
                        }
                        if ((this.cd).action == -8) {
                            drawprom(145, 95);
                            drawcs(175, "Failed.  You already have 20 cars in your account!", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, i, i_91_, bool))
                                (this.cd).action = 0;
                        }
                        if ((this.cd).action == -7) {
                            drawprom(145, 95);
                            drawcs(175, "You already have this car!", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, i, i_91_, bool))
                                (this.cd).action = 0;
                        }
                        if ((this.cd).action == 7) {
                            drawprom(145, 95);
                            drawcs(175, new StringBuilder().append("").append((this.cd).names[(this.cd).ac]).append(" has been successfully added to your cars!").toString(), 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, i, i_91_, bool))
                                (this.cd).action = 0;
                        }
                        if ((this.cd).action == 6) {
                            drawprom(145, 95);
                            drawcs(195, new StringBuilder().append("Adding ").append((this.cd).names[(this.cd).ac]).append(" to your cars...").toString(), 0, 0, 0, 3);
                        }
                        int i_108_ = 95;
                        if (this.multion != 0)
                            i_108_ = 185;
                        if (this.lfrom == 2 && this.multion != 0) {
                            if (drawcarb(false, this.myc, "", i_108_, 105, i, i_91_, bool)) {
                                if ((this.cd).lastload != 2) {
                                    this.cfase = 5;
                                    if (!this.logged) {
                                        (this.cd).action = 0;
                                        (this.cd).reco = -2;
                                        this.tcnt = 5;
                                        this.cntflock = 0;
                                    } else {
                                        (this.cd).action = 3;
                                        this.cd.sparkactionloader();
                                    }
                                } else {
                                    (this.cd).action = 0;
                                    this.minsl = 16;
                                    this.maxsl = (this.cd).nlocars - 1;
                                    if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl)
                                        i_99_ = this.onmsc;
                                    else
                                        i_99_ = 16;
                                    this.cfase = 3;
                                }
                                (this.app).moused = false;
                                this.lfrom = 0;
                            }
                        } else if (drawcarb(false, this.gac, "", i_108_, 105, i, i_91_, bool)) {
                            (this.cd).action = 0;
                            this.minsl = 0;
                            this.maxsl = 15;
                            i_99_ = 15;
                            this.cfase = 0;
                            (this.app).moused = false;
                            this.lfrom = 0;
                        }
                        if (drawcarb(true, null, " Top 20 Lists ", i_108_, (i_108_ - 95) / 7 + 25, i, i_91_, bool)) {
                            this.lfrom += 2;
                            (this.cd).action = 0;
                            this.cfase = 10;
                        }
                        if ((this.cd).action == 0) {
                            this.rd.setFont(new Font("Arial", 1, 11));
                            this.rd.setColor(new Color(0, 0, 0));
                            if (!(this.cd).createdby[this.sc[0] - 16].equals(this.nickname))
                                this.rd.drawString(new StringBuilder().append("Created by :  ").append((this.cd).createdby[this.sc[0] - 16]).append("").toString(), 241, 165);
                            else
                                this.rd.drawString("Created by You", 241, 165);
                            this.rd.drawString(new StringBuilder().append("Added by :  ").append((this.cd).adds[this.sc[0] - 16]).append(" Players").toString(), 241, 182);
                        }
                    }
                    if (this.cfase == 5) {
                        drawprom(145, 170);
                        if ((this.cd).action == 5) {
                            this.minsl = 16;
                            this.maxsl = (this.cd).nlocars - 1;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl)
                                i_99_ = this.onmsc;
                            else
                                i_99_ = 16;
                            this.cfase = 3;
                        }
                        if ((this.cd).action == 4) {
                            drawcs(195, "[  Loading Cars  ]", 0, 0, 0, 3);
                            if ((this.cd).nl > 0 && (this.cd).nl <= 20)
                                drawcs(235, new StringBuilder().append("Loading :  ").append((this.cd).loadnames[(this.cd).nl - 1]).append("").toString(), 0, 0, 0, 3);
                        }
                        if ((this.cd).action == -2) {
                            drawcs(195, "Unknown Connection Error", 0, 0, 0, 3);
                            drawcs(225, "Failed to connect to server, try again later!", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, i, i_91_, bool))
                                this.cfase = 0;
                        }
                        if ((this.cd).action == -1) {
                            drawcs(195, "No published cars found...", 0, 0, 0, 3);
                            drawcs(225, "You have no added cars to your account yet!", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, i, i_91_, bool))
                                this.cfase = 0;
                        }
                        if ((this.cd).action == 2 || (this.cd).action == 3) {
                            drawcs(195, "Loading your Account Cars list...", 0, 0, 0, 3);
                            if ((this.cd).action == 2) {
                                this.nickname = (this.app).tnick.getText();
                                this.nickey = (this.cd).tnickey;
                                this.app.setloggedcookie();
                                this.logged = true;
                                if ((this.cd).reco == 0)
                                    this.acexp = 0;
                                if ((this.cd).reco > 10)
                                    this.acexp = (this.cd).reco - 10;
                                if ((this.cd).reco == 3)
                                    this.acexp = -1;
                                if (this.lfrom == 0)
                                    (this.cd).action = 3;
                                else {
                                    (this.cd).action = 6;
                                    this.cfase = 11;
                                }
                            }
                        }
                        if ((this.cd).action == 1)
                            drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                        if ((this.cd).action == 0) {
                            if ((this.cd).reco == -5)
                                drawcs(171, "Login to Add this Car to your Account", 0, 0, 0, 3);
                            if ((this.cd).reco == -2)
                                drawcs(171, "Login to Retrieve your Account Cars", 0, 0, 0, 3);
                            if ((this.cd).reco == -1)
                                drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                            if ((this.cd).reco == 1)
                                drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                            if ((this.cd).reco == 2)
                                drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                            if ((this.cd).reco == -167 || (this.cd).reco == -177) {
                                if ((this.cd).reco == -167) {
                                    this.nickname = (this.app).tnick.getText();
                                    (this.cd).reco = -177;
                                }
                                drawcs(171, "You need to have a full account to access your cars!", 0, 0, 0, 3);
                            }
                            if ((this.cd).reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20))
                                drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                            if ((this.cd).reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20))
                                drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                            if (!(this.app).tnick.isShowing()) {
                                (this.app).tnick.show();
                                (this.app).tnick.setBackground(new Color(206, 237, 255));
                                if ((this.cd).reco != 1) {
                                    if ((this.cd).reco != 2)
                                        (this.app).tnick.setText(this.nickname);
                                    (this.app).tnick.setForeground(new Color(0, 0, 0));
                                } else
                                    (this.app).tnick.setForeground(new Color(255, 0, 0));
                                (this.app).tnick.requestFocus();
                            }
                            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 201);
                            this.app.movefield((this.app).tnick, 376, 185, 129, 23);
                            if (!(this.app).tpass.isShowing()) {
                                (this.app).tpass.show();
                                (this.app).tpass.setBackground(new Color(206, 237, 255));
                                if ((this.cd).reco != 2) {
                                    if (!this.autolog)
                                        (this.app).tpass.setText("");
                                    (this.app).tpass.setForeground(new Color(0, 0, 0));
                                } else
                                    (this.app).tpass.setForeground(new Color(255, 0, 0));
                                if (!(this.app).tnick.getText().equals("") && (this.cd).reco != 1)
                                    (this.app).tpass.requestFocus();
                            }
                            this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 231);
                            this.app.movefield((this.app).tpass, 376, 215, 129, 23);
                            if (this.tcnt < 30) {
                                this.tcnt++;
                                if (this.tcnt == 30) {
                                    if ((this.cd).reco == 2)
                                        (this.app).tpass.setText("");
                                    (this.app).tnick.setForeground(new Color(0, 0, 0));
                                    (this.app).tpass.setForeground(new Color(0, 0, 0));
                                }
                            }
                            if ((this.cd).reco != -177) {
                                if (drawcarb(true, null, "       Login       ", 347, 247, i, i_91_, bool) && this.tcnt > 5) {
                                    this.tcnt = 0;
                                    if (!(this.app).tnick.getText().equals("") && !(this.app).tpass.getText().equals("")) {
                                        this.autolog = false;
                                        (this.app).tnick.hide();
                                        (this.app).tpass.hide();
                                        this.app.requestFocus();
                                        (this.cd).action = 1;
                                        this.cd.sparkactionloader();
                                    } else {
                                        if ((this.app).tpass.getText().equals(""))
                                            (this.cd).reco = -4;
                                        if ((this.app).tnick.getText().equals(""))
                                            (this.cd).reco = -3;
                                    }
                                }
                            } else if (drawcarb(true, null, "  Upgrade your account to have full access  ", 254, 247, i, i_91_, bool) && this.cntflock == 0) {
                                this.app.editlink(this.nickname);
                                this.cntflock = 100;
                            }
                            if (drawcarb(true, null, "  Cancel  ", 409, 282, i, i_91_, bool)) {
                                (this.app).tnick.hide();
                                (this.app).tpass.hide();
                                this.app.requestFocus();
                                if (this.lfrom == 0)
                                    this.cfase = 0;
                                else
                                    this.cfase = 11;
                            }
                            if (drawcarb(true, null, "  Register!  ", 316, 282, i, i_91_, bool)) {
                                if (this.cntflock == 0) {
                                    this.app.reglink();
                                    this.cntflock = 100;
                                }
                            } else if (this.cntflock != 0)
                                this.cntflock--;
                        }
                    }
                    if (this.cfase == 4) {
                        drawprom(145, 150);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Failed to find any ready car in your \u2018mycars\u2019 folder!", 215, 175);
                        this.rd.drawString("Please \u2018Test Drive\u2019 your cars in the Car Maker to make", 215, 215);
                        this.rd.drawString("sure they are ready.", 215, 235);
                        if (drawcarb(true, null, "   OK   ", 371, 255, i, i_91_, bool))
                            this.cfase = 0;
                    }
                    if (this.cfase == 2) {
                        drawprom(165, 70);
                        drawcs(205, "Loading Car Maker Cars...", 0, 0, 0, 3);
                        this.app.repaint();
                        this.cd.loadcarmaker();
                        if ((this.cd).nlcars > 16) {
                            this.minsl = 16;
                            this.maxsl = (this.cd).nlcars - 1;
                            i_99_ = 16;
                            this.cfase = 3;
                        } else
                            this.cfase = 4;
                    }
                    if (this.cfase == 1) {
                        drawprom(145, 170);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("The game will now load all the cars that can be loaded", 215, 170);
                        this.rd.drawString("from your \u2018mycars\u2019 folder.", 215, 190);
                        this.rd.drawString("If a car is not loaded, then it is not ready (not finished).", 215, 210);
                        this.rd.drawString("Perform a \u2018Test Drive\u2019 on any car to see if it is ready or not.", 215, 230);
                        this.rd.drawString("The maximum number of cars that can be loaded is  40 !", 215, 260);
                        if (drawcarb(true, null, "   OK   ", 371, 275, i, i_91_, bool))
                            this.cfase = 2;
                    }
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(181, 120, 40));
                    this.rd.drawString("Top Speed:", 98, 343);
                    this.rd.drawImage(this.statb, 162, 337, null);
                    this.rd.drawString("Acceleration:", 88, 358);
                    this.rd.drawImage(this.statb, 162, 352, null);
                    this.rd.drawString("Handling:", 110, 373);
                    this.rd.drawImage(this.statb, 162, 367, null);
                    this.rd.drawString("Stunts:", 495, 343);
                    this.rd.drawImage(this.statb, 536, 337, null);
                    this.rd.drawString("Strength:", 483, 358);
                    this.rd.drawImage(this.statb, 536, 352, null);
                    this.rd.drawString("Endurance:", 473, 373);
                    this.rd.drawImage(this.statb, 536, 367, null);
                    this.rd.setColor(new Color(0, 0, 0));
                    float f = (float) ((this.cd).swits[this.sc[0]][2] - 220) / 90.0F;
                    if ((double) f < 0.2)
                        f = 0.2F;
                    this.rd.fillRect((int) (162.0F + 156.0F * f), 337, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    f = (this.cd).acelf[this.sc[0]][1] * (this.cd).acelf[this.sc[0]][0] * (this.cd).acelf[this.sc[0]][2] * (this.cd).grip[this.sc[0]] / 7700.0F;
                    if (f > 1.0F)
                        f = 1.0F;
                    this.rd.fillRect((int) (162.0F + 156.0F * f), 352, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    f = (this.cd).dishandle[this.sc[0]];
                    this.rd.fillRect((int) (162.0F + 156.0F * f), 367, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    f = ((float) (this.cd).airc[this.sc[0]] * (this.cd).airs[this.sc[0]] * (this.cd).bounce[this.sc[0]] + 28.0F) / 139.0F;
                    if (f > 1.0F)
                        f = 1.0F;
                    this.rd.fillRect((int) (536.0F + 156.0F * f), 337, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    float f_109_ = 0.5F;
                    f = ((this.cd).moment[this.sc[0]] + f_109_) / 2.6F;
                    if (f > 1.0F)
                        f = 1.0F;
                    this.rd.fillRect((int) (536.0F + 156.0F * f), 352, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    f = (this.cd).outdam[this.sc[0]];
                    this.rd.fillRect((int) (536.0F + 156.0F * f), 367, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                    this.rd.drawImage(this.statbo, 162, 337, null);
                    this.rd.drawImage(this.statbo, 162, 352, null);
                    this.rd.drawImage(this.statbo, 162, 367, null);
                    this.rd.drawImage(this.statbo, 536, 337, null);
                    this.rd.drawImage(this.statbo, 536, 352, null);
                    this.rd.drawImage(this.statbo, 536, 367, null);
                    if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        String string = "Class C";
                        if ((this.cd).cclass[this.sc[0]] == 1)
                            string = "Class B & C";
                        if ((this.cd).cclass[this.sc[0]] == 2)
                            string = "Class B";
                        if ((this.cd).cclass[this.sc[0]] == 3)
                            string = "Class A & B";
                        if ((this.cd).cclass[this.sc[0]] == 4)
                            string = "Class A";
                        if (this.kbload < 7) {
                            this.rd.setColor(new Color(0, 0, 0));
                            this.kbload++;
                        } else {
                            this.rd.setColor(new Color(176, 41, 0));
                            this.kbload = 0;
                        }
                        if (this.cfase != 10 || (this.cd).action != 0 && (this.cd).action < 14)
                            this.rd.drawString(string, 549 - this.ftm.stringWidth(string) / 2, 95);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("1st Color", 100, 55);
                        this.rd.drawString("2nd Color", 649, 55);
                        this.rd.setFont(new Font("Arial", 1, 10));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Hue  | ", 97, 70);
                        this.rd.drawImage(this.brt, 137, 63, null);
                        this.rd.drawString("Hue  | ", 647, 70);
                        this.rd.drawImage(this.brt, 687, 63, null);
                        this.rd.drawString("Intensity", 121, 219);
                        this.rd.drawString("Intensity", 671, 219);
                        this.rd.drawString("Reset", 110, 257);
                        this.rd.drawString("Reset", 660, 257);
                        for (int i_110_ = 0; i_110_ < 161; i_110_++) {
                            this.rd.setColor(Color.getHSBColor((float) ((double) (float) i_110_ * 0.00625), 1.0F, 1.0F));
                            this.rd.drawLine(102, 75 + i_110_, 110, 75 + i_110_);
                            if (i_110_ <= 128) {
                                this.rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0 - (double) (float) i_110_ * 0.00625)));
                                this.rd.drawLine(137, 75 + i_110_, 145, 75 + i_110_);
                            }
                            this.rd.setColor(Color.getHSBColor((float) ((double) (float) i_110_ * 0.00625), 1.0F, 1.0F));
                            this.rd.drawLine(652, 75 + i_110_, 660, 75 + i_110_);
                            if (i_110_ <= 128) {
                                this.rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0 - (double) (float) i_110_ * 0.00625)));
                                this.rd.drawLine(687, 75 + i_110_, 695, 75 + i_110_);
                            }
                        }
                        for (int i_111_ = 0; i_111_ < 40; i_111_++) {
                            this.rd.setColor(Color.getHSBColor(this.arnp[0], (float) ((double) (float) i_111_ * 0.025), 1.0F - this.arnp[2]));
                            this.rd.drawLine(121 + i_111_, 224, 121 + i_111_, 230);
                            this.rd.setColor(Color.getHSBColor(this.arnp[3], (float) ((double) (float) i_111_ * 0.025), 1.0F - this.arnp[5]));
                            this.rd.drawLine(671 + i_111_, 224, 671 + i_111_, 230);
                        }
                        this.rd.drawImage(this.arn, 110, 71 + (int) (this.arnp[0] * 160.0F), null);
                        this.rd.drawImage(this.arn, 145, 71 + (int) (this.arnp[2] * 160.0F), null);
                        this.rd.drawImage(this.arn, 660, 71 + (int) (this.arnp[3] * 160.0F), null);
                        this.rd.drawImage(this.arn, 695, 71 + (int) (this.arnp[5] * 160.0F), null);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(120 + (int) (this.arnp[1] * 40.0F), 222, 3, 3);
                        this.rd.drawLine(121 + (int) (this.arnp[1] * 40.0F), 224, 121 + (int) (this.arnp[1] * 40.0F), 230);
                        this.rd.fillRect(120 + (int) (this.arnp[1] * 40.0F), 230, 3, 3);
                        this.rd.fillRect(670 + (int) (this.arnp[4] * 40.0F), 222, 3, 3);
                        this.rd.drawLine(671 + (int) (this.arnp[4] * 40.0F), 224, 671 + (int) (this.arnp[4] * 40.0F), 230);
                        this.rd.fillRect(670 + (int) (this.arnp[4] * 40.0F), 230, 3, 3);
                        if (bool) {
                            if (this.mouson == -1) {
                                if (i > 96 && i < 152 && i_91_ > 248 && i_91_ < 258) {
                                    float[] fs = new float[3];
                                    Color.RGBtoHSB((contos[this.sc[0]]).fcol[0], (contos[this.sc[0]]).fcol[1], (contos[this.sc[0]]).fcol[2], fs);
                                    this.arnp[0] = fs[0];
                                    this.arnp[1] = fs[1];
                                    this.arnp[2] = 1.0F - fs[2];
                                }
                                if (i > 646 && i < 702 && i_91_ > 248 && i_91_ < 258) {
                                    float[] fs = new float[3];
                                    Color.RGBtoHSB((contos[this.sc[0]]).scol[0], (contos[this.sc[0]]).scol[1], (contos[this.sc[0]]).scol[2], fs);
                                    this.arnp[3] = fs[0];
                                    this.arnp[4] = fs[1];
                                    this.arnp[5] = 1.0F - fs[2];
                                }
                                this.mouson = -2;
                                if (i > 119 && i < 163 && i_91_ > 222 && i_91_ < 232)
                                    this.mouson = 1;
                                if (i > 669 && i < 713 && i_91_ > 222 && i_91_ < 232)
                                    this.mouson = 4;
                                if (i > 98 && i < 122 && i_91_ > 69 && i_91_ < 241 && this.mouson == -2)
                                    this.mouson = 0;
                                if (i > 133 && i < 157 && i_91_ > 69 && i_91_ < 209 && this.mouson == -2)
                                    this.mouson = 2;
                                if (i > 648 && i < 672 && i_91_ > 69 && i_91_ < 241 && this.mouson == -2)
                                    this.mouson = 3;
                                if (i > 683 && i < 707 && i_91_ > 69 && i_91_ < 209 && this.mouson == -2)
                                    this.mouson = 5;
                            }
                        } else if (this.mouson != -1)
                            this.mouson = -1;
                        if (this.mouson == 0 || this.mouson == 2 || this.mouson == 3 || this.mouson == 5) {
                            this.arnp[this.mouson] = (float) ((double) ((float) i_91_ - 75.0F) * 0.00625);
                            if (this.mouson == 2 || this.mouson == 5) {
                                if ((double) this.arnp[this.mouson] > 0.8)
                                    this.arnp[this.mouson] = 0.8F;
                            } else if (this.arnp[this.mouson] > 1.0F)
                                this.arnp[this.mouson] = 1.0F;
                            if (this.arnp[this.mouson] < 0.0F)
                                this.arnp[this.mouson] = 0.0F;
                        }
                        if (this.mouson == 1) {
                            this.arnp[this.mouson] = (float) ((double) ((float) i - 121.0F) * 0.025);
                            if (this.arnp[this.mouson] > 1.0F)
                                this.arnp[this.mouson] = 1.0F;
                            if (this.arnp[this.mouson] < 0.0F)
                                this.arnp[this.mouson] = 0.0F;
                        }
                        if (this.mouson == 4) {
                            this.arnp[this.mouson] = (float) ((double) ((float) i - 671.0F) * 0.025);
                            if (this.arnp[this.mouson] > 1.0F)
                                this.arnp[this.mouson] = 1.0F;
                            if (this.arnp[this.mouson] < 0.0F)
                                this.arnp[this.mouson] = 0.0F;
                        }
                        if (this.cfase != 10 && this.cfase != 5 && i_99_ == -1) {
                            Color color = Color.getHSBColor(this.arnp[0], this.arnp[1], 1.0F - this.arnp[2]);
                            Color color_112_ = Color.getHSBColor(this.arnp[3], this.arnp[4], 1.0F - this.arnp[5]);
                            for (int i_113_ = 0; i_113_ < (contos[this.sc[0]]).npl; i_113_++) {
                                if (((contos[this.sc[0]]).p[i_113_]).colnum == 1) {
                                    ((contos[this.sc[0]]).p[i_113_]).hsb[0] = this.arnp[0];
                                    ((contos[this.sc[0]]).p[i_113_]).hsb[1] = this.arnp[1];
                                    ((contos[this.sc[0]]).p[i_113_]).hsb[2] = 1.0F - this.arnp[2];
                                    ((contos[this.sc[0]]).p[i_113_]).c[0] = color.getRed();
                                    ((contos[this.sc[0]]).p[i_113_]).c[1] = color.getGreen();
                                    ((contos[this.sc[0]]).p[i_113_]).c[2] = color.getBlue();
                                    ((contos[this.sc[0]]).p[i_113_]).oc[0] = color.getRed();
                                    ((contos[this.sc[0]]).p[i_113_]).oc[1] = color.getGreen();
                                    ((contos[this.sc[0]]).p[i_113_]).oc[2] = color.getBlue();
                                }
                                if (((contos[this.sc[0]]).p[i_113_]).colnum == 2) {
                                    ((contos[this.sc[0]]).p[i_113_]).hsb[0] = this.arnp[3];
                                    ((contos[this.sc[0]]).p[i_113_]).hsb[1] = this.arnp[4];
                                    ((contos[this.sc[0]]).p[i_113_]).hsb[2] = 1.0F - this.arnp[5];
                                    ((contos[this.sc[0]]).p[i_113_]).c[0] = color_112_.getRed();
                                    ((contos[this.sc[0]]).p[i_113_]).c[1] = color_112_.getGreen();
                                    ((contos[this.sc[0]]).p[i_113_]).c[2] = color_112_.getBlue();
                                    ((contos[this.sc[0]]).p[i_113_]).oc[0] = color_112_.getRed();
                                    ((contos[this.sc[0]]).p[i_113_]).oc[1] = color_112_.getGreen();
                                    ((contos[this.sc[0]]).p[i_113_]).oc[2] = color_112_.getBlue();
                                }
                            }
                        }
                    }
                }
                if (!this.remi && this.cfase != 10 && this.cfase != 11)
                    this.rd.drawImage(this.contin[this.pcontin], 355, 385, null);
                else if (this.cfase == 11 && drawcarb(true, null, "Add to My Cars", 345, 385, i, i_91_, bool) && (this.cd).action == 0) {
                    (this.cd).ac = this.sc[0];
                    if (this.logged) {
                        (this.cd).action = 6;
                        this.cd.sparkactionloader();
                    } else {
                        (this.cd).reco = -5;
                        this.cfase = 5;
                    }
                }
            }
        } else {
            if (this.cfase == 11)
                (this.cd).action = 0;
            if ((this.app).mycar.isShowing())
                (this.app).mycar.hide();
            this.pback = 0;
            this.pnext = 0;
            this.gatey = 300;
            if (this.flipo > 10) {
                (contos[this.sc[0]]).y -= 100;
                if (this.nextc == 1)
                    (contos[this.sc[0]]).zy += 20;
                if (this.nextc == -1)
                    (contos[this.sc[0]]).zy -= 20;
            } else {
                if (this.flipo == 10) {
                    if (this.nextc >= 15) {
                        this.sc[0] = this.nextc;
                        this.lsc = -1;
                    }
                    if (this.nextc == 1) {
                        this.sc[0]++;
                        if (this.gmode == 1) {
                            if (this.sc[0] == 7)
                                this.sc[0] = 11;
                            if (this.sc[0] == 12)
                                this.sc[0] = 14;
                        }
                        if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5) {
                            for (/**/; this.sc[0] < this.maxsl && Math.abs((this.cd).cclass[this.sc[0]] - (this.ontyp - 1)) > 1; this.sc[0]++) {
                                /* empty */
                            }
                        }
                    }
                    if (this.nextc == -1) {
                        this.sc[0]--;
                        if (this.gmode == 1) {
                            if (this.sc[0] == 13)
                                this.sc[0] = 11;
                            if (this.sc[0] == 10)
                                this.sc[0] = 6;
                        }
                        if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5) {
                            for (/**/; this.sc[0] > this.minsl && Math.abs((this.cd).cclass[this.sc[0]] - (this.ontyp - 1)) > 1; this.sc[0]--) {
                                /* empty */
                            }
                        }
                    }
                    (contos[this.sc[0]]).z = 950;
                    (contos[this.sc[0]]).y = -34 - (contos[this.sc[0]]).grat - 1100;
                    (contos[this.sc[0]]).x = 0;
                    (contos[this.sc[0]]).zy = 0;
                }
                (contos[this.sc[0]]).y += 100;
            }
            this.flipo--;
        }
        this.rd.drawImage(this.byrd2, 72, 408, null);
        this.rd.drawImage(this.nfmcoms2, 532, 408, null);
        if (this.cfase == 0 || this.cfase == 3 || this.cfase == 11) {
            if (i_99_ != -1) {
                if (this.flatrstart > 1)
                    this.flatrstart = 0;
                this.nextc = i_99_;
                this.flipo = 20;
            }
            if ((control).right) {
                (control).right = false;
                if (this.sc[0] != this.maxsl && this.flipo == 0) {
                    if (this.flatrstart > 1)
                        this.flatrstart = 0;
                    this.nextc = 1;
                    this.flipo = 20;
                }
            }
            if ((control).left) {
                (control).left = false;
                if (this.sc[0] != this.minsl && this.flipo == 0) {
                    if (this.flatrstart > 1)
                        this.flatrstart = 0;
                    this.nextc = -1;
                    this.flipo = 20;
                }
            }
            if (this.cfase != 11 && i_100_ == 0) {
                if ((control).handb || (control).enter) {
                    (this.m).crs = false;
                    if (this.multion != 0) {
                        this.fase = 1177;
                        this.intertrack.stop();
                    } else if (this.testdrive != 3 && this.testdrive != 4)
                        this.fase = 3;
                    else
                        this.fase = -22;
                    if (this.sc[0] < 16 || (this.cd).lastload == 2)
                        this.app.setcarcookie(this.sc[0], this.arnp, this.gmode, this.unlocked, this.mtop);
                    if (this.gmode == 0)
                        this.osc = this.sc[0];
                    if (this.gmode == 1)
                        this.scm[0] = this.sc[0];
                    if (this.gmode == 2)
                        this.scm[1] = this.sc[0];
                    if ((this.app).mycar.isShowing())
                        (this.app).mycar.hide();
                    this.flexpix = null;
                    (control).handb = false;
                    (control).enter = false;
                }
            } else if ((control).handb || (control).enter) {
                (control).handb = false;
                (control).enter = false;
            }
        } else {
            this.pback = 0;
            this.pnext = 0;
            this.pcontin = 0;
            if (this.cfase == 8 && i_99_ != -1) {
                if (this.flatrstart > 1)
                    this.flatrstart = 0;
                this.nextc = i_99_;
                this.flipo = 20;
            }
            if (this.cfase == 5 && (this.cd).action == 0 && (control).enter) {
                this.tcnt = 0;
                if (!(this.app).tnick.getText().equals("") && !(this.app).tpass.getText().equals("")) {
                    (this.app).tnick.hide();
                    (this.app).tpass.hide();
                    this.app.requestFocus();
                    (this.cd).action = 1;
                    this.cd.sparkactionloader();
                } else {
                    if ((this.app).tpass.getText().equals(""))
                        (this.cd).reco = -4;
                    if ((this.app).tnick.getText().equals(""))
                        (this.cd).reco = -3;
                }
                (control).enter = false;
            }
        }
    }
    
    public void colorCar(ContO conto, int i) {
        if (this.plnames[i].indexOf("MadBot") == -1) {
            for (int i_114_ = 0; i_114_ < (conto).npl; i_114_++) {
                if (((conto).p[i_114_]).colnum == 1) {
                    Color color = Color.getHSBColor(this.allrnp[i][0], this.allrnp[i][1], 1.0F - this.allrnp[i][2]);
                    ((conto).p[i_114_]).oc[0] = color.getRed();
                    ((conto).p[i_114_]).oc[1] = color.getGreen();
                    ((conto).p[i_114_]).oc[2] = color.getBlue();
                }
                if (((conto).p[i_114_]).colnum == 2) {
                    Color color = Color.getHSBColor(this.allrnp[i][3], this.allrnp[i][4], 1.0F - this.allrnp[i][5]);
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
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.76F));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(205, i, 390, i_116_, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(205, i, 390, i_116_, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }
    
    public void drawdprom(int i, int i_117_) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.9F));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(205, i, 390, i_117_, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(205, i, 390, i_117_, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }
    
    public void drawlprom(int i, int i_118_) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(277, i, 390, i_118_, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(277, i, 390, i_118_, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }
    
    public void finish(CheckPoints checkpoints, ContO[] contos, Control control, int i, int i_119_, boolean bool) {
        if (!this.badmac)
            this.rd.drawImage(this.fleximg, 0, 0, null);
        else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 800, 450);
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        int i_120_ = 0;
        String string = ":";
        if ((checkpoints).stage > 0) {
            int i_121_ = (checkpoints).stage;
            if (i_121_ > 10)
                i_121_ -= 10;
            string = new StringBuilder().append(" ").append(i_121_).append("!").toString();
        }
        if (this.multion < 3) {
            if (this.winner) {
                this.rd.drawImage(this.congrd, 265, 87, null);
                drawcs(137, new StringBuilder().append("You Won!  At Stage").append(string).append("").toString(), 255, 161, 85, 3);
                drawcs(154, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
                i_120_ = 154;
            } else {
                this.rd.drawImage(this.gameov, 315, 117, null);
                if (this.multion != 0 && (this.forstart == 700 || this.discon == 240)) {
                    drawcs(167, "Sorry, You where Disconnected from Game!", 255, 161, 85, 3);
                    drawcs(184, "Please check your connection!", 255, 115, 0, 3);
                } else {
                    drawcs(167, new StringBuilder().append("You Lost!  At Stage").append(string).append("").toString(), 255, 161, 85, 3);
                    drawcs(184, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
                    i_120_ = 184;
                }
            }
        } else {
            this.rd.drawImage(this.gameov, 315, 117, null);
            drawcs(167, new StringBuilder().append("Finished Watching Game!  At Stage").append(string).append("").toString(), 255, 161, 85, 3);
            drawcs(184, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
            i_120_ = 184;
        }
        if (this.winner && this.multion == 0 && this.gmode != 0 && ((checkpoints).stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 || (checkpoints).stage == 27)) {
            int i_122_ = 0;
            int i_123_ = 0;
            this.pin = 60;
            if (this.gmode == 1) {
                if ((checkpoints).stage == 2) {
                    i_122_ = 5;
                    i_123_ = 365;
                    this.pin = -20;
                    this.scm[0] = 5;
                }
                if ((checkpoints).stage == 4) {
                    i_122_ = 6;
                    i_123_ = 320;
                    this.pin = -20;
                    this.scm[0] = 6;
                }
                if ((checkpoints).stage == 6) {
                    i_122_ = 11;
                    i_123_ = 326;
                    this.pin = -20;
                    this.scm[0] = 11;
                }
                if ((checkpoints).stage == 8) {
                    i_122_ = 14;
                    i_123_ = 350;
                    this.pin = -20;
                    this.scm[0] = 14;
                }
                if ((checkpoints).stage == 10) {
                    i_122_ = 15;
                    i_123_ = 370;
                    this.pin = -20;
                    this.scm[0] = 15;
                }
            }
            if (this.gmode == 2) {
                if ((checkpoints).stage == 12) {
                    i_122_ = 8;
                    i_123_ = 365;
                    this.pin = -20;
                    this.scm[1] = 8;
                }
                if ((checkpoints).stage == 14) {
                    i_122_ = 9;
                    i_123_ = 320;
                    this.pin = -20;
                    this.scm[1] = 9;
                }
                if ((checkpoints).stage == 16) {
                    i_122_ = 10;
                    i_123_ = 370;
                    this.pin = -20;
                    this.scm[1] = 10;
                }
                if ((checkpoints).stage == 18) {
                    i_122_ = 11;
                    i_123_ = 326;
                    this.pin = -20;
                    this.scm[1] = 11;
                }
                if ((checkpoints).stage == 20) {
                    i_122_ = 12;
                    i_123_ = 310;
                    this.pin = -20;
                    this.scm[1] = 12;
                }
                if ((checkpoints).stage == 22) {
                    i_122_ = 13;
                    i_123_ = 310;
                    this.pin = -20;
                    this.scm[1] = 13;
                }
                if ((checkpoints).stage == 24) {
                    i_122_ = 14;
                    i_123_ = 350;
                    this.pin = -20;
                    this.scm[1] = 14;
                }
                if ((checkpoints).stage == 26) {
                    i_122_ = 15;
                    i_123_ = 370;
                    this.pin = -20;
                    this.scm[1] = 15;
                }
            }
            if ((checkpoints).stage != 27) {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.aflk)
                    drawcs(200 + this.pin, new StringBuilder().append("Stage ").append((checkpoints).stage + 1 - (this.gmode - 1) * 10).append(" is now unlocked!").toString(), 196, 176, 0, 3);
                else
                    drawcs(200 + this.pin, new StringBuilder().append("Stage ").append((checkpoints).stage + 1 - (this.gmode - 1) * 10).append(" is now unlocked!").toString(), 255, 247, 165, 3);
                if (i_122_ != 0) {
                    if (this.aflk)
                        drawcs(200, "And:", 196, 176, 0, 3);
                    else
                        drawcs(200, "And:", 255, 247, 165, 3);
                    this.rd.setColor(new Color(236, 226, 202));
                    if (Math.random() > 0.5) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
                        this.rd.fillRect(226, 211, 344, 125);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(226, 211, 348, 4);
                    this.rd.fillRect(226, 211, 4, 125);
                    this.rd.fillRect(226, 332, 348, 4);
                    this.rd.fillRect(570, 211, 4, 125);
                    (contos[i_122_]).y = i_123_;
                    (this.m).crs = true;
                    (this.m).x = -400;
                    (this.m).y = 0;
                    (this.m).z = -50;
                    (this.m).xz = 0;
                    (this.m).zy = 0;
                    (this.m).ground = 2470;
                    (contos[i_122_]).z = 1000;
                    (contos[i_122_]).x = 0;
                    (contos[i_122_]).xz += 5;
                    (contos[i_122_]).zy = 0;
                    (contos[i_122_]).wzy -= 10;
                    contos[i_122_].d(this.rd);
                    if (Math.random() < 0.5) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        this.rd.setColor(new Color(236, 226, 202));
                        for (int i_124_ = 0; i_124_ < 30; i_124_++)
                            this.rd.drawLine(230, 215 + 4 * i_124_, 569, 215 + 4 * i_124_);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    String string_125_ = "";
                    if (i_122_ == 13)
                        string_125_ = " ";
                    if (this.aflk)
                        drawcs(320, new StringBuilder().append("").append((this.cd).names[i_122_]).append("").append(string_125_).append(" has been unlocked!").toString(), 196, 176, 0, 3);
                    else
                        drawcs(320, new StringBuilder().append("").append((this.cd).names[i_122_]).append("").append(string_125_).append(" has been unlocked!").toString(), 255, 247, 165, 3);
                    this.pin = 140;
                }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                drawcs(220 + this.pin, "GAME SAVED", 230, 167, 0, 3);
                if (this.pin == 60)
                    this.pin = 30;
                else
                    this.pin = 0;
            } else {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.aflk)
                    drawcs(180, new StringBuilder().append("Woohoooo you finished NFM").append(this.gmode).append(" !!!").toString(), 144, 167, 255, 3);
                else
                    drawcs(180, new StringBuilder().append("Woohoooo you finished NFM").append(this.gmode).append(" !!!").toString(), 228, 240, 255, 3);
                if (this.aflk)
                    drawcs(210, "You're Awesome!", 144, 167, 255, 3);
                else
                    drawcs(212, "You're Awesome!", 228, 240, 255, 3);
                if (this.aflk)
                    drawcs(240, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
                else
                    drawcs(240, "You're truly a RADICAL GAMER!", 255, 100, 100, 3);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.fillRect(0, 255, 800, 62);
                this.rd.drawImage(this.radicalplay, this.radpx + (int) (8.0 * Math.random() - 4.0), 255, null);
                if (this.radpx != 212) {
                    this.radpx += 40;
                    if (this.radpx > 800)
                        this.radpx = -468;
                }
                if (this.flipo == 40)
                    this.radpx = 213;
                this.flipo++;
                if (this.flipo == 70)
                    this.flipo = 0;
                if (this.radpx == 212) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.aflk)
                        drawcs(309, "A Game by Radicalplay.com", 144, 167, 255, 3);
                    else
                        drawcs(309, "A Game by Radicalplay.com", 228, 240, 255, 3);
                }
                if (this.aflk)
                    drawcs(350, "Now get up and dance!", 144, 167, 255, 3);
                else
                    drawcs(350, "Now get up and dance!", 228, 240, 255, 3);
                this.pin = 0;
            }
            if (this.aflk)
                this.aflk = false;
            else
                this.aflk = true;
        }
        if (this.multion != 0 && (checkpoints).stage == -2 && i_120_ != 0) {
            drawcs(i_120_ + 17, new StringBuilder().append("Created by: ").append((checkpoints).maker).append("").toString(), 255, 161, 85, 3);
            if ((checkpoints).pubt > 0) {
                if ((checkpoints).pubt == 2)
                    drawcs(310, "Super Public Stage", 41, 177, 255, 3);
                else
                    drawcs(310, "Public Stage", 41, 177, 255, 3);
                if (this.dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 317, i, i_119_, bool)) {
                    if (this.logged) {
                        (this.cd).onstage = (checkpoints).name;
                        (this.cd).staction = 2;
                        this.cd.sparkstageaction();
                        this.dnload = 2;
                    } else {
                        this.dnload = 1;
                        this.waitlink = 20;
                    }
                }
                if (this.dnload == 1) {
                    this.rd.setColor(new Color(193, 106, 0));
                    String string_126_ = "Upgrade to a full account to add custom stages!";
                    int i_127_ = 400 - this.ftm.stringWidth(string_126_) / 2;
                    int i_128_ = i_127_ + this.ftm.stringWidth(string_126_);
                    this.rd.drawString(string_126_, i_127_, 332);
                    if (this.waitlink != -1)
                        this.rd.drawLine(i_127_, 334, i_128_, 334);
                    if (i > i_127_ && i < i_128_ && i_119_ > 321 && i_119_ < 334) {
                        if (this.waitlink != -1)
                            this.app.setCursor(new Cursor(12));
                        if (bool && this.waitlink == 0) {
                            this.app.editlink(this.nickname);
                            this.waitlink = -1;
                        }
                    } else
                        this.app.setCursor(new Cursor(0));
                    if (this.waitlink > 0)
                        this.waitlink--;
                }
                if (this.dnload == 2) {
                    drawcs(332, "Adding stage please wait...", 193, 106, 0, 3);
                    if ((this.cd).staction == 0)
                        this.dnload = 3;
                    if ((this.cd).staction == -2)
                        this.dnload = 4;
                    if ((this.cd).staction == -3)
                        this.dnload = 5;
                    if ((this.cd).staction == -1)
                        this.dnload = 6;
                }
                if (this.dnload == 3)
                    drawcs(332, "Stager has been successfully added to your stages!", 193, 106, 0, 3);
                if (this.dnload == 4)
                    drawcs(332, "You already have this stage!", 193, 106, 0, 3);
                if (this.dnload == 5)
                    drawcs(332, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                if (this.dnload == 6)
                    drawcs(332, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
            } else
                drawcs(342, "Private Stage", 193, 106, 0, 3);
        }
        this.rd.drawImage(this.contin[this.pcontin], 355, 380, null);
        if ((control).enter || (control).handb) {
            if (this.loadedt)
                this.strack.unload();
            if (this.multion == 0) {
                this.opselect = 3;
                if (this.gmode == 1) {
                    this.opselect = 0;
                    if (this.winner && (checkpoints).stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 && (checkpoints).stage != 27) {
                        this.unlocked[this.gmode - 1]++;
                        this.justwon1 = true;
                    } else
                        this.justwon1 = false;
                }
                if (this.gmode == 2) {
                    this.opselect = 1;
                    if (this.winner && (checkpoints).stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 && (checkpoints).stage != 27) {
                        this.unlocked[this.gmode - 1]++;
                        this.justwon2 = true;
                    } else
                        this.justwon2 = false;
                }
                if ((checkpoints).stage == 27 && this.gmode == 0)
                    (checkpoints).stage = (int) (Math.random() * 27.0) + 1;
                this.fase = 102;
            } else if (!this.mtop || this.nfreeplays >= 5 && !this.logged) {
                this.opselect = 2;
                this.fase = 102;
            } else
                this.fase = -9;
            if (this.multion == 0 && this.winner && (checkpoints).stage != 27 && (checkpoints).stage > 0)
                (checkpoints).stage++;
            if (!this.winner && this.multion != 0 && (this.forstart == 700 || this.discon == 240) && this.ndisco < 5)
                this.ndisco++;
            this.flipo = 0;
            (control).enter = false;
            (control).handb = false;
        }
    }
    
    public void sortcars(int i) {
        if (i != 0) {
            for (int i_129_ = 1; i_129_ < 7; i_129_++)
                this.sc[i_129_] = -1;
            boolean[] bools = new boolean[7];
            if (i < 0)
                i = 27;
            int i_130_ = 7;
            if (this.gmode == 1)
                i_130_ = 5;
            boolean bool = false;
            if (i <= 10) {
                int i_131_ = 6;
                if (this.gmode == 1)
                    i_131_ = 4;
                if ((i == 1 || i == 2) && this.sc[0] != 5) {
                    this.sc[i_131_] = 5;
                    i_130_ = i_131_;
                }
                if ((i == 3 || i == 4) && this.sc[0] != 6) {
                    this.sc[i_131_] = 6;
                    i_130_ = i_131_;
                }
                if ((i == 5 || i == 6) && this.sc[0] != 11) {
                    this.sc[i_131_] = 11;
                    i_130_ = i_131_;
                }
                if ((i == 7 || i == 8) && this.sc[0] != 14) {
                    this.sc[i_131_] = 14;
                    i_130_ = i_131_;
                }
                if ((i == 9 || i == 10) && this.sc[0] != 15) {
                    this.sc[i_131_] = 15;
                    i_130_ = i_131_;
                }
            } else {
                i -= 10;
                bool = true;
                if (this.sc[0] != 7 + (i + 1) / 2 && i != 17) {
                    this.sc[6] = 7 + (i + 1) / 2;
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
                    this.sc[i_135_] = (int) (Math.random() * (double) (24.0F + 8.0F * ((float) i / f)));
                    if (this.sc[i_135_] >= 16)
                        this.sc[i_135_] -= 16;
                    bools[i_135_] = true;
                    for (int i_136_ = 0; i_136_ < 7; i_136_++) {
                        if (i_135_ != i_136_ && this.sc[i_135_] == this.sc[i_136_])
                            bools[i_135_] = false;
                    }
                    if (bool)
                        f = 16.0F;
                    float f_137_ = (float) (15 - this.sc[i_135_]) / 15.0F * ((float) i / f);
                    if ((double) f_137_ > 0.8)
                        f_137_ = 0.8F;
                    if (i == 17 && (double) f_137_ > 0.5)
                        f_137_ = 0.5F;
                    if ((double) f_137_ > Math.random())
                        bools[i_135_] = false;
                    if (this.gmode == 1) {
                        if (this.sc[i_135_] >= 7 && this.sc[i_135_] <= 10)
                            bools[i_135_] = false;
                        if (this.sc[i_135_] == 12 || this.sc[i_135_] == 13)
                            bools[i_135_] = false;
                        if (this.sc[i_135_] > 5 && this.unlocked[0] <= 2)
                            bools[i_135_] = false;
                        if (this.sc[i_135_] > 6 && this.unlocked[0] <= 4)
                            bools[i_135_] = false;
                        if (this.sc[i_135_] > 11 && this.unlocked[0] <= 6)
                            bools[i_135_] = false;
                        if (this.sc[i_135_] > 14 && this.unlocked[0] <= 8)
                            bools[i_135_] = false;
                    }
                    if (this.gmode == 2) {
                        if ((this.sc[i_135_] - 7) * 2 > this.unlocked[1])
                            bools[i_135_] = false;
                        if (i == 16 && this.unlocked[1] == 16 && this.sc[i_135_] < 9)
                            bools[i_135_] = false;
                    }
                }
                if (this.sc[i_135_] < i_132_) {
                    i_132_ = this.sc[i_135_];
                    if (i_133_ != i_135_) {
                        i_134_ = i_133_;
                        i_133_ = i_135_;
                    }
                }
            }
            if (!bool && i == 10) {
                boolean bool_138_ = false;
                for (int i_139_ = 0; i_139_ < 7; i_139_++) {
                    if (this.sc[i_139_] == 11)
                        bool_138_ = true;
                }
                if (!bool_138_ && (Math.random() > Math.random() || this.gmode != 0))
                    this.sc[i_133_] = 11;
                bool_138_ = false;
                for (int i_140_ = 0; i_140_ < 7; i_140_++) {
                    if (this.sc[i_140_] == 14)
                        bool_138_ = true;
                }
                if (!bool_138_ && (Math.random() > Math.random() || this.gmode != 0))
                    this.sc[i_134_] = 14;
            }
            if (i == 12) {
                boolean bool_141_ = false;
                for (int i_142_ = 0; i_142_ < 7; i_142_++) {
                    if (this.sc[i_142_] == 11)
                        bool_141_ = true;
                }
                if (!bool_141_)
                    this.sc[i_133_] = 11;
            }
            if (i == 14) {
                boolean bool_143_ = false;
                for (int i_144_ = 0; i_144_ < 7; i_144_++) {
                    if (this.sc[i_144_] == 12)
                        bool_143_ = true;
                }
                if (!bool_143_ && (Math.random() > Math.random() || this.gmode != 0))
                    this.sc[i_133_] = 12;
                bool_143_ = false;
                for (int i_145_ = 0; i_145_ < 7; i_145_++) {
                    if (this.sc[i_145_] == 10)
                        bool_143_ = true;
                }
                if (!bool_143_ && (Math.random() > Math.random() || this.gmode != 0))
                    this.sc[i_134_] = 10;
            }
            if (i == 15) {
                boolean bool_146_ = false;
                for (int i_147_ = 0; i_147_ < 7; i_147_++) {
                    if (this.sc[i_147_] == 11)
                        bool_146_ = true;
                }
                if (!bool_146_ && (Math.random() > Math.random() || this.gmode != 0))
                    this.sc[i_133_] = 11;
                bool_146_ = false;
                for (int i_148_ = 0; i_148_ < 7; i_148_++) {
                    if (this.sc[i_148_] == 13)
                        bool_146_ = true;
                }
                if (!bool_146_ && (Math.random() > Math.random() || this.gmode != 0))
                    this.sc[i_134_] = 13;
            }
            if (i == 16) {
                boolean bool_149_ = false;
                for (int i_150_ = 0; i_150_ < 7; i_150_++) {
                    if (this.sc[i_150_] == 13)
                        bool_149_ = true;
                }
                if (!bool_149_ && (Math.random() > Math.random() || this.gmode != 0))
                    this.sc[i_133_] = 13;
                bool_149_ = false;
                for (int i_151_ = 0; i_151_ < 7; i_151_++) {
                    if (this.sc[i_151_] == 12)
                        bool_149_ = true;
                }
                if (!bool_149_ && (Math.random() > Math.random() || this.gmode != 0))
                    this.sc[i_134_] = 12;
            }
            if ((this.cd).lastload == 1) {
                int i_152_ = 0;
                for (int i_153_ = 0; i_153_ < (this.cd).nlcars - 16; i_153_++) {
                    if (i_152_ == 0) {
                        for (int i_154_ = 1; i_154_ < i_130_; i_154_++)
                            bools[i_154_] = false;
                    }
                    if ((this.cd).include[i_153_] && this.sc[0] != i_153_ + 16) {
                        int i_155_;
                        for (i_155_ = (int) (1.0 + Math.random() * (double) (i_130_ - 1)); bools[i_155_]; i_155_ = (int) (1.0 + Math.random() * (double) (i_130_ - 1))) {
                            /* empty */
                        }
                        bools[i_155_] = true;
                        this.sc[i_155_] = i_153_ + 16;
                        if (++i_152_ == i_130_ - 1)
                            i_152_ = 0;
                    }
                }
            }
            if ((this.cd).lastload == 2) {
                int i_156_ = 0;
                for (int i_157_ = 0; i_157_ < (this.cd).nlocars - 16; i_157_++) {
                    if (i_156_ == 0) {
                        for (int i_158_ = 1; i_158_ < i_130_; i_158_++)
                            bools[i_158_] = false;
                    }
                    if ((this.cd).include[i_157_] && this.sc[0] != i_157_ + 16) {
                        int i_159_;
                        for (i_159_ = (int) (1.0 + Math.random() * (double) (i_130_ - 1)); bools[i_159_]; i_159_ = (int) (1.0 + Math.random() * (double) (i_130_ - 1))) {
                            /* empty */
                        }
                        bools[i_159_] = true;
                        this.sc[i_159_] = i_157_ + 16;
                        if (++i_156_ == i_130_ - 1)
                            i_156_ = 0;
                    }
                }
            }
        }
    }
    
    public void ctachm(int i, int i_160_, int i_161_, Control control) {
        if (this.fase == 1) {
            if (i_161_ == 1) {
                if (over(this.next[0], i, i_160_, 625, 135))
                    this.pnext = 1;
                if (over(this.back[0], i, i_160_, 115, 135))
                    this.pback = 1;
                if (over(this.contin[0], i, i_160_, 355, 360))
                    this.pcontin = 1;
            }
            if (i_161_ == 2) {
                if (this.pnext == 1)
                    (control).right = true;
                if (this.pback == 1)
                    (control).left = true;
                if (this.pcontin == 1)
                    (control).enter = true;
            }
        }
        if (this.fase == 3) {
            if (i_161_ == 1 && over(this.contin[0], i, i_160_, 355, 350))
                this.pcontin = 1;
            if (i_161_ == 2 && this.pcontin == 1) {
                (control).enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == 4) {
            if (i_161_ == 1 && over(this.back[0], i, i_160_, 370, 345))
                this.pback = 1;
            if (i_161_ == 2 && this.pback == 1) {
                (control).enter = true;
                this.pback = 0;
            }
        }
        if (this.fase == 6) {
            if (i_161_ == 1 && (over(this.star[0], i, i_160_, 359, 385) || over(this.star[0], i, i_160_, 359, 295)))
                this.pstar = 2;
            if (i_161_ == 2 && this.pstar == 2) {
                (control).enter = true;
                this.pstar = 1;
            }
        }
        if (this.fase == 7) {
            if (i_161_ == 1) {
                if (over(this.next[0], i, i_160_, 645, 275))
                    this.pnext = 1;
                if (over(this.back[0], i, i_160_, 95, 275))
                    this.pback = 1;
                if (over(this.contin[0], i, i_160_, 355, 385))
                    this.pcontin = 1;
            }
            if (i_161_ == 2) {
                if (this.pnext == 1)
                    (control).right = true;
                if (this.pback == 1)
                    (control).left = true;
                if (this.pcontin == 1) {
                    (control).enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == -5) {
            this.lxm = i;
            this.lym = i_160_;
            if (i_161_ == 1 && over(this.contin[0], i, i_160_, 355, 380))
                this.pcontin = 1;
            if (i_161_ == 2 && this.pcontin == 1) {
                (control).enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == -7) {
            if (i_161_ == 1) {
                if (overon(329, 45, 137, 22, i, i_160_)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (overon(320, 73, 155, 22, i, i_160_)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (overon(303, 99, 190, 22, i, i_160_)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (overon(341, 125, 109, 22, i, i_160_)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (i_161_ == 2 && this.shaded) {
                (control).enter = true;
                this.shaded = false;
            }
            if (i_161_ == 0 && (i != this.lxm || i_160_ != this.lym)) {
                if (overon(329, 45, 137, 22, i, i_160_))
                    this.opselect = 0;
                if (overon(320, 73, 155, 22, i, i_160_))
                    this.opselect = 1;
                if (overon(303, 99, 190, 22, i, i_160_))
                    this.opselect = 2;
                if (overon(341, 125, 109, 22, i, i_160_))
                    this.opselect = 3;
                this.lxm = i;
                this.lym = i_160_;
            }
        }
        if (this.fase == 10) {
            if (i_161_ == 1) {
                if (overon(343, 261, 110, 22, i, i_160_)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (overon(288, 291, 221, 22, i, i_160_)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (overon(301, 321, 196, 22, i, i_160_)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (overon(357, 351, 85, 22, i, i_160_)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (i_161_ == 2 && this.shaded) {
                (control).enter = true;
                this.shaded = false;
            }
            if (i_161_ == 0 && (i != this.lxm || i_160_ != this.lym)) {
                if (overon(343, 261, 110, 22, i, i_160_))
                    this.opselect = 0;
                if (overon(288, 291, 221, 22, i, i_160_))
                    this.opselect = 1;
                if (overon(301, 321, 196, 22, i, i_160_))
                    this.opselect = 2;
                if (overon(357, 351, 85, 22, i, i_160_))
                    this.opselect = 3;
                this.lxm = i;
                this.lym = i_160_;
            }
        }
        if (this.fase == 102) {
            if (i_161_ == 1) {
                if (overon(358, 262 + this.dropf, 82, 22, i, i_160_)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (overon(358, 290 + this.dropf, 82, 22, i, i_160_)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (overon(333, 318 + this.dropf, 132, 22, i, i_160_)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (this.dropf == 0 && overon(348, 346, 102, 22, i, i_160_)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (i_161_ == 2 && this.shaded) {
                (control).enter = true;
                this.shaded = false;
            }
            if (i_161_ == 0 && (i != this.lxm || i_160_ != this.lym)) {
                if (overon(358, 262 + this.dropf, 82, 22, i, i_160_))
                    this.opselect = 0;
                if (overon(358, 290 + this.dropf, 82, 22, i, i_160_))
                    this.opselect = 1;
                if (overon(333, 318 + this.dropf, 132, 22, i, i_160_))
                    this.opselect = 2;
                if (this.dropf == 0 && overon(348, 346, 102, 22, i, i_160_))
                    this.opselect = 3;
                this.lxm = i;
                this.lym = i_160_;
            }
        }
        if (this.fase == 11) {
            if (this.flipo >= 1 && this.flipo <= 15) {
                if (i_161_ == 1 && over(this.next[0], i, i_160_, 665, 395))
                    this.pnext = 1;
                if (i_161_ == 2 && this.pnext == 1) {
                    (control).right = true;
                    this.pnext = 0;
                }
            }
            if (this.flipo >= 3 && this.flipo <= 16) {
                if (i_161_ == 1 && over(this.back[0], i, i_160_, 75, 395))
                    this.pback = 1;
                if (i_161_ == 2 && this.pback == 1) {
                    (control).left = true;
                    this.pback = 0;
                }
            }
            if (this.flipo == 16) {
                if (i_161_ == 1 && over(this.contin[0], i, i_160_, 565, 395))
                    this.pcontin = 1;
                if (i_161_ == 2 && this.pcontin == 1) {
                    (control).enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == 8) {
            if (i_161_ == 1 && over(this.next[0], i, i_160_, 665, 395))
                this.pnext = 1;
            if (i_161_ == 2 && this.pnext == 1) {
                (control).enter = true;
                this.pnext = 0;
            }
        }
    }
    
    public void stat(Mad mad, CheckPoints checkpoints, Control control, boolean bool) {
        if (this.holdit) {
            int i = 250;
            if (this.fase == 7001) {
                if (this.exitm != 4) {
                    this.exitm = 0;
                    i = 600;
                } else
                    i = 1200;
            }
            if (this.exitm != 4 || !this.lan || this.im != 0) {
                this.holdcnt++;
                if (((control).enter || this.holdcnt > i) && (!(control).chatup || this.fase != 7001)) {
                    this.fase = -2;
                    (control).enter = false;
                }
            } else if ((control).enter)
                (control).enter = false;
        } else {
            if (this.holdcnt != 0)
                this.holdcnt = 0;
            if ((control).enter || (control).exit) {
                if (this.fase == 0) {
                    if (this.loadedt)
                        this.strack.stop();
                    this.fase = -6;
                } else if (this.starcnt == 0 && !(control).chatup && (this.multion < 2 || !this.lan)) {
                    if (this.exitm == 0)
                        this.exitm = 1;
                    else
                        this.exitm = 0;
                }
                if (!(control).chatup || this.fase != 7001)
                    (control).enter = false;
                (control).exit = false;
            }
        }
        if (this.exitm == 2) {
            this.fase = -2;
            this.winner = false;
        }
        if (this.fase != -2) {
            if (this.multion < 2) {
                this.holdit = false;
                if ((checkpoints).wasted == this.nplayers - 1 && this.nplayers != 1) {
                    drawhi(this.youwastedem, 70);
                    if (this.aflk) {
                        drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    (checkpoints).haltall = true;
                    this.holdit = true;
                    this.winner = true;
                }
                if (!this.holdit && (mad).dest && this.cntwis == 8) {
                    if (this.discon != 240)
                        drawhi(this.yourwasted, 70);
                    else {
                        drawhi(this.disco, 70);
                        stopchat();
                    }
                    boolean bool_162_ = false;
                    if (this.lan) {
                        bool_162_ = true;
                        for (int i = 0; i < this.nplayers; i++) {
                            if (i != this.im && this.dested[i] == 0 && this.plnames[i].indexOf("MadBot") == -1)
                                bool_162_ = false;
                        }
                    }
                    if (this.fase == 7001 && this.nplayers - ((checkpoints).wasted + 1) >= 2 && this.discon != 240 && !bool_162_)
                        this.exitm = 4;
                    else {
                        if (this.exitm == 4)
                            this.exitm = 0;
                        drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    }
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) {
                    for (int i = 0; i < this.nplayers; i++) {
                        if ((checkpoints).clear[i] == (checkpoints).nlaps * (checkpoints).nsp && (checkpoints).pos[i] == 0) {
                            if (i == this.im) {
                                drawhi(this.youwon, 70);
                                if (this.aflk) {
                                    drawcs(120, "You finished first, nice job!", 0, 0, 0, 0);
                                    this.aflk = false;
                                } else {
                                    drawcs(120, "You finished first, nice job!", 0, 128, 255, 0);
                                    this.aflk = true;
                                }
                                this.winner = true;
                            } else {
                                drawhi(this.youlost, 70);
                                if (this.fase != 7001) {
                                    if (this.aflk) {
                                        drawcs(120, new StringBuilder().append("").append((this.cd).names[this.sc[i]]).append(" finished first, race over!").toString(), 0, 0, 0, 0);
                                        this.aflk = false;
                                    } else {
                                        drawcs(120, new StringBuilder().append("").append((this.cd).names[this.sc[i]]).append(" finished first, race over!").toString(), 0, 128, 255, 0);
                                        this.aflk = true;
                                    }
                                } else if (this.aflk) {
                                    drawcs(120, new StringBuilder().append("").append(this.plnames[i]).append(" finished first, race over!").toString(), 0, 0, 0, 0);
                                    this.aflk = false;
                                } else {
                                    drawcs(120, new StringBuilder().append("").append(this.plnames[i]).append(" finished first, race over!").toString(), 0, 128, 255, 0);
                                    this.aflk = true;
                                }
                                this.winner = false;
                            }
                            drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                            (checkpoints).haltall = true;
                            this.holdit = true;
                        }
                    }
                }
            } else {
                this.holdit = false;
                if ((checkpoints).wasted >= this.nplayers - 1) {
                    String string = "Someone";
                    for (int i = 0; i < this.nplayers; i++) {
                        if ((checkpoints).dested[i] == 0)
                            string = this.plnames[i];
                    }
                    drawhi(this.gamefinished, 70);
                    if (this.aflk) {
                        drawcs(120, new StringBuilder().append("").append(string).append(" has wasted all the cars!").toString(), 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        drawcs(120, new StringBuilder().append("").append(string).append(" has wasted all the cars!").toString(), 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    (checkpoints).haltall = true;
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) {
                    for (int i = 0; i < this.nplayers; i++) {
                        if ((checkpoints).clear[i] == (checkpoints).nlaps * (checkpoints).nsp && (checkpoints).pos[i] == 0) {
                            drawhi(this.gamefinished, 70);
                            if (this.aflk) {
                                drawcs(120, new StringBuilder().append("").append(this.plnames[i]).append(" finished first, race over!").toString(), 0, 0, 0, 0);
                                this.aflk = false;
                            } else {
                                drawcs(120, new StringBuilder().append("").append(this.plnames[i]).append(" finished first, race over!").toString(), 0, 128, 255, 0);
                                this.aflk = true;
                            }
                            drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                            (checkpoints).haltall = true;
                            this.holdit = true;
                            this.winner = false;
                        }
                    }
                }
                if (!this.holdit && this.discon == 240) {
                    drawhi(this.gamefinished, 70);
                    if (this.aflk) {
                        drawcs(120, "Game got disconnected!", 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        drawcs(120, "Game got disconnected!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    (checkpoints).haltall = true;
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) {
                    this.rd.drawImage(this.wgame, 311, 20, null);
                    drawcs(397, "Click any player on the right to follow!", 0, 0, 0, 0);
                    if (!this.lan)
                        drawcs(412, "Press [V] to change view.  Press [Enter] to exit.", 0, 0, 0, 0);
                    else
                        drawcs(412, "Press [V] to change view.", 0, 0, 0, 0);
                }
            }
            if (bool) {
                if ((checkpoints).stage != 10 && this.multion < 2 && this.nplayers != 1 && this.arrace != (control).arrace) {
                    this.arrace = (control).arrace;
                    if (this.arrace) {
                        this.wasay = true;
                        this.say = " Arrow now pointing at  Cars  <";
                        this.tcnt = -5;
                    }
                    if (!this.arrace) {
                        this.wasay = false;
                        this.say = " Arrow now pointing at  Track  <";
                        this.tcnt = -5;
                        this.cntan = 20;
                        this.alocked = -1;
                        this.alocked = -1;
                    }
                }
                if (!this.holdit && this.fase != -6 && this.starcnt == 0 && this.multion < 2 && (checkpoints).stage != 10) {
                    arrow((mad).point, (mad).missedcp, checkpoints, this.arrace);
                    if (!this.arrace) {
                        if (this.auscnt == 45 && (mad).capcnt == 0 && this.exitm == 0) {
                            if ((mad).missedcp > 0) {
                                if ((mad).missedcp > 15 && (mad).missedcp < 50) {
                                    if (this.flk)
                                        drawcs(70, "Checkpoint Missed!", 255, 0, 0, 0);
                                    else
                                        drawcs(70, "Checkpoint Missed!", 255, 150, 0, 2);
                                }
                                (mad).missedcp++;
                                if ((mad).missedcp == 70)
                                    (mad).missedcp = -2;
                            } else if ((mad).mtouch && this.cntovn < 70) {
                                if (Math.abs(this.ana) > 100)
                                    this.cntan++;
                                else if (this.cntan != 0)
                                    this.cntan--;
                                if (this.cntan > 40) {
                                    this.cntovn++;
                                    this.cntan = 40;
                                    if (this.flk) {
                                        drawcs(70, "Wrong Way!", 255, 150, 0, 0);
                                        this.flk = false;
                                    } else {
                                        drawcs(70, "Wrong Way!", 255, 0, 0, 2);
                                        this.flk = true;
                                    }
                                }
                            }
                        }
                    } else if (this.alocked != this.lalocked) {
                        if (this.alocked != -1) {
                            this.wasay = true;
                            this.say = new StringBuilder().append(" Arrow Locked on   ").append(this.plnames[this.alocked]).append("   <").toString();
                            this.tcnt = -5;
                        } else {
                            this.wasay = true;
                            this.say = "Arrow Unlocked!";
                            this.tcnt = 10;
                        }
                        this.lalocked = this.alocked;
                    }
                }
                if ((this.m).darksky) {
                    Color color = new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]);
                    float[] fs = new float[3];
                    Color.RGBtoHSB((this.m).csky[0], (this.m).csky[1], (this.m).csky[2], fs);
                    fs[2] = 0.6F;
                    color = Color.getHSBColor(fs[0], fs[1], fs[2]);
                    this.rd.setColor(color);
                    this.rd.fillRect(602, 9, 54, 14);
                    this.rd.drawLine(601, 10, 601, 21);
                    this.rd.drawLine(600, 12, 600, 19);
                    this.rd.fillRect(607, 29, 49, 14);
                    this.rd.drawLine(606, 30, 606, 41);
                    this.rd.drawLine(605, 32, 605, 39);
                    this.rd.fillRect(18, 6, 155, 14);
                    this.rd.drawLine(17, 7, 17, 18);
                    this.rd.drawLine(16, 9, 16, 16);
                    this.rd.drawLine(173, 7, 173, 18);
                    this.rd.drawLine(174, 9, 174, 16);
                    this.rd.fillRect(40, 26, 107, 21);
                    this.rd.drawLine(39, 27, 39, 45);
                    this.rd.drawLine(38, 29, 38, 43);
                    this.rd.drawLine(147, 27, 147, 45);
                    this.rd.drawLine(148, 29, 148, 43);
                }
                this.rd.drawImage(this.dmg, 600, 7, null);
                this.rd.drawImage(this.pwr, 600, 27, null);
                this.rd.drawImage(this.lap, 19, 7, null);
                this.rd.setColor(new Color(0, 0, 100));
                this.rd.drawString(new StringBuilder().append("").append((mad).nlaps + 1).append(" / ").append((checkpoints).nlaps).append("").toString(), 51, 18);
                this.rd.drawImage(this.was, 92, 7, null);
                this.rd.setColor(new Color(0, 0, 100));
                this.rd.drawString(new StringBuilder().append("").append((checkpoints).wasted).append(" / ").append(this.nplayers - 1).append("").toString(), 150, 18);
                this.rd.drawImage(this.pos, 42, 27, null);
                this.rd.drawImage(this.rank[(checkpoints).pos[(mad).im]], 110, 28, null);
                drawstat((this.cd).maxmag[(mad).cn], (mad).hitmag, (mad).newcar, (mad).power);
            }
            if (!this.holdit) {
                if (this.starcnt != 0 && this.starcnt <= 35) {
                    if (this.starcnt == 35 && !this.mutes)
                        this.three.play();
                    if (this.starcnt == 24) {
                        this.gocnt = 2;
                        if (!this.mutes)
                            this.two.play();
                    }
                    if (this.starcnt == 13) {
                        this.gocnt = 1;
                        if (!this.mutes)
                            this.one.play();
                    }
                    if (this.starcnt == 2) {
                        this.gocnt = 0;
                        if (!this.mutes)
                            this.go.play();
                    }
                    this.duds = 0;
                    if (this.starcnt <= 37 && this.starcnt > 32)
                        this.duds = 1;
                    if (this.starcnt <= 26 && this.starcnt > 21)
                        this.duds = 1;
                    if (this.starcnt <= 15 && this.starcnt > 10)
                        this.duds = 1;
                    if (this.starcnt <= 4)
                        this.duds = 2;
                    if (this.dudo != -1) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        this.rd.drawImage(this.dude[this.duds], this.dudo, 0, null);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    if (this.gocnt != 0)
                        this.rd.drawImage(this.cntdn[this.gocnt], 385, 50, null);
                    else
                        this.rd.drawImage(this.cntdn[this.gocnt], 363, 50, null);
                }
                if (this.looped != 0 && (mad).loop == 2)
                    this.looped = 0;
                if ((mad).power < 45.0F) {
                    if (this.tcnt == 30 && this.auscnt == 45 && (mad).mtouch && (mad).capcnt == 0 && this.exitm == 0) {
                        if (this.looped != 2) {
                            if (this.pwcnt < 70 || this.pwcnt < 100 && this.looped != 0) {
                                if (this.pwflk) {
                                    drawcs(110, "Power low, perform stunt!", 0, 0, 200, 0);
                                    this.pwflk = false;
                                } else {
                                    drawcs(110, "Power low, perform stunt!", 255, 100, 0, 0);
                                    this.pwflk = true;
                                }
                            }
                        } else if (this.pwcnt < 100) {
                            String string = "";
                            if (this.multion == 0)
                                string = "  (Press Enter)";
                            if (this.pwflk) {
                                drawcs(110, new StringBuilder().append("Please read the Game Instructions!").append(string).append("").toString(), 0, 0, 200, 0);
                                this.pwflk = false;
                            } else {
                                drawcs(110, new StringBuilder().append("Please read the Game Instructions!").append(string).append("").toString(), 255, 100, 0, 0);
                                this.pwflk = true;
                            }
                        }
                        this.pwcnt++;
                        if (this.pwcnt == 300) {
                            this.pwcnt = 0;
                            if (this.looped != 0) {
                                this.looped++;
                                if (this.looped == 4)
                                    this.looped = 2;
                            }
                        }
                    }
                } else if (this.pwcnt != 0)
                    this.pwcnt = 0;
                if ((mad).capcnt == 0) {
                    if (this.tcnt < 30) {
                        if (this.exitm == 0) {
                            if (this.tflk) {
                                if (!this.wasay)
                                    drawcs(105, this.say, 0, 0, 0, 0);
                                else
                                    drawcs(105, this.say, 0, 0, 0, 0);
                                this.tflk = false;
                            } else {
                                if (!this.wasay)
                                    drawcs(105, this.say, 0, 128, 255, 0);
                                else
                                    drawcs(105, this.say, 255, 128, 0, 0);
                                this.tflk = true;
                            }
                        }
                        this.tcnt++;
                    } else if (this.wasay)
                        this.wasay = false;
                    if (this.auscnt < 45) {
                        if (this.exitm == 0) {
                            if (this.aflk) {
                                drawcs(85, this.asay, 98, 176, 255, 0);
                                this.aflk = false;
                            } else {
                                drawcs(85, this.asay, 0, 128, 255, 0);
                                this.aflk = true;
                            }
                        }
                        this.auscnt++;
                    }
                } else if (this.exitm == 0) {
                    if (this.tflk) {
                        drawcs(110, "Bad Landing!", 0, 0, 200, 0);
                        this.tflk = false;
                    } else {
                        drawcs(110, "Bad Landing!", 255, 100, 0, 0);
                        this.tflk = true;
                    }
                }
                if ((mad).trcnt == 10) {
                    this.loop = "";
                    this.spin = "";
                    this.asay = "";
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
                        this.loop = "Forward loop";
                    if (i == 2)
                        this.loop = "double Forward";
                    if (i == 3)
                        this.loop = "triple Forward";
                    if (i >= 4)
                        this.loop = "massive Forward looping";
                    if (i == -1)
                        this.loop = "Backloop";
                    if (i == -2)
                        this.loop = "double Back";
                    if (i == -3)
                        this.loop = "triple Back";
                    if (i <= -4)
                        this.loop = "massive Back looping";
                    if (i == 0) {
                        if ((mad).ftab && (mad).btab)
                            this.loop = "Tabletop and reversed Tabletop";
                        else if ((mad).ftab || (mad).btab)
                            this.loop = "Tabletop";
                    }
                    if (i > 0 && (mad).btab)
                        this.loop = new StringBuilder().append("Hanged ").append(this.loop).toString();
                    if (i < 0 && (mad).ftab)
                        this.loop = new StringBuilder().append("Hanged ").append(this.loop).toString();
                    if (this.loop != "") {
                        StringBuilder stringbuilder = new StringBuilder();
                        xtGraphics var_xtGraphics_163_ = this;
                        (var_xtGraphics_163_).asay = stringbuilder.append((var_xtGraphics_163_).asay).append(" ").append(this.loop).toString();
                    }
                    i = 0;
                    (mad).travxy = Math.abs((mad).travxy);
                    while ((mad).travxy > 270) {
                        (mad).travxy -= 360;
                        i++;
                    }
                    if (i == 0 && (mad).rtab) {
                        if (this.loop == "")
                            this.spin = "Tabletop";
                        else
                            this.spin = "Flipside";
                    }
                    if (i == 1)
                        this.spin = "Rollspin";
                    if (i == 2)
                        this.spin = "double Rollspin";
                    if (i == 3)
                        this.spin = "triple Rollspin";
                    if (i >= 4)
                        this.spin = "massive Roll spinning";
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
                        if (this.loop == "" && this.spin == "") {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics_165_ = this;
                            (var_xtGraphics_165_).asay = stringbuilder.append((var_xtGraphics_165_).asay).append(" ").append(i).toString();
                            if (bool_164_) {
                                StringBuilder stringbuilder_166_ = new StringBuilder();
                                xtGraphics var_xtGraphics_167_ = this;
                                (var_xtGraphics_167_).asay = stringbuilder_166_.append((var_xtGraphics_167_).asay).append(" and beyond").toString();
                            }
                        } else {
                            if (this.spin != "") {
                                if (this.loop == "") {
                                    StringBuilder stringbuilder = new StringBuilder();
                                    xtGraphics var_xtGraphics_168_ = this;
                                    (var_xtGraphics_168_).asay = stringbuilder.append((var_xtGraphics_168_).asay).append(" ").append(this.spin).toString();
                                } else {
                                    StringBuilder stringbuilder = new StringBuilder();
                                    xtGraphics var_xtGraphics_169_ = this;
                                    (var_xtGraphics_169_).asay = stringbuilder.append((var_xtGraphics_169_).asay).append(" with ").append(this.spin).toString();
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
                    } else if (this.spin != "") {
                        if (this.loop == "") {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics_173_ = this;
                            (var_xtGraphics_173_).asay = stringbuilder.append((var_xtGraphics_173_).asay).append(" ").append(this.spin).toString();
                        } else {
                            StringBuilder stringbuilder = new StringBuilder();
                            xtGraphics var_xtGraphics_174_ = this;
                            (var_xtGraphics_174_).asay = stringbuilder.append((var_xtGraphics_174_).asay).append(" by ").append(this.spin).toString();
                        }
                    }
                    if (this.asay != "")
                        this.auscnt -= 15;
                    if (this.loop != "")
                        this.auscnt -= 25;
                    if (this.spin != "")
                        this.auscnt -= 25;
                    if (i != 0)
                        this.auscnt -= 25;
                    if (this.auscnt < 45) {
                        if (!this.mutes)
                            this.powerup.play();
                        if (this.auscnt < -20)
                            this.auscnt = -20;
                        int i_175_ = 0;
                        if ((mad).powerup > 20.0F)
                            i_175_ = 1;
                        if ((mad).powerup > 40.0F)
                            i_175_ = 2;
                        if ((mad).powerup > 150.0F)
                            i_175_ = 3;
                        if ((mad).surfer)
                            this.asay = new StringBuilder().append(" ").append(this.adj[4][(int) (this.m.random() * 3.0F)]).append(this.asay).toString();
                        if (i_175_ != 3)
                            this.asay = new StringBuilder().append(this.adj[i_175_][(int) (this.m.random() * 3.0F)]).append(this.asay).append(this.exlm[i_175_]).toString();
                        else
                            this.asay = this.adj[i_175_][(int) (this.m.random() * 3.0F)];
                        if (!this.wasay) {
                            this.tcnt = this.auscnt;
                            if ((mad).power != 98.0F)
                                this.say = new StringBuilder().append("Power Up ").append((int) (100.0F * (mad).powerup / 98.0F)).append("%").toString();
                            else
                                this.say = "Power To The MAX";
                            if (this.skidup)
                                this.skidup = false;
                            else
                                this.skidup = true;
                        }
                    }
                }
                if ((mad).newcar) {
                    if (!this.wasay) {
                        this.say = "Car Fixed";
                        this.tcnt = 0;
                    }
                    if (this.crashup)
                        this.crashup = false;
                    else
                        this.crashup = true;
                }
                for (int i = 0; i < this.nplayers; i++) {
                    if (this.dested[i] != (checkpoints).dested[i] && i != this.im) {
                        this.dested[i] = (checkpoints).dested[i];
                        if (this.fase != 7001) {
                            if (this.dested[i] == 1) {
                                this.wasay = true;
                                this.say = new StringBuilder().append("").append((this.cd).names[this.sc[i]]).append(" has been wasted!").toString();
                                this.tcnt = -15;
                            }
                            if (this.dested[i] == 2) {
                                this.wasay = true;
                                this.say = new StringBuilder().append("You wasted ").append((this.cd).names[this.sc[i]]).append("!").toString();
                                this.tcnt = -15;
                            }
                        } else {
                            if (this.dested[i] == 1) {
                                this.wasay = true;
                                this.say = new StringBuilder().append("").append(this.plnames[i]).append(" has been wasted!").toString();
                                this.tcnt = -15;
                            }
                            if (this.dested[i] == 2) {
                                this.wasay = true;
                                if (this.multion < 2)
                                    this.say = new StringBuilder().append("You wasted ").append(this.plnames[i]).append("!").toString();
                                else
                                    this.say = new StringBuilder().append("").append(this.plnames[this.im]).append(" wasted ").append(this.plnames[i]).append("!").toString();
                                this.tcnt = -15;
                            }
                            if (this.dested[i] == 3) {
                                this.wasay = true;
                                this.say = new StringBuilder().append("").append(this.plnames[i]).append(" has been wasted! (Disconnected)").toString();
                                this.tcnt = -15;
                            }
                        }
                    }
                }
                if (this.multion >= 2 && this.alocked != this.lalocked) {
                    if (this.alocked != -1) {
                        this.wasay = false;
                        this.say = new StringBuilder().append("Now following ").append(this.plnames[this.alocked]).append("!").toString();
                        this.tcnt = -15;
                    }
                    this.lalocked = this.alocked;
                    this.clear = (mad).clear;
                }
                if (this.clear != (mad).clear && (mad).clear != 0) {
                    if (!this.wasay) {
                        this.say = "Checkpoint!";
                        this.tcnt = 15;
                    }
                    this.clear = (mad).clear;
                    if (!this.mutes)
                        this.checkpoint.play();
                    this.cntovn = 0;
                    if (this.cntan != 0)
                        this.cntan = 0;
                }
            }
        }
        if ((this.m).lightn != -1) {
            int i = ((this.strack).sClip).stream.available();
            (this.m).lton = false;
            if (i <= 6380001 && i > 5368001)
                (this.m).lton = true;
            if (i <= 2992001 && i > 1320001)
                (this.m).lton = true;
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
            if (this.dmcnt < 10) {
                if (this.dmflk) {
                    i_180_ = 170;
                    this.dmflk = false;
                } else
                    this.dmflk = true;
            }
            this.dmcnt++;
            if ((double) this.dmcnt > 167.0 - (double) i_178_ * 1.5)
                this.dmcnt = 0;
        }
        i_179_ += (float) i_179_ * ((float) (this.m).snap[0] / 100.0F);
        if (i_179_ > 255)
            i_179_ = 255;
        if (i_179_ < 0)
            i_179_ = 0;
        i_180_ += (float) i_180_ * ((float) (this.m).snap[1] / 100.0F);
        if (i_180_ > 255)
            i_180_ = 255;
        if (i_180_ < 0)
            i_180_ = 0;
        i_181_ += (float) i_181_ * ((float) (this.m).snap[2] / 100.0F);
        if (i_181_ > 255)
            i_181_ = 255;
        if (i_181_ < 0)
            i_181_ = 0;
        this.rd.setColor(new Color(i_179_, i_180_, i_181_));
        this.rd.fillPolygon(is, is_177_, 4);
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
        if (this.auscnt < 45 && this.aflk) {
            i_179_ = 128;
            i_180_ = 244;
            i_181_ = 244;
        }
        i_179_ += (float) i_179_ * ((float) (this.m).snap[0] / 100.0F);
        if (i_179_ > 255)
            i_179_ = 255;
        if (i_179_ < 0)
            i_179_ = 0;
        i_180_ += (float) i_180_ * ((float) (this.m).snap[1] / 100.0F);
        if (i_180_ > 255)
            i_180_ = 255;
        if (i_180_ < 0)
            i_180_ = 0;
        i_181_ += (float) i_181_ * ((float) (this.m).snap[2] / 100.0F);
        if (i_181_ > 255)
            i_181_ = 255;
        if (i_181_ < 0)
            i_181_ = 0;
        this.rd.setColor(new Color(i_179_, i_180_, i_181_));
        this.rd.fillPolygon(is, is_177_, 4);
    }
    
    public void drawhi(Image image, int i) {
        if ((this.m).darksky) {
            Color color = new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]);
            float[] fs = new float[3];
            Color.RGBtoHSB((this.m).csky[0], (this.m).csky[1], (this.m).csky[2], fs);
            fs[2] = 0.6F;
            color = Color.getHSBColor(fs[0], fs[1], fs[2]);
            this.rd.setColor(color);
            this.rd.fillRoundRect(390 - image.getWidth(this.ob) / 2, i - 2, image.getWidth(this.ob) + 20, image.getHeight(this.ob) + 2, 7, 20);
            this.rd.setColor(new Color((int) ((double) color.getRed() / 1.1), (int) ((double) color.getGreen() / 1.1), (int) ((double) color.getBlue() / 1.1)));
            this.rd.drawRoundRect(390 - image.getWidth(this.ob) / 2, i - 2, image.getWidth(this.ob) + 20, image.getHeight(this.ob) + 2, 7, 20);
        }
        this.rd.drawImage(image, 400 - image.getWidth(this.ob) / 2, i, null);
    }
    
    public void drawcs(int i, String string, int i_182_, int i_183_, int i_184_, int i_185_) {
        if (i_185_ != 3 && i_185_ != 4) {
            i_182_ += (float) i_182_ * ((float) (this.m).snap[0] / 100.0F);
            if (i_182_ > 255)
                i_182_ = 255;
            if (i_182_ < 0)
                i_182_ = 0;
            i_183_ += (float) i_183_ * ((float) (this.m).snap[1] / 100.0F);
            if (i_183_ > 255)
                i_183_ = 255;
            if (i_183_ < 0)
                i_183_ = 0;
            i_184_ += (float) i_184_ * ((float) (this.m).snap[2] / 100.0F);
            if (i_184_ > 255)
                i_184_ = 255;
            if (i_184_ < 0)
                i_184_ = 0;
        }
        if (i_185_ == 4) {
            i_182_ -= (float) i_182_ * ((float) (this.m).snap[0] / 100.0F);
            if (i_182_ > 255)
                i_182_ = 255;
            if (i_182_ < 0)
                i_182_ = 0;
            i_183_ -= (float) i_183_ * ((float) (this.m).snap[1] / 100.0F);
            if (i_183_ > 255)
                i_183_ = 255;
            if (i_183_ < 0)
                i_183_ = 0;
            i_184_ -= (float) i_184_ * ((float) (this.m).snap[2] / 100.0F);
            if (i_184_ > 255)
                i_184_ = 255;
            if (i_184_ < 0)
                i_184_ = 0;
        }
        if (i_185_ == 1) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, 400 - this.ftm.stringWidth(string) / 2 + 1, i + 1);
        }
        if (i_185_ == 2) {
            i_182_ = (i_182_ * 2 + (this.m).csky[0] * 1) / 3;
            if (i_182_ > 255)
                i_182_ = 255;
            if (i_182_ < 0)
                i_182_ = 0;
            i_183_ = (i_183_ * 2 + (this.m).csky[1] * 1) / 3;
            if (i_183_ > 255)
                i_183_ = 255;
            if (i_183_ < 0)
                i_183_ = 0;
            i_184_ = (i_184_ * 2 + (this.m).csky[2] * 1) / 3;
            if (i_184_ > 255)
                i_184_ = 255;
            if (i_184_ < 0)
                i_184_ = 0;
        }
        this.rd.setColor(new Color(i_182_, i_183_, i_184_));
        this.rd.drawString(string, 400 - this.ftm.stringWidth(string) / 2, i);
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
        boolean bool_193_ = false;
        int i_194_;
        if (!bool) {
            int i_195_ = 0;
            if ((checkpoints).x[i] - (checkpoints).opx[this.im] >= 0)
                i_195_ = 180;
            i_194_ = (int) ((double) (90 + i_195_) + Math.atan((double) ((checkpoints).z[i] - (checkpoints).opz[this.im]) / (double) ((checkpoints).x[i] - (checkpoints).opx[this.im])) / 0.017453292519943295);
        } else {
            int i_196_ = 0;
            if (this.multion == 0 || this.alocked == -1) {
                int i_197_ = -1;
                boolean bool_198_ = false;
                for (int i_199_ = 0; i_199_ < this.nplayers; i_199_++) {
                    if (i_199_ != this.im && (py((checkpoints).opx[this.im] / 100, (checkpoints).opx[i_199_] / 100, (checkpoints).opz[this.im] / 100, (checkpoints).opz[i_199_] / 100) < i_197_ || i_197_ == -1) && (!bool_198_ || (checkpoints).onscreen[i_199_] != 0) && (checkpoints).dested[i_199_] == 0) {
                        i_196_ = i_199_;
                        i_197_ = py((checkpoints).opx[this.im] / 100, (checkpoints).opx[i_199_] / 100, (checkpoints).opz[this.im] / 100, (checkpoints).opz[i_199_] / 100);
                        if ((checkpoints).onscreen[i_199_] != 0)
                            bool_198_ = true;
                    }
                }
            } else
                i_196_ = this.alocked;
            int i_200_ = 0;
            if ((checkpoints).opx[i_196_] - (checkpoints).opx[this.im] >= 0)
                i_200_ = 180;
            i_194_ = (int) ((double) (90 + i_200_) + Math.atan((double) ((checkpoints).opz[i_196_] - (checkpoints).opz[this.im]) / (double) ((checkpoints).opx[i_196_] - (checkpoints).opx[this.im])) / 0.017453292519943295);
            if (this.multion == 0) {
                drawcs(13, "[                                ]", 76, 67, 240, 0);
                drawcs(13, (this.cd).names[this.sc[i_196_]], 0, 0, 0, 0);
            } else {
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                drawcs(17, "[                                ]", 76, 67, 240, 0);
                drawcs(12, this.plnames[i_196_], 0, 0, 0, 0);
                this.rd.setFont(new Font("Arial", 0, 10));
                this.ftm = this.rd.getFontMetrics();
                drawcs(24, (this.cd).names[this.sc[i_196_]], 0, 0, 0, 0);
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
        }
        for (i_194_ += (this.m).xz; i_194_ < 0; i_194_ += 360) {
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
        if (Math.abs(this.ana - i_194_) < 180) {
            if (Math.abs(this.ana - i_194_) < 10)
                this.ana = i_194_;
            else if (this.ana < i_194_)
                this.ana += 10;
            else
                this.ana -= 10;
        } else {
            if (i_194_ < 0) {
                this.ana += 15;
                if (this.ana > 180)
                    this.ana -= 360;
            }
            if (i_194_ > 0) {
                this.ana -= 15;
                if (this.ana < -180)
                    this.ana += 360;
            }
        }
        rot(is, is_188_, i_189_, i_191_, this.ana, 7);
        i_194_ = Math.abs(this.ana);
        if (!bool) {
            if (i_194_ > 7 || i_186_ > 0 || i_186_ == -2 || this.cntan != 0) {
                for (int i_201_ = 0; i_201_ < 7; i_201_++) {
                    is[i_201_] = xs(is[i_201_], is_188_[i_201_]);
                    is_187_[i_201_] = ys(is_187_[i_201_], is_188_[i_201_]);
                }
                int i_202_ = (int) (190.0F + 190.0F * ((float) (this.m).snap[0] / 100.0F));
                if (i_202_ > 255)
                    i_202_ = 255;
                if (i_202_ < 0)
                    i_202_ = 0;
                int i_203_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[1] / 100.0F));
                if (i_203_ > 255)
                    i_203_ = 255;
                if (i_203_ < 0)
                    i_203_ = 0;
                int i_204_ = 0;
                if (i_186_ <= 0) {
                    if (i_194_ <= 45 && i_186_ != -2 && this.cntan == 0) {
                        i_202_ = (i_202_ * i_194_ + (this.m).csky[0] * (45 - i_194_)) / 45;
                        i_203_ = (i_203_ * i_194_ + (this.m).csky[1] * (45 - i_194_)) / 45;
                        i_204_ = (i_204_ * i_194_ + (this.m).csky[2] * (45 - i_194_)) / 45;
                    }
                    if (i_194_ >= 90) {
                        int i_205_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[0] / 100.0F));
                        if (i_205_ > 255)
                            i_205_ = 255;
                        if (i_205_ < 0)
                            i_205_ = 0;
                        i_202_ = (i_202_ * (140 - i_194_) + i_205_ * (i_194_ - 90)) / 50;
                        if (i_202_ > 255)
                            i_202_ = 255;
                    }
                } else if (this.flk) {
                    i_202_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[0] / 100.0F));
                    if (i_202_ > 255)
                        i_202_ = 255;
                    if (i_202_ < 0)
                        i_202_ = 0;
                    this.flk = false;
                } else {
                    i_202_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[0] / 100.0F));
                    if (i_202_ > 255)
                        i_202_ = 255;
                    if (i_202_ < 0)
                        i_202_ = 0;
                    i_203_ = (int) (220.0F + 220.0F * ((float) (this.m).snap[1] / 100.0F));
                    if (i_203_ > 255)
                        i_203_ = 255;
                    if (i_203_ < 0)
                        i_203_ = 0;
                    this.flk = true;
                }
                this.rd.setColor(new Color(i_202_, i_203_, i_204_));
                this.rd.fillPolygon(is, is_187_, 7);
                i_202_ = (int) (115.0F + 115.0F * ((float) (this.m).snap[0] / 100.0F));
                if (i_202_ > 255)
                    i_202_ = 255;
                if (i_202_ < 0)
                    i_202_ = 0;
                i_203_ = (int) (170.0F + 170.0F * ((float) (this.m).snap[1] / 100.0F));
                if (i_203_ > 255)
                    i_203_ = 255;
                if (i_203_ < 0)
                    i_203_ = 0;
                i_204_ = 0;
                if (i_186_ <= 0) {
                    if (i_194_ <= 45 && i_186_ != -2 && this.cntan == 0) {
                        i_202_ = (i_202_ * i_194_ + (this.m).csky[0] * (45 - i_194_)) / 45;
                        i_203_ = (i_203_ * i_194_ + (this.m).csky[1] * (45 - i_194_)) / 45;
                        i_204_ = (i_204_ * i_194_ + (this.m).csky[2] * (45 - i_194_)) / 45;
                    }
                } else if (this.flk) {
                    i_202_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[0] / 100.0F));
                    if (i_202_ > 255)
                        i_202_ = 255;
                    if (i_202_ < 0)
                        i_202_ = 0;
                    i_203_ = 0;
                }
                this.rd.setColor(new Color(i_202_, i_203_, i_204_));
                this.rd.drawPolygon(is, is_187_, 7);
            }
        } else {
            int i_206_ = 0;
            if (this.multion != 0)
                i_206_ = 8;
            for (int i_207_ = 0; i_207_ < 7; i_207_++) {
                is[i_207_] = xs(is[i_207_], is_188_[i_207_]);
                is_187_[i_207_] = ys(is_187_[i_207_], is_188_[i_207_]) + i_206_;
            }
            int i_208_ = (int) (159.0F + 159.0F * ((float) (this.m).snap[0] / 100.0F));
            if (i_208_ > 255)
                i_208_ = 255;
            if (i_208_ < 0)
                i_208_ = 0;
            int i_209_ = (int) (207.0F + 207.0F * ((float) (this.m).snap[1] / 100.0F));
            if (i_209_ > 255)
                i_209_ = 255;
            if (i_209_ < 0)
                i_209_ = 0;
            int i_210_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 100.0F));
            if (i_210_ > 255)
                i_210_ = 255;
            if (i_210_ < 0)
                i_210_ = 0;
            this.rd.setColor(new Color(i_208_, i_209_, i_210_));
            this.rd.fillPolygon(is, is_187_, 7);
            i_208_ = (int) (120.0F + 120.0F * ((float) (this.m).snap[0] / 100.0F));
            if (i_208_ > 255)
                i_208_ = 255;
            if (i_208_ < 0)
                i_208_ = 0;
            i_209_ = (int) (114.0F + 114.0F * ((float) (this.m).snap[1] / 100.0F));
            if (i_209_ > 255)
                i_209_ = 255;
            if (i_209_ < 0)
                i_209_ = 0;
            i_210_ = (int) (255.0F + 255.0F * ((float) (this.m).snap[2] / 100.0F));
            if (i_210_ > 255)
                i_210_ = 255;
            if (i_210_ < 0)
                i_210_ = 0;
            this.rd.setColor(new Color(i_208_, i_209_, i_210_));
            this.rd.drawPolygon(is, is_187_, 7);
        }
    }
    
    public void playsounds(Mad mad, Control control, int i) {
        if ((this.fase == 0 || this.fase == 7001) && this.starcnt < 35 && this.cntwis != 8 && !this.mutes) {
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
                            if (Math.abs((mad).speed) > 0.0F && Math.abs((mad).speed) <= (float) (this.cd).swits[(mad).cn][0]) {
                                int i_213_ = (int) (3.0F * Math.abs((mad).speed) / (float) (this.cd).swits[(mad).cn][0]);
                                if (i_213_ == 2) {
                                    if (this.pwait == 0)
                                        i_213_ = 0;
                                    else
                                        this.pwait--;
                                } else
                                    this.pwait = 7;
                                sparkeng(i_213_, (mad).cn);
                            }
                            if (Math.abs((mad).speed) > (float) (this.cd).swits[(mad).cn][0] && Math.abs((mad).speed) <= (float) (this.cd).swits[(mad).cn][1]) {
                                int i_214_ = (int) (3.0F * (Math.abs((mad).speed) - (float) (this.cd).swits[(mad).cn][0]) / (float) ((this.cd).swits[(mad).cn][1] - (this.cd).swits[(mad).cn][0]));
                                if (i_214_ == 2) {
                                    if (this.pwait == 0)
                                        i_214_ = 0;
                                    else
                                        this.pwait--;
                                } else
                                    this.pwait = 7;
                                sparkeng(i_214_, (mad).cn);
                            }
                            if (Math.abs((mad).speed) > (float) (this.cd).swits[(mad).cn][1] && Math.abs((mad).speed) <= (float) (this.cd).swits[(mad).cn][2]) {
                                int i_215_ = (int) (3.0F * (Math.abs((mad).speed) - (float) (this.cd).swits[(mad).cn][1]) / (float) ((this.cd).swits[(mad).cn][2] - (this.cd).swits[(mad).cn][1]));
                                sparkeng(i_215_, (mad).cn);
                            }
                        } else {
                            int i_216_ = 2;
                            if (this.pwait == 0) {
                                if (Math.abs((mad).speed) > (float) (this.cd).swits[(mad).cn][1])
                                    i_216_ = 3;
                            } else
                                this.pwait--;
                            sparkeng(i_216_, (mad).cn);
                        }
                    } else {
                        sparkeng(-1, (mad).cn);
                        if (bool_212_) {
                            if (this.stopcnt <= 0) {
                                this.air[5].loop();
                                this.stopcnt = 10;
                            }
                        } else if (this.stopcnt <= -2) {
                            this.air[2 + (int) (this.m.random() * 3.0F)].loop();
                            this.stopcnt = 7;
                        }
                    }
                } else
                    sparkeng(3, (mad).cn);
                this.grrd = false;
                this.aird = false;
            } else {
                this.pwait = 15;
                if (!(mad).mtouch && !this.grrd && (double) this.m.random() > 0.4) {
                    this.air[(int) (this.m.random() * 4.0F)].loop();
                    this.stopcnt = 5;
                    this.grrd = true;
                }
                if (!(mad).wtouch && !this.aird) {
                    stopairs();
                    this.air[(int) (this.m.random() * 4.0F)].loop();
                    this.stopcnt = 10;
                    this.aird = true;
                }
                sparkeng(-1, (mad).cn);
            }
            if ((mad).cntdest != 0 && this.cntwis < 7) {
                if (!this.pwastd) {
                    this.wastd.loop();
                    this.pwastd = true;
                }
            } else {
                if (this.pwastd) {
                    this.wastd.stop();
                    this.pwastd = false;
                }
                if (this.cntwis == 7 && !this.mutes)
                    this.firewasted.play();
            }
        } else {
            sparkeng(-2, (mad).cn);
            if (this.pwastd) {
                this.wastd.stop();
                this.pwastd = false;
            }
        }
        if (this.stopcnt != -20) {
            if (this.stopcnt == 1)
                stopairs();
            this.stopcnt--;
        }
        if (this.bfcrash != 0)
            this.bfcrash--;
        if (this.bfscrape != 0)
            this.bfscrape--;
        if (this.bfsc1 != 0)
            this.bfsc1--;
        if (this.bfsc2 != 0)
            this.bfsc2--;
        if (this.bfskid != 0)
            this.bfskid--;
        if ((mad).newcar)
            this.cntwis = 0;
        if (this.fase == 0 || this.fase == 7001 || this.fase == 6 || this.fase == -1 || this.fase == -2 || this.fase == -3 || this.fase == -4 || this.fase == -5) {
            if (this.mutes != (control).mutes)
                this.mutes = (control).mutes;
            if ((control).mutem != this.mutem) {
                this.mutem = (control).mutem;
                if (this.mutem) {
                    if (this.loadedt)
                        this.strack.stop();
                } else if (this.loadedt)
                    this.strack.resume();
            }
        }
        if ((mad).cntdest != 0 && this.cntwis < 7) {
            if ((mad).dest)
                this.cntwis++;
        } else {
            if ((mad).cntdest == 0)
                this.cntwis = 0;
            if (this.cntwis == 7)
                this.cntwis = 8;
        }
        if (this.macn)
            closesounds();
    }
    
    public void stopairs() {
        for (int i = 0; i < 6; i++)
            this.air[i].stop();
    }
    
    public void sparkeng(int i, int i_217_) {
        if (this.lcn != i_217_) {
            for (int i_218_ = 0; i_218_ < 5; i_218_++) {
                if (this.pengs[i_218_]) {
                    this.engs[(this.cd).enginsignature[this.lcn]][i_218_].stop();
                    this.pengs[i_218_] = false;
                }
            }
            this.lcn = i_217_;
        }
        i++;
        for (int i_219_ = 0; i_219_ < 5; i_219_++) {
            if (i == i_219_) {
                if (!this.pengs[i_219_]) {
                    this.engs[(this.cd).enginsignature[i_217_]][i_219_].loop();
                    this.pengs[i_219_] = true;
                }
            } else if (this.pengs[i_219_]) {
                this.engs[(this.cd).enginsignature[i_217_]][i_219_].stop();
                this.pengs[i_219_] = false;
            }
        }
    }
    
    public void crash(float f, int i) {
        if (this.bfcrash == 0) {
            if (i == 0) {
                if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F) {
                    if (!this.mutes)
                        this.lowcrash[this.crshturn].play();
                    this.bfcrash = 2;
                }
                if (Math.abs(f) >= 170.0F) {
                    if (!this.mutes)
                        this.crash[this.crshturn].play();
                    this.bfcrash = 2;
                }
                if (Math.abs(f) > 25.0F) {
                    if (this.crashup)
                        this.crshturn--;
                    else
                        this.crshturn++;
                    if (this.crshturn == -1)
                        this.crshturn = 2;
                    if (this.crshturn == 3)
                        this.crshturn = 0;
                }
            }
            if (i == -1) {
                if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F) {
                    if (!this.mutes)
                        this.lowcrash[2].play();
                    this.bfcrash = 2;
                }
                if (Math.abs(f) > 170.0F) {
                    if (!this.mutes)
                        this.crash[2].play();
                    this.bfcrash = 2;
                }
            }
            if (i == 1) {
                if (!this.mutes)
                    this.tires.play();
                this.bfcrash = 3;
            }
        }
    }
    
    public void skid(int i, float f) {
        if (this.bfcrash == 0 && this.bfskid == 0 && f > 150.0F) {
            if (i == 0) {
                if (!this.mutes)
                    this.skid[this.skflg].play();
                if (this.skidup)
                    this.skflg++;
                else
                    this.skflg--;
                if (this.skflg == 3)
                    this.skflg = 0;
                if (this.skflg == -1)
                    this.skflg = 2;
            } else {
                if (!this.mutes)
                    this.dustskid[this.dskflg].play();
                if (this.skidup)
                    this.dskflg++;
                else
                    this.dskflg--;
                if (this.dskflg == 3)
                    this.dskflg = 0;
                if (this.dskflg == -1)
                    this.dskflg = 2;
            }
            this.bfskid = 35;
        }
    }
    
    public void scrape(int i, int i_220_, int i_221_) {
        if (this.bfscrape == 0 && Math.sqrt((double) (i * i + i_220_ * i_220_ + i_221_ * i_221_)) / 10.0 > 10.0) {
            int i_222_ = 0;
            if (this.m.random() > this.m.random())
                i_222_ = 1;
            if (i_222_ == 0) {
                this.sturn1 = 0;
                this.sturn0++;
                if (this.sturn0 == 3) {
                    i_222_ = 1;
                    this.sturn1 = 1;
                    this.sturn0 = 0;
                }
            } else {
                this.sturn0 = 0;
                this.sturn1++;
                if (this.sturn1 == 3) {
                    i_222_ = 0;
                    this.sturn0 = 1;
                    this.sturn1 = 0;
                }
            }
            if (!this.mutes)
                this.scrape[i_222_].play();
            this.bfscrape = 5;
        }
    }
    
    public void gscrape(int i, int i_223_, int i_224_) {
        if ((this.bfsc1 == 0 || this.bfsc2 == 0) && Math.sqrt((double) (i * i + i_223_ * i_223_ + i_224_ * i_224_)) / 10.0 > 15.0) {
            if (this.bfsc1 == 0) {
                if (!this.mutes) {
                    this.scrape[2].stop();
                    this.scrape[2].play();
                }
                this.bfsc1 = 12;
                this.bfsc2 = 6;
            } else {
                if (!this.mutes) {
                    this.scrape[3].stop();
                    this.scrape[3].play();
                }
                this.bfsc2 = 12;
                this.bfsc1 = 6;
            }
        }
    }
    
    public void closesounds() {
        for (int i = 0; i < 5; i++) {
            for (int i_225_ = 0; i_225_ < 5; i_225_++)
                this.engs[i][i_225_].checkopen();
        }
        for (int i = 0; i < 6; i++)
            this.air[i].checkopen();
        this.tires.checkopen();
        this.checkpoint.checkopen();
        this.carfixed.checkopen();
        this.powerup.checkopen();
        this.three.checkopen();
        this.two.checkopen();
        this.one.checkopen();
        this.go.checkopen();
        this.wastd.checkopen();
        this.firewasted.checkopen();
        for (int i = 0; i < 3; i++) {
            this.skid[i].checkopen();
            this.dustskid[i].checkopen();
            this.crash[i].checkopen();
            this.lowcrash[i].checkopen();
            this.scrape[i].checkopen();
        }
    }
    
    public void rot(int[] is, int[] is_226_, int i, int i_227_, int i_228_, int i_229_) {
        if (i_228_ != 0) {
            for (int i_230_ = 0; i_230_ < i_229_; i_230_++) {
                int i_231_ = is[i_230_];
                int i_232_ = is_226_[i_230_];
                is[i_230_] = i + (int) ((float) (i_231_ - i) * this.m.cos(i_228_) - (float) (i_232_ - i_227_) * this.m.sin(i_228_));
                is_226_[i_230_] = i_227_ + (int) ((float) (i_231_ - i) * this.m.sin(i_228_) + (float) (i_232_ - i_227_) * this.m.cos(i_228_));
            }
        }
    }
    
    public int xs(int i, int i_233_) {
        if (i_233_ < 50)
            i_233_ = 50;
        return (i_233_ - (this.m).focus_point) * ((this.m).cx - i) / i_233_ + i;
    }
    
    public int ys(int i, int i_234_) {
        if (i_234_ < 50)
            i_234_ = 50;
        return (i_234_ - (this.m).focus_point) * ((this.m).cy - i) / i_234_ + i;
    }
    
    public int py(int i, int i_235_, int i_236_, int i_237_) {
        return (i - i_235_) * (i - i_235_) + (i_236_ - i_237_) * (i_236_ - i_237_);
    }
    
    public float pys(int i, int i_238_, int i_239_, int i_240_) {
        return (float) Math.sqrt((double) ((i - i_238_) * (i - i_238_) + (i_239_ - i_240_) * (i_239_ - i_240_)));
    }
    
    public void snap(int i) {
        this.dmg = loadsnap(this.odmg);
        this.pwr = loadsnap(this.opwr);
        this.was = loadsnap(this.owas);
        this.lap = loadsnap(this.olap);
        this.pos = loadsnap(this.opos);
        for (int i_241_ = 0; i_241_ < 7; i_241_++)
            this.rank[i_241_] = loadsnap(this.orank[i_241_]);
        for (int i_242_ = 0; i_242_ < 4; i_242_++)
            this.cntdn[i_242_] = loadsnap(this.ocntdn[i_242_]);
        if (this.multion != 0) {
            this.wgame = loadsnap(this.owgame);
            this.exitgame = loadsnap(this.oexitgame);
            this.gamefinished = loadsnap(this.ogamefinished);
            this.disco = loadsnap(this.odisco);
        }
        this.yourwasted = loadsnap(this.oyourwasted);
        this.youlost = loadsnap(this.oyoulost);
        this.youwon = loadsnap(this.oyouwon);
        this.youwastedem = loadsnap(this.oyouwastedem);
        this.gameh = loadsnap(this.ogameh);
        this.loadingmusic = loadopsnap(this.oloadingmusic, i, 76);
        this.star[0] = loadopsnap(this.ostar[0], i, 0);
        this.star[1] = loadopsnap(this.ostar[1], i, 0);
        this.flaot = loadopsnap(this.oflaot, i, 1);
    }
    
    public boolean overon(int i, int i_243_, int i_244_, int i_245_, int i_246_, int i_247_) {
        return i_246_ > i && i_246_ < i + i_244_ && i_247_ > i_243_ && i_247_ < i_243_ + i_245_;
    }
    
    public boolean over(Image image, int i, int i_248_, int i_249_, int i_250_) {
        int i_251_ = image.getHeight(this.ob);
        int i_252_ = image.getWidth(this.ob);
        return i > i_249_ - 5 && i < i_249_ + i_252_ + 5 && i_248_ > i_250_ - 5 && i_248_ < i_250_ + i_251_ + 5;
    }
    
    public void fleximage(Image image, int i, int i_253_) {
        if (!this.badmac) {
            if (i == 0) {
                this.flexpix = new int[360000];
                PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, this.flexpix, 0, 800);
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
                Color color = new Color(this.flexpix[i_260_]);
                boolean bool = false;
                boolean bool_261_ = false;
                boolean bool_262_ = false;
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
                this.flexpix[i_260_] = color_269_.getRGB();
            }
            this.fleximg = createImage(new MemoryImageSource(800, 450, this.flexpix, 0, 800));
            this.rd.drawImage(this.fleximg, 0, 0, null);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 800, 450);
        }
    }
    
    private Image loadsnap(Image image) {
        int i = image.getHeight(this.ob);
        int i_270_ = image.getWidth(this.ob);
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
                int i_273_ = (int) ((float) color_272_.getRed() + (float) color_272_.getRed() * ((float) (this.m).snap[0] / 100.0F));
                if (i_273_ > 255)
                    i_273_ = 255;
                if (i_273_ < 0)
                    i_273_ = 0;
                int i_274_ = (int) ((float) color_272_.getGreen() + (float) color_272_.getGreen() * ((float) (this.m).snap[1] / 100.0F));
                if (i_274_ > 255)
                    i_274_ = 255;
                if (i_274_ < 0)
                    i_274_ = 0;
                int i_275_ = (int) ((float) color_272_.getBlue() + (float) color_272_.getBlue() * ((float) (this.m).snap[2] / 100.0F));
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
        int i_278_ = image.getHeight(this.ob);
        int i_279_ = image.getWidth(this.ob);
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
        int[] is_281_ = { (this.m).snap[0], (this.m).snap[1], (this.m).snap[2] };
        while (is_281_[0] + is_281_[1] + is_281_[2] < -30) {
            for (int i_282_ = 0; i_282_ < 3; i_282_++) {
                if (is_281_[i_282_] < 50)
                    is_281_[i_282_]++;
            }
        }
        for (int i_283_ = 0; i_283_ < i_279_ * i_278_; i_283_++) {
            if (is[i_283_] != is[i_277_]) {
                Color color = new Color(is[i_283_]);
                boolean bool = false;
                boolean bool_284_ = false;
                boolean bool_285_ = false;
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
        int i = image.getHeight(this.ob);
        int i_291_ = image.getWidth(this.ob);
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
        int i = image.getHeight(this.ob);
        int i_294_ = image.getWidth(this.ob);
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
        if (!this.badmac) {
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
                boolean bool = false;
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
            this.fleximg = createImage(new MemoryImageSource(800, 450, is, 0, 800));
            this.rd.drawImage(this.fleximg, 0, 0, null);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 800, 450);
        }
    }
    
    public void jflexo() {
        if (!this.badmac) {
            int[] is = new int[268000];
            PixelGrabber pixelgrabber = new PixelGrabber((this.app).offImage, 65, 25, 670, 400, is, 0, 670);
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
                boolean bool = false;
                boolean bool_311_ = false;
                boolean bool_312_ = false;
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
            this.rd.drawImage(image, 65, 25, null);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 670, 400);
        }
    }
    
    public Image getImage(String string) {
        Image image = Toolkit.getDefaultToolkit().createImage(string);
        MediaTracker mediatracker = new MediaTracker(this.app);
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
        int i = image.getHeight(this.ob);
        int i_317_ = image.getWidth(this.ob);
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
        Object object = null;
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
        int i_321_ = image.getHeight(this.ob);
        int i_322_ = image.getWidth(this.ob);
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
        Object object = null;
        Image image_329_;
        if (i == 2) {
            BufferedImage bufferedimage = new BufferedImage(i_322_, i_321_, 2);
            bufferedimage.setRGB(0, 0, i_322_, i_321_, is_323_, 0, i_322_);
            image_329_ = bufferedimage;
        } else
            image_329_ = createImage(new MemoryImageSource(i_322_, i_321_, is_323_, 0, i_322_));
        Object object_330_ = null;
        return image_329_;
    }
    
    private Image dodgen(Image image) {
        int i = image.getHeight(this.ob);
        int i_331_ = image.getWidth(this.ob);
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
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, this.smokey, 0, 466);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        for (int i = 0; i < 94132; i++) {
            if (this.smokey[i] != this.smokey[0]) {
                Color color = new Color(this.smokey[i]);
                float[] fs = new float[3];
                Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
                fs[0] = 0.11F;
                fs[1] = 0.45F;
                Color color_338_ = Color.getHSBColor(fs[0], fs[1], fs[2]);
                this.smokey[i] = color_338_.getRGB();
            }
        }
    }
    
    private void makecarsbgc(Image image, Image image_339_) {
        int[] is = new int[268000];
        PixelGrabber pixelgrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400, is, 0, 670);
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
        this.carsbgc = createImage(new MemoryImageSource(670, 400, is, 0, 670));
    }
    
    public void carsbginflex() {
        this.flatr = 0;
        this.flyr = (int) (this.m.random() * 160.0F - 80.0F);
        this.flyrdest = (int) ((float) this.flyr + this.m.random() * 160.0F - 80.0F);
        this.flang = 1;
        this.flexpix = new int[268000];
        PixelGrabber pixelgrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400, this.flexpix, 0, 670);
        try {
            pixelgrabber.grabPixels();
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
    }
    
    public void drawSmokeCarsbg() {
        if (Math.abs(this.flyr - this.flyrdest) > 20) {
            if (this.flyr > this.flyrdest)
                this.flyr -= 20;
            else
                this.flyr += 20;
        } else {
            this.flyr = this.flyrdest;
            this.flyrdest = (int) ((float) this.flyr + this.m.random() * 160.0F - 80.0F);
        }
        if (this.flyr > 160)
            this.flyr = 160;
        if (this.flatr > 170) {
            this.flatrstart++;
            this.flatr = this.flatrstart * 3;
            this.flyr = (int) (this.m.random() * 160.0F - 80.0F);
            this.flyrdest = (int) ((float) this.flyr + this.m.random() * 160.0F - 80.0F);
            this.flang = 1;
        }
        for (int i = 0; i < 466; i++) {
            for (int i_360_ = 0; i_360_ < 202; i_360_++) {
                if (this.smokey[i + i_360_ * 466] != this.smokey[0]) {
                    float f = pys(i, 233, i_360_, this.flyr);
                    int i_361_ = (int) ((float) (i - 233) / f * (float) this.flatr);
                    int i_362_ = (int) ((float) (i_360_ - this.flyr) / f * (float) this.flatr);
                    int i_363_ = i + i_361_ + 100 + (i_360_ + i_362_ + 110) * 670;
                    if (i + i_361_ + 100 < 670 && i + i_361_ + 100 > 0 && i_360_ + i_362_ + 110 < 400 && i_360_ + i_362_ + 110 > 0 && i_363_ < 268000 && i_363_ >= 0) {
                        Color color = new Color(this.flexpix[i_363_]);
                        Color color_364_ = new Color(this.smokey[i + i_360_ * 466]);
                        float f_365_ = (255.0F - (float) color_364_.getRed()) / 255.0F;
                        float f_366_ = (255.0F - (float) color_364_.getGreen()) / 255.0F;
                        float f_367_ = (255.0F - (float) color_364_.getBlue()) / 255.0F;
                        int i_368_ = (int) (((float) color.getRed() * ((float) this.flang * f_365_) + (float) color_364_.getRed() * (1.0F - f_365_)) / ((float) this.flang * f_365_ + (1.0F - f_365_)));
                        int i_369_ = (int) (((float) color.getGreen() * ((float) this.flang * f_366_) + (float) color_364_.getGreen() * (1.0F - f_366_)) / ((float) this.flang * f_366_ + (1.0F - f_366_)));
                        int i_370_ = (int) (((float) color.getBlue() * ((float) this.flang * f_367_) + (float) color_364_.getBlue() * (1.0F - f_367_)) / ((float) this.flang * f_367_ + (1.0F - f_367_)));
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
                        this.flexpix[i_363_] = color_371_.getRGB();
                    }
                }
            }
        }
        this.flang += 2;
        this.flatr += 10 + this.flatrstart * 2;
        Image image = createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
        this.rd.drawImage(image, 65, 25, null);
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
        boolean bool_387_ = false;
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        int i_388_;
        if (bool) {
            i_388_ = this.ftm.stringWidth(string);
            if (string.startsWith("Class"))
                i_388_ = 112;
        } else
            i_388_ = image.getWidth(this.ob);
        int i_389_ = 0;
        if (i_383_ > i && i_383_ < i + i_388_ + 14 && i_384_ > i_382_ && i_384_ < i_382_ + 28) {
            i_389_ = 1;
            if (bool_385_)
                bool_386_ = true;
        }
        if (this.cfase != 11) {
            if (bool && string.equals(" Top 20 Lists ") && i_389_ == 0)
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.67F));
            if (bool && string.equals(" Top 20 Lists ") && i_389_ == 1)
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.9F));
        }
        this.rd.drawImage(this.bcl[i_389_], i, i_382_, null);
        this.rd.drawImage(this.bc[i_389_], i + 4, i_382_, i_388_ + 6, 28, null);
        this.rd.drawImage(this.bcr[i_389_], i + i_388_ + 10, i_382_, null);
        if (bool) {
            if (string.equals("X") && i_389_ == 1)
                this.rd.setColor(new Color(255, 0, 0));
            else
                this.rd.setColor(new Color(0, 0, 0));
            if (string.startsWith("Class"))
                this.rd.drawString(string, 400 - this.ftm.stringWidth(string) / 2, i_382_ + 19);
            else
                this.rd.drawString(string, i + 7, i_382_ + 19);
        } else
            this.rd.drawImage(image, i + 7, i_382_ + 7, null);
        if (bool && string.equals(" Top 20 Lists "))
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        return bool_386_;
    }
    
    public void drawWarning() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        this.rd.setFont(new Font("Arial", 1, 22));
        this.ftm = this.rd.getFontMetrics();
        drawcs(100, "Warning!", 255, 0, 0, 3);
        this.rd.setFont(new Font("Arial", 1, 18));
        this.ftm = this.rd.getFontMetrics();
        drawcs(150, "Bad language and flooding is strictly prohibited in this game!", 255, 255, 255, 3);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (this.warning < 210)
            drawcs(200, "If you continue typing bad language or flooding your game will shut down.", 200, 200, 200, 3);
        if (this.warning > 210)
            drawcs(200, "Sorry. This was your second warring your game has shut down.", 200, 200, 200, 3);
        if (this.warning > 250) {
            stopallnow();
            this.runtyp = 0;
            this.app.repaint();
            (this.app).gamer.stop();
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
