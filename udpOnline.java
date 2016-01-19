
/* udpOnline - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class udpOnline implements Runnable {
    private Thread con;
    private DatagramSocket dSocket;
    private boolean errd = false;
    int gameport = 7001;
    private InetAddress IPAddress;
    int nu = 0;
    long sendat = 0L;
    boolean started = false;
    private UDPMistro um;

    public udpOnline(final UDPMistro udpmistro, final String string, final int i, final int i0, final int i1) {
        um = udpmistro;
        gameport = i;
        nu = i0;
        try {
            dSocket = new DatagramSocket(7010 + i1 + nu);
            errd = false;
            IPAddress = InetAddress.getByName(string);
        } catch (final Exception exception) {
            System.out.println(
                    new StringBuilder().append("Error preparing for UDP Connection: ").append(exception).toString());
        }
    }

    public void closeSocket() {
        try {
            dSocket.close();
        } catch (final Exception exception) {
            
        }
        dSocket = null;
        errd = true;
        if (con != null) {
            con.stop();
            con = null;
        }
        started = false;
    }

    public String getSvalue(final String string, final int i) {
        String string18 = "";
        try {
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            String string22 = "";
            String string23 = "";
            for (/**/; i19 < string.length() && i21 != 2; i19++) {
                string22 = new StringBuilder().append("").append(string.charAt(i19)).toString();
                if (string22.equals("|")) {
                    i20++;
                    if (i21 == 1 || i20 > i)
                        i21 = 2;
                } else if (i20 == i) {
                    string23 = new StringBuilder().append(string23).append(string22).toString();
                    i21 = 1;
                }
            }
            string18 = string23;
        } catch (final Exception exception) {
            
        }
        return string18;
    }

    public int getvalue(final String string, final int i) {
        int i12 = -1;
        try {
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            String string16 = "";
            String string17 = "";
            for (/**/; i13 < string.length() && i15 != 2; i13++) {
                string16 = new StringBuilder().append("").append(string.charAt(i13)).toString();
                if (string16.equals("|")) {
                    i14++;
                    if (i15 == 1 || i14 > i)
                        i15 = 2;
                } else if (i14 == i) {
                    string17 = new StringBuilder().append(string17).append(string16).toString();
                    i15 = 1;
                }
            }
            if (string17.equals(""))
                string17 = "-1";
            i12 = Integer.valueOf(string17).intValue();
        } catch (final Exception exception) {
            
        }
        return i12;
    }

    @Override
    public void run() {
        started = true;
        Date date = new Date();
        sendat = date.getTime();
        String string = "";
        if (!um.go)
            string = "MAGNITUDE";
        if (nu == 0 && um.diledelay == 0) {
            um.sendat = sendat;
            string = new StringBuilder().append("").append(sendat).toString();
            string = string.substring(string.length() - 3, string.length());
            um.sendcheck = string;
            um.diledelay = 100;
        }
        try {
            final byte[] is = new byte[4];
            final DatagramPacket datagrampacket = new DatagramPacket(is, is.length, IPAddress, gameport);
            final String string2 = new StringBuilder().append("").append(string).append("|").append(um.im).append("|")
                    .append(um.frame[um.im][0]).append("|").append(um.info[um.im][0]).append("|").toString();
            final byte[] is3 = string2.getBytes();
            datagrampacket.setData(is3);
            dSocket.send(datagrampacket);
            for (int i = 0; i < um.nplayers - 1; i++) {
                dSocket.receive(datagrampacket);
                final String string4 = new String(datagrampacket.getData());
                if ((nu == 0 || !um.go) && i == 0) {
                    string = getSvalue(string4, 0);
                    if (!um.go && string.equals("1111111"))
                        um.go = true;
                }
                final int i5 = getvalue(string4, 1);
                if (i5 >= 0 && i5 < um.nplayers) {
                    final int i6 = getvalue(string4, 2);
                    int i7 = 0;
                    for (int i8 = 0; i8 < 3; i8++)
                        if (i6 != um.frame[i5][i8])
                            i7++;
                    if (i7 == 3)
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
            if (nu == 0 && um.diledelay != 0 && um.sendcheck.equals(string)) {
                date = new Date();
                for (int i = 4; i > 0; i--)
                    um.ldelays[i] = um.ldelays[i - 1];
                um.ldelays[0] = (int) (date.getTime() - um.sendat);
                um.delay = 0;
                for (int i = 0; i < 5; i++)
                    if (um.ldelays[i] != 0 && (um.delay == 0 || um.ldelays[i] < um.delay))
                        um.delay = um.ldelays[i];
                um.diledelay = 0;
                if (um.diled != 10)
                    um.diled++;
            }
        } catch (final Exception exception) {
            try {
                dSocket.close();
            } catch (final Exception exception11) {
                
            }
            dSocket = null;
            errd = true;
        }
        started = false;
        con = null;
    }

    public void spark() {
        if (errd)
            try {
                dSocket = new DatagramSocket(7020 + nu);
                errd = false;
            } catch (final Exception exception) {
                
            }
        try {
            con = new Thread(this);
            con.start();
        } catch (final Exception exception) {
            
        }
    }

    public void stomp() {
        if (con != null) {
            con.stop();
            con = null;
        }
        started = false;
    }
}
