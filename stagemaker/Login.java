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
        m = medium;
        rd = graphics2d;
        xt = var_xtGraphics;
        gs = gamesparker;
        if ((xt).playingame != -1)
            fase = 18;
        if ((xt).nofull)
            nservers = 1;
    }
    
    public void inishmulti() {
        (gs).tnick.hide();
        (gs).tnick.enable();
        (gs).tnick.setForeground(new Color(0, 0, 0));
        (gs).tnick.setBackground(color2k(255, 255, 255));
        (gs).tpass.hide();
        (gs).tpass.enable();
        (gs).tpass.setForeground(new Color(0, 0, 0));
        (gs).tpass.setBackground(color2k(255, 255, 255));
        (gs).temail.hide();
        (gs).temail.enable();
        (gs).temail.setForeground(new Color(0, 0, 0));
        (gs).temail.setBackground(color2k(255, 255, 255));
        (gs).keplo.hide();
        (gs).keplo.enable();
        (gs).keplo.setForeground(new Color(0, 0, 0));
        (gs).keplo.setBackground(new Color(190, 166, 105));
        gs.requestFocus();
        if ((gs).tnick.getText().equals(""))
            (gs).tnick.setText("Nickname");
        for (int i = 0; i < 6; i++)
            pessd[i] = false;
        nflk = 0;
        ncnt = 0;
        errcnt = 0;
        onf = false;
        ond = false;
        msg = "";
        btroom = false;
        gotcai = false;
        (m).crs = true;
        (m).x = -335;
        (m).y = 0;
        (m).z = -50;
        (m).xz = 0;
        (m).zy = 20;
        (m).ground = -2000;
        pend = 0;
        pendb = false;
        resofaso = false;
        for (int i = 0; i < nservers; i++) {
            serverdone[i] = -1;
            servestart[i] = 0L;
        }
        if ((xt).gotlog) {
            socketson = false;
            fase = 12;
            connector = new Thread(this);
            connector.start();
        } else {
            msg = "Login to Account";
            (gs).tnick.setText((xt).nickname);
            fase = 3;
        }
    }
    
    public void exitfromlobby() {
        if (!(xt).lan)
            opselect = 0;
        else
            opselect = 1;
        for (int i = 0; i < nservers; i++) {
            serverdone[i] = -1;
            servestart[i] = 0L;
        }
        for (int i = 0; i < 6; i++)
            pessd[i] = false;
        gotcai = false;
        btroom = false;
        (m).crs = true;
        (m).x = -335;
        (m).y = 0;
        (m).z = -50;
        (m).xz = 0;
        (m).zy = 20;
        (m).ground = -2000;
        pend = 0;
        pendb = false;
        socketson = false;
        if (!(xt).lan) {
            msg = "| Connecting to Servers |";
            trans = 0;
            fase = 13;
            nflk = 0;
        } else
            fase = 12;
        System.gc();
        connector = new Thread(this);
        connector.start();
    }
    
    public void endcons() {
        for (int i = 0; i < nservers; i++) {
            try {
                dSocket[i].close();
                dSocket[i] = null;
            } catch (Exception exception) {
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
    }
    
    public void run() {
        if (fase == 2) {
            gs.setCursor(new Cursor(3));
            int i = -1;
            int i_0_ = -1;
            try {
                socket = new Socket(servers[0], 7061);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
                dout.println(new StringBuilder().append("0|").append((gs).tnick.getText()).append("|").toString());
                String string = din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                    if (i == 0) {
                        i_0_ = getvalue(string, 1);
                        (xt).hours = getvalue(string, 2);
                        (xt).nickey = getSvalue(string, 3);
                    }
                }
                socket.close();
                din.close();
                dout.close();
            } catch (Exception exception) {
                /* empty */
            }
            (gs).tnick.enable();
            if (i == -1) {
                msg = "Unable to connect to any server at this moment.  Please try again later.";
                fase = 1;
            }
            if (i == 0) {
                (xt).nickname = (gs).tnick.getText();
                if (i_0_ != -1)
                    (xt).nfreeplays = i_0_;
                (gs).tnick.hide();
                (gs).tpass.hide();
                (gs).temail.hide();
                (gs).keplo.hide();
                gs.requestFocus();
                (xt).logged = false;
                fase = 12;
                System.gc();
            }
            if (i == 1) {
                msg = "This Nickname is being used by someone else right now.  Please use another.";
                nickero = true;
                (gs).tnick.setForeground(new Color(255, 0, 0));
                (gs).tnick.requestFocus();
                errcnt = 30;
                fase = 1;
            }
            if (i == 2) {
                msg = "Nickname registerd.  Please use another or click 'Login' bellow to login to this Nickname.";
                nickero = true;
                (gs).tnick.setForeground(new Color(255, 0, 0));
                (gs).tnick.requestFocus();
                errcnt = 30;
                fase = 1;
            }
            gs.setCursor(new Cursor(0));
        }
        if (fase == 4) {
            gs.setCursor(new Cursor(3));
            int i = -1;
            String string = "";
            try {
                socket = new Socket(servers[0], 7061);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
                dout.println(new StringBuilder().append("1|").append((gs).tnick.getText()).append("|").append((gs).tpass.getText()).append("|").toString());
                string = din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                    if (i == 0 || i > 10 || i == -167)
                        (xt).nickey = getSvalue(string, 1);
                }
                socket.close();
                din.close();
                dout.close();
            } catch (Exception exception) {
                /* empty */
            }
            (gs).tnick.enable();
            (gs).tpass.enable();
            (gs).keplo.enable();
            if (i == -1) {
                msg = "Unable to connect to server at this moment.  Please try again later.";
                fase = 3;
            }
            if (i == 0 || i == 3 || i > 10 || i == -167 || i == 111) {
                (xt).nickname = (gs).tnick.getText();
                (gs).tnick.hide();
                (gs).tpass.hide();
                (gs).temail.hide();
                (gs).keplo.hide();
                gs.requestFocus();
                gs.setloggedcookie();
                btroom = false;
                (xt).logged = true;
                (xt).gotlog = true;
                if (i == 0)
                    (xt).acexp = 0;
                if (i > 10)
                    (xt).acexp = i - 10;
                if (i == 3)
                    (xt).acexp = -1;
                if (i == -167) {
                    (xt).logged = false;
                    (xt).acexp = -2;
                }
                if (i == 111) {
                    if (!(xt).backlog.toLowerCase().equals((gs).tnick.getText().toLowerCase())) {
                        (xt).logged = false;
                        (xt).acexp = -3;
                    } else
                        (xt).acexp = 0;
                }
                if ((xt).logged)
                    (xt).backlog = (xt).nickname;
                fase = 12;
                System.gc();
            }
            if (i == 1) {
                msg = "Sorry.  The Nickname you have entered is incorrect or does not exist.";
                (gs).tnick.setForeground(new Color(255, 0, 0));
                (gs).tnick.requestFocus();
                errcnt = 40;
                fase = 3;
            }
            if (i == 2) {
                msg = "Sorry.  The Password you have entered is incorrect.";
                (gs).tpass.setForeground(new Color(255, 0, 0));
                (gs).tpass.requestFocus();
                errcnt = 40;
                fase = 3;
            }
            gs.setCursor(new Cursor(0));
        }
        if (fase == 8) {
            gs.setCursor(new Cursor(3));
            int i = -1;
            try {
                socket = new Socket(servers[0], 7061);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
                dout.println(new StringBuilder().append("2|").append((gs).temail.getText().toLowerCase()).append("|").toString());
                String string = din.readLine();
                if (string != null)
                    i = getvalue(string, 0);
                socket.close();
                din.close();
                dout.close();
            } catch (Exception exception) {
                /* empty */
            }
            (gs).temail.enable();
            if (i == -1) {
                msg = "Unable to connect to server at this moment.  Please try again later.";
                fase = 7;
            }
            if (i == 0) {
                (gs).temail.hide();
                msg = new StringBuilder().append("Account details sent!  Please check your Email: ").append((gs).temail.getText()).append(" to login.").toString();
                (gs).temail.setText("");
                (gs).tnick.setText("");
                (gs).tpass.setText("");
                fase = 3;
            }
            if (i == 1) {
                msg = "Sorry.  This Email Address does not exist in our system!";
                (gs).temail.setForeground(new Color(255, 0, 0));
                errcnt = 40;
                fase = 7;
            }
            gs.setCursor(new Cursor(0));
        }
        if ((fase == 12 || fase == 13 || fase == 14 || fase == 15) && !socketson) {
            for (int i = 0; i < nservers; i++) {
                try {
                    serverdone[i] = -1;
                    IPAddress[i] = InetAddress.getByName(servers[i]);
                    dSocket[i] = new DatagramSocket(7001 + i);
                } catch (Exception exception) {
                    serverdone[i] = 5;
                }
            }
            srvtrn = 0;
            socketson = true;
        }
        while (fase == 12 || fase == 13 || fase == 14 || fase == 15) {
            if (srvtrn < nservers) {
                for (/**/; serverdone[srvtrn] < (xt).cntptrys; serverdone[srvtrn]++) {
                    if (serverdone[srvtrn] == -1)
                        serverdone[srvtrn] = 0;
                    Date date = new Date();
                    servestart[srvtrn] = date.getTime();
                    try {
                        byte[] is = new byte[4];
                        DatagramPacket datagrampacket = new DatagramPacket(is, is.length, IPAddress[srvtrn], 7000);
                        String string = new StringBuilder().append("").append((xt).nickname).append("|").toString();
                        byte[] is_1_ = string.getBytes();
                        datagrampacket.setData(is_1_);
                        dSocket[srvtrn].send(datagrampacket);
                        dSocket[srvtrn].receive(datagrampacket);
                        String string_2_ = new String(datagrampacket.getData());
                        if (string_2_.startsWith("OK")) {
                            date = new Date();
                            if (date.getTime() - servestart[srvtrn] < (long) (xt).delays[srvtrn])
                                (xt).delays[srvtrn] = (int) (date.getTime() - servestart[srvtrn]);
                        }
                    } catch (Exception exception) {
                        (xt).delays[srvtrn] = 600;
                        serverdone[srvtrn] = 5;
                    }
                }
                srvtrn++;
            } else if (fase == 13) {
                int i = -1;
                boolean bool = false;
                for (int i_3_ = 0; i_3_ < nservers; i_3_++) {
                    if ((xt).delays[i_3_] < i || i == -1) {
                        i = (xt).delays[i_3_];
                        opselect = i_3_;
                    }
                    if ((xt).delays[i_3_] >= 600)
                        bool = true;
                }
                if (!bool) {
                    (xt).cntptrys -= 2;
                    if ((xt).cntptrys < 1)
                        (xt).cntptrys = 1;
                }
                fase = 14;
            }
            try {
                if (connector != null) {
                    /* empty */
                }
                Thread.sleep(5L);
            } catch (InterruptedException interruptedexception) {
                /* empty */
            }
        }
        if (fase != 12 && fase != 13 && fase != 14 && fase != 15 && fase != 5 && socketson) {
            for (int i = 0; i < nservers; i++) {
                try {
                    dSocket[i].close();
                    dSocket[i] = null;
                } catch (Exception exception) {
                    /* empty */
                }
            }
            socketson = false;
        }
        if (fase == 16 || fase == 17) {
            boolean bool = false;
            int i = 0;
            int i_4_ = -1;
            recom = 0;
            try {
                socket = new Socket((xt).server, 7067);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception exception) {
                /* empty */
            }
            while ((fase == 16 || fase == 17) && i != 3) {
                String string = "";
                if (!bool) {
                    try {
                        dout.println("10|");
                        String string_5_ = din.readLine();
                        if (string_5_ == null)
                            bool = true;
                        else
                            string = string_5_;
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
                            socket = new Socket((xt).server, 7067);
                            din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            dout = new PrintWriter(socket.getOutputStream(), true);
                            dout.println("10|");
                            String string_6_ = din.readLine();
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
                            socket.close();
                            socket = null;
                        } catch (Exception exception) {
                            /* empty */
                        }
                    }
                }
                if (!bool) {
                    for (int i_7_ = 0; i_7_ < 5; i_7_++) {
                        rmps[i_7_] = getvalue(string, i_7_ * 2);
                        rmwt[i_7_] = getvalue(string, 1 + i_7_ * 2);
                    }
                    int i_8_ = 1000;
                    for (int i_9_ = 0; i_9_ < 5; i_9_++) {
                        if (Math.abs(rmps[i_9_] - 4) < i_8_ && rmps[i_9_] < 10) {
                            recom = i_9_;
                            i_8_ = Math.abs(rmps[i_9_] - 4);
                        }
                    }
                    if (recom != i_4_) {
                        opselect = recom;
                        i_4_ = recom;
                    }
                    if (fase == 16)
                        fase = 17;
                } else {
                    msg = "Failed to connect to this Server!";
                    i++;
                }
                if (i != 3) {
                    try {
                        if (connector != null) {
                            /* empty */
                        }
                        Thread.sleep(2000L);
                    } catch (InterruptedException interruptedexception) {
                        /* empty */
                    }
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
            if (i == 3)
                resofaso = true;
        }
    }
    
    public void stopallnow() {
        if (connector != null) {
            connector.stop();
            connector = null;
        }
        endcons();
    }
    
    public void multimode(ContO[] contos) {
        btn = 0;
        xt.mainbg(4);
        rd.drawImage((xt).multim, 295, 33, null);
        drawSbutton((xt).exit, 690, 42);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        if (!gotcai) {
            int i = ((contos[(xt).sc[0]]).p[0]).oz[0];
            int i_10_ = i;
            int i_11_ = ((contos[(xt).sc[0]]).p[0]).oy[0];
            int i_12_ = i_11_;
            for (int i_13_ = 0; i_13_ < (contos[(xt).sc[0]]).npl; i_13_++) {
                for (int i_14_ = 0; i_14_ < ((contos[(xt).sc[0]]).p[i_13_]).n; i_14_++) {
                    if (((contos[(xt).sc[0]]).p[i_13_]).oz[i_14_] < i)
                        i = ((contos[(xt).sc[0]]).p[i_13_]).oz[i_14_];
                    if (((contos[(xt).sc[0]]).p[i_13_]).oz[i_14_] > i_10_)
                        i_10_ = ((contos[(xt).sc[0]]).p[i_13_]).oz[i_14_];
                    if (((contos[(xt).sc[0]]).p[i_13_]).oy[i_14_] < i_11_)
                        i_11_ = ((contos[(xt).sc[0]]).p[i_13_]).oy[i_14_];
                    if (((contos[(xt).sc[0]]).p[i_13_]).oy[i_14_] > i_12_)
                        i_12_ = ((contos[(xt).sc[0]]).p[i_13_]).oy[i_14_];
                }
            }
            cax = (i_10_ + i) / 2;
            cay = (i_12_ + i_11_) / 2;
            gotcai = true;
        }
        (contos[(xt).sc[0]]).z = 1500;
        (contos[(xt).sc[0]]).y = 380 - cay;
        (contos[(xt).sc[0]]).x = 100 - cax;
        (contos[(xt).sc[0]]).zy = 0;
        (contos[(xt).sc[0]]).xz = -90;
        (contos[(xt).sc[0]]).xy = pend;
        contos[(xt).sc[0]].d(rd);
        if (!pendb) {
            pend += 2;
            if (pend > 80)
                pendb = true;
        } else {
            pend -= 2;
            if (pend < -10)
                pendb = false;
        }
        rd.setColor(new Color(0, 0, 0));
        rd.drawString((xt).nickname, 239 - ftm.stringWidth((xt).nickname) / 2, 105);
        rd.setColor(color2k(90, 90, 90));
        rd.drawRect(319, 83, 180, 96);
        rd.drawString(new StringBuilder().append("").append(((xt).cd).names[(xt).sc[0]]).append("").toString(), 409 - ftm.stringWidth(new StringBuilder().append("").append(((xt).cd).names[(xt).sc[0]]).append("").toString()) / 2, 81);
        rd.drawRect(173, 83, 132, 32);
        rd.drawString("Nickname", 239 - ftm.stringWidth("Nickname") / 2, 81);
        drawbutton((xt).change, 570, 98);
        if (!(xt).logged) {
            drawSbutton((xt).upgrade, 239, 135);
            drawSbutton((xt).logout, 239, 165);
        } else {
            drawSbutton((xt).logout, 239, 135);
            rd.setColor(new Color(98, 56, 0));
            rd.drawString("Edit my Account", 239 - ftm.stringWidth("Edit my Account") / 2, 168);
            if (ond)
                rd.drawLine(239 - ftm.stringWidth("Edit my Account") / 2, 169, 239 - ftm.stringWidth("Edit my Account") / 2 + ftm.stringWidth("Edit my Account"), 169);
        }
        if (fase == 12 || fase == 13 || fase == 14 || fase == 15) {
            int i = srvtrn;
            if (i < nservers && serverdone[i] != -1) {
                Date date = new Date();
                if (date.getTime() - servestart[i] > 1500L) {
                    if (connector != null) {
                        connector.stop();
                        connector = null;
                    }
                    (xt).delays[i] = 600;
                    serverdone[i] = 5;
                    connector = new Thread(this);
                    connector.start();
                }
            }
        }
        if (fase == 12) {
            if ((xt).acexp == 0 || contrb) {
                rd.setColor(color2k(90, 90, 90));
                rd.drawString("Multiplayer Mode", 400 - ftm.stringWidth("Multiplayer Mode") / 2, 220);
                rd.drawRoundRect(205, 225, 390, 120, 20, 20);
                rd.setColor(color2k(255, 255, 255));
                if (opselect == 0 && !pessd[3])
                    rd.drawImage((xt).filb, 400 - (xt).pon.getWidth(ob) / 2 - 6, 242, (xt).pon.getWidth(ob) + 12, 25, null);
                drawbutton((xt).pon, 400, 255);
                if (opselect == 1 && !pessd[4])
                    rd.drawImage((xt).filb, 400 - (xt).pln.getWidth(ob) / 2 - 6, 302, (xt).pln.getWidth(ob) + 12, 25, null);
                drawbutton((xt).pln, 400, 315);
            } else {
                rd.setColor(color2k(255, 255, 255));
                rd.fillRoundRect(165, 219, 470, 135, 20, 20);
                rd.setColor(new Color(0, 0, 0));
                rd.drawRoundRect(165, 219, 470, 135, 20, 20);
                if ((xt).acexp > 0) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(new StringBuilder().append("Dear ").append((xt).nickname).append(",").toString(), 185, 245);
                    rd.drawString(new StringBuilder().append("Your account is due to expire in ").append((xt).acexp).append(" days.").toString(), 185, 265);
                    rd.drawString("Please renew your registration.", 185, 295);
                    stringbutton("Renew my Account Registration now!", 345, 332, 0);
                    stringbutton("Renew Later", 524, 332, 0);
                }
                if ((xt).acexp == -1) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(new StringBuilder().append("Dear ").append((xt).nickname).append(",").toString(), 185, 245);
                    rd.drawString("Your Need for Madness account registration has expired.", 185, 265);
                    rd.drawString("Please renew your registration.", 185, 295);
                    stringbutton("Renew my account registration now!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if ((xt).acexp == -2) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(new StringBuilder().append("Dear ").append((xt).nickname).append(",").toString(), 185, 245);
                    rd.drawString("Trial accounts are not allowed to access the downloaded game.", 185, 265);
                    rd.drawString("You can only play the game online using your trial account.", 185, 295);
                    stringbutton("Play the multiplayer online!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if ((xt).acexp == -3) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Some one else is already logged in the game with your account.", 185, 245);
                    rd.drawString("If you where just in the game then quitted it suddenly, it could just", 185, 265);
                    rd.drawString("be your 'ghost entry', if so please wait a few minutes and try again.", 185, 285);
                    rd.drawString("Otherwise please consider changing your password.", 185, 305);
                    stringbutton("Change Password", 332, 336, 0);
                    stringbutton("Try Again", 494, 336, 0);
                }
            }
        }
        if (fase == 13 || fase == 14 || fase == 16 || fase == 17) {
            if (trans < 40)
                rd.drawImage((xt).pon, 400 - (xt).pon.getWidth(ob) / 2, 255 - (xt).pon.getHeight(ob) / 2 - 12 - trans, null);
            else
                rd.drawImage((xt).pon, 400 - (xt).pon.getWidth(ob) / 2, 215 - (xt).pon.getHeight(ob) / 2 - 12, null);
            if (trans >= 40) {
                rd.setColor(color2k(255, 255, 255));
                rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                rd.setColor(new Color(0, 0, 0));
                rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                drawbutton((xt).cancel, 583, 388);
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if (fase == 13) {
                    rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 295);
                    if (msg.equals(". . . | Connecting to Servers | . . .") && ncnt == 0) {
                        msg = "| Connecting to Servers |";
                        ncnt = 5;
                    }
                    if (msg.equals(". . | Connecting to Servers | . .") && ncnt == 0) {
                        msg = ". . . | Connecting to Servers | . . .";
                        ncnt = 5;
                    }
                    if (msg.equals(". | Connecting to Servers | .") && ncnt == 0) {
                        msg = ". . | Connecting to Servers | . .";
                        ncnt = 5;
                    }
                    if (msg.equals("| Connecting to Servers |") && ncnt == 0) {
                        msg = ". | Connecting to Servers | .";
                        ncnt = 5;
                    }
                    if (ncnt != 0)
                        ncnt--;
                }
                if (fase == 16) {
                    rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 295);
                    if (msg.equals(". . . | Finding Rooms | . . .") && ncnt == 0) {
                        msg = "| Finding Rooms |";
                        ncnt = 5;
                    }
                    if (msg.equals(". . | Finding Rooms | . .") && ncnt == 0) {
                        msg = ". . . | Finding Rooms | . . .";
                        ncnt = 5;
                    }
                    if (msg.equals(". | Finding Rooms | .") && ncnt == 0) {
                        msg = ". . | Finding Rooms | . .";
                        ncnt = 5;
                    }
                    if (msg.equals("| Finding Rooms |") && ncnt == 0) {
                        msg = ". | Finding Rooms | .";
                        ncnt = 5;
                    }
                    if (ncnt != 0)
                        ncnt--;
                }
                if (fase == 14) {
                    msg = "";
                    int i = 0;
                    if (!(xt).nofull) {
                        for (int i_15_ = 0; i_15_ < nservers; i_15_++) {
                            if ((xt).delays[i_15_] >= 400)
                                i++;
                        }
                    }
                    if (i != nservers) {
                        boolean bool = false;
                        boolean bool_16_ = false;
                        for (int i_17_ = 0; i_17_ < nservers; i_17_++) {
                            if (opselect == i_17_) {
                                rd.setColor(new Color(98, 56, 0));
                                rd.fillRoundRect(175, 230 + i_17_ * 20, 450, 20, 14, 14);
                                rd.setColor(new Color(255, 176, 67));
                                rd.drawRoundRect(175, 230 + i_17_ * 20, 450, 20, 14, 14);
                                rd.setColor(color2k(255, 255, 255));
                                if ((xt).delays[i_17_] >= 400) {
                                    msg = "Your connection to this server is too slow!";
                                    bool_16_ = true;
                                }
                                if ((xt).delays[i_17_] == 600) {
                                    msg = "This server is not responding!";
                                    bool_16_ = true;
                                }
                                if ((xt).delays[i_17_] < 400) {
                                    for (int i_18_ = 0; i_18_ < nservers; i_18_++) {
                                        if ((xt).delays[i_18_] < (xt).delays[i_17_] && i_17_ != i_18_)
                                            bool = true;
                                    }
                                    if (bool)
                                        msg = "We recommend choosing the fastest server!";
                                    else if ((xt).delays[i_17_] >= 300)
                                        msg = "Your connection speed is not perfect.  You may encounter delay!";
                                }
                            }
                            if (!(xt).logged && (xt).nfreeplays - (xt).ndisco >= 5 && !bool_16_) {
                                msg = "You have already played 5 games today, please register!";
                                jflk = true;
                            }
                            rd.drawString("Server Name :", 195, 245 + i_17_ * 20);
                            rd.drawString("|   Delay/Speed :", 385, 245 + i_17_ * 20);
                            int i_19_ = 0;
                            int i_20_ = 0;
                            String string = new StringBuilder().append("").append((xt).delays[i_17_]).append("/").toString();
                            if ((xt).delays[i_17_] < 75) {
                                string = new StringBuilder().append(string).append("EXCELENT *****").toString();
                                i_19_ = 125;
                                i_20_ = 200;
                            }
                            if ((xt).delays[i_17_] >= 75 && (xt).delays[i_17_] < 150) {
                                string = new StringBuilder().append(string).append("Perfect ****").toString();
                                i_19_ = 125;
                                i_20_ = 200;
                            }
                            if ((xt).delays[i_17_] >= 150 && (xt).delays[i_17_] < 250) {
                                string = new StringBuilder().append(string).append("Good ***").toString();
                                i_19_ = 162;
                                i_20_ = 200;
                            }
                            if ((xt).delays[i_17_] >= 250 && (xt).delays[i_17_] < 400) {
                                string = new StringBuilder().append(string).append("Acceptable **").toString();
                                i_19_ = 200;
                                i_20_ = 200;
                            }
                            if ((xt).delays[i_17_] >= 400 && (xt).delays[i_17_] < 600) {
                                string = new StringBuilder().append(string).append("Poor").toString();
                                i_19_ = 200;
                                i_20_ = 0;
                            }
                            if ((xt).delays[i_17_] == 600)
                                string = "Not Responding";
                            if (opselect == i_17_) {
                                i_19_ *= 1.27F;
                                i_20_ *= 1.27F;
                            }
                            rd.setColor(new Color(i_19_, i_20_, 0));
                            rd.drawString(new StringBuilder().append("").append(snames[i_17_]).append("").toString(), 294, 245 + i_17_ * 20);
                            rd.drawString(string, 497, 245 + i_17_ * 20);
                            rd.setColor(new Color(0, 0, 0));
                        }
                        if ((xt).nofull) {
                            if (nflk % 4 != 0 || nflk == 0) {
                                rd.setFont(new Font("Arial", 0, 13));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(200, 0, 0));
                                rd.drawString("Warning! You did not allow the game full permissions when you started it.", 175, 275);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 292);
                                rd.drawString("Because of this you will be able to connect to ONLY the game's main server:", 175, 309);
                                rd.drawString(new StringBuilder().append("'").append(snames[0]).append("', which is not necessarily the fastest server you can connect to.").toString(), 175, 326);
                                rd.drawString("Please allow Java full permissions next time to be able to play on all servers!", 175, 343);
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                            }
                        } else {
                            if (bool_16_)
                                rd.setColor(new Color(200, 0, 0));
                            else if (jflk) {
                                rd.setColor(new Color(98, 56, 0));
                                jflk = false;
                            } else {
                                rd.setColor(new Color(255, 176, 67));
                                jflk = true;
                            }
                            if (nflk % 4 != 0 || nflk == 0)
                                rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 360);
                            if (nflk != 0)
                                nflk--;
                        }
                    } else {
                        if (nflk % 4 != 0 || nflk == 0) {
                            rd.setColor(new Color(200, 0, 0));
                            rd.drawString("Sorry.  Your connection is currently not fast enough to play online!", 400 - ftm.stringWidth("Sorry.  Your connection is currently not fast enough to play online!") / 2, 242);
                        }
                        if (nflk != 0)
                            nflk--;
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 0, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("Please make sure you or anyone else using this connection is not slowing", 181, 265);
                        rd.drawString("it down right now by downloading or streaming.", 181, 282);
                        rd.drawString("Also please make sure you don't have any other programs running on your", 181, 299);
                        rd.drawString("computer that maybe consuming your bandwidth.", 181, 316);
                        rd.drawString("Otherwise you may need to upgrade your connection speed to play!", 181, 333);
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("Press 'Cancel' to try again or to try playing a Lan game instead.", 400 - ftm.stringWidth("Press 'Cancel' to try again or to try playing a Lan game instead.") / 2, 357);
                    }
                    drawbutton((xt).play, 400, 395);
                }
                if (fase == 17) {
                    int i_21_ = 14;
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(new StringBuilder().append(": :   ").append((xt).servername).append("   : :").toString(), 400 - ftm.stringWidth(new StringBuilder().append(": :   ").append((xt).servername).append("   : :").toString()) / 2, 239);
                    for (int i_22_ = 0; i_22_ < 5; i_22_++) {
                        if (opselect == i_22_) {
                            rd.setColor(new Color(98, 56, 0));
                            rd.fillRoundRect(175, 230 + i_22_ * 20 + i_21_, 450, 20, 14, 14);
                            rd.setColor(new Color(255, 176, 67));
                            rd.drawRoundRect(175, 230 + i_22_ * 20 + i_21_, 450, 20, 14, 14);
                            rd.setColor(color2k(255, 255, 255));
                        }
                        rd.drawString(new StringBuilder().append("Room ").append(i_22_ + 1).append(" :").toString(), 247, 245 + i_22_ * 20 + i_21_);
                        rd.drawString(new StringBuilder().append("").append(rmps[i_22_]).append(" / 10  Players").toString(), 405 - ftm.stringWidth(new StringBuilder().append("").append(rmps[i_22_]).append(" / 10  Players").toString()), 245 + i_22_ * 20 + i_21_);
                        String string = "";
                        if (i_22_ == recom) {
                            if (opselect != i_22_)
                                rd.setColor(new Color(125, 200, 0));
                            else
                                rd.setColor(new Color(160, 255, 0));
                            string = "<  Recommended";
                        }
                        if (rmps[i_22_] >= 10) {
                            if (opselect != i_22_)
                                rd.setColor(new Color(200, 0, 0));
                            else
                                rd.setColor(new Color(255, 0, 0));
                            //rmps[i_22_] = 10;
                            string = "Hacked by chris <3";
                        }
                        if (!string.equals(""))
                            rd.drawString(string, 485 - ftm.stringWidth(string) / 2, 245 + i_22_ * 20 + i_21_);
                        rd.setColor(new Color(0, 0, 0));
                    }
                    /*if (i == 5) {
                        if (nflk % 4 != 0 || nflk == 0) {
                            rd.setColor(new Color(200, 0, 0));
                            rd.drawString("All rooms are currenlty full. Please wait and a room will be availble.", 400 - ftm.stringWidth("All rooms are currenlty full. Please wait and a room will be availble.") / 2, 360);
                        }
                        if (nflk != 0)
                            nflk--;
                    } else */if (rmps[opselect] >= 500) {
                        if (nflk != 0)
                            nflk--;
                        if (nflk % 4 != 0 || nflk == 0) {
                            rd.setColor(new Color(200, 0, 0));
                            rd.drawString("500 players? Seriously?", 400 - ftm.stringWidth("Sorry.  This room is currently full.") / 2, 360);
                        }
                    }
                    drawbutton((xt).play, 400, 395);
                }
            } else
                trans += 8;
        }
        if (fase == 15) {
            if (trans < 100)
                rd.drawImage((xt).pln, 400 - (xt).pln.getWidth(ob) / 2, 315 - (xt).pln.getHeight(ob) / 2 - 12 - trans, null);
            else
                rd.drawImage((xt).pln, 400 - (xt).pln.getWidth(ob) / 2, 215 - (xt).pln.getHeight(ob) / 2 - 12, null);
            if (trans >= 100) {
                rd.setColor(color2k(255, 255, 255));
                rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                rd.setColor(new Color(0, 0, 0));
                rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if ((xt).nofull) {
                    if (nflk % 4 != 0 || nflk == 0) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(200, 0, 0));
                        rd.drawString("Sorry. You did not allow the game full permissions when you started it.", 175, 242);
                        rd.setFont(new Font("Arial", 0, 13));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 262);
                        rd.drawString("Because of this the game will not be able to create LAN connections!", 175, 288);
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("Please restart the game and allow Java full permissions to be able to", 175, 315);
                        rd.drawString("play LAN games!", 175, 332);
                        rd.setFont(new Font("Arial", 0, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("(Close ALL browser windows including this one then", 295, 332);
                        rd.drawString("start the game again but click 'Run' when asked to 'run this application'. )", 175, 349);
                    }
                    if (nflk != 0)
                        nflk--;
                } else {
                    rd.drawString("Play a multiplayer game across your Local Area Network (LAN).", 179, 245);
                    rd.drawString("Experience the game live with zero delay and 100% real-time action!", 179, 262);
                    rd.setFont(new Font("Arial", 0, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("This is for if there is more then one computer connected to your network or", 179, 292);
                    rd.drawString("if you are in a computer lab or in an internet caf\u00e9.", 179, 309);
                    rd.drawString("You can also invite your friends to come over with their Laptop PCs or Macs", 179, 335);
                    rd.drawString("to log on to your internet connection/network and play with you!", 179, 352);
                }
                drawbutton((xt).cancel, 583, 388);
                drawbutton((xt).play, 400, 395);
            } else
                trans += 10;
        }
        if (resofaso) {
            resofaso = false;
            if (connector != null) {
                connector.stop();
                connector = null;
            }
            socketson = false;
            msg = "| Connecting to Servers |";
            fase = 13;
            connector = new Thread(this);
            connector.start();
        }
    }
    
    public void multistart(ContO[] contos) {
        btn = 0;
        xt.mainbg(4);
        rd.drawImage((xt).multim, 295, 33, null);
        drawSbutton((xt).exit, 690, 42);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        if (fase != 5) {
            if (!gotcai) {
                int i = ((contos[(xt).sc[0]]).p[0]).oz[0];
                int i_23_ = i;
                int i_24_ = ((contos[(xt).sc[0]]).p[0]).oy[0];
                int i_25_ = i_24_;
                for (int i_26_ = 0; i_26_ < (contos[(xt).sc[0]]).npl; i_26_++) {
                    for (int i_27_ = 0; i_27_ < ((contos[(xt).sc[0]]).p[i_26_]).n; i_27_++) {
                        if (((contos[(xt).sc[0]]).p[i_26_]).oz[i_27_] < i)
                            i = ((contos[(xt).sc[0]]).p[i_26_]).oz[i_27_];
                        if (((contos[(xt).sc[0]]).p[i_26_]).oz[i_27_] > i_23_)
                            i_23_ = ((contos[(xt).sc[0]]).p[i_26_]).oz[i_27_];
                        if (((contos[(xt).sc[0]]).p[i_26_]).oy[i_27_] < i_24_)
                            i_24_ = ((contos[(xt).sc[0]]).p[i_26_]).oy[i_27_];
                        if (((contos[(xt).sc[0]]).p[i_26_]).oy[i_27_] > i_25_)
                            i_25_ = ((contos[(xt).sc[0]]).p[i_26_]).oy[i_27_];
                    }
                }
                cax = (i_23_ + i) / 2;
                cay = (i_25_ + i_24_) / 2;
                gotcai = true;
            }
            (contos[(xt).sc[0]]).z = 1500;
            (contos[(xt).sc[0]]).y = 360 - cay;
            (contos[(xt).sc[0]]).x = -170 - cax;
            (contos[(xt).sc[0]]).zy = 0;
            (contos[(xt).sc[0]]).xz = -90;
            (contos[(xt).sc[0]]).xy = pend;
            contos[(xt).sc[0]].d(rd);
            if (!pendb) {
                pend += 2;
                if (pend > 80)
                    pendb = true;
            } else {
                pend -= 2;
                if (pend < -10)
                    pendb = false;
            }
            rd.setColor(color2k(70, 70, 70));
            rd.drawRect(246, 83, 180, 96);
            rd.drawString(new StringBuilder().append("").append(((xt).cd).names[(xt).sc[0]]).append("").toString(), 336 - ftm.stringWidth(new StringBuilder().append("").append(((xt).cd).names[(xt).sc[0]]).append("").toString()) / 2, 81);
            drawbutton((xt).change, 497, 98);
        }
        if (fase == 1 || fase == 2) {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 205);
            rd.drawString("Enter a Nickname:", 400 - ftm.stringWidth("Enter a Nickname:") - 14, 241);
            if (fase == 2) {
                if (msg.equals(". . . | Checking Nickname | . . .") && ncnt == 0) {
                    msg = "| Checking Nickname |";
                    ncnt = 5;
                }
                if (msg.equals(". . | Checking Nickname | . .") && ncnt == 0) {
                    msg = ". . . | Checking Nickname | . . .";
                    ncnt = 5;
                }
                if (msg.equals(". | Checking Nickname | .") && ncnt == 0) {
                    msg = ". . | Checking Nickname | . .";
                    ncnt = 5;
                }
                if (msg.equals("| Checking Nickname |") && ncnt == 0) {
                    msg = ". | Checking Nickname | .";
                    ncnt = 5;
                }
                if (ncnt != 0)
                    ncnt--;
                pessd[2] = true;
            }
            if (fase == 1 && !(gs).tnick.isShowing()) {
                (gs).tnick.show();
                (gs).tnick.requestFocus();
                if ((gs).tnick.getText().equals("Nickname"))
                    (gs).tnick.select(8, 8);
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0)
                    (gs).tnick.setForeground(new Color(0, 0, 0));
            }
            drawbutton((xt).play, 400, 285);
            if (nflk > 0) {
                if ((gs).tnick.getText().equals("")) {
                    (gs).tnick.setText("Nickname");
                    if (nflk == 1)
                        (gs).tnick.select(8, 8);
                } else
                    (gs).tnick.setText("");
                nflk--;
            }
            drawbutton((xt).login, 400, 340);
            drawbutton((xt).register, 400, 395);
            gs.movefield((gs).tnick, 400, 225, 129, 23);
            while (ftm.stringWidth((gs).tnick.getText()) > 86) {
                (gs).tnick.setText((gs).tnick.getText().substring(0, (gs).tnick.getText().length() - 1));
                (gs).tnick.select((gs).tnick.getText().length(), (gs).tnick.getText().length());
            }
            if (!(gs).tnick.getText().equals(lnick)) {
                fixtext((gs).tnick);
                lnick = (gs).tnick.getText();
            }
            if (xt.msgcheck((gs).tnick.getText()))
                (gs).tnick.setText("");
            if ((gs).tnick.getText().toLowerCase().indexOf("madbot") != -1)
                (gs).tnick.setText("");
        }
        if (fase == 3 || fase == 4) {
            rd.setColor(new Color(0, 0, 0));
            if (nflk % 4 != 0 || nflk == 0)
                rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 205);
            if (nflk != 0)
                nflk--;
            rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 237);
            rd.drawString("Password:", 376 - ftm.stringWidth("Password:") - 14, 267);
            if (fase == 4) {
                if (msg.equals(". . . | Logging In | . . .") && ncnt == 0) {
                    msg = "| Logging In |";
                    ncnt = 5;
                }
                if (msg.equals(". . | Logging In | . .") && ncnt == 0) {
                    msg = ". . . | Logging In | . . .";
                    ncnt = 5;
                }
                if (msg.equals(". | Logging In | .") && ncnt == 0) {
                    msg = ". . | Logging In | . .";
                    ncnt = 5;
                }
                if (msg.equals("| Logging In |") && ncnt == 0) {
                    msg = ". | Logging In | .";
                    ncnt = 5;
                }
                if (ncnt != 0)
                    ncnt--;
                pessd[2] = true;
            }
            if (fase == 3) {
                if (!(gs).keplo.isShowing())
                    (gs).keplo.show();
                if (!(gs).tpass.isShowing()) {
                    (gs).tpass.show();
                    if (!(gs).tnick.getText().equals(""))
                        (gs).tpass.requestFocus();
                }
                if (!(gs).tnick.isShowing()) {
                    (gs).tnick.show();
                    if ((gs).tnick.getText().equals(""))
                        (gs).tnick.requestFocus();
                }
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0) {
                    (gs).tpass.setText("");
                    (gs).tnick.setForeground(new Color(0, 0, 0));
                    (gs).tpass.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton((xt).login, 400, 315);
            if (onf)
                rd.setColor(color2k(0, 72, 255));
            else
                rd.setColor(color2k(120, 120, 120));
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.drawString("Forgot your nickname or password?", 400 - ftm.stringWidth("Forgot your nickname or password?") / 2, 345);
            drawbutton((xt).register, 400, 395);
            gs.movefield((gs).keplo, 376, 275, 129, 23);
            gs.movefield((gs).tnick, 376, 221, 129, 23);
            if (!(gs).tnick.getText().equals(lnick)) {
                fixtext((gs).tnick);
                lnick = (gs).tnick.getText();
            }
            gs.movefield((gs).tpass, 376, 251, 129, 23);
            if (!(gs).tpass.getText().equals(lpass)) {
                fixtext((gs).tpass);
                lpass = (gs).tpass.getText();
            }
        }
        if (fase == 5) {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 141);
            gs.movefield((gs).tnick, 376, 125, 129, 23);
            while (ftm.stringWidth((gs).tnick.getText()) > 86) {
                (gs).tnick.setText((gs).tnick.getText().substring(0, (gs).tnick.getText().length() - 1));
                (gs).tnick.select((gs).tnick.getText().length(), (gs).tnick.getText().length());
            }
            if (!(gs).tnick.getText().equals(lnick)) {
                fixtext((gs).tnick);
                lnick = (gs).tnick.getText();
            }
            if (!(gs).tnick.isShowing())
                (gs).tnick.show();
            drawbutton((xt).register, 400, 325);
            drawbutton((xt).cancel, 400, 375);
        }
        if (fase == 7 || fase == 8) {
            rd.setColor(new Color(0, 0, 0));
            if (nflk % 4 != 0 || nflk == 0)
                rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 205);
            if (nflk != 0)
                nflk--;
            rd.drawString("Your Email:", 344 - ftm.stringWidth("Your Email:") - 14, 241);
            if (fase == 8) {
                if (msg.equals(". . . | Checking Email | . . .") && ncnt == 0) {
                    msg = "| Checking Email |";
                    ncnt = 5;
                }
                if (msg.equals(". . | Checking Email | . .") && ncnt == 0) {
                    msg = ". . . | Checking Email | . . .";
                    ncnt = 5;
                }
                if (msg.equals(". | Checking Email | .") && ncnt == 0) {
                    msg = ". . | Checking Email | . .";
                    ncnt = 5;
                }
                if (msg.equals("| Checking Email |") && ncnt == 0) {
                    msg = ". | Checking Email | .";
                    ncnt = 5;
                }
                if (ncnt != 0)
                    ncnt--;
                pessd[2] = true;
            }
            if (fase == 7 && !(gs).temail.isShowing()) {
                (gs).temail.show();
                (gs).temail.requestFocus();
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0)
                    (gs).temail.setForeground(new Color(0, 0, 0));
            }
            drawbutton((xt).sdets, 400, 280);
            drawbutton((xt).cancel, 400, 375);
            gs.movefield((gs).temail, 344, 225, 199, 23);
            if (!(gs).temail.getText().equals(lemail)) {
                fixtext((gs).temail);
                lemail = (gs).temail.getText();
            }
        }
    }
    
    public void ctachm(int i, int i_28_, int i_29_, Control control, Lobby lobby) {
        int i_30_ = -1;
        if (fase != 2 && fase != 4 && fase != 6 && fase != 8 && fase != 9) {
            for (int i_31_ = 0; i_31_ < btn; i_31_++) {
                if (Math.abs(i - bx[i_31_]) < bw[i_31_] / 2 + 12 && Math.abs(i_28_ - by[i_31_]) < 14 && (i_29_ == 1 || i_29_ == 11))
                    pessd[i_31_] = true;
                else
                    pessd[i_31_] = false;
                if (Math.abs(i - bx[i_31_]) < bw[i_31_] / 2 + 12 && Math.abs(i_28_ - by[i_31_]) < 14 && i_29_ <= -1) {
                    (gs).mouses = 0;
                    i_30_ = i_31_;
                }
                if (fase == 12) {
                    int i_32_ = 3;
                    if (!(xt).logged)
                        i_32_ = 4;
                    if (Math.abs(i - bx[i_31_]) < bw[i_31_] / 2 + 12 && Math.abs(i_28_ - by[i_31_]) < 14 && (i_31_ == i_32_ || i_31_ == i_32_ + 1) && (i != lxm || i_28_ != lym))
                        opselect = i_31_ - i_32_;
                }
            }
        }
        if (i_30_ == 0) {
            (gs).tnick.hide();
            (gs).tpass.hide();
            (gs).keplo.hide();
            (gs).temail.hide();
            gs.requestFocus();
            (xt).fase = 24;
        }
        if (i_30_ == 1 && fase != 5) {
            (gs).tnick.hide();
            (gs).tpass.hide();
            (gs).keplo.hide();
            (gs).temail.hide();
            gs.requestFocus();
            (xt).fase = 23;
        }
        int i_33_ = 2;
        if (fase == 12 || fase == 13 || fase == 14 || fase == 15 || fase == 16 || fase == 17) {
            if ((xt).logged) {
                if (i > 173 && i_28_ > 150 && i < 300 && i_28_ < 178) {
                    if (!ond) {
                        ond = true;
                        gs.setCursor(new Cursor(12));
                    }
                } else if (ond) {
                    ond = false;
                    gs.setCursor(new Cursor(0));
                }
                if (cntcl == 0) {
                    if (ond && i_29_ == 11) {
                        gs.editlink((xt).nickname);
                        cntcl = 10;
                    }
                } else
                    cntcl--;
            } else {
                if (i_30_ == 2)
                    gs.editlink((xt).nickname);
                i_33_ = 3;
            }
            if (i_30_ == i_33_) {
                i_30_ = -1;
                if ((xt).sc[0] >= 16) {
                    (xt).sc[0] = 15;
                    gotcai = false;
                }
                (xt).logged = false;
                (xt).gotlog = false;
                (gs).keplo.setState(false);
                gs.setloggedcookie();
                ((xt).cd).msloaded = 0;
                ((xt).cd).lastload = 0;
                msg = "Login to Account";
                fase = 3;
            }
        }
        if (fase == 12) {
            if ((xt).acexp == 0 || contrb) {
                if ((control).up) {
                    opselect--;
                    if (opselect == -1)
                        opselect = 1;
                    (control).up = false;
                }
                if ((control).down) {
                    opselect++;
                    if (opselect == 2)
                        opselect = 0;
                    (control).down = false;
                }
                if ((control).enter) {
                    i_30_ = opselect + 3;
                    (control).enter = false;
                }
                if (i_30_ == i_33_ + 1) {
                    msg = "| Connecting to Servers |";
                    opselect = 0;
                    trans = 0;
                    fase = 13;
                    nflk = 0;
                    i_30_ = -1;
                }
                if (i_30_ == i_33_ + 2) {
                    trans = 0;
                    fase = 15;
                    i_30_ = -1;
                }
            } else {
                if ((xt).acexp > 0) {
                    if (i_30_ == i_33_ + 1 || (control).enter) {
                        gs.editlink((xt).nickname);
                        i_30_ = -1;
                    }
                    if (i_30_ == i_33_ + 2) {
                        opselect = 0;
                        contrb = true;
                        i_30_ = -1;
                    }
                }
                if ((xt).acexp == -1) {
                    if (i_30_ == i_33_ + 1 || (control).enter) {
                        gs.editlink((xt).nickname);
                        i_30_ = -1;
                    }
                    if (i_30_ == i_33_ + 2) {
                        i_30_ = -1;
                        if ((xt).sc[0] >= 16) {
                            (xt).sc[0] = 15;
                            gotcai = false;
                        }
                        (xt).logged = false;
                        ((xt).cd).lastload = 0;
                        msg = "Login to Account";
                        fase = 3;
                    }
                }
                if ((xt).acexp == -2) {
                    if (i_30_ == i_33_ + 1 || (control).enter) {
                        gs.multlink();
                        i_30_ = -1;
                    }
                    if (i_30_ == i_33_ + 2) {
                        i_30_ = -1;
                        if ((xt).sc[0] >= 16) {
                            (xt).sc[0] = 15;
                            gotcai = false;
                        }
                        (xt).logged = false;
                        ((xt).cd).lastload = 0;
                        msg = "Login to Account";
                        fase = 3;
                    }
                }
                if ((xt).acexp == -3) {
                    if (i_30_ == i_33_ + 1 || (control).enter) {
                        gs.editlink((xt).nickname);
                        i_30_ = -1;
                    }
                    if (i_30_ == i_33_ + 2) {
                        i_30_ = -1;
                        if ((xt).sc[0] >= 16) {
                            (xt).sc[0] = 15;
                            gotcai = false;
                        }
                        (xt).logged = false;
                        ((xt).cd).lastload = 0;
                        msg = "Login to Account";
                        fase = 3;
                    }
                }
            }
        }
        if (fase == 13 || fase == 14 || fase == 15 || fase == 16 || fase == 17) {
            if ((control).exit)
                i_30_ = 3;
            if (i_30_ == i_33_ + 1) {
                if (fase == 15)
                    opselect = 1;
                else
                    opselect = 0;
                if (fase == 16 || fase == 17) {
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
                    } catch (Exception exception) {
                        /* empty */
                    }
                    fase = 12;
                    connector = new Thread(this);
                    connector.start();
                }
                if (fase == 14) {
                    if (connector != null) {
                        connector.stop();
                        connector = null;
                    }
                    for (int i_34_ = 0; i_34_ < nservers; i_34_++) {
                        try {
                            dSocket[i_34_].close();
                            dSocket[i_34_] = null;
                        } catch (Exception exception) {
                            /* empty */
                        }
                    }
                    socketson = false;
                    fase = 12;
                    connector = new Thread(this);
                    connector.start();
                }
                fase = 12;
                gs.setCursor(new Cursor(0));
            }
        }
        if (fase == 14) {
            if ((control).enter) {
                i_30_ = 4;
                pessd[4] = true;
            }
            if ((control).up) {
                opselect--;
                if (opselect == -1)
                    opselect = nservers - 1;
                (control).up = false;
            }
            if ((control).down) {
                opselect++;
                if (opselect == nservers)
                    opselect = 0;
                (control).down = false;
            }
            for (int i_35_ = 0; i_35_ < nservers; i_35_++) {
                if (i > 175 && i_28_ > 230 + i_35_ * 20 && i < 625 && i_28_ < 250 + i_35_ * 20 && i_29_ == 1)
                    opselect = i_35_;
            }
            if (i_30_ == i_33_ + 2) {
                if ((xt).delays[opselect] >= 400 && !(xt).nickname.equals("Insano"))
                    nflk = 30;
                else {
                    (xt).server = servers[opselect];
                    (xt).servername = snames[opselect];
                    msg = "| Finding Rooms |";
                    opselect = 0;
                    nflk = 0;
                    i_30_ = -1;
                    fase = 16;
                }
            }
        }
        if (fase == 15) {
            if ((control).enter) {
                i_30_ = 4;
                pessd[4] = true;
            }
            if (i_30_ == i_33_ + 2) {
                if ((xt).nofull)
                    nflk = 30;
                else {
                    (xt).server = servers[1];
                    (xt).servername = snames[1];
                    (xt).servport = 7067;
                    (xt).lan = true;
                    i_30_ = -1;
                    fase = 18;
                    (lobby).fase = 0;
                }
            }
        }
        if (fase == 17) {
            if ((control).enter) {
                i_30_ = 4;
                pessd[4] = true;
            }
            if ((control).up) {
                opselect--;
                if (opselect == -1)
                    opselect = 4;
                (control).up = false;
            }
            if ((control).down) {
                opselect++;
                if (opselect == 5)
                    opselect = 0;
                (control).down = false;
            }
            for (int i_36_ = 0; i_36_ < 5; i_36_++) {
                if (i > 175 && i_28_ > 230 + i_36_ * 20 + 14 && i < 625 && i_28_ < 250 + i_36_ * 20 + 14 && i_29_ == 1)
                    opselect = i_36_;
            }
            if (i_30_ == i_33_ + 2) {
                if (rmps[opselect] >= 500 && !(xt).nickname.equals("Insano"))
                    nflk = 30;
                else {
                    (xt).servport = 7071 + opselect;
                    (xt).lan = false;
                    i_30_ = -1;
                    fase = 18;
                    (lobby).fase = 0;
                }
            }
        }
        if (fase == 3) {
            if (i > 295 && i_28_ > 334 && i < 505 && i_28_ < 348) {
                if (!onf) {
                    onf = true;
                    gs.setCursor(new Cursor(12));
                }
            } else if (onf) {
                onf = false;
                gs.setCursor(new Cursor(0));
            }
            if (onf && i_29_ == 11) {
                msg = "Please enter your Email Address to recover your account...";
                (gs).tnick.setForeground(new Color(0, 0, 0));
                (gs).tpass.setForeground(new Color(0, 0, 0));
                (gs).tnick.hide();
                (gs).tpass.hide();
                (gs).keplo.hide();
                onf = false;
                gs.setCursor(new Cursor(0));
                fase = 7;
            }
        }
        if (fase == 1) {
            if ((control).enter) {
                i_30_ = 2;
                pessd[2] = true;
            }
            if (i_30_ == 2) {
                if ((gs).tnick.getText().equals("Insano") || (gs).tnick.getText().equals("Nickname") || (gs).tnick.getText().equals("")) {
                    msg = "Type in any Nickname to play...";
                    (gs).tnick.setText("Nickname");
                    nflk = 30;
                } else {
                    msg = "| Checking Nickname |";
                    (gs).tnick.disable();
                    fase = 2;
                    connector = new Thread(this);
                    connector.start();
                }
            }
            if (i_30_ == 3) {
                if ((gs).tnick.getText().equals("Nickname") || msg.startsWith("This"))
                    (gs).tnick.setText("");
                msg = "Login to Account";
                (gs).tnick.setForeground(new Color(0, 0, 0));
                fase = 3;
                i_30_ = -1;
            }
            if (i_30_ == 4) {
                if (nickero || (gs).tnick.getText().equals("Nickname")) {
                    (gs).tnick.setText("");
                    nickero = false;
                }
                (gs).tnick.setForeground(new Color(0, 0, 0));
                gs.reglink();
            }
        }
        if (fase == 3) {
            if ((control).enter || (xt).autolog) {
                i_30_ = 2;
                pessd[2] = true;
                (xt).autolog = false;
            }
            if ((control).exit)
                i_30_ = 3;
            if (i_30_ == 2) {
                if ((gs).tnick.getText().equals("")) {
                    msg = "Enter your Nickname!";
                    nflk = 30;
                } else if ((gs).tpass.getText().equals("")) {
                    msg = "Enter your Password!";
                    nflk = 30;
                } else {
                    msg = "| Logging In |";
                    (gs).tnick.disable();
                    (gs).tpass.disable();
                    (gs).keplo.disable();
                    fase = 4;
                    connector = new Thread(this);
                    connector.start();
                }
            }
            if (i_30_ == 3)
                gs.reglink();
        }
        if (fase == 5) {
            if ((control).enter) {
                i_30_ = 1;
                pessd[1] = true;
            }
            if ((control).exit)
                i_30_ = 2;
            if (i_30_ != 1) {
                /* empty */
            }
            if (i_30_ == 2) {
                fase = lrgfase;
                if (fase == 12) {
                    (gs).tnick.hide();
                    connector = new Thread(this);
                    connector.start();
                }
            }
        }
        if (fase == 7) {
            if ((control).enter) {
                i_30_ = 2;
                pessd[2] = true;
            }
            if ((control).exit)
                i_30_ = 3;
            if (i_30_ == 2) {
                nflk = 0;
                if ((gs).temail.getText().equals("")) {
                    msg = "Please type in your Email Address!";
                    nflk = 30;
                }
                if (nflk == 0) {
                    String string = (gs).temail.getText();
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
                        msg = "Please type in your Email Address correctly!";
                        nflk = 30;
                        errcnt = 40;
                        (gs).temail.setForeground(new Color(255, 0, 0));
                    }
                }
                if (nflk == 0) {
                    msg = "| Checking Email |";
                    (gs).temail.disable();
                    fase = 8;
                    connector = new Thread(this);
                    connector.start();
                }
            }
            if (i_30_ == 3) {
                inishmulti();
                (gs).temail.setText("");
                (gs).tpass.setText("");
            }
        }
        lxm = i;
        lym = i_28_;
        (control).enter = false;
        (control).exit = false;
    }
    
    public void drawSbutton(Image image, int i, int i_40_) {
        bx[btn] = i;
        by[btn] = i_40_;
        bw[btn] = image.getWidth(ob);
        if (!pessd[btn]) {
            rd.drawImage(image, i - bw[btn] / 2, i_40_ - image.getHeight(ob) / 2 - 1, null);
            rd.drawImage((xt).bols, i - bw[btn] / 2 - 15, i_40_ - 13, null);
            rd.drawImage((xt).bors, i + bw[btn] / 2 + 9, i_40_ - 13, null);
            rd.drawImage((xt).bot, i - bw[btn] / 2 - 9, i_40_ - 13, bw[btn] + 18, 3, null);
            rd.drawImage((xt).bob, i - bw[btn] / 2 - 9, i_40_ + 10, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i_40_ - image.getHeight(ob) / 2, null);
            rd.drawImage((xt).bolps, i - bw[btn] / 2 - 15, i_40_ - 13, null);
            rd.drawImage((xt).borps, i + bw[btn] / 2 + 9, i_40_ - 13, null);
            rd.drawImage((xt).bob, i - bw[btn] / 2 - 9, i_40_ - 13, bw[btn] + 18, 3, null);
            rd.drawImage((xt).bot, i - bw[btn] / 2 - 9, i_40_ + 10, bw[btn] + 18, 3, null);
        }
        btn++;
    }
    
    public void drawbutton(Image image, int i, int i_41_) {
        bx[btn] = i;
        by[btn] = i_41_;
        bw[btn] = image.getWidth(ob);
        if (!pessd[btn]) {
            rd.drawImage(image, i - bw[btn] / 2, i_41_ - image.getHeight(ob) / 2, null);
            rd.drawImage((xt).bol, i - bw[btn] / 2 - 15, i_41_ - 16, null);
            rd.drawImage((xt).bor, i + bw[btn] / 2 + 9, i_41_ - 16, null);
            rd.drawImage((xt).bot, i - bw[btn] / 2 - 9, i_41_ - 16, bw[btn] + 18, 3, null);
            rd.drawImage((xt).bob, i - bw[btn] / 2 - 9, i_41_ + 13, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i_41_ - image.getHeight(ob) / 2 + 1, null);
            rd.drawImage((xt).bolp, i - bw[btn] / 2 - 15, i_41_ - 16, null);
            rd.drawImage((xt).borp, i + bw[btn] / 2 + 9, i_41_ - 16, null);
            rd.drawImage((xt).bob, i - bw[btn] / 2 - 9, i_41_ - 16, bw[btn] + 18, 3, null);
            rd.drawImage((xt).bot, i - bw[btn] / 2 - 9, i_41_ + 13, bw[btn] + 18, 3, null);
        }
        btn++;
    }
    
    public void stringbutton(String string, int i, int i_42_, int i_43_) {
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        bx[btn] = i;
        by[btn] = i_42_ - 5;
        bw[btn] = ftm.stringWidth(string);
        if (!pessd[btn]) {
            rd.setColor(color2k(220, 220, 220));
            rd.fillRect(i - bw[btn] / 2 - 10, i_42_ - (17 - i_43_), bw[btn] + 20, 25 - i_43_ * 2);
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ - (17 - i_43_), i + bw[btn] / 2 + 10, i_42_ - (17 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ - (18 - i_43_), i + bw[btn] / 2 + 10, i_42_ - (18 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_42_ - (19 - i_43_), i + bw[btn] / 2 + 9, i_42_ - (19 - i_43_));
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i + bw[btn] / 2 + 10, i_42_ - (17 - i_43_), i + bw[btn] / 2 + 10, i_42_ + (7 - i_43_));
            rd.drawLine(i + bw[btn] / 2 + 11, i_42_ - (17 - i_43_), i + bw[btn] / 2 + 11, i_42_ + (7 - i_43_));
            rd.drawLine(i + bw[btn] / 2 + 12, i_42_ - (16 - i_43_), i + bw[btn] / 2 + 12, i_42_ + (6 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ + (7 - i_43_), i + bw[btn] / 2 + 10, i_42_ + (7 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ + (8 - i_43_), i + bw[btn] / 2 + 10, i_42_ + (8 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_42_ + (9 - i_43_), i + bw[btn] / 2 + 9, i_42_ + (9 - i_43_));
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ - (17 - i_43_), i - bw[btn] / 2 - 10, i_42_ + (7 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 11, i_42_ - (17 - i_43_), i - bw[btn] / 2 - 11, i_42_ + (7 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 12, i_42_ - (16 - i_43_), i - bw[btn] / 2 - 12, i_42_ + (6 - i_43_));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2, i_42_);
        } else {
            rd.setColor(color2k(210, 210, 210));
            rd.fillRect(i - bw[btn] / 2 - 10, i_42_ - (17 - i_43_), bw[btn] + 20, 25 - i_43_ * 2);
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ - (17 - i_43_), i + bw[btn] / 2 + 10, i_42_ - (17 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ - (18 - i_43_), i + bw[btn] / 2 + 10, i_42_ - (18 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_42_ - (19 - i_43_), i + bw[btn] / 2 + 9, i_42_ - (19 - i_43_));
            rd.drawLine(i + bw[btn] / 2 + 10, i_42_ - (17 - i_43_), i + bw[btn] / 2 + 10, i_42_ + (7 - i_43_));
            rd.drawLine(i + bw[btn] / 2 + 11, i_42_ - (17 - i_43_), i + bw[btn] / 2 + 11, i_42_ + (7 - i_43_));
            rd.drawLine(i + bw[btn] / 2 + 12, i_42_ - (16 - i_43_), i + bw[btn] / 2 + 12, i_42_ + (6 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ + (7 - i_43_), i + bw[btn] / 2 + 10, i_42_ + (7 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ + (8 - i_43_), i + bw[btn] / 2 + 10, i_42_ + (8 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_42_ + (9 - i_43_), i + bw[btn] / 2 + 9, i_42_ + (9 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_42_ - (17 - i_43_), i - bw[btn] / 2 - 10, i_42_ + (7 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 11, i_42_ - (17 - i_43_), i - bw[btn] / 2 - 11, i_42_ + (7 - i_43_));
            rd.drawLine(i - bw[btn] / 2 - 12, i_42_ - (16 - i_43_), i - bw[btn] / 2 - 12, i_42_ + (6 - i_43_));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2 + 1, i_42_);
        }
        btn++;
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
