/* xtGraphics - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
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
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class xtGraphics extends Panel implements Runnable {
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
	int opselect = 0;
	int dropf = 0;
	int cfase = 0;
	boolean firstime = true;
	boolean shaded = false;
	int flipo = 0;
	int nextc = 0;
	int multion = 0;
	int gmode = 0;
	int[] unlocked = {
		1, 1
	};
	int[] scm = {
		0, 0
	};
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
	boolean onviewpro = false;
	int playingame = -1;
	int onjoin = -1;
	int ontyp = 0;
	boolean lan = false;
	float[] arnp = {
		0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F
	};
	String nickname = "";
	String clan = "";
	String nickey = "";
	String clankey = "";
	String backlog = "";
	String server = "multiplayer.needformadness.com";
	String localserver = "";
	String servername = "Madness";
	int servport = 7071;
	int gameport = 7001;
	int acexp = 0;
	int discon = 0;
	int cntptrys = 5;
	int[] delays = {
		600, 600, 600
	};
	int nplayers = 7;
	int im = 0;
	String[] plnames = {
		"", "", "", "", "", "", "", ""
	};
	int osc = 10;
	int minsl = 0;
	int maxsl = 15;
	int[] sc = {
		0, 0, 0, 0, 0, 0, 0, 0
	};
	int[] xstart = {
		0, -350, 350, 0, -350, 350, 0, 0
	};
	int[] zstart = {
		-760, -380, -380, 0, 380, 380, 760, 0
	};
	float[][] allrnp = new float[8][6];
	boolean[] isbot = new boolean[8];
	int clangame = 0;
	boolean clanchat = false;
	String[] pclan = {
		"", "", "", "", "", "", "", ""
	};
	String gaclan = "";
	int lcarx = 0;
	int lcary = 0;
	int lcarz = 0;
	int[] dcrashes = {
		0, 0, 0, 0, 0, 0, 0, 0
	};
	int beststunt = 0;
	int laptime = 0;
	int fastestlap = 0;
	int sendstat = 0;
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
	Image osped;
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
	Image sped;
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
	Image bggo;
	Image opback;
	Image nfmcoms;
	Image opti;
	Image opti2;
	Image bgmain;
	Image rpro;
	Image nfmcom;
	Image flaot;
	Image brt;
	Image arn;
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
	Image ks;
	Image kenter;
	Image nfm;
	Image login;
	Image register;
	Image play;
	Image sdets;
	Image cancel;
	Image bob;
	Image bot;
	Image bol;
	Image bolp;
	Image bor;
	Image borp;
	Image logout;
	Image change;
	Image pln;
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
	Image cnmc;
	Image redy;
	Image ntrg;
	Image[] bcl = new Image[2];
	Image[] bcr = new Image[2];
	Image[] bc = new Image[2];
	Image cmc;
	Image myc;
	Image gac;
	Image yac;
	Image ycmc;
	Image top20s;
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
	Image[] orank = new Image[8];
	Image[] rank = new Image[8];
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
	int[] dested = {
		0, 0, 0, 0, 0, 0, 0, 0
	};
	int dmcnt = 0;
	boolean dmflk = false;
	int pwcnt = 0;
	boolean pwflk = false;
	String[][] adj = {
		{
			"Cool", "Alright", "Nice"
		}, {
			"Wicked", "Amazing", "Super"
		}, {
			"Awesome", "Ripping", "Radical"
		}, {
			"What the...?", "You're a super star!!!!",
				"Who are you again...?"
		}, {
			"surf style", "off the lip", "bounce back"
		}
	};
	String[] exlm = {
		"!", "!!", "!!!"
	};
	String loop = "";
	String spin = "";
	String asay = "";
	int auscnt = 45;
	boolean aflk = false;
	int[] sndsize = {
		39, 128, 23, 58, 106, 140, 81, 135, 38, 141, 106, 76, 56,
		116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129,
		80, 44, 57, 123, 202, 210, 111
	};
	Image hello;
	Image sign;
	Image loadbar;
	int kbload = 0;
	int dnload = 0;
	float shload = 0.0F;
	Socket socket;
	BufferedReader din;
	PrintWriter dout;
	int radpx = 212;
	int pin = 60;
	int[] trkx = {
		65, 735
	};
	int trkl = 0;
	int trklim = (int)(Math.random() * 40.0);
	int lmode = 0;
	int[] bgmy = {
		0, -400
	};
	float bgf = 0.0F;
	boolean bgup = false;
	int[] ovx = {
		0, 0, 0, 0
	};
	int[] ovy = {
		0, 0, 0, 0
	};
	int[] ovw = {
		0, 0, 0, 0
	};
	int[] ovh = {
		0, 0, 0, 0
	};
	int[] ovsx = {
		0, 0, 0, 0
	};
	int removeds = 0;
	int nfmtab = 0;
	boolean justwon1 = false;
	boolean justwon2 = false;
	int lfrom = 0;
	int lockcnt = 0;
	boolean showtf = false;
	int ransay = 0;
	String[][] cnames = {
		{
			"", "", "", "", "", "", "Game Chat  "
		}, {
			"", "", "", "", "", "", "Your Clan's Chat  "
		}
	};
	String[][] sentn = {
		{
			"", "", "", "", "", "", ""
		}, {
			"", "", "", "", "", "", ""
		}
	};
	int[] updatec = {
		-1, -1
	};
	int[] movepos = {
		0, 0
	};
	int[] pointc = {
		6, 6
	};
	int[] floater = {
		0, 0
	};
	int[] cntchatp = {
		0, 0
	};
	int[] msgflk = {
		0, 0
	};
	String[] lcmsg = {
		"", ""
	};
	int flkat = 0;
	int movly = 0;
	int gxdu = 0;
	int gydu = 0;
	int muhi = 0;
	int lsc = -1;
	int mouson = -1;
	int onmsc = -1;
	boolean remi = false;
	int basefase = 0;
	boolean noclass = false;
	int gatey = 300;
	int[] pgatx = {
		211, 240, 280, 332, 399, 466, 517, 558, 586
	};
	int[] pgaty = {
		193, 213, 226, 237, 244, 239, 228, 214, 196
	};
	int[] pgady = {
		0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	boolean[] pgas = {
		false, false, false, false, false, false, false, false, false
	};
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

	public xtGraphics(Medium medium, CarDefine cardefine,
	Graphics2D graphics2d, GameSparker gamesparker) {
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
				if (string.indexOf("access denied") != -1) this.nofull = true;
			}
		}
		this.badmac = false;
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
			File file = new File(new StringBuilder().append("").append(Madness.fpath).append("data/sounds.zip").toString());
			FileInputStream fileinputstream = new FileInputStream(file);
			ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			for (ZipEntry zipentry = zipinputstream.getNextEntry();
			zipentry != null; zipentry = zipinputstream.getNextEntry()) {
				int i = (int) zipentry.getSize();
				String string = zipentry.getName();
				byte[] is = new byte[i];
				int i_0_ = 0;
				int i_1_;
				for ( /**/ ; i > 0; i -= i_1_) {
					i_1_ = zipinputstream.read(is, i_0_, i);
					i_0_ += i_1_;
				}
				for (int i_2_ = 0; i_2_ < 5; i_2_++) {
					for (int i_3_ = 0; i_3_ < 5; i_3_++) {
						if (string.equals(new StringBuilder().append("").append(i_3_).append("").append(i_2_).append(".wav").toString())) this.engs[i_3_][i_2_] = new soundClip(is);
					}
				}
				for (int i_4_ = 0; i_4_ < 6; i_4_++) {
					if (string.equals(new StringBuilder().append("air").append(i_4_).append(".wav").toString())) this.air[i_4_] = new soundClip(is);
				}
				for (int i_5_ = 0; i_5_ < 3; i_5_++) {
					if (string.equals(new StringBuilder().append("crash")
						.append(i_5_ + 1).append(".wav").toString())) this.crash[i_5_] = new soundClip(is);
				}
				for (int i_6_ = 0; i_6_ < 3; i_6_++) {
					if (string.equals(new StringBuilder().append("lowcrash").append(i_6_ + 1).append(".wav").toString())) this.lowcrash[i_6_] = new soundClip(is);
				}
				for (int i_7_ = 0; i_7_ < 3; i_7_++) {
					if (string.equals(new StringBuilder().append("skid").append(i_7_ + 1).append(".wav").toString())) this.skid[i_7_] = new soundClip(is);
				}
				for (int i_8_ = 0; i_8_ < 3; i_8_++) {
					if (string.equals(new StringBuilder().append("dustskid").append(i_8_ + 1).append(".wav").toString())) this.dustskid[i_8_] = new soundClip(is);
				}
				for (int i_9_ = 0; i_9_ < 3; i_9_++) {
					if (string.equals(new StringBuilder().append("scrape")
						.append(i_9_ + 1).append(".wav").toString())) {
						this.scrape[i_9_] = new soundClip(is);
						if (i_9_ == 2) this.scrape[3] = new soundClip(is);
					}
				}
				if (string.equals("powerup.wav")) this.powerup = new soundClip(is);
				if (string.equals("tires.wav")) this.tires = new soundClip(is);
				if (string.equals("checkpoint.wav")) this.checkpoint = new soundClip(is);
				if (string.equals("carfixed.wav")) this.carfixed = new soundClip(is);
				if (string.equals("three.wav")) this.three = new soundClip(is);
				if (string.equals("two.wav")) this.two = new soundClip(is);
				if (string.equals("one.wav")) this.one = new soundClip(is);
				if (string.equals("go.wav")) this.go = new soundClip(is);
				if (string.equals("wasted.wav")) this.wastd = new soundClip(is);
				if (string.equals("firewasted.wav")) this.firewasted = new soundClip(is);
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
			File file = new File(new StringBuilder().append("").append(Madness.fpath).append("data/images.zip").toString());
			FileInputStream fileinputstream = new FileInputStream(file);
			ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			for (ZipEntry zipentry = zipinputstream.getNextEntry();
			zipentry != null; zipentry = zipinputstream.getNextEntry()) {
				int i = (int) zipentry.getSize();
				String string = zipentry.getName();
				byte[] is = new byte[i];
				int i_11_ = 0;
				int i_12_;
				for ( /**/ ; i > 0; i -= i_12_) {
					i_12_ = zipinputstream.read(is, i_11_, i);
					i_11_ += i_12_;
				}
				if (string.equals("cars.gif")) this.carsbg = loadBimage(is, mediatracker, toolkit, 1);
				if (string.equals("color.gif")) image = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("class.gif")) image_10_ = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("smokey.gif")) smokeypix(is, mediatracker, toolkit);
				if (string.equals("1.gif")) this.orank[0] = loadimage(is, mediatracker, toolkit);
				if (string.equals("gameh.gif")) this.ogameh = loadimage(is, mediatracker, toolkit);
				if (string.equals("wgame.gif")) this.owgame = loadimage(is, mediatracker, toolkit);
				if (string.equals("gameov.gif")) this.gameov = loadimage(is, mediatracker, toolkit);
				if (string.equals("lap.gif")) this.olap = loadimage(is, mediatracker, toolkit);
				if (string.equals("paused.gif")) this.paused = loadimage(is, mediatracker, toolkit);
				if (string.equals("select.gif")) this.select = loadimage(is, mediatracker, toolkit);
				if (string.equals("yourwasted.gif")) this.oyourwasted = loadimage(is, mediatracker, toolkit);
				if (string.equals("disco.gif")) this.odisco = loadimage(is, mediatracker, toolkit);
				if (string.equals("youwastedem.gif")) this.oyouwastedem = loadimage(is, mediatracker, toolkit);
				if (string.equals("gamefinished.gif")) this.ogamefinished = loadimage(is, mediatracker, toolkit);
				if (string.equals("exitgame.gif")) this.oexitgame = loadimage(is, mediatracker, toolkit);
				if (string.equals("pgate.gif")) this.pgate = loadimage(is, mediatracker, toolkit);
				if (string.equals("d1.png")) this.dude[0] = loadimage(is, mediatracker, toolkit);
				if (string.equals("d2.png")) this.dude[1] = loadimage(is, mediatracker, toolkit);
				if (string.equals("d3.png")) this.dude[2] = loadimage(is, mediatracker, toolkit);
				if (string.equals("float.gif")) this.oflaot = loadimage(is, mediatracker, toolkit);
				if (string.equals("1c.gif")) this.ocntdn[1] = loadimage(is, mediatracker, toolkit);
				if (string.equals("2c.gif")) this.ocntdn[2] = loadimage(is, mediatracker, toolkit);
				if (string.equals("3c.gif")) this.ocntdn[3] = loadimage(is, mediatracker, toolkit);
				if (string.equals("2.gif")) this.orank[1] = loadimage(is, mediatracker, toolkit);
				if (string.equals("3.gif")) this.orank[2] = loadimage(is, mediatracker, toolkit);
				if (string.equals("4.gif")) this.orank[3] = loadimage(is, mediatracker, toolkit);
				if (string.equals("5.gif")) this.orank[4] = loadimage(is, mediatracker, toolkit);
				if (string.equals("6.gif")) this.orank[5] = loadimage(is, mediatracker, toolkit);
				if (string.equals("7.gif")) this.orank[6] = loadimage(is, mediatracker, toolkit);
				if (string.equals("8.gif")) this.orank[7] = loadimage(is, mediatracker, toolkit);
				if (string.equals("bgmain.jpg")) this.bgmain = loadBimage(is, mediatracker, toolkit, 2);
				if (string.equals("br.png")) this.br = loadimage(is, mediatracker, toolkit);
				if (string.equals("loadingmusic.gif")) this.oloadingmusic = loadimage(is, mediatracker, toolkit);
				if (string.equals("radicalplay.gif")) this.radicalplay = loadimage(is, mediatracker, toolkit);
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
				if (string.equals("rpro.gif")) this.rpro = loadimage(is, mediatracker, toolkit);
				if (string.equals("selectcar.gif")) this.selectcar = loadimage(is, mediatracker, toolkit);
				if (string.equals("track.jpg")) {
					this.trackbg[0] = loadBimage(is, mediatracker, toolkit, 3);
					this.trackbg[1] = dodgen(this.trackbg[0]);
				}
				if (string.equals("youlost.gif")) this.oyoulost = loadimage(is, mediatracker, toolkit);
				if (string.equals("youwon.gif")) this.oyouwon = loadimage(is, mediatracker, toolkit);
				if (string.equals("0c.gif")) this.ocntdn[0] = loadimage(is, mediatracker, toolkit);
				if (string.equals("damage.gif")) this.odmg = loadimage(is, mediatracker, toolkit);
				if (string.equals("power.gif")) this.opwr = loadimage(is, mediatracker, toolkit);
				if (string.equals("position.gif")) this.opos = loadimage(is, mediatracker, toolkit);
				if (string.equals("speed.gif")) this.osped = loadimage(is, mediatracker, toolkit);
				if (string.equals("wasted.gif")) this.owas = loadimage(is, mediatracker, toolkit);
				if (string.equals("start1.gif")) this.ostar[0] = loadimage(is, mediatracker, toolkit);
				if (string.equals("start2.gif")) {
					this.ostar[1] = loadimage(is, mediatracker, toolkit);
					this.star[2] = pressed(this.ostar[1]);
				}
				if (string.equals("congrad.gif")) this.congrd = loadimage(is, mediatracker, toolkit);
				if (string.equals("statb.gif")) this.statb = loadimage(is, mediatracker, toolkit);
				if (string.equals("statbo.gif")) this.statbo = loadimage(is, mediatracker, toolkit);
				if (string.equals("madness.gif")) this.mdness = loadude(is, mediatracker, toolkit);
				if (string.equals("fixhoop.png")) this.fixhoop = loadimage(is, mediatracker, toolkit);
				if (string.equals("arrow.gif")) this.sarrow = loadimage(is, mediatracker, toolkit);
				if (string.equals("stunts.png")) this.stunts = loadimage(is, mediatracker, toolkit);
				if (string.equals("racing.gif")) this.racing = loadimage(is, mediatracker, toolkit);
				if (string.equals("wasting.gif")) this.wasting = loadimage(is, mediatracker, toolkit);
				if (string.equals("plus.gif")) this.plus = loadimage(is, mediatracker, toolkit);
				if (string.equals("space.gif")) this.space = loadimage(is, mediatracker, toolkit);
				if (string.equals("arrows.gif")) this.arrows = loadimage(is, mediatracker, toolkit);
				if (string.equals("chil.gif")) this.chil = loadimage(is, mediatracker, toolkit);
				if (string.equals("ory.gif")) this.ory = loadimage(is, mediatracker, toolkit);
				if (string.equals("kz.gif")) this.kz = loadimage(is, mediatracker, toolkit);
				if (string.equals("kx.gif")) this.kx = loadimage(is, mediatracker, toolkit);
				if (string.equals("kv.gif")) this.kv = loadimage(is, mediatracker, toolkit);
				if (string.equals("km.gif")) this.km = loadimage(is, mediatracker, toolkit);
				if (string.equals("kn.gif")) this.kn = loadimage(is, mediatracker, toolkit);
				if (string.equals("ks.gif")) this.ks = loadimage(is, mediatracker, toolkit);
				if (string.equals("kenter.gif")) this.kenter = loadimage(is, mediatracker, toolkit);
				if (string.equals("nfm.gif")) this.nfm = loadimage(is, mediatracker, toolkit);
				if (string.equals("options.png")) this.opti = loadimage(is, mediatracker, toolkit);
				if (string.equals("options2.png")) this.opti2 = loadimage(is, mediatracker, toolkit);
				if (string.equals("opback.png")) this.opback = loadimage(is, mediatracker, toolkit);
				if (string.equals("logocars.png")) this.logocars = loadimage(is, mediatracker, toolkit);
				if (string.equals("logomad.png")) this.logomadnes = loadimage(is, mediatracker, toolkit);
				if (string.equals("logomadbg.jpg")) this.logomadbg = loadimage(is, mediatracker, toolkit);
				if (string.equals("byrd.png")) this.byrd = loadimage(is, mediatracker, toolkit);
				if (string.equals("bggo.jpg")) this.bggo = loadimage(is, mediatracker, toolkit);
				if (string.equals("nfmcoms.png")) this.nfmcoms = loadimage(is, mediatracker, toolkit);
				if (string.equals("nfmcom.gif")) this.nfmcom = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("brit.gif")) this.brt = loadimage(is, mediatracker, toolkit);
				if (string.equals("arn.gif")) this.arn = loadimage(is, mediatracker, toolkit);
				if (string.equals("mload.gif")) this.mload = loadimage(is, mediatracker, toolkit);
				if (string.equals("login.gif")) this.login = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("play.gif")) this.play = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("cancel.gif")) this.cancel = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("register.gif")) this.register = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("upgrade.gif")) this.upgrade = loadimage(is, mediatracker, toolkit);
				if (string.equals("sdets.gif")) this.sdets = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("bob.gif")) this.bob = loadBimage(is, mediatracker, toolkit, 1);
				if (string.equals("bot.gif")) this.bot = loadBimage(is, mediatracker, toolkit, 1);
				if (string.equals("bol.gif")) this.bol = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("bolp.gif")) this.bolp = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("bor.gif")) this.bor = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("borp.gif")) this.borp = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("logout.gif")) this.logout = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("change.gif")) this.change = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("pln.gif")) this.pln = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("bols.gif")) this.bols = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("bolps.gif")) this.bolps = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("bors.gif")) this.bors = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("borps.gif")) this.borps = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("games.gif")) this.games = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("exit.gif")) this.exit = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("chat.gif")) this.chat = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("players.gif")) this.players = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("roomp.gif")) this.roomp = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("cnmc.gif")) this.cnmc = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("ready.gif")) this.redy = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("notreg.gif")) this.ntrg = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("cgame.gif")) this.cgame = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("ccar.gif")) this.ccar = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("lanm.gif")) this.lanm = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("asu.gif")) this.asu = loadimage(is, mediatracker, toolkit);
				if (string.equals("asd.gif")) this.asd = loadimage(is, mediatracker, toolkit);
				if (string.equals("pls.gif")) this.pls = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("sts.gif")) this.sts = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("gmc.gif")) this.gmc = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("stg.gif")) this.stg = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("crd.gif")) this.crd = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("bcl.gif")) this.bcl[0] = loadimage(is, mediatracker, toolkit);
				if (string.equals("bcr.gif")) this.bcr[0] = loadimage(is, mediatracker, toolkit);
				if (string.equals("bc.gif")) this.bc[0] = loadimage(is, mediatracker, toolkit);
				if (string.equals("pbcl.gif")) this.bcl[1] = loadimage(is, mediatracker, toolkit);
				if (string.equals("pbcr.gif")) this.bcr[1] = loadimage(is, mediatracker, toolkit);
				if (string.equals("pbc.gif")) this.bc[1] = loadimage(is, mediatracker, toolkit);
				if (string.equals("cmc.gif")) this.cmc = loadimage(is, mediatracker, toolkit);
				if (string.equals("myc.gif")) this.myc = loadimage(is, mediatracker, toolkit);
				if (string.equals("gac.gif")) this.gac = loadimage(is, mediatracker, toolkit);
				if (string.equals("yac.gif")) this.yac = loadimage(is, mediatracker, toolkit);
				if (string.equals("ycmc.gif")) this.ycmc = loadimage(is, mediatracker, toolkit);
				if (string.equals("top20s.gif")) this.top20s = loadimage(is, mediatracker, toolkit);
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
		boolean bool = false;
		while (this.runtyp > 0) {
			if (this.runtyp >= 1 && this.runtyp <= 140) hipnoload(this.runtyp, false);
			if (this.runtyp == 176) {
				loading();
				bool = true;
			}
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
		if (bool) {
			pingstat();
			bool = false;
		}
		boolean[] bools = {
			true, true
		};
		while ((this.runtyp == -101 || this.sendstat == 1) && !this.lan) {
			String string = new StringBuilder().append("3|").append(this.playingame).append("|").append(this.updatec[0]).append("|").toString();
			if (this.clanchat) string = new StringBuilder().append(string).append("").append(this.updatec[1]).append("|").append(this.clan).append("|").append(this.clankey).append("|").toString();
			else string = new StringBuilder().append(string).append("0|||")
				.toString();
			if (this.updatec[0] <= -11) {
				for (int i = 0; i < -this.updatec[0] - 10; i++)
				string = new StringBuilder().append(string).append("").append(this.cnames[0][6 - i]).append("|").append(this.sentn[0][6 - i]).append("|").toString();
				this.updatec[0] = -2;
			}
			if (this.clanchat && this.updatec[1] <= -11) {
				for (int i = 0; i < -this.updatec[1] - 10; i++)
				string = new StringBuilder().append(string).append("").append(this.cnames[1][6 - i]).append("|").append(this.sentn[1][6 - i]).append("|").toString();
				this.updatec[1] = -2;
			}
			if (this.sendstat == 1) {
				string = new StringBuilder().append("5|").append(this.playingame).append("|").append(this.im).append("|").append(this.beststunt).append("|").append(this.fastestlap).append("|").toString();
				for (int i = 0; i < this.nplayers; i++)
				string = new StringBuilder().append(string).append("").append(this.dcrashes[i]).append("|").toString();
				this.sendstat = 2;
			}
			boolean bool_13_ = false;
			String string_14_ = "";
			try {
				this.dout.println(string);
				string_14_ = this.din.readLine();
				if (string_14_ == null) bool_13_ = true;
			} catch (Exception exception) {
				bool_13_ = true;
			}
			if (bool_13_) {
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
					this.socket = new Socket(this.server,
					this.servport);
					this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
					this.dout = new PrintWriter(this.socket.getOutputStream(),
					true);
					this.dout.println(string);
					string_14_ = this.din.readLine();
					if (string_14_ != null) bool_13_ = false;
				} catch (Exception exception) {
					/* empty */
				}
			}
			if (bool_13_) {
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
			if (this.sendstat != 2) {
				int i = 2;
				int i_15_ = 1;
				if (this.clanchat) i_15_ = 2;
				for (int i_16_ = 0; i_16_ < i_15_; i_16_++) {
					int i_17_ = getvalue(string_14_, i_16_);
					if (this.updatec[i_16_] != i_17_ && this.updatec[i_16_] >= -2 && this.pointc[i_16_] == 6) {
						for (int i_18_ = 0; i_18_ < 7; i_18_++) {
							this.cnames[i_16_][i_18_] = getSvalue(string_14_, i);
							i++;
							this.sentn[i_16_][i_18_] = getSvalue(string_14_, i);
							i++;
						}
						if (this.cnames[i_16_][6].equals("")) {
							if (i_16_ == 0) this.cnames[i_16_][6] = "Game Chat  ";
							else this.cnames[i_16_][6] = new StringBuilder().append("").append(this.clan).append("'s Chat  ").toString();
						}
						if (this.updatec[i_16_] != -2) {
							this.floater[i_16_] = 1;
							if (bools[i_16_]) {
								this.msgflk[i_16_] = 67;
								bools[i_16_] = false;
							} else this.msgflk[i_16_] = 110;
						}
						this.updatec[i_16_] = i_17_;
					}
				}
			} else this.sendstat = 3;
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
				this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
				this.dout = new PrintWriter(this.socket.getOutputStream(),
				true);
				this.dout.println(new StringBuilder().append("101|").append(this.runtyp + 174).append("|").append((this.app).tnick.getText())
					.append("|").append((this.app).tpass.getText())
					.append("|").toString());
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
		if (this.runtyp == -166 || this.runtyp == -167 || this.runtyp == -168) pingstat();
	}

	public void stopchat() {
		this.clanchat = false;
		this.clangame = 0;
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

	public void sendwin(CheckPoints checkpoints) {
		if (this.logged && this.multion == 1 && this.winner) {
			if ((checkpoints).wasted == this.nplayers - 1) this.runtyp = -167;
			else this.runtyp = -168;
		} else this.runtyp = -166;
		this.runner = new Thread(this);
		this.runner.start();
	}

	public void loading() {
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(0, 0, 800, 450);
		this.rd.drawImage(this.sign, 362, 35,
		this);
		this.rd.drawImage(this.hello, 125, 105,
		this);
		this.rd.setColor(new Color(198, 214, 255));
		this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
		this.rd.setColor(new Color(128, 167, 255));
		this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
		this.rd.drawImage(this.loadbar, 281, 365,
		this);
		this.rd.setFont(new Font("Arial", 1, 11));
		this.ftm = this.rd.getFontMetrics();
		drawcs(358, "Loading game, please wait.", 0, 0, 0, 3);
		this.rd.setColor(new Color(255, 255, 255));
		this.rd.fillRect(295, 398, 210, 17);
		this.shload += ((float) this.dnload + 10.0F - this.shload) / 100.0F;
		if (this.shload > (float) this.kbload) this.shload = (float) this.kbload;
		if (this.dnload == this.kbload) this.shload = (float) this.kbload;
		drawcs(410, new StringBuilder().append("").append((int)((26.0F + (this.shload / (float) this.kbload * 200.0F)) / 226.0F * 100.0F))
			.append(" % loaded    |    ").append(this.kbload - (int) this.shload)
			.append(" KB remaining").toString(), 32, 64, 128, 3);
		this.rd.setColor(new Color(32, 64, 128));
		this.rd.fillRect(287, 371,
		26 + (int)(this.shload / (float)(
		this).kbload * 200.0F),
		10);
	}

	public void stoploading() {
		loading();
		this.app.repaint();
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
			for (int i_19_ = 0; i_19_ < 5; i_19_++) {
				this.engs[i][i_19_].stop();
				this.engs[i][i_19_] = null;
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
		for (int i_20_ = 0; i_20_ < 8; i_20_++) {
			this.dested[i_20_] = 0;
			this.isbot[i_20_] = false;
			this.dcrashes[i_20_] = 0;
		}
		this.runtyp = 0;
		this.discon = 0;
		this.dnload = 0;
		this.beststunt = 0;
		this.laptime = 0;
		this.fastestlap = 0;
		this.sendstat = 0;
		if (this.fase == 2 || this.fase == -22) sortcars(i);
		if (this.fase == 22) {
			for (int i_21_ = 0; i_21_ < 2; i_21_++) {
				for (int i_22_ = 0; i_22_ < 7; i_22_++) {
					this.cnames[i_21_][i_22_] = "";
					this.sentn[i_21_][i_22_] = "";
				}
				if (i_21_ == 0) this.cnames[i_21_][6] = "Game Chat  ";
				else this.cnames[i_21_][6] = new StringBuilder().append("").append(this.clan).append("'s Chat  ").toString();
				this.updatec[i_21_] = -1;
				this.movepos[i_21_] = 0;
				this.pointc[i_21_] = 6;
				this.floater[i_21_] = 0;
				this.cntchatp[i_21_] = 0;
				this.msgflk[i_21_] = 0;
				this.lcmsg[i_21_] = "";
			}
			if (this.multion == 3) this.ransay = 4;
			else if (this.ransay == 0) this.ransay = 1 + (int)(Math.random() * 3.0);
			else {
				this.ransay++;
				if (this.ransay > 3) this.ransay = 1;
			}
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
		if (this.pin != 0) this.rd.drawImage(this.radicalplay, (this.radpx + (int)(8.0 * Math.random() - 4.0)),
		135, null);
		else this.rd.drawImage(this.radicalplay,
		212, 135, null);
		if (this.radpx != 212) {
			this.radpx += 40;
			if (this.radpx > 735) this.radpx = -388;
		} else if (this.pin != 0) this.pin--;
		if (i == 40) {
			this.radpx = 213;
			this.pin = 7;
		}
		if (this.radpx == 212) {
			this.rd.setFont(new Font("Arial", 1, 11));
			this.ftm = this.rd.getFontMetrics();
			drawcs(185 + (int)(5.0F * this.m.random()),
				"Radicalplay.com", 112, 120, 143, 3);
		}
		this.rd.setFont(new Font("Arial", 1, 11));
		this.ftm = this.rd.getFontMetrics();
		if (this.aflk) {
			drawcs(215,
				"And we are never going to find the new unless we get a little crazy...",
			112, 120, 143, 3);
			this.aflk = false;
		} else {
			drawcs(217,
				"And we are never going to find the new unless we get a little crazy...",
			150, 150, 150, 3);
			this.aflk = true;
		}
		this.rd.drawImage(this.rpro, 275, 265,
		null);
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(0, 0, 65, 450);
		this.rd.fillRect(735, 0, 65, 450);
		this.rd.fillRect(65, 0, 670, 25);
		this.rd.fillRect(65, 425, 670, 25);
	}

	public void credits(Control control, int i, int i_23_, int i_24_) {
		if (this.flipo == 0) {
			this.powerup.play();
			this.flipo = 1;
		}
		if (this.flipo >= 1 && this.flipo <= 100) {
			rad(this.flipo);
			this.flipo++;
			if (this.flipo == 100) this.flipo = 1;
		}
		if (this.flipo == 101) {
			mainbg(-1);
			this.rd.drawImage(this.mdness, 283,
			32, null);
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			drawcs(90, "At Radicalplay.com", 0, 0, 0, 3);
			drawcs(165,
				"Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects",
			0, 0, 0, 3);
			drawcs(185, "By Omar Waly", 40, 60, 0, 3);
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			drawcs(225, "Special Thanks!", 0, 0, 0, 3);
			this.rd.setFont(new Font("Arial", 1, 11));
			this.ftm = this.rd.getFontMetrics();
			drawcs(245,
				"Thanks to Dany Fernandez Diaz (DragShot) for imporving the game\u2019s music player to play more mod formats & effects!",
			66, 98, 0, 3);
			drawcs(260,
				"Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.",
			66, 98, 0, 3);
			drawcs(275,
				"Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.",
			66, 98, 0, 3);
			drawcs(290,
				"Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.",
			66, 98, 0, 3);
			drawcs(305,
				"A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!",
			66, 98, 0, 3);
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
			this.rd.setFont(new Font("Arial", 1, 11));
			this.ftm = this.rd.getFontMetrics();
			drawcs(365,
				"Most of the tracks where remixed by Omar Waly to match the game.",
			66, 98, 0, 3);
			drawcs(380,
				"More details about the tracks and their original composers at:",
			66, 98, 0, 3);
			drawcs(395, "http://multiplayer.needformadness.com/music.html", 33,
			49, 0, 3);
			this.rd.drawLine(400 - ((this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html")) / 2),
			396, ((this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html")) / 2 + 400),
			396);
			if (i > 258 && i < 542 && i_23_ > 385 && i_23_ < 399) {
				this.app.setCursor(new Cursor(12));
				if (i_24_ == 2) this.app.musiclink();
			} else this.app.setCursor(new Cursor(0));
		}
		if (this.flipo == 102) {
			mainbg(0);
			this.rd.drawImage(this.nfmcom, 190,
			195, null);
			if (i > 190 && i < 609 && i_23_ > 195 && i_23_ < 216) {
				this.app.setCursor(new Cursor(12));
				if (i_24_ == 2) this.app.madlink();
			} else this.app.setCursor(new Cursor(0));
		}
		this.rd.drawImage((this.next[this.pnext]),
		665, 395, null);
		if ((control).enter || (control).handb || (control).right) {
			if (this.flipo >= 1 && this.flipo <= 100) {
				this.flipo = 101;
				this.app.setCursor(new Cursor(0));
			} else this.flipo++;
			if (this.flipo == 103) {
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
			this.trklim = (int)(Math.random() * 40.0);
			this.trkl = 0;
		}
		if (bool) i = 0;
		for (int i_25_ = 0; i_25_ < 2; i_25_++) {
			this.rd.drawImage(this.trackbg[i],
			this.trkx[i_25_],
			25, null);
			this.trkx[i_25_] -= 10;
			if (this.trkx[i_25_] <= -605) this.trkx[i_25_] = 735;
		}
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(0, 0, 65, 450);
		this.rd.fillRect(735, 0, 65, 450);
		this.rd.fillRect(65, 0, 670, 25);
		this.rd.fillRect(65, 425, 670, 25);
	}

	public void mainbg(int i) {
		int i_26_ = 2;
		this.rd.setColor(new Color(191, 184, 124));
		if (i == -1) {
			if (i != this.lmode) {
				this.bgmy[0] = 0;
				this.bgmy[1] = -400;
				this.bgup = false;
				this.bgf = 0.0F;
				this.lmode = i;
			}
			this.rd.setColor(new Color(144, 222, 9));
			i_26_ = 8;
		}
		if (i == 0) {
			if (i != this.lmode) {
				this.bgmy[0] = 0;
				this.bgmy[1] = -400;
				this.bgup = false;
				this.bgf = 0.0F;
				this.lmode = i;
			}
			int i_27_ = (int)(255.0F * this.bgf + 191.0F * (1.0F - this.bgf));
			int i_28_ = (int)(176.0F * this.bgf + 184.0F * (1.0F - this.bgf));
			int i_29_ = (int)(67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
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
			this.rd.setColor(new Color(i_27_, i_28_, i_29_));
			i_26_ = 4;
		}
		if (i == 1) {
			if (i != this.lmode) {
				this.bgmy[0] = 0;
				this.bgmy[1] = -400;
				this.lmode = i;
			}
			this.rd.setColor(new Color(255, 176, 67));
			i_26_ = 8;
		}
		if (i == 2) {
			if (i != this.lmode) {
				this.bgmy[0] = 0;
				this.bgmy[1] = -400;
				this.lmode = i;
				this.bgf = 0.2F;
			}
			this.rd.setColor(new Color(188, 170, 122));
			if (this.flipo == 16) {
				int i_30_ = (int)(176.0F * this.bgf + 191.0F * (1.0F - this.bgf));
				int i_31_ = (int)(202.0F * this.bgf + 184.0F * (1.0F - this.bgf));
				int i_32_ = (int)(255.0F * this.bgf + 124.0F * (1.0F - this.bgf));
				this.rd.setColor(new Color(i_30_, i_31_,
				i_32_));
				this.bgf += 0.025F;
				if (this.bgf > 0.85F) this.bgf = 0.85F;
			} else this.bgf = 0.2F;
			i_26_ = 2;
		}
		if (i == 3) {
			if (i != this.lmode) {
				this.bgmy[0] = 0;
				this.bgmy[1] = -400;
				this.bgup = false;
				this.bgf = 0.0F;
				this.lmode = i;
			}
			int i_33_ = (int)(255.0F * this.bgf + 191.0F * (1.0F - this.bgf));
			int i_34_ = (int)(176.0F * this.bgf + 184.0F * (1.0F - this.bgf));
			int i_35_ = (int)(67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
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
			this.rd.setColor(new Color(i_33_, i_34_, i_35_));
			i_26_ = 2;
		}
		if (i != -101) {
			if (i == 4) {
				this.rd.setColor(new Color(216, 177, 100));
				this.rd.fillRect(65, 0, 670, 425);
			} else this.rd.fillRect(65, 25, 670, 400);
		}
		if (i == 4) {
			if (i != this.lmode) {
				this.bgmy[0] = 0;
				this.bgmy[1] = 400;
				for (int i_36_ = 0; i_36_ < 4; i_36_++) {
					this.ovw[i_36_] = (int)(50.0 + 150.0 * Math.random());
					this.ovh[i_36_] = (int)(50.0 + 150.0 * Math.random());
					this.ovy[i_36_] = (int)(400.0 * Math.random());
					this.ovx[i_36_] = (int)(Math.random() * 670.0);
					this.ovsx[i_36_] = (int)(5.0 + Math.random() * 10.0);
				}
				this.lmode = i;
			}
			for (int i_37_ = 0; i_37_ < 4; i_37_++) {
				this.rd.setColor(new Color(235, 176, 84));
				this.rd.fillOval((int)((double)(65 + this.ovx[i_37_]) - ((double) this.ovw[i_37_] * 1.5 / 2.0)), (int)((double)(25 + this.ovy[i_37_]) - ((double) this.ovh[i_37_] * 1.5 / 2.0)), (int)((double) this.ovw[i_37_] * 1.5), (int)((double) this.ovh[i_37_] * 1.5));
				this.rd.setColor(new Color(255, 176, 67));
				this.rd.fillOval((65 + this.ovx[i_37_] - this.ovh[i_37_] / 2), (25 + this.ovy[i_37_] - this.ovh[i_37_] / 2),
				this.ovw[i_37_],
				this.ovh[i_37_]);
				this.ovx[i_37_] -= this.ovsx[i_37_];
				if (((double) this.ovx[i_37_] + (double) this.ovw[i_37_] * 1.5 / 2.0) < 0.0) {
					this.ovw[i_37_] = (int)(50.0 + 150.0 * Math.random());
					this.ovh[i_37_] = (int)(50.0 + 150.0 * Math.random());
					this.ovy[i_37_] = (int)(400.0 * Math.random());
					this.ovx[i_37_] = (int)(670.0 + ((double) this.ovw[i_37_] * 1.5 / 2.0));
					this.ovsx[i_37_] = (int)(5.0 + Math.random() * 10.0);
				}
			}
		}
		if (i != -101 && i != 4) {
			for (int i_38_ = 0; i_38_ < 2; i_38_++) {
				if (i != 2 || this.flipo != 16) this.rd.drawImage(this.bgmain, 65,
				25 + this.bgmy[i_38_], null);
				this.bgmy[i_38_] += i_26_;
				if (this.bgmy[i_38_] >= 400) this.bgmy[i_38_] = -400;
			}
		}
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(0, 0, 65, 450);
		this.rd.fillRect(735, 0, 65, 450);
		if (i != 4) this.rd.fillRect(65, 0, 670, 25);
		this.rd.fillRect(65, 425, 670, 25);
	}

	public void inishstageselect(CheckPoints checkpoints) {
		if ((checkpoints).stage == -2 && ((this.cd).msloaded != 1 || !this.logged)) {
			(checkpoints).stage = (int)(Math.random() * 27.0) + 1;
			(checkpoints).top20 = 0;
		}
		if ((checkpoints).stage > 27)
		(checkpoints).stage = (int)(Math.random() * 27.0) + 1;
		if ((checkpoints).stage == -2) {
			boolean bool = false;
			for (int i = 1; i < (this.app)
				.mstgs.getItemCount(); i++) {
				if ((this.app).mstgs.getItem(i).equals((checkpoints).name)) bool = true;
			}
			if (!bool)
			(checkpoints).stage = (int)(Math.random() * 27.0) + 1;
		}
		if (this.gmode == 1) {
			if (this.unlocked[0] != 11 || this.justwon1)
			(checkpoints).stage = this.unlocked[0];
			else if (this.winner || (checkpoints).stage > 11)
			(checkpoints).stage = (int)(Math.random() * 11.0) + 1;
			if ((checkpoints).stage == 11)
			(checkpoints).stage = 27;
		}
		if (this.gmode == 2) {
			if (this.unlocked[0] != 17 || this.justwon2)
			(checkpoints).stage = this.unlocked[1] + 10;
			else if (this.winner || (checkpoints).stage < 11)
			(checkpoints).stage = (int)(Math.random() * 17.0) + 11;
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
			(this.app).sgame.select(5);
			this.nfmtab = 5;
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
		if (bool) this.rd.drawImage(this.select, 338,
		35, null);
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
		this.rd.drawImage(this.select, 338, 35,
		null);
		this.rd.setFont(new Font("Arial", 1, 13));
		this.ftm = this.rd.getFontMetrics();
		drawcs(130, new StringBuilder().append("This stage will be unlocked when stage ").append(this.unlocked[this.gmode - 1])
			.append(" is complete!").toString(), 177, 177, 177, 3);
		for (int i = 0; i < 9; i++)
		this.rd.drawImage(this.pgate,
		277 + i * 30, 215, null);
		this.rd.setFont(new Font("Arial", 1, 12));
		this.ftm = this.rd.getFontMetrics();
		if (this.aflk) {
			drawcs(185, new StringBuilder().append("[ Stage ").append((this.unlocked[this.gmode - 1]) + 1)
				.append(" Locked ]").toString(), 255, 128, 0, 3);
			this.aflk = false;
		} else {
			drawcs(185, new StringBuilder().append("[ Stage ").append((this.unlocked[this.gmode - 1]) + 1)
				.append(" Locked ]").toString(), 255, 0, 0, 3);
			this.aflk = true;
		}
		this.rd.drawImage((this.back[this.pback]),
		370, 345, null);
		this.lockcnt--;
		if (this.lockcnt == 0 || (control).enter || (control).handb || (control).left) {
			(control).left = false;
			(control).handb = false;
			(control).enter = false;
			this.fase = 1;
		}
	}

	public void stageselect(CheckPoints checkpoints, Control control, int i,
	int i_39_, boolean bool) {
		this.rd.drawImage(this.br, 65, 25, null);
		this.rd.drawImage(this.select, 338, 35,
		null);
		if (this.testdrive != 3 && this.testdrive != 4) {
			if ((checkpoints).stage > 0 && (this.cd).staction == 0) {
				if ((checkpoints).stage != 1 && ((checkpoints).stage != 11 || this.gmode != 2)) this.rd.drawImage((this.back[(this.pback)]),
				115, 135, null);
				if ((checkpoints).stage != 27) this.rd.drawImage((this.next[(this.pnext)]),
				625, 135, null);
			}
			if (this.gmode == 0) {
				boolean bool_40_ = false;
				int i_41_ = 0;
				if (this.nfmtab != (this.app).sgame.getSelectedIndex()) {
					this.nfmtab = (this.app).sgame.getSelectedIndex();
					(this.app).snfm1.select(0);
					(this.app).snfm2.select(0);
					(this.app).mstgs.select(0);
					this.app.requestFocus();
					bool_40_ = true;
				}
				if ((this.cd).staction == 5) {
					if (this.lfrom == 0) {
						(this.cd).staction = 0;
						this.removeds = 1;
						bool_40_ = true;
					} else {
						(this.cd).onstage = (checkpoints).name;
						(this.cd).staction = 2;
						this.dnload = 2;
					}
					this.nickname = (this.app).tnick.getText();
					this.backlog = this.nickname;
					this.nickey = (this.cd).tnickey;
					this.clan = (this.cd).tclan;
					this.clankey = (this.cd).tclankey;
					this.app.setloggedcookie();
					this.logged = true;
					this.gotlog = true;
					if ((this.cd).reco == 0) this.acexp = 0;
					if ((this.cd).reco > 10) this.acexp = (this.cd).reco - 10;
					if ((this.cd).reco == 3) this.acexp = -1;
					if ((this.cd).reco == 111) {
						if (!this.backlog.toLowerCase().equals(this.nickname.toLowerCase())) this.acexp = -3;
						else this.acexp = 0;
					}
				}
				if (this.nfmtab == 2 && (this.cd).staction == 0 && this.removeds == 1)
				(checkpoints).stage = -3;
				if ((this.app).openm && (this.cd).staction == 3) {
					(this.app).tnick.hide();
					(this.app).tpass.hide();
					(this.cd).staction = 0;
				}
				int i_42_ = 0;
				(this.app).sgame.setSize(131, 22);
				if ((this.app).sgame.getSelectedIndex() == 0) i_42_ = 400 - ((this.app)
					.sgame.getWidth() + 6 + (this.app)
					.snfm1.getWidth()) / 2;
				if ((this.app).sgame.getSelectedIndex() == 1) i_42_ = 400 - ((this.app)
					.sgame.getWidth() + 6 + (this.app)
					.snfm2.getWidth()) / 2;
				if ((this.app).sgame.getSelectedIndex() == 2) {
					(this.app).mstgs.setSize(338,
					22);
					if (bool_40_) {
						if (this.logged) {
							if ((this.cd).msloaded != 1) {
								(this.app)
									.mstgs.removeAll();
								(this.app)
									.mstgs.add(this.rd,
									"Loading your stages now, please wait...");
								(this.app)
									.mstgs.select(0);
								i_41_ = 1;
							}
						} else {
							(this.app).mstgs.removeAll();
							(this.app).mstgs.add(this.rd,
								"Please login first to load your stages...");
							(this.app).mstgs.select(0);
							(this.cd).msloaded = 0;
							this.lfrom = 0;
							(this.cd).staction = 3;
							this.showtf = false;
							this.tcnt = 0;
							this.cntflock = 0;
							(this.cd).reco = -2;
						}
					}
					i_42_ = 400 - ((this.app)
						.sgame.getWidth() + 6 + (this.app)
						.mstgs.getWidth()) / 2;
				}
				if ((this.app).sgame.getSelectedIndex() == 3) {
					(this.app).mstgs.setSize(338,
					22);
					if (bool_40_ && ((this.cd).msloaded != 3)) {
						(this.app).mstgs.removeAll();
						(this.app).mstgs.add(this.rd,
							"Loading Top20 list, please wait...");
						(this.app).mstgs.select(0);
						i_41_ = 3;
					}
					i_42_ = 400 - ((this.app)
						.sgame.getWidth() + 6 + (this.app)
						.mstgs.getWidth()) / 2;
				}
				if ((this.app).sgame.getSelectedIndex() == 4) {
					(this.app).mstgs.setSize(338,
					22);
					if (bool_40_ && ((this.cd).msloaded != 4)) {
						(this.app).mstgs.removeAll();
						(this.app).mstgs.add(this.rd,
							"Loading Top20 list, please wait...");
						(this.app).mstgs.select(0);
						i_41_ = 4;
					}
					i_42_ = 400 - ((this.app)
						.sgame.getWidth() + 6 + (this.app)
						.mstgs.getWidth()) / 2;
				}
				if ((this.app).sgame.getSelectedIndex() == 5) {
					if ((this.cd).staction != 0) {
						(this.app).tnick.hide();
						(this.app).tpass.hide();
						(this.cd).staction = 0;
					}
					(this.app).mstgs.setSize(338,
					22);
					if (bool_40_ && ((this.cd).msloaded != 2)) {
						(this.app).mstgs.removeAll();
						(this.app).mstgs.add(this.rd,
							"Loading Stage Maker stages, please wait...");
						(this.app).mstgs.select(0);
						i_41_ = 2;
					}
					i_42_ = 400 - ((this.app)
						.sgame.getWidth() + 6 + (this.app)
						.mstgs.getWidth()) / 2;
				}
				if (!(this.app).sgame.isShowing())
				(this.app).sgame.show();
				(this.app).sgame.move(i_42_, 62);
				i_42_ += (this.app).sgame.getWidth() + 6;
				if (this.nfmtab == 0) {
					if (!(this.app).snfm1.isShowing()) {
						(this.app).snfm1.show();
						if (!bool_40_ && (checkpoints).stage > 0)
						(this.app).snfm1.select((checkpoints).stage);
					}
					(this.app).snfm1.move(i_42_,
					62);
					if ((this.app).snfm2.isShowing())
					(this.app).snfm2.hide();
					if ((this.app).mstgs.isShowing())
					(this.app).mstgs.hide();
				}
				if (this.nfmtab == 1) {
					if (!(this.app).snfm2.isShowing()) {
						(this.app).snfm2.show();
						if (!bool_40_ && (checkpoints).stage > 10)
						(this.app).snfm2.select((checkpoints).stage - 10);
					}
					(this.app).snfm2.move(i_42_,
					62);
					if ((this.app).snfm1.isShowing())
					(this.app).snfm1.hide();
					if ((this.app).mstgs.isShowing())
					(this.app).mstgs.hide();
				}
				if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4 || this.nfmtab == 5) {
					if (!(this.app).mstgs.isShowing()) {
						(this.app).mstgs.show();
						if (!bool_40_)
						(this.app).mstgs.select((checkpoints).name);
					}
					(this.app).mstgs.move(i_42_,
					62);
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
						if ((checkpoints).top20 >= 3) string = new StringBuilder().append("N#").append((checkpoints).nto).append("  ").toString();
						if (this.aflk) {
							drawcs(132,
							new StringBuilder().append(string).append((checkpoints).name)
								.toString(),
							240, 240, 240, 3);
							this.aflk = false;
						} else {
							drawcs(132,
							new StringBuilder().append(string).append((checkpoints).name)
								.toString(),
							176, 176, 176, 3);
							this.aflk = true;
						}
						if ((checkpoints).stage == -2 && ((this.cd).staction == 0)) {
							this.rd.setFont(new Font("Arial", 1,
							11));
							this.ftm = this.rd.getFontMetrics();
							this.rd.setColor(new Color(255, 176,
							85));
							if ((checkpoints).maker.equals(this.nickname)) this.rd.drawString("Created by You", 70, 115);
							else this.rd.drawString(new StringBuilder().append("Created by :  ").append((checkpoints).maker)
								.append("").toString(),
							70, 115);
							if ((checkpoints).top20 >= 3) this.rd.drawString(new StringBuilder().append("Added by :  ").append((this.cd)
								.top20adds[((checkpoints).nto - 1)])
								.append(" Players").toString(),
							70, 135);
						}
					} else if (this.removeds != 1) {
						this.rd.setFont(new Font("Arial", 1,
						13));
						this.ftm = this.rd.getFontMetrics();
						drawcs(132, "Failed to load stage...", 255, 138, 0, 3);
						this.rd.setFont(new Font("Arial", 1,
						11));
						this.ftm = this.rd.getFontMetrics();
						if (this.nfmtab == 5) drawcs(155,
							"Please Test Drive this stage in the Stage Maker to make sure it can be loaded!",
						255, 138, 0, 3);
						if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4) drawcs(155,
							"It could be a connection error, please try again later.",
						255, 138, 0, 3);
						if (this.nfmtab == 1 || this.nfmtab == 0) {
							drawcs(155, "Will try to load another stage...",
							255, 138, 0, 3);
							this.app.repaint();
							try {
								Thread.sleep(5000L);
							} catch (InterruptedException interruptedexception) {
								/* empty */
							}
							if (this.nfmtab == 0)
							(this.app)
								.snfm1.select(1 + (int)(Math.random() * 10.0));
							if (this.nfmtab == 1)
							(this.app)
								.snfm2.select(1 + (int)(Math.random() * 17.0));
						}
					}
				}
				if ((this.cd).staction == 3) {
					drawdprom(145, 170);
					if ((this.cd).reco == -2) {
						if (this.lfrom == 0) drawcs(171,
							"Login to Retrieve your Account Stages", 0,
						0, 0, 3);
						else drawcs(171,
							"Login to add this stage to your account.",
						0, 0, 0, 3);
					}
					if ((this.cd).reco == -1) drawcs(171,
						"Unable to connect to server, try again later!",
					0, 8, 0, 3);
					if ((this.cd).reco == 1) drawcs(171,
						"Sorry.  The Nickname you have entered is incorrect.",
					0, 0, 0, 3);
					if ((this.cd).reco == 2) drawcs(171,
						"Sorry.  The Password you have entered is incorrect.",
					0, 0, 0, 3);
					if ((this.cd).reco == -167 || (this.cd).reco == -177) {
						if ((this.cd).reco == -167) {
							this.nickname = (this.app)
								.tnick.getText();
							this.backlog = this.nickname;
							(this.cd).reco = -177;
						}
						drawcs(171, "You are currently using a trial account.",
						0, 0, 0, 3);
					}
					if ((this.cd).reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20)) drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
					if ((this.cd).reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20)) drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
					if (!this.showtf) {
						(this.app).tnick.setBackground(new Color(206, 237, 255));
						if ((this.cd).reco != 1) {
							if ((this.cd).reco != 2)
							(this.app)
								.tnick.setText(this.nickname);
							(this.app).tnick.setForeground(new Color(0, 0, 0));
						} else(this.app).tnick.setForeground(new Color(255, 0, 0));
						(this.app).tnick.requestFocus();
						(this.app).tpass.setBackground(new Color(206, 237, 255));
						if ((this.cd).reco != 2) {
							if (!this.autolog)
							(this.app)
								.tpass.setText("");
							(this.app).tpass.setForeground(new Color(0, 0, 0));
						} else(this.app).tpass.setForeground(new Color(255, 0, 0));
						if (!(this.app).tnick.getText().equals("") && (this.cd).reco != 1)
						(this.app).tpass.requestFocus();
						this.showtf = true;
					}
					this.rd.drawString("Nickname:", (376 - this.ftm.stringWidth("Nickname:") - 14),
					201);
					this.rd.drawString("Password:", (376 - this.ftm.stringWidth("Password:") - 14),
					231);
					this.app.movefieldd((this.app).tnick, 376,
					185, 129, 23, true);
					this.app.movefieldd((this.app).tpass, 376,
					215, 129, 23, true);
					if (this.tcnt < 30) {
						this.tcnt++;
						if (this.tcnt == 30) {
							if ((this.cd).reco == 2)
							(this.app)
								.tpass.setText("");
							(this.app).tnick.setForeground(new Color(0, 0, 0));
							(this.app).tpass.setForeground(new Color(0, 0, 0));
						}
					}
					if ((this.cd).reco != -177) {
						if ((drawcarb(true, null, "       Login       ", 347,
						247, i, i_39_, bool) || (control).handb || (control).enter) && this.tcnt > 5) {
							this.tcnt = 0;
							if (!(this.app)
								.tnick.getText().equals("") && !(this.app)
								.tpass.getText().equals("")) {
								this.autolog = false;
								(this.app)
									.tnick.hide();
								(this.app)
									.tpass.hide();
								this.app.requestFocus();
								(this.cd).staction = 4;
								this.cd.sparkstageaction();
							} else {
								if ((this.app)
									.tpass.getText().equals(""))
								(this.cd).reco = -4;
								if ((this.app)
									.tnick.getText().equals(""))
								(this.cd).reco = -3;
							}
						}
					} else if (drawcarb(true, null,
						"  Upgrade to have your own stages!  ",
					277, 247, i, i_39_, bool) && this.cntflock == 0) {
						this.app.editlink(this.nickname, true);
						this.cntflock = 100;
					}
					if (drawcarb(true, null, "  Cancel  ", 409, 282, i, i_39_,
					bool)) {
						(this.app).tnick.hide();
						(this.app).tpass.hide();
						this.app.requestFocus();
						(this.cd).staction = 0;
					}
					if (drawcarb(true, null, "  Register!  ", 316, 282, i,
					i_39_, bool)) {
						if (this.cntflock == 0) {
							this.app.reglink();
							this.cntflock = 100;
						}
					} else if (this.cntflock != 0) this.cntflock--;
				}
				if ((this.cd).staction == 4) {
					drawdprom(145, 170);
					drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
				}
				if ((checkpoints).stage == -2 && (this.cd).msloaded == 1 && (checkpoints).top20 < 3 && !(this.app).openm && drawcarb(true, null, "X", 609, 113, i, i_39_, bool))
				(this.cd).staction = 6;
				if ((this.cd).staction == -1 && (checkpoints).top20 < 3) {
					this.removeds = 0;
					drawdprom(145, 95);
					drawcs(175,
						"Failed to remove stage from your account, try again later.",
					0, 0, 0, 3);
					if (drawcarb(true, null, " OK ", 379, 195, i, i_39_, bool))
					(this.cd).staction = 0;
				}
				if ((this.cd).staction == 1) {
					drawdprom(145, 95);
					drawcs(195, "Removing stage from your account...", 0, 0, 0,
					3);
					this.removeds = 1;
				}
				if ((this.cd).staction == 6) {
					drawdprom(145, 95);
					drawcs(175, "Remove this stage from your account?", 0, 0,
					0, 3);
					if (drawcarb(true, null, " Yes ", 354, 195, i, i_39_,
					bool)) {
						(this.cd).onstage = (this.app).mstgs.getSelectedItem();
						(this.cd).staction = 1;
						this.cd.sparkstageaction();
					}
					if (drawcarb(true, null, " No ", 408, 195, i, i_39_, bool))
					(this.cd).staction = 0;
				}
				if (i_41_ == 1) {
					this.app.drawms();
					this.app.repaint();
					this.cd.loadmystages(checkpoints);
				}
				if (i_41_ >= 3) {
					this.app.drawms();
					this.app.repaint();
					this.cd.loadtop20(i_41_);
				}
				if (i_41_ == 2) {
					this.app.drawms();
					this.app.repaint();
					this.cd.loadstagemaker();
				}
				if ((checkpoints).stage != -3 && (this.cd).staction == 0 && (checkpoints).top20 < 3) this.rd.drawImage((this.contin[(this.pcontin)]),
				355, 360, null);
				else this.pcontin = 0;
				if ((checkpoints).top20 >= 3 && (this.cd).staction != 3 && (this.cd).staction != 4) {
					this.rd.setFont(new Font("Arial", 1, 11));
					this.ftm = this.rd.getFontMetrics();
					if (this.dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 355,
					i, i_39_, bool)) {
						if (this.logged) {
							(this.cd).onstage = (checkpoints).name;
							(this.cd).staction = 2;
							this.cd.sparkstageaction();
							this.dnload = 2;
						} else {
							this.lfrom = 1;
							(this.cd).staction = 3;
							this.showtf = false;
							this.tcnt = 0;
							this.cntflock = 0;
							(this.cd).reco = -2;
						}
					}
					if (this.dnload == 2) {
						drawcs(370, "Adding stage please wait...", 193, 106, 0,
						3);
						if ((this.cd).staction == 0) this.dnload = 3;
						if ((this.cd).staction == -2) this.dnload = 4;
						if ((this.cd).staction == -3) this.dnload = 5;
						if ((this.cd).staction == -1) this.dnload = 6;
						if (this.dnload != 2)
						(this.cd).staction = 0;
					}
					if (this.dnload == 3) drawcs(370,
						"Stage has been successfully added to your stages!",
					193, 106, 0, 3);
					if (this.dnload == 4) drawcs(370, "You already have this stage!", 193, 106,
					0, 3);
					if (this.dnload == 5) drawcs(370,
						"Cannot add more then 20 stages to your account!",
					193, 106, 0, 3);
					if (this.dnload == 6) drawcs(370,
						"Failed to add stage, unknown error, please try again later.",
					193, 106, 0, 3);
				}
				if (this.testdrive == 0 && (checkpoints).top20 < 3) {
					if (!(this.app).gmode.isShowing()) {
						(this.app).gmode.select(0);
						(this.app).gmode.show();
					}
					(this.app).gmode.move(400 - (this.app)
						.gmode.getWidth() / 2,
					395);
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
				if (this.nfmtab == 0 && ((this.app).snfm1.getSelectedIndex() != (checkpoints).stage) && (this.app).snfm1.getSelectedIndex() != 0) {
					(checkpoints).stage = (this.app).snfm1.getSelectedIndex();
					(checkpoints).top20 = 0;
					(checkpoints).nto = 0;
					hidos();
					this.fase = 2;
					this.app.requestFocus();
				}
				if (this.nfmtab == 1 && ((this.app).snfm2.getSelectedIndex() != (checkpoints).stage - 10) && (this.app).snfm2.getSelectedIndex() != 0) {
					(checkpoints).stage = (this.app).snfm2.getSelectedIndex() + 10;
					(checkpoints).top20 = 0;
					(checkpoints).nto = 0;
					hidos();
					this.fase = 2;
					this.app.requestFocus();
				}
				if ((this.nfmtab == 2 || this.nfmtab == 5) && !(this.app).mstgs.getSelectedItem().equals((checkpoints).name) && (this.app).mstgs.getSelectedIndex() != 0) {
					if (this.nfmtab == 2)
					(checkpoints).stage = -2;
					else(checkpoints).stage = -1;
					(checkpoints).name = (this.app).mstgs.getSelectedItem();
					(checkpoints).top20 = 0;
					(checkpoints).nto = 0;
					hidos();
					this.fase = 2;
					this.app.requestFocus();
				}
				if (this.nfmtab == 3 || this.nfmtab == 4) {
					String string = "";
					int i_43_ = ((this.app)
						.mstgs.getSelectedItem().indexOf(" ") + 1);
					if (i_43_ > 0) string = (this.app)
						.mstgs.getSelectedItem().substring(i_43_);
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
					int i_44_ = (checkpoints).stage;
					if (i_44_ > 10) i_44_ -= 10;
					drawcs(80, new StringBuilder().append("Stage ").append(i_44_).append("  >").toString(), 255, 128, 0, 3);
				} else drawcs(80, "Final Party Stage  >", 255, 128, 0, 3);
				if (this.aflk) {
					drawcs(100, new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(), 240, 240, 240, 3);
					this.aflk = false;
				} else {
					drawcs(100, new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(), 176, 176, 176, 3);
					this.aflk = true;
				}
				if ((checkpoints).stage != -3) this.rd.drawImage((this.contin[(this.pcontin)]),
				355, 360, null);
				else this.pcontin = 0;
			}
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
						if (this.gmode == 0 || (this.gmode == 1 && ((checkpoints).stage != this.unlocked[0])) || (this.gmode == 2 && ((checkpoints).stage != this.unlocked[1] + 10)) || (checkpoints).stage == 27) {
							if ((checkpoints).stage != 27) {
								hidos();
								(checkpoints).stage++;
								if (this.gmode == 1 && (checkpoints).stage == 11)
								(checkpoints).stage = 27;
								if ((checkpoints).stage > 10) {
									(this.app)
										.sgame.select(1);
									this.nfmtab = 1;
								} else {
									(this.app)
										.sgame.select(0);
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
				drawcs(132, (checkpoints).name, 240, 240, 240,
				3);
				this.aflk = false;
			} else {
				drawcs(132, (checkpoints).name, 176, 176, 176,
				3);
				this.aflk = true;
			}
			this.rd.drawImage((this.contin[this.pcontin]),
			355, 360, null);
			if ((control).handb || (control).enter) {
				this.dudo = 150;
				this.fase = 5;
				(control).handb = false;
				(control).enter = false;
				this.intertrack.stop();
				this.intertrack.unloadimod();
			}
		}
		if (drawcarb(true, null, " Exit X ", 670, 30, i, i_39_, bool)) {
			this.fase = 102;
			if (this.gmode == 0) this.opselect = 3;
			if (this.gmode == 1) this.opselect = 0;
			if (this.gmode == 2) this.opselect = 1;
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
		int[] is = {
			(this.m).snap[0], (this.m).snap[1], (this.m).snap[2]
		};
		while (is[0] + is[1] + is[2] < -30) {
			for (int i_45_ = 0; i_45_ < 3; i_45_++) {
				if (is[i_45_] < 50) is[i_45_]++;
			}
		}
		int i_46_ = (int)(230.0F - 230.0F * ((float) is[0] / 100.0F));
		if (i_46_ > 255) i_46_ = 255;
		if (i_46_ < 0) i_46_ = 0;
		int i_47_ = (int)(230.0F - 230.0F * ((float) is[1] / 100.0F));
		if (i_47_ > 255) i_47_ = 255;
		if (i_47_ < 0) i_47_ = 0;
		int i_48_ = (int)(230.0F - 230.0F * ((float) is[2] / 100.0F));
		if (i_48_ > 255) i_48_ = 255;
		if (i_48_ < 0) i_48_ = 0;
		this.rd.setColor(new Color(i_46_, i_47_, i_48_));
		this.rd.fillRect(65, 25, 670, 400);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.3F));
		this.rd.drawImage(this.bggo, 0, -25,
		null);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(0, 0, 65, 450);
		this.rd.fillRect(735, 0, 65, 450);
		this.rd.fillRect(65, 0, 670, 25);
		this.rd.fillRect(65, 425, 670, 25);
		this.rd.setFont(new Font("Arial", 1, 13));
		this.ftm = this.rd.getFontMetrics();
		drawcs(50, this.asay, 0, 0, 0, 3);
		int i_49_ = -90;
		if (this.multion == 0) {
			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 10) i_49_ = 0;
			if (i == 11 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20 || i == 22 || i == 23 || i == 26) i_49_ = 0;
			if (i < 0 && this.nplayers != 1 && this.newparts) i_49_ = 0;
		} else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 3 || this.ransay == 4 || i == 10) i_49_ = 0;
		if (i_49_ == 0) {
			if (this.dudo > 0) {
				if (this.aflk) {
					if (Math.random() > Math.random()) this.duds = (int)(Math.random() * 3.0);
					else this.duds = (int)(Math.random() * 2.0);
					this.aflk = false;
				} else this.aflk = true;
				this.dudo--;
			} else this.duds = 0;
			this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
			this.rd.drawImage((this.dude[this.duds]),
			95, 35, null);
			this.rd.setComposite(AlphaComposite.getInstance(3, 0.7F));
			this.rd.drawImage(this.flaot, 192,
			67, null);
			this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
			i_46_ = (int)(80.0F - 80.0F * ((float) is[0] / 100.0F));
			if (i_46_ > 255) i_46_ = 255;
			if (i_46_ < 0) i_46_ = 0;
			i_47_ = (int)(80.0F - 80.0F * ((float) is[1] / 100.0F));
			if (i_47_ > 255) i_47_ = 255;
			if (i_47_ < 0) i_47_ = 0;
			i_48_ = (int)(80.0F - 80.0F * ((float) is[2] / 100.0F));
			if (i_48_ > 255) i_48_ = 255;
			if (i_48_ < 0) i_48_ = 0;
			this.rd.setColor(new Color(i_46_, i_47_, i_48_));
			this.rd.setFont(new Font("Arial", 1, 13));
			if (this.multion != 0) {
				if (this.ransay == 1 && i != 10) this.rd.drawString("Multiplayer Tip:  Press [ C ] to access chat quickly during the game!",
				262, 92);
				if (this.ransay == 2 && i != 10) {
					this.rd.drawString("Multiplayer Tip:  Press [ A ] to make Guidance Arrow point to cars and",
					262, 92);
					this.rd.drawString("click any of the players listed on the right to lock the Arrow on!",
					262, 112);
				}
				if (this.ransay == 3 && i != 10) {
					this.rd.drawString("Multiplayer Tip:  When wasting in multiplayer it's better to aim slightly",
					262, 92);
					this.rd.drawString("ahead of the other player's car to compensate for internet delay.",
					262, 112);
				}
				if (this.ransay == 4) {
					this.rd.drawString("When watching a game, click any player listed on the right of the",
					262, 92);
					this.rd.drawString("screen to follow and watch.", 262, 112);
					this.rd.drawString("Press [ V ] to change the viewing mode!", 262, 132);
				}
				if (i == 10 && this.ransay != 4) {
					if (this.tflk) {
						this.rd.setColor(new Color(200, i_47_,
						i_48_));
						this.tflk = false;
					} else this.tflk = true;
					this.rd.drawString("NOTE: Guidance Arrow and opponent status is disabled in this stage!",
					262, 92);
				}
			} else {
				if (i < 0 && this.nplayers != 1 && this.newparts) {
					this.rd.drawString("Please note, the computer car's AI has not yet been trained to handle",
					262, 92);
					this.rd.drawString("some of the new stage parts such as the 'Rollercoaster Road' and the",
					262, 112);
					this.rd.drawString("'Tunnel Side Ramp'.",
					262, 132);
					this.rd.drawString("(Those new parts where mostly designed for the multiplayer game.)",
					262, 152);
					this.rd.drawString("The AI will be trained and ready in the future releases of the game!",
					262, 172);
				}
				if (i == 1 || i == 11) {
					this.rd.drawString("Hey!  Don't forget, to complete a lap you must pass through",
					262, 92);
					this.rd.drawString("all checkpoints in the track!", 262, 112);
				}
				if (i == 2 || i == 12) this.rd.drawString("Remember, the more power you have the faster your car will be!",
				262, 92);
				if (i == 3) {
					this.rd.drawString("> Hint: its easier to waste the other cars then to race in this stage!",
					262, 92);
					this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to",
					262, 112);
					this.rd.drawString("the track.", 262, 132);
				}
				if (i == 4) this.rd.drawString("Remember, the better the stunt you perform the more power you get!",
				262, 92);
				if (i == 5) this.rd.drawString("Remember, the more power you have the stronger your car is!",
				262, 92);
				if (i == 10) {
					if (this.tflk) {
						this.rd.setColor(new Color(200, i_47_,
						i_48_));
						this.tflk = false;
					} else this.tflk = true;
					this.rd.drawString("NOTE: Guidance Arrow is disabled in this stage!",
					262, 92);
				}
				if (i == 13) {
					this.rd.drawString("Watch out!  Look out!  The policeman might be out to get you!",
					262, 92);
					this.rd.drawString("Don't upset him or you'll be arrested!", 262, 112);
					this.rd.drawString("Better run, run, run.",
					262, 152);
				}
				if (i == 14) {
					this.rd.drawString("Don't waste your time.  Waste them instead!", 262,
					92);
					this.rd.drawString("Try a taste of sweet revenge here (if you can)!",
					262, 112);
					this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to",
					262, 152);
					this.rd.drawString("the track.", 262, 172);
				}
				if (i == 17) {
					this.rd.drawString("Welcome to the realm of the king...", 262, 92);
					this.rd.drawString("The key word here is 'POWER'.  The more you have of it the faster",
					262, 132);
					this.rd.drawString("and STRONGER you car will be!", 262, 152);
				}
				if (i == 18) {
					this.rd.drawString("Watch out, EL KING is out to get you now!", 262, 92);
					this.rd.drawString("He seems to be seeking revenge?", 262, 112);
					this.rd.drawString("(To fly longer distances in the air try drifting your car on the ramp",
					262, 152);
					this.rd.drawString("before take off).", 262,
					172);
				}
				if (i == 19) this.rd.drawString("It\u2019s good to be the king!", 262, 92);
				if (i == 20) {
					this.rd.drawString("Remember, forward loops give your car a push forwards in the air",
					262, 92);
					this.rd.drawString("and help in racing.",
					262, 112);
					this.rd.drawString("(You may need to do more forward loops here.  Also try keeping",
					262, 152);
					this.rd.drawString("your power at maximum at all times.  Try not to miss a ramp).",
					262, 172);
				}
				if (i == 22) {
					this.rd.drawString("Watch out!  Beware!  Take care!", 262, 92);
					this.rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!",
					262, 112);
				}
				if (i == 23) {
					this.rd.drawString("Anyone for a game of Digger?!", 262, 92);
					this.rd.drawString("You can have fun using MASHEEN here!", 262, 112);
				}
				if (i == 26) {
					this.rd.drawString("This is it!  This is the toughest stage in the game!",
					262, 92);
					this.rd.drawString("This track is actually a 4D object projected onto the 3D world.",
					262, 132);
					this.rd.drawString("It's been broken down, separated and, in many ways, it is also a",
					262, 152);
					this.rd.drawString("maze!  GOOD LUCK!", 262,
					172);
				}
			}
		}
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.8F));
		this.rd.drawImage(this.loadingmusic, 289,
		205 + i_49_, null);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
		this.rd.setFont(new Font("Arial", 1, 11));
		this.ftm = this.rd.getFontMetrics();
		int i_50_ = i - 1;
		if (i_50_ < 0) i_50_ = 32;
		if (!bool) {
			drawcs(340 + i_49_, new StringBuilder().append("").append(this.sndsize[i_50_]).append(" KB").toString(), 0, 0, 0, 3);
			drawcs(375 + i_49_, " Please Wait...", 0, 0, 0, 3);
		} else {
			drawcs(365 + i_49_, "Loading complete!  Press Start to begin...",
			0, 0, 0, 3);
			this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
			this.rd.drawImage((this.star[this.pstar]),
			359, 385 + i_49_, null);
			this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
			if (this.pstar != 2) {
				if (this.pstar == 0) this.pstar = 1;
				else this.pstar = 0;
			}
			if (this.multion != 0) drawcs(380 + i_49_,
			new StringBuilder().append("").append(this.forstart / 20).toString(),
			0, 0, 0, 3);
		}
	}

	public void loadmusic(int i, String string, int i_51_) {
		hipnoload(i, false);
		this.app.setCursor(new Cursor(3));
		this.app.repaint();
		boolean bool = false;
		if (this.multion == 0) {
			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 10) bool = true;
			if (i == 11 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20 || i == 22 || i == 23 || i == 26) bool = true;
			if (i < 0 && this.nplayers != 1 && this.newparts) bool = true;
		} else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 3 || this.ransay == 4 || i == 10) bool = true;
		if (bool) {
			this.runtyp = i;
			this.runner = new Thread(this);
			this.runner.start();
		}
		loadstrack(i, string, i_51_);
		if (bool) {
			this.runner.stop();
			this.runner = null;
			this.runtyp = 0;
		}
		System.gc();
		if (this.multion == 0 && (this.app).applejava) {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException interruptedexception) {
				/* empty */
			}
		}
		if (!this.lan) this.strack.play();
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

	public void loadstrack(int i, String string, int i_52_) {
		if (i == 1) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		240, 8400, 135, false, false);
		if (i == 2) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		190, 9000, 145, false, false);
		if (i == 3) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		170, 8500, 145, false, false);
		if (i == 4) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		205, 7500, 125, false, false);
		if (i == 5) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		170, 7900, 125, false, false);
		if (i == 6) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		370, 7900, 125, false, false);
		if (i == 7) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		205, 7500, 125, false, false);
		if (i == 8) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		230, 7900, 125, false, false);
		if (i == 9) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		180, 7900, 125, false, false);
		if (i == 10) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		280, 8100, 145, false, false);
		if (i == 11) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		120, 8000, 125, false, false);
		if (i == 12) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		260, 7200, 125, false, false);
		if (i == 13) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		270, 8000, 125, false, false);
		if (i == 14) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		190, 8000, 125, false, false);
		if (i == 15) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		162, 7800, 125, false, false);
		if (i == 16) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		220, 7600, 125, false, false);
		if (i == 17) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		300, 7500, 125, false, false);
		if (i == 18) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		200, 7900, 125, false, false);
		if (i == 19) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		200, 7900, 125, false, false);
		if (i == 20) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		232, 7300, 125, false, false);
		if (i == 21) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		370, 7900, 125, false, false);
		if (i == 22) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		290, 7900, 125, false, false);
		if (i == 23) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		222, 7600, 125, false, false);
		if (i == 24) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		230, 8000, 125, false, false);
		if (i == 25) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		220, 8000, 125, false, false);
		if (i == 26) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		261, 8000, 125, false, false);
		if (i == 27) {
			if (this.gmode == 2) this.strack = new RadicalMod("music/party.zip", 400, 7600, 125, false,
			false);
			else this.strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(),
			276, 8800, 145, false, false);
		}
		if (i == 28) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		182, 8000, 125, false, false);
		if (i == 29) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		220, 8000, 125, false, false);
		if (i == 30) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		200, 8000, 125, false, false);
		if (i == 31) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		350, 7900, 125, false, false);
		if (i == 32) this.strack = new RadicalMod(new StringBuilder().append("music/stage")
			.append(i).append(".zip").toString(),
		310, 8000, 125, false, false);
		if (i < 0) {
			if (!string.equals("")) {
				if (i != -2) this.strack = new RadicalMod(new StringBuilder().append("mystages/mymusic/").append(string).append(".zip").toString(),
				i_52_, 8000, 125, false, false);
				else this.strack = new RadicalMod(string, i_52_, 8000, 125, false,
				true);
			} else this.strack = new RadicalMod();
		}
		this.loadedt = true;
	}

	public void musicomp(int i, Control control) {
		hipnoload(i, true);
		if (this.multion != 0) {
			this.forstart--;
			if (this.lan && this.im == 0) this.forstart = 0;
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
			this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
			RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
			this.rd.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_OFF));
			if (this.multion == 0) this.fase = 0;
			else {
				this.fase = 7001;
				this.forstart = 0;
				if (!this.lan) {
					try {
						this.socket = new Socket(this.server,
						this.servport);
						this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
						this.dout = new PrintWriter(this.socket.getOutputStream(),
						true);
						this.runtyp = -101;
						this.runner = new Thread(this);
						this.runner.start();
					} catch (Exception exception) {
						/* empty */
					}
				}
			}
			if (Math.random() > Math.random()) this.dudo = 250;
			else this.dudo = 428;
			(control).handb = false;
			(control).enter = false;
		}
	}

	public void waitenter() {
		if (this.forstart < 690) {
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			drawcs(70, "Waiting for all players to finish loading!", 0, 0, 0,
			0);
			if (this.forstart <= 640) drawcs(90,
			new StringBuilder().append("").append((640 - this.forstart) / 32).append("").toString(),
			0, 0, 0, 0);
			else drawcs(90, "Your connection to game may have been lost...", 0,
			0, 0, 0);
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

	public void multistat(Control control, CheckPoints checkpoints, int i,
	int i_53_, boolean bool, UDPMistro udpmistro) {
		int i_54_ = -1;
		if (this.fase != -2) {
			if (this.exitm != 0 && !this.holdit) {
				if (!this.lan || this.im != 0) {
					if (bool) {
						if (i > 357 && i < 396 && i_53_ > 162 && i_53_ < 179) {
							this.exitm = 2;
							if (this.multion == 1 && !this.lan && this.sendstat == 0) {
								this.sendstat = 1;
								if (this.runtyp != -101) {
									if (this.runner != null) this.runner.stop();
									this.runner = new Thread(this);
									this.runner.start();
								}
							}
						} else this.exitm = 0;
					}
					float[] fs = new float[3];
					Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2],
					fs);
					fs[1] -= 0.15;
					if (fs[1] < 0.0F) fs[1] = 0.0F;
					fs[2] += 0.15;
					if (fs[2] > 1.0F) fs[2] = 1.0F;
					this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
					this.rd.fillRect(357, 169, 39, 10);
					this.rd.fillRect(403, 169, 39, 10);
					fs[1] -= 0.07;
					if (fs[1] < 0.0F) fs[1] = 0.0F;
					fs[2] += 0.07;
					if (fs[2] > 1.0F) fs[2] = 1.0F;
					this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
					this.rd.fillRect(357, 162, 39, 7);
					this.rd.fillRect(403, 162, 39, 7);
					drawhi(this.exitgame, 116);
					if (i > 357 && i < 396 && i_53_ > 162 && i_53_ < 179) {
						this.rd.setColor(new Color(((this.m).csky[0]), ((this.m).csky[1]), ((this.m).csky[2])));
						this.rd.fillRect(357, 162, 39, 17);
					}
					if (i > 403 && i < 442 && i_53_ > 162 && i_53_ < 179) {
						this.rd.setColor(new Color(((this.m).csky[0]), ((this.m).csky[1]), ((this.m).csky[2])));
						this.rd.fillRect(403, 162, 39, 17);
					}
					this.rd.setColor(new Color(0, 0, 0));
					this.rd.drawString("Yes", 366, 175);
					this.rd.drawString("No", 416, 175);
					this.rd.setColor(new Color(((this.m).csky[0] / 2), ((this.m).csky[1] / 2), ((this.m).csky[2] / 2)));
					this.rd.drawRect(403, 162, 39, 17);
					this.rd.drawRect(357, 162, 39, 17);
				} else {
					this.rd.setFont(new Font("Arial", 1, 13));
					this.ftm = this.rd.getFontMetrics();
					drawcs(125,
						"You cannot exit game.  Your computer is the LAN server!",
					0, 0, 0, 0);
					this.msgflk[0]++;
					if (this.msgflk[0] == 67 || bool) {
						this.msgflk[0] = 0;
						this.exitm = 0;
					}
					this.rd.setFont(new Font("Arial", 1, 11));
					this.ftm = this.rd.getFontMetrics();
				}
			} else if (this.exitm == 4) {
				if (bool) {
					if (i > 357 && i < 396 && i_53_ > 362 && i_53_ < 379) {
						this.alocked = -1;
						this.lalocked = -1;
						this.multion = 2;
						(control).multion = this.multion;
						this.holdit = false;
						this.exitm = 0;
						(control).chatup = 0;
					}
					if ((!this.lan || this.im != 0) && i > 403 && i < 442 && i_53_ > 362 && i_53_ < 379) {
						this.holdcnt = 600;
						this.exitm = 0;
						(control).chatup = 0;
					}
				}
				float[] fs = new float[3];
				Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2], fs);
				fs[1] -= 0.15;
				if (fs[1] < 0.0F) fs[1] = 0.0F;
				fs[2] += 0.15;
				if (fs[2] > 1.0F) fs[2] = 1.0F;
				this.rd.setColor(Color.getHSBColor(fs[0], fs[1],
				fs[2]));
				this.rd.fillRect(357, 369, 39, 10);
				if (!this.lan || this.im != 0) this.rd.fillRect(403, 369, 39, 10);
				fs[1] -= 0.07;
				if (fs[1] < 0.0F) fs[1] = 0.0F;
				fs[2] += 0.07;
				if (fs[2] > 1.0F) fs[2] = 1.0F;
				this.rd.setColor(Color.getHSBColor(fs[0], fs[1],
				fs[2]));
				this.rd.fillRect(357, 362, 39, 7);
				if (!this.lan || this.im != 0) this.rd.fillRect(403, 362, 39, 7);
				this.rd.setColor(new Color(0, 0, 0));
				this.rd.setFont(new Font("Arial", 1, 13));
				this.ftm = this.rd.getFontMetrics();
				if (this.lan && this.im == 0) drawcs(140,
					"(You cannot exit game.  Your computer is the LAN server... )",
				0, 0, 0, 0);
				this.rd.drawString("Continue watching this game?", 155, 375);
				if (i > 357 && i < 396 && i_53_ > 362 && i_53_ < 379) {
					this.rd.setColor(new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]));
					this.rd.fillRect(357, 362, 39, 17);
				}
				if ((!this.lan || this.im != 0) && i > 403 && i < 442 && i_53_ > 362 && i_53_ < 379) {
					this.rd.setColor(new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]));
					this.rd.fillRect(403, 362, 39, 17);
				}
				this.rd.setFont(new Font("Arial", 1, 11));
				this.ftm = this.rd.getFontMetrics();
				this.rd.setColor(new Color(0, 0, 0));
				this.rd.drawString("Yes", 366, 375);
				if (!this.lan || this.im != 0) this.rd.drawString("No", 416, 375);
				this.rd.setColor(new Color((this.m).csky[0] / 2, (this.m).csky[1] / 2, (this.m).csky[2] / 2));
				if (!this.lan || this.im != 0) this.rd.drawRoundRect(147, 357, 301, 27, 7,
				20);
				else this.rd.drawRoundRect(147, 357, 262, 27, 7,
				20);
				this.rd.drawRect(357, 362, 39, 17);
				if (!this.lan || this.im != 0) this.rd.drawRect(403, 362, 39, 17);
			}
			if (this.runtyp == -101 && !this.lan) {
				if (this.warning == 0 || this.warning == 210) {
					int i_55_ = 0;
					int i_56_ = 0;
					if (this.clanchat) {
						i_55_ = 1;
						i_56_ = -23;
					} else if ((control).chatup == 2)
					(control).chatup = 1;
					for (int i_57_ = i_55_; i_57_ >= 0; i_57_--) {
						boolean bool_58_ = false;
						if (i > 5 && i < 33 && i_53_ > 423 + i_56_ && i_53_ < 446 + i_56_) {
							bool_58_ = true;
							if ((control).chatup != 0)
							(control).chatup = 0;
						} else if (this.pointc[i_57_] != 6) {
							this.pointc[i_57_] = 6;
							this.floater[i_57_] = 1;
						}
						if (i > 33 && i < 666 && i_53_ > 423 + i_56_ && i_53_ < 446 + i_56_ && this.lxm != i && i_53_ != this.lym && this.lxm != -100) {
							(control).chatup = i_57_ + 1;
							this.cntchatp[i_57_] = 0;
						}
						if (i_57_ == 0) {
							this.lxm = i;
							this.lym = i_53_;
						}
						if (this.exitm != 0 && this.exitm != 4)
						(control).chatup = 0;
						boolean bool_59_ = false;
						if ((control).enter && (control).chatup == i_57_ + 1) {
							bool_59_ = true;
							(control).chatup = 0;
							(control).enter = false;
							this.lxm = -100;
						}
						if (bool) {
							if (this.mouson == 0) {
								if (i > 676 && i < 785 && i_53_ > 426 + i_56_ && i_53_ < 443 + i_56_ && ((control).chatup == i_57_ + 1)) {
									bool_59_ = true;
									(control).chatup = 0;
								}
								if (bool_58_ && this.pointc[i_57_] > 0) {
									this.pointc[i_57_]--;
									this.floater[i_57_] = 1;
								}
								if (i_57_ == 0) this.mouson = 1;
							}
							if (i_57_ == 0)
							(control).chatup = 0;
						} else if (i_57_ == 0 && this.mouson != 0) this.mouson = 0;
						if (bool_59_) {
							String string = "";
							int i_60_ = 0;
							int i_61_ = 1;
							for ( /**/ ;
							(i_60_ < this.lcmsg[i_57_].length());
							i_60_++) {
								String string_62_ = new StringBuilder().append("").append(this.lcmsg[i_57_].charAt(i_60_))
									.toString();
								if (string_62_.equals(" ")) i_61_++;
								else i_61_ = 0;
								if (i_61_ < 2) string = new StringBuilder().append(string).append(string_62_).toString();
							}
							if (!string.equals("")) {
								string = string.replace('|', ':');
								if ((string.toLowerCase().indexOf((this.app)
									.tpass.getText().toLowerCase())) != -1) string = " ";
								if (!msgcheck(string) && (this.updatec[i_57_] > -12)) {
									if (this.cnames[i_57_]
									[6].equals("Game Chat  ") || (this.cnames[i_57_][6].equals(new StringBuilder().append("")
										.append(this.clan)
										.append("'s Chat  ").toString()))) this.cnames[i_57_][6] = "";
									for (int i_63_ = 0; i_63_ < 6; i_63_++) {
										this.sentn[i_57_][i_63_] = (this.sentn[i_57_]
										[i_63_ + 1]);
										this.cnames[i_57_]
										[i_63_] = (this.cnames[i_57_][i_63_ + 1]);
									}
									this.sentn[i_57_][6] = string;
									this.cnames[i_57_][6] = this.nickname;
									if (this.pointc[i_57_] != 6) {
										this.pointc[i_57_] = 6;
										this.floater[i_57_] = 1;
									}
									this.msgflk[i_57_] = 110;
									if (this.updatec[i_57_] > -11) this.updatec[i_57_] = -11;
									else this.updatec[i_57_]--;
								} else this.warning++;
							}
						}
						if (bool_58_ || this.floater[i_57_] != 0 || (control).chatup == i_57_ + 1 || this.msgflk[i_57_] != 0) {
							float[] fs = new float[3];
							Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2],
							fs);
							fs[1] -= 0.15;
							if (fs[1] < 0.0F) fs[1] = 0.0F;
							fs[2] += 0.15;
							if (fs[2] > 1.0F) fs[2] = 1.0F;
							this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
							this.rd.fillRect(33, 423 + i_56_,
							761, 23);
						}
						if ((control).chatup == 0 && (this.app).cmsg.isShowing()) {
							(this.app).cmsg.hide();
							this.app.requestFocus();
						}
						if ((control).chatup != i_57_ + 1) {
							int i_64_ = 0;
							int i_65_ = (int)(48.0F + (48.0F * ((float)((
							this.m)
								.snap[1]) / 100.0F)));
							if (i_65_ > 255) i_65_ = 255;
							if (i_65_ < 0) i_65_ = 0;
							int i_66_ = (int)(96.0F + (96.0F * ((float)((
							this.m)
								.snap[2]) / 100.0F)));
							if (i_66_ > 255) i_66_ = 255;
							if (i_66_ < 0) i_66_ = 0;
							if (this.floater[i_57_] != 0) {
								for (int i_67_ = 6; i_67_ >= 0; i_67_--) {
									if (this.pointc[i_57_] == i_67_) {
										if (Math.abs(i_64_ + (this.movepos[i_57_])) > 10) {
											this.floater[i_57_] = ((this.movepos[i_57_]) + i_64_) / 4;
											if ((this.floater[i_57_]) > -5 && (this.floater[i_57_]) < 0) this.floater[i_57_] = -5;
											if ((this.floater[i_57_]) < 10 && (this.floater[i_57_]) > 0) this.floater[i_57_] = 10;
											this.movepos[i_57_] -= (this.floater[i_57_]);
										} else {
											this.movepos[i_57_] = -i_64_;
											this.floater[i_57_] = 0;
										}
									}
									if (this.pointc[i_57_] >= i_67_) {
										this.rd.setColor(new Color(0, i_65_, i_66_));
										this.rd.setFont(new Font("Tahoma", 1, 11));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString(new StringBuilder().append(this.cnames[i_57_][i_67_])
											.append(": ").toString(),
										39 + i_64_ + (this.movepos[i_57_]),
										439 + i_56_);
										i_64_ += (this.ftm.stringWidth(new StringBuilder().append(this.cnames[i_57_][i_67_])
											.append(": ").toString()));
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Tahoma", 0, 11));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString(new StringBuilder().append(this.sentn[i_57_][i_67_])
											.append("   ").toString(),
										39 + i_64_ + (this.movepos[i_57_]),
										439 + i_56_);
										i_64_ += (this.ftm.stringWidth(new StringBuilder().append(this.sentn[i_57_][i_67_])
											.append("   ").toString()));
									} else {
										i_64_ += (this.ftm.stringWidth(new StringBuilder().append(this.cnames[i_57_][i_67_])
											.append(": ").toString()));
										i_64_ += (this.ftm.stringWidth(new StringBuilder().append(this.sentn[i_57_][i_67_])
											.append("   ").toString()));
									}
								}
								this.rd.setColor(new Color(0, 0,
								0));
								this.rd.fillRect(0, 423 + i_56_,
								5, 24);
								this.rd.fillRect(794, 423 + i_56_, 6, 24);
							} else {
								for (int i_68_ = this.pointc[i_57_];
								i_68_ >= 0; i_68_--) {
									if (i_68_ == 6 && (this.msgflk[i_57_] != 0)) this.msgflk[i_57_]--;
									this.rd.setColor(new Color(0, i_65_, i_66_));
									this.rd.setFont(new Font("Tahoma", 1, 11));
									this.ftm = this.rd.getFontMetrics();
									if ((this.ftm.stringWidth(new StringBuilder().append(this.cnames[i_57_][i_68_])
										.append(": ").toString())) + 39 + i_64_ < 775) {
										if (i_68_ != 6 || (this.msgflk[i_57_]) < 67 || (this.msgflk[i_57_]) % 3 != 0) this.rd.drawString(new StringBuilder().append(this.cnames[i_57_][i_68_])
											.append(": ").toString(),
										39 + i_64_, 439 + i_56_);
										i_64_ += (this.ftm.stringWidth(new StringBuilder().append(this.cnames[i_57_][i_68_])
											.append(": ").toString()));
									} else {
										String string = "";
										for (int i_69_ = 0;
										((this.ftm.stringWidth(string) + 39 + i_64_) < 775 && i_69_ < this.cnames[i_57_]
										[i_68_].length());
										i_69_++)
										string = new StringBuilder().append(string).append(this.cnames[i_57_]
										[i_68_].charAt(i_69_))
											.toString();
										string = new StringBuilder().append(string).append("...").toString();
										if (i_68_ != 6 || (this.msgflk[i_57_]) < 67 || (this.msgflk[i_57_]) % 3 != 0) this.rd.drawString(string, 39 + i_64_,
										439 + i_56_);
										break;
									}
									this.rd.setColor(new Color(0, 0, 0));
									this.rd.setFont(new Font("Tahoma", 0, 11));
									this.ftm = this.rd.getFontMetrics();
									if ((this.ftm.stringWidth(this.sentn[i_57_]
									[i_68_])) + 39 + i_64_ < 775) {
										if (i_68_ != 6 || (this.msgflk[i_57_]) < 67 || (this.msgflk[i_57_]) % 3 != 0) this.rd.drawString(new StringBuilder().append(this.sentn[i_57_][i_68_])
											.append("   ").toString(),
										39 + i_64_, 439 + i_56_);
										i_64_ += (this.ftm.stringWidth(new StringBuilder().append(this.sentn[i_57_][i_68_])
											.append("   ").toString()));
									} else {
										String string = "";
										for (int i_70_ = 0;
										((this.ftm.stringWidth(string) + 39 + i_64_) < 775 && i_70_ < this.sentn[i_57_]
										[i_68_].length());
										i_70_++)
										string = new StringBuilder().append(string).append(this.sentn[i_57_][i_68_].charAt(i_70_))
											.toString();
										string = new StringBuilder().append(string).append("...").toString();
										if (i_68_ != 6 || (this.msgflk[i_57_]) < 67 || (this.msgflk[i_57_]) % 3 != 0) this.rd.drawString(string, 39 + i_64_,
										439 + i_56_);
										break;
									}
								}
							}
						} else {
							this.msgflk[i_57_] = 0;
							i_54_ = i_57_;
						}
						if (bool_58_ || this.floater[i_57_] != 0) {
							float[] fs = new float[3];
							Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2],
							fs);
							fs[1] -= 0.076;
							if (fs[1] < 0.0F) fs[1] = 0.0F;
							fs[2] += 0.076;
							if (fs[2] > 1.0F) fs[2] = 1.0F;
							this.rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
							this.rd.fillRect(5, 423 + i_56_, 28,
							23);
						}
						if (bool_58_) this.rd.setColor(new Color(0, 0,
						0));
						else this.rd.setColor(new Color((int)((float)(
						(this.m)).cgrnd[0] / 2.0F), (int)((float)(
						(this.m)).cgrnd[1] / 2.0F), (int)((float)(
						(this.m)).cgrnd[2] / 2.0F)));
						this.rd.setFont(new Font("Tahoma", 1,
						11));
						this.rd.drawString("<<", 10,
						439 + i_56_);
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.drawRect(5, 423 + i_56_, 789,
						23);
						this.rd.drawLine(33, 423 + i_56_, 33,
						446 + i_56_);
						i_56_ += 23;
					}
					if (i > 775 && i < 794 && i_53_ > 409 - i_55_ * 23 && i_53_ < 423 - i_55_ * 23) {
						this.rd.drawRect(775, 409 - i_55_ * 23,
						19, 14);
						this.rd.setColor(new Color(200, 0, 0));
						if (bool) {
							(control).chatup = 0;
							if ((this.app)
								.cmsg.isShowing()) {
								(this.app)
									.cmsg.hide();
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
					this.rd.drawString("x", 782,
					420 - i_55_ * 23);
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
			} else if ((control).chatup != 0) {
				(control).chatup = 0;
				if (!this.lan) {
					this.runtyp = -101;
					if (this.runner != null) this.runner.stop();
					this.runner = new Thread(this);
					this.runner.start();
				}
			}
			if (this.holdit && this.multion == 1 && !this.lan && this.sendstat == 0) {
				this.sendstat = 1;
				if (this.runtyp != -101) {
					if (this.runner != null) this.runner.stop();
					this.runner = new Thread(this);
					this.runner.start();
				}
			}
			if (((control).arrace && this.starcnt < 38 && !this.holdit && (checkpoints).stage != 10) || this.multion >= 2) {
				if (this.alocked != -1 && ((checkpoints).dested[this.alocked]) != 0) {
					this.alocked = -1;
					this.lalocked = -1;
				}
				if (this.multion >= 2) {
					if (this.alocked == -1 || this.holdit) {
						if (this.cntflock == 100) {
							for (int i_71_ = 0;
							i_71_ < this.nplayers;
							i_71_++) {
								if (this.holdit) {
									if ((checkpoints).pos[i_71_] == 0) {
										this.alocked = i_71_;
										this.im = i_71_;
									}
								} else if (((checkpoints).dested[i_71_]) == 0) {
									this.alocked = i_71_;
									this.im = i_71_;
								}
							}
						}
						this.cntflock++;
					} else this.cntflock = 0;
					if (this.lan) {
						boolean bool_72_ = true;
						for (int i_73_ = 0;
						i_73_ < this.nplayers; i_73_++) {
							if (this.dested[i_73_] == 0 && this.plnames[i_73_].indexOf("MadBot") == -1) bool_72_ = false;
						}
						if (bool_72_) this.exitm = 2;
					}
				}
				int i_74_ = this.nplayers;
				for (int i_75_ = 0; i_75_ < i_74_; i_75_++) {
					boolean bool_76_ = false;
					for (int i_77_ = 0; i_77_ < this.nplayers;
					i_77_++) {
						if ((checkpoints).pos[i_77_] == i_75_ && (checkpoints).dested[i_77_] == 0 && !bool_76_) {
							boolean bool_78_ = false;
							boolean bool_79_ = false;
							boolean bool_80_ = false;
							int i_81_ = (int)(100.0F + (100.0F * ((float)((
							this.m)
								.snap[2]) / 100.0F)));
							if (i_81_ > 255) i_81_ = 255;
							if (i_81_ < 0) i_81_ = 0;
							this.rd.setColor(new Color(0, 0,
							i_81_));
							if (i_75_ == 0) this.rd.drawString("1st", 673, 76 + 30 * i_75_);
							if (i_75_ == 1) this.rd.drawString("2nd", 671, 76 + 30 * i_75_);
							if (i_75_ == 2) this.rd.drawString("3rd", 671, 76 + 30 * i_75_);
							if (i_75_ >= 3) this.rd.drawString(new StringBuilder().append("").append(i_75_ + 1).append("th").toString(),
							671, 76 + 30 * i_75_);
							if (this.clangame != 0) {
								int i_82_;
								int i_83_;
								if (this.pclan[i_77_].toLowerCase().equals(this.gaclan.toLowerCase())) {
									i_82_ = 255;
									i_83_ = 128;
									i_81_ = 0;
								} else {
									i_82_ = 0;
									i_83_ = 128;
									i_81_ = 255;
								}
								i_82_ += ((float) i_82_ * ((float)((
								this.m)
									.snap[0]) / 100.0F));
								if (i_82_ > 255) i_82_ = 255;
								if (i_82_ < 0) i_82_ = 0;
								i_83_ += ((float) i_83_ * ((float)((
								this.m)
									.snap[1]) / 100.0F));
								if (i_83_ > 255) i_83_ = 255;
								if (i_83_ < 0) i_83_ = 0;
								i_81_ += ((float) i_81_ * ((float)((
								this.m)
									.snap[2]) / 100.0F));
								if (i_81_ > 255) i_81_ = 255;
								if (i_81_ < 0) i_81_ = 0;
								this.rd.setColor(new Color(i_82_, i_83_, i_81_));
								this.rd.drawString(this.plnames[i_77_],
								731 - (this.ftm.stringWidth(this.plnames[i_77_])) / 2,
								70 + 30 * i_75_);
							}
							this.rd.setColor(new Color(0, 0,
							0));
							this.rd.drawString(this.plnames[i_77_],
							730 - ((this.ftm.stringWidth(this.plnames[i_77_])) / 2),
							70 + 30 * i_75_);
							int i_84_ = (int)(60.0F * ((checkpoints)
								.magperc[i_77_]));
							int i_85_ = 244;
							int i_86_ = 244;
							i_81_ = 11;
							if (i_84_ > 20) i_86_ = (int)(244.0F - 233.0F * ((float)(i_84_ - 20) / 40.0F));
							i_85_ += ((float) i_85_ * ((float)((this.m)).snap[0] / 100.0F));
							if (i_85_ > 255) i_85_ = 255;
							if (i_85_ < 0) i_85_ = 0;
							i_86_ += ((float) i_86_ * ((float)((this.m)).snap[1] / 100.0F));
							if (i_86_ > 255) i_86_ = 255;
							if (i_86_ < 0) i_86_ = 0;
							i_81_ += ((float) i_81_ * ((float)((this.m)).snap[2] / 100.0F));
							if (i_81_ > 255) i_81_ = 255;
							if (i_81_ < 0) i_81_ = 0;
							this.rd.setColor(new Color(i_85_, i_86_, i_81_));
							this.rd.fillRect(700, 74 + 30 * i_75_, i_84_, 5);
							this.rd.setColor(new Color(0, 0,
							0));
							this.rd.drawRect(700, 74 + 30 * i_75_, 60, 5);
							boolean bool_87_ = false;
							if ((this.im != i_77_ || this.multion >= 2) && i > 661 && i < 775 && i_53_ > 58 + 30 * i_75_ && i_53_ < 83 + 30 * i_75_) {
								bool_87_ = true;
								if (bool) {
									if (!this.onlock) {
										if ((this.alocked != i_77_) || (this.multion >= 2)) {
											this.alocked = i_77_;
											if (this.multion >= 2) this.im = i_77_;
										} else this.alocked = -1;
									}
									this.onlock = true;
								} else if (this.onlock) this.onlock = false;
							}
							if (this.alocked == i_77_) {
								i_85_ = (int)(159.0F + (159.0F * ((float)(
								(
								this).m).snap[0] / 100.0F)));
								if (i_85_ > 255) i_85_ = 255;
								if (i_85_ < 0) i_85_ = 0;
								i_86_ = (int)(207.0F + (207.0F * ((float)(
								(
								this).m).snap[1] / 100.0F)));
								if (i_86_ > 255) i_86_ = 255;
								if (i_86_ < 0) i_86_ = 0;
								i_81_ = (int)(255.0F + (255.0F * ((float)(
								(
								this).m).snap[2] / 100.0F)));
								if (i_81_ > 255) i_81_ = 255;
								if (i_81_ < 0) i_81_ = 0;
								this.rd.setColor(new Color(i_85_, i_86_, i_81_));
								this.rd.drawRect(661, 58 + 30 * i_75_, 114, 25);
								this.rd.drawRect(662, 59 + 30 * i_75_, 112, 23);
							}
							if (bool_87_ && !this.onlock) {
								if (this.alocked == i_77_) {
									i_85_ = (int)(120.0F + (120.0F * ((float)((
									(
									this).m)
										.snap[0]) / 100.0F)));
									if (i_85_ > 255) i_85_ = 255;
									if (i_85_ < 0) i_85_ = 0;
									i_86_ = (int)(114.0F + (114.0F * ((float)((
									(
									this).m)
										.snap[1]) / 100.0F)));
									if (i_86_ > 255) i_86_ = 255;
									if (i_86_ < 0) i_86_ = 0;
									i_81_ = (int)(255.0F + (255.0F * ((float)((
									(
									this).m)
										.snap[2]) / 100.0F)));
									if (i_81_ > 255) i_81_ = 255;
									if (i_81_ < 0) i_81_ = 0;
								} else {
									i_85_ = (int)(140.0F + (140.0F * ((float)((
									(
									this).m)
										.snap[0]) / 100.0F)));
									if (i_85_ > 255) i_85_ = 255;
									if (i_85_ < 0) i_85_ = 0;
									i_86_ = (int)(160.0F + (160.0F * ((float)((
									(
									this).m)
										.snap[1]) / 100.0F)));
									if (i_86_ > 255) i_86_ = 255;
									if (i_86_ < 0) i_86_ = 0;
									i_81_ = (int)(255.0F + (255.0F * ((float)((
									(
									this).m)
										.snap[2]) / 100.0F)));
									if (i_81_ > 255) i_81_ = 255;
									if (i_81_ < 0) i_81_ = 0;
								}
								this.rd.setColor(new Color(i_85_, i_86_, i_81_));
								this.rd.drawRect(660, 57 + 30 * i_75_, 116, 27);
							}
							bool_76_ = true;
						}
					}
				}
			}
			if ((udpmistro).go && (udpmistro).runon == 1 && !this.holdit) {
				int i_88_ = 0;
				int i_89_ = 0;
				for (int i_90_ = 0; i_90_ < this.nplayers;
				i_90_++) {
					if (i_90_ != (udpmistro).im) {
						i_89_++;
						if (((udpmistro).lframe[i_90_] == (udpmistro).lcframe[i_90_]) || (udpmistro).force[i_90_] == 7) i_88_++;
						else(udpmistro).lcframe[i_90_] = (udpmistro).lframe[i_90_];
					}
				}
				if (i_88_ == i_89_) this.discon++;
				else if (this.discon != 0) this.discon = 0;
				if (this.discon == 240)
				(udpmistro).runon = 2;
			}
		}
		if (i_54_ != -1) {
			float[] fs = new float[3];
			Color.RGBtoHSB((this.m).cgrnd[0], (this.m).cgrnd[1], (this.m).cgrnd[2], fs);
			fs[1] -= 0.22;
			if (fs[1] < 0.0F) fs[1] = 0.0F;
			fs[2] += 0.22;
			if (fs[2] > 1.0F) fs[2] = 1.0F;
			Color color = Color.getHSBColor(fs[0], fs[1], fs[2]);
			this.rd.setColor(color);
			this.rd.fillRect(676, 426 - i_54_ * 23, 109, 7);
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.setFont(new Font("Tahoma", 1, 11));
			this.rd.drawString("Send Message  >", 684,
			439 - i_54_ * 23);
			this.rd.setColor(new Color((int)((float)((this.m)
				.cgrnd[0]) / 1.2F), (int)((float)((this.m)
				.cgrnd[1]) / 1.2F), (int)((float)((this.m)
				.cgrnd[2]) / 1.2F)));
			this.rd.drawRect(676, 426 - i_54_ * 23, 109, 17);
			if (!(this.app).cmsg.isShowing()) {
				(this.app).cmsg.show();
				(this.app).cmsg.requestFocus();
				this.lcmsg[i_54_] = "";
				(this.app).cmsg.setText("");
				(this.app).cmsg.setBackground(color);
			}
			this.app.movefield((
			this.app).cmsg,
			34, 424 - i_54_ * 23, 633, 22);
			if ((this.app).cmsg.getText()
				.equals(this.lcmsg[i_54_])) this.cntchatp[i_54_]++;
			else this.cntchatp[i_54_] = -200;
			this.lcmsg[i_54_] = new StringBuilder().append("").append((this.app).cmsg.getText())
				.toString();
			if (this.cntchatp[i_54_] == 67)
			(control).chatup = 0;
			if ((this.app).cmsg.getText().length() > 100) {
				(this.app).cmsg.setText((this.app).cmsg.getText()
					.substring(0, 100));
				(this.app).cmsg.select(100, 100);
			}
			this.rd.setFont(new Font("Arial", 1, 11));
			this.ftm = this.rd.getFontMetrics();
		}
	}

	public void levelhigh(int i, int i_91_, int i_92_, int i_93_, int i_94_) {
		this.rd.drawImage(this.gameh, 301, 20,
		null);
		int i_95_ = 16;
		int i_96_ = 48;
		int i_97_ = 96;
		if (i_93_ < 50) {
			if (this.aflk) {
				i_95_ = 106;
				i_96_ = 176;
				i_97_ = 255;
				this.aflk = false;
			} else this.aflk = true;
		}
		if (i != this.im) {
			if (i_92_ == 0) drawcs(60, "You Wasted 'em!", i_95_, i_96_, i_97_, 0);
			else if (i_92_ == 1) drawcs(60, "Close Finish!", i_95_, i_96_, i_97_, 0);
			else drawcs(60, "Close Finish!  Almost got it!", i_95_, i_96_,
			i_97_, 0);
		} else if (i_91_ == 229) {
			if (this.discon != 240) drawcs(60, "Wasted!", i_95_, i_96_, i_97_, 0);
			else drawcs(60, "Disconnected!", i_95_, i_96_, i_97_, 0);
		} else if (i_94_ > 2 || i_94_ < 0) drawcs(60, "Stunts!", i_95_, i_96_, i_97_, 0);
		else drawcs(60, "Best Stunt!", i_95_, i_96_, i_97_, 0);
		drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
	}

	public void inst(Control control) {
		if (this.flipo == 0) this.flipo = 1;
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
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.3F));
		this.rd.drawImage(this.bggo, 65, 25,
		null);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(735, 0, 65, 450);
		this.rd.fillRect(65, 425, 670, 25);
		if (this.aflk) this.aflk = false;
		else this.aflk = true;
		if (this.flipo != 1 && this.flipo != 16) {
			if (this.dudo > 0) {
				if (this.aflk) {
					if (Math.random() > Math.random()) this.duds = (int)(Math.random() * 3.0);
					else this.duds = (int)(Math.random() * 2.0);
				}
				this.dudo--;
			} else this.duds = 0;
			this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
			this.rd.drawImage((this.dude[this.duds]),
			95, 15, null);
			this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
			this.rd.drawImage(this.oflaot, 192,
			42, null);
		}
		this.rd.setColor(new Color(0, 64, 128));
		this.rd.setFont(new Font("Arial", 1, 13));
		if (this.flipo == 3 || this.flipo == 5) {
			if (this.flipo == 3) {
				this.rd.drawString("Hello!  Welcome to the world of", 262, 67);
				this.rd.drawString("!", 657, 67);
				this.rd.drawImage(this.nfm, 469,
				55, null);
				this.rd.drawString("In this game there are two ways to complete a stage.",
				262, 107);
				this.rd.drawString("One is by racing and finishing in first place, the other is by",
				262, 127);
				this.rd.drawString("wasting and crashing all the other cars in the stage!",
				262, 147);
			} else {
				this.rd.setColor(new Color(0, 128, 255));
				this.rd.drawString("While racing, you will need to focus on going fast and passing",
				262, 67);
				this.rd.drawString("through all the checkpoints in the track. To complete a lap, you",
				262, 87);
				this.rd.drawString("must not miss a checkpoint.", 262, 107);
				this.rd.drawString("While wasting, you will just need to chase the other cars and",
				262, 127);
				this.rd.drawString("crash into them (without worrying about track and checkpoints).",
				262, 147);
			}
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawImage(this.racing, 165,
			185, null);
			this.rd.drawImage(this.ory, 429, 235,
			null);
			this.rd.drawImage(this.wasting, 492,
			185, null);
			this.rd.setFont(new Font("Arial", 1, 11));
			this.rd.drawString("Checkpoint", 392, 189);
			this.rd.setFont(new Font("Arial", 1, 13));
			this.rd.drawString("Drive your car using the Arrow Keys and Spacebar", 125, 320);
			this.rd.drawImage(this.space, 171,
			355, null);
			this.rd.drawImage(this.arrows, 505,
			323, null);
			this.rd.setFont(new Font("Arial", 1, 11));
			this.rd.drawString("(When your car is on the ground Spacebar is for Handbrake)",
			125, 341);
			this.rd.drawString("Accelerate", 515, 319);
			this.rd.drawString("Brake/Reverse", 506, 397);
			this.rd.drawString("Turn left", 454, 375);
			this.rd.drawString("Turn right", 590, 375);
			this.rd.drawString("Handbrake", 247, 374);
		}
		if (this.flipo == 7 || this.flipo == 9) {
			if (this.flipo == 7) {
				this.rd.drawString("Whether you are racing or wasting the other cars you will need",
				262, 67);
				this.rd.drawString("to power up your car.", 262,
				87);
				this.rd.drawString("=> More 'Power' makes your car become faster and stronger!",
				262, 107);
				this.rd.drawString("To power up your car (and keep it powered up) you will need to",
				262, 127);
				this.rd.drawString("perform stunts!", 262, 147);
				this.rd.drawImage(this.chil, 167,
				295, null);
			} else {
				this.rd.drawString("The better the stunt the more power you get!", 262, 67);
				this.rd.setColor(new Color(0, 128, 255));
				this.rd.drawString("Forward looping pushes your car forwards in the air and helps",
				262, 87);
				this.rd.drawString("when racing. Backward looping pushes your car upwards giving it",
				262, 107);
				this.rd.drawString("more hang time in the air making it easier to control its landing.",
				262, 127);
				this.rd.drawString("Left and right rolls shift your car in the air left and right slightly.",
				262, 147);
				if (this.aflk || this.dudo < 150) this.rd.drawImage(this.chil,
				167, 295, null);
			}
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawImage(this.stunts, 105,
			175, null);
			this.rd.drawImage(this.opwr, 540,
			253, null);
			this.rd.setFont(new Font("Arial", 1, 13));
			this.rd.drawString("To perform stunts. When your car is in the AIR:", 125, 310);
			this.rd.drawString("Press combo Spacebar + Arrow Keys", 125, 330);
			this.rd.drawImage(this.space, 185,
			355, null);
			this.rd.drawImage(this.plus, 405,
			358, null);
			this.rd.drawImage(this.arrows, 491,
			323, null);
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
				this.rd.drawString("When wasting cars, to help you find the other cars in the stage,",
				262, 67);
				this.rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track",
				262, 87);
				this.rd.drawString("to pointing to the cars.",
				262, 107);
				this.rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by",
				262, 127);
				this.rd.drawString("jumping through the electrified hoop.", 262, 147);
			} else {
				this.rd.setColor(new Color(0, 128, 255));
				this.rd.drawString("You will find that in some stages it's easier to waste the other cars",
				262, 67);
				this.rd.drawString("and in some others it's easier to race and finish in first place.",
				262, 87);
				this.rd.drawString("It is up to you to decide when to waste and when to race.",
				262, 107);
				this.rd.drawString("And remember, 'Power' is an important factor in the game. You",
				262, 127);
				this.rd.drawString("will need it whether you are racing or wasting!", 262,
				147);
			}
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawImage(this.fixhoop, 185,
			218, null);
			this.rd.drawImage(this.sarrow, 385,
			228, null);
			this.rd.setFont(new Font("Arial", 1, 11));
			this.rd.drawString("The Electrified Hoop", 192,
			216);
			this.rd.drawString("Jumping through it fixes your car.", 158, 338);
			this.rd.drawString("Make guidance arrow point to cars.", 385, 216);
		}
		if (this.flipo == 15) {
			this.rd.drawString("And if you don\u2019t know who I am,", 262, 67);
			this.rd.drawString("I am Coach Insano, I am the coach and narrator of this game!",
			262, 87);
			this.rd.drawString("I recommended starting with NFM 1 if it\u2019s your first time to play.",
			262, 127);
			this.rd.drawString("Good Luck & Have Fun!", 262,
			147);
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString("Other Controls :", 155, 205);
			this.rd.setFont(new Font("Arial", 1, 11));
			this.rd.drawImage(this.kz, 169, 229,
			null);
			this.rd.drawString("OR", 206, 251);
			this.rd.drawImage(this.kx, 229, 229,
			null);
			this.rd.drawString("To look behind you while driving.", 267, 251);
			this.rd.drawImage(this.kv, 169, 279,
			null);
			this.rd.drawString("Change Views", 207, 301);
			this.rd.drawImage(this.kenter, 169,
			329, null);
			this.rd.drawString("Navigate & Pause Game", 275,
			351);
			this.rd.drawImage(this.km, 489, 229,
			null);
			this.rd.drawString("Mute Music", 527, 251);
			this.rd.drawImage(this.kn, 489, 279,
			null);
			this.rd.drawString("Mute Sound Effects", 527, 301);
			this.rd.drawImage(this.ks, 489, 329,
			null);
			this.rd.drawString("Toggle radar / map", 527, 351);
		}
		if (this.flipo == 1 || this.flipo == 16) {
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			this.rd.setColor(new Color(0, 0, 0));
			if (this.flipo == 16) this.rd.drawString("M A I N    C O N T R O L S   -   once again!",
			400 - ((this.ftm.stringWidth("M A I N    C O N T R O L S   -   once again!")) / 2),
			49);
			else this.rd.drawString("M A I N    C O N T R O L S",
			400 - this.ftm.stringWidth("M A I N    C O N T R O L S") / 2,
			49);
			this.rd.drawString("Drive your car using the Arrow Keys:", 125, 80);
			this.rd.drawString("On the GROUND Spacebar is for Handbrake", 125, 101);
			this.rd.drawImage(this.space, 171,
			115, null);
			this.rd.drawImage(this.arrows, 505,
			83, null);
			this.rd.setFont(new Font("Arial", 1, 11));
			this.ftm = this.rd.getFontMetrics();
			this.rd.drawString("Accelerate", 515, 79);
			this.rd.drawString("Brake/Reverse", 506, 157);
			this.rd.drawString("Turn left", 454, 135);
			this.rd.drawString("Turn right", 590, 135);
			this.rd.drawString("Handbrake", 247, 134);
			drawcs(175,
				"----------------------------------------------------------------------------------------------------------------------------------------------------",
			0, 64, 128, 3);
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			this.rd.drawString("To perform STUNTS:", 125, 200);
			this.rd.drawString("In the AIR press combo Spacebar + Arrow Keys", 125, 220);
			this.rd.drawImage(this.space, 185,
			245, null);
			this.rd.drawImage(this.plus, 405,
			248, null);
			this.rd.drawImage(this.arrows, 491,
			213, null);
			this.rd.setFont(new Font("Arial", 1, 11));
			this.ftm = this.rd.getFontMetrics();
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString("Forward Loop", 492, 209);
			this.rd.drawString("Backward Loop", 490, 287);
			this.rd.drawString("Left Roll", 443, 265);
			this.rd.drawString("Right Roll", 576, 265);
			this.rd.drawString("Spacebar", 266, 264);
			this.rd.drawImage(this.stunts, 125,
			285, null);
		}
		if (this.flipo >= 1 && this.flipo <= 15) this.rd.drawImage((this.next[this.pnext]),
		665, 395, null);
		if (this.flipo >= 3 && this.flipo <= 16) this.rd.drawImage((this.back[this.pback]),
		75, 395, null);
		if (this.flipo == 16) this.rd.drawImage((this.contin[this.pcontin]),
		565, 395, null);
		if ((control).enter || (control).right) {
			if ((control).enter && this.flipo == 16) {
				this.flipo = 0;
				this.fase = this.oldfase;
				this.rd.setFont(new Font("Arial", 1, 11));
				this.ftm = this.rd.getFontMetrics();
			}
			(control).enter = false;
			(control).right = false;
			if (this.flipo >= 1 && this.flipo <= 15) this.flipo++;
		}
		if ((control).left) {
			if (this.flipo >= 3 && this.flipo <= 15) this.flipo -= 3;
			if (this.flipo == 16) this.flipo--;
			(control).left = false;
		}
	}

	public void maini(Control control) {
		if (this.flipo == 0) {
			this.app.setCursor(new Cursor(0));
			this.flipo++;
		}
		mainbg(1);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.6F));
		this.rd.drawImage(this.logomadbg, 65, 25,
		null);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
		this.rd.drawImage(this.logomadnes, 233,
		186, null);
		float f = (float) this.flkat / 800.0F;
		if ((double) f > 0.2) f = 0.2F;
		if (this.flkat > 200) {
			f = (float)(400 - this.flkat) / 1000.0F;
			if (f < 0.0F) f = 0.0F;
		}
		this.flkat++;
		if (this.flkat == 400) this.flkat = 0;
		this.rd.setComposite(AlphaComposite.getInstance(3, f));
		this.rd.drawImage(this.dude[0],
		351 + this.gxdu,
		28 + this.gydu, null);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
		if (this.movly == 0) {
			this.gxdu = (int)(5.0 - 11.0 * Math.random());
			this.gydu = (int)(5.0 - 11.0 * Math.random());
		}
		this.movly++;
		if (this.movly == 2) this.movly = 0;
		this.rd.drawImage(this.logocars, 66, 33,
		null);
		this.rd.drawImage(this.opback, 247, 237,
		null);
		if (this.muhi < 0) {
			this.rd.setColor(new Color(140, 70, 0));
			this.rd.fillRoundRect(335, 293, 114, 19, 7, 20);
		}
		this.muhi--;
		if (this.muhi < -5) this.muhi = 50;
		if ((control).up) {
			this.opselect--;
			if (this.opselect == -1) this.opselect = 3;
			(control).up = false;
		}
		if ((control).down) {
			this.opselect++;
			if (this.opselect == 4) this.opselect = 0;
			(control).down = false;
		}
		if (this.opselect == 0) {
			if (this.shaded) {
				this.rd.setColor(new Color(140, 70, 0));
				this.rd.fillRect(343, 261, 110, 22);
				this.aflk = false;
			}
			if (this.aflk) {
				this.rd.setColor(new Color(200, 200, 0));
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
		this.rd.drawImage(this.opti, 294, 265,
		null);
		if ((control).enter || (control).handb) {
			if (this.opselect == 1) {
				this.mtop = true;
				this.multion = 1;
				this.gmode = 0;
				if (this.firstime) {
					this.oldfase = -9;
					this.fase = 11;
					this.firstime = false;
				} else this.fase = -9;
			}
			if (this.opselect == 2) {
				this.oldfase = 10;
				this.fase = 11;
				this.firstime = false;
			}
			if (this.opselect == 3) this.fase = 8;
			if (this.opselect == 0) {
				if (this.unlocked[0] == 11) {
					if (this.unlocked[1] != 17) this.opselect = 1;
					else this.opselect = 2;
				}
				if (this.firstime) {
					this.oldfase = 102;
					this.fase = 11;
					this.firstime = false;
				} else this.fase = 102;
			}
			this.flipo = 0;
			(control).enter = false;
			(control).handb = false;
		}
		this.rd.drawImage(this.byrd, 72, 410,
		null);
		this.rd.drawImage(this.nfmcoms, 567, 410,
		null);
		if (this.shaded) {
			this.app.repaint();
			try {
				Thread.sleep(200L);
			} catch (InterruptedException interruptedexception) {
				/* empty */
			}
		}
	}

	public void maini2(Control control, int i, int i_98_, int i_99_) {
		mainbg(1);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.6F));
		this.rd.drawImage(this.logomadbg, 65, 25,
		null);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
		this.rd.drawImage(this.logomadnes, 233,
		186, null);
		float f = (float) this.flkat / 800.0F;
		if ((double) f > 0.2) f = 0.2F;
		if (this.flkat > 200) {
			f = (float)(400 - this.flkat) / 1000.0F;
			if (f < 0.0F) f = 0.0F;
		}
		this.flkat++;
		if (this.flkat == 400) this.flkat = 0;
		this.rd.setComposite(AlphaComposite.getInstance(3, f));
		this.rd.drawImage(this.dude[0],
		351 + this.gxdu,
		28 + this.gydu, null);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
		if (this.movly == 0) {
			this.gxdu = (int)(5.0 - 11.0 * Math.random());
			this.gydu = (int)(5.0 - 11.0 * Math.random());
		}
		this.movly++;
		if (this.movly == 2) this.movly = 0;
		this.rd.drawImage(this.logocars, 66, 33,
		null);
		this.rd.drawImage(this.opback, 247, 237,
		null);
		if ((control).up) {
			this.opselect--;
			if (this.opselect == -1) this.opselect = 3 - this.dropf / 15;
			(control).up = false;
		}
		if ((control).down) {
			this.opselect++;
			if (this.opselect == 4 - this.dropf / 15) this.opselect = 0;
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
			this.rd.drawRoundRect(358, (262 + this.dropf),
			82, 22, 7, 20);
		} else {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawRoundRect(358, (262 + this.dropf),
			82, 22, 7, 20);
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
			this.rd.drawRoundRect(358, (290 + this.dropf),
			82, 22, 7, 20);
		} else {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawRoundRect(358, (290 + this.dropf),
			82, 22, 7, 20);
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
			this.rd.drawRoundRect(333, (318 + this.dropf),
			132, 22, 7, 20);
		} else {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawRoundRect(333, (318 + this.dropf),
			132, 22, 7, 20);
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
		this.rd.drawImage(this.opti2, 346,
		265 + this.dropf,
		null);
		if (this.dropf != 0) {
			this.rd.setColor(new Color(58, 30, 8));
			this.rd.fillRect(357, 365, 87, 15);
		}
		if ((control).enter || (control).handb) {
			this.mtop = false;
			if (this.opselect == 0) {
				this.multion = 0;
				this.clangame = 0;
				this.gmode = 1;
				this.fase = -9;
			}
			if (this.opselect == 1) {
				this.multion = 0;
				this.clangame = 0;
				this.gmode = 2;
				this.fase = -9;
				this.opselect = 0;
			}
			if (this.dropf == 0 && this.opselect == 3) {
				this.multion = 0;
				this.clangame = 0;
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
				} else this.fase = -9;
			}
			this.flipo = 0;
			(control).enter = false;
			(control).handb = false;
		}
		this.rd.drawImage(this.byrd, 72, 410,
		null);
		this.rd.drawImage(this.nfmcoms, 567, 410,
		null);
		boolean bool = false;
		if (i_99_ == 2) bool = true;
		if (drawcarb(true, null, "   < Back   ", 161, 313, i, i_98_, bool)) {
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
		if (!this.badmac) this.rd.drawImage(this.fleximg, 0, 0,
		null);
		else {
			this.rd.setColor(new Color(30, 67, 110));
			this.rd.fillRect(281, 8, 237, 188);
		}
		if ((control).up) {
			this.opselect--;
			if (this.opselect == -1) this.opselect = 3;
			(control).up = false;
		}
		if ((control).down) {
			this.opselect++;
			if (this.opselect == 4) this.opselect = 0;
			(control).down = false;
		}
		if (this.opselect == 0) {
			this.rd.setColor(new Color(64, 143, 223));
			this.rd.fillRoundRect(329, 45, 137, 22, 7, 20);
			if (this.shaded) this.rd.setColor(new Color(225, 200, 255));
			else this.rd.setColor(new Color(0, 89, 223));
			this.rd.drawRoundRect(329, 45, 137, 22, 7, 20);
		}
		if (this.opselect == 1) {
			this.rd.setColor(new Color(64, 143, 223));
			this.rd.fillRoundRect(320, 73, 155, 22, 7, 20);
			if (this.shaded) this.rd.setColor(new Color(225, 200, 255));
			else this.rd.setColor(new Color(0, 89, 223));
			this.rd.drawRoundRect(320, 73, 155, 22, 7, 20);
		}
		if (this.opselect == 2) {
			this.rd.setColor(new Color(64, 143, 223));
			this.rd.fillRoundRect(303, 99, 190, 22, 7, 20);
			if (this.shaded) this.rd.setColor(new Color(225, 200, 255));
			else this.rd.setColor(new Color(0, 89, 223));
			this.rd.drawRoundRect(303, 99, 190, 22, 7, 20);
		}
		if (this.opselect == 3) {
			this.rd.setColor(new Color(64, 143, 223));
			this.rd.fillRoundRect(341, 125, 109, 22, 7, 20);
			if (this.shaded) this.rd.setColor(new Color(225, 200, 255));
			else this.rd.setColor(new Color(0, 89, 223));
			this.rd.drawRoundRect(341, 125, 109, 22, 7, 20);
		}
		this.rd.drawImage(this.paused, 281, 8,
		null);
		if ((control).enter || (control).handb) {
			if (this.opselect == 0) {
				if (this.loadedt && !this.mutem) this.strack.resume();
				this.fase = 0;
			}
			if (this.opselect == 1) {
				if ((record).caught >= 300) {
					if (this.loadedt && !this.mutem) this.strack.resume();
					this.fase = -1;
				} else this.fase = -8;
			}
			if (this.opselect == 2) {
				if (this.loadedt) this.strack.stop();
				this.oldfase = -7;
				this.fase = 11;
			}
			if (this.opselect == 3) {
				if (this.loadedt) this.strack.unload();
				this.fase = 102;
				if (this.gmode == 0) this.opselect = 3;
				if (this.gmode == 1) this.opselect = 0;
				if (this.gmode == 2) this.opselect = 1;
				this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				this.rd.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_ON));
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
		drawcs(89,
			"Sorry not enough replay data to play available, please try again later.",
		255, 255, 255, 1);
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
		drawcs(14,
			"Game lost its focus.   Click screen with mouse to continue.",
		100, 100, 100, 3);
		drawcs(445,
			"Game lost its focus.   Click screen with mouse to continue.",
		100, 100, 100, 3);
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
		this.basefase = 0;
		this.noclass = false;
		if (this.testdrive != 1 && this.testdrive != 2) {
			if (this.gmode != 0) {
				this.cfase = 0;
				this.sc[0] = this.scm[this.gmode - 1];
			}
			if (this.gmode == 0) this.sc[0] = this.osc;
			if ((this.cd).lastload != 1 || this.cfase != 3) this.onmsc = this.sc[0];
			if (this.cfase == 0 && this.sc[0] > 15) {
				this.sc[0] = 15;
				if (this.multion != 0) this.cfase = -1;
			}
			if (this.onjoin != -1 && this.multion != 0) {
				if (this.ontyp <= -2) this.cfase = 0;
				if (this.ontyp >= 20) {
					this.ontyp -= 20;
					this.cfase = 0;
				}
				if (this.ontyp >= 10) {
					this.ontyp -= 10;
					if ((this.cd).lastload != 2) {
						this.cfase = -1;
						this.onjoin = -1;
					} else this.cfase = 3;
				}
			}
			if (this.cfase == 11 || this.cfase == 101) {
				if (this.sc[0] >= 16 && (this.cd).lastload == 2 && this.sc[0] < 36) this.cfase = 3;
				else this.cfase = 0;
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
					if (this.sc[0] < this.minsl) this.sc[0] = this.minsl;
					if (this.sc[0] > this.maxsl) this.sc[0] = this.maxsl;
					if (this.onjoin != -1 && this.multion != 0 && this.ontyp > 0 && this.ontyp <= 5) {
						boolean bool = false;
						for (int i = 16;
						i < (this.cd).nlocars;
						i++) {
							if (Math.abs(((this.cd)
								.cclass[i]) - (this.ontyp - 1)) <= 1) {
								if (!bool) {
									this.minsl = i;
									bool = true;
								}
								if (bool) this.maxsl = i;
							}
						}
						if (!bool) {
							this.onjoin = -1;
							this.noclass = true;
						} else {
							if (this.sc[0] < this.minsl) this.sc[0] = this.minsl;
							if (this.sc[0] > this.maxsl) this.sc[0] = this.maxsl;
							if (Math.abs(((this.cd)
								.cclass[this.sc[0]]) - (this.ontyp - 1)) > 1) this.sc[0] = this.minsl;
						}
					}
				}
				if ((this.cd).lastload == -2 && this.logged) {
					this.cfase = 5;
					this.showtf = false;
					(this.cd).action = 3;
					this.cd.sparkactionloader();
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
				if (this.sc[0] < this.minsl) this.sc[0] = this.minsl;
				if (this.sc[0] > this.maxsl) this.sc[0] = this.maxsl;
			}
		} else {
			this.minsl = this.sc[0];
			this.maxsl = this.sc[0];
		}
		(this.app).mcars.setBackground(new Color(0, 0, 0));
		(this.app).mcars.setForeground(new Color(47, 179, 255));
		((this.app).mcars).alphad = true;
		((this.app).mcars).carsel = true;
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
			if ((this.cd).lastload == 2) i = (this.cd).nlocars;
			for (int i_100_ = 0; i_100_ < i; i_100_++) {
				float[] fs = new float[3];
				Color.RGBtoHSB((contos[i_100_]).fcol[0], (contos[i_100_]).fcol[1], (contos[i_100_]).fcol[2], fs);
				for (int i_101_ = 0; i_101_ < (contos[i_100_]).npl;
				i_101_++) {
					if (((contos[i_100_]).p[i_101_]).colnum == 1) {
						((contos[i_100_]).p[i_101_]).hsb[0] = fs[0];
						((contos[i_100_]).p[i_101_]).hsb[1] = fs[1];
						((contos[i_100_]).p[i_101_]).hsb[2] = fs[2];
						((contos[i_100_]).p[i_101_]).oc[0] = (contos[i_100_]).fcol[0];
						((contos[i_100_]).p[i_101_]).oc[1] = (contos[i_100_]).fcol[1];
						((contos[i_100_]).p[i_101_]).oc[2] = (contos[i_100_]).fcol[2];
					}
				}
				Color.RGBtoHSB((contos[i_100_]).scol[0], (contos[i_100_]).scol[1], (contos[i_100_]).scol[2], fs);
				for (int i_102_ = 0; i_102_ < (contos[i_100_]).npl;
				i_102_++) {
					if (((contos[i_100_]).p[i_102_]).colnum == 2) {
						((contos[i_100_]).p[i_102_]).hsb[0] = fs[0];
						((contos[i_100_]).p[i_102_]).hsb[1] = fs[1];
						((contos[i_100_]).p[i_102_]).hsb[2] = fs[2];
						((contos[i_100_]).p[i_102_]).oc[0] = (contos[i_100_]).scol[0];
						((contos[i_100_]).p[i_102_]).oc[1] = (contos[i_100_]).scol[1];
						((contos[i_100_]).p[i_102_]).oc[2] = (contos[i_100_]).scol[2];
					}
				}
				(contos[i_100_]).xy = 0;
			}
			for (int i_103_ = 0; i_103_ < 6; i_103_++)
			this.arnp[i_103_] = -1.0F;
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
		if (this.multion == 0) {
			this.intertrack.loadimod(false);
			this.intertrack.play();
		}
	}

	public void carselect(Control control, ContO[] contos, Mad mad, int i,
	int i_104_, boolean bool) {
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(0, 0, 65, 450);
		this.rd.fillRect(735, 0, 65, 450);
		this.rd.fillRect(65, 0, 670, 25);
		this.rd.fillRect(65, 425, 670, 25);
		if (this.flatrstart == 6) {
			if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) this.rd.drawImage(this.carsbgc,
			65, 25, null);
			else this.rd.drawImage(this.carsbg,
			65, 25, null);
		} else if (this.flatrstart <= 1) drawSmokeCarsbg();
		else {
			this.rd.setColor(new Color(255, 255, 255));
			this.rd.fillRect(65, 25, 670, 400);
			carsbginflex();
			this.flatrstart = 6;
		}
		this.rd.drawImage(this.selectcar, 321,
		37, null);
		if (this.cfase == 3 || this.cfase == 7 || this.remi) {
			if ((this.cd).lastload == 1) this.rd.drawImage(this.ycmc, 337,
			58, null);
			if ((this.cd).lastload == 2) this.rd.drawImage(this.yac, 323,
			58, null);
		}
		if (this.cfase == 11) {
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			String string = "Top 20 Cars";
			int i_105_ = (this.cd).loadlist;
			String string_106_ = "Weekly";
			while (i_105_ > 6) {
				i_105_ -= 6;
				if (string_106_.equals("Semi-Annual")) string_106_ = "Annual";
				if (string_106_.equals("Monthly")) string_106_ = "Semi-Annual";
				if (string_106_.equals("Weekly")) string_106_ = "Monthly";
			}
			if (i_105_ == 1) string = new StringBuilder().append("").append(string_106_).append(" Top 20 Cars").toString();
			if (i_105_ == 2) string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class A Cars").toString();
			if (i_105_ == 3) string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class A & B Cars").toString();
			if (i_105_ == 4) string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class B Cars").toString();
			if (i_105_ == 5) string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class B & C Cars").toString();
			if (i_105_ == 6) string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class C Cars").toString();
			drawcs(69, string, 120, 176, 255, 3);
		}
		if (this.cfase == 101) {
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			drawcs(69,
			new StringBuilder().append("").append((this.cd).viewname).append("'s account cars!").toString(),
			220, 112, 33, 3);
		}
		if (!this.remi) {
			this.rd.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_OFF));
			contos[this.sc[0]].d(this.rd);
			this.rd.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_ON));
		}
		if (this.cfase == 8) {
			drawprom(150, 85);
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			drawcs(195, "Removing Car...", 0, 0, 0, 3);
			if ((this.cd).action != 10) {
				if ((this.cd).action != -10) {
					this.cfase = 5;
					this.showtf = false;
				} else this.cfase = 9;
			}
		}
		if ((this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) && this.lsc != this.sc[0]) {
			if ((contos[this.sc[0]]).xy != 0)
			(contos[this.sc[0]]).xy = 0;
			boolean bool_107_ = false;
			for (int i_108_ = 0;
			(i_108_ < (contos[this.sc[0]]).npl && !bool_107_);
			i_108_++) {
				if ((((contos[this.sc[0]]).p[i_108_])).colnum == 1) {
					float[] fs = new float[3];
					Color.RGBtoHSB((((contos[this.sc[0]])
						.p[i_108_])).c[0], (((contos[this.sc[0]])
						.p[i_108_])).c[1], (((contos[this.sc[0]])
						.p[i_108_])).c[2],
					fs);
					this.arnp[0] = fs[0];
					this.arnp[1] = fs[1];
					this.arnp[2] = 1.0F - fs[2];
					bool_107_ = true;
				}
			}
			bool_107_ = false;
			for (int i_109_ = 0;
			(i_109_ < (contos[this.sc[0]]).npl && !bool_107_);
			i_109_++) {
				if ((((contos[this.sc[0]]).p[i_109_])).colnum == 2) {
					float[] fs = new float[3];
					Color.RGBtoHSB((((contos[this.sc[0]])
						.p[i_109_])).c[0], (((contos[this.sc[0]])
						.p[i_109_])).c[1], (((contos[this.sc[0]])
						.p[i_109_])).c[2],
					fs);
					this.arnp[3] = fs[0];
					this.arnp[4] = fs[1];
					this.arnp[5] = 1.0F - fs[2];
					bool_107_ = true;
				}
			}
			Color color = Color.getHSBColor(this.arnp[0],
			this.arnp[1],
			1.0F - this.arnp[2]);
			Color color_110_ = Color.getHSBColor(this.arnp[3],
			this.arnp[4],
			1.0F - this.arnp[5]);
			for (int i_111_ = 0;
			i_111_ < (contos[this.sc[0]]).npl;
			i_111_++) {
				if ((((contos[this.sc[0]]).p[i_111_])).colnum == 1) {
					(((contos[this.sc[0]]).p[i_111_])).hsb[0] = this.arnp[0];
					(((contos[this.sc[0]]).p[i_111_])).hsb[1] = this.arnp[1];
					(((contos[this.sc[0]]).p[i_111_])).hsb[2] = 1.0F - this.arnp[2];
					(((contos[this.sc[0]]).p[i_111_])).c[0] = color.getRed();
					(((contos[this.sc[0]]).p[i_111_])).c[1] = color.getGreen();
					(((contos[this.sc[0]]).p[i_111_])).c[2] = color.getBlue();
					(((contos[this.sc[0]]).p[i_111_])).oc[0] = color.getRed();
					(((contos[this.sc[0]]).p[i_111_])).oc[1] = color.getGreen();
					(((contos[this.sc[0]]).p[i_111_])).oc[2] = color.getBlue();
				}
				if ((((contos[this.sc[0]]).p[i_111_])).colnum == 2) {
					(((contos[this.sc[0]]).p[i_111_])).hsb[0] = this.arnp[3];
					(((contos[this.sc[0]]).p[i_111_])).hsb[1] = this.arnp[4];
					(((contos[this.sc[0]]).p[i_111_])).hsb[2] = 1.0F - this.arnp[5];
					(((contos[this.sc[0]]).p[i_111_])).c[0] = color_110_.getRed();
					(((contos[this.sc[0]]).p[i_111_])).c[1] = color_110_.getGreen();
					(((contos[this.sc[0]]).p[i_111_])).c[2] = color_110_.getBlue();
					(((contos[this.sc[0]]).p[i_111_])).oc[0] = color_110_.getRed();
					(((contos[this.sc[0]]).p[i_111_])).oc[1] = color_110_.getGreen();
					(((contos[this.sc[0]]).p[i_111_])).oc[2] = color_110_.getBlue();
				}
			}
			this.lsc = this.sc[0];
		}
		int i_112_ = -1;
		int i_113_ = 0;
		boolean bool_114_ = false;
		if (this.flipo == 0) {
			this.rd.setFont(new Font("Arial", 1, 13));
			this.ftm = this.rd.getFontMetrics();
			int i_115_ = 0;
			if (this.flatrstart < 6) i_115_ = 2;
			if (!this.remi && (this.cfase != 10 || ((this.cd).action != 0 && ((this.cd).action < 14)))) {
				if (this.cfase == 3 && (this.cd).lastload == 2) {
					(this.app).mcars.move(400 - ((
					(this.app).mcars)
						.w) / 2,
					78);
					((this.app).mcars)
						.show = true;
					if (!(this.app).mcars.getSelectedItem().equals((this.cd).names[this.sc[0]])) {
						for (int i_116_ = 16;
						(i_116_ < (this.cd).nlocars);
						i_116_++) {
							if ((this.cd).names[i_116_].equals((this.app)
								.mcars.getSelectedItem())) i_112_ = i_116_;
						}
						if (i_112_ == -1) {
							this.cfase = 5;
							(this.cd).action = 4;
							this.cd.sparkactionloader();
						}
					}
				} else {
					((this.app).mcars)
						.show = false;
					String string = "";
					if (this.cfase == 11) string = new StringBuilder().append("N#").append(this.sc[0] - 35).append("  ").toString();
					if (this.aflk) {
						drawcs(95 + i_115_,
						new StringBuilder().append(string).append((this.cd).names[this.sc[0]])
							.toString(),
						240, 240, 240, 3);
						this.aflk = false;
					} else {
						drawcs(95, new StringBuilder().append(string).append((this.cd)
							.names[this.sc[0]])
							.toString(), 176, 176, 176, 3);
						this.aflk = true;
					}
				}
			} else((this.app).mcars).show = false;
			(contos[this.sc[0]]).z = 950;
			if (this.sc[0] == 13)
			(contos[this.sc[0]]).z = 1000;
			(contos[this.sc[0]]).y = -34 - (contos[this.sc[0]]).grat;
			(contos[this.sc[0]]).x = 0;
			if (this.mouson >= 0 && this.mouson <= 3)
			(contos[this.sc[0]]).xz += 2;
			else(contos[this.sc[0]]).xz += 5;
			if ((contos[this.sc[0]]).xz > 360)
			(contos[this.sc[0]]).xz -= 360;
			(contos[this.sc[0]]).zy = 0;
			(contos[this.sc[0]]).wzy -= 10;
			if ((contos[this.sc[0]]).wzy < -30)
			(contos[this.sc[0]]).wzy += 30;
			if (!this.remi) {
				if (this.sc[0] != this.minsl) this.rd.drawImage((this.back[(this.pback)]),
				95, 275, null);
				if (this.sc[0] != this.maxsl) this.rd.drawImage((this.next[(this.pnext)]),
				645, 275, null);
			}
			if (this.gmode == 1) {
				if (this.sc[0] == 5 && this.unlocked[0] <= 2) i_113_ = 2;
				if (this.sc[0] == 6 && this.unlocked[0] <= 4) i_113_ = 4;
				if (this.sc[0] == 11 && this.unlocked[0] <= 6) i_113_ = 6;
				if (this.sc[0] == 14 && this.unlocked[0] <= 8) i_113_ = 8;
				if (this.sc[0] == 15 && this.unlocked[0] <= 10) i_113_ = 10;
			}
			if (this.gmode == 2 && this.sc[0] >= 8 && (this.unlocked[1] <= (this.sc[0] - 7) * 2)) i_113_ = (this.sc[0] - 7) * 2;
			if (i_113_ != 0) {
				if (this.gatey == 300) {
					for (int i_117_ = 0; i_117_ < 9; i_117_++) {
						this.pgas[i_117_] = false;
						this.pgady[i_117_] = 0;
					}
					this.pgas[0] = true;
				}
				for (int i_118_ = 0; i_118_ < 9; i_118_++) {
					this.rd.drawImage(this.pgate,
					this.pgatx[i_118_], (this.pgaty[i_118_] + this.pgady[i_118_] - this.gatey),
					null);
					if (this.flatrstart == 6) {
						if (this.pgas[i_118_]) {
							this.pgady[i_118_] -= (80 + 100 / (i_118_ + 1) - Math.abs(this.pgady[i_118_])) / 3;
							if (this.pgady[i_118_] < -(70 + 100 / (i_118_ + 1))) {
								this.pgas[i_118_] = false;
								if (i_118_ != 8) this.pgas[i_118_ + 1] = true;
							}
						} else {
							this.pgady[i_118_] += (80 + 100 / (i_118_ + 1) - Math.abs(this.pgady[i_118_])) / 3;
							if (this.pgady[i_118_] > 0) this.pgady[i_118_] = 0;
						}
					}
				}
				if (this.gatey != 0) this.gatey -= 100;
				if (this.flatrstart == 6) {
					drawcs(355, "[ Car Locked ]", 210, 210, 210, 3);
					drawcs(375,
					new StringBuilder().append("This car unlocks when stage ").append(i_113_).append(" is completed...").toString(),
					255, 96, 0, 3);
				}
			} else {
				if (this.flatrstart == 6) {
					if (this.cfase == 10) {
						if ((this.cd).action == 13) {
							this.minsl = 36;
							this.maxsl = ((this.cd)
								.xnlocars) - 1;
							i_112_ = 36;
							(this.cd).action = 0;
							this.cfase = 11;
						}
						if ((this.cd).action == 12) {
							int i_119_ = ((this.cd)
								.loadlist);
							String string = "Top 20 Cars";
							String string_120_ = "Weekly";
							while (i_119_ > 6) {
								i_119_ -= 6;
								if (string_120_.equals("Semi-Annual")) string_120_ = "Annual";
								if (string_120_.equals("Monthly")) string_120_ = "Semi-Annual";
								if (string_120_.equals("Weekly")) string_120_ = "Monthly";
							}
							if (i_119_ == 1) string = new StringBuilder().append("").append(string_120_).append(" Top 20 Cars").toString();
							if (i_119_ == 2) string = new StringBuilder().append("").append(string_120_).append(" Top 20 Class A Cars").toString();
							if (i_119_ == 3) string = new StringBuilder().append("").append(string_120_).append(" Top 20 Class A & B Cars")
								.toString();
							if (i_119_ == 4) string = new StringBuilder().append("").append(string_120_).append(" Top 20 Class B Cars").toString();
							if (i_119_ == 5) string = new StringBuilder().append("").append(string_120_).append(" Top 20 Class B & C Cars")
								.toString();
							if (i_119_ == 6) string = new StringBuilder().append("").append(string_120_).append(" Top 20 Class C Cars").toString();
							drawprom(145, 170);
							drawcs(195, new StringBuilder().append("[  Loading ").append(string).append("  ]").toString(), 0, 0, 0, 3);
							if ((this.cd).nl > 0 && ((this.cd).nl <= 20)) drawcs(235,
							new StringBuilder().append("Loading :  ").append((
							this.cd)
								.loadnames[(
							this.cd).nl - 1])
								.append("").toString(),
							0, 0, 0, 3);
						}
						if ((this.cd).action == 11) {
							drawprom(145, 170);
							drawcs(195, "Loading List, Please Wait...", 0, 0,
							0, 3);
						}
						if ((this.cd).action == -1) {
							drawprom(145, 170);
							drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
							drawcs(225,
								"Unknown Error.  Please try again later.",
							0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i,
							i_104_, bool)) {
								(this.cd).action = 0;
								this.cfase = this.basefase;
							}
						}
						if ((this.cd).action == 0 || ((this.cd).action == 14) || ((this.cd).action == 15) || ((this.cd).action == 16) || ((this.cd).action == 17)) {
							drawprom(65, 250);
							if (drawcarb(true, null, " X ", 557, 70, i, i_104_,
							bool)) {
								(this.cd).action = 0;
								this.cfase = this.basefase;
							}
							drawcs(305,
								"The lists get updated every 24 hours!", 0,
							0, 0, 3);
							if (((this.cd).action == 14) || ((this.cd).action == 15) || ((this.cd).action == 16) || ((this.cd).action == 17)) {
								if (!bool && this.cntflock == 20) this.cntflock = 0;
								if ((this.cd).action == 14) drawcs(91, "Weekly Top 20 Cars", 0, 0, 0,
								3);
								if ((this.cd).action == 15) drawcs(91, "Monthly Top 20 Cars", 0, 0, 0,
								3);
								if ((this.cd).action == 16) drawcs(91, "Semi-Annual Top 20 Cars", 0, 0,
								0, 3);
								if ((this.cd).action == 17) drawcs(91, "Annual Top 20 Cars", 0, 0, 0,
								3);
								if (drawcarb(true, null,
									"   All Cars, All Classes   ",
								318, 105, i, i_104_, bool) && this.cntflock == 0) {
									(this.cd)
										.loadlist = 1 + ((
									this.cd).action - 14) * 6;
									(this.cd).action = 11;
									this.cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class A Cars", 337,
								135, i, i_104_, bool) && this.cntflock == 0) {
									(this.cd)
										.loadlist = 2 + ((
									this.cd).action - 14) * 6;
									(this.cd).action = 11;
									this.cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class A & B Cars",
								337, 165, i, i_104_, bool) && this.cntflock == 0) {
									(this.cd)
										.loadlist = 3 + ((
									this.cd).action - 14) * 6;
									(this.cd).action = 11;
									this.cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class B Cars", 337,
								195, i, i_104_, bool) && this.cntflock == 0) {
									(this.cd)
										.loadlist = 4 + ((
									this.cd).action - 14) * 6;
									(this.cd).action = 11;
									this.cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class B & C Cars",
								337, 225, i, i_104_, bool) && this.cntflock == 0) {
									(this.cd)
										.loadlist = 5 + ((
									this.cd).action - 14) * 6;
									(this.cd).action = 11;
									this.cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class C Cars", 337,
								255, i, i_104_, bool) && this.cntflock == 0) {
									(this.cd)
										.loadlist = 6 + ((
									this.cd).action - 14) * 6;
									(this.cd).action = 11;
									this.cd.sparkactionloader();
								}
							}
							if ((this.cd).action == 0) {
								drawcs(91,
									"Top 20 Most Added Public Custom Cars",
								0, 0, 0, 3);
								if (drawcarb(true, null, "  Weekly Top 20  ",
								338, 125, i, i_104_, bool))
								(this.cd).action = 14;
								if (drawcarb(true, null, "  Monthly Top 20  ",
								337, 165, i, i_104_, bool))
								(this.cd).action = 15;
								if (drawcarb(true, null,
									"  Semi-Annual Top 20  ", 321,
								205, i, i_104_, bool))
								(this.cd).action = 16;
								if (drawcarb(true, null, "  Annual Top 20  ",
								339, 245, i, i_104_, bool))
								(this.cd).action = 17;
								if (this.cntflock != 20) this.cntflock = 20;
							}
						}
					}
					if (this.cfase == 100) {
						if ((this.cd).action == -1) {
							drawprom(145, 170);
							drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
							drawcs(225,
								"Unknown Error.  Please try again later.",
							0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i,
							i_104_, bool)) {
								if (this.sc[0] >= 16 && ((this.cd)
									.lastload) == 2 && this.sc[0] < 36) this.cfase = 3;
								else this.cfase = 0;
							}
						}
						if ((this.cd).action == -2) {
							drawprom(145, 170);
							drawcs(195, "No account cars found.", 0, 0, 0, 3);
							drawcs(225,
							new StringBuilder().append("").append((this.cd)
								.viewname)
								.append(" does not have any published or added cars.")
								.toString(),
							0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i,
							i_104_, bool)) {
								if (this.sc[0] >= 16 && ((this.cd)
									.lastload) == 2 && this.sc[0] < 36) this.cfase = 3;
								else this.cfase = 0;
							}
						}
						if ((this.cd).action == 100) {
							(this.cd).action = 101;
							this.cd.sparkactionloader();
						}
						if ((this.cd).action == 101) {
							drawprom(145, 170);
							drawcs(195,
							new StringBuilder().append("Loading ")
								.append((this.cd)
								.viewname)
								.append("'s account cars, please wait...")
								.toString(),
							0, 0, 0, 3);
						}
						if ((this.cd).action == 102) {
							drawprom(145, 170);
							drawcs(195,
							new StringBuilder().append("Loading ")
								.append((this.cd)
								.viewname)
								.append("'s account cars, please wait...")
								.toString(),
							0, 0, 0, 3);
							if ((this.cd).nl > 0 && ((this.cd).nl <= 20)) drawcs(235,
							new StringBuilder().append("Loading :  ").append((
							this.cd)
								.loadnames[(
							this.cd).nl - 1])
								.append("").toString(),
							0, 0, 0, 3);
						}
						if ((this.cd).action == 103) {
							this.minsl = 36;
							this.maxsl = ((this.cd)
								.xnlocars) - 1;
							i_112_ = 36;
							(this.cd).action = 0;
							this.cfase = 101;
						}
					}
					if (this.cfase == 0 && this.testdrive != 1 && this.testdrive != 2 && this.gmode == 0) {
						int i_121_ = 95;
						int i_122_ = 5;
						if (this.multion != 0) {
							i_121_ = 185;
							i_122_ = 0;
						}
						if (this.multion == 0 && drawcarb(false, this.cmc, "", 95,
						70, i, i_104_, bool)) {
							if ((this.cd).lastload != 1) this.cfase = 1;
							else {
								this.minsl = 16;
								this.maxsl = ((this.cd)
									.nlcars) - 1;
								i_112_ = 16;
								this.cfase = 3;
							}
						}
						if (drawcarb(false, this.myc, "",
						i_121_, 105 + i_122_, i, i_104_, bool)) {
							if ((this.cd).lastload != 2) {
								this.cfase = 5;
								this.showtf = false;
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
								this.maxsl = ((this.cd)
									.nlocars) - 1;
								if ((this.onmsc >= this.minsl) && (this.onmsc <= this.maxsl)) i_112_ = this.onmsc;
								else i_112_ = 16;
								this.cfase = 3;
							}
						}
						if ((this.multion == 0 || this.onjoin == -1) && drawcarb(false, this.top20s, "",
						i_121_, (i_121_ - 95) / 7 + 25 + i_122_, i,
						i_104_, bool)) {
							(this.cd).action = 0;
							this.cfase = 10;
						}
						if (this.remi) this.remi = false;
					}
					if (this.cfase == -1) {
						if (this.autolog) {
							this.autolog = false;
							this.cfase = 5;
							(this.cd).action = 1;
							this.cd.sparkactionloader();
						} else if (((this.cd)
							.lastload) != 2) {
							this.cfase = 5;
							this.showtf = false;
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
							this.maxsl = ((this.cd).nlocars - 1);
							if ((this.onmsc >= this.minsl) && (this.onmsc <= this.maxsl)) i_112_ = this.onmsc;
							else i_112_ = 16;
							this.cfase = 3;
						}
					}
					if (this.cfase == 9) {
						drawprom(145, 95);
						drawcs(175,
							"Failed to remove car.  Unkown Error.  Try again laster.",
						0, 0, 0, 3);
						if (drawcarb(true, null, "   OK   ", 371, 195, i,
						i_104_, bool)) {
							this.minsl = 16;
							this.maxsl = ((this.cd).nlocars - 1);
							if ((this.onmsc >= this.minsl) && (this.onmsc <= this.maxsl)) i_112_ = this.onmsc;
							else i_112_ = 16;
							this.cfase = 3;
						}
					}
					if (this.cfase == 7) {
						if ((this.app).mycar.isShowing())
						(this.app).mycar.hide();
						drawprom(145, 95);
						drawcs(175, "Remove this car from your account?", 0, 0,
						0, 3);
						if (drawcarb(true, null, " Yes ", 354, 195, i, i_104_,
						bool)) {
							this.remi = true;
							this.minsl = 0;
							this.maxsl = 15;
							i_112_ = 15;
							this.cfase = 8;
							this.onmsc = this.sc[0];
							(this.cd).ac = this.sc[0];
							(this.cd).action = 10;
							this.cd.sparkactionloader();
						}
						if (drawcarb(true, null, " No ", 408, 195, i, i_104_,
						bool)) this.cfase = 3;
					}
					if (this.cfase == 3 && i_112_ == -1) {
						int i_123_ = 95;
						int i_124_ = 5;
						if (this.multion != 0) {
							i_123_ = 185;
							i_124_ = 0;
						}
						if (drawcarb(false, this.gac, "",
						i_123_, 105 + i_124_, i, i_104_, bool)) {
							this.minsl = 0;
							this.maxsl = 15;
							if ((this.onmsc >= this.minsl) && (this.onmsc <= this.maxsl)) i_112_ = this.onmsc;
							else i_112_ = 15;
							this.cfase = 0;
						}
						if (this.multion == 0) {
							if (!(this.app)
								.openm) {
								if (!(this.app)
									.mycar.isShowing()) {
									(this.app)
										.mycar.show();
									(this.app)
										.mycar.setState((this.cd)
										.include[this.sc[0] - 16]);
								}
							} else(this.app)
								.mycar.hide();
							this.rd.setColor(new Color(198, 179,
							129));
							this.rd.fillRoundRect(305, 302, 190,
							24, 7, 20);
							this.rd.setColor(new Color(0, 0,
							0));
							this.rd.drawRoundRect(305, 302, 190,
							24, 7, 20);
							this.app.movefield((this.app).mycar,
							334, 306, 150, 17);
							if ((this.app)
								.mycar.getState() != ((this.cd)
								.include[this.sc[0] - 16])) {
								(this.cd)
									.include[this.sc[0] - 16] = (this.app)
									.mycar.getState();
								this.app.requestFocus();
							}
						}
						if ((this.multion == 0 || this.onjoin == -1) && drawcarb(false, this.top20s, "",
						i_123_, (i_123_ - 95) / 7 + 25 + i_124_, i,
						i_104_, bool)) {
							(this.cd).action = 0;
							this.cfase = 10;
							if ((this.app)
								.mycar.isShowing())
							(this.app)
								.mycar.hide();
						}
						if ((this.cd).lastload == 2) {
							if (drawcarb(true, null, "X", 567, 135, i, i_104_,
							bool)) this.cfase = 7;
							this.rd.setFont(new Font("Arial", 1,
							12));
							this.ftm = this.rd.getFontMetrics();
							this.rd.setColor(new Color(0, 0,
							0));
							if (!(this.cd)
								.createdby[this.sc[0] - 16].equals(this.nickname)) bool_114_ = clink(((
							this.cd)
								.createdby[this.sc[0] - 16]),
							i, i_104_, bool);
							else this.rd.drawString("Created by You", 241, 160);
						}
						if (this.remi) this.remi = false;
						if (this.noclass) {
							drawprom(200, 95);
							this.rd.setFont(new Font("Arial", 1,
							13));
							this.ftm = this.rd.getFontMetrics();
							String string = "Class C";
							if (this.ontyp == 2) string = "Class B or C";
							if (this.ontyp == 3) string = "Class B";
							if (this.ontyp == 4) string = "Class A or B";
							if (this.ontyp == 5) string = "Class A";
							drawcs(230, new StringBuilder().append("You do not have a ").append(string).append(" car in your account cars.")
								.toString(), 0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 250, i,
							i_104_, bool)) this.noclass = false;
						}
					}
					if ((this.cfase == 11 || this.cfase == 101) && i_112_ == -1) {
						if ((this.cd).action == -9) {
							drawprom(145, 95);
							drawcs(175,
								"Unknown error!  Failed to add car.  Try again later.",
							0, 0, 0, 3);
							if (drawcarb(true, null, " OK ", 379, 195, i,
							i_104_, bool))
							(this.cd).action = 0;
						}
						if ((this.cd).action == -8) {
							drawprom(145, 95);
							drawcs(175,
								"Failed.  You already have 20 cars in your account!",
							0, 0, 0, 3);
							if (drawcarb(true, null, " OK ", 379, 195, i,
							i_104_, bool))
							(this.cd).action = 0;
						}
						if ((this.cd).action == -7) {
							drawprom(145, 95);
							drawcs(175, "You already have this car!", 0, 0, 0,
							3);
							if (drawcarb(true, null, " OK ", 379, 195, i,
							i_104_, bool))
							(this.cd).action = 0;
						}
						if ((this.cd).action == 7) {
							drawprom(145, 95);
							drawcs(175,
							new StringBuilder().append("").append((this.cd)
								.names[((this.cd)
								.ac)])
								.append(" has been successfully added to your cars!")
								.toString(),
							0, 0, 0, 3);
							if (drawcarb(true, null, " OK ", 379, 195, i,
							i_104_, bool))
							(this.cd).action = 0;
						}
						if ((this.cd).action == 6) {
							drawprom(145, 95);
							drawcs(195,
							new StringBuilder().append("Adding ").append((this.cd)
								.names[((this.cd)
								.ac)])
								.append(" to your cars...").toString(),
							0, 0, 0, 3);
						}
						int i_125_ = 95;
						int i_126_ = 5;
						if (this.multion != 0) {
							i_125_ = 185;
							i_126_ = 0;
						}
						if (this.onmsc >= 16 && (((this.cd).lastload == 2) || ((this.cd)
							.lastload) == -2)) {
							if (drawcarb(false, this.myc, "",
							i_125_, 105 + i_126_, i, i_104_,
							bool)) {
								if (((this.cd)
									.lastload) != 2) {
									this.cfase = 5;
									this.showtf = false;
									if (!this.logged) {
										(this.cd)
											.action = 0;
										(this.cd)
											.reco = -2;
										this.tcnt = 5;
										this.cntflock = 0;
									} else {
										(this.cd)
											.action = 3;
										this.cd.sparkactionloader();
									}
								} else {
									(this.cd).action = 0;
									this.minsl = 16;
									this.maxsl = ((this.cd)
										.nlocars) - 1;
									if ((this.onmsc >= this.minsl) && (this.onmsc <= this.maxsl)) i_112_ = this.onmsc;
									else i_112_ = 16;
									this.cfase = 3;
								}
								(this.app).moused = false;
							}
						} else if (drawcarb(false, this.gac, "",
						i_125_, 105 + i_126_, i, i_104_,
						bool)) {
							(this.cd).action = 0;
							this.minsl = 0;
							this.maxsl = 15;
							if ((this.onmsc >= this.minsl) && (this.onmsc <= this.maxsl)) i_112_ = this.onmsc;
							else i_112_ = 15;
							this.cfase = 0;
							(this.app).moused = false;
						}
						if (drawcarb(false, this.top20s, "",
						i_125_, (i_125_ - 95) / 7 + 25 + i_126_,
						i, i_104_, bool)) {
							(this.cd).action = 0;
							this.cfase = 10;
						}
						if ((this.cd).action == 0) {
							this.rd.setFont(new Font("Arial", 1,
							12));
							this.ftm = this.rd.getFontMetrics();
							this.rd.setColor(new Color(0, 0,
							0));
							if (!(this.cd)
								.createdby[this.sc[0] - 16].equals(this.nickname)) bool_114_ = clink(((
							this.cd)
								.createdby[this.sc[0] - 16]),
							i, i_104_, bool);
							else this.rd.drawString("Created by You", 241, 160);
							if (this.cfase != 101) {
								this.rd.setFont(new Font("Arial", 1, 11));
								this.rd.drawString(new StringBuilder().append("Added by :  ").append((this.cd)
									.adds[this.sc[0] - 36])
									.append(" Players").toString(),
								241, 180);
							}
						}
					}
					if (this.cfase == 5) {
						drawprom(145, 170);
						if ((this.cd).action == 5) {
							this.minsl = 16;
							this.maxsl = ((this.cd).nlocars - 1);
							if ((this.cd).inslot != -1) {
								this.onmsc = ((this.cd)
									.inslot);
								(this.cd).inslot = -1;
							}
							if ((this.onmsc >= this.minsl) && (this.onmsc <= this.maxsl)) i_112_ = this.onmsc;
							else i_112_ = 16;
							this.cfase = 3;
						}
						if ((this.cd).action == 4) {
							drawcs(195, "[  Loading Car  ]", 0, 0, 0, 3);
							drawcs(235,
							new StringBuilder().append("Loading :  ").append((this.app)
								.mcars.getSelectedItem())
								.append("").toString(),
							0, 0, 0, 3);
						}
						if ((this.cd).action == -2) {
							drawcs(195, "Unknown Connection Error", 0, 0, 0,
							3);
							drawcs(225,
								"Failed to connect to server, try again later!",
							0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i,
							i_104_, bool)) this.cfase = 0;
						}
						if ((this.cd).action == -1) {
							drawcs(195, "No published cars found...", 0, 0, 0,
							3);
							drawcs(225,
								"You have no added cars to your account yet!",
							0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i,
							i_104_, bool)) this.cfase = 0;
						}
						if ((this.cd).action == 2 || ((this.cd).action == 3)) {
							drawcs(195, "Loading your Account Cars list...", 0,
							0, 0, 3);
							if ((this.cd).action == 2) {
								this.nickname = (this.app)
									.tnick.getText();
								this.backlog = this.nickname;
								this.nickey = ((this.cd)
									.tnickey);
								this.clan = ((this.cd)
									.tclan);
								this.clankey = ((this.cd)
									.tclankey);
								this.app.setloggedcookie();
								this.logged = true;
								this.gotlog = true;
								if ((this.cd).reco == 0) this.acexp = 0;
								if ((this.cd).reco > 10) this.acexp = ((this.cd)
									.reco) - 10;
								if ((this.cd).reco == 3) this.acexp = -1;
								if ((this.cd).reco == 111) {
									if (!this.backlog.toLowerCase().equals(this.nickname.toLowerCase())) this.acexp = -3;
									else this.acexp = 0;
								}
								if (this.basefase == 0)
								(this.cd).action = 3;
								if (this.basefase == 11) {
									(this.cd).action = 6;
									this.cfase = 11;
								}
								if (this.basefase == 101) {
									(this.cd).action = 6;
									this.cfase = 101;
								}
							}
						}
						if ((this.cd).action == 1) drawcs(195, "Logging in to your account...", 0, 0,
						0, 3);
						if ((this.cd).action == 0) {
							if ((this.cd).reco == -5) drawcs(171,
								"Login to Add this Car to your Account",
							0, 0, 0, 3);
							if ((this.cd).reco == -2) drawcs(171,
								"Login to Retrieve your Account Cars",
							0, 0, 0, 3);
							if ((this.cd).reco == -1) drawcs(171,
								"Unable to connect to server, try again later!",
							0, 8, 0, 3);
							if ((this.cd).reco == 1) drawcs(171,
								"Sorry.  The Nickname you have entered is incorrect.",
							0, 0, 0, 3);
							if ((this.cd).reco == 2) drawcs(171,
								"Sorry.  The Password you have entered is incorrect.",
							0, 0, 0, 3);
							if (((this.cd).reco == -167) || ((this.cd).reco == -177)) {
								if ((this.cd).reco == -167) {
									this.nickname = (
									this.app)
										.tnick.getText();
									this.backlog = this.nickname;
									(this.cd).reco = -177;
								}
								drawcs(171,
									"You are currently using a trial account.",
								0, 0, 0, 3);
							}
							if ((this.cd).reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20)) drawcs(171, "Please enter your Nickname!", 0,
							0, 0, 3);
							if ((this.cd).reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20)) drawcs(171, "Please enter your Password!", 0,
							0, 0, 3);
							if (!this.showtf) {
								(this.app)
									.tnick.show();
								(this.app)
									.tnick.setBackground(new Color(206, 237, 255));
								if ((this.cd).reco != 1) {
									if (((this.cd)
										.reco) != 2)
									(this.app)
										.tnick.setText(this.nickname);
									(this.app)
										.tnick.setForeground(new Color(0, 0, 0));
								} else(this.app)
									.tnick.setForeground(new Color(255, 0, 0));
								(this.app)
									.tnick.requestFocus();
								(this.app)
									.tpass.show();
								(this.app)
									.tpass.setBackground(new Color(206, 237, 255));
								if ((this.cd).reco != 2) {
									if (!this.autolog)
									(this.app)
										.tpass.setText("");
									(this.app)
										.tpass.setForeground(new Color(0, 0, 0));
								} else(this.app)
									.tpass.setForeground(new Color(255, 0, 0));
								if (!(this.app)
									.tnick.getText().equals("") && ((this.cd)
									.reco) != 1)
								(this.app)
									.tpass.requestFocus();
								this.showtf = true;
							}
							this.rd.drawString("Nickname:",
							376 - this.ftm.stringWidth("Nickname:") - 14,
							201);
							this.rd.drawString("Password:",
							376 - this.ftm.stringWidth("Password:") - 14,
							231);
							this.app.movefieldd((this.app).tnick,
							376, 185, 129, 23, true);
							this.app.movefieldd((this.app).tpass,
							376, 215, 129, 23, true);
							if (this.tcnt < 30) {
								this.tcnt++;
								if (this.tcnt == 30) {
									if (((this.cd)
										.reco) == 2)
									(this.app)
										.tpass.setText("");
									(this.app)
										.tnick.setForeground(new Color(0, 0, 0));
									(this.app)
										.tpass.setForeground(new Color(0, 0, 0));
								}
							}
							if ((this.cd).reco != -177) {
								if (drawcarb(true, null, "       Login       ",
								347, 247, i, i_104_, bool) && this.tcnt > 5) {
									this.tcnt = 0;
									if (!(
									this.app)
										.tnick.getText().equals("") && !(
									this.app)
										.tpass.getText().equals("")) {
										this.autolog = false;
										(this.app)
											.tnick.hide();
										(this.app)
											.tpass.hide();
										this.app.requestFocus();
										(this.cd)
											.action = 1;
										this.cd.sparkactionloader();
									} else {
										if ((
										this.app)
											.tpass.getText().equals(""))
										(
										this.cd).reco = -4;
										if ((
										this.app)
											.tnick.getText().equals(""))
										(
										this.cd).reco = -3;
									}
								}
							} else if ((drawcarb(true, null,
								"  Upgrade to have your own cars!  ",
							284, 247, i, i_104_, bool)) && this.cntflock == 0) {
								this.app.editlink(((
								this)
									.nickname),
								true);
								this.cntflock = 100;
							}
							if (drawcarb(true, null, "  Cancel  ", 409, 282, i,
							i_104_, bool)) {
								(this.app)
									.tnick.hide();
								(this.app)
									.tpass.hide();
								this.app.requestFocus();
								this.cfase = this.basefase;
							}
							if (drawcarb(true, null, "  Register!  ", 316, 282,
							i, i_104_, bool)) {
								if (this.cntflock == 0) {
									this.app.reglink();
									this.cntflock = 100;
								}
							} else if (this.cntflock != 0) this.cntflock--;
						}
					}
					if (this.cfase == 4) {
						drawprom(145, 150);
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.drawString("Failed to find any ready car in your \u2018mycars\u2019 folder!",
						215, 175);
						this.rd.drawString("Please \u2018Test Drive\u2019 your cars in the Car Maker to make",
						215, 215);
						this.rd.drawString("sure they are ready.", 215, 235);
						if (drawcarb(true, null, "   OK   ", 371, 255, i,
						i_104_, bool)) this.cfase = 0;
					}
					if (this.cfase == 2) {
						drawprom(165, 70);
						drawcs(205, "Loading Car Maker Cars...", 0, 0, 0, 3);
						this.app.repaint();
						this.cd.loadcarmaker();
						if ((this.cd).nlcars > 16) {
							this.minsl = 16;
							this.maxsl = ((this.cd).nlcars - 1);
							i_112_ = 16;
							this.cfase = 3;
						} else this.cfase = 4;
					}
					if (this.cfase == 1) {
						drawprom(145, 170);
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.drawString("The game will now load all the cars that can be loaded",
						215, 170);
						this.rd.drawString("from your \u2018mycars\u2019 folder.", 215, 190);
						this.rd.drawString("If a car is not loaded, then it is not ready (not finished).",
						215, 210);
						this.rd.drawString("Perform a \u2018Test Drive\u2019 on any car to see if it is ready or not.",
						215, 230);
						this.rd.drawString("The maximum number of cars that can be loaded is  40 !",
						215, 260);
						if (drawcarb(true, null, "   OK   ", 371, 275, i,
						i_104_, bool)) this.cfase = 2;
					}
					this.rd.setFont(new Font("Arial", 1, 11));
					this.ftm = this.rd.getFontMetrics();
					this.rd.setColor(new Color(181, 120, 40));
					this.rd.drawString("Top Speed:", 98, 343);
					this.rd.drawImage(this.statb,
					162, 337, null);
					this.rd.drawString("Acceleration:", 88,
					358);
					this.rd.drawImage(this.statb,
					162, 352, null);
					this.rd.drawString("Handling:", 110, 373);
					this.rd.drawImage(this.statb,
					162, 367, null);
					this.rd.drawString("Stunts:", 495, 343);
					this.rd.drawImage(this.statb,
					536, 337, null);
					this.rd.drawString("Strength:", 483, 358);
					this.rd.drawImage(this.statb,
					536, 352, null);
					this.rd.drawString("Endurance:", 473, 373);
					this.rd.drawImage(this.statb,
					536, 367, null);
					this.rd.setColor(new Color(0, 0, 0));
					float f = ((float)(((this.cd)
						.swits[this.sc[0]][2]) - 220) / 90.0F);
					if ((double) f < 0.2) f = 0.2F;
					this.rd.fillRect((int)(162.0F + 156.0F * f),
					337, (int)(156.0F * (1.0F - f) + 1.0F),
					7);
					f = (((this.cd).acelf[this.sc[0]][1]) * ((this.cd).acelf[this.sc[0]][0]) * ((this.cd).acelf[this.sc[0]][2]) * ((this.cd).grip[this.sc[0]]) / 7700.0F);
					if (f > 1.0F) f = 1.0F;
					this.rd.fillRect((int)(162.0F + 156.0F * f),
					352, (int)(156.0F * (1.0F - f) + 1.0F),
					7);
					f = ((this.cd).dishandle[this.sc[0]]);
					this.rd.fillRect((int)(162.0F + 156.0F * f),
					367, (int)(156.0F * (1.0F - f) + 1.0F),
					7);
					f = (((float)((this.cd).airc[this.sc[0]]) * ((this.cd).airs[this.sc[0]]) * ((this.cd).bounce[this.sc[0]])) + 28.0F) / 139.0F;
					if (f > 1.0F) f = 1.0F;
					this.rd.fillRect((int)(536.0F + 156.0F * f),
					337, (int)(156.0F * (1.0F - f) + 1.0F),
					7);
					float f_127_ = 0.5F;
					f = (((this.cd).moment[this.sc[0]]) + f_127_) / 2.6F;
					if (f > 1.0F) f = 1.0F;
					this.rd.fillRect((int)(536.0F + 156.0F * f),
					352, (int)(156.0F * (1.0F - f) + 1.0F),
					7);
					f = ((this.cd).outdam[this.sc[0]]);
					this.rd.fillRect((int)(536.0F + 156.0F * f),
					367, (int)(156.0F * (1.0F - f) + 1.0F),
					7);
					this.rd.drawImage(this.statbo, 162, 337, null);
					this.rd.drawImage(this.statbo, 162, 352, null);
					this.rd.drawImage(this.statbo, 162, 367, null);
					this.rd.drawImage(this.statbo, 536, 337, null);
					this.rd.drawImage(this.statbo, 536, 352, null);
					this.rd.drawImage(this.statbo, 536, 367, null);
					if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) {
						this.rd.setFont(new Font("Arial", 1,
						13));
						this.ftm = this.rd.getFontMetrics();
						String string = "Class C";
						if (((this.cd).cclass[this.sc[0]]) == 1) string = "Class B & C";
						if (((this.cd).cclass[this.sc[0]]) == 2) string = "Class B";
						if (((this.cd).cclass[this.sc[0]]) == 3) string = "Class A & B";
						if (((this.cd).cclass[this.sc[0]]) == 4) string = "Class A";
						if (this.kbload < 7) {
							this.rd.setColor(new Color(0, 0,
							0));
							this.kbload++;
						} else {
							this.rd.setColor(new Color(176, 41,
							0));
							this.kbload = 0;
						}
						if (this.cfase != 10 || (((this.cd).action != 0) && ((this.cd).action < 14))) this.rd.drawString(string,
						549 - this.ftm.stringWidth(string) / 2,
						95);
						this.rd.setFont(new Font("Arial", 1,
						12));
						this.ftm = this.rd.getFontMetrics();
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.drawString("1st Color", 100,
						55);
						this.rd.drawString("2nd Color", 649,
						55);
						this.rd.setFont(new Font("Arial", 1,
						10));
						this.ftm = this.rd.getFontMetrics();
						this.rd.drawString("Hue  | ", 97, 70);
						this.rd.drawImage(this.brt, 137, 63, null);
						this.rd.drawString("Hue  | ", 647, 70);
						this.rd.drawImage(this.brt, 687, 63, null);
						this.rd.drawString("Intensity", 121,
						219);
						this.rd.drawString("Intensity", 671,
						219);
						this.rd.drawString("Reset", 110, 257);
						this.rd.drawString("Reset", 660, 257);
						for (int i_128_ = 0; i_128_ < 161; i_128_++) {
							this.rd.setColor(Color.getHSBColor((float)((double)(float) i_128_ * 0.00625),
							1.0F, 1.0F));
							this.rd.drawLine(102, 75 + i_128_,
							110, 75 + i_128_);
							if (i_128_ <= 128) {
								this.rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float)(1.0 - ((double)(float) i_128_ * 0.00625))));
								this.rd.drawLine(137,
								75 + i_128_,
								145,
								75 + i_128_);
							}
							this.rd.setColor(Color.getHSBColor((float)((double)(float) i_128_ * 0.00625),
							1.0F, 1.0F));
							this.rd.drawLine(652, 75 + i_128_,
							660, 75 + i_128_);
							if (i_128_ <= 128) {
								this.rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float)(1.0 - ((double)(float) i_128_ * 0.00625))));
								this.rd.drawLine(687,
								75 + i_128_,
								695,
								75 + i_128_);
							}
						}
						for (int i_129_ = 0; i_129_ < 40; i_129_++) {
							this.rd.setColor(Color.getHSBColor(this.arnp[0], (float)((double)(float) i_129_ * 0.025),
							1.0F - this.arnp[2]));
							this.rd.drawLine(121 + i_129_, 224,
							121 + i_129_, 230);
							this.rd.setColor(Color.getHSBColor(this.arnp[3], (float)((double)(float) i_129_ * 0.025),
							1.0F - this.arnp[5]));
							this.rd.drawLine(671 + i_129_, 224,
							671 + i_129_, 230);
						}
						this.rd.drawImage(this.arn, 110,
						71 + (int)(this.arnp[0] * 160.0F),
						null);
						this.rd.drawImage(this.arn, 145,
						71 + (int)(this.arnp[2] * 160.0F),
						null);
						this.rd.drawImage(this.arn, 660,
						71 + (int)(this.arnp[3] * 160.0F),
						null);
						this.rd.drawImage(this.arn, 695,
						71 + (int)(this.arnp[5] * 160.0F),
						null);
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.fillRect(120 + (int)(this.arnp[1] * 40.0F),
						222, 3, 3);
						this.rd.drawLine(121 + (int)(this.arnp[1] * 40.0F),
						224,
						121 + (int)(this.arnp[1] * 40.0F),
						230);
						this.rd.fillRect(120 + (int)(this.arnp[1] * 40.0F),
						230, 3, 3);
						this.rd.fillRect(670 + (int)(this.arnp[4] * 40.0F),
						222, 3, 3);
						this.rd.drawLine(671 + (int)(this.arnp[4] * 40.0F),
						224,
						671 + (int)(this.arnp[4] * 40.0F),
						230);
						this.rd.fillRect(670 + (int)(this.arnp[4] * 40.0F),
						230, 3, 3);
						if (bool) {
							if (this.mouson == -1) {
								if (i > 96 && i < 152 && i_104_ > 248 && i_104_ < 258) {
									float[] fs = new float[3];
									Color.RGBtoHSB((contos[(this.sc[0])]).fcol[0], (contos[(this.sc[0])]).fcol[1], (contos[(this.sc[0])]).fcol[2],
									fs);
									this.arnp[0] = fs[0];
									this.arnp[1] = fs[1];
									this.arnp[2] = 1.0F - fs[2];
								}
								if (i > 646 && i < 702 && i_104_ > 248 && i_104_ < 258) {
									float[] fs = new float[3];
									Color.RGBtoHSB((contos[(this.sc[0])]).scol[0], (contos[(this.sc[0])]).scol[1], (contos[(this.sc[0])]).scol[2],
									fs);
									this.arnp[3] = fs[0];
									this.arnp[4] = fs[1];
									this.arnp[5] = 1.0F - fs[2];
								}
								this.mouson = -2;
								if (i > 119 && i < 163 && i_104_ > 222 && i_104_ < 232) this.mouson = 1;
								if (i > 669 && i < 713 && i_104_ > 222 && i_104_ < 232) this.mouson = 4;
								if (i > 98 && i < 122 && i_104_ > 69 && i_104_ < 241 && this.mouson == -2) this.mouson = 0;
								if (i > 133 && i < 157 && i_104_ > 69 && i_104_ < 209 && this.mouson == -2) this.mouson = 2;
								if (i > 648 && i < 672 && i_104_ > 69 && i_104_ < 241 && this.mouson == -2) this.mouson = 3;
								if (i > 683 && i < 707 && i_104_ > 69 && i_104_ < 209 && this.mouson == -2) this.mouson = 5;
							}
						} else if (this.mouson != -1) this.mouson = -1;
						if (this.mouson == 0 || this.mouson == 2 || this.mouson == 3 || this.mouson == 5) {
							this.arnp[(this.mouson)] = (float)((double)((float) i_104_ - 75.0F) * 0.00625);
							if (this.mouson == 2 || this.mouson == 5) {
								if ((double)(this.arnp[this.mouson]) > 0.8) this.arnp[this.mouson] = 0.8F;
							} else if ((this.arnp[this.mouson]) > 1.0F) this.arnp[(this.mouson)] = 1.0F;
							if ((this.arnp[this.mouson]) < 0.0F) this.arnp[(this.mouson)] = 0.0F;
						}
						if (this.mouson == 1) {
							this.arnp[(this.mouson)] = (float)((double)((float) i - 121.0F) * 0.025);
							if ((this.arnp[this.mouson]) > 1.0F) this.arnp[(this.mouson)] = 1.0F;
							if ((this.arnp[this.mouson]) < 0.0F) this.arnp[(this.mouson)] = 0.0F;
						}
						if (this.mouson == 4) {
							this.arnp[(this.mouson)] = (float)((double)((float) i - 671.0F) * 0.025);
							if ((this.arnp[this.mouson]) > 1.0F) this.arnp[(this.mouson)] = 1.0F;
							if ((this.arnp[this.mouson]) < 0.0F) this.arnp[(this.mouson)] = 0.0F;
						}
						if (this.cfase != 10 && this.cfase != 5 && i_112_ == -1) {
							Color color = (Color.getHSBColor(this.arnp[0],
							this.arnp[1],
							1.0F - this.arnp[2]));
							Color color_130_ = (Color.getHSBColor(this.arnp[3],
							this.arnp[4],
							1.0F - this.arnp[5]));
							for (int i_131_ = 0;
							i_131_ < (contos[(this.sc[0])]).npl;
							i_131_++) {
								if ((
								(contos[(this.sc[0])]).p[i_131_]).colnum == 1) {
									(
									(contos[(this.sc[0])]).p[i_131_]).hsb[0] = this.arnp[0];
									(
									(contos[(this.sc[0])]).p[i_131_]).hsb[1] = this.arnp[1];
									(
									(contos[(this.sc[0])]).p[i_131_]).hsb[2] = 1.0F - this.arnp[2];
									(
									(contos[(this.sc[0])]).p[i_131_]).c[0] = color.getRed();
									(
									(contos[(this.sc[0])]).p[i_131_]).c[1] = color.getGreen();
									(
									(contos[(this.sc[0])]).p[i_131_]).c[2] = color.getBlue();
									(
									(contos[(this.sc[0])]).p[i_131_]).oc[0] = color.getRed();
									(
									(contos[(this.sc[0])]).p[i_131_]).oc[1] = color.getGreen();
									(
									(contos[(this.sc[0])]).p[i_131_]).oc[2] = color.getBlue();
								}
								if ((
								(contos[(this.sc[0])]).p[i_131_]).colnum == 2) {
									(
									(contos[(this.sc[0])]).p[i_131_]).hsb[0] = this.arnp[3];
									(
									(contos[(this.sc[0])]).p[i_131_]).hsb[1] = this.arnp[4];
									(
									(contos[(this.sc[0])]).p[i_131_]).hsb[2] = 1.0F - this.arnp[5];
									(
									(contos[(this.sc[0])]).p[i_131_]).c[0] = color_130_.getRed();
									(
									(contos[(this.sc[0])]).p[i_131_]).c[1] = color_130_.getGreen();
									(
									(contos[(this.sc[0])]).p[i_131_]).c[2] = color_130_.getBlue();
									(
									(contos[(this.sc[0])]).p[i_131_]).oc[0] = color_130_.getRed();
									(
									(contos[(this.sc[0])]).p[i_131_]).oc[1] = color_130_.getGreen();
									(
									(contos[(this.sc[0])]).p[i_131_]).oc[2] = color_130_.getBlue();
								}
							}
						}
					}
				}
				if (!this.remi && this.cfase != 10 && this.cfase != 11 && this.cfase != 100 && this.cfase != 101) this.rd.drawImage((this.contin[(this.pcontin)]),
				355, 385, null);
				else {
					if (this.cfase == 11 && drawcarb(true, null, "Add to My Cars", 345, 385, i,
					i_104_, bool) && (this.cd).action == 0) {
						(this.cd).ac = this.sc[0];
						if (this.logged) {
							(this.cd).action = 6;
							this.cd.sparkactionloader();
						} else {
							(this.cd).reco = -5;
							this.cfase = 5;
							this.showtf = false;
						}
					}
					if (this.cfase == 101 && i_112_ == -1) {
						if (((this.cd).publish[this.sc[0] - 16]) == 1 || ((this.cd).publish[this.sc[0] - 16]) == 2) {
							if (drawcarb(true, null, "Add to My Cars", 345,
							385, i, i_104_, bool) && ((this.cd).action == 0)) {
								(this.cd).ac = this.sc[0];
								if (this.logged) {
									(this.cd).action = 6;
									this.cd.sparkactionloader();
								} else {
									(this.cd).reco = -5;
									this.cfase = 5;
									this.showtf = false;
								}
							}
						} else {
							this.rd.setFont(new Font("Arial", 1,
							12));
							this.ftm = this.rd.getFontMetrics();
							drawcs(405, "Private Car", 193, 106, 0, 3);
						}
					}
				}
			}
		} else {
			if (this.cfase == 11 || this.cfase == 101)
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
					if (this.nextc >= 20) {
						this.sc[0] = this.nextc - 20;
						this.lsc = -1;
					}
					if (this.nextc == 1) {
						this.sc[0]++;
						if (this.gmode == 1) {
							if (this.sc[0] == 7) this.sc[0] = 11;
							if (this.sc[0] == 12) this.sc[0] = 14;
						}
						if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5) {
							for ( /**/ ;
							((this.sc[0] < this.maxsl) && Math.abs(((
							this.cd)
								.cclass[this.sc[0]]) - (this.ontyp - 1)) > 1);
							this.sc[0]++) {
								/* empty */
							}
						}
					}
					if (this.nextc == -1) {
						this.sc[0]--;
						if (this.gmode == 1) {
							if (this.sc[0] == 13) this.sc[0] = 11;
							if (this.sc[0] == 10) this.sc[0] = 6;
						}
						if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5) {
							for ( /**/ ;
							((this.sc[0] > this.minsl) && Math.abs(((
							this.cd)
								.cclass[this.sc[0]]) - (this.ontyp - 1)) > 1);
							this.sc[0]--) {
								/* empty */
							}
						}
					}
					if (this.cfase == 3 && (this.cd).lastload == 2)
					(this.app).mcars.select((this.cd).names[this.sc[0]]);
					(contos[this.sc[0]]).z = 950;
					(contos[this.sc[0]]).y = (-34 - (contos[this.sc[0]]).grat - 1100);
					(contos[this.sc[0]]).x = 0;
					(contos[this.sc[0]]).zy = 0;
				}
				(contos[this.sc[0]]).y += 100;
			}
			this.flipo--;
		}
		if (this.cfase == 0 || this.cfase == 3 || this.cfase == 11 || this.cfase == 101) {
			this.basefase = this.cfase;
			if (i_112_ != -1) {
				if (this.flatrstart > 1) this.flatrstart = 0;
				this.nextc = i_112_ + 20;
				this.flipo = 20;
			}
			if ((control).right) {
				(control).right = false;
				if (this.sc[0] != this.maxsl && this.flipo == 0) {
					if (this.flatrstart > 1) this.flatrstart = 0;
					this.nextc = 1;
					this.flipo = 20;
				}
			}
			if ((control).left) {
				(control).left = false;
				if (this.sc[0] != this.minsl && this.flipo == 0) {
					if (this.flatrstart > 1) this.flatrstart = 0;
					this.nextc = -1;
					this.flipo = 20;
				}
			}
			if (this.cfase != 11 && this.cfase != 101 && i_113_ == 0 && this.flipo < 10 && ((control).handb || (control).enter)) {
				(this.m).crs = false;
				((this.app).mcars).show = false;
				if (this.multion != 0) {
					this.fase = 1177;
					this.intertrack.stop();
				} else if (this.testdrive != 3 && this.testdrive != 4) this.fase = 3;
				else this.fase = -22;
				if (this.sc[0] < 16 || (this.cd).lastload == 2) this.app.setcarcookie(this.sc[0], ((this.cd).names[this.sc[0]]),
				this.arnp, this.gmode,
				this.unlocked,
				this.mtop);
				if ((this.cd).haltload != 0) {
					if ((this.cd).haltload == 2)
					(this.cd).lcardate[1] = 0;
					(this.cd).lcardate[0] = 0;
					(this.cd).haltload = 0;
				}
				if (this.gmode == 0) this.osc = this.sc[0];
				if (this.gmode == 1) this.scm[0] = this.sc[0];
				if (this.gmode == 2) this.scm[1] = this.sc[0];
				if ((this.app).mycar.isShowing())
				(this.app).mycar.hide();
				this.flexpix = null;
				(control).handb = false;
				(control).enter = false;
			}
		} else {
			this.pback = 0;
			this.pnext = 0;
			this.pcontin = 0;
			if (this.cfase == 8 && i_112_ != -1) {
				if (this.flatrstart > 1) this.flatrstart = 0;
				this.nextc = i_112_ + 20;
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
		if ((control).handb || (control).enter) {
			(control).handb = false;
			(control).enter = false;
		}
		if (bool_114_) {
			(this.app).mouses = 0;
			this.onviewpro = true;
			(this.cd).viewname = ((this.cd).createdby[this.sc[0] - 16]);
			(this.m).crs = false;
			this.fase = 1177;
			this.intertrack.stop();
			this.sc[0] = this.onmsc;
			if ((this.sc[0] >= 16 && (this.cd).lastload != 2) || this.sc[0] >= 36) this.sc[0] = 15;
			this.osc = this.sc[0];
			this.multion = 1;
			this.gmode = 0;
			if ((this.app).mycar.isShowing())
			(this.app).mycar.hide();
			this.flexpix = null;
			(control).handb = false;
			(control).enter = false;
		}
	}

	public void colorCar(ContO conto, int i) {
		if (this.plnames[i].indexOf("MadBot") == -1) {
			for (int i_132_ = 0; i_132_ < (conto).npl; i_132_++) {
				if (((conto).p[i_132_]).colnum == 1) {
					Color color = Color.getHSBColor(this.allrnp[i][0],
					this.allrnp[i][1],
					1.0F - (this.allrnp[i][2]));
					((conto).p[i_132_]).oc[0] = color.getRed();
					((conto).p[i_132_]).oc[1] = color.getGreen();
					((conto).p[i_132_]).oc[2] = color.getBlue();
				}
				if (((conto).p[i_132_]).colnum == 2) {
					Color color = Color.getHSBColor(this.allrnp[i][3],
					this.allrnp[i][4],
					1.0F - (this.allrnp[i][5]));
					((conto).p[i_132_]).oc[0] = color.getRed();
					((conto).p[i_132_]).oc[1] = color.getGreen();
					((conto).p[i_132_]).oc[2] = color.getBlue();
				}
			}
		} else {
			for (int i_133_ = 0; i_133_ < (conto).npl; i_133_++) {
				if (((conto).p[i_133_]).colnum == 1) {
					((conto).p[i_133_]).oc[0] = (conto).fcol[0];
					((conto).p[i_133_]).oc[1] = (conto).fcol[1];
					((conto).p[i_133_]).oc[2] = (conto).fcol[2];
				}
				if (((conto).p[i_133_]).colnum == 2) {
					((conto).p[i_133_]).oc[0] = (conto).scol[0];
					((conto).p[i_133_]).oc[1] = (conto).scol[1];
					((conto).p[i_133_]).oc[2] = (conto).scol[2];
				}
			}
		}
	}

	public boolean clink(String string, int i, int i_134_, boolean bool) {
		boolean bool_135_ = false;
		this.rd.drawString(new StringBuilder().append("Created by :  ").append(string).append("").toString(),
		241, 160);
		int i_136_ = this.ftm.stringWidth(string);
		int i_137_ = (241 + this.ftm.stringWidth(new StringBuilder().append("Created by :  ")
			.append(string).append("").toString()) - i_136_);
		this.rd.drawLine(i_137_, 162, i_137_ + i_136_ - 2, 162);
		if (i > i_137_ - 2 && i < i_137_ + i_136_ && i_134_ > 147 && i_134_ < 164) {
			if (bool) bool_135_ = true;
			if (this.waitlink != 1) {
				this.app.setCursor(new Cursor(12));
				this.waitlink = 1;
			}
		} else if (this.waitlink != 0) {
			this.app.setCursor(new Cursor(0));
			this.waitlink = 0;
		}
		return bool_135_;
	}

	public void drawprom(int i, int i_138_) {
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.76F));
		this.rd.setColor(new Color(129, 203, 237));
		this.rd.fillRoundRect(205, i, 390, i_138_, 30, 30);
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.drawRoundRect(205, i, 390, i_138_, 30, 30);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
	}

	public void drawdprom(int i, int i_139_) {
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.9F));
		this.rd.setColor(new Color(129, 203, 237));
		this.rd.fillRoundRect(205, i, 390, i_139_, 30, 30);
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.drawRoundRect(205, i, 390, i_139_, 30, 30);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
	}

	public void drawlprom(int i, int i_140_) {
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.5F));
		this.rd.setColor(new Color(129, 203, 237));
		this.rd.fillRoundRect(277, i, 390, i_140_, 30, 30);
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.drawRoundRect(277, i, 390, i_140_, 30, 30);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
	}

	public void finish(CheckPoints checkpoints, ContO[] contos,
	Control control, int i, int i_141_, boolean bool) {
		if (!this.badmac) this.rd.drawImage(this.fleximg, 0, 0,
		null);
		else {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
			this.rd.fillRect(0, 0, 800, 450);
			this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		}
		this.rd.setFont(new Font("Arial", 1, 11));
		this.ftm = this.rd.getFontMetrics();
		int i_142_ = 0;
		String string = ":";
		if ((checkpoints).stage > 0) {
			int i_143_ = (checkpoints).stage;
			if (i_143_ > 10) i_143_ -= 10;
			string = new StringBuilder().append(" ").append(i_143_).append("!").toString();
		}
		if (this.multion < 3) {
			if (this.winner) {
				this.rd.drawImage(this.congrd,
				265, 87, null);
				drawcs(137,
				new StringBuilder().append("You Won!  At Stage").append(string).append("").toString(),
				255, 161, 85, 3);
				drawcs(154, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
				i_142_ = 154;
			} else {
				this.rd.drawImage(this.gameov,
				315, 117, null);
				if (this.multion != 0 && (this.forstart == 700 || this.discon == 240)) {
					drawcs(167, "Sorry, You where Disconnected from Game!",
					255, 161, 85, 3);
					drawcs(184, "Please check your connection!", 255, 115, 0,
					3);
				} else {
					drawcs(167, new StringBuilder().append("You Lost!  At Stage").append(string).append("").toString(), 255, 161, 85, 3);
					drawcs(184, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
					i_142_ = 184;
				}
			}
		} else {
			this.rd.drawImage(this.gameov, 315,
			117, null);
			drawcs(167, new StringBuilder().append("Finished Watching Game!  At Stage").append(string).append("").toString(), 255, 161, 85, 3);
			drawcs(184, new StringBuilder().append("").append((checkpoints).name).append("").toString(), 255, 115, 0, 3);
			i_142_ = 184;
		}
		if (this.winner && this.multion == 0 && this.gmode != 0 && (((checkpoints).stage == ((this.unlocked[this.gmode - 1]) + (this.gmode - 1) * 10)) || (checkpoints).stage == 27)) {
			int i_144_ = 0;
			int i_145_ = 0;
			this.pin = 60;
			if (this.gmode == 1) {
				if ((checkpoints).stage == 2) {
					i_144_ = 5;
					i_145_ = 365;
					this.pin = -20;
					this.scm[0] = 5;
				}
				if ((checkpoints).stage == 4) {
					i_144_ = 6;
					i_145_ = 320;
					this.pin = -20;
					this.scm[0] = 6;
				}
				if ((checkpoints).stage == 6) {
					i_144_ = 11;
					i_145_ = 326;
					this.pin = -20;
					this.scm[0] = 11;
				}
				if ((checkpoints).stage == 8) {
					i_144_ = 14;
					i_145_ = 350;
					this.pin = -20;
					this.scm[0] = 14;
				}
				if ((checkpoints).stage == 10) {
					i_144_ = 15;
					i_145_ = 370;
					this.pin = -20;
					this.scm[0] = 15;
				}
			}
			if (this.gmode == 2) {
				if ((checkpoints).stage == 12) {
					i_144_ = 8;
					i_145_ = 365;
					this.pin = -20;
					this.scm[1] = 8;
				}
				if ((checkpoints).stage == 14) {
					i_144_ = 9;
					i_145_ = 320;
					this.pin = -20;
					this.scm[1] = 9;
				}
				if ((checkpoints).stage == 16) {
					i_144_ = 10;
					i_145_ = 370;
					this.pin = -20;
					this.scm[1] = 10;
				}
				if ((checkpoints).stage == 18) {
					i_144_ = 11;
					i_145_ = 326;
					this.pin = -20;
					this.scm[1] = 11;
				}
				if ((checkpoints).stage == 20) {
					i_144_ = 12;
					i_145_ = 310;
					this.pin = -20;
					this.scm[1] = 12;
				}
				if ((checkpoints).stage == 22) {
					i_144_ = 13;
					i_145_ = 310;
					this.pin = -20;
					this.scm[1] = 13;
				}
				if ((checkpoints).stage == 24) {
					i_144_ = 14;
					i_145_ = 350;
					this.pin = -20;
					this.scm[1] = 14;
				}
				if ((checkpoints).stage == 26) {
					i_144_ = 15;
					i_145_ = 370;
					this.pin = -20;
					this.scm[1] = 15;
				}
			}
			if ((checkpoints).stage != 27) {
				this.rd.setFont(new Font("Arial", 1, 13));
				this.ftm = this.rd.getFontMetrics();
				if (this.aflk) drawcs(200 + this.pin,
				new StringBuilder().append("Stage ").append((checkpoints).stage + 1 - (this.gmode - 1) * 10)
					.append(" is now unlocked!").toString(),
				196, 176, 0, 3);
				else drawcs(200 + this.pin,
				new StringBuilder().append("Stage ").append((checkpoints).stage + 1 - (this.gmode - 1) * 10)
					.append(" is now unlocked!").toString(),
				255, 247, 165, 3);
				if (i_144_ != 0) {
					if (this.aflk) drawcs(200, "And:", 196, 176, 0, 3);
					else drawcs(200, "And:", 255, 247, 165, 3);
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
					(contos[i_144_]).y = i_145_;
					(this.m).crs = true;
					(this.m).x = -400;
					(this.m).y = 0;
					(this.m).z = -50;
					(this.m).xz = 0;
					(this.m).zy = 0;
					(this.m).ground = 2470;
					(contos[i_144_]).z = 1000;
					(contos[i_144_]).x = 0;
					(contos[i_144_]).xz += 5;
					(contos[i_144_]).zy = 0;
					(contos[i_144_]).wzy -= 10;
					this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_OFF);
					contos[i_144_].d(this.rd);
					this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
					if (Math.random() < 0.5) {
						this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
						this.rd.setColor(new Color(236, 226,
						202));
						for (int i_146_ = 0; i_146_ < 30; i_146_++)
						this.rd.drawLine(230,
						215 + 4 * i_146_,
						569,
						215 + 4 * i_146_);
						this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
					}
					String string_147_ = "";
					if (i_144_ == 13) string_147_ = " ";
					if (this.aflk) drawcs(320,
					new StringBuilder().append("").append((this.cd).names[i_144_])
						.append("").append(string_147_).append(" has been unlocked!").toString(),
					196, 176, 0, 3);
					else drawcs(320,
					new StringBuilder().append("").append((this.cd).names[i_144_])
						.append("").append(string_147_).append(" has been unlocked!").toString(),
					255, 247, 165, 3);
					this.pin = 140;
				}
				this.rd.setFont(new Font("Arial", 1, 11));
				this.ftm = this.rd.getFontMetrics();
				drawcs(220 + this.pin, "GAME SAVED", 230, 167,
				0, 3);
				if (this.pin == 60) this.pin = 30;
				else this.pin = 0;
			} else {
				this.rd.setFont(new Font("Arial", 1, 13));
				this.ftm = this.rd.getFontMetrics();
				if (this.aflk) drawcs(180, new StringBuilder().append("Woohoooo you finished NFM").append(this.gmode).append(" !!!").toString(), 144, 167, 255, 3);
				else drawcs(180, new StringBuilder().append("Woohoooo you finished NFM").append(this.gmode).append(" !!!").toString(), 228, 240, 255, 3);
				if (this.aflk) drawcs(210, "You're Awesome!", 144, 167, 255, 3);
				else drawcs(212, "You're Awesome!", 228, 240, 255, 3);
				if (this.aflk) drawcs(240, "You're truly a RADICAL GAMER!", 144, 167, 255,
				3);
				else drawcs(240, "You're truly a RADICAL GAMER!", 255, 100, 100,
				3);
				this.rd.setColor(new Color(0, 0, 0));
				this.rd.fillRect(0, 255, 800, 62);
				this.rd.drawImage((this.radicalplay), (this.radpx + (int)(8.0 * Math.random() - 4.0)),
				255, null);
				if (this.radpx != 212) {
					this.radpx += 40;
					if (this.radpx > 800) this.radpx = -468;
				}
				if (this.flipo == 40) this.radpx = 213;
				this.flipo++;
				if (this.flipo == 70) this.flipo = 0;
				if (this.radpx == 212) {
					this.rd.setFont(new Font("Arial", 1, 11));
					this.ftm = this.rd.getFontMetrics();
					if (this.aflk) drawcs(309, "A Game by Radicalplay.com", 144, 167, 255,
					3);
					else drawcs(309, "A Game by Radicalplay.com", 228, 240, 255,
					3);
				}
				if (this.aflk) drawcs(350, "Now get up and dance!", 144, 167, 255, 3);
				else drawcs(350, "Now get up and dance!", 228, 240, 255, 3);
				this.pin = 0;
			}
			if (this.aflk) this.aflk = false;
			else this.aflk = true;
		}
		if (this.multion != 0 && (checkpoints).stage == -2 && i_142_ != 0) {
			drawcs(i_142_ + 17,
			new StringBuilder().append("Created by: ").append((checkpoints).maker).append("").toString(),
			255, 161, 85, 3);
			if ((checkpoints).pubt > 0) {
				if ((checkpoints).pubt == 2) drawcs(310, "Super Public Stage", 41, 177, 255, 3);
				else drawcs(310, "Public Stage", 41, 177, 255, 3);
				if (this.dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 317, i,
				i_141_, bool)) {
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
					String string_148_ = "Upgrade to a full account to add custom stages!";
					int i_149_ = 400 - this.ftm.stringWidth(string_148_) / 2;
					int i_150_ = (i_149_ + this.ftm.stringWidth(string_148_));
					this.rd.drawString(string_148_, i_149_,
					332);
					if (this.waitlink != -1) this.rd.drawLine(i_149_, 334, i_150_,
					334);
					if (i > i_149_ && i < i_150_ && i_141_ > 321 && i_141_ < 334) {
						if (this.waitlink != -1) this.app.setCursor(new Cursor(12));
						if (bool && this.waitlink == 0) {
							this.app.editlink(this.nickname, true);
							this.waitlink = -1;
						}
					} else this.app.setCursor(new Cursor(0));
					if (this.waitlink > 0) this.waitlink--;
				}
				if (this.dnload == 2) {
					drawcs(332, "Adding stage please wait...", 193, 106, 0, 3);
					if ((this.cd).staction == 0) this.dnload = 3;
					if ((this.cd).staction == -2) this.dnload = 4;
					if ((this.cd).staction == -3) this.dnload = 5;
					if ((this.cd).staction == -1) this.dnload = 6;
				}
				if (this.dnload == 3) drawcs(332,
					"Stager has been successfully added to your stages!",
				193, 106, 0, 3);
				if (this.dnload == 4) drawcs(332, "You already have this stage!", 193, 106, 0,
				3);
				if (this.dnload == 5) drawcs(332,
					"Cannot add more then 20 stages to your account!",
				193, 106, 0, 3);
				if (this.dnload == 6) drawcs(332,
					"Failed to add stage, unknown error, please try again later.",
				193, 106, 0, 3);
			} else drawcs(342, "Private Stage", 193, 106, 0, 3);
		}
		this.rd.drawImage((this.contin[this.pcontin]),
		355, 380, null);
		if ((control).enter || (control).handb) {
			if (this.loadedt) this.strack.unload();
			if (this.multion == 0) {
				this.opselect = 3;
				if (this.gmode == 1) {
					this.opselect = 0;
					if (this.winner && ((checkpoints).stage == ((this.unlocked[this.gmode - 1]) + (this.gmode - 1) * 10)) && (checkpoints).stage != 27) {
						this.unlocked[(this.gmode - 1)]++;
						this.justwon1 = true;
					} else this.justwon1 = false;
				}
				if (this.gmode == 2) {
					this.opselect = 1;
					if (this.winner && ((checkpoints).stage == ((this.unlocked[this.gmode - 1]) + (this.gmode - 1) * 10)) && (checkpoints).stage != 27) {
						this.unlocked[(this.gmode - 1)]++;
						this.justwon2 = true;
					} else this.justwon2 = false;
				}
				if ((checkpoints).stage == 27 && this.gmode == 0)
				(checkpoints).stage = (int)(Math.random() * 27.0) + 1;
				this.fase = 102;
			} else if ((this.cd).haltload == 1) {
				this.sc[0] = 36;
				this.fase = 1177;
			} else if (!this.mtop || (this.nfreeplays >= 5 && !this.logged)) {
				this.opselect = 2;
				this.fase = 102;
			} else this.fase = -9;
			if (this.multion == 0 && this.winner && (checkpoints).stage != 27 && (checkpoints).stage > 0)
			(checkpoints).stage++;
			if (!this.winner && this.multion != 0 && (this.forstart == 700 || this.discon == 240) && this.ndisco < 5) this.ndisco++;
			this.flipo = 0;
			(control).enter = false;
			(control).handb = false;
		}
	}

	public void sortcars(int i) {
		if (i != 0) {
			for (int i_151_ = 1; i_151_ < 7; i_151_++)
			this.sc[i_151_] = -1;
			boolean[] bools = new boolean[7];
			if (i < 0) i = 27;
			int i_152_ = 7;
			if (this.gmode == 1) i_152_ = 5;
			boolean bool = false;
			if (i <= 10) {
				int i_153_ = 6;
				if (this.gmode == 1) i_153_ = 4;
				if ((i == 1 || i == 2) && this.sc[0] != 5) {
					this.sc[i_153_] = 5;
					i_152_ = i_153_;
				}
				if ((i == 3 || i == 4) && this.sc[0] != 6) {
					this.sc[i_153_] = 6;
					i_152_ = i_153_;
				}
				if ((i == 5 || i == 6) && this.sc[0] != 11) {
					this.sc[i_153_] = 11;
					i_152_ = i_153_;
				}
				if ((i == 7 || i == 8) && this.sc[0] != 14) {
					this.sc[i_153_] = 14;
					i_152_ = i_153_;
				}
				if ((i == 9 || i == 10) && this.sc[0] != 15) {
					this.sc[i_153_] = 15;
					i_152_ = i_153_;
				}
			} else {
				i -= 10;
				bool = true;
				if (this.sc[0] != 7 + (i + 1) / 2 && i != 17) {
					this.sc[6] = 7 + (i + 1) / 2;
					i_152_ = 6;
				}
			}
			int i_154_ = 16;
			int i_155_ = 1;
			int i_156_ = 2;
			for (int i_157_ = 1; i_157_ < i_152_; i_157_++) {
				bools[i_157_] = false;
				while (!bools[i_157_]) {
					float f = 10.0F;
					if (bool) f = 17.0F;
					this.sc[i_157_] = (int)(Math.random() * (double)(24.0F + 8.0F * ((float) i / f)));
					if (this.sc[i_157_] >= 16) this.sc[i_157_] -= 16;
					bools[i_157_] = true;
					for (int i_158_ = 0; i_158_ < 7; i_158_++) {
						if (i_157_ != i_158_ && (this.sc[i_157_] == this.sc[i_158_])) bools[i_157_] = false;
					}
					if (bool) f = 16.0F;
					float f_159_ = ((float)(15 - this.sc[i_157_]) / 15.0F * ((float) i / f));
					if ((double) f_159_ > 0.8) f_159_ = 0.8F;
					if (i == 17 && (double) f_159_ > 0.5) f_159_ = 0.5F;
					if ((double) f_159_ > Math.random()) bools[i_157_] = false;
					if (this.gmode == 1) {
						if (this.sc[i_157_] >= 7 && this.sc[i_157_] <= 10) bools[i_157_] = false;
						if (this.sc[i_157_] == 12 || this.sc[i_157_] == 13) bools[i_157_] = false;
						if (this.sc[i_157_] > 5 && this.unlocked[0] <= 2) bools[i_157_] = false;
						if (this.sc[i_157_] > 6 && this.unlocked[0] <= 4) bools[i_157_] = false;
						if (this.sc[i_157_] > 11 && this.unlocked[0] <= 6) bools[i_157_] = false;
						if (this.sc[i_157_] > 14 && this.unlocked[0] <= 8) bools[i_157_] = false;
					}
					if (this.gmode == 2) {
						if ((this.sc[i_157_] - 7) * 2 > this.unlocked[1]) bools[i_157_] = false;
						if (i == 16 && this.unlocked[1] == 16 && this.sc[i_157_] < 9) bools[i_157_] = false;
					}
				}
				if (this.sc[i_157_] < i_154_) {
					i_154_ = this.sc[i_157_];
					if (i_155_ != i_157_) {
						i_156_ = i_155_;
						i_155_ = i_157_;
					}
				}
			}
			if (!bool && i == 10) {
				boolean bool_160_ = false;
				for (int i_161_ = 0; i_161_ < 7; i_161_++) {
					if (this.sc[i_161_] == 11) bool_160_ = true;
				}
				if (!bool_160_ && (Math.random() > Math.random() || this.gmode != 0)) this.sc[i_155_] = 11;
				bool_160_ = false;
				for (int i_162_ = 0; i_162_ < 7; i_162_++) {
					if (this.sc[i_162_] == 14) bool_160_ = true;
				}
				if (!bool_160_ && (Math.random() > Math.random() || this.gmode != 0)) this.sc[i_156_] = 14;
			}
			if (i == 12) {
				boolean bool_163_ = false;
				for (int i_164_ = 0; i_164_ < 7; i_164_++) {
					if (this.sc[i_164_] == 11) bool_163_ = true;
				}
				if (!bool_163_) this.sc[i_155_] = 11;
			}
			if (i == 14) {
				boolean bool_165_ = false;
				for (int i_166_ = 0; i_166_ < 7; i_166_++) {
					if (this.sc[i_166_] == 12) bool_165_ = true;
				}
				if (!bool_165_ && (Math.random() > Math.random() || this.gmode != 0)) this.sc[i_155_] = 12;
				bool_165_ = false;
				for (int i_167_ = 0; i_167_ < 7; i_167_++) {
					if (this.sc[i_167_] == 10) bool_165_ = true;
				}
				if (!bool_165_ && (Math.random() > Math.random() || this.gmode != 0)) this.sc[i_156_] = 10;
			}
			if (i == 15) {
				boolean bool_168_ = false;
				for (int i_169_ = 0; i_169_ < 7; i_169_++) {
					if (this.sc[i_169_] == 11) bool_168_ = true;
				}
				if (!bool_168_ && (Math.random() > Math.random() || this.gmode != 0)) this.sc[i_155_] = 11;
				bool_168_ = false;
				for (int i_170_ = 0; i_170_ < 7; i_170_++) {
					if (this.sc[i_170_] == 13) bool_168_ = true;
				}
				if (!bool_168_ && (Math.random() > Math.random() || this.gmode != 0)) this.sc[i_156_] = 13;
			}
			if (i == 16) {
				boolean bool_171_ = false;
				for (int i_172_ = 0; i_172_ < 7; i_172_++) {
					if (this.sc[i_172_] == 13) bool_171_ = true;
				}
				if (!bool_171_ && (Math.random() > Math.random() || this.gmode != 0)) this.sc[i_155_] = 13;
				bool_171_ = false;
				for (int i_173_ = 0; i_173_ < 7; i_173_++) {
					if (this.sc[i_173_] == 12) bool_171_ = true;
				}
				if (!bool_171_ && (Math.random() > Math.random() || this.gmode != 0)) this.sc[i_156_] = 12;
			}
			if ((this.cd).lastload == 1) {
				int i_174_ = 0;
				for (int i_175_ = 0;
				i_175_ < (this.cd).nlcars - 16;
				i_175_++) {
					if (i_174_ == 0) {
						for (int i_176_ = 1; i_176_ < i_152_; i_176_++)
						bools[i_176_] = false;
					}
					if ((this.cd).include[i_175_] && this.sc[0] != i_175_ + 16) {
						int i_177_;
						for (i_177_ = (int)(1.0 + Math.random() * (double)(i_152_ - 1));
						bools[i_177_];
						i_177_ = (int)(1.0 + Math.random() * (double)(i_152_ - 1))) {
							/* empty */
						}
						bools[i_177_] = true;
						this.sc[i_177_] = i_175_ + 16;
						if (++i_174_ == i_152_ - 1) i_174_ = 0;
					}
				}
			}
			if ((this.cd).lastload == 2) {
				int i_178_ = 0;
				for (int i_179_ = 0;
				(i_179_ < (this.cd).nlocars - 16);
				i_179_++) {
					if (i_178_ == 0) {
						for (int i_180_ = 1; i_180_ < i_152_; i_180_++)
						bools[i_180_] = false;
					}
					if ((this.cd).include[i_179_] && this.sc[0] != i_179_ + 16) {
						int i_181_;
						for (i_181_ = (int)(1.0 + Math.random() * (double)(i_152_ - 1));
						bools[i_181_];
						i_181_ = (int)(1.0 + Math.random() * (double)(i_152_ - 1))) {
							/* empty */
						}
						bools[i_181_] = true;
						this.sc[i_181_] = i_179_ + 16;
						if (++i_178_ == i_152_ - 1) i_178_ = 0;
					}
				}
			}
		}
	}

	public void ctachm(int i, int i_182_, int i_183_, Control control) {
		if (this.fase == 1) {
			if (i_183_ == 1) {
				if (over(this.next[0], i, i_182_, 625, 135)) this.pnext = 1;
				if (over(this.back[0], i, i_182_, 115, 135)) this.pback = 1;
				if (over(this.contin[0], i, i_182_, 355, 360)) this.pcontin = 1;
			}
			if (i_183_ == 2) {
				if (this.pnext == 1)
				(control).right = true;
				if (this.pback == 1)
				(control).left = true;
				if (this.pcontin == 1)
				(control).enter = true;
			}
		}
		if (this.fase == 3) {
			if (i_183_ == 1 && over(this.contin[0], i, i_182_, 355, 350)) this.pcontin = 1;
			if (i_183_ == 2 && this.pcontin == 1) {
				(control).enter = true;
				this.pcontin = 0;
			}
		}
		if (this.fase == 4) {
			if (i_183_ == 1 && over(this.back[0], i, i_182_, 370, 345)) this.pback = 1;
			if (i_183_ == 2 && this.pback == 1) {
				(control).enter = true;
				this.pback = 0;
			}
		}
		if (this.fase == 6) {
			if (i_183_ == 1 && (over(this.star[0], i, i_182_, 359, 385) || over(this.star[0], i, i_182_, 359, 295))) this.pstar = 2;
			if (i_183_ == 2 && this.pstar == 2) {
				(control).enter = true;
				this.pstar = 1;
			}
		}
		if (this.fase == 7) {
			if (i_183_ == 1) {
				if (over(this.next[0], i, i_182_, 645, 275)) this.pnext = 1;
				if (over(this.back[0], i, i_182_, 95, 275)) this.pback = 1;
				if (over(this.contin[0], i, i_182_, 355, 385) && !(this.app).openm) this.pcontin = 1;
			}
			if (i_183_ == 2) {
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
			this.lym = i_182_;
			if (i_183_ == 1 && over(this.contin[0], i, i_182_, 355, 380)) this.pcontin = 1;
			if (i_183_ == 2 && this.pcontin == 1) {
				(control).enter = true;
				this.pcontin = 0;
			}
		}
		if (this.fase == -7) {
			if (i_183_ == 1) {
				if (overon(329, 45, 137, 22, i, i_182_)) {
					this.opselect = 0;
					this.shaded = true;
				}
				if (overon(320, 73, 155, 22, i, i_182_)) {
					this.opselect = 1;
					this.shaded = true;
				}
				if (overon(303, 99, 190, 22, i, i_182_)) {
					this.opselect = 2;
					this.shaded = true;
				}
				if (overon(341, 125, 109, 22, i, i_182_)) {
					this.opselect = 3;
					this.shaded = true;
				}
			}
			if (i_183_ == 2 && this.shaded) {
				(control).enter = true;
				this.shaded = false;
			}
			if (i_183_ == 0 && (i != this.lxm || i_182_ != this.lym)) {
				if (overon(329, 45, 137, 22, i, i_182_)) this.opselect = 0;
				if (overon(320, 73, 155, 22, i, i_182_)) this.opselect = 1;
				if (overon(303, 99, 190, 22, i, i_182_)) this.opselect = 2;
				if (overon(341, 125, 109, 22, i, i_182_)) this.opselect = 3;
				this.lxm = i;
				this.lym = i_182_;
			}
		}
		if (this.fase == 10) {
			if (i_183_ == 1) {
				if (overon(343, 261, 110, 22, i, i_182_)) {
					this.opselect = 0;
					this.shaded = true;
				}
				if (overon(288, 291, 221, 22, i, i_182_)) {
					this.opselect = 1;
					this.shaded = true;
				}
				if (overon(301, 321, 196, 22, i, i_182_)) {
					this.opselect = 2;
					this.shaded = true;
				}
				if (overon(357, 351, 85, 22, i, i_182_)) {
					this.opselect = 3;
					this.shaded = true;
				}
			}
			if (i_183_ == 2 && this.shaded) {
				(control).enter = true;
				this.shaded = false;
			}
			if (i_183_ == 0 && (i != this.lxm || i_182_ != this.lym)) {
				if (overon(343, 261, 110, 22, i, i_182_)) this.opselect = 0;
				if (overon(288, 291, 221, 22, i, i_182_)) this.opselect = 1;
				if (overon(301, 321, 196, 22, i, i_182_)) this.opselect = 2;
				if (overon(357, 351, 85, 22, i, i_182_)) this.opselect = 3;
				this.lxm = i;
				this.lym = i_182_;
			}
		}
		if (this.fase == 102) {
			if (i_183_ == 1) {
				if (overon(358, 262 + this.dropf, 82, 22, i,
				i_182_)) {
					this.opselect = 0;
					this.shaded = true;
				}
				if (overon(358, 290 + this.dropf, 82, 22, i,
				i_182_)) {
					this.opselect = 1;
					this.shaded = true;
				}
				if (overon(333, 318 + this.dropf, 132, 22, i,
				i_182_)) {
					this.opselect = 2;
					this.shaded = true;
				}
				if (this.dropf == 0 && overon(348, 346, 102, 22, i, i_182_)) {
					this.opselect = 3;
					this.shaded = true;
				}
			}
			if (i_183_ == 2 && this.shaded) {
				(control).enter = true;
				this.shaded = false;
			}
			if (i_183_ == 0 && (i != this.lxm || i_182_ != this.lym)) {
				if (overon(358, 262 + this.dropf, 82, 22, i,
				i_182_)) this.opselect = 0;
				if (overon(358, 290 + this.dropf, 82, 22, i,
				i_182_)) this.opselect = 1;
				if (overon(333, 318 + this.dropf, 132, 22, i,
				i_182_)) this.opselect = 2;
				if (this.dropf == 0 && overon(348, 346, 102, 22, i, i_182_)) this.opselect = 3;
				this.lxm = i;
				this.lym = i_182_;
			}
		}
		if (this.fase == 11) {
			if (this.flipo >= 1 && this.flipo <= 15) {
				if (i_183_ == 1 && over(this.next[0], i, i_182_, 665, 395)) this.pnext = 1;
				if (i_183_ == 2 && this.pnext == 1) {
					(control).right = true;
					this.pnext = 0;
				}
			}
			if (this.flipo >= 3 && this.flipo <= 16) {
				if (i_183_ == 1 && over(this.back[0], i, i_182_, 75, 395)) this.pback = 1;
				if (i_183_ == 2 && this.pback == 1) {
					(control).left = true;
					this.pback = 0;
				}
			}
			if (this.flipo == 16) {
				if (i_183_ == 1 && over(this.contin[0], i,
				i_182_, 565, 395)) this.pcontin = 1;
				if (i_183_ == 2 && this.pcontin == 1) {
					(control).enter = true;
					this.pcontin = 0;
				}
			}
		}
		if (this.fase == 8) {
			if (i_183_ == 1 && over(this.next[0], i, i_182_, 665, 395)) this.pnext = 1;
			if (i_183_ == 2 && this.pnext == 1) {
				(control).enter = true;
				this.pnext = 0;
			}
		}
	}

	public void stat(Mad mad, ContO conto, CheckPoints checkpoints,
	Control control, boolean bool) {
		if (this.holdit) {
			int i = 250;
			if (this.fase == 7001) {
				if (this.exitm != 4) {
					this.exitm = 0;
					i = 600;
				} else i = 1200;
			}
			if (this.exitm != 4 || !this.lan || this.im != 0) {
				this.holdcnt++;
				if (((control).enter || this.holdcnt > i) && ((control).chatup == 0 || this.fase != 7001)) {
					this.fase = -2;
					(control).enter = false;
				}
			} else if ((control).enter)
			(control).enter = false;
		} else {
			if (this.holdcnt != 0) this.holdcnt = 0;
			if ((control).enter || (control).exit) {
				if (this.fase == 0) {
					if (this.loadedt) this.strack.stop();
					this.fase = -6;
				} else if (this.starcnt == 0 && (control).chatup == 0 && (this.multion < 2 || !this.lan)) {
					if (this.exitm == 0) this.exitm = 1;
					else this.exitm = 0;
				}
				if ((control).chatup == 0 || this.fase != 7001)
				(control).enter = false;
				(control).exit = false;
			}
		}
		if (this.exitm == 2) {
			this.fase = -2;
			this.winner = false;
		}
		if (this.fase != -2) {
			this.holdit = false;
			if ((checkpoints).haltall)
			(checkpoints).haltall = false;
			boolean bool_184_ = false;
			String string = "";
			String string_185_ = "";
			if (this.clangame != 0 && (!(mad).dest || this.multion >= 2)) {
				bool_184_ = true;
				for (int i = 0; i < this.nplayers; i++) {
					if ((checkpoints).dested[i] == 0) {
						if (string.equals("")) string = this.pclan[i];
						else if (!string.toLowerCase().equals(this.pclan[i].toLowerCase())) {
							bool_184_ = false;
							break;
						}
					}
				}
			}
			if (this.clangame > 1) {
				boolean bool_186_ = false;
				String string_187_ = "";
				if (bool_184_) {
					for (int i = 0; i < this.nplayers; i++) {
						if (!string.toLowerCase().equals(this.pclan[i].toLowerCase())) {
							string_185_ = this.pclan[i];
							break;
						}
					}
					if (this.clangame == 2) {
						bool_186_ = true;
						string_187_ = new StringBuilder().append("Clan ").append(string_185_).append(" wasted, nobody won becuase this is a racing only game!")
							.toString();
					}
					if (this.clangame == 4 && !string.toLowerCase().equals(this.gaclan.toLowerCase())) {
						bool_186_ = true;
						string_187_ = new StringBuilder().append("Clan ").append(string_185_).append(" wasted, nobody won becuase ").append(string).append(" should have raced in this racing vs wasting game!")
							.toString();
					}
					if (this.clangame == 5 && string.toLowerCase().equals(this.gaclan.toLowerCase())) {
						bool_186_ = true;
						string_187_ = new StringBuilder().append("Clan ").append(string_185_).append(" wasted, nobody won becuase ").append(string).append(" should have raced in this racing vs wasting game!")
							.toString();
					}
				}
				for (int i = 0; i < this.nplayers; i++) {
					if (((checkpoints).clear[i] == ((checkpoints).nlaps * (checkpoints).nsp)) && (checkpoints).pos[i] == 0) {
						if (this.clangame == 3) {
							bool_186_ = true;
							string_187_ = new StringBuilder().append("").append(this.plnames[i]).append(" of clan ").append(this.pclan[i]).append(" finished first, nobody won becuase this is a wasting only game!")
								.toString();
						}
						if (this.clangame == 4 && (this.pclan[i].toLowerCase()
							.equals(this.gaclan.toLowerCase()))) {
							bool_186_ = true;
							string_187_ = new StringBuilder().append("").append(this.plnames[i]).append(" of clan ").append(this.pclan[i]).append(" finished first, nobody won becuase ")
								.append(this.pclan[i]).append(" should have wasted in this racing vs wasting game!")
								.toString();
						}
						if (this.clangame == 5 && !(this.pclan[i].toLowerCase()
							.equals(this.gaclan.toLowerCase()))) {
							bool_186_ = true;
							string_187_ = new StringBuilder().append("").append(this.plnames[i]).append(" of clan ").append(this.pclan[i]).append(" finished first, nobody won becuase ")
								.append(this.pclan[i]).append(" should have wasted in this racing vs wasting game!")
								.toString();
						}
					}
				}
				if (bool_186_) {
					drawhi(this.gamefinished, 70);
					if (this.aflk) {
						drawcs(120, string_187_, 0, 0, 0, 0);
						this.aflk = false;
					} else {
						drawcs(120, string_187_, 0, 128, 255, 0);
						this.aflk = true;
					}
					drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
					(checkpoints).haltall = true;
					this.holdit = true;
					this.winner = false;
				}
			}
			if (this.multion < 2) {
				if (!this.holdit && ((((checkpoints).wasted == this.nplayers - 1) && this.nplayers != 1) || bool_184_)) {
					drawhi(this.youwastedem, 70);
					if (!bool_184_) {
						if (this.aflk) {
							drawcs(120, "You Won, all cars have been wasted!",
							0, 0, 0, 0);
							this.aflk = false;
						} else {
							drawcs(120, "You Won, all cars have been wasted!",
							0, 128, 255, 0);
							this.aflk = true;
						}
					} else if (this.aflk) {
						drawcs(120,
						new StringBuilder().append("Your clan ").append(string).append(" has wasted all the cars!").toString(),
						0, 0, 0, 0);
						this.aflk = false;
					} else {
						drawcs(120,
						new StringBuilder().append("Your clan ").append(string).append(" has wasted all the cars!").toString(),
						0, 128, 255, 0);
						this.aflk = true;
					}
					drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
					(checkpoints).haltall = true;
					this.holdit = true;
					this.winner = true;
				}
				if (!this.holdit && (mad).dest && this.cntwis == 8) {
					if (this.discon != 240) drawhi(this.yourwasted, 70);
					else {
						drawhi(this.disco, 70);
						stopchat();
					}
					boolean bool_188_ = false;
					if (this.lan) {
						bool_188_ = true;
						for (int i = 0; i < this.nplayers;
						i++) {
							if (i != this.im && this.dested[i] == 0 && this.plnames[i].indexOf("MadBot") == -1) bool_188_ = false;
						}
					}
					if (this.fase == 7001 && (this.nplayers - ((checkpoints).wasted + 1)) >= 2 && this.discon != 240 && !bool_188_) this.exitm = 4;
					else {
						if (this.exitm == 4) this.exitm = 0;
						drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0,
						0);
					}
					this.holdit = true;
					this.winner = false;
				}
				if (!this.holdit) {
					for (int i = 0; i < this.nplayers; i++) {
						if (((checkpoints).clear[i] == ((checkpoints).nlaps * (checkpoints).nsp)) && (checkpoints).pos[i] == 0) {
							if (this.clangame == 0) {
								if (i == this.im) {
									drawhi(this.youwon, 70);
									if (this.aflk) {
										drawcs(120,
											"You finished first, nice job!",
										0, 0, 0, 0);
										this.aflk = false;
									} else {
										drawcs(120,
											"You finished first, nice job!",
										0, 128, 255, 0);
										this.aflk = true;
									}
									this.winner = true;
								} else {
									drawhi(this.youlost, 70);
									if (this.fase != 7001) {
										if (this.aflk) {
											drawcs(120,
											new StringBuilder().append("").append((
											this.cd)
												.names[(this.sc[i])])
												.append(" finished first, race over!")
												.toString(),
											0, 0, 0, 0);
											this.aflk = false;
										} else {
											drawcs(120,
											new StringBuilder().append("").append((
											this.cd)
												.names[(this.sc[i])])
												.append(" finished first, race over!")
												.toString(),
											0, 128, 255, 0);
											this.aflk = true;
										}
									} else if (this.aflk) {
										drawcs(120,
										new StringBuilder().append("")
											.append(this.plnames[i])
											.append(" finished first, race over!")
											.toString(),
										0, 0, 0, 0);
										this.aflk = false;
									} else {
										drawcs(120,
										new StringBuilder().append("")
											.append(this.plnames[i])
											.append(" finished first, race over!")
											.toString(),
										0, 128, 255, 0);
										this.aflk = true;
									}
									this.winner = false;
								}
							} else if (this.pclan[i].toLowerCase().equals(this.pclan[this.im].toLowerCase())) {
								drawhi(this.youwon, 70);
								if (this.aflk) {
									drawcs(120,
									new StringBuilder().append("Your clan ").append(this.pclan[this.im])
										.append(" finished first, nice job!")
										.toString(),
									0, 0, 0, 0);
									this.aflk = false;
								} else {
									drawcs(120,
									new StringBuilder().append("Your clan ").append(this.pclan[this.im])
										.append(" finished first, nice job!")
										.toString(),
									0, 128, 255, 0);
									this.aflk = true;
								}
								this.winner = true;
							} else {
								drawhi(this.youlost, 70);
								if (this.aflk) {
									drawcs(120,
									new StringBuilder().append("")
										.append(this.plnames[i])
										.append(" of clan ").append(this.pclan[i])
										.append(" finished first, race over!")
										.toString(),
									0, 0, 0, 0);
									this.aflk = false;
								} else {
									drawcs(120,
									new StringBuilder().append("")
										.append(this.plnames[i])
										.append(" of clan ").append(this.pclan[i])
										.append(" finished first, race over!")
										.toString(),
									0, 128, 255, 0);
									this.aflk = true;
								}
								this.winner = false;
							}
							drawcs(350, "Press  [ Enter ]  to continue", 0, 0,
							0, 0);
							(checkpoints).haltall = true;
							this.holdit = true;
						}
					}
				}
			} else {
				if (!this.holdit && (((checkpoints).wasted >= this.nplayers - 1) || bool_184_)) {
					String string_189_ = "Someone";
					if (!bool_184_) {
						for (int i = 0; i < this.nplayers;
						i++) {
							if ((checkpoints).dested[i] == 0) string_189_ = this.plnames[i];
						}
					} else string_189_ = new StringBuilder().append("Clan ").append(string).append("").toString();
					drawhi(this.gamefinished, 70);
					if (this.aflk) {
						drawcs(120,
						new StringBuilder().append("").append(string_189_).append(" has wasted all the cars!").toString(),
						0, 0, 0, 0);
						this.aflk = false;
					} else {
						drawcs(120,
						new StringBuilder().append("").append(string_189_).append(" has wasted all the cars!").toString(),
						0, 128, 255, 0);
						this.aflk = true;
					}
					drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
					(checkpoints).haltall = true;
					this.holdit = true;
					this.winner = false;
				}
				if (!this.holdit) {
					for (int i = 0; i < this.nplayers; i++) {
						if (((checkpoints).clear[i] == ((checkpoints).nlaps * (checkpoints).nsp)) && (checkpoints).pos[i] == 0) {
							drawhi(this.gamefinished, 70);
							if (this.clangame == 0) {
								if (this.aflk) {
									drawcs(120,
									new StringBuilder().append("")
										.append(this.plnames[i])
										.append(" finished first, race over!")
										.toString(),
									0, 0, 0, 0);
									this.aflk = false;
								} else {
									drawcs(120,
									new StringBuilder().append("")
										.append(this.plnames[i])
										.append(" finished first, race over!")
										.toString(),
									0, 128, 255, 0);
									this.aflk = true;
								}
							} else if (this.aflk) {
								drawcs(120, new StringBuilder().append("Clan ").append(this.pclan[i])
									.append(" finished first, race over!")
									.toString(), 0, 0, 0, 0);
								this.aflk = false;
							} else {
								drawcs(120, new StringBuilder().append("Clan ").append(this.pclan[i])
									.append(" finished first, race over!")
									.toString(), 0, 128, 255, 0);
								this.aflk = true;
							}
							drawcs(350, "Press  [ Enter ]  to continue", 0, 0,
							0, 0);
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
					this.rd.drawImage(this.wgame,
					311, 20, null);
					if (!this.clanchat) {
						drawcs(397, "Click any player on the right to follow!",
						0, 0, 0, 0);
						if (!this.lan) drawcs(412,
							"Press [V] to change view.  Press [Enter] to exit.",
						0, 0, 0, 0);
						else drawcs(412, "Press [V] to change view.", 0, 0, 0,
						0);
					}
				}
			}
			if (bool) {
				if ((checkpoints).stage != 10 && this.multion < 2 && this.nplayers != 1 && (this.arrace != (control).arrace)) {
					this.arrace = (control).arrace;
					if (this.multion == 1 && this.arrace)
					(control).radar = true;
					if (this.arrace) {
						this.wasay = true;
						this.say = " Arrow now pointing at >  CARS";
						if (this.multion == 1) {
							StringBuilder stringbuilder = new StringBuilder();
							xtGraphics var_xtGraphics_190_ = this;
							(var_xtGraphics_190_).say = stringbuilder.append((var_xtGraphics_190_).say)
								.append("    Press [S] to toggle Radar!")
								.toString();
						}
						this.tcnt = -5;
					}
					if (!this.arrace) {
						this.wasay = false;
						this.say = " Arrow now pointing at >  TRACK";
						if (this.multion == 1) {
							StringBuilder stringbuilder = new StringBuilder();
							xtGraphics var_xtGraphics_191_ = this;
							(var_xtGraphics_191_).say = stringbuilder.append((var_xtGraphics_191_).say)
								.append("    Press [S] to toggle Radar!")
								.toString();
						}
						this.tcnt = -5;
						this.cntan = 20;
						this.alocked = -1;
						this.alocked = -1;
					}
				}
				if (!this.holdit && this.fase != -6 && this.starcnt == 0 && this.multion < 2 && (checkpoints).stage != 10) {
					arrow((mad).point, (mad).missedcp, checkpoints,
					this.arrace);
					if (!this.arrace) {
						if (this.auscnt == 45 && (mad).capcnt == 0 && this.exitm == 0) {
							if ((mad).missedcp > 0) {
								if ((mad).missedcp > 15 && (mad).missedcp < 50) {
									if (this.flk) drawcs(70, "Checkpoint Missed!", 255,
									0, 0, 0);
									else drawcs(70, "Checkpoint Missed!", 255,
									150, 0, 2);
								}
								(mad).missedcp++;
								if ((mad).missedcp == 70)
								(mad).missedcp = -2;
							} else if ((mad).mtouch && this.cntovn < 70) {
								if (Math.abs(this.ana) > 100) this.cntan++;
								else if (this.cntan != 0) this.cntan--;
								if (this.cntan > 40) {
									this.cntovn++;
									this.cntan = 40;
									if (this.flk) {
										drawcs(70, "Wrong Way!", 255, 150, 0,
										0);
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
							this.say = new StringBuilder().append(" Arrow Locked on >  ").append(this.plnames[this.alocked])
								.append("").toString();
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
					Color.RGBtoHSB((this.m).csky[0], (this.m).csky[1], (this.m).csky[2],
					fs);
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
				this.rd.drawImage(this.dmg, 600,
				7, null);
				this.rd.drawImage(this.pwr, 600,
				27, null);
				this.rd.drawImage(this.lap, 19,
				7, null);
				this.rd.setColor(new Color(0, 0, 100));
				this.rd.drawString(new StringBuilder().append("").append((mad).nlaps + 1).append(" / ").append((checkpoints).nlaps).append("").toString(),
				51, 18);
				this.rd.drawImage(this.was, 92,
				7, null);
				this.rd.setColor(new Color(0, 0, 100));
				this.rd.drawString(new StringBuilder().append("").append((checkpoints).wasted).append(" / ").append(this.nplayers - 1).append("").toString(),
				150, 18);
				this.rd.drawImage(this.pos, 42,
				27, null);
				this.rd.drawImage((this.rank[((checkpoints)
					.pos[(mad).im])]),
				110, 28, null);
				drawstat(((this.cd).maxmag[(mad).cn]), (mad).hitmag, (mad).newcar, (mad).power);
				if ((control).radar && (checkpoints).stage != 10) radarstat(mad, conto, checkpoints);
			}
			if (!this.holdit) {
				if (this.starcnt != 0 && this.starcnt <= 35) {
					if (this.starcnt == 35 && !this.mutes) this.three.play();
					if (this.starcnt == 24) {
						this.gocnt = 2;
						if (!this.mutes) this.two.play();
					}
					if (this.starcnt == 13) {
						this.gocnt = 1;
						if (!this.mutes) this.one.play();
					}
					if (this.starcnt == 2) {
						this.gocnt = 0;
						if (!this.mutes) this.go.play();
					}
					this.duds = 0;
					if (this.starcnt <= 37 && this.starcnt > 32) this.duds = 1;
					if (this.starcnt <= 26 && this.starcnt > 21) this.duds = 1;
					if (this.starcnt <= 15 && this.starcnt > 10) this.duds = 1;
					if (this.starcnt <= 4) this.duds = 2;
					if (this.dudo != -1) {
						this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
						this.rd.drawImage((this.dude[this.duds]),
						this.dudo, 0, null);
						this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
					}
					if (this.gocnt != 0) this.rd.drawImage((this.cntdn[(this.gocnt)]),
					385, 50, null);
					else this.rd.drawImage((this.cntdn[(this.gocnt)]),
					363, 50, null);
				}
				if (this.looped != 0 && (mad).loop == 2) this.looped = 0;
				if ((mad).power < 45.0F) {
					if (this.tcnt == 30 && this.auscnt == 45 && (mad).mtouch && (mad).capcnt == 0 && this.exitm == 0) {
						if (this.looped != 2) {
							if (this.pwcnt < 70 || (this.pwcnt < 100 && this.looped != 0)) {
								if (this.pwflk) {
									drawcs(110, "Power low, perform stunt!", 0,
									0, 200, 0);
									this.pwflk = false;
								} else {
									drawcs(110, "Power low, perform stunt!",
									255, 100, 0, 0);
									this.pwflk = true;
								}
							}
						} else if (this.pwcnt < 100) {
							String string_192_ = "";
							if (this.multion == 0) string_192_ = "  (Press Enter)";
							if (this.pwflk) {
								drawcs(110,
								new StringBuilder().append("Please read the Game Instructions!")
									.append(string_192_).append("").toString(),
								0, 0, 200, 0);
								this.pwflk = false;
							} else {
								drawcs(110,
								new StringBuilder().append("Please read the Game Instructions!")
									.append(string_192_).append("").toString(),
								255, 100, 0, 0);
								this.pwflk = true;
							}
						}
						this.pwcnt++;
						if (this.pwcnt == 300) {
							this.pwcnt = 0;
							if (this.looped != 0) {
								this.looped++;
								if (this.looped == 4) this.looped = 2;
							}
						}
					}
				} else if (this.pwcnt != 0) this.pwcnt = 0;
				if ((mad).capcnt == 0) {
					if (this.tcnt < 30) {
						if (this.exitm == 0) {
							if (this.tflk) {
								if (!this.wasay) drawcs(105, this.say, 0, 0,
								0, 0);
								else drawcs(105, this.say, 0, 0,
								0, 0);
								this.tflk = false;
							} else {
								if (!this.wasay) drawcs(105, this.say, 0,
								128, 255, 0);
								else drawcs(105, this.say, 255,
								128, 0, 0);
								this.tflk = true;
							}
						}
						this.tcnt++;
					} else if (this.wasay) this.wasay = false;
					if (this.auscnt < 45) {
						if (this.exitm == 0) {
							if (this.aflk) {
								drawcs(85, this.asay, 98, 176,
								255, 0);
								this.aflk = false;
							} else {
								drawcs(85, this.asay, 0, 128,
								255, 0);
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
					if (i == 1) this.loop = "Forward loop";
					if (i == 2) this.loop = "double Forward";
					if (i == 3) this.loop = "triple Forward";
					if (i >= 4) this.loop = "massive Forward looping";
					if (i == -1) this.loop = "Backloop";
					if (i == -2) this.loop = "double Back";
					if (i == -3) this.loop = "triple Back";
					if (i <= -4) this.loop = "massive Back looping";
					if (i == 0) {
						if ((mad).ftab && (mad).btab) this.loop = "Tabletop and reversed Tabletop";
						else if ((mad).ftab || (mad).btab) this.loop = "Tabletop";
					}
					if (i > 0 && (mad).btab) this.loop = new StringBuilder().append("Hanged ").append(this.loop).toString();
					if (i < 0 && (mad).ftab) this.loop = new StringBuilder().append("Hanged ").append(this.loop).toString();
					if (this.loop != "") {
						StringBuilder stringbuilder = new StringBuilder();
						xtGraphics var_xtGraphics_193_ = this;
						(var_xtGraphics_193_).asay = stringbuilder.append((var_xtGraphics_193_).asay)
							.append(" ").append(this.loop).toString();
					}
					i = 0;
					(mad).travxy = Math.abs((mad).travxy);
					while ((mad).travxy > 270) {
						(mad).travxy -= 360;
						i++;
					}
					if (i == 0 && (mad).rtab) {
						if (this.loop == "") this.spin = "Tabletop";
						else this.spin = "Flipside";
					}
					if (i == 1) this.spin = "Rollspin";
					if (i == 2) this.spin = "double Rollspin";
					if (i == 3) this.spin = "triple Rollspin";
					if (i >= 4) this.spin = "massive Roll spinning";
					i = 0;
					boolean bool_194_ = false;
					(mad).travxz = Math.abs((mad).travxz);
					while ((mad).travxz > 90) {
						(mad).travxz -= 180;
						i += 180;
						if (i > 900) {
							i = 900;
							bool_194_ = true;
						}
					}
					if (i != 0) {
						if (this.loop == "" && this.spin == "") {
							StringBuilder stringbuilder = new StringBuilder();
							xtGraphics var_xtGraphics_195_ = this;
							(var_xtGraphics_195_).asay = stringbuilder.append((var_xtGraphics_195_).asay)
								.append(" ").append(i).toString();
							if (bool_194_) {
								StringBuilder stringbuilder_196_ = new StringBuilder();
								xtGraphics var_xtGraphics_197_ = this;
								(var_xtGraphics_197_).asay = stringbuilder_196_.append((var_xtGraphics_197_)
									.asay)
									.append(" and beyond").toString();
							}
						} else {
							if (this.spin != "") {
								if (this.loop == "") {
									StringBuilder stringbuilder = new StringBuilder();
									xtGraphics var_xtGraphics_198_ = this;
									(var_xtGraphics_198_).asay = stringbuilder.append((
									var_xtGraphics_198_).asay)
										.append(" ").append(this.spin)
										.toString();
								} else {
									StringBuilder stringbuilder = new StringBuilder();
									xtGraphics var_xtGraphics_199_ = this;
									(var_xtGraphics_199_).asay = stringbuilder.append((
									var_xtGraphics_199_).asay)
										.append(" with ").append(this.spin)
										.toString();
								}
							}
							StringBuilder stringbuilder = new StringBuilder();
							xtGraphics var_xtGraphics_200_ = this;
							(var_xtGraphics_200_).asay = stringbuilder.append((var_xtGraphics_200_).asay)
								.append(" by ").append(i).toString();
							if (bool_194_) {
								StringBuilder stringbuilder_201_ = new StringBuilder();
								xtGraphics var_xtGraphics_202_ = this;
								(var_xtGraphics_202_).asay = stringbuilder_201_.append((var_xtGraphics_202_)
									.asay)
									.append(" and beyond").toString();
							}
						}
					} else if (this.spin != "") {
						if (this.loop == "") {
							StringBuilder stringbuilder = new StringBuilder();
							xtGraphics var_xtGraphics_203_ = this;
							(var_xtGraphics_203_).asay = stringbuilder.append((var_xtGraphics_203_).asay)
								.append(" ").append(this.spin).toString();
						} else {
							StringBuilder stringbuilder = new StringBuilder();
							xtGraphics var_xtGraphics_204_ = this;
							(var_xtGraphics_204_).asay = stringbuilder.append((var_xtGraphics_204_).asay)
								.append(" by ").append(this.spin).toString();
						}
					}
					if (this.asay != "") this.auscnt -= 15;
					if (this.loop != "") this.auscnt -= 25;
					if (this.spin != "") this.auscnt -= 25;
					if (i != 0) this.auscnt -= 25;
					if (this.auscnt < 45) {
						if (!this.mutes) this.powerup.play();
						if (this.auscnt < -20) this.auscnt = -20;
						int i_205_ = 0;
						if ((mad).powerup > 20.0F) i_205_ = 1;
						if ((mad).powerup > 40.0F) i_205_ = 2;
						if ((mad).powerup > 150.0F) i_205_ = 3;
						if ((mad).surfer) this.asay = new StringBuilder().append(" ").append(this.adj[4]
						[(int)(this.m.random() * 3.0F)])
							.append(this.asay).toString();
						if (i_205_ != 3) this.asay = new StringBuilder().append(this.adj[i_205_]
						[(int)(this.m.random() * 3.0F)])
							.append(this.asay).append(this.exlm[i_205_])
							.toString();
						else this.asay = (this.adj[i_205_]
						[(int)(this.m.random() * 3.0F)]);
						if (!this.wasay) {
							this.tcnt = this.auscnt;
							if ((mad).power != 98.0F) this.say = new StringBuilder().append("Power Up ").append((int)(100.0F * (mad).powerup / 98.0F))
								.append("%").toString();
							else this.say = "Power To The MAX";
							if (this.skidup) this.skidup = false;
							else this.skidup = true;
						}
					}
				}
				if ((mad).newcar) {
					if (!this.wasay) {
						this.say = "Car Fixed";
						this.tcnt = 0;
					}
					if (this.crashup) this.crashup = false;
					else this.crashup = true;
				}
				for (int i = 0; i < this.nplayers; i++) {
					if ((this.dested[i] != (checkpoints).dested[i]) && i != this.im) {
						this.dested[i] = (checkpoints).dested[i];
						if (this.fase != 7001) {
							if (this.dested[i] == 1) {
								this.wasay = true;
								this.say = new StringBuilder().append("").append((this.cd)
									.names[this.sc[i]])
									.append(" has been wasted!").toString();
								this.tcnt = -15;
							}
							if (this.dested[i] == 2) {
								this.wasay = true;
								this.say = new StringBuilder().append("You wasted ").append((this.cd)
									.names[this.sc[i]])
									.append("!").toString();
								this.tcnt = -15;
							}
						} else {
							if (this.dested[i] == 1) {
								this.wasay = true;
								this.say = new StringBuilder().append("").append(this.plnames[i])
									.append(" has been wasted!").toString();
								this.tcnt = -15;
							}
							if (this.dested[i] == 2) {
								this.wasay = true;
								if (this.multion < 2) this.say = new StringBuilder().append("You wasted ").append(this.plnames[i])
									.append("!").toString();
								else this.say = new StringBuilder().append("").append(this.plnames[this.im])
									.append(" wasted ").append(this.plnames[i])
									.append("!").toString();
								this.tcnt = -15;
							}
							if (this.dested[i] == 3) {
								this.wasay = true;
								this.say = new StringBuilder().append("").append(this.plnames[i])
									.append(" has been wasted! (Disconnected)")
									.toString();
								this.tcnt = -15;
							}
						}
					}
				}
				if (this.multion >= 2 && (this.alocked != this.lalocked)) {
					if (this.alocked != -1) {
						this.wasay = false;
						this.say = new StringBuilder().append("Now following ")
							.append(this.plnames[this.alocked])
							.append("!").toString();
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
					if (!this.mutes) this.checkpoint.play();
					this.cntovn = 0;
					if (this.cntan != 0) this.cntan = 0;
				}
			}
		}
		if ((this.m).lightn != -1) {
			int i = ((this.strack).sClip)
				.stream.available();
			(this.m).lton = false;
			if (i <= 6380001 && i > 5368001)
			(this.m).lton = true;
			if (i <= 2992001 && i > 1320001)
			(this.m).lton = true;
		}
	}

	public void drawstat(int i, int i_206_, boolean bool, float f) {
		int[] is = new int[4];
		int[] is_207_ = new int[4];
		if (i_206_ > i) i_206_ = i;
		int i_208_ = (int)(98.0F * ((float) i_206_ / (float) i));
		is[0] = 662;
		is_207_[0] = 11;
		is[1] = 662;
		is_207_[1] = 20;
		is[2] = 662 + i_208_;
		is_207_[2] = 20;
		is[3] = 662 + i_208_;
		is_207_[3] = 11;
		int i_209_ = 244;
		int i_210_ = 244;
		int i_211_ = 11;
		if (i_208_ > 33) i_210_ = (int)(244.0F - 233.0F * ((float)(i_208_ - 33) / 65.0F));
		if (i_208_ > 70) {
			if (this.dmcnt < 10) {
				if (this.dmflk) {
					i_210_ = 170;
					this.dmflk = false;
				} else this.dmflk = true;
			}
			this.dmcnt++;
			if ((double) this.dmcnt > 167.0 - (double) i_208_ * 1.5) this.dmcnt = 0;
		}
		i_209_ += ((float) i_209_ * ((float)(this.m).snap[0] / 100.0F));
		if (i_209_ > 255) i_209_ = 255;
		if (i_209_ < 0) i_209_ = 0;
		i_210_ += ((float) i_210_ * ((float)(this.m).snap[1] / 100.0F));
		if (i_210_ > 255) i_210_ = 255;
		if (i_210_ < 0) i_210_ = 0;
		i_211_ += ((float) i_211_ * ((float)(this.m).snap[2] / 100.0F));
		if (i_211_ > 255) i_211_ = 255;
		if (i_211_ < 0) i_211_ = 0;
		this.rd.setColor(new Color(i_209_, i_210_, i_211_));
		this.rd.fillPolygon(is, is_207_, 4);
		is[0] = 662;
		is_207_[0] = 31;
		is[1] = 662;
		is_207_[1] = 40;
		is[2] = (int)(662.0F + f);
		is_207_[2] = 40;
		is[3] = (int)(662.0F + f);
		is_207_[3] = 31;
		i_209_ = 128;
		if (f == 98.0F) i_209_ = 64;
		i_210_ = (int)(190.0 + (double) f * 0.37);
		i_211_ = 244;
		if (this.auscnt < 45 && this.aflk) {
			i_209_ = 128;
			i_210_ = 244;
			i_211_ = 244;
		}
		i_209_ += ((float) i_209_ * ((float)(this.m).snap[0] / 100.0F));
		if (i_209_ > 255) i_209_ = 255;
		if (i_209_ < 0) i_209_ = 0;
		i_210_ += ((float) i_210_ * ((float)(this.m).snap[1] / 100.0F));
		if (i_210_ > 255) i_210_ = 255;
		if (i_210_ < 0) i_210_ = 0;
		i_211_ += ((float) i_211_ * ((float)(this.m).snap[2] / 100.0F));
		if (i_211_ > 255) i_211_ = 255;
		if (i_211_ < 0) i_211_ = 0;
		this.rd.setColor(new Color(i_209_, i_210_, i_211_));
		this.rd.fillPolygon(is, is_207_, 4);
	}

	public void drawhi(Image image, int i) {
		if ((this.m).darksky) {
			Color color = new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]);
			float[] fs = new float[3];
			Color.RGBtoHSB((this.m).csky[0], (this.m).csky[1], (this.m).csky[2], fs);
			fs[2] = 0.6F;
			color = Color.getHSBColor(fs[0], fs[1], fs[2]);
			this.rd.setColor(color);
			this.rd.fillRoundRect(390 - image.getWidth(this.ob) / 2, i - 2,
			image.getWidth(this.ob) + 20,
			image.getHeight(this.ob) + 2, 7, 20);
			this.rd.setColor(new Color((int)((double) color.getRed() / 1.1), (int)((double) color.getGreen() / 1.1), (int)((double) color.getBlue() / 1.1)));
			this.rd.drawRoundRect(390 - image.getWidth(this.ob) / 2, i - 2,
			image.getWidth(this.ob) + 20,
			image.getHeight(this.ob) + 2, 7, 20);
		}
		this.rd.drawImage(image, 400 - image.getWidth(this.ob) / 2, i, null);
	}

	public void drawcs(int i, String string, int i_212_, int i_213_,
	int i_214_, int i_215_) {
		if (i_215_ != 3 && i_215_ != 4 && i_215_ != 5) {
			i_212_ += ((float) i_212_ * ((float)(this.m).snap[0] / 100.0F));
			if (i_212_ > 255) i_212_ = 255;
			if (i_212_ < 0) i_212_ = 0;
			i_213_ += ((float) i_213_ * ((float)(this.m).snap[1] / 100.0F));
			if (i_213_ > 255) i_213_ = 255;
			if (i_213_ < 0) i_213_ = 0;
			i_214_ += ((float) i_214_ * ((float)(this.m).snap[2] / 100.0F));
			if (i_214_ > 255) i_214_ = 255;
			if (i_214_ < 0) i_214_ = 0;
		}
		if (i_215_ == 4) {
			i_212_ -= ((float) i_212_ * ((float)(this.m).snap[0] / 100.0F));
			if (i_212_ > 255) i_212_ = 255;
			if (i_212_ < 0) i_212_ = 0;
			i_213_ -= ((float) i_213_ * ((float)(this.m).snap[1] / 100.0F));
			if (i_213_ > 255) i_213_ = 255;
			if (i_213_ < 0) i_213_ = 0;
			i_214_ -= ((float) i_214_ * ((float)(this.m).snap[2] / 100.0F));
			if (i_214_ > 255) i_214_ = 255;
			if (i_214_ < 0) i_214_ = 0;
		}
		if (i_215_ == 1) {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString(string,
			400 - (this.ftm.stringWidth(string) / 2) + 1,
			i + 1);
		}
		if (i_215_ == 2) {
			i_212_ = (i_212_ * 2 + (this.m).csky[0] * 1) / 3;
			if (i_212_ > 255) i_212_ = 255;
			if (i_212_ < 0) i_212_ = 0;
			i_213_ = (i_213_ * 2 + (this.m).csky[1] * 1) / 3;
			if (i_213_ > 255) i_213_ = 255;
			if (i_213_ < 0) i_213_ = 0;
			i_214_ = (i_214_ * 2 + (this.m).csky[2] * 1) / 3;
			if (i_214_ > 255) i_214_ = 255;
			if (i_214_ < 0) i_214_ = 0;
		}
		if (i_215_ == 5) {
			this.rd.setColor(new Color((this.m).csky[0] / 2, (this.m).csky[1] / 2, (this.m).csky[2] / 2));
			this.rd.drawString(string,
			400 - (this.ftm.stringWidth(string) / 2) + 1,
			i + 1);
		}
		this.rd.setColor(new Color(i_212_, i_213_, i_214_));
		this.rd.drawString(string,
		400 - this.ftm.stringWidth(string) / 2,
		i);
	}

	public void arrow(int i, int i_216_, CheckPoints checkpoints,
	boolean bool) {
		int[] is = new int[7];
		int[] is_217_ = new int[7];
		int[] is_218_ = new int[7];
		int i_219_ = 400;
		int i_220_ = -90;
		int i_221_ = 700;
		for (int i_222_ = 0; i_222_ < 7; i_222_++)
		is_217_[i_222_] = i_220_;
		is[0] = i_219_;
		is_218_[0] = i_221_ + 110;
		is[1] = i_219_ - 35;
		is_218_[1] = i_221_ + 50;
		is[2] = i_219_ - 15;
		is_218_[2] = i_221_ + 50;
		is[3] = i_219_ - 15;
		is_218_[3] = i_221_ - 50;
		is[4] = i_219_ + 15;
		is_218_[4] = i_221_ - 50;
		is[5] = i_219_ + 15;
		is_218_[5] = i_221_ + 50;
		is[6] = i_219_ + 35;
		is_218_[6] = i_221_ + 50;
		boolean bool_223_ = false;
		int i_224_;
		if (!bool) {
			int i_225_ = 0;
			if (((checkpoints).x[i] - (checkpoints).opx[this.im]) >= 0) i_225_ = 180;
			i_224_ = (int)((double)(90 + i_225_) + ((Math.atan((double)((checkpoints).z[i] - ((checkpoints).opz[this.im])) / (double)((checkpoints).x[i] - ((checkpoints).opx[this.im])))) / 0.017453292519943295));
		} else {
			int i_226_ = 0;
			if (this.multion == 0 || this.alocked == -1) {
				int i_227_ = -1;
				boolean bool_228_ = false;
				for (int i_229_ = 0; i_229_ < this.nplayers;
				i_229_++) {
					if (i_229_ != this.im && ((py(((checkpoints).opx[this.im]) / 100, (checkpoints).opx[i_229_] / 100, ((checkpoints).opz[this.im]) / 100, (checkpoints).opz[i_229_] / 100) < i_227_) || i_227_ == -1) && (!bool_228_ || ((checkpoints).onscreen[i_229_] != 0)) && (checkpoints).dested[i_229_] == 0) {
						i_226_ = i_229_;
						i_227_ = py(((checkpoints).opx[this.im]) / 100, (checkpoints).opx[i_229_] / 100, ((checkpoints).opz[this.im]) / 100, ((checkpoints).opz[i_229_] / 100));
						if ((checkpoints).onscreen[i_229_] != 0) bool_228_ = true;
					}
				}
			} else i_226_ = this.alocked;
			int i_230_ = 0;
			if (((checkpoints).opx[i_226_] - (checkpoints).opx[this.im]) >= 0) i_230_ = 180;
			i_224_ = (int)((double)(90 + i_230_) + ((Math.atan((double)((checkpoints).opz[i_226_] - ((checkpoints).opz[this.im])) / (double)(((checkpoints).opx[i_226_]) - ((checkpoints).opx[this.im])))) / 0.017453292519943295));
			if (this.multion == 0) {
				drawcs(13, "[                                ]", 76, 67, 240,
				0);
				drawcs(13, ((this.cd).names[this.sc[i_226_]]), 0, 0, 0, 0);
			} else {
				this.rd.setFont(new Font("Arial", 1, 12));
				this.ftm = this.rd.getFontMetrics();
				drawcs(17, "[                                ]", 76, 67, 240,
				0);
				drawcs(12, this.plnames[i_226_], 0, 0, 0, 0);
				this.rd.setFont(new Font("Arial", 0, 10));
				this.ftm = this.rd.getFontMetrics();
				drawcs(24, ((this.cd).names[this.sc[i_226_]]), 0, 0, 0, 0);
				this.rd.setFont(new Font("Arial", 1, 11));
				this.ftm = this.rd.getFontMetrics();
			}
		}
		for (i_224_ += (this.m).xz; i_224_ < 0;
		i_224_ += 360) {
			/* empty */
		}
		for ( /**/ ; i_224_ > 180; i_224_ -= 360) {
			/* empty */
		}
		if (!bool) {
			if (i_224_ > 130) i_224_ = 130;
			if (i_224_ < -130) i_224_ = -130;
		} else {
			if (i_224_ > 100) i_224_ = 100;
			if (i_224_ < -100) i_224_ = -100;
		}
		if (Math.abs(this.ana - i_224_) < 180) {
			if (Math.abs(this.ana - i_224_) < 10) this.ana = i_224_;
			else if (this.ana < i_224_) this.ana += 10;
			else this.ana -= 10;
		} else {
			if (i_224_ < 0) {
				this.ana += 15;
				if (this.ana > 180) this.ana -= 360;
			}
			if (i_224_ > 0) {
				this.ana -= 15;
				if (this.ana < -180) this.ana += 360;
			}
		}
		rot(is, is_218_, i_219_, i_221_, this.ana, 7);
		i_224_ = Math.abs(this.ana);
		this.rd.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_ON));
		if (!bool) {
			if (i_224_ > 7 || i_216_ > 0 || i_216_ == -2 || this.cntan != 0) {
				for (int i_231_ = 0; i_231_ < 7; i_231_++) {
					is[i_231_] = xs(is[i_231_], is_218_[i_231_]);
					is_217_[i_231_] = ys(is_217_[i_231_], is_218_[i_231_]);
				}
				int i_232_ = (int)(190.0F + 190.0F * ((float)((this.m)).snap[0] / 100.0F));
				if (i_232_ > 255) i_232_ = 255;
				if (i_232_ < 0) i_232_ = 0;
				int i_233_ = (int)(255.0F + 255.0F * ((float)((this.m)).snap[1] / 100.0F));
				if (i_233_ > 255) i_233_ = 255;
				if (i_233_ < 0) i_233_ = 0;
				int i_234_ = 0;
				if (i_216_ <= 0) {
					if (i_224_ <= 45 && i_216_ != -2 && this.cntan == 0) {
						i_232_ = (i_232_ * i_224_ + ((this.m).csky[0] * (45 - i_224_))) / 45;
						i_233_ = (i_233_ * i_224_ + ((this.m).csky[1] * (45 - i_224_))) / 45;
						i_234_ = (i_234_ * i_224_ + ((this.m).csky[2] * (45 - i_224_))) / 45;
					}
					if (i_224_ >= 90) {
						int i_235_ = (int)(255.0F + 255.0F * ((float)(
						(this.m)).snap[0] / 100.0F));
						if (i_235_ > 255) i_235_ = 255;
						if (i_235_ < 0) i_235_ = 0;
						i_232_ = (i_232_ * (140 - i_224_) + i_235_ * (i_224_ - 90)) / 50;
						if (i_232_ > 255) i_232_ = 255;
					}
				} else if (this.flk) {
					i_232_ = (int)(255.0F + 255.0F * ((float)((
					this.m)
						.snap[0]) / 100.0F));
					if (i_232_ > 255) i_232_ = 255;
					if (i_232_ < 0) i_232_ = 0;
					this.flk = false;
				} else {
					i_232_ = (int)(255.0F + 255.0F * ((float)((
					this.m)
						.snap[0]) / 100.0F));
					if (i_232_ > 255) i_232_ = 255;
					if (i_232_ < 0) i_232_ = 0;
					i_233_ = (int)(220.0F + 220.0F * ((float)((
					this.m)
						.snap[1]) / 100.0F));
					if (i_233_ > 255) i_233_ = 255;
					if (i_233_ < 0) i_233_ = 0;
					this.flk = true;
				}
				this.rd.setColor(new Color(i_232_, i_233_,
				i_234_));
				this.rd.fillPolygon(is, is_217_, 7);
				i_232_ = (int)(115.0F + 115.0F * ((float)((this.m)).snap[0] / 100.0F));
				if (i_232_ > 255) i_232_ = 255;
				if (i_232_ < 0) i_232_ = 0;
				i_233_ = (int)(170.0F + 170.0F * ((float)((this.m)).snap[1] / 100.0F));
				if (i_233_ > 255) i_233_ = 255;
				if (i_233_ < 0) i_233_ = 0;
				i_234_ = 0;
				if (i_216_ <= 0) {
					if (i_224_ <= 45 && i_216_ != -2 && this.cntan == 0) {
						i_232_ = (i_232_ * i_224_ + ((this.m).csky[0] * (45 - i_224_))) / 45;
						i_233_ = (i_233_ * i_224_ + ((this.m).csky[1] * (45 - i_224_))) / 45;
						i_234_ = (i_234_ * i_224_ + ((this.m).csky[2] * (45 - i_224_))) / 45;
					}
				} else if (this.flk) {
					i_232_ = (int)(255.0F + 255.0F * ((float)((
					this.m)
						.snap[0]) / 100.0F));
					if (i_232_ > 255) i_232_ = 255;
					if (i_232_ < 0) i_232_ = 0;
					i_233_ = 0;
				}
				this.rd.setColor(new Color(i_232_, i_233_,
				i_234_));
				this.rd.drawPolygon(is, is_217_, 7);
			}
		} else {
			int i_236_ = 0;
			if (this.multion != 0) i_236_ = 8;
			for (int i_237_ = 0; i_237_ < 7; i_237_++) {
				is[i_237_] = xs(is[i_237_], is_218_[i_237_]);
				is_217_[i_237_] = ys(is_217_[i_237_], is_218_[i_237_]) + i_236_;
			}
			int i_238_ = (int)(159.0F + (159.0F * ((float)(this.m).snap[0] / 100.0F)));
			if (i_238_ > 255) i_238_ = 255;
			if (i_238_ < 0) i_238_ = 0;
			int i_239_ = (int)(207.0F + (207.0F * ((float)(this.m).snap[1] / 100.0F)));
			if (i_239_ > 255) i_239_ = 255;
			if (i_239_ < 0) i_239_ = 0;
			int i_240_ = (int)(255.0F + (255.0F * ((float)(this.m).snap[2] / 100.0F)));
			if (i_240_ > 255) i_240_ = 255;
			if (i_240_ < 0) i_240_ = 0;
			this.rd.setColor(new Color(i_238_, i_239_, i_240_));
			this.rd.fillPolygon(is, is_217_, 7);
			i_238_ = (int)(120.0F + (120.0F * ((float)(this.m).snap[0] / 100.0F)));
			if (i_238_ > 255) i_238_ = 255;
			if (i_238_ < 0) i_238_ = 0;
			i_239_ = (int)(114.0F + (114.0F * ((float)(this.m).snap[1] / 100.0F)));
			if (i_239_ > 255) i_239_ = 255;
			if (i_239_ < 0) i_239_ = 0;
			i_240_ = (int)(255.0F + (255.0F * ((float)(this.m).snap[2] / 100.0F)));
			if (i_240_ > 255) i_240_ = 255;
			if (i_240_ < 0) i_240_ = 0;
			this.rd.setColor(new Color(i_238_, i_239_, i_240_));
			this.rd.drawPolygon(is, is_217_, 7);
		}
		this.rd.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_OFF));
	}

	public void radarstat(Mad mad, ContO conto, CheckPoints checkpoints) {
		this.rd.setComposite(AlphaComposite.getInstance(3,
		0.5F));
		this.rd.setColor(new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]));
		this.rd.fillRoundRect(10, 55, 172, 172, 30, 30);
		this.rd.setComposite(AlphaComposite.getInstance(3,
		1.0F));
		this.rd.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_ON));
		this.rd.setColor(new Color((this.m).csky[0] / 2, (this.m).csky[1] / 2, (this.m).csky[2] / 2));
		for (int i = 0; i < (checkpoints).n; i++) {
			int i_241_ = i + 1;
			if (i == (checkpoints).n - 1) i_241_ = 0;
			boolean bool = false;
			if ((checkpoints).typ[i_241_] == -3) {
				i_241_ = 0;
				bool = true;
			}
			int[] is = {
				(int)(96.0F - ((float)(((checkpoints).opx[this.im]) - (checkpoints).x[i]) / (checkpoints).prox)), (int)(96.0F - ((float)(((checkpoints).opx[this.im]) - (checkpoints).x[i_241_]) / (checkpoints).prox))
			};
			int[] is_242_ = {
				(int)(141.0F - ((float)((checkpoints).z[i] - ((checkpoints)
					.opz[this.im])) / (checkpoints).prox)), (int)(141.0F - ((float)((checkpoints).z[i_241_] - ((checkpoints).opz[this.im])) / (checkpoints).prox))
			};
			rot(is, is_242_, 96, 141, (mad).cxz, 2);
			this.rd.drawLine(is[0], is_242_[0], is[1],
			is_242_[1]);
			if (bool) break;
		}
		boolean bool = false;
		boolean bool_243_ = false;
		boolean bool_244_ = false;
		if (this.arrace || this.multion > 1) {
			int[] is = new int[this.nplayers];
			int[] is_245_ = new int[this.nplayers];
			for (int i = 0; i < this.nplayers; i++) {
				is[i] = (int)(96.0F - ((float)(((checkpoints).opx[this.im]) - (checkpoints).opx[i]) / (checkpoints).prox));
				is_245_[i] = (int)(141.0F - ((float)((checkpoints).opz[i] - ((checkpoints).opz[this.im])) / (checkpoints).prox));
			}
			rot(is, is_245_, 96, 141, (mad).cxz,
			this.nplayers);
			int i = 0;
			int i_246_ = (int)(80.0F + (80.0F * ((float)(this.m).snap[1] / 100.0F)));
			if (i_246_ > 255) i_246_ = 255;
			if (i_246_ < 0) i_246_ = 0;
			int i_247_ = (int)(159.0F + (159.0F * ((float)(this.m).snap[2] / 100.0F)));
			if (i_247_ > 255) i_247_ = 255;
			if (i_247_ < 0) i_247_ = 0;
			for (int i_248_ = 0; i_248_ < this.nplayers;
			i_248_++) {
				if (i_248_ != this.im && (checkpoints).dested[i_248_] == 0) {
					if (this.clangame != 0) {
						if (this.pclan[i_248_].toLowerCase()
							.equals(this.gaclan.toLowerCase())) {
							i = 159;
							i_246_ = 80;
							i_247_ = 0;
						} else {
							i = 0;
							i_246_ = 80;
							i_247_ = 159;
						}
						i += ((float) i * ((float)((this.m).snap[0]) / 100.0F));
						if (i > 255) i = 255;
						if (i < 0) i = 0;
						i_246_ += ((float) i_246_ * ((float)((this.m)
							.snap[1]) / 100.0F));
						if (i_246_ > 255) i_246_ = 255;
						if (i_246_ < 0) i_246_ = 0;
						i_247_ += ((float) i_247_ * ((float)((this.m)
							.snap[2]) / 100.0F));
						if (i_247_ > 255) i_247_ = 255;
						if (i_247_ < 0) i_247_ = 0;
					}
					int i_249_ = 2;
					if (this.alocked == i_248_) {
						i_249_ = 3;
						this.rd.setColor(new Color(i, i_246_,
						i_247_));
					} else this.rd.setColor(new Color((i + ((this.m)
						.csky[0])) / 2, (((this.m).csky[1]) + i_246_) / 2, (i_247_ + ((this.m)
						.csky[2])) / 2));
					this.rd.drawLine(is[i_248_] - i_249_,
					is_245_[i_248_],
					is[i_248_] + i_249_,
					is_245_[i_248_]);
					this.rd.drawLine(is[i_248_],
					is_245_[i_248_] + i_249_,
					is[i_248_],
					is_245_[i_248_] - i_249_);
					this.rd.setColor(new Color(i, i_246_,
					i_247_));
					this.rd.fillRect(is[i_248_] - 1,
					is_245_[i_248_] - 1, 3, 3);
				}
			}
		}
		int i = (int)(159.0F + (159.0F * ((float)(this.m).snap[0] / 100.0F)));
		if (i > 255) i = 255;
		if (i < 0) i = 0;
		int i_250_ = 0;
		int i_251_ = 0;
		if (this.clangame != 0) {
			if (this.pclan[this.im].toLowerCase().equals(this.gaclan.toLowerCase())) {
				i = 159;
				i_250_ = 80;
				i_251_ = 0;
			} else {
				i = 0;
				i_250_ = 80;
				i_251_ = 159;
			}
			i += (float) i * ((float)(this.m).snap[0] / 100.0F);
			if (i > 255) i = 255;
			if (i < 0) i = 0;
			i_250_ += ((float) i_250_ * ((float)(this.m).snap[1] / 100.0F));
			if (i_250_ > 255) i_250_ = 255;
			if (i_250_ < 0) i_250_ = 0;
			i_251_ += ((float) i_251_ * ((float)(this.m).snap[2] / 100.0F));
			if (i_251_ > 255) i_251_ = 255;
			if (i_251_ < 0) i_251_ = 0;
		}
		this.rd.setColor(new Color((i + (this.m).csky[0]) / 2, ((this.m).csky[1] + i_250_) / 2, ((i_251_ + (this.m).csky[2]) / 2)));
		this.rd.drawLine(96, 139, 96, 143);
		this.rd.drawLine(94, 141, 98, 141);
		this.rd.setColor(new Color(i, i_250_, i_251_));
		this.rd.fillRect(95, 140, 3, 3);
		this.rd.setRenderingHint((RenderingHints.KEY_ANTIALIASING), (RenderingHints.VALUE_ANTIALIAS_OFF));
		if ((this.m).darksky) {
			Color color = new Color((this.m).csky[0], (this.m).csky[1], (this.m).csky[2]);
			float[] fs = new float[3];
			Color.RGBtoHSB((this.m).csky[0], (this.m).csky[1], (this.m).csky[2], fs);
			fs[2] = 0.6F;
			color = Color.getHSBColor(fs[0], fs[1], fs[2]);
			this.rd.setColor(color);
			this.rd.fillRect(5, 232, 181, 17);
			this.rd.drawLine(4, 233, 4, 247);
			this.rd.drawLine(3, 235, 3, 245);
			this.rd.drawLine(186, 233, 186, 247);
			this.rd.drawLine(187, 235, 187, 245);
		}
		this.rd.drawImage(this.sped, 7, 234,
		null);
		int i_252_ = (conto).x - this.lcarx;
		this.lcarx = (conto).x;
		int i_253_ = (conto).y - this.lcary;
		this.lcary = (conto).y;
		int i_254_ = (conto).z - this.lcarz;
		this.lcarz = (conto).z;
		float f = (float) Math.sqrt((double)(i_252_ * i_252_ + i_254_ * i_254_));
		float f_255_ = f * 1.4F * 21.0F * 60.0F * 60.0F / 100000.0F;
		float f_256_ = f_255_ * 0.621371F;
		this.rd.setColor(new Color(0, 0, 100));
		this.rd.drawString(new StringBuilder().append("").append((int) f_255_).toString(),
		62, 245);
		this.rd.drawString(new StringBuilder().append("").append((int) f_256_).toString(),
		132, 245);
	}

	public void playsounds(Mad mad, Control control, int i) {
		if ((this.fase == 0 || this.fase == 7001) && this.starcnt < 35 && this.cntwis != 8 && !this.mutes) {
			boolean bool = ((control).up && (mad).speed > 0.0F || (control).down && (mad).speed < 10.0F);
			boolean bool_257_ = ((mad).skid == 1 && (control).handb || Math.abs((mad).scz[0] - (((mad).scz[1] + (mad).scz[0] + (mad).scz[2] + (mad).scz[3]) / 4.0F)) > 1.0F || Math.abs((mad).scx[0] - (((mad).scx[1] + (mad).scx[0] + (mad).scx[2] + (mad).scx[3]) / 4.0F)) > 1.0F);
			boolean bool_258_ = false;
			if ((control).up && (mad).speed < 10.0F) {
				bool_257_ = true;
				bool = true;
				bool_258_ = true;
			}
			if (bool && (mad).mtouch) {
				if (!(mad).capsized) {
					if (!bool_257_) {
						if ((mad).power != 98.0F) {
							if (Math.abs((mad).speed) > 0.0F && (Math.abs((mad).speed) <= (float)((
							this.cd)
								.swits[(mad).cn][0]))) {
								int i_259_ = (int)(3.0F * Math.abs((mad).speed) / (float)((
								(this.cd))
									.swits[(mad).cn]
								[0]));
								if (i_259_ == 2) {
									if (this.pwait == 0) i_259_ = 0;
									else this.pwait--;
								} else this.pwait = 7;
								sparkeng(i_259_, (mad).cn);
							}
							if ((Math.abs((mad).speed) > (float)((
							this.cd)
								.swits[(mad).cn][0])) && (Math.abs((mad).speed) <= (float)((
							this.cd)
								.swits[(mad).cn][1]))) {
								int i_260_ = (int)(3.0F * (Math.abs((mad).speed) - (float)((
								(
								this).cd)
									.swits[(mad).cn]
								[0])) / (float)(((
								(this.cd))
									.swits[(mad).cn]
								[1]) - ((
								(
								this).cd)
									.swits[(mad).cn]
								[0])));
								if (i_260_ == 2) {
									if (this.pwait == 0) i_260_ = 0;
									else this.pwait--;
								} else this.pwait = 7;
								sparkeng(i_260_, (mad).cn);
							}
							if ((Math.abs((mad).speed) > (float)((
							this.cd)
								.swits[(mad).cn][1])) && (Math.abs((mad).speed) <= (float)((
							this.cd)
								.swits[(mad).cn][2]))) {
								int i_261_ = (int)(3.0F * (Math.abs((mad).speed) - (float)((
								(
								this).cd)
									.swits[(mad).cn]
								[1])) / (float)(((
								(this.cd))
									.swits[(mad).cn]
								[2]) - ((
								(
								this).cd)
									.swits[(mad).cn]
								[1])));
								sparkeng(i_261_, (mad).cn);
							}
						} else {
							int i_262_ = 2;
							if (this.pwait == 0) {
								if (Math.abs((mad).speed) > (float)((
								this.cd)
									.swits[(mad).cn][1])) i_262_ = 3;
							} else this.pwait--;
							sparkeng(i_262_, (mad).cn);
						}
					} else {
						sparkeng(-1, (mad).cn);
						if (bool_258_) {
							if (this.stopcnt <= 0) {
								this.air[5].loop();
								this.stopcnt = 10;
							}
						} else if (this.stopcnt <= -2) {
							this.air[2 + (int)(this.m.random() * 3.0F)].loop();
							this.stopcnt = 7;
						}
					}
				} else sparkeng(3, (mad).cn);
				this.grrd = false;
				this.aird = false;
			} else {
				this.pwait = 15;
				if (!(mad).mtouch && !this.grrd && (double) this.m.random() > 0.4) {
					this.air[(int)(this.m.random() * 4.0F)].loop();
					this.stopcnt = 5;
					this.grrd = true;
				}
				if (!(mad).wtouch && !this.aird) {
					stopairs();
					this.air[(int)(this.m.random() * 4.0F)].loop();
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
				if (this.cntwis == 7 && !this.mutes) this.firewasted.play();
			}
		} else {
			sparkeng(-2, (mad).cn);
			if (this.pwastd) {
				this.wastd.stop();
				this.pwastd = false;
			}
		}
		if (this.stopcnt != -20) {
			if (this.stopcnt == 1) stopairs();
			this.stopcnt--;
		}
		if (this.bfcrash != 0) this.bfcrash--;
		if (this.bfscrape != 0) this.bfscrape--;
		if (this.bfsc1 != 0) this.bfsc1--;
		if (this.bfsc2 != 0) this.bfsc2--;
		if (this.bfskid != 0) this.bfskid--;
		if ((mad).newcar) this.cntwis = 0;
		if (this.fase == 0 || this.fase == 7001 || this.fase == 6 || this.fase == -1 || this.fase == -2 || this.fase == -3 || this.fase == -4 || this.fase == -5) {
			if (this.mutes != (control).mutes) this.mutes = (control).mutes;
			if ((control).mutem != this.mutem) {
				this.mutem = (control).mutem;
				if (this.mutem) {
					if (this.loadedt) this.strack.stop();
				} else if (this.loadedt) this.strack.resume();
			}
		}
		if ((mad).cntdest != 0 && this.cntwis < 7) {
			if ((mad).dest) this.cntwis++;
		} else {
			if ((mad).cntdest == 0) this.cntwis = 0;
			if (this.cntwis == 7) this.cntwis = 8;
		}
		if ((this.app).applejava) closesounds();
	}

	public void stopairs() {
		for (int i = 0; i < 6; i++)
		this.air[i].stop();
	}

	public void sparkeng(int i, int i_263_) {
		if (this.lcn != i_263_) {
			for (int i_264_ = 0; i_264_ < 5; i_264_++) {
				if (this.pengs[i_264_]) {
					this.engs[((this.cd).enginsignature[this.lcn])]
					[i_264_].stop();
					this.pengs[i_264_] = false;
				}
			}
			this.lcn = i_263_;
		}
		i++;
		for (int i_265_ = 0; i_265_ < 5; i_265_++) {
			if (i == i_265_) {
				if (!this.pengs[i_265_]) {
					this.engs[((this.cd).enginsignature[i_263_])]
					[i_265_].loop();
					this.pengs[i_265_] = true;
				}
			} else if (this.pengs[i_265_]) {
				this.engs[((this.cd).enginsignature[i_263_])]
				[i_265_].stop();
				this.pengs[i_265_] = false;
			}
		}
	}

	public void crash(float f, int i) {
		if (this.bfcrash == 0) {
			if (i == 0) {
				if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F) {
					if (!this.mutes) this.lowcrash[this.crshturn].play();
					this.bfcrash = 2;
				}
				if (Math.abs(f) >= 170.0F) {
					if (!this.mutes) this.crash[this.crshturn].play();
					this.bfcrash = 2;
				}
				if (Math.abs(f) > 25.0F) {
					if (this.crashup) this.crshturn--;
					else this.crshturn++;
					if (this.crshturn == -1) this.crshturn = 2;
					if (this.crshturn == 3) this.crshturn = 0;
				}
			}
			if (i == -1) {
				if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F) {
					if (!this.mutes) this.lowcrash[2].play();
					this.bfcrash = 2;
				}
				if (Math.abs(f) > 170.0F) {
					if (!this.mutes) this.crash[2].play();
					this.bfcrash = 2;
				}
			}
			if (i == 1) {
				if (!this.mutes) this.tires.play();
				this.bfcrash = 3;
			}
		}
	}

	public void skid(int i, float f) {
		if (this.bfcrash == 0 && this.bfskid == 0 && f > 150.0F) {
			if (i == 0) {
				if (!this.mutes) this.skid[this.skflg].play();
				if (this.skidup) this.skflg++;
				else this.skflg--;
				if (this.skflg == 3) this.skflg = 0;
				if (this.skflg == -1) this.skflg = 2;
			} else {
				if (!this.mutes) this.dustskid[this.dskflg].play();
				if (this.skidup) this.dskflg++;
				else this.dskflg--;
				if (this.dskflg == 3) this.dskflg = 0;
				if (this.dskflg == -1) this.dskflg = 2;
			}
			this.bfskid = 35;
		}
	}

	public void scrape(int i, int i_266_, int i_267_) {
		if (this.bfscrape == 0 && (Math.sqrt((double)(i * i + i_266_ * i_266_ + i_267_ * i_267_)) / 10.0) > 10.0) {
			int i_268_ = 0;
			if (this.m.random() > this.m.random()) i_268_ = 1;
			if (i_268_ == 0) {
				this.sturn1 = 0;
				this.sturn0++;
				if (this.sturn0 == 3) {
					i_268_ = 1;
					this.sturn1 = 1;
					this.sturn0 = 0;
				}
			} else {
				this.sturn0 = 0;
				this.sturn1++;
				if (this.sturn1 == 3) {
					i_268_ = 0;
					this.sturn0 = 1;
					this.sturn1 = 0;
				}
			}
			if (!this.mutes) this.scrape[i_268_].play();
			this.bfscrape = 5;
		}
	}

	public void gscrape(int i, int i_269_, int i_270_) {
		if ((this.bfsc1 == 0 || this.bfsc2 == 0) && (Math.sqrt((double)(i * i + i_269_ * i_269_ + i_270_ * i_270_)) / 10.0) > 15.0) {
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
			for (int i_271_ = 0; i_271_ < 5; i_271_++)
			this.engs[i][i_271_].checkopen();
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

	public void rot(int[] is, int[] is_272_, int i, int i_273_, int i_274_,
	int i_275_) {
		if (i_274_ != 0) {
			for (int i_276_ = 0; i_276_ < i_275_; i_276_++) {
				int i_277_ = is[i_276_];
				int i_278_ = is_272_[i_276_];
				is[i_276_] = i + (int)(((float)(i_277_ - i) * this.m.cos(i_274_)) - ((float)(i_278_ - i_273_) * this.m.sin(i_274_)));
				is_272_[i_276_] = i_273_ + (int)(((float)(i_277_ - i) * this.m.sin(i_274_)) + ((float)(i_278_ - i_273_) * this.m.cos(i_274_)));
			}
		}
	}

	public int xs(int i, int i_279_) {
		if (i_279_ < 50) i_279_ = 50;
		return (((i_279_ - (this.m).focus_point) * ((this.m).cx - i) / i_279_) + i);
	}

	public int ys(int i, int i_280_) {
		if (i_280_ < 50) i_280_ = 50;
		return (((i_280_ - (this.m).focus_point) * ((this.m).cy - i) / i_280_) + i);
	}

	public int py(int i, int i_281_, int i_282_, int i_283_) {
		return ((i - i_281_) * (i - i_281_) + (i_282_ - i_283_) * (i_282_ - i_283_));
	}

	public float pys(int i, int i_284_, int i_285_, int i_286_) {
		return (float) Math.sqrt((double)((i - i_284_) * (i - i_284_) + (i_285_ - i_286_) * (i_285_ - i_286_)));
	}

	public void snap(int i) {
		this.dmg = loadsnap(this.odmg);
		this.pwr = loadsnap(this.opwr);
		this.was = loadsnap(this.owas);
		this.lap = loadsnap(this.olap);
		this.pos = loadsnap(this.opos);
		this.sped = loadsnap(this.osped);
		for (int i_287_ = 0; i_287_ < 8; i_287_++)
		this.rank[i_287_] = loadsnap(this.orank[i_287_]);
		for (int i_288_ = 0; i_288_ < 4; i_288_++)
		this.cntdn[i_288_] = loadsnap(this.ocntdn[i_288_]);
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

	public boolean overon(int i, int i_289_, int i_290_, int i_291_,
	int i_292_, int i_293_) {
		return (i_292_ > i && i_292_ < i + i_290_ && i_293_ > i_289_ && i_293_ < i_289_ + i_291_);
	}

	public boolean over(Image image, int i, int i_294_, int i_295_,
	int i_296_) {
		int i_297_ = image.getHeight(this.ob);
		int i_298_ = image.getWidth(this.ob);
		return (i > i_295_ - 5 && i < i_295_ + i_298_ + 5 && i_294_ > i_296_ - 5 && i_294_ < i_296_ + i_297_ + 5);
	}

	public void fleximage(Image image, int i, int i_299_) {
		if (!this.badmac) {
			if (i == 0) {
				this.flexpix = new int[360000];
				PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450,
				this.flexpix, 0, 800);
				try {
					pixelgrabber.grabPixels();
				} catch (InterruptedException interruptedexception) {
					/* empty */
				}
			}
			int i_300_ = 0;
			int i_301_ = 0;
			int i_302_ = 0;
			int i_303_ = 0;
			int i_304_ = (int)(Math.random() * 128.0);
			int i_305_ = (int)(5.0 + Math.random() * 15.0);
			for (int i_306_ = 0; i_306_ < 360000; i_306_++) {
				Color color = new Color(this.flexpix[i_306_]);
				boolean bool = false;
				boolean bool_307_ = false;
				boolean bool_308_ = false;
				int i_309_;
				int i_310_;
				int i_311_;
				if (i_300_ == 0) {
					i_309_ = color.getRed();
					i_301_ = i_309_;
					i_310_ = color.getGreen();
					i_302_ = i_310_;
					i_311_ = color.getBlue();
					i_303_ = i_311_;
				} else {
					i_309_ = (int)(((float) color.getRed() + (float) i_301_ * 0.38F * (float) i) / (1.0F + 0.38F * (float) i));
					i_301_ = i_309_;
					i_310_ = (int)(((float) color.getGreen() + (float) i_302_ * 0.38F * (float) i) / (1.0F + 0.38F * (float) i));
					i_302_ = i_310_;
					i_311_ = (int)(((float) color.getBlue() + (float) i_303_ * 0.38F * (float) i) / (1.0F + 0.38F * (float) i));
					i_303_ = i_311_;
				}
				if (++i_300_ == 800) i_300_ = 0;
				int i_312_ = (int)((float)(i_309_ * 17 + i_310_ + i_311_ + i_304_) / 21.0F);
				int i_313_ = (int)((float)(i_310_ * 17 + i_309_ + i_311_ + i_304_) / 22.0F);
				int i_314_ = (int)((float)(i_311_ * 17 + i_309_ + i_310_ + i_304_) / 24.0F);
				if (--i_305_ == 0) {
					i_304_ = (int)(Math.random() * 128.0);
					i_305_ = (int)(5.0 + Math.random() * 15.0);
				}
				Color color_315_ = new Color(i_312_, i_313_, i_314_);
				this.flexpix[i_306_] = color_315_.getRGB();
			}
			this.fleximg = createImage(new MemoryImageSource(800, 450, (this.flexpix),
			0, 800));
			this.rd.drawImage(this.fleximg, 0, 0,
			null);
		} else {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
			this.rd.fillRect(0, 0, 800, 450);
			this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		}
	}

	private Image loadsnap(Image image) {
		int i = image.getHeight(this.ob);
		int i_316_ = image.getWidth(this.ob);
		int[] is = new int[i_316_ * i];
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_316_, i, is, 0, i_316_);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_317_ = 0; i_317_ < i_316_ * i; i_317_++) {
			Color color = new Color(is[i_316_ * i - 1]);
			Color color_318_ = new Color(is[i_317_]);
			if (color_318_.getRed() != color_318_.getGreen() && color_318_.getGreen() != color_318_.getBlue()) {
				int i_319_ = (int)((float) color_318_.getRed() + ((float) color_318_.getRed() * ((float)((this.m)
					.snap[0]) / 100.0F)));
				if (i_319_ > 255) i_319_ = 255;
				if (i_319_ < 0) i_319_ = 0;
				int i_320_ = (int)((float) color_318_.getGreen() + ((float) color_318_.getGreen() * ((float)((this.m)
					.snap[1]) / 100.0F)));
				if (i_320_ > 255) i_320_ = 255;
				if (i_320_ < 0) i_320_ = 0;
				int i_321_ = (int)((float) color_318_.getBlue() + ((float) color_318_.getBlue() * ((float)((this.m)
					.snap[2]) / 100.0F)));
				if (i_321_ > 255) i_321_ = 255;
				if (i_321_ < 0) i_321_ = 0;
				is[i_317_] = ~0xffffff | i_319_ << 16 | i_320_ << 8 | i_321_;
			} else {
				int i_322_ = (int)((float)(color.getRed() - color_318_.getRed()) / (float) color.getRed() * 255.0F);
				if (i_322_ > 255) i_322_ = 255;
				if (i_322_ < 0) i_322_ = 0;
				is[i_317_] = i_322_ << 24 | 0x0 | 0x0 | 0x0;
			}
		}
		BufferedImage bufferedimage = new BufferedImage(i_316_, i, 2);
		bufferedimage.setRGB(0, 0, i_316_, i, is, 0, i_316_);
		return bufferedimage;
	}

	private Image loadopsnap(Image image, int i, int i_323_) {
		int i_324_ = image.getHeight(this.ob);
		int i_325_ = image.getWidth(this.ob);
		int[] is = new int[i_325_ * i_324_];
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_325_, i_324_, is, 0, i_325_);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		if (i < 0) i = 33;
		int i_326_ = 0;
		if (i_323_ == 1) i_326_ = is[61993];
		int[] is_327_ = {
			(this.m).snap[0], (this.m).snap[1], (this.m).snap[2]
		};
		while (is_327_[0] + is_327_[1] + is_327_[2] < -30) {
			for (int i_328_ = 0; i_328_ < 3; i_328_++) {
				if (is_327_[i_328_] < 50) is_327_[i_328_]++;
			}
		}
		for (int i_329_ = 0; i_329_ < i_325_ * i_324_; i_329_++) {
			if (is[i_329_] != is[i_323_]) {
				Color color = new Color(is[i_329_]);
				boolean bool = false;
				boolean bool_330_ = false;
				boolean bool_331_ = false;
				int i_332_;
				int i_333_;
				int i_334_;
				if (i_323_ == 1 && is[i_329_] == i_326_) {
					i_332_ = (int)(237.0F - 237.0F * ((float) is_327_[0] / 150.0F));
					if (i_332_ > 255) i_332_ = 255;
					if (i_332_ < 0) i_332_ = 0;
					i_333_ = (int)(237.0F - 237.0F * ((float) is_327_[1] / 150.0F));
					if (i_333_ > 255) i_333_ = 255;
					if (i_333_ < 0) i_333_ = 0;
					i_334_ = (int)(237.0F - 237.0F * ((float) is_327_[2] / 150.0F));
					if (i_334_ > 255) i_334_ = 255;
					if (i_334_ < 0) i_334_ = 0;
					if (i == 11) {
						i_332_ = 250;
						i_333_ = 250;
						i_334_ = 250;
					}
				} else {
					i_332_ = (int)((float) color.getRed() - (float) color.getRed() * ((float) is_327_[0] / 100.0F));
					if (i_332_ > 255) i_332_ = 255;
					if (i_332_ < 0) i_332_ = 0;
					i_333_ = (int)((float) color.getGreen() - ((float) color.getGreen() * ((float) is_327_[1] / 100.0F)));
					if (i_333_ > 255) i_333_ = 255;
					if (i_333_ < 0) i_333_ = 0;
					i_334_ = (int)((float) color.getBlue() - ((float) color.getBlue() * ((float) is_327_[2] / 100.0F)));
					if (i_334_ > 255) i_334_ = 255;
					if (i_334_ < 0) i_334_ = 0;
				}
				Color color_335_ = new Color(i_332_, i_333_, i_334_);
				is[i_329_] = color_335_.getRGB();
			}
		}
		Image image_336_ = createImage(new MemoryImageSource(i_325_, i_324_,
		is, 0, i_325_));
		return image_336_;
	}

	private Image pressed(Image image) {
		int i = image.getHeight(this.ob);
		int i_337_ = image.getWidth(this.ob);
		int[] is = new int[i_337_ * i];
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_337_, i, is, 0, i_337_);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_338_ = 0; i_338_ < i_337_ * i; i_338_++) {
			if (is[i_338_] != is[i_337_ * i - 1]) is[i_338_] = -16777216;
		}
		Image image_339_ = createImage(new MemoryImageSource(i_337_, i, is, 0, i_337_));
		return image_339_;
	}

	private Image bressed(Image image) {
		int i = image.getHeight(this.ob);
		int i_340_ = image.getWidth(this.ob);
		int[] is = new int[i_340_ * i];
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_340_, i, is, 0, i_340_);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		Color color = new Color(247, 255, 165);
		for (int i_341_ = 0; i_341_ < i_340_ * i; i_341_++) {
			if (is[i_341_] != is[i_340_ * i - 1]) is[i_341_] = color.getRGB();
		}
		Image image_342_ = createImage(new MemoryImageSource(i_340_, i, is, 0, i_340_));
		return image_342_;
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
			int i_343_ = 0;
			int i_344_ = 0;
			int i_345_ = 0;
			for (int i_346_ = 0; i_346_ < 360000; i_346_++) {
				Color color = new Color(is[i_346_]);
				boolean bool = false;
				int i_347_;
				if (i_345_ == 0) {
					i_347_ = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
					i_344_ = i_347_;
				} else {
					i_347_ = (color.getRed() + color.getGreen() + color.getBlue() + i_344_ * 30) / 33;
					i_344_ = i_347_;
				}
				if (++i_345_ == 800) i_345_ = 0;
				if (i_346_ > 800 * (8 + i_343_) + 281 && i_343_ < 188) {
					int i_348_ = (i_347_ + 60) / 3;
					int i_349_ = (i_347_ + 135) / 3;
					int i_350_ = (i_347_ + 220) / 3;
					if (++i == 237) {
						i_343_++;
						i = 0;
					}
					Color color_351_ = new Color(i_348_, i_349_, i_350_);
					is[i_346_] = color_351_.getRGB();
				} else {
					Color color_352_ = new Color(i_347_, i_347_, i_347_);
					is[i_346_] = color_352_.getRGB();
				}
			}
			this.fleximg = createImage(new MemoryImageSource(800, 450, is, 0, 800));
			this.rd.drawImage(this.fleximg, 0, 0,
			null);
		} else {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
			this.rd.fillRect(0, 0, 800, 450);
			this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		}
	}

	public void jflexo() {
		if (!this.badmac) {
			int[] is = new int[360000];
			PixelGrabber pixelgrabber = new PixelGrabber(((this.app)
				.offImage),
			0, 0, 800, 450, is, 0, 800);
			try {
				pixelgrabber.grabPixels();
			} catch (InterruptedException interruptedexception) {
				/* empty */
			}
			int i = 0;
			int i_353_ = 0;
			int i_354_ = 0;
			int i_355_ = 0;
			for (int i_356_ = 0; i_356_ < 360000; i_356_++) {
				Color color = new Color(is[i_356_]);
				boolean bool = false;
				boolean bool_357_ = false;
				boolean bool_358_ = false;
				int i_359_;
				int i_360_;
				int i_361_;
				if (i_355_ == 0) {
					i_359_ = color.getRed();
					i = i_359_;
					i_360_ = color.getGreen();
					i_354_ = i_360_;
					i_361_ = color.getBlue();
					i_353_ = i_361_;
				} else {
					i_359_ = (color.getRed() + i * 10) / 11;
					i = i_359_;
					i_360_ = (color.getGreen() + i_354_ * 10) / 11;
					i_354_ = i_360_;
					i_361_ = (color.getBlue() + i_353_ * 10) / 11;
					i_353_ = i_361_;
				}
				if (++i_355_ == 800) i_355_ = 0;
				Color color_362_ = new Color(i_359_, i_360_, i_361_);
				is[i_356_] = color_362_.getRGB();
			}
			Image image = createImage(new MemoryImageSource(800, 450, is, 0, 800));
			this.rd.drawImage(image, 0, 0, null);
		} else {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
			this.rd.fillRect(0, 0, 800, 450);
			this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		}
	}

	public void pingstat() {
		int i = (int)(100.0 * Math.random());
		try {
			URL url = (new URL(new StringBuilder().append("http://c.statcounter.com/9994681/0/14bb645e/1/?reco=")
				.append(i).append("").toString()));
			url.openConnection().setConnectTimeout(5000);
			Image image = Toolkit.getDefaultToolkit().createImage(url);
			MediaTracker mediatracker = new MediaTracker(this.app);
			mediatracker.addImage(image, 0);
			mediatracker.waitForID(0);
			mediatracker.removeImage(image, 0);
			Object object = null;
			Object object_363_ = null;
		} catch (Exception exception) {
			/* empty */
		}
	}

	public Image getImage(String string) {
		Image image = Toolkit.getDefaultToolkit().createImage(new StringBuilder()
			.append("").append(Madness.fpath)
			.append("").append(string).append("").toString());
		MediaTracker mediatracker = new MediaTracker(this.app);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (Exception exception) {
			/* empty */
		}
		return image;
	}

	private Image loadimage(byte[] is, MediaTracker mediatracker,
	Toolkit toolkit) {
		Image image = toolkit.createImage(is);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (Exception exception) {
			/* empty */
		}
		return image;
	}

	private Image loadude(byte[] is, MediaTracker mediatracker,
	Toolkit toolkit) {
		Image image = toolkit.createImage(is);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (Exception exception) {
			/* empty */
		}
		int i = image.getHeight(this.ob);
		int i_364_ = image.getWidth(this.ob);
		int[] is_365_ = new int[i_364_ * i];
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_364_, i, is_365_, 0, i_364_);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_366_ = 0; i_366_ < i_364_ * i; i_366_++) {
			Color color = new Color(is_365_[i_366_]);
			if (color.getGreen() > color.getRed() + 5 && color.getGreen() > color.getBlue() + 5) {
				int i_367_ = (int)(255.0F - (float)(color.getGreen() - ((color.getRed() + color.getBlue()) / 2)) * 1.5F);
				if (i_367_ > 255) i_367_ = 255;
				if (i_367_ < 0) i_367_ = 0;
				is_365_[i_366_] = i_367_ << 24 | 0x0 | 0x0 | 0x0;
			}
		}
		BufferedImage bufferedimage = new BufferedImage(i_364_, i, 2);
		bufferedimage.setRGB(0, 0, i_364_, i, is_365_, 0, i_364_);
		Object object = null;
		return bufferedimage;
	}

	private Image loadBimage(byte[] is, MediaTracker mediatracker,
	Toolkit toolkit, int i) {
		Image image = toolkit.createImage(is);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (Exception exception) {
			/* empty */
		}
		int i_368_ = image.getHeight(this.ob);
		int i_369_ = image.getWidth(this.ob);
		int[] is_370_ = new int[i_369_ * i_368_];
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_369_, i_368_, is_370_, 0,
		i_369_);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_371_ = 0; i_371_ < i_369_ * i_368_; i_371_++) {
			if (is_370_[i_371_] != is_370_[0] || i != 0) {
				Color color = new Color(is_370_[i_371_]);
				float[] fs = new float[3];
				Color.RGBtoHSB(color.getRed(), color.getGreen(),
				color.getBlue(), fs);
				fs[0] = 0.12F;
				fs[1] = 0.45F;
				if (i == 3) {
					fs[0] = 0.13F;
					fs[1] = 0.45F;
				}
				Color color_372_ = Color.getHSBColor(fs[0], fs[1], fs[2]);
				is_370_[i_371_] = color_372_.getRGB();
			}
		}
		if (i == 2) {
			Color color = new Color(is_370_[0]);
			int i_373_ = (0x40000000 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue());
			color = new Color(is_370_[1]);
			int i_374_ = (~0x7fffffff | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue());
			for (int i_375_ = 2; i_375_ < i_369_ * i_368_; i_375_++) {
				if (is_370_[i_375_] == is_370_[0]) is_370_[i_375_] = i_373_;
				if (is_370_[i_375_] == is_370_[1]) is_370_[i_375_] = i_374_;
			}
			is_370_[0] = i_373_;
			is_370_[1] = i_374_;
		}
		Object object = null;
		Image image_376_;
		if (i == 2) {
			BufferedImage bufferedimage = new BufferedImage(i_369_, i_368_, 2);
			bufferedimage.setRGB(0, 0, i_369_, i_368_, is_370_, 0, i_369_);
			image_376_ = bufferedimage;
		} else image_376_ = createImage(new MemoryImageSource(i_369_, i_368_, is_370_, 0,
		i_369_));
		Object object_377_ = null;
		return image_376_;
	}

	private Image dodgen(Image image) {
		int i = image.getHeight(this.ob);
		int i_378_ = image.getWidth(this.ob);
		int[] is = new int[i_378_ * i];
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_378_, i, is, 0, i_378_);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_379_ = 0; i_379_ < i_378_ * i; i_379_++) {
			Color color = new Color(is[i_379_]);
			int i_380_ = color.getRed() * 4 + 90;
			if (i_380_ > 255) i_380_ = 255;
			if (i_380_ < 0) i_380_ = 0;
			int i_381_ = color.getGreen() * 4 + 90;
			if (i_381_ > 255) i_381_ = 255;
			if (i_381_ < 0) i_381_ = 0;
			int i_382_ = color.getBlue() * 4 + 90;
			if (i_382_ > 255) i_382_ = 255;
			if (i_382_ < 0) i_382_ = 0;
			Color color_383_ = new Color(i_380_, i_381_, i_382_);
			is[i_379_] = color_383_.getRGB();
		}
		Image image_384_ = createImage(new MemoryImageSource(i_378_, i, is, 0, i_378_));
		return image_384_;
	}

	private void smokeypix(byte[] is, MediaTracker mediatracker,
	Toolkit toolkit) {
		Image image = toolkit.createImage(is);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (Exception exception) {
			/* empty */
		}
		PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202,
		this.smokey, 0, 466);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i = 0; i < 94132; i++) {
			if (this.smokey[i] != this.smokey[0]) {
				Color color = new Color(this.smokey[i]);
				float[] fs = new float[3];
				Color.RGBtoHSB(color.getRed(), color.getGreen(),
				color.getBlue(), fs);
				fs[0] = 0.11F;
				fs[1] = 0.45F;
				Color color_385_ = Color.getHSBColor(fs[0], fs[1], fs[2]);
				this.smokey[i] = color_385_.getRGB();
			}
		}
	}

	private void makecarsbgc(Image image, Image image_386_) {
		int[] is = new int[268000];
		PixelGrabber pixelgrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400, is,
		0, 670);
		try {
			pixelgrabber.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		int[] is_387_ = new int[20700];
		PixelGrabber pixelgrabber_388_ = new PixelGrabber(image, 0, 0, 92, 225, is_387_, 0, 92);
		try {
			pixelgrabber_388_.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		int[] is_389_ = new int[2112];
		PixelGrabber pixelgrabber_390_ = new PixelGrabber(image_386_, 0, 0, 88, 24, is_389_, 0, 88);
		try {
			pixelgrabber_390_.grabPixels();
		} catch (InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i = 0; i < 670; i++) {
			for (int i_391_ = 0; i_391_ < 400; i_391_++) {
				if (i > 14 && i < 106 && i_391_ > 11 && i_391_ < 236 && is_387_[i - 14 + (i_391_ - 11) * 92] != is_387_[0]) {
					Color color = new Color(is[i + i_391_ * 670]);
					Color color_392_ = new Color(is_387_[i - 14 + (i_391_ - 11) * 92]);
					int i_393_ = (int)((double) color.getRed() * 0.33 + (double) color_392_.getRed() * 0.67);
					if (i_393_ > 255) i_393_ = 255;
					if (i_393_ < 0) i_393_ = 0;
					int i_394_ = (int)((double) color.getGreen() * 0.33 + (double) color_392_.getGreen() * 0.67);
					if (i_394_ > 255) i_394_ = 255;
					if (i_394_ < 0) i_394_ = 0;
					int i_395_ = (int)((double) color.getBlue() * 0.33 + (double) color_392_.getBlue() * 0.67);
					if (i_395_ > 255) i_395_ = 255;
					if (i_395_ < 0) i_395_ = 0;
					Color color_396_ = new Color(i_393_, i_394_, i_395_);
					is[i + i_391_ * 670] = color_396_.getRGB();
				}
				if (i > 564 && i < 656 && i_391_ > 11 && i_391_ < 236 && is_387_[i - 564 + (i_391_ - 11) * 92] != is_387_[0]) {
					Color color = new Color(is[i + i_391_ * 670]);
					Color color_397_ = new Color(is_387_[i - 564 + (i_391_ - 11) * 92]);
					int i_398_ = (int)((double) color.getRed() * 0.33 + (double) color_397_.getRed() * 0.67);
					if (i_398_ > 255) i_398_ = 255;
					if (i_398_ < 0) i_398_ = 0;
					int i_399_ = (int)((double) color.getGreen() * 0.33 + (double) color_397_.getGreen() * 0.67);
					if (i_399_ > 255) i_399_ = 255;
					if (i_399_ < 0) i_399_ = 0;
					int i_400_ = (int)((double) color.getBlue() * 0.33 + (double) color_397_.getBlue() * 0.67);
					if (i_400_ > 255) i_400_ = 255;
					if (i_400_ < 0) i_400_ = 0;
					Color color_401_ = new Color(i_398_, i_399_, i_400_);
					is[i + i_391_ * 670] = color_401_.getRGB();
				}
				if (i > 440 && i < 528 && i_391_ > 53 && i_391_ < 77 && is_389_[i - 440 + (i_391_ - 53) * 88] != is_389_[0]) {
					Color color = new Color(is[i + i_391_ * 670]);
					Color color_402_ = new Color(is_389_[i - 440 + (i_391_ - 53) * 88]);
					int i_403_ = (int)((double) color.getRed() * 0.33 + (double) color_402_.getRed() * 0.67);
					if (i_403_ > 255) i_403_ = 255;
					if (i_403_ < 0) i_403_ = 0;
					int i_404_ = (int)((double) color.getGreen() * 0.33 + (double) color_402_.getGreen() * 0.67);
					if (i_404_ > 255) i_404_ = 255;
					if (i_404_ < 0) i_404_ = 0;
					int i_405_ = (int)((double) color.getBlue() * 0.33 + (double) color_402_.getBlue() * 0.67);
					if (i_405_ > 255) i_405_ = 255;
					if (i_405_ < 0) i_405_ = 0;
					Color color_406_ = new Color(i_403_, i_404_, i_405_);
					is[i + i_391_ * 670] = color_406_.getRGB();
				}
			}
		}
		this.carsbgc = createImage(new MemoryImageSource(670, 400, is, 0, 670));
	}

	public void carsbginflex() {
		if (!this.badmac) {
			this.flatr = 0;
			this.flyr = (int)(this.m.random() * 160.0F - 80.0F);
			this.flyrdest = (int)((float) this.flyr + this.m.random() * 160.0F - 80.0F);
			this.flang = 1;
			this.flexpix = new int[268000];
			PixelGrabber pixelgrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400,
			this.flexpix, 0, 670);
			try {
				pixelgrabber.grabPixels();
			} catch (InterruptedException interruptedexception) {
				/* empty */
			}
		}
	}

	public void drawSmokeCarsbg() {
		if (!this.badmac) {
			if (Math.abs(this.flyr - this.flyrdest) > 20) {
				if (this.flyr > this.flyrdest) this.flyr -= 20;
				else this.flyr += 20;
			} else {
				this.flyr = this.flyrdest;
				this.flyrdest = (int)((float) this.flyr + this.m.random() * 160.0F - 80.0F);
			}
			if (this.flyr > 160) this.flyr = 160;
			if (this.flatr > 170) {
				this.flatrstart++;
				this.flatr = this.flatrstart * 3;
				this.flyr = (int)(this.m.random() * 160.0F - 80.0F);
				this.flyrdest = (int)((float) this.flyr + this.m.random() * 160.0F - 80.0F);
				this.flang = 1;
			}
			for (int i = 0; i < 466; i++) {
				for (int i_407_ = 0; i_407_ < 202; i_407_++) {
					if (this.smokey[i + i_407_ * 466] != this.smokey[0]) {
						float f = pys(i, 233, i_407_, this.flyr);
						int i_408_ = (int)((float)(i - 233) / f * (float) this.flatr);
						int i_409_ = (int)((float)(i_407_ - this.flyr) / f * (float) this.flatr);
						int i_410_ = i + i_408_ + 100 + (i_407_ + i_409_ + 110) * 670;
						if (i + i_408_ + 100 < 670 && i + i_408_ + 100 > 0 && i_407_ + i_409_ + 110 < 400 && i_407_ + i_409_ + 110 > 0 && i_410_ < 268000 && i_410_ >= 0) {
							Color color = new Color(this.flexpix[i_410_]);
							Color color_411_ = new Color(this.smokey[i + i_407_ * 466]);
							float f_412_ = ((255.0F - (float) color_411_.getRed()) / 255.0F);
							float f_413_ = ((255.0F - (float) color_411_.getGreen()) / 255.0F);
							float f_414_ = ((255.0F - (float) color_411_.getBlue()) / 255.0F);
							int i_415_ = (int)((((float) color.getRed() * ((float) this.flang * f_412_)) + ((float) color_411_.getRed() * (1.0F - f_412_))) / (((float) this.flang * f_412_) + (1.0F - f_412_)));
							int i_416_ = (int)((((float) color.getGreen() * ((float) this.flang * f_413_)) + ((float) color_411_.getGreen() * (1.0F - f_413_))) / (((float) this.flang * f_413_) + (1.0F - f_413_)));
							int i_417_ = (int)((((float) color.getBlue() * ((float) this.flang * f_414_)) + ((float) color_411_.getBlue() * (1.0F - f_414_))) / (((float) this.flang * f_414_) + (1.0F - f_414_)));
							if (i_415_ > 255) i_415_ = 255;
							if (i_415_ < 0) i_415_ = 0;
							if (i_416_ > 255) i_416_ = 255;
							if (i_416_ < 0) i_416_ = 0;
							if (i_417_ > 255) i_417_ = 255;
							if (i_417_ < 0) i_417_ = 0;
							Color color_418_ = new Color(i_415_, i_416_, i_417_);
							this.flexpix[i_410_] = color_418_.getRGB();
						}
					}
				}
			}
			this.flang += 2;
			this.flatr += 10 + this.flatrstart * 2;
			Image image = createImage(new MemoryImageSource(670, 400, (this.flexpix),
			0, 670));
			this.rd.drawImage(image, 65, 25, null);
		} else {
			this.rd.drawImage(this.carsbg, 65,
			25, null);
			this.flatrstart++;
		}
	}

	public boolean msgcheck(String string) {
		boolean bool = false;
		string = string.toLowerCase();
		String[] strings = {
			"fu ", " rape", "slut ", "screw ", "redtube", "fuck", "fuk",
				"f*ck", "fu*k", "f**k", "ass hole", "asshole", "dick", "dik",
				"cock", "cok ", "shit", "damn", "sex", "anal", "whore",
				"bitch", "biatch", "bich", " ass", "bastard", "cunt", "dildo",
				"fag", "homo", "mothaf", "motherf", "negro", "nigga", "nigger",
				"pussy", "gay", "homo", "you punk", "i will kill you"
		};
		for (int i = 0; i < strings.length; i++) {
			if (string.indexOf(strings[i]) != -1) bool = true;
		}
		if (string.startsWith("ass ")) bool = true;
		if (string.equals("ass")) bool = true;
		if (string.equals("rape")) bool = true;
		if (string.equals("fu")) bool = true;
		String string_419_ = "";
		String string_420_ = "";
		int i = 0;
		boolean bool_421_ = false;
		boolean bool_422_;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++) {
			if (!bool_421_) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				bool_421_ = true;
			} else {
				bool_421_ = false;
				if (!string_420_.equals("") && !string_420_.equals(new StringBuilder().append("")
					.append(string.charAt(i)).toString())) bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		}
		if (!bool_422_) {
			for (int i_423_ = 0; i_423_ < strings.length; i_423_++) {
				if (string_419_.indexOf(strings[i_423_]) != -1) bool = true;
			}
		}
		string_419_ = "";
		string_420_ = "";
		i = 0;
		bool_421_ = true;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++) {
			if (!bool_421_) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				bool_421_ = true;
			} else {
				bool_421_ = false;
				if (!string_420_.equals("") && !string_420_.equals(new StringBuilder().append("")
					.append(string.charAt(i)).toString())) bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		}
		if (!bool_422_) {
			for (int i_424_ = 0; i_424_ < strings.length; i_424_++) {
				if (string_419_.indexOf(strings[i_424_]) != -1) bool = true;
			}
		}
		string_419_ = "";
		string_420_ = "";
		i = 0;
		int i_425_ = 0;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++) {
			if (i_425_ == 0) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				i_425_ = 2;
			} else {
				i_425_--;
				if (!string_420_.equals("") && !string_420_.equals(new StringBuilder().append("")
					.append(string.charAt(i)).toString())) bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		}
		if (!bool_422_) {
			for (int i_426_ = 0; i_426_ < strings.length; i_426_++) {
				if (string_419_.indexOf(strings[i_426_]) != -1) bool = true;
			}
		}
		string_419_ = "";
		string_420_ = "";
		i = 0;
		i_425_ = 1;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++) {
			if (i_425_ == 0) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				i_425_ = 2;
			} else {
				i_425_--;
				if (!string_420_.equals("") && !string_420_.equals(new StringBuilder().append("")
					.append(string.charAt(i)).toString())) bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		}
		if (!bool_422_) {
			for (int i_427_ = 0; i_427_ < strings.length; i_427_++) {
				if (string_419_.indexOf(strings[i_427_]) != -1) bool = true;
			}
		}
		string_419_ = "";
		string_420_ = "";
		i = 0;
		i_425_ = 2;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++) {
			if (i_425_ == 0) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				i_425_ = 2;
			} else {
				i_425_--;
				if (!string_420_.equals("") && !string_420_.equals(new StringBuilder().append("")
					.append(string.charAt(i)).toString())) bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		}
		if (!bool_422_) {
			for (int i_428_ = 0; i_428_ < strings.length; i_428_++) {
				if (string_419_.indexOf(strings[i_428_]) != -1) bool = true;
			}
		}
		return bool;
	}

	public boolean drawcarb(boolean bool, Image image, String string, int i,
	int i_429_, int i_430_, int i_431_,
	boolean bool_432_) {
		boolean bool_433_ = false;
		boolean bool_434_ = false;
		this.rd.setFont(new Font("Arial", 1, 13));
		this.ftm = this.rd.getFontMetrics();
		int i_435_;
		if (bool) {
			i_435_ = this.ftm.stringWidth(string);
			if (string.startsWith("Class")) i_435_ = 112;
		} else i_435_ = image.getWidth(this.ob);
		int i_436_ = 0;
		if (i_430_ > i && i_430_ < i + i_435_ + 14 && i_431_ > i_429_ && i_431_ < i_429_ + 28) {
			i_436_ = 1;
			if (bool_432_) bool_433_ = true;
		}
		this.rd.drawImage(this.bcl[i_436_], i,
		i_429_, null);
		this.rd.drawImage(this.bc[i_436_], i + 4,
		i_429_, i_435_ + 6, 28, null);
		this.rd.drawImage(this.bcr[i_436_],
		i + i_435_ + 10, i_429_, null);
		if (!bool && i_435_ == 73) i_429_--;
		if (bool) {
			if (string.equals("X") && i_436_ == 1) this.rd.setColor(new Color(255, 0, 0));
			else this.rd.setColor(new Color(0, 0, 0));
			if (string.startsWith("Class")) this.rd.drawString(string,
			400 - this.ftm.stringWidth(string) / 2,
			i_429_ + 19);
			else this.rd.drawString(string, i + 7, i_429_ + 19);
		} else this.rd.drawImage(image, i + 7, i_429_ + 7, null);
		return bool_433_;
	}

	public void drawWarning() {
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(0, 0, 800, 450);
		this.rd.setFont(new Font("Arial", 1, 22));
		this.ftm = this.rd.getFontMetrics();
		drawcs(100, "Warning!", 255, 0, 0, 3);
		this.rd.setFont(new Font("Arial", 1, 18));
		this.ftm = this.rd.getFontMetrics();
		drawcs(150,
			"Bad language and flooding is strictly prohibited in this game!",
		255, 255, 255, 3);
		this.rd.setFont(new Font("Arial", 1, 13));
		this.ftm = this.rd.getFontMetrics();
		if (this.warning < 210) drawcs(200,
			"If you continue typing bad language or flooding your game will shut down.",
		200, 200, 200, 3);
		if (this.warning > 210) drawcs(200,
			"Sorry. This was your second warring your game has shut down.",
		200, 200, 200, 3);
		if (this.warning > 250) {
			stopallnow();
			this.runtyp = 0;
			this.app.repaint();
			(this.app).gamer.stop();
		}
	}

	public int getvalue(String string, int i) {
		int i_437_ = -1;
		try {
			int i_438_ = 0;
			int i_439_ = 0;
			int i_440_ = 0;
			String string_441_ = "";
			String string_442_ = "";
			for ( /**/ ; i_438_ < string.length() && i_440_ != 2; i_438_++) {
				string_441_ = new StringBuilder().append("").append(string.charAt(i_438_)).toString();
				if (string_441_.equals("|")) {
					i_439_++;
					if (i_440_ == 1 || i_439_ > i) i_440_ = 2;
				} else if (i_439_ == i) {
					string_442_ = new StringBuilder().append(string_442_).append(string_441_).toString();
					i_440_ = 1;
				}
			}
			if (string_442_.equals("")) string_442_ = "-1";
			i_437_ = Integer.valueOf(string_442_).intValue();
		} catch (Exception exception) {
			/* empty */
		}
		return i_437_;
	}

	public String getSvalue(String string, int i) {
		String string_443_ = "";
		try {
			int i_444_ = 0;
			int i_445_ = 0;
			int i_446_ = 0;
			String string_447_ = "";
			String string_448_ = "";
			for ( /**/ ; i_444_ < string.length() && i_446_ != 2; i_444_++) {
				string_447_ = new StringBuilder().append("").append(string.charAt(i_444_)).toString();
				if (string_447_.equals("|")) {
					i_445_++;
					if (i_446_ == 1 || i_445_ > i) i_446_ = 2;
				} else if (i_445_ == i) {
					string_448_ = new StringBuilder().append(string_448_).append(string_447_).toString();
					i_446_ = 1;
				}
			}
			string_443_ = string_448_;
		} catch (Exception exception) {
			/* empty */
		}
		return string_443_;
	}
}