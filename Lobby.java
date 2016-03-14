/* Lobby - Decompiled by JODE Visit http://jode.sourceforge.net/ */
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
import java.util.concurrent.ThreadLocalRandom;

class Lobby implements Runnable {
    int addstage;
    private int britchl;
    private int btn;
    private final int[] bw = {
            0, 0, 0, 0, 0, 0, 0, 0
    };
    private final int[] bx = {
            0, 0, 0, 0, 0, 0, 0, 0
    };
    private final int[] by = {
            0, 0, 0, 0, 0, 0, 0, 0
    };
    private final int[] cac = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1
    };
    private final int[] cax = {
            0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    private final int[] cay = {
            0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    private final CarDefine cd;
    private int cflk;
    private String chalby = "";
    private int chalngd = -1;
    private int clicked = -1;
    private int cmonp = -1;
    private final String[] cnames = {
            "", "", "", "", "", "", ""
    };
    int cntchkn;
    private Thread connector;
    private int conon;
    private int ctime;
    private BufferedReader din;
    private final String[] dinvi = {
            "", "", "", "", "", "", "", ""
    };
    private int dispcar = -1;
    private ContO dispco;
    private PrintWriter dout;
    int fase;
    private int flks;
    private int forcar = -1;
    private boolean fstart;
    private FontMetrics ftm;
    private final String[] gaclan = new String[500];
    private final int[] gameturn = new int[500];
    private final int[] gascore = new int[500];
    /** Globe gb;. */
    private int gcars;
    private int gclass;
    private final int[] gclss = new int[500];
    private final int[] gcrs = new int[500];
    private int gfix;
    private final int[] gfx = new int[500];
    private final String[] gmaker = new String[500];
    private int gnbts;
    private final int[] gnlaps = new int[500];
    private int gnotp;
    private int gnpls = 8;
    private final int[] gntb = new int[500];
    int[] gnum = new int[500];
    private String gplayers = "";
    private final String[] gplyrs = new String[500];
    boolean grprsd;
    private final GameSparker gs;
    private int gstage;
    int gstagelaps;
    String gstagename = "";
    String[] gstages = new String[500];
    int[] gstgn = new int[500];
    private final String[] gvclan = new String[500];
    private final int[] gvscore = new int[500];
    private int gwait;
    private final int[] gwarb = new int[500];
    private final String[] gwarbnum = new String[500];
    private final int[] gwtyp = new int[500];
    private int im;
    private boolean invo;
    private final String[] invos = {
            "", "", "", "", "", "", "", ""
    };
    private boolean inwab;
    private boolean jflexo;
    private int join = -1;
    private boolean lanlogged = true;
    int laps = 3;
    private String lapsname = "";
    private final Login lg;
    private boolean lloaded;
    private String lmsg = "| Searching/Waiting for other LAN Players |";
    int loadstage;
    boolean loadwarb;
    private int longame = -1;
    private int lspos;
    private int lspos2;
    int lspos3;
    private int lxm;
    private int lym;
    private final Medium m;
    private final int[] mnbts = new int[500];
    private final int[] mnpls = new int[500];
    private boolean mousedout;
    private int mousonp = -1;
    private int mrot;
    private int mscro = 125;
    private int mscro2 = 145;
    int mscro3 = 345;
    private String msg = "";
    int msload;
    private int ncnt;
    int nfix;
    private int nflk;
    int ngm;
    boolean notb;
    private final int[] npls = new int[500];
    private int npo;
    private ImageObserver ob;
    int ongame = -1;
    private int onjoin = -1;
    private int ontyp;
    private int opengame;
    private int opselect;
    private int pback;
    private int pbtn;
    private final String[] pcarnames = new String[200];
    private final int[] pcars = new int[200];
    private final String[] pclan = new String[200];
    private final float[][] pcols = new float[200][6];
    private int pcurs;
    private final int[] pdam = {
            50, 50, 50, 50, 50, 50, 50, 50
    };
    private int pend;
    private boolean pendb;
    private final boolean[] pessd = {
            false, false, false, false, false, false, false, false
    };
    private final int[] pgames = new int[200];
    int pgamesel;
    private final int[] plap = {
            6, 6, 6, 6, 6, 6, 6, 6
    };
    int plsndt;
    private final String[] pnames = new String[200];
    private final int[] ppos = {
            6, 6, 6, 6, 6, 6, 6, 6
    };
    private final int[] ppow = {
            50, 50, 50, 50, 50, 50, 50, 50
    };
    private boolean pre1;
    private boolean pre2;
    int prereq;
    private int prevloaded = -1;
    private final String[] prnames = {
            "", "", "", "", "", "", "", ""
    };
    private int prnpo;
    private long ptime;
    private final Graphics2D rd;
    private boolean regnow;
    private int remstage;
    private int rerr;
    private final String[] sentn = {
            "", "", "", "", "", "", ""
    };
    private int sflk;
    private Socket socket;
    private int spos;
    private int spos2;
    int stage;
    String stagename = "";
    private String stuntname = "";
    private int updatec = -1;
    private final int[] wait = new int[500];
    private int waitlink;
    int warbsel;
    private String wastename = "";
    private final xtGraphics xt;
    boolean zeromsw;

    Lobby(final Medium medium, final Graphics2D graphics2d, final Login login/* , final Globe globe */, final xtGraphics xtgraphics, final CarDefine cardefine, final GameSparker gamesparker) {
        m = medium;
        rd = graphics2d;
        xt = xtgraphics;
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

    private Color color2k(final int i, final int i327, final int i328) {
        final Color color = new Color(i, i327, i328);
        final float[] fs = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
        fs[0] = 0.13F;
        fs[1] = 0.35F;
        return Color.getHSBColor(fs[0], fs[1], fs[2]);
    }

    void ctachm(final int xm, final int ym, final int i307, final Control control) {
        int i308 = -1;
        if (fase == 1 || fase == 4) {
            for (int i309 = 0; i309 < btn; i309++) {
                pessd[i309] = Math.abs(xm - bx[i309]) < bw[i309] / 2 + 12 && Math.abs(ym - by[i309]) < 14 && (i307 == 1 || i307 == 11);
                if (Math.abs(xm - bx[i309]) < bw[i309] / 2 + 12 && Math.abs(ym - by[i309]) < 14 && i307 <= -1) {
                    i308 = i309;
                    gs.mouses = 0;
                }
            }
        }
        if (conon == 1) {
            if (!regnow) {
                if (onjoin == -1) {
                    if (fase == 4) {
                        if (xm > 532 && xm < 592 && ym > 285 && ym < 306 && (i307 == 1 || i307 == 11)) {
                            pback = 1;
                        } else {
                            pback = 0;
                        }
                        if (xm > 532 && xm < 592 && ym > 285 && ym < 306 && i307 <= -1) {
                            gs.mouses = 0;
                            m.trk = 0;
                            if (xt.loadedt) {
                                xt.strack.unload();
                            }
                            m.focusPoint = 400;
                            m.crs = true;
                            m.x = -335;
                            m.y = 0;
                            m.z = -50;
                            m.xz = 0;
                            m.zy = 20;
                            m.ground = -2000;
                            fase = 1;
                        }
                        if (i308 == 0 && chalngd == -1) {
                            i308 = -1;
                            join = ongame;
                            msg = "| Joining Game |";
                            spos = 0;
                            m.trk = 0;
                            if (xt.loadedt) {
                                xt.strack.unload();
                            }
                            m.focusPoint = 400;
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
                    if (fase == 1) {
                        if (ongame == -1) {
                            if (i308 == 0) {
                                if (chalngd == -1) {
                                    if (xt.lan && !lanlogged) {
                                        gs.reglink();
                                    } else {
                                        boolean bool = false;
                                        for (int i310 = 0; i310 < ngm; i310++) {
                                            if (wait[i310] == 0) {
                                                bool = true;
                                                break;
                                            }
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
                                        } else {
                                            chalngd = -6;
                                        }
                                    }
                                } else if (chalngd != -5) {
                                    if (invo) {
                                        invo = false;
                                    }
                                    for (int i311 = 0; i311 < 7; i311++) {
                                        if (!"".equals(invos[i311])) {
                                            invos[i311] = "";
                                        }
                                        if (!"".equals(dinvi[i311])) {
                                            dinvi[i311] = "";
                                        }
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
                            }
                            if (i308 == 1) {
                                xt.fase = 23;
                            }
                            if (i308 == 2) {
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
                                }
                                hideinputs();
                            }
                            int i312 = 3;
                            if (chalngd > -1) {
                                if (i308 == 3) {
                                    ongame = chalngd;
                                    chalngd = -1;
                                }
                                if (i308 == 4) {
                                    ongame = chalngd;
                                    join = chalngd;
                                    msg = "| Joining Game |";
                                    chalngd = -1;
                                    longame = -1;
                                }
                                if (i308 == 5) {
                                    ongame = longame;
                                    chalngd = -1;
                                    longame = -1;
                                }
                                i312 = 6;
                            } else {
                                if (chalngd != -1 && chalngd != -5 && i308 == 3) {
                                    if (invo) {
                                        invo = false;
                                    }
                                    for (int i313 = 0; i313 < 7; i313++) {
                                        if (!"".equals(invos[i313])) {
                                            invos[i313] = "";
                                        }
                                        if (!"".equals(dinvi[i313])) {
                                            dinvi[i313] = "";
                                        }
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
                                if (chalngd == -6 && i308 == 4) {
                                    chalngd = -1;
                                }
                                if (chalngd == -2) {
                                    if (gs.wgame.getSelectedIndex() == 0) /*if (gs.sgame.getSelectedIndex() >= 3 && !xt.logged) {
                                                                          if (i308 == 4)
                                                                          gs.editlink(xt.nickname, true);
                                                                          i312 = 5;
                                                                          } else */ {
                                        if (i308 == 4) {
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
                                            } else {
                                                sflk = 25;
                                            }
                                        }
                                        if (loadstage >= 0) {
                                            i312 = 5;
                                        } else {
                                            if (i308 == 5) {
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
                                                    i308 = -1;
                                                } else {
                                                    sflk = 25;
                                                }
                                            }
                                            i312 = 6;
                                        }
                                    } else if (!"".equals(xt.clan) && gs.warb.sel != 0/* && gb.loadwbgames == 2 */ && gs.wgame.getSelectedIndex() == 2 && gs.pgame.sel != 0 && i308 == 4) {
                                        if (invo) {
                                            invo = false;
                                        }
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
                                    //if (gs.wgame.getSelectedIndex() == 1 && gb.canredo && i308 == i314)
                                    //	gb.loadwbgames = 7;
                                }
                                if (chalngd == -3) {
                                    if (i308 == 4) {
                                        chalngd = -2;
                                        gs.snpls.setVisible(false);
                                        gs.snbts.setVisible(false);
                                        gs.swait.setVisible(false);
                                        gs.requestFocus();
                                    }
                                    if (i308 == 5) {
                                        if (gnpls != 0 && gs.snpls.getSelectedIndex() != 0) {
                                            chalngd = -4;
                                            for (int i315 = 0; i315 < 7; i315++) {
                                                if (!"".equals(invos[i315])) {
                                                    invos[i315] = "";
                                                }
                                                if (!"".equals(dinvi[i315])) {
                                                    dinvi[i315] = "";
                                                }
                                            }
                                            i308 = -1;
                                            gs.snpls.setVisible(false);
                                            gs.snbts.setVisible(false);
                                            gs.swait.setVisible(false);
                                            gs.requestFocus();
                                        } else {
                                            sflk = 25;
                                        }
                                    }
                                    i312 = 6;
                                }
                                if (chalngd == -4) {
                                    i312 = 7;
                                    int i316 = 0;
                                    for (int i317 = 0; i317 < 7; i317++) {
                                        if (!"".equals(invos[i317])) {
                                            i316++;
                                        }
                                    }
                                    if (i316 < gnpls - 1) {
                                        if (i308 == 4) {
                                            invo = !invo;
                                        }
                                    } else {
                                        i312 = 6;
                                    }
                                    if (i308 == i312 - 2) {
                                        if (invo) {
                                            invo = false;
                                        }
                                        if (gs.mycar.getState() && xt.sc[0] < 16) {
                                            gclass = -(xt.sc[0] + 2);
                                            gcars = 0;
                                        }
                                        if (gs.notp.getState()) {
                                            gnotp = 1;
                                        } else {
                                            gnotp = 0;
                                        }
                                        gplayers = "";
                                        gs.sclass.setVisible(false);
                                        gs.scars.setVisible(false);
                                        gs.sfix.setVisible(false);
                                        gs.mycar.setVisible(false);
                                        gs.notp.setVisible(false);
                                        gs.requestFocus();
                                        chalngd = -3;
                                    }
                                    if (i308 == i312 - 1) {
                                        if (invo) {
                                            invo = false;
                                        }
                                        msg = "| Creating Game |";
                                        if (gs.mycar.getState() && xt.sc[0] < 16) {
                                            gclass = -(xt.sc[0] + 2);
                                            gcars = 0;
                                        }
                                        if (gclass != 0) {
                                            gwait = 120;
                                        }
                                        if (gs.notp.getState()) {
                                            gnotp = 1;
                                        } else {
                                            gnotp = 0;
                                        }
                                        gplayers = "";
                                        if (i316 != 0) {
                                            gnpls = i316 + 1;
                                            gplayers = pnames[im] + "#";
                                            for (int i318 = 0; i318 < i316; i318++) {
                                                final StringBuilder stringbuilder = new StringBuilder();
                                                final Lobby lobby319 = this;
                                                lobby319.gplayers = stringbuilder + lobby319.gplayers + invos[i318] + "#";
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
                            if (i308 == i312 && !xt.lan && !"Type here...".equals(gs.cmsg.getText()) && !"".equals(gs.cmsg.getText())) {
                                String string = gs.cmsg.getText().replace('|', ':');
                                if (string.toLowerCase().contains(gs.tpass.getText().toLowerCase())) {
                                    string = " ";
                                }
                                if (!xt.msgcheck(string) && updatec > -12) {
                                    for (int i320 = 0; i320 < 6; i320++) {
                                        sentn[i320] = sentn[i320 + 1];
                                        cnames[i320] = cnames[i320 + 1];
                                    }
                                    sentn[6] = string;
                                    cnames[6] = pnames[im];
                                    if (updatec > -11) {
                                        updatec = -11;
                                    } else {
                                        updatec--;
                                    }
                                } else {
                                    xt.warning++;
                                }
                                gs.cmsg.setText("");
                            }
                        } else if (dispcar == -1) {
                            int i321 = 0;
                            for (int i322 = 0; i322 < ngm; i322++) {
                                if (ongame == gnum[i322]) {
                                    i321 = i322;
                                }
                            }
                            boolean bool = false;
                            if (gwarb[i321] == 0) {
                                if (!"".equals(gplyrs[i321]) && !gplyrs[i321].contains(pnames[im])) {
                                    bool = true;
                                }
                            } else if (!xt.clan.equalsIgnoreCase(gaclan[i321]) && !xt.clan.equalsIgnoreCase(gvclan[i321])) {
                                bool = true;
                            }
                            if (control.enter && wait[i321] > 0 && pgames[im] == -1 && !bool) {
                                join = ongame;
                                msg = "| Joining Game |";
                                spos = 0;
                                if (pbtn == 0) {
                                    pessd[1] = true;
                                }
                            }
                            if (wait[i321] == -1 && pgames[im] == -1 && control.enter) {
                                i308 = 0;
                                pessd[0] = true;
                            }
                            if (pgames[im] == -1 && control.exit) {
                                i308 = 0;
                                pessd[0] = true;
                            }
                            if (i308 == 0) {
                                if (pgames[im] == -1) {
                                    ongame = -1;
                                    chalngd = -1;
                                } else {
                                    join = -2;
                                    msg = "| Leaving Game |";
                                    longame = -1;
                                }
                            }
                            if (pbtn == 0) {
                                if (i308 == 1) {
                                    if (wait[i321] > 0) {
                                        if (pgames[im] == -1) {
                                            join = ongame;
                                            msg = "| Joining Game |";
                                            spos = 0;
                                        } else if (gmaker[i321].equals(pnames[im]) && npls[i321] > 1) {
                                            fstart = true;
                                        } else {
                                            i308 = 2;
                                        }
                                    } else {
                                        if (wait[i321] == 0 && prevloaded == 1) {
                                            laps = gnlaps[i321];
                                            stage = gstgn[i321];
                                            stagename = gstages[i321];
                                            nfix = gfx[i321];
                                            notb = gntb[i321] == 1;
                                            gs.setCursor(new Cursor(3));
                                            conon = 3;
                                        } else {
                                            i308 = 2;
                                        }
                                        if (wait[i321] == 0 && xt.lan) {
                                            laps = gnlaps[i321];
                                            stage = gstgn[i321];
                                            stagename = gstages[i321];
                                            nfix = gfx[i321];
                                            notb = gntb[i321] == 1;
                                            gs.setCursor(new Cursor(3));
                                            conon = 3;
                                        }
                                    }
                                }
                                if (i308 == 2 && !xt.lan && !"Type here...".equals(gs.cmsg.getText()) && !"".equals(gs.cmsg.getText())) {
                                    String string = gs.cmsg.getText().replace('|', ':');
                                    if (string.toLowerCase().contains(gs.tpass.getText().toLowerCase())) {
                                        string = " ";
                                    }
                                    if (!xt.msgcheck(string) && updatec > -12) {
                                        for (int i323 = 0; i323 < 6; i323++) {
                                            sentn[i323] = sentn[i323 + 1];
                                            cnames[i323] = cnames[i323 + 1];
                                        }
                                        sentn[6] = string;
                                        cnames[6] = pnames[im];
                                        if (updatec > -11) {
                                            updatec = -11;
                                        } else {
                                            updatec--;
                                        }
                                    } else {
                                        xt.warning++;
                                    }
                                    gs.cmsg.setText("");
                                }
                            }
                            if (pbtn == 1 && i308 == 1) {
                                if (pgames[im] == -1) {
                                    join = ongame;
                                    msg = "| Joining Game |";
                                    spos = 0;
                                } else {
                                    invo = !invo;
                                }
                            }
                            if (pbtn == 2 && (i308 == 1 || i308 == 2)) {
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
                            if (i308 == 0) {
                                if (pgames[im] == -1) {
                                    ongame = -1;
                                    chalngd = -1;
                                } else {
                                    join = -2;
                                    msg = "| Leaving Game |";
                                    longame = -1;
                                }
                            }
                            if (pbtn == 1 && i308 == 1) {
                                if (pgames[im] == -1) {
                                    join = ongame;
                                    msg = "| Joining Game |";
                                    spos = 0;
                                } else {
                                    invo = !invo;
                                }
                            }
                        }
                    }
                } else if (ontyp != 76) {
                    if (i308 == 0) {
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
                    }
                    if (i308 == 1) {
                        onjoin = -1;
                    }
                } else {
                    if (i308 == 0) {
                        gs.editlink(xt.nickname, true);
                        onjoin = -1;
                    }
                    if (i308 == 1) {
                        onjoin = -1;
                    }
                }
            } else {
                if (i308 == 0) {
                    gs.editlink(xt.nickname, true);
                }
                if (i308 == 1) {
                    regnow = false;
                }
            }
        }
        lxm = xm;
        lym = ym;
        control.enter = false;
        control.exit = false;
    }

    private void drawSbutton(final Image image, final int i, final int i324) {
        bx[btn] = i;
        by[btn] = i324;
        bw[btn] = image.getWidth(ob);
        if (!pessd[btn]) {
            rd.drawImage(image, i - bw[btn] / 2, i324 - image.getHeight(ob) / 2 - 1, null);
            rd.drawImage(xt.bols, i - bw[btn] / 2 - 15, i324 - 13, null);
            rd.drawImage(xt.bors, i + bw[btn] / 2 + 9, i324 - 13, null);
            rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i324 - 13, bw[btn] + 18, 3, null);
            rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i324 + 10, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i324 - image.getHeight(ob) / 2, null);
            rd.drawImage(xt.bolps, i - bw[btn] / 2 - 15, i324 - 13, null);
            rd.drawImage(xt.borps, i + bw[btn] / 2 + 9, i324 - 13, null);
            rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i324 - 13, bw[btn] + 18, 3, null);
            rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i324 + 10, bw[btn] + 18, 3, null);
        }
        btn++;
    }

    private String getHSvalue(final String string, final int i) {
        String string347 = "";
        try {
            int i348 = 0;
            int i349 = 0;
            int i350 = 0;
            String string351 = "";
            String string352 = "";
            for (; i348 < string.length() && i350 != 2; i348++) {
                string351 = "" + string.charAt(i348);
                if ("#".equals(string351)) {
                    i349++;
                    if (i350 == 1 || i349 > i) {
                        i350 = 2;
                    }
                } else if (i349 == i) {
                    string352 = string352 + string351;
                    i350 = 1;
                }
            }
            string347 = string352;
        } catch (final Exception exception) {
        }
        return string347;
    }

    private int getHvalue(final String string, final int i) {
        int i341 = -1;
        try {
            int i342 = 0;
            int i343 = 0;
            int i344 = 0;
            String string345 = "";
            String string346 = "";
            for (; i342 < string.length() && i344 != 2; i342++) {
                string345 = "" + string.charAt(i342);
                if ("#".equals(string345)) {
                    i343++;
                    if (i344 == 1 || i343 > i) {
                        i344 = 2;
                    }
                } else if (i343 == i) {
                    string346 = string346 + string345;
                    i344 = 1;
                }
            }
            if ("".equals(string346)) {
                string346 = "-1";
            }
            i341 = Integer.parseInt(string346);
        } catch (final Exception exception) {
        }
        return i341;
    }

    private String getSevervalue(final String string, final int i) {
        String string353 = "";
        if (!"".equals(string)) {
            try {
                int i354 = 0;
                int i355 = 0;
                int i356 = 0;
                String string357 = "";
                String string358 = "";
                for (; i354 < string.length() && i356 != 2; i354++) {
                    string357 = "" + string.charAt(i354);
                    if ("|".equals(string357)) {
                        i355++;
                        if (i356 == 1 || i355 > i) {
                            i356 = 2;
                        }
                    } else if (i355 == i) {
                        string358 = string358 + string357;
                        i356 = 1;
                    }
                }
                string353 = string358;
            } catch (final Exception exception) {
                string353 = "";
            }
        }
        return string353;
    }

    private String getSvalue(final String string, final int i) {
        String string335 = "";
        try {
            int i336 = 0;
            int i337 = 0;
            int i338 = 0;
            String string339 = "";
            String string340 = "";
            for (; i336 < string.length() && i338 != 2; i336++) {
                string339 = "" + string.charAt(i336);
                if ("|".equals(string339)) {
                    i337++;
                    if (i338 == 1 || i337 > i) {
                        i338 = 2;
                    }
                } else if (i337 == i) {
                    string340 = string340 + string339;
                    i338 = 1;
                }
            }
            string335 = string340;
        } catch (final Exception exception) {
        }
        return string335;
    }

    private int getvalue(final String string, final int i) {
        int i329 = -1;
        try {
            int i330 = 0;
            int i331 = 0;
            int i332 = 0;
            String string333 = "";
            String string334 = "";
            for (; i330 < string.length() && i332 != 2; i330++) {
                string333 = "" + string.charAt(i330);
                if ("|".equals(string333)) {
                    i331++;
                    if (i332 == 1 || i331 > i) {
                        i332 = 2;
                    }
                } else if (i331 == i) {
                    string334 = string334 + string333;
                    i332 = 1;
                }
            }
            if ("".equals(string334)) {
                string334 = "-1";
            }
            i329 = Integer.parseInt(string334);
        } catch (final Exception exception) {
        }
        return i329;
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

    void inishlobby() {
        gs.tnick.setVisible(false);
        gs.tpass.setVisible(false);
        gs.temail.setVisible(false);
        hideinputs();
        gs.mycar.setBackground(color2k(255, 255, 255));
        gs.mycar.setForeground(new Color(0, 0, 0));
        gs.rooms.removeAll();
        gs.rooms.add(rd, xt.servername + " :: " + (xt.servport - 7070));
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
            for (int i0 = 0; i0 < 6; i0++) {
                pcols[i][i0] = 0.0F;
            }
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
        }
        conon = 1;
        connector = new Thread(this);
        connector.start();
    }

    void lobby(int i, int i99, boolean bool, final int i100, final CheckPoints checkpoints, final Control control, final ContO[] contos) {
        pre1 = false;
        pre2 = false;
        int i101 = 0;
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
                    int i102 = npo;
                    if (invo) {
                        i102 = 0;
                        for (int i103 = 0; i103 < npo; i103++) {
                            if (pgames[i103] == -1) {
                                i102++;
                            }
                        }
                        i102 += 2;
                    }
                    int i104 = (i102 - 11) * 30;
                    if (i104 < 0) {
                        i104 = 0;
                    }
                    int i105 = (int) (spos / 295.0F * i104);
                    int i106 = 0;
                    int i107 = -1;
                    int i108 = -1;
                    if (conon == 1) {
                        if (!invo) {
                            for (int i109 = 0; i109 < npo; i109++) {
                                if (pgames[i109] != -1) {
                                    int i110 = 0;
                                    for (int i111 = 0; i111 < ngm; i111++) {
                                        if (pgames[i109] == gnum[i111]) {
                                            i110 = i111;
                                        }
                                    }
                                    if (wait[i110] > 0) {
                                        if (82 + 30 * i106 - i105 > 50 && 82 + 30 * (i106 - 1) - i105 < 415) {
                                            boolean bool112 = false;
                                            if (i > 70 && i < 185 && i99 > 52 + 30 * i106 - i105 && i99 < 82 + 30 * i106 - i105) {
                                                if (pgames[im] == -1 && join == -1 && chalngd >= -1) {
                                                    if (bool || mousonp == i109) {
                                                        rd.setColor(color2k(255, 255, 255));
                                                        mousonp = i109;
                                                        i108 = 52 + 30 * i106 - i105;
                                                        if (bool) {
                                                            if (cmonp == i109) {
                                                                ongame = pgames[i109];
                                                            }
                                                            chalngd = -1;
                                                        } else {
                                                            if (cmonp == -1) {
                                                                ongame = -1;
                                                                cmonp = i109;
                                                            }
                                                            if (ongame == pgames[i109]) {
                                                                mousonp = -1;
                                                            }
                                                        }
                                                    } else {
                                                        rd.setColor(color2k(220, 220, 220));
                                                    }
                                                    rd.fillRect(70, 53 + 30 * i106 - i105, 116, 29);
                                                    i107 = i109;
                                                }
                                                bool112 = true;
                                                if (control.handb) {
                                                    gs.cmsg.setText(gs.cmsg.getText() + pnames[i109]);
                                                    control.handb = false;
                                                }
                                            }
                                            if (pgames[im] == -1 && join == -1 && chalngd >= -1) {
                                                rd.setColor(new Color(49, 79, 0));
                                            } else {
                                                rd.setColor(new Color(34, 55, 0));
                                            }
                                            //final boolean bool113 = gb.drawl(rd, pnames[i109], 68,
                                            //		53 + 30 * i106 - i105, bool112);
                                            //if (/*!bool112 /*|| !bool113*/) { //CHECK
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(pnames[i109], 127 - ftm.stringWidth(pnames[i109]) / 2, 66 + 30 * i106 - i105);
                                            rd.setFont(new Font("Arial", 0, 10));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(pcarnames[i109], 127 - ftm.stringWidth(pcarnames[i109]) / 2, 78 + 30 * i106 - i105);
                                            //}
                                            rd.setColor(color2k(150, 150, 150));
                                            rd.drawLine(70, 82 + 30 * i106 - i105, 185, 82 + 30 * i106 - i105);
                                        }
                                        i106++;
                                    }
                                }
                            }
                        }
                        int i114 = -1;
                        if (invo) {
                            for (int i115 = 0; i115 < ngm; i115++) {
                                if (gwarb[i115] != 0 && pgames[im] == gnum[i115]) {
                                    i114 = i115;
                                }
                            }
                            rd.setColor(new Color(0, 0, 0));
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            if (i114 == -1) {
                                rd.drawString("Free Players", 127 - ftm.stringWidth("Free Players") / 2, 75 - i105);
                            } else {
                                rd.drawString("Members of Clans", 127 - ftm.stringWidth("Members of Clans") / 2, 75 - i105);
                            }
                            rd.setFont(new Font("Arial", 0, 10));
                            ftm = rd.getFontMetrics();
                            rd.drawString("Click a player to invite:", 127 - ftm.stringWidth("Click a player to invite:") / 2, 92 - i105);
                            rd.setColor(color2k(150, 150, 150));
                            rd.drawLine(70, 112 - i105, 185, 112 - i105);
                            i106 += 2;
                        }
                        for (int i116 = 0; i116 < npo; i116++) {
                            boolean bool117 = false;
                            if (invo) {
                                if (im == i116) {
                                    bool117 = true;
                                }
                                for (int i118 = 0; i118 < 7; i118++) {
                                    if (invos[i118].equals(pnames[i116]) && !bool117) {
                                        bool117 = true;
                                    }
                                }
                                if (i114 != -1 && !pclan[i116].equalsIgnoreCase(gaclan[i114]) && !pclan[i116].equalsIgnoreCase(gvclan[i114])) {
                                    bool117 = true;
                                }
                            }
                            if (pgames[i116] == -1 && !bool117) {
                                if (82 + 30 * i106 - i105 > 50 && 82 + 30 * (i106 - 1) - i105 < 415) {
                                    boolean bool119 = false;
                                    if (i > 70 && i < 185 && i99 > 52 + 30 * i106 - i105 && i99 < 82 + 30 * i106 - i105) {
                                        if (invo) {
                                            if (bool) {
                                                rd.setColor(color2k(255, 255, 255));
                                                mousonp = i116;
                                            } else {
                                                rd.setColor(color2k(220, 220, 220));
                                                if (mousonp == i116) {
                                                    int i120 = 0;
                                                    for (boolean bool121 = false; i120 < 7 && !bool121; i120++) {
                                                        if ("".equals(invos[i120])) {
                                                            invos[i120] = pnames[i116];
                                                            bool121 = true;
                                                        }
                                                    }
                                                    mousonp = -1;
                                                    invo = false;
                                                }
                                            }
                                            rd.fillRect(70, 53 + 30 * i106 - i105, 116, 29);
                                            i107 = i116;
                                        }
                                        bool119 = true;
                                        if (control.handb) {
                                            gs.cmsg.setText(gs.cmsg.getText() + pnames[i116]);
                                            control.handb = false;
                                        }
                                    }
                                    if (invo) {
                                        rd.setColor(new Color(62, 98, 0));
                                    } else {
                                        rd.setColor(new Color(0, 0, 0));
                                    }
                                    //final boolean bool122 = gb.drawl(rd, pnames[i116], 68,
                                    //		53 + 30 * i106 - i105, bool119);
                                    //if (!bool119/* || !bool122*/) {//CHECK
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pnames[i116], 127 - ftm.stringWidth(pnames[i116]) / 2, 66 + 30 * i106 - i105);
                                    rd.setFont(new Font("Arial", 0, 10));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pcarnames[i116], 127 - ftm.stringWidth(pcarnames[i116]) / 2, 78 + 30 * i106 - i105);
                                    //}
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(70, 82 + 30 * i106 - i105, 185, 82 + 30 * i106 - i105);
                                }
                                i106++;
                            }
                        }
                        if (invo && i106 == 2) {
                            invo = false;
                        }
                        if (!invo) {
                            for (int i123 = npo - 1; i123 >= 0; i123--) {
                                if (pgames[i123] != -1) {
                                    int i124 = 0;
                                    for (int i125 = 0; i125 < ngm; i125++) {
                                        if (pgames[i123] == gnum[i125]) {
                                            i124 = i125;
                                        }
                                    }
                                    if (wait[i124] <= 0) {
                                        boolean bool126 = false;
                                        for (int i127 = 0; i127 < npo; i127++) {
                                            if (i123 != i127 && pnames[i123].equals(pnames[i127])) {
                                                if (pgames[i127] == -1) {
                                                    bool126 = true;
                                                } else {
                                                    for (int i128 = 0; i128 < ngm; i128++) {
                                                        if (pgames[i127] == gnum[i128] && wait[i128] > 0) {
                                                            bool126 = true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (!bool126) {
                                            if (82 + 30 * i106 - i105 > 50 && 82 + 30 * (i106 - 1) - i105 < 415) {
                                                boolean bool129 = false;
                                                if (i > 70 && i < 185 && i99 > 52 + 30 * i106 - i105 && i99 < 82 + 30 * i106 - i105) {
                                                    if (pgames[im] == -1 && join == -1 && chalngd >= -1) {
                                                        if (bool || mousonp == i123) {
                                                            rd.setColor(color2k(255, 255, 255));
                                                            mousonp = i123;
                                                            i108 = 52 + 30 * i106 - i105;
                                                            if (bool) {
                                                                if (cmonp == i123) {
                                                                    ongame = pgames[i123];
                                                                }
                                                                chalngd = -1;
                                                            } else {
                                                                if (cmonp == -1) {
                                                                    ongame = -1;
                                                                    cmonp = i123;
                                                                }
                                                                if (ongame == pgames[i123]) {
                                                                    mousonp = -1;
                                                                }
                                                            }
                                                        } else {
                                                            rd.setColor(color2k(220, 220, 220));
                                                        }
                                                        rd.fillRect(70, 53 + 30 * i106 - i105, 116, 29);
                                                        i107 = i123;
                                                    }
                                                    bool129 = true;
                                                    if (control.handb) {
                                                        gs.cmsg.setText(gs.cmsg.getText() + pnames[i123]);
                                                        control.handb = false;
                                                    }
                                                }
                                                if (pgames[im] == -1 && join == -1 && chalngd >= -1) {
                                                    if (wait[i124] == 0) {
                                                        rd.setColor(new Color(117, 67, 0));
                                                    } else {
                                                        rd.setColor(color2k(0, 28, 102));
                                                    }
                                                } else if (wait[i124] == 0) {
                                                    rd.setColor(new Color(82, 47, 0));
                                                } else {
                                                    rd.setColor(color2k(0, 20, 71));
                                                }
                                                //final boolean bool130 = gb.drawl(rd, pnames[i123], 68,
                                                //		53 + 30 * i106 - i105, bool129);
                                                //if (!bool129/* || !bool130*/) {//CHECK
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString(pnames[i123], 127 - ftm.stringWidth(pnames[i123]) / 2, 66 + 30 * i106 - i105);
                                                rd.setFont(new Font("Arial", 0, 10));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString(pcarnames[i123], 127 - ftm.stringWidth(pcarnames[i123]) / 2, 78 + 30 * i106 - i105);
                                                //}
                                                rd.setColor(color2k(150, 150, 150));
                                                rd.drawLine(70, 82 + 30 * i106 - i105, 185, 82 + 30 * i106 - i105);
                                            }
                                            i106++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (mousonp != i107) {
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
                    if (mscro == 131 || i104 == 0) {
                        if (i104 == 0) {
                            rd.setColor(color2k(205, 205, 205));
                        } else {
                            rd.setColor(color2k(215, 215, 215));
                        }
                        rd.fillRect(193, 53, 17, 17);
                    } else {
                        rd.setColor(color2k(220, 220, 220));
                        rd.fill3DRect(193, 53, 17, 17, true);
                    }
                    if (i104 != 0) {
                        rd.drawImage(xt.asu, 198, 59, null);
                    }
                    if (mscro == 132 || i104 == 0) {
                        if (i104 == 0) {
                            rd.setColor(color2k(205, 205, 205));
                        } else {
                            rd.setColor(color2k(215, 215, 215));
                        }
                        rd.fillRect(193, 396, 17, 17);
                    } else {
                        rd.setColor(color2k(220, 220, 220));
                        rd.fill3DRect(193, 396, 17, 17, true);
                    }
                    if (i104 != 0) {
                        rd.drawImage(xt.asd, 198, 403, null);
                    }
                    if (i104 != 0 && conon == 1) {
                        if (lspos != spos) {
                            rd.setColor(color2k(215, 215, 215));
                            rd.fillRect(193, 70 + spos, 17, 31);
                        } else {
                            if (mscro == 131) {
                                rd.setColor(color2k(215, 215, 215));
                            }
                            rd.fill3DRect(193, 70 + spos, 17, 31, true);
                        }
                        rd.setColor(color2k(150, 150, 150));
                        rd.drawLine(198, 83 + spos, 204, 83 + spos);
                        rd.drawLine(198, 85 + spos, 204, 85 + spos);
                        rd.drawLine(198, 87 + spos, 204, 87 + spos);
                        if (mscro > 101 && lspos != spos) {
                            lspos = spos;
                        }
                        if (bool) {
                            if (mscro == 125 && i > 193 && i < 210 && i99 > 70 + spos && i99 < spos + 101) {
                                mscro = i99 - spos;
                            }
                            if (mscro == 125 && i > 191 && i < 212 && i99 > 51 && i99 < 72) {
                                mscro = 131;
                            }
                            if (mscro == 125 && i > 191 && i < 212 && i99 > 394 && i99 < 415) {
                                mscro = 132;
                            }
                            if (mscro == 125 && i > 193 && i < 210 && i99 > 70 && i99 < 396) {
                                mscro = 85;
                                spos = i99 - mscro;
                            }
                            int i131 = 1350 / i104;
                            if (i131 < 1) {
                                i131 = 1;
                            }
                            if (mscro == 131) {
                                spos -= i131;
                                if (spos > 295) {
                                    spos = 295;
                                }
                                if (spos < 0) {
                                    spos = 0;
                                }
                                lspos = spos;
                            }
                            if (mscro == 132) {
                                spos += i131;
                                if (spos > 295) {
                                    spos = 295;
                                }
                                if (spos < 0) {
                                    spos = 0;
                                }
                                lspos = spos;
                            }
                            if (mscro <= 101) {
                                spos = i99 - mscro;
                                if (spos > 295) {
                                    spos = 295;
                                }
                                if (spos < 0) {
                                    spos = 0;
                                }
                            }
                            if (mscro == 125) {
                                mscro = 225;
                            }
                        } else if (mscro != 125) {
                            mscro = 125;
                        }
                        if (i100 != 0 && i > 65 && i < 170 && i99 > 93 && i99 < 413) {
                            spos -= i100;
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
                            if (opengame >= 27) {
                                opengame = 26;
                            }
                            int i132 = 229 + opengame;
                            if (i132 > 255) {
                                i132 = 255;
                            }
                            if (i132 < 0) {
                                i132 = 0;
                            }
                            rd.setColor(color2k(i132, i132, i132));
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
                            if (prevloaded != -1) {
                                prevloaded = -1;
                            }
                            if (updatec != -1) {
                                updatec = -1;
                            }
                            if (gs.cmsg.isShowing()) {
                                gs.cmsg.setVisible(false);
                                gs.requestFocus();
                            }
                            opengame -= 2;
                            if (opengame == 0 && longame != -1 && chalngd == -1) {
                                ongame = longame;
                                longame = -1;
                            }
                            if (invo) {
                                invo = false;
                            }
                            for (int i133 = 0; i133 < 7; i133++) {
                                if (!"".equals(invos[i133])) {
                                    invos[i133] = "";
                                }
                                if (!"".equals(dinvi[i133])) {
                                    dinvi[i133] = "";
                                }
                            }
                            if (fstart) {
                                fstart = false;
                            }
                            for (int i134 = 0; i134 < 9; i134++) {
                                if (cac[i134] != -1) {
                                    cac[i134] = -1;
                                }
                            }
                            if (dispcar != -1) {
                                dispcar = -1;
                            }
                        } else {
                            if (!xt.lan) {
                                drawSbutton(xt.cgame, 292, 42);
                                drawSbutton(xt.ccar, 442, 42);
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                                rd.setColor(color2k(60, 60, 60));
                                if (!gs.rooms.isShowing()) {
                                    gs.rooms.setVisible(true);
                                }
                                gs.rooms.move(580 - gs.rooms.w / 2, 29);
                                if (gs.rooms.sel != 0) {
                                    stopallnow();
                                    int i135 = gs.rooms.iroom[gs.rooms.sel];
                                    if (i135 < 1000) {
                                        if (i135 >= 1 && i135 <= 5) {
                                            xt.servport = 7070 + i135;
                                        }
                                    } else {
                                        i135 -= 1000;
                                        if (i135 >= 0 && i135 < lg.nservers) {
                                            xt.servport = 7071;
                                            xt.server = lg.servers[i135];
                                            xt.servername = lg.snames[i135];
                                        }
                                    }
                                    inishlobby();
                                    gs.rooms.kmoused = 20;
                                }
                                if (gs.rooms.kmoused != 0) {
                                    i = -1;
                                    i99 = -1;
                                    bool = false;
                                    gs.rooms.kmoused--;
                                }
                            } else {
                                rd.drawImage(xt.lanm, 241, 31, null);
                                if (npo <= 1) {
                                    drawSbutton(xt.cgame, 292, -1000);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (ncnt == 0) {
                                        rd.setColor(new Color(188, 111, 0));
                                    }
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(lmsg, 472 - ftm.stringWidth(lmsg) / 2, 295);
                                    if (". . . | Searching/Waiting for other LAN Players | . . .".equals(lmsg) && ncnt == 0) {
                                        lmsg = "| Searching/Waiting for other LAN Players |";
                                        ncnt = 5;
                                    }
                                    if (". . | Searching/Waiting for other LAN Players | . .".equals(lmsg) && ncnt == 0) {
                                        lmsg = ". . . | Searching/Waiting for other LAN Players | . . .";
                                        ncnt = 5;
                                    }
                                    if (". | Searching/Waiting for other LAN Players | .".equals(lmsg) && ncnt == 0) {
                                        lmsg = ". . | Searching/Waiting for other LAN Players | . .";
                                        ncnt = 5;
                                    }
                                    if ("| Searching/Waiting for other LAN Players |".equals(lmsg) && ncnt == 0) {
                                        lmsg = ". | Searching/Waiting for other LAN Players | .";
                                        ncnt = 5;
                                    }
                                    if (ncnt != 0) {
                                        ncnt--;
                                    }
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
                                    rd.drawString("[  " + i106 + " Players Connected  ]", 472 - ftm.stringWidth("[  " + i106 + " Players Connected  ]") / 2, 295);
                                    drawSbutton(xt.cgame, 472, 325);
                                }
                                drawSbutton(xt.ccar, 442, -1000);
                            }
                            drawSbutton(xt.exit, 690, 42);
                            if (control.enter && !"Type here...".equals(gs.cmsg.getText()) && !"".equals(gs.cmsg.getText())) {
                                if (chalngd == -1) {
                                    pessd[2] = true;
                                } else {
                                    pessd[5] = true;
                                }
                                control.enter = false;
                                String string = gs.cmsg.getText().replace('|', ':');
                                if (string.toLowerCase().contains(gs.tpass.getText().toLowerCase())) {
                                    string = " ";
                                }
                                if (!xt.msgcheck(string) && updatec > -12) {
                                    for (int i136 = 0; i136 < 6; i136++) {
                                        sentn[i136] = sentn[i136 + 1];
                                        cnames[i136] = cnames[i136 + 1];
                                    }
                                    sentn[6] = string;
                                    cnames[6] = pnames[im];
                                    if (updatec > -11) {
                                        updatec = -11;
                                    } else {
                                        updatec--;
                                    }
                                } else {
                                    xt.warning++;
                                }
                                gs.cmsg.setText("");
                            }
                            if (chalngd == -1) {
                                rd.setColor(color2k(230, 230, 230));
                                rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                                if (britchl != 0) {
                                    britchl = 0;
                                }
                                i104 = (ngm - 5) * 24;
                                if (i104 < 0) {
                                    i104 = 0;
                                }
                                i105 = (int) (spos2 / 82.0F * i104 - 2.0F);
                                final int[] is = new int[ngm];
                                final int[] is137 = new int[ngm];
                                for (int i138 = 0; i138 < ngm; i138++) {
                                    is[i138] = 0;
                                }
                                for (int i139 = 0; i139 < ngm; i139++) {
                                    for (int i140 = i139 + 1; i140 < ngm; i140++) {
                                        if (wait[i139] != wait[i140]) {
                                            if (wait[i139] <= 0 && wait[i140] <= 0) {
                                                if (wait[i139] < wait[i140]) {
                                                    is[i139]++;
                                                } else {
                                                    is[i140]++;
                                                }
                                            } else if ((wait[i139] > wait[i140] || wait[i139] <= 0) && wait[i140] > 0) {
                                                is[i139]++;
                                            } else {
                                                is[i140]++;
                                            }
                                        } else if (i140 < i139) {
                                            is[i139]++;
                                        } else {
                                            is[i140]++;
                                        }
                                    }
                                    is137[is[i139]] = i139;
                                }
                                if (control.down) {
                                    opselect++;
                                    for (boolean bool141 = false; 80 + 24 * opselect - i105 > 202 && !bool141; i105 = (int) (spos2 / 82.0F * i104 - 2.0F)) {
                                        spos2++;
                                        if (spos2 > 82) {
                                            spos2 = 82;
                                            bool141 = true;
                                        }
                                        if (spos2 < 0) {
                                            spos2 = 0;
                                            bool141 = true;
                                        }
                                    }
                                    control.down = false;
                                }
                                if (control.up) {
                                    opselect--;
                                    for (boolean bool142 = false; 80 + 24 * opselect - i105 < 80 && !bool142; i105 = (int) (spos2 / 82.0F * i104 - 2.0F)) {
                                        spos2--;
                                        if (spos2 > 82) {
                                            spos2 = 82;
                                            bool142 = true;
                                        }
                                        if (spos2 < 0) {
                                            spos2 = 0;
                                            bool142 = true;
                                        }
                                    }
                                    control.up = false;
                                }
                                int i143 = -1;
                                if (mousonp != -1) {
                                    int i144 = 0;
                                    for (int i145 = 0; i145 < ngm; i145++) {
                                        if (pgames[mousonp] == gnum[i145]) {
                                            i144 = i145;
                                        }
                                    }
                                    i143 = 91 + 24 * is[i144] - i105;
                                    if (80 + 24 * is[i144] - i105 > 202) {
                                        int i146 = 1000 / i104;
                                        if (i146 < 1) {
                                            i146 = 1;
                                        }
                                        spos2 += i146;
                                        i143 = -1;
                                    }
                                    if (80 + 24 * is[i144] - i105 < 80) {
                                        int i147 = 1000 / i104;
                                        if (i147 < 1) {
                                            i147 = 1;
                                        }
                                        spos2 -= i147;
                                        i143 = -1;
                                    }
                                    if (spos2 > 82) {
                                        spos2 = 82;
                                    }
                                    if (spos2 < 0) {
                                        spos2 = 0;
                                    }
                                    i105 = (int) (spos2 / 82.0F * i104 - 2.0F);
                                    opselect = is[i144];
                                }
                                if (opselect <= -1) {
                                    opselect = 0;
                                }
                                if (opselect >= ngm) {
                                    opselect = ngm - 1;
                                }
                                int i148 = 0;
                                for (int i149 = 0; i149 < ngm; i149++) {
                                    if (80 + 24 * i149 - i105 < 224 && 80 + 24 * i149 - i105 > 56) {
                                        if (opselect == i149) {
                                            if (80 + 24 * i149 - i105 >= 224) {
                                                opselect--;
                                            }
                                            if (80 + 24 * i149 - i105 < 62) {
                                                opselect++;
                                            }
                                        }
                                        boolean bool150 = false;
                                        boolean bool151 = false;
                                        if (!gs.openm) {
                                            if (i > 241 && i < 692 && i99 > 92 + 24 * i149 - i105 && i99 < 110 + 24 * i149 - i105) {
                                                if (lxm != i || lym != i99) {
                                                    opselect = i149;
                                                }
                                                bool150 = true;
                                                if (bool) {
                                                    if (clicked == -1) {
                                                        clicked = is137[i149];
                                                    }
                                                } else {
                                                    if (clicked == is137[i149]) {
                                                        ongame = gnum[is137[i149]];
                                                        opengame = 0;
                                                        if (i >= 641 && i <= 689 && i99 > 92 + 24 * i149 - i105 && i99 < 110 + 24 * i149 - i105 && wait[is137[i149]] > 0) {
                                                            boolean bool152 = false;
                                                            if (gwarb[is137[i149]] == 0) {
                                                                if ("".equals(gplyrs[is137[i149]]) || gplyrs[is137[i149]].contains(pnames[im])) {
                                                                    bool152 = true;
                                                                }
                                                            } else if (xt.clan.equalsIgnoreCase(gaclan[is137[i149]]) || xt.clan.equalsIgnoreCase(gvclan[is137[i149]])) {
                                                                bool152 = true;
                                                            }
                                                            if (bool152) {
                                                                join = gnum[is137[i149]];
                                                                msg = "| Joining Game |";
                                                                spos = 0;
                                                            }
                                                        }
                                                        clicked = -1;
                                                    }
                                                    i148++;
                                                }
                                            } else {
                                                i148++;
                                            }
                                            if (i >= 641 && i <= 689 && i99 > 92 + 24 * i149 - i105 && i99 < 110 + 24 * i149 - i105 && bool) {
                                                bool151 = true;
                                            }
                                        }
                                        if (opselect == i149) {
                                            if ((bool150 && bool) || control.enter) {
                                                rd.setColor(color2k(200, 200, 200));
                                                if (control.enter) {
                                                    ongame = gnum[is137[i149]];
                                                    opengame = 0;
                                                    control.enter = false;
                                                }
                                            } else {
                                                rd.setColor(color2k(255, 255, 255));
                                            }
                                            rd.fillRect(241, 92 + 24 * i149 - i105, 451, 18);
                                            if (bool150) {
                                                rd.setColor(color2k(150, 150, 150));
                                                rd.drawRect(239, 90 + 24 * i149 - i105, 454, 21);
                                            }
                                        }
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(gstages[is137[i149]], 382 - ftm.stringWidth(gstages[is137[i149]]) / 2, 105 + 24 * i149 - i105);
                                        rd.drawString("|", 525, 105 + 24 * i149 - i105);
                                        rd.drawString("|", 584, 105 + 24 * i149 - i105);
                                        if (wait[is137[i149]] > 0) {
                                            rd.drawString("" + npls[is137[i149]] + " / " + mnpls[is137[i149]], 556 - ftm.stringWidth("" + npls[is137[i149]] + " / " + mnpls[is137[i149]]) / 2, 105 + 24 * i149 - i105);
                                            rd.setFont(new Font("Arial", 0, 12));
                                            rd.setColor(new Color(80, 128, 0));
                                            rd.drawString("Waiting", 593, 105 + 24 * i149 - i105);
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            if (!bool151) {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fill3DRect(641, 92 + 24 * i149 - i105, 48, 18, true);
                                                rd.fill3DRect(642, 93 + 24 * i149 - i105, 46, 16, true);
                                            } else {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fillRect(641, 92 + 24 * i149 - i105, 48, 18);
                                            }
                                            rd.setColor(new Color(0, 0, 0));
                                            boolean bool153 = false;
                                            if (gwarb[is137[i149]] == 0) {
                                                if ("".equals(gplyrs[is137[i149]]) || gplyrs[is137[i149]].contains(pnames[im])) {
                                                    bool153 = true;
                                                }
                                            } else if (xt.clan.equalsIgnoreCase(gaclan[is137[i149]]) || xt.clan.equalsIgnoreCase(gvclan[is137[i149]])) {
                                                bool153 = true;
                                            }
                                            if (bool153) {
                                                rd.drawString("Join", 665 - ftm.stringWidth("Join") / 2, 105 + 24 * i149 - i105);
                                            } else {
                                                rd.drawString("View", 665 - ftm.stringWidth("View") / 2, 105 + 24 * i149 - i105);
                                            }
                                        } else {
                                            rd.drawString("" + npls[is137[i149]], 556 - ftm.stringWidth("" + npls[is137[i149]]) / 2, 105 + 24 * i149 - i105);
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            if (wait[is137[i149]] == 0) {
                                                rd.setColor(new Color(128, 73, 0));
                                                rd.drawString("Started", 594, 105 + 24 * i149 - i105);
                                            } else {
                                                rd.setColor(color2k(100, 100, 100));
                                                rd.drawString("Finished", 590, 105 + 24 * i149 - i105);
                                            }
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            if (!bool151) {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fill3DRect(641, 92 + 24 * i149 - i105, 48, 18, true);
                                            } else {
                                                rd.setColor(color2k(230, 230, 230));
                                                rd.fillRect(641, 92 + 24 * i149 - i105, 48, 18);
                                            }
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.drawString("View", 665 - ftm.stringWidth("View") / 2, 105 + 24 * i149 - i105);
                                        }
                                    } else {
                                        if (opselect == i149) {
                                            if (80 + 24 * i149 - i105 >= 224) {
                                                opselect--;
                                            }
                                            if (80 + 24 * i149 - i105 <= 56) {
                                                opselect++;
                                            }
                                        }
                                        i148++;
                                    }
                                }
                                if (i148 == ngm && clicked != -1) {
                                    clicked = -1;
                                }
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                if (ngm == 0) {
                                    if (!lloaded) {
                                        rd.drawString("|  Loading Games  |", 472 - ftm.stringWidth("|  Loading Games  |") / 2, 165);
                                    } else if (!xt.lan) {
                                        rd.drawString("No Games Created", 472 - ftm.stringWidth("No Games Created") / 2, 165);
                                    }
                                }
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
                                if (mscro2 == 141 || i104 == 0) {
                                    if (i104 == 0) {
                                        rd.setColor(color2k(205, 205, 205));
                                    } else {
                                        rd.setColor(color2k(215, 215, 215));
                                    }
                                    rd.fillRect(698, 90, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(698, 90, 17, 17, true);
                                }
                                if (i104 != 0) {
                                    rd.drawImage(xt.asu, 703, 96, null);
                                }
                                if (mscro2 == 142 || i104 == 0) {
                                    if (i104 == 0) {
                                        rd.setColor(color2k(205, 205, 205));
                                    } else {
                                        rd.setColor(color2k(215, 215, 215));
                                    }
                                    rd.fillRect(698, 220, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(698, 220, 17, 17, true);
                                }
                                if (i104 != 0) {
                                    rd.drawImage(xt.asd, 703, 226, null);
                                }
                                if (i104 != 0) {
                                    if (lspos2 != spos2) {
                                        rd.setColor(color2k(215, 215, 215));
                                        rd.fillRect(698, 107 + spos2, 17, 31);
                                    } else {
                                        if (mscro2 == 141) {
                                            rd.setColor(color2k(215, 215, 215));
                                        }
                                        rd.fill3DRect(698, 107 + spos2, 17, 31, true);
                                    }
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(703, 120 + spos2, 709, 120 + spos2);
                                    rd.drawLine(703, 122 + spos2, 709, 122 + spos2);
                                    rd.drawLine(703, 124 + spos2, 709, 124 + spos2);
                                    if (mscro2 > 138 && lspos2 != spos2) {
                                        lspos2 = spos2;
                                    }
                                    if (bool) {
                                        if (mscro2 == 145 && i > 698 && i < 715 && i99 > 107 + spos2 && i99 < spos2 + 138) {
                                            mscro2 = i99 - spos2;
                                        }
                                        if (mscro2 == 145 && i > 696 && i < 717 && i99 > 88 && i99 < 109) {
                                            mscro2 = 141;
                                        }
                                        if (mscro2 == 145 && i > 696 && i < 717 && i99 > 218 && i99 < 239) {
                                            mscro2 = 142;
                                        }
                                        if (mscro2 == 145 && i > 698 && i < 715 && i99 > 107 && i99 < 220) {
                                            mscro2 = 122;
                                            spos2 = i99 - mscro2;
                                        }
                                        int i154 = 400 / i104;
                                        if (i154 < 1) {
                                            i154 = 1;
                                        }
                                        if (mscro2 == 141) {
                                            spos2 -= i154;
                                            if (spos2 > 82) {
                                                spos2 = 82;
                                            }
                                            if (spos2 < 0) {
                                                spos2 = 0;
                                            }
                                            lspos2 = spos2;
                                        }
                                        if (mscro2 == 142) {
                                            spos2 += i154;
                                            if (spos2 > 82) {
                                                spos2 = 82;
                                            }
                                            if (spos2 < 0) {
                                                spos2 = 0;
                                            }
                                            lspos2 = spos2;
                                        }
                                        if (mscro2 <= 138) {
                                            spos2 = i99 - mscro2;
                                            if (spos2 > 82) {
                                                spos2 = 82;
                                            }
                                            if (spos2 < 0) {
                                                spos2 = 0;
                                            }
                                        }
                                        if (mscro2 == 145) {
                                            mscro2 = 225;
                                        }
                                    } else if (mscro2 != 145) {
                                        mscro2 = 145;
                                    }
                                    if (i100 != 0 && i > 235 && i < 698 && i99 > 87 && i99 < 239) {
                                        spos2 -= i100;
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
                                if (mousonp != -1 && i143 != -1) {
                                    rd.setColor(color2k(255, 255, 255));
                                    final int[] is155 = {
                                            185, 241, 241, 185
                                    };
                                    final int[] is156 = {
                                            i108, i143, i143 + 19, i108 + 30
                                    };
                                    rd.fillPolygon(is155, is156, 4);
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(185, i108, 241, i143);
                                    rd.drawLine(185, i108 + 30, 241, i143 + 19);
                                    rd.drawLine(241, i143, 692, i143);
                                    rd.drawLine(241, i143 + 19, 692, i143 + 19);
                                }
                            } else {
                                int i157 = 230 + britchl;
                                if (i157 > 255) {
                                    i157 = 255;
                                }
                                if (i157 < 0) {
                                    i157 = 0;
                                }
                                rd.setColor(color2k(i157, i157, i157));
                                rd.fillRoundRect(225, 59, 495, 200, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(225, 59, 495, 200, 20, 20);
                                if (britchl < 25) {
                                    britchl += 5;
                                }
                                if (chalngd > -1) {
                                    int i158 = 0;
                                    for (int i159 = 0; i159 < ngm; i159++) {
                                        if (chalngd == gnum[i159]) {
                                            i158 = i159;
                                        }
                                    }
                                    if (cflk % 4 != 0 || cflk == 0) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("You have been invited by " + chalby + " to join a game!", 472 - ftm.stringWidth("You have been invited by " + chalby + " to join a game!") / 2, 95);
                                        rd.setColor(new Color(117, 67, 0));
                                        rd.drawString(chalby, 472 - ftm.stringWidth("You have been invited by " + chalby + " to join a game!") / 2 + ftm.stringWidth("You have been invited by "), 95);
                                    }
                                    if (cflk != 0) {
                                        cflk--;
                                    }
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString("Stage:  " + gstages[i158] + " ,  Laps: " + gnlaps[i158], 472 - ftm.stringWidth("Stage:  " + gstages[i158] + " ,  Laps: " + gnlaps[i158]) / 2, 130);
                                    rd.setColor(new Color(62, 98, 0));
                                    rd.drawString(gstages[i158], 472 - ftm.stringWidth("Stage:  " + gstages[i158] + " ,  Laps: " + gnlaps[i158]) / 2 + ftm.stringWidth("Stage:  "), 130);
                                    rd.drawString("" + gnlaps[i158], 472 - ftm.stringWidth("Stage:  " + gstages[i158] + " ,  Laps: " + gnlaps[i158]) / 2 + ftm.stringWidth("Stage:  " + gstages[i158] + " ,  Laps: "), 130);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("Players:  " + mnpls[i158], 472 - ftm.stringWidth("Players:  " + mnpls[i158]) / 2, 150);
                                    rd.setColor(new Color(62, 98, 0));
                                    rd.drawString("" + mnpls[i158], 472 - ftm.stringWidth("Players:  " + mnpls[i158]) / 2 + ftm.stringWidth("Players:  "), 150);
                                    final Date date = new Date();
                                    final long l = date.getTime();
                                    if (ptime == 0L || l > ptime + 1000L) {
                                        if (ptime != 0L) {
                                            ctime--;
                                        }
                                        ptime = l;
                                    }
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 0, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString("(" + ctime + " )", 472 - ftm.stringWidth("(" + ctime + " )") / 2, 170);
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
                                        stringbutton(" Cancel X ", 669, 85, 2);
                                    }
                                    if (chalngd == -6) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        rd.drawString("This room already has a game that has started.", 288, 120);
                                        rd.drawString("Please switch to another room to create a new game.", 288, 140);
                                        rd.drawString("Or wait for the game to finish.", 288, 160);
                                        rd.drawString("Use the dropdown menu above to change room or server.", 288, 180);
                                        final int[] is = {
                                                580, 569, 576, 576, 584, 584, 591
                                        };
                                        final int[] is160 = {
                                                66, 77, 77, 102, 102, 77, 77
                                        };
                                        rd.fillPolygon(is, is160, 7);
                                        stringbutton("     OK     ", 472, 215, 1);
                                    }
                                    if (chalngd == -2) {
                                        final boolean bool161 = false;
                                        final boolean bool162 = false;
                                        if (!gs.wgame.isShowing()) {
                                            gs.wgame.setVisible(true);
                                        }
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
                                            if (sflk % 4 != 0 || sflk == 0) {
                                                rd.drawString("Select Stage", 472 - ftm.stringWidth("Select Stage") / 2, 85);
                                            }
                                            if (sflk != 0) {
                                                sflk--;
                                            }
                                            //}
                                            /*if (gs.sgame.getSelectedIndex() == 1) {
                                            	i163 = 472 - (gs.sgame.getWidth() + 6 + gs.snfm1.getWidth()) / 2;
                                            	sgflag = 1;
                                            }
                                            if (gs.sgame.getSelectedIndex() == 2) {
                                            	i163 = 472 - (gs.sgame.getWidth() + 6 + gs.snfm2.getWidth()) / 2;
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
                                            	i163 = 472 - (gs.sgame.getWidth() + 6 + gs.mstgs.getWidth()) / 2;
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
                                            	i163 = 472 - (gs.sgame.getWidth() + 6 + gs.mstgs.getWidth()) / 2;
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
                                            	i163 = 472 - (gs.sgame.getWidth() + 6 + gs.mstgs.getWidth()) / 2;
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
                                            	i163 = 472 - (gs.sgame.getWidth() + 6 + gs.mstgs.getWidth()) / 2;
                                            }*/
                                            /*if (!gs.sgame.isShowing()) {
                                            	gs.sgame.setVisible(true);
                                            	remstage = 0;
                                            	if (loadstage == 0) {
                                            		int i164 = (int) (ThreadLocalRandom.current().nextDouble() * 3.0);
                                            		if (i164 == 3)
                                            			i164 = 2;
                                            		gs.sgame.select(i164);
                                            	}
                                            }*/
                                            //gs.sgame.move(i163, 105);
                                            //i163 += gs.sgame.getWidth() + 6;
                                            //if (true) {
                                            if (!gs.snfmm.isShowing()) {
                                                gs.snfmm.setVisible(true);
                                                if (loadstage == 0) {
                                                    gs.snfmm.select(0);
                                                }
                                            }
                                            gs.snfmm.move(420, 105); //blaze it
                                            //if (gs.snfm1.isShowing())
                                            //	gs.snfm1.setVisible(false);
                                            //if (gs.snfm2.isShowing())
                                            //	gs.snfm2.setVisible(false);
                                            if (gs.mstgs.isShowing()) {
                                                gs.mstgs.setVisible(false);
                                            }
                                            //}
                                            if (/* gs.sgame.getSelectedIndex() == 0 && */gs.snfmm.getSelectedIndex() != 0 && gstage != gs.snfmm.getSelectedIndex()) {
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
                                            	gs.snfm2.move(i163, 105);
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
                                            	gs.snfm1.move(i163, 105);
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
                                            	gs.mstgs.move(i163, 105);
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
                                            				&& xt.drawcarb(true, null, "X", 674, 136, i, i99, bool))
                                            			remstage = 1;
                                            	} else if (remstage != 0)
                                            		remstage = 0;
                                            if (gs.sgame.getSelectedIndex() >= 4) {
                                            	if (!gs.mstgs.isShowing()) {
                                            		gs.mstgs.setVisible(true);
                                            		if (loadstage == 0)
                                            			gs.mstgs.select(0);
                                            	}
                                            	gs.mstgs.move(i163, 105);
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
                                                rd.drawString("Loading stage, please wait...", 472 - ftm.stringWidth("Loading Stage, please wait...") / 2, 165);
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
                                                rd.drawString(gstagename + "  -  Laps:              ", 472 - ftm.stringWidth(gstagename + "  -  Laps:              ") / 2, 155);
                                                if (!gs.slaps.isShowing()) {
                                                    gs.slaps.setVisible(true);
                                                    gs.slaps.select(gstagelaps - 1);
                                                }
                                                gs.slaps.move(472 + ftm.stringWidth(gstagename + "  -  Laps:              ") / 2 - 35, 138);
                                                if (gs.slaps.getSelectedIndex() != gstagelaps - 1) {
                                                    gstagelaps = gs.slaps.getSelectedIndex() + 1;
                                                    gs.requestFocus();
                                                }
                                                stringbutton("    Preview Stage    ", 472, 185, 2);
                                            } else if (gs.slaps.isShowing()) {
                                                gs.slaps.setVisible(false);
                                            }
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
                                            	if (xt.drawcarb(true, null, " OK ", 451, 175, i, i99, bool)) {
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
                                            	if (xt.drawcarb(true, null, " Yes ", 426, 175, i, i99, bool)) {
                                            		remstage = 2;
                                            		cd.onstage = gs.mstgs.getSelectedItem();
                                            		cd.staction = 1;
                                            		cd.sparkstageaction();
                                            		gs.mouses = 0;
                                            	}
                                            	if (xt.drawcarb(true, null, " No ", 480, 175, i, i99, bool)) {
                                            		remstage = 0;
                                            		gs.mouses = 0;
                                            	}
                                            }*/
                                            stringbutton("   Next >   ", 472, 235, 1);
                                            /* } */
                                        } else {
                                            if (!inwab) {
                                                //gs.sgame.setVisible(false);
                                                gs.mstgs.setVisible(false);
                                                gs.slaps.setVisible(false);
                                                //gs.snfm1.setVisible(false);
                                                gs.snfmm.setVisible(false);
                                                //gs.snfm2.setVisible(false);
                                            }
                                            /* if (!xt.clan.equals("")) {} else */ {//CHECK
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.drawString("You must join a clan first to play wars and battles!", 472 - ftm.stringWidth("You must join a clan first to play wars and battles!") / 2, 145);
                                                stringbutton("    Find a clan to join    ", 472, 185, 2);
                                            }
                                            if (!inwab) {
                                                inwab = true;
                                            }
                                        }
                                        {
                                            gs.pgame.setVisible(false);
                                        }
                                        {
                                            gs.vnpls.setVisible(false);
                                            gs.vtyp.setVisible(false);
                                        }
                                    }
                                    if (chalngd == -3) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        if (sflk % 4 != 0 || sflk == 0) {
                                            rd.drawString("Select Number of Players", 472 - ftm.stringWidth("Select Number of Players") / 2, 85);
                                        }
                                        if (sflk != 0) {
                                            sflk--;
                                        }
                                        int i166 = 0;
                                        if (xt.lan) {
                                            i166 = 59;
                                        }
                                        rd.drawString("Players", 413 - i166, 122);
                                        if (!gs.snpls.isShowing()) {
                                            gs.snpls.setVisible(true);
                                            gs.snpls.select(gnpls - 1);
                                        }
                                        gs.snpls.move(467 - i166, 105);
                                        boolean bool167 = false;
                                        if (gs.snpls.getSelectedIndex() != 0 && gs.snpls.getSelectedIndex() != gnpls - 1) {
                                            gnpls = gs.snpls.getSelectedIndex() + 1;
                                            bool167 = true;
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
                                            if (gs.snbts.getSelectedIndex() != gnbts || bool167) {
                                                for (gnbts = gs.snbts.getSelectedIndex(); gnbts + gnpls > 8; gnbts--) {
                                                }
                                                gs.snbts.select(gnbts);
                                            }
                                        }
                                        rd.drawString("Wait", 414, 162);
                                        if (!gs.swait.isShowing()) {
                                            gs.swait.setVisible(true);
                                            if (gwait == 0) {
                                                gs.swait.select(1);
                                            }
                                        }
                                        gs.swait.move(451, 145);
                                        if ((gs.swait.getSelectedIndex() + 1) * 60 != gwait) {
                                            gwait = (gs.swait.getSelectedIndex() + 1) * 60;
                                        }
                                        rd.setColor(color2k(90, 90, 90));
                                        rd.setFont(new Font("Arial", 0, 11));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("(Maximum time to wait for all players to `join. )", 472 - ftm.stringWidth("(Maximum time to wait for all players to join. )") / 2, 179);
                                        stringbutton("   < Back   ", 422, 235, 1);
                                        stringbutton("   Next >   ", 522, 235, 1);
                                    }
                                    if (chalngd == -4) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        if (sflk % 4 != 0 || sflk == 0) {
                                            rd.drawString("Game Options", 472 - ftm.stringWidth("Game Options") / 2, 85);
                                        }
                                        if (sflk != 0) {
                                            sflk--;
                                        }
                                        int i168 = 472 - (gs.scars.getWidth() + gs.sclass.getWidth() + gs.sfix.getWidth() + 16) / 2;
                                        if (!gs.scars.isShowing()) {
                                            gs.scars.setVisible(true);
                                            if (gcars >= 0 && gcars <= 2) {
                                                gs.scars.select(gcars);
                                            } else {
                                                gs.scars.select(0);
                                            }
                                        }
                                        gs.scars.move(i168, 105);
                                        i168 += gs.scars.getWidth() + 8;
                                        if (!gs.sclass.isShowing()) {
                                            gs.sclass.setVisible(true);
                                            if (gclass >= 0 && gclass <= 5) {
                                                gs.sclass.select(gclass);
                                            } else {
                                                gs.sclass.select(0);
                                            }
                                        }
                                        gs.sclass.move(i168, 105);
                                        i168 += gs.sclass.getWidth() + 8;
                                        if (!gs.sfix.isShowing()) {
                                            gs.sfix.setVisible(true);
                                            if (gfix >= 0 && gfix <= 5) {
                                                gs.sfix.select(gfix);
                                            } else {
                                                gs.sfix.select(0);
                                            }
                                        }
                                        gs.sfix.move(i168, 105);
                                        i168 += gs.sfix.getWidth();
                                        if (!gs.openm) {
                                            gs.movefield(gs.notp, i168 - 112, 131, 150, 17);
                                        } else {
                                            gs.movefield(gs.notp, i168 - 112, -2000, 150, 17);
                                        }
                                        if (!gs.notp.isShowing()) {
                                            gs.notp.setVisible(true);
                                            if (gnotp == 0) {
                                                gs.notp.setState(false);
                                            } else {
                                                gs.notp.setState(true);
                                            }
                                        }
                                        if (xt.sc[0] < 16) {
                                            if (!gs.openm) {
                                                gs.movefield(gs.mycar, 472 - (gs.scars.getWidth() + gs.sclass.getWidth() + gs.sfix.getWidth() + 16) / 2, 131, 150, 17);
                                            } else {
                                                gs.movefield(gs.mycar, 410, -2000, 150, 17);
                                            }
                                            if (!gs.mycar.isShowing()) {
                                                gs.mycar.setVisible(true);
                                                gs.mycar.setLabel(cd.names[xt.sc[0]] + " Game!");
                                                if (gclass <= -2) {
                                                    gs.mycar.setState(true);
                                                } else {
                                                    gs.mycar.setState(false);
                                                }
                                            }
                                        } else if (gs.mycar.getState()) {
                                            gs.mycar.setState(false);
                                        }
                                        if (gs.mycar.getState()) {
                                            if (gs.sclass.isEnabled()) {
                                                gs.sclass.setEnabled(false);
                                            }
                                            if (gs.scars.isEnabled()) {
                                                gs.scars.setEnabled(false);
                                            }
                                        } else {
                                            if (!gs.sclass.isEnabled()) {
                                                gs.sclass.setEnabled(true);
                                            }
                                            if (!gs.scars.isEnabled()) {
                                                gs.scars.setEnabled(true);
                                            }
                                            if (gs.sclass.getSelectedIndex() != gclass) {
                                                gclass = gs.sclass.getSelectedIndex();
                                                gs.mycar.setVisible(false);
                                            }
                                            if (gs.scars.getSelectedIndex() != gcars) {
                                                gcars = gs.scars.getSelectedIndex();
                                            }
                                        }
                                        if (gs.sfix.getSelectedIndex() != gfix) {
                                            gfix = gs.sfix.getSelectedIndex();
                                        }
                                        String string = "Public Game, anyone can join...";
                                        int i169 = 0;
                                        for (int i170 = 0; i170 < 7; i170++) {
                                            if (!"".equals(invos[i170])) {
                                                i169++;
                                            }
                                        }
                                        if (i169 > 0) {
                                            string = "Players Allowed:  ";
                                            int i171 = 0;
                                            for (int i172 = 0; i172 < 7; i172++) {
                                                if (!"".equals(invos[i172])) {
                                                    string = string + invos[i172];
                                                    if (++i171 != i169) {
                                                        if (i171 == i169 - 1) {
                                                            string = string + " and ";
                                                        } else {
                                                            string = string + ", ";
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        rd.setColor(new Color(0, 0, 0));
                                        if (i169 < gnpls - 1) {
                                            rd.setFont(new Font("Arial", 1, 13));
                                            rd.drawString("Private Game, only specific players allowed to join?  " + i169 + "/" + (gnpls - 1), 330, 180);
                                            stringbutton("<   Select   ", 281, 180, 2);
                                            rd.setFont(new Font("Tahoma", 0, 11));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(string, 472 - ftm.stringWidth(string) / 2, 203);
                                        } else {
                                            rd.setFont(new Font("Arial", 1, 13));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString("" + i169 + " Allowed Players Selected", 472 - ftm.stringWidth("" + i169 + " Allowed Players Selected") / 2, 180);
                                            rd.setFont(new Font("Tahoma", 0, 11));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString(string, 472 - ftm.stringWidth(string) / 2, 203);
                                        }
                                        stringbutton("   < Back   ", 422, 235, 1);
                                        stringbutton("   Finish!   ", 522, 235, 1);
                                    }
                                    if (chalngd == -5) {
                                        if (fstart) {
                                            fstart = false;
                                        }
                                        rd.setFont(new Font("Arial", 1, 13));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(msg, 472 - ftm.stringWidth(msg) / 2, 145);
                                        if (". . . | Creating Game | . . .".equals(msg) && ncnt == 0) {
                                            msg = "| Creating Game |";
                                            ncnt = 5;
                                        }
                                        if (". . | Creating Game | . .".equals(msg) && ncnt == 0) {
                                            msg = ". . . | Creating Game | . . .";
                                            ncnt = 5;
                                        }
                                        if (". | Creating Game | .".equals(msg) && ncnt == 0) {
                                            msg = ". . | Creating Game | . .";
                                            ncnt = 5;
                                        }
                                        if ("| Creating Game |".equals(msg) && ncnt == 0) {
                                            msg = ". | Creating Game | .";
                                            ncnt = 5;
                                        }
                                        if (ncnt != 0) {
                                            ncnt--;
                                        }
                                    }
                                }
                            }
                            //if ((chalngd == -1 || chalngd == -6) && lg.gamec != -1) {}
                        }
                    } else if (opengame < 26) {
                        int i191 = 229 + opengame;
                        if (i191 > 255) {
                            i191 = 255;
                        }
                        if (i191 < 0) {
                            i191 = 0;
                        }
                        rd.setColor(color2k(i191, i191, i191));
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
                        if (prevloaded != -1) {
                            prevloaded = -1;
                        }
                        if (updatec != -1) {
                            updatec = -1;
                        }
                        if (gs.cmsg.isShowing()) {
                            gs.cmsg.setVisible(false);
                            gs.requestFocus();
                        }
                        if (gs.rooms.isShowing()) {
                            gs.rooms.setVisible(false);
                        }
                        if (fstart) {
                            fstart = false;
                        }
                        for (int i192 = 0; i192 < 9; i192++) {
                            if (cac[i192] != -1) {
                                cac[i192] = -1;
                            }
                        }
                        if (dispcar != -1) {
                            dispcar = -1;
                        }
                        opengame += 2;
                    } else {
                        rd.setColor(color2k(255, 255, 255));
                        rd.fillRoundRect(225, 1, 495, 417, 20, 20);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawRoundRect(225, 1, 495, 417, 20, 20);
                        if ((join > -1 && pgames[im] != join) || join == -2) {
                            if (join > -1 && pgames[im] != join) {
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                                rd.drawString(msg, 472 - ftm.stringWidth(msg) / 2, 195);
                                if (". . . | Joining Game | . . .".equals(msg) && ncnt == 0) {
                                    msg = "| Joining Game |";
                                    ncnt = 5;
                                }
                                if (". . | Joining Game | . .".equals(msg) && ncnt == 0) {
                                    msg = ". . . | Joining Game | . . .";
                                    ncnt = 5;
                                }
                                if (". | Joining Game | .".equals(msg) && ncnt == 0) {
                                    msg = ". . | Joining Game | . .";
                                    ncnt = 5;
                                }
                                if ("| Joining Game |".equals(msg) && ncnt == 0) {
                                    msg = ". | Joining Game | .";
                                    ncnt = 5;
                                }
                                if (ncnt != 0) {
                                    ncnt--;
                                }
                            }
                            if (join == -2) {
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                                rd.drawString(msg, 472 - ftm.stringWidth(msg) / 2, 195);
                                if (". . . | Leaving Game | . . .".equals(msg) && ncnt == 0) {
                                    msg = "| Leaving Game |";
                                    ncnt = 5;
                                }
                                if (". . | Leaving Game | . .".equals(msg) && ncnt == 0) {
                                    msg = ". . . | Leaving Game | . . .";
                                    ncnt = 5;
                                }
                                if (". | Leaving Game | .".equals(msg) && ncnt == 0) {
                                    msg = ". . | Leaving Game | . .";
                                    ncnt = 5;
                                }
                                if ("| Leaving Game |".equals(msg) && ncnt == 0) {
                                    msg = ". | Leaving Game | .";
                                    ncnt = 5;
                                }
                                if (ncnt != 0) {
                                    ncnt--;
                                }
                            }
                            if (gs.cmsg.isShowing()) {
                                gs.cmsg.setVisible(false);
                                gs.requestFocus();
                            }
                        } else {
                            int i193 = 0;
                            for (int i194 = 0; i194 < ngm; i194++) {
                                if (ongame == gnum[i194]) {
                                    i193 = i194;
                                }
                            }
                            rd.setFont(new Font("Arial", 1, 11));
                            ftm = rd.getFontMetrics();
                            rd.setColor(new Color(0, 0, 0));
                            int i195 = 23;
                            int i196 = 0;
                            if (gwarb[i193] != 0) {
                                i195 = 28;
                                i196 = 2;
                                String string = "Clan war";
                                if (gwarb[i193] == 2) {
                                    string = "Car battle";
                                }
                                if (gwarb[i193] == 3) {
                                    string = "Stage battle";
                                }
                                rd.drawString(string + " between " + gaclan[i193] + " and " + gvclan[i193], 243, 14);
                            }
                            String string = "";
                            String string197 = "";
                            String string198 = "";
                            if (conon == 1) {
                                if (wait[i193] > 0) {
                                    if (gwarb[i193] == 0) {
                                        String string199 = "";
                                        if ("".equals(gplyrs[i193])) {
                                            string199 = "Public Game";
                                        } else {
                                            string199 = "Private Game";
                                        }
                                        if (gfx[i193] == 1) {
                                            string199 = string199 + " | 4 Fixes";
                                        }
                                        if (gfx[i193] == 2) {
                                            string199 = string199 + " | 3 Fixes";
                                        }
                                        if (gfx[i193] == 3) {
                                            string199 = string199 + " | 2 Fixes";
                                        }
                                        if (gfx[i193] == 4) {
                                            string199 = string199 + " | 1 Fix";
                                        }
                                        if (gfx[i193] == 5) {
                                            string199 = string199 + " | No Fixing";
                                        }
                                        String string200 = "";
                                        if (gclss[i193] > -2) {
                                            if (gcrs[i193] == 1) {
                                                string200 = "Custom Cars";
                                            }
                                            if (gcrs[i193] == 2) {
                                                string200 = "Game Cars";
                                            }
                                            String string201 = "";
                                            if (gclss[i193] == 1) {
                                                string201 = "Class C";
                                            }
                                            if (gclss[i193] == 2) {
                                                string201 = "Class B & C";
                                            }
                                            if (gclss[i193] == 3) {
                                                string201 = "Class B";
                                            }
                                            if (gclss[i193] == 4) {
                                                string201 = "Class A & B";
                                            }
                                            if (gclss[i193] == 5) {
                                                string201 = "Class A";
                                            }
                                            if (!"".equals(string200) && !"".equals(string201)) {
                                                string200 = string200 + " | " + string201;
                                            } else {
                                                string200 = string200 + string201;
                                            }
                                        } else {
                                            string200 = cd.names[Math.abs(gclss[i193] + 2)];
                                        }
                                        if ("".equals(string200)) {
                                            rd.drawString("Type:", 243, 23);
                                            rd.setColor(new Color(80, 128, 0));
                                            rd.drawString(string199, 279, 23);
                                        } else {
                                            rd.drawString("Type:", 243, 14);
                                            rd.drawString("Cars:", 244, 28);
                                            rd.setColor(new Color(80, 128, 0));
                                            rd.drawString(string199, 279, 14);
                                            rd.drawString(string200, 279, 28);
                                        }
                                    } else {
                                        String string202 = "Game #" + gameturn[i193];
                                        if (gcrs[i193] == 1) {
                                            string202 = string202 + " | Clan Cars";
                                        }
                                        if (gcrs[i193] == 2) {
                                            string202 = string202 + " | Game Cars";
                                        }
                                        if (gclss[i193] == 1) {
                                            string202 = string202 + " | Class C";
                                        }
                                        if (gclss[i193] == 2) {
                                            string202 = string202 + " | Class B & C";
                                        }
                                        if (gclss[i193] == 3) {
                                            string202 = string202 + " | Class B";
                                        }
                                        if (gclss[i193] == 4) {
                                            string202 = string202 + " | Class A & B";
                                        }
                                        if (gclss[i193] == 5) {
                                            string202 = string202 + " | Class A";
                                        }
                                        if (gfx[i193] == 1) {
                                            string202 = string202 + " | 4 Fixes";
                                        }
                                        if (gfx[i193] == 2) {
                                            string202 = string202 + " | 3 Fixes";
                                        }
                                        if (gfx[i193] == 3) {
                                            string202 = string202 + " | 2 Fixes";
                                        }
                                        if (gfx[i193] == 4) {
                                            string202 = string202 + " | 1 Fix";
                                        }
                                        if (gfx[i193] == 5) {
                                            string202 = string202 + " | No Fixing";
                                        }
                                        rd.setColor(new Color(80, 128, 0));
                                        rd.drawString(string202, 243, 28);
                                    }
                                }
                                if (wait[i193] == 0) {
                                    rd.drawString("Status:", 241 + i196, i195);
                                    rd.setColor(new Color(128, 73, 0));
                                    if (prevloaded == 0) {
                                        rd.drawString("Starting...", 286 + i196, i195);
                                    } else {
                                        rd.drawString("Started", 286 + i196, i195);
                                    }
                                }
                                if (wait[i193] == -1) {
                                    rd.drawString("Status:", 241 + i196, i195);
                                    rd.setColor(color2k(100, 100, 100));
                                    rd.drawString("Finished", 286 + i196, i195);
                                }
                            } else {
                                rd.drawString("Status:", 241 + i196, i195);
                                rd.setColor(new Color(128, 73, 0));
                                rd.drawString("Starting...", 286 + i196, i195);
                            }
                            if (gwarb[i193] == 0) {
                                rd.setColor(new Color(0, 0, 0));
                                if (gmaker[i193].equals(pnames[im])) {
                                    rd.drawString("Created by You", 449, 23);
                                } else {
                                    rd.drawString("Created by", 449, 23);
                                    rd.drawString(":", 511, 23);
                                    rd.drawString(gmaker[i193], 520, 23);
                                }
                            } else if (wait[i193] == 0 || wait[i193] == -1 || conon != 1) {
                                rd.setColor(color2k(200, 200, 200));
                                rd.drawRect(349, 16, 253, 16);
                                rd.setFont(new Font("Arial", 0, 11));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(0, 0, 0));
                                int i203 = 0;
                                int i204 = 0;
                                if (wait[i193] == -1) {
                                    final String[] strings = {
                                            "", "", "", "", "", "", "", ""
                                    };
                                    for (int i205 = 0; i205 < prnpo; i205++) {
                                        for (int i206 = 0; i206 < npo; i206++) {
                                            if (prnames[i205].equals(pnames[i206]) && pgames[i206] == gnum[i193]) {
                                                strings[i205] = pclan[i206];
                                            }
                                        }
                                    }
                                    for (int i207 = 0; i207 < prnpo; i207++) {
                                        if (ppos[i207] == 0) {
                                            string = strings[i207];
                                            break;
                                        }
                                    }
                                    if (!"".equals(string)) {
                                        if (gwtyp[i193] == 2) {
                                            boolean bool208 = false;
                                            for (int i209 = 0; i209 < prnpo; i209++) {
                                                if (!strings[i209].equalsIgnoreCase(string) && pdam[i209] < 55 && pdam[i209] != -17) {
                                                    bool208 = true;
                                                    break;
                                                }
                                            }
                                            if (!bool208) {
                                                string198 = string + " should have raced in this game!";
                                                string = "";
                                            }
                                        }
                                        if (gwtyp[i193] == 3) {
                                            boolean bool210 = true;
                                            for (int i211 = 0; i211 < prnpo; i211++) {
                                                if (!strings[i211].equalsIgnoreCase(string) && pdam[i211] < 55 && pdam[i211] != -17) {
                                                    bool210 = false;
                                                    break;
                                                }
                                            }
                                            if (!bool210) {
                                                string198 = string + " should have wasted in this game!";
                                                string = "";
                                            }
                                        }
                                        if (gwtyp[i193] == 4) {
                                            if (string.equalsIgnoreCase(gaclan[i193])) {
                                                boolean bool212 = true;
                                                for (int i213 = 0; i213 < prnpo; i213++) {
                                                    if (!strings[i213].equalsIgnoreCase(string) && pdam[i213] < 55 && pdam[i213] != -17) {
                                                        bool212 = false;
                                                        break;
                                                    }
                                                }
                                                if (!bool212) {
                                                    string198 = string + " should have wasted in this game!";
                                                    string = "";
                                                }
                                            } else {
                                                boolean bool214 = false;
                                                for (int i215 = 0; i215 < prnpo; i215++) {
                                                    if (!strings[i215].equalsIgnoreCase(string) && pdam[i215] < 55 && pdam[i215] != -17) {
                                                        bool214 = true;
                                                        break;
                                                    }
                                                }
                                                if (!bool214) {
                                                    string198 = string + " should have raced in this game!";
                                                    string = "";
                                                }
                                            }
                                        }
                                        if (gwtyp[i193] == 5) {
                                            if (!string.equalsIgnoreCase(gaclan[i193])) {
                                                boolean bool216 = true;
                                                for (int i217 = 0; i217 < prnpo; i217++) {
                                                    if (!strings[i217].equalsIgnoreCase(string) && pdam[i217] < 55 && pdam[i217] != -17) {
                                                        bool216 = false;
                                                        break;
                                                    }
                                                }
                                                if (!bool216) {
                                                    string198 = string + " should have wasted in this game!";
                                                    string = "";
                                                }
                                            } else {
                                                boolean bool218 = false;
                                                for (int i219 = 0; i219 < prnpo; i219++) {
                                                    if (!strings[i219].equalsIgnoreCase(string) && pdam[i219] < 55 && pdam[i219] != -17) {
                                                        bool218 = true;
                                                        break;
                                                    }
                                                }
                                                if (!bool218) {
                                                    string198 = string + " should have raced in this game!";
                                                    string = "";
                                                }
                                            }
                                        }
                                    } else {
                                        string198 = "No one finished first - no one survived!";
                                    }
                                    if (string.equalsIgnoreCase(gaclan[i193])) {
                                        i203 = 1;
                                    }
                                    if (string.equalsIgnoreCase(gvclan[i193])) {
                                        i204 = 1;
                                    }
                                }
                                rd.drawString(gaclan[i193] + " : " + (gascore[i193] + i203) + "     |     " + gvclan[i193] + " : " + (gvscore[i193] + i204), 474 - ftm.stringWidth(gaclan[i193] + " : " + gascore[i193] + "     |     " + gvclan[i193] + " : " + gvscore[i193]) / 2, 28);
                                if (gwarb[i193] == 1) {
                                    if (gascore[i193] + i203 >= 5) {
                                        string197 = gaclan[i193] + " wins the war!";
                                    }
                                    if (gvscore[i193] + i204 >= 5) {
                                        string197 = gvclan[i193] + " wins the war!";
                                    }
                                } else {
                                    if (gascore[i193] + i203 >= 3) {
                                        string197 = gaclan[i193] + " wins the battle!";
                                    }
                                    if (gvscore[i193] + i204 >= 3) {
                                        string197 = gvclan[i193] + " wins the battle!";
                                    }
                                }
                            }
                            rd.setColor(color2k(200, 200, 200));
                            rd.drawLine(233, 32, 602, 32);
                            rd.drawLine(602, 7, 602, 32);
                            if (conon == 1) {
                                if (pgames[im] == ongame) {
                                    stringbutton("Leave Game X", 660, 26, 0);
                                } else {
                                    stringbutton("Close X", 679, 26, 0);
                                }
                            }
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
                            int i220 = 0;
                            int i221 = -1;
                            for (int i222 = 0; i222 < npo; i222++) {
                                if (pgames[i222] == ongame) {
                                    rd.setColor(color2k(240, 240, 240));
                                    if (i222 == im && wait[i193] != -1) {
                                        if (nflk == 0 || conon == 2) {
                                            rd.setColor(color2k(255, 255, 255));
                                            nflk = 3;
                                        } else {
                                            nflk--;
                                        }
                                    }
                                    rd.fillRect(237, 54 + i220 * 42, 170, 40);
                                    rd.setColor(color2k(200, 200, 200));
                                    if (gwarb[i193] != 0) {
                                        if (pclan[i222].equalsIgnoreCase(gaclan[i193])) {
                                            rd.setColor(new Color(255, 128, 0));
                                        }
                                        if (pclan[i222].equalsIgnoreCase(gvclan[i193])) {
                                            rd.setColor(new Color(0, 128, 255));
                                        }
                                        if (wait[i193] == -1 && prevloaded == 1 && string.equalsIgnoreCase(pclan[i222]) && nflk == 0) {
                                            rd.setColor(new Color(0, 0, 0));
                                        }
                                    } else if (wait[i193] == -1 && prevloaded == 1) {
                                        for (int i223 = 0; i223 < prnpo; i223++) {
                                            if (pnames[i222].equals(prnames[i223]) && ppos[i223] == 0 && nflk == 0) {
                                                rd.setColor(new Color(0, 0, 0));
                                            }
                                        }
                                    }
                                    rd.drawRect(237, 54 + i220 * 42, 170, 40);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pnames[i222], 282 - ftm.stringWidth(pnames[i222]) / 2, 72 + i220 * 42);
                                    rd.setFont(new Font("Arial", 0, 10));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(pcarnames[i222], 282 - ftm.stringWidth(pcarnames[i222]) / 2, 84 + i220 * 42);
                                    m.crs = true;
                                    m.x = -335;
                                    m.y = 0;
                                    m.z = -50;
                                    m.xz = 0;
                                    m.zy = 20;
                                    m.ground = -2000;
                                    if (pcars[i222] != -1) {
                                        for (int i224 = 0; i224 < contos[pcars[i222]].npl; i224++) {
                                            contos[pcars[i222]].p[i224].flx = 0;
                                            if (contos[pcars[i222]].p[i224].colnum == 1) {
                                                contos[pcars[i222]].p[i224].hsb[0] = pcols[i222][0];
                                                contos[pcars[i222]].p[i224].hsb[1] = pcols[i222][1];
                                                contos[pcars[i222]].p[i224].hsb[2] = 1.0F - pcols[i222][2];
                                            }
                                            if (contos[pcars[i222]].p[i224].colnum == 2) {
                                                contos[pcars[i222]].p[i224].hsb[0] = pcols[i222][3];
                                                contos[pcars[i222]].p[i224].hsb[1] = pcols[i222][4];
                                                contos[pcars[i222]].p[i224].hsb[2] = 1.0F - pcols[i222][5];
                                            }
                                        }
                                        if (cac[i220] != pcars[i222]) {
                                            int i225 = contos[pcars[i222]].p[0].oz[0];
                                            int i226 = i225;
                                            int i227 = contos[pcars[i222]].p[0].oy[0];
                                            int i228 = i227;
                                            for (int i229 = 0; i229 < contos[pcars[i222]].npl; i229++) {
                                                for (int i230 = 0; i230 < contos[pcars[i222]].p[i229].n; i230++) {
                                                    if (contos[pcars[i222]].p[i229].oz[i230] < i225) {
                                                        i225 = contos[pcars[i222]].p[i229].oz[i230];
                                                    }
                                                    if (contos[pcars[i222]].p[i229].oz[i230] > i226) {
                                                        i226 = contos[pcars[i222]].p[i229].oz[i230];
                                                    }
                                                    if (contos[pcars[i222]].p[i229].oy[i230] < i227) {
                                                        i227 = contos[pcars[i222]].p[i229].oy[i230];
                                                    }
                                                    if (contos[pcars[i222]].p[i229].oy[i230] > i228) {
                                                        i228 = contos[pcars[i222]].p[i229].oy[i230];
                                                    }
                                                }
                                            }
                                            cax[i220] = (i226 + i225) / 2;
                                            cay[i220] = (i228 + i227) / 2;
                                            cac[i220] = pcars[i222];
                                        }
                                        if (i > 327 && i < 402 && i99 > 57 + i220 * 42 && i99 < 91 + i220 * 42) {
                                            i101 = 12;
                                            i221 = i222;
                                            for (int i231 = 0; i231 < contos[pcars[i222]].npl; i231++) {
                                                contos[pcars[i222]].p[i231].flx = 77;
                                            }
                                        }
                                        contos[pcars[i222]].z = 2500 - i220 * 80;
                                        contos[pcars[i222]].y = 150 + 250 * i220 - cay[i220];
                                        contos[pcars[i222]].x = -145 - cax[i220];
                                        contos[pcars[i222]].zy = 0;
                                        contos[pcars[i222]].xz = -90;
                                        contos[pcars[i222]].xy = pend - i220 * 5;
                                        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                        contos[pcars[i222]].d(rd);
                                        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                    } else {
                                        rd.setFont(new Font("Arial", 1, 11));
                                        rd.setColor(color2k(80, 80, 80));
                                        rd.drawString("Loading...", 339, 77 + i220 * 42);
                                    }
                                    i220++;
                                }
                            }
                            if (!pendb) {
                                pend += 2;
                                if (pend > 80) {
                                    pendb = true;
                                }
                            } else {
                                pend -= 2;
                                if (pend < -10) {
                                    pendb = false;
                                }
                            }
                            if (i221 != -1) {
                                if (bool) {
                                    mousedout = true;
                                } else if (mousedout) {
                                    if (dispcar != i221 && i221 != -1 && cd.action != 6) {
                                        cd.action = 0;
                                        dispcar = i221;
                                        forcar = pcars[i221];
                                        dispco = null;
                                        System.gc();
                                        dispco = new ContO(contos[forcar], 0, 0, 0, 0);
                                    } else {
                                        dispcar = -1;
                                    }
                                    mousedout = false;
                                }
                            } else if (mousedout) {
                                mousedout = false;
                            }
                            for (int i232 = 0; i232 < 7; i232++) {
                                for (int i233 = 0; i233 < npo; i233++) {
                                    if (pgames[i233] == ongame && invos[i232].equals(pnames[i233]) && dinvi[i232].equals(invos[i232])) {
                                        for (int i234 = i232; i234 < 6; i234++) {
                                            invos[i234] = invos[i234 + 1];
                                            dinvi[i234] = dinvi[i234 + 1];
                                        }
                                        invos[6] = "";
                                        dinvi[6] = "";
                                    }
                                }
                            }
                            if (wait[i193] > 0) {
                                int i235 = 0;
                                for (int i236 = i220; i236 < mnpls[i193]; i236++) {
                                    rd.setColor(color2k(200, 200, 200));
                                    rd.drawRect(237, 54 + i236 * 42, 170, 40);
                                    boolean bool237 = false;
                                    if (pgames[im] == ongame) {
                                        if (!"".equals(gplyrs[i193])) {
                                            bool237 = true;
                                        }
                                    } else if (gwarb[i193] == 0) {
                                        if (!"".equals(gplyrs[i193]) && !gplyrs[i193].contains(pnames[im])) {
                                            bool237 = true;
                                        }
                                    } else if (!xt.clan.equalsIgnoreCase(gaclan[i193]) && !xt.clan.equalsIgnoreCase(gvclan[i193])) {
                                        bool237 = true;
                                    }
                                    if (i > 237 && i < 407 && i99 > 54 + i236 * 42 && i99 < 94 + i236 * 42 && !bool237) {
                                        if (pgames[im] == ongame) {
                                            stringbutton("<     Invite Player      ", 322, 79 + i236 * 42, 0);
                                        } else {
                                            stringbutton("    Join Game    ", 322, 79 + i236 * 42, 0);
                                        }
                                        pbtn = 1;
                                    } else if ("".equals(invos[i235])) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Empty", 322 - ftm.stringWidth("Empty") / 2, 72 + i236 * 42);
                                        rd.setFont(new Font("Arial", 0, 10));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Waiting for player...", 322 - ftm.stringWidth("Waiting for player...") / 2, 84 + i236 * 42);
                                    } else if (!dinvi[i235].equals(invos[i235])) {
                                        if (nflk != 0) {
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString("Inviting player...", 322 - ftm.stringWidth("Inviting player...") / 2, 79 + i236 * 42);
                                        }
                                    } else {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Player Invited!", 322 - ftm.stringWidth("Player Invited!") / 2, 71 + i236 * 42);
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString(invos[i235], 322 - ftm.stringWidth(invos[i235]) / 2, 87 + i236 * 42);
                                    }
                                    i235++;
                                }
                            }
                            if (xt.lan && mnbts[i193] != 0) {
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString("Plus " + mnbts[i193] + " MadBots!", 322 - ftm.stringWidth("Plus " + mnbts[i193] + " MadBots!") / 2, 73 + mnpls[i193] * 42);
                            }
                            if (dispcar == -1 || conon != 1) {
                                rd.drawImage(xt.sts, 537, 39, null);
                                rd.setColor(color2k(200, 200, 200));
                                rd.drawRect(415, 54, 293, 166);
                                if (conon == 1) {
                                    if (wait[i193] > 0) {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (gwarb[i193] == 0) {
                                            if (wait[i193] > 30 || npls[i193] <= 1) {
                                                String string238 = "s";
                                                if (mnpls[i193] - npls[i193] == 1) {
                                                    string238 = "";
                                                }
                                                rd.drawString("Waiting for " + (mnpls[i193] - npls[i193]) + " more player" + string238 + " to join to start.", 561 - ftm.stringWidth("Waiting for " + (mnpls[i193] - npls[i193]) + " more player" + string238 + " to join to start.") / 2, 98);
                                                rd.setFont(new Font("Arial", 0, 12));
                                                ftm = rd.getFontMetrics();
                                                int i239 = 134;
                                                if (!"Coach Insano".equals(gmaker[i193]) && !gmaker[i193].equals(pnames[im])) {
                                                    boolean bool240 = false;
                                                    for (int i241 = 0; i241 < npo; i241++) {
                                                        if (pgames[i241] == ongame && gmaker[i193].equals(pnames[i241])) {
                                                            bool240 = true;
                                                        }
                                                    }
                                                    if (bool240) {
                                                        i239 = 144;
                                                        rd.drawString(gmaker[i193] + " can start this game at anytime.", 561 - ftm.stringWidth(gmaker[i193] + " can start this game at anytime.") / 2, 124);
                                                    }
                                                }
                                                if (npls[i193] > 1) {
                                                    String string242 = "" + wait[i193] + " seconds";
                                                    if (wait[i193] > 60) {
                                                        string242 = "" + (int) (wait[i193] / 60.0F * 100.0F) / 100.0F + " minutes";
                                                    }
                                                    rd.drawString("(Waiting " + string242 + " maximum! )", 561 - ftm.stringWidth("(Waiting " + string242 + " maximum! )") / 2, i239);
                                                }
                                            } else {
                                                final Date date = new Date();
                                                final long l = date.getTime();
                                                if (ptime == 0L || l > ptime + 1500L) {
                                                    if (ptime != 0L) {
                                                        wait[i193]--;
                                                        if (wait[i193] < 1) {
                                                            wait[i193] = 1;
                                                        }
                                                    }
                                                    ptime = l;
                                                }
                                                if (pgames[im] == ongame || nflk != 0) {
                                                    rd.drawString("Game starts in " + wait[i193] + " seconds!", 561 - ftm.stringWidth("Game starts in " + wait[i193] + " seconds!") / 2, 124);
                                                    if (pgames[im] != ongame) {
                                                        nflk--;
                                                    }
                                                } else if (pgames[im] != ongame) {
                                                    nflk = 3;
                                                }
                                            }
                                            if (pgames[im] != ongame) {
                                                if ("".equals(gplyrs[i193]) || gplyrs[i193].contains(pnames[im])) {
                                                    stringbutton("    Join this Game    ", 561, 182, 0);
                                                } else {
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    ftm = rd.getFontMetrics();
                                                    rd.setColor(new Color(128, 73, 0));
                                                    rd.drawString("Private Game, only specific players allowed.", 561 - ftm.stringWidth("Private Game, only specific players allowed.") / 2, 180);
                                                    stringbutton("    Join this Game    ", 561, -1000, 0);
                                                }
                                            } else if (gmaker[i193].equals(pnames[im])) {
                                                if (npls[i193] > 1) {
                                                    if (!fstart) {
                                                        stringbutton("    Start this Game Now!    ", 561, 182, 0);
                                                    } else {
                                                        stringbutton("    Starting game now, one moment...    ", 561, 182, 0);
                                                    }
                                                } else {
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    ftm = rd.getFontMetrics();
                                                    rd.setColor(new Color(128, 73, 0));
                                                    rd.drawString("You have created this game.", 561 - ftm.stringWidth("You have created this game.") / 2, 180);
                                                }
                                            } else {
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(80, 128, 0));
                                                rd.drawString("You have joined this game.", 561 - ftm.stringWidth("You have joined this game.") / 2, 180);
                                            }
                                        } else {
                                            String string243 = "s";
                                            if (mnpls[i193] - npls[i193] == 1) {
                                                string243 = "";
                                            }
                                            rd.drawString("Waiting for " + (mnpls[i193] - npls[i193]) + " clan member" + string243 + " to join to start.", 561 - ftm.stringWidth("Waiting for " + (mnpls[i193] - npls[i193]) + " clan member" + string243 + " to join to start.") / 2, 72);
                                            int i244 = mnpls[i193] / 2;
                                            int i245 = mnpls[i193] / 2;
                                            for (int i246 = 0; i246 < npo; i246++) {
                                                if (pgames[i246] == gnum[i193]) {
                                                    if (pclan[i246].equalsIgnoreCase(gaclan[i193]) && --i244 < 0) {
                                                        i244 = 0;
                                                    }
                                                    if (pclan[i246].equalsIgnoreCase(gvclan[i193]) && --i245 < 0) {
                                                        i245 = 0;
                                                    }
                                                }
                                            }
                                            rd.setFont(new Font("Arial", 0, 12));
                                            ftm = rd.getFontMetrics();
                                            rd.drawString("(" + i244 + " of " + gaclan[i193] + "  &  " + i245 + " of " + gvclan[i193] + " )", 561 - ftm.stringWidth("(" + i244 + " of " + gaclan[i193] + "  &  " + i245 + " of " + gvclan[i193] + " )") / 2, 87);
                                            rd.drawString(gaclan[i193], 491 - ftm.stringWidth(gaclan[i193]) / 2, 125);
                                            rd.drawString(gvclan[i193], 631 - ftm.stringWidth(gvclan[i193]) / 2, 125);
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            String string247 = "War";
                                            if (gwarb[i193] > 1) {
                                                string247 = "Battle";
                                            }
                                            rd.drawString(string247 + " Score", 561 - ftm.stringWidth(string247 + " Score") / 2, 107);
                                            rd.drawString("" + gascore[i193], 491 - ftm.stringWidth("" + gascore[i193]) / 2, 139);
                                            rd.drawString("" + gvscore[i193], 631 - ftm.stringWidth("" + gascore[i193]) / 2, 139);
                                            rd.drawRect(421, 111, 280, 33);
                                            rd.drawLine(561, 111, 561, 144);
                                            rd.setColor(new Color(255, 128, 0));
                                            rd.drawRect(422, 112, 138, 31);
                                            rd.setColor(new Color(0, 128, 255));
                                            rd.drawRect(562, 112, 138, 31);
                                            if (pgames[im] != ongame) {
                                                if (xt.clan.equalsIgnoreCase(gaclan[i193]) || xt.clan.equalsIgnoreCase(gvclan[i193])) {
                                                    stringbutton("    Join this Game    ", 561, 200, 0);
                                                } else {
                                                    rd.setColor(new Color(128, 73, 0));
                                                    rd.drawString("You must be a member of either clan to join.", 561 - ftm.stringWidth("You must be a member of either clan to join.") / 2, 198);
                                                }
                                            } else {
                                                if (gmaker[i193].equals(pnames[im]) && npls[i193] > 1) {
                                                    stringbutton("    Start this Game Now!    ", 561, -1000, 0);
                                                }
                                                rd.setColor(new Color(80, 128, 0));
                                                rd.drawString("You have joined this game.", 561 - ftm.stringWidth("You have joined this game.") / 2, 198);
                                            }
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            if (gwtyp[i193] == 1) {
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString("This is a normal clan game.", 561 - ftm.stringWidth("This is a normal clan game.") / 2, 161);
                                                rd.setFont(new Font("Arial", 0, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString("Any clan can win by racing or wasting.", 561 - ftm.stringWidth("Any clan can win by racing or wasting.") / 2, 176);
                                            }
                                            if (gwtyp[i193] == 2) {
                                                if (sflk != 0) {
                                                    sflk--;
                                                    rd.setColor(new Color(0, 0, 0));
                                                } else {
                                                    sflk = 3;
                                                    rd.setColor(new Color(117, 67, 0));
                                                }
                                                rd.drawString("This is a racing only game!", 561 - ftm.stringWidth("This is a racing only game!") / 2, 161);
                                                rd.setFont(new Font("Arial", 0, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString("A clan can only win by racing.", 561 - ftm.stringWidth("A clan can only win by racing.") / 2, 176);
                                            }
                                            if (gwtyp[i193] == 3) {
                                                if (sflk != 0) {
                                                    sflk--;
                                                    rd.setColor(new Color(0, 0, 0));
                                                } else {
                                                    sflk = 3;
                                                    rd.setColor(new Color(117, 67, 0));
                                                }
                                                rd.drawString("This is a wasting only game!", 561 - ftm.stringWidth("This is a wasting only game!") / 2, 161);
                                                rd.setFont(new Font("Arial", 0, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString("A clan can only win by wasting.", 561 - ftm.stringWidth("A clan can only win by wasting.") / 2, 176);
                                            }
                                            if (gwtyp[i193] == 4) {
                                                if (sflk != 0) {
                                                    sflk--;
                                                    rd.setColor(new Color(0, 0, 0));
                                                } else {
                                                    sflk = 3;
                                                    rd.setColor(new Color(117, 67, 0));
                                                }
                                                rd.drawString("This is Racers VS Wasters game!", 561 - ftm.stringWidth("This is Racers VS Wasters game!") / 2, 161);
                                                rd.drawString(gaclan[i193] + " wastes & " + gvclan[i193] + " races.", 561 - ftm.stringWidth(gaclan[i193] + " wastes & " + gvclan[i193] + " races.") / 2, 176);
                                            }
                                            if (gwtyp[i193] == 5) {
                                                if (sflk != 0) {
                                                    sflk--;
                                                    rd.setColor(new Color(0, 0, 0));
                                                } else {
                                                    sflk = 3;
                                                    rd.setColor(new Color(117, 67, 0));
                                                }
                                                rd.drawString("This is Racers VS Wasters game!", 561 - ftm.stringWidth("This is Racers VS Wasters game!") / 2, 161);
                                                rd.drawString(gaclan[i193] + " races & " + gvclan[i193] + " wastes.", 561 - ftm.stringWidth(gaclan[i193] + " races & " + gvclan[i193] + " wastes.") / 2, 176);
                                            }
                                        }
                                    } else if (prevloaded == 1) {
                                        int i248 = (int) (80.0 + rerr / 1.243);
                                        if (i248 > 255) {
                                            i248 = 255;
                                        }
                                        if (i248 < 0) {
                                            i248 = 0;
                                        }
                                        int i249 = (int) (128.0 + rerr / 2.428);
                                        if (i249 > 255) {
                                            i249 = 255;
                                        }
                                        if (i249 < 0) {
                                            i249 = 0;
                                        }
                                        int i250 = rerr;
                                        if (i250 > 255) {
                                            i250 = 255;
                                        }
                                        if (i250 < 0) {
                                            i250 = 0;
                                        }
                                        if (wait[i193] == 0) {
                                            rd.setColor(new Color(i248, i249, i250));
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
                                        i220 = 0;
                                        for (int i251 = 0; i251 < prnpo; i251++) {
                                            for (int i252 = 0; i252 < prnpo; i252++) {
                                                if (ppos[i252] == i251) {
                                                    rd.setFont(new Font("Tahoma", 0, 11));
                                                    ftm = rd.getFontMetrics();
                                                    rd.setColor(new Color(0, 44, 124));
                                                    rd.drawString(prnames[i252], 455 - ftm.stringWidth(prnames[i252]) / 2, 83 + 11 * i220);
                                                    if (pdam[i252] < 55 && pdam[i252] != -17) {
                                                        rd.setColor(new Color(80, 128, 0));
                                                        String string253 = "th";
                                                        if (ppos[i252] == 0) {
                                                            string253 = "st";
                                                        }
                                                        if (ppos[i252] == 1) {
                                                            string253 = "nd";
                                                        }
                                                        if (ppos[i252] == 2) {
                                                            string253 = "rd";
                                                        }
                                                        rd.drawString("" + (ppos[i252] + 1) + string253, 515 - ftm.stringWidth("" + (ppos[i252] + 1) + string253) / 2, 83 + 11 * i220);
                                                        rd.setColor(new Color(128, 73, 0));
                                                        if (plap[i252] > gnlaps[i193] - 1) {
                                                            plap[i252] = gnlaps[i193] - 1;
                                                        }
                                                        rd.drawString("" + (plap[i252] + 1) + " / " + gnlaps[i193], 560 - ftm.stringWidth("" + (plap[i252] + 1) + " / " + gnlaps[i193]) / 2, 83 + 11 * i220);
                                                        rd.setColor(new Color(0, 128, 255));
                                                        rd.drawRect(582, 76 + 11 * i220, 56, 6);
                                                        rd.fillRect(583, 79 + 11 * i220, ppow[i252], 3);
                                                        rd.setColor(new Color(128, 210, 255));
                                                        rd.fillRect(583, 77 + 11 * i220, ppow[i252], 2);
                                                        rd.setColor(new Color(255, 0, 0));
                                                        rd.drawRect(645, 76 + 11 * i220, 56, 6);
                                                        rd.fillRect(646, 79 + 11 * i220, pdam[i252], 3);
                                                        rd.setColor(new Color(255, 155, 64));
                                                        rd.fillRect(646, 77 + 11 * i220, pdam[i252], 2);
                                                    } else {
                                                        i248 = (int) (85.0 + rerr * 2 / 1.5);
                                                        if (i248 > 255) {
                                                            i248 = 255;
                                                        }
                                                        if (i248 < 0) {
                                                            i248 = 0;
                                                        }
                                                        rd.setColor(color2k(i248, i248, i248));
                                                        rd.fillRect(490, 75 + 11 * i220, 213, 9);
                                                        rd.setFont(new Font("Tahoma", 1, 11));
                                                        ftm = rd.getFontMetrics();
                                                        i248 = 255 - rerr * 2;
                                                        if (i248 > 255) {
                                                            i248 = 255;
                                                        }
                                                        if (i248 < 0) {
                                                            i248 = 0;
                                                        }
                                                        i249 = (int) (155.0 - rerr * 2 / 1.645);
                                                        if (i249 > 255) {
                                                            i249 = 255;
                                                        }
                                                        if (i249 < 0) {
                                                            i249 = 0;
                                                        }
                                                        i250 = (int) (64.0 - rerr * 2 / 3.984);
                                                        if (i250 > 255) {
                                                            i250 = 255;
                                                        }
                                                        if (i250 < 0) {
                                                            i250 = 0;
                                                        }
                                                        rd.setColor(new Color(i248, i249, i250));
                                                        if (pdam[i252] != -17) {
                                                            rd.drawString("=   =   =   =    W A S T E D    =   =   =   =", 597 - ftm.stringWidth("=   =   =   =    W A S T E D    =   =   =   =") / 2, 84 + 11 * i220);
                                                        } else {
                                                            rd.drawString("=   =   =   DISCONNECTED   =   =   =", 597 - ftm.stringWidth("=   =   =   DISCONNECTED   =   =   =") / 2, 84 + 11 * i220);
                                                        }
                                                    }
                                                    i220++;
                                                }
                                            }
                                        }
                                        if (wait[i193] == 0) {
                                            stringbutton("    Watch Live Now!    ", 561, 196, 0);
                                        } else {
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            int i254 = 186;
                                            if (!"".equals(lapsname) && !"".equals(wastename) && !"".equals(stuntname)) {
                                                i254 = 183;
                                            }
                                            if (gwarb[i193] == 0) {
                                                String string255 = "";
                                                for (int i256 = 0; i256 < prnpo; i256++) {
                                                    if (ppos[i256] == 0) {
                                                        string255 = prnames[i256];
                                                        break;
                                                    }
                                                }
                                                if ("".equals(string255)) {
                                                    rd.drawString("Game Finished!    Nobody Won!", 561 - ftm.stringWidth("Game Finished!    Nobody Won!") / 2, i254);
                                                } else {
                                                    rd.drawString("Game Finished!    Winner:  " + string255, 561 - ftm.stringWidth("Game Finished!    Winner:  " + string255) / 2, i254);
                                                    if (nflk == 0) {
                                                        rd.setColor(new Color(255, 176, 67));
                                                        nflk = 3;
                                                    } else {
                                                        nflk--;
                                                    }
                                                    rd.drawString(string255, 561 - ftm.stringWidth("Game Finished!    Winner:  " + string255) / 2 + ftm.stringWidth("Game Finished!    Winner:  "), i254);
                                                }
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.setFont(new Font("Arial", 0, 11));
                                                ftm = rd.getFontMetrics();
                                                String string257 = "    ";
                                                int i258 = 0;
                                                if (!"".equals(lapsname)) {
                                                    string257 = string257 + "Fastest lap: " + lapsname + "    ";
                                                    i258++;
                                                }
                                                if (!"".equals(wastename)) {
                                                    string257 = string257 + "Deadliest waster: " + wastename + "    ";
                                                    i258++;
                                                }
                                                if (i258 == 2) {
                                                    if (!"".equals(stuntname)) {
                                                        rd.drawString(string257, 561 - ftm.stringWidth(string257) / 2, 199);
                                                        rd.drawString("Best stunt: " + stuntname, 561 - ftm.stringWidth("Best stunt: " + stuntname) / 2, 213);
                                                    } else {
                                                        rd.drawString(string257, 561 - ftm.stringWidth(string257) / 2, 206);
                                                    }
                                                } else {
                                                    if (!"".equals(stuntname)) {
                                                        string257 = string257 + "Best stunt: " + stuntname + "    ";
                                                    }
                                                    rd.drawString(string257, 561 - ftm.stringWidth(string257) / 2, 206);
                                                }
                                            } else if ("".equals(string197)) {
                                                if ("".equals(string)) {
                                                    rd.drawString("Game Finished!    Nobody Won!", 561 - ftm.stringWidth("Game Finished!    Nobody Won!") / 2, 186);
                                                    rd.setFont(new Font("Arial", 1, 11));
                                                    ftm = rd.getFontMetrics();
                                                    rd.drawString(string198, 561 - ftm.stringWidth(string198) / 2, 206);
                                                } else {
                                                    rd.drawString("Game Finished!    " + string + "  Wins!", 561 - ftm.stringWidth("Game Finished!    " + string + "  Wins!") / 2, 196);
                                                    if (nflk == 0) {
                                                        rd.setColor(new Color(255, 176, 67));
                                                        nflk = 3;
                                                    } else {
                                                        nflk--;
                                                    }
                                                    rd.drawString(string, 561 - ftm.stringWidth("Game Finished!    " + string + "  Wins!") / 2 + ftm.stringWidth("Game Finished!    "), 196);
                                                }
                                            } else {
                                                if (nflk == 0) {
                                                    rd.setColor(new Color(255, 176, 67));
                                                    nflk = 3;
                                                } else {
                                                    nflk--;
                                                }
                                                rd.drawString(string197, 561 - ftm.stringWidth(string197) / 2, 196);
                                            }
                                        }
                                        rerr += 3;
                                    } else {
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (prevloaded == -1) {
                                            if (!xt.lan) {
                                                rd.drawString("Loading Info...", 561 - ftm.stringWidth("Loading Info...") / 2, 134);
                                            } else if (pgames[im] == ongame) {
                                                rd.drawString("About to Start...", 561 - ftm.stringWidth("About to Start...") / 2, 134);
                                            } else {
                                                rd.drawString("Game Started", 561 - ftm.stringWidth("Game Started") / 2, 117);
                                                stringbutton("    Watch this Game    ", 561, 154, 0);
                                            }
                                        } else {
                                            rd.drawString("About to Start...", 561 - ftm.stringWidth("About to Start...") / 2, 134);
                                        }
                                    }
                                } else {
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    if (conon == 2) {
                                        rd.drawString("Starting Game Now!", 561 - ftm.stringWidth("Starting Game Now!") / 2, 124);
                                    }
                                    if (conon == 3) {
                                        rd.drawString("Opening Game Now!", 561 - ftm.stringWidth("Opening Game Now!") / 2, 124);
                                    }
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
                                rd.drawString("Laps: " + gnlaps[i193], 660, 235);
                                if (i > 415 && i < 708 && i99 > 222 && i99 < 262 && (wait[i193] > 0 || gstgn[i193] < 0) && conon == 1) {
                                    stringbutton("       Preview Stage       ", 562, 247, 0);
                                    pbtn = 2;
                                } else {
                                    rd.drawString("Stage " + gstgn[i193], 562 - ftm.stringWidth("Stage " + gstgn[i193]) / 2, 237);
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(gstages[i193], 562 - ftm.stringWidth(gstages[i193]) / 2, 254);
                                }
                                if (!xt.lan) {
                                    int i261 = 237;
                                    int i262 = 471;
                                    if (wait[i193] > 0) {
                                        if (mnpls[i193] > 5) {
                                            i261 = 415;
                                            i262 = 293;
                                        }
                                    } else if (npls[i193] > 5) {
                                        i261 = 415;
                                        i262 = 293;
                                    }
                                    rd.setColor(color2k(200, 200, 200));
                                    rd.drawRect(i261, 264, i262, 124);
                                    rd.setColor(color2k(240, 240, 240));
                                    rd.fillRect(i261 + 1, 265, i262 - 1, 21);
                                    rd.drawImage(xt.gmc, i261 + 7, 269, null);
                                    rd.setFont(new Font("Tahoma", 0, 11));
                                    rd.setColor(color2k(110, 110, 110));
                                    rd.drawString("(Game Chat )", i261 + 57, 278);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (updatec != -1) {
                                        final String[] strings = new String[7];
                                        final String[] strings263 = new String[7];
                                        final boolean[] bools = {
                                                false, false, false, false, false, false, false
                                        };
                                        for (int i264 = 0; i264 < 7; i264++) {
                                            strings[i264] = "";
                                            strings263[i264] = cnames[i264];
                                            int i265 = 0;
                                            int i266 = 0;
                                            int i267 = 0;
                                            int i268 = 0;
                                            int i269 = 0;
                                            for (; i265 < sentn[i264].length(); i265++) {
                                                final String string270 = "" + sentn[i264].charAt(i265);
                                                if (" ".equals(string270)) {
                                                    i266 = i267;
                                                    i268 = i265;
                                                    i269++;
                                                } else {
                                                    i269 = 0;
                                                }
                                                if (i269 <= 1) {
                                                    final StringBuilder stringbuilder = new StringBuilder();
                                                    final String[] strings271 = strings;
                                                    final int i272 = i264;
                                                    strings271[i272] = stringbuilder + strings271[i272] + string270;
                                                    i267++;
                                                    if (ftm.stringWidth(strings[i264]) > i262 - 94) {
                                                        if (i266 != 0) {
                                                            strings[i264] = strings[i264].substring(0, i266);
                                                            for (int i273 = 0; i273 < i264; i273++) {
                                                                strings[i273] = strings[i273 + 1];
                                                                strings263[i273] = strings263[i273 + 1];
                                                                bools[i273] = bools[i273 + 1];
                                                            }
                                                            strings[i264] = "";
                                                            bools[i264] = true;
                                                            i265 = i268;
                                                            i267 = 0;
                                                            i266 = 0;
                                                        } else {
                                                            strings[i264] = "";
                                                            i267 = 0;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        String string274 = "";
                                        rd.setFont(new Font("Tahoma", 1, 11));
                                        ftm = rd.getFontMetrics();
                                        for (int i275 = 0; i275 < 7; i275++) {
                                            if (!string274.equals(strings263[i275])) {
                                                rd.drawString(strings263[i275] + ":", i261 + 84 - ftm.stringWidth(strings263[i275] + ":"), 299 + i275 * 14);
                                                string274 = strings263[i275];
                                            }
                                        }
                                        rd.setFont(new Font("Tahoma", 0, 11));
                                        for (int i276 = 0; i276 < 7; i276++) {
                                            if (bools[i276] && i276 == 0 && strings[i276].contains(" ")) {
                                                strings[i276] = "..." + strings[i276].substring(strings[i276].indexOf(" "), strings[i276].length());
                                            }
                                            rd.drawString(strings[i276], i261 + 88, 299 + i276 * 14);
                                        }
                                    } else {
                                        rd.drawString("Loading chat...", i261 + i262 / 2 - ftm.stringWidth("Loading chat...") / 2, 315);
                                    }
                                    if (conon == 1) {
                                        pre2 = true;
                                    } else {
                                        hideinputs();
                                    }
                                    if (control.enter && !"Type here...".equals(gs.cmsg.getText()) && !"".equals(gs.cmsg.getText())) {
                                        pessd[btn] = true;
                                        control.enter = false;
                                        String string277 = gs.cmsg.getText().replace('|', ':');
                                        if (string277.toLowerCase().contains(gs.tpass.getText().toLowerCase())) {
                                            string277 = " ";
                                        }
                                        if (!xt.msgcheck(string277) && updatec > -12) {
                                            for (int i278 = 0; i278 < 6; i278++) {
                                                sentn[i278] = sentn[i278 + 1];
                                                cnames[i278] = cnames[i278 + 1];
                                            }
                                            sentn[6] = string277;
                                            cnames[6] = pnames[im];
                                            if (updatec > -11) {
                                                updatec = -11;
                                            } else {
                                                updatec--;
                                            }
                                        } else {
                                            xt.warning++;
                                        }
                                        gs.cmsg.setText("");
                                    }
                                    stringbutton("Send Message", 655, 405, 3);
                                }
                            } else {
                                if (gs.cmsg.isShowing()) {
                                    gs.cmsg.setVisible(false);
                                }
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
                                        if (flks > 3) {
                                            flks = -1;
                                        }
                                    } else {
                                        rd.setColor(new Color(224, 226, 176));
                                        flks--;
                                        if (flks < -4) {
                                            flks = 0;
                                        }
                                    }
                                    rd.fillRect(445, 120, 233, 127);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.drawString(cd.names[forcar], 561 - ftm.stringWidth(cd.names[forcar]) / 2, 117);
                                    for (int i279 = 0; i279 < dispco.npl; i279++) {
                                        if (contos[forcar].p[i279].colnum == 1) {
                                            dispco.p[i279].hsb[0] = pcols[dispcar][0];
                                            dispco.p[i279].hsb[1] = pcols[dispcar][1];
                                            dispco.p[i279].hsb[2] = 1.0F - pcols[dispcar][2];
                                        }
                                        if (contos[forcar].p[i279].colnum == 2) {
                                            dispco.p[i279].hsb[0] = pcols[dispcar][3];
                                            dispco.p[i279].hsb[1] = pcols[dispcar][4];
                                            dispco.p[i279].hsb[2] = 1.0F - pcols[dispcar][5];
                                        }
                                    }
                                    m.cx = 561;
                                    dispco.z = 1200;
                                    dispco.y = 605 - dispco.grat;
                                    dispco.x = 225;
                                    dispco.zy = 0;
                                    dispco.xz = mrot;
                                    mrot -= 5;
                                    if (mrot < -360) {
                                        mrot += 360;
                                    }
                                    dispco.xy = 0;
                                    dispco.wzy -= 10;
                                    if (dispco.wzy < -45) {
                                        dispco.wzy += 45;
                                    }
                                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                    dispco.d(rd);
                                    rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                    m.cx = 400;
                                    rd.setFont(new Font("Arial", 1, 11));
                                    int i280 = 424;
                                    int i281 = -55;
                                    rd.setColor(new Color(0, 63, 128));
                                    rd.drawString("Top Speed:", 30 + i280, 318 + i281);
                                    rd.drawImage(xt.statb, 97 + i280, 312 + i281, null);
                                    rd.drawString("Acceleration:", 20 + i280, 333 + i281);
                                    rd.drawImage(xt.statb, 97 + i280, 327 + i281, null);
                                    rd.setColor(color2k(255, 255, 255));
                                    float f = (cd.swits[forcar][2] - 220) / 90.0F;
                                    if (f < 0.2) {
                                        f = 0.2F;
                                    }
                                    rd.fillRect((int) (97.0F + 156.0F * f) + i280, 312 + i281, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    f = cd.acelf[forcar][1] * cd.acelf[forcar][0] * cd.acelf[forcar][2] * cd.grip[forcar] / 7700.0F;
                                    if (f > 1.0F) {
                                        f = 1.0F;
                                    }
                                    rd.fillRect((int) (97.0F + 156.0F * f) + i280, 327 + i281, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    rd.drawImage(xt.statbo, 97 + i280, 312 + i281, null);
                                    rd.drawImage(xt.statbo, 97 + i280, 327 + i281, null);
                                    i280 = 50;
                                    i281 = -25;
                                    rd.setColor(new Color(0, 63, 128));
                                    rd.drawString("Stunts:", 427 + i280, 318 + i281);
                                    rd.drawImage(xt.statb, 471 + i280, 312 + i281, null);
                                    rd.drawString("Strength:", 415 + i280, 333 + i281);
                                    rd.drawImage(xt.statb, 471 + i280, 327 + i281, null);
                                    rd.drawString("Endurance:", 405 + i280, 348 + i281);
                                    rd.drawImage(xt.statb, 471 + i280, 342 + i281, null);
                                    rd.setColor(color2k(255, 255, 255));
                                    f = (cd.airc[forcar] * cd.airs[forcar] * cd.bounce[forcar] + 28.0F) / 139.0F;
                                    if (f > 1.0F) {
                                        f = 1.0F;
                                    }
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i280, 312 + i281, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    final float f282 = 0.5F;
                                    f = (cd.moment[forcar] + f282) / 2.6F;
                                    if (f > 1.0F) {
                                        f = 1.0F;
                                    }
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i280, 327 + i281, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    f = cd.outdam[forcar];
                                    rd.fillRect((int) (471.0F + 156.0F * f) + i280, 342 + i281, (int) (156.0F * (1.0F - f) + 1.0F), 7);
                                    rd.drawImage(xt.statbo, 471 + i280, 312 + i281, null);
                                    rd.drawImage(xt.statbo, 471 + i280, 327 + i281, null);
                                    rd.drawImage(xt.statbo, 471 + i280, 342 + i281, null);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (forcar < 16) {
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("Created by Radicalplay.com", 561 - ftm.stringWidth("Created by Radicalplay.com") / 2, 347);
                                        String string283 = "Game Car";
                                        if (cd.cclass[forcar] == 0) {
                                            string283 = "Class C ,  Game Car";
                                        }
                                        if (cd.cclass[forcar] == 1) {
                                            string283 = "Class B & C ,  Game Car";
                                        }
                                        if (cd.cclass[forcar] == 2) {
                                            string283 = "Class B ,  Game Car";
                                        }
                                        if (cd.cclass[forcar] == 3) {
                                            string283 = "Class A & B ,  Game Car";
                                        }
                                        if (cd.cclass[forcar] == 4) {
                                            string283 = "Class A ,  Game Car";
                                        }
                                        rd.drawString(string283, 561 - ftm.stringWidth(string283) / 2, 367);
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.drawString("You already have this car.", 561 - ftm.stringWidth("You already have this car.") / 2, 395);
                                    } else {
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        if (!cd.createdby[forcar - 16].equals(xt.nickname)) {
                                            rd.drawString("Created by :  " + cd.createdby[forcar - 16], 561 - ftm.stringWidth("Created by :  " + cd.createdby[forcar - 16]) / 2, 347);
                                            final int i284 = ftm.stringWidth(cd.createdby[forcar - 16]);
                                            final int i285 = 561 - ftm.stringWidth("Created by :  " + cd.createdby[forcar - 16]) / 2 + ftm.stringWidth("Created by :  " + cd.createdby[forcar - 16]) - i284;
                                            rd.drawLine(i285, 349, i285 + i284 - 2, 349);
                                            if (i > i285 - 2 && i < i285 + i284 && i99 > 334 && i99 < 351) {
                                                i101 = 12;
                                            }
                                        } else {
                                            rd.drawString("Created by You", 561 - ftm.stringWidth("Created by You") / 2, 347);
                                        }
                                        rd.setColor(new Color(128, 73, 0));
                                        String string286 = "";
                                        if (cd.cclass[forcar] == 0) {
                                            string286 = "Class C ,  ";
                                        }
                                        if (cd.cclass[forcar] == 1) {
                                            string286 = "Class B & C ,  ";
                                        }
                                        if (cd.cclass[forcar] == 2) {
                                            string286 = "Class B ,  ";
                                        }
                                        if (cd.cclass[forcar] == 3) {
                                            string286 = "Class A & B ,  ";
                                        }
                                        if (cd.cclass[forcar] == 4) {
                                            string286 = "Class A ,  ";
                                        }
                                        if (cd.publish[forcar - 16] == 0) {
                                            string286 = string286 + "Private Car";
                                        }
                                        if (cd.publish[forcar - 16] == 1) {
                                            string286 = string286 + "Public Car";
                                            rd.setColor(new Color(0, 64, 128));
                                        }
                                        if (cd.publish[forcar - 16] == 2) {
                                            string286 = string286 + "Super Public Car";
                                            rd.setColor(new Color(0, 64, 128));
                                        }
                                        rd.drawString(string286, 561 - ftm.stringWidth(string286) / 2, 367);
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.setFont(new Font("Arial", 0, 12));
                                        ftm = rd.getFontMetrics();
                                        if (cd.publish[forcar - 16] == 1 || cd.publish[forcar - 16] == 2) {
                                            if (cd.action == -9) {
                                                rd.drawString("Failed to add car!  Unknown error!", 561 - ftm.stringWidth("Failed to add car!  Unknown error!") / 2, 395);
                                            }
                                            if (cd.action == -8) {
                                                rd.drawString("Failed!  You already have 20 cars!", 561 - ftm.stringWidth("Failed!  You already have 20 cars!") / 2, 395);
                                            }
                                            if (cd.action == 7) {
                                                rd.drawString(cd.names[cd.ac] + " has been added to your cars!", 561 - ftm.stringWidth(cd.names[cd.ac] + " has been added to your cars!") / 2, 395);
                                            }
                                            if (cd.action == -7) {
                                                rd.drawString("You already have this car.", 561 - ftm.stringWidth("You already have this car.") / 2, 395);
                                            }
                                            if (cd.action == 6) {
                                                rd.drawString("Adding Car...", 561 - ftm.stringWidth("Adding Car...") / 2, 395);
                                            }
                                            if (cd.action == -6) {
                                                final String string287 = "Upgrade to a full account to add custom cars!";
                                                final int i288 = 561 - ftm.stringWidth(string287) / 2;
                                                final int i289 = i288 + ftm.stringWidth(string287);
                                                rd.drawString(string287, i288, 395);
                                                if (waitlink != -1) {
                                                    rd.drawLine(i288, 396, i289, 396);
                                                }
                                                if (i > i288 && i < i289 && i99 > 384 && i99 < 397) {
                                                    if (waitlink != -1) {
                                                        i101 = 12;
                                                    }
                                                    if (bool && waitlink == 0) {
                                                        gs.editlink(xt.nickname, true);
                                                        waitlink = -1;
                                                    }
                                                }
                                                if (waitlink > 0) {
                                                    waitlink--;
                                                }
                                            }
                                            if (cd.action == 0 && xt.drawcarb(true, null, " Add to My Cars ", 503, 375, i, i99, bool)) {
                                                if (xt.logged) {
                                                    if (cd.lastload != 2 || forcar >= 36) {
                                                        cd.action = 6;
                                                        cd.ac = forcar;
                                                        cd.sparkactionloader();
                                                    } else {
                                                        cd.action = -7;
                                                    }
                                                } else {
                                                    cd.action = -6;
                                                    waitlink = 20;
                                                }
                                            }
                                        } else {
                                            rd.drawString("Private Car.  Cannot be added to account.", 561 - ftm.stringWidth("Private Car.  Cannot be added to account.") / 2, 395);
                                        }
                                    }
                                    if (xt.drawcarb(true, null, "X", 682, 99, i, i99, bool)) {
                                        dispcar = -1;
                                    }
                                } else {
                                    dispcar = -1;
                                }
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
                        int i290 = 0;
                        if (ontyp >= 10) {
                            i290 = 10;
                            string = "Custom Cars";
                            if (ontyp > 10) {
                                string = string + ", ";
                            }
                        }
                        if (ontyp >= 20) {
                            i290 = 20;
                            string = "Game Cars";
                            if (ontyp > 20) {
                                string = string + ", ";
                            }
                        }
                        if (ontyp >= 30) {
                            i290 = 30;
                            string = "Clan Cars";
                            if (ontyp > 30) {
                                string = string + ", ";
                            }
                        }
                        if (ontyp - i290 == 1) {
                            string = string + "Class C";
                        }
                        if (ontyp - i290 == 2) {
                            string = string + "Class B & C";
                        }
                        if (ontyp - i290 == 3) {
                            string = string + "Class B";
                        }
                        if (ontyp - i290 == 4) {
                            string = string + "Class A & B";
                        }
                        if (ontyp - i290 == 5) {
                            string = string + "Class A";
                        }
                        if (ontyp <= -2) {
                            if (Math.abs(ontyp + 2) == 13) {
                                string = " " + cd.names[Math.abs(ontyp + 2)] + "  Game";
                            } else {
                                string = cd.names[Math.abs(ontyp + 2)] + " Game";
                            }
                        }
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(": :   " + string + "   : :", 400 - ftm.stringWidth(": :   " + string + "   : :") / 2, 175);
                        string = "a";
                        if (ontyp - i290 == 1) {
                            string = "a class C";
                        }
                        if (ontyp - i290 == 2) {
                            string = "a class B or C";
                        }
                        if (ontyp - i290 == 3) {
                            string = "a class B";
                        }
                        if (ontyp - i290 == 4) {
                            string = "a class A or B";
                        }
                        if (ontyp - i290 == 5) {
                            string = "a class A";
                        }
                        if (i290 == 0) {
                            string = string + " car";
                        }
                        if (i290 == 10) {
                            string = string + " custom car";
                        }
                        if (i290 == 20) {
                            string = string + " game car";
                        }
                        if (i290 == 30) {
                            string = string + " clan car";
                        }
                        if (ontyp <= -2) {
                            if (Math.abs(ontyp + 2) == 13) {
                                string = " " + cd.names[Math.abs(ontyp + 2)] + " ";
                            } else {
                                string = cd.names[Math.abs(ontyp + 2)];
                            }
                        }
                        rd.drawString("To join this game you need to have " + string + "!", 400 - ftm.stringWidth("To join this game you need to have " + string + "!") / 2, 206);
                        stringbutton("  Get " + string + " now  ", 400, 247, 0);
                        stringbutton("  Cancel X  ", 593, 259, 2);
                        //if (gb.open > 0 && gb.upo)
                        //	onjoin = -1;
                    } else {
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(": :   Custom Stage   : :", 400 - ftm.stringWidth(": :   Custom Stage   : :") / 2, 175);
                        rd.drawString("You need to upgrade to a full account to join this game!", 400 - ftm.stringWidth("You need to upgrade to a full account to join this game!") / 2, 202);
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
                if (f > 1.0F) {
                    f = 1.0F;
                }
                if (f < 0.0F) {
                    f = 0.0F;
                }
                rd.setComposite(AlphaComposite.getInstance(3, f));
                if (lg.flipo > 10) {
                    rd.drawImage(xt.logomadnes, 97 + (int) (2.0 - ThreadLocalRandom.current().nextDouble() * 4.0), 36 + (int) (2.0 - ThreadLocalRandom.current().nextDouble() * 4.0), null);
                } else {
                    rd.drawImage(xt.logomadnes, 97, 36, null);
                }
                lg.flipo++;
                if (lg.flipo > 50) {
                    lg.flipo = 0;
                }
                final int i291 = 30;
                rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                rd.setColor(new Color(203, 227, 253));
                rd.fillRoundRect(115, 57 + i291, 570, 307, 20, 20);
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                rd.setColor(color2k(90, 90, 90));
                rd.drawRoundRect(115, 57 + i291, 570, 307, 20, 20);
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                rd.setColor(color2k(0, 0, 0));
                rd.drawString("You are allowed 5 multiplayer turns per day to try the game with your trial account.", 135, 85 + i291);
                rd.drawString("Upgrade your account to a full account to purchase and play the multiplayer game.", 135, 105 + i291);
                drawSbutton(xt.upgrade, 400, 130 + i291);
                rd.setColor(new Color(30, 70, 110));
                rd.drawString("You can upgrade your account by just sharing the game & posting about it online!", 135, 165 + i291);
                rd.drawString("Click 'Upgrade' for more details.", 135, 185 + i291);
                rd.drawString("Or try the multiplayer again tomorrow.", 135, 205 + i291);
                rd.setColor(color2k(0, 0, 0));
                rd.drawString("For now to preview and try the multiplayer more, with your trial account you can:", 135, 245 + i291);
                rd.setColor(new Color(30, 70, 110));
                rd.drawString("-  Watch online multiplayer games.", 135, 265 + i291);
                rd.drawString("-  Access the multiplayer dome.", 135, 285 + i291);
                rd.drawString("-  Play LAN multiplayer games (unlimitedly).", 135, 305 + i291);
                drawSbutton(xt.exit, 400, 336 + i291);
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
                }
            }
            xt.warning++;
        }
        if (i101 != pcurs) {
            gs.setCursor(new Cursor(i101));
            pcurs = i101;
        }
    }

    void preforma(final int i, final int i292) {
        if (pre1) {
            boolean bool = false;
            if (!gs.openm/* && gb.open == 0 */) {
                if (conon != 0) {
                    bool = true;
                }
            } else if (gs.cmsg.isShowing()) {
                gs.cmsg.setVisible(false);
            }
            gs.movefieldd(gs.cmsg, 235, 390, 360, 22, bool);
            if ("Type here...".equals(gs.cmsg.getText()) && i > 234 && i < 603 && i292 > 385 && i292 < 417) {
                gs.cmsg.setText("");
            }
        }
        if (pre2) {
            boolean bool = false;
            if (!gs.openm/* && gb.open == 0 */) {
                bool = true;
            } else if (gs.cmsg.isShowing()) {
                gs.cmsg.setVisible(false);
            }
            gs.movefieldd(gs.cmsg, 237, 390, 360, 22, bool);
            if ("Type here...".equals(gs.cmsg.getText()) && i > 232 && i < 601 && i292 > 385 && i292 < 417) {
                gs.cmsg.setText("");
            }
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
            if (!lloaded) {
                gs.setCursor(new Cursor(3));
            }
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
                int i1 = -1;
                for (int i2 = 0; i2 < ngm; i2++) {
                    if (join == gnum[i2] || pgames[im] == gnum[i2]) {
                        i1 = i2;
                    }
                }
                if (i1 != -1) {
                    boolean bool = false;
                    ontyp = 0;
                    if (gcrs[i1] == 1 && pcars[im] < 16) {
                        bool = true;
                        ontyp = 10;
                        if (gclss[i1] > 0 && gclss[i1] <= 5) {
                            ontyp += gclss[i1];
                        }
                    }
                    if (gcrs[i1] == 2 && pcars[im] >= 16) {
                        bool = true;
                        ontyp = 20;
                        if (gclss[i1] > 0 && gclss[i1] <= 5) {
                            ontyp += gclss[i1];
                        }
                    }
                    if (gcrs[i1] == 1 && gwarb[i1] != 0 && xt.sc[0] != 36) {
                        bool = true;
                        ontyp = 30;
                        if (gclss[i1] > 0 && gclss[i1] <= 5) {
                            ontyp += gclss[i1];
                        }
                    }
                    if (gclss[i1] > 0 && gclss[i1] <= 5 && Math.abs(cd.cclass[pcars[im]] - (gclss[i1] - 1)) > 1) {
                        bool = true;
                        if (gcrs[i1] == 1) {
                            if (gwarb[i1] == 0) {
                                ontyp = 10;
                            } else {
                                ontyp = 30;
                            }
                        }
                        if (gcrs[i1] == 2) {
                            ontyp = 20;
                        }
                        ontyp += gclss[i1];
                    }
                    if (gclss[i1] <= -2 && pcars[im] != Math.abs(gclss[i1] + 2)) {
                        bool = true;
                        ontyp = gclss[i1];
                    }
                    if (gstgn[i1] == -2 && !xt.logged) {
                        bool = true;
                        ontyp = 76;
                    }
                    if (bool) {
                        onjoin = gnum[i1];
                        jflexo = false;
                        if (join >= 0) {
                            join = -1;
                        }
                        if (pgames[im] != -1) {
                            join = -2;
                        }
                    }
                }
            }
            if (xt.onjoin != -1) {
                join = xt.onjoin;
                ongame = xt.onjoin;
                xt.onjoin = -1;
            }
            if (updatec < -17) {
                updatec = -17;
            }
            boolean bool = false;
            if (lloaded) {
                i = pgames[im];
                if (i != -1) {
                    for (int i3 = 0; i3 < ngm; i3++) {
                        if (i == gnum[i3]) {
                            laps = gnlaps[i3];
                            stage = gstgn[i3];
                            stagename = gstages[i3];
                            nfix = gfx[i3];
                            notb = gntb[i3] == 1;
                        }
                    }
                }
            }
            String string = "" + xt.sc[0];
            if (xt.sc[0] >= xtGraphics.nCars) {
                string = "C" + cd.names[xt.sc[0]];
            }
            String string4 = "1|" + xt.nickname + ":" + xt.nickey + "|" + xt.clan + "|" + xt.clankey + "|" + string + "|" + join + "|" + (int) (xt.arnp[0] * 100.0F) + "|" + (int) (xt.arnp[1] * 100.0F) + "|" + (int) (xt.arnp[2] * 100.0F) + "|" + (int) (xt.arnp[3] * 100.0F) + "|" + (int) (xt.arnp[4] * 100.0F) + "|" + (int) (xt.arnp[5] * 100.0F) + "|" + ongame + "|";
            if (!xt.lan) {
                string4 = string4 + updatec + "|";
                if (updatec <= -11) {
                    for (int i5 = 0; i5 < -updatec - 10; i5++) {
                        string4 = string4 + cnames[6 - i5] + "|" + sentn[6 - i5] + "|";
                    }
                    updatec = -2;
                }
            } else {
                String string6 = "Nonex";
                try {
                    string6 = InetAddress.getLocalHost().getHostName();
                    if (string6.contains("|")) {
                        string6 = InetAddress.getLocalHost().getHostAddress();
                    }
                } catch (final Exception exception) {
                    string6 = "Nonex";
                }
                int i7 = 0;
                if (xt.logged) {
                    i7 = 1;
                }
                string4 = string4 + string6 + "|" + i7 + "|";
            }
            if (fstart) {
                string4 = string4 + "3|";
                bool = true;
            }
            if (chalngd == -5 && !fstart) {
                string4 = string4 + "11|" + gstage + "|" + gstagename + "|" + gstagelaps + "|" + gnpls + "|" + gwait + "|" + pnames[im] + "|" + gcars + "|" + gclass + "|" + gfix + "|" + gnotp + "|" + gplayers + "|";
                if (xt.lan) {
                    string4 = string4 + gnbts + "|";
                }
            }
            if (ongame != -1 && chalngd != -5 && !fstart) {
                boolean bool8 = false;
                for (int i9 = 0; i9 < 7; i9++) {
                    if (!"".equals(invos[i9]) && !dinvi[i9].equals(invos[i9])) {
                        if (!bool8) {
                            string4 = string4 + "2|" + ongame + "|";
                            bool8 = true;
                        }
                        string4 = string4 + invos[i9] + "|";
                        dinvi[i9] = invos[i9];
                    }
                }
            }
            String string10 = "";
            boolean bool11 = false;
            try {
                dout.println(string4);
                string10 = din.readLine();
                if (string10 == null) {
                    bool11 = true;
                }
            } catch (final Exception exception) {
                bool11 = true;
            }
            if (bool11) {
                try {
                    socket.close();
                    socket = null;
                    din.close();
                    din = null;
                    dout.close();
                    dout = null;
                } catch (final Exception exception) {
                }
                try {
                    socket = new Socket(xt.server, xt.servport);
                    din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    dout = new PrintWriter(socket.getOutputStream(), true);
                    dout.println(string4);
                    string10 = din.readLine();
                    if (string10 != null) {
                        bool11 = false;
                    }
                } catch (final Exception exception) {
                }
            }
            if (bool11) {
                try {
                    socket.close();
                    socket = null;
                } catch (final Exception exception) {
                }
                conon = 0;
                lg.exitfromlobby();
                hideinputs();
                connector.stop();
            }
            if (regnow && join == -2) {
                join = -1;
            }
            npo = getvalue(string10, 0);
            if (npo < 0) {
                npo = 0;
            }
            im = getvalue(string10, 1);
            if (im < 0) {
                im = 0;
            }
            for (int i12 = 0; i12 < npo; i12++) {
                pnames[i12] = getSvalue(string10, 2 + i12 * 10);
                if ("".equals(pnames[i12])) {
                    pnames[i12] = "Unknown";
                }
                final String string13 = getSvalue(string10, 3 + i12 * 10);
                if (string13.startsWith("C")) {
                    pcarnames[i12] = string13.substring(1);
                    if (!"".equals(pcarnames[i12])) {
                        int i14 = 0;
                        for (int i15 = 16; i15 < 56; i15++) {
                            if (pcarnames[i12].equals(cd.names[i15])) {
                                i14 = i15;
                                break;
                            }
                        }
                        if (i14 == 0) {
                            pcars[i12] = -1;
                            boolean bool16 = false;
                            for (int i17 = 0; i17 < cd.nl; i17++) {
                                if (pcarnames[i12].equals(cd.loadnames[i17])) {
                                    bool16 = true;
                                }
                            }
                            if (!bool16 && cd.nl < 20 && cd.nl >= 0) {
                                cd.loadnames[cd.nl] = pcarnames[i12];
                                cd.nl++;
                            }
                            cd.sparkcarloader();
                        } else {
                            pcars[i12] = i14;
                        }
                    } else {
                        pcars[i12] = 0;
                        pcarnames[i12] = cd.names[pcars[i12]];
                    }
                } else {
                    pcars[i12] = getvalue(string10, 3 + i12 * 10);
                    if (pcars[i12] == -1) {
                        pcars[i12] = 0;
                    }
                    pcarnames[i12] = cd.names[pcars[i12]];
                }
                pclan[i12] = getSvalue(string10, 4 + i12 * 10);
                pgames[i12] = getvalue(string10, 5 + i12 * 10);
                pcols[i12][0] = getvalue(string10, 6 + i12 * 10) / 100.0F;
                if (pcols[i12][0] == -1.0F) {
                    pcols[i12][0] = 0.0F;
                }
                pcols[i12][1] = getvalue(string10, 7 + i12 * 10) / 100.0F;
                if (pcols[i12][1] == -1.0F) {
                    pcols[i12][1] = 0.0F;
                }
                pcols[i12][2] = getvalue(string10, 8 + i12 * 10) / 100.0F;
                if (pcols[i12][2] == -1.0F) {
                    pcols[i12][2] = 0.0F;
                }
                pcols[i12][3] = getvalue(string10, 9 + i12 * 10) / 100.0F;
                if (pcols[i12][3] == -1.0F) {
                    pcols[i12][3] = 0.0F;
                }
                pcols[i12][4] = getvalue(string10, 10 + i12 * 10) / 100.0F;
                if (pcols[i12][4] == -1.0F) {
                    pcols[i12][4] = 0.0F;
                }
                pcols[i12][5] = getvalue(string10, 11 + i12 * 10) / 100.0F;
                if (pcols[i12][5] == -1.0F) {
                    pcols[i12][5] = 0.0F;
                }
            }
            int i18 = 12 + (npo - 1) * 10;
            ngm = getvalue(string10, i18);
            if (ngm < 0) {
                ngm = 0;
            }
            int i19 = 12;
            if (xt.lan) {
                i19 = 13;
            }
            for (int i20 = 0; i20 < ngm; i20++) {
                gnum[i20] = getvalue(string10, i18 + 1 + i20 * i19);
                gstgn[i20] = getvalue(string10, i18 + 2 + i20 * i19);
                gstgn[i20] = Math.abs(gstgn[i20]);
                if (gstgn[i20] > 100) {
                    gstgn[i20] = -2;
                }
                gstages[i20] = getSvalue(string10, i18 + 3 + i20 * i19);
                gnlaps[i20] = getvalue(string10, i18 + 4 + i20 * i19);
                mnpls[i20] = getvalue(string10, i18 + 5 + i20 * i19);
                wait[i20] = getvalue(string10, i18 + 6 + i20 * i19);
                gmaker[i20] = getSvalue(string10, i18 + 7 + i20 * i19);
                gcrs[i20] = getvalue(string10, i18 + 8 + i20 * i19);
                gclss[i20] = getvalue(string10, i18 + 9 + i20 * i19);
                gfx[i20] = getvalue(string10, i18 + 10 + i20 * i19);
                gntb[i20] = getvalue(string10, i18 + 11 + i20 * i19);
                gplyrs[i20] = getSvalue(string10, i18 + 12 + i20 * i19);
                if (gplyrs[i20].startsWith("#warb#")) {
                    gwarb[i20] = getHvalue(gplyrs[i20], 2);
                    gwarbnum[i20] = getHSvalue(gplyrs[i20], 3);
                    gameturn[i20] = getHvalue(gplyrs[i20], 4);
                    gaclan[i20] = getHSvalue(gplyrs[i20], 5);
                    gvclan[i20] = getHSvalue(gplyrs[i20], 6);
                    gascore[i20] = getHvalue(gplyrs[i20], 7);
                    gvscore[i20] = getHvalue(gplyrs[i20], 8);
                    gwtyp[i20] = getHvalue(gplyrs[i20], 9);
                    if (gwtyp[i20] < 1 || gwtyp[i20] > 5) {
                        gwtyp[i20] = 1;
                    }
                    gplyrs[i20] = "";
                } else {
                    gwarb[i20] = 0;
                    gwarbnum[i20] = "";
                    gameturn[i20] = 0;
                    gaclan[i20] = "";
                    gvclan[i20] = "";
                    gascore[i20] = 0;
                    gvscore[i20] = 0;
                    gwtyp[i20] = 0;
                }
                if (xt.lan) {
                    mnbts[i20] = getvalue(string10, i18 + 13 + i20 * i19);
                }
                if (xt.playingame > -1 && xt.playingame == gnum[i20] && !xt.lan) {
                    ongame = gnum[i20];
                }
                if (i == gnum[i20] && wait[i20] == 0 && lloaded && i != -1) {
                    for (int i21 = 0; i21 < npo; i21++) {
                        if (pgames[i21] == gnum[i20] && pnames[i21].equals(xt.nickname)) {
                            im = i21;
                            break;
                        }
                    }
                    conon = 2;
                    gs.setCursor(new Cursor(3));
                }
            }
            for (int i22 = 0; i22 < ngm; i22++) {
                npls[i22] = 0;
                for (int i23 = 0; i23 < npo; i23++) {
                    if (pgames[i23] == gnum[i22]) {
                        npls[i22]++;
                    }
                }
            }
            if (conon != 0 && xt.playingame != -1) {
                xt.playingame = -1;
            }
            if (ongame != -1) {
                boolean bool24 = false;
                for (int i25 = 0; i25 < ngm; i25++) {
                    if (ongame == gnum[i25]) {
                        bool24 = true;
                    }
                }
                if (!bool24) {
                    britchl = -1;
                }
            }
            if (join > -1) {
                boolean bool26 = false;
                for (int i27 = 0; i27 < ngm; i27++) {
                    if (join == gnum[i27]) {
                        bool26 = true;
                    }
                }
                if (!bool26) {
                    join = -1;
                }
            }
            for (int i28 = 0; i28 < npo; i28++) {
                if (pgames[i28] != -1) {
                    boolean bool29 = false;
                    for (int i30 = 0; i30 < ngm; i30++) {
                        if (pgames[i28] == gnum[i30]) {
                            bool29 = true;
                        }
                    }
                    if (!bool29) {
                        pgames[i28] = -1;
                    }
                }
            }
            if (xt.lan) {
                i18 += 14 + (ngm - 1) * 13;
            } else {
                i18 += 13 + (ngm - 1) * 12;
            }
            if (!xt.lan) {
                final int i31 = getvalue(string10, i18);
                final int i32 = getvalue(string10, i18 + 1);
                i18 += 2;
                if (updatec != i31 && updatec >= -2 && i32 == ongame) {
                    for (int i33 = 0; i33 < 7; i33++) {
                        cnames[i33] = getSvalue(string10, i18 + i33 * 2);
                        sentn[i33] = getSvalue(string10, i18 + 1 + i33 * 2);
                    }
                    updatec = i31;
                    i18 += 14;
                }
                if (ongame != -1) {
                    if (prevloaded != -1) {
                        prevloaded = -1;
                    }
                    boolean bool34 = false;
                    for (int i35 = 0; i35 < ngm; i35++) {
                        if (ongame == gnum[i35] && wait[i35] <= 0) {
                            bool34 = true;
                        }
                    }
                    if (bool34) {
                        prevloaded = getvalue(string10, i18);
                        i18++;
                        if (prevloaded == 1) {
                            prnpo = getvalue(string10, i18);
                            i18++;
                            for (int i36 = 0; i36 < prnpo; i36++) {
                                prnames[i36] = getSvalue(string10, i18);
                                i18++;
                            }
                            for (int i37 = 0; i37 < prnpo; i37++) {
                                ppos[i37] = getvalue(string10, i18);
                                i18++;
                            }
                            for (int i38 = 0; i38 < prnpo; i38++) {
                                plap[i38] = getvalue(string10, i18);
                                i18++;
                            }
                            for (int i39 = 0; i39 < prnpo; i39++) {
                                ppow[i39] = (int) (getvalue(string10, i18) / 9800.0F * 55.0F);
                                i18++;
                            }
                            for (int i40 = 0; i40 < prnpo; i40++) {
                                final int i41 = getvalue(string10, i18);
                                if (i41 != -17) {
                                    pdam[i40] = (int) (i41 / 100.0F * 55.0F);
                                } else {
                                    pdam[i40] = -17;
                                }
                                i18++;
                            }
                            stuntname = getSvalue(string10, i18);
                            i18++;
                            lapsname = getSvalue(string10, i18);
                            i18++;
                            wastename = getSvalue(string10, i18);
                            i18++;
                        }
                    }
                }
            } else {
                final int i42 = getvalue(string10, i18);
                lanlogged = true;
                i18++;
            }
            final int i43 = getvalue(string10, i18);
            if (i43 != -1) {
                int i44 = 0;
                for (int i45 = 0; i45 < ngm; i45++) {
                    if (i43 == gnum[i45]) {
                        i44 = i45;
                    }
                }
                boolean bool46 = false;
                if (gwarb[i44] != 0) {
                    if (xt.clan.equalsIgnoreCase(gaclan[i44]) || xt.clan.equalsIgnoreCase(gvclan[i44])) {
                        bool46 = true;
                    }
                } else {
                    bool46 = true;
                }
                if ((pgames[im] != ongame || ongame == -1) && i43 != ongame && chalngd == -1 && join == -1 && fase == 1 && wait[i44] > 0 && bool46) {
                    chalngd = i43;
                    chalby = getSvalue(string10, i18 + 1);
                    cflk = 20;
                    ctime = 20;
                    ptime = 0L;
                    longame = ongame;
                    if (gs.rooms.open) {
                        gs.rooms.open = false;
                    }
                    if (ongame != -1) {
                        britchl = -1;
                    }
                }
                i18++;
            }
            if (!xt.lan) {
                int i47 = 1;
                for (int i48 = 1; i48 < 6; i48++) {
                    if (i48 != xt.servport - 7070) {
                        final int i49 = getvalue(string10, i18 + i48);
                        if (i49 != -1) {
                            gs.rooms.sopts[i47] = "Room " + i48 + "  ::  " + i49;
                            gs.rooms.opts[i47] = "";
                            gs.rooms.iroom[i47] = i48;
                            i47++;
                        }
                    }
                }
                for (int i50 = 0; i50 < lg.nservers; i50++) {
                    if (!xt.server.equals(lg.servers[i50]) && xt.delays[i50] < 300) {
                        gs.rooms.sopts[i47] = ":: " + lg.snames[i50];
                        gs.rooms.opts[i47] = "";
                        gs.rooms.iroom[i47] = 1000 + i50;
                        i47++;
                    }
                }
                gs.rooms.no = i47;
            }
            if (join > -1) {
                boolean bool51 = false;
                for (int i52 = 0; i52 < ngm; i52++) {
                    if (join == gnum[i52] && wait[i52] == 0) {
                        bool51 = true;
                    }
                }
                if (pgames[im] == join || bool51) {
                    join = -1;
                    nflk = 3;
                }
            }
            if (join == -2) {
                boolean bool53 = false;
                for (int i54 = 0; i54 < ngm; i54++) {
                    if (pgames[im] == gnum[i54] && wait[i54] == 0) {
                        bool53 = true;
                    }
                }
                if (pgames[im] == -1 || bool53) {
                    join = -1;
                    if (!bool53) {
                        ongame = -1;
                    }
                }
            }
            if (chalngd == -5 && pgames[im] != -1) {
                ongame = pgames[im];
                chalngd = -1;
                if (!xt.lan && "".equals(gplayers)) {
                    lg.gamealert();
                }
            }
            if (fstart && bool) {
                fstart = false;
            }
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
            } else */if (lg.gamec != -1) {
                lg.gamec = -1;
            }
            date = new Date();
            final long l55 = date.getTime();
            int i56 = 700 - (int) (l55 - l);
            if (i56 < 50) {
                i56 = 50;
            }
            try {
                Thread.sleep(i56);
            } catch (final InterruptedException interruptedexception) {
            }
        }
        if (conon == 2) {
            int i57 = 20;
            xt.playingame = -1;
            while (i57 != 0) {
                final String string = "2|" + i + "|";
                String string58 = "";
                boolean bool = false;
                try {
                    dout.println(string);
                    string58 = din.readLine();
                    if (string58 == null) {
                        bool = true;
                    }
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
                    }
                    try {
                        socket = new Socket(xt.server, xt.servport);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println(string);
                        string58 = din.readLine();
                        if (string58 != null) {
                            bool = false;
                        }
                    } catch (final Exception exception) {
                    }
                }
                if (bool) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (final Exception exception) {
                    }
                    conon = 0;
                    lg.exitfromlobby();
                    hideinputs();
                    connector.stop();
                }
                if (!xt.lan) {
                    xt.gameport = getvalue(string58, 0);
                } else {
                    xt.gameport = -1;
                    xt.localserver = getSevervalue(string58, 0);
                    if (!"".equals(xt.localserver)) {
                        xt.gameport = 0;
                    }
                }
                if (xt.gameport != -1) {
                    int i59 = 0;
                    xt.im = -1;
                    xt.nplayers = getvalue(string58, 1);
                    if (xt.nplayers < 1) {
                        xt.nplayers = 1;
                    }
                    if (xt.nplayers > 8) {
                        xt.nplayers = 8;
                    }
                    for (int i60 = 0; i60 < xt.nplayers; i60++) {
                        xt.plnames[i60] = getSvalue(string58, 2 + i60);
                        if (xt.nickname.equals(xt.plnames[i60])) {
                            xt.im = i60;
                        }
                    }
                    int i61 = 2 + xt.nplayers;
                    for (int i62 = 0; i62 < xt.nplayers; i62++) {
                        String string63 = getSvalue(string58, i61 + i62);
                        if (string63.startsWith("C")) {
                            string63 = string63.substring(1);
                            if (!"".equals(string63)) {
                                int i64 = 0;
                                for (int i65 = 16; i65 < 56; i65++) {
                                    if (string63.equals(cd.names[i65])) {
                                        i64 = i65;
                                        break;
                                    }
                                }
                                for (; i64 == 0 && i59 < 100; i59++) {
                                    boolean bool66 = false;
                                    for (int i67 = 0; i67 < cd.nl; i67++) {
                                        if (string63.equals(cd.loadnames[i67])) {
                                            bool66 = true;
                                        }
                                    }
                                    if (!bool66 && cd.nl < 20) {
                                        cd.loadnames[cd.nl] = string63;
                                        cd.nl++;
                                    }
                                    cd.sparkcarloader();
                                    try {
                                        Thread.sleep(100L);
                                    } catch (final InterruptedException interruptedexception) {
                                    }
                                    for (int i68 = 16; i68 < 56; i68++) {
                                        if (string63.equals(cd.names[i68])) {
                                            i64 = i68;
                                        }
                                    }
                                }
                                if (i64 != 0) {
                                    xt.sc[i62] = i64;
                                    for (int i69 = 0; i69 < npo; i69++) {
                                        if (pcarnames[i69].equals(string63)) {
                                            pcars[i69] = i64;
                                        }
                                    }
                                } else {
                                    xt.im = -1;
                                }
                            } else {
                                xt.im = -1;
                            }
                        } else {
                            xt.sc[i62] = getvalue(string58, i61 + i62);
                            if (xt.sc[i62] == -1) {
                                xt.im = -1;
                            }
                        }
                    }
                    i61 += xt.nplayers;
                    for (int i70 = 0; i70 < xt.nplayers; i70++) {
                        xt.xstart[i70] = getvalue(string58, i61 + i70);
                    }
                    i61 += xt.nplayers;
                    for (int i71 = 0; i71 < xt.nplayers; i71++) {
                        xt.zstart[i71] = getvalue(string58, i61 + i71);
                    }
                    i61 += xt.nplayers;
                    for (int i72 = 0; i72 < xt.nplayers; i72++) {
                        for (int i73 = 0; i73 < 6; i73++) {
                            xt.allrnp[i72][i73] = getvalue(string58, i61 + i72 * 6 + i73) / 100.0F;
                        }
                    }
                    if (xt.im != -1) {
                        xt.playingame = i;
                        int i74 = 0;
                        for (int i75 = 0; i75 < ngm; i75++) {
                            if (i == gnum[i75]) {
                                i74 = i75;
                            }
                        }
                        if (gwarb[i74] != 0) {
                            xt.clangame = gwtyp[i74];
                            xt.clanchat = true;
                            xt.gaclan = gaclan[i74];
                            for (int i76 = 0; i76 < xt.nplayers; i76++) {
                                for (int i77 = 0; i77 < npo; i77++) {
                                    if (xt.plnames[i76].equals(pnames[i77]) && pgames[i77] == i) {
                                        xt.pclan[i76] = pclan[i77];
                                    }
                                }
                            }
                        } else {
                            xt.clangame = 0;
                        }
                    } else {
                        xt.playingame = -1;
                        xt.im = 0;
                    }
                    i57 = 0;
                } else {
                    i57--;
                }
                try {
                    Thread.sleep(1000L);
                } catch (final InterruptedException interruptedexception) {
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
                    }
                }
                hideinputs();
                xt.multion = 1;
                fase = 76;
                System.gc();
            } else {
                inishlobby();
            }
        }
        if (conon == 3) {
            int i78 = 20;
            xt.playingame = -1;
            while (i78 != 0) {
                final String string = "4|" + ongame + "|";
                String string79 = "";
                boolean bool = false;
                try {
                    dout.println(string);
                    string79 = din.readLine();
                    if (string79 == null) {
                        bool = true;
                    }
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
                    }
                    try {
                        socket = new Socket(xt.server, xt.servport);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println(string);
                        string79 = din.readLine();
                        if (string79 != null) {
                            bool = false;
                        }
                    } catch (final Exception exception) {
                    }
                }
                if (bool) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (final Exception exception) {
                    }
                    conon = 0;
                    lg.exitfromlobby();
                    hideinputs();
                    connector.stop();
                }
                if (!xt.lan) {
                    xt.gameport = getvalue(string79, 0);
                } else {
                    xt.gameport = -1;
                    xt.localserver = getSevervalue(string79, 0);
                    if (!"".equals(xt.localserver)) {
                        xt.gameport = 0;
                    }
                }
                if (xt.gameport != -1) {
                    int i80 = 0;
                    xt.nplayers = getvalue(string79, 1);
                    if (xt.nplayers < 1) {
                        xt.nplayers = 1;
                    }
                    if (xt.nplayers > 8) {
                        xt.nplayers = 8;
                    }
                    xt.im = getvalue(string79, 2) + xt.nplayers;
                    for (int i81 = 0; i81 < xt.nplayers; i81++) {
                        xt.plnames[i81] = getSvalue(string79, 3 + i81);
                    }
                    int i82 = 3 + xt.nplayers;
                    for (int i83 = 0; i83 < xt.nplayers; i83++) {
                        String string84 = getSvalue(string79, i82 + i83);
                        if (string84.startsWith("C")) {
                            string84 = string84.substring(1);
                            if (!"".equals(string84)) {
                                int i85 = 0;
                                for (int i86 = 16; i86 < 56; i86++) {
                                    if (string84.equals(cd.names[i86])) {
                                        i85 = i86;
                                        break;
                                    }
                                }
                                for (; i85 == 0 && i80 < 100; i80++) {
                                    boolean bool87 = false;
                                    for (int i88 = 0; i88 < cd.nl; i88++) {
                                        if (string84.equals(cd.loadnames[i88])) {
                                            bool87 = true;
                                        }
                                    }
                                    if (!bool87 && cd.nl < 20) {
                                        cd.loadnames[cd.nl] = string84;
                                        cd.nl++;
                                    }
                                    cd.sparkcarloader();
                                    try {
                                        Thread.sleep(100L);
                                    } catch (final InterruptedException interruptedexception) {
                                    }
                                    for (int i89 = 16; i89 < 56; i89++) {
                                        if (string84.equals(cd.names[i89])) {
                                            i85 = i89;
                                        }
                                    }
                                }
                                if (i85 != 0) {
                                    xt.sc[i83] = i85;
                                    for (int i90 = 0; i90 < npo; i90++) {
                                        if (pcarnames[i90].equals(string84)) {
                                            pcars[i90] = i85;
                                        }
                                    }
                                } else {
                                    xt.im = -1;
                                }
                            } else {
                                xt.im = -1;
                            }
                        } else {
                            xt.sc[i83] = getvalue(string79, i82 + i83);
                            if (xt.sc[i83] == -1) {
                                xt.im = -1;
                            }
                        }
                    }
                    i82 += xt.nplayers;
                    for (int i91 = 0; i91 < xt.nplayers; i91++) {
                        xt.xstart[i91] = getvalue(string79, i82 + i91);
                    }
                    i82 += xt.nplayers;
                    for (int i92 = 0; i92 < xt.nplayers; i92++) {
                        xt.zstart[i92] = getvalue(string79, i82 + i92);
                    }
                    i82 += xt.nplayers;
                    for (int i93 = 0; i93 < xt.nplayers; i93++) {
                        for (int i94 = 0; i94 < 6; i94++) {
                            xt.allrnp[i93][i94] = getvalue(string79, i82 + i93 * 6 + i94) / 100.0F;
                        }
                    }
                    if (xt.im >= xt.nplayers && xt.im < xt.nplayers + 3) {
                        xt.playingame = ongame;
                        int i95 = 0;
                        for (int i96 = 0; i96 < ngm; i96++) {
                            if (ongame == gnum[i96]) {
                                i95 = i96;
                            }
                        }
                        if (gwarb[i95] != 0) {
                            xt.clangame = gwtyp[i95];
                            xt.gaclan = gaclan[i95];
                            if (xt.clan.equalsIgnoreCase(gaclan[i95]) || xt.clan.equalsIgnoreCase(gvclan[i95])) {
                                xt.clanchat = true;
                            }
                            for (int i97 = 0; i97 < xt.nplayers; i97++) {
                                for (int i98 = 0; i98 < npo; i98++) {
                                    if (xt.plnames[i97].equals(pnames[i98]) && pgames[i98] == ongame) {
                                        xt.pclan[i97] = pclan[i98];
                                    }
                                }
                            }
                        } else {
                            xt.clangame = 0;
                        }
                    } else {
                        xt.playingame = -1;
                        xt.im = 0;
                    }
                    i78 = 0;
                } else {
                    i78--;
                }
                try {
                    Thread.sleep(1000L);
                } catch (final InterruptedException interruptedexception) {
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
            }
            if (xt.playingame != -1) {
                hideinputs();
                xt.multion = 3;
                fase = 76;
                System.gc();
            } else {
                inishlobby();
            }
        }
    }

    void stageselect(final CheckPoints checkpoints, final Control control, final int i, final int i293, final boolean bool) {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        rd.fillRect(65, 0, 670, 25);
        rd.fillRect(65, 425, 670, 25);
        btn = 0;
        int i294 = 0;
        rd.drawImage(xt.br, 65, 25, null);
        if (britchl == -1) {
            ongame = -1;
            britchl = 0;
        }
        int i295 = 0;
        for (int i296 = 0; i296 < ngm; i296++) {
            if (ongame == gnum[i296]) {
                i295 = i296;
            }
        }
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
            if (wait[i295] > 0) {
                if (gwarb[i295] == 0) {
                    if (wait[i295] > 30 || npls[i295] <= 1) {
                        String string = "";
                        if (npls[i295] > 1) {
                            final Date date = new Date();
                            final long l = date.getTime();
                            if (ptime == 0L || l > ptime + 1500L) {
                                if (ptime != 0L) {
                                    wait[i295]--;
                                    if (wait[i295] < 1) {
                                        wait[i295] = 1;
                                    }
                                }
                                ptime = l;
                            }
                            string = " (waiting " + wait[i295] + " seconds maximum)";
                            if (wait[i295] > 60) {
                                string = " (waiting " + (int) (wait[i295] / 60.0F * 100.0F) / 100.0F + " minutes maximum)";
                            }
                        }
                        rd.drawString("Waiting for " + (mnpls[i295] - npls[i295]) + " more players to join to start this game" + string + "!", 95, 15);
                        rd.setFont(new Font("Arial", 0, 12));
                        if (!"Coach Insano".equals(gmaker[i295]) && !gmaker[i295].equals(pnames[im])) {
                            boolean bool297 = false;
                            for (int i298 = 0; i298 < npo; i298++) {
                                if (pgames[i298] == ongame && gmaker[i295].equals(pnames[i298])) {
                                    bool297 = true;
                                }
                            }
                            if (bool297) {
                                rd.drawString(gmaker[i295] + " can start this game at anytime (the game creator)...", 95, 31);
                            }
                        }
                    } else {
                        final Date date = new Date();
                        final long l = date.getTime();
                        if (ptime == 0L || l > ptime + 1500L) {
                            if (ptime != 0L) {
                                wait[i295]--;
                                if (wait[i295] < 1) {
                                    wait[i295] = 1;
                                }
                            }
                            ptime = l;
                        }
                        if (pgames[im] == ongame || nflk != 0) {
                            rd.drawString("Game starts in " + wait[i295] + " seconds!", 400 - ftm.stringWidth("Game starts in " + wait[i295] + " seconds!") / 2, 23);
                            if (pgames[im] != ongame) {
                                nflk--;
                            }
                        } else if (pgames[im] != ongame) {
                            nflk = 3;
                        }
                    }
                } else {
                    rd.drawString("Waiting for " + (mnpls[i295] - npls[i295]) + " clan members to join to start this game!", 95, 23);
                }
                if (pgames[im] != ongame) {
                    boolean bool299 = false;
                    if (gwarb[i295] == 0) {
                        if ("".equals(gplyrs[i295]) || gplyrs[i295].contains(pnames[im])) {
                            bool299 = true;
                        }
                    } else if (xt.clan.equalsIgnoreCase(gaclan[i295]) || xt.clan.equalsIgnoreCase(gvclan[i295])) {
                        bool299 = true;
                    }
                    if (bool299) {
                        stringbutton(" Join Game ", 660, 23, 2);
                    }
                }
            } else {
                rd.setColor(color2k(120, 120, 120));
                if (wait[i295] == 0) {
                    rd.drawString("Game Started", 400 - ftm.stringWidth("Game Started") / 2, 20);
                } else {
                    rd.drawString("Game Finished", 400 - ftm.stringWidth("Game Finished") / 2, 20);
                }
            }
        }
        rd.setFont(new Font("Arial", 1, 11));
        xt.ftm = rd.getFontMetrics();
        ftm = rd.getFontMetrics();
        String string = "";
        /*if (checkpoints.stage < 0)
        	string = "Custom Stage";
        if (checkpoints.stage > 0 && checkpoints.stage <= 10)
        	string = "" + ("Stage ") + (checkpoints.stage) + (" NFM 1");
        if (checkpoints.stage > 10 && checkpoints.stage <= 27)
        	string = "" + ("Stage ") + (checkpoints.stage - 10) + (" NFM 2");
        if (checkpoints.stage > 27)*/
        string = "Stage " + checkpoints.stage;
        xt.drawcs(85, "Previewing " + string + "  >", 255, 138, 0, 5);
        xt.drawcs(105, "| " + checkpoints.name + " |", 255, 176, 85, 5);
        rd.drawImage(xt.back[pback], 532, 285, null);
        if (plsndt == 0) {
            final String string300 = "Play Soundtrack >";
            final int i301 = 562 - ftm.stringWidth(string300) / 2;
            final int i302 = i301 + ftm.stringWidth(string300);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string300, i301 + 1, 326);
            rd.drawLine(i301 + 1, 328, i302 + 1, 328);
            rd.setColor(new Color(255, 138, 0));
            rd.drawString(string300, i301, 325);
            rd.drawLine(i301, 327, i302, 327);
            if (i > i301 && i < i302 && i293 > 314 && i293 < 327) {
                i294 = 12;
                if (bool) {
                    plsndt = 1;
                }
            }
        }
        if (plsndt == 1) {
            xt.drawcs(190, "Loading Soundtrack, please wait...", 255, 138, 0, 5);
        }
        if (checkpoints.stage < 0) {
            rd.setColor(new Color(255, 138, 0));
            rd.drawString("Created by: " + checkpoints.maker, 85, 413);
            if (checkpoints.pubt > 0) {
                if (checkpoints.pubt == 2) {
                    xt.drawcs(413, "Super Public Stage", 41, 177, 255, 3);
                } else {
                    xt.drawcs(413, "Public Stage", 41, 177, 255, 3);
                }
                if (addstage == 0 && xt.drawcarb(true, null, " Add to My Stages ", 334, 420, i, i293, bool)) {
                    if (xt.logged) {
                        cd.onstage = checkpoints.name;
                        cd.staction = 2;
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
                    final String string303 = "Upgrade to a full account to add custom stages!";
                    final int i304 = 400 - ftm.stringWidth(string303) / 2;
                    final int i305 = i304 + ftm.stringWidth(string303);
                    rd.drawString(string303, i304, 435);
                    if (waitlink != -1) {
                        rd.drawLine(i304, 437, i305, 437);
                    }
                    if (i > i304 && i < i305 && i293 > 424 && i293 < 437) {
                        if (waitlink != -1) {
                            i294 = 12;
                        }
                        if (bool && waitlink == 0) {
                            gs.editlink(xt.nickname, true);
                            waitlink = -1;
                        }
                    }
                    if (waitlink > 0) {
                        waitlink--;
                    }
                }
                if (addstage == 2) {
                    xt.drawcs(435, "Adding stage please wait...", 193, 106, 0, 3);
                    if (cd.staction == 0) {
                        addstage = 3;
                    }
                    if (cd.staction == -2) {
                        addstage = 4;
                    }
                    if (cd.staction == -3) {
                        addstage = 5;
                    }
                    if (cd.staction == -1) {
                        addstage = 6;
                    }
                }
                if (addstage == 3) {
                    xt.drawcs(435, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                }
                if (addstage == 4) {
                    xt.drawcs(435, "You already have this stage!", 193, 106, 0, 3);
                }
                if (addstage == 5) {
                    xt.drawcs(435, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                }
                if (addstage == 6) {
                    xt.drawcs(435, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
                }
            } else {
                xt.drawcs(435, "Private Stage", 193, 106, 0, 3);
            }
        }
        if (control.enter || conon == 2 || (ongame == -1 && chalngd != -2)) {
            m.trk = 0;
            if (xt.loadedt) {
                xt.strack.unload();
            }
            m.focusPoint = 400;
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
        if (i294 != pcurs) {
            gs.setCursor(new Cursor(i294));
            pcurs = i294;
        }
    }

    void stopallnow() {
        conon = 0;
        try {
            socket.close();
            socket = null;
            din.close();
            din = null;
            dout.close();
            dout = null;
        } catch (final Exception exception) {
        }
        if (connector != null) {
            connector.stop();
            connector = null;
        }
    }

    private void stringbutton(final String string, final int i, final int i325, final int i326) {
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        bx[btn] = i;
        by[btn] = i325 - 5;
        bw[btn] = ftm.stringWidth(string);
        if (!pessd[btn]) {
            rd.setColor(color2k(220, 220, 220));
            rd.fillRect(i - bw[btn] / 2 - 10, i325 - (17 - i326), bw[btn] + 20, 25 - i326 * 2);
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i325 - (17 - i326), i + bw[btn] / 2 + 10, i325 - (17 - i326));
            rd.drawLine(i - bw[btn] / 2 - 10, i325 - (18 - i326), i + bw[btn] / 2 + 10, i325 - (18 - i326));
            rd.drawLine(i - bw[btn] / 2 - 9, i325 - (19 - i326), i + bw[btn] / 2 + 9, i325 - (19 - i326));
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i + bw[btn] / 2 + 10, i325 - (17 - i326), i + bw[btn] / 2 + 10, i325 + 7 - i326);
            rd.drawLine(i + bw[btn] / 2 + 11, i325 - (17 - i326), i + bw[btn] / 2 + 11, i325 + 7 - i326);
            rd.drawLine(i + bw[btn] / 2 + 12, i325 - (16 - i326), i + bw[btn] / 2 + 12, i325 + 6 - i326);
            rd.drawLine(i - bw[btn] / 2 - 10, i325 + 7 - i326, i + bw[btn] / 2 + 10, i325 + 7 - i326);
            rd.drawLine(i - bw[btn] / 2 - 10, i325 + 8 - i326, i + bw[btn] / 2 + 10, i325 + 8 - i326);
            rd.drawLine(i - bw[btn] / 2 - 9, i325 + 9 - i326, i + bw[btn] / 2 + 9, i325 + 9 - i326);
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i325 - (17 - i326), i - bw[btn] / 2 - 10, i325 + 7 - i326);
            rd.drawLine(i - bw[btn] / 2 - 11, i325 - (17 - i326), i - bw[btn] / 2 - 11, i325 + 7 - i326);
            rd.drawLine(i - bw[btn] / 2 - 12, i325 - (16 - i326), i - bw[btn] / 2 - 12, i325 + 6 - i326);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2, i325);
        } else {
            rd.setColor(color2k(210, 210, 210));
            rd.fillRect(i - bw[btn] / 2 - 10, i325 - (17 - i326), bw[btn] + 20, 25 - i326 * 2);
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i - bw[btn] / 2 - 10, i325 - (17 - i326), i + bw[btn] / 2 + 10, i325 - (17 - i326));
            rd.drawLine(i - bw[btn] / 2 - 10, i325 - (18 - i326), i + bw[btn] / 2 + 10, i325 - (18 - i326));
            rd.drawLine(i - bw[btn] / 2 - 9, i325 - (19 - i326), i + bw[btn] / 2 + 9, i325 - (19 - i326));
            rd.drawLine(i + bw[btn] / 2 + 10, i325 - (17 - i326), i + bw[btn] / 2 + 10, i325 + 7 - i326);
            rd.drawLine(i + bw[btn] / 2 + 11, i325 - (17 - i326), i + bw[btn] / 2 + 11, i325 + 7 - i326);
            rd.drawLine(i + bw[btn] / 2 + 12, i325 - (16 - i326), i + bw[btn] / 2 + 12, i325 + 6 - i326);
            rd.drawLine(i - bw[btn] / 2 - 10, i325 + 7 - i326, i + bw[btn] / 2 + 10, i325 + 7 - i326);
            rd.drawLine(i - bw[btn] / 2 - 10, i325 + 8 - i326, i + bw[btn] / 2 + 10, i325 + 8 - i326);
            rd.drawLine(i - bw[btn] / 2 - 9, i325 + 9 - i326, i + bw[btn] / 2 + 9, i325 + 9 - i326);
            rd.drawLine(i - bw[btn] / 2 - 10, i325 - (17 - i326), i - bw[btn] / 2 - 10, i325 + 7 - i326);
            rd.drawLine(i - bw[btn] / 2 - 11, i325 - (17 - i326), i - bw[btn] / 2 - 11, i325 + 7 - i326);
            rd.drawLine(i - bw[btn] / 2 - 12, i325 - (16 - i326), i - bw[btn] / 2 - 12, i325 + 6 - i326);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2 + 1, i325);
        }
        btn++;
    }
}
