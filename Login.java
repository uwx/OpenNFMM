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
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Date;

public class Login implements Runnable {
	Graphics2D rd;
	xtGraphics xt;
	Medium m;
	FontMetrics ftm;
	ImageObserver ob;
	GameSparker gs;
	int nmsgs = 0;
	int nconf = 0;
	int nfreq = 0;
	int ncreq = 0;
	int fclan = 0;
	int fplayer = 0;
	String clanapv = "";
	boolean justlog = false;
	int cntgame = 0;
	int gamec = -1;
	int groom = 0;
	String gmaker = "";
	String gservern = "";
	Thread connector;
	int fase = 0;
	Socket socket;
	BufferedReader din;
	PrintWriter dout;
	boolean[] pessd = {
		false, false, false, false, false, false
	};
	int[] bx = {
		0, 0, 0, 0, 0, 0
	};
	int[] by = {
		0, 0, 0, 0, 0, 0
	};
	int[] bw = {
		0, 0, 0, 0, 0, 0
	};
	int btn = 0;
	int nflk = 0;
	int ncnt = 0;
	int errcnt = 0;
	int lrgfase = 0;
	String msg = "";
	String lnick = "";
	String lpass = "";
	String lemail = "";
	boolean onf = false;
	boolean nickero = false;
	boolean jflk = false;
	boolean ond = false;
	int opselect = 0;
	int trans = 0;
	int cntcl = 0;
	boolean contrb = false;
	int nservers = 2;
	String[] servers = {
		"multiplayer.needformadness.com", "avenger.needformadness.com",
			"ghostrider.needformadness.com"
	};
	InetAddress[] IPAddress = new InetAddress[3];
	DatagramSocket[] dSocket = new DatagramSocket[3];
	int[] serverdone = {
		-1, -1, -1
	};
	long[] servestart = {
		0L, 0L, 0L
	};
	String[] snames = {
		"Dominion", "Avenger", "Ghostrider"
	};
	boolean socketson = false;
	int srvtrn = 0;
	int[] rmps = {
		0, 0, 0, 0, 0
	};
	int[] rmwt = {
		0, 0, 0, 0, 0
	};
	int recom = 0;
	boolean resofaso = false;
	boolean checknote = false;
	int pend = 0;
	boolean pendb = false;
	boolean gotcai = false;
	int cax = 0;
	int cay = 0;
	boolean btroom = false;
	boolean showtf = false;
	int[] bgmy = {
		0, 400, 800
	};
	int flipo = 0;
	int xrl = 0;
	int xrr = 0;
	boolean onr = false;
	int oxm = 0;
	int oym = 0;
	int lxm = 0;
	int lym = 0;

	public Login(Medium medium, Graphics2D graphics2d,
	xtGraphics var_xtGraphics, GameSparker gamesparker) {
		this.m = medium;
		this.rd = graphics2d;
		this.xt = var_xtGraphics;
		this.gs = gamesparker;
		if ((this.xt).playingame != -1)
		this.fase = 18;
		if ((this.xt).nofull)
		this.nservers = 1;
	}

	public void inishmulti() {
		(this.gs).tnick.hide();
		(this.gs).tnick.enable();
		(this.gs).tnick.setForeground(new Color(0, 0,
		0));
		(this.gs).tnick.setBackground(color2k(240, 240,
		240));
		(this.gs).tpass.hide();
		(this.gs).tpass.enable();
		(this.gs).tpass.setForeground(new Color(0, 0,
		0));
		(this.gs).tpass.setBackground(color2k(240, 240,
		240));
		(this.gs).temail.hide();
		(this.gs).temail.enable();
		(this.gs).temail.setForeground(new Color(0, 0,
		0));
		(this.gs).temail.setBackground(color2k(240, 240, 240));
		(this.gs).keplo.hide();
		(this.gs).keplo.enable();
		(this.gs).keplo.setForeground(new Color(0, 0,
		0));
		(this.gs).keplo.setBackground(new Color(193, 181, 142));
		this.gs.requestFocus();
		if ((this.gs).tnick.getText().equals(""))
		(this.gs).tnick.setText("Nickname");
		for (int i = 0; i < 6; i++)
		this.pessd[i] = false;
		this.nflk = 0;
		this.ncnt = 0;
		this.errcnt = 0;
		this.onf = false;
		this.ond = false;
		this.msg = "";
		this.btroom = false;
		this.gotcai = false;
		(this.m).crs = true;
		(this.m).x = -335;
		(this.m).y = 0;
		(this.m).z = -50;
		(this.m).xz = 0;
		(this.m).zy = 20;
		(this.m).ground = -2000;
		this.pend = 0;
		this.pendb = false;
		this.resofaso = false;
		for (int i = 0; i < this.nservers; i++) {
			this.serverdone[i] = -1;
			this.servestart[i] = 0L;
		}
		this.checknote = false;
		if ((this.xt).gotlog) {
			this.checknote = true;
			this.socketson = false;
			this.fase = 12;
			this.connector = new Thread(this);
			this.connector.start();
		} else {
			this.msg = "Login to access the multiplayer madness!";
			(this.gs).tnick.setText((this.xt).nickname);
			this.fase = 3;
		}
	}

	public void exitfromlobby() {
		if (!(this.xt).lan)
		this.opselect = 0;
		else this.opselect = 1;
		for (int i = 0; i < this.nservers; i++) {
			this.serverdone[i] = -1;
			this.servestart[i] = 0L;
		}
		for (int i = 0; i < 6; i++)
		this.pessd[i] = false;
		this.gotcai = false;
		this.btroom = false;
		(this.m).crs = true;
		(this.m).x = -335;
		(this.m).y = 0;
		(this.m).z = -50;
		(this.m).xz = 0;
		(this.m).zy = 20;
		(this.m).ground = -2000;
		this.pend = 0;
		this.pendb = false;
		this.gamec = -1;
		this.socketson = false;
		this.fase = 12;
		System.gc();
		this.connector = new Thread(this);
		this.connector.start();
	}

	public void endcons() {
		for (int i = 0; i < this.nservers; i++) {
			try {
				this.dSocket[i].close();
				this.dSocket[i] = null;
			} catch (Exception exception) {
				/* empty */
			}
		}
		try {
			this.socket.close();
			this.socket = null;
			this.din.close();
			this.din = null;
			this.dout.close();
			this.dout = null;
		} catch (Exception exception) {
			/* empty */
		}
	}

	public void checknotifcations() {}
	
	public void gamealert() {
		try {
			this.socket = new Socket(this.servers[0], 7061);
			this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.dout = new PrintWriter(this.socket.getOutputStream(),
			true);
			this.dout.println(new StringBuilder().append("101|20|").append((this.xt).nickname).append("|").append((this.xt).nickey).append("|").append((this.xt).servername).append("|").append((this.xt).servport - 7070).append("|").toString());
			String string = this.din.readLine();
			this.socket.close();
			this.din.close();
			this.dout.close();
		} catch (Exception exception) {
			/* empty */
		}
	}

	public void checkgamealerts() {
		try {
			this.socket = new Socket(this.servers[0], 7061);
			this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.dout = new PrintWriter(this.socket.getOutputStream(),
			true);
			this.dout.println("101|21|");
			String string = this.din.readLine();
			if (string != null) {
				int i = getvalue(string, 0);
				if (i != -1 && i != this.gamec) {
					String string_12_ = getSvalue(string, 2);
					int i_13_ = getvalue(string, 3);
					boolean bool = false;
					if (!string_12_.equals((this.xt)
						.servername) || i_13_ != ((this.xt).servport - 7070)) {
						for (int i_14_ = 0; i_14_ < this.nservers;
						i_14_++) {
							if (string_12_.equals(this.snames[i_14_]) && ((this.xt).delays[i_14_]) < 300) bool = true;
						}
					}
					if (bool) {
						this.gmaker = getSvalue(string, 1);
						if (this.gmaker.equals((
						this.xt)
							.nickname))
						this.gmaker = "You";
						this.groom = i_13_;
						this.gservern = string_12_;
						this.gamec = i;
						this.cntgame = 0;
					}
				}
			}
			this.socket.close();
			this.din.close();
			this.dout.close();
		} catch (Exception exception) {
			/* empty */
		}
	}

