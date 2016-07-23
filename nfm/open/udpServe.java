package nfm.open;
/* nfm.open.udpServe - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class udpServe implements Runnable {
	private DatagramSocket dSocket;
	private int im = 0;
	private final int[] lsframe = { -1, -1, -1, -1, -1, -1, -1, -1 };
	private int mport = 7060;
	private Thread servo;
	private final UDPMistro um;

	public udpServe(final UDPMistro udpmistro, final int i) {
		um = udpmistro;
		im = i;
		mport = 7060 + im;
		servo = new Thread(this);
		servo.start();
	}

	private String getSvalue(final String string, final int i) {
		String string_24_ = "";
		try {
			int i_25_ = 0;
			int i_26_ = 0;
			int i_27_ = 0;
			String string_28_ = "";
			String string_29_ = "";
			for (/**/; i_25_ < string.length() && i_27_ != 2; i_25_++) {
				string_28_ = "" + string.charAt(i_25_);
				if (string_28_.equals("|")) {
					i_26_++;
					if (i_27_ == 1 || i_26_ > i)
						i_27_ = 2;
				} else if (i_26_ == i) {
					string_29_ = string_29_ + string_28_;
					i_27_ = 1;
				}
			}
			string_24_ = string_29_;
		} catch (final Exception exception) {
			/* empty */
		}
		return string_24_;
	}

	private int getvalue(final String string, final int i) {
		int i_18_ = -1;
		try {
			int i_19_ = 0;
			int i_20_ = 0;
			int i_21_ = 0;
			String string_22_ = "";
			String string_23_ = "";
			for (/**/; i_19_ < string.length() && i_21_ != 2; i_19_++) {
				string_22_ = "" + string.charAt(i_19_);
				if (string_22_.equals("|")) {
					i_20_++;
					if (i_21_ == 1 || i_20_ > i)
						i_21_ = 2;
				} else if (i_20_ == i) {
					string_23_ = string_23_ + string_22_;
					i_21_ = 1;
				}
			}
			if (string_23_.equals(""))
				string_23_ = "-1";
			i_18_ = Integer.valueOf(string_23_);
		} catch (final Exception exception) {
			/* empty */
		}
		return i_18_;
	}

	@Override
	public void run() {
		try {
			dSocket = new DatagramSocket(mport);
			final byte[] is = new byte[128];
			while (true) {
				final DatagramPacket datagrampacket = new DatagramPacket(is, is.length);
				dSocket.receive(datagrampacket);
				final String string = new String(datagrampacket.getData());
				String string_0_ = getSvalue(string, 0);
				final int i = getvalue(string, 1);
				if (i == im && im < um.nplayers && um.out[i] != 76) {
					final int i_1_ = getvalue(string, 2);
					int i_2_ = 0;
					for (int i_3_ = 0; i_3_ < 3; i_3_++)
						if (i_1_ != um.frame[i][i_3_])
							i_2_++;
					if (i_2_ == 3)
						for (int i_4_ = 0; i_4_ < 3; i_4_++)
							if (i_1_ > um.frame[i][i_4_]) {
								for (int i_5_ = 2; i_5_ >= i_4_ + 1; i_5_--) {
									um.frame[i][i_5_] = um.frame[i][i_5_ - 1];
									um.info[i][i_5_] = um.info[i][i_5_ - 1];
								}
								um.frame[i][i_4_] = i_1_;
								um.info[i][i_4_] = getSvalue(string, 3);
								i_4_ = 3;
							}
					if (um.gocnt[i] != 0) {
						int i_6_ = 0;
						for (int i_7_ = 0; i_7_ < um.nplayers; i_7_++)
							if (um.frame[i_7_][0] >= 0)
								i_6_++;
						if (i_6_ == um.nplayers) {
							string_0_ = "1111111";
							um.gocnt[i]--;
						}
					}
					if (!um.go) {
						int i_8_ = 0;
						for (int i_9_ = 0; i_9_ < um.nplayers; i_9_++)
							if (um.frame[i_9_][0] >= 0)
								i_8_++;
						if (i_8_ == um.nplayers)
							um.gocnt[0]--;
						if (um.gocnt[0] <= 1)
							um.go = true;
					}
				}
				final InetAddress inetaddress = datagrampacket.getAddress();
				final int i_10_ = datagrampacket.getPort();
				for (int i_11_ = 0; i_11_ < um.nplayers; i_11_++)
					if (i_11_ != im) {
						int i_12_ = -1;
						for (int i_13_ = 0; i_13_ < 3; i_13_++)
							if (um.frame[i_11_][i_13_] == lsframe[i_11_] + 1)
								i_12_ = i_13_;
						if (i_12_ == -1)
							for (int i_14_ = 0; i_14_ < 3; i_14_++)
								if (um.frame[i_11_][i_14_] > lsframe[i_11_])
									i_12_ = i_14_;
						if (i_12_ == -1)
							i_12_ = 0;
						lsframe[i_11_] = um.frame[i_11_][i_12_];
						final String string_15_ = "" + string_0_ + "|" +
								i_11_ + "|" + um.frame[i_11_][i_12_] + "|" +
								um.info[i_11_][i_12_] + "|";
						final byte[] is_16_ = string_15_.getBytes();
						final DatagramPacket datagrampacket_17_ = new DatagramPacket(is_16_, is_16_.length, inetaddress,
								i_10_);
						dSocket.send(datagrampacket_17_);
					}
			}
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public void stopServe() {
		try {
			dSocket.close();
			dSocket = null;
		} catch (final Exception exception) {
			/* empty */
		}
		if (servo != null) {
			servo.stop();
			servo = null;
		}
	}
}
