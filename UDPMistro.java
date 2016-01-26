
/* UDPMistro - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

class UDPMistro implements Runnable {
    int delay = 0;
    int diled = 0;
    int diledelay = 0;
    private BufferedReader din;
    private PrintWriter dout;
    //int[] force = new int[7];
    float freg = 0.0F;
    boolean go = false;
    //int[] gocnt = new int[7];
    int im = 0;
    //boolean[] isbot = new boolean[7];
    //int[] lcframe = new int[7];
    int[] ldelays = new int[5];
    //int[] lframe = new int[7];
    int nplayers = 0;
    //int[] out = new int[7];
    private int pgame = 0;
    private int porturn = 0;
    private final int rate = 30;
    private Thread runner;
    int runon = 0;
    long sendat = 0L;
    String sendcheck = "";
    private Socket socket;
    private final udpOnline[] udpc = new udpOnline[20];
    private int wx = 0;
    private String xtserver = "";
    private int xtservport = 0;

    //fixed for 8 player games
    private final udpServe[] usrv = new udpServe[13];

    String[][] info = new String[14][3];
    int[][] frame = new int[14][3];
    int[] lframe = new int[8];
    int[] force = new int[8];
    int[] lcframe = new int[8];
    boolean[] isbot = new boolean[8];
    int[] gocnt = new int[8];
    int[] out = new int[8];

    private int getncoms(final String string) {
        int i = 0;
        int i89 = 0;
        String string90 = "";
        for (/**/; i89 < string.length(); i89++) {
            string90 = new StringBuilder().append("").append(string.charAt(i89)).toString();
            if (string90.equals(",")) {
                i++;
            }
        }
        return i;
    }

    private String getSvalue(final String string, final int i) {
        String string83 = "";
        try {
            int i84 = 0;
            int i85 = 0;
            int i86 = 0;
            String string87 = "";
            String string88 = "";
            for (/**/; i84 < string.length() && i86 != 2; i84++) {
                string87 = new StringBuilder().append("").append(string.charAt(i84)).toString();
                if (string87.equals(",")) {
                    i85++;
                    if (i86 == 1 || i85 > i) {
                        i86 = 2;
                    }
                } else if (i85 == i) {
                    string88 = new StringBuilder().append(string88).append(string87).toString();
                    i86 = 1;
                }
            }
            string83 = string88;
        } catch (final Exception exception) {

        }
        return string83;
    }

    private int getvalue(final String string, final int i) {
        int i78 = -1;
        try {
            int i79 = 0;
            int i80 = 0;
            String string81 = "";
            String string82 = "";
            for (/**/; wx < string.length() && i80 != 2; wx++) {
                string81 = new StringBuilder().append("").append(string.charAt(wx)).toString();
                if (string81.equals(",")) {
                    i79++;
                    if (i80 == 1 || i79 > i) {
                        i80 = 2;
                    }
                } else if (i79 == i) {
                    string82 = new StringBuilder().append(string82).append(string81).toString();
                    i80 = 1;
                }
            }
            if (string82.equals("")) {
                string82 = "-1";
            }
            i78 = Integer.valueOf(string82).intValue();
        } catch (final Exception exception) {

        }
        return i78;
    }

    void readContOinfo(final ContO conto, final int i) {
        if (go && force[i] == 1 && !isbot[i]) {
            int i37 = -2;
            if (i37 == -2) {
                for (int i38 = 0; i38 < 3; i38++)
                    if (frame[i][i38] == lframe[i] + 1) {
                        i37 = -1;
                    }
            }
            if (i37 == -1) {
                for (int i39 = 0; i39 < 3; i39++)
                    if (frame[i][i39] == lframe[i]) {
                        i37 = i39;
                    }
            }
            if (i37 > 0) {
                final String string = info[i][i37];
                final int i40 = getncoms(string);
                wx = 0;
                if (i40 > 1) {
                    conto.x = getvalue(string, 1);
                }
                if (i40 > 1) {
                    conto.y = getvalue(string, 0);
                }
                if (i40 > 1) {
                    conto.z = getvalue(string, 0);
                }
                if (i40 > 1) {
                    conto.xz = getvalue(string, 0);
                }
                if (i40 > 1) {
                    conto.xy = getvalue(string, 0);
                }
                if (i40 > 1) {
                    conto.zy = getvalue(string, 0);
                }
            }
        }
    }

    void readinfo(final Mad mad, final ContO conto, final Control control, final int i, final int[] is) {
        if (go && force[i] != 7 && !isbot[i]) {
            freg += 0.05;
            int i29 = -1;
            if (i29 == -1) {
                for (int i30 = 0; i30 < 3; i30++)
                    if (frame[i][i30] == lframe[i] + 1) {
                        i29 = i30;
                        if (i30 == 1) {
                            freg -= 0.1;
                        }
                        if (i30 == 2) {
                            freg -= 0.15;
                        }
                    }
            }
            if (i29 == -1) {
                int i31 = 0;
                for (int i32 = 0; i32 < 3; i32++)
                    if (frame[i][i32] > lframe[i] + 1) {
                        i31++;
                    }
                if (i31 == 3) {
                    i29 = 2;
                }
            }
            if (i29 == -1 && force[i] == 1) {
                for (int i33 = 0; i33 < 3; i33++)
                    if (frame[i][i33] >= lframe[i]) {
                        i29 = i33;
                    }
                if (i29 == -1) {
                    freg += 0.2;
                }
            }
            if (freg < -15.0F) {
                freg = -15.0F;
            }
            if (freg > 0.0F) {
                freg = 0.0F;
            }
            if (i29 != -1) {
                force[i] = 0;
                final String string = info[i][i29];
                final String string34 = getSvalue(string, 0);
                if (string34.length() == 16) {
                    String string35 = "";
                    string35 = new StringBuilder().append("").append(string34.charAt(0)).toString();
                    if (string35.equals("0")) {
                        control.left = false;
                    } else {
                        control.left = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(1)).toString();
                    if (string35.equals("0")) {
                        control.right = false;
                    } else {
                        control.right = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(2)).toString();
                    if (string35.equals("0")) {
                        control.up = false;
                    } else {
                        control.up = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(3)).toString();
                    if (string35.equals("0")) {
                        control.down = false;
                    } else {
                        control.down = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(4)).toString();
                    if (string35.equals("0")) {
                        control.handb = false;
                    } else {
                        control.handb = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(5)).toString();
                    if (string35.equals("0")) {
                        mad.newcar = false;
                    } else {
                        mad.newcar = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(6)).toString();
                    if (string35.equals("0")) {
                        mad.mtouch = false;
                    } else {
                        mad.mtouch = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(7)).toString();
                    if (string35.equals("0")) {
                        mad.wtouch = false;
                    } else {
                        mad.wtouch = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(8)).toString();
                    if (string35.equals("0")) {
                        mad.pushed = false;
                    } else {
                        mad.pushed = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(9)).toString();
                    if (string35.equals("0")) {
                        mad.gtouch = false;
                    } else {
                        mad.gtouch = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(10)).toString();
                    if (string35.equals("0")) {
                        mad.pl = false;
                    } else {
                        mad.pl = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(11)).toString();
                    if (string35.equals("0")) {
                        mad.pr = false;
                    } else {
                        mad.pr = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(12)).toString();
                    if (string35.equals("0")) {
                        mad.pd = false;
                    } else {
                        mad.pd = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(13)).toString();
                    if (string35.equals("0")) {
                        mad.pu = false;
                    } else {
                        mad.pu = true;
                    }
                    string35 = new StringBuilder().append("").append(string34.charAt(14)).toString();
                    if (string35.equals("0")) {
                        mad.dest = false;
                    } else {
                        mad.dest = true;
                    }
                } else if (string34.equals("disco")) {
                    is[i] = 3;
                    mad.hitmag = mad.cd.maxmag[mad.cn] + 100;
                    force[i] = 7;
                }
                if (force[i] != 7) {
                    final int i36 = getncoms(string);
                    wx = 0;
                    if (i36 > 1) {
                        conto.x = getvalue(string, 1);
                    }
                    if (i36 > 2) {
                        conto.y = getvalue(string, 0);
                    }
                    if (i36 > 3) {
                        conto.z = getvalue(string, 0);
                    }
                    if (i36 > 4) {
                        conto.xz = getvalue(string, 0);
                    }
                    if (i36 > 5) {
                        conto.xy = getvalue(string, 0);
                    }
                    if (i36 > 6) {
                        conto.zy = getvalue(string, 0);
                    }
                    if (i36 > 7) {
                        mad.speed = getvalue(string, 0) / 100.0F;
                    }
                    if (i36 > 8) {
                        mad.power = getvalue(string, 0) / 100.0F;
                    }
                    if (i36 > 9) {
                        mad.mxz = getvalue(string, 0);
                    }
                    if (i36 > 10) {
                        mad.pzy = getvalue(string, 0);
                    }
                    if (i36 > 11) {
                        mad.pxy = getvalue(string, 0);
                    }
                    if (i36 > 12) {
                        mad.txz = getvalue(string, 0);
                    }
                    if (i36 > 13) {
                        mad.loop = getvalue(string, 0);
                    }
                    if (i36 > 14) {
                        conto.wxz = getvalue(string, 0);
                    }
                    if (i36 > 15) {
                        mad.pcleared = getvalue(string, 0);
                    }
                    if (i36 > 16) {
                        mad.clear = getvalue(string, 0);
                    }
                    if (i36 > 17) {
                        mad.nlaps = getvalue(string, 0);
                    }
                    if (i36 > 18) {
                        mad.hitmag = (int) (getvalue(string, 0) / 100.0F * mad.cd.maxmag[mad.cn]);
                    }
                }
                lframe[i] = frame[i][i29];
            } else if (force[i] == 0) {
                lframe[i]++;
                force[i] = 1;
            }
        }
    }

    @Override
    public void run() {
        int i = 0;
        while (runon == 1) {
            if (!udpc[0].started) {
                udpc[0].spark();
                i = 1;
            } else {
                final Date date = new Date();
                if (i > delay / rate && date.getTime() - udpc[0].sendat > rate - 5) {
                    udpc[0].spark();
                    i = 1;
                }
            }
            if (delay > rate && i <= delay / rate && i >= 1 && i < 20) {
                final Date date = new Date();
                final long l = date.getTime() - udpc[i - 1].sendat;
                if (l >= rate - 5 && l < rate * 2) {
                    udpc[i].spark();
                    i++;
                }
            }
            if (diled == 10) {
                for (int i18 = 0; i18 < 20; i18++)
                    if (udpc[i18].started) {
                        final Date date = new Date();
                        final long l = date.getTime() - udpc[i18].sendat;
                        if (l > delay * 1.5 && l > rate) {
                            udpc[i18].stomp();
                        }
                    }
            }
            if (diledelay > 0) {
                diledelay--;
            }
            try {
                if (runner != null) {

                }
                Thread.sleep(5L);
            } catch (final InterruptedException interruptedexception) {

            }
        }
        int i19 = 0;
        int i20 = 0;
        while (runon == 4) {
            for (int i21 = 0; i21 < nplayers; i21++) {
                boolean bool = false;
                if (info[i21][0].length() > 16) {
                    final String string = new StringBuilder().append("").append(info[i21][0].charAt(15)).toString();
                    if (!string.equals("0")) {
                        bool = true;
                    }
                }
                if (!bool && out[i21] == 77) {
                    out[i21] = 0;
                }
                if (out[i21] < 76)
                    if (frame[i21][0] > 6) {
                        if (lcframe[i21] != frame[i21][0] && !bool) {
                            lcframe[i21] = frame[i21][0];
                            out[i21] = 0;
                        } else {
                            if (out[i21] < 70) {
                                out[i21] = 71;
                            }
                            out[i21]++;
                            if (bool) {
                                out[i21] = 77;
                            }
                            if (out[i21] == 76) {
                                info[i21][0] = "disco";
                                frame[i21][0] += 10;
                            }
                        }
                    } else {
                        out[i21]++;
                        if (out[i21] == 30) {
                            frame[i21][0] = 7;
                        }
                    }
            }
            if (i20 == 10) {
                final String string = new StringBuilder().append("3|").append(pgame).append("|alive|").toString();
                String string22 = "";
                if (i19 == 0) {
                    try {
                        dout.println(string);
                        string22 = din.readLine();
                        if (string22 == null) {
                            i19 = 1;
                        }
                    } catch (final Exception exception) {
                        i19 = 1;
                    }
                }
                if (i19 == 1) {
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
                        socket = new Socket(xtserver, xtservport);
                        din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        dout = new PrintWriter(socket.getOutputStream(), true);
                        dout.println(string);
                        string22 = din.readLine();
                        if (string22 != null) {
                            i19 = 0;
                        }
                    } catch (final Exception exception) {

                    }
                }
                if (i19 == 1) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (final Exception exception) {

                    }
                    i19 = 2;
                }
                i20 = 0;
            } else {
                i20++;
            }
            try {
                if (runner != null) {

                }
                Thread.sleep(1000L);
            } catch (final InterruptedException interruptedexception) {

            }
        }
        int i23 = 0;
        while (runon == 2) {
            int i24 = 0;
            for (int i25 = 0; i25 < 20; i25++)
                if (!udpc[i25].started) {
                    i24++;
                }
            if (i24 != 20) {
                i23++;
            }
            if (i23 == 400 || i24 == 20) {
                for (int i26 = 0; i26 < 20; i26++) {
                    udpc[i26].closeSocket();
                    udpc[i26] = null;
                }
                runon = 3;
            }
            try {
                if (runner != null) {

                }
                Thread.sleep(5L);
            } catch (final InterruptedException interruptedexception) {

            }
        }
        if (runon == 3) {
            System.gc();
            System.runFinalization();
            runon = 0;
            runner = null;
        }
        if (runon == 5) {
            for (int i27 = 0; i27 < nplayers + 2; i27++) {
                try {
                    usrv[i27].stopServe();
                    usrv[i27] = null;
                } catch (final Exception exception) {

                }
            }
            final String string = new StringBuilder().append("3|").append(pgame).append("|finish|").toString();
            try {
                dout.println(string);
                din.readLine();
                socket.close();
                socket = null;
                din.close();
                din = null;
                dout.close();
                dout = null;
            } catch (final Exception exception) {

            }
            System.gc();
            System.runFinalization();
            runon = 0;
            runner = null;
        }
    }

    void setinfo(final Mad mad, final ContO conto, final Control control, final int i, final float f, final boolean bool, final int i41) {
        info[i41][0] = "";
        if (control.left) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i42 = 0;
            strings[i42] = stringbuilder.append(strings[i42]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i43 = 0;
            strings[i43] = stringbuilder.append(strings[i43]).append("0").toString();
        }
        if (control.right) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i44 = 0;
            strings[i44] = stringbuilder.append(strings[i44]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i45 = 0;
            strings[i45] = stringbuilder.append(strings[i45]).append("0").toString();
        }
        if (control.up) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i46 = 0;
            strings[i46] = stringbuilder.append(strings[i46]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i47 = 0;
            strings[i47] = stringbuilder.append(strings[i47]).append("0").toString();
        }
        if (control.down) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i48 = 0;
            strings[i48] = stringbuilder.append(strings[i48]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i49 = 0;
            strings[i49] = stringbuilder.append(strings[i49]).append("0").toString();
        }
        if (control.handb) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i50 = 0;
            strings[i50] = stringbuilder.append(strings[i50]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i51 = 0;
            strings[i51] = stringbuilder.append(strings[i51]).append("0").toString();
        }
        if (mad.newcar) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i52 = 0;
            strings[i52] = stringbuilder.append(strings[i52]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i53 = 0;
            strings[i53] = stringbuilder.append(strings[i53]).append("0").toString();
        }
        if (mad.mtouch) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i54 = 0;
            strings[i54] = stringbuilder.append(strings[i54]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i55 = 0;
            strings[i55] = stringbuilder.append(strings[i55]).append("0").toString();
        }
        if (mad.wtouch) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i56 = 0;
            strings[i56] = stringbuilder.append(strings[i56]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i57 = 0;
            strings[i57] = stringbuilder.append(strings[i57]).append("0").toString();
        }
        if (mad.pushed) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i58 = 0;
            strings[i58] = stringbuilder.append(strings[i58]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i59 = 0;
            strings[i59] = stringbuilder.append(strings[i59]).append("0").toString();
        }
        if (mad.gtouch) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i60 = 0;
            strings[i60] = stringbuilder.append(strings[i60]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i61 = 0;
            strings[i61] = stringbuilder.append(strings[i61]).append("0").toString();
        }
        if (mad.pl) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i62 = 0;
            strings[i62] = stringbuilder.append(strings[i62]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i63 = 0;
            strings[i63] = stringbuilder.append(strings[i63]).append("0").toString();
        }
        if (mad.pr) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i64 = 0;
            strings[i64] = stringbuilder.append(strings[i64]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i65 = 0;
            strings[i65] = stringbuilder.append(strings[i65]).append("0").toString();
        }
        if (mad.pd) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i66 = 0;
            strings[i66] = stringbuilder.append(strings[i66]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i67 = 0;
            strings[i67] = stringbuilder.append(strings[i67]).append("0").toString();
        }
        if (mad.pu) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i68 = 0;
            strings[i68] = stringbuilder.append(strings[i68]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i69 = 0;
            strings[i69] = stringbuilder.append(strings[i69]).append("0").toString();
        }
        if (mad.dest) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i70 = 0;
            strings[i70] = stringbuilder.append(strings[i70]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i71 = 0;
            strings[i71] = stringbuilder.append(strings[i71]).append("0").toString();
        }
        if (bool) {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i72 = 0;
            strings[i72] = stringbuilder.append(strings[i72]).append("1").toString();
        } else {
            final StringBuilder stringbuilder = new StringBuilder();
            final String[] strings = info[i41];
            final int i73 = 0;
            strings[i73] = stringbuilder.append(strings[i73]).append("0").toString();
        }
        final StringBuilder stringbuilder = new StringBuilder();
        final String[] strings = info[i41];
        final int i74 = 0;
        strings[i74] = stringbuilder.append(strings[i74]).append(",").append(conto.x).append(",").append(conto.y).append(",").append(conto.z).append(",").append(conto.xz).append(",").append(conto.xy).append(",").append(conto.zy).append(",").append((int) (mad.speed
                * 100.0F)).append(",").append((int) (mad.power
                        * 100.0F)).append(",").append(mad.mxz).append(",").append(mad.pzy).append(",").append(mad.pxy).append(",").append(mad.txz).append(",").append(mad.loop).append(",").append(conto.wxz).append(",").append(mad.pcleared).append(",").append(mad.clear).append(",").append(mad.nlaps).append(",").append((int) (f
                                * 100.0F)).append(",").append(i).append(",").toString();
        while (info[i41][0].length() < 110) {
            final StringBuilder stringbuilder75 = new StringBuilder();
            final String[] strings76 = info[i41];
            final int i77 = 0;
            strings76[i77] = stringbuilder75.append(strings76[i77]).append("|").toString();
        }
        if (runon == 2) {
            mad.hitmag = mad.cd.maxmag[mad.cn] + 100;
        }
        frame[i41][0]++;
    }

    void UDPConnectLan(final String string, final int i, final int i7) {
        diledelay = 0;
        delay = 0;
        for (int i8 = 0; i8 < 5; i8++) {
            ldelays[i8] = 0;
        }
        diled = 0;
        go = false;
        freg = 0.0F;
        im = i7;
        nplayers = i;
        for (int i9 = 0; i9 < 7; i9++) {
            for (int i10 = 0; i10 < 3; i10++) {
                frame[i9][i10] = -1;
                info[i9][i10] = "";
            }
            isbot[i9] = false;
            lframe[i9] = 0;
            force[i9] = 0;
            lcframe[i9] = 0;
        }
        if (im != 0) {
            for (int i11 = 0; i11 < 20; i11++) {
                udpc[i11] = new udpOnline(this, string, 7060 + im, i11, porturn);
            }
            if (porturn == 0) {
                porturn = 20;
            } else {
                porturn = 0;
            }
            if (im >= nplayers) {
                frame[im][0] = 11111;
                info[im][0] = "watching";
                while (info[im][0].length() < 110) {
                    final StringBuilder stringbuilder = new StringBuilder();
                    final String[] strings = info[im];
                    final int i12 = 0;
                    strings[i12] = stringbuilder.append(strings[i12]).append("|").toString();
                }
                nplayers++;
                go = true;
            }
            runon = 1;
        } else {
            try {
                socket = new Socket(xtserver, xtservport);
                din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dout = new PrintWriter(socket.getOutputStream(), true);
            } catch (final Exception exception) {

            }
            runon = 4;
        }
        runner = new Thread(this);
        runner.start();
    }

    void UDPConnectOnline(final String string, final int i, final int i0, final int i1) {
        diledelay = 0;
        delay = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            ldelays[i2] = 0;
        }
        diled = 0;
        go = false;
        freg = 0.0F;
        im = i1;
        nplayers = i0;
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                frame[i3][i4] = -1;
                info[i3][i4] = "";
            }
            isbot[i3] = false;
            lframe[i3] = 0;
            force[i3] = 0;
            lcframe[i3] = 0;
        }
        for (int i5 = 0; i5 < 20; i5++) {
            udpc[i5] = new udpOnline(this, string, i + im, i5, porturn);
        }
        if (porturn == 0) {
            porturn = 20;
        } else {
            porturn = 0;
        }
        if (im >= nplayers) {
            frame[im][0] = 11111;
            info[im][0] = "watching";
            while (info[im][0].length() < 110) {
                final StringBuilder stringbuilder = new StringBuilder();
                final String[] strings = info[im];
                final int i6 = 0;
                strings[i6] = stringbuilder.append(strings[i6]).append("|").toString();
            }
            nplayers++;
            go = true;
        }
        runon = 1;
        runner = new Thread(this);
        runner.start();
    }

    void UDPLanServer(final int i, final String string, final int i13, final int i14) {
        xtserver = string;
        xtservport = i13;
        pgame = i14;
        for (int i15 = 0; i15 < 7; i15++) {
            gocnt[i15] = 3;
            out[i15] = 0;
            for (int i16 = 0; i16 < 3; i16++) {
                frame[i15][i16] = -1;
                info[i15][i16] = "";
            }
            lframe[i15] = 0;
            force[i15] = 0;
            lcframe[i15] = 0;
        }
        for (int i17 = 0; i17 < nplayers + 2; i17++) {
            usrv[i17] = new udpServe(this, i17 + 1);
        }
    }

    void UDPquit() {
        if (runon == 1) {
            runon = 2;
        }
        if (runon == 4) {
            runon = 5;
        }
    }
}
