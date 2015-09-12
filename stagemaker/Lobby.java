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
        m = medium;
        rd = graphics2d;
        xt = var_xtGraphics;
        cd = cardefine;
        gs = gamesparker;
        lg = login;
        gb = globe;
        (gs).cmsg.setBackground(color2k(255, 255, 255));
        (gs).swait.setBackground(color2k(220, 220, 220));
        (gs).snpls.setBackground(color2k(220, 220, 220));
        (gs).snbts.setBackground(color2k(220, 220, 220));
        (gs).sgame.setBackground(color2k(200, 200, 200));
        (gs).snfmm.setBackground(color2k(200, 200, 200));
        (gs).snfm1.setBackground(color2k(200, 200, 200));
        (gs).snfm2.setBackground(color2k(200, 200, 200));
        (gs).mstgs.setBackground(new Color(192, 223, 208));
        (gs).slaps.setBackground(color2k(200, 200, 200));
        (gs).sclass.setBackground(color2k(220, 220, 220));
        (gs).scars.setBackground(color2k(220, 220, 220));
        (gs).sfix.setBackground(color2k(220, 220, 220));
        (gs).mycar.setBackground(color2k(255, 255, 255));
        (gs).notp.setBackground(color2k(255, 255, 255));
        (gs).rooms.setBackground(color2k(170, 170, 170));
        (gs).swait.setForeground(new Color(0, 0, 0));
        (gs).snpls.setForeground(new Color(0, 0, 0));
        (gs).snbts.setForeground(new Color(0, 0, 0));
        (gs).sgame.setForeground(new Color(0, 0, 0));
        (gs).snfmm.setForeground(new Color(0, 0, 0));
        (gs).snfm1.setForeground(new Color(0, 0, 0));
        (gs).slaps.setForeground(new Color(0, 0, 0));
        (gs).snfm2.setForeground(new Color(0, 0, 0));
        (gs).mstgs.setForeground(new Color(0, 0, 0));
        (gs).sclass.setForeground(new Color(0, 0, 0));
        (gs).scars.setForeground(new Color(0, 0, 0));
        (gs).sfix.setForeground(new Color(0, 0, 0));
        (gs).mycar.setForeground(new Color(0, 0, 0));
        (gs).notp.setForeground(new Color(0, 0, 0));
        (gs).rooms.setForeground(new Color(0, 0, 0));
        (gs).sgame.removeAll();
        (gs).sgame.add(rd, " NFM Multiplayer ");
        (gs).sgame.add(rd, " NFM 2     ");
        (gs).sgame.add(rd, " NFM 1     ");
        (gs).sgame.add(rd, " My Stages ");
    }
    
    public void inishlobby() {
        (gs).tnick.hide();
        (gs).tpass.hide();
        (gs).temail.hide();
        hideinputs();
        (gs).mycar.setBackground(color2k(255, 255, 255));
        (gs).mycar.setForeground(new Color(0, 0, 0));
        (gs).rooms.removeAll();
        (gs).rooms.add(rd, new StringBuilder().append("").append((xt).servername).append(" :: ").append((xt).servport - 7070).append("").toString());
        (gs).rooms.select(0);
        gs.requestFocus();
        cd.loadready();
        for (int i = 0; i < 500; i++) {
            gnum[i] = -2;
            gstgn[i] = 0;
            gstages[i] = "";
            gnlaps[i] = 0;
            mnpls[i] = 0;
            mnbts[i] = 0;
            wait[i] = 0;
            gmaker[i] = "";
            gcrs[i] = 0;
            gclss[i] = 0;
            gfx[i] = 0;
            gntb[i] = 0;
            gplyrs[i] = "";
            npls[i] = 0;
        }
        for (int i = 0; i < 200; i++) {
            pnames[i] = "";
            pcars[i] = 0;
            pcarnames[i] = "";
            pgames[i] = -1;
            for (int i_0_ = 0; i_0_ < 6; i_0_++)
                pcols[i][i_0_] = 0.0F;
        }
        ongame = -1;
        join = -1;
        onjoin = -1;
        chalngd = -1;
        dispcar = -1;
        forcar = -1;
        chalby = "";
        im = 0;
        fstart = false;
        updatec = -1;
        prevloaded = -1;
        spos = 0;
        spos2 = 0;
        spos3 = 0;
        ngm = 0;
        npo = 0;
        fase = 1;
        lloaded = false;
        try {
            socket = new Socket((xt).server, (xt).servport);
            din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dout = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception exception) {
            /* empty */
        }
        conon = 1;
        connector = new Thread(this);
        connector.start();
    }
    
    public void run() {
        int i = -1;
        while (conon == 1) {
            if (!lloaded)
                gs.setCursor(new Cursor(3));
            if (!(xt).logged && !(xt).lan && (xt).nfreeplays - (xt).ndisco >= 5) {
                if (join >= 0) {
                    join = -1;
                    regnow = true;
                }
                if (pgames[im] != -1) {
                    join = -2;
                    regnow = true;
                }
            }
            if ((join >= 0 || pgames[im] != -1) && !regnow) {
                int i_1_ = -1;
                for (int i_2_ = 0; i_2_ < ngm; i_2_++) {
                    if (join == gnum[i_2_] || pgames[im] == gnum[i_2_])
                        i_1_ = i_2_;
                }
                if (i_1_ != -1) {
                    boolean bool = false;
                    ontyp = 0;
                    if (gcrs[i_1_] == 1 && pcars[im] < 16) {
                        bool = true;
                        ontyp = 10;
                        if (gclss[i_1_] > 0 && gclss[i_1_] <= 5)
                            ontyp += gclss[i_1_];
                    }
                    if (gcrs[i_1_] == 2 && pcars[im] >= 16) {
                        bool = true;
                        ontyp = 20;
                        if (gclss[i_1_] > 0 && gclss[i_1_] <= 5)
                            ontyp += gclss[i_1_];
                    }
                    if (gclss[i_1_] > 0 && gclss[i_1_] <= 5 && Math.abs((cd).cclass[pcars[im]] - (gclss[i_1_] - 1)) > 1) {
                        bool = true;
                        if (gcrs[i_1_] == 1)
                            ontyp = 10;
                        if (gcrs[i_1_] == 2)
                            ontyp = 20;
                        ontyp += gclss[i_1_];
                    }
                    if (gclss[i_1_] <= -2 && pcars[im] != Math.abs(gclss[i_1_] + 2)) {
                        bool = true;
                        ontyp = gclss[i_1_];
                    }
                    if (gstgn[i_1_] == -2 && !(xt).logged) {
                        bool = true;
                        ontyp = 76;
                    }
                    if (bool) {
                        onjoin = gnum[i_1_];
                        jflexo = false;
                        if (join >= 0)
                            join = -1;
                        if (pgames[im] != -1)
                            join = -2;
                    }
                }
            }
            if ((xt).onjoin != -1) {
                join = (xt).onjoin;
                ongame = (xt).onjoin;
                (xt).onjoin = -1;
            }
            if (updatec < -17)
                updatec = -17;
            boolean bool = false;
            if (lloaded) {
                i = pgames[im];
                if (i != -1) {
                    for (int i_3_ = 0; i_3_ < ngm; i_3_++) {
                        if (i == gnum[i_3_]) {
                            laps = gnlaps[i_3_];
                            stage = gstgn[i_3_];
                            stagename = gstages[i_3_];
                            nfix = gfx[i_3_];
                            if (gntb[i_3_] == 1)
                                notb = true;
                            else
                                notb = false;
                        }
                    }
                }
            }
            String string = new StringBuilder().append("").append((xt).sc[0]).append("").toString();
            if ((xt).sc[0] >= 16)
                string = new StringBuilder().append("C").append((cd).names[(xt).sc[0]]).append("").toString();
            String string_4_ = new StringBuilder().append("1|").append((xt).nickname).append(":").append((xt).nickey).append("|").append(string).append("|").append(join).append("|").append((int) ((xt).arnp[0] * 100.0F)).append("|").append((int) ((xt).arnp[1] * 100.0F)).append("|").append((int) ((xt).arnp[2] * 100.0F)).append("|").append((int) ((xt).arnp[3] * 100.0F)).append("|").append((int) ((xt).arnp[4] * 100.0F)).append("|").append((int) ((xt).arnp[5] * 100.0F)).append("|").append(ongame).append("|").toString();
            if (!(xt).lan) {
                string_4_ = new StringBuilder().append(string_4_).append("").append(updatec).append("|").toString();
                if (updatec <= -11) {
                    for (int i_5_ = 0; i_5_ < -updatec - 10; i_5_++)
                        string_4_ = new StringBuilder().append(string_4_).append("").append(cnames[6 - i_5_]).append("|").append(sentn[6 - i_5_]).append("|").toString();
                    updatec = -2;
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
                if ((xt).logged)
                    i_7_ = 1;
                string_4_ = new StringBuilder().append(string_4_).append("").append(string_6_).append("|").append(i_7_).append("|").toString();
            }
            if (fstart) {
                string_4_ = new StringBuilder().append(string_4_).append("3|").toString();
                bool = true;
            }
            if (chalngd == -5 && !fstart) {
                string_4_ = new StringBuilder().append(string_4_).append("11|").append(gstage).append("|").append(gstagename).append("|").append(gstagelaps).append("|").append(gnpls).append("|").append(gwait).append("|").append(pnames[im]).append("|").append(gcars).append("|").append(gclass).append("|").append(gfix).append("|").append(gnotp).append("|").append(gplayers).append("|").toString();
                if ((xt).lan)
                    string_4_ = new StringBuilder().append(string_4_).append("").append(gnbts).append("|").toString();
            }
            if (ongame != -1 && chalngd != -5 && !fstart) {
                boolean bool_8_ = false;
                for (int i_9_ = 0; i_9_ < 7; i_9_++) {
                    if (!invos[i_9_].equals("") && !dinvi[i_9_].equals(invos[i_9_])) {
                        if (!bool_8_) {
                            string_4_ = new StringBuilder().append(string_4_).append("2|").append(ongame).append("|").toString();
                            bool_8_ = true;
                        }
                        string_4_ = new StringBuilder().append(string_4_).append("").append(invos[i_9_]).append("|").toString();
                        dinvi[i_9_] = invos[i_9_];
                    }
                }
            }
            String string_10_ = "";
            boolean bool_11_ = false;
            try {
                dout.println(string_4_);
                string_10_ = din.readLine();
                if (string_10_ == null)
                    bool_11_ = true;
            } catch (Exception exception) {
                bool_11_ = true;
            }
            if (bool_11_) {
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
                    socket = new Socket((xt).server, (xt).servport);
                    din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    dout = new PrintWriter(socket.getOutputStream(), true);
                    dout.println(string_4_);
                    string_10_ = din.readLine();
                    if (string_10_ != null)
                        bool_11_ = false;
                } catch (Exception exception) {
                    /* empty */
                }
            }
            if (bool_11_) {
                try {
                    socket.close();
                    socket = null;
                } catch (Exception exception) {
                    /* empty */
                }
                conon = 0;
                lg.exitfromlobby();
                hideinputs();
                connector.stop();
            }
            if (regnow && join == -2)
                join = -1;
            npo = getvalue(string_10_, 0);
            if (npo < 0)
                npo = 0;
            im = getvalue(string_10_, 1);
            if (im < 0)
                im = 0;
            for (int i_12_ = 0; i_12_ < npo; i_12_++) {
                pnames[i_12_] = getSvalue(string_10_, 2 + i_12_ * 9);
                if (pnames[i_12_].equals(""))
                    pnames[i_12_] = "Unknown";
                String string_13_ = getSvalue(string_10_, 3 + i_12_ * 9);
                if (string_13_.startsWith("C")) {
                    pcarnames[i_12_] = string_13_.substring(1);
                    if (!pcarnames[i_12_].equals("")) {
                        int i_14_ = 0;
                        for (int i_15_ = 16; i_15_ < 56; i_15_++) {
                            if (pcarnames[i_12_].equals((cd).names[i_15_])) {
                                i_14_ = i_15_;
                                break;
                            }
                        }
                        if (i_14_ == 0) {
                            pcars[i_12_] = -1;
                            boolean bool_16_ = false;
                            for (int i_17_ = 0; i_17_ < (cd).nl; i_17_++) {
                                if (pcarnames[i_12_].equals((cd).loadnames[i_17_]))
                                    bool_16_ = true;
                            }
                            if (!bool_16_ && (cd).nl < 20 && (cd).nl >= 0) {
                                (cd).loadnames[(cd).nl] = pcarnames[i_12_];
                                (cd).nl++;
                            }
                            cd.sparkcarloader();
                        } else
                            pcars[i_12_] = i_14_;
                    } else {
                        pcars[i_12_] = 0;
                        pcarnames[i_12_] = (cd).names[pcars[i_12_]];
                    }
                } else {
                    pcars[i_12_] = getvalue(string_10_, 3 + i_12_ * 9);
                    if (pcars[i_12_] <= -1)
                        pcars[i_12_] = 0;
                    pcarnames[i_12_] = (cd).names[pcars[i_12_]];
                }
                pgames[i_12_] = getvalue(string_10_, 4 + i_12_ * 9);
                pcols[i_12_][0] = (float) getvalue(string_10_, 5 + i_12_ * 9) / 100.0F;
                if (pcols[i_12_][0] <= -1.0F)
                    pcols[i_12_][0] = 0.0F;
                pcols[i_12_][1] = (float) getvalue(string_10_, 6 + i_12_ * 9) / 100.0F;
                if (pcols[i_12_][1] <= -1.0F)
                    pcols[i_12_][1] = 0.0F;
                pcols[i_12_][2] = (float) getvalue(string_10_, 7 + i_12_ * 9) / 100.0F;
                if (pcols[i_12_][2] <= -1.0F)
                    pcols[i_12_][2] = 0.0F;
                pcols[i_12_][3] = (float) getvalue(string_10_, 8 + i_12_ * 9) / 100.0F;
                if (pcols[i_12_][3] <= -1.0F)
                    pcols[i_12_][3] = 0.0F;
                pcols[i_12_][4] = (float) getvalue(string_10_, 9 + i_12_ * 9) / 100.0F;
                if (pcols[i_12_][4] <= -1.0F)
                    pcols[i_12_][4] = 0.0F;
                pcols[i_12_][5] = (float) getvalue(string_10_, 10 + i_12_ * 9) / 100.0F;
                if (pcols[i_12_][5] <= -1.0F)
                    pcols[i_12_][5] = 0.0F;
            }
            int i_18_ = 11 + (npo - 1) * 9;
            ngm = getvalue(string_10_, i_18_);
            if (ngm < 0)
                ngm = 0;
            int i_19_ = 12;
            if ((xt).lan)
                i_19_ = 13;
            for (int i_20_ = 0; i_20_ < ngm; i_20_++) {
                gnum[i_20_] = getvalue(string_10_, i_18_ + 1 + i_20_ * i_19_);
                gstgn[i_20_] = getvalue(string_10_, i_18_ + 2 + i_20_ * i_19_);
                gstgn[i_20_] = Math.abs(gstgn[i_20_]);
                if (gstgn[i_20_] > 100)
                    gstgn[i_20_] = -2;
                gstages[i_20_] = getSvalue(string_10_, i_18_ + 3 + i_20_ * i_19_);
                gnlaps[i_20_] = getvalue(string_10_, i_18_ + 4 + i_20_ * i_19_);
                mnpls[i_20_] = getvalue(string_10_, i_18_ + 5 + i_20_ * i_19_);
                wait[i_20_] = getvalue(string_10_, i_18_ + 6 + i_20_ * i_19_);
                gmaker[i_20_] = getSvalue(string_10_, i_18_ + 7 + i_20_ * i_19_);
                gcrs[i_20_] = getvalue(string_10_, i_18_ + 8 + i_20_ * i_19_);
                gclss[i_20_] = getvalue(string_10_, i_18_ + 9 + i_20_ * i_19_);
                gfx[i_20_] = getvalue(string_10_, i_18_ + 10 + i_20_ * i_19_);
                gntb[i_20_] = getvalue(string_10_, i_18_ + 11 + i_20_ * i_19_);
                gplyrs[i_20_] = getSvalue(string_10_, i_18_ + 12 + i_20_ * i_19_);
                if ((xt).lan)
                    mnbts[i_20_] = getvalue(string_10_, i_18_ + 13 + i_20_ * i_19_);
                if ((xt).playingame > -1 && (xt).playingame == gnum[i_20_] && !(xt).lan)
                    ongame = gnum[i_20_];
                if (i == gnum[i_20_] && wait[i_20_] == 0 && lloaded && i != -1) {
                    for (int i_21_ = 0; i_21_ < npo; i_21_++) {
                        if (pgames[i_21_] == gnum[i_20_] && pnames[i_21_].equals((xt).nickname)) {
                            im = i_21_;
                            break;
                        }
                    }
                    conon = 2;
                    gs.setCursor(new Cursor(3));
                }
            }
            for (int i_22_ = 0; i_22_ < ngm; i_22_++) {
                npls[i_22_] = 0;
                for (int i_23_ = 0; i_23_ < npo; i_23_++) {
                    if (pgames[i_23_] == gnum[i_22_])
                        npls[i_22_]++;
                }
            }
            if (conon != 0 && (xt).playingame != -1)
                (xt).playingame = -1;
            if (ongame != -1) {
                boolean bool_24_ = false;
                for (int i_25_ = 0; i_25_ < ngm; i_25_++) {
                    if (ongame == gnum[i_25_])
                        bool_24_ = true;
                }
                if (!bool_24_)
                    britchl = -1;
            }
            if (join > -1) {
                boolean bool_26_ = false;
                for (int i_27_ = 0; i_27_ < ngm; i_27_++) {
                    if (join == gnum[i_27_])
                        bool_26_ = true;
                }
                if (!bool_26_)
                    join = -1;
            }
            for (int i_28_ = 0; i_28_ < npo; i_28_++) {
                if (pgames[i_28_] != -1) {
                    boolean bool_29_ = false;
                    for (int i_30_ = 0; i_30_ < ngm; i_30_++) {
                        if (pgames[i_28_] == gnum[i_30_])
                            bool_29_ = true;
                    }
                    if (!bool_29_)
                        pgames[i_28_] = -1;
                }
            }
            if ((xt).lan)
                i_18_ += 14 + (ngm - 1) * 13;
            else
                i_18_ += 13 + (ngm - 1) * 12;
            if (!(xt).lan) {
                int i_31_ = getvalue(string_10_, i_18_);
                int i_32_ = getvalue(string_10_, i_18_ + 1);
                i_18_ += 2;
                if (updatec != i_31_ && updatec >= -2 && i_32_ == ongame) {
                    for (int i_33_ = 0; i_33_ < 7; i_33_++) {
                        cnames[i_33_] = getSvalue(string_10_, i_18_ + i_33_ * 2);
                        sentn[i_33_] = getSvalue(string_10_, i_18_ + 1 + i_33_ * 2);
                    }
                    updatec = i_31_;
                    if (ongame <= -1)
                        spos3 = 28;
                    i_18_ += 14;
                }
                if (ongame != -1) {
                    if (prevloaded != -1)
                        prevloaded = -1;
                    boolean bool_34_ = false;
                    for (int i_35_ = 0; i_35_ < ngm; i_35_++) {
                        if (ongame == gnum[i_35_] && wait[i_35_] <= 0)
                            bool_34_ = true;
                    }
                    if (bool_34_) {
                        prevloaded = getvalue(string_10_, i_18_);
                        i_18_++;
                        if (prevloaded == 1) {
                            prnpo = getvalue(string_10_, i_18_);
                            i_18_++;
                            for (int i_36_ = 0; i_36_ < prnpo; i_36_++) {
                                prnames[i_36_] = getSvalue(string_10_, i_18_);
                                i_18_++;
                            }
                            for (int i_37_ = 0; i_37_ < prnpo; i_37_++) {
                                ppos[i_37_] = getvalue(string_10_, i_18_);
                                i_18_++;
                            }
                            for (int i_38_ = 0; i_38_ < prnpo; i_38_++) {
                                plap[i_38_] = getvalue(string_10_, i_18_);
                                i_18_++;
                            }
                            for (int i_39_ = 0; i_39_ < prnpo; i_39_++) {
                                ppow[i_39_] = (int) ((float) getvalue(string_10_, i_18_) / 9800.0F * 55.0F);
                                i_18_++;
                            }
                            for (int i_40_ = 0; i_40_ < prnpo; i_40_++) {
                                int i_41_ = getvalue(string_10_, i_18_);
                                if (i_41_ != -17)
                                    pdam[i_40_] = (int) ((float) i_41_ / 100.0F * 55.0F);
                                else
                                    pdam[i_40_] = -17;
                                i_18_++;
                            }
                        }
                    }
                }
            } else {
                int i_42_ = getvalue(string_10_, i_18_);
                if (i_42_ == 1)
                    lanlogged = true;
                //else
                //    lanlogged = false;
                i_18_++;
            }
            int i_43_ = getvalue(string_10_, i_18_);
            if (i_43_ != -1) {
                int i_44_ = 0;
                for (int i_45_ = 0; i_45_ < ngm; i_45_++) {
                    if (i_43_ == gnum[i_45_])
                        i_44_ = i_45_;
                }
                if ((pgames[im] != ongame || ongame <= -1) && i_43_ != ongame && chalngd <= -1 && join <= -1 && fase == 1 && wait[i_44_] > 0) {
                    chalngd = i_43_;
                    chalby = getSvalue(string_10_, i_18_ + 1);
                    cflk = 20;
                    ctime = 20;
                    ptime = 0L;
                    longame = ongame;
                    if (((gs).rooms).open)
                        ((gs).rooms).open = false;
                    if (ongame != -1)
                        britchl = -1;
                }
                i_18_++;
            }
            if (!(xt).lan) {
                int i_46_ = 1;
                for (int i_47_ = 1; i_47_ < 6; i_47_++) {
                    if (i_47_ != (xt).servport - 7070) {
                        int i_48_ = getvalue(string_10_, i_18_ + i_47_);
                        if (i_48_ != -1) {
                            if (i_48_ > 10)
                                i_48_ = 10;
                            ((gs).rooms).sopts[i_46_] = new StringBuilder().append("Room ").append(i_47_).append(" :   ").append(i_48_).append(" / 10").toString();
                            if (i_48_ == 10)
                                ((gs).rooms).opts[i_46_] = "full";
                            else
                                ((gs).rooms).opts[i_46_] = "";
                            ((gs).rooms).iroom[i_46_] = i_47_;
                            i_46_++;
                        }
                    }
                }
                ((gs).rooms).no = i_46_;
            }
            if (join > -1) {
                boolean bool_49_ = false;
                for (int i_50_ = 0; i_50_ < ngm; i_50_++) {
                    if (join == gnum[i_50_] && wait[i_50_] == 0)
                        bool_49_ = true;
                }
                if (pgames[im] == join || bool_49_) {
                    join = -1;
                    nflk = 3;
                }
            }
            if (join == -2) {
                boolean bool_51_ = false;
                for (int i_52_ = 0; i_52_ < ngm; i_52_++) {
                    if (pgames[im] == gnum[i_52_] && wait[i_52_] == 0)
                        bool_51_ = true;
                }
                if (pgames[im] <= -1 || bool_51_) {
                    join = -1;
                    if (!bool_51_)
                        ongame = -1;
                }
            }
            if (chalngd == -5 && pgames[im] != -1) {
                ongame = pgames[im];
                chalngd = -1;
            }
            if (fstart && bool)
                fstart = false;
            rerr = 0;
            if (!lloaded) {
                gs.setCursor(new Cursor(0));
                lloaded = true;
            }
            gb.roomlogos(pnames, npo);
            try {
                if (connector != null) {
                    /* empty */
                }
                Thread.sleep(600L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        if (conon == 2) {
            int i_53_ = 20;
            (xt).playingame = -1;
            while (i_53_ != 0) {
                String string = new StringBuilder().append("2|").append(i).append("|").toString();
                String string_54_ = "";
                boolean bool = false;
                try {
                    dout.println(string);
                    string_54_ = din.readLine();
                    if (string_54_ == null)
                        bool = true;
                } catch (Exception exception) {
                    bool = true;
                }
                if (bool) {
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
                        socket = new Socket((xt).server, (xt).servport);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println(string);
                        string_54_ = din.readLine();
                        if (string_54_ != null)
                            bool = false;
                    } catch (Exception exception) {
                        /* empty */
                    }
                }
                if (bool) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (Exception exception) {
                        /* empty */
                    }
                    conon = 0;
                    lg.exitfromlobby();
                    hideinputs();
                    connector.stop();
                }
                if (!(xt).lan)
                    (xt).gameport = getvalue(string_54_, 0);
                else {
                    (xt).gameport = -1;
                    (xt).localserver = getSevervalue(string_54_, 0);
                    if (!(xt).localserver.equals(""))
                        (xt).gameport = 0;
                }
                if ((xt).gameport != -1) {
                    int i_55_ = 0;
                    (xt).im = -1;
                    (xt).nplayers = getvalue(string_54_, 1);
                    if ((xt).nplayers < 1)
                        (xt).nplayers = 1;
                    if ((xt).nplayers > 7)
                        (xt).nplayers = 7;
                    for (int i_56_ = 0; i_56_ < (xt).nplayers; i_56_++) {
                        (xt).plnames[i_56_] = getSvalue(string_54_, 2 + i_56_);
                        if ((xt).nickname.equals((xt).plnames[i_56_]))
                            (xt).im = i_56_;
                    }
                    int i_57_ = 2 + (xt).nplayers;
                    for (int i_58_ = 0; i_58_ < (xt).nplayers; i_58_++) {
                        String string_59_ = getSvalue(string_54_, i_57_ + i_58_);
                        if (string_59_.startsWith("C")) {
                            string_59_ = string_59_.substring(1);
                            if (!string_59_.equals("")) {
                                int i_60_ = 0;
                                for (int i_61_ = 16; i_61_ < 56; i_61_++) {
                                    if (string_59_.equals((cd).names[i_61_])) {
                                        i_60_ = i_61_;
                                        break;
                                    }
                                }
                                for (/**/; i_60_ == 0 && i_55_ < 100; i_55_++) {
                                    boolean bool_62_ = false;
                                    for (int i_63_ = 0; i_63_ < (cd).nl; i_63_++) {
                                        if (string_59_.equals((cd).loadnames[i_63_]))
                                            bool_62_ = true;
                                    }
                                    if (!bool_62_ && (cd).nl < 20) {
                                        (cd).loadnames[(cd).nl] = string_59_;
                                        (cd).nl++;
                                    }
                                    cd.sparkcarloader();
                                    try {
                                        if (connector != null) {
                                            /* empty */
                                        }
                                        Thread.sleep(100L);
                                    } catch (InterruptedException interruptedexception) {
                                        /* empty */
                                    }
                                    for (int i_64_ = 16; i_64_ < 56; i_64_++) {
                                        if (string_59_.equals((cd).names[i_64_]))
                                            i_60_ = i_64_;
                                    }
                                }
                                if (i_60_ != 0) {
                                    (xt).sc[i_58_] = i_60_;
                                    for (int i_65_ = 0; i_65_ < npo; i_65_++) {
                                        if (pcarnames[i_65_].equals(string_59_))
                                            pcars[i_65_] = i_60_;
                                    }
                                } else
                                    (xt).im = -1;
                            } else
                                (xt).im = -1;
                        } else {
                            (xt).sc[i_58_] = getvalue(string_54_, i_57_ + i_58_);
                            if ((xt).sc[i_58_] <= -1)
                                (xt).im = -1;
                        }
                    }
                    i_57_ += (xt).nplayers;
                    for (int i_66_ = 0; i_66_ < (xt).nplayers; i_66_++)
                        (xt).xstart[i_66_] = getvalue(string_54_, i_57_ + i_66_);
                    i_57_ += (xt).nplayers;
                    for (int i_67_ = 0; i_67_ < (xt).nplayers; i_67_++)
                        (xt).zstart[i_67_] = getvalue(string_54_, i_57_ + i_67_);
                    i_57_ += (xt).nplayers;
                    for (int i_68_ = 0; i_68_ < (xt).nplayers; i_68_++) {
                        for (int i_69_ = 0; i_69_ < 6; i_69_++)
                            (xt).allrnp[i_68_][i_69_] = (float) getvalue(string_54_, i_57_ + i_68_ * 6 + i_69_) / 100.0F;
                    }
                    if ((xt).im <= -1) {
                        (xt).playingame = -1;
                        (xt).im = 0;
                    } else
                        (xt).playingame = i;
                    i_53_ = 0;
                } else
                    i_53_--;
                try {
                    if (connector != null) {
                        /* empty */
                    }
                    Thread.sleep(1000L);
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
            }
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
            if ((xt).playingame != -1) {
                if (!(xt).lan && !(xt).logged) {
                    try {
                        socket = new Socket((lg).servers[0], 7061);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println(new StringBuilder().append("7|").append((xt).nfreeplays).append("|").toString());
                        String string = din.readLine();
                        (xt).hours = getvalue(string, 0);
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
                hideinputs();
                (xt).multion = 1;
                fase = 76;
                System.gc();
            } else
                inishlobby();
        }
        if (conon == 3) {
            int i_70_ = 20;
            (xt).playingame = -1;
            while (i_70_ != 0) {
                String string = new StringBuilder().append("4|").append(ongame).append("|").toString();
                String string_71_ = "";
                boolean bool = false;
                try {
                    dout.println(string);
                    string_71_ = din.readLine();
                    if (string_71_ == null)
                        bool = true;
                } catch (Exception exception) {
                    bool = true;
                }
                if (bool) {
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
                        socket = new Socket((xt).server, (xt).servport);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println(string);
                        string_71_ = din.readLine();
                        if (string_71_ != null)
                            bool = false;
                    } catch (Exception exception) {
                        /* empty */
                    }
                }
                if (bool) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (Exception exception) {
                        /* empty */
                    }
                    conon = 0;
                    lg.exitfromlobby();
                    hideinputs();
                    connector.stop();
                }
                if (!(xt).lan)
                    (xt).gameport = getvalue(string_71_, 0);
                else {
                    (xt).gameport = -1;
                    (xt).localserver = getSevervalue(string_71_, 0);
                    if (!(xt).localserver.equals(""))
                        (xt).gameport = 0;
                }
                if ((xt).gameport != -1) {
                    int i_72_ = 0;
                    (xt).nplayers = getvalue(string_71_, 1);
                    if ((xt).nplayers < 1)
                        (xt).nplayers = 1;
                    if ((xt).nplayers > 7)
                        (xt).nplayers = 7;
                    (xt).im = getvalue(string_71_, 2) + (xt).nplayers;
                    for (int i_73_ = 0; i_73_ < (xt).nplayers; i_73_++)
                        (xt).plnames[i_73_] = getSvalue(string_71_, 3 + i_73_);
                    int i_74_ = 3 + (xt).nplayers;
                    for (int i_75_ = 0; i_75_ < (xt).nplayers; i_75_++) {
                        String string_76_ = getSvalue(string_71_, i_74_ + i_75_);
                        if (string_76_.startsWith("C")) {
                            string_76_ = string_76_.substring(1);
                            if (!string_76_.equals("")) {
                                int i_77_ = 0;
                                for (int i_78_ = 16; i_78_ < 56; i_78_++) {
                                    if (string_76_.equals((cd).names[i_78_])) {
                                        i_77_ = i_78_;
                                        break;
                                    }
                                }
                                for (/**/; i_77_ == 0 && i_72_ < 100; i_72_++) {
                                    boolean bool_79_ = false;
                                    for (int i_80_ = 0; i_80_ < (cd).nl; i_80_++) {
                                        if (string_76_.equals((cd).loadnames[i_80_]))
                                            bool_79_ = true;
                                    }
                                    if (!bool_79_ && (cd).nl < 20) {
                                        (cd).loadnames[(cd).nl] = string_76_;
                                        (cd).nl++;
                                    }
                                    cd.sparkcarloader();
                                    try {
                                        if (connector != null) {
                                            /* empty */
                                        }
                                        Thread.sleep(100L);
                                    } catch (InterruptedException interruptedexception) {
                                        /* empty */
                                    }
                                    for (int i_81_ = 16; i_81_ < 56; i_81_++) {
                                        if (string_76_.equals((cd).names[i_81_]))
                                            i_77_ = i_81_;
                                    }
                                }
                                if (i_77_ != 0) {
                                    (xt).sc[i_75_] = i_77_;
                                    for (int i_82_ = 0; i_82_ < npo; i_82_++) {
                                        if (pcarnames[i_82_].equals(string_76_))
                                            pcars[i_82_] = i_77_;
                                    }
                                } else
                                    (xt).im = -1;
                            } else
                                (xt).im = -1;
                        } else {
                            (xt).sc[i_75_] = getvalue(string_71_, i_74_ + i_75_);
                            if ((xt).sc[i_75_] <= -1)
                                (xt).im = -1;
                        }
                    }
                    i_74_ += (xt).nplayers;
                    for (int i_83_ = 0; i_83_ < (xt).nplayers; i_83_++)
                        (xt).xstart[i_83_] = getvalue(string_71_, i_74_ + i_83_);
                    i_74_ += (xt).nplayers;
                    for (int i_84_ = 0; i_84_ < (xt).nplayers; i_84_++)
                        (xt).zstart[i_84_] = getvalue(string_71_, i_74_ + i_84_);
                    i_74_ += (xt).nplayers;
                    for (int i_85_ = 0; i_85_ < (xt).nplayers; i_85_++) {
                        for (int i_86_ = 0; i_86_ < 6; i_86_++)
                            (xt).allrnp[i_85_][i_86_] = (float) getvalue(string_71_, i_74_ + i_85_ * 6 + i_86_) / 100.0F;
                    }
                    if ((xt).im >= (xt).nplayers && (xt).im < (xt).nplayers + 3)
                        (xt).playingame = ongame;
                    else {
                        (xt).playingame = -1;
                        (xt).im = 0;
                    }
                    i_70_ = 0;
                } else
                    i_70_--;
                try {
                    if (connector != null) {
                        /* empty */
                    }
                    Thread.sleep(1000L);
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
            }
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
            if ((xt).playingame != -1) {
                hideinputs();
                (xt).multion = 3;
                fase = 76;
                System.gc();
            } else
                inishlobby();
        }
    }
    
    public void stopallnow() {
        conon = 0;
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
        if (connector != null) {
            connector.stop();
            connector = null;
        }
    }
    
    public void lobby(int i, int i_87_, boolean bool, int i_88_, CheckPoints checkpoints, Control control, ContO[] contos) {
        pre1 = false;
        pre2 = false;
        int i_89_ = 0;
        if ((xt).warning == 0 || (xt).warning == 210) {
            if (!regnow) {
                if (onjoin <= -1) {
                    xt.mainbg(3);
                    if (britchl <= -1) {
                        ongame = -1;
                        britchl = 0;
                    }
                    btn = 0;
                    pbtn = 0;
                    zeromsw = false;
                    int i_90_ = npo;
                    if (invo) {
                        i_90_ = 0;
                        for (int i_91_ = 0; i_91_ < npo; i_91_++) {
                            if (pgames[i_91_] <= -1)
                                i_90_++;
                        }
                        i_90_ += 2;
                    }
                    int i_92_ = (i_90_ - 11) * 30;
                    if (i_92_ < 0)
                        i_92_ = 0;
                    int i_93_ = (int) ((float) spos / 295.0F * (float) i_92_);
                    int i_94_ = 0;
                    int i_95_ = -1;
                    int i_96_ = -1;
                    if (conon == 1) {
                        if (!invo) {
                            for (int i_97_ = 0; i_97_ < npo; i_97_++) {
                                if (pgames[i_97_] != -1) {
                                    int i_98_ = 0;
                                    for (int i_99_ = 0; i_99_ < ngm; i_99_++) {
                                        if (pgames[i_97_] == gnum[i_99_])
                                            i_98_ = i_99_;
                                    }
                                    if (wait[i_98_] > 0) {
                                        if (82 + 30 * i_94_ - i_93_ > 50 && 82 + 30 * (i_94_ - 1) - i_93_ < 415) {
                                            boolean bool_100_ = false;
                                            if (i > 70 && i < 185 && i_87_ > 52 + 30 * i_94_ - i_93_ && i_87_ < 82 + 30 * i_94_ - i_93_) {
                                                if (pgames[im] <= -1 && join <= -1 && chalngd >= -1) {
                                                    if (bool || mousonp == i_97_) {
                                                        rd.setColor(color2k(255, 255, 255));
                                                        mousonp = i_97_;
                                                        i_96_ = 52 + 30 * i_94_ - i_93_;
                                                        if (bool) {
                                                            if (cmonp == i_97_)
                                                                ongame = pgames[i_97_];
                                                            chalngd = -1;
                                                        } else {
                                                            if (cmonp <= -1) {
                                                                ongame = -1;
                                                                cmonp = i_97_;
                                                            }
                                                            if (ongame == pgames[i_97_])
                                                                mousonp = -1;
                                                        }
                                                    } else
                                                        rd.setColor(color2k(220, 220, 220));
                                                    rd.fillRect(70, 53 + 30 * i_94_ - i_93_, 116, 29);
                                                    i_95_ = i_97_;
                                                }
                                                bool_100_ = true;
                                            }
                                            if (pgames[im] <= -1 && join <= -1 && chalngd >= -1)
                                                rd.setColor(new Color(49, 79, 0));
                                            else
                                                rd.setColor(new Color(34, 55, 0));
                                            boolean bool_101_ = gb.drawl(pnames[i_97_], 68, 53 + 30 * i_94_ - i_93_, bool_100_);
                                            if (!bool_100_ || !bool_101_) {
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString(pnames[i_97_], 127 - ftm.stringWidth(pnames[i_97_]) / 2, 66 + 30 * i_94_ - i_93_);
                                                rd.setFont(new Font("Arial", 0, 10));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString(pcarnames[i_97_], 127 - ftm.stringWidth(pcarnames[i_97_]) / 2, 78 + 30 * i_94_ - i_93_);
                                            }
                                            rd.setColor(color2k(150, 150, 150));
                                            rd.drawLine(70, 82 + 30 * i_94_ - i_93_, 185, 82 + 30 * i_94_ - i_93_);
                                        }
                                        i_94_++;
                                    }
                                }
                            }
                        }
                        if (invo) {
                            rd.setColor(new Color(0, 0, 0));
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            rd.drawString("Free Players", 127 - ftm.stringWidth("Free Players") / 2, 75 - i_93_);
                            rd.setFont(new Font("Arial", 0, 10));
                            ftm = rd.getFontMetrics();
                            rd.drawString("Click a player to invite:", 127 - ftm.stringWidth("Click a player to invite:") / 2, 92 - i_93_);
                            rd.setColor(color2k(150, 150, 150));
                            rd.drawLine(70, 112 - i_93_, 185, 112 - i_93_);
                            i_94_ += 2;
                        }
                        for (int i_102_ = 0; i_102_ < npo; i_102_++) {
                            boolean bool_103_ = false;
                            if (invo) {
                                if (im == i_102_)
                                    bool_103_ = true;
                                for (int i_104_ = 0; i_104_ < 7; i_104_++) {
                                    if (invos[i_104_].equals(pnames[i_102_]) && !bool_103_)
                                        bool_103_ = true;
                                }
                            }
                            if (pgames[i_102_] <= -1 && !bool_103_) {
                                if (82 + 30 * i_94_ - i_93_ > 50 && 82 + 30 * (i_94_ - 1) - i_93_ < 415) {
                                    boolean bool_105_ = false;
                                    if (i > 70 && i < 185 && i_87_ > 52 + 30 * i_94_ - i_93_ && i_87_ < 82 + 30 * i_94_ - i_93_) {
                                        if (invo) {
                                            if (bool) {
                                                rd.setColor(color2k(255, 255, 255));
                                                mousonp = i_102_;
                                            } else {
                                                rd.setColor(color2k(220, 220, 220));
                                                if (mousonp == i_102_) {
                                                    int i_106_ = 0;
                                                    for (boolean bool_107_ = false; i_106_ < 7 && !bool_107_; i_106_++) {
                                                        if (invos[i_106_].equals("")) {
                                                            invos[i_106_] = pnames[i_102_];
                                                            bool_107_ = true;
                                                        }
                                                    }
                                                    mousonp = -1;
                                                    invo = false;
                                                }
                                            }
                                            rd.fillRect(70, 53 + 30 * i_94_ - i_93_, 116, 29);
                                            i_95_ = i_102_;
                                        } else if (pgames[im] <= -1 && join <= -1 && chalngd >= -1) {
                                            i_89_ = 12;
                                            if (bool) {
                                                if (!(gb).proname.equals(pnames[i_102_])) {
                                                    (gb).proname = pnames[i_102_];
                                                    (gb).loadedp = false;
                                                }
                                                (gb).tab = 1;
                                                (gb).open = 2;
                                                (gb).upo = true;
                                            }
                                        }
                                        bool_105_ = true;
                                    }
                                    if (invo)
                                        rd.setColor(new Color(62, 98, 0));
                                    else
                                        rd.setColor(new Color(0, 0, 0));
                                    boolean bool_108_ = gb.drawl(pnames[i_102_], 68, 53 + 30 * i_94_ - i_93_, bool_105_);
                                    if (!bool_105_ || !bool_108_) {
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(pnames[i_102_], 127 - ftm.stringWidth(pnames[i_102_]) / 2, 66 + 30 * i_94_ - i_93_);
                                        rd.setFont(new Font("Arial", 0, 10));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(pcarnames[i_102_], 127 - ftm.stringWidth(pcarnames[i_102_]) / 2, 78 + 30 * i_94_ - i_93_);
                                    }
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(70, 82 + 30 * i_94_ - i_93_, 185, 82 + 30 * i_94_ - i_93_);
                                }
                                i_94_++;
                            }
                        }
                        if (invo && i_94_ == 2)
                            invo = false;
                        if (!invo) {
                            for (int i_109_ = npo - 1; i_109_ >= 0; i_109_--) {
                                if (pgames[i_109_] != -1) {
                                    int i_110_ = 0;
                                    for (int i_111_ = 0; i_111_ < ngm; i_111_++) {
                                        if (pgames[i_109_] == gnum[i_111_])
                                            i_110_ = i_111_;
                                    }
                                    if (wait[i_110_] <= 0) {
                                        boolean bool_112_ = false;
                                        for (int i_113_ = 0; i_113_ < npo; i_113_++) {
                                            if (i_109_ != i_113_ && pnames[i_109_].equals(pnames[i_113_])) {
                                                if (pgames[i_113_] <= -1)
                                                    bool_112_ = true;
                                                else {
                                                    for (int i_114_ = 0; i_114_ < ngm; i_114_++) {
                                                        if (pgames[i_113_] == gnum[i_114_] && wait[i_114_] > 0)
                                                            bool_112_ = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (!bool_112_) {
                                            if (82 + 30 * i_94_ - i_93_ > 50 && 82 + 30 * (i_94_ - 1) - i_93_ < 415) {
                                                boolean bool_115_ = false;
                                                if (i > 70 && i < 185 && i_87_ > 52 + 30 * i_94_ - i_93_ && i_87_ < 82 + 30 * i_94_ - i_93_) {
                                                    if (pgames[im] <= -1 && join <= -1 && chalngd >= -1) {
                                                        if (bool || mousonp == i_109_) {
                                                            rd.setColor(color2k(255, 255, 255));
                                                            mousonp = i_109_;
                                                            i_96_ = 52 + 30 * i_94_ - i_93_;
                                                            if (bool) {
                                                                if (cmonp == i_109_)
                                                                    ongame = pgames[i_109_];
                                                                chalngd = -1;
                                                            } else {
                                                                if (cmonp <= -1) {
                                                                    ongame = -1;
                                                                    cmonp = i_109_;
                                                                }
                                                                if (ongame == pgames[i_109_])
                                                                    mousonp = -1;
                                                            }
                                                        } else
                                                            rd.setColor(color2k(220, 220, 220));
                                                        rd.fillRect(70, 53 + 30 * i_94_ - i_93_, 116, 29);
                                                        i_95_ = i_109_;
                                                    }
                                                    bool_115_ = true;
                                                }
                                                if (pgames[im] <= -1 && join <= -1 && chalngd >= -1) {
                                                    if (wait[i_110_] == 0)
                                                        rd.setColor(new Color(117, 67, 0));
                                                    else
                                                        rd.setColor(color2k(0, 28, 102));
                                                } else if (wait[i_110_] == 0)
                                                    rd.setColor(new Color(82, 47, 0));
                                                else
                                                    rd.setColor(color2k(0, 20, 71));
                                                boolean bool_116_ = gb.drawl(pnames[i_109_], 68, 53 + 30 * i_94_ - i_93_, bool_115_);
                                                if (!bool_115_ || !bool_116_) {
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    ftm = rd.getFontMetrics();
                                                    rd.drawString(pnames[i_109_], 127 - ftm.stringWidth(pnames[i_109_]) / 2, 66 + 30 * i_94_ - i_93_);
                                                    rd.setFont(new Font("Arial", 0, 10));
                                                    ftm = rd.getFontMetrics();
                                                    rd.drawString(pcarnames[i_109_], 127 - ftm.stringWidth(pcarnames[i_109_]) / 2, 78 + 30 * i_94_ - i_93_);
                                                }
                                                rd.setColor(color2k(150, 150, 150));
                                                rd.drawLine(70, 82 + 30 * i_94_ - i_93_, 185, 82 + 30 * i_94_ - i_93_);
                                            }
                                            i_94_++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (mousonp != i_95_) {
                        mousonp = -1;
                        cmonp = -1;
                    }
                    if (npo == 0) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 12));
                        ftm = rd.getFontMetrics();
                        rd.drawString("|  Loading Players  |", 127 - ftm.stringWidth("|  Loading Players  |") / 2, 95);
                    }
                    rd.setColor(color2k(205, 205, 205));
                    rd.fillRect(65, 25, 145, 28);
                    rd.setColor(color2k(150, 150, 150));
                    rd.drawLine(65, 50, 190, 50);
                    rd.setColor(color2k(205, 205, 205));
                    rd.fillRect(65, 413, 145, 12);
                    rd.setColor(color2k(150, 150, 150));
                    rd.drawLine(65, 415, 190, 415);
                    rd.setColor(color2k(205, 205, 205));
                    rd.fillRect(193, 53, 17, 360);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawLine(211, 25, 211, 425);
                    rd.drawImage((xt).roomp, 72, 30, null);
                    if (mscro == 131 || i_92_ == 0) {
                        if (i_92_ == 0)
                            rd.setColor(color2k(205, 205, 205));
                        else
                            rd.setColor(color2k(215, 215, 215));
                        rd.fillRect(193, 53, 17, 17);
                    } else {
                        rd.setColor(color2k(220, 220, 220));
                        rd.fill3DRect(193, 53, 17, 17, true);
                    }
                    if (i_92_ != 0)
                        rd.drawImage((xt).asu, 198, 59, null);
                    if (mscro == 132 || i_92_ == 0) {
                        if (i_92_ == 0)
                            rd.setColor(color2k(205, 205, 205));
                        else
                            rd.setColor(color2k(215, 215, 215));
                        rd.fillRect(193, 396, 17, 17);
                    } else {
                        rd.setColor(color2k(220, 220, 220));
                        rd.fill3DRect(193, 396, 17, 17, true);
                    }
                    if (i_92_ != 0)
                        rd.drawImage((xt).asd, 198, 403, null);
                    if (i_92_ != 0 && conon == 1) {
                        if (lspos != spos) {
                            rd.setColor(color2k(215, 215, 215));
                            rd.fillRect(193, 70 + spos, 17, 31);
                        } else {
                            if (mscro == 131)
                                rd.setColor(color2k(215, 215, 215));
                            rd.fill3DRect(193, 70 + spos, 17, 31, true);
                        }
                        rd.setColor(color2k(150, 150, 150));
                        rd.drawLine(198, 83 + spos, 204, 83 + spos);
                        rd.drawLine(198, 85 + spos, 204, 85 + spos);
                        rd.drawLine(198, 87 + spos, 204, 87 + spos);
                        if (mscro > 101 && lspos != spos)
                            lspos = spos;
                        if (bool) {
                            if (mscro == 125 && i > 193 && i < 210 && i_87_ > 70 + spos && i_87_ < spos + 101)
                                mscro = i_87_ - spos;
                            if (mscro == 125 && i > 191 && i < 212 && i_87_ > 51 && i_87_ < 72)
                                mscro = 131;
                            if (mscro == 125 && i > 191 && i < 212 && i_87_ > 394 && i_87_ < 415)
                                mscro = 132;
                            if (mscro == 125 && i > 193 && i < 210 && i_87_ > 70 && i_87_ < 396) {
                                mscro = 85;
                                spos = i_87_ - mscro;
                            }
                            int i_117_ = 1350 / i_92_;
                            if (i_117_ < 1)
                                i_117_ = 1;
                            if (mscro == 131) {
                                spos -= i_117_;
                                if (spos > 295)
                                    spos = 295;
                                if (spos < 0)
                                    spos = 0;
                                lspos = spos;
                            }
                            if (mscro == 132) {
                                spos += i_117_;
                                if (spos > 295)
                                    spos = 295;
                                if (spos < 0)
                                    spos = 0;
                                lspos = spos;
                            }
                            if (mscro <= 101) {
                                spos = i_87_ - mscro;
                                if (spos > 295)
                                    spos = 295;
                                if (spos < 0)
                                    spos = 0;
                            }
                            if (mscro == 125)
                                mscro = 225;
                        } else if (mscro != 125)
                            mscro = 125;
                        if (i_88_ != 0 && i > 65 && i < 170 && i_87_ > 93 && i_87_ < 413) {
                            spos -= i_88_;
                            zeromsw = true;
                            if (spos > 295) {
                                spos = 295;
                                zeromsw = false;
                            }
                            if (spos < 0) {
                                spos = 0;
                                zeromsw = false;
                            }
                            lspos = spos;
                        }
                    }
                    if (ongame <= -1) {
                        if (opengame >= 2) {
                            if (opengame >= 27)
                                opengame = 26;
                            int i_118_ = 229 + opengame;
                            if (i_118_ > 255)
                                i_118_ = 255;
                            if (i_118_ < 0)
                                i_118_ = 0;
                            rd.setColor(color2k(i_118_, i_118_, i_118_));
                            rd.fillRoundRect(225, 59 - opengame, 495, 200 + opengame * 7, 20, 20);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRoundRect(225, 59 - opengame, 495, 200 + opengame * 7, 20, 20);
                            if (!(xt).lan) {
                                rd.setColor(color2k(217, 217, 217));
                                rd.fillRoundRect(225, 263 + opengame * 7, 495, 157, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(225, 263 + opengame * 7, 495, 157, 20, 20);
                            }
                            btn = 0;
                            if (prevloaded != -1)
                                prevloaded = -1;
                            if (updatec != -1)
                                updatec = -1;
                            if ((gs).cmsg.getText().equals(""))
                                (gs).cmsg.setText("Type here...");
                            if ((gs).cmsg.isShowing()) {
                                (gs).cmsg.hide();
                                gs.requestFocus();
                            }
                            opengame -= 2;
                            if (opengame == 0 && longame != -1 && chalngd <= -1) {
                                ongame = longame;
                                longame = -1;
                            }
                            if (invo)
                                invo = false;
                            for (int i_119_ = 0; i_119_ < 7; i_119_++) {
                                if (!invos[i_119_].equals(""))
                                    invos[i_119_] = "";
                                if (!dinvi[i_119_].equals(""))
                                    dinvi[i_119_] = "";
                            }
                            if (fstart)
                                fstart = false;
                            for (int i_120_ = 0; i_120_ < 9; i_120_++) {
                                if (cac[i_120_] != -1)
                                    cac[i_120_] = -1;
                            }
                            if (dispcar != -1)
                                dispcar = -1;
                        } else {
                            if (!(xt).lan) {
                                drawSbutton((xt).cgame, 292, 42);
                                drawSbutton((xt).ccar, 442, 42);
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                                rd.setColor(color2k(60, 60, 60));
                                if (!(gs).rooms.isShowing())
                                    (gs).rooms.show();
                                (gs).rooms.move(580 - ((gs).rooms).w / 2, 29);
                                if (((gs).rooms).sel != 0) {
                                    stopallnow();
                                    (xt).servport = 7070 + ((gs).rooms).iroom[((gs).rooms).sel];
                                    inishlobby();
                                    ((gs).rooms).kmoused = 20;
                                }
                                if (((gs).rooms).kmoused != 0) {
                                    i = -1;
                                    i_87_ = -1;
                                    bool = false;
                                    ((gs).rooms).kmoused--;
                                }
                            } else {
                                rd.drawImage((xt).lanm, 241, 31, null);
                                if (npo <= 1) {
                                    drawSbutton((xt).cgame, 292, -1000);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (ncnt == 0)
                                        rd.setColor(new Color(188, 111, 0));
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(lmsg, 472 - ftm.stringWidth(lmsg) / 2, 295);
                                    if (lmsg.equals(". . . | Searching/Waiting for other LAN Players | . . .") && ncnt == 0) {
                                        lmsg = "| Searching/Waiting for other LAN Players |";
                                        ncnt = 5;
                                    }
                                    if (lmsg.equals(". . | Searching/Waiting for other LAN Players | . .") && ncnt == 0) {
                                        lmsg = ". . . | Searching/Waiting for other LAN Players | . . .";
                                        ncnt = 5;
                                    }
                                    if (lmsg.equals(". | Searching/Waiting for other LAN Players | .") && ncnt == 0) {
                                        lmsg = ". . | Searching/Waiting for other LAN Players | . .";
                                        ncnt = 5;
                                    }
                                    if (lmsg.equals("| Searching/Waiting for other LAN Players |") && ncnt == 0) {
                                        lmsg = ". | Searching/Waiting for other LAN Players | .";
                                        ncnt = 5;
                                    }
                                    if (ncnt != 0)
                                        ncnt--;
                                    rd.setColor(color2k(70, 70, 70));
                                    rd.drawString("HACKED BY C.HANSEN", 225, 325);
                                    rd.drawString("Get some asshole to connect to your motherfucking router", 225, 345);
                                    rd.drawString("or get Hamachi and make a hosts file redirecting localhost to your hamachi IP...", 225, 365);
                                } else if (!lanlogged) {
                                	lanlogged = true;
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString("HACKED BY C.HANSEN", 472 - ftm.stringWidth("HACKED BY C.HANSEN") / 2, 295);
                                    rd.setColor(color2k(70, 70, 70));
                                    rd.drawString("Exit and re-enter the lobby for 3 more free plays", 225, 325);
                                    rd.drawString("ACCEPT NO IMITATION", 225, 345);
                                    rd.drawString("IF YOU STEAL MY SHIT I'LL FUCK YOU UP", 225, 365);
                                    rd.drawString("HACKED BY C.HANSEN", 225, 385);
                                    drawSbutton((xt).register, 472, 395);
                                } else {
                                    rd.setColor(color2k(90, 90, 90));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(new StringBuilder().append("[  ").append(i_94_).append(" Players Connected  ]").toString(), 472 - ftm.stringWidth(new StringBuilder().append("[  ").append(i_94_).append(" Players Connected  ]").toString()) / 2, 295);
                                    drawSbutton((xt).cgame, 472, 325);
                                }
                                drawSbutton((xt).ccar, 442, -1000);
                            }
                            drawSbutton((xt).exit, 690, 42);
                            if ((control).enter && !(gs).cmsg.getText().equals("Type here...") && !(gs).cmsg.getText().equals("")) {
                                if (chalngd <= -1)
                                    pessd[2] = true;
                                else
                                    pessd[5] = true;
                                (control).enter = false;
                                String string = (gs).cmsg.getText().replace('|', ':');
                                if (string.toLowerCase().indexOf((gs).tpass.getText().toLowerCase()) != -1)
                                    string = " ";
                                if (!xt.msgcheck(string) && updatec > -12) {
                                    for (int i_121_ = 0; i_121_ < 6; i_121_++) {
                                        sentn[i_121_] = sentn[i_121_ + 1];
                                        cnames[i_121_] = cnames[i_121_ + 1];
                                    }
                                    sentn[6] = string;
                                    cnames[6] = pnames[im];
                                    if (updatec > -11)
                                        updatec = -11;
                                    else
                                        updatec--;
                                    spos3 = 28;
                                } else
                                    (xt).warning++;
                                (gs).cmsg.setText("");
                            }
                            if (chalngd <= -1) {
                                rd.setColor(color2k(230, 230, 230));
                                rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                                if (britchl != 0)
                                    britchl = 0;
                                i_92_ = (ngm - 5) * 24;
                                if (i_92_ < 0)
                                    i_92_ = 0;
                                i_93_ = (int) ((float) spos2 / 82.0F * (float) i_92_ - 2.0F);
                                int[] is = new int[ngm];
                                int[] is_122_ = new int[ngm];
                                for (int i_123_ = 0; i_123_ < ngm; i_123_++)
                                    is[i_123_] = 0;
                                for (int i_124_ = 0; i_124_ < ngm; i_124_++) {
                                    for (int i_125_ = i_124_ + 1; i_125_ < ngm; i_125_++) {
                                        if (wait[i_124_] != wait[i_125_]) {
                                            if (wait[i_124_] <= 0 && wait[i_125_] <= 0) {
                                                if (wait[i_124_] < wait[i_125_])
                                                    is[i_124_]++;
                                                else
                                                    is[i_125_]++;
                                            } else if ((wait[i_124_] > wait[i_125_] || wait[i_124_] <= 0) && wait[i_125_] > 0)
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
                                    opselect++;
                                    for (boolean bool_126_ = false; 80 + 24 * opselect - i_93_ > 202 && !bool_126_; i_93_ = (int) ((float) spos2 / 82.0F * (float) i_92_ - 2.0F)) {
                                        spos2++;
                                        if (spos2 > 82) {
                                            spos2 = 82;
                                            bool_126_ = true;
                                        }
                                        if (spos2 < 0) {
                                            spos2 = 0;
                                            bool_126_ = true;
                                        }
                                    }
                                    (control).down = false;
                                }
                                if ((control).up) {
                                    opselect--;
                                    for (boolean bool_127_ = false; 80 + 24 * opselect - i_93_ < 80 && !bool_127_; i_93_ = (int) ((float) spos2 / 82.0F * (float) i_92_ - 2.0F)) {
                                        spos2--;
                                        if (spos2 > 82) {
                                            spos2 = 82;
                                            bool_127_ = true;
                                        }
                                        if (spos2 < 0) {
                                            spos2 = 0;
                                            bool_127_ = true;
                                        }
                                    }
                                    (control).up = false;
                                }
                                int i_128_ = -1;
                                if (mousonp != -1) {
                                    int i_129_ = 0;
                                    for (int i_130_ = 0; i_130_ < ngm; i_130_++) {
                                        if (pgames[mousonp] == gnum[i_130_])
                                            i_129_ = i_130_;
                                    }
                                    i_128_ = 91 + 24 * is[i_129_] - i_93_;
                                    if (80 + 24 * is[i_129_] - i_93_ > 202) {
                                        int i_131_ = 1000 / i_92_;
                                        if (i_131_ < 1)
                                            i_131_ = 1;
                                        spos2 += i_131_;
                                        i_128_ = -1;
                                    }
                                    if (80 + 24 * is[i_129_] - i_93_ < 80) {
                                        int i_132_ = 1000 / i_92_;
                                        if (i_132_ < 1)
                                            i_132_ = 1;
                                        spos2 -= i_132_;
                                        i_128_ = -1;
                                    }
                                    if (spos2 > 82)
                                        spos2 = 82;
                                    if (spos2 < 0)
                                        spos2 = 0;
                                    i_93_ = (int) ((float) spos2 / 82.0F * (float) i_92_ - 2.0F);
                                    opselect = is[i_129_];
                                }
                                if (opselect <= -1)
                                    opselect = 0;
                                if (opselect >= ngm)
                                    opselect = ngm - 1;
                                int i_133_ = 0;
                                for (int i_134_ = 0; i_134_ < ngm; i_134_++) {
                                    if (80 + 24 * i_134_ - i_93_ < 224 && 80 + 24 * i_134_ - i_93_ > 56) {
                                        if (opselect == i_134_) {
                                            if (80 + 24 * i_134_ - i_93_ >= 224)
                                                opselect--;
                                            if (80 + 24 * i_134_ - i_93_ < 62)
                                                opselect++;
                                        }
                                        boolean bool_135_ = false;
                                        boolean bool_136_ = false;
                                        if (!(gs).openm) {
                                            if (i > 241 && i < 692 && i_87_ > 92 + 24 * i_134_ - i_93_ && i_87_ < 110 + 24 * i_134_ - i_93_) {
                                                if (lxm != i || lym != i_87_)
                                                    opselect = i_134_;
                                                bool_135_ = true;
                                                if (bool) {
                                                    if (clicked <= -1)
                                                        clicked = is_122_[i_134_];
                                                } else {
                                                    if (clicked == is_122_[i_134_]) {
                                                        ongame = gnum[is_122_[i_134_]];
                                                        opengame = 0;
                                                        if (i >= 641 && i <= 689 && i_87_ > 92 + 24 * i_134_ - i_93_ && i_87_ < 110 + 24 * i_134_ - i_93_ && wait[is_122_[i_134_]] > 0 && (gplyrs[is_122_[i_134_]].equals("") || gplyrs[is_122_[i_134_]].indexOf(pnames[im]) != -1)) {
                                                            join = gnum[is_122_[i_134_]];
                                                            msg = "| Joining Game |";
                                                            spos = 0;
                                                        }
                                                        clicked = -1;
                                                    }
                                                    i_133_++;
                                                }
                                            } else
                                                i_133_++;
                                            if (i >= 641 && i <= 689 && i_87_ > 92 + 24 * i_134_ - i_93_ && i_87_ < 110 + 24 * i_134_ - i_93_ && bool)
                                                bool_136_ = true;
                                        }
                                        if (opselect == i_134_) {
                                            if (bool_135_ && bool || (control).enter) {
                                                rd.setColor(color2k(200, 200, 200));
                                                if ((control).enter) {
                                                    ongame = gnum[is_122_[i_134_]];
                                                    opengame = 0;
                                                    (control).enter = false;
                                                }
                                            } else
                                                rd.setColor(color2k(255, 255, 255));
                                            rd.fillRect(241, 92 + 24 * i_134_ - i_93_, 451, 18);
                                            if (bool_135_) {
                                                rd.setColor(color2k(150, 150, 150));
                                                rd.drawRect(239, 90 + 24 * i_134_ - i_93_, 454, 21);
                                            }
                                        }
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(gstages[is_122_[i_134_]], 382 - ftm.stringWidth(gstages[is_122_[i_134_]]) / 2, 105 + 24 * i_134_ - i_93_);
                                        rd.drawString("|", 525, 105 + 24 * i_134_ - i_93_);
                                        rd.drawString("|", 584, 105 + 24 * i_134_ - i_93_);
                                        if (wait[is_122_[i_134_]] > 0) {
                                            rd.drawString(new StringBuilder().append("").append(npls[is_122_[i_134_]]).append(" / ").append(mnpls[is_122_[i_134_]]).append("").toString(), 556 - ftm.stringWidth(new StringBuilder().append("").append(npls[is_122_[i_134_]]).append(" / ").append(mnpls[is_122_[i_134_]]).append("").toString()) / 2, 105 + 24 * i_134_ - i_93_);
                                            rd.setFont(new Font("Arial", 0, 12));
                                            rd.setColor(new Color(80, 128, 0));
                                            rd.drawString("Waiting", 593, 105 + 24 * i_134_ - i_93_);
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            if (!bool_136_) {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fill3DRect(641, 92 + 24 * i_134_ - i_93_, 48, 18, true);
                                                rd.fill3DRect(642, 93 + 24 * i_134_ - i_93_, 46, 16, true);
                                            } else {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fillRect(641, 92 + 24 * i_134_ - i_93_, 48, 18);
                                            }
                                            rd.setColor(new Color(0, 0, 0));
                                            if (gplyrs[is_122_[i_134_]].equals("") || gplyrs[is_122_[i_134_]].indexOf(pnames[im]) != -1)
                                                rd.drawString("Join", 665 - ftm.stringWidth("Join") / 2, 105 + 24 * i_134_ - i_93_);
                                            else
                                                rd.drawString("View", 665 - ftm.stringWidth("View") / 2, 105 + 24 * i_134_ - i_93_);
                                        } else {
                                            rd.drawString(new StringBuilder().append("").append(npls[is_122_[i_134_]]).append("").toString(), 556 - ftm.stringWidth(new StringBuilder().append("").append(npls[is_122_[i_134_]]).append("").toString()) / 2, 105 + 24 * i_134_ - i_93_);
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            if (wait[is_122_[i_134_]] == 0) {
                                                rd.setColor(new Color(128, 73, 0));
                                                rd.drawString("Started", 594, 105 + 24 * i_134_ - i_93_);
                                            } else {
                                                rd.setColor(color2k(100, 100, 100));
                                                rd.drawString("Finished", 590, 105 + 24 * i_134_ - i_93_);
                                            }
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            if (!bool_136_) {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fill3DRect(641, 92 + 24 * i_134_ - i_93_, 48, 18, true);
                                            } else {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fillRect(641, 92 + 24 * i_134_ - i_93_, 48, 18);
                                            }
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.drawString("View", 665 - ftm.stringWidth("View") / 2, 105 + 24 * i_134_ - i_93_);
                                        }
                                    } else {
                                        if (opselect == i_134_) {
                                            if (80 + 24 * i_134_ - i_93_ >= 224)
                                                opselect--;
                                            if (80 + 24 * i_134_ - i_93_ <= 56)
                                                opselect++;
                                        }
                                        i_133_++;
                                    }
                                }
                                if (i_133_ == ngm && clicked != -1)
                                    clicked = -1;
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                if (ngm == 0) {
                                    if (!lloaded)
                                        rd.drawString("|  Loading Games  |", 472 - ftm.stringWidth("|  Loading Games  |") / 2, 165);
                                    else if (!(xt).lan)
                                        rd.drawString("No Games Created", 472 - ftm.stringWidth("No Games Created") / 2, 165);
                                }
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(235, 65, 480, 25);
                                rd.drawImage((xt).games, 241, 69, null);
                                rd.setColor(color2k(70, 70, 70));
                                rd.drawString("Stage Name", 382 - ftm.stringWidth("Stage Name") / 2, 81);
                                rd.drawString("|", 525, 81);
                                rd.drawString("Players", 556 - ftm.stringWidth("Players") / 2, 81);
                                rd.drawString("|", 584, 81);
                                rd.drawString("Status", 641 - ftm.stringWidth("Status") / 2, 81);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(235, 87, 696, 87);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(235, 237, 480, 17);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(235, 239, 696, 239);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(698, 107, 17, 113);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(231, 65, 4, 189);
                                if (mscro2 == 141 || i_92_ == 0) {
                                    if (i_92_ == 0)
                                        rd.setColor(color2k(205, 205, 205));
                                    else
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(698, 90, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(698, 90, 17, 17, true);
                                }
                                if (i_92_ != 0)
                                    rd.drawImage((xt).asu, 703, 96, null);
                                if (mscro2 == 142 || i_92_ == 0) {
                                    if (i_92_ == 0)
                                        rd.setColor(color2k(205, 205, 205));
                                    else
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(698, 220, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(698, 220, 17, 17, true);
                                }
                                if (i_92_ != 0)
                                    rd.drawImage((xt).asd, 703, 226, null);
                                if (i_92_ != 0) {
                                    if (lspos2 != spos2) {
                                        rd.setColor(color2k(215, 215, 215));
                                        rd.fillRect(698, 107 + spos2, 17, 31);
                                    } else {
                                        if (mscro2 == 141)
                                            rd.setColor(color2k(215, 215, 215));
                                        rd.fill3DRect(698, 107 + spos2, 17, 31, true);
                                    }
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(703, 120 + spos2, 709, 120 + spos2);
                                    rd.drawLine(703, 122 + spos2, 709, 122 + spos2);
                                    rd.drawLine(703, 124 + spos2, 709, 124 + spos2);
                                    if (mscro2 > 138 && lspos2 != spos2)
                                        lspos2 = spos2;
                                    if (bool) {
                                        if (mscro2 == 145 && i > 698 && i < 715 && i_87_ > 107 + spos2 && i_87_ < spos2 + 138)
                                            mscro2 = i_87_ - spos2;
                                        if (mscro2 == 145 && i > 696 && i < 717 && i_87_ > 88 && i_87_ < 109)
                                            mscro2 = 141;
                                        if (mscro2 == 145 && i > 696 && i < 717 && i_87_ > 218 && i_87_ < 239)
                                            mscro2 = 142;
                                        if (mscro2 == 145 && i > 698 && i < 715 && i_87_ > 107 && i_87_ < 220) {
                                            mscro2 = 122;
                                            spos2 = i_87_ - mscro2;
                                        }
                                        int i_137_ = 400 / i_92_;
                                        if (i_137_ < 1)
                                            i_137_ = 1;
                                        if (mscro2 == 141) {
                                            spos2 -= i_137_;
                                            if (spos2 > 82)
                                                spos2 = 82;
                                            if (spos2 < 0)
                                                spos2 = 0;
                                            lspos2 = spos2;
                                        }
                                        if (mscro2 == 142) {
                                            spos2 += i_137_;
                                            if (spos2 > 82)
                                                spos2 = 82;
                                            if (spos2 < 0)
                                                spos2 = 0;
                                            lspos2 = spos2;
                                        }
                                        if (mscro2 <= 138) {
                                            spos2 = i_87_ - mscro2;
                                            if (spos2 > 82)
                                                spos2 = 82;
                                            if (spos2 < 0)
                                                spos2 = 0;
                                        }
                                        if (mscro2 == 145)
                                            mscro2 = 225;
                                    } else if (mscro2 != 145)
                                        mscro2 = 145;
                                    if (i_88_ != 0 && i > 235 && i < 698 && i_87_ > 87 && i_87_ < 239) {
                                        spos2 -= i_88_;
                                        zeromsw = true;
                                        if (spos2 > 82) {
                                            spos2 = 82;
                                            zeromsw = false;
                                        }
                                        if (spos2 < 0) {
                                            spos2 = 0;
                                            zeromsw = false;
                                        }
                                        lspos2 = spos2;
                                    }
                                }
                                if (mousonp != -1 && i_128_ != -1) {
                                    rd.setColor(color2k(255, 255, 255));
                                    int[] is_138_ = { 185, 241, 241, 185 };
                                    int[] is_139_ = { i_96_, i_128_, i_128_ + 19, i_96_ + 30 };
                                    rd.fillPolygon(is_138_, is_139_, 4);
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(185, i_96_, 241, i_128_);
                                    rd.drawLine(185, i_96_ + 30, 241, i_128_ + 19);
                                    rd.drawLine(241, i_128_, 692, i_128_);
                                    rd.drawLine(241, i_128_ + 19, 692, i_128_ + 19);
                                }
                            } else {
                                int i_140_ = 230 + britchl;
                                if (i_140_ > 255)
                                    i_140_ = 255;
                                if (i_140_ < 0)
                                    i_140_ = 0;
                                rd.setColor(color2k(i_140_, i_140_, i_140_));
                                rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                                if (britchl < 25)
                                    britchl += 5;
                                if (chalngd > -1) {
                                    int i_141_ = 0;
                                    for (int i_142_ = 0; i_142_ < ngm; i_142_++) {
                                        if (chalngd == gnum[i_142_])
                                            i_141_ = i_142_;
                                    }
                                    if (cflk % 4 != 0 || cflk == 0) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(new StringBuilder().append("You have been invited by ").append(chalby).append(" to join a game!").toString(), 472 - ftm.stringWidth(new StringBuilder().append("You have been invited by ").append(chalby).append(" to join a game!").toString()) / 2, 95);
                                        rd.setColor(new Color(117, 67, 0));
                                        rd.drawString(chalby, 472 - ftm.stringWidth(new StringBuilder().append("You have been invited by ").append(chalby).append(" to join a game!").toString()) / 2 + ftm.stringWidth("You have been invited by "), 95);
                                    }
                                    if (cflk != 0)
                                        cflk--;
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(new StringBuilder().append("Stage:  ").append(gstages[i_141_]).append(" ,  Laps: ").append(gnlaps[i_141_]).append("").toString(), 472 - ftm.stringWidth(new StringBuilder().append("Stage:  ").append(gstages[i_141_]).append(" ,  Laps: ").append(gnlaps[i_141_]).append("").toString()) / 2, 130);
                                    rd.setColor(new Color(62, 98, 0));
                                    rd.drawString(gstages[i_141_], 472 - ftm.stringWidth(new StringBuilder().append("Stage:  ").append(gstages[i_141_]).append(" ,  Laps: ").append(gnlaps[i_141_]).append("").toString()) / 2 + ftm.stringWidth("Stage:  "), 130);
                                    rd.drawString(new StringBuilder().append("").append(gnlaps[i_141_]).append("").toString(), 472 - ftm.stringWidth(new StringBuilder().append("Stage:  ").append(gstages[i_141_]).append(" ,  Laps: ").append(gnlaps[i_141_]).append("").toString()) / 2 + ftm.stringWidth(new StringBuilder().append("Stage:  ").append(gstages[i_141_]).append(" ,  Laps: ").toString()), 130);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString(new StringBuilder().append("Players:  ").append(mnpls[i_141_]).append("").toString(), 472 - ftm.stringWidth(new StringBuilder().append("Players:  ").append(mnpls[i_141_]).append("").toString()) / 2, 150);
                                    rd.setColor(new Color(62, 98, 0));
                                    rd.drawString(new StringBuilder().append("").append(mnpls[i_141_]).append("").toString(), 472 - ftm.stringWidth(new StringBuilder().append("Players:  ").append(mnpls[i_141_]).append("").toString()) / 2 + ftm.stringWidth("Players:  "), 150);
                                    Date date = new Date();
                                    long l = date.getTime();
                                    if (ptime == 0L || l > ptime + 1000L) {
                                        if (ptime != 0L)
                                            ctime--;
                                        ptime = l;
                                    }
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 0, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(new StringBuilder().append("(").append(ctime).append(" )").toString(), 472 - ftm.stringWidth(new StringBuilder().append("(").append(ctime).append(" )").toString()) / 2, 170);
                                    if (ctime == 0) {
                                        ongame = longame;
                                        chalngd = -1;
                                        longame = -1;
                                    }
                                    stringbutton("   View Game   ", 352, 215, 2);
                                    stringbutton("   Join Game   ", 462, 215, 2);
                                    stringbutton("   Decline X   ", 599, 215, 2);
                                } else {
                                    if (chalngd != -5) {
                                        if (cflk % 4 != 0 || cflk == 0) {
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 1, 13));
                                            rd.drawString("Create Game...", 241, 85);
                                        }
                                        if (cflk != 0)
                                            cflk--;
                                        stringbutton(" Cancel X ", 669, 85, 2);
                                    }
                                    if (chalngd == -2) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        if (sflk % 4 != 0 || sflk == 0)
                                            rd.drawString("Select Game's Stage", 472 - ftm.stringWidth("Select Game's Stage") / 2, 85);
                                        if (sflk != 0)
                                            sflk--;
                                        int i_143_ = 0;
                                        (gs).sgame.setSize(139, 22);
                                        if ((gs).sgame.getSelectedIndex() == 0)
                                            i_143_ = 472 - ((gs).sgame.getWidth() + 6 + (gs).snfmm.getWidth()) / 2;
                                        if ((gs).sgame.getSelectedIndex() == 1)
                                            i_143_ = 472 - ((gs).sgame.getWidth() + 6 + (gs).snfm1.getWidth()) / 2;
                                        if ((gs).sgame.getSelectedIndex() == 2)
                                            i_143_ = 472 - ((gs).sgame.getWidth() + 6 + (gs).snfm2.getWidth()) / 2;
                                        if ((gs).sgame.getSelectedIndex() == 3) {
                                            (gs).mstgs.setSize(338, 22);
                                            if (!sgflag) {
                                                if ((xt).logged) {
                                                    if ((cd).msloaded != 1) {
                                                        (gs).mstgs.removeAll();
                                                        (gs).mstgs.add(rd, "Loading your stages now, please wait...");
                                                        (gs).mstgs.select(0);
                                                        msload = true;
                                                    }
                                                } else {
                                                    (gs).mstgs.removeAll();
                                                    (gs).mstgs.add(rd, "You need to have a full account to access ");
                                                    (gs).mstgs.select(0);
                                                    (cd).msloaded = 0;
                                                }
                                                sgflag = true;
                                            }
                                            i_143_ = 472 - ((gs).sgame.getWidth() + 6 + (gs).mstgs.getWidth()) / 2;
                                        } else
                                            sgflag = false;
                                        if (!(gs).sgame.isShowing()) {
                                            (gs).sgame.show();
                                            remstage = 0;
                                            if (loadstage == 0) {
                                                int i_144_ = (int) (Math.random() * 3.0);
                                                if (i_144_ == 3)
                                                    i_144_ = 2;
                                                (gs).sgame.select(i_144_);
                                            }
                                        }
                                        (gs).sgame.move(i_143_, 105);
                                        i_143_ += (gs).sgame.getWidth() + 6;
                                        if ((gs).sgame.getSelectedIndex() == 0) {
                                            if (!(gs).snfmm.isShowing()) {
                                                (gs).snfmm.show();
                                                if (loadstage == 0)
                                                    (gs).snfmm.select(0);
                                            }
                                            (gs).snfmm.move(i_143_, 105);
                                            if ((gs).snfm1.isShowing())
                                                (gs).snfm1.hide();
                                            if ((gs).snfm2.isShowing())
                                                (gs).snfm2.hide();
                                            if ((gs).mstgs.isShowing())
                                                (gs).mstgs.hide();
                                        }
                                        if ((gs).sgame.getSelectedIndex() == 0 && (gs).snfmm.getSelectedIndex() != 0 && gstage != (gs).snfmm.getSelectedIndex() + 27) {
                                            loadstage = (gs).snfmm.getSelectedIndex() + 27;
                                            gstage = loadstage;
                                            gs.requestFocus();
                                        }
                                        if ((gs).sgame.getSelectedIndex() == 1) {
                                            if (!(gs).snfm2.isShowing()) {
                                                (gs).snfm2.show();
                                                if (loadstage == 0)
                                                    (gs).snfm2.select(0);
                                            }
                                            (gs).snfm2.move(i_143_, 105);
                                            if ((gs).snfmm.isShowing())
                                                (gs).snfmm.hide();
                                            if ((gs).snfm1.isShowing())
                                                (gs).snfm1.hide();
                                            if ((gs).mstgs.isShowing())
                                                (gs).mstgs.hide();
                                        }
                                        if ((gs).sgame.getSelectedIndex() == 1 && (gs).snfm2.getSelectedIndex() != 0 && gstage != (gs).snfm2.getSelectedIndex() + 10) {
                                            loadstage = (gs).snfm2.getSelectedIndex() + 10;
                                            gstage = loadstage;
                                            gs.requestFocus();
                                        }
                                        if ((gs).sgame.getSelectedIndex() == 2) {
                                            if (!(gs).snfm1.isShowing()) {
                                                (gs).snfm1.show();
                                                if (loadstage == 0)
                                                    (gs).snfm1.select(0);
                                            }
                                            (gs).snfm1.move(i_143_, 105);
                                            if ((gs).snfmm.isShowing())
                                                (gs).snfmm.hide();
                                            if ((gs).snfm2.isShowing())
                                                (gs).snfm2.hide();
                                            if ((gs).mstgs.isShowing())
                                                (gs).mstgs.hide();
                                        }
                                        if ((gs).sgame.getSelectedIndex() == 2 && (gs).snfm1.getSelectedIndex() != 0 && gstage != (gs).snfm1.getSelectedIndex()) {
                                            loadstage = (gs).snfm1.getSelectedIndex();
                                            gstage = loadstage;
                                            gs.requestFocus();
                                        }
                                        if ((gs).sgame.getSelectedIndex() == 3) {
                                            if (!(gs).mstgs.isShowing()) {
                                                (gs).mstgs.show();
                                                if (loadstage == 0)
                                                    (gs).mstgs.select(0);
                                            }
                                            (gs).mstgs.move(i_143_, 105);
                                            if ((gs).snfmm.isShowing())
                                                (gs).snfmm.hide();
                                            if ((gs).snfm1.isShowing())
                                                (gs).snfm1.hide();
                                            if ((gs).snfm2.isShowing())
                                                (gs).snfm2.hide();
                                        }
                                        if (remstage != 2) {
                                            if ((gs).sgame.getSelectedIndex() == 3 && (gs).mstgs.getSelectedIndex() != 0) {
                                                if (gstage != (gs).mstgs.getSelectedIndex() + 100) {
                                                    loadstage = (gs).mstgs.getSelectedIndex() + 100;
                                                    gstage = loadstage;
                                                    gs.requestFocus();
                                                    remstage = 0;
                                                }
                                                if (loadstage <= 0 && remstage == 0 && xt.drawcarb(true, null, "X", 674, 136, i, i_87_, bool))
                                                    remstage = 1;
                                            } else if (remstage != 0)
                                                remstage = 0;
                                        }
                                        if (loadstage > 0 && remstage == 0) {
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString("Loading stage, please wait...", 472 - ftm.stringWidth("Loading Stage, please wait...") / 2, 165);
                                        }
                                        if ((gs).sgame.getSelectedIndex() == 3 && !(xt).logged) {
                                            stringbutton("   Upgrade Account   ", 472, 176, 1);
                                            if ((gs).slaps.isShowing())
                                                (gs).slaps.hide();
                                        } else {
                                            if (loadstage < 0 && remstage == 0) {
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString(new StringBuilder().append("").append(gstagename).append("  -  Laps:              ").toString(), 472 - ftm.stringWidth(new StringBuilder().append("").append(gstagename).append("  -  Laps:              ").toString()) / 2, 155);
                                                if (!(gs).slaps.isShowing()) {
                                                    (gs).slaps.show();
                                                    (gs).slaps.select(gstagelaps - 1);
                                                }
                                                (gs).slaps.move(472 + ftm.stringWidth(new StringBuilder().append("").append(gstagename).append("  -  Laps:              ").toString()) / 2 - 35, 138);
                                                if ((gs).slaps.getSelectedIndex() != gstagelaps - 1) {
                                                    gstagelaps = (gs).slaps.getSelectedIndex() + 1;
                                                    gs.requestFocus();
                                                }
                                                stringbutton("    Preview Stage    ", 472, 185, 2);
                                            } else if ((gs).slaps.isShowing())
                                                (gs).slaps.hide();
                                            if (remstage == 3) {
                                                if (loadstage < 0)
                                                    stringbutton("    Preview Stage    ", 472, -160, 2);
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 1, 13));
                                                ftm = rd.getFontMetrics();
                                                xt.drawlprom(135, 75);
                                                rd.drawString("Failed to remove stage, server error, please try again later.", 472 - ftm.stringWidth("Failed to remove stage, server error, please try again later.") / 2, 155);
                                                if (xt.drawcarb(true, null, " OK ", 451, 175, i, i_87_, bool)) {
                                                    remstage = 0;
                                                    (gs).mouses = 0;
                                                }
                                            }
                                            if (remstage == 2) {
                                                if (loadstage < 0)
                                                    stringbutton("    Preview Stage    ", 472, -160, 2);
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 1, 13));
                                                ftm = rd.getFontMetrics();
                                                xt.drawlprom(135, 75);
                                                rd.drawString("Removing stage from your account...", 472 - ftm.stringWidth("Removing stage from your account...") / 2, 175);
                                                if ((cd).staction == 0) {
                                                    gstage = 0;
                                                    loadstage = 0;
                                                    remstage = 0;
                                                }
                                                if ((cd).staction <= -1) {
                                                    remstage = 3;
                                                    (gs).mouses = 0;
                                                }
                                            }
                                            if (remstage == 1) {
                                                if (loadstage < 0)
                                                    stringbutton("    Preview Stage    ", 472, -160, 2);
                                                xt.drawlprom(135, 75);
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 1, 13));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString("Remove this stage from your account?", 472 - ftm.stringWidth("Remove this stage from your account?") / 2, 155);
                                                if (xt.drawcarb(true, null, " Yes ", 426, 175, i, i_87_, bool)) {
                                                    remstage = 2;
                                                    (cd).onstage = (gs).mstgs.getSelectedItem();
                                                    (cd).staction = 1;
                                                    cd.sparkstageaction();
                                                    (gs).mouses = 0;
                                                }
                                                if (xt.drawcarb(true, null, " No ", 480, 175, i, i_87_, bool)) {
                                                    remstage = 0;
                                                    (gs).mouses = 0;
                                                }
                                            }
                                            stringbutton("   Next >   ", 472, 235, 1);
                                        }
                                    }
                                    if (chalngd == -3) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        if (sflk % 4 != 0 || sflk == 0)
                                            rd.drawString("Select Number of Players", 472 - ftm.stringWidth("Select Number of Players") / 2, 85);
                                        if (sflk != 0)
                                            sflk--;
                                        int i_145_ = 0;
                                        if ((xt).lan)
                                            i_145_ = 59;
                                        rd.drawString("Players", 413 - i_145_, 122);
                                        if (!(gs).snpls.isShowing()) {
                                            (gs).snpls.show();
                                            (gs).snpls.select(gnpls - 1);
                                        }
                                        (gs).snpls.move(467 - i_145_, 105);
                                        boolean bool_146_ = false;
                                        if ((gs).snpls.getSelectedIndex() != 0 && (gs).snpls.getSelectedIndex() != gnpls - 1) {
                                            gnpls = (gs).snpls.getSelectedIndex() + 1;
                                            bool_146_ = true;
                                            (gs).swait.hide();
                                        }
                                        if ((xt).lan) {
                                            rd.drawString("Bots", 490, 122);
                                            if (!(gs).snbts.isShowing()) {
                                                (gs).snbts.show();
                                                (gs).snbts.select(0);
                                                gnbts = 0;
                                            }
                                            (gs).snbts.move(524, 105);
                                            if ((gs).snbts.getSelectedIndex() != gnbts || bool_146_) {
                                                for (gnbts = (gs).snbts.getSelectedIndex(); gnbts + gnpls > 7; gnbts--) {
                                                    /* empty */
                                                }
                                                (gs).snbts.select(gnbts);
                                            }
                                        }
                                        rd.drawString("Wait", 414, 162);
                                        if (!(gs).swait.isShowing()) {
                                            (gs).swait.show();
                                            if (gwait == 0)
                                                (gs).swait.select(1);
                                        }
                                        (gs).swait.move(451, 145);
                                        if (((gs).swait.getSelectedIndex() + 1) * 60 != gwait)
                                            gwait = ((gs).swait.getSelectedIndex() + 1) * 60;
                                        rd.setColor(color2k(90, 90, 90));
                                        rd.setFont(new Font("Arial", 0, 11));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("(Maximum time to wait for all players to join. )", 472 - ftm.stringWidth("(Maximum time to wait for all players to join. )") / 2, 179);
                                        stringbutton("   < Back   ", 422, 235, 1);
                                        stringbutton("   Next >   ", 522, 235, 1);
                                    }
                                    if (chalngd == -4) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        if (sflk % 4 != 0 || sflk == 0)
                                            rd.drawString("Game Options", 472 - ftm.stringWidth("Game Options") / 2, 85);
                                        if (sflk != 0)
                                            sflk--;
                                        int i_147_ = 472 - ((gs).scars.getWidth() + (gs).sclass.getWidth() + (gs).sfix.getWidth() + 16) / 2;
                                        if (!(gs).scars.isShowing()) {
                                            (gs).scars.show();
                                            if (gcars >= 0 && gcars <= 2)
                                                (gs).scars.select(gcars);
                                            else
                                                (gs).scars.select(0);
                                        }
                                        (gs).scars.move(i_147_, 105);
                                        i_147_ += (gs).scars.getWidth() + 8;
                                        if (!(gs).sclass.isShowing()) {
                                            (gs).sclass.show();
                                            if (gclass >= 0 && gclass <= 5)
                                                (gs).sclass.select(gclass);
                                            else
                                                (gs).sclass.select(0);
                                        }
                                        (gs).sclass.move(i_147_, 105);
                                        i_147_ += (gs).sclass.getWidth() + 8;
                                        if (!(gs).sfix.isShowing()) {
                                            (gs).sfix.show();
                                            if (gfix >= 0 && gfix <= 5)
                                                (gs).sfix.select(gfix);
                                            else
                                                (gs).sfix.select(0);
                                        }
                                        (gs).sfix.move(i_147_, 105);
                                        i_147_ += (gs).sfix.getWidth();
                                        if (!(gs).openm)
                                            gs.movefield((gs).notp, i_147_ - 112, 131, 150, 17);
                                        else
                                            gs.movefield((gs).notp, i_147_ - 112, -2000, 150, 17);
                                        if (!(gs).notp.isShowing()) {
                                            (gs).notp.show();
                                            if (gnotp == 0)
                                                (gs).notp.setState(false);
                                            else
                                                (gs).notp.setState(true);
                                        }
                                        if ((xt).sc[0] < 16) {
                                            if (!(gs).openm)
                                                gs.movefield((gs).mycar, 472 - ((gs).scars.getWidth() + (gs).sclass.getWidth() + (gs).sfix.getWidth() + 16) / 2, 131, 150, 17);
                                            else
                                                gs.movefield((gs).mycar, 410, -2000, 150, 17);
                                            if (!(gs).mycar.isShowing()) {
                                                (gs).mycar.show();
                                                (gs).mycar.setLabel(new StringBuilder().append("").append((cd).names[(xt).sc[0]]).append(" Game!").toString());
                                                if (gclass <= -2)
                                                    (gs).mycar.setState(true);
                                                else
                                                    (gs).mycar.setState(false);
                                            }
                                        } else if ((gs).mycar.getState())
                                            (gs).mycar.setState(false);
                                        if ((gs).mycar.getState()) {
                                            if ((gs).sclass.isEnabled())
                                                (gs).sclass.disable();
                                            if ((gs).scars.isEnabled())
                                                (gs).scars.disable();
                                        } else {
                                            if (!(gs).sclass.isEnabled())
                                                (gs).sclass.enable();
                                            if (!(gs).scars.isEnabled())
                                                (gs).scars.enable();
                                            if ((gs).sclass.getSelectedIndex() != gclass) {
                                                gclass = (gs).sclass.getSelectedIndex();
                                                (gs).mycar.hide();
                                            }
                                            if ((gs).scars.getSelectedIndex() != gcars)
                                                gcars = (gs).scars.getSelectedIndex();
                                        }
                                        if ((gs).sfix.getSelectedIndex() != gfix)
                                            gfix = (gs).sfix.getSelectedIndex();
                                        String string = "Public Game, anyone can join...";
                                        int i_148_ = 0;
                                        for (int i_149_ = 0; i_149_ < 7; i_149_++) {
                                            if (!invos[i_149_].equals(""))
                                                i_148_++;
                                        }
                                        if (i_148_ > 0) {
                                            string = "Players Allowed:  ";
                                            int i_150_ = 0;
                                            for (int i_151_ = 0; i_151_ < 7; i_151_++) {
                                                if (!invos[i_151_].equals("")) {
                                                    string = new StringBuilder().append(string).append(invos[i_151_]).toString();
                                                    if (++i_150_ != i_148_) {
                                                        if (i_150_ == i_148_ - 1)
                                                            string = new StringBuilder().append(string).append(" and ").toString();
                                                        else
                                                            string = new StringBuilder().append(string).append(", ").toString();
                                                    }
                                                }
                                            }
                                        }
                                        rd.setColor(new Color(0, 0, 0));
                                        if (i_148_ < gnpls - 1) {
                                            rd.setFont(new Font("Arial", 1, 13));
                                            rd.drawString(new StringBuilder().append("Private Game, only specific players allowed to join?  ").append(i_148_).append("/").append(gnpls - 1).append("").toString(), 330, 180);
                                            stringbutton("<   Select   ", 281, 180, 2);
                                            rd.setFont(new Font("Tahoma", 0, 11));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(string, 472 - ftm.stringWidth(string) / 2, 203);
                                        } else {
                                            rd.setFont(new Font("Arial", 1, 13));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(new StringBuilder().append("").append(i_148_).append(" Allowed Players Selected").toString(), 472 - ftm.stringWidth(new StringBuilder().append("").append(i_148_).append(" Allowed Players Selected").toString()) / 2, 180);
                                            rd.setFont(new Font("Tahoma", 0, 11));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(string, 472 - ftm.stringWidth(string) / 2, 203);
                                        }
                                        stringbutton("   < Back   ", 422, 235, 1);
                                        stringbutton("   Finish!   ", 522, 235, 1);
                                    }
                                    if (chalngd == -5) {
                                        if (fstart)
                                            fstart = false;
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(msg, 472 - ftm.stringWidth(msg) / 2, 145);
                                        if (msg.equals(". . . | Creating Game | . . .") && ncnt == 0) {
                                            msg = "| Creating Game |";
                                            ncnt = 5;
                                        }
                                        if (msg.equals(". . | Creating Game | . .") && ncnt == 0) {
                                            msg = ". . . | Creating Game | . . .";
                                            ncnt = 5;
                                        }
                                        if (msg.equals(". | Creating Game | .") && ncnt == 0) {
                                            msg = ". . | Creating Game | . .";
                                            ncnt = 5;
                                        }
                                        if (msg.equals("| Creating Game |") && ncnt == 0) {
                                            msg = ". | Creating Game | .";
                                            ncnt = 5;
                                        }
                                        if (ncnt != 0)
                                            ncnt--;
                                    }
                                }
                            }
                            if (!(xt).lan) {
                                rd.setColor(color2k(230, 230, 230));
                                rd.fillRoundRect(225, 263, 495, 157, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(225, 263, 495, 157, 20, 20);
                                String[] strings = new String[14];
                                String[] strings_152_ = new String[14];
                                boolean[] bools = new boolean[14];
                                for (int i_153_ = 0; i_153_ < 14; i_153_++) {
                                    strings[i_153_] = "";
                                    strings_152_[i_153_] = "";
                                    bools[i_153_] = false;
                                }
                                int i_154_ = 0;
                                rd.setFont(new Font("Tahoma", 0, 11));
                                ftm = rd.getFontMetrics();
                                if (updatec != -1) {
                                    for (int i_155_ = 0; i_155_ < 7; i_155_++) {
                                        strings[i_154_] = "";
                                        strings_152_[i_154_] = cnames[i_155_];
                                        int i_156_ = 0;
                                        int i_157_ = 0;
                                        int i_158_ = 0;
                                        int i_159_ = 0;
                                        int i_160_ = 0;
                                        for (/**/; i_156_ < sentn[i_155_].length(); i_156_++) {
                                            String string = new StringBuilder().append("").append(sentn[i_155_].charAt(i_156_)).toString();
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
                                                if (ftm.stringWidth(strings[i_154_]) > 367) {
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
                                                            strings_152_[i_154_] = cnames[i_155_];
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
                                    i_93_ = (int) ((float) spos3 / 28.0F * (float) i_92_);
                                    String string = "";
                                    rd.setFont(new Font("Tahoma", 1, 11));
                                    ftm = rd.getFontMetrics();
                                    for (int i_165_ = 0; i_165_ < i_154_; i_165_++) {
                                        if (!string.equals(strings_152_[i_165_])) {
                                            if (280 + i_165_ * 15 - i_93_ > 266 && 280 + i_165_ * 15 - i_93_ < 370)
                                                rd.drawString(new StringBuilder().append(strings_152_[i_165_]).append(":").toString(), 320 - ftm.stringWidth(new StringBuilder().append(strings_152_[i_165_]).append(":").toString()), 305 + i_165_ * 15 - i_93_);
                                            string = strings_152_[i_165_];
                                        }
                                    }
                                    rd.setFont(new Font("Tahoma", 0, 11));
                                    for (int i_166_ = 0; i_166_ < i_154_; i_166_++) {
                                        if (bools[i_166_] && i_166_ == 0 && strings[i_166_].indexOf(" ") != -1)
                                            strings[i_166_] = new StringBuilder().append("...").append(strings[i_166_].substring(strings[i_166_].indexOf(" "), strings[i_166_].length())).append("").toString();
                                        if (280 + i_166_ * 15 - i_93_ > 266 && 280 + i_166_ * 15 - i_93_ < 370)
                                            rd.drawString(strings[i_166_], 325, 305 + i_166_ * 15 - i_93_);
                                    }
                                } else {
                                    i_92_ = 0;
                                    boolean bool_167_ = false;
                                    rd.drawString("Loading chat...", 465 - ftm.stringWidth("Loading chat...") / 2, 325);
                                }
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(235, 269, 480, 25);
                                rd.drawImage((xt).chat, 241, 273, null);
                                rd.setFont(new Font("Arial", 1, 12));
                                rd.setColor(color2k(120, 120, 120));
                                rd.drawString("(Room Chat )", 299, 285);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(235, 291, 696, 291);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(235, 387, 480, 28);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(235, 389, 696, 389);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(698, 311, 17, 59);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(231, 269, 4, 146);
                                if (mscro3 == 351 || i_92_ == 0) {
                                    if (i_92_ == 0)
                                        rd.setColor(color2k(205, 205, 205));
                                    else
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(698, 294, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(698, 294, 17, 17, true);
                                }
                                if (i_92_ != 0)
                                    rd.drawImage((xt).asu, 703, 300, null);
                                if (mscro3 == 352 || i_92_ == 0) {
                                    if (i_92_ == 0)
                                        rd.setColor(color2k(205, 205, 205));
                                    else
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(698, 370, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(698, 370, 17, 17, true);
                                }
                                if (i_92_ != 0)
                                    rd.drawImage((xt).asd, 703, 376, null);
                                if (i_92_ != 0) {
                                    if (lspos3 != spos3) {
                                        rd.setColor(color2k(215, 215, 215));
                                        rd.fillRect(698, 311 + spos3, 17, 31);
                                    } else {
                                        if (mscro3 == 141)
                                            rd.setColor(color2k(215, 215, 215));
                                        rd.fill3DRect(698, 311 + spos3, 17, 31, true);
                                    }
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(703, 324 + spos3, 709, 324 + spos3);
                                    rd.drawLine(703, 326 + spos3, 709, 326 + spos3);
                                    rd.drawLine(703, 328 + spos3, 709, 328 + spos3);
                                    if (mscro3 > 342 && lspos3 != spos3)
                                        lspos3 = spos3;
                                    if (bool) {
                                        if (mscro3 == 345 && i > 698 && i < 715 && i_87_ > 311 + spos3 && i_87_ < spos3 + 342)
                                            mscro3 = i_87_ - spos3;
                                        if (mscro3 == 345 && i > 696 && i < 717 && i_87_ > 292 && i_87_ < 313)
                                            mscro3 = 351;
                                        if (mscro3 == 345 && i > 696 && i < 717 && i_87_ > 368 && i_87_ < 389)
                                            mscro3 = 352;
                                        if (mscro3 == 345 && i > 698 && i < 715 && i_87_ > 311 && i_87_ < 370) {
                                            mscro3 = 326;
                                            spos3 = i_87_ - mscro3;
                                        }
                                        int i_168_ = 100 / i_92_;
                                        if (i_168_ < 1)
                                            i_168_ = 1;
                                        if (mscro3 == 351) {
                                            spos3 -= i_168_;
                                            if (spos3 > 28)
                                                spos3 = 28;
                                            if (spos3 < 0)
                                                spos3 = 0;
                                            lspos3 = spos3;
                                        }
                                        if (mscro3 == 352) {
                                            spos3 += i_168_;
                                            if (spos3 > 28)
                                                spos3 = 28;
                                            if (spos3 < 0)
                                                spos3 = 0;
                                            lspos3 = spos3;
                                        }
                                        if (mscro3 <= 342) {
                                            spos3 = i_87_ - mscro3;
                                            if (spos3 > 28)
                                                spos3 = 28;
                                            if (spos3 < 0)
                                                spos3 = 0;
                                        }
                                        if (mscro3 == 345)
                                            mscro3 = 425;
                                    } else if (mscro3 != 345)
                                        mscro3 = 345;
                                    if (i_88_ != 0 && i > 235 && i < 698 && i_87_ > 291 && i_87_ < 389) {
                                        spos3 -= i_88_ / 2;
                                        zeromsw = true;
                                        if (spos3 > 28) {
                                            spos3 = 28;
                                            zeromsw = false;
                                        }
                                        if (spos3 < 0) {
                                            spos3 = 0;
                                            zeromsw = false;
                                        }
                                        lspos3 = spos3;
                                    }
                                }
                                pre1 = true;
                                stringbutton("Send Message", 657, 406, 3);
                            }
                        }
                    } else if (opengame < 26) {
                        int i_169_ = 229 + opengame;
                        if (i_169_ > 255)
                            i_169_ = 255;
                        if (i_169_ < 0)
                            i_169_ = 0;
                        rd.setColor(color2k(i_169_, i_169_, i_169_));
                        rd.fillRoundRect(225, 59 - opengame, 495, 200 + opengame * 7, 20, 20);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawRoundRect(225, 59 - opengame, 495, 200 + opengame * 7, 20, 20);
                        if (!(xt).lan) {
                            rd.setColor(color2k(217, 217, 217));
                            rd.fillRoundRect(225, 263 + opengame * 7, 495, 157, 20, 20);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRoundRect(225, 263 + opengame * 7, 495, 157, 20, 20);
                        }
                        btn = 0;
                        if (prevloaded != -1)
                            prevloaded = -1;
                        if (updatec != -1)
                            updatec = -1;
                        if ((gs).cmsg.getText().equals(""))
                            (gs).cmsg.setText("Type here...");
                        if ((gs).cmsg.isShowing()) {
                            (gs).cmsg.hide();
                            gs.requestFocus();
                        }
                        if ((gs).rooms.isShowing())
                            (gs).rooms.hide();
                        if (fstart)
                            fstart = false;
                        for (int i_170_ = 0; i_170_ < 9; i_170_++) {
                            if (cac[i_170_] != -1)
                                cac[i_170_] = -1;
                        }
                        if (dispcar != -1)
                            dispcar = -1;
                        opengame += 2;
                    } else {
                        rd.setColor(color2k(255, 255, 255));
                        rd.fillRoundRect(225, 33, 495, 385, 20, 20);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawRoundRect(225, 33, 495, 385, 20, 20);
                        if (join > -1 && pgames[im] != join || join == -2) {
                            if (join > -1 && pgames[im] != join) {
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                                rd.drawString(msg, 472 - ftm.stringWidth(msg) / 2, 195);
                                if (msg.equals(". . . | Joining Game | . . .") && ncnt == 0) {
                                    msg = "| Joining Game |";
                                    ncnt = 5;
                                }
                                if (msg.equals(". . | Joining Game | . .") && ncnt == 0) {
                                    msg = ". . . | Joining Game | . . .";
                                    ncnt = 5;
                                }
                                if (msg.equals(". | Joining Game | .") && ncnt == 0) {
                                    msg = ". . | Joining Game | . .";
                                    ncnt = 5;
                                }
                                if (msg.equals("| Joining Game |") && ncnt == 0) {
                                    msg = ". | Joining Game | .";
                                    ncnt = 5;
                                }
                                if (ncnt != 0)
                                    ncnt--;
                            }
                            if (join == -2) {
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                                rd.drawString(msg, 472 - ftm.stringWidth(msg) / 2, 195);
                                if (msg.equals(". . . | Leaving Game | . . .") && ncnt == 0) {
                                    msg = "| Leaving Game |";
                                    ncnt = 5;
                                }
                                if (msg.equals(". . | Leaving Game | . .") && ncnt == 0) {
                                    msg = ". . . | Leaving Game | . . .";
                                    ncnt = 5;
                                }
                                if (msg.equals(". | Leaving Game | .") && ncnt == 0) {
                                    msg = ". . | Leaving Game | . .";
                                    ncnt = 5;
                                }
                                if (msg.equals("| Leaving Game |") && ncnt == 0) {
                                    msg = ". | Leaving Game | .";
                                    ncnt = 5;
                                }
                                if (ncnt != 0)
                                    ncnt--;
                            }
                            if ((gs).cmsg.isShowing()) {
                                (gs).cmsg.hide();
                                gs.requestFocus();
                            }
                        } else {
                            int i_171_ = 0;
                            for (int i_172_ = 0; i_172_ < ngm; i_172_++) {
                                if (ongame == gnum[i_172_])
                                    i_171_ = i_172_;
                            }
                            rd.setFont(new Font("Arial", 1, 11));
                            rd.setColor(new Color(0, 0, 0));
                            if (conon == 1) {
                                if (wait[i_171_] > 0) {
                                    String string = "";
                                    if (gplyrs[i_171_].equals(""))
                                        string = "Public Game";
                                    else
                                        string = "Private Game";
                                    if (gfx[i_171_] == 1)
                                        string = new StringBuilder().append(string).append(", 4 Fixes").toString();
                                    if (gfx[i_171_] == 2)
                                        string = new StringBuilder().append(string).append(", 3 Fixes").toString();
                                    if (gfx[i_171_] == 3)
                                        string = new StringBuilder().append(string).append(", 2 Fixes").toString();
                                    if (gfx[i_171_] == 4)
                                        string = new StringBuilder().append(string).append(", 1 Fix").toString();
                                    if (gfx[i_171_] == 5)
                                        string = new StringBuilder().append(string).append(", No Fixing").toString();
                                    String string_173_ = "";
                                    if (gclss[i_171_] > -2) {
                                        if (gcrs[i_171_] == 1)
                                            string_173_ = "Custom Cars";
                                        if (gcrs[i_171_] == 2)
                                            string_173_ = "Game Cars";
                                        String string_174_ = "";
                                        if (gclss[i_171_] == 1)
                                            string_174_ = "Class C";
                                        if (gclss[i_171_] == 2)
                                            string_174_ = "Class B & C";
                                        if (gclss[i_171_] == 3)
                                            string_174_ = "Class B";
                                        if (gclss[i_171_] == 4)
                                            string_174_ = "Class A & B";
                                        if (gclss[i_171_] == 5)
                                            string_174_ = "Class A";
                                        if (!string_173_.equals("") && !string_174_.equals(""))
                                            string_173_ = new StringBuilder().append(string_173_).append(", ").append(string_174_).toString();
                                        else
                                            string_173_ = new StringBuilder().append(string_173_).append(string_174_).toString();
                                    } else
                                        string_173_ = new StringBuilder().append("").append((cd).names[Math.abs(gclss[i_171_] + 2)]).append("").toString();
                                    if (string_173_.equals("")) {
                                        rd.drawString("Type:", 243, 55);
                                        rd.setColor(new Color(80, 128, 0));
                                        rd.drawString(string, 279, 55);
                                    } else {
                                        rd.drawString("Type:", 243, 48);
                                        rd.drawString("Cars:", 244, 60);
                                        rd.setColor(new Color(80, 128, 0));
                                        rd.drawString(string, 279, 48);
                                        rd.drawString(string_173_, 279, 60);
                                    }
                                }
                                if (wait[i_171_] == 0) {
                                    rd.drawString("Status:", 241, 55);
                                    rd.setColor(new Color(128, 73, 0));
                                    if (prevloaded == 0)
                                        rd.drawString("Starting...", 286, 55);
                                    else
                                        rd.drawString("Started", 286, 55);
                                }
                                if (wait[i_171_] <= -1) {
                                    rd.drawString("Status:", 241, 55);
                                    rd.setColor(color2k(100, 100, 100));
                                    rd.drawString("Finished", 286, 55);
                                }
                            } else {
                                rd.drawString("Status:", 241, 55);
                                rd.setColor(new Color(128, 73, 0));
                                rd.drawString("Starting...", 286, 55);
                            }
                            rd.setColor(new Color(0, 0, 0));
                            if (gmaker[i_171_].equals(pnames[im]))
                                rd.drawString("Created by You", 449, 55);
                            else {
                                rd.drawString("Created by", 449, 55);
                                rd.drawString(":", 511, 55);
                                rd.drawString(gmaker[i_171_], 520, 55);
                            }
                            rd.setColor(color2k(200, 200, 200));
                            rd.drawLine(233, 64, 602, 64);
                            rd.drawLine(602, 39, 602, 64);
                            if (conon == 1) {
                                if (pgames[im] == ongame)
                                    stringbutton("Leave Game X", 660, 58, 0);
                                else
                                    stringbutton("Close X", 679, 58, 0);
                            }
                            rd.drawImage((xt).pls, 292, 81, null);
                            if (opengame != 27) {
                                (m).crs = true;
                                (m).x = -335;
                                (m).y = 0;
                                (m).z = -50;
                                (m).xz = 0;
                                (m).zy = 20;
                                (m).ground = -2000;
                                pend = 0;
                                pendb = false;
                                ptime = 0L;
                                opengame = 27;
                            }
                            int i_175_ = 0;
                            int i_176_ = -1;
                            for (int i_177_ = 0; i_177_ < npo; i_177_++) {
                                if (pgames[i_177_] == ongame) {
                                    rd.setColor(color2k(240, 240, 240));
                                    if (i_177_ == im && wait[i_171_] != -1) {
                                        if (nflk == 0 || conon == 2) {
                                            rd.setColor(color2k(255, 255, 255));
                                            nflk = 3;
                                        } else
                                            nflk--;
                                    }
                                    rd.fillRect(237, 96 + i_175_ * 42, 170, 40);
                                    rd.setColor(color2k(200, 200, 200));
                                    if (wait[i_171_] <= -1 && prevloaded == 1) {
                                        for (int i_178_ = 0; i_178_ < prnpo; i_178_++) {
                                            if (pnames[i_177_].equals(prnames[i_178_]) && ppos[i_178_] == 0 && nflk == 0)
                                                rd.setColor(new Color(0, 0, 0));
                                        }
                                    }
                                    rd.drawRect(237, 96 + i_175_ * 42, 170, 40);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pnames[i_177_], 282 - ftm.stringWidth(pnames[i_177_]) / 2, 114 + i_175_ * 42);
                                    rd.setFont(new Font("Arial", 0, 10));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pcarnames[i_177_], 282 - ftm.stringWidth(pcarnames[i_177_]) / 2, 126 + i_175_ * 42);
                                    (m).crs = true;
                                    (m).x = -335;
                                    (m).y = 0;
                                    (m).z = -50;
                                    (m).xz = 0;
                                    (m).zy = 20;
                                    (m).ground = -2000;
                                    if (pcars[i_177_] != -1) {
                                        for (int i_179_ = 0; i_179_ < (contos[pcars[i_177_]]).npl; i_179_++) {
                                            ((contos[pcars[i_177_]]).p[i_179_]).flx = 0;
                                            if (((contos[pcars[i_177_]]).p[i_179_]).colnum == 1) {
                                                ((contos[pcars[i_177_]]).p[i_179_]).hsb[0] = pcols[i_177_][0];
                                                ((contos[pcars[i_177_]]).p[i_179_]).hsb[1] = pcols[i_177_][1];
                                                ((contos[pcars[i_177_]]).p[i_179_]).hsb[2] = 1.0F - pcols[i_177_][2];
                                            }
                                            if (((contos[pcars[i_177_]]).p[i_179_]).colnum == 2) {
                                                ((contos[pcars[i_177_]]).p[i_179_]).hsb[0] = pcols[i_177_][3];
                                                ((contos[pcars[i_177_]]).p[i_179_]).hsb[1] = pcols[i_177_][4];
                                                ((contos[pcars[i_177_]]).p[i_179_]).hsb[2] = 1.0F - pcols[i_177_][5];
                                            }
                                        }
                                        if (cac[i_175_] != pcars[i_177_]) {
                                            int i_180_ = ((contos[pcars[i_177_]]).p[0]).oz[0];
                                            int i_181_ = i_180_;
                                            int i_182_ = ((contos[pcars[i_177_]]).p[0]).oy[0];
                                            int i_183_ = i_182_;
                                            for (int i_184_ = 0; i_184_ < (contos[pcars[i_177_]]).npl; i_184_++) {
                                                for (int i_185_ = 0; i_185_ < ((contos[pcars[i_177_]]).p[i_184_]).n; i_185_++) {
                                                    if (((contos[pcars[i_177_]]).p[i_184_]).oz[i_185_] < i_180_)
                                                        i_180_ = ((contos[pcars[i_177_]]).p[i_184_]).oz[i_185_];
                                                    if (((contos[pcars[i_177_]]).p[i_184_]).oz[i_185_] > i_181_)
                                                        i_181_ = ((contos[pcars[i_177_]]).p[i_184_]).oz[i_185_];
                                                    if (((contos[pcars[i_177_]]).p[i_184_]).oy[i_185_] < i_182_)
                                                        i_182_ = ((contos[pcars[i_177_]]).p[i_184_]).oy[i_185_];
                                                    if (((contos[pcars[i_177_]]).p[i_184_]).oy[i_185_] > i_183_)
                                                        i_183_ = ((contos[pcars[i_177_]]).p[i_184_]).oy[i_185_];
                                                }
                                            }
                                            cax[i_175_] = (i_181_ + i_180_) / 2;
                                            cay[i_175_] = (i_183_ + i_182_) / 2;
                                            cac[i_175_] = pcars[i_177_];
                                        }
                                        if (i > 327 && i < 402 && i_87_ > 99 + i_175_ * 42 && i_87_ < 133 + i_175_ * 42) {
                                            i_89_ = 12;
                                            i_176_ = i_177_;
                                            for (int i_186_ = 0; i_186_ < (contos[pcars[i_177_]]).npl; i_186_++)
                                                ((contos[pcars[i_177_]]).p[i_186_]).flx = 77;
                                        }
                                        (contos[pcars[i_177_]]).z = 2500 - i_175_ * 80;
                                        (contos[pcars[i_177_]]).y = 400 + 250 * i_175_ - cay[i_175_];
                                        (contos[pcars[i_177_]]).x = -145 - cax[i_175_];
                                        (contos[pcars[i_177_]]).zy = 0;
                                        (contos[pcars[i_177_]]).xz = -90;
                                        (contos[pcars[i_177_]]).xy = pend - i_175_ * 5;
                                        contos[pcars[i_177_]].d(rd);
                                    } else {
                                        rd.setFont(new Font("Arial", 1, 11));
                                        rd.setColor(color2k(80, 80, 80));
                                        rd.drawString("Loading...", 339, 119 + i_175_ * 42);
                                    }
                                    i_175_++;
                                }
                            }
                            if (!pendb) {
                                pend += 2;
                                if (pend > 80)
                                    pendb = true;
                            } else {
                                pend -= 2;
                                if (pend < -10)
                                    pendb = false;
                            }
                            if (i_176_ != -1) {
                                if (bool)
                                    mousedout = true;
                                else if (mousedout) {
                                    if (dispcar != i_176_ && i_176_ != -1 && (cd).action != 6) {
                                        (cd).action = 0;
                                        dispcar = i_176_;
                                        forcar = pcars[i_176_];
                                        dispco = null;
                                        System.gc();
                                        dispco = new ContO(contos[forcar], 0, 0, 0, 0);
                                    } else
                                        dispcar = -1;
                                    mousedout = false;
                                }
                            } else if (mousedout)
                                mousedout = false;
                            for (int i_187_ = 0; i_187_ < 7; i_187_++) {
                                for (int i_188_ = 0; i_188_ < npo; i_188_++) {
                                    if (pgames[i_188_] == ongame && invos[i_187_].equals(pnames[i_188_]) && dinvi[i_187_].equals(invos[i_187_])) {
                                        for (int i_189_ = i_187_; i_189_ < 6; i_189_++) {
                                            invos[i_189_] = invos[i_189_ + 1];
                                            dinvi[i_189_] = dinvi[i_189_ + 1];
                                        }
                                        invos[6] = "";
                                        dinvi[6] = "";
                                    }
                                }
                            }
                            if (wait[i_171_] > 0) {
                                int i_190_ = 0;
                                for (int i_191_ = i_175_; i_191_ < mnpls[i_171_]; i_191_++) {
                                    rd.setColor(color2k(200, 200, 200));
                                    rd.drawRect(237, 96 + i_191_ * 42, 170, 40);
                                    boolean bool_192_ = false;
                                    if (pgames[im] == ongame) {
                                        if (!gplyrs[i_171_].equals(""))
                                            bool_192_ = true;
                                    } else if (!gplyrs[i_171_].equals("") && gplyrs[i_171_].indexOf(pnames[im]) <= -1)
                                        bool_192_ = true;
                                    if (i > 237 && i < 407 && i_87_ > 96 + i_191_ * 42 && i_87_ < 136 + i_191_ * 42 && !bool_192_) {
                                        if (pgames[im] == ongame)
                                            stringbutton("<     Invite Player      ", 322, 121 + i_191_ * 42, 0);
                                        else
                                            stringbutton("    Join Game    ", 322, 121 + i_191_ * 42, 0);
                                        pbtn = 1;
                                    } else if (invos[i_190_].equals("")) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Empty", 322 - ftm.stringWidth("Empty") / 2, 114 + i_191_ * 42);
                                        rd.setFont(new Font("Arial", 0, 10));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Waiting for player...", 322 - ftm.stringWidth("Waiting for player...") / 2, 126 + i_191_ * 42);
                                    } else if (!dinvi[i_190_].equals(invos[i_190_])) {
                                        if (nflk != 0) {
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString("Inviting player...", 322 - ftm.stringWidth("Inviting player...") / 2, 121 + i_191_ * 42);
                                        }
                                    } else {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Player Invited!", 322 - ftm.stringWidth("Player Invited!") / 2, 113 + i_191_ * 42);
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(invos[i_190_], 322 - ftm.stringWidth(invos[i_190_]) / 2, 129 + i_191_ * 42);
                                    }
                                    i_190_++;
                                }
                            }
                            if ((xt).lan && mnbts[i_171_] != 0) {
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString(new StringBuilder().append("Plus ").append(mnbts[i_171_]).append(" MadBots!").toString(), 322 - ftm.stringWidth(new StringBuilder().append("Plus ").append(mnbts[i_171_]).append(" MadBots!").toString()) / 2, 115 + mnpls[i_171_] * 42);
                            }
                            if (dispcar <= -1 || conon != 1) {
                                rd.drawImage((xt).sts, 537, 81, null);
                                rd.setColor(color2k(200, 200, 200));
                                rd.drawRect(415, 96, 293, 124);
                                if (conon == 1) {
                                    if (wait[i_171_] > 0) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (wait[i_171_] > 30 || npls[i_171_] <= 1) {
                                            String string = "s";
                                            if (mnpls[i_171_] - npls[i_171_] == 1)
                                                string = "";
                                            rd.drawString(new StringBuilder().append("Waiting for ").append(mnpls[i_171_] - npls[i_171_]).append(" more player").append(string).append(" to join to start.").toString(), 561 - ftm.stringWidth(new StringBuilder().append("Waiting for ").append(mnpls[i_171_] - npls[i_171_]).append(" more player").append(string).append(" to join to start.").toString()) / 2, 119);
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            int i_193_ = 155;
                                            // whoah wtf does this do
                                            if (!gmaker[i_171_].equals("Coach Insano") && !gmaker[i_171_].equals(pnames[im])) {
                                                boolean bool_194_ = false;
                                                for (int i_195_ = 0; i_195_ < npo; i_195_++) {
                                                    if (pgames[i_195_] == ongame && gmaker[i_171_].equals(pnames[i_195_]))
                                                        bool_194_ = true;
                                                }
                                                if (bool_194_) {
                                                    i_193_ = 165;
                                                    rd.drawString(new StringBuilder().append("").append(gmaker[i_171_]).append(" can start this game at anytime.").toString(), 561 - ftm.stringWidth(new StringBuilder().append("").append(gmaker[i_171_]).append(" can start this game at anytime.").toString()) / 2, 145);
                                                }
                                            }
                                            if (npls[i_171_] > 1) {
                                                String string_196_ = new StringBuilder().append("").append(wait[i_171_]).append(" seconds").toString();
                                                if (wait[i_171_] > 60)
                                                    string_196_ = new StringBuilder().append("").append((float) (int) ((float) wait[i_171_] / 60.0F * 100.0F) / 100.0F).append(" minutes").toString();
                                                rd.drawString(new StringBuilder().append("(Waiting ").append(string_196_).append(" maximum! )").toString(), 561 - ftm.stringWidth(new StringBuilder().append("(Waiting ").append(string_196_).append(" maximum! )").toString()) / 2, i_193_);
                                            }
                                        } else {
                                            Date date = new Date();
                                            long l = date.getTime();
                                            if (ptime == 0L || l > ptime + 1500L) {
                                                if (ptime != 0L) {
                                                    wait[i_171_]--;
                                                    if (wait[i_171_] < 1)
                                                        wait[i_171_] = 1;
                                                }
                                                ptime = l;
                                            }
                                            if (pgames[im] == ongame || nflk != 0) {
                                                rd.drawString(new StringBuilder().append("Game starts in ").append(wait[i_171_]).append(" seconds!").toString(), 561 - ftm.stringWidth(new StringBuilder().append("Game starts in ").append(wait[i_171_]).append(" seconds!").toString()) / 2, 145);
                                                if (pgames[im] != ongame)
                                                    nflk--;
                                            } else if (pgames[im] != ongame)
                                                nflk = 3;
                                        }
                                        if (pgames[im] != ongame) {
                                            if (gplyrs[i_171_].equals("") || gplyrs[i_171_].indexOf(pnames[im]) != -1)
                                                stringbutton("    Join this Game    ", 561, 203, 0);
                                            else {
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(128, 73, 0));
                                                rd.drawString("Private Game, only specific players allowed.", 561 - ftm.stringWidth("Private Game, only specific players allowed!") / 2, 201);
                                            }
                                        } else if (gmaker[i_171_].equals(pnames[im])) {
                                            if (npls[i_171_] > 1) {
                                                if (!fstart)
                                                    stringbutton("    Start this Game Now!    ", 561, 203, 0);
                                                else
                                                    stringbutton("    Starting game now, one moment...    ", 561, 203, 0);
                                            } else {
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(128, 73, 0));
                                                rd.drawString("You have created this game.", 561 - ftm.stringWidth("You have created this game.") / 2, 201);
                                            }
                                        } else {
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.setColor(new Color(80, 128, 0));
                                            rd.drawString("You have joined this game.", 561 - ftm.stringWidth("You have joined this game.") / 2, 201);
                                        }
                                    } else if (prevloaded == 1) {
                                        int i_197_ = (int) (80.0 + (double) (float) rerr / 1.243);
                                        if (i_197_ > 255)
                                            i_197_ = 255;
                                        if (i_197_ < 0)
                                            i_197_ = 0;
                                        int i_198_ = (int) (128.0 + (double) (float) rerr / 2.428);
                                        if (i_198_ > 255)
                                            i_198_ = 255;
                                        if (i_198_ < 0)
                                            i_198_ = 0;
                                        int i_199_ = rerr;
                                        if (i_199_ > 255)
                                            i_199_ = 255;
                                        if (i_199_ < 0)
                                            i_199_ = 0;
                                        if (wait[i_171_] == 0) {
                                            rd.setColor(new Color(i_197_, i_198_, i_199_));
                                            rd.setFont(new Font("Arial", 1, 12));
                                            rd.drawString("Live Info!", 621, 93);
                                            rd.drawString("Live Info!", 451, 93);
                                        }
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Tahoma", 1, 11));
                                        rd.drawString("Player       Position   Laps      Power        Damage", 439, 111);
                                        rd.setColor(color2k(200, 200, 200));
                                        if (prnpo < 7) {
                                            rd.drawLine(489, 103, 489, 185);
                                            rd.drawLine(542, 103, 542, 185);
                                            rd.drawLine(579, 103, 579, 185);
                                            rd.drawLine(641, 103, 641, 185);
                                            rd.drawLine(422, 114, 702, 114);
                                            rd.drawLine(422, 186, 702, 186);
                                        } else {
                                            rd.drawLine(489, 103, 489, 193);
                                            rd.drawLine(542, 103, 542, 193);
                                            rd.drawLine(579, 103, 579, 193);
                                            rd.drawLine(641, 103, 641, 233);
                                            rd.drawLine(422, 114, 702, 114);
                                            rd.drawLine(422, 194, 702, 194);
                                        }
                                        i_175_ = 0;
                                        for (int i_200_ = 0; i_200_ < prnpo; i_200_++) {
                                            for (int i_201_ = 0; i_201_ < prnpo; i_201_++) {
                                                if (ppos[i_201_] == i_200_) {
                                                    rd.setFont(new Font("Tahoma", 0, 11));
                                                    ftm = rd.getFontMetrics();
                                                    rd.setColor(new Color(0, 44, 124));
                                                    rd.drawString(prnames[i_201_], 455 - ftm.stringWidth(prnames[i_201_]) / 2, 125 + 11 * i_175_);
                                                    if (pdam[i_201_] < 55 && pdam[i_201_] != -17) {
                                                        rd.setColor(new Color(80, 128, 0));
                                                        String string = "th";
                                                        if (ppos[i_201_] == 0)
                                                            string = "st";
                                                        if (ppos[i_201_] == 1)
                                                            string = "nd";
                                                        if (ppos[i_201_] == 2)
                                                            string = "rd";
                                                        rd.drawString(new StringBuilder().append("").append(ppos[i_201_] + 1).append("").append(string).toString(), 515 - ftm.stringWidth(new StringBuilder().append("").append(ppos[i_201_] + 1).append("").append(string).toString()) / 2, 125 + 11 * i_175_);
                                                        rd.setColor(new Color(128, 73, 0));
                                                        if (plap[i_201_] > gnlaps[i_171_] - 1)
                                                            plap[i_201_] = gnlaps[i_171_] - 1;
                                                        rd.drawString(new StringBuilder().append("").append(plap[i_201_] + 1).append(" / ").append(gnlaps[i_171_]).append("").toString(), 560 - ftm.stringWidth(new StringBuilder().append("").append(plap[i_201_] + 1).append(" / ").append(gnlaps[i_171_]).append("").toString()) / 2, 125 + 11 * i_175_);
                                                        rd.setColor(new Color(0, 128, 255));
                                                        rd.drawRect(582, 118 + 11 * i_175_, 56, 6);
                                                        rd.fillRect(583, 121 + 11 * i_175_, ppow[i_201_], 3);
                                                        rd.setColor(new Color(128, 210, 255));
                                                        rd.fillRect(583, 119 + 11 * i_175_, ppow[i_201_], 2);
                                                        rd.setColor(new Color(255, 0, 0));
                                                        rd.drawRect(645, 118 + 11 * i_175_, 56, 6);
                                                        rd.fillRect(646, 121 + 11 * i_175_, pdam[i_201_], 3);
                                                        rd.setColor(new Color(255, 155, 64));
                                                        rd.fillRect(646, 119 + 11 * i_175_, pdam[i_201_], 2);
                                                    } else {
                                                        i_197_ = (int) (85.0 + (double) (float) (rerr * 2) / 1.5);
                                                        if (i_197_ > 255)
                                                            i_197_ = 255;
                                                        if (i_197_ < 0)
                                                            i_197_ = 0;
                                                        rd.setColor(color2k(i_197_, i_197_, i_197_));
                                                        rd.fillRect(490, 117 + 11 * i_175_, 213, 9);
                                                        rd.setFont(new Font("Tahoma", 1, 11));
                                                        ftm = rd.getFontMetrics();
                                                        i_197_ = 255 - rerr * 2;
                                                        if (i_197_ > 255)
                                                            i_197_ = 255;
                                                        if (i_197_ < 0)
                                                            i_197_ = 0;
                                                        i_198_ = (int) (155.0 - (double) (float) (rerr * 2) / 1.645);
                                                        if (i_198_ > 255)
                                                            i_198_ = 255;
                                                        if (i_198_ < 0)
                                                            i_198_ = 0;
                                                        i_199_ = (int) (64.0 - (double) (float) (rerr * 2) / 3.984);
                                                        if (i_199_ > 255)
                                                            i_199_ = 255;
                                                        if (i_199_ < 0)
                                                            i_199_ = 0;
                                                        rd.setColor(new Color(i_197_, i_198_, i_199_));
                                                        if (pdam[i_201_] != -17)
                                                            rd.drawString("=   =   =   =    W A S T E D    =   =   =   =", 597 - ftm.stringWidth("=   =   =   =    W A S T E D    =   =   =   =") / 2, 126 + 11 * i_175_);
                                                        else
                                                            rd.drawString("=   =   =   DISCONNECTED   =   =   =", 597 - ftm.stringWidth("=   =   =   DISCONNECTED   =   =   =") / 2, 126 + 11 * i_175_);
                                                    }
                                                    i_175_++;
                                                }
                                            }
                                        }
                                        int i_202_ = 0;
                                        int i_203_ = 3;
                                        if (prnpo < 7) {
                                            i_202_ = 5;
                                            i_203_ = 0;
                                        }
                                        if (wait[i_171_] == 0)
                                            stringbutton("    Watch Live Now!    ", 561, 212 - i_202_, i_203_);
                                        else {
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            String string = "";
                                            for (int i_204_ = 0; i_204_ < prnpo; i_204_++) {
                                                if (ppos[i_204_] == 0)
                                                    string = prnames[i_204_];
                                            }
                                            if (string.equals(""))
                                                rd.drawString("Game Finished!", 561 - ftm.stringWidth("Game Finished!") / 2, 212 - i_202_);
                                            else {
                                                rd.drawString(new StringBuilder().append("Game Finished!    Winner:  ").append(string).append("").toString(), 561 - ftm.stringWidth(new StringBuilder().append("Game Finished!    Winner:  ").append(string).append("").toString()) / 2, 212 - i_202_);
                                                if (nflk == 0) {
                                                    rd.setColor(new Color(255, 176, 67));
                                                    nflk = 3;
                                                } else
                                                    nflk--;
                                                rd.drawString(new StringBuilder().append("").append(string).append("").toString(), 561 - ftm.stringWidth(new StringBuilder().append("Game Finished!    Winner:  ").append(string).append("").toString()) / 2 + ftm.stringWidth("Game Finished!    Winner:  "), 212 - i_202_);
                                            }
                                        }
                                        rerr += 3;
                                    } else {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (prevloaded <= -1) {
                                            if (!(xt).lan)
                                                rd.drawString("Loading Info...", 561 - ftm.stringWidth("Loading Info...") / 2, 155);
                                            else if (pgames[im] == ongame)
                                                rd.drawString("About to Start...", 561 - ftm.stringWidth("About to Start...") / 2, 155);
                                            else {
                                                rd.drawString("Game Started!", 561 - ftm.stringWidth("Game Started!") / 2, 135);
                                                stringbutton("    Watch this Game    ", 561, 175, 0);
                                            }
                                        } else
                                            rd.drawString("About to Start...", 561 - ftm.stringWidth("About to Start...") / 2, 155);
                                    }
                                } else {
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    if (conon == 2)
                                        rd.drawString("Starting Game Now!", 561 - ftm.stringWidth("Starting Game Now!") / 2, 145);
                                    if (conon == 3)
                                        rd.drawString("Opening Game Now!", 561 - ftm.stringWidth("Opening Game Now!") / 2, 145);
                                    rd.setFont(new Font("Arial", 0, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString("Please Wait...", 561 - ftm.stringWidth("Please Wait...") / 2, 175);
                                }
                                if (gstgn[i_171_] < 0) {
                                    rd.setColor(new Color(239, 234, 177));
                                    rd.fillRect(415, 222, 293, 40);
                                }
                                rd.setColor(color2k(200, 200, 200));
                                rd.drawRect(415, 222, 293, 40);
                                rd.drawImage((xt).stg, 422, 227, null);
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 10));
                                ftm = rd.getFontMetrics();
                                rd.drawString(new StringBuilder().append("Laps: ").append(gnlaps[i_171_]).append("").toString(), 660, 235);
                                if (i > 415 && i < 708 && i_87_ > 222 && i_87_ < 262 && (wait[i_171_] > 0 || gstgn[i_171_] < 0) && conon == 1) {
                                    stringbutton("       Preview Stage       ", 562, 247, 0);
                                    pbtn = 2;
                                } else {
                                    if (gstgn[i_171_] > 0) {
                                        String string = "NFM 1";
                                        int i_205_ = gstgn[i_171_];
                                        if (gstgn[i_171_] > 10) {
                                            string = "NFM 2";
                                            i_205_ = gstgn[i_171_] - 10;
                                        }
                                        if (gstgn[i_171_] > 27) {
                                            string = "Multiplayer";
                                            i_205_ = gstgn[i_171_] - 27;
                                        }
                                        rd.drawString(new StringBuilder().append("").append(string).append(" - Stage ").append(i_205_).append("").toString(), 562 - ftm.stringWidth(new StringBuilder().append("").append(string).append(" - Stage ").append(i_205_).append("").toString()) / 2, 237);
                                    } else
                                        rd.drawString("Custom Stage", 562 - ftm.stringWidth("Custom Stage") / 2, 237);
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(gstages[i_171_], 562 - ftm.stringWidth(gstages[i_171_]) / 2, 254);
                                }
                                if (!(xt).lan) {
                                    int i_206_ = 237;
                                    int i_207_ = 471;
                                    if (wait[i_171_] > 0) {
                                        if (mnpls[i_171_] > 4) {
                                            i_206_ = 415;
                                            i_207_ = 293;
                                        }
                                    } else if (npls[i_171_] > 4) {
                                        i_206_ = 415;
                                        i_207_ = 293;
                                    }
                                    rd.setColor(color2k(200, 200, 200));
                                    rd.drawRect(i_206_, 264, i_207_, 124);
                                    rd.setColor(color2k(240, 240, 240));
                                    rd.fillRect(i_206_ + 1, 265, i_207_ - 1, 21);
                                    rd.drawImage((xt).gmc, i_206_ + 7, 269, null);
                                    rd.setFont(new Font("Tahoma", 0, 11));
                                    rd.setColor(color2k(110, 110, 110));
                                    rd.drawString("(Game Chat )", i_206_ + 57, 278);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (updatec != -1) {
                                        String[] strings = new String[7];
                                        String[] strings_208_ = new String[7];
                                        boolean[] bools = { false, false, false, false, false, false, false };
                                        for (int i_209_ = 0; i_209_ < 7; i_209_++) {
                                            strings[i_209_] = "";
                                            strings_208_[i_209_] = cnames[i_209_];
                                            int i_210_ = 0;
                                            int i_211_ = 0;
                                            int i_212_ = 0;
                                            int i_213_ = 0;
                                            int i_214_ = 0;
                                            for (/**/; i_210_ < sentn[i_209_].length(); i_210_++) {
                                                String string = new StringBuilder().append("").append(sentn[i_209_].charAt(i_210_)).toString();
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
                                                    if (ftm.stringWidth(strings[i_209_]) > i_207_ - 94) {
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
                                        rd.setFont(new Font("Tahoma", 1, 11));
                                        ftm = rd.getFontMetrics();
                                        for (int i_218_ = 0; i_218_ < 7; i_218_++) {
                                            if (!string.equals(strings_208_[i_218_])) {
                                                rd.drawString(new StringBuilder().append(strings_208_[i_218_]).append(":").toString(), i_206_ + 84 - ftm.stringWidth(new StringBuilder().append(strings_208_[i_218_]).append(":").toString()), 299 + i_218_ * 14);
                                                string = strings_208_[i_218_];
                                            }
                                        }
                                        rd.setFont(new Font("Tahoma", 0, 11));
                                        for (int i_219_ = 0; i_219_ < 7; i_219_++) {
                                            if (bools[i_219_] && i_219_ == 0 && strings[i_219_].indexOf(" ") != -1)
                                                strings[i_219_] = new StringBuilder().append("...").append(strings[i_219_].substring(strings[i_219_].indexOf(" "), strings[i_219_].length())).append("").toString();
                                            rd.drawString(strings[i_219_], i_206_ + 88, 299 + i_219_ * 14);
                                        }
                                    } else
                                        rd.drawString("Loading chat...", i_206_ + i_207_ / 2 - ftm.stringWidth("Loading chat...") / 2, 315);
                                    if (conon == 1)
                                        pre2 = true;
                                    else
                                        hideinputs();
                                    if ((control).enter && !(gs).cmsg.getText().equals("Type here...") && !(gs).cmsg.getText().equals("")) {
                                        pessd[btn] = true;
                                        (control).enter = false;
                                        String string = (gs).cmsg.getText().replace('|', ':');
                                        if (string.toLowerCase().indexOf((gs).tpass.getText().toLowerCase()) != -1)
                                            string = " ";
                                        if (!xt.msgcheck(string) && updatec > -12) {
                                            for (int i_220_ = 0; i_220_ < 6; i_220_++) {
                                                sentn[i_220_] = sentn[i_220_ + 1];
                                                cnames[i_220_] = cnames[i_220_ + 1];
                                            }
                                            sentn[6] = string;
                                            cnames[6] = pnames[im];
                                            if (updatec > -11)
                                                updatec = -11;
                                            else
                                                updatec--;
                                        } else
                                            (xt).warning++;
                                        (gs).cmsg.setText("");
                                    }
                                    stringbutton("Send Message", 655, 405, 3);
                                }
                            } else {
                                if ((gs).cmsg.isShowing())
                                    (gs).cmsg.hide();
                                if (pcars[dispcar] == forcar && forcar != -1) {
                                    rd.drawImage((xt).crd, 517, 81, null);
                                    rd.setColor(new Color(16, 198, 255));
                                    rd.drawRect(415, 96, 293, 315);
                                    rd.setColor(color2k(240, 240, 240));
                                    rd.fillRect(416, 97, 4, 314);
                                    rd.fillRect(704, 97, 4, 314);
                                    rd.fillRect(416, 97, 292, 4);
                                    rd.fillRect(416, 407, 292, 4);
                                    if (flks >= 0) {
                                        rd.setColor(new Color(239, 234, 177));
                                        flks++;
                                        if (flks > 3)
                                            flks = -1;
                                    } else {
                                        rd.setColor(new Color(224, 226, 176));
                                        flks--;
                                        if (flks < -4)
                                            flks = 0;
                                    }
                                    rd.fillRect(445, 120, 233, 127);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString((cd).names[forcar], 561 - ftm.stringWidth((cd).names[forcar]) / 2, 117);
                                    for (int i_221_ = 0; i_221_ < (dispco).npl; i_221_++) {
                                        if (((contos[forcar]).p[i_221_]).colnum == 1) {
                                            ((dispco).p[i_221_]).hsb[0] = pcols[dispcar][0];
                                            ((dispco).p[i_221_]).hsb[1] = pcols[dispcar][1];
                                            ((dispco).p[i_221_]).hsb[2] = 1.0F - pcols[dispcar][2];
                                        }
                                        if (((contos[forcar]).p[i_221_]).colnum == 2) {
                                            ((dispco).p[i_221_]).hsb[0] = pcols[dispcar][3];
                                            ((dispco).p[i_221_]).hsb[1] = pcols[dispcar][4];
                                            ((dispco).p[i_221_]).hsb[2] = 1.0F - pcols[dispcar][5];
                                        }
                                    }
                                    (m).cx = 561;
                                    (dispco).z = 1200;
                                    (dispco).y = 605 - (dispco).grat;
                                    (dispco).x = 225;
                                    (dispco).zy = 0;
                                    (dispco).xz = mrot;
                                    mrot -= 5;
                                    if (mrot < -360)
                                        mrot += 360;
                                    (dispco).xy = 0;
                                    (dispco).wzy -= 10;
                                    if ((dispco).wzy < -45)
                                        (dispco).wzy += 45;
                                    dispco.d(rd);
                                    (m).cx = 400;
                                    rd.setFont(new Font("Arial", 1, 11));
                                    int i_222_ = 424;
                                    int i_223_ = -55;
                                    rd.setColor(new Color(0, 63, 128));
                                    rd.drawString("Top Speed:", 30 + i_222_, 318 + i_223_);
                                    rd.drawImage((xt).statb, 97 + i_222_, 312 + i_223_, null);
                                    rd.drawString("Acceleration:", 20 + i_222_, 333 + i_223_);
                                    rd.drawImage((xt).statb, 97 + i_222_, 327 + i_223_, null);
                                    rd.setColor(color2k(255, 255, 255));
                                    float f = (float) ((cd).swits[forcar][2] - 220) / 90.0F;
                                    if ((double) f < 0.2)
                                        f = 0.2F;
                                    rd.fillRect((int) (97.0F + 156.0F * f) + i_222_, 312 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    f = (cd).acelf[forcar][1] * (cd).acelf[forcar][0] * (cd).acelf[forcar][2] * (cd).grip[forcar] / 7700.0F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    rd.fillRect((int) (97.0F + 156.0F * f) + i_222_, 327 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    rd.drawImage((xt).statbo, 97 + i_222_, 312 + i_223_, null);
                                    rd.drawImage((xt).statbo, 97 + i_222_, 327 + i_223_, null);
                                    i_222_ = 50;
                                    i_223_ = -25;
                                    rd.setColor(new Color(0, 63, 128));
                                    rd.drawString("Stunts:", 427 + i_222_, 318 + i_223_);
                                    rd.drawImage((xt).statb, 471 + i_222_, 312 + i_223_, null);
                                    rd.drawString("Strength:", 415 + i_222_, 333 + i_223_);
                                    rd.drawImage((xt).statb, 471 + i_222_, 327 + i_223_, null);
                                    rd.drawString("Endurance:", 405 + i_222_, 348 + i_223_);
                                    rd.drawImage((xt).statb, 471 + i_222_, 342 + i_223_, null);
                                    rd.setColor(color2k(255, 255, 255));
                                    f = ((float) (cd).airc[forcar] * (cd).airs[forcar] * (cd).bounce[forcar] + 28.0F) / 139.0F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i_222_, 312 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    float f_224_ = 0.5F;
                                    f = ((cd).moment[forcar] + f_224_) / 2.6F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i_222_, 327 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    f = (cd).outdam[forcar];
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i_222_, 342 + i_223_, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    rd.drawImage((xt).statbo, 471 + i_222_, 312 + i_223_, null);
                                    rd.drawImage((xt).statbo, 471 + i_222_, 327 + i_223_, null);
                                    rd.drawImage((xt).statbo, 471 + i_222_, 342 + i_223_, null);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (forcar < 16) {
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Created by Radicalplay.com", 561 - ftm.stringWidth("Created by Radicalplay.com") / 2, 347);
                                        String string = "Game Car";
                                        if ((cd).cclass[forcar] == 0)
                                            string = "Class C ,  Game Car";
                                        if ((cd).cclass[forcar] == 1)
                                            string = "Class B & C ,  Game Car";
                                        if ((cd).cclass[forcar] == 2)
                                            string = "Class B ,  Game Car";
                                        if ((cd).cclass[forcar] == 3)
                                            string = "Class A & B ,  Game Car";
                                        if ((cd).cclass[forcar] == 4)
                                            string = "Class A ,  Game Car";
                                        rd.drawString(string, 561 - ftm.stringWidth(string) / 2, 367);
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("You already have this car.", 561 - ftm.stringWidth("You already have this car.") / 2, 395);
                                    } else {
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (!(cd).createdby[forcar - 16].equals((xt).nickname))
                                            rd.drawString(new StringBuilder().append("Created by :  ").append((cd).createdby[forcar - 16]).append("").toString(), 561 - ftm.stringWidth(new StringBuilder().append("Created by :  ").append((cd).createdby[forcar - 16]).append("").toString()) / 2, 347);
                                        else
                                            rd.drawString("Created by You", 561 - ftm.stringWidth("Created by You") / 2, 347);
                                        rd.setColor(new Color(128, 73, 0));
                                        String string = "";
                                        if ((cd).cclass[forcar] == 0)
                                            string = "Class C ,  ";
                                        if ((cd).cclass[forcar] == 1)
                                            string = "Class B & C ,  ";
                                        if ((cd).cclass[forcar] == 2)
                                            string = "Class B ,  ";
                                        if ((cd).cclass[forcar] == 3)
                                            string = "Class A & B ,  ";
                                        if ((cd).cclass[forcar] == 4)
                                            string = "Class A ,  ";
                                        if ((cd).publish[forcar - 16] == 0)
                                            string = new StringBuilder().append(string).append("Private Car").toString();
                                        if ((cd).publish[forcar - 16] == 1) {
                                            string = new StringBuilder().append(string).append("Public Car").toString();
                                            rd.setColor(new Color(0, 64, 128));
                                        }
                                        if ((cd).publish[forcar - 16] == 2) {
                                            string = new StringBuilder().append(string).append("Super Public Car").toString();
                                            rd.setColor(new Color(0, 64, 128));
                                        }
                                        rd.drawString(string, 561 - ftm.stringWidth(string) / 2, 367);
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        if ((cd).publish[forcar - 16] == 1 || (cd).publish[forcar - 16] == 2) {
                                            if ((cd).action == -9)
                                                rd.drawString("Failed to add car!  Unknown error!", 561 - ftm.stringWidth("Failed to add car!  Unknown error!") / 2, 395);
                                            if ((cd).action == -8)
                                                rd.drawString("Failed!  You already have 20 cars!", 561 - ftm.stringWidth("Failed!  You already have 20 cars!") / 2, 395);
                                            if ((cd).action == 7)
                                                rd.drawString(new StringBuilder().append("").append((cd).names[(cd).ac]).append(" has been added to your cars!").toString(), 561 - ftm.stringWidth(new StringBuilder().append("").append((cd).names[(cd).ac]).append(" has been added to your cars!").toString()) / 2, 395);
                                            if ((cd).action == -7)
                                                rd.drawString("You already have this car.", 561 - ftm.stringWidth("You already have this car.") / 2, 395);
                                            if ((cd).action == 6)
                                                rd.drawString("Adding Car...", 561 - ftm.stringWidth("Adding Car...") / 2, 395);
                                            if ((cd).action == -6) {
                                                String string_225_ = "Upgrade to a full account to add custom cars!";
                                                int i_226_ = 561 - ftm.stringWidth(string_225_) / 2;
                                                int i_227_ = i_226_ + ftm.stringWidth(string_225_);
                                                rd.drawString(string_225_, i_226_, 395);
                                                if (waitlink != -1)
                                                    rd.drawLine(i_226_, 396, i_227_, 396);
                                                if (i > i_226_ && i < i_227_ && i_87_ > 384 && i_87_ < 397) {
                                                    if (waitlink != -1)
                                                        i_89_ = 12;
                                                    if (bool && waitlink == 0) {
                                                        gs.editlink((xt).nickname);
                                                        waitlink = -1;
                                                    }
                                                }
                                                if (waitlink > 0)
                                                    waitlink--;
                                            }
                                            if ((cd).action == 0 && xt.drawcarb(true, null, " Add to My Cars ", 503, 375, i, i_87_, bool)) {
                                                if ((xt).logged) {
                                                    if ((cd).lastload != 2 || forcar >= 36) {
                                                        if ((cd).nlocars < 36) {
                                                            (cd).action = 6;
                                                            (cd).ac = forcar;
                                                            cd.sparkactionloader();
                                                        } else
                                                            (cd).action = -8;
                                                    } else
                                                        (cd).action = -7;
                                                } else {
                                                    (cd).action = -6;
                                                    waitlink = 20;
                                                }
                                            }
                                        } else
                                            rd.drawString("Private Car.  Cannot be added to account.", 561 - ftm.stringWidth("Private Car.  Cannot be added to account.") / 2, 395);
                                    }
                                    if (xt.drawcarb(true, null, "X", 682, 99, i, i_87_, bool))
                                        dispcar = -1;
                                } else
                                    dispcar = -1;
                            }
                        }
                    }
                } else {
                    if (!jflexo) {
                        xt.jflexo();
                        jflexo = true;
                    }
                    btn = 0;
                    if ((gs).cmsg.isShowing()) {
                        (gs).cmsg.hide();
                        gs.requestFocus();
                    }
                    rd.setColor(color2k(255, 255, 255));
                    rd.fillRoundRect(155, 148, 490, 127, 20, 20);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawRoundRect(155, 148, 490, 127, 20, 20);
                    if (ontyp != 76) {
                        String string = "";
                        int i_228_ = 0;
                        if (ontyp >= 10) {
                            i_228_ = 10;
                            string = "Custom Cars";
                            if (ontyp > 10)
                                string = new StringBuilder().append(string).append(", ").toString();
                        }
                        if (ontyp >= 20) {
                            i_228_ = 20;
                            string = "Game Cars";
                            if (ontyp > 20)
                                string = new StringBuilder().append(string).append(", ").toString();
                        }
                        if (ontyp - i_228_ == 1)
                            string = new StringBuilder().append(string).append("Class C").toString();
                        if (ontyp - i_228_ == 2)
                            string = new StringBuilder().append(string).append("Class B & C").toString();
                        if (ontyp - i_228_ == 3)
                            string = new StringBuilder().append(string).append("Class B").toString();
                        if (ontyp - i_228_ == 4)
                            string = new StringBuilder().append(string).append("Class A & B").toString();
                        if (ontyp - i_228_ == 5)
                            string = new StringBuilder().append(string).append("Class A").toString();
                        if (ontyp <= -2) {
                            if (Math.abs(ontyp + 2) == 13)
                                string = new StringBuilder().append(" ").append((cd).names[Math.abs(ontyp + 2)]).append("  Game").toString();
                            else
                                string = new StringBuilder().append("").append((cd).names[Math.abs(ontyp + 2)]).append(" Game").toString();
                        }
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(new StringBuilder().append(": :   ").append(string).append("   : :").toString(), 400 - ftm.stringWidth(new StringBuilder().append(": :   ").append(string).append("   : :").toString()) / 2, 175);
                        string = "a";
                        if (ontyp - i_228_ == 1)
                            string = "a class C";
                        if (ontyp - i_228_ == 2)
                            string = "a class B or C";
                        if (ontyp - i_228_ == 3)
                            string = "a class B";
                        if (ontyp - i_228_ == 4)
                            string = "a class A or B";
                        if (ontyp - i_228_ == 5)
                            string = "a class A";
                        if (i_228_ == 0)
                            string = new StringBuilder().append(string).append(" car").toString();
                        if (i_228_ == 10)
                            string = new StringBuilder().append(string).append(" custom car").toString();
                        if (i_228_ == 20)
                            string = new StringBuilder().append(string).append(" game car").toString();
                        if (ontyp <= -2) {
                            if (Math.abs(ontyp + 2) == 13)
                                string = new StringBuilder().append(" ").append((cd).names[Math.abs(ontyp + 2)]).append(" ").toString();
                            else
                                string = new StringBuilder().append("").append((cd).names[Math.abs(ontyp + 2)]).append("").toString();
                        }
                        rd.drawString(new StringBuilder().append("To join this game you need to have ").append(string).append("!").toString(), 400 - ftm.stringWidth(new StringBuilder().append("To join this game you need to have ").append(string).append("!").toString()) / 2, 206);
                        stringbutton(new StringBuilder().append("  Get ").append(string).append(" now...  ").toString(), 400, 247, 0);
                        stringbutton("  Cancel X  ", 593, 259, 2);
                    } else {
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(": :   Custom Stage   : :", 400 - ftm.stringWidth(": :   Custom Stage   : :") / 2, 175);
                        rd.drawString("You need to have a full account to join this game!", 400 - ftm.stringWidth("You need to have a full account to join this game!") / 2, 206);
                        stringbutton("  Upgrade Account  ", 400, 247, 0);
                        stringbutton("  Cancel X  ", 593, 259, 2);
                    }
                }
            } else {
                xt.mainbg(3);
                btn = 0;
                if ((gs).cmsg.isShowing()) {
                    (gs).cmsg.hide();
                    gs.requestFocus();
                }
                rd.setColor(color2k(240, 240, 240));
                rd.fillRoundRect(160, 75, 480, 300, 20, 20);
                rd.setColor(color2k(145, 145, 145));
                rd.drawRoundRect(160, 75, 480, 300, 20, 20);
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                rd.setColor(color2k(0, 0, 0));
                rd.drawString("You have played the allowed 5 games!  Please register.", 180, 105);
                rd.setColor(color2k(90, 90, 90));
                rd.drawString("You are allowed 5 free games of online multiplayer per day.", 180, 125);
                rd.drawString("Register to play unlimitedly!", 180, 145);
                rd.drawString(new StringBuilder().append("You will be able to play again tomorrow or in ").append((float) (xt).hours / 10.0F).append(" hours exactly.").toString(), 180, 185);
                rd.drawString("Now until tomorrow, you can only watch games!", 180, 205);
                rd.setColor(color2k(0, 0, 0));
                rd.drawString("Register an account to enjoy playing the game with no limitations", 180, 265);
                rd.drawString("and with all the multiplayer options available!", 180, 285);
                stringbutton("  Register Now!  ", 315, 325, 0);
                stringbutton("  Exit  ", 515, 325, 0);
            }
        } else {
        	// SWEAR WARNING...IT MAY GET YOU KICKED SERVERSIDE...
            //xt.drawWarning();
            //if ((gs).cmsg.isShowing()) {
            //    (gs).cmsg.hide();
            //    gs.requestFocus();
            //}
            /*if ((xt).warning > 220) {
                conon = 0;
                try {
                    socket.close();
                    socket = null;
                    din.close();
                    din = null;
                    dout.close();
                    dout = null;
                } catch (Exception exception) {}
            }*/
            //(xt).warning++;
        }
        if (i_89_ != pcurs) {
            gs.setCursor(new Cursor(i_89_));
            pcurs = i_89_;
        }
    }
    
    public void preforma(int i, int i_229_) {
        if (pre1) {
            if (!(gs).openm && (gb).open == 0) {
                if (conon != 0 && !(gs).cmsg.isShowing()) {
                    (gs).cmsg.show();
                    (gs).cmsg.requestFocus();
                    prereq = 2;
                }
            } else if ((gs).cmsg.isShowing())
                (gs).cmsg.hide();
            gs.movefield((gs).cmsg, 235, 390, 360, 22);
            if ((gs).cmsg.getText().equals("Type here...") && i > 234 && i < 603 && i_229_ > 385 && i_229_ < 417)
                (gs).cmsg.setText("");
        }
        if (pre2) {
            if (!(gs).openm && (gb).open == 0) {
                if (!(gs).cmsg.isShowing()) {
                    (gs).cmsg.show();
                    (gs).cmsg.requestFocus();
                    prereq = 2;
                }
            } else if ((gs).cmsg.isShowing())
                (gs).cmsg.hide();
            gs.movefield((gs).cmsg, 237, 390, 360, 22);
            if ((gs).cmsg.getText().equals("Type here...") && i > 232 && i < 601 && i_229_ > 385 && i_229_ < 417)
                (gs).cmsg.setText("");
        }
        if (pre1 || pre2) {
            if ((gs).cmsg.getText().length() > 100) {
                (gs).cmsg.setText((gs).cmsg.getText().substring(0, 100));
                (gs).cmsg.select(100, 100);
            }
            pre1 = false;
            pre2 = false;
        }
        if (prereq != 0) {
            if (prereq == 1)
                gs.requestFocus();
            prereq--;
        }
    }
    
    public void stageselect(CheckPoints checkpoints, Control control, int i, int i_230_, boolean bool) {
        btn = 0;
        int i_231_ = 0;
        rd.drawImage((xt).br, 65, 25, null);
        if (britchl <= -1) {
            ongame = -1;
            britchl = 0;
        }
        int i_232_ = 0;
        for (int i_233_ = 0; i_233_ < ngm; i_233_++) {
            if (ongame == gnum[i_233_])
                i_232_ = i_233_;
        }
        if (chalngd != -2 && ongame != -1) {
            rd.setColor(color2k(20, 20, 20));
            rd.fillRect(80, 25, 640, 40);
            rd.setColor(color2k(70, 70, 70));
            rd.drawLine(80, 65, 720, 65);
            rd.drawLine(80, 65, 80, 25);
            rd.drawLine(720, 65, 720, 25);
            rd.setColor(color2k(210, 210, 210));
            rd.setFont(new Font("Arial", 1, 12));
            ftm = rd.getFontMetrics();
            if (wait[i_232_] > 0) {
                if (wait[i_232_] > 30 || npls[i_232_] <= 1) {
                    String string = "";
                    if (npls[i_232_] > 1) {
                        Date date = new Date();
                        long l = date.getTime();
                        if (ptime == 0L || l > ptime + 1500L) {
                            if (ptime != 0L) {
                                wait[i_232_]--;
                                if (wait[i_232_] < 1)
                                    wait[i_232_] = 1;
                            }
                            ptime = l;
                        }
                        string = new StringBuilder().append(" (waiting ").append(wait[i_232_]).append(" seconds maximum)").toString();
                        if (wait[i_232_] > 60)
                            string = new StringBuilder().append(" (waiting ").append((float) (int) ((float) wait[i_232_] / 60.0F * 100.0F) / 100.0F).append(" minutes maximum)").toString();
                    }
                    rd.drawString(new StringBuilder().append("Waiting for ").append(mnpls[i_232_] - npls[i_232_]).append(" more players to join to start this game").append(string).append("!").toString(), 95, 40);
                    rd.setFont(new Font("Arial", 0, 12));
                    if (!gmaker[i_232_].equals("Coach Insano") && !gmaker[i_232_].equals(pnames[im])) {
                        boolean bool_234_ = false;
                        for (int i_235_ = 0; i_235_ < npo; i_235_++) {
                            if (pgames[i_235_] == ongame && gmaker[i_232_].equals(pnames[i_235_]))
                                bool_234_ = true;
                        }
                        if (bool_234_)
                            rd.drawString(new StringBuilder().append("").append(gmaker[i_232_]).append(" can start this game at anytime (the game creator)...").toString(), 95, 56);
                    }
                } else {
                    Date date = new Date();
                    long l = date.getTime();
                    if (ptime == 0L || l > ptime + 1500L) {
                        if (ptime != 0L) {
                            wait[i_232_]--;
                            if (wait[i_232_] < 1)
                                wait[i_232_] = 1;
                        }
                        ptime = l;
                    }
                    if (pgames[im] == ongame || nflk != 0) {
                        rd.drawString(new StringBuilder().append("Game starts in ").append(wait[i_232_]).append(" seconds!").toString(), 400 - ftm.stringWidth(new StringBuilder().append("Game starts in ").append(wait[i_232_]).append(" seconds!").toString()) / 2, 48);
                        if (pgames[im] != ongame)
                            nflk--;
                    } else if (pgames[im] != ongame)
                        nflk = 3;
                }
                if (pgames[im] != ongame && (gplyrs[i_232_].equals("") || gplyrs[i_232_].indexOf(pnames[im]) != -1))
                    stringbutton(" Join Game ", 660, 48, 2);
            } else {
                rd.setColor(color2k(120, 120, 120));
                if (wait[i_232_] == 0)
                    rd.drawString("Game Started", 400 - ftm.stringWidth("Game Started") / 2, 45);
                else
                    rd.drawString("Game Finished", 400 - ftm.stringWidth("Game Finished") / 2, 45);
            }
        }
        rd.setFont(new Font("Arial", 1, 11));
        (xt).ftm = rd.getFontMetrics();
        String string = "";
        if ((checkpoints).stage < 0)
            string = "Custom Stage";
        if ((checkpoints).stage > 0 && (checkpoints).stage <= 10)
            string = new StringBuilder().append("Stage ").append((checkpoints).stage).append(" NFM 1").toString();
        if ((checkpoints).stage > 10 && (checkpoints).stage <= 27)
            string = new StringBuilder().append("Stage ").append((checkpoints).stage - 10).append(" NFM 2").toString();
        if ((checkpoints).stage > 27)
            string = new StringBuilder().append("Multiplayer Stage ").append((checkpoints).stage - 27).append("").toString();
        xt.drawcs(85, new StringBuilder().append("Previewing ").append(string).append("  >").toString(), 255, 138, 0, 3);
        xt.drawcs(105, new StringBuilder().append("| ").append((checkpoints).name).append(" |").toString(), 255, 176, 85, 3);
        rd.drawImage((xt).back[pback], 532, 285, null);
        if ((checkpoints).stage < 0) {
            rd.setColor(new Color(255, 138, 0));
            rd.drawString(new StringBuilder().append("Created by: ").append((checkpoints).maker).append("").toString(), 85, 388);
            if ((checkpoints).pubt > 0) {
                if ((checkpoints).pubt == 2)
                    xt.drawcs(388, "Super Public Stage", 41, 177, 255, 3);
                else
                    xt.drawcs(388, "Public Stage", 41, 177, 255, 3);
                if (addstage == 0 && xt.drawcarb(true, null, " Add to My Stages ", 334, 395, i, i_230_, bool)) {
                    if ((xt).logged) {
                        (cd).onstage = (checkpoints).name;
                        (cd).staction = 2;
                        cd.sparkstageaction();
                        addstage = 2;
                    } else {
                        addstage = 1;
                        waitlink = 20;
                    }
                }
                if (addstage == 1) {
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(193, 106, 0));
                    String string_236_ = "Upgrade to a full account to add custom stages!";
                    int i_237_ = 400 - ftm.stringWidth(string_236_) / 2;
                    int i_238_ = i_237_ + ftm.stringWidth(string_236_);
                    rd.drawString(string_236_, i_237_, 410);
                    if (waitlink != -1)
                        rd.drawLine(i_237_, 412, i_238_, 412);
                    if (i > i_237_ && i < i_238_ && i_230_ > 399 && i_230_ < 412) {
                        if (waitlink != -1)
                            i_231_ = 12;
                        if (bool && waitlink == 0) {
                            gs.editlink((xt).nickname);
                            waitlink = -1;
                        }
                    }
                    if (waitlink > 0)
                        waitlink--;
                }
                if (addstage == 2) {
                    xt.drawcs(410, "Adding stage please wait...", 193, 106, 0, 3);
                    if ((cd).staction == 0)
                        addstage = 3;
                    if ((cd).staction == -2)
                        addstage = 4;
                    if ((cd).staction == -3)
                        addstage = 5;
                    if ((cd).staction <= -1)
                        addstage = 6;
                }
                if (addstage == 3)
                    xt.drawcs(410, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                if (addstage == 4)
                    xt.drawcs(410, "You already have this stage!", 193, 106, 0, 3);
                if (addstage == 5)
                    xt.drawcs(410, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                if (addstage == 6)
                    xt.drawcs(410, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
            } else
                xt.drawcs(410, "Private Stage", 193, 106, 0, 3);
        }
        if ((control).enter || conon == 2 || ongame <= -1 && chalngd != -2) {
            (m).trk = 0;
            (m).focus_point = 400;
            (m).crs = true;
            (m).x = -335;
            (m).y = 0;
            (m).z = -50;
            (m).xz = 0;
            (m).zy = 20;
            (m).ground = -2000;
            fase = 1;
            (control).enter = false;
        }
        if (i_231_ != pcurs) {
            gs.setCursor(new Cursor(i_231_));
            pcurs = i_231_;
        }
    }
    
    public void ctachm(int i, int i_239_, int i_240_, Control control) {
        int i_241_ = -1;
        if (fase == 1 || fase == 4) {
            for (int i_242_ = 0; i_242_ < btn; i_242_++) {
                if (Math.abs(i - bx[i_242_]) < bw[i_242_] / 2 + 12 && Math.abs(i_239_ - by[i_242_]) < 14 && (i_240_ == 1 || i_240_ == 11))
                    pessd[i_242_] = true;
                else
                    pessd[i_242_] = false;
                if (Math.abs(i - bx[i_242_]) < bw[i_242_] / 2 + 12 && Math.abs(i_239_ - by[i_242_]) < 14 && i_240_ <= -1) {
                    i_241_ = i_242_;
                    (gs).mouses = 0;
                }
            }
        }
        if (conon == 1) {
            if (!regnow) {
                if (onjoin <= -1) {
                    if (fase == 4) {
                        if (i > 532 && i < 592 && i_239_ > 285 && i_239_ < 306 && (i_240_ == 1 || i_240_ == 11))
                            pback = 1;
                        else
                            pback = 0;
                        if (i > 532 && i < 592 && i_239_ > 285 && i_239_ < 306 && i_240_ <= -1) {
                            (gs).mouses = 0;
                            (m).trk = 0;
                            (m).focus_point = 400;
                            (m).crs = true;
                            (m).x = -335;
                            (m).y = 0;
                            (m).z = -50;
                            (m).xz = 0;
                            (m).zy = 20;
                            (m).ground = -2000;
                            fase = 1;
                        }
                        if (i_241_ == 0 && chalngd <= -1) {
                            i_241_ = -1;
                            join = ongame;
                            msg = "| Joining Game |";
                            spos = 0;
                            (m).trk = 0;
                            (m).focus_point = 400;
                            (m).crs = true;
                            (m).x = -335;
                            (m).y = 0;
                            (m).z = -50;
                            (m).xz = 0;
                            (m).zy = 20;
                            (m).ground = -2000;
                            fase = 1;
                        }
                    }
                    if (fase == 1) {
                        if (ongame <= -1) {
                            if (i_241_ == 0) {
                                if (chalngd <= -1) {
                                    if ((xt).lan && !lanlogged)
                                        gs.reglink();
                                    else {
                                        loadstage = 0;
                                        remstage = 0;
                                        gstage = 0;
                                        gnpls = 7;
                                        gwait = 0;
                                        gnbts = 0;
                                        gclass = 0;
                                        gcars = 0;
                                        gfix = 0;
                                        gnotp = 1;
                                        gplayers = "";
                                        chalngd = -2;
                                    }
                                } else if (chalngd != -5)
                                    cflk = 25;
                            }
                            if (i_241_ == 1) {
                                conon = 0;
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
                                hideinputs();
                                (xt).playingame = -101;
                                (xt).fase = 23;
                            }
                            if (i_241_ == 2) {
                                conon = 0;
                                lg.exitfromlobby();
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
                                hideinputs();
                            }
                            int i_243_ = 3;
                            if (chalngd > -1) {
                                if (i_241_ == 3) {
                                    ongame = chalngd;
                                    chalngd = -1;
                                }
                                if (i_241_ == 4) {
                                    ongame = chalngd;
                                    join = chalngd;
                                    msg = "| Joining Game |";
                                    chalngd = -1;
                                    longame = -1;
                                }
                                if (i_241_ == 5) {
                                    ongame = longame;
                                    chalngd = -1;
                                    longame = -1;
                                }
                                i_243_ = 6;
                            } else {
                                if (chalngd != -1 && chalngd != -5 && i_241_ == 3) {
                                    if (invo)
                                        invo = false;
                                    for (int i_244_ = 0; i_244_ < 7; i_244_++) {
                                        if (!invos[i_244_].equals(""))
                                            invos[i_244_] = "";
                                        if (!dinvi[i_244_].equals(""))
                                            dinvi[i_244_] = "";
                                    }
                                    (gs).swait.hide();
                                    (gs).snpls.hide();
                                    (gs).snbts.hide();
                                    (gs).sgame.hide();
                                    (gs).mstgs.hide();
                                    (gs).slaps.hide();
                                    (gs).snfm1.hide();
                                    (gs).snfmm.hide();
                                    (gs).snfm2.hide();
                                    (gs).sclass.hide();
                                    (gs).scars.hide();
                                    (gs).sfix.hide();
                                    (gs).mycar.hide();
                                    (gs).notp.hide();
                                    gs.requestFocus();
                                    chalngd = -1;
                                }
                                if (chalngd == -2) {
                                    if ((gs).sgame.getSelectedIndex() == 3 && !(xt).logged) {
                                        if (i_241_ == 4)
                                            gs.editlink((xt).nickname);
                                        i_243_ = 5;
                                    } else {
                                        if (i_241_ == 4) {
                                            if (loadstage < 0) {
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.fillRect(0, 0, 670, 400);
                                                gs.repaint();
                                                (gs).cmsg.hide();
                                                (gs).sgame.hide();
                                                (gs).mstgs.hide();
                                                (gs).slaps.hide();
                                                (gs).snfm1.hide();
                                                (gs).snfmm.hide();
                                                (gs).snfm2.hide();
                                                gs.requestFocus();
                                                (m).ptr = 0;
                                                (m).ptcnt = -10;
                                                (m).hit = 45000;
                                                (m).fallen = 0;
                                                (m).nrnd = 0;
                                                (m).trk = 1;
                                                (m).ih = 25;
                                                (m).iw = 65;
                                                (m).h = 425;
                                                (m).w = 735;
                                                addstage = 0;
                                                fase = 4;
                                            } else
                                                sflk = 25;
                                        }
                                        if (loadstage >= 0)
                                            i_243_ = 5;
                                        else {
                                            if (i_241_ == 5) {
                                                if (gstage != 0) {
                                                    (gs).sgame.hide();
                                                    (gs).mstgs.hide();
                                                    (gs).slaps.hide();
                                                    (gs).snfm1.hide();
                                                    (gs).snfmm.hide();
                                                    (gs).snfm2.hide();
                                                    gs.requestFocus();
                                                    chalngd = -3;
                                                    i_241_ = -1;
                                                } else
                                                    sflk = 25;
                                            }
                                            i_243_ = 6;
                                        }
                                    }
                                }
                                if (chalngd == -3) {
                                    if (i_241_ == 4) {
                                        chalngd = -2;
                                        (gs).snpls.hide();
                                        (gs).snbts.hide();
                                        (gs).swait.hide();
                                        gs.requestFocus();
                                    }
                                    if (i_241_ == 5) {
                                        if (gnpls != 0 && (gs).snpls.getSelectedIndex() != 0) {
                                            chalngd = -4;
                                            for (int i_245_ = 0; i_245_ < 7; i_245_++) {
                                                if (!invos[i_245_].equals(""))
                                                    invos[i_245_] = "";
                                                if (!dinvi[i_245_].equals(""))
                                                    dinvi[i_245_] = "";
                                            }
                                            i_241_ = -1;
                                            (gs).snpls.hide();
                                            (gs).snbts.hide();
                                            (gs).swait.hide();
                                            gs.requestFocus();
                                        } else
                                            sflk = 25;
                                    }
                                    i_243_ = 6;
                                }
                                if (chalngd == -4) {
                                    i_243_ = 7;
                                    int i_246_ = 0;
                                    for (int i_247_ = 0; i_247_ < 7; i_247_++) {
                                        if (!invos[i_247_].equals(""))
                                            i_246_++;
                                    }
                                    if (i_246_ < gnpls - 1) {
                                        if (i_241_ == 4) {
                                            if (!invo)
                                                invo = true;
                                            else
                                                invo = false;
                                        }
                                    } else
                                        i_243_ = 6;
                                    if (i_241_ == i_243_ - 2) {
                                        if (invo)
                                            invo = false;
                                        if ((gs).mycar.getState() && (xt).sc[0] < 16) {
                                            gclass = -((xt).sc[0] + 2);
                                            gcars = 0;
                                        }
                                        if ((gs).notp.getState())
                                            gnotp = 1;
                                        else
                                            gnotp = 0;
                                        gplayers = "";
                                        (gs).sclass.hide();
                                        (gs).scars.hide();
                                        (gs).sfix.hide();
                                        (gs).mycar.hide();
                                        (gs).notp.hide();
                                        gs.requestFocus();
                                        chalngd = -3;
                                    }
                                    if (i_241_ == i_243_ - 1) {
                                        if (invo)
                                            invo = false;
                                        msg = "| Creating Game |";
                                        if ((gs).mycar.getState() && (xt).sc[0] < 16) {
                                            gclass = -((xt).sc[0] + 2);
                                            gcars = 0;
                                        }
                                        if (gclass != 0)
                                            gwait = 120;
                                        if ((gs).notp.getState())
                                            gnotp = 1;
                                        else
                                            gnotp = 0;
                                        gplayers = "";
                                        if (i_246_ != 0) {
                                            gnpls = i_246_ + 1;
                                            gplayers = new StringBuilder().append("").append(pnames[im]).append("X").toString();
                                            for (int i_248_ = 0; i_248_ < i_246_; i_248_++) {
                                                StringBuilder stringbuilder = new StringBuilder();
                                                Lobby lobby_249_ = this;
                                                (lobby_249_).gplayers = stringbuilder.append((lobby_249_).gplayers).append(invos[i_248_]).append("X").toString();
                                            }
                                        }
                                        (gs).sclass.hide();
                                        (gs).scars.hide();
                                        (gs).sfix.hide();
                                        (gs).mycar.hide();
                                        (gs).notp.hide();
                                        gs.requestFocus();
                                        chalngd = -5;
                                    }
                                }
                            }
                            if (i_241_ == i_243_ && !(xt).lan && !(gs).cmsg.getText().equals("Type here...") && !(gs).cmsg.getText().equals("")) {
                                String string = (gs).cmsg.getText().replace('|', ':');
                                if (string.toLowerCase().indexOf((gs).tpass.getText().toLowerCase()) != -1)
                                    string = " ";
                                if (!xt.msgcheck(string) && updatec > -12) {
                                    for (int i_250_ = 0; i_250_ < 6; i_250_++) {
                                        sentn[i_250_] = sentn[i_250_ + 1];
                                        cnames[i_250_] = cnames[i_250_ + 1];
                                    }
                                    sentn[6] = string;
                                    cnames[6] = pnames[im];
                                    if (updatec > -11)
                                        updatec = -11;
                                    else
                                        updatec--;
                                    spos3 = 28;
                                } else
                                    (xt).warning++;
                                (gs).cmsg.setText("");
                            }
                        } else if (dispcar <= -1) {
                            int i_251_ = 0;
                            for (int i_252_ = 0; i_252_ < ngm; i_252_++) {
                                if (ongame == gnum[i_252_])
                                    i_251_ = i_252_;
                            }
                            boolean bool = false;
                            if (!gplyrs[i_251_].equals("") && gplyrs[i_251_].indexOf(pnames[im]) <= -1)
                                bool = true;
                            if ((control).enter && wait[i_251_] > 0 && pgames[im] <= -1 && !bool) {
                                join = ongame;
                                msg = "| Joining Game |";
                                spos = 0;
                                if (pbtn == 0)
                                    pessd[1] = true;
                            }
                            if (wait[i_251_] <= -1 && pgames[im] <= -1 && (control).enter) {
                                i_241_ = 0;
                                pessd[0] = true;
                            }
                            if (pgames[im] <= -1 && (control).exit) {
                                i_241_ = 0;
                                pessd[0] = true;
                            }
                            if (i_241_ == 0) {
                                if (pgames[im] <= -1) {
                                    ongame = -1;
                                    chalngd = -1;
                                } else {
                                    join = -2;
                                    msg = "| Leaving Game |";
                                    longame = -1;
                                }
                            }
                            if (pbtn == 0) {
                                if (i_241_ == 1) {
                                    if (wait[i_251_] > 0) {
                                        if (pgames[im] <= -1) {
                                            join = ongame;
                                            msg = "| Joining Game |";
                                            spos = 0;
                                        } else if (gmaker[i_251_].equals(pnames[im]) && npls[i_251_] > 1)
                                            fstart = true;
                                        else
                                            i_241_ = 2;
                                    } else {
                                        if (wait[i_251_] == 0 && prevloaded == 1) {
                                            laps = gnlaps[i_251_];
                                            stage = gstgn[i_251_];
                                            stagename = gstages[i_251_];
                                            nfix = gfx[i_251_];
                                            if (gntb[i_251_] == 1)
                                                notb = true;
                                            else
                                                notb = false;
                                            gs.setCursor(new Cursor(3));
                                            conon = 3;
                                        } else
                                            i_241_ = 2;
                                        if (wait[i_251_] == 0 && (xt).lan) {
                                            laps = gnlaps[i_251_];
                                            stage = gstgn[i_251_];
                                            stagename = gstages[i_251_];
                                            nfix = gfx[i_251_];
                                            if (gntb[i_251_] == 1)
                                                notb = true;
                                            else
                                                notb = false;
                                            gs.setCursor(new Cursor(3));
                                            conon = 3;
                                        }
                                    }
                                }
                                if (i_241_ == 2 && !(xt).lan && !(gs).cmsg.getText().equals("Type here...") && !(gs).cmsg.getText().equals("")) {
                                    String string = (gs).cmsg.getText().replace('|', ':');
                                    if (string.toLowerCase().indexOf((gs).tpass.getText().toLowerCase()) != -1)
                                        string = " ";
                                    if (!xt.msgcheck(string) && updatec > -12) {
                                        for (int i_253_ = 0; i_253_ < 6; i_253_++) {
                                            sentn[i_253_] = sentn[i_253_ + 1];
                                            cnames[i_253_] = cnames[i_253_ + 1];
                                        }
                                        sentn[6] = string;
                                        cnames[6] = pnames[im];
                                        if (updatec > -11)
                                            updatec = -11;
                                        else
                                            updatec--;
                                    } else
                                        (xt).warning++;
                                    (gs).cmsg.setText("");
                                }
                            }
                            if (pbtn == 1 && i_241_ == 1) {
                                if (pgames[im] <= -1) {
                                    join = ongame;
                                    msg = "| Joining Game |";
                                    spos = 0;
                                } else if (!invo)
                                    invo = true;
                                else
                                    invo = false;
                            }
                            if (pbtn == 2 && (i_241_ == 1 || i_241_ == 2)) {
                                fase = 2;
                                (m).ptr = 0;
                                (m).ptcnt = -10;
                                (m).hit = 45000;
                                (m).fallen = 0;
                                (m).nrnd = 0;
                                (m).trk = 1;
                                (m).ih = 25;
                                (m).iw = 65;
                                (m).h = 425;
                                (m).w = 735;
                                if ((gs).cmsg.isShowing()) {
                                    (gs).cmsg.hide();
                                    gs.requestFocus();
                                }
                            }
                        } else {
                            if (i_241_ == 0) {
                                if (pgames[im] <= -1) {
                                    ongame = -1;
                                    chalngd = -1;
                                } else {
                                    join = -2;
                                    msg = "| Leaving Game |";
                                    longame = -1;
                                }
                            }
                            if (pbtn == 1 && i_241_ == 1) {
                                if (pgames[im] <= -1) {
                                    join = ongame;
                                    msg = "| Joining Game |";
                                    spos = 0;
                                } else if (!invo)
                                    invo = true;
                                else
                                    invo = false;
                            }
                        }
                    }
                } else if (ontyp != 76) {
                    if (i_241_ == 0) {
                        (xt).onjoin = onjoin;
                        (xt).ontyp = ontyp;
                        (xt).playingame = -101;
                        conon = 0;
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
                        hideinputs();
                        (xt).fase = 23;
                    }
                    if (i_241_ == 1)
                        onjoin = -1;
                } else {
                    if (i_241_ == 0) {
                        gs.editlink((xt).nickname);
                        onjoin = -1;
                    }
                    if (i_241_ == 1)
                        onjoin = -1;
                }
            } else {
                if (i_241_ == 0) {
                    gs.reglink();
                    gs.regprom();
                }
                if (i_241_ == 1) {
                    regnow = false;
                    gs.regprom();
                }
            }
        }
        lxm = i;
        lym = i_239_;
        (control).enter = false;
        (control).exit = false;
    }
    
    public void hideinputs() {
        (gs).cmsg.hide();
        (gs).swait.hide();
        (gs).snpls.hide();
        (gs).snbts.hide();
        (gs).sgame.hide();
        (gs).mstgs.hide();
        (gs).snfm1.hide();
        (gs).snfmm.hide();
        (gs).slaps.hide();
        (gs).snfm2.hide();
        (gs).sclass.hide();
        (gs).scars.hide();
        (gs).sfix.hide();
        (gs).mycar.hide();
        (gs).notp.hide();
        (gs).rooms.hide();
        gs.requestFocus();
    }
    
    public void drawSbutton(Image image, int i, int i_254_) {
        bx[btn] = i;
        by[btn] = i_254_;
        bw[btn] = image.getWidth(ob);
        if (!pessd[btn]) {
            rd.drawImage(image, i - bw[btn] / 2, i_254_ - image.getHeight(ob) / 2 - 1, null);
            rd.drawImage((xt).bols, i - bw[btn] / 2 - 15, i_254_ - 13, null);
            rd.drawImage((xt).bors, i + bw[btn] / 2 + 9, i_254_ - 13, null);
            rd.drawImage((xt).bot, i - bw[btn] / 2 - 9, i_254_ - 13, bw[btn] + 18, 3, null);
            rd.drawImage((xt).bob, i - bw[btn] / 2 - 9, i_254_ + 10, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i_254_ - image.getHeight(ob) / 2, null);
            rd.drawImage((xt).bolps, i - bw[btn] / 2 - 15, i_254_ - 13, null);
            rd.drawImage((xt).borps, i + bw[btn] / 2 + 9, i_254_ - 13, null);
            rd.drawImage((xt).bob, i - bw[btn] / 2 - 9, i_254_ - 13, bw[btn] + 18, 3, null);
            rd.drawImage((xt).bot, i - bw[btn] / 2 - 9, i_254_ + 10, bw[btn] + 18, 3, null);
        }
        btn++;
    }
    
    public void stringbutton(String string, int i, int i_255_, int i_256_) {
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        bx[btn] = i;
        by[btn] = i_255_ - 5;
        bw[btn] = ftm.stringWidth(string);
        if (!pessd[btn]) {
            rd.setColor(color2k(220, 220, 220));
            rd.fillRect(i - bw[btn] / 2 - 10, i_255_ - (17 - i_256_), bw[btn] + 20, 25 - i_256_ * 2);
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ - (17 - i_256_), i + bw[btn] / 2 + 10, i_255_ - (17 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ - (18 - i_256_), i + bw[btn] / 2 + 10, i_255_ - (18 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_255_ - (19 - i_256_), i + bw[btn] / 2 + 9, i_255_ - (19 - i_256_));
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i + bw[btn] / 2 + 10, i_255_ - (17 - i_256_), i + bw[btn] / 2 + 10, i_255_ + (7 - i_256_));
            rd.drawLine(i + bw[btn] / 2 + 11, i_255_ - (17 - i_256_), i + bw[btn] / 2 + 11, i_255_ + (7 - i_256_));
            rd.drawLine(i + bw[btn] / 2 + 12, i_255_ - (16 - i_256_), i + bw[btn] / 2 + 12, i_255_ + (6 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ + (7 - i_256_), i + bw[btn] / 2 + 10, i_255_ + (7 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ + (8 - i_256_), i + bw[btn] / 2 + 10, i_255_ + (8 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_255_ + (9 - i_256_), i + bw[btn] / 2 + 9, i_255_ + (9 - i_256_));
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ - (17 - i_256_), i - bw[btn] / 2 - 10, i_255_ + (7 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 11, i_255_ - (17 - i_256_), i - bw[btn] / 2 - 11, i_255_ + (7 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 12, i_255_ - (16 - i_256_), i - bw[btn] / 2 - 12, i_255_ + (6 - i_256_));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2, i_255_);
        } else {
            rd.setColor(color2k(210, 210, 210));
            rd.fillRect(i - bw[btn] / 2 - 10, i_255_ - (17 - i_256_), bw[btn] + 20, 25 - i_256_ * 2);
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ - (17 - i_256_), i + bw[btn] / 2 + 10, i_255_ - (17 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ - (18 - i_256_), i + bw[btn] / 2 + 10, i_255_ - (18 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_255_ - (19 - i_256_), i + bw[btn] / 2 + 9, i_255_ - (19 - i_256_));
            rd.drawLine(i + bw[btn] / 2 + 10, i_255_ - (17 - i_256_), i + bw[btn] / 2 + 10, i_255_ + (7 - i_256_));
            rd.drawLine(i + bw[btn] / 2 + 11, i_255_ - (17 - i_256_), i + bw[btn] / 2 + 11, i_255_ + (7 - i_256_));
            rd.drawLine(i + bw[btn] / 2 + 12, i_255_ - (16 - i_256_), i + bw[btn] / 2 + 12, i_255_ + (6 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ + (7 - i_256_), i + bw[btn] / 2 + 10, i_255_ + (7 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ + (8 - i_256_), i + bw[btn] / 2 + 10, i_255_ + (8 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_255_ + (9 - i_256_), i + bw[btn] / 2 + 9, i_255_ + (9 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_255_ - (17 - i_256_), i - bw[btn] / 2 - 10, i_255_ + (7 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 11, i_255_ - (17 - i_256_), i - bw[btn] / 2 - 11, i_255_ + (7 - i_256_));
            rd.drawLine(i - bw[btn] / 2 - 12, i_255_ - (16 - i_256_), i - bw[btn] / 2 - 12, i_255_ + (6 - i_256_));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2 + 1, i_255_);
        }
        btn++;
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