	public void run() {
		if (this.checknote) {
			checknotifcations();
			this.checknote = false;
		}
		if (this.fase == 2) {
			this.gs.setCursor(new Cursor(3));
			int i = -1;
			int i_15_ = -1;
			try {
				this.socket = new Socket(this.servers[0], 7061);
				this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
				this.dout = new PrintWriter(this.socket.getOutputStream(),
				true);
				this.dout.println(new StringBuilder().append("0|").append((
				this.gs)
					.tnick.getText())
					.append("|").toString());
				String string = this.din.readLine();
				if (string != null) {
					i = getvalue(string, 0);
					if (i == 0) {
						i_15_ = getvalue(string, 1);
						(this.xt).hours = getvalue(string, 2);
						(this.xt).nickey = getSvalue(string, 3);
					}
				}
				this.socket.close();
				this.din.close();
				this.dout.close();
			} catch (Exception exception) {
				/* empty */
			}
			(this.gs).tnick.enable();
			if (i == -1) {
				this.msg = "Unable to connect to any server at this moment.  Please try again later.";
				this.fase = 1;
			}
			if (i == 0) {
				(this.xt).nickname = (this.gs).tnick.getText();
				if (i_15_ != -1)
				(this.xt).nfreeplays = 0;
				(this.gs).tnick.hide();
				(this.gs).tpass.hide();
				(this.gs).temail.hide();
				(this.gs).keplo.hide();
				this.gs.requestFocus();
				(this.xt).logged = false;
				this.fase = 12;
				System.gc();
			}
			if (i == 1) {
				this.msg = "This Nickname is being used by someone else right now.  Please use another.";
				this.nickero = true;
				(this.gs).tnick.setForeground(new Color(255, 0, 0));
				(this.gs).tnick.requestFocus();
				this.errcnt = 30;
				this.fase = 1;
			}
			if (i == 2) {
				this.msg = "Nickname registerd.  Please use another or click 'Login' bellow to login to this Nickname.";
				this.nickero = true;
				(this.gs).tnick.setForeground(new Color(255, 0, 0));
				(this.gs).tnick.requestFocus();
				this.errcnt = 30;
				this.fase = 1;
			}
			this.gs.setCursor(new Cursor(0));
		}
		if (this.fase == 4) {
			this.gs.setCursor(new Cursor(3));
			int i = -1;
			int i_16_ = -1;
			String string = "";
			try {
				this.socket = new Socket(this.servers[0], 7061);
				this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
				this.dout = new PrintWriter(this.socket.getOutputStream(),
				true);
				this.dout.println(new StringBuilder().append("1|").append((this.gs).tnick.getText())
					.append("|").append((this.gs).tpass.getText())
					.append("|").toString());
				string = this.din.readLine();
				if (string != null) {
					i = getvalue(string, 0);
					if (i == 0 || i == 3 || i > 10 || i == -167) {
						(this.xt).nickey = getSvalue(string, 1);
						if (i != -167) {
							(this.xt).clan = getSvalue(string, 2);
							(this.xt).clankey = getSvalue(string, 3);
						} else {
							(this.xt).clan = "";
							(this.xt).clankey = "";
							i_16_ = getvalue(string, 2);
							(this.xt).hours = getvalue(string, 3);
						}
					}
				}
				this.socket.close();
				this.din.close();
				this.dout.close();
			} catch (Exception exception) {
				/* empty */
			}
			(this.gs).tnick.enable();
			(this.gs).tpass.enable();
			(this.gs).keplo.enable();
			if (i == -1) {
				this.msg = "Unable to connect to server at this moment.  Please try again later.";
				this.fase = 3;
			}
			if (i == 0 || i == 3 || i > 10 || i == -167 || i == 111) {
				(this.xt).nickname = (this.gs).tnick.getText();
				this.showtf = false;
				(this.gs).tnick.hide();
				(this.gs).tpass.hide();
				(this.gs).temail.hide();
				(this.gs).keplo.hide();
				this.gs.requestFocus();
				this.gs.setloggedcookie();
				this.btroom = false;
				(this.xt).logged = true;
				(this.xt).gotlog = true;
				if (i == 0)
				(this.xt).acexp = 0;
				if (i > 10)
				(this.xt).acexp = i - 10;
				if (i == 3)
				(this.xt).acexp = -1;
				if (i == -167) {
					(this.xt).logged = false;
					if (i_16_ != -1)
					(this.xt).nfreeplays = 0;
				}
				if ((this.xt).logged)
				(this.xt).backlog = (this.xt).nickname;
				this.fase = 12;
				this.justlog = true;
				checknotifcations();
				System.gc();
			}
			if (i == 1) {
				this.msg = "Sorry.  The Nickname you have entered is incorrect or does not exist.";
				(this.gs).tnick.setForeground(new Color(255, 0, 0));
				(this.gs).tnick.requestFocus();
				this.errcnt = 40;
				this.fase = 3;
			}
			if (i == 2) {
				this.msg = "Sorry.  The Password you have entered is incorrect.";
				(this.gs).tpass.setForeground(new Color(255, 0, 0));
				(this.gs).tpass.requestFocus();
				this.errcnt = 40;
				this.fase = 3;
			}
			this.gs.setCursor(new Cursor(0));
		}
		if (this.fase == 8) {
			this.gs.setCursor(new Cursor(3));
			int i = -1;
			try {
				this.socket = new Socket(this.servers[0], 7061);
				this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
				this.dout = new PrintWriter(this.socket.getOutputStream(),
				true);
				this.dout.println(new StringBuilder().append("2|").append((
				this.gs)
					.temail.getText().toLowerCase())
					.append("|").toString());
				String string = this.din.readLine();
				if (string != null) i = getvalue(string, 0);
				this.socket.close();
				this.din.close();
				this.dout.close();
			} catch (Exception exception) {
				/* empty */
			}
			(this.gs).temail.enable();
			if (i == -1) {
				this.msg = "Unable to connect to server at this moment.  Please try again later.";
				this.fase = 7;
			}
			if (i == 0) {
				this.showtf = false;
				(this.gs).temail.hide();
				this.msg = new StringBuilder().append("Please check your Email: ").append((this.gs).temail.getText())
					.append(" to login.").toString();
				(this.gs).temail.setText("");
				(this.gs).tnick.setText("");
				(this.gs).tpass.setText("");
				this.fase = 3;
			}
			if (i == 1) {
				this.msg = "Sorry.  This Email Address does not exist in our system!";
				(this.gs).temail.setForeground(new Color(255, 0, 0));
				this.errcnt = 40;
				this.fase = 7;
			}
			this.gs.setCursor(new Cursor(0));
		}
		if ((this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) && !this.socketson) {
			for (int i = 0; i < this.nservers; i++) {
				try {
					this.serverdone[i] = -1;
					this.IPAddress[i] = InetAddress.getByName(this.servers[i]);
					this.dSocket[i] = new DatagramSocket(7001 + i);
				} catch (Exception exception) {
					this.serverdone[i] = 5;
				}
			}
			this.srvtrn = 0;
			this.socketson = true;
		}
		while (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
			if (this.srvtrn < this.nservers) {
				for (/**/ ;
				(this.serverdone[this.srvtrn] < (this.xt).cntptrys);
				this.serverdone[this.srvtrn]++) {
					if (this.serverdone[this.srvtrn] == -1)
					this.serverdone[this.srvtrn] = 0;
					Date date = new Date();
					this.servestart[this.srvtrn] = date.getTime();
					try {
						byte[] is = new byte[4];
						DatagramPacket datagrampacket = new DatagramPacket(is, is.length, (this.IPAddress[this.srvtrn]),
						7000);
						String string = new StringBuilder().append("").append((this.xt).nickname)
							.append("|").toString();
						byte[] is_17_ = string.getBytes();
						datagrampacket.setData(is_17_);
						this.dSocket[this.srvtrn].send(datagrampacket);
						this.dSocket[this.srvtrn].receive(datagrampacket);
						String string_18_ = new String(datagrampacket.getData());
						if (string_18_.startsWith("OK")) {
							date = new Date();
							if (date.getTime() - (this.servestart[this.srvtrn]) < (long)((this.xt)
								.delays[this.srvtrn]))
							(this.xt).delays[this.srvtrn] = (int)(date.getTime() - (this.servestart[this.srvtrn]));
						}
					} catch (Exception exception) {
						(this.xt).delays[(this
							.srvtrn)] = 6000;
						this.serverdone[this.srvtrn] = 5;
					}
				}
				this.srvtrn++;
			}
			try {
				if (this.connector != null) {
					/* empty */
				}
				Thread.sleep(5L);
			} catch (InterruptedException interruptedexception) {
				/* empty */
			}
		}
		if (this.fase != 12 && this.fase != 13 && this.fase != 14 && this.fase != 15 && this.fase != 5 && this.socketson) {
			for (int i = 0; i < this.nservers; i++) {
				try {
					this.dSocket[i].close();
					this.dSocket[i] = null;
				} catch (Exception exception) {
					/* empty */
				}
			}
			this.socketson = false;
		}
		if (this.fase == 16 || this.fase == 17) {
			boolean bool = false;
			int i = 0;
			int i_20_ = -1;
			this.recom = 0;
			try {
				this.socket = new Socket((this.xt).server,
				7067);
				this.din = (new BufferedReader(new InputStreamReader(this.socket.getInputStream())));
				this.dout = new PrintWriter(this.socket.getOutputStream(),
				true);
			} catch (Exception exception) {
				/* empty */
			}
			while ((this.fase == 16 || this.fase == 17) && i != 3) {
				String string = "";
				if (!bool) {
					try {
						this.dout.println("10|");
						String string_21_ = this.din.readLine();
						if (string_21_ == null) bool = true;
						else string = string_21_;
					} catch (Exception exception) {
						bool = true;
					}
					if (bool) {
						try {
							this.socket.close();
							this.socket = null;
							this.din.close();
							this.din = null;
							this.dout.close();
							this.dout = null;
						} catch (Exception exception) {
							/* empty */
						}
						try {
							this.socket = new Socket(((this.xt)
								.server),
							7067);
							this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
							this.dout = new PrintWriter(this.socket.getOutputStream(),
							true);
							this.dout.println("10|");
							String string_22_ = this.din.readLine();
							if (string_22_ != null) bool = false;
							else string = string_22_;
						} catch (Exception exception) {
							bool = true;
						}
					}
					if (bool) {
						try {
							this.socket.close();
							this.socket = null;
						} catch (Exception exception) {
							/* empty */
						}
					}
				}
				if (!bool) {
					for (int i_23_ = 0; i_23_ < 5; i_23_++) {
						this.rmps[i_23_] = getvalue(string, i_23_ * 2);
						this.rmwt[i_23_] = getvalue(string, 1 + i_23_ * 2);
					}
					int i_24_ = 1000;
					for (int i_25_ = 0; i_25_ < 5; i_25_++) {
						if (Math.abs(this.rmps[i_25_] - 6) < i_24_) {
							this.recom = i_25_;
							i_24_ = Math.abs(this.rmps[i_25_] - 6);
						}
					}
					if (this.recom != i_20_) {
						this.opselect = this.recom;
						i_20_ = this.recom;
					}
					if (this.fase == 16)
					this.fase = 17;
				} else {
					this.msg = "Failed to connect to this Server!";
					i++;
				}
				if (i != 3) {
					try {
						if (this.connector != null) {
							/* empty */
						}
						Thread.sleep(2000L);
					} catch (InterruptedException interruptedexception) {
						/* empty */
					}
				}
			}
			try {
				this.socket.close();
				this.socket = null;
				this.din.close();
				this.din = null;
				this.dout.close();
				this.dout = null;
			} catch (Exception exception) {
				/* empty */
			}
			if (i == 3)
			this.resofaso = true;
		}
	}

