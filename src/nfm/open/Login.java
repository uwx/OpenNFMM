package nfm.open;
import static nfm.open.Medium.cm;

/* Login - Decompiled by JODE
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
import java.util.concurrent.ThreadLocalRandom;

import nfm.open.xtGraphics.Images;

class Login implements Runnable {
    private final int[] bgmy = {
            0, 400, 800
    };
    private int btn = 0;
    private final int[] bw = {
            0, 0, 0, 0, 0, 0
    };
    private final int[] bx = {
            0, 0, 0, 0, 0, 0
    };
    private final int[] by = {
            0, 0, 0, 0, 0, 0
    };
    private int cax = 0;
    private int cay = 0;
    private boolean checknote = false;
    String clanapv = "";
    private int cntcl = 0;
    private Thread connector;
    private boolean contrb = false;
    private BufferedReader din;
    private PrintWriter dout;
    private final DatagramSocket[] dSocket = new DatagramSocket[3];
    private int errcnt = 0;
    int fase = 0;
    int fclan = 0;
    int flipo = 0;
    int fplayer = 0;
    private FontMetrics ftm;
    int gamec = -1;
    private String gmaker = "";
    private boolean gotcai = false;
    private final GameSparker gs;
    private final InetAddress[] IPAddress = new InetAddress[3];
    boolean jflk = false;
    boolean justlog = false;
    private String lemail = "";
    private String lnick = "";
    private String lpass = "";
    private final int lrgfase = 0;
    private int lxm = 0;
    private int lym = 0;
    private String msg = "";
    private int ncnt = 0;
    int nconf = 0;
    int ncreq = 0;
    private int nflk = 0;
    int nfreq = 0;
    private boolean nickero = false;
    int nmsgs = 0;
    int nservers = 2;
    private ImageObserver ob;
    private boolean ond = false;
    private boolean onf = false;
    private boolean onr = false;
    private int opselect = 0;
    private int oxm = 0;
    private int oym = 0;
    private int pend = 0;
    private boolean pendb = false;
    private final boolean[] pessd = {
            false, false, false, false, false, false
    };
    private final Graphics2D rd;
    private int recom = 0;
    private boolean resofaso = false;
    private final int[] rmps = {
            0, 0, 0, 0, 0
    };
    private final int[] rmwt = {
            0, 0, 0, 0, 0
    };
    private final int[] serverdone = {
            -1, -1, -1
    };
    final String[] servers = {
            "multiplayer.needformadness.com", "avenger.needformadness.com", "ghostrider.needformadness.com"
    };
    private final long[] servestart = {
            0L, 0L, 0L
    };
    private boolean showtf = false;
    final String[] snames = {
            "Dominion", "Avenger", "Ghostrider"
    };
    private Socket socket;
    private boolean socketson = false;
    private int srvtrn = 0;
    private int trans = 0;
    private int xrl = 0;
    private int xrr = 0;
    
    Login(final Graphics2D graphics2d, final GameSparker gamesparker) {
        rd = graphics2d;
        gs = gamesparker;
        if (xtGraphics.playingame != -1) {
            fase = 18;
        }
        if (xtGraphics.nofull) {
            nservers = 1;
        }
    }

    public void checkgamealerts() {
        try {
            socket = new Socket(servers[0], 7061);
            din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dout = new PrintWriter(socket.getOutputStream(), true);
            dout.println("101|21|");
            final String string = din.readLine();
            if (string != null) {
                final int i = getvalue(string, 0);
                if (i != -1 && i != gamec) {
                    final String string12 = getSvalue(string, 2);
                    final int i13 = getvalue(string, 3);
                    boolean bool = false;
                    if (!string12.equals(xtGraphics.servername) || i13 != xtGraphics.servport - 7070) {
                        for (int i14 = 0; i14 < nservers; i14++)
                            if (string12.equals(snames[i14]) && xtGraphics.delays[i14] < 300) {
                                bool = true;
                            }
                    }
                    if (bool) {
                        gmaker = getSvalue(string, 1);
                        if (gmaker.equals(xtGraphics.nickname)) {
                            gmaker = "You";
                        }
                        gamec = i;
                    }
                }
            }
            socket.close();
            din.close();
            dout.close();
        } catch (final Exception ignored) {

        }
    }

    private Color color2k(final int i, final int i62, final int i63) {
        final Color color = new Color(i, i62, i63);
        final float[] fs = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
        fs[0] = 0.13F;
        fs[1] = 0.35F;
        return Color.getHSBColor(fs[0], fs[1], fs[2]);
    }

    void ctachm(final int i, final int i47, final int i48, final Control control, final Lobby lobby) {
        int i49 = -1;
        if (fase != 2 && fase != 4 && fase != 6 && fase != 8 && fase != 9) {
            for (int i50 = 0; i50 < btn; i50++) {
                pessd[i50] = Math.abs(i - bx[i50]) < bw[i50] / 2 + 12 && Math.abs(i47 - by[i50]) < 14 && (i48 == 1 || i48 == 11);
                if (Math.abs(i - bx[i50]) < bw[i50] / 2 + 12 && Math.abs(i47 - by[i50]) < 14 && i48 <= -1) {
                    GameSparker.mouses = 0;
                    i49 = i50;
                }
                if (fase == 12 && Math.abs(i - bx[i50]) < bw[i50] / 2 + 12 && Math.abs(i47 - by[i50]) < 14 && (i50 == 3 || i50 == 4) && (i != lxm || i47 != lym)) {
                    opselect = i50 - 3;
                }
            }
        }
        if (i49 == 0) {
            GameSparker.tnick.setVisible(false);
            GameSparker.tpass.setVisible(false);
            GameSparker.keplo.setVisible(false);
            GameSparker.temail.setVisible(false);
            gs.requestFocus();
            xtGraphics.fase = 24;
        }
        if (i49 == 1 && fase != 5) {
            GameSparker.tnick.setVisible(false);
            GameSparker.tpass.setVisible(false);
            GameSparker.keplo.setVisible(false);
            GameSparker.temail.setVisible(false);
            gs.requestFocus();
            xtGraphics.fase = 23;
        }
        final int i51 = 2;
        if (fase == 12 || fase == 13 || fase == 14 || fase == 15 || fase == 16 || fase == 17) {
            if (i > 176 && i47 > 152 && i < 296 && i47 < 174) {
                if (!ond) {
                    ond = true;
                    gs.setCursor(new Cursor(12));
                }
            } else if (ond) {
                ond = false;
                gs.setCursor(new Cursor(0));
            }
            if (cntcl == 0) {
                if (ond && i48 == 11) {
                    GameSparker.editlink(xtGraphics.nickname, false);
                    cntcl = 10;
                }
            } else {
                cntcl--;
            }
            if (i49 == i51) {
                i49 = -1;
                if (xtGraphics.sc[0] >= 16) {
                    xtGraphics.sc[0] = 15;
                    gotcai = false;
                }
                xtGraphics.logged = false;
                xtGraphics.gotlog = false;
                GameSparker.keplo.setState(false);
                GameSparker.setloggedcookie();
                CarDefine.msloaded = 0;
                CarDefine.lastload = 0;
                msg = "Login to access the multiplayer madness!";
                fase = 3;
            }
        }
        if (fase == 12)
            if (xtGraphics.acexp == 0 || contrb) {
                if (control.up) {
                    opselect--;
                    if (opselect == -1) {
                        opselect = 1;
                    }
                    control.up = false;
                }
                if (control.down) {
                    opselect++;
                    if (opselect == 2) {
                        opselect = 0;
                    }
                    control.down = false;
                }
                if (control.enter) {
                    i49 = opselect + 3;
                    control.enter = false;
                }
                if (i49 == i51 + 2) {
                    trans = 0;
                    fase = 15;
                    i49 = -1;
                }
                if (!xtGraphics.logged && i49 == i51 + 3) {
                    GameSparker.editlink(xtGraphics.nickname, true);
                }
            } else {
                if (xtGraphics.acexp > 0) {
                    if (i49 == i51 + 1 || control.enter) {
                        GameSparker.editlink(xtGraphics.nickname, false);
                        i49 = -1;
                    }
                    if (i49 == i51 + 2) {
                        opselect = 0;
                        contrb = true;
                        i49 = -1;
                    }
                }
                if (xtGraphics.acexp == -1) {
                    if (i49 == i51 + 1 || control.enter) {
                        GameSparker.editlink(xtGraphics.nickname, false);
                        i49 = -1;
                    }
                    if (i49 == i51 + 2) {
                        i49 = -1;
                        if (xtGraphics.sc[0] >= 16) {
                            xtGraphics.sc[0] = 15;
                            gotcai = false;
                        }
                        xtGraphics.logged = false;
                        CarDefine.lastload = 0;
                        msg = "Login to access the multiplayer madness!";
                        fase = 3;
                    }
                }
                if (xtGraphics.acexp == -2) {
                    if (i49 == i51 + 1 || control.enter) {
                        GameSparker.multlink();
                        i49 = -1;
                    }
                    if (i49 == i51 + 2) {
                        i49 = -1;
                        if (xtGraphics.sc[0] >= 16) {
                            xtGraphics.sc[0] = 15;
                            gotcai = false;
                        }
                        xtGraphics.logged = false;
                        CarDefine.lastload = 0;
                        msg = "Login to access the multiplayer madness!";
                        fase = 3;
                    }
                }
                if (xtGraphics.acexp == -3) {
                    if (i49 == i51 + 1 || control.enter) {
                        GameSparker.editlink(xtGraphics.nickname, false);
                        i49 = -1;
                    }
                    if (i49 == i51 + 2) {
                        i49 = -1;
                        if (xtGraphics.sc[0] >= 16) {
                            xtGraphics.sc[0] = 15;
                            gotcai = false;
                        }
                        xtGraphics.logged = false;
                        CarDefine.lastload = 0;
                        msg = "Login to access the multiplayer madness!";
                        fase = 3;
                    }
                }
            }
        if (fase == 13 || fase == 14 || fase == 15 || fase == 16 || fase == 17) {
            if (control.exit) {
                i49 = 3;
            }
            if (i49 == i51 + 1) {
                if (fase == 15) {
                    opselect = 1;
                } else {
                    opselect = 0;
                }
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
                    } catch (final Exception ignored) {

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
                    for (int i52 = 0; i52 < nservers; i52++) {
                        try {
                            dSocket[i52].close();
                            dSocket[i52] = null;
                        } catch (final Exception ignored) {

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
        if (fase == 15) {
            if (control.enter) {
                i49 = 4;
                pessd[4] = true;
            }
            if (i49 == i51 + 2)
                if (xtGraphics.nofull) {
                    nflk = 30;
                } else {
                    xtGraphics.server = servers[1];
                    xtGraphics.servername = snames[1];
                    xtGraphics.servport = 7067;
                    xtGraphics.lan = true;
                    i49 = -1;
                    fase = 18;
                    lobby.fase = 0;
                }
        }
        if (fase == 17) {
            if (control.enter) {
                i49 = 4;
                pessd[4] = true;
            }
            if (control.up) {
                opselect--;
                if (opselect == -1) {
                    opselect = 4;
                }
                control.up = false;
            }
            if (control.down) {
                opselect++;
                if (opselect == 5) {
                    opselect = 0;
                }
                control.down = false;
            }
            for (int i54 = 0; i54 < 5; i54++)
                if (i > 175 && i47 > 230 + i54 * 20 + 14 && i < 625 && i47 < 250 + i54 * 20 + 14 && i48 == 1) {
                    opselect = i54;
                }
            if (i49 == i51 + 2) {
                xtGraphics.servport = 7071 + opselect;
                xtGraphics.lan = false;
                i49 = -1;
                fase = 18;
                lobby.fase = 0;
            }
        }
        if (fase == 3) {
            if (i > 295 && i47 > 334 && i < 505 && i47 < 348) {
                if (!onf) {
                    onf = true;
                    gs.setCursor(new Cursor(12));
                }
            } else if (onf) {
                onf = false;
                gs.setCursor(new Cursor(0));
            }
            if (onf && i48 == 11) {
                msg = "Please enter your Email Address to recover your account details.";
                GameSparker.tnick.setForeground(new Color(0, 0, 0));
                GameSparker.tpass.setForeground(new Color(0, 0, 0));
                GameSparker.tnick.setVisible(false);
                GameSparker.tpass.setVisible(false);
                GameSparker.keplo.setVisible(false);
                onf = false;
                gs.setCursor(new Cursor(0));
                fase = 7;
            }
            if (i > xrl && i < xrr && i47 > 360 && i47 < 373) {
                if (!onr) {
                    onr = true;
                    gs.setCursor(new Cursor(12));
                }
            } else if (onr) {
                onr = false;
                gs.setCursor(new Cursor(0));
            }
            if (onr && i48 == 11) {
                GameSparker.reglink();
                GameSparker.mouses = 0;
            }
        }
        if (fase == 1) {
            if (control.enter) {
                i49 = 2;
                pessd[2] = true;
            }
            if (i49 == 2)
                if (GameSparker.tnick.getText().equals("Fyre") || GameSparker.tnick.getText().equals("Nickname") || GameSparker.tnick.getText().equals("")) {
                    msg = "Type in any Nickname to play...";
                    GameSparker.tnick.setText("Nickname");
                    nflk = 30;
                } else {
                    msg = "| Checking Nickname |";
                    GameSparker.tnick.setEnabled(false);
                    fase = 2;
                    connector = new Thread(this);
                    connector.start();
                }
            if (i49 == 3) {
                if (GameSparker.tnick.getText().equals("Nickname") || msg.startsWith("This")) {
                    GameSparker.tnick.setText("");
                }
                msg = "Login to access the multiplayer madness!";
                GameSparker.tnick.setForeground(new Color(0, 0, 0));
                fase = 3;
                i49 = -1;
            }
            if (i49 == 4) {
                if (nickero || GameSparker.tnick.getText().equals("Nickname")) {
                    GameSparker.tnick.setText("");
                    nickero = false;
                }
                GameSparker.tnick.setForeground(new Color(0, 0, 0));
                GameSparker.reglink();
            }
        }
        if (fase == 3) {
            if (control.enter || xtGraphics.autolog) {
                i49 = 2;
                pessd[2] = true;
                xtGraphics.autolog = false;
            }
            if (control.exit) {
                i49 = 3;
            }
            if (i49 == 2)
                if (GameSparker.tnick.getText().equals("")) {
                    msg = "Enter your Nickname!";
                    nflk = 30;
                } else if (GameSparker.tpass.getText().equals("")) {
                    msg = "Enter your Password!";
                    nflk = 30;
                } else {
                    msg = "| Logging In |";
                    GameSparker.tnick.setEnabled(false);
                    GameSparker.tpass.setEnabled(false);
                    GameSparker.keplo.setEnabled(false);
                    fase = 4;
                    connector = new Thread(this);
                    connector.start();
                }
            if (i49 == 3) {
                GameSparker.regnew();
            }
        }
        if (fase == 5) {
            if (control.enter) {
                i49 = 1;
                pessd[1] = true;
            }
            if (control.exit) {
                i49 = 2;
            }
            if (i49 == 2) {
                fase = lrgfase;
                if (fase == 12) {
                    GameSparker.tnick.setVisible(false);
                    connector = new Thread(this);
                    connector.start();
                }
            }
        }
        if (fase == 7) {
            if (control.enter) {
                i49 = 2;
                pessd[2] = true;
            }
            if (control.exit) {
                i49 = 3;
            }
            if (i49 == 2) {
                nflk = 0;
                if (GameSparker.temail.getText().equals("")) {
                    msg = "Please type in your Email Address!";
                    nflk = 30;
                }
                if (nflk == 0) {
                    final String string = GameSparker.temail.getText();
                    int i55 = 0;
                    int i56 = 0;
                    for (/**/ ; i55 < string.length(); i55++) {
                        final String string57 = "" + string.charAt(i55);
                        if (string57.equals("@") && i56 == 0 && i55 != 0) {
                            i56 = 1;
                        }
                        if (string57.equals(".") && i56 == 1 && i55 != string.length() - 1) {
                            i56 = 2;
                        }
                    }
                    if (i56 != 2) {
                        msg = "Please type in your Email Address correctly!";
                        nflk = 30;
                        errcnt = 40;
                        GameSparker.temail.setForeground(new Color(255, 0, 0));
                    }
                }
                if (nflk == 0) {
                    msg = "| Checking Email |";
                    GameSparker.temail.setEnabled(false);
                    fase = 8;
                    connector = new Thread(this);
                    connector.start();
                }
            }
            if (i49 == 3) {
                inishmulti();
                GameSparker.temail.setText("");
                GameSparker.tpass.setText("");
            }
        }
        lxm = i;
        lym = i47;
        control.enter = false;
        control.exit = false;
    }

    private void drawbutton(final Image image, final int i, final int i59) {
        bx[btn] = i;
        by[btn] = i59;
        bw[btn] = image.getWidth(ob);
        if (!pessd[btn]) {
            rd.drawImage(image, i - bw[btn] / 2, i59 - image.getHeight(ob) / 2, null);
            rd.drawImage(Images.bol, i - bw[btn] / 2 - 15, i59 - 16, null);
            rd.drawImage(Images.bor, i + bw[btn] / 2 + 9, i59 - 16, null);
            rd.drawImage(Images.bot, i - bw[btn] / 2 - 9, i59 - 16, bw[btn] + 18, 3, null);
            rd.drawImage(Images.bob, i - bw[btn] / 2 - 9, i59 + 13, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i59 - image.getHeight(ob) / 2 + 1, null);
            rd.drawImage(Images.bolp, i - bw[btn] / 2 - 15, i59 - 16, null);
            rd.drawImage(Images.borp, i + bw[btn] / 2 + 9, i59 - 16, null);
            rd.drawImage(Images.bob, i - bw[btn] / 2 - 9, i59 - 16, bw[btn] + 18, 3, null);
            rd.drawImage(Images.bot, i - bw[btn] / 2 - 9, i59 + 13, bw[btn] + 18, 3, null);
        }
        btn++;
    }

    private void drawSbutton(final Image image, final int i, final int i58) {
        bx[btn] = i;
        by[btn] = i58;
        bw[btn] = image.getWidth(ob);
        if (!pessd[btn]) {
            rd.drawImage(image, i - bw[btn] / 2, i58 - image.getHeight(ob) / 2 - 1, null);
            rd.drawImage(Images.bols, i - bw[btn] / 2 - 15, i58 - 13, null);
            rd.drawImage(Images.bors, i + bw[btn] / 2 + 9, i58 - 13, null);
            rd.drawImage(Images.bot, i - bw[btn] / 2 - 9, i58 - 13, bw[btn] + 18, 3, null);
            rd.drawImage(Images.bob, i - bw[btn] / 2 - 9, i58 + 10, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i58 - image.getHeight(ob) / 2, null);
            rd.drawImage(Images.bolps, i - bw[btn] / 2 - 15, i58 - 13, null);
            rd.drawImage(Images.borps, i + bw[btn] / 2 + 9, i58 - 13, null);
            rd.drawImage(Images.bob, i - bw[btn] / 2 - 9, i58 - 13, bw[btn] + 18, 3, null);
            rd.drawImage(Images.bot, i - bw[btn] / 2 - 9, i58 + 10, bw[btn] + 18, 3, null);
        }
        btn++;
    }

    void endcons() {
        for (int i = 0; i < nservers; i++) {
            try {
                dSocket[i].close();
                dSocket[i] = null;
            } catch (final Exception ignored) {

            }
        }
        try {
            socket.close();
            socket = null;
            din.close();
            din = null;
            dout.close();
            dout = null;
        } catch (final Exception ignored) {

        }
    }

    void exitfromlobby() {
        if (!xtGraphics.lan) {
            opselect = 0;
        } else {
            opselect = 1;
        }
        for (int i = 0; i < nservers; i++) {
            serverdone[i] = -1;
            servestart[i] = 0L;
        }
        for (int i = 0; i < 6; i++) {
            pessd[i] = false;
        }
        gotcai = false;
        Medium.crs = true;
        Medium.x[cm] = -335;
        Medium.y[cm] = 0;
        Medium.z[cm] = -50;
        Medium.xz[cm] = 0;
        Medium.zy[cm] = 20;
        Medium.ground[cm] = -2000;
        pend = 0;
        pendb = false;
        gamec = -1;
        socketson = false;
        fase = 12;
        System.gc();
        connector = new Thread(this);
        connector.start();
    }

    private void fixtext(final TextField textfield) {
        String string = textfield.getText();
        string = string.replace('\"', '#');
        final String string64 = "\\";
        String string65 = "";
        int i = 0;
        int i66 = -1;
        for (/**/ ; i < string.length(); i++) {
            final String string67 = "" + string.charAt(i);
            if (string67.equals("|") || string67.equals(",") || string67.equals("(") || string67.equals(")") || string67.equals("#") || string67.equals(string64) || string67.equals("!") || string67.equals("?") || string67.equals(" ") || string67.equals("~") || string67.equals("$") || string67.equals("%") || string67.equals("^") || string67.equals("&") || string67.equals("*") || string67.equals("+") || string67.equals("=") || string67.equals(">") || string67.equals("<") || string67.equals("/") || string67.equals("'") || string67.equals(";") || string67.equals(":") || string67.equals("\u00a0")) {
                i66 = i;
            } else {
                string65 = "" + string65 + string67;
            }
        }
        if (i66 != -1) {
            textfield.setText(string65);
            textfield.select(i66, i66);
        }
    }

    void gamealert() {
        try {
            socket = new Socket(servers[0], 7061);
            din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dout = new PrintWriter(socket.getOutputStream(), true);
            dout.println("101|20|" + xtGraphics.nickname + "|" + xtGraphics.nickey + "|" + xtGraphics.servername + "|" + (xtGraphics.servport - 7070) + "|");
            din.readLine();
            socket.close();
            din.close();
            dout.close();
        } catch (final Exception ignored) {

        }
    }

    private String getSvalue(final String string, final int i) {
        String string74 = "";
        try {
            int i75 = 0;
            int i76 = 0;
            int i77 = 0;
            String string78;
            String string79 = "";
            for (/**/ ; i75 < string.length() && i77 != 2; i75++) {
                string78 = "" + string.charAt(i75);
                if (string78.equals("|")) {
                    i76++;
                    if (i77 == 1 || i76 > i) {
                        i77 = 2;
                    }
                } else if (i76 == i) {
                    string79 = "" + string79 + string78;
                    i77 = 1;
                }
            }
            string74 = string79;
        } catch (final Exception ignored) {

        }
        return string74;
    }

    private int getvalue(final String string, final int i) {
        int i68 = -1;
        try {
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            String string72;
            String string73 = "";
            for (/**/ ; i69 < string.length() && i71 != 2; i69++) {
                string72 = "" + string.charAt(i69);
                if (string72.equals("|")) {
                    i70++;
                    if (i71 == 1 || i70 > i) {
                        i71 = 2;
                    }
                } else if (i70 == i) {
                    string73 = "" + string73 + string72;
                    i71 = 1;
                }
            }
            if (string73.equals("")) {
                string73 = "-1";
            }
            i68 = Integer.parseInt(string73);
        } catch (final Exception ignored) {

        }
        return i68;
    }

    void inishmulti() {
        GameSparker.tnick.setVisible(false);
        GameSparker.tnick.setEnabled(true);
        GameSparker.tnick.setForeground(new Color(0, 0, 0));
        GameSparker.tnick.setBackground(color2k(240, 240, 240));
        GameSparker.tpass.setVisible(false);
        GameSparker.tpass.setEnabled(true);
        GameSparker.tpass.setForeground(new Color(0, 0, 0));
        GameSparker.tpass.setBackground(color2k(240, 240, 240));
        GameSparker.temail.setVisible(false);
        GameSparker.temail.setEnabled(true);
        GameSparker.temail.setForeground(new Color(0, 0, 0));
        GameSparker.temail.setBackground(color2k(240, 240, 240));
        GameSparker.keplo.setVisible(false);
        GameSparker.keplo.setEnabled(true);
        GameSparker.keplo.setForeground(new Color(0, 0, 0));
        GameSparker.keplo.setBackground(new Color(193, 181, 142));
        gs.requestFocus();
        if (GameSparker.tnick.getText().equals("")) {
            GameSparker.tnick.setText("Nickname");
        }
        for (int i = 0; i < 6; i++) {
            pessd[i] = false;
        }
        nflk = 0;
        ncnt = 0;
        errcnt = 0;
        onf = false;
        ond = false;
        msg = "";
        gotcai = false;
        Medium.crs = true;
        Medium.x[cm] = -335;
        Medium.y[cm] = 0;
        Medium.z[cm] = -50;
        Medium.xz[cm] = 0;
        Medium.zy[cm] = 20;
        Medium.ground[cm] = -2000;
        pend = 0;
        pendb = false;
        resofaso = false;
        for (int i = 0; i < nservers; i++) {
            serverdone[i] = -1;
            servestart[i] = 0L;
        }
        checknote = false;
        if (xtGraphics.gotlog) {
            checknote = true;
            socketson = false;
            fase = 12;
            connector = new Thread(this);
            connector.start();
        } else {
            msg = "Login to access the multiplayer madness!";
            GameSparker.tnick.setText(xtGraphics.nickname);
            fase = 3;
        }
    }

    void multimode(final ContO[] contos) {
        btn = 0;
        xtGraphics.mainbg(4);
        for (int i = 0; i < 3; i++) {
            rd.drawImage(Images.bgmain, 65, bgmy[i], null);
            bgmy[i] -= 4;
            if (bgmy[i] <= -400) {
                bgmy[i] = 800;
            }
        }
        rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
        rd.drawImage(Images.bggo, 0, 0, null);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(65, 425, 670, 25);
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        float f = 1.0F - (flipo - 10) / 80.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        if (f < 0.0F) {
            f = 0.0F;
        }
        rd.setComposite(AlphaComposite.getInstance(3, f));
        if (flipo > 10) {
            rd.drawImage(Images.logomadnes, 96 + (int) (2.0 - ThreadLocalRandom.current().nextDouble() * 4.0), 11 + (int) (2.0 - ThreadLocalRandom.current().nextDouble() * 4.0), null);
        } else {
            rd.drawImage(Images.logomadnes, 96, 11, null);
        }
        flipo++;
        if (flipo > 50) {
            flipo = 0;
        }
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        drawSbutton(Images.exit, 690, 17);
        rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
        rd.setColor(new Color(203, 227, 253));
        rd.fillRoundRect(319, 83, 180, 96, 20, 20);
        rd.fillRoundRect(173, 83, 132, 32, 20, 20);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        rd.setColor(color2k(90, 90, 90));
        rd.drawRoundRect(319, 83, 180, 96, 20, 20);
        rd.drawRoundRect(173, 83, 132, 32, 20, 20);
        if (!gotcai) {
            int i = contos[xtGraphics.sc[0]].p[0].oz[0];
            int i26 = i;
            int i27 = contos[xtGraphics.sc[0]].p[0].oy[0];
            int i28 = i27;
            for (int i29 = 0; i29 < contos[xtGraphics.sc[0]].npl; i29++) {
                for (int i30 = 0; i30 < contos[xtGraphics.sc[0]].p[i29].n; i30++) {
                    if (contos[xtGraphics.sc[0]].p[i29].oz[i30] < i) {
                        i = contos[xtGraphics.sc[0]].p[i29].oz[i30];
                    }
                    if (contos[xtGraphics.sc[0]].p[i29].oz[i30] > i26) {
                        i26 = contos[xtGraphics.sc[0]].p[i29].oz[i30];
                    }
                    if (contos[xtGraphics.sc[0]].p[i29].oy[i30] < i27) {
                        i27 = contos[xtGraphics.sc[0]].p[i29].oy[i30];
                    }
                    if (contos[xtGraphics.sc[0]].p[i29].oy[i30] > i28) {
                        i28 = contos[xtGraphics.sc[0]].p[i29].oy[i30];
                    }
                }
            }
            cax = (i26 + i) / 2;
            cay = (i28 + i27) / 2;
            gotcai = true;
        }
        contos[xtGraphics.sc[0]].z = 1500;
        contos[xtGraphics.sc[0]].y = 380 - cay;
        contos[xtGraphics.sc[0]].x = 100 - cax;
        contos[xtGraphics.sc[0]].zy = 0;
        contos[xtGraphics.sc[0]].xz = -90;
        contos[xtGraphics.sc[0]].xy = pend;
        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        contos[xtGraphics.sc[0]].d(rd);
        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        rd.setColor(new Color(0, 0, 0));
        rd.drawString(xtGraphics.nickname, 239 - ftm.stringWidth(xtGraphics.nickname) / 2, 105);
        rd.setColor(color2k(90, 90, 90));
        rd.drawString("" + CarDefine.names[xtGraphics.sc[0]] + "", 409 - ftm.stringWidth("" + CarDefine.names[xtGraphics.sc[0]] + "") / 2, 81);
        rd.drawString("Nickname", 239 - ftm.stringWidth("Nickname") / 2, 81);
        drawbutton(Images.change, 570, 98);
        drawSbutton(Images.logout, 239, 135);
        rd.setColor(new Color(98, 56, 0));
        rd.drawString("Edit my Account", 239 - ftm.stringWidth("Edit my Account") / 2, 168);
        if (ond) {
            rd.drawLine(239 - ftm.stringWidth("Edit my Account") / 2, 169, 239 - ftm.stringWidth("Edit my Account") / 2 + ftm.stringWidth("Edit my Account"), 169);
        }
        if (fase == 12 || fase == 13 || fase == 14 || fase == 15) {
            final int i = srvtrn;
            if (i < nservers && serverdone[i] != -1) {
                final Date date = new Date();
                if (date.getTime() - servestart[i] > 1500L) {
                    if (connector != null) {
                        connector.stop();
                        connector = null;
                    }
                    xtGraphics.delays[i] = 600;
                    serverdone[i] = 5;
                    connector = new Thread(this);
                    connector.start();
                }
            }
        }
        if (fase == 12)
            if (xtGraphics.acexp == 0 || contrb) {
                rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                rd.setColor(new Color(203, 227, 253));
                rd.fillRoundRect(205, 225, 390, 120, 20, 20);
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                rd.setColor(color2k(90, 90, 90));
                rd.drawString("Multiplayer Mode", 400 - ftm.stringWidth("Multiplayer Mode") / 2, 220);
                rd.drawRoundRect(205, 225, 390, 120, 20, 20);
                drawbutton(Images.pln, 400, 285 - Images.pln.getHeight(ob) / 2);
                if (opselect == 1 && !pessd[4]) {
                    rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                    rd.setColor(new Color(203, 227, 253));
                    rd.fillRect(387 - Images.pln.getWidth(ob) / 2, 285 - Images.pln.getHeight(ob) - 5, Images.pln.getWidth(ob) + 26, 26);
                    rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                }
                drawbutton(Images.pln, 400, 285 - Images.pln.getHeight(ob) / 2);
            } else {
                rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                rd.setColor(new Color(203, 227, 253));
                rd.fillRoundRect(165, 219, 470, 135, 20, 20);
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                rd.setColor(color2k(90, 90, 90));
                rd.drawRoundRect(165, 219, 470, 135, 20, 20);
                if (xtGraphics.acexp > 0) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Dear " + xtGraphics.nickname + ",", 185, 245);
                    rd.drawString("Your account is due to expire in " + xtGraphics.acexp + " days.", 185, 265);
                    rd.drawString("Renew your registration soon!", 185, 295);
                    stringbutton("Renew my Account Registration now!", 345, 332, 0);
                    stringbutton("Renew Later", 524, 332, 0);
                }
                if (xtGraphics.acexp == -1) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Dear " + xtGraphics.nickname + ",", 185, 245);
                    rd.drawString("Your Need for Madness account registration has expired.", 185, 265);
                    rd.drawString("Please renew your registration.", 185, 295);
                    stringbutton("Renew my account registration now!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if (xtGraphics.acexp == -2) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Dear " + xtGraphics.nickname + ",", 185, 245);
                    rd.drawString("Trial accounts are not allowed to access the downloaded game.", 185, 265);
                    rd.drawString("You can only play the game online using your trial account.", 185, 295);
                    stringbutton("Play the multiplayer online!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if (xtGraphics.acexp == -3) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Some one else is already logged in the game with your account.", 185, 245);
                    rd.drawString("If you where just in the game then quitted it suddenly, it could just", 185, 265);
                    rd.drawString("be your 'ghost entry', if so please wait a few minutes and try again.", 185, 285);
                    rd.drawString("Otherwise please consider changing your password.", 185, 305);
                    stringbutton("Change Password", 332, 336, 0);
                    stringbutton("Try Again", 494, 336, 0);
                }
            }
        if (fase == 15) {
            if (trans < 100) {
                rd.drawImage(Images.pln, 400 - Images.pln.getWidth(ob) / 2, 315 - Images.pln.getHeight(ob) / 2 - 12 - trans, null);
            } else {
                rd.drawImage(Images.pln, 400 - Images.pln.getWidth(ob) / 2, 215 - Images.pln.getHeight(ob) / 2 - 12, null);
            }
            if (trans >= 100) {
                rd.setColor(color2k(255, 255, 255));
                rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                rd.setColor(new Color(0, 0, 0));
                rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if (xtGraphics.nofull) {
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
                    if (nflk != 0) {
                        nflk--;
                    }
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
                drawbutton(Images.cancel, 583, 395);
                drawbutton(Images.play, 400, 395);
            } else {
                trans += 10;
            }
        }
        if (resofaso) {
            resofaso = false;
        }
    }

    void multistart(final ContO[] contos, final int i, final int i38, final boolean bool) {
        btn = 0;
        xtGraphics.mainbg(4);
        for (int i39 = 0; i39 < 3; i39++) {
            rd.drawImage(Images.bgmain, 65, bgmy[i39], null);
            bgmy[i39] -= 4;
            if (bgmy[i39] <= -400) {
                bgmy[i39] = 800;
            }
        }
        rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
        rd.drawImage(Images.bggo, 0, 0, null);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        rd.setColor(new Color(0, 0, 0));
        rd.fillRect(65, 425, 670, 25);
        rd.fillRect(0, 0, 65, 450);
        rd.fillRect(735, 0, 65, 450);
        float f = 1.0F - (flipo - 10) / 80.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }
        if (f < 0.0F) {
            f = 0.0F;
        }
        rd.setComposite(AlphaComposite.getInstance(3, f));
        if (flipo > 10) {
            rd.drawImage(Images.logomadnes, 96 + (int) (2.0 - ThreadLocalRandom.current().nextDouble() * 4.0), 11 + (int) (2.0 - ThreadLocalRandom.current().nextDouble() * 4.0), null);
        } else {
            rd.drawImage(Images.logomadnes, 96, 11, null);
        }
        flipo++;
        if (flipo > 50) {
            flipo = 0;
        }
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        int i40 = 0;
        if (i != oxm || i38 != oym) {
            i40 = 1;
            oxm = i;
            oym = i38;
        }
        if (bool) {
            i40 = 2;
        }
        rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
        rd.drawImage(Images.dude[i40], 87, 76, null);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        rd.drawImage(Images.redy, 445, 153, null);
        // really dirty solution to a very specific bug
        // DO NOT DELETE THE LINE BELOW
        // drawSbutton((xt).exit, 690, 17);
        drawSbutton(Images.exit, 690, 17);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        if (fase != 5) {
            rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
            rd.setColor(new Color(203, 227, 253));
            rd.fillRoundRect(246, 83, 180, 96, 20, 20);
            rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            rd.setColor(color2k(90, 90, 90));
            rd.drawString("" + CarDefine.names[xtGraphics.sc[0]] + "", 336 - ftm.stringWidth("" + CarDefine.names[xtGraphics.sc[0]] + "") / 2, 81);
            rd.drawRoundRect(246, 83, 180, 96, 20, 20);
            if (!gotcai) {
                int i41 = contos[xtGraphics.sc[0]].p[0].oz[0];
                int i42 = i41;
                int i43 = contos[xtGraphics.sc[0]].p[0].oy[0];
                int i44 = i43;
                for (int i45 = 0; i45 < contos[xtGraphics.sc[0]].npl; i45++) {
                    for (int i46 = 0; i46 < contos[xtGraphics.sc[0]].p[i45].n; i46++) {
                        if (contos[xtGraphics.sc[0]].p[i45].oz[i46] < i41) {
                            i41 = contos[xtGraphics.sc[0]].p[i45].oz[i46];
                        }
                        if (contos[xtGraphics.sc[0]].p[i45].oz[i46] > i42) {
                            i42 = contos[xtGraphics.sc[0]].p[i45].oz[i46];
                        }
                        if (contos[xtGraphics.sc[0]].p[i45].oy[i46] < i43) {
                            i43 = contos[xtGraphics.sc[0]].p[i45].oy[i46];
                        }
                        if (contos[xtGraphics.sc[0]].p[i45].oy[i46] > i44) {
                            i44 = contos[xtGraphics.sc[0]].p[i45].oy[i46];
                        }
                    }
                }
                cax = (i42 + i41) / 2;
                cay = (i44 + i43) / 2;
                gotcai = true;
            }
            contos[xtGraphics.sc[0]].z = 1500;
            contos[xtGraphics.sc[0]].y = 380 - cay;
            contos[xtGraphics.sc[0]].x = -170 - cax;
            contos[xtGraphics.sc[0]].zy = 0;
            contos[xtGraphics.sc[0]].xz = -90;
            contos[xtGraphics.sc[0]].xy = pend;
            rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            contos[xtGraphics.sc[0]].d(rd);
            rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
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
            drawbutton(Images.change, 497, 98);
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
                if (ncnt != 0) {
                    ncnt--;
                }
                pessd[2] = true;
            }
            if (fase == 1 && !GameSparker.tnick.isShowing()) {
                GameSparker.tnick.setVisible(true);
                GameSparker.tnick.requestFocus();
                if (GameSparker.tnick.getText().equals("Nickname")) {
                    GameSparker.tnick.select(8, 8);
                }
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0) {
                    GameSparker.tnick.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton(Images.play, 400, 285);
            if (nflk > 0) {
                if (GameSparker.tnick.getText().equals("")) {
                    GameSparker.tnick.setText("Nickname");
                    if (nflk == 1) {
                        GameSparker.tnick.select(8, 8);
                    }
                } else {
                    GameSparker.tnick.setText("");
                }
                nflk--;
            }
            drawbutton(Images.login, 400, 340);
            drawbutton(Images.register, 400, 395);
            GameSparker.movefield(GameSparker.tnick, 400, 225, 129, 23);
            while (ftm.stringWidth(GameSparker.tnick.getText()) > 86) {
                GameSparker.tnick.setText(GameSparker.tnick.getText().substring(0, GameSparker.tnick.getText().length() - 1));
                GameSparker.tnick.select(GameSparker.tnick.getText().length(), GameSparker.tnick.getText().length());
            }
            if (!GameSparker.tnick.getText().equals(lnick)) {
                fixtext(GameSparker.tnick);
                lnick = GameSparker.tnick.getText();
            }
            if (xtGraphics.msgcheck(GameSparker.tnick.getText())) {
                GameSparker.tnick.setText("");
            }
            if (GameSparker.tnick.getText().toLowerCase().contains("madbot")) {
                GameSparker.tnick.setText("");
            }
        }
        if (fase == 3 || fase == 4) {
            rd.drawImage(Images.ntrg, 97, 388, null);
            rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
            rd.setColor(new Color(203, 227, 253));
            rd.fillRoundRect(246, 212, 308, 142, 20, 20);
            rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            rd.setColor(color2k(90, 90, 90));
            rd.drawRoundRect(246, 212, 308, 142, 20, 20);
            rd.setColor(new Color(0, 0, 0));
            if (nflk % 4 != 0 || nflk == 0) {
                rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 205);
            }
            if (nflk != 0) {
                nflk--;
            }
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
                if (ncnt != 0) {
                    ncnt--;
                }
                pessd[2] = true;
            }
            if (fase == 3) {
                showtf = true;
                if (!GameSparker.applejava) {
                    if (!GameSparker.tpass.isShowing()) {
                        GameSparker.tpass.setVisible(true);
                        if (!GameSparker.tnick.getText().equals("")) {
                            GameSparker.tpass.requestFocus();
                        }
                    }
                    if (!GameSparker.tnick.isShowing()) {
                        GameSparker.tnick.setVisible(true);
                        if (GameSparker.tnick.getText().equals("")) {
                            GameSparker.tnick.requestFocus();
                        }
                    }
                }
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0) {
                    GameSparker.tpass.setText("");
                    GameSparker.tnick.setForeground(new Color(0, 0, 0));
                    GameSparker.tpass.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton(Images.login, 400, 315);
            if (onf) {
                rd.setColor(color2k(0, 72, 255));
            } else {
                rd.setColor(color2k(120, 120, 120));
            }
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.drawString("Forgot your nickname or password?", 400 - ftm.stringWidth("Forgot your nickname or password?") / 2, 345);
            rd.setColor(new Color(0, 0, 0));
            rd.setFont(new Font("Arial", 1, 12));
            ftm = rd.getFontMetrics();
            final String string = "Register a full account here!";
            xrl = 400 - ftm.stringWidth(string) / 2;
            xrr = xrl + ftm.stringWidth(string);
            rd.drawString(string, xrl, 371);
            rd.drawLine(xrl, 372, xrr, 372);
            drawbutton(Images.register, 400, 395);
            GameSparker.movefieldd(GameSparker.tnick, 376, 221, 129, 23, showtf);
            if (!GameSparker.tnick.getText().equals(lnick)) {
                fixtext(GameSparker.tnick);
                lnick = GameSparker.tnick.getText();
            }
            GameSparker.movefieldd(GameSparker.tpass, 376, 251, 129, 23, showtf);
            if (!GameSparker.tpass.getText().equals(lpass)) {
                fixtext(GameSparker.tpass);
                lpass = GameSparker.tpass.getText();
            }
            if (fase == 3 && (!GameSparker.tpass.getText().equals("") && !GameSparker.tnick.getText().equals("") || !GameSparker.applejava) && !GameSparker.keplo.isShowing()) {
                GameSparker.keplo.setVisible(true);
            }
            GameSparker.movefield(GameSparker.keplo, 376, 275, 129, 23);
        }
        if (fase == 5) {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 141);
            GameSparker.movefield(GameSparker.tnick, 376, 125, 129, 23);
            while (ftm.stringWidth(GameSparker.tnick.getText()) > 86) {
                GameSparker.tnick.setText(GameSparker.tnick.getText().substring(0, GameSparker.tnick.getText().length() - 1));
                GameSparker.tnick.select(GameSparker.tnick.getText().length(), GameSparker.tnick.getText().length());
            }
            if (!GameSparker.tnick.getText().equals(lnick)) {
                fixtext(GameSparker.tnick);
                lnick = GameSparker.tnick.getText();
            }
            if (!GameSparker.tnick.isShowing()) {
                GameSparker.tnick.setVisible(true);
            }
            drawbutton(Images.register, 400, 325);
            drawbutton(Images.cancel, 400, 375);
        }
        if (fase == 7 || fase == 8) {
            rd.setColor(new Color(0, 0, 0));
            if (nflk % 4 != 0 || nflk == 0) {
                rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 205);
            }
            if (nflk != 0) {
                nflk--;
            }
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
                if (ncnt != 0) {
                    ncnt--;
                }
                pessd[2] = true;
            }
            if (fase == 7) {
                showtf = true;
                if (!GameSparker.applejava && !GameSparker.temail.isShowing()) {
                    GameSparker.temail.setVisible(true);
                    GameSparker.temail.requestFocus();
                }
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0) {
                    GameSparker.temail.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton(Images.sdets, 400, 280);
            drawbutton(Images.cancel, 400, 375);
            GameSparker.movefieldd(GameSparker.temail, 344, 225, 199, 23, showtf);
            if (!GameSparker.temail.getText().equals(lemail)) {
                fixtext(GameSparker.temail);
                lemail = GameSparker.temail.getText();
            }
        }
    }

    @Override
    public void run() {
        if (checknote) {
            checknote = false;
        }
        if (fase == 2) {
            gs.setCursor(new Cursor(3));
            int i = -1;
            int i15 = -1;
            try {
                socket = new Socket(servers[0], 7061);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
                dout.println("0|" + GameSparker.tnick.getText() + "|");
                final String string = din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                    if (i == 0) {
                        i15 = getvalue(string, 1);
                        xtGraphics.hours = getvalue(string, 2);
                        xtGraphics.nickey = getSvalue(string, 3);
                    }
                }
                socket.close();
                din.close();
                dout.close();
            } catch (final Exception ignored) {

            }
            GameSparker.tnick.setEnabled(true);
            if (i == -1) {
                msg = "Unable to connect to any server at this moment.  Please try again later.";
                fase = 1;
            }
            if (i == 0) {
                xtGraphics.nickname = GameSparker.tnick.getText();
                if (i15 != -1) {
                    xtGraphics.nfreeplays = 0;
                }
                GameSparker.tnick.setVisible(false);
                GameSparker.tpass.setVisible(false);
                GameSparker.temail.setVisible(false);
                GameSparker.keplo.setVisible(false);
                gs.requestFocus();
                xtGraphics.logged = false;
                fase = 12;
                System.gc();
            }
            if (i == 1) {
                msg = "This Nickname is being used by someone else right now.  Please use another.";
                nickero = true;
                GameSparker.tnick.setForeground(new Color(255, 0, 0));
                GameSparker.tnick.requestFocus();
                errcnt = 30;
                fase = 1;
            }
            if (i == 2) {
                msg = "Nickname registerd.  Please use another or click 'Login' bellow to login to this Nickname.";
                nickero = true;
                GameSparker.tnick.setForeground(new Color(255, 0, 0));
                GameSparker.tnick.requestFocus();
                errcnt = 30;
                fase = 1;
            }
            gs.setCursor(new Cursor(0));
        }
        if (fase == 4) {
            gs.setCursor(new Cursor(3));
            int i = -1;
            int i16 = -1;
            String string;
            try {
                socket = new Socket(servers[0], 7061);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
                dout.println("1|" + GameSparker.tnick.getText() + "|" + GameSparker.tpass.getText() + "|");
                string = din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                    if (i == 0 || i == 3 || i > 10 || i == -167) {
                        xtGraphics.nickey = getSvalue(string, 1);
                        if (i != -167) {
                            xtGraphics.clan = getSvalue(string, 2);
                            xtGraphics.clankey = getSvalue(string, 3);
                        } else {
                            xtGraphics.clan = "";
                            xtGraphics.clankey = "";
                            i16 = getvalue(string, 2);
                            xtGraphics.hours = getvalue(string, 3);
                        }
                    }
                }
                socket.close();
                din.close();
                dout.close();
            } catch (final Exception ignored) {

            }
            GameSparker.tnick.setEnabled(true);
            GameSparker.tpass.setEnabled(true);
            GameSparker.keplo.setEnabled(true);
            if (i == -1) {
                msg = "Unable to connect to server at this moment.  Please try again later.";
                fase = 3;
            }
            if (i == 0 || i == 3 || i > 10 || i == -167 || i == 111) {
                xtGraphics.nickname = GameSparker.tnick.getText();
                showtf = false;
                GameSparker.tnick.setVisible(false);
                GameSparker.tpass.setVisible(false);
                GameSparker.temail.setVisible(false);
                GameSparker.keplo.setVisible(false);
                gs.requestFocus();
                GameSparker.setloggedcookie();
                xtGraphics.logged = true;
                xtGraphics.gotlog = true;
                if (i == 0) {
                    xtGraphics.acexp = 0;
                }
                if (i > 10) {
                    xtGraphics.acexp = i - 10;
                }
                if (i == 3) {
                    xtGraphics.acexp = -1;
                }
                if (i == -167) {
                    xtGraphics.logged = false;
                    if (i16 != -1) {
                        xtGraphics.nfreeplays = 0;
                    }
                }
                if (xtGraphics.logged) {
                    xtGraphics.backlog = xtGraphics.nickname;
                }
                fase = 12;
                justlog = true;
                System.gc();
            }
            if (i == 1) {
                msg = "Sorry.  The Nickname you have entered is incorrect or does not exist.";
                GameSparker.tnick.setForeground(new Color(255, 0, 0));
                GameSparker.tnick.requestFocus();
                errcnt = 40;
                fase = 3;
            }
            if (i == 2) {
                msg = "Sorry.  The Password you have entered is incorrect.";
                GameSparker.tpass.setForeground(new Color(255, 0, 0));
                GameSparker.tpass.requestFocus();
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
                dout.println("2|" + GameSparker.temail.getText().toLowerCase() + "|");
                final String string = din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                }
                socket.close();
                din.close();
                dout.close();
            } catch (final Exception ignored) {

            }
            GameSparker.temail.setEnabled(true);
            if (i == -1) {
                msg = "Unable to connect to server at this moment.  Please try again later.";
                fase = 7;
            }
            if (i == 0) {
                showtf = false;
                GameSparker.temail.setVisible(false);
                msg = "Please check your Email: " + GameSparker.temail.getText() + " to login.";
                GameSparker.temail.setText("");
                GameSparker.tnick.setText("");
                GameSparker.tpass.setText("");
                fase = 3;
            }
            if (i == 1) {
                msg = "Sorry.  This Email Address does not exist in our system!";
                GameSparker.temail.setForeground(new Color(255, 0, 0));
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
                } catch (final Exception exception) {
                    serverdone[i] = 5;
                }
            }
            srvtrn = 0;
            socketson = true;
        }
        while (fase == 12 || fase == 13 || fase == 14 || fase == 15) {
            if (srvtrn < nservers) {
                for (/**/ ; serverdone[srvtrn] < xtGraphics.cntptrys; serverdone[srvtrn]++) {
                    if (serverdone[srvtrn] == -1) {
                        serverdone[srvtrn] = 0;
                    }
                    Date date = new Date();
                    servestart[srvtrn] = date.getTime();
                    try {
                        final byte[] is = new byte[4];
                        final DatagramPacket datagrampacket = new DatagramPacket(is, is.length, IPAddress[srvtrn], 7000);
                        final String string = "" + xtGraphics.nickname + "|";
                        final byte[] is17 = string.getBytes();
                        datagrampacket.setData(is17);
                        dSocket[srvtrn].send(datagrampacket);
                        dSocket[srvtrn].receive(datagrampacket);
                        final String string18 = new String(datagrampacket.getData());
                        if (string18.startsWith("OK")) {
                            date = new Date();
                            if (date.getTime() - servestart[srvtrn] < xtGraphics.delays[srvtrn]) {
                                xtGraphics.delays[srvtrn] = (int) (date.getTime() - servestart[srvtrn]);
                            }
                        }
                    } catch (final Exception exception) {
                        xtGraphics.delays[srvtrn] = 6000;
                        serverdone[srvtrn] = 5;
                    }
                }
                srvtrn++;
            }
            try {
                if (connector != null) {

                }
                Thread.sleep(5L);
            } catch (final InterruptedException ignored) {

            }
        }
        if (fase != 12 && fase != 13 && fase != 14 && fase != 15 && fase != 5 && socketson) {
            for (int i = 0; i < nservers; i++) {
                try {
                    dSocket[i].close();
                    dSocket[i] = null;
                } catch (final Exception ignored) {

                }
            }
            socketson = false;
        }
        if (fase == 16 || fase == 17) {
            boolean bool = false;
            int i = 0;
            int i20 = -1;
            recom = 0;
            try {
                socket = new Socket(xtGraphics.server, 7067);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
            } catch (final Exception ignored) {

            }
            while ((fase == 16 || fase == 17) && i != 3) {
                String string = "";
                if (!bool) {
                    try {
                        dout.println("10|");
                        final String string21 = din.readLine();
                        if (string21 == null) {
                            bool = true;
                        } else {
                            string = string21;
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
                        } catch (final Exception ignored) {

                        }
                        try {
                            socket = new Socket(xtGraphics.server, 7067);
                            din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            dout = new PrintWriter(socket.getOutputStream(), true);
                            dout.println("10|");
                            final String string22 = din.readLine();
                            if (string22 != null) {
                                bool = false;
                            } else {
                                string = string22;
                            }
                        } catch (final Exception exception) {
                            bool = true;
                        }
                    }
                    if (bool) {
                        try {
                            socket.close();
                            socket = null;
                        } catch (final Exception ignored) {

                        }
                    }
                }
                if (!bool) {
                    for (int i23 = 0; i23 < 5; i23++) {
                        rmps[i23] = getvalue(string, i23 * 2);
                        rmwt[i23] = getvalue(string, 1 + i23 * 2);
                    }
                    int i24 = 1000;
                    for (int i25 = 0; i25 < 5; i25++)
                        if (Math.abs(rmps[i25] - 6) < i24) {
                            recom = i25;
                            i24 = Math.abs(rmps[i25] - 6);
                        }
                    if (recom != i20) {
                        opselect = recom;
                        i20 = recom;
                    }
                    if (fase == 16) {
                        fase = 17;
                    }
                } else {
                    msg = "Failed to connect to this Server!";
                    i++;
                }
                if (i != 3) {
                    try {
                        if (connector != null) {

                        }
                        Thread.sleep(2000L);
                    } catch (final InterruptedException ignored) {

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
            } catch (final Exception ignored) {

            }
            if (i == 3) {
                resofaso = true;
            }
        }
    }

    void stopallnow() {
        if (connector != null) {
            connector.stop();
            connector = null;
        }
        endcons();
    }

    private void stringbutton(final String string, final int i, final int i60, final int i61) {
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        bx[btn] = i;
        by[btn] = i60 - 5;
        bw[btn] = ftm.stringWidth(string);
        if (!pessd[btn]) {
            rd.setColor(color2k(220, 220, 220));
            rd.fillRect(i - bw[btn] / 2 - 10, i60 - (17 - i61), bw[btn] + 20, 25 - i61 * 2);
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i60 - (17 - i61), i + bw[btn] / 2 + 10, i60 - (17 - i61));
            rd.drawLine(i - bw[btn] / 2 - 10, i60 - (18 - i61), i + bw[btn] / 2 + 10, i60 - (18 - i61));
            rd.drawLine(i - bw[btn] / 2 - 9, i60 - (19 - i61), i + bw[btn] / 2 + 9, i60 - (19 - i61));
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i + bw[btn] / 2 + 10, i60 - (17 - i61), i + bw[btn] / 2 + 10, i60 + 7 - i61);
            rd.drawLine(i + bw[btn] / 2 + 11, i60 - (17 - i61), i + bw[btn] / 2 + 11, i60 + 7 - i61);
            rd.drawLine(i + bw[btn] / 2 + 12, i60 - (16 - i61), i + bw[btn] / 2 + 12, i60 + 6 - i61);
            rd.drawLine(i - bw[btn] / 2 - 10, i60 + 7 - i61, i + bw[btn] / 2 + 10, i60 + 7 - i61);
            rd.drawLine(i - bw[btn] / 2 - 10, i60 + 8 - i61, i + bw[btn] / 2 + 10, i60 + 8 - i61);
            rd.drawLine(i - bw[btn] / 2 - 9, i60 + 9 - i61, i + bw[btn] / 2 + 9, i60 + 9 - i61);
            rd.setColor(color2k(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 10, i60 - (17 - i61), i - bw[btn] / 2 - 10, i60 + 7 - i61);
            rd.drawLine(i - bw[btn] / 2 - 11, i60 - (17 - i61), i - bw[btn] / 2 - 11, i60 + 7 - i61);
            rd.drawLine(i - bw[btn] / 2 - 12, i60 - (16 - i61), i - bw[btn] / 2 - 12, i60 + 6 - i61);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2, i60);
        } else {
            rd.setColor(color2k(210, 210, 210));
            rd.fillRect(i - bw[btn] / 2 - 10, i60 - (17 - i61), bw[btn] + 20, 25 - i61 * 2);
            rd.setColor(color2k(200, 200, 200));
            rd.drawLine(i - bw[btn] / 2 - 10, i60 - (17 - i61), i + bw[btn] / 2 + 10, i60 - (17 - i61));
            rd.drawLine(i - bw[btn] / 2 - 10, i60 - (18 - i61), i + bw[btn] / 2 + 10, i60 - (18 - i61));
            rd.drawLine(i - bw[btn] / 2 - 9, i60 - (19 - i61), i + bw[btn] / 2 + 9, i60 - (19 - i61));
            rd.drawLine(i + bw[btn] / 2 + 10, i60 - (17 - i61), i + bw[btn] / 2 + 10, i60 + 7 - i61);
            rd.drawLine(i + bw[btn] / 2 + 11, i60 - (17 - i61), i + bw[btn] / 2 + 11, i60 + 7 - i61);
            rd.drawLine(i + bw[btn] / 2 + 12, i60 - (16 - i61), i + bw[btn] / 2 + 12, i60 + 6 - i61);
            rd.drawLine(i - bw[btn] / 2 - 10, i60 + 7 - i61, i + bw[btn] / 2 + 10, i60 + 7 - i61);
            rd.drawLine(i - bw[btn] / 2 - 10, i60 + 8 - i61, i + bw[btn] / 2 + 10, i60 + 8 - i61);
            rd.drawLine(i - bw[btn] / 2 - 9, i60 + 9 - i61, i + bw[btn] / 2 + 9, i60 + 9 - i61);
            rd.drawLine(i - bw[btn] / 2 - 10, i60 - (17 - i61), i - bw[btn] / 2 - 10, i60 + 7 - i61);
            rd.drawLine(i - bw[btn] / 2 - 11, i60 - (17 - i61), i - bw[btn] / 2 - 11, i60 + 7 - i61);
            rd.drawLine(i - bw[btn] / 2 - 12, i60 - (16 - i61), i - bw[btn] / 2 - 12, i60 + 6 - i61);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2 + 1, i60);
        }
        btn++;
    }
}
