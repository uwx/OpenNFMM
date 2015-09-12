package stagemaker;

/* GameSparker - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.applet.Applet;
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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
public class GameSparker extends Applet implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3953201233896689407L;

	public Settings getSettings() {
		return settings;
	}
	Settings settings = new Settings();
    Graphics2D rd;
    Image offImage;
    Thread gamer;
    int mload = 1;
    boolean exwist = false;
    String ver = "v17";
    int apx = 0;
    int apy = 0;
    float apmult = 1.0F;
    float reqmult = 0.0F;
    int smooth = 1;
    int lastw = 0;
    int lasth = 0;
    boolean onbar = false;
    boolean oncarm = false;
    boolean onstgm = false;
    Image sizebar;
    Image blb;
    Image[] chkbx = new Image[2];
    Image[] carmaker = new Image[2];
    Image[] stagemaker = new Image[2];
    int showsize = 0;
    Control[] u = new Control[7];
    int mouses = 0;
    int xm = 0;
    int ym = 0;
    int mousew = 0;
    boolean lostfcs = false;
    boolean moused = false;
    int fcscnt = 0;
    int nob = 0;
    int notb = 0;
    int view = 0;
    boolean elay = false;
    TextField tnick;
    TextField tpass;
    TextField temail;
    TextField cmsg;
    TextArea mmsg;
    Checkbox mycar;
    Checkbox notp;
    Checkbox keplo;
    boolean openm = false;
    Smenu sgame = new Smenu(8);
    Smenu snfmm = new Smenu(12);
    Smenu snfm1 = new Smenu(12);
    Smenu snfm2 = new Smenu(19);
    Smenu mstgs = new Smenu(30);
    Smenu slaps = new Smenu(17);
    Smenu snpls = new Smenu(8);
    Smenu snbts = new Smenu(8);
    Smenu swait = new Smenu(6);
    Smenu sclass = new Smenu(7);
    Smenu scars = new Smenu(4);
    Smenu sfix = new Smenu(7);
    Smenu gmode = new Smenu(3);
    Smenu rooms = new Smenu(7);
    Smenu sendtyp = new Smenu(4);
    Smenu senditem = new Smenu(21);
    
    public void run() {
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(0, 0, 800, 450);
        repaint();
        requestFocus();
        Medium medium = new Medium();
        Trackers trackers = new Trackers();
        CheckPoints checkpoints = new CheckPoints();
        ContO[] contos = new ContO[122];
        CarDefine cardefine = new CarDefine(contos, medium, trackers, this);
        xtGraphics var_xtGraphics = new xtGraphics(medium, cardefine, rd, this);
        settings.initclasses(this,var_xtGraphics,cardefine,contos,checkpoints,trackers,medium);
        sizebar = var_xtGraphics.getImage("data/sizebar.gif");
        blb = var_xtGraphics.getImage("data/b.gif");
        chkbx[0] = var_xtGraphics.getImage("data/checkbox1.gif");
        chkbx[1] = var_xtGraphics.getImage("data/checkbox2.gif");
        carmaker[0] = var_xtGraphics.getImage("data/carmaker1.gif");
        carmaker[1] = var_xtGraphics.getImage("data/carmaker2.gif");
        stagemaker[0] = var_xtGraphics.getImage("data/stagemaker1.gif");
        stagemaker[1] = var_xtGraphics.getImage("data/stagemaker2.gif");
        var_xtGraphics.loaddata();
        Login login = null;
        Lobby lobby = null;
        Globe globe = null;
        boolean bool = false;
        UDPMistro udpmistro = new UDPMistro();
        Record record = new Record(medium);
        loadbase(contos, medium, trackers, var_xtGraphics, false);
        ContO[] contos_0_ = new ContO[10000];
        Mad[] mads = new Mad[7];
        settings.initmads(mads);
        for (int i = 0; i < 7; i++) {
            mads[i] = new Mad(cardefine, medium, record, var_xtGraphics, i);
            u[i] = new Control(medium);
        }
        float f = 47.0F;
        readcookies(var_xtGraphics, contos);
        (var_xtGraphics).testdrive = Madness.testdrive;
        if ((var_xtGraphics).testdrive != 0) {
            if ((var_xtGraphics).testdrive <= 2) {
                (var_xtGraphics).sc[0] = cardefine.loadcar(Madness.testcar, 16);
                if ((var_xtGraphics).sc[0] != -1)
                    (var_xtGraphics).fase = -9;
                else {
                    Madness.testcar = "Failx12";
                    Madness.carmaker();
                }
            } else {
                (checkpoints).name = Madness.testcar;
                (var_xtGraphics).fase = -9;
            }
        }
        var_xtGraphics.stoploading();
        requestFocus();
        System.gc();
        Date date = new Date();
        long l = 0L;
        long l_1_ = date.getTime();
        float f_2_ = 30.0F;
        boolean bool_3_ = false;
        int i = 30;
        int i_4_ = 530;
        int i_5_ = 0;
        int i_6_ = 0;
        int i_7_ = 0;
        int i_8_ = 0;
        int i_9_ = 0;
        boolean bool_10_ = false;
        for (;;) {
            date = new Date();
            long l_11_ = date.getTime();
            if ((var_xtGraphics).fase == 111) {
                if (mouses == 1)
                    i_7_ = 800;
                if (i_7_ < 800) {
                    var_xtGraphics.clicknow();
                    i_7_++;
                } else {
                    i_7_ = 0;
                    if (!exwist)
                        (var_xtGraphics).fase = 9;
                    mouses = 0;
                    lostfcs = false;
                }
            }
            if ((var_xtGraphics).fase == 9) {
                if ((double) i_7_ < 0.167) {
                    var_xtGraphics.rad(i_7_);
                    catchlink();
                    if (mouses == 2)
                        mouses = 0;
                    if (mouses == 1)
                        mouses = 2;
                    i_7_++;
                } else {
                    i_7_ = 0;
                    (var_xtGraphics).fase = 10;
                    mouses = 0;
                    u[0].falseo(0);
                }
            }
            if ((var_xtGraphics).fase == -9) {
                if ((var_xtGraphics).loadedt) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 800, 450);
                    repaint();
                    (var_xtGraphics).strack.unload();
                    (var_xtGraphics).strack = null;
                    (var_xtGraphics).flexpix = null;
                    (var_xtGraphics).fleximg = null;
                    System.gc();
                    (var_xtGraphics).loadedt = false;
                }
                if (i_7_ < 2) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(65, 25, 670, 400);
                    i_7_++;
                } else {
                    var_xtGraphics.inishcarselect(contos);
                    i_7_ = 0;
                    (var_xtGraphics).fase = 7;
                    mouses = 0;
                }
            }
            if ((var_xtGraphics).fase == 8) {
                var_xtGraphics.credits(u[0], xm, ym, mouses);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if ((var_xtGraphics).flipo <= 100)
                    catchlink();
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == 10) {
                var_xtGraphics.maini(u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == 102) {
                if ((var_xtGraphics).loadedt) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 800, 450);
                    repaint();
                    (var_xtGraphics).strack.unload();
                    (var_xtGraphics).strack = null;
                    (var_xtGraphics).flexpix = null;
                    (var_xtGraphics).fleximg = null;
                    System.gc();
                    (var_xtGraphics).loadedt = false;
                }
                if ((var_xtGraphics).testdrive == 1 || (var_xtGraphics).testdrive == 2)
                    Madness.carmaker();
                if ((var_xtGraphics).testdrive == 3 || (var_xtGraphics).testdrive == 4)
                    Madness.stagemaker();
                var_xtGraphics.maini2(u[0], xm, ym, mouses);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == -22) {
                (checkpoints).name = Madness.testcar;
                (checkpoints).stage = -1;
                loadstage(contos_0_, contos, medium, trackers, checkpoints, var_xtGraphics, mads, record);
                if ((checkpoints).stage == -3) {
                    Madness.testcar = "Failx12";
                    Madness.stagemaker();
                }
            }
            if ((var_xtGraphics).fase == 11) {
                var_xtGraphics.inst(u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == -5) {
                var_xtGraphics.finish(checkpoints, contos, u[0], xm, ym, moused);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == 7) {
                var_xtGraphics.carselect(u[0], contos, mads[0], xm, ym, moused);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == 6) {
                var_xtGraphics.musicomp((checkpoints).stage, u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == 5)
                var_xtGraphics.loadmusic((checkpoints).stage, (checkpoints).trackname, (checkpoints).trackvol);
            if ((var_xtGraphics).fase == 4) {
                var_xtGraphics.cantgo(u[0]);
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == 3) {
                rd.setColor(new Color(0, 0, 0));
                rd.fillRect(65, 25, 670, 400);
                repaint();
                var_xtGraphics.inishstageselect(checkpoints);
            }
            if ((var_xtGraphics).fase == 2) {
                var_xtGraphics.loadingstage((checkpoints).stage, true);
                (checkpoints).nfix = 0;
                (checkpoints).notb = false;
                loadstage(contos_0_, contos, medium, trackers, checkpoints, var_xtGraphics, mads, record);
                u[0].falseo(0);
                (udpmistro).freg = 0.0F;
            }
            if ((var_xtGraphics).fase == 1) {
                var_xtGraphics.trackbg(false);
                if ((checkpoints).stage != -3) {
                    medium.aroundtrack(checkpoints);
                    int i_12_ = 0;
                    int[] is = new int[10000];
                    for (int i_13_ = (var_xtGraphics).nplayers; i_13_ < notb; i_13_++) {
                        if ((contos_0_[i_13_]).dist != 0) {
                            is[i_12_] = i_13_;
                            i_12_++;
                        } else
                            contos_0_[i_13_].d(rd);
                    }
                    int[] is_14_ = new int[i_12_];
                    for (int i_15_ = 0; i_15_ < i_12_; i_15_++)
                        is_14_[i_15_] = 0;
                    for (int i_16_ = 0; i_16_ < i_12_; i_16_++) {
                        for (int i_17_ = i_16_ + 1; i_17_ < i_12_; i_17_++) {
                            if ((contos_0_[is[i_16_]]).dist != (contos_0_[is[i_17_]]).dist) {
                                if ((contos_0_[is[i_16_]]).dist < (contos_0_[is[i_17_]]).dist)
                                    is_14_[i_16_]++;
                                else
                                    is_14_[i_17_]++;
                            } else if (i_17_ > i_16_)
                                is_14_[i_16_]++;
                            else
                                is_14_[i_17_]++;
                        }
                    }
                    for (int i_18_ = 0; i_18_ < i_12_; i_18_++) {
                        for (int i_19_ = 0; i_19_ < i_12_; i_19_++) {
                            if (is_14_[i_19_] == i_18_)
                                contos_0_[is[i_19_]].d(rd);
                        }
                    }
                }
                if (!openm)
                    var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
                var_xtGraphics.stageselect(checkpoints, u[0], xm, ym, moused);
                drawms();
            }
            if ((var_xtGraphics).fase == 1177) {
                if (!bool) {
                    (var_xtGraphics).intertrack.unloadimod();
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(65, 25, 670, 400);
                    if (mload > 0)
                        rd.drawImage((var_xtGraphics).mload, 259, 195, this);
                    repaint();
                    if (mload > 0) {
                        try {
                            /*URL url = new URL("http://multiplayer.needformadness.com/ver.txt");
                            DataInputStream datainputstream = new DataInputStream(url.openStream());
                            String string = datainputstream.readLine();
                            if (!string.equals(ver))
                                mload = 3;
                            datainputstream.close();*/
                        } catch (Exception exception) {
                            /* empty */
                        }
                    }
                    if (mload == 3) {
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        rd.drawString("The Game has been Updated!", 50, 50);
                        rd.drawString("Please download the latest version from:", 50, 100);
                        cmsg.show();
                        movefield(cmsg, 50, 115, 360, 22);
                        cmsg.setText(new StringBuilder().append("http://multiplayer.needformadness.com/download.pl#").append((var_xtGraphics).nickname).append("").toString());
                        rd.setFont(new Font("Arial", 0, 13));
                        rd.drawString("(From >>  multiplayer.needformadness.com  >>  Download )", 50, 155);
                        rd.setFont(new Font("Arial", 0, 13));
                        rd.drawString("To learn about what has been updated and added to the game,", 50, 220);
                        rd.drawString("Go to >>  multiplayer.needformadness.com  >>  Development Blog", 50, 240);
                        repaint();
                        openurl(new StringBuilder().append("http://multiplayer.needformadness.com/download.pl#").append((var_xtGraphics).nickname).append("").toString());
                        gamer.stop();
                    }
                    if (mload == 2) {
                        cardefine.loadready();
                        loadbase(contos, medium, trackers, var_xtGraphics, true);
                        readcookies(var_xtGraphics, contos);
                        mload = -1;
                    }
                    if (mload != -1)
                        mload = -1;
                    System.gc();
                    login = new Login(medium, rd, var_xtGraphics, this);
                    globe = new Globe(rd, var_xtGraphics, login, cardefine, this);
                    lobby = new Lobby(medium, rd, login, globe, var_xtGraphics, cardefine, this);
                    bool = true;
                }
                if ((login).fase != 18) {
                    boolean bool_20_ = false;
                    if ((login).fase == 0)
                        login.inishmulti();
                    if ((login).fase >= 1 && (login).fase <= 11)
                        login.multistart(contos);
                    if ((login).fase >= 12 && (login).fase <= 17) {
                        if ((globe).open != 452)
                            login.multimode(contos);
                        else
                            bool_20_ = true;
                        globe.dome(0, xm, ym, moused, u[0]);
                    }
                    if (!bool_20_)
                        login.ctachm(xm, ym, mouses, u[0], lobby);
                    else
                        drawms();
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
                    }
                } else {
                    boolean bool_21_ = false;
                    if ((lobby).fase == 0)
                        lobby.inishlobby();
                    if ((lobby).fase == 1) {
                        if ((globe).open >= 2 && (globe).open < 452)
                            openm = true;
                        if ((globe).open != 452)
                            lobby.lobby(xm, ym, moused, mousew, checkpoints, u[0], contos);
                        else
                            bool_21_ = true;
                        globe.dome((lobby).conon, xm, ym, moused, u[0]);
                        if ((lobby).loadstage > 0) {
                            setCursor(new Cursor(3));
                            drawms();
                            repaint();
                            (trackers).nt = 0;
                            if (loadstagePreview((lobby).loadstage, "", contos_0_, contos, medium, checkpoints)) {
                                (lobby).gstagename = (checkpoints).name;
                                (lobby).gstagelaps = (checkpoints).nlaps;
                                (lobby).loadstage = -(lobby).loadstage;
                            } else {
                                (lobby).loadstage = 0;
                                (checkpoints).name = "";
                            }
                            setCursor(new Cursor(0));
                        }
                        if ((lobby).msload) {
                            setCursor(new Cursor(3));
                            drawms();
                            repaint();
                            cardefine.loadmystages(checkpoints);
                            (lobby).msload = false;
                            setCursor(new Cursor(0));
                        }
                    }
                    if ((lobby).fase == 3) {
                        var_xtGraphics.trackbg(false);
                        (medium).trk = 0;
                        (medium).focus_point = 400;
                        (medium).crs = true;
                        (medium).x = -335;
                        (medium).y = 0;
                        (medium).z = -50;
                        (medium).xz = 0;
                        (medium).zy = 20;
                        (medium).ground = -2000;
                        (lobby).fase = 1;
                    }
                    if ((lobby).fase == 4) {
                        var_xtGraphics.trackbg(false);
                        medium.aroundtrack(checkpoints);
                        int i_22_ = 0;
                        int[] is = new int[10000];
                        for (int i_23_ = 0; i_23_ < nob; i_23_++) {
                            if ((contos_0_[i_23_]).dist != 0) {
                                is[i_22_] = i_23_;
                                i_22_++;
                            } else
                                contos_0_[i_23_].d(rd);
                        }
                        int[] is_24_ = new int[i_22_];
                        for (int i_25_ = 0; i_25_ < i_22_; i_25_++)
                            is_24_[i_25_] = 0;
                        for (int i_26_ = 0; i_26_ < i_22_; i_26_++) {
                            for (int i_27_ = i_26_ + 1; i_27_ < i_22_; i_27_++) {
                                if ((contos_0_[is[i_26_]]).dist != (contos_0_[is[i_27_]]).dist) {
                                    if ((contos_0_[is[i_26_]]).dist < (contos_0_[is[i_27_]]).dist)
                                        is_24_[i_26_]++;
                                    else
                                        is_24_[i_27_]++;
                                } else if (i_27_ > i_26_)
                                    is_24_[i_26_]++;
                                else
                                    is_24_[i_27_]++;
                            }
                        }
                        for (int i_28_ = 0; i_28_ < i_22_; i_28_++) {
                            for (int i_29_ = 0; i_29_ < i_22_; i_29_++) {
                                if (is_24_[i_29_] == i_28_)
                                    contos_0_[is[i_29_]].d(rd);
                            }
                        }
                        lobby.stageselect(checkpoints, u[0], xm, ym, moused);
                    }
                    if ((lobby).fase == 2) {
                        int i_30_ = 0;
                        for (int i_31_ = 0; i_31_ < (lobby).ngm; i_31_++) {
                            if ((lobby).ongame == (lobby).gnum[i_31_])
                                i_30_ = i_31_;
                        }
                        boolean bool_32_ = false;
                        if ((lobby).gstgn[i_30_] > 0) {
                            if ((lobby).gstgn[i_30_] == -(lobby).loadstage)
                                bool_32_ = true;
                        } else if ((lobby).gstages[i_30_].equals((checkpoints).name))
                            bool_32_ = true;
                        if (bool_32_) {
                            (lobby).fase = 4;
                            (lobby).addstage = 0;
                        } else {
                            var_xtGraphics.loadingstage((lobby).gstgn[i_30_], false);
                            (trackers).nt = 0;
                            if (loadstagePreview((lobby).gstgn[i_30_], (lobby).gstages[i_30_], contos_0_, contos, medium, checkpoints)) {
                                (lobby).loadstage = -(lobby).gstgn[i_30_];
                                (lobby).fase = 4;
                                (lobby).addstage = 0;
                            } else {
                                (lobby).loadstage = 0;
                                (checkpoints).name = "";
                                (lobby).fase = 3;
                            }
                        }
                    }
                    if ((lobby).fase == 76) {
                        (checkpoints).nlaps = (lobby).laps;
                        (checkpoints).stage = (lobby).stage;
                        (checkpoints).name = (lobby).stagename;
                        (checkpoints).nfix = (lobby).nfix;
                        (checkpoints).notb = (lobby).notb;
                        (var_xtGraphics).fase = 21;
                        (u[0]).multion = (var_xtGraphics).multion;
                    }
                    if (!openm) {
                        if (!bool_21_)
                            lobby.ctachm(xm, ym, mouses, u[0]);
                    } else
                        mouses = 0;
                    drawms();
                    if ((lobby).fase == 1)
                        lobby.preforma(xm, ym);
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
                        if (!(lobby).zeromsw)
                            mousew = 0;
                    }
                }
            }
            if ((var_xtGraphics).fase == 24) {
                login.endcons();
                login = null;
                lobby = null;
                globe = null;
                bool = false;
                System.gc();
                System.runFinalization();
                if (!(var_xtGraphics).mtop) {
                    (var_xtGraphics).fase = 102;
                    (var_xtGraphics).opselect = 2;
                } else {
                    (var_xtGraphics).fase = 10;
                    (var_xtGraphics).opselect = 1;
                }
            }
            if ((var_xtGraphics).fase == 23) {
                login.endcons();
                login = null;
                lobby = null;
                globe = null;
                bool = false;
                System.gc();
                System.runFinalization();
                (var_xtGraphics).fase = -9;
            }
            if ((var_xtGraphics).fase == 22) {
                loadstage(contos_0_, contos, medium, trackers, checkpoints, var_xtGraphics, mads, record);
                if ((checkpoints).stage != -3) {
                    if ((var_xtGraphics).lan && (var_xtGraphics).im == 0)
                        udpmistro.UDPLanServer((var_xtGraphics).nplayers, (var_xtGraphics).server, (var_xtGraphics).servport, (var_xtGraphics).playingame);
                    u[0].falseo(2);
                    requestFocus();
                } else
                    (var_xtGraphics).fase = 1177;
            }
            if ((var_xtGraphics).fase == 21) {
                login.endcons();
                login = null;
                lobby = null;
                globe = null;
                bool = false;
                System.gc();
                System.runFinalization();
                (var_xtGraphics).fase = 22;
            }
            if ((var_xtGraphics).fase == 0) {
                for (int i_33_ = 0; i_33_ < (var_xtGraphics).nplayers; i_33_++) {
                    if ((mads[i_33_]).newcar) {
                        int i_34_ = (contos_0_[i_33_]).xz;
                        int i_35_ = (contos_0_[i_33_]).xy;
                        int i_36_ = (contos_0_[i_33_]).zy;
                        contos_0_[i_33_] = new ContO(contos[(mads[i_33_]).cn], (contos_0_[i_33_]).x, (contos_0_[i_33_]).y, (contos_0_[i_33_]).z, 0);
                        (contos_0_[i_33_]).xz = i_34_;
                        (contos_0_[i_33_]).xy = i_35_;
                        (contos_0_[i_33_]).zy = i_36_;
                        (mads[i_33_]).newcar = false;
                    }
                }
                medium.d(rd);
                int i_37_ = 0;
                int[] is = new int[10000];
                for (int i_38_ = 0; i_38_ < nob; i_38_++) {
                    if ((contos_0_[i_38_]).dist != 0) {
                        is[i_37_] = i_38_;
                        i_37_++;
                    } else
                        contos_0_[i_38_].d(rd);
                }
                int[] is_39_ = new int[i_37_];
                int[] is_40_ = new int[i_37_];
                for (int i_41_ = 0; i_41_ < i_37_; i_41_++)
                    is_39_[i_41_] = 0;
                for (int i_42_ = 0; i_42_ < i_37_; i_42_++) {
                    for (int i_43_ = i_42_ + 1; i_43_ < i_37_; i_43_++) {
                        if ((contos_0_[is[i_42_]]).dist < (contos_0_[is[i_43_]]).dist)
                            is_39_[i_42_]++;
                        else
                            is_39_[i_43_]++;
                    }
                    is_40_[is_39_[i_42_]] = i_42_;
                }
                for (int i_44_ = 0; i_44_ < i_37_; i_44_++)
                    contos_0_[is[is_40_[i_44_]]].d(rd);
                if ((var_xtGraphics).starcnt == 0) {
                    for (int i_45_ = 0; i_45_ < (var_xtGraphics).nplayers; i_45_++) {
                        for (int i_46_ = 0; i_46_ < (var_xtGraphics).nplayers; i_46_++) {
                            if (i_46_ != i_45_)
                                mads[i_45_].colide(contos_0_[i_45_], mads[i_46_], contos_0_[i_46_]);
                        }
                    }
                    for (int i_47_ = 0; i_47_ < (var_xtGraphics).nplayers; i_47_++)
                        mads[i_47_].drive(u[i_47_], contos_0_[i_47_], trackers, checkpoints);
                    for (int i_48_ = 0; i_48_ < (var_xtGraphics).nplayers; i_48_++)
                        record.rec(contos_0_[i_48_], i_48_, (mads[i_48_]).squash, (mads[i_48_]).lastcolido, (mads[i_48_]).cntdest, 0);
                    checkpoints.checkstat(mads, contos_0_, record, (var_xtGraphics).nplayers, (var_xtGraphics).im, 0);
                    for (int i_49_ = 1; i_49_ < (var_xtGraphics).nplayers; i_49_++)
                        u[i_49_].preform(mads[i_49_], contos_0_[i_49_], checkpoints, trackers);
                } else {
                    if ((var_xtGraphics).starcnt == 130) {
                        (medium).adv = 1900;
                        (medium).zy = 40;
                        (medium).vxz = 70;
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                    }
                    if ((var_xtGraphics).starcnt != 0)
                        (var_xtGraphics).starcnt--;
                }
                if ((var_xtGraphics).starcnt < 38) {
                    if (view == 0) {
                        medium.follow(contos_0_[0], (mads[0]).cxz, (u[0]).lookback);
                        var_xtGraphics.stat(mads[0], checkpoints, u[0], true);
                    }
                    if (view == 1) {
                        medium.around(contos_0_[0], false);
                        var_xtGraphics.stat(mads[0], checkpoints, u[0], false);
                    }
                    if (view == 2) {
                        medium.watch(contos_0_[0], (mads[0]).mxz);
                        var_xtGraphics.stat(mads[0], checkpoints, u[0], false);
                    }
                    if (mouses == 1) {
                        (u[0]).enter = true;
                        mouses = 0;
                    }
                } else {
                    int i_50_ = 3;
                    if ((var_xtGraphics).nplayers == 1)
                        i_50_ = 0;
                    medium.around(contos_0_[i_50_], true);
                    if ((u[0]).enter || (u[0]).handb) {
                        (var_xtGraphics).starcnt = 38;
                        (u[0]).enter = false;
                        (u[0]).handb = false;
                    }
                    if ((var_xtGraphics).starcnt == 38) {
                        mouses = 0;
                        (medium).vert = false;
                        (medium).adv = 900;
                        (medium).vxz = 180;
                        checkpoints.checkstat(mads, contos_0_, record, (var_xtGraphics).nplayers, (var_xtGraphics).im, 0);
                        medium.follow(contos_0_[0], (mads[0]).cxz, 0);
                        var_xtGraphics.stat(mads[0], checkpoints, u[0], true);
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                    }
                }
            }
            if ((var_xtGraphics).fase == 7001) {
                for (int i_51_ = 0; i_51_ < (var_xtGraphics).nplayers; i_51_++) {
                    if ((mads[i_51_]).newedcar == 0 && (mads[i_51_]).newcar) {
                        int i_52_ = (contos_0_[i_51_]).xz;
                        int i_53_ = (contos_0_[i_51_]).xy;
                        int i_54_ = (contos_0_[i_51_]).zy;
                        var_xtGraphics.colorCar(contos[(mads[i_51_]).cn], i_51_);
                        contos_0_[i_51_] = new ContO(contos[(mads[i_51_]).cn], (contos_0_[i_51_]).x, (contos_0_[i_51_]).y, (contos_0_[i_51_]).z, 0);
                        (contos_0_[i_51_]).xz = i_52_;
                        (contos_0_[i_51_]).xy = i_53_;
                        (contos_0_[i_51_]).zy = i_54_;
                        (mads[i_51_]).newedcar = 20;
                    }
                }
                medium.d(rd);
                int i_55_ = 0;
                int[] is = new int[10000];
                for (int i_56_ = 0; i_56_ < nob; i_56_++) {
                    if ((contos_0_[i_56_]).dist != 0) {
                        is[i_55_] = i_56_;
                        i_55_++;
                    } else
                        contos_0_[i_56_].d(rd);
                }
                int[] is_57_ = new int[i_55_];
                int[] is_58_ = new int[i_55_];
                for (int i_59_ = 0; i_59_ < i_55_; i_59_++)
                    is_57_[i_59_] = 0;
                for (int i_60_ = 0; i_60_ < i_55_; i_60_++) {
                    for (int i_61_ = i_60_ + 1; i_61_ < i_55_; i_61_++) {
                        if ((contos_0_[is[i_60_]]).dist < (contos_0_[is[i_61_]]).dist)
                            is_57_[i_60_]++;
                        else
                            is_57_[i_61_]++;
                    }
                    is_58_[is_57_[i_60_]] = i_60_;
                }
                for (int i_62_ = 0; i_62_ < i_55_; i_62_++) {
                    if (is[is_58_[i_62_]] < (var_xtGraphics).nplayers && is[is_58_[i_62_]] != (var_xtGraphics).im)
                        udpmistro.readContOinfo(contos_0_[is[is_58_[i_62_]]], is[is_58_[i_62_]]);
                    contos_0_[is[is_58_[i_62_]]].d(rd);
                }
                if ((var_xtGraphics).starcnt == 0) {
                    if ((var_xtGraphics).multion == 1) {
                        int i_63_ = 1;
                        for (int i_64_ = 0; i_64_ < (var_xtGraphics).nplayers; i_64_++) {
                            if ((var_xtGraphics).im != i_64_) {
                                udpmistro.readinfo(mads[i_64_], contos_0_[i_64_], u[i_63_], i_64_, (checkpoints).dested);
                                i_63_++;
                            }
                        }
                    } else {
                        for (int i_65_ = 0; i_65_ < (var_xtGraphics).nplayers; i_65_++)
                            udpmistro.readinfo(mads[i_65_], contos_0_[i_65_], u[i_65_], i_65_, (checkpoints).dested);
                    }
                    for (int i_66_ = 0; i_66_ < (var_xtGraphics).nplayers; i_66_++) {
                        for (int i_67_ = 0; i_67_ < (var_xtGraphics).nplayers; i_67_++) {
                            if (i_67_ != i_66_)
                                mads[i_66_].colide(contos_0_[i_66_], mads[i_67_], contos_0_[i_67_]);
                        }
                    }
                    if ((var_xtGraphics).multion == 1) {
                        int i_68_ = 1;
                        for (int i_69_ = 0; i_69_ < (var_xtGraphics).nplayers; i_69_++) {
                            if ((var_xtGraphics).im != i_69_) {
                                mads[i_69_].drive(u[i_68_], contos_0_[i_69_], trackers, checkpoints);
                                i_68_++;
                            } else
                                mads[i_69_].drive(u[0], contos_0_[i_69_], trackers, checkpoints);
                        }
                        for (int i_70_ = 0; i_70_ < (var_xtGraphics).nplayers; i_70_++)
                            record.rec(contos_0_[i_70_], i_70_, (mads[i_70_]).squash, (mads[i_70_]).lastcolido, (mads[i_70_]).cntdest, (var_xtGraphics).im);
                    } else {
                        for (int i_71_ = 0; i_71_ < (var_xtGraphics).nplayers; i_71_++)
                            mads[i_71_].drive(u[i_71_], contos_0_[i_71_], trackers, checkpoints);
                    }
                    checkpoints.checkstat(mads, contos_0_, record, (var_xtGraphics).nplayers, (var_xtGraphics).im, (var_xtGraphics).multion);
                } else {
                    if ((var_xtGraphics).starcnt == 130) {
                        (medium).adv = 1900;
                        (medium).zy = 40;
                        (medium).vxz = 70;
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                        repaint();
                        if ((var_xtGraphics).lan) {
                            udpmistro.UDPConnectLan((var_xtGraphics).localserver, (var_xtGraphics).nplayers, (var_xtGraphics).im);
                            if ((var_xtGraphics).im == 0)
                                var_xtGraphics.setbots((udpmistro).isbot, (udpmistro).frame);
                        } else
                            udpmistro.UDPConnectOnline((var_xtGraphics).server, (var_xtGraphics).gameport, (var_xtGraphics).nplayers, (var_xtGraphics).im);
                        if ((var_xtGraphics).multion >= 2) {
                            (var_xtGraphics).im = (int) (Math.random() * (double) (var_xtGraphics).nplayers);
                            (var_xtGraphics).starcnt = 0;
                        }
                    }
                    if ((var_xtGraphics).starcnt == 50)
                        (udpmistro).frame[(udpmistro).im][0] = 0;
                    if ((var_xtGraphics).starcnt != 39 && (var_xtGraphics).starcnt != 0)
                        (var_xtGraphics).starcnt--;
                    if ((udpmistro).go && (var_xtGraphics).starcnt >= 39) {
                        (var_xtGraphics).starcnt = 38;
                        if ((var_xtGraphics).lan) {
                            int i_72_ = (checkpoints).stage;
                            if (i_72_ < 0)
                                i_72_ = 33;
                            if ((var_xtGraphics).loadedt)
                                (var_xtGraphics).strack.play();
                        }
                    }
                }
                if ((var_xtGraphics).lan && (udpmistro).im == 0) {
                    for (int i_73_ = 2; i_73_ < (var_xtGraphics).nplayers; i_73_++) {
                        if ((udpmistro).isbot[i_73_]) {
                            u[i_73_].preform(mads[i_73_], contos_0_[i_73_], checkpoints, trackers);
                            udpmistro.setinfo(mads[i_73_], contos_0_[i_73_], u[i_73_], (checkpoints).pos[i_73_], (checkpoints).magperc[i_73_], false, i_73_);
                        }
                    }
                }
                if ((var_xtGraphics).starcnt < 38) {
                    if ((var_xtGraphics).multion == 1) {
                        udpmistro.setinfo(mads[(var_xtGraphics).im], contos_0_[(var_xtGraphics).im], u[0], (checkpoints).pos[(var_xtGraphics).im], (checkpoints).magperc[(var_xtGraphics).im], (var_xtGraphics).holdit, (var_xtGraphics).im);
                        if (view == 0) {
                            medium.follow(contos_0_[(var_xtGraphics).im], (mads[(var_xtGraphics).im]).cxz, (u[0]).lookback);
                            var_xtGraphics.stat(mads[(var_xtGraphics).im], checkpoints, u[0], true);
                        }
                        if (view == 1) {
                            medium.around(contos_0_[(var_xtGraphics).im], false);
                            var_xtGraphics.stat(mads[(var_xtGraphics).im], checkpoints, u[0], false);
                        }
                        if (view == 2) {
                            medium.watch(contos_0_[(var_xtGraphics).im], (mads[(var_xtGraphics).im]).mxz);
                            var_xtGraphics.stat(mads[(var_xtGraphics).im], checkpoints, u[0], false);
                        }
                    } else {
                        if (view == 0)
                            medium.getaround(contos_0_[(var_xtGraphics).im]);
                        if (view == 1)
                            medium.getfollow(contos_0_[(var_xtGraphics).im], (mads[(var_xtGraphics).im]).cxz, (u[0]).lookback);
                        if (view == 2)
                            medium.watch(contos_0_[(var_xtGraphics).im], (mads[(var_xtGraphics).im]).mxz);
                        var_xtGraphics.stat(mads[(var_xtGraphics).im], checkpoints, u[0], true);
                    }
                    if (mouses == 1) {
                        if ((var_xtGraphics).holdit && (var_xtGraphics).exitm != 4 && (var_xtGraphics).multion == 1)
                            (u[0]).enter = true;
                        mouses = 0;
                    }
                } else {
                    medium.around(contos_0_[(var_xtGraphics).im], true);
                    if ((var_xtGraphics).starcnt == 39)
                        var_xtGraphics.waitenter();
                    if ((var_xtGraphics).starcnt == 38) {
                        (var_xtGraphics).forstart = 0;
                        mouses = 0;
                        (medium).vert = false;
                        (medium).adv = 900;
                        (medium).vxz = 180;
                        checkpoints.checkstat(mads, contos_0_, record, (var_xtGraphics).nplayers, (var_xtGraphics).im, (var_xtGraphics).multion);
                        medium.follow(contos_0_[(var_xtGraphics).im], (mads[(var_xtGraphics).im]).cxz, 0);
                        var_xtGraphics.stat(mads[(var_xtGraphics).im], checkpoints, u[0], true);
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(0, 0, 800, 450);
                    }
                }
                var_xtGraphics.multistat(u[0], checkpoints, xm, ym, moused, udpmistro);
            }
            if ((var_xtGraphics).fase == -1) {
                if (i_6_ == 0) {
                    for (int i_74_ = 0; i_74_ < (var_xtGraphics).nplayers; i_74_++) {
                        (record).ocar[i_74_] = new ContO(contos_0_[i_74_], 0, 0, 0, 0);
                        contos_0_[i_74_] = new ContO((record).car[0][i_74_], 0, 0, 0, 0);
                    }
                }
                medium.d(rd);
                int i_75_ = 0;
                int[] is = new int[100];
                for (int i_76_ = 0; i_76_ < nob; i_76_++) {
                    if ((contos_0_[i_76_]).dist != 0) {
                        is[i_75_] = i_76_;
                        i_75_++;
                    } else
                        contos_0_[i_76_].d(rd);
                }
                int[] is_77_ = new int[i_75_];
                for (int i_78_ = 0; i_78_ < i_75_; i_78_++)
                    is_77_[i_78_] = 0;
                for (int i_79_ = 0; i_79_ < i_75_; i_79_++) {
                    for (int i_80_ = i_79_ + 1; i_80_ < i_75_; i_80_++) {
                        if ((contos_0_[is[i_79_]]).dist != (contos_0_[is[i_80_]]).dist) {
                            if ((contos_0_[is[i_79_]]).dist < (contos_0_[is[i_80_]]).dist)
                                is_77_[i_79_]++;
                            else
                                is_77_[i_80_]++;
                        } else if (i_80_ > i_79_)
                            is_77_[i_79_]++;
                        else
                            is_77_[i_80_]++;
                    }
                }
                for (int i_81_ = 0; i_81_ < i_75_; i_81_++) {
                    for (int i_82_ = 0; i_82_ < i_75_; i_82_++) {
                        if (is_77_[i_82_] == i_81_)
                            contos_0_[is[i_82_]].d(rd);
                    }
                }
                if ((u[0]).enter || (u[0]).handb || mouses == 1) {
                    i_6_ = 299;
                    (u[0]).enter = false;
                    (u[0]).handb = false;
                    mouses = 0;
                }
                for (int i_83_ = 0; i_83_ < (var_xtGraphics).nplayers; i_83_++) {
                    if ((record).fix[i_83_] == i_6_) {
                        if ((contos_0_[i_83_]).dist == 0)
                            (contos_0_[i_83_]).fcnt = 8;
                        else
                            (contos_0_[i_83_]).fix = true;
                    }
                    if ((contos_0_[i_83_]).fcnt == 7 || (contos_0_[i_83_]).fcnt == 8) {
                        contos_0_[i_83_] = new ContO(contos[(mads[i_83_]).cn], 0, 0, 0, 0);
                        (record).cntdest[i_83_] = 0;
                    }
                    if (i_6_ == 299)
                        contos_0_[i_83_] = new ContO((record).ocar[i_83_], 0, 0, 0, 0);
                    record.play(contos_0_[i_83_], mads[i_83_], i_83_, i_6_);
                }
                if (++i_6_ == 300) {
                    i_6_ = 0;
                    (var_xtGraphics).fase = -6;
                } else
                    var_xtGraphics.replyn();
                medium.around(contos_0_[0], false);
            }
            if ((var_xtGraphics).fase == -2) {
                if ((var_xtGraphics).multion >= 2)
                    (record).hcaught = false;
                u[0].falseo(3);
                if ((record).hcaught && (record).wasted == 0 && (record).whenwasted != 229 && ((checkpoints).stage == 1 || (checkpoints).stage == 2) && (var_xtGraphics).looped != 0)
                    (record).hcaught = false;
                if ((record).hcaught) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(0, 0, 800, 450);
                    repaint();
                }
                if ((var_xtGraphics).multion != 0) {
                    udpmistro.UDPquit();
                    var_xtGraphics.stopchat();
                    if (cmsg.isShowing())
                        cmsg.hide();
                    cmsg.setText("");
                    requestFocus();
                }
                if ((record).hcaught) {
                    if ((double) medium.random() > 0.45)
                        (medium).vert = false;
                    else
                        (medium).vert = true;
                    (medium).adv = (int) (900.0F * medium.random());
                    (medium).vxz = (int) (360.0F * medium.random());
                    i_6_ = 0;
                    (var_xtGraphics).fase = -3;
                    i_7_ = 0;
                    i_8_ = 0;
                } else {
                    i_6_ = -2;
                    (var_xtGraphics).fase = -4;
                }
            }
            if ((var_xtGraphics).fase == -3) {
                if (i_6_ == 0) {
                    if ((record).wasted == 0) {
                        if ((record).whenwasted == 229) {
                            i_9_ = 67;
                            (medium).vxz += 90;
                        } else {
                            i_9_ = (int) (medium.random() * 4.0F);
                            if (i_9_ == 1 || i_9_ == 3)
                                i_9_ = 69;
                            if (i_9_ == 2 || i_9_ == 4)
                                i_9_ = 30;
                        }
                    } else if ((record).closefinish != 0 && i_8_ != 0)
                        (medium).vxz += 90;
                    for (int i_84_ = 0; i_84_ < (var_xtGraphics).nplayers; i_84_++)
                        contos_0_[i_84_] = new ContO((record).starcar[i_84_], 0, 0, 0, 0);
                }
                medium.d(rd);
                int i_85_ = 0;
                int[] is = new int[100];
                for (int i_86_ = 0; i_86_ < nob; i_86_++) {
                    if ((contos_0_[i_86_]).dist != 0) {
                        is[i_85_] = i_86_;
                        i_85_++;
                    } else
                        contos_0_[i_86_].d(rd);
                }
                int[] is_87_ = new int[i_85_];
                for (int i_88_ = 0; i_88_ < i_85_; i_88_++)
                    is_87_[i_88_] = 0;
                for (int i_89_ = 0; i_89_ < i_85_; i_89_++) {
                    for (int i_90_ = i_89_ + 1; i_90_ < i_85_; i_90_++) {
                        if ((contos_0_[is[i_89_]]).dist != (contos_0_[is[i_90_]]).dist) {
                            if ((contos_0_[is[i_89_]]).dist < (contos_0_[is[i_90_]]).dist)
                                is_87_[i_89_]++;
                            else
                                is_87_[i_90_]++;
                        } else if (i_90_ > i_89_)
                            is_87_[i_89_]++;
                        else
                            is_87_[i_90_]++;
                    }
                }
                for (int i_91_ = 0; i_91_ < i_85_; i_91_++) {
                    for (int i_92_ = 0; i_92_ < i_85_; i_92_++) {
                        if (is_87_[i_92_] == i_91_)
                            contos_0_[is[i_92_]].d(rd);
                    }
                }
                for (int i_93_ = 0; i_93_ < (var_xtGraphics).nplayers; i_93_++) {
                    if ((record).hfix[i_93_] == i_6_) {
                        if ((contos_0_[i_93_]).dist == 0)
                            (contos_0_[i_93_]).fcnt = 8;
                        else
                            (contos_0_[i_93_]).fix = true;
                    }
                    if ((contos_0_[i_93_]).fcnt == 7 || (contos_0_[i_93_]).fcnt == 8) {
                        contos_0_[i_93_] = new ContO(contos[(mads[i_93_]).cn], 0, 0, 0, 0);
                        (record).cntdest[i_93_] = 0;
                    }
                    record.playh(contos_0_[i_93_], mads[i_93_], i_93_, i_6_, (var_xtGraphics).im);
                }
                if (i_8_ == 2 && i_6_ == 299)
                    (u[0]).enter = true;
                if ((u[0]).enter || (u[0]).handb) {
                    (var_xtGraphics).fase = -4;
                    (u[0]).enter = false;
                    (u[0]).handb = false;
                    i_6_ = -7;
                } else {
                    var_xtGraphics.levelhigh((record).wasted, (record).whenwasted, (record).closefinish, i_6_, (checkpoints).stage);
                    if (i_6_ == 0 || i_6_ == 1 || i_6_ == 2) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.fillRect(0, 0, 800, 450);
                    }
                    if ((record).wasted != (var_xtGraphics).im) {
                        if ((record).closefinish == 0) {
                            if (i_7_ == 9 || i_7_ == 11) {
                                rd.setColor(new Color(255, 255, 255));
                                rd.fillRect(0, 0, 800, 450);
                            }
                            if (i_7_ == 0)
                                medium.around(contos_0_[(var_xtGraphics).im], false);
                            if (i_7_ > 0 && i_7_ < 20)
                                medium.transaround(contos_0_[(var_xtGraphics).im], contos_0_[(record).wasted], i_7_);
                            if (i_7_ == 20)
                                medium.around(contos_0_[(record).wasted], false);
                            if (i_6_ > (record).whenwasted && i_7_ != 20)
                                i_7_++;
                            if ((i_7_ == 0 || i_7_ == 20) && ++i_6_ == 300) {
                                i_6_ = 0;
                                i_7_ = 0;
                                i_8_++;
                            }
                        } else if ((record).closefinish == 1) {
                            if (i_7_ == 0)
                                medium.around(contos_0_[(var_xtGraphics).im], false);
                            if (i_7_ > 0 && i_7_ < 20)
                                medium.transaround(contos_0_[(var_xtGraphics).im], contos_0_[(record).wasted], i_7_);
                            if (i_7_ == 20)
                                medium.around(contos_0_[(record).wasted], false);
                            if (i_7_ > 20 && i_7_ < 40)
                                medium.transaround(contos_0_[(record).wasted], contos_0_[(var_xtGraphics).im], i_7_ - 20);
                            if (i_7_ == 40)
                                medium.around(contos_0_[(var_xtGraphics).im], false);
                            if (i_7_ > 40 && i_7_ < 60)
                                medium.transaround(contos_0_[(var_xtGraphics).im], contos_0_[(record).wasted], i_7_ - 40);
                            if (i_7_ == 60)
                                medium.around(contos_0_[(record).wasted], false);
                            if (i_6_ > 160 && i_7_ < 20)
                                i_7_++;
                            if (i_6_ > 230 && i_7_ < 40)
                                i_7_++;
                            if (i_6_ > 280 && i_7_ < 60)
                                i_7_++;
                            if ((i_7_ == 0 || i_7_ == 20 || i_7_ == 40 || i_7_ == 60) && ++i_6_ == 300) {
                                i_6_ = 0;
                                i_7_ = 0;
                                i_8_++;
                            }
                        } else {
                            if (i_7_ == 0)
                                medium.around(contos_0_[(var_xtGraphics).im], false);
                            if (i_7_ > 0 && i_7_ < 20)
                                medium.transaround(contos_0_[(var_xtGraphics).im], contos_0_[(record).wasted], i_7_);
                            if (i_7_ == 20)
                                medium.around(contos_0_[(record).wasted], false);
                            if (i_7_ > 20 && i_7_ < 40)
                                medium.transaround(contos_0_[(record).wasted], contos_0_[(var_xtGraphics).im], i_7_ - 20);
                            if (i_7_ == 40)
                                medium.around(contos_0_[(var_xtGraphics).im], false);
                            if (i_7_ > 40 && i_7_ < 60)
                                medium.transaround(contos_0_[(var_xtGraphics).im], contos_0_[(record).wasted], i_7_ - 40);
                            if (i_7_ == 60)
                                medium.around(contos_0_[(record).wasted], false);
                            if (i_7_ > 60 && i_7_ < 80)
                                medium.transaround(contos_0_[(record).wasted], contos_0_[(var_xtGraphics).im], i_7_ - 60);
                            if (i_7_ == 80)
                                medium.around(contos_0_[(var_xtGraphics).im], false);
                            if (i_6_ > 90 && i_7_ < 20)
                                i_7_++;
                            if (i_6_ > 160 && i_7_ < 40)
                                i_7_++;
                            if (i_6_ > 230 && i_7_ < 60)
                                i_7_++;
                            if (i_6_ > 280 && i_7_ < 80)
                                i_7_++;
                            if ((i_7_ == 0 || i_7_ == 20 || i_7_ == 40 || i_7_ == 60 || i_7_ == 80) && ++i_6_ == 300) {
                                i_6_ = 0;
                                i_7_ = 0;
                                i_8_++;
                            }
                        }
                    } else {
                        if (i_9_ == 67 && (i_7_ == 3 || i_7_ == 31 || i_7_ == 66)) {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 800, 450);
                        }
                        if (i_9_ == 69 && (i_7_ == 3 || i_7_ == 5 || i_7_ == 31 || i_7_ == 33 || i_7_ == 66 || i_7_ == 68)) {
                            rd.setColor(new Color(255, 255, 255));
                            rd.fillRect(0, 0, 800, 450);
                        }
                        if (i_9_ == 30 && i_7_ >= 1 && i_7_ < 30) {
                            if (i_7_ % (int) (2.0F + medium.random() * 3.0F) == 0 && !bool_10_) {
                                rd.setColor(new Color(255, 255, 255));
                                rd.fillRect(0, 0, 800, 450);
                                bool_10_ = true;
                            } else
                                bool_10_ = false;
                        }
                        if (i_6_ > (record).whenwasted && i_7_ != i_9_)
                            i_7_++;
                        medium.around(contos_0_[(var_xtGraphics).im], false);
                        if ((i_7_ == 0 || i_7_ == i_9_) && ++i_6_ == 300) {
                            i_6_ = 0;
                            i_7_ = 0;
                            i_8_++;
                        }
                    }
                }
            }
            if ((var_xtGraphics).fase == -4) {
                if (i_6_ == 0) {
                    var_xtGraphics.sendwin(checkpoints);
                    if ((var_xtGraphics).winner && (var_xtGraphics).multion == 0 && (var_xtGraphics).gmode != 0 && (checkpoints).stage != 27 && (checkpoints).stage == (var_xtGraphics).unlocked[(var_xtGraphics).gmode - 1] + ((var_xtGraphics).gmode - 1) * 10) {
                        (var_xtGraphics).unlocked[(var_xtGraphics).gmode - 1]++;
                        setcarcookie((var_xtGraphics).sc[0], (var_xtGraphics).arnp, (var_xtGraphics).gmode, (var_xtGraphics).unlocked, false);
                        (var_xtGraphics).unlocked[(var_xtGraphics).gmode - 1]--;
                    }
                }
                if (i_6_ <= 0) {
                    rd.drawImage((var_xtGraphics).mdness, 289, 30, null);
                    rd.drawImage((var_xtGraphics).dude[0], 135, 10, null);
                }
                if (i_6_ >= 0)
                    var_xtGraphics.fleximage(offImage, i_6_, (checkpoints).stage);
                if (++i_6_ == 7) {
                    (var_xtGraphics).fase = -5;
                    rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                }
            }
            if ((var_xtGraphics).fase == -6) {
                repaint();
                var_xtGraphics.pauseimage(offImage);
                (var_xtGraphics).fase = -7;
                mouses = 0;
            }
            if ((var_xtGraphics).fase == -7) {
                var_xtGraphics.pausedgame((checkpoints).stage, u[0], record);
                if (i_6_ != 0)
                    i_6_ = 0;
                var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
                if (mouses == 2)
                    mouses = 0;
                if (mouses == 1)
                    mouses = 2;
            }
            if ((var_xtGraphics).fase == -8) {
                var_xtGraphics.cantreply();
                if (++i_6_ == 150 || (u[0]).enter || (u[0]).handb || mouses == 1) {
                    (var_xtGraphics).fase = -7;
                    mouses = 0;
                    (u[0]).enter = false;
                    (u[0]).handb = false;
                }
            }
            if (lostfcs && (var_xtGraphics).fase == 7001) {
                if (fcscnt == 0) {
                    if (!(u[0]).chatup)
                        requestFocus();
                    fcscnt = 10;
                } else
                    fcscnt--;
            }
            repaint();
            if ((var_xtGraphics).im > -1 && (var_xtGraphics).im < 7) {
                int i_94_ = 0;
                if ((var_xtGraphics).multion == 2 || (var_xtGraphics).multion == 3) {
                    i_94_ = (var_xtGraphics).im;
                    (u[i_94_]).mutem = (u[0]).mutem;
                    (u[i_94_]).mutes = (u[0]).mutes;
                }
                var_xtGraphics.playsounds(mads[(var_xtGraphics).im], u[i_94_], (checkpoints).stage);
            }
            date = new Date();
            long l_95_ = date.getTime();
            if ((var_xtGraphics).fase == 0 || (var_xtGraphics).fase == -1 || (var_xtGraphics).fase == -3 || (var_xtGraphics).fase == 7001) {
                if (!bool_3_) {
                    i = 15;
                    f_2_ = f;
                    if (f_2_ < 30.0F)
                        f_2_ = 30.0F;
                    bool_3_ = true;
                    i_5_ = 0;
                }
                if (i_5_ == 10) {
                    float f_96_ = ((float) i_4_ + (udpmistro).freg - (float) (l_95_ - l_1_)) / 20.0F;
                    if (f_96_ > 40.0F)
                        f_96_ = 40.0F;
                    if (f_96_ < -40.0F)
                        f_96_ = -40.0F;
                    f_2_ += f_96_;
                    if (f_2_ < 5.0F)
                        f_2_ = 5.0F;
                    medium.adjstfade(f_2_, (var_xtGraphics).starcnt);
                    l_1_ = l_95_;
                    i_5_ = 0;
                } else
                    i_5_++;
            } else {
                if (bool_3_) {
                    i = 30;
                    f = f_2_;
                    bool_3_ = false;
                    i_5_ = 0;
                }
                if (i_5_ == 10) {
                    if (l_95_ - l_1_ < 400L)
                        f_2_ += 3.5;
                    else {
                        f_2_ -= 3.5;
                        if (f_2_ < 5.0F)
                            f_2_ = 5.0F;
                    }
                    l_1_ = l_95_;
                    i_5_ = 0;
                } else
                    i_5_++;
            }
            if (exwist) {
                rd.dispose();
                var_xtGraphics.stopallnow();
                cardefine.stopallnow();
                udpmistro.UDPquit();
                if (bool) {
                    lobby.stopallnow();
                    login.stopallnow();
                    globe.stopallnow();
                }
                System.gc();
                gamer.stop();
                gamer = null;
            }
            l = (long) Math.round(f_2_) - (l_95_ - l_11_);
            if (l < (long) i)
                l = (long) i;
            try {
                if (gamer != null) {
                    /* empty */
                }
                Thread.sleep(l);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
    }
    
    public void paint(Graphics graphics) {
        if (lastw != getWidth() || lasth != getHeight()) {
            lastw = getWidth();
            lasth = getHeight();
            showsize = 100;
            if (lastw <= 800 || lasth <= 550)
                reqmult = 0.0F;
        }
        if (showsize != 0) {
            if (showsize == 100 || showsize == 70)
                graphics.clearRect(0, 0, getWidth(), getHeight());
            float f = (float) (getWidth() - 40) / 800.0F - 1.0F;
            if (f > (float) (getHeight() - 70) / 450.0F - 1.0F)
                f = (float) (getHeight() - 70) / 450.0F - 1.0F;
            if (f > 1.0F)
                f = 1.0F;
            if (f < 0.0F)
                f = 0.0F;
            apmult = 1.0F + f * reqmult;
            if (!oncarm)
                graphics.drawImage(carmaker[0], 50, 14, this);
            else
                graphics.drawImage(carmaker[1], 50, 14, this);
            if (!onstgm)
                graphics.drawImage(stagemaker[0], getWidth() - 208, 14, this);
            else
                graphics.drawImage(stagemaker[1], getWidth() - 208, 14, this);
            graphics.drawImage(sizebar, getWidth() / 2 - 120, 23, this);
            graphics.drawImage(blb, (int) ((float) (getWidth() / 2 - 112) + 141.0F * reqmult), 23, this);
            graphics.drawImage(chkbx[smooth], getWidth() / 2 + 57, 23, this);
            graphics.setFont(new Font("Arial", 1, 11));
            graphics.setColor(new Color(74, 99, 125));
            graphics.drawString("Screen Size:", getWidth() / 2 - 114, 17);
            graphics.drawString("Smooth", getWidth() / 2 + 74, 34);
            graphics.setColor(new Color(0, 0, 0));
            graphics.fillRect(getWidth() / 2 - 43, 5, 80, 16);
            graphics.setColor(new Color(121, 135, 152));
            String string = new StringBuilder().append("").append((int) (apmult * 100.0F)).append("%").toString();
            if (reqmult == 0.0F)
                string = "Original";
            if (reqmult == 1.0F)
                string = "Maximum";
            graphics.drawString(string, getWidth() / 2 - 40, 17);
            if (!oncarm && !onstgm)
                showsize--;
            if (mload == 3) {
                showsize = 0;
                cmsg.show();
                apx = (int) ((float) (getWidth() / 2) - 400.0F * apmult);
                apy = (int) ((float) (getHeight() / 2) - 225.0F * apmult - 50.0F);
                if (apy < 50)
                    apy = 50;
                movefield(cmsg, 50, 115, 360, 22);
            }
            if (showsize == 0) {
                graphics.setColor(new Color(0, 0, 0));
                graphics.fillRect(getWidth() / 2 - 150, 0, 300, 40);
                graphics.fillRect(50, 14, 142, 23);
                graphics.fillRect(getWidth() - 208, 14, 158, 23);
            }
        }
        apx = (int) ((float) (getWidth() / 2) - 400.0F * apmult);
        apy = (int) ((float) (getHeight() / 2) - 225.0F * apmult - 50.0F);
        if (apy < 50)
            apy = 50;
        if (apmult > 1.0F) {
            if (smooth == 1) {
                Graphics2D graphics2d = (Graphics2D) graphics;
                graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                graphics2d.drawImage(offImage, apx, apy, (int) (800.0F * apmult), (int) (450.0F * apmult), this);
            } else
                graphics.drawImage(offImage, apx, apy, (int) (800.0F * apmult), (int) (450.0F * apmult), this);
        } else
            graphics.drawImage(offImage, apx, apy, this);
    }
    
    public void update(Graphics graphics) {
        paint(graphics);
    }
    
    public void init() {
        setBackground(new Color(0, 0, 0));
        offImage = createImage(800, 450);
        if (offImage != null)
            rd = (Graphics2D) offImage.getGraphics();
        rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        setLayout(null);
        tnick = new TextField("Nickbname");
        tnick.setFont(new Font("Arial", 1, 13));
        tpass = new TextField("");
        tpass.setFont(new Font("Arial", 1, 13));
        tpass.setEchoCharacter('*');
        temail = new TextField("");
        temail.setFont(new Font("Arial", 1, 13));
        cmsg = new TextField("");
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
        snfmm.setFont(new Font("Arial", 1, 13));
        snfm1.setFont(new Font("Arial", 1, 13));
        snfm2.setFont(new Font("Arial", 1, 13));
        mstgs.setFont(new Font("Arial", 1, 13));
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
        sgame.add(rd, " NFM 1     ");
        sgame.add(rd, " NFM 2     ");
        sgame.add(rd, " My Stages ");
        sgame.add(rd, " Weekly Top20 ");
        sgame.add(rd, " Monthly Top20 ");
        sgame.add(rd, " All Time Top20 ");
        sgame.add(rd, " Stage Maker ");
        snfmm.add(rd, "Select Stage");
        snfm1.add(rd, "Select Stage");
        snfm2.add(rd, "Select Stage");
        mstgs.add(rd, "Suddenly the King becomes Santa's Little Helper");
        snpls.add(rd, "Select");
        swait.add(rd, "1 Minute");
        for (int i = 0; i < 5; i++)
            snfmm.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());
        for (int i = 0; i < 10; i++)
            snfm1.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());
        for (int i = 0; i < 17; i++)
            snfm2.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());
        for (int i = 0; i < 6; i++)
            snpls.add(rd, new StringBuilder().append("    ").append(i + 2).append("").toString());
        for (int i = 0; i < 6; i++)
            snbts.add(rd, new StringBuilder().append("    ").append(i).append("    ").toString());
        for (int i = 0; i < 2; i++)
            swait.add(rd, new StringBuilder().append("").append(i + 2).append(" Minutes").toString());
        for (int i = 0; i < 15; i++)
            slaps.add(rd, new StringBuilder().append("").append(i + 1).append("").toString());
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
        gmode.add(rd, " Normal Game ");
        gmode.add(rd, " Practice Game ");
        (rooms).rooms = true;
        rooms.add(rd, "Ghostrider :: 1");
        sendtyp.add(rd, "Write a Message");
        sendtyp.add(rd, "Share a Custom Car");
        sendtyp.add(rd, "Share a Custom Stage");
        senditem.add(rd, "Suddenly the King becomes Santa's Little Helper");
        hidefields();
    }
    
    public void hidefields() {
        mmsg.hide();
        senditem.hide();
        sendtyp.hide();
        rooms.hide();
        mstgs.hide();
        gmode.hide();
        sclass.hide();
        scars.hide();
        sfix.hide();
        mycar.hide();
        notp.hide();
        keplo.hide();
        tnick.hide();
        tpass.hide();
        temail.hide();
        cmsg.hide();
        sgame.hide();
        slaps.hide();
        snfm1.hide();
        snfmm.hide();
        snfm2.hide();
        snpls.hide();
        snbts.hide();
        swait.hide();
    }
    
    public void drawms() {
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
        if (sclass.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (scars.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (sfix.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (sgame.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (snfm1.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (snfm2.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (snfmm.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (mstgs.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (rooms.draw(rd, xm, ym, moused, 450, false))
            openm = true;
        if (sendtyp.draw(rd, xm, ym, moused, 450, true))
            openm = true;
        if (senditem.draw(rd, xm, ym, moused, 450, true))
            openm = true;
    }
    
    public void movefield(Component component, int i, int i_97_, int i_98_, int i_99_) {
        if (i_98_ == 360 || i_98_ == 576) {
            i = (int) ((float) i * apmult + (float) apx + (float) (component.getWidth() / 2) * (apmult - 1.0F));
            i_97_ = (int) ((float) i_97_ * apmult + (float) apy + 12.0F * (apmult - 1.0F));
        } else {
            i = (int) ((float) i * apmult + (float) apx);
            i_97_ = (int) ((float) i_97_ * apmult + (float) apy + 12.0F * (apmult - 1.0F));
        }
        if (component.getX() != i || component.getY() != i_97_)
            component.setBounds(i, i_97_, i_98_, i_99_);
    }
    
    public void loadstage(ContO[] contos, ContO[] contos_100_, Medium medium, Trackers trackers, CheckPoints checkpoints, xtGraphics var_xtGraphics, Mad[] mads, Record record) {
        if ((var_xtGraphics).testdrive == 2 || (var_xtGraphics).testdrive == 4)
            (var_xtGraphics).nplayers = 1;
        if ((var_xtGraphics).gmode == 1) {
            (var_xtGraphics).nplayers = 5;
            (var_xtGraphics).xstart[4] = 0;
            (var_xtGraphics).zstart[4] = 760;
        }
        (trackers).nt = 0;
        nob = (var_xtGraphics).nplayers;
        notb = 0;
        (checkpoints).n = 0;
        (checkpoints).nsp = 0;
        (checkpoints).fn = 0;
        (checkpoints).trackname = "";
        (checkpoints).haltall = false;
        (checkpoints).wasted = 0;
        (checkpoints).catchfin = 0;
        (medium).resdown = 0;
        (medium).lightson = false;
        (medium).noelec = 0;
        (medium).ground = 250;
        (medium).trk = 0;
        view = 0;
        int i = 0;
        int i_101_ = 100;
        int i_102_ = 0;
        int i_103_ = 100;
        (var_xtGraphics).newparts = false;
        String string = "";
        try {
            DataInputStream datainputstream;
            if ((var_xtGraphics).multion == 0 && (checkpoints).stage != -2) {
                String string_104_ = new StringBuilder().append("stages/").append((checkpoints).stage).append("").toString();
                if ((checkpoints).stage == -1)
                    string_104_ = new StringBuilder().append("mystages/").append((checkpoints).name).append("").toString();
                File file = new File(new StringBuilder().append("").append(string_104_).append(".txt").toString());
                datainputstream = new DataInputStream(new FileInputStream(file));
            } else if ((checkpoints).stage > 0) {
                URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/stages/").append((checkpoints).stage).append(".txt").toString());
                datainputstream = new DataInputStream(url.openStream());
            } else {
                String string_105_ = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/").append((checkpoints).name).append(".radq").toString();
                string_105_ = string_105_.replace(' ', '_');
                URL url = new URL(string_105_);
                int i_106_ = url.openConnection().getContentLength();
                DataInputStream datainputstream_107_ = new DataInputStream(url.openStream());
                byte[] is = new byte[i_106_];
                datainputstream_107_.readFully(is);
                ZipInputStream zipinputstream;
                if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                else {
                    byte[] is_108_ = new byte[i_106_ - 40];
                    for (int i_109_ = 0; i_109_ < i_106_ - 40; i_109_++) {
                        int i_110_ = 20;
                        if (i_109_ >= 500)
                            i_110_ = 40;
                        is_108_[i_109_] = is[i_109_ + i_110_];
                    }
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_108_));
                }
                ZipEntry zipentry = zipinputstream.getNextEntry();
                int i_111_ = Integer.valueOf(zipentry.getName()).intValue();
                byte[] is_112_ = new byte[i_111_];
                int i_113_ = 0;
                int i_114_;
                for (/**/; i_111_ > 0; i_111_ -= i_114_) {
                    i_114_ = zipinputstream.read(is_112_, i_113_, i_111_);
                    i_113_ += i_114_;
                }
                zipinputstream.close();
                datainputstream_107_.close();
                datainputstream = new DataInputStream(new ByteArrayInputStream(is_112_));
            }
            String string_115_;
            while ((string_115_ = datainputstream.readLine()) != null) {
                string = new StringBuilder().append("").append(string_115_.trim()).toString();
                if (string.startsWith("snap"))
                    medium.setsnap(getint("snap", string, 0), getint("snap", string, 1), getint("snap", string, 2));
                if (string.startsWith("sky")) {
                    medium.setsky(getint("sky", string, 0), getint("sky", string, 1), getint("sky", string, 2));
                    var_xtGraphics.snap((checkpoints).stage);
                }
                if (string.startsWith("ground"))
                    medium.setgrnd(getint("ground", string, 0), getint("ground", string, 1), getint("ground", string, 2));
                if (string.startsWith("polys"))
                    medium.setpolys(getint("polys", string, 0), getint("polys", string, 1), getint("polys", string, 2));
                if (string.startsWith("fog"))
                    medium.setfade(getint("fog", string, 0), getint("fog", string, 1), getint("fog", string, 2));
                if (string.startsWith("texture"))
                    medium.setexture(getint("texture", string, 0), getint("texture", string, 1), getint("texture", string, 2), getint("texture", string, 3));
                if (string.startsWith("clouds"))
                    medium.setcloads(getint("clouds", string, 0), getint("clouds", string, 1), getint("clouds", string, 2), getint("clouds", string, 3), getint("clouds", string, 4));
                if (string.startsWith("density")) {
                    (medium).fogd = (getint("density", string, 0) + 1) * 2 - 1;
                    if ((medium).fogd < 1)
                        (medium).fogd = 1;
                    if ((medium).fogd > 30)
                        (medium).fogd = 30;
                }
                if (string.startsWith("fadefrom"))
                    medium.fadfrom(getint("fadefrom", string, 0));
                if (string.startsWith("lightson"))
                    (medium).lightson = true;
                if (string.startsWith("mountains"))
                    (medium).mgen = getint("mountains", string, 0);
                if (string.startsWith("set")) {
                    int i_116_ = getint("set", string, 0);
                    boolean bool = true;
                    if (i_116_ >= 65 && i_116_ <= 75 && (checkpoints).notb)
                        bool = false;
                    if (bool) {
                        if (i_116_ == 49 || i_116_ == 64 || i_116_ >= 56 && i_116_ <= 61)
                            (var_xtGraphics).newparts = true;
                        if (((checkpoints).stage < 0 || (checkpoints).stage >= 28) && i_116_ >= 10 && i_116_ <= 25)
                            (medium).loadnew = true;
                        i_116_ += 46;
                        contos[nob] = new ContO(contos_100_[i_116_], getint("set", string, 1), (medium).ground - (contos_100_[i_116_]).grat, getint("set", string, 2), getint("set", string, 3));
                        if (string.indexOf(")p") != -1) {
                            (checkpoints).x[(checkpoints).n] = getint("chk", string, 1);
                            (checkpoints).z[(checkpoints).n] = getint("chk", string, 2);
                            (checkpoints).y[(checkpoints).n] = 0;
                            (checkpoints).typ[(checkpoints).n] = 0;
                            if (string.indexOf(")pt") != -1)
                                (checkpoints).typ[(checkpoints).n] = -1;
                            if (string.indexOf(")pr") != -1)
                                (checkpoints).typ[(checkpoints).n] = -2;
                            if (string.indexOf(")po") != -1)
                                (checkpoints).typ[(checkpoints).n] = -3;
                            if (string.indexOf(")ph") != -1)
                                (checkpoints).typ[(checkpoints).n] = -4;
                            if (string.indexOf("out") != -1)
                                System.out.println(new StringBuilder().append("out: ").append((checkpoints).n).toString());
                            (checkpoints).n++;
                            notb = nob + 1;
                        }
                        nob++;
                        if ((medium).loadnew)
                            (medium).loadnew = false;
                    }
                }
                if (string.startsWith("chk")) {
                    int i_117_ = getint("chk", string, 0);
                    i_117_ += 46;
                    int i_118_ = (medium).ground - (contos_100_[i_117_]).grat;
                    if (i_117_ == 110)
                        i_118_ = getint("chk", string, 4);
                    contos[nob] = new ContO(contos_100_[i_117_], getint("chk", string, 1), i_118_, getint("chk", string, 2), getint("chk", string, 3));
                    (checkpoints).x[(checkpoints).n] = getint("chk", string, 1);
                    (checkpoints).z[(checkpoints).n] = getint("chk", string, 2);
                    (checkpoints).y[(checkpoints).n] = i_118_;
                    if (getint("chk", string, 3) == 0)
                        (checkpoints).typ[(checkpoints).n] = 1;
                    else
                        (checkpoints).typ[(checkpoints).n] = 2;
                    (checkpoints).pcs = (checkpoints).n;
                    (checkpoints).n++;
                    (contos[nob]).checkpoint = (checkpoints).nsp + 1;
                    (checkpoints).nsp++;
                    nob++;
                    notb = nob;
                }
                if ((checkpoints).nfix != 5 && string.startsWith("fix")) {
                    int i_119_ = getint("fix", string, 0);
                    i_119_ += 46;
                    contos[nob] = new ContO(contos_100_[i_119_], getint("fix", string, 1), getint("fix", string, 3), getint("fix", string, 2), getint("fix", string, 4));
                    (checkpoints).fx[(checkpoints).fn] = getint("fix", string, 1);
                    (checkpoints).fz[(checkpoints).fn] = getint("fix", string, 2);
                    (checkpoints).fy[(checkpoints).fn] = getint("fix", string, 3);
                    (contos[nob]).elec = true;
                    if (getint("fix", string, 4) != 0) {
                        (checkpoints).roted[(checkpoints).fn] = true;
                        (contos[nob]).roted = true;
                    } else
                        (checkpoints).roted[(checkpoints).fn] = false;
                    if (string.indexOf(")s") != -1)
                        (checkpoints).special[(checkpoints).fn] = true;
                    else
                        (checkpoints).special[(checkpoints).fn] = false;
                    (checkpoints).fn++;
                    nob++;
                    notb = nob;
                }
                if (!(checkpoints).notb && string.startsWith("pile")) {
                    contos[nob] = new ContO(getint("pile", string, 0), getint("pile", string, 1), getint("pile", string, 2), medium, trackers, getint("pile", string, 3), getint("pile", string, 4), (medium).ground);
                    nob++;
                }
                if ((var_xtGraphics).multion == 0 && string.startsWith("nlaps")) {
                    (checkpoints).nlaps = getint("nlaps", string, 0);
                    if ((checkpoints).nlaps < 1)
                        (checkpoints).nlaps = 1;
                    if ((checkpoints).nlaps > 15)
                        (checkpoints).nlaps = 15;
                }
                if ((checkpoints).stage > 0 && string.startsWith("name"))
                    (checkpoints).name = getstring("name", string, 0).replace('|', ',');
                if (string.startsWith("stagemaker"))
                    (checkpoints).maker = getstring("stagemaker", string, 0);
                if (string.startsWith("publish"))
                    (checkpoints).pubt = getint("publish", string, 0);
                if (string.startsWith("soundtrack")) {
                    (checkpoints).trackname = getstring("soundtrack", string, 0);
                    (checkpoints).trackvol = getint("soundtrack", string, 1);
                    if ((checkpoints).trackvol < 50)
                        (checkpoints).trackvol = 50;
                    if ((checkpoints).trackvol > 300)
                        (checkpoints).trackvol = 300;
                    (var_xtGraphics).sndsize[32] = getint("soundtrack", string, 2);
                }
                if (string.startsWith("maxr")) {
                    int i_120_ = getint("maxr", string, 0);
                    int i_121_ = getint("maxr", string, 1);
                    i = i_121_;
                    int i_122_ = getint("maxr", string, 2);
                    for (int i_123_ = 0; i_123_ < i_120_; i_123_++) {
                        contos[nob] = new ContO(contos_100_[85], i_121_, (medium).ground - (contos_100_[85]).grat, i_123_ * 4800 + i_122_, 0);
                        nob++;
                    }
                    (trackers).y[(trackers).nt] = -5000;
                    (trackers).rady[(trackers).nt] = 7100;
                    (trackers).x[(trackers).nt] = i_121_ + 500;
                    (trackers).radx[(trackers).nt] = 600;
                    (trackers).z[(trackers).nt] = i_120_ * 4800 / 2 + i_122_ - 2400;
                    (trackers).radz[(trackers).nt] = i_120_ * 4800 / 2;
                    (trackers).xy[(trackers).nt] = 90;
                    (trackers).zy[(trackers).nt] = 0;
                    (trackers).dam[(trackers).nt] = 167;
                    (trackers).decor[(trackers).nt] = false;
                    (trackers).skd[(trackers).nt] = 0;
                    (trackers).nt++;
                }
                if (string.startsWith("maxl")) {
                    int i_124_ = getint("maxl", string, 0);
                    int i_125_ = getint("maxl", string, 1);
                    i_101_ = i_125_;
                    int i_126_ = getint("maxl", string, 2);
                    for (int i_127_ = 0; i_127_ < i_124_; i_127_++) {
                        contos[nob] = new ContO(contos_100_[85], i_125_, (medium).ground - (contos_100_[85]).grat, i_127_ * 4800 + i_126_, 180);
                        nob++;
                    }
                    (trackers).y[(trackers).nt] = -5000;
                    (trackers).rady[(trackers).nt] = 7100;
                    (trackers).x[(trackers).nt] = i_125_ - 500;
                    (trackers).radx[(trackers).nt] = 600;
                    (trackers).z[(trackers).nt] = i_124_ * 4800 / 2 + i_126_ - 2400;
                    (trackers).radz[(trackers).nt] = i_124_ * 4800 / 2;
                    (trackers).xy[(trackers).nt] = -90;
                    (trackers).zy[(trackers).nt] = 0;
                    (trackers).dam[(trackers).nt] = 167;
                    (trackers).decor[(trackers).nt] = false;
                    (trackers).skd[(trackers).nt] = 0;
                    (trackers).nt++;
                }
                if (string.startsWith("maxt")) {
                    int i_128_ = getint("maxt", string, 0);
                    int i_129_ = getint("maxt", string, 1);
                    i_102_ = i_129_;
                    int i_130_ = getint("maxt", string, 2);
                    for (int i_131_ = 0; i_131_ < i_128_; i_131_++) {
                        contos[nob] = new ContO(contos_100_[85], i_131_ * 4800 + i_130_, (medium).ground - (contos_100_[85]).grat, i_129_, 90);
                        nob++;
                    }
                    (trackers).y[(trackers).nt] = -5000;
                    (trackers).rady[(trackers).nt] = 7100;
                    (trackers).z[(trackers).nt] = i_129_ + 500;
                    (trackers).radz[(trackers).nt] = 600;
                    (trackers).x[(trackers).nt] = i_128_ * 4800 / 2 + i_130_ - 2400;
                    (trackers).radx[(trackers).nt] = i_128_ * 4800 / 2;
                    (trackers).zy[(trackers).nt] = 90;
                    (trackers).xy[(trackers).nt] = 0;
                    (trackers).dam[(trackers).nt] = 167;
                    (trackers).decor[(trackers).nt] = false;
                    (trackers).skd[(trackers).nt] = 0;
                    (trackers).nt++;
                }
                if (string.startsWith("maxb")) {
                    int i_132_ = getint("maxb", string, 0);
                    int i_133_ = getint("maxb", string, 1);
                    i_103_ = i_133_;
                    int i_134_ = getint("maxb", string, 2);
                    for (int i_135_ = 0; i_135_ < i_132_; i_135_++) {
                        contos[nob] = new ContO(contos_100_[85], i_135_ * 4800 + i_134_, (medium).ground - (contos_100_[85]).grat, i_133_, -90);
                        nob++;
                    }
                    (trackers).y[(trackers).nt] = -5000;
                    (trackers).rady[(trackers).nt] = 7100;
                    (trackers).z[(trackers).nt] = i_133_ - 500;
                    (trackers).radz[(trackers).nt] = 600;
                    (trackers).x[(trackers).nt] = i_132_ * 4800 / 2 + i_134_ - 2400;
                    (trackers).radx[(trackers).nt] = i_132_ * 4800 / 2;
                    (trackers).zy[(trackers).nt] = -90;
                    (trackers).xy[(trackers).nt] = 0;
                    (trackers).dam[(trackers).nt] = 167;
                    (trackers).decor[(trackers).nt] = false;
                    (trackers).skd[(trackers).nt] = 0;
                    (trackers).nt++;
                }
            }
            datainputstream.close();
            medium.newpolys(i_101_, i - i_101_, i_103_, i_102_ - i_103_, trackers, notb);
            medium.newclouds(i_101_, i, i_103_, i_102_);
            medium.newmountains(i_101_, i, i_103_, i_102_);
            medium.newstars();
            trackers.devidetrackers(i_101_, i - i_101_, i_103_, i_102_ - i_103_);
        } catch (Exception exception) {
            (checkpoints).stage = -3;
            System.out.println(new StringBuilder().append("Error in stage ").append((checkpoints).stage).toString());
            System.out.println(new StringBuilder().append("").append(exception).toString());
            System.out.println(new StringBuilder().append("At line: ").append(string).toString());
        }
        if ((checkpoints).nsp < 2)
            (checkpoints).stage = -3;
        if ((medium).nrw * (medium).ncl >= 16000)
            (checkpoints).stage = -3;
        if ((checkpoints).stage != -3) {
            (checkpoints).top20 = Math.abs((checkpoints).top20);
            if ((checkpoints).stage == 26)
                (medium).lightn = 0;
            else
                (medium).lightn = -1;
            if ((checkpoints).stage == 1 || (checkpoints).stage == 11)
                (medium).nochekflk = false;
            else
                (medium).nochekflk = true;
            for (int i_136_ = 0; i_136_ < (var_xtGraphics).nplayers; i_136_++)
                u[i_136_].reset(checkpoints, (var_xtGraphics).sc[i_136_]);
            var_xtGraphics.resetstat((checkpoints).stage);
            for (int i_137_ = 0; i_137_ < (var_xtGraphics).nplayers; i_137_++) {
                if ((var_xtGraphics).fase == 22)
                    var_xtGraphics.colorCar(contos_100_[(var_xtGraphics).sc[i_137_]], i_137_);
                contos[i_137_] = new ContO(contos_100_[(var_xtGraphics).sc[i_137_]], (var_xtGraphics).xstart[i_137_], 250 - (contos_100_[(var_xtGraphics).sc[i_137_]]).grat, (var_xtGraphics).zstart[i_137_], 0);
                mads[i_137_].reseto((var_xtGraphics).sc[i_137_], contos[i_137_], checkpoints);
            }
            if ((var_xtGraphics).fase == 2 || (var_xtGraphics).fase == -22) {
                (medium).trx = (long) ((i_101_ + i) / 2);
                (medium).trz = (long) ((i_102_ + i_103_) / 2);
                (medium).ptr = 0;
                (medium).ptcnt = -10;
                (medium).hit = 45000;
                (medium).fallen = 0;
                (medium).nrnd = 0;
                (medium).trk = 1;
                (medium).ih = 25;
                (medium).iw = 65;
                (medium).h = 425;
                (medium).w = 735;
                (var_xtGraphics).fase = 1;
                mouses = 0;
            }
            if ((var_xtGraphics).fase == 22) {
                (medium).crs = false;
                (var_xtGraphics).fase = 5;
            }
            if ((checkpoints).stage > 0) {
                int i_138_ = (checkpoints).stage;
                if (i_138_ > 27)
                    i_138_ -= 27;
                else if (i_138_ > 10)
                    i_138_ -= 10;
                (var_xtGraphics).asay = new StringBuilder().append("Stage ").append(i_138_).append(":  ").append((checkpoints).name).append(" ").toString();
            } else
                (var_xtGraphics).asay = new StringBuilder().append("Custom Stage:  ").append((checkpoints).name).append(" ").toString();
            record.reset(contos);
        } else if ((var_xtGraphics).fase == 2)
            (var_xtGraphics).fase = 1;
        System.gc();
    }
    
    public boolean loadstagePreview(int i, String string, ContO[] contos, ContO[] contos_139_, Medium medium, CheckPoints checkpoints) {
        boolean bool = true;
        if (i < 100) {
            (checkpoints).stage = i;
            if ((checkpoints).stage < 0)
                (checkpoints).name = string;
        } else {
            (checkpoints).stage = -2;
            (checkpoints).name = mstgs.getSelectedItem();
        }
        nob = 0;
        (checkpoints).n = 0;
        (checkpoints).nsp = 0;
        (checkpoints).fn = 0;
        (checkpoints).haltall = false;
        (checkpoints).wasted = 0;
        (checkpoints).catchfin = 0;
        (medium).ground = 250;
        view = 0;
        (medium).trx = 0L;
        (medium).trz = 0L;
        String string_140_ = "";
        try {
            DataInputStream datainputstream;
            if ((checkpoints).stage > 0) {
                URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/stages/").append((checkpoints).stage).append(".txt").toString());
                datainputstream = new DataInputStream(url.openStream());
            } else {
                String string_141_ = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/").append((checkpoints).name).append(".radq").toString();
                string_141_ = string_141_.replace(' ', '_');
                URL url = new URL(string_141_);
                int i_142_ = url.openConnection().getContentLength();
                DataInputStream datainputstream_143_ = new DataInputStream(url.openStream());
                byte[] is = new byte[i_142_];
                datainputstream_143_.readFully(is);
                ZipInputStream zipinputstream;
                if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                else {
                    byte[] is_144_ = new byte[i_142_ - 40];
                    for (int i_145_ = 0; i_145_ < i_142_ - 40; i_145_++) {
                        int i_146_ = 20;
                        if (i_145_ >= 500)
                            i_146_ = 40;
                        is_144_[i_145_] = is[i_145_ + i_146_];
                    }
                    zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_144_));
                }
                ZipEntry zipentry = zipinputstream.getNextEntry();
                int i_147_ = Integer.valueOf(zipentry.getName()).intValue();
                byte[] is_148_ = new byte[i_147_];
                int i_149_ = 0;
                int i_150_;
                for (/**/; i_147_ > 0; i_147_ -= i_150_) {
                    i_150_ = zipinputstream.read(is_148_, i_149_, i_147_);
                    i_149_ += i_150_;
                }
                zipinputstream.close();
                datainputstream_143_.close();
                datainputstream = new DataInputStream(new ByteArrayInputStream(is_148_));
            }
            String string_151_;
            while ((string_151_ = datainputstream.readLine()) != null) {
                string_140_ = new StringBuilder().append("").append(string_151_.trim()).toString();
                if (string_140_.startsWith("set")) {
                    int i_152_ = getint("set", string_140_, 0);
                    i_152_ += 46;
                    contos[nob] = new ContO(contos_139_[i_152_], getint("set", string_140_, 1), (medium).ground - (contos_139_[i_152_]).grat, getint("set", string_140_, 2), getint("set", string_140_, 3));
                    if (string_140_.indexOf(")p") != -1) {
                        (checkpoints).x[(checkpoints).n] = getint("chk", string_140_, 1);
                        (checkpoints).z[(checkpoints).n] = getint("chk", string_140_, 2);
                        (checkpoints).y[(checkpoints).n] = 0;
                        (checkpoints).typ[(checkpoints).n] = 0;
                        if (string_140_.indexOf(")pt") != -1)
                            (checkpoints).typ[(checkpoints).n] = -1;
                        if (string_140_.indexOf(")pr") != -1)
                            (checkpoints).typ[(checkpoints).n] = -2;
                        if (string_140_.indexOf(")po") != -1)
                            (checkpoints).typ[(checkpoints).n] = -3;
                        if (string_140_.indexOf(")ph") != -1)
                            (checkpoints).typ[(checkpoints).n] = -4;
                        if (string_140_.indexOf("out") != -1)
                            System.out.println(new StringBuilder().append("out: ").append((checkpoints).n).toString());
                        (checkpoints).n++;
                    }
                    nob++;
                }
                if (string_140_.startsWith("chk")) {
                    int i_153_ = getint("chk", string_140_, 0);
                    i_153_ += 46;
                    int i_154_ = (medium).ground - (contos_139_[i_153_]).grat;
                    if (i_153_ == 110)
                        i_154_ = getint("chk", string_140_, 4);
                    contos[nob] = new ContO(contos_139_[i_153_], getint("chk", string_140_, 1), i_154_, getint("chk", string_140_, 2), getint("chk", string_140_, 3));
                    (checkpoints).x[(checkpoints).n] = getint("chk", string_140_, 1);
                    (checkpoints).z[(checkpoints).n] = getint("chk", string_140_, 2);
                    (checkpoints).y[(checkpoints).n] = i_154_;
                    if (getint("chk", string_140_, 3) == 0)
                        (checkpoints).typ[(checkpoints).n] = 1;
                    else
                        (checkpoints).typ[(checkpoints).n] = 2;
                    (checkpoints).pcs = (checkpoints).n;
                    (checkpoints).n++;
                    (contos[nob]).checkpoint = (checkpoints).nsp + 1;
                    (checkpoints).nsp++;
                    nob++;
                }
                if (string_140_.startsWith("fix")) {
                    int i_155_ = getint("fix", string_140_, 0);
                    i_155_ += 46;
                    contos[nob] = new ContO(contos_139_[i_155_], getint("fix", string_140_, 1), getint("fix", string_140_, 3), getint("fix", string_140_, 2), getint("fix", string_140_, 4));
                    (checkpoints).fx[(checkpoints).fn] = getint("fix", string_140_, 1);
                    (checkpoints).fz[(checkpoints).fn] = getint("fix", string_140_, 2);
                    (checkpoints).fy[(checkpoints).fn] = getint("fix", string_140_, 3);
                    (contos[nob]).elec = true;
                    if (getint("fix", string_140_, 4) != 0) {
                        (checkpoints).roted[(checkpoints).fn] = true;
                        (contos[nob]).roted = true;
                    } else
                        (checkpoints).roted[(checkpoints).fn] = false;
                    if (string_140_.indexOf(")s") != -1)
                        (checkpoints).special[(checkpoints).fn] = true;
                    else
                        (checkpoints).special[(checkpoints).fn] = false;
                    (checkpoints).fn++;
                    nob++;
                }
                if (string_140_.startsWith("nlaps")) {
                    (checkpoints).nlaps = getint("nlaps", string_140_, 0);
                    if ((checkpoints).nlaps < 1)
                        (checkpoints).nlaps = 1;
                    if ((checkpoints).nlaps > 15)
                        (checkpoints).nlaps = 15;
                }
                if ((checkpoints).stage > 0 && string_140_.startsWith("name"))
                    (checkpoints).name = getstring("name", string_140_, 0).replace('|', ',');
                if (string_140_.startsWith("stagemaker"))
                    (checkpoints).maker = getstring("stagemaker", string_140_, 0);
                if (string_140_.startsWith("publish"))
                    (checkpoints).pubt = getint("publish", string_140_, 0);
                if (string_140_.startsWith("maxr")) {
                    int i_156_ = getint("maxr", string_140_, 1);
                    (medium).trx += (long) i_156_;
                }
                if (string_140_.startsWith("maxl")) {
                    int i_157_ = getint("maxl", string_140_, 1);
                    (medium).trx += (long) i_157_;
                }
                if (string_140_.startsWith("maxt")) {
                    int i_158_ = getint("maxt", string_140_, 1);
                    (medium).trz += (long) i_158_;
                }
                if (string_140_.startsWith("maxb")) {
                    int i_159_ = getint("maxb", string_140_, 1);
                    (medium).trz += (long) i_159_;
                }
            }
            datainputstream.close();
        } catch (Exception exception) {
            bool = false;
            System.out.println(new StringBuilder().append("Error in stage ").append((checkpoints).stage).toString());
            System.out.println(new StringBuilder().append("").append(exception).toString());
            System.out.println(new StringBuilder().append("At line: ").append(string_140_).toString());
        }
        if ((checkpoints).nsp < 2)
            bool = false;
        (medium).trx = (medium).trx / 2L;
        (medium).trz = (medium).trz / 2L;
        System.gc();
        return bool;
    }
    
    public void loadbase(ContO[] contos, Medium medium, Trackers trackers, xtGraphics var_xtGraphics, boolean bool) {
        String[] strings = { "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster" };
        String[] strings_160_ = { "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "tside", "launchpad", "thenet", "speedramp", "offhill", "slider", "uphill", "roll1", "roll2", "roll3", "roll4", "roll5", "roll6", "opile1", "opile2", "aircheckpoint", "tree1", "tree2", "tree3", "tree4", "tree5", "tree6", "tree7", "tree8", "cac1", "cac2", "cac3" };
        int i = 0;
        (var_xtGraphics).dnload += 6;
        try {
            ZipInputStream zipinputstream;
            if (!bool) {
                File file = new File("data/models.zip");
                zipinputstream = new ZipInputStream(new FileInputStream(file));
            } else {
                URL url = new URL("http://multiplayer.needformadness.com/data/models.zip");
                zipinputstream = new ZipInputStream(url.openStream());
            }
            ZipEntry zipentry = zipinputstream.getNextEntry();
            for (/**/; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i_162_ = 0;
                for (int i_163_ = 0; i_163_ < 16; i_163_++) {
                    if (zipentry.getName().startsWith(strings[i_163_]))
                        i_162_ = i_163_;
                }
                for (int i_164_ = 0; i_164_ < 66; i_164_++) {
                    if (zipentry.getName().startsWith(strings_160_[i_164_]))
                        i_162_ = i_164_ + 56;
                }
                int i_165_ = (int) zipentry.getSize();
                i += i_165_;
                byte[] is = new byte[i_165_];
                int i_166_ = 0;
                int i_167_;
                for (/**/; i_165_ > 0; i_165_ -= i_167_) {
                    i_167_ = zipinputstream.read(is, i_166_, i_165_);
                    i_166_ += i_167_;
                }
                contos[i_162_] = new ContO(is, medium, trackers);
                (var_xtGraphics).dnload++;
            }
            zipinputstream.close();
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Error Reading Models: ").append(exception).toString());
        }
        System.gc();
        if (mload != -1 && i != 598390)
            mload = 2;
    }
    
    public int getint(String string, String string_168_, int i) {
        int i_169_ = 0;
        String string_170_ = "";
        for (int i_171_ = string.length() + 1; i_171_ < string_168_.length(); i_171_++) {
            String string_172_ = new StringBuilder().append("").append(string_168_.charAt(i_171_)).toString();
            if (string_172_.equals(",") || string_172_.equals(")")) {
                i_169_++;
                i_171_++;
            }
            if (i_169_ == i)
                string_170_ = new StringBuilder().append(string_170_).append(string_168_.charAt(i_171_)).toString();
        }
        return Integer.valueOf(string_170_).intValue();
    }
    
    public String getstring(String string, String string_173_, int i) {
        int i_174_ = 0;
        String string_175_ = "";
        for (int i_176_ = string.length() + 1; i_176_ < string_173_.length(); i_176_++) {
            String string_177_ = new StringBuilder().append("").append(string_173_.charAt(i_176_)).toString();
            if (string_177_.equals(",") || string_177_.equals(")")) {
                i_174_++;
                i_176_++;
            }
            if (i_174_ == i)
                string_175_ = new StringBuilder().append(string_175_).append(string_173_.charAt(i_176_)).toString();
        }
        return string_175_;
    }
    
    public void start() {
        if (gamer == null)
            gamer = new Thread(this);
        gamer.start();
    }
    
    public void stop() {
        if (exwist && gamer != null) {
            System.gc();
            gamer.stop();
            gamer = null;
        }
        exwist = true;
    }
    
    public void setcarcookie(int i, float[] fs, int i_178_, int[] is, boolean bool) {
        try {
            File file = new File("data/");
            String string = "";
            if (file.getAbsolutePath().toLowerCase().endsWith("desktop\\data")) {
                file = new File("../data/");
                string = "../";
            }
            if (!file.exists())
                file.mkdirs();
            file = new File(new StringBuilder().append("").append(string).append("data/user.data").toString());
            String[] strings = { "", "", "", "" };
            if (file.exists()) {
                BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string_179_;
                for (int i_180_ = 0; (string_179_ = bufferedreader.readLine()) != null && i_180_ < 4; i_180_++)
                    strings[i_180_] = string_179_;
                bufferedreader.close();
            }
            if (i_178_ == 0)
                strings[1] = new StringBuilder().append("lastcar(").append(i).append(",").append((int) (fs[0] * 100.0F)).append(",").append((int) (fs[1] * 100.0F)).append(",").append((int) (fs[2] * 100.0F)).append(",").append((int) (fs[3] * 100.0F)).append(",").append((int) (fs[4] * 100.0F)).append(",").append((int) (fs[5] * 100.0F)).append(")").toString();
            if (i_178_ == 1)
                strings[2] = new StringBuilder().append("NFM1(").append(i).append(",").append(is[0]).append(")").toString();
            if (i_178_ == 2)
                strings[3] = new StringBuilder().append("NFM2(").append(i).append(",").append(is[1]).append(")").toString();
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            bufferedwriter.write(strings[0]);
            bufferedwriter.newLine();
            bufferedwriter.write(strings[1]);
            bufferedwriter.newLine();
            bufferedwriter.write(strings[2]);
            bufferedwriter.newLine();
            bufferedwriter.write(strings[3]);
            bufferedwriter.newLine();
            bufferedwriter.close();
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void setloggedcookie() {
        try {
            File file = new File("data/");
            String string = "";
            if (file.getAbsolutePath().toLowerCase().endsWith("desktop\\data")) {
                file = new File("../data/");
                string = "../";
            }
            if (!file.exists())
                file.mkdirs();
            file = new File(new StringBuilder().append("").append(string).append("data/user.data").toString());
            String[] strings = { "", "", "", "" };
            if (file.exists()) {
                BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string_182_;
                for (int i = 0; (string_182_ = bufferedreader.readLine()) != null && i < 4; i++)
                    strings[i] = string_182_;
                bufferedreader.close();
            }
            if (keplo.getState())
                strings[0] = new StringBuilder().append("lastuser(").append(tnick.getText()).append(",").append(tpass.getText()).append(")").toString();
            else
                strings[0] = new StringBuilder().append("lastuser(").append(tnick.getText()).append(")").toString();
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            bufferedwriter.write(strings[0]);
            bufferedwriter.newLine();
            bufferedwriter.write(strings[1]);
            bufferedwriter.newLine();
            bufferedwriter.write(strings[2]);
            bufferedwriter.newLine();
            bufferedwriter.write(strings[3]);
            bufferedwriter.newLine();
            bufferedwriter.close();
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void readcookies(xtGraphics var_xtGraphics, ContO[] contos) {
        (var_xtGraphics).nickname = "";
        try {
            File file = new File("data/");
            String string = "";
            if (file.getAbsolutePath().toLowerCase().endsWith("desktop\\data"))
                string = "../";
            file = new File(new StringBuilder().append("").append(string).append("data/user.data").toString());
            String[] strings = { "", "", "", "" };
            if (file.exists()) {
                BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string_184_;
                for (int i = 0; (string_184_ = bufferedreader.readLine()) != null && i < 4; i++)
                    strings[i] = string_184_;
                bufferedreader.close();
            }
            if (strings[0].startsWith("lastuser")) {
                (var_xtGraphics).nickname = getstring("lastuser", strings[0], 0);
                String string_186_ = "";
                try {
                    string_186_ = getstring("lastuser", strings[0], 1);
                } catch (Exception exception) {
                    string_186_ = "";
                }
                if (!string_186_.equals("")) {
                    tnick.setText((var_xtGraphics).nickname);
                    tpass.setText(string_186_);
                    (var_xtGraphics).autolog = true;
                }
            }
            if (strings[2].startsWith("NFM1")) {
                int i = getint("NFM1", strings[2], 0);
                if (i >= 0 && i < 16) {
                    (var_xtGraphics).scm[0] = i;
                    (var_xtGraphics).firstime = false;
                }
                i = getint("NFM1", strings[2], 1);
                if (i >= 1 && i <= 11)
                    (var_xtGraphics).unlocked[0] = i;
            }
            if (strings[3].startsWith("NFM2")) {
                int i = getint("NFM2", strings[3], 0);
                if (i >= 0 && i < 16) {
                    (var_xtGraphics).scm[1] = i;
                    (var_xtGraphics).firstime = false;
                }
                i = getint("NFM2", strings[3], 1);
                if (i >= 1 && i <= 17)
                    (var_xtGraphics).unlocked[1] = i;
            }
            if (strings[1].startsWith("lastcar")) {
                int i = getint("lastcar", strings[1], 0);
                if (i >= 0 && i < 36) {
                    (var_xtGraphics).osc = i;
                    (var_xtGraphics).firstime = false;
                }
                int i_187_ = 0;
                for (int i_188_ = 0; i_188_ < 6; i_188_++) {
                    i = getint("lastcar", strings[1], i_188_ + 1);
                    if (i >= 0 && i <= 100) {
                        (var_xtGraphics).arnp[i_188_] = (float) i / 100.0F;
                        i_187_++;
                    }
                }
                if (i_187_ == 6 && (var_xtGraphics).osc >= 0 && (var_xtGraphics).osc <= 15) {
                    Color color = Color.getHSBColor((var_xtGraphics).arnp[0], (var_xtGraphics).arnp[1], 1.0F - (var_xtGraphics).arnp[2]);
                    Color color_189_ = Color.getHSBColor((var_xtGraphics).arnp[3], (var_xtGraphics).arnp[4], 1.0F - (var_xtGraphics).arnp[5]);
                    for (int i_190_ = 0; i_190_ < (contos[(var_xtGraphics).osc]).npl; i_190_++) {
                        if (((contos[(var_xtGraphics).osc]).p[i_190_]).colnum == 1) {
                            ((contos[(var_xtGraphics).osc]).p[i_190_]).c[0] = color.getRed();
                            ((contos[(var_xtGraphics).osc]).p[i_190_]).c[1] = color.getGreen();
                            ((contos[(var_xtGraphics).osc]).p[i_190_]).c[2] = color.getBlue();
                        }
                    }
                    for (int i_191_ = 0; i_191_ < (contos[(var_xtGraphics).osc]).npl; i_191_++) {
                        if (((contos[(var_xtGraphics).osc]).p[i_191_]).colnum == 2) {
                            ((contos[(var_xtGraphics).osc]).p[i_191_]).c[0] = color_189_.getRed();
                            ((contos[(var_xtGraphics).osc]).p[i_191_]).c[1] = color_189_.getGreen();
                            ((contos[(var_xtGraphics).osc]).p[i_191_]).c[2] = color_189_.getBlue();
                        }
                    }
                }
            }
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void regprom() {
        /* empty */
    }
    
    public boolean mouseUp(Event event, int i, int i_192_) {
        if (!exwist) {
            if (mouses == 11) {
                xm = (int) ((float) (i - apx) / apmult);
                ym = (int) ((float) (i_192_ - apy) / apmult);
                mouses = -1;
            }
            moused = false;
        }
        if (i > getWidth() / 2 + 55 && i < getWidth() / 2 + 117 && i_192_ > 21 && i_192_ < 38 && !onbar) {
            if (smooth == 1)
                smooth = 0;
            else
                smooth = 1;
            showsize = 60;
        }
        onbar = false;
        if (oncarm)
            Madness.carmaker();
        if (onstgm)
            Madness.stagemaker();
        return false;
    }
    
    public boolean mouseDown(Event event, int i, int i_193_) {
        requestFocus();
        if (!exwist) {
            if (mouses == 0) {
                xm = (int) ((float) (i - apx) / apmult);
                ym = (int) ((float) (i_193_ - apy) / apmult);
                mouses = 1;
            }
            moused = true;
        }
        sizescreen(i, i_193_);
        return false;
    }
    
    public boolean mouseMove(Event event, int i, int i_194_) {
        if (!exwist && !lostfcs) {
            xm = (int) ((float) (i - apx) / apmult);
            ym = (int) ((float) (i_194_ - apy) / apmult);
        }
        if (showsize < 20)
            showsize = 20;
        if (i > 50 && i < 192 && i_194_ > 14 && i_194_ < 37) {
            if (!oncarm) {
                oncarm = true;
                setCursor(new Cursor(12));
            }
        } else if (oncarm) {
            oncarm = false;
            setCursor(new Cursor(0));
        }
        if (i > getWidth() - 208 && i < getWidth() - 50 && i_194_ > 14 && i_194_ < 37) {
            if (!onstgm) {
                onstgm = true;
                setCursor(new Cursor(12));
            }
        } else if (onstgm) {
            onstgm = false;
            setCursor(new Cursor(0));
        }
        return false;
    }
    
    public boolean mouseDrag(Event event, int i, int i_195_) {
        if (!exwist && !lostfcs) {
            xm = (int) ((float) (i - apx) / apmult);
            ym = (int) ((float) (i_195_ - apy) / apmult);
        }
        sizescreen(i, i_195_);
        return false;
    }
    
    public boolean lostFocus(Event event, Object object) {
        if (!exwist && !lostfcs) {
            lostfcs = true;
            fcscnt = 10;
            if (u[0] != null) {
                if ((u[0]).multion == 0)
                    u[0].falseo(1);
                else if (!(u[0]).chatup)
                    requestFocus();
                setCursor(new Cursor(0));
            }
        }
        return false;
    }
    
    public boolean gotFocus(Event event, Object object) {
        if (!exwist && lostfcs)
            lostfcs = false;
        return false;
    }
    
    public void mouseW(int i) {
        if (!exwist)
            mousew += i * 4;
    }
    
    public void sizescreen(int i, int i_196_) {
        if (i > getWidth() / 2 - 120 && i < getWidth() / 2 + 42 && i_196_ > 21 && i_196_ < 39 || onbar) {
            reqmult = (float) (i - (getWidth() / 2 - 112)) / 141.0F;
            if ((double) reqmult < 0.1)
                reqmult = 0.0F;
            if (reqmult > 1.0F)
                reqmult = 1.0F;
            onbar = true;
            showsize = 100;
        }
    }
    
    public void catchlink() {
        if (!lostfcs) {
            if (xm > 65 && xm < 735 && ym > 135 && ym < 194 || xm > 275 && xm < 525 && ym > 265 && ym < 284) {
                setCursor(new Cursor(12));
                if (mouses == 2)
                    openurl("http://www.radicalplay.com/");
            } else
                setCursor(new Cursor(0));
        }
    }
    
    public void musiclink() {
        openurl("http://multiplayer.needformadness.com/music.html");
    }
    
    public void reglink() {
        openurl("http://multiplayer.needformadness.com/register.html?ref=game");
    }
    
    public void madlink() {
        openurl("http://www.needformadness.com/");
    }
    
    public void editlink(String string) {
        openurl(new StringBuilder().append("http://multiplayer.needformadness.com/edit.pl#").append(string).append("").toString());
    }
    
    public void multlink() {
        openurl("http://multiplayer.needformadness.com/");
    }
    
    public void regnew() {
        openurl("http://multiplayer.needformadness.com/registernew.pl");
    }
    
    public void openurl(String string) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(string));
            } catch (Exception exception) {
                /* empty */
            }
        } else {
            try {
                Runtime.getRuntime().exec(new StringBuilder().append("").append(Madness.urlopen()).append(" ").append(string).append("").toString());
            } catch (Exception exception) {
                /* empty */
            }
        }
    }
    
    public boolean keyDown(Event event, int i) {
        if (!exwist) {
            if ((u[0]).multion < 2) {
                if (i == 1004)
                    (u[0]).up = true;
                if (i == 1005)
                    (u[0]).down = true;
                if (i == 1007)
                    (u[0]).right = true;
                if (i == 1006)
                    (u[0]).left = true;
                if (i == 32)
                    (u[0]).handb = true;
            }
            if (i == 10)
                (u[0]).enter = true;
            if (i == 27) {
                (u[0]).exit = true;
                if ((u[0]).chatup)
                    (u[0]).chatup = false;
            }
            if ((i == 67 || i == 99) && (u[0]).multion != 0) {
                (u[0]).chatup = true;
                view = 0;
            }
            if (i == 96) {
                if (elay)
                    elay = false;
                else
                    elay = true;
            }
            if (!(u[0]).chatup) {
                if (i == 120 || i == 88)
                    (u[0]).lookback = -1;
                if (i == 122 || i == 90)
                    (u[0]).lookback = 1;
                if (i == 77 || i == 109) {
                    if ((u[0]).mutem)
                        (u[0]).mutem = false;
                    else
                        (u[0]).mutem = true;
                }
                if (i == 78 || i == 110) {
                    if ((u[0]).mutes)
                        (u[0]).mutes = false;
                    else
                        (u[0]).mutes = true;
                }
                if (i == 97 || i == 65) {
                    if ((u[0]).arrace)
                        (u[0]).arrace = false;
                    else
                        (u[0]).arrace = true;
                }
                if (i == 118 || i == 86) {
                    view++;
                    if (view == 3)
                        view = 0;
                }
            }
        }
        return false;
    }
    
    public boolean keyUp(Event event, int i) {
        if (!exwist) {
            if ((u[0]).multion < 2) {
                if (i == 1004)
                    (u[0]).up = false;
                if (i == 1005)
                    (u[0]).down = false;
                if (i == 1007)
                    (u[0]).right = false;
                if (i == 1006)
                    (u[0]).left = false;
                if (i == 32)
                    (u[0]).handb = false;
            }
            if (i == 27)
                (u[0]).exit = false;
            if (i == 120 || i == 88 || i == 122 || i == 90)
                (u[0]).lookback = 0;
        }
        return false;
    }
}