	public void stopallnow() {
		if (this.connector != null) {
			this.connector.stop();
			this.connector = null;
		}
		endcons();
	}

	public void multimode(ContO[] contos) {
		this.btn = 0;
		this.xt.mainbg(4);
		for (int i = 0; i < 3; i++) {
			this.rd.drawImage(((this.xt)
				.bgmain),
			65, this.bgmy[i], null);
			this.bgmy[i] -= 4;
			if (this.bgmy[i] <= -400)
			this.bgmy[i] = 800;
		}
		this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
		this.rd.drawImage((this.xt).bggo, 0,
		0, null);
		this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(65, 425, 670, 25);
		this.rd.fillRect(0, 0, 65, 450);
		this.rd.fillRect(735, 0, 65, 450);
		float f = 1.0F - (float)(this.flipo - 10) / 80.0F;
		if (f > 1.0F) f = 1.0F;
		if (f < 0.0F) f = 0.0F;
		this.rd.setComposite(AlphaComposite.getInstance(3, f));
		if (this.flipo > 10)
		this.rd.drawImage(((this.xt)
			.logomadnes),
		96 + (int)(2.0 - Math.random() * 4.0),
		11 + (int)(2.0 - Math.random() * 4.0),
		null);
		else this.rd.drawImage(((this.xt)
			.logomadnes),
		96, 11, null);
		this.flipo++;
		if (this.flipo > 50)
		this.flipo = 0;
		this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		drawSbutton((this.xt).exit, 690, 17);
		this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
		this.rd.setColor(new Color(203, 227, 253));
		this.rd.fillRoundRect(319, 83, 180, 96, 20, 20);
		this.rd.fillRoundRect(173, 83, 132, 32, 20, 20);
		this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		this.rd.setColor(color2k(90, 90, 90));
		this.rd.drawRoundRect(319, 83, 180, 96, 20, 20);
		this.rd.drawRoundRect(173, 83, 132, 32, 20, 20);
		if (!this.gotcai) {
			int i = (((contos[((this.xt)
				.sc[0])]).p[0])
				.oz[0]);
			int i_26_ = i;
			int i_27_ = (((contos[((this.xt)
				.sc[0])]).p[0])
				.oy[0]);
			int i_28_ = i_27_;
			for (int i_29_ = 0;
			(i_29_ < ((contos[(this.xt).sc[0]])
				.npl));
			i_29_++) {
				for (int i_30_ = 0;
				i_30_ < (
				(contos[((this.xt)
					.sc[0])]).p[i_29_]).n;
				i_30_++) {
					if ((
					(contos[((this.xt).sc[0])]).p[i_29_]).oz[i_30_] < i) i = (
					(contos[((this.xt)
						.sc[0])]).p[i_29_]).oz[i_30_];
					if ((
					(contos[((this.xt).sc[0])]).p[i_29_]).oz[i_30_] > i_26_) i_26_ = (((contos[((
					this.xt)
						.sc[0])]).p[i_29_])
						.oz[i_30_]);
					if ((
					(contos[((this.xt).sc[0])]).p[i_29_]).oy[i_30_] < i_27_) i_27_ = (((contos[((
					this.xt)
						.sc[0])]).p[i_29_])
						.oy[i_30_]);
					if ((
					(contos[((this.xt).sc[0])]).p[i_29_]).oy[i_30_] > i_28_) i_28_ = (((contos[((
					this.xt)
						.sc[0])]).p[i_29_])
						.oy[i_30_]);
				}
			}
			this.cax = (i_26_ + i) / 2;
			this.cay = (i_28_ + i_27_) / 2;
			this.gotcai = true;
		}
		(contos[(this.xt).sc[0]]).z = 1500;
		(contos[(this.xt).sc[0]]).y = 380 - this.cay;
		(contos[(this.xt).sc[0]]).x = 100 - this.cax;
		(contos[(this.xt).sc[0]]).zy = 0;
		(contos[(this.xt).sc[0]]).xz = -90;
		(contos[(this.xt).sc[0]]).xy = this.pend;
		this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_OFF);
		contos[(this.xt).sc[0]].d(this.rd);
		this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		if (!this.pendb) {
			this.pend += 2;
			if (this.pend > 80)
			this.pendb = true;
		} else {
			this.pend -= 2;
			if (this.pend < -10)
			this.pendb = false;
		}
		this.rd.setFont(new Font("Arial", 1, 13));
		this.ftm = this.rd.getFontMetrics();
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.drawString((this.xt).nickname,
		239 - (this.ftm.stringWidth((this.xt).nickname) / 2),
		105);
		this.rd.setColor(color2k(90, 90, 90));
		this.rd.drawString(new StringBuilder().append("").append(((this.xt).cd).names[(this.xt).sc[0]])
			.append("").toString(),
		409 - (this.ftm.stringWidth(new StringBuilder().append("").append(((this.xt).cd)
			.names[(this.xt).sc[0]])
			.append("").toString())) / 2,
		81);
		this.rd.drawString("Nickname",
		239 - this.ftm.stringWidth("Nickname") / 2,
		81);
		drawbutton((this.xt).change, 570, 98);
		drawSbutton((this.xt).logout, 239, 135);
		this.rd.setColor(new Color(98, 56, 0));
		this.rd.drawString("Edit my Account",
		239 - (this.ftm.stringWidth("Edit my Account") / 2),
		168);
		if (this.ond)
		this.rd.drawLine(239 - this.ftm.stringWidth("Edit my Account") / 2,
		169, (239 - this.ftm.stringWidth("Edit my Account") / 2 + this.ftm.stringWidth("Edit my Account")),
		169);
		if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
			int i = this.srvtrn;
			if (i < this.nservers && this.serverdone[i] != -1) {
				Date date = new Date();
				if (date.getTime() - this.servestart[i] > 1500L) {
					if (this.connector != null) {
						this.connector.stop();
						this.connector = null;
					}
					(this.xt).delays[i] = 600;
					this.serverdone[i] = 5;
					this.connector = new Thread(this);
					this.connector.start();
				}
			}
		}
		if (this.fase == 12) {
			if ((this.xt).acexp == 0 || this.contrb) {
				this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
				this.rd.setColor(new Color(203, 227, 253));
				this.rd.fillRoundRect(205, 225, 390, 120, 20, 20);
				this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
				this.rd.setColor(color2k(90, 90, 90));
				this.rd.drawString("Multiplayer Mode",
				400 - (this.ftm.stringWidth("Multiplayer Mode") / 2),
				220);
				this.rd.drawRoundRect(205, 225, 390, 120, 20, 20);
				drawbutton((this.xt).pln, 400, 285 - xt.pln.getHeight(ob) / 2);
				if (this.opselect == 1 && !this.pessd[4]) {
					this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
					this.rd.setColor(new Color(203, 227, 253));
					this.rd.fillRect(387 - (this.xt).pln.getWidth(this.ob) / 2,
					285 - xt.pln.getHeight(ob) - 5, (this.xt).pln.getWidth(this.ob) + 26,
					26);
					this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
				}
				drawbutton((this.xt).pln, 400, 285 - xt.pln.getHeight(ob) / 2);
			} else {
				this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
				this.rd.setColor(new Color(203, 227, 253));
				this.rd.fillRoundRect(165, 219, 470, 135, 20, 20);
				this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
				this.rd.setColor(color2k(90, 90, 90));
				this.rd.drawRoundRect(165, 219, 470, 135, 20, 20);
				if ((this.xt).acexp > 0) {
					this.rd.setColor(new Color(0, 0, 0));
					this.rd.drawString(new StringBuilder().append("Dear ").append((this.xt).nickname).append(",").toString(),
					185, 245);
					this.rd.drawString(new StringBuilder().append("Your account is due to expire in ").append((this.xt).acexp).append(" days.").toString(),
					185, 265);
					this.rd.drawString("Renew your registration soon!", 185, 295);
					stringbutton("Renew my Account Registration now!", 345,
					332, 0);
					stringbutton("Renew Later", 524, 332, 0);
				}
				if ((this.xt).acexp == -1) {
					this.rd.setColor(new Color(0, 0, 0));
					this.rd.drawString(new StringBuilder().append("Dear ").append((this.xt).nickname).append(",").toString(),
					185, 245);
					this.rd.drawString("Your Need for Madness account registration has expired.",
					185, 265);
					this.rd.drawString("Please renew your registration.", 185, 295);
					stringbutton("Renew my account registration now!", 362,
					332, 0);
					stringbutton("Cancel", 524, 332, 0);
				}
				if ((this.xt).acexp == -2) {
					this.rd.setColor(new Color(0, 0, 0));
					this.rd.drawString(new StringBuilder().append("Dear ").append((this.xt).nickname).append(",").toString(),
					185, 245);
					this.rd.drawString("Trial accounts are not allowed to access the downloaded game.",
					185, 265);
					this.rd.drawString("You can only play the game online using your trial account.",
					185, 295);
					stringbutton("Play the multiplayer online!", 362, 332, 0);
					stringbutton("Cancel", 524, 332, 0);
				}
				if ((this.xt).acexp == -3) {
					this.rd.setColor(new Color(0, 0, 0));
					this.rd.drawString("Some one else is already logged in the game with your account.",
					185, 245);
					this.rd.drawString("If you where just in the game then quitted it suddenly, it could just",
					185, 265);
					this.rd.drawString("be your 'ghost entry', if so please wait a few minutes and try again.",
					185, 285);
					this.rd.drawString("Otherwise please consider changing your password.",
					185, 305);
					stringbutton("Change Password", 332, 336, 0);
					stringbutton("Try Again", 494, 336, 0);
				}
			}
		}
		if (this.fase == 15) {
			if (this.trans < 100)
			this.rd.drawImage((this.xt).pln,
			400 - (this.xt).pln.getWidth(this.ob) / 2,
			315 - ((this.xt).pln.getHeight(this.ob) / 2) - 12 - this.trans,
			null);
			else this.rd.drawImage((this.xt).pln,
			400 - (this.xt).pln.getWidth(this.ob) / 2,
			215 - (this.xt).pln.getHeight(this.ob) / 2 - 12,
			null);
			if (this.trans >= 100) {
				this.rd.setColor(color2k(255, 255, 255));
				this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
				this.rd.setColor(new Color(0, 0, 0));
				this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
				this.rd.setFont(new Font("Arial", 1, 13));
				this.ftm = this.rd.getFontMetrics();
				if ((this.xt).nofull) {
					if (this.nflk % 4 != 0 || this.nflk == 0) {
						this.rd.setFont(new Font("Arial", 1, 13));
						this.ftm = this.rd.getFontMetrics();
						this.rd.setColor(new Color(200, 0, 0));
						this.rd.drawString("Sorry. You did not allow the game full permissions when you started it.",
						175, 242);
						this.rd.setFont(new Font("Arial", 0, 13));
						this.ftm = this.rd.getFontMetrics();
						this.rd.setColor(new Color(0, 0, 0));
						this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).",
						175, 262);
						this.rd.drawString("Because of this the game will not be able to create LAN connections!",
						175, 288);
						this.rd.setFont(new Font("Arial", 1, 13));
						this.ftm = this.rd.getFontMetrics();
						this.rd.drawString("Please restart the game and allow Java full permissions to be able to",
						175, 315);
						this.rd.drawString("play LAN games!", 175,
						332);
						this.rd.setFont(new Font("Arial", 0, 13));
						this.ftm = this.rd.getFontMetrics();
						this.rd.drawString("(Close ALL browser windows including this one then",
						295, 332);
						this.rd.drawString("start the game again but click 'Run' when asked to 'run this application'. )",
						175, 349);
					}
					if (this.nflk != 0)
					this.nflk--;
				} else {
					this.rd.drawString("Play a multiplayer game across your Local Area Network (LAN).",
					179, 245);
					this.rd.drawString("Experience the game live with zero delay and 100% real-time action!",
					179, 262);
					this.rd.setFont(new Font("Arial", 0, 13));
					this.ftm = this.rd.getFontMetrics();
					this.rd.drawString("This is for if there is more then one computer connected to your network or",
					179, 292);
					this.rd.drawString("if you are in a computer lab or in an internet caf\u00e9.",
					179, 309);
					this.rd.drawString("You can also invite your friends to come over with their Laptop PCs or Macs",
					179, 335);
					this.rd.drawString("to log on to your internet connection/network and play with you!",
					179, 352);
				}
				drawbutton((this.xt).cancel, 583, 395);
				drawbutton((this.xt).play, 400, 395);
			} else this.trans += 10;
		}
		if (this.resofaso) {
			this.resofaso = false;
		}
	}

	public void multistart(ContO[] contos, int i, int i_38_, boolean bool) {
		this.btn = 0;
		this.xt.mainbg(4);
		for (int i_39_ = 0; i_39_ < 3; i_39_++) {
			this.rd.drawImage(((this.xt)
				.bgmain),
			65, this.bgmy[i_39_], null);
			this.bgmy[i_39_] -= 4;
			if (this.bgmy[i_39_] <= -400)
			this.bgmy[i_39_] = 800;
		}
		this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
		this.rd.drawImage((this.xt).bggo, 0,
		0, null);
		this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		this.rd.setColor(new Color(0, 0, 0));
		this.rd.fillRect(65, 425, 670, 25);
		this.rd.fillRect(0, 0, 65, 450);
		this.rd.fillRect(735, 0, 65, 450);
		float f = 1.0F - (float)(this.flipo - 10) / 80.0F;
		if (f > 1.0F) f = 1.0F;
		if (f < 0.0F) f = 0.0F;
		this.rd.setComposite(AlphaComposite.getInstance(3, f));
		if (this.flipo > 10)
		this.rd.drawImage(((this.xt)
			.logomadnes),
		96 + (int)(2.0 - Math.random() * 4.0),
		11 + (int)(2.0 - Math.random() * 4.0),
		null);
		else this.rd.drawImage(((this.xt)
			.logomadnes),
		96, 11, null);
		this.flipo++;
		if (this.flipo > 50)
		this.flipo = 0;
		this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		int i_40_ = 0;
		if (i != this.oxm || i_38_ != this.oym) {
			i_40_ = 1;
			this.oxm = i;
			this.oym = i_38_;
		}
		if (bool) i_40_ = 2;
		this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
		this.rd.drawImage(((this.xt).dude[i_40_]),
		87, 76, null);
		this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
		this.rd.drawImage((this.xt).redy, 445,
		153, null);
		// really dirty solution to a very specific bug
		// DO NOT DELETE THE LINE BELOW
		//drawSbutton((this.xt).exit, 690, 17);
		drawSbutton((this.xt).exit, 690, 17);
		this.rd.setFont(new Font("Arial", 1, 13));
		this.ftm = this.rd.getFontMetrics();
		if (this.fase != 5) {
			this.rd.setComposite(AlphaComposite.getInstance(3,
			0.25F));
			this.rd.setColor(new Color(203, 227, 253));
			this.rd.fillRoundRect(246, 83, 180, 96, 20, 20);
			this.rd.setComposite(AlphaComposite.getInstance(3,
			1.0F));
			this.rd.setColor(color2k(90, 90, 90));
			this.rd.drawString(new StringBuilder().append("").append(((this.xt).cd).names[(this.xt).sc[0]])
				.append("").toString(),
			336 - (this.ftm.stringWidth(new StringBuilder().append("").append(((this.xt).cd)
				.names[(this.xt).sc[0]])
				.append("").toString())) / 2,
			81);
			this.rd.drawRoundRect(246, 83, 180, 96, 20, 20);
			if (!this.gotcai) {
				int i_41_ = ((
				(contos[((this.xt)
					.sc[0])]).p[0])
					.oz[0]);
				int i_42_ = i_41_;
				int i_43_ = ((
				(contos[((this.xt)
					.sc[0])]).p[0])
					.oy[0]);
				int i_44_ = i_43_;
				for (int i_45_ = 0;
				i_45_ < (contos[((this.xt)
					.sc[0])]).npl;
				i_45_++) {
					for (int i_46_ = 0;
					(i_46_ < (
					(contos[((this.xt)
						.sc[0])]).p[i_45_]).n);
					i_46_++) {
						if ((
						(contos[((this.xt)
							.sc[0])]).p[i_45_]).oz[i_46_] < i_41_) i_41_ = (
						(
						contos[((this.xt)
							.sc[0])]).p[i_45_]).oz[i_46_];
						if ((
						(contos[((this.xt)
							.sc[0])]).p[i_45_]).oz[i_46_] > i_42_) i_42_ = (
						(
						contos[((this.xt)
							.sc[0])]).p[i_45_]).oz[i_46_];
						if ((
						(contos[((this.xt)
							.sc[0])]).p[i_45_]).oy[i_46_] < i_43_) i_43_ = (
						(
						contos[((this.xt)
							.sc[0])]).p[i_45_]).oy[i_46_];
						if ((
						(contos[((this.xt)
							.sc[0])]).p[i_45_]).oy[i_46_] > i_44_) i_44_ = (
						(
						contos[((this.xt)
							.sc[0])]).p[i_45_]).oy[i_46_];
					}
				}
				this.cax = (i_42_ + i_41_) / 2;
				this.cay = (i_44_ + i_43_) / 2;
				this.gotcai = true;
			}
			(contos[(this.xt).sc[0]]).z = 1500;
			(contos[(this.xt).sc[0]]).y = 380 - this.cay;
			(contos[(this.xt).sc[0]]).x = -170 - this.cax;
			(contos[(this.xt).sc[0]]).zy = 0;
			(contos[(this.xt).sc[0]]).xz = -90;
			(contos[(this.xt).sc[0]]).xy = this.pend;
			this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, (RenderingHints.VALUE_ANTIALIAS_OFF));
			contos[(this.xt).sc[0]].d(this.rd);
			this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, (RenderingHints.VALUE_ANTIALIAS_ON));
			if (!this.pendb) {
				this.pend += 2;
				if (this.pend > 80)
				this.pendb = true;
			} else {
				this.pend -= 2;
				if (this.pend < -10)
				this.pendb = false;
			}
			drawbutton((this.xt).change, 497, 98);
		}
		if (this.fase == 1 || this.fase == 2) {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString(this.msg,
			400 - this.ftm.stringWidth(this.msg) / 2,
			205);
			this.rd.drawString("Enter a Nickname:", (400 - this.ftm.stringWidth("Enter a Nickname:") - 14),
			241);
			if (this.fase == 2) {
				if (this.msg.equals(". . . | Checking Nickname | . . .") && this.ncnt == 0) {
					this.msg = "| Checking Nickname |";
					this.ncnt = 5;
				}
				if (this.msg.equals(". . | Checking Nickname | . .") && this.ncnt == 0) {
					this.msg = ". . . | Checking Nickname | . . .";
					this.ncnt = 5;
				}
				if (this.msg.equals(". | Checking Nickname | .") && this.ncnt == 0) {
					this.msg = ". . | Checking Nickname | . .";
					this.ncnt = 5;
				}
				if (this.msg.equals("| Checking Nickname |") && this.ncnt == 0) {
					this.msg = ". | Checking Nickname | .";
					this.ncnt = 5;
				}
				if (this.ncnt != 0)
				this.ncnt--;
				this.pessd[2] = true;
			}
			if (this.fase == 1 && !(this.gs).tnick.isShowing()) {
				(this.gs).tnick.show();
				(this.gs).tnick.requestFocus();
				if ((this.gs).tnick.getText()
					.equals("Nickname"))
				(this.gs).tnick.select(8, 8);
			}
			if (this.errcnt != 0) {
				this.errcnt--;
				if (this.errcnt == 0)
				(this.gs).tnick.setForeground(new Color(0, 0, 0));
			}
			drawbutton((this.xt).play, 400, 285);
			if (this.nflk > 0) {
				if ((this.gs).tnick.getText()
					.equals("")) {
					(this.gs).tnick.setText("Nickname");
					if (this.nflk == 1)
					(this.gs).tnick.select(8, 8);
				} else(this.gs).tnick.setText("");
				this.nflk--;
			}
			drawbutton((this.xt).login, 400, 340);
			drawbutton((this.xt).register, 400, 395);
			this.gs.movefield(((this.gs)
				.tnick),
			400, 225, 129, 23);
			while (this.ftm.stringWidth((
			this.gs)
				.tnick.getText()) > 86) {
				(this.gs).tnick.setText((this.gs).tnick.getText()
					.substring(0, (this.gs).tnick.getText()
					.length() - 1));
				(this.gs).tnick.select((this.gs).tnick.getText()
					.length(), (this.gs).tnick.getText()
					.length());
			}
			if (!(this.gs).tnick.getText()
				.equals(this.lnick)) {
				fixtext((this.gs).tnick);
				this.lnick = (this.gs).tnick.getText();
			}
			if (this.xt.msgcheck((this.gs)
				.tnick.getText()))
			(this.gs).tnick.setText("");
			if ((this.gs).tnick.getText().toLowerCase().indexOf("madbot") != -1)
			(this.gs).tnick.setText("");
		}
		if (this.fase == 3 || this.fase == 4) {
			this.rd.drawImage((this.xt).ntrg,
			97, 388, null);
			this.rd.setComposite(AlphaComposite.getInstance(3,
			0.25F));
			this.rd.setColor(new Color(203, 227, 253));
			this.rd.fillRoundRect(246, 212, 308, 142, 20, 20);
			this.rd.setComposite(AlphaComposite.getInstance(3,
			1.0F));
			this.rd.setColor(color2k(90, 90, 90));
			this.rd.drawRoundRect(246, 212, 308, 142, 20, 20);
			this.rd.setColor(new Color(0, 0, 0));
			if (this.nflk % 4 != 0 || this.nflk == 0)
			this.rd.drawString(this.msg,
			400 - (this.ftm.stringWidth(this.msg) / 2),
			205);
			if (this.nflk != 0)
			this.nflk--;
			this.rd.drawString("Nickname:",
			376 - this.ftm.stringWidth("Nickname:") - 14, 237);
			this.rd.drawString("Password:",
			376 - this.ftm.stringWidth("Password:") - 14, 267);
			if (this.fase == 4) {
				if (this.msg.equals(". . . | Logging In | . . .") && this.ncnt == 0) {
					this.msg = "| Logging In |";
					this.ncnt = 5;
				}
				if (this.msg.equals(". . | Logging In | . .") && this.ncnt == 0) {
					this.msg = ". . . | Logging In | . . .";
					this.ncnt = 5;
				}
				if (this.msg.equals(". | Logging In | .") && this.ncnt == 0) {
					this.msg = ". . | Logging In | . .";
					this.ncnt = 5;
				}
				if (this.msg.equals("| Logging In |") && this.ncnt == 0) {
					this.msg = ". | Logging In | .";
					this.ncnt = 5;
				}
				if (this.ncnt != 0)
				this.ncnt--;
				this.pessd[2] = true;
			}
			if (this.fase == 3) {
				this.showtf = true;
				if (!(this.gs).applejava) {
					if (!(this.gs).tpass.isShowing()) {
						(this.gs).tpass.show();
						if (!(this.gs).tnick.getText().equals(""))
						(this.gs).tpass.requestFocus();
					}
					if (!(this.gs).tnick.isShowing()) {
						(this.gs).tnick.show();
						if ((this.gs).tnick.getText().equals(""))
						(this.gs).tnick.requestFocus();
					}
				}
			}
			if (this.errcnt != 0) {
				this.errcnt--;
				if (this.errcnt == 0) {
					(this.gs).tpass.setText("");
					(this.gs).tnick.setForeground(new Color(0, 0, 0));
					(this.gs).tpass.setForeground(new Color(0, 0, 0));
				}
			}
			drawbutton((this.xt).login, 400, 315);
			if (this.onf)
			this.rd.setColor(color2k(0, 72, 255));
			else this.rd.setColor(color2k(120, 120, 120));
			this.rd.setFont(new Font("Arial", 1, 11));
			this.ftm = this.rd.getFontMetrics();
			this.rd.drawString("Forgot your nickname or password?",
			400 - (this.ftm.stringWidth("Forgot your nickname or password?") / 2),
			345);
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.setFont(new Font("Arial", 1, 12));
			this.ftm = this.rd.getFontMetrics();
			String string = "Register a full account here!";
			this.xrl = 400 - this.ftm.stringWidth(string) / 2;
			this.xrr = this.xrl + this.ftm.stringWidth(string);
			this.rd.drawString(string, this.xrl, 371);
			this.rd.drawLine(this.xrl, 372, this.xrr, 372);
			drawbutton((this.xt).register, 400, 395);
			this.gs.movefieldd(((this.gs)
				.tnick),
			376, 221, 129, 23, this.showtf);
			if (!(this.gs).tnick.getText()
				.equals(this.lnick)) {
				fixtext((this.gs).tnick);
				this.lnick = (this.gs).tnick.getText();
			}
			this.gs.movefieldd(((this.gs)
				.tpass),
			376, 251, 129, 23, this.showtf);
			if (!(this.gs).tpass.getText()
				.equals(this.lpass)) {
				fixtext((this.gs).tpass);
				this.lpass = (this.gs).tpass.getText();
			}
			if (this.fase == 3 && ((!(this.gs).tpass.getText()
				.equals("") && !(this.gs).tnick.getText()
				.equals("")) || !(this.gs).applejava) && !(this.gs).keplo.isShowing())
			(this.gs).keplo.show();
			this.gs.movefield(((this.gs)
				.keplo),
			376, 275, 129, 23);
		}
		if (this.fase == 5) {
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString("Nickname:",
			376 - this.ftm.stringWidth("Nickname:") - 14, 141);
			this.gs.movefield(((this.gs)
				.tnick),
			376, 125, 129, 23);
			while (this.ftm.stringWidth((
			this.gs)
				.tnick.getText()) > 86) {
				(this.gs).tnick.setText((this.gs).tnick.getText()
					.substring(0, (this.gs).tnick.getText()
					.length() - 1));
				(this.gs).tnick.select((this.gs).tnick.getText()
					.length(), (this.gs).tnick.getText()
					.length());
			}
			if (!(this.gs).tnick.getText()
				.equals(this.lnick)) {
				fixtext((this.gs).tnick);
				this.lnick = (this.gs).tnick.getText();
			}
			if (!(this.gs).tnick.isShowing())
			(this.gs).tnick.show();
			drawbutton((this.xt).register, 400, 325);
			drawbutton((this.xt).cancel, 400, 375);
		}
		if (this.fase == 7 || this.fase == 8) {
			this.rd.setColor(new Color(0, 0, 0));
			if (this.nflk % 4 != 0 || this.nflk == 0)
			this.rd.drawString(this.msg,
			400 - (this.ftm.stringWidth(this.msg) / 2),
			205);
			if (this.nflk != 0)
			this.nflk--;
			this.rd.drawString("Your Email:", (344 - this.ftm.stringWidth("Your Email:") - 14),
			241);
			if (this.fase == 8) {
				if (this.msg.equals(". . . | Checking Email | . . .") && this.ncnt == 0) {
					this.msg = "| Checking Email |";
					this.ncnt = 5;
				}
				if (this.msg.equals(". . | Checking Email | . .") && this.ncnt == 0) {
					this.msg = ". . . | Checking Email | . . .";
					this.ncnt = 5;
				}
				if (this.msg.equals(". | Checking Email | .") && this.ncnt == 0) {
					this.msg = ". . | Checking Email | . .";
					this.ncnt = 5;
				}
				if (this.msg.equals("| Checking Email |") && this.ncnt == 0) {
					this.msg = ". | Checking Email | .";
					this.ncnt = 5;
				}
				if (this.ncnt != 0)
				this.ncnt--;
				this.pessd[2] = true;
			}
			if (this.fase == 7) {
				this.showtf = true;
				if (!(this.gs).applejava && !(this.gs).temail.isShowing()) {
					(this.gs).temail.show();
					(this.gs).temail.requestFocus();
				}
			}
			if (this.errcnt != 0) {
				this.errcnt--;
				if (this.errcnt == 0)
				(this.gs).temail.setForeground(new Color(0, 0, 0));
			}
			drawbutton((this.xt).sdets, 400, 280);
			drawbutton((this.xt).cancel, 400, 375);
			this.gs.movefieldd(((this.gs)
				.temail),
			344, 225, 199, 23, this.showtf);
			if (!(this.gs).temail.getText()
				.equals(this.lemail)) {
				fixtext((this.gs).temail);
				this.lemail = (this.gs).temail.getText();
			}
		}
	}

	public void ctachm(int i, int i_47_, int i_48_, Control control,
	Lobby lobby) {
		int i_49_ = -1;
		if (this.fase != 2 && this.fase != 4 && this.fase != 6 && this.fase != 8 && this.fase != 9) {
			for (int i_50_ = 0; i_50_ < this.btn; i_50_++) {
				if ((Math.abs(i - this.bx[i_50_]) < this.bw[i_50_] / 2 + 12) && Math.abs(i_47_ - this.by[i_50_]) < 14 && (i_48_ == 1 || i_48_ == 11))
				this.pessd[i_50_] = true;
				else this.pessd[i_50_] = false;
				if ((Math.abs(i - this.bx[i_50_]) < this.bw[i_50_] / 2 + 12) && Math.abs(i_47_ - this.by[i_50_]) < 14 && i_48_ <= -1) {
					(this.gs).mouses = 0;
					i_49_ = i_50_;
				}
				if (this.fase == 12 && (Math.abs(i - this.bx[i_50_]) < this.bw[i_50_] / 2 + 12) && Math.abs(i_47_ - this.by[i_50_]) < 14 && (i_50_ == 3 || i_50_ == 4) && (i != this.lxm || i_47_ != this.lym))
				this.opselect = i_50_ - 3;
			}
		}
		if (i_49_ == 0) {
			(this.gs).tnick.hide();
			(this.gs).tpass.hide();
			(this.gs).keplo.hide();
			(this.gs).temail.hide();
			this.gs.requestFocus();
			(this.xt).fase = 24;
		}
		if (i_49_ == 1 && this.fase != 5) {
			(this.gs).tnick.hide();
			(this.gs).tpass.hide();
			(this.gs).keplo.hide();
			(this.gs).temail.hide();
			this.gs.requestFocus();
			(this.xt).fase = 23;
		}
		int i_51_ = 2;
		if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15 || this.fase == 16 || this.fase == 17) {
			if (i > 176 && i_47_ > 152 && i < 296 && i_47_ < 174) {
				if (!this.ond) {
					this.ond = true;
					this.gs.setCursor(new Cursor(12));
				}
			} else if (this.ond) {
				this.ond = false;
				this.gs.setCursor(new Cursor(0));
			}
			if (this.cntcl == 0) {
				if (this.ond && i_48_ == 11) {
					this.gs.editlink((
					this.xt).nickname,
					false);
					this.cntcl = 10;
				}
			} else this.cntcl--;
			if (i_49_ == i_51_) {
				i_49_ = -1;
				if ((this.xt).sc[0] >= 16) {
					(this.xt).sc[0] = 15;
					this.gotcai = false;
				}
				(this.xt).logged = false;
				(this.xt).gotlog = false;
				(this.gs).keplo.setState(false);
				this.gs.setloggedcookie();
				((this.xt).cd).msloaded = 0;
				((this.xt).cd).lastload = 0;
				this.msg = "Login to access the multiplayer madness!";
				this.fase = 3;
			}
		}
		if (this.fase == 12) {
			if ((this.xt).acexp == 0 || this.contrb) {
				if ((control).up) {
					this.opselect--;
					if (this.opselect == -1)
					this.opselect = 1;
					(control).up = false;
				}
				if ((control).down) {
					this.opselect++;
					if (this.opselect == 2)
					this.opselect = 0;
					(control).down = false;
				}
				if ((control).enter) {
					i_49_ = this.opselect + 3;
					(control).enter = false;
				}
				if (i_49_ == i_51_ + 2) {
					this.trans = 0;
					this.fase = 15;
					i_49_ = -1;
				}
				if (!(this.xt).logged && i_49_ == i_51_ + 3)
				this.gs.editlink((
				this.xt).nickname,
				true);
			} else {
				if ((this.xt).acexp > 0) {
					if (i_49_ == i_51_ + 1 || (control).enter) {
						this.gs.editlink(((
						this.xt)
							.nickname),
						false);
						i_49_ = -1;
					}
					if (i_49_ == i_51_ + 2) {
						this.opselect = 0;
						this.contrb = true;
						i_49_ = -1;
					}
				}
				if ((this.xt).acexp == -1) {
					if (i_49_ == i_51_ + 1 || (control).enter) {
						this.gs.editlink(((
						this.xt)
							.nickname),
						false);
						i_49_ = -1;
					}
					if (i_49_ == i_51_ + 2) {
						i_49_ = -1;
						if ((this.xt).sc[0] >= 16) {
							(this.xt).sc[0] = 15;
							this.gotcai = false;
						}
						(this.xt).logged = false;
						((this.xt).cd)
							.lastload = 0;
						this.msg = "Login to access the multiplayer madness!";
						this.fase = 3;
					}
				}
				if ((this.xt).acexp == -2) {
					if (i_49_ == i_51_ + 1 || (control).enter) {
						this.gs.multlink();
						i_49_ = -1;
					}
					if (i_49_ == i_51_ + 2) {
						i_49_ = -1;
						if ((this.xt).sc[0] >= 16) {
							(this.xt).sc[0] = 15;
							this.gotcai = false;
						}
						(this.xt).logged = false;
						((this.xt).cd)
							.lastload = 0;
						this.msg = "Login to access the multiplayer madness!";
						this.fase = 3;
					}
				}
				if ((this.xt).acexp == -3) {
					if (i_49_ == i_51_ + 1 || (control).enter) {
						this.gs.editlink(((
						this.xt)
							.nickname),
						false);
						i_49_ = -1;
					}
					if (i_49_ == i_51_ + 2) {
						i_49_ = -1;
						if ((this.xt).sc[0] >= 16) {
							(this.xt).sc[0] = 15;
							this.gotcai = false;
						}
						(this.xt).logged = false;
						((this.xt).cd)
							.lastload = 0;
						this.msg = "Login to access the multiplayer madness!";
						this.fase = 3;
					}
				}
			}
		}
		if (this.fase == 13 || this.fase == 14 || this.fase == 15 || this.fase == 16 || this.fase == 17) {
			if ((control).exit) i_49_ = 3;
			if (i_49_ == i_51_ + 1) {
				if (this.fase == 15)
				this.opselect = 1;
				else this.opselect = 0;
				if (this.fase == 16 || this.fase == 17) {
					if (this.connector != null) {
						this.connector.stop();
						this.connector = null;
					}
					try {
						this.socket.close();
						this.socket = null;
						this.din.close();
						this.din = null;
						this.dout.close();
						this.dout = null;
					} catch (Exception exception) {
						/* empty */
					}
					this.fase = 12;
					this.connector = new Thread(this);
					this.connector.start();
				}
				if (this.fase == 14) {
					if (this.connector != null) {
						this.connector.stop();
						this.connector = null;
					}
					for (int i_52_ = 0; i_52_ < this.nservers;
					i_52_++) {
						try {
							this.dSocket[i_52_].close();
							this.dSocket[i_52_] = null;
						} catch (Exception exception) {
							/* empty */
						}
					}
					this.socketson = false;
					this.fase = 12;
					this.connector = new Thread(this);
					this.connector.start();
				}
				this.fase = 12;
				this.gs.setCursor(new Cursor(0));
			}
		}
		if (this.fase == 15) {
			if ((control).enter) {
				i_49_ = 4;
				this.pessd[4] = true;
			}
			if (i_49_ == i_51_ + 2) {
				if ((this.xt).nofull)
				this.nflk = 30;
				else {
					(this.xt).server = this.servers[1];
					(this.xt).servername = this.snames[1];
					(this.xt).servport = 7067;
					(this.xt).lan = true;
					i_49_ = -1;
					this.fase = 18;
					(lobby).fase = 0;
				}
			}
		}
		if (this.fase == 17) {
			if ((control).enter) {
				i_49_ = 4;
				this.pessd[4] = true;
			}
			if ((control).up) {
				this.opselect--;
				if (this.opselect == -1)
				this.opselect = 4;
				(control).up = false;
			}
			if ((control).down) {
				this.opselect++;
				if (this.opselect == 5)
				this.opselect = 0;
				(control).down = false;
			}
			for (int i_54_ = 0; i_54_ < 5; i_54_++) {
				if (i > 175 && i_47_ > 230 + i_54_ * 20 + 14 && i < 625 && i_47_ < 250 + i_54_ * 20 + 14 && i_48_ == 1)
				this.opselect = i_54_;
			}
			if (i_49_ == i_51_ + 2) {
				(this.xt).servport = 7071 + this.opselect;
				(this.xt).lan = false;
				i_49_ = -1;
				this.fase = 18;
				(lobby).fase = 0;
			}
		}
		if (this.fase == 3) {
			if (i > 295 && i_47_ > 334 && i < 505 && i_47_ < 348) {
				if (!this.onf) {
					this.onf = true;
					this.gs.setCursor(new Cursor(12));
				}
			} else if (this.onf) {
				this.onf = false;
				this.gs.setCursor(new Cursor(0));
			}
			if (this.onf && i_48_ == 11) {
				this.msg = "Please enter your Email Address to recover your account details.";
				(this.gs).tnick.setForeground(new Color(0, 0, 0));
				(this.gs).tpass.setForeground(new Color(0, 0, 0));
				(this.gs).tnick.hide();
				(this.gs).tpass.hide();
				(this.gs).keplo.hide();
				this.onf = false;
				this.gs.setCursor(new Cursor(0));
				this.fase = 7;
			}
			if (i > this.xrl && i < this.xrr && i_47_ > 360 && i_47_ < 373) {
				if (!this.onr) {
					this.onr = true;
					this.gs.setCursor(new Cursor(12));
				}
			} else if (this.onr) {
				this.onr = false;
				this.gs.setCursor(new Cursor(0));
			}
			if (this.onr && i_48_ == 11) {
				this.gs.reglink();
				(this.gs).mouses = 0;
			}
		}
		if (this.fase == 1) {
			if ((control).enter) {
				i_49_ = 2;
				this.pessd[2] = true;
			}
			if (i_49_ == 2) {
				if ((this.gs).tnick.getText()
					.equals("Fyre") || (this.gs).tnick.getText()
					.equals("Nickname") || (this.gs).tnick.getText()
					.equals("")) {
					this.msg = "Type in any Nickname to play...";
					(this.gs).tnick.setText("Nickname");
					this.nflk = 30;
				} else {
					this.msg = "| Checking Nickname |";
					(this.gs).tnick.disable();
					this.fase = 2;
					this.connector = new Thread(this);
					this.connector.start();
				}
			}
			if (i_49_ == 3) {
				if ((this.gs).tnick.getText()
					.equals("Nickname") || this.msg.startsWith("This"))
				(this.gs).tnick.setText("");
				this.msg = "Login to access the multiplayer madness!";
				(this.gs).tnick.setForeground(new Color(0, 0, 0));
				this.fase = 3;
				i_49_ = -1;
			}
			if (i_49_ == 4) {
				if (this.nickero || (this.gs).tnick.getText()
					.equals("Nickname")) {
					(this.gs).tnick.setText("");
					this.nickero = false;
				}
				(this.gs).tnick.setForeground(new Color(0, 0, 0));
				this.gs.reglink();
			}
		}
		if (this.fase == 3) {
			if ((control).enter || (this.xt).autolog) {
				i_49_ = 2;
				this.pessd[2] = true;
				(this.xt).autolog = false;
			}
			if ((control).exit) i_49_ = 3;
			if (i_49_ == 2) {
				if ((this.gs).tnick.getText()
					.equals("")) {
					this.msg = "Enter your Nickname!";
					this.nflk = 30;
				} else if ((this.gs).tpass.getText().equals("")) {
					this.msg = "Enter your Password!";
					this.nflk = 30;
				} else {
					this.msg = "| Logging In |";
					(this.gs).tnick.disable();
					(this.gs).tpass.disable();
					(this.gs).keplo.disable();
					this.fase = 4;
					this.connector = new Thread(this);
					this.connector.start();
				}
			}
			if (i_49_ == 3)
			this.gs.regnew();
		}
		if (this.fase == 5) {
			if ((control).enter) {
				i_49_ = 1;
				this.pessd[1] = true;
			}
			if ((control).exit) i_49_ = 2;
			if (i_49_ != 1) {
				/* empty */
			}
			if (i_49_ == 2) {
				this.fase = this.lrgfase;
				if (this.fase == 12) {
					(this.gs).tnick.hide();
					this.connector = new Thread(this);
					this.connector.start();
				}
			}
		}
		if (this.fase == 7) {
			if ((control).enter) {
				i_49_ = 2;
				this.pessd[2] = true;
			}
			if ((control).exit) i_49_ = 3;
			if (i_49_ == 2) {
				this.nflk = 0;
				if ((this.gs).temail.getText()
					.equals("")) {
					this.msg = "Please type in your Email Address!";
					this.nflk = 30;
				}
				if (this.nflk == 0) {
					String string = (this.gs).temail.getText();
					int i_55_ = 0;
					int i_56_ = 0;
					for (/**/ ; i_55_ < string.length(); i_55_++) {
						String string_57_ = new StringBuilder().append("").append(string.charAt(i_55_)).toString();
						if (string_57_.equals("@") && i_56_ == 0 && i_55_ != 0) i_56_ = 1;
						if (string_57_.equals(".") && i_56_ == 1 && i_55_ != string.length() - 1) i_56_ = 2;
					}
					if (i_56_ != 2) {
						this.msg = "Please type in your Email Address correctly!";
						this.nflk = 30;
						this.errcnt = 40;
						(this.gs).temail.setForeground(new Color(255, 0, 0));
					}
				}
				if (this.nflk == 0) {
					this.msg = "| Checking Email |";
					(this.gs).temail.disable();
					this.fase = 8;
					this.connector = new Thread(this);
					this.connector.start();
				}
			}
			if (i_49_ == 3) {
				inishmulti();
				(this.gs).temail.setText("");
				(this.gs).tpass.setText("");
			}
		}
		this.lxm = i;
		this.lym = i_47_;
		(control).enter = false;
		(control).exit = false;
	}

	public void drawSbutton(Image image, int i, int i_58_) {
		this.bx[this.btn] = i;
		this.by[this.btn] = i_58_;
		this.bw[this.btn] = image.getWidth(this.ob);
		if (!this.pessd[this.btn]) {
			this.rd.drawImage(image, i - this.bw[this.btn] / 2,
			i_58_ - image.getHeight(this.ob) / 2 - 1, null);
			this.rd.drawImage((this.xt).bols,
			i - (this.bw[this.btn]) / 2 - 15,
			i_58_ - 13, null);
			this.rd.drawImage((this.xt).bors,
			i + (this.bw[this.btn]) / 2 + 9,
			i_58_ - 13, null);
			this.rd.drawImage((this.xt).bot,
			i - this.bw[this.btn] / 2 - 9, i_58_ - 13, this.bw[this.btn] + 18, 3, null);
			this.rd.drawImage((this.xt).bob,
			i - this.bw[this.btn] / 2 - 9, i_58_ + 10, this.bw[this.btn] + 18, 3, null);
		} else {
			this.rd.drawImage(image, i - this.bw[this.btn] / 2 + 1,
			i_58_ - image.getHeight(this.ob) / 2, null);
			this.rd.drawImage((this.xt).bolps,
			i - (this.bw[this.btn]) / 2 - 15,
			i_58_ - 13, null);
			this.rd.drawImage((this.xt).borps,
			i + (this.bw[this.btn]) / 2 + 9,
			i_58_ - 13, null);
			this.rd.drawImage((this.xt).bob,
			i - this.bw[this.btn] / 2 - 9, i_58_ - 13, this.bw[this.btn] + 18, 3, null);
			this.rd.drawImage((this.xt).bot,
			i - this.bw[this.btn] / 2 - 9, i_58_ + 10, this.bw[this.btn] + 18, 3, null);
		}
		this.btn++;
	}

	public void drawbutton(Image image, int i, int i_59_) {
		this.bx[this.btn] = i;
		this.by[this.btn] = i_59_;
		this.bw[this.btn] = image.getWidth(this.ob);
		if (!this.pessd[this.btn]) {
			this.rd.drawImage(image, i - this.bw[this.btn] / 2,
			i_59_ - image.getHeight(this.ob) / 2, null);
			this.rd.drawImage((this.xt).bol,
			i - (this.bw[this.btn]) / 2 - 15,
			i_59_ - 16, null);
			this.rd.drawImage((this.xt).bor,
			i + (this.bw[this.btn]) / 2 + 9,
			i_59_ - 16, null);
			this.rd.drawImage((this.xt).bot,
			i - this.bw[this.btn] / 2 - 9, i_59_ - 16, this.bw[this.btn] + 18, 3, null);
			this.rd.drawImage((this.xt).bob,
			i - this.bw[this.btn] / 2 - 9, i_59_ + 13, this.bw[this.btn] + 18, 3, null);
		} else {
			this.rd.drawImage(image, i - this.bw[this.btn] / 2 + 1,
			i_59_ - image.getHeight(this.ob) / 2 + 1, null);
			this.rd.drawImage((this.xt).bolp,
			i - (this.bw[this.btn]) / 2 - 15,
			i_59_ - 16, null);
			this.rd.drawImage((this.xt).borp,
			i + (this.bw[this.btn]) / 2 + 9,
			i_59_ - 16, null);
			this.rd.drawImage((this.xt).bob,
			i - this.bw[this.btn] / 2 - 9, i_59_ - 16, this.bw[this.btn] + 18, 3, null);
			this.rd.drawImage((this.xt).bot,
			i - this.bw[this.btn] / 2 - 9, i_59_ + 13, this.bw[this.btn] + 18, 3, null);
		}
		this.btn++;
	}

	public void stringbutton(String string, int i, int i_60_, int i_61_) {
		this.rd.setFont(new Font("Arial", 1, 12));
		this.ftm = this.rd.getFontMetrics();
		this.bx[this.btn] = i;
		this.by[this.btn] = i_60_ - 5;
		this.bw[this.btn] = this.ftm.stringWidth(string);
		if (!this.pessd[this.btn]) {
			this.rd.setColor(color2k(220, 220, 220));
			this.rd.fillRect(i - this.bw[this.btn] / 2 - 10,
			i_60_ - (17 - i_61_), this.bw[this.btn] + 20, 25 - i_61_ * 2);
			this.rd.setColor(color2k(240, 240, 240));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ - (17 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ - (17 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ - (18 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ - (18 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 9,
			i_60_ - (19 - i_61_),
			i + this.bw[this.btn] / 2 + 9,
			i_60_ - (19 - i_61_));
			this.rd.setColor(color2k(200, 200, 200));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 10,
			i_60_ - (17 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 11,
			i_60_ - (17 - i_61_),
			i + this.bw[this.btn] / 2 + 11,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 12,
			i_60_ - (16 - i_61_),
			i + this.bw[this.btn] / 2 + 12,
			i_60_ + (6 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ + (7 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ + (8 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ + (8 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 9,
			i_60_ + (9 - i_61_),
			i + this.bw[this.btn] / 2 + 9,
			i_60_ + (9 - i_61_));
			this.rd.setColor(color2k(240, 240, 240));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ - (17 - i_61_),
			i - this.bw[this.btn] / 2 - 10,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 11,
			i_60_ - (17 - i_61_),
			i - this.bw[this.btn] / 2 - 11,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 12,
			i_60_ - (16 - i_61_),
			i - this.bw[this.btn] / 2 - 12,
			i_60_ + (6 - i_61_));
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString(string,
			i - (this.bw[this.btn]) / 2,
			i_60_);
		} else {
			this.rd.setColor(color2k(210, 210, 210));
			this.rd.fillRect(i - this.bw[this.btn] / 2 - 10,
			i_60_ - (17 - i_61_), this.bw[this.btn] + 20, 25 - i_61_ * 2);
			this.rd.setColor(color2k(200, 200, 200));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ - (17 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ - (17 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ - (18 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ - (18 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 9,
			i_60_ - (19 - i_61_),
			i + this.bw[this.btn] / 2 + 9,
			i_60_ - (19 - i_61_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 10,
			i_60_ - (17 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 11,
			i_60_ - (17 - i_61_),
			i + this.bw[this.btn] / 2 + 11,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i + this.bw[this.btn] / 2 + 12,
			i_60_ - (16 - i_61_),
			i + this.bw[this.btn] / 2 + 12,
			i_60_ + (6 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ + (7 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ + (8 - i_61_),
			i + this.bw[this.btn] / 2 + 10,
			i_60_ + (8 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 9,
			i_60_ + (9 - i_61_),
			i + this.bw[this.btn] / 2 + 9,
			i_60_ + (9 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 10,
			i_60_ - (17 - i_61_),
			i - this.bw[this.btn] / 2 - 10,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 11,
			i_60_ - (17 - i_61_),
			i - this.bw[this.btn] / 2 - 11,
			i_60_ + (7 - i_61_));
			this.rd.drawLine(i - this.bw[this.btn] / 2 - 12,
			i_60_ - (16 - i_61_),
			i - this.bw[this.btn] / 2 - 12,
			i_60_ + (6 - i_61_));
			this.rd.setColor(new Color(0, 0, 0));
			this.rd.drawString(string,
			i - (this.bw[this.btn]) / 2 + 1,
			i_60_);
		}
		this.btn++;
	}

	public Color color2k(int i, int i_62_, int i_63_) {
		Color color = new Color(i, i_62_, i_63_);
		float[] fs = new float[3];
		Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), fs);
		fs[0] = 0.13F;
		fs[1] = 0.35F;
		return Color.getHSBColor(fs[0], fs[1], fs[2]);
	}

	public void fixtext(TextField textfield) {
		String string = textfield.getText();
		string = string.replace('\"', '#');
		String string_64_ = "\\";
		String string_65_ = "";
		int i = 0;
		int i_66_ = -1;
		for (/**/ ; i < string.length(); i++) {
			String string_67_ = new StringBuilder().append("").append(string.charAt(i)).toString();
			if (string_67_.equals("|") || string_67_.equals(",") || string_67_.equals("(") || string_67_.equals(")") || string_67_.equals("#") || string_67_.equals(string_64_) || string_67_.equals("!") || string_67_.equals("?") || string_67_.equals(" ") || string_67_.equals("~") || string_67_.equals("$") || string_67_.equals("%") || string_67_.equals("^") || string_67_.equals("&") || string_67_.equals("*") || string_67_.equals("+") || string_67_.equals("=") || string_67_.equals(">") || string_67_.equals("<") || string_67_.equals("/") || string_67_.equals("'") || string_67_.equals(";") || string_67_.equals(":") || string_67_.equals("\u00a0")) i_66_ = i;
			else string_65_ = new StringBuilder().append(string_65_).append(string_67_).toString();
		}
		if (i_66_ != -1) {
			textfield.setText(string_65_);
			textfield.select(i_66_, i_66_);
		}
	}

	public int getvalue(String string, int i) {
		int i_68_ = -1;
		try {
			int i_69_ = 0;
			int i_70_ = 0;
			int i_71_ = 0;
			String string_72_ = "";
			String string_73_ = "";
			for (/**/ ; i_69_ < string.length() && i_71_ != 2; i_69_++) {
				string_72_ = new StringBuilder().append("").append(string.charAt(i_69_)).toString();
				if (string_72_.equals("|")) {
					i_70_++;
					if (i_71_ == 1 || i_70_ > i) i_71_ = 2;
				} else if (i_70_ == i) {
					string_73_ = new StringBuilder().append(string_73_).append(string_72_).toString();
					i_71_ = 1;
				}
			}
			if (string_73_.equals("")) string_73_ = "-1";
			i_68_ = Integer.valueOf(string_73_).intValue();
		} catch (Exception exception) {
			/* empty */
		}
		return i_68_;
	}

	public String getSvalue(String string, int i) {
		String string_74_ = "";
		try {
			int i_75_ = 0;
			int i_76_ = 0;
			int i_77_ = 0;
			String string_78_ = "";
			String string_79_ = "";
			for (/**/ ; i_75_ < string.length() && i_77_ != 2; i_75_++) {
				string_78_ = new StringBuilder().append("").append(string.charAt(i_75_)).toString();
				if (string_78_.equals("|")) {
					i_76_++;
					if (i_77_ == 1 || i_76_ > i) i_77_ = 2;
				} else if (i_76_ == i) {
					string_79_ = new StringBuilder().append(string_79_).append(string_78_).toString();
					i_77_ = 1;
				}
			}
			string_74_ = string_79_;
		} catch (Exception exception) {
			/* empty */
		}
		return string_74_;
	}
}