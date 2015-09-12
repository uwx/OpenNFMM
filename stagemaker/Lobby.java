package stagemaker;

/* Lobby - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
public class Lobby implements Runnable
{
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
    boolean lanlogged = false;
    int fase = 0;
    int stage = 0;
    int laps = 3;
    String stagename = "";
    int nfix = 0;
    boolean notb = false;
    boolean[] pessd = { false, false, false, false, false, false, false, false };
    int[] bx = { 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] by = { 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] bw = { 0, 0, 0, 0, 0, 0, 0, 0 };
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
    int[] pgames = new int[200];
    float[][] pcols = new float[200][6];
    int prnpo = 0;
    String[] prnames = { "", "", "", "", "", "", "" };
    int[] ppos = { 6, 6, 6, 6, 6, 6, 6 };
    int[] plap = { 6, 6, 6, 6, 6, 6, 6 };
    int[] ppow = { 50, 50, 50, 50, 50, 50, 50 };
    int[] pdam = { 50, 50, 50, 50, 50, 50, 50 };
    int prevloaded = -1;
    int ngm = 0;
    int[] gnum = new int[500]; //whoah theres a limit of 500 games
    int[] gstgn = new int[500]; //whoah theres a limit of 500 games
    String[] gstages = new String[500]; //whoah theres a limit of 500 games
    int[] gnlaps = new int[500]; //whoah theres a limit of 500 games
    int[] mnpls = new int[500]; //whoah theres a limit of 500 games
    int[] mnbts = new int[500]; //whoah theres a limit of 500 games
    int[] wait = new int[500]; //whoah theres a limit of 500 games
    int[] gcrs = new int[500]; //whoah theres a limit of 500 games
    int[] gclss = new int[500]; //whoah theres a limit of 500 games
    int[] gfx = new int[500]; //whoah theres a limit of 500 games
    int[] gntb = new int[500]; //whoah theres a limit of 500 games
    String[] gplyrs = new String[500]; //whoah theres a limit of 500 games
    String[] gmaker = new String[500]; //whoah theres a limit of 500 games
    int[] npls = new int[500]; //whoah theres a limit of 500 games
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
    String[] invos = { "", "", "", "", "", "", "" };
    String[] dinvi = { "", "", "", "", "", "", "" };
    String[] cnames = { "", "", "", "", "", "", "" };
    String[] sentn = { "", "", "", "", "", "", "" };
    int updatec = -1;
    int loadstage = 0;
    int gstage = 0;
    int gstagelaps = 0;
    int gnpls = 7;
    int gwait = 0;
    int gnbts = 0;
    int gcars;
    int gclass = 0;
    int gfix = 0;
    int gnotp = 1;
    int remstage = 0;
    boolean msload = false;
    boolean sgflag = false;
    String gstagename = "";
    String gplayers = "";
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
    int pend = 0;
    int mrot = 0;
    boolean pendb = false;
    int[] cac = { -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    int[] cax = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] cay = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    boolean mousedout = false;
    int flks = 0;
    int waitlink = 0;
    boolean pre1 = false;
    boolean pre2 = false;
    int prereq = 0;
    int lxm = 0;
    int lym = 0;
    
    public Lobby(Medium medium, Graphics2D graphics2d, Login login, Globe globe, xtGraphics var_xtGraphics, CarDefine cardefine, GameSparker gamesparker) {
        this.m = medium;
        this.rd = graphics2d;
        this.xt = var_xtGraphics;
        this.cd = cardefine;
        this.gs = gamesparker;
        this.lg = login;
        this.gb = globe;
        (this.gs).cmsg.setBackground(color2k(255, 255, 255));
        (this.gs).swait.setBackground(color2k(220, 220, 220));
        (this.gs).snpls.setBackground(color2k(220, 220, 220));
        (this.gs).snbts.setBackground(color2k(220, 220, 220));
        (this.gs).sgame.setBackground(color2k(200, 200, 200));
        (this.gs).snfmm.setBackground(color2k(200, 200, 200));
        (this.gs).snfm1.setBackground(color2k(200, 200, 200));
        (this.gs).snfm2.setBackground(color2k(200, 200, 200));
        (this.gs).mstgs.setBackground(new Color(192, 223, 208));
        (this.gs).slaps.setBackground(color2k(200, 200, 200));
        (this.gs).sclass.setBackground(color2k(220, 220, 220));
        (this.gs).scars.setBackground(color2k(220, 220, 220));
        (this.gs).sfix.setBackground(color2k(220, 220, 220));
        (this.gs).mycar.setBackground(color2k(255, 255, 255));
        (this.gs).notp.setBackground(color2k(255, 255, 255));
        (this.gs).rooms.setBackground(color2k(170, 170, 170));
        (this.gs).swait.setForeground(new Color(0, 0, 0));
        (this.gs).snpls.setForeground(new Color(0, 0, 0));
        (this.gs).snbts.setForeground(new Color(0, 0, 0));
        (this.gs).sgame.setForeground(new Color(0, 0, 0));
        (this.gs).snfmm.setForeground(new Color(0, 0, 0));
        (this.gs).snfm1.setForeground(new Color(0, 0, 0));
        (this.gs).slaps.setForeground(new Color(0, 0, 0));
        (this.gs).snfm2.setForeground(new Color(0, 0, 0));
        (this.gs).mstgs.setForeground(new Color(0, 0, 0));
        (this.gs).sclass.setForeground(new Color(0, 0, 0));
        (this.gs).scars.setForeground(new Color(0, 0, 0));
        (this.gs).sfix.setForeground(new Color(0, 0, 0));
        (this.gs).mycar.setForeground(new Color(0, 0, 0));
        (this.gs).notp.setForeground(new Color(0, 0, 0));
        (this.gs).rooms.setForeground(new Color(0, 0, 0));
        (this.gs).sgame.removeAll();
        (this.gs).sgame.add(this.rd, " NFM Multiplayer ");
        (this.gs).sgame.add(this.rd, " NFM 2     ");
        (this.gs).sgame.add(this.rd, " NFM 1     ");
        (this.gs).sgame.add(this.rd, " My Stages ");
    }
    
    public void inishlobby() {
        (this.gs).tnick.hide();
        (this.gs).tpass.hide();
        (this.gs).temail.hide();
        hideinputs();
        (this.gs).mycar.setBackground(color2k(255, 255, 255));
        (this.gs).mycar.setForeground(new Color(0, 0, 0));
        (this.gs).rooms.removeAll();
        (this.gs).rooms.add(this.rd, new StringBuilder().append("").append((this.xt).servername).append(" :: ").append((this.xt).servport - 7070).append("").toString());
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
        }
        for (int i = 0; i < 200; i++) {
            this.pnames[i] = "";
            this.pcars[i] = 0;
            this.pcarnames[i] = "";
            this.pgames[i] = -1;
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
        try {
            this.socket = new Socket((this.xt).server, (this.xt).servport);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
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
            if (!this.lloaded)
                this.gs.setCursor(new Cursor(3));
            if (!(this.xt).logged && !(this.xt).lan && (this.xt).nfreeplays - (this.xt).ndisco >= 5) {
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
                    if (this.join == this.gnum[i_2_] || this.pgames[this.im] == this.gnum[i_2_])
                        i_1_ = i_2_;
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
                    if (this.gclss[i_1_] > 0 && this.gclss[i_1_] <= 5 && Math.abs((this.cd).cclass[this.pcars[this.im]] - (this.gclss[i_1_] - 1)) > 1) {
                        bool = true;
                        if (this.gcrs[i_1_] == 1)
                            this.ontyp = 10;
                        if (this.gcrs[i_1_] == 2)
                            this.ontyp = 20;
                        this.ontyp += this.gclss[i_1_];
                    }
                    if (this.gclss[i_1_] <= -2 && this.pcars[this.im] != Math.abs(this.gclss[i_1_] + 2)) {
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
                            else
                                this.notb = false;
                        }
                    }
                }
            }
            String string = new StringBuilder().append("").append((this.xt).sc[0]).append("").toString();
            if ((this.xt).sc[0] >= 16)
                string = new StringBuilder().append("C").append((this.cd).names[(this.xt).sc[0]]).append("").toString();
            String string_4_ = new StringBuilder().append("1|").append((this.xt).nickname).append(":").append((this.xt).nickey).append("|").append(string).append("|").append(this.join).append("|").append((int) ((this.xt).arnp[0] * 100.0F)).append("|").append((int) ((this.xt).arnp[1] * 100.0F)).append("|").append((int) ((this.xt).arnp[2] * 100.0F)).append("|").append((int) ((this.xt).arnp[3] * 100.0F)).append("|").append((int) ((this.xt).arnp[4] * 100.0F)).append("|").append((int) ((this.xt).arnp[5] * 100.0F)).append("|").append(this.ongame).append("|").toString();
            if (!(this.xt).lan) {
                string_4_ = new StringBuilder().append(string_4_).append("").append(this.updatec).append("|").toString();
                if (this.updatec <= -11) {
                    for (int i_5_ = 0; i_5_ < -this.updatec - 10; i_5_++)
                        string_4_ = new StringBuilder().append(string_4_).append("").append(this.cnames[6 - i_5_]).append("|").append(this.sentn[6 - i_5_]).append("|").toString();
                    this.updatec = -2;
                }
            } else {
                String string_6_ = "Nonex";
                try {
                    string_6_ = InetAddress.getLocalHost().getHostName();
                    if (string_6_.indexOf("|") != -1)
                        string_6_ = InetAddress.getLocalHost().getHostAddress();
                } catch (Exception exception) {
                    string_6_ = "Nonex";
                }
                int i_7_ = 0;
                if ((this.xt).logged)
                    i_7_ = 1;
                string_4_ = new StringBuilder().append(string_4_).append("").append(string_6_).append("|").append(i_7_).append("|").toString();
            }
            if (this.fstart) {
                string_4_ = new StringBuilder().append(string_4_).append("3|").toString();
                bool = true;
            }
            if (this.chalngd == -5 && !this.fstart) {
                string_4_ = new StringBuilder().append(string_4_).append("11|").append(this.gstage).append("|").append(this.gstagename).append("|").append(this.gstagelaps).append("|").append(this.gnpls).append("|").append(this.gwait).append("|").append(this.pnames[this.im]).append("|").append(this.gcars).append("|").append(this.gclass).append("|").append(this.gfix).append("|").append(this.gnotp).append("|").append(this.gplayers).append("|").toString();
                if ((this.xt).lan)
                    string_4_ = new StringBuilder().append(string_4_).append("").append(this.gnbts).append("|").toString();
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
                if (string_10_ == null)
                    bool_11_ = true;
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
                    this.socket = new Socket((this.xt).server, (this.xt).servport);
                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                    this.dout.println(string_4_);
                    string_10_ = this.din.readLine();
                    if (string_10_ != null)
                        bool_11_ = false;
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
                this.pnames[i_12_] = getSvalue(string_10_, 2 + i_12_ * 9);
                if (this.pnames[i_12_].equals(""))
                    this.pnames[i_12_] = "Unknown";
                String string_13_ = getSvalue(string_10_, 3 + i_12_ * 9);
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
                            for (int i_17_ = 0; i_17_ < (this.cd).nl; i_17_++) {
                                if (this.pcarnames[i_12_].equals((this.cd).loadnames[i_17_]))
                                    bool_16_ = true;
                            }
                            if (!bool_16_ && (this.cd).nl < 20 && (this.cd).nl >= 0) {
                                (this.cd).loadnames[(this.cd).nl] = this.pcarnames[i_12_];
                                (this.cd).nl++;
                            }
                            this.cd.sparkcarloader();
                        } else
                            this.pcars[i_12_] = i_14_;
                    } else {
                        this.pcars[i_12_] = 0;
                        this.pcarnames[i_12_] = (this.cd).names[this.pcars[i_12_]];
                    }
                } else {
                    this.pcars[i_12_] = getvalue(string_10_, 3 + i_12_ * 9);
                    if (this.pcars[i_12_] <= -1)
                        this.pcars[i_12_] = 0;
                    this.pcarnames[i_12_] = (this.cd).names[this.pcars[i_12_]];
                }
                this.pgames[i_12_] = getvalue(string_10_, 4 + i_12_ * 9);
                this.pcols[i_12_][0] = (float) getvalue(string_10_, 5 + i_12_ * 9) / 100.0F;
                if (this.pcols[i_12_][0] <= -1.0F)
                    this.pcols[i_12_][0] = 0.0F;
                this.pcols[i_12_][1] = (float) getvalue(string_10_, 6 + i_12_ * 9) / 100.0F;
                if (this.pcols[i_12_][1] <= -1.0F)
                    this.pcols[i_12_][1] = 0.0F;
                this.pcols[i_12_][2] = (float) getvalue(string_10_, 7 + i_12_ * 9) / 100.0F;
                if (this.pcols[i_12_][2] <= -1.0F)
                    this.pcols[i_12_][2] = 0.0F;
                this.pcols[i_12_][3] = (float) getvalue(string_10_, 8 + i_12_ * 9) / 100.0F;
                if (this.pcols[i_12_][3] <= -1.0F)
                    this.pcols[i_12_][3] = 0.0F;
                this.pcols[i_12_][4] = (float) getvalue(string_10_, 9 + i_12_ * 9) / 100.0F;
                if (this.pcols[i_12_][4] <= -1.0F)
                    this.pcols[i_12_][4] = 0.0F;
                this.pcols[i_12_][5] = (float) getvalue(string_10_, 10 + i_12_ * 9) / 100.0F;
                if (this.pcols[i_12_][5] <= -1.0F)
                    this.pcols[i_12_][5] = 0.0F;
            }
            int i_18_ = 11 + (this.npo - 1) * 9;
            this.ngm = getvalue(string_10_, i_18_);
            if (this.ngm < 0)
                this.ngm = 0;
            int i_19_ = 12;
            if ((this.xt).lan)
                i_19_ = 13;
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
                if ((this.xt).lan)
                    this.mnbts[i_20_] = getvalue(string_10_, i_18_ + 13 + i_20_ * i_19_);
                if ((this.xt).playingame > -1 && (this.xt).playingame == this.gnum[i_20_] && !(this.xt).lan)
                    this.ongame = this.gnum[i_20_];
                if (i == this.gnum[i_20_] && this.wait[i_20_] == 0 && this.lloaded && i != -1) {
                    for (int i_21_ = 0; i_21_ < this.npo; i_21_++) {
                        if (this.pgames[i_21_] == this.gnum[i_20_] && this.pnames[i_21_].equals((this.xt).nickname)) {
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
                    if (this.ongame == this.gnum[i_25_])
                        bool_24_ = true;
                }
                if (!bool_24_)
                    this.britchl = -1;
            }
            if (this.join > -1) {
                boolean bool_26_ = false;
                for (int i_27_ = 0; i_27_ < this.ngm; i_27_++) {
                    if (this.join == this.gnum[i_27_])
                        bool_26_ = true;
                }
                if (!bool_26_)
                    this.join = -1;
            }
            for (int i_28_ = 0; i_28_ < this.npo; i_28_++) {
                if (this.pgames[i_28_] != -1) {
                    boolean bool_29_ = false;
                    for (int i_30_ = 0; i_30_ < this.ngm; i_30_++) {
                        if (this.pgames[i_28_] == this.gnum[i_30_])
                            bool_29_ = true;
                    }
                    if (!bool_29_)
                        this.pgames[i_28_] = -1;
                }
            }
            if ((this.xt).lan)
                i_18_ += 14 + (this.ngm - 1) * 13;
            else
                i_18_ += 13 + (this.ngm - 1) * 12;
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
                    if (this.ongame <= -1)
                        this.spos3 = 28;
                    i_18_ += 14;
                }
                if (this.ongame != -1) {
                    if (this.prevloaded != -1)
                        this.prevloaded = -1;
                    boolean bool_34_ = false;
                    for (int i_35_ = 0; i_35_ < this.ngm; i_35_++) {
                        if (this.ongame == this.gnum[i_35_] && this.wait[i_35_] <= 0)
                            bool_34_ = true;
                    }
                    if (bool_34_) {
                        this.prevloaded = getvalue(string_10_, i_18_);
                        i_18_++;
                        if (this.prevloaded == 1) {
                            this.prnpo = getvalue(string_10_, i_18_);
                            i_18_++;
                            for (int i_36_ = 0; i_36_ < this.prnpo; i_36_++) {
                                this.prnames[i_36_] = getSvalue(string_10_, i_18_);
                                i_18_++;
                            }
                            for (int i_37_ = 0; i_37_ < this.prnpo; i_37_++) {
                                this.ppos[i_37_] = getvalue(string_10_, i_18_);
                                i_18_++;
                            }
                            for (int i_38_ = 0; i_38_ < this.prnpo; i_38_++) {
                                this.plap[i_38_] = getvalue(string_10_, i_18_);
                                i_18_++;
                            }
                            for (int i_39_ = 0; i_39_ < this.prnpo; i_39_++) {
                                this.ppow[i_39_] = (int) ((float) getvalue(string_10_, i_18_) / 9800.0F * 55.0F);
                                i_18_++;
                            }
                            for (int i_40_ = 0; i_40_ < this.prnpo; i_40_++) {
                                int i_41_ = getvalue(string_10_, i_18_);
                                if (i_41_ != -17)
                                    this.pdam[i_40_] = (int) ((float) i_41_ / 100.0F * 55.0F);
                                else
                                    this.pdam[i_40_] = -17;
                                i_18_++;
                            }
                        }
                    }
                }
            } else {
                int i_42_ = getvalue(string_10_, i_18_);
                if (i_42_ == 1)
                    this.lanlogged = true;
                //else
                //    this.lanlogged = false;
                i_18_++;
            }
            int i_43_ = getvalue(string_10_, i_18_);
            if (i_43_ != -1) {
                int i_44_ = 0;
                for (int i_45_ = 0; i_45_ < this.ngm; i_45_++) {
                    if (i_43_ == this.gnum[i_45_])
                        i_44_ = i_45_;
                }
                if ((this.pgames[this.im] != this.ongame || this.ongame <= -1) && i_43_ != this.ongame && this.chalngd <= -1 && this.join <= -1 && this.fase == 1 && this.wait[i_44_] > 0) {
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
                int i_46_ = 1;
                for (int i_47_ = 1; i_47_ < 6; i_47_++) {
                    if (i_47_ != (this.xt).servport - 7070) {
                        int i_48_ = getvalue(string_10_, i_18_ + i_47_);
                        if (i_48_ != -1) {
                            if (i_48_ > 10)
                                i_48_ = 10;
                            ((this.gs).rooms).sopts[i_46_] = new StringBuilder().append("Room ").append(i_47_).append(" :   ").append(i_48_).append(" / 10").toString();
                            if (i_48_ == 10)
                                ((this.gs).rooms).opts[i_46_] = "full";
                            else
                                ((this.gs).rooms).opts[i_46_] = "";
                            ((this.gs).rooms).iroom[i_46_] = i_47_;
                            i_46_++;
                        }
                    }
                }
                ((this.gs).rooms).no = i_46_;
            }
            if (this.join > -1) {
                boolean bool_49_ = false;
                for (int i_50_ = 0; i_50_ < this.ngm; i_50_++) {
                    if (this.join == this.gnum[i_50_] && this.wait[i_50_] == 0)
                        bool_49_ = true;
                }
                if (this.pgames[this.im] == this.join || bool_49_) {
                    this.join = -1;
                    this.nflk = 3;
                }
            }
            if (this.join == -2) {
                boolean bool_51_ = false;
                for (int i_52_ = 0; i_52_ < this.ngm; i_52_++) {
                    if (this.pgames[this.im] == this.gnum[i_52_] && this.wait[i_52_] == 0)
                        bool_51_ = true;
                }
                if (this.pgames[this.im] <= -1 || bool_51_) {
                    this.join = -1;
                    if (!bool_51_)
                        this.ongame = -1;
                }
            }
            if (this.chalngd == -5 && this.pgames[this.im] != -1) {
                this.ongame = this.pgames[this.im];
                this.chalngd = -1;
            }
            if (this.fstart && bool)
                this.fstart = false;
            this.rerr = 0;
            if (!this.lloaded) {
                this.gs.setCursor(new Cursor(0));
                this.lloaded = true;
            }
            this.gb.roomlogos(this.pnames, this.npo);
            try {
                if (this.connector != null) {
                    /* empty */
                }
                Thread.sleep(600L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        if (this.conon == 2) {
            int i_53_ = 20;
            (this.xt).playingame = -1;
            while (i_53_ != 0) {
                String string = new StringBuilder().append("2|").append(i).append("|").toString();
                String string_54_ = "";
                boolean bool = false;
                try {
                    this.dout.println(string);
                    string_54_ = this.din.readLine();
                    if (string_54_ == null)
                        bool = true;
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
                        this.socket = new Socket((this.xt).server, (this.xt).servport);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                        this.dout.println(string);
                        string_54_ = this.din.readLine();
                        if (string_54_ != null)
                            bool = false;
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
                    (this.xt).gameport = getvalue(string_54_, 0);
                else {
                    (this.xt).gameport = -1;
                    (this.xt).localserver = getSevervalue(string_54_, 0);
                    if (!(this.xt).localserver.equals(""))
                        (this.xt).gameport = 0;
                }
                if ((this.xt).gameport != -1) {
                    int i_55_ = 0;
                    (this.xt).im = -1;
                    (this.xt).nplayers = getvalue(string_54_, 1);
                    if ((this.xt).nplayers < 1)
                        (this.xt).nplayers = 1;
                    if ((this.xt).nplayers > 7)
                        (this.xt).nplayers = 7;
                    for (int i_56_ = 0; i_56_ < (this.xt).nplayers; i_56_++) {
                        (this.xt).plnames[i_56_] = getSvalue(string_54_, 2 + i_56_);
                        if ((this.xt).nickname.equals((this.xt).plnames[i_56_]))
                            (this.xt).im = i_56_;
                    }
                    int i_57_ = 2 + (this.xt).nplayers;
                    for (int i_58_ = 0; i_58_ < (this.xt).nplayers; i_58_++) {
                        String string_59_ = getSvalue(string_54_, i_57_ + i_58_);
                        if (string_59_.startsWith("C")) {
                            string_59_ = string_59_.substring(1);
                            if (!string_59_.equals("")) {
                                int i_60_ = 0;
                                for (int i_61_ = 16; i_61_ < 56; i_61_++) {
                                    if (string_59_.equals((this.cd).names[i_61_])) {
                                        i_60_ = i_61_;
                                        break;
                                    }
                                }
                                for (/**/; i_60_ == 0 && i_55_ < 100; i_55_++) {
                                    boolean bool_62_ = false;
                                    for (int i_63_ = 0; i_63_ < (this.cd).nl; i_63_++) {
                                        if (string_59_.equals((this.cd).loadnames[i_63_]))
                                            bool_62_ = true;
                                    }
                                    if (!bool_62_ && (this.cd).nl < 20) {
                                        (this.cd).loadnames[(this.cd).nl] = string_59_;
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
                                    for (int i_64_ = 16; i_64_ < 56; i_64_++) {
                                        if (string_59_.equals((this.cd).names[i_64_]))
                                            i_60_ = i_64_;
                                    }
                                }
                                if (i_60_ != 0) {
                                    (this.xt).sc[i_58_] = i_60_;
                                    for (int i_65_ = 0; i_65_ < this.npo; i_65_++) {
                                        if (this.pcarnames[i_65_].equals(string_59_))
                                            this.pcars[i_65_] = i_60_;
                                    }
                                } else
                                    (this.xt).im = -1;
                            } else
                                (this.xt).im = -1;
                        } else {
                            (this.xt).sc[i_58_] = getvalue(string_54_, i_57_ + i_58_);
                            if ((this.xt).sc[i_58_] <= -1)
                                (this.xt).im = -1;
                        }
                    }
                    i_57_ += (this.xt).nplayers;
                    for (int i_66_ = 0; i_66_ < (this.xt).nplayers; i_66_++)
                        (this.xt).xstart[i_66_] = getvalue(string_54_, i_57_ + i_66_);
                    i_57_ += (this.xt).nplayers;
                    for (int i_67_ = 0; i_67_ < (this.xt).nplayers; i_67_++)
                        (this.xt).zstart[i_67_] = getvalue(string_54_, i_57_ + i_67_);
                    i_57_ += (this.xt).nplayers;
                    for (int i_68_ = 0; i_68_ < (this.xt).nplayers; i_68_++) {
                        for (int i_69_ = 0; i_69_ < 6; i_69_++)
                            (this.xt).allrnp[i_68_][i_69_] = (float) getvalue(string_54_, i_57_ + i_68_ * 6 + i_69_) / 100.0F;
                    }
                    if ((this.xt).im <= -1) {
                        (this.xt).playingame = -1;
                        (this.xt).im = 0;
                    } else
                        (this.xt).playingame = i;
                    i_53_ = 0;
                } else
                    i_53_--;
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
                    try {
                        this.socket = new Socket((this.lg).servers[0], 7061);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                        this.dout.println(new StringBuilder().append("7|").append((this.xt).nfreeplays).append("|").toString());
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
            } else
                inishlobby();
        }
        if (this.conon == 3) {
            int i_70_ = 20;
            (this.xt).playingame = -1;
            while (i_70_ != 0) {
                String string = new StringBuilder().append("4|").append(this.ongame).append("|").toString();
                String string_71_ = "";
                boolean bool = false;
                try {
                    this.dout.println(string);
                    string_71_ = this.din.readLine();
                    if (string_71_ == null)
                        bool = true;
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
                        this.socket = new Socket((this.xt).server, (this.xt).servport);
                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                        this.dout.println(string);
                        string_71_ = this.din.readLine();
                        if (string_71_ != null)
                            bool = false;
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
                    (this.xt).gameport = getvalue(string_71_, 0);
                else {
                    (this.xt).gameport = -1;
                    (this.xt).localserver = getSevervalue(string_71_, 0);
                    if (!(this.xt).localserver.equals(""))
                        (this.xt).gameport = 0;
                }
                if ((this.xt).gameport != -1) {
                    int i_72_ = 0;
                    (this.xt).nplayers = getvalue(string_71_, 1);
                    if ((this.xt).nplayers < 1)
                        (this.xt).nplayers = 1;
                    if ((this.xt).nplayers > 7)
                        (this.xt).nplayers = 7;
                    (this.xt).im = getvalue(string_71_, 2) + (this.xt).nplayers;
                    for (int i_73_ = 0; i_73_ < (this.xt).nplayers; i_73_++)
                        (this.xt).plnames[i_73_] = getSvalue(string_71_, 3 + i_73_);
                    int i_74_ = 3 + (this.xt).nplayers;
                    for (int i_75_ = 0; i_75_ < (this.xt).nplayers; i_75_++) {
                        String string_76_ = getSvalue(string_71_, i_74_ + i_75_);
                        if (string_76_.startsWith("C")) {
                            string_76_ = string_76_.substring(1);
                            if (!string_76_.equals("")) {
                                int i_77_ = 0;
                                for (int i_78_ = 16; i_78_ < 56; i_78_++) {
                                    if (string_76_.equals((this.cd).names[i_78_])) {
                                        i_77_ = i_78_;
                                        break;
                                    }
                                }
                                for (/**/; i_77_ == 0 && i_72_ < 100; i_72_++) {
                                    boolean bool_79_ = false;
                                    for (int i_80_ = 0; i_80_ < (this.cd).nl; i_80_++) {
                                        if (string_76_.equals((this.cd).loadnames[i_80_]))
                                            bool_79_ = true;
                                    }
                                    if (!bool_79_ && (this.cd).nl < 20) {
                                        (this.cd).loadnames[(this.cd).nl] = string_76_;
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
                                    for (int i_81_ = 16; i_81_ < 56; i_81_++) {
                                        if (string_76_.equals((this.cd).names[i_81_]))
                                            i_77_ = i_81_;
                                    }
                                }
                                if (i_77_ != 0) {
                                    (this.xt).sc[i_75_] = i_77_;
                                    for (int i_82_ = 0; i_82_ < this.npo; i_82_++) {
                                        if (this.pcarnames[i_82_].equals(string_76_))
                                            this.pcars[i_82_] = i_77_;
                                    }
                                } else
                                    (this.xt).im = -1;
                            } else
                                (this.xt).im = -1;
                        } else {
                            (this.xt).sc[i_75_] = getvalue(string_71_, i_74_ + i_75_);
                            if ((this.xt).sc[i_75_] <= -1)
                                (this.xt).im = -1;
                        }
                    }
                    i_74_ += (this.xt).nplayers;
                    for (int i_83_ = 0; i_83_ < (this.xt).nplayers; i_83_++)
                        (this.xt).xstart[i_83_] = getvalue(string_71_, i_74_ + i_83_);
                    i_74_ += (this.xt).nplayers;
                    for (int i_84_ = 0; i_84_ < (this.xt).nplayers; i_84_++)
                        (this.xt).zstart[i_84_] = getvalue(string_71_, i_74_ + i_84_);
                    i_74_ += (this.xt).nplayers;
                    for (int i_85_ = 0; i_85_ < (this.xt).nplayers; i_85_++) {
                        for (int i_86_ = 0; i_86_ < 6; i_86_++)
                            (this.xt).allrnp[i_85_][i_86_] = (float) getvalue(string_71_, i_74_ + i_85_ * 6 + i_86_) / 100.0F;
                    }
                    if ((this.xt).im >= (this.xt).nplayers && (this.xt).im < (this.xt).nplayers + 3)
                        (this.xt).playingame = this.ongame;
                    else {
                        (this.xt).playingame = -1;
                        (this.xt).im = 0;
                    }
                    i_70_ = 0;
                } else
                    i_70_--;
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
            } else
                inishlobby();
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
    
    public void lobby(int i, int i_87_, boolean bool, int i_88_, CheckPoints checkpoints, Control control, ContO[] contos) {
        this.pre1 = false;
        this.pre2 = false;
        int i_89_ = 0;
        if ((this.xt).warning == 0 || (this.xt).warning == 210) {
            if (!this.regnow) {
                if (this.onjoin <= -1) {
                    this.xt.mainbg(3);
                    if (this.britchl <= -1) {
                        this.ongame = -1;
                        this.britchl = 0;
                    }
                    this.btn = 0;
                    this.pbtn = 0;
                    this.zeromsw = false;
                    int i_90_ = this.npo;
                    if (this.invo) {
                        i_90_ = 0;
                        for (int i_91_ = 0; i_91_ < this.npo; i_91_++) {
                            if (this.pgames[i_91_] <= -1)
                                i_90_++;
                        }
                        i_90_ += 2;
                    }
                    int i_92_ = (i_90_ - 11) * 30;
                    if (i_92_ < 0)
                        i_92_ = 0;
                    int i_93_ = (int) ((float) this.spos / 295.0F * (float) i_92_);
                    int i_94_ = 0;
                    int i_95_ = -1;
                    int i_96_ = -1;
                    if (this.conon == 1) {
                        if (!this.invo) {
                            for (int i_97_ = 0; i_97_ < this.npo; i_97_++) {
                                if (this.pgames[i_97_] != -1) {
                                    int i_98_ = 0;
                                    for (int i_99_ = 0; i_99_ < this.ngm; i_99_++) {
                                        if (this.pgames[i_97_] == this.gnum[i_99_])
                                            i_98_ = i_99_;
                                    }
                                    if (this.wait[i_98_] > 0) {
                                        if (82 + 30 * i_94_ - i_93_ > 50 && 82 + 30 * (i_94_ - 1) - i_93_ < 415) {
                                            boolean bool_100_ = false;
                                            if (i > 70 && i < 185 && i_87_ > 52 + 30 * i_94_ - i_93_ && i_87_ < 82 + 30 * i_94_ - i_93_) {
                                                if (this.pgames[this.im] <= -1 && this.join <= -1 && this.chalngd >= -1) {
                                                    if (bool || this.mousonp == i_97_) {
                                                        this.rd.setColor(color2k(255, 255, 255));
                                                        this.mousonp = i_97_;
                                                        i_96_ = 52 + 30 * i_94_ - i_93_;
                                                        if (bool) {
                                                            if (this.cmonp == i_97_)
                                                                this.ongame = this.pgames[i_97_];
                                                            this.chalngd = -1;
                                                        } else {
                                                            if (this.cmonp <= -1) {
                                                                this.ongame = -1;
                                                                this.cmonp = i_97_;
                                                            }
                                                            if (this.ongame == this.pgames[i_97_])
                                                                this.mousonp = -1;
                                                        }
                                                    } else
                                                        this.rd.setColor(color2k(220, 220, 220));
                                                    this.rd.fillRect(70, 53 + 30 * i_94_ - i_93_, 116, 29);
                                                    i_95_ = i_97_;
                                                }
                                                bool_100_ = true;
                                            }
                                            if (this.pgames[this.im] <= -1 && this.join <= -1 && this.chalngd >= -1)
                                                this.rd.setColor(new Color(49, 79, 0));
                                            else
                                                this.rd.setColor(new Color(34, 55, 0));
                                            boolean bool_101_ = this.gb.drawl(this.pnames[i_97_], 68, 53 + 30 * i_94_ - i_93_, bool_100_);
                                            if (!bool_100_ || !bool_101_) {
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString(this.pnames[i_97_], 127 - this.ftm.stringWidth(this.pnames[i_97_]) / 2, 66 + 30 * i_94_ - i_93_);
                                                this.rd.setFont(new Font("Arial", 0, 10));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString(this.pcarnames[i_97_], 127 - this.ftm.stringWidth(this.pcarnames[i_97_]) / 2, 78 + 30 * i_94_ - i_93_);
                                            }
                                            this.rd.setColor(color2k(150, 150, 150));
                                            this.rd.drawLine(70, 82 + 30 * i_94_ - i_93_, 185, 82 + 30 * i_94_ - i_93_);
                                        }
                                        i_94_++;
                                    }
                                }
                            }
                        }
                        if (this.invo) {
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("Free Players", 127 - this.ftm.stringWidth("Free Players") / 2, 75 - i_93_);
                            this.rd.setFont(new Font("Arial", 0, 10));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("Click a player to invite:", 127 - this.ftm.stringWidth("Click a player to invite:") / 2, 92 - i_93_);
                            this.rd.setColor(color2k(150, 150, 150));
                            this.rd.drawLine(70, 112 - i_93_, 185, 112 - i_93_);
                            i_94_ += 2;
                        }
                        for (int i_102_ = 0; i_102_ < this.npo; i_102_++) {
                            boolean bool_103_ = false;
                            if (this.invo) {
                                if (this.im == i_102_)
                                    bool_103_ = true;
                                for (int i_104_ = 0; i_104_ < 7; i_104_++) {
                                    if (this.invos[i_104_].equals(this.pnames[i_102_]) && !bool_103_)
                                        bool_103_ = true;
                                }
                            }
                            if (this.pgames[i_102_] <= -1 && !bool_103_) {
                                if (82 + 30 * i_94_ - i_93_ > 50 && 82 + 30 * (i_94_ - 1) - i_93_ < 415) {
                                    boolean bool_105_ = false;
                                    if (i > 70 && i < 185 && i_87_ > 52 + 30 * i_94_ - i_93_ && i_87_ < 82 + 30 * i_94_ - i_93_) {
                                        if (this.invo) {
                                            if (bool) {
                                                this.rd.setColor(color2k(255, 255, 255));
                                                this.mousonp = i_102_;
                                            } else {
                                                this.rd.setColor(color2k(220, 220, 220));
                                                if (this.mousonp == i_102_) {
                                                    int i_106_ = 0;
                                                    for (boolean bool_107_ = false; i_106_ < 7 && !bool_107_; i_106_++) {
                                                        if (this.invos[i_106_].equals("")) {
                                                            this.invos[i_106_] = this.pnames[i_102_];
                                                            bool_107_ = true;
                                                        }
                                                    }
                                                    this.mousonp = -1;
                                                    this.invo = false;
                                                }
                                            }
                                            this.rd.fillRect(70, 53 + 30 * i_94_ - i_93_, 116, 29);
                                            i_95_ = i_102_;
                                        } else if (this.pgames[this.im] <= -1 && this.join <= -1 && this.chalngd >= -1) {
                                            i_89_ = 12;
                                            if (bool) {
                                                if (!(this.gb).proname.equals(this.pnames[i_102_])) {
                                                    (this.gb).proname = this.pnames[i_102_];
                                                    (this.gb).loadedp = false;
                                                }
                                                (this.gb).tab = 1;
                                                (this.gb).open = 2;
                                                (this.gb).upo = true;
                                            }
                                        }
                                        bool_105_ = true;
                                    }
                                    if (this.invo)
                                        this.rd.setColor(new Color(62, 98, 0));
                                    else
                                        this.rd.setColor(new Color(0, 0, 0));
                                    boolean bool_108_ = this.gb.drawl(this.pnames[i_102_], 68, 53 + 30 * i_94_ - i_93_, bool_105_);
                                    if (!bool_105_ || !bool_108_) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.pnames[i_102_], 127 - this.ftm.stringWidth(this.pnames[i_102_]) / 2, 66 + 30 * i_94_ - i_93_);
                                        this.rd.setFont(new Font("Arial", 0, 10));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.pcarnames[i_102_], 127 - this.ftm.stringWidth(this.pcarnames[i_102_]) / 2, 78 + 30 * i_94_ - i_93_);
                                    }
                                    this.rd.setColor(color2k(150, 150, 150));
                                    this.rd.drawLine(70, 82 + 30 * i_94_ - i_93_, 185, 82 + 30 * i_94_ - i_93_);
                                }
                                i_94_++;
                            }
                        }
                        if (this.invo && i_94_ == 2)
                            this.invo = false;
                        if (!this.invo) {
                            for (int i_109_ = this.npo - 1; i_109_ >= 0; i_109_--) {
                                if (this.pgames[i_109_] != -1) {
                                    int i_110_ = 0;
                                    for (int i_111_ = 0; i_111_ < this.ngm; i_111_++) {
                                        if (this.pgames[i_109_] == this.gnum[i_111_])
                                            i_110_ = i_111_;
                                    }
                                    if (this.wait[i_110_] <= 0) {
                                        boolean bool_112_ = false;
                                        for (int i_113_ = 0; i_113_ < this.npo; i_113_++) {
                                            if (i_109_ != i_113_ && this.pnames[i_109_].equals(this.pnames[i_113_])) {
                                                if (this.pgames[i_113_] <= -1)
                                                    bool_112_ = true;
                                                else {
                                                    for (int i_114_ = 0; i_114_ < this.ngm; i_114_++) {
                                                        if (this.pgames[i_113_] == this.gnum[i_114_] && this.wait[i_114_] > 0)
                                                            bool_112_ = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (!bool_112_) {
                                            if (82 + 30 * i_94_ - i_93_ > 50 && 82 + 30 * (i_94_ - 1) - i_93_ < 415) {
                                                boolean bool_115_ = false;
                                                if (i > 70 && i < 185 && i_87_ > 52 + 30 * i_94_ - i_93_ && i_87_ < 82 + 30 * i_94_ - i_93_) {
                                                    if (this.pgames[this.im] <= -1 && this.join <= -1 && this.chalngd >= -1) {
                                                        if (bool || this.mousonp == i_109_) {
                                                            this.rd.setColor(color2k(255, 255, 255));
                                                            this.mousonp = i_109_;
                                                            i_96_ = 52 + 30 * i_94_ - i_93_;
                                                            if (bool) {
                                                                if (this.cmonp == i_109_)
                                                                    this.ongame = this.pgames[i_109_];
                                                                this.chalngd = -1;
                                                            } else {
                                                                if (this.cmonp <= -1) {
                                                                    this.ongame = -1;
                                                                    this.cmonp = i_109_;
                                                                }
                                                                if (this.ongame == this.pgames[i_109_])
                                                                    this.mousonp = -1;
                                                            }
                                                        } else
                                                            this.rd.setColor(color2k(220, 220, 220));
                                                        this.rd.fillRect(70, 53 + 30 * i_94_ - i_93_, 116, 29);
                                                        i_95_ = i_109_;
                                                    }
                                                    bool_115_ = true;
                                                }
                                                if (this.pgames[this.im] <= -1 && this.join <= -1 && this.chalngd >= -1) {
                                                    if (this.wait[i_110_] == 0)
                                                        this.rd.setColor(new Color(117, 67, 0));
                                                    else
                                                        this.rd.setColor(color2k(0, 28, 102));
                                                } else if (this.wait[i_110_] == 0)
                                                    this.rd.setColor(new Color(82, 47, 0));
                                                else
                                                    this.rd.setColor(color2k(0, 20, 71));
                                                boolean bool_116_ = this.gb.drawl(this.pnames[i_109_], 68, 53 + 30 * i_94_ - i_93_, bool_115_);
                                                if (!bool_115_ || !bool_116_) {
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString(this.pnames[i_109_], 127 - this.ftm.stringWidth(this.pnames[i_109_]) / 2, 66 + 30 * i_94_ - i_93_);
                                                    this.rd.setFont(new Font("Arial", 0, 10));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.drawString(this.pcarnames[i_109_], 127 - this.ftm.stringWidth(this.pcarnames[i_109_]) / 2, 78 + 30 * i_94_ - i_93_);
                                                }
                                                this.rd.setColor(color2k(150, 150, 150));
                                                this.rd.drawLine(70, 82 + 30 * i_94_ - i_93_, 185, 82 + 30 * i_94_ - i_93_);
                                            }
                                            i_94_++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.mousonp != i_95_) {
                        this.mousonp = -1;
                        this.cmonp = -1;
                    }
                    if (this.npo == 0) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("|  Loading Players  |", 127 - this.ftm.stringWidth("|  Loading Players  |") / 2, 95);
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
                    this.rd.drawImage((this.xt).roomp, 72, 30, null);
                    if (this.mscro == 131 || i_92_ == 0) {
                        if (i_92_ == 0)
                            this.rd.setColor(color2k(205, 205, 205));
                        else
                            this.rd.setColor(color2k(215, 215, 215));
                        this.rd.fillRect(193, 53, 17, 17);
                    } else {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fill3DRect(193, 53, 17, 17, true);
                    }
                    if (i_92_ != 0)
                        this.rd.drawImage((this.xt).asu, 198, 59, null);
                    if (this.mscro == 132 || i_92_ == 0) {
                        if (i_92_ == 0)
                            this.rd.setColor(color2k(205, 205, 205));
                        else
                            this.rd.setColor(color2k(215, 215, 215));
                        this.rd.fillRect(193, 396, 17, 17);
                    } else {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fill3DRect(193, 396, 17, 17, true);
                    }
                    if (i_92_ != 0)
                        this.rd.drawImage((this.xt).asd, 198, 403, null);
                    if (i_92_ != 0 && this.conon == 1) {
                        if (this.lspos != this.spos) {
                            this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fillRect(193, 70 + this.spos, 17, 31);
                        } else {
                            if (this.mscro == 131)
                                this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fill3DRect(193, 70 + this.spos, 17, 31, true);
                        }
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(198, 83 + this.spos, 204, 83 + this.spos);
                        this.rd.drawLine(198, 85 + this.spos, 204, 85 + this.spos);
                        this.rd.drawLine(198, 87 + this.spos, 204, 87 + this.spos);
                        if (this.mscro > 101 && this.lspos != this.spos)
                            this.lspos = this.spos;
                        if (bool) {
                            if (this.mscro == 125 && i > 193 && i < 210 && i_87_ > 70 + this.spos && i_87_ < this.spos + 101)
                                this.mscro = i_87_ - this.spos;
                            if (this.mscro == 125 && i > 191 && i < 212 && i_87_ > 51 && i_87_ < 72)
                                this.mscro = 131;
                            if (this.mscro == 125 && i > 191 && i < 212 && i_87_ > 394 && i_87_ < 415)
                                this.mscro = 132;
                            if (this.mscro == 125 && i > 193 && i < 210 && i_87_ > 70 && i_87_ < 396) {
                                this.mscro = 85;
                                this.spos = i_87_ - this.mscro;
                            }
                            int i_117_ = 1350 / i_92_;
                            if (i_117_ < 1)
                                i_117_ = 1;
                            if (this.mscro == 131) {
                                this.spos -= i_117_;
                                if (this.spos > 295)
                                    this.spos = 295;
                                if (this.spos < 0)
                                    this.spos = 0;
                                this.lspos = this.spos;
                            }
                            if (this.mscro == 132) {
                                this.spos += i_117_;
                                if (this.spos > 295)
                                    this.spos = 295;
                                if (this.spos < 0)
                                    this.spos = 0;
                                this.lspos = this.spos;
                            }
                            if (this.mscro <= 101) {
                                this.spos = i_87_ - this.mscro;
                                if (this.spos > 295)
                                    this.spos = 295;
                                if (this.spos < 0)
                                    this.spos = 0;
                            }
                            if (this.mscro == 125)
                                this.mscro = 225;
                        } else if (this.mscro != 125)
                            this.mscro = 125;
                        if (i_88_ != 0 && i > 65 && i < 170 && i_87_ > 93 && i_87_ < 413) {
                            this.spos -= i_88_;
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
                    if (this.ongame <= -1) {
                        if (this.opengame >= 2) {
                            if (this.opengame >= 27)
                                this.opengame = 26;
                            int i_118_ = 229 + this.opengame;
                            if (i_118_ > 255)
                                i_118_ = 255;
                            if (i_118_ < 0)
                                i_118_ = 0;
                            this.rd.setColor(color2k(i_118_, i_118_, i_118_));
                            this.rd.fillRoundRect(225, 59 - this.opengame, 495, 200 + this.opengame * 7, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(225, 59 - this.opengame, 495, 200 + this.opengame * 7, 20, 20);
                            if (!(this.xt).lan) {
                                this.rd.setColor(color2k(217, 217, 217));
                                this.rd.fillRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                            }
                            this.btn = 0;
                            if (this.prevloaded != -1)
                                this.prevloaded = -1;
                            if (this.updatec != -1)
                                this.updatec = -1;
                            if ((this.gs).cmsg.getText().equals(""))
                                (this.gs).cmsg.setText("Type here...");
                            if ((this.gs).cmsg.isShowing()) {
                                (this.gs).cmsg.hide();
                                this.gs.requestFocus();
                            }
                            this.opengame -= 2;
                            if (this.opengame == 0 && this.longame != -1 && this.chalngd <= -1) {
                                this.ongame = this.longame;
                                this.longame = -1;
                            }
                            if (this.invo)
                                this.invo = false;
                            for (int i_119_ = 0; i_119_ < 7; i_119_++) {
                                if (!this.invos[i_119_].equals(""))
                                    this.invos[i_119_] = "";
                                if (!this.dinvi[i_119_].equals(""))
                                    this.dinvi[i_119_] = "";
                            }
                            if (this.fstart)
                                this.fstart = false;
                            for (int i_120_ = 0; i_120_ < 9; i_120_++) {
                                if (this.cac[i_120_] != -1)
                                    this.cac[i_120_] = -1;
                            }
                            if (this.dispcar != -1)
                                this.dispcar = -1;
                        } else {
                            if (!(this.xt).lan) {
                                drawSbutton((this.xt).cgame, 292, 42);
                                drawSbutton((this.xt).ccar, 442, 42);
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(color2k(60, 60, 60));
                                if (!(this.gs).rooms.isShowing())
                                    (this.gs).rooms.show();
                                (this.gs).rooms.move(580 - ((this.gs).rooms).w / 2, 29);
                                if (((this.gs).rooms).sel != 0) {
                                    stopallnow();
                                    (this.xt).servport = 7070 + ((this.gs).rooms).iroom[((this.gs).rooms).sel];
                                    inishlobby();
                                    ((this.gs).rooms).kmoused = 20;
                                }
                                if (((this.gs).rooms).kmoused != 0) {
                                    i = -1;
                                    i_87_ = -1;
                                    bool = false;
                                    ((this.gs).rooms).kmoused--;
                                }
                            } else {
                                this.rd.drawImage((this.xt).lanm, 241, 31, null);
                                if (this.npo <= 1) {
                                    drawSbutton((this.xt).cgame, 292, -1000);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    if (this.ncnt == 0)
                                        this.rd.setColor(new Color(188, 111, 0));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(this.lmsg, 472 - this.ftm.stringWidth(this.lmsg) / 2, 295);
                                    if (this.lmsg.equals(". . . | Searching/Waiting for other LAN Players | . . .") && this.ncnt == 0) {
                                        this.lmsg = "| Searching/Waiting for other LAN Players |";
                                        this.ncnt = 5;
                                    }
                                    if (this.lmsg.equals(". . | Searching/Waiting for other LAN Players | . .") && this.ncnt == 0) {
                                        this.lmsg = ". . . | Searching/Waiting for other LAN Players | . . .";
                                        this.ncnt = 5;
                                    }
                                    if (this.lmsg.equals(". | Searching/Waiting for other LAN Players | .") && this.ncnt == 0) {
                                        this.lmsg = ". . | Searching/Waiting for other LAN Players | . .";
                                        this.ncnt = 5;
                                    }
                                    if (this.lmsg.equals("| Searching/Waiting for other LAN Players |") && this.ncnt == 0) {
                                        this.lmsg = ". | Searching/Waiting for other LAN Players | .";
                                        this.ncnt = 5;
                                    }
                                    if (this.ncnt != 0)
                                        this.ncnt--;
                                    this.rd.setColor(color2k(70, 70, 70));
                                    this.rd.drawString("HACKED BY C.HANSEN", 225, 325);
                                    this.rd.drawString("Get some asshole to connect to your motherfucking router", 225, 345);
                                    this.rd.drawString("or get Hamachi and make a hosts file redirecting localhost to your hamachi IP...", 225, 365);
                                } else if (!this.lanlogged) {
                                	this.lanlogged = true;
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("HACKED BY C.HANSEN", 472 - this.ftm.stringWidth("HACKED BY C.HANSEN") / 2, 295);
                                    this.rd.setColor(color2k(70, 70, 70));
                                    this.rd.drawString("Exit and re-enter the lobby for 3 more free plays", 225, 325);
                                    this.rd.drawString("ACCEPT NO IMITATION", 225, 345);
                                    this.rd.drawString("IF YOU STEAL MY SHIT I'LL FUCK YOU UP", 225, 365);
                                    this.rd.drawString("HACKED BY C.HANSEN", 225, 385);
                                    drawSbutton((this.xt).register, 472, 395);
                                } else {
                                    this.rd.setColor(color2k(90, 90, 90));
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(new StringBuilder().append("[  ").append(i_94_).append(" Players Connected  ]").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("[  ").append(i_94_).append(" Players Connected  ]").toString()) / 2, 295);
                                    drawSbutton((this.xt).cgame, 472, 325);
                                }
                                drawSbutton((this.xt).ccar, 442, -1000);
                            }
                            drawSbutton((this.xt).exit, 690, 42);
                            if ((control).enter && !(this.gs).cmsg.getText().equals("Type here...") && !(this.gs).cmsg.getText().equals("")) {
                                if (this.chalngd <= -1)
                                    this.pessd[2] = true;
                                else
                                    this.pessd[5] = true;
                                (control).enter = false;
                                String string = (this.gs).cmsg.getText().replace('|', ':');
                                if (string.toLowerCase().indexOf((this.gs).tpass.getText().toLowerCase()) != -1)
                                    string = " ";
                                if (!this.xt.msgcheck(string) && this.updatec > -12) {
                                    for (int i_121_ = 0; i_121_ < 6; i_121_++) {
                                        this.sentn[i_121_] = this.sentn[i_121_ + 1];
                                        this.cnames[i_121_] = this.cnames[i_121_ + 1];
                                    }
                                    this.sentn[6] = string;
                                    this.cnames[6] = this.pnames[this.im];
                                    if (this.updatec > -11)
                                        this.updatec = -11;
                                    else
                                        this.updatec--;
                                    this.spos3 = 28;
                                } else
                                    (this.xt).warning++;
                                (this.gs).cmsg.setText("");
                            }
                            if (this.chalngd <= -1) {
                                this.rd.setColor(color2k(230, 230, 230));
                                this.rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                                if (this.britchl != 0)
                                    this.britchl = 0;
                                i_92_ = (this.ngm - 5) * 24;
                                if (i_92_ < 0)
                                    i_92_ = 0;
                                i_93_ = (int) ((float) this.spos2 / 82.0F * (float) i_92_ - 2.0F);
                                int[] is = new int[this.ngm];
                                int[] is_122_ = new int[this.ngm];
                                for (int i_123_ = 0; i_123_ < this.ngm; i_123_++)
                                    is[i_123_] = 0;
                                for (int i_124_ = 0; i_124_ < this.ngm; i_124_++) {
                                    for (int i_125_ = i_124_ + 1; i_125_ < this.ngm; i_125_++) {
                                        if (this.wait[i_124_] != this.wait[i_125_]) {
                                            if (this.wait[i_124_] <= 0 && this.wait[i_125_] <= 0) {
                                                if (this.wait[i_124_] < this.wait[i_125_])
                                                    is[i_124_]++;
                                                else
                                                    is[i_125_]++;
                                            } else if ((this.wait[i_124_] > this.wait[i_125_] || this.wait[i_124_] <= 0) && this.wait[i_125_] > 0)
                                                is[i_124_]++;
                                            else
                                                is[i_125_]++;
                                        } else if (i_125_ < i_124_)
                                            is[i_124_]++;
                                        else
                                            is[i_125_]++;
                                    }
                                    is_122_[is[i_124_]] = i_124_;
                                }
                                if ((control).down) {
                                    this.opselect++;
                                    for (boolean bool_126_ = false; 80 + 24 * this.opselect - i_93_ > 202 && !bool_126_; i_93_ = (int) ((float) this.spos2 / 82.0F * (float) i_92_ - 2.0F)) {
                                        this.spos2++;
                                        if (this.spos2 > 82) {
                                            this.spos2 = 82;
                                            bool_126_ = true;
                                        }
                                        if (this.spos2 < 0) {
                                            this.spos2 = 0;
                                            bool_126_ = true;
                                        }
                                    }
                                    (control).down = false;
                                }
                                if ((control).up) {
                                    this.opselect--;
                                    for (boolean bool_127_ = false; 80 + 24 * this.opselect - i_93_ < 80 && !bool_127_; i_93_ = (int) ((float) this.spos2 / 82.0F * (float) i_92_ - 2.0F)) {
                                        this.spos2--;
                                        if (this.spos2 > 82) {
                                            this.spos2 = 82;
                                            bool_127_ = true;
                                        }
                                        if (this.spos2 < 0) {
                                            this.spos2 = 0;
                                            bool_127_ = true;
                                        }
                                    }
                                    (control).up = false;
                                }
                                int i_128_ = -1;
                                if (this.mousonp != -1) {
                                    int i_129_ = 0;
                                    for (int i_130_ = 0; i_130_ < this.ngm; i_130_++) {
                                        if (this.pgames[this.mousonp] == this.gnum[i_130_])
                                            i_129_ = i_130_;
                                    }
                                    i_128_ = 91 + 24 * is[i_129_] - i_93_;
                                    if (80 + 24 * is[i_129_] - i_93_ > 202) {
                                        int i_131_ = 1000 / i_92_;
                                        if (i_131_ < 1)
                                            i_131_ = 1;
                                        this.spos2 += i_131_;
                                        i_128_ = -1;
                                    }
                                    if (80 + 24 * is[i_129_] - i_93_ < 80) {
                                        int i_132_ = 1000 / i_92_;
                                        if (i_132_ < 1)
                                            i_132_ = 1;
                                        this.spos2 -= i_132_;
                                        i_128_ = -1;
                                    }
                                    if (this.spos2 > 82)
                                        this.spos2 = 82;
                                    if (this.spos2 < 0)
                                        this.spos2 = 0;
                                    i_93_ = (int) ((float) this.spos2 / 82.0F * (float) i_92_ - 2.0F);
                                    this.opselect = is[i_129_];
                                }
                                if (this.opselect <= -1)
                                    this.opselect = 0;
                                if (this.opselect >= this.ngm)
                                    this.opselect = this.ngm - 1;
                                int i_133_ = 0;
                                for (int i_134_ = 0; i_134_ < this.ngm; i_134_++) {
                                    if (80 + 24 * i_134_ - i_93_ < 224 && 80 + 24 * i_134_ - i_93_ > 56) {
                                        if (this.opselect == i_134_) {
                                            if (80 + 24 * i_134_ - i_93_ >= 224)
                                                this.opselect--;
                                            if (80 + 24 * i_134_ - i_93_ < 62)
                                                this.opselect++;
                                        }
                                        boolean bool_135_ = false;
                                        boolean bool_136_ = false;
                                        if (!(this.gs).openm) {
                                            if (i > 241 && i < 692 && i_87_ > 92 + 24 * i_134_ - i_93_ && i_87_ < 110 + 24 * i_134_ - i_93_) {
                                                if (this.lxm != i || this.lym != i_87_)
                                                    this.opselect = i_134_;
                                                bool_135_ = true;
                                                if (bool) {
                                                    if (this.clicked <= -1)
                                                        this.clicked = is_122_[i_134_];
                                                } else {
                                                    if (this.clicked == is_122_[i_134_]) {
                                                        this.ongame = this.gnum[is_122_[i_134_]];
                                                        this.opengame = 0;
                                                        if (i >= 641 && i <= 689 && i_87_ > 92 + 24 * i_134_ - i_93_ && i_87_ < 110 + 24 * i_134_ - i_93_ && this.wait[is_122_[i_134_]] > 0 && (this.gplyrs[is_122_[i_134_]].equals("") || this.gplyrs[is_122_[i_134_]].indexOf(this.pnames[this.im]) != -1)) {
                                                            this.join = this.gnum[is_122_[i_134_]];
                                                            this.msg = "| Joining Game |";
                                                            this.spos = 0;
                                                        }
                                                        this.clicked = -1;
                                                    }
                                                    i_133_++;
                                                }
                                            } else
                                                i_133_++;
                                            if (i >= 641 && i <= 689 && i_87_ > 92 + 24 * i_134_ - i_93_ && i_87_ < 110 + 24 * i_134_ - i_93_ && bool)
                                                bool_136_ = true;
                                        }
                                        if (this.opselect == i_134_) {
                                            if (bool_135_ && bool || (control).enter) {
                                                this.rd.setColor(color2k(200, 200, 200));
                                                if ((control).enter) {
                                                    this.ongame = this.gnum[is_122_[i_134_]];
                                                    this.opengame = 0;
                                                    (control).enter = false;
                                                }
                                            } else
                                                this.rd.setColor(color2k(255, 255, 255));
                                            this.rd.fillRect(241, 92 + 24 * i_134_ - i_93_, 451, 18);
                                            if (bool_135_) {
                                                this.rd.setColor(color2k(150, 150, 150));
                                                this.rd.drawRect(239, 90 + 24 * i_134_ - i_93_, 454, 21);
                                            }
                                        }
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.gstages[is_122_[i_134_]], 382 - this.ftm.stringWidth(this.gstages[is_122_[i_134_]]) / 2, 105 + 24 * i_134_ - i_93_);
                                        this.rd.drawString("|", 525, 105 + 24 * i_134_ - i_93_);
                                        this.rd.drawString("|", 584, 105 + 24 * i_134_ - i_93_);
                                        if (this.wait[is_122_[i_134_]] > 0) {
                                            this.rd.drawString(new StringBuilder().append("").append(this.npls[is_122_[i_134_]]).append(" / ").append(this.mnpls[is_122_[i_134_]]).append("").toString(), 556 - this.ftm.stringWidth(new StringBuilder().append("").append(this.npls[is_122_[i_134_]]).append(" / ").append(this.mnpls[is_122_[i_134_]]).append("").toString()) / 2, 105 + 24 * i_134_ - i_93_);
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.rd.setColor(new Color(80, 128, 0));
                                            this.rd.drawString("Waiting", 593, 105 + 24 * i_134_ - i_93_);
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            if (!bool_136_) {
                                                this.rd.setColor(color2k(230, 230, 230));
                                                this.rd.fill3DRect(641, 92 + 24 * i_134_ - i_93_, 48, 18, true);
                                                this.rd.fill3DRect(642, 93 + 24 * i_134_ - i_93_, 46, 16, true);
                                            } else {
                                                this.rd.setColor(color2k(230, 230, 230));
                                                this.rd.fillRect(641, 92 + 24 * i_134_ - i_93_, 48, 18);
                                            }
                                            this.rd.setColor(new Color(0, 0, 0));
                                            if (this.gplyrs[is_122_[i_134_]].equals("") || this.gplyrs[is_122_[i_134_]].indexOf(this.pnames[this.im]) != -1)
                                                this.rd.drawString("Join", 665 - this.ftm.stringWidth("Join") / 2, 105 + 24 * i_134_ - i_93_);
                                            else
                                                this.rd.drawString("View", 665 - this.ftm.stringWidth("View") / 2, 105 + 24 * i_134_ - i_93_);
                                        } else {
                                            this.rd.drawString(new StringBuilder().append("").append(this.npls[is_122_[i_134_]]).append("").toString(), 556 - this.ftm.stringWidth(new StringBuilder().append("").append(this.npls[is_122_[i_134_]]).append("").toString()) / 2, 105 + 24 * i_134_ - i_93_);
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            if (this.wait[is_122_[i_134_]] == 0) {
                                                this.rd.setColor(new Color(128, 73, 0));
                                                this.rd.drawString("Started", 594, 105 + 24 * i_134_ - i_93_);
                                            } else {
                                                this.rd.setColor(color2k(100, 100, 100));
                                                this.rd.drawString("Finished", 590, 105 + 24 * i_134_ - i_93_);
                                            }
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            if (!bool_136_) {
                                                this.rd.setColor(color2k(230, 230, 230));
                                                this.rd.fill3DRect(641, 92 + 24 * i_134_ - i_93_, 48, 18, true);
                                            } else {
                                                this.rd.setColor(color2k(230, 230, 230));
                                                this.rd.fillRect(641, 92 + 24 * i_134_ - i_93_, 48, 18);
                                            }
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.drawString("View", 665 - this.ftm.stringWidth("View") / 2, 105 + 24 * i_134_ - i_93_);
                                        }
                                    } else {
                                        if (this.opselect == i_134_) {
                                            if (80 + 24 * i_134_ - i_93_ >= 224)
                                                this.opselect--;
                                            if (80 + 24 * i_134_ - i_93_ <= 56)
                                                this.opselect++;
                                        }
                                        i_133_++;
                                    }
                                }
                                if (i_133_ == this.ngm && this.clicked != -1)
                                    this.clicked = -1;
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.ngm == 0) {
                                    if (!this.lloaded)
                                        this.rd.drawString("|  Loading Games  |", 472 - this.ftm.stringWidth("|  Loading Games  |") / 2, 165);
                                    else if (!(this.xt).lan)
                                        this.rd.drawString("No Games Created", 472 - this.ftm.stringWidth("No Games Created") / 2, 165);
                                }
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(235, 65, 480, 25);
                                this.rd.drawImage((this.xt).games, 241, 69, null);
                                this.rd.setColor(color2k(70, 70, 70));
                                this.rd.drawString("Stage Name", 382 - this.ftm.stringWidth("Stage Name") / 2, 81);
                                this.rd.drawString("|", 525, 81);
                                this.rd.drawString("Players", 556 - this.ftm.stringWidth("Players") / 2, 81);
                                this.rd.drawString("|", 584, 81);
                                this.rd.drawString("Status", 641 - this.ftm.stringWidth("Status") / 2, 81);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(235, 87, 696, 87);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(235, 237, 480, 17);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(235, 239, 696, 239);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(698, 107, 17, 113);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(231, 65, 4, 189);
                                if (this.mscro2 == 141 || i_92_ == 0) {
                                    if (i_92_ == 0)
                                        this.rd.setColor(color2k(205, 205, 205));
                                    else
                                        this.rd.setColor(color2k(215, 215, 215));
                                    this.rd.fillRect(698, 90, 17, 17);
                                } else {
                                    this.rd.setColor(color2k(220, 220, 220));
                                    this.rd.fill3DRect(698, 90, 17, 17, true);
                                }
                                if (i_92_ != 0)
                                    this.rd.drawImage((this.xt).asu, 703, 96, null);
                                if (this.mscro2 == 142 || i_92_ == 0) {
                                    if (i_92_ == 0)
                                        this.rd.setColor(color2k(205, 205, 205));
                                    else
                                        this.rd.setColor(color2k(215, 215, 215));
                                    this.rd.fillRect(698, 220, 17, 17);
                                } else {
                                    this.rd.setColor(color2k(220, 220, 220));
                                    this.rd.fill3DRect(698, 220, 17, 17, true);
                                }
                                if (i_92_ != 0)
                                    this.rd.drawImage((this.xt).asd, 703, 226, null);
                                if (i_92_ != 0) {
                                    if (this.lspos2 != this.spos2) {
                                        this.rd.setColor(color2k(215, 215, 215));
                                        this.rd.fillRect(698, 107 + this.spos2, 17, 31);
                                    } else {
                                        if (this.mscro2 == 141)
                                            this.rd.setColor(color2k(215, 215, 215));
                                        this.rd.fill3DRect(698, 107 + this.spos2, 17, 31, true);
                                    }
                                    this.rd.setColor(color2k(150, 150, 150));
                                    this.rd.drawLine(703, 120 + this.spos2, 709, 120 + this.spos2);
                                    this.rd.drawLine(703, 122 + this.spos2, 709, 122 + this.spos2);
                                    this.rd.drawLine(703, 124 + this.spos2, 709, 124 + this.spos2);
                                    if (this.mscro2 > 138 && this.lspos2 != this.spos2)
                                        this.lspos2 = this.spos2;
                                    if (bool) {
                                        if (this.mscro2 == 145 && i > 698 && i < 715 && i_87_ > 107 + this.spos2 && i_87_ < this.spos2 + 138)
                                            this.mscro2 = i_87_ - this.spos2;
                                        if (this.mscro2 == 145 && i > 696 && i < 717 && i_87_ > 88 && i_87_ < 109)
                                            this.mscro2 = 141;
                                        if (this.mscro2 == 145 && i > 696 && i < 717 && i_87_ > 218 && i_87_ < 239)
                                            this.mscro2 = 142;
                                        if (this.mscro2 == 145 && i > 698 && i < 715 && i_87_ > 107 && i_87_ < 220) {
                                            this.mscro2 = 122;
                                            this.spos2 = i_87_ - this.mscro2;
                                        }
                                        int i_137_ = 400 / i_92_;
                                        if (i_137_ < 1)
                                            i_137_ = 1;
                                        if (this.mscro2 == 141) {
                                            this.spos2 -= i_137_;
                                            if (this.spos2 > 82)
                                                this.spos2 = 82;
                                            if (this.spos2 < 0)
                                                this.spos2 = 0;
                                            this.lspos2 = this.spos2;
                                        }
                                        if (this.mscro2 == 142) {
                                            this.spos2 += i_137_;
                                            if (this.spos2 > 82)
                                                this.spos2 = 82;
                                            if (this.spos2 < 0)
                                                this.spos2 = 0;
                                            this.lspos2 = this.spos2;
                                        }
                                        if (this.mscro2 <= 138) {
                                            this.spos2 = i_87_ - this.mscro2;
                                            if (this.spos2 > 82)
                                                this.spos2 = 82;
                                            if (this.spos2 < 0)
                                                this.spos2 = 0;
                                        }
                                        if (this.mscro2 == 145)
                                            this.mscro2 = 225;
                                    } else if (this.mscro2 != 145)
                                        this.mscro2 = 145;
                                    if (i_88_ != 0 && i > 235 && i < 698 && i_87_ > 87 && i_87_ < 239) {
                                        this.spos2 -= i_88_;
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
                                if (this.mousonp != -1 && i_128_ != -1) {
                                    this.rd.setColor(color2k(255, 255, 255));
                                    int[] is_138_ = { 185, 241, 241, 185 };
                                    int[] is_139_ = { i_96_, i_128_, i_128_ + 19, i_96_ + 30 };
                                    this.rd.fillPolygon(is_138_, is_139_, 4);
                                    this.rd.setColor(color2k(150, 150, 150));
                                    this.rd.drawLine(185, i_96_, 241, i_128_);
                                    this.rd.drawLine(185, i_96_ + 30, 241, i_128_ + 19);
                                    this.rd.drawLine(241, i_128_, 692, i_128_);
                                    this.rd.drawLine(241, i_128_ + 19, 692, i_128_ + 19);
                                }
                            } else {
                                int i_140_ = 230 + this.britchl;
                                if (i_140_ > 255)
                                    i_140_ = 255;
                                if (i_140_ < 0)
                                    i_140_ = 0;
                                this.rd.setColor(color2k(i_140_, i_140_, i_140_));
                                this.rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                                if (this.britchl < 25)
                                    this.britchl += 5;
                                if (this.chalngd > -1) {
                                    int i_141_ = 0;
                                    for (int i_142_ = 0; i_142_ < this.ngm; i_142_++) {
                                        if (this.chalngd == this.gnum[i_142_])
                                            i_141_ = i_142_;
                                    }
                                    if (this.cflk % 4 != 0 || this.cflk == 0) {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(new StringBuilder().append("You have been invited by ").append(this.chalby).append(" to join a game!").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("You have been invited by ").append(this.chalby).append(" to join a game!").toString()) / 2, 95);
                                        this.rd.setColor(new Color(117, 67, 0));
                                        this.rd.drawString(this.chalby, 472 - this.ftm.stringWidth(new StringBuilder().append("You have been invited by ").append(this.chalby).append(" to join a game!").toString()) / 2 + this.ftm.stringWidth("You have been invited by "), 95);
                                    }
                                    if (this.cflk != 0)
                                        this.cflk--;
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(new StringBuilder().append("Stage:  ").append(this.gstages[i_141_]).append(" ,  Laps: ").append(this.gnlaps[i_141_]).append("").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("Stage:  ").append(this.gstages[i_141_]).append(" ,  Laps: ").append(this.gnlaps[i_141_]).append("").toString()) / 2, 130);
                                    this.rd.setColor(new Color(62, 98, 0));
                                    this.rd.drawString(this.gstages[i_141_], 472 - this.ftm.stringWidth(new StringBuilder().append("Stage:  ").append(this.gstages[i_141_]).append(" ,  Laps: ").append(this.gnlaps[i_141_]).append("").toString()) / 2 + this.ftm.stringWidth("Stage:  "), 130);
                                    this.rd.drawString(new StringBuilder().append("").append(this.gnlaps[i_141_]).append("").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("Stage:  ").append(this.gstages[i_141_]).append(" ,  Laps: ").append(this.gnlaps[i_141_]).append("").toString()) / 2 + this.ftm.stringWidth(new StringBuilder().append("Stage:  ").append(this.gstages[i_141_]).append(" ,  Laps: ").toString()), 130);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(new StringBuilder().append("Players:  ").append(this.mnpls[i_141_]).append("").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("Players:  ").append(this.mnpls[i_141_]).append("").toString()) / 2, 150);
                                    this.rd.setColor(new Color(62, 98, 0));
                                    this.rd.drawString(new StringBuilder().append("").append(this.mnpls[i_141_]).append("").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("Players:  ").append(this.mnpls[i_141_]).append("").toString()) / 2 + this.ftm.stringWidth("Players:  "), 150);
                                    Date date = new Date();
                                    long l = date.getTime();
                                    if (this.ptime == 0L || l > this.ptime + 1000L) {
                                        if (this.ptime != 0L)
                                            this.ctime--;
                                        this.ptime = l;
                                    }
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 0, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(new StringBuilder().append("(").append(this.ctime).append(" )").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("(").append(this.ctime).append(" )").toString()) / 2, 170);
                                    if (this.ctime == 0) {
                                        this.ongame = this.longame;
                                        this.chalngd = -1;
                                        this.longame = -1;
                                    }
                                    stringbutton("   View Game   ", 352, 215, 2);
                                    stringbutton("   Join Game   ", 462, 215, 2);
                                    stringbutton("   Decline X   ", 599, 215, 2);
                                } else {
                                    if (this.chalngd != -5) {
                                        if (this.cflk % 4 != 0 || this.cflk == 0) {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 13));
                                            this.rd.drawString("Create Game...", 241, 85);
                                        }
                                        if (this.cflk != 0)
                                            this.cflk--;
                                        stringbutton(" Cancel X ", 669, 85, 2);
                                    }
                                    if (this.chalngd == -2) {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (this.sflk % 4 != 0 || this.sflk == 0)
                                            this.rd.drawString("Select Game's Stage", 472 - this.ftm.stringWidth("Select Game's Stage") / 2, 85);
                                        if (this.sflk != 0)
                                            this.sflk--;
                                        int i_143_ = 0;
                                        (this.gs).sgame.setSize(139, 22);
                                        if ((this.gs).sgame.getSelectedIndex() == 0)
                                            i_143_ = 472 - ((this.gs).sgame.getWidth() + 6 + (this.gs).snfmm.getWidth()) / 2;
                                        if ((this.gs).sgame.getSelectedIndex() == 1)
                                            i_143_ = 472 - ((this.gs).sgame.getWidth() + 6 + (this.gs).snfm1.getWidth()) / 2;
                                        if ((this.gs).sgame.getSelectedIndex() == 2)
                                            i_143_ = 472 - ((this.gs).sgame.getWidth() + 6 + (this.gs).snfm2.getWidth()) / 2;
                                        if ((this.gs).sgame.getSelectedIndex() == 3) {
                                            (this.gs).mstgs.setSize(338, 22);
                                            if (!this.sgflag) {
                                                if ((this.xt).logged) {
                                                    if ((this.cd).msloaded != 1) {
                                                        (this.gs).mstgs.removeAll();
                                                        (this.gs).mstgs.add(this.rd, "Loading your stages now, please wait...");
                                                        (this.gs).mstgs.select(0);
                                                        this.msload = true;
                                                    }
                                                } else {
                                                    (this.gs).mstgs.removeAll();
                                                    (this.gs).mstgs.add(this.rd, "You need to have a full account to access this.");
                                                    (this.gs).mstgs.select(0);
                                                    (this.cd).msloaded = 0;
                                                }
                                                this.sgflag = true;
                                            }
                                            i_143_ = 472 - ((this.gs).sgame.getWidth() + 6 + (this.gs).mstgs.getWidth()) / 2;
                                        } else
                                            this.sgflag = false;
                                        if (!(this.gs).sgame.isShowing()) {
                                            (this.gs).sgame.show();
                                            this.remstage = 0;
                                            if (this.loadstage == 0) {
                                                int i_144_ = (int) (Math.random() * 3.0);
                                                if (i_144_ == 3)
                                                    i_144_ = 2;
                                                (this.gs).sgame.select(i_144_);
                                            }
                                        }
                                        (this.gs).sgame.move(i_143_, 105);
                                        i_143_ += (this.gs).sgame.getWidth() + 6;
                                        if ((this.gs).sgame.getSelectedIndex() == 0) {
                                            if (!(this.gs).snfmm.isShowing()) {
                                                (this.gs).snfmm.show();
                                                if (this.loadstage == 0)
                                                    (this.gs).snfmm.select(0);
                                            }
                                            (this.gs).snfmm.move(i_143_, 105);
                                            if ((this.gs).snfm1.isShowing())
                                                (this.gs).snfm1.hide();
                                            if ((this.gs).snfm2.isShowing())
                                                (this.gs).snfm2.hide();
                                            if ((this.gs).mstgs.isShowing())
                                                (this.gs).mstgs.hide();
                                        }
                                        if ((this.gs).sgame.getSelectedIndex() == 0 && (this.gs).snfmm.getSelectedIndex() != 0 && this.gstage != (this.gs).snfmm.getSelectedIndex() + 27) {
                                            this.loadstage = (this.gs).snfmm.getSelectedIndex() + 27;
                                            this.gstage = this.loadstage;
                                            this.gs.requestFocus();
                                        }
                                        if ((this.gs).sgame.getSelectedIndex() == 1) {
                                            if (!(this.gs).snfm2.isShowing()) {
                                                (this.gs).snfm2.show();
                                                if (this.loadstage == 0)
                                                    (this.gs).snfm2.select(0);
                                            }
                                            (this.gs).snfm2.move(i_143_, 105);
                                            if ((this.gs).snfmm.isShowing())
                                                (this.gs).snfmm.hide();
                                            if ((this.gs).snfm1.isShowing())
                                                (this.gs).snfm1.hide();
                                            if ((this.gs).mstgs.isShowing())
                                                (this.gs).mstgs.hide();
                                        }
                                        if ((this.gs).sgame.getSelectedIndex() == 1 && (this.gs).snfm2.getSelectedIndex() != 0 && this.gstage != (this.gs).snfm2.getSelectedIndex() + 10) {
                                            this.loadstage = (this.gs).snfm2.getSelectedIndex() + 10;
                                            this.gstage = this.loadstage;
                                            this.gs.requestFocus();
                                        }
                                        if ((this.gs).sgame.getSelectedIndex() == 2) {
                                            if (!(this.gs).snfm1.isShowing()) {
                                                (this.gs).snfm1.show();
                                                if (this.loadstage == 0)
                                                    (this.gs).snfm1.select(0);
                                            }
                                            (this.gs).snfm1.move(i_143_, 105);
                                            if ((this.gs).snfmm.isShowing())
                                                (this.gs).snfmm.hide();
                                            if ((this.gs).snfm2.isShowing())
                                                (this.gs).snfm2.hide();
                                            if ((this.gs).mstgs.isShowing())
                                                (this.gs).mstgs.hide();
                                        }
                                        if ((this.gs).sgame.getSelectedIndex() == 2 && (this.gs).snfm1.getSelectedIndex() != 0 && this.gstage != (this.gs).snfm1.getSelectedIndex()) {
                                            this.loadstage = (this.gs).snfm1.getSelectedIndex();
                                            this.gstage = this.loadstage;
                                            this.gs.requestFocus();
                                        }
                                        if ((this.gs).sgame.getSelectedIndex() == 3) {
                                            if (!(this.gs).mstgs.isShowing()) {
                                                (this.gs).mstgs.show();
                                                if (this.loadstage == 0)
                                                    (this.gs).mstgs.select(0);
                                            }
                                            (this.gs).mstgs.move(i_143_, 105);
                                            if ((this.gs).snfmm.isShowing())
                                                (this.gs).snfmm.hide();
                                            if ((this.gs).snfm1.isShowing())
                                                (this.gs).snfm1.hide();
                                            if ((this.gs).snfm2.isShowing())
                                                (this.gs).snfm2.hide();
                                        }
                                        if (this.remstage != 2) {
                                            if ((this.gs).sgame.getSelectedIndex() == 3 && (this.gs).mstgs.getSelectedIndex() != 0) {
                                                if (this.gstage != (this.gs).mstgs.getSelectedIndex() + 100) {
                                                    this.loadstage = (this.gs).mstgs.getSelectedIndex() + 100;
                                                    this.gstage = this.loadstage;
                                                    this.gs.requestFocus();
                                                    this.remstage = 0;
                                                }
                                                if (this.loadstage <= 0 && this.remstage == 0 && this.xt.drawcarb(true, null, "X", 674, 136, i, i_87_, bool))
                                                    this.remstage = 1;
                                            } else if (this.remstage != 0)
                                                this.remstage = 0;
                                        }
                                        if (this.loadstage > 0 && this.remstage == 0) {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString("Loading stage, please wait...", 472 - this.ftm.stringWidth("Loading Stage, please wait...") / 2, 165);
                                        }
                                        if ((this.gs).sgame.getSelectedIndex() == 3 && !(this.xt).logged) {
                                            stringbutton("   Upgrade Account   ", 472, 176, 1);
                                            if ((this.gs).slaps.isShowing())
                                                (this.gs).slaps.hide();
                                        } else {
                                            if (this.loadstage < 0 && this.remstage == 0) {
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString(new StringBuilder().append("").append(this.gstagename).append("  -  Laps:              ").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("").append(this.gstagename).append("  -  Laps:              ").toString()) / 2, 155);
                                                if (!(this.gs).slaps.isShowing()) {
                                                    (this.gs).slaps.show();
                                                    (this.gs).slaps.select(this.gstagelaps - 1);
                                                }
                                                (this.gs).slaps.move(472 + this.ftm.stringWidth(new StringBuilder().append("").append(this.gstagename).append("  -  Laps:              ").toString()) / 2 - 35, 138);
                                                if ((this.gs).slaps.getSelectedIndex() != this.gstagelaps - 1) {
                                                    this.gstagelaps = (this.gs).slaps.getSelectedIndex() + 1;
                                                    this.gs.requestFocus();
                                                }
                                                stringbutton("    Preview Stage    ", 472, 185, 2);
                                            } else if ((this.gs).slaps.isShowing())
                                                (this.gs).slaps.hide();
                                            if (this.remstage == 3) {
                                                if (this.loadstage < 0)
                                                    stringbutton("    Preview Stage    ", 472, -160, 2);
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 13));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.xt.drawlprom(135, 75);
                                                this.rd.drawString("Failed to remove stage, server error, please try again later.", 472 - this.ftm.stringWidth("Failed to remove stage, server error, please try again later.") / 2, 155);
                                                if (this.xt.drawcarb(true, null, " OK ", 451, 175, i, i_87_, bool)) {
                                                    this.remstage = 0;
                                                    (this.gs).mouses = 0;
                                                }
                                            }
                                            if (this.remstage == 2) {
                                                if (this.loadstage < 0)
                                                    stringbutton("    Preview Stage    ", 472, -160, 2);
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 13));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.xt.drawlprom(135, 75);
                                                this.rd.drawString("Removing stage from your account...", 472 - this.ftm.stringWidth("Removing stage from your account...") / 2, 175);
                                                if ((this.cd).staction == 0) {
                                                    this.gstage = 0;
                                                    this.loadstage = 0;
                                                    this.remstage = 0;
                                                }
                                                if ((this.cd).staction <= -1) {
                                                    this.remstage = 3;
                                                    (this.gs).mouses = 0;
                                                }
                                            }
                                            if (this.remstage == 1) {
                                                if (this.loadstage < 0)
                                                    stringbutton("    Preview Stage    ", 472, -160, 2);
                                                this.xt.drawlprom(135, 75);
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.setFont(new Font("Arial", 1, 13));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.drawString("Remove this stage from your account?", 472 - this.ftm.stringWidth("Remove this stage from your account?") / 2, 155);
                                                if (this.xt.drawcarb(true, null, " Yes ", 426, 175, i, i_87_, bool)) {
                                                    this.remstage = 2;
                                                    (this.cd).onstage = (this.gs).mstgs.getSelectedItem();
                                                    (this.cd).staction = 1;
                                                    this.cd.sparkstageaction();
                                                    (this.gs).mouses = 0;
                                                }
                                                if (this.xt.drawcarb(true, null, " No ", 480, 175, i, i_87_, bool)) {
                                                    this.remstage = 0;
                                                    (this.gs).mouses = 0;
                                                }
                                            }
                                            stringbutton("   Next >   ", 472, 235, 1);
                                        }
                                    }
                                    if (this.chalngd == -3) {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (this.sflk % 4 != 0 || this.sflk == 0)
                                            this.rd.drawString("Select Number of Players", 472 - this.ftm.stringWidth("Select Number of Players") / 2, 85);
                                        if (this.sflk != 0)
                                            this.sflk--;
                                        int i_145_ = 0;
                                        if ((this.xt).lan)
                                            i_145_ = 59;
                                        this.rd.drawString("Players", 413 - i_145_, 122);
                                        if (!(this.gs).snpls.isShowing()) {
                                            (this.gs).snpls.show();
                                            (this.gs).snpls.select(this.gnpls - 1);
                                        }
                                        (this.gs).snpls.move(467 - i_145_, 105);
                                        boolean bool_146_ = false;
                                        if ((this.gs).snpls.getSelectedIndex() != 0 && (this.gs).snpls.getSelectedIndex() != this.gnpls - 1) {
                                            this.gnpls = (this.gs).snpls.getSelectedIndex() + 1;
                                            bool_146_ = true;
                                            (this.gs).swait.hide();
                                        }
                                        if ((this.xt).lan) {
                                            this.rd.drawString("Bots", 490, 122);
                                            if (!(this.gs).snbts.isShowing()) {
                                                (this.gs).snbts.show();
                                                (this.gs).snbts.select(0);
                                                this.gnbts = 0;
                                            }
                                            (this.gs).snbts.move(524, 105);
                                            if ((this.gs).snbts.getSelectedIndex() != this.gnbts || bool_146_) {
                                                for (this.gnbts = (this.gs).snbts.getSelectedIndex(); this.gnbts + this.gnpls > 7; this.gnbts--) {
                                                    /* empty */
                                                }
                                                (this.gs).snbts.select(this.gnbts);
                                            }
                                        }
                                        this.rd.drawString("Wait", 414, 162);
                                        if (!(this.gs).swait.isShowing()) {
                                            (this.gs).swait.show();
                                            if (this.gwait == 0)
                                                (this.gs).swait.select(1);
                                        }
                                        (this.gs).swait.move(451, 145);
                                        if (((this.gs).swait.getSelectedIndex() + 1) * 60 != this.gwait)
                                            this.gwait = ((this.gs).swait.getSelectedIndex() + 1) * 60;
                                        this.rd.setColor(color2k(90, 90, 90));
                                        this.rd.setFont(new Font("Arial", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("(Maximum time to wait for all players to join. )", 472 - this.ftm.stringWidth("(Maximum time to wait for all players to join. )") / 2, 179);
                                        stringbutton("   < Back   ", 422, 235, 1);
                                        stringbutton("   Next >   ", 522, 235, 1);
                                    }
                                    if (this.chalngd == -4) {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (this.sflk % 4 != 0 || this.sflk == 0)
                                            this.rd.drawString("Game Options", 472 - this.ftm.stringWidth("Game Options") / 2, 85);
                                        if (this.sflk != 0)
                                            this.sflk--;
                                        int i_147_ = 472 - ((this.gs).scars.getWidth() + (this.gs).sclass.getWidth() + (this.gs).sfix.getWidth() + 16) / 2;
                                        if (!(this.gs).scars.isShowing()) {
                                            (this.gs).scars.show();
                                            if (this.gcars >= 0 && this.gcars <= 2)
                                                (this.gs).scars.select(this.gcars);
                                            else
                                                (this.gs).scars.select(0);
                                        }
                                        (this.gs).scars.move(i_147_, 105);
                                        i_147_ += (this.gs).scars.getWidth() + 8;
                                        if (!(this.gs).sclass.isShowing()) {
                                            (this.gs).sclass.show();
                                            if (this.gclass >= 0 && this.gclass <= 5)
                                                (this.gs).sclass.select(this.gclass);
                                            else
                                                (this.gs).sclass.select(0);
                                        }
                                        (this.gs).sclass.move(i_147_, 105);
                                        i_147_ += (this.gs).sclass.getWidth() + 8;
                                        if (!(this.gs).sfix.isShowing()) {
                                            (this.gs).sfix.show();
                                            if (this.gfix >= 0 && this.gfix <= 5)
                                                (this.gs).sfix.select(this.gfix);
                                            else
                                                (this.gs).sfix.select(0);
                                        }
                                        (this.gs).sfix.move(i_147_, 105);
                                        i_147_ += (this.gs).sfix.getWidth();
                                        if (!(this.gs).openm)
                                            this.gs.movefield((this.gs).notp, i_147_ - 112, 131, 150, 17);
                                        else
                                            this.gs.movefield((this.gs).notp, i_147_ - 112, -2000, 150, 17);
                                        if (!(this.gs).notp.isShowing()) {
                                            (this.gs).notp.show();
                                            if (this.gnotp == 0)
                                                (this.gs).notp.setState(false);
                                            else
                                                (this.gs).notp.setState(true);
                                        }
                                        if ((this.xt).sc[0] < 16) {
                                            if (!(this.gs).openm)
                                                this.gs.movefield((this.gs).mycar, 472 - ((this.gs).scars.getWidth() + (this.gs).sclass.getWidth() + (this.gs).sfix.getWidth() + 16) / 2, 131, 150, 17);
                                            else
                                                this.gs.movefield((this.gs).mycar, 410, -2000, 150, 17);
                                            if (!(this.gs).mycar.isShowing()) {
                                                (this.gs).mycar.show();
                                                (this.gs).mycar.setLabel(new StringBuilder().append("").append((this.cd).names[(this.xt).sc[0]]).append(" Game!").toString());
                                                if (this.gclass <= -2)
                                                    (this.gs).mycar.setState(true);
                                                else
                                                    (this.gs).mycar.setState(false);
                                            }
                                        } else if ((this.gs).mycar.getState())
                                            (this.gs).mycar.setState(false);
                                        if ((this.gs).mycar.getState()) {
                                            if ((this.gs).sclass.isEnabled())
                                                (this.gs).sclass.disable();
                                            if ((this.gs).scars.isEnabled())
                                                (this.gs).scars.disable();
                                        } else {
                                            if (!(this.gs).sclass.isEnabled())
                                                (this.gs).sclass.enable();
                                            if (!(this.gs).scars.isEnabled())
                                                (this.gs).scars.enable();
                                            if ((this.gs).sclass.getSelectedIndex() != this.gclass) {
                                                this.gclass = (this.gs).sclass.getSelectedIndex();
                                                (this.gs).mycar.hide();
                                            }
                                            if ((this.gs).scars.getSelectedIndex() != this.gcars)
                                                this.gcars = (this.gs).scars.getSelectedIndex();
                                        }
                                        if ((this.gs).sfix.getSelectedIndex() != this.gfix)
                                            this.gfix = (this.gs).sfix.getSelectedIndex();
                                        String string = "Public Game, anyone can join...";
                                        int i_148_ = 0;
                                        for (int i_149_ = 0; i_149_ < 7; i_149_++) {
                                            if (!this.invos[i_149_].equals(""))
                                                i_148_++;
                                        }
                                        if (i_148_ > 0) {
                                            string = "Players Allowed:  ";
                                            int i_150_ = 0;
                                            for (int i_151_ = 0; i_151_ < 7; i_151_++) {
                                                if (!this.invos[i_151_].equals("")) {
                                                    string = new StringBuilder().append(string).append(this.invos[i_151_]).toString();
                                                    if (++i_150_ != i_148_) {
                                                        if (i_150_ == i_148_ - 1)
                                                            string = new StringBuilder().append(string).append(" and ").toString();
                                                        else
                                                            string = new StringBuilder().append(string).append(", ").toString();
                                                    }
                                                }
                                            }
                                        }
                                        this.rd.setColor(new Color(0, 0, 0));
                                        if (i_148_ < this.gnpls - 1) {
                                            this.rd.setFont(new Font("Arial", 1, 13));
                                            this.rd.drawString(new StringBuilder().append("Private Game, only specific players allowed to join?  ").append(i_148_).append("/").append(this.gnpls - 1).append("").toString(), 330, 180);
                                            stringbutton("<   Select   ", 281, 180, 2);
                                            this.rd.setFont(new Font("Tahoma", 0, 11));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString(string, 472 - this.ftm.stringWidth(string) / 2, 203);
                                        } else {
                                            this.rd.setFont(new Font("Arial", 1, 13));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString(new StringBuilder().append("").append(i_148_).append(" Allowed Players Selected").toString(), 472 - this.ftm.stringWidth(new StringBuilder().append("").append(i_148_).append(" Allowed Players Selected").toString()) / 2, 180);
                                            this.rd.setFont(new Font("Tahoma", 0, 11));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString(string, 472 - this.ftm.stringWidth(string) / 2, 203);
                                        }
                                        stringbutton("   < Back   ", 422, 235, 1);
                                        stringbutton("   Finish!   ", 522, 235, 1);
                                    }
                                    if (this.chalngd == -5) {
                                        if (this.fstart)
                                            this.fstart = false;
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 145);
                                        if (this.msg.equals(". . . | Creating Game | . . .") && this.ncnt == 0) {
                                            this.msg = "| Creating Game |";
                                            this.ncnt = 5;
                                        }
                                        if (this.msg.equals(". . | Creating Game | . .") && this.ncnt == 0) {
                                            this.msg = ". . . | Creating Game | . . .";
                                            this.ncnt = 5;
                                        }
                                        if (this.msg.equals(". | Creating Game | .") && this.ncnt == 0) {
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
                                this.rd.setColor(color2k(230, 230, 230));
                                this.rd.fillRoundRect(225, 263, 495, 157, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(225, 263, 495, 157, 20, 20);
                                String[] strings = new String[14];
                                String[] strings_152_ = new String[14];
                                boolean[] bools = new boolean[14];
                                for (int i_153_ = 0; i_153_ < 14; i_153_++) {
                                    strings[i_153_] = "";
                                    strings_152_[i_153_] = "";
                                    bools[i_153_] = false;
                                }
                                int i_154_ = 0;
                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.updatec != -1) {
                                    for (int i_155_ = 0; i_155_ < 7; i_155_++) {
                                        strings[i_154_] = "";
                                        strings_152_[i_154_] = this.cnames[i_155_];
                                        int i_156_ = 0;
                                        int i_157_ = 0;
                                        int i_158_ = 0;
                                        int i_159_ = 0;
                                        int i_160_ = 0;
                                        for (/**/; i_156_ < this.sentn[i_155_].length(); i_156_++) {
                                            String string = new StringBuilder().append("").append(this.sentn[i_155_].charAt(i_156_)).toString();
                                            if (string.equals(" ")) {
                                                i_157_ = i_158_;
                                                i_159_ = i_156_;
                                                i_160_++;
                                            } else
                                                i_160_ = 0;
                                            if (i_160_ <= 1) {
                                                StringBuilder stringbuilder = new StringBuilder();
                                                String[] strings_161_ = strings;
                                                int i_162_ = i_154_;
                                                strings_161_[i_162_] = stringbuilder.append(strings_161_[i_162_]).append(string).toString();
                                                i_158_++;
                                                if (this.ftm.stringWidth(strings[i_154_]) > 367) {
                                                    if (i_157_ != 0) {
                                                        strings[i_154_] = strings[i_154_].substring(0, i_157_);
                                                        if (i_154_ == 13) {
                                                            for (int i_163_ = 0; i_163_ < 13; i_163_++) {
                                                                strings[i_163_] = strings[i_163_ + 1];
                                                                strings_152_[i_163_] = strings_152_[i_163_ + 1];
                                                                bools[i_163_] = bools[i_163_ + 1];
                                                            }
                                                            strings[i_154_] = "";
                                                            bools[i_154_] = true;
                                                        } else {
                                                            i_154_++;
                                                            strings_152_[i_154_] = this.cnames[i_155_];
                                                        }
                                                        i_156_ = i_159_;
                                                        i_158_ = 0;
                                                        i_157_ = 0;
                                                    } else {
                                                        strings[i_154_] = "";
                                                        i_158_ = 0;
                                                    }
                                                }
                                            }
                                        }
                                        if (i_154_ == 13 && i_155_ != 6) {
                                            for (int i_164_ = 0; i_164_ < 13; i_164_++) {
                                                strings[i_164_] = strings[i_164_ + 1];
                                                strings_152_[i_164_] = strings_152_[i_164_ + 1];
                                                bools[i_164_] = bools[i_164_ + 1];
                                            }
                                        } else
                                            i_154_++;
                                    }
                                    i_92_ = (i_154_ - 6) * 15;
                                    if (i_92_ < 0)
                                        i_92_ = 0;
                                    i_93_ = (int) ((float) this.spos3 / 28.0F * (float) i_92_);
                                    String string = "";
                                    this.rd.setFont(new Font("Tahoma", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    for (int i_165_ = 0; i_165_ < i_154_; i_165_++) {
                                        if (!string.equals(strings_152_[i_165_])) {
                                            if (280 + i_165_ * 15 - i_93_ > 266 && 280 + i_165_ * 15 - i_93_ < 370)
                                                this.rd.drawString(new StringBuilder().append(strings_152_[i_165_]).append(":").toString(), 320 - this.ftm.stringWidth(new StringBuilder().append(strings_152_[i_165_]).append(":").toString()), 305 + i_165_ * 15 - i_93_);
                                            string = strings_152_[i_165_];
                                        }
                                    }
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    for (int i_166_ = 0; i_166_ < i_154_; i_166_++) {
                                        if (bools[i_166_] && i_166_ == 0 && strings[i_166_].indexOf(" ") != -1)
                                            strings[i_166_] = new StringBuilder().append("...").append(strings[i_166_].substring(strings[i_166_].indexOf(" "), strings[i_166_].length())).append("").toString();
                                        if (280 + i_166_ * 15 - i_93_ > 266 && 280 + i_166_ * 15 - i_93_ < 370)
                                            this.rd.drawString(strings[i_166_], 325, 305 + i_166_ * 15 - i_93_);
                                    }
                                } else {
                                    i_92_ = 0;
                                    boolean bool_167_ = false;
                                    this.rd.drawString("Loading chat...", 465 - this.ftm.stringWidth("Loading chat...") / 2, 325);
                                }
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(235, 269, 480, 25);
                                this.rd.drawImage((this.xt).chat, 241, 273, null);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.rd.setColor(color2k(120, 120, 120));
                                this.rd.drawString("(Room Chat )", 299, 285);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(235, 291, 696, 291);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(235, 387, 480, 28);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(235, 389, 696, 389);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(698, 311, 17, 59);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(231, 269, 4, 146);
                                if (this.mscro3 == 351 || i_92_ == 0) {
                                    if (i_92_ == 0)
                                        this.rd.setColor(color2k(205, 205, 205));
                                    else
                                        this.rd.setColor(color2k(215, 215, 215));
                                    this.rd.fillRect(698, 294, 17, 17);
                                } else {
                                    this.rd.setColor(color2k(220, 220, 220));
                                    this.rd.fill3DRect(698, 294, 17, 17, true);
                                }
                                if (i_92_ != 0)
                                    this.rd.drawImage((this.xt).asu, 703, 300, null);
                                if (this.mscro3 == 352 || i_92_ == 0) {
                                    if (i_92_ == 0)
                                        this.rd.setColor(color2k(205, 205, 205));
                                    else
                                        this.rd.setColor(color2k(215, 215, 215));
                                    this.rd.fillRect(698, 370, 17, 17);
                                } else {
                                    this.rd.setColor(color2k(220, 220, 220));
                                    this.rd.fill3DRect(698, 370, 17, 17, true);
                                }
                                if (i_92_ != 0)
                                    this.rd.drawImage((this.xt).asd, 703, 376, null);
                                if (i_92_ != 0) {
                                    if (this.lspos3 != this.spos3) {
                                        this.rd.setColor(color2k(215, 215, 215));
                                        this.rd.fillRect(698, 311 + this.spos3, 17, 31);
                                    } else {
                                        if (this.mscro3 == 141)
                                            this.rd.setColor(color2k(215, 215, 215));
                                        this.rd.fill3DRect(698, 311 + this.spos3, 17, 31, true);
                                    }
                                    this.rd.setColor(color2k(150, 150, 150));
                                    this.rd.drawLine(703, 324 + this.spos3, 709, 324 + this.spos3);
                                    this.rd.drawLine(703, 326 + this.spos3, 709, 326 + this.spos3);
                                    this.rd.drawLine(703, 328 + this.spos3, 709, 328 + this.spos3);
                                    if (this.mscro3 > 342 && this.lspos3 != this.spos3)
                                        this.lspos3 = this.spos3;
                                    if (bool) {
                                        if (this.mscro3 == 345 && i > 698 && i < 715 && i_87_ > 311 + this.spos3 && i_87_ < this.spos3 + 342)
                                            this.mscro3 = i_87_ - this.spos3;
                                        if (this.mscro3 == 345 && i > 696 && i < 717 && i_87_ > 292 && i_87_ < 313)
                                            this.mscro3 = 351;
                                        if (this.mscro3 == 345 && i > 696 && i < 717 && i_87_ > 368 && i_87_ < 389)
                                            this.mscro3 = 352;
                                        if (this.mscro3 == 345 && i > 698 && i < 715 && i_87_ > 311 && i_87_ < 370) {
                                            this.mscro3 = 326;
                                            this.spos3 = i_87_ - this.mscro3;
                                        }
                                        int i_168_ = 100 / i_92_;
                                        if (i_168_ < 1)
                                            i_168_ = 1;
                                        if (this.mscro3 == 351) {
                                            this.spos3 -= i_168_;
                                            if (this.spos3 > 28)
                                                this.spos3 = 28;
                                            if (this.spos3 < 0)
                                                this.spos3 = 0;
                                            this.lspos3 = this.spos3;
                                        }
                                        if (this.mscro3 == 352) {
                                            this.spos3 += i_168_;
                                            if (this.spos3 > 28)
                                                this.spos3 = 28;
                                            if (this.spos3 < 0)
                                                this.spos3 = 0;
                                            this.lspos3 = this.spos3;
                                        }
                                        if (this.mscro3 <= 342) {
                                            this.spos3 = i_87_ - this.mscro3;
                                            if (this.spos3 > 28)
                                                this.spos3 = 28;
                                            if (this.spos3 < 0)
                                                this.spos3 = 0;
                                        }
                                        if (this.mscro3 == 345)
                                            this.mscro3 = 425;
                                    } else if (this.mscro3 != 345)
                                        this.mscro3 = 345;
                                    if (i_88_ != 0 && i > 235 && i < 698 && i_87_ > 291 && i_87_ < 389) {
                                        this.spos3 -= i_88_ / 2;
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
                        }
                    } else if (this.opengame < 26) {
                        int i_169_ = 229 + this.opengame;
                        if (i_169_ > 255)
                            i_169_ = 255;
                        if (i_169_ < 0)
                            i_169_ = 0;
                        this.rd.setColor(color2k(i_169_, i_169_, i_169_));
                        this.rd.fillRoundRect(225, 59 - this.opengame, 495, 200 + this.opengame * 7, 20, 20);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRoundRect(225, 59 - this.opengame, 495, 200 + this.opengame * 7, 20, 20);
                        if (!(this.xt).lan) {
                            this.rd.setColor(color2k(217, 217, 217));
                            this.rd.fillRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(225, 263 + this.opengame * 7, 495, 157, 20, 20);
                        }
                        this.btn = 0;
                        if (this.prevloaded != -1)
                            this.prevloaded = -1;
                        if (this.updatec != -1)
                            this.updatec = -1;
                        if ((this.gs).cmsg.getText().equals(""))
                            (this.gs).cmsg.setText("Type here...");
                        if ((this.gs).cmsg.isShowing()) {
                            (this.gs).cmsg.hide();
                            this.gs.requestFocus();
                        }
                        if ((this.gs).rooms.isShowing())
                            (this.gs).rooms.hide();
                        if (this.fstart)
                            this.fstart = false;
                        for (int i_170_ = 0; i_170_ < 9; i_170_++) {
                            if (this.cac[i_170_] != -1)
                                this.cac[i_170_] = -1;
                        }
                        if (this.dispcar != -1)
                            this.dispcar = -1;
                        this.opengame += 2;
                    } else {
                        this.rd.setColor(color2k(255, 255, 255));
                        this.rd.fillRoundRect(225, 33, 495, 385, 20, 20);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRoundRect(225, 33, 495, 385, 20, 20);
                        if (this.join > -1 && this.pgames[this.im] != this.join || this.join == -2) {
                            if (this.join > -1 && this.pgames[this.im] != this.join) {
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 195);
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
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(this.msg, 472 - this.ftm.stringWidth(this.msg) / 2, 195);
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
                            int i_171_ = 0;
                            for (int i_172_ = 0; i_172_ < this.ngm; i_172_++) {
                                if (this.ongame == this.gnum[i_172_])
                                    i_171_ = i_172_;
                            }
                            this.rd.setFont(new Font("Arial", 1, 11));
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.conon == 1) {
                                if (this.wait[i_171_] > 0) {
                                    String string = "";
                                    if (this.gplyrs[i_171_].equals(""))
                                        string = "Public Game";
                                    else
                                        string = "Private Game";
                                    if (this.gfx[i_171_] == 1)
                                        string = new StringBuilder().append(string).append(", 4 Fixes").toString();
                                    if (this.gfx[i_171_] == 2)
                                        string = new StringBuilder().append(string).append(", 3 Fixes").toString();
                                    if (this.gfx[i_171_] == 3)
                                        string = new StringBuilder().append(string).append(", 2 Fixes").toString();
                                    if (this.gfx[i_171_] == 4)
                                        string = new StringBuilder().append(string).append(", 1 Fix").toString();
                                    if (this.gfx[i_171_] == 5)
                                        string = new StringBuilder().append(string).append(", No Fixing").toString();
                                    String string_173_ = "";
                                    if (this.gclss[i_171_] > -2) {
                                        if (this.gcrs[i_171_] == 1)
                                            string_173_ = "Custom Cars";
                                        if (this.gcrs[i_171_] == 2)
                                            string_173_ = "Game Cars";
                                        String string_174_ = "";
                                        if (this.gclss[i_171_] == 1)
                                            string_174_ = "Class C";
                                        if (this.gclss[i_171_] == 2)
                                            string_174_ = "Class B & C";
                                        if (this.gclss[i_171_] == 3)
                                            string_174_ = "Class B";
                                        if (this.gclss[i_171_] == 4)
                                            string_174_ = "Class A & B";
                                        if (this.gclss[i_171_] == 5)
                                            string_174_ = "Class A";
                                        if (!string_173_.equals("") && !string_174_.equals(""))
                                            string_173_ = new StringBuilder().append(string_173_).append(", ").append(string_174_).toString();
                                        else
                                            string_173_ = new StringBuilder().append(string_173_).append(string_174_).toString();
                                    } else
                                        string_173_ = new StringBuilder().append("").append((this.cd).names[Math.abs(this.gclss[i_171_] + 2)]).append("").toString();
                                    if (string_173_.equals("")) {
                                        this.rd.drawString("Type:", 243, 55);
                                        this.rd.setColor(new Color(80, 128, 0));
                                        this.rd.drawString(string, 279, 55);
                                    } else {
                                        this.rd.drawString("Type:", 243, 48);
                                        this.rd.drawString("Cars:", 244, 60);
                                        this.rd.setColor(new Color(80, 128, 0));
                                        this.rd.drawString(string, 279, 48);
                                        this.rd.drawString(string_173_, 279, 60);
                                    }
                                }
                                if (this.wait[i_171_] == 0) {
                                    this.rd.drawString("Status:", 241, 55);
                                    this.rd.setColor(new Color(128, 73, 0));
                                    if (this.prevloaded == 0)
                                        this.rd.drawString("Starting...", 286, 55);
                                    else
                                        this.rd.drawString("Started", 286, 55);
                                }
                                if (this.wait[i_171_] <= -1) {
                                    this.rd.drawString("Status:", 241, 55);
                                    this.rd.setColor(color2k(100, 100, 100));
                                    this.rd.drawString("Finished", 286, 55);
                                }
                            } else {
                                this.rd.drawString("Status:", 241, 55);
                                this.rd.setColor(new Color(128, 73, 0));
                                this.rd.drawString("Starting...", 286, 55);
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.gmaker[i_171_].equals(this.pnames[this.im]))
                                this.rd.drawString("Created by You", 449, 55);
                            else {
                                this.rd.drawString("Created by", 449, 55);
                                this.rd.drawString(":", 511, 55);
                                this.rd.drawString(this.gmaker[i_171_], 520, 55);
                            }
                            this.rd.setColor(color2k(200, 200, 200));
                            this.rd.drawLine(233, 64, 602, 64);
                            this.rd.drawLine(602, 39, 602, 64);
                            if (this.conon == 1) {
                                if (this.pgames[this.im] == this.ongame)
                                    stringbutton("Leave Game X", 660, 58, 0);
                                else
                                    stringbutton("Close X", 679, 58, 0);
                            }
                            this.rd.drawImage((this.xt).pls, 292, 81, null);
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
                            int i_175_ = 0;
                            int i_176_ = -1;
                            for (int i_177_ = 0; i_177_ < this.npo; i_177_++) {
                                if (this.pgames[i_177_] == this.ongame) {
                                    this.rd.setColor(color2k(240, 240, 240));
                                    if (i_177_ == this.im && this.wait[i_171_] != -1) {
                                        if (this.nflk == 0 || this.conon == 2) {
                                            this.rd.setColor(color2k(255, 255, 255));
                                            this.nflk = 3;
                                        } else
                                            this.nflk--;
                                    }
                                    this.rd.fillRect(237, 96 + i_175_ * 42, 170, 40);
                                    this.rd.setColor(color2k(200, 200, 200));
                                    if (this.wait[i_171_] <= -1 && this.prevloaded == 1) {
                                        for (int i_178_ = 0; i_178_ < this.prnpo; i_178_++) {
                                            if (this.pnames[i_177_].equals(this.prnames[i_178_]) && this.ppos[i_178_] == 0 && this.nflk == 0)
                                                this.rd.setColor(new Color(0, 0, 0));
                                        }
                                    }
                                    this.rd.drawRect(237, 96 + i_175_ * 42, 170, 40);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(this.pnames[i_177_], 282 - this.ftm.stringWidth(this.pnames[i_177_]) / 2, 114 + i_175_ * 42);
                                    this.rd.setFont(new Font("Arial", 0, 10));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(this.pcarnames[i_177_], 282 - this.ftm.stringWidth(this.pcarnames[i_177_]) / 2, 126 + i_175_ * 42);
                                    (this.m).crs = true;
                                    (this.m).x = -335;
                                    (this.m).y = 0;
                                    (this.m).z = -50;
                                    (this.m).xz = 0;
                                    (this.m).zy = 20;
                                    (this.m).ground = -2000;
                                    if (this.pcars[i_177_] != -1) {
                                        for (int i_179_ = 0; i_179_ < (contos[this.pcars[i_177_]]).npl; i_179_++) {
                                            ((contos[this.pcars[i_177_]]).p[i_179_]).flx = 0;
                                            if (((contos[this.pcars[i_177_]]).p[i_179_]).colnum == 1) {
                                                ((contos[this.pcars[i_177_]]).p[i_179_]).hsb[0] = this.pcols[i_177_][0];
                                                ((contos[this.pcars[i_177_]]).p[i_179_]).hsb[1] = this.pcols[i_177_][1];
                                                ((contos[this.pcars[i_177_]]).p[i_179_]).hsb[2] = 1.0F - this.pcols[i_177_][2];
                                            }
                                            if (((contos[this.pcars[i_177_]]).p[i_179_]).colnum == 2) {
                                                ((contos[this.pcars[i_177_]]).p[i_179_]).hsb[0] = this.pcols[i_177_][3];
                                                ((contos[this.pcars[i_177_]]).p[i_179_]).hsb[1] = this.pcols[i_177_][4];
                                                ((contos[this.pcars[i_177_]]).p[i_179_]).hsb[2] = 1.0F - this.pcols[i_177_][5];
                                            }
                                        }
                                        if (this.cac[i_175_] != this.pcars[i_177_]) {
                                            int i_180_ = ((contos[this.pcars[i_177_]]).p[0]).oz[0];
                                            int i_181_ = i_180_;
                                            int i_182_ = ((contos[this.pcars[i_177_]]).p[0]).oy[0];
                                            int i_183_ = i_182_;
                                            for (int i_184_ = 0; i_184_ < (contos[this.pcars[i_177_]]).npl; i_184_++) {
                                                for (int i_185_ = 0; i_185_ < ((contos[this.pcars[i_177_]]).p[i_184_]).n; i_185_++) {
                                                    if (((contos[this.pcars[i_177_]]).p[i_184_]).oz[i_185_] < i_180_)
                                                        i_180_ = ((contos[this.pcars[i_177_]]).p[i_184_]).oz[i_185_];
                                                    if (((contos[this.pcars[i_177_]]).p[i_184_]).oz[i_185_] > i_181_)
                                                        i_181_ = ((contos[this.pcars[i_177_]]).p[i_184_]).oz[i_185_];
                                                    if (((contos[this.pcars[i_177_]]).p[i_184_]).oy[i_185_] < i_182_)
                                                        i_182_ = ((contos[this.pcars[i_177_]]).p[i_184_]).oy[i_185_];
                                                    if (((contos[this.pcars[i_177_]]).p[i_184_]).oy[i_185_] > i_183_)
                                                        i_183_ = ((contos[this.pcars[i_177_]]).p[i_184_]).oy[i_185_];
                                                }
                                            }
                                            this.cax[i_175_] = (i_181_ + i_180_) / 2;
                                            this.cay[i_175_] = (i_183_ + i_182_) / 2;
                                            this.cac[i_175_] = this.pcars[i_177_];
                                        }
                                        if (i > 327 && i < 402 && i_87_ > 99 + i_175_ * 42 && i_87_ < 133 + i_175_ * 42) {
                                            i_89_ = 12;
                                            i_176_ = i_177_;
                                            for (int i_186_ = 0; i_186_ < (contos[this.pcars[i_177_]]).npl; i_186_++)
                                                ((contos[this.pcars[i_177_]]).p[i_186_]).flx = 77;
                                        }
                                        (contos[this.pcars[i_177_]]).z = 2500 - i_175_ * 80;
                                        (contos[this.pcars[i_177_]]).y = 400 + 250 * i_175_ - this.cay[i_175_];
                                        (contos[this.pcars[i_177_]]).x = -145 - this.cax[i_175_];
                                        (contos[this.pcars[i_177_]]).zy = 0;
                                        (contos[this.pcars[i_177_]]).xz = -90;
                                        (contos[this.pcars[i_177_]]).xy = this.pend - i_175_ * 5;
                                        contos[this.pcars[i_177_]].d(this.rd);
                                    } else {
                                        this.rd.setFont(new Font("Arial", 1, 11));
                                        this.rd.setColor(color2k(80, 80, 80));
                                        this.rd.drawString("Loading...", 339, 119 + i_175_ * 42);
                                    }
                                    i_175_++;
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
                            if (i_176_ != -1) {
                                if (bool)
                                    this.mousedout = true;
                                else if (this.mousedout) {
                                    if (this.dispcar != i_176_ && i_176_ != -1 && (this.cd).action != 6) {
                                        (this.cd).action = 0;
                                        this.dispcar = i_176_;
                                        this.forcar = this.pcars[i_176_];
                                        this.dispco = null;
                                        System.gc();
                                        this.dispco = new ContO(contos[this.forcar], 0, 0, 0, 0);
                                    } else
                                        this.dispcar = -1;
                                    this.mousedout = false;
                                }
                            } else if (this.mousedout)
                                this.mousedout = false;
                            for (int i_187_ = 0; i_187_ < 7; i_187_++) {
                                for (int i_188_ = 0; i_188_ < this.npo; i_188_++) {
                                    if (this.pgames[i_188_] == this.ongame && this.invos[i_187_].equals(this.pnames[i_188_]) && this.dinvi[i_187_].equals(this.invos[i_187_])) {
                                        for (int i_189_ = i_187_; i_189_ < 6; i_189_++) {
                                            this.invos[i_189_] = this.invos[i_189_ + 1];
                                            this.dinvi[i_189_] = this.dinvi[i_189_ + 1];
                                        }
                                        this.invos[6] = "";
                                        this.dinvi[6] = "";
                                    }
                                }
                            }
                            if (this.wait[i_171_] > 0) {
                                int i_190_ = 0;
                                for (int i_191_ = i_175_; i_191_ < this.mnpls[i_171_]; i_191_++) {
                                    this.rd.setColor(color2k(200, 200, 200));
                                    this.rd.drawRect(237, 96 + i_191_ * 42, 170, 40);
                                    boolean bool_192_ = false;
                                    if (this.pgames[this.im] == this.ongame) {
                                        if (!this.gplyrs[i_171_].equals(""))
                                            bool_192_ = true;
                                    } else if (!this.gplyrs[i_171_].equals("") && this.gplyrs[i_171_].indexOf(this.pnames[this.im]) <= -1)
                                        bool_192_ = true;
                                    if (i > 237 && i < 407 && i_87_ > 96 + i_191_ * 42 && i_87_ < 136 + i_191_ * 42 && !bool_192_) {
                                        if (this.pgames[this.im] == this.ongame)
                                            stringbutton("<     Invite Player      ", 322, 121 + i_191_ * 42, 0);
                                        else
                                            stringbutton("    Join Game    ", 322, 121 + i_191_ * 42, 0);
                                        this.pbtn = 1;
                                    } else if (this.invos[i_190_].equals("")) {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("Empty", 322 - this.ftm.stringWidth("Empty") / 2, 114 + i_191_ * 42);
                                        this.rd.setFont(new Font("Arial", 0, 10));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("Waiting for player...", 322 - this.ftm.stringWidth("Waiting for player...") / 2, 126 + i_191_ * 42);
                                    } else if (!this.dinvi[i_190_].equals(this.invos[i_190_])) {
                                        if (this.nflk != 0) {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.drawString("Inviting player...", 322 - this.ftm.stringWidth("Inviting player...") / 2, 121 + i_191_ * 42);
                                        }
                                    } else {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 0, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("Player Invited!", 322 - this.ftm.stringWidth("Player Invited!") / 2, 113 + i_191_ * 42);
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.invos[i_190_], 322 - this.ftm.stringWidth(this.invos[i_190_]) / 2, 129 + i_191_ * 42);
                                    }
                                    i_190_++;
                                }
                            }
                            if ((this.xt).lan && this.mnbts[i_171_] != 0) {
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(new StringBuilder().append("Plus ").append(this.mnbts[i_171_]).append(" MadBots!").toString(), 322 - this.ftm.stringWidth(new StringBuilder().append("Plus ").append(this.mnbts[i_171_]).append(" MadBots!").toString()) / 2, 115 + this.mnpls[i_171_] * 42);
                            }
                            if (this.dispcar <= -1 || this.conon != 1) {
                                this.rd.drawImage((this.xt).sts, 537, 81, null);
                                this.rd.setColor(color2k(200, 200, 200));
                                this.rd.drawRect(415, 96, 293, 124);
                                if (this.conon == 1) {
                                    if (this.wait[i_171_] > 0) {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (this.wait[i_171_] > 30 || this.npls[i_171_] <= 1) {
                                            String string = "s";
                                            if (this.mnpls[i_171_] - this.npls[i_171_] == 1)
                                                string = "";
                                            this.rd.drawString(new StringBuilder().append("Waiting for ").append(this.mnpls[i_171_] - this.npls[i_171_]).append(" more player").append(string).append(" to join to start.").toString(), 561 - this.ftm.stringWidth(new StringBuilder().append("Waiting for ").append(this.mnpls[i_171_] - this.npls[i_171_]).append(" more player").append(string).append(" to join to start.").toString()) / 2, 119);
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            int i_193_ = 155;
                                            // whoah wtf does this do
                                            if (!this.gmaker[i_171_].equals("Coach Insano") && !this.gmaker[i_171_].equals(this.pnames[this.im])) {
                                                boolean bool_194_ = false;
                                                for (int i_195_ = 0; i_195_ < this.npo; i_195_++) {
                                                    if (this.pgames[i_195_] == this.ongame && this.gmaker[i_171_].equals(this.pnames[i_195_]))
                                                        bool_194_ = true;
                                                }
                                                if (bool_194_) {
                                                    i_193_ = 165;
                                                    this.rd.drawString(new StringBuilder().append("").append(this.gmaker[i_171_]).append(" can start this game at anytime.").toString(), 561 - this.ftm.stringWidth(new StringBuilder().append("").append(this.gmaker[i_171_]).append(" can start this game at anytime.").toString()) / 2, 145);
                                                }
                                            }
                                            if (this.npls[i_171_] > 1) {
                                                String string_196_ = new StringBuilder().append("").append(this.wait[i_171_]).append(" seconds").toString();
                                                if (this.wait[i_171_] > 60)
                                                    string_196_ = new StringBuilder().append("").append((float) (int) ((float) this.wait[i_171_] / 60.0F * 100.0F) / 100.0F).append(" minutes").toString();
                                                this.rd.drawString(new StringBuilder().append("(Waiting ").append(string_196_).append(" maximum! )").toString(), 561 - this.ftm.stringWidth(new StringBuilder().append("(Waiting ").append(string_196_).append(" maximum! )").toString()) / 2, i_193_);
                                            }
                                        } else {
                                            Date date = new Date();
                                            long l = date.getTime();
                                            if (this.ptime == 0L || l > this.ptime + 1500L) {
                                                if (this.ptime != 0L) {
                                                    this.wait[i_171_]--;
                                                    if (this.wait[i_171_] < 1)
                                                        this.wait[i_171_] = 1;
                                                }
                                                this.ptime = l;
                                            }
                                            if (this.pgames[this.im] == this.ongame || this.nflk != 0) {
                                                this.rd.drawString(new StringBuilder().append("Game starts in ").append(this.wait[i_171_]).append(" seconds!").toString(), 561 - this.ftm.stringWidth(new StringBuilder().append("Game starts in ").append(this.wait[i_171_]).append(" seconds!").toString()) / 2, 145);
                                                if (this.pgames[this.im] != this.ongame)
                                                    this.nflk--;
                                            } else if (this.pgames[this.im] != this.ongame)
                                                this.nflk = 3;
                                        }
                                        if (this.pgames[this.im] != this.ongame) {
                                            if (this.gplyrs[i_171_].equals("") || this.gplyrs[i_171_].indexOf(this.pnames[this.im]) != -1)
                                                stringbutton("    Join this Game    ", 561, 203, 0);
                                            else {
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.setColor(new Color(128, 73, 0));
                                                this.rd.drawString("Private Game, only specific players allowed.", 561 - this.ftm.stringWidth("Private Game, only specific players allowed!") / 2, 201);
                                            }
                                        } else if (this.gmaker[i_171_].equals(this.pnames[this.im])) {
                                            if (this.npls[i_171_] > 1) {
                                                if (!this.fstart)
                                                    stringbutton("    Start this Game Now!    ", 561, 203, 0);
                                                else
                                                    stringbutton("    Starting game now, one moment...    ", 561, 203, 0);
                                            } else {
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.setColor(new Color(128, 73, 0));
                                                this.rd.drawString("You have created this game.", 561 - this.ftm.stringWidth("You have created this game.") / 2, 201);
                                            }
                                        } else {
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.setColor(new Color(80, 128, 0));
                                            this.rd.drawString("You have joined this game.", 561 - this.ftm.stringWidth("You have joined this game.") / 2, 201);
                                        }
                                    } else if (this.prevloaded == 1) {
                                        int i_197_ = (int) (80.0 + (double) (float) this.rerr / 1.243);
                                        if (i_197_ > 255)
                                            i_197_ = 255;
                                        if (i_197_ < 0)
                                            i_197_ = 0;
                                        int i_198_ = (int) (128.0 + (double) (float) this.rerr / 2.428);
                                        if (i_198_ > 255)
                                            i_198_ = 255;
                                        if (i_198_ < 0)
                                            i_198_ = 0;
                                        int i_199_ = this.rerr;
                                        if (i_199_ > 255)
                                            i_199_ = 255;
                                        if (i_199_ < 0)
                                            i_199_ = 0;
                                        if (this.wait[i_171_] == 0) {
                                            this.rd.setColor(new Color(i_197_, i_198_, i_199_));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.rd.drawString("Live Info!", 621, 93);
                                            this.rd.drawString("Live Info!", 451, 93);
                                        }
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Tahoma", 1, 11));
                                        this.rd.drawString("Player       Position   Laps      Power        Damage", 439, 111);
                                        this.rd.setColor(color2k(200, 200, 200));
                                        if (this.prnpo < 7) {
                                            this.rd.drawLine(489, 103, 489, 185);
                                            this.rd.drawLine(542, 103, 542, 185);
                                            this.rd.drawLine(579, 103, 579, 185);
                                            this.rd.drawLine(641, 103, 641, 185);
                                            this.rd.drawLine(422, 114, 702, 114);
                                            this.rd.drawLine(422, 186, 702, 186);
                                        } else {
                                            this.rd.drawLine(489, 103, 489, 193);
                                            this.rd.drawLine(542, 103, 542, 193);
                                            this.rd.drawLine(579, 103, 579, 193);
                                            this.rd.drawLine(641, 103, 641, 233);
                                            this.rd.drawLine(422, 114, 702, 114);
                                            this.rd.drawLine(422, 194, 702, 194);
                                        }
                                        i_175_ = 0;
                                        for (int i_200_ = 0; i_200_ < this.prnpo; i_200_++) {
                                            for (int i_201_ = 0; i_201_ < this.prnpo; i_201_++) {
                                                if (this.ppos[i_201_] == i_200_) {
                                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    this.rd.setColor(new Color(0, 44, 124));
                                                    this.rd.drawString(this.prnames[i_201_], 455 - this.ftm.stringWidth(this.prnames[i_201_]) / 2, 125 + 11 * i_175_);
                                                    if (this.pdam[i_201_] < 55 && this.pdam[i_201_] != -17) {
                                                        this.rd.setColor(new Color(80, 128, 0));
                                                        String string = "th";
                                                        if (this.ppos[i_201_] == 0)
                                                            string = "st";
                                                        if (this.ppos[i_201_] == 1)
                                                            string = "nd";
                                                        if (this.ppos[i_201_] == 2)
                                                            string = "rd";
                                                        this.rd.drawString(new StringBuilder().append("").append(this.ppos[i_201_] + 1).append("").append(string).toString(), 515 - this.ftm.stringWidth(new StringBuilder().append("").append(this.ppos[i_201_] + 1).append("").append(string).toString()) / 2, 125 + 11 * i_175_);
                                                        this.rd.setColor(new Color(128, 73, 0));
                                                        if (this.plap[i_201_] > this.gnlaps[i_171_] - 1)
                                                            this.plap[i_201_] = this.gnlaps[i_171_] - 1;
                                                        this.rd.drawString(new StringBuilder().append("").append(this.plap[i_201_] + 1).append(" / ").append(this.gnlaps[i_171_]).append("").toString(), 560 - this.ftm.stringWidth(new StringBuilder().append("").append(this.plap[i_201_] + 1).append(" / ").append(this.gnlaps[i_171_]).append("").toString()) / 2, 125 + 11 * i_175_);
                                                        this.rd.setColor(new Color(0, 128, 255));
                                                        this.rd.drawRect(582, 118 + 11 * i_175_, 56, 6);
                                                        this.rd.fillRect(583, 121 + 11 * i_175_, this.ppow[i_201_], 3);
                                                        this.rd.setColor(new Color(128, 210, 255));
                                                        this.rd.fillRect(583, 119 + 11 * i_175_, this.ppow[i_201_], 2);
                                                        this.rd.setColor(new Color(255, 0, 0));
                                                        this.rd.drawRect(645, 118 + 11 * i_175_, 56, 6);
                                                        this.rd.fillRect(646, 121 + 11 * i_175_, this.pdam[i_201_], 3);
                                                        this.rd.setColor(new Color(255, 155, 64));
                                                        this.rd.fillRect(646, 119 + 11 * i_175_, this.pdam[i_201_], 2);
                                                    } else {
                                                        i_197_ = (int) (85.0 + (double) (float) (this.rerr * 2) / 1.5);
                                                        if (i_197_ > 255)
                                                            i_197_ = 255;
                                                        if (i_197_ < 0)
                                                            i_197_ = 0;
                                                        this.rd.setColor(color2k(i_197_, i_197_, i_197_));
                                                        this.rd.fillRect(490, 117 + 11 * i_175_, 213, 9);
                                                        this.rd.setFont(new Font("Tahoma", 1, 11));
                                                        this.ftm = this.rd.getFontMetrics();
                                                        i_197_ = 255 - this.rerr * 2;
                                                        if (i_197_ > 255)
                                                            i_197_ = 255;
                                                        if (i_197_ < 0)
                                                            i_197_ = 0;
                                                        i_198_ = (int) (155.0 - (double) (float) (this.rerr * 2) / 1.645);
                                                        if (i_198_ > 255)
                                                            i_198_ = 255;
                                                        if (i_198_ < 0)
                                                            i_198_ = 0;
                                                        i_199_ = (int) (64.0 - (double) (float) (this.rerr * 2) / 3.984);
                                                        if (i_199_ > 255)
                                                            i_199_ = 255;
                                                        if (i_199_ < 0)
                                                            i_199_ = 0;
                                                        this.rd.setColor(new Color(i_197_, i_198_, i_199_));
                                                        if (this.pdam[i_201_] != -17)
                                                            this.rd.drawString("=   =   =   =    W A S T E D    =   =   =   =", 597 - this.ftm.stringWidth("=   =   =   =    W A S T E D    =   =   =   =") / 2, 126 + 11 * i_175_);
                                                        else
                                                            this.rd.drawString("=   =   =   DISCONNECTED   =   =   =", 597 - this.ftm.stringWidth("=   =   =   DISCONNECTED   =   =   =") / 2, 126 + 11 * i_175_);
                                                    }
                                                    i_175_++;
                                                }
                                            }
                                        }
                                        int i_202_ = 0;
                                        int i_203_ = 3;
                                        if (this.prnpo < 7) {
                                            i_202_ = 5;
                                            i_203_ = 0;
                                        }
                                        if (this.wait[i_171_] == 0)
                                            stringbutton("    Watch Live Now!    ", 561, 212 - i_202_, i_203_);
                                        else {
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            String string = "";
                                            for (int i_204_ = 0; i_204_ < this.prnpo; i_204_++) {
                                                if (this.ppos[i_204_] == 0)
                                                    string = this.prnames[i_204_];
                                            }
                                            if (string.equals(""))
                                                this.rd.drawString("Game Finished!", 561 - this.ftm.stringWidth("Game Finished!") / 2, 212 - i_202_);
                                            else {
                                                this.rd.drawString(new StringBuilder().append("Game Finished!    Winner:  ").append(string).append("").toString(), 561 - this.ftm.stringWidth(new StringBuilder().append("Game Finished!    Winner:  ").append(string).append("").toString()) / 2, 212 - i_202_);
                                                if (this.nflk == 0) {
                                                    this.rd.setColor(new Color(255, 176, 67));
                                                    this.nflk = 3;
                                                } else
                                                    this.nflk--;
                                                this.rd.drawString(new StringBuilder().append("").append(string).append("").toString(), 561 - this.ftm.stringWidth(new StringBuilder().append("Game Finished!    Winner:  ").append(string).append("").toString()) / 2 + this.ftm.stringWidth("Game Finished!    Winner:  "), 212 - i_202_);
                                            }
                                        }
                                        this.rerr += 3;
                                    } else {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (this.prevloaded <= -1) {
                                            if (!(this.xt).lan)
                                                this.rd.drawString("Loading Info...", 561 - this.ftm.stringWidth("Loading Info...") / 2, 155);
                                            else if (this.pgames[this.im] == this.ongame)
                                                this.rd.drawString("About to Start...", 561 - this.ftm.stringWidth("About to Start...") / 2, 155);
                                            else {
                                                this.rd.drawString("Game Started!", 561 - this.ftm.stringWidth("Game Started!") / 2, 135);
                                                stringbutton("    Watch this Game    ", 561, 175, 0);
                                            }
                                        } else
                                            this.rd.drawString("About to Start...", 561 - this.ftm.stringWidth("About to Start...") / 2, 155);
                                    }
                                } else {
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (this.conon == 2)
                                        this.rd.drawString("Starting Game Now!", 561 - this.ftm.stringWidth("Starting Game Now!") / 2, 145);
                                    if (this.conon == 3)
                                        this.rd.drawString("Opening Game Now!", 561 - this.ftm.stringWidth("Opening Game Now!") / 2, 145);
                                    this.rd.setFont(new Font("Arial", 0, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("Please Wait...", 561 - this.ftm.stringWidth("Please Wait...") / 2, 175);
                                }
                                if (this.gstgn[i_171_] < 0) {
                                    this.rd.setColor(new Color(239, 234, 177));
                                    this.rd.fillRect(415, 222, 293, 40);
                                }
                                this.rd.setColor(color2k(200, 200, 200));
                                this.rd.drawRect(415, 222, 293, 40);
                                this.rd.drawImage((this.xt).stg, 422, 227, null);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.setFont(new Font("Arial", 1, 10));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(new StringBuilder().append("Laps: ").append(this.gnlaps[i_171_]).append("").toString(), 660, 235);
                                if (i > 415 && i < 708 && i_87_ > 222 && i_87_ < 262 && (this.wait[i_171_] > 0 || this.gstgn[i_171_] < 0) && this.conon == 1) {
                                    stringbutton("       Preview Stage       ", 562, 247, 0);
                                    this.pbtn = 2;
                                } else {
                                    if (this.gstgn[i_171_] > 0) {
                                        String string = "NFM 1";
                                        int i_205_ = this.gstgn[i_171_];
                                        if (this.gstgn[i_171_] > 10) {
                                            string = "NFM 2";
                                            i_205_ = this.gstgn[i_171_] - 10;
                                        }
                                        if (this.gstgn[i_171_] > 27) {
                                            string = "Multiplayer";
                                            i_205_ = this.gstgn[i_171_] - 27;
                                        }
                                        this.rd.drawString(new StringBuilder().append("").append(string).append(" - Stage ").append(i_205_).append("").toString(), 562 - this.ftm.stringWidth(new StringBuilder().append("").append(string).append(" - Stage ").append(i_205_).append("").toString()) / 2, 237);
                                    } else
                                        this.rd.drawString("Custom Stage", 562 - this.ftm.stringWidth("Custom Stage") / 2, 237);
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString(this.gstages[i_171_], 562 - this.ftm.stringWidth(this.gstages[i_171_]) / 2, 254);
                                }
                                if (!(this.xt).lan) {
                                    int i_206_ = 237;
                                    int i_207_ = 471;
                                    if (this.wait[i_171_] > 0) {
                                        if (this.mnpls[i_171_] > 4) {
                                            i_206_ = 415;
                                            i_207_ = 293;
                                        }
                                    } else if (this.npls[i_171_] > 4) {
                                        i_206_ = 415;
                                        i_207_ = 293;
                                    }
                                    this.rd.setColor(color2k(200, 200, 200));
                                    this.rd.drawRect(i_206_, 264, i_207_, 124);
                                    this.rd.setColor(color2k(240, 240, 240));
                                    this.rd.fillRect(i_206_ + 1, 265, i_207_ - 1, 21);
                                    this.rd.drawImage((this.xt).gmc, i_206_ + 7, 269, null);
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.rd.setColor(color2k(110, 110, 110));
                                    this.rd.drawString("(Game Chat )", i_206_ + 57, 278);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    if (this.updatec != -1) {
                                        String[] strings = new String[7];
                                        String[] strings_208_ = new String[7];
                                        boolean[] bools = { false, false, false, false, false, false, false };
                                        for (int i_209_ = 0; i_209_ < 7; i_209_++) {
                                            strings[i_209_] = "";
                                            strings_208_[i_209_] = this.cnames[i_209_];
                                            int i_210_ = 0;
                                            int i_211_ = 0;
                                            int i_212_ = 0;
                                            int i_213_ = 0;
                                            int i_214_ = 0;
                                            for (/**/; i_210_ < this.sentn[i_209_].length(); i_210_++) {
                                                String string = new StringBuilder().append("").append(this.sentn[i_209_].charAt(i_210_)).toString();
                                                if (string.equals(" ")) {
                                                    i_211_ = i_212_;
                                                    i_213_ = i_210_;
                                                    i_214_++;
                                                } else
                                                    i_214_ = 0;
                                                if (i_214_ <= 1) {
                                                    StringBuilder stringbuilder = new StringBuilder();
                                                    String[] strings_215_ = strings;
                                                    int i_216_ = i_209_;
                                                    strings_215_[i_216_] = stringbuilder.append(strings_215_[i_216_]).append(string).toString();
                                                    i_212_++;
                                                    if (this.ftm.stringWidth(strings[i_209_]) > i_207_ - 94) {
                                                        if (i_211_ != 0) {
                                                            strings[i_209_] = strings[i_209_].substring(0, i_211_);
                                                            for (int i_217_ = 0; i_217_ < i_209_; i_217_++) {
                                                                strings[i_217_] = strings[i_217_ + 1];
                                                                strings_208_[i_217_] = strings_208_[i_217_ + 1];
                                                                bools[i_217_] = bools[i_217_ + 1];
                                                            }
                                                            strings[i_209_] = "";
                                                            bools[i_209_] = true;
                                                            i_210_ = i_213_;
                                                            i_212_ = 0;
                                                            i_211_ = 0;
                                                        } else {
                                                            strings[i_209_] = "";
                                                            i_212_ = 0;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        String string = "";
                                        this.rd.setFont(new Font("Tahoma", 1, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        for (int i_218_ = 0; i_218_ < 7; i_218_++) {
                                            if (!string.equals(strings_208_[i_218_])) {
                                                this.rd.drawString(new StringBuilder().append(strings_208_[i_218_]).append(":").toString(), i_206_ + 84 - this.ftm.stringWidth(new StringBuilder().append(strings_208_[i_218_]).append(":").toString()), 299 + i_218_ * 14);
                                                string = strings_208_[i_218_];
                                            }
                                        }
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        for (int i_219_ = 0; i_219_ < 7; i_219_++) {
                                            if (bools[i_219_] && i_219_ == 0 && strings[i_219_].indexOf(" ") != -1)
                                                strings[i_219_] = new StringBuilder().append("...").append(strings[i_219_].substring(strings[i_219_].indexOf(" "), strings[i_219_].length())).append("").toString();
                                            this.rd.drawString(strings[i_219_], i_206_ + 88, 299 + i_219_ * 14);
                                        }
                                    } else
                                        this.rd.drawString("Loading chat...", i_206_ + i_207_ / 2 - this.ftm.stringWidth("Loading chat...") / 2, 315);
                                    if (this.conon == 1)
                                        this.pre2 = true;
                                    else
                                        hideinputs();
                                    if ((control).enter && !(this.gs).cmsg.getText().equals("Type here...") && !(this.gs).cmsg.getText().equals("")) {
                                        this.pessd[this.btn] = true;
                                        (control).enter = false;
                                        String string = (this.gs).cmsg.getText().replace('|', ':');
                                        if (string.toLowerCase().indexOf((this.gs).tpass.getText().toLowerCase()) != -1)
                                            string = " ";
                                        if (!this.xt.msgcheck(string) && this.updatec > -12) {
                                            for (int i_220_ = 0; i_220_ < 6; i_220_++) {
                                                this.sentn[i_220_] = this.sentn[i_220_ + 1];
                                                this.cnames[i_220_] = this.cnames[i_220_ + 1];
                                            }
                                            this.sentn[6] = string;
                                            this.cnames[6] = this.pnames[this.im];
                                            if (this.updatec > -11)
                                                this.updatec = -11;
                                            else
                                                this.updatec--;
                                        } else
                                            (this.xt).warning++;
                                        (this.gs).cmsg.setText("");
                                    }
                                    stringbutton("Send Message", 655, 405, 3);
                                }
                            } else {
                                if ((this.gs).cmsg.isShowing())
                                    (this.gs).cmsg.hide();
                                if (this.pcars[this.dispcar] == this.forcar && this.forcar != -1) {
                                    this.rd.drawImage((this.xt).crd, 517, 81, null);
                                    this.rd.setColor(new Color(16, 198, 255));
                                    this.rd.drawRect(415, 96, 293, 315);
                                    this.rd.setColor(color2k(240, 240, 240));
                                    this.rd.fillRect(416, 97, 4, 314);
                                    this.rd.fillRect(704, 97, 4, 314);
                                    this.rd.fillRect(416, 97, 292, 4);
                                    this.rd.fillRect(416, 407, 292, 4);
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
                                    this.rd.fillRect(445, 120, 233, 127);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString((this.cd).names[this.forcar], 561 - this.ftm.stringWidth((this.cd).names[this.forcar]) / 2, 117);
                                    for (int i_221_ = 0; i_221_ < (this.dispco).npl; i_221_++) {
                                        if (((contos[this.forcar]).p[i_221_]).colnum == 1) {
                                            ((this.dispco).p[i_221_]).hsb[0] = this.pcols[this.dispcar][0];
                                            ((this.dispco).p[i_221_]).hsb[1] = this.pcols[this.dispcar][1];
                                            ((this.dispco).p[i_221_]).hsb[2] = 1.0F - this.pcols[this.dispcar][2];
                                        }
                                        if (((contos[this.forcar]).p[i_221_]).colnum == 2) {
                                            ((this.dispco).p[i_221_]).hsb[0] = this.pcols[this.dispcar][3];
                                            ((this.dispco).p[i_221_]).hsb[1] = this.pcols[this.dispcar][4];
                                            ((this.dispco).p[i_221_]).hsb[2] = 1.0F - this.pcols[this.dispcar][5];
                                        }
                                    }
                                    (this.m).cx = 561;
                                    (this.dispco).z = 1200;
                                    (this.dispco).y = 605 - (this.dispco).grat;
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
                                    this.dispco.d(this.rd);
                                    (this.m).cx = 400;
                                    this.rd.setFont(new Font("Arial", 1, 11));
                                    int i_222_ = 424;
                                    int i_223_ = -55;
                                    this.rd.setColor(new Color(0, 63, 128));
                                    this.rd.drawString("Top Speed:", 30 + i_222_, 318 + i_223_);
                                    this.rd.drawImage((this.xt).statb, 97 + i_222_, 312 + i_223_, null);
                                    this.rd.drawString("Acceleration:", 20 + i_222_, 333 + i_223_);
                                    this.rd.drawImage((this.xt).statb, 97 + i_222_, 327 + i_223_, null);
                                    this.rd.setColor(color2k(255, 255, 255));
                                    float f = (float) ((this.cd).swits[this.forcar][2] - 220) / 90.0F;
                                    if ((double) f < 0.2)
                                        f = 0.2F;
                                    this.rd.fillRect((int) (97.0F + 156.0F * f) + i_222_, 312 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    f = (this.cd).acelf[this.forcar][1] * (this.cd).acelf[this.forcar][0] * (this.cd).acelf[this.forcar][2] * (this.cd).grip[this.forcar] / 7700.0F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    this.rd.fillRect((int) (97.0F + 156.0F * f) + i_222_, 327 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    this.rd.drawImage((this.xt).statbo, 97 + i_222_, 312 + i_223_, null);
                                    this.rd.drawImage((this.xt).statbo, 97 + i_222_, 327 + i_223_, null);
                                    i_222_ = 50;
                                    i_223_ = -25;
                                    this.rd.setColor(new Color(0, 63, 128));
                                    this.rd.drawString("Stunts:", 427 + i_222_, 318 + i_223_);
                                    this.rd.drawImage((this.xt).statb, 471 + i_222_, 312 + i_223_, null);
                                    this.rd.drawString("Strength:", 415 + i_222_, 333 + i_223_);
                                    this.rd.drawImage((this.xt).statb, 471 + i_222_, 327 + i_223_, null);
                                    this.rd.drawString("Endurance:", 405 + i_222_, 348 + i_223_);
                                    this.rd.drawImage((this.xt).statb, 471 + i_222_, 342 + i_223_, null);
                                    this.rd.setColor(color2k(255, 255, 255));
                                    f = ((float) (this.cd).airc[this.forcar] * (this.cd).airs[this.forcar] * (this.cd).bounce[this.forcar] + 28.0F) / 139.0F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    this.rd.fillRect((int) (471.0F + 156.0F * f) + i_222_, 312 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    float f_224_ = 0.5F;
                                    f = ((this.cd).moment[this.forcar] + f_224_) / 2.6F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    this.rd.fillRect((int) (471.0F + 156.0F * f) + i_222_, 327 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    f = (this.cd).outdam[this.forcar];
                                    this.rd.fillRect((int) (471.0F + 156.0F * f) + i_222_, 342 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    this.rd.drawImage((this.xt).statbo, 471 + i_222_, 312 + i_223_, null);
                                    this.rd.drawImage((this.xt).statbo, 471 + i_222_, 327 + i_223_, null);
                                    this.rd.drawImage((this.xt).statbo, 471 + i_222_, 342 + i_223_, null);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    if (this.forcar < 16) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("Created by Radicalplay.com", 561 - this.ftm.stringWidth("Created by Radicalplay.com") / 2, 347);
                                        String string = "Game Car";
                                        if ((this.cd).cclass[this.forcar] == 0)
                                            string = "Class C ,  Game Car";
                                        if ((this.cd).cclass[this.forcar] == 1)
                                            string = "Class B & C ,  Game Car";
                                        if ((this.cd).cclass[this.forcar] == 2)
                                            string = "Class B ,  Game Car";
                                        if ((this.cd).cclass[this.forcar] == 3)
                                            string = "Class A & B ,  Game Car";
                                        if ((this.cd).cclass[this.forcar] == 4)
                                            string = "Class A ,  Game Car";
                                        this.rd.drawString(string, 561 - this.ftm.stringWidth(string) / 2, 367);
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 0, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("You already have this car.", 561 - this.ftm.stringWidth("You already have this car.") / 2, 395);
                                    } else {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (!(this.cd).createdby[this.forcar - 16].equals((this.xt).nickname))
                                            this.rd.drawString(new StringBuilder().append("Created by :  ").append((this.cd).createdby[this.forcar - 16]).append("").toString(), 561 - this.ftm.stringWidth(new StringBuilder().append("Created by :  ").append((this.cd).createdby[this.forcar - 16]).append("").toString()) / 2, 347);
                                        else
                                            this.rd.drawString("Created by You", 561 - this.ftm.stringWidth("Created by You") / 2, 347);
                                        this.rd.setColor(new Color(128, 73, 0));
                                        String string = "";
                                        if ((this.cd).cclass[this.forcar] == 0)
                                            string = "Class C ,  ";
                                        if ((this.cd).cclass[this.forcar] == 1)
                                            string = "Class B & C ,  ";
                                        if ((this.cd).cclass[this.forcar] == 2)
                                            string = "Class B ,  ";
                                        if ((this.cd).cclass[this.forcar] == 3)
                                            string = "Class A & B ,  ";
                                        if ((this.cd).cclass[this.forcar] == 4)
                                            string = "Class A ,  ";
                                        if ((this.cd).publish[this.forcar - 16] == 0)
                                            string = new StringBuilder().append(string).append("Private Car").toString();
                                        if ((this.cd).publish[this.forcar - 16] == 1) {
                                            string = new StringBuilder().append(string).append("Public Car").toString();
                                            this.rd.setColor(new Color(0, 64, 128));
                                        }
                                        if ((this.cd).publish[this.forcar - 16] == 2) {
                                            string = new StringBuilder().append(string).append("Super Public Car").toString();
                                            this.rd.setColor(new Color(0, 64, 128));
                                        }
                                        this.rd.drawString(string, 561 - this.ftm.stringWidth(string) / 2, 367);
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Arial", 0, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        if ((this.cd).publish[this.forcar - 16] == 1 || (this.cd).publish[this.forcar - 16] == 2) {
                                            if ((this.cd).action == -9)
                                                this.rd.drawString("Failed to add car!  Unknown error!", 561 - this.ftm.stringWidth("Failed to add car!  Unknown error!") / 2, 395);
                                            if ((this.cd).action == -8)
                                                this.rd.drawString("Failed!  You already have 20 cars!", 561 - this.ftm.stringWidth("Failed!  You already have 20 cars!") / 2, 395);
                                            if ((this.cd).action == 7)
                                                this.rd.drawString(new StringBuilder().append("").append((this.cd).names[(this.cd).ac]).append(" has been added to your cars!").toString(), 561 - this.ftm.stringWidth(new StringBuilder().append("").append((this.cd).names[(this.cd).ac]).append(" has been added to your cars!").toString()) / 2, 395);
                                            if ((this.cd).action == -7)
                                                this.rd.drawString("You already have this car.", 561 - this.ftm.stringWidth("You already have this car.") / 2, 395);
                                            if ((this.cd).action == 6)
                                                this.rd.drawString("Adding Car...", 561 - this.ftm.stringWidth("Adding Car...") / 2, 395);
                                            if ((this.cd).action == -6) {
                                                String string_225_ = "Upgrade to a full account to add custom cars!";
                                                int i_226_ = 561 - this.ftm.stringWidth(string_225_) / 2;
                                                int i_227_ = i_226_ + this.ftm.stringWidth(string_225_);
                                                this.rd.drawString(string_225_, i_226_, 395);
                                                if (this.waitlink != -1)
                                                    this.rd.drawLine(i_226_, 396, i_227_, 396);
                                                if (i > i_226_ && i < i_227_ && i_87_ > 384 && i_87_ < 397) {
                                                    if (this.waitlink != -1)
                                                        i_89_ = 12;
                                                    if (bool && this.waitlink == 0) {
                                                        this.gs.editlink((this.xt).nickname);
                                                        this.waitlink = -1;
                                                    }
                                                }
                                                if (this.waitlink > 0)
                                                    this.waitlink--;
                                            }
                                            if ((this.cd).action == 0 && this.xt.drawcarb(true, null, " Add to My Cars ", 503, 375, i, i_87_, bool)) {
                                                if ((this.xt).logged) {
                                                    if ((this.cd).lastload != 2 || this.forcar >= 36) {
                                                        if ((this.cd).nlocars < 36) {
                                                            (this.cd).action = 6;
                                                            (this.cd).ac = this.forcar;
                                                            this.cd.sparkactionloader();
                                                        } else
                                                            (this.cd).action = -8;
                                                    } else
                                                        (this.cd).action = -7;
                                                } else {
                                                    (this.cd).action = -6;
                                                    this.waitlink = 20;
                                                }
                                            }
                                        } else
                                            this.rd.drawString("Private Car.  Cannot be added to account.", 561 - this.ftm.stringWidth("Private Car.  Cannot be added to account.") / 2, 395);
                                    }
                                    if (this.xt.drawcarb(true, null, "X", 682, 99, i, i_87_, bool))
                                        this.dispcar = -1;
                                } else
                                    this.dispcar = -1;
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
                    this.rd.fillRoundRect(155, 148, 490, 127, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(155, 148, 490, 127, 20, 20);
                    if (this.ontyp != 76) {
                        String string = "";
                        int i_228_ = 0;
                        if (this.ontyp >= 10) {
                            i_228_ = 10;
                            string = "Custom Cars";
                            if (this.ontyp > 10)
                                string = new StringBuilder().append(string).append(", ").toString();
                        }
                        if (this.ontyp >= 20) {
                            i_228_ = 20;
                            string = "Game Cars";
                            if (this.ontyp > 20)
                                string = new StringBuilder().append(string).append(", ").toString();
                        }
                        if (this.ontyp - i_228_ == 1)
                            string = new StringBuilder().append(string).append("Class C").toString();
                        if (this.ontyp - i_228_ == 2)
                            string = new StringBuilder().append(string).append("Class B & C").toString();
                        if (this.ontyp - i_228_ == 3)
                            string = new StringBuilder().append(string).append("Class B").toString();
                        if (this.ontyp - i_228_ == 4)
                            string = new StringBuilder().append(string).append("Class A & B").toString();
                        if (this.ontyp - i_228_ == 5)
                            string = new StringBuilder().append(string).append("Class A").toString();
                        if (this.ontyp <= -2) {
                            if (Math.abs(this.ontyp + 2) == 13)
                                string = new StringBuilder().append(" ").append((this.cd).names[Math.abs(this.ontyp + 2)]).append("  Game").toString();
                            else
                                string = new StringBuilder().append("").append((this.cd).names[Math.abs(this.ontyp + 2)]).append(" Game").toString();
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(new StringBuilder().append(": :   ").append(string).append("   : :").toString(), 400 - this.ftm.stringWidth(new StringBuilder().append(": :   ").append(string).append("   : :").toString()) / 2, 175);
                        string = "a";
                        if (this.ontyp - i_228_ == 1)
                            string = "a class C";
                        if (this.ontyp - i_228_ == 2)
                            string = "a class B or C";
                        if (this.ontyp - i_228_ == 3)
                            string = "a class B";
                        if (this.ontyp - i_228_ == 4)
                            string = "a class A or B";
                        if (this.ontyp - i_228_ == 5)
                            string = "a class A";
                        if (i_228_ == 0)
                            string = new StringBuilder().append(string).append(" car").toString();
                        if (i_228_ == 10)
                            string = new StringBuilder().append(string).append(" custom car").toString();
                        if (i_228_ == 20)
                            string = new StringBuilder().append(string).append(" game car").toString();
                        if (this.ontyp <= -2) {
                            if (Math.abs(this.ontyp + 2) == 13)
                                string = new StringBuilder().append(" ").append((this.cd).names[Math.abs(this.ontyp + 2)]).append(" ").toString();
                            else
                                string = new StringBuilder().append("").append((this.cd).names[Math.abs(this.ontyp + 2)]).append("").toString();
                        }
                        this.rd.drawString(new StringBuilder().append("To join this game you need to have ").append(string).append("!").toString(), 400 - this.ftm.stringWidth(new StringBuilder().append("To join this game you need to have ").append(string).append("!").toString()) / 2, 206);
                        stringbutton(new StringBuilder().append("  Get ").append(string).append(" now...  ").toString(), 400, 247, 0);
                        stringbutton("  Cancel X  ", 593, 259, 2);
                    } else {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(": :   Custom Stage   : :", 400 - this.ftm.stringWidth(": :   Custom Stage   : :") / 2, 175);
                        this.rd.drawString("You need to have a full account to join this game!", 400 - this.ftm.stringWidth("You need to have a full account to join this game!") / 2, 206);
                        stringbutton("  Upgrade Account  ", 400, 247, 0);
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
                this.rd.setColor(color2k(240, 240, 240));
                this.rd.fillRoundRect(160, 75, 480, 300, 20, 20);
                this.rd.setColor(color2k(145, 145, 145));
                this.rd.drawRoundRect(160, 75, 480, 300, 20, 20);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(color2k(0, 0, 0));
                this.rd.drawString("You have played the allowed 5 games!  Please register.", 180, 105);
                this.rd.setColor(color2k(90, 90, 90));
                this.rd.drawString("You are allowed 5 free games of online multiplayer per day.", 180, 125);
                this.rd.drawString("Register to play unlimitedly!", 180, 145);
                this.rd.drawString(new StringBuilder().append("You will be able to play again tomorrow or in ").append((float) (this.xt).hours / 10.0F).append(" hours exactly.").toString(), 180, 185);
                this.rd.drawString("Now until tomorrow, you can only watch games!", 180, 205);
                this.rd.setColor(color2k(0, 0, 0));
                this.rd.drawString("Register an account to enjoy playing the game with no limitations", 180, 265);
                this.rd.drawString("and with all the multiplayer options available!", 180, 285);
                stringbutton("  Register Now!  ", 315, 325, 0);
                stringbutton("  Exit  ", 515, 325, 0);
            }
        } else {
        	// SWEAR WARNING...IT MAY GET YOU KICKED SERVERSIDE...
            //this.xt.drawWarning();
            //if ((this.gs).cmsg.isShowing()) {
            //    (this.gs).cmsg.hide();
            //    this.gs.requestFocus();
            //}
            /*if ((this.xt).warning > 220) {
                this.conon = 0;
                try {
                    this.socket.close();
                    this.socket = null;
                    this.din.close();
                    this.din = null;
                    this.dout.close();
                    this.dout = null;
                } catch (Exception exception) {}
            }*/
            //(this.xt).warning++;
        }
        if (i_89_ != this.pcurs) {
            this.gs.setCursor(new Cursor(i_89_));
            this.pcurs = i_89_;
        }
    }
    
    public void preforma(int i, int i_229_) {
        if (this.pre1) {
            if (!(this.gs).openm && (this.gb).open == 0) {
                if (this.conon != 0 && !(this.gs).cmsg.isShowing()) {
                    (this.gs).cmsg.show();
                    (this.gs).cmsg.requestFocus();
                    this.prereq = 2;
                }
            } else if ((this.gs).cmsg.isShowing())
                (this.gs).cmsg.hide();
            this.gs.movefield((this.gs).cmsg, 235, 390, 360, 22);
            if ((this.gs).cmsg.getText().equals("Type here...") && i > 234 && i < 603 && i_229_ > 385 && i_229_ < 417)
                (this.gs).cmsg.setText("");
        }
        if (this.pre2) {
            if (!(this.gs).openm && (this.gb).open == 0) {
                if (!(this.gs).cmsg.isShowing()) {
                    (this.gs).cmsg.show();
                    (this.gs).cmsg.requestFocus();
                    this.prereq = 2;
                }
            } else if ((this.gs).cmsg.isShowing())
                (this.gs).cmsg.hide();
            this.gs.movefield((this.gs).cmsg, 237, 390, 360, 22);
            if ((this.gs).cmsg.getText().equals("Type here...") && i > 232 && i < 601 && i_229_ > 385 && i_229_ < 417)
                (this.gs).cmsg.setText("");
        }
        if (this.pre1 || this.pre2) {
            if ((this.gs).cmsg.getText().length() > 100) {
                (this.gs).cmsg.setText((this.gs).cmsg.getText().substring(0, 100));
                (this.gs).cmsg.select(100, 100);
            }
            this.pre1 = false;
            this.pre2 = false;
        }
        if (this.prereq != 0) {
            if (this.prereq == 1)
                this.gs.requestFocus();
            this.prereq--;
        }
    }
    
    public void stageselect(CheckPoints checkpoints, Control control, int i, int i_230_, boolean bool) {
        this.btn = 0;
        int i_231_ = 0;
        this.rd.drawImage((this.xt).br, 65, 25, null);
        if (this.britchl <= -1) {
            this.ongame = -1;
            this.britchl = 0;
        }
        int i_232_ = 0;
        for (int i_233_ = 0; i_233_ < this.ngm; i_233_++) {
            if (this.ongame == this.gnum[i_233_])
                i_232_ = i_233_;
        }
        if (this.chalngd != -2 && this.ongame != -1) {
            this.rd.setColor(color2k(20, 20, 20));
            this.rd.fillRect(80, 25, 640, 40);
            this.rd.setColor(color2k(70, 70, 70));
            this.rd.drawLine(80, 65, 720, 65);
            this.rd.drawLine(80, 65, 80, 25);
            this.rd.drawLine(720, 65, 720, 25);
            this.rd.setColor(color2k(210, 210, 210));
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            if (this.wait[i_232_] > 0) {
                if (this.wait[i_232_] > 30 || this.npls[i_232_] <= 1) {
                    String string = "";
                    if (this.npls[i_232_] > 1) {
                        Date date = new Date();
                        long l = date.getTime();
                        if (this.ptime == 0L || l > this.ptime + 1500L) {
                            if (this.ptime != 0L) {
                                this.wait[i_232_]--;
                                if (this.wait[i_232_] < 1)
                                    this.wait[i_232_] = 1;
                            }
                            this.ptime = l;
                        }
                        string = new StringBuilder().append(" (waiting ").append(this.wait[i_232_]).append(" seconds maximum)").toString();
                        if (this.wait[i_232_] > 60)
                            string = new StringBuilder().append(" (waiting ").append((float) (int) ((float) this.wait[i_232_] / 60.0F * 100.0F) / 100.0F).append(" minutes maximum)").toString();
                    }
                    this.rd.drawString(new StringBuilder().append("Waiting for ").append(this.mnpls[i_232_] - this.npls[i_232_]).append(" more players to join to start this game").append(string).append("!").toString(), 95, 40);
                    this.rd.setFont(new Font("Arial", 0, 12));
                    if (!this.gmaker[i_232_].equals("Coach Insano") && !this.gmaker[i_232_].equals(this.pnames[this.im])) {
                        boolean bool_234_ = false;
                        for (int i_235_ = 0; i_235_ < this.npo; i_235_++) {
                            if (this.pgames[i_235_] == this.ongame && this.gmaker[i_232_].equals(this.pnames[i_235_]))
                                bool_234_ = true;
                        }
                        if (bool_234_)
                            this.rd.drawString(new StringBuilder().append("").append(this.gmaker[i_232_]).append(" can start this game at anytime (the game creator)...").toString(), 95, 56);
                    }
                } else {
                    Date date = new Date();
                    long l = date.getTime();
                    if (this.ptime == 0L || l > this.ptime + 1500L) {
                        if (this.ptime != 0L) {
                            this.wait[i_232_]--;
                            if (this.wait[i_232_] < 1)
                                this.wait[i_232_] = 1;
                        }
                        this.ptime = l;
                    }
                    if (this.pgames[this.im] == this.ongame || this.nflk != 0) {
                        this.rd.drawString(new StringBuilder().append("Game starts in ").append(this.wait[i_232_]).append(" seconds!").toString(), 400 - this.ftm.stringWidth(new StringBuilder().append("Game starts in ").append(this.wait[i_232_]).append(" seconds!").toString()) / 2, 48);
                        if (this.pgames[this.im] != this.ongame)
                            this.nflk--;
                    } else if (this.pgames[this.im] != this.ongame)
                        this.nflk = 3;
                }
                if (this.pgames[this.im] != this.ongame && (this.gplyrs[i_232_].equals("") || this.gplyrs[i_232_].indexOf(this.pnames[this.im]) != -1))
                    stringbutton(" Join Game ", 660, 48, 2);
            } else {
                this.rd.setColor(color2k(120, 120, 120));
                if (this.wait[i_232_] == 0)
                    this.rd.drawString("Game Started", 400 - this.ftm.stringWidth("Game Started") / 2, 45);
                else
                    this.rd.drawString("Game Finished", 400 - this.ftm.stringWidth("Game Finished") / 2, 45);
            }
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        (this.xt).ftm = this.rd.getFontMetrics();
        String string = "";
        if ((checkpoints).stage < 0)
            string = "Custom Stage";
        if ((checkpoints).stage > 0 && (checkpoints).stage <= 10)
            string = new StringBuilder().append("Stage ").append((checkpoints).stage).append(" NFM 1").toString();
        if ((checkpoints).stage > 10 && (checkpoints).stage <= 27)
            string = new StringBuilder().append("Stage ").append((checkpoints).stage - 10).append(" NFM 2").toString();
        if ((checkpoints).stage > 27)
            string = new StringBuilder().append("Multiplayer Stage ").append((checkpoints).stage - 27).append("").toString();
        this.xt.drawcs(85, new StringBuilder().append("Previewing ").append(string).append("  >").toString(), 255, 138, 0, 3);
        this.xt.drawcs(105, new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(), 255, 176, 85, 3);
        this.rd.drawImage((this.xt).back[this.pback], 532, 285, null);
        if ((checkpoints).stage < 0) {
            this.rd.setColor(new Color(255, 138, 0));
            this.rd.drawString(new StringBuilder().append("Created by: ").append((checkpoints).maker).append("").toString(), 85, 388);
            if ((checkpoints).pubt > 0) {
                if ((checkpoints).pubt == 2)
                    this.xt.drawcs(388, "Super Public Stage", 41, 177, 255, 3);
                else
                    this.xt.drawcs(388, "Public Stage", 41, 177, 255, 3);
                if (this.addstage == 0 && this.xt.drawcarb(true, null, " Add to My Stages ", 334, 395, i, i_230_, bool)) {
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
                    String string_236_ = "Upgrade to a full account to add custom stages!";
                    int i_237_ = 400 - this.ftm.stringWidth(string_236_) / 2;
                    int i_238_ = i_237_ + this.ftm.stringWidth(string_236_);
                    this.rd.drawString(string_236_, i_237_, 410);
                    if (this.waitlink != -1)
                        this.rd.drawLine(i_237_, 412, i_238_, 412);
                    if (i > i_237_ && i < i_238_ && i_230_ > 399 && i_230_ < 412) {
                        if (this.waitlink != -1)
                            i_231_ = 12;
                        if (bool && this.waitlink == 0) {
                            this.gs.editlink((this.xt).nickname);
                            this.waitlink = -1;
                        }
                    }
                    if (this.waitlink > 0)
                        this.waitlink--;
                }
                if (this.addstage == 2) {
                    this.xt.drawcs(410, "Adding stage please wait...", 193, 106, 0, 3);
                    if ((this.cd).staction == 0)
                        this.addstage = 3;
                    if ((this.cd).staction == -2)
                        this.addstage = 4;
                    if ((this.cd).staction == -3)
                        this.addstage = 5;
                    if ((this.cd).staction <= -1)
                        this.addstage = 6;
                }
                if (this.addstage == 3)
                    this.xt.drawcs(410, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                if (this.addstage == 4)
                    this.xt.drawcs(410, "You already have this stage!", 193, 106, 0, 3);
                if (this.addstage == 5)
                    this.xt.drawcs(410, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                if (this.addstage == 6)
                    this.xt.drawcs(410, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
            } else
                this.xt.drawcs(410, "Private Stage", 193, 106, 0, 3);
        }
        if ((control).enter || this.conon == 2 || this.ongame <= -1 && this.chalngd != -2) {
            (this.m).trk = 0;
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
        if (i_231_ != this.pcurs) {
            this.gs.setCursor(new Cursor(i_231_));
            this.pcurs = i_231_;
        }
    }
    
    public void ctachm(int i, int i_239_, int i_240_, Control control) {
        int i_241_ = -1;
        if (this.fase == 1 || this.fase == 4) {
            for (int i_242_ = 0; i_242_ < this.btn; i_242_++) {
                if (Math.abs(i - this.bx[i_242_]) < this.bw[i_242_] / 2 + 12 && Math.abs(i_239_ - this.by[i_242_]) < 14 && (i_240_ == 1 || i_240_ == 11))
                    this.pessd[i_242_] = true;
                else
                    this.pessd[i_242_] = false;
                if (Math.abs(i - this.bx[i_242_]) < this.bw[i_242_] / 2 + 12 && Math.abs(i_239_ - this.by[i_242_]) < 14 && i_240_ <= -1) {
                    i_241_ = i_242_;
                    (this.gs).mouses = 0;
                }
            }
        }
        if (this.conon == 1) {
            if (!this.regnow) {
                if (this.onjoin <= -1) {
                    if (this.fase == 4) {
                        if (i > 532 && i < 592 && i_239_ > 285 && i_239_ < 306 && (i_240_ == 1 || i_240_ == 11))
                            this.pback = 1;
                        else
                            this.pback = 0;
                        if (i > 532 && i < 592 && i_239_ > 285 && i_239_ < 306 && i_240_ <= -1) {
                            (this.gs).mouses = 0;
                            (this.m).trk = 0;
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
                        if (i_241_ == 0 && this.chalngd <= -1) {
                            i_241_ = -1;
                            this.join = this.ongame;
                            this.msg = "| Joining Game |";
                            this.spos = 0;
                            (this.m).trk = 0;
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
                        if (this.ongame <= -1) {
                            if (i_241_ == 0) {
                                if (this.chalngd <= -1) {
                                    if ((this.xt).lan && !this.lanlogged)
                                        this.gs.reglink();
                                    else {
                                        this.loadstage = 0;
                                        this.remstage = 0;
                                        this.gstage = 0;
                                        this.gnpls = 7;
                                        this.gwait = 0;
                                        this.gnbts = 0;
                                        this.gclass = 0;
                                        this.gcars = 0;
                                        this.gfix = 0;
                                        this.gnotp = 1;
                                        this.gplayers = "";
                                        this.chalngd = -2;
                                    }
                                } else if (this.chalngd != -5)
                                    this.cflk = 25;
                            }
                            if (i_241_ == 1) {
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
                                hideinputs();
                                (this.xt).playingame = -101;
                                (this.xt).fase = 23;
                            }
                            if (i_241_ == 2) {
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
                            int i_243_ = 3;
                            if (this.chalngd > -1) {
                                if (i_241_ == 3) {
                                    this.ongame = this.chalngd;
                                    this.chalngd = -1;
                                }
                                if (i_241_ == 4) {
                                    this.ongame = this.chalngd;
                                    this.join = this.chalngd;
                                    this.msg = "| Joining Game |";
                                    this.chalngd = -1;
                                    this.longame = -1;
                                }
                                if (i_241_ == 5) {
                                    this.ongame = this.longame;
                                    this.chalngd = -1;
                                    this.longame = -1;
                                }
                                i_243_ = 6;
                            } else {
                                if (this.chalngd != -1 && this.chalngd != -5 && i_241_ == 3) {
                                    if (this.invo)
                                        this.invo = false;
                                    for (int i_244_ = 0; i_244_ < 7; i_244_++) {
                                        if (!this.invos[i_244_].equals(""))
                                            this.invos[i_244_] = "";
                                        if (!this.dinvi[i_244_].equals(""))
                                            this.dinvi[i_244_] = "";
                                    }
                                    (this.gs).swait.hide();
                                    (this.gs).snpls.hide();
                                    (this.gs).snbts.hide();
                                    (this.gs).sgame.hide();
                                    (this.gs).mstgs.hide();
                                    (this.gs).slaps.hide();
                                    (this.gs).snfm1.hide();
                                    (this.gs).snfmm.hide();
                                    (this.gs).snfm2.hide();
                                    (this.gs).sclass.hide();
                                    (this.gs).scars.hide();
                                    (this.gs).sfix.hide();
                                    (this.gs).mycar.hide();
                                    (this.gs).notp.hide();
                                    this.gs.requestFocus();
                                    this.chalngd = -1;
                                }
                                if (this.chalngd == -2) {
                                    if ((this.gs).sgame.getSelectedIndex() == 3 && !(this.xt).logged) {
                                        if (i_241_ == 4)
                                            this.gs.editlink((this.xt).nickname);
                                        i_243_ = 5;
                                    } else {
                                        if (i_241_ == 4) {
                                            if (this.loadstage < 0) {
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.fillRect(0, 0, 670, 400);
                                                this.gs.repaint();
                                                (this.gs).cmsg.hide();
                                                (this.gs).sgame.hide();
                                                (this.gs).mstgs.hide();
                                                (this.gs).slaps.hide();
                                                (this.gs).snfm1.hide();
                                                (this.gs).snfmm.hide();
                                                (this.gs).snfm2.hide();
                                                this.gs.requestFocus();
                                                (this.m).ptr = 0;
                                                (this.m).ptcnt = -10;
                                                (this.m).hit = 45000;
                                                (this.m).fallen = 0;
                                                (this.m).nrnd = 0;
                                                (this.m).trk = 1;
                                                (this.m).ih = 25;
                                                (this.m).iw = 65;
                                                (this.m).h = 425;
                                                (this.m).w = 735;
                                                this.addstage = 0;
                                                this.fase = 4;
                                            } else
                                                this.sflk = 25;
                                        }
                                        if (this.loadstage >= 0)
                                            i_243_ = 5;
                                        else {
                                            if (i_241_ == 5) {
                                                if (this.gstage != 0) {
                                                    (this.gs).sgame.hide();
                                                    (this.gs).mstgs.hide();
                                                    (this.gs).slaps.hide();
                                                    (this.gs).snfm1.hide();
                                                    (this.gs).snfmm.hide();
                                                    (this.gs).snfm2.hide();
                                                    this.gs.requestFocus();
                                                    this.chalngd = -3;
                                                    i_241_ = -1;
                                                } else
                                                    this.sflk = 25;
                                            }
                                            i_243_ = 6;
                                        }
                                    }
                                }
                                if (this.chalngd == -3) {
                                    if (i_241_ == 4) {
                                        this.chalngd = -2;
                                        (this.gs).snpls.hide();
                                        (this.gs).snbts.hide();
                                        (this.gs).swait.hide();
                                        this.gs.requestFocus();
                                    }
                                    if (i_241_ == 5) {
                                        if (this.gnpls != 0 && (this.gs).snpls.getSelectedIndex() != 0) {
                                            this.chalngd = -4;
                                            for (int i_245_ = 0; i_245_ < 7; i_245_++) {
                                                if (!this.invos[i_245_].equals(""))
                                                    this.invos[i_245_] = "";
                                                if (!this.dinvi[i_245_].equals(""))
                                                    this.dinvi[i_245_] = "";
                                            }
                                            i_241_ = -1;
                                            (this.gs).snpls.hide();
                                            (this.gs).snbts.hide();
                                            (this.gs).swait.hide();
                                            this.gs.requestFocus();
                                        } else
                                            this.sflk = 25;
                                    }
                                    i_243_ = 6;
                                }
                                if (this.chalngd == -4) {
                                    i_243_ = 7;
                                    int i_246_ = 0;
                                    for (int i_247_ = 0; i_247_ < 7; i_247_++) {
                                        if (!this.invos[i_247_].equals(""))
                                            i_246_++;
                                    }
                                    if (i_246_ < this.gnpls - 1) {
                                        if (i_241_ == 4) {
                                            if (!this.invo)
                                                this.invo = true;
                                            else
                                                this.invo = false;
                                        }
                                    } else
                                        i_243_ = 6;
                                    if (i_241_ == i_243_ - 2) {
                                        if (this.invo)
                                            this.invo = false;
                                        if ((this.gs).mycar.getState() && (this.xt).sc[0] < 16) {
                                            this.gclass = -((this.xt).sc[0] + 2);
                                            this.gcars = 0;
                                        }
                                        if ((this.gs).notp.getState())
                                            this.gnotp = 1;
                                        else
                                            this.gnotp = 0;
                                        this.gplayers = "";
                                        (this.gs).sclass.hide();
                                        (this.gs).scars.hide();
                                        (this.gs).sfix.hide();
                                        (this.gs).mycar.hide();
                                        (this.gs).notp.hide();
                                        this.gs.requestFocus();
                                        this.chalngd = -3;
                                    }
                                    if (i_241_ == i_243_ - 1) {
                                        if (this.invo)
                                            this.invo = false;
                                        this.msg = "| Creating Game |";
                                        if ((this.gs).mycar.getState() && (this.xt).sc[0] < 16) {
                                            this.gclass = -((this.xt).sc[0] + 2);
                                            this.gcars = 0;
                                        }
                                        if (this.gclass != 0)
                                            this.gwait = 120;
                                        if ((this.gs).notp.getState())
                                            this.gnotp = 1;
                                        else
                                            this.gnotp = 0;
                                        this.gplayers = "";
                                        if (i_246_ != 0) {
                                            this.gnpls = i_246_ + 1;
                                            this.gplayers = new StringBuilder().append("").append(this.pnames[this.im]).append("X").toString();
                                            for (int i_248_ = 0; i_248_ < i_246_; i_248_++) {
                                                StringBuilder stringbuilder = new StringBuilder();
                                                Lobby lobby_249_ = this;
                                                (lobby_249_).gplayers = stringbuilder.append((lobby_249_).gplayers).append(this.invos[i_248_]).append("X").toString();
                                            }
                                        }
                                        (this.gs).sclass.hide();
                                        (this.gs).scars.hide();
                                        (this.gs).sfix.hide();
                                        (this.gs).mycar.hide();
                                        (this.gs).notp.hide();
                                        this.gs.requestFocus();
                                        this.chalngd = -5;
                                    }
                                }
                            }
                            if (i_241_ == i_243_ && !(this.xt).lan && !(this.gs).cmsg.getText().equals("Type here...") && !(this.gs).cmsg.getText().equals("")) {
                                String string = (this.gs).cmsg.getText().replace('|', ':');
                                if (string.toLowerCase().indexOf((this.gs).tpass.getText().toLowerCase()) != -1)
                                    string = " ";
                                if (!this.xt.msgcheck(string) && this.updatec > -12) {
                                    for (int i_250_ = 0; i_250_ < 6; i_250_++) {
                                        this.sentn[i_250_] = this.sentn[i_250_ + 1];
                                        this.cnames[i_250_] = this.cnames[i_250_ + 1];
                                    }
                                    this.sentn[6] = string;
                                    this.cnames[6] = this.pnames[this.im];
                                    if (this.updatec > -11)
                                        this.updatec = -11;
                                    else
                                        this.updatec--;
                                    this.spos3 = 28;
                                } else
                                    (this.xt).warning++;
                                (this.gs).cmsg.setText("");
                            }
                        } else if (this.dispcar <= -1) {
                            int i_251_ = 0;
                            for (int i_252_ = 0; i_252_ < this.ngm; i_252_++) {
                                if (this.ongame == this.gnum[i_252_])
                                    i_251_ = i_252_;
                            }
                            boolean bool = false;
                            if (!this.gplyrs[i_251_].equals("") && this.gplyrs[i_251_].indexOf(this.pnames[this.im]) <= -1)
                                bool = true;
                            if ((control).enter && this.wait[i_251_] > 0 && this.pgames[this.im] <= -1 && !bool) {
                                this.join = this.ongame;
                                this.msg = "| Joining Game |";
                                this.spos = 0;
                                if (this.pbtn == 0)
                                    this.pessd[1] = true;
                            }
                            if (this.wait[i_251_] <= -1 && this.pgames[this.im] <= -1 && (control).enter) {
                                i_241_ = 0;
                                this.pessd[0] = true;
                            }
                            if (this.pgames[this.im] <= -1 && (control).exit) {
                                i_241_ = 0;
                                this.pessd[0] = true;
                            }
                            if (i_241_ == 0) {
                                if (this.pgames[this.im] <= -1) {
                                    this.ongame = -1;
                                    this.chalngd = -1;
                                } else {
                                    this.join = -2;
                                    this.msg = "| Leaving Game |";
                                    this.longame = -1;
                                }
                            }
                            if (this.pbtn == 0) {
                                if (i_241_ == 1) {
                                    if (this.wait[i_251_] > 0) {
                                        if (this.pgames[this.im] <= -1) {
                                            this.join = this.ongame;
                                            this.msg = "| Joining Game |";
                                            this.spos = 0;
                                        } else if (this.gmaker[i_251_].equals(this.pnames[this.im]) && this.npls[i_251_] > 1)
                                            this.fstart = true;
                                        else
                                            i_241_ = 2;
                                    } else {
                                        if (this.wait[i_251_] == 0 && this.prevloaded == 1) {
                                            this.laps = this.gnlaps[i_251_];
                                            this.stage = this.gstgn[i_251_];
                                            this.stagename = this.gstages[i_251_];
                                            this.nfix = this.gfx[i_251_];
                                            if (this.gntb[i_251_] == 1)
                                                this.notb = true;
                                            else
                                                this.notb = false;
                                            this.gs.setCursor(new Cursor(3));
                                            this.conon = 3;
                                        } else
                                            i_241_ = 2;
                                        if (this.wait[i_251_] == 0 && (this.xt).lan) {
                                            this.laps = this.gnlaps[i_251_];
                                            this.stage = this.gstgn[i_251_];
                                            this.stagename = this.gstages[i_251_];
                                            this.nfix = this.gfx[i_251_];
                                            if (this.gntb[i_251_] == 1)
                                                this.notb = true;
                                            else
                                                this.notb = false;
                                            this.gs.setCursor(new Cursor(3));
                                            this.conon = 3;
                                        }
                                    }
                                }
                                if (i_241_ == 2 && !(this.xt).lan && !(this.gs).cmsg.getText().equals("Type here...") && !(this.gs).cmsg.getText().equals("")) {
                                    String string = (this.gs).cmsg.getText().replace('|', ':');
                                    if (string.toLowerCase().indexOf((this.gs).tpass.getText().toLowerCase()) != -1)
                                        string = " ";
                                    if (!this.xt.msgcheck(string) && this.updatec > -12) {
                                        for (int i_253_ = 0; i_253_ < 6; i_253_++) {
                                            this.sentn[i_253_] = this.sentn[i_253_ + 1];
                                            this.cnames[i_253_] = this.cnames[i_253_ + 1];
                                        }
                                        this.sentn[6] = string;
                                        this.cnames[6] = this.pnames[this.im];
                                        if (this.updatec > -11)
                                            this.updatec = -11;
                                        else
                                            this.updatec--;
                                    } else
                                        (this.xt).warning++;
                                    (this.gs).cmsg.setText("");
                                }
                            }
                            if (this.pbtn == 1 && i_241_ == 1) {
                                if (this.pgames[this.im] <= -1) {
                                    this.join = this.ongame;
                                    this.msg = "| Joining Game |";
                                    this.spos = 0;
                                } else if (!this.invo)
                                    this.invo = true;
                                else
                                    this.invo = false;
                            }
                            if (this.pbtn == 2 && (i_241_ == 1 || i_241_ == 2)) {
                                this.fase = 2;
                                (this.m).ptr = 0;
                                (this.m).ptcnt = -10;
                                (this.m).hit = 45000;
                                (this.m).fallen = 0;
                                (this.m).nrnd = 0;
                                (this.m).trk = 1;
                                (this.m).ih = 25;
                                (this.m).iw = 65;
                                (this.m).h = 425;
                                (this.m).w = 735;
                                if ((this.gs).cmsg.isShowing()) {
                                    (this.gs).cmsg.hide();
                                    this.gs.requestFocus();
                                }
                            }
                        } else {
                            if (i_241_ == 0) {
                                if (this.pgames[this.im] <= -1) {
                                    this.ongame = -1;
                                    this.chalngd = -1;
                                } else {
                                    this.join = -2;
                                    this.msg = "| Leaving Game |";
                                    this.longame = -1;
                                }
                            }
                            if (this.pbtn == 1 && i_241_ == 1) {
                                if (this.pgames[this.im] <= -1) {
                                    this.join = this.ongame;
                                    this.msg = "| Joining Game |";
                                    this.spos = 0;
                                } else if (!this.invo)
                                    this.invo = true;
                                else
                                    this.invo = false;
                            }
                        }
                    }
                } else if (this.ontyp != 76) {
                    if (i_241_ == 0) {
                        (this.xt).onjoin = this.onjoin;
                        (this.xt).ontyp = this.ontyp;
                        (this.xt).playingame = -101;
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
                        hideinputs();
                        (this.xt).fase = 23;
                    }
                    if (i_241_ == 1)
                        this.onjoin = -1;
                } else {
                    if (i_241_ == 0) {
                        this.gs.editlink((this.xt).nickname);
                        this.onjoin = -1;
                    }
                    if (i_241_ == 1)
                        this.onjoin = -1;
                }
            } else {
                if (i_241_ == 0) {
                    this.gs.reglink();
                    this.gs.regprom();
                }
                if (i_241_ == 1) {
                    this.regnow = false;
                    this.gs.regprom();
                }
            }
        }
        this.lxm = i;
        this.lym = i_239_;
        (control).enter = false;
        (control).exit = false;
    }
    
    public void hideinputs() {
        (this.gs).cmsg.hide();
        (this.gs).swait.hide();
        (this.gs).snpls.hide();
        (this.gs).snbts.hide();
        (this.gs).sgame.hide();
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
    
    public void drawSbutton(Image image, int i, int i_254_) {
        this.bx[this.btn] = i;
        this.by[this.btn] = i_254_;
        this.bw[this.btn] = image.getWidth(this.ob);
        if (!this.pessd[this.btn]) {
            this.rd.drawImage(image, i - this.bw[this.btn] / 2, i_254_ - image.getHeight(this.ob) / 2 - 1, null);
            this.rd.drawImage((this.xt).bols, i - this.bw[this.btn] / 2 - 15, i_254_ - 13, null);
            this.rd.drawImage((this.xt).bors, i + this.bw[this.btn] / 2 + 9, i_254_ - 13, null);
            this.rd.drawImage((this.xt).bot, i - this.bw[this.btn] / 2 - 9, i_254_ - 13, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage((this.xt).bob, i - this.bw[this.btn] / 2 - 9, i_254_ + 10, this.bw[this.btn] + 18, 3, null);
        } else {
            this.rd.drawImage(image, i - this.bw[this.btn] / 2 + 1, i_254_ - image.getHeight(this.ob) / 2, null);
            this.rd.drawImage((this.xt).bolps, i - this.bw[this.btn] / 2 - 15, i_254_ - 13, null);
            this.rd.drawImage((this.xt).borps, i + this.bw[this.btn] / 2 + 9, i_254_ - 13, null);
            this.rd.drawImage((this.xt).bob, i - this.bw[this.btn] / 2 - 9, i_254_ - 13, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage((this.xt).bot, i - this.bw[this.btn] / 2 - 9, i_254_ + 10, this.bw[this.btn] + 18, 3, null);
        }
        this.btn++;
    }
    
    public void stringbutton(String string, int i, int i_255_, int i_256_) {
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        this.bx[this.btn] = i;
        this.by[this.btn] = i_255_ - 5;
        this.bw[this.btn] = this.ftm.stringWidth(string);
        if (!this.pessd[this.btn]) {
            this.rd.setColor(color2k(220, 220, 220));
            this.rd.fillRect(i - this.bw[this.btn] / 2 - 10, i_255_ - (17 - i_256_), this.bw[this.btn] + 20, 25 - i_256_ * 2);
            this.rd.setColor(color2k(240, 240, 240));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ - (17 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ - (17 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ - (18 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ - (18 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_255_ - (19 - i_256_), i + this.bw[this.btn] / 2 + 9, i_255_ - (19 - i_256_));
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 10, i_255_ - (17 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ + (7 - i_256_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 11, i_255_ - (17 - i_256_), i + this.bw[this.btn] / 2 + 11, i_255_ + (7 - i_256_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 12, i_255_ - (16 - i_256_), i + this.bw[this.btn] / 2 + 12, i_255_ + (6 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ + (7 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ + (7 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ + (8 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ + (8 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_255_ + (9 - i_256_), i + this.bw[this.btn] / 2 + 9, i_255_ + (9 - i_256_));
            this.rd.setColor(color2k(240, 240, 240));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ - (17 - i_256_), i - this.bw[this.btn] / 2 - 10, i_255_ + (7 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 11, i_255_ - (17 - i_256_), i - this.bw[this.btn] / 2 - 11, i_255_ + (7 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 12, i_255_ - (16 - i_256_), i - this.bw[this.btn] / 2 - 12, i_255_ + (6 - i_256_));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, i - this.bw[this.btn] / 2, i_255_);
        } else {
            this.rd.setColor(color2k(210, 210, 210));
            this.rd.fillRect(i - this.bw[this.btn] / 2 - 10, i_255_ - (17 - i_256_), this.bw[this.btn] + 20, 25 - i_256_ * 2);
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ - (17 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ - (17 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ - (18 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ - (18 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_255_ - (19 - i_256_), i + this.bw[this.btn] / 2 + 9, i_255_ - (19 - i_256_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 10, i_255_ - (17 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ + (7 - i_256_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 11, i_255_ - (17 - i_256_), i + this.bw[this.btn] / 2 + 11, i_255_ + (7 - i_256_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 12, i_255_ - (16 - i_256_), i + this.bw[this.btn] / 2 + 12, i_255_ + (6 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ + (7 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ + (7 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ + (8 - i_256_), i + this.bw[this.btn] / 2 + 10, i_255_ + (8 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_255_ + (9 - i_256_), i + this.bw[this.btn] / 2 + 9, i_255_ + (9 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_255_ - (17 - i_256_), i - this.bw[this.btn] / 2 - 10, i_255_ + (7 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 11, i_255_ - (17 - i_256_), i - this.bw[this.btn] / 2 - 11, i_255_ + (7 - i_256_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 12, i_255_ - (16 - i_256_), i - this.bw[this.btn] / 2 - 12, i_255_ + (6 - i_256_));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, i - this.bw[this.btn] / 2 + 1, i_255_);
        }
        this.btn++;
    }
    
    public Color color2k(int i, int i_257_, int i_258_) {
        Color color = new Color(i, i_257_, i_258_);
        float[] fs = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
        fs[0] = 0.14F;
        fs[1] = 0.35F;
        return Color.getHSBColor(fs[0], fs[1], fs[2]);
    }
    
    public int getvalue(String string, int i) {
        int i_259_ = -1;
        try {
            int i_260_ = 0;
            int i_261_ = 0;
            int i_262_ = 0;
            String string_263_ = "";
            String string_264_ = "";
            for (/**/; i_260_ < string.length() && i_262_ != 2; i_260_++) {
                string_263_ = new StringBuilder().append("").append(string.charAt(i_260_)).toString();
                if (string_263_.equals("|")) {
                    i_261_++;
                    if (i_262_ == 1 || i_261_ > i)
                        i_262_ = 2;
                } else if (i_261_ == i) {
                    string_264_ = new StringBuilder().append(string_264_).append(string_263_).toString();
                    i_262_ = 1;
                }
            }
            if (string_264_.equals(""))
                string_264_ = "-1";
            i_259_ = Integer.valueOf(string_264_).intValue();
        } catch (Exception exception) {
            /* empty */
        }
        return i_259_;
    }
    
    public String getSvalue(String string, int i) {
        String string_265_ = "";
        try {
            int i_266_ = 0;
            int i_267_ = 0;
            int i_268_ = 0;
            String string_269_ = "";
            String string_270_ = "";
            for (/**/; i_266_ < string.length() && i_268_ != 2; i_266_++) {
                string_269_ = new StringBuilder().append("").append(string.charAt(i_266_)).toString();
                if (string_269_.equals("|")) {
                    i_267_++;
                    if (i_268_ == 1 || i_267_ > i)
                        i_268_ = 2;
                } else if (i_267_ == i) {
                    string_270_ = new StringBuilder().append(string_270_).append(string_269_).toString();
                    i_268_ = 1;
                }
            }
            string_265_ = string_270_;
        } catch (Exception exception) {
            /* empty */
        }
        return string_265_;
    }
    
    public String getSevervalue(String string, int i) {
        String string_271_ = "";
        if (!string.equals("")) {
            try {
                boolean bool = false;
                int i_272_ = 0;
                int i_273_ = 0;
                int i_274_ = 0;
                String string_275_ = "";
                String string_276_ = "";
                for (/**/; i_272_ < string.length() && i_274_ != 2; i_272_++) {
                    string_275_ = new StringBuilder().append("").append(string.charAt(i_272_)).toString();
                    if (string_275_.equals("|")) {
                        i_273_++;
                        if (i_274_ == 1 || i_273_ > i)
                            i_274_ = 2;
                    } else if (i_273_ == i) {
                        string_276_ = new StringBuilder().append(string_276_).append(string_275_).toString();
                        i_274_ = 1;
                    }
                }
                string_271_ = string_276_;
            } catch (Exception exception) {
                string_271_ = "";
            }
        }
        return string_271_;
    }
}
