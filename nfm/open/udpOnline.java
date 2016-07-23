package nfm.open;
/* nfm.open.udpOnline - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

class udpOnline implements Runnable {
    private Thread con;
    private DatagramSocket dSocket;
    private boolean errd = false;
    private int gameport = 7001;
    private InetAddress IPAddress;
    private int nu = 0;
    long sendat = 0L;
    boolean started = false;
    private final UDPMistro um;

    udpOnline(final UDPMistro udpmistro, final String string, final int i, final int i0, final int i1) {
        um = udpmistro;
        gameport = i;
        nu = i0;
        try {
            dSocket = new DatagramSocket(7010 + i1 + nu);
            errd = false;
            IPAddress = InetAddress.getByName(string);
        } catch (final Exception exception) {
            System.out.println("Error preparing for UDP Connection: " + exception);
        }
    }

    void closeSocket() {
        try {
            dSocket.close();
        } catch (final Exception ignored) {

        }
        dSocket = null;
        errd = true;
        if (con != null) {
            con.stop();
            con = null;
        }
        started = false;
    }

    private String getSvalue(final String string, final int i) {
        String string18 = "";
        try {
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            String string22;
            String string23 = "";
            for (/**/; i19 < string.length() && i21 != 2; i19++) {
                string22 = "" + string.charAt(i19);
                if (string22.equals("|")) {
                    i20++;
                    if (i21 == 1 || i20 > i) {
                        i21 = 2;
                    }
                } else if (i20 == i) {
                    string23 = "" + string23 + string22;
                    i21 = 1;
                }
            }
            string18 = string23;
        } catch (final Exception ignored) {

        }
        return string18;
    }

    private int getvalue(final String string, final int i) {
        int i12 = -1;
        try {
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            String string16;
            String string17 = "";
            for (/**/; i13 < string.length() && i15 != 2; i13++) {
                string16 = "" + string.charAt(i13);
                if (string16.equals("|")) {
                    i14++;
                    if (i15 == 1 || i14 > i) {
                        i15 = 2;
                    }
                } else if (i14 == i) {
                    string17 = "" + string17 + string16;
                    i15 = 1;
                }
            }
            if (string17.equals("")) {
                string17 = "-1";
            }
            i12 = Integer.parseInt(string17);
        } catch (final Exception ignored) {

        }
        return i12;
    }

    @Override
    public void run() {
        started = true;
        Date date = new Date();
        sendat = date.getTime();
        String string = "";
        if (!um.go) {
            string = "MAGNITUDE";
        }
        if (nu == 0 && um.diledelay == 0) {
            um.sendat = sendat;
            string = "" + sendat;
            string = string.substring(string.length() - 3, string.length());
            um.sendcheck = string;
            um.diledelay = 100;
        }
        try {
            final byte[] is = new byte[4];
            final DatagramPacket datagrampacket = new DatagramPacket(is, is.length, IPAddress, gameport);
            final String string2 = "" + string + "|" + um.im + "|" + um.frame[um.im][0] + "|" + um.info[um.im][0] + "|";
            final byte[] is3 = string2.getBytes();
            datagrampacket.setData(is3);
            dSocket.send(datagrampacket);
            for (int i = 0; i < um.nplayers - 1; i++) {
                dSocket.receive(datagrampacket);
                final String string4 = new String(datagrampacket.getData());
                if ((nu == 0 || !um.go) && i == 0) {
                    string = getSvalue(string4, 0);
                    if (!um.go && string.equals("1111111")) {
                        um.go = true;
                    }
                }
                final int i5 = getvalue(string4, 1);
                if (i5 >= 0 && i5 < um.nplayers) {
                    final int i6 = getvalue(string4, 2);
                    int i7 = 0;
                    for (int i8 = 0; i8 < 3; i8++)
                        if (i6 != um.frame[i5][i8]) {
                            i7++;
                        }
                    if (i7 == 3) {
                        for (int i9 = 0; i9 < 3; i9++)
                            if (i6 > um.frame[i5][i9]) {
                                for (int i10 = 2; i10 >= i9 + 1; i10--) {
                                    um.frame[i5][i10] = um.frame[i5][i10 - 1];
                                    um.info[i5][i10] = um.info[i5][i10 - 1];
                                }
                                um.frame[i5][i9] = i6;
                                um.info[i5][i9] = getSvalue(string4, 3);
                                i9 = 3;
                            }
                    }
                }
            }
            if (nu == 0 && um.diledelay != 0 && um.sendcheck.equals(string)) {
                date = new Date();
                System.arraycopy(um.ldelays, 0, um.ldelays, 1, 4);
                um.ldelays[0] = (int) (date.getTime() - um.sendat);
                um.delay = 0;
                for (int i = 0; i < 5; i++)
                    if (um.ldelays[i] != 0 && (um.delay == 0 || um.ldelays[i] < um.delay)) {
                        um.delay = um.ldelays[i];
                    }
                um.diledelay = 0;
                if (um.diled != 10) {
                    um.diled++;
                }
            }
        } catch (final Exception exception) {
            try {
                dSocket.close();
            } catch (final Exception ignored) {

            }
            dSocket = null;
            errd = true;
        }
        started = false;
        con = null;
    }

    void spark() {
        if (errd) {
            try {
                dSocket = new DatagramSocket(7020 + nu);
                errd = false;
            } catch (final Exception ignored) {

            }
        }
        try {
            con = new Thread(this);
            con.start();
        } catch (final Exception ignored) {

        }
    }

    void stomp() {
        if (con != null) {
            con.stop();
            con = null;
        }
        started = false;
    }
}
