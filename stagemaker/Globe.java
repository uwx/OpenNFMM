package stagemaker;

/* Globe - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
public class Globe implements Runnable
{
    MediaTracker mt;
    Graphics2D rd;
    xtGraphics xt;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker gs;
    Login lg;
    CarDefine cd;
    Thread connector;
    boolean domon = false;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    int fase = 0;
    int open = 0;
    boolean upo = false;
    int tab = 0;
    boolean onp = false;
    int ptab = 0;
    int spos = 0;
    int lspos = 0;
    int mscro = 825;
    int spos2 = 0;
    int lspos2 = 0;
    int mscro2 = 825;
    int spos3 = 0;
    int lspos3 = 0;
    int mscro3 = 825;
    int spos4 = 208;
    int lspos4 = 0;
    int mscro4 = 825;
    int overit = 0;
    int flk = 0;
    int flko = 0;
    boolean flg = false;
    int curs = 0;
    int waitlink = 0;
    int addstage = 0;
    int npo = -1;
    String[] pname = new String[900];
    int[] proom = new int[900];
    int[] pserver = new int[900];
    int[][] roomf = new int[3][5];
    String[] cnames = new String[21];
    String[] sentn = new String[21];
    String[] ctime = new String[21];
    long[] nctime = new long[21];
    int updatec = -1;
    String proname = "";
    boolean loadedp = false;
    int edit = 0;
    int upload = 0;
    int perc = 0;
    int playt = 0;
    int uploadt = 0;
    String filename = "";
    String msg = "";
    String trackname = "";
    boolean refresh = false;
    boolean logol = false;
    boolean clanlogol = false;
    boolean avatarl = false;
    int sentchange = 0;
    boolean badlang = false;
    String[] aboutxt = new String[3];
    int nab = 0;
    Image clanlogo;
    Image avatar;
    int racing = 50;
    int wasting = 150;
    String themesong = "";
    String sentance = "";
    int trackvol = 0;
    int comesoon = 0;
    int nlg = 0;
    String[] logos = new String[200];
    boolean[] logon = new boolean[200];
    Image[] logoi = new Image[200];
    int loadmsgs = -1;
    String hasmsgs = "";
    String lastsub = "";
    int nm = 0;
    String[] mname = new String[200];
    String[] mconvo = new String[200];
    String[] msub = new String[200];
    int[] mtyp = new int[200];
    String[] mtime = new String[200];
    long[] mctime = new long[200];
    int openc = 0;
    int opy = 0;
    int addopy = 0;
    int oph = 0;
    int itemsel = 0;
    int loaditem = 0;
    String[] mline = new String[1000];
    int[] mlinetyp = new int[1000];
    long[] mctimes = new long[1000];
    String[] mtimes = new String[1000];
    int nml = 0;
    int readmsg = 0;
    String opname = "";
    String blockname = "";
    String unblockname = "";
    int sendmsg = 0;
    int underc = 0;
    float bgf = 0.0F;
    boolean bgup = false;
    int[] bgx = { 0, 670, 1340 };
    int prereq = 0;
    long ntime = 0L;
    int fun = 1;
    
    public Globe(Graphics2D graphics2d, xtGraphics var_xtGraphics, Login login, CarDefine cardefine, GameSparker gamesparker) {
        rd = graphics2d;
        xt = var_xtGraphics;
        gs = gamesparker;
        lg = login;
        cd = cardefine;
        for (int i = 0; i < 21; i++) {
            ctime[i] = "";
            cnames[i] = "";
            sentn[i] = "";
            nctime[i] = 0L;
        }
        for (int i = 0; i < 900; i++)
            pname[i] = "";
        for (int i = 0; i < 200; i++) {
            logos[i] = "";
            logon[i] = false;
        }
        mt = new MediaTracker(gs);
        (gs).sendtyp.setBackground(colorb2k(210, 210, 210));
        (gs).sendtyp.setForeground(new Color(0, 0, 0));
        (gs).senditem.setBackground(colorb2k(230, 230, 230));
        (gs).senditem.setForeground(new Color(0, 0, 0));
        (gs).mmsg.setBackground(colorb2k(240, 240, 240));
        (gs).mmsg.setForeground(new Color(0, 0, 0));
    }
    
    public void dome(int i, int i_0_, int i_1_, boolean bool, Control control) {
        boolean bool_2_ = false;
        boolean bool_3_ = false;
        boolean bool_4_ = false;
        if (open == 0) {
            boolean bool_5_ = false;
            if (i_1_ > 425 && i_1_ < 450 && (float) i_0_ < 500.0F + (float) (i_1_ - 425) * 9.2F && (float) i_0_ > 300.0F - (float) (i_1_ - 425) * 9.2F)
                bool_5_ = true;
            int[] is = { 0, 9, 232, 250, 550, 568, 791, 800 };
            int[] is_6_ = { 452, 443, 443, 425, 425, 443, 443, 452 };
            if (bool_5_)
                rd.setColor(color2k(255, 255, 255));
            else
                rd.setColor(new Color(207, 177, 110));
            rd.fillPolygon(is, is_6_, 8);
            rd.setColor(new Color(((xt).brl * 2 + 207) / 2, ((xt).brl + 177) / 2, 60));
            rd.drawPolygon(is, is_6_, 8);
            rd.drawImage((xt).dome, 311, 430, null);
            if (bool_5_ && bool && i < 2) {
                open = 2;
                upo = true;
            }
        }
        if (open >= 2 && open < 452) {
            int[] is = { 0, 0, 9, 232, 250, 550, 568, 791, 800, 800 };
            int[] is_7_ = { 902 - open, 452 - open, 443 - open, 443 - open, 425 - open, 425 - open, 443 - open, 443 - open, 452 - open, 902 - open };
            float f = ((float) open - 2.0F) / 450.0F;
            int i_8_ = (int) (255.0F * (1.0F - f) + 216.0F * f);
            if (i_8_ > 255)
                i_8_ = 255;
            if (i_8_ < 0)
                i_8_ = 0;
            int i_9_ = (int) (243.0F * (1.0F - f) + 179.0F * f);
            if (i_9_ > 255)
                i_9_ = 255;
            if (i_9_ < 0)
                i_9_ = 0;
            int i_10_ = (int) (179.0F * (1.0F - f) + 100.0F * f);
            if (i_10_ > 255)
                i_10_ = 255;
            if (i_10_ < 0)
                i_10_ = 0;
            rd.setColor(new Color(i_8_, i_9_, i_10_));
            rd.fillPolygon(is, is_7_, 10);
            rd.drawImage((xt).dome, 311, 430 - open, null);
            if (upo)
                open += 45;
            else
                open -= 45;
            gs.hidefields();
            if (open == 452) {
                gs.setCursor(new Cursor(0));
                npo = -1;
                updatec = -1;
                domon = true;
                connector = new Thread(this);
                connector.start();
            }
        }
        if (open == 452) {
            if ((xt).warning == 0 || (xt).warning == 210) {
                int i_11_ = 0;
                int i_12_ = (int) (255.0F * bgf + 191.0F * (1.0F - bgf));
                int i_13_ = (int) (176.0F * bgf + 184.0F * (1.0F - bgf));
                int i_14_ = (int) (67.0F * bgf + 124.0F * (1.0F - bgf));
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
                rd.setColor(new Color(i_12_, i_13_, i_14_));
                rd.fillRect(0, 0, 800, 450);
                rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
                rd.drawImage((xt).bgmain, bgx[0], 0, null);
                rd.drawImage((xt).bgmain, bgx[1], 0, null);
                rd.drawImage((xt).bgmain, bgx[2], 0, null);
                rd.drawImage((xt).bgmain, bgx[0], 400, null);
                rd.drawImage((xt).bgmain, bgx[1], 400, null);
                rd.drawImage((xt).bgmain, bgx[2], 400, null);
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                for (int i_15_ = 0; i_15_ < 3; i_15_++) {
                    bgx[i_15_] -= 5;
                    if (bgx[i_15_] <= -670)
                        bgx[i_15_] = 1340;
                }
                if (drawbutton((xt).exit, 755, 17, i_0_, i_1_, bool) || i >= 2) {
                    open = 450;
                    upo = false;
                    domon = false;
                    onexit();
                }
                int i_16_ = 0;
                if (domon) {
                    if (tab == 0) {
                        rd.setColor(color2k(230, 230, 230));
                        rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                        if (updatec != -1) {
                            String[] strings = new String[42];
                            String[] strings_18_ = new String[42];
                            String[] strings_19_ = new String[42];
                            boolean[] bools = new boolean[42];
                            for (int i_20_ = 0; i_20_ < 42; i_20_++) {
                                strings[i_20_] = "";
                                strings_18_[i_20_] = "";
                                strings_19_[i_20_] = "";
                                bools[i_20_] = false;
                            }
                            int i_21_ = 0;
                            rd.setFont(new Font("Tahoma", 0, 11));
                            ftm = rd.getFontMetrics();
                            for (int i_22_ = 0; i_22_ < 21; i_22_++) {
                                strings[i_21_] = "";
                                strings_18_[i_21_] = cnames[i_22_];
                                strings_19_[i_21_] = ctime[i_22_];
                                int i_23_ = 0;
                                int i_24_ = 0;
                                int i_25_ = 0;
                                int i_26_ = 0;
                                int i_27_ = 0;
                                for (/**/; i_23_ < sentn[i_22_].length(); i_23_++) {
                                    String string = new StringBuilder().append("").append(sentn[i_22_].charAt(i_23_)).toString();
                                    if (string.equals(" ")) {
                                        i_24_ = i_25_;
                                        i_26_ = i_23_;
                                        i_27_++;
                                    } else
                                        i_27_ = 0;
                                    if (i_27_ <= 1) {
                                        StringBuilder stringbuilder = new StringBuilder();
                                        String[] strings_28_ = strings;
                                        int i_29_ = i_21_;
                                        strings_28_[i_29_] = stringbuilder.append(strings_28_[i_29_]).append(string).toString();
                                        i_25_++;
                                        if (ftm.stringWidth(strings[i_21_]) > 469) {
                                            if (i_24_ != 0) {
                                                strings[i_21_] = strings[i_21_].substring(0, i_24_);
                                                if (i_21_ == 41) {
                                                    for (int i_30_ = 0; i_30_ < 41; i_30_++) {
                                                        strings[i_30_] = strings[i_30_ + 1];
                                                        strings_18_[i_30_] = strings_18_[i_30_ + 1];
                                                        strings_19_[i_30_] = strings_19_[i_30_ + 1];
                                                        bools[i_30_] = bools[i_30_ + 1];
                                                    }
                                                    strings[i_21_] = "";
                                                    bools[i_21_] = true;
                                                } else {
                                                    i_21_++;
                                                    strings_18_[i_21_] = cnames[i_22_];
                                                    strings_19_[i_21_] = ctime[i_22_];
                                                }
                                                i_23_ = i_26_;
                                                i_25_ = 0;
                                                i_24_ = 0;
                                            } else {
                                                strings[i_21_] = "";
                                                i_25_ = 0;
                                            }
                                        }
                                    }
                                }
                                if (i_21_ == 41 && i_22_ != 20) {
                                    for (int i_31_ = 0; i_31_ < 41; i_31_++) {
                                        strings[i_31_] = strings[i_31_ + 1];
                                        strings_18_[i_31_] = strings_18_[i_31_ + 1];
                                        strings_19_[i_31_] = strings_19_[i_31_ + 1];
                                        bools[i_31_] = bools[i_31_ + 1];
                                    }
                                } else
                                    i_21_++;
                            }
                            String string = "";
                            int i_32_ = i_21_;
                            for (int i_33_ = 0; i_33_ < i_21_; i_33_++) {
                                if (!string.equals(strings_18_[i_33_])) {
                                    if (i_33_ != 0)
                                        i_32_++;
                                    string = strings_18_[i_33_];
                                }
                            }
                            i_16_ = (int) (((float) i_32_ - 21.5F) * 15.0F);
                            if (i_16_ < 0)
                                i_16_ = 0;
                            int i_34_ = (int) ((float) spos2 / 275.0F * (float) i_16_);
                            i_32_ = 0;
                            string = "";
                            for (int i_35_ = 0; i_35_ <= i_21_; i_35_++) {
                                if (i_35_ != i_21_) {
                                    if (!string.equals(strings_18_[i_35_])) {
                                        if (i_35_ != 0) {
                                            if (i_32_ * 15 - i_34_ > -20 && i_32_ * 15 - i_34_ < 345) {
                                                rd.setFont(new Font("Tahoma", 0, 11));
                                                rd.setColor(color2k(125, 125, 125));
                                                rd.drawString(strings_19_[i_35_ - 1], 297, 82 + i_32_ * 15 - i_34_);
                                            }
                                            i_32_++;
                                        }
                                        if (i_32_ * 15 - i_34_ > -20 && i_32_ * 15 - i_34_ < 345) {
                                            rd.setFont(new Font("Tahoma", 1, 11));
                                            ftm = rd.getFontMetrics();
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.drawString(new StringBuilder().append(strings_18_[i_35_]).append(":").toString(), 292 - ftm.stringWidth(new StringBuilder().append(strings_18_[i_35_]).append(":").toString()), 82 + i_32_ * 15 - i_34_);
                                        }
                                        string = strings_18_[i_35_];
                                    }
                                    if (bools[i_35_] && i_35_ == 0 && strings[i_35_].indexOf(" ") != -1)
                                        strings[i_35_] = new StringBuilder().append("...").append(strings[i_35_].substring(strings[i_35_].indexOf(" "), strings[i_35_].length())).append("").toString();
                                    if (i_32_ * 15 - i_34_ > -20 && i_32_ * 15 - i_34_ < 345) {
                                        rd.setFont(new Font("Tahoma", 0, 11));
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.drawString(strings[i_35_], 297, 82 + i_32_ * 15 - i_34_);
                                    }
                                    i_32_++;
                                } else if (i_32_ * 15 - i_34_ > -20 && i_32_ * 15 - i_34_ < 345) {
                                    rd.setFont(new Font("Tahoma", 0, 11));
                                    rd.setColor(color2k(125, 125, 125));
                                    rd.drawString(strings_19_[i_35_ - 1], 297, 82 + i_32_ * 15 - i_34_);
                                }
                            }
                        } else {
                            i_16_ = 0;
                            spos2 = 275;
                            rd.setColor(new Color(0, 0, 0));
                            rd.setFont(new Font("Tahoma", 1, 11));
                            ftm = rd.getFontMetrics();
                            rd.drawString("Loading chat...", 498 - ftm.stringWidth("Loading chat...") / 2, 220);
                        }
                        rd.setColor(color2k(205, 205, 205));
                        rd.fillRect(207, 46, 582, 25);
                        rd.setFont(new Font("Arial", 1, 12));
                        rd.setColor(color2k(40, 40, 40));
                        rd.drawString("Global Chat", 213, 62);
                        rd.setColor(color2k(150, 150, 150));
                        rd.drawLine(207, 68, 770, 68);
                        rd.setColor(color2k(205, 205, 205));
                        rd.fillRect(207, 411, 582, 28);
                        rd.setColor(color2k(150, 150, 150));
                        rd.drawLine(207, 413, 770, 413);
                        rd.setColor(color2k(205, 205, 205));
                        rd.fillRect(772, 88, 17, 306);
                        rd.setColor(color2k(205, 205, 205));
                        rd.fillRect(203, 46, 4, 393);
                        bool_2_ = true;
                        if ((stringbutton("Send Message", 731, 430, 3, i_0_, i_1_, bool) || (control).enter) && !(gs).cmsg.getText().equals("Type here...") && !(gs).cmsg.getText().equals("") && (xt).acexp != -3) {
                            String string = (gs).cmsg.getText().replace('|', ':');
                            if (string.toLowerCase().indexOf((gs).tpass.getText().toLowerCase()) != -1)
                                string = " ";
                            if (!xt.msgcheck(string) && updatec > -12) {
                                for (int i_36_ = 0; i_36_ < 20; i_36_++) {
                                    sentn[i_36_] = sentn[i_36_ + 1];
                                    cnames[i_36_] = cnames[i_36_ + 1];
                                    ctime[i_36_] = ctime[i_36_ + 1];
                                }
                                sentn[20] = string;
                                cnames[20] = (xt).nickname;
                                ctime[20] = "- just now";
                                if (updatec > -11)
                                    updatec = -11;
                                else
                                    updatec--;
                                spos2 = 275;
                            } else
                                (xt).warning++;
                            (gs).cmsg.setText("");
                            (control).enter = false;
                        }
                        if (mscro2 == 831 || i_16_ == 0) {
                            if (i_16_ == 0)
                                rd.setColor(color2k(205, 205, 205));
                            else
                                rd.setColor(color2k(215, 215, 215));
                            rd.fillRect(772, 71, 17, 17);
                        } else {
                            rd.setColor(color2k(220, 220, 220));
                            rd.fill3DRect(772, 71, 17, 17, true);
                        }
                        if (i_16_ != 0)
                            rd.drawImage((xt).asu, 777, 77, null);
                        if (mscro2 == 832 || i_16_ == 0) {
                            if (i_16_ == 0)
                                rd.setColor(color2k(205, 205, 205));
                            else
                                rd.setColor(color2k(215, 215, 215));
                            rd.fillRect(772, 394, 17, 17);
                        } else {
                            rd.setColor(color2k(220, 220, 220));
                            rd.fill3DRect(772, 394, 17, 17, true);
                        }
                        if (i_16_ != 0)
                            rd.drawImage((xt).asd, 777, 401, null);
                        if (i_16_ != 0) {
                            if (lspos2 != spos2) {
                                rd.setColor(color2k(215, 215, 215));
                                rd.fillRect(772, 88 + spos2, 17, 31);
                            } else {
                                if (mscro2 == 831)
                                    rd.setColor(color2k(215, 215, 215));
                                rd.fill3DRect(772, 88 + spos2, 17, 31, true);
                            }
                            rd.setColor(color2k(150, 150, 150));
                            rd.drawLine(777, 101 + spos2, 783, 101 + spos2);
                            rd.drawLine(777, 103 + spos2, 783, 103 + spos2);
                            rd.drawLine(777, 105 + spos2, 783, 105 + spos2);
                            if (mscro2 > 800 && lspos2 != spos2)
                                lspos2 = spos2;
                            if (bool) {
                                if (mscro2 == 825 && i_0_ > 772 && i_0_ < 789 && i_1_ > 88 + spos2 && i_1_ < spos2 + 119)
                                    mscro2 = i_1_ - spos2;
                                if (mscro2 == 825 && i_0_ > 770 && i_0_ < 791 && i_1_ > 69 && i_1_ < 90)
                                    mscro2 = 831;
                                if (mscro2 == 825 && i_0_ > 770 && i_0_ < 791 && i_1_ > 392 && i_1_ < 413)
                                    mscro2 = 832;
                                if (mscro2 == 825 && i_0_ > 772 && i_0_ < 789 && i_1_ > 88 && i_1_ < 394) {
                                    mscro2 = 103;
                                    spos2 = i_1_ - mscro2;
                                }
                                int i_37_ = 2670 / i_16_;
                                if (i_37_ < 1)
                                    i_37_ = 1;
                                if (mscro2 == 831) {
                                    spos2 -= i_37_;
                                    if (spos2 > 275)
                                        spos2 = 275;
                                    if (spos2 < 0)
                                        spos2 = 0;
                                    lspos2 = spos2;
                                }
                                if (mscro2 == 832) {
                                    spos2 += i_37_;
                                    if (spos2 > 275)
                                        spos2 = 275;
                                    if (spos2 < 0)
                                        spos2 = 0;
                                    lspos2 = spos2;
                                }
                                if (mscro2 < 800) {
                                    spos2 = i_1_ - mscro2;
                                    if (spos2 > 275)
                                        spos2 = 275;
                                    if (spos2 < 0)
                                        spos2 = 0;
                                }
                                if (mscro2 == 825)
                                    mscro2 = 925;
                            } else if (mscro2 != 825)
                                mscro2 = 825;
                        }
                    } else if (edit != 3 && (gs).cmsg.isShowing())
                        (gs).cmsg.hide();
                    if (tab == 1) {
                        rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        rd.setColor(new Color(255, 255, 255));
                        rd.fillRoundRect(207, 45, 577, 394, 20, 20);
                        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawRoundRect(207, 45, 577, 394, 20, 20);
                        if (!flg)
                            flk += 5;
                        else
                            flk -= 5;
                        if (flk >= 100) {
                            flk = 100;
                            flg = true;
                        }
                        if (flk <= 60) {
                            flk = 60;
                            flg = false;
                        }
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(0, 0, 0));
                        rd.setComposite(AlphaComposite.getInstance(3, (float) flk / 100.0F));
                        boolean bool_38_ = false;
                        if (proname.equals((xt).nickname)) {
                            rd.drawString("Your Profile", 232, 67);
                            bool_38_ = true;
                        } else
                            rd.drawString(new StringBuilder().append("").append(proname).append("'s Profile").toString(), 232, 67);
                        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        if (loadedp) {
                            if (!bool_38_ && stringbutton("   <   My Profile   ", 715, 73, 1, i_0_, i_1_, bool)) {
                                proname = (xt).nickname;
                                loadedp = false;
                                onexitpro();
                            }
                            rd.setColor(new Color(0, 0, 0));
                            rd.setFont(new Font("Arial", 0, 11));
                            ftm = rd.getFontMetrics();
                            if (logol)
                                drawl(proname, 236, 101, true);
                            else
                                rd.drawString("No logo available", 296 - ftm.stringWidth("No logo available") / 2, 121);
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            String string = "Logo";
                            if (i_0_ > 232 && i_0_ < 359 && i_1_ > 84 && i_1_ < 134 && edit == 0 && bool_38_) {
                                string = "Edit Logo";
                                rd.drawLine(238, 98, 238 + ftm.stringWidth(string), 98);
                                if (i_0_ > 238 && i_0_ < 238 + ftm.stringWidth(string) && i_1_ > 85 && i_1_ < 100) {
                                    i_11_ = 12;
                                    if (bool) {
                                        if ((xt).logged) {
                                            edit = 1;
                                            msg = "Edit your Nickname's logo";
                                            flko = 0;
                                        } else
                                            edit = 5;
                                    }
                                }
                            }
                            rd.drawString(string, 238, 97);
                            rd.drawLine(232, 84, 232, 134);
                            rd.drawLine(232, 84, 238 + ftm.stringWidth(string) + 2, 84);
                            rd.drawLine(238 + ftm.stringWidth(string) + 2, 84, 238 + ftm.stringWidth(string) + 15, 97);
                            rd.drawLine(238 + ftm.stringWidth(string) + 15, 97, 359, 97);
                            rd.drawLine(359, 97, 359, 134);
                            rd.drawLine(232, 134, 359, 134);
                            rd.setFont(new Font("Arial", 0, 11));
                            ftm = rd.getFontMetrics();
                            if (clanlogol)
                                rd.drawImage(clanlogo, 406, 101, null);
                            else
                                rd.drawString("No clan logo available (this feature is under construction...)", 581 - ftm.stringWidth("No clan logo available (this feature is under construction...)") / 2, 121);
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            string = "Clan";
                            do {
                                if (i_0_ > 402 && i_0_ < 759 && i_1_ > 84 && i_1_ < 134 && clanlogol && edit == 0) {
                                    string = "View Clan :  Unknown";
                                    rd.drawLine(408, 98, 408 + ftm.stringWidth(string), 98);
                                    if (i_0_ > 408 && i_0_ < 408 + ftm.stringWidth(string) && i_1_ > 85 && i_1_ < 100 || i_0_ > 406 && i_0_ < 756 && i_1_ > 101 && i_1_ < 131) {
                                        i_11_ = 12;
                                        if (bool)
                                            break;
                                    }
                                }
                            } while (false);
                            rd.drawString(string, 408, 97);
                            rd.drawLine(402, 84, 402, 134);
                            rd.drawLine(402, 84, 408 + ftm.stringWidth(string) + 2, 84);
                            rd.drawLine(408 + ftm.stringWidth(string) + 2, 84, 408 + ftm.stringWidth(string) + 15, 97);
                            rd.drawLine(408 + ftm.stringWidth(string) + 15, 97, 759, 97);
                            rd.drawLine(759, 97, 759, 134);
                            rd.drawLine(402, 134, 759, 134);
                            rd.setFont(new Font("Arial", 0, 11));
                            ftm = rd.getFontMetrics();
                            if (avatarl)
                                rd.drawImage(avatar, 236, 161, null);
                            else
                                rd.drawString("No avatar available", 336 - ftm.stringWidth("No avatar available") / 2, 255);
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            string = "Avatar";
                            if (i_0_ > 232 && i_0_ < 439 && i_1_ > 144 && i_1_ < 364 && edit == 0 && bool_38_) {
                                string = "Edit Avatar";
                                rd.drawLine(238, 158, 238 + ftm.stringWidth(string), 158);
                                if (i_0_ > 238 && i_0_ < 238 + ftm.stringWidth(string) && i_1_ > 145 && i_1_ < 160) {
                                    i_11_ = 12;
                                    if (bool) {
                                        if ((xt).logged) {
                                            edit = 2;
                                            msg = "Edit your proflie avatar";
                                            flko = 0;
                                        } else
                                            edit = 5;
                                    }
                                }
                            }
                            rd.drawString(string, 238, 157);
                            rd.drawLine(232, 144, 232, 364);
                            rd.drawLine(232, 144, 238 + ftm.stringWidth(string) + 2, 144);
                            rd.drawLine(238 + ftm.stringWidth(string) + 2, 144, 238 + ftm.stringWidth(string) + 15, 157);
                            rd.drawLine(238 + ftm.stringWidth(string) + 15, 157, 439, 157);
                            rd.drawLine(439, 157, 439, 364);
                            rd.drawLine(232, 364, 439, 364);
                            string = "About";
                            if (i_0_ > 459 && i_0_ < 759 && i_1_ > 144 && i_1_ < 364 && edit == 0 && bool_38_) {
                                string = "Edit About";
                                rd.drawLine(465, 158, 465 + ftm.stringWidth(string), 158);
                                if (i_0_ > 465 && i_0_ < 465 + ftm.stringWidth(string) && i_1_ > 145 && i_1_ < 160) {
                                    i_11_ = 12;
                                    if (bool) {
                                        if ((xt).logged) {
                                            edit = 3;
                                            msg = "";
                                            flko = 0;
                                            sentchange = 0;
                                            badlang = false;
                                        } else
                                            edit = 5;
                                    }
                                }
                            }
                            rd.drawString(string, 465, 157);
                            rd.drawLine(459, 144, 459, 364);
                            rd.drawLine(459, 144, 465 + ftm.stringWidth(string) + 2, 144);
                            rd.drawLine(465 + ftm.stringWidth(string) + 2, 144, 465 + ftm.stringWidth(string) + 15, 157);
                            rd.drawLine(465 + ftm.stringWidth(string) + 15, 157, 759, 157);
                            rd.drawLine(759, 157, 759, 364);
                            rd.drawLine(459, 364, 759, 364);
                            if (nab != 0) {
                                rd.setFont(new Font("Tahoma", 1, 11));
                                int i_39_ = 200;
                                if (nab == 2)
                                    i_39_ = 192;
                                if (nab == 3)
                                    i_39_ = 185;
                                for (int i_40_ = 0; i_40_ < nab; i_40_++)
                                    rd.drawString(aboutxt[i_40_], 469, i_39_ + i_40_ * 15);
                            } else {
                                rd.setFont(new Font("Arial", 0, 11));
                                ftm = rd.getFontMetrics();
                                rd.drawString("No description available", 609 - ftm.stringWidth("No description available") / 2, 200);
                            }
                            rd.drawLine(489, 230, 729, 230);
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            rd.drawString("Racing", 532 - ftm.stringWidth("Racing") / 2, 253);
                            rd.drawString("VS", 532 - ftm.stringWidth("VS") / 2, 270);
                            rd.drawString("Wasting", 532 - ftm.stringWidth("Wasting") / 2, 287);
                            float f = (float) racing;
                            float f_41_ = (float) wasting;
                            if (racing > 10 && racing > wasting) {
                                f = 10.0F;
                                f_41_ = (float) wasting / ((float) racing / 10.0F);
                            }
                            if (wasting > 10 && wasting >= racing) {
                                f_41_ = 10.0F;
                                f = (float) racing / ((float) wasting / 10.0F);
                            }
                            f *= 14.0F;
                            f_41_ *= 14.0F;
                            for (int i_42_ = 0; i_42_ < 5; i_42_++) {
                                if (f != 0.0F) {
                                    rd.setColor(new Color(0, i_42_ * 50, 255));
                                    rd.drawLine(569, 245 + i_42_, (int) (569.0F + f), 245 + i_42_);
                                    rd.drawLine(569, 254 - i_42_, (int) (569.0F + f), 254 - i_42_);
                                }
                                if (f_41_ != 0.0F) {
                                    rd.setColor(new Color(255, i_42_ * 50, 0));
                                    rd.drawLine(569, 279 + i_42_, (int) (569.0F + f_41_), 279 + i_42_);
                                    rd.drawLine(569, 288 - i_42_, (int) (569.0F + f_41_), 288 - i_42_);
                                }
                            }
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRect(569, 244, 140, 11);
                            rd.drawRect(569, 278, 140, 11);
                            rd.drawLine(489, 304, 729, 304);
                            if (!themesong.equals("") && trackvol != 0) {
                                if (playt == 1)
                                    rd.drawString("Loading theme song, please wait...", 609 - ftm.stringWidth("Loading theme song, please wait...") / 2, 340);
                                if (playt == 0 && stringbutton(" Play Theme Song ", 609, 340, 1, i_0_, i_1_, bool) && edit == 0)
                                    playt = 1;
                                if (playt == 2) {
                                    rd.drawString("Theme song playing...", 609 - ftm.stringWidth("Theme song playing...") / 2, 325);
                                    if (stringbutton(" Stop ", 609, 350, 2, i_0_, i_1_, bool)) {
                                        (xt).strack.unload();
                                        playt = 0;
                                    }
                                }
                            } else {
                                rd.setFont(new Font("Arial", 0, 11));
                                ftm = rd.getFontMetrics();
                                rd.drawString("No theme song available", 609 - ftm.stringWidth("No theme song available") / 2, 340);
                            }
                            if (!bool_38_) {
                                rd.drawRect(232, 378, 527, 50);
                                if (stringbutton("   Add Friend   ", 313, 408, 1, i_0_, i_1_, bool))
                                    underc = 60;
                                if (stringbutton("   Send Message   ", 436, 408, 1, i_0_, i_1_, bool)) {
                                    tab = 2;
                                    openc = 10;
                                    if (!opname.equals(proname)) {
                                        opname = proname;
                                        lastsub = "";
                                        readmsg = 1;
                                    }
                                }
                                if (stringbutton("   View Cars   ", 558, 408, 1, i_0_, i_1_, bool))
                                    underc = 60;
                                if (stringbutton("   View Stages   ", 673, 408, 1, i_0_, i_1_, bool))
                                    underc = 60;
                                if (underc != 0) {
                                    int i_43_ = ftm.stringWidth("Option still under construction, you can only use 'Send Message' for now...");
                                    rd.setColor(new Color(244, 232, 204));
                                    rd.fillRect(495 - (i_43_ + 40) / 2, 422, i_43_ + 40, 23);
                                    rd.setColor(new Color(0, 0, 0));
                                    if (underc % 4 != 0)
                                        rd.drawString("Option still under construction, you can only use 'Send Message' for now...", 495 - i_43_ / 2, 438);
                                    rd.drawRect(495 - (i_43_ + 40) / 2, 422, i_43_ + 40, 23);
                                    underc--;
                                }
                            }
                            if (edit == 1 || edit == 2) {
                                rd.setColor(new Color(244, 232, 204));
                                rd.fillRoundRect(265, 92, 460, 220, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(265, 92, 460, 220, 20, 20);
                                String[] strings = { "logo", "120x30", "4 : 1" };
                                if (edit == 2) {
                                    strings[0] = "avatar";
                                    strings[1] = "200x200";
                                    strings[2] = "1 : 1";
                                }
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                if (flko % 4 != 0 || flko == 0)
                                    rd.drawString(msg, 495 - ftm.stringWidth(msg) / 2, 115);
                                if (flko != 0)
                                    flko--;
                                rd.setFont(new Font("Arial", 0, 12));
                                rd.drawString(new StringBuilder().append("The ").append(strings[0]).append(" image is ").append(strings[1]).append(" pixels.").toString(), 275, 140);
                                rd.drawString("Any image uploaded will be resized to that width and height. For the best results", 275, 160);
                                rd.drawString(new StringBuilder().append("try to upload an image that is bigger or equal to ").append(strings[1]).append(" and has the scale of").toString(), 275, 180);
                                rd.drawString(new StringBuilder().append("[ ").append(strings[2]).append(" ]  in  [ Width : Height ].").toString(), 275, 200);
                                rd.drawString("Image uploaded must be less than 1MB and in the format of JPEG, GIF or PNG.", 275, 220);
                                if (upload == 0) {
                                    if (stringbutton("  Upload Image  ", 495, 250, 0, i_0_, i_1_, bool)) {
                                        FileDialog filedialog = new FileDialog(new Frame(), "Upload Image");
                                        filedialog.setMode(0);
                                        filedialog.setVisible(true);
                                        filename = new StringBuilder().append("").append(filedialog.getDirectory()).append("").append(filedialog.getFile()).append("").toString();
                                        if (!filename.equals("nullnull"))
                                            upload = 1;
                                    }
                                } else {
                                    rd.setFont(new Font("Arial", 1, 12));
                                    ftm = rd.getFontMetrics();
                                    if (upload == 1)
                                        rd.drawString("Checking image...", 495 - ftm.stringWidth("Checking image...") / 2, 250);
                                    if (upload == 2)
                                        rd.drawString("Authenticating...", 495 - ftm.stringWidth("Authenticating...") / 2, 250);
                                    if (upload == 3)
                                        rd.drawString(new StringBuilder().append("Uploading image :  ").append(perc).append(" %").toString(), 495 - ftm.stringWidth("Uploading image :  80 %") / 2, 250);
                                    if (upload == 4)
                                        rd.drawString("Creating image online...", 495 - ftm.stringWidth("Creating image online...") / 2, 250);
                                    if (upload == 5)
                                        rd.drawString("Done", 495 - ftm.stringWidth("Done") / 2, 250);
                                }
                                if (stringbutton(" Cancel ", 495, 290, 2, i_0_, i_1_, bool)) {
                                    if (upload == 0)
                                        edit = 0;
                                    else
                                        upload = 0;
                                }
                            }
                            if (edit == 3) {
                                rd.setColor(new Color(244, 232, 204));
                                rd.fillRoundRect(265, 38, 460, 390, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(265, 38, 460, 390, 20, 20);
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString("Edit your about section", 495 - ftm.stringWidth("Edit your about section") / 2, 61);
                                rd.setFont(new Font("Arial", 0, 12));
                                if (!badlang)
                                    rd.drawString("Type in a sentence that best describes you and your playing style in the game :", 275, 86);
                                else {
                                    rd.setFont(new Font("Arial", 1, 12));
                                    rd.drawString("The sentence must not contain bad language!", 275, 86);
                                    rd.setFont(new Font("Arial", 0, 12));
                                }
                                bool_3_ = true;
                                rd.drawLine(315, 123, 675, 123);
                                rd.drawString("The (Racing VS Wasting ) is comparison between your multiplayer wins by", 275, 146);
                                rd.drawString("racing versus wasting.", 275, 166);
                                rd.drawString("It does not in anyway signify if you are better or worse than another player!", 275, 186);
                                rd.drawString("It simply shows whether you have a tendency to win games by racing or by", 275, 206);
                                rd.drawString("wasting, it shows what you are better at.", 275, 226);
                                rd.drawLine(315, 241, 675, 241);
                                rd.drawString("Upload your very own theme song!", 275, 264);
                                rd.drawString("The theme song must be a MOD Track that is in a zip file and less than 250KB.", 275, 284);
                                rd.drawString("You can find lots of MOD Tracks at modarchive.org.", 275, 304);
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                if (uploadt == 0) {
                                    if (msg.equals("")) {
                                        if (!themesong.equals("") && trackvol != 0)
                                            rd.drawString(new StringBuilder().append("Current Track : ").append(themesong).append("").toString(), 495 - ftm.stringWidth(new StringBuilder().append("Current Track : ").append(themesong).append("").toString()) / 2, 324);
                                        else {
                                            rd.setFont(new Font("Arial", 0, 12));
                                            rd.drawString("[ No theme song uploaded... ]", 495 - ftm.stringWidth("[ No theme song uploaded... ]") / 2, 324);
                                        }
                                    } else {
                                        if (flko % 4 != 0 || flko == 0)
                                            rd.drawString(msg, 495 - ftm.stringWidth(msg) / 2, 324);
                                        if (flko != 0)
                                            flko--;
                                    }
                                    if (stringbutton("  Upload Track  ", 495, 354, 0, i_0_, i_1_, bool)) {
                                        FileDialog filedialog = new FileDialog(new Frame(), "Upload Track");
                                        filedialog.setMode(0);
                                        filedialog.setFile("*.zip");
                                        filedialog.setVisible(true);
                                        filename = new StringBuilder().append("").append(filedialog.getDirectory()).append("").append(filedialog.getFile()).append("").toString();
                                        if (!filename.equals("nullnull")) {
                                            trackname = filedialog.getFile().substring(0, filedialog.getFile().length() - 4);
                                            uploadt = 1;
                                        }
                                    }
                                } else {
                                    if (uploadt == 1)
                                        rd.drawString("Checking MOD Track...", 495 - ftm.stringWidth("Checking MOD Track...") / 2, 354);
                                    if (uploadt == 2)
                                        rd.drawString("Authenticating...", 495 - ftm.stringWidth("Authenticating...") / 2, 354);
                                    if (uploadt == 3)
                                        rd.drawString("Uploading track, please wait...", 495 - ftm.stringWidth("Uploading track, please wait...") / 2, 354);
                                    if (uploadt == 4)
                                        rd.drawString("Adding track to your profile...", 495 - ftm.stringWidth("Adding track to your profile...") / 2, 354);
                                    if (uploadt == 5)
                                        rd.drawString("Done", 495 - ftm.stringWidth("Done") / 2, 354);
                                }
                                rd.drawLine(315, 376, 675, 376);
                                if (stringbutton("        Done        ", 495, 407, 1, i_0_, i_1_, bool)) {
                                    edit = 0;
                                    if (sentchange == 1) {
                                        if (xt.msgcheck(sentance) || sentance.toLowerCase().indexOf((gs).tpass.getText().toLowerCase()) != -1 || (xt).acexp == -3) {
                                            edit = 3;
                                            sentchange = 0;
                                            sentance = "";
                                            (gs).cmsg.setText(sentance);
                                            badlang = true;
                                        } else
                                            sentchange = 2;
                                        trunsent();
                                    }
                                }
                            }
                            if (edit == 5) {
                                rd.setColor(new Color(244, 232, 204));
                                rd.fillRoundRect(265, 187, 460, 125, 20, 20);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawRoundRect(265, 187, 460, 125, 20, 20);
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString("You need to upgrade your account to a full account to edit your profile!", 495 - ftm.stringWidth("You need to upgrade your account to a full account to edit your profile!") / 2, 215);
                                if (stringbutton("  Upgrade Now  ", 495, 250, 0, i_0_, i_1_, bool))
                                    gs.editlink((xt).nickname);
                                if (stringbutton("  Cancel  ", 495, 290, 2, i_0_, i_1_, bool))
                                    edit = 0;
                            }
                        } else
                            rd.drawString("Loading profile, please wait...", 495 - ftm.stringWidth("Loading profile, please wait...") / 2, 222);
                    } else {
                        edit = 0;
                        upload = 0;
                        uploadt = 0;
                        sentchange = 0;
                        underc = 0;
                    }
                    if (tab == 2) {
                        if (openc != 10) {
                            rd.setColor(color2k(230, 230, 230));
                            rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                            if (loadmsgs != 0 && loadmsgs != -2 && loadmsgs != -1) {
                                i_16_ = (nm - 10) * 31;
                                if (i_16_ < 0)
                                    i_16_ = 0;
                                int i_44_ = (int) ((float) spos3 / 268.0F * (float) i_16_);
                                int i_45_ = 0;
                                for (int i_46_ = 0; i_46_ < nm; i_46_++) {
                                    if (mtyp[i_46_] != 3) {
                                        if (76 + 31 * i_45_ - i_44_ < 408 && 107 + 31 * i_45_ - i_44_ > 76) {
                                            boolean bool_47_ = false;
                                            if (i_0_ > 207 && i_0_ < 770 && i_1_ > 76 + 31 * i_45_ - i_44_ && i_1_ < 106 + 31 * i_45_ - i_44_) {
                                                bool_47_ = true;
                                                i_11_ = 12;
                                                if (bool && openc == 0) {
                                                    opy = 70 + 31 * i_45_ - i_44_;
                                                    addopy = (40 - opy) / 10;
                                                    oph = 44;
                                                    openc = 1;
                                                    if (!opname.equals(mname[i_46_])) {
                                                        opname = mname[i_46_];
                                                        lastsub = "";
                                                        readmsg = 1;
                                                    }
                                                }
                                            }
                                            if (mtyp[i_46_] == 1) {
                                                rd.setColor(color2k(240, 240, 240));
                                                rd.fillRect(207, 77 + 31 * i_45_ - i_44_, 564, 30);
                                            }
                                            if (bool_47_) {
                                                rd.setColor(color2k(250, 250, 250));
                                                rd.fillRect(207, 77 + 31 * i_45_ - i_44_, 564, 30);
                                            }
                                            boolean bool_48_ = drawl(mname[i_46_], 207, 77 + 31 * i_45_ - i_44_, bool_47_);
                                            if (!bool_47_ || !bool_48_) {
                                                rd.setFont(new Font("Arial", 1, 12));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString(mname[i_46_], 267 - ftm.stringWidth(mname[i_46_]) / 2, 96 + 31 * i_45_ - i_44_);
                                            }
                                            int[] is = { 0, 5, 5, 14, 14, 5, 5 };
                                            int[] is_49_ = { 0, -5, -2, -2, 3, 3, 5 };
                                            if (mtyp[i_46_] != 2) {
                                                for (int i_50_ = 0; i_50_ < 7; i_50_++) {
                                                    is[i_50_] += 335;
                                                    is_49_[i_50_] += 98 + 31 * i_45_ - i_44_;
                                                }
                                                rd.setColor(new Color(0, 128, 0));
                                            } else {
                                                for (int i_51_ = 0; i_51_ < 7; i_51_++) {
                                                    is[i_51_] = 349 - is[i_51_];
                                                    is_49_[i_51_] += 98 + 31 * i_45_ - i_44_;
                                                }
                                                rd.setColor(new Color(0, 0, 128));
                                            }
                                            rd.fillPolygon(is, is_49_, 7);
                                            rd.setFont(new Font("Tahoma", 0, 11));
                                            ftm = rd.getFontMetrics();
                                            rd.setColor(color2k(125, 125, 125));
                                            rd.drawString(mtime[i_46_], 760 - ftm.stringWidth(mtime[i_46_]), 102 + 31 * i_45_ - i_44_);
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.drawString(msub[i_46_], 335, 89 + 31 * i_45_ - i_44_);
                                            rd.setColor(color2k(150, 150, 150));
                                            rd.drawLine(207, 107 + 31 * i_45_ - i_44_, 770, 107 + 31 * i_45_ - i_44_);
                                        }
                                        i_45_++;
                                    }
                                }
                                for (int i_52_ = 0; i_52_ < nm; i_52_++) {
                                    if (mtyp[i_52_] == 3) {
                                        if (76 + 31 * i_45_ - i_44_ < 408 && 107 + 31 * i_45_ - i_44_ > 76) {
                                            rd.setFont(new Font("Arial", 1, 12));
                                            ftm = rd.getFontMetrics();
                                            boolean bool_53_ = false;
                                            if (i_0_ > 207 && i_0_ < 770 && i_1_ > 76 + 31 * i_45_ - i_44_ && i_1_ < 106 + 31 * i_45_ - i_44_)
                                                bool_53_ = true;
                                            boolean bool_54_ = drawl(mname[i_52_], 207, 77 + 31 * i_45_ - i_44_, bool_53_);
                                            if (!bool_53_ || !bool_54_) {
                                                rd.setColor(new Color(0, 0, 0));
                                                rd.drawString(mname[i_52_], 267 - ftm.stringWidth(mname[i_52_]) / 2, 96 + 31 * i_45_ - i_44_);
                                            }
                                            rd.setColor(color2k(100, 100, 100));
                                            rd.fillRect(327, 77 + 31 * i_45_ - i_44_, 444, 30);
                                            rd.setColor(color2k(200, 200, 200));
                                            if (unblockname.equals(""))
                                                rd.drawString("Blocked", 337, 96 + 31 * i_45_ - i_44_);
                                            else
                                                rd.drawString("Unblocking...", 337, 96 + 31 * i_45_ - i_44_);
                                            if (bool_53_ && stringbutton("   Unblock  ", 724, 96 + 31 * i_45_ - i_44_, 3, i_0_, i_1_, bool) && unblockname.equals(""))
                                                unblockname = mname[i_52_];
                                            rd.setColor(color2k(150, 150, 150));
                                            rd.drawLine(207, 107 + 31 * i_45_ - i_44_, 770, 107 + 31 * i_45_ - i_44_);
                                        }
                                        i_45_++;
                                    }
                                }
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(207, 46, 582, 30);
                                rd.setFont(new Font("Arial", 1, 12));
                                rd.setColor(color2k(40, 40, 40));
                                rd.drawString("Conversations", 213, 67);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(207, 73, 770, 73);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(207, 409, 582, 30);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(207, 411, 770, 411);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(772, 93, 17, 299);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(203, 46, 4, 393);
                                if (mscro3 == 831 || i_16_ == 0) {
                                    if (i_16_ == 0)
                                        rd.setColor(color2k(205, 205, 205));
                                    else
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(772, 76, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(772, 76, 17, 17, true);
                                }
                                if (i_16_ != 0)
                                    rd.drawImage((xt).asu, 777, 82, null);
                                if (mscro3 == 832 || i_16_ == 0) {
                                    if (i_16_ == 0)
                                        rd.setColor(color2k(205, 205, 205));
                                    else
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(772, 392, 17, 17);
                                } else {
                                    rd.setColor(color2k(220, 220, 220));
                                    rd.fill3DRect(772, 392, 17, 17, true);
                                }
                                if (i_16_ != 0)
                                    rd.drawImage((xt).asd, 777, 399, null);
                                if (i_16_ != 0) {
                                    if (lspos3 != spos3) {
                                        rd.setColor(color2k(215, 215, 215));
                                        rd.fillRect(772, 93 + spos3, 17, 31);
                                    } else {
                                        if (mscro3 == 831)
                                            rd.setColor(color2k(215, 215, 215));
                                        rd.fill3DRect(772, 93 + spos3, 17, 31, true);
                                    }
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(777, 106 + spos3, 783, 106 + spos3);
                                    rd.drawLine(777, 108 + spos3, 783, 108 + spos3);
                                    rd.drawLine(777, 110 + spos3, 783, 110 + spos3);
                                    if (mscro3 > 800 && lspos3 != spos3)
                                        lspos3 = spos3;
                                    if (bool && openc == 0) {
                                        if (mscro3 == 825 && i_0_ > 772 && i_0_ < 789 && i_1_ > 93 + spos3 && i_1_ < spos3 + 124)
                                            mscro3 = i_1_ - spos3;
                                        if (mscro3 == 825 && i_0_ > 770 && i_0_ < 791 && i_1_ > 74 && i_1_ < 95)
                                            mscro3 = 831;
                                        if (mscro3 == 825 && i_0_ > 770 && i_0_ < 791 && i_1_ > 390 && i_1_ < 411)
                                            mscro3 = 832;
                                        if (mscro3 == 825 && i_0_ > 772 && i_0_ < 789 && i_1_ > 93 && i_1_ < 392) {
                                            mscro3 = 108;
                                            spos3 = i_1_ - mscro3;
                                        }
                                        int i_55_ = 2670 / i_16_;
                                        if (i_55_ < 1)
                                            i_55_ = 1;
                                        if (mscro3 == 831) {
                                            spos3 -= i_55_;
                                            if (spos3 > 268)
                                                spos3 = 268;
                                            if (spos3 < 0)
                                                spos3 = 0;
                                            lspos3 = spos3;
                                        }
                                        if (mscro3 == 832) {
                                            spos3 += i_55_;
                                            if (spos3 > 268)
                                                spos3 = 268;
                                            if (spos3 < 0)
                                                spos3 = 0;
                                            lspos3 = spos3;
                                        }
                                        if (mscro3 < 800) {
                                            spos3 = i_1_ - mscro3;
                                            if (spos3 > 268)
                                                spos3 = 268;
                                            if (spos3 < 0)
                                                spos3 = 0;
                                        }
                                        if (mscro3 == 825)
                                            mscro3 = 925;
                                    } else if (mscro3 != 825)
                                        mscro3 = 825;
                                }
                            } else {
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(207, 46, 582, 30);
                                rd.setFont(new Font("Arial", 1, 12));
                                rd.setColor(color2k(40, 40, 40));
                                rd.drawString("Conversations", 213, 67);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(207, 73, 770, 73);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(207, 409, 582, 30);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(207, 411, 770, 411);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(772, 76, 17, 333);
                                rd.setColor(color2k(205, 205, 205));
                                rd.fillRect(203, 46, 4, 393);
                                if (loadmsgs == 0) {
                                    rd.setFont(new Font("Arial", 1, 11));
                                    ftm = rd.getFontMetrics();
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("You have not started any conversations yet.", 487 - ftm.stringWidth("You have not started any conversations yet.") / 2, 200);
                                }
                                if (loadmsgs == -2) {
                                    rd.setFont(new Font("Arial", 1, 11));
                                    ftm = rd.getFontMetrics();
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("Failed to load conversations, will try again now...", 487 - ftm.stringWidth("Failed to load conversations, will try again now...") / 2, 200);
                                }
                                if (loadmsgs == -1) {
                                    rd.setFont(new Font("Arial", 1, 11));
                                    ftm = rd.getFontMetrics();
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("Loading conversations, please wait...", 487 - ftm.stringWidth("Loading conversation, please wait...") / 2, 200);
                                }
                            }
                            if ((gs).sendtyp.isShowing())
                                (gs).sendtyp.hide();
                            if ((gs).senditem.isShowing())
                                (gs).senditem.hide();
                        } else {
                            rd.setColor(color2k(240, 240, 240));
                            rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                            rd.setColor(color2k(250, 250, 250));
                            rd.fillRect(207, 86, 577, 274);
                            i_16_ = (int) (((float) nml - 14.75F) * 17.0F);
                            if (i_16_ < 0)
                                i_16_ = 0;
                            int i_56_ = (int) ((float) spos4 / 208.0F * (float) i_16_);
                            if (readmsg == 2) {
                                for (int i_57_ = 0; i_57_ < nml; i_57_++) {
                                    if (86 + 17 * i_57_ - i_56_ < 360 && 125 + 17 * i_57_ - i_56_ > 86 && mlinetyp[i_57_] != 167) {
                                        rd.setColor(new Color(0, 0, 0));
                                        if (mlinetyp[i_57_] != 10 && mlinetyp[i_57_] != 20) {
                                            if (mlinetyp[i_57_] == 0 || mlinetyp[i_57_] == 1 || mlinetyp[i_57_] == 2)
                                                rd.setFont(new Font("Tahoma", 1, 11));
                                            else
                                                rd.setFont(new Font("Tahoma", 0, 11));
                                            rd.drawString(mline[i_57_], 217, 103 + 17 * i_57_ - i_56_);
                                            if (mlinetyp[i_57_] == 0 || mlinetyp[i_57_] == 1 || mlinetyp[i_57_] == 2) {
                                                rd.setFont(new Font("Tahoma", 0, 11));
                                                ftm = rd.getFontMetrics();
                                                rd.setColor(color2k(125, 125, 125));
                                                rd.drawString(mtimes[i_57_], 757 - ftm.stringWidth(mtimes[i_57_]), 103 + 17 * i_57_ - i_56_);
                                            }
                                        } else {
                                            if (mlinetyp[i_57_] == 10) {
                                                if ((cd).acname.equals(mline[i_57_])) {
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    ftm = rd.getFontMetrics();
                                                    if ((cd).action == -9)
                                                        rd.drawString("Failed to add car!  Unknown error, please try again later.", 217, 109 + 17 * i_57_ - i_56_);
                                                    if ((cd).action == -8)
                                                        rd.drawString("Cannot add more then 20 cars to your account!", 217, 109 + 17 * i_57_ - i_56_);
                                                    if ((cd).action == 7) {
                                                        rd.setColor(new Color(94, 170, 0));
                                                        rd.drawString(new StringBuilder().append("[").append(mline[i_57_]).append("] has been added to your cars!").toString(), 217, 109 + 17 * i_57_ - i_56_);
                                                    }
                                                    if ((cd).action == -7)
                                                        rd.drawString("You already have this car.", 217, 109 + 17 * i_57_ - i_56_);
                                                    if ((cd).action == 6)
                                                        rd.drawString("Adding Car...", 217, 109 + 17 * i_57_ - i_56_);
                                                    if ((cd).action == -6) {
                                                        rd.setColor(new Color(193, 106, 0));
                                                        String string = "Upgrade to a full account to add custom cars!";
                                                        int i_58_ = 217;
                                                        int i_59_ = i_58_ + ftm.stringWidth(string);
                                                        rd.drawString(string, i_58_, 109 + 17 * i_57_ - i_56_);
                                                        if (waitlink != -1)
                                                            rd.drawLine(i_58_, 111 + 17 * i_57_ - i_56_, i_59_, 111 + 17 * i_57_ - i_56_);
                                                        if (i_0_ > i_58_ && i_0_ < i_59_ && i_1_ > 98 + 17 * i_57_ - i_56_ && i_1_ < 111 + 17 * i_57_ - i_56_) {
                                                            if (waitlink != -1)
                                                                i_11_ = 12;
                                                            if (bool && waitlink == 0) {
                                                                gs.editlink((xt).nickname);
                                                                waitlink = -1;
                                                            }
                                                        }
                                                        if (waitlink > 0)
                                                            waitlink--;
                                                    }
                                                }
                                                if ((cd).action == 0 || !(cd).acname.equals(mline[i_57_])) {
                                                    rd.setFont(new Font("Arial", 0, 12));
                                                    rd.drawString("Car name:", 340, 109 + 17 * i_57_ - i_56_);
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    rd.drawString(new StringBuilder().append("[  ").append(mline[i_57_]).append("  ]").toString(), 407, 109 + 17 * i_57_ - i_56_);
                                                    if (xt.drawcarb(true, null, " Add to My Cars ", 217, 90 + 17 * i_57_ - i_56_, i_0_, i_1_, bool)) {
                                                        if ((xt).logged) {
                                                            (cd).action = 6;
                                                            (cd).ac = -1;
                                                            (cd).acname = mline[i_57_];
                                                            cd.sparkactionloader();
                                                        } else {
                                                            (cd).acname = mline[i_57_];
                                                            (cd).action = -6;
                                                            waitlink = 20;
                                                        }
                                                    }
                                                }
                                            }
                                            if (mlinetyp[i_57_] == 20) {
                                                if ((cd).onstage.equals(mline[i_57_])) {
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    ftm = rd.getFontMetrics();
                                                    if (addstage == 2) {
                                                        rd.drawString("Adding stage...", 217, 109 + 17 * i_57_ - i_56_);
                                                        if ((cd).staction == 0)
                                                            addstage = 3;
                                                        if ((cd).staction == -2)
                                                            addstage = 4;
                                                        if ((cd).staction == -3)
                                                            addstage = 5;
                                                        if ((cd).staction == -1)
                                                            addstage = 6;
                                                    }
                                                    if (addstage == 3) {
                                                        rd.setColor(new Color(94, 170, 0));
                                                        rd.drawString(new StringBuilder().append("[").append(mline[i_57_]).append("] has been added to your stages!").toString(), 217, 109 + 17 * i_57_ - i_56_);
                                                    }
                                                    if (addstage == 4)
                                                        rd.drawString("You already have this stage.", 217, 109 + 17 * i_57_ - i_56_);
                                                    if (addstage == 5)
                                                        rd.drawString("Cannot add more then 20 stages to your account!", 217, 109 + 17 * i_57_ - i_56_);
                                                    if (addstage == 6)
                                                        rd.drawString("Failed to add stage!  Unknown error, please try again later.", 217, 109 + 17 * i_57_ - i_56_);
                                                    if (addstage == 1) {
                                                        rd.setColor(new Color(193, 106, 0));
                                                        String string = "Upgrade to a full account to add custom stages!";
                                                        int i_60_ = 217;
                                                        int i_61_ = i_60_ + ftm.stringWidth(string);
                                                        rd.drawString(string, i_60_, 109 + 17 * i_57_ - i_56_);
                                                        if (waitlink != -1)
                                                            rd.drawLine(i_60_, 111 + 17 * i_57_ - i_56_, i_61_, 111 + 17 * i_57_ - i_56_);
                                                        if (i_0_ > i_60_ && i_0_ < i_61_ && i_1_ > 98 + 17 * i_57_ - i_56_ && i_1_ < 111 + 17 * i_57_ - i_56_) {
                                                            if (waitlink != -1)
                                                                i_11_ = 12;
                                                            if (bool && waitlink == 0) {
                                                                gs.editlink((xt).nickname);
                                                                waitlink = -1;
                                                            }
                                                        }
                                                        if (waitlink > 0)
                                                            waitlink--;
                                                    }
                                                }
                                                if (addstage == 0 || !(cd).onstage.equals(mline[i_57_])) {
                                                    rd.setFont(new Font("Arial", 0, 12));
                                                    rd.drawString("Stage name:", 355, 109 + 17 * i_57_ - i_56_);
                                                    rd.setFont(new Font("Arial", 1, 12));
                                                    rd.drawString(new StringBuilder().append("[  ").append(mline[i_57_]).append("  ]").toString(), 434, 109 + 17 * i_57_ - i_56_);
                                                    if (xt.drawcarb(true, null, " Add to My Stages ", 217, 90 + 17 * i_57_ - i_56_, i_0_, i_1_, bool)) {
                                                        if ((xt).logged) {
                                                            (cd).onstage = mline[i_57_];
                                                            (cd).staction = 2;
                                                            cd.sparkstageaction();
                                                            addstage = 2;
                                                        } else {
                                                            (cd).onstage = mline[i_57_];
                                                            addstage = 1;
                                                            waitlink = 20;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (readmsg == 1) {
                                rd.setFont(new Font("Tahoma", 1, 11));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString("Loading...", 487 - ftm.stringWidth("Loading...") / 2, 200);
                            }
                            if (readmsg == 3) {
                                rd.setFont(new Font("Tahoma", 1, 11));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString("Failed to fetch and load conversation.", 487 - ftm.stringWidth("Failed to fetch and load conversation.") / 2, 200);
                            }
                            if (readmsg == 4) {
                                rd.setFont(new Font("Tahoma", 1, 11));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString("Failed to load conversation, server error, please try again later.", 487 - ftm.stringWidth("Failed to load conversation, please try again later.") / 2, 200);
                            }
                            if (readmsg == 5) {
                                rd.setFont(new Font("Tahoma", 1, 11));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString("Failed to send message, server error, please try again later.", 487 - ftm.stringWidth("Failed to send message, server error, please try again later.") / 2, 200);
                            }
                            rd.setColor(color2k(240, 240, 240));
                            rd.fillRect(207, 47, 577, 39);
                            rd.fillRect(207, 360, 577, 39);
                            rd.setColor(color2k(205, 205, 205));
                            rd.drawLine(207, 86, 783, 86);
                            rd.drawLine(207, 86, 207, 360);
                            rd.drawLine(207, 360, 783, 360);
                            rd.fillRect(767, 104, 17, 239);
                            if (mscro4 == 831 || i_16_ == 0) {
                                if (i_16_ == 0)
                                    rd.setColor(color2k(205, 205, 205));
                                else
                                    rd.setColor(color2k(215, 215, 215));
                                rd.fillRect(767, 87, 17, 17);
                            } else {
                                rd.setColor(color2k(220, 220, 220));
                                rd.fill3DRect(767, 87, 17, 17, true);
                            }
                            if (i_16_ != 0)
                                rd.drawImage((xt).asu, 772, 93, null);
                            if (mscro4 == 832 || i_16_ == 0) {
                                if (i_16_ == 0)
                                    rd.setColor(color2k(205, 205, 205));
                                else
                                    rd.setColor(color2k(215, 215, 215));
                                rd.fillRect(767, 343, 17, 17);
                            } else {
                                rd.setColor(color2k(220, 220, 220));
                                rd.fill3DRect(767, 343, 17, 17, true);
                            }
                            if (i_16_ != 0)
                                rd.drawImage((xt).asd, 772, 350, null);
                            if (i_16_ != 0) {
                                if (lspos4 != spos4) {
                                    rd.setColor(color2k(215, 215, 215));
                                    rd.fillRect(767, 104 + spos4, 17, 31);
                                } else {
                                    if (mscro4 == 831)
                                        rd.setColor(color2k(215, 215, 215));
                                    rd.fill3DRect(767, 104 + spos4, 17, 31, true);
                                }
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawLine(772, 117 + spos4, 778, 117 + spos4);
                                rd.drawLine(772, 119 + spos4, 778, 119 + spos4);
                                rd.drawLine(772, 121 + spos4, 778, 121 + spos4);
                                if (mscro4 > 800 && lspos4 != spos4)
                                    lspos4 = spos4;
                                if (bool) {
                                    if (mscro4 == 825 && i_0_ > 767 && i_0_ < 784 && i_1_ > 104 + spos4 && i_1_ < spos4 + 135)
                                        mscro4 = i_1_ - spos4;
                                    if (mscro4 == 825 && i_0_ > 765 && i_0_ < 786 && i_1_ > 85 && i_1_ < 106)
                                        mscro4 = 831;
                                    if (mscro4 == 825 && i_0_ > 765 && i_0_ < 786 && i_1_ > 341 && i_1_ < 362)
                                        mscro4 = 832;
                                    if (mscro4 == 825 && i_0_ > 767 && i_0_ < 784 && i_1_ > 104 && i_1_ < 343) {
                                        mscro4 = 119;
                                        spos4 = i_1_ - mscro4;
                                    }
                                    int i_62_ = 2670 / i_16_;
                                    if (i_62_ < 1)
                                        i_62_ = 1;
                                    if (mscro4 == 831) {
                                        spos4 -= i_62_;
                                        if (spos4 > 208)
                                            spos4 = 208;
                                        if (spos4 < 0)
                                            spos4 = 0;
                                        lspos4 = spos4;
                                    }
                                    if (mscro4 == 832) {
                                        spos4 += i_62_;
                                        if (spos4 > 208)
                                            spos4 = 208;
                                        if (spos4 < 0)
                                            spos4 = 0;
                                        lspos4 = spos4;
                                    }
                                    if (mscro4 < 800) {
                                        spos4 = i_1_ - mscro4;
                                        if (spos4 > 208)
                                            spos4 = 208;
                                        if (spos4 < 0)
                                            spos4 = 0;
                                    }
                                    if (mscro4 == 825)
                                        mscro4 = 925;
                                } else if (mscro4 != 825)
                                    mscro4 = 825;
                            }
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            if (!drawl(opname, 207, 47, true)) {
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString(opname, 267 - ftm.stringWidth(opname) / 2, 66);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawRect(207, 47, 119, 29);
                            }
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawString(new StringBuilder().append("::  Conversation with ").append(opname).append("").toString(), 336, 72);
                            if (i_0_ > 207 && i_0_ < 327 && i_1_ > 47 && i_1_ < 77) {
                                i_11_ = 12;
                                if (bool) {
                                    tab = 1;
                                    if (!proname.equals(opname)) {
                                        proname = opname;
                                        loadedp = false;
                                        onexitpro();
                                    }
                                }
                            }
                            if (stringbutton("Block / Ignore", 665, 66, 0, i_0_, i_1_, bool)) {
                                openc = 0;
                                blockname = opname;
                            }
                            if (stringbutton("Close X", 752, 66, 0, i_0_, i_1_, bool)) {
                                openc = 0;
                                readmsg = 0;
                            }
                            if (!(gs).sendtyp.isShowing()) {
                                (gs).sendtyp.select(0);
                                itemsel = 0;
                                (gs).sendtyp.show();
                            }
                            (gs).sendtyp.move(207, 365);
                            String string = "";
                            if ((gs).sendtyp.getSelectedIndex() == 0) {
                                bool_4_ = true;
                                if (loaditem != 0)
                                    loaditem = 0;
                            }
                            if ((gs).sendtyp.getSelectedIndex() == 1) {
                                string = "car";
                                rd.setFont(new Font("Arial", 0, 12));
                                rd.drawString("Send a public car you have or a private car that belongs to you.", 376, 382);
                            }
                            if ((gs).sendtyp.getSelectedIndex() == 2) {
                                string = "stage";
                                rd.setFont(new Font("Arial", 0, 12));
                                rd.drawString("Send a public stage you have or a private stage that belongs to you.", 376, 382);
                            }
                            if (itemsel != (gs).sendtyp.getSelectedIndex()) {
                                (gs).senditem.hide();
                                itemsel = (gs).sendtyp.getSelectedIndex();
                            }
                            if ((gs).sendtyp.getSelectedIndex() == 1 || (gs).sendtyp.getSelectedIndex() == 2) {
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString(new StringBuilder().append("Select ").append(string).append(" to share:").toString(), 207, 420);
                                if (!(gs).senditem.isShowing()) {
                                    (gs).senditem.removeAll();
                                    if ((xt).logged) {
                                        (gs).senditem.add(rd, new StringBuilder().append("Loading your ").append(string).append(" list, please wait...").toString());
                                        loaditem = (gs).sendtyp.getSelectedIndex();
                                    } else
                                        (gs).senditem.add(rd, new StringBuilder().append("You a need a full account to access custom ").append(string).append("s!").toString());
                                    (gs).senditem.select(0);
                                    (gs).senditem.show();
                                }
                                (gs).senditem.move(207 + ftm.stringWidth(new StringBuilder().append("Select ").append(string).append(" to share:").toString()) + 11, 403);
                                if (loaditem == 10 && (gs).sendtyp.getSelectedIndex() == 1 || loaditem == 20 && (gs).sendtyp.getSelectedIndex() == 2 || !(xt).logged) {
                                    if ((xt).logged) {
                                        if (sendmsg == 0) {
                                            if (stringbutton("   Send  >  ", 723, 420, 0, i_0_, i_1_, bool))
                                                sendmsg = 1;
                                        } else
                                            rd.drawString("Sending...", 723 - ftm.stringWidth("Sending...") / 2, 420);
                                    } else if (stringbutton("  Upgrade Now  ", 723, 420, 0, i_0_, i_1_, bool))
                                        gs.editlink((xt).nickname);
                                }
                            } else if (sendmsg == 0) {
                                if (stringbutton("   Send  >  ", 723, 408, 0, i_0_, i_1_, bool) && !(gs).mmsg.getText().trim().equals("") && (gs).mmsg.getText().toLowerCase().indexOf((gs).tpass.getText().toLowerCase()) == -1 && (xt).acexp != -3) {
                                    if (!xt.msgcheck((gs).mmsg.getText()))
                                        sendmsg = 1;
                                    else {
                                        (gs).sendtyp.hide();
                                        (xt).warning++;
                                    }
                                }
                            } else {
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString("Sending...", 723 - ftm.stringWidth("Sending...") / 2, 408);
                            }
                        }
                        if (openc >= 1 && openc < 10) {
                            rd.setColor(color2k(240, 240, 230));
                            rd.fillRoundRect(197, opy, 597, oph, 20, 20);
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawRoundRect(197, opy, 597, oph, 20, 20);
                            if (!drawl(opname, 207, opy + 7, true)) {
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString(opname, 267 - ftm.stringWidth(opname) / 2, opy + 26);
                                rd.setColor(color2k(150, 150, 150));
                                rd.drawRect(207, opy + 7, 119, 29);
                            }
                            opy += addopy;
                            oph += 36;
                            openc++;
                        }
                    } else {
                        if ((gs).sendtyp.isShowing())
                            (gs).sendtyp.hide();
                        if ((gs).senditem.isShowing())
                            (gs).senditem.hide();
                    }
                    if (tab != 0 && tab != 1 && tab != 2) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("Coming soon in the next updates, stay tuned...", 495 - ftm.stringWidth("Coming soon in the next updates, stay tuned...") / 2, 200);
                    }
                    if (ptab == 0) {
                        if (npo != -1) {
                            i_16_ = (npo - 7) * 50;
                            if (i_16_ < 0)
                                i_16_ = 0;
                            int i_63_ = (int) ((float) spos / 345.0F * (float) i_16_);
                            for (int i_64_ = 0; i_64_ < npo; i_64_++) {
                                if (57 + 50 * i_64_ - i_63_ > 0 && 57 + 50 * (i_64_ - 1) - i_63_ < 438) {
                                    boolean bool_65_ = false;
                                    if (i_0_ > 26 && i_0_ < 146 && i_1_ > 38 + 50 * i_64_ - i_63_ && i_1_ < 68 + 50 * i_64_ - i_63_) {
                                        bool_65_ = true;
                                        i_11_ = 12;
                                        if (bool) {
                                            tab = 1;
                                            if (!proname.equals(pname[i_64_])) {
                                                proname = pname[i_64_];
                                                loadedp = false;
                                                onexitpro();
                                            }
                                        }
                                    }
                                    boolean bool_66_ = drawl(pname[i_64_], 26, 38 + 50 * i_64_ - i_63_, bool_65_);
                                    if (!bool_65_ || !bool_66_) {
                                        rd.setFont(new Font("Arial", 1, 12));
                                        ftm = rd.getFontMetrics();
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.drawString(pname[i_64_], 86 - ftm.stringWidth(pname[i_64_]) / 2, 49 + 50 * i_64_ - i_63_);
                                        rd.setFont(new Font("Arial", 1, 11));
                                        ftm = rd.getFontMetrics();
                                        String string = "Not in any room...";
                                        if (pserver[i_64_] >= 0 && pserver[i_64_] <= 2 && proom[i_64_] >= 0 && proom[i_64_] <= 4) {
                                            string = new StringBuilder().append("").append((lg).snames[pserver[i_64_]]).append(" :: Room ").append(proom[i_64_] + 1).append("").toString();
                                            if (roomf[pserver[i_64_]][proom[i_64_]] >= 10)
                                                rd.setColor(new Color(117, 67, 0));
                                            else
                                                rd.setColor(new Color(49, 79, 0));
                                        }
                                        rd.drawString(string, 86 - ftm.stringWidth(string) / 2, 65 + 50 * i_64_ - i_63_);
                                    }
                                    rd.setColor(color2k(150, 150, 150));
                                    rd.drawLine(5, 77 + 50 * i_64_ - i_63_, 167, 77 + 50 * i_64_ - i_63_);
                                }
                            }
                        } else {
                            rd.setColor(new Color(0, 0, 0));
                            rd.setFont(new Font("Arial", 1, 12));
                            ftm = rd.getFontMetrics();
                            rd.drawString("Loading Players...", 86 - ftm.stringWidth("Loading Players...") / 2, 200);
                        }
                    } else {
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 12));
                        ftm = rd.getFontMetrics();
                        rd.drawString("Coming soon...", 86 - ftm.stringWidth("Coming soon...") / 2, 200);
                        rd.setFont(new Font("Arial", 0, 11));
                        ftm = rd.getFontMetrics();
                        rd.drawString("Feature still under construction...", 86 - ftm.stringWidth("Feature still under construction...") / 2, 220);
                    }
                } else if (open == 452) {
                    rd.setColor(color2k(230, 230, 230));
                    rd.fillRoundRect(240, 170, 511, 90, 20, 20);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawRoundRect(240, 170, 511, 90, 20, 20);
                    rd.setColor(new Color(0, 0, 0));
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Failed to connect to server at this time, please exit and try again later.", 495 - ftm.stringWidth("Failed to connect to server at this time, please exit and try again later.") / 2, 200);
                    if (stringbutton("  Exit  ", 495, 230, 1, i_0_, i_1_, bool)) {
                        open = 450;
                        upo = false;
                        domon = false;
                    }
                }
                int[] is = { 193, 193, 298, 318 };
                int[] is_67_ = { 33, 13, 13, 33 };
                for (int i_68_ = 0; i_68_ < 4; i_68_++) {
                    if (tab == i_68_)
                        rd.setColor(color2k(255, 255, 255));
                    else
                        rd.setColor(color2k(200, 200, 200));
                    if (i_1_ >= 12 && i_1_ <= 32 && i_0_ > is[0] && i_0_ < is[3] && tab != i_68_) {
                        rd.setColor(color2k(227, 227, 227));
                        if (bool) {
                            tab = i_68_;
                            if (tab == 1 && proname.equals("")) {
                                proname = (xt).nickname;
                                loadedp = false;
                                onexitpro();
                            }
                        }
                    }
                    rd.fillPolygon(is, is_67_, 4);
                    for (int i_69_ = 0; i_69_ < 4; i_69_++)
                        is[i_69_] += 125;
                }
                rd.drawImage((xt).cnmc, 224, 15, null);
                rd.setColor(new Color(0, 0, 0));
                rd.drawLine(191, 34, 800, 34);
                rd.setColor(color2k(200, 200, 200));
                rd.fillRect(0, 0, 190, 28);
                rd.setColor(color2k(150, 150, 150));
                rd.drawLine(0, 25, 170, 25);
                rd.setColor(color2k(200, 200, 200));
                rd.fillRect(0, 438, 190, 12);
                rd.setColor(color2k(150, 150, 150));
                rd.drawLine(0, 440, 170, 440);
                rd.setColor(color2k(200, 200, 200));
                rd.fillRect(173, 28, 17, 410);
                rd.setColor(new Color(0, 0, 0));
                rd.drawLine(191, 0, 191, 450);
                if (i_0_ > 0 && i_0_ < 171 && i_1_ > 2 && i_1_ < 23) {
                    if (!onp) {
                        rd.setColor(color2k(220, 220, 220));
                        rd.fillRect(2, 2, 146, 21);
                    }
                    rd.setColor(color2k(255, 255, 255));
                    if (bool && overit == 0 && !onp) {
                        onp = true;
                        overit = 5;
                    }
                    if (overit < 0)
                        overit++;
                } else
                    rd.setColor(color2k(235, 235, 235));
                rd.fillRect(150, 2, 20, 20);
                rd.setColor(color2k(150, 150, 150));
                rd.drawRect(150, 2, 20, 20);
                rd.setColor(new Color(0, 0, 0));
                rd.drawLine(157, 10, 157, 11);
                rd.drawLine(158, 11, 158, 12);
                rd.drawLine(159, 12, 159, 13);
                rd.drawLine(160, 13, 160, 14);
                rd.drawLine(161, 12, 161, 13);
                rd.drawLine(162, 11, 162, 12);
                rd.drawLine(163, 10, 163, 11);
                if (ptab == 0)
                    rd.drawImage((xt).players, 7, 5, null);
                if (ptab == 1)
                    rd.drawImage((xt).myfr, 21, 4, null);
                if (ptab == 2)
                    rd.drawImage((xt).mycl, 34, 4, null);
                if (onp) {
                    rd.setColor(color2k(200, 200, 200));
                    rd.fillRect(0, 25, 170, 67);
                    rd.setColor(color2k(150, 150, 150));
                    rd.drawRect(0, 25, 170, 67);
                    if (i_0_ > 0 && i_0_ < 171 && i_1_ >= 26 && i_1_ < 48) {
                        rd.setColor(color2k(235, 235, 235));
                        rd.fillRect(1, 26, 169, 22);
                        if (bool)
                            ptab = 0;
                    }
                    if (i_0_ > 0 && i_0_ < 171 && i_1_ >= 48 && i_1_ < 70) {
                        rd.setColor(color2k(235, 235, 235));
                        rd.fillRect(1, 48, 169, 22);
                        if (bool)
                            ptab = 1;
                    }
                    if (i_0_ > 0 && i_0_ < 171 && i_1_ >= 70 && i_1_ < 92) {
                        rd.setColor(color2k(235, 235, 235));
                        rd.fillRect(1, 70, 169, 22);
                        if (bool)
                            ptab = 2;
                    }
                    rd.drawImage((xt).players, 7, 30, null);
                    rd.drawImage((xt).myfr, 21, 51, null);
                    rd.drawImage((xt).mycl, 34, 73, null);
                    if (bool && overit == 0) {
                        onp = false;
                        overit = -5;
                    }
                    if (overit > 0)
                        overit--;
                }
                if (mscro == 831 || i_16_ == 0) {
                    if (i_16_ == 0)
                        rd.setColor(color2k(205, 205, 205));
                    else
                        rd.setColor(color2k(215, 215, 215));
                    rd.fillRect(173, 28, 17, 17);
                } else {
                    rd.setColor(color2k(220, 220, 220));
                    rd.fill3DRect(173, 28, 17, 17, true);
                }
                if (i_16_ != 0)
                    rd.drawImage((xt).asu, 178, 34, null);
                if (mscro == 832 || i_16_ == 0) {
                    if (i_16_ == 0)
                        rd.setColor(color2k(205, 205, 205));
                    else
                        rd.setColor(color2k(215, 215, 215));
                    rd.fillRect(173, 421, 17, 17);
                } else {
                    rd.setColor(color2k(220, 220, 220));
                    rd.fill3DRect(173, 421, 17, 17, true);
                }
                if (i_16_ != 0)
                    rd.drawImage((xt).asd, 178, 428, null);
                if (i_16_ != 0) {
                    if (lspos != spos) {
                        rd.setColor(color2k(215, 215, 215));
                        rd.fillRect(173, 45 + spos, 17, 31);
                    } else {
                        if (mscro == 831)
                            rd.setColor(color2k(215, 215, 215));
                        rd.fill3DRect(173, 45 + spos, 17, 31, true);
                    }
                    rd.setColor(color2k(150, 150, 150));
                    rd.drawLine(178, 58 + spos, 184, 58 + spos);
                    rd.drawLine(178, 60 + spos, 184, 60 + spos);
                    rd.drawLine(178, 62 + spos, 184, 62 + spos);
                    if (mscro > 800 && lspos != spos)
                        lspos = spos;
                    if (bool) {
                        if (mscro == 825 && i_0_ > 173 && i_0_ < 190 && i_1_ > 45 + spos && i_1_ < spos + 76)
                            mscro = i_1_ - spos;
                        if (mscro == 825 && i_0_ > 171 && i_0_ < 192 && i_1_ > 26 && i_1_ < 47)
                            mscro = 831;
                        if (mscro == 825 && i_0_ > 171 && i_0_ < 192 && i_1_ > 419 && i_1_ < 440)
                            mscro = 832;
                        if (mscro == 825 && i_0_ > 173 && i_0_ < 190 && i_1_ > 45 && i_1_ < 421) {
                            mscro = 60;
                            spos = i_1_ - mscro;
                        }
                        int i_70_ = 2670 / i_16_;
                        if (i_70_ < 1)
                            i_70_ = 1;
                        if (mscro == 831) {
                            spos -= i_70_;
                            if (spos > 345)
                                spos = 345;
                            if (spos < 0)
                                spos = 0;
                            lspos = spos;
                        }
                        if (mscro == 832) {
                            spos += i_70_;
                            if (spos > 345)
                                spos = 345;
                            if (spos < 0)
                                spos = 0;
                            lspos = spos;
                        }
                        if (mscro < 800) {
                            spos = i_1_ - mscro;
                            if (spos > 345)
                                spos = 345;
                            if (spos < 0)
                                spos = 0;
                        }
                        if (mscro == 825)
                            mscro = 925;
                    } else if (mscro != 825)
                        mscro = 825;
                }
                if (i_11_ != curs) {
                    gs.setCursor(new Cursor(i_11_));
                    curs = i_11_;
                }
            } else {
                xt.drawWarning();
                if ((gs).cmsg.isShowing()) {
                    (gs).cmsg.hide();
                    gs.requestFocus();
                }
                if ((xt).warning > 220) {
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
                (xt).warning++;
            }
        }
        if (bool_2_) {
            if (!(gs).cmsg.isShowing()) {
                (gs).cmsg.show();
                (gs).cmsg.requestFocus();
                prereq = 2;
            }
            gs.movefield((gs).cmsg, 207, 414, 462, 22);
            if ((gs).cmsg.getText().equals("Type here...") && i_0_ > 197 && i_0_ < 679 && i_1_ > 404 && i_1_ < 446)
                (gs).cmsg.setText("");
            if ((gs).cmsg.getText().length() > 200) {
                (gs).cmsg.setText((gs).cmsg.getText().substring(0, 200));
                (gs).cmsg.select(200, 200);
            }
        }
        if (bool_3_) {
            if (!(gs).cmsg.isShowing()) {
                (gs).cmsg.show();
                (gs).cmsg.setText(sentance);
                (gs).cmsg.requestFocus();
            }
            gs.movefield((gs).cmsg, 275, 91, 440, 22);
            if (!sentance.equals((gs).cmsg.getText())) {
                sentchange = 1;
                rd.setFont(new Font("Tahoma", 1, 11));
                ftm = rd.getFontMetrics();
                if (ftm.stringWidth((gs).cmsg.getText()) > 800)
                    (gs).cmsg.setText(sentance);
                else
                    sentance = (gs).cmsg.getText();
            }
        }
        if (bool_4_) {
            if (!(gs).mmsg.isShowing()) {
                (gs).mmsg.show();
                (gs).mmsg.setText(" ");
                (gs).mmsg.requestFocus();
            }
            gs.movefield((gs).mmsg, 207, 389, 450, 50);
        } else if ((gs).mmsg.isShowing())
            (gs).mmsg.hide();
        if (prereq != 0) {
            if (prereq == 1)
                gs.requestFocus();
            prereq--;
        }
    }
    
    public void run() {
        try {
            socket = new Socket((lg).servers[0], 7061);
            din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dout = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception exception) {
            domon = false;
        }
        while (domon) {
            String string = "";
            String string_72_ = "";
            string = new StringBuilder().append("101|100|").append((xt).nickname).append(":").append((xt).nickey).append("|").toString();
            try {
                dout.println(string);
                string_72_ = din.readLine();
                if (string_72_ == null)
                    domon = false;
            } catch (Exception exception) {
                domon = false;
            }
            if (domon) {
                ntime = getLvalue(string_72_, 0);
                for (int i = 0; i < 3; i++) {
                    for (int i_73_ = 0; i_73_ < 5; i_73_++)
                        roomf[i][i_73_] = 0;
                }
                int i = 0;
                int i_74_ = 1;
                boolean bool = false;
                while (!bool) {
                    String string_75_ = getSvalue(string_72_, i_74_);
                    if (!string_75_.equals("")) {
                        int i_76_ = getvalue(string_72_, i_74_ + 1);
                        int i_77_ = getvalue(string_72_, i_74_ + 2);
                        if ((i_76_ == -1 || i_77_ == -1) && i < 900) {
                            pname[i] = string_75_;
                            proom[i] = i_76_;
                            pserver[i] = i_77_;
                            i++;
                        }
                    } else
                        bool = true;
                    i_74_ += 3;
                }
                i_74_ = 1;
                bool = false;
                while (!bool) {
                    String string_78_ = getSvalue(string_72_, i_74_);
                    if (!string_78_.equals("")) {
                        int i_79_ = getvalue(string_72_, i_74_ + 1);
                        int i_80_ = getvalue(string_72_, i_74_ + 2);
                        if (i_79_ >= 0 && i_79_ <= 4 && i_80_ >= 0 && i_80_ <= 2) {
                            roomf[i_80_][i_79_]++;
                            if (i < 900) {
                                pname[i] = string_78_;
                                proom[i] = i_79_;
                                pserver[i] = i_80_;
                                i++;
                            }
                        }
                    } else
                        bool = true;
                    i_74_ += 3;
                }
                npo = i;
            }
            if (sentchange == 2 && domon) {
                string = new StringBuilder().append("101|5|").append((gs).tnick.getText()).append("|").append((gs).tpass.getText()).append("|").append(sentance).append("|").toString();
                try {
                    dout.println(string);
                    string_72_ = din.readLine();
                } catch (Exception exception) {
                    /* empty */
                }
                sentchange = 0;
            }
            if (tab == 2 && domon) {
                if (!blockname.equals("")) {
                    for (int i = 0; i < nm; i++) {
                        if (mname[i].equals(blockname)) {
                            mtyp[i] = 3;
                            break;
                        }
                    }
                    try {
                        string = new StringBuilder().append("101|11|").append((gs).tnick.getText()).append("|").append((gs).tpass.getText()).append("|").append(blockname).append("|").toString();
                        dout.println(string);
                        string_72_ = din.readLine();
                    } catch (Exception exception) {
                        /* empty */
                    }
                    blockname = "";
                }
                if (!unblockname.equals("")) {
                    for (int i = 0; i < nm; i++) {
                        if (mname[i].equals(unblockname)) {
                            mtyp[i] = 0;
                            break;
                        }
                    }
                    try {
                        string = new StringBuilder().append("101|12|").append((gs).tnick.getText()).append("|").append((gs).tpass.getText()).append("|").append(unblockname).append("|").toString();
                        dout.println(string);
                        string_72_ = din.readLine();
                    } catch (Exception exception) {
                        /* empty */
                    }
                    unblockname = "";
                }
                try {
                    Socket socket = new Socket((lg).servers[0], 7061);
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    DataInputStream datainputstream = new DataInputStream(socket.getInputStream());
                    string = new StringBuilder().append("101|13|").append((xt).nickname).append("|").append((xt).nickey).append("|").append(loadmsgs).append("|").toString();
                    printwriter.println(string);
                    string_72_ = bufferedreader.readLine();
                    if (string_72_.startsWith("MSGS")) {
                        String string_81_ = "";
                        nm = 0;
                        boolean bool = false;
                        while (!bool && (string_81_ = datainputstream.readLine()) != null && nm < 200) {
                            if (!string_81_.equals("||XENDX||")) {
                                mname[nm] = getSvalue(string_81_, 0);
                                mtyp[nm] = getvalue(string_81_, 1);
                                mconvo[nm] = getSvalue(string_81_, 2);
                                msub[nm] = getSvalue(string_81_, 3);
                                mctime[nm] = getLvalue(string_81_, 4);
                                mtime[nm] = "";
                                nm++;
                            } else
                                bool = true;
                        }
                        loadmsgs = getvalue(string_72_, 1);
                    } else if (string_72_.equals("NOMSGS"))
                        loadmsgs = 0;
                    try {
                        socket.close();
                        datainputstream.close();
                        bufferedreader.close();
                        printwriter.close();
                    } catch (Exception exception) {
                        /* empty */
                    }
                } catch (Exception exception) {
                    loadmsgs = -2;
                }
                if (loadmsgs > 0) {
                    for (int i = 0; i < nm; i++) {
                        if (mctime[i] > 0L) {
                            try {
                                long l = ntime - mctime[i];
                                String string_85_ = "Received";
                                if (mtyp[i] == 2)
                                    string_85_ = "Sent";
                                if (l >= 1000L && l < 60000L)
                                    mtime[i] = new StringBuilder().append("").append(string_85_).append(" seconds ago").toString();
                                if (l >= 60000L && l < 3600000L) {
                                    int i_86_ = (int) (l / 60000L);
                                    String string_87_ = "s";
                                    if (i_86_ == 1)
                                        string_87_ = "";
                                    mtime[i] = new StringBuilder().append("").append(string_85_).append(" ").append(i_86_).append(" minute").append(string_87_).append(" ago").toString();
                                }
                                if (l >= 3600000L && l < 86400000L) {
                                    int i_88_ = (int) (l / 3600000L);
                                    String string_89_ = "s";
                                    if (i_88_ == 1)
                                        string_89_ = "";
                                    mtime[i] = new StringBuilder().append("").append(string_85_).append(" ").append(i_88_).append(" hour").append(string_89_).append(" ago").toString();
                                }
                                if (l >= 86400000L) {
                                    int i_90_ = (int) (l / 86400000L);
                                    String string_91_ = "s";
                                    if (i_90_ == 1)
                                        string_91_ = "";
                                    mtime[i] = new StringBuilder().append("").append(string_85_).append(" ").append(i_90_).append(" day").append(string_91_).append(" ago").toString();
                                }
                            } catch (Exception exception) {
                                mtime[i] = "";
                            }
                        } else
                            mtime[i] = "";
                    }
                }
                if (openc != 0) {
                    boolean bool = false;
                    int i = -1;
                    for (int i_92_ = 0; i_92_ < nm; i_92_++) {
                        if (mname[i_92_].equals(opname)) {
                            i = i_92_;
                            break;
                        }
                    }
                    if (i != -1 && readmsg != 3 && readmsg != 4 && readmsg != 5) {
                        if (!msub[i].equals(lastsub)) {
                            bool = true;
                            readmsg = 1;
                        } else
                            readmsg = 2;
                    } else {
                        lastsub = "";
                        if (readmsg == 1) {
                            readmsg = 0;
                            nml = 0;
                        }
                    }
                    if (bool) {
                        try {
                            Socket socket = new Socket((lg).servers[0], 7061);
                            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                            DataInputStream datainputstream = new DataInputStream(socket.getInputStream());
                            string = new StringBuilder().append("101|8|").append((xt).nickname).append("|").append((xt).nickey).append("|").append(mconvo[i]).append("").toString();
                            printwriter.println(string);
                            string_72_ = bufferedreader.readLine();
                            if (string_72_.equals("RECIVE")) {
                                String string_93_ = "";
                                boolean bool_94_ = false;
                                for (int i_95_ = 0; i_95_ < nml; i_95_++) {
                                    mline[i_95_] = null;
                                    mlinetyp[i_95_] = 0;
                                    mctimes[i_95_] = 0L;
                                    mtimes[i_95_] = null;
                                }
                                nml = 0;
                                (cd).acname = "";
                                (cd).action = 0;
                                (cd).onstage = "";
                                addstage = 0;
                                while (!bool_94_ && (string_93_ = datainputstream.readLine()) != null) {
                                    if (!string_93_.equals("||XENDX||")) {
                                        if (string_93_.startsWith("|")) {
                                            if (nml != 0) {
                                                mline[nml] = "";
                                                mlinetyp[nml] = 167;
                                                nml++;
                                            }
                                            String string_96_ = getSvalue(string_93_, 1);
                                            if (string_96_.toLowerCase().equals((xt).nickname.toLowerCase()))
                                                string_96_ = "You";
                                            mlinetyp[nml] = getvalue(string_93_, 2);
                                            int i_97_ = mlinetyp[nml];
                                            if (i_97_ == 0) {
                                                mline[nml] = new StringBuilder().append("").append(string_96_).append(" wrote:").toString();
                                                mctimes[nml] = getLvalue(string_93_, 3);
                                                mtimes[nml] = "";
                                                nml++;
                                            }
                                            if (i_97_ == 1) {
                                                mline[nml] = new StringBuilder().append("").append(string_96_).append(" shared a car:").toString();
                                                mctimes[nml] = getLvalue(string_93_, 3);
                                                mtimes[nml] = "";
                                                nml++;
                                                mline[nml] = getSvalue(string_93_, 4);
                                                mlinetyp[nml] = 10;
                                                nml++;
                                                mline[nml] = "";
                                                mlinetyp[nml] = 167;
                                                nml++;
                                            }
                                            if (i_97_ == 2) {
                                                mline[nml] = new StringBuilder().append("").append(string_96_).append(" shared a stage:").toString();
                                                mctimes[nml] = getLvalue(string_93_, 3);
                                                mtimes[nml] = "";
                                                nml++;
                                                mline[nml] = getSvalue(string_93_, 4);
                                                mlinetyp[nml] = 20;
                                                nml++;
                                                mline[nml] = "";
                                                mlinetyp[nml] = 167;
                                                nml++;
                                            }
                                        } else {
                                            mline[nml] = string_93_;
                                            try {
                                                rd.setFont(new Font("Tahoma", 0, 11));
                                                ftm = rd.getFontMetrics();
                                                int i_98_ = 0;
                                                String string_99_ = "";
                                                for (/**/; i_98_ < string_93_.length(); i_98_++) {
                                                    string_99_ = new StringBuilder().append(string_99_).append(string_93_.charAt(i_98_)).toString();
                                                    if (ftm.stringWidth(string_99_) > 540) {
                                                        if (string_99_.lastIndexOf(" ") != -1) {
                                                            mline[nml] = string_99_.substring(0, string_99_.lastIndexOf(" "));
                                                            string_99_ = string_99_.substring(string_99_.lastIndexOf(" ") + 1, string_99_.length());
                                                        } else {
                                                            mline[nml] = string_99_;
                                                            string_99_ = "";
                                                        }
                                                        mlinetyp[nml] = -1;
                                                        nml++;
                                                    }
                                                }
                                                mline[nml] = string_99_;
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                            mlinetyp[nml] = -1;
                                            nml++;
                                        }
                                    } else
                                        bool_94_ = true;
                                }
                                readmsg = 2;
                                lastsub = msub[i];
                                if (mtyp[i] == 1) {
                                    mtyp[i] = 0;
                                    try {
                                        dout.println(new StringBuilder().append("101|10|").append((xt).nickname).append("|").append(opname).append("|").toString());
                                        string_72_ = din.readLine();
                                    } catch (Exception exception) {
                                        /* empty */
                                    }
                                }
                                spos4 = 208;
                            } else
                                readmsg = 3;
                            try {
                                socket.close();
                                datainputstream.close();
                                bufferedreader.close();
                                printwriter.close();
                            } catch (Exception exception) {
                                /* empty */
                            }
                        } catch (Exception exception) {
                            readmsg = 4;
                        }
                    }
                    if (readmsg == 2) {
                        for (int i_103_ = 0; i_103_ < nml; i_103_++) {
                            if ((mlinetyp[i_103_] == 0 || mlinetyp[i_103_] == 1 || mlinetyp[i_103_] == 2) && mctimes[i_103_] > 0L) {
                                try {
                                    long l = ntime - mctimes[i_103_];
                                    if (l >= 1000L && l < 60000L)
                                        mtimes[i_103_] = "seconds ago";
                                    if (l >= 60000L && l < 3600000L) {
                                        int i_104_ = (int) (l / 60000L);
                                        String string_105_ = "s";
                                        if (i_104_ == 1)
                                            string_105_ = "";
                                        mtimes[i_103_] = new StringBuilder().append("").append(i_104_).append(" minute").append(string_105_).append(" ago").toString();
                                    }
                                    if (l >= 3600000L && l < 86400000L) {
                                        int i_106_ = (int) (l / 3600000L);
                                        String string_107_ = "s";
                                        if (i_106_ == 1)
                                            string_107_ = "";
                                        mtimes[i_103_] = new StringBuilder().append("").append(i_106_).append(" hour").append(string_107_).append(" ago").toString();
                                    }
                                    if (l >= 86400000L) {
                                        int i_108_ = (int) (l / 86400000L);
                                        String string_109_ = "s";
                                        if (i_108_ == 1)
                                            string_109_ = "";
                                        mtimes[i_103_] = new StringBuilder().append("").append(i_108_).append(" day").append(string_109_).append(" ago").toString();
                                    }
                                } catch (Exception exception) {
                                    mtimes[i_103_] = "";
                                }
                            } else
                                mtimes[i_103_] = "";
                        }
                    }
                }
                if (sendmsg == 2) {
                    (gs).mmsg.setText(" ");
                    sendmsg = 0;
                }
                if (openc == 10) {
                    if (loaditem == 1) {
                        int i = 0;
                        String[] strings = new String[20];
                        try {
                            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/cars/lists/").append((gs).tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                            url.openConnection().setConnectTimeout(2000);
                            String string_110_ = "";
                            DataInputStream datainputstream = new DataInputStream(url.openStream());
                            while ((string_110_ = datainputstream.readLine()) != null) {
                                string_110_ = new StringBuilder().append("").append(string_110_.trim()).toString();
                                if (string_110_.startsWith("mycars")) {
                                    boolean bool = true;
                                    while (bool && i < 20) {
                                        strings[i] = getfuncSvalue("mycars", string_110_, i);
                                        if (strings[i].equals(""))
                                            bool = false;
                                        else
                                            i++;
                                    }
                                }
                            }
                            datainputstream.close();
                        } catch (Exception exception) {
                            String string_111_ = new StringBuilder().append("").append(exception).toString();
                            if (string_111_.indexOf("FileNotFound") != -1)
                                i = 0;
                            else
                                i = -1;
                        }
                        if (i == -1) {
                            (gs).senditem.removeAll();
                            (gs).senditem.add(rd, "Failed to load your cars, please try again later.");
                            loaditem = 0;
                        }
                        if (i == 0) {
                            (gs).senditem.removeAll();
                            (gs).senditem.add(rd, "You have no added or published cars to load.");
                            loaditem = 0;
                        }
                        if (i > 0) {
                            String[] strings_112_ = new String[20];
                            int i_113_ = 0;
                            for (int i_114_ = 0; i_114_ < i; i_114_++) {
                                (gs).senditem.removeAll();
                                (gs).senditem.add(rd, new StringBuilder().append("Loading shareable cars,  ").append((int) ((float) i_114_ / (float) i * 100.0F)).append(" %").toString());
                                try {
                                    String string_115_ = new StringBuilder().append("http://multiplayer.needformadness.com/cars/").append(strings[i_114_]).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
                                    string_115_ = string_115_.replace(' ', '_');
                                    URL url = new URL(string_115_);
                                    url.openConnection().setConnectTimeout(2000);
                                    String string_116_ = "";
                                    DataInputStream datainputstream = new DataInputStream(url.openStream());
                                    while ((string_116_ = datainputstream.readLine()) != null) {
                                        string_116_ = new StringBuilder().append("").append(string_116_.trim()).toString();
                                        if (string_116_.startsWith("details")) {
                                            String string_117_ = getfuncSvalue("details", string_116_, 0);
                                            int i_118_ = getfuncvalue("details", string_116_, 1);
                                            if (i_118_ > 0 || string_117_.toLowerCase().equals((gs).tnick.getText().toLowerCase())) {
                                                strings_112_[i_113_] = strings[i_114_];
                                                i_113_++;
                                            }
                                        }
                                    }
                                    datainputstream.close();
                                } catch (Exception exception) {
                                    /* empty */
                                }
                            }
                            (gs).senditem.removeAll();
                            if (i_113_ > 0) {
                                for (int i_119_ = 0; i_119_ < i_113_; i_119_++)
                                    (gs).senditem.add(rd, strings_112_[i_119_]);
                                loaditem = 10;
                            } else {
                                (gs).senditem.add(rd, "You have no cars that can be shared.");
                                loaditem = 0;
                            }
                        }
                    }
                    if (loaditem == 2) {
                        int i = 0;
                        String[] strings = new String[20];
                        try {
                            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/tracks/lists/").append((gs).tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                            url.openConnection().setConnectTimeout(2000);
                            String string_120_ = "";
                            DataInputStream datainputstream = new DataInputStream(url.openStream());
                            while ((string_120_ = datainputstream.readLine()) != null) {
                                string_120_ = new StringBuilder().append("").append(string_120_.trim()).toString();
                                if (string_120_.startsWith("mystages")) {
                                    boolean bool = true;
                                    while (bool && i < 20) {
                                        strings[i] = getfuncSvalue("mystages", string_120_, i);
                                        if (strings[i].equals(""))
                                            bool = false;
                                        else
                                            i++;
                                    }
                                }
                            }
                            datainputstream.close();
                        } catch (Exception exception) {
                            String string_121_ = new StringBuilder().append("").append(exception).toString();
                            if (string_121_.indexOf("FileNotFound") != -1)
                                i = 0;
                            else
                                i = -1;
                        }
                        if (i == -1) {
                            (gs).senditem.removeAll();
                            (gs).senditem.add(rd, "Failed to load your stages, please try again later.");
                            loaditem = 0;
                        }
                        if (i == 0) {
                            (gs).senditem.removeAll();
                            (gs).senditem.add(rd, "You have no added or published stages to load.");
                            loaditem = 0;
                        }
                        if (i > 0) {
                            String[] strings_122_ = new String[20];
                            int i_123_ = 0;
                            for (int i_124_ = 0; i_124_ < i; i_124_++) {
                                (gs).senditem.removeAll();
                                (gs).senditem.add(rd, new StringBuilder().append("Loading shareable stages,  ").append((int) ((float) i_124_ / (float) i * 100.0F)).append(" %").toString());
                                try {
                                    String string_125_ = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/").append(strings[i_124_]).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
                                    string_125_ = string_125_.replace(' ', '_');
                                    URL url = new URL(string_125_);
                                    url.openConnection().setConnectTimeout(2000);
                                    String string_126_ = "";
                                    DataInputStream datainputstream = new DataInputStream(url.openStream());
                                    while ((string_126_ = datainputstream.readLine()) != null) {
                                        string_126_ = new StringBuilder().append("").append(string_126_.trim()).toString();
                                        if (string_126_.startsWith("details")) {
                                            String string_127_ = getfuncSvalue("details", string_126_, 0);
                                            int i_128_ = getfuncvalue("details", string_126_, 1);
                                            if (i_128_ > 0 || string_127_.toLowerCase().equals((gs).tnick.getText().toLowerCase())) {
                                                strings_122_[i_123_] = strings[i_124_];
                                                i_123_++;
                                            }
                                        }
                                    }
                                    datainputstream.close();
                                } catch (Exception exception) {
                                    /* empty */
                                }
                            }
                            (gs).senditem.removeAll();
                            if (i_123_ > 0) {
                                for (int i_129_ = 0; i_129_ < i_123_; i_129_++)
                                    (gs).senditem.add(rd, strings_122_[i_129_]);
                                loaditem = 20;
                            } else {
                                (gs).senditem.add(rd, "You have no stages that can be shared.");
                                loaditem = 0;
                            }
                        }
                    }
                    if (sendmsg == 1) {
                        try {
                            String string_130_ = "#nada#";
                            for (int i = 0; i < nm; i++) {
                                if (mname[i].equals(opname)) {
                                    string_130_ = mconvo[i];
                                    break;
                                }
                            }
                            string = new StringBuilder().append("101|9|").append((xt).nickname).append("|").append((xt).nickey).append("|").append(opname).append("|").append(string_130_).append("|").append((gs).sendtyp.getSelectedIndex()).append("|").toString();
                            if ((gs).sendtyp.getSelectedIndex() == 0) {
                                String string_131_ = (gs).mmsg.getText().replace("|", ":");
                                string_131_ = string_131_.replaceAll("[\\t\\n\\r]", "|");
                                String string_132_ = "";
                                int i = 0;
                                int i_133_ = 0;
                                for (/**/; i < string_131_.length(); i++) {
                                    String string_134_ = new StringBuilder().append("").append(string_131_.charAt(i)).toString();
                                    if (string_134_.equals("|"))
                                        i_133_++;
                                    else
                                        i_133_ = 0;
                                    if (i_133_ <= 1)
                                        string_132_ = new StringBuilder().append(string_132_).append(string_134_).toString();
                                }
                                string = new StringBuilder().append(string).append("").append(string_132_).append("||").toString();
                            }
                            if ((gs).sendtyp.getSelectedIndex() == 1 || (gs).sendtyp.getSelectedIndex() == 2)
                                string = new StringBuilder().append(string).append("").append((gs).senditem.getSelectedItem()).append("|").toString();
                            dout.println(string);
                            string_72_ = din.readLine();
                            if (string_72_.equals("OK"))
                                sendmsg = 2;
                            else {
                                readmsg = 5;
                                sendmsg = 0;
                            }
                        } catch (Exception exception) {
                            readmsg = 5;
                            sendmsg = 0;
                        }
                    }
                }
            }
            if (tab == 0 && domon) {
                string = new StringBuilder().append("101|101|").append(updatec).append("|").toString();
                if (updatec <= -11) {
                    for (int i = 0; i < -updatec - 10; i++)
                        string = new StringBuilder().append(string).append("").append(cnames[20 - i]).append("|").append(sentn[20 - i]).append("|").toString();
                    updatec = -2;
                }
                try {
                    dout.println(string);
                    string_72_ = din.readLine();
                    if (string_72_ == null)
                        domon = false;
                } catch (Exception exception) {
                    domon = false;
                }
                if (domon) {
                    int i = getvalue(string_72_, 0);
                    if (updatec != i && updatec >= -2) {
                        for (int i_135_ = 0; i_135_ < 21; i_135_++) {
                            cnames[i_135_] = getSvalue(string_72_, 1 + i_135_ * 3);
                            sentn[i_135_] = getSvalue(string_72_, 2 + i_135_ * 3);
                            nctime[i_135_] = getLvalue(string_72_, 3 + i_135_ * 3);
                        }
                        updatec = i;
                    }
                    for (int i_136_ = 0; i_136_ < 21; i_136_++) {
                        if (nctime[i_136_] > 0L) {
                            long l = ntime - nctime[i_136_];
                            if (l < 1000L)
                                ctime[i_136_] = "- just now";
                            if (l >= 1000L && l < 60000L)
                                ctime[i_136_] = "- seconds ago";
                            if (l >= 60000L && l < 3600000L) {
                                int i_137_ = (int) (l / 60000L);
                                String string_138_ = "s";
                                if (i_137_ == 1)
                                    string_138_ = "";
                                ctime[i_136_] = new StringBuilder().append("- ").append(i_137_).append(" minute").append(string_138_).append(" ago").toString();
                            }
                            if (l >= 3600000L && l < 86400000L) {
                                int i_139_ = (int) (l / 3600000L);
                                String string_140_ = "s";
                                if (i_139_ == 1)
                                    string_140_ = "";
                                ctime[i_136_] = new StringBuilder().append("- ").append(i_139_).append(" hour").append(string_140_).append(" ago").toString();
                            }
                            if (l >= 86400000L) {
                                int i_141_ = (int) (l / 86400000L);
                                String string_142_ = "s";
                                if (i_141_ == 1)
                                    string_142_ = "";
                                ctime[i_136_] = new StringBuilder().append("- ").append(i_141_).append(" day").append(string_142_).append(" ago").toString();
                            }
                        } else
                            ctime[i_136_] = "";
                    }
                }
            }
            if (tab == 1) {
                if (upload == 5) {
                    upload = 0;
                    loadedp = false;
                    edit = 0;
                    refresh = true;
                }
                if (!loadedp) {
                    if (!refresh) {
                        loadproinfo();
                        trunsent();
                    }
                    logopng();
                    clanlogopng();
                    avatarpng();
                    refresh = false;
                    loadedp = true;
                }
            }
            if (upload != 0) {
                if (filename.toLowerCase().endsWith(".gif") || filename.toLowerCase().endsWith(".jpg") || filename.toLowerCase().endsWith(".jpeg") || filename.toLowerCase().endsWith(".png")) {
                    File file = new File(filename);
                    if (file.exists()) {
                        int i = (int) file.length();
                        if (i < 1048576) {
                            if (upload != 0) {
                                upload = 2;
                                try {
                                    int i_143_ = 2;
                                    if (edit == 2)
                                        i_143_ = 3;
                                    string = new StringBuilder().append("101|").append(i_143_).append("|").append((gs).tnick.getText()).append("|").append((gs).tpass.getText()).append("|").append(i).append("|").toString();
                                    dout.println(string);
                                    string_72_ = din.readLine();
                                    if (string_72_.equals("OK")) {
                                        FileInputStream fileinputstream = new FileInputStream(file);
                                        byte[] is = new byte[i];
                                        fileinputstream.read(is);
                                        fileinputstream.close();
                                        DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());
                                        if (upload != 0)
                                            upload = 3;
                                        perc = 0;
                                        int i_144_ = 0;
                                        while (i_144_ < i && upload != 0) {
                                            int i_145_ = 10240;
                                            if (i_144_ + i_145_ > i)
                                                i_145_ = i - i_144_;
                                            dataoutputstream.write(is, i_144_, i_145_);
                                            i_144_ += i_145_;
                                            perc = (int) ((float) i_144_ / (float) i * 100.0F);
                                        }
                                        if (upload != 0) {
                                            string_72_ = din.readLine();
                                            if (string_72_.equals("CR"))
                                                upload = 4;
                                            else {
                                                msg = "Failed to create image online, server error!";
                                                flko = 45;
                                                upload = 0;
                                            }
                                            string_72_ = din.readLine();
                                            if (string_72_.equals("OK"))
                                                upload = 5;
                                        } else {
                                            try {
                                                socket.close();
                                                socket = null;
                                                din.close();
                                                din = null;
                                                dout.close();
                                                dout = null;
                                                connector = null;
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                            try {
                                                socket = new Socket((lg).servers[0], 7061);
                                                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                                dout = new PrintWriter(socket.getOutputStream(), true);
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                        }
                                    } else {
                                        msg = "Failed to authenticate to start an uploading connection!";
                                        flko = 45;
                                        upload = 0;
                                    }
                                } catch (Exception exception) {
                                    msg = "Failed to upload image, unknown error!";
                                    flko = 45;
                                    upload = 0;
                                    try {
                                        socket.close();
                                        socket = null;
                                        din.close();
                                        din = null;
                                        dout.close();
                                        dout = null;
                                        connector = null;
                                    } catch (Exception exception_146_) {
                                        /* empty */
                                    }
                                    try {
                                        socket = new Socket((lg).servers[0], 7061);
                                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                        dout = new PrintWriter(socket.getOutputStream(), true);
                                    } catch (Exception exception_147_) {
                                        /* empty */
                                    }
                                }
                            }
                        } else {
                            msg = "Uploaded image must be less than 1MB in size!";
                            flko = 45;
                            upload = 0;
                        }
                    } else {
                        msg = "The file chosen is invalid or does not exist!";
                        flko = 45;
                        upload = 0;
                    }
                } else {
                    msg = "Uploaded image must be JPEG, GIF or PNG!";
                    flko = 45;
                    upload = 0;
                }
            }
            if (uploadt == 5) {
                uploadt = 0;
                msg = "";
            }
            if (uploadt != 0) {
                File file = new File(filename);
                if (file.exists()) {
                    int i = (int) file.length();
                    if (i < 256000) {
                        (xt).strack = new RadicalMod(filename, true);
                        if (((xt).strack).loaded == 2) {
                            trackvol = (int) (220.0F / ((float) ((xt).strack).rvol / 3750.0F));
                            (xt).strack.unload();
                            if (uploadt != 0) {
                                uploadt = 2;
                                try {
                                    string = new StringBuilder().append("101|4|").append((gs).tnick.getText()).append("|").append((gs).tpass.getText()).append("|").append(trackname).append("|").append(trackvol).append("|").append(i).append("|").toString();
                                    dout.println(string);
                                    string_72_ = din.readLine();
                                    if (string_72_.equals("OK")) {
                                        string_72_ = din.readLine();
                                        if (uploadt != 0) {
                                            if (string_72_.equals("UPLOAD")) {
                                                uploadt = 3;
                                                FileInputStream fileinputstream = new FileInputStream(file);
                                                byte[] is = new byte[i];
                                                fileinputstream.read(is);
                                                fileinputstream.close();
                                                DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());
                                                dataoutputstream.write(is, 0, i);
                                                uploadt = 4;
                                                string_72_ = din.readLine();
                                            }
                                            if (string_72_.equals("FOUND")) {
                                                uploadt = 4;
                                                string_72_ = din.readLine();
                                            }
                                            if (string_72_.equals("OK")) {
                                                themesong = trackname;
                                                uploadt = 5;
                                            } else if (string_72_.equals("EXIST")) {
                                                msg = "Another track with the same name already exists, please rename you file!";
                                                flko = 45;
                                                uploadt = 0;
                                            } else {
                                                msg = "Failed to add MOD Track to your profile, unknown error!";
                                                flko = 45;
                                                uploadt = 0;
                                            }
                                        } else {
                                            try {
                                                socket.close();
                                                socket = null;
                                                din.close();
                                                din = null;
                                                dout.close();
                                                dout = null;
                                                connector = null;
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                            try {
                                                socket = new Socket((lg).servers[0], 7061);
                                                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                                dout = new PrintWriter(socket.getOutputStream(), true);
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                        }
                                    } else {
                                        msg = "Failed to authenticate to start an uploading connection!";
                                        flko = 45;
                                        uploadt = 0;
                                    }
                                } catch (Exception exception) {
                                    msg = "Failed to upload track, unknown error!";
                                    flko = 45;
                                    uploadt = 0;
                                    try {
                                        socket.close();
                                        socket = null;
                                        din.close();
                                        din = null;
                                        dout.close();
                                        dout = null;
                                        connector = null;
                                    } catch (Exception exception_148_) {
                                        /* empty */
                                    }
                                    try {
                                        socket = new Socket((lg).servers[0], 7061);
                                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                        dout = new PrintWriter(socket.getOutputStream(), true);
                                    } catch (Exception exception_149_) {
                                        /* empty */
                                    }
                                }
                            }
                        } else {
                            (xt).strack.unload();
                            msg = "The file choosen is not a valid MOD Track!";
                            flko = 45;
                            uploadt = 0;
                        }
                    } else {
                        msg = "Uploaded file must be less than 250KB in size!";
                        flko = 45;
                        uploadt = 0;
                    }
                } else {
                    msg = "The file chosen is invalid or does not exist!";
                    flko = 45;
                    uploadt = 0;
                }
            }
            if (playt == 1) {
                (xt).strack = new RadicalMod(themesong, trackvol, 8000, 125, false, true);
                (xt).strack.play();
                playt = 2;
            }
            domelogos();
            try {
                if (connector != null) {
                    /* empty */
                }
                Thread.sleep(600L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        onexit();
        try {
            socket.close();
            socket = null;
            din.close();
            din = null;
            dout.close();
            dout = null;
            connector = null;
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void onexit() {
        onexitpro();
        gs.hidefields();
        (cd).acname = "";
        (cd).action = 0;
    }
    
    public void onexitpro() {
        edit = 0;
        upload = 0;
        uploadt = 0;
        if (playt == 2) {
            (xt).strack.unload();
            playt = 0;
        }
    }
    
    public void stopallnow() {
        if (connector != null) {
            connector.stop();
            connector = null;
        }
        try {
            socket.close();
            socket = null;
            din.close();
            din = null;
            dout.close();
            dout = null;
            connector = null;
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void trunsent() {
        for (int i = 0; i < 3; i++)
            aboutxt[i] = "";
        if (!sentance.equals("")) {
            rd.setFont(new Font("Tahoma", 1, 11));
            ftm = rd.getFontMetrics();
            int i = 0;
            int i_150_ = 0;
            int i_151_ = 0;
            int i_152_ = 0;
            boolean bool = false;
            for (/**/; i_150_ < sentance.length(); i_150_++) {
                String string = new StringBuilder().append("").append(sentance.charAt(i_150_)).toString();
                if (string.equals(" "))
                    i_151_ = i_150_;
                if (i < 3) {
                    StringBuilder stringbuilder = new StringBuilder();
                    String[] strings = aboutxt;
                    int i_153_ = i;
                    strings[i_153_] = stringbuilder.append(strings[i_153_]).append(string).toString();
                    if (ftm.stringWidth(aboutxt[i]) > 276) {
                        if (i_151_ != i_152_) {
                            aboutxt[i] = sentance.substring(i_152_, i_151_);
                            i_150_ = i_151_;
                            i_152_ = i_150_;
                        } else if (i == 2)
                            bool = true;
                        i++;
                    }
                } else {
                    if (bool)
                        aboutxt[2] = aboutxt[2].substring(0, aboutxt[2].length() - 3);
                    StringBuilder stringbuilder = new StringBuilder();
                    String[] strings = aboutxt;
                    int i_154_ = 2;
                    strings[i_154_] = stringbuilder.append(strings[i_154_]).append("...").toString();
                    i_150_ = sentance.length();
                }
            }
        }
        nab = 0;
        for (int i = 0; i < 3 && !aboutxt[i].equals(""); i++) {
            aboutxt[i] = aboutxt[i].trim();
            nab++;
        }
    }
    
    public void roomlogos(String[] strings, int i) {
        for (int i_155_ = 0; i_155_ < 2; i_155_++) {
            boolean bool = true;
            String string = "";
            for (int i_156_ = 0; i_156_ < i; i_156_++) {
                bool = false;
                for (int i_157_ = 0; i_157_ < nlg; i_157_++) {
                    if (strings[i_156_].toLowerCase().equals(logos[i_157_].toLowerCase())) {
                        bool = true;
                        break;
                    }
                }
                if (!bool) {
                    string = strings[i_156_].toLowerCase();
                    break;
                }
            }
            if (bool)
                break;
            logos[nlg] = string;
            logon[nlg] = false;
            try {
                URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(logos[nlg]).append("/logo.png").toString());
                url.openConnection().setConnectTimeout(2000);
                String string_158_ = url.openConnection().getContentType();
                if (string_158_.equals("image/png")) {
                    logoi[nlg] = Toolkit.getDefaultToolkit().createImage(url);
                    mt.addImage(logoi[nlg], nlg);
                    logon[nlg] = true;
                    fun++;
                    if (fun == 12)
                        fun = 1;
                }
            } catch (Exception exception) {
                /* empty */
            }
            nlg++;
            if (nlg == 200)
                nlg = 0;
        }
    }
    
    public void domelogos() {
        for (int i = 0; i < 5; i++) {
            boolean bool = true;
            String string = "";
            for (int i_159_ = 0; i_159_ < nm; i_159_++) {
                bool = false;
                for (int i_160_ = 0; i_160_ < nlg; i_160_++) {
                    if (mname[i_159_].toLowerCase().equals(logos[i_160_].toLowerCase())) {
                        bool = true;
                        break;
                    }
                }
                if (!bool) {
                    string = mname[i_159_].toLowerCase();
                    break;
                }
            }
            if (bool) {
                for (int i_161_ = 0; i_161_ < npo; i_161_++) {
                    bool = false;
                    for (int i_162_ = 0; i_162_ < nlg; i_162_++) {
                        if (pname[i_161_].toLowerCase().equals(logos[i_162_].toLowerCase())) {
                            bool = true;
                            break;
                        }
                    }
                    if (!bool) {
                        string = pname[i_161_].toLowerCase();
                        break;
                    }
                }
            }
            if (bool)
                break;
            logos[nlg] = string;
            logon[nlg] = false;
            try {
                URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(logos[nlg]).append("/logo.png").toString());
                url.openConnection().setConnectTimeout(2000);
                String string_163_ = url.openConnection().getContentType();
                if (string_163_.equals("image/png")) {
                    logoi[nlg] = Toolkit.getDefaultToolkit().createImage(url);
                    mt.addImage(logoi[nlg], nlg);
                    logon[nlg] = true;
                    fun++;
                    if (fun == 12)
                        fun = 1;
                }
            } catch (Exception exception) {
                /* empty */
            }
            nlg++;
            if (nlg == 200)
                nlg = 0;
        }
    }
    
    public boolean drawl(String string, int i, int i_164_, boolean bool) {
        boolean bool_165_ = false;
        int i_166_ = -1;
        for (int i_167_ = 0; i_167_ < nlg; i_167_++) {
            if (string.toLowerCase().equals(logos[i_167_].toLowerCase())) {
                i_166_ = i_167_;
                break;
            }
        }
        if (i_166_ != -1 && logon[i_166_]) {
            if (!bool)
                rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
            rd.drawImage(logoi[i_166_], i, i_164_, null);
            bool_165_ = mt.checkID(i_166_);
            if (!bool)
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        }
        return bool_165_;
    }
    
    public void logopng() {
        int i = -1;
        for (int i_168_ = 0; i_168_ < nlg; i_168_++) {
            if (proname.toLowerCase().equals(logos[i_168_].toLowerCase())) {
                i = i_168_;
                break;
            }
        }
        if (i == -1) {
            i = nlg;
            nlg++;
            if (nlg == 200)
                nlg = 0;
        }
        logos[i] = proname.toLowerCase();
        try {
            String string = "";
            if (refresh)
                string = new StringBuilder().append("?req=").append((int) (Math.random() * 1000.0)).append("").toString();
            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(proname).append("/logo.png").append(string).append("").toString());
            url.openConnection().setConnectTimeout(2000);
            String string_169_ = url.openConnection().getContentType();
            if (string_169_.equals("image/png")) {
                logoi[i] = Toolkit.getDefaultToolkit().createImage(url);
                mt.addImage(logoi[i], i);
                logon[i] = true;
            } else
                logon[i] = false;
        } catch (Exception exception) {
            /* empty */
        }
        logol = logon[i];
    }
    
    public void avatarpng() {
        avatarl = false;
        String string = "";
        if (refresh)
            string = new StringBuilder().append("?req=").append((int) (Math.random() * 1000.0)).append("").toString();
        try {
            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(proname).append("/avatar.png").append(string).append("").toString());
            url.openConnection().setConnectTimeout(2000);
            String string_170_ = url.openConnection().getContentType();
            if (string_170_.equals("image/png")) {
                avatar = Toolkit.getDefaultToolkit().createImage(url);
                avatarl = true;
            }
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void clanlogopng() {
        clanlogol = false;
    }
    
    public void loadproinfo() {
        racing = 0;
        wasting = 0;
        themesong = "";
        trackvol = 0;
        sentance = "";
        try {
            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(proname).append("/info.txt?req=").append((int) (Math.random() * 1000.0)).append("").toString());
            url.openConnection().setConnectTimeout(2000);
            String string = url.openConnection().getContentType();
            if (string.equals("text/plain")) {
                DataInputStream datainputstream = new DataInputStream(url.openStream());
                String string_171_ = "";
                for (int i = 0; (string_171_ = datainputstream.readLine()) != null && i < 9; i++) {
                    string_171_ = string_171_.trim();
                    if (i == 0)
                        themesong = string_171_;
                    if (i == 1) {
                        int i_172_;
                        try {
                            i_172_ = Integer.valueOf(string_171_).intValue();
                        } catch (Exception exception) {
                            i_172_ = 0;
                        }
                        trackvol = i_172_;
                    }
                    if (i == 2) {
                        int i_173_;
                        try {
                            i_173_ = Integer.valueOf(string_171_).intValue();
                        } catch (Exception exception) {
                            i_173_ = 0;
                        }
                        racing = i_173_;
                    }
                    if (i == 3) {
                        int i_174_;
                        try {
                            i_174_ = Integer.valueOf(string_171_).intValue();
                        } catch (Exception exception) {
                            i_174_ = 0;
                        }
                        wasting = i_174_;
                    }
                    if (i == 8)
                        sentance = string_171_;
                }
                datainputstream.close();
            }
        } catch (Exception exception) {
            sentance = "Failed to load profile info, server error!";
        }
    }
    
    public boolean drawbutton(Image image, int i, int i_175_, int i_176_, int i_177_, boolean bool) {
        boolean bool_178_ = false;
        boolean bool_179_ = false;
        int i_180_ = image.getWidth(ob);
        if (Math.abs(i_176_ - i) < i_180_ / 2 + 12 && Math.abs(i_177_ - i_175_) < 14 && bool)
            bool_179_ = true;
        if (Math.abs(i_176_ - i) < i_180_ / 2 + 12 && Math.abs(i_177_ - i_175_) < 14 && (gs).mouses <= -1) {
            bool_178_ = true;
            (gs).mouses = 0;
        }
        if (!bool_179_) {
            rd.drawImage(image, i - i_180_ / 2, i_175_ - image.getHeight(ob) / 2, null);
            rd.drawImage((xt).bols, i - i_180_ / 2 - 15, i_175_ - 13, null);
            rd.drawImage((xt).bors, i + i_180_ / 2 + 9, i_175_ - 13, null);
            rd.drawImage((xt).bot, i - i_180_ / 2 - 9, i_175_ - 13, i_180_ + 18, 3, null);
            rd.drawImage((xt).bob, i - i_180_ / 2 - 9, i_175_ + 10, i_180_ + 18, 3, null);
        } else {
            rd.drawImage(image, i - i_180_ / 2 + 1, i_175_ - image.getHeight(ob) / 2 + 1, null);
            rd.drawImage((xt).bolps, i - i_180_ / 2 - 15, i_175_ - 13, null);
            rd.drawImage((xt).borps, i + i_180_ / 2 + 9, i_175_ - 13, null);
            rd.drawImage((xt).bob, i - i_180_ / 2 - 9, i_175_ - 13, i_180_ + 18, 3, null);
            rd.drawImage((xt).bot, i - i_180_ / 2 - 9, i_175_ + 10, i_180_ + 18, 3, null);
        }
        return bool_178_;
    }
    
    public boolean stringbutton(String string, int i, int i_181_, int i_182_, int i_183_, int i_184_, boolean bool) {
        boolean bool_185_ = false;
        boolean bool_186_ = false;
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        int i_187_ = ftm.stringWidth(string);
        if (Math.abs(i_183_ - i) < i_187_ / 2 + 12 && Math.abs(i_184_ - i_181_) < 14 && bool)
            bool_186_ = true;
        if (Math.abs(i_183_ - i) < i_187_ / 2 + 12 && Math.abs(i_184_ - i_181_) < 14 && (gs).mouses <= -1) {
            bool_185_ = true;
            (gs).mouses = 0;
        }
        if (!bool_186_) {
            rd.setColor(colorb2k(220, 220, 220));
            rd.fillRect(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i_187_ + 20, 25 - i_182_ * 2);
            rd.setColor(colorb2k(240, 240, 240));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i + i_187_ / 2 + 10, i_181_ - (17 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (18 - i_182_), i + i_187_ / 2 + 10, i_181_ - (18 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 9, i_181_ - (19 - i_182_), i + i_187_ / 2 + 9, i_181_ - (19 - i_182_));
            rd.setColor(colorb2k(200, 200, 200));
            rd.drawLine(i + i_187_ / 2 + 10, i_181_ - (17 - i_182_), i + i_187_ / 2 + 10, i_181_ + (7 - i_182_));
            rd.drawLine(i + i_187_ / 2 + 11, i_181_ - (17 - i_182_), i + i_187_ / 2 + 11, i_181_ + (7 - i_182_));
            rd.drawLine(i + i_187_ / 2 + 12, i_181_ - (16 - i_182_), i + i_187_ / 2 + 12, i_181_ + (6 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ + (7 - i_182_), i + i_187_ / 2 + 10, i_181_ + (7 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ + (8 - i_182_), i + i_187_ / 2 + 10, i_181_ + (8 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 9, i_181_ + (9 - i_182_), i + i_187_ / 2 + 9, i_181_ + (9 - i_182_));
            rd.setColor(colorb2k(240, 240, 240));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i - i_187_ / 2 - 10, i_181_ + (7 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 11, i_181_ - (17 - i_182_), i - i_187_ / 2 - 11, i_181_ + (7 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 12, i_181_ - (16 - i_182_), i - i_187_ / 2 - 12, i_181_ + (6 - i_182_));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - i_187_ / 2, i_181_);
        } else {
            rd.setColor(colorb2k(210, 210, 210));
            rd.fillRect(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i_187_ + 20, 25 - i_182_ * 2);
            rd.setColor(colorb2k(200, 200, 200));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i + i_187_ / 2 + 10, i_181_ - (17 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (18 - i_182_), i + i_187_ / 2 + 10, i_181_ - (18 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 9, i_181_ - (19 - i_182_), i + i_187_ / 2 + 9, i_181_ - (19 - i_182_));
            rd.drawLine(i + i_187_ / 2 + 10, i_181_ - (17 - i_182_), i + i_187_ / 2 + 10, i_181_ + (7 - i_182_));
            rd.drawLine(i + i_187_ / 2 + 11, i_181_ - (17 - i_182_), i + i_187_ / 2 + 11, i_181_ + (7 - i_182_));
            rd.drawLine(i + i_187_ / 2 + 12, i_181_ - (16 - i_182_), i + i_187_ / 2 + 12, i_181_ + (6 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ + (7 - i_182_), i + i_187_ / 2 + 10, i_181_ + (7 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ + (8 - i_182_), i + i_187_ / 2 + 10, i_181_ + (8 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 9, i_181_ + (9 - i_182_), i + i_187_ / 2 + 9, i_181_ + (9 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i - i_187_ / 2 - 10, i_181_ + (7 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 11, i_181_ - (17 - i_182_), i - i_187_ / 2 - 11, i_181_ + (7 - i_182_));
            rd.drawLine(i - i_187_ / 2 - 12, i_181_ - (16 - i_182_), i - i_187_ / 2 - 12, i_181_ + (6 - i_182_));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - i_187_ / 2 + 1, i_181_);
        }
        return bool_185_;
    }
    
    public Color color2k(int i, int i_188_, int i_189_) {
        Color color = new Color(i, i_188_, i_189_);
        float[] fs = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
        fs[0] = 0.14F;
        fs[1] = 0.35F;
        return Color.getHSBColor(fs[0], fs[1], fs[2]);
    }
    
    public Color colorb2k(int i, int i_190_, int i_191_) {
        Color color = new Color(i, i_190_, i_191_);
        float[] fs = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
        fs[0] = 0.13F;
        fs[1] = 0.35F;
        return Color.getHSBColor(fs[0], fs[1], fs[2]);
    }
    
    public int getvalue(String string, int i) {
        int i_192_ = -1;
        try {
            int i_193_ = 0;
            int i_194_ = 0;
            int i_195_ = 0;
            String string_196_ = "";
            String string_197_ = "";
            for (/**/; i_193_ < string.length() && i_195_ != 2; i_193_++) {
                string_196_ = new StringBuilder().append("").append(string.charAt(i_193_)).toString();
                if (string_196_.equals("|")) {
                    i_194_++;
                    if (i_195_ == 1 || i_194_ > i)
                        i_195_ = 2;
                } else if (i_194_ == i) {
                    string_197_ = new StringBuilder().append(string_197_).append(string_196_).toString();
                    i_195_ = 1;
                }
            }
            if (string_197_.equals(""))
                string_197_ = "-1";
            i_192_ = Integer.valueOf(string_197_).intValue();
        } catch (Exception exception) {
            /* empty */
        }
        return i_192_;
    }
    
    public String getSvalue(String string, int i) {
        String string_198_ = "";
        try {
            int i_199_ = 0;
            int i_200_ = 0;
            int i_201_ = 0;
            String string_202_ = "";
            String string_203_ = "";
            for (/**/; i_199_ < string.length() && i_201_ != 2; i_199_++) {
                string_202_ = new StringBuilder().append("").append(string.charAt(i_199_)).toString();
                if (string_202_.equals("|")) {
                    i_200_++;
                    if (i_201_ == 1 || i_200_ > i)
                        i_201_ = 2;
                } else if (i_200_ == i) {
                    string_203_ = new StringBuilder().append(string_203_).append(string_202_).toString();
                    i_201_ = 1;
                }
            }
            string_198_ = string_203_;
        } catch (Exception exception) {
            /* empty */
        }
        return string_198_;
    }
    
    public long getLvalue(String string, int i) {
        long l = -1L;
        try {
            int i_204_ = 0;
            int i_205_ = 0;
            int i_206_ = 0;
            String string_207_ = "";
            String string_208_ = "";
            for (/**/; i_204_ < string.length() && i_206_ != 2; i_204_++) {
                string_207_ = new StringBuilder().append("").append(string.charAt(i_204_)).toString();
                if (string_207_.equals("|")) {
                    i_205_++;
                    if (i_206_ == 1 || i_205_ > i)
                        i_206_ = 2;
                } else if (i_205_ == i) {
                    string_208_ = new StringBuilder().append(string_208_).append(string_207_).toString();
                    i_206_ = 1;
                }
            }
            if (string_208_.equals(""))
                string_208_ = "-1";
            l = Long.valueOf(string_208_).longValue();
        } catch (Exception exception) {
            /* empty */
        }
        return l;
    }
    
    public int getfuncvalue(String string, String string_209_, int i) {
        int i_210_ = 0;
        String string_211_ = "";
        for (int i_212_ = string.length() + 1; i_212_ < string_209_.length(); i_212_++) {
            String string_213_ = new StringBuilder().append("").append(string_209_.charAt(i_212_)).toString();
            if (string_213_.equals(",") || string_213_.equals(")")) {
                i_210_++;
                i_212_++;
            }
            if (i_210_ == i)
                string_211_ = new StringBuilder().append(string_211_).append(string_209_.charAt(i_212_)).toString();
        }
        return Float.valueOf(string_211_).intValue();
    }
    
    public String getfuncSvalue(String string, String string_214_, int i) {
        String string_215_ = "";
        int i_216_ = 0;
        for (int i_217_ = string.length() + 1; i_217_ < string_214_.length() && i_216_ <= i; i_217_++) {
            String string_218_ = new StringBuilder().append("").append(string_214_.charAt(i_217_)).toString();
            if (string_218_.equals(",") || string_218_.equals(")"))
                i_216_++;
            else if (i_216_ == i)
                string_215_ = new StringBuilder().append(string_215_).append(string_218_).toString();
        }
        return string_215_;
    }
}
