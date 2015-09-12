/* Lobby - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class Lobby implements Runnable {
	Graphics2D rd;
	Login lg;
	Globe gb;
	xtGraphics xt;
	CarDefine cd;
	Medium m;
	FontMetrics ftm;
	ImageObserver ob;
	GameSparker gs;
	Thread connector;
	int conon = 0;
	boolean regnow = false;
	boolean lanlogged = true;
	int fase = 0;
	int stage = 0;
	int laps = 3;
	String stagename = "";
	int nfix = 0;
	boolean notb = false;
	boolean[] pessd = {
		false, false, false, false, false, false, false, false
	};
	int[] bx = {
		0, 0, 0, 0, 0, 0, 0, 0
	};
	int[] by = {
		0, 0, 0, 0, 0, 0, 0, 0
	};
	int[] bw = {
		0, 0, 0, 0, 0, 0, 0, 0
	};
	int btn = 0;
	int pbtn = 0;
	int nflk = 0;
	int ncnt = 0;
	int rerr = 0;
	int pback = 0;
	int cflk = 0;
	int sflk = 0;
	String msg = "";
	String lmsg = "| Searching/Waiting for other LAN Players |";
	int opselect = 0;
	boolean lloaded = false;
	int npo = 0;
	String[] pnames = new String[200];
	int[] pcars = new int[200];
	String[] pcarnames = new String[200];
	String[] pclan = new String[200];
	int[] pgames = new int[200];
	float[][] pcols = new float[200][6];
	int prnpo = 0;
	String[] prnames = {
		"", "", "", "", "", "", "", ""
	};
	int[] ppos = {
		6, 6, 6, 6, 6, 6, 6, 6
	};
	int[] plap = {
		6, 6, 6, 6, 6, 6, 6, 6
	};
	int[] ppow = {
		50, 50, 50, 50, 50, 50, 50, 50
	};
	int[] pdam = {
		50, 50, 50, 50, 50, 50, 50, 50
	};
	int prevloaded = -1;
	String stuntname = "";
	String lapsname = "";
	String wastename = "";
	int ngm = 0;
	int[] gnum = new int[500];
	int[] gstgn = new int[500];
	String[] gstages = new String[500];
	int[] gnlaps = new int[500];
	int[] mnpls = new int[500];
	int[] mnbts = new int[500];
	int[] wait = new int[500];
	int[] gcrs = new int[500];
	int[] gclss = new int[500];
	int[] gfx = new int[500];
	int[] gntb = new int[500];
	String[] gplyrs = new String[500];
	int[] gwarb = new int[500];
	String[] gwarbnum = new String[500];
	int[] gameturn = new int[500];
	String[] gaclan = new String[500];
	String[] gvclan = new String[500];
	int[] gascore = new int[500];
	int[] gvscore = new int[500];
	int[] gwtyp = new int[500];
	String[] gmaker = new String[500];
	int[] npls = new int[500];
	int ongame = -1;
	int join = -1;
	int chalngd = -1;
	int im = 0;
	int longame = -1;
	int onjoin = -1;
	int ontyp = 0;
	int dispcar = -1;
	int forcar = -1;
	int addstage = 0;
	ContO dispco = null;
	boolean fstart = false;
	boolean jflexo = false;
	String chalby = "";
	int ctime = 0;
	boolean invo = false;
	String[] invos = {
		"", "", "", "", "", "", "", ""
	};
	String[] dinvi = {
		"", "", "", "", "", "", "", ""
	};
	String[] cnames = {
		"", "", "", "", "", "", ""
	};
	String[] sentn = {
		"", "", "", "", "", "", ""
	};
	int updatec = -1;
	int loadstage = 0;
	int gstage = 0;
	int gstagelaps = 0;
	int gnpls = 8;
	int gwait = 0;
	int gnbts = 0;
	int gcars;
	int gclass = 0;
	int gfix = 0;
	int gnotp = 0;
	int remstage = 0;
	int msload = 0;
	int sgflag = 0;
	String gstagename = "";
	String gplayers = "";
	boolean inwab = false;
	boolean loadwarb = false;
	int warbsel = 0;
	int cancreate = 0;
	int pgamesel = 0;
	int cntchkn = 0;
	Socket socket;
	BufferedReader din;
	PrintWriter dout;
	int spos = 0;
	int spos2 = 0;
	int spos3 = 28;
	int mscro = 125;
	int lspos = 0;
	int mscro2 = 145;
	int lspos2 = 0;
	int mscro3 = 345;
	int lspos3 = 0;
	int clicked = -1;
	int opengame = 0;
	int britchl = 0;
	boolean zeromsw = false;
	int mousonp = -1;
	int cmonp = -1;
	long ptime = 0L;
	int pcurs = 0;
	boolean grprsd = false;
	int pend = 0;
	int mrot = 0;
	boolean pendb = false;
	int[] cac = {
		-1, -1, -1, -1, -1, -1, -1, -1, -1
	};
	int[] cax = {
		0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	int[] cay = {
		0, 0, 0, 0, 0, 0, 0, 0, 0
	};
	boolean mousedout = false;
	int flks = 0;
	int waitlink = 0;
	boolean pre1 = false;
	boolean pre2 = false;
	int prereq = 0;
	int plsndt = 0;
	int lxm = 0;
	int lym = 0;

	public Lobby(Medium medium, Graphics2D graphics2d, Login login,
	Globe globe, xtGraphics var_xtGraphics, CarDefine cardefine,
	GameSparker gamesparker) {
		this.m = medium;
		this.rd = graphics2d;
		this.xt = var_xtGraphics;
		this.cd = cardefine;
		this.gs = gamesparker;
		this.lg = login;
		this.gb = globe;
		(this.gs).cmsg.setBackground(color2k(240, 240,
		240));
		(this.gs).swait.setBackground(color2k(220, 220,
		220));
		(this.gs).snpls.setBackground(color2k(220, 220,
		220));
		(this.gs).snbts.setBackground(color2k(220, 220,
		220));
		(this.gs).sgame.setBackground(color2k(200, 200,
		200));
		(this.gs).wgame.setBackground(color2k(200, 200,
		200));
		(this.gs).pgame.setBackground(color2k(200, 200,
		200));
		(this.gs).vnpls.setBackground(color2k(200, 200,
		200));
		(this.gs).vtyp.setBackground(color2k(200, 200,
		200));
		(this.gs).warb.setBackground(color2k(200, 200,
		200));
		(this.gs).snfmm.setBackground(color2k(200, 200,
		200));
		(this.gs).snfm1.setBackground(color2k(200, 200,
		200));
		(this.gs).snfm2.setBackground(color2k(200, 200,
		200));
		(this.gs).mstgs.setBackground(color2k(230, 230,
		230));
		(this.gs).slaps.setBackground(color2k(200, 200,
		200));
		(this.gs).sclass.setBackground(color2k(220, 220, 220));
		(this.gs).scars.setBackground(color2k(220, 220,
		220));
		(this.gs).sfix.setBackground(color2k(220, 220,
		220));
		(this.gs).mycar.setBackground(color2k(255, 255,
		255));
		(this.gs).notp.setBackground(color2k(255, 255,
		255));
		(this.gs).rooms.setBackground(color2k(170, 170,
		170));
		(this.gs).swait.setForeground(new Color(0, 0,
		0));
		(this.gs).snpls.setForeground(new Color(0, 0,
		0));
		(this.gs).snbts.setForeground(new Color(0, 0,
		0));
		(this.gs).sgame.setForeground(new Color(0, 0,
		0));
		(this.gs).wgame.setForeground(new Color(0, 0,
		0));
		(this.gs).pgame.setForeground(new Color(0, 0,
		0));
		(this.gs).vnpls.setForeground(new Color(0, 0,
		0));
		(this.gs).vtyp.setForeground(new Color(0, 0,
		0));
		(this.gs).warb.setForeground(new Color(0, 0,
		0));
		(this.gs).snfmm.setForeground(new Color(0, 0,
		0));
		(this.gs).snfm1.setForeground(new Color(0, 0,
		0));
		(this.gs).slaps.setForeground(new Color(0, 0,
		0));
		(this.gs).snfm2.setForeground(new Color(0, 0,
		0));
		(this.gs).mstgs.setForeground(new Color(0, 0,
		0));
		(this.gs).sclass.setForeground(new Color(0, 0,
		0));
		(this.gs).scars.setForeground(new Color(0, 0,
		0));
		(this.gs).sfix.setForeground(new Color(0, 0,
		0));
		(this.gs).mycar.setForeground(new Color(0, 0,
		0));
		(this.gs).notp.setForeground(new Color(0, 0,
		0));
		(this.gs).rooms.setForeground(new Color(0, 0,
		0));
		(this.gs).sgame.removeAll();
		(this.gs).sgame.add(this.rd,
			" NFM Multiplayer ");
		(this.gs).sgame.add(this.rd,
			" NFM 2     ");
		(this.gs).sgame.add(this.rd,
			" NFM 1     ");
		(this.gs).sgame.add(this.rd,
			" My Stages ");
		(this.gs).sgame.add(this.rd,
			" My Clan Stages ");
		(this.gs).sgame.add(this.rd,
			" Weekly Top 20 ");
		(this.gs).sgame.add(this.rd,
			" Monthly Top 20 ");
	}

	public void inishlobby() {
		(this.gs).tnick.hide();
		(this.gs).tpass.hide();
		(this.gs).temail.hide();
		hideinputs();
		(this.gs).mycar.setBackground(color2k(255, 255,
		255));
		(this.gs).mycar.setForeground(new Color(0, 0,
		0));
		(this.gs).rooms.removeAll();
		(this.gs).rooms.add(this.rd,
		new StringBuilder().append("").append((this.xt).servername).append(" :: ").append((this.xt).servport - 7070).append("").toString());
		(this.gs).rooms.select(0);
		this.gs.requestFocus();
		this.cd.loadready();
		for (int i = 0; i < 500; i++) {
			this.gnum[i] = -2;
			this.gstgn[i] = 0;
			this.gstages[i] = "";
			this.gnlaps[i] = 0;
			this.mnpls[i] = 0;
			this.mnbts[i] = 0;
			this.wait[i] = 0;
			this.gmaker[i] = "";
			this.gcrs[i] = 0;
			this.gclss[i] = 0;
			this.gfx[i] = 0;
			this.gntb[i] = 0;
			this.gplyrs[i] = "";
			this.npls[i] = 0;
			this.gwarb[i] = 0;
			this.gwarbnum[i] = "";
			this.gameturn[i] = 0;
			this.gaclan[i] = "";
			this.gvclan[i] = "";
			this.gascore[i] = 0;
			this.gvscore[i] = 0;
			this.gwtyp[i] = 0;
		}
		for (int i = 0; i < 200; i++) {
			this.pnames[i] = "";
			this.pcars[i] = 0;
			this.pcarnames[i] = "";
			this.pgames[i] = -1;
			this.pclan[i] = "";
			for (int i_0_ = 0; i_0_ < 6; i_0_++)
			this.pcols[i][i_0_] = 0.0F;
		}
		this.ongame = -1;
		this.join = -1;
		this.onjoin = -1;
		this.chalngd = -1;
		this.dispcar = -1;
		this.forcar = -1;
		this.chalby = "";
		this.im = 0;
		this.fstart = false;
		this.updatec = -1;
		this.prevloaded = -1;
		this.spos = 0;
		this.spos2 = 0;
		this.spos3 = 0;
		this.ngm = 0;
		this.npo = 0;
		this.fase = 1;
		this.lloaded = false;
		(this.lg).gamec = -1;
		try {
			this.socket = new Socket((this.xt).server, (this.xt).servport);
			this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.dout = new PrintWriter(this.socket.getOutputStream(),
			true);
		} catch (Exception exception) {
			/* empty */
		}
		this.conon = 1;
		this.connector = new Thread(this);
		this.connector.start();
	}

	public void run() {
		int i = -1;
		while (this.conon == 1) {
			Date date = new Date();
			long l = date.getTime();
			if (!this.lloaded)
			this.gs.setCursor(new Cursor(3));
			if (!(this.xt).logged && !(this.xt).lan && ((this.xt).nfreeplays - (this.xt).ndisco) >= 5) {
				if (this.join >= 0) {
					this.join = -1;
					this.regnow = true;
				}
				if (this.pgames[this.im] != -1) {
					this.join = -2;
					this.regnow = true;
				}
			}
			if ((this.join >= 0 || this.pgames[this.im] != -1) && !this.regnow) {
				int i_1_ = -1;
				for (int i_2_ = 0; i_2_ < this.ngm; i_2_++) {
					if (this.join == this.gnum[i_2_] || (this.pgames[this.im] == this.gnum[i_2_])) i_1_ = i_2_;
				}
				if (i_1_ != -1) {
					boolean bool = false;
					this.ontyp = 0;
					if (this.gcrs[i_1_] == 1 && this.pcars[this.im] < 16) {
						bool = true;
						this.ontyp = 10;
						if (this.gclss[i_1_] > 0 && this.gclss[i_1_] <= 5)
						this.ontyp += this.gclss[i_1_];
					}
					if (this.gcrs[i_1_] == 2 && this.pcars[this.im] >= 16) {
						bool = true;
						this.ontyp = 20;
						if (this.gclss[i_1_] > 0 && this.gclss[i_1_] <= 5)
						this.ontyp += this.gclss[i_1_];
					}
					if (this.gcrs[i_1_] == 1 && this.gwarb[i_1_] != 0 && (this.xt).sc[0] != 36) {
						bool = true;
						this.ontyp = 30;
						if (this.gclss[i_1_] > 0 && this.gclss[i_1_] <= 5)
						this.ontyp += this.gclss[i_1_];
					}
					if (this.gclss[i_1_] > 0 && this.gclss[i_1_] <= 5 && Math.abs(((this.cd).cclass[this.pcars[this.im]]) - (this.gclss[i_1_] - 1)) > 1) {
						bool = true;
						if (this.gcrs[i_1_] == 1) {
							if (this.gwarb[i_1_] == 0)
							this.ontyp = 10;
							else this.ontyp = 30;
						}
						if (this.gcrs[i_1_] == 2)
						this.ontyp = 20;
						this.ontyp += this.gclss[i_1_];
					}
					if (this.gclss[i_1_] <= -2 && (this.pcars[this.im] != Math.abs(this.gclss[i_1_] + 2))) {
						bool = true;
						this.ontyp = this.gclss[i_1_];
					}
					if (this.gstgn[i_1_] == -2 && !(this.xt).logged) {
						bool = true;
						this.ontyp = 76;
					}
					if (bool) {
						this.onjoin = this.gnum[i_1_];
						this.jflexo = false;
						if (this.join >= 0)
						this.join = -1;
						if (this.pgames[this.im] != -1)
						this.join = -2;
					}
				}
			}
			if ((this.xt).onjoin != -1) {
				this.join = (this.xt).onjoin;
				this.ongame = (this.xt).onjoin;
				(this.xt).onjoin = -1;
			}
			if (this.updatec < -17)
			this.updatec = -17;
			boolean bool = false;
			if (this.lloaded) {
				i = this.pgames[this.im];
				if (i != -1) {
					for (int i_3_ = 0; i_3_ < this.ngm; i_3_++) {
						if (i == this.gnum[i_3_]) {
							this.laps = this.gnlaps[i_3_];
							this.stage = this.gstgn[i_3_];
							this.stagename = this.gstages[i_3_];
							this.nfix = this.gfx[i_3_];
							if (this.gntb[i_3_] == 1)
							this.notb = true;
							else this.notb = false;
						}
					}
				}
			}
			String string = new StringBuilder().append("").append((this.xt).sc[0]).append("").toString();
			if ((this.xt).sc[0] >= 16) string = new StringBuilder().append("C").append((this.cd).names[(this.xt).sc[0]])
				.append("").toString();
			String string_4_ = new StringBuilder().append("1|").append((this.xt).nickname).append(":").append((this.xt).nickey).append("|").append((this.xt).clan).append("|").append((this.xt).clankey).append("|").append(string).append("|").append(this.join).append("|").append((int)((this.xt).arnp[0] * 100.0F))
				.append("|").append((int)((this.xt).arnp[1] * 100.0F))
				.append("|").append((int)((this.xt).arnp[2] * 100.0F))
				.append("|").append((int)((this.xt).arnp[3] * 100.0F))
				.append("|").append((int)((this.xt).arnp[4] * 100.0F))
				.append("|").append((int)((this.xt).arnp[5] * 100.0F))
				.append("|").append(this.ongame).append("|").toString();
			if (!(this.xt).lan) {
				string_4_ = new StringBuilder().append(string_4_).append("").append(this.updatec).append("|").toString();
				if (this.updatec <= -11) {
					for (int i_5_ = 0; i_5_ < -this.updatec - 10;
					i_5_++)
					string_4_ = new StringBuilder().append(string_4_).append("").append(this.cnames[6 - i_5_]).append("|").append(this.sentn[6 - i_5_]).append("|").toString();
					this.updatec = -2;
				}
			} else {
				String string_6_ = "Nonex";
				try {
					string_6_ = InetAddress.getLocalHost().getHostName();
					if (string_6_.indexOf("|") != -1) string_6_ = InetAddress.getLocalHost().getHostAddress();
				} catch (Exception exception) {
					string_6_ = "Nonex";
				}
				int i_7_ = 0;
				if ((this.xt).logged) i_7_ = 1;
				string_4_ = new StringBuilder().append(string_4_).append("").append(string_6_).append("|").append(i_7_).append("|").toString();
			}
			if (this.fstart) {
				string_4_ = new StringBuilder().append(string_4_).append("3|").toString();
				bool = true;
			}
			if (this.chalngd == -5 && !this.fstart) {
				string_4_ = new StringBuilder().append(string_4_).append("11|")
					.append(this.gstage).append("|").append(this.gstagename).append("|").append(this.gstagelaps).append("|").append(this.gnpls).append("|").append(this.gwait).append("|").append(this.pnames[this.im]).append("|").append(this.gcars).append("|").append(this.gclass).append("|").append(this.gfix).append("|").append(this.gnotp).append("|").append(this.gplayers).append("|").toString();
				if ((this.xt).lan) string_4_ = new StringBuilder().append(string_4_).append("").append(this.gnbts).append("|").toString();
			}
			if (this.ongame != -1 && this.chalngd != -5 && !this.fstart) {
				boolean bool_8_ = false;
				for (int i_9_ = 0; i_9_ < 7; i_9_++) {
					if (!this.invos[i_9_].equals("") && !this.dinvi[i_9_].equals(this.invos[i_9_])) {
						if (!bool_8_) {
							string_4_ = new StringBuilder().append(string_4_).append("2|").append(this.ongame).append("|").toString();
							bool_8_ = true;
						}
						string_4_ = new StringBuilder().append(string_4_).append("").append(this.invos[i_9_]).append("|").toString();
						this.dinvi[i_9_] = this.invos[i_9_];
					}
				}
			}
			String string_10_ = "";
			boolean bool_11_ = false;
			try {
				this.dout.println(string_4_);
				string_10_ = this.din.readLine();
				if (string_10_ == null) bool_11_ = true;
			} catch (Exception exception) {
				bool_11_ = true;
			}
			if (bool_11_) {
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
					this.socket = new Socket((this.xt).server, ((this.xt)
						.servport));
					this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
					this.dout = new PrintWriter(this.socket.getOutputStream(),
					true);
					this.dout.println(string_4_);
					string_10_ = this.din.readLine();
					if (string_10_ != null) bool_11_ = false;
				} catch (Exception exception) {
					/* empty */
				}
			}
			if (bool_11_) {
				try {
					this.socket.close();
					this.socket = null;
				} catch (Exception exception) {
					/* empty */
				}
				this.conon = 0;
				this.lg.exitfromlobby();
				hideinputs();
				this.connector.stop();
			}
			if (this.regnow && this.join == -2)
			this.join = -1;
			this.npo = getvalue(string_10_, 0);
			if (this.npo < 0)
			this.npo = 0;
			this.im = getvalue(string_10_, 1);
			if (this.im < 0)
			this.im = 0;
			for (int i_12_ = 0; i_12_ < this.npo; i_12_++) {
				this.pnames[i_12_] = getSvalue(string_10_, 2 + i_12_ * 10);
				if (this.pnames[i_12_].equals(""))
				this.pnames[i_12_] = "Unknown";
				String string_13_ = getSvalue(string_10_, 3 + i_12_ * 10);
				if (string_13_.startsWith("C")) {
					this.pcarnames[i_12_] = string_13_.substring(1);
					if (!this.pcarnames[i_12_].equals("")) {
						int i_14_ = 0;
						for (int i_15_ = 16; i_15_ < 56; i_15_++) {
							if (this.pcarnames[i_12_].equals((this.cd).names[i_15_])) {
								i_14_ = i_15_;
								break;
							}
						}
						if (i_14_ == 0) {
							this.pcars[i_12_] = -1;
							boolean bool_16_ = false;
							for (int i_17_ = 0;
							i_17_ < (this.cd).nl;
							i_17_++) {
								if (this.pcarnames[i_12_].equals((this.cd).loadnames[i_17_])) bool_16_ = true;
							}
							if (!bool_16_ && (this.cd).nl < 20 && (this.cd).nl >= 0) {
								(this.cd).loadnames[(this.cd).nl] = this.pcarnames[i_12_];
								(this.cd).nl++;
							}
							this.cd.sparkcarloader();
						} else this.pcars[i_12_] = i_14_;
					} else {
						this.pcars[i_12_] = 0;
						this.pcarnames[i_12_] = ((this.cd).names[this.pcars[i_12_]]);
					}
				} else {
					this.pcars[i_12_] = getvalue(string_10_, 3 + i_12_ * 10);
					if (this.pcars[i_12_] == -1)
					this.pcars[i_12_] = 0;
					this.pcarnames[i_12_] = ((this.cd).names[this.pcars[i_12_]]);
				}
				this.pclan[i_12_] = getSvalue(string_10_, 4 + i_12_ * 10);
				this.pgames[i_12_] = getvalue(string_10_, 5 + i_12_ * 10);
				this.pcols[i_12_][0] = (float) getvalue(string_10_, 6 + i_12_ * 10) / 100.0F;
				if (this.pcols[i_12_][0] == -1.0F)
				this.pcols[i_12_][0] = 0.0F;
				this.pcols[i_12_][1] = (float) getvalue(string_10_, 7 + i_12_ * 10) / 100.0F;
				if (this.pcols[i_12_][1] == -1.0F)
				this.pcols[i_12_][1] = 0.0F;
				this.pcols[i_12_][2] = (float) getvalue(string_10_, 8 + i_12_ * 10) / 100.0F;
				if (this.pcols[i_12_][2] == -1.0F)
				this.pcols[i_12_][2] = 0.0F;
				this.pcols[i_12_][3] = (float) getvalue(string_10_, 9 + i_12_ * 10) / 100.0F;
				if (this.pcols[i_12_][3] == -1.0F)
				this.pcols[i_12_][3] = 0.0F;
				this.pcols[i_12_][4] = (float) getvalue(string_10_, 10 + i_12_ * 10) / 100.0F;
				if (this.pcols[i_12_][4] == -1.0F)
				this.pcols[i_12_][4] = 0.0F;
				this.pcols[i_12_][5] = (float) getvalue(string_10_, 11 + i_12_ * 10) / 100.0F;
				if (this.pcols[i_12_][5] == -1.0F)
				this.pcols[i_12_][5] = 0.0F;
			}
			int i_18_ = 12 + (this.npo - 1) * 10;
			this.ngm = getvalue(string_10_, i_18_);
			if (this.ngm < 0)
			this.ngm = 0;
			int i_19_ = 12;
			if ((this.xt).lan) i_19_ = 13;
			for (int i_20_ = 0; i_20_ < this.ngm; i_20_++) {
				this.gnum[i_20_] = getvalue(string_10_, i_18_ + 1 + i_20_ * i_19_);
				this.gstgn[i_20_] = getvalue(string_10_, i_18_ + 2 + i_20_ * i_19_);
				this.gstgn[i_20_] = Math.abs(this.gstgn[i_20_]);
				if (this.gstgn[i_20_] > 100)
				this.gstgn[i_20_] = -2;
				this.gstages[i_20_] = getSvalue(string_10_, i_18_ + 3 + i_20_ * i_19_);
				this.gnlaps[i_20_] = getvalue(string_10_, i_18_ + 4 + i_20_ * i_19_);
				this.mnpls[i_20_] = getvalue(string_10_, i_18_ + 5 + i_20_ * i_19_);
				this.wait[i_20_] = getvalue(string_10_, i_18_ + 6 + i_20_ * i_19_);
				this.gmaker[i_20_] = getSvalue(string_10_, i_18_ + 7 + i_20_ * i_19_);
				this.gcrs[i_20_] = getvalue(string_10_, i_18_ + 8 + i_20_ * i_19_);
				this.gclss[i_20_] = getvalue(string_10_, i_18_ + 9 + i_20_ * i_19_);
				this.gfx[i_20_] = getvalue(string_10_, i_18_ + 10 + i_20_ * i_19_);
				this.gntb[i_20_] = getvalue(string_10_, i_18_ + 11 + i_20_ * i_19_);
				this.gplyrs[i_20_] = getSvalue(string_10_, i_18_ + 12 + i_20_ * i_19_);
				if (this.gplyrs[i_20_].startsWith("#warb#")) {
					this.gwarb[i_20_] = getHvalue(this.gplyrs[i_20_], 2);
					this.gwarbnum[i_20_] = getHSvalue(this.gplyrs[i_20_], 3);
					this.gameturn[i_20_] = getHvalue(this.gplyrs[i_20_], 4);
					this.gaclan[i_20_] = getHSvalue(this.gplyrs[i_20_], 5);
					this.gvclan[i_20_] = getHSvalue(this.gplyrs[i_20_], 6);
					this.gascore[i_20_] = getHvalue(this.gplyrs[i_20_], 7);
					this.gvscore[i_20_] = getHvalue(this.gplyrs[i_20_], 8);
					this.gwtyp[i_20_] = getHvalue(this.gplyrs[i_20_], 9);
					if (this.gwtyp[i_20_] < 1 || this.gwtyp[i_20_] > 5)
					this.gwtyp[i_20_] = 1;
					this.gplyrs[i_20_] = "";
				} else {
					this.gwarb[i_20_] = 0;
					this.gwarbnum[i_20_] = "";
					this.gameturn[i_20_] = 0;
					this.gaclan[i_20_] = "";
					this.gvclan[i_20_] = "";
					this.gascore[i_20_] = 0;
					this.gvscore[i_20_] = 0;
					this.gwtyp[i_20_] = 0;
				}
				if ((this.xt).lan)
				this.mnbts[i_20_] = getvalue(string_10_, i_18_ + 13 + i_20_ * i_19_);
				if ((this.xt).playingame > -1 && ((this.xt).playingame == this.gnum[i_20_]) && !(this.xt).lan)
				this.ongame = this.gnum[i_20_];
				if (i == this.gnum[i_20_] && this.wait[i_20_] == 0 && this.lloaded && i != -1) {
					for (int i_21_ = 0; i_21_ < this.npo; i_21_++) {
						if ((this.pgames[i_21_] == this.gnum[i_20_]) && (this.pnames[i_21_].equals((this.xt).nickname))) {
							this.im = i_21_;
							break;
						}
					}
					this.conon = 2;
					this.gs.setCursor(new Cursor(3));
				}
			}
			for (int i_22_ = 0; i_22_ < this.ngm; i_22_++) {
				this.npls[i_22_] = 0;
				for (int i_23_ = 0; i_23_ < this.npo; i_23_++) {
					if (this.pgames[i_23_] == this.gnum[i_22_])
					this.npls[i_22_]++;
				}
			}
			if (this.conon != 0 && (this.xt).playingame != -1)
			(this.xt).playingame = -1;
			if (this.ongame != -1) {
				boolean bool_24_ = false;
				for (int i_25_ = 0; i_25_ < this.ngm; i_25_++) {
					if (this.ongame == this.gnum[i_25_]) bool_24_ = true;
				}
				if (!bool_24_)
				this.britchl = -1;
			}
			if (this.join > -1) {
				boolean bool_26_ = false;
				for (int i_27_ = 0; i_27_ < this.ngm; i_27_++) {
					if (this.join == this.gnum[i_27_]) bool_26_ = true;
				}
				if (!bool_26_)
				this.join = -1;
			}
			for (int i_28_ = 0; i_28_ < this.npo; i_28_++) {
				if (this.pgames[i_28_] != -1) {
					boolean bool_29_ = false;
					for (int i_30_ = 0; i_30_ < this.ngm; i_30_++) {
						if (this.pgames[i_28_] == this.gnum[i_30_]) bool_29_ = true;
					}
					if (!bool_29_)
					this.pgames[i_28_] = -1;
				}
			}
			if ((this.xt).lan) i_18_ += 14 + (this.ngm - 1) * 13;
			else i_18_ += 13 + (this.ngm - 1) * 12;
			if (!(this.xt).lan) {
				int i_31_ = getvalue(string_10_, i_18_);
				int i_32_ = getvalue(string_10_, i_18_ + 1);
				i_18_ += 2;
				if (this.updatec != i_31_ && this.updatec >= -2 && i_32_ == this.ongame) {
					for (int i_33_ = 0; i_33_ < 7; i_33_++) {
						this.cnames[i_33_] = getSvalue(string_10_, i_18_ + i_33_ * 2);
						this.sentn[i_33_] = getSvalue(string_10_, i_18_ + 1 + i_33_ * 2);
					}
					this.updatec = i_31_;
					if (this.ongame == -1)
					this.spos3 = 28;
					i_18_ += 14;
				}
				if (this.ongame != -1) {
					if (this.prevloaded != -1)
					this.prevloaded = -1;
					boolean bool_34_ = false;
					for (int i_35_ = 0; i_35_ < this.ngm; i_35_++) {
						if (this.ongame == this.gnum[i_35_] && this.wait[i_35_] <= 0) bool_34_ = true;
					}
					if (bool_34_) {
						this.prevloaded = getvalue(string_10_, i_18_);
						i_18_++;
						if (this.prevloaded == 1) {
							this.prnpo = getvalue(string_10_, i_18_);
							i_18_++;
							for (int i_36_ = 0; i_36_ < this.prnpo;
							i_36_++) {
								this.prnames[i_36_] = getSvalue(string_10_, i_18_);
								i_18_++;
							}
							for (int i_37_ = 0; i_37_ < this.prnpo;
							i_37_++) {
								this.ppos[i_37_] = getvalue(string_10_, i_18_);
								i_18_++;
							}
							for (int i_38_ = 0; i_38_ < this.prnpo;
							i_38_++) {
								this.plap[i_38_] = getvalue(string_10_, i_18_);
								i_18_++;
							}
							for (int i_39_ = 0; i_39_ < this.prnpo;
							i_39_++) {
								this.ppow[i_39_] = (int)((float) getvalue(string_10_,
								i_18_) / 9800.0F * 55.0F);
								i_18_++;
							}
							for (int i_40_ = 0; i_40_ < this.prnpo;
							i_40_++) {
								int i_41_ = getvalue(string_10_, i_18_);
								if (i_41_ != -17)
								this.pdam[i_40_] = (int)((float) i_41_ / 100.0F * 55.0F);
								else this.pdam[i_40_] = -17;
								i_18_++;
							}
							this.stuntname = getSvalue(string_10_, i_18_);
							i_18_++;
							this.lapsname = getSvalue(string_10_, i_18_);
							i_18_++;
							this.wastename = getSvalue(string_10_, i_18_);
							i_18_++;
						}
					}
				}
			} else {
				int i_42_ = getvalue(string_10_, i_18_);
				if (i_42_ == 1)
				this.lanlogged = true;
				else this.lanlogged = true;
				i_18_++;
			}
			int i_43_ = getvalue(string_10_, i_18_);
			if (i_43_ != -1) {
				int i_44_ = 0;
				for (int i_45_ = 0; i_45_ < this.ngm; i_45_++) {
					if (i_43_ == this.gnum[i_45_]) i_44_ = i_45_;
				}
				boolean bool_46_ = false;
				if (this.gwarb[i_44_] != 0) {
					if ((this.xt).clan.toLowerCase()
						.equals(this.gaclan[i_44_].toLowerCase()) || ((this.xt).clan.toLowerCase().equals(this.gvclan[i_44_].toLowerCase()))) bool_46_ = true;
				} else bool_46_ = true;
				if (((this.pgames[this.im] != this.ongame) || this.ongame == -1) && i_43_ != this.ongame && this.chalngd == -1 && this.join == -1 && this.fase == 1 && this.wait[i_44_] > 0 && bool_46_) {
					this.chalngd = i_43_;
					this.chalby = getSvalue(string_10_, i_18_ + 1);
					this.cflk = 20;
					this.ctime = 20;
					this.ptime = 0L;
					this.longame = this.ongame;
					if (((this.gs).rooms).open)
					((this.gs).rooms).open = false;
					if (this.ongame != -1)
					this.britchl = -1;
				}
				i_18_++;
			}
			if (!(this.xt).lan) {
				int i_47_ = 1;
				for (int i_48_ = 1; i_48_ < 6; i_48_++) {
					if (i_48_ != (this.xt).servport - 7070) {
						int i_49_ = getvalue(string_10_, i_18_ + i_48_);
						if (i_49_ != -1) {
							((this.gs).rooms)
								.sopts[i_47_] = new StringBuilder().append("Room ").append(i_48_).append("  ::  ").append(i_49_).append("").toString();
							((this.gs).rooms)
								.opts[i_47_] = "";
							((this.gs).rooms)
								.iroom[i_47_] = i_48_;
							i_47_++;
						}
					}
				}
				for (int i_50_ = 0;
				i_50_ < (this.lg).nservers; i_50_++) {
					if (!((this.xt).server.equals((this.lg).servers[i_50_])) && ((this.xt).delays[i_50_] < 300)) {
						((this.gs).rooms)
							.sopts[i_47_] = new StringBuilder().append(":: ").append((this.lg).snames[i_50_])
							.append("").toString();
						((this.gs).rooms)
							.opts[i_47_] = "";
						((this.gs).rooms)
							.iroom[i_47_] = 1000 + i_50_;
						i_47_++;
					}
				}
				((this.gs).rooms).no = i_47_;
			}
			if (this.join > -1) {
				boolean bool_51_ = false;
				for (int i_52_ = 0; i_52_ < this.ngm; i_52_++) {
					if (this.join == this.gnum[i_52_] && this.wait[i_52_] == 0) bool_51_ = true;
				}
				if ((this.pgames[this.im] == this.join) || bool_51_) {
					this.join = -1;
					this.nflk = 3;
				}
			}
			if (this.join == -2) {
				boolean bool_53_ = false;
				for (int i_54_ = 0; i_54_ < this.ngm; i_54_++) {
					if ((this.pgames[this.im] == this.gnum[i_54_]) && this.wait[i_54_] == 0) bool_53_ = true;
				}
				if (this.pgames[this.im] == -1 || bool_53_) {
					this.join = -1;
					if (!bool_53_)
					this.ongame = -1;
				}
			}
			if (this.chalngd == -5 && this.pgames[this.im] != -1) {
				this.ongame = this.pgames[this.im];
				this.chalngd = -1;
				if (!(this.xt).lan && this.gplayers.equals(""))
				this.lg.gamealert();
			}
			if (this.fstart && bool)
			this.fstart = false;
			this.rerr = 0;
			if (!this.lloaded) {
				this.gs.setCursor(new Cursor(0));
				this.lloaded = true;
			}
			if (!(this.gb).domon) {
				this.gb.roomlogos(this.pnames, this.npo);
				if (this.ongame == -1) {
					if (this.cntchkn == 5)
					this.lg.checkgamealerts();
				} else if ((this.lg).gamec != -1)
				(this.lg).gamec = -1;
				if (this.cntchkn == 5) {
					this.lg.checknotifcations();
					this.cntchkn = 0;
				} else this.cntchkn++;
			} else if ((this.lg).gamec != -1)
			(this.lg).gamec = -1;
			date = new Date();
			long l_55_ = date.getTime();
			int i_56_ = 700 - (int)(l_55_ - l);
			if (i_56_ < 50) i_56_ = 50;
			try {
				if (this.connector != null) {
					/* empty */
				}
				Thread.sleep((long) i_56_);
			} catch (InterruptedException interruptedexception) {
				/* empty */
			}
		}
		if (this.conon == 2) {
			int i_57_ = 20;
			(this.xt).playingame = -1;
			while (i_57_ != 0) {
				String string = new StringBuilder().append("2|").append(i).append("|").toString();
				String string_58_ = "";
				boolean bool = false;
				try {
					this.dout.println(string);
					string_58_ = this.din.readLine();
					if (string_58_ == null) bool = true;
				} catch (Exception exception) {
					bool = true;
				}
				if (bool) {
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
						this.socket = new Socket(((this.xt)
							.server), ((this.xt)
							.servport));
						this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
						this.dout = new PrintWriter(this.socket.getOutputStream(),
						true);
						this.dout.println(string);
						string_58_ = this.din.readLine();
						if (string_58_ != null) bool = false;
					} catch (Exception exception) {
						/* empty */
					}
				}
				if (bool) {
					try {
						this.socket.close();
						this.socket = null;
					} catch (Exception exception) {
						/* empty */
					}
					this.conon = 0;
					this.lg.exitfromlobby();
					hideinputs();
					this.connector.stop();
				}
				if (!(this.xt).lan)
				(this.xt).gameport = getvalue(string_58_, 0);
				else {
					(this.xt).gameport = -1;
					(this.xt).localserver = getSevervalue(string_58_, 0);
					if (!(this.xt).localserver.equals(""))
					(this.xt).gameport = 0;
				}
				if ((this.xt).gameport != -1) {
					int i_59_ = 0;
					(this.xt).im = -1;
					(this.xt).nplayers = getvalue(string_58_, 1);
					if ((this.xt).nplayers < 1)
					(this.xt).nplayers = 1;
					if ((this.xt).nplayers > 8)
					(this.xt).nplayers = 8;
					for (int i_60_ = 0;
					i_60_ < (this.xt).nplayers;
					i_60_++) {
						(this.xt).plnames[i_60_] = getSvalue(string_58_, 2 + i_60_);
						if ((this.xt).nickname.equals((this.xt).plnames[i_60_]))
						(this.xt).im = i_60_;
					}
					int i_61_ = 2 + (this.xt).nplayers;
					for (int i_62_ = 0;
					i_62_ < (this.xt).nplayers;
					i_62_++) {
						String string_63_ = getSvalue(string_58_, i_61_ + i_62_);
						if (string_63_.startsWith("C")) {
							string_63_ = string_63_.substring(1);
							if (!string_63_.equals("")) {
								int i_64_ = 0;
								for (int i_65_ = 16; i_65_ < 56; i_65_++) {
									if (string_63_.equals((
									this.cd)
										.names[i_65_])) {
										i_64_ = i_65_;
										break;
									}
								}
								for (/**/ ; i_64_ == 0 && i_59_ < 100;
								i_59_++) {
									boolean bool_66_ = false;
									for (int i_67_ = 0;
									(i_67_ < ((this.cd)
										.nl));
									i_67_++) {
										if (string_63_.equals((
										(this
											.cd))
											.loadnames[i_67_])) bool_66_ = true;
									}
									if (!bool_66_ && ((this.cd).nl < 20)) {
										(this.cd)
											.loadnames[((this.cd)
											.nl)] = string_63_;
										(this.cd).nl++;
									}
									this.cd.sparkcarloader();
									try {
										if (this.connector != null) {
											/* empty */
										}
										Thread.sleep(100L);
									} catch (InterruptedException interruptedexception) {
										/* empty */
									}
									for (int i_68_ = 16; i_68_ < 56; i_68_++) {
										if (string_63_.equals((
										(this
											.cd))
											.names[i_68_])) i_64_ = i_68_;
									}
								}
								if (i_64_ != 0) {
									(this.xt).sc[i_62_] = i_64_;
									for (int i_69_ = 0;
									i_69_ < this.npo; i_69_++) {
										if (this.pcarnames[i_69_].equals(string_63_))
										this.pcars[i_69_] = i_64_;
									}
								} else(this.xt).im = -1;
							} else(this.xt).im = -1;
						} else {
							(this.xt).sc[i_62_] = getvalue(string_58_, i_61_ + i_62_);
							if ((this.xt).sc[i_62_] == -1)
							(this.xt).im = -1;
						}
					}
					i_61_ += (this.xt).nplayers;
					for (int i_70_ = 0;
					i_70_ < (this.xt).nplayers;
					i_70_++)
					(this.xt).xstart[i_70_] = getvalue(string_58_, i_61_ + i_70_);
					i_61_ += (this.xt).nplayers;
					for (int i_71_ = 0;
					i_71_ < (this.xt).nplayers;
					i_71_++)
					(this.xt).zstart[i_71_] = getvalue(string_58_, i_61_ + i_71_);
					i_61_ += (this.xt).nplayers;
					for (int i_72_ = 0;
					i_72_ < (this.xt).nplayers;
					i_72_++) {
						for (int i_73_ = 0; i_73_ < 6; i_73_++)
						(this.xt).allrnp[i_72_]
						[i_73_] = ((float) getvalue(string_58_,
						i_61_ + i_72_ * 6 + i_73_) / 100.0F);
					}
					if ((this.xt).im != -1) {
						(this.xt).playingame = i;
						int i_74_ = 0;
						for (int i_75_ = 0; i_75_ < this.ngm;
						i_75_++) {
							if (i == this.gnum[i_75_]) i_74_ = i_75_;
						}
						if (this.gwarb[i_74_] != 0) {
							(this.xt).clangame = this.gwtyp[i_74_];
							(this.xt).clanchat = true;
							(this.xt).gaclan = this.gaclan[i_74_];
							for (int i_76_ = 0;
							(i_76_ < (this.xt).nplayers);
							i_76_++) {
								for (int i_77_ = 0; i_77_ < this.npo;
								i_77_++) {
									if (((this.xt)
										.plnames[i_76_].equals(this.pnames[i_77_])) && this.pgames[i_77_] == i)
									(this.xt)
										.pclan[i_76_] = this.pclan[i_77_];
								}
							}
						} else(this.xt).clangame = 0;
					} else {
						(this.xt).playingame = -1;
						(this.xt).im = 0;
					}
					i_57_ = 0;
				} else i_57_--;
				try {
					if (this.connector != null) {
						/* empty */
					}
					Thread.sleep(1000L);
				} catch (InterruptedException interruptedexception) {
					/* empty */
				}
			}
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
			if ((this.xt).playingame != -1) {
				if (!(this.xt).lan && !(this.xt).logged) {
					(this.xt).nfreeplays++;
					try {
						this.socket = new Socket(((this.lg).servers[0]),
						7061);
						this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
						this.dout = new PrintWriter(this.socket.getOutputStream(),
						true);
						this.dout.println(new StringBuilder().append("7|").append((
						this.xt)
							.nfreeplays)
							.append("|").toString());
						String string = this.din.readLine();
						(this.xt).hours = getvalue(string, 0);
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
				hideinputs();
				(this.xt).multion = 1;
				this.fase = 76;
				System.gc();
			} else inishlobby();
		}
		if (this.conon == 3) {
			int i_78_ = 20;
			(this.xt).playingame = -1;
			while (i_78_ != 0) {
				String string = new StringBuilder().append("4|").append(this.ongame).append("|").toString();
				String string_79_ = "";
				boolean bool = false;
				try {
					this.dout.println(string);
					string_79_ = this.din.readLine();
					if (string_79_ == null) bool = true;
				} catch (Exception exception) {
					bool = true;
				}
				if (bool) {
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
						this.socket = new Socket(((this.xt)
							.server), ((this.xt)
							.servport));
						this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
						this.dout = new PrintWriter(this.socket.getOutputStream(),
						true);
						this.dout.println(string);
						string_79_ = this.din.readLine();
						if (string_79_ != null) bool = false;
					} catch (Exception exception) {
						/* empty */
					}
				}
				if (bool) {
					try {
						this.socket.close();
						this.socket = null;
					} catch (Exception exception) {
						/* empty */
					}
					this.conon = 0;
					this.lg.exitfromlobby();
					hideinputs();
					this.connector.stop();
				}
				if (!(this.xt).lan)
				(this.xt).gameport = getvalue(string_79_, 0);
				else {
					(this.xt).gameport = -1;
					(this.xt).localserver = getSevervalue(string_79_, 0);
					if (!(this.xt).localserver.equals(""))
					(this.xt).gameport = 0;
				}
				if ((this.xt).gameport != -1) {
					int i_80_ = 0;
					(this.xt).nplayers = getvalue(string_79_, 1);
					if ((this.xt).nplayers < 1)
					(this.xt).nplayers = 1;
					if ((this.xt).nplayers > 8)
					(this.xt).nplayers = 8;
					(this.xt).im = (getvalue(string_79_, 2) + (this.xt).nplayers);
					for (int i_81_ = 0;
					i_81_ < (this.xt).nplayers;
					i_81_++)
					(this.xt).plnames[i_81_] = getSvalue(string_79_, 3 + i_81_);
					int i_82_ = 3 + (this.xt).nplayers;
					for (int i_83_ = 0;
					i_83_ < (this.xt).nplayers;
					i_83_++) {
						String string_84_ = getSvalue(string_79_, i_82_ + i_83_);
						if (string_84_.startsWith("C")) {
							string_84_ = string_84_.substring(1);
							if (!string_84_.equals("")) {
								int i_85_ = 0;
								for (int i_86_ = 16; i_86_ < 56; i_86_++) {
									if (string_84_.equals((
									this.cd)
										.names[i_86_])) {
										i_85_ = i_86_;
										break;
									}
								}
								for (/**/ ; i_85_ == 0 && i_80_ < 100;
								i_80_++) {
									boolean bool_87_ = false;
									for (int i_88_ = 0;
									(i_88_ < ((this.cd)
										.nl));
									i_88_++) {
										if (string_84_.equals((
										(this
											.cd))
											.loadnames[i_88_])) bool_87_ = true;
									}
									if (!bool_87_ && ((this.cd).nl < 20)) {
										(this.cd)
											.loadnames[((this.cd)
											.nl)] = string_84_;
										(this.cd).nl++;
									}
									this.cd.sparkcarloader();
									try {
										if (this.connector != null) {
											/* empty */
										}
										Thread.sleep(100L);
									} catch (InterruptedException interruptedexception) {
										/* empty */
									}
									for (int i_89_ = 16; i_89_ < 56; i_89_++) {
										if (string_84_.equals((
										(this
											.cd))
											.names[i_89_])) i_85_ = i_89_;
									}
								}
								if (i_85_ != 0) {
									(this.xt).sc[i_83_] = i_85_;
									for (int i_90_ = 0;
									i_90_ < this.npo; i_90_++) {
										if (this.pcarnames[i_90_].equals(string_84_))
										this.pcars[i_90_] = i_85_;
									}
								} else(this.xt).im = -1;
							} else(this.xt).im = -1;
						} else {
							(this.xt).sc[i_83_] = getvalue(string_79_, i_82_ + i_83_);
							if ((this.xt).sc[i_83_] == -1)
							(this.xt).im = -1;
						}
					}
					i_82_ += (this.xt).nplayers;
					for (int i_91_ = 0;
					i_91_ < (this.xt).nplayers;
					i_91_++)
					(this.xt).xstart[i_91_] = getvalue(string_79_, i_82_ + i_91_);
					i_82_ += (this.xt).nplayers;
					for (int i_92_ = 0;
					i_92_ < (this.xt).nplayers;
					i_92_++)
					(this.xt).zstart[i_92_] = getvalue(string_79_, i_82_ + i_92_);
					i_82_ += (this.xt).nplayers;
					for (int i_93_ = 0;
					i_93_ < (this.xt).nplayers;
					i_93_++) {
						for (int i_94_ = 0; i_94_ < 6; i_94_++)
						(this.xt).allrnp[i_93_]
						[i_94_] = ((float) getvalue(string_79_,
						i_82_ + i_93_ * 6 + i_94_) / 100.0F);
					}
					if (((this.xt).im >= (this.xt).nplayers) && ((this.xt).im < (this.xt).nplayers + 3)) {
						(this.xt).playingame = this.ongame;
						int i_95_ = 0;
						for (int i_96_ = 0; i_96_ < this.ngm;
						i_96_++) {
							if (this.ongame == this.gnum[i_96_]) i_95_ = i_96_;
						}
						if (this.gwarb[i_95_] != 0) {
							(this.xt).clangame = this.gwtyp[i_95_];
							(this.xt).gaclan = this.gaclan[i_95_];
							if (((this.xt).clan.toLowerCase().equals(this.gaclan[i_95_].toLowerCase())) || ((this.xt).clan.toLowerCase().equals(this.gvclan[i_95_].toLowerCase())))
							(this.xt).clanchat = true;
							for (int i_97_ = 0;
							(i_97_ < (this.xt).nplayers);
							i_97_++) {
								for (int i_98_ = 0; i_98_ < this.npo;
								i_98_++) {
									if (((this.xt)
										.plnames[i_97_].equals(this.pnames[i_98_])) && (this.pgames[i_98_] == this.ongame))
									(this.xt)
										.pclan[i_97_] = this.pclan[i_98_];
								}
							}
						} else(this.xt).clangame = 0;
					} else {
						(this.xt).playingame = -1;
						(this.xt).im = 0;
					}
					i_78_ = 0;
				} else i_78_--;
				try {
					if (this.connector != null) {
						/* empty */
					}
					Thread.sleep(1000L);
				} catch (InterruptedException interruptedexception) {
					/* empty */
				}
			}
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
			if ((this.xt).playingame != -1) {
				hideinputs();
				(this.xt).multion = 3;
				this.fase = 76;
				System.gc();
			} else inishlobby();
		}
	}

	public void stopallnow() {
		this.conon = 0;
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
		if (this.connector != null) {
			this.connector.stop();
			this.connector = null;
		}
	}

	public void lobby(int i, int i_99_, boolean bool, int i_100_,
	CheckPoints checkpoints, Control control,
	ContO[] contos) {
		this.pre1 = false;
		this.pre2 = false;
		int i_101_ = 0;
		if ((this.xt).warning == 0 || (this.xt).warning == 210) {
			if (!this.regnow) {
				if (this.onjoin == -1) {
					this.xt.mainbg(3);
					if (this.britchl == -1) {
						this.ongame = -1;
						this.britchl = 0;
					}
					this.btn = 0;
					this.pbtn = 0;
					this.zeromsw = false;
					int i_102_ = this.npo;
					if (this.invo) {
						i_102_ = 0;
						for (int i_103_ = 0; i_103_ < this.npo;
						i_103_++) {
							if (this.pgames[i_103_] == -1) i_102_++;
						}
						i_102_ += 2;
					}
					int i_104_ = (i_102_ - 11) * 30;
					if (i_104_ < 0) i_104_ = 0;
					int i_105_ = (int)((float)this.spos / 295.0F * (float) i_104_);
					int i_106_ = 0;
					int i_107_ = -1;
					int i_108_ = -1;
					if (this.conon == 1) {
						if (!this.invo) {
							for (int i_109_ = 0; i_109_ < this.npo;
							i_109_++) {
								if (this.pgames[i_109_] != -1) {
									int i_110_ = 0;
									for (int i_111_ = 0;
									i_111_ < this.ngm;
									i_111_++) {
										if (this.pgames[i_109_] == this.gnum[i_111_]) i_110_ = i_111_;
									}
									if (this.wait[i_110_] > 0) {
										if (82 + 30 * i_106_ - i_105_ > 50 && (82 + 30 * (i_106_ - 1) - i_105_ < 415)) {
											boolean bool_112_ = false;
											if (i > 70 && i < 185 && i_99_ > (52 + 30 * i_106_ - i_105_) && i_99_ < (82 + 30 * i_106_ - i_105_)) {
												if ((this.pgames[this.im]) == -1 && (this.join == -1) && (this.chalngd >= -1)) {
													if (bool || ((this
														.mousonp) == i_109_)) {
														this.rd.setColor(color2k(255, 255,
														255));
														this.mousonp = i_109_;
														i_108_ = (52 + 30 * i_106_ - i_105_);
														if (bool) {
															if ((this
																.cmonp) == i_109_)
															this
																.ongame = ((
															this)
																.pgames[i_109_]);
															this
																.chalngd = -1;
														} else {
															if ((this
																.cmonp) == -1) {
																this
																	.ongame = -1;
																this
																	.cmonp = i_109_;
															}
															if ((this
																.ongame) == ((
															this)
																.pgames[i_109_]))
															this
																.mousonp = -1;
														}
													} else this.rd.setColor(color2k(220, 220,
													220));
													this.rd.fillRect(70, (53 + 30 * i_106_ - i_105_),
													116, 29);
													i_107_ = i_109_;
												}
												bool_112_ = true;
												if ((control)
													.handb) {
													(
													this.gs)
														.cmsg.setText(new StringBuilder().append((
													(this
														.gs))
														.cmsg.getText())
														.append("").append(this
														.pnames[i_109_])
														.toString());
													(control).handb = false;
												}
											}
											if ((this.pgames[this.im]) == -1 && this.join == -1 && (this.chalngd >= -1))
											this.rd.setColor(new Color(49, 79, 0));
											else this.rd.setColor(new Color(34, 55, 0));
											boolean bool_113_ = (this.gb.drawl(this.rd, (this.pnames[i_109_]),
											68,
											53 + 30 * i_106_ - i_105_,
											bool_112_));
											if (!bool_112_ || !bool_113_) {
												this.rd.setFont(new Font("Arial", 1, 12));
												this.ftm = this.rd.getFontMetrics();
												this.rd.drawString((this.pnames[i_109_]),
												127 - ((this
													.ftm.stringWidth(this
													.pnames[i_109_])) / 2), (66 + 30 * i_106_ - i_105_));
												this.rd.setFont(new Font("Arial", 0, 10));
												this.ftm = this.rd.getFontMetrics();
												this.rd.drawString((this.pcarnames[i_109_]),
												127 - (this
													.ftm.stringWidth(this
													.pcarnames[i_109_])) / 2, (78 + 30 * i_106_ - i_105_));
											}
											this.rd.setColor(color2k(150, 150, 150));
											this.rd.drawLine(70, 82 + 30 * i_106_ - i_105_,
											185,
											82 + 30 * i_106_ - i_105_);
										}
										i_106_++;
									}
								}
							}
						}
						int i_114_ = -1;
						if (this.invo) {
							for (int i_115_ = 0; i_115_ < this.ngm;
							i_115_++) {
								if (this.gwarb[i_115_] != 0 && ((this.pgames[this.im]) == this.gnum[i_115_])) i_114_ = i_115_;
							}
							this.rd.setColor(new Color(0, 0, 0));
							this.rd.setFont(new Font("Arial", 1,
							12));
							this.ftm = this.rd.getFontMetrics();
							if (i_114_ == -1)
							this.rd.drawString("Free Players",
							127 - (this.ftm.stringWidth("Free Players") / 2),
							75 - i_105_);
							else this.rd.drawString("Members of Clans", (127 - (this.ftm.stringWidth("Members of Clans") / 2)),
							75 - i_105_);
							this.rd.setFont(new Font("Arial", 0,
							10));
							this.ftm = this.rd.getFontMetrics();
							this.rd.drawString("Click a player to invite:",
							127 - (this.ftm.stringWidth("Click a player to invite:")) / 2,
							92 - i_105_);
							this.rd.setColor(color2k(150, 150, 150));
							this.rd.drawLine(70, 112 - i_105_, 185,
							112 - i_105_);
							i_106_ += 2;
						}
						for (int i_116_ = 0; i_116_ < this.npo;
						i_116_++) {
							boolean bool_117_ = false;
							if (this.invo) {
								if (this.im == i_116_) bool_117_ = true;
								for (int i_118_ = 0; i_118_ < 7; i_118_++) {
									if ((this.invos[i_118_].equals(this.pnames[i_116_])) && !bool_117_) bool_117_ = true;
								}
								if (i_114_ != -1 && !(this.pclan[i_116_].toLowerCase().equals(this.gaclan[i_114_].toLowerCase())) && !(this.pclan[i_116_].toLowerCase().equals(this.gvclan[i_114_].toLowerCase()))) bool_117_ = true;
							}
							if (this.pgames[i_116_] == -1 && !bool_117_) {
								if (82 + 30 * i_106_ - i_105_ > 50 && 82 + 30 * (i_106_ - 1) - i_105_ < 415) {
									boolean bool_119_ = false;
									if (i > 70 && i < 185 && i_99_ > 52 + 30 * i_106_ - i_105_ && i_99_ < 82 + 30 * i_106_ - i_105_) {
										if (this.invo) {
											if (bool) {
												this.rd.setColor(color2k(255, 255, 255));
												this.mousonp = i_116_;
											} else {
												this.rd.setColor(color2k(220, 220, 220));
												if (this.mousonp == i_116_) {
													int i_120_ = 0;
													for (boolean bool_121_ = false;
													(i_120_ < 7 && !bool_121_);
													i_120_++) {
														if (this
															.invos[i_120_].equals("")) {
															this
																.invos[i_120_] = ((
															this)
																.pnames[i_116_]);
															bool_121_ = true;
														}
													}
													this.mousonp = -1;
													this.invo = false;
												}
											}
											this.rd.fillRect(70, 53 + 30 * i_106_ - i_105_,
											116, 29);
											i_107_ = i_116_;
										} else if ((this.pgames[this.im]) == -1 && this.join == -1 && (this.chalngd >= -1)) {
											i_101_ = 12;
											if (bool) {
												if (!(
												this.gb)
													.proname.equals(this.pnames[i_116_])) {
													(this.gb)
														.proname = (this
														.pnames[i_116_]);
													(this.gb)
														.loadedp = false;
												}
												(this.gb).tab = 1;
												(this.gb)
													.open = 2;
												(this.gb).upo = true;
											}
										}
										bool_119_ = true;
										if ((control).handb) {
											(this.gs)
												.cmsg.setText(new StringBuilder().append((
											this.gs)
												.cmsg.getText())
												.append("").append(this.pnames[i_116_])
												.toString());
											(control).handb = false;
										}
									}
									if (this.invo)
									this.rd.setColor(new Color(62, 98, 0));
									else this.rd.setColor(new Color(0, 0, 0));
									boolean bool_122_ = (this.gb.drawl(this.rd, this.pnames[i_116_], 68,
									53 + 30 * i_106_ - i_105_,
									bool_119_));
									if (!bool_119_ || !bool_122_) {
										this.rd.setFont(new Font("Arial", 1, 12));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString(this.pnames[i_116_],
										127 - (this.ftm.stringWidth(this.pnames[i_116_])) / 2,
										66 + 30 * i_106_ - i_105_);
										this.rd.setFont(new Font("Arial", 0, 10));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString(this.pcarnames[i_116_],
										127 - (this.ftm.stringWidth(this.pcarnames[i_116_])) / 2,
										78 + 30 * i_106_ - i_105_);
									}
									this.rd.setColor(color2k(150, 150, 150));
									this.rd.drawLine(70, 82 + 30 * i_106_ - i_105_, 185,
									82 + 30 * i_106_ - i_105_);
								}
								i_106_++;
							}
						}
						if (this.invo && i_106_ == 2)
						this.invo = false;
						if (!this.invo) {
							for (int i_123_ = this.npo - 1;
							i_123_ >= 0; i_123_--) {
								if (this.pgames[i_123_] != -1) {
									int i_124_ = 0;
									for (int i_125_ = 0;
									i_125_ < this.ngm;
									i_125_++) {
										if (this.pgames[i_123_] == this.gnum[i_125_]) i_124_ = i_125_;
									}
									if (this.wait[i_124_] <= 0) {
										boolean bool_126_ = false;
										for (int i_127_ = 0;
										i_127_ < this.npo;
										i_127_++) {
											if (i_123_ != i_127_ && (this.pnames[i_123_].equals(this.pnames[i_127_]))) {
												if ((this.pgames[i_127_]) == -1) bool_126_ = true;
												else {
													for (int i_128_ = 0;
													(i_128_ < (this
														.ngm));
													i_128_++) {
														if (((this
															.pgames[i_127_]) == (this
															.gnum[i_128_])) && ((this
															.wait[i_128_]) > 0)) bool_126_ = true;
													}
												}
											}
										}
										if (!bool_126_) {
											if (82 + 30 * i_106_ - i_105_ > 50 && (82 + 30 * (i_106_ - 1) - i_105_) < 415) {
												boolean bool_129_ = false;
												if (i > 70 && i < 185 && i_99_ > (52 + 30 * i_106_ - i_105_) && i_99_ < (82 + 30 * i_106_ - i_105_)) {
													if (((this.pgames[this.im]) == -1) && (this.join == -1) && (this
														.chalngd) >= -1) {
														if (bool || ((this
															.mousonp) == i_123_)) {
															this
																.rd.setColor(color2k(255,
															255,
															255));
															this
																.mousonp = i_123_;
															i_108_ = (52 + (30 * i_106_) - i_105_);
															if (bool) {
																if (((
																this)
																	.cmonp) == i_123_)
																(
																this)
																	.ongame = ((
																this)
																	.pgames[i_123_]);
																this
																	.chalngd = -1;
															} else {
																if (((
																this)
																	.cmonp) == -1) {
																	(
																	this)
																		.ongame = -1;
																	(
																	this)
																		.cmonp = i_123_;
																}
																if (((
																this)
																	.ongame) == ((
																this)
																	.pgames[i_123_]))
																(
																this)
																	.mousonp = -1;
															}
														} else this
															.rd.setColor(color2k(220,
														220,
														220));
														this.rd.fillRect(70, (53 + 30 * i_106_ - i_105_),
														116, 29);
														i_107_ = i_123_;
													}
													bool_129_ = true;
													if ((control)
														.handb) {
														(
														this.gs)
															.cmsg.setText(new StringBuilder().append((
														(
														this).gs)
															.cmsg.getText())
															.append("").append((
														this)
															.pnames[i_123_])
															.toString());
														(control)
															.handb = false;
													}
												}
												if ((this.pgames[this.im]) == -1 && (this.join == -1) && (this.chalngd >= -1)) {
													if ((this.wait[i_124_]) == 0)
													this.rd.setColor(new Color(117, 67,
													0));
													else this.rd.setColor(color2k(0, 28,
													102));
												} else if ((this.wait[i_124_]) == 0)
												this.rd.setColor(new Color(82, 47, 0));
												else this.rd.setColor(color2k(0, 20, 71));
												boolean bool_130_ = (this.gb.drawl(this.rd, (this.pnames[i_123_]),
												68, (53 + 30 * i_106_ - i_105_),
												bool_129_));
												if (!bool_129_ || !bool_130_) {
													this.rd.setFont(new Font("Arial", 1,
													12));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.drawString((this.pnames[i_123_]), (127 - (this
														.ftm.stringWidth(this
														.pnames[i_123_])) / 2), (66 + 30 * i_106_ - i_105_));
													this.rd.setFont(new Font("Arial", 0,
													10));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.drawString((this
														.pcarnames[i_123_]), (127 - (this
														.ftm.stringWidth(this
														.pcarnames[i_123_])) / 2), (78 + 30 * i_106_ - i_105_));
												}
												this.rd.setColor(color2k(150, 150, 150));
												this.rd.drawLine(70,
												82 + 30 * i_106_ - i_105_,
												185, (82 + 30 * i_106_ - i_105_));
											}
											i_106_++;
										}
									}
								}
							}
						}
					}
					if (this.mousonp != i_107_) {
						this.mousonp = -1;
						this.cmonp = -1;
					}
					if (this.npo == 0) {
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.setFont(new Font("Arial", 1, 12));
						this.ftm = this.rd.getFontMetrics();
						this.rd.drawString("|  Loading Players  |",
						127 - (this.ftm.stringWidth("|  Loading Players  |") / 2),
						95);
					}
					this.rd.setColor(color2k(205, 205, 205));
					this.rd.fillRect(65, 25, 145, 28);
					this.rd.setColor(color2k(150, 150, 150));
					this.rd.drawLine(65, 50, 190, 50);
					this.rd.setColor(color2k(205, 205, 205));
					this.rd.fillRect(65, 413, 145, 12);
					this.rd.setColor(color2k(150, 150, 150));
					this.rd.drawLine(65, 415, 190, 415);
					this.rd.setColor(color2k(205, 205, 205));
					this.rd.fillRect(193, 53, 17, 360);
					this.rd.setColor(new Color(0, 0, 0));
					this.rd.drawLine(211, 25, 211, 425);
					this.rd.drawImage((
					this.xt).roomp,
					72, 30, null);
					if (this.mscro == 131 || i_104_ == 0) {
						if (i_104_ == 0)
						this.rd.setColor(color2k(205, 205, 205));
						else this.rd.setColor(color2k(215, 215, 215));
						this.rd.fillRect(193, 53, 17, 17);
					} else {
						this.rd.setColor(color2k(220, 220, 220));
						this.rd.fill3DRect(193, 53, 17, 17, true);
					}
					if (i_104_ != 0)
					this.rd.drawImage((
					this.xt).asu,
					198, 59, null);
					if (this.mscro == 132 || i_104_ == 0) {
						if (i_104_ == 0)
						this.rd.setColor(color2k(205, 205, 205));
						else this.rd.setColor(color2k(215, 215, 215));
						this.rd.fillRect(193, 396, 17, 17);
					} else {
						this.rd.setColor(color2k(220, 220, 220));
						this.rd.fill3DRect(193, 396, 17, 17, true);
					}
					if (i_104_ != 0)
					this.rd.drawImage((
					this.xt).asd,
					198, 403, null);
					if (i_104_ != 0 && this.conon == 1) {
						if (this.lspos != this.spos) {
							this.rd.setColor(color2k(215, 215, 215));
							this.rd.fillRect(193, (70 + this.spos),
							17, 31);
						} else {
							if (this.mscro == 131)
							this.rd.setColor(color2k(215, 215,
							215));
							this.rd.fill3DRect(193,
							70 + (this
								.spos),
							17, 31, true);
						}
						this.rd.setColor(color2k(150, 150, 150));
						this.rd.drawLine(198,
						83 + this.spos,
						204,
						83 + this.spos);
						this.rd.drawLine(198,
						85 + this.spos,
						204,
						85 + this.spos);
						this.rd.drawLine(198,
						87 + this.spos,
						204,
						87 + this.spos);
						if (this.mscro > 101 && this.lspos != this.spos)
						this.lspos = this.spos;
						if (bool) {
							if (this.mscro == 125 && i > 193 && i < 210 && i_99_ > 70 + this.spos && i_99_ < this.spos + 101)
							this.mscro = i_99_ - this.spos;
							if (this.mscro == 125 && i > 191 && i < 212 && i_99_ > 51 && i_99_ < 72)
							this.mscro = 131;
							if (this.mscro == 125 && i > 191 && i < 212 && i_99_ > 394 && i_99_ < 415)
							this.mscro = 132;
							if (this.mscro == 125 && i > 193 && i < 210 && i_99_ > 70 && i_99_ < 396) {
								this.mscro = 85;
								this.spos = i_99_ - this.mscro;
							}
							int i_131_ = 1350 / i_104_;
							if (i_131_ < 1) i_131_ = 1;
							if (this.mscro == 131) {
								this.spos -= i_131_;
								if (this.spos > 295)
								this.spos = 295;
								if (this.spos < 0)
								this.spos = 0;
								this.lspos = this.spos;
							}
							if (this.mscro == 132) {
								this.spos += i_131_;
								if (this.spos > 295)
								this.spos = 295;
								if (this.spos < 0)
								this.spos = 0;
								this.lspos = this.spos;
							}
							if (this.mscro <= 101) {
								this.spos = i_99_ - this.mscro;
								if (this.spos > 295)
								this.spos = 295;
								if (this.spos < 0)
								this.spos = 0;
							}
							if (this.mscro == 125)
							this.mscro = 225;
						} else if (this.mscro != 125)
						this.mscro = 125;
						if (i_100_ != 0 && i > 65 && i < 170 && i_99_ > 93 && i_99_ < 413) {
							this.spos -= i_100_;
							this.zeromsw = true;
							if (this.spos > 295) {
								this.spos = 295;
								this.zeromsw = false;
							}
							if (this.spos < 0) {
								this.spos = 0;
								this.zeromsw = false;
							}
							this.lspos = this.spos;
						}
					}
					if (this.ongame == -1) {
						if (this.opengame >= 2) {
							if (this.opengame >= 27)
							this.opengame = 26;
							int i_132_ = 229 + this.opengame;
							if (i_132_ > 255) i_132_ = 255;
							if (i_132_ < 0) i_132_ = 0;
							this.rd.setColor(color2k(i_132_, i_132_,
							i_132_));
							this.rd.fillRoundRect(225,
							59 - (int)((float)this.opengame * 2.23F),
							495, 200 + this.opengame * 8, 20,
							20);
							this.rd.setColor(new Color(0, 0, 0));
							this.rd.drawRoundRect(225,
							59 - (int)((float)this.opengame * 2.23F),
							495, 200 + this.opengame * 8, 20,
							20);
							if (!(this.xt).lan) {
								this.rd.setColor(color2k(217, 217,
								217));
								this.rd.fillRoundRect(225, 263 + this.opengame * 7,
								495, 157, 20, 20);
								this.rd.setColor(new Color(0, 0, 0));
								this.rd.drawRoundRect(225, 263 + this.opengame * 7,
								495, 157, 20, 20);
							}
							this.btn = 0;
							if (this.prevloaded != -1)
							this.prevloaded = -1;
							if (this.updatec != -1)
							this.updatec = -1;
							if ((this.gs).cmsg.isShowing()) {
								(this.gs).cmsg.hide();
								this.gs.requestFocus();
							}
							this.opengame -= 2;
							if (this.opengame == 0 && this.longame != -1 && this.chalngd == -1) {
								this.ongame = this.longame;
								this.longame = -1;
							}
							if (this.invo)
							this.invo = false;
							for (int i_133_ = 0; i_133_ < 7; i_133_++) {
								if (!this.invos[i_133_].equals(""))
								this.invos[i_133_] = "";
								if (!this.dinvi[i_133_].equals(""))
								this.dinvi[i_133_] = "";
							}
							if (this.fstart)
							this.fstart = false;
							for (int i_134_ = 0; i_134_ < 9; i_134_++) {
								if (this.cac[i_134_] != -1)
								this.cac[i_134_] = -1;
							}
							if (this.dispcar != -1)
							this.dispcar = -1;
						} else {
							if (!(this.xt).lan) {
								drawSbutton(((this.xt)
									.cgame),
								292, 42);
								drawSbutton(((this.xt)
									.ccar),
								442, 42);
								this.rd.setFont(new Font("Arial", 1,
								13));
								this.ftm = this.rd.getFontMetrics();
								this.rd.setColor(color2k(60, 60,
								60));
								if (!(this.gs)
									.rooms.isShowing())
								(this.gs).rooms.show();
								(this.gs).rooms.move(580 - (((
								this.gs).rooms)
									.w) / 2,
								29);
								if ((((this.gs)
									.rooms)).sel != 0) {
									stopallnow();
									int i_135_ = (((
									this.gs).rooms)
										.iroom[(
									((this.gs)
										.rooms)).sel]);
									if (i_135_ < 1000) {
										if (i_135_ >= 1 && i_135_ <= 5)
										(this.xt)
											.servport = 7070 + i_135_;
									} else {
										i_135_ -= 1000;
										if (i_135_ >= 0 && (i_135_ < ((this.lg)
											.nservers))) {
											(this.xt)
												.servport = 7071;
											(this.xt)
												.server = ((this.lg)
												.servers[i_135_]);
											(this.xt)
												.servername = ((this.lg)
												.snames[i_135_]);
										}
									}
									inishlobby();
									(((this.gs)
										.rooms)).kmoused = 20;
								}
								if ((((this.gs)
									.rooms)).kmoused != 0) {
									i = -1;
									i_99_ = -1;
									bool = false;
									(((this.gs)
										.rooms)).kmoused--;
								}
							} else {
								this.rd.drawImage((
								(this
									.xt)).lanm,
								241, 31, null);
								if (this.npo <= 1) {
									drawSbutton((
									this.xt).cgame,
									292, -1000);
									this.rd.setColor(new Color(0, 0,
									0));
									if (this.ncnt == 0)
									this.rd.setColor(new Color(188, 111, 0));
									this.rd.setFont(new Font("Arial",
									1, 13));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString(this.lmsg,
									472 - (this.ftm.stringWidth(this.lmsg)) / 2,
									295);
									if ((this.lmsg.equals(". . . | Searching/Waiting for other LAN Players | . . .")) && this.ncnt == 0) {
										this.lmsg = "| Searching/Waiting for other LAN Players |";
										this.ncnt = 5;
									}
									if ((this.lmsg.equals(". . | Searching/Waiting for other LAN Players | . .")) && this.ncnt == 0) {
										this.lmsg = ". . . | Searching/Waiting for other LAN Players | . . .";
										this.ncnt = 5;
									}
									if ((this.lmsg.equals(". | Searching/Waiting for other LAN Players | .")) && this.ncnt == 0) {
										this.lmsg = ". . | Searching/Waiting for other LAN Players | . .";
										this.ncnt = 5;
									}
									if ((this.lmsg.equals("| Searching/Waiting for other LAN Players |")) && this.ncnt == 0) {
										this.lmsg = ". | Searching/Waiting for other LAN Players | .";
										this.ncnt = 5;
									}
									if (this.ncnt != 0)
									this.ncnt--;
									this.rd.setColor(color2k(70, 70,
									70));
								}/* else if (!this.lanlogged) {
									this.rd.setColor(new Color(0, 0,
									0));
									this.rd.setFont(new Font("Arial",
									1, 13));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString("You have played the allowed 3 LAN games per day!", (472 - ((this.ftm.stringWidth("You have played the allowed 3 LAN games per day!")) / 2)),
									295);
									this.rd.setColor(color2k(70, 70,
									70));
									this.rd.drawString("There needs to be at least one of the LAN players in the lobby with a registered",
									225, 325);
									this.rd.drawString("account to be able to play LAN unlimitedly...",
									225, 345);
									this.rd.drawString("Just one registered user allows everyone in the LAN game to play unlimitedly!",
									225, 365);
									this.rd.drawString("Please register now!", 225, 385);
									drawSbutton((
									this.xt).register,
									472, 395);
								}*/ else {
									this.rd.setColor(color2k(90, 90,
									90));
									this.rd.setFont(new Font("Arial",
									1, 12));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString(new StringBuilder().append("[  ")
										.append(i_106_).append(" Players Connected  ]")
										.toString(),
									472 - (this.ftm.stringWidth(new StringBuilder().append("[  ").append(i_106_).append(" Players Connected  ]")
										.toString())) / 2,
									295);
									drawSbutton((
									this.xt).cgame,
									472, 325);
								}
								drawSbutton(((this.xt)
									.ccar),
								442, -1000);
							}
							drawSbutton((this.xt).exit,
							690, 42);
							if ((control).enter && !(this.gs).cmsg.getText().equals("Type here...") && !(this.gs).cmsg.getText().equals("")) {
								if (this.chalngd == -1)
								this.pessd[2] = true;
								else this.pessd[5] = true;
								(control).enter = false;
								String string = (this.gs)
									.cmsg.getText().replace('|', ':');
								if ((string.toLowerCase().indexOf((this.gs)
									.tpass.getText().toLowerCase())) != -1) string = " ";
								if (!this.xt.msgcheck(string) && this.updatec > -12) {
									for (int i_136_ = 0; i_136_ < 6;
									i_136_++) {
										this.sentn[i_136_] = this.sentn[i_136_ + 1];
										this.cnames[i_136_] = (this.cnames[i_136_ + 1]);
									}
									this.sentn[6] = string;
									this.cnames[6] = (this.pnames[this.im]);
									if (this.updatec > -11)
									this.updatec = -11;
									else this.updatec--;
									this.spos3 = 28;
								} else(this.xt).warning++;
								(this.gs).cmsg.setText("");
							}
							if (this.chalngd == -1) {
								this.rd.setColor(color2k(230, 230,
								230));
								this.rd.fillRoundRect(225, 59, 495,
								200, 20, 20);
								this.rd.setColor(new Color(0, 0, 0));
								this.rd.drawRoundRect(225, 59, 495,
								200, 20, 20);
								if (this.britchl != 0)
								this.britchl = 0;
								i_104_ = (this.ngm - 5) * 24;
								if (i_104_ < 0) i_104_ = 0;
								i_105_ = (int)(((float)this.spos2 / 82.0F * (float) i_104_) - 2.0F);
								int[] is = new int[this.ngm];
								int[] is_137_ = new int[this.ngm];
								for (int i_138_ = 0;
								i_138_ < this.ngm; i_138_++)
								is[i_138_] = 0;
								for (int i_139_ = 0;
								i_139_ < this.ngm; i_139_++) {
									for (int i_140_ = i_139_ + 1;
									i_140_ < this.ngm;
									i_140_++) {
										if (this.wait[i_139_] != this.wait[i_140_]) {
											if ((this.wait[i_139_] <= 0) && (this.wait[i_140_] <= 0)) {
												if (this.wait[i_139_] < (this.wait[i_140_])) is[i_139_]++;
												else is[i_140_]++;
											} else if ((((this.wait[i_139_]) > (this.wait[i_140_])) || (this.wait[i_139_]) <= 0) && (this.wait[i_140_]) > 0) is[i_139_]++;
											else is[i_140_]++;
										} else if (i_140_ < i_139_) is[i_139_]++;
										else is[i_140_]++;
									}
									is_137_[is[i_139_]] = i_139_;
								}
								if ((control).down) {
									this.opselect++;
									for (boolean bool_141_ = false;
									((80 + 24 * this.opselect - i_105_) > 202 && !bool_141_);
									i_105_ = (int)(((float)(this
										.spos2) / 82.0F * (float) i_104_) - 2.0F)) {
										this.spos2++;
										if (this.spos2 > 82) {
											this.spos2 = 82;
											bool_141_ = true;
										}
										if (this.spos2 < 0) {
											this.spos2 = 0;
											bool_141_ = true;
										}
									}
									(control).down = false;
								}
								if ((control).up) {
									this.opselect--;
									for (boolean bool_142_ = false;
									((80 + 24 * this.opselect - i_105_) < 80 && !bool_142_);
									i_105_ = (int)(((float)(this
										.spos2) / 82.0F * (float) i_104_) - 2.0F)) {
										this.spos2--;
										if (this.spos2 > 82) {
											this.spos2 = 82;
											bool_142_ = true;
										}
										if (this.spos2 < 0) {
											this.spos2 = 0;
											bool_142_ = true;
										}
									}
									(control).up = false;
								}
								int i_143_ = -1;
								if (this.mousonp != -1) {
									int i_144_ = 0;
									for (int i_145_ = 0;
									i_145_ < this.ngm;
									i_145_++) {
										if ((this.pgames[this.mousonp]) == this.gnum[i_145_]) i_144_ = i_145_;
									}
									i_143_ = 91 + 24 * is[i_144_] - i_105_;
									if (80 + 24 * is[i_144_] - i_105_ > 202) {
										int i_146_ = 1000 / i_104_;
										if (i_146_ < 1) i_146_ = 1;
										this.spos2 += i_146_;
										i_143_ = -1;
									}
									if (80 + 24 * is[i_144_] - i_105_ < 80) {
										int i_147_ = 1000 / i_104_;
										if (i_147_ < 1) i_147_ = 1;
										this.spos2 -= i_147_;
										i_143_ = -1;
									}
									if (this.spos2 > 82)
									this.spos2 = 82;
									if (this.spos2 < 0)
									this.spos2 = 0;
									i_105_ = (int)(((float)this.spos2 / 82.0F * (float) i_104_) - 2.0F);
									this.opselect = is[i_144_];
								}
								if (this.opselect <= -1)
								this.opselect = 0;
								if (this.opselect >= this.ngm)
								this.opselect = this.ngm - 1;
								int i_148_ = 0;
								for (int i_149_ = 0;
								i_149_ < this.ngm; i_149_++) {
									if (80 + 24 * i_149_ - i_105_ < 224 && 80 + 24 * i_149_ - i_105_ > 56) {
										if (this.opselect == i_149_) {
											if (80 + 24 * i_149_ - i_105_ >= 224)
											this.opselect--;
											if (80 + 24 * i_149_ - i_105_ < 62)
											this.opselect++;
										}
										boolean bool_150_ = false;
										boolean bool_151_ = false;
										if (!(this.gs)
											.openm) {
											if (i > 241 && i < 692 && i_99_ > (92 + 24 * i_149_ - i_105_) && i_99_ < (110 + 24 * i_149_ - i_105_)) {
												if (this.lxm != i || (this.lym != i_99_))
												this.opselect = i_149_;
												bool_150_ = true;
												if (bool) {
													if (this.clicked == -1)
													this.clicked = is_137_[i_149_];
												} else {
													if (this.clicked == is_137_[i_149_]) {
														this.ongame = (this
															.gnum[(is_137_[i_149_])]);
														this.opengame = 0;
														if (i >= 641 && i <= 689 && (i_99_ > (92 + (24 * i_149_) - i_105_)) && (i_99_ < (110 + (24 * i_149_) - i_105_)) && ((this
															.wait[(is_137_[i_149_])]) > 0)) {
															boolean bool_152_ = false;
															if ((this
																.gwarb[(is_137_[i_149_])]) == 0) {
																if ((
																this)
																	.gplyrs[(is_137_[i_149_])].equals("") || ((
																this)
																	.gplyrs[is_137_[i_149_]].indexOf((
																this)
																	.pnames[((
																this)
																	.im)])) != -1) bool_152_ = true;
															} else if (((
															((
															this)
																.xt))
																.clan.toLowerCase()
																.equals((
															this)
																.gaclan[is_137_[i_149_]].toLowerCase())) || ((
															(
															this).xt).clan.toLowerCase().equals((
															this).gvclan[is_137_[i_149_]].toLowerCase()))) bool_152_ = true;
															if (bool_152_) {
																this
																	.join = ((
																this)
																	.gnum[(is_137_[i_149_])]);
																this
																	.msg = "| Joining Game |";
																this
																	.spos = 0;
															}
														}
														this.clicked = -1;
													}
													i_148_++;
												}
											} else i_148_++;
											if (i >= 641 && i <= 689 && i_99_ > (92 + 24 * i_149_ - i_105_) && i_99_ < (110 + 24 * i_149_ - i_105_) && bool) bool_151_ = true;
										}
										if (this.opselect == i_149_) {
											if (bool_150_ && bool || (control).enter) {
												this.rd.setColor(color2k(200, 200, 200));
												if ((control)
													.enter) {
													this.ongame = (this.gnum[is_137_[i_149_]]);
													this.opengame = 0;
													(control).enter = false;
												}
											} else this.rd.setColor(color2k(255, 255, 255));
											this.rd.fillRect(241,
											92 + 24 * i_149_ - i_105_,
											451, 18);
											if (bool_150_) {
												this.rd.setColor(color2k(150, 150, 150));
												this.rd.drawRect(239,
												90 + 24 * i_149_ - i_105_,
												454, 21);
											}
										}
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 1, 12));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString((this.gstages[is_137_[i_149_]]),
										382 - (this.ftm.stringWidth(this.gstages[is_137_[i_149_]])) / 2,
										105 + 24 * i_149_ - i_105_);
										this.rd.drawString("|", 525,
										105 + 24 * i_149_ - i_105_);
										this.rd.drawString("|", 584,
										105 + 24 * i_149_ - i_105_);
										if ((this.wait[is_137_[i_149_]]) > 0) {
											this.rd.drawString(new StringBuilder().append("").append(this.npls[is_137_[i_149_]])
												.append(" / ").append(this.mnpls[is_137_[i_149_]])
												.append("").toString(), (556 - (this.ftm.stringWidth(new StringBuilder()
												.append("").append(this.npls[is_137_[i_149_]])
												.append(" / ").append(this.mnpls[is_137_[i_149_]])
												.append("")
												.toString())) / 2),
											105 + 24 * i_149_ - i_105_);
											this.rd.setFont(new Font("Arial", 0, 12));
											this.rd.setColor(new Color(80, 128, 0));
											this.rd.drawString("Waiting", 593,
											105 + 24 * i_149_ - i_105_);
											this.rd.setFont(new Font("Arial", 1, 12));
											this.ftm = this.rd.getFontMetrics();
											if (!bool_151_) {
												this.rd.setColor(color2k(230, 230, 230));
												this.rd.fill3DRect(641,
												92 + 24 * i_149_ - i_105_,
												48, 18, true);
												this.rd.fill3DRect(642,
												93 + 24 * i_149_ - i_105_,
												46, 16, true);
											} else {
												this.rd.setColor(color2k(230, 230, 230));
												this.rd.fillRect(641,
												92 + 24 * i_149_ - i_105_,
												48, 18);
											}
											this.rd.setColor(new Color(0, 0, 0));
											boolean bool_153_ = false;
											if ((this.gwarb[is_137_[i_149_]]) == 0) {
												if (this.gplyrs[is_137_[i_149_]].equals("") || ((this
													.gplyrs[is_137_[i_149_]].indexOf(this.pnames[this.im])) != -1)) bool_153_ = true;
											} else if (((
											this.xt)
												.clan.toLowerCase().equals(this
												.gaclan[is_137_[i_149_]].toLowerCase())) || ((
											this.xt)
												.clan.toLowerCase().equals(this
												.gvclan[(is_137_[i_149_])].toLowerCase()))) bool_153_ = true;
											if (bool_153_)
											this.rd.drawString("Join",
											665 - (this
												.ftm.stringWidth("Join")) / 2, (105 + 24 * i_149_ - i_105_));
											else this.rd.drawString("View",
											665 - (this
												.ftm.stringWidth("View")) / 2, (105 + 24 * i_149_ - i_105_));
										} else {
											this.rd.drawString(new StringBuilder().append("").append(this.npls[is_137_[i_149_]])
												.append("").toString(), (556 - ((this.ftm.stringWidth(new StringBuilder()
												.append("").append(this.npls[is_137_[i_149_]])
												.append("").toString())) / 2)),
											105 + 24 * i_149_ - i_105_);
											this.rd.setFont(new Font("Arial", 0, 12));
											this.ftm = this.rd.getFontMetrics();
											if ((this.wait[is_137_[i_149_]]) == 0) {
												this.rd.setColor(new Color(128, 73, 0));
												this.rd.drawString("Started", 594, (105 + 24 * i_149_ - i_105_));
											} else {
												this.rd.setColor(color2k(100, 100, 100));
												this.rd.drawString("Finished", 590, (105 + 24 * i_149_ - i_105_));
											}
											this.rd.setFont(new Font("Arial", 1, 12));
											this.ftm = this.rd.getFontMetrics();
											if (!bool_151_) {
												this.rd.setColor(color2k(230, 230, 230));
												this.rd.fill3DRect(641,
												92 + 24 * i_149_ - i_105_,
												48, 18, true);
											} else {
												this.rd.setColor(color2k(230, 230, 230));
												this.rd.fillRect(641,
												92 + 24 * i_149_ - i_105_,
												48, 18);
											}
											this.rd.setColor(new Color(0, 0, 0));
											this.rd.drawString("View", (665 - (this.ftm.stringWidth("View") / 2)),
											105 + 24 * i_149_ - i_105_);
										}
									} else {
										if (this.opselect == i_149_) {
											if (80 + 24 * i_149_ - i_105_ >= 224)
											this.opselect--;
											if (80 + 24 * i_149_ - i_105_ <= 56)
											this.opselect++;
										}
										i_148_++;
									}
								}
								if (i_148_ == this.ngm && this.clicked != -1)
								this.clicked = -1;
								this.rd.setColor(new Color(0, 0, 0));
								this.rd.setFont(new Font("Arial", 1,
								12));
								this.ftm = this.rd.getFontMetrics();
								if (this.ngm == 0) {
									if (!this.lloaded)
									this.rd.drawString("|  Loading Games  |", (472 - (this.ftm.stringWidth("|  Loading Games  |")) / 2),
									165);
									else if (!(this.xt)
										.lan)
									this.rd.drawString("No Games Created",
									472 - (this.ftm.stringWidth("No Games Created")) / 2,
									165);
								}
								this.rd.setColor(color2k(205, 205,
								205));
								this.rd.fillRect(235, 65, 480, 25);
								this.rd.drawImage((
								(this
									.xt)).games,
								241, 69, null);
								this.rd.setColor(color2k(70, 70,
								70));
								this.rd.drawString("Stage Name",
								382 - this.ftm.stringWidth("Stage Name") / 2,
								81);
								this.rd.drawString("|", 525, 81);
								this.rd.drawString("Players",
								556 - this.ftm.stringWidth("Players") / 2,
								81);
								this.rd.drawString("|", 584, 81);
								this.rd.drawString("Status",
								641 - this.ftm.stringWidth("Status") / 2,
								81);
								this.rd.setColor(color2k(150, 150,
								150));
								this.rd.drawLine(235, 87, 696, 87);
								this.rd.setColor(color2k(205, 205,
								205));
								this.rd.fillRect(235, 237, 480, 17);
								this.rd.setColor(color2k(150, 150,
								150));
								this.rd.drawLine(235, 239, 696, 239);
								this.rd.setColor(color2k(205, 205,
								205));
								this.rd.fillRect(698, 107, 17, 113);
								this.rd.setColor(color2k(205, 205,
								205));
								this.rd.fillRect(231, 65, 4, 189);
								if (this.mscro2 == 141 || i_104_ == 0) {
									if (i_104_ == 0)
									this.rd.setColor(color2k(205, 205, 205));
									else this.rd.setColor(color2k(215, 215, 215));
									this.rd.fillRect(698, 90, 17,
									17);
								} else {
									this.rd.setColor(color2k(220, 220, 220));
									this.rd.fill3DRect(698, 90, 17,
									17, true);
								}
								if (i_104_ != 0)
								this.rd.drawImage((this.xt).asu,
								703, 96, null);
								if (this.mscro2 == 142 || i_104_ == 0) {
									if (i_104_ == 0)
									this.rd.setColor(color2k(205, 205, 205));
									else this.rd.setColor(color2k(215, 215, 215));
									this.rd.fillRect(698, 220, 17,
									17);
								} else {
									this.rd.setColor(color2k(220, 220, 220));
									this.rd.fill3DRect(698, 220, 17,
									17, true);
								}
								if (i_104_ != 0)
								this.rd.drawImage((this.xt).asd,
								703, 226, null);
								if (i_104_ != 0) {
									if (this.lspos2 != this.spos2) {
										this.rd.setColor(color2k(215, 215, 215));
										this.rd.fillRect(698, 107 + this.spos2,
										17, 31);
									} else {
										if (this.mscro2 == 141)
										this.rd.setColor(color2k(215, 215, 215));
										this.rd.fill3DRect(698, 107 + this.spos2,
										17, 31, true);
									}
									this.rd.setColor(color2k(150, 150, 150));
									this.rd.drawLine(703, 120 + this.spos2, 709,
									120 + this.spos2);
									this.rd.drawLine(703, 122 + this.spos2, 709,
									122 + this.spos2);
									this.rd.drawLine(703, 124 + this.spos2, 709,
									124 + this.spos2);
									if (this.mscro2 > 138 && (this.lspos2 != this.spos2))
									this.lspos2 = this.spos2;
									if (bool) {
										if (this.mscro2 == 145 && i > 698 && i < 715 && (i_99_ > 107 + this.spos2) && (i_99_ < this.spos2 + 138))
										this.mscro2 = i_99_ - this.spos2;
										if (this.mscro2 == 145 && i > 696 && i < 717 && i_99_ > 88 && i_99_ < 109)
										this.mscro2 = 141;
										if (this.mscro2 == 145 && i > 696 && i < 717 && i_99_ > 218 && i_99_ < 239)
										this.mscro2 = 142;
										if (this.mscro2 == 145 && i > 698 && i < 715 && i_99_ > 107 && i_99_ < 220) {
											this.mscro2 = 122;
											this.spos2 = (i_99_ - this.mscro2);
										}
										int i_154_ = 400 / i_104_;
										if (i_154_ < 1) i_154_ = 1;
										if (this.mscro2 == 141) {
											this.spos2 -= i_154_;
											if (this.spos2 > 82)
											this.spos2 = 82;
											if (this.spos2 < 0)
											this.spos2 = 0;
											this.lspos2 = this.spos2;
										}
										if (this.mscro2 == 142) {
											this.spos2 += i_154_;
											if (this.spos2 > 82)
											this.spos2 = 82;
											if (this.spos2 < 0)
											this.spos2 = 0;
											this.lspos2 = this.spos2;
										}
										if (this.mscro2 <= 138) {
											this.spos2 = (i_99_ - this.mscro2);
											if (this.spos2 > 82)
											this.spos2 = 82;
											if (this.spos2 < 0)
											this.spos2 = 0;
										}
										if (this.mscro2 == 145)
										this.mscro2 = 225;
									} else if (this.mscro2 != 145)
									this.mscro2 = 145;
									if (i_100_ != 0 && i > 235 && i < 698 && i_99_ > 87 && i_99_ < 239) {
										this.spos2 -= i_100_;
										this.zeromsw = true;
										if (this.spos2 > 82) {
											this.spos2 = 82;
											this.zeromsw = false;
										}
										if (this.spos2 < 0) {
											this.spos2 = 0;
											this.zeromsw = false;
										}
										this.lspos2 = this.spos2;
									}
								}
								if (this.mousonp != -1 && i_143_ != -1) {
									this.rd.setColor(color2k(255, 255, 255));
									int[] is_155_ = {
										185, 241, 241, 185
									};
									int[] is_156_ = {
										i_108_, i_143_, i_143_ + 19,
										i_108_ + 30
									};
									this.rd.fillPolygon(is_155_,
									is_156_, 4);
									this.rd.setColor(color2k(150, 150, 150));
									this.rd.drawLine(185, i_108_,
									241, i_143_);
									this.rd.drawLine(185,
									i_108_ + 30,
									241,
									i_143_ + 19);
									this.rd.drawLine(241, i_143_,
									692, i_143_);
									this.rd.drawLine(241,
									i_143_ + 19,
									692,
									i_143_ + 19);
								}
							} else {
								int i_157_ = 230 + this.britchl;
								if (i_157_ > 255) i_157_ = 255;
								if (i_157_ < 0) i_157_ = 0;
								this.rd.setColor(color2k(i_157_, i_157_, i_157_));
								this.rd.fillRoundRect(225, 59, 495,
								200, 20, 20);
								this.rd.setColor(new Color(0, 0, 0));
								this.rd.drawRoundRect(225, 59, 495,
								200, 20, 20);
								if (this.britchl < 25)
								this.britchl += 5;
								if (this.chalngd > -1) {
									int i_158_ = 0;
									for (int i_159_ = 0;
									i_159_ < this.ngm;
									i_159_++) {
										if (this.chalngd == this.gnum[i_159_]) i_158_ = i_159_;
									}
									if (this.cflk % 4 != 0 || this.cflk == 0) {
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 1, 13));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString(new StringBuilder().append("You have been invited by ")
											.append(this.chalby).append(" to join a game!")
											.toString(), (472 - (this.ftm.stringWidth(new StringBuilder().append("You have been invited by ")
											.append(this.chalby)
											.append(" to join a game!")
											.toString())) / 2),
										95);
										this.rd.setColor(new Color(117, 67, 0));
										this.rd.drawString(this.chalby, (472 - (this.ftm.stringWidth(new StringBuilder().append("You have been invited by ")
											.append(this.chalby)
											.append(" to join a game!")
											.toString())) / 2 + (this.ftm.stringWidth("You have been invited by "))),
										95);
									}
									if (this.cflk != 0)
									this.cflk--;
									this.rd.setColor(new Color(0, 0,
									0));
									this.rd.setFont(new Font("Arial",
									1, 12));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString(new StringBuilder().append("Stage:  ").append(this.gstages[i_158_])
										.append(" ,  Laps: ").append(this.gnlaps[i_158_])
										.append("").toString(),
									472 - (this.ftm.stringWidth(new StringBuilder().append("Stage:  ").append(this.gstages[i_158_])
										.append(" ,  Laps: ").append(this.gnlaps[i_158_])
										.append("").toString())) / 2,
									130);
									this.rd.setColor(new Color(62, 98, 0));
									this.rd.drawString(this.gstages[i_158_], (472 - (this.ftm.stringWidth(new StringBuilder().append("Stage:  ").append(this.gstages[i_158_])
										.append(" ,  Laps: ").append(this.gnlaps[i_158_])
										.append("").toString())) / 2 + this.ftm.stringWidth("Stage:  ")),
									130);
									this.rd.drawString(new StringBuilder().append("").append(this.gnlaps[i_158_])
										.append("").toString(), (472 - (this.ftm.stringWidth(new StringBuilder().append("Stage:  ").append(this.gstages[i_158_])
										.append(" ,  Laps: ").append(this.gnlaps[i_158_])
										.append("").toString())) / 2 + (this.ftm.stringWidth(new StringBuilder().append("Stage:  ").append(this.gstages[i_158_])
										.append(" ,  Laps: ").toString()))),
									130);
									this.rd.setColor(new Color(0, 0,
									0));
									this.rd.drawString(new StringBuilder().append("Players:  ").append(this.mnpls[i_158_])
										.append("").toString(),
									472 - (this.ftm.stringWidth(new StringBuilder().append("Players:  ").append(this.mnpls[i_158_])
										.append("").toString())) / 2,
									150);
									this.rd.setColor(new Color(62, 98, 0));
									this.rd.drawString(new StringBuilder().append("").append(this.mnpls[i_158_])
										.append("").toString(), (472 - (this.ftm.stringWidth(new StringBuilder().append("Players:  ").append(this.mnpls[i_158_])
										.append("").toString())) / 2 + this.ftm.stringWidth("Players:  ")),
									150);
									Date date = new Date();
									long l = date.getTime();
									if (this.ptime == 0L || l > this.ptime + 1000L) {
										if (this.ptime != 0L)
										this.ctime--;
										this.ptime = l;
									}
									this.rd.setColor(new Color(0, 0,
									0));
									this.rd.setFont(new Font("Arial",
									0, 12));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString(new StringBuilder().append("(")
										.append(this.ctime).append(" )").toString(),
									472 - (this.ftm.stringWidth(new StringBuilder().append("(").append(this.ctime)
										.append(" )").toString())) / 2,
									170);
									if (this.ctime == 0) {
										this.ongame = this.longame;
										this.chalngd = -1;
										this.longame = -1;
									}
									stringbutton("   View Game   ", 352, 215,
									2);
									stringbutton("   Join Game   ", 462, 215,
									2);
									stringbutton("   Decline X   ", 599, 215,
									2);
								} else {
									if (this.chalngd != -5) stringbutton(" Cancel X ", 669, 85, 2);
									if (this.chalngd == -6) {
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 1, 13));
										this.rd.drawString("This room already has a game that has started.",
										288, 120);
										this.rd.drawString("Please switch to another room to create a new game.",
										288, 140);
										this.rd.drawString("Or wait for the game to finish.",
										288, 160);
										this.rd.drawString("Use the dropdown menu above to change room or server.",
										288, 180);
										int[] is = {
											580, 569, 576, 576, 584,
											584, 591
										};
										int[] is_160_ = {
											66, 77, 77, 102, 102, 77, 77
										};
										this.rd.fillPolygon(is, is_160_, 7);
										stringbutton("     OK     ", 472, 215,
										1);
									}
									if (this.chalngd == -2) {
										boolean bool_161_ = false;
										boolean bool_162_ = false;
										if (!(this.gs)
											.wgame.isShowing())
										(this.gs)
											.wgame.show();
										(this.gs)
											.wgame.move(236, 68);
										if ((this.gs)
											.wgame.getSelectedIndex() == 0) {
											if (this.inwab) {
												this.inwab = false;
												(
												this.gs)
													.warb.hide();
												this.loadstage = 0;
											}
											this.rd.setColor(new Color(0, 0, 0));
											this.rd.setFont(new Font("Arial", 1, 13));
											this.ftm = this.rd.getFontMetrics();
											if (this.sflk % 4 != 0 || this.sflk == 0)
											this.rd.drawString("Select Stage",
											472 - ((this
												.ftm.stringWidth("Select Stage")) / 2),
											85);
											if (this.sflk != 0)
											this.sflk--;
											int i_163_ = 0;
											(this.gs)
												.sgame.setSize(139, 22);
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 0) {
												i_163_ = (472 - (((
												this.gs)
													.sgame.getWidth() + 6 + (
												(this
													.gs))
													.snfmm.getWidth()) / 2));
												this.sgflag = 0;
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 1) {
												i_163_ = (472 - (((
												this.gs)
													.sgame.getWidth() + 6 + (
												(this
													.gs))
													.snfm1.getWidth()) / 2));
												this.sgflag = 1;
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 2) {
												i_163_ = (472 - (((
												this.gs)
													.sgame.getWidth() + 6 + (
												(this
													.gs))
													.snfm2.getWidth()) / 2));
												this.sgflag = 2;
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 3) {
												(
												this.gs)
													.mstgs.setSize(338, 22);
												if (this.sgflag != 3) {
													this.gstage = 0;
													if ((
													this.xt)
														.logged) {
														if ((
														(this
															.cd)).msloaded != 1) {
															(
															this.gs)
																.mstgs.removeAll();
															(
															this.gs)
																.mstgs.add((
															this).rd,
																"Loading your stages now, please wait...");
															(
															this.gs)
																.mstgs.select(0);
															this
																.msload = 1;
														}
													} else {
														(
														this.gs)
															.mstgs.removeAll();
														(
														this.gs)
															.mstgs.add(this.rd,
															"You need to have a full account to access this.");
														(
														this.gs)
															.mstgs.select(0);
														(
														this.cd)
															.msloaded = 0;
													}
													this.sgflag = 3;
												}
												i_163_ = (472 - (((
												this.gs)
													.sgame.getWidth() + 6 + (
												(this
													.gs))
													.mstgs.getWidth()) / 2));
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 4) {
												(
												this.gs)
													.mstgs.setSize(338, 22);
												if (this.sgflag != 4) {
													this.gstage = 0;
													if ((
													this.xt)
														.logged) {
														if ((
														(this
															.cd)).msloaded != 7) {
															(
															this.gs)
																.mstgs.removeAll();
															(
															this.gs)
																.mstgs.add((
															this).rd,
																"Loading your stages now, please wait...");
															(
															this.gs)
																.mstgs.select(0);
															this
																.msload = 7;
														}
													} else {
														(
														this.gs)
															.mstgs.removeAll();
														(
														this.gs)
															.mstgs.add(this.rd,
															"You need to have a full account to access this.");
														(
														this.gs)
															.mstgs.select(0);
														(
														this.cd)
															.msloaded = 0;
													}
													this.sgflag = 4;
												}
												i_163_ = (472 - (((
												this.gs)
													.sgame.getWidth() + 6 + (
												(this
													.gs))
													.mstgs.getWidth()) / 2));
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 5) {
												(
												this.gs)
													.mstgs.setSize(338, 22);
												if (this.sgflag != 5) {
													this.gstage = 0;
													if ((
													this.xt)
														.logged) {
														if ((
														(this
															.cd)).msloaded != 3) {
															(
															this.gs)
																.mstgs.removeAll();
															(
															this.gs)
																.mstgs.add((
															this).rd,
																"Loading your stages now, please wait...");
															(
															this.gs)
																.mstgs.select(0);
															this
																.msload = 3;
														}
													} else {
														(
														this.gs)
															.mstgs.removeAll();
														(
														this.gs)
															.mstgs.add(this.rd,
															"You need to have a full account to access this.");
														(
														this.gs)
															.mstgs.select(0);
														(
														this.cd)
															.msloaded = 0;
													}
													this.sgflag = 5;
												}
												i_163_ = (472 - (((
												this.gs)
													.sgame.getWidth() + 6 + (
												(this
													.gs))
													.mstgs.getWidth()) / 2));
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 6) {
												(
												this.gs)
													.mstgs.setSize(338, 22);
												if (this.sgflag != 6) {
													this.gstage = 0;
													if ((
													this.xt)
														.logged) {
														if ((
														(this
															.cd)).msloaded != 4) {
															(
															this.gs)
																.mstgs.removeAll();
															(
															this.gs)
																.mstgs.add((
															this).rd,
																"Loading your stages now, please wait...");
															(
															this.gs)
																.mstgs.select(0);
															this
																.msload = 4;
														}
													} else {
														(
														this.gs)
															.mstgs.removeAll();
														(
														this.gs)
															.mstgs.add(this.rd,
															"You need to have a full account to access this.");
														(
														this.gs)
															.mstgs.select(0);
														(
														this.cd)
															.msloaded = 0;
													}
													this.sgflag = 6;
												}
												i_163_ = (472 - (((
												this.gs)
													.sgame.getWidth() + 6 + (
												(this
													.gs))
													.mstgs.getWidth()) / 2));
											}
											if (!(
											this.gs)
												.sgame.isShowing()) {
												(
												this.gs)
													.sgame.show();
												this.remstage = 0;
												if (this.loadstage == 0) {
													int i_164_ = (int)(Math.random() * 3.0);
													if (i_164_ == 3) i_164_ = 2;
													(
													this.gs)
														.sgame.select(i_164_);
												}
											}
											(this.gs)
												.sgame.move(i_163_, 105);
											i_163_ += (
											this.gs)
												.sgame.getWidth() + 6;
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 0) {
												if (!(
												this.gs)
													.snfmm.isShowing()) {
													(
													this.gs)
														.snfmm.show();
													if ((this
														.loadstage) == 0)
													(
													this.gs)
														.snfmm.select(0);
												}
												(
												this.gs)
													.snfmm.move(i_163_, 105);
												if ((
												this.gs)
													.snfm1.isShowing())
												(
												this.gs)
													.snfm1.hide();
												if ((
												this.gs)
													.snfm2.isShowing())
												(
												this.gs)
													.snfm2.hide();
												if ((
												this.gs)
													.mstgs.isShowing())
												(
												this.gs)
													.mstgs.hide();
											}
											if (((
											this.gs)
												.sgame.getSelectedIndex() == 0) && (
											this.gs)
												.snfmm.getSelectedIndex() != 0 && (this.gstage != ((
											this.gs)
												.snfmm.getSelectedIndex() + 27))) {
												this.loadstage = ((
												this.gs)
													.snfmm.getSelectedIndex() + 27);
												this.gstage = this.loadstage;
												this.gs.requestFocus();
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 1) {
												if (!(
												this.gs)
													.snfm2.isShowing()) {
													(
													this.gs)
														.snfm2.show();
													if ((this
														.loadstage) == 0)
													(
													this.gs)
														.snfm2.select(0);
												}
												(
												this.gs)
													.snfm2.move(i_163_, 105);
												if ((
												this.gs)
													.snfmm.isShowing())
												(
												this.gs)
													.snfmm.hide();
												if ((
												this.gs)
													.snfm1.isShowing())
												(
												this.gs)
													.snfm1.hide();
												if ((
												this.gs)
													.mstgs.isShowing())
												(
												this.gs)
													.mstgs.hide();
											}
											if (((
											this.gs)
												.sgame.getSelectedIndex() == 1) && (
											this.gs)
												.snfm2.getSelectedIndex() != 0 && (this.gstage != ((
											this.gs)
												.snfm2.getSelectedIndex() + 10))) {
												this.loadstage = ((
												this.gs)
													.snfm2.getSelectedIndex() + 10);
												this.gstage = this.loadstage;
												this.gs.requestFocus();
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 2) {
												if (!(
												this.gs)
													.snfm1.isShowing()) {
													(
													this.gs)
														.snfm1.show();
													if ((this
														.loadstage) == 0)
													(
													this.gs)
														.snfm1.select(0);
												}
												(
												this.gs)
													.snfm1.move(i_163_, 105);
												if ((
												this.gs)
													.snfmm.isShowing())
												(
												this.gs)
													.snfmm.hide();
												if ((
												this.gs)
													.snfm2.isShowing())
												(
												this.gs)
													.snfm2.hide();
												if ((
												this.gs)
													.mstgs.isShowing())
												(
												this.gs)
													.mstgs.hide();
											}
											if (((
											this.gs)
												.sgame.getSelectedIndex() == 2) && (
											this.gs)
												.snfm1.getSelectedIndex() != 0 && (this.gstage != ((
											this.gs)
												.snfm1.getSelectedIndex()))) {
												this.loadstage = (
												this.gs)
													.snfm1.getSelectedIndex();
												this.gstage = this.loadstage;
												this.gs.requestFocus();
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() == 3) {
												if (!(
												this.gs)
													.mstgs.isShowing()) {
													(
													this.gs)
														.mstgs.show();
													if ((this
														.loadstage) == 0)
													(
													this.gs)
														.mstgs.select(0);
												}
												(
												this.gs)
													.mstgs.move(i_163_, 105);
												if ((
												this.gs)
													.snfmm.isShowing())
												(
												this.gs)
													.snfmm.hide();
												if ((
												this.gs)
													.snfm1.isShowing())
												(
												this.gs)
													.snfm1.hide();
												if ((
												this.gs)
													.snfm2.isShowing())
												(
												this.gs)
													.snfm2.hide();
											}
											if (this.remstage != 2) {
												if (((
												this.gs)
													.sgame.getSelectedIndex() == 3) && ((
												this.gs)
													.mstgs.getSelectedIndex() != 0)) {
													if (this.gstage != ((
													this.gs)
														.mstgs.getSelectedIndex()) + 100) {
														this
															.loadstage = ((
														(this
															.gs))
															.mstgs.getSelectedIndex()) + 100;
														this.gstage = (this
															.loadstage);
														this.gs.requestFocus();
														this.remstage = 0;
													}
													if ((this
														.loadstage) <= 0 && (this
														.remstage) == 0 && (this
														.xt.drawcarb(true, null, "X",
													674, 136, i,
													i_99_, bool)))
													this.remstage = 1;
												} else if ((this
													.remstage) != 0)
												this.remstage = 0;
											}
											if ((
											this.gs)
												.sgame.getSelectedIndex() >= 4) {
												if (!(
												this.gs)
													.mstgs.isShowing()) {
													(
													this.gs)
														.mstgs.show();
													if ((this
														.loadstage) == 0)
													(
													this.gs)
														.mstgs.select(0);
												}
												(
												this.gs)
													.mstgs.move(i_163_, 105);
												if ((
												this.gs)
													.snfmm.isShowing())
												(
												this.gs)
													.snfmm.hide();
												if ((
												this.gs)
													.snfm1.isShowing())
												(
												this.gs)
													.snfm1.hide();
												if ((
												this.gs)
													.snfm2.isShowing())
												(
												this.gs)
													.snfm2.hide();
											}
											if (((
											this.gs)
												.sgame.getSelectedIndex() >= 4) && (
											this.gs)
												.mstgs.getSelectedIndex() != 0 && (this.gstage != ((
											this.gs)
												.mstgs.getSelectedIndex() + 100))) {
												this.loadstage = ((
												this.gs)
													.mstgs.getSelectedIndex() + 100);
												this.gstage = this.loadstage;
												this.gs.requestFocus();
											}
											if (this.loadstage > 0 && (this.remstage == 0)) {
												this.rd.setColor(new Color(0, 0, 0));
												this.rd.setFont(new Font("Arial", 1, 12));
												this.ftm = this.rd.getFontMetrics();
												this.rd.drawString("Loading stage, please wait...", (472 - ((this
													.ftm.stringWidth("Loading Stage, please wait...")) / 2)),
												165);
											}
											if (((
											this.gs)
												.sgame.getSelectedIndex() >= 3) && !((
											this.xt)
												.logged)) {
												this.rd.setColor(new Color(0, 0, 0));
												this.rd.setFont(new Font("Arial", 1, 12));
												this.ftm = this.rd.getFontMetrics();
												this.rd.drawString("You are currently using a trial account.", (472 - ((this
													.ftm.stringWidth("You are currently using a trial account.")) / 2)),
												155);
												this.rd.drawString("You need to upgrade your account to access and publish custom stages!", (472 - ((this
													.ftm.stringWidth("You need to upgrade your account to access and publish custom stages!")) / 2)),
												175);
												this.rd.setColor(color2k(200, 200, 200));
												this.rd.fillRoundRect(382, 185, 180, 50, 20,
												20);
												drawSbutton((
												(this
													.xt)).upgrade,
												472, 210);
												if ((
												this.gs)
													.slaps.isShowing())
												(
												this.gs)
													.slaps.hide();
											} else {
												if ((this.loadstage < 0) && (this.remstage == 0)) {
													this.rd.setColor(new Color(0, 0, 0));
													this.rd.setFont(new Font("Arial", 1,
													12));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.drawString(new StringBuilder().append("").append(this
														.gstagename)
														.append("  -  Laps:              ")
														.toString(), (472 - (this
														.ftm.stringWidth(new StringBuilder().append("").append((
													this)
														.gstagename)
														.append("  -  Laps:              ")
														.toString())) / 2),
													155);
													if (!(
													this.gs)
														.slaps.isShowing()) {
														(
														this.gs)
															.slaps.show();
														(
														this.gs)
															.slaps.select((this
															.gstagelaps) - 1);
													}
													(
													this.gs)
														.slaps.move((472 + (this
														.ftm.stringWidth(new StringBuilder().append("").append((
													this)
														.gstagename)
														.append("  -  Laps:              ")
														.toString())) / 2 - 35),
													138);
													if ((
													this.gs)
														.slaps.getSelectedIndex() != (this
														.gstagelaps) - 1) {
														this
															.gstagelaps = ((
														(this
															.gs))
															.slaps.getSelectedIndex()) + 1;
														this.gs.requestFocus();
													}
													stringbutton("    Preview Stage    ",
													472, 185, 2);
												} else if ((
												this.gs)
													.slaps.isShowing())
												(
												this.gs)
													.slaps.hide();
												if (this.remstage == 3) {
													if ((this
														.loadstage) < 0) stringbutton("    Preview Stage    ",
													472, -160, 2);
													this.rd.setColor(new Color(0, 0, 0));
													this.rd.setFont(new Font("Arial", 1,
													13));
													this.ftm = (this
														.rd.getFontMetrics());
													this.xt.drawlprom(135, 75);
													this.rd.drawString("Failed to remove stage, server error, please try again later.", (472 - ((this
														.ftm.stringWidth("Failed to remove stage, server error, please try again later.")) / 2)),
													155);
													if (this.xt.drawcarb(true, null, " OK ",
													451, 175, i, i_99_,
													bool)) {
														this.remstage = 0;
														(
														this.gs)
															.mouses = 0;
													}
												}
												if (this.remstage == 2) {
													if ((this
														.loadstage) < 0) stringbutton("    Preview Stage    ",
													472, -160, 2);
													this.rd.setColor(new Color(0, 0, 0));
													this.rd.setFont(new Font("Arial", 1,
													13));
													this.ftm = (this
														.rd.getFontMetrics());
													this.xt.drawlprom(135, 75);
													this.rd.drawString("Removing stage from your account...", (472 - ((this
														.ftm.stringWidth("Removing stage from your account...")) / 2)),
													175);
													if (((
													this.cd)
														.staction) == 0) {
														this.gstage = 0;
														this
															.loadstage = 0;
														this.remstage = 0;
													}
													if (((
													this.cd)
														.staction) == -1) {
														this.remstage = 3;
														(
														this.gs)
															.mouses = 0;
													}
												}
												if (this.remstage == 1) {
													if ((this
														.loadstage) < 0) stringbutton("    Preview Stage    ",
													472, -160, 2);
													this.xt.drawlprom(135, 75);
													this.rd.setColor(new Color(0, 0, 0));
													this.rd.setFont(new Font("Arial", 1,
													13));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.drawString("Remove this stage from your account?", (472 - ((this
														.ftm.stringWidth("Remove this stage from your account?")) / 2)),
													155);
													if (this.xt.drawcarb(true, null, " Yes ",
													426, 175, i, i_99_,
													bool)) {
														this.remstage = 2;
														(
														this.cd)
															.onstage = ((
														(this
															.gs))
															.mstgs.getSelectedItem());
														(
														this.cd)
															.staction = 1;
														this.cd.sparkstageaction();
														(
														this.gs)
															.mouses = 0;
													}
													if (this.xt.drawcarb(true, null, " No ",
													480, 175, i, i_99_,
													bool)) {
														this.remstage = 0;
														(
														this.gs)
															.mouses = 0;
													}
												}
												stringbutton("   Next >   ",
												472, 235, 1);
											}
										} else {
											if (!this.inwab) {
												(
												this.gs)
													.sgame.hide();
												(
												this.gs)
													.mstgs.hide();
												(
												this.gs)
													.slaps.hide();
												(
												this.gs)
													.snfm1.hide();
												(
												this.gs)
													.snfmm.hide();
												(
												this.gs)
													.snfm2.hide();
											}
											if (!(
											this.xt)
												.clan.equals("")) {
												if (!this.inwab) {
													this.rd.setColor(new Color(0, 0, 0));
													this.rd.setFont(new Font("Arial", 1,
													12));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.drawString("Loading your clan's wars and battles, please wait...", (472 - ((this
														.ftm.stringWidth("Loading your clan's wars and battles, please wait...")) / 2)),
													155);
													this.loadwarb = true;
													this.warbsel = 0;
													this.cancreate = 0;
												} else {
													if (!(
													this.gs)
														.warb.isShowing())
													(
													this.gs)
														.warb.show();
													(
													this.gs)
														.warb.move(472 - (
													((
													(
													this).gs)
														.warb)).w / 2,
													105);
													if ((
													((
													this.gs)
														.warb)).sel != 0) {
														if ((
														(
														(this
															.gs)).warb).sel != (this
															.warbsel)) {
															(
															this.gb)
																.loadwbgames = 1;
															this
																.rd.setColor(new Color(0,
															0,
															0));
															this
																.rd.setFont(new Font("Arial", 1,
															12));
															this.ftm = ((
															this)
																.rd.getFontMetrics());
															this
																.rd.drawString("Loading scheduled games, please wait...", (472 - (((
															this)
																.ftm.stringWidth("Loading scheduled games, please wait...")) / 2)),
															165);
															this
																.warbsel = (
															((
															(
															this).gs)
																.warb)).sel;
															(
															(
															(this
																.gs)).vnpls).sel = 0;
															(
															(
															(this
																.gs)).vtyp).sel = 0;
															this
																.pgamesel = 0;
															this
																.cancreate = 0;
														} else {
															if (((
															(
															this).gb)
																.loadwbgames) == 7) {
																this
																	.rd.setColor(new Color(0, 0,
																0));
																this
																	.rd.setFont(new Font("Arial",
																1, 12));
																this
																	.ftm = ((
																this)
																	.rd.getFontMetrics());
																this
																	.rd.drawString("Redoing last game, please wait...", (472 - ((
																this)
																	.ftm.stringWidth("Redoing last game, please wait...") / 2)),
																155);
															}
															if (((
															(
															this).gb)
																.loadwbgames) == 2) {
																this
																	.rd.setColor(new Color(0, 0,
																0));
																this
																	.rd.setFont(new Font("Arial",
																1, 12));
																this
																	.ftm = ((
																this)
																	.rd.getFontMetrics());
																if ((
																(
																this).gs)
																	.wgame.getSelectedIndex() == 1) {
																	(
																	this)
																		.rd.drawString(new StringBuilder()
																		.append("[ ")
																		.append((
																	this.gb)
																		.gameturndisp)
																		.append(" ]")
																		.toString(), (472 - (
																	this).ftm.stringWidth(new StringBuilder().append("[ ").append((this.gb).gameturndisp).append(" ]").toString()) / 2),
																	155);
																	bool_162_ = true;
																	int i_165_ = (472 - ((
																	(this.gs).vnpls).w + ((this.gs).vtyp).w + 10) / 2);
																	(
																	(
																	this).gs)
																		.vnpls.move(i_165_,
																	168);
																	i_165_ += (
																	(
																	(
																	this).gs).vnpls).w + 10;
																	(
																	(
																	this).gs)
																		.vtyp.move(i_165_,
																	168);
																	if (!(
																	((
																	this)
																		.gb))
																		.lwbwinner.toLowerCase()
																		.equals((
																	(
																	this).xt)
																		.clan.toLowerCase())) {
																		if ((
																		(
																		(
																		this).gs).vnpls).sel != 0) {
																			if (this.pgamesel != -((this.gs).vnpls).sel) {
																				this.gstagename = (this.gb).wbstages[(this.gb).gameturn];
																				this.cancreate = 0;
																				this.pgamesel = -((this.gs).vnpls).sel;
																			}
																			if (this.cancreate == 1)
																			this.cancreate = 2;
																			if (this.cancreate == 0) {
																				if ((this.gb).wbstage[(this.gb).gameturn] == 101)
																				this.cancreate = 2;
																				else {
																					this.loadstage = (this.gb).wbstage[(this.gb).gameturn];
																					this.cancreate = 1;
																				}
																			}
																			if (this.cancreate == 1)
																			this.rd.drawString("Loading...", 472 - this.ftm.stringWidth("Loading...") / 2, 235);
																			if (this.cancreate == 2) stringbutton("   Create Game   ", 472, 235, 1);
																		}
																	} else {
																		if ((
																		this).sflk != 0)
																		(
																		this).sflk--;
																		else {
																			(
																			this).sflk = 4;
																			(
																			this).rd.setColor(new Color(117, 67, 0));
																		}
																		(
																		this)
																			.rd.drawString(new StringBuilder().append("Your clan won the last game.  ").append((this.gb).vclan).append(" must create this game!").toString(),
																		472 - this.ftm.stringWidth(new StringBuilder().append("Your clan won the last game.  ").append((this.gb).vclan).append(" must create this game!").toString()) / 2,
																		211);
																	}
																	if ((
																	((
																	this)
																		.gb))
																		.canredo) stringbutton(" Redo last game  < ",
																	644,
																	242,
																	1);
																}
																if ((
																(
																this).gs)
																	.wgame.getSelectedIndex() == 2) {
																	bool_161_ = true;
																	(
																	(
																	this).gs)
																		.pgame.move((472 - (
																	(
																	(
																	this).gs).pgame).w / 2),
																	150);
																	if ((
																	((
																	(
																	this).gs)
																		.pgame)).sel != 0) {
																		if ((
																		this).pgamesel != ((this.gs).pgame).sel) {
																			(
																			this).gstagename = (this.gb).wbstages[((this.gs).pgame).sel - 1];
																			(
																			this).cancreate = 0;
																			(
																			this).pgamesel = ((this.gs).pgame).sel;
																		}
																		if ((
																		this).cancreate == 1)
																		(
																		this).cancreate = 2;
																		if ((
																		this).cancreate == 0) {
																			if ((this.gb).wbstage[((this.gs).pgame).sel - 1] == 101)
																			this.cancreate = 2;
																			else {
																				this.loadstage = (this.gb).wbstage[((this.gs).pgame).sel - 1];
																				this.cancreate = 1;
																			}
																		}
																		if ((
																		this).cancreate == 1)
																		(
																		this).rd.drawString("Loading...", 472 - this.ftm.stringWidth("Loading...") / 2, 235);
																		if ((
																		this).cancreate == 2) stringbutton("   Create Practice Game   ", 472, 235, 1);
																	}
																}
															}
															if (((
															(
															this).gb)
																.loadwbgames) == 3)
															this
																.rd.drawString("Failed to load scheduled games, please try again later...", (472 - ((
															this)
																.ftm.stringWidth("Failed to load scheduled games, please try again later...") / 2)),
															165);
															if (((
															(
															this).gb)
																.loadwbgames) == 4)
															this
																.rd.drawString("This war or battle was not found, it may have been expired.", (472 - ((
															this)
																.ftm.stringWidth("This war or battle was not found, it may have been expired.") / 2)),
															165);
															if (((
															(
															this).gb)
																.loadwbgames) == 6)
															this
																.rd.drawString("Failed to undo the last game, please try again later...", (472 - ((
															this)
																.ftm.stringWidth("Failed to undo the last game, please try again later...") / 2)),
															165);
														}
													}
												}
											} else {
												this.rd.setColor(new Color(0, 0, 0));
												this.rd.setFont(new Font("Arial", 1, 12));
												this.ftm = this.rd.getFontMetrics();
												this.rd.drawString("You must join a clan first to play wars and battles!", (472 - ((this
													.ftm.stringWidth("You must join a clan first to play wars and battles!")) / 2)),
												145);
												stringbutton("    Find a clan to join    ",
												472, 185, 2);
											}
											if (!this.inwab)
											this.inwab = true;
										}
										if (bool_161_)
										(this.gs)
											.pgame.show();
										else(this.gs)
											.pgame.hide();
										if (bool_162_) {
											(this.gs)
												.vnpls.show();
											(this.gs)
												.vtyp.show();
										} else {
											(this.gs)
												.vnpls.hide();
											(this.gs)
												.vtyp.hide();
										}
									}
									if (this.chalngd == -3) {
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 1, 13));
										this.ftm = this.rd.getFontMetrics();
										if (this.sflk % 4 != 0 || this.sflk == 0)
										this.rd.drawString("Select Number of Players", (472 - ((this.ftm.stringWidth("Select Number of Players")) / 2)),
										85);
										if (this.sflk != 0)
										this.sflk--;
										int i_166_ = 0;
										if ((this.xt)
											.lan) i_166_ = 59;
										this.rd.drawString("Players", 413 - i_166_, 122);
										if (!(this.gs)
											.snpls.isShowing()) {
											(this.gs)
												.snpls.show();
											(this.gs)
												.snpls.select(this.gnpls - 1);
										}
										(this.gs)
											.snpls.move(467 - i_166_, 105);
										boolean bool_167_ = false;
										if ((this.gs)
											.snpls.getSelectedIndex() != 0 && ((
										this.gs)
											.snpls.getSelectedIndex() != this.gnpls - 1)) {
											this.gnpls = (
											this.gs)
												.snpls.getSelectedIndex() + 1;
											bool_167_ = true;
											(this.gs)
												.swait.hide();
										}
										if ((this.xt)
											.lan) {
											this.rd.drawString("Bots", 490, 122);
											if (!(
											this.gs)
												.snbts.isShowing()) {
												(
												this.gs)
													.snbts.show();
												(
												this.gs)
													.snbts.select(0);
												//this.gnbts = 0;
											}
											(this.gs)
												.snbts.move(524, 105);
											if (((
											this.gs)
												.snbts.getSelectedIndex() != this.gnbts) || bool_167_) {
												for (this.gnbts = ((
												this.gs)
													.snbts.getSelectedIndex());
												((this.gnbts + this.gnpls) > 8);
												this.gnbts--) {
													/* empty */
												}
												(
												this.gs)
													.snbts.select(this.gnbts);
											}
										}
										this.rd.drawString("Wait",
										414, 162);
										if (!(this.gs)
											.swait.isShowing()) {
											(this.gs)
												.swait.show();
											if (this.gwait == 0)
											(
											this.gs)
												.swait.select(1);
										}
										(this.gs)
											.swait.move(451, 145);
										if (((this.gs)
											.swait.getSelectedIndex() + 1) * 60 != this.gwait)
										this.gwait = ((
										this.gs)
											.swait.getSelectedIndex() + 1) * 60;
										this.rd.setColor(color2k(90, 90, 90));
										this.rd.setFont(new Font("Arial", 0, 11));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString("(Maximum time to wait for all players to `join. )", (472 - ((this.ftm.stringWidth("(Maximum time to wait for all players to join. )")) / 2)),
										179);
										stringbutton("   < Back   ", 422, 235,
										1);
										stringbutton("   Next >   ", 522, 235,
										1);
									}
									if (this.chalngd == -4) {
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 1, 13));
										this.ftm = this.rd.getFontMetrics();
										if (this.sflk % 4 != 0 || this.sflk == 0)
										this.rd.drawString("Game Options",
										472 - (this.ftm.stringWidth("Game Options")) / 2,
										85);
										if (this.sflk != 0)
										this.sflk--;
										int i_168_ = 472 - ((
										this.gs)
											.scars.getWidth() + (
										this.gs)
											.sclass.getWidth() + (
										this.gs)
											.sfix.getWidth() + 16) / 2;
										if (!(this.gs)
											.scars.isShowing()) {
											(this.gs)
												.scars.show();
											if (this.gcars >= 0 && this.gcars <= 2)
											(
											this.gs)
												.scars.select(this.gcars);
											else(
											this.gs)
												.scars.select(0);
										}
										(this.gs)
											.scars.move(i_168_, 105);
										i_168_ += (
										this.gs)
											.scars.getWidth() + 8;
										if (!(this.gs)
											.sclass.isShowing()) {
											(this.gs)
												.sclass.show();
											if (this.gclass >= 0 && this.gclass <= 5)
											(
											this.gs)
												.sclass.select(this.gclass);
											else(
											this.gs)
												.sclass.select(0);
										}
										(this.gs)
											.sclass.move(i_168_, 105);
										i_168_ += (
										this.gs)
											.sclass.getWidth() + 8;
										if (!(this.gs)
											.sfix.isShowing()) {
											(this.gs)
												.sfix.show();
											if (this.gfix >= 0 && this.gfix <= 5)
											(
											this.gs)
												.sfix.select(this.gfix);
											else(
											this.gs)
												.sfix.select(0);
										}
										(this.gs)
											.sfix.move(i_168_, 105);
										i_168_ += (
										this.gs)
											.sfix.getWidth();
										if (!(this.gs)
											.openm)
										this.gs.movefield((
										this.gs).notp,
										i_168_ - 112, 131, 150, 17);
										else this.gs.movefield((
										this.gs).notp,
										i_168_ - 112, -2000, 150, 17);
										if (!(this.gs)
											.notp.isShowing()) {
											(this.gs)
												.notp.show();
											if (this.gnotp == 0)
											(
											this.gs)
												.notp.setState(false);
											else(
											this.gs)
												.notp.setState(true);
										}
										if (((this.xt)
											.sc[0]) < 16) {
											if (!(
											this.gs).openm)
											this.gs.movefield((
											this.gs).mycar, (472 - ((
											this.gs)
												.scars.getWidth() + (
											this.gs)
												.sclass.getWidth() + (
											this.gs)
												.sfix.getWidth() + 16) / 2),
											131, 150, 17);
											else this.gs.movefield((
											this.gs).mycar,
											410, -2000, 150, 17);
											if (!(
											this.gs)
												.mycar.isShowing()) {
												(
												this.gs)
													.mycar.show();
												(
												this.gs)
													.mycar.setLabel(new StringBuilder().append("").append((
												this.cd)
													.names[((
												this.xt)
													.sc[0])])
													.append(" Game!")
													.toString());
												if (this.gclass <= -2)
												(
												this.gs)
													.mycar.setState(true);
												else(
												this.gs)
													.mycar.setState(false);
											}
										} else if ((
										this.gs)
											.mycar.getState())
										(this.gs)
											.mycar.setState(false);
										if ((this.gs)
											.mycar.getState()) {
											if ((
											this.gs)
												.sclass.isEnabled())
											(
											this.gs)
												.sclass.disable();
											if ((
											this.gs)
												.scars.isEnabled())
											(
											this.gs)
												.scars.disable();
										} else {
											if (!(
											this.gs)
												.sclass.isEnabled())
											(
											this.gs)
												.sclass.enable();
											if (!(
											this.gs)
												.scars.isEnabled())
											(
											this.gs)
												.scars.enable();
											if ((
											this.gs)
												.sclass.getSelectedIndex() != this.gclass) {
												this.gclass = (
												this.gs)
													.sclass.getSelectedIndex();
												(
												this.gs)
													.mycar.hide();
											}
											if ((
											this.gs)
												.scars.getSelectedIndex() != this.gcars)
											this.gcars = (
											this.gs)
												.scars.getSelectedIndex();
										}
										if ((this.gs)
											.sfix.getSelectedIndex() != this.gfix)
										this.gfix = (
										this.gs)
											.sfix.getSelectedIndex();
										String string = "Public Game, anyone can join...";
										int i_169_ = 0;
										for (int i_170_ = 0; i_170_ < 7;
										i_170_++) {
											if (!this.invos[i_170_].equals("")) i_169_++;
										}
										if (i_169_ > 0) {
											string = "Players Allowed:  ";
											int i_171_ = 0;
											for (int i_172_ = 0; i_172_ < 7;
											i_172_++) {
												if (!this.invos[i_172_].equals("")) {
													string = new StringBuilder().append(string).append(this
														.invos[i_172_])
														.toString();
													if (++i_171_ != i_169_) {
														if (i_171_ == i_169_ - 1) string = new StringBuilder().append(string)
															.append(" and ")
															.toString();
														else string = (new StringBuilder()
															.append(string)
															.append(", ")
															.toString());
													}
												}
											}
										}
										this.rd.setColor(new Color(0, 0, 0));
										if (i_169_ < this.gnpls - 1) {
											this.rd.setFont(new Font("Arial", 1, 13));
											this.rd.drawString(new StringBuilder().append("Private Game, only specific players allowed to join?  ")
												.append(i_169_).append("/").append(this.gnpls - 1)
												.append("").toString(),
											330, 180);
											stringbutton("<   Select   ", 281,
											180, 2);
											this.rd.setFont(new Font("Tahoma", 0, 11));
											this.ftm = this.rd.getFontMetrics();
											this.rd.drawString(string, (472 - (this.ftm.stringWidth(string) / 2)),
											203);
										} else {
											this.rd.setFont(new Font("Arial", 1, 13));
											this.ftm = this.rd.getFontMetrics();
											this.rd.drawString(new StringBuilder().append("").append(i_169_).append(" Allowed Players Selected")
												.toString(), (472 - (this.ftm.stringWidth(new StringBuilder()
												.append("").append(i_169_).append(" Allowed Players Selected")
												.toString())) / 2),
											180);
											this.rd.setFont(new Font("Tahoma", 0, 11));
											this.ftm = this.rd.getFontMetrics();
											this.rd.drawString(string, (472 - (this.ftm.stringWidth(string) / 2)),
											203);
										}
										stringbutton("   < Back   ", 422, 235,
										1);
										stringbutton("   Finish!   ", 522, 235,
										1);
									}
									if (this.chalngd == -5) {
										if (this.fstart)
										this.fstart = false;
										this.rd.setFont(new Font("Arial", 1, 13));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString(this.msg,
										472 - (this.ftm.stringWidth(this.msg)) / 2,
										145);
										if ((this.msg.equals(". . . | Creating Game | . . .")) && this.ncnt == 0) {
											this.msg = "| Creating Game |";
											this.ncnt = 5;
										}
										if ((this.msg.equals(". . | Creating Game | . .")) && this.ncnt == 0) {
											this.msg = ". . . | Creating Game | . . .";
											this.ncnt = 5;
										}
										if ((this.msg.equals(". | Creating Game | .")) && this.ncnt == 0) {
											this.msg = ". . | Creating Game | . .";
											this.ncnt = 5;
										}
										if (this.msg.equals("| Creating Game |") && this.ncnt == 0) {
											this.msg = ". | Creating Game | .";
											this.ncnt = 5;
										}
										if (this.ncnt != 0)
										this.ncnt--;
									}
								}
							}
							if (!(this.xt).lan) {
								this.rd.setColor(color2k(230, 230,
								230));
								this.rd.fillRoundRect(225, 263, 495,
								157, 20, 20);
								this.rd.setColor(new Color(0, 0, 0));
								this.rd.drawRoundRect(225, 263, 495,
								157, 20, 20);
								String[] strings = new String[14];
								String[] strings_173_ = new String[14];
								boolean[] bools = new boolean[14];
								for (int i_174_ = 0; i_174_ < 14; i_174_++) {
									strings[i_174_] = "";
									strings_173_[i_174_] = "";
									bools[i_174_] = false;
								}
								int i_175_ = 0;
								this.rd.setFont(new Font("Tahoma", 0,
								11));
								this.ftm = this.rd.getFontMetrics();
								if (this.updatec != -1) {
									for (int i_176_ = 0; i_176_ < 7;
									i_176_++) {
										strings[i_175_] = "";
										strings_173_[i_175_] = this.cnames[i_176_];
										int i_177_ = 0;
										int i_178_ = 0;
										int i_179_ = 0;
										int i_180_ = 0;
										int i_181_ = 0;
										for (/**/ ;
										i_177_ < this.sentn[i_176_].length();
										i_177_++) {
											String string = new StringBuilder().append("").append(this.sentn[i_176_].charAt(i_177_))
												.toString();
											if (string.equals(" ")) {
												i_178_ = i_179_;
												i_180_ = i_177_;
												i_181_++;
											} else i_181_ = 0;
											if (i_181_ <= 1) {
												StringBuilder stringbuilder = new StringBuilder();
												String[] strings_182_ = strings;
												int i_183_ = i_175_;
												strings_182_[i_183_] = stringbuilder.append(strings_182_[i_183_])
													.append(string).toString();
												i_179_++;
												if ((this.ftm.stringWidth(strings[i_175_])) > 367) {
													if (i_178_ != 0) {
														strings[i_175_] = (strings[i_175_].substring(0, i_178_));
														if (i_175_ == 13) {
															for (int i_184_ = 0;
															i_184_ < 13;
															i_184_++) {
																strings[i_184_] = (strings[(i_184_ + 1)]);
																strings_173_[i_184_] = (strings_173_[(i_184_ + 1)]);
																bools[i_184_] = (bools[(i_184_ + 1)]);
															}
															strings[i_175_] = "";
															bools[i_175_] = true;
														} else {
															i_175_++;
															strings_173_[i_175_] = ((
															this)
																.cnames[i_176_]);
														}
														i_177_ = i_180_;
														i_179_ = 0;
														i_178_ = 0;
													} else {
														strings[i_175_] = "";
														i_179_ = 0;
													}
												}
											}
										}
										if (i_175_ == 13 && i_176_ != 6) {
											for (int i_185_ = 0; i_185_ < 13;
											i_185_++) {
												strings[i_185_] = strings[i_185_ + 1];
												strings_173_[i_185_] = strings_173_[i_185_ + 1];
												bools[i_185_] = bools[i_185_ + 1];
											}
										} else i_175_++;
									}
									i_104_ = (i_175_ - 6) * 15;
									if (i_104_ < 0) i_104_ = 0;
									i_105_ = (int)((float)this.spos3 / 28.0F * (float) i_104_);
									String string = "";
									this.rd.setFont(new Font("Tahoma", 1, 11));
									this.ftm = this.rd.getFontMetrics();
									for (int i_186_ = 0; i_186_ < i_175_;
									i_186_++) {
										if (!string.equals(strings_173_[i_186_])) {
											if ((280 + i_186_ * 15 - i_105_ > 266) && (280 + i_186_ * 15 - i_105_ < 370))
											this.rd.drawString(new StringBuilder().append(strings_173_[i_186_])
												.append(":").toString(),
											320 - (this
												.ftm.stringWidth(new StringBuilder().append(strings_173_[i_186_])
												.append(":")
												.toString())), (305 + i_186_ * 15 - i_105_));
											string = strings_173_[i_186_];
										}
									}
									this.rd.setFont(new Font("Tahoma", 0, 11));
									for (int i_187_ = 0; i_187_ < i_175_;
									i_187_++) {
										if (bools[i_187_] && i_187_ == 0 && (strings[i_187_].indexOf(" ") != -1)) strings[i_187_] = new StringBuilder().append("...").append(strings[i_187_].substring(strings[i_187_].indexOf(" "),
										strings[i_187_].length()))
											.append("").toString();
										if (280 + i_187_ * 15 - i_105_ > 266 && (280 + i_187_ * 15 - i_105_ < 370))
										this.rd.drawString(strings[i_187_], 325,
										305 + i_187_ * 15 - i_105_);
									}
								} else {
									i_104_ = 0;
									boolean bool_188_ = false;
									this.rd.drawString("Loading chat...",
									465 - (this.ftm.stringWidth("Loading chat...")) / 2,
									325);
								}
								this.rd.setColor(color2k(205, 205,
								205));
								this.rd.fillRect(235, 269, 480, 25);
								this.rd.drawImage((
								(this
									.xt)).chat,
								241, 273, null);
								this.rd.setFont(new Font("Arial", 1,
								12));
								this.rd.setColor(color2k(120, 120,
								120));
								this.rd.drawString("(Room Chat )",
								299, 285);
								this.rd.setColor(color2k(150, 150,
								150));
								this.rd.drawLine(235, 291, 696, 291);
								this.rd.setColor(color2k(205, 205,
								205));
								this.rd.fillRect(235, 387, 480, 28);
								this.rd.setColor(color2k(150, 150,
								150));
								this.rd.drawLine(235, 389, 696, 389);
								this.rd.setColor(color2k(205, 205,
								205));
								this.rd.fillRect(698, 311, 17, 59);
								this.rd.setColor(color2k(205, 205,
								205));
								this.rd.fillRect(231, 269, 4, 146);
								if (this.mscro3 == 351 || i_104_ == 0) {
									if (i_104_ == 0)
									this.rd.setColor(color2k(205, 205, 205));
									else this.rd.setColor(color2k(215, 215, 215));
									this.rd.fillRect(698, 294, 17,
									17);
								} else {
									this.rd.setColor(color2k(220, 220, 220));
									this.rd.fill3DRect(698, 294, 17,
									17, true);
								}
								if (i_104_ != 0)
								this.rd.drawImage((this.xt).asu,
								703, 300, null);
								if (this.mscro3 == 352 || i_104_ == 0) {
									if (i_104_ == 0)
									this.rd.setColor(color2k(205, 205, 205));
									else this.rd.setColor(color2k(215, 215, 215));
									this.rd.fillRect(698, 370, 17,
									17);
								} else {
									this.rd.setColor(color2k(220, 220, 220));
									this.rd.fill3DRect(698, 370, 17,
									17, true);
								}
								if (i_104_ != 0)
								this.rd.drawImage((this.xt).asd,
								703, 376, null);
								if (i_104_ != 0) {
									if (this.lspos3 != this.spos3) {
										this.rd.setColor(color2k(215, 215, 215));
										this.rd.fillRect(698, 311 + this.spos3,
										17, 31);
									} else {
										if (this.mscro3 == 141)
										this.rd.setColor(color2k(215, 215, 215));
										this.rd.fill3DRect(698, 311 + this.spos3,
										17, 31, true);
									}
									this.rd.setColor(color2k(150, 150, 150));
									this.rd.drawLine(703, 324 + this.spos3, 709,
									324 + this.spos3);
									this.rd.drawLine(703, 326 + this.spos3, 709,
									326 + this.spos3);
									this.rd.drawLine(703, 328 + this.spos3, 709,
									328 + this.spos3);
									if (this.mscro3 > 342 && (this.lspos3 != this.spos3))
									this.lspos3 = this.spos3;
									if (bool) {
										if (this.mscro3 == 345 && i > 698 && i < 715 && (i_99_ > 311 + this.spos3) && (i_99_ < this.spos3 + 342))
										this.mscro3 = i_99_ - this.spos3;
										if (this.mscro3 == 345 && i > 696 && i < 717 && i_99_ > 292 && i_99_ < 313)
										this.mscro3 = 351;
										if (this.mscro3 == 345 && i > 696 && i < 717 && i_99_ > 368 && i_99_ < 389)
										this.mscro3 = 352;
										if (this.mscro3 == 345 && i > 698 && i < 715 && i_99_ > 311 && i_99_ < 370) {
											this.mscro3 = 326;
											this.spos3 = (i_99_ - this.mscro3);
										}
										int i_189_ = 100 / i_104_;
										if (i_189_ < 1) i_189_ = 1;
										if (this.mscro3 == 351) {
											this.spos3 -= i_189_;
											if (this.spos3 > 28)
											this.spos3 = 28;
											if (this.spos3 < 0)
											this.spos3 = 0;
											this.lspos3 = this.spos3;
										}
										if (this.mscro3 == 352) {
											this.spos3 += i_189_;
											if (this.spos3 > 28)
											this.spos3 = 28;
											if (this.spos3 < 0)
											this.spos3 = 0;
											this.lspos3 = this.spos3;
										}
										if (this.mscro3 <= 342) {
											this.spos3 = (i_99_ - this.mscro3);
											if (this.spos3 > 28)
											this.spos3 = 28;
											if (this.spos3 < 0)
											this.spos3 = 0;
										}
										if (this.mscro3 == 345)
										this.mscro3 = 425;
									} else if (this.mscro3 != 345)
									this.mscro3 = 345;
									if (i_100_ != 0 && i > 235 && i < 698 && i_99_ > 291 && i_99_ < 389) {
										this.spos3 -= i_100_ / 2;
										this.zeromsw = true;
										if (this.spos3 > 28) {
											this.spos3 = 28;
											this.zeromsw = false;
										}
										if (this.spos3 < 0) {
											this.spos3 = 0;
											this.zeromsw = false;
										}
										this.lspos3 = this.spos3;
									}
								}
								this.pre1 = true;
								stringbutton("Send Message", 657, 406, 3);
							}
							if ((this.chalngd == -1 || this.chalngd == -6) && (this.lg).gamec != -1) {
								if ((this.lg).cntgame >= 0 && ((this.lg).cntgame < 10))
								this.rd.setComposite(AlphaComposite.getInstance(3, (float)((this.lg)
									.cntgame) / 10.0F));
								if ((this.lg).cntgame > 390 && ((this.lg).cntgame < 400))
								this.rd.setComposite(AlphaComposite.getInstance(3, (float)(400 - ((
								this.lg)
									.cntgame)) / 10.0F));
								this.rd.setColor(color2k(245, 245,
								245));
								this.rd.fillRoundRect(383, 242, 337,
								46, 20, 20);
								this.rd.setColor(new Color(0, 0, 0));
								this.rd.drawRoundRect(383, 242, 337,
								46, 20, 20);
								this.rd.setFont(new Font("Arial", 1,
								12));
								this.ftm = this.rd.getFontMetrics();
								this.rd.drawString(new StringBuilder().append("").append((this.lg).gmaker)
									.append(" created a game in ").append((this.lg).gservern)
									.append(" :: Room ").append((this.lg).groom)
									.append("").toString(),
								551 - (this.ftm.stringWidth(new StringBuilder().append("")
									.append((this.lg)
									.gmaker)
									.append(" created a game in ").append((this.lg)
									.gservern)
									.append(" :: Room ").append((this.lg)
									.groom)
									.append("").toString())) / 2,
								260);
								if (i > 488 && i < 614 && i_99_ > 264 && i_99_ < 287) {
									if (bool)
									this.grprsd = true;
									else if (this.grprsd) {
										for (int i_190_ = 0;
										(i_190_ < ((this.lg)
											.nservers));
										i_190_++) {
											if ((this.lg)
												.gservern.equals((this.lg)
												.snames[i_190_])) {
												stopallnow();
												(
												this.xt).server = ((
												this.lg)
													.servers[i_190_]);
												(
												this.xt).servername = ((
												this.lg)
													.snames[i_190_]);
												(
												this.xt).servport = 7070 + (
												(this
													.lg)).groom;
												inishlobby();
												break;
											}
										}
										this.grprsd = false;
									}
								} else if (this.grprsd)
								this.grprsd = false;
								if (!this.grprsd) {
									this.rd.setColor(color2k(230, 230, 230));
									this.rd.fill3DRect(490, 266, 122,
									19, true);
									this.rd.setColor(new Color(0, 0,
									0));
								} else {
									this.rd.setColor(color2k(230, 230, 230));
									this.rd.fillRect(490, 266, 122,
									19);
									this.rd.setColor(color2k(60, 60,
									60));
								}
								this.rd.drawString("View / Join Game", (551 - (this.ftm.stringWidth("View / Join Game") / 2)),
								280);
								if (((this.lg).cntgame >= 0 && ((this.lg).cntgame < 10)) || (((this.lg).cntgame > 390) && ((this.lg).cntgame < 400)))
								this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
								(this.lg).cntgame++;
								if ((this.lg).cntgame == 400)
								(this.lg).gamec = -1;
							}
						}
					} else if (this.opengame < 26) {
						int i_191_ = 229 + this.opengame;
						if (i_191_ > 255) i_191_ = 255;
						if (i_191_ < 0) i_191_ = 0;
						this.rd.setColor(color2k(i_191_, i_191_,
						i_191_));
						this.rd.fillRoundRect(225,
						59 - (int)((float)this.opengame * 2.23F),
						495, 200 + this.opengame * 8, 20, 20);
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.drawRoundRect(225,
						59 - (int)((float)this.opengame * 2.23F),
						495, 200 + this.opengame * 8, 20, 20);
						if (!(this.xt).lan) {
							this.rd.setColor(color2k(217, 217, 217));
							this.rd.fillRoundRect(225, 263 + this.opengame * 7, 495,
							157, 20, 20);
							this.rd.setColor(new Color(0, 0, 0));
							this.rd.drawRoundRect(225, 263 + this.opengame * 7, 495,
							157, 20, 20);
						}
						this.btn = 0;
						if (this.prevloaded != -1)
						this.prevloaded = -1;
						if (this.updatec != -1)
						this.updatec = -1;
						if ((this.gs).cmsg.isShowing()) {
							(this.gs).cmsg.hide();
							this.gs.requestFocus();
						}
						if ((this.gs).rooms.isShowing())
						(this.gs).rooms.hide();
						if (this.fstart)
						this.fstart = false;
						for (int i_192_ = 0; i_192_ < 9; i_192_++) {
							if (this.cac[i_192_] != -1)
							this.cac[i_192_] = -1;
						}
						if (this.dispcar != -1)
						this.dispcar = -1;
						this.opengame += 2;
					} else {
						this.rd.setColor(color2k(255, 255, 255));
						this.rd.fillRoundRect(225, 1, 495, 417, 20,
						20);
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.drawRoundRect(225, 1, 495, 417, 20,
						20);
						if ((this.join > -1 && (this.pgames[this.im] != this.join)) || this.join == -2) {
							if (this.join > -1 && (this.pgames[this.im] != this.join)) {
								this.rd.setFont(new Font("Arial", 1,
								13));
								this.ftm = this.rd.getFontMetrics();
								this.rd.drawString(this.msg, (472 - (this.ftm.stringWidth(this.msg) / 2)),
								195);
								if (this.msg.equals(". . . | Joining Game | . . .") && this.ncnt == 0) {
									this.msg = "| Joining Game |";
									this.ncnt = 5;
								}
								if (this.msg.equals(". . | Joining Game | . .") && this.ncnt == 0) {
									this.msg = ". . . | Joining Game | . . .";
									this.ncnt = 5;
								}
								if (this.msg.equals(". | Joining Game | .") && this.ncnt == 0) {
									this.msg = ". . | Joining Game | . .";
									this.ncnt = 5;
								}
								if (this.msg.equals("| Joining Game |") && this.ncnt == 0) {
									this.msg = ". | Joining Game | .";
									this.ncnt = 5;
								}
								if (this.ncnt != 0)
								this.ncnt--;
							}
							if (this.join == -2) {
								this.rd.setFont(new Font("Arial", 1,
								13));
								this.ftm = this.rd.getFontMetrics();
								this.rd.drawString(this.msg, (472 - (this.ftm.stringWidth(this.msg) / 2)),
								195);
								if (this.msg.equals(". . . | Leaving Game | . . .") && this.ncnt == 0) {
									this.msg = "| Leaving Game |";
									this.ncnt = 5;
								}
								if (this.msg.equals(". . | Leaving Game | . .") && this.ncnt == 0) {
									this.msg = ". . . | Leaving Game | . . .";
									this.ncnt = 5;
								}
								if (this.msg.equals(". | Leaving Game | .") && this.ncnt == 0) {
									this.msg = ". . | Leaving Game | . .";
									this.ncnt = 5;
								}
								if (this.msg.equals("| Leaving Game |") && this.ncnt == 0) {
									this.msg = ". | Leaving Game | .";
									this.ncnt = 5;
								}
								if (this.ncnt != 0)
								this.ncnt--;
							}
							if ((this.gs).cmsg.isShowing()) {
								(this.gs).cmsg.hide();
								this.gs.requestFocus();
							}
						} else {
							int i_193_ = 0;
							for (int i_194_ = 0; i_194_ < this.ngm;
							i_194_++) {
								if (this.ongame == this.gnum[i_194_]) i_193_ = i_194_;
							}
							this.rd.setFont(new Font("Arial", 1,
							11));
							this.ftm = this.rd.getFontMetrics();
							this.rd.setColor(new Color(0, 0, 0));
							int i_195_ = 23;
							int i_196_ = 0;
							if (this.gwarb[i_193_] != 0) {
								i_195_ = 28;
								i_196_ = 2;
								String string = "Clan war";
								if (this.gwarb[i_193_] == 2) string = "Car battle";
								if (this.gwarb[i_193_] == 3) string = "Stage battle";
								this.rd.drawString(new StringBuilder().append("").append(string).append(" between ").append(this.gaclan[i_193_]).append(" and ").append(this.gvclan[i_193_]).append("").toString(),
								243, 14);
							}
							String string = "";
							String string_197_ = "";
							String string_198_ = "";
							if (this.conon == 1) {
								if (this.wait[i_193_] > 0) {
									if (this.gwarb[i_193_] == 0) {
										String string_199_ = "";
										if (this.gplyrs[i_193_].equals("")) string_199_ = "Public Game";
										else string_199_ = "Private Game";
										if (this.gfx[i_193_] == 1) string_199_ = new StringBuilder().append(string_199_).append(" | 4 Fixes")
											.toString();
										if (this.gfx[i_193_] == 2) string_199_ = new StringBuilder().append(string_199_).append(" | 3 Fixes")
											.toString();
										if (this.gfx[i_193_] == 3) string_199_ = new StringBuilder().append(string_199_).append(" | 2 Fixes")
											.toString();
										if (this.gfx[i_193_] == 4) string_199_ = new StringBuilder().append(string_199_).append(" | 1 Fix").toString();
										if (this.gfx[i_193_] == 5) string_199_ = new StringBuilder().append(string_199_).append(" | No Fixing")
											.toString();
										String string_200_ = "";
										if (this.gclss[i_193_] > -2) {
											if (this.gcrs[i_193_] == 1) string_200_ = "Custom Cars";
											if (this.gcrs[i_193_] == 2) string_200_ = "Game Cars";
											String string_201_ = "";
											if (this.gclss[i_193_] == 1) string_201_ = "Class C";
											if (this.gclss[i_193_] == 2) string_201_ = "Class B & C";
											if (this.gclss[i_193_] == 3) string_201_ = "Class B";
											if (this.gclss[i_193_] == 4) string_201_ = "Class A & B";
											if (this.gclss[i_193_] == 5) string_201_ = "Class A";
											if (!string_200_.equals("") && !string_201_.equals("")) string_200_ = new StringBuilder()
												.append(string_200_).append(" | ").append(string_201_)
												.toString();
											else string_200_ = new StringBuilder()
												.append(string_200_).append(string_201_)
												.toString();
										} else string_200_ = new StringBuilder().append("").append((
										this.cd)
											.names[Math.abs(((
										this)
											.gclss[i_193_]) + 2)])
											.append("").toString();
										if (string_200_.equals("")) {
											this.rd.drawString("Type:", 243, 23);
											this.rd.setColor(new Color(80, 128, 0));
											this.rd.drawString(string_199_, 279, 23);
										} else {
											this.rd.drawString("Type:", 243, 14);
											this.rd.drawString("Cars:", 244, 28);
											this.rd.setColor(new Color(80, 128, 0));
											this.rd.drawString(string_199_, 279, 14);
											this.rd.drawString(string_200_, 279, 28);
										}
									} else {
										String string_202_ = new StringBuilder().append("Game #").append(this.gameturn[i_193_])
											.append("").toString();
										if (this.gcrs[i_193_] == 1) string_202_ = new StringBuilder().append(string_202_).append(" | Clan Cars")
											.toString();
										if (this.gcrs[i_193_] == 2) string_202_ = new StringBuilder().append(string_202_).append(" | Game Cars")
											.toString();
										if (this.gclss[i_193_] == 1) string_202_ = new StringBuilder().append(string_202_).append(" | Class C")
											.toString();
										if (this.gclss[i_193_] == 2) string_202_ = new StringBuilder().append(string_202_).append(" | Class B & C")
											.toString();
										if (this.gclss[i_193_] == 3) string_202_ = new StringBuilder().append(string_202_).append(" | Class B")
											.toString();
										if (this.gclss[i_193_] == 4) string_202_ = new StringBuilder().append(string_202_).append(" | Class A & B")
											.toString();
										if (this.gclss[i_193_] == 5) string_202_ = new StringBuilder().append(string_202_).append(" | Class A")
											.toString();
										if (this.gfx[i_193_] == 1) string_202_ = new StringBuilder().append(string_202_).append(" | 4 Fixes")
											.toString();
										if (this.gfx[i_193_] == 2) string_202_ = new StringBuilder().append(string_202_).append(" | 3 Fixes")
											.toString();
										if (this.gfx[i_193_] == 3) string_202_ = new StringBuilder().append(string_202_).append(" | 2 Fixes")
											.toString();
										if (this.gfx[i_193_] == 4) string_202_ = new StringBuilder().append(string_202_).append(" | 1 Fix").toString();
										if (this.gfx[i_193_] == 5) string_202_ = new StringBuilder().append(string_202_).append(" | No Fixing")
											.toString();
										this.rd.setColor(new Color(80, 128, 0));
										this.rd.drawString(string_202_, 243, 28);
									}
								}
								if (this.wait[i_193_] == 0) {
									this.rd.drawString("Status:",
									241 + i_196_,
									i_195_);
									this.rd.setColor(new Color(128, 73, 0));
									if (this.prevloaded == 0)
									this.rd.drawString("Starting...", 286 + i_196_,
									i_195_);
									else this.rd.drawString("Started", 286 + i_196_, i_195_);
								}
								if (this.wait[i_193_] == -1) {
									this.rd.drawString("Status:",
									241 + i_196_,
									i_195_);
									this.rd.setColor(color2k(100, 100, 100));
									this.rd.drawString("Finished",
									286 + i_196_,
									i_195_);
								}
							} else {
								this.rd.drawString("Status:",
								241 + i_196_,
								i_195_);
								this.rd.setColor(new Color(128, 73,
								0));
								this.rd.drawString("Starting...",
								286 + i_196_,
								i_195_);
							}
							if (this.gwarb[i_193_] == 0) {
								this.rd.setColor(new Color(0, 0, 0));
								if (this.gmaker[i_193_].equals(this.pnames[this.im]))
								this.rd.drawString("Created by You", 449, 23);
								else {
									this.rd.drawString("Created by",
									449, 23);
									this.rd.drawString(":", 511, 23);
									this.rd.drawString(((
									this)
										.gmaker[i_193_]),
									520, 23);
								}
							} else if (this.wait[i_193_] == 0 || this.wait[i_193_] == -1 || this.conon != 1) {
								this.rd.setColor(color2k(200, 200,
								200));
								this.rd.drawRect(349, 16, 253, 16);
								this.rd.setFont(new Font("Arial", 0,
								11));
								this.ftm = this.rd.getFontMetrics();
								this.rd.setColor(new Color(0, 0, 0));
								int i_203_ = 0;
								int i_204_ = 0;
								if (this.wait[i_193_] == -1) {
									String[] strings = {
										"", "", "", "", "", "", "", ""
									};
									for (int i_205_ = 0;
									i_205_ < this.prnpo;
									i_205_++) {
										for (int i_206_ = 0;
										i_206_ < this.npo;
										i_206_++) {
											if ((this.prnames[i_205_].equals(this.pnames[i_206_])) && ((this.pgames[i_206_]) == (this.gnum[i_193_]))) strings[i_205_] = (this.pclan[i_206_]);
										}
									}
									for (int i_207_ = 0;
									i_207_ < this.prnpo;
									i_207_++) {
										if (this.ppos[i_207_] == 0) {
											string = strings[i_207_];
											break;
										}
									}
									if (!string.equals("")) {
										if (this.gwtyp[i_193_] == 2) {
											boolean bool_208_ = false;
											for (int i_209_ = 0;
											i_209_ < this.prnpo;
											i_209_++) {
												if (!(strings[i_209_].toLowerCase().equals(string.toLowerCase())) && (this.pdam[i_209_]) < 55 && (this.pdam[i_209_]) != -17) {
													bool_208_ = true;
													break;
												}
											}
											if (!bool_208_) {
												string_198_ = new StringBuilder()
													.append("").append(string).append(" should have raced in this game!")
													.toString();
												string = "";
											}
										}
										if (this.gwtyp[i_193_] == 3) {
											boolean bool_210_ = true;
											for (int i_211_ = 0;
											i_211_ < this.prnpo;
											i_211_++) {
												if (!(strings[i_211_].toLowerCase().equals(string.toLowerCase())) && (this.pdam[i_211_]) < 55 && (this.pdam[i_211_]) != -17) {
													bool_210_ = false;
													break;
												}
											}
											if (!bool_210_) {
												string_198_ = new StringBuilder()
													.append("").append(string).append(" should have wasted in this game!")
													.toString();
												string = "";
											}
										}
										if (this.gwtyp[i_193_] == 4) {
											if (string.toLowerCase().equals(this.gaclan[i_193_].toLowerCase())) {
												boolean bool_212_ = true;
												for (int i_213_ = 0;
												(i_213_ < this.prnpo);
												i_213_++) {
													if (!(strings[i_213_].toLowerCase().equals(string.toLowerCase())) && (this.pdam[i_213_]) < 55 && (this.pdam[i_213_]) != -17) {
														bool_212_ = false;
														break;
													}
												}
												if (!bool_212_) {
													string_198_ = new StringBuilder().append("").append(string).append(" should have wasted in this game!")
														.toString();
													string = "";
												}
											} else {
												boolean bool_214_ = false;
												for (int i_215_ = 0;
												(i_215_ < this.prnpo);
												i_215_++) {
													if (!(strings[i_215_].toLowerCase().equals(string.toLowerCase())) && (this.pdam[i_215_]) < 55 && (this.pdam[i_215_]) != -17) {
														bool_214_ = true;
														break;
													}
												}
												if (!bool_214_) {
													string_198_ = new StringBuilder().append("").append(string).append(" should have raced in this game!")
														.toString();
													string = "";
												}
											}
										}
										if (this.gwtyp[i_193_] == 5) {
											if (!string.toLowerCase().equals(this.gaclan[i_193_].toLowerCase())) {
												boolean bool_216_ = true;
												for (int i_217_ = 0;
												(i_217_ < this.prnpo);
												i_217_++) {
													if (!(strings[i_217_].toLowerCase().equals(string.toLowerCase())) && (this.pdam[i_217_]) < 55 && (this.pdam[i_217_]) != -17) {
														bool_216_ = false;
														break;
													}
												}
												if (!bool_216_) {
													string_198_ = new StringBuilder().append("").append(string).append(" should have wasted in this game!")
														.toString();
													string = "";
												}
											} else {
												boolean bool_218_ = false;
												for (int i_219_ = 0;
												(i_219_ < this.prnpo);
												i_219_++) {
													if (!(strings[i_219_].toLowerCase().equals(string.toLowerCase())) && (this.pdam[i_219_]) < 55 && (this.pdam[i_219_]) != -17) {
														bool_218_ = true;
														break;
													}
												}
												if (!bool_218_) {
													string_198_ = new StringBuilder().append("").append(string).append(" should have raced in this game!")
														.toString();
													string = "";
												}
											}
										}
									} else string_198_ = "No one finished first - no one survived!";
									if (string.toLowerCase().equals(this.gaclan[i_193_].toLowerCase())) i_203_ = 1;
									if (string.toLowerCase().equals(this.gvclan[i_193_].toLowerCase())) i_204_ = 1;
								}
								this.rd.drawString(new StringBuilder().append("").append(this.gaclan[i_193_]).append(" : ").append(this.gascore[i_193_] + i_203_)
									.append("     |     ").append(this.gvclan[i_193_]).append(" : ").append(this.gvscore[i_193_] + i_204_)
									.append("").toString(), (474 - (this.ftm.stringWidth(new StringBuilder().append("").append(this.gaclan[i_193_])
									.append(" : ").append(this.gascore[i_193_])
									.append("     |     ").append(this.gvclan[i_193_])
									.append(" : ").append(this.gvscore[i_193_])
									.append("").toString())) / 2),
								28);
								if (this.gwarb[i_193_] == 1) {
									if (this.gascore[i_193_] + i_203_ >= 5) string_197_ = new StringBuilder().append("").append(this.gaclan[i_193_])
										.append(" wins the war!")
										.toString();
									if (this.gvscore[i_193_] + i_204_ >= 5) string_197_ = new StringBuilder().append("").append(this.gvclan[i_193_])
										.append(" wins the war!")
										.toString();
								} else {
									if (this.gascore[i_193_] + i_203_ >= 3) string_197_ = new StringBuilder().append("").append(this.gaclan[i_193_])
										.append(" wins the battle!")
										.toString();
									if (this.gvscore[i_193_] + i_204_ >= 3) string_197_ = new StringBuilder().append("").append(this.gvclan[i_193_])
										.append(" wins the battle!")
										.toString();
								}
							}
							this.rd.setColor(color2k(200, 200, 200));
							this.rd.drawLine(233, 32, 602, 32);
							this.rd.drawLine(602, 7, 602, 32);
							if (this.conon == 1) {
								if (this.pgames[this.im] == this.ongame) stringbutton("Leave Game X", 660, 26, 0);
								else stringbutton("Close X", 679, 26, 0);
							}
							this.rd.drawImage(((
							this.xt)
								.pls),
							292, 39, null);
							if (this.opengame != 27) {
								(this.m).crs = true;
								(this.m).x = -335;
								(this.m).y = 0;
								(this.m).z = -50;
								(this.m).xz = 0;
								(this.m).zy = 20;
								(this.m).ground = -2000;
								this.pend = 0;
								this.pendb = false;
								this.ptime = 0L;
								this.opengame = 27;
							}
							int i_220_ = 0;
							int i_221_ = -1;
							for (int i_222_ = 0; i_222_ < this.npo;
							i_222_++) {
								if (this.pgames[i_222_] == this.ongame) {
									this.rd.setColor(color2k(240, 240, 240));
									if (i_222_ == this.im && this.wait[i_193_] != -1) {
										if (this.nflk == 0 || this.conon == 2) {
											this.rd.setColor(color2k(255, 255, 255));
											this.nflk = 3;
										} else this.nflk--;
									}
									this.rd.fillRect(237, (54 + i_220_ * 42),
									170, 40);
									this.rd.setColor(color2k(200, 200, 200));
									if (this.gwarb[i_193_] != 0) {
										if (this.pclan[i_222_].toLowerCase().equals(this.gaclan[i_193_].toLowerCase()))
										this.rd.setColor(new Color(255, 128, 0));
										if (this.pclan[i_222_].toLowerCase().equals(this.gvclan[i_193_].toLowerCase()))
										this.rd.setColor(new Color(0, 128, 255));
										if (this.wait[i_193_] == -1 && this.prevloaded == 1 && (string.toLowerCase().equals(this.pclan[i_222_].toLowerCase())) && this.nflk == 0)
										this.rd.setColor(new Color(0, 0, 0));
									} else if ((this.wait[i_193_] == -1) && (this.prevloaded == 1)) {
										for (int i_223_ = 0;
										i_223_ < this.prnpo;
										i_223_++) {
											if ((this.pnames[i_222_].equals(this.prnames[i_223_])) && (this.ppos[i_223_] == 0) && this.nflk == 0)
											this.rd.setColor(new Color(0, 0, 0));
										}
									}
									this.rd.drawRect(237, (54 + i_220_ * 42),
									170, 40);
									this.rd.setColor(new Color(0, 0,
									0));
									this.rd.setFont(new Font("Arial",
									1, 12));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString(this.pnames[i_222_],
									282 - (this.ftm.stringWidth(this.pnames[i_222_])) / 2,
									72 + i_220_ * 42);
									this.rd.setFont(new Font("Arial",
									0, 10));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString(this.pcarnames[i_222_],
									282 - (this.ftm.stringWidth(this.pcarnames[i_222_])) / 2,
									84 + i_220_ * 42);
									(this.m).crs = true;
									(this.m).x = -335;
									(this.m).y = 0;
									(this.m).z = -50;
									(this.m).xz = 0;
									(this.m).zy = 20;
									(this.m).ground = -2000;
									if (this.pcars[i_222_] != -1) {
										for (int i_224_ = 0;
										(i_224_ < (
										contos[(this.pcars[i_222_])]).npl);
										i_224_++) {
											(
											((contos[(this
												.pcars[i_222_])])
												.p[i_224_])).flx = 0;
											if ((
											((
											contos[(this.pcars[i_222_])])
												.p[i_224_])).colnum == 1) {
												(
												((
												contos[(this.pcars[i_222_])])
													.p[i_224_])).hsb[0] = (this.pcols[i_222_][0]);
												(
												((
												contos[(this.pcars[i_222_])])
													.p[i_224_])).hsb[1] = (this.pcols[i_222_][1]);
												(
												((
												contos[(this.pcars[i_222_])])
													.p[i_224_])).hsb[2] = 1.0F - (this
													.pcols[i_222_]
												[2]);
											}
											if ((
											((
											contos[(this.pcars[i_222_])])
												.p[i_224_])).colnum == 2) {
												(
												((
												contos[(this.pcars[i_222_])])
													.p[i_224_])).hsb[0] = (this.pcols[i_222_][3]);
												(
												((
												contos[(this.pcars[i_222_])])
													.p[i_224_])).hsb[1] = (this.pcols[i_222_][4]);
												(
												((
												contos[(this.pcars[i_222_])])
													.p[i_224_])).hsb[2] = 1.0F - (this
													.pcols[i_222_]
												[5]);
											}
										}
										if (this.cac[i_220_] != this.pcars[i_222_]) {
											int i_225_ = ((
											((
											contos[(this
												.pcars[i_222_])])
												.p[0]))
												.oz[0]);
											int i_226_ = i_225_;
											int i_227_ = ((
											((
											contos[(this
												.pcars[i_222_])])
												.p[0]))
												.oy[0]);
											int i_228_ = i_227_;
											for (int i_229_ = 0;
											(i_229_ < ((
											contos[(this
												.pcars[i_222_])])
												.npl));
											i_229_++) {
												for (int i_230_ = 0;
												(i_230_ < (
												((
												(contos[(this
													.pcars[i_222_])]))
													.p[i_229_])).n);
												i_230_++) {
													if (((
													((
													(contos[(this
														.pcars[i_222_])]))
														.p[i_229_]))
														.oz[i_230_]) < i_225_) i_225_ = ((
													((
													(contos[((
													this)
														.pcars[i_222_])]))
														.p[i_229_]))
														.oz[i_230_]);
													if (((
													((
													(contos[(this
														.pcars[i_222_])]))
														.p[i_229_]))
														.oz[i_230_]) > i_226_) i_226_ = ((
													((
													(contos[((
													this)
														.pcars[i_222_])]))
														.p[i_229_]))
														.oz[i_230_]);
													if (((
													((
													(contos[(this
														.pcars[i_222_])]))
														.p[i_229_]))
														.oy[i_230_]) < i_227_) i_227_ = ((
													((
													(contos[((
													this)
														.pcars[i_222_])]))
														.p[i_229_]))
														.oy[i_230_]);
													if (((
													((
													(contos[(this
														.pcars[i_222_])]))
														.p[i_229_]))
														.oy[i_230_]) > i_228_) i_228_ = ((
													((
													(contos[((
													this)
														.pcars[i_222_])]))
														.p[i_229_]))
														.oy[i_230_]);
												}
											}
											this.cax[i_220_] = (i_226_ + i_225_) / 2;
											this.cay[i_220_] = (i_228_ + i_227_) / 2;
											this.cac[i_220_] = this.pcars[i_222_];
										}
										if (i > 327 && i < 402 && i_99_ > 57 + i_220_ * 42 && i_99_ < 91 + i_220_ * 42) {
											i_101_ = 12;
											i_221_ = i_222_;
											for (int i_231_ = 0;
											(i_231_ < ((
											contos[(this
												.pcars[i_222_])])
												.npl));
											i_231_++)
											(
											((
											contos[(this.pcars[i_222_])])
												.p[i_231_])).flx = 77;
										}
										(contos[(this.pcars[i_222_])]).z = 2500 - i_220_ * 80;
										(contos[(this.pcars[i_222_])]).y = (150 + 250 * i_220_ - this.cay[i_220_]);
										(contos[(this.pcars[i_222_])]).x = (-145 - this.cax[i_220_]);
										(contos[(this.pcars[i_222_])]).zy = 0;
										(contos[(this.pcars[i_222_])]).xz = -90;
										(contos[(this.pcars[i_222_])]).xy = this.pend - i_220_ * 5;
										this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, (RenderingHints.VALUE_ANTIALIAS_OFF));
										contos[this.pcars[i_222_]].d(this.rd);
										this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, (RenderingHints.VALUE_ANTIALIAS_ON));
									} else {
										this.rd.setFont(new Font("Arial", 1, 11));
										this.rd.setColor(color2k(80, 80, 80));
										this.rd.drawString("Loading...", 339,
										77 + i_220_ * 42);
									}
									i_220_++;
								}
							}
							if (!this.pendb) {
								this.pend += 2;
								if (this.pend > 80)
								this.pendb = true;
							} else {
								this.pend -= 2;
								if (this.pend < -10)
								this.pendb = false;
							}
							if (i_221_ != -1) {
								if (bool)
								this.mousedout = true;
								else if (this.mousedout) {
									if (this.dispcar != i_221_ && i_221_ != -1 && ((this.cd)
										.action) != 6) {
										(this.cd).action = 0;
										this.dispcar = i_221_;
										this.forcar = this.pcars[i_221_];
										this.dispco = null;
										System.gc();
										this.dispco = new ContO(contos[(this
											.forcar)],
										0, 0, 0, 0);
									} else this.dispcar = -1;
									this.mousedout = false;
								}
							} else if (this.mousedout)
							this.mousedout = false;
							for (int i_232_ = 0; i_232_ < 7; i_232_++) {
								for (int i_233_ = 0;
								i_233_ < this.npo; i_233_++) {
									if ((this.pgames[i_233_] == this.ongame) && (this.invos[i_232_].equals(this.pnames[i_233_])) && (this.dinvi[i_232_].equals(this.invos[i_232_]))) {
										for (int i_234_ = i_232_; i_234_ < 6;
										i_234_++) {
											this.invos[i_234_] = (this.invos[i_234_ + 1]);
											this.dinvi[i_234_] = (this.dinvi[i_234_ + 1]);
										}
										this.invos[6] = "";
										this.dinvi[6] = "";
									}
								}
							}
							if (this.wait[i_193_] > 0) {
								int i_235_ = 0;
								for (int i_236_ = i_220_;
								i_236_ < this.mnpls[i_193_];
								i_236_++) {
									this.rd.setColor(color2k(200, 200, 200));
									this.rd.drawRect(237, (54 + i_236_ * 42),
									170, 40);
									boolean bool_237_ = false;
									if ((this.pgames[this.im]) == this.ongame) {
										if (!this.gplyrs[i_193_].equals("")) bool_237_ = true;
									} else if (this.gwarb[i_193_] == 0) {
										if (!this.gplyrs[i_193_].equals("") && (this.gplyrs[i_193_].indexOf(this.pnames[this.im])) == -1) bool_237_ = true;
									} else if (!((
									this.xt)
										.clan.toLowerCase().equals(this.gaclan[i_193_].toLowerCase())) && !((
									this.xt)
										.clan.toLowerCase().equals(this.gvclan[i_193_].toLowerCase()))) bool_237_ = true;
									if (i > 237 && i < 407 && i_99_ > 54 + i_236_ * 42 && i_99_ < 94 + i_236_ * 42 && !bool_237_) {
										if ((this.pgames[this.im]) == this.ongame) stringbutton("<     Invite Player      ",
										322, 79 + i_236_ * 42, 0);
										else stringbutton("    Join Game    ",
										322, 79 + i_236_ * 42,
										0);
										this.pbtn = 1;
									} else if (this.invos[i_235_].equals("")) {
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 1, 12));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString("Empty",
										322 - (this.ftm.stringWidth("Empty") / 2),
										72 + i_236_ * 42);
										this.rd.setFont(new Font("Arial", 0, 10));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString("Waiting for player...",
										322 - ((this.ftm.stringWidth("Waiting for player...")) / 2),
										84 + i_236_ * 42);
									} else if (!this.dinvi[i_235_].equals(this.invos[i_235_])) {
										if (this.nflk != 0) {
											this.rd.setColor(new Color(0, 0, 0));
											this.rd.setFont(new Font("Arial", 0, 12));
											this.ftm = this.rd.getFontMetrics();
											this.rd.drawString("Inviting player...", (322 - ((this.ftm.stringWidth("Inviting player...")) / 2)),
											79 + i_236_ * 42);
										}
									} else {
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 0, 12));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString("Player Invited!",
										322 - (this.ftm.stringWidth("Player Invited!")) / 2,
										71 + i_236_ * 42);
										this.rd.setFont(new Font("Arial", 1, 12));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString(this.invos[i_235_],
										322 - (this.ftm.stringWidth(this.invos[i_235_])) / 2,
										87 + i_236_ * 42);
									}
									i_235_++;
								}
							}
							if ((this.xt).lan && this.mnbts[i_193_] != 0) {
								this.rd.setColor(new Color(0, 0, 0));
								this.rd.setFont(new Font("Arial", 1,
								12));
								this.ftm = this.rd.getFontMetrics();
								this.rd.drawString(new StringBuilder().append("Plus ").append(this.mnbts[i_193_]).append(" MadBots!").toString(),
								322 - (this.ftm.stringWidth(new StringBuilder().append("Plus ").append(this.mnbts[i_193_])
									.append(" MadBots!")
									.toString())) / 2,
								73 + this.mnpls[i_193_] * 42);
							}
							if (this.dispcar == -1 || this.conon != 1) {
								this.rd.drawImage((
								(this
									.xt)).sts,
								537, 39, null);
								this.rd.setColor(color2k(200, 200,
								200));
								this.rd.drawRect(415, 54, 293, 166);
								if (this.conon == 1) {
									if (this.wait[i_193_] > 0) {
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 1, 12));
										this.ftm = this.rd.getFontMetrics();
										if (this.gwarb[i_193_] == 0) {
											if ((this.wait[i_193_] > 30) || (this.npls[i_193_] <= 1)) {
												String string_238_ = "s";
												if (((this.mnpls[i_193_]) - (this.npls[i_193_])) == 1) string_238_ = "";
												this.rd.drawString(new StringBuilder().append("Waiting for ")
													.append((this.mnpls[i_193_]) - (this
													.npls[i_193_]))
													.append(" more player")
													.append(string_238_).append(" to join to start.")
													.toString(), (561 - (this.ftm.stringWidth(new StringBuilder().append("Waiting for ")
													.append((this
													.mnpls[i_193_]) - ((
												this)
													.npls[i_193_]))
													.append(" more player")
													.append(string_238_)
													.append(" to join to start.")
													.toString())) / 2),
												98);
												this.rd.setFont(new Font("Arial", 0, 12));
												this.ftm = this.rd.getFontMetrics();
												int i_239_ = 134;
												if (!(this.gmaker[i_193_].equals("Coach Insano")) && !(this
													.gmaker[i_193_].equals(this.pnames[(this
													.im)]))) {
													boolean bool_240_ = false;
													for (int i_241_ = 0;
													(i_241_ < (this
														.npo));
													i_241_++) {
														if (((this
															.pgames[i_241_]) == (this
															.ongame)) && (this
															.gmaker[i_193_].equals(this
															.pnames[i_241_]))) bool_240_ = true;
													}
													if (bool_240_) {
														i_239_ = 144;
														this.rd.drawString(new StringBuilder().append("").append((
														this)
															.gmaker[i_193_])
															.append(" can start this game at anytime.")
															.toString(), (561 - (this
															.ftm.stringWidth(new StringBuilder().append("")
															.append((
														this)
															.gmaker[i_193_])
															.append(" can start this game at anytime.")
															.toString())) / 2),
														124);
													}
												}
												if (this.npls[i_193_] > 1) {
													String string_242_ = new StringBuilder().append("").append(this
														.wait[i_193_])
														.append(" seconds")
														.toString();
													if ((this.wait[i_193_]) > 60) string_242_ = new StringBuilder().append("").append((float)(int)((float)this.wait[i_193_] / 60.0F * 100.0F) / 100.0F)
														.append(" minutes")
														.toString();
													this.rd.drawString(new StringBuilder().append("(Waiting ")
														.append(string_242_)
														.append(" maximum! )")
														.toString(), (561 - (this
														.ftm.stringWidth(new StringBuilder().append("(Waiting ")
														.append(string_242_)
														.append(" maximum! )")
														.toString())) / 2),
													i_239_);
												}
											} else {
												Date date = new Date();
												long l = date.getTime();
												if (this.ptime == 0L || l > (this
													.ptime) + 1500L) {
													if (this.ptime != 0L) {
														this.wait[i_193_]--;
														if ((this
															.wait[i_193_]) < 1)
														this
															.wait[i_193_] = 1;
													}
													this.ptime = l;
												}
												if (((this.pgames[this.im]) == this.ongame) || (this.nflk != 0)) {
													this.rd.drawString(new StringBuilder().append("Game starts in ")
														.append(this
														.wait[i_193_])
														.append(" seconds!")
														.toString(), (561 - (this
														.ftm.stringWidth(new StringBuilder().append("Game starts in ")
														.append((
													this)
														.wait[i_193_])
														.append(" seconds!")
														.toString())) / 2),
													124);
													if ((this.pgames[this.im]) != (this
														.ongame))
													this.nflk--;
												} else if ((this
													.pgames[(this
													.im)]) != (this
													.ongame))
												this.nflk = 3;
											}
											if ((this.pgames[this.im]) != this.ongame) {
												if (this.gplyrs[i_193_].equals("") || ((this
													.gplyrs[i_193_].indexOf(this.pnames[this.im])) != -1)) stringbutton("    Join this Game    ",
												561, 182, 0);
												else {
													this.rd.setFont(new Font("Arial", 1,
													12));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.setColor(new Color(128, 73,
													0));
													this.rd.drawString("Private Game, only specific players allowed.", (561 - ((this
														.ftm.stringWidth("Private Game, only specific players allowed.")) / 2)),
													180);
													stringbutton("    Join this Game    ",
													561, -1000, 0);
												}
											} else if (this
												.gmaker[i_193_].equals(this.pnames[this.im])) {
												if (this.npls[i_193_] > 1) {
													if (!this.fstart) stringbutton("    Start this Game Now!    ",
													561, 182, 0);
													else stringbutton("    Starting game now, one moment...    ",
													561, 182, 0);
												} else {
													this.rd.setFont(new Font("Arial", 1,
													12));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.setColor(new Color(128, 73,
													0));
													this.rd.drawString("You have created this game.", (561 - ((this
														.ftm.stringWidth("You have created this game.")) / 2)),
													180);
												}
											} else {
												this.rd.setFont(new Font("Arial", 1, 12));
												this.ftm = this.rd.getFontMetrics();
												this.rd.setColor(new Color(80, 128, 0));
												this.rd.drawString("You have joined this game.", (561 - ((this
													.ftm.stringWidth("You have joined this game.")) / 2)),
												180);
											}
										} else {
											String string_243_ = "s";
											if ((this.mnpls[i_193_] - this.npls[i_193_]) == 1) string_243_ = "";
											this.rd.drawString(new StringBuilder().append("Waiting for ").append((this.mnpls[i_193_]) - (this.npls[i_193_]))
												.append(" clan member").append(string_243_).append(" to join to start.")
												.toString(), (561 - (this.ftm.stringWidth(new StringBuilder()
												.append("Waiting for ")
												.append((this
												.mnpls[i_193_]) - (this
												.npls[i_193_]))
												.append(" clan member")
												.append(string_243_).append(" to join to start.")
												.toString())) / 2),
											72);
											int i_244_ = (this.mnpls[i_193_] / 2);
											int i_245_ = (this.mnpls[i_193_] / 2);
											for (int i_246_ = 0;
											i_246_ < this.npo;
											i_246_++) {
												if ((this.pgames[i_246_]) == (this.gnum[i_193_])) {
													if ((this
														.pclan[i_246_].toLowerCase().equals(this
														.gaclan[i_193_].toLowerCase())) && --i_244_ < 0) i_244_ = 0;
													if ((this
														.pclan[i_246_].toLowerCase().equals(this
														.gvclan[i_193_].toLowerCase())) && --i_245_ < 0) i_245_ = 0;
												}
											}
											this.rd.setFont(new Font("Arial", 0, 12));
											this.ftm = this.rd.getFontMetrics();
											this.rd.drawString(new StringBuilder().append("(").append(i_244_).append(" of ").append(this.gaclan[i_193_])
												.append("  &  ").append(i_245_).append(" of ").append(this.gvclan[i_193_])
												.append(" )").toString(),
											561 - (this.ftm.stringWidth(new StringBuilder().append("(").append(i_244_).append(" of ").append(this
												.gaclan[i_193_])
												.append("  &  ").append(i_245_).append(" of ").append(this
												.gvclan[i_193_])
												.append(" )")
												.toString())) / 2,
											87);
											this.rd.drawString(this.gaclan[i_193_],
											491 - (this.ftm.stringWidth(this.gaclan[i_193_])) / 2,
											125);
											this.rd.drawString(this.gvclan[i_193_],
											631 - (this.ftm.stringWidth(this.gvclan[i_193_])) / 2,
											125);
											this.rd.setFont(new Font("Arial", 1, 12));
											this.ftm = this.rd.getFontMetrics();
											String string_247_ = "War";
											if (this.gwarb[i_193_] > 1) string_247_ = "Battle";
											this.rd.drawString(new StringBuilder().append("").append(string_247_).append(" Score").toString(),
											561 - (this.ftm.stringWidth(new StringBuilder().append("").append(string_247_)
												.append(" Score")
												.toString())) / 2,
											107);
											this.rd.drawString(new StringBuilder().append("").append(this.gascore[i_193_])
												.append("").toString(),
											491 - (this.ftm.stringWidth(new StringBuilder().append("").append(this
												.gascore[i_193_])
												.append("")
												.toString())) / 2,
											139);
											this.rd.drawString(new StringBuilder().append("").append(this.gvscore[i_193_])
												.append("").toString(),
											631 - (this.ftm.stringWidth(new StringBuilder().append("").append(this
												.gascore[i_193_])
												.append("")
												.toString())) / 2,
											139);
											this.rd.drawRect(421, 111, 280, 33);
											this.rd.drawLine(561, 111, 561, 144);
											this.rd.setColor(new Color(255, 128, 0));
											this.rd.drawRect(422, 112, 138, 31);
											this.rd.setColor(new Color(0, 128, 255));
											this.rd.drawRect(562, 112, 138, 31);
											if ((this.pgames[this.im]) != this.ongame) {
												if (((
												this.xt)
													.clan.toLowerCase().equals(this.gaclan[i_193_].toLowerCase())) || ((
												this.xt)
													.clan.toLowerCase().equals(this
													.gvclan[i_193_].toLowerCase()))) stringbutton("    Join this Game    ",
												561, 200, 0);
												else {
													this.rd.setColor(new Color(128, 73,
													0));
													this.rd.drawString("You must be a member of either clan to join.", (561 - ((this
														.ftm.stringWidth("You must be a member of either clan to join.")) / 2)),
													198);
												}
											} else {
												if ((this.gmaker[i_193_].equals(this.pnames[this.im])) && (this.npls[i_193_]) > 1) stringbutton("    Start this Game Now!    ",
												561, -1000, 0);
												this.rd.setColor(new Color(80, 128, 0));
												this.rd.drawString("You have joined this game.", (561 - ((this
													.ftm.stringWidth("You have joined this game.")) / 2)),
												198);
											}
											this.rd.setFont(new Font("Arial", 1, 12));
											this.ftm = this.rd.getFontMetrics();
											if (this.gwtyp[i_193_] == 1) {
												this.rd.setColor(new Color(0, 0, 0));
												this.rd.drawString("This is a normal clan game.", (561 - ((this
													.ftm.stringWidth("This is a normal clan game.")) / 2)),
												161);
												this.rd.setFont(new Font("Arial", 0, 12));
												this.ftm = this.rd.getFontMetrics();
												this.rd.setColor(new Color(0, 0, 0));
												this.rd.drawString("Any clan can win by racing or wasting.", (561 - ((this
													.ftm.stringWidth("Any clan can win by racing or wasting.")) / 2)),
												176);
											}
											if (this.gwtyp[i_193_] == 2) {
												if (this.sflk != 0) {
													this.sflk--;
													this.rd.setColor(new Color(0, 0, 0));
												} else {
													this.sflk = 3;
													this.rd.setColor(new Color(117, 67,
													0));
												}
												this.rd.drawString("This is a racing only game!", (561 - ((this
													.ftm.stringWidth("This is a racing only game!")) / 2)),
												161);
												this.rd.setFont(new Font("Arial", 0, 12));
												this.ftm = this.rd.getFontMetrics();
												this.rd.setColor(new Color(0, 0, 0));
												this.rd.drawString("A clan can only win by racing.", (561 - ((this
													.ftm.stringWidth("A clan can only win by racing.")) / 2)),
												176);
											}
											if (this.gwtyp[i_193_] == 3) {
												if (this.sflk != 0) {
													this.sflk--;
													this.rd.setColor(new Color(0, 0, 0));
												} else {
													this.sflk = 3;
													this.rd.setColor(new Color(117, 67,
													0));
												}
												this.rd.drawString("This is a wasting only game!", (561 - ((this
													.ftm.stringWidth("This is a wasting only game!")) / 2)),
												161);
												this.rd.setFont(new Font("Arial", 0, 12));
												this.ftm = this.rd.getFontMetrics();
												this.rd.setColor(new Color(0, 0, 0));
												this.rd.drawString("A clan can only win by wasting.", (561 - ((this
													.ftm.stringWidth("A clan can only win by wasting.")) / 2)),
												176);
											}
											if (this.gwtyp[i_193_] == 4) {
												if (this.sflk != 0) {
													this.sflk--;
													this.rd.setColor(new Color(0, 0, 0));
												} else {
													this.sflk = 3;
													this.rd.setColor(new Color(117, 67,
													0));
												}
												this.rd.drawString("This is Racers VS Wasters game!", (561 - ((this
													.ftm.stringWidth("This is Racers VS Wasters game!")) / 2)),
												161);
												this.rd.drawString(new StringBuilder().append("").append(this.gaclan[i_193_])
													.append(" wastes & ").append(this.gvclan[i_193_])
													.append(" races.")
													.toString(), (561 - ((this
													.ftm.stringWidth(new StringBuilder().append("").append(this
													.gaclan[i_193_])
													.append(" wastes & ")
													.append(this
													.gvclan[i_193_])
													.append(" races.")
													.toString())) / 2)),
												176);
											}
											if (this.gwtyp[i_193_] == 5) {
												if (this.sflk != 0) {
													this.sflk--;
													this.rd.setColor(new Color(0, 0, 0));
												} else {
													this.sflk = 3;
													this.rd.setColor(new Color(117, 67,
													0));
												}
												this.rd.drawString("This is Racers VS Wasters game!", (561 - ((this
													.ftm.stringWidth("This is Racers VS Wasters game!")) / 2)),
												161);
												this.rd.drawString(new StringBuilder().append("").append(this.gaclan[i_193_])
													.append(" races & ").append(this.gvclan[i_193_])
													.append(" wastes.")
													.toString(), (561 - ((this
													.ftm.stringWidth(new StringBuilder().append("").append(this
													.gaclan[i_193_])
													.append(" races & ")
													.append(this
													.gvclan[i_193_])
													.append(" wastes.")
													.toString())) / 2)),
												176);
											}
										}
									} else if (this.prevloaded == 1) {
										int i_248_ = (int)(80.0 + ((double)(float)((
										this)
											.rerr) / 1.243));
										if (i_248_ > 255) i_248_ = 255;
										if (i_248_ < 0) i_248_ = 0;
										int i_249_ = (int)(128.0 + ((double)(float)((
										this)
											.rerr) / 2.428));
										if (i_249_ > 255) i_249_ = 255;
										if (i_249_ < 0) i_249_ = 0;
										int i_250_ = this.rerr;
										if (i_250_ > 255) i_250_ = 255;
										if (i_250_ < 0) i_250_ = 0;
										if (this.wait[i_193_] == 0) {
											this.rd.setColor(new Color(i_248_, i_249_,
											i_250_));
											this.rd.setFont(new Font("Arial", 1, 12));
											this.rd.drawString("Live Info!", 621, 51);
											this.rd.drawString("Live Info!", 451, 51);
										}
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Tahoma", 1, 11));
										this.rd.drawString("Player       Position   Laps      Power        Damage",
										439, 69);
										this.rd.setColor(color2k(200, 200, 200));
										this.rd.drawLine(489, 61,
										489, 162);
										this.rd.drawLine(542, 61,
										542, 162);
										this.rd.drawLine(579, 61,
										579, 162);
										this.rd.drawLine(641, 61,
										641, 162);
										this.rd.drawLine(422, 72,
										702, 72);
										this.rd.drawLine(422, 163,
										702, 163);
										i_220_ = 0;
										for (int i_251_ = 0;
										i_251_ < this.prnpo;
										i_251_++) {
											for (int i_252_ = 0;
											i_252_ < this.prnpo;
											i_252_++) {
												if (this.ppos[i_252_] == i_251_) {
													this.rd.setFont(new Font("Tahoma", 0,
													11));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.setColor(new Color(0, 44,
													124));
													this.rd.drawString((this
														.prnames[i_252_]), (455 - (this
														.ftm.stringWidth(this
														.prnames[i_252_])) / 2),
													83 + 11 * i_220_);
													if ((this.pdam[i_252_]) < 55 && (this.pdam[i_252_]) != -17) {
														this.rd.setColor(new Color(80, 128,
														0));
														String string_253_ = "th";
														if ((this
															.ppos[i_252_]) == 0) string_253_ = "st";
														if ((this
															.ppos[i_252_]) == 1) string_253_ = "nd";
														if ((this
															.ppos[i_252_]) == 2) string_253_ = "rd";
														this.rd.drawString(new StringBuilder().append("").append(((
														this)
															.ppos[i_252_]) + 1)
															.append("").append(string_253_)
															.toString(), (515 - (this
															.ftm.stringWidth(new StringBuilder().append("")
															.append(((
														this)
															.ppos[i_252_]) + 1)
															.append("")
															.append(string_253_)
															.toString())) / 2),
														83 + 11 * i_220_);
														this.rd.setColor(new Color(128, 73,
														0));
														if ((this
															.plap[i_252_]) > (this
															.gnlaps[i_193_]) - 1)
														this
															.plap[i_252_] = (((
														this)
															.gnlaps[i_193_]) - 1);
														this.rd.drawString(new StringBuilder().append("").append(((
														this)
															.plap[i_252_]) + 1)
															.append(" / ").append((
														this)
															.gnlaps[i_193_])
															.append("")
															.toString(), (560 - (this
															.ftm.stringWidth(new StringBuilder().append("")
															.append(((
														this)
															.plap[i_252_]) + 1)
															.append(" / ")
															.append((
														this)
															.gnlaps[i_193_])
															.append("")
															.toString())) / 2),
														83 + 11 * i_220_);
														this.rd.setColor(new Color(0, 128,
														255));
														this.rd.drawRect(582,
														76 + 11 * i_220_,
														56, 6);
														this.rd.fillRect(583,
														79 + 11 * i_220_, (this
															.ppow[i_252_]),
														3);
														this.rd.setColor(new Color(128,
														210,
														255));
														this.rd.fillRect(583,
														77 + 11 * i_220_, (this
															.ppow[i_252_]),
														2);
														this.rd.setColor(new Color(255, 0,
														0));
														this.rd.drawRect(645,
														76 + 11 * i_220_,
														56, 6);
														this.rd.fillRect(646,
														79 + 11 * i_220_, (this
															.pdam[i_252_]),
														3);
														this.rd.setColor(new Color(255,
														155,
														64));
														this.rd.fillRect(646,
														77 + 11 * i_220_, (this
															.pdam[i_252_]),
														2);
													} else {
														i_248_ = (int)(85.0 + ((double)(float)(this.rerr * 2) / 1.5));
														if (i_248_ > 255) i_248_ = 255;
														if (i_248_ < 0) i_248_ = 0;
														this.rd.setColor(color2k(i_248_,
														i_248_,
														i_248_));
														this.rd.fillRect(490,
														75 + 11 * i_220_,
														213, 9);
														this.rd.setFont(new Font("Tahoma",
														1, 11));
														this.ftm = (this
															.rd.getFontMetrics());
														i_248_ = 255 - (((
														this)
															.rerr) * 2);
														if (i_248_ > 255) i_248_ = 255;
														if (i_248_ < 0) i_248_ = 0;
														i_249_ = (int)(155.0 - ((double)(float)(this.rerr * 2) / 1.645));
														if (i_249_ > 255) i_249_ = 255;
														if (i_249_ < 0) i_249_ = 0;
														i_250_ = (int)(64.0 - ((double)(float)(this.rerr * 2) / 3.984));
														if (i_250_ > 255) i_250_ = 255;
														if (i_250_ < 0) i_250_ = 0;
														this.rd.setColor(new Color(i_248_, i_249_,
														i_250_));
														if ((this
															.pdam[i_252_]) != -17)
														this
															.rd.drawString("=   =   =   =    W A S T E D    =   =   =   =", (597 - (((
														this)
															.ftm.stringWidth("=   =   =   =    W A S T E D    =   =   =   =")) / 2)), (84 + (11 * i_220_)));
														else this
															.rd.drawString("=   =   =   DISCONNECTED   =   =   =", (597 - (((
														this)
															.ftm.stringWidth("=   =   =   DISCONNECTED   =   =   =")) / 2)), (84 + (11 * i_220_)));
													}
													i_220_++;
												}
											}
										}
										if (this.wait[i_193_] == 0) stringbutton("    Watch Live Now!    ",
										561, 196, 0);
										else {
											this.rd.setColor(new Color(0, 0, 0));
											this.rd.setFont(new Font("Arial", 1, 12));
											this.ftm = this.rd.getFontMetrics();
											int i_254_ = 186;
											if (!this.lapsname.equals("") && !this
												.wastename.equals("") && !this
												.stuntname.equals("")) i_254_ = 183;
											if (this.gwarb[i_193_] == 0) {
												String string_255_ = "";
												for (int i_256_ = 0;
												(i_256_ < this.prnpo);
												i_256_++) {
													if ((this.ppos[i_256_]) == 0) {
														string_255_ = (this
															.prnames[i_256_]);
														break;
													}
												}
												if (string_255_.equals(""))
												this.rd.drawString("Game Finished!    Nobody Won!", (561 - ((this
													.ftm.stringWidth("Game Finished!    Nobody Won!")) / 2)),
												i_254_);
												else {
													this.rd.drawString(new StringBuilder().append("Game Finished!    Winner:  ")
														.append(string_255_)
														.append("").toString(), (561 - (this
														.ftm.stringWidth(new StringBuilder().append("Game Finished!    Winner:  ")
														.append(string_255_)
														.append("").toString())) / 2),
													i_254_);
													if (this.nflk == 0) {
														this.rd.setColor(new Color(255,
														176,
														67));
														this.nflk = 3;
													} else this.nflk--;
													this.rd.drawString(new StringBuilder().append("").append(string_255_)
														.append("").toString(), (561 - (this
														.ftm.stringWidth(new StringBuilder().append("Game Finished!    Winner:  ")
														.append(string_255_)
														.append("").toString())) / 2 + (this
														.ftm.stringWidth("Game Finished!    Winner:  "))),
													i_254_);
												}
												this.rd.setColor(new Color(0, 0, 0));
												this.rd.setFont(new Font("Arial", 0, 11));
												this.ftm = this.rd.getFontMetrics();
												String string_257_ = "    ";
												int i_258_ = 0;
												if (!this
													.lapsname.equals("")) {
													string_257_ = new StringBuilder().append(string_257_)
														.append("Fastest lap: ")
														.append(this
														.lapsname)
														.append("    ")
														.toString();
													i_258_++;
												}
												if (!this
													.wastename.equals("")) {
													string_257_ = new StringBuilder().append(string_257_)
														.append("Deadliest waster: ")
														.append(this
														.wastename)
														.append("    ")
														.toString();
													i_258_++;
												}
												if (i_258_ == 2) {
													if (!this
														.stuntname.equals("")) {
														this.rd.drawString(string_257_, (561 - (((
														this)
															.ftm.stringWidth(string_257_)) / 2)),
														199);
														this.rd.drawString(new StringBuilder().append("Best stunt: ")
															.append((
														this)
															.stuntname)
															.append("")
															.toString(), (561 - (this
															.ftm.stringWidth(new StringBuilder().append("Best stunt: ")
															.append((
														this)
															.stuntname)
															.append("")
															.toString())) / 2),
														213);
													} else this.rd.drawString(string_257_, (561 - (((
													this)
														.ftm.stringWidth(string_257_)) / 2)),
													206);
												} else {
													if (!this
														.stuntname.equals("")) string_257_ = new StringBuilder().append(string_257_)
														.append("Best stunt: ")
														.append((
													this)
														.stuntname)
														.append("    ")
														.toString();
													this.rd.drawString(string_257_, (561 - ((this
														.ftm.stringWidth(string_257_)) / 2)),
													206);
												}
											} else if (string_197_.equals("")) {
												if (string.equals("")) {
													this.rd.drawString("Game Finished!    Nobody Won!", (561 - ((this
														.ftm.stringWidth("Game Finished!    Nobody Won!")) / 2)),
													186);
													this.rd.setFont(new Font("Arial", 1,
													11));
													this.ftm = (this
														.rd.getFontMetrics());
													this.rd.drawString(string_198_, (561 - ((this
														.ftm.stringWidth(string_198_)) / 2)),
													206);
												} else {
													this.rd.drawString(new StringBuilder().append("Game Finished!    ")
														.append(string).append("  Wins!")
														.toString(), (561 - (this
														.ftm.stringWidth(new StringBuilder().append("Game Finished!    ")
														.append(string)
														.append("  Wins!")
														.toString())) / 2),
													196);
													if (this.nflk == 0) {
														this.rd.setColor(new Color(255,
														176,
														67));
														this.nflk = 3;
													} else this.nflk--;
													this.rd.drawString(new StringBuilder().append("").append(string).append("").toString(), (561 - (this
														.ftm.stringWidth(new StringBuilder().append("Game Finished!    ")
														.append(string)
														.append("  Wins!")
														.toString())) / 2 + (this
														.ftm.stringWidth("Game Finished!    "))),
													196);
												}
											} else {
												if (this.nflk == 0) {
													this.rd.setColor(new Color(255, 176,
													67));
													this.nflk = 3;
												} else this.nflk--;
												this.rd.drawString(string_197_,
												561 - (this
													.ftm.stringWidth(string_197_)) / 2,
												196);
											}
										}
										this.rerr += 3;
									} else {
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 1, 12));
										this.ftm = this.rd.getFontMetrics();
										if (this.prevloaded == -1) {
											if (!(
											this.xt).lan)
											this.rd.drawString("Loading Info...", (561 - ((this
												.ftm.stringWidth("Loading Info...")) / 2)),
											134);
											else if ((this.pgames[this.im]) == this.ongame)
											this.rd.drawString("About to Start...", (561 - ((this
												.ftm.stringWidth("About to Start...")) / 2)),
											134);
											else {
												this.rd.drawString("Game Started",
												561 - ((this
													.ftm.stringWidth("Game Started")) / 2),
												117);
												stringbutton("    Watch this Game    ",
												561, 154, 0);
											}
										} else this.rd.drawString("About to Start...",
										561 - ((this.ftm.stringWidth("About to Start...")) / 2),
										134);
									}
								} else {
									this.rd.setColor(new Color(0, 0,
									0));
									this.rd.setFont(new Font("Arial",
									1, 12));
									this.ftm = this.rd.getFontMetrics();
									if (this.conon == 2)
									this.rd.drawString("Starting Game Now!", (561 - (this.ftm.stringWidth("Starting Game Now!")) / 2),
									124);
									if (this.conon == 3)
									this.rd.drawString("Opening Game Now!",
									561 - (this.ftm.stringWidth("Opening Game Now!")) / 2,
									124);
									this.rd.setFont(new Font("Arial",
									0, 12));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString("Please Wait...", (561 - (this.ftm.stringWidth("Please Wait...") / 2)),
									154);
								}
								this.rd.setColor(color2k(200, 200,
								200));
								this.rd.drawRect(415, 222, 293, 40);
								this.rd.drawImage((
								(this
									.xt)).stg,
								422, 227, null);
								this.rd.setColor(new Color(0, 0, 0));
								this.rd.setFont(new Font("Arial", 1,
								10));
								this.ftm = this.rd.getFontMetrics();
								this.rd.drawString(new StringBuilder().append("Laps: ")
									.append(this.gnlaps[i_193_]).append("").toString(),
								660, 235);
								if (i > 415 && i < 708 && i_99_ > 222 && i_99_ < 262 && (this.wait[i_193_] > 0 || this.gstgn[i_193_] < 0) && this.conon == 1) {
									stringbutton("       Preview Stage       ",
									562, 247, 0);
									this.pbtn = 2;
								} else {
									if (this.gstgn[i_193_] > 0) {
										String string_259_ = "NFM 1";
										int i_260_ = this.gstgn[i_193_];
										if (this.gstgn[i_193_] > 10) {
											string_259_ = "NFM 2";
											i_260_ = (this.gstgn[i_193_] - 10);
										}
										if (this.gstgn[i_193_] > 27) {
											string_259_ = "Multiplayer";
											i_260_ = (this.gstgn[i_193_] - 27);
										}
										this.rd.drawString(new StringBuilder().append("")
											.append(string_259_).append(" - Stage ").append(i_260_).append("").toString(),
										562 - (this.ftm.stringWidth(new StringBuilder().append("").append(string_259_).append(" - Stage ").append(i_260_).append("").toString())) / 2,
										237);
									} else this.rd.drawString("Custom Stage",
									562 - (this.ftm.stringWidth("Custom Stage")) / 2,
									237);
									this.rd.setFont(new Font("Arial",
									1, 12));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString(this.gstages[i_193_],
									562 - (this.ftm.stringWidth(this.gstages[i_193_])) / 2,
									254);
								}
								if (!(this.xt).lan) {
									int i_261_ = 237;
									int i_262_ = 471;
									if (this.wait[i_193_] > 0) {
										if (this.mnpls[i_193_] > 5) {
											i_261_ = 415;
											i_262_ = 293;
										}
									} else if (this.npls[i_193_] > 5) {
										i_261_ = 415;
										i_262_ = 293;
									}
									this.rd.setColor(color2k(200, 200, 200));
									this.rd.drawRect(i_261_, 264,
									i_262_, 124);
									this.rd.setColor(color2k(240, 240, 240));
									this.rd.fillRect(i_261_ + 1, 265,
									i_262_ - 1, 21);
									this.rd.drawImage((this.xt).gmc,
									i_261_ + 7, 269, null);
									this.rd.setFont(new Font("Tahoma", 0, 11));
									this.rd.setColor(color2k(110, 110, 110));
									this.rd.drawString("(Game Chat )", i_261_ + 57, 278);
									this.rd.setColor(new Color(0, 0,
									0));
									if (this.updatec != -1) {
										String[] strings = new String[7];
										String[] strings_263_ = new String[7];
										boolean[] bools = {
											false, false, false, false,
											false, false, false
										};
										for (int i_264_ = 0; i_264_ < 7;
										i_264_++) {
											strings[i_264_] = "";
											strings_263_[i_264_] = (this.cnames[i_264_]);
											int i_265_ = 0;
											int i_266_ = 0;
											int i_267_ = 0;
											int i_268_ = 0;
											int i_269_ = 0;
											for (/**/ ;
											(i_265_ < this.sentn[i_264_].length());
											i_265_++) {
												String string_270_ = new StringBuilder()
													.append("").append(this
													.sentn[i_264_].charAt(i_265_))
													.toString();
												if (string_270_.equals(" ")) {
													i_266_ = i_267_;
													i_268_ = i_265_;
													i_269_++;
												} else i_269_ = 0;
												if (i_269_ <= 1) {
													StringBuilder stringbuilder = new StringBuilder();
													String[] strings_271_ = strings;
													int i_272_ = i_264_;
													strings_271_[i_272_] = stringbuilder.append(strings_271_[i_272_])
														.append(string_270_)
														.toString();
													i_267_++;
													if ((this.ftm.stringWidth(strings[i_264_])) > i_262_ - 94) {
														if (i_266_ != 0) {
															strings[i_264_] = (strings[i_264_].substring(0,
															i_266_));
															for (int i_273_ = 0;
															(i_273_ < i_264_);
															i_273_++) {
																strings[i_273_] = (strings[(i_273_ + 1)]);
																strings_263_[i_273_] = (strings_263_[(i_273_ + 1)]);
																bools[i_273_] = (bools[(i_273_ + 1)]);
															}
															strings[i_264_] = "";
															bools[i_264_] = true;
															i_265_ = i_268_;
															i_267_ = 0;
															i_266_ = 0;
														} else {
															strings[i_264_] = "";
															i_267_ = 0;
														}
													}
												}
											}
										}
										String string_274_ = "";
										this.rd.setFont(new Font("Tahoma", 1, 11));
										this.ftm = this.rd.getFontMetrics();
										for (int i_275_ = 0; i_275_ < 7;
										i_275_++) {
											if (!string_274_.equals(strings_263_[i_275_])) {
												this.rd.drawString(new StringBuilder().append(strings_263_[i_275_])
													.append(":").toString(), (i_261_ + 84 - (this.ftm.stringWidth(new StringBuilder().append(strings_263_[i_275_])
													.append(":")
													.toString()))),
												299 + i_275_ * 14);
												string_274_ = strings_263_[i_275_];
											}
										}
										this.rd.setFont(new Font("Tahoma", 0, 11));
										for (int i_276_ = 0; i_276_ < 7;
										i_276_++) {
											if (bools[i_276_] && i_276_ == 0 && strings[i_276_].indexOf(" ") != -1) strings[i_276_] = new StringBuilder()
												.append("...").append(strings[i_276_].substring(strings[i_276_].indexOf(" "),
											strings[i_276_].length()))
												.append("").toString();
											this.rd.drawString(strings[i_276_], i_261_ + 88,
											299 + i_276_ * 14);
										}
									} else this.rd.drawString("Loading chat...", (i_261_ + i_262_ / 2 - (this.ftm.stringWidth("Loading chat...")) / 2),
									315);
									if (this.conon == 1)
									this.pre2 = true;
									else hideinputs();
									if ((control).enter && !(this.gs)
										.cmsg.getText().equals("Type here...") && !(this.gs)
										.cmsg.getText().equals("")) {
										this.pessd[(this
											.btn)] = true;
										(control).enter = false;
										String string_277_ = (this.gs)
											.cmsg.getText().replace('|', ':');
										if ((string_277_.toLowerCase().indexOf((this.gs)
											.tpass.getText().toLowerCase())) != -1) string_277_ = " ";
										if (!this.xt.msgcheck(string_277_) && this.updatec > -12) {
											for (int i_278_ = 0; i_278_ < 6;
											i_278_++) {
												this.sentn[i_278_] = (this.sentn[i_278_ + 1]);
												this.cnames[i_278_] = (this.cnames[i_278_ + 1]);
											}
											this.sentn[6] = string_277_;
											this.cnames[6] = (this.pnames[this.im]);
											if (this.updatec > -11)
											this.updatec = -11;
											else this.updatec--;
										} else(this.xt)
											.warning++;
										(this.gs)
											.cmsg.setText("");
									}
									stringbutton("Send Message", 655, 405, 3);
								}
							} else {
								if ((this.gs).cmsg.isShowing())
								(this.gs).cmsg.hide();
								if (((this.pcars[this.dispcar]) == this.forcar) && this.forcar != -1) {
									this.rd.drawImage((this.xt).crd,
									517, 81, null);
									this.rd.setColor(new Color(16, 198, 255));
									this.rd.drawRect(415, 96, 293,
									315);
									this.rd.setColor(color2k(240, 240, 240));
									this.rd.fillRect(416, 97, 4,
									314);
									this.rd.fillRect(704, 97, 4,
									314);
									this.rd.fillRect(416, 97, 292,
									4);
									this.rd.fillRect(416, 407, 292,
									4);
									if (this.flks >= 0) {
										this.rd.setColor(new Color(239, 234, 177));
										this.flks++;
										if (this.flks > 3)
										this.flks = -1;
									} else {
										this.rd.setColor(new Color(224, 226, 176));
										this.flks--;
										if (this.flks < -4)
										this.flks = 0;
									}
									this.rd.fillRect(445, 120, 233,
									127);
									this.rd.setColor(new Color(0, 0,
									0));
									this.rd.setFont(new Font("Arial",
									1, 13));
									this.ftm = this.rd.getFontMetrics();
									this.rd.drawString(((this.cd).names[this.forcar]), (561 - ((this.ftm.stringWidth((this.cd)
										.names[this.forcar])) / 2)),
									117);
									for (int i_279_ = 0;
									(i_279_ < ((this.dispco)
										.npl));
									i_279_++) {
										if ((
										((
										contos[this.forcar])
											.p[i_279_])).colnum == 1) {
											(
											((this.dispco).p[i_279_])).hsb[0] = (this.pcols[this.dispcar]
											[0]);
											(
											((this.dispco).p[i_279_])).hsb[1] = (this.pcols[this.dispcar]
											[1]);
											(
											((this.dispco).p[i_279_])).hsb[2] = (1.0F - (this.pcols[this.dispcar]
											[2]));
										}
										if ((
										((
										contos[this.forcar])
											.p[i_279_])).colnum == 2) {
											(
											((this.dispco).p[i_279_])).hsb[0] = (this.pcols[this.dispcar]
											[3]);
											(
											((this.dispco).p[i_279_])).hsb[1] = (this.pcols[this.dispcar]
											[4]);
											(
											((this.dispco).p[i_279_])).hsb[2] = (1.0F - (this.pcols[this.dispcar]
											[5]));
										}
									}
									(this.m).cx = 561;
									(this.dispco).z = 1200;
									(this.dispco).y = 605 - (
									this.dispco).grat;
									(this.dispco).x = 225;
									(this.dispco).zy = 0;
									(this.dispco).xz = this.mrot;
									this.mrot -= 5;
									if (this.mrot < -360)
									this.mrot += 360;
									(this.dispco).xy = 0;
									(this.dispco).wzy -= 10;
									if ((this.dispco).wzy < -45)
									(this.dispco).wzy += 45;
									this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_OFF);
									this.dispco.d(this.rd);
									this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
									RenderingHints.VALUE_ANTIALIAS_ON);
									(this.m).cx = 400;
									this.rd.setFont(new Font("Arial",
									1, 11));
									int i_280_ = 424;
									int i_281_ = -55;
									this.rd.setColor(new Color(0, 63,
									128));
									this.rd.drawString("Top Speed:",
									30 + i_280_,
									318 + i_281_);
									this.rd.drawImage(((this.xt)
										.statb),
									97 + i_280_, 312 + i_281_, null);
									this.rd.drawString("Acceleration:", 20 + i_280_,
									333 + i_281_);
									this.rd.drawImage(((this.xt)
										.statb),
									97 + i_280_, 327 + i_281_, null);
									this.rd.setColor(color2k(255, 255, 255));
									float f = (float)(((
									this.cd)
										.swits[this.forcar][2]) - 220) / 90.0F;
									if ((double) f < 0.2) f = 0.2F;
									this.rd.fillRect((int)(97.0F + 156.0F * f) + i_280_,
									312 + i_281_, (int)(156.0F * (1.0F - f) + 1.0F),
									7);
									f = (((this.cd).acelf[this.forcar][1]) * ((this.cd)
										.acelf[this.forcar][0]) * ((this.cd)
										.acelf[this.forcar][2]) * ((this.cd)
										.grip[this.forcar]) / 7700.0F);
									if (f > 1.0F) f = 1.0F;
									this.rd.fillRect((int)(97.0F + 156.0F * f) + i_280_,
									327 + i_281_, (int)(156.0F * (1.0F - f) + 1.0F),
									7);
									this.rd.drawImage(((this.xt)
										.statbo),
									97 + i_280_, 312 + i_281_, null);
									this.rd.drawImage(((this.xt)
										.statbo),
									97 + i_280_, 327 + i_281_, null);
									i_280_ = 50;
									i_281_ = -25;
									this.rd.setColor(new Color(0, 63,
									128));
									this.rd.drawString("Stunts:",
									427 + i_280_,
									318 + i_281_);
									this.rd.drawImage(((this.xt)
										.statb),
									471 + i_280_, 312 + i_281_, null);
									this.rd.drawString("Strength:",
									415 + i_280_,
									333 + i_281_);
									this.rd.drawImage(((this.xt)
										.statb),
									471 + i_280_, 327 + i_281_, null);
									this.rd.drawString("Endurance:",
									405 + i_280_,
									348 + i_281_);
									this.rd.drawImage(((this.xt)
										.statb),
									471 + i_280_, 342 + i_281_, null);
									this.rd.setColor(color2k(255, 255, 255));
									f = (((float)((
									this.cd)
										.airc[this.forcar]) * ((this.cd)
										.airs[this.forcar]) * ((this.cd)
										.bounce[this.forcar])) + 28.0F) / 139.0F;
									if (f > 1.0F) f = 1.0F;
									this.rd.fillRect((int)(471.0F + 156.0F * f) + i_280_,
									312 + i_281_, (int)(156.0F * (1.0F - f) + 1.0F),
									7);
									float f_282_ = 0.5F;
									f = (((this.cd)
										.moment[this.forcar]) + f_282_) / 2.6F;
									if (f > 1.0F) f = 1.0F;
									this.rd.fillRect((int)(471.0F + 156.0F * f) + i_280_,
									327 + i_281_, (int)(156.0F * (1.0F - f) + 1.0F),
									7);
									f = ((this.cd).outdam[this.forcar]);
									this.rd.fillRect((int)(471.0F + 156.0F * f) + i_280_,
									342 + i_281_, (int)(156.0F * (1.0F - f) + 1.0F),
									7);
									this.rd.drawImage(((this.xt)
										.statbo),
									471 + i_280_, 312 + i_281_, null);
									this.rd.drawImage(((this.xt)
										.statbo),
									471 + i_280_, 327 + i_281_, null);
									this.rd.drawImage(((this.xt)
										.statbo),
									471 + i_280_, 342 + i_281_, null);
									this.rd.setColor(new Color(0, 0,
									0));
									if (this.forcar < 16) {
										this.rd.setFont(new Font("Arial", 1, 12));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString("Created by Radicalplay.com", (561 - ((this.ftm.stringWidth("Created by Radicalplay.com")) / 2)),
										347);
										String string_283_ = "Game Car";
										if (((this.cd)
											.cclass[this.forcar]) == 0) string_283_ = "Class C ,  Game Car";
										if (((this.cd)
											.cclass[this.forcar]) == 1) string_283_ = "Class B & C ,  Game Car";
										if (((this.cd)
											.cclass[this.forcar]) == 2) string_283_ = "Class B ,  Game Car";
										if (((this.cd)
											.cclass[this.forcar]) == 3) string_283_ = "Class A & B ,  Game Car";
										if (((this.cd)
											.cclass[this.forcar]) == 4) string_283_ = "Class A ,  Game Car";
										this.rd.drawString(string_283_, (561 - (this.ftm.stringWidth(string_283_) / 2)),
										367);
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 0, 12));
										this.ftm = this.rd.getFontMetrics();
										this.rd.drawString("You already have this car.", (561 - ((this.ftm.stringWidth("You already have this car.")) / 2)),
										395);
									} else {
										this.rd.setFont(new Font("Arial", 1, 12));
										this.ftm = this.rd.getFontMetrics();
										if (!(this.cd)
											.createdby[this.forcar - 16].equals((this.xt)
											.nickname)) {
											this.rd.drawString(new StringBuilder().append("Created by :  ").append((
											this.cd)
												.createdby[(this.forcar - 16)])
												.append("").toString(), (561 - ((this.ftm.stringWidth(new StringBuilder()
												.append("Created by :  ")
												.append((
											this.cd)
												.createdby[(this
												.forcar) - 16])
												.append("").toString())) / 2)),
											347);
											int i_284_ = (this.ftm.stringWidth((
											this.cd)
												.createdby[(this.forcar - 16)]));
											int i_285_ = (561 - (this.ftm.stringWidth(new StringBuilder()
												.append("Created by :  ")
												.append((
											this.cd)
												.createdby[(this
												.forcar) - 16])
												.append("")
												.toString())) / 2 + (this.ftm.stringWidth(new StringBuilder()
												.append("Created by :  ")
												.append((
											this.cd)
												.createdby[(this
												.forcar) - 16])
												.append("").toString())) - i_284_);
											this.rd.drawLine(i_285_, 349,
											i_285_ + i_284_ - 2, 349);
											if (i > i_285_ - 2 && i < i_285_ + i_284_ && i_99_ > 334 && i_99_ < 351) {
												if (bool) {
													if (!(
													this.gb)
														.proname.equals((
													this.cd)
														.createdby[(this
														.forcar) - 16])) {
														(
														this.gb)
															.proname = ((
														(this
															.cd))
															.createdby[((
														this).forcar - 16)]);
														(
														this.gb)
															.loadedp = false;
													}
													(this.gb)
														.tab = 1;
													(this.gb)
														.open = 2;
													(this.gb)
														.upo = true;
												}
												i_101_ = 12;
											}
										} else this.rd.drawString("Created by You",
										561 - ((this.ftm.stringWidth("Created by You")) / 2),
										347);
										this.rd.setColor(new Color(128, 73, 0));
										String string_286_ = "";
										if (((this.cd)
											.cclass[this.forcar]) == 0) string_286_ = "Class C ,  ";
										if (((this.cd)
											.cclass[this.forcar]) == 1) string_286_ = "Class B & C ,  ";
										if (((this.cd)
											.cclass[this.forcar]) == 2) string_286_ = "Class B ,  ";
										if (((this.cd)
											.cclass[this.forcar]) == 3) string_286_ = "Class A & B ,  ";
										if (((this.cd)
											.cclass[this.forcar]) == 4) string_286_ = "Class A ,  ";
										if (((this.cd)
											.publish[this.forcar - 16]) == 0) string_286_ = new StringBuilder().append(string_286_).append("Private Car")
											.toString();
										if (((this.cd)
											.publish[this.forcar - 16]) == 1) {
											string_286_ = new StringBuilder().append(string_286_).append("Public Car")
												.toString();
											this.rd.setColor(new Color(0, 64, 128));
										}
										if (((this.cd)
											.publish[this.forcar - 16]) == 2) {
											string_286_ = new StringBuilder().append(string_286_).append("Super Public Car")
												.toString();
											this.rd.setColor(new Color(0, 64, 128));
										}
										this.rd.drawString(string_286_, (561 - (this.ftm.stringWidth(string_286_) / 2)),
										367);
										this.rd.setColor(new Color(0, 0, 0));
										this.rd.setFont(new Font("Arial", 0, 12));
										this.ftm = this.rd.getFontMetrics();
										if (((this.cd)
											.publish[this.forcar - 16]) == 1 || ((this.cd)
											.publish[(this.forcar - 16)]) == 2) {
											if ((
											this.cd).action == -9)
											this.rd.drawString("Failed to add car!  Unknown error!", (561 - ((this
												.ftm.stringWidth("Failed to add car!  Unknown error!")) / 2)),
											395);
											if ((
											this.cd).action == -8)
											this.rd.drawString("Failed!  You already have 20 cars!", (561 - ((this
												.ftm.stringWidth("Failed!  You already have 20 cars!")) / 2)),
											395);
											if ((
											this.cd).action == 7)
											this.rd.drawString(new StringBuilder().append("").append((
											this.cd)
												.names[((
											this.cd)
												.ac)])
												.append(" has been added to your cars!")
												.toString(), (561 - (this.ftm.stringWidth(new StringBuilder().append("").append((
											(this
												.cd))
												.names[((
											(
											this).cd)
												.ac)])
												.append(" has been added to your cars!")
												.toString())) / 2),
											395);
											if ((
											this.cd).action == -7)
											this.rd.drawString("You already have this car.", (561 - ((this
												.ftm.stringWidth("You already have this car.")) / 2)),
											395);
											if ((
											this.cd).action == 6)
											this.rd.drawString("Adding Car...",
											561 - ((this
												.ftm.stringWidth("Adding Car...")) / 2),
											395);
											if ((
											this.cd).action == -6) {
												String string_287_ = "Upgrade to a full account to add custom cars!";
												int i_288_ = (561 - (this
													.ftm.stringWidth(string_287_)) / 2);
												int i_289_ = (i_288_ + (this
													.ftm.stringWidth(string_287_)));
												this.rd.drawString(string_287_, i_288_, 395);
												if (this.waitlink != -1)
												this.rd.drawLine(i_288_, 396, i_289_,
												396);
												if (i > i_288_ && i < i_289_ && i_99_ > 384 && i_99_ < 397) {
													if (this.waitlink != -1) i_101_ = 12;
													if (bool && (this
														.waitlink) == 0) {
														this.gs.editlink((
														(this
															.xt)).nickname,
														true);
														this.waitlink = -1;
													}
												}
												if (this.waitlink > 0)
												this.waitlink--;
											}
											if ((
											this.cd).action == 0 && (this.xt.drawcarb(true, null,
												" Add to My Cars ", 503,
											375, i, i_99_, bool))) {
												if ((
												this.xt)
													.logged) {
													if (((
													this.cd)
														.lastload) != 2 || (this
														.forcar) >= 36) {
														(
														this.cd)
															.action = 6;
														(
														this.cd).ac = (this
															.forcar);
														this.cd.sparkactionloader();
													} else(
													this.cd)
														.action = -7;
												} else {
													(
													this.cd).action = -6;
													this.waitlink = 20;
												}
											}
										} else this.rd.drawString("Private Car.  Cannot be added to account.", (561 - ((this.ftm.stringWidth("Private Car.  Cannot be added to account.")) / 2)),
										395);
									}
									if (this.xt.drawcarb(true, null,
										"X", 682,
									99, i,
									i_99_,
									bool))
									this.dispcar = -1;
								} else this.dispcar = -1;
							}
						}
					}
				} else {
					if (!this.jflexo) {
						this.xt.jflexo();
						this.jflexo = true;
					}
					this.btn = 0;
					if ((this.gs).cmsg.isShowing()) {
						(this.gs).cmsg.hide();
						this.gs.requestFocus();
					}
					this.rd.setColor(color2k(255, 255, 255));
					this.rd.fillRoundRect(155, 148, 490, 127, 20,
					20);
					this.rd.setColor(new Color(0, 0, 0));
					this.rd.drawRoundRect(155, 148, 490, 127, 20,
					20);
					if (this.ontyp != 76) {
						String string = "";
						int i_290_ = 0;
						if (this.ontyp >= 10) {
							i_290_ = 10;
							string = "Custom Cars";
							if (this.ontyp > 10) string = new StringBuilder().append(string).append(", ").toString();
						}
						if (this.ontyp >= 20) {
							i_290_ = 20;
							string = "Game Cars";
							if (this.ontyp > 20) string = new StringBuilder().append(string).append(", ").toString();
						}
						if (this.ontyp >= 30) {
							i_290_ = 30;
							string = "Clan Cars";
							if (this.ontyp > 30) string = new StringBuilder().append(string).append(", ").toString();
						}
						if (this.ontyp - i_290_ == 1) string = new StringBuilder().append(string).append("Class C").toString();
						if (this.ontyp - i_290_ == 2) string = new StringBuilder().append(string).append("Class B & C").toString();
						if (this.ontyp - i_290_ == 3) string = new StringBuilder().append(string).append("Class B").toString();
						if (this.ontyp - i_290_ == 4) string = new StringBuilder().append(string).append("Class A & B").toString();
						if (this.ontyp - i_290_ == 5) string = new StringBuilder().append(string).append("Class A").toString();
						if (this.ontyp <= -2) {
							if (Math.abs(this.ontyp + 2) == 13) string = new StringBuilder().append(" ").append((this.cd)
								.names[Math.abs(this.ontyp + 2)])
								.append("  Game").toString();
							else string = new StringBuilder().append("").append((this.cd)
								.names[Math.abs(this.ontyp + 2)])
								.append(" Game").toString();
						}
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.setFont(new Font("Arial", 1, 13));
						this.ftm = this.rd.getFontMetrics();
						this.rd.drawString(new StringBuilder().append(": :   ").append(string).append("   : :").toString(),
						400 - (this.ftm.stringWidth(new StringBuilder().append(": :   ")
							.append(string).append("   : :").toString())) / 2,
						175);
						string = "a";
						if (this.ontyp - i_290_ == 1) string = "a class C";
						if (this.ontyp - i_290_ == 2) string = "a class B or C";
						if (this.ontyp - i_290_ == 3) string = "a class B";
						if (this.ontyp - i_290_ == 4) string = "a class A or B";
						if (this.ontyp - i_290_ == 5) string = "a class A";
						if (i_290_ == 0) string = new StringBuilder().append(string).append(" car").toString();
						if (i_290_ == 10) string = new StringBuilder().append(string).append(" custom car").toString();
						if (i_290_ == 20) string = new StringBuilder().append(string).append(" game car").toString();
						if (i_290_ == 30) string = new StringBuilder().append(string).append(" clan car").toString();
						if (this.ontyp <= -2) {
							if (Math.abs(this.ontyp + 2) == 13) string = new StringBuilder().append(" ").append((this.cd)
								.names[Math.abs(this.ontyp + 2)])
								.append(" ").toString();
							else string = new StringBuilder().append("").append((this.cd)
								.names[Math.abs(this.ontyp + 2)])
								.append("").toString();
						}
						this.rd.drawString(new StringBuilder().append("To join this game you need to have ").append(string).append("!").toString(), (400 - (this.ftm.stringWidth(new StringBuilder().append("To join this game you need to have ")
							.append(string).append("!").toString())) / 2),
						206);
						stringbutton(new StringBuilder().append("  Get ")
							.append(string).append(" now  ").toString(),
						400, 247, 0);
						stringbutton("  Cancel X  ", 593, 259, 2);
						if ((this.gb).open > 0 && (this.gb).upo)
						this.onjoin = -1;
					} else {
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.setFont(new Font("Arial", 1, 13));
						this.ftm = this.rd.getFontMetrics();
						this.rd.drawString(": :   Custom Stage   : :", (400 - (this.ftm.stringWidth(": :   Custom Stage   : :") / 2)),
						175);
						this.rd.drawString("You need to upgrade to a full account to join this game!", (400 - ((this.ftm.stringWidth("You need to upgrade to a full account to join this game!")) / 2)),
						202);
						this.rd.setColor(color2k(200, 200, 200));
						this.rd.fillRoundRect(310, 215, 180, 50, 20,
						20);
						drawSbutton((this.xt).upgrade,
						400, 240);
						stringbutton("  Cancel X  ", 593, 259, 2);
					}
				}
			} else {
				this.xt.mainbg(3);
				this.btn = 0;
				if ((this.gs).cmsg.isShowing()) {
					(this.gs).cmsg.hide();
					this.gs.requestFocus();
				}
				this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
				this.rd.drawImage(((this.xt)
					.bggo),
				0, 0, null);
				this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
				this.rd.setColor(new Color(0, 0, 0));
				this.rd.fillRect(65, 425, 670, 25);
				this.rd.fillRect(0, 0, 65, 450);
				this.rd.fillRect(735, 0, 65, 450);
				this.rd.fillRect(65, 0, 670, 25);
				float f = 1.0F - (float)((this.lg).flipo - 10) / 80.0F;
				if (f > 1.0F) f = 1.0F;
				if (f < 0.0F) f = 0.0F;
				this.rd.setComposite(AlphaComposite.getInstance(3,
				f));
				if ((this.lg).flipo > 10)
				this.rd.drawImage((this.xt).logomadnes,
				97 + (int)(2.0 - Math.random() * 4.0),
				36 + (int)(2.0 - Math.random() * 4.0), null);
				else this.rd.drawImage((
				this.xt).logomadnes,
				97, 36, null);
				(this.lg).flipo++;
				if ((this.lg).flipo > 50)
				(this.lg).flipo = 0;
				int i_291_ = 30;
				this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
				this.rd.setColor(new Color(203, 227, 253));
				this.rd.fillRoundRect(115, 57 + i_291_, 570, 307, 20,
				20);
				this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
				this.rd.setColor(color2k(90, 90, 90));
				this.rd.drawRoundRect(115, 57 + i_291_, 570, 307, 20,
				20);
				this.rd.setFont(new Font("Arial", 1, 13));
				this.ftm = this.rd.getFontMetrics();
				this.rd.setColor(color2k(0, 0, 0));
				this.rd.drawString("You are allowed 5 multiplayer turns per day to try the game with your trial account.",
				135, 85 + i_291_);
				this.rd.drawString("Upgrade your account to a full account to purchase and play the multiplayer game.",
				135, 105 + i_291_);
				drawSbutton((this.xt).upgrade, 400,
				130 + i_291_);
				this.rd.setColor(new Color(30, 70, 110));
				this.rd.drawString("You can upgrade your account by just sharing the game & posting about it online!",
				135, 165 + i_291_);
				this.rd.drawString("Click 'Upgrade' for more details.", 135, 185 + i_291_);
				this.rd.drawString("Or try the multiplayer again tomorrow.", 135,
				205 + i_291_);
				this.rd.setColor(color2k(0, 0, 0));
				this.rd.drawString("For now to preview and try the multiplayer more, with your trial account you can:",
				135, 245 + i_291_);
				this.rd.setColor(new Color(30, 70, 110));
				this.rd.drawString("-  Watch online multiplayer games.", 135, 265 + i_291_);
				this.rd.drawString("-  Access the multiplayer dome.",
				135, 285 + i_291_);
				this.rd.drawString("-  Play LAN multiplayer games (unlimitedly).", 135,
				305 + i_291_);
				drawSbutton((this.xt).exit, 400,
				336 + i_291_);
			}
		} else {
			this.xt.drawWarning();
			if ((this.gs).cmsg.isShowing()) {
				(this.gs).cmsg.hide();
				this.gs.requestFocus();
			}
			if ((this.xt).warning > 220) {
				this.conon = 0;
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
			(this.xt).warning++;
		}
		if (i_101_ != this.pcurs) {
			this.gs.setCursor(new Cursor(i_101_));
			this.pcurs = i_101_;
		}
	}

	public void preforma(int i, int i_292_) {
		if (this.pre1) {
			boolean bool = false;
			if (!(this.gs).openm && (this.gb).open == 0) {
				if (this.conon != 0) bool = true;
			} else if ((this.gs).cmsg.isShowing())
			(this.gs).cmsg.hide();
			this.gs.movefieldd(((this.gs)
				.cmsg),
			235, 390, 360, 22, bool);
			if ((this.gs).cmsg.getText()
				.equals("Type here...") && i > 234 && i < 603 && i_292_ > 385 && i_292_ < 417)
			(this.gs).cmsg.setText("");
		}
		if (this.pre2) {
			boolean bool = false;
			if (!(this.gs).openm && (this.gb).open == 0) bool = true;
			else if ((this.gs).cmsg.isShowing())
			(this.gs).cmsg.hide();
			this.gs.movefieldd(((this.gs)
				.cmsg),
			237, 390, 360, 22, bool);
			if ((this.gs).cmsg.getText()
				.equals("Type here...") && i > 232 && i < 601 && i_292_ > 385 && i_292_ < 417)
			(this.gs).cmsg.setText("");
		}
		if (this.pre1 || this.pre2) {
			if ((this.gs).cmsg.getText().length() > 100) {
				(this.gs).cmsg.setText((this.gs).cmsg.getText()
					.substring(0, 100));
				(this.gs).cmsg.select(100, 100);
			}
			this.pre1 = false;
			this.pre2 = false;
		}
	}

	public void stageselect(CheckPoints checkpoints, Control control, int i,
	int i_293_, boolean bool) {
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(0, 0, 65, 450);
		this.rd.fillRect(735, 0, 65, 450);
		this.rd.fillRect(65, 0, 670, 25);
		this.rd.fillRect(65, 425, 670, 25);
		this.btn = 0;
		int i_294_ = 0;
		this.rd.drawImage((this.xt).br, 65,
		25, null);
		if (this.britchl == -1) {
			this.ongame = -1;
			this.britchl = 0;
		}
		int i_295_ = 0;
		for (int i_296_ = 0; i_296_ < this.ngm; i_296_++) {
			if (this.ongame == this.gnum[i_296_]) i_295_ = i_296_;
		}
		if (this.chalngd != -2 && this.ongame != -1) {
			this.rd.setColor(color2k(20, 20, 20));
			this.rd.fillRect(80, 0, 640, 40);
			this.rd.setColor(color2k(70, 70, 70));
			this.rd.drawLine(80, 40, 720, 40);
			this.rd.drawLine(80, 40, 80, 0);
			this.rd.drawLine(720, 40, 720, 0);
			this.rd.setColor(new Color(193, 106, 0));
			this.rd.setFont(new Font("Arial", 1, 12));
			this.ftm = this.rd.getFontMetrics();
			if (this.wait[i_295_] > 0) {
				if (this.gwarb[i_295_] == 0) {
					if (this.wait[i_295_] > 30 || this.npls[i_295_] <= 1) {
						String string = "";
						if (this.npls[i_295_] > 1) {
							Date date = new Date();
							long l = date.getTime();
							if (this.ptime == 0L || l > this.ptime + 1500L) {
								if (this.ptime != 0L) {
									this.wait[i_295_]--;
									if (this.wait[i_295_] < 1)
									this.wait[i_295_] = 1;
								}
								this.ptime = l;
							}
							string = new StringBuilder().append(" (waiting ").append(this.wait[i_295_]).append(" seconds maximum)").toString();
							if (this.wait[i_295_] > 60) string = new StringBuilder().append(" (waiting ").append((float)(int)((float)((
							this)
								.wait[i_295_]) / 60.0F * 100.0F) / 100.0F)
								.append(" minutes maximum)").toString();
						}
						this.rd.drawString(new StringBuilder().append("Waiting for ").append(this.mnpls[i_295_] - this.npls[i_295_])
							.append(" more players to join to start this game")
							.append(string).append("!").toString(),
						95, 15);
						this.rd.setFont(new Font("Arial", 0, 12));
						if (!this.gmaker[i_295_].equals("Coach Insano") && !(this.gmaker[i_295_].equals(this.pnames[this.im]))) {
							boolean bool_297_ = false;
							for (int i_298_ = 0; i_298_ < this.npo;
							i_298_++) {
								if ((this.pgames[i_298_] == this.ongame) && (this.gmaker[i_295_].equals(this.pnames[i_298_]))) bool_297_ = true;
							}
							if (bool_297_)
							this.rd.drawString(new StringBuilder().append("").append(this.gmaker[i_295_]).append(" can start this game at anytime (the game creator)...")
								.toString(),
							95, 31);
						}
					} else {
						Date date = new Date();
						long l = date.getTime();
						if (this.ptime == 0L || l > this.ptime + 1500L) {
							if (this.ptime != 0L) {
								this.wait[i_295_]--;
								if (this.wait[i_295_] < 1)
								this.wait[i_295_] = 1;
							}
							this.ptime = l;
						}
						if ((this.pgames[this.im] == this.ongame) || this.nflk != 0) {
							this.rd.drawString(new StringBuilder().append("Game starts in ").append(this.wait[i_295_]).append(" seconds!").toString(),
							400 - (this.ftm.stringWidth(new StringBuilder().append("Game starts in ").append(this.wait[i_295_])
								.append(" seconds!").toString())) / 2,
							23);
							if (this.pgames[this.im] != this.ongame)
							this.nflk--;
						} else if (this.pgames[this.im] != this.ongame)
						this.nflk = 3;
					}
				} else this.rd.drawString(new StringBuilder().append("Waiting for ").append(this.mnpls[i_295_] - this.npls[i_295_])
					.append(" clan members to join to start this game!")
					.toString(),
				95, 23);
				if (this.pgames[this.im] != this.ongame) {
					boolean bool_299_ = false;
					if (this.gwarb[i_295_] == 0) {
						if (this.gplyrs[i_295_].equals("") || ((this.gplyrs[i_295_].indexOf(this.pnames[this.im])) != -1)) bool_299_ = true;
					} else if (((this.xt).clan.toLowerCase().equals(this.gaclan[i_295_].toLowerCase())) || ((this.xt).clan.toLowerCase().equals(this.gvclan[i_295_].toLowerCase()))) bool_299_ = true;
					if (bool_299_) stringbutton(" Join Game ", 660, 23, 2);
				}
			} else {
				this.rd.setColor(color2k(120, 120, 120));
				if (this.wait[i_295_] == 0)
				this.rd.drawString("Game Started",
				400 - (this.ftm.stringWidth("Game Started") / 2),
				20);
				else this.rd.drawString("Game Finished",
				400 - (this.ftm.stringWidth("Game Finished") / 2),
				20);
			}
		}
		this.rd.setFont(new Font("Arial", 1, 11));
		(this.xt).ftm = this.rd.getFontMetrics();
		this.ftm = this.rd.getFontMetrics();
		String string = "";
		if ((checkpoints).stage < 0) string = "Custom Stage";
		if ((checkpoints).stage > 0 && (checkpoints).stage <= 10) string = new StringBuilder().append("Stage ").append((checkpoints).stage).append(" NFM 1").toString();
		if ((checkpoints).stage > 10 && (checkpoints).stage <= 27) string = new StringBuilder().append("Stage ").append((checkpoints).stage - 10).append(" NFM 2").toString();
		if ((checkpoints).stage > 27) string = new StringBuilder().append("Multiplayer Stage ").append((checkpoints).stage - 27).append("").toString();
		this.xt.drawcs(85, new StringBuilder().append("Previewing ").append(string).append("  >").toString(), 255, 138, 0, 5);
		this.xt.drawcs(105,
		new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(),
		255, 176, 85, 5);
		this.rd.drawImage(((this.xt).back[this.pback]),
		532, 285, null);
		if (this.plsndt == 0) {
			String string_300_ = "Play Soundtrack >";
			int i_301_ = 562 - this.ftm.stringWidth(string_300_) / 2;
			int i_302_ = i_301_ + this.ftm.stringWidth(string_300_);
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString(string_300_, i_301_ + 1, 326);
			this.rd.drawLine(i_301_ + 1, 328, i_302_ + 1, 328);
			this.rd.setColor(new Color(255, 138, 0));
			this.rd.drawString(string_300_, i_301_, 325);
			this.rd.drawLine(i_301_, 327, i_302_, 327);
			if (i > i_301_ && i < i_302_ && i_293_ > 314 && i_293_ < 327) {
				i_294_ = 12;
				if (bool)
				this.plsndt = 1;
			}
		}
		if (this.plsndt == 1)
		this.xt.drawcs(190, "Loading Soundtrack, please wait...",
		255, 138, 0, 5);
		if ((checkpoints).stage < 0) {
			this.rd.setColor(new Color(255, 138, 0));
			this.rd.drawString(new StringBuilder().append("Created by: ").append((checkpoints)
				.maker)
				.append("").toString(),
			85, 413);
			if ((checkpoints).pubt > 0) {
				if ((checkpoints).pubt == 2)
				this.xt.drawcs(413, "Super Public Stage", 41,
				177, 255, 3);
				else this.xt.drawcs(413, "Public Stage", 41, 177, 255,
				3);
				if (this.addstage == 0 && this.xt.drawcarb(true, null,
					" Add to My Stages ", 334,
				420, i, i_293_, bool)) {
					if ((this.xt).logged) {
						(this.cd).onstage = (checkpoints).name;
						(this.cd).staction = 2;
						this.cd.sparkstageaction();
						this.addstage = 2;
					} else {
						this.addstage = 1;
						this.waitlink = 20;
					}
				}
				if (this.addstage == 1) {
					this.rd.setFont(new Font("Arial", 1, 11));
					this.ftm = this.rd.getFontMetrics();
					this.rd.setColor(new Color(193, 106, 0));
					String string_303_ = "Upgrade to a full account to add custom stages!";
					int i_304_ = (400 - this.ftm.stringWidth(string_303_) / 2);
					int i_305_ = i_304_ + this.ftm.stringWidth(string_303_);
					this.rd.drawString(string_303_, i_304_, 435);
					if (this.waitlink != -1)
					this.rd.drawLine(i_304_, 437, i_305_, 437);
					if (i > i_304_ && i < i_305_ && i_293_ > 424 && i_293_ < 437) {
						if (this.waitlink != -1) i_294_ = 12;
						if (bool && this.waitlink == 0) {
							this.gs.editlink(((
							this.xt)
								.nickname),
							true);
							this.waitlink = -1;
						}
					}
					if (this.waitlink > 0)
					this.waitlink--;
				}
				if (this.addstage == 2) {
					this.xt.drawcs(435,
						"Adding stage please wait...",
					193, 106, 0, 3);
					if ((this.cd).staction == 0)
					this.addstage = 3;
					if ((this.cd).staction == -2)
					this.addstage = 4;
					if ((this.cd).staction == -3)
					this.addstage = 5;
					if ((this.cd).staction == -1)
					this.addstage = 6;
				}
				if (this.addstage == 3)
				this.xt.drawcs(435,
					"Stage has been successfully added to your stages!",
				193, 106, 0, 3);
				if (this.addstage == 4)
				this.xt.drawcs(435,
					"You already have this stage!",
				193, 106, 0, 3);
				if (this.addstage == 5)
				this.xt.drawcs(435,
					"Cannot add more then 20 stages to your account!",
				193, 106, 0, 3);
				if (this.addstage == 6)
				this.xt.drawcs(435,
					"Failed to add stage, unknown error, please try again later.",
				193, 106, 0, 3);
			} else this.xt.drawcs(435, "Private Stage", 193, 106, 0, 3);
		}
		if ((control).enter || this.conon == 2 || this.ongame == -1 && this.chalngd != -2) {
			(this.m).trk = 0;
			if ((this.xt).loadedt)
			(this.xt).strack.unload();
			(this.m).focus_point = 400;
			(this.m).crs = true;
			(this.m).x = -335;
			(this.m).y = 0;
			(this.m).z = -50;
			(this.m).xz = 0;
			(this.m).zy = 20;
			(this.m).ground = -2000;
			this.fase = 1;
			(control).enter = false;
		}
		if (i_294_ != this.pcurs) {
			this.gs.setCursor(new Cursor(i_294_));
			this.pcurs = i_294_;
		}
	}

	public void ctachm(int i, int i_306_, int i_307_, Control control) {
		int i_308_ = -1;
		if (this.fase == 1 || this.fase == 4) {
			for (int i_309_ = 0; i_309_ < this.btn; i_309_++) {
				if ((Math.abs(i - this.bx[i_309_]) < this.bw[i_309_] / 2 + 12) && Math.abs(i_306_ - this.by[i_309_]) < 14 && (i_307_ == 1 || i_307_ == 11))
				this.pessd[i_309_] = true;
				else this.pessd[i_309_] = false;
				if ((Math.abs(i - this.bx[i_309_]) < this.bw[i_309_] / 2 + 12) && Math.abs(i_306_ - this.by[i_309_]) < 14 && i_307_ <= -1) {
					i_308_ = i_309_;
					(this.gs).mouses = 0;
				}
			}
		}
		if (this.conon == 1) {
			if (!this.regnow) {
				if (this.onjoin == -1) {
					if (this.fase == 4) {
						if (i > 532 && i < 592 && i_306_ > 285 && i_306_ < 306 && (i_307_ == 1 || i_307_ == 11))
						this.pback = 1;
						else this.pback = 0;
						if (i > 532 && i < 592 && i_306_ > 285 && i_306_ < 306 && i_307_ <= -1) {
							(this.gs).mouses = 0;
							(this.m).trk = 0;
							if ((this.xt).loadedt)
							(this.xt).strack.unload();
							(this.m).focus_point = 400;
							(this.m).crs = true;
							(this.m).x = -335;
							(this.m).y = 0;
							(this.m).z = -50;
							(this.m).xz = 0;
							(this.m).zy = 20;
							(this.m).ground = -2000;
							this.fase = 1;
						}
						if (i_308_ == 0 && this.chalngd == -1) {
							i_308_ = -1;
							this.join = this.ongame;
							this.msg = "| Joining Game |";
							this.spos = 0;
							(this.m).trk = 0;
							if ((this.xt).loadedt)
							(this.xt).strack.unload();
							(this.m).focus_point = 400;
							(this.m).crs = true;
							(this.m).x = -335;
							(this.m).y = 0;
							(this.m).z = -50;
							(this.m).xz = 0;
							(this.m).zy = 20;
							(this.m).ground = -2000;
							this.fase = 1;
						}
					}
					if (this.fase == 1) {
						if (this.ongame == -1) {
							if (i_308_ == 0) {
								if (this.chalngd == -1) {
									if ((this.xt).lan && !this.lanlogged)
									this.gs.reglink();
									else {
										boolean bool = false;
										for (int i_310_ = 0;
										i_310_ < this.ngm;
										i_310_++) {
											if (this.wait[i_310_] == 0) {
												bool = true;
												break;
											}
										}
										if (!bool || (
										this.xt).lan) {
											this.loadstage = 0;
											this.remstage = 0;
											this.gstage = 0;
											this.gnpls = 8;
											this.gwait = 0;
											this.gnbts = 0;
											this.gclass = 0;
											this.gcars = 0;
											this.gfix = 0;
											this.gnotp = 0;
											this.gplayers = "";
											(this.gs)
												.wgame.select(0);
											this.chalngd = -2;
										} else this.chalngd = -6;
									}
								} else if (this.chalngd != -5) {
									if (this.invo)
									this.invo = false;
									for (int i_311_ = 0; i_311_ < 7;
									i_311_++) {
										if (!this.invos[i_311_].equals(""))
										this.invos[i_311_] = "";
										if (!this.dinvi[i_311_].equals(""))
										this.dinvi[i_311_] = "";
									}
									(this.gs).swait.hide();
									(this.gs).snpls.hide();
									(this.gs).snbts.hide();
									(this.gs).sgame.hide();
									(this.gs).wgame.hide();
									(this.gs).pgame.hide();
									(this.gs).vnpls.hide();
									(this.gs).vtyp.hide();
									(this.gs).warb.hide();
									(this.gs).mstgs.hide();
									(this.gs).slaps.hide();
									(this.gs).snfm1.hide();
									(this.gs).snfmm.hide();
									(this.gs).snfm2.hide();
									(this.gs)
										.sclass.hide();
									(this.gs).scars.hide();
									(this.gs).sfix.hide();
									(this.gs).mycar.hide();
									(this.gs).notp.hide();
									this.gs.requestFocus();
									this.chalngd = -1;
								}
							}
							if (i_308_ == 1)
							(this.xt).fase = 23;
							if (i_308_ == 2) {
								this.conon = 0;
								this.lg.exitfromlobby();
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
								hideinputs();
							}
							int i_312_ = 3;
							if (this.chalngd > -1) {
								if (i_308_ == 3) {
									this.ongame = this.chalngd;
									this.chalngd = -1;
								}
								if (i_308_ == 4) {
									this.ongame = this.chalngd;
									this.join = this.chalngd;
									this.msg = "| Joining Game |";
									this.chalngd = -1;
									this.longame = -1;
								}
								if (i_308_ == 5) {
									this.ongame = this.longame;
									this.chalngd = -1;
									this.longame = -1;
								}
								i_312_ = 6;
							} else {
								if (this.chalngd != -1 && this.chalngd != -5 && i_308_ == 3) {
									if (this.invo)
									this.invo = false;
									for (int i_313_ = 0; i_313_ < 7;
									i_313_++) {
										if (!this.invos[i_313_].equals(""))
										this.invos[i_313_] = "";
										if (!this.dinvi[i_313_].equals(""))
										this.dinvi[i_313_] = "";
									}
									(this.gs).swait.hide();
									(this.gs).snpls.hide();
									(this.gs).snbts.hide();
									(this.gs).sgame.hide();
									(this.gs).wgame.hide();
									(this.gs).pgame.hide();
									(this.gs).vnpls.hide();
									(this.gs).vtyp.hide();
									(this.gs).warb.hide();
									(this.gs).mstgs.hide();
									(this.gs).slaps.hide();
									(this.gs).snfm1.hide();
									(this.gs).snfmm.hide();
									(this.gs).snfm2.hide();
									(this.gs)
										.sclass.hide();
									(this.gs).scars.hide();
									(this.gs).sfix.hide();
									(this.gs).mycar.hide();
									(this.gs).notp.hide();
									this.gs.requestFocus();
									this.chalngd = -1;
								}
								if (this.chalngd == -6 && i_308_ == 4)
								this.chalngd = -1;
								if (this.chalngd == -2) {
									if ((this.gs)
										.wgame.getSelectedIndex() == 0) {
										if ((this.gs)
											.sgame.getSelectedIndex() >= 3 && !(
										this.xt).logged) {
											if (i_308_ == 4)
											this.gs.editlink(((
											this.xt)
												.nickname),
											true);
											i_312_ = 5;
										} else {
											if (i_308_ == 4) {
												if (this.loadstage < 0) {
													this.rd.setColor(new Color(0, 0, 0));
													this.rd.fillRect(0, 0, 670, 400);
													this.gs.repaint();
													(
													this.gs)
														.rooms.hide();
													(
													this.gs)
														.cmsg.hide();
													(
													this.gs)
														.sgame.hide();
													(
													this.gs)
														.wgame.hide();
													(
													this.gs)
														.warb.hide();
													(
													this.gs)
														.pgame.hide();
													(
													this.gs)
														.vnpls.hide();
													(
													this.gs)
														.vtyp.hide();
													(
													this.gs)
														.mstgs.hide();
													(
													this.gs)
														.slaps.hide();
													(
													this.gs)
														.snfm1.hide();
													(
													this.gs)
														.snfmm.hide();
													(
													this.gs)
														.snfm2.hide();
													this.gs.requestFocus();
													(this.m)
														.ptr = 0;
													(this.m)
														.ptcnt = -10;
													(this.m)
														.hit = 20000;
													(this.m)
														.fallen = 0;
													(this.m)
														.nrnd = 0;
													(this.m)
														.ih = 25;
													(this.m)
														.iw = 65;
													(this.m)
														.h = 425;
													(this.m)
														.w = 735;
													(this.m)
														.trk = 4;
													this.plsndt = 0;
													this.addstage = 0;
													this.fase = 4;
												} else this.sflk = 25;
											}
											if (this.loadstage >= 0) i_312_ = 5;
											else {
												if (i_308_ == 5) {
													if (this.gstage != 0) {
														(
														this.gs)
															.sgame.hide();
														(
														this.gs)
															.wgame.hide();
														(
														this.gs)
															.pgame.hide();
														(
														this.gs)
															.vnpls.hide();
														(
														this.gs)
															.vtyp.hide();
														(
														this.gs)
															.warb.hide();
														(
														this.gs)
															.mstgs.hide();
														(
														this.gs)
															.slaps.hide();
														(
														this.gs)
															.snfm1.hide();
														(
														this.gs)
															.snfmm.hide();
														(
														this.gs)
															.snfm2.hide();
														this.gs.requestFocus();
														this.chalngd = -3;
														i_308_ = -1;
													} else this.sflk = 25;
												}
												i_312_ = 6;
											}
										}
									} else if (!(
									this.xt)
										.clan.equals("")) {
										int i_314_ = 4;
										if ((((
										this.gs).warb)
											.sel) != 0 && ((this.gb)
											.loadwbgames) == 2) {
											if (((
											this.gs)
												.wgame.getSelectedIndex() == 1) && (((
											(this
												.gs)).vnpls).sel != 0) && (this.cancreate == 2)) {
												if (i_308_ == 4) {
													if (this.invo)
													this.invo = false;
													this.msg = "| Creating Game |";
													this.gplayers = new StringBuilder().append("#warb#").append((
													(this
														.gb)).warb)
														.append("#").append((
													(this
														.gb)).warbnum)
														.append("#").append((
													(this
														.gb)).gameturn + 1)
														.append("#").append((
													(this
														.xt)).clan)
														.append("#").append((
													(this
														.gb)).vclan)
														.append("#").append((
													(this
														.gb)).ascore)
														.append("#").append((
													(this
														.gb)).vscore)
														.append("#").append((
													((
													(
													this).gs)
														.vtyp)).sel + 1)
														.append("#").toString();
													this.gstage = ((
													this.gb)
														.wbstage[(
													(this
														.gb)).gameturn]);
													this.gstagelaps = ((
													this.gb)
														.wblaps[(
													(this
														.gb)).gameturn]);
													this.gcars = (((
													this.gb)
														.wbcars[(
													(this
														.gb)).gameturn]) - 1);
													this.gclass = ((
													this.gb)
														.wbclass[(
													(this
														.gb)).gameturn]);
													this.gfix = ((
													this.gb)
														.wbfix[(
													(this
														.gb)).gameturn]);
													this.gnpls = 8;
													if ((
													((
													this.gs)
														.vnpls)).sel == 1)
													this.gnpls = 4;
													if ((
													((
													this.gs)
														.vnpls)).sel == 2)
													this.gnpls = 6;
													this.gwait = 120;
													this.gnotp = 0;
													(
													this.gs)
														.wgame.hide();
													(
													this.gs)
														.pgame.hide();
													(
													this.gs)
														.vnpls.hide();
													(
													this.gs)
														.vtyp.hide();
													(
													this.gs)
														.warb.hide();
													this.gs.requestFocus();
													this.chalngd = -5;
												}
												i_314_++;
											}
											if (((
											this.gs)
												.wgame.getSelectedIndex() == 2) && (((
											(this
												.gs)).pgame).sel != 0) && i_308_ == 4) {
												if (this.invo)
												this.invo = false;
												this.msg = "| Creating Game |";
												this.gstage = ((
												this.gb)
													.wbstage[(
												((
												this.gs)
													.pgame)).sel - 1]);
												this.gstagelaps = ((
												this.gb)
													.wblaps[(
												((
												this.gs)
													.pgame)).sel - 1]);
												this.gcars = (((
												this.gb)
													.wbcars[(
												((
												this.gs)
													.pgame)).sel - 1]) - 1);
												this.gclass = ((
												this.gb)
													.wbclass[(
												((
												this.gs)
													.pgame)).sel - 1]);
												this.gfix = ((
												this.gb)
													.wbfix[(
												((
												this.gs)
													.pgame)).sel - 1]);
												this.gnpls = 8;
												this.gwait = 120;
												this.gnotp = 0;
												this.gplayers = "";
												(
												this.gs)
													.wgame.hide();
												(
												this.gs)
													.pgame.hide();
												(
												this.gs)
													.vnpls.hide();
												(
												this.gs)
													.vtyp.hide();
												(
												this.gs)
													.warb.hide();
												this.gs.requestFocus();
												this.chalngd = -5;
											}
											if (((
											this.gs)
												.wgame.getSelectedIndex() == 1) && ((this.gb)
												.canredo) && i_308_ == i_314_)
											(this.gb)
												.loadwbgames = 7;
										}
									} else if (i_308_ == 4) {
										(this.gb).tab = 3;
										(this.gb).cfase = 2;
										(this.gb).em = 1;
										(this.gb).msg = "Clan Search";
										(this.gb).smsg = "Listing clans with recent activity...";
										(this.gb).nclns = 0;
										(this.gb).spos5 = 0;
										(this.gb).lspos5 = 0;
										(this.gb).flko = 0;
										(this.gb).open = 2;
										(this.gb).upo = true;
									}
								}
								if (this.chalngd == -3) {
									if (i_308_ == 4) {
										this.chalngd = -2;
										(this.gs)
											.snpls.hide();
										(this.gs)
											.snbts.hide();
										(this.gs)
											.swait.hide();
										this.gs.requestFocus();
									}
									if (i_308_ == 5) {
										if (this.gnpls != 0 && ((
										this.gs)
											.snpls.getSelectedIndex() != 0)) {
											this.chalngd = -4;
											for (int i_315_ = 0; i_315_ < 7;
											i_315_++) {
												if (!this.invos[i_315_].equals(""))
												this.invos[i_315_] = "";
												if (!this.dinvi[i_315_].equals(""))
												this.dinvi[i_315_] = "";
											}
											i_308_ = -1;
											(this.gs)
												.snpls.hide();
											(this.gs)
												.snbts.hide();
											(this.gs)
												.swait.hide();
											this.gs.requestFocus();
										} else this.sflk = 25;
									}
									i_312_ = 6;
								}
								if (this.chalngd == -4) {
									i_312_ = 7;
									int i_316_ = 0;
									for (int i_317_ = 0; i_317_ < 7;
									i_317_++) {
										if (!this.invos[i_317_].equals("")) i_316_++;
									}
									if (i_316_ < this.gnpls - 1) {
										if (i_308_ == 4) {
											if (!this.invo)
											this.invo = true;
											else this.invo = false;
										}
									} else i_312_ = 6;
									if (i_308_ == i_312_ - 2) {
										if (this.invo)
										this.invo = false;
										if ((this.gs)
											.mycar.getState() && ((
										this.xt).sc[0] < 16)) {
											this.gclass = -((
											this.xt).sc[0] + 2);
											this.gcars = 0;
										}
										if ((this.gs)
											.notp.getState())
										this.gnotp = 1;
										else this.gnotp = 0;
										this.gplayers = "";
										(this.gs)
											.sclass.hide();
										(this.gs)
											.scars.hide();
										(this.gs)
											.sfix.hide();
										(this.gs)
											.mycar.hide();
										(this.gs)
											.notp.hide();
										this.gs.requestFocus();
										this.chalngd = -3;
									}
									if (i_308_ == i_312_ - 1) {
										if (this.invo)
										this.invo = false;
										this.msg = "| Creating Game |";
										if ((this.gs)
											.mycar.getState() && ((
										this.xt).sc[0] < 16)) {
											this.gclass = -((
											this.xt).sc[0] + 2);
											this.gcars = 0;
										}
										if (this.gclass != 0)
										this.gwait = 120;
										if ((this.gs)
											.notp.getState())
										this.gnotp = 1;
										else this.gnotp = 0;
										this.gplayers = "";
										if (i_316_ != 0) {
											this.gnpls = i_316_ + 1;
											this.gplayers = new StringBuilder().append("").append(this.pnames[this.im])
												.append("#").toString();
											for (int i_318_ = 0;
											i_318_ < i_316_; i_318_++) {
												StringBuilder stringbuilder = new StringBuilder();
												Lobby lobby_319_ = this;
												(lobby_319_).gplayers = stringbuilder.append((lobby_319_)
													.gplayers)
													.append(this.invos[i_318_])
													.append("#").toString();
											}
										}
										(this.gs)
											.sclass.hide();
										(this.gs)
											.scars.hide();
										(this.gs)
											.sfix.hide();
										(this.gs)
											.mycar.hide();
										(this.gs)
											.notp.hide();
										this.gs.requestFocus();
										this.chalngd = -5;
									}
								}
							}
							if (i_308_ == i_312_ && !(this.xt).lan && !(this.gs).cmsg.getText().equals("Type here...") && !(this.gs).cmsg.getText().equals("")) {
								String string = (this.gs)
									.cmsg.getText().replace('|', ':');
								if ((string.toLowerCase().indexOf((this.gs)
									.tpass.getText().toLowerCase())) != -1) string = " ";
								if (!this.xt.msgcheck(string) && this.updatec > -12) {
									for (int i_320_ = 0; i_320_ < 6;
									i_320_++) {
										this.sentn[i_320_] = this.sentn[i_320_ + 1];
										this.cnames[i_320_] = (this.cnames[i_320_ + 1]);
									}
									this.sentn[6] = string;
									this.cnames[6] = (this.pnames[this.im]);
									if (this.updatec > -11)
									this.updatec = -11;
									else this.updatec--;
									this.spos3 = 28;
								} else(this.xt).warning++;
								(this.gs).cmsg.setText("");
							}
						} else if (this.dispcar == -1) {
							int i_321_ = 0;
							for (int i_322_ = 0; i_322_ < this.ngm;
							i_322_++) {
								if (this.ongame == this.gnum[i_322_]) i_321_ = i_322_;
							}
							boolean bool = false;
							if (this.gwarb[i_321_] == 0) {
								if (!this.gplyrs[i_321_].equals("") && (this.gplyrs[i_321_].indexOf(this.pnames[this.im])) == -1) bool = true;
							} else if (!((this.xt)
								.clan.toLowerCase().equals(this.gaclan[i_321_].toLowerCase())) && !((this.xt)
								.clan.toLowerCase().equals(this.gvclan[i_321_].toLowerCase()))) bool = true;
							if ((control).enter && this.wait[i_321_] > 0 && (this.pgames[this.im] == -1) && !bool) {
								this.join = this.ongame;
								this.msg = "| Joining Game |";
								this.spos = 0;
								if (this.pbtn == 0)
								this.pessd[1] = true;
							}
							if (this.wait[i_321_] == -1 && (this.pgames[this.im] == -1) && (control).enter) {
								i_308_ = 0;
								this.pessd[0] = true;
							}
							if (this.pgames[this.im] == -1 && (control).exit) {
								i_308_ = 0;
								this.pessd[0] = true;
							}
							if (i_308_ == 0) {
								if (this.pgames[this.im] == -1) {
									this.ongame = -1;
									this.chalngd = -1;
								} else {
									this.join = -2;
									this.msg = "| Leaving Game |";
									this.longame = -1;
								}
							}
							if (this.pbtn == 0) {
								if (i_308_ == 1) {
									if (this.wait[i_321_] > 0) {
										if ((this.pgames[this.im]) == -1) {
											this.join = this.ongame;
											this.msg = "| Joining Game |";
											this.spos = 0;
										} else if ((this.gmaker[i_321_].equals(this.pnames[this.im])) && (this.npls[i_321_]) > 1)
										this.fstart = true;
										else i_308_ = 2;
									} else {
										if (this.wait[i_321_] == 0 && (this.prevloaded == 1)) {
											this.laps = (this.gnlaps[i_321_]);
											this.stage = this.gstgn[i_321_];
											this.stagename = (this.gstages[i_321_]);
											this.nfix = this.gfx[i_321_];
											if (this.gntb[i_321_] == 1)
											this.notb = true;
											else this.notb = false;
											this.gs.setCursor(new Cursor(3));
											this.conon = 3;
										} else i_308_ = 2;
										if (this.wait[i_321_] == 0 && (
										this.xt).lan) {
											this.laps = (this.gnlaps[i_321_]);
											this.stage = this.gstgn[i_321_];
											this.stagename = (this.gstages[i_321_]);
											this.nfix = this.gfx[i_321_];
											if (this.gntb[i_321_] == 1)
											this.notb = true;
											else this.notb = false;
											this.gs.setCursor(new Cursor(3));
											this.conon = 3;
										}
									}
								}
								if (i_308_ == 2 && !(this.xt).lan && !(this.gs)
									.cmsg.getText().equals("Type here...") && !(this.gs)
									.cmsg.getText().equals("")) {
									String string = (this.gs)
										.cmsg.getText().replace('|', ':');
									if ((string.toLowerCase().indexOf((this.gs)
										.tpass.getText().toLowerCase())) != -1) string = " ";
									if (!this.xt.msgcheck(string) && this.updatec > -12) {
										for (int i_323_ = 0; i_323_ < 6;
										i_323_++) {
											this.sentn[i_323_] = (this.sentn[i_323_ + 1]);
											this.cnames[i_323_] = (this.cnames[i_323_ + 1]);
										}
										this.sentn[6] = string;
										this.cnames[6] = (this.pnames[this.im]);
										if (this.updatec > -11)
										this.updatec = -11;
										else this.updatec--;
									} else(this.xt)
										.warning++;
									(this.gs).cmsg.setText("");
								}
							}
							if (this.pbtn == 1 && i_308_ == 1) {
								if (this.pgames[this.im] == -1) {
									this.join = this.ongame;
									this.msg = "| Joining Game |";
									this.spos = 0;
								} else if (!this.invo)
								this.invo = true;
								else this.invo = false;
							}
							if (this.pbtn == 2 && (i_308_ == 1 || i_308_ == 2)) {
								this.fase = 2;
								(this.m).ptr = 0;
								(this.m).ptcnt = -10;
								(this.m).hit = 20000;
								(this.m).fallen = 500;
								(this.m).nrnd = 0;
								(this.m).ih = 25;
								(this.m).iw = 65;
								(this.m).h = 425;
								(this.m).w = 735;
								(this.m).trk = 4;
								this.plsndt = 0;
								if ((this.gs).cmsg.isShowing()) {
									(this.gs).cmsg.hide();
									this.gs.requestFocus();
								}
							}
						} else {
							if (i_308_ == 0) {
								if (this.pgames[this.im] == -1) {
									this.ongame = -1;
									this.chalngd = -1;
								} else {
									this.join = -2;
									this.msg = "| Leaving Game |";
									this.longame = -1;
								}
							}
							if (this.pbtn == 1 && i_308_ == 1) {
								if (this.pgames[this.im] == -1) {
									this.join = this.ongame;
									this.msg = "| Joining Game |";
									this.spos = 0;
								} else if (!this.invo)
								this.invo = true;
								else this.invo = false;
							}
						}
					}
				} else if (this.ontyp != 76) {
					if (i_308_ == 0) {
						if (this.ontyp < 30) {
							(this.xt).onjoin = this.onjoin;
							(this.xt).ontyp = this.ontyp;
							(this.xt).playingame = -101;
							(this.xt).fase = 23;
						} else {
							if (!(this.gb).claname.equals((this.xt).clan)) {
								(this.gb).claname = (this.xt).clan;
								(this.gb).loadedc = false;
							}
							(this.gb).spos5 = 0;
							(this.gb).lspos5 = 0;
							(this.gb).cfase = 3;
							(this.gb).loadedcars = -1;
							(this.gb).loadedcar = 0;
							(this.gb).ctab = 2;
							(this.gb).tab = 3;
							(this.gb).open = 2;
							(this.gb).upo = true;
							this.onjoin = -1;
						}
					}
					if (i_308_ == 1)
					this.onjoin = -1;
				} else {
					if (i_308_ == 0) {
						this.gs.editlink(((
						this.xt)
							.nickname),
						true);
						this.onjoin = -1;
					}
					if (i_308_ == 1)
					this.onjoin = -1;
				}
			} else {
				if (i_308_ == 0)
				this.gs.editlink((
				this.xt).nickname,
				true);
				if (i_308_ == 1)
				this.regnow = false;
			}
		}
		this.lxm = i;
		this.lym = i_306_;
		(control).enter = false;
		(control).exit = false;
	}

	public void hideinputs() {
		(this.gs).cmsg.hide();
		(this.gs).swait.hide();
		(this.gs).snpls.hide();
		(this.gs).snbts.hide();
		(this.gs).sgame.hide();
		(this.gs).wgame.hide();
		(this.gs).pgame.hide();
		(this.gs).vnpls.hide();
		(this.gs).vtyp.hide();
		(this.gs).warb.hide();
		(this.gs).mstgs.hide();
		(this.gs).snfm1.hide();
		(this.gs).snfmm.hide();
		(this.gs).slaps.hide();
		(this.gs).snfm2.hide();
		(this.gs).sclass.hide();
		(this.gs).scars.hide();
		(this.gs).sfix.hide();
		(this.gs).mycar.hide();
		(this.gs).notp.hide();
		(this.gs).rooms.hide();
		this.gs.requestFocus();
	}

	public void drawSbutton(Image image, int i, int i_324_) {
		this.bx[this.btn] = i;
		this.by[this.btn] = i_324_;
		this.bw[this.btn] = image.getWidth(this.ob);
		if (!this.pessd[this.btn]) {
			this.rd.drawImage(image, i - this.bw[this.btn] / 2,
			i_324_ - image.getHeight(this.ob) / 2 - 1, null);
			this.rd.drawImage((this.xt).bols,
			i - (this.bw[this.btn]) / 2 - 15,
			i_324_ - 13, null);
			this.rd.drawImage((this.xt).bors,
			i + (this.bw[this.btn]) / 2 + 9,
			i_324_ - 13, null);
			this.rd.drawImage((this.xt).bot,
			i - this.bw[this.btn] / 2 - 9,
			i_324_ - 13, this.bw[this.btn] + 18, 3,
			null);
			this.rd.drawImage((this.xt).bob,
			i - this.bw[this.btn] / 2 - 9,
			i_324_ + 10, this.bw[this.btn] + 18, 3,
			null);
		} else {
			this.rd.drawImage(image, i - this.bw[this.btn] / 2 + 1,
			i_324_ - image.getHeight(this.ob) / 2, null);
			this.rd.drawImage((this.xt).bolps,
			i - (this.bw[this.btn]) / 2 - 15,
			i_324_ - 13, null);
			this.rd.drawImage((this.xt).borps,
			i + (this.bw[this.btn]) / 2 + 9,
			i_324_ - 13, null);
			this.rd.drawImage((this.xt).bob,
			i - this.bw[this.btn] / 2 - 9,
			i_324_ - 13, this.bw[this.btn] + 18, 3,
			null);
			this.rd.drawImage((this.xt).bot,
			i - this.bw[this.btn] / 2 - 9,
			i_324_ + 10, this.bw[this.btn] + 18, 3,
			null);
		}
		this.btn++;
	}

	public void stringbutton(String string, int i, int i_325_, int i_326_) {
		this.rd.setFont(new Font("Arial", 1, 12));
		this.ftm = this.rd.getFontMetrics();
		this.bx[this.btn] = i;
		this.by[this.btn] = i_325_ - 5;
		this.bw[this.btn] = this.ftm.stringWidth(string);
		if (!this.pessd[this.btn]) {
			this.rd.setColor(color2k(220, 220, 220));
			this.rd.fillRect(i - this.bw[this.btn] / 2 - 10,
			i_325_ - (17 - i_326_), this.bw[this.btn] + 20, 25 - i_326_ * 2);
			this.rd.setColor(color2k(240, 240, 240));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ - (17 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ - (17 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ - (18 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ - (18 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 9,
			i_325_ - (19 - i_326_),
			i + this.bw[this.btn] / 2 + 9,
			i_325_ - (19 - i_326_));
			this.rd.setColor(color2k(200, 200, 200));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 10,
			i_325_ - (17 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 11,
			i_325_ - (17 - i_326_),
			i + this.bw[this.btn] / 2 + 11,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 12,
			i_325_ - (16 - i_326_),
			i + this.bw[this.btn] / 2 + 12,
			i_325_ + (6 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ + (7 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ + (8 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ + (8 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 9,
			i_325_ + (9 - i_326_),
			i + this.bw[this.btn] / 2 + 9,
			i_325_ + (9 - i_326_));
			this.rd.setColor(color2k(240, 240, 240));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ - (17 - i_326_),
			i - this.bw[this.btn] / 2 - 10,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 11,
			i_325_ - (17 - i_326_),
			i - this.bw[this.btn] / 2 - 11,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 12,
			i_325_ - (16 - i_326_),
			i - this.bw[this.btn] / 2 - 12,
			i_325_ + (6 - i_326_));
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString(string,
			i - (this.bw[this.btn]) / 2,
			i_325_);
		} else {
			this.rd.setColor(color2k(210, 210, 210));
			this.rd.fillRect(i - this.bw[this.btn] / 2 - 10,
			i_325_ - (17 - i_326_), this.bw[this.btn] + 20, 25 - i_326_ * 2);
			this.rd.setColor(color2k(200, 200, 200));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ - (17 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ - (17 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ - (18 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ - (18 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 9,
			i_325_ - (19 - i_326_),
			i + this.bw[this.btn] / 2 + 9,
			i_325_ - (19 - i_326_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 10,
			i_325_ - (17 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 11,
			i_325_ - (17 - i_326_),
			i + this.bw[this.btn] / 2 + 11,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 12,
			i_325_ - (16 - i_326_),
			i + this.bw[this.btn] / 2 + 12,
			i_325_ + (6 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ + (7 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ + (8 - i_326_),
			i + this.bw[this.btn] / 2 + 10,
			i_325_ + (8 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 9,
			i_325_ + (9 - i_326_),
			i + this.bw[this.btn] / 2 + 9,
			i_325_ + (9 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_325_ - (17 - i_326_),
			i - this.bw[this.btn] / 2 - 10,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 11,
			i_325_ - (17 - i_326_),
			i - this.bw[this.btn] / 2 - 11,
			i_325_ + (7 - i_326_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 12,
			i_325_ - (16 - i_326_),
			i - this.bw[this.btn] / 2 - 12,
			i_325_ + (6 - i_326_));
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString(string,
			i - (this.bw[this.btn]) / 2 + 1,
			i_325_);
		}
		this.btn++;
	}

	public Color color2k(int i, int i_327_, int i_328_) {
		Color color = new Color(i, i_327_, i_328_);
		float[] fs = new float[3];
		Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
		fs[0] = 0.13F;
		fs[1] = 0.35F;
		return Color.getHSBColor(fs[0], fs[1], fs[2]);
	}

	public int getvalue(String string, int i) {
		int i_329_ = -1;
		try {
			int i_330_ = 0;
			int i_331_ = 0;
			int i_332_ = 0;
			String string_333_ = "";
			String string_334_ = "";
			for (/**/ ; i_330_ < string.length() && i_332_ != 2; i_330_++) {
				string_333_ = new StringBuilder().append("").append(string.charAt(i_330_)).toString();
				if (string_333_.equals("|")) {
					i_331_++;
					if (i_332_ == 1 || i_331_ > i) i_332_ = 2;
				} else if (i_331_ == i) {
					string_334_ = new StringBuilder().append(string_334_).append(string_333_).toString();
					i_332_ = 1;
				}
			}
			if (string_334_.equals("")) string_334_ = "-1";
			i_329_ = Integer.valueOf(string_334_).intValue();
		} catch (Exception exception) {
			/* empty */
		}
		return i_329_;
	}

	public String getSvalue(String string, int i) {
		String string_335_ = "";
		try {
			int i_336_ = 0;
			int i_337_ = 0;
			int i_338_ = 0;
			String string_339_ = "";
			String string_340_ = "";
			for (/**/ ; i_336_ < string.length() && i_338_ != 2; i_336_++) {
				string_339_ = new StringBuilder().append("").append(string.charAt(i_336_)).toString();
				if (string_339_.equals("|")) {
					i_337_++;
					if (i_338_ == 1 || i_337_ > i) i_338_ = 2;
				} else if (i_337_ == i) {
					string_340_ = new StringBuilder().append(string_340_).append(string_339_).toString();
					i_338_ = 1;
				}
			}
			string_335_ = string_340_;
		} catch (Exception exception) {
			/* empty */
		}
		return string_335_;
	}

	public int getHvalue(String string, int i) {
		int i_341_ = -1;
		try {
			int i_342_ = 0;
			int i_343_ = 0;
			int i_344_ = 0;
			String string_345_ = "";
			String string_346_ = "";
			for (/**/ ; i_342_ < string.length() && i_344_ != 2; i_342_++) {
				string_345_ = new StringBuilder().append("").append(string.charAt(i_342_)).toString();
				if (string_345_.equals("#")) {
					i_343_++;
					if (i_344_ == 1 || i_343_ > i) i_344_ = 2;
				} else if (i_343_ == i) {
					string_346_ = new StringBuilder().append(string_346_).append(string_345_).toString();
					i_344_ = 1;
				}
			}
			if (string_346_.equals("")) string_346_ = "-1";
			i_341_ = Integer.valueOf(string_346_).intValue();
		} catch (Exception exception) {
			/* empty */
		}
		return i_341_;
	}

	public String getHSvalue(String string, int i) {
		String string_347_ = "";
		try {
			int i_348_ = 0;
			int i_349_ = 0;
			int i_350_ = 0;
			String string_351_ = "";
			String string_352_ = "";
			for (/**/ ; i_348_ < string.length() && i_350_ != 2; i_348_++) {
				string_351_ = new StringBuilder().append("").append(string.charAt(i_348_)).toString();
				if (string_351_.equals("#")) {
					i_349_++;
					if (i_350_ == 1 || i_349_ > i) i_350_ = 2;
				} else if (i_349_ == i) {
					string_352_ = new StringBuilder().append(string_352_).append(string_351_).toString();
					i_350_ = 1;
				}
			}
			string_347_ = string_352_;
		} catch (Exception exception) {
			/* empty */
		}
		return string_347_;
	}

	public String getSevervalue(String string, int i) {
		String string_353_ = "";
		if (!string.equals("")) {
			try {
				boolean bool = false;
				int i_354_ = 0;
				int i_355_ = 0;
				int i_356_ = 0;
				String string_357_ = "";
				String string_358_ = "";
				for (/**/ ; i_354_ < string.length() && i_356_ != 2; i_354_++) {
					string_357_ = new StringBuilder().append("").append(string.charAt(i_354_)).toString();
					if (string_357_.equals("|")) {
						i_355_++;
						if (i_356_ == 1 || i_355_ > i) i_356_ = 2;
					} else if (i_355_ == i) {
						string_358_ = new StringBuilder().append(string_358_).append(string_357_).toString();
						i_356_ = 1;
					}
				}
				string_353_ = string_358_;
			} catch (Exception exception) {
				string_353_ = "";
			}
		}
		return string_353_;
	}
}