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
        this.rd = graphics2d;
        this.xt = var_xtGraphics;
        this.gs = gamesparker;
        this.lg = login;
        this.cd = cardefine;
        for (int i = 0; i < 21; i++) {
            this.ctime[i] = "";
            this.cnames[i] = "";
            this.sentn[i] = "";
            this.nctime[i] = 0L;
        }
        for (int i = 0; i < 900; i++)
            this.pname[i] = "";
        for (int i = 0; i < 200; i++) {
            this.logos[i] = "";
            this.logon[i] = false;
        }
        this.mt = new MediaTracker(this.gs);
        (this.gs).sendtyp.setBackground(colorb2k(210, 210, 210));
        (this.gs).sendtyp.setForeground(new Color(0, 0, 0));
        (this.gs).senditem.setBackground(colorb2k(230, 230, 230));
        (this.gs).senditem.setForeground(new Color(0, 0, 0));
        (this.gs).mmsg.setBackground(colorb2k(240, 240, 240));
        (this.gs).mmsg.setForeground(new Color(0, 0, 0));
    }
    
    public void dome(int i, int i_0_, int i_1_, boolean bool, Control control) {
        boolean bool_2_ = false;
        boolean bool_3_ = false;
        boolean bool_4_ = false;
        if (this.open == 0) {
            boolean bool_5_ = false;
            if (i_1_ > 425 && i_1_ < 450 && (float) i_0_ < 500.0F + (float) (i_1_ - 425) * 9.2F && (float) i_0_ > 300.0F - (float) (i_1_ - 425) * 9.2F)
                bool_5_ = true;
            int[] is = { 0, 9, 232, 250, 550, 568, 791, 800 };
            int[] is_6_ = { 452, 443, 443, 425, 425, 443, 443, 452 };
            if (bool_5_)
                this.rd.setColor(color2k(255, 255, 255));
            else
                this.rd.setColor(new Color(207, 177, 110));
            this.rd.fillPolygon(is, is_6_, 8);
            this.rd.setColor(new Color(((this.xt).brl * 2 + 207) / 2, ((this.xt).brl + 177) / 2, 60));
            this.rd.drawPolygon(is, is_6_, 8);
            this.rd.drawImage((this.xt).dome, 311, 430, null);
            if (bool_5_ && bool && i < 2) {
                this.open = 2;
                this.upo = true;
            }
        }
        if (this.open >= 2 && this.open < 452) {
            int[] is = { 0, 0, 9, 232, 250, 550, 568, 791, 800, 800 };
            int[] is_7_ = { 902 - this.open, 452 - this.open, 443 - this.open, 443 - this.open, 425 - this.open, 425 - this.open, 443 - this.open, 443 - this.open, 452 - this.open, 902 - this.open };
            float f = ((float) this.open - 2.0F) / 450.0F;
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
            this.rd.setColor(new Color(i_8_, i_9_, i_10_));
            this.rd.fillPolygon(is, is_7_, 10);
            this.rd.drawImage((this.xt).dome, 311, 430 - this.open, null);
            if (this.upo)
                this.open += 45;
            else
                this.open -= 45;
            this.gs.hidefields();
            if (this.open == 452) {
                this.gs.setCursor(new Cursor(0));
                this.npo = -1;
                this.updatec = -1;
                this.domon = true;
                this.connector = new Thread(this);
                this.connector.start();
            }
        }
        if (this.open == 452) {
            if ((this.xt).warning == 0 || (this.xt).warning == 210) {
                int i_11_ = 0;
                int i_12_ = (int) (255.0F * this.bgf + 191.0F * (1.0F - this.bgf));
                int i_13_ = (int) (176.0F * this.bgf + 184.0F * (1.0F - this.bgf));
                int i_14_ = (int) (67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
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
                this.rd.setColor(new Color(i_12_, i_13_, i_14_));
                this.rd.fillRect(0, 0, 800, 450);
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
                this.rd.drawImage((this.xt).bgmain, this.bgx[0], 0, null);
                this.rd.drawImage((this.xt).bgmain, this.bgx[1], 0, null);
                this.rd.drawImage((this.xt).bgmain, this.bgx[2], 0, null);
                this.rd.drawImage((this.xt).bgmain, this.bgx[0], 400, null);
                this.rd.drawImage((this.xt).bgmain, this.bgx[1], 400, null);
                this.rd.drawImage((this.xt).bgmain, this.bgx[2], 400, null);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                for (int i_15_ = 0; i_15_ < 3; i_15_++) {
                    this.bgx[i_15_] -= 5;
                    if (this.bgx[i_15_] <= -670)
                        this.bgx[i_15_] = 1340;
                }
                if (drawbutton((this.xt).exit, 755, 17, i_0_, i_1_, bool) || i >= 2) {
                    this.open = 450;
                    this.upo = false;
                    this.domon = false;
                    onexit();
                }
                int i_16_ = 0;
                boolean bool_17_ = false;
                if (this.domon) {
                    if (this.tab == 0) {
                        this.rd.setColor(color2k(230, 230, 230));
                        this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                        if (this.updatec != -1) {
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
                            this.rd.setFont(new Font("Tahoma", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            for (int i_22_ = 0; i_22_ < 21; i_22_++) {
                                strings[i_21_] = "";
                                strings_18_[i_21_] = this.cnames[i_22_];
                                strings_19_[i_21_] = this.ctime[i_22_];
                                int i_23_ = 0;
                                int i_24_ = 0;
                                int i_25_ = 0;
                                int i_26_ = 0;
                                int i_27_ = 0;
                                for (/**/; i_23_ < this.sentn[i_22_].length(); i_23_++) {
                                    String string = new StringBuilder().append("").append(this.sentn[i_22_].charAt(i_23_)).toString();
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
                                        if (this.ftm.stringWidth(strings[i_21_]) > 469) {
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
                                                    strings_18_[i_21_] = this.cnames[i_22_];
                                                    strings_19_[i_21_] = this.ctime[i_22_];
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
                            int i_34_ = (int) ((float) this.spos2 / 275.0F * (float) i_16_);
                            i_32_ = 0;
                            string = "";
                            for (int i_35_ = 0; i_35_ <= i_21_; i_35_++) {
                                if (i_35_ != i_21_) {
                                    if (!string.equals(strings_18_[i_35_])) {
                                        if (i_35_ != 0) {
                                            if (i_32_ * 15 - i_34_ > -20 && i_32_ * 15 - i_34_ < 345) {
                                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                                this.rd.setColor(color2k(125, 125, 125));
                                                this.rd.drawString(strings_19_[i_35_ - 1], 297, 82 + i_32_ * 15 - i_34_);
                                            }
                                            i_32_++;
                                        }
                                        if (i_32_ * 15 - i_34_ > -20 && i_32_ * 15 - i_34_ < 345) {
                                            this.rd.setFont(new Font("Tahoma", 1, 11));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.drawString(new StringBuilder().append(strings_18_[i_35_]).append(":").toString(), 292 - this.ftm.stringWidth(new StringBuilder().append(strings_18_[i_35_]).append(":").toString()), 82 + i_32_ * 15 - i_34_);
                                        }
                                        string = strings_18_[i_35_];
                                    }
                                    if (bools[i_35_] && i_35_ == 0 && strings[i_35_].indexOf(" ") != -1)
                                        strings[i_35_] = new StringBuilder().append("...").append(strings[i_35_].substring(strings[i_35_].indexOf(" "), strings[i_35_].length())).append("").toString();
                                    if (i_32_ * 15 - i_34_ > -20 && i_32_ * 15 - i_34_ < 345) {
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString(strings[i_35_], 297, 82 + i_32_ * 15 - i_34_);
                                    }
                                    i_32_++;
                                } else if (i_32_ * 15 - i_34_ > -20 && i_32_ * 15 - i_34_ < 345) {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.rd.setColor(color2k(125, 125, 125));
                                    this.rd.drawString(strings_19_[i_35_ - 1], 297, 82 + i_32_ * 15 - i_34_);
                                }
                            }
                        } else {
                            i_16_ = 0;
                            bool_17_ = false;
                            this.spos2 = 275;
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.setFont(new Font("Tahoma", 1, 11));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("Loading chat...", 498 - this.ftm.stringWidth("Loading chat...") / 2, 220);
                        }
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(207, 46, 582, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.rd.setColor(color2k(40, 40, 40));
                        this.rd.drawString("Global Chat", 213, 62);
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(207, 68, 770, 68);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(207, 411, 582, 28);
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(207, 413, 770, 413);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(772, 88, 17, 306);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(203, 46, 4, 393);
                        bool_2_ = true;
                        if ((stringbutton("Send Message", 731, 430, 3, i_0_, i_1_, bool) || (control).enter) && !(this.gs).cmsg.getText().equals("Type here...") && !(this.gs).cmsg.getText().equals("") && (this.xt).acexp != -3) {
                            String string = (this.gs).cmsg.getText().replace('|', ':');
                            if (string.toLowerCase().indexOf((this.gs).tpass.getText().toLowerCase()) != -1)
                                string = " ";
                            if (!this.xt.msgcheck(string) && this.updatec > -12) {
                                for (int i_36_ = 0; i_36_ < 20; i_36_++) {
                                    this.sentn[i_36_] = this.sentn[i_36_ + 1];
                                    this.cnames[i_36_] = this.cnames[i_36_ + 1];
                                    this.ctime[i_36_] = this.ctime[i_36_ + 1];
                                }
                                this.sentn[20] = string;
                                this.cnames[20] = (this.xt).nickname;
                                this.ctime[20] = "- just now";
                                if (this.updatec > -11)
                                    this.updatec = -11;
                                else
                                    this.updatec--;
                                this.spos2 = 275;
                            } else
                                (this.xt).warning++;
                            (this.gs).cmsg.setText("");
                            (control).enter = false;
                        }
                        if (this.mscro2 == 831 || i_16_ == 0) {
                            if (i_16_ == 0)
                                this.rd.setColor(color2k(205, 205, 205));
                            else
                                this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fillRect(772, 71, 17, 17);
                        } else {
                            this.rd.setColor(color2k(220, 220, 220));
                            this.rd.fill3DRect(772, 71, 17, 17, true);
                        }
                        if (i_16_ != 0)
                            this.rd.drawImage((this.xt).asu, 777, 77, null);
                        if (this.mscro2 == 832 || i_16_ == 0) {
                            if (i_16_ == 0)
                                this.rd.setColor(color2k(205, 205, 205));
                            else
                                this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fillRect(772, 394, 17, 17);
                        } else {
                            this.rd.setColor(color2k(220, 220, 220));
                            this.rd.fill3DRect(772, 394, 17, 17, true);
                        }
                        if (i_16_ != 0)
                            this.rd.drawImage((this.xt).asd, 777, 401, null);
                        if (i_16_ != 0) {
                            if (this.lspos2 != this.spos2) {
                                this.rd.setColor(color2k(215, 215, 215));
                                this.rd.fillRect(772, 88 + this.spos2, 17, 31);
                            } else {
                                if (this.mscro2 == 831)
                                    this.rd.setColor(color2k(215, 215, 215));
                                this.rd.fill3DRect(772, 88 + this.spos2, 17, 31, true);
                            }
                            this.rd.setColor(color2k(150, 150, 150));
                            this.rd.drawLine(777, 101 + this.spos2, 783, 101 + this.spos2);
                            this.rd.drawLine(777, 103 + this.spos2, 783, 103 + this.spos2);
                            this.rd.drawLine(777, 105 + this.spos2, 783, 105 + this.spos2);
                            if (this.mscro2 > 800 && this.lspos2 != this.spos2)
                                this.lspos2 = this.spos2;
                            if (bool) {
                                if (this.mscro2 == 825 && i_0_ > 772 && i_0_ < 789 && i_1_ > 88 + this.spos2 && i_1_ < this.spos2 + 119)
                                    this.mscro2 = i_1_ - this.spos2;
                                if (this.mscro2 == 825 && i_0_ > 770 && i_0_ < 791 && i_1_ > 69 && i_1_ < 90)
                                    this.mscro2 = 831;
                                if (this.mscro2 == 825 && i_0_ > 770 && i_0_ < 791 && i_1_ > 392 && i_1_ < 413)
                                    this.mscro2 = 832;
                                if (this.mscro2 == 825 && i_0_ > 772 && i_0_ < 789 && i_1_ > 88 && i_1_ < 394) {
                                    this.mscro2 = 103;
                                    this.spos2 = i_1_ - this.mscro2;
                                }
                                int i_37_ = 2670 / i_16_;
                                if (i_37_ < 1)
                                    i_37_ = 1;
                                if (this.mscro2 == 831) {
                                    this.spos2 -= i_37_;
                                    if (this.spos2 > 275)
                                        this.spos2 = 275;
                                    if (this.spos2 < 0)
                                        this.spos2 = 0;
                                    this.lspos2 = this.spos2;
                                }
                                if (this.mscro2 == 832) {
                                    this.spos2 += i_37_;
                                    if (this.spos2 > 275)
                                        this.spos2 = 275;
                                    if (this.spos2 < 0)
                                        this.spos2 = 0;
                                    this.lspos2 = this.spos2;
                                }
                                if (this.mscro2 < 800) {
                                    this.spos2 = i_1_ - this.mscro2;
                                    if (this.spos2 > 275)
                                        this.spos2 = 275;
                                    if (this.spos2 < 0)
                                        this.spos2 = 0;
                                }
                                if (this.mscro2 == 825)
                                    this.mscro2 = 925;
                            } else if (this.mscro2 != 825)
                                this.mscro2 = 825;
                        }
                    } else if (this.edit != 3 && (this.gs).cmsg.isShowing())
                        (this.gs).cmsg.hide();
                    if (this.tab == 1) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRoundRect(207, 45, 577, 394, 20, 20);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRoundRect(207, 45, 577, 394, 20, 20);
                        if (!this.flg)
                            this.flk += 5;
                        else
                            this.flk -= 5;
                        if (this.flk >= 100) {
                            this.flk = 100;
                            this.flg = true;
                        }
                        if (this.flk <= 60) {
                            this.flk = 60;
                            this.flg = false;
                        }
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setComposite(AlphaComposite.getInstance(3, (float) this.flk / 100.0F));
                        boolean bool_38_ = false;
                        if (this.proname.equals((this.xt).nickname)) {
                            this.rd.drawString("Your Profile", 232, 67);
                            bool_38_ = true;
                        } else
                            this.rd.drawString(new StringBuilder().append("").append(this.proname).append("'s Profile").toString(), 232, 67);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        if (this.loadedp) {
                            if (!bool_38_ && stringbutton("   <   My Profile   ", 715, 73, 1, i_0_, i_1_, bool)) {
                                this.proname = (this.xt).nickname;
                                this.loadedp = false;
                                onexitpro();
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            if (this.logol)
                                drawl(this.proname, 236, 101, true);
                            else
                                this.rd.drawString("No logo available", 296 - this.ftm.stringWidth("No logo available") / 2, 121);
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            String string = "Logo";
                            if (i_0_ > 232 && i_0_ < 359 && i_1_ > 84 && i_1_ < 134 && this.edit == 0 && bool_38_) {
                                string = "Edit Logo";
                                this.rd.drawLine(238, 98, 238 + this.ftm.stringWidth(string), 98);
                                if (i_0_ > 238 && i_0_ < 238 + this.ftm.stringWidth(string) && i_1_ > 85 && i_1_ < 100) {
                                    i_11_ = 12;
                                    if (bool) {
                                        if ((this.xt).logged) {
                                            this.edit = 1;
                                            this.msg = "Edit your Nickname's logo";
                                            this.flko = 0;
                                        } else
                                            this.edit = 5;
                                    }
                                }
                            }
                            this.rd.drawString(string, 238, 97);
                            this.rd.drawLine(232, 84, 232, 134);
                            this.rd.drawLine(232, 84, 238 + this.ftm.stringWidth(string) + 2, 84);
                            this.rd.drawLine(238 + this.ftm.stringWidth(string) + 2, 84, 238 + this.ftm.stringWidth(string) + 15, 97);
                            this.rd.drawLine(238 + this.ftm.stringWidth(string) + 15, 97, 359, 97);
                            this.rd.drawLine(359, 97, 359, 134);
                            this.rd.drawLine(232, 134, 359, 134);
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            if (this.clanlogol)
                                this.rd.drawImage(this.clanlogo, 406, 101, null);
                            else
                                this.rd.drawString("No clan logo available (this feature is under construction...)", 581 - this.ftm.stringWidth("No clan logo available (this feature is under construction...)") / 2, 121);
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            string = "Clan";
                            do {
                                if (i_0_ > 402 && i_0_ < 759 && i_1_ > 84 && i_1_ < 134 && this.clanlogol && this.edit == 0) {
                                    string = "View Clan :  Unknown";
                                    this.rd.drawLine(408, 98, 408 + this.ftm.stringWidth(string), 98);
                                    if (i_0_ > 408 && i_0_ < 408 + this.ftm.stringWidth(string) && i_1_ > 85 && i_1_ < 100 || i_0_ > 406 && i_0_ < 756 && i_1_ > 101 && i_1_ < 131) {
                                        i_11_ = 12;
                                        if (bool)
                                            break;
                                    }
                                }
                            } while (false);
                            this.rd.drawString(string, 408, 97);
                            this.rd.drawLine(402, 84, 402, 134);
                            this.rd.drawLine(402, 84, 408 + this.ftm.stringWidth(string) + 2, 84);
                            this.rd.drawLine(408 + this.ftm.stringWidth(string) + 2, 84, 408 + this.ftm.stringWidth(string) + 15, 97);
                            this.rd.drawLine(408 + this.ftm.stringWidth(string) + 15, 97, 759, 97);
                            this.rd.drawLine(759, 97, 759, 134);
                            this.rd.drawLine(402, 134, 759, 134);
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            if (this.avatarl)
                                this.rd.drawImage(this.avatar, 236, 161, null);
                            else
                                this.rd.drawString("No avatar available", 336 - this.ftm.stringWidth("No avatar available") / 2, 255);
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            string = "Avatar";
                            if (i_0_ > 232 && i_0_ < 439 && i_1_ > 144 && i_1_ < 364 && this.edit == 0 && bool_38_) {
                                string = "Edit Avatar";
                                this.rd.drawLine(238, 158, 238 + this.ftm.stringWidth(string), 158);
                                if (i_0_ > 238 && i_0_ < 238 + this.ftm.stringWidth(string) && i_1_ > 145 && i_1_ < 160) {
                                    i_11_ = 12;
                                    if (bool) {
                                        if ((this.xt).logged) {
                                            this.edit = 2;
                                            this.msg = "Edit your proflie avatar";
                                            this.flko = 0;
                                        } else
                                            this.edit = 5;
                                    }
                                }
                            }
                            this.rd.drawString(string, 238, 157);
                            this.rd.drawLine(232, 144, 232, 364);
                            this.rd.drawLine(232, 144, 238 + this.ftm.stringWidth(string) + 2, 144);
                            this.rd.drawLine(238 + this.ftm.stringWidth(string) + 2, 144, 238 + this.ftm.stringWidth(string) + 15, 157);
                            this.rd.drawLine(238 + this.ftm.stringWidth(string) + 15, 157, 439, 157);
                            this.rd.drawLine(439, 157, 439, 364);
                            this.rd.drawLine(232, 364, 439, 364);
                            string = "About";
                            if (i_0_ > 459 && i_0_ < 759 && i_1_ > 144 && i_1_ < 364 && this.edit == 0 && bool_38_) {
                                string = "Edit About";
                                this.rd.drawLine(465, 158, 465 + this.ftm.stringWidth(string), 158);
                                if (i_0_ > 465 && i_0_ < 465 + this.ftm.stringWidth(string) && i_1_ > 145 && i_1_ < 160) {
                                    i_11_ = 12;
                                    if (bool) {
                                        if ((this.xt).logged) {
                                            this.edit = 3;
                                            this.msg = "";
                                            this.flko = 0;
                                            this.sentchange = 0;
                                            this.badlang = false;
                                        } else
                                            this.edit = 5;
                                    }
                                }
                            }
                            this.rd.drawString(string, 465, 157);
                            this.rd.drawLine(459, 144, 459, 364);
                            this.rd.drawLine(459, 144, 465 + this.ftm.stringWidth(string) + 2, 144);
                            this.rd.drawLine(465 + this.ftm.stringWidth(string) + 2, 144, 465 + this.ftm.stringWidth(string) + 15, 157);
                            this.rd.drawLine(465 + this.ftm.stringWidth(string) + 15, 157, 759, 157);
                            this.rd.drawLine(759, 157, 759, 364);
                            this.rd.drawLine(459, 364, 759, 364);
                            if (this.nab != 0) {
                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                int i_39_ = 200;
                                if (this.nab == 2)
                                    i_39_ = 192;
                                if (this.nab == 3)
                                    i_39_ = 185;
                                for (int i_40_ = 0; i_40_ < this.nab; i_40_++)
                                    this.rd.drawString(this.aboutxt[i_40_], 469, i_39_ + i_40_ * 15);
                            } else {
                                this.rd.setFont(new Font("Arial", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("No description available", 609 - this.ftm.stringWidth("No description available") / 2, 200);
                            }
                            this.rd.drawLine(489, 230, 729, 230);
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("Racing", 532 - this.ftm.stringWidth("Racing") / 2, 253);
                            this.rd.drawString("VS", 532 - this.ftm.stringWidth("VS") / 2, 270);
                            this.rd.drawString("Wasting", 532 - this.ftm.stringWidth("Wasting") / 2, 287);
                            float f = (float) this.racing;
                            float f_41_ = (float) this.wasting;
                            if (this.racing > 10 && this.racing > this.wasting) {
                                f = 10.0F;
                                f_41_ = (float) this.wasting / ((float) this.racing / 10.0F);
                            }
                            if (this.wasting > 10 && this.wasting >= this.racing) {
                                f_41_ = 10.0F;
                                f = (float) this.racing / ((float) this.wasting / 10.0F);
                            }
                            f *= 14.0F;
                            f_41_ *= 14.0F;
                            for (int i_42_ = 0; i_42_ < 5; i_42_++) {
                                if (f != 0.0F) {
                                    this.rd.setColor(new Color(0, i_42_ * 50, 255));
                                    this.rd.drawLine(569, 245 + i_42_, (int) (569.0F + f), 245 + i_42_);
                                    this.rd.drawLine(569, 254 - i_42_, (int) (569.0F + f), 254 - i_42_);
                                }
                                if (f_41_ != 0.0F) {
                                    this.rd.setColor(new Color(255, i_42_ * 50, 0));
                                    this.rd.drawLine(569, 279 + i_42_, (int) (569.0F + f_41_), 279 + i_42_);
                                    this.rd.drawLine(569, 288 - i_42_, (int) (569.0F + f_41_), 288 - i_42_);
                                }
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRect(569, 244, 140, 11);
                            this.rd.drawRect(569, 278, 140, 11);
                            this.rd.drawLine(489, 304, 729, 304);
                            if (!this.themesong.equals("") && this.trackvol != 0) {
                                if (this.playt == 1)
                                    this.rd.drawString("Loading theme song, please wait...", 609 - this.ftm.stringWidth("Loading theme song, please wait...") / 2, 340);
                                if (this.playt == 0 && stringbutton(" Play Theme Song ", 609, 340, 1, i_0_, i_1_, bool) && this.edit == 0)
                                    this.playt = 1;
                                if (this.playt == 2) {
                                    this.rd.drawString("Theme song playing...", 609 - this.ftm.stringWidth("Theme song playing...") / 2, 325);
                                    if (stringbutton(" Stop ", 609, 350, 2, i_0_, i_1_, bool)) {
                                        (this.xt).strack.unload();
                                        this.playt = 0;
                                    }
                                }
                            } else {
                                this.rd.setFont(new Font("Arial", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("No theme song available", 609 - this.ftm.stringWidth("No theme song available") / 2, 340);
                            }
                            if (!bool_38_) {
                                this.rd.drawRect(232, 378, 527, 50);
                                if (stringbutton("   Add Friend   ", 313, 408, 1, i_0_, i_1_, bool))
                                    this.underc = 60;
                                if (stringbutton("   Send Message   ", 436, 408, 1, i_0_, i_1_, bool)) {
                                    this.tab = 2;
                                    this.openc = 10;
                                    if (!this.opname.equals(this.proname)) {
                                        this.opname = this.proname;
                                        this.lastsub = "";
                                        this.readmsg = 1;
                                    }
                                }
                                if (stringbutton("   View Cars   ", 558, 408, 1, i_0_, i_1_, bool))
                                    this.underc = 60;
                                if (stringbutton("   View Stages   ", 673, 408, 1, i_0_, i_1_, bool))
                                    this.underc = 60;
                                if (this.underc != 0) {
                                    int i_43_ = this.ftm.stringWidth("Option still under construction, you can only use 'Send Message' for now...");
                                    this.rd.setColor(new Color(244, 232, 204));
                                    this.rd.fillRect(495 - (i_43_ + 40) / 2, 422, i_43_ + 40, 23);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    if (this.underc % 4 != 0)
                                        this.rd.drawString("Option still under construction, you can only use 'Send Message' for now...", 495 - i_43_ / 2, 438);
                                    this.rd.drawRect(495 - (i_43_ + 40) / 2, 422, i_43_ + 40, 23);
                                    this.underc--;
                                }
                            }
                            if (this.edit == 1 || this.edit == 2) {
                                this.rd.setColor(new Color(244, 232, 204));
                                this.rd.fillRoundRect(265, 92, 460, 220, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(265, 92, 460, 220, 20, 20);
                                String[] strings = { "logo", "120x30", "4 : 1" };
                                if (this.edit == 2) {
                                    strings[0] = "avatar";
                                    strings[1] = "200x200";
                                    strings[2] = "1 : 1";
                                }
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.flko % 4 != 0 || this.flko == 0)
                                    this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
                                if (this.flko != 0)
                                    this.flko--;
                                this.rd.setFont(new Font("Arial", 0, 12));
                                this.rd.drawString(new StringBuilder().append("The ").append(strings[0]).append(" image is ").append(strings[1]).append(" pixels.").toString(), 275, 140);
                                this.rd.drawString("Any image uploaded will be resized to that width and height. For the best results", 275, 160);
                                this.rd.drawString(new StringBuilder().append("try to upload an image that is bigger or equal to ").append(strings[1]).append(" and has the scale of").toString(), 275, 180);
                                this.rd.drawString(new StringBuilder().append("[ ").append(strings[2]).append(" ]  in  [ Width : Height ].").toString(), 275, 200);
                                this.rd.drawString("Image uploaded must be less than 1MB and in the format of JPEG, GIF or PNG.", 275, 220);
                                if (this.upload == 0) {
                                    if (stringbutton("  Upload Image  ", 495, 250, 0, i_0_, i_1_, bool)) {
                                        FileDialog filedialog = new FileDialog(new Frame(), "Upload Image");
                                        filedialog.setMode(0);
                                        filedialog.setVisible(true);
                                        this.filename = new StringBuilder().append("").append(filedialog.getDirectory()).append("").append(filedialog.getFile()).append("").toString();
                                        if (!this.filename.equals("nullnull"))
                                            this.upload = 1;
                                    }
                                } else {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (this.upload == 1)
                                        this.rd.drawString("Checking image...", 495 - this.ftm.stringWidth("Checking image...") / 2, 250);
                                    if (this.upload == 2)
                                        this.rd.drawString("Authenticating...", 495 - this.ftm.stringWidth("Authenticating...") / 2, 250);
                                    if (this.upload == 3)
                                        this.rd.drawString(new StringBuilder().append("Uploading image :  ").append(this.perc).append(" %").toString(), 495 - this.ftm.stringWidth("Uploading image :  80 %") / 2, 250);
                                    if (this.upload == 4)
                                        this.rd.drawString("Creating image online...", 495 - this.ftm.stringWidth("Creating image online...") / 2, 250);
                                    if (this.upload == 5)
                                        this.rd.drawString("Done", 495 - this.ftm.stringWidth("Done") / 2, 250);
                                }
                                if (stringbutton(" Cancel ", 495, 290, 2, i_0_, i_1_, bool)) {
                                    if (this.upload == 0)
                                        this.edit = 0;
                                    else
                                        this.upload = 0;
                                }
                            }
                            if (this.edit == 3) {
                                this.rd.setColor(new Color(244, 232, 204));
                                this.rd.fillRoundRect(265, 38, 460, 390, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(265, 38, 460, 390, 20, 20);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("Edit your about section", 495 - this.ftm.stringWidth("Edit your about section") / 2, 61);
                                this.rd.setFont(new Font("Arial", 0, 12));
                                if (!this.badlang)
                                    this.rd.drawString("Type in a sentence that best describes you and your playing style in the game :", 275, 86);
                                else {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.rd.drawString("The sentence must not contain bad language!", 275, 86);
                                    this.rd.setFont(new Font("Arial", 0, 12));
                                }
                                bool_3_ = true;
                                this.rd.drawLine(315, 123, 675, 123);
                                this.rd.drawString("The (Racing VS Wasting ) is comparison between your multiplayer wins by", 275, 146);
                                this.rd.drawString("racing versus wasting.", 275, 166);
                                this.rd.drawString("It does not in anyway signify if you are better or worse than another player!", 275, 186);
                                this.rd.drawString("It simply shows whether you have a tendency to win games by racing or by", 275, 206);
                                this.rd.drawString("wasting, it shows what you are better at.", 275, 226);
                                this.rd.drawLine(315, 241, 675, 241);
                                this.rd.drawString("Upload your very own theme song!", 275, 264);
                                this.rd.drawString("The theme song must be a MOD Track that is in a zip file and less than 250KB.", 275, 284);
                                this.rd.drawString("You can find lots of MOD Tracks at modarchive.org.", 275, 304);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.uploadt == 0) {
                                    if (this.msg.equals("")) {
                                        if (!this.themesong.equals("") && this.trackvol != 0)
                                            this.rd.drawString(new StringBuilder().append("Current Track : ").append(this.themesong).append("").toString(), 495 - this.ftm.stringWidth(new StringBuilder().append("Current Track : ").append(this.themesong).append("").toString()) / 2, 324);
                                        else {
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.rd.drawString("[ No theme song uploaded... ]", 495 - this.ftm.stringWidth("[ No theme song uploaded... ]") / 2, 324);
                                        }
                                    } else {
                                        if (this.flko % 4 != 0 || this.flko == 0)
                                            this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 324);
                                        if (this.flko != 0)
                                            this.flko--;
                                    }
                                    if (stringbutton("  Upload Track  ", 495, 354, 0, i_0_, i_1_, bool)) {
                                        FileDialog filedialog = new FileDialog(new Frame(), "Upload Track");
                                        filedialog.setMode(0);
                                        filedialog.setFile("*.zip");
                                        filedialog.setVisible(true);
                                        this.filename = new StringBuilder().append("").append(filedialog.getDirectory()).append("").append(filedialog.getFile()).append("").toString();
                                        if (!this.filename.equals("nullnull")) {
                                            this.trackname = filedialog.getFile().substring(0, filedialog.getFile().length() - 4);
                                            this.uploadt = 1;
                                        }
                                    }
                                } else {
                                    if (this.uploadt == 1)
                                        this.rd.drawString("Checking MOD Track...", 495 - this.ftm.stringWidth("Checking MOD Track...") / 2, 354);
                                    if (this.uploadt == 2)
                                        this.rd.drawString("Authenticating...", 495 - this.ftm.stringWidth("Authenticating...") / 2, 354);
                                    if (this.uploadt == 3)
                                        this.rd.drawString("Uploading track, please wait...", 495 - this.ftm.stringWidth("Uploading track, please wait...") / 2, 354);
                                    if (this.uploadt == 4)
                                        this.rd.drawString("Adding track to your profile...", 495 - this.ftm.stringWidth("Adding track to your profile...") / 2, 354);
                                    if (this.uploadt == 5)
                                        this.rd.drawString("Done", 495 - this.ftm.stringWidth("Done") / 2, 354);
                                }
                                this.rd.drawLine(315, 376, 675, 376);
                                if (stringbutton("        Done        ", 495, 407, 1, i_0_, i_1_, bool)) {
                                    this.edit = 0;
                                    if (this.sentchange == 1) {
                                        if (this.xt.msgcheck(this.sentance) || this.sentance.toLowerCase().indexOf((this.gs).tpass.getText().toLowerCase()) != -1 || (this.xt).acexp == -3) {
                                            this.edit = 3;
                                            this.sentchange = 0;
                                            this.sentance = "";
                                            (this.gs).cmsg.setText(this.sentance);
                                            this.badlang = true;
                                        } else
                                            this.sentchange = 2;
                                        trunsent();
                                    }
                                }
                            }
                            if (this.edit == 5) {
                                this.rd.setColor(new Color(244, 232, 204));
                                this.rd.fillRoundRect(265, 187, 460, 125, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(265, 187, 460, 125, 20, 20);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("You need to upgrade your account to a full account to edit your profile!", 495 - this.ftm.stringWidth("You need to upgrade your account to a full account to edit your profile!") / 2, 215);
                                if (stringbutton("  Upgrade Now  ", 495, 250, 0, i_0_, i_1_, bool))
                                    this.gs.editlink((this.xt).nickname);
                                if (stringbutton("  Cancel  ", 495, 290, 2, i_0_, i_1_, bool))
                                    this.edit = 0;
                            }
                        } else
                            this.rd.drawString("Loading profile, please wait...", 495 - this.ftm.stringWidth("Loading profile, please wait...") / 2, 222);
                    } else {
                        this.edit = 0;
                        this.upload = 0;
                        this.uploadt = 0;
                        this.sentchange = 0;
                        this.underc = 0;
                    }
                    if (this.tab == 2) {
                        if (this.openc != 10) {
                            this.rd.setColor(color2k(230, 230, 230));
                            this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                            if (this.loadmsgs != 0 && this.loadmsgs != -2 && this.loadmsgs != -1) {
                                i_16_ = (this.nm - 10) * 31;
                                if (i_16_ < 0)
                                    i_16_ = 0;
                                int i_44_ = (int) ((float) this.spos3 / 268.0F * (float) i_16_);
                                int i_45_ = 0;
                                for (int i_46_ = 0; i_46_ < this.nm; i_46_++) {
                                    if (this.mtyp[i_46_] != 3) {
                                        if (76 + 31 * i_45_ - i_44_ < 408 && 107 + 31 * i_45_ - i_44_ > 76) {
                                            boolean bool_47_ = false;
                                            if (i_0_ > 207 && i_0_ < 770 && i_1_ > 76 + 31 * i_45_ - i_44_ && i_1_ < 106 + 31 * i_45_ - i_44_) {
                                                bool_47_ = true;
                                                i_11_ = 12;
                                                if (bool && this.openc == 0) {
                                                    this.opy = 70 + 31 * i_45_ - i_44_;
                                                    this.addopy = (40 - this.opy) / 10;
                                                    this.oph = 44;
                                                    this.openc = 1;
                                                    if (!this.opname.equals(this.mname[i_46_])) {
                                                        this.opname = this.mname[i_46_];
                                                        this.lastsub = "";
                                                        this.readmsg = 1;
                                                    }
                                                }
                                            }
                                            if (this.mtyp[i_46_] == 1) {
                                                this.rd.setColor(color2k(240, 240, 240));
                                                this.rd.fillRect(207, 77 + 31 * i_45_ - i_44_, 564, 30);
                                            }
                                            if (bool_47_) {
                                                this.rd.setColor(color2k(250, 250, 250));
                                                this.rd.fillRect(207, 77 + 31 * i_45_ - i_44_, 564, 30);
                                            }
                                            boolean bool_48_ = drawl(this.mname[i_46_], 207, 77 + 31 * i_45_ - i_44_, bool_47_);
                                            if (!bool_47_ || !bool_48_) {
                                                this.rd.setFont(new Font("Arial", 1, 12));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.drawString(this.mname[i_46_], 267 - this.ftm.stringWidth(this.mname[i_46_]) / 2, 96 + 31 * i_45_ - i_44_);
                                            }
                                            int[] is = { 0, 5, 5, 14, 14, 5, 5 };
                                            int[] is_49_ = { 0, -5, -2, -2, 3, 3, 5 };
                                            if (this.mtyp[i_46_] != 2) {
                                                for (int i_50_ = 0; i_50_ < 7; i_50_++) {
                                                    is[i_50_] += 335;
                                                    is_49_[i_50_] += 98 + 31 * i_45_ - i_44_;
                                                }
                                                this.rd.setColor(new Color(0, 128, 0));
                                            } else {
                                                for (int i_51_ = 0; i_51_ < 7; i_51_++) {
                                                    is[i_51_] = 349 - is[i_51_];
                                                    is_49_[i_51_] += 98 + 31 * i_45_ - i_44_;
                                                }
                                                this.rd.setColor(new Color(0, 0, 128));
                                            }
                                            this.rd.fillPolygon(is, is_49_, 7);
                                            this.rd.setFont(new Font("Tahoma", 0, 11));
                                            this.ftm = this.rd.getFontMetrics();
                                            this.rd.setColor(color2k(125, 125, 125));
                                            this.rd.drawString(this.mtime[i_46_], 760 - this.ftm.stringWidth(this.mtime[i_46_]), 102 + 31 * i_45_ - i_44_);
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.drawString(this.msub[i_46_], 335, 89 + 31 * i_45_ - i_44_);
                                            this.rd.setColor(color2k(150, 150, 150));
                                            this.rd.drawLine(207, 107 + 31 * i_45_ - i_44_, 770, 107 + 31 * i_45_ - i_44_);
                                        }
                                        i_45_++;
                                    }
                                }
                                for (int i_52_ = 0; i_52_ < this.nm; i_52_++) {
                                    if (this.mtyp[i_52_] == 3) {
                                        if (76 + 31 * i_45_ - i_44_ < 408 && 107 + 31 * i_45_ - i_44_ > 76) {
                                            this.rd.setFont(new Font("Arial", 1, 12));
                                            this.ftm = this.rd.getFontMetrics();
                                            boolean bool_53_ = false;
                                            if (i_0_ > 207 && i_0_ < 770 && i_1_ > 76 + 31 * i_45_ - i_44_ && i_1_ < 106 + 31 * i_45_ - i_44_)
                                                bool_53_ = true;
                                            boolean bool_54_ = drawl(this.mname[i_52_], 207, 77 + 31 * i_45_ - i_44_, bool_53_);
                                            if (!bool_53_ || !bool_54_) {
                                                this.rd.setColor(new Color(0, 0, 0));
                                                this.rd.drawString(this.mname[i_52_], 267 - this.ftm.stringWidth(this.mname[i_52_]) / 2, 96 + 31 * i_45_ - i_44_);
                                            }
                                            this.rd.setColor(color2k(100, 100, 100));
                                            this.rd.fillRect(327, 77 + 31 * i_45_ - i_44_, 444, 30);
                                            this.rd.setColor(color2k(200, 200, 200));
                                            if (this.unblockname.equals(""))
                                                this.rd.drawString("Blocked", 337, 96 + 31 * i_45_ - i_44_);
                                            else
                                                this.rd.drawString("Unblocking...", 337, 96 + 31 * i_45_ - i_44_);
                                            if (bool_53_ && stringbutton("   Unblock  ", 724, 96 + 31 * i_45_ - i_44_, 3, i_0_, i_1_, bool) && this.unblockname.equals(""))
                                                this.unblockname = this.mname[i_52_];
                                            this.rd.setColor(color2k(150, 150, 150));
                                            this.rd.drawLine(207, 107 + 31 * i_45_ - i_44_, 770, 107 + 31 * i_45_ - i_44_);
                                        }
                                        i_45_++;
                                    }
                                }
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(207, 46, 582, 30);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.rd.setColor(color2k(40, 40, 40));
                                this.rd.drawString("Conversations", 213, 67);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(207, 73, 770, 73);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(207, 409, 582, 30);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(207, 411, 770, 411);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(772, 93, 17, 299);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(203, 46, 4, 393);
                                if (this.mscro3 == 831 || i_16_ == 0) {
                                    if (i_16_ == 0)
                                        this.rd.setColor(color2k(205, 205, 205));
                                    else
                                        this.rd.setColor(color2k(215, 215, 215));
                                    this.rd.fillRect(772, 76, 17, 17);
                                } else {
                                    this.rd.setColor(color2k(220, 220, 220));
                                    this.rd.fill3DRect(772, 76, 17, 17, true);
                                }
                                if (i_16_ != 0)
                                    this.rd.drawImage((this.xt).asu, 777, 82, null);
                                if (this.mscro3 == 832 || i_16_ == 0) {
                                    if (i_16_ == 0)
                                        this.rd.setColor(color2k(205, 205, 205));
                                    else
                                        this.rd.setColor(color2k(215, 215, 215));
                                    this.rd.fillRect(772, 392, 17, 17);
                                } else {
                                    this.rd.setColor(color2k(220, 220, 220));
                                    this.rd.fill3DRect(772, 392, 17, 17, true);
                                }
                                if (i_16_ != 0)
                                    this.rd.drawImage((this.xt).asd, 777, 399, null);
                                if (i_16_ != 0) {
                                    if (this.lspos3 != this.spos3) {
                                        this.rd.setColor(color2k(215, 215, 215));
                                        this.rd.fillRect(772, 93 + this.spos3, 17, 31);
                                    } else {
                                        if (this.mscro3 == 831)
                                            this.rd.setColor(color2k(215, 215, 215));
                                        this.rd.fill3DRect(772, 93 + this.spos3, 17, 31, true);
                                    }
                                    this.rd.setColor(color2k(150, 150, 150));
                                    this.rd.drawLine(777, 106 + this.spos3, 783, 106 + this.spos3);
                                    this.rd.drawLine(777, 108 + this.spos3, 783, 108 + this.spos3);
                                    this.rd.drawLine(777, 110 + this.spos3, 783, 110 + this.spos3);
                                    if (this.mscro3 > 800 && this.lspos3 != this.spos3)
                                        this.lspos3 = this.spos3;
                                    if (bool && this.openc == 0) {
                                        if (this.mscro3 == 825 && i_0_ > 772 && i_0_ < 789 && i_1_ > 93 + this.spos3 && i_1_ < this.spos3 + 124)
                                            this.mscro3 = i_1_ - this.spos3;
                                        if (this.mscro3 == 825 && i_0_ > 770 && i_0_ < 791 && i_1_ > 74 && i_1_ < 95)
                                            this.mscro3 = 831;
                                        if (this.mscro3 == 825 && i_0_ > 770 && i_0_ < 791 && i_1_ > 390 && i_1_ < 411)
                                            this.mscro3 = 832;
                                        if (this.mscro3 == 825 && i_0_ > 772 && i_0_ < 789 && i_1_ > 93 && i_1_ < 392) {
                                            this.mscro3 = 108;
                                            this.spos3 = i_1_ - this.mscro3;
                                        }
                                        int i_55_ = 2670 / i_16_;
                                        if (i_55_ < 1)
                                            i_55_ = 1;
                                        if (this.mscro3 == 831) {
                                            this.spos3 -= i_55_;
                                            if (this.spos3 > 268)
                                                this.spos3 = 268;
                                            if (this.spos3 < 0)
                                                this.spos3 = 0;
                                            this.lspos3 = this.spos3;
                                        }
                                        if (this.mscro3 == 832) {
                                            this.spos3 += i_55_;
                                            if (this.spos3 > 268)
                                                this.spos3 = 268;
                                            if (this.spos3 < 0)
                                                this.spos3 = 0;
                                            this.lspos3 = this.spos3;
                                        }
                                        if (this.mscro3 < 800) {
                                            this.spos3 = i_1_ - this.mscro3;
                                            if (this.spos3 > 268)
                                                this.spos3 = 268;
                                            if (this.spos3 < 0)
                                                this.spos3 = 0;
                                        }
                                        if (this.mscro3 == 825)
                                            this.mscro3 = 925;
                                    } else if (this.mscro3 != 825)
                                        this.mscro3 = 825;
                                }
                            } else {
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(207, 46, 582, 30);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.rd.setColor(color2k(40, 40, 40));
                                this.rd.drawString("Conversations", 213, 67);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(207, 73, 770, 73);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(207, 409, 582, 30);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(207, 411, 770, 411);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(772, 76, 17, 333);
                                this.rd.setColor(color2k(205, 205, 205));
                                this.rd.fillRect(203, 46, 4, 393);
                                if (this.loadmsgs == 0) {
                                    this.rd.setFont(new Font("Arial", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("You have not started any conversations yet.", 487 - this.ftm.stringWidth("You have not started any conversations yet.") / 2, 200);
                                }
                                if (this.loadmsgs == -2) {
                                    this.rd.setFont(new Font("Arial", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Failed to load conversations, will try again now...", 487 - this.ftm.stringWidth("Failed to load conversations, will try again now...") / 2, 200);
                                }
                                if (this.loadmsgs == -1) {
                                    this.rd.setFont(new Font("Arial", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Loading conversations, please wait...", 487 - this.ftm.stringWidth("Loading conversation, please wait...") / 2, 200);
                                }
                            }
                            if ((this.gs).sendtyp.isShowing())
                                (this.gs).sendtyp.hide();
                            if ((this.gs).senditem.isShowing())
                                (this.gs).senditem.hide();
                        } else {
                            this.rd.setColor(color2k(240, 240, 240));
                            this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                            this.rd.setColor(color2k(250, 250, 250));
                            this.rd.fillRect(207, 86, 577, 274);
                            i_16_ = (int) (((float) this.nml - 14.75F) * 17.0F);
                            if (i_16_ < 0)
                                i_16_ = 0;
                            int i_56_ = (int) ((float) this.spos4 / 208.0F * (float) i_16_);
                            if (this.readmsg == 2) {
                                for (int i_57_ = 0; i_57_ < this.nml; i_57_++) {
                                    if (86 + 17 * i_57_ - i_56_ < 360 && 125 + 17 * i_57_ - i_56_ > 86 && this.mlinetyp[i_57_] != 167) {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        if (this.mlinetyp[i_57_] != 10 && this.mlinetyp[i_57_] != 20) {
                                            if (this.mlinetyp[i_57_] == 0 || this.mlinetyp[i_57_] == 1 || this.mlinetyp[i_57_] == 2)
                                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                            else
                                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                            this.rd.drawString(this.mline[i_57_], 217, 103 + 17 * i_57_ - i_56_);
                                            if (this.mlinetyp[i_57_] == 0 || this.mlinetyp[i_57_] == 1 || this.mlinetyp[i_57_] == 2) {
                                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                                this.ftm = this.rd.getFontMetrics();
                                                this.rd.setColor(color2k(125, 125, 125));
                                                this.rd.drawString(this.mtimes[i_57_], 757 - this.ftm.stringWidth(this.mtimes[i_57_]), 103 + 17 * i_57_ - i_56_);
                                            }
                                        } else {
                                            if (this.mlinetyp[i_57_] == 10) {
                                                if ((this.cd).acname.equals(this.mline[i_57_])) {
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    if ((this.cd).action == -9)
                                                        this.rd.drawString("Failed to add car!  Unknown error, please try again later.", 217, 109 + 17 * i_57_ - i_56_);
                                                    if ((this.cd).action == -8)
                                                        this.rd.drawString("Cannot add more then 20 cars to your account!", 217, 109 + 17 * i_57_ - i_56_);
                                                    if ((this.cd).action == 7) {
                                                        this.rd.setColor(new Color(94, 170, 0));
                                                        this.rd.drawString(new StringBuilder().append("[").append(this.mline[i_57_]).append("] has been added to your cars!").toString(), 217, 109 + 17 * i_57_ - i_56_);
                                                    }
                                                    if ((this.cd).action == -7)
                                                        this.rd.drawString("You already have this car.", 217, 109 + 17 * i_57_ - i_56_);
                                                    if ((this.cd).action == 6)
                                                        this.rd.drawString("Adding Car...", 217, 109 + 17 * i_57_ - i_56_);
                                                    if ((this.cd).action == -6) {
                                                        this.rd.setColor(new Color(193, 106, 0));
                                                        String string = "Upgrade to a full account to add custom cars!";
                                                        int i_58_ = 217;
                                                        int i_59_ = i_58_ + this.ftm.stringWidth(string);
                                                        this.rd.drawString(string, i_58_, 109 + 17 * i_57_ - i_56_);
                                                        if (this.waitlink != -1)
                                                            this.rd.drawLine(i_58_, 111 + 17 * i_57_ - i_56_, i_59_, 111 + 17 * i_57_ - i_56_);
                                                        if (i_0_ > i_58_ && i_0_ < i_59_ && i_1_ > 98 + 17 * i_57_ - i_56_ && i_1_ < 111 + 17 * i_57_ - i_56_) {
                                                            if (this.waitlink != -1)
                                                                i_11_ = 12;
                                                            if (bool && this.waitlink == 0) {
                                                                this.gs.editlink((this.xt).nickname);
                                                                this.waitlink = -1;
                                                            }
                                                        }
                                                        if (this.waitlink > 0)
                                                            this.waitlink--;
                                                    }
                                                }
                                                if ((this.cd).action == 0 || !(this.cd).acname.equals(this.mline[i_57_])) {
                                                    this.rd.setFont(new Font("Arial", 0, 12));
                                                    this.rd.drawString("Car name:", 340, 109 + 17 * i_57_ - i_56_);
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.rd.drawString(new StringBuilder().append("[  ").append(this.mline[i_57_]).append("  ]").toString(), 407, 109 + 17 * i_57_ - i_56_);
                                                    if (this.xt.drawcarb(true, null, " Add to My Cars ", 217, 90 + 17 * i_57_ - i_56_, i_0_, i_1_, bool)) {
                                                        if ((this.xt).logged) {
                                                            (this.cd).action = 6;
                                                            (this.cd).ac = -1;
                                                            (this.cd).acname = this.mline[i_57_];
                                                            this.cd.sparkactionloader();
                                                        } else {
                                                            (this.cd).acname = this.mline[i_57_];
                                                            (this.cd).action = -6;
                                                            this.waitlink = 20;
                                                        }
                                                    }
                                                }
                                            }
                                            if (this.mlinetyp[i_57_] == 20) {
                                                if ((this.cd).onstage.equals(this.mline[i_57_])) {
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.ftm = this.rd.getFontMetrics();
                                                    if (this.addstage == 2) {
                                                        this.rd.drawString("Adding stage...", 217, 109 + 17 * i_57_ - i_56_);
                                                        if ((this.cd).staction == 0)
                                                            this.addstage = 3;
                                                        if ((this.cd).staction == -2)
                                                            this.addstage = 4;
                                                        if ((this.cd).staction == -3)
                                                            this.addstage = 5;
                                                        if ((this.cd).staction == -1)
                                                            this.addstage = 6;
                                                    }
                                                    if (this.addstage == 3) {
                                                        this.rd.setColor(new Color(94, 170, 0));
                                                        this.rd.drawString(new StringBuilder().append("[").append(this.mline[i_57_]).append("] has been added to your stages!").toString(), 217, 109 + 17 * i_57_ - i_56_);
                                                    }
                                                    if (this.addstage == 4)
                                                        this.rd.drawString("You already have this stage.", 217, 109 + 17 * i_57_ - i_56_);
                                                    if (this.addstage == 5)
                                                        this.rd.drawString("Cannot add more then 20 stages to your account!", 217, 109 + 17 * i_57_ - i_56_);
                                                    if (this.addstage == 6)
                                                        this.rd.drawString("Failed to add stage!  Unknown error, please try again later.", 217, 109 + 17 * i_57_ - i_56_);
                                                    if (this.addstage == 1) {
                                                        this.rd.setColor(new Color(193, 106, 0));
                                                        String string = "Upgrade to a full account to add custom stages!";
                                                        int i_60_ = 217;
                                                        int i_61_ = i_60_ + this.ftm.stringWidth(string);
                                                        this.rd.drawString(string, i_60_, 109 + 17 * i_57_ - i_56_);
                                                        if (this.waitlink != -1)
                                                            this.rd.drawLine(i_60_, 111 + 17 * i_57_ - i_56_, i_61_, 111 + 17 * i_57_ - i_56_);
                                                        if (i_0_ > i_60_ && i_0_ < i_61_ && i_1_ > 98 + 17 * i_57_ - i_56_ && i_1_ < 111 + 17 * i_57_ - i_56_) {
                                                            if (this.waitlink != -1)
                                                                i_11_ = 12;
                                                            if (bool && this.waitlink == 0) {
                                                                this.gs.editlink((this.xt).nickname);
                                                                this.waitlink = -1;
                                                            }
                                                        }
                                                        if (this.waitlink > 0)
                                                            this.waitlink--;
                                                    }
                                                }
                                                if (this.addstage == 0 || !(this.cd).onstage.equals(this.mline[i_57_])) {
                                                    this.rd.setFont(new Font("Arial", 0, 12));
                                                    this.rd.drawString("Stage name:", 355, 109 + 17 * i_57_ - i_56_);
                                                    this.rd.setFont(new Font("Arial", 1, 12));
                                                    this.rd.drawString(new StringBuilder().append("[  ").append(this.mline[i_57_]).append("  ]").toString(), 434, 109 + 17 * i_57_ - i_56_);
                                                    if (this.xt.drawcarb(true, null, " Add to My Stages ", 217, 90 + 17 * i_57_ - i_56_, i_0_, i_1_, bool)) {
                                                        if ((this.xt).logged) {
                                                            (this.cd).onstage = this.mline[i_57_];
                                                            (this.cd).staction = 2;
                                                            this.cd.sparkstageaction();
                                                            this.addstage = 2;
                                                        } else {
                                                            (this.cd).onstage = this.mline[i_57_];
                                                            this.addstage = 1;
                                                            this.waitlink = 20;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (this.readmsg == 1) {
                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Loading...", 487 - this.ftm.stringWidth("Loading...") / 2, 200);
                            }
                            if (this.readmsg == 3) {
                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Failed to fetch and load conversation.", 487 - this.ftm.stringWidth("Failed to fetch and load conversation.") / 2, 200);
                            }
                            if (this.readmsg == 4) {
                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Failed to load conversation, server error, please try again later.", 487 - this.ftm.stringWidth("Failed to load conversation, please try again later.") / 2, 200);
                            }
                            if (this.readmsg == 5) {
                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Failed to send message, server error, please try again later.", 487 - this.ftm.stringWidth("Failed to send message, server error, please try again later.") / 2, 200);
                            }
                            this.rd.setColor(color2k(240, 240, 240));
                            this.rd.fillRect(207, 47, 577, 39);
                            this.rd.fillRect(207, 360, 577, 39);
                            this.rd.setColor(color2k(205, 205, 205));
                            this.rd.drawLine(207, 86, 783, 86);
                            this.rd.drawLine(207, 86, 207, 360);
                            this.rd.drawLine(207, 360, 783, 360);
                            this.rd.fillRect(767, 104, 17, 239);
                            if (this.mscro4 == 831 || i_16_ == 0) {
                                if (i_16_ == 0)
                                    this.rd.setColor(color2k(205, 205, 205));
                                else
                                    this.rd.setColor(color2k(215, 215, 215));
                                this.rd.fillRect(767, 87, 17, 17);
                            } else {
                                this.rd.setColor(color2k(220, 220, 220));
                                this.rd.fill3DRect(767, 87, 17, 17, true);
                            }
                            if (i_16_ != 0)
                                this.rd.drawImage((this.xt).asu, 772, 93, null);
                            if (this.mscro4 == 832 || i_16_ == 0) {
                                if (i_16_ == 0)
                                    this.rd.setColor(color2k(205, 205, 205));
                                else
                                    this.rd.setColor(color2k(215, 215, 215));
                                this.rd.fillRect(767, 343, 17, 17);
                            } else {
                                this.rd.setColor(color2k(220, 220, 220));
                                this.rd.fill3DRect(767, 343, 17, 17, true);
                            }
                            if (i_16_ != 0)
                                this.rd.drawImage((this.xt).asd, 772, 350, null);
                            if (i_16_ != 0) {
                                if (this.lspos4 != this.spos4) {
                                    this.rd.setColor(color2k(215, 215, 215));
                                    this.rd.fillRect(767, 104 + this.spos4, 17, 31);
                                } else {
                                    if (this.mscro4 == 831)
                                        this.rd.setColor(color2k(215, 215, 215));
                                    this.rd.fill3DRect(767, 104 + this.spos4, 17, 31, true);
                                }
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(772, 117 + this.spos4, 778, 117 + this.spos4);
                                this.rd.drawLine(772, 119 + this.spos4, 778, 119 + this.spos4);
                                this.rd.drawLine(772, 121 + this.spos4, 778, 121 + this.spos4);
                                if (this.mscro4 > 800 && this.lspos4 != this.spos4)
                                    this.lspos4 = this.spos4;
                                if (bool) {
                                    if (this.mscro4 == 825 && i_0_ > 767 && i_0_ < 784 && i_1_ > 104 + this.spos4 && i_1_ < this.spos4 + 135)
                                        this.mscro4 = i_1_ - this.spos4;
                                    if (this.mscro4 == 825 && i_0_ > 765 && i_0_ < 786 && i_1_ > 85 && i_1_ < 106)
                                        this.mscro4 = 831;
                                    if (this.mscro4 == 825 && i_0_ > 765 && i_0_ < 786 && i_1_ > 341 && i_1_ < 362)
                                        this.mscro4 = 832;
                                    if (this.mscro4 == 825 && i_0_ > 767 && i_0_ < 784 && i_1_ > 104 && i_1_ < 343) {
                                        this.mscro4 = 119;
                                        this.spos4 = i_1_ - this.mscro4;
                                    }
                                    int i_62_ = 2670 / i_16_;
                                    if (i_62_ < 1)
                                        i_62_ = 1;
                                    if (this.mscro4 == 831) {
                                        this.spos4 -= i_62_;
                                        if (this.spos4 > 208)
                                            this.spos4 = 208;
                                        if (this.spos4 < 0)
                                            this.spos4 = 0;
                                        this.lspos4 = this.spos4;
                                    }
                                    if (this.mscro4 == 832) {
                                        this.spos4 += i_62_;
                                        if (this.spos4 > 208)
                                            this.spos4 = 208;
                                        if (this.spos4 < 0)
                                            this.spos4 = 0;
                                        this.lspos4 = this.spos4;
                                    }
                                    if (this.mscro4 < 800) {
                                        this.spos4 = i_1_ - this.mscro4;
                                        if (this.spos4 > 208)
                                            this.spos4 = 208;
                                        if (this.spos4 < 0)
                                            this.spos4 = 0;
                                    }
                                    if (this.mscro4 == 825)
                                        this.mscro4 = 925;
                                } else if (this.mscro4 != 825)
                                    this.mscro4 = 825;
                            }
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            if (!drawl(this.opname, 207, 47, true)) {
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString(this.opname, 267 - this.ftm.stringWidth(this.opname) / 2, 66);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawRect(207, 47, 119, 29);
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString(new StringBuilder().append("::  Conversation with ").append(this.opname).append("").toString(), 336, 72);
                            if (i_0_ > 207 && i_0_ < 327 && i_1_ > 47 && i_1_ < 77) {
                                i_11_ = 12;
                                if (bool) {
                                    this.tab = 1;
                                    if (!this.proname.equals(this.opname)) {
                                        this.proname = this.opname;
                                        this.loadedp = false;
                                        onexitpro();
                                    }
                                }
                            }
                            if (stringbutton("Block / Ignore", 665, 66, 0, i_0_, i_1_, bool)) {
                                this.openc = 0;
                                this.blockname = this.opname;
                            }
                            if (stringbutton("Close X", 752, 66, 0, i_0_, i_1_, bool)) {
                                this.openc = 0;
                                this.readmsg = 0;
                            }
                            if (!(this.gs).sendtyp.isShowing()) {
                                (this.gs).sendtyp.select(0);
                                this.itemsel = 0;
                                (this.gs).sendtyp.show();
                            }
                            (this.gs).sendtyp.move(207, 365);
                            String string = "";
                            if ((this.gs).sendtyp.getSelectedIndex() == 0) {
                                bool_4_ = true;
                                if (this.loaditem != 0)
                                    this.loaditem = 0;
                            }
                            if ((this.gs).sendtyp.getSelectedIndex() == 1) {
                                string = "car";
                                this.rd.setFont(new Font("Arial", 0, 12));
                                this.rd.drawString("Send a public car you have or a private car that belongs to you.", 376, 382);
                            }
                            if ((this.gs).sendtyp.getSelectedIndex() == 2) {
                                string = "stage";
                                this.rd.setFont(new Font("Arial", 0, 12));
                                this.rd.drawString("Send a public stage you have or a private stage that belongs to you.", 376, 382);
                            }
                            if (this.itemsel != (this.gs).sendtyp.getSelectedIndex()) {
                                (this.gs).senditem.hide();
                                this.itemsel = (this.gs).sendtyp.getSelectedIndex();
                            }
                            if ((this.gs).sendtyp.getSelectedIndex() == 1 || (this.gs).sendtyp.getSelectedIndex() == 2) {
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(new StringBuilder().append("Select ").append(string).append(" to share:").toString(), 207, 420);
                                if (!(this.gs).senditem.isShowing()) {
                                    (this.gs).senditem.removeAll();
                                    if ((this.xt).logged) {
                                        (this.gs).senditem.add(this.rd, new StringBuilder().append("Loading your ").append(string).append(" list, please wait...").toString());
                                        this.loaditem = (this.gs).sendtyp.getSelectedIndex();
                                    } else
                                        (this.gs).senditem.add(this.rd, new StringBuilder().append("You a need a full account to access custom ").append(string).append("s!").toString());
                                    (this.gs).senditem.select(0);
                                    (this.gs).senditem.show();
                                }
                                (this.gs).senditem.move(207 + this.ftm.stringWidth(new StringBuilder().append("Select ").append(string).append(" to share:").toString()) + 11, 403);
                                if (this.loaditem == 10 && (this.gs).sendtyp.getSelectedIndex() == 1 || this.loaditem == 20 && (this.gs).sendtyp.getSelectedIndex() == 2 || !(this.xt).logged) {
                                    if ((this.xt).logged) {
                                        if (this.sendmsg == 0) {
                                            if (stringbutton("   Send  >  ", 723, 420, 0, i_0_, i_1_, bool))
                                                this.sendmsg = 1;
                                        } else
                                            this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 420);
                                    } else if (stringbutton("  Upgrade Now  ", 723, 420, 0, i_0_, i_1_, bool))
                                        this.gs.editlink((this.xt).nickname);
                                }
                            } else if (this.sendmsg == 0) {
                                if (stringbutton("   Send  >  ", 723, 408, 0, i_0_, i_1_, bool) && !(this.gs).mmsg.getText().trim().equals("") && (this.gs).mmsg.getText().toLowerCase().indexOf((this.gs).tpass.getText().toLowerCase()) == -1 && (this.xt).acexp != -3) {
                                    if (!this.xt.msgcheck((this.gs).mmsg.getText()))
                                        this.sendmsg = 1;
                                    else {
                                        (this.gs).sendtyp.hide();
                                        (this.xt).warning++;
                                    }
                                }
                            } else {
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                            }
                        }
                        if (this.openc >= 1 && this.openc < 10) {
                            this.rd.setColor(color2k(240, 240, 230));
                            this.rd.fillRoundRect(197, this.opy, 597, this.oph, 20, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(197, this.opy, 597, this.oph, 20, 20);
                            if (!drawl(this.opname, 207, this.opy + 7, true)) {
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString(this.opname, 267 - this.ftm.stringWidth(this.opname) / 2, this.opy + 26);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawRect(207, this.opy + 7, 119, 29);
                            }
                            this.opy += this.addopy;
                            this.oph += 36;
                            this.openc++;
                        }
                    } else {
                        if ((this.gs).sendtyp.isShowing())
                            (this.gs).sendtyp.hide();
                        if ((this.gs).senditem.isShowing())
                            (this.gs).senditem.hide();
                    }
                    if (this.tab != 0 && this.tab != 1 && this.tab != 2) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Coming soon in the next updates, stay tuned...", 495 - this.ftm.stringWidth("Coming soon in the next updates, stay tuned...") / 2, 200);
                    }
                    if (this.ptab == 0) {
                        if (this.npo != -1) {
                            i_16_ = (this.npo - 7) * 50;
                            if (i_16_ < 0)
                                i_16_ = 0;
                            int i_63_ = (int) ((float) this.spos / 345.0F * (float) i_16_);
                            for (int i_64_ = 0; i_64_ < this.npo; i_64_++) {
                                if (57 + 50 * i_64_ - i_63_ > 0 && 57 + 50 * (i_64_ - 1) - i_63_ < 438) {
                                    boolean bool_65_ = false;
                                    if (i_0_ > 26 && i_0_ < 146 && i_1_ > 38 + 50 * i_64_ - i_63_ && i_1_ < 68 + 50 * i_64_ - i_63_) {
                                        bool_65_ = true;
                                        i_11_ = 12;
                                        if (bool) {
                                            this.tab = 1;
                                            if (!this.proname.equals(this.pname[i_64_])) {
                                                this.proname = this.pname[i_64_];
                                                this.loadedp = false;
                                                onexitpro();
                                            }
                                        }
                                    }
                                    boolean bool_66_ = drawl(this.pname[i_64_], 26, 38 + 50 * i_64_ - i_63_, bool_65_);
                                    if (!bool_65_ || !bool_66_) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString(this.pname[i_64_], 86 - this.ftm.stringWidth(this.pname[i_64_]) / 2, 49 + 50 * i_64_ - i_63_);
                                        this.rd.setFont(new Font("Arial", 1, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        String string = "Not in any room...";
                                        if (this.pserver[i_64_] >= 0 && this.pserver[i_64_] <= 2 && this.proom[i_64_] >= 0 && this.proom[i_64_] <= 4) {
                                            string = new StringBuilder().append("").append((this.lg).snames[this.pserver[i_64_]]).append(" :: Room ").append(this.proom[i_64_] + 1).append("").toString();
                                            if (this.roomf[this.pserver[i_64_]][this.proom[i_64_]] >= 10)
                                                this.rd.setColor(new Color(117, 67, 0));
                                            else
                                                this.rd.setColor(new Color(49, 79, 0));
                                        }
                                        this.rd.drawString(string, 86 - this.ftm.stringWidth(string) / 2, 65 + 50 * i_64_ - i_63_);
                                    }
                                    this.rd.setColor(color2k(150, 150, 150));
                                    this.rd.drawLine(5, 77 + 50 * i_64_ - i_63_, 167, 77 + 50 * i_64_ - i_63_);
                                }
                            }
                        } else {
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("Loading Players...", 86 - this.ftm.stringWidth("Loading Players...") / 2, 200);
                        }
                    } else {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Coming soon...", 86 - this.ftm.stringWidth("Coming soon...") / 2, 200);
                        this.rd.setFont(new Font("Arial", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Feature still under construction...", 86 - this.ftm.stringWidth("Feature still under construction...") / 2, 220);
                    }
                } else if (this.open == 452) {
                    this.rd.setColor(color2k(230, 230, 230));
                    this.rd.fillRoundRect(240, 170, 511, 90, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(240, 170, 511, 90, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Failed to connect to server at this time, please exit and try again later.", 495 - this.ftm.stringWidth("Failed to connect to server at this time, please exit and try again later.") / 2, 200);
                    if (stringbutton("  Exit  ", 495, 230, 1, i_0_, i_1_, bool)) {
                        this.open = 450;
                        this.upo = false;
                        this.domon = false;
                    }
                }
                int[] is = { 193, 193, 298, 318 };
                int[] is_67_ = { 33, 13, 13, 33 };
                for (int i_68_ = 0; i_68_ < 4; i_68_++) {
                    if (this.tab == i_68_)
                        this.rd.setColor(color2k(255, 255, 255));
                    else
                        this.rd.setColor(color2k(200, 200, 200));
                    if (i_1_ >= 12 && i_1_ <= 32 && i_0_ > is[0] && i_0_ < is[3] && this.tab != i_68_) {
                        this.rd.setColor(color2k(227, 227, 227));
                        if (bool) {
                            this.tab = i_68_;
                            if (this.tab == 1 && this.proname.equals("")) {
                                this.proname = (this.xt).nickname;
                                this.loadedp = false;
                                onexitpro();
                            }
                        }
                    }
                    this.rd.fillPolygon(is, is_67_, 4);
                    for (int i_69_ = 0; i_69_ < 4; i_69_++)
                        is[i_69_] += 125;
                }
                this.rd.drawImage((this.xt).cnmc, 224, 15, null);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawLine(191, 34, 800, 34);
                this.rd.setColor(color2k(200, 200, 200));
                this.rd.fillRect(0, 0, 190, 28);
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawLine(0, 25, 170, 25);
                this.rd.setColor(color2k(200, 200, 200));
                this.rd.fillRect(0, 438, 190, 12);
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawLine(0, 440, 170, 440);
                this.rd.setColor(color2k(200, 200, 200));
                this.rd.fillRect(173, 28, 17, 410);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawLine(191, 0, 191, 450);
                if (i_0_ > 0 && i_0_ < 171 && i_1_ > 2 && i_1_ < 23) {
                    if (!this.onp) {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fillRect(2, 2, 146, 21);
                    }
                    this.rd.setColor(color2k(255, 255, 255));
                    if (bool && this.overit == 0 && !this.onp) {
                        this.onp = true;
                        this.overit = 5;
                    }
                    if (this.overit < 0)
                        this.overit++;
                } else
                    this.rd.setColor(color2k(235, 235, 235));
                this.rd.fillRect(150, 2, 20, 20);
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawRect(150, 2, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawLine(157, 10, 157, 11);
                this.rd.drawLine(158, 11, 158, 12);
                this.rd.drawLine(159, 12, 159, 13);
                this.rd.drawLine(160, 13, 160, 14);
                this.rd.drawLine(161, 12, 161, 13);
                this.rd.drawLine(162, 11, 162, 12);
                this.rd.drawLine(163, 10, 163, 11);
                if (this.ptab == 0)
                    this.rd.drawImage((this.xt).players, 7, 5, null);
                if (this.ptab == 1)
                    this.rd.drawImage((this.xt).myfr, 21, 4, null);
                if (this.ptab == 2)
                    this.rd.drawImage((this.xt).mycl, 34, 4, null);
                if (this.onp) {
                    this.rd.setColor(color2k(200, 200, 200));
                    this.rd.fillRect(0, 25, 170, 67);
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawRect(0, 25, 170, 67);
                    if (i_0_ > 0 && i_0_ < 171 && i_1_ >= 26 && i_1_ < 48) {
                        this.rd.setColor(color2k(235, 235, 235));
                        this.rd.fillRect(1, 26, 169, 22);
                        if (bool)
                            this.ptab = 0;
                    }
                    if (i_0_ > 0 && i_0_ < 171 && i_1_ >= 48 && i_1_ < 70) {
                        this.rd.setColor(color2k(235, 235, 235));
                        this.rd.fillRect(1, 48, 169, 22);
                        if (bool)
                            this.ptab = 1;
                    }
                    if (i_0_ > 0 && i_0_ < 171 && i_1_ >= 70 && i_1_ < 92) {
                        this.rd.setColor(color2k(235, 235, 235));
                        this.rd.fillRect(1, 70, 169, 22);
                        if (bool)
                            this.ptab = 2;
                    }
                    this.rd.drawImage((this.xt).players, 7, 30, null);
                    this.rd.drawImage((this.xt).myfr, 21, 51, null);
                    this.rd.drawImage((this.xt).mycl, 34, 73, null);
                    if (bool && this.overit == 0) {
                        this.onp = false;
                        this.overit = -5;
                    }
                    if (this.overit > 0)
                        this.overit--;
                }
                if (this.mscro == 831 || i_16_ == 0) {
                    if (i_16_ == 0)
                        this.rd.setColor(color2k(205, 205, 205));
                    else
                        this.rd.setColor(color2k(215, 215, 215));
                    this.rd.fillRect(173, 28, 17, 17);
                } else {
                    this.rd.setColor(color2k(220, 220, 220));
                    this.rd.fill3DRect(173, 28, 17, 17, true);
                }
                if (i_16_ != 0)
                    this.rd.drawImage((this.xt).asu, 178, 34, null);
                if (this.mscro == 832 || i_16_ == 0) {
                    if (i_16_ == 0)
                        this.rd.setColor(color2k(205, 205, 205));
                    else
                        this.rd.setColor(color2k(215, 215, 215));
                    this.rd.fillRect(173, 421, 17, 17);
                } else {
                    this.rd.setColor(color2k(220, 220, 220));
                    this.rd.fill3DRect(173, 421, 17, 17, true);
                }
                if (i_16_ != 0)
                    this.rd.drawImage((this.xt).asd, 178, 428, null);
                if (i_16_ != 0) {
                    if (this.lspos != this.spos) {
                        this.rd.setColor(color2k(215, 215, 215));
                        this.rd.fillRect(173, 45 + this.spos, 17, 31);
                    } else {
                        if (this.mscro == 831)
                            this.rd.setColor(color2k(215, 215, 215));
                        this.rd.fill3DRect(173, 45 + this.spos, 17, 31, true);
                    }
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawLine(178, 58 + this.spos, 184, 58 + this.spos);
                    this.rd.drawLine(178, 60 + this.spos, 184, 60 + this.spos);
                    this.rd.drawLine(178, 62 + this.spos, 184, 62 + this.spos);
                    if (this.mscro > 800 && this.lspos != this.spos)
                        this.lspos = this.spos;
                    if (bool) {
                        if (this.mscro == 825 && i_0_ > 173 && i_0_ < 190 && i_1_ > 45 + this.spos && i_1_ < this.spos + 76)
                            this.mscro = i_1_ - this.spos;
                        if (this.mscro == 825 && i_0_ > 171 && i_0_ < 192 && i_1_ > 26 && i_1_ < 47)
                            this.mscro = 831;
                        if (this.mscro == 825 && i_0_ > 171 && i_0_ < 192 && i_1_ > 419 && i_1_ < 440)
                            this.mscro = 832;
                        if (this.mscro == 825 && i_0_ > 173 && i_0_ < 190 && i_1_ > 45 && i_1_ < 421) {
                            this.mscro = 60;
                            this.spos = i_1_ - this.mscro;
                        }
                        int i_70_ = 2670 / i_16_;
                        if (i_70_ < 1)
                            i_70_ = 1;
                        if (this.mscro == 831) {
                            this.spos -= i_70_;
                            if (this.spos > 345)
                                this.spos = 345;
                            if (this.spos < 0)
                                this.spos = 0;
                            this.lspos = this.spos;
                        }
                        if (this.mscro == 832) {
                            this.spos += i_70_;
                            if (this.spos > 345)
                                this.spos = 345;
                            if (this.spos < 0)
                                this.spos = 0;
                            this.lspos = this.spos;
                        }
                        if (this.mscro < 800) {
                            this.spos = i_1_ - this.mscro;
                            if (this.spos > 345)
                                this.spos = 345;
                            if (this.spos < 0)
                                this.spos = 0;
                        }
                        if (this.mscro == 825)
                            this.mscro = 925;
                    } else if (this.mscro != 825)
                        this.mscro = 825;
                }
                if (i_11_ != this.curs) {
                    this.gs.setCursor(new Cursor(i_11_));
                    this.curs = i_11_;
                }
            } else {
                this.xt.drawWarning();
                if ((this.gs).cmsg.isShowing()) {
                    (this.gs).cmsg.hide();
                    this.gs.requestFocus();
                }
                if ((this.xt).warning > 220) {
                    boolean bool_71_ = false;
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
        }
        if (bool_2_) {
            if (!(this.gs).cmsg.isShowing()) {
                (this.gs).cmsg.show();
                (this.gs).cmsg.requestFocus();
                this.prereq = 2;
            }
            this.gs.movefield((this.gs).cmsg, 207, 414, 462, 22);
            if ((this.gs).cmsg.getText().equals("Type here...") && i_0_ > 197 && i_0_ < 679 && i_1_ > 404 && i_1_ < 446)
                (this.gs).cmsg.setText("");
            if ((this.gs).cmsg.getText().length() > 200) {
                (this.gs).cmsg.setText((this.gs).cmsg.getText().substring(0, 200));
                (this.gs).cmsg.select(200, 200);
            }
        }
        if (bool_3_) {
            if (!(this.gs).cmsg.isShowing()) {
                (this.gs).cmsg.show();
                (this.gs).cmsg.setText(this.sentance);
                (this.gs).cmsg.requestFocus();
            }
            this.gs.movefield((this.gs).cmsg, 275, 91, 440, 22);
            if (!this.sentance.equals((this.gs).cmsg.getText())) {
                this.sentchange = 1;
                this.rd.setFont(new Font("Tahoma", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                if (this.ftm.stringWidth((this.gs).cmsg.getText()) > 800)
                    (this.gs).cmsg.setText(this.sentance);
                else
                    this.sentance = (this.gs).cmsg.getText();
            }
        }
        if (bool_4_) {
            if (!(this.gs).mmsg.isShowing()) {
                (this.gs).mmsg.show();
                (this.gs).mmsg.setText(" ");
                (this.gs).mmsg.requestFocus();
            }
            this.gs.movefield((this.gs).mmsg, 207, 389, 450, 50);
        } else if ((this.gs).mmsg.isShowing())
            (this.gs).mmsg.hide();
        if (this.prereq != 0) {
            if (this.prereq == 1)
                this.gs.requestFocus();
            this.prereq--;
        }
    }
    
    public void run() {
        try {
            this.socket = new Socket((this.lg).servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
        } catch (Exception exception) {
            this.domon = false;
        }
        while (this.domon) {
            String string = "";
            String string_72_ = "";
            string = new StringBuilder().append("101|100|").append((this.xt).nickname).append(":").append((this.xt).nickey).append("|").toString();
            try {
                this.dout.println(string);
                string_72_ = this.din.readLine();
                if (string_72_ == null)
                    this.domon = false;
            } catch (Exception exception) {
                this.domon = false;
            }
            if (this.domon) {
                this.ntime = getLvalue(string_72_, 0);
                for (int i = 0; i < 3; i++) {
                    for (int i_73_ = 0; i_73_ < 5; i_73_++)
                        this.roomf[i][i_73_] = 0;
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
                            this.pname[i] = string_75_;
                            this.proom[i] = i_76_;
                            this.pserver[i] = i_77_;
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
                            this.roomf[i_80_][i_79_]++;
                            if (i < 900) {
                                this.pname[i] = string_78_;
                                this.proom[i] = i_79_;
                                this.pserver[i] = i_80_;
                                i++;
                            }
                        }
                    } else
                        bool = true;
                    i_74_ += 3;
                }
                this.npo = i;
            }
            if (this.sentchange == 2 && this.domon) {
                string = new StringBuilder().append("101|5|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(this.sentance).append("|").toString();
                try {
                    this.dout.println(string);
                    string_72_ = this.din.readLine();
                } catch (Exception exception) {
                    /* empty */
                }
                this.sentchange = 0;
            }
            if (this.tab == 2 && this.domon) {
                if (!this.blockname.equals("")) {
                    for (int i = 0; i < this.nm; i++) {
                        if (this.mname[i].equals(this.blockname)) {
                            this.mtyp[i] = 3;
                            break;
                        }
                    }
                    try {
                        string = new StringBuilder().append("101|11|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(this.blockname).append("|").toString();
                        this.dout.println(string);
                        string_72_ = this.din.readLine();
                    } catch (Exception exception) {
                        /* empty */
                    }
                    this.blockname = "";
                }
                if (!this.unblockname.equals("")) {
                    for (int i = 0; i < this.nm; i++) {
                        if (this.mname[i].equals(this.unblockname)) {
                            this.mtyp[i] = 0;
                            break;
                        }
                    }
                    try {
                        string = new StringBuilder().append("101|12|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(this.unblockname).append("|").toString();
                        this.dout.println(string);
                        string_72_ = this.din.readLine();
                    } catch (Exception exception) {
                        /* empty */
                    }
                    this.unblockname = "";
                }
                try {
                    Socket socket = new Socket((this.lg).servers[0], 7061);
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    DataInputStream datainputstream = new DataInputStream(socket.getInputStream());
                    string = new StringBuilder().append("101|13|").append((this.xt).nickname).append("|").append((this.xt).nickey).append("|").append(this.loadmsgs).append("|").toString();
                    printwriter.println(string);
                    string_72_ = bufferedreader.readLine();
                    if (string_72_.startsWith("MSGS")) {
                        String string_81_ = "";
                        this.nm = 0;
                        boolean bool = false;
                        while (!bool && (string_81_ = datainputstream.readLine()) != null && this.nm < 200) {
                            if (!string_81_.equals("||XENDX||")) {
                                this.mname[this.nm] = getSvalue(string_81_, 0);
                                this.mtyp[this.nm] = getvalue(string_81_, 1);
                                this.mconvo[this.nm] = getSvalue(string_81_, 2);
                                this.msub[this.nm] = getSvalue(string_81_, 3);
                                this.mctime[this.nm] = getLvalue(string_81_, 4);
                                this.mtime[this.nm] = "";
                                this.nm++;
                            } else
                                bool = true;
                        }
                        this.loadmsgs = getvalue(string_72_, 1);
                    } else if (string_72_.equals("NOMSGS"))
                        this.loadmsgs = 0;
                    try {
                        socket.close();
                        Object object = null;
                        datainputstream.close();
                        Object object_82_ = null;
                        bufferedreader.close();
                        Object object_83_ = null;
                        printwriter.close();
                        Object object_84_ = null;
                    } catch (Exception exception) {
                        /* empty */
                    }
                } catch (Exception exception) {
                    this.loadmsgs = -2;
                }
                if (this.loadmsgs > 0) {
                    for (int i = 0; i < this.nm; i++) {
                        if (this.mctime[i] > 0L) {
                            try {
                                long l = this.ntime - this.mctime[i];
                                String string_85_ = "Received";
                                if (this.mtyp[i] == 2)
                                    string_85_ = "Sent";
                                if (l >= 1000L && l < 60000L)
                                    this.mtime[i] = new StringBuilder().append("").append(string_85_).append(" seconds ago").toString();
                                if (l >= 60000L && l < 3600000L) {
                                    int i_86_ = (int) (l / 60000L);
                                    String string_87_ = "s";
                                    if (i_86_ == 1)
                                        string_87_ = "";
                                    this.mtime[i] = new StringBuilder().append("").append(string_85_).append(" ").append(i_86_).append(" minute").append(string_87_).append(" ago").toString();
                                }
                                if (l >= 3600000L && l < 86400000L) {
                                    int i_88_ = (int) (l / 3600000L);
                                    String string_89_ = "s";
                                    if (i_88_ == 1)
                                        string_89_ = "";
                                    this.mtime[i] = new StringBuilder().append("").append(string_85_).append(" ").append(i_88_).append(" hour").append(string_89_).append(" ago").toString();
                                }
                                if (l >= 86400000L) {
                                    int i_90_ = (int) (l / 86400000L);
                                    String string_91_ = "s";
                                    if (i_90_ == 1)
                                        string_91_ = "";
                                    this.mtime[i] = new StringBuilder().append("").append(string_85_).append(" ").append(i_90_).append(" day").append(string_91_).append(" ago").toString();
                                }
                            } catch (Exception exception) {
                                this.mtime[i] = "";
                            }
                        } else
                            this.mtime[i] = "";
                    }
                }
                if (this.openc != 0) {
                    boolean bool = false;
                    int i = -1;
                    for (int i_92_ = 0; i_92_ < this.nm; i_92_++) {
                        if (this.mname[i_92_].equals(this.opname)) {
                            i = i_92_;
                            break;
                        }
                    }
                    if (i != -1 && this.readmsg != 3 && this.readmsg != 4 && this.readmsg != 5) {
                        if (!this.msub[i].equals(this.lastsub)) {
                            bool = true;
                            this.readmsg = 1;
                        } else
                            this.readmsg = 2;
                    } else {
                        this.lastsub = "";
                        if (this.readmsg == 1) {
                            this.readmsg = 0;
                            this.nml = 0;
                        }
                    }
                    if (bool) {
                        try {
                            Socket socket = new Socket((this.lg).servers[0], 7061);
                            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                            DataInputStream datainputstream = new DataInputStream(socket.getInputStream());
                            string = new StringBuilder().append("101|8|").append((this.xt).nickname).append("|").append((this.xt).nickey).append("|").append(this.mconvo[i]).append("").toString();
                            printwriter.println(string);
                            string_72_ = bufferedreader.readLine();
                            if (string_72_.equals("RECIVE")) {
                                String string_93_ = "";
                                boolean bool_94_ = false;
                                for (int i_95_ = 0; i_95_ < this.nml; i_95_++) {
                                    this.mline[i_95_] = null;
                                    this.mlinetyp[i_95_] = 0;
                                    this.mctimes[i_95_] = 0L;
                                    this.mtimes[i_95_] = null;
                                }
                                this.nml = 0;
                                (this.cd).acname = "";
                                (this.cd).action = 0;
                                (this.cd).onstage = "";
                                this.addstage = 0;
                                while (!bool_94_ && (string_93_ = datainputstream.readLine()) != null) {
                                    if (!string_93_.equals("||XENDX||")) {
                                        if (string_93_.startsWith("|")) {
                                            if (this.nml != 0) {
                                                this.mline[this.nml] = "";
                                                this.mlinetyp[this.nml] = 167;
                                                this.nml++;
                                            }
                                            String string_96_ = getSvalue(string_93_, 1);
                                            if (string_96_.toLowerCase().equals((this.xt).nickname.toLowerCase()))
                                                string_96_ = "You";
                                            this.mlinetyp[this.nml] = getvalue(string_93_, 2);
                                            int i_97_ = this.mlinetyp[this.nml];
                                            if (i_97_ == 0) {
                                                this.mline[this.nml] = new StringBuilder().append("").append(string_96_).append(" wrote:").toString();
                                                this.mctimes[this.nml] = getLvalue(string_93_, 3);
                                                this.mtimes[this.nml] = "";
                                                this.nml++;
                                            }
                                            if (i_97_ == 1) {
                                                this.mline[this.nml] = new StringBuilder().append("").append(string_96_).append(" shared a car:").toString();
                                                this.mctimes[this.nml] = getLvalue(string_93_, 3);
                                                this.mtimes[this.nml] = "";
                                                this.nml++;
                                                this.mline[this.nml] = getSvalue(string_93_, 4);
                                                this.mlinetyp[this.nml] = 10;
                                                this.nml++;
                                                this.mline[this.nml] = "";
                                                this.mlinetyp[this.nml] = 167;
                                                this.nml++;
                                            }
                                            if (i_97_ == 2) {
                                                this.mline[this.nml] = new StringBuilder().append("").append(string_96_).append(" shared a stage:").toString();
                                                this.mctimes[this.nml] = getLvalue(string_93_, 3);
                                                this.mtimes[this.nml] = "";
                                                this.nml++;
                                                this.mline[this.nml] = getSvalue(string_93_, 4);
                                                this.mlinetyp[this.nml] = 20;
                                                this.nml++;
                                                this.mline[this.nml] = "";
                                                this.mlinetyp[this.nml] = 167;
                                                this.nml++;
                                            }
                                        } else {
                                            this.mline[this.nml] = string_93_;
                                            try {
                                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                                this.ftm = this.rd.getFontMetrics();
                                                int i_98_ = 0;
                                                String string_99_ = "";
                                                for (/**/; i_98_ < string_93_.length(); i_98_++) {
                                                    string_99_ = new StringBuilder().append(string_99_).append(string_93_.charAt(i_98_)).toString();
                                                    if (this.ftm.stringWidth(string_99_) > 540) {
                                                        if (string_99_.lastIndexOf(" ") != -1) {
                                                            this.mline[this.nml] = string_99_.substring(0, string_99_.lastIndexOf(" "));
                                                            string_99_ = string_99_.substring(string_99_.lastIndexOf(" ") + 1, string_99_.length());
                                                        } else {
                                                            this.mline[this.nml] = string_99_;
                                                            string_99_ = "";
                                                        }
                                                        this.mlinetyp[this.nml] = -1;
                                                        this.nml++;
                                                    }
                                                }
                                                this.mline[this.nml] = string_99_;
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                            this.mlinetyp[this.nml] = -1;
                                            this.nml++;
                                        }
                                    } else
                                        bool_94_ = true;
                                }
                                this.readmsg = 2;
                                this.lastsub = this.msub[i];
                                if (this.mtyp[i] == 1) {
                                    this.mtyp[i] = 0;
                                    try {
                                        this.dout.println(new StringBuilder().append("101|10|").append((this.xt).nickname).append("|").append(this.opname).append("|").toString());
                                        string_72_ = this.din.readLine();
                                    } catch (Exception exception) {
                                        /* empty */
                                    }
                                }
                                this.spos4 = 208;
                            } else
                                this.readmsg = 3;
                            try {
                                socket.close();
                                Object object = null;
                                datainputstream.close();
                                Object object_100_ = null;
                                bufferedreader.close();
                                Object object_101_ = null;
                                printwriter.close();
                                Object object_102_ = null;
                            } catch (Exception exception) {
                                /* empty */
                            }
                        } catch (Exception exception) {
                            this.readmsg = 4;
                        }
                    }
                    if (this.readmsg == 2) {
                        for (int i_103_ = 0; i_103_ < this.nml; i_103_++) {
                            if ((this.mlinetyp[i_103_] == 0 || this.mlinetyp[i_103_] == 1 || this.mlinetyp[i_103_] == 2) && this.mctimes[i_103_] > 0L) {
                                try {
                                    long l = this.ntime - this.mctimes[i_103_];
                                    if (l >= 1000L && l < 60000L)
                                        this.mtimes[i_103_] = "seconds ago";
                                    if (l >= 60000L && l < 3600000L) {
                                        int i_104_ = (int) (l / 60000L);
                                        String string_105_ = "s";
                                        if (i_104_ == 1)
                                            string_105_ = "";
                                        this.mtimes[i_103_] = new StringBuilder().append("").append(i_104_).append(" minute").append(string_105_).append(" ago").toString();
                                    }
                                    if (l >= 3600000L && l < 86400000L) {
                                        int i_106_ = (int) (l / 3600000L);
                                        String string_107_ = "s";
                                        if (i_106_ == 1)
                                            string_107_ = "";
                                        this.mtimes[i_103_] = new StringBuilder().append("").append(i_106_).append(" hour").append(string_107_).append(" ago").toString();
                                    }
                                    if (l >= 86400000L) {
                                        int i_108_ = (int) (l / 86400000L);
                                        String string_109_ = "s";
                                        if (i_108_ == 1)
                                            string_109_ = "";
                                        this.mtimes[i_103_] = new StringBuilder().append("").append(i_108_).append(" day").append(string_109_).append(" ago").toString();
                                    }
                                } catch (Exception exception) {
                                    this.mtimes[i_103_] = "";
                                }
                            } else
                                this.mtimes[i_103_] = "";
                        }
                    }
                }
                if (this.sendmsg == 2) {
                    (this.gs).mmsg.setText(" ");
                    this.sendmsg = 0;
                }
                if (this.openc == 10) {
                    if (this.loaditem == 1) {
                        int i = 0;
                        String[] strings = new String[20];
                        try {
                            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/cars/lists/").append((this.gs).tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
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
                            (this.gs).senditem.removeAll();
                            (this.gs).senditem.add(this.rd, "Failed to load your cars, please try again later.");
                            this.loaditem = 0;
                        }
                        if (i == 0) {
                            (this.gs).senditem.removeAll();
                            (this.gs).senditem.add(this.rd, "You have no added or published cars to load.");
                            this.loaditem = 0;
                        }
                        if (i > 0) {
                            String[] strings_112_ = new String[20];
                            int i_113_ = 0;
                            for (int i_114_ = 0; i_114_ < i; i_114_++) {
                                (this.gs).senditem.removeAll();
                                (this.gs).senditem.add(this.rd, new StringBuilder().append("Loading shareable cars,  ").append((int) ((float) i_114_ / (float) i * 100.0F)).append(" %").toString());
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
                                            if (i_118_ > 0 || string_117_.toLowerCase().equals((this.gs).tnick.getText().toLowerCase())) {
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
                            (this.gs).senditem.removeAll();
                            if (i_113_ > 0) {
                                for (int i_119_ = 0; i_119_ < i_113_; i_119_++)
                                    (this.gs).senditem.add(this.rd, strings_112_[i_119_]);
                                this.loaditem = 10;
                            } else {
                                (this.gs).senditem.add(this.rd, "You have no cars that can be shared.");
                                this.loaditem = 0;
                            }
                        }
                    }
                    if (this.loaditem == 2) {
                        int i = 0;
                        String[] strings = new String[20];
                        try {
                            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/tracks/lists/").append((this.gs).tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
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
                            (this.gs).senditem.removeAll();
                            (this.gs).senditem.add(this.rd, "Failed to load your stages, please try again later.");
                            this.loaditem = 0;
                        }
                        if (i == 0) {
                            (this.gs).senditem.removeAll();
                            (this.gs).senditem.add(this.rd, "You have no added or published stages to load.");
                            this.loaditem = 0;
                        }
                        if (i > 0) {
                            String[] strings_122_ = new String[20];
                            int i_123_ = 0;
                            for (int i_124_ = 0; i_124_ < i; i_124_++) {
                                (this.gs).senditem.removeAll();
                                (this.gs).senditem.add(this.rd, new StringBuilder().append("Loading shareable stages,  ").append((int) ((float) i_124_ / (float) i * 100.0F)).append(" %").toString());
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
                                            if (i_128_ > 0 || string_127_.toLowerCase().equals((this.gs).tnick.getText().toLowerCase())) {
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
                            (this.gs).senditem.removeAll();
                            if (i_123_ > 0) {
                                for (int i_129_ = 0; i_129_ < i_123_; i_129_++)
                                    (this.gs).senditem.add(this.rd, strings_122_[i_129_]);
                                this.loaditem = 20;
                            } else {
                                (this.gs).senditem.add(this.rd, "You have no stages that can be shared.");
                                this.loaditem = 0;
                            }
                        }
                    }
                    if (this.sendmsg == 1) {
                        try {
                            String string_130_ = "#nada#";
                            for (int i = 0; i < this.nm; i++) {
                                if (this.mname[i].equals(this.opname)) {
                                    string_130_ = this.mconvo[i];
                                    break;
                                }
                            }
                            string = new StringBuilder().append("101|9|").append((this.xt).nickname).append("|").append((this.xt).nickey).append("|").append(this.opname).append("|").append(string_130_).append("|").append((this.gs).sendtyp.getSelectedIndex()).append("|").toString();
                            if ((this.gs).sendtyp.getSelectedIndex() == 0) {
                                String string_131_ = (this.gs).mmsg.getText().replace("|", ":");
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
                            if ((this.gs).sendtyp.getSelectedIndex() == 1 || (this.gs).sendtyp.getSelectedIndex() == 2)
                                string = new StringBuilder().append(string).append("").append((this.gs).senditem.getSelectedItem()).append("|").toString();
                            this.dout.println(string);
                            string_72_ = this.din.readLine();
                            if (string_72_.equals("OK"))
                                this.sendmsg = 2;
                            else {
                                this.readmsg = 5;
                                this.sendmsg = 0;
                            }
                        } catch (Exception exception) {
                            this.readmsg = 5;
                            this.sendmsg = 0;
                        }
                    }
                }
            }
            if (this.tab == 0 && this.domon) {
                string = new StringBuilder().append("101|101|").append(this.updatec).append("|").toString();
                if (this.updatec <= -11) {
                    for (int i = 0; i < -this.updatec - 10; i++)
                        string = new StringBuilder().append(string).append("").append(this.cnames[20 - i]).append("|").append(this.sentn[20 - i]).append("|").toString();
                    this.updatec = -2;
                }
                try {
                    this.dout.println(string);
                    string_72_ = this.din.readLine();
                    if (string_72_ == null)
                        this.domon = false;
                } catch (Exception exception) {
                    this.domon = false;
                }
                if (this.domon) {
                    int i = getvalue(string_72_, 0);
                    if (this.updatec != i && this.updatec >= -2) {
                        for (int i_135_ = 0; i_135_ < 21; i_135_++) {
                            this.cnames[i_135_] = getSvalue(string_72_, 1 + i_135_ * 3);
                            this.sentn[i_135_] = getSvalue(string_72_, 2 + i_135_ * 3);
                            this.nctime[i_135_] = getLvalue(string_72_, 3 + i_135_ * 3);
                        }
                        this.updatec = i;
                    }
                    for (int i_136_ = 0; i_136_ < 21; i_136_++) {
                        if (this.nctime[i_136_] > 0L) {
                            long l = this.ntime - this.nctime[i_136_];
                            if (l < 1000L)
                                this.ctime[i_136_] = "- just now";
                            if (l >= 1000L && l < 60000L)
                                this.ctime[i_136_] = "- seconds ago";
                            if (l >= 60000L && l < 3600000L) {
                                int i_137_ = (int) (l / 60000L);
                                String string_138_ = "s";
                                if (i_137_ == 1)
                                    string_138_ = "";
                                this.ctime[i_136_] = new StringBuilder().append("- ").append(i_137_).append(" minute").append(string_138_).append(" ago").toString();
                            }
                            if (l >= 3600000L && l < 86400000L) {
                                int i_139_ = (int) (l / 3600000L);
                                String string_140_ = "s";
                                if (i_139_ == 1)
                                    string_140_ = "";
                                this.ctime[i_136_] = new StringBuilder().append("- ").append(i_139_).append(" hour").append(string_140_).append(" ago").toString();
                            }
                            if (l >= 86400000L) {
                                int i_141_ = (int) (l / 86400000L);
                                String string_142_ = "s";
                                if (i_141_ == 1)
                                    string_142_ = "";
                                this.ctime[i_136_] = new StringBuilder().append("- ").append(i_141_).append(" day").append(string_142_).append(" ago").toString();
                            }
                        } else
                            this.ctime[i_136_] = "";
                    }
                }
            }
            if (this.tab == 1) {
                if (this.upload == 5) {
                    this.upload = 0;
                    this.loadedp = false;
                    this.edit = 0;
                    this.refresh = true;
                }
                if (!this.loadedp) {
                    if (!this.refresh) {
                        loadproinfo();
                        trunsent();
                    }
                    logopng();
                    clanlogopng();
                    avatarpng();
                    this.refresh = false;
                    this.loadedp = true;
                }
            }
            if (this.upload != 0) {
                if (this.filename.toLowerCase().endsWith(".gif") || this.filename.toLowerCase().endsWith(".jpg") || this.filename.toLowerCase().endsWith(".jpeg") || this.filename.toLowerCase().endsWith(".png")) {
                    File file = new File(this.filename);
                    if (file.exists()) {
                        int i = (int) file.length();
                        if (i < 1048576) {
                            if (this.upload != 0) {
                                this.upload = 2;
                                try {
                                    int i_143_ = 2;
                                    if (this.edit == 2)
                                        i_143_ = 3;
                                    string = new StringBuilder().append("101|").append(i_143_).append("|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(i).append("|").toString();
                                    this.dout.println(string);
                                    string_72_ = this.din.readLine();
                                    if (string_72_.equals("OK")) {
                                        FileInputStream fileinputstream = new FileInputStream(file);
                                        byte[] is = new byte[i];
                                        fileinputstream.read(is);
                                        fileinputstream.close();
                                        DataOutputStream dataoutputstream = new DataOutputStream(this.socket.getOutputStream());
                                        if (this.upload != 0)
                                            this.upload = 3;
                                        this.perc = 0;
                                        int i_144_ = 0;
                                        while (i_144_ < i && this.upload != 0) {
                                            int i_145_ = 10240;
                                            if (i_144_ + i_145_ > i)
                                                i_145_ = i - i_144_;
                                            dataoutputstream.write(is, i_144_, i_145_);
                                            i_144_ += i_145_;
                                            this.perc = (int) ((float) i_144_ / (float) i * 100.0F);
                                        }
                                        if (this.upload != 0) {
                                            string_72_ = this.din.readLine();
                                            if (string_72_.equals("CR"))
                                                this.upload = 4;
                                            else {
                                                this.msg = "Failed to create image online, server error!";
                                                this.flko = 45;
                                                this.upload = 0;
                                            }
                                            string_72_ = this.din.readLine();
                                            if (string_72_.equals("OK"))
                                                this.upload = 5;
                                        } else {
                                            try {
                                                this.socket.close();
                                                this.socket = null;
                                                this.din.close();
                                                this.din = null;
                                                this.dout.close();
                                                this.dout = null;
                                                this.connector = null;
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                            try {
                                                this.socket = new Socket((this.lg).servers[0], 7061);
                                                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                        }
                                    } else {
                                        this.msg = "Failed to authenticate to start an uploading connection!";
                                        this.flko = 45;
                                        this.upload = 0;
                                    }
                                } catch (Exception exception) {
                                    this.msg = "Failed to upload image, unknown error!";
                                    this.flko = 45;
                                    this.upload = 0;
                                    try {
                                        this.socket.close();
                                        this.socket = null;
                                        this.din.close();
                                        this.din = null;
                                        this.dout.close();
                                        this.dout = null;
                                        this.connector = null;
                                    } catch (Exception exception_146_) {
                                        /* empty */
                                    }
                                    try {
                                        this.socket = new Socket((this.lg).servers[0], 7061);
                                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                    } catch (Exception exception_147_) {
                                        /* empty */
                                    }
                                }
                            }
                        } else {
                            this.msg = "Uploaded image must be less than 1MB in size!";
                            this.flko = 45;
                            this.upload = 0;
                        }
                    } else {
                        this.msg = "The file chosen is invalid or does not exist!";
                        this.flko = 45;
                        this.upload = 0;
                    }
                } else {
                    this.msg = "Uploaded image must be JPEG, GIF or PNG!";
                    this.flko = 45;
                    this.upload = 0;
                }
            }
            if (this.uploadt == 5) {
                this.uploadt = 0;
                this.msg = "";
            }
            if (this.uploadt != 0) {
                File file = new File(this.filename);
                if (file.exists()) {
                    int i = (int) file.length();
                    if (i < 256000) {
                        (this.xt).strack = new RadicalMod(this.filename, true);
                        if (((this.xt).strack).loaded == 2) {
                            this.trackvol = (int) (220.0F / ((float) ((this.xt).strack).rvol / 3750.0F));
                            (this.xt).strack.unload();
                            if (this.uploadt != 0) {
                                this.uploadt = 2;
                                try {
                                    string = new StringBuilder().append("101|4|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(this.trackname).append("|").append(this.trackvol).append("|").append(i).append("|").toString();
                                    this.dout.println(string);
                                    string_72_ = this.din.readLine();
                                    if (string_72_.equals("OK")) {
                                        string_72_ = this.din.readLine();
                                        if (this.uploadt != 0) {
                                            if (string_72_.equals("UPLOAD")) {
                                                this.uploadt = 3;
                                                FileInputStream fileinputstream = new FileInputStream(file);
                                                byte[] is = new byte[i];
                                                fileinputstream.read(is);
                                                fileinputstream.close();
                                                DataOutputStream dataoutputstream = new DataOutputStream(this.socket.getOutputStream());
                                                dataoutputstream.write(is, 0, i);
                                                this.uploadt = 4;
                                                string_72_ = this.din.readLine();
                                            }
                                            if (string_72_.equals("FOUND")) {
                                                this.uploadt = 4;
                                                string_72_ = this.din.readLine();
                                            }
                                            if (string_72_.equals("OK")) {
                                                this.themesong = this.trackname;
                                                this.uploadt = 5;
                                            } else if (string_72_.equals("EXIST")) {
                                                this.msg = "Another track with the same name already exists, please rename you file!";
                                                this.flko = 45;
                                                this.uploadt = 0;
                                            } else {
                                                this.msg = "Failed to add MOD Track to your profile, unknown error!";
                                                this.flko = 45;
                                                this.uploadt = 0;
                                            }
                                        } else {
                                            try {
                                                this.socket.close();
                                                this.socket = null;
                                                this.din.close();
                                                this.din = null;
                                                this.dout.close();
                                                this.dout = null;
                                                this.connector = null;
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                            try {
                                                this.socket = new Socket((this.lg).servers[0], 7061);
                                                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                            } catch (Exception exception) {
                                                /* empty */
                                            }
                                        }
                                    } else {
                                        this.msg = "Failed to authenticate to start an uploading connection!";
                                        this.flko = 45;
                                        this.uploadt = 0;
                                    }
                                } catch (Exception exception) {
                                    this.msg = "Failed to upload track, unknown error!";
                                    this.flko = 45;
                                    this.uploadt = 0;
                                    try {
                                        this.socket.close();
                                        this.socket = null;
                                        this.din.close();
                                        this.din = null;
                                        this.dout.close();
                                        this.dout = null;
                                        this.connector = null;
                                    } catch (Exception exception_148_) {
                                        /* empty */
                                    }
                                    try {
                                        this.socket = new Socket((this.lg).servers[0], 7061);
                                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                    } catch (Exception exception_149_) {
                                        /* empty */
                                    }
                                }
                            }
                        } else {
                            (this.xt).strack.unload();
                            this.msg = "The file choosen is not a valid MOD Track!";
                            this.flko = 45;
                            this.uploadt = 0;
                        }
                    } else {
                        this.msg = "Uploaded file must be less than 250KB in size!";
                        this.flko = 45;
                        this.uploadt = 0;
                    }
                } else {
                    this.msg = "The file chosen is invalid or does not exist!";
                    this.flko = 45;
                    this.uploadt = 0;
                }
            }
            if (this.playt == 1) {
                (this.xt).strack = new RadicalMod(this.themesong, this.trackvol, 8000, 125, false, true);
                (this.xt).strack.play();
                this.playt = 2;
            }
            domelogos();
            try {
                if (this.connector != null) {
                    /* empty */
                }
                Thread.sleep(600L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        onexit();
        try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
            this.connector = null;
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void onexit() {
        onexitpro();
        this.gs.hidefields();
        (this.cd).acname = "";
        (this.cd).action = 0;
    }
    
    public void onexitpro() {
        this.edit = 0;
        this.upload = 0;
        this.uploadt = 0;
        if (this.playt == 2) {
            (this.xt).strack.unload();
            this.playt = 0;
        }
    }
    
    public void stopallnow() {
        if (this.connector != null) {
            this.connector.stop();
            this.connector = null;
        }
        try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
            this.connector = null;
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void trunsent() {
        for (int i = 0; i < 3; i++)
            this.aboutxt[i] = "";
        if (!this.sentance.equals("")) {
            this.rd.setFont(new Font("Tahoma", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            int i = 0;
            int i_150_ = 0;
            int i_151_ = 0;
            int i_152_ = 0;
            boolean bool = false;
            for (/**/; i_150_ < this.sentance.length(); i_150_++) {
                String string = new StringBuilder().append("").append(this.sentance.charAt(i_150_)).toString();
                if (string.equals(" "))
                    i_151_ = i_150_;
                if (i < 3) {
                    StringBuilder stringbuilder = new StringBuilder();
                    String[] strings = this.aboutxt;
                    int i_153_ = i;
                    strings[i_153_] = stringbuilder.append(strings[i_153_]).append(string).toString();
                    if (this.ftm.stringWidth(this.aboutxt[i]) > 276) {
                        if (i_151_ != i_152_) {
                            this.aboutxt[i] = this.sentance.substring(i_152_, i_151_);
                            i_150_ = i_151_;
                            i_152_ = i_150_;
                        } else if (i == 2)
                            bool = true;
                        i++;
                    }
                } else {
                    if (bool)
                        this.aboutxt[2] = this.aboutxt[2].substring(0, this.aboutxt[2].length() - 3);
                    StringBuilder stringbuilder = new StringBuilder();
                    String[] strings = this.aboutxt;
                    int i_154_ = 2;
                    strings[i_154_] = stringbuilder.append(strings[i_154_]).append("...").toString();
                    i_150_ = this.sentance.length();
                }
            }
        }
        this.nab = 0;
        for (int i = 0; i < 3 && !this.aboutxt[i].equals(""); i++) {
            this.aboutxt[i] = this.aboutxt[i].trim();
            this.nab++;
        }
    }
    
    public void roomlogos(String[] strings, int i) {
        for (int i_155_ = 0; i_155_ < 2; i_155_++) {
            boolean bool = true;
            String string = "";
            for (int i_156_ = 0; i_156_ < i; i_156_++) {
                bool = false;
                for (int i_157_ = 0; i_157_ < this.nlg; i_157_++) {
                    if (strings[i_156_].toLowerCase().equals(this.logos[i_157_].toLowerCase())) {
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
            this.logos[this.nlg] = string;
            this.logon[this.nlg] = false;
            try {
                URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(this.logos[this.nlg]).append("/logo.png").toString());
                url.openConnection().setConnectTimeout(2000);
                String string_158_ = url.openConnection().getContentType();
                if (string_158_.equals("image/png")) {
                    this.logoi[this.nlg] = Toolkit.getDefaultToolkit().createImage(url);
                    this.mt.addImage(this.logoi[this.nlg], this.nlg);
                    this.logon[this.nlg] = true;
                    this.fun++;
                    if (this.fun == 12)
                        this.fun = 1;
                }
            } catch (Exception exception) {
                /* empty */
            }
            this.nlg++;
            if (this.nlg == 200)
                this.nlg = 0;
        }
    }
    
    public void domelogos() {
        for (int i = 0; i < 5; i++) {
            boolean bool = true;
            String string = "";
            for (int i_159_ = 0; i_159_ < this.nm; i_159_++) {
                bool = false;
                for (int i_160_ = 0; i_160_ < this.nlg; i_160_++) {
                    if (this.mname[i_159_].toLowerCase().equals(this.logos[i_160_].toLowerCase())) {
                        bool = true;
                        break;
                    }
                }
                if (!bool) {
                    string = this.mname[i_159_].toLowerCase();
                    break;
                }
            }
            if (bool) {
                for (int i_161_ = 0; i_161_ < this.npo; i_161_++) {
                    bool = false;
                    for (int i_162_ = 0; i_162_ < this.nlg; i_162_++) {
                        if (this.pname[i_161_].toLowerCase().equals(this.logos[i_162_].toLowerCase())) {
                            bool = true;
                            break;
                        }
                    }
                    if (!bool) {
                        string = this.pname[i_161_].toLowerCase();
                        break;
                    }
                }
            }
            if (bool)
                break;
            this.logos[this.nlg] = string;
            this.logon[this.nlg] = false;
            try {
                URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(this.logos[this.nlg]).append("/logo.png").toString());
                url.openConnection().setConnectTimeout(2000);
                String string_163_ = url.openConnection().getContentType();
                if (string_163_.equals("image/png")) {
                    this.logoi[this.nlg] = Toolkit.getDefaultToolkit().createImage(url);
                    this.mt.addImage(this.logoi[this.nlg], this.nlg);
                    this.logon[this.nlg] = true;
                    this.fun++;
                    if (this.fun == 12)
                        this.fun = 1;
                }
            } catch (Exception exception) {
                /* empty */
            }
            this.nlg++;
            if (this.nlg == 200)
                this.nlg = 0;
        }
    }
    
    public boolean drawl(String string, int i, int i_164_, boolean bool) {
        boolean bool_165_ = false;
        int i_166_ = -1;
        for (int i_167_ = 0; i_167_ < this.nlg; i_167_++) {
            if (string.toLowerCase().equals(this.logos[i_167_].toLowerCase())) {
                i_166_ = i_167_;
                break;
            }
        }
        if (i_166_ != -1 && this.logon[i_166_]) {
            if (!bool)
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
            this.rd.drawImage(this.logoi[i_166_], i, i_164_, null);
            bool_165_ = this.mt.checkID(i_166_);
            if (!bool)
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        }
        return bool_165_;
    }
    
    public void logopng() {
        int i = -1;
        for (int i_168_ = 0; i_168_ < this.nlg; i_168_++) {
            if (this.proname.toLowerCase().equals(this.logos[i_168_].toLowerCase())) {
                i = i_168_;
                break;
            }
        }
        if (i == -1) {
            i = this.nlg;
            this.nlg++;
            if (this.nlg == 200)
                this.nlg = 0;
        }
        this.logos[i] = this.proname.toLowerCase();
        try {
            String string = "";
            if (this.refresh)
                string = new StringBuilder().append("?req=").append((int) (Math.random() * 1000.0)).append("").toString();
            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(this.proname).append("/logo.png").append(string).append("").toString());
            url.openConnection().setConnectTimeout(2000);
            String string_169_ = url.openConnection().getContentType();
            if (string_169_.equals("image/png")) {
                this.logoi[i] = Toolkit.getDefaultToolkit().createImage(url);
                this.mt.addImage(this.logoi[i], i);
                this.logon[i] = true;
            } else
                this.logon[i] = false;
        } catch (Exception exception) {
            /* empty */
        }
        this.logol = this.logon[i];
    }
    
    public void avatarpng() {
        this.avatarl = false;
        String string = "";
        if (this.refresh)
            string = new StringBuilder().append("?req=").append((int) (Math.random() * 1000.0)).append("").toString();
        try {
            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(this.proname).append("/avatar.png").append(string).append("").toString());
            url.openConnection().setConnectTimeout(2000);
            String string_170_ = url.openConnection().getContentType();
            if (string_170_.equals("image/png")) {
                this.avatar = Toolkit.getDefaultToolkit().createImage(url);
                this.avatarl = true;
            }
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void clanlogopng() {
        this.clanlogol = false;
    }
    
    public void loadproinfo() {
        this.racing = 0;
        this.wasting = 0;
        this.themesong = "";
        this.trackvol = 0;
        this.sentance = "";
        try {
            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/profiles/").append(this.proname).append("/info.txt?req=").append((int) (Math.random() * 1000.0)).append("").toString());
            url.openConnection().setConnectTimeout(2000);
            String string = url.openConnection().getContentType();
            if (string.equals("text/plain")) {
                DataInputStream datainputstream = new DataInputStream(url.openStream());
                String string_171_ = "";
                for (int i = 0; (string_171_ = datainputstream.readLine()) != null && i < 9; i++) {
                    string_171_ = string_171_.trim();
                    if (i == 0)
                        this.themesong = string_171_;
                    if (i == 1) {
                        boolean bool = false;
                        int i_172_;
                        try {
                            i_172_ = Integer.valueOf(string_171_).intValue();
                        } catch (Exception exception) {
                            i_172_ = 0;
                        }
                        this.trackvol = i_172_;
                    }
                    if (i == 2) {
                        boolean bool = false;
                        int i_173_;
                        try {
                            i_173_ = Integer.valueOf(string_171_).intValue();
                        } catch (Exception exception) {
                            i_173_ = 0;
                        }
                        this.racing = i_173_;
                    }
                    if (i == 3) {
                        boolean bool = false;
                        int i_174_;
                        try {
                            i_174_ = Integer.valueOf(string_171_).intValue();
                        } catch (Exception exception) {
                            i_174_ = 0;
                        }
                        this.wasting = i_174_;
                    }
                    if (i == 8)
                        this.sentance = string_171_;
                }
                datainputstream.close();
            }
        } catch (Exception exception) {
            this.sentance = "Failed to load profile info, server error!";
        }
    }
    
    public boolean drawbutton(Image image, int i, int i_175_, int i_176_, int i_177_, boolean bool) {
        boolean bool_178_ = false;
        boolean bool_179_ = false;
        int i_180_ = image.getWidth(this.ob);
        if (Math.abs(i_176_ - i) < i_180_ / 2 + 12 && Math.abs(i_177_ - i_175_) < 14 && bool)
            bool_179_ = true;
        if (Math.abs(i_176_ - i) < i_180_ / 2 + 12 && Math.abs(i_177_ - i_175_) < 14 && (this.gs).mouses <= -1) {
            bool_178_ = true;
            (this.gs).mouses = 0;
        }
        if (!bool_179_) {
            this.rd.drawImage(image, i - i_180_ / 2, i_175_ - image.getHeight(this.ob) / 2, null);
            this.rd.drawImage((this.xt).bols, i - i_180_ / 2 - 15, i_175_ - 13, null);
            this.rd.drawImage((this.xt).bors, i + i_180_ / 2 + 9, i_175_ - 13, null);
            this.rd.drawImage((this.xt).bot, i - i_180_ / 2 - 9, i_175_ - 13, i_180_ + 18, 3, null);
            this.rd.drawImage((this.xt).bob, i - i_180_ / 2 - 9, i_175_ + 10, i_180_ + 18, 3, null);
        } else {
            this.rd.drawImage(image, i - i_180_ / 2 + 1, i_175_ - image.getHeight(this.ob) / 2 + 1, null);
            this.rd.drawImage((this.xt).bolps, i - i_180_ / 2 - 15, i_175_ - 13, null);
            this.rd.drawImage((this.xt).borps, i + i_180_ / 2 + 9, i_175_ - 13, null);
            this.rd.drawImage((this.xt).bob, i - i_180_ / 2 - 9, i_175_ - 13, i_180_ + 18, 3, null);
            this.rd.drawImage((this.xt).bot, i - i_180_ / 2 - 9, i_175_ + 10, i_180_ + 18, 3, null);
        }
        return bool_178_;
    }
    
    public boolean stringbutton(String string, int i, int i_181_, int i_182_, int i_183_, int i_184_, boolean bool) {
        boolean bool_185_ = false;
        boolean bool_186_ = false;
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        int i_187_ = this.ftm.stringWidth(string);
        if (Math.abs(i_183_ - i) < i_187_ / 2 + 12 && Math.abs(i_184_ - i_181_) < 14 && bool)
            bool_186_ = true;
        if (Math.abs(i_183_ - i) < i_187_ / 2 + 12 && Math.abs(i_184_ - i_181_) < 14 && (this.gs).mouses <= -1) {
            bool_185_ = true;
            (this.gs).mouses = 0;
        }
        if (!bool_186_) {
            this.rd.setColor(colorb2k(220, 220, 220));
            this.rd.fillRect(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i_187_ + 20, 25 - i_182_ * 2);
            this.rd.setColor(colorb2k(240, 240, 240));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i + i_187_ / 2 + 10, i_181_ - (17 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (18 - i_182_), i + i_187_ / 2 + 10, i_181_ - (18 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 9, i_181_ - (19 - i_182_), i + i_187_ / 2 + 9, i_181_ - (19 - i_182_));
            this.rd.setColor(colorb2k(200, 200, 200));
            this.rd.drawLine(i + i_187_ / 2 + 10, i_181_ - (17 - i_182_), i + i_187_ / 2 + 10, i_181_ + (7 - i_182_));
            this.rd.drawLine(i + i_187_ / 2 + 11, i_181_ - (17 - i_182_), i + i_187_ / 2 + 11, i_181_ + (7 - i_182_));
            this.rd.drawLine(i + i_187_ / 2 + 12, i_181_ - (16 - i_182_), i + i_187_ / 2 + 12, i_181_ + (6 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ + (7 - i_182_), i + i_187_ / 2 + 10, i_181_ + (7 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ + (8 - i_182_), i + i_187_ / 2 + 10, i_181_ + (8 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 9, i_181_ + (9 - i_182_), i + i_187_ / 2 + 9, i_181_ + (9 - i_182_));
            this.rd.setColor(colorb2k(240, 240, 240));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i - i_187_ / 2 - 10, i_181_ + (7 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 11, i_181_ - (17 - i_182_), i - i_187_ / 2 - 11, i_181_ + (7 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 12, i_181_ - (16 - i_182_), i - i_187_ / 2 - 12, i_181_ + (6 - i_182_));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, i - i_187_ / 2, i_181_);
        } else {
            this.rd.setColor(colorb2k(210, 210, 210));
            this.rd.fillRect(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i_187_ + 20, 25 - i_182_ * 2);
            this.rd.setColor(colorb2k(200, 200, 200));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i + i_187_ / 2 + 10, i_181_ - (17 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (18 - i_182_), i + i_187_ / 2 + 10, i_181_ - (18 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 9, i_181_ - (19 - i_182_), i + i_187_ / 2 + 9, i_181_ - (19 - i_182_));
            this.rd.drawLine(i + i_187_ / 2 + 10, i_181_ - (17 - i_182_), i + i_187_ / 2 + 10, i_181_ + (7 - i_182_));
            this.rd.drawLine(i + i_187_ / 2 + 11, i_181_ - (17 - i_182_), i + i_187_ / 2 + 11, i_181_ + (7 - i_182_));
            this.rd.drawLine(i + i_187_ / 2 + 12, i_181_ - (16 - i_182_), i + i_187_ / 2 + 12, i_181_ + (6 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ + (7 - i_182_), i + i_187_ / 2 + 10, i_181_ + (7 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ + (8 - i_182_), i + i_187_ / 2 + 10, i_181_ + (8 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 9, i_181_ + (9 - i_182_), i + i_187_ / 2 + 9, i_181_ + (9 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 10, i_181_ - (17 - i_182_), i - i_187_ / 2 - 10, i_181_ + (7 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 11, i_181_ - (17 - i_182_), i - i_187_ / 2 - 11, i_181_ + (7 - i_182_));
            this.rd.drawLine(i - i_187_ / 2 - 12, i_181_ - (16 - i_182_), i - i_187_ / 2 - 12, i_181_ + (6 - i_182_));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, i - i_187_ / 2 + 1, i_181_);
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
