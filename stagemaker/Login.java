package stagemaker;

/* Login - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TextField;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
public class Login implements Runnable
{
    Graphics2D rd;
    xtGraphics xt;
    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker gs;
    Thread connector;
    int fase = 0;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    boolean[] pessd = { false, false, false, false, false, false };
    int[] bx = { 0, 0, 0, 0, 0, 0 };
    int[] by = { 0, 0, 0, 0, 0, 0 };
    int[] bw = { 0, 0, 0, 0, 0, 0 };
    int btn = 0;
    int nflk = 0;
    int ncnt = 0;
    int errcnt = 0;
    int lrgfase = 0;
    String msg = "";
    String lnick = "";
    String lpass = "";
    String lemail = "";
    boolean onf = false;
    boolean nickero = false;
    boolean jflk = false;
    boolean ond = false;
    int opselect = 0;
    int trans = 0;
    int cntcl = 0;
    boolean contrb = false;
    int nservers = 3;
    String[] servers = { "multiplayer.needformadness.com", "avenger.needformadness.com", "ghostrider.needformadness.com" };
    InetAddress[] IPAddress = new InetAddress[3];
    DatagramSocket[] dSocket = new DatagramSocket[3];
    int[] serverdone = { -1, -1, -1 };
    long[] servestart = { 0L, 0L, 0L };
    String[] snames = { "Dominion", "Avenger", "Ghostrider" };
    boolean socketson = false;
    int srvtrn = 0;
    int[] rmps = { 0, 0, 0, 0, 0 };
    int[] rmwt = { 0, 0, 0, 0, 0 };
    int recom = 0;
    boolean resofaso = false;
    int pend = 0;
    boolean pendb = false;
    boolean gotcai = false;
    int cax = 0;
    int cay = 0;
    boolean btroom = false;
    int xrl = 0;
    int xrr = 0;
    boolean onr = false;
    int lxm = 0;
    int lym = 0;
    
    public Login(Medium medium, Graphics2D graphics2d, xtGraphics var_xtGraphics, GameSparker gamesparker) {
        this.m = medium;
        this.rd = graphics2d;
        this.xt = var_xtGraphics;
        this.gs = gamesparker;
        if ((this.xt).playingame != -1)
            this.fase = 18;
        if ((this.xt).nofull)
            this.nservers = 1;
    }
    
    public void inishmulti() {
        (this.gs).tnick.hide();
        (this.gs).tnick.enable();
        (this.gs).tnick.setForeground(new Color(0, 0, 0));
        (this.gs).tnick.setBackground(color2k(255, 255, 255));
        (this.gs).tpass.hide();
        (this.gs).tpass.enable();
        (this.gs).tpass.setForeground(new Color(0, 0, 0));
        (this.gs).tpass.setBackground(color2k(255, 255, 255));
        (this.gs).temail.hide();
        (this.gs).temail.enable();
        (this.gs).temail.setForeground(new Color(0, 0, 0));
        (this.gs).temail.setBackground(color2k(255, 255, 255));
        (this.gs).keplo.hide();
        (this.gs).keplo.enable();
        (this.gs).keplo.setForeground(new Color(0, 0, 0));
        (this.gs).keplo.setBackground(new Color(190, 166, 105));
        this.gs.requestFocus();
        if ((this.gs).tnick.getText().equals(""))
            (this.gs).tnick.setText("Nickname");
        for (int i = 0; i < 6; i++)
            this.pessd[i] = false;
        this.nflk = 0;
        this.ncnt = 0;
        this.errcnt = 0;
        this.onf = false;
        this.ond = false;
        this.msg = "";
        this.btroom = false;
        this.gotcai = false;
        (this.m).crs = true;
        (this.m).x = -335;
        (this.m).y = 0;
        (this.m).z = -50;
        (this.m).xz = 0;
        (this.m).zy = 20;
        (this.m).ground = -2000;
        this.pend = 0;
        this.pendb = false;
        this.resofaso = false;
        for (int i = 0; i < this.nservers; i++) {
            this.serverdone[i] = -1;
            this.servestart[i] = 0L;
        }
        if ((this.xt).gotlog) {
            this.socketson = false;
            this.fase = 12;
            this.connector = new Thread(this);
            this.connector.start();
        } else {
            this.msg = "Login to Account";
            (this.gs).tnick.setText((this.xt).nickname);
            this.fase = 3;
        }
    }
    
    public void exitfromlobby() {
        if (!(this.xt).lan)
            this.opselect = 0;
        else
            this.opselect = 1;
        for (int i = 0; i < this.nservers; i++) {
            this.serverdone[i] = -1;
            this.servestart[i] = 0L;
        }
        for (int i = 0; i < 6; i++)
            this.pessd[i] = false;
        this.gotcai = false;
        this.btroom = false;
        (this.m).crs = true;
        (this.m).x = -335;
        (this.m).y = 0;
        (this.m).z = -50;
        (this.m).xz = 0;
        (this.m).zy = 20;
        (this.m).ground = -2000;
        this.pend = 0;
        this.pendb = false;
        this.socketson = false;
        if (!(this.xt).lan) {
            this.msg = "| Connecting to Servers |";
            this.trans = 0;
            this.fase = 13;
            this.nflk = 0;
        } else
            this.fase = 12;
        System.gc();
        this.connector = new Thread(this);
        this.connector.start();
    }
    
    public void endcons() {
        for (int i = 0; i < this.nservers; i++) {
            try {
                this.dSocket[i].close();
                this.dSocket[i] = null;
            } catch (Exception exception) {
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
    }
    
    public void run() {
        if (this.fase == 2) {
            this.gs.setCursor(new Cursor(3));
            int i = -1;
            int i_0_ = -1;
            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                this.dout.println(new StringBuilder().append("0|").append((this.gs).tnick.getText()).append("|").toString());
                String string = this.din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                    if (i == 0) {
                        i_0_ = getvalue(string, 1);
                        (this.xt).hours = getvalue(string, 2);
                        (this.xt).nickey = getSvalue(string, 3);
                    }
                }
                this.socket.close();
                this.din.close();
                this.dout.close();
            } catch (Exception exception) {
                /* empty */
            }
            (this.gs).tnick.enable();
            if (i == -1) {
                this.msg = "Unable to connect to any server at this moment.  Please try again later.";
                this.fase = 1;
            }
            if (i == 0) {
                (this.xt).nickname = (this.gs).tnick.getText();
                if (i_0_ != -1)
                    (this.xt).nfreeplays = i_0_;
                (this.gs).tnick.hide();
                (this.gs).tpass.hide();
                (this.gs).temail.hide();
                (this.gs).keplo.hide();
                this.gs.requestFocus();
                (this.xt).logged = false;
                this.fase = 12;
                System.gc();
            }
            if (i == 1) {
                this.msg = "This Nickname is being used by someone else right now.  Please use another.";
                this.nickero = true;
                (this.gs).tnick.setForeground(new Color(255, 0, 0));
                (this.gs).tnick.requestFocus();
                this.errcnt = 30;
                this.fase = 1;
            }
            if (i == 2) {
                this.msg = "Nickname registerd.  Please use another or click 'Login' bellow to login to this Nickname.";
                this.nickero = true;
                (this.gs).tnick.setForeground(new Color(255, 0, 0));
                (this.gs).tnick.requestFocus();
                this.errcnt = 30;
                this.fase = 1;
            }
            this.gs.setCursor(new Cursor(0));
        }
        if (this.fase == 4) {
            this.gs.setCursor(new Cursor(3));
            int i = -1;
            String string = "";
            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                this.dout.println(new StringBuilder().append("1|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").toString());
                string = this.din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                    if (i == 0 || i > 10 || i == -167)
                        (this.xt).nickey = getSvalue(string, 1);
                }
                this.socket.close();
                this.din.close();
                this.dout.close();
            } catch (Exception exception) {
                /* empty */
            }
            (this.gs).tnick.enable();
            (this.gs).tpass.enable();
            (this.gs).keplo.enable();
            if (i == -1) {
                this.msg = "Unable to connect to server at this moment.  Please try again later.";
                this.fase = 3;
            }
            if (i == 0 || i == 3 || i > 10 || i == -167 || i == 111) {
                (this.xt).nickname = (this.gs).tnick.getText();
                (this.gs).tnick.hide();
                (this.gs).tpass.hide();
                (this.gs).temail.hide();
                (this.gs).keplo.hide();
                this.gs.requestFocus();
                this.gs.setloggedcookie();
                this.btroom = false;
                (this.xt).logged = true;
                (this.xt).gotlog = true;
                if (i == 0)
                    (this.xt).acexp = 0;
                if (i > 10)
                    (this.xt).acexp = i - 10;
                if (i == 3)
                    (this.xt).acexp = -1;
                if (i == -167) {
                    (this.xt).logged = false;
                    (this.xt).acexp = -2;
                }
                if (i == 111) {
                    if (!(this.xt).backlog.toLowerCase().equals((this.gs).tnick.getText().toLowerCase())) {
                        (this.xt).logged = false;
                        (this.xt).acexp = -3;
                    } else
                        (this.xt).acexp = 0;
                }
                if ((this.xt).logged)
                    (this.xt).backlog = (this.xt).nickname;
                this.fase = 12;
                System.gc();
            }
            if (i == 1) {
                this.msg = "Sorry.  The Nickname you have entered is incorrect or does not exist.";
                (this.gs).tnick.setForeground(new Color(255, 0, 0));
                (this.gs).tnick.requestFocus();
                this.errcnt = 40;
                this.fase = 3;
            }
            if (i == 2) {
                this.msg = "Sorry.  The Password you have entered is incorrect.";
                (this.gs).tpass.setForeground(new Color(255, 0, 0));
                (this.gs).tpass.requestFocus();
                this.errcnt = 40;
                this.fase = 3;
            }
            this.gs.setCursor(new Cursor(0));
        }
        if (this.fase == 8) {
            this.gs.setCursor(new Cursor(3));
            int i = -1;
            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                this.dout.println(new StringBuilder().append("2|").append((this.gs).temail.getText().toLowerCase()).append("|").toString());
                String string = this.din.readLine();
                if (string != null)
                    i = getvalue(string, 0);
                this.socket.close();
                this.din.close();
                this.dout.close();
            } catch (Exception exception) {
                /* empty */
            }
            (this.gs).temail.enable();
            if (i == -1) {
                this.msg = "Unable to connect to server at this moment.  Please try again later.";
                this.fase = 7;
            }
            if (i == 0) {
                (this.gs).temail.hide();
                this.msg = new StringBuilder().append("Account details sent!  Please check your Email: ").append((this.gs).temail.getText()).append(" to login.").toString();
                (this.gs).temail.setText("");
                (this.gs).tnick.setText("");
                (this.gs).tpass.setText("");
                this.fase = 3;
            }
            if (i == 1) {
                this.msg = "Sorry.  This Email Address does not exist in our system!";
                (this.gs).temail.setForeground(new Color(255, 0, 0));
                this.errcnt = 40;
                this.fase = 7;
            }
            this.gs.setCursor(new Cursor(0));
        }
        if ((this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) && !this.socketson) {
            for (int i = 0; i < this.nservers; i++) {
                try {
                    this.serverdone[i] = -1;
                    this.IPAddress[i] = InetAddress.getByName(this.servers[i]);
                    this.dSocket[i] = new DatagramSocket(7001 + i);
                } catch (Exception exception) {
                    this.serverdone[i] = 5;
                }
            }
            this.srvtrn = 0;
            this.socketson = true;
        }
        while (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
            if (this.srvtrn < this.nservers) {
                for (/**/; this.serverdone[this.srvtrn] < (this.xt).cntptrys; this.serverdone[this.srvtrn]++) {
                    if (this.serverdone[this.srvtrn] == -1)
                        this.serverdone[this.srvtrn] = 0;
                    Date date = new Date();
                    this.servestart[this.srvtrn] = date.getTime();
                    try {
                        byte[] is = new byte[4];
                        DatagramPacket datagrampacket = new DatagramPacket(is, is.length, this.IPAddress[this.srvtrn], 7000);
                        String string = new StringBuilder().append("").append((this.xt).nickname).append("|").toString();
                        byte[] is_1_ = string.getBytes();
                        datagrampacket.setData(is_1_);
                        this.dSocket[this.srvtrn].send(datagrampacket);
                        this.dSocket[this.srvtrn].receive(datagrampacket);
                        String string_2_ = new String(datagrampacket.getData());
                        if (string_2_.startsWith("OK")) {
                            date = new Date();
                            if (date.getTime() - this.servestart[this.srvtrn] < (long) (this.xt).delays[this.srvtrn])
                                (this.xt).delays[this.srvtrn] = (int) (date.getTime() - this.servestart[this.srvtrn]);
                        }
                    } catch (Exception exception) {
                        (this.xt).delays[this.srvtrn] = 600;
                        this.serverdone[this.srvtrn] = 5;
                    }
                }
                this.srvtrn++;
            } else if (this.fase == 13) {
                int i = -1;
                boolean bool = false;
                for (int i_3_ = 0; i_3_ < this.nservers; i_3_++) {
                    if ((this.xt).delays[i_3_] < i || i == -1) {
                        i = (this.xt).delays[i_3_];
                        this.opselect = i_3_;
                    }
                    if ((this.xt).delays[i_3_] >= 600)
                        bool = true;
                }
                if (!bool) {
                    (this.xt).cntptrys -= 2;
                    if ((this.xt).cntptrys < 1)
                        (this.xt).cntptrys = 1;
                }
                this.fase = 14;
            }
            try {
                if (this.connector != null) {
                    /* empty */
                }
                Thread.sleep(5L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        if (this.fase != 12 && this.fase != 13 && this.fase != 14 && this.fase != 15 && this.fase != 5 && this.socketson) {
            for (int i = 0; i < this.nservers; i++) {
                try {
                    this.dSocket[i].close();
                    this.dSocket[i] = null;
                } catch (Exception exception) {
                    /* empty */
                }
            }
            this.socketson = false;
        }
        if (this.fase == 16 || this.fase == 17) {
            boolean bool = false;
            int i = 0;
            int i_4_ = -1;
            this.recom = 0;
            try {
                this.socket = new Socket((this.xt).server, 7067);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            } catch (Exception exception) {
                /* empty */
            }
            while ((this.fase == 16 || this.fase == 17) && i != 3) {
                String string = "";
                if (!bool) {
                    try {
                        this.dout.println("10|");
                        String string_5_ = this.din.readLine();
                        if (string_5_ == null)
                            bool = true;
                        else
                            string = string_5_;
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
                            this.socket = new Socket((this.xt).server, 7067);
                            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                            this.dout.println("10|");
                            String string_6_ = this.din.readLine();
                            if (string_6_ != null)
                                bool = false;
                            else
                                string = string_6_;
                        } catch (Exception exception) {
                            bool = true;
                        }
                    }
                    if (bool) {
                        try {
                            this.socket.close();
                            this.socket = null;
                        } catch (Exception exception) {
                            /* empty */
                        }
                    }
                }
                if (!bool) {
                    for (int i_7_ = 0; i_7_ < 5; i_7_++) {
                        this.rmps[i_7_] = getvalue(string, i_7_ * 2);
                        this.rmwt[i_7_] = getvalue(string, 1 + i_7_ * 2);
                    }
                    int i_8_ = 1000;
                    for (int i_9_ = 0; i_9_ < 5; i_9_++) {
                        if (Math.abs(this.rmps[i_9_] - 4) < i_8_ && this.rmps[i_9_] < 10) {
                            this.recom = i_9_;
                            i_8_ = Math.abs(this.rmps[i_9_] - 4);
                        }
                    }
                    if (this.recom != i_4_) {
                        this.opselect = this.recom;
                        i_4_ = this.recom;
                    }
                    if (this.fase == 16)
                        this.fase = 17;
                } else {
                    this.msg = "Failed to connect to this Server!";
                    i++;
                }
                if (i != 3) {
                    try {
                        if (this.connector != null) {
                            /* empty */
                        }
                        Thread.sleep(2000L);
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
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
            if (i == 3)
                this.resofaso = true;
        }
    }
    
    public void stopallnow() {
        if (this.connector != null) {
            this.connector.stop();
            this.connector = null;
        }
        endcons();
    }
    
    public void multimode(ContO[] contos) {
        this.btn = 0;
        this.xt.mainbg(4);
        this.rd.drawImage((this.xt).multim, 295, 33, null);
        drawSbutton((this.xt).exit, 690, 42);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (!this.gotcai) {
            int i = ((contos[(this.xt).sc[0]]).p[0]).oz[0];
            int i_10_ = i;
            int i_11_ = ((contos[(this.xt).sc[0]]).p[0]).oy[0];
            int i_12_ = i_11_;
            for (int i_13_ = 0; i_13_ < (contos[(this.xt).sc[0]]).npl; i_13_++) {
                for (int i_14_ = 0; i_14_ < ((contos[(this.xt).sc[0]]).p[i_13_]).n; i_14_++) {
                    if (((contos[(this.xt).sc[0]]).p[i_13_]).oz[i_14_] < i)
                        i = ((contos[(this.xt).sc[0]]).p[i_13_]).oz[i_14_];
                    if (((contos[(this.xt).sc[0]]).p[i_13_]).oz[i_14_] > i_10_)
                        i_10_ = ((contos[(this.xt).sc[0]]).p[i_13_]).oz[i_14_];
                    if (((contos[(this.xt).sc[0]]).p[i_13_]).oy[i_14_] < i_11_)
                        i_11_ = ((contos[(this.xt).sc[0]]).p[i_13_]).oy[i_14_];
                    if (((contos[(this.xt).sc[0]]).p[i_13_]).oy[i_14_] > i_12_)
                        i_12_ = ((contos[(this.xt).sc[0]]).p[i_13_]).oy[i_14_];
                }
            }
            this.cax = (i_10_ + i) / 2;
            this.cay = (i_12_ + i_11_) / 2;
            this.gotcai = true;
        }
        (contos[(this.xt).sc[0]]).z = 1500;
        (contos[(this.xt).sc[0]]).y = 380 - this.cay;
        (contos[(this.xt).sc[0]]).x = 100 - this.cax;
        (contos[(this.xt).sc[0]]).zy = 0;
        (contos[(this.xt).sc[0]]).xz = -90;
        (contos[(this.xt).sc[0]]).xy = this.pend;
        contos[(this.xt).sc[0]].d(this.rd);
        if (!this.pendb) {
            this.pend += 2;
            if (this.pend > 80)
                this.pendb = true;
        } else {
            this.pend -= 2;
            if (this.pend < -10)
                this.pendb = false;
        }
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawString((this.xt).nickname, 239 - this.ftm.stringWidth((this.xt).nickname) / 2, 105);
        this.rd.setColor(color2k(90, 90, 90));
        this.rd.drawRect(319, 83, 180, 96);
        this.rd.drawString(new StringBuilder().append("").append(((this.xt).cd).names[(this.xt).sc[0]]).append("").toString(), 409 - this.ftm.stringWidth(new StringBuilder().append("").append(((this.xt).cd).names[(this.xt).sc[0]]).append("").toString()) / 2, 81);
        this.rd.drawRect(173, 83, 132, 32);
        this.rd.drawString("Nickname", 239 - this.ftm.stringWidth("Nickname") / 2, 81);
        drawbutton((this.xt).change, 570, 98);
        if (!(this.xt).logged) {
            drawSbutton((this.xt).upgrade, 239, 135);
            drawSbutton((this.xt).logout, 239, 165);
        } else {
            drawSbutton((this.xt).logout, 239, 135);
            this.rd.setColor(new Color(98, 56, 0));
            this.rd.drawString("Edit my Account", 239 - this.ftm.stringWidth("Edit my Account") / 2, 168);
            if (this.ond)
                this.rd.drawLine(239 - this.ftm.stringWidth("Edit my Account") / 2, 169, 239 - this.ftm.stringWidth("Edit my Account") / 2 + this.ftm.stringWidth("Edit my Account"), 169);
        }
        if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
            int i = this.srvtrn;
            if (i < this.nservers && this.serverdone[i] != -1) {
                Date date = new Date();
                if (date.getTime() - this.servestart[i] > 1500L) {
                    if (this.connector != null) {
                        this.connector.stop();
                        this.connector = null;
                    }
                    (this.xt).delays[i] = 600;
                    this.serverdone[i] = 5;
                    this.connector = new Thread(this);
                    this.connector.start();
                }
            }
        }
        if (this.fase == 12) {
            if ((this.xt).acexp == 0 || this.contrb) {
                this.rd.setColor(color2k(90, 90, 90));
                this.rd.drawString("Multiplayer Mode", 400 - this.ftm.stringWidth("Multiplayer Mode") / 2, 220);
                this.rd.drawRoundRect(205, 225, 390, 120, 20, 20);
                this.rd.setColor(color2k(255, 255, 255));
                if (this.opselect == 0 && !this.pessd[3])
                    this.rd.drawImage((this.xt).filb, 400 - (this.xt).pon.getWidth(this.ob) / 2 - 6, 242, (this.xt).pon.getWidth(this.ob) + 12, 25, null);
                drawbutton((this.xt).pon, 400, 255);
                if (this.opselect == 1 && !this.pessd[4])
                    this.rd.drawImage((this.xt).filb, 400 - (this.xt).pln.getWidth(this.ob) / 2 - 6, 302, (this.xt).pln.getWidth(this.ob) + 12, 25, null);
                drawbutton((this.xt).pln, 400, 315);
            } else {
                this.rd.setColor(color2k(255, 255, 255));
                this.rd.fillRoundRect(165, 219, 470, 135, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(165, 219, 470, 135, 20, 20);
                if ((this.xt).acexp > 0) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(new StringBuilder().append("Dear ").append((this.xt).nickname).append(",").toString(), 185, 245);
                    this.rd.drawString(new StringBuilder().append("Your account is due to expire in ").append((this.xt).acexp).append(" days.").toString(), 185, 265);
                    this.rd.drawString("Please renew your registration.", 185, 295);
                    stringbutton("Renew my Account Registration now!", 345, 332, 0);
                    stringbutton("Renew Later", 524, 332, 0);
                }
                if ((this.xt).acexp == -1) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(new StringBuilder().append("Dear ").append((this.xt).nickname).append(",").toString(), 185, 245);
                    this.rd.drawString("Your Need for Madness account registration has expired.", 185, 265);
                    this.rd.drawString("Please renew your registration.", 185, 295);
                    stringbutton("Renew my account registration now!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if ((this.xt).acexp == -2) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(new StringBuilder().append("Dear ").append((this.xt).nickname).append(",").toString(), 185, 245);
                    this.rd.drawString("Trial accounts are not allowed to access the downloaded game.", 185, 265);
                    this.rd.drawString("You can only play the game online using your trial account.", 185, 295);
                    stringbutton("Play the multiplayer online!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if ((this.xt).acexp == -3) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Some one else is already logged in the game with your account.", 185, 245);
                    this.rd.drawString("If you where just in the game then quitted it suddenly, it could just", 185, 265);
                    this.rd.drawString("be your 'ghost entry', if so please wait a few minutes and try again.", 185, 285);
                    this.rd.drawString("Otherwise please consider changing your password.", 185, 305);
                    stringbutton("Change Password", 332, 336, 0);
                    stringbutton("Try Again", 494, 336, 0);
                }
            }
        }
        if (this.fase == 13 || this.fase == 14 || this.fase == 16 || this.fase == 17) {
            if (this.trans < 40)
                this.rd.drawImage((this.xt).pon, 400 - (this.xt).pon.getWidth(this.ob) / 2, 255 - (this.xt).pon.getHeight(this.ob) / 2 - 12 - this.trans, null);
            else
                this.rd.drawImage((this.xt).pon, 400 - (this.xt).pon.getWidth(this.ob) / 2, 215 - (this.xt).pon.getHeight(this.ob) / 2 - 12, null);
            if (this.trans >= 40) {
                this.rd.setColor(color2k(255, 255, 255));
                this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                drawbutton((this.xt).cancel, 583, 388);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.fase == 13) {
                    this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 295);
                    if (this.msg.equals(". . . | Connecting to Servers | . . .") && this.ncnt == 0) {
                        this.msg = "| Connecting to Servers |";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". . | Connecting to Servers | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Connecting to Servers | . . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". | Connecting to Servers | .") && this.ncnt == 0) {
                        this.msg = ". . | Connecting to Servers | . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals("| Connecting to Servers |") && this.ncnt == 0) {
                        this.msg = ". | Connecting to Servers | .";
                        this.ncnt = 5;
                    }
                    if (this.ncnt != 0)
                        this.ncnt--;
                }
                if (this.fase == 16) {
                    this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 295);
                    if (this.msg.equals(". . . | Finding Rooms | . . .") && this.ncnt == 0) {
                        this.msg = "| Finding Rooms |";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". . | Finding Rooms | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Finding Rooms | . . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". | Finding Rooms | .") && this.ncnt == 0) {
                        this.msg = ". . | Finding Rooms | . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals("| Finding Rooms |") && this.ncnt == 0) {
                        this.msg = ". | Finding Rooms | .";
                        this.ncnt = 5;
                    }
                    if (this.ncnt != 0)
                        this.ncnt--;
                }
                if (this.fase == 14) {
                    this.msg = "";
                    int i = 0;
                    if (!(this.xt).nofull) {
                        for (int i_15_ = 0; i_15_ < this.nservers; i_15_++) {
                            if ((this.xt).delays[i_15_] >= 400)
                                i++;
                        }
                    }
                    if (i != this.nservers) {
                        boolean bool = false;
                        boolean bool_16_ = false;
                        for (int i_17_ = 0; i_17_ < this.nservers; i_17_++) {
                            if (this.opselect == i_17_) {
                                this.rd.setColor(new Color(98, 56, 0));
                                this.rd.fillRoundRect(175, 230 + i_17_ * 20, 450, 20, 14, 14);
                                this.rd.setColor(new Color(255, 176, 67));
                                this.rd.drawRoundRect(175, 230 + i_17_ * 20, 450, 20, 14, 14);
                                this.rd.setColor(color2k(255, 255, 255));
                                if ((this.xt).delays[i_17_] >= 400) {
                                    this.msg = "Your connection to this server is too slow!";
                                    bool_16_ = true;
                                }
                                if ((this.xt).delays[i_17_] == 600) {
                                    this.msg = "This server is not responding!";
                                    bool_16_ = true;
                                }
                                if ((this.xt).delays[i_17_] < 400) {
                                    for (int i_18_ = 0; i_18_ < this.nservers; i_18_++) {
                                        if ((this.xt).delays[i_18_] < (this.xt).delays[i_17_] && i_17_ != i_18_)
                                            bool = true;
                                    }
                                    if (bool)
                                        this.msg = "We recommend choosing the fastest server!";
                                    else if ((this.xt).delays[i_17_] >= 300)
                                        this.msg = "Your connection speed is not perfect.  You may encounter delay!";
                                }
                            }
                            if (!(this.xt).logged && (this.xt).nfreeplays - (this.xt).ndisco >= 5 && !bool_16_) {
                                this.msg = "You have already played 5 games today, please register!";
                                this.jflk = true;
                            }
                            this.rd.drawString("Server Name :", 195, 245 + i_17_ * 20);
                            this.rd.drawString("|   Delay/Speed :", 385, 245 + i_17_ * 20);
                            int i_19_ = 0;
                            int i_20_ = 0;
                            String string = new StringBuilder().append("").append((this.xt).delays[i_17_]).append("/").toString();
                            if ((this.xt).delays[i_17_] < 75) {
                                string = new StringBuilder().append(string).append("EXCELENT *****").toString();
                                i_19_ = 125;
                                i_20_ = 200;
                            }
                            if ((this.xt).delays[i_17_] >= 75 && (this.xt).delays[i_17_] < 150) {
                                string = new StringBuilder().append(string).append("Perfect ****").toString();
                                i_19_ = 125;
                                i_20_ = 200;
                            }
                            if ((this.xt).delays[i_17_] >= 150 && (this.xt).delays[i_17_] < 250) {
                                string = new StringBuilder().append(string).append("Good ***").toString();
                                i_19_ = 162;
                                i_20_ = 200;
                            }
                            if ((this.xt).delays[i_17_] >= 250 && (this.xt).delays[i_17_] < 400) {
                                string = new StringBuilder().append(string).append("Acceptable **").toString();
                                i_19_ = 200;
                                i_20_ = 200;
                            }
                            if ((this.xt).delays[i_17_] >= 400 && (this.xt).delays[i_17_] < 600) {
                                string = new StringBuilder().append(string).append("Poor").toString();
                                i_19_ = 200;
                                i_20_ = 0;
                            }
                            if ((this.xt).delays[i_17_] == 600)
                                string = "Not Responding";
                            if (this.opselect == i_17_) {
                                i_19_ *= 1.27F;
                                i_20_ *= 1.27F;
                            }
                            this.rd.setColor(new Color(i_19_, i_20_, 0));
                            this.rd.drawString(new StringBuilder().append("").append(this.snames[i_17_]).append("").toString(), 294, 245 + i_17_ * 20);
                            this.rd.drawString(string, 497, 245 + i_17_ * 20);
                            this.rd.setColor(new Color(0, 0, 0));
                        }
                        if ((this.xt).nofull) {
                            if (this.nflk % 4 != 0 || this.nflk == 0) {
                                this.rd.setFont(new Font("Arial", 0, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(200, 0, 0));
                                this.rd.drawString("Warning! You did not allow the game full permissions when you started it.", 175, 275);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 292);
                                this.rd.drawString("Because of this you will be able to connect to ONLY the game's main server:", 175, 309);
                                this.rd.drawString(new StringBuilder().append("'").append(this.snames[0]).append("', which is not necessarily the fastest server you can connect to.").toString(), 175, 326);
                                this.rd.drawString("Please allow Java full permissions next time to be able to play on all servers!", 175, 343);
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                            }
                        } else {
                            if (bool_16_)
                                this.rd.setColor(new Color(200, 0, 0));
                            else if (this.jflk) {
                                this.rd.setColor(new Color(98, 56, 0));
                                this.jflk = false;
                            } else {
                                this.rd.setColor(new Color(255, 176, 67));
                                this.jflk = true;
                            }
                            if (this.nflk % 4 != 0 || this.nflk == 0)
                                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 360);
                            if (this.nflk != 0)
                                this.nflk--;
                        }
                    } else {
                        if (this.nflk % 4 != 0 || this.nflk == 0) {
                            this.rd.setColor(new Color(200, 0, 0));
                            this.rd.drawString("Sorry.  Your connection is currently not fast enough to play online!", 400 - this.ftm.stringWidth("Sorry.  Your connection is currently not fast enough to play online!") / 2, 242);
                        }
                        if (this.nflk != 0)
                            this.nflk--;
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Please make sure you or anyone else using this connection is not slowing", 181, 265);
                        this.rd.drawString("it down right now by downloading or streaming.", 181, 282);
                        this.rd.drawString("Also please make sure you don't have any other programs running on your", 181, 299);
                        this.rd.drawString("computer that maybe consuming your bandwidth.", 181, 316);
                        this.rd.drawString("Otherwise you may need to upgrade your connection speed to play!", 181, 333);
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Press 'Cancel' to try again or to try playing a Lan game instead.", 400 - this.ftm.stringWidth("Press 'Cancel' to try again or to try playing a Lan game instead.") / 2, 357);
                    }
                    drawbutton((this.xt).play, 400, 395);
                }
                if (this.fase == 17) {
                    int i = 0;
                    int i_21_ = 14;
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(new StringBuilder().append(": :   ").append((this.xt).servername).append("   : :").toString(), 400 - this.ftm.stringWidth(new StringBuilder().append(": :   ").append((this.xt).servername).append("   : :").toString()) / 2, 239);
                    for (int i_22_ = 0; i_22_ < 5; i_22_++) {
                        if (this.opselect == i_22_) {
                            this.rd.setColor(new Color(98, 56, 0));
                            this.rd.fillRoundRect(175, 230 + i_22_ * 20 + i_21_, 450, 20, 14, 14);
                            this.rd.setColor(new Color(255, 176, 67));
                            this.rd.drawRoundRect(175, 230 + i_22_ * 20 + i_21_, 450, 20, 14, 14);
                            this.rd.setColor(color2k(255, 255, 255));
                        }
                        this.rd.drawString(new StringBuilder().append("Room ").append(i_22_ + 1).append(" :").toString(), 247, 245 + i_22_ * 20 + i_21_);
                        this.rd.drawString(new StringBuilder().append("").append(this.rmps[i_22_]).append(" / 10  Players").toString(), 405 - this.ftm.stringWidth(new StringBuilder().append("").append(this.rmps[i_22_]).append(" / 10  Players").toString()), 245 + i_22_ * 20 + i_21_);
                        String string = "";
                        if (i_22_ == this.recom) {
                            if (this.opselect != i_22_)
                                this.rd.setColor(new Color(125, 200, 0));
                            else
                                this.rd.setColor(new Color(160, 255, 0));
                            string = "<  Recommended";
                        }
                        if (this.rmps[i_22_] >= 10) {
                            if (this.opselect != i_22_)
                                this.rd.setColor(new Color(200, 0, 0));
                            else
                                this.rd.setColor(new Color(255, 0, 0));
                            //this.rmps[i_22_] = 10;
                            string = "Hacked by chris <3";
                            i++;
                        }
                        if (!string.equals(""))
                            this.rd.drawString(string, 485 - this.ftm.stringWidth(string) / 2, 245 + i_22_ * 20 + i_21_);
                        this.rd.setColor(new Color(0, 0, 0));
                    }
                    /*if (i == 5) {
                        if (this.nflk % 4 != 0 || this.nflk == 0) {
                            this.rd.setColor(new Color(200, 0, 0));
                            this.rd.drawString("All rooms are currenlty full. Please wait and a room will be availble.", 400 - this.ftm.stringWidth("All rooms are currenlty full. Please wait and a room will be availble.") / 2, 360);
                        }
                        if (this.nflk != 0)
                            this.nflk--;
                    } else */if (this.rmps[this.opselect] >= 500) {
                        if (this.nflk != 0)
                            this.nflk--;
                        if (this.nflk % 4 != 0 || this.nflk == 0) {
                            this.rd.setColor(new Color(200, 0, 0));
                            this.rd.drawString("500 players? Seriously?", 400 - this.ftm.stringWidth("Sorry.  This room is currently full.") / 2, 360);
                        }
                    }
                    drawbutton((this.xt).play, 400, 395);
                }
            } else
                this.trans += 8;
        }
        if (this.fase == 15) {
            if (this.trans < 100)
                this.rd.drawImage((this.xt).pln, 400 - (this.xt).pln.getWidth(this.ob) / 2, 315 - (this.xt).pln.getHeight(this.ob) / 2 - 12 - this.trans, null);
            else
                this.rd.drawImage((this.xt).pln, 400 - (this.xt).pln.getWidth(this.ob) / 2, 215 - (this.xt).pln.getHeight(this.ob) / 2 - 12, null);
            if (this.trans >= 100) {
                this.rd.setColor(color2k(255, 255, 255));
                this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if ((this.xt).nofull) {
                    if (this.nflk % 4 != 0 || this.nflk == 0) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(200, 0, 0));
                        this.rd.drawString("Sorry. You did not allow the game full permissions when you started it.", 175, 242);
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 262);
                        this.rd.drawString("Because of this the game will not be able to create LAN connections!", 175, 288);
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Please restart the game and allow Java full permissions to be able to", 175, 315);
                        this.rd.drawString("play LAN games!", 175, 332);
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("(Close ALL browser windows including this one then", 295, 332);
                        this.rd.drawString("start the game again but click 'Run' when asked to 'run this application'. )", 175, 349);
                    }
                    if (this.nflk != 0)
                        this.nflk--;
                } else {
                    this.rd.drawString("Play a multiplayer game across your Local Area Network (LAN).", 179, 245);
                    this.rd.drawString("Experience the game live with zero delay and 100% real-time action!", 179, 262);
                    this.rd.setFont(new Font("Arial", 0, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("This is for if there is more then one computer connected to your network or", 179, 292);
                    this.rd.drawString("if you are in a computer lab or in an internet caf\u00e9.", 179, 309);
                    this.rd.drawString("You can also invite your friends to come over with their Laptop PCs or Macs", 179, 335);
                    this.rd.drawString("to log on to your internet connection/network and play with you!", 179, 352);
                }
                drawbutton((this.xt).cancel, 583, 388);
                drawbutton((this.xt).play, 400, 395);
            } else
                this.trans += 10;
        }
        if (this.resofaso) {
            this.resofaso = false;
            if (this.connector != null) {
                this.connector.stop();
                this.connector = null;
            }
            this.socketson = false;
            this.msg = "| Connecting to Servers |";
            this.fase = 13;
            this.connector = new Thread(this);
            this.connector.start();
        }
    }
    
    public void multistart(ContO[] contos) {
        this.btn = 0;
        this.xt.mainbg(4);
        this.rd.drawImage((this.xt).multim, 295, 33, null);
        drawSbutton((this.xt).exit, 690, 42);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (this.fase != 5) {
            if (!this.gotcai) {
                int i = ((contos[(this.xt).sc[0]]).p[0]).oz[0];
                int i_23_ = i;
                int i_24_ = ((contos[(this.xt).sc[0]]).p[0]).oy[0];
                int i_25_ = i_24_;
                for (int i_26_ = 0; i_26_ < (contos[(this.xt).sc[0]]).npl; i_26_++) {
                    for (int i_27_ = 0; i_27_ < ((contos[(this.xt).sc[0]]).p[i_26_]).n; i_27_++) {
                        if (((contos[(this.xt).sc[0]]).p[i_26_]).oz[i_27_] < i)
                            i = ((contos[(this.xt).sc[0]]).p[i_26_]).oz[i_27_];
                        if (((contos[(this.xt).sc[0]]).p[i_26_]).oz[i_27_] > i_23_)
                            i_23_ = ((contos[(this.xt).sc[0]]).p[i_26_]).oz[i_27_];
                        if (((contos[(this.xt).sc[0]]).p[i_26_]).oy[i_27_] < i_24_)
                            i_24_ = ((contos[(this.xt).sc[0]]).p[i_26_]).oy[i_27_];
                        if (((contos[(this.xt).sc[0]]).p[i_26_]).oy[i_27_] > i_25_)
                            i_25_ = ((contos[(this.xt).sc[0]]).p[i_26_]).oy[i_27_];
                    }
                }
                this.cax = (i_23_ + i) / 2;
                this.cay = (i_25_ + i_24_) / 2;
                this.gotcai = true;
            }
            (contos[(this.xt).sc[0]]).z = 1500;
            (contos[(this.xt).sc[0]]).y = 360 - this.cay;
            (contos[(this.xt).sc[0]]).x = -170 - this.cax;
            (contos[(this.xt).sc[0]]).zy = 0;
            (contos[(this.xt).sc[0]]).xz = -90;
            (contos[(this.xt).sc[0]]).xy = this.pend;
            contos[(this.xt).sc[0]].d(this.rd);
            if (!this.pendb) {
                this.pend += 2;
                if (this.pend > 80)
                    this.pendb = true;
            } else {
                this.pend -= 2;
                if (this.pend < -10)
                    this.pendb = false;
            }
            this.rd.setColor(color2k(70, 70, 70));
            this.rd.drawRect(246, 83, 180, 96);
            this.rd.drawString(new StringBuilder().append("").append(((this.xt).cd).names[(this.xt).sc[0]]).append("").toString(), 336 - this.ftm.stringWidth(new StringBuilder().append("").append(((this.xt).cd).names[(this.xt).sc[0]]).append("").toString()) / 2, 81);
            drawbutton((this.xt).change, 497, 98);
        }
        if (this.fase == 1 || this.fase == 2) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            this.rd.drawString("Enter a Nickname:", 400 - this.ftm.stringWidth("Enter a Nickname:") - 14, 241);
            if (this.fase == 2) {
                if (this.msg.equals(". . . | Checking Nickname | . . .") && this.ncnt == 0) {
                    this.msg = "| Checking Nickname |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Checking Nickname | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Checking Nickname | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Checking Nickname | .") && this.ncnt == 0) {
                    this.msg = ". . | Checking Nickname | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Checking Nickname |") && this.ncnt == 0) {
                    this.msg = ". | Checking Nickname | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0)
                    this.ncnt--;
                this.pessd[2] = true;
            }
            if (this.fase == 1 && !(this.gs).tnick.isShowing()) {
                (this.gs).tnick.show();
                (this.gs).tnick.requestFocus();
                if ((this.gs).tnick.getText().equals("Nickname"))
                    (this.gs).tnick.select(8, 8);
            }
            if (this.errcnt != 0) {
                this.errcnt--;
                if (this.errcnt == 0)
                    (this.gs).tnick.setForeground(new Color(0, 0, 0));
            }
            drawbutton((this.xt).play, 400, 285);
            if (this.nflk > 0) {
                if ((this.gs).tnick.getText().equals("")) {
                    (this.gs).tnick.setText("Nickname");
                    if (this.nflk == 1)
                        (this.gs).tnick.select(8, 8);
                } else
                    (this.gs).tnick.setText("");
                this.nflk--;
            }
            drawbutton((this.xt).login, 400, 340);
            drawbutton((this.xt).register, 400, 395);
            this.gs.movefield((this.gs).tnick, 400, 225, 129, 23);
            while (this.ftm.stringWidth((this.gs).tnick.getText()) > 86) {
                (this.gs).tnick.setText((this.gs).tnick.getText().substring(0, (this.gs).tnick.getText().length() - 1));
                (this.gs).tnick.select((this.gs).tnick.getText().length(), (this.gs).tnick.getText().length());
            }
            if (!(this.gs).tnick.getText().equals(this.lnick)) {
                fixtext((this.gs).tnick);
                this.lnick = (this.gs).tnick.getText();
            }
            if (this.xt.msgcheck((this.gs).tnick.getText()))
                (this.gs).tnick.setText("");
            if ((this.gs).tnick.getText().toLowerCase().indexOf("madbot") != -1)
                (this.gs).tnick.setText("");
        }
        if (this.fase == 3 || this.fase == 4) {
            this.rd.setColor(new Color(0, 0, 0));
            if (this.nflk % 4 != 0 || this.nflk == 0)
                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            if (this.nflk != 0)
                this.nflk--;
            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 237);
            this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 267);
            if (this.fase == 4) {
                if (this.msg.equals(". . . | Logging In | . . .") && this.ncnt == 0) {
                    this.msg = "| Logging In |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Logging In | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Logging In | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Logging In | .") && this.ncnt == 0) {
                    this.msg = ". . | Logging In | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Logging In |") && this.ncnt == 0) {
                    this.msg = ". | Logging In | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0)
                    this.ncnt--;
                this.pessd[2] = true;
            }
            if (this.fase == 3) {
                if (!(this.gs).keplo.isShowing())
                    (this.gs).keplo.show();
                if (!(this.gs).tpass.isShowing()) {
                    (this.gs).tpass.show();
                    if (!(this.gs).tnick.getText().equals(""))
                        (this.gs).tpass.requestFocus();
                }
                if (!(this.gs).tnick.isShowing()) {
                    (this.gs).tnick.show();
                    if ((this.gs).tnick.getText().equals(""))
                        (this.gs).tnick.requestFocus();
                }
            }
            if (this.errcnt != 0) {
                this.errcnt--;
                if (this.errcnt == 0) {
                    (this.gs).tpass.setText("");
                    (this.gs).tnick.setForeground(new Color(0, 0, 0));
                    (this.gs).tpass.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton((this.xt).login, 400, 315);
            if (this.onf)
                this.rd.setColor(color2k(0, 72, 255));
            else
                this.rd.setColor(color2k(120, 120, 120));
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Forgot your nickname or password?", 400 - this.ftm.stringWidth("Forgot your nickname or password?") / 2, 345);
            drawbutton((this.xt).register, 400, 395);
            this.gs.movefield((this.gs).keplo, 376, 275, 129, 23);
            this.gs.movefield((this.gs).tnick, 376, 221, 129, 23);
            if (!(this.gs).tnick.getText().equals(this.lnick)) {
                fixtext((this.gs).tnick);
                this.lnick = (this.gs).tnick.getText();
            }
            this.gs.movefield((this.gs).tpass, 376, 251, 129, 23);
            if (!(this.gs).tpass.getText().equals(this.lpass)) {
                fixtext((this.gs).tpass);
                this.lpass = (this.gs).tpass.getText();
            }
        }
        if (this.fase == 5) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 141);
            this.gs.movefield((this.gs).tnick, 376, 125, 129, 23);
            while (this.ftm.stringWidth((this.gs).tnick.getText()) > 86) {
                (this.gs).tnick.setText((this.gs).tnick.getText().substring(0, (this.gs).tnick.getText().length() - 1));
                (this.gs).tnick.select((this.gs).tnick.getText().length(), (this.gs).tnick.getText().length());
            }
            if (!(this.gs).tnick.getText().equals(this.lnick)) {
                fixtext((this.gs).tnick);
                this.lnick = (this.gs).tnick.getText();
            }
            if (!(this.gs).tnick.isShowing())
                (this.gs).tnick.show();
            drawbutton((this.xt).register, 400, 325);
            drawbutton((this.xt).cancel, 400, 375);
        }
        if (this.fase == 7 || this.fase == 8) {
            this.rd.setColor(new Color(0, 0, 0));
            if (this.nflk % 4 != 0 || this.nflk == 0)
                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            if (this.nflk != 0)
                this.nflk--;
            this.rd.drawString("Your Email:", 344 - this.ftm.stringWidth("Your Email:") - 14, 241);
            if (this.fase == 8) {
                if (this.msg.equals(". . . | Checking Email | . . .") && this.ncnt == 0) {
                    this.msg = "| Checking Email |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Checking Email | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Checking Email | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Checking Email | .") && this.ncnt == 0) {
                    this.msg = ". . | Checking Email | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Checking Email |") && this.ncnt == 0) {
                    this.msg = ". | Checking Email | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0)
                    this.ncnt--;
                this.pessd[2] = true;
            }
            if (this.fase == 7 && !(this.gs).temail.isShowing()) {
                (this.gs).temail.show();
                (this.gs).temail.requestFocus();
            }
            if (this.errcnt != 0) {
                this.errcnt--;
                if (this.errcnt == 0)
                    (this.gs).temail.setForeground(new Color(0, 0, 0));
            }
            drawbutton((this.xt).sdets, 400, 280);
            drawbutton((this.xt).cancel, 400, 375);
            this.gs.movefield((this.gs).temail, 344, 225, 199, 23);
            if (!(this.gs).temail.getText().equals(this.lemail)) {
                fixtext((this.gs).temail);
                this.lemail = (this.gs).temail.getText();
            }
        }
    }
    
    public void ctachm(int i, int i_28_, int i_29_, Control control, Lobby lobby) {
        int i_30_ = -1;
        if (this.fase != 2 && this.fase != 4 && this.fase != 6 && this.fase != 8 && this.fase != 9) {
            for (int i_31_ = 0; i_31_ < this.btn; i_31_++) {
                if (Math.abs(i - this.bx[i_31_]) < this.bw[i_31_] / 2 + 12 && Math.abs(i_28_ - this.by[i_31_]) < 14 && (i_29_ == 1 || i_29_ == 11))
                    this.pessd[i_31_] = true;
                else
                    this.pessd[i_31_] = false;
                if (Math.abs(i - this.bx[i_31_]) < this.bw[i_31_] / 2 + 12 && Math.abs(i_28_ - this.by[i_31_]) < 14 && i_29_ <= -1) {
                    (this.gs).mouses = 0;
                    i_30_ = i_31_;
                }
                if (this.fase == 12) {
                    int i_32_ = 3;
                    if (!(this.xt).logged)
                        i_32_ = 4;
                    if (Math.abs(i - this.bx[i_31_]) < this.bw[i_31_] / 2 + 12 && Math.abs(i_28_ - this.by[i_31_]) < 14 && (i_31_ == i_32_ || i_31_ == i_32_ + 1) && (i != this.lxm || i_28_ != this.lym))
                        this.opselect = i_31_ - i_32_;
                }
            }
        }
        if (i_30_ == 0) {
            (this.gs).tnick.hide();
            (this.gs).tpass.hide();
            (this.gs).keplo.hide();
            (this.gs).temail.hide();
            this.gs.requestFocus();
            (this.xt).fase = 24;
        }
        if (i_30_ == 1 && this.fase != 5) {
            (this.gs).tnick.hide();
            (this.gs).tpass.hide();
            (this.gs).keplo.hide();
            (this.gs).temail.hide();
            this.gs.requestFocus();
            (this.xt).fase = 23;
        }
        int i_33_ = 2;
        if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15 || this.fase == 16 || this.fase == 17) {
            if ((this.xt).logged) {
                if (i > 173 && i_28_ > 150 && i < 300 && i_28_ < 178) {
                    if (!this.ond) {
                        this.ond = true;
                        this.gs.setCursor(new Cursor(12));
                    }
                } else if (this.ond) {
                    this.ond = false;
                    this.gs.setCursor(new Cursor(0));
                }
                if (this.cntcl == 0) {
                    if (this.ond && i_29_ == 11) {
                        this.gs.editlink((this.xt).nickname);
                        this.cntcl = 10;
                    }
                } else
                    this.cntcl--;
            } else {
                if (i_30_ == 2)
                    this.gs.editlink((this.xt).nickname);
                i_33_ = 3;
            }
            if (i_30_ == i_33_) {
                i_30_ = -1;
                if ((this.xt).sc[0] >= 16) {
                    (this.xt).sc[0] = 15;
                    this.gotcai = false;
                }
                (this.xt).logged = false;
                (this.xt).gotlog = false;
                (this.gs).keplo.setState(false);
                this.gs.setloggedcookie();
                ((this.xt).cd).msloaded = 0;
                ((this.xt).cd).lastload = 0;
                this.msg = "Login to Account";
                this.fase = 3;
            }
        }
        if (this.fase == 12) {
            if ((this.xt).acexp == 0 || this.contrb) {
                if ((control).up) {
                    this.opselect--;
                    if (this.opselect == -1)
                        this.opselect = 1;
                    (control).up = false;
                }
                if ((control).down) {
                    this.opselect++;
                    if (this.opselect == 2)
                        this.opselect = 0;
                    (control).down = false;
                }
                if ((control).enter) {
                    i_30_ = this.opselect + 3;
                    (control).enter = false;
                }
                if (i_30_ == i_33_ + 1) {
                    this.msg = "| Connecting to Servers |";
                    this.opselect = 0;
                    this.trans = 0;
                    this.fase = 13;
                    this.nflk = 0;
                    i_30_ = -1;
                }
                if (i_30_ == i_33_ + 2) {
                    this.trans = 0;
                    this.fase = 15;
                    i_30_ = -1;
                }
            } else {
                if ((this.xt).acexp > 0) {
                    if (i_30_ == i_33_ + 1 || (control).enter) {
                        this.gs.editlink((this.xt).nickname);
                        i_30_ = -1;
                    }
                    if (i_30_ == i_33_ + 2) {
                        this.opselect = 0;
                        this.contrb = true;
                        i_30_ = -1;
                    }
                }
                if ((this.xt).acexp == -1) {
                    if (i_30_ == i_33_ + 1 || (control).enter) {
                        this.gs.editlink((this.xt).nickname);
                        i_30_ = -1;
                    }
                    if (i_30_ == i_33_ + 2) {
                        i_30_ = -1;
                        if ((this.xt).sc[0] >= 16) {
                            (this.xt).sc[0] = 15;
                            this.gotcai = false;
                        }
                        (this.xt).logged = false;
                        ((this.xt).cd).lastload = 0;
                        this.msg = "Login to Account";
                        this.fase = 3;
                    }
                }
                if ((this.xt).acexp == -2) {
                    if (i_30_ == i_33_ + 1 || (control).enter) {
                        this.gs.multlink();
                        i_30_ = -1;
                    }
                    if (i_30_ == i_33_ + 2) {
                        i_30_ = -1;
                        if ((this.xt).sc[0] >= 16) {
                            (this.xt).sc[0] = 15;
                            this.gotcai = false;
                        }
                        (this.xt).logged = false;
                        ((this.xt).cd).lastload = 0;
                        this.msg = "Login to Account";
                        this.fase = 3;
                    }
                }
                if ((this.xt).acexp == -3) {
                    if (i_30_ == i_33_ + 1 || (control).enter) {
                        this.gs.editlink((this.xt).nickname);
                        i_30_ = -1;
                    }
                    if (i_30_ == i_33_ + 2) {
                        i_30_ = -1;
                        if ((this.xt).sc[0] >= 16) {
                            (this.xt).sc[0] = 15;
                            this.gotcai = false;
                        }
                        (this.xt).logged = false;
                        ((this.xt).cd).lastload = 0;
                        this.msg = "Login to Account";
                        this.fase = 3;
                    }
                }
            }
        }
        if (this.fase == 13 || this.fase == 14 || this.fase == 15 || this.fase == 16 || this.fase == 17) {
            if ((control).exit)
                i_30_ = 3;
            if (i_30_ == i_33_ + 1) {
                if (this.fase == 15)
                    this.opselect = 1;
                else
                    this.opselect = 0;
                if (this.fase == 16 || this.fase == 17) {
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
                    } catch (Exception exception) {
                        /* empty */
                    }
                    this.fase = 12;
                    this.connector = new Thread(this);
                    this.connector.start();
                }
                if (this.fase == 14) {
                    if (this.connector != null) {
                        this.connector.stop();
                        this.connector = null;
                    }
                    for (int i_34_ = 0; i_34_ < this.nservers; i_34_++) {
                        try {
                            this.dSocket[i_34_].close();
                            this.dSocket[i_34_] = null;
                        } catch (Exception exception) {
                            /* empty */
                        }
                    }
                    this.socketson = false;
                    this.fase = 12;
                    this.connector = new Thread(this);
                    this.connector.start();
                }
                this.fase = 12;
                this.gs.setCursor(new Cursor(0));
            }
        }
        if (this.fase == 14) {
            if ((control).enter) {
                i_30_ = 4;
                this.pessd[4] = true;
            }
            if ((control).up) {
                this.opselect--;
                if (this.opselect == -1)
                    this.opselect = this.nservers - 1;
                (control).up = false;
            }
            if ((control).down) {
                this.opselect++;
                if (this.opselect == this.nservers)
                    this.opselect = 0;
                (control).down = false;
            }
            for (int i_35_ = 0; i_35_ < this.nservers; i_35_++) {
                if (i > 175 && i_28_ > 230 + i_35_ * 20 && i < 625 && i_28_ < 250 + i_35_ * 20 && i_29_ == 1)
                    this.opselect = i_35_;
            }
            if (i_30_ == i_33_ + 2) {
                if ((this.xt).delays[this.opselect] >= 400 && !(this.xt).nickname.equals("Insano"))
                    this.nflk = 30;
                else {
                    (this.xt).server = this.servers[this.opselect];
                    (this.xt).servername = this.snames[this.opselect];
                    this.msg = "| Finding Rooms |";
                    this.opselect = 0;
                    this.nflk = 0;
                    i_30_ = -1;
                    this.fase = 16;
                }
            }
        }
        if (this.fase == 15) {
            if ((control).enter) {
                i_30_ = 4;
                this.pessd[4] = true;
            }
            if (i_30_ == i_33_ + 2) {
                if ((this.xt).nofull)
                    this.nflk = 30;
                else {
                    (this.xt).server = this.servers[1];
                    (this.xt).servername = this.snames[1];
                    (this.xt).servport = 7067;
                    (this.xt).lan = true;
                    i_30_ = -1;
                    this.fase = 18;
                    (lobby).fase = 0;
                }
            }
        }
        if (this.fase == 17) {
            if ((control).enter) {
                i_30_ = 4;
                this.pessd[4] = true;
            }
            if ((control).up) {
                this.opselect--;
                if (this.opselect == -1)
                    this.opselect = 4;
                (control).up = false;
            }
            if ((control).down) {
                this.opselect++;
                if (this.opselect == 5)
                    this.opselect = 0;
                (control).down = false;
            }
            for (int i_36_ = 0; i_36_ < 5; i_36_++) {
                if (i > 175 && i_28_ > 230 + i_36_ * 20 + 14 && i < 625 && i_28_ < 250 + i_36_ * 20 + 14 && i_29_ == 1)
                    this.opselect = i_36_;
            }
            if (i_30_ == i_33_ + 2) {
                if (this.rmps[this.opselect] >= 500 && !(this.xt).nickname.equals("Insano"))
                    this.nflk = 30;
                else {
                    (this.xt).servport = 7071 + this.opselect;
                    (this.xt).lan = false;
                    i_30_ = -1;
                    this.fase = 18;
                    (lobby).fase = 0;
                }
            }
        }
        if (this.fase == 3) {
            if (i > 295 && i_28_ > 334 && i < 505 && i_28_ < 348) {
                if (!this.onf) {
                    this.onf = true;
                    this.gs.setCursor(new Cursor(12));
                }
            } else if (this.onf) {
                this.onf = false;
                this.gs.setCursor(new Cursor(0));
            }
            if (this.onf && i_29_ == 11) {
                this.msg = "Please enter your Email Address to recover your account...";
                (this.gs).tnick.setForeground(new Color(0, 0, 0));
                (this.gs).tpass.setForeground(new Color(0, 0, 0));
                (this.gs).tnick.hide();
                (this.gs).tpass.hide();
                (this.gs).keplo.hide();
                this.onf = false;
                this.gs.setCursor(new Cursor(0));
                this.fase = 7;
            }
        }
        if (this.fase == 1) {
            if ((control).enter) {
                i_30_ = 2;
                this.pessd[2] = true;
            }
            if (i_30_ == 2) {
                if ((this.gs).tnick.getText().equals("Insano") || (this.gs).tnick.getText().equals("Nickname") || (this.gs).tnick.getText().equals("")) {
                    this.msg = "Type in any Nickname to play...";
                    (this.gs).tnick.setText("Nickname");
                    this.nflk = 30;
                } else {
                    this.msg = "| Checking Nickname |";
                    (this.gs).tnick.disable();
                    this.fase = 2;
                    this.connector = new Thread(this);
                    this.connector.start();
                }
            }
            if (i_30_ == 3) {
                if ((this.gs).tnick.getText().equals("Nickname") || this.msg.startsWith("This"))
                    (this.gs).tnick.setText("");
                this.msg = "Login to Account";
                (this.gs).tnick.setForeground(new Color(0, 0, 0));
                this.fase = 3;
                i_30_ = -1;
            }
            if (i_30_ == 4) {
                if (this.nickero || (this.gs).tnick.getText().equals("Nickname")) {
                    (this.gs).tnick.setText("");
                    this.nickero = false;
                }
                (this.gs).tnick.setForeground(new Color(0, 0, 0));
                this.gs.reglink();
            }
        }
        if (this.fase == 3) {
            if ((control).enter || (this.xt).autolog) {
                i_30_ = 2;
                this.pessd[2] = true;
                (this.xt).autolog = false;
            }
            if ((control).exit)
                i_30_ = 3;
            if (i_30_ == 2) {
                if ((this.gs).tnick.getText().equals("")) {
                    this.msg = "Enter your Nickname!";
                    this.nflk = 30;
                } else if ((this.gs).tpass.getText().equals("")) {
                    this.msg = "Enter your Password!";
                    this.nflk = 30;
                } else {
                    this.msg = "| Logging In |";
                    (this.gs).tnick.disable();
                    (this.gs).tpass.disable();
                    (this.gs).keplo.disable();
                    this.fase = 4;
                    this.connector = new Thread(this);
                    this.connector.start();
                }
            }
            if (i_30_ == 3)
                this.gs.reglink();
        }
        if (this.fase == 5) {
            if ((control).enter) {
                i_30_ = 1;
                this.pessd[1] = true;
            }
            if ((control).exit)
                i_30_ = 2;
            if (i_30_ != 1) {
                /* empty */
            }
            if (i_30_ == 2) {
                this.fase = this.lrgfase;
                if (this.fase == 12) {
                    (this.gs).tnick.hide();
                    this.connector = new Thread(this);
                    this.connector.start();
                }
            }
        }
        if (this.fase == 7) {
            if ((control).enter) {
                i_30_ = 2;
                this.pessd[2] = true;
            }
            if ((control).exit)
                i_30_ = 3;
            if (i_30_ == 2) {
                this.nflk = 0;
                if ((this.gs).temail.getText().equals("")) {
                    this.msg = "Please type in your Email Address!";
                    this.nflk = 30;
                }
                if (this.nflk == 0) {
                    String string = (this.gs).temail.getText();
                    int i_37_ = 0;
                    int i_38_ = 0;
                    for (/**/; i_37_ < string.length(); i_37_++) {
                        String string_39_ = new StringBuilder().append("").append(string.charAt(i_37_)).toString();
                        if (string_39_.equals("@") && i_38_ == 0 && i_37_ != 0)
                            i_38_ = 1;
                        if (string_39_.equals(".") && i_38_ == 1 && i_37_ != string.length() - 1)
                            i_38_ = 2;
                    }
                    if (i_38_ != 2) {
                        this.msg = "Please type in your Email Address correctly!";
                        this.nflk = 30;
                        this.errcnt = 40;
                        (this.gs).temail.setForeground(new Color(255, 0, 0));
                    }
                }
                if (this.nflk == 0) {
                    this.msg = "| Checking Email |";
                    (this.gs).temail.disable();
                    this.fase = 8;
                    this.connector = new Thread(this);
                    this.connector.start();
                }
            }
            if (i_30_ == 3) {
                inishmulti();
                (this.gs).temail.setText("");
                (this.gs).tpass.setText("");
            }
        }
        this.lxm = i;
        this.lym = i_28_;
        (control).enter = false;
        (control).exit = false;
    }
    
    public void drawSbutton(Image image, int i, int i_40_) {
        this.bx[this.btn] = i;
        this.by[this.btn] = i_40_;
        this.bw[this.btn] = image.getWidth(this.ob);
        if (!this.pessd[this.btn]) {
            this.rd.drawImage(image, i - this.bw[this.btn] / 2, i_40_ - image.getHeight(this.ob) / 2 - 1, null);
            this.rd.drawImage((this.xt).bols, i - this.bw[this.btn] / 2 - 15, i_40_ - 13, null);
            this.rd.drawImage((this.xt).bors, i + this.bw[this.btn] / 2 + 9, i_40_ - 13, null);
            this.rd.drawImage((this.xt).bot, i - this.bw[this.btn] / 2 - 9, i_40_ - 13, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage((this.xt).bob, i - this.bw[this.btn] / 2 - 9, i_40_ + 10, this.bw[this.btn] + 18, 3, null);
        } else {
            this.rd.drawImage(image, i - this.bw[this.btn] / 2 + 1, i_40_ - image.getHeight(this.ob) / 2, null);
            this.rd.drawImage((this.xt).bolps, i - this.bw[this.btn] / 2 - 15, i_40_ - 13, null);
            this.rd.drawImage((this.xt).borps, i + this.bw[this.btn] / 2 + 9, i_40_ - 13, null);
            this.rd.drawImage((this.xt).bob, i - this.bw[this.btn] / 2 - 9, i_40_ - 13, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage((this.xt).bot, i - this.bw[this.btn] / 2 - 9, i_40_ + 10, this.bw[this.btn] + 18, 3, null);
        }
        this.btn++;
    }
    
    public void drawbutton(Image image, int i, int i_41_) {
        this.bx[this.btn] = i;
        this.by[this.btn] = i_41_;
        this.bw[this.btn] = image.getWidth(this.ob);
        if (!this.pessd[this.btn]) {
            this.rd.drawImage(image, i - this.bw[this.btn] / 2, i_41_ - image.getHeight(this.ob) / 2, null);
            this.rd.drawImage((this.xt).bol, i - this.bw[this.btn] / 2 - 15, i_41_ - 16, null);
            this.rd.drawImage((this.xt).bor, i + this.bw[this.btn] / 2 + 9, i_41_ - 16, null);
            this.rd.drawImage((this.xt).bot, i - this.bw[this.btn] / 2 - 9, i_41_ - 16, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage((this.xt).bob, i - this.bw[this.btn] / 2 - 9, i_41_ + 13, this.bw[this.btn] + 18, 3, null);
        } else {
            this.rd.drawImage(image, i - this.bw[this.btn] / 2 + 1, i_41_ - image.getHeight(this.ob) / 2 + 1, null);
            this.rd.drawImage((this.xt).bolp, i - this.bw[this.btn] / 2 - 15, i_41_ - 16, null);
            this.rd.drawImage((this.xt).borp, i + this.bw[this.btn] / 2 + 9, i_41_ - 16, null);
            this.rd.drawImage((this.xt).bob, i - this.bw[this.btn] / 2 - 9, i_41_ - 16, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage((this.xt).bot, i - this.bw[this.btn] / 2 - 9, i_41_ + 13, this.bw[this.btn] + 18, 3, null);
        }
        this.btn++;
    }
    
    public void stringbutton(String string, int i, int i_42_, int i_43_) {
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        this.bx[this.btn] = i;
        this.by[this.btn] = i_42_ - 5;
        this.bw[this.btn] = this.ftm.stringWidth(string);
        if (!this.pessd[this.btn]) {
            this.rd.setColor(color2k(220, 220, 220));
            this.rd.fillRect(i - this.bw[this.btn] / 2 - 10, i_42_ - (17 - i_43_), this.bw[this.btn] + 20, 25 - i_43_ * 2);
            this.rd.setColor(color2k(240, 240, 240));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ - (17 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ - (17 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ - (18 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ - (18 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_42_ - (19 - i_43_), i + this.bw[this.btn] / 2 + 9, i_42_ - (19 - i_43_));
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 10, i_42_ - (17 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ + (7 - i_43_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 11, i_42_ - (17 - i_43_), i + this.bw[this.btn] / 2 + 11, i_42_ + (7 - i_43_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 12, i_42_ - (16 - i_43_), i + this.bw[this.btn] / 2 + 12, i_42_ + (6 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ + (7 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ + (7 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ + (8 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ + (8 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_42_ + (9 - i_43_), i + this.bw[this.btn] / 2 + 9, i_42_ + (9 - i_43_));
            this.rd.setColor(color2k(240, 240, 240));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ - (17 - i_43_), i - this.bw[this.btn] / 2 - 10, i_42_ + (7 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 11, i_42_ - (17 - i_43_), i - this.bw[this.btn] / 2 - 11, i_42_ + (7 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 12, i_42_ - (16 - i_43_), i - this.bw[this.btn] / 2 - 12, i_42_ + (6 - i_43_));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, i - this.bw[this.btn] / 2, i_42_);
        } else {
            this.rd.setColor(color2k(210, 210, 210));
            this.rd.fillRect(i - this.bw[this.btn] / 2 - 10, i_42_ - (17 - i_43_), this.bw[this.btn] + 20, 25 - i_43_ * 2);
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ - (17 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ - (17 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ - (18 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ - (18 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_42_ - (19 - i_43_), i + this.bw[this.btn] / 2 + 9, i_42_ - (19 - i_43_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 10, i_42_ - (17 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ + (7 - i_43_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 11, i_42_ - (17 - i_43_), i + this.bw[this.btn] / 2 + 11, i_42_ + (7 - i_43_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 12, i_42_ - (16 - i_43_), i + this.bw[this.btn] / 2 + 12, i_42_ + (6 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ + (7 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ + (7 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ + (8 - i_43_), i + this.bw[this.btn] / 2 + 10, i_42_ + (8 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_42_ + (9 - i_43_), i + this.bw[this.btn] / 2 + 9, i_42_ + (9 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_42_ - (17 - i_43_), i - this.bw[this.btn] / 2 - 10, i_42_ + (7 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 11, i_42_ - (17 - i_43_), i - this.bw[this.btn] / 2 - 11, i_42_ + (7 - i_43_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 12, i_42_ - (16 - i_43_), i - this.bw[this.btn] / 2 - 12, i_42_ + (6 - i_43_));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, i - this.bw[this.btn] / 2 + 1, i_42_);
        }
        this.btn++;
    }
    
    public Color color2k(int i, int i_44_, int i_45_) {
        Color color = new Color(i, i_44_, i_45_);
        float[] fs = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
        fs[0] = 0.13F;
        fs[1] = 0.35F;
        return Color.getHSBColor(fs[0], fs[1], fs[2]);
    }
    
    public void fixtext(TextField textfield) {
        String string = textfield.getText();
        string = string.replace('\"', '#');
        String string_46_ = "\\";
        String string_47_ = "";
        int i = 0;
        int i_48_ = -1;
        for (/**/; i < string.length(); i++) {
            String string_49_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            if (string_49_.equals("|") || string_49_.equals(",") || string_49_.equals("#") || string_49_.equals(string_46_) || string_49_.equals("!") || string_49_.equals("?") || string_49_.equals(" ") || string_49_.equals("~") || string_49_.equals("$") || string_49_.equals("%") || string_49_.equals("^") || string_49_.equals("&") || string_49_.equals("*") || string_49_.equals("+") || string_49_.equals("=") || string_49_.equals(">") || string_49_.equals("<") || string_49_.equals("/") || string_49_.equals("'") || string_49_.equals(";") || string_49_.equals(":") || string_49_.equals("\u00a0"))
                i_48_ = i;
            else
                string_47_ = new StringBuilder().append(string_47_).append(string_49_).toString();
        }
        if (i_48_ != -1) {
            textfield.setText(string_47_);
            textfield.select(i_48_, i_48_);
        }
    }
    
    public int getvalue(String string, int i) {
        int i_50_ = -1;
        try {
            int i_51_ = 0;
            int i_52_ = 0;
            int i_53_ = 0;
            String string_54_ = "";
            String string_55_ = "";
            for (/**/; i_51_ < string.length() && i_53_ != 2; i_51_++) {
                string_54_ = new StringBuilder().append("").append(string.charAt(i_51_)).toString();
                if (string_54_.equals("|")) {
                    i_52_++;
                    if (i_53_ == 1 || i_52_ > i)
                        i_53_ = 2;
                } else if (i_52_ == i) {
                    string_55_ = new StringBuilder().append(string_55_).append(string_54_).toString();
                    i_53_ = 1;
                }
            }
            if (string_55_.equals(""))
                string_55_ = "-1";
            i_50_ = Integer.valueOf(string_55_).intValue();
        } catch (Exception exception) {
            /* empty */
        }
        return i_50_;
    }
    
    public String getSvalue(String string, int i) {
        String string_56_ = "";
        try {
            int i_57_ = 0;
            int i_58_ = 0;
            int i_59_ = 0;
            String string_60_ = "";
            String string_61_ = "";
            for (/**/; i_57_ < string.length() && i_59_ != 2; i_57_++) {
                string_60_ = new StringBuilder().append("").append(string.charAt(i_57_)).toString();
                if (string_60_.equals("|")) {
                    i_58_++;
                    if (i_59_ == 1 || i_58_ > i)
                        i_59_ = 2;
                } else if (i_58_ == i) {
                    string_61_ = new StringBuilder().append(string_61_).append(string_60_).toString();
                    i_59_ = 1;
                }
            }
            string_56_ = string_61_;
        } catch (Exception exception) {
            /* empty */
        }
        return string_56_;
    }
}
