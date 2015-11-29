
/* UDPMistro - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class UDPMistro implements Runnable {
	int delay = 0;
	int diled = 0;
	int diledelay = 0;
	BufferedReader din;
	PrintWriter dout;
	int[] force = new int[7];
	int[][] frame = new int[10][3];
	float freg = 0.0F;
	boolean go = false;
	int[] gocnt = new int[7];
	int im = 0;
	String[][] info = new String[10][3];
	boolean[] isbot = new boolean[7];
	int[] lcframe = new int[7];
	int[] ldelays = new int[5];
	int[] lframe = new int[7];
	int nplayers = 0;
	int[] out = new int[7];
	int pgame = 0;
	int porturn = 0;
	int rate = 30;
	Thread runner;
	int runon = 0;
	long sendat = 0L;
	String sendcheck = Messages.getString("UDPMistro.0"); //$NON-NLS-1$
	Socket socket;
	udpOnline[] udpc = new udpOnline[20];
	udpServe[] usrv = new udpServe[9];
	int wx = 0;
	String xtserver = Messages.getString("UDPMistro.1"); //$NON-NLS-1$
	int xtservport = 0;

	public int getncoms(final String string) {
		int i = 0;
		int i_89_ = 0;
		String string_90_ = Messages.getString("UDPMistro.2"); //$NON-NLS-1$
		for (/**/; i_89_ < string.length(); i_89_++) {
			string_90_ = new StringBuilder().append(Messages.getString("UDPMistro.3")).append(string.charAt(i_89_)).toString(); //$NON-NLS-1$
			if (string_90_.equals(Messages.getString("UDPMistro.4"))) //$NON-NLS-1$
				i++;
		}
		return i;
	}

	public String getSvalue(final String string, final int i) {
		String string_83_ = Messages.getString("UDPMistro.5"); //$NON-NLS-1$
		try {
			int i_84_ = 0;
			int i_85_ = 0;
			int i_86_ = 0;
			String string_87_ = Messages.getString("UDPMistro.6"); //$NON-NLS-1$
			String string_88_ = Messages.getString("UDPMistro.7"); //$NON-NLS-1$
			for (/**/; i_84_ < string.length() && i_86_ != 2; i_84_++) {
				string_87_ = new StringBuilder().append(Messages.getString("UDPMistro.8")).append(string.charAt(i_84_)).toString(); //$NON-NLS-1$
				if (string_87_.equals(Messages.getString("UDPMistro.9"))) { //$NON-NLS-1$
					i_85_++;
					if (i_86_ == 1 || i_85_ > i)
						i_86_ = 2;
				} else if (i_85_ == i) {
					string_88_ = new StringBuilder().append(string_88_).append(string_87_).toString();
					i_86_ = 1;
				}
			}
			string_83_ = string_88_;
		} catch (final Exception exception) {
			/* empty */
		}
		return string_83_;
	}

	public int getvalue(final String string, final int i) {
		int i_78_ = -1;
		try {
			int i_79_ = 0;
			int i_80_ = 0;
			String string_81_ = Messages.getString("UDPMistro.10"); //$NON-NLS-1$
			String string_82_ = Messages.getString("UDPMistro.11"); //$NON-NLS-1$
			for (/**/; wx < string.length() && i_80_ != 2; wx++) {
				string_81_ = new StringBuilder().append(Messages.getString("UDPMistro.12")).append(string.charAt(wx)).toString(); //$NON-NLS-1$
				if (string_81_.equals(Messages.getString("UDPMistro.13"))) { //$NON-NLS-1$
					i_79_++;
					if (i_80_ == 1 || i_79_ > i)
						i_80_ = 2;
				} else if (i_79_ == i) {
					string_82_ = new StringBuilder().append(string_82_).append(string_81_).toString();
					i_80_ = 1;
				}
			}
			if (string_82_.equals(Messages.getString("UDPMistro.14"))) //$NON-NLS-1$
				string_82_ = Messages.getString("UDPMistro.15"); //$NON-NLS-1$
			i_78_ = Integer.valueOf(string_82_).intValue();
		} catch (final Exception exception) {
			/* empty */
		}
		return i_78_;
	}

	public void readContOinfo(final ContO conto, final int i) {
		if (go && force[i] == 1 && !isbot[i]) {
			int i_37_ = -2;
			if (i_37_ == -2)
				for (int i_38_ = 0; i_38_ < 3; i_38_++)
					if (frame[i][i_38_] == lframe[i] + 1)
						i_37_ = -1;
			if (i_37_ == -1)
				for (int i_39_ = 0; i_39_ < 3; i_39_++)
					if (frame[i][i_39_] == lframe[i])
						i_37_ = i_39_;
			if (i_37_ > 0) {
				final String string = info[i][i_37_];
				final int i_40_ = getncoms(string);
				wx = 0;
				if (i_40_ > 1)
					conto.x = getvalue(string, 1);
				if (i_40_ > 1)
					conto.y = getvalue(string, 0);
				if (i_40_ > 1)
					conto.z = getvalue(string, 0);
				if (i_40_ > 1)
					conto.xz = getvalue(string, 0);
				if (i_40_ > 1)
					conto.xy = getvalue(string, 0);
				if (i_40_ > 1)
					conto.zy = getvalue(string, 0);
			}
		}
	}

	public void readinfo(final Mad mad, final ContO conto, final Control control, final int i, final int[] is) {
		if (go && force[i] != 7 && !isbot[i]) {
			freg += 0.05;
			int i_29_ = -1;
			if (i_29_ == -1)
				for (int i_30_ = 0; i_30_ < 3; i_30_++)
					if (frame[i][i_30_] == lframe[i] + 1) {
						i_29_ = i_30_;
						if (i_30_ == 1)
							freg -= 0.1;
						if (i_30_ == 2)
							freg -= 0.15;
					}
			if (i_29_ == -1) {
				int i_31_ = 0;
				for (int i_32_ = 0; i_32_ < 3; i_32_++)
					if (frame[i][i_32_] > lframe[i] + 1)
						i_31_++;
				if (i_31_ == 3)
					i_29_ = 2;
			}
			if (i_29_ == -1 && force[i] == 1) {
				for (int i_33_ = 0; i_33_ < 3; i_33_++)
					if (frame[i][i_33_] >= lframe[i])
						i_29_ = i_33_;
				if (i_29_ == -1)
					freg += 0.2;
			}
			if (freg < -15.0F)
				freg = -15.0F;
			if (freg > 0.0F)
				freg = 0.0F;
			if (i_29_ != -1) {
				force[i] = 0;
				final String string = info[i][i_29_];
				final String string_34_ = getSvalue(string, 0);
				if (string_34_.length() == 16) {
					String string_35_ = Messages.getString("UDPMistro.16"); //$NON-NLS-1$
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.17")).append(string_34_.charAt(0)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.18"))) //$NON-NLS-1$
						control.left = false;
					else
						control.left = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.19")).append(string_34_.charAt(1)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.20"))) //$NON-NLS-1$
						control.right = false;
					else
						control.right = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.21")).append(string_34_.charAt(2)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.22"))) //$NON-NLS-1$
						control.up = false;
					else
						control.up = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.23")).append(string_34_.charAt(3)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.24"))) //$NON-NLS-1$
						control.down = false;
					else
						control.down = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.25")).append(string_34_.charAt(4)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.26"))) //$NON-NLS-1$
						control.handb = false;
					else
						control.handb = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.27")).append(string_34_.charAt(5)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.28"))) //$NON-NLS-1$
						mad.newcar = false;
					else
						mad.newcar = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.29")).append(string_34_.charAt(6)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.30"))) //$NON-NLS-1$
						mad.mtouch = false;
					else
						mad.mtouch = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.31")).append(string_34_.charAt(7)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.32"))) //$NON-NLS-1$
						mad.wtouch = false;
					else
						mad.wtouch = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.33")).append(string_34_.charAt(8)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.34"))) //$NON-NLS-1$
						mad.pushed = false;
					else
						mad.pushed = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.35")).append(string_34_.charAt(9)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.36"))) //$NON-NLS-1$
						mad.gtouch = false;
					else
						mad.gtouch = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.37")).append(string_34_.charAt(10)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.38"))) //$NON-NLS-1$
						mad.pl = false;
					else
						mad.pl = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.39")).append(string_34_.charAt(11)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.40"))) //$NON-NLS-1$
						mad.pr = false;
					else
						mad.pr = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.41")).append(string_34_.charAt(12)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.42"))) //$NON-NLS-1$
						mad.pd = false;
					else
						mad.pd = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.43")).append(string_34_.charAt(13)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.44"))) //$NON-NLS-1$
						mad.pu = false;
					else
						mad.pu = true;
					string_35_ = new StringBuilder().append(Messages.getString("UDPMistro.45")).append(string_34_.charAt(14)).toString(); //$NON-NLS-1$
					if (string_35_.equals(Messages.getString("UDPMistro.46"))) //$NON-NLS-1$
						mad.dest = false;
					else
						mad.dest = true;
				} else if (string_34_.equals(Messages.getString("UDPMistro.47"))) { //$NON-NLS-1$
					is[i] = 3;
					mad.hitmag = mad.cd.maxmag[mad.cn] + 100;
					force[i] = 7;
				}
				if (force[i] != 7) {
					final int i_36_ = getncoms(string);
					wx = 0;
					if (i_36_ > 1)
						conto.x = getvalue(string, 1);
					if (i_36_ > 2)
						conto.y = getvalue(string, 0);
					if (i_36_ > 3)
						conto.z = getvalue(string, 0);
					if (i_36_ > 4)
						conto.xz = getvalue(string, 0);
					if (i_36_ > 5)
						conto.xy = getvalue(string, 0);
					if (i_36_ > 6)
						conto.zy = getvalue(string, 0);
					if (i_36_ > 7)
						mad.speed = getvalue(string, 0) / 100.0F;
					if (i_36_ > 8)
						mad.power = getvalue(string, 0) / 100.0F;
					if (i_36_ > 9)
						mad.mxz = getvalue(string, 0);
					if (i_36_ > 10)
						mad.pzy = getvalue(string, 0);
					if (i_36_ > 11)
						mad.pxy = getvalue(string, 0);
					if (i_36_ > 12)
						mad.txz = getvalue(string, 0);
					if (i_36_ > 13)
						mad.loop = getvalue(string, 0);
					if (i_36_ > 14)
						conto.wxz = getvalue(string, 0);
					if (i_36_ > 15)
						mad.pcleared = getvalue(string, 0);
					if (i_36_ > 16)
						mad.clear = getvalue(string, 0);
					if (i_36_ > 17)
						mad.nlaps = getvalue(string, 0);
					if (i_36_ > 18)
						mad.hitmag = (int) (getvalue(string, 0) / 100.0F * mad.cd.maxmag[mad.cn]);
				}
				lframe[i] = frame[i][i_29_];
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
			if (diled == 10)
				for (int i_18_ = 0; i_18_ < 20; i_18_++)
					if (udpc[i_18_].started) {
						final Date date = new Date();
						final long l = date.getTime() - udpc[i_18_].sendat;
						if (l > delay * 1.5 && l > rate)
							udpc[i_18_].stomp();
					}
			if (diledelay > 0)
				diledelay--;
			try {
				if (runner != null) {
					/* empty */
				}
				Thread.sleep(5L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		}
		int i_19_ = 0;
		int i_20_ = 0;
		while (runon == 4) {
			for (int i_21_ = 0; i_21_ < nplayers; i_21_++) {
				boolean bool = false;
				if (info[i_21_][0].length() > 16) {
					final String string = new StringBuilder().append(Messages.getString("UDPMistro.48")).append(info[i_21_][0].charAt(15)).toString(); //$NON-NLS-1$
					if (!string.equals(Messages.getString("UDPMistro.49"))) //$NON-NLS-1$
						bool = true;
				}
				if (!bool && out[i_21_] == 77)
					out[i_21_] = 0;
				if (out[i_21_] < 76)
					if (frame[i_21_][0] > 6) {
						if (lcframe[i_21_] != frame[i_21_][0] && !bool) {
							lcframe[i_21_] = frame[i_21_][0];
							out[i_21_] = 0;
						} else {
							if (out[i_21_] < 70)
								out[i_21_] = 71;
							out[i_21_]++;
							if (bool)
								out[i_21_] = 77;
							if (out[i_21_] == 76) {
								info[i_21_][0] = Messages.getString("UDPMistro.50"); //$NON-NLS-1$
								frame[i_21_][0] += 10;
							}
						}
					} else {
						out[i_21_]++;
						if (out[i_21_] == 30)
							frame[i_21_][0] = 7;
					}
			}
			if (i_20_ == 10) {
				final String string = new StringBuilder().append(Messages.getString("UDPMistro.51")).append(pgame).append(Messages.getString("UDPMistro.52")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
				String string_22_ = Messages.getString("UDPMistro.53"); //$NON-NLS-1$
				if (i_19_ == 0)
					try {
						dout.println(string);
						string_22_ = din.readLine();
						if (string_22_ == null)
							i_19_ = 1;
					} catch (final Exception exception) {
						i_19_ = 1;
					}
				if (i_19_ == 1) {
					try {
						socket.close();
						socket = null;
						din.close();
						din = null;
						dout.close();
						dout = null;
					} catch (final Exception exception) {
						/* empty */
					}
					try {
						socket = new Socket(xtserver, xtservport);
						din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						dout = new PrintWriter(socket.getOutputStream(), true);
						dout.println(string);
						string_22_ = din.readLine();
						if (string_22_ != null)
							i_19_ = 0;
					} catch (final Exception exception) {
						/* empty */
					}
				}
				if (i_19_ == 1) {
					try {
						socket.close();
						socket = null;
					} catch (final Exception exception) {
						/* empty */
					}
					i_19_ = 2;
				}
				i_20_ = 0;
			} else
				i_20_++;
			try {
				if (runner != null) {
					/* empty */
				}
				Thread.sleep(1000L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		}
		int i_23_ = 0;
		while (runon == 2) {
			int i_24_ = 0;
			for (int i_25_ = 0; i_25_ < 20; i_25_++)
				if (!udpc[i_25_].started)
					i_24_++;
			if (i_24_ != 20)
				i_23_++;
			if (i_23_ == 400 || i_24_ == 20) {
				for (int i_26_ = 0; i_26_ < 20; i_26_++) {
					udpc[i_26_].closeSocket();
					udpc[i_26_] = null;
				}
				runon = 3;
			}
			try {
				if (runner != null) {
					/* empty */
				}
				Thread.sleep(5L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		}
		if (runon == 3) {
			System.gc();
			System.runFinalization();
			runon = 0;
			runner = null;
		}
		if (runon == 5) {
			for (int i_27_ = 0; i_27_ < nplayers + 2; i_27_++)
				try {
					usrv[i_27_].stopServe();
					usrv[i_27_] = null;
				} catch (final Exception exception) {
					/* empty */
				}
			final String string = new StringBuilder().append(Messages.getString("UDPMistro.54")).append(pgame).append(Messages.getString("UDPMistro.55")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
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
				/* empty */
			}
			System.gc();
			System.runFinalization();
			runon = 0;
			runner = null;
		}
	}

	public void setinfo(final Mad mad, final ContO conto, final Control control, final int i, final float f,
			final boolean bool, final int i_41_) {
		info[i_41_][0] = Messages.getString("UDPMistro.56"); //$NON-NLS-1$
		if (control.left) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_42_ = 0;
			strings[i_42_] = stringbuilder.append(strings[i_42_]).append(Messages.getString("UDPMistro.57")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_43_ = 0;
			strings[i_43_] = stringbuilder.append(strings[i_43_]).append(Messages.getString("UDPMistro.58")).toString(); //$NON-NLS-1$
		}
		if (control.right) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_44_ = 0;
			strings[i_44_] = stringbuilder.append(strings[i_44_]).append(Messages.getString("UDPMistro.59")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_45_ = 0;
			strings[i_45_] = stringbuilder.append(strings[i_45_]).append(Messages.getString("UDPMistro.60")).toString(); //$NON-NLS-1$
		}
		if (control.up) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_46_ = 0;
			strings[i_46_] = stringbuilder.append(strings[i_46_]).append(Messages.getString("UDPMistro.61")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_47_ = 0;
			strings[i_47_] = stringbuilder.append(strings[i_47_]).append(Messages.getString("UDPMistro.62")).toString(); //$NON-NLS-1$
		}
		if (control.down) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_48_ = 0;
			strings[i_48_] = stringbuilder.append(strings[i_48_]).append(Messages.getString("UDPMistro.63")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_49_ = 0;
			strings[i_49_] = stringbuilder.append(strings[i_49_]).append(Messages.getString("UDPMistro.64")).toString(); //$NON-NLS-1$
		}
		if (control.handb) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_50_ = 0;
			strings[i_50_] = stringbuilder.append(strings[i_50_]).append(Messages.getString("UDPMistro.65")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_51_ = 0;
			strings[i_51_] = stringbuilder.append(strings[i_51_]).append(Messages.getString("UDPMistro.66")).toString(); //$NON-NLS-1$
		}
		if (mad.newcar) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_52_ = 0;
			strings[i_52_] = stringbuilder.append(strings[i_52_]).append(Messages.getString("UDPMistro.67")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_53_ = 0;
			strings[i_53_] = stringbuilder.append(strings[i_53_]).append(Messages.getString("UDPMistro.68")).toString(); //$NON-NLS-1$
		}
		if (mad.mtouch) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_54_ = 0;
			strings[i_54_] = stringbuilder.append(strings[i_54_]).append(Messages.getString("UDPMistro.69")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_55_ = 0;
			strings[i_55_] = stringbuilder.append(strings[i_55_]).append(Messages.getString("UDPMistro.70")).toString(); //$NON-NLS-1$
		}
		if (mad.wtouch) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_56_ = 0;
			strings[i_56_] = stringbuilder.append(strings[i_56_]).append(Messages.getString("UDPMistro.71")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_57_ = 0;
			strings[i_57_] = stringbuilder.append(strings[i_57_]).append(Messages.getString("UDPMistro.72")).toString(); //$NON-NLS-1$
		}
		if (mad.pushed) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_58_ = 0;
			strings[i_58_] = stringbuilder.append(strings[i_58_]).append(Messages.getString("UDPMistro.73")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_59_ = 0;
			strings[i_59_] = stringbuilder.append(strings[i_59_]).append(Messages.getString("UDPMistro.74")).toString(); //$NON-NLS-1$
		}
		if (mad.gtouch) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_60_ = 0;
			strings[i_60_] = stringbuilder.append(strings[i_60_]).append(Messages.getString("UDPMistro.75")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_61_ = 0;
			strings[i_61_] = stringbuilder.append(strings[i_61_]).append(Messages.getString("UDPMistro.76")).toString(); //$NON-NLS-1$
		}
		if (mad.pl) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_62_ = 0;
			strings[i_62_] = stringbuilder.append(strings[i_62_]).append(Messages.getString("UDPMistro.77")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_63_ = 0;
			strings[i_63_] = stringbuilder.append(strings[i_63_]).append(Messages.getString("UDPMistro.78")).toString(); //$NON-NLS-1$
		}
		if (mad.pr) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_64_ = 0;
			strings[i_64_] = stringbuilder.append(strings[i_64_]).append(Messages.getString("UDPMistro.79")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_65_ = 0;
			strings[i_65_] = stringbuilder.append(strings[i_65_]).append(Messages.getString("UDPMistro.80")).toString(); //$NON-NLS-1$
		}
		if (mad.pd) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_66_ = 0;
			strings[i_66_] = stringbuilder.append(strings[i_66_]).append(Messages.getString("UDPMistro.81")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_67_ = 0;
			strings[i_67_] = stringbuilder.append(strings[i_67_]).append(Messages.getString("UDPMistro.82")).toString(); //$NON-NLS-1$
		}
		if (mad.pu) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_68_ = 0;
			strings[i_68_] = stringbuilder.append(strings[i_68_]).append(Messages.getString("UDPMistro.83")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_69_ = 0;
			strings[i_69_] = stringbuilder.append(strings[i_69_]).append(Messages.getString("UDPMistro.84")).toString(); //$NON-NLS-1$
		}
		if (mad.dest) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_70_ = 0;
			strings[i_70_] = stringbuilder.append(strings[i_70_]).append(Messages.getString("UDPMistro.85")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_71_ = 0;
			strings[i_71_] = stringbuilder.append(strings[i_71_]).append(Messages.getString("UDPMistro.86")).toString(); //$NON-NLS-1$
		}
		if (bool) {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_72_ = 0;
			strings[i_72_] = stringbuilder.append(strings[i_72_]).append(Messages.getString("UDPMistro.87")).toString(); //$NON-NLS-1$
		} else {
			final StringBuilder stringbuilder = new StringBuilder();
			final String[] strings = info[i_41_];
			final int i_73_ = 0;
			strings[i_73_] = stringbuilder.append(strings[i_73_]).append(Messages.getString("UDPMistro.88")).toString(); //$NON-NLS-1$
		}
		final StringBuilder stringbuilder = new StringBuilder();
		final String[] strings = info[i_41_];
		final int i_74_ = 0;
		strings[i_74_] = stringbuilder.append(strings[i_74_]).append(Messages.getString("UDPMistro.89")).append(conto.x).append(Messages.getString("UDPMistro.90")).append(conto.y) //$NON-NLS-1$ //$NON-NLS-2$
				.append(Messages.getString("UDPMistro.91")).append(conto.z).append(Messages.getString("UDPMistro.92")).append(conto.xz).append(Messages.getString("UDPMistro.93")).append(conto.xy).append(Messages.getString("UDPMistro.94")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				.append(conto.zy).append(Messages.getString("UDPMistro.95")).append((int) (mad.speed * 100.0F)).append(Messages.getString("UDPMistro.96")) //$NON-NLS-1$ //$NON-NLS-2$
				.append((int) (mad.power * 100.0F)).append(Messages.getString("UDPMistro.97")).append(mad.mxz).append(Messages.getString("UDPMistro.98")).append(mad.pzy).append(Messages.getString("UDPMistro.99")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(mad.pxy).append(Messages.getString("UDPMistro.100")).append(mad.txz).append(Messages.getString("UDPMistro.101")).append(mad.loop).append(Messages.getString("UDPMistro.102")).append(conto.wxz) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(Messages.getString("UDPMistro.103")).append(mad.pcleared).append(Messages.getString("UDPMistro.104")).append(mad.clear).append(Messages.getString("UDPMistro.105")).append(mad.nlaps) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(Messages.getString("UDPMistro.106")).append((int) (f * 100.0F)).append(Messages.getString("UDPMistro.107")).append(i).append(Messages.getString("UDPMistro.108")).toString(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		while (info[i_41_][0].length() < 110) {
			final StringBuilder stringbuilder_75_ = new StringBuilder();
			final String[] strings_76_ = info[i_41_];
			final int i_77_ = 0;
			strings_76_[i_77_] = stringbuilder_75_.append(strings_76_[i_77_]).append(Messages.getString("UDPMistro.109")).toString(); //$NON-NLS-1$
		}
		if (runon == 2)
			mad.hitmag = mad.cd.maxmag[mad.cn] + 100;
		frame[i_41_][0]++;
	}

	public void UDPConnectLan(final String string, final int i, final int i_7_) {
		diledelay = 0;
		delay = 0;
		for (int i_8_ = 0; i_8_ < 5; i_8_++)
			ldelays[i_8_] = 0;
		diled = 0;
		go = false;
		freg = 0.0F;
		im = i_7_;
		nplayers = i;
		for (int i_9_ = 0; i_9_ < 7; i_9_++) {
			for (int i_10_ = 0; i_10_ < 3; i_10_++) {
				frame[i_9_][i_10_] = -1;
				info[i_9_][i_10_] = Messages.getString("UDPMistro.110"); //$NON-NLS-1$
			}
			isbot[i_9_] = false;
			lframe[i_9_] = 0;
			force[i_9_] = 0;
			lcframe[i_9_] = 0;
		}
		if (im != 0) {
			for (int i_11_ = 0; i_11_ < 20; i_11_++)
				udpc[i_11_] = new udpOnline(this, string, 7060 + im, i_11_, porturn);
			if (porturn == 0)
				porturn = 20;
			else
				porturn = 0;
			if (im >= nplayers) {
				frame[im][0] = 11111;
				info[im][0] = Messages.getString("UDPMistro.111"); //$NON-NLS-1$
				while (info[im][0].length() < 110) {
					final StringBuilder stringbuilder = new StringBuilder();
					final String[] strings = info[im];
					final int i_12_ = 0;
					strings[i_12_] = stringbuilder.append(strings[i_12_]).append(Messages.getString("UDPMistro.112")).toString(); //$NON-NLS-1$
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
				/* empty */
			}
			runon = 4;
		}
		runner = new Thread(this);
		runner.start();
	}

	public void UDPConnectOnline(final String string, final int i, final int i_0_, final int i_1_) {
		diledelay = 0;
		delay = 0;
		for (int i_2_ = 0; i_2_ < 5; i_2_++)
			ldelays[i_2_] = 0;
		diled = 0;
		go = false;
		freg = 0.0F;
		im = i_1_;
		nplayers = i_0_;
		for (int i_3_ = 0; i_3_ < 7; i_3_++) {
			for (int i_4_ = 0; i_4_ < 3; i_4_++) {
				frame[i_3_][i_4_] = -1;
				info[i_3_][i_4_] = Messages.getString("UDPMistro.113"); //$NON-NLS-1$
			}
			isbot[i_3_] = false;
			lframe[i_3_] = 0;
			force[i_3_] = 0;
			lcframe[i_3_] = 0;
		}
		for (int i_5_ = 0; i_5_ < 20; i_5_++)
			udpc[i_5_] = new udpOnline(this, string, i + im, i_5_, porturn);
		if (porturn == 0)
			porturn = 20;
		else
			porturn = 0;
		if (im >= nplayers) {
			frame[im][0] = 11111;
			info[im][0] = Messages.getString("UDPMistro.114"); //$NON-NLS-1$
			while (info[im][0].length() < 110) {
				final StringBuilder stringbuilder = new StringBuilder();
				final String[] strings = info[im];
				final int i_6_ = 0;
				strings[i_6_] = stringbuilder.append(strings[i_6_]).append(Messages.getString("UDPMistro.115")).toString(); //$NON-NLS-1$
			}
			nplayers++;
			go = true;
		}
		runon = 1;
		runner = new Thread(this);
		runner.start();
	}

	public void UDPLanServer(final int i, final String string, final int i_13_, final int i_14_) {
		xtserver = string;
		xtservport = i_13_;
		pgame = i_14_;
		for (int i_15_ = 0; i_15_ < 7; i_15_++) {
			gocnt[i_15_] = 3;
			out[i_15_] = 0;
			for (int i_16_ = 0; i_16_ < 3; i_16_++) {
				frame[i_15_][i_16_] = -1;
				info[i_15_][i_16_] = Messages.getString("UDPMistro.116"); //$NON-NLS-1$
			}
			lframe[i_15_] = 0;
			force[i_15_] = 0;
			lcframe[i_15_] = 0;
		}
		for (int i_17_ = 0; i_17_ < nplayers + 2; i_17_++)
			usrv[i_17_] = new udpServe(this, i_17_ + 1);
	}

	public void UDPquit() {
		if (runon == 1)
			runon = 2;
		if (runon == 4)
			runon = 5;
	}
}
