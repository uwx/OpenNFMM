
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

public class Login implements Runnable {
	int[] bgmy = { 0, 400, 800 };
	int btn = 0;
	boolean btroom = false;
	int[] bw = { 0, 0, 0, 0, 0, 0 };
	int[] bx = { 0, 0, 0, 0, 0, 0 };
	int[] by = { 0, 0, 0, 0, 0, 0 };
	int cax = 0;
	int cay = 0;
	boolean checknote = false;
	String clanapv = Messages.getString("Login.0"); //$NON-NLS-1$
	int cntcl = 0;
	int cntgame = 0;
	Thread connector;
	boolean contrb = false;
	BufferedReader din;
	PrintWriter dout;
	DatagramSocket[] dSocket = new DatagramSocket[3];
	int errcnt = 0;
	int fase = 0;
	int fclan = 0;
	int flipo = 0;
	int fplayer = 0;
	FontMetrics ftm;
	int gamec = -1;
	String gmaker = Messages.getString("Login.1"); //$NON-NLS-1$
	boolean gotcai = false;
	int groom = 0;
	GameSparker gs;
	String gservern = Messages.getString("Login.2"); //$NON-NLS-1$
	InetAddress[] IPAddress = new InetAddress[3];
	boolean jflk = false;
	boolean justlog = false;
	String lemail = Messages.getString("Login.3"); //$NON-NLS-1$
	String lnick = Messages.getString("Login.4"); //$NON-NLS-1$
	String lpass = Messages.getString("Login.5"); //$NON-NLS-1$
	int lrgfase = 0;
	int lxm = 0;
	int lym = 0;
	Medium m;
	String msg = Messages.getString("Login.6"); //$NON-NLS-1$
	int ncnt = 0;
	int nconf = 0;
	int ncreq = 0;
	int nflk = 0;
	int nfreq = 0;
	boolean nickero = false;
	int nmsgs = 0;
	int nservers = 2;
	ImageObserver ob;
	boolean ond = false;
	boolean onf = false;
	boolean onr = false;
	int opselect = 0;
	int oxm = 0;
	int oym = 0;
	int pend = 0;
	boolean pendb = false;
	boolean[] pessd = { false, false, false, false, false, false };
	Graphics2D rd;
	int recom = 0;
	boolean resofaso = false;
	int[] rmps = { 0, 0, 0, 0, 0 };
	int[] rmwt = { 0, 0, 0, 0, 0 };
	int[] serverdone = { -1, -1, -1 };
	String[] servers = { Messages.getString("Login.7"), Messages.getString("Login.8"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("Login.9") }; //$NON-NLS-1$
	long[] servestart = { 0L, 0L, 0L };
	boolean showtf = false;
	String[] snames = { Messages.getString("Login.10"), Messages.getString("Login.11"), Messages.getString("Login.12") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	Socket socket;
	boolean socketson = false;
	int srvtrn = 0;
	int trans = 0;
	int xrl = 0;
	int xrr = 0;
	xtGraphics xt;

	public Login(final Medium medium, final Graphics2D graphics2d, final xtGraphics var_xtGraphics,
			final GameSparker gamesparker) {
		m = medium;
		rd = graphics2d;
		xt = var_xtGraphics;
		gs = gamesparker;
		if (xt.playingame != -1)
			fase = 18;
		if (xt.nofull)
			nservers = 1;
	}

	public void checkgamealerts() {
		try {
			socket = new Socket(servers[0], 7061);
			din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			dout = new PrintWriter(socket.getOutputStream(), true);
			dout.println(Messages.getString("Login.13")); //$NON-NLS-1$
			final String string = din.readLine();
			if (string != null) {
				final int i = getvalue(string, 0);
				if (i != -1 && i != gamec) {
					final String string_12_ = getSvalue(string, 2);
					final int i_13_ = getvalue(string, 3);
					boolean bool = false;
					if (!string_12_.equals(xt.servername) || i_13_ != xt.servport - 7070)
						for (int i_14_ = 0; i_14_ < nservers; i_14_++)
							if (string_12_.equals(snames[i_14_]) && xt.delays[i_14_] < 300)
								bool = true;
					if (bool) {
						gmaker = getSvalue(string, 1);
						if (gmaker.equals(xt.nickname))
							gmaker = Messages.getString("Login.14"); //$NON-NLS-1$
						groom = i_13_;
						gservern = string_12_;
						gamec = i;
						cntgame = 0;
					}
				}
			}
			socket.close();
			din.close();
			dout.close();
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public void checknotifcations() {
	}

	public Color color2k(final int i, final int i_62_, final int i_63_) {
		final Color color = new Color(i, i_62_, i_63_);
		final float[] fs = new float[3];
		Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
		fs[0] = 0.13F;
		fs[1] = 0.35F;
		return Color.getHSBColor(fs[0], fs[1], fs[2]);
	}

	public void ctachm(final int i, final int i_47_, final int i_48_, final Control control, final Lobby lobby) {
		int i_49_ = -1;
		if (fase != 2 && fase != 4 && fase != 6 && fase != 8 && fase != 9)
			for (int i_50_ = 0; i_50_ < btn; i_50_++) {
				if (Math.abs(i - bx[i_50_]) < bw[i_50_] / 2 + 12 && Math.abs(i_47_ - by[i_50_]) < 14
						&& (i_48_ == 1 || i_48_ == 11))
					pessd[i_50_] = true;
				else
					pessd[i_50_] = false;
				if (Math.abs(i - bx[i_50_]) < bw[i_50_] / 2 + 12 && Math.abs(i_47_ - by[i_50_]) < 14 && i_48_ <= -1) {
					gs.mouses = 0;
					i_49_ = i_50_;
				}
				if (fase == 12 && Math.abs(i - bx[i_50_]) < bw[i_50_] / 2 + 12 && Math.abs(i_47_ - by[i_50_]) < 14
						&& (i_50_ == 3 || i_50_ == 4) && (i != lxm || i_47_ != lym))
					opselect = i_50_ - 3;
			}
		if (i_49_ == 0) {
			gs.tnick.setVisible(false);
			gs.tpass.setVisible(false);
			gs.keplo.setVisible(false);
			gs.temail.setVisible(false);
			gs.requestFocus();
			xt.fase = 24;
		}
		if (i_49_ == 1 && fase != 5) {
			gs.tnick.setVisible(false);
			gs.tpass.setVisible(false);
			gs.keplo.setVisible(false);
			gs.temail.setVisible(false);
			gs.requestFocus();
			xt.fase = 23;
		}
		final int i_51_ = 2;
		if (fase == 12 || fase == 13 || fase == 14 || fase == 15 || fase == 16 || fase == 17) {
			if (i > 176 && i_47_ > 152 && i < 296 && i_47_ < 174) {
				if (!ond) {
					ond = true;
					gs.setCursor(new Cursor(12));
				}
			} else if (ond) {
				ond = false;
				gs.setCursor(new Cursor(0));
			}
			if (cntcl == 0) {
				if (ond && i_48_ == 11) {
					gs.editlink(xt.nickname, false);
					cntcl = 10;
				}
			} else
				cntcl--;
			if (i_49_ == i_51_) {
				i_49_ = -1;
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
				msg = Messages.getString("Login.15"); //$NON-NLS-1$
				fase = 3;
			}
		}
		if (fase == 12)
			if (xt.acexp == 0 || contrb) {
				if (control.up) {
					opselect--;
					if (opselect == -1)
						opselect = 1;
					control.up = false;
				}
				if (control.down) {
					opselect++;
					if (opselect == 2)
						opselect = 0;
					control.down = false;
				}
				if (control.enter) {
					i_49_ = opselect + 3;
					control.enter = false;
				}
				if (i_49_ == i_51_ + 2) {
					trans = 0;
					fase = 15;
					i_49_ = -1;
				}
				if (!xt.logged && i_49_ == i_51_ + 3)
					gs.editlink(xt.nickname, true);
			} else {
				if (xt.acexp > 0) {
					if (i_49_ == i_51_ + 1 || control.enter) {
						gs.editlink(xt.nickname, false);
						i_49_ = -1;
					}
					if (i_49_ == i_51_ + 2) {
						opselect = 0;
						contrb = true;
						i_49_ = -1;
					}
				}
				if (xt.acexp == -1) {
					if (i_49_ == i_51_ + 1 || control.enter) {
						gs.editlink(xt.nickname, false);
						i_49_ = -1;
					}
					if (i_49_ == i_51_ + 2) {
						i_49_ = -1;
						if (xt.sc[0] >= 16) {
							xt.sc[0] = 15;
							gotcai = false;
						}
						xt.logged = false;
						xt.cd.lastload = 0;
						msg = Messages.getString("Login.16"); //$NON-NLS-1$
						fase = 3;
					}
				}
				if (xt.acexp == -2) {
					if (i_49_ == i_51_ + 1 || control.enter) {
						gs.multlink();
						i_49_ = -1;
					}
					if (i_49_ == i_51_ + 2) {
						i_49_ = -1;
						if (xt.sc[0] >= 16) {
							xt.sc[0] = 15;
							gotcai = false;
						}
						xt.logged = false;
						xt.cd.lastload = 0;
						msg = Messages.getString("Login.17"); //$NON-NLS-1$
						fase = 3;
					}
				}
				if (xt.acexp == -3) {
					if (i_49_ == i_51_ + 1 || control.enter) {
						gs.editlink(xt.nickname, false);
						i_49_ = -1;
					}
					if (i_49_ == i_51_ + 2) {
						i_49_ = -1;
						if (xt.sc[0] >= 16) {
							xt.sc[0] = 15;
							gotcai = false;
						}
						xt.logged = false;
						xt.cd.lastload = 0;
						msg = Messages.getString("Login.18"); //$NON-NLS-1$
						fase = 3;
					}
				}
			}
		if (fase == 13 || fase == 14 || fase == 15 || fase == 16 || fase == 17) {
			if (control.exit)
				i_49_ = 3;
			if (i_49_ == i_51_ + 1) {
				if (fase == 15)
					opselect = 1;
				else
					opselect = 0;
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
						/* empty */
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
					for (int i_52_ = 0; i_52_ < nservers; i_52_++)
						try {
							dSocket[i_52_].close();
							dSocket[i_52_] = null;
						} catch (final Exception exception) {
							/* empty */
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
				i_49_ = 4;
				pessd[4] = true;
			}
			if (i_49_ == i_51_ + 2)
				if (xt.nofull)
					nflk = 30;
				else {
					xt.server = servers[1];
					xt.servername = snames[1];
					xt.servport = 7067;
					xt.lan = true;
					i_49_ = -1;
					fase = 18;
					lobby.fase = 0;
				}
		}
		if (fase == 17) {
			if (control.enter) {
				i_49_ = 4;
				pessd[4] = true;
			}
			if (control.up) {
				opselect--;
				if (opselect == -1)
					opselect = 4;
				control.up = false;
			}
			if (control.down) {
				opselect++;
				if (opselect == 5)
					opselect = 0;
				control.down = false;
			}
			for (int i_54_ = 0; i_54_ < 5; i_54_++)
				if (i > 175 && i_47_ > 230 + i_54_ * 20 + 14 && i < 625 && i_47_ < 250 + i_54_ * 20 + 14 && i_48_ == 1)
					opselect = i_54_;
			if (i_49_ == i_51_ + 2) {
				xt.servport = 7071 + opselect;
				xt.lan = false;
				i_49_ = -1;
				fase = 18;
				lobby.fase = 0;
			}
		}
		if (fase == 3) {
			if (i > 295 && i_47_ > 334 && i < 505 && i_47_ < 348) {
				if (!onf) {
					onf = true;
					gs.setCursor(new Cursor(12));
				}
			} else if (onf) {
				onf = false;
				gs.setCursor(new Cursor(0));
			}
			if (onf && i_48_ == 11) {
				msg = Messages.getString("Login.19"); //$NON-NLS-1$
				gs.tnick.setForeground(new Color(0, 0, 0));
				gs.tpass.setForeground(new Color(0, 0, 0));
				gs.tnick.setVisible(false);
				gs.tpass.setVisible(false);
				gs.keplo.setVisible(false);
				onf = false;
				gs.setCursor(new Cursor(0));
				fase = 7;
			}
			if (i > xrl && i < xrr && i_47_ > 360 && i_47_ < 373) {
				if (!onr) {
					onr = true;
					gs.setCursor(new Cursor(12));
				}
			} else if (onr) {
				onr = false;
				gs.setCursor(new Cursor(0));
			}
			if (onr && i_48_ == 11) {
				gs.reglink();
				gs.mouses = 0;
			}
		}
		if (fase == 1) {
			if (control.enter) {
				i_49_ = 2;
				pessd[2] = true;
			}
			if (i_49_ == 2)
				if (gs.tnick.getText().equals(Messages.getString("Login.20")) || gs.tnick.getText().equals(Messages.getString("Login.21")) //$NON-NLS-1$ //$NON-NLS-2$
						|| gs.tnick.getText().equals(Messages.getString("Login.22"))) { //$NON-NLS-1$
					msg = Messages.getString("Login.23"); //$NON-NLS-1$
					gs.tnick.setText(Messages.getString("Login.24")); //$NON-NLS-1$
					nflk = 30;
				} else {
					msg = Messages.getString("Login.25"); //$NON-NLS-1$
					gs.tnick.disable();
					fase = 2;
					connector = new Thread(this);
					connector.start();
				}
			if (i_49_ == 3) {
				if (gs.tnick.getText().equals(Messages.getString("Login.26")) || msg.startsWith(Messages.getString("Login.27"))) //$NON-NLS-1$ //$NON-NLS-2$
					gs.tnick.setText(Messages.getString("Login.28")); //$NON-NLS-1$
				msg = Messages.getString("Login.29"); //$NON-NLS-1$
				gs.tnick.setForeground(new Color(0, 0, 0));
				fase = 3;
				i_49_ = -1;
			}
			if (i_49_ == 4) {
				if (nickero || gs.tnick.getText().equals(Messages.getString("Login.30"))) { //$NON-NLS-1$
					gs.tnick.setText(Messages.getString("Login.31")); //$NON-NLS-1$
					nickero = false;
				}
				gs.tnick.setForeground(new Color(0, 0, 0));
				gs.reglink();
			}
		}
		if (fase == 3) {
			if (control.enter || xt.autolog) {
				i_49_ = 2;
				pessd[2] = true;
				xt.autolog = false;
			}
			if (control.exit)
				i_49_ = 3;
			if (i_49_ == 2)
				if (gs.tnick.getText().equals(Messages.getString("Login.32"))) { //$NON-NLS-1$
					msg = Messages.getString("Login.33"); //$NON-NLS-1$
					nflk = 30;
				} else if (gs.tpass.getText().equals(Messages.getString("Login.34"))) { //$NON-NLS-1$
					msg = Messages.getString("Login.35"); //$NON-NLS-1$
					nflk = 30;
				} else {
					msg = Messages.getString("Login.36"); //$NON-NLS-1$
					gs.tnick.disable();
					gs.tpass.disable();
					gs.keplo.disable();
					fase = 4;
					connector = new Thread(this);
					connector.start();
				}
			if (i_49_ == 3)
				gs.regnew();
		}
		if (fase == 5) {
			if (control.enter) {
				i_49_ = 1;
				pessd[1] = true;
			}
			if (control.exit)
				i_49_ = 2;
			if (i_49_ != 1) {
				/* empty */
			}
			if (i_49_ == 2) {
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
				i_49_ = 2;
				pessd[2] = true;
			}
			if (control.exit)
				i_49_ = 3;
			if (i_49_ == 2) {
				nflk = 0;
				if (gs.temail.getText().equals(Messages.getString("Login.37"))) { //$NON-NLS-1$
					msg = Messages.getString("Login.38"); //$NON-NLS-1$
					nflk = 30;
				}
				if (nflk == 0) {
					final String string = gs.temail.getText();
					int i_55_ = 0;
					int i_56_ = 0;
					for (/**/ ; i_55_ < string.length(); i_55_++) {
						final String string_57_ = new StringBuilder().append(Messages.getString("Login.39")).append(string.charAt(i_55_)) //$NON-NLS-1$
								.toString();
						if (string_57_.equals(Messages.getString("Login.40")) && i_56_ == 0 && i_55_ != 0) //$NON-NLS-1$
							i_56_ = 1;
						if (string_57_.equals(Messages.getString("Login.41")) && i_56_ == 1 && i_55_ != string.length() - 1) //$NON-NLS-1$
							i_56_ = 2;
					}
					if (i_56_ != 2) {
						msg = Messages.getString("Login.42"); //$NON-NLS-1$
						nflk = 30;
						errcnt = 40;
						gs.temail.setForeground(new Color(255, 0, 0));
					}
				}
				if (nflk == 0) {
					msg = Messages.getString("Login.43"); //$NON-NLS-1$
					gs.temail.disable();
					fase = 8;
					connector = new Thread(this);
					connector.start();
				}
			}
			if (i_49_ == 3) {
				inishmulti();
				gs.temail.setText(Messages.getString("Login.44")); //$NON-NLS-1$
				gs.tpass.setText(Messages.getString("Login.45")); //$NON-NLS-1$
			}
		}
		lxm = i;
		lym = i_47_;
		control.enter = false;
		control.exit = false;
	}

	public void drawbutton(final Image image, final int i, final int i_59_) {
		bx[btn] = i;
		by[btn] = i_59_;
		bw[btn] = image.getWidth(ob);
		if (!pessd[btn]) {
			rd.drawImage(image, i - bw[btn] / 2, i_59_ - image.getHeight(ob) / 2, null);
			rd.drawImage(xt.bol, i - bw[btn] / 2 - 15, i_59_ - 16, null);
			rd.drawImage(xt.bor, i + bw[btn] / 2 + 9, i_59_ - 16, null);
			rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i_59_ - 16, bw[btn] + 18, 3, null);
			rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i_59_ + 13, bw[btn] + 18, 3, null);
		} else {
			rd.drawImage(image, i - bw[btn] / 2 + 1, i_59_ - image.getHeight(ob) / 2 + 1, null);
			rd.drawImage(xt.bolp, i - bw[btn] / 2 - 15, i_59_ - 16, null);
			rd.drawImage(xt.borp, i + bw[btn] / 2 + 9, i_59_ - 16, null);
			rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i_59_ - 16, bw[btn] + 18, 3, null);
			rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i_59_ + 13, bw[btn] + 18, 3, null);
		}
		btn++;
	}

	public void drawSbutton(final Image image, final int i, final int i_58_) {
		bx[btn] = i;
		by[btn] = i_58_;
		bw[btn] = image.getWidth(ob);
		if (!pessd[btn]) {
			rd.drawImage(image, i - bw[btn] / 2, i_58_ - image.getHeight(ob) / 2 - 1, null);
			rd.drawImage(xt.bols, i - bw[btn] / 2 - 15, i_58_ - 13, null);
			rd.drawImage(xt.bors, i + bw[btn] / 2 + 9, i_58_ - 13, null);
			rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i_58_ - 13, bw[btn] + 18, 3, null);
			rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i_58_ + 10, bw[btn] + 18, 3, null);
		} else {
			rd.drawImage(image, i - bw[btn] / 2 + 1, i_58_ - image.getHeight(ob) / 2, null);
			rd.drawImage(xt.bolps, i - bw[btn] / 2 - 15, i_58_ - 13, null);
			rd.drawImage(xt.borps, i + bw[btn] / 2 + 9, i_58_ - 13, null);
			rd.drawImage(xt.bob, i - bw[btn] / 2 - 9, i_58_ - 13, bw[btn] + 18, 3, null);
			rd.drawImage(xt.bot, i - bw[btn] / 2 - 9, i_58_ + 10, bw[btn] + 18, 3, null);
		}
		btn++;
	}

	public void endcons() {
		for (int i = 0; i < nservers; i++)
			try {
				dSocket[i].close();
				dSocket[i] = null;
			} catch (final Exception exception) {
				/* empty */
			}
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
	}

	public void exitfromlobby() {
		if (!xt.lan)
			opselect = 0;
		else
			opselect = 1;
		for (int i = 0; i < nservers; i++) {
			serverdone[i] = -1;
			servestart[i] = 0L;
		}
		for (int i = 0; i < 6; i++)
			pessd[i] = false;
		gotcai = false;
		btroom = false;
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

	public void fixtext(final TextField textfield) {
		String string = textfield.getText();
		string = string.replace('\"', '#');
		final String string_64_ = Messages.getString("Login.46"); //$NON-NLS-1$
		String string_65_ = Messages.getString("Login.47"); //$NON-NLS-1$
		int i = 0;
		int i_66_ = -1;
		for (/**/ ; i < string.length(); i++) {
			final String string_67_ = new StringBuilder().append(Messages.getString("Login.48")).append(string.charAt(i)).toString(); //$NON-NLS-1$
			if (string_67_.equals(Messages.getString("Login.49")) || string_67_.equals(Messages.getString("Login.50")) || string_67_.equals(Messages.getString("Login.51")) || string_67_.equals(Messages.getString("Login.52")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					|| string_67_.equals(Messages.getString("Login.53")) || string_67_.equals(string_64_) || string_67_.equals(Messages.getString("Login.54")) //$NON-NLS-1$ //$NON-NLS-2$
					|| string_67_.equals(Messages.getString("Login.55")) || string_67_.equals(Messages.getString("Login.56")) || string_67_.equals(Messages.getString("Login.57")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_67_.equals(Messages.getString("Login.58")) || string_67_.equals(Messages.getString("Login.59")) || string_67_.equals(Messages.getString("Login.60")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_67_.equals(Messages.getString("Login.61")) || string_67_.equals(Messages.getString("Login.62")) || string_67_.equals(Messages.getString("Login.63")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_67_.equals(Messages.getString("Login.64")) || string_67_.equals(Messages.getString("Login.65")) || string_67_.equals(Messages.getString("Login.66")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_67_.equals(Messages.getString("Login.67")) || string_67_.equals(Messages.getString("Login.68")) || string_67_.equals(Messages.getString("Login.69")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_67_.equals(Messages.getString("Login.70")) || string_67_.equals(Messages.getString("Login.71"))) //$NON-NLS-1$ //$NON-NLS-2$
				i_66_ = i;
			else
				string_65_ = new StringBuilder().append(string_65_).append(string_67_).toString();
		}
		if (i_66_ != -1) {
			textfield.setText(string_65_);
			textfield.select(i_66_, i_66_);
		}
	}

	public void gamealert() {
		try {
			socket = new Socket(servers[0], 7061);
			din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			dout = new PrintWriter(socket.getOutputStream(), true);
			dout.println(new StringBuilder().append(Messages.getString("Login.72")).append(xt.nickname).append(Messages.getString("Login.73")).append(xt.nickey) //$NON-NLS-1$ //$NON-NLS-2$
					.append(Messages.getString("Login.74")).append(xt.servername).append(Messages.getString("Login.75")).append(xt.servport - 7070).append(Messages.getString("Login.76")).toString()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			din.readLine();
			socket.close();
			din.close();
			dout.close();
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public String getSvalue(final String string, final int i) {
		String string_74_ = Messages.getString("Login.77"); //$NON-NLS-1$
		try {
			int i_75_ = 0;
			int i_76_ = 0;
			int i_77_ = 0;
			String string_78_ = Messages.getString("Login.78"); //$NON-NLS-1$
			String string_79_ = Messages.getString("Login.79"); //$NON-NLS-1$
			for (/**/ ; i_75_ < string.length() && i_77_ != 2; i_75_++) {
				string_78_ = new StringBuilder().append(Messages.getString("Login.80")).append(string.charAt(i_75_)).toString(); //$NON-NLS-1$
				if (string_78_.equals(Messages.getString("Login.81"))) { //$NON-NLS-1$
					i_76_++;
					if (i_77_ == 1 || i_76_ > i)
						i_77_ = 2;
				} else if (i_76_ == i) {
					string_79_ = new StringBuilder().append(string_79_).append(string_78_).toString();
					i_77_ = 1;
				}
			}
			string_74_ = string_79_;
		} catch (final Exception exception) {
			/* empty */
		}
		return string_74_;
	}

	public int getvalue(final String string, final int i) {
		int i_68_ = -1;
		try {
			int i_69_ = 0;
			int i_70_ = 0;
			int i_71_ = 0;
			String string_72_ = Messages.getString("Login.82"); //$NON-NLS-1$
			String string_73_ = Messages.getString("Login.83"); //$NON-NLS-1$
			for (/**/ ; i_69_ < string.length() && i_71_ != 2; i_69_++) {
				string_72_ = new StringBuilder().append(Messages.getString("Login.84")).append(string.charAt(i_69_)).toString(); //$NON-NLS-1$
				if (string_72_.equals(Messages.getString("Login.85"))) { //$NON-NLS-1$
					i_70_++;
					if (i_71_ == 1 || i_70_ > i)
						i_71_ = 2;
				} else if (i_70_ == i) {
					string_73_ = new StringBuilder().append(string_73_).append(string_72_).toString();
					i_71_ = 1;
				}
			}
			if (string_73_.equals(Messages.getString("Login.86"))) //$NON-NLS-1$
				string_73_ = Messages.getString("Login.87"); //$NON-NLS-1$
			i_68_ = Integer.valueOf(string_73_).intValue();
		} catch (final Exception exception) {
			/* empty */
		}
		return i_68_;
	}

	public void inishmulti() {
		gs.tnick.setVisible(false);
		gs.tnick.enable();
		gs.tnick.setForeground(new Color(0, 0, 0));
		gs.tnick.setBackground(color2k(240, 240, 240));
		gs.tpass.setVisible(false);
		gs.tpass.enable();
		gs.tpass.setForeground(new Color(0, 0, 0));
		gs.tpass.setBackground(color2k(240, 240, 240));
		gs.temail.setVisible(false);
		gs.temail.enable();
		gs.temail.setForeground(new Color(0, 0, 0));
		gs.temail.setBackground(color2k(240, 240, 240));
		gs.keplo.setVisible(false);
		gs.keplo.enable();
		gs.keplo.setForeground(new Color(0, 0, 0));
		gs.keplo.setBackground(new Color(193, 181, 142));
		gs.requestFocus();
		if (gs.tnick.getText().equals(Messages.getString("Login.88"))) //$NON-NLS-1$
			gs.tnick.setText(Messages.getString("Login.89")); //$NON-NLS-1$
		for (int i = 0; i < 6; i++)
			pessd[i] = false;
		nflk = 0;
		ncnt = 0;
		errcnt = 0;
		onf = false;
		ond = false;
		msg = Messages.getString("Login.90"); //$NON-NLS-1$
		btroom = false;
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
			msg = Messages.getString("Login.91"); //$NON-NLS-1$
			gs.tnick.setText(xt.nickname);
			fase = 3;
		}
	}

	public void multimode(final ContO[] contos) {
		btn = 0;
		xt.mainbg(4);
		for (int i = 0; i < 3; i++) {
			rd.drawImage(xt.bgmain, 65, bgmy[i], null);
			bgmy[i] -= 4;
			if (bgmy[i] <= -400)
				bgmy[i] = 800;
		}
		rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
		rd.drawImage(xt.bggo, 0, 0, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.setColor(new Color(0, 0, 0));
		rd.fillRect(65, 425, 670, 25);
		rd.fillRect(0, 0, 65, 450);
		rd.fillRect(735, 0, 65, 450);
		float f = 1.0F - (flipo - 10) / 80.0F;
		if (f > 1.0F)
			f = 1.0F;
		if (f < 0.0F)
			f = 0.0F;
		rd.setComposite(AlphaComposite.getInstance(3, f));
		if (flipo > 10)
			rd.drawImage(xt.logomadnes, 96 + (int) (2.0 - Math.random() * 4.0), 11 + (int) (2.0 - Math.random() * 4.0),
					null);
		else
			rd.drawImage(xt.logomadnes, 96, 11, null);
		flipo++;
		if (flipo > 50)
			flipo = 0;
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
			int i_26_ = i;
			int i_27_ = contos[xt.sc[0]].p[0].oy[0];
			int i_28_ = i_27_;
			for (int i_29_ = 0; i_29_ < contos[xt.sc[0]].npl; i_29_++)
				for (int i_30_ = 0; i_30_ < contos[xt.sc[0]].p[i_29_].n; i_30_++) {
					if (contos[xt.sc[0]].p[i_29_].oz[i_30_] < i)
						i = contos[xt.sc[0]].p[i_29_].oz[i_30_];
					if (contos[xt.sc[0]].p[i_29_].oz[i_30_] > i_26_)
						i_26_ = contos[xt.sc[0]].p[i_29_].oz[i_30_];
					if (contos[xt.sc[0]].p[i_29_].oy[i_30_] < i_27_)
						i_27_ = contos[xt.sc[0]].p[i_29_].oy[i_30_];
					if (contos[xt.sc[0]].p[i_29_].oy[i_30_] > i_28_)
						i_28_ = contos[xt.sc[0]].p[i_29_].oy[i_30_];
				}
			cax = (i_26_ + i) / 2;
			cay = (i_28_ + i_27_) / 2;
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
			if (pend > 80)
				pendb = true;
		} else {
			pend -= 2;
			if (pend < -10)
				pendb = false;
		}
		rd.setFont(new Font(Messages.getString("Login.92"), 1, 13)); //$NON-NLS-1$
		ftm = rd.getFontMetrics();
		rd.setColor(new Color(0, 0, 0));
		rd.drawString(xt.nickname, 239 - ftm.stringWidth(xt.nickname) / 2, 105);
		rd.setColor(color2k(90, 90, 90));
		rd.drawString(new StringBuilder().append(Messages.getString("Login.93")).append(xt.cd.names[xt.sc[0]]).append(Messages.getString("Login.94")).toString(), 409 //$NON-NLS-1$ //$NON-NLS-2$
				- ftm.stringWidth(new StringBuilder().append(Messages.getString("Login.95")).append(xt.cd.names[xt.sc[0]]).append(Messages.getString("Login.96")).toString()) //$NON-NLS-1$ //$NON-NLS-2$
						/ 2,
				81);
		rd.drawString(Messages.getString("Login.97"), 239 - ftm.stringWidth(Messages.getString("Login.98")) / 2, 81); //$NON-NLS-1$ //$NON-NLS-2$
		drawbutton(xt.change, 570, 98);
		drawSbutton(xt.logout, 239, 135);
		rd.setColor(new Color(98, 56, 0));
		rd.drawString(Messages.getString("Login.99"), 239 - ftm.stringWidth(Messages.getString("Login.100")) / 2, 168); //$NON-NLS-1$ //$NON-NLS-2$
		if (ond)
			rd.drawLine(239 - ftm.stringWidth(Messages.getString("Login.101")) / 2, 169, //$NON-NLS-1$
					239 - ftm.stringWidth(Messages.getString("Login.102")) / 2 + ftm.stringWidth(Messages.getString("Login.103")), 169); //$NON-NLS-1$ //$NON-NLS-2$
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
				rd.drawString(Messages.getString("Login.104"), 400 - ftm.stringWidth(Messages.getString("Login.105")) / 2, 220); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawRoundRect(205, 225, 390, 120, 20, 20);
				drawbutton(xt.pln, 400, 285 - xt.pln.getHeight(ob) / 2);
				if (opselect == 1 && !pessd[4]) {
					rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
					rd.setColor(new Color(203, 227, 253));
					rd.fillRect(387 - xt.pln.getWidth(ob) / 2, 285 - xt.pln.getHeight(ob) - 5, xt.pln.getWidth(ob) + 26,
							26);
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
					rd.drawString(new StringBuilder().append(Messages.getString("Login.106")).append(xt.nickname).append(Messages.getString("Login.107")).toString(), 185, //$NON-NLS-1$ //$NON-NLS-2$
							245);
					rd.drawString(new StringBuilder().append(Messages.getString("Login.108")).append(xt.acexp) //$NON-NLS-1$
							.append(Messages.getString("Login.109")).toString(), 185, 265); //$NON-NLS-1$
					rd.drawString(Messages.getString("Login.110"), 185, 295); //$NON-NLS-1$
					stringbutton(Messages.getString("Login.111"), 345, 332, 0); //$NON-NLS-1$
					stringbutton(Messages.getString("Login.112"), 524, 332, 0); //$NON-NLS-1$
				}
				if (xt.acexp == -1) {
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(new StringBuilder().append(Messages.getString("Login.113")).append(xt.nickname).append(Messages.getString("Login.114")).toString(), 185, //$NON-NLS-1$ //$NON-NLS-2$
							245);
					rd.drawString(Messages.getString("Login.115"), 185, 265); //$NON-NLS-1$
					rd.drawString(Messages.getString("Login.116"), 185, 295); //$NON-NLS-1$
					stringbutton(Messages.getString("Login.117"), 362, 332, 0); //$NON-NLS-1$
					stringbutton(Messages.getString("Login.118"), 524, 332, 0); //$NON-NLS-1$
				}
				if (xt.acexp == -2) {
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(new StringBuilder().append(Messages.getString("Login.119")).append(xt.nickname).append(Messages.getString("Login.120")).toString(), 185, //$NON-NLS-1$ //$NON-NLS-2$
							245);
					rd.drawString(Messages.getString("Login.121"), 185, 265); //$NON-NLS-1$
					rd.drawString(Messages.getString("Login.122"), 185, 295); //$NON-NLS-1$
					stringbutton(Messages.getString("Login.123"), 362, 332, 0); //$NON-NLS-1$
					stringbutton(Messages.getString("Login.124"), 524, 332, 0); //$NON-NLS-1$
				}
				if (xt.acexp == -3) {
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("Login.125"), 185, 245); //$NON-NLS-1$
					rd.drawString(Messages.getString("Login.126"), 185, 265); //$NON-NLS-1$
					rd.drawString(Messages.getString("Login.127"), 185, 285); //$NON-NLS-1$
					rd.drawString(Messages.getString("Login.128"), 185, 305); //$NON-NLS-1$
					stringbutton(Messages.getString("Login.129"), 332, 336, 0); //$NON-NLS-1$
					stringbutton(Messages.getString("Login.130"), 494, 336, 0); //$NON-NLS-1$
				}
			}
		if (fase == 15) {
			if (trans < 100)
				rd.drawImage(xt.pln, 400 - xt.pln.getWidth(ob) / 2, 315 - xt.pln.getHeight(ob) / 2 - 12 - trans, null);
			else
				rd.drawImage(xt.pln, 400 - xt.pln.getWidth(ob) / 2, 215 - xt.pln.getHeight(ob) / 2 - 12, null);
			if (trans >= 100) {
				rd.setColor(color2k(255, 255, 255));
				rd.fillRoundRect(165, 219, 470, 150, 20, 20);
				rd.setColor(new Color(0, 0, 0));
				rd.drawRoundRect(165, 219, 470, 150, 20, 20);
				rd.setFont(new Font(Messages.getString("Login.131"), 1, 13)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				if (xt.nofull) {
					if (nflk % 4 != 0 || nflk == 0) {
						rd.setFont(new Font(Messages.getString("Login.132"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.setColor(new Color(200, 0, 0));
						rd.drawString(Messages.getString("Login.133"), 175, //$NON-NLS-1$
								242);
						rd.setFont(new Font(Messages.getString("Login.134"), 0, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(Messages.getString("Login.135"), //$NON-NLS-1$
								175, 262);
						rd.drawString(Messages.getString("Login.136"), 175, 288); //$NON-NLS-1$
						rd.setFont(new Font(Messages.getString("Login.137"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.drawString(Messages.getString("Login.138"), 175, //$NON-NLS-1$
								315);
						rd.drawString(Messages.getString("Login.139"), 175, 332); //$NON-NLS-1$
						rd.setFont(new Font(Messages.getString("Login.140"), 0, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.drawString(Messages.getString("Login.141"), 295, 332); //$NON-NLS-1$
						rd.drawString(Messages.getString("Login.142"), //$NON-NLS-1$
								175, 349);
					}
					if (nflk != 0)
						nflk--;
				} else {
					rd.drawString(Messages.getString("Login.143"), 179, 245); //$NON-NLS-1$
					rd.drawString(Messages.getString("Login.144"), 179, 262); //$NON-NLS-1$
					rd.setFont(new Font(Messages.getString("Login.145"), 0, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("Login.146"), 179, //$NON-NLS-1$
							292);
					rd.drawString(Messages.getString("Login.147"), 179, 309); //$NON-NLS-1$
					rd.drawString(Messages.getString("Login.148"), 179, //$NON-NLS-1$
							335);
					rd.drawString(Messages.getString("Login.149"), 179, 352); //$NON-NLS-1$
				}
				drawbutton(xt.cancel, 583, 395);
				drawbutton(xt.play, 400, 395);
			} else
				trans += 10;
		}
		if (resofaso)
			resofaso = false;
	}

	public void multistart(final ContO[] contos, final int i, final int i_38_, final boolean bool) {
		btn = 0;
		xt.mainbg(4);
		for (int i_39_ = 0; i_39_ < 3; i_39_++) {
			rd.drawImage(xt.bgmain, 65, bgmy[i_39_], null);
			bgmy[i_39_] -= 4;
			if (bgmy[i_39_] <= -400)
				bgmy[i_39_] = 800;
		}
		rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
		rd.drawImage(xt.bggo, 0, 0, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.setColor(new Color(0, 0, 0));
		rd.fillRect(65, 425, 670, 25);
		rd.fillRect(0, 0, 65, 450);
		rd.fillRect(735, 0, 65, 450);
		float f = 1.0F - (flipo - 10) / 80.0F;
		if (f > 1.0F)
			f = 1.0F;
		if (f < 0.0F)
			f = 0.0F;
		rd.setComposite(AlphaComposite.getInstance(3, f));
		if (flipo > 10)
			rd.drawImage(xt.logomadnes, 96 + (int) (2.0 - Math.random() * 4.0), 11 + (int) (2.0 - Math.random() * 4.0),
					null);
		else
			rd.drawImage(xt.logomadnes, 96, 11, null);
		flipo++;
		if (flipo > 50)
			flipo = 0;
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		int i_40_ = 0;
		if (i != oxm || i_38_ != oym) {
			i_40_ = 1;
			oxm = i;
			oym = i_38_;
		}
		if (bool)
			i_40_ = 2;
		rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
		rd.drawImage(xt.dude[i_40_], 87, 76, null);
		rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		rd.drawImage(xt.redy, 445, 153, null);
		// really dirty solution to a very specific bug
		// DO NOT DELETE THE LINE BELOW
		// drawSbutton((xt).exit, 690, 17);
		drawSbutton(xt.exit, 690, 17);
		rd.setFont(new Font(Messages.getString("Login.150"), 1, 13)); //$NON-NLS-1$
		ftm = rd.getFontMetrics();
		if (fase != 5) {
			rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
			rd.setColor(new Color(203, 227, 253));
			rd.fillRoundRect(246, 83, 180, 96, 20, 20);
			rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
			rd.setColor(color2k(90, 90, 90));
			rd.drawString(new StringBuilder().append(Messages.getString("Login.151")).append(xt.cd.names[xt.sc[0]]).append(Messages.getString("Login.152")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
					336 - ftm.stringWidth(
							new StringBuilder().append(Messages.getString("Login.153")).append(xt.cd.names[xt.sc[0]]).append(Messages.getString("Login.154")).toString()) / 2, //$NON-NLS-1$ //$NON-NLS-2$
					81);
			rd.drawRoundRect(246, 83, 180, 96, 20, 20);
			if (!gotcai) {
				int i_41_ = contos[xt.sc[0]].p[0].oz[0];
				int i_42_ = i_41_;
				int i_43_ = contos[xt.sc[0]].p[0].oy[0];
				int i_44_ = i_43_;
				for (int i_45_ = 0; i_45_ < contos[xt.sc[0]].npl; i_45_++)
					for (int i_46_ = 0; i_46_ < contos[xt.sc[0]].p[i_45_].n; i_46_++) {
						if (contos[xt.sc[0]].p[i_45_].oz[i_46_] < i_41_)
							i_41_ = contos[xt.sc[0]].p[i_45_].oz[i_46_];
						if (contos[xt.sc[0]].p[i_45_].oz[i_46_] > i_42_)
							i_42_ = contos[xt.sc[0]].p[i_45_].oz[i_46_];
						if (contos[xt.sc[0]].p[i_45_].oy[i_46_] < i_43_)
							i_43_ = contos[xt.sc[0]].p[i_45_].oy[i_46_];
						if (contos[xt.sc[0]].p[i_45_].oy[i_46_] > i_44_)
							i_44_ = contos[xt.sc[0]].p[i_45_].oy[i_46_];
					}
				cax = (i_42_ + i_41_) / 2;
				cay = (i_44_ + i_43_) / 2;
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
				if (pend > 80)
					pendb = true;
			} else {
				pend -= 2;
				if (pend < -10)
					pendb = false;
			}
			drawbutton(xt.change, 497, 98);
		}
		if (fase == 1 || fase == 2) {
			rd.setColor(new Color(0, 0, 0));
			rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 205);
			rd.drawString(Messages.getString("Login.155"), 400 - ftm.stringWidth(Messages.getString("Login.156")) - 14, 241); //$NON-NLS-1$ //$NON-NLS-2$
			if (fase == 2) {
				if (msg.equals(Messages.getString("Login.157")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.158"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.159")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.160"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.161")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.162"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.163")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.164"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (ncnt != 0)
					ncnt--;
				pessd[2] = true;
			}
			if (fase == 1 && !gs.tnick.isShowing()) {
				gs.tnick.setVisible(true);
				gs.tnick.requestFocus();
				if (gs.tnick.getText().equals(Messages.getString("Login.165"))) //$NON-NLS-1$
					gs.tnick.select(8, 8);
			}
			if (errcnt != 0) {
				errcnt--;
				if (errcnt == 0)
					gs.tnick.setForeground(new Color(0, 0, 0));
			}
			drawbutton(xt.play, 400, 285);
			if (nflk > 0) {
				if (gs.tnick.getText().equals(Messages.getString("Login.166"))) { //$NON-NLS-1$
					gs.tnick.setText(Messages.getString("Login.167")); //$NON-NLS-1$
					if (nflk == 1)
						gs.tnick.select(8, 8);
				} else
					gs.tnick.setText(Messages.getString("Login.168")); //$NON-NLS-1$
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
			if (xt.msgcheck(gs.tnick.getText()))
				gs.tnick.setText(Messages.getString("Login.169")); //$NON-NLS-1$
			if (gs.tnick.getText().toLowerCase().indexOf(Messages.getString("Login.170")) != -1) //$NON-NLS-1$
				gs.tnick.setText(Messages.getString("Login.171")); //$NON-NLS-1$
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
			if (nflk % 4 != 0 || nflk == 0)
				rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 205);
			if (nflk != 0)
				nflk--;
			rd.drawString(Messages.getString("Login.172"), 376 - ftm.stringWidth(Messages.getString("Login.173")) - 14, 237); //$NON-NLS-1$ //$NON-NLS-2$
			rd.drawString(Messages.getString("Login.174"), 376 - ftm.stringWidth(Messages.getString("Login.175")) - 14, 267); //$NON-NLS-1$ //$NON-NLS-2$
			if (fase == 4) {
				if (msg.equals(Messages.getString("Login.176")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.177"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.178")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.179"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.180")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.181"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.182")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.183"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (ncnt != 0)
					ncnt--;
				pessd[2] = true;
			}
			if (fase == 3) {
				showtf = true;
				if (!gs.applejava) {
					if (!gs.tpass.isShowing()) {
						gs.tpass.setVisible(true);
						if (!gs.tnick.getText().equals(Messages.getString("Login.184"))) //$NON-NLS-1$
							gs.tpass.requestFocus();
					}
					if (!gs.tnick.isShowing()) {
						gs.tnick.setVisible(true);
						if (gs.tnick.getText().equals(Messages.getString("Login.185"))) //$NON-NLS-1$
							gs.tnick.requestFocus();
					}
				}
			}
			if (errcnt != 0) {
				errcnt--;
				if (errcnt == 0) {
					gs.tpass.setText(Messages.getString("Login.186")); //$NON-NLS-1$
					gs.tnick.setForeground(new Color(0, 0, 0));
					gs.tpass.setForeground(new Color(0, 0, 0));
				}
			}
			drawbutton(xt.login, 400, 315);
			if (onf)
				rd.setColor(color2k(0, 72, 255));
			else
				rd.setColor(color2k(120, 120, 120));
			rd.setFont(new Font(Messages.getString("Login.187"), 1, 11)); //$NON-NLS-1$
			ftm = rd.getFontMetrics();
			rd.drawString(Messages.getString("Login.188"), //$NON-NLS-1$
					400 - ftm.stringWidth(Messages.getString("Login.189")) / 2, 345); //$NON-NLS-1$
			rd.setColor(new Color(0, 0, 0));
			rd.setFont(new Font(Messages.getString("Login.190"), 1, 12)); //$NON-NLS-1$
			ftm = rd.getFontMetrics();
			final String string = Messages.getString("Login.191"); //$NON-NLS-1$
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
			if (fase == 3 && (!gs.tpass.getText().equals(Messages.getString("Login.192")) && !gs.tnick.getText().equals(Messages.getString("Login.193")) || !gs.applejava) //$NON-NLS-1$ //$NON-NLS-2$
					&& !gs.keplo.isShowing())
				gs.keplo.setVisible(true);
			gs.movefield(gs.keplo, 376, 275, 129, 23);
		}
		if (fase == 5) {
			rd.setColor(new Color(0, 0, 0));
			rd.drawString(Messages.getString("Login.194"), 376 - ftm.stringWidth(Messages.getString("Login.195")) - 14, 141); //$NON-NLS-1$ //$NON-NLS-2$
			gs.movefield(gs.tnick, 376, 125, 129, 23);
			while (ftm.stringWidth(gs.tnick.getText()) > 86) {
				gs.tnick.setText(gs.tnick.getText().substring(0, gs.tnick.getText().length() - 1));
				gs.tnick.select(gs.tnick.getText().length(), gs.tnick.getText().length());
			}
			if (!gs.tnick.getText().equals(lnick)) {
				fixtext(gs.tnick);
				lnick = gs.tnick.getText();
			}
			if (!gs.tnick.isShowing())
				gs.tnick.setVisible(true);
			drawbutton(xt.register, 400, 325);
			drawbutton(xt.cancel, 400, 375);
		}
		if (fase == 7 || fase == 8) {
			rd.setColor(new Color(0, 0, 0));
			if (nflk % 4 != 0 || nflk == 0)
				rd.drawString(msg, 400 - ftm.stringWidth(msg) / 2, 205);
			if (nflk != 0)
				nflk--;
			rd.drawString(Messages.getString("Login.196"), 344 - ftm.stringWidth(Messages.getString("Login.197")) - 14, 241); //$NON-NLS-1$ //$NON-NLS-2$
			if (fase == 8) {
				if (msg.equals(Messages.getString("Login.198")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.199"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.200")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.201"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.202")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.203"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (msg.equals(Messages.getString("Login.204")) && ncnt == 0) { //$NON-NLS-1$
					msg = Messages.getString("Login.205"); //$NON-NLS-1$
					ncnt = 5;
				}
				if (ncnt != 0)
					ncnt--;
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
				if (errcnt == 0)
					gs.temail.setForeground(new Color(0, 0, 0));
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
			int i_15_ = -1;
			try {
				socket = new Socket(servers[0], 7061);
				din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				dout = new PrintWriter(socket.getOutputStream(), true);
				dout.println(new StringBuilder().append(Messages.getString("Login.206")).append(gs.tnick.getText()).append(Messages.getString("Login.207")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				final String string = din.readLine();
				if (string != null) {
					i = getvalue(string, 0);
					if (i == 0) {
						i_15_ = getvalue(string, 1);
						xt.hours = getvalue(string, 2);
						xt.nickey = getSvalue(string, 3);
					}
				}
				socket.close();
				din.close();
				dout.close();
			} catch (final Exception exception) {
				/* empty */
			}
			gs.tnick.enable();
			if (i == -1) {
				msg = Messages.getString("Login.208"); //$NON-NLS-1$
				fase = 1;
			}
			if (i == 0) {
				xt.nickname = gs.tnick.getText();
				if (i_15_ != -1)
					xt.nfreeplays = 0;
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
				msg = Messages.getString("Login.209"); //$NON-NLS-1$
				nickero = true;
				gs.tnick.setForeground(new Color(255, 0, 0));
				gs.tnick.requestFocus();
				errcnt = 30;
				fase = 1;
			}
			if (i == 2) {
				msg = Messages.getString("Login.210"); //$NON-NLS-1$
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
			int i_16_ = -1;
			String string = Messages.getString("Login.211"); //$NON-NLS-1$
			try {
				socket = new Socket(servers[0], 7061);
				din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				dout = new PrintWriter(socket.getOutputStream(), true);
				dout.println(new StringBuilder().append(Messages.getString("Login.212")).append(gs.tnick.getText()).append(Messages.getString("Login.213")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(gs.tpass.getText()).append(Messages.getString("Login.214")).toString()); //$NON-NLS-1$
				string = din.readLine();
				if (string != null) {
					i = getvalue(string, 0);
					if (i == 0 || i == 3 || i > 10 || i == -167) {
						xt.nickey = getSvalue(string, 1);
						if (i != -167) {
							xt.clan = getSvalue(string, 2);
							xt.clankey = getSvalue(string, 3);
						} else {
							xt.clan = Messages.getString("Login.215"); //$NON-NLS-1$
							xt.clankey = Messages.getString("Login.216"); //$NON-NLS-1$
							i_16_ = getvalue(string, 2);
							xt.hours = getvalue(string, 3);
						}
					}
				}
				socket.close();
				din.close();
				dout.close();
			} catch (final Exception exception) {
				/* empty */
			}
			gs.tnick.enable();
			gs.tpass.enable();
			gs.keplo.enable();
			if (i == -1) {
				msg = Messages.getString("Login.217"); //$NON-NLS-1$
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
				btroom = false;
				xt.logged = true;
				xt.gotlog = true;
				if (i == 0)
					xt.acexp = 0;
				if (i > 10)
					xt.acexp = i - 10;
				if (i == 3)
					xt.acexp = -1;
				if (i == -167) {
					xt.logged = false;
					if (i_16_ != -1)
						xt.nfreeplays = 0;
				}
				if (xt.logged)
					xt.backlog = xt.nickname;
				fase = 12;
				justlog = true;
				checknotifcations();
				System.gc();
			}
			if (i == 1) {
				msg = Messages.getString("Login.218"); //$NON-NLS-1$
				gs.tnick.setForeground(new Color(255, 0, 0));
				gs.tnick.requestFocus();
				errcnt = 40;
				fase = 3;
			}
			if (i == 2) {
				msg = Messages.getString("Login.219"); //$NON-NLS-1$
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
				dout.println(new StringBuilder().append(Messages.getString("Login.220")).append(gs.temail.getText().toLowerCase()).append(Messages.getString("Login.221")) //$NON-NLS-1$ //$NON-NLS-2$
						.toString());
				final String string = din.readLine();
				if (string != null)
					i = getvalue(string, 0);
				socket.close();
				din.close();
				dout.close();
			} catch (final Exception exception) {
				/* empty */
			}
			gs.temail.enable();
			if (i == -1) {
				msg = Messages.getString("Login.222"); //$NON-NLS-1$
				fase = 7;
			}
			if (i == 0) {
				showtf = false;
				gs.temail.setVisible(false);
				msg = new StringBuilder().append(Messages.getString("Login.223")).append(gs.temail.getText()) //$NON-NLS-1$
						.append(Messages.getString("Login.224")).toString(); //$NON-NLS-1$
				gs.temail.setText(Messages.getString("Login.225")); //$NON-NLS-1$
				gs.tnick.setText(Messages.getString("Login.226")); //$NON-NLS-1$
				gs.tpass.setText(Messages.getString("Login.227")); //$NON-NLS-1$
				fase = 3;
			}
			if (i == 1) {
				msg = Messages.getString("Login.228"); //$NON-NLS-1$
				gs.temail.setForeground(new Color(255, 0, 0));
				errcnt = 40;
				fase = 7;
			}
			gs.setCursor(new Cursor(0));
		}
		if ((fase == 12 || fase == 13 || fase == 14 || fase == 15) && !socketson) {
			for (int i = 0; i < nservers; i++)
				try {
					serverdone[i] = -1;
					IPAddress[i] = InetAddress.getByName(servers[i]);
					dSocket[i] = new DatagramSocket(7001 + i);
				} catch (final Exception exception) {
					serverdone[i] = 5;
				}
			srvtrn = 0;
			socketson = true;
		}
		while (fase == 12 || fase == 13 || fase == 14 || fase == 15) {
			if (srvtrn < nservers) {
				for (/**/ ; serverdone[srvtrn] < xt.cntptrys; serverdone[srvtrn]++) {
					if (serverdone[srvtrn] == -1)
						serverdone[srvtrn] = 0;
					Date date = new Date();
					servestart[srvtrn] = date.getTime();
					try {
						final byte[] is = new byte[4];
						final DatagramPacket datagrampacket = new DatagramPacket(is, is.length, IPAddress[srvtrn],
								7000);
						final String string = new StringBuilder().append(Messages.getString("Login.229")).append(xt.nickname).append(Messages.getString("Login.230")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						final byte[] is_17_ = string.getBytes();
						datagrampacket.setData(is_17_);
						dSocket[srvtrn].send(datagrampacket);
						dSocket[srvtrn].receive(datagrampacket);
						final String string_18_ = new String(datagrampacket.getData());
						if (string_18_.startsWith(Messages.getString("Login.231"))) { //$NON-NLS-1$
							date = new Date();
							if (date.getTime() - servestart[srvtrn] < xt.delays[srvtrn])
								xt.delays[srvtrn] = (int) (date.getTime() - servestart[srvtrn]);
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
					/* empty */
				}
				Thread.sleep(5L);
			} catch (final InterruptedException interruptedexception) {
				/* empty */
			}
		}
		if (fase != 12 && fase != 13 && fase != 14 && fase != 15 && fase != 5 && socketson) {
			for (int i = 0; i < nservers; i++)
				try {
					dSocket[i].close();
					dSocket[i] = null;
				} catch (final Exception exception) {
					/* empty */
				}
			socketson = false;
		}
		if (fase == 16 || fase == 17) {
			boolean bool = false;
			int i = 0;
			int i_20_ = -1;
			recom = 0;
			try {
				socket = new Socket(xt.server, 7067);
				din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				dout = new PrintWriter(socket.getOutputStream(), true);
			} catch (final Exception exception) {
				/* empty */
			}
			while ((fase == 16 || fase == 17) && i != 3) {
				String string = Messages.getString("Login.232"); //$NON-NLS-1$
				if (!bool) {
					try {
						dout.println(Messages.getString("Login.233")); //$NON-NLS-1$
						final String string_21_ = din.readLine();
						if (string_21_ == null)
							bool = true;
						else
							string = string_21_;
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
							/* empty */
						}
						try {
							socket = new Socket(xt.server, 7067);
							din = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							dout = new PrintWriter(socket.getOutputStream(), true);
							dout.println(Messages.getString("Login.234")); //$NON-NLS-1$
							final String string_22_ = din.readLine();
							if (string_22_ != null)
								bool = false;
							else
								string = string_22_;
						} catch (final Exception exception) {
							bool = true;
						}
					}
					if (bool)
						try {
							socket.close();
							socket = null;
						} catch (final Exception exception) {
							/* empty */
						}
				}
				if (!bool) {
					for (int i_23_ = 0; i_23_ < 5; i_23_++) {
						rmps[i_23_] = getvalue(string, i_23_ * 2);
						rmwt[i_23_] = getvalue(string, 1 + i_23_ * 2);
					}
					int i_24_ = 1000;
					for (int i_25_ = 0; i_25_ < 5; i_25_++)
						if (Math.abs(rmps[i_25_] - 6) < i_24_) {
							recom = i_25_;
							i_24_ = Math.abs(rmps[i_25_] - 6);
						}
					if (recom != i_20_) {
						opselect = recom;
						i_20_ = recom;
					}
					if (fase == 16)
						fase = 17;
				} else {
					msg = Messages.getString("Login.235"); //$NON-NLS-1$
					i++;
				}
				if (i != 3)
					try {
						if (connector != null) {
							/* empty */
						}
						Thread.sleep(2000L);
					} catch (final InterruptedException interruptedexception) {
						/* empty */
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
				/* empty */
			}
			if (i == 3)
				resofaso = true;
		}
	}

	public void stopallnow() {
		if (connector != null) {
			connector.stop();
			connector = null;
		}
		endcons();
	}

	public void stringbutton(final String string, final int i, final int i_60_, final int i_61_) {
		rd.setFont(new Font(Messages.getString("Login.236"), 1, 12)); //$NON-NLS-1$
		ftm = rd.getFontMetrics();
		bx[btn] = i;
		by[btn] = i_60_ - 5;
		bw[btn] = ftm.stringWidth(string);
		if (!pessd[btn]) {
			rd.setColor(color2k(220, 220, 220));
			rd.fillRect(i - bw[btn] / 2 - 10, i_60_ - (17 - i_61_), bw[btn] + 20, 25 - i_61_ * 2);
			rd.setColor(color2k(240, 240, 240));
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ - (17 - i_61_), i + bw[btn] / 2 + 10, i_60_ - (17 - i_61_));
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ - (18 - i_61_), i + bw[btn] / 2 + 10, i_60_ - (18 - i_61_));
			rd.drawLine(i - bw[btn] / 2 - 9, i_60_ - (19 - i_61_), i + bw[btn] / 2 + 9, i_60_ - (19 - i_61_));
			rd.setColor(color2k(200, 200, 200));
			rd.drawLine(i + bw[btn] / 2 + 10, i_60_ - (17 - i_61_), i + bw[btn] / 2 + 10, i_60_ + 7 - i_61_);
			rd.drawLine(i + bw[btn] / 2 + 11, i_60_ - (17 - i_61_), i + bw[btn] / 2 + 11, i_60_ + 7 - i_61_);
			rd.drawLine(i + bw[btn] / 2 + 12, i_60_ - (16 - i_61_), i + bw[btn] / 2 + 12, i_60_ + 6 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ + 7 - i_61_, i + bw[btn] / 2 + 10, i_60_ + 7 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ + 8 - i_61_, i + bw[btn] / 2 + 10, i_60_ + 8 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 9, i_60_ + 9 - i_61_, i + bw[btn] / 2 + 9, i_60_ + 9 - i_61_);
			rd.setColor(color2k(240, 240, 240));
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ - (17 - i_61_), i - bw[btn] / 2 - 10, i_60_ + 7 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 11, i_60_ - (17 - i_61_), i - bw[btn] / 2 - 11, i_60_ + 7 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 12, i_60_ - (16 - i_61_), i - bw[btn] / 2 - 12, i_60_ + 6 - i_61_);
			rd.setColor(new Color(0, 0, 0));
			rd.drawString(string, i - bw[btn] / 2, i_60_);
		} else {
			rd.setColor(color2k(210, 210, 210));
			rd.fillRect(i - bw[btn] / 2 - 10, i_60_ - (17 - i_61_), bw[btn] + 20, 25 - i_61_ * 2);
			rd.setColor(color2k(200, 200, 200));
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ - (17 - i_61_), i + bw[btn] / 2 + 10, i_60_ - (17 - i_61_));
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ - (18 - i_61_), i + bw[btn] / 2 + 10, i_60_ - (18 - i_61_));
			rd.drawLine(i - bw[btn] / 2 - 9, i_60_ - (19 - i_61_), i + bw[btn] / 2 + 9, i_60_ - (19 - i_61_));
			rd.drawLine(i + bw[btn] / 2 + 10, i_60_ - (17 - i_61_), i + bw[btn] / 2 + 10, i_60_ + 7 - i_61_);
			rd.drawLine(i + bw[btn] / 2 + 11, i_60_ - (17 - i_61_), i + bw[btn] / 2 + 11, i_60_ + 7 - i_61_);
			rd.drawLine(i + bw[btn] / 2 + 12, i_60_ - (16 - i_61_), i + bw[btn] / 2 + 12, i_60_ + 6 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ + 7 - i_61_, i + bw[btn] / 2 + 10, i_60_ + 7 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ + 8 - i_61_, i + bw[btn] / 2 + 10, i_60_ + 8 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 9, i_60_ + 9 - i_61_, i + bw[btn] / 2 + 9, i_60_ + 9 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 10, i_60_ - (17 - i_61_), i - bw[btn] / 2 - 10, i_60_ + 7 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 11, i_60_ - (17 - i_61_), i - bw[btn] / 2 - 11, i_60_ + 7 - i_61_);
			rd.drawLine(i - bw[btn] / 2 - 12, i_60_ - (16 - i_61_), i - bw[btn] / 2 - 12, i_60_ + 6 - i_61_);
			rd.setColor(new Color(0, 0, 0));
			rd.drawString(string, i - bw[btn] / 2 + 1, i_60_);
		}
		btn++;
	}
}