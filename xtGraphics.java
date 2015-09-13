
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
	/**
	 *
	 */
	private static final long serialVersionUID = 1254986552635023147L;
	int acexp = 0;
	String[][] adj = { { "Cool", "Alright", "Nice" }, { "Wicked", "Amazing", "Super" },
			{ "Awesome", "Ripping", "Radical" }, { "What the...?", "You're a super star!!!!", "Who are you again...?" },
			{ "surf style", "off the lip", "bounce back" } };
	boolean aflk = false;
	soundClip[] air = new soundClip[6];
	boolean aird = false;
	float[][] allrnp = new float[8][6];
	int alocked = -1;
	int ana = 0;
	GameSparker app;
	Image arn;
	float[] arnp = { 0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F };
	boolean arrace = false;
	Image arrows;
	String asay = "";
	Image asd;
	Image asu;
	int auscnt = 45;
	boolean autolog = false;
	Image[] back = new Image[2];
	String backlog = "";
	boolean badmac = false;
	int basefase = 0;
	Image[] bc = new Image[2];
	Image[] bcl = new Image[2];
	Image[] bcr = new Image[2];
	int beststunt = 0;
	int bfcrash = 0;
	int bfsc1 = 0;
	int bfsc2 = 0;
	int bfscrape = 0;
	int bfskid = 0;
	float bgf = 0.0F;
	Image bggo;
	Image bgmain;
	int[] bgmy = { 0, -400 };
	boolean bgup = false;
	Image bob;
	Image bol;
	Image bolp;
	Image bolps;
	Image bols;
	Image bor;
	Image borp;
	Image borps;
	Image bors;
	Image bot;
	Image br;
	Image brt;
	Image byrd;
	Image cancel;
	soundClip carfixed;
	Image carsbg;
	Image carsbgc;
	Image ccar;
	CarDefine cd;
	int cfase = 0;
	Image cgame;
	Image change;
	Image chat;
	soundClip checkpoint;
	Image chil;
	Chronometer chrono;
	boolean chronostart;
	String clan = "";
	boolean clanchat = false;
	int clangame = 0;
	String clankey = "";
	int clear = 0;
	Image cmc;
	String[][] cnames = { { "", "", "", "", "", "", "Game Chat  " }, { "", "", "", "", "", "", "Your Clan's Chat  " } };
	Image cnmc;
	int cntan = 0;
	int[] cntchatp = { 0, 0 };
	Image[] cntdn = new Image[4];
	int cntflock = 0;
	int cntovn = 0;
	int cntptrys = 5;
	int cntwis = 0;
	Image congrd;
	Image[] contin = new Image[2];
	soundClip[] crash = new soundClip[3];
	boolean crashup = false;
	Image crd;
	int crshturn = 0;
	int[] dcrashes = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] delays = { 600, 600, 600 };
	int[] dested = { 0, 0, 0, 0, 0, 0, 0, 0 };
	BufferedReader din;
	Image disco;
	int discon = 0;
	int dmcnt = 0;
	boolean dmflk = false;
	Image dmg;
	int dnload = 0;
	PrintWriter dout;
	int dropf = 0;
	int dskflg = 0;
	Image[] dude = new Image[3];
	int dudo = 0;
	int duds = 0;
	soundClip[] dustskid = new soundClip[3];
	soundClip[][] engs = new soundClip[5][5];
	Image exit;
	Image exitgame;
	int exitm = 0;
	String[] exlm = { "!", "!!", "!!!" };
	int fase = 111;
	int fastestlap = 0;
	soundClip firewasted;
	boolean firstime = true;
	Image fixhoop;
	int flang = 0;
	Image flaot;
	int flatr = 0;
	int flatrstart = 0;
	Image fleximg;
	int[] flexpix = null;
	int flipo = 0;
	boolean flk = false;
	int flkat = 0;
	int[] floater = { 0, 0 };
	int flyr = 0;
	int flyrdest = 0;
	int forstart = 0;
	FontMetrics ftm;
	Image gac;
	String gaclan = "";
	Image gamefinished;
	Image gameh;
	Image gameov;
	int gameport = 7001;
	Image games;
	int gatey = 300;
	Image gmc;
	int gmode = 0;
	soundClip go;
	int gocnt = 0;
	boolean gotlog = false;
	boolean grrd = false;
	int gxdu = 0;
	int gydu = 0;
	Image hello;
	int holdcnt = 0;
	boolean holdit = false;
	int hours = 8;
	int im = 0;
	RadicalMod intertrack;
	boolean[] isbot = new boolean[8];
	boolean justwon1 = false;
	boolean justwon2 = false;
	int kbload = 0;
	Image kenter;
	Image km;
	Image kn;
	Image ks;
	Image kv;
	Image kx;
	Image kz;
	int lalocked = -1;
	boolean lan = false;
	Image lanm;
	Image lap;
	int laps = 0;
	int laptime = 0;
	int lcarx = 0;
	int lcary = 0;
	int lcarz = 0;
	String[] lcmsg = { "", "" };
	int lcn = 0;
	int lfrom = 0;
	int lmode = 0;
	Image loadbar;
	boolean loadedt = false;
	Image loadingmusic;
	String localserver = "";
	int lockcnt = 0;
	boolean logged = false;
	Image login;
	Image logocars;
	Image logomadbg;
	Image logomadnes;
	Image logout;
	String loop = "";
	int looped = 1;
	soundClip[] lowcrash = new soundClip[3];
	int lsc = -1;
	int lxm = -10;
	int lym = -10;
	Medium m;
	int maxsl = 15;
	Image mdness;
	int minsl = 0;
	Image mload;
	int mouson = -1;
	int[] movepos = { 0, 0 };
	int movly = 0;
	int[] msgflk = { 0, 0 };
	boolean mtop = false;
	int muhi = 0;
	int multion = 0;
	boolean mutem = false;
	boolean mutes = false;
	Image myc;
	int ndisco = 0;
	boolean newparts = false;
	Image[] next = new Image[2];
	int nextc = 0;
	Image nfm;
	Image nfmcom;
	Image nfmcoms;
	int nfmtab = 0;
	int nfreeplays = 0;
	String nickey = "";
	String nickname = "";
	boolean noclass = false;
	boolean nofull = false;
	int nplayers = 7;
	Image ntrg;
	ImageObserver ob;
	Image[] ocntdn = new Image[4];
	Image odisco;
	Image odmg;
	Image oexitgame;
	Image oflaot;
	Image ogamefinished;
	Image ogameh;
	Image olap;
	int oldfase = 0;
	Image oloadingmusic;
	soundClip one;
	Image onfmm;
	int onjoin = -1;
	boolean onlock = false;
	int onmsc = -1;
	int ontyp = 0;
	boolean onviewpro = false;
	Image opback;
	Image opos;
	int opselect = 0;
	Image opti;
	Image opti2;
	Image opwr;
	Image[] orank = new Image[8];
	Image ory;
	int osc = 10;
	Image osped;
	Image[] ostar = new Image[2];
	int[] ovh = { 0, 0, 0, 0 };
	int[] ovsx = { 0, 0, 0, 0 };
	int[] ovw = { 0, 0, 0, 0 };
	int[] ovx = { 0, 0, 0, 0 };
	int[] ovy = { 0, 0, 0, 0 };
	Image owas;
	Image owgame;
	Image oyoulost;
	Image oyourwasted;
	Image oyouwastedem;
	Image oyouwon;
	Image paused;
	int pback = 0;
	String[] pclan = { "", "", "", "", "", "", "", "" };
	int pcontin = 0;
	boolean[] pengs = new boolean[5];
	int[] pgady = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	boolean[] pgas = { false, false, false, false, false, false, false, false, false };
	Image pgate;
	int[] pgatx = { 211, 240, 280, 332, 399, 466, 517, 558, 586 };
	int[] pgaty = { 193, 213, 226, 237, 244, 239, 228, 214, 196 };
	int pin = 60;
	Image play;
	Image players;
	int playingame = -1;
	Image pln;
	String[] plnames = { "", "", "", "", "", "", "", "" };
	Image pls;
	Image plus;
	int pnext = 0;
	int[] pointc = { 6, 6 };
	Image pos;
	int posit = 0;
	soundClip powerup;
	int pstar = 0;
	int pwait = 7;
	boolean pwastd = false;
	int pwcnt = 0;
	boolean pwflk = false;
	Image pwr;
	Image racing;
	Image radicalplay;
	int radpx = 212;
	Image[] rank = new Image[8];
	int ransay = 0;
	Graphics2D rd;
	Image redy;
	Image register;
	boolean remi = false;
	int removeds = 0;
	Image roomp;
	Image rpro;
	Thread runner;
	int runtyp = 0;
	Image sarrow;
	String say = "";
	int[] sc = { 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] scm = { 0, 0 };
	soundClip[] scrape = new soundClip[4];
	Image sdets;
	Image select;
	Image selectcar;
	int sendstat = 0;
	String[][] sentn = { { "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "" } };
	String server = "multiplayer.needformadness.com";
	String servername = "Madness";
	int servport = 7071;
	boolean shaded = false;
	float shload = 0.0F;
	boolean showtf = false;
	Image sign;
	int skflg = 0;
	soundClip[] skid = new soundClip[3];
	boolean skidup = false;
	int[] smokey = new int[94132];
	int[] sndsize = { 39, 128, 23, 58, 106, 140, 81, 135, 38, 141, 106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65,
			52, 30, 151, 129, 80, 44, 57, 123, 202, 210, 111 };
	Socket socket;
	Image space;
	Image sped;
	String spin = "";
	Image[] star = new Image[3];
	int starcnt = 0;
	Image statb;
	Image statbo;
	Image stg;
	int stopcnt = 0;
	RadicalMod strack;
	Image sts;
	Image stunts;
	int sturn0 = 0;
	int sturn1 = 0;
	int tcnt = 30;
	int testdrive = 0;
	boolean tflk = false;
	soundClip three;
	soundClip tires;
	Image top20s;
	Image[] trackbg = new Image[2];
	int trkl = 0;
	int trklim = (int) (Math.random() * 40.0);
	int[] trkx = { 65, 735 };
	soundClip two;
	int[] unlocked = { 1, 1 };
	int[] updatec = { -1, -1 };
	Image upgrade;
	int waitlink = 0;
	int warning = 0;
	Image was;
	boolean wasay = false;
	soundClip wastd;
	int wasted = 0;
	Image wasting;
	Image wgame;
	boolean winner = true;
	int[] xstart = { 0, -350, 350, 0, -350, 350, 0, 0 };
	Image yac;
	Image ycmc;
	Image youlost;
	Image yourwasted;
	Image youwastedem;
	Image youwon;
	int[] zstart = { -760, -380, -380, 0, 380, 380, 760, 0 };

	public xtGraphics(final Medium medium, final CarDefine cardefine, final Graphics2D graphics2d,
			final GameSparker gamesparker) {
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
		final SecurityManager securitymanager = System.getSecurityManager();
		if (securitymanager != null)
			try {
				securitymanager.checkConnect("needformadness.com", -1);
			} catch (final Exception exception) {
				final String string = new StringBuilder().append("").append(exception).toString();
				if (string.indexOf("access denied") != -1)
					nofull = true;
			}
		badmac = false;
		chrono = new Chronometer(this);
		chronostart = false;
	}

	public void arrow(final int i, final int i_216_, final CheckPoints checkpoints, final boolean bool) {
		final int[] is = new int[7];
		final int[] is_217_ = new int[7];
		final int[] is_218_ = new int[7];
		final int i_219_ = 400;
		final int i_220_ = -90;
		final int i_221_ = 700;
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
		int i_224_;
		if (!bool) {
			int i_225_ = 0;
			if (checkpoints.x[i] - checkpoints.opx[im] >= 0)
				i_225_ = 180;
			i_224_ = (int) (90 + i_225_ + Math.atan((double) (checkpoints.z[i] - checkpoints.opz[im])
					/ (double) (checkpoints.x[i] - checkpoints.opx[im])) / 0.017453292519943295);
		} else {
			int i_226_ = 0;
			if (multion == 0 || alocked == -1) {
				int i_227_ = -1;
				boolean bool_228_ = false;
				for (int i_229_ = 0; i_229_ < nplayers; i_229_++)
					if (i_229_ != im
							&& (py(checkpoints.opx[im] / 100, checkpoints.opx[i_229_] / 100, checkpoints.opz[im] / 100,
									checkpoints.opz[i_229_] / 100) < i_227_ || i_227_ == -1)
							&& (!bool_228_ || checkpoints.onscreen[i_229_] != 0) && checkpoints.dested[i_229_] == 0) {
						i_226_ = i_229_;
						i_227_ = py(checkpoints.opx[im] / 100, checkpoints.opx[i_229_] / 100, checkpoints.opz[im] / 100,
								checkpoints.opz[i_229_] / 100);
						if (checkpoints.onscreen[i_229_] != 0)
							bool_228_ = true;
					}
			} else
				i_226_ = alocked;
			int i_230_ = 0;
			if (checkpoints.opx[i_226_] - checkpoints.opx[im] >= 0)
				i_230_ = 180;
			i_224_ = (int) (90 + i_230_ + Math.atan((double) (checkpoints.opz[i_226_] - checkpoints.opz[im])
					/ (double) (checkpoints.opx[i_226_] - checkpoints.opx[im])) / 0.017453292519943295);
			if (multion == 0) {
				drawcs(13, "[                                ]", 76, 67, 240, 0);
				drawcs(13, cd.names[sc[i_226_]], 0, 0, 0, 0);
			} else {
				rd.setFont(new Font("Arial", 1, 12));
				ftm = rd.getFontMetrics();
				drawcs(17, "[                                ]", 76, 67, 240, 0);
				drawcs(12, plnames[i_226_], 0, 0, 0, 0);
				rd.setFont(new Font("Arial", 0, 10));
				ftm = rd.getFontMetrics();
				drawcs(24, cd.names[sc[i_226_]], 0, 0, 0, 0);
				rd.setFont(new Font("Arial", 1, 11));
				ftm = rd.getFontMetrics();
			}
		}
		for (i_224_ += m.xz; i_224_ < 0; i_224_ += 360) {
			/* empty */
		}
		for ( /**/ ; i_224_ > 180; i_224_ -= 360) {
			/* empty */
		}
		if (!bool) {
			if (i_224_ > 130)
				i_224_ = 130;
			if (i_224_ < -130)
				i_224_ = -130;
		} else {
			if (i_224_ > 100)
				i_224_ = 100;
			if (i_224_ < -100)
				i_224_ = -100;
		}
		if (Math.abs(ana - i_224_) < 180) {
			if (Math.abs(ana - i_224_) < 10)
				ana = i_224_;
			else if (ana < i_224_)
				ana += 10;
			else
				ana -= 10;
		} else {
			if (i_224_ < 0) {
				ana += 15;
				if (ana > 180)
					ana -= 360;
			}
			if (i_224_ > 0) {
				ana -= 15;
				if (ana < -180)
					ana += 360;
			}
		}
		rot(is, is_218_, i_219_, i_221_, ana, 7);
		i_224_ = Math.abs(ana);
		rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (!bool) {
			if (i_224_ > 7 || i_216_ > 0 || i_216_ == -2 || cntan != 0) {
				for (int i_231_ = 0; i_231_ < 7; i_231_++) {
					is[i_231_] = xs(is[i_231_], is_218_[i_231_]);
					is_217_[i_231_] = ys(is_217_[i_231_], is_218_[i_231_]);
				}
				int i_232_ = (int) (190.0F + 190.0F * (m.snap[0] / 100.0F));
				if (i_232_ > 255)
					i_232_ = 255;
				if (i_232_ < 0)
					i_232_ = 0;
				int i_233_ = (int) (255.0F + 255.0F * (m.snap[1] / 100.0F));
				if (i_233_ > 255)
					i_233_ = 255;
				if (i_233_ < 0)
					i_233_ = 0;
				int i_234_ = 0;
				if (i_216_ <= 0) {
					if (i_224_ <= 45 && i_216_ != -2 && cntan == 0) {
						i_232_ = (i_232_ * i_224_ + m.csky[0] * (45 - i_224_)) / 45;
						i_233_ = (i_233_ * i_224_ + m.csky[1] * (45 - i_224_)) / 45;
						i_234_ = (i_234_ * i_224_ + m.csky[2] * (45 - i_224_)) / 45;
					}
					if (i_224_ >= 90) {
						int i_235_ = (int) (255.0F + 255.0F * (m.snap[0] / 100.0F));
						if (i_235_ > 255)
							i_235_ = 255;
						if (i_235_ < 0)
							i_235_ = 0;
						i_232_ = (i_232_ * (140 - i_224_) + i_235_ * (i_224_ - 90)) / 50;
						if (i_232_ > 255)
							i_232_ = 255;
					}
				} else if (flk) {
					i_232_ = (int) (255.0F + 255.0F * (m.snap[0] / 100.0F));
					if (i_232_ > 255)
						i_232_ = 255;
					if (i_232_ < 0)
						i_232_ = 0;
					flk = false;
				} else {
					i_232_ = (int) (255.0F + 255.0F * (m.snap[0] / 100.0F));
					if (i_232_ > 255)
						i_232_ = 255;
					if (i_232_ < 0)
						i_232_ = 0;
					i_233_ = (int) (220.0F + 220.0F * (m.snap[1] / 100.0F));
					if (i_233_ > 255)
						i_233_ = 255;
					if (i_233_ < 0)
						i_233_ = 0;
					flk = true;
				}
				rd.setColor(new Color(i_232_, i_233_, i_234_));
				rd.fillPolygon(is, is_217_, 7);
				i_232_ = (int) (115.0F + 115.0F * (m.snap[0] / 100.0F));
				if (i_232_ > 255)
					i_232_ = 255;
				if (i_232_ < 0)
					i_232_ = 0;
				i_233_ = (int) (170.0F + 170.0F * (m.snap[1] / 100.0F));
				if (i_233_ > 255)
					i_233_ = 255;
				if (i_233_ < 0)
					i_233_ = 0;
				i_234_ = 0;
				if (i_216_ <= 0) {
					if (i_224_ <= 45 && i_216_ != -2 && cntan == 0) {
						i_232_ = (i_232_ * i_224_ + m.csky[0] * (45 - i_224_)) / 45;
						i_233_ = (i_233_ * i_224_ + m.csky[1] * (45 - i_224_)) / 45;
						i_234_ = (i_234_ * i_224_ + m.csky[2] * (45 - i_224_)) / 45;
					}
				} else if (flk) {
					i_232_ = (int) (255.0F + 255.0F * (m.snap[0] / 100.0F));
					if (i_232_ > 255)
						i_232_ = 255;
					if (i_232_ < 0)
						i_232_ = 0;
					i_233_ = 0;
				}
				rd.setColor(new Color(i_232_, i_233_, i_234_));
				rd.drawPolygon(is, is_217_, 7);
			}
		} else {
			int i_236_ = 0;
			if (multion != 0)
				i_236_ = 8;
			for (int i_237_ = 0; i_237_ < 7; i_237_++) {
				is[i_237_] = xs(is[i_237_], is_218_[i_237_]);
				is_217_[i_237_] = ys(is_217_[i_237_], is_218_[i_237_]) + i_236_;
			}
			int i_238_ = (int) (159.0F + 159.0F * (m.snap[0] / 100.0F));
			if (i_238_ > 255)
				i_238_ = 255;
			if (i_238_ < 0)
				i_238_ = 0;
			int i_239_ = (int) (207.0F + 207.0F * (m.snap[1] / 100.0F));
			if (i_239_ > 255)
				i_239_ = 255;
			if (i_239_ < 0)
				i_239_ = 0;
			int i_240_ = (int) (255.0F + 255.0F * (m.snap[2] / 100.0F));
			if (i_240_ > 255)
				i_240_ = 255;
			if (i_240_ < 0)
				i_240_ = 0;
			rd.setColor(new Color(i_238_, i_239_, i_240_));
			rd.fillPolygon(is, is_217_, 7);
			i_238_ = (int) (120.0F + 120.0F * (m.snap[0] / 100.0F));
			if (i_238_ > 255)
				i_238_ = 255;
			if (i_238_ < 0)
				i_238_ = 0;
			i_239_ = (int) (114.0F + 114.0F * (m.snap[1] / 100.0F));
			if (i_239_ > 255)
				i_239_ = 255;
			if (i_239_ < 0)
				i_239_ = 0;
			i_240_ = (int) (255.0F + 255.0F * (m.snap[2] / 100.0F));
			if (i_240_ > 255)
				i_240_ = 255;
			if (i_240_ < 0)
				i_240_ = 0;
			rd.setColor(new Color(i_238_, i_239_, i_240_));
			rd.drawPolygon(is, is_217_, 7);
		}
		rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
	}

	private Image bressed(final Image image) {
		final int i = image.getHeight(ob);
		final int i_340_ = image.getWidth(ob);
		final int[] is = new int[i_340_ * i];
		final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_340_, i, is, 0, i_340_);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		final Color color = new Color(247, 255, 165);
		for (int i_341_ = 0; i_341_ < i_340_ * i; i_341_++)
			if (is[i_341_] != is[i_340_ * i - 1])
				is[i_341_] = color.getRGB();
		final Image image_342_ = createImage(new MemoryImageSource(i_340_, i, is, 0, i_340_));
		return image_342_;
	}

	public void cantgo(final Control control) {
		pnext = 0;
		trackbg(false);
		rd.drawImage(br, 65, 25, null);
		rd.drawImage(select, 338, 35, null);
		rd.setFont(new Font("Arial", 1, 13));
		ftm = rd.getFontMetrics();
		drawcs(130, new StringBuilder().append("This stage will be unlocked when stage ").append(unlocked[gmode - 1])
				.append(" is complete!").toString(), 177, 177, 177, 3);
		for (int i = 0; i < 9; i++)
			rd.drawImage(pgate, 277 + i * 30, 215, null);
		rd.setFont(new Font("Arial", 1, 12));
		ftm = rd.getFontMetrics();
		if (aflk) {
			drawcs(185, new StringBuilder().append("[ Stage ").append(unlocked[gmode - 1] + 1).append(" Locked ]")
					.toString(), 255, 128, 0, 3);
			aflk = false;
		} else {
			drawcs(185, new StringBuilder().append("[ Stage ").append(unlocked[gmode - 1] + 1).append(" Locked ]")
					.toString(), 255, 0, 0, 3);
			aflk = true;
		}
		rd.drawImage(back[pback], 370, 345, null);
		lockcnt--;
		if (lockcnt == 0 || control.enter || control.handb || control.left) {
			control.left = false;
			control.handb = false;
			control.enter = false;
			fase = 1;
		}
	}

	public void cantreply() {
		rd.setColor(new Color(64, 143, 223));
		rd.fillRoundRect(200, 73, 400, 23, 7, 20);
		rd.setColor(new Color(0, 89, 223));
		rd.drawRoundRect(200, 73, 400, 23, 7, 20);
		drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
	}

	public void carsbginflex() {
		if (!badmac) {
			flatr = 0;
			flyr = (int) (m.random() * 160.0F - 80.0F);
			flyrdest = (int) (flyr + m.random() * 160.0F - 80.0F);
			flang = 1;
			flexpix = new int[268000];
			final PixelGrabber pixelgrabber = new PixelGrabber(carsbg, 0, 0, 670, 400, flexpix, 0, 670);
			try {
				pixelgrabber.grabPixels();
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		}
	}

	public void carselect(final Control control, final ContO[] contos, final Mad mad, final int i, final int i_104_,
			final boolean bool) {
		rd.setColor(new Color(0, 0, 0));
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
			if (cd.lastload == 1)
				rd.drawImage(ycmc, 337, 58, null);
			if (cd.lastload == 2)
				rd.drawImage(yac, 323, 58, null);
		}
		if (cfase == 11) {
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			String string = "Top 20 Cars";
			int i_105_ = cd.loadlist;
			String string_106_ = "Weekly";
			while (i_105_ > 6 && !Thread.currentThread().isInterrupted()) {
				i_105_ -= 6;
				if (string_106_.equals("Semi-Annual"))
					string_106_ = "Annual";
				if (string_106_.equals("Monthly"))
					string_106_ = "Semi-Annual";
				if (string_106_.equals("Weekly"))
					string_106_ = "Monthly";
			}
			if (i_105_ == 1)
				string = new StringBuilder().append("").append(string_106_).append(" Top 20 Cars").toString();
			if (i_105_ == 2)
				string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class A Cars").toString();
			if (i_105_ == 3)
				string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class A & B Cars")
						.toString();
			if (i_105_ == 4)
				string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class B Cars").toString();
			if (i_105_ == 5)
				string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class B & C Cars")
						.toString();
			if (i_105_ == 6)
				string = new StringBuilder().append("").append(string_106_).append(" Top 20 Class C Cars").toString();
			drawcs(69, string, 120, 176, 255, 3);
		}
		if (cfase == 101) {
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			drawcs(69, new StringBuilder().append("").append(cd.viewname).append("'s account cars!").toString(), 220,
					112, 33, 3);
		}
		if (!remi) {
			rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			contos[sc[0]].d(rd);
			rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
		if (cfase == 8) {
			drawprom(150, 85);
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			drawcs(195, "Removing Car...", 0, 0, 0, 3);
			if (cd.action != 10)
				if (cd.action != -10) {
					cfase = 5;
					showtf = false;
				} else
					cfase = 9;
		}
		if ((multion != 0 || testdrive == 1 || testdrive == 2) && lsc != sc[0]) {
			if (contos[sc[0]].xy != 0)
				contos[sc[0]].xy = 0;
			boolean bool_107_ = false;
			for (int i_108_ = 0; i_108_ < contos[sc[0]].npl && !bool_107_; i_108_++)
				if (contos[sc[0]].p[i_108_].colnum == 1) {
					final float[] fs = new float[3];
					Color.RGBtoHSB(contos[sc[0]].p[i_108_].c[0], contos[sc[0]].p[i_108_].c[1],
							contos[sc[0]].p[i_108_].c[2], fs);
					arnp[0] = fs[0];
					arnp[1] = fs[1];
					arnp[2] = 1.0F - fs[2];
					bool_107_ = true;
				}
			bool_107_ = false;
			for (int i_109_ = 0; i_109_ < contos[sc[0]].npl && !bool_107_; i_109_++)
				if (contos[sc[0]].p[i_109_].colnum == 2) {
					final float[] fs = new float[3];
					Color.RGBtoHSB(contos[sc[0]].p[i_109_].c[0], contos[sc[0]].p[i_109_].c[1],
							contos[sc[0]].p[i_109_].c[2], fs);
					arnp[3] = fs[0];
					arnp[4] = fs[1];
					arnp[5] = 1.0F - fs[2];
					bool_107_ = true;
				}
			final Color color = Color.getHSBColor(arnp[0], arnp[1], 1.0F - arnp[2]);
			final Color color_110_ = Color.getHSBColor(arnp[3], arnp[4], 1.0F - arnp[5]);
			for (int i_111_ = 0; i_111_ < contos[sc[0]].npl; i_111_++) {
				if (contos[sc[0]].p[i_111_].colnum == 1) {
					contos[sc[0]].p[i_111_].hsb[0] = arnp[0];
					contos[sc[0]].p[i_111_].hsb[1] = arnp[1];
					contos[sc[0]].p[i_111_].hsb[2] = 1.0F - arnp[2];
					contos[sc[0]].p[i_111_].c[0] = color.getRed();
					contos[sc[0]].p[i_111_].c[1] = color.getGreen();
					contos[sc[0]].p[i_111_].c[2] = color.getBlue();
					contos[sc[0]].p[i_111_].oc[0] = color.getRed();
					contos[sc[0]].p[i_111_].oc[1] = color.getGreen();
					contos[sc[0]].p[i_111_].oc[2] = color.getBlue();
				}
				if (contos[sc[0]].p[i_111_].colnum == 2) {
					contos[sc[0]].p[i_111_].hsb[0] = arnp[3];
					contos[sc[0]].p[i_111_].hsb[1] = arnp[4];
					contos[sc[0]].p[i_111_].hsb[2] = 1.0F - arnp[5];
					contos[sc[0]].p[i_111_].c[0] = color_110_.getRed();
					contos[sc[0]].p[i_111_].c[1] = color_110_.getGreen();
					contos[sc[0]].p[i_111_].c[2] = color_110_.getBlue();
					contos[sc[0]].p[i_111_].oc[0] = color_110_.getRed();
					contos[sc[0]].p[i_111_].oc[1] = color_110_.getGreen();
					contos[sc[0]].p[i_111_].oc[2] = color_110_.getBlue();
				}
			}
			lsc = sc[0];
		}
		int i_112_ = -1;
		int i_113_ = 0;
		boolean bool_114_ = false;
		if (flipo == 0) {
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			int i_115_ = 0;
			if (flatrstart < 6)
				i_115_ = 2;
			if (!remi && (cfase != 10 || cd.action != 0 && cd.action < 14)) {
				if (cfase == 3 && cd.lastload == 2) {
					app.mcars.move(400 - app.mcars.w / 2, 78);
					app.mcars.show = true;
					if (!app.mcars.getSelectedItem().equals(cd.names[sc[0]])) {
						for (int i_116_ = 16; i_116_ < cd.nlocars; i_116_++)
							if (cd.names[i_116_].equals(app.mcars.getSelectedItem()))
								i_112_ = i_116_;
						if (i_112_ == -1) {
							cfase = 5;
							cd.action = 4;
							cd.sparkactionloader();
						}
					}
				} else {
					app.mcars.show = false;
					String string = "";
					if (cfase == 11)
						string = new StringBuilder().append("N#").append(sc[0] - 35).append("  ").toString();
					if (aflk) {
						drawcs(95 + i_115_, new StringBuilder().append(string).append(cd.names[sc[0]]).toString(), 240,
								240, 240, 3);
						aflk = false;
					} else {
						drawcs(95, new StringBuilder().append(string).append(cd.names[sc[0]]).toString(), 176, 176, 176,
								3);
						aflk = true;
					}
				}
			} else
				app.mcars.show = false;
			contos[sc[0]].z = 950;
			if (sc[0] == 13)
				contos[sc[0]].z = 1000;
			contos[sc[0]].y = -34 - contos[sc[0]].grat;
			contos[sc[0]].x = 0;
			if (mouson >= 0 && mouson <= 3)
				contos[sc[0]].xz += 2;
			else
				contos[sc[0]].xz += 5;
			if (contos[sc[0]].xz > 360)
				contos[sc[0]].xz -= 360;
			contos[sc[0]].zy = 0;
			contos[sc[0]].wzy -= 10;
			if (contos[sc[0]].wzy < -30)
				contos[sc[0]].wzy += 30;
			if (!remi) {
				if (sc[0] != minsl)
					rd.drawImage(back[pback], 95, 275, null);
				if (sc[0] != maxsl)
					rd.drawImage(next[pnext], 645, 275, null);
			}
			if (gmode == 1) {
				if (sc[0] == 5 && unlocked[0] <= 2)
					i_113_ = 2;
				if (sc[0] == 6 && unlocked[0] <= 4)
					i_113_ = 4;
				if (sc[0] == 11 && unlocked[0] <= 6)
					i_113_ = 6;
				if (sc[0] == 14 && unlocked[0] <= 8)
					i_113_ = 8;
				if (sc[0] == 15 && unlocked[0] <= 10)
					i_113_ = 10;
			}
			if (gmode == 2 && sc[0] >= 8 && unlocked[1] <= (sc[0] - 7) * 2)
				i_113_ = (sc[0] - 7) * 2;
			if (i_113_ != 0) {
				if (gatey == 300) {
					for (int i_117_ = 0; i_117_ < 9; i_117_++) {
						pgas[i_117_] = false;
						pgady[i_117_] = 0;
					}
					pgas[0] = true;
				}
				for (int i_118_ = 0; i_118_ < 9; i_118_++) {
					rd.drawImage(pgate, pgatx[i_118_], pgaty[i_118_] + pgady[i_118_] - gatey, null);
					if (flatrstart == 6)
						if (pgas[i_118_]) {
							pgady[i_118_] -= (80 + 100 / (i_118_ + 1) - Math.abs(pgady[i_118_])) / 3;
							if (pgady[i_118_] < -(70 + 100 / (i_118_ + 1))) {
								pgas[i_118_] = false;
								if (i_118_ != 8)
									pgas[i_118_ + 1] = true;
							}
						} else {
							pgady[i_118_] += (80 + 100 / (i_118_ + 1) - Math.abs(pgady[i_118_])) / 3;
							if (pgady[i_118_] > 0)
								pgady[i_118_] = 0;
						}
				}
				if (gatey != 0)
					gatey -= 100;
				if (flatrstart == 6) {
					drawcs(355, "[ Car Locked ]", 210, 210, 210, 3);
					drawcs(375, new StringBuilder().append("This car unlocks when stage ").append(i_113_)
							.append(" is completed...").toString(), 255, 96, 0, 3);
				}
			} else {
				if (flatrstart == 6) {
					if (cfase == 10) {
						if (cd.action == 13) {
							minsl = 36;
							maxsl = cd.xnlocars - 1;
							i_112_ = 36;
							cd.action = 0;
							cfase = 11;
						}
						if (cd.action == 12) {
							int i_119_ = cd.loadlist;
							String string = "Top 20 Cars";
							String string_120_ = "Weekly";
							while (i_119_ > 6 && !Thread.currentThread().isInterrupted()) {
								i_119_ -= 6;
								if (string_120_.equals("Semi-Annual"))
									string_120_ = "Annual";
								if (string_120_.equals("Monthly"))
									string_120_ = "Semi-Annual";
								if (string_120_.equals("Weekly"))
									string_120_ = "Monthly";
							}
							if (i_119_ == 1)
								string = new StringBuilder().append("").append(string_120_).append(" Top 20 Cars")
										.toString();
							if (i_119_ == 2)
								string = new StringBuilder().append("").append(string_120_)
										.append(" Top 20 Class A Cars").toString();
							if (i_119_ == 3)
								string = new StringBuilder().append("").append(string_120_)
										.append(" Top 20 Class A & B Cars").toString();
							if (i_119_ == 4)
								string = new StringBuilder().append("").append(string_120_)
										.append(" Top 20 Class B Cars").toString();
							if (i_119_ == 5)
								string = new StringBuilder().append("").append(string_120_)
										.append(" Top 20 Class B & C Cars").toString();
							if (i_119_ == 6)
								string = new StringBuilder().append("").append(string_120_)
										.append(" Top 20 Class C Cars").toString();
							drawprom(145, 170);
							drawcs(195,
									new StringBuilder().append("[  Loading ").append(string).append("  ]").toString(),
									0, 0, 0, 3);
							if (cd.nl > 0 && cd.nl <= 20)
								drawcs(235, new StringBuilder().append("Loading :  ").append(cd.loadnames[cd.nl - 1])
										.append("").toString(), 0, 0, 0, 3);
						}
						if (cd.action == 11) {
							drawprom(145, 170);
							drawcs(195, "Loading List, Please Wait...", 0, 0, 0, 3);
						}
						if (cd.action == -1) {
							drawprom(145, 170);
							drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
							drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i, i_104_, bool)) {
								cd.action = 0;
								cfase = basefase;
							}
						}
						if (cd.action == 0 || cd.action == 14 || cd.action == 15 || cd.action == 16
								|| cd.action == 17) {
							drawprom(65, 250);
							if (drawcarb(true, null, " X ", 557, 70, i, i_104_, bool)) {
								cd.action = 0;
								cfase = basefase;
							}
							drawcs(305, "The lists get updated every 24 hours!", 0, 0, 0, 3);
							if (cd.action == 14 || cd.action == 15 || cd.action == 16 || cd.action == 17) {
								if (!bool && cntflock == 20)
									cntflock = 0;
								if (cd.action == 14)
									drawcs(91, "Weekly Top 20 Cars", 0, 0, 0, 3);
								if (cd.action == 15)
									drawcs(91, "Monthly Top 20 Cars", 0, 0, 0, 3);
								if (cd.action == 16)
									drawcs(91, "Semi-Annual Top 20 Cars", 0, 0, 0, 3);
								if (cd.action == 17)
									drawcs(91, "Annual Top 20 Cars", 0, 0, 0, 3);
								if (drawcarb(true, null, "   All Cars, All Classes   ", 318, 105, i, i_104_, bool)
										&& cntflock == 0) {
									cd.loadlist = 1 + (cd.action - 14) * 6;
									cd.action = 11;
									cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class A Cars", 337, 135, i, i_104_, bool) && cntflock == 0) {
									cd.loadlist = 2 + (cd.action - 14) * 6;
									cd.action = 11;
									cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class A & B Cars", 337, 165, i, i_104_, bool)
										&& cntflock == 0) {
									cd.loadlist = 3 + (cd.action - 14) * 6;
									cd.action = 11;
									cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class B Cars", 337, 195, i, i_104_, bool) && cntflock == 0) {
									cd.loadlist = 4 + (cd.action - 14) * 6;
									cd.action = 11;
									cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class B & C Cars", 337, 225, i, i_104_, bool)
										&& cntflock == 0) {
									cd.loadlist = 5 + (cd.action - 14) * 6;
									cd.action = 11;
									cd.sparkactionloader();
								}
								if (drawcarb(true, null, "Class C Cars", 337, 255, i, i_104_, bool) && cntflock == 0) {
									cd.loadlist = 6 + (cd.action - 14) * 6;
									cd.action = 11;
									cd.sparkactionloader();
								}
							}
							if (cd.action == 0) {
								drawcs(91, "Top 20 Most Added Public Custom Cars", 0, 0, 0, 3);
								if (drawcarb(true, null, "  Weekly Top 20  ", 338, 125, i, i_104_, bool))
									cd.action = 14;
								if (drawcarb(true, null, "  Monthly Top 20  ", 337, 165, i, i_104_, bool))
									cd.action = 15;
								if (drawcarb(true, null, "  Semi-Annual Top 20  ", 321, 205, i, i_104_, bool))
									cd.action = 16;
								if (drawcarb(true, null, "  Annual Top 20  ", 339, 245, i, i_104_, bool))
									cd.action = 17;
								if (cntflock != 20)
									cntflock = 20;
							}
						}
					}
					if (cfase == 100) {
						if (cd.action == -1) {
							drawprom(145, 170);
							drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
							drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i, i_104_, bool))
								if (sc[0] >= 16 && cd.lastload == 2 && sc[0] < 36)
									cfase = 3;
								else
									cfase = 0;
						}
						if (cd.action == -2) {
							drawprom(145, 170);
							drawcs(195, "No account cars found.", 0, 0, 0, 3);
							drawcs(225,
									new StringBuilder().append("").append(cd.viewname)
											.append(" does not have any published or added cars.").toString(),
									0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i, i_104_, bool))
								if (sc[0] >= 16 && cd.lastload == 2 && sc[0] < 36)
									cfase = 3;
								else
									cfase = 0;
						}
						if (cd.action == 100) {
							cd.action = 101;
							cd.sparkactionloader();
						}
						if (cd.action == 101) {
							drawprom(145, 170);
							drawcs(195, new StringBuilder().append("Loading ").append(cd.viewname)
									.append("'s account cars, please wait...").toString(), 0, 0, 0, 3);
						}
						if (cd.action == 102) {
							drawprom(145, 170);
							drawcs(195, new StringBuilder().append("Loading ").append(cd.viewname)
									.append("'s account cars, please wait...").toString(), 0, 0, 0, 3);
							if (cd.nl > 0 && cd.nl <= 20)
								drawcs(235, new StringBuilder().append("Loading :  ").append(cd.loadnames[cd.nl - 1])
										.append("").toString(), 0, 0, 0, 3);
						}
						if (cd.action == 103) {
							minsl = 36;
							maxsl = cd.xnlocars - 1;
							i_112_ = 36;
							cd.action = 0;
							cfase = 101;
						}
					}
					if (cfase == 0 && testdrive != 1 && testdrive != 2 && gmode == 0) {
						int i_121_ = 95;
						int i_122_ = 5;
						if (multion != 0) {
							i_121_ = 185;
							i_122_ = 0;
						}
						if (multion == 0 && drawcarb(false, cmc, "", 95, 70, i, i_104_, bool))
							if (cd.lastload != 1)
								cfase = 1;
							else {
								minsl = 16;
								maxsl = cd.nlcars - 1;
								i_112_ = 16;
								cfase = 3;
							}
						if (drawcarb(false, myc, "", i_121_, 105 + i_122_, i, i_104_, bool))
							if (cd.lastload != 2) {
								cfase = 5;
								showtf = false;
								if (!logged) {
									cd.action = 0;
									cd.reco = -2;
									tcnt = 5;
									cntflock = 0;
								} else {
									cd.action = 3;
									cd.sparkactionloader();
								}
							} else {
								minsl = 16;
								maxsl = cd.nlocars - 1;
								if (onmsc >= minsl && onmsc <= maxsl)
									i_112_ = onmsc;
								else
									i_112_ = 16;
								cfase = 3;
							}
						if ((multion == 0 || onjoin == -1) && drawcarb(false, top20s, "", i_121_,
								(i_121_ - 95) / 7 + 25 + i_122_, i, i_104_, bool)) {
							cd.action = 0;
							cfase = 10;
						}
						if (remi)
							remi = false;
					}
					if (cfase == -1)
						if (autolog) {
							autolog = false;
							cfase = 5;
							cd.action = 1;
							cd.sparkactionloader();
						} else if (cd.lastload != 2) {
							cfase = 5;
							showtf = false;
							if (!logged) {
								cd.action = 0;
								cd.reco = -2;
								tcnt = 5;
								cntflock = 0;
							} else {
								cd.action = 3;
								cd.sparkactionloader();
							}
						} else {
							minsl = 16;
							maxsl = cd.nlocars - 1;
							if (onmsc >= minsl && onmsc <= maxsl)
								i_112_ = onmsc;
							else
								i_112_ = 16;
							cfase = 3;
						}
					if (cfase == 9) {
						drawprom(145, 95);
						drawcs(175, "Failed to remove car.  Unkown Error.  Try again laster.", 0, 0, 0, 3);
						if (drawcarb(true, null, "   OK   ", 371, 195, i, i_104_, bool)) {
							minsl = 16;
							maxsl = cd.nlocars - 1;
							if (onmsc >= minsl && onmsc <= maxsl)
								i_112_ = onmsc;
							else
								i_112_ = 16;
							cfase = 3;
						}
					}
					if (cfase == 7) {
						if (app.mycar.isShowing())
							app.mycar.setVisible(false);
						drawprom(145, 95);
						drawcs(175, "Remove this car from your account?", 0, 0, 0, 3);
						if (drawcarb(true, null, " Yes ", 354, 195, i, i_104_, bool)) {
							remi = true;
							minsl = 0;
							maxsl = 15;
							i_112_ = 15;
							cfase = 8;
							onmsc = sc[0];
							cd.ac = sc[0];
							cd.action = 10;
							cd.sparkactionloader();
						}
						if (drawcarb(true, null, " No ", 408, 195, i, i_104_, bool))
							cfase = 3;
					}
					if (cfase == 3 && i_112_ == -1) {
						int i_123_ = 95;
						int i_124_ = 5;
						if (multion != 0) {
							i_123_ = 185;
							i_124_ = 0;
						}
						if (drawcarb(false, gac, "", i_123_, 105 + i_124_, i, i_104_, bool)) {
							minsl = 0;
							maxsl = 15;
							if (onmsc >= minsl && onmsc <= maxsl)
								i_112_ = onmsc;
							else
								i_112_ = 15;
							cfase = 0;
						}
						if (multion == 0) {
							if (!app.openm) {
								if (!app.mycar.isShowing()) {
									app.mycar.setVisible(true);
									app.mycar.setState(cd.include[sc[0] - 16]);
								}
							} else
								app.mycar.setVisible(false);
							rd.setColor(new Color(198, 179, 129));
							rd.fillRoundRect(305, 302, 190, 24, 7, 20);
							rd.setColor(new Color(0, 0, 0));
							rd.drawRoundRect(305, 302, 190, 24, 7, 20);
							app.movefield(app.mycar, 334, 306, 150, 17);
							if (app.mycar.getState() != cd.include[sc[0] - 16]) {
								cd.include[sc[0] - 16] = app.mycar.getState();
								app.requestFocus();
							}
						}
						if ((multion == 0 || onjoin == -1) && drawcarb(false, top20s, "", i_123_,
								(i_123_ - 95) / 7 + 25 + i_124_, i, i_104_, bool)) {
							cd.action = 0;
							cfase = 10;
							if (app.mycar.isShowing())
								app.mycar.setVisible(false);
						}
						if (cd.lastload == 2) {
							if (drawcarb(true, null, "X", 567, 135, i, i_104_, bool))
								cfase = 7;
							rd.setFont(new Font("Arial", 1, 12));
							ftm = rd.getFontMetrics();
							rd.setColor(new Color(0, 0, 0));
							if (!cd.createdby[sc[0] - 16].equals(nickname))
								bool_114_ = clink(cd.createdby[sc[0] - 16], i, i_104_, bool);
							else
								rd.drawString("Created by You", 241, 160);
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
							drawcs(230, new StringBuilder().append("You do not have a ").append(string)
									.append(" car in your account cars.").toString(), 0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 250, i, i_104_, bool))
								noclass = false;
						}
					}
					if ((cfase == 11 || cfase == 101) && i_112_ == -1) {
						if (cd.action == -9) {
							drawprom(145, 95);
							drawcs(175, "Unknown error!  Failed to add car.  Try again later.", 0, 0, 0, 3);
							if (drawcarb(true, null, " OK ", 379, 195, i, i_104_, bool))
								cd.action = 0;
						}
						if (cd.action == -8) {
							drawprom(145, 95);
							drawcs(175, "Failed.  You already have 20 cars in your account!", 0, 0, 0, 3);
							if (drawcarb(true, null, " OK ", 379, 195, i, i_104_, bool))
								cd.action = 0;
						}
						if (cd.action == -7) {
							drawprom(145, 95);
							drawcs(175, "You already have this car!", 0, 0, 0, 3);
							if (drawcarb(true, null, " OK ", 379, 195, i, i_104_, bool))
								cd.action = 0;
						}
						if (cd.action == 7) {
							drawprom(145, 95);
							drawcs(175,
									new StringBuilder().append("").append(cd.names[cd.ac])
											.append(" has been successfully added to your cars!").toString(),
									0, 0, 0, 3);
							if (drawcarb(true, null, " OK ", 379, 195, i, i_104_, bool))
								cd.action = 0;
						}
						if (cd.action == 6) {
							drawprom(145, 95);
							drawcs(195, new StringBuilder().append("Adding ").append(cd.names[cd.ac])
									.append(" to your cars...").toString(), 0, 0, 0, 3);
						}
						int i_125_ = 95;
						int i_126_ = 5;
						if (multion != 0) {
							i_125_ = 185;
							i_126_ = 0;
						}
						if (onmsc >= 16 && (cd.lastload == 2 || cd.lastload == -2)) {
							if (drawcarb(false, myc, "", i_125_, 105 + i_126_, i, i_104_, bool)) {
								if (cd.lastload != 2) {
									cfase = 5;
									showtf = false;
									if (!logged) {
										cd.action = 0;
										cd.reco = -2;
										tcnt = 5;
										cntflock = 0;
									} else {
										cd.action = 3;
										cd.sparkactionloader();
									}
								} else {
									cd.action = 0;
									minsl = 16;
									maxsl = cd.nlocars - 1;
									if (onmsc >= minsl && onmsc <= maxsl)
										i_112_ = onmsc;
									else
										i_112_ = 16;
									cfase = 3;
								}
								app.moused = false;
							}
						} else if (drawcarb(false, gac, "", i_125_, 105 + i_126_, i, i_104_, bool)) {
							cd.action = 0;
							minsl = 0;
							maxsl = 15;
							if (onmsc >= minsl && onmsc <= maxsl)
								i_112_ = onmsc;
							else
								i_112_ = 15;
							cfase = 0;
							app.moused = false;
						}
						if (drawcarb(false, top20s, "", i_125_, (i_125_ - 95) / 7 + 25 + i_126_, i, i_104_, bool)) {
							cd.action = 0;
							cfase = 10;
						}
						if (cd.action == 0) {
							rd.setFont(new Font("Arial", 1, 12));
							ftm = rd.getFontMetrics();
							rd.setColor(new Color(0, 0, 0));
							if (!cd.createdby[sc[0] - 16].equals(nickname))
								bool_114_ = clink(cd.createdby[sc[0] - 16], i, i_104_, bool);
							else
								rd.drawString("Created by You", 241, 160);
							if (cfase != 101) {
								rd.setFont(new Font("Arial", 1, 11));
								rd.drawString(new StringBuilder().append("Added by :  ").append(cd.adds[sc[0] - 36])
										.append(" Players").toString(), 241, 180);
							}
						}
					}
					if (cfase == 5) {
						drawprom(145, 170);
						if (cd.action == 5) {
							minsl = 16;
							maxsl = cd.nlocars - 1;
							if (cd.inslot != -1) {
								onmsc = cd.inslot;
								cd.inslot = -1;
							}
							if (onmsc >= minsl && onmsc <= maxsl)
								i_112_ = onmsc;
							else
								i_112_ = 16;
							cfase = 3;
						}
						if (cd.action == 4) {
							drawcs(195, "[  Loading Car  ]", 0, 0, 0, 3);
							drawcs(235, new StringBuilder().append("Loading :  ").append(app.mcars.getSelectedItem())
									.append("").toString(), 0, 0, 0, 3);
						}
						if (cd.action == -2) {
							drawcs(195, "Unknown Connection Error", 0, 0, 0, 3);
							drawcs(225, "Failed to connect to server, try again later!", 0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i, i_104_, bool))
								cfase = 0;
						}
						if (cd.action == -1) {
							drawcs(195, "No published cars found...", 0, 0, 0, 3);
							drawcs(225, "You have no added cars to your account yet!", 0, 0, 0, 3);
							if (drawcarb(true, null, "   OK   ", 371, 255, i, i_104_, bool))
								cfase = 0;
						}
						if (cd.action == 2 || cd.action == 3) {
							drawcs(195, "Loading your Account Cars list...", 0, 0, 0, 3);
							if (cd.action == 2) {
								nickname = app.tnick.getText();
								backlog = nickname;
								nickey = cd.tnickey;
								clan = cd.tclan;
								clankey = cd.tclankey;
								app.setloggedcookie();
								logged = true;
								gotlog = true;
								if (cd.reco == 0)
									acexp = 0;
								if (cd.reco > 10)
									acexp = cd.reco - 10;
								if (cd.reco == 3)
									acexp = -1;
								if (cd.reco == 111)
									if (!backlog.toLowerCase().equals(nickname.toLowerCase()))
										acexp = -3;
									else
										acexp = 0;
								if (basefase == 0)
									cd.action = 3;
								if (basefase == 11) {
									cd.action = 6;
									cfase = 11;
								}
								if (basefase == 101) {
									cd.action = 6;
									cfase = 101;
								}
							}
						}
						if (cd.action == 1)
							drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
						if (cd.action == 0) {
							if (cd.reco == -5)
								drawcs(171, "Login to Add this Car to your Account", 0, 0, 0, 3);
							if (cd.reco == -2)
								drawcs(171, "Login to Retrieve your Account Cars", 0, 0, 0, 3);
							if (cd.reco == -1)
								drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
							if (cd.reco == 1)
								drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
							if (cd.reco == 2)
								drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
							if (cd.reco == -167 || cd.reco == -177) {
								if (cd.reco == -167) {
									nickname = app.tnick.getText();
									backlog = nickname;
									cd.reco = -177;
								}
								drawcs(171, "You are currently using a trial account.", 0, 0, 0, 3);
							}
							if (cd.reco == -3 && (tcnt % 3 != 0 || tcnt > 20))
								drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
							if (cd.reco == -4 && (tcnt % 3 != 0 || tcnt > 20))
								drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
							if (!showtf) {
								app.tnick.setVisible(true);
								app.tnick.setBackground(new Color(206, 237, 255));
								if (cd.reco != 1) {
									if (cd.reco != 2)
										app.tnick.setText(nickname);
									app.tnick.setForeground(new Color(0, 0, 0));
								} else
									app.tnick.setForeground(new Color(255, 0, 0));
								app.tnick.requestFocus();
								app.tpass.setVisible(true);
								app.tpass.setBackground(new Color(206, 237, 255));
								if (cd.reco != 2) {
									if (!autolog)
										app.tpass.setText("");
									app.tpass.setForeground(new Color(0, 0, 0));
								} else
									app.tpass.setForeground(new Color(255, 0, 0));
								if (!app.tnick.getText().equals("") && cd.reco != 1)
									app.tpass.requestFocus();
								showtf = true;
							}
							rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 201);
							rd.drawString("Password:", 376 - ftm.stringWidth("Password:") - 14, 231);
							app.movefieldd(app.tnick, 376, 185, 129, 23, true);
							app.movefieldd(app.tpass, 376, 215, 129, 23, true);
							if (tcnt < 30) {
								tcnt++;
								if (tcnt == 30) {
									if (cd.reco == 2)
										app.tpass.setText("");
									app.tnick.setForeground(new Color(0, 0, 0));
									app.tpass.setForeground(new Color(0, 0, 0));
								}
							}
							if (cd.reco != -177) {
								if (drawcarb(true, null, "       Login       ", 347, 247, i, i_104_, bool)
										&& tcnt > 5) {
									tcnt = 0;
									if (!app.tnick.getText().equals("") && !app.tpass.getText().equals("")) {
										autolog = false;
										app.tnick.setVisible(false);
										app.tpass.setVisible(false);
										app.requestFocus();
										cd.action = 1;
										cd.sparkactionloader();
									} else {
										if (app.tpass.getText().equals(""))
											cd.reco = -4;
										if (app.tnick.getText().equals(""))
											cd.reco = -3;
									}
								}
							} else if (drawcarb(true, null, "  Upgrade to have your own cars!  ", 284, 247, i, i_104_,
									bool) && cntflock == 0) {
								app.editlink(this.nickname, true);
								cntflock = 100;
							}
							if (drawcarb(true, null, "  Cancel  ", 409, 282, i, i_104_, bool)) {
								app.tnick.setVisible(false);
								app.tpass.setVisible(false);
								app.requestFocus();
								cfase = basefase;
							}
							if (drawcarb(true, null, "  Register!  ", 316, 282, i, i_104_, bool)) {
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
						if (drawcarb(true, null, "   OK   ", 371, 255, i, i_104_, bool))
							cfase = 0;
					}
					if (cfase == 2) {
						drawprom(165, 70);
						drawcs(205, "Loading Car Maker Cars...", 0, 0, 0, 3);
						app.repaint();
						cd.loadcarmaker();
						if (cd.nlcars > 16) {
							minsl = 16;
							maxsl = cd.nlcars - 1;
							i_112_ = 16;
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
						rd.drawString("Perform a \u2018Test Drive\u2019 on any car to see if it is ready or not.", 215,
								230);
						rd.drawString("The maximum number of cars that can be loaded is  40 !", 215, 260);
						if (drawcarb(true, null, "   OK   ", 371, 275, i, i_104_, bool))
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
					float f = (cd.swits[sc[0]][2] - 220) / 90.0F;
					if (f < 0.2)
						f = 0.2F;
					rd.fillRect((int) (162.0F + 156.0F * f), 337, (int) (156.0F * (1.0F - f) + 1.0F), 7);
					f = cd.acelf[sc[0]][1] * cd.acelf[sc[0]][0] * cd.acelf[sc[0]][2] * cd.grip[sc[0]] / 7700.0F;
					if (f > 1.0F)
						f = 1.0F;
					rd.fillRect((int) (162.0F + 156.0F * f), 352, (int) (156.0F * (1.0F - f) + 1.0F), 7);
					f = cd.dishandle[sc[0]];
					rd.fillRect((int) (162.0F + 156.0F * f), 367, (int) (156.0F * (1.0F - f) + 1.0F), 7);
					f = (cd.airc[sc[0]] * cd.airs[sc[0]] * cd.bounce[sc[0]] + 28.0F) / 139.0F;
					if (f > 1.0F)
						f = 1.0F;
					rd.fillRect((int) (536.0F + 156.0F * f), 337, (int) (156.0F * (1.0F - f) + 1.0F), 7);
					final float f_127_ = 0.5F;
					f = (cd.moment[sc[0]] + f_127_) / 2.6F;
					if (f > 1.0F)
						f = 1.0F;
					rd.fillRect((int) (536.0F + 156.0F * f), 352, (int) (156.0F * (1.0F - f) + 1.0F), 7);
					f = cd.outdam[sc[0]];
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
						if (cd.cclass[sc[0]] == 1)
							string = "Class B & C";
						if (cd.cclass[sc[0]] == 2)
							string = "Class B";
						if (cd.cclass[sc[0]] == 3)
							string = "Class A & B";
						if (cd.cclass[sc[0]] == 4)
							string = "Class A";
						if (kbload < 7) {
							rd.setColor(new Color(0, 0, 0));
							kbload++;
						} else {
							rd.setColor(new Color(176, 41, 0));
							kbload = 0;
						}
						if (cfase != 10 || cd.action != 0 && cd.action < 14)
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
						for (int i_128_ = 0; i_128_ < 161; i_128_++) {
							rd.setColor(Color.getHSBColor((float) (i_128_ * 0.00625), 1.0F, 1.0F));
							rd.drawLine(102, 75 + i_128_, 110, 75 + i_128_);
							if (i_128_ <= 128) {
								rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0 - i_128_ * 0.00625)));
								rd.drawLine(137, 75 + i_128_, 145, 75 + i_128_);
							}
							rd.setColor(Color.getHSBColor((float) (i_128_ * 0.00625), 1.0F, 1.0F));
							rd.drawLine(652, 75 + i_128_, 660, 75 + i_128_);
							if (i_128_ <= 128) {
								rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0 - i_128_ * 0.00625)));
								rd.drawLine(687, 75 + i_128_, 695, 75 + i_128_);
							}
						}
						for (int i_129_ = 0; i_129_ < 40; i_129_++) {
							rd.setColor(Color.getHSBColor(arnp[0], (float) (i_129_ * 0.025), 1.0F - arnp[2]));
							rd.drawLine(121 + i_129_, 224, 121 + i_129_, 230);
							rd.setColor(Color.getHSBColor(arnp[3], (float) (i_129_ * 0.025), 1.0F - arnp[5]));
							rd.drawLine(671 + i_129_, 224, 671 + i_129_, 230);
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
								if (i > 96 && i < 152 && i_104_ > 248 && i_104_ < 258) {
									final float[] fs = new float[3];
									Color.RGBtoHSB(contos[sc[0]].fcol[0], contos[sc[0]].fcol[1], contos[sc[0]].fcol[2],
											fs);
									arnp[0] = fs[0];
									arnp[1] = fs[1];
									arnp[2] = 1.0F - fs[2];
								}
								if (i > 646 && i < 702 && i_104_ > 248 && i_104_ < 258) {
									final float[] fs = new float[3];
									Color.RGBtoHSB(contos[sc[0]].scol[0], contos[sc[0]].scol[1], contos[sc[0]].scol[2],
											fs);
									arnp[3] = fs[0];
									arnp[4] = fs[1];
									arnp[5] = 1.0F - fs[2];
								}
								mouson = -2;
								if (i > 119 && i < 163 && i_104_ > 222 && i_104_ < 232)
									mouson = 1;
								if (i > 669 && i < 713 && i_104_ > 222 && i_104_ < 232)
									mouson = 4;
								if (i > 98 && i < 122 && i_104_ > 69 && i_104_ < 241 && mouson == -2)
									mouson = 0;
								if (i > 133 && i < 157 && i_104_ > 69 && i_104_ < 209 && mouson == -2)
									mouson = 2;
								if (i > 648 && i < 672 && i_104_ > 69 && i_104_ < 241 && mouson == -2)
									mouson = 3;
								if (i > 683 && i < 707 && i_104_ > 69 && i_104_ < 209 && mouson == -2)
									mouson = 5;
							}
						} else if (mouson != -1)
							mouson = -1;
						if (mouson == 0 || mouson == 2 || mouson == 3 || mouson == 5) {
							arnp[mouson] = (float) ((i_104_ - 75.0F) * 0.00625);
							if (mouson == 2 || mouson == 5) {
								if (arnp[mouson] > 0.8)
									arnp[mouson] = 0.8F;
							} else if (arnp[mouson] > 1.0F)
								arnp[mouson] = 1.0F;
							if (arnp[mouson] < 0.0F)
								arnp[mouson] = 0.0F;
						}
						if (mouson == 1) {
							arnp[mouson] = (float) ((i - 121.0F) * 0.025);
							if (arnp[mouson] > 1.0F)
								arnp[mouson] = 1.0F;
							if (arnp[mouson] < 0.0F)
								arnp[mouson] = 0.0F;
						}
						if (mouson == 4) {
							arnp[mouson] = (float) ((i - 671.0F) * 0.025);
							if (arnp[mouson] > 1.0F)
								arnp[mouson] = 1.0F;
							if (arnp[mouson] < 0.0F)
								arnp[mouson] = 0.0F;
						}
						if (cfase != 10 && cfase != 5 && i_112_ == -1) {
							final Color color = Color.getHSBColor(arnp[0], arnp[1], 1.0F - arnp[2]);
							final Color color_130_ = Color.getHSBColor(arnp[3], arnp[4], 1.0F - arnp[5]);
							for (int i_131_ = 0; i_131_ < contos[sc[0]].npl; i_131_++) {
								if (contos[sc[0]].p[i_131_].colnum == 1) {
									contos[sc[0]].p[i_131_].hsb[0] = arnp[0];
									contos[sc[0]].p[i_131_].hsb[1] = arnp[1];
									contos[sc[0]].p[i_131_].hsb[2] = 1.0F - arnp[2];
									contos[sc[0]].p[i_131_].c[0] = color.getRed();
									contos[sc[0]].p[i_131_].c[1] = color.getGreen();
									contos[sc[0]].p[i_131_].c[2] = color.getBlue();
									contos[sc[0]].p[i_131_].oc[0] = color.getRed();
									contos[sc[0]].p[i_131_].oc[1] = color.getGreen();
									contos[sc[0]].p[i_131_].oc[2] = color.getBlue();
								}
								if (contos[sc[0]].p[i_131_].colnum == 2) {
									contos[sc[0]].p[i_131_].hsb[0] = arnp[3];
									contos[sc[0]].p[i_131_].hsb[1] = arnp[4];
									contos[sc[0]].p[i_131_].hsb[2] = 1.0F - arnp[5];
									contos[sc[0]].p[i_131_].c[0] = color_130_.getRed();
									contos[sc[0]].p[i_131_].c[1] = color_130_.getGreen();
									contos[sc[0]].p[i_131_].c[2] = color_130_.getBlue();
									contos[sc[0]].p[i_131_].oc[0] = color_130_.getRed();
									contos[sc[0]].p[i_131_].oc[1] = color_130_.getGreen();
									contos[sc[0]].p[i_131_].oc[2] = color_130_.getBlue();
								}
							}
						}
					}
				}
				if (!remi && cfase != 10 && cfase != 11 && cfase != 100 && cfase != 101)
					rd.drawImage(contin[pcontin], 355, 385, null);
				else {
					if (cfase == 11 && drawcarb(true, null, "Add to My Cars", 345, 385, i, i_104_, bool)
							&& cd.action == 0) {
						cd.ac = sc[0];
						if (logged) {
							cd.action = 6;
							cd.sparkactionloader();
						} else {
							cd.reco = -5;
							cfase = 5;
							showtf = false;
						}
					}
					if (cfase == 101 && i_112_ == -1)
						if (cd.publish[sc[0] - 16] == 1 || cd.publish[sc[0] - 16] == 2) {
							if (drawcarb(true, null, "Add to My Cars", 345, 385, i, i_104_, bool) && cd.action == 0) {
								cd.ac = sc[0];
								if (logged) {
									cd.action = 6;
									cd.sparkactionloader();
								} else {
									cd.reco = -5;
									cfase = 5;
									showtf = false;
								}
							}
						} else {
							rd.setFont(new Font("Arial", 1, 12));
							ftm = rd.getFontMetrics();
							drawcs(405, "Private Car", 193, 106, 0, 3);
						}
				}
			}
		} else {
			if (cfase == 11 || cfase == 101)
				cd.action = 0;
			if (app.mycar.isShowing())
				app.mycar.setVisible(false);
			pback = 0;
			pnext = 0;
			gatey = 300;
			if (flipo > 10) {
				contos[sc[0]].y -= 100;
				if (nextc == 1)
					contos[sc[0]].zy += 20;
				if (nextc == -1)
					contos[sc[0]].zy -= 20;
			} else {
				if (flipo == 10) {
					if (nextc >= 20) {
						sc[0] = nextc - 20;
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
						if (multion != 0 && onjoin != -1 && ontyp > 0 && ontyp <= 5)
							for ( /**/ ; sc[0] < maxsl && Math.abs(cd.cclass[sc[0]] - (ontyp - 1)) > 1; sc[0]++) {
								/* empty */
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
						if (multion != 0 && onjoin != -1 && ontyp > 0 && ontyp <= 5)
							for ( /**/ ; sc[0] > minsl && Math.abs(cd.cclass[sc[0]] - (ontyp - 1)) > 1; sc[0]--) {
								/* empty */
							}
					}
					if (cfase == 3 && cd.lastload == 2)
						app.mcars.select(cd.names[sc[0]]);
					contos[sc[0]].z = 950;
					contos[sc[0]].y = -34 - contos[sc[0]].grat - 1100;
					contos[sc[0]].x = 0;
					contos[sc[0]].zy = 0;
				}
				contos[sc[0]].y += 100;
			}
			flipo--;
		}
		if (cfase == 0 || cfase == 3 || cfase == 11 || cfase == 101) {
			basefase = cfase;
			if (i_112_ != -1) {
				if (flatrstart > 1)
					flatrstart = 0;
				nextc = i_112_ + 20;
				flipo = 20;
			}
			if (control.right) {
				control.right = false;
				if (sc[0] != maxsl && flipo == 0) {
					if (flatrstart > 1)
						flatrstart = 0;
					nextc = 1;
					flipo = 20;
				}
			}
			if (control.left) {
				control.left = false;
				if (sc[0] != minsl && flipo == 0) {
					if (flatrstart > 1)
						flatrstart = 0;
					nextc = -1;
					flipo = 20;
				}
			}
			if (cfase != 11 && cfase != 101 && i_113_ == 0 && flipo < 10 && (control.handb || control.enter)) {
				m.crs = false;
				app.mcars.show = false;
				if (multion != 0) {
					fase = 1177;
					intertrack.stop();
				} else if (testdrive != 3 && testdrive != 4)
					fase = 3;
				else
					fase = -22;
				if (sc[0] < 16 || cd.lastload == 2)
					app.setcarcookie(sc[0], cd.names[sc[0]], arnp, gmode, unlocked, mtop);
				if (cd.haltload != 0) {
					if (cd.haltload == 2)
						cd.lcardate[1] = 0;
					cd.lcardate[0] = 0;
					cd.haltload = 0;
				}
				if (gmode == 0)
					osc = sc[0];
				if (gmode == 1)
					scm[0] = sc[0];
				if (gmode == 2)
					scm[1] = sc[0];
				if (app.mycar.isShowing())
					app.mycar.setVisible(false);
				flexpix = null;
				control.handb = false;
				control.enter = false;
			}
		} else {
			pback = 0;
			pnext = 0;
			pcontin = 0;
			if (cfase == 8 && i_112_ != -1) {
				if (flatrstart > 1)
					flatrstart = 0;
				nextc = i_112_ + 20;
				flipo = 20;
			}
			if (cfase == 5 && cd.action == 0 && control.enter) {
				tcnt = 0;
				if (!app.tnick.getText().equals("") && !app.tpass.getText().equals("")) {
					app.tnick.setVisible(false);
					app.tpass.setVisible(false);
					app.requestFocus();
					cd.action = 1;
					cd.sparkactionloader();
				} else {
					if (app.tpass.getText().equals(""))
						cd.reco = -4;
					if (app.tnick.getText().equals(""))
						cd.reco = -3;
				}
				control.enter = false;
			}
		}
		if (control.handb || control.enter) {
			control.handb = false;
			control.enter = false;
		}
		if (bool_114_) {
			app.mouses = 0;
			onviewpro = true;
			cd.viewname = cd.createdby[sc[0] - 16];
			m.crs = false;
			fase = 1177;
			intertrack.stop();
			sc[0] = onmsc;
			if (sc[0] >= 16 && cd.lastload != 2 || sc[0] >= 36)
				sc[0] = 15;
			osc = sc[0];
			multion = 1;
			gmode = 0;
			if (app.mycar.isShowing())
				app.mycar.setVisible(false);
			flexpix = null;
			control.handb = false;
			control.enter = false;
		}
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

	public boolean clink(final String string, final int i, final int i_134_, final boolean bool) {
		boolean bool_135_ = false;
		rd.drawString(new StringBuilder().append("Created by :  ").append(string).append("").toString(), 241, 160);
		final int i_136_ = ftm.stringWidth(string);
		final int i_137_ = 241
				+ ftm.stringWidth(new StringBuilder().append("Created by :  ").append(string).append("").toString())
				- i_136_;
		rd.drawLine(i_137_, 162, i_137_ + i_136_ - 2, 162);
		if (i > i_137_ - 2 && i < i_137_ + i_136_ && i_134_ > 147 && i_134_ < 164) {
			if (bool)
				bool_135_ = true;
			if (waitlink != 1) {
				app.setCursor(new Cursor(12));
				waitlink = 1;
			}
		} else if (waitlink != 0) {
			app.setCursor(new Cursor(0));
			waitlink = 0;
		}
		return bool_135_;
	}

	public void closesounds() {
		for (int i = 0; i < 5; i++)
			for (int i_271_ = 0; i_271_ < 5; i_271_++)
				engs[i][i_271_].checkopen();
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

	public void colorCar(final ContO conto, final int i) {
		if (plnames[i].indexOf("MadBot") == -1)
			for (int i_132_ = 0; i_132_ < conto.npl; i_132_++) {
				if (conto.p[i_132_].colnum == 1) {
					final Color color = Color.getHSBColor(allrnp[i][0], allrnp[i][1], 1.0F - allrnp[i][2]);
					conto.p[i_132_].oc[0] = color.getRed();
					conto.p[i_132_].oc[1] = color.getGreen();
					conto.p[i_132_].oc[2] = color.getBlue();
				}
				if (conto.p[i_132_].colnum == 2) {
					final Color color = Color.getHSBColor(allrnp[i][3], allrnp[i][4], 1.0F - allrnp[i][5]);
					conto.p[i_132_].oc[0] = color.getRed();
					conto.p[i_132_].oc[1] = color.getGreen();
					conto.p[i_132_].oc[2] = color.getBlue();
				}
			}
		else
			for (int i_133_ = 0; i_133_ < conto.npl; i_133_++) {
				if (conto.p[i_133_].colnum == 1) {
					conto.p[i_133_].oc[0] = conto.fcol[0];
					conto.p[i_133_].oc[1] = conto.fcol[1];
					conto.p[i_133_].oc[2] = conto.fcol[2];
				}
				if (conto.p[i_133_].colnum == 2) {
					conto.p[i_133_].oc[0] = conto.scol[0];
					conto.p[i_133_].oc[1] = conto.scol[1];
					conto.p[i_133_].oc[2] = conto.scol[2];
				}
			}
	}

	protected Color colorSnap(final int r, final int g, final int b) {
		return colorSnap(r, g, b, 255);
	}

	protected Color colorSnap(final int r, final int g, final int b, int a) {
		int nr = r;
		int ng = g;
		int nb = b;
		nr = (int) (nr + nr * (m.snap[0] / 100F));
		if (nr > 255)
			nr = 255;
		if (nr < 0)
			nr = 0;
		ng = (int) (ng + ng * (m.snap[1] / 100F));
		if (ng > 255)
			ng = 255;
		if (ng < 0)
			ng = 0;
		nb = (int) (nb + nb * (m.snap[2] / 100F));
		if (nb > 255)
			nb = 255;
		if (nb < 0)
			nb = 0;
		if (a > 255)
			a = 255;
		if (a < 0)
			a = 0;
		final Color c = new Color(nr, ng, nb, a);
		rd.setColor(c);
		return c;
	}

	public void crash(final float f, final int i) {
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

	public void credits(final Control control, final int i, final int i_23_, final int i_24_) {
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
			drawcs(185, "By Omar Waly", 40, 60, 0, 3);
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			drawcs(225, "Special Thanks!", 0, 0, 0, 3);
			rd.setFont(new Font("Arial", 1, 11));
			ftm = rd.getFontMetrics();
			drawcs(245,
					"Thanks to Dany Fernandez Diaz (DragShot) for imporving the game\u2019s music player to play more mod formats & effects!",
					66, 98, 0, 3);
			drawcs(260, "Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.", 66, 98,
					0, 3);
			drawcs(275,
					"Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.",
					66, 98, 0, 3);
			drawcs(290,
					"Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.",
					66, 98, 0, 3);
			drawcs(305,
					"A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!",
					66, 98, 0, 3);
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
			rd.setFont(new Font("Arial", 1, 11));
			ftm = rd.getFontMetrics();
			drawcs(365, "Most of the tracks where remixed by Omar Waly to match the game.", 66, 98, 0, 3);
			drawcs(380, "More details about the tracks and their original composers at:", 66, 98, 0, 3);
			drawcs(395, "http://multiplayer.needformadness.com/music.html", 33, 49, 0, 3);
			rd.drawLine(400 - ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2, 396,
					ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2 + 400, 396);
			if (i > 258 && i < 542 && i_23_ > 385 && i_23_ < 399) {
				app.setCursor(new Cursor(12));
				if (i_24_ == 2)
					app.musiclink();
			} else
				app.setCursor(new Cursor(0));
		}
		if (flipo == 102) {
			mainbg(-1);
			rd.drawImage(onfmm, 283, 32, null);
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			drawcs(165, "Decompiled and fixed by", 0, 0, 0, 3);
			drawcs(185, "rafa1231518 aka chrishansen69", 40, 60, 0, 3);
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			drawcs(225, "~~~~~~ Special Thanks ~~~~~~", 0, 0, 0, 3);
			rd.setFont(new Font("Arial", 1, 11));
			ftm = rd.getFontMetrics();
			drawcs(245, "Dany Fernandez Diaz (DragShot) for some code I stole-uh, I mean borrowed!", 66, 98, 0, 3);
			drawcs(260, "Thanks to Kaffeinated, Ten Graves & everyone else for their awesome work in NFM2!", 66, 98, 0,
					3);
			drawcs(275, "Thanks to Emmanuel Dupuy for JD-GUI, Pavel Kouznetsov for JAD and Jochen Hoenicke for JODE.",
					66, 98, 0, 3);
			drawcs(290, "Thanks to Allan for being a glorious bastard and please add credits.", 66, 98, 0, 3);
			drawcs(305, "Thanks to the Eclipse Foundation for this laggy piece of shit-uh, I mean great IDE!", 66, 98,
					0, 3);
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			drawcs(345, "~~~~~~ License ~~~~~~", 0, 0, 0, 3);
			rd.setFont(new Font("Arial", 1, 11));
			ftm = rd.getFontMetrics();
			drawcs(365, "All code is licensed under the BSD license, unless noted otherwise.", 66, 98, 0, 3);
			drawcs(380,
					"Need for Madness Multiplayer created by Omar Waly, copyright (c) Radical Play 2005-2015. All rights reserved.",
					66, 98, 0, 3);
			drawcs(395, "OpenNFMM copyright (c) C. Hansen 2015. Some rights reserved.", 66, 98, 0, 3);
			drawcs(410, "Dual Mod Engine copyright (c) Dany Fernandez Diaz (DragShot) 2015. Some rights reserved.", 66,
					98, 0, 3);

			if (i_23_ > 354 && i_23_ < 410 && i < 665) {
				app.setCursor(new Cursor(12));
				if (i_24_ == 2)
					app.onfmmlink();
			} else if (i_23_ > 354 && i_23_ < 395 && i > 665) {
				app.setCursor(new Cursor(12));
				if (i_24_ == 2)
					app.onfmmlink();
			} else
				app.setCursor(new Cursor(0));
		}
		if (flipo == 103) {
			mainbg(0);
			rd.drawImage(nfmcom, 190, 195, null);
			if (i > 190 && i < 609 && i_23_ > 195 && i_23_ < 216) {
				app.setCursor(new Cursor(12));
				if (i_24_ == 2)
					app.madlink();
			} else
				app.setCursor(new Cursor(0));
		}
		rd.drawImage(next[pnext], 665, 395, null);

		if (control.enter || control.handb || control.right) {
			if (flipo >= 1 && flipo <= 100) {
				flipo = 101;
				app.setCursor(new Cursor(0));
			} else
				flipo++;
			if (flipo == 104) {
				flipo = 0;
				fase = 10;
			}
			control.enter = false;
			control.handb = false;
			control.right = false;
		}
	}

	public void ctachm(final int i, final int i_182_, final int i_183_, final Control control) {
		if (fase == 1) {
			if (i_183_ == 1) {
				if (over(next[0], i, i_182_, 625, 135))
					pnext = 1;
				if (over(back[0], i, i_182_, 115, 135))
					pback = 1;
				if (over(contin[0], i, i_182_, 355, 360))
					pcontin = 1;
			}
			if (i_183_ == 2) {
				if (pnext == 1)
					control.right = true;
				if (pback == 1)
					control.left = true;
				if (pcontin == 1)
					control.enter = true;
			}
		}
		if (fase == 3) {
			if (i_183_ == 1 && over(contin[0], i, i_182_, 355, 350))
				pcontin = 1;
			if (i_183_ == 2 && pcontin == 1) {
				control.enter = true;
				pcontin = 0;
			}
		}
		if (fase == 4) {
			if (i_183_ == 1 && over(back[0], i, i_182_, 370, 345))
				pback = 1;
			if (i_183_ == 2 && pback == 1) {
				control.enter = true;
				pback = 0;
			}
		}
		if (fase == 6) {
			if (i_183_ == 1 && (over(star[0], i, i_182_, 359, 385) || over(star[0], i, i_182_, 359, 295)))
				pstar = 2;
			if (i_183_ == 2 && pstar == 2) {
				control.enter = true;
				pstar = 1;
			}
		}
		if (fase == 7) {
			if (i_183_ == 1) {
				if (over(next[0], i, i_182_, 645, 275))
					pnext = 1;
				if (over(back[0], i, i_182_, 95, 275))
					pback = 1;
				if (over(contin[0], i, i_182_, 355, 385) && !app.openm)
					pcontin = 1;
			}
			if (i_183_ == 2) {
				if (pnext == 1)
					control.right = true;
				if (pback == 1)
					control.left = true;
				if (pcontin == 1) {
					control.enter = true;
					pcontin = 0;
				}
			}
		}
		if (fase == -5) {
			lxm = i;
			lym = i_182_;
			if (i_183_ == 1 && over(contin[0], i, i_182_, 355, 380))
				pcontin = 1;
			if (i_183_ == 2 && pcontin == 1) {
				control.enter = true;
				pcontin = 0;
			}
		}
		if (fase == -7) {
			if (i_183_ == 1) {
				if (overon(329, 45, 137, 22, i, i_182_)) {
					opselect = 0;
					shaded = true;
				}
				if (overon(320, 73, 155, 22, i, i_182_)) {
					opselect = 1;
					shaded = true;
				}
				if (overon(303, 99, 190, 22, i, i_182_)) {
					opselect = 2;
					shaded = true;
				}
				if (overon(341, 125, 109, 22, i, i_182_)) {
					opselect = 3;
					shaded = true;
				}
			}
			if (i_183_ == 2 && shaded) {
				control.enter = true;
				shaded = false;
			}
			if (i_183_ == 0 && (i != lxm || i_182_ != lym)) {
				if (overon(329, 45, 137, 22, i, i_182_))
					opselect = 0;
				if (overon(320, 73, 155, 22, i, i_182_))
					opselect = 1;
				if (overon(303, 99, 190, 22, i, i_182_))
					opselect = 2;
				if (overon(341, 125, 109, 22, i, i_182_))
					opselect = 3;
				lxm = i;
				lym = i_182_;
			}
		}
		if (fase == 10) {
			if (i_183_ == 1) {
				if (overon(343, 261, 110, 22, i, i_182_)) {
					opselect = 0;
					shaded = true;
				}
				if (overon(288, 291, 221, 22, i, i_182_)) {
					opselect = 1;
					shaded = true;
				}
				if (overon(301, 321, 196, 22, i, i_182_)) {
					opselect = 2;
					shaded = true;
				}
				if (overon(357, 351, 85, 22, i, i_182_)) {
					opselect = 3;
					shaded = true;
				}
			}
			if (i_183_ == 2 && shaded) {
				control.enter = true;
				shaded = false;
			}
			if (i_183_ == 0 && (i != lxm || i_182_ != lym)) {
				if (overon(343, 261, 110, 22, i, i_182_))
					opselect = 0;
				if (overon(288, 291, 221, 22, i, i_182_))
					opselect = 1;
				if (overon(301, 321, 196, 22, i, i_182_))
					opselect = 2;
				if (overon(357, 351, 85, 22, i, i_182_))
					opselect = 3;
				lxm = i;
				lym = i_182_;
			}
		}
		if (fase == 102) {
			if (i_183_ == 1) {
				if (overon(358, 262 + dropf, 82, 22, i, i_182_)) {
					opselect = 0;
					shaded = true;
				}
				if (overon(358, 290 + dropf, 82, 22, i, i_182_)) {
					opselect = 1;
					shaded = true;
				}
				if (overon(333, 318 + dropf, 132, 22, i, i_182_)) {
					opselect = 2;
					shaded = true;
				}
				if (dropf == 0 && overon(348, 346, 102, 22, i, i_182_)) {
					opselect = 3;
					shaded = true;
				}
			}
			if (i_183_ == 2 && shaded) {
				control.enter = true;
				shaded = false;
			}
			if (i_183_ == 0 && (i != lxm || i_182_ != lym)) {
				if (overon(358, 262 + dropf, 82, 22, i, i_182_))
					opselect = 0;
				if (overon(358, 290 + dropf, 82, 22, i, i_182_))
					opselect = 1;
				if (overon(333, 318 + dropf, 132, 22, i, i_182_))
					opselect = 2;
				if (dropf == 0 && overon(348, 346, 102, 22, i, i_182_))
					opselect = 3;
				lxm = i;
				lym = i_182_;
			}
		}
		if (fase == 11) {
			if (flipo >= 1 && flipo <= 15) {
				if (i_183_ == 1 && over(next[0], i, i_182_, 665, 395))
					pnext = 1;
				if (i_183_ == 2 && pnext == 1) {
					control.right = true;
					pnext = 0;
				}
			}
			if (flipo >= 3 && flipo <= 16) {
				if (i_183_ == 1 && over(back[0], i, i_182_, 75, 395))
					pback = 1;
				if (i_183_ == 2 && pback == 1) {
					control.left = true;
					pback = 0;
				}
			}
			if (flipo == 16) {
				if (i_183_ == 1 && over(contin[0], i, i_182_, 565, 395))
					pcontin = 1;
				if (i_183_ == 2 && pcontin == 1) {
					control.enter = true;
					pcontin = 0;
				}
			}
		}
		if (fase == 8) {
			if (i_183_ == 1 && over(next[0], i, i_182_, 665, 395))
				pnext = 1;
			if (i_183_ == 2 && pnext == 1) {
				control.enter = true;
				pnext = 0;
			}
		}
	}

	private Image dodgen(final Image image) {
		final int i = image.getHeight(ob);
		final int i_378_ = image.getWidth(ob);
		final int[] is = new int[i_378_ * i];
		final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_378_, i, is, 0, i_378_);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_379_ = 0; i_379_ < i_378_ * i; i_379_++) {
			final Color color = new Color(is[i_379_]);
			int i_380_ = color.getRed() * 4 + 90;
			if (i_380_ > 255)
				i_380_ = 255;
			if (i_380_ < 0)
				i_380_ = 0;
			int i_381_ = color.getGreen() * 4 + 90;
			if (i_381_ > 255)
				i_381_ = 255;
			if (i_381_ < 0)
				i_381_ = 0;
			int i_382_ = color.getBlue() * 4 + 90;
			if (i_382_ > 255)
				i_382_ = 255;
			if (i_382_ < 0)
				i_382_ = 0;
			final Color color_383_ = new Color(i_380_, i_381_, i_382_);
			is[i_379_] = color_383_.getRGB();
		}
		final Image image_384_ = createImage(new MemoryImageSource(i_378_, i, is, 0, i_378_));
		return image_384_;
	}

	public boolean drawcarb(final boolean bool, final Image image, final String string, final int i, int i_429_,
			final int i_430_, final int i_431_, final boolean bool_432_) {
		boolean bool_433_ = false;
		rd.setFont(new Font("Arial", 1, 13));
		ftm = rd.getFontMetrics();
		int i_435_;
		if (bool) {
			i_435_ = ftm.stringWidth(string);
			if (string.startsWith("Class"))
				i_435_ = 112;
		} else
			i_435_ = image.getWidth(ob);
		int i_436_ = 0;
		if (i_430_ > i && i_430_ < i + i_435_ + 14 && i_431_ > i_429_ && i_431_ < i_429_ + 28) {
			i_436_ = 1;
			if (bool_432_)
				bool_433_ = true;
		}
		rd.drawImage(bcl[i_436_], i, i_429_, null);
		rd.drawImage(bc[i_436_], i + 4, i_429_, i_435_ + 6, 28, null);
		rd.drawImage(bcr[i_436_], i + i_435_ + 10, i_429_, null);
		if (!bool && i_435_ == 73)
			i_429_--;
		if (bool) {
			if (string.equals("X") && i_436_ == 1)
				rd.setColor(new Color(255, 0, 0));
			else
				rd.setColor(new Color(0, 0, 0));
			if (string.startsWith("Class"))
				rd.drawString(string, 400 - ftm.stringWidth(string) / 2, i_429_ + 19);
			else
				rd.drawString(string, i + 7, i_429_ + 19);
		} else
			rd.drawImage(image, i + 7, i_429_ + 7, null);
		return bool_433_;
	}

	public void drawcs(final int i, final String string, int i_212_, int i_213_, int i_214_, final int i_215_) {
		if (i_215_ != 3 && i_215_ != 4 && i_215_ != 5) {
			i_212_ += i_212_ * (m.snap[0] / 100.0F);
			if (i_212_ > 255)
				i_212_ = 255;
			if (i_212_ < 0)
				i_212_ = 0;
			i_213_ += i_213_ * (m.snap[1] / 100.0F);
			if (i_213_ > 255)
				i_213_ = 255;
			if (i_213_ < 0)
				i_213_ = 0;
			i_214_ += i_214_ * (m.snap[2] / 100.0F);
			if (i_214_ > 255)
				i_214_ = 255;
			if (i_214_ < 0)
				i_214_ = 0;
		}
		if (i_215_ == 4) {
			i_212_ -= i_212_ * (m.snap[0] / 100.0F);
			if (i_212_ > 255)
				i_212_ = 255;
			if (i_212_ < 0)
				i_212_ = 0;
			i_213_ -= i_213_ * (m.snap[1] / 100.0F);
			if (i_213_ > 255)
				i_213_ = 255;
			if (i_213_ < 0)
				i_213_ = 0;
			i_214_ -= i_214_ * (m.snap[2] / 100.0F);
			if (i_214_ > 255)
				i_214_ = 255;
			if (i_214_ < 0)
				i_214_ = 0;
		}
		if (i_215_ == 1) {
			rd.setColor(new Color(0, 0, 0));
			rd.drawString(string, 400 - ftm.stringWidth(string) / 2 + 1, i + 1);
		}
		if (i_215_ == 2) {
			i_212_ = (i_212_ * 2 + m.csky[0] * 1) / 3;
			if (i_212_ > 255)
				i_212_ = 255;
			if (i_212_ < 0)
				i_212_ = 0;
			i_213_ = (i_213_ * 2 + m.csky[1] * 1) / 3;
			if (i_213_ > 255)
				i_213_ = 255;
			if (i_213_ < 0)
				i_213_ = 0;
			i_214_ = (i_214_ * 2 + m.csky[2] * 1) / 3;
			if (i_214_ > 255)
				i_214_ = 255;
			if (i_214_ < 0)
				i_214_ = 0;
		}
		if (i_215_ == 5) {
			rd.setColor(new Color(m.csky[0] / 2, m.csky[1] / 2, m.csky[2] / 2));
			rd.drawString(string, 400 - ftm.stringWidth(string) / 2 + 1, i + 1);
		}
		rd.setColor(new Color(i_212_, i_213_, i_214_));
		rd.drawString(string, 400 - ftm.stringWidth(string) / 2, i);
	}

	public void drawdprom(final int i, final int i_139_) {
		rd.setComposite(AlphaComposite.getInstance(3, 0.9F));
		rd.setColor(new Color(129, 203, 237));
		rd.fillRoundRect(205, i, 390, i_139_, 30, 30);
		rd.setColor(new Color(0, 0, 0));
		rd.drawRoundRect(205, i, 390, i_139_, 30, 30);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
	}

	public void drawhi(final Image image, final int i) {
		if (m.darksky) {
			Color color = new Color(m.csky[0], m.csky[1], m.csky[2]);
			final float[] fs = new float[3];
			Color.RGBtoHSB(m.csky[0], m.csky[1], m.csky[2], fs);
			fs[2] = 0.6F;
			color = Color.getHSBColor(fs[0], fs[1], fs[2]);
			rd.setColor(color);
			rd.fillRoundRect(390 - image.getWidth(ob) / 2, i - 2, image.getWidth(ob) + 20, image.getHeight(ob) + 2, 7,
					20);
			rd.setColor(new Color((int) (color.getRed() / 1.1), (int) (color.getGreen() / 1.1),
					(int) (color.getBlue() / 1.1)));
			rd.drawRoundRect(390 - image.getWidth(ob) / 2, i - 2, image.getWidth(ob) + 20, image.getHeight(ob) + 2, 7,
					20);
		}
		rd.drawImage(image, 400 - image.getWidth(ob) / 2, i, null);
	}

	public void drawlprom(final int i, final int i_140_) {
		rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
		rd.setColor(new Color(129, 203, 237));
		rd.fillRoundRect(277, i, 390, i_140_, 30, 30);
		rd.setColor(new Color(0, 0, 0));
		rd.drawRoundRect(277, i, 390, i_140_, 30, 30);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
	}

	public void drawprom(final int i, final int i_138_) {
		rd.setComposite(AlphaComposite.getInstance(3, 0.76F));
		rd.setColor(new Color(129, 203, 237));
		rd.fillRoundRect(205, i, 390, i_138_, 30, 30);
		rd.setColor(new Color(0, 0, 0));
		rd.drawRoundRect(205, i, 390, i_138_, 30, 30);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
	}

	public void drawSmokeCarsbg() {
		if (!badmac) {
			if (Math.abs(flyr - flyrdest) > 20) {
				if (flyr > flyrdest)
					flyr -= 20;
				else
					flyr += 20;
			} else {
				flyr = flyrdest;
				flyrdest = (int) (flyr + m.random() * 160.0F - 80.0F);
			}
			if (flyr > 160)
				flyr = 160;
			if (flatr > 170) {
				flatrstart++;
				flatr = flatrstart * 3;
				flyr = (int) (m.random() * 160.0F - 80.0F);
				flyrdest = (int) (flyr + m.random() * 160.0F - 80.0F);
				flang = 1;
			}
			for (int i = 0; i < 466; i++)
				for (int i_407_ = 0; i_407_ < 202; i_407_++)
					if (smokey[i + i_407_ * 466] != smokey[0]) {
						final float f = pys(i, 233, i_407_, flyr);
						final int i_408_ = (int) ((i - 233) / f * flatr);
						final int i_409_ = (int) ((i_407_ - flyr) / f * flatr);
						final int i_410_ = i + i_408_ + 100 + (i_407_ + i_409_ + 110) * 670;
						if (i + i_408_ + 100 < 670 && i + i_408_ + 100 > 0 && i_407_ + i_409_ + 110 < 400
								&& i_407_ + i_409_ + 110 > 0 && i_410_ < 268000 && i_410_ >= 0) {
							final Color color = new Color(flexpix[i_410_]);
							final Color color_411_ = new Color(smokey[i + i_407_ * 466]);
							final float f_412_ = (255.0F - color_411_.getRed()) / 255.0F;
							final float f_413_ = (255.0F - color_411_.getGreen()) / 255.0F;
							final float f_414_ = (255.0F - color_411_.getBlue()) / 255.0F;
							int i_415_ = (int) ((color.getRed() * (flang * f_412_)
									+ color_411_.getRed() * (1.0F - f_412_)) / (flang * f_412_ + (1.0F - f_412_)));
							int i_416_ = (int) ((color.getGreen() * (flang * f_413_)
									+ color_411_.getGreen() * (1.0F - f_413_)) / (flang * f_413_ + (1.0F - f_413_)));
							int i_417_ = (int) ((color.getBlue() * (flang * f_414_)
									+ color_411_.getBlue() * (1.0F - f_414_)) / (flang * f_414_ + (1.0F - f_414_)));
							if (i_415_ > 255)
								i_415_ = 255;
							if (i_415_ < 0)
								i_415_ = 0;
							if (i_416_ > 255)
								i_416_ = 255;
							if (i_416_ < 0)
								i_416_ = 0;
							if (i_417_ > 255)
								i_417_ = 255;
							if (i_417_ < 0)
								i_417_ = 0;
							final Color color_418_ = new Color(i_415_, i_416_, i_417_);
							flexpix[i_410_] = color_418_.getRGB();
						}
					}
			flang += 2;
			flatr += 10 + flatrstart * 2;
			final Image image = createImage(new MemoryImageSource(670, 400, flexpix, 0, 670));
			rd.drawImage(image, 65, 25, null);
		} else {
			rd.drawImage(carsbg, 65, 25, null);
			flatrstart++;
		}
	}

	public void drawstat(final int i, int i_206_, final boolean bool, final float f) {
		final int[] is = new int[4];
		final int[] is_207_ = new int[4];
		if (i_206_ > i)
			i_206_ = i;
		final int i_208_ = (int) (98.0F * ((float) i_206_ / (float) i));
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
		if (i_208_ > 33)
			i_210_ = (int) (244.0F - 233.0F * ((i_208_ - 33) / 65.0F));
		if (i_208_ > 70) {
			if (dmcnt < 10)
				if (dmflk) {
					i_210_ = 170;
					dmflk = false;
				} else
					dmflk = true;
			dmcnt++;
			if (dmcnt > 167.0 - i_208_ * 1.5)
				dmcnt = 0;
		}
		i_209_ += i_209_ * (m.snap[0] / 100.0F);
		if (i_209_ > 255)
			i_209_ = 255;
		if (i_209_ < 0)
			i_209_ = 0;
		i_210_ += i_210_ * (m.snap[1] / 100.0F);
		if (i_210_ > 255)
			i_210_ = 255;
		if (i_210_ < 0)
			i_210_ = 0;
		i_211_ += i_211_ * (m.snap[2] / 100.0F);
		if (i_211_ > 255)
			i_211_ = 255;
		if (i_211_ < 0)
			i_211_ = 0;
		rd.setColor(new Color(i_209_, i_210_, i_211_));
		rd.fillPolygon(is, is_207_, 4);
		is[0] = 662;
		is_207_[0] = 31;
		is[1] = 662;
		is_207_[1] = 40;
		is[2] = (int) (662.0F + f);
		is_207_[2] = 40;
		is[3] = (int) (662.0F + f);
		is_207_[3] = 31;
		i_209_ = 128;
		if (f == 98.0F)
			i_209_ = 64;
		i_210_ = (int) (190.0 + f * 0.37);
		i_211_ = 244;
		if (auscnt < 45 && aflk) {
			i_209_ = 128;
			i_210_ = 244;
			i_211_ = 244;
		}
		i_209_ += i_209_ * (m.snap[0] / 100.0F);
		if (i_209_ > 255)
			i_209_ = 255;
		if (i_209_ < 0)
			i_209_ = 0;
		i_210_ += i_210_ * (m.snap[1] / 100.0F);
		if (i_210_ > 255)
			i_210_ = 255;
		if (i_210_ < 0)
			i_210_ = 0;
		i_211_ += i_211_ * (m.snap[2] / 100.0F);
		if (i_211_ > 255)
			i_211_ = 255;
		if (i_211_ < 0)
			i_211_ = 0;
		rd.setColor(new Color(i_209_, i_210_, i_211_));
		rd.fillPolygon(is, is_207_, 4);
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
			app.gamer.interrupt();
		}
	}

	public void finish(final CheckPoints checkpoints, final ContO[] contos, final Control control, final int i,
			final int i_141_, final boolean bool) {
		if (chronostart) {
			chrono.stop();
			chronostart = false;
		}
		if (!badmac)
			rd.drawImage(fleximg, 0, 0, null);
		else {
			rd.setColor(new Color(0, 0, 0));
			rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
			rd.fillRect(0, 0, 800, 450);
			rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		}
		rd.setFont(new Font("Arial", 1, 11));
		ftm = rd.getFontMetrics();
		int i_142_ = 0;
		String string = ":";
		if (checkpoints.stage > 0) {
			int i_143_ = checkpoints.stage;
			if (i_143_ > 10)
				i_143_ -= 10;
			string = new StringBuilder().append(" ").append(i_143_).append("!").toString();
		}
		if (multion < 3) {
			if (winner) {
				rd.drawImage(congrd, 265, 87, null);
				drawcs(137, new StringBuilder().append("You Won!  At Stage").append(string).append("").toString(), 255,
						161, 85, 3);
				drawcs(154, new StringBuilder().append("").append(checkpoints.name).append("").toString(), 255, 115, 0,
						3);
				i_142_ = 154;
			} else {
				rd.drawImage(gameov, 315, 117, null);
				if (multion != 0 && (forstart == 700 || discon == 240)) {
					drawcs(167, "Sorry, You where Disconnected from Game!", 255, 161, 85, 3);
					drawcs(184, "Please check your connection!", 255, 115, 0, 3);
				} else {
					drawcs(167, new StringBuilder().append("You Lost!  At Stage").append(string).append("").toString(),
							255, 161, 85, 3);
					drawcs(184, new StringBuilder().append("").append(checkpoints.name).append("").toString(), 255, 115,
							0, 3);
					i_142_ = 184;
				}
			}
			rd.setColor(new Color(193, 106, 0));
			rd.drawString(new StringBuilder().append("Your time: ").append(chrono.getTotalTime()).toString(), 380 - ftm
					.stringWidth(new StringBuilder().append("Your time: ").append(chrono.getTotalTime()).toString()),
					200);
			rd.drawString(new StringBuilder().append("Best lap: ").append(chrono.getBestLapTime()).toString(), 420,
					200);
		} else {
			rd.drawImage(gameov, 315, 117, null);
			drawcs(167, new StringBuilder().append("Finished Watching Game!  At Stage").append(string).append("")
					.toString(), 255, 161, 85, 3);
			drawcs(184, new StringBuilder().append("").append(checkpoints.name).append("").toString(), 255, 115, 0, 3);
			i_142_ = 184;
		}
		if (winner && multion == 0 && gmode != 0
				&& (checkpoints.stage == unlocked[gmode - 1] + (gmode - 1) * 10 || checkpoints.stage == 27)) {
			int i_144_ = 0;
			int i_145_ = 0;
			pin = 60;
			if (gmode == 1) {
				if (checkpoints.stage == 2) {
					i_144_ = 5;
					i_145_ = 365;
					pin = -20;
					scm[0] = 5;
				}
				if (checkpoints.stage == 4) {
					i_144_ = 6;
					i_145_ = 320;
					pin = -20;
					scm[0] = 6;
				}
				if (checkpoints.stage == 6) {
					i_144_ = 11;
					i_145_ = 326;
					pin = -20;
					scm[0] = 11;
				}
				if (checkpoints.stage == 8) {
					i_144_ = 14;
					i_145_ = 350;
					pin = -20;
					scm[0] = 14;
				}
				if (checkpoints.stage == 10) {
					i_144_ = 15;
					i_145_ = 370;
					pin = -20;
					scm[0] = 15;
				}
			}
			if (gmode == 2) {
				if (checkpoints.stage == 12) {
					i_144_ = 8;
					i_145_ = 365;
					pin = -20;
					scm[1] = 8;
				}
				if (checkpoints.stage == 14) {
					i_144_ = 9;
					i_145_ = 320;
					pin = -20;
					scm[1] = 9;
				}
				if (checkpoints.stage == 16) {
					i_144_ = 10;
					i_145_ = 370;
					pin = -20;
					scm[1] = 10;
				}
				if (checkpoints.stage == 18) {
					i_144_ = 11;
					i_145_ = 326;
					pin = -20;
					scm[1] = 11;
				}
				if (checkpoints.stage == 20) {
					i_144_ = 12;
					i_145_ = 310;
					pin = -20;
					scm[1] = 12;
				}
				if (checkpoints.stage == 22) {
					i_144_ = 13;
					i_145_ = 310;
					pin = -20;
					scm[1] = 13;
				}
				if (checkpoints.stage == 24) {
					i_144_ = 14;
					i_145_ = 350;
					pin = -20;
					scm[1] = 14;
				}
				if (checkpoints.stage == 26) {
					i_144_ = 15;
					i_145_ = 370;
					pin = -20;
					scm[1] = 15;
				}
			}
			if (checkpoints.stage != 27) {
				rd.setFont(new Font("Arial", 1, 13));
				ftm = rd.getFontMetrics();
				if (aflk)
					drawcs(200 + pin, new StringBuilder().append("Stage ")
							.append(checkpoints.stage + 1 - (gmode - 1) * 10).append(" is now unlocked!").toString(),
							196, 176, 0, 3);
				else
					drawcs(200 + pin, new StringBuilder().append("Stage ")
							.append(checkpoints.stage + 1 - (gmode - 1) * 10).append(" is now unlocked!").toString(),
							255, 247, 165, 3);
				if (i_144_ != 0) {
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
					contos[i_144_].y = i_145_;
					m.crs = true;
					m.x = -400;
					m.y = 0;
					m.z = -50;
					m.xz = 0;
					m.zy = 0;
					m.ground = 2470;
					contos[i_144_].z = 1000;
					contos[i_144_].x = 0;
					contos[i_144_].xz += 5;
					contos[i_144_].zy = 0;
					contos[i_144_].wzy -= 10;
					rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
					contos[i_144_].d(rd);
					rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
					if (Math.random() < 0.5) {
						rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
						rd.setColor(new Color(236, 226, 202));
						for (int i_146_ = 0; i_146_ < 30; i_146_++)
							rd.drawLine(230, 215 + 4 * i_146_, 569, 215 + 4 * i_146_);
						rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
					}
					String string_147_ = "";
					if (i_144_ == 13)
						string_147_ = " ";
					if (aflk)
						drawcs(320, new StringBuilder().append("").append(cd.names[i_144_]).append("")
								.append(string_147_).append(" has been unlocked!").toString(), 196, 176, 0, 3);
					else
						drawcs(320, new StringBuilder().append("").append(cd.names[i_144_]).append("")
								.append(string_147_).append(" has been unlocked!").toString(), 255, 247, 165, 3);
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
					drawcs(180, new StringBuilder().append("Woohoooo you finished NFM").append(gmode).append(" !!!")
							.toString(), 144, 167, 255, 3);
				else
					drawcs(180, new StringBuilder().append("Woohoooo you finished NFM").append(gmode).append(" !!!")
							.toString(), 228, 240, 255, 3);
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
		if (multion != 0 && checkpoints.stage == -2 && i_142_ != 0) {
			drawcs(i_142_ + 17,
					new StringBuilder().append("Created by: ").append(checkpoints.maker).append("").toString(), 255,
					161, 85, 3);
			if (checkpoints.pubt > 0) {
				if (checkpoints.pubt == 2)
					drawcs(310, "Super Public Stage", 41, 177, 255, 3);
				else
					drawcs(310, "Public Stage", 41, 177, 255, 3);
				if (dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 317, i, i_141_, bool))
					if (logged) {
						cd.onstage = checkpoints.name;
						cd.staction = 2;
						cd.sparkstageaction();
						dnload = 2;
					} else {
						dnload = 1;
						waitlink = 20;
					}
				if (dnload == 1) {
					rd.setColor(new Color(193, 106, 0));
					final String string_148_ = "Upgrade to a full account to add custom stages!";
					final int i_149_ = 400 - ftm.stringWidth(string_148_) / 2;
					final int i_150_ = i_149_ + ftm.stringWidth(string_148_);
					rd.drawString(string_148_, i_149_, 332);
					if (waitlink != -1)
						rd.drawLine(i_149_, 334, i_150_, 334);
					if (i > i_149_ && i < i_150_ && i_141_ > 321 && i_141_ < 334) {
						if (waitlink != -1)
							app.setCursor(new Cursor(12));
						if (bool && waitlink == 0) {
							app.editlink(nickname, true);
							waitlink = -1;
						}
					} else
						app.setCursor(new Cursor(0));
					if (waitlink > 0)
						waitlink--;
				}
				if (dnload == 2) {
					drawcs(332, "Adding stage please wait...", 193, 106, 0, 3);
					if (cd.staction == 0)
						dnload = 3;
					if (cd.staction == -2)
						dnload = 4;
					if (cd.staction == -3)
						dnload = 5;
					if (cd.staction == -1)
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
		if (control.enter || control.handb) {
			if (loadedt)
				strack.unload();
			if (multion == 0) {
				opselect = 3;
				if (gmode == 1) {
					opselect = 0;
					if (winner && checkpoints.stage == unlocked[gmode - 1] + (gmode - 1) * 10
							&& checkpoints.stage != 27) {
						unlocked[gmode - 1]++;
						justwon1 = true;
					} else
						justwon1 = false;
				}
				if (gmode == 2) {
					opselect = 1;
					if (winner && checkpoints.stage == unlocked[gmode - 1] + (gmode - 1) * 10
							&& checkpoints.stage != 27) {
						unlocked[gmode - 1]++;
						justwon2 = true;
					} else
						justwon2 = false;
				}
				if (checkpoints.stage == 27 && gmode == 0)
					checkpoints.stage = (int) (Math.random() * 27.0) + 1;
				fase = 102;
			} else if (cd.haltload == 1) {
				sc[0] = 36;
				fase = 1177;
			} else if (!mtop || nfreeplays >= 5 && !logged) {
				opselect = 2;
				fase = 102;
			} else
				fase = -9;
			if (multion == 0 && winner && checkpoints.stage != 27 && checkpoints.stage > 0)
				checkpoints.stage++;
			if (!winner && multion != 0 && (forstart == 700 || discon == 240) && ndisco < 5)
				ndisco++;
			flipo = 0;
			control.enter = false;
			control.handb = false;
		}
	}

	public void fleximage(final Image image, final int i, final int i_299_) {
		if (!badmac) {
			if (i == 0) {
				flexpix = new int[360000];
				final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, flexpix, 0, 800);
				try {
					pixelgrabber.grabPixels();
				} catch (final InterruptedException interruptedexception) {
					/* empty */
				}
			}
			int i_300_ = 0;
			int i_301_ = 0;
			int i_302_ = 0;
			int i_303_ = 0;
			int i_304_ = (int) (Math.random() * 128.0);
			int i_305_ = (int) (5.0 + Math.random() * 15.0);
			for (int i_306_ = 0; i_306_ < 360000; i_306_++) {
				final Color color = new Color(flexpix[i_306_]);
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
					i_309_ = (int) ((color.getRed() + i_301_ * 0.38F * i) / (1.0F + 0.38F * i));
					i_301_ = i_309_;
					i_310_ = (int) ((color.getGreen() + i_302_ * 0.38F * i) / (1.0F + 0.38F * i));
					i_302_ = i_310_;
					i_311_ = (int) ((color.getBlue() + i_303_ * 0.38F * i) / (1.0F + 0.38F * i));
					i_303_ = i_311_;
				}
				if (++i_300_ == 800)
					i_300_ = 0;
				final int i_312_ = (int) ((i_309_ * 17 + i_310_ + i_311_ + i_304_) / 21.0F);
				final int i_313_ = (int) ((i_310_ * 17 + i_309_ + i_311_ + i_304_) / 22.0F);
				final int i_314_ = (int) ((i_311_ * 17 + i_309_ + i_310_ + i_304_) / 24.0F);
				if (--i_305_ == 0) {
					i_304_ = (int) (Math.random() * 128.0);
					i_305_ = (int) (5.0 + Math.random() * 15.0);
				}
				final Color color_315_ = new Color(i_312_, i_313_, i_314_);
				flexpix[i_306_] = color_315_.getRGB();
			}
			fleximg = createImage(new MemoryImageSource(800, 450, flexpix, 0, 800));
			rd.drawImage(fleximg, 0, 0, null);
		} else {
			rd.setColor(new Color(0, 0, 0));
			rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
			rd.fillRect(0, 0, 800, 450);
			rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		}
	}

	public Image getImage(final String string) {
		final Image image = Toolkit.getDefaultToolkit().createImage(
				new StringBuilder().append("").append(Madness.fpath).append("").append(string).append("").toString());
		final MediaTracker mediatracker = new MediaTracker(app);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (final Exception exception) {
			/* empty */
		}
		return image;
	}

	public String getSvalue(final String string, final int i) {
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
					if (i_446_ == 1 || i_445_ > i)
						i_446_ = 2;
				} else if (i_445_ == i) {
					string_448_ = new StringBuilder().append(string_448_).append(string_447_).toString();
					i_446_ = 1;
				}
			}
			string_443_ = string_448_;
		} catch (final Exception exception) {
			/* empty */
		}
		return string_443_;
	}

	public int getvalue(final String string, final int i) {
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
					if (i_440_ == 1 || i_439_ > i)
						i_440_ = 2;
				} else if (i_439_ == i) {
					string_442_ = new StringBuilder().append(string_442_).append(string_441_).toString();
					i_440_ = 1;
				}
			}
			if (string_442_.equals(""))
				string_442_ = "-1";
			i_437_ = Integer.valueOf(string_442_).intValue();
		} catch (final Exception exception) {
			/* empty */
		}
		return i_437_;
	}

	public void gscrape(final int i, final int i_269_, final int i_270_) {
		if ((bfsc1 == 0 || bfsc2 == 0) && Math.sqrt(i * i + i_269_ * i_269_ + i_270_ * i_270_) / 10.0 > 15.0)
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

	public void hidos() {
		app.sgame.setVisible(false);
		app.snfm1.setVisible(false);
		app.snfm2.setVisible(false);
		app.mstgs.setVisible(false);
	}

	public void hipnoload(final int i, final boolean bool) {
		final int[] is = { m.snap[0], m.snap[1], m.snap[2] };
		while (is[0] + is[1] + is[2] < -30 && !Thread.currentThread().isInterrupted())
			for (int i_45_ = 0; i_45_ < 3; i_45_++)
				if (is[i_45_] < 50)
					is[i_45_]++;
		int i_46_ = (int) (230.0F - 230.0F * (is[0] / 100.0F));
		if (i_46_ > 255)
			i_46_ = 255;
		if (i_46_ < 0)
			i_46_ = 0;
		int i_47_ = (int) (230.0F - 230.0F * (is[1] / 100.0F));
		if (i_47_ > 255)
			i_47_ = 255;
		if (i_47_ < 0)
			i_47_ = 0;
		int i_48_ = (int) (230.0F - 230.0F * (is[2] / 100.0F));
		if (i_48_ > 255)
			i_48_ = 255;
		if (i_48_ < 0)
			i_48_ = 0;
		rd.setColor(new Color(i_46_, i_47_, i_48_));
		rd.fillRect(65, 25, 670, 400);
		rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
		rd.drawImage(bggo, 0, -25, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.setColor(new Color(0, 0, 0));
		rd.fillRect(0, 0, 65, 450);
		rd.fillRect(735, 0, 65, 450);
		rd.fillRect(65, 0, 670, 25);
		rd.fillRect(65, 425, 670, 25);
		rd.setFont(new Font("Arial", 1, 13));
		ftm = rd.getFontMetrics();
		drawcs(50, asay, 0, 0, 0, 3);
		int i_49_ = -90;
		if (multion == 0) {
			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 10)
				i_49_ = 0;
			if (i == 11 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20 || i == 22
					|| i == 23 || i == 26)
				i_49_ = 0;
			if (i < 0 && nplayers != 1 && newparts)
				i_49_ = 0;
		} else if (ransay == 1 || ransay == 2 || ransay == 3 || ransay == 4 || i == 10)
			i_49_ = 0;
		if (i_49_ == 0) {
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
			rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
			rd.drawImage(dude[duds], 95, 35, null);
			rd.setComposite(AlphaComposite.getInstance(3, 0.7F));
			rd.drawImage(flaot, 192, 67, null);
			rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
			i_46_ = (int) (80.0F - 80.0F * (is[0] / 100.0F));
			if (i_46_ > 255)
				i_46_ = 255;
			if (i_46_ < 0)
				i_46_ = 0;
			i_47_ = (int) (80.0F - 80.0F * (is[1] / 100.0F));
			if (i_47_ > 255)
				i_47_ = 255;
			if (i_47_ < 0)
				i_47_ = 0;
			i_48_ = (int) (80.0F - 80.0F * (is[2] / 100.0F));
			if (i_48_ > 255)
				i_48_ = 255;
			if (i_48_ < 0)
				i_48_ = 0;
			rd.setColor(new Color(i_46_, i_47_, i_48_));
			rd.setFont(new Font("Arial", 1, 13));
			if (multion != 0) {
				if (ransay == 1 && i != 10)
					rd.drawString("Multiplayer Tip:  Press [ C ] to access chat quickly during the game!", 262, 92);
				if (ransay == 2 && i != 10) {
					rd.drawString("Multiplayer Tip:  Press [ A ] to make Guidance Arrow point to cars and", 262, 92);
					rd.drawString("click any of the players listed on the right to lock the Arrow on!", 262, 112);
				}
				if (ransay == 3 && i != 10) {
					rd.drawString("Multiplayer Tip:  When wasting in multiplayer it's better to aim slightly", 262, 92);
					rd.drawString("ahead of the other player's car to compensate for internet delay.", 262, 112);
				}
				if (ransay == 4) {
					rd.drawString("When watching a game, click any player listed on the right of the", 262, 92);
					rd.drawString("screen to follow and watch.", 262, 112);
					rd.drawString("Press [ V ] to change the viewing mode!", 262, 132);
				}
				if (i == 10 && ransay != 4) {
					if (tflk) {
						rd.setColor(new Color(200, i_47_, i_48_));
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
						rd.setColor(new Color(200, i_47_, i_48_));
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
		rd.setComposite(AlphaComposite.getInstance(3, 0.8F));
		rd.drawImage(loadingmusic, 289, 205 + i_49_, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.setFont(new Font("Arial", 1, 11));
		ftm = rd.getFontMetrics();
		int i_50_ = i - 1;
		if (i_50_ < 0)
			i_50_ = 32;
		if (!bool) {
			drawcs(340 + i_49_, new StringBuilder().append("").append(sndsize[i_50_]).append(" KB").toString(), 0, 0, 0,
					3);
			drawcs(375 + i_49_, " Please Wait...", 0, 0, 0, 3);
		} else {
			drawcs(365 + i_49_, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
			rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
			rd.drawImage(star[pstar], 359, 385 + i_49_, null);
			rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
			if (pstar != 2)
				if (pstar == 0)
					pstar = 1;
				else
					pstar = 0;
			if (multion != 0)
				drawcs(380 + i_49_, new StringBuilder().append("").append(forstart / 20).toString(), 0, 0, 0, 3);
		}
	}

	public void inishcarselect(final ContO[] contos) {
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
		basefase = 0;
		noclass = false;
		if (testdrive != 1 && testdrive != 2) {
			if (gmode != 0) {
				cfase = 0;
				sc[0] = scm[gmode - 1];
			}
			if (gmode == 0)
				sc[0] = osc;
			if (cd.lastload != 1 || cfase != 3)
				onmsc = sc[0];
			if (cfase == 0 && sc[0] > 15) {
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
					if (cd.lastload != 2) {
						cfase = -1;
						onjoin = -1;
					} else
						cfase = 3;
				}
			}
			if (cfase == 11 || cfase == 101)
				if (sc[0] >= 16 && cd.lastload == 2 && sc[0] < 36)
					cfase = 3;
				else
					cfase = 0;
			if (cfase == 3) {
				if (multion != 0 && cd.lastload == 1) {
					sc[0] = 15;
					minsl = 0;
					maxsl = 15;
					cfase = 0;
				}
				if (cd.lastload == 0) {
					sc[0] = 15;
					minsl = 0;
					maxsl = 15;
					cfase = 0;
				}
				if (cd.lastload == 2) {
					minsl = 16;
					maxsl = cd.nlocars - 1;
					if (sc[0] < minsl)
						sc[0] = minsl;
					if (sc[0] > maxsl)
						sc[0] = maxsl;
					if (onjoin != -1 && multion != 0 && ontyp > 0 && ontyp <= 5) {
						boolean bool = false;
						for (int i = 16; i < cd.nlocars; i++)
							if (Math.abs(cd.cclass[i] - (ontyp - 1)) <= 1) {
								if (!bool) {
									minsl = i;
									bool = true;
								}
								if (bool)
									maxsl = i;
							}
						if (!bool) {
							onjoin = -1;
							noclass = true;
						} else {
							if (sc[0] < minsl)
								sc[0] = minsl;
							if (sc[0] > maxsl)
								sc[0] = maxsl;
							if (Math.abs(cd.cclass[sc[0]] - (ontyp - 1)) > 1)
								sc[0] = minsl;
						}
					}
				}
				if (cd.lastload == -2 && logged) {
					cfase = 5;
					showtf = false;
					cd.action = 3;
					cd.sparkactionloader();
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
		app.mcars.setBackground(new Color(0, 0, 0));
		app.mcars.setForeground(new Color(47, 179, 255));
		app.mcars.alphad = true;
		app.mcars.carsel = true;
		carsbginflex();
		flatrstart = 0;
		m.lightson = false;
		pnext = 0;
		pback = 0;
		lsc = -1;
		mouson = -1;
		if (multion == 0) {
			app.mycar.setLabel(" Include in this game.");
			app.mycar.setBackground(new Color(198, 179, 129));
			app.mycar.setForeground(new Color(0, 0, 0));
			int i = 16;
			if (cd.lastload == 2)
				i = cd.nlocars;
			for (int i_100_ = 0; i_100_ < i; i_100_++) {
				final float[] fs = new float[3];
				Color.RGBtoHSB(contos[i_100_].fcol[0], contos[i_100_].fcol[1], contos[i_100_].fcol[2], fs);
				for (int i_101_ = 0; i_101_ < contos[i_100_].npl; i_101_++)
					if (contos[i_100_].p[i_101_].colnum == 1) {
						contos[i_100_].p[i_101_].hsb[0] = fs[0];
						contos[i_100_].p[i_101_].hsb[1] = fs[1];
						contos[i_100_].p[i_101_].hsb[2] = fs[2];
						contos[i_100_].p[i_101_].oc[0] = contos[i_100_].fcol[0];
						contos[i_100_].p[i_101_].oc[1] = contos[i_100_].fcol[1];
						contos[i_100_].p[i_101_].oc[2] = contos[i_100_].fcol[2];
					}
				Color.RGBtoHSB(contos[i_100_].scol[0], contos[i_100_].scol[1], contos[i_100_].scol[2], fs);
				for (int i_102_ = 0; i_102_ < contos[i_100_].npl; i_102_++)
					if (contos[i_100_].p[i_102_].colnum == 2) {
						contos[i_100_].p[i_102_].hsb[0] = fs[0];
						contos[i_100_].p[i_102_].hsb[1] = fs[1];
						contos[i_100_].p[i_102_].hsb[2] = fs[2];
						contos[i_100_].p[i_102_].oc[0] = contos[i_100_].scol[0];
						contos[i_100_].p[i_102_].oc[1] = contos[i_100_].scol[1];
						contos[i_100_].p[i_102_].oc[2] = contos[i_100_].scol[2];
					}
				contos[i_100_].xy = 0;
			}
			for (int i_103_ = 0; i_103_ < 6; i_103_++)
				arnp[i_103_] = -1.0F;
		}
		m.trk = 0;
		m.crs = true;
		m.x = -400;
		m.y = -525;
		m.z = -50;
		m.xz = 0;
		m.zy = 10;
		m.ground = 495;
		m.ih = 0;
		m.iw = 0;
		m.h = 450;
		m.w = 800;
		m.focus_point = 400;
		m.cx = 400;
		m.cy = 225;
		m.cz = 50;
		if (multion == 0) {
			intertrack.loadimod(false);
			intertrack.play();
		}
	}

	public void inishstageselect(final CheckPoints checkpoints) {
		if (checkpoints.stage == -2 && (cd.msloaded != 1 || !logged)) {
			checkpoints.stage = (int) (Math.random() * 27.0) + 1;
			checkpoints.top20 = 0;
		}
		if (checkpoints.stage > 27)
			checkpoints.stage = (int) (Math.random() * 27.0) + 1;
		if (checkpoints.stage == -2) {
			boolean bool = false;
			for (int i = 1; i < app.mstgs.getItemCount(); i++)
				if (app.mstgs.getItem(i).equals(checkpoints.name))
					bool = true;
			if (!bool)
				checkpoints.stage = (int) (Math.random() * 27.0) + 1;
		}
		if (gmode == 1) {
			if (unlocked[0] != 11 || justwon1)
				checkpoints.stage = unlocked[0];
			else if (winner || checkpoints.stage > 11)
				checkpoints.stage = (int) (Math.random() * 11.0) + 1;
			if (checkpoints.stage == 11)
				checkpoints.stage = 27;
		}
		if (gmode == 2)
			if (unlocked[0] != 17 || justwon2)
				checkpoints.stage = unlocked[1] + 10;
			else if (winner || checkpoints.stage < 11)
				checkpoints.stage = (int) (Math.random() * 17.0) + 11;
		app.sgame.setBackground(new Color(0, 0, 0));
		app.sgame.setForeground(new Color(47, 179, 255));
		app.snfm1.setBackground(new Color(0, 0, 0));
		app.snfm1.setForeground(new Color(47, 179, 255));
		app.snfm2.setBackground(new Color(0, 0, 0));
		app.snfm2.setForeground(new Color(47, 179, 255));
		app.mstgs.setBackground(new Color(0, 0, 0));
		app.mstgs.setForeground(new Color(47, 179, 255));
		app.gmode.setBackground(new Color(49, 49, 0));
		app.gmode.setForeground(new Color(148, 167, 0));
		app.sgame.removeAll();
		app.sgame.add(rd, " NFM 1     ");
		app.sgame.add(rd, " NFM 2     ");
		app.sgame.add(rd, " My Stages ");
		app.sgame.add(rd, " Weekly Top20 ");
		app.sgame.add(rd, " Monthly Top20 ");
		app.sgame.add(rd, " Stage Maker ");
		if (checkpoints.stage > 0 && checkpoints.stage <= 10) {
			app.sgame.select(0);
			nfmtab = 0;
		}
		if (checkpoints.stage > 10) {
			app.sgame.select(1);
			nfmtab = 1;
		}
		if (checkpoints.stage == -2) {
			app.sgame.select(2);
			nfmtab = 2;
		}
		if (checkpoints.stage == -1) {
			app.sgame.select(5);
			nfmtab = 5;
		}
		removeds = 0;
		lfrom = 0;
		cd.staction = 0;
		fase = 2;
	}

	public void inst(final Control control) {
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
		rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
		rd.drawImage(bggo, 65, 25, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.setColor(new Color(0, 0, 0));
		rd.fillRect(735, 0, 65, 450);
		rd.fillRect(65, 425, 670, 25);
		if (aflk)
			aflk = false;
		else
			aflk = true;
		if (flipo != 1 && flipo != 16) {
			if (dudo > 0) {
				if (aflk)
					if (Math.random() > Math.random())
						duds = (int) (Math.random() * 3.0);
					else
						duds = (int) (Math.random() * 2.0);
				dudo--;
			} else
				duds = 0;
			rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
			rd.drawImage(dude[duds], 95, 15, null);
			rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
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
			rd.drawString("I recommended starting with NFM 1 if it\u2019s your first time to play.", 262, 127);
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
			rd.drawImage(ks, 489, 329, null);
			rd.drawString("Toggle radar / map", 527, 351);
		}
		if (flipo == 1 || flipo == 16) {
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			rd.setColor(new Color(0, 0, 0));
			if (flipo == 16)
				rd.drawString("M A I N    C O N T R O L S   -   once again!",
						400 - ftm.stringWidth("M A I N    C O N T R O L S   -   once again!") / 2, 49);
			else
				rd.drawString("M A I N    C O N T R O L S", 400 - ftm.stringWidth("M A I N    C O N T R O L S") / 2,
						49);
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
			drawcs(175,
					"----------------------------------------------------------------------------------------------------------------------------------------------------",
					0, 64, 128, 3);
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
		if (control.enter || control.right) {
			if (control.enter && flipo == 16) {
				flipo = 0;
				fase = oldfase;
				rd.setFont(new Font("Arial", 1, 11));
				ftm = rd.getFontMetrics();
			}
			control.enter = false;
			control.right = false;
			if (flipo >= 1 && flipo <= 15)
				flipo++;
		}
		if (control.left) {
			if (flipo >= 3 && flipo <= 15)
				flipo -= 3;
			if (flipo == 16)
				flipo--;
			control.left = false;
		}
	}

	public void jflexo() {
		if (!badmac) {
			final int[] is = new int[360000];
			final PixelGrabber pixelgrabber = new PixelGrabber(app.offImage, 0, 0, 800, 450, is, 0, 800);
			try {
				pixelgrabber.grabPixels();
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
			int i = 0;
			int i_353_ = 0;
			int i_354_ = 0;
			int i_355_ = 0;
			for (int i_356_ = 0; i_356_ < 360000; i_356_++) {
				final Color color = new Color(is[i_356_]);
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
				if (++i_355_ == 800)
					i_355_ = 0;
				final Color color_362_ = new Color(i_359_, i_360_, i_361_);
				is[i_356_] = color_362_.getRGB();
			}
			final Image image = createImage(new MemoryImageSource(800, 450, is, 0, 800));
			rd.drawImage(image, 0, 0, null);
		} else {
			rd.setColor(new Color(0, 0, 0));
			rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
			rd.fillRect(0, 0, 800, 450);
			rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		}
	}

	public void levelhigh(final int i, final int i_91_, final int i_92_, final int i_93_, final int i_94_) {
		rd.drawImage(gameh, 301, 20, null);
		int i_95_ = 16;
		int i_96_ = 48;
		int i_97_ = 96;
		if (i_93_ < 50)
			if (aflk) {
				i_95_ = 106;
				i_96_ = 176;
				i_97_ = 255;
				aflk = false;
			} else
				aflk = true;
		if (i != im) {
			if (i_92_ == 0)
				drawcs(60, "You Wasted 'em!", i_95_, i_96_, i_97_, 0);
			else if (i_92_ == 1)
				drawcs(60, "Close Finish!", i_95_, i_96_, i_97_, 0);
			else
				drawcs(60, "Close Finish!  Almost got it!", i_95_, i_96_, i_97_, 0);
		} else if (i_91_ == 229) {
			if (discon != 240)
				drawcs(60, "Wasted!", i_95_, i_96_, i_97_, 0);
			else
				drawcs(60, "Disconnected!", i_95_, i_96_, i_97_, 0);
		} else if (i_94_ > 2 || i_94_ < 0)
			drawcs(60, "Stunts!", i_95_, i_96_, i_97_, 0);
		else
			drawcs(60, "Best Stunt!", i_95_, i_96_, i_97_, 0);
		drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
	}

	private Image loadBimage(final byte[] is, final MediaTracker mediatracker, final Toolkit toolkit, final int i) {
		final Image image = toolkit.createImage(is);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (final Exception exception) {
			/* empty */
		}
		final int i_368_ = image.getHeight(ob);
		final int i_369_ = image.getWidth(ob);
		final int[] is_370_ = new int[i_369_ * i_368_];
		final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_369_, i_368_, is_370_, 0, i_369_);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_371_ = 0; i_371_ < i_369_ * i_368_; i_371_++)
			if (is_370_[i_371_] != is_370_[0] || i != 0) {
				final Color color = new Color(is_370_[i_371_]);
				final float[] fs = new float[3];
				Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
				fs[0] = 0.12F;
				fs[1] = 0.45F;
				if (i == 3) {
					fs[0] = 0.13F;
					fs[1] = 0.45F;
				}
				final Color color_372_ = Color.getHSBColor(fs[0], fs[1], fs[2]);
				is_370_[i_371_] = color_372_.getRGB();
			}
		if (i == 2) {
			Color color = new Color(is_370_[0]);
			final int i_373_ = 0x40000000 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
			color = new Color(is_370_[1]);
			final int i_374_ = ~0x7fffffff | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
			for (int i_375_ = 2; i_375_ < i_369_ * i_368_; i_375_++) {
				if (is_370_[i_375_] == is_370_[0])
					is_370_[i_375_] = i_373_;
				if (is_370_[i_375_] == is_370_[1])
					is_370_[i_375_] = i_374_;
			}
			is_370_[0] = i_373_;
			is_370_[1] = i_374_;
		}
		Image image_376_;
		if (i == 2) {
			final BufferedImage bufferedimage = new BufferedImage(i_369_, i_368_, 2);
			bufferedimage.setRGB(0, 0, i_369_, i_368_, is_370_, 0, i_369_);
			image_376_ = bufferedimage;
		} else
			image_376_ = createImage(new MemoryImageSource(i_369_, i_368_, is_370_, 0, i_369_));
		return image_376_;
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

	private Image loadimage(final byte[] is, final MediaTracker mediatracker, final Toolkit toolkit) {
		final Image image = toolkit.createImage(is);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (final Exception exception) {
			/* empty */
		}
		return image;
	}

	public void loadimages() {
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final MediaTracker mediatracker = new MediaTracker(app);
		Image image = null;
		Image image_10_ = null;
		dnload += 8;
		try {
			final File file = new File(
					new StringBuilder().append("").append(Madness.fpath).append("data/images.zip").toString());
			final FileInputStream fileinputstream = new FileInputStream(file);
			final ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream
					.getNextEntry()) {
				int i = (int) zipentry.getSize();
				final String string = zipentry.getName();
				final byte[] is = new byte[i];
				int i_11_ = 0;
				int i_12_;
				for ( /**/ ; i > 0; i -= i_12_) {
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
				if (string.equals("d1.png"))
					dude[0] = loadimage(is, mediatracker, toolkit);
				if (string.equals("d2.png"))
					dude[1] = loadimage(is, mediatracker, toolkit);
				if (string.equals("d3.png"))
					dude[2] = loadimage(is, mediatracker, toolkit);
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
				if (string.equals("8.gif"))
					orank[7] = loadimage(is, mediatracker, toolkit);
				if (string.equals("bgmain.jpg"))
					bgmain = loadBimage(is, mediatracker, toolkit, 2);
				if (string.equals("br.png"))
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
				if (string.equals("speed.gif"))
					osped = loadimage(is, mediatracker, toolkit);
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
				if (string.equals("onfmm.gif"))
					onfmm = loadude(is, mediatracker, toolkit);
				if (string.equals("fixhoop.png"))
					fixhoop = loadimage(is, mediatracker, toolkit);
				if (string.equals("arrow.gif"))
					sarrow = loadimage(is, mediatracker, toolkit);
				if (string.equals("stunts.png"))
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
				if (string.equals("ks.gif"))
					ks = loadimage(is, mediatracker, toolkit);
				if (string.equals("kenter.gif"))
					kenter = loadimage(is, mediatracker, toolkit);
				if (string.equals("nfm.gif"))
					nfm = loadimage(is, mediatracker, toolkit);
				if (string.equals("options.png"))
					opti = loadimage(is, mediatracker, toolkit);
				if (string.equals("options2.png"))
					opti2 = loadimage(is, mediatracker, toolkit);
				if (string.equals("opback.png"))
					opback = loadimage(is, mediatracker, toolkit);
				if (string.equals("logocars.png"))
					logocars = loadimage(is, mediatracker, toolkit);
				if (string.equals("logomad.png"))
					logomadnes = loadimage(is, mediatracker, toolkit);
				if (string.equals("logomadbg.jpg"))
					logomadbg = loadimage(is, mediatracker, toolkit);
				if (string.equals("byrd.png"))
					byrd = loadimage(is, mediatracker, toolkit);
				if (string.equals("bggo.jpg"))
					bggo = loadimage(is, mediatracker, toolkit);
				if (string.equals("nfmcoms.png"))
					nfmcoms = loadimage(is, mediatracker, toolkit);
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
				if (string.equals("cnmc.gif"))
					cnmc = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("ready.gif"))
					redy = loadBimage(is, mediatracker, toolkit, 0);
				if (string.equals("notreg.gif"))
					ntrg = loadBimage(is, mediatracker, toolkit, 0);
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
				if (string.equals("top20s.gif"))
					top20s = loadimage(is, mediatracker, toolkit);
				dnload += 2;
			}
			fileinputstream.close();
			zipinputstream.close();
		} catch (final Exception exception) {
			System.out.println(new StringBuilder().append("Error Loading Images: ").append(exception).toString());
		}
		makecarsbgc(image, image_10_);
		System.gc();
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
		shload += (dnload + 10.0F - shload) / 100.0F;
		if (shload > kbload)
			shload = kbload;
		if (dnload == kbload)
			shload = kbload;
		drawcs(410,
				new StringBuilder().append("").append((int) ((26.0F + shload / kbload * 200.0F) / 226.0F * 100.0F))
						.append(" % loaded    |    ").append(kbload - (int) shload).append(" KB remaining").toString(),
				32, 64, 128, 3);
		rd.setColor(new Color(32, 64, 128));
		rd.fillRect(287, 371, 26 + (int) (shload / this.kbload * 200.0F), 10);
	}

	public void loadingstage(final int i, final boolean bool) {
		
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
		app.repaint();
		if (cd.staction != 0) {
			app.tnick.setVisible(false);
			app.tpass.setVisible(false);
			cd.staction = 0;
		}
		removeds = 0;
	}

	public void loadmusic(final int i, final String string, final int i_51_) {
		hipnoload(i, false);
		app.setCursor(new Cursor(3));
		app.repaint();
		boolean bool = false;
		if (multion == 0) {
			if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 10)
				bool = true;
			if (i == 11 || i == 12 || i == 13 || i == 14 || i == 17 || i == 18 || i == 19 || i == 20 || i == 22
					|| i == 23 || i == 26)
				bool = true;
			if (i < 0 && nplayers != 1 && newparts)
				bool = true;
		} else if (ransay == 1 || ransay == 2 || ransay == 3 || ransay == 4 || i == 10)
			bool = true;
		if (bool) {
			runtyp = i;
			runner = new Thread(this);
			runner.start();
		}
		loadstrack(i, string, i_51_);
		if (bool) {
			runner.interrupt();
			runner = null;
			runtyp = 0;
		}
		System.gc();
		if (multion == 0 && app.applejava)
			try {
				Thread.sleep(1000L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		if (!lan)
			strack.play();
		else if (im != 0)
			try {
				Thread.sleep(1000L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		app.setCursor(new Cursor(0));
		pcontin = 0;
		mutem = false;
		mutes = false;
		fase = 6;
	}

	private Image loadopsnap(final Image image, int i, final int i_323_) {
		final int i_324_ = image.getHeight(ob);
		final int i_325_ = image.getWidth(ob);
		final int[] is = new int[i_325_ * i_324_];
		final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_325_, i_324_, is, 0, i_325_);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		if (i < 0)
			i = 33;
		int i_326_ = 0;
		if (i_323_ == 1)
			i_326_ = is[61993];
		final int[] is_327_ = { m.snap[0], m.snap[1], m.snap[2] };
		while (is_327_[0] + is_327_[1] + is_327_[2] < -30 && !Thread.currentThread().isInterrupted())
			for (int i_328_ = 0; i_328_ < 3; i_328_++)
				if (is_327_[i_328_] < 50)
					is_327_[i_328_]++;
		for (int i_329_ = 0; i_329_ < i_325_ * i_324_; i_329_++)
			if (is[i_329_] != is[i_323_]) {
				final Color color = new Color(is[i_329_]);
				int i_332_;
				int i_333_;
				int i_334_;
				if (i_323_ == 1 && is[i_329_] == i_326_) {
					i_332_ = (int) (237.0F - 237.0F * (is_327_[0] / 150.0F));
					if (i_332_ > 255)
						i_332_ = 255;
					if (i_332_ < 0)
						i_332_ = 0;
					i_333_ = (int) (237.0F - 237.0F * (is_327_[1] / 150.0F));
					if (i_333_ > 255)
						i_333_ = 255;
					if (i_333_ < 0)
						i_333_ = 0;
					i_334_ = (int) (237.0F - 237.0F * (is_327_[2] / 150.0F));
					if (i_334_ > 255)
						i_334_ = 255;
					if (i_334_ < 0)
						i_334_ = 0;
					if (i == 11) {
						i_332_ = 250;
						i_333_ = 250;
						i_334_ = 250;
					}
				} else {
					i_332_ = (int) (color.getRed() - color.getRed() * (is_327_[0] / 100.0F));
					if (i_332_ > 255)
						i_332_ = 255;
					if (i_332_ < 0)
						i_332_ = 0;
					i_333_ = (int) (color.getGreen() - color.getGreen() * (is_327_[1] / 100.0F));
					if (i_333_ > 255)
						i_333_ = 255;
					if (i_333_ < 0)
						i_333_ = 0;
					i_334_ = (int) (color.getBlue() - color.getBlue() * (is_327_[2] / 100.0F));
					if (i_334_ > 255)
						i_334_ = 255;
					if (i_334_ < 0)
						i_334_ = 0;
				}
				final Color color_335_ = new Color(i_332_, i_333_, i_334_);
				is[i_329_] = color_335_.getRGB();
			}
		final Image image_336_ = createImage(new MemoryImageSource(i_325_, i_324_, is, 0, i_325_));
		return image_336_;
	}

	private Image loadsnap(final Image image) {
		final int i = image.getHeight(ob);
		final int i_316_ = image.getWidth(ob);
		final int[] is = new int[i_316_ * i];
		final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_316_, i, is, 0, i_316_);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_317_ = 0; i_317_ < i_316_ * i; i_317_++) {
			final Color color = new Color(is[i_316_ * i - 1]);
			final Color color_318_ = new Color(is[i_317_]);
			if (color_318_.getRed() != color_318_.getGreen() && color_318_.getGreen() != color_318_.getBlue()) {
				int i_319_ = (int) (color_318_.getRed() + color_318_.getRed() * (m.snap[0] / 100.0F));
				if (i_319_ > 255)
					i_319_ = 255;
				if (i_319_ < 0)
					i_319_ = 0;
				int i_320_ = (int) (color_318_.getGreen() + color_318_.getGreen() * (m.snap[1] / 100.0F));
				if (i_320_ > 255)
					i_320_ = 255;
				if (i_320_ < 0)
					i_320_ = 0;
				int i_321_ = (int) (color_318_.getBlue() + color_318_.getBlue() * (m.snap[2] / 100.0F));
				if (i_321_ > 255)
					i_321_ = 255;
				if (i_321_ < 0)
					i_321_ = 0;
				is[i_317_] = ~0xffffff | i_319_ << 16 | i_320_ << 8 | i_321_;
			} else {
				int i_322_ = (int) ((float) (color.getRed() - color_318_.getRed()) / (float) color.getRed() * 255.0F);
				if (i_322_ > 255)
					i_322_ = 255;
				if (i_322_ < 0)
					i_322_ = 0;
				is[i_317_] = i_322_ << 24 | 0x0 | 0x0 | 0x0;
			}
		}
		final BufferedImage bufferedimage = new BufferedImage(i_316_, i, 2);
		bufferedimage.setRGB(0, 0, i_316_, i, is, 0, i_316_);
		return bufferedimage;
	}

	public void loadsounds() {
		dnload += 3;
		try {
			final File file = new File(
					new StringBuilder().append("").append(Madness.fpath).append("data/sounds.zip").toString());
			final FileInputStream fileinputstream = new FileInputStream(file);
			final ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream
					.getNextEntry()) {
				int i = (int) zipentry.getSize();
				final String string = zipentry.getName();
				final byte[] is = new byte[i];
				int i_0_ = 0;
				int i_1_;
				for ( /**/ ; i > 0; i -= i_1_) {
					i_1_ = zipinputstream.read(is, i_0_, i);
					i_0_ += i_1_;
				}
				for (int i_2_ = 0; i_2_ < 5; i_2_++)
					for (int i_3_ = 0; i_3_ < 5; i_3_++)
						if (string.equals(new StringBuilder().append("").append(i_3_).append("").append(i_2_)
								.append(".wav").toString()))
							engs[i_3_][i_2_] = new soundClip(is);
				for (int i_4_ = 0; i_4_ < 6; i_4_++)
					if (string.equals(new StringBuilder().append("air").append(i_4_).append(".wav").toString()))
						air[i_4_] = new soundClip(is);
				for (int i_5_ = 0; i_5_ < 3; i_5_++)
					if (string.equals(new StringBuilder().append("crash").append(i_5_ + 1).append(".wav").toString()))
						crash[i_5_] = new soundClip(is);
				for (int i_6_ = 0; i_6_ < 3; i_6_++)
					if (string
							.equals(new StringBuilder().append("lowcrash").append(i_6_ + 1).append(".wav").toString()))
						lowcrash[i_6_] = new soundClip(is);
				for (int i_7_ = 0; i_7_ < 3; i_7_++)
					if (string.equals(new StringBuilder().append("skid").append(i_7_ + 1).append(".wav").toString()))
						skid[i_7_] = new soundClip(is);
				for (int i_8_ = 0; i_8_ < 3; i_8_++)
					if (string
							.equals(new StringBuilder().append("dustskid").append(i_8_ + 1).append(".wav").toString()))
						dustskid[i_8_] = new soundClip(is);
				for (int i_9_ = 0; i_9_ < 3; i_9_++)
					if (string
							.equals(new StringBuilder().append("scrape").append(i_9_ + 1).append(".wav").toString())) {
						scrape[i_9_] = new soundClip(is);
						if (i_9_ == 2)
							scrape[3] = new soundClip(is);
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
		} catch (final Exception exception) {
			System.out.println(new StringBuilder().append("Error Loading Sounds: ").append(exception).toString());
		}
		System.gc();
	}

	public void loadstrack(final int i, final String string, final int i_52_) {
		if (i == 1)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 240,
					8400, 135, false, false);
		if (i == 2)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 190,
					9000, 145, false, false);
		if (i == 3)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 170,
					8500, 145, false, false);
		if (i == 4)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 205,
					7500, 125, false, false);
		if (i == 5)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 170,
					7900, 125, false, false);
		if (i == 6)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 370,
					7900, 125, false, false);
		if (i == 7)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 205,
					7500, 125, false, false);
		if (i == 8)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 230,
					7900, 125, false, false);
		if (i == 9)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 180,
					7900, 125, false, false);
		if (i == 10)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 280,
					8100, 145, false, false);
		if (i == 11)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 120,
					8000, 125, false, false);
		if (i == 12)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 260,
					7200, 125, false, false);
		if (i == 13)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 270,
					8000, 125, false, false);
		if (i == 14)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 190,
					8000, 125, false, false);
		if (i == 15)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 162,
					7800, 125, false, false);
		if (i == 16)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220,
					7600, 125, false, false);
		if (i == 17)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 300,
					7500, 125, false, false);
		if (i == 18)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200,
					7900, 125, false, false);
		if (i == 19)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200,
					7900, 125, false, false);
		if (i == 20)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 232,
					7300, 125, false, false);
		if (i == 21)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 370,
					7900, 125, false, false);
		if (i == 22)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 290,
					7900, 125, false, false);
		if (i == 23)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 222,
					7600, 125, false, false);
		if (i == 24)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 230,
					8000, 125, false, false);
		if (i == 25)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220,
					8000, 125, false, false);
		if (i == 26)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 261,
					8000, 125, false, false);
		if (i == 27)
			if (gmode == 2)
				strack = new RadicalMod("music/party.zip", 400, 7600, 125, false, false);
			else
				strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(),
						276, 8800, 145, false, false);
		if (i == 28)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 182,
					8000, 125, false, false);
		if (i == 29)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 220,
					8000, 125, false, false);
		if (i == 30)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 200,
					8000, 125, false, false);
		if (i == 31)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 350,
					7900, 125, false, false);
		if (i == 32)
			strack = new RadicalMod(new StringBuilder().append("music/stage").append(i).append(".zip").toString(), 310,
					8000, 125, false, false);
		if (i < 0)
			if (!string.equals("")) {
				if (i != -2)
					strack = new RadicalMod(
							new StringBuilder().append("mystages/mymusic/").append(string).append(".zip").toString(),
							i_52_, 8000, 125, false, false);
				else
					strack = new RadicalMod(string, i_52_, 8000, 125, false, true);
			} else
				strack = new RadicalMod();
		loadedt = true;
	}

	private Image loadude(final byte[] is, final MediaTracker mediatracker, final Toolkit toolkit) {
		final Image image = toolkit.createImage(is);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (final Exception exception) {
			/* empty */
		}
		final int i = image.getHeight(ob);
		final int i_364_ = image.getWidth(ob);
		final int[] is_365_ = new int[i_364_ * i];
		final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_364_, i, is_365_, 0, i_364_);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_366_ = 0; i_366_ < i_364_ * i; i_366_++) {
			final Color color = new Color(is_365_[i_366_]);
			if (color.getGreen() > color.getRed() + 5 && color.getGreen() > color.getBlue() + 5) {
				int i_367_ = (int) (255.0F - (color.getGreen() - (color.getRed() + color.getBlue()) / 2) * 1.5F);
				if (i_367_ > 255)
					i_367_ = 255;
				if (i_367_ < 0)
					i_367_ = 0;
				is_365_[i_366_] = i_367_ << 24 | 0x0 | 0x0 | 0x0;
			}
		}
		final BufferedImage bufferedimage = new BufferedImage(i_364_, i, 2);
		bufferedimage.setRGB(0, 0, i_364_, i, is_365_, 0, i_364_);
		return bufferedimage;
	}

	public void mainbg(final int i) {
		int i_26_ = 2;
		rd.setColor(new Color(191, 184, 124));
		if (i == -1) {
			if (i != lmode) {
				bgmy[0] = 0;
				bgmy[1] = -400;
				bgup = false;
				bgf = 0.0F;
				lmode = i;
			}
			rd.setColor(new Color(144, 222, 9));
			i_26_ = 8;
		}
		if (i == 0) {
			if (i != lmode) {
				bgmy[0] = 0;
				bgmy[1] = -400;
				bgup = false;
				bgf = 0.0F;
				lmode = i;
			}
			final int i_27_ = (int) (255.0F * bgf + 191.0F * (1.0F - bgf));
			final int i_28_ = (int) (176.0F * bgf + 184.0F * (1.0F - bgf));
			final int i_29_ = (int) (67.0F * bgf + 124.0F * (1.0F - bgf));
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
			rd.setColor(new Color(i_27_, i_28_, i_29_));
			i_26_ = 4;
		}
		if (i == 1) {
			if (i != lmode) {
				bgmy[0] = 0;
				bgmy[1] = -400;
				lmode = i;
			}
			rd.setColor(new Color(255, 176, 67));
			i_26_ = 8;
		}
		if (i == 2) {
			if (i != lmode) {
				bgmy[0] = 0;
				bgmy[1] = -400;
				lmode = i;
				bgf = 0.2F;
			}
			rd.setColor(new Color(188, 170, 122));
			if (flipo == 16) {
				final int i_30_ = (int) (176.0F * bgf + 191.0F * (1.0F - bgf));
				final int i_31_ = (int) (202.0F * bgf + 184.0F * (1.0F - bgf));
				final int i_32_ = (int) (255.0F * bgf + 124.0F * (1.0F - bgf));
				rd.setColor(new Color(i_30_, i_31_, i_32_));
				bgf += 0.025F;
				if (bgf > 0.85F)
					bgf = 0.85F;
			} else
				bgf = 0.2F;
			i_26_ = 2;
		}
		if (i == 3) {
			if (i != lmode) {
				bgmy[0] = 0;
				bgmy[1] = -400;
				bgup = false;
				bgf = 0.0F;
				lmode = i;
			}
			final int i_33_ = (int) (255.0F * bgf + 191.0F * (1.0F - bgf));
			final int i_34_ = (int) (176.0F * bgf + 184.0F * (1.0F - bgf));
			final int i_35_ = (int) (67.0F * bgf + 124.0F * (1.0F - bgf));
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
			rd.setColor(new Color(i_33_, i_34_, i_35_));
			i_26_ = 2;
		}
		if (i != -101)
			if (i == 4) {
				rd.setColor(new Color(216, 177, 100));
				rd.fillRect(65, 0, 670, 425);
			} else
				rd.fillRect(65, 25, 670, 400);
		if (i == 4) {
			if (i != lmode) {
				bgmy[0] = 0;
				bgmy[1] = 400;
				for (int i_36_ = 0; i_36_ < 4; i_36_++) {
					ovw[i_36_] = (int) (50.0 + 150.0 * Math.random());
					ovh[i_36_] = (int) (50.0 + 150.0 * Math.random());
					ovy[i_36_] = (int) (400.0 * Math.random());
					ovx[i_36_] = (int) (Math.random() * 670.0);
					ovsx[i_36_] = (int) (5.0 + Math.random() * 10.0);
				}
				lmode = i;
			}
			for (int i_37_ = 0; i_37_ < 4; i_37_++) {
				rd.setColor(new Color(235, 176, 84));
				rd.fillOval((int) (65 + ovx[i_37_] - ovw[i_37_] * 1.5 / 2.0),
						(int) (25 + ovy[i_37_] - ovh[i_37_] * 1.5 / 2.0), (int) (ovw[i_37_] * 1.5),
						(int) (ovh[i_37_] * 1.5));
				rd.setColor(new Color(255, 176, 67));
				rd.fillOval(65 + ovx[i_37_] - ovh[i_37_] / 2, 25 + ovy[i_37_] - ovh[i_37_] / 2, ovw[i_37_], ovh[i_37_]);
				ovx[i_37_] -= ovsx[i_37_];
				if (ovx[i_37_] + ovw[i_37_] * 1.5 / 2.0 < 0.0) {
					ovw[i_37_] = (int) (50.0 + 150.0 * Math.random());
					ovh[i_37_] = (int) (50.0 + 150.0 * Math.random());
					ovy[i_37_] = (int) (400.0 * Math.random());
					ovx[i_37_] = (int) (670.0 + ovw[i_37_] * 1.5 / 2.0);
					ovsx[i_37_] = (int) (5.0 + Math.random() * 10.0);
				}
			}
		}
		if (i != -101 && i != 4)
			for (int i_38_ = 0; i_38_ < 2; i_38_++) {
				if (i != 2 || flipo != 16)
					rd.drawImage(bgmain, 65, 25 + bgmy[i_38_], null);
				bgmy[i_38_] += i_26_;
				if (bgmy[i_38_] >= 400)
					bgmy[i_38_] = -400;
			}
		rd.setColor(new Color(0, 0, 0));
		rd.fillRect(0, 0, 65, 450);
		rd.fillRect(735, 0, 65, 450);
		if (i != 4)
			rd.fillRect(65, 0, 670, 25);
		rd.fillRect(65, 425, 670, 25);
	}

	public void maini(final Control control) {
		if (flipo == 0) {
			app.setCursor(new Cursor(0));
			flipo++;
		}
		mainbg(1);
		rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
		rd.drawImage(logomadbg, 65, 25, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.drawImage(logomadnes, 233, 186, null);
		float f = flkat / 800.0F;
		if (f > 0.2)
			f = 0.2F;
		if (flkat > 200) {
			f = (400 - flkat) / 1000.0F;
			if (f < 0.0F)
				f = 0.0F;
		}
		flkat++;
		if (flkat == 400)
			flkat = 0;
		rd.setComposite(AlphaComposite.getInstance(3, f));
		rd.drawImage(dude[0], 351 + gxdu, 28 + gydu, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		if (movly == 0) {
			gxdu = (int) (5.0 - 11.0 * Math.random());
			gydu = (int) (5.0 - 11.0 * Math.random());
		}
		movly++;
		if (movly == 2)
			movly = 0;
		rd.drawImage(logocars, 66, 33, null);
		rd.drawImage(opback, 247, 237, null);
		if (muhi < 0) {
			rd.setColor(new Color(140, 70, 0));
			rd.fillRoundRect(335, 293, 114, 19, 7, 20);
		}
		muhi--;
		if (muhi < -5)
			muhi = 50;
		if (control.up) {
			opselect--;
			if (opselect == -1)
				opselect = 3;
			control.up = false;
		}
		if (control.down) {
			opselect++;
			if (opselect == 4)
				opselect = 0;
			control.down = false;
		}
		if (opselect == 0) {
			if (shaded) {
				rd.setColor(new Color(140, 70, 0));
				rd.fillRect(343, 261, 110, 22);
				aflk = false;
			}
			if (aflk) {
				rd.setColor(new Color(200, 200, 0));
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
		if (control.enter || control.handb) {
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
				if (unlocked[0] == 11)
					if (unlocked[1] != 17)
						opselect = 1;
					else
						opselect = 2;
				if (firstime) {
					oldfase = 102;
					fase = 11;
					firstime = false;
				} else
					fase = 102;
			}
			flipo = 0;
			control.enter = false;
			control.handb = false;
		}
		rd.drawImage(byrd, 72, 410, null);
		rd.drawImage(nfmcoms, 567, 410, null);
		if (shaded) {
			app.repaint();
			try {
				Thread.sleep(200L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		}
	}

	public void maini2(final Control control, final int i, final int i_98_, final int i_99_) {
		mainbg(1);
		rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
		rd.drawImage(logomadbg, 65, 25, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.drawImage(logomadnes, 233, 186, null);
		float f = flkat / 800.0F;
		if (f > 0.2)
			f = 0.2F;
		if (flkat > 200) {
			f = (400 - flkat) / 1000.0F;
			if (f < 0.0F)
				f = 0.0F;
		}
		flkat++;
		if (flkat == 400)
			flkat = 0;
		rd.setComposite(AlphaComposite.getInstance(3, f));
		rd.drawImage(dude[0], 351 + gxdu, 28 + gydu, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		if (movly == 0) {
			gxdu = (int) (5.0 - 11.0 * Math.random());
			gydu = (int) (5.0 - 11.0 * Math.random());
		}
		movly++;
		if (movly == 2)
			movly = 0;
		rd.drawImage(logocars, 66, 33, null);
		rd.drawImage(opback, 247, 237, null);
		if (control.up) {
			opselect--;
			if (opselect == -1)
				opselect = 3 - dropf / 15;
			control.up = false;
		}
		if (control.down) {
			opselect++;
			if (opselect == 4 - dropf / 15)
				opselect = 0;
			control.down = false;
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
		if (dropf == 0)
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
		rd.drawImage(opti2, 346, 265 + dropf, null);
		if (dropf != 0) {
			rd.setColor(new Color(58, 30, 8));
			rd.fillRect(357, 365, 87, 15);
		}
		if (control.enter || control.handb) {
			mtop = false;
			if (opselect == 0) {
				multion = 0;
				clangame = 0;
				gmode = 1;
				fase = -9;
			}
			if (opselect == 1) {
				multion = 0;
				clangame = 0;
				gmode = 2;
				fase = -9;
				opselect = 0;
			}
			if (dropf == 0 && opselect == 3) {
				multion = 0;
				clangame = 0;
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
			control.enter = false;
			control.handb = false;
		}
		rd.drawImage(byrd, 72, 410, null);
		rd.drawImage(nfmcoms, 567, 410, null);
		boolean bool = false;
		if (i_99_ == 2)
			bool = true;
		if (drawcarb(true, null, "   < Back   ", 161, 313, i, i_98_, bool)) {
			opselect = 0;
			fase = 10;
		}
		if (shaded) {
			app.repaint();
			try {
				Thread.sleep(200L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		}
	}

	private void makecarsbgc(final Image image, final Image image_386_) {
		final int[] is = new int[268000];
		final PixelGrabber pixelgrabber = new PixelGrabber(carsbg, 0, 0, 670, 400, is, 0, 670);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		final int[] is_387_ = new int[20700];
		final PixelGrabber pixelgrabber_388_ = new PixelGrabber(image, 0, 0, 92, 225, is_387_, 0, 92);
		try {
			pixelgrabber_388_.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		final int[] is_389_ = new int[2112];
		final PixelGrabber pixelgrabber_390_ = new PixelGrabber(image_386_, 0, 0, 88, 24, is_389_, 0, 88);
		try {
			pixelgrabber_390_.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i = 0; i < 670; i++)
			for (int i_391_ = 0; i_391_ < 400; i_391_++) {
				if (i > 14 && i < 106 && i_391_ > 11 && i_391_ < 236
						&& is_387_[i - 14 + (i_391_ - 11) * 92] != is_387_[0]) {
					final Color color = new Color(is[i + i_391_ * 670]);
					final Color color_392_ = new Color(is_387_[i - 14 + (i_391_ - 11) * 92]);
					int i_393_ = (int) (color.getRed() * 0.33 + color_392_.getRed() * 0.67);
					if (i_393_ > 255)
						i_393_ = 255;
					if (i_393_ < 0)
						i_393_ = 0;
					int i_394_ = (int) (color.getGreen() * 0.33 + color_392_.getGreen() * 0.67);
					if (i_394_ > 255)
						i_394_ = 255;
					if (i_394_ < 0)
						i_394_ = 0;
					int i_395_ = (int) (color.getBlue() * 0.33 + color_392_.getBlue() * 0.67);
					if (i_395_ > 255)
						i_395_ = 255;
					if (i_395_ < 0)
						i_395_ = 0;
					final Color color_396_ = new Color(i_393_, i_394_, i_395_);
					is[i + i_391_ * 670] = color_396_.getRGB();
				}
				if (i > 564 && i < 656 && i_391_ > 11 && i_391_ < 236
						&& is_387_[i - 564 + (i_391_ - 11) * 92] != is_387_[0]) {
					final Color color = new Color(is[i + i_391_ * 670]);
					final Color color_397_ = new Color(is_387_[i - 564 + (i_391_ - 11) * 92]);
					int i_398_ = (int) (color.getRed() * 0.33 + color_397_.getRed() * 0.67);
					if (i_398_ > 255)
						i_398_ = 255;
					if (i_398_ < 0)
						i_398_ = 0;
					int i_399_ = (int) (color.getGreen() * 0.33 + color_397_.getGreen() * 0.67);
					if (i_399_ > 255)
						i_399_ = 255;
					if (i_399_ < 0)
						i_399_ = 0;
					int i_400_ = (int) (color.getBlue() * 0.33 + color_397_.getBlue() * 0.67);
					if (i_400_ > 255)
						i_400_ = 255;
					if (i_400_ < 0)
						i_400_ = 0;
					final Color color_401_ = new Color(i_398_, i_399_, i_400_);
					is[i + i_391_ * 670] = color_401_.getRGB();
				}
				if (i > 440 && i < 528 && i_391_ > 53 && i_391_ < 77
						&& is_389_[i - 440 + (i_391_ - 53) * 88] != is_389_[0]) {
					final Color color = new Color(is[i + i_391_ * 670]);
					final Color color_402_ = new Color(is_389_[i - 440 + (i_391_ - 53) * 88]);
					int i_403_ = (int) (color.getRed() * 0.33 + color_402_.getRed() * 0.67);
					if (i_403_ > 255)
						i_403_ = 255;
					if (i_403_ < 0)
						i_403_ = 0;
					int i_404_ = (int) (color.getGreen() * 0.33 + color_402_.getGreen() * 0.67);
					if (i_404_ > 255)
						i_404_ = 255;
					if (i_404_ < 0)
						i_404_ = 0;
					int i_405_ = (int) (color.getBlue() * 0.33 + color_402_.getBlue() * 0.67);
					if (i_405_ > 255)
						i_405_ = 255;
					if (i_405_ < 0)
						i_405_ = 0;
					final Color color_406_ = new Color(i_403_, i_404_, i_405_);
					is[i + i_391_ * 670] = color_406_.getRGB();
				}
			}
		carsbgc = createImage(new MemoryImageSource(670, 400, is, 0, 670));
	}

	public boolean msgcheck(String string) {
		boolean bool = false;
		string = string.toLowerCase();
		final String[] strings = { "fu ", " rape", "slut ", "screw ", "redtube", "fuck", "fuk", "f*ck", "fu*k", "f**k",
				"ass hole", "asshole", "dick", "dik", "cock", "cok ", "shit", "damn", "sex", "anal", "whore", "bitch",
				"biatch", "bich", " ass", "bastard", "cunt", "dildo", "fag", "homo", "mothaf", "motherf", "negro",
				"nigga", "nigger", "pussy", "gay", "homo", "you punk", "i will kill you" };
		for (int i = 0; i < strings.length; i++)
			if (string.indexOf(strings[i]) != -1)
				bool = true;
		if (string.startsWith("ass "))
			bool = true;
		if (string.equals("ass"))
			bool = true;
		if (string.equals("rape"))
			bool = true;
		if (string.equals("fu"))
			bool = true;
		String string_419_ = "";
		String string_420_ = "";
		int i = 0;
		boolean bool_421_ = false;
		boolean bool_422_;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++)
			if (!bool_421_) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				bool_421_ = true;
			} else {
				bool_421_ = false;
				if (!string_420_.equals("")
						&& !string_420_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
					bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		if (!bool_422_)
			for (int i_423_ = 0; i_423_ < strings.length; i_423_++)
				if (string_419_.indexOf(strings[i_423_]) != -1)
					bool = true;
		string_419_ = "";
		string_420_ = "";
		i = 0;
		bool_421_ = true;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++)
			if (!bool_421_) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				bool_421_ = true;
			} else {
				bool_421_ = false;
				if (!string_420_.equals("")
						&& !string_420_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
					bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		if (!bool_422_)
			for (int i_424_ = 0; i_424_ < strings.length; i_424_++)
				if (string_419_.indexOf(strings[i_424_]) != -1)
					bool = true;
		string_419_ = "";
		string_420_ = "";
		i = 0;
		int i_425_ = 0;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++)
			if (i_425_ == 0) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				i_425_ = 2;
			} else {
				i_425_--;
				if (!string_420_.equals("")
						&& !string_420_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
					bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		if (!bool_422_)
			for (int i_426_ = 0; i_426_ < strings.length; i_426_++)
				if (string_419_.indexOf(strings[i_426_]) != -1)
					bool = true;
		string_419_ = "";
		string_420_ = "";
		i = 0;
		i_425_ = 1;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++)
			if (i_425_ == 0) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				i_425_ = 2;
			} else {
				i_425_--;
				if (!string_420_.equals("")
						&& !string_420_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
					bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		if (!bool_422_)
			for (int i_427_ = 0; i_427_ < strings.length; i_427_++)
				if (string_419_.indexOf(strings[i_427_]) != -1)
					bool = true;
		string_419_ = "";
		string_420_ = "";
		i = 0;
		i_425_ = 2;
		for (bool_422_ = false; i < string.length() && !bool_422_; i++)
			if (i_425_ == 0) {
				string_419_ = new StringBuilder().append(string_419_).append("").append(string.charAt(i)).toString();
				i_425_ = 2;
			} else {
				i_425_--;
				if (!string_420_.equals("")
						&& !string_420_.equals(new StringBuilder().append("").append(string.charAt(i)).toString()))
					bool_422_ = true;
				string_420_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			}
		if (!bool_422_)
			for (int i_428_ = 0; i_428_ < strings.length; i_428_++)
				if (string_419_.indexOf(strings[i_428_]) != -1)
					bool = true;
		return bool;
	}

	public void multistat(final Control control, final CheckPoints checkpoints, final int i, final int i_53_,
			final boolean bool, final UDPMistro udpmistro) {
		int i_54_ = -1;
		if (fase != -2) {
			if (exitm != 0 && !holdit) {
				if (!lan || im != 0) {
					if (bool)
						if (i > 357 && i < 396 && i_53_ > 162 && i_53_ < 179) {
							exitm = 2;
							if (multion == 1 && !lan && sendstat == 0) {
								sendstat = 1;
								if (runtyp != -101) {
									if (runner != null)
										runner.interrupt();
									runner = null;
									runner = new Thread(this);
									runner.start();
								}
							}
						} else
							exitm = 0;
					final float[] fs = new float[3];
					Color.RGBtoHSB(m.cgrnd[0], m.cgrnd[1], m.cgrnd[2], fs);
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
					if (i > 357 && i < 396 && i_53_ > 162 && i_53_ < 179) {
						rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
						rd.fillRect(357, 162, 39, 17);
					}
					if (i > 403 && i < 442 && i_53_ > 162 && i_53_ < 179) {
						rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
						rd.fillRect(403, 162, 39, 17);
					}
					rd.setColor(new Color(0, 0, 0));
					rd.drawString("Yes", 366, 175);
					rd.drawString("No", 416, 175);
					rd.setColor(new Color(m.csky[0] / 2, m.csky[1] / 2, m.csky[2] / 2));
					rd.drawRect(403, 162, 39, 17);
					rd.drawRect(357, 162, 39, 17);
				} else {
					rd.setFont(new Font("Arial", 1, 13));
					ftm = rd.getFontMetrics();
					drawcs(125, "You cannot exit game.  Your computer is the LAN server!", 0, 0, 0, 0);
					msgflk[0]++;
					if (msgflk[0] == 67 || bool) {
						msgflk[0] = 0;
						exitm = 0;
					}
					rd.setFont(new Font("Arial", 1, 11));
					ftm = rd.getFontMetrics();
				}
			} else if (exitm == 4) {
				if (bool) {
					if (i > 357 && i < 396 && i_53_ > 362 && i_53_ < 379) {
						alocked = -1;
						lalocked = -1;
						multion = 2;
						control.multion = multion;
						holdit = false;
						exitm = 0;
						control.chatup = 0;
					}
					if ((!lan || im != 0) && i > 403 && i < 442 && i_53_ > 362 && i_53_ < 379) {
						holdcnt = 600;
						exitm = 0;
						control.chatup = 0;
					}
				}
				final float[] fs = new float[3];
				Color.RGBtoHSB(m.cgrnd[0], m.cgrnd[1], m.cgrnd[2], fs);
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
				if (i > 357 && i < 396 && i_53_ > 362 && i_53_ < 379) {
					rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
					rd.fillRect(357, 362, 39, 17);
				}
				if ((!lan || im != 0) && i > 403 && i < 442 && i_53_ > 362 && i_53_ < 379) {
					rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
					rd.fillRect(403, 362, 39, 17);
				}
				rd.setFont(new Font("Arial", 1, 11));
				ftm = rd.getFontMetrics();
				rd.setColor(new Color(0, 0, 0));
				rd.drawString("Yes", 366, 375);
				if (!lan || im != 0)
					rd.drawString("No", 416, 375);
				rd.setColor(new Color(m.csky[0] / 2, m.csky[1] / 2, m.csky[2] / 2));
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
					int i_55_ = 0;
					int i_56_ = 0;
					if (clanchat) {
						i_55_ = 1;
						i_56_ = -23;
					} else if (control.chatup == 2)
						control.chatup = 1;
					for (int i_57_ = i_55_; i_57_ >= 0; i_57_--) {
						boolean bool_58_ = false;
						if (i > 5 && i < 33 && i_53_ > 423 + i_56_ && i_53_ < 446 + i_56_) {
							bool_58_ = true;
							if (control.chatup != 0)
								control.chatup = 0;
						} else if (pointc[i_57_] != 6) {
							pointc[i_57_] = 6;
							floater[i_57_] = 1;
						}
						if (i > 33 && i < 666 && i_53_ > 423 + i_56_ && i_53_ < 446 + i_56_ && lxm != i && i_53_ != lym
								&& lxm != -100) {
							control.chatup = i_57_ + 1;
							cntchatp[i_57_] = 0;
						}
						if (i_57_ == 0) {
							lxm = i;
							lym = i_53_;
						}
						if (exitm != 0 && exitm != 4)
							control.chatup = 0;
						boolean bool_59_ = false;
						if (control.enter && control.chatup == i_57_ + 1) {
							bool_59_ = true;
							control.chatup = 0;
							control.enter = false;
							lxm = -100;
						}
						if (bool) {
							if (mouson == 0) {
								if (i > 676 && i < 785 && i_53_ > 426 + i_56_ && i_53_ < 443 + i_56_
										&& control.chatup == i_57_ + 1) {
									bool_59_ = true;
									control.chatup = 0;
								}
								if (bool_58_ && pointc[i_57_] > 0) {
									pointc[i_57_]--;
									floater[i_57_] = 1;
								}
								if (i_57_ == 0)
									mouson = 1;
							}
							if (i_57_ == 0)
								control.chatup = 0;
						} else if (i_57_ == 0 && mouson != 0)
							mouson = 0;
						if (bool_59_) {
							String string = "";
							int i_60_ = 0;
							int i_61_ = 1;
							for ( /**/ ; i_60_ < lcmsg[i_57_].length(); i_60_++) {
								final String string_62_ = new StringBuilder().append("")
										.append(lcmsg[i_57_].charAt(i_60_)).toString();
								if (string_62_.equals(" "))
									i_61_++;
								else
									i_61_ = 0;
								if (i_61_ < 2)
									string = new StringBuilder().append(string).append(string_62_).toString();
							}
							if (!string.equals("")) {
								string = string.replace('|', ':');
								if (string.toLowerCase().indexOf(app.tpass.getText().toLowerCase()) != -1)
									string = " ";
								if (!msgcheck(string) && updatec[i_57_] > -12) {
									if (cnames[i_57_][6].equals("Game Chat  ") || cnames[i_57_][6].equals(
											new StringBuilder().append("").append(clan).append("'s Chat  ").toString()))
										cnames[i_57_][6] = "";
									for (int i_63_ = 0; i_63_ < 6; i_63_++) {
										sentn[i_57_][i_63_] = sentn[i_57_][i_63_ + 1];
										cnames[i_57_][i_63_] = cnames[i_57_][i_63_ + 1];
									}
									sentn[i_57_][6] = string;
									cnames[i_57_][6] = nickname;
									if (pointc[i_57_] != 6) {
										pointc[i_57_] = 6;
										floater[i_57_] = 1;
									}
									msgflk[i_57_] = 110;
									if (updatec[i_57_] > -11)
										updatec[i_57_] = -11;
									else
										updatec[i_57_]--;
								} else
									warning++;
							}
						}
						if (bool_58_ || floater[i_57_] != 0 || control.chatup == i_57_ + 1 || msgflk[i_57_] != 0) {
							final float[] fs = new float[3];
							Color.RGBtoHSB(m.cgrnd[0], m.cgrnd[1], m.cgrnd[2], fs);
							fs[1] -= 0.15;
							if (fs[1] < 0.0F)
								fs[1] = 0.0F;
							fs[2] += 0.15;
							if (fs[2] > 1.0F)
								fs[2] = 1.0F;
							rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
							rd.fillRect(33, 423 + i_56_, 761, 23);
						}
						if (control.chatup == 0 && app.cmsg.isShowing()) {
							app.cmsg.setVisible(false);
							app.requestFocus();
						}
						if (control.chatup != i_57_ + 1) {
							int i_64_ = 0;
							int i_65_ = (int) (48.0F + 48.0F * (m.snap[1] / 100.0F));
							if (i_65_ > 255)
								i_65_ = 255;
							if (i_65_ < 0)
								i_65_ = 0;
							int i_66_ = (int) (96.0F + 96.0F * (m.snap[2] / 100.0F));
							if (i_66_ > 255)
								i_66_ = 255;
							if (i_66_ < 0)
								i_66_ = 0;
							if (floater[i_57_] != 0) {
								for (int i_67_ = 6; i_67_ >= 0; i_67_--) {
									if (pointc[i_57_] == i_67_)
										if (Math.abs(i_64_ + movepos[i_57_]) > 10) {
											floater[i_57_] = (movepos[i_57_] + i_64_) / 4;
											if (floater[i_57_] > -5 && floater[i_57_] < 0)
												floater[i_57_] = -5;
											if (floater[i_57_] < 10 && floater[i_57_] > 0)
												floater[i_57_] = 10;
											movepos[i_57_] -= floater[i_57_];
										} else {
											movepos[i_57_] = -i_64_;
											floater[i_57_] = 0;
										}
									if (pointc[i_57_] >= i_67_) {
										rd.setColor(new Color(0, i_65_, i_66_));
										rd.setFont(new Font("Tahoma", 1, 11));
										ftm = rd.getFontMetrics();
										rd.drawString(new StringBuilder().append(cnames[i_57_][i_67_]).append(": ")
												.toString(), 39 + i_64_ + movepos[i_57_], 439 + i_56_);
										i_64_ += ftm.stringWidth(new StringBuilder().append(cnames[i_57_][i_67_])
												.append(": ").toString());
										rd.setColor(new Color(0, 0, 0));
										rd.setFont(new Font("Tahoma", 0, 11));
										ftm = rd.getFontMetrics();
										rd.drawString(new StringBuilder().append(sentn[i_57_][i_67_]).append("   ")
												.toString(), 39 + i_64_ + movepos[i_57_], 439 + i_56_);
										i_64_ += ftm.stringWidth(new StringBuilder().append(sentn[i_57_][i_67_])
												.append("   ").toString());
									} else {
										i_64_ += ftm.stringWidth(new StringBuilder().append(cnames[i_57_][i_67_])
												.append(": ").toString());
										i_64_ += ftm.stringWidth(new StringBuilder().append(sentn[i_57_][i_67_])
												.append("   ").toString());
									}
								}
								rd.setColor(new Color(0, 0, 0));
								rd.fillRect(0, 423 + i_56_, 5, 24);
								rd.fillRect(794, 423 + i_56_, 6, 24);
							} else
								for (int i_68_ = pointc[i_57_]; i_68_ >= 0; i_68_--) {
									if (i_68_ == 6 && msgflk[i_57_] != 0)
										msgflk[i_57_]--;
									rd.setColor(new Color(0, i_65_, i_66_));
									rd.setFont(new Font("Tahoma", 1, 11));
									ftm = rd.getFontMetrics();
									if (ftm.stringWidth(
											new StringBuilder().append(cnames[i_57_][i_68_]).append(": ").toString())
											+ 39 + i_64_ < 775) {
										if (i_68_ != 6 || msgflk[i_57_] < 67 || msgflk[i_57_] % 3 != 0)
											rd.drawString(new StringBuilder().append(cnames[i_57_][i_68_]).append(": ")
													.toString(), 39 + i_64_, 439 + i_56_);
										i_64_ += ftm.stringWidth(new StringBuilder().append(cnames[i_57_][i_68_])
												.append(": ").toString());
									} else {
										String string = "";
										for (int i_69_ = 0; ftm.stringWidth(string) + 39 + i_64_ < 775
												&& i_69_ < cnames[i_57_][i_68_].length(); i_69_++)
											string = new StringBuilder().append(string)
													.append(cnames[i_57_][i_68_].charAt(i_69_)).toString();
										string = new StringBuilder().append(string).append("...").toString();
										if (i_68_ != 6 || msgflk[i_57_] < 67 || msgflk[i_57_] % 3 != 0)
											rd.drawString(string, 39 + i_64_, 439 + i_56_);
										break;
									}
									rd.setColor(new Color(0, 0, 0));
									rd.setFont(new Font("Tahoma", 0, 11));
									ftm = rd.getFontMetrics();
									if (ftm.stringWidth(sentn[i_57_][i_68_]) + 39 + i_64_ < 775) {
										if (i_68_ != 6 || msgflk[i_57_] < 67 || msgflk[i_57_] % 3 != 0)
											rd.drawString(new StringBuilder().append(sentn[i_57_][i_68_]).append("   ")
													.toString(), 39 + i_64_, 439 + i_56_);
										i_64_ += ftm.stringWidth(new StringBuilder().append(sentn[i_57_][i_68_])
												.append("   ").toString());
									} else {
										String string = "";
										for (int i_70_ = 0; ftm.stringWidth(string) + 39 + i_64_ < 775
												&& i_70_ < sentn[i_57_][i_68_].length(); i_70_++)
											string = new StringBuilder().append(string)
													.append(sentn[i_57_][i_68_].charAt(i_70_)).toString();
										string = new StringBuilder().append(string).append("...").toString();
										if (i_68_ != 6 || msgflk[i_57_] < 67 || msgflk[i_57_] % 3 != 0)
											rd.drawString(string, 39 + i_64_, 439 + i_56_);
										break;
									}
								}
						} else {
							msgflk[i_57_] = 0;
							i_54_ = i_57_;
						}
						if (bool_58_ || floater[i_57_] != 0) {
							final float[] fs = new float[3];
							Color.RGBtoHSB(m.cgrnd[0], m.cgrnd[1], m.cgrnd[2], fs);
							fs[1] -= 0.076;
							if (fs[1] < 0.0F)
								fs[1] = 0.0F;
							fs[2] += 0.076;
							if (fs[2] > 1.0F)
								fs[2] = 1.0F;
							rd.setColor(Color.getHSBColor(fs[0], fs[1], fs[2]));
							rd.fillRect(5, 423 + i_56_, 28, 23);
						}
						if (bool_58_)
							rd.setColor(new Color(0, 0, 0));
						else
							rd.setColor(new Color((int) (m.cgrnd[0] / 2.0F), (int) (m.cgrnd[1] / 2.0F),
									(int) (m.cgrnd[2] / 2.0F)));
						rd.setFont(new Font("Tahoma", 1, 11));
						rd.drawString("<<", 10, 439 + i_56_);
						rd.setColor(new Color(0, 0, 0));
						rd.drawRect(5, 423 + i_56_, 789, 23);
						rd.drawLine(33, 423 + i_56_, 33, 446 + i_56_);
						i_56_ += 23;
					}
					if (i > 775 && i < 794 && i_53_ > 409 - i_55_ * 23 && i_53_ < 423 - i_55_ * 23) {
						rd.drawRect(775, 409 - i_55_ * 23, 19, 14);
						rd.setColor(new Color(200, 0, 0));
						if (bool) {
							control.chatup = 0;
							if (app.cmsg.isShowing()) {
								app.cmsg.setVisible(false);
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
							} catch (final Exception exception) {
								/* empty */
							}
						}
					}
					rd.setFont(new Font("Arial", 1, 12));
					rd.drawString("x", 782, 420 - i_55_ * 23);
				} else {
					drawWarning();
					if (app.cmsg.isShowing()) {
						app.cmsg.setVisible(false);
						app.requestFocus();
					}
					warning++;
				}
				rd.setFont(new Font("Arial", 1, 11));
				ftm = rd.getFontMetrics();
			} else if (control.chatup != 0) {
				control.chatup = 0;
				if (!lan) {
					runtyp = -101;
					if (runner != null)
						runner.interrupt();
					runner = null;
					runner = new Thread(this);
					runner.start();
				}
			}
			if (holdit && multion == 1 && !lan && sendstat == 0) {
				sendstat = 1;
				if (runtyp != -101) {
					if (runner != null)
						runner.interrupt();
					runner = null;
					runner = new Thread(this);
					runner.start();
				}
			}
			if (control.arrace && starcnt < 38 && !holdit && checkpoints.stage != 10 || multion >= 2) {
				if (alocked != -1 && checkpoints.dested[alocked] != 0) {
					alocked = -1;
					lalocked = -1;
				}
				if (multion >= 2) {
					if (alocked == -1 || holdit) {
						if (cntflock == 100)
							for (int i_71_ = 0; i_71_ < nplayers; i_71_++)
								if (holdit) {
									if (checkpoints.pos[i_71_] == 0) {
										alocked = i_71_;
										im = i_71_;
									}
								} else if (checkpoints.dested[i_71_] == 0) {
									alocked = i_71_;
									im = i_71_;
								}
						cntflock++;
					} else
						cntflock = 0;
					if (lan) {
						boolean bool_72_ = true;
						for (int i_73_ = 0; i_73_ < nplayers; i_73_++)
							if (dested[i_73_] == 0 && plnames[i_73_].indexOf("MadBot") == -1)
								bool_72_ = false;
						if (bool_72_)
							exitm = 2;
					}
				}
				final int i_74_ = nplayers;
				for (int i_75_ = 0; i_75_ < i_74_; i_75_++) {
					boolean bool_76_ = false;
					for (int i_77_ = 0; i_77_ < nplayers; i_77_++)
						if (checkpoints.pos[i_77_] == i_75_ && checkpoints.dested[i_77_] == 0 && !bool_76_) {
							int i_81_ = (int) (100.0F + 100.0F * (m.snap[2] / 100.0F));
							if (i_81_ > 255)
								i_81_ = 255;
							if (i_81_ < 0)
								i_81_ = 0;
							rd.setColor(new Color(0, 0, i_81_));
							if (i_75_ == 0)
								rd.drawString("1st", 673, 76 + 30 * i_75_);
							if (i_75_ == 1)
								rd.drawString("2nd", 671, 76 + 30 * i_75_);
							if (i_75_ == 2)
								rd.drawString("3rd", 671, 76 + 30 * i_75_);
							if (i_75_ >= 3)
								rd.drawString(new StringBuilder().append("").append(i_75_ + 1).append("th").toString(),
										671, 76 + 30 * i_75_);
							if (clangame != 0) {
								int i_82_;
								int i_83_;
								if (pclan[i_77_].toLowerCase().equals(gaclan.toLowerCase())) {
									i_82_ = 255;
									i_83_ = 128;
									i_81_ = 0;
								} else {
									i_82_ = 0;
									i_83_ = 128;
									i_81_ = 255;
								}
								i_82_ += i_82_ * (m.snap[0] / 100.0F);
								if (i_82_ > 255)
									i_82_ = 255;
								if (i_82_ < 0)
									i_82_ = 0;
								i_83_ += i_83_ * (m.snap[1] / 100.0F);
								if (i_83_ > 255)
									i_83_ = 255;
								if (i_83_ < 0)
									i_83_ = 0;
								i_81_ += i_81_ * (m.snap[2] / 100.0F);
								if (i_81_ > 255)
									i_81_ = 255;
								if (i_81_ < 0)
									i_81_ = 0;
								rd.setColor(new Color(i_82_, i_83_, i_81_));
								rd.drawString(plnames[i_77_], 731 - ftm.stringWidth(plnames[i_77_]) / 2,
										70 + 30 * i_75_);
							}
							rd.setColor(new Color(0, 0, 0));
							rd.drawString(plnames[i_77_], 730 - ftm.stringWidth(plnames[i_77_]) / 2, 70 + 30 * i_75_);
							final int i_84_ = (int) (60.0F * checkpoints.magperc[i_77_]);
							int i_85_ = 244;
							int i_86_ = 244;
							i_81_ = 11;
							if (i_84_ > 20)
								i_86_ = (int) (244.0F - 233.0F * ((i_84_ - 20) / 40.0F));
							i_85_ += i_85_ * (m.snap[0] / 100.0F);
							if (i_85_ > 255)
								i_85_ = 255;
							if (i_85_ < 0)
								i_85_ = 0;
							i_86_ += i_86_ * (m.snap[1] / 100.0F);
							if (i_86_ > 255)
								i_86_ = 255;
							if (i_86_ < 0)
								i_86_ = 0;
							i_81_ += i_81_ * (m.snap[2] / 100.0F);
							if (i_81_ > 255)
								i_81_ = 255;
							if (i_81_ < 0)
								i_81_ = 0;
							rd.setColor(new Color(i_85_, i_86_, i_81_));
							rd.fillRect(700, 74 + 30 * i_75_, i_84_, 5);
							rd.setColor(new Color(0, 0, 0));
							rd.drawRect(700, 74 + 30 * i_75_, 60, 5);
							boolean bool_87_ = false;
							if ((im != i_77_ || multion >= 2) && i > 661 && i < 775 && i_53_ > 58 + 30 * i_75_
									&& i_53_ < 83 + 30 * i_75_) {
								bool_87_ = true;
								if (bool) {
									if (!onlock)
										if (alocked != i_77_ || multion >= 2) {
											alocked = i_77_;
											if (multion >= 2)
												im = i_77_;
										} else
											alocked = -1;
									onlock = true;
								} else if (onlock)
									onlock = false;
							}
							if (alocked == i_77_) {
								i_85_ = (int) (159.0F + 159.0F * (this.m.snap[0] / 100.0F));
								if (i_85_ > 255)
									i_85_ = 255;
								if (i_85_ < 0)
									i_85_ = 0;
								i_86_ = (int) (207.0F + 207.0F * (this.m.snap[1] / 100.0F));
								if (i_86_ > 255)
									i_86_ = 255;
								if (i_86_ < 0)
									i_86_ = 0;
								i_81_ = (int) (255.0F + 255.0F * (this.m.snap[2] / 100.0F));
								if (i_81_ > 255)
									i_81_ = 255;
								if (i_81_ < 0)
									i_81_ = 0;
								rd.setColor(new Color(i_85_, i_86_, i_81_));
								rd.drawRect(661, 58 + 30 * i_75_, 114, 25);
								rd.drawRect(662, 59 + 30 * i_75_, 112, 23);
							}
							if (bool_87_ && !onlock) {
								if (alocked == i_77_) {
									i_85_ = (int) (120.0F + 120.0F * (this.m.snap[0] / 100.0F));
									if (i_85_ > 255)
										i_85_ = 255;
									if (i_85_ < 0)
										i_85_ = 0;
									i_86_ = (int) (114.0F + 114.0F * (this.m.snap[1] / 100.0F));
									if (i_86_ > 255)
										i_86_ = 255;
									if (i_86_ < 0)
										i_86_ = 0;
									i_81_ = (int) (255.0F + 255.0F * (this.m.snap[2] / 100.0F));
									if (i_81_ > 255)
										i_81_ = 255;
									if (i_81_ < 0)
										i_81_ = 0;
								} else {
									i_85_ = (int) (140.0F + 140.0F * (this.m.snap[0] / 100.0F));
									if (i_85_ > 255)
										i_85_ = 255;
									if (i_85_ < 0)
										i_85_ = 0;
									i_86_ = (int) (160.0F + 160.0F * (this.m.snap[1] / 100.0F));
									if (i_86_ > 255)
										i_86_ = 255;
									if (i_86_ < 0)
										i_86_ = 0;
									i_81_ = (int) (255.0F + 255.0F * (this.m.snap[2] / 100.0F));
									if (i_81_ > 255)
										i_81_ = 255;
									if (i_81_ < 0)
										i_81_ = 0;
								}
								rd.setColor(new Color(i_85_, i_86_, i_81_));
								rd.drawRect(660, 57 + 30 * i_75_, 116, 27);
							}
							bool_76_ = true;
						}
				}
			}
			if (udpmistro.go && udpmistro.runon == 1 && !holdit) {
				int i_88_ = 0;
				int i_89_ = 0;
				for (int i_90_ = 0; i_90_ < nplayers; i_90_++)
					if (i_90_ != udpmistro.im) {
						i_89_++;
						if (udpmistro.lframe[i_90_] == udpmistro.lcframe[i_90_] || udpmistro.force[i_90_] == 7)
							i_88_++;
						else
							udpmistro.lcframe[i_90_] = udpmistro.lframe[i_90_];
					}
				if (i_88_ == i_89_)
					discon++;
				else if (discon != 0)
					discon = 0;
				if (discon == 240)
					udpmistro.runon = 2;
			}
		}
		if (i_54_ != -1) {
			final float[] fs = new float[3];
			Color.RGBtoHSB(m.cgrnd[0], m.cgrnd[1], m.cgrnd[2], fs);
			fs[1] -= 0.22;
			if (fs[1] < 0.0F)
				fs[1] = 0.0F;
			fs[2] += 0.22;
			if (fs[2] > 1.0F)
				fs[2] = 1.0F;
			final Color color = Color.getHSBColor(fs[0], fs[1], fs[2]);
			rd.setColor(color);
			rd.fillRect(676, 426 - i_54_ * 23, 109, 7);
			rd.setColor(new Color(0, 0, 0));
			rd.setFont(new Font("Tahoma", 1, 11));
			rd.drawString("Send Message  >", 684, 439 - i_54_ * 23);
			rd.setColor(new Color((int) (m.cgrnd[0] / 1.2F), (int) (m.cgrnd[1] / 1.2F), (int) (m.cgrnd[2] / 1.2F)));
			rd.drawRect(676, 426 - i_54_ * 23, 109, 17);
			if (!app.cmsg.isShowing()) {
				app.cmsg.setVisible(true);
				app.cmsg.requestFocus();
				lcmsg[i_54_] = "";
				app.cmsg.setText("");
				app.cmsg.setBackground(color);
			}
			app.movefield(app.cmsg, 34, 424 - i_54_ * 23, 633, 22);
			if (app.cmsg.getText().equals(lcmsg[i_54_]))
				cntchatp[i_54_]++;
			else
				cntchatp[i_54_] = -200;
			lcmsg[i_54_] = new StringBuilder().append("").append(app.cmsg.getText()).toString();
			if (cntchatp[i_54_] == 67)
				control.chatup = 0;
			if (app.cmsg.getText().length() > 100) {
				app.cmsg.setText(app.cmsg.getText().substring(0, 100));
				app.cmsg.select(100, 100);
			}
			rd.setFont(new Font("Arial", 1, 11));
			ftm = rd.getFontMetrics();
		}
	}

	public void musicomp(final int i, final Control control) {
		hipnoload(i, true);
		if (multion != 0) {
			forstart--;
			if (lan && im == 0)
				forstart = 0;
		}
		if (control.handb || control.enter || forstart == 0) {
			System.gc();
			m.trk = 0;
			m.crs = false;
			m.ih = 0;
			m.iw = 0;
			m.h = 450;
			m.w = 800;
			m.focus_point = 400;
			m.cx = 400;
			m.cy = 225;
			m.cz = 50;
			rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
			rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
			if (multion == 0)
				fase = 0;
			else {
				fase = 7001;
				forstart = 0;
				if (!lan)
					try {
						socket = new Socket(server, servport);
						din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						dout = new PrintWriter(socket.getOutputStream(), true);
						runtyp = -101;
						runner = new Thread(this);
						runner.start();
					} catch (final Exception exception) {
						/* empty */
					}
			}
			if (Math.random() > Math.random())
				dudo = 250;
			else
				dudo = 428;
			control.handb = false;
			control.enter = false;
		}
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

	public boolean over(final Image image, final int i, final int i_294_, final int i_295_, final int i_296_) {
		final int i_297_ = image.getHeight(ob);
		final int i_298_ = image.getWidth(ob);
		return i > i_295_ - 5 && i < i_295_ + i_298_ + 5 && i_294_ > i_296_ - 5 && i_294_ < i_296_ + i_297_ + 5;
	}

	public boolean overon(final int i, final int i_289_, final int i_290_, final int i_291_, final int i_292_,
			final int i_293_) {
		return i_292_ > i && i_292_ < i + i_290_ && i_293_ > i_289_ && i_293_ < i_289_ + i_291_;
	}

	public void pausedgame(final int i, final Control control, final Record record) {
		if (chronostart) {
			chronostart = false;
			chrono.pause();
		}
		if (!badmac)
			rd.drawImage(fleximg, 0, 0, null);
		else {
			rd.setColor(new Color(30, 67, 110));
			rd.fillRect(281, 8, 237, 188);
		}
		if (control.up) {
			opselect--;
			if (opselect == -1)
				opselect = 3;
			control.up = false;
		}
		if (control.down) {
			opselect++;
			if (opselect == 4)
				opselect = 0;
			control.down = false;
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
		if (control.enter || control.handb) {
			if (opselect == 0) {
				chronostart = true;
				chrono.resume();
				if (loadedt && !mutem)
					strack.resume();
				fase = 0;
			}
			if (opselect == 1)
				if (record.caught >= 300) {
					if (loadedt && !mutem)
						strack.resume();
					fase = -1;
				} else
					fase = -8;
			if (opselect == 2) {
				chronostart = false;
				chrono.stop();
				if (loadedt)
					strack.stop();
				oldfase = -7;
				fase = 11;
			}
			if (opselect == 3) {
				chronostart = false;
				chrono.stop();
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
				rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			}
			control.enter = false;
			control.handb = false;
		}
	}

	public void pauseimage(final Image image) {
		if (!badmac) {
			final int[] is = new int[360000];
			final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 800, 450, is, 0, 800);
			try {
				pixelgrabber.grabPixels();
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
			int i = 0;
			int i_343_ = 0;
			int i_344_ = 0;
			int i_345_ = 0;
			for (int i_346_ = 0; i_346_ < 360000; i_346_++) {
				final Color color = new Color(is[i_346_]);
				int i_347_;
				if (i_345_ == 0) {
					i_347_ = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
					i_344_ = i_347_;
				} else {
					i_347_ = (color.getRed() + color.getGreen() + color.getBlue() + i_344_ * 30) / 33;
					i_344_ = i_347_;
				}
				if (++i_345_ == 800)
					i_345_ = 0;
				if (i_346_ > 800 * (8 + i_343_) + 281 && i_343_ < 188) {
					final int i_348_ = (i_347_ + 60) / 3;
					final int i_349_ = (i_347_ + 135) / 3;
					final int i_350_ = (i_347_ + 220) / 3;
					if (++i == 237) {
						i_343_++;
						i = 0;
					}
					final Color color_351_ = new Color(i_348_, i_349_, i_350_);
					is[i_346_] = color_351_.getRGB();
				} else {
					final Color color_352_ = new Color(i_347_, i_347_, i_347_);
					is[i_346_] = color_352_.getRGB();
				}
			}
			fleximg = createImage(new MemoryImageSource(800, 450, is, 0, 800));
			rd.drawImage(fleximg, 0, 0, null);
		} else {
			rd.setColor(new Color(0, 0, 0));
			rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
			rd.fillRect(0, 0, 800, 450);
			rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		}
	}

	public void pingstat() {
		final int i = (int) (100.0 * Math.random());
		try {
			final URL url = new URL(new StringBuilder().append("http://c.statcounter.com/9994681/0/14bb645e/1/?reco=")
					.append(i).append("").toString());
			url.openConnection().setConnectTimeout(5000);
			final Image image = Toolkit.getDefaultToolkit().createImage(url);
			final MediaTracker mediatracker = new MediaTracker(app);
			mediatracker.addImage(image, 0);
			mediatracker.waitForID(0);
			mediatracker.removeImage(image, 0);
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public void playsounds(final Mad mad, final Control control, final int i) {
		if ((fase == 0 || fase == 7001) && starcnt < 35 && cntwis != 8 && !mutes) {
			boolean bool = control.up && mad.speed > 0.0F || control.down && mad.speed < 10.0F;
			boolean bool_257_ = mad.skid == 1 && control.handb
					|| Math.abs(mad.scz[0] - (mad.scz[1] + mad.scz[0] + mad.scz[2] + mad.scz[3]) / 4.0F) > 1.0F
					|| Math.abs(mad.scx[0] - (mad.scx[1] + mad.scx[0] + mad.scx[2] + mad.scx[3]) / 4.0F) > 1.0F;
			boolean bool_258_ = false;
			if (control.up && mad.speed < 10.0F) {
				bool_257_ = true;
				bool = true;
				bool_258_ = true;
			}
			if (bool && mad.mtouch) {
				if (!mad.capsized) {
					if (!bool_257_) {
						if (mad.power != 98.0F) {
							if (Math.abs(mad.speed) > 0.0F && Math.abs(mad.speed) <= cd.swits[mad.cn][0]) {
								int i_259_ = (int) (3.0F * Math.abs(mad.speed) / cd.swits[mad.cn][0]);
								if (i_259_ == 2) {
									if (pwait == 0)
										i_259_ = 0;
									else
										pwait--;
								} else
									pwait = 7;
								sparkeng(i_259_, mad.cn);
							}
							if (Math.abs(mad.speed) > cd.swits[mad.cn][0]
									&& Math.abs(mad.speed) <= cd.swits[mad.cn][1]) {
								int i_260_ = (int) (3.0F * (Math.abs(mad.speed) - this.cd.swits[mad.cn][0])
										/ (cd.swits[mad.cn][1] - this.cd.swits[mad.cn][0]));
								if (i_260_ == 2) {
									if (pwait == 0)
										i_260_ = 0;
									else
										pwait--;
								} else
									pwait = 7;
								sparkeng(i_260_, mad.cn);
							}
							if (Math.abs(mad.speed) > cd.swits[mad.cn][1]
									&& Math.abs(mad.speed) <= cd.swits[mad.cn][2]) {
								final int i_261_ = (int) (3.0F * (Math.abs(mad.speed) - this.cd.swits[mad.cn][1])
										/ (cd.swits[mad.cn][2] - this.cd.swits[mad.cn][1]));
								sparkeng(i_261_, mad.cn);
							}
						} else {
							int i_262_ = 2;
							if (pwait == 0) {
								if (Math.abs(mad.speed) > cd.swits[mad.cn][1])
									i_262_ = 3;
							} else
								pwait--;
							sparkeng(i_262_, mad.cn);
						}
					} else {
						sparkeng(-1, mad.cn);
						if (bool_258_) {
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
					sparkeng(3, mad.cn);
				grrd = false;
				aird = false;
			} else {
				pwait = 15;
				if (!mad.mtouch && !grrd && m.random() > 0.4) {
					air[(int) (m.random() * 4.0F)].loop();
					stopcnt = 5;
					grrd = true;
				}
				if (!mad.wtouch && !aird) {
					stopairs();
					air[(int) (m.random() * 4.0F)].loop();
					stopcnt = 10;
					aird = true;
				}
				sparkeng(-1, mad.cn);
			}
			if (mad.cntdest != 0 && cntwis < 7) {
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
			sparkeng(-2, mad.cn);
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
		if (mad.newcar)
			cntwis = 0;
		if (fase == 0 || fase == 7001 || fase == 6 || fase == -1 || fase == -2 || fase == -3 || fase == -4
				|| fase == -5) {
			if (mutes != control.mutes)
				mutes = control.mutes;
			if (control.mutem != mutem) {
				mutem = control.mutem;
				if (mutem) {
					if (loadedt)
						strack.stop();
				} else if (loadedt)
					strack.resume();
			}
		}
		if (mad.cntdest != 0 && cntwis < 7) {
			if (mad.dest)
				cntwis++;
		} else {
			if (mad.cntdest == 0)
				cntwis = 0;
			if (cntwis == 7)
				cntwis = 8;
		}
		if (app.applejava)
			closesounds();
	}

	private Image pressed(final Image image) {
		final int i = image.getHeight(ob);
		final int i_337_ = image.getWidth(ob);
		final int[] is = new int[i_337_ * i];
		final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, i_337_, i, is, 0, i_337_);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i_338_ = 0; i_338_ < i_337_ * i; i_338_++)
			if (is[i_338_] != is[i_337_ * i - 1])
				is[i_338_] = -16777216;
		final Image image_339_ = createImage(new MemoryImageSource(i_337_, i, is, 0, i_337_));
		return image_339_;
	}

	public int py(final int i, final int i_281_, final int i_282_, final int i_283_) {
		return (i - i_281_) * (i - i_281_) + (i_282_ - i_283_) * (i_282_ - i_283_);
	}

	public float pys(final int i, final int i_284_, final int i_285_, final int i_286_) {
		return (float) Math.sqrt((i - i_284_) * (i - i_284_) + (i_285_ - i_286_) * (i_285_ - i_286_));
	}

	public void rad(final int i) {
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
		rd.setColor(new Color(0, 0, 0));
		rd.fillRect(0, 0, 65, 450);
		rd.fillRect(735, 0, 65, 450);
		rd.fillRect(65, 0, 670, 25);
		rd.fillRect(65, 425, 670, 25);
	}

	public void radarstat(final Mad mad, final ContO conto, final CheckPoints checkpoints) {
		rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
		rd.setColor(new Color(m.csky[0], m.csky[1], m.csky[2]));
		rd.fillRoundRect(10, 55, 172, 172, 30, 30);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rd.setColor(new Color(m.csky[0] / 2, m.csky[1] / 2, m.csky[2] / 2));
		for (int i = 0; i < checkpoints.n; i++) {
			int i_241_ = i + 1;
			if (i == checkpoints.n - 1)
				i_241_ = 0;
			boolean bool = false;
			if (checkpoints.typ[i_241_] == -3) {
				i_241_ = 0;
				bool = true;
			}
			final int[] is = { (int) (96.0F - (checkpoints.opx[im] - checkpoints.x[i]) / checkpoints.prox),
					(int) (96.0F - (checkpoints.opx[im] - checkpoints.x[i_241_]) / checkpoints.prox) };
			final int[] is_242_ = { (int) (141.0F - (checkpoints.z[i] - checkpoints.opz[im]) / checkpoints.prox),
					(int) (141.0F - (checkpoints.z[i_241_] - checkpoints.opz[im]) / checkpoints.prox) };
			rot(is, is_242_, 96, 141, mad.cxz, 2);
			rd.drawLine(is[0], is_242_[0], is[1], is_242_[1]);
			if (bool)
				break;
		}
		if (arrace || multion > 1) {
			final int[] is = new int[nplayers];
			final int[] is_245_ = new int[nplayers];
			for (int i = 0; i < nplayers; i++) {
				is[i] = (int) (96.0F - (checkpoints.opx[im] - checkpoints.opx[i]) / checkpoints.prox);
				is_245_[i] = (int) (141.0F - (checkpoints.opz[i] - checkpoints.opz[im]) / checkpoints.prox);
			}
			rot(is, is_245_, 96, 141, mad.cxz, nplayers);
			int i = 0;
			int i_246_ = (int) (80.0F + 80.0F * (m.snap[1] / 100.0F));
			if (i_246_ > 255)
				i_246_ = 255;
			if (i_246_ < 0)
				i_246_ = 0;
			int i_247_ = (int) (159.0F + 159.0F * (m.snap[2] / 100.0F));
			if (i_247_ > 255)
				i_247_ = 255;
			if (i_247_ < 0)
				i_247_ = 0;
			for (int i_248_ = 0; i_248_ < nplayers; i_248_++)
				if (i_248_ != im && checkpoints.dested[i_248_] == 0) {
					if (clangame != 0) {
						if (pclan[i_248_].toLowerCase().equals(gaclan.toLowerCase())) {
							i = 159;
							i_246_ = 80;
							i_247_ = 0;
						} else {
							i = 0;
							i_246_ = 80;
							i_247_ = 159;
						}
						i += i * (m.snap[0] / 100.0F);
						if (i > 255)
							i = 255;
						if (i < 0)
							i = 0;
						i_246_ += i_246_ * (m.snap[1] / 100.0F);
						if (i_246_ > 255)
							i_246_ = 255;
						if (i_246_ < 0)
							i_246_ = 0;
						i_247_ += i_247_ * (m.snap[2] / 100.0F);
						if (i_247_ > 255)
							i_247_ = 255;
						if (i_247_ < 0)
							i_247_ = 0;
					}
					int i_249_ = 2;
					if (alocked == i_248_) {
						i_249_ = 3;
						rd.setColor(new Color(i, i_246_, i_247_));
					} else
						rd.setColor(new Color((i + m.csky[0]) / 2, (m.csky[1] + i_246_) / 2, (i_247_ + m.csky[2]) / 2));
					rd.drawLine(is[i_248_] - i_249_, is_245_[i_248_], is[i_248_] + i_249_, is_245_[i_248_]);
					rd.drawLine(is[i_248_], is_245_[i_248_] + i_249_, is[i_248_], is_245_[i_248_] - i_249_);
					rd.setColor(new Color(i, i_246_, i_247_));
					rd.fillRect(is[i_248_] - 1, is_245_[i_248_] - 1, 3, 3);
				}
		}
		int i = (int) (159.0F + 159.0F * (m.snap[0] / 100.0F));
		if (i > 255)
			i = 255;
		if (i < 0)
			i = 0;
		int i_250_ = 0;
		int i_251_ = 0;
		if (clangame != 0) {
			if (pclan[im].toLowerCase().equals(gaclan.toLowerCase())) {
				i = 159;
				i_250_ = 80;
				i_251_ = 0;
			} else {
				i = 0;
				i_250_ = 80;
				i_251_ = 159;
			}
			i += i * (m.snap[0] / 100.0F);
			if (i > 255)
				i = 255;
			if (i < 0)
				i = 0;
			i_250_ += i_250_ * (m.snap[1] / 100.0F);
			if (i_250_ > 255)
				i_250_ = 255;
			if (i_250_ < 0)
				i_250_ = 0;
			i_251_ += i_251_ * (m.snap[2] / 100.0F);
			if (i_251_ > 255)
				i_251_ = 255;
			if (i_251_ < 0)
				i_251_ = 0;
		}
		rd.setColor(new Color((i + m.csky[0]) / 2, (m.csky[1] + i_250_) / 2, (i_251_ + m.csky[2]) / 2));
		rd.drawLine(96, 139, 96, 143);
		rd.drawLine(94, 141, 98, 141);
		rd.setColor(new Color(i, i_250_, i_251_));
		rd.fillRect(95, 140, 3, 3);
		rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		if (m.darksky) {
			Color color = new Color(m.csky[0], m.csky[1], m.csky[2]);
			final float[] fs = new float[3];
			Color.RGBtoHSB(m.csky[0], m.csky[1], m.csky[2], fs);
			fs[2] = 0.6F;
			color = Color.getHSBColor(fs[0], fs[1], fs[2]);
			rd.setColor(color);
			rd.fillRect(5, 232, 181, 17);
			rd.drawLine(4, 233, 4, 247);
			rd.drawLine(3, 235, 3, 245);
			rd.drawLine(186, 233, 186, 247);
			rd.drawLine(187, 235, 187, 245);
		}
		rd.drawImage(sped, 7, 234, null);
		final int i_252_ = conto.x - lcarx;
		lcarx = conto.x;
		lcary = conto.y;
		final int i_254_ = conto.z - lcarz;
		lcarz = conto.z;
		final float f = (float) Math.sqrt(i_252_ * i_252_ + i_254_ * i_254_);
		final float f_255_ = f * 1.4F * 21.0F * 60.0F * 60.0F / 100000.0F;
		final float f_256_ = f_255_ * 0.621371F;
		rd.setColor(new Color(0, 0, 100));
		rd.drawString(new StringBuilder().append("").append((int) f_255_).toString(), 62, 245);
		rd.drawString(new StringBuilder().append("").append((int) f_256_).toString(), 132, 245);
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

	public void resetstat(final int i) {
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
		for (int i_20_ = 0; i_20_ < 8; i_20_++) {
			dested[i_20_] = 0;
			isbot[i_20_] = false;
			dcrashes[i_20_] = 0;
		}
		runtyp = 0;
		discon = 0;
		dnload = 0;
		beststunt = 0;
		laptime = 0;
		fastestlap = 0;
		sendstat = 0;
		if (fase == 2 || fase == -22)
			sortcars(i);
		if (fase == 22) {
			for (int i_21_ = 0; i_21_ < 2; i_21_++) {
				for (int i_22_ = 0; i_22_ < 7; i_22_++) {
					cnames[i_21_][i_22_] = "";
					sentn[i_21_][i_22_] = "";
				}
				if (i_21_ == 0)
					cnames[i_21_][6] = "Game Chat  ";
				else
					cnames[i_21_][6] = new StringBuilder().append("").append(clan).append("'s Chat  ").toString();
				updatec[i_21_] = -1;
				movepos[i_21_] = 0;
				pointc[i_21_] = 6;
				floater[i_21_] = 0;
				cntchatp[i_21_] = 0;
				msgflk[i_21_] = 0;
				lcmsg[i_21_] = "";
			}
			if (multion == 3)
				ransay = 4;
			else if (ransay == 0)
				ransay = 1 + (int) (Math.random() * 3.0);
			else {
				ransay++;
				if (ransay > 3)
					ransay = 1;
			}
		}
	}

	public void rot(final int[] is, final int[] is_272_, final int i, final int i_273_, final int i_274_,
			final int i_275_) {
		if (i_274_ != 0)
			for (int i_276_ = 0; i_276_ < i_275_; i_276_++) {
				final int i_277_ = is[i_276_];
				final int i_278_ = is_272_[i_276_];
				is[i_276_] = i + (int) ((i_277_ - i) * m.cos(i_274_) - (i_278_ - i_273_) * m.sin(i_274_));
				is_272_[i_276_] = i_273_ + (int) ((i_277_ - i) * m.sin(i_274_) + (i_278_ - i_273_) * m.cos(i_274_));
			}
	}

	@Override
	public void run() {
		if (!Thread.currentThread().isInterrupted()) {
			boolean bool = false;
			while (runtyp > 0 && !Thread.currentThread().isInterrupted()) {
				if (runtyp >= 1 && runtyp <= 140)
					hipnoload(runtyp, false);
				if (runtyp == 176) {
					loading();
					bool = true;
				}
				app.repaint();
				try {
					if (runner != null) {
						/* empty */
					}
					Thread.sleep(20L);
				} catch (final InterruptedException interruptedexception) {
					/* empty */
				}
			}
			if (bool) {
				pingstat();
				bool = false;
			}
			final boolean[] bools = { true, true };
			while ((runtyp == -101 || sendstat == 1) && !lan && !Thread.currentThread().isInterrupted()) {
				String string = new StringBuilder().append("3|").append(playingame).append("|").append(updatec[0])
						.append("|").toString();
				if (clanchat)
					string = new StringBuilder().append(string).append("").append(updatec[1]).append("|").append(clan)
							.append("|").append(clankey).append("|").toString();
				else
					string = new StringBuilder().append(string).append("0|||").toString();
				if (updatec[0] <= -11) {
					for (int i = 0; i < -updatec[0] - 10; i++)
						string = new StringBuilder().append(string).append("").append(cnames[0][6 - i]).append("|")
								.append(sentn[0][6 - i]).append("|").toString();
					updatec[0] = -2;
				}
				if (clanchat && updatec[1] <= -11) {
					for (int i = 0; i < -updatec[1] - 10; i++)
						string = new StringBuilder().append(string).append("").append(cnames[1][6 - i]).append("|")
								.append(sentn[1][6 - i]).append("|").toString();
					updatec[1] = -2;
				}
				if (sendstat == 1) {
					string = new StringBuilder().append("5|").append(playingame).append("|").append(im).append("|")
							.append(beststunt).append("|").append(fastestlap).append("|").toString();
					for (int i = 0; i < nplayers; i++)
						string = new StringBuilder().append(string).append("").append(dcrashes[i]).append("|")
								.toString();
					sendstat = 2;
				}
				boolean bool_13_ = false;
				String string_14_ = "";
				try {
					dout.println(string);
					string_14_ = din.readLine();
					if (string_14_ == null)
						bool_13_ = true;
				} catch (final Exception exception) {
					bool_13_ = true;
				}
				if (bool_13_) {
					try {
						socket.close();
						socket = null;
						din.close();
						din = null;
						dout.close();
						dout = null;
					} catch (final Exception exception) {
						/* empty */
					}
					try {
						socket = new Socket(server, servport);
						din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						dout = new PrintWriter(socket.getOutputStream(), true);
						dout.println(string);
						string_14_ = din.readLine();
						if (string_14_ != null)
							bool_13_ = false;
					} catch (final Exception exception) {
						/* empty */
					}
				}
				if (bool_13_) {
					try {
						socket.close();
						socket = null;
					} catch (final Exception exception) {
						/* empty */
					}
					runtyp = 0;
					if (app.cmsg.isShowing()) {
						app.cmsg.setVisible(false);
						app.requestFocus();
					}
					runner.interrupt();
					runner = null;
				}
				if (sendstat != 2) {
					int i = 2;
					int i_15_ = 1;
					if (clanchat)
						i_15_ = 2;
					for (int i_16_ = 0; i_16_ < i_15_; i_16_++) {
						final int i_17_ = getvalue(string_14_, i_16_);
						if (updatec[i_16_] != i_17_ && updatec[i_16_] >= -2 && pointc[i_16_] == 6) {
							for (int i_18_ = 0; i_18_ < 7; i_18_++) {
								cnames[i_16_][i_18_] = getSvalue(string_14_, i);
								i++;
								sentn[i_16_][i_18_] = getSvalue(string_14_, i);
								i++;
							}
							if (cnames[i_16_][6].equals(""))
								if (i_16_ == 0)
									cnames[i_16_][6] = "Game Chat  ";
								else
									cnames[i_16_][6] = new StringBuilder().append("").append(clan).append("'s Chat  ")
											.toString();
							if (updatec[i_16_] != -2) {
								floater[i_16_] = 1;
								if (bools[i_16_]) {
									msgflk[i_16_] = 67;
									bools[i_16_] = false;
								} else
									msgflk[i_16_] = 110;
							}
							updatec[i_16_] = i_17_;
						}
					}
				} else
					sendstat = 3;
				try {
					if (runner != null) {
						/* empty */
					}
					Thread.sleep(1000L);
				} catch (final InterruptedException interruptedexception) {
					/* empty */
				}
			}
			if (runtyp == -167 || runtyp == -168) {
				try {
					socket = new Socket("multiplayer.needformadness.com", 7061);
					din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					dout = new PrintWriter(socket.getOutputStream(), true);
					dout.println(new StringBuilder().append("101|").append(runtyp + 174).append("|")
							.append(app.tnick.getText()).append("|").append(app.tpass.getText()).append("|")
							.toString());
					din.readLine();
					socket.close();
					socket = null;
					din.close();
					din = null;
					dout.close();
					dout = null;
				} catch (final Exception exception) {
					/* empty */
				}
				runtyp = 0;
			}
			if (runtyp == -166 || runtyp == -167 || runtyp == -168)
				pingstat();
		}
	}

	public void scrape(final int i, final int i_266_, final int i_267_) {
		if (bfscrape == 0 && Math.sqrt(i * i + i_266_ * i_266_ + i_267_ * i_267_) / 10.0 > 10.0) {
			int i_268_ = 0;
			if (m.random() > m.random())
				i_268_ = 1;
			if (i_268_ == 0) {
				sturn1 = 0;
				sturn0++;
				if (sturn0 == 3) {
					i_268_ = 1;
					sturn1 = 1;
					sturn0 = 0;
				}
			} else {
				sturn0 = 0;
				sturn1++;
				if (sturn1 == 3) {
					i_268_ = 0;
					sturn0 = 1;
					sturn1 = 0;
				}
			}
			if (!mutes)
				scrape[i_268_].play();
			bfscrape = 5;
		}
	}

	public void sendwin(final CheckPoints checkpoints) {
		if (logged && multion == 1 && winner) {
			if (checkpoints.wasted == nplayers - 1)
				runtyp = -167;
			else
				runtyp = -168;
		} else
			runtyp = -166;
		runner = new Thread(this);
		runner.start();
	}

	public void setbots(final boolean[] bools, final int[][] is) {
		for (int i = 0; i < nplayers; i++)
			if (plnames[i].indexOf("MadBot") != -1) {
				bools[i] = true;
				isbot[i] = true;
			}
	}

	public void skid(final int i, final float f) {
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

	private void smokeypix(final byte[] is, final MediaTracker mediatracker, final Toolkit toolkit) {
		final Image image = toolkit.createImage(is);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (final Exception exception) {
			/* empty */
		}
		final PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, 466, 202, smokey, 0, 466);
		try {
			pixelgrabber.grabPixels();
		} catch (final InterruptedException interruptedexception) {
			/* empty */
		}
		for (int i = 0; i < 94132; i++)
			if (smokey[i] != smokey[0]) {
				final Color color = new Color(smokey[i]);
				final float[] fs = new float[3];
				Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
				fs[0] = 0.11F;
				fs[1] = 0.45F;
				final Color color_385_ = Color.getHSBColor(fs[0], fs[1], fs[2]);
				smokey[i] = color_385_.getRGB();
			}
	}

	public void snap(final int i) {
		dmg = loadsnap(odmg);
		pwr = loadsnap(opwr);
		was = loadsnap(owas);
		lap = loadsnap(olap);
		pos = loadsnap(opos);
		sped = loadsnap(osped);
		for (int i_287_ = 0; i_287_ < 8; i_287_++)
			rank[i_287_] = loadsnap(orank[i_287_]);
		for (int i_288_ = 0; i_288_ < 4; i_288_++)
			cntdn[i_288_] = loadsnap(ocntdn[i_288_]);
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

	public void sortcars(int i) {
		if (i != 0) {
			for (int i_151_ = 1; i_151_ < 7; i_151_++)
				sc[i_151_] = -1;
			final boolean[] bools = new boolean[7];
			if (i < 0)
				i = 27;
			int i_152_ = 7;
			if (gmode == 1)
				i_152_ = 5;
			boolean bool = false;
			if (i <= 10) {
				int i_153_ = 6;
				if (gmode == 1)
					i_153_ = 4;
				if ((i == 1 || i == 2) && sc[0] != 5) {
					sc[i_153_] = 5;
					i_152_ = i_153_;
				}
				if ((i == 3 || i == 4) && sc[0] != 6) {
					sc[i_153_] = 6;
					i_152_ = i_153_;
				}
				if ((i == 5 || i == 6) && sc[0] != 11) {
					sc[i_153_] = 11;
					i_152_ = i_153_;
				}
				if ((i == 7 || i == 8) && sc[0] != 14) {
					sc[i_153_] = 14;
					i_152_ = i_153_;
				}
				if ((i == 9 || i == 10) && sc[0] != 15) {
					sc[i_153_] = 15;
					i_152_ = i_153_;
				}
			} else {
				i -= 10;
				bool = true;
				if (sc[0] != 7 + (i + 1) / 2 && i != 17) {
					sc[6] = 7 + (i + 1) / 2;
					i_152_ = 6;
				}
			}
			int i_154_ = 16;
			int i_155_ = 1;
			int i_156_ = 2;
			for (int i_157_ = 1; i_157_ < i_152_; i_157_++) {
				bools[i_157_] = false;
				while (!bools[i_157_] && !Thread.currentThread().isInterrupted()) {
					float f = 10.0F;
					if (bool)
						f = 17.0F;
					sc[i_157_] = (int) (Math.random() * (24.0F + 8.0F * (i / f)));
					if (sc[i_157_] >= 16)
						sc[i_157_] -= 16;
					bools[i_157_] = true;
					for (int i_158_ = 0; i_158_ < 7; i_158_++)
						if (i_157_ != i_158_ && sc[i_157_] == sc[i_158_])
							bools[i_157_] = false;
					if (bool)
						f = 16.0F;
					float f_159_ = (15 - sc[i_157_]) / 15.0F * (i / f);
					if (f_159_ > 0.8)
						f_159_ = 0.8F;
					if (i == 17 && f_159_ > 0.5)
						f_159_ = 0.5F;
					if (f_159_ > Math.random())
						bools[i_157_] = false;
					if (gmode == 1) {
						if (sc[i_157_] >= 7 && sc[i_157_] <= 10)
							bools[i_157_] = false;
						if (sc[i_157_] == 12 || sc[i_157_] == 13)
							bools[i_157_] = false;
						if (sc[i_157_] > 5 && unlocked[0] <= 2)
							bools[i_157_] = false;
						if (sc[i_157_] > 6 && unlocked[0] <= 4)
							bools[i_157_] = false;
						if (sc[i_157_] > 11 && unlocked[0] <= 6)
							bools[i_157_] = false;
						if (sc[i_157_] > 14 && unlocked[0] <= 8)
							bools[i_157_] = false;
					}
					if (gmode == 2) {
						if ((sc[i_157_] - 7) * 2 > unlocked[1])
							bools[i_157_] = false;
						if (i == 16 && unlocked[1] == 16 && sc[i_157_] < 9)
							bools[i_157_] = false;
					}
				}
				if (sc[i_157_] < i_154_) {
					i_154_ = sc[i_157_];
					if (i_155_ != i_157_) {
						i_156_ = i_155_;
						i_155_ = i_157_;
					}
				}
			}
			if (!bool && i == 10) {
				boolean bool_160_ = false;
				for (int i_161_ = 0; i_161_ < 7; i_161_++)
					if (sc[i_161_] == 11)
						bool_160_ = true;
				if (!bool_160_ && (Math.random() > Math.random() || gmode != 0))
					sc[i_155_] = 11;
				bool_160_ = false;
				for (int i_162_ = 0; i_162_ < 7; i_162_++)
					if (sc[i_162_] == 14)
						bool_160_ = true;
				if (!bool_160_ && (Math.random() > Math.random() || gmode != 0))
					sc[i_156_] = 14;
			}
			if (i == 12) {
				boolean bool_163_ = false;
				for (int i_164_ = 0; i_164_ < 7; i_164_++)
					if (sc[i_164_] == 11)
						bool_163_ = true;
				if (!bool_163_)
					sc[i_155_] = 11;
			}
			if (i == 14) {
				boolean bool_165_ = false;
				for (int i_166_ = 0; i_166_ < 7; i_166_++)
					if (sc[i_166_] == 12)
						bool_165_ = true;
				if (!bool_165_ && (Math.random() > Math.random() || gmode != 0))
					sc[i_155_] = 12;
				bool_165_ = false;
				for (int i_167_ = 0; i_167_ < 7; i_167_++)
					if (sc[i_167_] == 10)
						bool_165_ = true;
				if (!bool_165_ && (Math.random() > Math.random() || gmode != 0))
					sc[i_156_] = 10;
			}
			if (i == 15) {
				boolean bool_168_ = false;
				for (int i_169_ = 0; i_169_ < 7; i_169_++)
					if (sc[i_169_] == 11)
						bool_168_ = true;
				if (!bool_168_ && (Math.random() > Math.random() || gmode != 0))
					sc[i_155_] = 11;
				bool_168_ = false;
				for (int i_170_ = 0; i_170_ < 7; i_170_++)
					if (sc[i_170_] == 13)
						bool_168_ = true;
				if (!bool_168_ && (Math.random() > Math.random() || gmode != 0))
					sc[i_156_] = 13;
			}
			if (i == 16) {
				boolean bool_171_ = false;
				for (int i_172_ = 0; i_172_ < 7; i_172_++)
					if (sc[i_172_] == 13)
						bool_171_ = true;
				if (!bool_171_ && (Math.random() > Math.random() || gmode != 0))
					sc[i_155_] = 13;
				bool_171_ = false;
				for (int i_173_ = 0; i_173_ < 7; i_173_++)
					if (sc[i_173_] == 12)
						bool_171_ = true;
				if (!bool_171_ && (Math.random() > Math.random() || gmode != 0))
					sc[i_156_] = 12;
			}
			if (cd.lastload == 1) {
				int i_174_ = 0;
				for (int i_175_ = 0; i_175_ < cd.nlcars - 16; i_175_++) {
					if (i_174_ == 0)
						for (int i_176_ = 1; i_176_ < i_152_; i_176_++)
							bools[i_176_] = false;
					if (cd.include[i_175_] && sc[0] != i_175_ + 16) {
						int i_177_;
						for (i_177_ = (int) (1.0 + Math.random() * (i_152_ - 1)); bools[i_177_]; i_177_ = (int) (1.0
								+ Math.random() * (i_152_ - 1))) {
							/* empty */
						}
						bools[i_177_] = true;
						sc[i_177_] = i_175_ + 16;
						if (++i_174_ == i_152_ - 1)
							i_174_ = 0;
					}
				}
			}
			if (cd.lastload == 2) {
				int i_178_ = 0;
				for (int i_179_ = 0; i_179_ < cd.nlocars - 16; i_179_++) {
					if (i_178_ == 0)
						for (int i_180_ = 1; i_180_ < i_152_; i_180_++)
							bools[i_180_] = false;
					if (cd.include[i_179_] && sc[0] != i_179_ + 16) {
						int i_181_;
						for (i_181_ = (int) (1.0 + Math.random() * (i_152_ - 1)); bools[i_181_]; i_181_ = (int) (1.0
								+ Math.random() * (i_152_ - 1))) {
							/* empty */
						}
						bools[i_181_] = true;
						sc[i_181_] = i_179_ + 16;
						if (++i_178_ == i_152_ - 1)
							i_178_ = 0;
					}
				}
			}
		}
	}

	public void sparkeng(int i, final int i_263_) {
		if (lcn != i_263_) {
			for (int i_264_ = 0; i_264_ < 5; i_264_++)
				if (pengs[i_264_]) {
					engs[cd.enginsignature[lcn]][i_264_].stop();
					pengs[i_264_] = false;
				}
			lcn = i_263_;
		}
		i++;
		for (int i_265_ = 0; i_265_ < 5; i_265_++)
			if (i == i_265_) {
				if (!pengs[i_265_]) {
					engs[cd.enginsignature[i_263_]][i_265_].loop();
					pengs[i_265_] = true;
				}
			} else if (pengs[i_265_]) {
				engs[cd.enginsignature[i_263_]][i_265_].stop();
				pengs[i_265_] = false;
			}
	}

	public void stageselect(final CheckPoints checkpoints, final Control control, final int i, final int i_39_,
			final boolean bool) {
		rd.drawImage(br, 65, 25, null);
		rd.drawImage(select, 338, 35, null);
		if (testdrive != 3 && testdrive != 4) {
			if (checkpoints.stage > 0 && cd.staction == 0) {
				if (checkpoints.stage != 1 && (checkpoints.stage != 11 || gmode != 2))
					rd.drawImage(back[pback], 115, 135, null);
				if (checkpoints.stage != 27)
					rd.drawImage(next[pnext], 625, 135, null);
			}
			if (gmode == 0) {
				boolean bool_40_ = false;
				int i_41_ = 0;
				if (nfmtab != app.sgame.getSelectedIndex()) {
					nfmtab = app.sgame.getSelectedIndex();
					app.snfm1.select(0);
					app.snfm2.select(0);
					app.mstgs.select(0);
					app.requestFocus();
					bool_40_ = true;
				}
				if (cd.staction == 5) {
					if (lfrom == 0) {
						cd.staction = 0;
						removeds = 1;
						bool_40_ = true;
					} else {
						cd.onstage = checkpoints.name;
						cd.staction = 2;
						dnload = 2;
					}
					nickname = app.tnick.getText();
					backlog = nickname;
					nickey = cd.tnickey;
					clan = cd.tclan;
					clankey = cd.tclankey;
					app.setloggedcookie();
					logged = true;
					gotlog = true;
					if (cd.reco == 0)
						acexp = 0;
					if (cd.reco > 10)
						acexp = cd.reco - 10;
					if (cd.reco == 3)
						acexp = -1;
					if (cd.reco == 111)
						if (!backlog.toLowerCase().equals(nickname.toLowerCase()))
							acexp = -3;
						else
							acexp = 0;
				}
				if (nfmtab == 2 && cd.staction == 0 && removeds == 1)
					checkpoints.stage = -3;
				if (app.openm && cd.staction == 3) {
					app.tnick.setVisible(false);
					app.tpass.setVisible(false);
					cd.staction = 0;
				}
				int i_42_ = 0;
				app.sgame.setSize(131, 22);
				if (app.sgame.getSelectedIndex() == 0)
					i_42_ = 400 - (app.sgame.getWidth() + 6 + app.snfm1.getWidth()) / 2;
				if (app.sgame.getSelectedIndex() == 1)
					i_42_ = 400 - (app.sgame.getWidth() + 6 + app.snfm2.getWidth()) / 2;
				if (app.sgame.getSelectedIndex() == 2) {
					app.mstgs.setSize(338, 22);
					if (bool_40_)
						if (logged) {
							if (cd.msloaded != 1) {
								app.mstgs.removeAll();
								app.mstgs.add(rd, "Loading your stages now, please wait...");
								app.mstgs.select(0);
								i_41_ = 1;
							}
						} else {
							app.mstgs.removeAll();
							app.mstgs.add(rd, "Please login first to load your stages...");
							app.mstgs.select(0);
							cd.msloaded = 0;
							lfrom = 0;
							cd.staction = 3;
							showtf = false;
							tcnt = 0;
							cntflock = 0;
							cd.reco = -2;
						}
					i_42_ = 400 - (app.sgame.getWidth() + 6 + app.mstgs.getWidth()) / 2;
				}
				if (app.sgame.getSelectedIndex() == 3) {
					app.mstgs.setSize(338, 22);
					if (bool_40_ && cd.msloaded != 3) {
						app.mstgs.removeAll();
						app.mstgs.add(rd, "Loading Top20 list, please wait...");
						app.mstgs.select(0);
						i_41_ = 3;
					}
					i_42_ = 400 - (app.sgame.getWidth() + 6 + app.mstgs.getWidth()) / 2;
				}
				if (app.sgame.getSelectedIndex() == 4) {
					app.mstgs.setSize(338, 22);
					if (bool_40_ && cd.msloaded != 4) {
						app.mstgs.removeAll();
						app.mstgs.add(rd, "Loading Top20 list, please wait...");
						app.mstgs.select(0);
						i_41_ = 4;
					}
					i_42_ = 400 - (app.sgame.getWidth() + 6 + app.mstgs.getWidth()) / 2;
				}
				if (app.sgame.getSelectedIndex() == 5) {
					if (cd.staction != 0) {
						app.tnick.setVisible(false);
						app.tpass.setVisible(false);
						cd.staction = 0;
					}
					app.mstgs.setSize(338, 22);
					if (bool_40_ && cd.msloaded != 2) {
						app.mstgs.removeAll();
						app.mstgs.add(rd, "Loading Stage Maker stages, please wait...");
						app.mstgs.select(0);
						i_41_ = 2;
					}
					i_42_ = 400 - (app.sgame.getWidth() + 6 + app.mstgs.getWidth()) / 2;
				}
				if (!app.sgame.isShowing())
					app.sgame.setVisible(true);
				app.sgame.move(i_42_, 62);
				i_42_ += app.sgame.getWidth() + 6;
				if (nfmtab == 0) {
					if (!app.snfm1.isShowing()) {
						app.snfm1.setVisible(true);
						if (!bool_40_ && checkpoints.stage > 0)
							app.snfm1.select(checkpoints.stage);
					}
					app.snfm1.move(i_42_, 62);
					if (app.snfm2.isShowing())
						app.snfm2.setVisible(false);
					if (app.mstgs.isShowing())
						app.mstgs.setVisible(false);
				}
				if (nfmtab == 1) {
					if (!app.snfm2.isShowing()) {
						app.snfm2.setVisible(true);
						if (!bool_40_ && checkpoints.stage > 10)
							app.snfm2.select(checkpoints.stage - 10);
					}
					app.snfm2.move(i_42_, 62);
					if (app.snfm1.isShowing())
						app.snfm1.setVisible(false);
					if (app.mstgs.isShowing())
						app.mstgs.setVisible(false);
				}
				if (nfmtab == 2 || nfmtab == 3 || nfmtab == 4 || nfmtab == 5) {
					if (!app.mstgs.isShowing()) {
						app.mstgs.setVisible(true);
						if (!bool_40_)
							app.mstgs.select(checkpoints.name);
					}
					app.mstgs.move(i_42_, 62);
					if (app.snfm1.isShowing())
						app.snfm1.setVisible(false);
					if (app.snfm2.isShowing())
						app.snfm2.setVisible(false);
				}
				rd.setFont(new Font("Arial", 1, 13));
				ftm = rd.getFontMetrics();
				if (cd.staction == 0 || cd.staction == 6)
					if (checkpoints.stage != -3) {
						String string = "";
						if (checkpoints.top20 >= 3)
							string = new StringBuilder().append("N#").append(checkpoints.nto).append("  ").toString();
						if (aflk) {
							drawcs(132, new StringBuilder().append(string).append(checkpoints.name).toString(), 240,
									240, 240, 3);
							aflk = false;
						} else {
							drawcs(132, new StringBuilder().append(string).append(checkpoints.name).toString(), 176,
									176, 176, 3);
							aflk = true;
						}
						if (checkpoints.stage == -2 && cd.staction == 0) {
							rd.setFont(new Font("Arial", 1, 11));
							ftm = rd.getFontMetrics();
							rd.setColor(new Color(255, 176, 85));
							if (checkpoints.maker.equals(nickname))
								rd.drawString("Created by You", 70, 115);
							else
								rd.drawString(new StringBuilder().append("Created by :  ").append(checkpoints.maker)
										.append("").toString(), 70, 115);
							if (checkpoints.top20 >= 3)
								rd.drawString(new StringBuilder().append("Added by :  ")
										.append(cd.top20adds[checkpoints.nto - 1]).append(" Players").toString(), 70,
										135);
						}
					} else if (removeds != 1) {
						rd.setFont(new Font("Arial", 1, 13));
						ftm = rd.getFontMetrics();
						drawcs(132, "Failed to load stage...", 255, 138, 0, 3);
						rd.setFont(new Font("Arial", 1, 11));
						ftm = rd.getFontMetrics();
						if (nfmtab == 5)
							drawcs(155,
									"Please Test Drive this stage in the Stage Maker to make sure it can be loaded!",
									255, 138, 0, 3);
						if (nfmtab == 2 || nfmtab == 3 || nfmtab == 4)
							drawcs(155, "It could be a connection error, please try again later.", 255, 138, 0, 3);
						if (nfmtab == 1 || nfmtab == 0) {
							drawcs(155, "Will try to load another stage...", 255, 138, 0, 3);
							app.repaint();
							try {
								Thread.sleep(5000L);
							} catch (final InterruptedException interruptedexception) {
								/* empty */
							}
							if (nfmtab == 0)
								app.snfm1.select(1 + (int) (Math.random() * 10.0));
							if (nfmtab == 1)
								app.snfm2.select(1 + (int) (Math.random() * 17.0));
						}
					}
				if (cd.staction == 3) {
					drawdprom(145, 170);
					if (cd.reco == -2)
						if (lfrom == 0)
							drawcs(171, "Login to Retrieve your Account Stages", 0, 0, 0, 3);
						else
							drawcs(171, "Login to add this stage to your account.", 0, 0, 0, 3);
					if (cd.reco == -1)
						drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
					if (cd.reco == 1)
						drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
					if (cd.reco == 2)
						drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
					if (cd.reco == -167 || cd.reco == -177) {
						if (cd.reco == -167) {
							nickname = app.tnick.getText();
							backlog = nickname;
							cd.reco = -177;
						}
						drawcs(171, "You are currently using a trial account.", 0, 0, 0, 3);
					}
					if (cd.reco == -3 && (tcnt % 3 != 0 || tcnt > 20))
						drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
					if (cd.reco == -4 && (tcnt % 3 != 0 || tcnt > 20))
						drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
					if (!showtf) {
						app.tnick.setBackground(new Color(206, 237, 255));
						if (cd.reco != 1) {
							if (cd.reco != 2)
								app.tnick.setText(nickname);
							app.tnick.setForeground(new Color(0, 0, 0));
						} else
							app.tnick.setForeground(new Color(255, 0, 0));
						app.tnick.requestFocus();
						app.tpass.setBackground(new Color(206, 237, 255));
						if (cd.reco != 2) {
							if (!autolog)
								app.tpass.setText("");
							app.tpass.setForeground(new Color(0, 0, 0));
						} else
							app.tpass.setForeground(new Color(255, 0, 0));
						if (!app.tnick.getText().equals("") && cd.reco != 1)
							app.tpass.requestFocus();
						showtf = true;
					}
					rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 201);
					rd.drawString("Password:", 376 - ftm.stringWidth("Password:") - 14, 231);
					app.movefieldd(app.tnick, 376, 185, 129, 23, true);
					app.movefieldd(app.tpass, 376, 215, 129, 23, true);
					if (tcnt < 30) {
						tcnt++;
						if (tcnt == 30) {
							if (cd.reco == 2)
								app.tpass.setText("");
							app.tnick.setForeground(new Color(0, 0, 0));
							app.tpass.setForeground(new Color(0, 0, 0));
						}
					}
					if (cd.reco != -177) {
						if ((drawcarb(true, null, "       Login       ", 347, 247, i, i_39_, bool) || control.handb
								|| control.enter) && tcnt > 5) {
							tcnt = 0;
							if (!app.tnick.getText().equals("") && !app.tpass.getText().equals("")) {
								autolog = false;
								app.tnick.setVisible(false);
								app.tpass.setVisible(false);
								app.requestFocus();
								cd.staction = 4;
								cd.sparkstageaction();
							} else {
								if (app.tpass.getText().equals(""))
									cd.reco = -4;
								if (app.tnick.getText().equals(""))
									cd.reco = -3;
							}
						}
					} else if (drawcarb(true, null, "  Upgrade to have your own stages!  ", 277, 247, i, i_39_, bool)
							&& cntflock == 0) {
						app.editlink(nickname, true);
						cntflock = 100;
					}
					if (drawcarb(true, null, "  Cancel  ", 409, 282, i, i_39_, bool)) {
						app.tnick.setVisible(false);
						app.tpass.setVisible(false);
						app.requestFocus();
						cd.staction = 0;
					}
					if (drawcarb(true, null, "  Register!  ", 316, 282, i, i_39_, bool)) {
						if (cntflock == 0) {
							app.reglink();
							cntflock = 100;
						}
					} else if (cntflock != 0)
						cntflock--;
				}
				if (cd.staction == 4) {
					drawdprom(145, 170);
					drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
				}
				if (checkpoints.stage == -2 && cd.msloaded == 1 && checkpoints.top20 < 3 && !app.openm
						&& drawcarb(true, null, "X", 609, 113, i, i_39_, bool))
					cd.staction = 6;
				if (cd.staction == -1 && checkpoints.top20 < 3) {
					removeds = 0;
					drawdprom(145, 95);
					drawcs(175, "Failed to remove stage from your account, try again later.", 0, 0, 0, 3);
					if (drawcarb(true, null, " OK ", 379, 195, i, i_39_, bool))
						cd.staction = 0;
				}
				if (cd.staction == 1) {
					drawdprom(145, 95);
					drawcs(195, "Removing stage from your account...", 0, 0, 0, 3);
					removeds = 1;
				}
				if (cd.staction == 6) {
					drawdprom(145, 95);
					drawcs(175, "Remove this stage from your account?", 0, 0, 0, 3);
					if (drawcarb(true, null, " Yes ", 354, 195, i, i_39_, bool)) {
						cd.onstage = app.mstgs.getSelectedItem();
						cd.staction = 1;
						cd.sparkstageaction();
					}
					if (drawcarb(true, null, " No ", 408, 195, i, i_39_, bool))
						cd.staction = 0;
				}
				if (i_41_ == 1) {
					app.drawms();
					app.repaint();
					cd.loadmystages(checkpoints);
				}
				if (i_41_ >= 3) {
					app.drawms();
					app.repaint();
					cd.loadtop20(i_41_);
				}
				if (i_41_ == 2) {
					app.drawms();
					app.repaint();
					cd.loadstagemaker();
				}
				if (checkpoints.stage != -3 && cd.staction == 0 && checkpoints.top20 < 3)
					rd.drawImage(contin[pcontin], 355, 360, null);
				else
					pcontin = 0;
				if (checkpoints.top20 >= 3 && cd.staction != 3 && cd.staction != 4) {
					rd.setFont(new Font("Arial", 1, 11));
					ftm = rd.getFontMetrics();
					if (dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 355, i, i_39_, bool))
						if (logged) {
							cd.onstage = checkpoints.name;
							cd.staction = 2;
							cd.sparkstageaction();
							dnload = 2;
						} else {
							lfrom = 1;
							cd.staction = 3;
							showtf = false;
							tcnt = 0;
							cntflock = 0;
							cd.reco = -2;
						}
					if (dnload == 2) {
						drawcs(370, "Adding stage please wait...", 193, 106, 0, 3);
						if (cd.staction == 0)
							dnload = 3;
						if (cd.staction == -2)
							dnload = 4;
						if (cd.staction == -3)
							dnload = 5;
						if (cd.staction == -1)
							dnload = 6;
						if (dnload != 2)
							cd.staction = 0;
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
				if (testdrive == 0 && checkpoints.top20 < 3) {
					if (!app.gmode.isShowing()) {
						app.gmode.select(0);
						app.gmode.setVisible(true);
					}
					app.gmode.move(400 - app.gmode.getWidth() / 2, 395);
					if (app.gmode.getSelectedIndex() == 0 && nplayers != 7) {
						nplayers = 7;
						fase = 2;
						app.requestFocus();
					}
					if (app.gmode.getSelectedIndex() == 1 && nplayers != 1) {
						nplayers = 1;
						fase = 2;
						app.requestFocus();
					}
				} else if (app.gmode.isShowing())
					app.gmode.setVisible(false);
				if (nfmtab == 0 && app.snfm1.getSelectedIndex() != checkpoints.stage
						&& app.snfm1.getSelectedIndex() != 0) {
					checkpoints.stage = app.snfm1.getSelectedIndex();
					checkpoints.top20 = 0;
					checkpoints.nto = 0;
					hidos();
					fase = 2;
					app.requestFocus();
				}
				if (nfmtab == 1 && app.snfm2.getSelectedIndex() != checkpoints.stage - 10
						&& app.snfm2.getSelectedIndex() != 0) {
					checkpoints.stage = app.snfm2.getSelectedIndex() + 10;
					checkpoints.top20 = 0;
					checkpoints.nto = 0;
					hidos();
					fase = 2;
					app.requestFocus();
				}
				if ((nfmtab == 2 || nfmtab == 5) && !app.mstgs.getSelectedItem().equals(checkpoints.name)
						&& app.mstgs.getSelectedIndex() != 0) {
					if (nfmtab == 2)
						checkpoints.stage = -2;
					else
						checkpoints.stage = -1;
					checkpoints.name = app.mstgs.getSelectedItem();
					checkpoints.top20 = 0;
					checkpoints.nto = 0;
					hidos();
					fase = 2;
					app.requestFocus();
				}
				if (nfmtab == 3 || nfmtab == 4) {
					String string = "";
					final int i_43_ = app.mstgs.getSelectedItem().indexOf(" ") + 1;
					if (i_43_ > 0)
						string = app.mstgs.getSelectedItem().substring(i_43_);
					if (!string.equals("") && !string.equals(checkpoints.name) && app.mstgs.getSelectedIndex() != 0) {
						checkpoints.stage = -2;
						checkpoints.name = string;
						checkpoints.top20 = -cd.msloaded;
						checkpoints.nto = app.mstgs.getSelectedIndex();
						hidos();
						fase = 2;
						app.requestFocus();
					}
				}
			} else {
				rd.setFont(new Font("SansSerif", 1, 13));
				ftm = rd.getFontMetrics();
				if (checkpoints.stage != 27) {
					int i_44_ = checkpoints.stage;
					if (i_44_ > 10)
						i_44_ -= 10;
					drawcs(80, new StringBuilder().append("Stage ").append(i_44_).append("  >").toString(), 255, 128, 0,
							3);
				} else
					drawcs(80, "Final Party Stage  >", 255, 128, 0, 3);
				if (aflk) {
					drawcs(100, new StringBuilder().append("| ").append(checkpoints.name).append(" |").toString(), 240,
							240, 240, 3);
					aflk = false;
				} else {
					drawcs(100, new StringBuilder().append("| ").append(checkpoints.name).append(" |").toString(), 176,
							176, 176, 3);
					aflk = true;
				}
				if (checkpoints.stage != -3)
					rd.drawImage(contin[pcontin], 355, 360, null);
				else
					pcontin = 0;
			}
			if (cd.staction == 0) {
				if ((control.handb || control.enter) && checkpoints.stage != -3 && checkpoints.top20 < 3) {
					app.gmode.setVisible(false);
					hidos();
					dudo = 150;
					fase = 5;
					control.handb = false;
					control.enter = false;
					intertrack.stop();
					intertrack.unloadimod();
				}
				if (checkpoints.stage > 0) {
					if (control.right) {
						if (gmode == 0 || gmode == 1 && checkpoints.stage != unlocked[0]
								|| gmode == 2 && checkpoints.stage != unlocked[1] + 10 || checkpoints.stage == 27) {
							if (checkpoints.stage != 27) {
								hidos();
								checkpoints.stage++;
								if (gmode == 1 && checkpoints.stage == 11)
									checkpoints.stage = 27;
								if (checkpoints.stage > 10) {
									app.sgame.select(1);
									nfmtab = 1;
								} else {
									app.sgame.select(0);
									nfmtab = 0;
								}
								fase = 2;
							}
						} else {
							fase = 4;
							lockcnt = 100;
						}
						control.right = false;
					}
					if (control.left && checkpoints.stage != 1 && (checkpoints.stage != 11 || gmode != 2)) {
						hidos();
						checkpoints.stage--;
						if (gmode == 1 && checkpoints.stage == 26)
							checkpoints.stage = 10;
						if (checkpoints.stage > 10) {
							app.sgame.select(1);
							nfmtab = 1;
						} else {
							app.sgame.select(0);
							nfmtab = 0;
						}
						fase = 2;
						control.left = false;
					}
				}
			}
		} else {
			if (aflk) {
				drawcs(132, checkpoints.name, 240, 240, 240, 3);
				aflk = false;
			} else {
				drawcs(132, checkpoints.name, 176, 176, 176, 3);
				aflk = true;
			}
			rd.drawImage(contin[pcontin], 355, 360, null);
			if (control.handb || control.enter) {
				dudo = 150;
				fase = 5;
				control.handb = false;
				control.enter = false;
				intertrack.stop();
				intertrack.unloadimod();
			}
		}
		if (drawcarb(true, null, " Exit X ", 670, 30, i, i_39_, bool)) {
			fase = 102;
			if (gmode == 0)
				opselect = 3;
			if (gmode == 1)
				opselect = 0;
			if (gmode == 2)
				opselect = 1;
			app.gmode.setVisible(false);
			hidos();
			app.tnick.setVisible(false);
			app.tpass.setVisible(false);
			intertrack.stop();
		}
	}

	public void stat(final Mad mad, final ContO conto, final CheckPoints checkpoints, final Control control,
			final boolean bool) {
		if (!chronostart) {
			//if (loadedt && !mutem)
			//	strack.resume();
			if (starcnt == 0) {
				chrono.setLaps(checkpoints.nlaps);
				chrono.start();
				chronostart = true;
			}
		}
		if (control.radar)
			chrono.paint(10, 260, 1);
		else
			chrono.paint(10, 50, 1);
		if (holdit) {
			int i = 250;
			if (fase == 7001)
				if (exitm != 4) {
					exitm = 0;
					i = 600;
				} else
					i = 1200;
			if (exitm != 4 || !lan || im != 0) {
				holdcnt++;
				if ((control.enter || holdcnt > i) && (control.chatup == 0 || fase != 7001)) {
					fase = -2;
					control.enter = false;
				}
			} else if (control.enter)
				control.enter = false;
		} else {
			if (holdcnt != 0)
				holdcnt = 0;
			if (control.enter || control.exit) {
				if (fase == 0) {
					if (loadedt)
						strack.stop();
					fase = -6;
				} else if (starcnt == 0 && control.chatup == 0 && (multion < 2 || !lan))
					if (exitm == 0)
						exitm = 1;
					else
						exitm = 0;
				if (control.chatup == 0 || fase != 7001)
					control.enter = false;
				control.exit = false;
			}
		}
		if (exitm == 2) {
			fase = -2;
			winner = false;
		}
		if (fase != -2) {
			holdit = false;
			if (checkpoints.haltall)
				checkpoints.haltall = false;
			boolean bool_184_ = false;
			String string = "";
			String string_185_ = "";
			if (clangame != 0 && (!mad.dest || multion >= 2)) {
				bool_184_ = true;
				for (int i = 0; i < nplayers; i++)
					if (checkpoints.dested[i] == 0)
						if (string.equals(""))
							string = pclan[i];
						else if (!string.toLowerCase().equals(pclan[i].toLowerCase())) {
							bool_184_ = false;
							break;
						}
			}
			if (clangame > 1) {
				boolean bool_186_ = false;
				String string_187_ = "";
				if (bool_184_) {
					for (int i = 0; i < nplayers; i++)
						if (!string.toLowerCase().equals(pclan[i].toLowerCase())) {
							string_185_ = pclan[i];
							break;
						}
					if (clangame == 2) {
						bool_186_ = true;
						string_187_ = new StringBuilder().append("Clan ").append(string_185_)
								.append(" wasted, nobody won becuase this is a racing only game!").toString();
					}
					if (clangame == 4 && !string.toLowerCase().equals(gaclan.toLowerCase())) {
						bool_186_ = true;
						string_187_ = new StringBuilder().append("Clan ").append(string_185_)
								.append(" wasted, nobody won becuase ").append(string)
								.append(" should have raced in this racing vs wasting game!").toString();
					}
					if (clangame == 5 && string.toLowerCase().equals(gaclan.toLowerCase())) {
						bool_186_ = true;
						string_187_ = new StringBuilder().append("Clan ").append(string_185_)
								.append(" wasted, nobody won becuase ").append(string)
								.append(" should have raced in this racing vs wasting game!").toString();
					}
				}
				for (int i = 0; i < nplayers; i++)
					if (checkpoints.clear[i] == checkpoints.nlaps * checkpoints.nsp && checkpoints.pos[i] == 0) {
						if (clangame == 3) {
							bool_186_ = true;
							string_187_ = new StringBuilder().append("").append(plnames[i]).append(" of clan ")
									.append(pclan[i])
									.append(" finished first, nobody won becuase this is a wasting only game!")
									.toString();
						}
						if (clangame == 4 && pclan[i].toLowerCase().equals(gaclan.toLowerCase())) {
							bool_186_ = true;
							string_187_ = new StringBuilder().append("").append(plnames[i]).append(" of clan ")
									.append(pclan[i]).append(" finished first, nobody won becuase ").append(pclan[i])
									.append(" should have wasted in this racing vs wasting game!").toString();
						}
						if (clangame == 5 && !pclan[i].toLowerCase().equals(gaclan.toLowerCase())) {
							bool_186_ = true;
							string_187_ = new StringBuilder().append("").append(plnames[i]).append(" of clan ")
									.append(pclan[i]).append(" finished first, nobody won becuase ").append(pclan[i])
									.append(" should have wasted in this racing vs wasting game!").toString();
						}
					}
				if (bool_186_) {
					drawhi(gamefinished, 70);
					if (aflk) {
						drawcs(120, string_187_, 0, 0, 0, 0);
						aflk = false;
					} else {
						drawcs(120, string_187_, 0, 128, 255, 0);
						aflk = true;
					}
					drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
					checkpoints.haltall = true;
					holdit = true;
					winner = false;
				}
			}
			if (multion < 2) {
				if (!holdit && (checkpoints.wasted == nplayers - 1 && nplayers != 1 || bool_184_)) {
					drawhi(youwastedem, 70);
					if (!bool_184_) {
						if (aflk) {
							drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
							aflk = false;
						} else {
							drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
							aflk = true;
						}
					} else if (aflk) {
						drawcs(120, new StringBuilder().append("Your clan ").append(string)
								.append(" has wasted all the cars!").toString(), 0, 0, 0, 0);
						aflk = false;
					} else {
						drawcs(120, new StringBuilder().append("Your clan ").append(string)
								.append(" has wasted all the cars!").toString(), 0, 128, 255, 0);
						aflk = true;
					}
					drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
					checkpoints.haltall = true;
					holdit = true;
					winner = true;
				}
				if (!holdit && mad.dest && cntwis == 8) {
					if (discon != 240)
						drawhi(yourwasted, 70);
					else {
						drawhi(disco, 70);
						stopchat();
					}
					boolean bool_188_ = false;
					if (lan) {
						bool_188_ = true;
						for (int i = 0; i < nplayers; i++)
							if (i != im && dested[i] == 0 && plnames[i].indexOf("MadBot") == -1)
								bool_188_ = false;
					}
					if (fase == 7001 && nplayers - (checkpoints.wasted + 1) >= 2 && discon != 240 && !bool_188_)
						exitm = 4;
					else {
						if (exitm == 4)
							exitm = 0;
						drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
					}
					holdit = true;
					winner = false;
				}
				if (!holdit)
					for (int i = 0; i < nplayers; i++)
						if (checkpoints.clear[i] == checkpoints.nlaps * checkpoints.nsp && checkpoints.pos[i] == 0) {
							if (chronostart)
								chrono.pause();
							// it is stopped later on
							if (clangame == 0) {
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
											drawcs(120,
													new StringBuilder().append("").append(cd.names[sc[i]])
															.append(" finished first, race over!").toString(),
													0, 0, 0, 0);
											aflk = false;
										} else {
											drawcs(120,
													new StringBuilder().append("").append(cd.names[sc[i]])
															.append(" finished first, race over!").toString(),
													0, 128, 255, 0);
											aflk = true;
										}
									} else if (aflk) {
										drawcs(120, new StringBuilder().append("").append(plnames[i])
												.append(" finished first, race over!").toString(), 0, 0, 0, 0);
										aflk = false;
									} else {
										drawcs(120,
												new StringBuilder().append("").append(plnames[i])
														.append(" finished first, race over!").toString(),
												0, 128, 255, 0);
										aflk = true;
									}
									winner = false;
								}
							} else if (pclan[i].toLowerCase().equals(pclan[im].toLowerCase())) {
								drawhi(youwon, 70);
								if (aflk) {
									drawcs(120, new StringBuilder().append("Your clan ").append(pclan[im])
											.append(" finished first, nice job!").toString(), 0, 0, 0, 0);
									aflk = false;
								} else {
									drawcs(120, new StringBuilder().append("Your clan ").append(pclan[im])
											.append(" finished first, nice job!").toString(), 0, 128, 255, 0);
									aflk = true;
								}
								winner = true;
							} else {
								drawhi(youlost, 70);
								if (aflk) {
									drawcs(120,
											new StringBuilder().append("").append(plnames[i]).append(" of clan ")
													.append(pclan[i]).append(" finished first, race over!").toString(),
											0, 0, 0, 0);
									aflk = false;
								} else {
									drawcs(120,
											new StringBuilder().append("").append(plnames[i]).append(" of clan ")
													.append(pclan[i]).append(" finished first, race over!").toString(),
											0, 128, 255, 0);
									aflk = true;
								}
								winner = false;
							}
							drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
							checkpoints.haltall = true;
							holdit = true;
						}
			} else {
				if (!holdit && (checkpoints.wasted >= nplayers - 1 || bool_184_)) {
					String string_189_ = "Someone";
					if (!bool_184_) {
						for (int i = 0; i < nplayers; i++)
							if (checkpoints.dested[i] == 0)
								string_189_ = plnames[i];
					} else
						string_189_ = new StringBuilder().append("Clan ").append(string).append("").toString();
					drawhi(gamefinished, 70);
					if (aflk) {
						drawcs(120, new StringBuilder().append("").append(string_189_)
								.append(" has wasted all the cars!").toString(), 0, 0, 0, 0);
						aflk = false;
					} else {
						drawcs(120, new StringBuilder().append("").append(string_189_)
								.append(" has wasted all the cars!").toString(), 0, 128, 255, 0);
						aflk = true;
					}
					drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
					checkpoints.haltall = true;
					holdit = true;
					winner = false;
				}
				if (!holdit)
					for (int i = 0; i < nplayers; i++)
						if (checkpoints.clear[i] == checkpoints.nlaps * checkpoints.nsp && checkpoints.pos[i] == 0) {
							drawhi(gamefinished, 70);
							if (clangame == 0) {
								if (aflk) {
									drawcs(120, new StringBuilder().append("").append(plnames[i])
											.append(" finished first, race over!").toString(), 0, 0, 0, 0);
									aflk = false;
								} else {
									drawcs(120, new StringBuilder().append("").append(plnames[i])
											.append(" finished first, race over!").toString(), 0, 128, 255, 0);
									aflk = true;
								}
							} else if (aflk) {
								drawcs(120, new StringBuilder().append("Clan ").append(pclan[i])
										.append(" finished first, race over!").toString(), 0, 0, 0, 0);
								aflk = false;
							} else {
								drawcs(120, new StringBuilder().append("Clan ").append(pclan[i])
										.append(" finished first, race over!").toString(), 0, 128, 255, 0);
								aflk = true;
							}
							drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
							checkpoints.haltall = true;
							holdit = true;
							winner = false;
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
					checkpoints.haltall = true;
					holdit = true;
					winner = false;
				}
				if (!holdit) {
					rd.drawImage(wgame, 311, 20, null);
					if (!clanchat) {
						drawcs(397, "Click any player on the right to follow!", 0, 0, 0, 0);
						if (!lan)
							drawcs(412, "Press [V] to change view.  Press [Enter] to exit.", 0, 0, 0, 0);
						else
							drawcs(412, "Press [V] to change view.", 0, 0, 0, 0);
					}
				}
			}
			if (bool) {
				if (checkpoints.stage != 10 && multion < 2 && nplayers != 1 && arrace != control.arrace) {
					arrace = control.arrace;
					if (multion == 1 && arrace)
						control.radar = true;
					if (arrace) {
						wasay = true;
						say = " Arrow now pointing at >  CARS";
						if (multion == 1) {
							final StringBuilder stringbuilder = new StringBuilder();
							say = stringbuilder.append(say)
									.append("    Press [S] to toggle Radar!").toString();
						}
						tcnt = -5;
					}
					if (!arrace) {
						wasay = false;
						say = " Arrow now pointing at >  TRACK";
						if (multion == 1) {
							final StringBuilder stringbuilder = new StringBuilder();
							say = stringbuilder.append(say)
									.append("    Press [S] to toggle Radar!").toString();
						}
						tcnt = -5;
						cntan = 20;
						alocked = -1;
						alocked = -1;
					}
				}
				if (!holdit && fase != -6 && starcnt == 0 && multion < 2 && checkpoints.stage != 10) {
					arrow(mad.point, mad.missedcp, checkpoints, arrace);
					if (!arrace) {
						if (auscnt == 45 && mad.capcnt == 0 && exitm == 0)
							if (mad.missedcp > 0) {
								if (mad.missedcp > 15 && mad.missedcp < 50)
									if (flk)
										drawcs(70, "Checkpoint Missed!", 255, 0, 0, 0);
									else
										drawcs(70, "Checkpoint Missed!", 255, 150, 0, 2);
								mad.missedcp++;
								if (mad.missedcp == 70)
									mad.missedcp = -2;
							} else if (mad.mtouch && cntovn < 70) {
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
					} else if (alocked != lalocked) {
						if (alocked != -1) {
							wasay = true;
							say = new StringBuilder().append(" Arrow Locked on >  ").append(plnames[alocked]).append("")
									.toString();
							tcnt = -5;
						} else {
							wasay = true;
							say = "Arrow Unlocked!";
							tcnt = 10;
						}
						lalocked = alocked;
					}
				}
				if (m.darksky) {
					Color color = new Color(m.csky[0], m.csky[1], m.csky[2]);
					final float[] fs = new float[3];
					Color.RGBtoHSB(m.csky[0], m.csky[1], m.csky[2], fs);
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
				rd.drawString(new StringBuilder().append("").append(mad.nlaps + 1).append(" / ")
						.append(checkpoints.nlaps).append("").toString(), 51, 18);
				rd.drawImage(was, 92, 7, null);
				rd.setColor(new Color(0, 0, 100));
				rd.drawString(new StringBuilder().append("").append(checkpoints.wasted).append(" / ")
						.append(nplayers - 1).append("").toString(), 150, 18);
				rd.drawImage(pos, 42, 27, null);
				rd.drawImage(rank[checkpoints.pos[mad.im]], 110, 28, null);
				drawstat(cd.maxmag[mad.cn], mad.hitmag, mad.newcar, mad.power);
				if (control.radar && checkpoints.stage != 10)
					radarstat(mad, conto, checkpoints);
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
						rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
						rd.drawImage(dude[duds], dudo, 0, null);
						rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
					}
					if (gocnt != 0)
						rd.drawImage(cntdn[gocnt], 385, 50, null);
					else
						rd.drawImage(cntdn[gocnt], 363, 50, null);
				}
				if (looped != 0 && mad.loop == 2)
					looped = 0;
				if (mad.power < 45.0F) {
					if (tcnt == 30 && auscnt == 45 && mad.mtouch && mad.capcnt == 0 && exitm == 0) {
						if (looped != 2) {
							if (pwcnt < 70 || pwcnt < 100 && looped != 0)
								if (pwflk) {
									drawcs(110, "Power low, perform stunt!", 0, 0, 200, 0);
									pwflk = false;
								} else {
									drawcs(110, "Power low, perform stunt!", 255, 100, 0, 0);
									pwflk = true;
								}
						} else if (pwcnt < 100) {
							String string_192_ = "";
							if (multion == 0)
								string_192_ = "  (Press Enter)";
							if (pwflk) {
								drawcs(110, new StringBuilder().append("Please read the Game Instructions!")
										.append(string_192_).append("").toString(), 0, 0, 200, 0);
								pwflk = false;
							} else {
								drawcs(110, new StringBuilder().append("Please read the Game Instructions!")
										.append(string_192_).append("").toString(), 255, 100, 0, 0);
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
				if (mad.capcnt == 0) {
					if (tcnt < 30) {
						if (exitm == 0)
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
						tcnt++;
					} else if (wasay)
						wasay = false;
					if (auscnt < 45) {
						if (exitm == 0)
							if (aflk) {
								drawcs(85, asay, 98, 176, 255, 0);
								aflk = false;
							} else {
								drawcs(85, asay, 0, 128, 255, 0);
								aflk = true;
							}
						auscnt++;
					}
				} else if (exitm == 0)
					if (tflk) {
						drawcs(110, "Bad Landing!", 0, 0, 200, 0);
						tflk = false;
					} else {
						drawcs(110, "Bad Landing!", 255, 100, 0, 0);
						tflk = true;
					}
				if (mad.trcnt == 10) {
					loop = "";
					spin = "";
					asay = "";
					int i = 0;
					while (mad.travzy > 225 && !Thread.currentThread().isInterrupted()) {
						mad.travzy -= 360;
						i++;
					}
					while (mad.travzy < -225 && !Thread.currentThread().isInterrupted()) {
						mad.travzy += 360;
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
					if (i == 0)
						if (mad.ftab && mad.btab)
							loop = "Tabletop and reversed Tabletop";
						else if (mad.ftab || mad.btab)
							loop = "Tabletop";
					if (i > 0 && mad.btab)
						loop = new StringBuilder().append("Hanged ").append(loop).toString();
					if (i < 0 && mad.ftab)
						loop = new StringBuilder().append("Hanged ").append(loop).toString();
					if (loop != "") {
						final StringBuilder stringbuilder = new StringBuilder();
						final xtGraphics var_xtGraphics_193_ = this;
						var_xtGraphics_193_.asay = stringbuilder.append(var_xtGraphics_193_.asay).append(" ")
								.append(loop).toString();
					}
					i = 0;
					mad.travxy = Math.abs(mad.travxy);
					while (mad.travxy > 270 && !Thread.currentThread().isInterrupted()) {
						mad.travxy -= 360;
						i++;
					}
					if (i == 0 && mad.rtab)
						if (loop == "")
							spin = "Tabletop";
						else
							spin = "Flipside";
					if (i == 1)
						spin = "Rollspin";
					if (i == 2)
						spin = "double Rollspin";
					if (i == 3)
						spin = "triple Rollspin";
					if (i >= 4)
						spin = "massive Roll spinning";
					i = 0;
					boolean bool_194_ = false;
					mad.travxz = Math.abs(mad.travxz);
					while (mad.travxz > 90 && !Thread.currentThread().isInterrupted()) {
						mad.travxz -= 180;
						i += 180;
						if (i > 900) {
							i = 900;
							bool_194_ = true;
						}
					}
					if (i != 0) {
						if (loop == "" && spin == "") {
							final StringBuilder stringbuilder = new StringBuilder();
							final xtGraphics var_xtGraphics_195_ = this;
							var_xtGraphics_195_.asay = stringbuilder.append(var_xtGraphics_195_.asay).append(" ")
									.append(i).toString();
							if (bool_194_) {
								final StringBuilder stringbuilder_196_ = new StringBuilder();
								final xtGraphics var_xtGraphics_197_ = this;
								var_xtGraphics_197_.asay = stringbuilder_196_.append(var_xtGraphics_197_.asay)
										.append(" and beyond").toString();
							}
						} else {
							if (spin != "")
								if (loop == "") {
									final StringBuilder stringbuilder = new StringBuilder();
									final xtGraphics var_xtGraphics_198_ = this;
									var_xtGraphics_198_.asay = stringbuilder.append(var_xtGraphics_198_.asay)
											.append(" ").append(spin).toString();
								} else {
									final StringBuilder stringbuilder = new StringBuilder();
									final xtGraphics var_xtGraphics_199_ = this;
									var_xtGraphics_199_.asay = stringbuilder.append(var_xtGraphics_199_.asay)
											.append(" with ").append(spin).toString();
								}
							final StringBuilder stringbuilder = new StringBuilder();
							final xtGraphics var_xtGraphics_200_ = this;
							var_xtGraphics_200_.asay = stringbuilder.append(var_xtGraphics_200_.asay).append(" by ")
									.append(i).toString();
							if (bool_194_) {
								final StringBuilder stringbuilder_201_ = new StringBuilder();
								final xtGraphics var_xtGraphics_202_ = this;
								var_xtGraphics_202_.asay = stringbuilder_201_.append(var_xtGraphics_202_.asay)
										.append(" and beyond").toString();
							}
						}
					} else if (spin != "")
						if (loop == "") {
							final StringBuilder stringbuilder = new StringBuilder();
							final xtGraphics var_xtGraphics_203_ = this;
							var_xtGraphics_203_.asay = stringbuilder.append(var_xtGraphics_203_.asay).append(" ")
									.append(spin).toString();
						} else {
							final StringBuilder stringbuilder = new StringBuilder();
							final xtGraphics var_xtGraphics_204_ = this;
							var_xtGraphics_204_.asay = stringbuilder.append(var_xtGraphics_204_.asay).append(" by ")
									.append(spin).toString();
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
						int i_205_ = 0;
						if (mad.powerup > 20.0F)
							i_205_ = 1;
						if (mad.powerup > 40.0F)
							i_205_ = 2;
						if (mad.powerup > 150.0F)
							i_205_ = 3;
						if (mad.surfer)
							asay = new StringBuilder().append(" ").append(adj[4][(int) (m.random() * 3.0F)])
									.append(asay).toString();
						if (i_205_ != 3)
							asay = new StringBuilder().append(adj[i_205_][(int) (m.random() * 3.0F)]).append(asay)
									.append(exlm[i_205_]).toString();
						else
							asay = adj[i_205_][(int) (m.random() * 3.0F)];
						if (!wasay) {
							tcnt = auscnt;
							if (mad.power != 98.0F)
								say = new StringBuilder().append("Power Up ")
										.append((int) (100.0F * mad.powerup / 98.0F)).append("%").toString();
							else
								say = "Power To The MAX";
							if (skidup)
								skidup = false;
							else
								skidup = true;
						}
					}
				}
				if (mad.newcar) {
					if (!wasay) {
						say = "Car Fixed";
						tcnt = 0;
					}
					if (crashup)
						crashup = false;
					else
						crashup = true;
				}
				for (int i = 0; i < nplayers; i++)
					if (dested[i] != checkpoints.dested[i] && i != im) {
						dested[i] = checkpoints.dested[i];
						if (fase != 7001) {
							if (dested[i] == 1) {
								wasay = true;
								say = new StringBuilder().append("").append(cd.names[sc[i]]).append(" has been wasted!")
										.toString();
								tcnt = -15;
							}
							if (dested[i] == 2) {
								wasay = true;
								say = new StringBuilder().append("You wasted ").append(cd.names[sc[i]]).append("!")
										.toString();
								tcnt = -15;
							}
						} else {
							if (dested[i] == 1) {
								wasay = true;
								say = new StringBuilder().append("").append(plnames[i]).append(" has been wasted!")
										.toString();
								tcnt = -15;
							}
							if (dested[i] == 2) {
								wasay = true;
								if (multion < 2)
									say = new StringBuilder().append("You wasted ").append(plnames[i]).append("!")
											.toString();
								else
									say = new StringBuilder().append("").append(plnames[im]).append(" wasted ")
											.append(plnames[i]).append("!").toString();
								tcnt = -15;
							}
							if (dested[i] == 3) {
								wasay = true;
								say = new StringBuilder().append("").append(plnames[i])
										.append(" has been wasted! (Disconnected)").toString();
								tcnt = -15;
							}
						}
					}
				if (multion >= 2 && alocked != lalocked) {
					if (alocked != -1) {
						wasay = false;
						say = new StringBuilder().append("Now following ").append(plnames[alocked]).append("!")
								.toString();
						tcnt = -15;
					}
					lalocked = alocked;
					clear = mad.clear;
				}
				if (clear != mad.clear && mad.clear != 0) {
					if (!wasay) {
						say = "Checkpoint!";
						tcnt = 15;
					}
					clear = mad.clear;
					if (checkpoints.nlaps > 0 && clear % checkpoints.nsp == 0)
						chrono.performLap();
					if (!mutes)
						checkpoint.play();
					cntovn = 0;
					if (cntan != 0)
						cntan = 0;
				}
			}
		}
		if (m.lightn != -1) {
			final int i = strack.sClip.stream.available();
			m.lton = false;
			if (i <= 6380001 && i > 5368001)
				m.lton = true;
			if (i <= 2992001 && i > 1320001)
				m.lton = true;
		}
	}

	public void stopairs() {
		for (int i = 0; i < 6; i++)
			air[i].stop();
	}

	public void stopallnow() {
		if (runner != null) {
			runner.interrupt();
			runner = null;
		}
		runtyp = 0;
		if (loadedt) {
			strack.unload();
			strack = null;
			loadedt = false;
		}
		for (int i = 0; i < 5; i++)
			for (int i_19_ = 0; i_19_ < 5; i_19_++) {
				if (engs[i][i_19_] != null)
					engs[i][i_19_].stop();
				engs[i][i_19_] = null;
			}
		for (int i = 0; i < 6; i++) {
			if (air[i] != null)
				air[i].stop();
			air[i] = null;
		}
		wastd.stop();
		if (intertrack != null)
			intertrack.unload();
		intertrack = null;
	}

	public void stopchat() {
		clanchat = false;
		clangame = 0;
		if (runtyp == -101) {
			runtyp = 0;
			try {
				socket.close();
				socket = null;
				din.close();
				din = null;
				dout.close();
				dout = null;
			} catch (final Exception exception) {
				/* empty */
			}
		}
	}

	public void stoploading() {
		loading();
		app.repaint();
		runtyp = 0;
	}

	public void trackbg(final boolean bool) {
		int i = 0;
		trkl++;
		if (trkl > trklim) {
			i = 1;
			trklim = (int) (Math.random() * 40.0);
			trkl = 0;
		}
		if (bool)
			i = 0;
		for (int i_25_ = 0; i_25_ < 2; i_25_++) {
			rd.drawImage(trackbg[i], trkx[i_25_], 25, null);
			trkx[i_25_] -= 10;
			if (trkx[i_25_] <= -605)
				trkx[i_25_] = 735;
		}
		rd.setColor(new Color(0, 0, 0));
		rd.fillRect(0, 0, 65, 450);
		rd.fillRect(735, 0, 65, 450);
		rd.fillRect(65, 0, 670, 25);
		rd.fillRect(65, 425, 670, 25);
	}

	public void waitenter() {
		if (forstart < 690) {
			rd.setFont(new Font("Arial", 1, 13));
			ftm = rd.getFontMetrics();
			drawcs(70, "Waiting for all players to finish loading!", 0, 0, 0, 0);
			if (forstart <= 640)
				drawcs(90, new StringBuilder().append("").append((640 - forstart) / 32).append("").toString(), 0, 0, 0,
						0);
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

	public int xs(final int i, int i_279_) {
		if (i_279_ < 50)
			i_279_ = 50;
		return (i_279_ - m.focus_point) * (m.cx - i) / i_279_ + i;
	}

	public int ys(final int i, int i_280_) {
		if (i_280_ < 50)
			i_280_ = 50;
		return (i_280_ - m.focus_point) * (m.cy - i) / i_280_ + i;
	}
}