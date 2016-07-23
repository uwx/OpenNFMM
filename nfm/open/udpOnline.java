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

	public udpOnline(final UDPMistro udpmistro, final String string, final int i, final int i_0_, final int i_1_) {
		um = udpmistro;
		gameport = i;
		nu = i_0_;
		try {
			dSocket = new DatagramSocket(7010 + i_1_ + nu);
			errd = false;
			IPAddress = InetAddress.getByName(string);
		} catch (final Exception exception) {
			System.out.println(
					"Error preparing for UDP Connection: " + exception);
		}
	}

	public void closeSocket() {
		try {
			dSocket.close();
		} catch (final Exception exception) {
			/* empty */
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
		String string_18_ = "";
		try {
			int i_19_ = 0;
			int i_20_ = 0;
			int i_21_ = 0;
			String string_22_;
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
			string_18_ = string_23_;
		} catch (final Exception exception) {
			/* empty */
		}
		return string_18_;
	}

	private int getvalue(final String string, final int i) {
		int i_12_ = -1;
		try {
			int i_13_ = 0;
			int i_14_ = 0;
			int i_15_ = 0;
			String string_16_;
			String string_17_ = "";
			for (/**/; i_13_ < string.length() && i_15_ != 2; i_13_++) {
				string_16_ = "" + string.charAt(i_13_);
				if (string_16_.equals("|")) {
					i_14_++;
					if (i_15_ == 1 || i_14_ > i)
						i_15_ = 2;
				} else if (i_14_ == i) {
					string_17_ = string_17_ + string_16_;
					i_15_ = 1;
				}
			}
			if (string_17_.equals(""))
				string_17_ = "-1";
			i_12_ = Integer.valueOf(string_17_);
		} catch (final Exception exception) {
			/* empty */
		}
		return i_12_;
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
			string = "" + sendat;
			string = string.substring(string.length() - 3, string.length());
			um.sendcheck = string;
			um.diledelay = 100;
		}
		try {
			final byte[] is = new byte[4];
			final DatagramPacket datagrampacket = new DatagramPacket(is, is.length, IPAddress, gameport);
			final String string_2_ = "" + string + "|" + um.im + "|" +
					um.frame[um.im][0] + "|" + um.info[um.im][0] + "|";
			final byte[] is_3_ = string_2_.getBytes();
			datagrampacket.setData(is_3_);
			dSocket.send(datagrampacket);
			for (int i = 0; i < um.nplayers - 1; i++) {
				dSocket.receive(datagrampacket);
				final String string_4_ = new String(datagrampacket.getData());
				if ((nu == 0 || !um.go) && i == 0) {
					string = getSvalue(string_4_, 0);
					if (!um.go && string.equals("1111111"))
						um.go = true;
				}
				final int i_5_ = getvalue(string_4_, 1);
				if (i_5_ >= 0 && i_5_ < um.nplayers) {
					final int i_6_ = getvalue(string_4_, 2);
					int i_7_ = 0;
					for (int i_8_ = 0; i_8_ < 3; i_8_++)
						if (i_6_ != um.frame[i_5_][i_8_])
							i_7_++;
					if (i_7_ == 3)
						for (int i_9_ = 0; i_9_ < 3; i_9_++)
							if (i_6_ > um.frame[i_5_][i_9_]) {
								for (int i_10_ = 2; i_10_ >= i_9_ + 1; i_10_--) {
									um.frame[i_5_][i_10_] = um.frame[i_5_][i_10_ - 1];
									um.info[i_5_][i_10_] = um.info[i_5_][i_10_ - 1];
								}
								um.frame[i_5_][i_9_] = i_6_;
								um.info[i_5_][i_9_] = getSvalue(string_4_, 3);
								i_9_ = 3;
							}
				}
			}
			if (nu == 0 && um.diledelay != 0 && um.sendcheck.equals(string)) {
				date = new Date();
				System.arraycopy(um.ldelays, 0, um.ldelays, 1, 4);
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
			} catch (final Exception exception_11_) {
				/* empty */
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
				/* empty */
			}
		try {
			con = new Thread(this);
			con.start();
		} catch (final Exception exception) {
			/* empty */
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
