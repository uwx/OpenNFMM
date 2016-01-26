
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
    private final Medium m;
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
    String[] servers = {
            "multiplayer.needformadness.com", "avenger.needformadness.com", "ghostrider.needformadness.com"
    };
    private final long[] servestart = {
            0L, 0L, 0L
    };
    private boolean showtf = false;
    String[] snames = {
            "Dominion", "Avenger", "Ghostrider"
    };
    private Socket socket;
    private boolean socketson = false;
    private int srvtrn = 0;
    private int trans = 0;
    private int xrl = 0;
    private int xrr = 0;
    private final xtGraphics xt;

    Login(final Medium medium, final Graphics2D graphics2d, final xtGraphics xtgraphics, final GameSparker gamesparker) {
        m = medium;
        rd = graphics2d;
        xt = xtgraphics;
        gs = gamesparker;
        if (xt.playingame != -1) {
            fase = 18;
        }
        if (xt.nofull) {
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
                    if (!string12.equals(xt.servername) || i13 != xt.servport - 7070) {
                        for (int i14 = 0; i14 < nservers; i14++)
                            if (string12.equals(snames[i14]) && xt.delays[i14] < 300) {
                                bool = true;
                            }
                    }
                    if (bool) {
                        gmaker = getSvalue(string, 1);
                        if (gmaker.equals(xt.nickname)) {
                            gmaker = "You";
                        }
                        gamec = i;
                    }
                }
            }
            socket.close();
            din.close();
            dout.close();
        } catch (final Exception exception) {

        }
    }

    private void checknotifcations() {
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
                if (Math.abs(i - bx[i50]) < bw[i50] / 2 + 12 && Math.abs(i47 - by[i50]) < 14
                        && (i48 == 1 || i48 == 11)) {
                    pessd[i50] = true;
                } else {
                    pessd[i50] = false;
                }
                if (Math.abs(i - bx[i50]) < bw[i50] / 2 + 12 && Math.abs(i47 - by[i50]) < 14 && i48 <= -1) {
                    gs.mouses = 0;
                    i49 = i50;
                }
                if (fase == 12 && Math.abs(i - bx[i50]) < bw[i50] / 2 + 12 && Math.abs(i47 - by[i50]) < 14
                        && (i50 == 3 || i50 == 4) && (i != lxm || i47 != lym)) {
                    opselect = i50 - 3;
                }
            }
        }
        if (i49 == 0) {
            gs.tnick.setVisible(false);
            gs.tpass.setVisible(false);
            gs.keplo.setVisible(false);
            gs.temail.setVisible(false);
            gs.requestFocus();
            xt.fase = 24;
        }
        if (i49 == 1 && fase != 5) {
            gs.tnick.setVisible(false);
            gs.tpass.setVisible(false);
            gs.keplo.setVisible(false);
            gs.temail.setVisible(false);
            gs.requestFocus();
            xt.fase = 23;
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
                    gs.editlink(xt.nickname, false);
                    cntcl = 10;
                }
            } else {
                cntcl--;
            }
            if (i49 == i51) {
                i49 = -1;
                if (xt.sc[0] >= 16) {
                    xt.sc[0] = 15;
                    gotcai = false;
                }
                xt.logged = false;
                xt.gotlog = false;
                gs.keplo.setState(false);
                gs.setloggedcookie();
                xt.cd.msloaded = 0;
                xt.cd.lastload = 0;
                msg = "Login to access the multiplayer madness!";
                fase = 3;
            }
        }
        if (fase == 12)
            if (xt.acexp == 0 || contrb) {
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
                if (!xt.logged && i49 == i51 + 3) {
                    gs.editlink(xt.nickname, true);
                }
            } else {
                if (xt.acexp > 0) {
                    if (i49 == i51 + 1 || control.enter) {
                        gs.editlink(xt.nickname, false);
                        i49 = -1;
                    }
                    if (i49 == i51 + 2) {
                        opselect = 0;
                        contrb = true;
                        i49 = -1;
                    }
                }
                if (xt.acexp == -1) {
                    if (i49 == i51 + 1 || control.enter) {
                        gs.editlink(xt.nickname, false);
                        i49 = -1;
                    }
                    if (i49 == i51 + 2) {
                        i49 = -1;
                        if (xt.sc[0] >= 16) {
                            xt.sc[0] = 15;
                            gotcai = false;
                        }
                        xt.logged = false;
                        xt.cd.lastload = 0;
                        msg = "Login to access the multiplayer madness!";
                        fase = 3;
                    }
                }
                if (xt.acexp == -2) {
                    if (i49 == i51 + 1 || control.enter) {
                        gs.multlink();
                        i49 = -1;
                    }
                    if (i49 == i51 + 2) {
                        i49 = -1;
                        if (xt.sc[0] >= 16) {
                            xt.sc[0] = 15;
                            gotcai = false;
                        }
                        xt.logged = false;
                        xt.cd.lastload = 0;
                        msg = "Login to access the multiplayer madness!";
                        fase = 3;
                    }
                }
                if (xt.acexp == -3) {
                    if (i49 == i51 + 1 || control.enter) {
                        gs.editlink(xt.nickname, false);
                        i49 = -1;
                    }
                    if (i49 == i51 + 2) {
                        i49 = -1;
                        if (xt.sc[0] >= 16) {
                            xt.sc[0] = 15;
                            gotcai = false;
                        }
                        xt.logged = false;
                        xt.cd.lastload = 0;
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
                    } catch (final Exception exception) {

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
                        } catch (final Exception exception) {

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
                if (xt.nofull) {
                    nflk = 30;
                } else {
                    xt.server = servers[1];
                    xt.servername = snames[1];
                    xt.servport = 7067;
                    xt.lan = true;
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
                xt.servport = 7071 + opselect;
                xt.lan = false;
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
                gs.tnick.setForeground(new Color(0, 0, 0));
                gs.tpass.setForeground(new Color(0, 0, 0));
                gs.tnick.setVisible(false);
                gs.tpass.setVisible(false);
                gs.keplo.setVisible(false);
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
                gs.reglink();
                gs.mouses = 0;
            }
        }
        if (fase == 1) {
            if (control.enter) {
                i49 = 2;
                pessd[2] = true;
            }
            if (i49 == 2)
                if (gs.tnick.getText().equals("Fyre") || gs.tnick.getText().equals("Nickname")
                        || gs.tnick.getText().equals("")) {
                    msg = "Type in any Nickname to play...";
                    gs.tnick.setText("Nickname");
                    nflk = 30;
                } else {
                    msg = "| Checking Nickname |";
                    gs.tnick.setEnabled(false);
                    fase = 2;
                    connector = new Thread(this);
                    connector.start();
                }
            if (i49 == 3) {
                if (gs.tnick.getText().equals("Nickname") || msg.startsWith("This")) {
                    gs.tnick.setText("");
                }
                msg = "Login to access the multiplayer madness!";
                gs.tnick.setForeground(new Color(0, 0, 0));
                fase = 3;
                i49 = -1;
            }
            if (i49 == 4) {
                if (nickero || gs.tnick.getText().equals("Nickname")) {
                    gs.tnick.setText("");
                    nickero = false;
                }
                gs.tnick.setForeground(new Color(0, 0, 0));
                gs.reglink();
            }
        }
        if (fase == 3) {
            if (control.enter || xt.autolog) {
                i49 = 2;
                pessd[2] = true;
                xt.autolog = false;
            }
            if (control.exit) {
                i49 = 3;
            }
            if (i49 == 2)
                if (gs.tnick.getText().equals("")) {
                    msg = "Enter your Nickname!";
                    nflk = 30;
                } else if (gs.tpass.getText().equals("")) {
                    msg = "Enter your Password!";
                    nflk = 30;
                } else {
                    msg = "| Logging In |";
                    gs.tnick.setEnabled(false);
                    gs.tpass.setEnabled(false);
                    gs.keplo.setEnabled(false);
                    fase = 4;
                    connector = new Thread(this);
                    connector.start();
                }
            if (i49 == 3) {
                gs.regnew();
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
            if (i49 != 1) {

            }
            if (i49 == 2) {
                fase = lrgfase;
                if (fase == 12) {
                    gs.tnick.setVisible(false);
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
                if (gs.temail.getText().equals("")) {
                    msg = "Please type in your Email Address!";
                    nflk = 30;
                }
                if (nflk == 0) {
                    final String string = gs.temail.getText();
                    int i55 = 0;
                    int i56 = 0;
                    for (/**/ ; i55 < string.length(); i55++) {
                        final String string57 = "" + ("") + (string.charAt(i55));
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
                        gs.temail.setForeground(new Color(255, 0, 0));
                    }
                }
                if (nflk == 0) {
                    msg = "| Checking Email |";
                    gs.temail.setEnabled(false);
                    fase = 8;
                    connector = new Thread(this);
                    connector.start();
                }
            }
            if (i49 == 3) {
                inishmulti();
                gs.temail.setText("");
                gs.tpass.setText("");
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
            rd.drawImage(xt.bol, i - bw[btn] / 2 - 15, i59 - 16, null);
            rd.drawImage(xt.bor, i + bw[btn] / 2 + 9, i59 - 16, null);
            rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i59 - 16, bw[btn] + 18, 3, null);
            rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i59 + 13, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i59 - image.getHeight(ob) / 2 + 1, null);
            rd.drawImage(xt.bolp, i - bw[btn] / 2 - 15, i59 - 16, null);
            rd.drawImage(xt.borp, i + bw[btn] / 2 + 9, i59 - 16, null);
            rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i59 - 16, bw[btn] + 18, 3, null);
            rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i59 + 13, bw[btn] + 18, 3, null);
        }
        btn++;
    }

    private void drawSbutton(final Image image, final int i, final int i58) {
        bx[btn] = i;
        by[btn] = i58;
        bw[btn] = image.getWidth(ob);
        if (!pessd[btn]) {
            rd.drawImage(image, i - bw[btn] / 2, i58 - image.getHeight(ob) / 2 - 1, null);
            rd.drawImage(xt.bols, i - bw[btn] / 2 - 15, i58 - 13, null);
            rd.drawImage(xt.bors, i + bw[btn] / 2 + 9, i58 - 13, null);
            rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i58 - 13, bw[btn] + 18, 3, null);
            rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i58 + 10, bw[btn] + 18, 3, null);
        } else {
            rd.drawImage(image, i - bw[btn] / 2 + 1, i58 - image.getHeight(ob) / 2, null);
            rd.drawImage(xt.bolps, i - bw[btn] / 2 - 15, i58 - 13, null);
            rd.drawImage(xt.borps, i + bw[btn] / 2 + 9, i58 - 13, null);
            rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i58 - 13, bw[btn] + 18, 3, null);
            rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i58 + 10, bw[btn] + 18, 3, null);
        }
        btn++;
    }

    void endcons() {
        for (int i = 0; i < nservers; i++) {
            try {
                dSocket[i].close();
                dSocket[i] = null;
            } catch (final Exception exception) {

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
    }

    void exitfromlobby() {
        if (!xt.lan) {
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
        m.crs = true;
        m.x = -335;
        m.y = 0;
        m.z = -50;
        m.xz = 0;
        m.zy = 20;
        m.ground = -2000;
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
            final String string67 = "" + ("") + (string.charAt(i));
            if (string67.equals("|") || string67.equals(",") || string67.equals("(") || string67.equals(")")
                    || string67.equals("#") || string67.equals(string64) || string67.equals("!") || string67.equals("?")
                    || string67.equals(" ") || string67.equals("~") || string67.equals("$") || string67.equals("%")
                    || string67.equals("^") || string67.equals("&") || string67.equals("*") || string67.equals("+")
                    || string67.equals("=") || string67.equals(">") || string67.equals("<") || string67.equals("/")
                    || string67.equals("'") || string67.equals(";") || string67.equals(":")
                    || string67.equals("\u00a0")) {
                i66 = i;
            } else {
                string65 = "" + (string65) + (string67);
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
            dout.println("" + ("101|20|") + (xt.nickname) + ("|") + (xt.nickey) + ("|") + (xt.servername) + ("|") + (xt.servport
                    - 7070) + ("|"));
            din.readLine();
            socket.close();
            din.close();
            dout.close();
        } catch (final Exception exception) {

        }
    }

    private String getSvalue(final String string, final int i) {
        String string74 = "";
        try {
            int i75 = 0;
            int i76 = 0;
            int i77 = 0;
            String string78 = "";
            String string79 = "";
            for (/**/ ; i75 < string.length() && i77 != 2; i75++) {
                string78 = "" + ("") + (string.charAt(i75));
                if (string78.equals("|")) {
                    i76++;
                    if (i77 == 1 || i76 > i) {
                        i77 = 2;
                    }
                } else if (i76 == i) {
                    string79 = "" + (string79) + (string78);
                    i77 = 1;
                }
            }
            string74 = string79;
        } catch (final Exception exception) {

        }
        return string74;
    }

    private int getvalue(final String string, final int i) {
        int i68 = -1;
        try {
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            String string72 = "";
            String string73 = "";
            for (/**/ ; i69 < string.length() && i71 != 2; i69++) {
                string72 = "" + ("") + (string.charAt(i69));
                if (string72.equals("|")) {
                    i70++;
                    if (i71 == 1 || i70 > i) {
                        i71 = 2;
                    }
                } else if (i70 == i) {
                    string73 = "" + (string73) + (string72);
                    i71 = 1;
                }
            }
            if (string73.equals("")) {
                string73 = "-1";
            }
            i68 = Integer.valueOf(string73).intValue();
        } catch (final Exception exception) {

        }
        return i68;
    }

    void inishmulti() {
        gs.tnick.setVisible(false);
        gs.tnick.setEnabled(true);
        gs.tnick.setForeground(new Color(0, 0, 0));
        gs.tnick.setBackground(color2k(240, 240, 240));
        gs.tpass.setVisible(false);
        gs.tpass.setEnabled(true);
        gs.tpass.setForeground(new Color(0, 0, 0));
        gs.tpass.setBackground(color2k(240, 240, 240));
        gs.temail.setVisible(false);
        gs.temail.setEnabled(true);
        gs.temail.setForeground(new Color(0, 0, 0));
        gs.temail.setBackground(color2k(240, 240, 240));
        gs.keplo.setVisible(false);
        gs.keplo.setEnabled(true);
        gs.keplo.setForeground(new Color(0, 0, 0));
        gs.keplo.setBackground(new Color(193, 181, 142));
        gs.requestFocus();
        if (gs.tnick.getText().equals("")) {
            gs.tnick.setText("Nickname");
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
        m.crs = true;
        m.x = -335;
        m.y = 0;
        m.z = -50;
        m.xz = 0;
        m.zy = 20;
        m.ground = -2000;
        pend = 0;
        pendb = false;
        resofaso = false;
        for (int i = 0; i < nservers; i++) {
            serverdone[i] = -1;
            servestart[i] = 0L;
        }
        checknote = false;
        if (xt.gotlog) {
            checknote = true;
            socketson = false;
            fase = 12;
            connector = new Thread(this);
            connector.start();
        } else {
            msg = "Login to access the multiplayer madness!";
            gs.tnick.setText(xt.nickname);
            fase = 3;
        }
    }

    void multimode(final ContO[] contos) {
        btn = 0;
        xt.mainbg(4);
        for (int i = 0; i < 3; i++) {
            rd.drawImage(xt.bgmain, 65, bgmy[i], null);
            bgmy[i] -= 4;
            if (bgmy[i] <= -400) {
                bgmy[i] = 800;
            }
        }
        rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
        rd.drawImage(xt.bggo, 0, 0, null);
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
            rd.drawImage(xt.logomadnes, 96 + (int) (2.0 - Math.random() * 4.0), 11
                    + (int) (2.0 - Math.random() * 4.0), null);
        } else {
            rd.drawImage(xt.logomadnes, 96, 11, null);
        }
        flipo++;
        if (flipo > 50) {
            flipo = 0;
        }
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        drawSbutton(xt.exit, 690, 17);
        rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
        rd.setColor(new Color(203, 227, 253));
        rd.fillRoundRect(319, 83, 180, 96, 20, 20);
        rd.fillRoundRect(173, 83, 132, 32, 20, 20);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        rd.setColor(color2k(90, 90, 90));
        rd.drawRoundRect(319, 83, 180, 96, 20, 20);
        rd.drawRoundRect(173, 83, 132, 32, 20, 20);
        if (!gotcai) {
            int i = contos[xt.sc[0]].p[0].oz[0];
            int i26 = i;
            int i27 = contos[xt.sc[0]].p[0].oy[0];
            int i28 = i27;
            for (int i29 = 0; i29 < contos[xt.sc[0]].npl; i29++) {
                for (int i30 = 0; i30 < contos[xt.sc[0]].p[i29].n; i30++) {
                    if (contos[xt.sc[0]].p[i29].oz[i30] < i) {
                        i = contos[xt.sc[0]].p[i29].oz[i30];
                    }
                    if (contos[xt.sc[0]].p[i29].oz[i30] > i26) {
                        i26 = contos[xt.sc[0]].p[i29].oz[i30];
                    }
                    if (contos[xt.sc[0]].p[i29].oy[i30] < i27) {
                        i27 = contos[xt.sc[0]].p[i29].oy[i30];
                    }
                    if (contos[xt.sc[0]].p[i29].oy[i30] > i28) {
                        i28 = contos[xt.sc[0]].p[i29].oy[i30];
                    }
                }
            }
            cax = (i26 + i) / 2;
            cay = (i28 + i27) / 2;
            gotcai = true;
        }
        contos[xt.sc[0]].z = 1500;
        contos[xt.sc[0]].y = 380 - cay;
        contos[xt.sc[0]].x = 100 - cax;
        contos[xt.sc[0]].zy = 0;
        contos[xt.sc[0]].xz = -90;
        contos[xt.sc[0]].xy = pend;
        rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        contos[xt.sc[0]].d(rd);
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
        rd.drawString(xt.nickname, 239 - ftm.stringWidth(xt.nickname) / 2, 105);
        rd.setColor(color2k(90, 90, 90));
        rd.drawString("" + ("") + (xt.cd.names[xt.sc[0]]) + (""), 409
                - ftm.stringWidth("" + ("") + (xt.cd.names[xt.sc[0]]) + (""))
                        / 2, 81);
        rd.drawString("Nickname", 239 - ftm.stringWidth("Nickname") / 2, 81);
        drawbutton(xt.change, 570, 98);
        drawSbutton(xt.logout, 239, 135);
        rd.setColor(new Color(98, 56, 0));
        rd.drawString("Edit my Account", 239 - ftm.stringWidth("Edit my Account") / 2, 168);
        if (ond) {
            rd.drawLine(239 - ftm.stringWidth("Edit my Account") / 2, 169, 239 - ftm.stringWidth("Edit my Account") / 2
                    + ftm.stringWidth("Edit my Account"), 169);
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
                    xt.delays[i] = 600;
                    serverdone[i] = 5;
                    connector = new Thread(this);
                    connector.start();
                }
            }
        }
        if (fase == 12)
            if (xt.acexp == 0 || contrb) {
                rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                rd.setColor(new Color(203, 227, 253));
                rd.fillRoundRect(205, 225, 390, 120, 20, 20);
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                rd.setColor(color2k(90, 90, 90));
                rd.drawString("Multiplayer Mode", 400 - ftm.stringWidth("Multiplayer Mode") / 2, 220);
                rd.drawRoundRect(205, 225, 390, 120, 20, 20);
                drawbutton(xt.pln, 400, 285 - xt.pln.getHeight(ob) / 2);
                if (opselect == 1 && !pessd[4]) {
                    rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                    rd.setColor(new Color(203, 227, 253));
                    rd.fillRect(387 - xt.pln.getWidth(ob) / 2, 285 - xt.pln.getHeight(ob) - 5, xt.pln.getWidth(ob)
                            + 26, 26);
                    rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                }
                drawbutton(xt.pln, 400, 285 - xt.pln.getHeight(ob) / 2);
            } else {
                rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                rd.setColor(new Color(203, 227, 253));
                rd.fillRoundRect(165, 219, 470, 135, 20, 20);
                rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                rd.setColor(color2k(90, 90, 90));
                rd.drawRoundRect(165, 219, 470, 135, 20, 20);
                if (xt.acexp > 0) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("" + ("Dear ") + (xt.nickname) + (","), 185, 245);
                    rd.drawString("" + ("Your account is due to expire in ") + (xt.acexp) + (" days."), 185, 265);
                    rd.drawString("Renew your registration soon!", 185, 295);
                    stringbutton("Renew my Account Registration now!", 345, 332, 0);
                    stringbutton("Renew Later", 524, 332, 0);
                }
                if (xt.acexp == -1) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("" + ("Dear ") + (xt.nickname) + (","), 185, 245);
                    rd.drawString("Your Need for Madness account registration has expired.", 185, 265);
                    rd.drawString("Please renew your registration.", 185, 295);
                    stringbutton("Renew my account registration now!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if (xt.acexp == -2) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("" + ("Dear ") + (xt.nickname) + (","), 185, 245);
                    rd.drawString("Trial accounts are not allowed to access the downloaded game.", 185, 265);
                    rd.drawString("You can only play the game online using your trial account.", 185, 295);
                    stringbutton("Play the multiplayer online!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if (xt.acexp == -3) {
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
                rd.drawImage(xt.pln, 400 - xt.pln.getWidth(ob) / 2, 315 - xt.pln.getHeight(ob) / 2 - 12 - trans, null);
            } else {
                rd.drawImage(xt.pln, 400 - xt.pln.getWidth(ob) / 2, 215 - xt.pln.getHeight(ob) / 2 - 12, null);
            }
            if (trans >= 100) {
                rd.setColor(color2k(255, 255, 255));
                rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                rd.setColor(new Color(0, 0, 0));
                rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if (xt.nofull) {
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
                drawbutton(xt.cancel, 583, 395);
                drawbutton(xt.play, 400, 395);
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
        xt.mainbg(4);
        for (int i39 = 0; i39 < 3; i39++) {
            rd.drawImage(xt.bgmain, 65, bgmy[i39], null);
            bgmy[i39] -= 4;
            if (bgmy[i39] <= -400) {
                bgmy[i39] = 800;
            }
        }
        rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
        rd.drawImage(xt.bggo, 0, 0, null);
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
            rd.drawImage(xt.logomadnes, 96 + (int) (2.0 - Math.random() * 4.0), 11
                    + (int) (2.0 - Math.random() * 4.0), null);
        } else {
            rd.drawImage(xt.logomadnes, 96, 11, null);
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
        rd.drawImage(xt.dude[i40], 87, 76, null);
        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        rd.drawImage(xt.redy, 445, 153, null);
        // really dirty solution to a very specific bug
        // DO NOT DELETE THE LINE BELOW
        // drawSbutton((xt).exit, 690, 17);
        drawSbutton(xt.exit, 690, 17);
        rd.setFont(new Font("Arial", 1, 13));
        ftm = rd.getFontMetrics();
        if (fase != 5) {
            rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
            rd.setColor(new Color(203, 227, 253));
            rd.fillRoundRect(246, 83, 180, 96, 20, 20);
            rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            rd.setColor(color2k(90, 90, 90));
            rd.drawString("" + ("") + (xt.cd.names[xt.sc[0]]) + (""), 336
                    - ftm.stringWidth("" + ("") + (xt.cd.names[xt.sc[0]]) + (""))
                            / 2, 81);
            rd.drawRoundRect(246, 83, 180, 96, 20, 20);
            if (!gotcai) {
                int i41 = contos[xt.sc[0]].p[0].oz[0];
                int i42 = i41;
                int i43 = contos[xt.sc[0]].p[0].oy[0];
                int i44 = i43;
                for (int i45 = 0; i45 < contos[xt.sc[0]].npl; i45++) {
                    for (int i46 = 0; i46 < contos[xt.sc[0]].p[i45].n; i46++) {
                        if (contos[xt.sc[0]].p[i45].oz[i46] < i41) {
                            i41 = contos[xt.sc[0]].p[i45].oz[i46];
                        }
                        if (contos[xt.sc[0]].p[i45].oz[i46] > i42) {
                            i42 = contos[xt.sc[0]].p[i45].oz[i46];
                        }
                        if (contos[xt.sc[0]].p[i45].oy[i46] < i43) {
                            i43 = contos[xt.sc[0]].p[i45].oy[i46];
                        }
                        if (contos[xt.sc[0]].p[i45].oy[i46] > i44) {
                            i44 = contos[xt.sc[0]].p[i45].oy[i46];
                        }
                    }
                }
                cax = (i42 + i41) / 2;
                cay = (i44 + i43) / 2;
                gotcai = true;
            }
            contos[xt.sc[0]].z = 1500;
            contos[xt.sc[0]].y = 380 - cay;
            contos[xt.sc[0]].x = -170 - cax;
            contos[xt.sc[0]].zy = 0;
            contos[xt.sc[0]].xz = -90;
            contos[xt.sc[0]].xy = pend;
            rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            contos[xt.sc[0]].d(rd);
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
            drawbutton(xt.change, 497, 98);
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
            if (fase == 1 && !gs.tnick.isShowing()) {
                gs.tnick.setVisible(true);
                gs.tnick.requestFocus();
                if (gs.tnick.getText().equals("Nickname")) {
                    gs.tnick.select(8, 8);
                }
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0) {
                    gs.tnick.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton(xt.play, 400, 285);
            if (nflk > 0) {
                if (gs.tnick.getText().equals("")) {
                    gs.tnick.setText("Nickname");
                    if (nflk == 1) {
                        gs.tnick.select(8, 8);
                    }
                } else {
                    gs.tnick.setText("");
                }
                nflk--;
            }
            drawbutton(xt.login, 400, 340);
            drawbutton(xt.register, 400, 395);
            gs.movefield(gs.tnick, 400, 225, 129, 23);
            while (ftm.stringWidth(gs.tnick.getText()) > 86) {
                gs.tnick.setText(gs.tnick.getText().substring(0, gs.tnick.getText().length() - 1));
                gs.tnick.select(gs.tnick.getText().length(), gs.tnick.getText().length());
            }
            if (!gs.tnick.getText().equals(lnick)) {
                fixtext(gs.tnick);
                lnick = gs.tnick.getText();
            }
            if (xt.msgcheck(gs.tnick.getText())) {
                gs.tnick.setText("");
            }
            if (gs.tnick.getText().toLowerCase().indexOf("madbot") != -1) {
                gs.tnick.setText("");
            }
        }
        if (fase == 3 || fase == 4) {
            rd.drawImage(xt.ntrg, 97, 388, null);
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
                if (!gs.applejava) {
                    if (!gs.tpass.isShowing()) {
                        gs.tpass.setVisible(true);
                        if (!gs.tnick.getText().equals("")) {
                            gs.tpass.requestFocus();
                        }
                    }
                    if (!gs.tnick.isShowing()) {
                        gs.tnick.setVisible(true);
                        if (gs.tnick.getText().equals("")) {
                            gs.tnick.requestFocus();
                        }
                    }
                }
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0) {
                    gs.tpass.setText("");
                    gs.tnick.setForeground(new Color(0, 0, 0));
                    gs.tpass.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton(xt.login, 400, 315);
            if (onf) {
                rd.setColor(color2k(0, 72, 255));
            } else {
                rd.setColor(color2k(120, 120, 120));
            }
            rd.setFont(new Font("Arial", 1, 11));
            ftm = rd.getFontMetrics();
            rd.drawString("Forgot your nickname or password?", 400
                    - ftm.stringWidth("Forgot your nickname or password?") / 2, 345);
            rd.setColor(new Color(0, 0, 0));
            rd.setFont(new Font("Arial", 1, 12));
            ftm = rd.getFontMetrics();
            final String string = "Register a full account here!";
            xrl = 400 - ftm.stringWidth(string) / 2;
            xrr = xrl + ftm.stringWidth(string);
            rd.drawString(string, xrl, 371);
            rd.drawLine(xrl, 372, xrr, 372);
            drawbutton(xt.register, 400, 395);
            gs.movefieldd(gs.tnick, 376, 221, 129, 23, showtf);
            if (!gs.tnick.getText().equals(lnick)) {
                fixtext(gs.tnick);
                lnick = gs.tnick.getText();
            }
            gs.movefieldd(gs.tpass, 376, 251, 129, 23, showtf);
            if (!gs.tpass.getText().equals(lpass)) {
                fixtext(gs.tpass);
                lpass = gs.tpass.getText();
            }
            if (fase == 3 && (!gs.tpass.getText().equals("") && !gs.tnick.getText().equals("") || !gs.applejava)
                    && !gs.keplo.isShowing()) {
                gs.keplo.setVisible(true);
            }
            gs.movefield(gs.keplo, 376, 275, 129, 23);
        }
        if (fase == 5) {
            rd.setColor(new Color(0, 0, 0));
            rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 141);
            gs.movefield(gs.tnick, 376, 125, 129, 23);
            while (ftm.stringWidth(gs.tnick.getText()) > 86) {
                gs.tnick.setText(gs.tnick.getText().substring(0, gs.tnick.getText().length() - 1));
                gs.tnick.select(gs.tnick.getText().length(), gs.tnick.getText().length());
            }
            if (!gs.tnick.getText().equals(lnick)) {
                fixtext(gs.tnick);
                lnick = gs.tnick.getText();
            }
            if (!gs.tnick.isShowing()) {
                gs.tnick.setVisible(true);
            }
            drawbutton(xt.register, 400, 325);
            drawbutton(xt.cancel, 400, 375);
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
                if (!gs.applejava && !gs.temail.isShowing()) {
                    gs.temail.setVisible(true);
                    gs.temail.requestFocus();
                }
            }
            if (errcnt != 0) {
                errcnt--;
                if (errcnt == 0) {
                    gs.temail.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton(xt.sdets, 400, 280);
            drawbutton(xt.cancel, 400, 375);
            gs.movefieldd(gs.temail, 344, 225, 199, 23, showtf);
            if (!gs.temail.getText().equals(lemail)) {
                fixtext(gs.temail);
                lemail = gs.temail.getText();
            }
        }
    }

    @Override
    public void run() {
        if (checknote) {
            checknotifcations();
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
                dout.println("" + ("0|") + (gs.tnick.getText()) + ("|"));
                final String string = din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                    if (i == 0) {
                        i15 = getvalue(string, 1);
                        xt.hours = getvalue(string, 2);
                        xt.nickey = getSvalue(string, 3);
                    }
                }
                socket.close();
                din.close();
                dout.close();
            } catch (final Exception exception) {

            }
            gs.tnick.setEnabled(true);
            if (i == -1) {
                msg = "Unable to connect to any server at this moment.  Please try again later.";
                fase = 1;
            }
            if (i == 0) {
                xt.nickname = gs.tnick.getText();
                if (i15 != -1) {
                    xt.nfreeplays = 0;
                }
                gs.tnick.setVisible(false);
                gs.tpass.setVisible(false);
                gs.temail.setVisible(false);
                gs.keplo.setVisible(false);
                gs.requestFocus();
                xt.logged = false;
                fase = 12;
                System.gc();
            }
            if (i == 1) {
                msg = "This Nickname is being used by someone else right now.  Please use another.";
                nickero = true;
                gs.tnick.setForeground(new Color(255, 0, 0));
                gs.tnick.requestFocus();
                errcnt = 30;
                fase = 1;
            }
            if (i == 2) {
                msg = "Nickname registerd.  Please use another or click 'Login' bellow to login to this Nickname.";
                nickero = true;
                gs.tnick.setForeground(new Color(255, 0, 0));
                gs.tnick.requestFocus();
                errcnt = 30;
                fase = 1;
            }
            gs.setCursor(new Cursor(0));
        }
        if (fase == 4) {
            gs.setCursor(new Cursor(3));
            int i = -1;
            int i16 = -1;
            String string = "";
            try {
                socket = new Socket(servers[0], 7061);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
                dout.println("" + ("1|") + (gs.tnick.getText()) + ("|") + (gs.tpass.getText()) + ("|"));
                string = din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                    if (i == 0 || i == 3 || i > 10 || i == -167) {
                        xt.nickey = getSvalue(string, 1);
                        if (i != -167) {
                            xt.clan = getSvalue(string, 2);
                            xt.clankey = getSvalue(string, 3);
                        } else {
                            xt.clan = "";
                            xt.clankey = "";
                            i16 = getvalue(string, 2);
                            xt.hours = getvalue(string, 3);
                        }
                    }
                }
                socket.close();
                din.close();
                dout.close();
            } catch (final Exception exception) {

            }
            gs.tnick.setEnabled(true);
            gs.tpass.setEnabled(true);
            gs.keplo.setEnabled(true);
            if (i == -1) {
                msg = "Unable to connect to server at this moment.  Please try again later.";
                fase = 3;
            }
            if (i == 0 || i == 3 || i > 10 || i == -167 || i == 111) {
                xt.nickname = gs.tnick.getText();
                showtf = false;
                gs.tnick.setVisible(false);
                gs.tpass.setVisible(false);
                gs.temail.setVisible(false);
                gs.keplo.setVisible(false);
                gs.requestFocus();
                gs.setloggedcookie();
                xt.logged = true;
                xt.gotlog = true;
                if (i == 0) {
                    xt.acexp = 0;
                }
                if (i > 10) {
                    xt.acexp = i - 10;
                }
                if (i == 3) {
                    xt.acexp = -1;
                }
                if (i == -167) {
                    xt.logged = false;
                    if (i16 != -1) {
                        xt.nfreeplays = 0;
                    }
                }
                if (xt.logged) {
                    xt.backlog = xt.nickname;
                }
                fase = 12;
                justlog = true;
                checknotifcations();
                System.gc();
            }
            if (i == 1) {
                msg = "Sorry.  The Nickname you have entered is incorrect or does not exist.";
                gs.tnick.setForeground(new Color(255, 0, 0));
                gs.tnick.requestFocus();
                errcnt = 40;
                fase = 3;
            }
            if (i == 2) {
                msg = "Sorry.  The Password you have entered is incorrect.";
                gs.tpass.setForeground(new Color(255, 0, 0));
                gs.tpass.requestFocus();
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
                dout.println("" + ("2|") + (gs.temail.getText().toLowerCase()) + ("|"));
                final String string = din.readLine();
                if (string != null) {
                    i = getvalue(string, 0);
                }
                socket.close();
                din.close();
                dout.close();
            } catch (final Exception exception) {

            }
            gs.temail.setEnabled(true);
            if (i == -1) {
                msg = "Unable to connect to server at this moment.  Please try again later.";
                fase = 7;
            }
            if (i == 0) {
                showtf = false;
                gs.temail.setVisible(false);
                msg = "" + ("Please check your Email: ") + (gs.temail.getText()) + (" to login.");
                gs.temail.setText("");
                gs.tnick.setText("");
                gs.tpass.setText("");
                fase = 3;
            }
            if (i == 1) {
                msg = "Sorry.  This Email Address does not exist in our system!";
                gs.temail.setForeground(new Color(255, 0, 0));
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
                for (/**/ ; serverdone[srvtrn] < xt.cntptrys; serverdone[srvtrn]++) {
                    if (serverdone[srvtrn] == -1) {
                        serverdone[srvtrn] = 0;
                    }
                    Date date = new Date();
                    servestart[srvtrn] = date.getTime();
                    try {
                        final byte[] is = new byte[4];
                        final DatagramPacket datagrampacket = new DatagramPacket(is, is.length, IPAddress[srvtrn], 7000);
                        final String string = "" + ("") + (xt.nickname) + ("|");
                        final byte[] is17 = string.getBytes();
                        datagrampacket.setData(is17);
                        dSocket[srvtrn].send(datagrampacket);
                        dSocket[srvtrn].receive(datagrampacket);
                        final String string18 = new String(datagrampacket.getData());
                        if (string18.startsWith("OK")) {
                            date = new Date();
                            if (date.getTime() - servestart[srvtrn] < xt.delays[srvtrn]) {
                                xt.delays[srvtrn] = (int) (date.getTime() - servestart[srvtrn]);
                            }
                        }
                    } catch (final Exception exception) {
                        xt.delays[srvtrn] = 6000;
                        serverdone[srvtrn] = 5;
                    }
                }
                srvtrn++;
            }
            try {
                if (connector != null) {

                }
                Thread.sleep(5L);
            } catch (final InterruptedException interruptedexception) {

            }
        }
        if (fase != 12 && fase != 13 && fase != 14 && fase != 15 && fase != 5 && socketson) {
            for (int i = 0; i < nservers; i++) {
                try {
                    dSocket[i].close();
                    dSocket[i] = null;
                } catch (final Exception exception) {

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
                socket = new Socket(xt.server, 7067);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
            } catch (final Exception exception) {

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
                        } catch (final Exception exception) {

                        }
                        try {
                            socket = new Socket(xt.server, 7067);
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
                        } catch (final Exception exception) {

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
                    } catch (final InterruptedException interruptedexception) {

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
            } catch (final Exception exception) {

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
