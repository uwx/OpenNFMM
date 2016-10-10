package nfm.open;

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
    final int[] ldelays = new int[5];
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

    final String[][] info = new String[14][3];
    final int[][] frame = new int[14][3];
    final int[] lframe = new int[8];
    final int[] force = new int[8];
    final int[] lcframe = new int[8];
    final boolean[] isbot = new boolean[8];
    final int[] gocnt = new int[8];
    final int[] out = new int[8];

    private int getncoms(final String string) {
        int i = 0;
        int i89 = 0;
        String string90;
        for (/**/; i89 < string.length(); i89++) {
            string90 = "" + string.charAt(i89);
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
            String string87;
            String string88 = "";
            for (/**/; i84 < string.length() && i86 != 2; i84++) {
                string87 = "" + string.charAt(i84);
                if (string87.equals(",")) {
                    i85++;
                    if (i86 == 1 || i85 > i) {
                        i86 = 2;
                    }
                } else if (i85 == i) {
                    string88 = "" + string88 + string87;
                    i86 = 1;
                }
            }
            string83 = string88;
        } catch (final Exception ignored) {

        }
        return string83;
    }

    private int getvalue(final String string, final int i) {
        int i78 = -1;
        try {
            int i79 = 0;
            int i80 = 0;
            String string81;
            String string82 = "";
            for (/**/; wx < string.length() && i80 != 2; wx++) {
                string81 = "" + string.charAt(wx);
                if (string81.equals(",")) {
                    i79++;
                    if (i80 == 1 || i79 > i) {
                        i80 = 2;
                    }
                } else if (i79 == i) {
                    string82 = "" + string82 + string81;
                    i80 = 1;
                }
            }
            if (string82.equals("")) {
                string82 = "-1";
            }
            i78 = Integer.parseInt(string82);
        } catch (final Exception ignored) {

        }
        return i78;
    }

    void readContOinfo(final ContO conto, final int i) {
        if (go && force[i] == 1 && !isbot[i]) {
            int i37 = -2;
            if (i37 == -2) {
                for (int i38 = 0; i38 < 3; i38++) {
                    if (frame[i][i38] == lframe[i] + 1) {
                        i37 = -1;
                    }
                }
            }
            if (i37 == -1) {
                for (int i39 = 0; i39 < 3; i39++) {
                    if (frame[i][i39] == lframe[i]) {
                        i37 = i39;
                    }
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
                for (int i30 = 0; i30 < 3; i30++) {
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
            }
            if (i29 == -1) {
                int i31 = 0;
                for (int i32 = 0; i32 < 3; i32++) {
                    if (frame[i][i32] > lframe[i] + 1) {
                        i31++;
                    }
                }
                if (i31 == 3) {
                    i29 = 2;
                }
            }
            if (i29 == -1 && force[i] == 1) {
                for (int i33 = 0; i33 < 3; i33++) {
                    if (frame[i][i33] >= lframe[i]) {
                        i29 = i33;
                    }
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
                    String string35;
                    string35 = "" + string34.charAt(0);
                    control.left = !string35.equals("0");
                    string35 = "" + string34.charAt(1);
                    control.right = !string35.equals("0");
                    string35 = "" + string34.charAt(2);
                    control.up = !string35.equals("0");
                    string35 = "" + string34.charAt(3);
                    control.down = !string35.equals("0");
                    string35 = "" + string34.charAt(4);
                    control.handb = !string35.equals("0");
                    string35 = "" + string34.charAt(5);
                    mad.newcar = !string35.equals("0");
                    string35 = "" + string34.charAt(6);
                    mad.mtouch = !string35.equals("0");
                    string35 = "" + string34.charAt(7);
                    mad.wtouch = !string35.equals("0");
                    string35 = "" + string34.charAt(8);
                    mad.pushed = !string35.equals("0");
                    string35 = "" + string34.charAt(9);
                    mad.gtouch = !string35.equals("0");
                    string35 = "" + string34.charAt(10);
                    mad.pl = !string35.equals("0");
                    string35 = "" + string34.charAt(11);
                    mad.pr = !string35.equals("0");
                    string35 = "" + string34.charAt(12);
                    mad.pd = !string35.equals("0");
                    string35 = "" + string34.charAt(13);
                    mad.pu = !string35.equals("0");
                    string35 = "" + string34.charAt(14);
                    mad.dest = !string35.equals("0");
                } else if (string34.equals("disco")) {
                    is[i] = 3;
                    mad.hitmag = mad.stat.maxmag + 100;
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
                        mad.hitmag = (int) (getvalue(string, 0) / 100.0F * mad.stat.maxmag);
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
                for (int i18 = 0; i18 < 20; i18++) {
                    if (udpc[i18].started) {
                        final Date date = new Date();
                        final long l = date.getTime() - udpc[i18].sendat;
                        if (l > delay * 1.5 && l > rate) {
                            udpc[i18].stomp();
                        }
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
            } catch (final InterruptedException ignored) {

            }
        }
        int i19 = 0;
        int i20 = 0;
        while (runon == 4) {
            for (int i21 = 0; i21 < nplayers; i21++) {
                boolean bool = false;
                if (info[i21][0].length() > 16) {
                    final String string = "" + info[i21][0].charAt(15);
                    if (!string.equals("0")) {
                        bool = true;
                    }
                }
                if (!bool && out[i21] == 77) {
                    out[i21] = 0;
                }
                if (out[i21] < 76) {
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
            }
            if (i20 == 10) {
                final String string = "3|" + pgame + "|alive|";
                String string22;
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
                    } catch (final Exception ignored) {

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
                    } catch (final Exception ignored) {

                    }
                }
                if (i19 == 1) {
                    try {
                        socket.close();
                        socket = null;
                    } catch (final Exception ignored) {

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
            } catch (final InterruptedException ignored) {

            }
        }
        int i23 = 0;
        while (runon == 2) {
            int i24 = 0;
            for (int i25 = 0; i25 < 20; i25++) {
                if (!udpc[i25].started) {
                    i24++;
                }
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
            } catch (final InterruptedException ignored) {

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
                } catch (final Exception ignored) {

                }
            }
            final String string = "3|" + pgame + "|finish|";
            try {
                dout.println(string);
                din.readLine();
                socket.close();
                socket = null;
                din.close();
                din = null;
                dout.close();
                dout = null;
            } catch (final Exception ignored) {

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
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (control.right) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (control.up) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (control.down) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (control.handb) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.newcar) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.mtouch) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.wtouch) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.pushed) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.gtouch) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.pl) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.pr) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.pd) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.pu) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (mad.dest) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        if (bool) {
            info[i41][0] = info[i41][0] + "1";
        } else {
            info[i41][0] = info[i41][0] + "0";
        }
        info[i41][0] = info[i41][0] + "," + conto.x + "," + conto.y + "," + conto.z + "," + conto.xz + "," + conto.xy + "," + conto.zy + "," + (int) (mad.speed * 100.0F) + "," + (int) (mad.power * 100.0F) + "," + mad.mxz + "," + mad.pzy + "," + mad.pxy + "," + mad.txz + "," + mad.loop + "," + conto.wxz + "," + mad.pcleared + "," + mad.clear + "," + mad.nlaps + "," + (int) (f * 100.0F) + "," + i + ",";
        while (info[i41][0].length() < 110) {
            info[i41][0] = info[i41][0] + "|";
        }
        if (runon == 2) {
            mad.hitmag = mad.stat.maxmag + 100;
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
                    info[im][0] = info[im][0] + "|";
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
            } catch (final Exception ignored) {

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
                info[im][0] = "" + info[im][0] + "|";
            }
            nplayers++;
            go = true;
        }
        runon = 1;
        runner = new Thread(this);
        runner.start();
    }

    void UDPLanServer(final String string, final int i13, final int i14) {
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
