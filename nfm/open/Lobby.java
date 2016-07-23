package nfm.open;
/* nfm.open.Lobby - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

class Lobby implements Runnable {
    int addstage = 0;
    private int britchl = 0;
    private int btn = 0;
    private final int[] bw = {0, 0, 0, 0, 0, 0, 0, 0};
    private final int[] bx = {0, 0, 0, 0, 0, 0, 0, 0};
    private final int[] by = {0, 0, 0, 0, 0, 0, 0, 0};
    private final int[] cac = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    private final int cancreate = 0;
    private final int[] cax = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final int[] cay = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private final CarDefine cd;
    private int cflk = 0;
    private String chalby = "";
    private int chalngd = -1;
    private int clicked = -1;
    private int cmonp = -1;
    private final String[] cnames = {"", "", "", "", "", "", ""};
    int cntchkn = 0;
    private Thread connector;
    private int conon = 0;
    private int ctime = 0;
    private BufferedReader din;
    private final String[] dinvi = {"", "", "", "", "", "", "", ""};
    private int dispcar = -1;
    private ContO dispco = null;
    private PrintWriter dout;
    int fase = 0;
    private int flks = 0;
    private int forcar = -1;
    private boolean fstart = false;
    private FontMetrics ftm;
    private final String[] gaclan = new String[500];
    private final int[] gameturn = new int[500];
    private final int[] gascore = new int[500];
    //Globe gb;
    private int gcars;
    private int gclass = 0;
    private final int[] gclss = new int[500];
    private final int[] gcrs = new int[500];
    private int gfix = 0;
    private final int[] gfx = new int[500];
    private final String[] gmaker = new String[500];
    private int gnbts = 0;
    private final int[] gnlaps = new int[500];
    private int gnotp = 0;
    private int gnpls = 8;
    private final int[] gntb = new int[500];
    final int[] gnum = new int[500];
    private String gplayers = "";
    private final String[] gplyrs = new String[500];
    boolean grprsd = false;
    private final GameSparker gs;
    private int gstage = 0;
    int gstagelaps = 0;
    String gstagename = "";
    final String[] gstages = new String[500];
    final int[] gstgn = new int[500];
    private final String[] gvclan = new String[500];
    private final int[] gvscore = new int[500];
    private int gwait = 0;
    private final int[] gwarb = new int[500];
    private final String[] gwarbnum = new String[500];
    private final int[] gwtyp = new int[500];
    private int im = 0;
    private boolean invo = false;
    private final String[] invos = {"", "", "", "", "", "", "", ""};
    private boolean inwab = false;
    private boolean jflexo = false;
    private int join = -1;
    private boolean lanlogged = true;
    int laps = 3;
    private String lapsname = "";
    private final Login lg;
    private boolean lloaded = false;
    private String lmsg = "| Searching/Waiting for other LAN Players |";
    int loadstage = 0;
    boolean loadwarb = false;
    private int longame = -1;
    private int lspos = 0;
    private int lspos2 = 0;
    int lspos3 = 0;
    private int lxm = 0;
    private int lym = 0;
    private final Medium m;
    private final int[] mnbts = new int[500];
    private final int[] mnpls = new int[500];
    private boolean mousedout = false;
    private int mousonp = -1;
    private int mrot = 0;
    private int mscro = 125;
    private int mscro2 = 145;
    int mscro3 = 345;
    private String msg = "";
    int msload = 0;
    private int ncnt = 0;
    int nfix = 0;
    private int nflk = 0;
    int ngm = 0;
    boolean notb = false;
    private final int[] npls = new int[500];
    private int npo = 0;
    private ImageObserver ob;
    int ongame = -1;
    private int onjoin = -1;
    private int ontyp = 0;
    private int opengame = 0;
    private int opselect = 0;
    private int pback = 0;
    private int pbtn = 0;
    private final String[] pcarnames = new String[200];
    private final int[] pcars = new int[200];
    private final String[] pclan = new String[200];
    private final float[][] pcols = new float[200][6];
    private int pcurs = 0;
    private final int[] pdam = {50, 50, 50, 50, 50, 50, 50, 50};
    private int pend = 0;
    private boolean pendb = false;
    private final boolean[] pessd = {false, false, false, false, false, false, false, false};
    private final int[] pgames = new int[200];
    int pgamesel = 0;
    private final int[] plap = {6, 6, 6, 6, 6, 6, 6, 6};
    int plsndt = 0;
    private final String[] pnames = new String[200];
    private final int[] ppos = {6, 6, 6, 6, 6, 6, 6, 6};
    private final int[] ppow = {50, 50, 50, 50, 50, 50, 50, 50};
    private boolean pre1 = false;
    private boolean pre2 = false;
    int prereq = 0;
    private int prevloaded = -1;
    private final String[] prnames = {"", "", "", "", "", "", "", ""};
    private int prnpo = 0;
    private long ptime = 0L;
    private final Graphics2D rd;
    private boolean regnow = false;
    private int remstage = 0;
    private int rerr = 0;
    private final String[] sentn = {"", "", "", "", "", "", ""};
    private int sflk = 0;
    private int sgflag = 0;
    private Socket socket;
    private int spos = 0;
    private int spos2 = 0;
    private int spos3 = 28;
    int stage = 0;
    String stagename = "";
    private String stuntname = "";
    private int updatec = -1;
    private final int[] wait = new int[500];
    private int waitlink = 0;
    int warbsel = 0;
    private String wastename = "";
    private final xtGraphics xt;
    boolean zeromsw = false;

    public Lobby(final Medium medium, final Graphics2D graphics2d, final Login login/*, final Globe globe*/,
                 final xtGraphics var_xtGraphics, final CarDefine cardefine, final GameSparker gamesparker) {
        m = medium;
        rd = graphics2d;
        xt = var_xtGraphics;
        cd = cardefine;
        gs = gamesparker;
        lg = login;
        //gb = globe;
        gs.cmsg.setBackground(color2k(240, 240, 240));
        gs.swait.setBackground(color2k(220, 220, 220));
        gs.snpls.setBackground(color2k(220, 220, 220));
        gs.snbts.setBackground(color2k(220, 220, 220));
        //gs.sgame.setBackground(color2k(200, 200, 200));
        gs.wgame.setBackground(color2k(200, 200, 200));
        gs.pgame.setBackground(color2k(200, 200, 200));
        gs.vnpls.setBackground(color2k(200, 200, 200));
        gs.vtyp.setBackground(color2k(200, 200, 200));
        gs.warb.setBackground(color2k(200, 200, 200));
        gs.snfmm.setBackground(color2k(200, 200, 200));
        //gs.snfm1.setBackground(color2k(200, 200, 200));
        //gs.snfm2.setBackground(color2k(200, 200, 200));
        gs.mstgs.setBackground(color2k(230, 230, 230));
        gs.slaps.setBackground(color2k(200, 200, 200));
        gs.sclass.setBackground(color2k(220, 220, 220));
        gs.scars.setBackground(color2k(220, 220, 220));
        gs.sfix.setBackground(color2k(220, 220, 220));
        gs.mycar.setBackground(color2k(255, 255, 255));
        gs.notp.setBackground(color2k(255, 255, 255));
        gs.rooms.setBackground(color2k(170, 170, 170));
        gs.swait.setForeground(new Color(0, 0, 0));
        gs.snpls.setForeground(new Color(0, 0, 0));
        gs.snbts.setForeground(new Color(0, 0, 0));
        //gs.sgame.setForeground(new Color(0, 0, 0));
        gs.wgame.setForeground(new Color(0, 0, 0));
        gs.pgame.setForeground(new Color(0, 0, 0));
        gs.vnpls.setForeground(new Color(0, 0, 0));
        gs.vtyp.setForeground(new Color(0, 0, 0));
        gs.warb.setForeground(new Color(0, 0, 0));
        gs.snfmm.setForeground(new Color(0, 0, 0));
        //gs.snfm1.setForeground(new Color(0, 0, 0));
        gs.slaps.setForeground(new Color(0, 0, 0));
        //gs.snfm2.setForeground(new Color(0, 0, 0));
        gs.mstgs.setForeground(new Color(0, 0, 0));
        gs.sclass.setForeground(new Color(0, 0, 0));
        gs.scars.setForeground(new Color(0, 0, 0));
        gs.sfix.setForeground(new Color(0, 0, 0));
        gs.mycar.setForeground(new Color(0, 0, 0));
        gs.notp.setForeground(new Color(0, 0, 0));
        gs.rooms.setForeground(new Color(0, 0, 0));
        gs.sgame.removeAll();
        gs.sgame.setVisible(false);
        //gs.sgame.add(rd, "");
        /*gs.sgame.add(rd, " NFM 2     ");
		gs.sgame.add(rd, " NFM 1     ");
		gs.sgame.add(rd, " My Stages ");
		gs.sgame.add(rd, " My Clan Stages ");
		gs.sgame.add(rd, " Weekly Top 20 ");
		gs.sgame.add(rd, " Monthly Top 20 ");*/
    }

    private Color color2k(final int i, final int i_327_, final int i_328_) {
        final Color color = new Color(i, i_327_, i_328_);
        final float[] fs = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
        fs[0] = 0.13F;
        fs[1] = 0.35F;
        return Color.getHSBColor(fs[0], fs[1], fs[2]);
    }

    public void ctachm(final int xm, final int ym, final int i_307_, final Control control) {
        int i_308_ = -1;
        if (fase == 1 || fase == 4)
            for (int i_309_ = 0; i_309_ < btn; i_309_++) {
                pessd[i_309_] = Math.abs(xm - bx[i_309_]) < bw[i_309_] / 2 + 12 && Math.abs(ym - by[i_309_]) < 14
                        && (i_307_ == 1 || i_307_ == 11);
                if (Math.abs(xm - bx[i_309_]) < bw[i_309_] / 2 + 12 && Math.abs(ym - by[i_309_]) < 14
                        && i_307_ <= -1) {
                    i_308_ = i_309_;
                    gs.mouses = 0;
                }
            }
        if (conon == 1)
            if (!regnow) {
                if (onjoin == -1) {
                    if (fase == 4) {
                        if (xm > 532 && xm < 592 && ym > 285 && ym < 306 && (i_307_ == 1 || i_307_ == 11))
                            pback = 1;
                        else
                            pback = 0;
                        if (xm > 532 && xm < 592 && ym > 285 && ym < 306 && i_307_ <= -1) {
                            gs.mouses = 0;
                            m.trk = 0;
                            if (xt.loadedt)
                                xt.strack.unload();
                            m.focus_point = 400;
                            m.crs = true;
                            m.x = -335;
                            m.y = 0;
                            m.z = -50;
                            m.xz = 0;
                            m.zy = 20;
                            m.ground = -2000;
                            fase = 1;
                        }
                        if (i_308_ == 0 && chalngd == -1) {
                            i_308_ = -1;
                            join = ongame;
                            msg = "| Joining Game |";
                            spos = 0;
                            m.trk = 0;
                            if (xt.loadedt)
                                xt.strack.unload();
                            m.focus_point = 400;
                            m.crs = true;
                            m.x = -335;
                            m.y = 0;
                            m.z = -50;
                            m.xz = 0;
                            m.zy = 20;
                            m.ground = -2000;
                            fase = 1;
                        }
                    }
                    if (fase == 1)
                        if (ongame == -1) {
                            if (i_308_ == 0)
                                if (chalngd == -1) {
                                    if (xt.lan && !lanlogged)
                                        gs.reglink();
                                    else {
                                        boolean bool = false;
                                        for (int i_310_ = 0; i_310_ < ngm; i_310_++)
                                            if (wait[i_310_] == 0) {
                                                bool = true;
                                                break;
                                            }
                                        if (!bool || xt.lan) {
                                            loadstage = 0;
                                            remstage = 0;
                                            gstage = 0;
                                            gnpls = 8;
                                            gwait = 0;
                                            gnbts = 0;
                                            gclass = 0;
                                            gcars = 0;
                                            gfix = 0;
                                            gnotp = 0;
                                            gplayers = "";
                                            gs.wgame.select(0);
                                            chalngd = -2;
                                        } else
                                            chalngd = -6;
                                    }
                                } else if (chalngd != -5) {
                                    if (invo)
                                        invo = false;
                                    for (int i_311_ = 0; i_311_ < 7; i_311_++) {
                                        if (!invos[i_311_].equals(""))
                                            invos[i_311_] = "";
                                        if (!dinvi[i_311_].equals(""))
                                            dinvi[i_311_] = "";
                                    }
                                    gs.swait.setVisible(false);
                                    gs.snpls.setVisible(false);
                                    gs.snbts.setVisible(false);
                                    //gs.sgame.setVisible(false);
                                    gs.wgame.setVisible(false);
                                    gs.pgame.setVisible(false);
                                    gs.vnpls.setVisible(false);
                                    gs.vtyp.setVisible(false);
                                    gs.warb.setVisible(false);
                                    gs.mstgs.setVisible(false);
                                    gs.slaps.setVisible(false);
                                    //gs.snfm1.setVisible(false);
                                    gs.snfmm.setVisible(false);
                                    //gs.snfm2.setVisible(false);
                                    gs.sclass.setVisible(false);
                                    gs.scars.setVisible(false);
                                    gs.sfix.setVisible(false);
                                    gs.mycar.setVisible(false);
                                    gs.notp.setVisible(false);
                                    gs.requestFocus();
                                    chalngd = -1;
                                }
                            if (i_308_ == 1)
                                xt.fase = 23;
                            if (i_308_ == 2) {
                                conon = 0;
                                lg.exitfromlobby();
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
                                hideinputs();
                            }
                            int i_312_ = 3;
                            if (chalngd > -1) {
                                if (i_308_ == 3) {
                                    ongame = chalngd;
                                    chalngd = -1;
                                }
                                if (i_308_ == 4) {
                                    ongame = chalngd;
                                    join = chalngd;
                                    msg = "| Joining Game |";
                                    chalngd = -1;
                                    longame = -1;
                                }
                                if (i_308_ == 5) {
                                    ongame = longame;
                                    chalngd = -1;
                                    longame = -1;
                                }
                                i_312_ = 6;
                            } else {
                                if (chalngd != -1 && chalngd != -5 && i_308_ == 3) {
                                    if (invo)
                                        invo = false;
                                    for (int i_313_ = 0; i_313_ < 7; i_313_++) {
                                        if (!invos[i_313_].equals(""))
                                            invos[i_313_] = "";
                                        if (!dinvi[i_313_].equals(""))
                                            dinvi[i_313_] = "";
                                    }
                                    gs.swait.setVisible(false);
                                    gs.snpls.setVisible(false);
                                    gs.snbts.setVisible(false);
                                    //gs.sgame.setVisible(false);
                                    gs.wgame.setVisible(false);
                                    gs.pgame.setVisible(false);
                                    gs.vnpls.setVisible(false);
                                    gs.vtyp.setVisible(false);
                                    gs.warb.setVisible(false);
                                    gs.mstgs.setVisible(false);
                                    gs.slaps.setVisible(false);
                                    //gs.snfm1.setVisible(false);
                                    gs.snfmm.setVisible(false);
                                    //gs.snfm2.setVisible(false);
                                    gs.sclass.setVisible(false);
                                    gs.scars.setVisible(false);
                                    gs.sfix.setVisible(false);
                                    gs.mycar.setVisible(false);
                                    gs.notp.setVisible(false);
                                    gs.requestFocus();
                                    chalngd = -1;
                                }
                                if (chalngd == -6 && i_308_ == 4)
                                    chalngd = -1;
                                if (chalngd == -2)
                                    if (gs.wgame.getSelectedIndex() == 0) {
										/*if (gs.sgame.getSelectedIndex() >= 3 && !xt.logged) {
											if (i_308_ == 4)
												gs.editlink(xt.nickname, true);
											i_312_ = 5;
										} else */
                                        {
                                            if (i_308_ == 4)
                                                if (loadstage < 0) {
                                                    rd.setColor(new Color(0, 0, 0));
                                                    rd.fillRect(0, 0, 670, 400);
                                                    //gs.repaint();
                                                    gs.rooms.setVisible(false);
                                                    gs.cmsg.setVisible(false);
                                                    //gs.sgame.setVisible(false);
                                                    gs.wgame.setVisible(false);
                                                    gs.warb.setVisible(false);
                                                    gs.pgame.setVisible(false);
                                                    gs.vnpls.setVisible(false);
                                                    gs.vtyp.setVisible(false);
                                                    gs.mstgs.setVisible(false);
                                                    gs.slaps.setVisible(false);
                                                    //gs.snfm1.setVisible(false);
                                                    gs.snfmm.setVisible(false);
                                                    //gs.snfm2.setVisible(false);
                                                    gs.requestFocus();
                                                    m.ptr = 0;
                                                    m.ptcnt = -10;
                                                    m.hit = 20000;
                                                    m.fallen = 0;
                                                    m.nrnd = 0;
                                                    m.ih = 25;
                                                    m.iw = 65;
                                                    m.h = 425;
                                                    m.w = 735;
                                                    m.trk = 4;
                                                    plsndt = 0;
                                                    addstage = 0;
                                                    fase = 4;
                                                } else
                                                    sflk = 25;
                                            if (loadstage >= 0)
                                                i_312_ = 5;
                                            else {
                                                if (i_308_ == 5)
                                                    if (gstage != 0) {
                                                        //gs.sgame.setVisible(false);
                                                        gs.wgame.setVisible(false);
                                                        gs.pgame.setVisible(false);
                                                        gs.vnpls.setVisible(false);
                                                        gs.vtyp.setVisible(false);
                                                        gs.warb.setVisible(false);
                                                        gs.mstgs.setVisible(false);
                                                        gs.slaps.setVisible(false);
                                                        //gs.snfm1.setVisible(false);
                                                        gs.snfmm.setVisible(false);
                                                        //gs.snfm2.setVisible(false);
                                                        gs.requestFocus();
                                                        chalngd = -3;
                                                        i_308_ = -1;
                                                    } else
                                                        sflk = 25;
                                                i_312_ = 6;
                                            }
                                        }
                                    } else if (!xt.clan.equals("")) {
                                        int i_314_;
                                        if (gs.warb.sel != 0/* && gb.loadwbgames == 2*/) {//CHECK
                                            if (gs.wgame.getSelectedIndex() == 1 && gs.vnpls.sel != 0
                                                    && cancreate == 2) {
                                                if (i_308_ == 4) {
                                                    if (invo)
                                                        invo = false;
                                                    msg = "| Creating Game |";
													/*gplayers = new StringBuilder().append("#warb#").append(gb.warb)
															.append("#").append(gb.warbnum).append("#")
															.append(gb.gameturn + 1).append("#").append(xt.clan)
															.append("#").append(gb.vclan).append("#").append(gb.ascore)
															.append("#").append(gb.vscore).append("#")
															.append(this.gs.vtyp.sel + 1).append("#").toString();
													gstage = gb.wbstage[gb.gameturn];
													gstagelaps = gb.wblaps[gb.gameturn];
													gcars = gb.wbcars[gb.gameturn] - 1;
													gclass = gb.wbclass[gb.gameturn];
													gfix = gb.wbfix[gb.gameturn];*/
                                                    gnpls = 8;
                                                    if (gs.vnpls.sel == 1)
                                                        gnpls = 4;
                                                    if (gs.vnpls.sel == 2)
                                                        gnpls = 6;
                                                    gwait = 120;
                                                    gnotp = 0;
                                                    gs.wgame.setVisible(false);
                                                    gs.pgame.setVisible(false);
                                                    gs.vnpls.setVisible(false);
                                                    gs.vtyp.setVisible(false);
                                                    gs.warb.setVisible(false);
                                                    gs.requestFocus();
                                                    chalngd = -5;
                                                }
                                                i_314_++;
                                            }
                                            if (gs.wgame.getSelectedIndex() == 2 && gs.pgame.sel != 0 && i_308_ == 4) {
                                                if (invo)
                                                    invo = false;
                                                msg = "| Creating Game |";
												/*gstage = gb.wbstage[gs.pgame.sel - 1];
												gstagelaps = gb.wblaps[gs.pgame.sel - 1];
												gcars = gb.wbcars[gs.pgame.sel - 1] - 1;
												gclass = gb.wbclass[gs.pgame.sel - 1];
												gfix = gb.wbfix[gs.pgame.sel - 1];*/
                                                gnpls = 8;
                                                gwait = 120;
                                                gnotp = 0;
                                                gplayers = "";
                                                gs.wgame.setVisible(false);
                                                gs.pgame.setVisible(false);
                                                gs.vnpls.setVisible(false);
                                                gs.vtyp.setVisible(false);
                                                gs.warb.setVisible(false);
                                                gs.requestFocus();
                                                chalngd = -5;
                                            }
                                            //if (gs.wgame.getSelectedIndex() == 1 && gb.canredo && i_308_ == i_314_)
                                            //	gb.loadwbgames = 7;
                                        }
                                    }/* else if (i_308_ == 4) {
										gb.tab = 3;
										gb.cfase = 2;
										gb.em = 1;
										gb.msg = "Clan Search";
										gb.smsg = "Listing clans with recent activity...";
										gb.nclns = 0;
										gb.spos5 = 0;
										gb.lspos5 = 0;
										gb.flko = 0;
										gb.open = 2;
										gb.upo = true;
									}*/
                                if (chalngd == -3) {
                                    if (i_308_ == 4) {
                                        chalngd = -2;
                                        gs.snpls.setVisible(false);
                                        gs.snbts.setVisible(false);
                                        gs.swait.setVisible(false);
                                        gs.requestFocus();
                                    }
                                    if (i_308_ == 5)
                                        if (gnpls != 0 && gs.snpls.getSelectedIndex() != 0) {
                                            chalngd = -4;
                                            for (int i_315_ = 0; i_315_ < 7; i_315_++) {
                                                if (!invos[i_315_].equals(""))
                                                    invos[i_315_] = "";
                                                if (!dinvi[i_315_].equals(""))
                                                    dinvi[i_315_] = "";
                                            }
                                            i_308_ = -1;
                                            gs.snpls.setVisible(false);
                                            gs.snbts.setVisible(false);
                                            gs.swait.setVisible(false);
                                            gs.requestFocus();
                                        } else
                                            sflk = 25;
                                    i_312_ = 6;
                                }
                                if (chalngd == -4) {
                                    i_312_ = 7;
                                    int i_316_ = 0;
                                    for (int i_317_ = 0; i_317_ < 7; i_317_++)
                                        if (!invos[i_317_].equals(""))
                                            i_316_++;
                                    if (i_316_ < gnpls - 1) {
                                        if (i_308_ == 4)
                                            invo = !invo;
                                    } else
                                        i_312_ = 6;
                                    if (i_308_ == i_312_ - 2) {
                                        if (invo)
                                            invo = false;
                                        if (gs.mycar.getState() && xt.sc[0] < 16) {
                                            gclass = -(xt.sc[0] + 2);
                                            gcars = 0;
                                        }
                                        if (gs.notp.getState())
                                            gnotp = 1;
                                        else
                                            gnotp = 0;
                                        gplayers = "";
                                        gs.sclass.setVisible(false);
                                        gs.scars.setVisible(false);
                                        gs.sfix.setVisible(false);
                                        gs.mycar.setVisible(false);
                                        gs.notp.setVisible(false);
                                        gs.requestFocus();
                                        chalngd = -3;
                                    }
                                    if (i_308_ == i_312_ - 1) {
                                        if (invo)
                                            invo = false;
                                        msg = "| Creating Game |";
                                        if (gs.mycar.getState() && xt.sc[0] < 16) {
                                            gclass = -(xt.sc[0] + 2);
                                            gcars = 0;
                                        }
                                        if (gclass != 0)
                                            gwait = 120;
                                        if (gs.notp.getState())
                                            gnotp = 1;
                                        else
                                            gnotp = 0;
                                        gplayers = "";
                                        if (i_316_ != 0) {
                                            gnpls = i_316_ + 1;
                                            gplayers = "" + pnames[im] + "#";
                                            for (int i_318_ = 0; i_318_ < i_316_; i_318_++) {
                                                final StringBuilder stringbuilder = new StringBuilder();
                                                final Lobby lobby_319_ = this;
                                                lobby_319_.gplayers = stringbuilder.append(lobby_319_.gplayers)
                                                        .append(invos[i_318_]).append("#").toString();
                                            }
                                        }
                                        gs.sclass.setVisible(false);
                                        gs.scars.setVisible(false);
                                        gs.sfix.setVisible(false);
                                        gs.mycar.setVisible(false);
                                        gs.notp.setVisible(false);
                                        gs.requestFocus();
                                        chalngd = -5;
                                    }
                                }
                            }
                            if (i_308_ == i_312_ && !xt.lan && !gs.cmsg.getText().equals("Type here...")
                                    && !gs.cmsg.getText().equals("")) {
                                String string = gs.cmsg.getText().replace('|', ':');
                                if (string.toLowerCase().contains(gs.tpass.getText().toLowerCase()))
                                    string = " ";
                                if (!xt.msgcheck(string) && updatec > -12) {
                                    for (int i_320_ = 0; i_320_ < 6; i_320_++) {
                                        sentn[i_320_] = sentn[i_320_ + 1];
                                        cnames[i_320_] = cnames[i_320_ + 1];
                                    }
                                    sentn[6] = string;
                                    cnames[6] = pnames[im];
                                    if (updatec > -11)
                                        updatec = -11;
                                    else
                                        updatec--;
                                    spos3 = 28;
                                } else
                                    xt.warning++;
                                gs.cmsg.setText("");
                            }
                        } else if (dispcar == -1) {
                            int i_321_ = 0;
                            for (int i_322_ = 0; i_322_ < ngm; i_322_++)
                                if (ongame == gnum[i_322_])
                                    i_321_ = i_322_;
                            boolean bool = false;
                            if (gwarb[i_321_] == 0) {
                                if (!gplyrs[i_321_].equals("") && !gplyrs[i_321_].contains(pnames[im]))
                                    bool = true;
                            } else if (!xt.clan.toLowerCase().equals(gaclan[i_321_].toLowerCase())
                                    && !xt.clan.toLowerCase().equals(gvclan[i_321_].toLowerCase()))
                                bool = true;
                            if (control.enter && wait[i_321_] > 0 && pgames[im] == -1 && !bool) {
                                join = ongame;
                                msg = "| Joining Game |";
                                spos = 0;
                                if (pbtn == 0)
                                    pessd[1] = true;
                            }
                            if (wait[i_321_] == -1 && pgames[im] == -1 && control.enter) {
                                i_308_ = 0;
                                pessd[0] = true;
                            }
                            if (pgames[im] == -1 && control.exit) {
                                i_308_ = 0;
                                pessd[0] = true;
                            }
                            if (i_308_ == 0)
                                if (pgames[im] == -1) {
                                    ongame = -1;
                                    chalngd = -1;
                                } else {
                                    join = -2;
                                    msg = "| Leaving Game |";
                                    longame = -1;
                                }
                            if (pbtn == 0) {
                                if (i_308_ == 1)
                                    if (wait[i_321_] > 0) {
                                        if (pgames[im] == -1) {
                                            join = ongame;
                                            msg = "| Joining Game |";
                                            spos = 0;
                                        } else if (gmaker[i_321_].equals(pnames[im]) && npls[i_321_] > 1)
                                            fstart = true;
                                        else
                                            i_308_ = 2;
                                    } else {
                                        if (wait[i_321_] == 0 && prevloaded == 1) {
                                            laps = gnlaps[i_321_];
                                            stage = gstgn[i_321_];
                                            stagename = gstages[i_321_];
                                            nfix = gfx[i_321_];
                                            notb = gntb[i_321_] == 1;
                                            gs.setCursor(new Cursor(3));
                                            conon = 3;
                                        } else
                                            i_308_ = 2;
                                        if (wait[i_321_] == 0 && xt.lan) {
                                            laps = gnlaps[i_321_];
                                            stage = gstgn[i_321_];
                                            stagename = gstages[i_321_];
                                            nfix = gfx[i_321_];
                                            notb = gntb[i_321_] == 1;
                                            gs.setCursor(new Cursor(3));
                                            conon = 3;
                                        }
                                    }
                                if (i_308_ == 2 && !xt.lan && !gs.cmsg.getText().equals("Type here...")
                                        && !gs.cmsg.getText().equals("")) {
                                    String string = gs.cmsg.getText().replace('|', ':');
                                    if (string.toLowerCase().contains(gs.tpass.getText().toLowerCase()))
                                        string = " ";
                                    if (!xt.msgcheck(string) && updatec > -12) {
                                        for (int i_323_ = 0; i_323_ < 6; i_323_++) {
                                            sentn[i_323_] = sentn[i_323_ + 1];
                                            cnames[i_323_] = cnames[i_323_ + 1];
                                        }
                                        sentn[6] = string;
                                        cnames[6] = pnames[im];
                                        if (updatec > -11)
                                            updatec = -11;
                                        else
                                            updatec--;
                                    } else
                                        xt.warning++;
                                    gs.cmsg.setText("");
                                }
                            }
                            if (pbtn == 1 && i_308_ == 1)
                                if (pgames[im] == -1) {
                                    join = ongame;
                                    msg = "| Joining Game |";
                                    spos = 0;
                                } else invo = !invo;
                            if (pbtn == 2 && (i_308_ == 1 || i_308_ == 2)) {
                                fase = 2;
                                m.ptr = 0;
                                m.ptcnt = -10;
                                m.hit = 20000;
                                m.fallen = 500;
                                m.nrnd = 0;
                                m.ih = 25;
                                m.iw = 65;
                                m.h = 425;
                                m.w = 735;
                                m.trk = 4;
                                plsndt = 0;
                                if (gs.cmsg.isShowing()) {
                                    gs.cmsg.setVisible(false);
                                    gs.requestFocus();
                                }
                            }
                        } else {
                            if (i_308_ == 0)
                                if (pgames[im] == -1) {
                                    ongame = -1;
                                    chalngd = -1;
                                } else {
                                    join = -2;
                                    msg = "| Leaving Game |";
                                    longame = -1;
                                }
                            if (pbtn == 1 && i_308_ == 1)
                                if (pgames[im] == -1) {
                                    join = ongame;
                                    msg = "| Joining Game |";
                                    spos = 0;
                                } else invo = !invo;
                        }
                } else if (ontyp != 76) {
                    if (i_308_ == 0)
                        if (ontyp < 30) {
                            xt.onjoin = onjoin;
                            xt.ontyp = ontyp;
                            xt.playingame = -101;
                            xt.fase = 23;
                        } else {
							/*if (!gb.claname.equals(xt.clan)) {
								gb.claname = xt.clan;
								gb.loadedc = false;
							}
							gb.spos5 = 0;
							gb.lspos5 = 0;
							gb.cfase = 3;
							gb.loadedcars = -1;
							gb.loadedcar = 0;
							gb.ctab = 2;
							gb.tab = 3;
							gb.open = 2;
							gb.upo = true;*/
                            onjoin = -1;
                        }
                    if (i_308_ == 1)
                        onjoin = -1;
                } else {
                    if (i_308_ == 0) {
                        gs.editlink(xt.nickname, true);
                        onjoin = -1;
                    }
                    if (i_308_ == 1)
                        onjoin = -1;
                }
            } else {
                if (i_308_ == 0)
                    gs.editlink(xt.nickname, true);
                if (i_308_ == 1)
                    regnow = false;
            }
        lxm = xm;
        lym = ym;
        control.enter = false;
        control.exit = false;
    }

    private void drawSbutton(final Image image, final int i, final int i_324_) {
        bx[btn] = i;
        by[btn] = i_324_;
        bw[btn] = image.getWidth(ob);
        if (!pessd[btn]) {
            rd.drawImage(image, i - bw[btn] / 2, i_324_ - image.getHeight(ob) / 2 - 1, null);
            rd.drawImage(xt.bols, i - bw[btn] / 2 - 15, i_324_ - 13, null);
            rd.drawImage(xt.bors, i + bw[btn] / 2 + 9, i_324_ - 13, null);
            rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i_324_ - 13, bw[btn] + 18, 3, null);
            rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i_324_ + 10, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i_324_ - image.getHeight(ob) / 2, null);
            rd.drawImage(xt.bolps, i - bw[btn] / 2 - 15, i_324_ - 13, null);
            rd.drawImage(xt.borps, i + bw[btn] / 2 + 9, i_324_ - 13, null);
            rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i_324_ - 13, bw[btn] + 18, 3, null);
            rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i_324_ + 10, bw[btn] + 18, 3, null);
        }
        btn++;
    }

    private String getHSvalue(final String string, final int i) {
        String string_347_ = "";
        try {
            int i_348_ = 0;
            int i_349_ = 0;
            int i_350_ = 0;
            String string_351_;
            String string_352_ = "";
            for (/**/ ; i_348_ < string.length() && i_350_ != 2; i_348_++) {
                string_351_ = "" + string.charAt(i_348_);
                if (string_351_.equals("#")) {
                    i_349_++;
                    if (i_350_ == 1 || i_349_ > i)
                        i_350_ = 2;
                } else if (i_349_ == i) {
                    string_352_ = string_352_ + string_351_;
                    i_350_ = 1;
                }
            }
            string_347_ = string_352_;
        } catch (final Exception exception) {
			/* empty */
        }
        return string_347_;
    }

    private int getHvalue(final String string, final int i) {
        int i_341_ = -1;
        try {
            int i_342_ = 0;
            int i_343_ = 0;
            int i_344_ = 0;
            String string_345_;
            String string_346_ = "";
            for (/**/ ; i_342_ < string.length() && i_344_ != 2; i_342_++) {
                string_345_ = "" + string.charAt(i_342_);
                if (string_345_.equals("#")) {
                    i_343_++;
                    if (i_344_ == 1 || i_343_ > i)
                        i_344_ = 2;
                } else if (i_343_ == i) {
                    string_346_ = string_346_ + string_345_;
                    i_344_ = 1;
                }
            }
            if (string_346_.equals(""))
                string_346_ = "-1";
            i_341_ = Integer.valueOf(string_346_);
        } catch (final Exception exception) {
			/* empty */
        }
        return i_341_;
    }

    private String getSevervalue(final String string, final int i) {
        String string_353_ = "";
        if (!string.equals(""))
            try {
                int i_354_ = 0;
                int i_355_ = 0;
                int i_356_ = 0;
                String string_357_;
                String string_358_ = "";
                for (/**/ ; i_354_ < string.length() && i_356_ != 2; i_354_++) {
                    string_357_ = "" + string.charAt(i_354_);
                    if (string_357_.equals("|")) {
                        i_355_++;
                        if (i_356_ == 1 || i_355_ > i)
                            i_356_ = 2;
                    } else if (i_355_ == i) {
                        string_358_ = string_358_ + string_357_;
                        i_356_ = 1;
                    }
                }
                string_353_ = string_358_;
            } catch (final Exception exception) {
                string_353_ = "";
            }
        return string_353_;
    }

    private String getSvalue(final String string, final int i) {
        String string_335_ = "";
        try {
            int i_336_ = 0;
            int i_337_ = 0;
            int i_338_ = 0;
            String string_339_;
            String string_340_ = "";
            for (/**/ ; i_336_ < string.length() && i_338_ != 2; i_336_++) {
                string_339_ = "" + string.charAt(i_336_);
                if (string_339_.equals("|")) {
                    i_337_++;
                    if (i_338_ == 1 || i_337_ > i)
                        i_338_ = 2;
                } else if (i_337_ == i) {
                    string_340_ = string_340_ + string_339_;
                    i_338_ = 1;
                }
            }
            string_335_ = string_340_;
        } catch (final Exception exception) {
			/* empty */
        }
        return string_335_;
    }

    private int getvalue(final String string, final int i) {
        int i_329_ = -1;
        try {
            int i_330_ = 0;
            int i_331_ = 0;
            int i_332_ = 0;
            String string_333_;
            String string_334_ = "";
            for (/**/ ; i_330_ < string.length() && i_332_ != 2; i_330_++) {
                string_333_ = "" + string.charAt(i_330_);
                if (string_333_.equals("|")) {
                    i_331_++;
                    if (i_332_ == 1 || i_331_ > i)
                        i_332_ = 2;
                } else if (i_331_ == i) {
                    string_334_ = string_334_ + string_333_;
                    i_332_ = 1;
                }
            }
            if (string_334_.equals(""))
                string_334_ = "-1";
            i_329_ = Integer.valueOf(string_334_);
        } catch (final Exception exception) {
			/* empty */
        }
        return i_329_;
    }

    private void hideinputs() {
        gs.cmsg.setVisible(false);
        gs.swait.setVisible(false);
        gs.snpls.setVisible(false);
        gs.snbts.setVisible(false);
        //gs.sgame.setVisible(false);
        gs.wgame.setVisible(false);
        gs.pgame.setVisible(false);
        gs.vnpls.setVisible(false);
        gs.vtyp.setVisible(false);
        gs.warb.setVisible(false);
        gs.mstgs.setVisible(false);
        //gs.snfm1.setVisible(false);
        gs.snfmm.setVisible(false);
        gs.slaps.setVisible(false);
        //gs.snfm2.setVisible(false);
        gs.sclass.setVisible(false);
        gs.scars.setVisible(false);
        gs.sfix.setVisible(false);
        gs.mycar.setVisible(false);
        gs.notp.setVisible(false);
        gs.rooms.setVisible(false);
        gs.requestFocus();
    }

    public void inishlobby() {
        gs.tnick.setVisible(false);
        gs.tpass.setVisible(false);
        gs.temail.setVisible(false);
        hideinputs();
        gs.mycar.setBackground(color2k(255, 255, 255));
        gs.mycar.setForeground(new Color(0, 0, 0));
        gs.rooms.removeAll();
        gs.rooms.add(rd, "" + xt.servername + " :: " + (xt.servport - 7070) +
                "");
        gs.rooms.select(0);
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
            gwarb[i] = 0;
            gwarbnum[i] = "";
            gameturn[i] = 0;
            gaclan[i] = "";
            gvclan[i] = "";
            gascore[i] = 0;
            gvscore[i] = 0;
            gwtyp[i] = 0;
        }
        for (int i = 0; i < 200; i++) {
            pnames[i] = "";
            pcars[i] = 0;
            pcarnames[i] = "";
            pgames[i] = -1;
            pclan[i] = "";
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
        lg.gamec = -1;
        try {
            socket = new Socket(xt.server, xt.servport);
            din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dout = new PrintWriter(socket.getOutputStream(), true);
        } catch (final Exception exception) {
			/* empty */
        }
        conon = 1;
        connector = new Thread(this);
        connector.start();
    }

    public void lobby(int i, int i_99_, boolean bool, final int i_100_,
                      final Control control, final ContO[] contos) {
        pre1 = false;
        pre2 = false;
        int i_101_ = 0;
        if (xt.warning == 0 || xt.warning == 210) {
            if (!regnow) {
                if (onjoin == -1) {
                    xt.mainbg(3);
                    if (britchl == -1) {
                        ongame = -1;
                        britchl = 0;
                    }
                    btn = 0;
                    pbtn = 0;
                    zeromsw = false;
                    int i_102_ = npo;
                    if (invo) {
                        i_102_ = 0;
                        for (int i_103_ = 0; i_103_ < npo; i_103_++)
                            if (pgames[i_103_] == -1)
                                i_102_++;
                        i_102_ += 2;
                    }
                    int i_104_ = (i_102_ - 11) * 30;
                    if (i_104_ < 0)
                        i_104_ = 0;
                    int i_105_ = (int) (spos / 295.0F * i_104_);
                    int i_106_ = 0;
                    int i_107_ = -1;
                    int i_108_ = -1;
                    if (conon == 1) {
                        if (!invo)
                            for (int i_109_ = 0; i_109_ < npo; i_109_++)
                                if (pgames[i_109_] != -1) {
                                    int i_110_ = 0;
                                    for (int i_111_ = 0; i_111_ < ngm; i_111_++)
                                        if (pgames[i_109_] == gnum[i_111_])
                                            i_110_ = i_111_;
                                    if (wait[i_110_] > 0) {
                                        if (82 + 30 * i_106_ - i_105_ > 50 && 82 + 30 * (i_106_ - 1) - i_105_ < 415) {
                                            boolean bool_112_ = false;
                                            if (i > 70 && i < 185 && i_99_ > 52 + 30 * i_106_ - i_105_
                                                    && i_99_ < 82 + 30 * i_106_ - i_105_) {
                                                if (pgames[im] == -1 && join == -1 && chalngd >= -1) {
                                                    if (bool || mousonp == i_109_) {
                                                        rd.setColor(color2k(255, 255, 255));
                                                        mousonp = i_109_;
                                                        i_108_ = 52 + 30 * i_106_ - i_105_;
                                                        if (bool) {
                                                            if (cmonp == i_109_)
                                                                ongame = this.pgames[i_109_];
                                                            chalngd = -1;
                                                        } else {
                                                            if (cmonp == -1) {
                                                                ongame = -1;
                                                                cmonp = i_109_;
                                                            }
                                                            if (ongame == this.pgames[i_109_])
                                                                mousonp = -1;
                                                        }
                                                    } else
                                                        rd.setColor(color2k(220, 220, 220));
                                                    rd.fillRect(70, 53 + 30 * i_106_ - i_105_, 116, 29);
                                                    i_107_ = i_109_;
                                                }
                                                if (control.handb) {
                                                    gs.cmsg.setText(gs.cmsg.getText() +
                                                            "" + pnames[i_109_]);
                                                    control.handb = false;
                                                }
                                            }
                                            if (pgames[im] == -1 && join == -1 && chalngd >= -1)
                                                rd.setColor(new Color(49, 79, 0));
                                            else
                                                rd.setColor(new Color(34, 55, 0));
                                            //final boolean bool_113_ = gb.drawl(rd, pnames[i_109_], 68,
                                            //		53 + 30 * i_106_ - i_105_, bool_112_);
                                            //if (/*!bool_112_ /*|| !bool_113_*/) { //CHECK
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(pnames[i_109_], 127 - ftm.stringWidth(pnames[i_109_]) / 2,
                                                    66 + 30 * i_106_ - i_105_);
                                            rd.setFont(new Font("Arial", 0, 10));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(pcarnames[i_109_],
                                                    127 - ftm.stringWidth(pcarnames[i_109_]) / 2,
                                                    78 + 30 * i_106_ - i_105_);
                                            //}
                                            rd.setColor(color2k(150, 150, 150));
                                            rd.drawLine(70, 82 + 30 * i_106_ - i_105_, 185, 82 + 30 * i_106_ - i_105_);
                                        }
                                        i_106_++;
                                    }
                                }
                        int i_114_ = -1;
                        if (invo) {
                            for (int i_115_ = 0; i_115_ < ngm; i_115_++)
                                if (gwarb[i_115_] != 0 && pgames[im] == gnum[i_115_])
                                    i_114_ = i_115_;
                            rd.setColor(new Color(0, 0, 0));
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            if (i_114_ == -1)
                                rd.drawString("Free Players", 127 - ftm.stringWidth("Free Players") / 2, 75 - i_105_);
                            else
                                rd.drawString("Members of Clans", 127 - ftm.stringWidth("Members of Clans") / 2,
                                        75 - i_105_);
                            rd.setFont(new Font("Arial", 0, 10));
                            ftm = rd.getFontMetrics();
                            rd.drawString("Click a player to invite:",
                                    127 - ftm.stringWidth("Click a player to invite:") / 2, 92 - i_105_);
                            rd.setColor(color2k(150, 150, 150));
                            rd.drawLine(70, 112 - i_105_, 185, 112 - i_105_);
                            i_106_ += 2;
                        }
                        for (int i_116_ = 0; i_116_ < npo; i_116_++) {
                            boolean bool_117_ = false;
                            if (invo) {
                                if (im == i_116_)
                                    bool_117_ = true;
                                for (int i_118_ = 0; i_118_ < 7; i_118_++)
                                    if (invos[i_118_].equals(pnames[i_116_]) && !bool_117_)
                                        bool_117_ = true;
                                if (i_114_ != -1 && !pclan[i_116_].toLowerCase().equals(gaclan[i_114_].toLowerCase())
                                        && !pclan[i_116_].toLowerCase().equals(gvclan[i_114_].toLowerCase()))
                                    bool_117_ = true;
                            }
                            if (pgames[i_116_] == -1 && !bool_117_) {
                                if (82 + 30 * i_106_ - i_105_ > 50 && 82 + 30 * (i_106_ - 1) - i_105_ < 415) {
                                    boolean bool_119_ = false;
                                    if (i > 70 && i < 185 && i_99_ > 52 + 30 * i_106_ - i_105_
                                            && i_99_ < 82 + 30 * i_106_ - i_105_) {
                                        if (invo) {
                                            if (bool) {
                                                rd.setColor(color2k(255, 255, 255));
                                                mousonp = i_116_;
                                            } else {
                                                rd.setColor(color2k(220, 220, 220));
                                                if (mousonp == i_116_) {
                                                    int i_120_ = 0;
                                                    for (boolean bool_121_ = false; i_120_ < 7 && !bool_121_; i_120_++)
                                                        if (invos[i_120_].equals("")) {
                                                            invos[i_120_] = this.pnames[i_116_];
                                                            bool_121_ = true;
                                                        }
                                                    mousonp = -1;
                                                    invo = false;
                                                }
                                            }
                                            rd.fillRect(70, 53 + 30 * i_106_ - i_105_, 116, 29);
                                            i_107_ = i_116_;
                                        } else if (pgames[im] == -1 && join == -1 && chalngd >= -1) {
                                            //i_101_ = 12;
											/*if (bool) {
												if (!gb.proname.equals(pnames[i_116_])) {
													gb.proname = pnames[i_116_];
													gb.loadedp = false;
												}
												gb.tab = 1;
												gb.open = 2;
												gb.upo = true;
											}*/
                                        }
                                        if (control.handb) {
                                            gs.cmsg.setText(gs.cmsg.getText() + "" +
                                                    pnames[i_116_]);
                                            control.handb = false;
                                        }
                                    }
                                    if (invo)
                                        rd.setColor(new Color(62, 98, 0));
                                    else
                                        rd.setColor(new Color(0, 0, 0));
                                    //final boolean bool_122_ = gb.drawl(rd, pnames[i_116_], 68,
                                    //		53 + 30 * i_106_ - i_105_, bool_119_);
                                    //if (!bool_119_/* || !bool_122_*/) {//CHECK
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pnames[i_116_], 127 - ftm.stringWidth(pnames[i_116_]) / 2,
                                            66 + 30 * i_106_ - i_105_);
                                    rd.setFont(new Font("Arial", 0, 10));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pcarnames[i_116_], 127 - ftm.stringWidth(pcarnames[i_116_]) / 2,
                                            78 + 30 * i_106_ - i_105_);
                                    //}
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(70, 82 + 30 * i_106_ - i_105_, 185, 82 + 30 * i_106_ - i_105_);
                                }
                                i_106_++;
                            }
                        }
                        if (invo && i_106_ == 2)
                            invo = false;
                        if (!invo)
                            for (int i_123_ = npo - 1; i_123_ >= 0; i_123_--)
                                if (pgames[i_123_] != -1) {
                                    int i_124_ = 0;
                                    for (int i_125_ = 0; i_125_ < ngm; i_125_++)
                                        if (pgames[i_123_] == gnum[i_125_])
                                            i_124_ = i_125_;
                                    if (wait[i_124_] <= 0) {
                                        boolean bool_126_ = false;
                                        for (int i_127_ = 0; i_127_ < npo; i_127_++)
                                            if (i_123_ != i_127_ && pnames[i_123_].equals(pnames[i_127_]))
                                                if (pgames[i_127_] == -1)
                                                    bool_126_ = true;
                                                else
                                                    for (int i_128_ = 0; i_128_ < ngm; i_128_++)
                                                        if (pgames[i_127_] == gnum[i_128_] && wait[i_128_] > 0)
                                                            bool_126_ = true;
                                        if (!bool_126_) {
                                            if (82 + 30 * i_106_ - i_105_ > 50
                                                    && 82 + 30 * (i_106_ - 1) - i_105_ < 415) {
                                                boolean bool_129_ = false;
                                                if (i > 70 && i < 185 && i_99_ > 52 + 30 * i_106_ - i_105_
                                                        && i_99_ < 82 + 30 * i_106_ - i_105_) {
                                                    if (pgames[im] == -1 && join == -1 && chalngd >= -1) {
                                                        if (bool || mousonp == i_123_) {
                                                            rd.setColor(color2k(255, 255, 255));
                                                            mousonp = i_123_;
                                                            i_108_ = 52 + 30 * i_106_ - i_105_;
                                                            if (bool) {
                                                                if (this.cmonp == i_123_)
                                                                    this.ongame = this.pgames[i_123_];
                                                                chalngd = -1;
                                                            } else {
                                                                if (this.cmonp == -1) {
                                                                    this.ongame = -1;
                                                                    this.cmonp = i_123_;
                                                                }
                                                                if (this.ongame == this.pgames[i_123_])
                                                                    this.mousonp = -1;
                                                            }
                                                        } else
                                                            rd.setColor(color2k(220, 220, 220));
                                                        rd.fillRect(70, 53 + 30 * i_106_ - i_105_, 116, 29);
                                                        i_107_ = i_123_;
                                                    }
                                                    if (control.handb) {
                                                        gs.cmsg.setText(this.gs.cmsg.getText() + "" +
                                                                this.pnames[i_123_]);
                                                        control.handb = false;
                                                    }
                                                }
                                                if (pgames[im] == -1 && join == -1 && chalngd >= -1) {
                                                    if (wait[i_124_] == 0)
                                                        rd.setColor(new Color(117, 67, 0));
                                                    else
                                                        rd.setColor(color2k(0, 28, 102));
                                                } else if (wait[i_124_] == 0)
                                                    rd.setColor(new Color(82, 47, 0));
                                                else
                                                    rd.setColor(color2k(0, 20, 71));
                                                //final boolean bool_130_ = gb.drawl(rd, pnames[i_123_], 68,
                                                //		53 + 30 * i_106_ - i_105_, bool_129_);
                                                //if (!bool_129_/* || !bool_130_*/) {//CHECK
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString(pnames[i_123_],
                                                        127 - ftm.stringWidth(pnames[i_123_]) / 2,
                                                        66 + 30 * i_106_ - i_105_);
                                                rd.setFont(new Font("Arial", 0, 10));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString(pcarnames[i_123_],
                                                        127 - ftm.stringWidth(pcarnames[i_123_]) / 2,
                                                        78 + 30 * i_106_ - i_105_);
                                                //}
                                                rd.setColor(color2k(150, 150, 150));
                                                rd.drawLine(70, 82 + 30 * i_106_ - i_105_, 185,
                                                        82 + 30 * i_106_ - i_105_);
                                            }
                                            i_106_++;
                                        }
                                    }
                                }
                    }
                    if (mousonp != i_107_) {
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
                    rd.drawImage(xt.roomp, 72, 30, null);
                    if (mscro == 131 || i_104_ == 0) {
                        if (i_104_ == 0)
                            rd.setColor(color2k(205, 205, 205));
                        else
                            rd.setColor(color2k(215, 215, 215));
                        rd.fillRect(193, 53, 17, 17);
                    } else {
                        rd.setColor(color2k(220, 220, 220));
                        rd.fill3DRect(193, 53, 17, 17, true);
                    }
                    if (i_104_ != 0)
                        rd.drawImage(xt.asu, 198, 59, null);
                    if (mscro == 132 || i_104_ == 0) {
                        if (i_104_ == 0)
                            rd.setColor(color2k(205, 205, 205));
                        else
                            rd.setColor(color2k(215, 215, 215));
                        rd.fillRect(193, 396, 17, 17);
                    } else {
                        rd.setColor(color2k(220, 220, 220));
                        rd.fill3DRect(193, 396, 17, 17, true);
                    }
                    if (i_104_ != 0)
                        rd.drawImage(xt.asd, 198, 403, null);
                    if (i_104_ != 0 && conon == 1) {
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
                            if (mscro == 125 && i > 193 && i < 210 && i_99_ > 70 + spos && i_99_ < spos + 101)
                                mscro = i_99_ - spos;
                            if (mscro == 125 && i > 191 && i < 212 && i_99_ > 51 && i_99_ < 72)
                                mscro = 131;
                            if (mscro == 125 && i > 191 && i < 212 && i_99_ > 394 && i_99_ < 415)
                                mscro = 132;
                            if (mscro == 125 && i > 193 && i < 210 && i_99_ > 70 && i_99_ < 396) {
                                mscro = 85;
                                spos = i_99_ - mscro;
                            }
                            int i_131_ = 1350 / i_104_;
                            if (i_131_ < 1)
                                i_131_ = 1;
                            if (mscro == 131) {
                                spos -= i_131_;
                                if (spos > 295)
                                    spos = 295;
                                if (spos < 0)
                                    spos = 0;
                                lspos = spos;
                            }
                            if (mscro == 132) {
                                spos += i_131_;
                                if (spos > 295)
                                    spos = 295;
                                if (spos < 0)
                                    spos = 0;
                                lspos = spos;
                            }
                            if (mscro <= 101) {
                                spos = i_99_ - mscro;
                                if (spos > 295)
                                    spos = 295;
                                if (spos < 0)
                                    spos = 0;
                            }
                            if (mscro == 125)
                                mscro = 225;
                        } else if (mscro != 125)
                            mscro = 125;
                        if (i_100_ != 0 && i > 65 && i < 170 && i_99_ > 93 && i_99_ < 413) {
                            spos -= i_100_;
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
                    if (ongame == -1) {
                        if (opengame >= 2) {
                            if (opengame >= 27)
                                opengame = 26;
                            int i_132_ = 229 + opengame;
                            if (i_132_ > 255)
                                i_132_ = 255;
                            if (i_132_ < 0)
                                i_132_ = 0;
                            rd.setColor(color2k(i_132_, i_132_, i_132_));
                            rd.fillRoundRect(225, 59 - (int) (opengame * 2.23F), 495, 200 + opengame * 8, 20, 20);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRoundRect(225, 59 - (int) (opengame * 2.23F), 495, 200 + opengame * 8, 20, 20);
                            if (!xt.lan) {
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
                            if (gs.cmsg.isShowing()) {
                                gs.cmsg.setVisible(false);
                                gs.requestFocus();
                            }
                            opengame -= 2;
                            if (opengame == 0 && longame != -1 && chalngd == -1) {
                                ongame = longame;
                                longame = -1;
                            }
                            if (invo)
                                invo = false;
                            for (int i_133_ = 0; i_133_ < 7; i_133_++) {
                                if (!invos[i_133_].equals(""))
                                    invos[i_133_] = "";
                                if (!dinvi[i_133_].equals(""))
                                    dinvi[i_133_] = "";
                            }
                            if (fstart)
                                fstart = false;
                            for (int i_134_ = 0; i_134_ < 9; i_134_++)
                                if (cac[i_134_] != -1)
                                    cac[i_134_] = -1;
                            if (dispcar != -1)
                                dispcar = -1;
                        } else {
                            if (!xt.lan) {
                                drawSbutton(xt.cgame, 292, 42);
                                drawSbutton(xt.ccar, 442, 42);
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                                rd.setColor(color2k(60, 60, 60));
                                if (!gs.rooms.isShowing())
                                    gs.rooms.setVisible(true);
                                gs.rooms.move(580 - gs.rooms.w / 2, 29);
                                if (gs.rooms.sel != 0) {
                                    stopallnow();
                                    int i_135_ = gs.rooms.iroom[gs.rooms.sel];
                                    if (i_135_ < 1000) {
                                        if (i_135_ >= 1 && i_135_ <= 5)
                                            xt.servport = 7070 + i_135_;
                                    } else {
                                        i_135_ -= 1000;
                                        if (i_135_ >= 0 && i_135_ < lg.nservers) {
                                            xt.servport = 7071;
                                            xt.server = lg.servers[i_135_];
                                            xt.servername = lg.snames[i_135_];
                                        }
                                    }
                                    inishlobby();
                                    gs.rooms.kmoused = 20;
                                }
                                if (gs.rooms.kmoused != 0) {
                                    i = -1;
                                    i_99_ = -1;
                                    bool = false;
                                    gs.rooms.kmoused--;
                                }
                            } else {
                                rd.drawImage(xt.lanm, 241, 31, null);
                                if (npo <= 1) {
                                    drawSbutton(xt.cgame, 292, -1000);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (ncnt == 0)
                                        rd.setColor(new Color(188, 111, 0));
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(lmsg, 472 - ftm.stringWidth(lmsg) / 2, 295);
                                    if (lmsg.equals(". . . | Searching/Waiting for other LAN Players | . . .")
                                            && ncnt == 0) {
                                        lmsg = "| Searching/Waiting for other LAN Players |";
                                        ncnt = 5;
                                    }
                                    if (lmsg.equals(". . | Searching/Waiting for other LAN Players | . .")
                                            && ncnt == 0) {
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
                                } /*
									 * else if (!lanlogged) { rd.setColor(new
									 * Color(0, 0, 0)); rd.setFont(new
									 * Font("Arial", 1, 13)); ftm =
									 * rd.getFontMetrics(); rd.drawString(
									 * "You have played the allowed 3 LAN games per day!"
									 * , (472 - ((ftm.stringWidth(
									 * "You have played the allowed 3 LAN games per day!"
									 * )) / 2)), 295); rd.setColor(color2k(70,
									 * 70, 70)); rd.drawString(
									 * "There needs to be at least one of the LAN players in the lobby with a registered"
									 * , 225, 325); rd.drawString(
									 * "account to be able to play LAN unlimitedly..."
									 * , 225, 345); rd.drawString(
									 * "Just one registered user allows everyone in the LAN game to play unlimitedly!"
									 * , 225, 365); rd.drawString(
									 * "Please register now!", 225, 385);
									 * drawSbutton(( xt).register, 472, 395); }
									 */ else {
                                    rd.setColor(color2k(90, 90, 90));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(
                                            "[  " + i_106_ +
                                                    " Players Connected  ]",
                                            472 - ftm.stringWidth("[  " + i_106_ +
                                                    " Players Connected  ]") / 2,
                                            295);
                                    drawSbutton(xt.cgame, 472, 325);
                                }
                                drawSbutton(xt.ccar, 442, -1000);
                            }
                            drawSbutton(xt.exit, 690, 42);
                            if (control.enter && !gs.cmsg.getText().equals("Type here...")
                                    && !gs.cmsg.getText().equals("")) {
                                if (chalngd == -1)
                                    pessd[2] = true;
                                else
                                    pessd[5] = true;
                                control.enter = false;
                                String string = gs.cmsg.getText().replace('|', ':');
                                if (string.toLowerCase().contains(gs.tpass.getText().toLowerCase()))
                                    string = " ";
                                if (!xt.msgcheck(string) && updatec > -12) {
                                    for (int i_136_ = 0; i_136_ < 6; i_136_++) {
                                        sentn[i_136_] = sentn[i_136_ + 1];
                                        cnames[i_136_] = cnames[i_136_ + 1];
                                    }
                                    sentn[6] = string;
                                    cnames[6] = pnames[im];
                                    if (updatec > -11)
                                        updatec = -11;
                                    else
                                        updatec--;
                                    spos3 = 28;
                                } else
                                    xt.warning++;
                                gs.cmsg.setText("");
                            }
                            if (chalngd == -1) {
                                rd.setColor(color2k(230, 230, 230));
                                rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                                if (britchl != 0)
                                    britchl = 0;
                                i_104_ = (ngm - 5) * 24;
                                if (i_104_ < 0)
                                    i_104_ = 0;
                                i_105_ = (int) (spos2 / 82.0F * i_104_ - 2.0F);
                                final int[] is = new int[ngm];
                                final int[] is_137_ = new int[ngm];
                                for (int i_138_ = 0; i_138_ < ngm; i_138_++)
                                    is[i_138_] = 0;
                                for (int i_139_ = 0; i_139_ < ngm; i_139_++) {
                                    for (int i_140_ = i_139_ + 1; i_140_ < ngm; i_140_++)
                                        if (wait[i_139_] != wait[i_140_]) {
                                            if (wait[i_139_] <= 0 && wait[i_140_] <= 0) {
                                                if (wait[i_139_] < wait[i_140_])
                                                    is[i_139_]++;
                                                else
                                                    is[i_140_]++;
                                            } else if ((wait[i_139_] > wait[i_140_] || wait[i_139_] <= 0)
                                                    && wait[i_140_] > 0)
                                                is[i_139_]++;
                                            else
                                                is[i_140_]++;
                                        } else if (i_140_ < i_139_)
                                            is[i_139_]++;
                                        else
                                            is[i_140_]++;
                                    is_137_[is[i_139_]] = i_139_;
                                }
                                if (control.down) {
                                    opselect++;
                                    for (boolean bool_141_ = false; 80 + 24 * opselect - i_105_ > 202
                                            && !bool_141_; i_105_ = (int) (spos2 / 82.0F * i_104_ - 2.0F)) {
                                        spos2++;
                                        if (spos2 > 82) {
                                            spos2 = 82;
                                            bool_141_ = true;
                                        }
                                        if (spos2 < 0) {
                                            spos2 = 0;
                                            bool_141_ = true;
                                        }
                                    }
                                    control.down = false;
                                }
                                if (control.up) {
                                    opselect--;
                                    for (boolean bool_142_ = false; 80 + 24 * opselect - i_105_ < 80
                                            && !bool_142_; i_105_ = (int) (spos2 / 82.0F * i_104_ - 2.0F)) {
                                        spos2--;
                                        if (spos2 > 82) {
                                            spos2 = 82;
                                            bool_142_ = true;
                                        }
                                        if (spos2 < 0) {
                                            spos2 = 0;
                                            bool_142_ = true;
                                        }
                                    }
                                    control.up = false;
                                }
                                int i_143_ = -1;
                                if (mousonp != -1) {
                                    int i_144_ = 0;
                                    for (int i_145_ = 0; i_145_ < ngm; i_145_++)
                                        if (pgames[mousonp] == gnum[i_145_])
                                            i_144_ = i_145_;
                                    i_143_ = 91 + 24 * is[i_144_] - i_105_;
                                    if (80 + 24 * is[i_144_] - i_105_ > 202) {
                                        int i_146_ = 1000 / i_104_;
                                        if (i_146_ < 1)
                                            i_146_ = 1;
                                        spos2 += i_146_;
                                        i_143_ = -1;
                                    }
                                    if (80 + 24 * is[i_144_] - i_105_ < 80) {
                                        int i_147_ = 1000 / i_104_;
                                        if (i_147_ < 1)
                                            i_147_ = 1;
                                        spos2 -= i_147_;
                                        i_143_ = -1;
                                    }
                                    if (spos2 > 82)
                                        spos2 = 82;
                                    if (spos2 < 0)
                                        spos2 = 0;
                                    i_105_ = (int) (spos2 / 82.0F * i_104_ - 2.0F);
                                    opselect = is[i_144_];
                                }
                                if (opselect <= -1)
                                    opselect = 0;
                                if (opselect >= ngm)
                                    opselect = ngm - 1;
                                int i_148_ = 0;
                                for (int i_149_ = 0; i_149_ < ngm; i_149_++)
                                    if (80 + 24 * i_149_ - i_105_ < 224 && 80 + 24 * i_149_ - i_105_ > 56) {
                                        if (opselect == i_149_) {
                                            if (80 + 24 * i_149_ - i_105_ >= 224)
                                                opselect--;
                                            if (80 + 24 * i_149_ - i_105_ < 62)
                                                opselect++;
                                        }
                                        boolean bool_150_ = false;
                                        boolean bool_151_ = false;
                                        if (!gs.openm) {
                                            if (i > 241 && i < 692 && i_99_ > 92 + 24 * i_149_ - i_105_
                                                    && i_99_ < 110 + 24 * i_149_ - i_105_) {
                                                if (lxm != i || lym != i_99_)
                                                    opselect = i_149_;
                                                bool_150_ = true;
                                                if (bool) {
                                                    if (clicked == -1)
                                                        clicked = is_137_[i_149_];
                                                } else {
                                                    if (clicked == is_137_[i_149_]) {
                                                        ongame = gnum[is_137_[i_149_]];
                                                        opengame = 0;
                                                        if (i >= 641 && i <= 689 && i_99_ > 92 + 24 * i_149_ - i_105_
                                                                && i_99_ < 110 + 24 * i_149_ - i_105_
                                                                && wait[is_137_[i_149_]] > 0) {
                                                            boolean bool_152_ = false;
                                                            if (gwarb[is_137_[i_149_]] == 0) {
                                                                if (this.gplyrs[is_137_[i_149_]].equals("")
                                                                        || this.gplyrs[is_137_[i_149_]].contains(this.pnames[this.im]))
                                                                    bool_152_ = true;
                                                            } else if (this.xt.clan.toLowerCase()
                                                                    .equals(this.gaclan[is_137_[i_149_]].toLowerCase())
                                                                    || this.xt.clan.toLowerCase().equals(
                                                                    this.gvclan[is_137_[i_149_]].toLowerCase()))
                                                                bool_152_ = true;
                                                            if (bool_152_) {
                                                                join = this.gnum[is_137_[i_149_]];
                                                                msg = "| Joining Game |";
                                                                spos = 0;
                                                            }
                                                        }
                                                        clicked = -1;
                                                    }
                                                    i_148_++;
                                                }
                                            } else
                                                i_148_++;
                                            if (i >= 641 && i <= 689 && i_99_ > 92 + 24 * i_149_ - i_105_
                                                    && i_99_ < 110 + 24 * i_149_ - i_105_ && bool)
                                                bool_151_ = true;
                                        }
                                        if (opselect == i_149_) {
                                            if (bool_150_ && bool || control.enter) {
                                                rd.setColor(color2k(200, 200, 200));
                                                if (control.enter) {
                                                    ongame = gnum[is_137_[i_149_]];
                                                    opengame = 0;
                                                    control.enter = false;
                                                }
                                            } else
                                                rd.setColor(color2k(255, 255, 255));
                                            rd.fillRect(241, 92 + 24 * i_149_ - i_105_, 451, 18);
                                            if (bool_150_) {
                                                rd.setColor(color2k(150, 150, 150));
                                                rd.drawRect(239, 90 + 24 * i_149_ - i_105_, 454, 21);
                                            }
                                        }
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(gstages[is_137_[i_149_]],
                                                382 - ftm.stringWidth(gstages[is_137_[i_149_]]) / 2,
                                                105 + 24 * i_149_ - i_105_);
                                        rd.drawString("|", 525, 105 + 24 * i_149_ - i_105_);
                                        rd.drawString("|", 584, 105 + 24 * i_149_ - i_105_);
                                        if (wait[is_137_[i_149_]] > 0) {
                                            rd.drawString("" + npls[is_137_[i_149_]] +
                                                            " / " + mnpls[is_137_[i_149_]] + "",
                                                    556 - ftm.stringWidth("" +
                                                            npls[is_137_[i_149_]] + " / " +
                                                            mnpls[is_137_[i_149_]] + "") / 2,
                                                    105 + 24 * i_149_ - i_105_);
                                            rd.setFont(new Font("Arial", 0, 12));
                                            rd.setColor(new Color(80, 128, 0));
                                            rd.drawString("Waiting", 593, 105 + 24 * i_149_ - i_105_);
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            if (!bool_151_) {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fill3DRect(641, 92 + 24 * i_149_ - i_105_, 48, 18, true);
                                                rd.fill3DRect(642, 93 + 24 * i_149_ - i_105_, 46, 16, true);
                                            } else {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fillRect(641, 92 + 24 * i_149_ - i_105_, 48, 18);
                                            }
                                            rd.setColor(new Color(0, 0, 0));
                                            boolean bool_153_ = false;
                                            if (gwarb[is_137_[i_149_]] == 0) {
                                                if (gplyrs[is_137_[i_149_]].equals("")
                                                        || gplyrs[is_137_[i_149_]].contains(pnames[im]))
                                                    bool_153_ = true;
                                            } else if (xt.clan.toLowerCase().equals(gaclan[is_137_[i_149_]].toLowerCase())
                                                    || xt.clan.toLowerCase()
                                                    .equals(gvclan[is_137_[i_149_]].toLowerCase()))
                                                bool_153_ = true;
                                            if (bool_153_)
                                                rd.drawString("Join", 665 - ftm.stringWidth("Join") / 2,
                                                        105 + 24 * i_149_ - i_105_);
                                            else
                                                rd.drawString("View", 665 - ftm.stringWidth("View") / 2,
                                                        105 + 24 * i_149_ - i_105_);
                                        } else {
                                            rd.drawString(
                                                    "" + npls[is_137_[i_149_]] +
                                                            "",
                                                    556 - ftm.stringWidth("" +
                                                            npls[is_137_[i_149_]] + "") / 2,
                                                    105 + 24 * i_149_ - i_105_);
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            if (wait[is_137_[i_149_]] == 0) {
                                                rd.setColor(new Color(128, 73, 0));
                                                rd.drawString("Started", 594, 105 + 24 * i_149_ - i_105_);
                                            } else {
                                                rd.setColor(color2k(100, 100, 100));
                                                rd.drawString("Finished", 590, 105 + 24 * i_149_ - i_105_);
                                            }
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            if (!bool_151_) {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fill3DRect(641, 92 + 24 * i_149_ - i_105_, 48, 18, true);
                                            } else {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fillRect(641, 92 + 24 * i_149_ - i_105_, 48, 18);
                                            }
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.drawString("View", 665 - ftm.stringWidth("View") / 2,
                                                    105 + 24 * i_149_ - i_105_);
                                        }
                                    } else {
                                        if (opselect == i_149_) {
                                            if (80 + 24 * i_149_ - i_105_ >= 224)
                                                opselect--;
                                            if (80 + 24 * i_149_ - i_105_ <= 56)
                                                opselect++;
                                        }
                                        i_148_++;
                                    }
                                if (i_148_ == ngm && clicked != -1)
                                    clicked = -1;
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                if (ngm == 0)
                                    if (!lloaded)
                                        rd.drawString("|  Loading Games  |",
                                                472 - ftm.stringWidth("|  Loading Games  |") / 2, 165);
                                    else if (!xt.lan)
                                        rd.drawString("No Games Created", 472 - ftm.stringWidth("No Games Created") / 2,
                                                165);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(235, 65, 480, 25);
                                rd.drawImage(xt.games, 241, 69, null);
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
                                if (mscro2 == 141 || i_104_ == 0) {
                                    if (i_104_ == 0)
                                        rd.setColor(color2k(205, 205, 205));
                                    else
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(698, 90, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(698, 90, 17, 17, true);
                                }
                                if (i_104_ != 0)
                                    rd.drawImage(xt.asu, 703, 96, null);
                                if (mscro2 == 142 || i_104_ == 0) {
                                    if (i_104_ == 0)
                                        rd.setColor(color2k(205, 205, 205));
                                    else
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(698, 220, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(698, 220, 17, 17, true);
                                }
                                if (i_104_ != 0)
                                    rd.drawImage(xt.asd, 703, 226, null);
                                if (i_104_ != 0) {
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
                                        if (mscro2 == 145 && i > 698 && i < 715 && i_99_ > 107 + spos2
                                                && i_99_ < spos2 + 138)
                                            mscro2 = i_99_ - spos2;
                                        if (mscro2 == 145 && i > 696 && i < 717 && i_99_ > 88 && i_99_ < 109)
                                            mscro2 = 141;
                                        if (mscro2 == 145 && i > 696 && i < 717 && i_99_ > 218 && i_99_ < 239)
                                            mscro2 = 142;
                                        if (mscro2 == 145 && i > 698 && i < 715 && i_99_ > 107 && i_99_ < 220) {
                                            mscro2 = 122;
                                            spos2 = i_99_ - mscro2;
                                        }
                                        int i_154_ = 400 / i_104_;
                                        if (i_154_ < 1)
                                            i_154_ = 1;
                                        if (mscro2 == 141) {
                                            spos2 -= i_154_;
                                            if (spos2 > 82)
                                                spos2 = 82;
                                            if (spos2 < 0)
                                                spos2 = 0;
                                            lspos2 = spos2;
                                        }
                                        if (mscro2 == 142) {
                                            spos2 += i_154_;
                                            if (spos2 > 82)
                                                spos2 = 82;
                                            if (spos2 < 0)
                                                spos2 = 0;
                                            lspos2 = spos2;
                                        }
                                        if (mscro2 <= 138) {
                                            spos2 = i_99_ - mscro2;
                                            if (spos2 > 82)
                                                spos2 = 82;
                                            if (spos2 < 0)
                                                spos2 = 0;
                                        }
                                        if (mscro2 == 145)
                                            mscro2 = 225;
                                    } else if (mscro2 != 145)
                                        mscro2 = 145;
                                    if (i_100_ != 0 && i > 235 && i < 698 && i_99_ > 87 && i_99_ < 239) {
                                        spos2 -= i_100_;
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
                                if (mousonp != -1 && i_143_ != -1) {
                                    rd.setColor(color2k(255, 255, 255));
                                    final int[] is_155_ = {185, 241, 241, 185};
                                    final int[] is_156_ = {i_108_, i_143_, i_143_ + 19, i_108_ + 30};
                                    rd.fillPolygon(is_155_, is_156_, 4);
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(185, i_108_, 241, i_143_);
                                    rd.drawLine(185, i_108_ + 30, 241, i_143_ + 19);
                                    rd.drawLine(241, i_143_, 692, i_143_);
                                    rd.drawLine(241, i_143_ + 19, 692, i_143_ + 19);
                                }
                            } else {
                                int i_157_ = 230 + britchl;
                                if (i_157_ > 255)
                                    i_157_ = 255;
                                if (i_157_ < 0)
                                    i_157_ = 0;
                                rd.setColor(color2k(i_157_, i_157_, i_157_));
                                rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                                if (britchl < 25)
                                    britchl += 5;
                                if (chalngd > -1) {
                                    int i_158_ = 0;
                                    for (int i_159_ = 0; i_159_ < ngm; i_159_++)
                                        if (chalngd == gnum[i_159_])
                                            i_158_ = i_159_;
                                    if (cflk % 4 != 0 || cflk == 0) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(
                                                "You have been invited by " + chalby +
                                                        " to join a game!",
                                                472 - ftm.stringWidth(
                                                        "You have been invited by " +
                                                                chalby + " to join a game!")
                                                        / 2,
                                                95);
                                        rd.setColor(new Color(117, 67, 0));
                                        rd.drawString(
                                                chalby, 472
                                                        - ftm.stringWidth("You have been invited by " + chalby +
                                                        " to join a game!") / 2
                                                        + ftm.stringWidth("You have been invited by "), 95);
                                    }
                                    if (cflk != 0)
                                        cflk--;
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(
                                            "Stage:  " + gstages[i_158_] +
                                                    " ,  Laps: " + gnlaps[i_158_] + "",
                                            472 - ftm.stringWidth("Stage:  " +
                                                    gstages[i_158_] + " ,  Laps: " + gnlaps[i_158_] +
                                                    "") / 2,
                                            130);
                                    rd.setColor(new Color(62, 98, 0));
                                    rd.drawString(gstages[i_158_], 472 - ftm
                                            .stringWidth("Stage:  " + gstages[i_158_] +
                                                    " ,  Laps: " + gnlaps[i_158_] + "")
                                            / 2 + ftm.stringWidth("Stage:  "), 130);
                                    rd.drawString(
                                            "" + gnlaps[i_158_] + "",
                                            472 - ftm.stringWidth("Stage:  " +
                                                    gstages[i_158_] + " ,  Laps: " + gnlaps[i_158_] +
                                                    "") / 2
                                                    + ftm.stringWidth("Stage:  " +
                                                    gstages[i_158_] + " ,  Laps: "),
                                            130);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString(
                                            "Players:  " + mnpls[i_158_] + "",
                                            472 - ftm.stringWidth("Players:  " +
                                                    mnpls[i_158_] + "") / 2,
                                            150);
                                    rd.setColor(new Color(62, 98, 0));
                                    rd.drawString(
                                            "" + mnpls[i_158_] + "",
                                            472 - ftm.stringWidth("Players:  " +
                                                    mnpls[i_158_] + "") / 2
                                                    + ftm.stringWidth("Players:  "),
                                            150);
                                    final Date date = new Date();
                                    final long l = date.getTime();
                                    if (ptime == 0L || l > ptime + 1000L) {
                                        if (ptime != 0L)
                                            ctime--;
                                        ptime = l;
                                    }
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 0, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString("(" + ctime + " )",
                                            472 - ftm.stringWidth("(" + ctime +
                                                    " )") / 2,
                                            170);
                                    if (ctime == 0) {
                                        ongame = longame;
                                        chalngd = -1;
                                        longame = -1;
                                    }
                                    stringbutton("   View Game   ", 352, 215, 2);
                                    stringbutton("   Join Game   ", 462, 215, 2);
                                    stringbutton("   Decline X   ", 599, 215, 2);
                                } else {
                                    if (chalngd != -5)
                                        stringbutton(" Cancel X ", 669, 85, 2);
                                    if (chalngd == -6) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        rd.drawString("This room already has a game that has started.", 288, 120);
                                        rd.drawString("Please switch to another room to create a new game.", 288, 140);
                                        rd.drawString("Or wait for the game to finish.", 288, 160);
                                        rd.drawString("Use the dropdown menu above to change room or server.", 288,
                                                180);
                                        final int[] is = {580, 569, 576, 576, 584, 584, 591};
                                        final int[] is_160_ = {66, 77, 77, 102, 102, 77, 77};
                                        rd.fillPolygon(is, is_160_, 7);
                                        stringbutton("     OK     ", 472, 215, 1);
                                    }
                                    if (chalngd == -2) {
                                        boolean bool_161_ = false;
                                        boolean bool_162_ = false;
                                        if (!gs.wgame.isShowing())
                                            gs.wgame.setVisible(true);
                                        gs.wgame.move(236, 68);
                                        if (gs.wgame.getSelectedIndex() == 0) {
                                            if (inwab) {
                                                inwab = false;
                                                gs.warb.setVisible(false);
                                                loadstage = 0;
                                            }
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 1, 13));
                                            ftm = rd.getFontMetrics();
                                            if (sflk % 4 != 0 || sflk == 0)
                                                rd.drawString("Select Stage", 472 - ftm.stringWidth("Select Stage") / 2,
                                                        85);
                                            if (sflk != 0)
                                                sflk--;
                                            //int i_163_ = 0;
                                            //gs.sgame.setSize(139, 22);
                                            //if (gs.sgame.getSelectedIndex() == 0) {
                                            //i_163_ = 472 - (gs.sgame.getWidth() + 6 + gs.snfmm.getWidth()) / 2;
                                            sgflag = 0;
                                            //}
											/*if (gs.sgame.getSelectedIndex() == 1) {
												i_163_ = 472 - (gs.sgame.getWidth() + 6 + gs.snfm1.getWidth()) / 2;
												sgflag = 1;
											}
											if (gs.sgame.getSelectedIndex() == 2) {
												i_163_ = 472 - (gs.sgame.getWidth() + 6 + gs.snfm2.getWidth()) / 2;
												sgflag = 2;
											}
											if (gs.sgame.getSelectedIndex() == 3) {
												gs.mstgs.setSize(338, 22);
												if (sgflag != 3) {
													gstage = 0;
													if (xt.logged) {
														if (cd.msloaded != 1) {
															gs.mstgs.removeAll();
															gs.mstgs.add(this.rd,
																	"Loading your stages now, please wait...");
															gs.mstgs.select(0);
															msload = 1;
														}
													} else {
														gs.mstgs.removeAll();
														gs.mstgs.add(rd, "You need to have a full account to access ");
														gs.mstgs.select(0);
														cd.msloaded = 0;
													}
													sgflag = 3;
												}
												i_163_ = 472 - (gs.sgame.getWidth() + 6 + gs.mstgs.getWidth()) / 2;
											}*/
											/*if (gs.sgame.getSelectedIndex() == 4) {
												gs.mstgs.setSize(338, 22);
												if (sgflag != 4) {
													gstage = 0;
													if (xt.logged) {
														if (cd.msloaded != 7) {
															gs.mstgs.removeAll();
															gs.mstgs.add(this.rd,
																	"Loading your stages now, please wait...");
															gs.mstgs.select(0);
															msload = 7;
														}
													} else {
														gs.mstgs.removeAll();
														gs.mstgs.add(rd, "You need to have a full account to access ");
														gs.mstgs.select(0);
														cd.msloaded = 0;
													}
													sgflag = 4;
												}
												i_163_ = 472 - (gs.sgame.getWidth() + 6 + gs.mstgs.getWidth()) / 2;
											}*/
											/*if (gs.sgame.getSelectedIndex() == 5) {
												gs.mstgs.setSize(338, 22);
												if (sgflag != 5) {
													gstage = 0;
													if (xt.logged) {
														if (cd.msloaded != 3) {
															gs.mstgs.removeAll();
															gs.mstgs.add(this.rd,
																	"Loading your stages now, please wait...");
															gs.mstgs.select(0);
															msload = 3;
														}
													} else {
														gs.mstgs.removeAll();
														gs.mstgs.add(rd, "You need to have a full account to access ");
														gs.mstgs.select(0);
														cd.msloaded = 0;
													}
													sgflag = 5;
												}
												i_163_ = 472 - (gs.sgame.getWidth() + 6 + gs.mstgs.getWidth()) / 2;
											}*/
											/*if (gs.sgame.getSelectedIndex() == 6) {
												gs.mstgs.setSize(338, 22);
												if (sgflag != 6) {
													gstage = 0;
													if (xt.logged) {
														if (cd.msloaded != 4) {
															gs.mstgs.removeAll();
															gs.mstgs.add(this.rd,
																	"Loading your stages now, please wait...");
															gs.mstgs.select(0);
															msload = 4;
														}
													} else {
														gs.mstgs.removeAll();
														gs.mstgs.add(rd, "You need to have a full account to access ");
														gs.mstgs.select(0);
														cd.msloaded = 0;
													}
													sgflag = 6;
												}
												i_163_ = 472 - (gs.sgame.getWidth() + 6 + gs.mstgs.getWidth()) / 2;
											}*/
											/*if (!gs.sgame.isShowing()) {
												gs.sgame.setVisible(true);
												remstage = 0;
												if (loadstage == 0) {
													int i_164_ = (int) (Math.random() * 3.0);
													if (i_164_ == 3)
														i_164_ = 2;
													gs.sgame.select(i_164_);
												}
											}*/
                                            //gs.sgame.move(i_163_, 105);
                                            //i_163_ += gs.sgame.getWidth() + 6;
                                            //if (true) {
                                            if (!gs.snfmm.isShowing()) {
                                                gs.snfmm.setVisible(true);
                                                if (loadstage == 0)
                                                    gs.snfmm.select(0);
                                            }
                                            gs.snfmm.move(420, 105); //blaze it
                                            //if (gs.snfm1.isShowing())
                                            //	gs.snfm1.setVisible(false);
                                            //if (gs.snfm2.isShowing())
                                            //	gs.snfm2.setVisible(false);
                                            if (gs.mstgs.isShowing())
                                                gs.mstgs.setVisible(false);
                                            //}
                                            if (/*gs.sgame.getSelectedIndex() == 0 && */gs.snfmm.getSelectedIndex() != 0
                                                    && gstage != gs.snfmm.getSelectedIndex()) {
                                                loadstage = gs.snfmm.getSelectedIndex();
                                                gstage = loadstage;
                                                gs.requestFocus();
                                            }
											/*if (gs.sgame.getSelectedIndex() == 1) {
												if (!gs.snfm2.isShowing()) {
													gs.snfm2.setVisible(true);
													if (loadstage == 0)
														gs.snfm2.select(0);
												}
												gs.snfm2.move(i_163_, 105);
												if (gs.snfmm.isShowing())
													gs.snfmm.setVisible(false);
												if (gs.snfm1.isShowing())
													gs.snfm1.setVisible(false);
												if (gs.mstgs.isShowing())
													gs.mstgs.setVisible(false);
											}
											if (gs.sgame.getSelectedIndex() == 1 && gs.snfm2.getSelectedIndex() != 0
													&& gstage != gs.snfm2.getSelectedIndex() + 10) {
												loadstage = gs.snfm2.getSelectedIndex() + 10;
												gstage = loadstage;
												gs.requestFocus();
											}
											if (gs.sgame.getSelectedIndex() == 2) {
												if (!gs.snfm1.isShowing()) {
													gs.snfm1.setVisible(true);
													if (loadstage == 0)
														gs.snfm1.select(0);
												}
												gs.snfm1.move(i_163_, 105);
												if (gs.snfmm.isShowing())
													gs.snfmm.setVisible(false);
												if (gs.snfm2.isShowing())
													gs.snfm2.setVisible(false);
												if (gs.mstgs.isShowing())
													gs.mstgs.setVisible(false);
											}
											if (gs.sgame.getSelectedIndex() == 2 && gs.snfm1.getSelectedIndex() != 0
													&& gstage != gs.snfm1.getSelectedIndex()) {
												loadstage = gs.snfm1.getSelectedIndex();
												gstage = loadstage;
												gs.requestFocus();
											}
											if (gs.sgame.getSelectedIndex() == 3) {
												if (!gs.mstgs.isShowing()) {
													gs.mstgs.setVisible(true);
													if (loadstage == 0)
														gs.mstgs.select(0);
												}
												gs.mstgs.move(i_163_, 105);
												if (gs.snfmm.isShowing())
													gs.snfmm.setVisible(false);
												if (gs.snfm1.isShowing())
													gs.snfm1.setVisible(false);
												if (gs.snfm2.isShowing())
													gs.snfm2.setVisible(false);
											}*/
											/*if (remstage != 2)
												if (gs.sgame.getSelectedIndex() == 3
														&& gs.mstgs.getSelectedIndex() != 0) {
													if (gstage != gs.mstgs.getSelectedIndex() + 100) {
														loadstage = gs.mstgs.getSelectedIndex() + 100;
														gstage = loadstage;
														gs.requestFocus();
														remstage = 0;
													}
													if (loadstage <= 0 && remstage == 0
															&& xt.drawcarb(true, null, "X", 674, 136, i, i_99_, bool))
														remstage = 1;
												} else if (remstage != 0)
													remstage = 0;
											if (gs.sgame.getSelectedIndex() >= 4) {
												if (!gs.mstgs.isShowing()) {
													gs.mstgs.setVisible(true);
													if (loadstage == 0)
														gs.mstgs.select(0);
												}
												gs.mstgs.move(i_163_, 105);
												if (gs.snfmm.isShowing())
													gs.snfmm.setVisible(false);
												if (gs.snfm1.isShowing())
													gs.snfm1.setVisible(false);
												if (gs.snfm2.isShowing())
													gs.snfm2.setVisible(false);
											}*/
											/*if (gs.sgame.getSelectedIndex() >= 4 && gs.mstgs.getSelectedIndex() != 0
													&& gstage != gs.mstgs.getSelectedIndex() + 100) {
												loadstage = gs.mstgs.getSelectedIndex() + 100;
												gstage = loadstage;
												gs.requestFocus();
											}*/
                                            if (loadstage > 0 && remstage == 0) {
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString("Loading stage, please wait...",
                                                        472 - ftm.stringWidth("Loading Stage, please wait...") / 2,
                                                        165);
                                            }
											/*if (gs.sgame.getSelectedIndex() >= 3 && !xt.logged) {
												rd.setColor(new Color(0, 0, 0));
												rd.setFont(new Font("Arial", 1, 12));
												ftm = rd.getFontMetrics();
												rd.drawString("You are currently using a trial account.", 472
														- ftm.stringWidth("You are currently using a trial account.")
																/ 2,
														155);
												rd.drawString(
														"You need to upgrade your account to access and publish custom stages!",
														472 - ftm.stringWidth(
																"You need to upgrade your account to access and publish custom stages!")
																/ 2,
														175);
												rd.setColor(color2k(200, 200, 200));
												rd.fillRoundRect(382, 185, 180, 50, 20, 20);
												drawSbutton(xt.upgrade, 472, 210);
												if (gs.slaps.isShowing())
													gs.slaps.setVisible(false);
											} else *///{
                                            if (loadstage < 0 && remstage == 0) {
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString(
                                                        "" + gstagename +
                                                                "  -  Laps:              ",
                                                        472 - ftm.stringWidth("" +
                                                                this.gstagename +
                                                                "  -  Laps:              ") / 2,
                                                        155);
                                                if (!gs.slaps.isShowing()) {
                                                    gs.slaps.setVisible(true);
                                                    gs.slaps.select(gstagelaps - 1);
                                                }
                                                gs.slaps.move(472
                                                        + ftm.stringWidth("" +
                                                        this.gstagename +
                                                        "  -  Laps:              ") / 2
                                                        - 35, 138);
                                                if (gs.slaps.getSelectedIndex() != gstagelaps - 1) {
                                                    gstagelaps = gs.slaps.getSelectedIndex() + 1;
                                                    gs.requestFocus();
                                                }
                                                stringbutton("    Preview Stage    ", 472, 185, 2);
                                            } else if (gs.slaps.isShowing())
                                                gs.slaps.setVisible(false);
												/*if (remstage == 3) {
													if (loadstage < 0)
														stringbutton("    Preview Stage    ", 472, -160, 2);
													rd.setColor(new Color(0, 0, 0));
													rd.setFont(new Font("Arial", 1, 13));
													ftm = rd.getFontMetrics();
													xt.drawlprom(135, 75);
													rd.drawString(
															"Failed to remove stage, server error, please try again later.",
															472 - ftm.stringWidth(
																	"Failed to remove stage, server error, please try again later.")
																	/ 2,
															155);
													if (xt.drawcarb(true, null, " OK ", 451, 175, i, i_99_, bool)) {
														remstage = 0;
														gs.mouses = 0;
													}
												}
												if (remstage == 2) {
													if (loadstage < 0)
														stringbutton("    Preview Stage    ", 472, -160, 2);
													rd.setColor(new Color(0, 0, 0));
													rd.setFont(new Font("Arial", 1, 13));
													ftm = rd.getFontMetrics();
													xt.drawlprom(135, 75);
													rd.drawString("Removing stage from your account...",
															472 - ftm.stringWidth("Removing stage from your account...")
																	/ 2,
															175);
													if (cd.staction == 0) {
														gstage = 0;
														loadstage = 0;
														remstage = 0;
													}
													if (cd.staction == -1) {
														remstage = 3;
														gs.mouses = 0;
													}
												}
												if (remstage == 1) {
													if (loadstage < 0)
														stringbutton("    Preview Stage    ", 472, -160, 2);
													xt.drawlprom(135, 75);
													rd.setColor(new Color(0, 0, 0));
													rd.setFont(new Font("Arial", 1, 13));
													ftm = rd.getFontMetrics();
													rd.drawString("Remove this stage from your account?", 472
															- ftm.stringWidth("Remove this stage from your account?")
																	/ 2,
															155);
													if (xt.drawcarb(true, null, " Yes ", 426, 175, i, i_99_, bool)) {
														remstage = 2;
														cd.onstage = gs.mstgs.getSelectedItem();
														cd.staction = 1;
														cd.sparkstageaction();
														gs.mouses = 0;
													}
													if (xt.drawcarb(true, null, " No ", 480, 175, i, i_99_, bool)) {
														remstage = 0;
														gs.mouses = 0;
													}
												}*/
                                            stringbutton("   Next >   ", 472, 235, 1);
											/*}*/
                                        } else {
                                            if (!inwab) {
                                                //gs.sgame.setVisible(false);
                                                gs.mstgs.setVisible(false);
                                                gs.slaps.setVisible(false);
                                                //gs.snfm1.setVisible(false);
                                                gs.snfmm.setVisible(false);
                                                //gs.snfm2.setVisible(false);
                                            }
											/*if (!xt.clan.equals("")) {} else */
                                            {//CHECK
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString("You must join a clan first to play wars and battles!",
                                                        472 - ftm.stringWidth(
                                                                "You must join a clan first to play wars and battles!")
                                                                / 2,
                                                        145);
                                                stringbutton("    Find a clan to join    ", 472, 185, 2);
                                            }
                                            if (!inwab)
                                                inwab = true;
                                        }
                                        if (bool_161_)
                                            gs.pgame.setVisible(true);
                                        else
                                            gs.pgame.setVisible(false);
                                        if (bool_162_) {
                                            gs.vnpls.setVisible(true);
                                            gs.vtyp.setVisible(true);
                                        } else {
                                            gs.vnpls.setVisible(false);
                                            gs.vtyp.setVisible(false);
                                        }
                                    }
                                    if (chalngd == -3) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        if (sflk % 4 != 0 || sflk == 0)
                                            rd.drawString("Select Number of Players",
                                                    472 - ftm.stringWidth("Select Number of Players") / 2, 85);
                                        if (sflk != 0)
                                            sflk--;
                                        int i_166_ = 0;
                                        if (xt.lan)
                                            i_166_ = 59;
                                        rd.drawString("Players", 413 - i_166_, 122);
                                        if (!gs.snpls.isShowing()) {
                                            gs.snpls.setVisible(true);
                                            gs.snpls.select(gnpls - 1);
                                        }
                                        gs.snpls.move(467 - i_166_, 105);
                                        boolean bool_167_ = false;
                                        if (gs.snpls.getSelectedIndex() != 0
                                                && gs.snpls.getSelectedIndex() != gnpls - 1) {
                                            gnpls = gs.snpls.getSelectedIndex() + 1;
                                            bool_167_ = true;
                                            gs.swait.setVisible(false);
                                        }
                                        if (xt.lan) {
                                            rd.drawString("Bots", 490, 122);
                                            if (!gs.snbts.isShowing()) {
                                                gs.snbts.setVisible(true);
                                                gs.snbts.select(0);
                                                // gnbts = 0;
                                            }
                                            gs.snbts.move(524, 105);
                                            if (gs.snbts.getSelectedIndex() != gnbts || bool_167_) {
                                                for (gnbts = gs.snbts.getSelectedIndex(); gnbts + gnpls > 8; gnbts--) {
													/* empty */
                                                }
                                                gs.snbts.select(gnbts);
                                            }
                                        }
                                        rd.drawString("Wait", 414, 162);
                                        if (!gs.swait.isShowing()) {
                                            gs.swait.setVisible(true);
                                            if (gwait == 0)
                                                gs.swait.select(1);
                                        }
                                        gs.swait.move(451, 145);
                                        if ((gs.swait.getSelectedIndex() + 1) * 60 != gwait)
                                            gwait = (gs.swait.getSelectedIndex() + 1) * 60;
                                        rd.setColor(color2k(90, 90, 90));
                                        rd.setFont(new Font("Arial", 0, 11));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("(Maximum time to wait for all players to `join. )", 472
                                                        - ftm.stringWidth("(Maximum time to wait for all players to join. )")
                                                        / 2,
                                                179);
                                        stringbutton("   < Back   ", 422, 235, 1);
                                        stringbutton("   Next >   ", 522, 235, 1);
                                    }
                                    if (chalngd == -4) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        if (sflk % 4 != 0 || sflk == 0)
                                            rd.drawString("Game Options", 472 - ftm.stringWidth("Game Options") / 2,
                                                    85);
                                        if (sflk != 0)
                                            sflk--;
                                        int i_168_ = 472
                                                - (gs.scars.getWidth() + gs.sclass.getWidth() + gs.sfix.getWidth() + 16)
                                                / 2;
                                        if (!gs.scars.isShowing()) {
                                            gs.scars.setVisible(true);
                                            if (gcars >= 0 && gcars <= 2)
                                                gs.scars.select(gcars);
                                            else
                                                gs.scars.select(0);
                                        }
                                        gs.scars.move(i_168_, 105);
                                        i_168_ += gs.scars.getWidth() + 8;
                                        if (!gs.sclass.isShowing()) {
                                            gs.sclass.setVisible(true);
                                            if (gclass >= 0 && gclass <= 5)
                                                gs.sclass.select(gclass);
                                            else
                                                gs.sclass.select(0);
                                        }
                                        gs.sclass.move(i_168_, 105);
                                        i_168_ += gs.sclass.getWidth() + 8;
                                        if (!gs.sfix.isShowing()) {
                                            gs.sfix.setVisible(true);
                                            if (gfix >= 0 && gfix <= 5)
                                                gs.sfix.select(gfix);
                                            else
                                                gs.sfix.select(0);
                                        }
                                        gs.sfix.move(i_168_, 105);
                                        i_168_ += gs.sfix.getWidth();
                                        if (!gs.openm)
                                            gs.movefield(gs.notp, i_168_ - 112, 131, 150, 17);
                                        else
                                            gs.movefield(gs.notp, i_168_ - 112, -2000, 150, 17);
                                        if (!gs.notp.isShowing()) {
                                            gs.notp.setVisible(true);
                                            if (gnotp == 0)
                                                gs.notp.setState(false);
                                            else
                                                gs.notp.setState(true);
                                        }
                                        if (xt.sc[0] < 16) {
                                            if (!gs.openm)
                                                gs.movefield(gs.mycar, 472 - (gs.scars.getWidth() + gs.sclass.getWidth()
                                                        + gs.sfix.getWidth() + 16) / 2, 131, 150, 17);
                                            else
                                                gs.movefield(gs.mycar, 410, -2000, 150, 17);
                                            if (!gs.mycar.isShowing()) {
                                                gs.mycar.setVisible(true);
                                                gs.mycar.setLabel("" +
                                                        cd.names[xt.sc[0]] + " Game!");
                                                if (gclass <= -2)
                                                    gs.mycar.setState(true);
                                                else
                                                    gs.mycar.setState(false);
                                            }
                                        } else if (gs.mycar.getState())
                                            gs.mycar.setState(false);
                                        if (gs.mycar.getState()) {
                                            if (gs.sclass.isEnabled())
                                                gs.sclass.disable();
                                            if (gs.scars.isEnabled())
                                                gs.scars.disable();
                                        } else {
                                            if (!gs.sclass.isEnabled())
                                                gs.sclass.enable();
                                            if (!gs.scars.isEnabled())
                                                gs.scars.enable();
                                            if (gs.sclass.getSelectedIndex() != gclass) {
                                                gclass = gs.sclass.getSelectedIndex();
                                                gs.mycar.setVisible(false);
                                            }
                                            if (gs.scars.getSelectedIndex() != gcars)
                                                gcars = gs.scars.getSelectedIndex();
                                        }
                                        if (gs.sfix.getSelectedIndex() != gfix)
                                            gfix = gs.sfix.getSelectedIndex();
                                        String string = "Public Game, anyone can join...";
                                        int i_169_ = 0;
                                        for (int i_170_ = 0; i_170_ < 7; i_170_++)
                                            if (!invos[i_170_].equals(""))
                                                i_169_++;
                                        if (i_169_ > 0) {
                                            string = "Players Allowed:  ";
                                            int i_171_ = 0;
                                            for (int i_172_ = 0; i_172_ < 7; i_172_++)
                                                if (!invos[i_172_].equals("")) {
                                                    string = string + invos[i_172_];
                                                    if (++i_171_ != i_169_)
                                                        if (i_171_ == i_169_ - 1)
                                                            string = string + " and ";
                                                        else
                                                            string = string + ", ";
                                                }
                                        }
                                        rd.setColor(new Color(0, 0, 0));
                                        if (i_169_ < gnpls - 1) {
                                            rd.setFont(new Font("Arial", 1, 13));
                                            rd.drawString("Private Game, only specific players allowed to join?  " +
                                                            i_169_ + "/" + (gnpls - 1) + "",
                                                    330, 180);
                                            stringbutton("<   Select   ", 281, 180, 2);
                                            rd.setFont(new Font("Tahoma", 0, 11));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(string, 472 - ftm.stringWidth(string) / 2, 203);
                                        } else {
                                            rd.setFont(new Font("Arial", 1, 13));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(
                                                    "" + i_169_ +
                                                            " Allowed Players Selected",
                                                    472 - ftm
                                                            .stringWidth("" + i_169_ +
                                                                    " Allowed Players Selected")
                                                            / 2,
                                                    180);
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
                            //if ((chalngd == -1 || chalngd == -6) && lg.gamec != -1) {}
                        }
                    } else if (opengame < 26) {
                        int i_191_ = 229 + opengame;
                        if (i_191_ > 255)
                            i_191_ = 255;
                        if (i_191_ < 0)
                            i_191_ = 0;
                        rd.setColor(color2k(i_191_, i_191_, i_191_));
                        rd.fillRoundRect(225, 59 - (int) (opengame * 2.23F), 495, 200 + opengame * 8, 20, 20);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawRoundRect(225, 59 - (int) (opengame * 2.23F), 495, 200 + opengame * 8, 20, 20);
                        if (!xt.lan) {
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
                        if (gs.cmsg.isShowing()) {
                            gs.cmsg.setVisible(false);
                            gs.requestFocus();
                        }
                        if (gs.rooms.isShowing())
                            gs.rooms.setVisible(false);
                        if (fstart)
                            fstart = false;
                        for (int i_192_ = 0; i_192_ < 9; i_192_++)
                            if (cac[i_192_] != -1)
                                cac[i_192_] = -1;
                        if (dispcar != -1)
                            dispcar = -1;
                        opengame += 2;
                    } else {
                        rd.setColor(color2k(255, 255, 255));
                        rd.fillRoundRect(225, 1, 495, 417, 20, 20);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawRoundRect(225, 1, 495, 417, 20, 20);
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
                            if (gs.cmsg.isShowing()) {
                                gs.cmsg.setVisible(false);
                                gs.requestFocus();
                            }
                        } else {
                            int i_193_ = 0;
                            for (int i_194_ = 0; i_194_ < ngm; i_194_++)
                                if (ongame == gnum[i_194_])
                                    i_193_ = i_194_;
                            rd.setFont(new Font("Arial", 1, 11));
                            ftm = rd.getFontMetrics();
                            rd.setColor(new Color(0, 0, 0));
                            int i_195_ = 23;
                            int i_196_ = 0;
                            if (gwarb[i_193_] != 0) {
                                i_195_ = 28;
                                i_196_ = 2;
                                String string = "Clan war";
                                if (gwarb[i_193_] == 2)
                                    string = "Car battle";
                                if (gwarb[i_193_] == 3)
                                    string = "Stage battle";
                                rd.drawString("" + string + " between " +
                                        gaclan[i_193_] + " and " + gvclan[i_193_] + "", 243, 14);
                            }
                            String string = "";
                            String string_197_ = "";
                            String string_198_ = "";
                            if (conon == 1) {
                                if (wait[i_193_] > 0)
                                    if (gwarb[i_193_] == 0) {
                                        String string_199_;
                                        if (gplyrs[i_193_].equals(""))
                                            string_199_ = "Public Game";
                                        else
                                            string_199_ = "Private Game";
                                        if (gfx[i_193_] == 1)
                                            string_199_ = string_199_ + " | 4 Fixes";
                                        if (gfx[i_193_] == 2)
                                            string_199_ = string_199_ + " | 3 Fixes";
                                        if (gfx[i_193_] == 3)
                                            string_199_ = string_199_ + " | 2 Fixes";
                                        if (gfx[i_193_] == 4)
                                            string_199_ = string_199_ + " | 1 Fix";
                                        if (gfx[i_193_] == 5)
                                            string_199_ = string_199_ + " | No Fixing";
                                        String string_200_ = "";
                                        if (gclss[i_193_] > -2) {
                                            if (gcrs[i_193_] == 1)
                                                string_200_ = "Custom Cars";
                                            if (gcrs[i_193_] == 2)
                                                string_200_ = "Game Cars";
                                            String string_201_ = "";
                                            if (gclss[i_193_] == 1)
                                                string_201_ = "Class C";
                                            if (gclss[i_193_] == 2)
                                                string_201_ = "Class B & C";
                                            if (gclss[i_193_] == 3)
                                                string_201_ = "Class B";
                                            if (gclss[i_193_] == 4)
                                                string_201_ = "Class A & B";
                                            if (gclss[i_193_] == 5)
                                                string_201_ = "Class A";
                                            if (!string_200_.equals("") && !string_201_.equals(""))
                                                string_200_ = string_200_ + " | " +
                                                        string_201_;
                                            else
                                                string_200_ = string_200_ +
                                                        string_201_;
                                        } else
                                            string_200_ = "" +
                                                    cd.names[Math.abs(this.gclss[i_193_] + 2)] + "";
                                        if (string_200_.equals("")) {
                                            rd.drawString("Type:", 243, 23);
                                            rd.setColor(new Color(80, 128, 0));
                                            rd.drawString(string_199_, 279, 23);
                                        } else {
                                            rd.drawString("Type:", 243, 14);
                                            rd.drawString("Cars:", 244, 28);
                                            rd.setColor(new Color(80, 128, 0));
                                            rd.drawString(string_199_, 279, 14);
                                            rd.drawString(string_200_, 279, 28);
                                        }
                                    } else {
                                        String string_202_ = "Game #" +
                                                gameturn[i_193_] + "";
                                        if (gcrs[i_193_] == 1)
                                            string_202_ = string_202_ + " | Clan Cars";
                                        if (gcrs[i_193_] == 2)
                                            string_202_ = string_202_ + " | Game Cars";
                                        if (gclss[i_193_] == 1)
                                            string_202_ = string_202_ + " | Class C";
                                        if (gclss[i_193_] == 2)
                                            string_202_ = string_202_ +
                                                    " | Class B & C";
                                        if (gclss[i_193_] == 3)
                                            string_202_ = string_202_ + " | Class B";
                                        if (gclss[i_193_] == 4)
                                            string_202_ = string_202_ +
                                                    " | Class A & B";
                                        if (gclss[i_193_] == 5)
                                            string_202_ = string_202_ + " | Class A";
                                        if (gfx[i_193_] == 1)
                                            string_202_ = string_202_ + " | 4 Fixes";
                                        if (gfx[i_193_] == 2)
                                            string_202_ = string_202_ + " | 3 Fixes";
                                        if (gfx[i_193_] == 3)
                                            string_202_ = string_202_ + " | 2 Fixes";
                                        if (gfx[i_193_] == 4)
                                            string_202_ = string_202_ + " | 1 Fix";
                                        if (gfx[i_193_] == 5)
                                            string_202_ = string_202_ + " | No Fixing";
                                        rd.setColor(new Color(80, 128, 0));
                                        rd.drawString(string_202_, 243, 28);
                                    }
                                if (wait[i_193_] == 0) {
                                    rd.drawString("Status:", 241 + i_196_, i_195_);
                                    rd.setColor(new Color(128, 73, 0));
                                    if (prevloaded == 0)
                                        rd.drawString("Starting...", 286 + i_196_, i_195_);
                                    else
                                        rd.drawString("Started", 286 + i_196_, i_195_);
                                }
                                if (wait[i_193_] == -1) {
                                    rd.drawString("Status:", 241 + i_196_, i_195_);
                                    rd.setColor(color2k(100, 100, 100));
                                    rd.drawString("Finished", 286 + i_196_, i_195_);
                                }
                            } else {
                                rd.drawString("Status:", 241 + i_196_, i_195_);
                                rd.setColor(new Color(128, 73, 0));
                                rd.drawString("Starting...", 286 + i_196_, i_195_);
                            }
                            if (gwarb[i_193_] == 0) {
                                rd.setColor(new Color(0, 0, 0));
                                if (gmaker[i_193_].equals(pnames[im]))
                                    rd.drawString("Created by You", 449, 23);
                                else {
                                    rd.drawString("Created by", 449, 23);
                                    rd.drawString(":", 511, 23);
                                    rd.drawString(this.gmaker[i_193_], 520, 23);
                                }
                            } else if (wait[i_193_] == 0 || wait[i_193_] == -1 || conon != 1) {
                                rd.setColor(color2k(200, 200, 200));
                                rd.drawRect(349, 16, 253, 16);
                                rd.setFont(new Font("Arial", 0, 11));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(0, 0, 0));
                                int i_203_ = 0;
                                int i_204_ = 0;
                                if (wait[i_193_] == -1) {
                                    final String[] strings = {"", "", "", "", "", "", "", ""};
                                    for (int i_205_ = 0; i_205_ < prnpo; i_205_++)
                                        for (int i_206_ = 0; i_206_ < npo; i_206_++)
                                            if (prnames[i_205_].equals(pnames[i_206_])
                                                    && pgames[i_206_] == gnum[i_193_])
                                                strings[i_205_] = pclan[i_206_];
                                    for (int i_207_ = 0; i_207_ < prnpo; i_207_++)
                                        if (ppos[i_207_] == 0) {
                                            string = strings[i_207_];
                                            break;
                                        }
                                    if (!string.equals("")) {
                                        if (gwtyp[i_193_] == 2) {
                                            boolean bool_208_ = false;
                                            for (int i_209_ = 0; i_209_ < prnpo; i_209_++)
                                                if (!strings[i_209_].toLowerCase().equals(string.toLowerCase())
                                                        && pdam[i_209_] < 55 && pdam[i_209_] != -17) {
                                                    bool_208_ = true;
                                                    break;
                                                }
                                            if (!bool_208_) {
                                                string_198_ = "" + string +
                                                        " should have raced in this game!";
                                                string = "";
                                            }
                                        }
                                        if (gwtyp[i_193_] == 3) {
                                            boolean bool_210_ = true;
                                            for (int i_211_ = 0; i_211_ < prnpo; i_211_++)
                                                if (!strings[i_211_].toLowerCase().equals(string.toLowerCase())
                                                        && pdam[i_211_] < 55 && pdam[i_211_] != -17) {
                                                    bool_210_ = false;
                                                    break;
                                                }
                                            if (!bool_210_) {
                                                string_198_ = "" + string +
                                                        " should have wasted in this game!";
                                                string = "";
                                            }
                                        }
                                        if (gwtyp[i_193_] == 4)
                                            if (string.toLowerCase().equals(gaclan[i_193_].toLowerCase())) {
                                                boolean bool_212_ = true;
                                                for (int i_213_ = 0; i_213_ < prnpo; i_213_++)
                                                    if (!strings[i_213_].toLowerCase().equals(string.toLowerCase())
                                                            && pdam[i_213_] < 55 && pdam[i_213_] != -17) {
                                                        bool_212_ = false;
                                                        break;
                                                    }
                                                if (!bool_212_) {
                                                    string_198_ = "" + string +
                                                            " should have wasted in this game!";
                                                    string = "";
                                                }
                                            } else {
                                                boolean bool_214_ = false;
                                                for (int i_215_ = 0; i_215_ < prnpo; i_215_++)
                                                    if (!strings[i_215_].toLowerCase().equals(string.toLowerCase())
                                                            && pdam[i_215_] < 55 && pdam[i_215_] != -17) {
                                                        bool_214_ = true;
                                                        break;
                                                    }
                                                if (!bool_214_) {
                                                    string_198_ = "" + string +
                                                            " should have raced in this game!";
                                                    string = "";
                                                }
                                            }
                                        if (gwtyp[i_193_] == 5)
                                            if (!string.toLowerCase().equals(gaclan[i_193_].toLowerCase())) {
                                                boolean bool_216_ = true;
                                                for (int i_217_ = 0; i_217_ < prnpo; i_217_++)
                                                    if (!strings[i_217_].toLowerCase().equals(string.toLowerCase())
                                                            && pdam[i_217_] < 55 && pdam[i_217_] != -17) {
                                                        bool_216_ = false;
                                                        break;
                                                    }
                                                if (!bool_216_) {
                                                    string_198_ = "" + string +
                                                            " should have wasted in this game!";
                                                    string = "";
                                                }
                                            } else {
                                                boolean bool_218_ = false;
                                                for (int i_219_ = 0; i_219_ < prnpo; i_219_++)
                                                    if (!strings[i_219_].toLowerCase().equals(string.toLowerCase())
                                                            && pdam[i_219_] < 55 && pdam[i_219_] != -17) {
                                                        bool_218_ = true;
                                                        break;
                                                    }
                                                if (!bool_218_) {
                                                    string_198_ = "" + string +
                                                            " should have raced in this game!";
                                                    string = "";
                                                }
                                            }
                                    } else
                                        string_198_ = "No one finished first - no one survived!";
                                    if (string.toLowerCase().equals(gaclan[i_193_].toLowerCase()))
                                        i_203_ = 1;
                                    if (string.toLowerCase().equals(gvclan[i_193_].toLowerCase()))
                                        i_204_ = 1;
                                }
                                rd.drawString("" + gaclan[i_193_] + " : " +
                                                (gascore[i_193_] + i_203_) + "     |     " + gvclan[i_193_] +
                                                " : " + (gvscore[i_193_] + i_204_) + "",
                                        474 - ftm.stringWidth("" + gaclan[i_193_] +
                                                " : " + gascore[i_193_] + "     |     " +
                                                gvclan[i_193_] + " : " + gvscore[i_193_] + "") / 2,
                                        28);
                                if (gwarb[i_193_] == 1) {
                                    if (gascore[i_193_] + i_203_ >= 5)
                                        string_197_ = "" + gaclan[i_193_] +
                                                " wins the war!";
                                    if (gvscore[i_193_] + i_204_ >= 5)
                                        string_197_ = "" + gvclan[i_193_] +
                                                " wins the war!";
                                } else {
                                    if (gascore[i_193_] + i_203_ >= 3)
                                        string_197_ = "" + gaclan[i_193_] +
                                                " wins the battle!";
                                    if (gvscore[i_193_] + i_204_ >= 3)
                                        string_197_ = "" + gvclan[i_193_] +
                                                " wins the battle!";
                                }
                            }
                            rd.setColor(color2k(200, 200, 200));
                            rd.drawLine(233, 32, 602, 32);
                            rd.drawLine(602, 7, 602, 32);
                            if (conon == 1)
                                if (pgames[im] == ongame)
                                    stringbutton("Leave Game X", 660, 26, 0);
                                else
                                    stringbutton("Close X", 679, 26, 0);
                            rd.drawImage(xt.pls, 292, 39, null);
                            if (opengame != 27) {
                                m.crs = true;
                                m.x = -335;
                                m.y = 0;
                                m.z = -50;
                                m.xz = 0;
                                m.zy = 20;
                                m.ground = -2000;
                                pend = 0;
                                pendb = false;
                                ptime = 0L;
                                opengame = 27;
                            }
                            int i_220_ = 0;
                            int i_221_ = -1;
                            for (int i_222_ = 0; i_222_ < npo; i_222_++)
                                if (pgames[i_222_] == ongame) {
                                    rd.setColor(color2k(240, 240, 240));
                                    if (i_222_ == im && wait[i_193_] != -1)
                                        if (nflk == 0 || conon == 2) {
                                            rd.setColor(color2k(255, 255, 255));
                                            nflk = 3;
                                        } else
                                            nflk--;
                                    rd.fillRect(237, 54 + i_220_ * 42, 170, 40);
                                    rd.setColor(color2k(200, 200, 200));
                                    if (gwarb[i_193_] != 0) {
                                        if (pclan[i_222_].toLowerCase().equals(gaclan[i_193_].toLowerCase()))
                                            rd.setColor(new Color(255, 128, 0));
                                        if (pclan[i_222_].toLowerCase().equals(gvclan[i_193_].toLowerCase()))
                                            rd.setColor(new Color(0, 128, 255));
                                        if (wait[i_193_] == -1 && prevloaded == 1
                                                && string.toLowerCase().equals(pclan[i_222_].toLowerCase())
                                                && nflk == 0)
                                            rd.setColor(new Color(0, 0, 0));
                                    } else if (wait[i_193_] == -1 && prevloaded == 1)
                                        for (int i_223_ = 0; i_223_ < prnpo; i_223_++)
                                            if (pnames[i_222_].equals(prnames[i_223_]) && ppos[i_223_] == 0
                                                    && nflk == 0)
                                                rd.setColor(new Color(0, 0, 0));
                                    rd.drawRect(237, 54 + i_220_ * 42, 170, 40);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pnames[i_222_], 282 - ftm.stringWidth(pnames[i_222_]) / 2,
                                            72 + i_220_ * 42);
                                    rd.setFont(new Font("Arial", 0, 10));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pcarnames[i_222_], 282 - ftm.stringWidth(pcarnames[i_222_]) / 2,
                                            84 + i_220_ * 42);
                                    m.crs = true;
                                    m.x = -335;
                                    m.y = 0;
                                    m.z = -50;
                                    m.xz = 0;
                                    m.zy = 20;
                                    m.ground = -2000;
                                    if (pcars[i_222_] != -1) {
                                        for (int i_224_ = 0; i_224_ < contos[pcars[i_222_]].npl; i_224_++) {
                                            contos[pcars[i_222_]].p[i_224_].flx = 0;
                                            if (contos[pcars[i_222_]].p[i_224_].colnum == 1) {
                                                contos[pcars[i_222_]].p[i_224_].hsb[0] = pcols[i_222_][0];
                                                contos[pcars[i_222_]].p[i_224_].hsb[1] = pcols[i_222_][1];
                                                contos[pcars[i_222_]].p[i_224_].hsb[2] = 1.0F - pcols[i_222_][2];
                                            }
                                            if (contos[pcars[i_222_]].p[i_224_].colnum == 2) {
                                                contos[pcars[i_222_]].p[i_224_].hsb[0] = pcols[i_222_][3];
                                                contos[pcars[i_222_]].p[i_224_].hsb[1] = pcols[i_222_][4];
                                                contos[pcars[i_222_]].p[i_224_].hsb[2] = 1.0F - pcols[i_222_][5];
                                            }
                                        }
                                        if (cac[i_220_] != pcars[i_222_]) {
                                            int i_225_ = contos[pcars[i_222_]].p[0].oz[0];
                                            int i_226_ = i_225_;
                                            int i_227_ = contos[pcars[i_222_]].p[0].oy[0];
                                            int i_228_ = i_227_;
                                            for (int i_229_ = 0; i_229_ < contos[pcars[i_222_]].npl; i_229_++)
                                                for (int i_230_ = 0; i_230_ < contos[pcars[i_222_]].p[i_229_].n; i_230_++) {
                                                    if (contos[pcars[i_222_]].p[i_229_].oz[i_230_] < i_225_)
                                                        i_225_ = contos[this.pcars[i_222_]].p[i_229_].oz[i_230_];
                                                    if (contos[pcars[i_222_]].p[i_229_].oz[i_230_] > i_226_)
                                                        i_226_ = contos[this.pcars[i_222_]].p[i_229_].oz[i_230_];
                                                    if (contos[pcars[i_222_]].p[i_229_].oy[i_230_] < i_227_)
                                                        i_227_ = contos[this.pcars[i_222_]].p[i_229_].oy[i_230_];
                                                    if (contos[pcars[i_222_]].p[i_229_].oy[i_230_] > i_228_)
                                                        i_228_ = contos[this.pcars[i_222_]].p[i_229_].oy[i_230_];
                                                }
                                            cax[i_220_] = (i_226_ + i_225_) / 2;
                                            cay[i_220_] = (i_228_ + i_227_) / 2;
                                            cac[i_220_] = pcars[i_222_];
                                        }
                                        if (i > 327 && i < 402 && i_99_ > 57 + i_220_ * 42
                                                && i_99_ < 91 + i_220_ * 42) {
                                            i_101_ = 12;
                                            i_221_ = i_222_;
                                            for (int i_231_ = 0; i_231_ < contos[pcars[i_222_]].npl; i_231_++)
                                                contos[pcars[i_222_]].p[i_231_].flx = 77;
                                        }
                                        contos[pcars[i_222_]].z = 2500 - i_220_ * 80;
                                        contos[pcars[i_222_]].y = 150 + 250 * i_220_ - cay[i_220_];
                                        contos[pcars[i_222_]].x = -145 - cax[i_220_];
                                        contos[pcars[i_222_]].zy = 0;
                                        contos[pcars[i_222_]].xz = -90;
                                        contos[pcars[i_222_]].xy = pend - i_220_ * 5;
                                        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                                RenderingHints.VALUE_ANTIALIAS_OFF);
                                        contos[pcars[i_222_]].d(rd);
                                        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                                RenderingHints.VALUE_ANTIALIAS_ON);
                                    } else {
                                        rd.setFont(new Font("Arial", 1, 11));
                                        rd.setColor(color2k(80, 80, 80));
                                        rd.drawString("Loading...", 339, 77 + i_220_ * 42);
                                    }
                                    i_220_++;
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
                            if (i_221_ != -1) {
                                if (bool)
                                    mousedout = true;
                                else if (mousedout) {
                                    if (dispcar != i_221_ && i_221_ != -1 && cd.action != 6) {
                                        cd.action = 0;
                                        dispcar = i_221_;
                                        forcar = pcars[i_221_];
                                        dispco = null;
                                        System.gc();
                                        dispco = new ContO(contos[forcar], 0, 0, 0, 0);
                                    } else
                                        dispcar = -1;
                                    mousedout = false;
                                }
                            } else if (mousedout)
                                mousedout = false;
                            for (int i_232_ = 0; i_232_ < 7; i_232_++)
                                for (int i_233_ = 0; i_233_ < npo; i_233_++)
                                    if (pgames[i_233_] == ongame && invos[i_232_].equals(pnames[i_233_])
                                            && dinvi[i_232_].equals(invos[i_232_])) {
                                        for (int i_234_ = i_232_; i_234_ < 6; i_234_++) {
                                            invos[i_234_] = invos[i_234_ + 1];
                                            dinvi[i_234_] = dinvi[i_234_ + 1];
                                        }
                                        invos[6] = "";
                                        dinvi[6] = "";
                                    }
                            if (wait[i_193_] > 0) {
                                int i_235_ = 0;
                                for (int i_236_ = i_220_; i_236_ < mnpls[i_193_]; i_236_++) {
                                    rd.setColor(color2k(200, 200, 200));
                                    rd.drawRect(237, 54 + i_236_ * 42, 170, 40);
                                    boolean bool_237_ = false;
                                    if (pgames[im] == ongame) {
                                        if (!gplyrs[i_193_].equals(""))
                                            bool_237_ = true;
                                    } else if (gwarb[i_193_] == 0) {
                                        if (!gplyrs[i_193_].equals("") && !gplyrs[i_193_].contains(pnames[im]))
                                            bool_237_ = true;
                                    } else if (!xt.clan.toLowerCase().equals(gaclan[i_193_].toLowerCase())
                                            && !xt.clan.toLowerCase().equals(gvclan[i_193_].toLowerCase()))
                                        bool_237_ = true;
                                    if (i > 237 && i < 407 && i_99_ > 54 + i_236_ * 42 && i_99_ < 94 + i_236_ * 42
                                            && !bool_237_) {
                                        if (pgames[im] == ongame)
                                            stringbutton("<     Invite Player      ", 322, 79 + i_236_ * 42, 0);
                                        else
                                            stringbutton("    Join Game    ", 322, 79 + i_236_ * 42, 0);
                                        pbtn = 1;
                                    } else if (invos[i_235_].equals("")) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Empty", 322 - ftm.stringWidth("Empty") / 2, 72 + i_236_ * 42);
                                        rd.setFont(new Font("Arial", 0, 10));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Waiting for player...",
                                                322 - ftm.stringWidth("Waiting for player...") / 2, 84 + i_236_ * 42);
                                    } else if (!dinvi[i_235_].equals(invos[i_235_])) {
                                        if (nflk != 0) {
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString("Inviting player...",
                                                    322 - ftm.stringWidth("Inviting player...") / 2, 79 + i_236_ * 42);
                                        }
                                    } else {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Player Invited!", 322 - ftm.stringWidth("Player Invited!") / 2,
                                                71 + i_236_ * 42);
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(invos[i_235_], 322 - ftm.stringWidth(invos[i_235_]) / 2,
                                                87 + i_236_ * 42);
                                    }
                                    i_235_++;
                                }
                            }
                            if (xt.lan && mnbts[i_193_] != 0) {
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString(
                                        "Plus " + mnbts[i_193_] + " MadBots!",
                                        322 - ftm.stringWidth("Plus " + mnbts[i_193_] +
                                                " MadBots!") / 2,
                                        73 + mnpls[i_193_] * 42);
                            }
                            if (dispcar == -1 || conon != 1) {
                                rd.drawImage(xt.sts, 537, 39, null);
                                rd.setColor(color2k(200, 200, 200));
                                rd.drawRect(415, 54, 293, 166);
                                if (conon == 1) {
                                    if (wait[i_193_] > 0) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (gwarb[i_193_] == 0) {
                                            if (wait[i_193_] > 30 || npls[i_193_] <= 1) {
                                                String string_238_ = "s";
                                                if (mnpls[i_193_] - npls[i_193_] == 1)
                                                    string_238_ = "";
                                                rd.drawString(
                                                        "Waiting for " +
                                                                (mnpls[i_193_] - npls[i_193_]) +
                                                                " more player" + string_238_ +
                                                                " to join to start.",
                                                        561 - ftm
                                                                .stringWidth(
                                                                        "Waiting for " +
                                                                                (mnpls[i_193_]
                                                                                        - this.npls[i_193_]) +
                                                                                " more player" + string_238_ +
                                                                                " to join to start.")
                                                                / 2,
                                                        98);
                                                rd.setFont(new Font("Arial", 0, 12));
                                                ftm = rd.getFontMetrics();
                                                int i_239_ = 134;
                                                if (!gmaker[i_193_].equals("Coach Insano")
                                                        && !gmaker[i_193_].equals(pnames[im])) {
                                                    boolean bool_240_ = false;
                                                    for (int i_241_ = 0; i_241_ < npo; i_241_++)
                                                        if (pgames[i_241_] == ongame
                                                                && gmaker[i_193_].equals(pnames[i_241_]))
                                                            bool_240_ = true;
                                                    if (bool_240_) {
                                                        i_239_ = 144;
                                                        rd.drawString("" +
                                                                        this.gmaker[i_193_] +
                                                                        " can start this game at anytime.",
                                                                561 - ftm.stringWidth("" +
                                                                        this.gmaker[i_193_] +
                                                                        " can start this game at anytime.") / 2,
                                                                124);
                                                    }
                                                }
                                                if (npls[i_193_] > 1) {
                                                    String string_242_ = "" +
                                                            wait[i_193_] + " seconds";
                                                    if (wait[i_193_] > 60)
                                                        string_242_ = "" +
                                                                (int) (wait[i_193_] / 60.0F * 100.0F) / 100.0F +
                                                                " minutes";
                                                    rd.drawString(
                                                            "(Waiting " + string_242_ +
                                                                    " maximum! )",
                                                            561 - ftm.stringWidth("(Waiting " + string_242_ +
                                                                    " maximum! )") / 2,
                                                            i_239_);
                                                }
                                            } else {
                                                final Date date = new Date();
                                                final long l = date.getTime();
                                                if (ptime == 0L || l > ptime + 1500L) {
                                                    if (ptime != 0L) {
                                                        wait[i_193_]--;
                                                        if (wait[i_193_] < 1)
                                                            wait[i_193_] = 1;
                                                    }
                                                    ptime = l;
                                                }
                                                if (pgames[im] == ongame || nflk != 0) {
                                                    rd.drawString("Game starts in " +
                                                                    wait[i_193_] + " seconds!",
                                                            561 - ftm.stringWidth("Game starts in " + this.wait[i_193_] +
                                                                    " seconds!") / 2,
                                                            124);
                                                    if (pgames[im] != ongame)
                                                        nflk--;
                                                } else if (pgames[im] != ongame)
                                                    nflk = 3;
                                            }
                                            if (pgames[im] != ongame) {
                                                if (gplyrs[i_193_].equals("")
                                                        || gplyrs[i_193_].contains(pnames[im]))
                                                    stringbutton("    Join this Game    ", 561, 182, 0);
                                                else {
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    ftm = rd.getFontMetrics();
                                                    rd.setColor(new Color(128, 73, 0));
                                                    rd.drawString("Private Game, only specific players allowed.",
                                                            561 - ftm.stringWidth(
                                                                    "Private Game, only specific players allowed.") / 2,
                                                            180);
                                                    stringbutton("    Join this Game    ", 561, -1000, 0);
                                                }
                                            } else if (gmaker[i_193_].equals(pnames[im])) {
                                                if (npls[i_193_] > 1) {
                                                    if (!fstart)
                                                        stringbutton("    Start this Game Now!    ", 561, 182, 0);
                                                    else
                                                        stringbutton("    Starting game now, one moment...    ", 561,
                                                                182, 0);
                                                } else {
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    ftm = rd.getFontMetrics();
                                                    rd.setColor(new Color(128, 73, 0));
                                                    rd.drawString("You have created this game.",
                                                            561 - ftm.stringWidth("You have created this game.") / 2,
                                                            180);
                                                }
                                            } else {
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(80, 128, 0));
                                                rd.drawString("You have joined this game.",
                                                        561 - ftm.stringWidth("You have joined this game.") / 2, 180);
                                            }
                                        } else {
                                            String string_243_ = "s";
                                            if (mnpls[i_193_] - npls[i_193_] == 1)
                                                string_243_ = "";
                                            rd.drawString(
                                                    "Waiting for " +
                                                            (mnpls[i_193_] - npls[i_193_]) + " clan member" +
                                                            string_243_ + " to join to start.",
                                                    561 - ftm.stringWidth("Waiting for " +
                                                            (mnpls[i_193_] - npls[i_193_]) + " clan member" +
                                                            string_243_ + " to join to start.") / 2,
                                                    72);
                                            int i_244_ = mnpls[i_193_] / 2;
                                            int i_245_ = mnpls[i_193_] / 2;
                                            for (int i_246_ = 0; i_246_ < npo; i_246_++)
                                                if (pgames[i_246_] == gnum[i_193_]) {
                                                    if (pclan[i_246_].toLowerCase().equals(gaclan[i_193_].toLowerCase())
                                                            && --i_244_ < 0)
                                                        i_244_ = 0;
                                                    if (pclan[i_246_].toLowerCase().equals(gvclan[i_193_].toLowerCase())
                                                            && --i_245_ < 0)
                                                        i_245_ = 0;
                                                }
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString("(" + i_244_ + " of " +
                                                            gaclan[i_193_] + "  &  " + i_245_ +
                                                            " of " + gvclan[i_193_] + " )",
                                                    561 - ftm
                                                            .stringWidth("(" + i_244_ +
                                                                    " of " + gaclan[i_193_] +
                                                                    "  &  " + i_245_ + " of " +
                                                                    gvclan[i_193_] + " )")
                                                            / 2,
                                                    87);
                                            rd.drawString(gaclan[i_193_], 491 - ftm.stringWidth(gaclan[i_193_]) / 2,
                                                    125);
                                            rd.drawString(gvclan[i_193_], 631 - ftm.stringWidth(gvclan[i_193_]) / 2,
                                                    125);
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            String string_247_ = "War";
                                            if (gwarb[i_193_] > 1)
                                                string_247_ = "Battle";
                                            rd.drawString(
                                                    "" + string_247_ + " Score",
                                                    561 - ftm
                                                            .stringWidth("" +
                                                                    string_247_ + " Score")
                                                            / 2,
                                                    107);
                                            rd.drawString(
                                                    "" + gascore[i_193_] + "",
                                                    491 - ftm.stringWidth("" +
                                                            gascore[i_193_] + "") / 2,
                                                    139);
                                            rd.drawString(
                                                    "" + gvscore[i_193_] + "",
                                                    631 - ftm.stringWidth("" +
                                                            gascore[i_193_] + "") / 2,
                                                    139);
                                            rd.drawRect(421, 111, 280, 33);
                                            rd.drawLine(561, 111, 561, 144);
                                            rd.setColor(new Color(255, 128, 0));
                                            rd.drawRect(422, 112, 138, 31);
                                            rd.setColor(new Color(0, 128, 255));
                                            rd.drawRect(562, 112, 138, 31);
                                            if (pgames[im] != ongame) {
                                                if (xt.clan.toLowerCase().equals(gaclan[i_193_].toLowerCase())
                                                        || xt.clan.toLowerCase().equals(gvclan[i_193_].toLowerCase()))
                                                    stringbutton("    Join this Game    ", 561, 200, 0);
                                                else {
                                                    rd.setColor(new Color(128, 73, 0));
                                                    rd.drawString("You must be a member of either clan to join.",
                                                            561 - ftm.stringWidth(
                                                                    "You must be a member of either clan to join.") / 2,
                                                            198);
                                                }
                                            } else {
                                                if (gmaker[i_193_].equals(pnames[im]) && npls[i_193_] > 1)
                                                    stringbutton("    Start this Game Now!    ", 561, -1000, 0);
                                                rd.setColor(new Color(80, 128, 0));
                                                rd.drawString("You have joined this game.",
                                                        561 - ftm.stringWidth("You have joined this game.") / 2, 198);
                                            }
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            if (gwtyp[i_193_] == 1) {
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString("This is a normal clan game.",
                                                        561 - ftm.stringWidth("This is a normal clan game.") / 2, 161);
                                                rd.setFont(new Font("Arial", 0, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString("Any clan can win by racing or wasting.", 561
                                                                - ftm.stringWidth("Any clan can win by racing or wasting.") / 2,
                                                        176);
                                            }
                                            if (gwtyp[i_193_] == 2) {
                                                if (sflk != 0) {
                                                    sflk--;
                                                    rd.setColor(new Color(0, 0, 0));
                                                } else {
                                                    sflk = 3;
                                                    rd.setColor(new Color(117, 67, 0));
                                                }
                                                rd.drawString("This is a racing only game!",
                                                        561 - ftm.stringWidth("This is a racing only game!") / 2, 161);
                                                rd.setFont(new Font("Arial", 0, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString("A clan can only win by racing.",
                                                        561 - ftm.stringWidth("A clan can only win by racing.") / 2,
                                                        176);
                                            }
                                            if (gwtyp[i_193_] == 3) {
                                                if (sflk != 0) {
                                                    sflk--;
                                                    rd.setColor(new Color(0, 0, 0));
                                                } else {
                                                    sflk = 3;
                                                    rd.setColor(new Color(117, 67, 0));
                                                }
                                                rd.drawString("This is a wasting only game!",
                                                        561 - ftm.stringWidth("This is a wasting only game!") / 2, 161);
                                                rd.setFont(new Font("Arial", 0, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString("A clan can only win by wasting.",
                                                        561 - ftm.stringWidth("A clan can only win by wasting.") / 2,
                                                        176);
                                            }
                                            if (gwtyp[i_193_] == 4) {
                                                if (sflk != 0) {
                                                    sflk--;
                                                    rd.setColor(new Color(0, 0, 0));
                                                } else {
                                                    sflk = 3;
                                                    rd.setColor(new Color(117, 67, 0));
                                                }
                                                rd.drawString("This is Racers VS Wasters game!",
                                                        561 - ftm.stringWidth("This is Racers VS Wasters game!") / 2,
                                                        161);
                                                rd.drawString(
                                                        "" + gaclan[i_193_] +
                                                                " wastes & " + gvclan[i_193_] +
                                                                " races.",
                                                        561 - ftm.stringWidth("" +
                                                                gaclan[i_193_] + " wastes & " +
                                                                gvclan[i_193_] + " races.")
                                                                / 2,
                                                        176);
                                            }
                                            if (gwtyp[i_193_] == 5) {
                                                if (sflk != 0) {
                                                    sflk--;
                                                    rd.setColor(new Color(0, 0, 0));
                                                } else {
                                                    sflk = 3;
                                                    rd.setColor(new Color(117, 67, 0));
                                                }
                                                rd.drawString("This is Racers VS Wasters game!",
                                                        561 - ftm.stringWidth("This is Racers VS Wasters game!") / 2,
                                                        161);
                                                rd.drawString(
                                                        "" + gaclan[i_193_] +
                                                                " races & " + gvclan[i_193_] +
                                                                " wastes.",
                                                        561 - ftm.stringWidth("" +
                                                                gaclan[i_193_] + " races & " +
                                                                gvclan[i_193_] + " wastes.")
                                                                / 2,
                                                        176);
                                            }
                                        }
                                    } else if (prevloaded == 1) {
                                        int i_248_ = (int) (80.0 + this.rerr / 1.243);
                                        if (i_248_ > 255)
                                            i_248_ = 255;
                                        if (i_248_ < 0)
                                            i_248_ = 0;
                                        int i_249_ = (int) (128.0 + this.rerr / 2.428);
                                        if (i_249_ > 255)
                                            i_249_ = 255;
                                        if (i_249_ < 0)
                                            i_249_ = 0;
                                        int i_250_ = rerr;
                                        if (i_250_ > 255)
                                            i_250_ = 255;
                                        if (i_250_ < 0)
                                            i_250_ = 0;
                                        if (wait[i_193_] == 0) {
                                            rd.setColor(new Color(i_248_, i_249_, i_250_));
                                            rd.setFont(new Font("Arial", 1, 12));
                                            rd.drawString("Live Info!", 621, 51);
                                            rd.drawString("Live Info!", 451, 51);
                                        }
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Tahoma", 1, 11));
                                        rd.drawString("Player       Position   Laps      Power        Damage", 439, 69);
                                        rd.setColor(color2k(200, 200, 200));
                                        rd.drawLine(489, 61, 489, 162);
                                        rd.drawLine(542, 61, 542, 162);
                                        rd.drawLine(579, 61, 579, 162);
                                        rd.drawLine(641, 61, 641, 162);
                                        rd.drawLine(422, 72, 702, 72);
                                        rd.drawLine(422, 163, 702, 163);
                                        i_220_ = 0;
                                        for (int i_251_ = 0; i_251_ < prnpo; i_251_++)
                                            for (int i_252_ = 0; i_252_ < prnpo; i_252_++)
                                                if (ppos[i_252_] == i_251_) {
                                                    rd.setFont(new Font("Tahoma", 0, 11));
                                                    ftm = rd.getFontMetrics();
                                                    rd.setColor(new Color(0, 44, 124));
                                                    rd.drawString(prnames[i_252_],
                                                            455 - ftm.stringWidth(prnames[i_252_]) / 2,
                                                            83 + 11 * i_220_);
                                                    if (pdam[i_252_] < 55 && pdam[i_252_] != -17) {
                                                        rd.setColor(new Color(80, 128, 0));
                                                        String string_253_ = "th";
                                                        if (ppos[i_252_] == 0)
                                                            string_253_ = "st";
                                                        if (ppos[i_252_] == 1)
                                                            string_253_ = "nd";
                                                        if (ppos[i_252_] == 2)
                                                            string_253_ = "rd";
                                                        rd.drawString(
                                                                "" +
                                                                        (this.ppos[i_252_] + 1) +
                                                                        "" + string_253_,
                                                                515 - ftm.stringWidth("" +
                                                                        (this.ppos[i_252_] + 1) + "" +
                                                                        string_253_) / 2,
                                                                83 + 11 * i_220_);
                                                        rd.setColor(new Color(128, 73, 0));
                                                        if (plap[i_252_] > gnlaps[i_193_] - 1)
                                                            plap[i_252_] = this.gnlaps[i_193_] - 1;
                                                        rd.drawString(
                                                                "" +
                                                                        (this.plap[i_252_] + 1) + " / " +
                                                                        this.gnlaps[i_193_] + "",
                                                                560 - ftm.stringWidth("" +
                                                                        (this.plap[i_252_] + 1) + " / " +
                                                                        this.gnlaps[i_193_] + "") / 2,
                                                                83 + 11 * i_220_);
                                                        rd.setColor(new Color(0, 128, 255));
                                                        rd.drawRect(582, 76 + 11 * i_220_, 56, 6);
                                                        rd.fillRect(583, 79 + 11 * i_220_, ppow[i_252_], 3);
                                                        rd.setColor(new Color(128, 210, 255));
                                                        rd.fillRect(583, 77 + 11 * i_220_, ppow[i_252_], 2);
                                                        rd.setColor(new Color(255, 0, 0));
                                                        rd.drawRect(645, 76 + 11 * i_220_, 56, 6);
                                                        rd.fillRect(646, 79 + 11 * i_220_, pdam[i_252_], 3);
                                                        rd.setColor(new Color(255, 155, 64));
                                                        rd.fillRect(646, 77 + 11 * i_220_, pdam[i_252_], 2);
                                                    } else {
                                                        i_248_ = (int) (85.0 + rerr * 2 / 1.5);
                                                        if (i_248_ > 255)
                                                            i_248_ = 255;
                                                        if (i_248_ < 0)
                                                            i_248_ = 0;
                                                        rd.setColor(color2k(i_248_, i_248_, i_248_));
                                                        rd.fillRect(490, 75 + 11 * i_220_, 213, 9);
                                                        rd.setFont(new Font("Tahoma", 1, 11));
                                                        ftm = rd.getFontMetrics();
                                                        i_248_ = 255 - this.rerr * 2;
                                                        if (i_248_ > 255)
                                                            i_248_ = 255;
                                                        if (i_248_ < 0)
                                                            i_248_ = 0;
                                                        i_249_ = (int) (155.0 - rerr * 2 / 1.645);
                                                        if (i_249_ > 255)
                                                            i_249_ = 255;
                                                        if (i_249_ < 0)
                                                            i_249_ = 0;
                                                        i_250_ = (int) (64.0 - rerr * 2 / 3.984);
                                                        if (i_250_ > 255)
                                                            i_250_ = 255;
                                                        if (i_250_ < 0)
                                                            i_250_ = 0;
                                                        rd.setColor(new Color(i_248_, i_249_, i_250_));
                                                        if (pdam[i_252_] != -17)
                                                            rd.drawString(
                                                                    "=   =   =   =    W A S T E D    =   =   =   =",
                                                                    597 - this.ftm.stringWidth(
                                                                            "=   =   =   =    W A S T E D    =   =   =   =")
                                                                            / 2,
                                                                    84 + 11 * i_220_);
                                                        else
                                                            rd.drawString("=   =   =   DISCONNECTED   =   =   =",
                                                                    597 - this.ftm.stringWidth(
                                                                            "=   =   =   DISCONNECTED   =   =   =") / 2,
                                                                    84 + 11 * i_220_);
                                                    }
                                                    i_220_++;
                                                }
                                        if (wait[i_193_] == 0)
                                            stringbutton("    Watch Live Now!    ", 561, 196, 0);
                                        else {
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            int i_254_ = 186;
                                            if (!lapsname.equals("") && !wastename.equals("") && !stuntname.equals(""))
                                                i_254_ = 183;
                                            if (gwarb[i_193_] == 0) {
                                                String string_255_ = "";
                                                for (int i_256_ = 0; i_256_ < prnpo; i_256_++)
                                                    if (ppos[i_256_] == 0) {
                                                        string_255_ = prnames[i_256_];
                                                        break;
                                                    }
                                                if (string_255_.equals(""))
                                                    rd.drawString("Game Finished!    Nobody Won!",
                                                            561 - ftm.stringWidth("Game Finished!    Nobody Won!") / 2,
                                                            i_254_);
                                                else {
                                                    rd.drawString(
                                                            "Game Finished!    Winner:  " +
                                                                    string_255_ + "",
                                                            561 - ftm
                                                                    .stringWidth("Game Finished!    Winner:  " +
                                                                            string_255_ + "")
                                                                    / 2,
                                                            i_254_);
                                                    if (nflk == 0) {
                                                        rd.setColor(new Color(255, 176, 67));
                                                        nflk = 3;
                                                    } else
                                                        nflk--;
                                                    rd.drawString(
                                                            "" +
                                                                    string_255_ + "", 561
                                                                    - ftm.stringWidth("Game Finished!    Winner:  " +
                                                                    string_255_ + "")
                                                                    / 2
                                                                    + ftm.stringWidth("Game Finished!    Winner:  "),
                                                            i_254_);
                                                }
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 0, 11));
                                                ftm = rd.getFontMetrics();
                                                String string_257_ = "    ";
                                                int i_258_ = 0;
                                                if (!lapsname.equals("")) {
                                                    string_257_ = string_257_ +
                                                            "Fastest lap: " + lapsname + "    ";
                                                    i_258_++;
                                                }
                                                if (!wastename.equals("")) {
                                                    string_257_ = string_257_ +
                                                            "Deadliest waster: " + wastename +
                                                            "    ";
                                                    i_258_++;
                                                }
                                                if (i_258_ == 2) {
                                                    if (!stuntname.equals("")) {
                                                        rd.drawString(string_257_,
                                                                561 - this.ftm.stringWidth(string_257_) / 2, 199);
                                                        rd.drawString(
                                                                "Best stunt: " +
                                                                        this.stuntname + "",
                                                                561 - ftm.stringWidth("Best stunt: " + this.stuntname +
                                                                        "") / 2,
                                                                213);
                                                    } else
                                                        rd.drawString(string_257_,
                                                                561 - this.ftm.stringWidth(string_257_) / 2, 206);
                                                } else {
                                                    if (!stuntname.equals(""))
                                                        string_257_ = string_257_ +
                                                                "Best stunt: " + this.stuntname +
                                                                "    ";
                                                    rd.drawString(string_257_, 561 - ftm.stringWidth(string_257_) / 2,
                                                            206);
                                                }
                                            } else if (string_197_.equals("")) {
                                                if (string.equals("")) {
                                                    rd.drawString("Game Finished!    Nobody Won!",
                                                            561 - ftm.stringWidth("Game Finished!    Nobody Won!") / 2,
                                                            186);
                                                    rd.setFont(new Font("Arial", 1, 11));
                                                    ftm = rd.getFontMetrics();
                                                    rd.drawString(string_198_, 561 - ftm.stringWidth(string_198_) / 2,
                                                            206);
                                                } else {
                                                    rd.drawString(
                                                            "Game Finished!    " +
                                                                    string + "  Wins!",
                                                            561 - ftm.stringWidth("Game Finished!    " + string +
                                                                    "  Wins!") / 2,
                                                            196);
                                                    if (nflk == 0) {
                                                        rd.setColor(new Color(255, 176, 67));
                                                        nflk = 3;
                                                    } else
                                                        nflk--;
                                                    rd.drawString("" + string +
                                                                    "", 561
                                                                    - ftm.stringWidth("Game Finished!    " + string +
                                                                    "  Wins!") / 2
                                                                    + ftm.stringWidth("Game Finished!    "),
                                                            196);
                                                }
                                            } else {
                                                if (nflk == 0) {
                                                    rd.setColor(new Color(255, 176, 67));
                                                    nflk = 3;
                                                } else
                                                    nflk--;
                                                rd.drawString(string_197_, 561 - ftm.stringWidth(string_197_) / 2, 196);
                                            }
                                        }
                                        rerr += 3;
                                    } else {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (prevloaded == -1) {
                                            if (!xt.lan)
                                                rd.drawString("Loading Info...",
                                                        561 - ftm.stringWidth("Loading Info...") / 2, 134);
                                            else if (pgames[im] == ongame)
                                                rd.drawString("About to Start...",
                                                        561 - ftm.stringWidth("About to Start...") / 2, 134);
                                            else {
                                                rd.drawString("Game Started", 561 - ftm.stringWidth("Game Started") / 2,
                                                        117);
                                                stringbutton("    Watch this Game    ", 561, 154, 0);
                                            }
                                        } else
                                            rd.drawString("About to Start...",
                                                    561 - ftm.stringWidth("About to Start...") / 2, 134);
                                    }
                                } else {
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    if (conon == 2)
                                        rd.drawString("Starting Game Now!",
                                                561 - ftm.stringWidth("Starting Game Now!") / 2, 124);
                                    if (conon == 3)
                                        rd.drawString("Opening Game Now!",
                                                561 - ftm.stringWidth("Opening Game Now!") / 2, 124);
                                    rd.setFont(new Font("Arial", 0, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString("Please Wait...", 561 - ftm.stringWidth("Please Wait...") / 2, 154);
                                }
                                rd.setColor(color2k(200, 200, 200));
                                rd.drawRect(415, 222, 293, 40);
                                rd.drawImage(xt.stg, 422, 227, null);
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 10));
                                ftm = rd.getFontMetrics();
                                rd.drawString("Laps: " + gnlaps[i_193_] + "", 660, 235);
                                if (i > 415 && i < 708 && i_99_ > 222 && i_99_ < 262
                                        && (wait[i_193_] > 0 || gstgn[i_193_] < 0) && conon == 1) {
                                    stringbutton("       Preview Stage       ", 562, 247, 0);
                                    pbtn = 2;
                                } else {
                                    rd.drawString("Stage " + gstgn[i_193_], 562 - ftm.stringWidth("Stage " + gstgn[i_193_]) / 2, 237);
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(gstages[i_193_], 562 - ftm.stringWidth(gstages[i_193_]) / 2, 254);
                                }
                                if (!xt.lan) {
                                    int i_261_ = 237;
                                    int i_262_ = 471;
                                    if (wait[i_193_] > 0) {
                                        if (mnpls[i_193_] > 5) {
                                            i_261_ = 415;
                                            i_262_ = 293;
                                        }
                                    } else if (npls[i_193_] > 5) {
                                        i_261_ = 415;
                                        i_262_ = 293;
                                    }
                                    rd.setColor(color2k(200, 200, 200));
                                    rd.drawRect(i_261_, 264, i_262_, 124);
                                    rd.setColor(color2k(240, 240, 240));
                                    rd.fillRect(i_261_ + 1, 265, i_262_ - 1, 21);
                                    rd.drawImage(xt.gmc, i_261_ + 7, 269, null);
                                    rd.setFont(new Font("Tahoma", 0, 11));
                                    rd.setColor(color2k(110, 110, 110));
                                    rd.drawString("(Game Chat )", i_261_ + 57, 278);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (updatec != -1) {
                                        final String[] strings = new String[7];
                                        final String[] strings_263_ = new String[7];
                                        final boolean[] bools = {false, false, false, false, false, false, false};
                                        for (int i_264_ = 0; i_264_ < 7; i_264_++) {
                                            strings[i_264_] = "";
                                            strings_263_[i_264_] = cnames[i_264_];
                                            int i_265_ = 0;
                                            int i_266_ = 0;
                                            int i_267_ = 0;
                                            int i_268_ = 0;
                                            int i_269_ = 0;
                                            for (/**/ ; i_265_ < sentn[i_264_].length(); i_265_++) {
                                                final String string_270_ = "" +
                                                        sentn[i_264_].charAt(i_265_);
                                                if (string_270_.equals(" ")) {
                                                    i_266_ = i_267_;
                                                    i_268_ = i_265_;
                                                    i_269_++;
                                                } else
                                                    i_269_ = 0;
                                                if (i_269_ <= 1) {
                                                    final StringBuilder stringbuilder = new StringBuilder();
                                                    strings[i_264_] = stringbuilder.append(strings[i_264_])
                                                            .append(string_270_).toString();
                                                    i_267_++;
                                                    if (ftm.stringWidth(strings[i_264_]) > i_262_ - 94)
                                                        if (i_266_ != 0) {
                                                            strings[i_264_] = strings[i_264_].substring(0, i_266_);
                                                            for (int i_273_ = 0; i_273_ < i_264_; i_273_++) {
                                                                strings[i_273_] = strings[i_273_ + 1];
                                                                strings_263_[i_273_] = strings_263_[i_273_ + 1];
                                                                bools[i_273_] = bools[i_273_ + 1];
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
                                        String string_274_ = "";
                                        rd.setFont(new Font("Tahoma", 1, 11));
                                        ftm = rd.getFontMetrics();
                                        for (int i_275_ = 0; i_275_ < 7; i_275_++)
                                            if (!string_274_.equals(strings_263_[i_275_])) {
                                                rd.drawString(
                                                        strings_263_[i_275_] + ":",
                                                        i_261_ + 84 - ftm.stringWidth(strings_263_[i_275_] + ":"),
                                                        299 + i_275_ * 14);
                                                string_274_ = strings_263_[i_275_];
                                            }
                                        rd.setFont(new Font("Tahoma", 0, 11));
                                        for (int i_276_ = 0; i_276_ < 7; i_276_++) {
                                            if (bools[i_276_] && i_276_ == 0 && strings[i_276_].contains(" "))
                                                strings[i_276_] = "..." +
                                                        strings[i_276_].substring(strings[i_276_].indexOf(" "),
                                                                strings[i_276_].length()) +
                                                        "";
                                            rd.drawString(strings[i_276_], i_261_ + 88, 299 + i_276_ * 14);
                                        }
                                    } else
                                        rd.drawString("Loading chat...",
                                                i_261_ + i_262_ / 2 - ftm.stringWidth("Loading chat...") / 2, 315);
                                    if (conon == 1)
                                        pre2 = true;
                                    else
                                        hideinputs();
                                    if (control.enter && !gs.cmsg.getText().equals("Type here...")
                                            && !gs.cmsg.getText().equals("")) {
                                        pessd[btn] = true;
                                        control.enter = false;
                                        String string_277_ = gs.cmsg.getText().replace('|', ':');
                                        if (string_277_.toLowerCase().contains(gs.tpass.getText().toLowerCase()))
                                            string_277_ = " ";
                                        if (!xt.msgcheck(string_277_) && updatec > -12) {
                                            for (int i_278_ = 0; i_278_ < 6; i_278_++) {
                                                sentn[i_278_] = sentn[i_278_ + 1];
                                                cnames[i_278_] = cnames[i_278_ + 1];
                                            }
                                            sentn[6] = string_277_;
                                            cnames[6] = pnames[im];
                                            if (updatec > -11)
                                                updatec = -11;
                                            else
                                                updatec--;
                                        } else
                                            xt.warning++;
                                        gs.cmsg.setText("");
                                    }
                                    stringbutton("Send Message", 655, 405, 3);
                                }
                            } else {
                                if (gs.cmsg.isShowing())
                                    gs.cmsg.setVisible(false);
                                if (pcars[dispcar] == forcar && forcar != -1) {
                                    rd.drawImage(xt.crd, 517, 81, null);
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
                                    rd.drawString(cd.names[forcar], 561 - ftm.stringWidth(cd.names[forcar]) / 2, 117);
                                    for (int i_279_ = 0; i_279_ < dispco.npl; i_279_++) {
                                        if (contos[forcar].p[i_279_].colnum == 1) {
                                            dispco.p[i_279_].hsb[0] = pcols[dispcar][0];
                                            dispco.p[i_279_].hsb[1] = pcols[dispcar][1];
                                            dispco.p[i_279_].hsb[2] = 1.0F - pcols[dispcar][2];
                                        }
                                        if (contos[forcar].p[i_279_].colnum == 2) {
                                            dispco.p[i_279_].hsb[0] = pcols[dispcar][3];
                                            dispco.p[i_279_].hsb[1] = pcols[dispcar][4];
                                            dispco.p[i_279_].hsb[2] = 1.0F - pcols[dispcar][5];
                                        }
                                    }
                                    m.cx = 561;
                                    dispco.z = 1200;
                                    dispco.y = 605 - dispco.grat;
                                    dispco.x = 225;
                                    dispco.zy = 0;
                                    dispco.xz = mrot;
                                    mrot -= 5;
                                    if (mrot < -360)
                                        mrot += 360;
                                    dispco.xy = 0;
                                    dispco.wzy -= 10;
                                    if (dispco.wzy < -45)
                                        dispco.wzy += 45;
                                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                            RenderingHints.VALUE_ANTIALIAS_OFF);
                                    dispco.d(rd);
                                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                            RenderingHints.VALUE_ANTIALIAS_ON);
                                    m.cx = 400;
                                    rd.setFont(new Font("Arial", 1, 11));
                                    int i_280_ = 424;
                                    int i_281_ = -55;
                                    rd.setColor(new Color(0, 63, 128));
                                    rd.drawString("Top Speed:", 30 + i_280_, 318 + i_281_);
                                    rd.drawImage(xt.statb, 97 + i_280_, 312 + i_281_, null);
                                    rd.drawString("Acceleration:", 20 + i_280_, 333 + i_281_);
                                    rd.drawImage(xt.statb, 97 + i_280_, 327 + i_281_, null);
                                    rd.setColor(color2k(255, 255, 255));
                                    float f = (cd.swits[forcar][2] - 220) / 90.0F;
                                    if (f < 0.2)
                                        f = 0.2F;
                                    rd.fillRect((int) (97.0F + 156.0F * f) + i_280_, 312 + i_281_,
                                            (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    f = cd.acelf[forcar][1] * cd.acelf[forcar][0] * cd.acelf[forcar][2]
                                            * cd.grip[forcar] / 7700.0F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    rd.fillRect((int) (97.0F + 156.0F * f) + i_280_, 327 + i_281_,
                                            (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    rd.drawImage(xt.statbo, 97 + i_280_, 312 + i_281_, null);
                                    rd.drawImage(xt.statbo, 97 + i_280_, 327 + i_281_, null);
                                    i_280_ = 50;
                                    i_281_ = -25;
                                    rd.setColor(new Color(0, 63, 128));
                                    rd.drawString("Stunts:", 427 + i_280_, 318 + i_281_);
                                    rd.drawImage(xt.statb, 471 + i_280_, 312 + i_281_, null);
                                    rd.drawString("Strength:", 415 + i_280_, 333 + i_281_);
                                    rd.drawImage(xt.statb, 471 + i_280_, 327 + i_281_, null);
                                    rd.drawString("Endurance:", 405 + i_280_, 348 + i_281_);
                                    rd.drawImage(xt.statb, 471 + i_280_, 342 + i_281_, null);
                                    rd.setColor(color2k(255, 255, 255));
                                    f = (cd.airc[forcar] * cd.airs[forcar] * cd.bounce[forcar] + 28.0F) / 139.0F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i_280_, 312 + i_281_,
                                            (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    final float f_282_ = 0.5F;
                                    f = (cd.moment[forcar] + f_282_) / 2.6F;
                                    if (f > 1.0F)
                                        f = 1.0F;
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i_280_, 327 + i_281_,
                                            (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    f = cd.outdam[forcar];
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i_280_, 342 + i_281_,
                                            (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    rd.drawImage(xt.statbo, 471 + i_280_, 312 + i_281_, null);
                                    rd.drawImage(xt.statbo, 471 + i_280_, 327 + i_281_, null);
                                    rd.drawImage(xt.statbo, 471 + i_280_, 342 + i_281_, null);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (forcar < 16) {
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Created by Radicalplay.com",
                                                561 - ftm.stringWidth("Created by Radicalplay.com") / 2, 347);
                                        String string_283_ = "Game Car";
                                        if (cd.cclass[forcar] == 0)
                                            string_283_ = "Class C ,  Game Car";
                                        if (cd.cclass[forcar] == 1)
                                            string_283_ = "Class B & C ,  Game Car";
                                        if (cd.cclass[forcar] == 2)
                                            string_283_ = "Class B ,  Game Car";
                                        if (cd.cclass[forcar] == 3)
                                            string_283_ = "Class A & B ,  Game Car";
                                        if (cd.cclass[forcar] == 4)
                                            string_283_ = "Class A ,  Game Car";
                                        rd.drawString(string_283_, 561 - ftm.stringWidth(string_283_) / 2, 367);
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("You already have this car.",
                                                561 - ftm.stringWidth("You already have this car.") / 2, 395);
                                    } else {
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (!cd.createdby[forcar - 16].equals(xt.nickname)) {
                                            rd.drawString(
                                                    "Created by :  " +
                                                            cd.createdby[forcar - 16] + "",
                                                    561 - ftm.stringWidth("Created by :  " +
                                                            cd.createdby[forcar - 16] + "")
                                                            / 2,
                                                    347);
                                            final int i_284_ = ftm.stringWidth(cd.createdby[forcar - 16]);
                                            final int i_285_ = 561
                                                    - ftm.stringWidth("Created by :  " +
                                                    cd.createdby[forcar - 16] + "")
                                                    / 2
                                                    + ftm.stringWidth("Created by :  " +
                                                    cd.createdby[forcar - 16] + "")
                                                    - i_284_;
                                            rd.drawLine(i_285_, 349, i_285_ + i_284_ - 2, 349);
                                            if (i > i_285_ - 2 && i < i_285_ + i_284_ && i_99_ > 334 && i_99_ < 351) {
                                                if (bool) {
													/*if (!gb.proname.equals(cd.createdby[forcar - 16])) {
														gb.proname = cd.createdby[this.forcar - 16];
														gb.loadedp = false;
													}
													gb.tab = 1;
													gb.open = 2;
													gb.upo = true;*/
                                                }
                                                i_101_ = 12;
                                            }
                                        } else
                                            rd.drawString("Created by You", 561 - ftm.stringWidth("Created by You") / 2,
                                                    347);
                                        rd.setColor(new Color(128, 73, 0));
                                        String string_286_ = "";
                                        if (cd.cclass[forcar] == 0)
                                            string_286_ = "Class C ,  ";
                                        if (cd.cclass[forcar] == 1)
                                            string_286_ = "Class B & C ,  ";
                                        if (cd.cclass[forcar] == 2)
                                            string_286_ = "Class B ,  ";
                                        if (cd.cclass[forcar] == 3)
                                            string_286_ = "Class A & B ,  ";
                                        if (cd.cclass[forcar] == 4)
                                            string_286_ = "Class A ,  ";
                                        if (cd.publish[forcar - 16] == 0)
                                            string_286_ = string_286_ + "Private Car";
                                        if (cd.publish[forcar - 16] == 1) {
                                            string_286_ = string_286_ + "Public Car";
                                            rd.setColor(new Color(0, 64, 128));
                                        }
                                        if (cd.publish[forcar - 16] == 2) {
                                            string_286_ = string_286_ +
                                                    "Super Public Car";
                                            rd.setColor(new Color(0, 64, 128));
                                        }
                                        rd.drawString(string_286_, 561 - ftm.stringWidth(string_286_) / 2, 367);
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        if (cd.publish[forcar - 16] == 1 || cd.publish[forcar - 16] == 2) {
                                            if (cd.action == -9)
                                                rd.drawString("Failed to add car!  Unknown error!",
                                                        561 - ftm.stringWidth("Failed to add car!  Unknown error!") / 2,
                                                        395);
                                            if (cd.action == -8)
                                                rd.drawString("Failed!  You already have 20 cars!",
                                                        561 - ftm.stringWidth("Failed!  You already have 20 cars!") / 2,
                                                        395);
                                            if (cd.action == 7)
                                                rd.drawString(
                                                        "" + cd.names[cd.ac] +
                                                                " has been added to your cars!",
                                                        561 - ftm.stringWidth("" +
                                                                cd.names[this.cd.ac] +
                                                                " has been added to your cars!")
                                                                / 2,
                                                        395);
                                            if (cd.action == -7)
                                                rd.drawString("You already have this car.",
                                                        561 - ftm.stringWidth("You already have this car.") / 2, 395);
                                            if (cd.action == 6)
                                                rd.drawString("Adding Car...",
                                                        561 - ftm.stringWidth("Adding Car...") / 2, 395);
                                            if (cd.action == -6) {
                                                final String string_287_ = "Upgrade to a full account to add custom cars!";
                                                final int i_288_ = 561 - ftm.stringWidth(string_287_) / 2;
                                                final int i_289_ = i_288_ + ftm.stringWidth(string_287_);
                                                rd.drawString(string_287_, i_288_, 395);
                                                if (waitlink != -1)
                                                    rd.drawLine(i_288_, 396, i_289_, 396);
                                                if (i > i_288_ && i < i_289_ && i_99_ > 384 && i_99_ < 397) {
                                                    if (waitlink != -1)
                                                        i_101_ = 12;
                                                    if (bool && waitlink == 0) {
                                                        gs.editlink(xt.nickname, true);
                                                        waitlink = -1;
                                                    }
                                                }
                                                if (waitlink > 0)
                                                    waitlink--;
                                            }
                                            if (cd.action == 0 && xt.drawcarb(true, null, " Add to My Cars ", 503, 375,
                                                    i, i_99_, bool))
                                                if (xt.logged) {
                                                    if (cd.lastload != 2 || forcar >= 36) {
                                                        cd.action = 6;
                                                        cd.ac = forcar;
                                                        cd.sparkactionloader();
                                                    } else
                                                        cd.action = -7;
                                                } else {
                                                    cd.action = -6;
                                                    waitlink = 20;
                                                }
                                        } else
                                            rd.drawString("Private Car.  Cannot be added to account.", 561
                                                            - ftm.stringWidth("Private Car.  Cannot be added to account.") / 2,
                                                    395);
                                    }
                                    if (xt.drawcarb(true, null, "X", 682, 99, i, i_99_, bool))
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
                    if (gs.cmsg.isShowing()) {
                        gs.cmsg.setVisible(false);
                        gs.requestFocus();
                    }
                    rd.setColor(color2k(255, 255, 255));
                    rd.fillRoundRect(155, 148, 490, 127, 20, 20);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawRoundRect(155, 148, 490, 127, 20, 20);
                    if (ontyp != 76) {
                        String string = "";
                        int i_290_ = 0;
                        if (ontyp >= 10) {
                            i_290_ = 10;
                            string = "Custom Cars";
                            if (ontyp > 10)
                                string = string + ", ";
                        }
                        if (ontyp >= 20) {
                            i_290_ = 20;
                            string = "Game Cars";
                            if (ontyp > 20)
                                string = string + ", ";
                        }
                        if (ontyp >= 30) {
                            i_290_ = 30;
                            string = "Clan Cars";
                            if (ontyp > 30)
                                string = string + ", ";
                        }
                        if (ontyp - i_290_ == 1)
                            string = string + "Class C";
                        if (ontyp - i_290_ == 2)
                            string = string + "Class B & C";
                        if (ontyp - i_290_ == 3)
                            string = string + "Class B";
                        if (ontyp - i_290_ == 4)
                            string = string + "Class A & B";
                        if (ontyp - i_290_ == 5)
                            string = string + "Class A";
                        if (ontyp <= -2)
                            if (Math.abs(ontyp + 2) == 13)
                                string = " " + cd.names[Math.abs(ontyp + 2)] +
                                        "  Game";
                            else
                                string = "" + cd.names[Math.abs(ontyp + 2)] +
                                        " Game";
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(": :   " + string + "   : :",
                                400 - ftm.stringWidth(
                                        ": :   " + string + "   : :")
                                        / 2,
                                175);
                        string = "a";
                        if (ontyp - i_290_ == 1)
                            string = "a class C";
                        if (ontyp - i_290_ == 2)
                            string = "a class B or C";
                        if (ontyp - i_290_ == 3)
                            string = "a class B";
                        if (ontyp - i_290_ == 4)
                            string = "a class A or B";
                        if (ontyp - i_290_ == 5)
                            string = "a class A";
                        if (i_290_ == 0)
                            string = string + " car";
                        if (i_290_ == 10)
                            string = string + " custom car";
                        if (i_290_ == 20)
                            string = string + " game car";
                        if (i_290_ == 30)
                            string = string + " clan car";
                        if (ontyp <= -2)
                            if (Math.abs(ontyp + 2) == 13)
                                string = " " + cd.names[Math.abs(ontyp + 2)] +
                                        " ";
                            else
                                string = "" + cd.names[Math.abs(ontyp + 2)] + "";
                        rd.drawString(
                                "To join this game you need to have " + string +
                                        "!",
                                400 - ftm.stringWidth("To join this game you need to have " +
                                        string + "!") / 2,
                                206);
                        stringbutton("  Get " + string + " now  ",
                                400, 247, 0);
                        stringbutton("  Cancel X  ", 593, 259, 2);
                        //if (gb.open > 0 && gb.upo)
                        //	onjoin = -1;
                    } else {
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(": :   Custom Stage   : :", 400 - ftm.stringWidth(": :   Custom Stage   : :") / 2,
                                175);
                        rd.drawString("You need to upgrade to a full account to join this game!",
                                400 - ftm.stringWidth("You need to upgrade to a full account to join this game!") / 2,
                                202);
                        rd.setColor(color2k(200, 200, 200));
                        rd.fillRoundRect(310, 215, 180, 50, 20, 20);
                        drawSbutton(xt.upgrade, 400, 240);
                        stringbutton("  Cancel X  ", 593, 259, 2);
                    }
                }
            } else {
                xt.mainbg(3);
                btn = 0;
                if (gs.cmsg.isShowing()) {
                    gs.cmsg.setVisible(false);
                    gs.requestFocus();
                }
                rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
                rd.drawImage(xt.bggo, 0, 0, null);
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(65, 425, 670, 25);
                rd.fillRect(0, 0, 65, 450);
                rd.fillRect(735, 0, 65, 450);
                rd.fillRect(65, 0, 670, 25);
                float f = 1.0F - (lg.flipo - 10) / 80.0F;
                if (f > 1.0F)
                    f = 1.0F;
                if (f < 0.0F)
                    f = 0.0F;
                rd.setComposite(AlphaComposite.getInstance(3, f));
                if (lg.flipo > 10)
                    rd.drawImage(xt.logomadnes, 97 + (int) (2.0 - Math.random() * 4.0),
                            36 + (int) (2.0 - Math.random() * 4.0), null);
                else
                    rd.drawImage(xt.logomadnes, 97, 36, null);
                lg.flipo++;
                if (lg.flipo > 50)
                    lg.flipo = 0;
                final int i_291_ = 30;
                rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                rd.setColor(new Color(203, 227, 253));
                rd.fillRoundRect(115, 57 + i_291_, 570, 307, 20, 20);
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                rd.setColor(color2k(90, 90, 90));
                rd.drawRoundRect(115, 57 + i_291_, 570, 307, 20, 20);
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                rd.setColor(color2k(0, 0, 0));
                rd.drawString("You are allowed 5 multiplayer turns per day to try the game with your trial account.",
                        135, 85 + i_291_);
                rd.drawString("Upgrade your account to a full account to purchase and play the multiplayer game.", 135,
                        105 + i_291_);
                drawSbutton(xt.upgrade, 400, 130 + i_291_);
                rd.setColor(new Color(30, 70, 110));
                rd.drawString("You can upgrade your account by just sharing the game & posting about it online!", 135,
                        165 + i_291_);
                rd.drawString("Click 'Upgrade' for more details.", 135, 185 + i_291_);
                rd.drawString("Or try the multiplayer again tomorrow.", 135, 205 + i_291_);
                rd.setColor(color2k(0, 0, 0));
                rd.drawString("For now to preview and try the multiplayer more, with your trial account you can:", 135,
                        245 + i_291_);
                rd.setColor(new Color(30, 70, 110));
                rd.drawString("-  Watch online multiplayer games.", 135, 265 + i_291_);
                rd.drawString("-  Access the multiplayer dome.", 135, 285 + i_291_);
                rd.drawString("-  Play LAN multiplayer games (unlimitedly).", 135, 305 + i_291_);
                drawSbutton(xt.exit, 400, 336 + i_291_);
            }
        } else {
            xt.drawWarning();
            if (gs.cmsg.isShowing()) {
                gs.cmsg.setVisible(false);
                gs.requestFocus();
            }
            if (xt.warning > 220) {
                conon = 0;
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
            xt.warning++;
        }
        if (i_101_ != pcurs) {
            gs.setCursor(new Cursor(i_101_));
            pcurs = i_101_;
        }
    }

    public void preforma(final int i, final int i_292_) {
        if (pre1) {
            boolean bool = false;
            if (!gs.openm/* && gb.open == 0*/) {
                if (conon != 0)
                    bool = true;
            } else if (gs.cmsg.isShowing())
                gs.cmsg.setVisible(false);
            gs.movefieldd(gs.cmsg, 235, 390, 360, 22, bool);
            if (gs.cmsg.getText().equals("Type here...") && i > 234 && i < 603 && i_292_ > 385 && i_292_ < 417)
                gs.cmsg.setText("");
        }
        if (pre2) {
            boolean bool = false;
            if (!gs.openm/* && gb.open == 0*/)
                bool = true;
            else if (gs.cmsg.isShowing())
                gs.cmsg.setVisible(false);
            gs.movefieldd(gs.cmsg, 237, 390, 360, 22, bool);
            if (gs.cmsg.getText().equals("Type here...") && i > 232 && i < 601 && i_292_ > 385 && i_292_ < 417)
                gs.cmsg.setText("");
        }
        if (pre1 || pre2) {
            if (gs.cmsg.getText().length() > 100) {
                gs.cmsg.setText(gs.cmsg.getText().substring(0, 100));
                gs.cmsg.select(100, 100);
            }
            pre1 = false;
            pre2 = false;
        }
    }

    @Override
    public void run() {
        int i = -1;
        while (conon == 1) {
            Date date = new Date();
            final long l = date.getTime();
            if (!lloaded)
                gs.setCursor(new Cursor(3));
            if (!xt.logged && !xt.lan && xt.nfreeplays - xt.ndisco >= 5) {
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
                for (int i_2_ = 0; i_2_ < ngm; i_2_++)
                    if (join == gnum[i_2_] || pgames[im] == gnum[i_2_])
                        i_1_ = i_2_;
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
                    if (gcrs[i_1_] == 1 && gwarb[i_1_] != 0 && xt.sc[0] != 36) {
                        bool = true;
                        ontyp = 30;
                        if (gclss[i_1_] > 0 && gclss[i_1_] <= 5)
                            ontyp += gclss[i_1_];
                    }
                    if (gclss[i_1_] > 0 && gclss[i_1_] <= 5 && Math.abs(cd.cclass[pcars[im]] - (gclss[i_1_] - 1)) > 1) {
                        bool = true;
                        if (gcrs[i_1_] == 1)
                            if (gwarb[i_1_] == 0)
                                ontyp = 10;
                            else
                                ontyp = 30;
                        if (gcrs[i_1_] == 2)
                            ontyp = 20;
                        ontyp += gclss[i_1_];
                    }
                    if (gclss[i_1_] <= -2 && pcars[im] != Math.abs(gclss[i_1_] + 2)) {
                        bool = true;
                        ontyp = gclss[i_1_];
                    }
                    if (gstgn[i_1_] == -2 && !xt.logged) {
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
            if (xt.onjoin != -1) {
                join = xt.onjoin;
                ongame = xt.onjoin;
                xt.onjoin = -1;
            }
            if (updatec < -17)
                updatec = -17;
            boolean bool = false;
            if (lloaded) {
                i = pgames[im];
                if (i != -1)
                    for (int i_3_ = 0; i_3_ < ngm; i_3_++)
                        if (i == gnum[i_3_]) {
                            laps = gnlaps[i_3_];
                            stage = gstgn[i_3_];
                            stagename = gstages[i_3_];
                            nfix = gfx[i_3_];
                            notb = gntb[i_3_] == 1;
                        }
            }
            String string = "" + xt.sc[0] + "";
            if (xt.sc[0] >= xtGraphics.nCars)
                string = "C" + cd.names[xt.sc[0]] + "";
            String string_4_ = "1|" + xt.nickname + ":" + xt.nickey +
                    "|" + xt.clan + "|" + xt.clankey + "|" + string + "|" +
                    join + "|" + (int) (xt.arnp[0] * 100.0F) + "|" +
                    (int) (xt.arnp[1] * 100.0F) + "|" + (int) (xt.arnp[2] * 100.0F) + "|" +
                    (int) (xt.arnp[3] * 100.0F) + "|" + (int) (xt.arnp[4] * 100.0F) + "|" +
                    (int) (xt.arnp[5] * 100.0F) + "|" + ongame + "|";
            if (!xt.lan) {
                string_4_ = string_4_ + "" + updatec + "|";
                if (updatec <= -11) {
                    for (int i_5_ = 0; i_5_ < -updatec - 10; i_5_++)
                        string_4_ = string_4_ + "" + cnames[6 - i_5_] +
                                "|" + sentn[6 - i_5_] + "|";
                    updatec = -2;
                }
            } else {
                String string_6_;
                try {
                    string_6_ = InetAddress.getLocalHost().getHostName();
                    if (string_6_.contains("|"))
                        string_6_ = InetAddress.getLocalHost().getHostAddress();
                } catch (final Exception exception) {
                    string_6_ = "Nonex";
                }
                int i_7_ = 0;
                if (xt.logged)
                    i_7_ = 1;
                string_4_ = string_4_ + "" + string_6_ + "|" + i_7_ +
                        "|";
            }
            if (fstart) {
                string_4_ = string_4_ + "3|";
                bool = true;
            }
            if (chalngd == -5 && !fstart) {
                string_4_ = string_4_ + "11|" + gstage + "|" +
                        gstagename + "|" + gstagelaps + "|" + gnpls + "|" +
                        gwait + "|" + pnames[im] + "|" + gcars + "|" +
                        gclass + "|" + gfix + "|" + gnotp + "|" + gplayers +
                        "|";
                if (xt.lan)
                    string_4_ = string_4_ + "" + gnbts + "|";
            }
            if (ongame != -1 && chalngd != -5 && !fstart) {
                boolean bool_8_ = false;
                for (int i_9_ = 0; i_9_ < 7; i_9_++)
                    if (!invos[i_9_].equals("") && !dinvi[i_9_].equals(invos[i_9_])) {
                        if (!bool_8_) {
                            string_4_ = string_4_ + "2|" + ongame + "|";
                            bool_8_ = true;
                        }
                        string_4_ = string_4_ + "" + invos[i_9_] + "|";
                        dinvi[i_9_] = invos[i_9_];
                    }
            }
            String string_10_ = "";
            boolean bool_11_ = false;
            try {
                dout.println(string_4_);
                string_10_ = din.readLine();
                if (string_10_ == null)
                    bool_11_ = true;
            } catch (final Exception exception) {
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
                } catch (final Exception exception) {
					/* empty */
                }
                try {
                    socket = new Socket(xt.server, xt.servport);
                    din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    dout = new PrintWriter(socket.getOutputStream(), true);
                    dout.println(string_4_);
                    string_10_ = din.readLine();
                    if (string_10_ != null)
                        bool_11_ = false;
                } catch (final Exception exception) {
					/* empty */
                }
            }
            if (bool_11_) {
                try {
                    socket.close();
                    socket = null;
                } catch (final Exception exception) {
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
                pnames[i_12_] = getSvalue(string_10_, 2 + i_12_ * 10);
                if (pnames[i_12_].equals(""))
                    pnames[i_12_] = "Unknown";
                final String string_13_ = getSvalue(string_10_, 3 + i_12_ * 10);
                if (string_13_.startsWith("C")) {
                    pcarnames[i_12_] = string_13_.substring(1);
                    if (!pcarnames[i_12_].equals("")) {
                        int i_14_ = 0;
                        for (int i_15_ = 16; i_15_ < 56; i_15_++)
                            if (pcarnames[i_12_].equals(cd.names[i_15_])) {
                                i_14_ = i_15_;
                                break;
                            }
                        if (i_14_ == 0) {
                            pcars[i_12_] = -1;
                            boolean bool_16_ = false;
                            for (int i_17_ = 0; i_17_ < cd.nl; i_17_++)
                                if (pcarnames[i_12_].equals(cd.loadnames[i_17_]))
                                    bool_16_ = true;
                            if (!bool_16_ && cd.nl < 20 && cd.nl >= 0) {
                                cd.loadnames[cd.nl] = pcarnames[i_12_];
                                cd.nl++;
                            }
                            cd.sparkcarloader();
                        } else
                            pcars[i_12_] = i_14_;
                    } else {
                        pcars[i_12_] = 0;
                        pcarnames[i_12_] = cd.names[pcars[i_12_]];
                    }
                } else {
                    pcars[i_12_] = getvalue(string_10_, 3 + i_12_ * 10);
                    if (pcars[i_12_] == -1)
                        pcars[i_12_] = 0;
                    pcarnames[i_12_] = cd.names[pcars[i_12_]];
                }
                pclan[i_12_] = getSvalue(string_10_, 4 + i_12_ * 10);
                pgames[i_12_] = getvalue(string_10_, 5 + i_12_ * 10);
                pcols[i_12_][0] = getvalue(string_10_, 6 + i_12_ * 10) / 100.0F;
                if (pcols[i_12_][0] == -1.0F)
                    pcols[i_12_][0] = 0.0F;
                pcols[i_12_][1] = getvalue(string_10_, 7 + i_12_ * 10) / 100.0F;
                if (pcols[i_12_][1] == -1.0F)
                    pcols[i_12_][1] = 0.0F;
                pcols[i_12_][2] = getvalue(string_10_, 8 + i_12_ * 10) / 100.0F;
                if (pcols[i_12_][2] == -1.0F)
                    pcols[i_12_][2] = 0.0F;
                pcols[i_12_][3] = getvalue(string_10_, 9 + i_12_ * 10) / 100.0F;
                if (pcols[i_12_][3] == -1.0F)
                    pcols[i_12_][3] = 0.0F;
                pcols[i_12_][4] = getvalue(string_10_, 10 + i_12_ * 10) / 100.0F;
                if (pcols[i_12_][4] == -1.0F)
                    pcols[i_12_][4] = 0.0F;
                pcols[i_12_][5] = getvalue(string_10_, 11 + i_12_ * 10) / 100.0F;
                if (pcols[i_12_][5] == -1.0F)
                    pcols[i_12_][5] = 0.0F;
            }
            int i_18_ = 12 + (npo - 1) * 10;
            ngm = getvalue(string_10_, i_18_);
            if (ngm < 0)
                ngm = 0;
            int i_19_ = 12;
            if (xt.lan)
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
                if (gplyrs[i_20_].startsWith("#warb#")) {
                    gwarb[i_20_] = getHvalue(gplyrs[i_20_], 2);
                    gwarbnum[i_20_] = getHSvalue(gplyrs[i_20_], 3);
                    gameturn[i_20_] = getHvalue(gplyrs[i_20_], 4);
                    gaclan[i_20_] = getHSvalue(gplyrs[i_20_], 5);
                    gvclan[i_20_] = getHSvalue(gplyrs[i_20_], 6);
                    gascore[i_20_] = getHvalue(gplyrs[i_20_], 7);
                    gvscore[i_20_] = getHvalue(gplyrs[i_20_], 8);
                    gwtyp[i_20_] = getHvalue(gplyrs[i_20_], 9);
                    if (gwtyp[i_20_] < 1 || gwtyp[i_20_] > 5)
                        gwtyp[i_20_] = 1;
                    gplyrs[i_20_] = "";
                } else {
                    gwarb[i_20_] = 0;
                    gwarbnum[i_20_] = "";
                    gameturn[i_20_] = 0;
                    gaclan[i_20_] = "";
                    gvclan[i_20_] = "";
                    gascore[i_20_] = 0;
                    gvscore[i_20_] = 0;
                    gwtyp[i_20_] = 0;
                }
                if (xt.lan)
                    mnbts[i_20_] = getvalue(string_10_, i_18_ + 13 + i_20_ * i_19_);
                if (xt.playingame > -1 && xt.playingame == gnum[i_20_] && !xt.lan)
                    ongame = gnum[i_20_];
                if (i == gnum[i_20_] && wait[i_20_] == 0 && lloaded && i != -1) {
                    for (int i_21_ = 0; i_21_ < npo; i_21_++)
                        if (pgames[i_21_] == gnum[i_20_] && pnames[i_21_].equals(xt.nickname)) {
                            im = i_21_;
                            break;
                        }
                    conon = 2;
                    gs.setCursor(new Cursor(3));
                }
            }
            for (int i_22_ = 0; i_22_ < ngm; i_22_++) {
                npls[i_22_] = 0;
                for (int i_23_ = 0; i_23_ < npo; i_23_++)
                    if (pgames[i_23_] == gnum[i_22_])
                        npls[i_22_]++;
            }
            if (conon != 0 && xt.playingame != -1)
                xt.playingame = -1;
            if (ongame != -1) {
                boolean bool_24_ = false;
                for (int i_25_ = 0; i_25_ < ngm; i_25_++)
                    if (ongame == gnum[i_25_])
                        bool_24_ = true;
                if (!bool_24_)
                    britchl = -1;
            }
            if (join > -1) {
                boolean bool_26_ = false;
                for (int i_27_ = 0; i_27_ < ngm; i_27_++)
                    if (join == gnum[i_27_])
                        bool_26_ = true;
                if (!bool_26_)
                    join = -1;
            }
            for (int i_28_ = 0; i_28_ < npo; i_28_++)
                if (pgames[i_28_] != -1) {
                    boolean bool_29_ = false;
                    for (int i_30_ = 0; i_30_ < ngm; i_30_++)
                        if (pgames[i_28_] == gnum[i_30_])
                            bool_29_ = true;
                    if (!bool_29_)
                        pgames[i_28_] = -1;
                }
            if (xt.lan)
                i_18_ += 14 + (ngm - 1) * 13;
            else
                i_18_ += 13 + (ngm - 1) * 12;
            if (!xt.lan) {
                final int i_31_ = getvalue(string_10_, i_18_);
                final int i_32_ = getvalue(string_10_, i_18_ + 1);
                i_18_ += 2;
                if (updatec != i_31_ && updatec >= -2 && i_32_ == ongame) {
                    for (int i_33_ = 0; i_33_ < 7; i_33_++) {
                        cnames[i_33_] = getSvalue(string_10_, i_18_ + i_33_ * 2);
                        sentn[i_33_] = getSvalue(string_10_, i_18_ + 1 + i_33_ * 2);
                    }
                    updatec = i_31_;
                    if (ongame == -1)
                        spos3 = 28;
                    i_18_ += 14;
                }
                if (ongame != -1) {
                    if (prevloaded != -1)
                        prevloaded = -1;
                    boolean bool_34_ = false;
                    for (int i_35_ = 0; i_35_ < ngm; i_35_++)
                        if (ongame == gnum[i_35_] && wait[i_35_] <= 0)
                            bool_34_ = true;
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
                                ppow[i_39_] = (int) (getvalue(string_10_, i_18_) / 9800.0F * 55.0F);
                                i_18_++;
                            }
                            for (int i_40_ = 0; i_40_ < prnpo; i_40_++) {
                                final int i_41_ = getvalue(string_10_, i_18_);
                                if (i_41_ != -17)
                                    pdam[i_40_] = (int) (i_41_ / 100.0F * 55.0F);
                                else
                                    pdam[i_40_] = -17;
                                i_18_++;
                            }
                            stuntname = getSvalue(string_10_, i_18_);
                            i_18_++;
                            lapsname = getSvalue(string_10_, i_18_);
                            i_18_++;
                            wastename = getSvalue(string_10_, i_18_);
                            i_18_++;
                        }
                    }
                }
            } else {
                final int i_42_ = getvalue(string_10_, i_18_);
                if (i_42_ == 1)
                    lanlogged = true;
                else
                    lanlogged = true;
                i_18_++;
            }
            final int i_43_ = getvalue(string_10_, i_18_);
            if (i_43_ != -1) {
                int i_44_ = 0;
                for (int i_45_ = 0; i_45_ < ngm; i_45_++)
                    if (i_43_ == gnum[i_45_])
                        i_44_ = i_45_;
                boolean bool_46_ = false;
                if (gwarb[i_44_] != 0) {
                    if (xt.clan.toLowerCase().equals(gaclan[i_44_].toLowerCase())
                            || xt.clan.toLowerCase().equals(gvclan[i_44_].toLowerCase()))
                        bool_46_ = true;
                } else
                    bool_46_ = true;
                if ((pgames[im] != ongame || ongame == -1) && i_43_ != ongame && chalngd == -1 && join == -1
                        && fase == 1 && wait[i_44_] > 0 && bool_46_) {
                    chalngd = i_43_;
                    chalby = getSvalue(string_10_, i_18_ + 1);
                    cflk = 20;
                    ctime = 20;
                    ptime = 0L;
                    longame = ongame;
                    if (gs.rooms.open)
                        gs.rooms.open = false;
                    if (ongame != -1)
                        britchl = -1;
                }
                i_18_++;
            }
            if (!xt.lan) {
                int i_47_ = 1;
                for (int i_48_ = 1; i_48_ < 6; i_48_++)
                    if (i_48_ != xt.servport - 7070) {
                        final int i_49_ = getvalue(string_10_, i_18_ + i_48_);
                        if (i_49_ != -1) {
                            gs.rooms.sopts[i_47_] = "Room " + i_48_ + "  ::  " +
                                    i_49_ + "";
                            gs.rooms.opts[i_47_] = "";
                            gs.rooms.iroom[i_47_] = i_48_;
                            i_47_++;
                        }
                    }
                for (int i_50_ = 0; i_50_ < lg.nservers; i_50_++)
                    if (!xt.server.equals(lg.servers[i_50_]) && xt.delays[i_50_] < 300) {
                        gs.rooms.sopts[i_47_] = ":: " + lg.snames[i_50_] + "";
                        gs.rooms.opts[i_47_] = "";
                        gs.rooms.iroom[i_47_] = 1000 + i_50_;
                        i_47_++;
                    }
                gs.rooms.no = i_47_;
            }
            if (join > -1) {
                boolean bool_51_ = false;
                for (int i_52_ = 0; i_52_ < ngm; i_52_++)
                    if (join == gnum[i_52_] && wait[i_52_] == 0)
                        bool_51_ = true;
                if (pgames[im] == join || bool_51_) {
                    join = -1;
                    nflk = 3;
                }
            }
            if (join == -2) {
                boolean bool_53_ = false;
                for (int i_54_ = 0; i_54_ < ngm; i_54_++)
                    if (pgames[im] == gnum[i_54_] && wait[i_54_] == 0)
                        bool_53_ = true;
                if (pgames[im] == -1 || bool_53_) {
                    join = -1;
                    if (!bool_53_)
                        ongame = -1;
                }
            }
            if (chalngd == -5 && pgames[im] != -1) {
                ongame = pgames[im];
                chalngd = -1;
                if (!xt.lan && gplayers.equals(""))
                    lg.gamealert();
            }
            if (fstart && bool)
                fstart = false;
            rerr = 0;
            if (!lloaded) {
                gs.setCursor(new Cursor(0));
                lloaded = true;
            }
			/*if (!gb.domon) {//CHECK
				gb.roomlogos(pnames, npo);
				if (ongame == -1) {
					if (cntchkn == 5)
						lg.checkgamealerts();
				} else if (lg.gamec != -1)
					lg.gamec = -1;
				if (cntchkn == 5) {
					lg.checknotifcations();
					cntchkn = 0;
				} else
					cntchkn++;
			} else */
            if (lg.gamec != -1)
                lg.gamec = -1;
            date = new Date();
            final long l_55_ = date.getTime();
            int i_56_ = 700 - (int) (l_55_ - l);
            if (i_56_ < 50)
                i_56_ = 50;
            try {
                if (connector != null) {
					/* empty */
                }
                Thread.sleep(i_56_);
            } catch (final InterruptedException interruptedexception) {
				/* empty */
            }
        }
        if (conon == 2) {
            int i_57_ = 20;
            xt.playingame = -1;
            while (i_57_ != 0) {
                final String string = "2|" + i + "|";
                String string_58_ = "";
                boolean bool = false;
                try {
                    dout.println(string);
                    string_58_ = din.readLine();
                    if (string_58_ == null)
                        bool = true;
                } catch (final Exception exception) {
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
                    } catch (final Exception exception) {
						/* empty */
                    }
                    try {
                        socket = new Socket(xt.server, xt.servport);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println(string);
                        string_58_ = din.readLine();
                        if (string_58_ != null)
                            bool = false;
                    } catch (final Exception exception) {
						/* empty */
                    }
                }
                if (bool) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (final Exception exception) {
						/* empty */
                    }
                    conon = 0;
                    lg.exitfromlobby();
                    hideinputs();
                    connector.stop();
                }
                if (!xt.lan)
                    xt.gameport = getvalue(string_58_, 0);
                else {
                    xt.gameport = -1;
                    xt.localserver = getSevervalue(string_58_, 0);
                    if (!xt.localserver.equals(""))
                        xt.gameport = 0;
                }
                if (xt.gameport != -1) {
                    int i_59_ = 0;
                    xt.im = -1;
                    xt.nplayers = getvalue(string_58_, 1);
                    if (xt.nplayers < 1)
                        xt.nplayers = 1;
                    if (xt.nplayers > 8)
                        xt.nplayers = 8;
                    for (int i_60_ = 0; i_60_ < xt.nplayers; i_60_++) {
                        xt.plnames[i_60_] = getSvalue(string_58_, 2 + i_60_);
                        if (xt.nickname.equals(xt.plnames[i_60_]))
                            xt.im = i_60_;
                    }
                    int i_61_ = 2 + xt.nplayers;
                    for (int i_62_ = 0; i_62_ < xt.nplayers; i_62_++) {
                        String string_63_ = getSvalue(string_58_, i_61_ + i_62_);
                        if (string_63_.startsWith("C")) {
                            string_63_ = string_63_.substring(1);
                            if (!string_63_.equals("")) {
                                int i_64_ = 0;
                                for (int i_65_ = 16; i_65_ < 56; i_65_++)
                                    if (string_63_.equals(cd.names[i_65_])) {
                                        i_64_ = i_65_;
                                        break;
                                    }
                                for (/**/ ; i_64_ == 0 && i_59_ < 100; i_59_++) {
                                    boolean bool_66_ = false;
                                    for (int i_67_ = 0; i_67_ < cd.nl; i_67_++)
                                        if (string_63_.equals(cd.loadnames[i_67_]))
                                            bool_66_ = true;
                                    if (!bool_66_ && cd.nl < 20) {
                                        cd.loadnames[cd.nl] = string_63_;
                                        cd.nl++;
                                    }
                                    cd.sparkcarloader();
                                    try {
                                        if (connector != null) {
											/* empty */
                                        }
                                        Thread.sleep(100L);
                                    } catch (final InterruptedException interruptedexception) {
										/* empty */
                                    }
                                    for (int i_68_ = 16; i_68_ < 56; i_68_++)
                                        if (string_63_.equals(cd.names[i_68_]))
                                            i_64_ = i_68_;
                                }
                                if (i_64_ != 0) {
                                    xt.sc[i_62_] = i_64_;
                                    for (int i_69_ = 0; i_69_ < npo; i_69_++)
                                        if (pcarnames[i_69_].equals(string_63_))
                                            pcars[i_69_] = i_64_;
                                } else
                                    xt.im = -1;
                            } else
                                xt.im = -1;
                        } else {
                            xt.sc[i_62_] = getvalue(string_58_, i_61_ + i_62_);
                            if (xt.sc[i_62_] == -1)
                                xt.im = -1;
                        }
                    }
                    i_61_ += xt.nplayers;
                    for (int i_70_ = 0; i_70_ < xt.nplayers; i_70_++)
                        xt.xstart[i_70_] = getvalue(string_58_, i_61_ + i_70_);
                    i_61_ += xt.nplayers;
                    for (int i_71_ = 0; i_71_ < xt.nplayers; i_71_++)
                        xt.zstart[i_71_] = getvalue(string_58_, i_61_ + i_71_);
                    i_61_ += xt.nplayers;
                    for (int i_72_ = 0; i_72_ < xt.nplayers; i_72_++)
                        for (int i_73_ = 0; i_73_ < 6; i_73_++)
                            xt.allrnp[i_72_][i_73_] = getvalue(string_58_, i_61_ + i_72_ * 6 + i_73_) / 100.0F;
                    if (xt.im != -1) {
                        xt.playingame = i;
                        int i_74_ = 0;
                        for (int i_75_ = 0; i_75_ < ngm; i_75_++)
                            if (i == gnum[i_75_])
                                i_74_ = i_75_;
                        if (gwarb[i_74_] != 0) {
                            xt.clangame = gwtyp[i_74_];
                            xt.clanchat = true;
                            xt.gaclan = gaclan[i_74_];
                            for (int i_76_ = 0; i_76_ < xt.nplayers; i_76_++)
                                for (int i_77_ = 0; i_77_ < npo; i_77_++)
                                    if (xt.plnames[i_76_].equals(pnames[i_77_]) && pgames[i_77_] == i)
                                        xt.pclan[i_76_] = pclan[i_77_];
                        } else
                            xt.clangame = 0;
                    } else {
                        xt.playingame = -1;
                        xt.im = 0;
                    }
                    i_57_ = 0;
                } else
                    i_57_--;
                try {
                    if (connector != null) {
						/* empty */
                    }
                    Thread.sleep(1000L);
                } catch (final InterruptedException interruptedexception) {
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
            } catch (final Exception exception) {
				/* empty */
            }
            if (xt.playingame != -1) {
                if (!xt.lan && !xt.logged) {
                    xt.nfreeplays++;
                    try {
                        socket = new Socket(lg.servers[0], 7061);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println("7|" + xt.nfreeplays + "|");
                        final String string = din.readLine();
                        xt.hours = getvalue(string, 0);
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
                hideinputs();
                xt.multion = 1;
                fase = 76;
                System.gc();
            } else
                inishlobby();
        }
        if (conon == 3) {
            int i_78_ = 20;
            xt.playingame = -1;
            while (i_78_ != 0) {
                final String string = "4|" + ongame + "|";
                String string_79_ = "";
                boolean bool = false;
                try {
                    dout.println(string);
                    string_79_ = din.readLine();
                    if (string_79_ == null)
                        bool = true;
                } catch (final Exception exception) {
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
                    } catch (final Exception exception) {
						/* empty */
                    }
                    try {
                        socket = new Socket(xt.server, xt.servport);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println(string);
                        string_79_ = din.readLine();
                        if (string_79_ != null)
                            bool = false;
                    } catch (final Exception exception) {
						/* empty */
                    }
                }
                if (bool) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (final Exception exception) {
						/* empty */
                    }
                    conon = 0;
                    lg.exitfromlobby();
                    hideinputs();
                    connector.stop();
                }
                if (!xt.lan)
                    xt.gameport = getvalue(string_79_, 0);
                else {
                    xt.gameport = -1;
                    xt.localserver = getSevervalue(string_79_, 0);
                    if (!xt.localserver.equals(""))
                        xt.gameport = 0;
                }
                if (xt.gameport != -1) {
                    int i_80_ = 0;
                    xt.nplayers = getvalue(string_79_, 1);
                    if (xt.nplayers < 1)
                        xt.nplayers = 1;
                    if (xt.nplayers > 8)
                        xt.nplayers = 8;
                    xt.im = getvalue(string_79_, 2) + xt.nplayers;
                    for (int i_81_ = 0; i_81_ < xt.nplayers; i_81_++)
                        xt.plnames[i_81_] = getSvalue(string_79_, 3 + i_81_);
                    int i_82_ = 3 + xt.nplayers;
                    for (int i_83_ = 0; i_83_ < xt.nplayers; i_83_++) {
                        String string_84_ = getSvalue(string_79_, i_82_ + i_83_);
                        if (string_84_.startsWith("C")) {
                            string_84_ = string_84_.substring(1);
                            if (!string_84_.equals("")) {
                                int i_85_ = 0;
                                for (int i_86_ = 16; i_86_ < 56; i_86_++)
                                    if (string_84_.equals(cd.names[i_86_])) {
                                        i_85_ = i_86_;
                                        break;
                                    }
                                for (/**/ ; i_85_ == 0 && i_80_ < 100; i_80_++) {
                                    boolean bool_87_ = false;
                                    for (int i_88_ = 0; i_88_ < cd.nl; i_88_++)
                                        if (string_84_.equals(cd.loadnames[i_88_]))
                                            bool_87_ = true;
                                    if (!bool_87_ && cd.nl < 20) {
                                        cd.loadnames[cd.nl] = string_84_;
                                        cd.nl++;
                                    }
                                    cd.sparkcarloader();
                                    try {
                                        if (connector != null) {
											/* empty */
                                        }
                                        Thread.sleep(100L);
                                    } catch (final InterruptedException interruptedexception) {
										/* empty */
                                    }
                                    for (int i_89_ = 16; i_89_ < 56; i_89_++)
                                        if (string_84_.equals(cd.names[i_89_]))
                                            i_85_ = i_89_;
                                }
                                if (i_85_ != 0) {
                                    xt.sc[i_83_] = i_85_;
                                    for (int i_90_ = 0; i_90_ < npo; i_90_++)
                                        if (pcarnames[i_90_].equals(string_84_))
                                            pcars[i_90_] = i_85_;
                                } else
                                    xt.im = -1;
                            } else
                                xt.im = -1;
                        } else {
                            xt.sc[i_83_] = getvalue(string_79_, i_82_ + i_83_);
                            if (xt.sc[i_83_] == -1)
                                xt.im = -1;
                        }
                    }
                    i_82_ += xt.nplayers;
                    for (int i_91_ = 0; i_91_ < xt.nplayers; i_91_++)
                        xt.xstart[i_91_] = getvalue(string_79_, i_82_ + i_91_);
                    i_82_ += xt.nplayers;
                    for (int i_92_ = 0; i_92_ < xt.nplayers; i_92_++)
                        xt.zstart[i_92_] = getvalue(string_79_, i_82_ + i_92_);
                    i_82_ += xt.nplayers;
                    for (int i_93_ = 0; i_93_ < xt.nplayers; i_93_++)
                        for (int i_94_ = 0; i_94_ < 6; i_94_++)
                            xt.allrnp[i_93_][i_94_] = getvalue(string_79_, i_82_ + i_93_ * 6 + i_94_) / 100.0F;
                    if (xt.im >= xt.nplayers && xt.im < xt.nplayers + 3) {
                        xt.playingame = ongame;
                        int i_95_ = 0;
                        for (int i_96_ = 0; i_96_ < ngm; i_96_++)
                            if (ongame == gnum[i_96_])
                                i_95_ = i_96_;
                        if (gwarb[i_95_] != 0) {
                            xt.clangame = gwtyp[i_95_];
                            xt.gaclan = gaclan[i_95_];
                            if (xt.clan.toLowerCase().equals(gaclan[i_95_].toLowerCase())
                                    || xt.clan.toLowerCase().equals(gvclan[i_95_].toLowerCase()))
                                xt.clanchat = true;
                            for (int i_97_ = 0; i_97_ < xt.nplayers; i_97_++)
                                for (int i_98_ = 0; i_98_ < npo; i_98_++)
                                    if (xt.plnames[i_97_].equals(pnames[i_98_]) && pgames[i_98_] == ongame)
                                        xt.pclan[i_97_] = pclan[i_98_];
                        } else
                            xt.clangame = 0;
                    } else {
                        xt.playingame = -1;
                        xt.im = 0;
                    }
                    i_78_ = 0;
                } else
                    i_78_--;
                try {
                    if (connector != null) {
						/* empty */
                    }
                    Thread.sleep(1000L);
                } catch (final InterruptedException interruptedexception) {
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
            } catch (final Exception exception) {
				/* empty */
            }
            if (xt.playingame != -1) {
                hideinputs();
                xt.multion = 3;
                fase = 76;
                System.gc();
            } else
                inishlobby();
        }
    }

    public void stageselect(final CheckPoints checkpoints, final Control control, final int i, final int i_293_,
                            final boolean bool) {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
        btn = 0;
        int i_294_ = 0;
        rd.drawImage(xt.br, 65, 25, null);
        if (britchl == -1) {
            ongame = -1;
            britchl = 0;
        }
        int i_295_ = 0;
        for (int i_296_ = 0; i_296_ < ngm; i_296_++)
            if (ongame == gnum[i_296_])
                i_295_ = i_296_;
        if (chalngd != -2 && ongame != -1) {
            rd.setColor(color2k(20, 20, 20));
            rd.fillRect(80, 0, 640, 40);
            rd.setColor(color2k(70, 70, 70));
            rd.drawLine(80, 40, 720, 40);
            rd.drawLine(80, 40, 80, 0);
            rd.drawLine(720, 40, 720, 0);
            rd.setColor(new Color(193, 106, 0));
            rd.setFont(new Font("Arial", 1, 12));
            ftm = rd.getFontMetrics();
            if (wait[i_295_] > 0) {
                if (gwarb[i_295_] == 0) {
                    if (wait[i_295_] > 30 || npls[i_295_] <= 1) {
                        String string = "";
                        if (npls[i_295_] > 1) {
                            final Date date = new Date();
                            final long l = date.getTime();
                            if (ptime == 0L || l > ptime + 1500L) {
                                if (ptime != 0L) {
                                    wait[i_295_]--;
                                    if (wait[i_295_] < 1)
                                        wait[i_295_] = 1;
                                }
                                ptime = l;
                            }
                            string = " (waiting " + wait[i_295_] +
                                    " seconds maximum)";
                            if (wait[i_295_] > 60)
                                string = " (waiting " +
                                        (int) (this.wait[i_295_] / 60.0F * 100.0F) / 100.0F +
                                        " minutes maximum)";
                        }
                        rd.drawString("Waiting for " + (mnpls[i_295_] - npls[i_295_]) +
                                " more players to join to start this game" + string + "!", 95, 15);
                        rd.setFont(new Font("Arial", 0, 12));
                        if (!gmaker[i_295_].equals("Coach Insano") && !gmaker[i_295_].equals(pnames[im])) {
                            boolean bool_297_ = false;
                            for (int i_298_ = 0; i_298_ < npo; i_298_++)
                                if (pgames[i_298_] == ongame && gmaker[i_295_].equals(pnames[i_298_]))
                                    bool_297_ = true;
                            if (bool_297_)
                                rd.drawString("" + gmaker[i_295_] +
                                                " can start this game at anytime (the game creator)...", 95,
                                        31);
                        }
                    } else {
                        final Date date = new Date();
                        final long l = date.getTime();
                        if (ptime == 0L || l > ptime + 1500L) {
                            if (ptime != 0L) {
                                wait[i_295_]--;
                                if (wait[i_295_] < 1)
                                    wait[i_295_] = 1;
                            }
                            ptime = l;
                        }
                        if (pgames[im] == ongame || nflk != 0) {
                            rd.drawString(
                                    "Game starts in " + wait[i_295_] +
                                            " seconds!",
                                    400 - ftm.stringWidth("Game starts in " +
                                            wait[i_295_] + " seconds!") / 2,
                                    23);
                            if (pgames[im] != ongame)
                                nflk--;
                        } else if (pgames[im] != ongame)
                            nflk = 3;
                    }
                } else
                    rd.drawString("Waiting for " + (mnpls[i_295_] - npls[i_295_]) +
                            " clan members to join to start this game!", 95, 23);
                if (pgames[im] != ongame) {
                    boolean bool_299_ = false;
                    if (gwarb[i_295_] == 0) {
                        if (gplyrs[i_295_].equals("") || gplyrs[i_295_].contains(pnames[im]))
                            bool_299_ = true;
                    } else if (xt.clan.toLowerCase().equals(gaclan[i_295_].toLowerCase())
                            || xt.clan.toLowerCase().equals(gvclan[i_295_].toLowerCase()))
                        bool_299_ = true;
                    if (bool_299_)
                        stringbutton(" Join Game ", 660, 23, 2);
                }
            } else {
                rd.setColor(color2k(120, 120, 120));
                if (wait[i_295_] == 0)
                    rd.drawString("Game Started", 400 - ftm.stringWidth("Game Started") / 2, 20);
                else
                    rd.drawString("Game Finished", 400 - ftm.stringWidth("Game Finished") / 2, 20);
            }
        }
        rd.setFont(new Font("Arial", 1, 11));
        xt.ftm = rd.getFontMetrics();
        ftm = rd.getFontMetrics();
        String string;
		/*if (checkpoints.stage < 0)
			string = "Custom Stage";
		if (checkpoints.stage > 0 && checkpoints.stage <= 10)
			string = new StringBuilder().append("Stage ").append(checkpoints.stage).append(" NFM 1").toString();
		if (checkpoints.stage > 10 && checkpoints.stage <= 27)
			string = new StringBuilder().append("Stage ").append(checkpoints.stage - 10).append(" NFM 2").toString();
		if (checkpoints.stage > 27)*/
        string = "Stage " + checkpoints.stage;
        xt.drawcs(85, "Previewing " + string + "  >", 255, 138, 0,
                5);
        xt.drawcs(105, "| " + checkpoints.name + " |", 255, 176, 85,
                5);
        rd.drawImage(xt.back[pback], 532, 285, null);
        if (plsndt == 0) {
            final String string_300_ = "Play Soundtrack >";
            final int i_301_ = 562 - ftm.stringWidth(string_300_) / 2;
            final int i_302_ = i_301_ + ftm.stringWidth(string_300_);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string_300_, i_301_ + 1, 326);
            rd.drawLine(i_301_ + 1, 328, i_302_ + 1, 328);
            rd.setColor(new Color(255, 138, 0));
            rd.drawString(string_300_, i_301_, 325);
            rd.drawLine(i_301_, 327, i_302_, 327);
            if (i > i_301_ && i < i_302_ && i_293_ > 314 && i_293_ < 327) {
                i_294_ = 12;
                if (bool)
                    plsndt = 1;
            }
        }
        if (plsndt == 1)
            xt.drawcs(190, "Loading Soundtrack, please wait...", 255, 138, 0, 5);
        if (checkpoints.stage < 0) {
            rd.setColor(new Color(255, 138, 0));
            rd.drawString("Created by: " + checkpoints.maker + "",
                    85, 413);
            if (checkpoints.pubt > 0) {
                if (checkpoints.pubt == 2)
                    xt.drawcs(413, "Super Public Stage", 41, 177, 255, 3);
                else
                    xt.drawcs(413, "Public Stage", 41, 177, 255, 3);
                if (addstage == 0 && xt.drawcarb(true, null, " Add to My Stages ", 334, 420, i, i_293_, bool))
                    if (xt.logged) {
                        cd.onstage = checkpoints.name;
                        cd.staction = 2;
                        cd.sparkstageaction();
                        addstage = 2;
                    } else {
                        addstage = 1;
                        waitlink = 20;
                    }
                if (addstage == 1) {
                    rd.setFont(new Font("Arial", 1, 11));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(193, 106, 0));
                    final String string_303_ = "Upgrade to a full account to add custom stages!";
                    final int i_304_ = 400 - ftm.stringWidth(string_303_) / 2;
                    final int i_305_ = i_304_ + ftm.stringWidth(string_303_);
                    rd.drawString(string_303_, i_304_, 435);
                    if (waitlink != -1)
                        rd.drawLine(i_304_, 437, i_305_, 437);
                    if (i > i_304_ && i < i_305_ && i_293_ > 424 && i_293_ < 437) {
                        if (waitlink != -1)
                            i_294_ = 12;
                        if (bool && waitlink == 0) {
                            gs.editlink(xt.nickname, true);
                            waitlink = -1;
                        }
                    }
                    if (waitlink > 0)
                        waitlink--;
                }
                if (addstage == 2) {
                    xt.drawcs(435, "Adding stage please wait...", 193, 106, 0, 3);
                    if (cd.staction == 0)
                        addstage = 3;
                    if (cd.staction == -2)
                        addstage = 4;
                    if (cd.staction == -3)
                        addstage = 5;
                    if (cd.staction == -1)
                        addstage = 6;
                }
                if (addstage == 3)
                    xt.drawcs(435, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                if (addstage == 4)
                    xt.drawcs(435, "You already have this stage!", 193, 106, 0, 3);
                if (addstage == 5)
                    xt.drawcs(435, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                if (addstage == 6)
                    xt.drawcs(435, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
            } else
                xt.drawcs(435, "Private Stage", 193, 106, 0, 3);
        }
        if (control.enter || conon == 2 || ongame == -1 && chalngd != -2) {
            m.trk = 0;
            if (xt.loadedt)
                xt.strack.unload();
            m.focus_point = 400;
            m.crs = true;
            m.x = -335;
            m.y = 0;
            m.z = -50;
            m.xz = 0;
            m.zy = 20;
            m.ground = -2000;
            fase = 1;
            control.enter = false;
        }
        if (i_294_ != pcurs) {
            gs.setCursor(new Cursor(i_294_));
            pcurs = i_294_;
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
        } catch (final Exception exception) {
			/* empty */
        }
        if (connector != null) {
            connector.stop();
            connector = null;
        }
    }

    private void stringbutton(final String string, final int i, final int i_325_, final int i_326_) {
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        bx[btn] = i;
        by[btn] = i_325_ - 5;
        bw[btn] = ftm.stringWidth(string);
        if (!pessd[btn]) {
            rd.setColor(color2k(220, 220, 220));
            rd.fillRect(i - bw[btn] / 2 - 10, i_325_ - (17 - i_326_), bw[btn] + 20, 25 - i_326_ * 2);
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ - (17 - i_326_), i + bw[btn] / 2 + 10, i_325_ - (17 - i_326_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ - (18 - i_326_), i + bw[btn] / 2 + 10, i_325_ - (18 - i_326_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_325_ - (19 - i_326_), i + bw[btn] / 2 + 9, i_325_ - (19 - i_326_));
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i + bw[btn] / 2 + 10, i_325_ - (17 - i_326_), i + bw[btn] / 2 + 10, i_325_ + 7 - i_326_);
            rd.drawLine(i + bw[btn] / 2 + 11, i_325_ - (17 - i_326_), i + bw[btn] / 2 + 11, i_325_ + 7 - i_326_);
            rd.drawLine(i + bw[btn] / 2 + 12, i_325_ - (16 - i_326_), i + bw[btn] / 2 + 12, i_325_ + 6 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ + 7 - i_326_, i + bw[btn] / 2 + 10, i_325_ + 7 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ + 8 - i_326_, i + bw[btn] / 2 + 10, i_325_ + 8 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 9, i_325_ + 9 - i_326_, i + bw[btn] / 2 + 9, i_325_ + 9 - i_326_);
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ - (17 - i_326_), i - bw[btn] / 2 - 10, i_325_ + 7 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 11, i_325_ - (17 - i_326_), i - bw[btn] / 2 - 11, i_325_ + 7 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 12, i_325_ - (16 - i_326_), i - bw[btn] / 2 - 12, i_325_ + 6 - i_326_);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2, i_325_);
        } else {
            rd.setColor(color2k(210, 210, 210));
            rd.fillRect(i - bw[btn] / 2 - 10, i_325_ - (17 - i_326_), bw[btn] + 20, 25 - i_326_ * 2);
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ - (17 - i_326_), i + bw[btn] / 2 + 10, i_325_ - (17 - i_326_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ - (18 - i_326_), i + bw[btn] / 2 + 10, i_325_ - (18 - i_326_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_325_ - (19 - i_326_), i + bw[btn] / 2 + 9, i_325_ - (19 - i_326_));
            rd.drawLine(i + bw[btn] / 2 + 10, i_325_ - (17 - i_326_), i + bw[btn] / 2 + 10, i_325_ + 7 - i_326_);
            rd.drawLine(i + bw[btn] / 2 + 11, i_325_ - (17 - i_326_), i + bw[btn] / 2 + 11, i_325_ + 7 - i_326_);
            rd.drawLine(i + bw[btn] / 2 + 12, i_325_ - (16 - i_326_), i + bw[btn] / 2 + 12, i_325_ + 6 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ + 7 - i_326_, i + bw[btn] / 2 + 10, i_325_ + 7 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ + 8 - i_326_, i + bw[btn] / 2 + 10, i_325_ + 8 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 9, i_325_ + 9 - i_326_, i + bw[btn] / 2 + 9, i_325_ + 9 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 10, i_325_ - (17 - i_326_), i - bw[btn] / 2 - 10, i_325_ + 7 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 11, i_325_ - (17 - i_326_), i - bw[btn] / 2 - 11, i_325_ + 7 - i_326_);
            rd.drawLine(i - bw[btn] / 2 - 12, i_325_ - (16 - i_326_), i - bw[btn] / 2 - 12, i_325_ + 6 - i_326_);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2 + 1, i_325_);
        }
        btn++;
    }
}