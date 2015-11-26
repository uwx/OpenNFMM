
/* GameSparker - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.awt.AlphaComposite;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameSparker extends JPanel implements KeyListener, MouseListener, MouseMotionListener, ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -5976860556958716653L;
	float apmult = 1.0F;
	boolean applejava = false;
	int apx = 0;
	int apy = 0;
	Image blb;
	Image[] carmaker = new Image[2];
	Image[] chkbx = new Image[2];
	Smenu clanlev = new Smenu(8);
	Smenu clcars = new Smenu(707);
	TextField cmsg;
	Smenu datat = new Smenu(26);
	boolean exwist = false;
	int fcscnt = 0;
	Image fulls;
	Smenu gmode = new Smenu(3);
	Smenu icars = new Smenu(5);
	Smenu ilaps = new Smenu(18);
	Checkbox keplo;
	int lasth = 0;
	int lastw = 0;
	int lmxz = 0;
	boolean lostfcs = false;
	Smenu mcars = new Smenu(707);
	int mload = 1;
	TextArea mmsg;
	int moto = 1;
	boolean moused = false;
	int mouses = 0;
	int mousew = 0;
	Smenu mstgs = new Smenu(707);
	int mvect = 100;
	Checkbox mycar;
	int nob = 0;
	int notb = 0;
	Checkbox notp;
	BufferedImage offImage;
	boolean onbar = false;
	boolean oncarm = false;
	boolean onfulls = false;
	boolean onstgm = false;
	boolean openm = false;
	Smenu pgame = new Smenu(11);
	Smenu proitem = new Smenu(707);
	Graphics2D rd;
	float reqmult = 0.0F;
	Smenu rooms = new Smenu(7);
	Smenu scars = new Smenu(4);
	Smenu sclass = new Smenu(7);
	Smenu senditem = new Smenu(707);
	Smenu sendtyp = new Smenu(6);
	Smenu sfix = new Smenu(7);
	Smenu sgame = new Smenu(8);
	int shaka = 0;
	int showsize = 0;
	Image sizebar;
	Smenu slaps = new Smenu(17);
	int smooth = 1;
	Smenu snbts = new Smenu(8);
	Smenu snfm1 = new Smenu(12);
	Smenu snfm2 = new Smenu(19);
	Smenu snfmm = new Smenu(12);
	Smenu snpls = new Smenu(9);
	Image[] stagemaker = new Image[2];
	Smenu swait = new Smenu(6);
	TextField temail;
	TextField tnick;
	TextField tpass;
	Control[] u = new Control[8];
	int view = 0;
	Smenu vnpls = new Smenu(5);
	Smenu vtyp = new Smenu(6);
	Smenu warb = new Smenu(102);
	Smenu wgame = new Smenu(4);
	int xm = 0;
	int ym = 0;

	public void catchlink() {
		if (!lostfcs)
			if (xm > 65 && xm < 735 && ym > 135 && ym < 194 || xm > 275 && xm < 525 && ym > 265 && ym < 284) {
				setCursor(new Cursor(12));
				if (mouses == 2)
					openurl("http://www.radicalplay.com/");
			} else
				setCursor(new Cursor(0));
	}

	public void checkmemory(final xtGraphics var_xtGraphics) {
		if (applejava || Runtime.getRuntime().freeMemory() / 1048576L < 50L)
			var_xtGraphics.badmac = true;
	}

	public void cropit(final Graphics2D graphics2d, final int i, final int i_98_) {
		if (i != 0 || i_98_ != 0) {
			graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
			graphics2d.setColor(new Color(0, 0, 0));
		}
		if (i != 0)
			if (i < 0)
				graphics2d.fillRect(apx + i, apy - (int) (25.0F * apmult), Math.abs(i), (int) (500.0F * apmult));
			else
				graphics2d.fillRect(apx + (int) (800.0F * apmult), apy - (int) (25.0F * apmult), i,
						(int) (500.0F * apmult));
		if (i_98_ != 0)
			if (i_98_ < 0)
				graphics2d.fillRect(apx - (int) (25.0F * apmult), apy + i_98_, (int) (850.0F * apmult),
						Math.abs(i_98_));
			else
				graphics2d.fillRect(apx - (int) (25.0F * apmult), apy + (int) (450.0F * apmult),
						(int) (850.0F * apmult), i_98_);
	}

	public void drawms() {
		openm = false;
		if (gmode.draw(rd, xm, ym, moused, 450, true))
			openm = true;
		if (swait.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (slaps.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (snpls.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (snbts.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (scars.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (sgame.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (snfm1.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (snfm2.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (snfmm.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (mstgs.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (mcars.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (pgame.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (vnpls.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (vtyp.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (warb.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (wgame.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (rooms.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (sendtyp.draw(rd, xm, ym, moused, 450, true))
			openm = true;
		if (senditem.draw(rd, xm, ym, moused, 450, true))
			openm = true;
		if (datat.draw(rd, xm, ym, moused, 450, true))
			openm = true;
		if (clanlev.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (clcars.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (ilaps.draw(rd, xm, ym, moused, 450, true))
			openm = true;
		if (icars.draw(rd, xm, ym, moused, 450, true))
			openm = true;
		if (proitem.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (sfix.draw(rd, xm, ym, moused, 450, false))
			openm = true;
		if (sclass.draw(rd, xm, ym, moused, 450, false))
			openm = true;
	}

	public void editlink(final String string, final boolean bool) {
		String string_208_ = "";
		if (bool)
			string_208_ = "?display=upgrade";
		openurl(new StringBuilder().append("http://multiplayer.needformadness.com/edit.pl").append(string_208_)
				.append("#").append(string).append("").toString());
	}

	public int getint(final String string, final String string_181_, final int i) {
		int i_182_ = 0;
		String string_183_ = "";
		for (int i_184_ = string.length() + 1; i_184_ < string_181_.length(); i_184_++) {
			final String string_185_ = new StringBuilder().append("").append(string_181_.charAt(i_184_)).toString();
			if (string_185_.equals(",") || string_185_.equals(")")) {
				i_182_++;
				i_184_++;
			}
			if (i_182_ == i)
				string_183_ = new StringBuilder().append(string_183_).append(string_181_.charAt(i_184_)).toString();
		}
		return Integer.valueOf(string_183_).intValue();
	}

	public String getstring(final String string, final String string_186_, final int i) {
		int i_187_ = 0;
		String string_188_ = "";
		for (int i_189_ = string.length() + 1; i_189_ < string_186_.length(); i_189_++) {
			final String string_190_ = new StringBuilder().append("").append(string_186_.charAt(i_189_)).toString();
			if (string_190_.equals(",") || string_190_.equals(")")) {
				i_187_++;
				i_189_++;
			}
			if (i_187_ == i)
				string_188_ = new StringBuilder().append(string_188_).append(string_186_.charAt(i_189_)).toString();
		}
		return string_188_;
	}

	@Override
	public boolean gotFocus(final Event event, final Object object) {
		if (!exwist && lostfcs)
			lostfcs = false;
		return false;
	}

	public void hidefields() {
		ilaps.setVisible(false);
		icars.setVisible(false);
		proitem.setVisible(false);
		clcars.setVisible(false);
		clanlev.setVisible(false);
		mmsg.setVisible(false);
		datat.setVisible(false);
		senditem.setVisible(false);
		sendtyp.setVisible(false);
		rooms.setVisible(false);
		mcars.setVisible(false);
		mstgs.setVisible(false);
		gmode.setVisible(false);
		sclass.setVisible(false);
		scars.setVisible(false);
		sfix.setVisible(false);
		mycar.setVisible(false);
		notp.setVisible(false);
		keplo.setVisible(false);
		tnick.setVisible(false);
		tpass.setVisible(false);
		temail.setVisible(false);
		cmsg.setVisible(false);
		sgame.setVisible(false);
		wgame.setVisible(false);
		pgame.setVisible(false);
		vnpls.setVisible(false);
		vtyp.setVisible(false);
		warb.setVisible(false);
		slaps.setVisible(false);
		snfm1.setVisible(false);
		snfmm.setVisible(false);
		snfm2.setVisible(false);
		snpls.setVisible(false);
		snbts.setVisible(false);
		swait.setVisible(false);
	}

	//@Override
	public void initApplet() {
		setBackground(new Color(0, 0, 0));
		//offImage = createImage(800, 450);
		//if (offImage != null)
		//	rd = (Graphics2D) offImage.getGraphics();
		setLayout(null);
		tnick = new TextField("Nickbname");
		tnick.setFont(new Font("Arial", 1, 13));
		tpass = new TextField("");
		tpass.setFont(new Font("Arial", 1, 13));
		tpass.setEchoChar('*');
		temail = new TextField("");
		temail.setFont(new Font("Arial", 1, 13));
		cmsg = new TextField("");
		if (System.getProperty("java.vendor").toLowerCase().indexOf("oracle") != -1)
			cmsg.addKeyListener( /* TYPE_ERROR */ new GameSparker$1(this));
		mmsg = new TextArea("", 200, 20, 3);
		cmsg.setFont(new Font("Tahoma", 0, 11));
		mmsg.setFont(new Font("Tahoma", 0, 11));
		mycar = new Checkbox("Sword of Justice Game!");
		notp = new Checkbox("No Trees & Piles");
		keplo = new Checkbox("Stay logged in");
		keplo.setState(true);
		add(tnick);
		add(tpass);
		add(temail);
		add(cmsg);
		add(mmsg);
		add(mycar);
		add(notp);
		add(keplo);
		sgame.setFont(new Font("Arial", 1, 13));
		wgame.setFont(new Font("Arial", 1, 13));
		warb.setFont(new Font("Arial", 1, 13));
		pgame.setFont(new Font("Arial", 1, 12));
		vnpls.setFont(new Font("Arial", 1, 13));
		vtyp.setFont(new Font("Arial", 1, 13));
		snfmm.setFont(new Font("Arial", 1, 13));
		snfm1.setFont(new Font("Arial", 1, 13));
		snfm2.setFont(new Font("Arial", 1, 13));
		mstgs.setFont(new Font("Arial", 1, 13));
		mcars.setFont(new Font("Arial", 1, 13));
		slaps.setFont(new Font("Arial", 1, 13));
		snpls.setFont(new Font("Arial", 0, 13));
		snbts.setFont(new Font("Arial", 0, 13));
		swait.setFont(new Font("Arial", 0, 12));
		sclass.setFont(new Font("Arial", 1, 12));
		scars.setFont(new Font("Arial", 1, 12));
		sfix.setFont(new Font("Arial", 1, 12));
		mycar.setFont(new Font("Arial", 1, 12));
		notp.setFont(new Font("Arial", 1, 12));
		keplo.setFont(new Font("Arial", 1, 12));
		gmode.setFont(new Font("Arial", 1, 13));
		rooms.setFont(new Font("Arial", 1, 13));
		sendtyp.setFont(new Font("Arial", 1, 12));
		senditem.setFont(new Font("Arial", 1, 12));
		datat.setFont(new Font("Arial", 1, 12));
		clanlev.setFont(new Font("Arial", 1, 12));
		clcars.setFont(new Font("Arial", 1, 12));
		clcars.alphad = true;
		ilaps.setFont(new Font("Arial", 1, 13));
		icars.setFont(new Font("Arial", 1, 12));
		proitem.setFont(new Font("Arial", 1, 12));
	}

	public void loadbase(final ContO[] contos, final Medium medium, final Trackers trackers,
			final xtGraphics var_xtGraphics, final boolean bool) {
		final String[] strings = { "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge",
				"leadoxide", "koolkat", "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone",
				"drmonster" };
		final String[] strings_173_ = { "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad",
				"offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground",
				"ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp",
				"sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint",
				"sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "tside", "launchpad", "thenet",
				"speedramp", "offhill", "slider", "uphill", "roll1", "roll2", "roll3", "roll4", "roll5", "roll6",
				"opile1", "opile2", "aircheckpoint", "tree1", "tree2", "tree3", "tree4", "tree5", "tree6", "tree7",
				"tree8", "cac1", "cac2", "cac3", "8sroad", "8soffroad" };
		int i = 0;
		var_xtGraphics.dnload += 6;
		try {
			ZipInputStream zipinputstream;
			if (!bool) {
				final File file = new File(
						new StringBuilder().append("").append(Madness.fpath).append("data/models.zip").toString());
				zipinputstream = new ZipInputStream(new FileInputStream(file));
			} else {
				final URL url = new URL("http://multiplayer.needformadness.com/data/models.zip");
				zipinputstream = new ZipInputStream(url.openStream());
			}
			ZipEntry zipentry = zipinputstream.getNextEntry();
			for ( /**/ ; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
				int i_175_ = 0;
				for (int i_176_ = 0; i_176_ < 16; i_176_++)
					if (zipentry.getName().startsWith(strings[i_176_]))
						i_175_ = i_176_;
				for (int i_177_ = 0; i_177_ < 68; i_177_++)
					if (zipentry.getName().startsWith(strings_173_[i_177_]))
						i_175_ = i_177_ + 56;
				int i_178_ = (int) zipentry.getSize();
				i += i_178_;
				final byte[] is = new byte[i_178_];
				int i_179_ = 0;
				int i_180_;
				for ( /**/ ; i_178_ > 0; i_178_ -= i_180_) {
					i_180_ = zipinputstream.read(is, i_179_, i_178_);
					i_179_ += i_180_;
				}
				contos[i_175_] = new ContO(is, medium, trackers);
				var_xtGraphics.dnload++;
			}
			zipinputstream.close();
		} catch (final Exception exception) {
			System.out.println(new StringBuilder().append("Error Reading Models: ").append(exception).toString());
		}
		System.gc();
		if (mload != -1 && i != 615671)
			mload = 2;
	}

	public void loadstage(final ContO[] contos, final ContO[] contos_108_, final Medium medium, final Trackers trackers,
			final CheckPoints checkpoints, final xtGraphics var_xtGraphics, final Mad[] mads, final Record record) {
		if (var_xtGraphics.testdrive == 2 || var_xtGraphics.testdrive == 4)
			var_xtGraphics.nplayers = 1;
		/*if (var_xtGraphics.gmode == 1) {
			var_xtGraphics.nplayers = 5;
			var_xtGraphics.xstart[4] = 0;
			var_xtGraphics.zstart[4] = 760;
		}*/
		trackers.nt = 0;
		nob = var_xtGraphics.nplayers;
		notb = 0;
		checkpoints.n = 0;
		checkpoints.nsp = 0;
		checkpoints.fn = 0;
		checkpoints.trackname = "";
		checkpoints.haltall = false;
		checkpoints.wasted = 0;
		checkpoints.catchfin = 0;
		medium.resdown = 0;
		medium.rescnt = 5;
		medium.lightson = false;
		medium.noelec = 0;
		medium.ground = 250;
		medium.trk = 0;
		view = 0;
		int i = 0;
		int i_109_ = 100;
		int i_110_ = 0;
		int i_111_ = 100;
		var_xtGraphics.newparts = false;
		String string = "";
		try {
			DataInputStream datainputstream;
			if (var_xtGraphics.multion == 0 && checkpoints.stage != -2) {
				String string_112_ = new StringBuilder().append("stages/").append(checkpoints.stage).append("")
						.toString();
				if (checkpoints.stage == -1)
					string_112_ = new StringBuilder().append("mystages/").append(checkpoints.name).append("")
							.toString();
				final File file = new File(new StringBuilder().append("").append(Madness.fpath).append("")
						.append(string_112_).append(".txt").toString());
				datainputstream = new DataInputStream(new FileInputStream(file));
			} else if (checkpoints.stage > 0) {
				final URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/stages/")
						.append(checkpoints.stage).append(".txt").toString());
				datainputstream = new DataInputStream(url.openStream());
			} else {
				String string_113_ = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/")
						.append(checkpoints.name).append(".radq").toString();
				string_113_ = string_113_.replace(' ', '_');
				final URL url = new URL(string_113_);
				final int i_114_ = url.openConnection().getContentLength();
				final DataInputStream datainputstream_115_ = new DataInputStream(url.openStream());
				final byte[] is = new byte[i_114_];
				datainputstream_115_.readFully(is);
				ZipInputStream zipinputstream;
				if (is[0] == 80 && is[1] == 75 && is[2] == 3)
					zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
				else {
					final byte[] is_116_ = new byte[i_114_ - 40];
					for (int i_117_ = 0; i_117_ < i_114_ - 40; i_117_++) {
						int i_118_ = 20;
						if (i_117_ >= 500)
							i_118_ = 40;
						is_116_[i_117_] = is[i_117_ + i_118_];
					}
					zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_116_));
				}
				final ZipEntry zipentry = zipinputstream.getNextEntry();
				int i_119_ = Integer.valueOf(zipentry.getName()).intValue();
				final byte[] is_120_ = new byte[i_119_];
				int i_121_ = 0;
				int i_122_;
				for ( /**/ ; i_119_ > 0; i_119_ -= i_122_) {
					i_122_ = zipinputstream.read(is_120_, i_121_, i_119_);
					i_121_ += i_122_;
				}
				zipinputstream.close();
				datainputstream_115_.close();
				datainputstream = new DataInputStream(new ByteArrayInputStream(is_120_));
			}
			String string_123_;
			while ((string_123_ = datainputstream.readLine()) != null) {
				string = new StringBuilder().append("").append(string_123_.trim()).toString();
				if (string.startsWith("snap"))
					medium.setsnap(getint("snap", string, 0), getint("snap", string, 1), getint("snap", string, 2));
				if (string.startsWith("sky")) {
					medium.setsky(getint("sky", string, 0), getint("sky", string, 1), getint("sky", string, 2));
					var_xtGraphics.snap(checkpoints.stage);
				}
				if (string.startsWith("ground"))
					medium.setgrnd(getint("ground", string, 0), getint("ground", string, 1),
							getint("ground", string, 2));
				if (string.startsWith("polys"))
					medium.setpolys(getint("polys", string, 0), getint("polys", string, 1), getint("polys", string, 2));
				if (string.startsWith("fog"))
					medium.setfade(getint("fog", string, 0), getint("fog", string, 1), getint("fog", string, 2));
				if (string.startsWith("texture"))
					medium.setexture(getint("texture", string, 0), getint("texture", string, 1),
							getint("texture", string, 2), getint("texture", string, 3));
				if (string.startsWith("clouds"))
					medium.setcloads(getint("clouds", string, 0), getint("clouds", string, 1),
							getint("clouds", string, 2), getint("clouds", string, 3), getint("clouds", string, 4));
				if (string.startsWith("density")) {
					medium.fogd = (getint("density", string, 0) + 1) * 2 - 1;
					if (medium.fogd < 1)
						medium.fogd = 1;
					if (medium.fogd > 30)
						medium.fogd = 30;
				}
				if (string.startsWith("fadefrom"))
					medium.fadfrom(getint("fadefrom", string, 0));
				if (string.startsWith("lightson"))
					medium.lightson = true;
				if (string.startsWith("mountains"))
					medium.mgen = getint("mountains", string, 0);
				if (string.startsWith("set")) {
					int i_124_ = getint("set", string, 0);
					if (var_xtGraphics.nplayers == 8) {
						if (i_124_ == 47)
							i_124_ = 76;
						if (i_124_ == 48)
							i_124_ = 77;
					}
					boolean bool = true;
					if (i_124_ >= 65 && i_124_ <= 75 && checkpoints.notb)
						bool = false;
					if (bool) {
						if (i_124_ == 49 || i_124_ == 64 || i_124_ >= 56 && i_124_ <= 61)
							var_xtGraphics.newparts = true;
						if ((checkpoints.stage < 0 || checkpoints.stage >= 28) && i_124_ >= 10 && i_124_ <= 25)
							medium.loadnew = true;
						i_124_ += 46;
						contos[nob] = new ContO(contos_108_[i_124_], getint("set", string, 1),
								medium.ground - contos_108_[i_124_].grat, getint("set", string, 2),
								getint("set", string, 3));
						if (string.indexOf(")p") != -1) {
							checkpoints.x[checkpoints.n] = getint("set", string, 1);
							checkpoints.z[checkpoints.n] = getint("set", string, 2);
							checkpoints.y[checkpoints.n] = 0;
							checkpoints.typ[checkpoints.n] = 0;
							if (string.indexOf(")pt") != -1)
								checkpoints.typ[checkpoints.n] = -1;
							if (string.indexOf(")pr") != -1)
								checkpoints.typ[checkpoints.n] = -2;
							if (string.indexOf(")po") != -1)
								checkpoints.typ[checkpoints.n] = -3;
							if (string.indexOf(")ph") != -1)
								checkpoints.typ[checkpoints.n] = -4;
							if (string.indexOf("out") != -1)
								System.out
										.println(new StringBuilder().append("out: ").append(checkpoints.n).toString());
							checkpoints.n++;
							notb = nob + 1;
						}
						nob++;
						if (medium.loadnew)
							medium.loadnew = false;
					}
				}
				if (string.startsWith("chk")) {
					int i_125_ = getint("chk", string, 0);
					i_125_ += 46;
					int i_126_ = medium.ground - contos_108_[i_125_].grat;
					if (i_125_ == 110)
						i_126_ = getint("chk", string, 4);
					contos[nob] = new ContO(contos_108_[i_125_], getint("chk", string, 1), i_126_,
							getint("chk", string, 2), getint("chk", string, 3));
					checkpoints.x[checkpoints.n] = getint("chk", string, 1);
					checkpoints.z[checkpoints.n] = getint("chk", string, 2);
					checkpoints.y[checkpoints.n] = i_126_;
					if (getint("chk", string, 3) == 0)
						checkpoints.typ[checkpoints.n] = 1;
					else
						checkpoints.typ[checkpoints.n] = 2;
					checkpoints.pcs = checkpoints.n;
					checkpoints.n++;
					contos[nob].checkpoint = checkpoints.nsp + 1;
					checkpoints.nsp++;
					nob++;
					notb = nob;
				}
				if (checkpoints.nfix != 5 && string.startsWith("fix")) {
					int i_127_ = getint("fix", string, 0);
					i_127_ += 46;
					contos[nob] = new ContO(contos_108_[i_127_], getint("fix", string, 1), getint("fix", string, 3),
							getint("fix", string, 2), getint("fix", string, 4));
					checkpoints.fx[checkpoints.fn] = getint("fix", string, 1);
					checkpoints.fz[checkpoints.fn] = getint("fix", string, 2);
					checkpoints.fy[checkpoints.fn] = getint("fix", string, 3);
					contos[nob].elec = true;
					if (getint("fix", string, 4) != 0) {
						checkpoints.roted[checkpoints.fn] = true;
						contos[nob].roted = true;
					} else
						checkpoints.roted[checkpoints.fn] = false;
					if (string.indexOf(")s") != -1)
						checkpoints.special[checkpoints.fn] = true;
					else
						checkpoints.special[checkpoints.fn] = false;
					checkpoints.fn++;
					nob++;
					notb = nob;
				}
				if (!checkpoints.notb && string.startsWith("pile")) {
					contos[nob] = new ContO(getint("pile", string, 0), getint("pile", string, 1),
							getint("pile", string, 2), medium, trackers, getint("pile", string, 3),
							getint("pile", string, 4), medium.ground);
					nob++;
				}
				if (var_xtGraphics.multion == 0 && string.startsWith("nlaps")) {
					checkpoints.nlaps = getint("nlaps", string, 0);
					//if (checkpoints.nlaps < 1)
					//	checkpoints.nlaps = 1;
					//if (checkpoints.nlaps > 15)
					//	checkpoints.nlaps = 15;
				}
				if (checkpoints.stage > 0 && string.startsWith("name"))
					checkpoints.name = getstring("name", string, 0).replace('|', ',');
				if (string.startsWith("stagemaker"))
					checkpoints.maker = getstring("stagemaker", string, 0);
				if (string.startsWith("publish"))
					checkpoints.pubt = getint("publish", string, 0);
				if (string.startsWith("soundtrack")) {
					checkpoints.trackname = getstring("soundtrack", string, 0);
					checkpoints.trackvol = getint("soundtrack", string, 1);
					if (checkpoints.trackvol < 50)
						checkpoints.trackvol = 50;
					if (checkpoints.trackvol > 300)
						checkpoints.trackvol = 300;
					var_xtGraphics.sndsize[32] = getint("soundtrack", string, 2);
				}
				if (string.startsWith("maxr")) {
					final int i_128_ = getint("maxr", string, 0);
					final int i_129_ = getint("maxr", string, 1);
					i = i_129_;
					final int i_130_ = getint("maxr", string, 2);
					for (int i_131_ = 0; i_131_ < i_128_; i_131_++) {
						contos[nob] = new ContO(contos_108_[85], i_129_, medium.ground - contos_108_[85].grat,
								i_131_ * 4800 + i_130_, 0);
						nob++;
					}
					trackers.y[trackers.nt] = -5000;
					trackers.rady[trackers.nt] = 7100;
					trackers.x[trackers.nt] = i_129_ + 500;
					trackers.radx[trackers.nt] = 600;
					trackers.z[trackers.nt] = i_128_ * 4800 / 2 + i_130_ - 2400;
					trackers.radz[trackers.nt] = i_128_ * 4800 / 2;
					trackers.xy[trackers.nt] = 90;
					trackers.zy[trackers.nt] = 0;
					trackers.dam[trackers.nt] = 167;
					trackers.decor[trackers.nt] = false;
					trackers.skd[trackers.nt] = 0;
					trackers.nt++;
				}
				if (string.startsWith("maxl")) {
					final int i_132_ = getint("maxl", string, 0);
					final int i_133_ = getint("maxl", string, 1);
					i_109_ = i_133_;
					final int i_134_ = getint("maxl", string, 2);
					for (int i_135_ = 0; i_135_ < i_132_; i_135_++) {
						contos[nob] = new ContO(contos_108_[85], i_133_, medium.ground - contos_108_[85].grat,
								i_135_ * 4800 + i_134_, 180);
						nob++;
					}
					trackers.y[trackers.nt] = -5000;
					trackers.rady[trackers.nt] = 7100;
					trackers.x[trackers.nt] = i_133_ - 500;
					trackers.radx[trackers.nt] = 600;
					trackers.z[trackers.nt] = i_132_ * 4800 / 2 + i_134_ - 2400;
					trackers.radz[trackers.nt] = i_132_ * 4800 / 2;
					trackers.xy[trackers.nt] = -90;
					trackers.zy[trackers.nt] = 0;
					trackers.dam[trackers.nt] = 167;
					trackers.decor[trackers.nt] = false;
					trackers.skd[trackers.nt] = 0;
					trackers.nt++;
				}
				if (string.startsWith("maxt")) {
					final int i_136_ = getint("maxt", string, 0);
					final int i_137_ = getint("maxt", string, 1);
					i_110_ = i_137_;
					final int i_138_ = getint("maxt", string, 2);
					for (int i_139_ = 0; i_139_ < i_136_; i_139_++) {
						contos[nob] = new ContO(contos_108_[85], i_139_ * 4800 + i_138_,
								medium.ground - contos_108_[85].grat, i_137_, 90);
						nob++;
					}
					trackers.y[trackers.nt] = -5000;
					trackers.rady[trackers.nt] = 7100;
					trackers.z[trackers.nt] = i_137_ + 500;
					trackers.radz[trackers.nt] = 600;
					trackers.x[trackers.nt] = i_136_ * 4800 / 2 + i_138_ - 2400;
					trackers.radx[trackers.nt] = i_136_ * 4800 / 2;
					trackers.zy[trackers.nt] = 90;
					trackers.xy[trackers.nt] = 0;
					trackers.dam[trackers.nt] = 167;
					trackers.decor[trackers.nt] = false;
					trackers.skd[trackers.nt] = 0;
					trackers.nt++;
				}
				if (string.startsWith("maxb")) {
					final int i_140_ = getint("maxb", string, 0);
					final int i_141_ = getint("maxb", string, 1);
					i_111_ = i_141_;
					final int i_142_ = getint("maxb", string, 2);
					for (int i_143_ = 0; i_143_ < i_140_; i_143_++) {
						contos[nob] = new ContO(contos_108_[85], i_143_ * 4800 + i_142_,
								medium.ground - contos_108_[85].grat, i_141_, -90);
						nob++;
					}
					trackers.y[trackers.nt] = -5000;
					trackers.rady[trackers.nt] = 7100;
					trackers.z[trackers.nt] = i_141_ - 500;
					trackers.radz[trackers.nt] = 600;
					trackers.x[trackers.nt] = i_140_ * 4800 / 2 + i_142_ - 2400;
					trackers.radx[trackers.nt] = i_140_ * 4800 / 2;
					trackers.zy[trackers.nt] = -90;
					trackers.xy[trackers.nt] = 0;
					trackers.dam[trackers.nt] = 167;
					trackers.decor[trackers.nt] = false;
					trackers.skd[trackers.nt] = 0;
					trackers.nt++;
				}
			}
			datainputstream.close();
			medium.newpolys(i_109_, i - i_109_, i_111_, i_110_ - i_111_, trackers, notb);
			medium.newclouds(i_109_, i, i_111_, i_110_);
			medium.newmountains(i_109_, i, i_111_, i_110_);
			medium.newstars();
			trackers.devidetrackers(i_109_, i - i_109_, i_111_, i_110_ - i_111_);
		} catch (final Exception exception) {
			checkpoints.stage = -3;
			System.out.println(new StringBuilder().append("Error in stage ").append(checkpoints.stage).toString());
			System.out.println(new StringBuilder().append("").append(exception).toString());
			System.out.println(new StringBuilder().append("At line: ").append(string).toString());
		}
		if (checkpoints.nsp < 2)
			checkpoints.stage = -3;
		if (medium.nrw * medium.ncl >= 16000)
			checkpoints.stage = -3;
		if (checkpoints.stage != -3) {
			checkpoints.top20 = Math.abs(checkpoints.top20);
			if (checkpoints.stage == 26)
				medium.lightn = 0;
			else
				medium.lightn = -1;
			if (checkpoints.stage == 1 || checkpoints.stage == 11)
				medium.nochekflk = false;
			else
				medium.nochekflk = true;
			for (int i_144_ = 0; i_144_ < var_xtGraphics.nplayers; i_144_++)
				u[i_144_].reset(checkpoints, var_xtGraphics.sc[i_144_]);
			var_xtGraphics.resetstat(checkpoints.stage);
			checkpoints.calprox();
			for (int i_145_ = 0; i_145_ < var_xtGraphics.nplayers; i_145_++) {
				if (var_xtGraphics.fase == 22)
					var_xtGraphics.colorCar(contos_108_[var_xtGraphics.sc[i_145_]], i_145_);
				contos[i_145_] = new ContO(contos_108_[var_xtGraphics.sc[i_145_]], var_xtGraphics.xstart[i_145_],
						250 - contos_108_[var_xtGraphics.sc[i_145_]].grat, var_xtGraphics.zstart[i_145_], 0);
				mads[i_145_].reseto(var_xtGraphics.sc[i_145_], contos[i_145_], checkpoints);
			}
			if (var_xtGraphics.fase == 2 || var_xtGraphics.fase == -22) {
				medium.trx = (i_109_ + i) / 2;
				medium.trz = (i_110_ + i_111_) / 2;
				medium.ptr = 0;
				medium.ptcnt = -10;
				medium.hit = 45000;
				medium.fallen = 0;
				medium.nrnd = 0;
				medium.trk = 1;
				medium.ih = 25;
				medium.iw = 65;
				medium.h = 425;
				medium.w = 735;
				var_xtGraphics.fase = 1;
				mouses = 0;
			}
			if (var_xtGraphics.fase == 22) {
				medium.crs = false;
				var_xtGraphics.fase = 5;
			}
			if (checkpoints.stage > 0) {
				int i_146_ = checkpoints.stage;
				if (i_146_ > 27)
					i_146_ -= 27;
				else if (i_146_ > 10)
					i_146_ -= 10;
				var_xtGraphics.asay = new StringBuilder().append("Stage ").append(i_146_).append(":  ")
						.append(checkpoints.name).append(" ").toString();
			} else
				var_xtGraphics.asay = new StringBuilder().append("Custom Stage:  ").append(checkpoints.name).append(" ")
						.toString();
			record.reset(contos);
		} else if (var_xtGraphics.fase == 2)
			var_xtGraphics.fase = 1;
		System.gc();
	}

	public boolean loadstagePreview(final int i, final String string, final ContO[] contos, final ContO[] contos_147_,
			final Medium medium, final CheckPoints checkpoints) {
		boolean bool = true;
		if (i < 100) {
			checkpoints.stage = i;
			if (checkpoints.stage < 0)
				checkpoints.name = string;
		} else {
			checkpoints.stage = -2;
			if (sgame.getSelectedIndex() == 3 || sgame.getSelectedIndex() == 4)
				checkpoints.name = mstgs.getSelectedItem();
			else {
				final int i_148_ = mstgs.getSelectedItem().indexOf(" ") + 1;
				if (i_148_ > 0)
					checkpoints.name = mstgs.getSelectedItem().substring(i_148_);
			}
		}
		nob = 0;
		checkpoints.n = 0;
		checkpoints.nsp = 0;
		checkpoints.fn = 0;
		checkpoints.haltall = false;
		checkpoints.wasted = 0;
		checkpoints.catchfin = 0;
		medium.ground = 250;
		view = 0;
		medium.trx = 0L;
		medium.trz = 0L;
		int i_149_ = 0;
		int i_150_ = 100;
		int i_151_ = 0;
		int i_152_ = 100;
		String string_153_ = "";
		try {
			DataInputStream datainputstream;
			if (checkpoints.stage > 0) {
				final URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/stages/")
						.append(checkpoints.stage).append(".txt").toString());
				datainputstream = new DataInputStream(url.openStream());
			} else {
				String string_154_ = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/")
						.append(checkpoints.name).append(".radq").toString();
				string_154_ = string_154_.replace(' ', '_');
				final URL url = new URL(string_154_);
				final int i_155_ = url.openConnection().getContentLength();
				final DataInputStream datainputstream_156_ = new DataInputStream(url.openStream());
				final byte[] is = new byte[i_155_];
				datainputstream_156_.readFully(is);
				ZipInputStream zipinputstream;
				if (is[0] == 80 && is[1] == 75 && is[2] == 3)
					zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
				else {
					final byte[] is_157_ = new byte[i_155_ - 40];
					for (int i_158_ = 0; i_158_ < i_155_ - 40; i_158_++) {
						int i_159_ = 20;
						if (i_158_ >= 500)
							i_159_ = 40;
						is_157_[i_158_] = is[i_158_ + i_159_];
					}
					zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_157_));
				}
				final ZipEntry zipentry = zipinputstream.getNextEntry();
				int i_160_ = Integer.valueOf(zipentry.getName()).intValue();
				final byte[] is_161_ = new byte[i_160_];
				int i_162_ = 0;
				int i_163_;
				for ( /**/ ; i_160_ > 0; i_160_ -= i_163_) {
					i_163_ = zipinputstream.read(is_161_, i_162_, i_160_);
					i_162_ += i_163_;
				}
				zipinputstream.close();
				datainputstream_156_.close();
				datainputstream = new DataInputStream(new ByteArrayInputStream(is_161_));
			}
			String string_164_;
			while ((string_164_ = datainputstream.readLine()) != null) {
				string_153_ = new StringBuilder().append("").append(string_164_.trim()).toString();
				if (string_153_.startsWith("snap"))
					medium.setsnap(getint("snap", string_153_, 0), getint("snap", string_153_, 1),
							getint("snap", string_153_, 2));
				if (string_153_.startsWith("sky"))
					medium.setsky(getint("sky", string_153_, 0), getint("sky", string_153_, 1),
							getint("sky", string_153_, 2));
				if (string_153_.startsWith("ground"))
					medium.setgrnd(getint("ground", string_153_, 0), getint("ground", string_153_, 1),
							getint("ground", string_153_, 2));
				if (string_153_.startsWith("polys"))
					medium.setpolys(getint("polys", string_153_, 0), getint("polys", string_153_, 1),
							getint("polys", string_153_, 2));
				if (string_153_.startsWith("fog"))
					medium.setfade(getint("fog", string_153_, 0), getint("fog", string_153_, 1),
							getint("fog", string_153_, 2));
				if (string_153_.startsWith("texture"))
					medium.setexture(getint("texture", string_153_, 0), getint("texture", string_153_, 1),
							getint("texture", string_153_, 2), getint("texture", string_153_, 3));
				if (string_153_.startsWith("clouds"))
					medium.setcloads(getint("clouds", string_153_, 0), getint("clouds", string_153_, 1),
							getint("clouds", string_153_, 2), getint("clouds", string_153_, 3),
							getint("clouds", string_153_, 4));
				if (string_153_.startsWith("density")) {
					medium.fogd = (getint("density", string_153_, 0) + 1) * 2 - 1;
					if (medium.fogd < 1)
						medium.fogd = 1;
					if (medium.fogd > 30)
						medium.fogd = 30;
				}
				if (string_153_.startsWith("fadefrom"))
					medium.fadfrom(getint("fadefrom", string_153_, 0));
				if (string_153_.startsWith("lightson"))
					medium.lightson = true;
				if (string_153_.startsWith("mountains"))
					medium.mgen = getint("mountains", string_153_, 0);
				if (string_153_.startsWith("soundtrack")) {
					checkpoints.trackname = getstring("soundtrack", string_153_, 0);
					checkpoints.trackvol = getint("soundtrack", string_153_, 1);
					if (checkpoints.trackvol < 50)
						checkpoints.trackvol = 50;
					if (checkpoints.trackvol > 300)
						checkpoints.trackvol = 300;
				}
				if (string_153_.startsWith("set")) {
					int i_165_ = getint("set", string_153_, 0);
					i_165_ += 46;
					contos[nob] = new ContO(contos_147_[i_165_], getint("set", string_153_, 1),
							medium.ground - contos_147_[i_165_].grat, getint("set", string_153_, 2),
							getint("set", string_153_, 3));
					contos[nob].t.nt = 0;
					if (string_153_.indexOf(")p") != -1) {
						checkpoints.x[checkpoints.n] = getint("chk", string_153_, 1);
						checkpoints.z[checkpoints.n] = getint("chk", string_153_, 2);
						checkpoints.y[checkpoints.n] = 0;
						checkpoints.typ[checkpoints.n] = 0;
						if (string_153_.indexOf(")pt") != -1)
							checkpoints.typ[checkpoints.n] = -1;
						if (string_153_.indexOf(")pr") != -1)
							checkpoints.typ[checkpoints.n] = -2;
						if (string_153_.indexOf(")po") != -1)
							checkpoints.typ[checkpoints.n] = -3;
						if (string_153_.indexOf(")ph") != -1)
							checkpoints.typ[checkpoints.n] = -4;
						if (string_153_.indexOf("out") != -1)
							System.out.println(new StringBuilder().append("out: ").append(checkpoints.n).toString());
						checkpoints.n++;
					}
					nob++;
				}
				if (string_153_.startsWith("chk")) {
					int i_166_ = getint("chk", string_153_, 0);
					i_166_ += 46;
					int i_167_ = medium.ground - contos_147_[i_166_].grat;
					if (i_166_ == 110)
						i_167_ = getint("chk", string_153_, 4);
					contos[nob] = new ContO(contos_147_[i_166_], getint("chk", string_153_, 1), i_167_,
							getint("chk", string_153_, 2), getint("chk", string_153_, 3));
					checkpoints.x[checkpoints.n] = getint("chk", string_153_, 1);
					checkpoints.z[checkpoints.n] = getint("chk", string_153_, 2);
					checkpoints.y[checkpoints.n] = i_167_;
					if (getint("chk", string_153_, 3) == 0)
						checkpoints.typ[checkpoints.n] = 1;
					else
						checkpoints.typ[checkpoints.n] = 2;
					checkpoints.pcs = checkpoints.n;
					checkpoints.n++;
					contos[nob].checkpoint = checkpoints.nsp + 1;
					checkpoints.nsp++;
					nob++;
				}
				if (string_153_.startsWith("fix")) {
					int i_168_ = getint("fix", string_153_, 0);
					i_168_ += 46;
					contos[nob] = new ContO(contos_147_[i_168_], getint("fix", string_153_, 1),
							getint("fix", string_153_, 3), getint("fix", string_153_, 2),
							getint("fix", string_153_, 4));
					checkpoints.fx[checkpoints.fn] = getint("fix", string_153_, 1);
					checkpoints.fz[checkpoints.fn] = getint("fix", string_153_, 2);
					checkpoints.fy[checkpoints.fn] = getint("fix", string_153_, 3);
					contos[nob].elec = true;
					if (getint("fix", string_153_, 4) != 0) {
						checkpoints.roted[checkpoints.fn] = true;
						contos[nob].roted = true;
					} else
						checkpoints.roted[checkpoints.fn] = false;
					if (string_153_.indexOf(")s") != -1)
						checkpoints.special[checkpoints.fn] = true;
					else
						checkpoints.special[checkpoints.fn] = false;
					checkpoints.fn++;
					nob++;
				}
				if (string_153_.startsWith("nlaps")) {
					checkpoints.nlaps = getint("nlaps", string_153_, 0);
					if (checkpoints.nlaps < 1)
						checkpoints.nlaps = 1;
					if (checkpoints.nlaps > 15)
						checkpoints.nlaps = 15;
				}
				if (checkpoints.stage > 0 && string_153_.startsWith("name"))
					checkpoints.name = getstring("name", string_153_, 0).replace('|', ',');
				if (string_153_.startsWith("stagemaker"))
					checkpoints.maker = getstring("stagemaker", string_153_, 0);
				if (string_153_.startsWith("publish"))
					checkpoints.pubt = getint("publish", string_153_, 0);
				if (string_153_.startsWith("maxr")) {
					final int i_169_ = getint("maxr", string_153_, 1);
					i_149_ = i_169_;
				}
				if (string_153_.startsWith("maxl")) {
					final int i_170_ = getint("maxl", string_153_, 1);
					i_150_ = i_170_;
				}
				if (string_153_.startsWith("maxt")) {
					final int i_171_ = getint("maxt", string_153_, 1);
					i_151_ = i_171_;
				}
				if (string_153_.startsWith("maxb")) {
					final int i_172_ = getint("maxb", string_153_, 1);
					i_152_ = i_172_;
				}
			}
			datainputstream.close();
			medium.newpolys(i_150_, i_149_ - i_150_, i_152_, i_151_ - i_152_, null, notb);
			medium.newclouds(i_150_, i_149_, i_152_, i_151_);
			medium.newmountains(i_150_, i_149_, i_152_, i_151_);
			medium.newstars();
		} catch (final Exception exception) {
			bool = false;
			System.out.println(new StringBuilder().append("Error in stage ").append(checkpoints.stage).toString());
			System.out.println(new StringBuilder().append("").append(exception).toString());
			System.out.println(new StringBuilder().append("At line: ").append(string_153_).toString());
		}
		if (checkpoints.nsp < 2)
			bool = false;
		if (medium.nrw * medium.ncl >= 16000)
			bool = false;
		medium.trx = (i_150_ + i_149_) / 2;
		medium.trz = (i_151_ + i_152_) / 2;
		System.gc();
		return bool;
	}

	@Override
	public boolean lostFocus(final Event event, final Object object) {
		if (!exwist && !lostfcs) {
			lostfcs = true;
			fcscnt = 10;
			if (u[0] != null) {
				if (u[0].multion == 0)
					u[0].falseo(1);
				else if (u[0].chatup == 0)
					requestFocus();
				setCursor(new Cursor(0));
			}
		}
		return false;
	}

	public void madlink() {
		openurl("http://www.needformadness.com/");
	}

	public void mouseW(final int i) {
		if (!exwist)
			mousew += i * 4;
	}

	public void movefield(final Component component, int i, int i_99_, final int i_100_, final int i_101_) {
		if (i_100_ == 360 || i_100_ == 576) {
			i = (int) (i * apmult + apx + component.getWidth() / 2 * (apmult - 1.0F));
			i_99_ = (int) (i_99_ * apmult + apy + 12.0F * (apmult - 1.0F));
		} else {
			i = (int) (i * apmult + apx);
			i_99_ = (int) (i_99_ * apmult + apy + 12.0F * (apmult - 1.0F));
		}
		if (component.getX() != i || component.getY() != i_99_)
			component.setBounds(i, i_99_, i_100_, i_101_);
	}

	public void movefielda(final TextArea textarea, int i, int i_105_, final int i_106_, final int i_107_) {
		if (applejava) {
			if (xm > i && xm < i + i_106_ && ym > i_105_ && ym < i_105_ + i_107_ || !textarea.getText().equals(" ")) {
				if (!textarea.isShowing()) {
					textarea.setVisible(true);
					textarea.requestFocus();
				}
				if (i_106_ == 360 || i_106_ == 576) {
					i = (int) (i * apmult + apx + textarea.getWidth() / 2 * (apmult - 1.0F));
					i_105_ = (int) (i_105_ * apmult + apy + 12.0F * (apmult - 1.0F));
				} else {
					i = (int) (i * apmult + apx);
					i_105_ = (int) (i_105_ * apmult + apy + 12.0F * (apmult - 1.0F));
				}
				if (textarea.getX() != i || textarea.getY() != i_105_)
					textarea.setBounds(i, i_105_, i_106_, i_107_);
			} else {
				if (textarea.isShowing()) {
					textarea.setVisible(false);
					requestFocus();
				}
				rd.setColor(textarea.getBackground());
				rd.fillRect(i, i_105_, i_106_ - 1, i_107_ - 1);
				rd.setColor(textarea.getBackground().darker());
				rd.drawRect(i, i_105_, i_106_ - 1, i_107_ - 1);
			}
		} else {
			if (!textarea.isShowing())
				textarea.setVisible(true);
			movefield(textarea, i, i_105_, i_106_, i_107_);
		}
	}

	public void movefieldd(final TextField textfield, int i, int i_102_, final int i_103_, final int i_104_,
			final boolean bool) {
		if (applejava) {
			if (bool)
				if (xm > i && xm < i + i_103_ && ym > i_102_ && ym < i_102_ + i_104_
						|| !textfield.getText().equals("")) {
					if (!textfield.isShowing()) {
						textfield.setVisible(true);
						textfield.requestFocus();
					}
					if (i_103_ == 360 || i_103_ == 576) {
						i = (int) (i * apmult + apx + textfield.getWidth() / 2 * (apmult - 1.0F));
						i_102_ = (int) (i_102_ * apmult + apy + 12.0F * (apmult - 1.0F));
					} else {
						i = (int) (i * apmult + apx);
						i_102_ = (int) (i_102_ * apmult + apy + 12.0F * (apmult - 1.0F));
					}
					if (textfield.getX() != i || textfield.getY() != i_102_)
						textfield.setBounds(i, i_102_, i_103_, i_104_);
				} else {
					if (textfield.isShowing()) {
						textfield.setVisible(false);
						requestFocus();
					}
					rd.setColor(textfield.getBackground());
					rd.fillRect(i, i_102_, i_103_ - 1, i_104_ - 1);
					rd.setColor(textfield.getBackground().darker());
					rd.drawRect(i, i_102_, i_103_ - 1, i_104_ - 1);
				}
		} else {
			if (bool && !textfield.isShowing())
				textfield.setVisible(true);
			movefield(textfield, i, i_102_, i_103_, i_104_);
		}
	}

	public void multlink() {
		openurl("http://multiplayer.needformadness.com/");
	}

	public void musiclink() {
		openurl("http://multiplayer.needformadness.com/music.html");
	}

	public void onfmmlink() {
		openurl("https://github.com/chrishansen69/OpenNFMM");
	}

	public void openurl(final String string) {
		if (Desktop.isDesktopSupported())
			try {
				Desktop.getDesktop().browse(new URI(string));
			} catch (final Exception exception) {
				/* empty */
			}
		else
			try {
				Runtime.getRuntime().exec(new StringBuilder().append("").append(Madness.urlopen()).append(" ")
						.append(string).append("").toString());
			} catch (final Exception exception) {
				/* empty */
			}
	}

	@Override
	public void paintComponent(final Graphics graphics) {
		final Graphics2D graphics2d = (Graphics2D) graphics;
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		gameTick();
		if (lastw != getWidth() || lasth != getHeight()) {
			lastw = getWidth();
			lasth = getHeight();
			showsize = 100;
			if (lastw <= 800 || lasth <= 550)
				reqmult = 0.0F;
			if (Madness.fullscreen) {
				apx = (int) (getWidth() / 2 - 400.0F * apmult);
				apy = (int) (getHeight() / 2 - 225.0F * apmult);
			}
		}
		int i = 0;
		int i_97_ = 0;
		if (moto == 1 && shaka > 0) {
			i = (int) ((shaka * 2 * Math.random() - shaka) * apmult);
			i_97_ = (int) ((shaka * 2 * Math.random() - shaka) * apmult);
			shaka--;
		}
		if (!Madness.fullscreen) {
			if (showsize != 0) {
				if (showsize == 100 || showsize == 70)
					graphics2d.clearRect(0, 0, getWidth(), getHeight());
				float f = (getWidth() - 40) / 800.0F - 1.0F;
				if (f > (getHeight() - 70) / 450.0F - 1.0F)
					f = (getHeight() - 70) / 450.0F - 1.0F;
				if (f > 1.0F)
					f = 1.0F;
				if (f < 0.0F)
					f = 0.0F;
				apmult = 1.0F + f * reqmult;
				if (!oncarm)
					graphics2d.drawImage(carmaker[0], 50, 14, this);
				else
					graphics2d.drawImage(carmaker[1], 50, 14, this);
				if (!onstgm)
					graphics2d.drawImage(stagemaker[0], getWidth() - 208, 14, this);
				else
					graphics2d.drawImage(stagemaker[1], getWidth() - 208, 14, this);
				graphics2d.drawImage(sizebar, getWidth() / 2 - 230, 23, this);
				graphics2d.drawImage(blb, (int) (getWidth() / 2 - 222 + 141.0F * reqmult), 23, this);
				graphics2d.drawImage(chkbx[smooth], getWidth() / 2 - 53, 23, this);
				graphics2d.setFont(new Font("Arial", 1, 11));
				graphics2d.setColor(new Color(74, 99, 125));
				graphics2d.drawString("Screen Size:", getWidth() / 2 - 224, 17);
				graphics2d.drawString("Smooth", getWidth() / 2 - 36, 34);
				graphics2d.drawImage(fulls, getWidth() / 2 + 27, 15, this);
				graphics2d.setColor(new Color(94, 126, 159));
				graphics2d.drawString("Fullscreen", getWidth() / 2 + 63, 30);
				graphics2d.drawImage(chkbx[Madness.anti], getWidth() / 2 + 135, 9, this);
				graphics2d.drawString("Antialiasing", getWidth() / 2 + 152, 20);
				graphics2d.drawImage(chkbx[moto], getWidth() / 2 + 135, 26, this);
				graphics2d.drawString("Motion Effects", getWidth() / 2 + 152, 37);
				graphics2d.setColor(new Color(0, 0, 0));
				graphics2d.fillRect(getWidth() / 2 - 153, 5, 80, 16);
				graphics2d.setColor(new Color(121, 135, 152));
				String string = new StringBuilder().append("").append((int) (apmult * 100.0F)).append("%").toString();
				if (reqmult == 0.0F)
					string = "Original";
				if (reqmult == 1.0F)
					string = "Maximum";
				graphics2d.drawString(string, getWidth() / 2 - 150, 17);
				if (!oncarm && !onstgm)
					showsize--;
				if (showsize == 0) {
					graphics2d.setColor(new Color(0, 0, 0));
					graphics2d.fillRect(getWidth() / 2 - 260, 0, 520, 40);
					graphics2d.fillRect(50, 14, 142, 23);
					graphics2d.fillRect(getWidth() - 208, 14, 158, 23);
				}
			}
			apx = (int) (getWidth() / 2 - 400.0F * apmult);
			apy = (int) (getHeight() / 2 - 225.0F * apmult - 50.0F);
			if (apy < 50)
				apy = 50;
			if (apmult > 1.0F) {
				if (smooth == 1) {
					graphics2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
							RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					if (moto == 1) {
						graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
						rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
								RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
						graphics2d.drawImage(offImage, apx + i, apy + i_97_, (int) (800.0F * apmult),
								(int) (450.0F * apmult), this);
						cropit(graphics2d, i, i_97_);
					} else
						graphics2d.drawImage(offImage, apx, apy, (int) (800.0F * apmult), (int) (450.0F * apmult),
								this);
				} else if (moto == 1) {
					graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
					rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
							RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
					graphics2d.drawImage(offImage, apx + i, apy + i_97_, (int) (800.0F * apmult),
							(int) (450.0F * apmult), this);
					cropit(graphics2d, i, i_97_);
				} else
					graphics2d.drawImage(offImage, apx, apy, (int) (800.0F * apmult), (int) (450.0F * apmult), this);
			} else if (moto == 1) {
				graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
				rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
						RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
				graphics2d.drawImage(offImage, apx + i, apy + i_97_, this);
				cropit(graphics2d, i, i_97_);
			} else
				graphics2d.drawImage(offImage, apx, apy, this);
		} else if (moto == 1) {
			graphics2d.setComposite(AlphaComposite.getInstance(3, mvect / 100.0F));
			rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
			graphics2d.drawImage(offImage, apx + i, apy + i_97_, this);
			cropit(graphics2d, i, i_97_);
		} else
			graphics2d.drawImage(offImage, apx, apy, this);
	}

	public void readcookies(final xtGraphics var_xtGraphics, final CarDefine cardefine, final ContO[] contos) {
		var_xtGraphics.nickname = "";
		try {
			final File file = new File(
					new StringBuilder().append("").append(Madness.fpath).append("data/user.data").toString());
			final String[] strings = { "", "", "", "", "" };
			if (file.exists()) {
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string;
				for (int i = 0; (string = bufferedreader.readLine()) != null && i < 5; i++)
					strings[i] = string;
				bufferedreader.close();
			}
			if (strings[0].startsWith("lastuser")) {
				var_xtGraphics.nickname = getstring("lastuser", strings[0], 0);
				if (!var_xtGraphics.nickname.equals(""))
					var_xtGraphics.opselect = 1;
				String string = "";
				try {
					string = getstring("lastuser", strings[0], 1);
				} catch (final Exception exception) {
					string = "";
				}
				if (!string.equals("")) {
					tnick.setText(var_xtGraphics.nickname);
					tpass.setText(string);
					var_xtGraphics.autolog = true;
				}
			}
			if (strings[2].startsWith("NFM1")) {
				int i = getint("NFM1", strings[2], 0);
				if (i >= 0 && i < 16) {
					var_xtGraphics.scm[0] = i;
					var_xtGraphics.firstime = false;
				}
				i = getint("NFM1", strings[2], 1);
				if (i >= 1 && i <= 11)
					var_xtGraphics.unlocked[0] = i;
			}
			if (strings[3].startsWith("NFM2")) {
				int i = getint("NFM2", strings[3], 0);
				if (i >= 0 && i < 16) {
					var_xtGraphics.scm[1] = i;
					var_xtGraphics.firstime = false;
				}
				i = getint("NFM2", strings[3], 1);
				if (i >= 1 && i <= 17)
					var_xtGraphics.unlocked[1] = i;
			}
			if (strings[4].startsWith("graphics")) {
				int i = getint("graphics", strings[4], 0);
				if (i >= 0 && i <= 1)
					moto = i;
				i = getint("graphics", strings[4], 1);
				if (i >= 0 && i <= 1)
					Madness.anti = i;
			}
			if (strings[1].startsWith("lastcar")) {
				int i = getint("lastcar", strings[1], 0);
				cardefine.lastcar = getstring("lastcar", strings[1], 7);
				if (i >= 0 && i < 36) {
					var_xtGraphics.osc = i;
					var_xtGraphics.firstime = false;
				}
				int i_198_ = 0;
				for (int i_199_ = 0; i_199_ < 6; i_199_++) {
					i = getint("lastcar", strings[1], i_199_ + 1);
					if (i >= 0 && i <= 100) {
						var_xtGraphics.arnp[i_199_] = i / 100.0F;
						i_198_++;
					}
				}
				if (i_198_ == 6 && var_xtGraphics.osc >= 0 && var_xtGraphics.osc <= 15) {
					final Color color = Color.getHSBColor(var_xtGraphics.arnp[0], var_xtGraphics.arnp[1],
							1.0F - var_xtGraphics.arnp[2]);
					final Color color_200_ = Color.getHSBColor(var_xtGraphics.arnp[3], var_xtGraphics.arnp[4],
							1.0F - var_xtGraphics.arnp[5]);
					for (int i_201_ = 0; i_201_ < contos[var_xtGraphics.osc].npl; i_201_++)
						if (contos[var_xtGraphics.osc].p[i_201_].colnum == 1) {
							contos[var_xtGraphics.osc].p[i_201_].c[0] = color.getRed();
							contos[var_xtGraphics.osc].p[i_201_].c[1] = color.getGreen();
							contos[var_xtGraphics.osc].p[i_201_].c[2] = color.getBlue();
						}
					for (int i_202_ = 0; i_202_ < contos[var_xtGraphics.osc].npl; i_202_++)
						if (contos[var_xtGraphics.osc].p[i_202_].colnum == 2) {
							contos[var_xtGraphics.osc].p[i_202_].c[0] = color_200_.getRed();
							contos[var_xtGraphics.osc].p[i_202_].c[1] = color_200_.getGreen();
							contos[var_xtGraphics.osc].p[i_202_].c[2] = color_200_.getBlue();
						}
				}
			}
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public void reglink() {
		openurl("http://multiplayer.needformadness.com/register.html?ref=game");
	}

	public void regnew() {
		openurl("http://multiplayer.needformadness.com/registernew.pl");
	}

	public void regprom() {
		/* empty */
	}

	public void makeMenus() {
		rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		sgame.add(rd, " NFM 1     ");
		sgame.add(rd, " NFM 2     ");
		sgame.add(rd, " My Stages ");
		sgame.add(rd, " Weekly Top20 ");
		sgame.add(rd, " Monthly Top20 ");
		sgame.add(rd, " All Time Top20 ");
		sgame.add(rd, " Stage Maker ");
		wgame.add(rd, " Normal Game");
		wgame.add(rd, " War / Battle");
		wgame.add(rd, " War / Battle - Practice");
		warb.add(rd, " Loading your clan's wars and battles, please wait...");
		pgame.add(rd, " Select the game you want to practice");
		vnpls.add(rd, "Players");
		vnpls.add(rd, " 2 VS 2");
		vnpls.add(rd, " 3 VS 3");
		vnpls.add(rd, " 4 VS 4");
		vtyp.add(rd, "Normal clan game");
		vtyp.add(rd, "Racing only");
		vtyp.add(rd, "Wasting only");
		vtyp.add(rd, "Racers VS Wasters - my clan wastes");
		vtyp.add(rd, "Racers VS Wasters - my clan races");
		snfmm.add(rd, "Select Stage");
		snfm1.add(rd, "Select Stage");
		snfm2.add(rd, "Select Stage");
		mstgs.add(rd, "Suddenly the King becomes Santa's Little Helper");
		mcars.add(rd, "Sword of Justice");
		snpls.add(rd, "Select");
		swait.add(rd, "1 Minute");
		ilaps.add(rd, "Laps");
		ilaps.add(rd, "1 Lap");
		for (int i = 0; i < 5; i++)
			snfmm.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());
		for (int i = 0; i < 10; i++)
			snfm1.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());
		for (int i = 0; i < 17; i++)
			snfm2.add(rd, new StringBuilder().append(" Stage ").append(i + 1).append("").toString());
		for (int i = 0; i < 7; i++)
			snpls.add(rd, new StringBuilder().append("    ").append(i + 2).append("").toString());
		for (int i = 0; i < 7; i++)
			snbts.add(rd, new StringBuilder().append("    ").append(i).append("    ").toString());
		for (int i = 0; i < 2; i++)
			swait.add(rd, new StringBuilder().append("").append(i + 2).append(" Minutes").toString());
		for (int i = 0; i < 15; i++)
			slaps.add(rd, new StringBuilder().append("").append(i + 1).append("").toString());
		for (int i = 0; i < 14; i++)
			ilaps.add(rd, new StringBuilder().append("").append(i + 2).append(" Laps").toString());
		sclass.add(rd, "All Classes");
		sclass.add(rd, "Class C Cars");
		sclass.add(rd, "Class B & C Cars");
		sclass.add(rd, "Class B Cars");
		sclass.add(rd, "Class A & B Cars");
		sclass.add(rd, "Class A Cars");
		scars.add(rd, "All Cars");
		scars.add(rd, "Custom Cars");
		scars.add(rd, "Game Cars");
		sfix.add(rd, "Unlimited Fixing");
		sfix.add(rd, "4 Fixes");
		sfix.add(rd, "3 Fixes");
		sfix.add(rd, "2 Fixes");
		sfix.add(rd, "1 Fix");
		sfix.add(rd, "No Fixing");
		icars.add(rd, "Type of Cars");
		icars.add(rd, "All Cars");
		icars.add(rd, "Clan Cars");
		icars.add(rd, "Game Cars");
		icars.w = 140;
		gmode.add(rd, " Normal Game ");
		gmode.add(rd, " Practice Game ");
		rooms.rooms = true;
		rooms.add(rd, "Ghostrider :: 1");
		sendtyp.add(rd, "Write a Message");
		sendtyp.add(rd, "Share a Custom Car");
		sendtyp.add(rd, "Share a Custom Stage");
		sendtyp.add(rd, "Send a Clan Invitation");
		sendtyp.add(rd, "Share a Relative Date");
		senditem.add(rd, "Suddenly the King becomes Santa's Little Helper");
		for (int i = 0; i < 6; i++)
			clanlev.add(rd, new StringBuilder().append("").append(i + 1).append("").toString());
		clanlev.add(rd, "7 - Admin");
		hidefields();
	}

	public GameSparker() {
		initApplet();
        setBorder(BorderFactory.createLineBorder(Color.black));
        //
        setBackground(new Color(0, 0, 0));

		//rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		//rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		setLayout(null);
		//dr = new DebugRunner();
		//dr.start();

		offImage = new BufferedImage(800, 450, BufferedImage.TYPE_INT_ARGB);
		if (offImage != null)
			rd = offImage.createGraphics();
		makeMenus();
		initialize();
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		requestFocusInWindow();
		//ActionListener animate =
        /*ActionListener count = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                counted++;
            }
        };*/
		// 40 - 25 fps
        // 33 - 30 fps
		// 25 - 40 fps
        Timer timer = new Timer(25, this);
        timer.start();
        /*Timer counter = new Timer(1, count);
        counter.start();*/
        //timer.setDelay(delay);
	}



	//allan please remove this soon
	private Date date;
	private int i_7_;
	private xtGraphics var_xtGraphics;
	private ContO[] contos;
	private ContO[] contos_0_;
	private Mad[] mads;
	private Medium medium;
	private Trackers trackers;
	private CheckPoints checkpoints;
	private CarDefine cardefine;
	private Login login = null;
	private Lobby lobby = null;
	private Globe globe = null;
	private UDPMistro udpmistro = new UDPMistro();
	private boolean bool = false;
	Record record;
	private int i_6_;
	private int i_8_;
	private int i_9_;
	private boolean bool_10_;
	private long l_1_;
	private float f_2_;
	private boolean bool_3_;
	private int i_4_;
	private int i_5_;
	private float f;
	//@Override
	public void initialize() {
		rd.setColor(new Color(0, 0, 0));
		rd.fillRect(0, 0, 800, 450);
		repaint();
		requestFocus();
		if (System.getProperty("java.vendor").toLowerCase().indexOf("apple") != -1)
			applejava = true;
		medium = new Medium();
		trackers = new Trackers();
		checkpoints = new CheckPoints();
		contos = new ContO[124];
		cardefine = new CarDefine(contos, medium, trackers, this);
		var_xtGraphics = new xtGraphics(medium, cardefine, rd, this);
		sizebar = var_xtGraphics.getImage("data/sizebar.gif");
		blb = var_xtGraphics.getImage("data/b.gif");
		fulls = var_xtGraphics.getImage("data/fullscreen.gif");
		chkbx[0] = var_xtGraphics.getImage("data/checkbox1.gif");
		chkbx[1] = var_xtGraphics.getImage("data/checkbox2.gif");
		carmaker[0] = var_xtGraphics.getImage("data/carmaker1.gif");
		carmaker[1] = var_xtGraphics.getImage("data/carmaker2.gif");
		stagemaker[0] = var_xtGraphics.getImage("data/stagemaker1.gif");
		stagemaker[1] = var_xtGraphics.getImage("data/stagemaker2.gif");
		var_xtGraphics.loaddata();
		//login = null;
		//lobby = null;
		//globe = null;
		//boolean bool = false;
		//final UDPMistro udpmistro = new UDPMistro();
		record = new Record(medium);
		loadbase(contos, medium, trackers, var_xtGraphics, false);
		contos_0_ = new ContO[10000];
		mads = new Mad[8];
		for (int i = 0; i < 8; i++) {
			mads[i] = new Mad(cardefine, medium, record, var_xtGraphics, i);
			u[i] = new Control(medium);
		}
		f = 47.0F;
		readcookies(var_xtGraphics, cardefine, contos);
		var_xtGraphics.testdrive = Madness.testdrive;
		if (var_xtGraphics.testdrive != 0)
			if (var_xtGraphics.testdrive <= 2) {
				var_xtGraphics.sc[0] = cardefine.loadcar(Madness.testcar, 16);
				if (var_xtGraphics.sc[0] != -1)
					var_xtGraphics.fase = -9;
				else {
					Madness.testcar = "Failx12";
					Madness.carmaker();
				}
			} else {
				checkpoints.name = Madness.testcar;
				var_xtGraphics.fase = -9;
			}
		var_xtGraphics.stoploading();
		requestFocus();
		if (var_xtGraphics.testdrive == 0 && var_xtGraphics.firstime)
			setupini();
		System.gc();
		date = new Date();
		l_1_ = date.getTime();
		f_2_ = 30.0F;
		bool_3_ = false;
		i_4_ = 530;
		i_5_ = 0;
		i_6_ = 0;
		i_7_ = 0;
		i_8_ = 0;
		i_9_ = 0;
		bool_10_ = false;

		//while (!Thread.currentThread().isInterrupted()) {}
	}

	public void gameTick() {

			date = new Date();
			date.getTime();
			if (var_xtGraphics.fase == 111) {
				if (mouses == 1)
					i_7_ = 800;
				if (i_7_ < 800) {
					var_xtGraphics.clicknow();
					i_7_++;
				} else {
					i_7_ = 0;
					if (!exwist)
						var_xtGraphics.fase = 9;
					mouses = 0;
					lostfcs = false;
				}
			}
			if (var_xtGraphics.fase == 9)
				if (i_7_ < 76) {
					var_xtGraphics.rad(i_7_);
					catchlink();
					if (mouses == 2)
						mouses = 0;
					if (mouses == 1)
						mouses = 2;
					i_7_++;
				} else {
					i_7_ = 0;
					var_xtGraphics.fase = 10;
					mouses = 0;
					u[0].falseo(0);
				}
			if (var_xtGraphics.fase == -9) {
				if (var_xtGraphics.loadedt) {
					var_xtGraphics.mainbg(-101);
					rd.setColor(new Color(0, 0, 0));
					rd.fillRect(0, 0, 800, 450);
					repaint();
					var_xtGraphics.strack.unload();
					var_xtGraphics.strack = null;
					var_xtGraphics.flexpix = null;
					var_xtGraphics.fleximg = null;
					System.gc();
					var_xtGraphics.loadedt = false;
				}
				if (i_7_ < 2) {
					var_xtGraphics.mainbg(-101);
					rd.setColor(new Color(0, 0, 0));
					rd.fillRect(65, 25, 670, 400);
					i_7_++;
				} else {
					checkmemory(var_xtGraphics);
					var_xtGraphics.inishcarselect(contos);
					i_7_ = 0;
					var_xtGraphics.fase = 7;
					mvect = 50;
					mouses = 0;
				}
			}
			if (var_xtGraphics.fase == 8) {
				var_xtGraphics.credits(u[0], xm, ym, mouses);
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (var_xtGraphics.flipo <= 100)
					catchlink();
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
			}
			if (var_xtGraphics.fase == 10) {
				mvect = 100;
				var_xtGraphics.maini(u[0]);
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
			}
			if (var_xtGraphics.fase == 102) {
				mvect = 100;
				if (var_xtGraphics.loadedt) {
					rd.setColor(new Color(0, 0, 0));
					rd.fillRect(0, 0, 800, 450);
					repaint();
					checkmemory(var_xtGraphics);
					var_xtGraphics.strack.unload();
					var_xtGraphics.strack = null;
					var_xtGraphics.flexpix = null;
					var_xtGraphics.fleximg = null;
					System.gc();
					var_xtGraphics.loadedt = false;
				}
				if (var_xtGraphics.testdrive == 1 || var_xtGraphics.testdrive == 2)
					Madness.carmaker();
				if (var_xtGraphics.testdrive == 3 || var_xtGraphics.testdrive == 4)
					Madness.stagemaker();
				var_xtGraphics.maini2(u[0], xm, ym, mouses);
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
			}
			if (var_xtGraphics.fase == -22) {
				checkpoints.name = Madness.testcar;
				checkpoints.stage = -1;
				loadstage(contos_0_, contos, medium, trackers, checkpoints, var_xtGraphics, mads, record);
				if (checkpoints.stage == -3) {
					Madness.testcar = "Failx12";
					Madness.stagemaker();
				}
			}
			if (var_xtGraphics.fase == 11) {
				var_xtGraphics.inst(u[0]);
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
			}
			if (var_xtGraphics.fase == -5) {
				mvect = 100;
				var_xtGraphics.finish(checkpoints, contos, u[0], xm, ym, moused);
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
			}
			if (var_xtGraphics.fase == 7) {
				var_xtGraphics.carselect(u[0], contos, mads[0], xm, ym, moused);
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
				drawms();
			}
			if (var_xtGraphics.fase == 6) {
				var_xtGraphics.musicomp(checkpoints.stage, u[0]);
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
			}
			if (var_xtGraphics.fase == 5) {
				mvect = 100;
				var_xtGraphics.loadmusic(checkpoints.stage, checkpoints.trackname, checkpoints.trackvol);
			}
			if (var_xtGraphics.fase == 4) {
				var_xtGraphics.cantgo(u[0]);
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
			}
			if (var_xtGraphics.fase == 3) {
				rd.setColor(new Color(0, 0, 0));
				rd.fillRect(65, 25, 670, 400);
				repaint();
				var_xtGraphics.inishstageselect(checkpoints);
			}
			if (var_xtGraphics.fase == 2) {
				mvect = 100;
				var_xtGraphics.loadingstage(checkpoints.stage, true);
				checkpoints.nfix = 0;
				checkpoints.notb = false;
				loadstage(contos_0_, contos, medium, trackers, checkpoints, var_xtGraphics, mads, record);
				u[0].falseo(0);
				udpmistro.freg = 0.0F;
				mvect = 20;
			}
			if (var_xtGraphics.fase == 1) {
				var_xtGraphics.trackbg(false);
				rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
				if (checkpoints.stage != -3) {
					medium.aroundtrack(checkpoints);
					if (medium.hit == 5000 && mvect < 40)
						mvect++;
					int i_12_ = 0;
					final int[] is = new int[1000];
					for (int i_13_ = var_xtGraphics.nplayers; i_13_ < notb; i_13_++)
						if (contos_0_[i_13_].dist != 0) {
							is[i_12_] = i_13_;
							i_12_++;
						} else
							contos_0_[i_13_].d(rd);
					final int[] is_14_ = new int[i_12_];
					for (int i_15_ = 0; i_15_ < i_12_; i_15_++)
						is_14_[i_15_] = 0;
					for (int i_16_ = 0; i_16_ < i_12_; i_16_++)
						for (int i_17_ = i_16_ + 1; i_17_ < i_12_; i_17_++)
							if (contos_0_[is[i_16_]].dist != contos_0_[is[i_17_]].dist) {
								if (contos_0_[is[i_16_]].dist < contos_0_[is[i_17_]].dist)
									is_14_[i_16_]++;
								else
									is_14_[i_17_]++;
							} else if (i_17_ > i_16_)
								is_14_[i_16_]++;
							else
								is_14_[i_17_]++;
					for (int i_18_ = 0; i_18_ < i_12_; i_18_++)
						for (int i_19_ = 0; i_19_ < i_12_; i_19_++)
							if (is_14_[i_19_] == i_18_)
								contos_0_[is[i_19_]].d(rd);
				}
				if (!openm)
					var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
				rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				var_xtGraphics.stageselect(checkpoints, u[0], xm, ym, moused);
				drawms();
			}
			if (var_xtGraphics.fase == 1177) {
				mvect = 100;
				if (!bool) {
					if (var_xtGraphics.loadedt) {
						rd.setColor(new Color(0, 0, 0));
						rd.fillRect(0, 0, 800, 450);
						repaint();
						checkmemory(var_xtGraphics);
						var_xtGraphics.strack.unload();
						var_xtGraphics.strack = null;
						var_xtGraphics.flexpix = null;
						var_xtGraphics.fleximg = null;
						System.gc();
						var_xtGraphics.loadedt = false;
					}
					var_xtGraphics.intertrack.unload();
					rd.setColor(new Color(0, 0, 0));
					rd.fillRect(65, 25, 670, 400);
					if (mload > 0)
						rd.drawImage(var_xtGraphics.mload, 259, 195, this);
					repaint();
					if (mload == 2) {
						cardefine.loadready();
						loadbase(contos, medium, trackers, var_xtGraphics, true);
						readcookies(var_xtGraphics, cardefine, contos);
						mload = -1;
					}
					System.gc();
					login = new Login(medium, rd, var_xtGraphics, this);
					globe = new Globe(rd, var_xtGraphics, medium, login, cardefine, checkpoints, contos, contos_0_,
							this);
					lobby = new Lobby(medium, rd, login, globe, var_xtGraphics, cardefine, this);
					bool = true;
				}
				if (login.fase != 18) {
					boolean bool_20_ = false;
					if (login.fase == 0)
						login.inishmulti();
					if (login.fase >= 1 && login.fase <= 11)
						login.multistart(contos, xm, ym, moused);
					if (login.fase >= 12 && login.fase <= 17) {
						if (globe.open != 452)
							login.multimode(contos);
						else
							bool_20_ = true;
						globe.dome(0, xm, ym, moused, u[0]);
					}
					if (login.justlog) {
						if (!var_xtGraphics.clan.equals(""))
							globe.itab = 2;
						login.justlog = false;
					}
					if (!bool_20_) {
						login.ctachm(xm, ym, mouses, u[0], lobby);
						mvect = 50;
					} else {
						drawms();
						mvect = 100;
					}
					if (mouses == 1)
						mouses = 11;
					if (mouses <= -1) {
						mouses--;
						if (mouses == -4)
							mouses = 0;
					}
					if (mousew != 0)
						if (mousew > 0)
							mousew--;
						else
							mousew++;
				} else {
					boolean bool_21_ = false;
					if (lobby.fase == 0) {
						lobby.inishlobby();
						mvect = 100;
					}
					if (lobby.fase == 1) {
						if (globe.open >= 2 && globe.open < 452)
							openm = true;
						if (globe.open != 452)
							lobby.lobby(xm, ym, moused, mousew, checkpoints, u[0], contos);
						else
							bool_21_ = true;
						globe.dome(lobby.conon, xm, ym, moused, u[0]);
						if (lobby.loadstage > 0) {
							setCursor(new Cursor(3));
							drawms();
							repaint();
							trackers.nt = 0;
							if (loadstagePreview(lobby.loadstage, "", contos_0_, contos, medium, checkpoints)) {
								lobby.gstagename = checkpoints.name;
								lobby.gstagelaps = checkpoints.nlaps;
								lobby.loadstage = -lobby.loadstage;
							} else {
								lobby.loadstage = 0;
								checkpoints.name = "";
							}
							setCursor(new Cursor(0));
						}
						if (lobby.msload != 0) {
							setCursor(new Cursor(3));
							drawms();
							repaint();
							if (lobby.msload == 1)
								cardefine.loadmystages(checkpoints);
							if (lobby.msload == 7)
								cardefine.loadclanstages(var_xtGraphics.clan);
							if (lobby.msload == 3 || lobby.msload == 4)
								cardefine.loadtop20(lobby.msload);
							lobby.msload = 0;
							setCursor(new Cursor(0));
						}
					}
					if (lobby.fase == 3) {
						var_xtGraphics.trackbg(false);
						medium.trk = 0;
						medium.focus_point = 400;
						medium.crs = true;
						medium.x = -335;
						medium.y = 0;
						medium.z = -50;
						medium.xz = 0;
						medium.zy = 20;
						medium.ground = -2000;
						mvect = 100;
						lobby.fase = 1;
					}
					if (lobby.fase == 4) {
						mvect = 50;
						rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
						medium.d(rd);
						medium.aroundtrack(checkpoints);
						int i_22_ = 0;
						final int[] is = new int[1000];
						for (int i_23_ = 0; i_23_ < nob; i_23_++)
							if (contos_0_[i_23_].dist != 0) {
								is[i_22_] = i_23_;
								i_22_++;
							} else
								contos_0_[i_23_].d(rd);
						final int[] is_24_ = new int[i_22_];
						for (int i_25_ = 0; i_25_ < i_22_; i_25_++)
							is_24_[i_25_] = 0;
						for (int i_26_ = 0; i_26_ < i_22_; i_26_++)
							for (int i_27_ = i_26_ + 1; i_27_ < i_22_; i_27_++)
								if (contos_0_[is[i_26_]].dist != contos_0_[is[i_27_]].dist) {
									if (contos_0_[is[i_26_]].dist < contos_0_[is[i_27_]].dist)
										is_24_[i_26_]++;
									else
										is_24_[i_27_]++;
								} else if (i_27_ > i_26_)
									is_24_[i_26_]++;
								else
									is_24_[i_27_]++;
						for (int i_28_ = 0; i_28_ < i_22_; i_28_++)
							for (int i_29_ = 0; i_29_ < i_22_; i_29_++)
								if (is_24_[i_29_] == i_28_)
									contos_0_[is[i_29_]].d(rd);
						rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
						lobby.stageselect(checkpoints, u[0], xm, ym, moused);
						if (lobby.plsndt == 1) {
							mvect = 70;
							repaint();
							setCursor(new Cursor(3));
							var_xtGraphics.loadstrack(checkpoints.stage, checkpoints.trackname,
									checkpoints.trackvol);
							var_xtGraphics.strack.play();
							lobby.plsndt = 2;
							moused = false;
							mouses = 0;
						}
					}
					if (lobby.fase == 2) {
						int i_30_ = 0;
						for (int i_31_ = 0; i_31_ < lobby.ngm; i_31_++)
							if (lobby.ongame == lobby.gnum[i_31_])
								i_30_ = i_31_;
						boolean bool_32_ = false;
						if (lobby.gstgn[i_30_] > 0) {
							if (lobby.gstgn[i_30_] == -lobby.loadstage)
								bool_32_ = true;
						} else if (lobby.gstages[i_30_].equals(checkpoints.name))
							bool_32_ = true;
						if (bool_32_) {
							lobby.fase = 4;
							lobby.addstage = 0;
						} else {
							var_xtGraphics.loadingstage(lobby.gstgn[i_30_], false);
							trackers.nt = 0;
							if (loadstagePreview(lobby.gstgn[i_30_], lobby.gstages[i_30_], contos_0_, contos,
									medium, checkpoints)) {
								lobby.loadstage = -lobby.gstgn[i_30_];
								lobby.fase = 4;
								lobby.addstage = 0;
							} else {
								lobby.loadstage = 0;
								checkpoints.name = "";
								lobby.fase = 3;
							}
						}
					}
					if (lobby.fase == 76) {
						checkpoints.nlaps = lobby.laps;
						checkpoints.stage = lobby.stage;
						checkpoints.name = lobby.stagename;
						checkpoints.nfix = lobby.nfix;
						checkpoints.notb = lobby.notb;
						var_xtGraphics.fase = 21;
						u[0].multion = var_xtGraphics.multion;
					}
					if (globe.loadwbgames == 7) {
						repaint();
						globe.redogame();
					}
					if (!openm) {
						if (!bool_21_)
							lobby.ctachm(xm, ym, mouses, u[0]);
					} else
						mouses = 0;
					drawms();
					if (lobby.fase == 1)
						lobby.preforma(xm, ym);
					if (lobby.loadwarb) {
						repaint();
						globe.loadwarb();
						lobby.loadwarb = false;
					}
					if (globe.loadwbgames == 1) {
						repaint();
						globe.loadwgames();
					}
					if (mouses == 1)
						mouses = 11;
					if (mouses <= -1) {
						mouses--;
						if (mouses == -4)
							mouses = 0;
					}
					if (mousew != 0) {
						if (mousew > 0)
							mousew--;
						else
							mousew++;
						if (!lobby.zeromsw)
							mousew = 0;
					}
				}
			}
			if (var_xtGraphics.fase == 24) {
				login.endcons();
				login = null;
				lobby = null;
				globe = null;
				bool = false;
				System.gc();
				System.runFinalization();
				if (!var_xtGraphics.mtop) {
					var_xtGraphics.fase = 102;
					var_xtGraphics.opselect = 2;
				} else {
					var_xtGraphics.fase = 10;
					var_xtGraphics.opselect = 1;
				}
			}
			if (var_xtGraphics.fase == 23) {
				if (login.fase == 18)
					var_xtGraphics.playingame = -101;
				login.stopallnow();
				lobby.stopallnow();
				globe.stopallnow();
				login = null;
				lobby = null;
				globe = null;
				hidefields();
				bool = false;
				System.gc();
				System.runFinalization();
				var_xtGraphics.fase = -9;
			}
			if (var_xtGraphics.fase == 22) {
				loadstage(contos_0_, contos, medium, trackers, checkpoints, var_xtGraphics, mads, record);
				if (checkpoints.stage != -3) {
					if (var_xtGraphics.lan && var_xtGraphics.im == 0)
						udpmistro.UDPLanServer(var_xtGraphics.nplayers, var_xtGraphics.server,
								var_xtGraphics.servport, var_xtGraphics.playingame);
					u[0].falseo(2);
					requestFocus();
				} else
					var_xtGraphics.fase = 1177;
			}
			if (var_xtGraphics.fase == 21) {
				login.endcons();
				login = null;
				lobby = null;
				globe = null;
				bool = false;
				System.gc();
				System.runFinalization();
				var_xtGraphics.fase = 22;
			}
			if (var_xtGraphics.fase == 0) {
				for (int i_33_ = 0; i_33_ < var_xtGraphics.nplayers; i_33_++)
					if (mads[i_33_].newcar) {
						final int i_34_ = contos_0_[i_33_].xz;
						final int i_35_ = contos_0_[i_33_].xy;
						final int i_36_ = contos_0_[i_33_].zy;
						contos_0_[i_33_] = new ContO(contos[mads[i_33_].cn], contos_0_[i_33_].x, contos_0_[i_33_].y,
								contos_0_[i_33_].z, 0);
						contos_0_[i_33_].xz = i_34_;
						contos_0_[i_33_].xy = i_35_;
						contos_0_[i_33_].zy = i_36_;
						mads[i_33_].newcar = false;
					}
				medium.d(rd);
				int i_37_ = 0;
				final int[] is = new int[10000];
				for (int i_38_ = 0; i_38_ < nob; i_38_++)
					if (contos_0_[i_38_].dist != 0) {
						is[i_37_] = i_38_;
						i_37_++;
					} else
						contos_0_[i_38_].d(rd);
				final int[] is_39_ = new int[i_37_];
				final int[] is_40_ = new int[i_37_];
				for (int i_41_ = 0; i_41_ < i_37_; i_41_++)
					is_39_[i_41_] = 0;
				for (int i_42_ = 0; i_42_ < i_37_; i_42_++) {
					for (int i_43_ = i_42_ + 1; i_43_ < i_37_; i_43_++)
						if (contos_0_[is[i_42_]].dist < contos_0_[is[i_43_]].dist)
							is_39_[i_42_]++;
						else
							is_39_[i_43_]++;
					is_40_[is_39_[i_42_]] = i_42_;
				}
				for (int i_44_ = 0; i_44_ < i_37_; i_44_++)
					contos_0_[is[is_40_[i_44_]]].d(rd);
				if (var_xtGraphics.starcnt == 0) {
					for (int i_45_ = 0; i_45_ < var_xtGraphics.nplayers; i_45_++)
						for (int i_46_ = 0; i_46_ < var_xtGraphics.nplayers; i_46_++)
							if (i_46_ != i_45_)
								mads[i_45_].colide(contos_0_[i_45_], mads[i_46_], contos_0_[i_46_]);
					for (int i_47_ = 0; i_47_ < var_xtGraphics.nplayers; i_47_++)
						mads[i_47_].drive(u[i_47_], contos_0_[i_47_], trackers, checkpoints);
					for (int i_48_ = 0; i_48_ < var_xtGraphics.nplayers; i_48_++)
						record.rec(contos_0_[i_48_], i_48_, mads[i_48_].squash, mads[i_48_].lastcolido,
								mads[i_48_].cntdest, 0);
					checkpoints.checkstat(mads, contos_0_, record, var_xtGraphics.nplayers, var_xtGraphics.im, 0);
					for (int i_49_ = 1; i_49_ < var_xtGraphics.nplayers; i_49_++)
						u[i_49_].preform(mads[i_49_], contos_0_[i_49_], checkpoints, trackers);
				} else {
					if (var_xtGraphics.starcnt == 130) {
						medium.adv = 1900;
						medium.zy = 40;
						medium.vxz = 70;
						rd.setColor(new Color(255, 255, 255));
						rd.fillRect(0, 0, 800, 450);
					}
					if (var_xtGraphics.starcnt != 0)
						var_xtGraphics.starcnt--;
				}
				if (var_xtGraphics.starcnt < 38) {
					if (view == 0) {
						medium.follow(contos_0_[0], mads[0].cxz, u[0].lookback);
						var_xtGraphics.stat(mads[0], contos_0_[0], checkpoints, u[0], true);
						if (mads[0].outshakedam > 0) {
							shaka = mads[0].outshakedam / 20;
							if (shaka > 25)
								shaka = 25;
						}
						mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
						if (mvect > 90)
							mvect = 90;
						lmxz = medium.xz;
					}
					if (view == 1) {
						medium.around(contos_0_[0], false);
						var_xtGraphics.stat(mads[0], contos_0_[0], checkpoints, u[0], false);
						mvect = 80;
					}
					if (view == 2) {
						medium.watch(contos_0_[0], mads[0].mxz);
						var_xtGraphics.stat(mads[0], contos_0_[0], checkpoints, u[0], false);
						mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
						if (mvect > 90)
							mvect = 90;
						lmxz = medium.xz;
					}
					if (mouses == 1) {
						u[0].enter = true;
						mouses = 0;
					}
				} else {
					int i_50_ = 3;
					if (var_xtGraphics.nplayers == 1)
						i_50_ = 0;
					medium.around(contos_0_[i_50_], true);
					mvect = 80;
					if (u[0].enter || u[0].handb) {
						var_xtGraphics.starcnt = 38;
						u[0].enter = false;
						u[0].handb = false;
					}
					if (var_xtGraphics.starcnt == 38) {
						mouses = 0;
						medium.vert = false;
						medium.adv = 900;
						medium.vxz = 180;
						checkpoints.checkstat(mads, contos_0_, record, var_xtGraphics.nplayers, var_xtGraphics.im,
								0);
						medium.follow(contos_0_[0], mads[0].cxz, 0);
						var_xtGraphics.stat(mads[0], contos_0_[0], checkpoints, u[0], true);
						rd.setColor(new Color(255, 255, 255));
						rd.fillRect(0, 0, 800, 450);
					}
				}
			}
			if (var_xtGraphics.fase == 7001) {
				for (int i_51_ = 0; i_51_ < var_xtGraphics.nplayers; i_51_++)
					if (mads[i_51_].newedcar == 0 && mads[i_51_].newcar) {
						final int i_52_ = contos_0_[i_51_].xz;
						final int i_53_ = contos_0_[i_51_].xy;
						final int i_54_ = contos_0_[i_51_].zy;
						var_xtGraphics.colorCar(contos[mads[i_51_].cn], i_51_);
						contos_0_[i_51_] = new ContO(contos[mads[i_51_].cn], contos_0_[i_51_].x, contos_0_[i_51_].y,
								contos_0_[i_51_].z, 0);
						contos_0_[i_51_].xz = i_52_;
						contos_0_[i_51_].xy = i_53_;
						contos_0_[i_51_].zy = i_54_;
						mads[i_51_].newedcar = 20;
					}
				medium.d(rd);
				int i_55_ = 0;
				final int[] is = new int[10000];
				for (int i_56_ = 0; i_56_ < nob; i_56_++)
					if (contos_0_[i_56_].dist != 0) {
						is[i_55_] = i_56_;
						i_55_++;
					} else
						contos_0_[i_56_].d(rd);
				final int[] is_57_ = new int[i_55_];
				final int[] is_58_ = new int[i_55_];
				for (int i_59_ = 0; i_59_ < i_55_; i_59_++)
					is_57_[i_59_] = 0;
				for (int i_60_ = 0; i_60_ < i_55_; i_60_++) {
					for (int i_61_ = i_60_ + 1; i_61_ < i_55_; i_61_++)
						if (contos_0_[is[i_60_]].dist < contos_0_[is[i_61_]].dist)
							is_57_[i_60_]++;
						else
							is_57_[i_61_]++;
					is_58_[is_57_[i_60_]] = i_60_;
				}
				for (int i_62_ = 0; i_62_ < i_55_; i_62_++) {
					if (is[is_58_[i_62_]] < var_xtGraphics.nplayers && is[is_58_[i_62_]] != var_xtGraphics.im)
						udpmistro.readContOinfo(contos_0_[is[is_58_[i_62_]]], is[is_58_[i_62_]]);
					contos_0_[is[is_58_[i_62_]]].d(rd);
				}
				if (var_xtGraphics.starcnt == 0) {
					if (var_xtGraphics.multion == 1) {
						int i_63_ = 1;
						for (int i_64_ = 0; i_64_ < var_xtGraphics.nplayers; i_64_++)
							if (var_xtGraphics.im != i_64_) {
								udpmistro.readinfo(mads[i_64_], contos_0_[i_64_], u[i_63_], i_64_,
										checkpoints.dested);
								i_63_++;
							}
					} else
						for (int i_65_ = 0; i_65_ < var_xtGraphics.nplayers; i_65_++)
							udpmistro.readinfo(mads[i_65_], contos_0_[i_65_], u[i_65_], i_65_, checkpoints.dested);
					for (int i_66_ = 0; i_66_ < var_xtGraphics.nplayers; i_66_++)
						for (int i_67_ = 0; i_67_ < var_xtGraphics.nplayers; i_67_++)
							if (i_67_ != i_66_)
								mads[i_66_].colide(contos_0_[i_66_], mads[i_67_], contos_0_[i_67_]);
					if (var_xtGraphics.multion == 1) {
						int i_68_ = 1;
						for (int i_69_ = 0; i_69_ < var_xtGraphics.nplayers; i_69_++)
							if (var_xtGraphics.im != i_69_) {
								mads[i_69_].drive(u[i_68_], contos_0_[i_69_], trackers, checkpoints);
								i_68_++;
							} else
								mads[i_69_].drive(u[0], contos_0_[i_69_], trackers, checkpoints);
						for (int i_70_ = 0; i_70_ < var_xtGraphics.nplayers; i_70_++)
							record.rec(contos_0_[i_70_], i_70_, mads[i_70_].squash, mads[i_70_].lastcolido,
									mads[i_70_].cntdest, var_xtGraphics.im);
					} else
						for (int i_71_ = 0; i_71_ < var_xtGraphics.nplayers; i_71_++)
							mads[i_71_].drive(u[i_71_], contos_0_[i_71_], trackers, checkpoints);
					checkpoints.checkstat(mads, contos_0_, record, var_xtGraphics.nplayers, var_xtGraphics.im,
							var_xtGraphics.multion);
				} else {
					if (var_xtGraphics.starcnt == 130) {
						medium.adv = 1900;
						medium.zy = 40;
						medium.vxz = 70;
						rd.setColor(new Color(255, 255, 255));
						rd.fillRect(0, 0, 800, 450);
						repaint();
						if (var_xtGraphics.lan) {
							udpmistro.UDPConnectLan(var_xtGraphics.localserver, var_xtGraphics.nplayers,
									var_xtGraphics.im);
							if (var_xtGraphics.im == 0)
								var_xtGraphics.setbots(udpmistro.isbot, udpmistro.frame);
						} else
							udpmistro.UDPConnectOnline(var_xtGraphics.server, var_xtGraphics.gameport,
									var_xtGraphics.nplayers, var_xtGraphics.im);
						if (var_xtGraphics.multion >= 2) {
							var_xtGraphics.im = (int) (Math.random() * var_xtGraphics.nplayers);
							var_xtGraphics.starcnt = 0;
						}
					}
					if (var_xtGraphics.starcnt == 50)
						udpmistro.frame[udpmistro.im][0] = 0;
					if (var_xtGraphics.starcnt != 39 && var_xtGraphics.starcnt != 0)
						var_xtGraphics.starcnt--;
					if (udpmistro.go && var_xtGraphics.starcnt >= 39) {
						var_xtGraphics.starcnt = 38;
						if (var_xtGraphics.lan) {
							int i_72_ = checkpoints.stage;
							if (i_72_ < 0)
								i_72_ = 33;
							if (var_xtGraphics.loadedt)
								var_xtGraphics.strack.play();
						}
					}
				}
				if (var_xtGraphics.lan && udpmistro.im == 0)
					for (int i_73_ = 2; i_73_ < var_xtGraphics.nplayers; i_73_++)
						if (udpmistro.isbot[i_73_]) {
							u[i_73_].preform(mads[i_73_], contos_0_[i_73_], checkpoints, trackers);
							udpmistro.setinfo(mads[i_73_], contos_0_[i_73_], u[i_73_], checkpoints.pos[i_73_],
									checkpoints.magperc[i_73_], false, i_73_);
						}
				if (var_xtGraphics.starcnt < 38) {
					if (var_xtGraphics.multion == 1) {
						udpmistro.setinfo(mads[var_xtGraphics.im], contos_0_[var_xtGraphics.im], u[0],
								checkpoints.pos[var_xtGraphics.im], checkpoints.magperc[var_xtGraphics.im],
								var_xtGraphics.holdit, var_xtGraphics.im);
						if (view == 0) {
							medium.follow(contos_0_[var_xtGraphics.im], mads[var_xtGraphics.im].cxz, u[0].lookback);
							var_xtGraphics.stat(mads[var_xtGraphics.im], contos_0_[var_xtGraphics.im], checkpoints,
									u[0], true);
							if (mads[var_xtGraphics.im].outshakedam > 0) {
								shaka = mads[var_xtGraphics.im].outshakedam / 20;
								if (shaka > 25)
									shaka = 25;
							}
							mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
							if (mvect > 90)
								mvect = 90;
							lmxz = medium.xz;
						}
						if (view == 1) {
							medium.around(contos_0_[var_xtGraphics.im], false);
							var_xtGraphics.stat(mads[var_xtGraphics.im], contos_0_[var_xtGraphics.im], checkpoints,
									u[0], false);
							mvect = 80;
						}
						if (view == 2) {
							medium.watch(contos_0_[var_xtGraphics.im], mads[var_xtGraphics.im].mxz);
							var_xtGraphics.stat(mads[var_xtGraphics.im], contos_0_[var_xtGraphics.im], checkpoints,
									u[0], false);
							mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
							if (mvect > 90)
								mvect = 90;
							lmxz = medium.xz;
						}
					} else {
						if (view == 0) {
							medium.getaround(contos_0_[var_xtGraphics.im]);
							mvect = 80;
						}
						if (view == 1) {
							medium.getfollow(contos_0_[var_xtGraphics.im], mads[var_xtGraphics.im].cxz,
									u[0].lookback);
							mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
							if (mvect > 90)
								mvect = 90;
							lmxz = medium.xz;
						}
						if (view == 2) {
							medium.watch(contos_0_[var_xtGraphics.im], mads[var_xtGraphics.im].mxz);
							mvect = 65 + Math.abs(lmxz - medium.xz) / 5 * 100;
							if (mvect > 90)
								mvect = 90;
							lmxz = medium.xz;
						}
						var_xtGraphics.stat(mads[var_xtGraphics.im], contos_0_[var_xtGraphics.im], checkpoints,
								u[0], true);
					}
					if (mouses == 1) {
						if (var_xtGraphics.holdit && var_xtGraphics.exitm != 4 && var_xtGraphics.multion == 1)
							u[0].enter = true;
						mouses = 0;
					}
				} else {
					medium.around(contos_0_[var_xtGraphics.im], true);
					mvect = 80;
					if (var_xtGraphics.starcnt == 39)
						var_xtGraphics.waitenter();
					if (var_xtGraphics.starcnt == 38) {
						var_xtGraphics.forstart = 0;
						mouses = 0;
						medium.vert = false;
						medium.adv = 900;
						medium.vxz = 180;
						checkpoints.checkstat(mads, contos_0_, record, var_xtGraphics.nplayers, var_xtGraphics.im,
								var_xtGraphics.multion);
						medium.follow(contos_0_[var_xtGraphics.im], mads[var_xtGraphics.im].cxz, 0);
						var_xtGraphics.stat(mads[var_xtGraphics.im], contos_0_[var_xtGraphics.im], checkpoints,
								u[0], true);
						rd.setColor(new Color(255, 255, 255));
						rd.fillRect(0, 0, 800, 450);
					}
				}
				var_xtGraphics.multistat(u[0], checkpoints, xm, ym, moused, udpmistro);
			}
			if (var_xtGraphics.fase == -1) {
				if (i_6_ == 0)
					for (int i_74_ = 0; i_74_ < var_xtGraphics.nplayers; i_74_++) {
						record.ocar[i_74_] = new ContO(contos_0_[i_74_], 0, 0, 0, 0);
						contos_0_[i_74_] = new ContO(record.car[0][i_74_], 0, 0, 0, 0);
					}
				medium.d(rd);
				int i_75_ = 0;
				final int[] is = new int[10000];
				for (int i_76_ = 0; i_76_ < nob; i_76_++)
					if (contos_0_[i_76_].dist != 0) {
						is[i_75_] = i_76_;
						i_75_++;
					} else
						contos_0_[i_76_].d(rd);
				final int[] is_77_ = new int[i_75_];
				for (int i_78_ = 0; i_78_ < i_75_; i_78_++)
					is_77_[i_78_] = 0;
				for (int i_79_ = 0; i_79_ < i_75_; i_79_++)
					for (int i_80_ = i_79_ + 1; i_80_ < i_75_; i_80_++)
						if (contos_0_[is[i_79_]].dist != contos_0_[is[i_80_]].dist) {
							if (contos_0_[is[i_79_]].dist < contos_0_[is[i_80_]].dist)
								is_77_[i_79_]++;
							else
								is_77_[i_80_]++;
						} else if (i_80_ > i_79_)
							is_77_[i_79_]++;
						else
							is_77_[i_80_]++;
				for (int i_81_ = 0; i_81_ < i_75_; i_81_++)
					for (int i_82_ = 0; i_82_ < i_75_; i_82_++)
						if (is_77_[i_82_] == i_81_)
							contos_0_[is[i_82_]].d(rd);
				if (u[0].enter || u[0].handb || mouses == 1) {
					i_6_ = 299;
					u[0].enter = false;
					u[0].handb = false;
					mouses = 0;
				}
				for (int i_83_ = 0; i_83_ < var_xtGraphics.nplayers; i_83_++) {
					if (record.fix[i_83_] == i_6_)
						if (contos_0_[i_83_].dist == 0)
							contos_0_[i_83_].fcnt = 8;
						else
							contos_0_[i_83_].fix = true;
					if (contos_0_[i_83_].fcnt == 7 || contos_0_[i_83_].fcnt == 8) {
						contos_0_[i_83_] = new ContO(contos[mads[i_83_].cn], 0, 0, 0, 0);
						record.cntdest[i_83_] = 0;
					}
					if (i_6_ == 299)
						contos_0_[i_83_] = new ContO(record.ocar[i_83_], 0, 0, 0, 0);
					record.play(contos_0_[i_83_], mads[i_83_], i_83_, i_6_);
				}
				if (++i_6_ == 300) {
					i_6_ = 0;
					var_xtGraphics.fase = -6;
				} else
					var_xtGraphics.replyn();
				medium.around(contos_0_[0], false);
			}
			if (var_xtGraphics.fase == -2) {
				if (var_xtGraphics.multion >= 2)
					record.hcaught = false;
				u[0].falseo(3);
				if (record.hcaught && record.wasted == 0 && record.whenwasted != 229
						&& (checkpoints.stage == 1 || checkpoints.stage == 2) && var_xtGraphics.looped != 0)
					record.hcaught = false;
				if (record.hcaught) {
					rd.setColor(new Color(0, 0, 0));
					rd.fillRect(0, 0, 800, 450);
					repaint();
				}
				if (var_xtGraphics.multion != 0) {
					udpmistro.UDPquit();
					var_xtGraphics.stopchat();
					if (cmsg.isShowing())
						cmsg.setVisible(false);
					cmsg.setText("");
					requestFocus();
				}
				if (record.hcaught) {
					if (medium.random() > 0.45)
						medium.vert = false;
					else
						medium.vert = true;
					medium.adv = (int) (900.0F * medium.random());
					medium.vxz = (int) (360.0F * medium.random());
					i_6_ = 0;
					var_xtGraphics.fase = -3;
					i_7_ = 0;
					i_8_ = 0;
				} else {
					i_6_ = -2;
					var_xtGraphics.fase = -4;
				}
			}
			if (var_xtGraphics.fase == -3) {
				if (i_6_ == 0) {
					if (record.wasted == 0) {
						if (record.whenwasted == 229) {
							i_9_ = 67;
							medium.vxz += 90;
						} else {
							i_9_ = (int) (medium.random() * 4.0F);
							if (i_9_ == 1 || i_9_ == 3)
								i_9_ = 69;
							if (i_9_ == 2 || i_9_ == 4)
								i_9_ = 30;
						}
					} else if (record.closefinish != 0 && i_8_ != 0)
						medium.vxz += 90;
					for (int i_84_ = 0; i_84_ < var_xtGraphics.nplayers; i_84_++)
						contos_0_[i_84_] = new ContO(record.starcar[i_84_], 0, 0, 0, 0);
				}
				medium.d(rd);
				int i_85_ = 0;
				final int[] is = new int[10000];
				for (int i_86_ = 0; i_86_ < nob; i_86_++)
					if (contos_0_[i_86_].dist != 0) {
						is[i_85_] = i_86_;
						i_85_++;
					} else
						contos_0_[i_86_].d(rd);
				final int[] is_87_ = new int[i_85_];
				for (int i_88_ = 0; i_88_ < i_85_; i_88_++)
					is_87_[i_88_] = 0;
				for (int i_89_ = 0; i_89_ < i_85_; i_89_++)
					for (int i_90_ = i_89_ + 1; i_90_ < i_85_; i_90_++)
						if (contos_0_[is[i_89_]].dist != contos_0_[is[i_90_]].dist) {
							if (contos_0_[is[i_89_]].dist < contos_0_[is[i_90_]].dist)
								is_87_[i_89_]++;
							else
								is_87_[i_90_]++;
						} else if (i_90_ > i_89_)
							is_87_[i_89_]++;
						else
							is_87_[i_90_]++;
				for (int i_91_ = 0; i_91_ < i_85_; i_91_++)
					for (int i_92_ = 0; i_92_ < i_85_; i_92_++)
						if (is_87_[i_92_] == i_91_)
							contos_0_[is[i_92_]].d(rd);
				for (int i_93_ = 0; i_93_ < var_xtGraphics.nplayers; i_93_++) {
					if (record.hfix[i_93_] == i_6_)
						if (contos_0_[i_93_].dist == 0)
							contos_0_[i_93_].fcnt = 8;
						else
							contos_0_[i_93_].fix = true;
					if (contos_0_[i_93_].fcnt == 7 || contos_0_[i_93_].fcnt == 8) {
						contos_0_[i_93_] = new ContO(contos[mads[i_93_].cn], 0, 0, 0, 0);
						record.cntdest[i_93_] = 0;
					}
					record.playh(contos_0_[i_93_], mads[i_93_], i_93_, i_6_, var_xtGraphics.im);
				}
				if (i_8_ == 2 && i_6_ == 299)
					u[0].enter = true;
				if (u[0].enter || u[0].handb) {
					var_xtGraphics.fase = -4;
					u[0].enter = false;
					u[0].handb = false;
					i_6_ = -7;
				} else {
					var_xtGraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, i_6_,
							checkpoints.stage);
					if (i_6_ == 0 || i_6_ == 1 || i_6_ == 2) {
						rd.setColor(new Color(0, 0, 0));
						rd.fillRect(0, 0, 800, 450);
					}
					if (record.wasted != var_xtGraphics.im) {
						if (record.closefinish == 0) {
							if (i_7_ == 9 || i_7_ == 11) {
								rd.setColor(new Color(255, 255, 255));
								rd.fillRect(0, 0, 800, 450);
							}
							if (i_7_ == 0)
								medium.around(contos_0_[var_xtGraphics.im], false);
							if (i_7_ > 0 && i_7_ < 20)
								medium.transaround(contos_0_[var_xtGraphics.im], contos_0_[record.wasted], i_7_);
							if (i_7_ == 20)
								medium.around(contos_0_[record.wasted], false);
							if (i_6_ > record.whenwasted && i_7_ != 20)
								i_7_++;
							if ((i_7_ == 0 || i_7_ == 20) && ++i_6_ == 300) {
								i_6_ = 0;
								i_7_ = 0;
								i_8_++;
							}
						} else if (record.closefinish == 1) {
							if (i_7_ == 0)
								medium.around(contos_0_[var_xtGraphics.im], false);
							if (i_7_ > 0 && i_7_ < 20)
								medium.transaround(contos_0_[var_xtGraphics.im], contos_0_[record.wasted], i_7_);
							if (i_7_ == 20)
								medium.around(contos_0_[record.wasted], false);
							if (i_7_ > 20 && i_7_ < 40)
								medium.transaround(contos_0_[record.wasted], contos_0_[var_xtGraphics.im],
										i_7_ - 20);
							if (i_7_ == 40)
								medium.around(contos_0_[var_xtGraphics.im], false);
							if (i_7_ > 40 && i_7_ < 60)
								medium.transaround(contos_0_[var_xtGraphics.im], contos_0_[record.wasted],
										i_7_ - 40);
							if (i_7_ == 60)
								medium.around(contos_0_[record.wasted], false);
							if (i_6_ > 160 && i_7_ < 20)
								i_7_++;
							if (i_6_ > 230 && i_7_ < 40)
								i_7_++;
							if (i_6_ > 280 && i_7_ < 60)
								i_7_++;
							if ((i_7_ == 0 || i_7_ == 20 || i_7_ == 40 || i_7_ == 60) && ++i_6_ == 300) {
								i_6_ = 0;
								i_7_ = 0;
								i_8_++;
							}
						} else {
							if (i_7_ == 0)
								medium.around(contos_0_[var_xtGraphics.im], false);
							if (i_7_ > 0 && i_7_ < 20)
								medium.transaround(contos_0_[var_xtGraphics.im], contos_0_[record.wasted], i_7_);
							if (i_7_ == 20)
								medium.around(contos_0_[record.wasted], false);
							if (i_7_ > 20 && i_7_ < 40)
								medium.transaround(contos_0_[record.wasted], contos_0_[var_xtGraphics.im],
										i_7_ - 20);
							if (i_7_ == 40)
								medium.around(contos_0_[var_xtGraphics.im], false);
							if (i_7_ > 40 && i_7_ < 60)
								medium.transaround(contos_0_[var_xtGraphics.im], contos_0_[record.wasted],
										i_7_ - 40);
							if (i_7_ == 60)
								medium.around(contos_0_[record.wasted], false);
							if (i_7_ > 60 && i_7_ < 80)
								medium.transaround(contos_0_[record.wasted], contos_0_[var_xtGraphics.im],
										i_7_ - 60);
							if (i_7_ == 80)
								medium.around(contos_0_[var_xtGraphics.im], false);
							if (i_6_ > 90 && i_7_ < 20)
								i_7_++;
							if (i_6_ > 160 && i_7_ < 40)
								i_7_++;
							if (i_6_ > 230 && i_7_ < 60)
								i_7_++;
							if (i_6_ > 280 && i_7_ < 80)
								i_7_++;
							if ((i_7_ == 0 || i_7_ == 20 || i_7_ == 40 || i_7_ == 60 || i_7_ == 80)
									&& ++i_6_ == 300) {
								i_6_ = 0;
								i_7_ = 0;
								i_8_++;
							}
						}
					} else {
						if (i_9_ == 67 && (i_7_ == 3 || i_7_ == 31 || i_7_ == 66)) {
							rd.setColor(new Color(255, 255, 255));
							rd.fillRect(0, 0, 800, 450);
						}
						if (i_9_ == 69 && (i_7_ == 3 || i_7_ == 5 || i_7_ == 31 || i_7_ == 33 || i_7_ == 66
								|| i_7_ == 68)) {
							rd.setColor(new Color(255, 255, 255));
							rd.fillRect(0, 0, 800, 450);
						}
						if (i_9_ == 30 && i_7_ >= 1 && i_7_ < 30)
							if (i_7_ % (int) (2.0F + medium.random() * 3.0F) == 0 && !bool_10_) {
								rd.setColor(new Color(255, 255, 255));
								rd.fillRect(0, 0, 800, 450);
								bool_10_ = true;
							} else
								bool_10_ = false;
						if (i_6_ > record.whenwasted && i_7_ != i_9_)
							i_7_++;
						medium.around(contos_0_[var_xtGraphics.im], false);
						if ((i_7_ == 0 || i_7_ == i_9_) && ++i_6_ == 300) {
							i_6_ = 0;
							i_7_ = 0;
							i_8_++;
						}
					}
				}
			}
			if (var_xtGraphics.fase == -4) {
				if (i_6_ == 0) {
					var_xtGraphics.sendwin(checkpoints);
					if (var_xtGraphics.winner && var_xtGraphics.multion == 0 && var_xtGraphics.gmode != 0
							&& checkpoints.stage != 27
							&& checkpoints.stage == var_xtGraphics.unlocked[var_xtGraphics.gmode - 1]
									+ (var_xtGraphics.gmode - 1) * 10) {
						var_xtGraphics.unlocked[var_xtGraphics.gmode - 1]++;
						setcarcookie(var_xtGraphics.sc[0], cardefine.names[var_xtGraphics.sc[0]],
								var_xtGraphics.arnp, var_xtGraphics.gmode, var_xtGraphics.unlocked, false);
						var_xtGraphics.unlocked[var_xtGraphics.gmode - 1]--;
					}
				}
				if (i_6_ <= 0) {
					rd.drawImage(var_xtGraphics.mdness, 289, 30, null);
					rd.drawImage(var_xtGraphics.dude[0], 135, 10, null);
				}
				if (i_6_ >= 0)
					var_xtGraphics.fleximage(offImage, i_6_, checkpoints.stage);
				if (++i_6_ == 7) {
					var_xtGraphics.fase = -5;
					rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
							RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
					rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				}
			}
			if (var_xtGraphics.fase == -6) {
				repaint();
				var_xtGraphics.pauseimage(offImage);
				var_xtGraphics.fase = -7;
				mouses = 0;
			}
			if (var_xtGraphics.fase == -7) {
				var_xtGraphics.pausedgame(checkpoints.stage, u[0], record);
				if (i_6_ != 0)
					i_6_ = 0;
				var_xtGraphics.ctachm(xm, ym, mouses, u[0]);
				if (mouses == 2)
					mouses = 0;
				if (mouses == 1)
					mouses = 2;
			}
			if (var_xtGraphics.fase == -8) {
				var_xtGraphics.cantreply();
				if (++i_6_ == 150 || u[0].enter || u[0].handb || mouses == 1) {
					var_xtGraphics.fase = -7;
					mouses = 0;
					u[0].enter = false;
					u[0].handb = false;
				}
			}
			if (lostfcs && var_xtGraphics.fase == 7001)
				if (fcscnt == 0) {
					if (u[0].chatup == 0)
						requestFocus();
					fcscnt = 10;
				} else
					fcscnt--;
			repaint();
			if (var_xtGraphics.im > -1 && var_xtGraphics.im < 8) {
				int i_94_ = 0;
				if (var_xtGraphics.multion == 2 || var_xtGraphics.multion == 3) {
					i_94_ = var_xtGraphics.im;
					u[i_94_].mutem = u[0].mutem;
					u[i_94_].mutes = u[0].mutes;
				}
				var_xtGraphics.playsounds(mads[var_xtGraphics.im], u[i_94_], checkpoints.stage);
			}
			date = new Date();
			final long l_95_ = date.getTime();
			if (var_xtGraphics.fase == 0 || var_xtGraphics.fase == -1 || var_xtGraphics.fase == -3
					|| var_xtGraphics.fase == 7001) {
				if (!bool_3_) {
					f_2_ = f;
					if (f_2_ < 30.0F)
						f_2_ = 30.0F;
					bool_3_ = true;
					i_5_ = 0;
				}
				if (i_5_ == 10) {
					float f_96_ = (i_4_ + udpmistro.freg - (l_95_ - l_1_)) / 20.0F;
					if (f_96_ > 40.0F)
						f_96_ = 40.0F;
					if (f_96_ < -40.0F)
						f_96_ = -40.0F;
					f_2_ += f_96_;
					if (f_2_ < 5.0F)
						f_2_ = 5.0F;
					medium.adjstfade(f_2_, f_96_, var_xtGraphics.starcnt, this);
					l_1_ = l_95_;
					i_5_ = 0;
				} else
					i_5_++;
			} else {
				if (bool_3_) {
					f = f_2_;
					bool_3_ = false;
					i_5_ = 0;
				}
				if (i_5_ == 10) {
					if (l_95_ - l_1_ < 400L)
						f_2_ += 3.5;
					else {
						f_2_ -= 3.5;
						if (f_2_ < 5.0F)
							f_2_ = 5.0F;
					}
					l_1_ = l_95_;
					i_5_ = 0;
				} else
					i_5_++;
			}
			if (exwist) {
				rd.dispose();
				var_xtGraphics.stopallnow();
				cardefine.stopallnow();
				udpmistro.UDPquit();
				if (bool) {
					lobby.stopallnow();
					login.stopallnow();
					globe.stopallnow();
				}
				System.gc();
				if (Madness.endadv == 2)
					Madness.advopen();
			}

	}

	public void setcarcookie(final int i, final String string, final float[] fs, final int i_191_, final int[] is,
			final boolean bool) {
		try {
			final File file = new File(
					new StringBuilder().append("").append(Madness.fpath).append("data/user.data").toString());
			final String[] strings = { "", "", "", "", "" };
			if (file.exists()) {
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string_192_;
				for (int i_193_ = 0; (string_192_ = bufferedreader.readLine()) != null && i_193_ < 5; i_193_++)
					strings[i_193_] = string_192_;
				bufferedreader.close();
			}
			if (i_191_ == 0)
				strings[1] = new StringBuilder().append("lastcar(").append(i).append(",").append((int) (fs[0] * 100.0F))
						.append(",").append((int) (fs[1] * 100.0F)).append(",").append((int) (fs[2] * 100.0F))
						.append(",").append((int) (fs[3] * 100.0F)).append(",").append((int) (fs[4] * 100.0F))
						.append(",").append((int) (fs[5] * 100.0F)).append(",").append(string).append(")").toString();
			if (i_191_ == 1)
				strings[2] = new StringBuilder().append("NFM1(").append(i).append(",").append(is[0]).append(")")
						.toString();
			if (i_191_ == 2)
				strings[3] = new StringBuilder().append("NFM2(").append(i).append(",").append(is[1]).append(")")
						.toString();
			strings[4] = new StringBuilder().append("graphics(").append(moto).append(",").append(Madness.anti)
					.append(")").toString();
			final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
			for (int i_195_ = 0; i_195_ < 5; i_195_++) {
				bufferedwriter.write(strings[i_195_]);
				bufferedwriter.newLine();
			}
			bufferedwriter.close();
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public void setloggedcookie() {
		try {
			final File file = new File(
					new StringBuilder().append("").append(Madness.fpath).append("data/user.data").toString());
			final String[] strings = { "", "", "", "", "" };
			if (file.exists()) {
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string;
				for (int i = 0; (string = bufferedreader.readLine()) != null && i < 5; i++)
					strings[i] = string;
				bufferedreader.close();
			}
			if (keplo.getState())
				strings[0] = new StringBuilder().append("lastuser(").append(tnick.getText()).append(",")
						.append(tpass.getText()).append(")").toString();
			else
				strings[0] = new StringBuilder().append("lastuser(").append(tnick.getText()).append(")").toString();
			final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < 5; i++) {
				bufferedwriter.write(strings[i]);
				bufferedwriter.newLine();
			}
			bufferedwriter.close();
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public void setupini() {
		Madness.inisetup = true;
		try {
			final File file = new File(
					new StringBuilder().append("").append(Madness.fpath).append("Madness.ini").toString());
			if (file.exists()) {
				final String[] strings = new String[40];
				int i = 0;
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string;
				for ( /**/ ; (string = bufferedreader.readLine()) != null && i < 40; i++) {
					strings[i] = string;
					if (strings[i].startsWith("Class Path"))
						if (strings[i].indexOf("madapps.jar") != -1)
							strings[i] = "Class Path=\\data\\madapps.jar;";
						else
							strings[i] = "Class Path=\\data\\madapp.jar;";
					if (strings[i].startsWith("JRE Path"))
						strings[i] = "JRE Path=data\\jre\\";
				}
				bufferedreader.close();
				final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
				for (int i_210_ = 0; i_210_ < i; i_210_++) {
					bufferedwriter.write(strings[i_210_]);
					bufferedwriter.newLine();
				}
				bufferedwriter.close();
			}
		} catch (final Exception exception) {
			/* empty */
		}
		Madness.inisetup = false;
	}

	public void sizescreen(final int i, final int i_207_) {
		if (i > getWidth() / 2 - 230 && i < getWidth() / 2 - 68 && i_207_ > 21 && i_207_ < 39 || onbar) {
			reqmult = (i - (getWidth() / 2 - 222)) / 141.0F;
			if (reqmult < 0.1)
				reqmult = 0.0F;
			if (reqmult > 1.0F)
				reqmult = 1.0F;
			onbar = true;
			showsize = 100;
		}
	}

	/*-@Override
	public void start() {
		if (gamer == null)
			gamer = new Thread(this);
		gamer.start();
	}

	@Override
	public void stop() {
		if (exwist && gamer != null) {
			System.gc();
			gamer.interrupt();
			gamer = null;
		}
		exwist = true;
	}*/

	/*@Override
	public void update(final Graphics graphics) {
		paint(graphics);
	}*/


	public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
    	if (!exwist) {
			//115 114 99
			if (e.getKeyCode() == KeyEvent.VK_UP)
				u[0].up = true;
			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				u[0].down = true;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT)
				u[0].right = true;
			if (e.getKeyCode() == KeyEvent.VK_LEFT)
				u[0].left = true;
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
				u[0].handb = true;
			if (e.getKeyCode() == KeyEvent.VK_ENTER)
				u[0].enter = true;
			if (e.getKeyCode() == KeyEvent.VK_Z)
				u[0].lookback = -1;
			if (e.getKeyCode() == KeyEvent.VK_X)
				u[0].lookback = 1;
			if (e.getKeyCode() == KeyEvent.VK_M)
				if (u[0].mutem)
					u[0].mutem = false;
				else
					u[0].mutem = true;
			if (e.getKeyCode() == KeyEvent.VK_N)
				if (u[0].mutes)
					u[0].mutes = false;
				else
					u[0].mutes = true;
			if (e.getKeyCode() == KeyEvent.VK_A)
				if (u[0].arrace)
					u[0].arrace = false;
				else
					u[0].arrace = true;
			if (e.getKeyCode() == KeyEvent.VK_S)
				if (u[0].radar)
					u[0].radar = false;
				else
					u[0].radar = true;
			if (e.getKeyCode() == KeyEvent.VK_V) {
				view++;
				if (view == 8)
					view = 0;
			}
		}
    }
    public void keyReleased(KeyEvent e) {
    	if (!exwist) {
			if (u[0].multion < 2) {
				if (e.getKeyCode() == KeyEvent.VK_UP)
					u[0].up = false;
				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					u[0].down = false;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					u[0].right = false;
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					u[0].left = false;
				if (e.getKeyCode() == KeyEvent.VK_SPACE)
					u[0].handb = false;
			}
			if (e.getKeyCode() == 27) {
				u[0].exit = false;
				if (Madness.fullscreen)
					Madness.exitfullscreen();
			}
			if (e.getKeyCode() == KeyEvent.VK_X || e.getKeyCode() == KeyEvent.VK_Z)
				u[0].lookback = 0;
    	}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int i = e.getX();
		int i_206_ = e.getY();
		if (!exwist && !lostfcs) {
			xm = (int) ((i - apx) / apmult);
			ym = (int) ((i_206_ - apy) / apmult);
		}
		if (!Madness.fullscreen)
			sizescreen(i, i_206_);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int i = e.getX();
		int i_205_ = e.getY();
		if (!exwist && !lostfcs) {
			xm = (int) ((i - apx) / apmult);
			ym = (int) ((i_205_ - apy) / apmult);
		}
		if (!Madness.fullscreen) {
			if (showsize < 20)
				showsize = 20;
			if (i > 50 && i < 192 && i_205_ > 14 && i_205_ < 37) {
				if (!oncarm) {
					oncarm = true;
					setCursor(new Cursor(12));
				}
			} else if (oncarm) {
				oncarm = false;
				setCursor(new Cursor(0));
			}
			if (i > getWidth() - 208 && i < getWidth() - 50 && i_205_ > 14 && i_205_ < 37) {
				if (!onstgm) {
					onstgm = true;
					setCursor(new Cursor(12));
				}
			} else if (onstgm) {
				onstgm = false;
				setCursor(new Cursor(0));
			}
			if (i > getWidth() / 2 + 22 && i < getWidth() / 2 + 122 && i_205_ > 14 && i_205_ < 37) {
				if (!onfulls) {
				onfulls = true;
					setCursor(new Cursor(12));
				}
			} else if (onfulls) {
				onfulls = false;
				setCursor(new Cursor(0));
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int i = e.getX();
		int i_204_ = e.getY();
	requestFocus();
		if (!exwist) {
			if (mouses == 0) {
				xm = (int) ((i - apx) / apmult);
				ym = (int) ((i_204_ - apy) / apmult);
				mouses = 1;
			}
			moused = true;
		}
		if (!Madness.fullscreen)
			sizescreen(i, i_204_);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int i = e.getX();
		int i_203_ = e.getY();
		if (!exwist) {
			if (mouses == 11) {
				xm = (int) ((i - apx) / apmult);
				ym = (int) ((i_203_ - apy) / apmult);
				mouses = -1;
			}
			moused = false;
		}
		if (!Madness.fullscreen) {
			if (i > getWidth() / 2 - 55 && i < getWidth() / 2 + 7 && i_203_ > 21 && i_203_ < 38 && !onbar) {
				if (smooth == 1)
					smooth = 0;
				else
					smooth = 1;
				showsize = 60;
			}
			if (i > getWidth() / 2 + 133 && i < getWidth() / 2 + 231 && i_203_ > 7 && i_203_ < 24 && !onbar) {
				if (Madness.anti == 0)
					Madness.anti = 1;
				else
					Madness.anti = 0;
				showsize = 60;
			}
			if (i > getWidth() / 2 + 133 && i < getWidth() / 2 + 231 && i_203_ > 24 && i_203_ < 41 && !onbar) {
				if (moto == 0)
					moto = 1;
				else
					moto = 0;
				showsize = 60;
			}
			if (onfulls)
				Madness.gofullscreen();
			onbar = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
 	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}