
/* udpServe - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class udpServe implements Runnable {
    private DatagramSocket dSocket;
    int im = 0;
    int[] lsframe = {
            -1, -1, -1, -1, -1, -1, -1, -1
    };
    int mport = 7060;
    Thread servo;
    private UDPMistro um;

    public udpServe(final UDPMistro udpmistro, final int i) {
        um = udpmistro;
        im = i;
        mport = 7060 + im;
        servo = new Thread(this);
        servo.start();
    }

    private String getSvalue(final String string, final int i) {
        String string24 = "";
        try {
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            String string28 = "";
            String string29 = "";
            for (/**/; i25 < string.length() && i27 != 2; i25++) {
                string28 = new StringBuilder().append("").append(string.charAt(i25)).toString();
                if (string28.equals("|")) {
                    i26++;
                    if (i27 == 1 || i26 > i)
                        i27 = 2;
                } else if (i26 == i) {
                    string29 = new StringBuilder().append(string29).append(string28).toString();
                    i27 = 1;
                }
            }
            string24 = string29;
        } catch (final Exception exception) {
            
        }
        return string24;
    }

    private int getvalue(final String string, final int i) {
        int i18 = -1;
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
            if (string23.equals(""))
                string23 = "-1";
            i18 = Integer.valueOf(string23).intValue();
        } catch (final Exception exception) {
            
        }
        return i18;
    }

    @Override
    public void run() {
        try {
            dSocket = new DatagramSocket(mport);
            final byte[] is = new byte[128];
            for (;;) {
                final DatagramPacket datagrampacket = new DatagramPacket(is, is.length);
                dSocket.receive(datagrampacket);
                final String string = new String(datagrampacket.getData());
                String string0 = getSvalue(string, 0);
                final int i = getvalue(string, 1);
                if (i == im && im < um.nplayers && um.out[i] != 76) {
                    final int i1 = getvalue(string, 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < 3; i3++)
                        if (i1 != um.frame[i][i3])
                            i2++;
                    if (i2 == 3)
                        for (int i4 = 0; i4 < 3; i4++)
                            if (i1 > um.frame[i][i4]) {
                                for (int i5 = 2; i5 >= i4 + 1; i5--) {
                                    um.frame[i][i5] = um.frame[i][i5 - 1];
                                    um.info[i][i5] = um.info[i][i5 - 1];
                                }
                                um.frame[i][i4] = i1;
                                um.info[i][i4] = getSvalue(string, 3);
                                i4 = 3;
                            }
                    if (um.gocnt[i] != 0) {
                        int i6 = 0;
                        for (int i7 = 0; i7 < um.nplayers; i7++)
                            if (um.frame[i7][0] >= 0)
                                i6++;
                        if (i6 == um.nplayers) {
                            string0 = "1111111";
                            um.gocnt[i]--;
                        }
                    }
                    if (!um.go) {
                        int i8 = 0;
                        for (int i9 = 0; i9 < um.nplayers; i9++)
                            if (um.frame[i9][0] >= 0)
                                i8++;
                        if (i8 == um.nplayers)
                            um.gocnt[0]--;
                        if (um.gocnt[0] <= 1)
                            um.go = true;
                    }
                }
                final InetAddress inetaddress = datagrampacket.getAddress();
                final int i10 = datagrampacket.getPort();
                for (int i11 = 0; i11 < um.nplayers; i11++)
                    if (i11 != im) {
                        int i12 = -1;
                        for (int i13 = 0; i13 < 3; i13++)
                            if (um.frame[i11][i13] == lsframe[i11] + 1)
                                i12 = i13;
                        if (i12 == -1)
                            for (int i14 = 0; i14 < 3; i14++)
                                if (um.frame[i11][i14] > lsframe[i11])
                                    i12 = i14;
                        if (i12 == -1)
                            i12 = 0;
                        lsframe[i11] = um.frame[i11][i12];
                        final String string15 = new StringBuilder().append("").append(string0).append("|").append(i11)
                                .append("|").append(um.frame[i11][i12]).append("|").append(um.info[i11][i12])
                                .append("|").toString();
                        final byte[] is16 = string15.getBytes();
                        final DatagramPacket datagrampacket17 = new DatagramPacket(is16, is16.length, inetaddress, i10);
                        dSocket.send(datagrampacket17);
                    }
            }
        } catch (final Exception exception) {
            
        }
    }

    public void stopServe() {
        try {
            dSocket.close();
            dSocket = null;
        } catch (final Exception exception) {
            
        }
        if (servo != null) {
            servo.stop();
            servo = null;
        }
    }
}
