
/* StageMaker - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.applet.Applet;
import java.awt.AlphaComposite;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JOptionPane;

public class StageMaker extends Applet implements Runnable {
	/**
	 *
	 */
	private static final long serialVersionUID = 2444709970063151411L;
	String[][] addeda = new String[20][5000];
	int adrot = 0;
	int apx = 0;
	int apy = 0;
	int arrcnt = 0;
	boolean arrng = false;
	int[][] atp = { { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 1520, 2830, -1520, -2830 },
			{ -1520, 2830, 1520, -2830 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 },
			{ 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 },
			{ 0, 2800, 0, -2800 }, { 0, 560, 0, -560 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 385, 980, 385, -980 },
			{ 0, 0, 0, -600 }, { 0, 0, 0, 0 }, { 0, 2164, 0, -2164 }, { 0, 2164, 0, -2164 }, { 0, 3309, 0, -1680 },
			{ 0, 1680, 0, -3309 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 1810, 980, 1810, -980 }, { 0, 0, 0, 0 }, { 0, 500, 0, -500 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 1680, 0, -3309 },
			{ 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 700, 1400, 700, -1400 },
			{ 0, -1480, 0, -1480 }, { 0, 0, 0, 0 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 700, 0, -700, 0 },
			{ 0, 0, 0, 0 }, { 0, -2198, 0, 1482 }, { 0, -1319, 0, 1391 }, { 0, -1894, 0, 2271 }, { 0, -826, 0, 839 },
			{ 0, -1400, 0, 1400 }, { 0, -1400, 0, 1400 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	int avon = 0;
	ContO[] bco = new ContO[67];
	String bstage = Messages.getString("StageMaker.0"); //$NON-NLS-1$
	Image[] btgame = new Image[2];
	int btn = 0;
	int[] bw = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] bx = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] by = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] cfade = { 255, 220, 220 };
	int[] cgrnd = { 205, 200, 200 };
	int chi = -1;
	int[] cldd = { 210, 210, 210, 1, -1000 };
	int cntout = 0;
	ContO[] co = new ContO[10000];
	CheckPoints cp = new CheckPoints();
	int[] csky = { 170, 220, 255 };
	String[] discp = {
			Messages.getString("StageMaker.1"), //$NON-NLS-1$
			Messages.getString("StageMaker.2"), //$NON-NLS-1$
			Messages.getString("StageMaker.3"), //$NON-NLS-1$
			Messages.getString("StageMaker.4"), //$NON-NLS-1$
			Messages.getString("StageMaker.5"), //$NON-NLS-1$
			Messages.getString("StageMaker.6"), //$NON-NLS-1$
			Messages.getString("StageMaker.7"), //$NON-NLS-1$
			Messages.getString("StageMaker.8"), //$NON-NLS-1$
			Messages.getString("StageMaker.9"), //$NON-NLS-1$
			Messages.getString("StageMaker.10"), //$NON-NLS-1$
			Messages.getString("StageMaker.11"), //$NON-NLS-1$
			Messages.getString("StageMaker.12"), //$NON-NLS-1$
			Messages.getString("StageMaker.13"), //$NON-NLS-1$
			Messages.getString("StageMaker.14"), //$NON-NLS-1$
			Messages.getString("StageMaker.15"), //$NON-NLS-1$
			Messages.getString("StageMaker.16"), //$NON-NLS-1$
			Messages.getString("StageMaker.17"), //$NON-NLS-1$
			Messages.getString("StageMaker.18"), //$NON-NLS-1$
			Messages.getString("StageMaker.19"), //$NON-NLS-1$
			Messages.getString("StageMaker.20"), //$NON-NLS-1$
			Messages.getString("StageMaker.21"), //$NON-NLS-1$
			Messages.getString("StageMaker.22"), //$NON-NLS-1$
			Messages.getString("StageMaker.23"), //$NON-NLS-1$
			Messages.getString("StageMaker.24"), //$NON-NLS-1$
			Messages.getString("StageMaker.25"), //$NON-NLS-1$
			Messages.getString("StageMaker.26"), //$NON-NLS-1$
			Messages.getString("StageMaker.27"), //$NON-NLS-1$
			Messages.getString("StageMaker.28"), //$NON-NLS-1$
			Messages.getString("StageMaker.29"), //$NON-NLS-1$
			Messages.getString("StageMaker.30"), //$NON-NLS-1$
			Messages.getString("StageMaker.31"), //$NON-NLS-1$
			Messages.getString("StageMaker.32"), //$NON-NLS-1$
			Messages.getString("StageMaker.33"), //$NON-NLS-1$
			Messages.getString("StageMaker.34"), //$NON-NLS-1$
			Messages.getString("StageMaker.35"), //$NON-NLS-1$
			Messages.getString("StageMaker.36"), //$NON-NLS-1$
			Messages.getString("StageMaker.37"), //$NON-NLS-1$
			Messages.getString("StageMaker.38"), Messages.getString("StageMaker.39"), //$NON-NLS-1$ //$NON-NLS-2$
			Messages.getString("StageMaker.40"), //$NON-NLS-1$
			Messages.getString("StageMaker.41"), //$NON-NLS-1$
			Messages.getString("StageMaker.42"), //$NON-NLS-1$
			Messages.getString("StageMaker.43"), //$NON-NLS-1$
			Messages.getString("StageMaker.44"), //$NON-NLS-1$
			Messages.getString("StageMaker.45"), //$NON-NLS-1$
			Messages.getString("StageMaker.46"), //$NON-NLS-1$
			Messages.getString("StageMaker.47"), //$NON-NLS-1$
			Messages.getString("StageMaker.48"), //$NON-NLS-1$
			Messages.getString("StageMaker.49"), //$NON-NLS-1$
			Messages.getString("StageMaker.50"), //$NON-NLS-1$
			Messages.getString("StageMaker.51"), //$NON-NLS-1$
			Messages.getString("StageMaker.52"), //$NON-NLS-1$
			Messages.getString("StageMaker.53"), //$NON-NLS-1$
			Messages.getString("StageMaker.54"), //$NON-NLS-1$
			Messages.getString("StageMaker.55"), //$NON-NLS-1$
			Messages.getString("StageMaker.56"), //$NON-NLS-1$
			Messages.getString("StageMaker.57"), //$NON-NLS-1$
			Messages.getString("StageMaker.58"), //$NON-NLS-1$
			Messages.getString("StageMaker.59"), //$NON-NLS-1$
			Messages.getString("StageMaker.60"), //$NON-NLS-1$
			Messages.getString("StageMaker.61"), //$NON-NLS-1$
			Messages.getString("StageMaker.62"), //$NON-NLS-1$
			Messages.getString("StageMaker.63"), //$NON-NLS-1$
			Messages.getString("StageMaker.64"), //$NON-NLS-1$
			Messages.getString("StageMaker.65"), //$NON-NLS-1$
			Messages.getString("StageMaker.66"), //$NON-NLS-1$
			Messages.getString("StageMaker.67") }; //$NON-NLS-1$
	boolean down = false;
	int dtab = 0;
	int dtabed = -1;
	boolean epart = false;
	int errd = 0;
	String[] errlo = {
			Messages.getString("StageMaker.68"), //$NON-NLS-1$
			Messages.getString("StageMaker.69"), //$NON-NLS-1$
			Messages.getString("StageMaker.70"), //$NON-NLS-1$
			Messages.getString("StageMaker.71"), //$NON-NLS-1$
			Messages.getString("StageMaker.72"), //$NON-NLS-1$
			Messages.getString("StageMaker.73"), //$NON-NLS-1$
			Messages.getString("StageMaker.74"), //$NON-NLS-1$
			Messages.getString("StageMaker.75") }; //$NON-NLS-1$
	int esp = -1;
	boolean exwist = false;
	int fgen = 0;
	TextField fixh = new TextField(Messages.getString("StageMaker.76"), 5); //$NON-NLS-1$
	int flyh = 0;
	boolean focuson = true;
	int[] fogn = { 60, 0 };
	FontMetrics ftm;
	int hf = 2000;
	int hi = -1;
	float[][] hsb = { { 0.5F, 0.875F, 0.5F }, { 0.5F, 0.875F, 0.5F }, { 0.5F, 0.875F, 0.5F } };
	boolean left = false;
	int logged = 0;
	Image logo;
	int lsp = -1;
	String ltrackname = Messages.getString("StageMaker.77"); //$NON-NLS-1$
	int lxm = 0;
	int lym = 0;
	Medium m = new Medium();
	String[] maker = new String[20];
	TextField mgen = new TextField(Messages.getString("StageMaker.78"), 10); //$NON-NLS-1$
	boolean mousdr = false;
	int mouseon = -1;
	int mouses = 0;
	String[] mystages = new String[20];
	int[] nad = new int[20];
	Smenu nlaps = new Smenu(40);
	int nms = 0;
	int nob = 0;
	int nundo = 0;
	int[] ocheckp = { 5, 6, 7, 11, 14, 33, 34, 38 };
	Image offImage;
	boolean onbtgame = false;
	boolean onfly = false;
	boolean onoff = false;
	int origfade = 5000;
	boolean overcan = false;
	Smenu part = new Smenu(40);
	boolean[] pessd = { false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false };
	Checkbox pfog = new Checkbox(Messages.getString("StageMaker.79")); //$NON-NLS-1$
	boolean pgen = false;
	float phd = 2L + Math.round(Math.random() * 4.0);
	boolean preop = false;
	Smenu ptyp = new Smenu(40);
	int[] pubt = new int[20];
	Smenu pubtyp = new Smenu(40);
	float pwd = 2L + Math.round(Math.random() * 4.0);
	int[] rcheckp = { 0, 1, 2, 3, 4, 12, 13, 37 };
	Graphics2D rd;
	boolean right = false;
	int rot = 0;
	Image[] sd = new Image[2];
	int seq = 0;
	boolean seqn = false;
	boolean setcur = false;
	int sfase = 0;
	Image[] sl = new Image[2];
	Smenu slstage = new Smenu(2000);
	int[] snap = { 50, 50, 50 };
	int sp = 0;
	int spart = 0;
	int sptyp = 0;
	Image[] sr = new Image[2];
	TextField srch = new TextField(Messages.getString("StageMaker.80"), 38); //$NON-NLS-1$
	String sstage = Messages.getString("StageMaker.81"); //$NON-NLS-1$
	String stagename = Messages.getString("StageMaker.82"); //$NON-NLS-1$
	Smenu strtyp = new Smenu(40);
	Image[] su = new Image[2];
	String suser = Messages.getString("StageMaker.83"); //$NON-NLS-1$
	int sx = 0;
	int sy = -10000;
	int sz = 1500;
	Trackers t = new Trackers();
	int tab = 0;
	int tabed = -1;
	int[] texture = { 0, 0, 0, 10 };
	Thread thredo;
	TextField tnick = new TextField(Messages.getString("StageMaker.84"), 15); //$NON-NLS-1$
	TextField tpass = new TextField(Messages.getString("StageMaker.85"), 15); //$NON-NLS-1$
	RadicalMod track = new RadicalMod();
	String trackname = Messages.getString("StageMaker.86"); //$NON-NLS-1$
	Smenu tracks = new Smenu(2000);
	int tracksize = 111;
	int trackvol = 200;
	String tstage = new StringBuilder()
			.append(Messages.getString("StageMaker.87")) //$NON-NLS-1$
			.append((int) (Math.random() * 100000.0)).append(Messages.getString("StageMaker.88")).toString(); //$NON-NLS-1$
	String ttstage = Messages.getString("StageMaker.89"); //$NON-NLS-1$
	String[] undos = new String[5000];
	boolean up = false;
	int vx = 0;
	int vxz = 0;
	int vy = 0;
	int vz = 0;
	Smenu witho = new Smenu(40);
	int xm = 0;
	int xnob = 0;
	int ym = 0;
	Image[] zi = new Image[2];
	Image[] zo = new Image[2];
	boolean zoomi = false;
	boolean zoomo = false;

	public boolean button(final String string, final int i, final int i_381_, final int i_382_, final boolean bool) {
		rd.setFont(new Font(Messages.getString("StageMaker.90"), 1, 12)); //$NON-NLS-1$
		ftm = rd.getFontMetrics();
		final int i_383_ = ftm.stringWidth(string);
		boolean bool_384_ = false;
		boolean bool_385_ = false;
		if (string.equals(Messages.getString("StageMaker.91")) && epart && Math.abs(xm - i) < i_383_ / 2 + 12 && Math.abs(ym - i_381_ + 5) < 10) //$NON-NLS-1$
			overcan = true;
		if (Math.abs(xm - i) < i_383_ / 2 + 12 && Math.abs(ym - i_381_ + 5) < 10 && mouses == 1)
			bool_384_ = true;
		else
			bool_384_ = false;
		if (Math.abs(xm - i) < i_383_ / 2 + 12 && Math.abs(ym - i_381_ + 5) < 10 && mouses == -1) {
			mouses = 0;
			bool_385_ = true;
		}
		boolean bool_386_ = false;
		if (bool) {
			if (tab == 0)
				rd.setColor(new Color(207, 207, 207));
			if (tab == 1)
				rd.setColor(new Color(200, 200, 200));
			if (tab == 2)
				rd.setColor(new Color(170, 170, 170));
			if (tab != 3) {
				rd.drawRect(i - i_383_ / 2 - 15, i_381_ - (22 - i_382_), i_383_ + 29, 34 - i_382_ * 2);
				if (i_382_ == 2 && tab == 1) {
					rd.setColor(new Color(220, 220, 220));
					rd.fillRect(i - i_383_ / 2 - 15, i_381_ - (22 - i_382_), i_383_ + 29, 34 - i_382_ * 2);
				}
			} else
				bool_386_ = true;
		}
		if (!bool_384_) {
			rd.setColor(new Color(220, 220, 220));
			if (bool_386_)
				rd.setColor(new Color(230, 230, 230));
			rd.fillRect(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i_383_ + 20, 25 - i_382_ * 2);
			rd.setColor(new Color(240, 240, 240));
			if (bool_386_)
				rd.setColor(new Color(255, 255, 255));
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ - (17 - i_382_));
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (18 - i_382_), i + i_383_ / 2 + 10, i_381_ - (18 - i_382_));
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_383_ / 2 - 9, i_381_ - (19 - i_382_), i + i_383_ / 2 + 9, i_381_ - (19 - i_382_));
			rd.setColor(new Color(200, 200, 200));
			if (bool_386_)
				rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i + i_383_ / 2 + 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ + 7 - i_382_);
			rd.drawLine(i + i_383_ / 2 + 11, i_381_ - (17 - i_382_), i + i_383_ / 2 + 11, i_381_ + 7 - i_382_);
			rd.setColor(new Color(200, 200, 200));
			if (bool_386_)
				rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i + i_383_ / 2 + 12, i_381_ - (16 - i_382_), i + i_383_ / 2 + 12, i_381_ + 6 - i_382_);
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ + 7 - i_382_, i + i_383_ / 2 + 10, i_381_ + 7 - i_382_);
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ + 8 - i_382_, i + i_383_ / 2 + 10, i_381_ + 8 - i_382_);
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i - i_383_ / 2 - 9, i_381_ + 9 - i_382_, i + i_383_ / 2 + 9, i_381_ + 9 - i_382_);
			rd.setColor(new Color(240, 240, 240));
			if (bool_386_)
				rd.setColor(new Color(255, 255, 255));
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i - i_383_ / 2 - 10, i_381_ + 7 - i_382_);
			rd.drawLine(i - i_383_ / 2 - 11, i_381_ - (17 - i_382_), i - i_383_ / 2 - 11, i_381_ + 7 - i_382_);
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_383_ / 2 - 12, i_381_ - (16 - i_382_), i - i_383_ / 2 - 12, i_381_ + 6 - i_382_);
			rd.setColor(new Color(0, 0, 0));
			if (string.equals(Messages.getString("StageMaker.92"))) //$NON-NLS-1$
				rd.setColor(new Color(100, 100, 100));
			rd.drawString(string, i - i_383_ / 2, i_381_);
		} else {
			rd.setColor(new Color(220, 220, 220));
			rd.fillRect(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i_383_ + 20, 25 - i_382_ * 2);
			rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ - (17 - i_382_));
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (18 - i_382_), i + i_383_ / 2 + 10, i_381_ - (18 - i_382_));
			rd.drawLine(i - i_383_ / 2 - 9, i_381_ - (19 - i_382_), i + i_383_ / 2 + 9, i_381_ - (19 - i_382_));
			rd.setColor(new Color(247, 247, 247));
			rd.drawLine(i + i_383_ / 2 + 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ + 7 - i_382_);
			rd.drawLine(i + i_383_ / 2 + 11, i_381_ - (17 - i_382_), i + i_383_ / 2 + 11, i_381_ + 7 - i_382_);
			rd.drawLine(i + i_383_ / 2 + 12, i_381_ - (16 - i_382_), i + i_383_ / 2 + 12, i_381_ + 6 - i_382_);
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ + 7 - i_382_, i + i_383_ / 2 + 10, i_381_ + 7 - i_382_);
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ + 8 - i_382_, i + i_383_ / 2 + 10, i_381_ + 8 - i_382_);
			rd.drawLine(i - i_383_ / 2 - 9, i_381_ + 9 - i_382_, i + i_383_ / 2 + 9, i_381_ + 9 - i_382_);
			rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i - i_383_ / 2 - 10, i_381_ + 7 - i_382_);
			rd.drawLine(i - i_383_ / 2 - 11, i_381_ - (17 - i_382_), i - i_383_ / 2 - 11, i_381_ + 7 - i_382_);
			rd.drawLine(i - i_383_ / 2 - 12, i_381_ - (16 - i_382_), i - i_383_ / 2 - 12, i_381_ + 6 - i_382_);
			rd.setColor(new Color(0, 0, 0));
			if (string.equals(Messages.getString("StageMaker.93"))) //$NON-NLS-1$
				rd.setColor(new Color(100, 100, 100));
			rd.drawString(string, i - i_383_ / 2 + 1, i_381_ + 1);
		}
		return bool_385_;
	}

	public void copyesp(final boolean bool) {
		sp = co[esp].colok;
		rot = co[esp].roofat;
		if (sp == 2)
			rot -= 30;
		if (sp == 3)
			rot += 30;
		if (sp == 15)
			rot += 90;
		if (sp == 20)
			rot += 180;
		if (sp == 26)
			rot -= 90;
		if (sp == 0) {
			sptyp = 0;
			spart = 0;
		}
		if (sp == 4) {
			sptyp = 0;
			spart = 1;
		}
		if (sp == 13) {
			sptyp = 0;
			spart = 2;
		}
		if (sp == 3) {
			sptyp = 0;
			spart = 3;
		}
		if (sp == 2) {
			sptyp = 0;
			spart = 4;
		}
		if (sp == 1) {
			sptyp = 0;
			spart = 5;
		}
		if (sp == 35) {
			sptyp = 0;
			spart = 6;
		}
		if (sp == 36) {
			sptyp = 0;
			spart = 7;
		}
		if (sp == 10) {
			sptyp = 0;
			spart = 8;
		}
		if (sp == 5) {
			sptyp = 0;
			spart = 9;
		}
		if (sp == 7) {
			sptyp = 0;
			spart = 10;
		}
		if (sp == 14) {
			sptyp = 0;
			spart = 11;
		}
		if (sp == 6) {
			sptyp = 0;
			spart = 12;
		}
		if (sp == 34) {
			sptyp = 0;
			spart = 13;
		}
		if (sp == 33) {
			sptyp = 0;
			spart = 14;
		}
		if (sp == 11) {
			sptyp = 0;
			spart = 15;
		}
		if (sp == 8) {
			sptyp = 0;
			spart = 16;
		}
		if (sp == 9) {
			sptyp = 0;
			spart = 17;
		}
		if (sp == 15) {
			sptyp = 0;
			spart = 18;
		}
		if (sp == 12) {
			sptyp = 0;
			spart = 19;
		}
		if (sp == 46) {
			sptyp = 0;
			spart = 20;
		}
		if (sp == 47) {
			sptyp = 0;
			spart = 21;
		}
		if (sp == 48) {
			sptyp = 0;
			spart = 23;
		}
		if (sp == 49) {
			sptyp = 0;
			spart = 24;
		}
		if (sp == 50) {
			sptyp = 0;
			spart = 22;
		}
		if (sp == 51) {
			sptyp = 0;
			spart = 25;
		}
		if (sp == 16) {
			sptyp = 1;
			spart = 0;
		}
		if (sp == 18) {
			sptyp = 1;
			spart = 1;
		}
		if (sp == 19) {
			sptyp = 1;
			spart = 2;
		}
		if (sp == 22) {
			sptyp = 1;
			spart = 3;
		}
		if (sp == 17) {
			sptyp = 1;
			spart = 4;
		}
		if (sp == 21) {
			sptyp = 1;
			spart = 5;
		}
		if (sp == 20) {
			sptyp = 1;
			spart = 6;
		}
		if (sp == 39) {
			sptyp = 1;
			spart = 7;
		}
		if (sp == 42) {
			sptyp = 1;
			spart = 8;
		}
		if (sp == 40) {
			sptyp = 1;
			spart = 9;
		}
		if (sp == 23) {
			sptyp = 1;
			spart = 10;
		}
		if (sp == 25) {
			sptyp = 1;
			spart = 11;
		}
		if (sp == 24) {
			sptyp = 1;
			spart = 12;
		}
		if (sp == 43) {
			sptyp = 1;
			spart = 13;
		}
		if (sp == 45) {
			sptyp = 1;
			spart = 14;
		}
		if (sp == 26) {
			sptyp = 1;
			spart = 15;
		}
		if (sp == 27) {
			sptyp = 2;
			spart = 0;
		}
		if (sp == 28) {
			sptyp = 2;
			spart = 1;
		}
		if (sp == 41) {
			sptyp = 2;
			spart = 2;
		}
		if (sp == 44) {
			sptyp = 2;
			spart = 3;
		}
		if (sp == 52) {
			sptyp = 2;
			spart = 4;
		}
		if (sp == 53) {
			sptyp = 2;
			spart = 5;
		}
		if (sp == 30 || sp == 32 || sp == 54) {
			sptyp = 3;
			spart = 0;
		}
		if (sp == 31) {
			sptyp = 4;
			spart = 0;
		}
		if (sp == 55) {
			sptyp = 5;
			spart = 0;
		}
		if (sp == 56) {
			sptyp = 5;
			spart = 1;
		}
		if (sp == 57) {
			sptyp = 5;
			spart = 2;
		}
		if (sp == 58) {
			sptyp = 5;
			spart = 3;
		}
		if (sp == 59) {
			sptyp = 5;
			spart = 4;
		}
		if (sp == 60) {
			sptyp = 5;
			spart = 5;
		}
		if (sp == 61) {
			sptyp = 5;
			spart = 6;
		}
		if (sp == 62) {
			sptyp = 5;
			spart = 7;
		}
		if (sp == 63) {
			sptyp = 5;
			spart = 8;
		}
		if (sp == 64) {
			sptyp = 5;
			spart = 9;
		}
		if (sp == 65) {
			sptyp = 5;
			spart = 10;
		}
		if (sp == 66) {
			if (bool)
				fgen = co[esp].srz;
			else
				fgen = 0;
			pwd = co[esp].srx;
			phd = co[esp].sry;
			pgen = false;
			sptyp = 6;
		}
		if (sptyp == 0) {
			partroads();
			part.setVisible(true);
		}
		if (sptyp == 1) {
			partramps();
			part.setVisible(true);
		}
		if (sptyp == 2) {
			partobst();
			part.setVisible(true);
		}
		if (sptyp == 5) {
			partrees();
			part.setVisible(true);
		}
		ptyp.select(sptyp);
		part.select(spart);
	}

	public void delstage(final String string) {
		try {
			final File file = new File(
					new StringBuilder().append(Messages.getString("StageMaker.94")).append(string).append(Messages.getString("StageMaker.95")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			file.delete();
			slstage.remove(string);
			slstage.select(0);
		} catch (final Exception exception) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("StageMaker.96")).append(exception).toString(), //$NON-NLS-1$
					Messages.getString("StageMaker.97"), 1); //$NON-NLS-1$
		}
	}

	public void deltrack() {
		try {
			final File file = new File(new StringBuilder().append(Messages.getString("StageMaker.98")).append(tracks.getSelectedItem()) //$NON-NLS-1$
					.append(Messages.getString("StageMaker.99")).toString()); //$NON-NLS-1$
			file.delete();
			if (trackname.equals(tracks.getSelectedItem())) {
				trackname = Messages.getString("StageMaker.100"); //$NON-NLS-1$
				sortop();
				savefile();
			}
			tracks.remove(tracks.getSelectedItem());
			tracks.select(0);
		} catch (final Exception exception) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("StageMaker.101")).append(exception).toString(), //$NON-NLS-1$
					Messages.getString("StageMaker.102"), 1); //$NON-NLS-1$
		}
	}

	public void drawms() {
		boolean bool = false;
		if (pubtyp.draw(rd, xm, ym, mousdr, 550, false))
			bool = true;
		if (slstage.draw(rd, xm, ym, mousdr, 550, false))
			bool = true;
		if (strtyp.draw(rd, xm, ym, mousdr, 550, false))
			bool = true;
		int i = 0;
		if (preop)
			i = -1000;
		if (part.draw(rd, xm, ym + i, mousdr && !preop, 550, false))
			bool = true;
		if (ptyp.draw(rd, xm, ym, mousdr, 550, false)) {
			bool = true;
			preop = true;
		} else
			preop = false;
		if (nlaps.draw(rd, xm, ym, mousdr, 550, true))
			bool = true;
		if (tracks.draw(rd, xm, ym, mousdr, 550, true))
			bool = true;
		if (witho.draw(rd, xm, ym, mousdr, 550, true))
			bool = true;
		if (bool)
			mouses = 0;
	}

	public void fixtext(final TextField textfield) {
		String string = textfield.getText();
		string = string.replace('\"', '#');
		final String string_330_ = Messages.getString("StageMaker.103"); //$NON-NLS-1$
		String string_331_ = Messages.getString("StageMaker.104"); //$NON-NLS-1$
		int i = 0;
		int i_332_ = -1;
		rd.setFont(new Font(Messages.getString("StageMaker.105"), 1, 12)); //$NON-NLS-1$
		ftm = rd.getFontMetrics();
		for (/**/; i < string.length(); i++) {
			final String string_333_ = new StringBuilder().append(Messages.getString("StageMaker.106")).append(string.charAt(i)).toString(); //$NON-NLS-1$
			if (string_333_.equals(Messages.getString("StageMaker.107")) || string_333_.equals(Messages.getString("StageMaker.108")) || string_333_.equals(Messages.getString("StageMaker.109")) || string_333_.equals(Messages.getString("StageMaker.110")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					|| string_333_.equals(Messages.getString("StageMaker.111")) || string_333_.equals(string_330_) || string_333_.equals(Messages.getString("StageMaker.112")) //$NON-NLS-1$ //$NON-NLS-2$
					|| string_333_.equals(Messages.getString("StageMaker.113")) || string_333_.equals(Messages.getString("StageMaker.114")) || string_333_.equals(Messages.getString("StageMaker.115")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_333_.equals(Messages.getString("StageMaker.116")) || string_333_.equals(Messages.getString("StageMaker.117")) || string_333_.equals(Messages.getString("StageMaker.118")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_333_.equals(Messages.getString("StageMaker.119")) || string_333_.equals(Messages.getString("StageMaker.120")) || string_333_.equals(Messages.getString("StageMaker.121")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_333_.equals(Messages.getString("StageMaker.122")) || string_333_.equals(Messages.getString("StageMaker.123")) || string_333_.equals(Messages.getString("StageMaker.124")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_333_.equals(Messages.getString("StageMaker.125")) || string_333_.equals(Messages.getString("StageMaker.126")) || string_333_.equals(Messages.getString("StageMaker.127")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_333_.equals(Messages.getString("StageMaker.128")) || ftm.stringWidth(string_331_) > 274) //$NON-NLS-1$
				i_332_ = i;
			else
				string_331_ = new StringBuilder().append(string_331_).append(string_333_).toString();
		}
		if (i_332_ != -1) {
			textfield.setText(string_331_);
			textfield.select(i_332_, i_332_);
		}
	}

	public Image getImage(final String string) {
		final Image image = Toolkit.getDefaultToolkit().createImage(string);
		final MediaTracker mediatracker = new MediaTracker(this);
		mediatracker.addImage(image, 0);
		try {
			mediatracker.waitForID(0);
		} catch (final Exception exception) {
			/* empty */
		}
		return image;
	}

	public int getint(final String string, final String string_354_, final int i) {
		int i_355_ = 0;
		String string_356_ = Messages.getString("StageMaker.129"); //$NON-NLS-1$
		for (int i_357_ = string.length() + 1; i_357_ < string_354_.length(); i_357_++) {
			final String string_358_ = new StringBuilder().append(Messages.getString("StageMaker.130")).append(string_354_.charAt(i_357_)).toString(); //$NON-NLS-1$
			if (string_358_.equals(Messages.getString("StageMaker.131")) || string_358_.equals(Messages.getString("StageMaker.132"))) { //$NON-NLS-1$ //$NON-NLS-2$
				i_355_++;
				i_357_++;
			}
			if (i_355_ == i)
				string_356_ = new StringBuilder().append(string_356_).append(string_354_.charAt(i_357_)).toString();
		}
		return Integer.valueOf(string_356_).intValue();
	}

	public String getstring(final String string, final String string_349_, final int i) {
		int i_350_ = 0;
		String string_351_ = Messages.getString("StageMaker.133"); //$NON-NLS-1$
		for (int i_352_ = string.length() + 1; i_352_ < string_349_.length(); i_352_++) {
			final String string_353_ = new StringBuilder().append(Messages.getString("StageMaker.134")).append(string_349_.charAt(i_352_)).toString(); //$NON-NLS-1$
			if (string_353_.equals(Messages.getString("StageMaker.135")) || string_353_.equals(Messages.getString("StageMaker.136"))) { //$NON-NLS-1$ //$NON-NLS-2$
				i_350_++;
				i_352_++;
			}
			if (i_350_ == i)
				string_351_ = new StringBuilder().append(string_351_).append(string_349_.charAt(i_352_)).toString();
		}
		return string_351_;
	}

	public String getSvalue(final String string, final String string_376_, final int i) {
		String string_377_ = Messages.getString("StageMaker.137"); //$NON-NLS-1$
		int i_378_ = 0;
		for (int i_379_ = string.length() + 1; i_379_ < string_376_.length() && i_378_ <= i; i_379_++) {
			final String string_380_ = new StringBuilder().append(Messages.getString("StageMaker.138")).append(string_376_.charAt(i_379_)).toString(); //$NON-NLS-1$
			if (string_380_.equals(Messages.getString("StageMaker.139")) || string_380_.equals(Messages.getString("StageMaker.140"))) //$NON-NLS-1$ //$NON-NLS-2$
				i_378_++;
			else if (i_378_ == i)
				string_377_ = new StringBuilder().append(string_377_).append(string_380_).toString();
		}
		return string_377_;
	}

	public int getvalue(final String string, final String string_371_, final int i) {
		int i_372_ = 0;
		String string_373_ = Messages.getString("StageMaker.141"); //$NON-NLS-1$
		for (int i_374_ = string.length() + 1; i_374_ < string_371_.length(); i_374_++) {
			final String string_375_ = new StringBuilder().append(Messages.getString("StageMaker.142")).append(string_371_.charAt(i_374_)).toString(); //$NON-NLS-1$
			if (string_375_.equals(Messages.getString("StageMaker.143")) || string_375_.equals(Messages.getString("StageMaker.144"))) { //$NON-NLS-1$ //$NON-NLS-2$
				i_372_++;
				i_374_++;
			}
			if (i_372_ == i)
				string_373_ = new StringBuilder().append(string_373_).append(string_371_.charAt(i_374_)).toString();
		}
		return Float.valueOf(string_373_).intValue();
	}

	public void hidefields() {
		pubtyp.setVisible(false);
		tpass.setVisible(false);
		tnick.setVisible(false);
		witho.setVisible(false);
		strtyp.setVisible(false);
		srch.setVisible(false);
		slstage.setVisible(false);
		tracks.setVisible(false);
		nlaps.setVisible(false);
		pfog.setVisible(false);
		fixh.setVisible(false);
		mgen.setVisible(false);
		ptyp.setVisible(false);
		part.setVisible(false);
	}

	@Override
	public void init() {
		setBackground(new Color(0, 0, 0));
		offImage = createImage(800, 550);
		if (offImage != null)
			rd = (Graphics2D) offImage.getGraphics();
		rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		setLayout(null);
		slstage.setFont(new Font(Messages.getString("StageMaker.145"), 1, 13)); //$NON-NLS-1$
		slstage.add(rd, Messages.getString("StageMaker.146")); //$NON-NLS-1$
		slstage.setForeground(new Color(63, 80, 110));
		slstage.setBackground(new Color(209, 217, 230));
		srch.setFont(new Font(Messages.getString("StageMaker.147"), 1, 12)); //$NON-NLS-1$
		srch.setBackground(new Color(255, 255, 255));
		srch.setForeground(new Color(0, 0, 0));
		strtyp.setFont(new Font(Messages.getString("StageMaker.148"), 1, 12)); //$NON-NLS-1$
		strtyp.add(rd, Messages.getString("StageMaker.149")); //$NON-NLS-1$
		strtyp.add(rd, Messages.getString("StageMaker.150")); //$NON-NLS-1$
		strtyp.setBackground(new Color(63, 80, 110));
		strtyp.setForeground(new Color(209, 217, 230));
		ptyp.setFont(new Font(Messages.getString("StageMaker.151"), 1, 12)); //$NON-NLS-1$
		ptyp.add(rd, Messages.getString("StageMaker.152")); //$NON-NLS-1$
		ptyp.add(rd, Messages.getString("StageMaker.153")); //$NON-NLS-1$
		ptyp.add(rd, Messages.getString("StageMaker.154")); //$NON-NLS-1$
		ptyp.add(rd, Messages.getString("StageMaker.155")); //$NON-NLS-1$
		ptyp.add(rd, Messages.getString("StageMaker.156")); //$NON-NLS-1$
		ptyp.add(rd, Messages.getString("StageMaker.157")); //$NON-NLS-1$
		ptyp.add(rd, Messages.getString("StageMaker.158")); //$NON-NLS-1$
		ptyp.setBackground(new Color(63, 80, 110));
		ptyp.setForeground(new Color(209, 217, 230));
		part.setFont(new Font(Messages.getString("StageMaker.159"), 1, 12)); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.160")); //$NON-NLS-1$
		part.setBackground(new Color(63, 80, 110));
		part.setForeground(new Color(209, 217, 230));
		fixh.setFont(new Font(Messages.getString("StageMaker.161"), 1, 12)); //$NON-NLS-1$
		fixh.setBackground(new Color(255, 255, 255));
		fixh.setForeground(new Color(0, 0, 0));
		mgen.setFont(new Font(Messages.getString("StageMaker.162"), 1, 12)); //$NON-NLS-1$
		mgen.setBackground(new Color(255, 255, 255));
		mgen.setForeground(new Color(0, 0, 0));
		pfog.setFont(new Font(Messages.getString("StageMaker.163"), 1, 12)); //$NON-NLS-1$
		pfog.setBackground(new Color(225, 225, 225));
		pfog.setForeground(new Color(0, 0, 0));
		nlaps.setFont(new Font(Messages.getString("StageMaker.164"), 1, 12)); //$NON-NLS-1$
		for (int i = 0; i < 15; i++)
			nlaps.add(rd, new StringBuilder().append(Messages.getString("StageMaker.165")).append(i + 1).append(Messages.getString("StageMaker.166")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
		nlaps.setBackground(new Color(63, 80, 110));
		nlaps.setForeground(new Color(209, 217, 230));
		tracks.setFont(new Font(Messages.getString("StageMaker.167"), 1, 12)); //$NON-NLS-1$
		tracks.add(rd, Messages.getString("StageMaker.168")); //$NON-NLS-1$
		tracks.setForeground(new Color(63, 80, 110));
		tracks.setBackground(new Color(209, 217, 230));
		witho.setFont(new Font(Messages.getString("StageMaker.169"), 1, 12)); //$NON-NLS-1$
		witho.add(rd, Messages.getString("StageMaker.170")); //$NON-NLS-1$
		witho.add(rd, Messages.getString("StageMaker.171")); //$NON-NLS-1$
		witho.setBackground(new Color(63, 80, 110));
		witho.setForeground(new Color(209, 217, 230));
		tnick.setFont(new Font(Messages.getString("StageMaker.172"), 1, 13)); //$NON-NLS-1$
		tnick.setBackground(new Color(255, 255, 255));
		tnick.setForeground(new Color(0, 0, 0));
		tpass.setFont(new Font(Messages.getString("StageMaker.173"), 1, 13)); //$NON-NLS-1$
		tpass.setEchoCharacter('*');
		tpass.setBackground(new Color(255, 255, 255));
		tpass.setForeground(new Color(0, 0, 0));
		pubtyp.setFont(new Font(Messages.getString("StageMaker.174"), 1, 13)); //$NON-NLS-1$
		pubtyp.add(rd, Messages.getString("StageMaker.175")); //$NON-NLS-1$
		pubtyp.add(rd, Messages.getString("StageMaker.176")); //$NON-NLS-1$
		pubtyp.add(rd, Messages.getString("StageMaker.177")); //$NON-NLS-1$
		pubtyp.setBackground(new Color(63, 80, 110));
		pubtyp.setForeground(new Color(209, 217, 230));
		add(tnick);
		add(tpass);
		add(srch);
		add(fixh);
		add(mgen);
		add(pfog);
		hidefields();
	}

	@Override
	public boolean keyDown(final Event event, final int i) {
		if (focuson) {
			if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87 || i == 43 || i == 61)
				zoomi = true;
			if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83 || i == 45)
				zoomo = true;
			if (i == 1006)
				left = true;
			if (i == 1007)
				right = true;
			if (i == 1005)
				down = true;
			if (i == 1004)
				up = true;
		}
		return false;
	}

	@Override
	public boolean keyUp(final Event event, final int i) {
		if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87 || i == 43 || i == 61)
			zoomi = false;
		if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83 || i == 45)
			zoomo = false;
		if (i == 1006)
			left = false;
		if (i == 1007)
			right = false;
		if (i == 1005)
			down = false;
		if (i == 1004)
			up = false;
		return false;
	}

	public void loadbase() {
		final String[] strings = { Messages.getString("StageMaker.178"), Messages.getString("StageMaker.179"), Messages.getString("StageMaker.180"), Messages.getString("StageMaker.181"), Messages.getString("StageMaker.182"), Messages.getString("StageMaker.183"), Messages.getString("StageMaker.184"), Messages.getString("StageMaker.185"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				Messages.getString("StageMaker.186"), Messages.getString("StageMaker.187"), Messages.getString("StageMaker.188"), Messages.getString("StageMaker.189"), Messages.getString("StageMaker.190"), Messages.getString("StageMaker.191"), Messages.getString("StageMaker.192"), Messages.getString("StageMaker.193"), Messages.getString("StageMaker.194"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
				Messages.getString("StageMaker.195"), Messages.getString("StageMaker.196"), Messages.getString("StageMaker.197"), Messages.getString("StageMaker.198"), Messages.getString("StageMaker.199"), Messages.getString("StageMaker.200"), Messages.getString("StageMaker.201"), Messages.getString("StageMaker.202"), Messages.getString("StageMaker.203"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
				Messages.getString("StageMaker.204"), Messages.getString("StageMaker.205"), Messages.getString("StageMaker.206"), Messages.getString("StageMaker.207"), Messages.getString("StageMaker.208"), Messages.getString("StageMaker.209"), Messages.getString("StageMaker.210"), Messages.getString("StageMaker.211"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
				Messages.getString("StageMaker.212"), Messages.getString("StageMaker.213"), Messages.getString("StageMaker.214"), Messages.getString("StageMaker.215"), Messages.getString("StageMaker.216"), Messages.getString("StageMaker.217"), Messages.getString("StageMaker.218"), Messages.getString("StageMaker.219"), Messages.getString("StageMaker.220"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
				Messages.getString("StageMaker.221"), Messages.getString("StageMaker.222"), Messages.getString("StageMaker.223"), Messages.getString("StageMaker.224"), Messages.getString("StageMaker.225"), Messages.getString("StageMaker.226"), Messages.getString("StageMaker.227"), Messages.getString("StageMaker.228"), Messages.getString("StageMaker.229"), Messages.getString("StageMaker.230"), Messages.getString("StageMaker.231"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
				Messages.getString("StageMaker.232"), Messages.getString("StageMaker.233"), Messages.getString("StageMaker.234"), Messages.getString("StageMaker.235"), Messages.getString("StageMaker.236"), Messages.getString("StageMaker.237"), Messages.getString("StageMaker.238"), Messages.getString("StageMaker.239"), Messages.getString("StageMaker.240"), Messages.getString("StageMaker.241"), Messages.getString("StageMaker.242"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$
				Messages.getString("StageMaker.243") }; //$NON-NLS-1$
		try {
			final File file = new File(Messages.getString("StageMaker.244")); //$NON-NLS-1$
			final ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));
			ZipEntry zipentry = zipinputstream.getNextEntry();
			for (/**/; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
				int i = -1;
				for (int i_176_ = 0; i_176_ < 66; i_176_++)
					if (zipentry.getName().startsWith(strings[i_176_]))
						i = i_176_;
				if (i != -1) {
					int i_177_ = (int) zipentry.getSize();
					final byte[] is = new byte[i_177_];
					int i_178_ = 0;
					int i_179_;
					for (/**/; i_177_ > 0; i_177_ -= i_179_) {
						i_179_ = zipinputstream.read(is, i_178_, i_177_);
						i_178_ += i_179_;
					}
					bco[i] = new ContO(is, m, t);
					for (int i_180_ = 0; i_180_ < bco[i].npl; i_180_++)
						bco[i].p[i_180_].loadprojf();
					if (i == 31)
						bco[i].elec = true;
				}
			}
			zipinputstream.close();
			bco[66] = new ContO((int) (10000.0 * Math.random()), (int) pwd, (int) phd, m, t, 0, 0, 0);
		} catch (final Exception exception) {
			JOptionPane.showMessageDialog(null, new StringBuilder()
					.append(Messages.getString("StageMaker.245")).append(exception).toString(), //$NON-NLS-1$
					Messages.getString("StageMaker.246"), 1); //$NON-NLS-1$
		}
		System.gc();
	}

	public void loadsettings() {
		try {
			final File file = new File(Messages.getString("StageMaker.247")); //$NON-NLS-1$
			if (file.exists()) {
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string = bufferedreader.readLine();
				if (string != null) {
					sstage = string;
					stagename = sstage;
				}
				string = bufferedreader.readLine();
				if (string != null) {
					suser = string;
					if (!suser.equals(Messages.getString("StageMaker.248"))) //$NON-NLS-1$
						tnick.setText(suser);
				}
				bufferedreader.close();
			}
		} catch (final Exception exception) {
			/* empty */
		}
	}

	@Override
	public boolean mouseDown(final Event event, final int i, final int i_173_) {
		mousdr = true;
		xm = i - apx;
		ym = i_173_ - apy;
		mouses = 1;
		requestFocus();
		focuson = true;
		return false;
	}

	@Override
	public boolean mouseDrag(final Event event, final int i, final int i_175_) {
		mousdr = true;
		xm = i - apx;
		ym = i_175_ - apy;
		return false;
	}

	@Override
	public boolean mouseMove(final Event event, final int i, final int i_174_) {
		xm = i - apx;
		ym = i_174_ - apy;
		if (xm > 620 && xm < 774 && ym > 0 && ym < 23) {
			if (!onbtgame) {
				onbtgame = true;
				setCursor(new Cursor(12));
			}
		} else if (onbtgame) {
			onbtgame = false;
			setCursor(new Cursor(0));
		}
		return false;
	}

	@Override
	public boolean mouseUp(final Event event, final int i, final int i_172_) {
		mousdr = false;
		xm = i - apx;
		ym = i_172_ - apy;
		if (mouses == 1)
			mouses = -1;
		if (onbtgame)
			Madness.game();
		return false;
	}

	public void movefield(final Component component, int i, int i_169_, final int i_170_, final int i_171_) {
		i += apx;
		i_169_ += apy;
		if (component.getX() != i || component.getY() != i_169_ || component.getWidth() != i_170_
				|| component.getHeight() != i_171_)
			component.setBounds(i, i_169_, i_170_, i_171_);
	}

	public void newstage() {
		if (!srch.getText().equals(Messages.getString("StageMaker.249"))) { //$NON-NLS-1$
			final File file = new File(
					new StringBuilder().append(Messages.getString("StageMaker.250")).append(srch.getText()).append(Messages.getString("StageMaker.251")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			if (!file.exists()) {
				stagename = srch.getText();
				tstage = new StringBuilder()
						.append(Messages.getString("StageMaker.252")) //$NON-NLS-1$
						.append((int) (Math.random() * 100000.0)).append(Messages.getString("StageMaker.253")).toString(); //$NON-NLS-1$
				if (strtyp.getSelectedIndex() == 1)
					bstage = Messages.getString("StageMaker.254"); //$NON-NLS-1$
				else
					bstage = Messages.getString("StageMaker.255"); //$NON-NLS-1$
				final StringBuilder stringbuilder = new StringBuilder();
				final StageMaker stagemaker_238_ = this;
				stagemaker_238_.bstage = stringbuilder.append(stagemaker_238_.bstage)
						.append(Messages.getString("StageMaker.256")) //$NON-NLS-1$
						.toString();
				savefile();
				strtyp.setVisible(false);
				srch.setVisible(false);
				sfase = 0;
				tabed = -2;
			} else
				JOptionPane.showMessageDialog(null,
						Messages.getString("StageMaker.257"), Messages.getString("StageMaker.258"), 1); //$NON-NLS-1$ //$NON-NLS-2$
		} else
			JOptionPane.showMessageDialog(null, Messages.getString("StageMaker.259"), Messages.getString("StageMaker.260"), 1); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void openhlink() {
		Madness.openurl(Messages.getString("StageMaker.261")); //$NON-NLS-1$
	}

	public void openlink() {
		Madness.openurl(Messages.getString("StageMaker.262")); //$NON-NLS-1$
	}

	public boolean ovbutton(final String string, final int i, final int i_387_) {
		rd.setFont(new Font(Messages.getString("StageMaker.263"), 0, 12)); //$NON-NLS-1$
		ftm = rd.getFontMetrics();
		if (string.equals(Messages.getString("StageMaker.264")) || string.equals(Messages.getString("StageMaker.265"))) { //$NON-NLS-1$ //$NON-NLS-2$
			rd.setFont(new Font(Messages.getString("StageMaker.266"), 1, 12)); //$NON-NLS-1$
			ftm = rd.getFontMetrics();
		}
		final int i_388_ = ftm.stringWidth(string);
		final int i_389_ = 4;
		boolean bool = false;
		boolean bool_390_ = false;
		if (Math.abs(xm - i) < i_388_ / 2 + 12 && Math.abs(ym - i_387_ + 5) < 10 && mouses == 1)
			bool = true;
		else
			bool = false;
		if (Math.abs(xm - i) < i_388_ / 2 + 12 && Math.abs(ym - i_387_ + 5) < 10 && mouses == -1) {
			mouses = 0;
			bool_390_ = true;
		}
		if (!bool) {
			rd.setColor(new Color(220, 220, 220));
			rd.fillRect(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i_388_ + 20, 25 - i_389_ * 2);
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ - (17 - i_389_));
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (18 - i_389_), i + i_388_ / 2 + 10, i_387_ - (18 - i_389_));
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_388_ / 2 - 9, i_387_ - (19 - i_389_), i + i_388_ / 2 + 9, i_387_ - (19 - i_389_));
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i + i_388_ / 2 + 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ + 7 - i_389_);
			rd.drawLine(i + i_388_ / 2 + 11, i_387_ - (17 - i_389_), i + i_388_ / 2 + 11, i_387_ + 7 - i_389_);
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i + i_388_ / 2 + 12, i_387_ - (16 - i_389_), i + i_388_ / 2 + 12, i_387_ + 6 - i_389_);
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ + 7 - i_389_, i + i_388_ / 2 + 10, i_387_ + 7 - i_389_);
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ + 8 - i_389_, i + i_388_ / 2 + 10, i_387_ + 8 - i_389_);
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i - i_388_ / 2 - 9, i_387_ + 9 - i_389_, i + i_388_ / 2 + 9, i_387_ + 9 - i_389_);
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i - i_388_ / 2 - 10, i_387_ + 7 - i_389_);
			rd.drawLine(i - i_388_ / 2 - 11, i_387_ - (17 - i_389_), i - i_388_ / 2 - 11, i_387_ + 7 - i_389_);
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_388_ / 2 - 12, i_387_ - (16 - i_389_), i - i_388_ / 2 - 12, i_387_ + 6 - i_389_);
			rd.setColor(new Color(0, 0, 0));
			if (string.equals(Messages.getString("StageMaker.267"))) //$NON-NLS-1$
				rd.setColor(new Color(255, 0, 0));
			if (string.equals(Messages.getString("StageMaker.268"))) //$NON-NLS-1$
				rd.setColor(new Color(0, 64, 128));
			rd.drawString(string, i - i_388_ / 2, i_387_);
		} else {
			rd.setColor(new Color(220, 220, 220));
			rd.fillRect(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i_388_ + 20, 25 - i_389_ * 2);
			rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ - (17 - i_389_));
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (18 - i_389_), i + i_388_ / 2 + 10, i_387_ - (18 - i_389_));
			rd.drawLine(i - i_388_ / 2 - 9, i_387_ - (19 - i_389_), i + i_388_ / 2 + 9, i_387_ - (19 - i_389_));
			rd.setColor(new Color(247, 247, 247));
			rd.drawLine(i + i_388_ / 2 + 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ + 7 - i_389_);
			rd.drawLine(i + i_388_ / 2 + 11, i_387_ - (17 - i_389_), i + i_388_ / 2 + 11, i_387_ + 7 - i_389_);
			rd.drawLine(i + i_388_ / 2 + 12, i_387_ - (16 - i_389_), i + i_388_ / 2 + 12, i_387_ + 6 - i_389_);
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ + 7 - i_389_, i + i_388_ / 2 + 10, i_387_ + 7 - i_389_);
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ + 8 - i_389_, i + i_388_ / 2 + 10, i_387_ + 8 - i_389_);
			rd.drawLine(i - i_388_ / 2 - 9, i_387_ + 9 - i_389_, i + i_388_ / 2 + 9, i_387_ + 9 - i_389_);
			rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i - i_388_ / 2 - 10, i_387_ + 7 - i_389_);
			rd.drawLine(i - i_388_ / 2 - 11, i_387_ - (17 - i_389_), i - i_388_ / 2 - 11, i_387_ + 7 - i_389_);
			rd.drawLine(i - i_388_ / 2 - 12, i_387_ - (16 - i_389_), i - i_388_ / 2 - 12, i_387_ + 6 - i_389_);
			rd.setColor(new Color(0, 0, 0));
			if (string.equals(Messages.getString("StageMaker.269"))) //$NON-NLS-1$
				rd.setColor(new Color(255, 0, 0));
			if (string.equals(Messages.getString("StageMaker.270"))) //$NON-NLS-1$
				rd.setColor(new Color(0, 64, 128));
			rd.drawString(string, i - i_388_ / 2 + 1, i_387_ + 1);
		}
		return bool_390_;
	}

	@Override
	public void paint(final Graphics graphics) {
		apx = getWidth() / 2 - 400;
		apy = getHeight() / 2 - 275;
		graphics.drawImage(offImage, apx, apy, this);
	}

	public void partobst() {
		part.removeAll();
		part.add(rd, Messages.getString("StageMaker.271")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.272")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.273")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.274")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.275")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.276")); //$NON-NLS-1$
	}

	public void partramps() {
		part.removeAll();
		part.add(rd, Messages.getString("StageMaker.277")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.278")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.279")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.280")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.281")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.282")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.283")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.284")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.285")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.286")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.287")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.288")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.289")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.290")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.291")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.292")); //$NON-NLS-1$
	}

	public void partrees() {
		part.removeAll();
		part.add(rd, Messages.getString("StageMaker.293")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.294")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.295")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.296")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.297")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.298")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.299")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.300")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.301")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.302")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.303")); //$NON-NLS-1$
	}

	public void partroads() {
		part.removeAll();
		part.add(rd, Messages.getString("StageMaker.304")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.305")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.306")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.307")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.308")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.309")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.310")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.311")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.312")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.313")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.314")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.315")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.316")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.317")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.318")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.319")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.320")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.321")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.322")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.323")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.324")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.325")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.326")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.327")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.328")); //$NON-NLS-1$
		part.add(rd, Messages.getString("StageMaker.329")); //$NON-NLS-1$
	}

	public int py(final int i, final int i_343_, final int i_344_, final int i_345_) {
		return (int) Math.sqrt((i - i_343_) * (i - i_343_) + (i_344_ - i_345_) * (i_344_ - i_345_));
	}

	public int pyn(final int i, final int i_346_, final int i_347_, final int i_348_) {
		return (i - i_346_) / 100 * ((i - i_346_) / 100) + (i_347_ - i_348_) / 100 * ((i_347_ - i_348_) / 100);
	}

	public void readstage(final int i) {
		errd = 0;
		trackname = Messages.getString("StageMaker.330"); //$NON-NLS-1$
		t.nt = 0;
		nob = 0;
		xnob = 0;
		cp.n = 0;
		cp.nsp = 0;
		cp.fn = 0;
		cp.haltall = false;
		cp.wasted = 0;
		cp.catchfin = 0;
		m.ground = 250;
		m.lightson = false;
		if (i == 0) {
			m.snap[0] = 0;
			m.snap[1] = 0;
			m.snap[2] = 0;
		}
		if (i == 3) {
			tstage = Messages.getString("StageMaker.331"); //$NON-NLS-1$
			bstage = Messages.getString("StageMaker.332"); //$NON-NLS-1$
		}
		String string = bstage;
		if (i == 1 || i == 2)
			string = new StringBuilder().append(Messages.getString("StageMaker.333")).append(tstage).append(Messages.getString("StageMaker.334")).append(bstage).append(Messages.getString("StageMaker.335")).toString(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		int i_181_ = 0;
		int i_182_ = 100;
		int i_183_ = 0;
		int i_184_ = 100;
		boolean bool = true;
		boolean bool_185_ = true;
		String string_186_ = Messages.getString("StageMaker.336"); //$NON-NLS-1$
		try {
			DataInputStream datainputstream;
			if (i == 3) {
				final File file = new File(
						new StringBuilder().append(Messages.getString("StageMaker.337")).append(stagename).append(Messages.getString("StageMaker.338")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				datainputstream = new DataInputStream(new FileInputStream(file));
				nundo = 0;
			} else
				datainputstream = new DataInputStream(new ByteArrayInputStream(string.getBytes()));
			String string_187_;
			while ((string_187_ = datainputstream.readLine()) != null) {
				string_186_ = new StringBuilder().append(Messages.getString("StageMaker.339")).append(string_187_.trim()).toString(); //$NON-NLS-1$
				if (string_186_.startsWith(Messages.getString("StageMaker.340"))) { //$NON-NLS-1$
					csky[0] = getint(Messages.getString("StageMaker.341"), string_186_, 0); //$NON-NLS-1$
					csky[1] = getint(Messages.getString("StageMaker.342"), string_186_, 1); //$NON-NLS-1$
					csky[2] = getint(Messages.getString("StageMaker.343"), string_186_, 2); //$NON-NLS-1$
					m.setsky(csky[0], csky[1], csky[2]);
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_188_ = this;
						stagemaker_188_.tstage = stringbuilder.append(stagemaker_188_.tstage).append(Messages.getString("StageMaker.344")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.345")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.346"))) { //$NON-NLS-1$
					cgrnd[0] = getint(Messages.getString("StageMaker.347"), string_186_, 0); //$NON-NLS-1$
					cgrnd[1] = getint(Messages.getString("StageMaker.348"), string_186_, 1); //$NON-NLS-1$
					cgrnd[2] = getint(Messages.getString("StageMaker.349"), string_186_, 2); //$NON-NLS-1$
					m.setgrnd(cgrnd[0], cgrnd[1], cgrnd[2]);
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_189_ = this;
						stagemaker_189_.tstage = stringbuilder.append(stagemaker_189_.tstage).append(Messages.getString("StageMaker.350")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.351")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.352"))) { //$NON-NLS-1$
					m.setpolys(getint(Messages.getString("StageMaker.353"), string_186_, 0), getint(Messages.getString("StageMaker.354"), string_186_, 1), //$NON-NLS-1$ //$NON-NLS-2$
							getint(Messages.getString("StageMaker.355"), string_186_, 2)); //$NON-NLS-1$
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_190_ = this;
						stagemaker_190_.tstage = stringbuilder.append(stagemaker_190_.tstage).append(Messages.getString("StageMaker.356")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.357")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.358"))) { //$NON-NLS-1$
					cfade[0] = getint(Messages.getString("StageMaker.359"), string_186_, 0); //$NON-NLS-1$
					cfade[1] = getint(Messages.getString("StageMaker.360"), string_186_, 1); //$NON-NLS-1$
					cfade[2] = getint(Messages.getString("StageMaker.361"), string_186_, 2); //$NON-NLS-1$
					m.setfade(cfade[0], cfade[1], cfade[2]);
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_191_ = this;
						stagemaker_191_.tstage = stringbuilder.append(stagemaker_191_.tstage).append(Messages.getString("StageMaker.362")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.363")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.364"))) { //$NON-NLS-1$
					texture[0] = getint(Messages.getString("StageMaker.365"), string_186_, 0); //$NON-NLS-1$
					texture[1] = getint(Messages.getString("StageMaker.366"), string_186_, 1); //$NON-NLS-1$
					texture[2] = getint(Messages.getString("StageMaker.367"), string_186_, 2); //$NON-NLS-1$
					texture[3] = getint(Messages.getString("StageMaker.368"), string_186_, 3); //$NON-NLS-1$
					m.setexture(texture[0], texture[1], texture[2], texture[3]);
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_192_ = this;
						stagemaker_192_.tstage = stringbuilder.append(stagemaker_192_.tstage).append(Messages.getString("StageMaker.369")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.370")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.371"))) { //$NON-NLS-1$
					cldd[0] = getint(Messages.getString("StageMaker.372"), string_186_, 0); //$NON-NLS-1$
					cldd[1] = getint(Messages.getString("StageMaker.373"), string_186_, 1); //$NON-NLS-1$
					cldd[2] = getint(Messages.getString("StageMaker.374"), string_186_, 2); //$NON-NLS-1$
					cldd[3] = getint(Messages.getString("StageMaker.375"), string_186_, 3); //$NON-NLS-1$
					cldd[4] = getint(Messages.getString("StageMaker.376"), string_186_, 4); //$NON-NLS-1$
					m.setcloads(cldd[0], cldd[1], cldd[2], cldd[3], cldd[4]);
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_193_ = this;
						stagemaker_193_.tstage = stringbuilder.append(stagemaker_193_.tstage).append(Messages.getString("StageMaker.377")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.378")).toString(); //$NON-NLS-1$
					}
				}
				if (i != 2 && string_186_.startsWith(Messages.getString("StageMaker.379"))) { //$NON-NLS-1$
					m.setsnap(getint(Messages.getString("StageMaker.380"), string_186_, 0), getint(Messages.getString("StageMaker.381"), string_186_, 1), //$NON-NLS-1$ //$NON-NLS-2$
							getint(Messages.getString("StageMaker.382"), string_186_, 2)); //$NON-NLS-1$
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_194_ = this;
						stagemaker_194_.tstage = stringbuilder.append(stagemaker_194_.tstage).append(Messages.getString("StageMaker.383")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.384")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.385"))) { //$NON-NLS-1$
					m.fogd = (getint(Messages.getString("StageMaker.386"), string_186_, 0) + 1) * 2 - 1; //$NON-NLS-1$
					if (m.fogd < 1)
						m.fogd = 1;
					if (m.fogd > 30)
						m.fogd = 30;
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_195_ = this;
						stagemaker_195_.tstage = stringbuilder.append(stagemaker_195_.tstage).append(Messages.getString("StageMaker.387")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.388")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.389"))) { //$NON-NLS-1$
					m.mgen = getint(Messages.getString("StageMaker.390"), string_186_, 0); //$NON-NLS-1$
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_196_ = this;
						stagemaker_196_.tstage = stringbuilder.append(stagemaker_196_.tstage).append(Messages.getString("StageMaker.391")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.392")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.393"))) { //$NON-NLS-1$
					m.fadfrom(getint(Messages.getString("StageMaker.394"), string_186_, 0)); //$NON-NLS-1$
					origfade = m.fade[0];
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_197_ = this;
						stagemaker_197_.tstage = stringbuilder.append(stagemaker_197_.tstage).append(Messages.getString("StageMaker.395")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.396")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.397"))) { //$NON-NLS-1$
					m.lightson = true;
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_198_ = this;
						stagemaker_198_.tstage = stringbuilder.append(stagemaker_198_.tstage).append(Messages.getString("StageMaker.398")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.399")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.400"))) { //$NON-NLS-1$
					cp.nlaps = getint(Messages.getString("StageMaker.401"), string_186_, 0); //$NON-NLS-1$
					if (cp.nlaps < 1)
						cp.nlaps = 1;
					if (cp.nlaps > 15)
						cp.nlaps = 15;
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_199_ = this;
						stagemaker_199_.tstage = stringbuilder.append(stagemaker_199_.tstage).append(Messages.getString("StageMaker.402")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.403")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.404"))) { //$NON-NLS-1$
					trackname = getstring(Messages.getString("StageMaker.405"), string_186_, 0); //$NON-NLS-1$
					trackvol = getint(Messages.getString("StageMaker.406"), string_186_, 1); //$NON-NLS-1$
					tracksize = getint(Messages.getString("StageMaker.407"), string_186_, 2); //$NON-NLS-1$
					if (i == 3) {
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_200_ = this;
						stagemaker_200_.tstage = stringbuilder.append(stagemaker_200_.tstage).append(Messages.getString("StageMaker.408")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.409")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.410"))) { //$NON-NLS-1$
					int i_201_ = getint(Messages.getString("StageMaker.411"), string_186_, 0); //$NON-NLS-1$
					if (i_201_ >= 10 && i_201_ <= 25)
						m.loadnew = true;
					i_201_ -= 10;
					co[nob] = new ContO(bco[i_201_], getint(Messages.getString("StageMaker.412"), string_186_, 1), m.ground - bco[i_201_].grat, //$NON-NLS-1$
							getint(Messages.getString("StageMaker.413"), string_186_, 2), getint(Messages.getString("StageMaker.414"), string_186_, 3)); //$NON-NLS-1$ //$NON-NLS-2$
					co[nob].roofat = getint(Messages.getString("StageMaker.415"), string_186_, 3); //$NON-NLS-1$
					co[nob].colok = i_201_;
					if (string_186_.indexOf(Messages.getString("StageMaker.416")) != -1) { //$NON-NLS-1$
						cp.x[cp.n] = getint(Messages.getString("StageMaker.417"), string_186_, 1); //$NON-NLS-1$
						cp.z[cp.n] = getint(Messages.getString("StageMaker.418"), string_186_, 2); //$NON-NLS-1$
						cp.y[cp.n] = 0;
						cp.typ[cp.n] = 0;
						if (string_186_.indexOf(Messages.getString("StageMaker.419")) != -1) //$NON-NLS-1$
							cp.typ[cp.n] = -1;
						if (string_186_.indexOf(Messages.getString("StageMaker.420")) != -1) //$NON-NLS-1$
							cp.typ[cp.n] = -2;
						if (string_186_.indexOf(Messages.getString("StageMaker.421")) != -1) //$NON-NLS-1$
							cp.typ[cp.n] = -3;
						if (string_186_.indexOf(Messages.getString("StageMaker.422")) != -1) //$NON-NLS-1$
							cp.typ[cp.n] = -4;
						cp.n++;
					}
					xnob++;
					nob++;
					if (i == 3) {
						if (bool_185_) {
							final StringBuilder stringbuilder = new StringBuilder();
							final StageMaker stagemaker_202_ = this;
							stagemaker_202_.bstage = stringbuilder.append(stagemaker_202_.bstage).append(Messages.getString("StageMaker.423")) //$NON-NLS-1$
									.toString();
							bool_185_ = false;
						}
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_203_ = this;
						stagemaker_203_.bstage = stringbuilder.append(stagemaker_203_.bstage).append(Messages.getString("StageMaker.424")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.425")).toString(); //$NON-NLS-1$
					}
					if (m.loadnew)
						m.loadnew = false;
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.426"))) { //$NON-NLS-1$
					int i_204_ = getint(Messages.getString("StageMaker.427"), string_186_, 0); //$NON-NLS-1$
					i_204_ -= 10;
					int i_205_ = m.ground - bco[i_204_].grat;
					if (i_204_ == 54)
						i_205_ = getint(Messages.getString("StageMaker.428"), string_186_, 4); //$NON-NLS-1$
					co[nob] = new ContO(bco[i_204_], getint(Messages.getString("StageMaker.429"), string_186_, 1), i_205_, //$NON-NLS-1$
							getint(Messages.getString("StageMaker.430"), string_186_, 2), getint(Messages.getString("StageMaker.431"), string_186_, 3)); //$NON-NLS-1$ //$NON-NLS-2$
					co[nob].roofat = getint(Messages.getString("StageMaker.432"), string_186_, 3); //$NON-NLS-1$
					co[nob].colok = i_204_;
					cp.x[cp.n] = getint(Messages.getString("StageMaker.433"), string_186_, 1); //$NON-NLS-1$
					cp.z[cp.n] = getint(Messages.getString("StageMaker.434"), string_186_, 2); //$NON-NLS-1$
					cp.y[cp.n] = i_205_;
					if (getint(Messages.getString("StageMaker.435"), string_186_, 3) == 0) //$NON-NLS-1$
						cp.typ[cp.n] = 1;
					else
						cp.typ[cp.n] = 2;
					cp.pcs = cp.n;
					cp.n++;
					co[nob].checkpoint = cp.nsp + 1;
					if (string_186_.indexOf(Messages.getString("StageMaker.436")) != -1) //$NON-NLS-1$
						co[nob].wh = cp.nsp + 1;
					cp.nsp++;
					xnob++;
					nob++;
					if (i == 3) {
						if (bool_185_) {
							final StringBuilder stringbuilder = new StringBuilder();
							final StageMaker stagemaker_206_ = this;
							stagemaker_206_.bstage = stringbuilder.append(stagemaker_206_.bstage).append(Messages.getString("StageMaker.437")) //$NON-NLS-1$
									.toString();
							bool_185_ = false;
						}
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_207_ = this;
						stagemaker_207_.bstage = stringbuilder.append(stagemaker_207_.bstage).append(Messages.getString("StageMaker.438")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.439")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.440"))) { //$NON-NLS-1$
					int i_208_ = getint(Messages.getString("StageMaker.441"), string_186_, 0); //$NON-NLS-1$
					i_208_ -= 10;
					co[nob] = new ContO(bco[i_208_], getint(Messages.getString("StageMaker.442"), string_186_, 1), getint(Messages.getString("StageMaker.443"), string_186_, 3), //$NON-NLS-1$ //$NON-NLS-2$
							getint(Messages.getString("StageMaker.444"), string_186_, 2), getint(Messages.getString("StageMaker.445"), string_186_, 4)); //$NON-NLS-1$ //$NON-NLS-2$
					co[nob].roofat = getint(Messages.getString("StageMaker.446"), string_186_, 4); //$NON-NLS-1$
					co[nob].colok = i_208_;
					cp.fx[cp.fn] = getint(Messages.getString("StageMaker.447"), string_186_, 1); //$NON-NLS-1$
					cp.fz[cp.fn] = getint(Messages.getString("StageMaker.448"), string_186_, 2); //$NON-NLS-1$
					cp.fy[cp.fn] = getint(Messages.getString("StageMaker.449"), string_186_, 3); //$NON-NLS-1$
					co[nob].elec = true;
					if (getint(Messages.getString("StageMaker.450"), string_186_, 4) != 0) { //$NON-NLS-1$
						cp.roted[cp.fn] = true;
						co[nob].roted = true;
					} else
						cp.roted[cp.fn] = false;
					if (string_186_.indexOf(Messages.getString("StageMaker.451")) != -1) //$NON-NLS-1$
						cp.special[cp.fn] = true;
					else
						cp.special[cp.fn] = false;
					cp.fn++;
					xnob++;
					nob++;
					if (i == 3) {
						if (bool_185_) {
							final StringBuilder stringbuilder = new StringBuilder();
							final StageMaker stagemaker_209_ = this;
							stagemaker_209_.bstage = stringbuilder.append(stagemaker_209_.bstage).append(Messages.getString("StageMaker.452")) //$NON-NLS-1$
									.toString();
							bool_185_ = false;
						}
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_210_ = this;
						stagemaker_210_.bstage = stringbuilder.append(stagemaker_210_.bstage).append(Messages.getString("StageMaker.453")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.454")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.455"))) { //$NON-NLS-1$
					co[nob] = new ContO(getint(Messages.getString("StageMaker.456"), string_186_, 0), getint(Messages.getString("StageMaker.457"), string_186_, 1), //$NON-NLS-1$ //$NON-NLS-2$
							getint(Messages.getString("StageMaker.458"), string_186_, 2), m, t, getint(Messages.getString("StageMaker.459"), string_186_, 3), //$NON-NLS-1$ //$NON-NLS-2$
							getint(Messages.getString("StageMaker.460"), string_186_, 4), m.ground); //$NON-NLS-1$
					co[nob].srz = getint(Messages.getString("StageMaker.461"), string_186_, 0); //$NON-NLS-1$
					co[nob].srx = getint(Messages.getString("StageMaker.462"), string_186_, 1); //$NON-NLS-1$
					co[nob].sry = getint(Messages.getString("StageMaker.463"), string_186_, 2); //$NON-NLS-1$
					co[nob].colok = 66;
					xnob++;
					nob++;
					if (i == 3) {
						if (bool_185_) {
							final StringBuilder stringbuilder = new StringBuilder();
							final StageMaker stagemaker_211_ = this;
							stagemaker_211_.bstage = stringbuilder.append(stagemaker_211_.bstage).append(Messages.getString("StageMaker.464")) //$NON-NLS-1$
									.toString();
							bool_185_ = false;
						}
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_212_ = this;
						stagemaker_212_.bstage = stringbuilder.append(stagemaker_212_.bstage).append(Messages.getString("StageMaker.465")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.466")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.467"))) { //$NON-NLS-1$
					final int i_213_ = getint(Messages.getString("StageMaker.468"), string_186_, 0); //$NON-NLS-1$
					final int i_214_ = getint(Messages.getString("StageMaker.469"), string_186_, 1); //$NON-NLS-1$
					i_181_ = i_214_;
					final int i_215_ = getint(Messages.getString("StageMaker.470"), string_186_, 2); //$NON-NLS-1$
					for (int i_216_ = 0; i_216_ < i_213_; i_216_++) {
						co[nob] = new ContO(bco[29], i_214_, m.ground - bco[29].grat, i_216_ * 4800 + i_215_, 0);
						if (i == 0)
							xnob++;
						else
							nob++;
					}
					if (i == 3) {
						if (bool) {
							final StringBuilder stringbuilder = new StringBuilder();
							final StageMaker stagemaker_217_ = this;
							stagemaker_217_.bstage = stringbuilder.append(stagemaker_217_.bstage).append(Messages.getString("StageMaker.471")) //$NON-NLS-1$
									.toString();
							bool = false;
						}
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_218_ = this;
						stagemaker_218_.bstage = stringbuilder.append(stagemaker_218_.bstage).append(Messages.getString("StageMaker.472")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.473")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.474"))) { //$NON-NLS-1$
					final int i_219_ = getint(Messages.getString("StageMaker.475"), string_186_, 0); //$NON-NLS-1$
					final int i_220_ = getint(Messages.getString("StageMaker.476"), string_186_, 1); //$NON-NLS-1$
					i_182_ = i_220_;
					final int i_221_ = getint(Messages.getString("StageMaker.477"), string_186_, 2); //$NON-NLS-1$
					for (int i_222_ = 0; i_222_ < i_219_; i_222_++) {
						co[nob] = new ContO(bco[29], i_220_, m.ground - bco[29].grat, i_222_ * 4800 + i_221_, 180);
						if (i == 0)
							xnob++;
						else
							nob++;
					}
					if (i == 3) {
						if (bool) {
							final StringBuilder stringbuilder = new StringBuilder();
							final StageMaker stagemaker_223_ = this;
							stagemaker_223_.bstage = stringbuilder.append(stagemaker_223_.bstage).append(Messages.getString("StageMaker.478")) //$NON-NLS-1$
									.toString();
							bool = false;
						}
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_224_ = this;
						stagemaker_224_.bstage = stringbuilder.append(stagemaker_224_.bstage).append(Messages.getString("StageMaker.479")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.480")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.481"))) { //$NON-NLS-1$
					final int i_225_ = getint(Messages.getString("StageMaker.482"), string_186_, 0); //$NON-NLS-1$
					final int i_226_ = getint(Messages.getString("StageMaker.483"), string_186_, 1); //$NON-NLS-1$
					i_183_ = i_226_;
					final int i_227_ = getint(Messages.getString("StageMaker.484"), string_186_, 2); //$NON-NLS-1$
					for (int i_228_ = 0; i_228_ < i_225_; i_228_++) {
						co[nob] = new ContO(bco[29], i_228_ * 4800 + i_227_, m.ground - bco[29].grat, i_226_, 90);
						if (i == 0)
							xnob++;
						else
							nob++;
					}
					if (i == 3) {
						if (bool) {
							final StringBuilder stringbuilder = new StringBuilder();
							final StageMaker stagemaker_229_ = this;
							stagemaker_229_.bstage = stringbuilder.append(stagemaker_229_.bstage).append(Messages.getString("StageMaker.485")) //$NON-NLS-1$
									.toString();
							bool = false;
						}
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_230_ = this;
						stagemaker_230_.bstage = stringbuilder.append(stagemaker_230_.bstage).append(Messages.getString("StageMaker.486")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.487")).toString(); //$NON-NLS-1$
					}
				}
				if (string_186_.startsWith(Messages.getString("StageMaker.488"))) { //$NON-NLS-1$
					final int i_231_ = getint(Messages.getString("StageMaker.489"), string_186_, 0); //$NON-NLS-1$
					final int i_232_ = getint(Messages.getString("StageMaker.490"), string_186_, 1); //$NON-NLS-1$
					i_184_ = i_232_;
					final int i_233_ = getint(Messages.getString("StageMaker.491"), string_186_, 2); //$NON-NLS-1$
					for (int i_234_ = 0; i_234_ < i_231_; i_234_++) {
						co[nob] = new ContO(bco[29], i_234_ * 4800 + i_233_, m.ground - bco[29].grat, i_232_, -90);
						if (i == 0)
							xnob++;
						else
							nob++;
					}
					if (i == 3) {
						if (bool) {
							final StringBuilder stringbuilder = new StringBuilder();
							final StageMaker stagemaker_235_ = this;
							stagemaker_235_.bstage = stringbuilder.append(stagemaker_235_.bstage).append(Messages.getString("StageMaker.492")) //$NON-NLS-1$
									.toString();
							bool = false;
						}
						final StringBuilder stringbuilder = new StringBuilder();
						final StageMaker stagemaker_236_ = this;
						stagemaker_236_.bstage = stringbuilder.append(stagemaker_236_.bstage).append(Messages.getString("StageMaker.493")) //$NON-NLS-1$
								.append(string_186_).append(Messages.getString("StageMaker.494")).toString(); //$NON-NLS-1$
					}
				}
			}
			datainputstream.close();
			m.newpolys(i_182_, i_181_ - i_182_, i_184_, i_183_ - i_184_, t, nob);
			m.newclouds(i_182_, i_181_, i_184_, i_183_);
			m.newmountains(i_182_, i_181_, i_184_, i_183_);
			m.newstars();
		} catch (final Exception exception) {
			System.out.println(new StringBuilder().append(Messages.getString("StageMaker.495")).append(stagename).toString()); //$NON-NLS-1$
			System.out.println(new StringBuilder().append(Messages.getString("StageMaker.496")).append(exception).toString()); //$NON-NLS-1$
			System.out.println(new StringBuilder().append(Messages.getString("StageMaker.497")).append(string_186_).toString()); //$NON-NLS-1$
			errd = 6;
			if (cp.fn >= 5) // file name size????
				errd = 5;
			if (t.nt >= 670000) // trackers limit
				errd = 1;
			if (cp.n >= 10000) // )p etc limit
				errd = 2;
			if (nob >= 10000) // part limit
				errd = 4;
		}
		if (m.nrw * m.ncl >= 16000)
			errd = 3;
		if (xnob >= 10000)
			errd = 4;
		if (i == 3 && bstage.indexOf(Messages.getString("StageMaker.498")) == -1 && bstage.indexOf(Messages.getString("StageMaker.499")) == -1) { //$NON-NLS-1$ //$NON-NLS-2$
			final StringBuilder stringbuilder = new StringBuilder();
			final StageMaker stagemaker_237_ = this;
			stagemaker_237_.bstage = stringbuilder.append(stagemaker_237_.bstage).append(Messages.getString("StageMaker.500")) //$NON-NLS-1$
					.toString();
		}
	}

	public void removesp() {
		if (nundo < 5000) {
			undos[nundo] = bstage;
			nundo++;
		}
		String string = Messages.getString("StageMaker.501"); //$NON-NLS-1$
		if (co[esp].colok != 30 && co[esp].colok != 31 && co[esp].colok != 32 && co[esp].colok != 66)
			string = new StringBuilder().append(Messages.getString("StageMaker.502")).append(co[esp].colok + 10).append(Messages.getString("StageMaker.503")).append(co[esp].x) //$NON-NLS-1$ //$NON-NLS-2$
					.append(Messages.getString("StageMaker.504")).append(co[esp].z).append(Messages.getString("StageMaker.505")).append(co[esp].roofat).append(Messages.getString("StageMaker.506")).toString(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (co[esp].colok == 31)
			string = new StringBuilder().append(Messages.getString("StageMaker.507")).append(co[esp].colok + 10).append(Messages.getString("StageMaker.508")).append(co[esp].x) //$NON-NLS-1$ //$NON-NLS-2$
					.append(Messages.getString("StageMaker.509")).append(co[esp].z).append(Messages.getString("StageMaker.510")).append(co[esp].y).append(Messages.getString("StageMaker.511")).append(co[esp].roofat) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.append(Messages.getString("StageMaker.512")).toString(); //$NON-NLS-1$
		if (co[esp].colok == 30 || co[esp].colok == 32)
			string = new StringBuilder().append(Messages.getString("StageMaker.513")).append(co[esp].colok + 10).append(Messages.getString("StageMaker.514")).append(co[esp].x) //$NON-NLS-1$ //$NON-NLS-2$
					.append(Messages.getString("StageMaker.515")).append(co[esp].z).append(Messages.getString("StageMaker.516")).append(co[esp].roofat).append(Messages.getString("StageMaker.517")).toString(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		if (co[esp].colok == 54)
			string = new StringBuilder().append(Messages.getString("StageMaker.518")).append(co[esp].colok + 10).append(Messages.getString("StageMaker.519")).append(co[esp].x) //$NON-NLS-1$ //$NON-NLS-2$
					.append(Messages.getString("StageMaker.520")).append(co[esp].z).append(Messages.getString("StageMaker.521")).append(co[esp].roofat).append(Messages.getString("StageMaker.522")).append(co[esp].y) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.append(Messages.getString("StageMaker.523")).toString(); //$NON-NLS-1$
		if (co[esp].colok == 66)
			string = new StringBuilder().append(Messages.getString("StageMaker.524")).append(co[esp].srz).append(Messages.getString("StageMaker.525")).append(co[esp].srx).append(Messages.getString("StageMaker.526")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.append(co[esp].sry).append(Messages.getString("StageMaker.527")).append(co[esp].x).append(Messages.getString("StageMaker.528")).append(co[esp].z).append(Messages.getString("StageMaker.529")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.toString();
		final int i = bstage.indexOf(string);
		int i_166_ = i + string.length();
		int i_167_ = -1;
		int i_168_ = bstage.indexOf(Messages.getString("StageMaker.530"), i_166_); //$NON-NLS-1$
		if (i_168_ != -1)
			i_167_ = i_168_;
		i_168_ = bstage.indexOf(Messages.getString("StageMaker.531"), i_166_); //$NON-NLS-1$
		if (i_168_ != -1 && i_168_ < i_167_)
			i_167_ = i_168_;
		i_168_ = bstage.indexOf(Messages.getString("StageMaker.532"), i_166_); //$NON-NLS-1$
		if (i_168_ != -1 && i_168_ < i_167_)
			i_167_ = i_168_;
		if (i_167_ == -1) {
			i_167_ = bstage.indexOf(Messages.getString("StageMaker.533"), i_166_); //$NON-NLS-1$
			if (i_167_ != -1)
				i_167_++;
		}
		if (i_167_ != -1)
			i_166_ = i_167_;
		if (i != -1)
			bstage = new StringBuilder().append(Messages.getString("StageMaker.534")).append(bstage.substring(0, i)).append(Messages.getString("StageMaker.535")) //$NON-NLS-1$ //$NON-NLS-2$
					.append(bstage.substring(i_166_, bstage.length())).append(Messages.getString("StageMaker.536")).toString(); //$NON-NLS-1$
		readstage(0);
	}

	public void renstage(final String string) {
		if (string.equals(Messages.getString("StageMaker.537"))) //$NON-NLS-1$
			JOptionPane.showMessageDialog(null, Messages.getString("StageMaker.538"), Messages.getString("StageMaker.539"), 1); //$NON-NLS-1$ //$NON-NLS-2$
		else
			try {
				final File file = new File(
						new StringBuilder().append(Messages.getString("StageMaker.540")).append(stagename).append(Messages.getString("StageMaker.541")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				final File file_329_ = new File(
						new StringBuilder().append(Messages.getString("StageMaker.542")).append(string).append(Messages.getString("StageMaker.543")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				if (file.renameTo(file_329_)) {
					stagename = string;
					sfase = 0;
					hidefields();
					tabed = -2;
				} else
					JOptionPane.showMessageDialog(null,
							new StringBuilder().append(Messages.getString("StageMaker.544")).append(string) //$NON-NLS-1$
									.append(Messages.getString("StageMaker.545")).toString(), //$NON-NLS-1$
							Messages.getString("StageMaker.546"), 1); //$NON-NLS-1$
			} catch (final Exception exception) {
				JOptionPane.showMessageDialog(null, new StringBuilder()
						.append(Messages.getString("StageMaker.547")).append(exception).toString(), Messages.getString("StageMaker.548"), //$NON-NLS-1$ //$NON-NLS-2$
						1);
			}
	}

	public void rot(final int[] is, final int[] is_334_, final int i, final int i_335_, final int i_336_,
			final int i_337_) {
		if (i_336_ != 0)
			for (int i_338_ = 0; i_338_ < i_337_; i_338_++) {
				final int i_339_ = is[i_338_];
				final int i_340_ = is_334_[i_338_];
				is[i_338_] = i + (int) ((i_339_ - i) * m.cos(i_336_) - (i_340_ - i_335_) * m.sin(i_336_));
				is_334_[i_338_] = i_335_ + (int) ((i_339_ - i) * m.sin(i_336_) + (i_340_ - i_335_) * m.cos(i_336_));
			}
	}

	@Override
	public void run() {
		thredo.setPriority(10);
		btgame[0] = getImage(Messages.getString("StageMaker.549")); //$NON-NLS-1$
		btgame[1] = getImage(Messages.getString("StageMaker.550")); //$NON-NLS-1$
		logo = getImage(Messages.getString("StageMaker.551")); //$NON-NLS-1$
		for (int i = 0; i < 2; i++) {
			su[i] = getImage(new StringBuilder().append(Messages.getString("StageMaker.552")).append(i + 1).append(Messages.getString("StageMaker.553")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			sl[i] = getImage(new StringBuilder().append(Messages.getString("StageMaker.554")).append(i + 1).append(Messages.getString("StageMaker.555")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			sd[i] = getImage(new StringBuilder().append(Messages.getString("StageMaker.556")).append(i + 1).append(Messages.getString("StageMaker.557")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			sr[i] = getImage(new StringBuilder().append(Messages.getString("StageMaker.558")).append(i + 1).append(Messages.getString("StageMaker.559")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			zi[i] = getImage(new StringBuilder().append(Messages.getString("StageMaker.560")).append(i + 1).append(Messages.getString("StageMaker.561")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			zo[i] = getImage(new StringBuilder().append(Messages.getString("StageMaker.562")).append(i + 1).append(Messages.getString("StageMaker.563")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
		}
		loadbase();
		loadsettings();
		if (Madness.testdrive != 0) {
			if (Madness.testcar.equals(Messages.getString("StageMaker.564"))) { //$NON-NLS-1$
				JOptionPane.showMessageDialog(null,
						Messages.getString("StageMaker.565"), //$NON-NLS-1$
						Messages.getString("StageMaker.566"), 1); //$NON-NLS-1$
				thredo.stop();
			} else {
				stagename = Madness.testcar;
				errd = 0;
				readstage(3);
				if (errd == 0) {
					tab = 2;
					dtab = 6;
					witho.select(Madness.testdrive - 3);
				}
			}
			Madness.testcar = Messages.getString("StageMaker.567"); //$NON-NLS-1$
			Madness.testdrive = 0;
		}
		requestFocus();
		while (!exwist) {
			rd.setColor(new Color(225, 225, 225));
			rd.fillRect(0, 25, 800, 525);
			rd.setColor(new Color(0, 0, 0));
			if (tab != tabed)
				hidefields();
			if (tab == 0) {
				if (tabed != tab) {
					slstage.removeAll();
					slstage.maxl = 360;
					slstage.add(rd, Messages.getString("StageMaker.568")); //$NON-NLS-1$
					final String[] strings = new File(Messages.getString("StageMaker.569")).list(); //$NON-NLS-1$
					if (strings != null)
						for (int i = 0; i < strings.length; i++)
							if (strings[i].toLowerCase().endsWith(Messages.getString("StageMaker.570"))) //$NON-NLS-1$
								slstage.add(rd, strings[i].substring(0, strings[i].length() - 4));
					if (stagename.equals(Messages.getString("StageMaker.571"))) //$NON-NLS-1$
						slstage.select(0);
					else {
						slstage.select(stagename);
						if (stagename.equals(slstage.getSelectedItem())) {
							readstage(3);
							sx = 0;
							sz = 1500;
							sy = -10000;
						} else {
							stagename = Messages.getString("StageMaker.572"); //$NON-NLS-1$
							slstage.select(0);
						}
					}
					mouseon = -1;
					sfase = 0;
				}
				rd.drawImage(logo, 261, 35, null);
				if (xm > 261 && xm < 538 && ym > 35 && ym < 121) {
					if (mouseon == -1) {
						mouseon = 3;
						setCursor(new Cursor(12));
					}
				} else if (mouseon == 3) {
					mouseon = -1;
					setCursor(new Cursor(0));
				}
				if (mouseon == 3 && mouses == -1)
					openhlink();
				rd.setFont(new Font(Messages.getString("StageMaker.573"), 1, 13)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				if (xm > 200 && xm < 550 && ym > 467 && ym < 504) {
					if (mouseon == -1) {
						mouseon = 2;
						setCursor(new Cursor(12));
					}
				} else if (mouseon == 2) {
					mouseon = -1;
					setCursor(new Cursor(0));
				}
				if (mouseon == 2)
					rd.setColor(new Color(0, 64, 128));
				else
					rd.setColor(new Color(0, 0, 0));
				rd.drawString(Messages.getString("StageMaker.574"), //$NON-NLS-1$
						400 - ftm.stringWidth(Messages.getString("StageMaker.575")) / 2, //$NON-NLS-1$
						480);
				rd.setColor(new Color(0, 128, 255));
				String string = Messages.getString("StageMaker.576"); //$NON-NLS-1$
				rd.drawString(string, 400 - ftm.stringWidth(string) / 2, 500);
				if (mouseon == 2)
					rd.setColor(new Color(0, 128, 255));
				else
					rd.setColor(new Color(0, 64, 128));
				rd.drawLine(400 - ftm.stringWidth(string) / 2, 501, 400 + ftm.stringWidth(string) / 2, 501);
				if (mouseon == 2 && mouses == -1)
					openhlink();
				final int i = -110;
				if (xm > 150 && xm < 600 && ym > 467 + i && ym < 504 + i) {
					if (mouseon == -1) {
						mouseon = 1;
						setCursor(new Cursor(12));
					}
				} else if (mouseon == 1) {
					mouseon = -1;
					setCursor(new Cursor(0));
				}
				if (mouseon == 1)
					rd.setColor(new Color(0, 64, 128));
				else
					rd.setColor(new Color(0, 0, 0));
				rd.drawString(Messages.getString("StageMaker.577"), //$NON-NLS-1$
						400 - ftm.stringWidth(
								Messages.getString("StageMaker.578")) / 2, //$NON-NLS-1$
						480 + i);
				rd.setColor(new Color(0, 128, 255));
				string = Messages.getString("StageMaker.579"); //$NON-NLS-1$
				rd.drawString(string, 400 - ftm.stringWidth(string) / 2, 500 + i);
				if (mouseon == 1)
					rd.setColor(new Color(0, 128, 255));
				else
					rd.setColor(new Color(0, 64, 128));
				rd.drawLine(400 - ftm.stringWidth(string) / 2, 501 + i, 400 + ftm.stringWidth(string) / 2, 501 + i);
				if (mouseon == 1 && mouses == -1)
					openlink();
				final int i_0_ = -60;
				final int i_1_ = 70;
				rd.setColor(new Color(0, 0, 0));
				rd.drawRect(227 - i_1_, 194 + i_0_, 346 + i_1_ * 2, 167 + i_1_ / 5);
				if (sfase == 0) {
					rd.drawString(Messages.getString("StageMaker.580"), 400 - ftm.stringWidth(Messages.getString("StageMaker.581")) / 2, //$NON-NLS-1$ //$NON-NLS-2$
							230 + i_0_);
					slstage.move(220, 240 + i_0_);
					if (slstage.getWidth() != 360)
						slstage.setSize(360, 21);
					if (!slstage.isShowing())
						slstage.setVisible(true);
					if (button(Messages.getString("StageMaker.582"), 400, 296 + i_0_, 0, true)) { //$NON-NLS-1$
						srch.setText(Messages.getString("StageMaker.583")); //$NON-NLS-1$
						slstage.setVisible(false);
						sfase = 1;
					}
					if (button(Messages.getString("StageMaker.584"), 325, 336 + i_0_, 0, false)) //$NON-NLS-1$
						if (!stagename.equals(Messages.getString("StageMaker.585"))) { //$NON-NLS-1$
							slstage.setVisible(false);
							srch.setText(stagename);
							sfase = 2;
						} else
							JOptionPane.showMessageDialog(null, Messages.getString("StageMaker.586"), Messages.getString("StageMaker.587"), //$NON-NLS-1$ //$NON-NLS-2$
									1);
					if (button(Messages.getString("StageMaker.588"), 475, 336 + i_0_, 0, false)) //$NON-NLS-1$
						if (!stagename.equals(Messages.getString("StageMaker.589"))) { //$NON-NLS-1$
							if (JOptionPane.showConfirmDialog(null,
									new StringBuilder()
											.append(Messages.getString("StageMaker.590")) //$NON-NLS-1$
											.append(stagename).append(Messages.getString("StageMaker.591")).toString(), //$NON-NLS-1$
									Messages.getString("StageMaker.592"), 0) == 0) //$NON-NLS-1$
								delstage(stagename);
						} else
							JOptionPane.showMessageDialog(null, Messages.getString("StageMaker.593"), Messages.getString("StageMaker.594"), //$NON-NLS-1$ //$NON-NLS-2$
									1);
					if (slstage.getSelectedIndex() != 0) {
						if (!stagename.equals(slstage.getSelectedItem())) {
							stagename = slstage.getSelectedItem();
							readstage(3);
							sx = 0;
							sz = 1500;
							sy = -10000;
							requestFocus();
						}
					} else
						stagename = Messages.getString("StageMaker.595"); //$NON-NLS-1$
				}
				if (sfase == 1) {
					rd.drawString(Messages.getString("StageMaker.596"), 400 - ftm.stringWidth(Messages.getString("StageMaker.597")) / 2, 220 + i_0_); //$NON-NLS-1$ //$NON-NLS-2$
					rd.setFont(new Font(Messages.getString("StageMaker.598"), 1, 12)); //$NON-NLS-1$
					rd.drawString(Messages.getString("StageMaker.599"), 200, 246 + i_0_); //$NON-NLS-1$
					movefield(srch, 310, 231 + i_0_, 290, 23);
					if (!srch.isShowing()) {
						srch.setVisible(true);
						srch.requestFocus();
					}
					fixtext(srch);
					rd.drawString(Messages.getString("StageMaker.600"), 293, 272 + i_0_); //$NON-NLS-1$
					strtyp.move(408, 256 + i_0_);
					if (!strtyp.isShowing())
						strtyp.setVisible(true);
					if (button(Messages.getString("StageMaker.601"), 400, 311 + i_0_, 0, true)) //$NON-NLS-1$
						newstage();
					if (button(Messages.getString("StageMaker.602"), 400, 351 + i_0_, 0, false)) { //$NON-NLS-1$
						strtyp.setVisible(false);
						srch.setVisible(false);
						sfase = 0;
					}
				}
				if (sfase == 2) {
					rd.drawString(
							new StringBuilder().append(Messages.getString("StageMaker.603")).append(stagename).append(Messages.getString("StageMaker.604")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
							400 - ftm.stringWidth(new StringBuilder().append(Messages.getString("StageMaker.605")).append(stagename) //$NON-NLS-1$
									.append(Messages.getString("StageMaker.606")).toString()) / 2, //$NON-NLS-1$
							230 + i_0_);
					rd.setFont(new Font(Messages.getString("StageMaker.607"), 1, 12)); //$NON-NLS-1$
					rd.drawString(Messages.getString("StageMaker.608"), 218, 266 + i_0_); //$NON-NLS-1$
					if (!srch.isShowing()) {
						srch.setVisible(true);
						srch.requestFocus();
					}
					movefield(srch, 292, 251 + i_0_, 290, 23);
					fixtext(srch);
					if (button(Messages.getString("StageMaker.609"), 400, 306 + i_0_, 0, true)) //$NON-NLS-1$
						renstage(srch.getText());
					if (button(Messages.getString("StageMaker.610"), 400, 346 + i_0_, 0, false)) { //$NON-NLS-1$
						srch.setVisible(false);
						sfase = 0;
					}
				}
			}
			if (tab == 1) {
				if (tabed != tab) {
					m.trk = 2;
					readstage(0);
					if (sptyp == 0)
						partroads();
					if (sptyp == 1)
						partramps();
					if (sptyp == 2)
						partobst();
					if (sptyp == 5)
						partrees();
					onoff = false;
					setCursor(new Cursor(0));
					setcur = false;
					epart = false;
					arrng = false;
					if (nob == 1) {
						sptyp = 0;
						if (co[0].colok == 38)
							spart = 9;
						else
							spart = 0;
					}
					mouseon = -1;
				}
				if (sptyp == 0) {
					if (spart == 0)
						sp = 0;
					if (spart == 1)
						sp = 4;
					if (spart == 2)
						sp = 13;
					if (spart == 3)
						sp = 3;
					if (spart == 4)
						sp = 2;
					if (spart == 5)
						sp = 1;
					if (spart == 6)
						sp = 35;
					if (spart == 7)
						sp = 36;
					if (spart == 8)
						sp = 10;
					if (spart == 9)
						sp = 5;
					if (spart == 10)
						sp = 7;
					if (spart == 11)
						sp = 14;
					if (spart == 12)
						sp = 6;
					if (spart == 13)
						sp = 34;
					if (spart == 14)
						sp = 33;
					if (spart == 15)
						sp = 11;
					if (spart == 16)
						sp = 8;
					if (spart == 17)
						sp = 9;
					if (spart == 18)
						sp = 15;
					if (spart == 19)
						sp = 12;
					if (spart == 20)
						sp = 46;
					if (spart == 21)
						sp = 47;
					if (spart == 22)
						sp = 50;
					if (spart == 23)
						sp = 48;
					if (spart == 24)
						sp = 49;
					if (spart == 25)
						sp = 51;
				}
				if (sptyp == 1) {
					if (spart == 0)
						sp = 16;
					if (spart == 1)
						sp = 18;
					if (spart == 2)
						sp = 19;
					if (spart == 3)
						sp = 22;
					if (spart == 4)
						sp = 17;
					if (spart == 5)
						sp = 21;
					if (spart == 6)
						sp = 20;
					if (spart == 7)
						sp = 39;
					if (spart == 8)
						sp = 42;
					if (spart == 9)
						sp = 40;
					if (spart == 10)
						sp = 23;
					if (spart == 11)
						sp = 25;
					if (spart == 12)
						sp = 24;
					if (spart == 13)
						sp = 43;
					if (spart == 14)
						sp = 45;
					if (spart == 15)
						sp = 26;
				}
				if (sptyp == 2) {
					if (spart == 0)
						sp = 27;
					if (spart == 1)
						sp = 28;
					if (spart == 2)
						sp = 41;
					if (spart == 3)
						sp = 44;
					if (spart == 4)
						sp = 52;
					if (spart == 5)
						sp = 53;
				}
				if (sptyp == 3)
					if (onfly)
						sp = 54;
					else if (!onoff)
						sp = 30;
					else
						sp = 32;
				if (sptyp == 4)
					sp = 31;
				if (sptyp == 5) {
					if (spart == 0)
						sp = 55;
					if (spart == 1)
						sp = 56;
					if (spart == 2)
						sp = 57;
					if (spart == 3)
						sp = 58;
					if (spart == 4)
						sp = 59;
					if (spart == 5)
						sp = 60;
					if (spart == 6)
						sp = 61;
					if (spart == 7)
						sp = 62;
					if (spart == 8)
						sp = 63;
					if (spart == 9)
						sp = 64;
					if (spart == 10)
						sp = 65;
				}
				if (sptyp == 6) {
					if (!pgen) {
						int i = (int) (10000.0 * Math.random());
						if (fgen != 0) {
							i = fgen;
							fgen = 0;
						}
						bco[66] = new ContO(i, (int) pwd, (int) phd, m, t, 0, 0, 0);
						bco[66].srz = i;
						bco[66].srx = (int) pwd;
						bco[66].sry = (int) phd;
						pgen = true;
						seq = 3;
					}
					sp = 66;
					rot = 0;
				} else if (pgen) {
					pgen = false;
					pwd = 2L + Math.round(Math.random() * 4.0);
					phd = 2L + Math.round(Math.random() * 4.0);
				}
				if (sp == 30 || sp == 31 || sp == 32 || sp == 54) {
					if (rot == -90)
						rot = 90;
					if (rot == 180)
						rot = 0;
				}
				adrot = 0;
				if (sp == 2)
					adrot = -30;
				if (sp == 3)
					adrot = 30;
				if (sp == 15)
					adrot = 90;
				if (sp == 20)
					adrot = 180;
				if (sp == 26)
					adrot = 90;
				rd.setColor(new Color(200, 200, 200));
				rd.fillRect(248, 63, 514, 454);
				m.trk = 2;
				m.zy = 90;
				m.xz = 0;
				m.iw = 248;
				m.w = 762;
				m.ih = 63;
				m.h = 517;
				m.cx = 505;
				m.cy = 290;
				m.x = sx - m.cx;
				m.z = sz - m.cz;
				m.y = sy;
				int i = 0;
				final int[] is = new int[10000]; // stageselect limit
				for (int i_2_ = 0; i_2_ < nob; i_2_++)
					if (co[i_2_].dist != 0) {
						is[i] = i_2_;
						i++;
					} else
						co[i_2_].d(rd);
				final int[] is_3_ = new int[i];
				for (int i_4_ = 0; i_4_ < i; i_4_++)
					is_3_[i_4_] = 0;
				for (int i_5_ = 0; i_5_ < i; i_5_++)
					for (int i_6_ = i_5_ + 1; i_6_ < i; i_6_++)
						if (co[is[i_5_]].dist != co[is[i_6_]].dist) {
							if (co[is[i_5_]].dist < co[is[i_6_]].dist)
								is_3_[i_5_]++;
							else
								is_3_[i_6_]++;
						} else if (i_6_ > i_5_)
							is_3_[i_5_]++;
						else
							is_3_[i_6_]++;
				for (int i_7_ = 0; i_7_ < i; i_7_++)
					for (int i_8_ = 0; i_8_ < i; i_8_++)
						if (is_3_[i_8_] == i_7_) {
							if (is[i_8_] == hi)
								m.trk = 3;
							if (is[i_8_] == chi && !co[is[i_8_]].errd) {
								final int i_9_ = m.cx + (int) ((co[is[i_8_]].x - m.x - m.cx) * m.cos(m.xz)
										- (co[is[i_8_]].z - m.z - m.cz) * m.sin(m.xz));
								final int i_10_ = m.cz + (int) ((co[is[i_8_]].x - m.x - m.cx) * m.sin(m.xz)
										+ (co[is[i_8_]].z - m.z - m.cz) * m.cos(m.xz));
								final int i_11_ = m.cy + (int) ((co[is[i_8_]].y - m.y - m.cy) * m.cos(m.zy)
										- (i_10_ - m.cz) * m.sin(m.zy));
								final int i_12_ = m.cz + (int) ((co[is[i_8_]].y - m.y - m.cy) * m.sin(m.zy)
										+ (i_10_ - m.cz) * m.cos(m.zy));
								final int i_13_ = 1000000 / Math.abs(sy);
								final Graphics2D graphics2d = rd;
								graphics2d.setComposite(AlphaComposite.getInstance(3, 0.7F));
								rd.setColor(new Color(0, 164, 255));
								rd.fillOval(xs(i_9_, i_12_) - i_13_ / 2, ys(i_11_, i_12_) - i_13_ / 2, i_13_, i_13_);
								graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
								rd.setColor(new Color(0, 0, 0));
								rd.setFont(new Font(Messages.getString("StageMaker.611"), 1, 12)); //$NON-NLS-1$
								ftm = rd.getFontMetrics();
								rd.drawString(
										new StringBuilder().append(Messages.getString("StageMaker.612")).append(arrcnt + 1).append(Messages.getString("StageMaker.613")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
										xs(i_9_, i_12_) - ftm.stringWidth(new StringBuilder().append(Messages.getString("StageMaker.614")) //$NON-NLS-1$
												.append(arrcnt + 1).append(Messages.getString("StageMaker.615")).toString()) / 2, //$NON-NLS-1$
										ys(i_11_, i_12_) - i_13_ / 2);
							}
							if (arrng && (co[is[i_8_]].colok == 30 || co[is[i_8_]].colok == 32
									|| co[is[i_8_]].colok == 54) && co[is[i_8_]].errd) {
								final int i_14_ = m.cx + (int) ((co[is[i_8_]].x - m.x - m.cx) * m.cos(m.xz)
										- (co[is[i_8_]].z - m.z - m.cz) * m.sin(m.xz));
								final int i_15_ = m.cz + (int) ((co[is[i_8_]].x - m.x - m.cx) * m.sin(m.xz)
										+ (co[is[i_8_]].z - m.z - m.cz) * m.cos(m.xz));
								final int i_16_ = m.cy + (int) ((co[is[i_8_]].y - m.y - m.cy) * m.cos(m.zy)
										- (i_15_ - m.cz) * m.sin(m.zy));
								final int i_17_ = m.cz + (int) ((co[is[i_8_]].y - m.y - m.cy) * m.sin(m.zy)
										+ (i_15_ - m.cz) * m.cos(m.zy));
								final int i_18_ = 1000000 / Math.abs(sy);
								final Graphics2D graphics2d = rd;
								graphics2d.setComposite(AlphaComposite.getInstance(3, 0.5F));
								rd.setColor(new Color(255, 128, 0));
								rd.fillOval(xs(i_14_, i_17_) - i_18_ / 2, ys(i_16_, i_17_) - i_18_ / 2, i_18_, i_18_);
								graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
								rd.setColor(new Color(0, 0, 0));
								rd.setFont(new Font(Messages.getString("StageMaker.616"), 1, 12)); //$NON-NLS-1$
								ftm = rd.getFontMetrics();
								rd.drawString(
										new StringBuilder().append(Messages.getString("StageMaker.617")).append(co[is[i_8_]].wh).append(Messages.getString("StageMaker.618")) //$NON-NLS-1$ //$NON-NLS-2$
												.toString(),
										xs(i_14_, i_17_) - ftm.stringWidth(new StringBuilder().append(Messages.getString("StageMaker.619")) //$NON-NLS-1$
												.append(co[is[i_8_]].wh).append(Messages.getString("StageMaker.620")).toString()) / 2, //$NON-NLS-1$
										ys(i_16_, i_17_) - i_18_ / 2);
							}
							co[is[i_8_]].d(rd);
							if (m.trk == 3)
								m.trk = 2;
						}
				if (xm > 248 && xm < 762 && ym > 63 && ym < 517) {
					if (!epart && !arrng) {
						bco[sp].x = (xm - 505) * (Math.abs(sy) / m.focus_point) + sx;
						bco[sp].z = (290 - ym) * (Math.abs(sy) / m.focus_point) + sz;
						bco[sp].y = m.ground - bco[sp].grat;
						bco[sp].xz = rot + adrot;
						int i_19_ = 200;
						int i_20_ = 0;
						int i_21_ = 0;
						final int[] is_22_ = { bco[sp].x + atp[sp][0], bco[sp].x + atp[sp][2] };
						final int[] is_23_ = { bco[sp].z + atp[sp][1], bco[sp].z + atp[sp][3] };
						rot(is_22_, is_23_, bco[sp].x, bco[sp].z, rot, 2);
						int i_24_ = 0;
						onfly = false;
						int i_25_ = 500;
						for (int i_26_ = 0; i_26_ < nob; i_26_++) {
							final int[] is_27_ = { co[i_26_].x + atp[co[i_26_].colok][0],
									co[i_26_].x + atp[co[i_26_].colok][2] };
							final int[] is_28_ = { co[i_26_].z + atp[co[i_26_].colok][1],
									co[i_26_].z + atp[co[i_26_].colok][3] };
							int i_29_ = co[i_26_].roofat;
							if (co[i_26_].colok == 2)
								i_29_ += 30;
							if (co[i_26_].colok == 3)
								i_29_ -= 30;
							if (co[i_26_].colok == 15)
								i_29_ -= 90;
							if (co[i_26_].colok == 20)
								i_29_ -= 180;
							if (co[i_26_].colok == 26)
								i_29_ -= 90;
							rot(is_27_, is_28_, co[i_26_].x, co[i_26_].z, i_29_, 2);
							if (sp <= 54) {
								int i_30_ = py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]);
								if (i_30_ < i_19_ && i_30_ != 0) {
									i_19_ = i_30_;
									i_20_ = is_27_[0] - is_22_[0];
									i_21_ = is_28_[0] - is_23_[0];
								}
								i_30_ = py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]);
								if (i_30_ < i_19_ && i_30_ != 0) {
									i_19_ = i_30_;
									i_20_ = is_27_[1] - is_22_[0];
									i_21_ = is_28_[1] - is_23_[0];
								}
								i_30_ = py(is_27_[1], is_22_[1], is_28_[1], is_23_[1]);
								if (i_30_ < i_19_ && i_30_ != 0) {
									i_19_ = i_30_;
									i_20_ = is_27_[1] - is_22_[1];
									i_21_ = is_28_[1] - is_23_[1];
								}
								i_30_ = py(is_27_[0], is_22_[1], is_28_[0], is_23_[1]);
								if (i_30_ < i_19_ && i_30_ != 0) {
									i_19_ = i_30_;
									i_20_ = is_27_[0] - is_22_[1];
									i_21_ = is_28_[0] - is_23_[1];
								}
							}
							if (sptyp == 3 && py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) != 0
									&& py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) != 0) {
								for (int i_31_ = 0; i_31_ < rcheckp.length; i_31_++)
									if (co[i_26_].colok == rcheckp[i_31_]) {
										if (py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) <= i_24_ || i_24_ == 0) {
											i_24_ = py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]);
											onoff = false;
										}
										if (py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) <= i_24_) {
											i_24_ = py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]);
											onoff = false;
										}
									}
								for (int i_32_ = 0; i_32_ < ocheckp.length; i_32_++)
									if (co[i_26_].colok == ocheckp[i_32_]) {
										if (py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) <= i_24_ || i_24_ == 0) {
											i_24_ = py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]);
											onoff = true;
										}
										if (py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) <= i_24_) {
											i_24_ = py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]);
											onoff = true;
										}
									}
							}
							if (sp > 12 && sp < 33 || sp == 35 || sp == 36 || sp >= 39 && sp <= 54) {
								if ((rot == 0 || rot == 180 || sp == 26 || sp == 15)
										&& (i_29_ == 0 || i_29_ == 180 || sp == 26 || sp == 15)) {
									if (Math.abs(is_27_[0] - is_22_[0]) < 200)
										i_20_ = is_27_[0] - is_22_[0];
									if (Math.abs(is_27_[0] - is_22_[1]) < 200)
										i_20_ = is_27_[0] - is_22_[1];
									if (Math.abs(is_27_[1] - is_22_[1]) < 200)
										i_20_ = is_27_[1] - is_22_[1];
									if (Math.abs(is_27_[1] - is_22_[0]) < 200)
										i_20_ = is_27_[1] - is_22_[0];
								}
								if ((rot == 90 || rot == -90 || sp == 26 || sp == 15)
										&& (i_29_ == 90 || i_29_ == -90 || sp == 26 || sp == 15)) {
									if (Math.abs(is_28_[0] - is_23_[0]) < 200)
										i_21_ = is_28_[0] - is_23_[0];
									if (Math.abs(is_28_[0] - is_23_[1]) < 200)
										i_21_ = is_28_[0] - is_23_[1];
									if (Math.abs(is_28_[1] - is_23_[1]) < 200)
										i_21_ = is_28_[1] - is_23_[1];
									if (Math.abs(is_28_[1] - is_23_[0]) < 200)
										i_21_ = is_28_[1] - is_23_[0];
								}
							}
							if (sptyp == 3 && co[i_26_].colok >= 46 && co[i_26_].colok <= 51) {
								final int[] is_33_ = { 2, 3, 5, 2, 3, 3 };
								if ((Math.abs(co[i_26_].roofat) == 180 || co[i_26_].roofat == 0) && rot == 0
										&& Math.abs(bco[sp].x - co[i_26_].x) < 500
										&& Math.abs(bco[sp].z - co[i_26_].z) < 3000)
									for (int i_34_ = 0; i_34_ < is_33_[co[i_26_].colok - 46]; i_34_++)
										for (int i_35_ = 0; i_35_ < co[i_26_].p[i_34_].n; i_35_++)
											if (py(bco[sp].x, co[i_26_].x, bco[sp].z,
													co[i_26_].z + co[i_26_].p[i_34_].oz[i_35_]) < i_25_) {
												i_25_ = py(bco[sp].x, co[i_26_].x, bco[sp].z,
														co[i_26_].z + co[i_26_].p[i_34_].oz[i_35_]);
												flyh = co[i_26_].p[i_34_].oy[i_35_] - 28 + m.ground;
												i_20_ = co[i_26_].x - bco[sp].x;
												i_21_ = co[i_26_].z + co[i_26_].p[i_34_].oz[i_35_] - bco[sp].z;
												onfly = true;
											}
								if (Math.abs(co[i_26_].roofat) == 90 && rot == 90
										&& Math.abs(bco[sp].z - co[i_26_].z) < 500
										&& Math.abs(bco[sp].x - co[i_26_].x) < 3000)
									for (int i_36_ = 0; i_36_ < is_33_[co[i_26_].colok - 46]; i_36_++)
										for (int i_37_ = 0; i_37_ < co[i_26_].p[i_36_].n; i_37_++)
											if (py(bco[sp].z, co[i_26_].z, bco[sp].x,
													co[i_26_].x + co[i_26_].p[i_36_].ox[i_37_]) < i_25_) {
												i_25_ = py(bco[sp].z, co[i_26_].z, bco[sp].x,
														co[i_26_].x + co[i_26_].p[i_36_].ox[i_37_]);
												flyh = co[i_26_].p[i_36_].oy[i_37_] - 28 + m.ground;
												i_21_ = co[i_26_].z - bco[sp].z;
												i_20_ = co[i_26_].x + co[i_26_].p[i_36_].ox[i_37_] - bco[sp].x;
												onfly = true;
											}
							}
						}
						bco[sp].x += i_20_;
						bco[sp].z += i_21_;
						final int i_38_ = bco[sp].xy;
						final int i_39_ = bco[sp].zy;
						if (sp == 31) {
							bco[sp].y = -hf;
							if (bco[sp].y > -500)
								bco[sp].y = -500;
						} else
							bco[sp].xy = 0;
						if (sp == 54)
							bco[sp].y = flyh;
						bco[sp].zy = 0;
						if (cntout == 0) {
							if (mouseon == -1) {
								bco[sp].d(rd);
								if (!setcur) {
									setCursor(new Cursor(13));
									setcur = true;
								}
								if (mouses == -1) {
									if (nundo < 5000) {
										undos[nundo] = bstage;
										nundo++;
									}
									if (bco[sp].xz == 270)
										bco[sp].xz = -90;
									if (bco[sp].xz == 360)
										bco[sp].xz = 0;
									errd = 0;
									boolean bool = false;
									if (xnob < 10000) {
										if (sp != 31 && sp != 54 && sp != 66)
											try {
												co[nob] = new ContO(bco[sp], bco[sp].x, m.ground - bco[sp].grat,
														bco[sp].z, bco[sp].xz);
												co[nob].roofat = bco[sp].xz;
												co[nob].colok = sp;
												nob++;
											} catch (final Exception exception) {
												errd = 1;
											}
										if (sp == 31)
											if (cp.fn < 5) {
												co[nob] = new ContO(bco[sp], bco[sp].x, bco[sp].y, bco[sp].z,
														bco[sp].xz);
												co[nob].roofat = bco[sp].xz;
												co[nob].colok = sp;
												nob++;
												fixh.setText(new StringBuilder().append(Messages.getString("StageMaker.621")).append(Math.abs(bco[sp].y)) //$NON-NLS-1$
														.append(Messages.getString("StageMaker.622")).toString()); //$NON-NLS-1$
											} else
												errd = 5;
										if (sp == 54)
											try {
												co[nob] = new ContO(bco[sp], bco[sp].x, bco[sp].y, bco[sp].z,
														bco[sp].xz);
												co[nob].roofat = bco[sp].xz;
												co[nob].colok = sp;
												nob++;
											} catch (final Exception exception) {
												errd = 1;
											}
										if (sp == 66) {
											co[nob] = new ContO(bco[66].srz, bco[66].srx, bco[66].sry, m, t, bco[66].x,
													bco[66].z, bco[sp].y);
											co[nob].srz = bco[66].srz;
											co[nob].srx = bco[66].srx;
											co[nob].sry = bco[66].sry;
											co[nob].colok = sp;
											nob++;
										}
									} else
										errd = 4;
									if (errd == 0) {
										sortstage();
										readstage(0);
										bool = true;
										if (sp == 66)
											pgen = false;
										if (sp == 52 || sp == 53 || sp >= 55 && sp <= 65) {
											seq = 3;
											bco[sp].xy = 0;
											bco[sp].zy = 0;
											boolean bool_40_ = false;
											if (rot == 0 && !bool_40_) {
												rot = 90;
												bool_40_ = true;
											}
											if (rot == 90 && !bool_40_) {
												rot = 180;
												bool_40_ = true;
											}
											if (rot == 180 && !bool_40_) {
												rot = -90;
												bool_40_ = true;
											}
											if (rot == -90 && !bool_40_) {
												rot = 0;
												bool_40_ = true;
											}
										}
									}
									if (errd != 0) {
										JOptionPane.showMessageDialog(null,
												new StringBuilder().append(Messages.getString("StageMaker.623")) //$NON-NLS-1$
														.append(errlo[errd - 1]).append(Messages.getString("StageMaker.624")).toString(), //$NON-NLS-1$
												Messages.getString("StageMaker.625"), 0); //$NON-NLS-1$
										if (bool) {
											nundo--;
											bstage = undos[nundo];
											readstage(0);
										}
									}
									lxm = bco[sp].x;
									lym = bco[sp].z;
									cntout = 10;
								}
							}
						} else {
							if (lxm != bco[sp].x && lxm != bco[sp].z)
								cntout--;
							if (setcur) {
								setCursor(new Cursor(0));
								setcur = false;
							}
						}
						bco[sp].xy = i_38_;
						bco[sp].zy = i_39_;
					} else {
						if (epart)
							if (esp == -1 && !overcan) {
								hi = -1;
								int i_41_ = 0;
								for (int i_42_ = 0; i_42_ < nob; i_42_++) {
									final int i_43_ = m.cx + (int) ((co[i_42_].x - m.x - m.cx) * m.cos(m.xz)
											- (co[i_42_].z - m.z - m.cz) * m.sin(m.xz));
									final int i_44_ = m.cz + (int) ((co[i_42_].x - m.x - m.cx) * m.sin(m.xz)
											+ (co[i_42_].z - m.z - m.cz) * m.cos(m.xz));
									final int i_45_ = m.cy + (int) ((co[i_42_].y - m.y - m.cy) * m.cos(m.zy)
											- (i_44_ - m.cz) * m.sin(m.zy));
									final int i_46_ = m.cz + (int) ((co[i_42_].y - m.y - m.cy) * m.sin(m.zy)
											+ (i_44_ - m.cz) * m.cos(m.zy));
									if (xm > xs(i_43_ - co[i_42_].maxR, i_46_) && xm < xs(i_43_ + co[i_42_].maxR, i_46_)
											&& ym > ys(i_45_ - co[i_42_].maxR, i_46_)
											&& ym < ys(i_45_ + co[i_42_].maxR, i_46_) && co[i_42_].colok != 37
											&& co[i_42_].colok != 38)
										if (hi == -1) {
											hi = i_42_;
											i_41_ = py(xm, xs(i_43_, i_46_), ym, ys(i_45_, i_46_));
										} else if (py(xm, xs(i_43_, i_46_), ym, ys(i_45_, i_46_)) <= i_41_) {
											hi = i_42_;
											i_41_ = py(xm, xs(i_43_, i_46_), ym, ys(i_45_, i_46_));
										}
								}
								if (hi != -1) {
									if (!setcur) {
										setCursor(new Cursor(13));
										setcur = true;
									}
									if (mouses == -1) {
										esp = hi;
										mouses = 0;
									}
								} else if (setcur) {
									setCursor(new Cursor(0));
									setcur = false;
								}
							} else if (setcur) {
								setCursor(new Cursor(0));
								setcur = false;
							}
						if (arrng) {
							chi = -1;
							int i_47_ = 5000;
							for (int i_48_ = 0; i_48_ < nob; i_48_++)
								if ((co[i_48_].colok == 30 || co[i_48_].colok == 32 || co[i_48_].colok == 54)
										&& !co[i_48_].errd) {
									final int i_49_ = m.cx + (int) ((co[i_48_].x - m.x - m.cx) * m.cos(m.xz)
											- (co[i_48_].z - m.z - m.cz) * m.sin(m.xz));
									final int i_50_ = m.cz + (int) ((co[i_48_].x - m.x - m.cx) * m.sin(m.xz)
											+ (co[i_48_].z - m.z - m.cz) * m.cos(m.xz));
									final int i_51_ = m.cy + (int) ((co[i_48_].y - m.y - m.cy) * m.cos(m.zy)
											- (i_50_ - m.cz) * m.sin(m.zy));
									final int i_52_ = m.cz + (int) ((co[i_48_].y - m.y - m.cy) * m.sin(m.zy)
											+ (i_50_ - m.cz) * m.cos(m.zy));
									if (xm > xs(i_49_ - co[i_48_].maxR, i_52_) && xm < xs(i_49_ + co[i_48_].maxR, i_52_)
											&& ym > ys(i_51_ - co[i_48_].maxR, i_52_)
											&& ym < ys(i_51_ + co[i_48_].maxR, i_52_)
											&& py(xm, xs(i_49_, i_52_), ym, ys(i_51_, i_52_)) <= i_47_) {
										chi = i_48_;
										i_47_ = py(xm, xs(i_49_, i_52_), ym, ys(i_51_, i_52_));
									}
								}
							if (chi != -1) {
								if (!setcur) {
									setCursor(new Cursor(13));
									setcur = true;
								}
								if (mouses == -1) {
									arrcnt++;
									co[chi].wh = arrcnt;
									co[chi].errd = true;
									mouses = 0;
								}
							} else if (setcur) {
								setCursor(new Cursor(0));
								setcur = false;
							}
						}
					}
				} else if (setcur) {
					setCursor(new Cursor(0));
					setcur = false;
				}
				if (epart && esp != -1)
					if (co[esp].dist != 0) {
						m.cx = 505;
						m.cy = 290;
						m.x = sx - m.cx;
						m.z = sz - m.cz;
						m.y = sy;
						final int i_53_ = m.cx + (int) ((co[esp].x - m.x - m.cx) * m.cos(m.xz)
								- (co[esp].z - m.z - m.cz) * m.sin(m.xz));
						final int i_54_ = m.cz + (int) ((co[esp].x - m.x - m.cx) * m.sin(m.xz)
								+ (co[esp].z - m.z - m.cz) * m.cos(m.xz));
						final int i_55_ = m.cy
								+ (int) ((co[esp].y - m.y - m.cy) * m.cos(m.zy) - (i_54_ - m.cz) * m.sin(m.zy));
						final int i_56_ = m.cz
								+ (int) ((co[esp].y - m.y - m.cy) * m.sin(m.zy) + (i_54_ - m.cz) * m.cos(m.zy));
						final int i_57_ = xs(i_53_, i_56_);
						final int i_58_ = ys(i_55_, i_56_);
						rd.setColor(new Color(225, 225, 225));
						rd.fillRect(i_57_, i_58_, 90, 88);
						rd.setColor(new Color(138, 147, 160));
						rd.drawRect(i_57_, i_58_, 90, 88);
						if (button(Messages.getString("StageMaker.626"), i_57_ + 45, i_58_ + 22, 3, false)) { //$NON-NLS-1$
							copyesp(true);
							removesp();
							lxm = 0;
							lym = 0;
							cntout = 2;
							epart = false;
						}
						if (button(Messages.getString("StageMaker.627"), i_57_ + 45, i_58_ + 49, 3, false)) { //$NON-NLS-1$
							removesp();
							esp = -1;
							mouses = 0;
						}
						if (button(Messages.getString("StageMaker.628"), i_57_ + 45, i_58_ + 76, 3, false)) { //$NON-NLS-1$
							copyesp(false);
							lxm = 0;
							lym = 0;
							cntout = 2;
							epart = false;
						}
						rd.setColor(new Color(255, 0, 0));
						rd.drawString(Messages.getString("StageMaker.629"), i_57_ + 82, i_58_ - 2); //$NON-NLS-1$
						if (xm > 248 && xm < 762 && ym > 63 && ym < 517 && mouses == 1
								&& (xm < i_57_ || xm > i_57_ + 90 || ym < i_58_ || ym > i_58_ + 88)) {
							esp = -1;
							mouses = 0;
						}
					} else
						esp = -1;
				rd.setColor(new Color(225, 225, 225));
				rd.fillRect(248, 25, 514, 38);
				rd.fillRect(0, 25, 248, 530);
				rd.fillRect(248, 517, 514, 38);
				rd.fillRect(762, 25, 38, 530);
				if (sptyp == 6) {
					rd.setColor(new Color(0, 0, 0));
					rd.setFont(new Font(Messages.getString("StageMaker.630"), 1, 12)); //$NON-NLS-1$
					rd.drawString(Messages.getString("StageMaker.631"), 11, 97); //$NON-NLS-1$
					rd.drawString(Messages.getString("StageMaker.632"), 14, 117); //$NON-NLS-1$
					boolean bool = false;
					if (xm > 57 && xm < 204 && ym > 90 && ym < 99)
						bool = true;
					rd.setColor(new Color(136, 148, 170));
					if (bool || mouseon == 1) {
						rd.drawRect(57, 90, 147, 8);
						rd.setColor(new Color(0, 0, 0));
					}
					rd.drawLine(57, 94, 204, 94);
					if (mouseon == 1) {
						pwd = (xm - 57) / 36.75F + 2.0F;
						if (pwd < 2.0F)
							pwd = 2.0F;
						if (pwd > 6.0F)
							pwd = 6.0F;
					}
					rd.drawRect((int) (57.0F + (pwd - 2.0F) * 36.75F), 90, 2, 8);
					boolean bool_59_ = false;
					if (xm > 57 && xm < 204 && ym > 110 && ym < 119)
						bool_59_ = true;
					rd.setColor(new Color(136, 148, 170));
					if (bool_59_ || mouseon == 2) {
						rd.drawRect(57, 110, 147, 8);
						rd.setColor(new Color(0, 0, 0));
					}
					rd.drawLine(57, 114, 204, 114);
					if (mouseon == 2) {
						phd = (xm - 57) / 36.75F + 2.0F;
						if (phd < 2.0F)
							phd = 2.0F;
						if (phd > 6.0F)
							phd = 6.0F;
					}
					rd.drawRect((int) (57.0F + (phd - 2.0F) * 36.75F), 110, 2, 8);
					if (mouses == 1) {
						if (bool)
							mouseon = 1;
						if (bool_59_)
							mouseon = 2;
					} else {
						if (mouseon == 1 || mouseon == 2)
							pgen = false;
						mouseon = -1;
					}
				}
				int i_60_ = 0;
				if (xm > 482 && xm < 529 && ym > 35 && ym < 61 || up) {
					i_60_ = 1;
					if (mouses == 1 || up)
						sz += 500;
				}
				rd.drawImage(su[i_60_], 482, 35, null);
				i_60_ = 0;
				if (xm > 482 && xm < 529 && ym > 519 && ym < 545 || down) {
					i_60_ = 1;
					if (mouses == 1 || down)
						sz -= 500;
				}
				rd.drawImage(sd[i_60_], 482, 519, null);
				i_60_ = 0;
				if (xm > 220 && xm < 246 && ym > 264 && ym < 311 || left) {
					i_60_ = 1;
					if (mouses == 1 || left)
						sx -= 500;
				}
				rd.drawImage(sl[i_60_], 220, 264, null);
				i_60_ = 0;
				if (xm > 764 && xm < 790 && ym > 264 && ym < 311 || right) {
					i_60_ = 1;
					if (mouses == 1 || right)
						sx += 500;
				}
				rd.drawImage(sr[i_60_], 764, 264, null);
				i_60_ = 0;
				if (xm > 616 && xm < 677 && ym > 30 && ym < 61 || zoomi) {
					i_60_ = 1;
					if (mouses == 1 || zoomi) {
						sy += 500;
						if (sy > -2500)
							sy = -2500;
					}
				}
				rd.drawImage(zi[i_60_], 616, 30, null);
				i_60_ = 0;
				if (xm > 690 && xm < 751 && ym > 30 && ym < 61 || zoomo) {
					i_60_ = 1;
					if (mouses == 1 || zoomo) {
						sy -= 500;
						if (sy < -55000)
							sy = -55000;
					}
				}
				rd.drawImage(zo[i_60_], 690, 30, null);
				if ((epart || arrng) && sy < -36000)
					sy = -36000;
				rd.setFont(new Font(Messages.getString("StageMaker.633"), 1, 11)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				rd.setColor(new Color(0, 0, 0));
				rd.drawString(Messages.getString("StageMaker.634"), 11, 47); //$NON-NLS-1$
				rd.setFont(new Font(Messages.getString("StageMaker.635"), 1, 13)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				ptyp.move(10, 50);
				if (!ptyp.isShowing()) {
					ptyp.setVisible(true);
					ptyp.select(sptyp);
				}
				if (sptyp != ptyp.getSelectedIndex()) {
					sptyp = ptyp.getSelectedIndex();
					if (sptyp == 0) {
						partroads();
						part.setVisible(true);
					}
					if (sptyp == 1) {
						partramps();
						part.setVisible(true);
					}
					if (sptyp == 2) {
						partobst();
						part.setVisible(true);
					}
					if (sptyp == 5) {
						partrees();
						part.setVisible(true);
					}
					spart = 0;
					part.select(spart);
					requestFocus();
					fixh.setText(Messages.getString("StageMaker.636")); //$NON-NLS-1$
					focuson = false;
				}
				part.move(10, 80);
				part.setSize(200, 21);
				if (sptyp == 0 || sptyp == 1 || sptyp == 2 || sptyp == 5) {
					if (!part.isShowing()) {
						part.setVisible(true);
						part.select(spart);
					}
				} else if (part.isShowing())
					part.setVisible(false);
				if (spart != part.getSelectedIndex()) {
					spart = part.getSelectedIndex();
					focuson = false;
				}
				if (sptyp == 3)
					rd.drawString(Messages.getString("StageMaker.637"), 110 - ftm.stringWidth(Messages.getString("StageMaker.638")) / 2, 120); //$NON-NLS-1$ //$NON-NLS-2$
				if (sptyp == 4)
					rd.drawString(Messages.getString("StageMaker.639"), 110 - ftm.stringWidth(Messages.getString("StageMaker.640")) / 2, 120); //$NON-NLS-1$ //$NON-NLS-2$
				if (lsp != sp) {
					seq = 3;
					bco[sp].xy = 0;
					bco[sp].zy = 0;
					lsp = sp;
					epart = false;
					arrng = false;
				}
				if (xm > 10 && xm < 210 && ym > 130 && ym < 334) {
					if (seq >= 3)
						if (seq == 20 || !seqn) {
							seq = 0;
							bco[sp].xy = 0;
							bco[sp].zy = 0;
						} else
							seq++;
					seqn = true;
					rd.setColor(new Color(210, 210, 210));
				} else {
					rd.setColor(new Color(200, 200, 200));
					seqn = false;
				}
				rd.fillRect(10, 130, 200, 200);
				if ((sp == 30 || sp == 32 || sp == 54) && button(Messages.getString("StageMaker.641"), 110, 315, 2, true)) { //$NON-NLS-1$
					mouses = 0;
					epart = false;
					if (!arrng) {
						arrcnt = 0;
						for (int i_61_ = 0; i_61_ < nob; i_61_++)
							if (co[i_61_].colok == 30 || co[i_61_].colok == 32 || co[i_61_].colok == 54)
								co[i_61_].errd = false;
						arrng = true;
					} else
						arrng = false;
				}
				if (seqn && mouses == -1)
					if (sp != 66) {
						boolean bool = false;
						if (rot == 0 && !bool) {
							rot = 90;
							bool = true;
						}
						if (rot == 90 && !bool) {
							rot = 180;
							bool = true;
						}
						if (rot == 180 && !bool) {
							rot = -90;
							bool = true;
						}
						if (rot == -90 && !bool) {
							rot = 0;
							bool = true;
						}
						if (sp == 30 || sp == 31 || sp == 32) {
							if (rot == -90)
								rot = 90;
							if (rot == 180)
								rot = 0;
						}
						seq = 5;
						bco[sp].xy = 0;
						bco[sp].zy = 0;
						epart = false;
						arrng = false;
					} else {
						pgen = false;
						pwd = 2L + Math.round(Math.random() * 4.0);
						phd = 2L + Math.round(Math.random() * 4.0);
					}
				if (sp == 31) {
					rd.setFont(new Font(Messages.getString("StageMaker.642"), 1, 12)); //$NON-NLS-1$
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.643"), 62, 280); //$NON-NLS-1$
					movefield(fixh, 107, 266, 50, 20);
					if (fixh.hasFocus())
						focuson = false;
					if (!fixh.isShowing())
						fixh.setVisible(true);
					rd.setFont(new Font(Messages.getString("StageMaker.644"), 0, 11)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("StageMaker.645"), //$NON-NLS-1$
							110 - ftm.stringWidth(Messages.getString("StageMaker.646")) / 2, 300); //$NON-NLS-1$
					if (fixh.getText().equals(Messages.getString("StageMaker.647"))) { //$NON-NLS-1$
						fixh.setText(Messages.getString("StageMaker.648")); //$NON-NLS-1$
						fixh.select(0, 0);
					}
					try {
						hf = Integer.valueOf(fixh.getText()).intValue();
						if (hf > 8000) {
							hf = 8000;
							fixh.setText(Messages.getString("StageMaker.649")); //$NON-NLS-1$
						}
					} catch (final Exception exception) {
						hf = 2000;
						fixh.setText(Messages.getString("StageMaker.650")); //$NON-NLS-1$
					}
				} else if (fixh.isShowing())
					fixh.setVisible(false);
				m.trk = 2;
				m.zy = 90;
				m.xz = 0;
				m.iw = 10;
				m.w = 210;
				m.ih = 130;
				m.h = 330;
				m.cx = 110;
				m.cy = 230;
				m.x = -110;
				m.z = -230;
				m.y = -15000;
				if (sptyp == 1 && sp != 20 && sp != 21 && sp != 43 && sp != 45)
					m.y = -10000;
				if (sptyp == 2 && sp != 41)
					m.y = -7600;
				if (sptyp == 3 || sptyp == 4)
					m.y = -5000;
				if (sptyp == 5) {
					m.y = -3000;
					m.z = 150;
				}
				if (sptyp == 6)
					m.y = -7600;
				if (sp == 31) {
					m.z = -500;
					if (rot != 0)
						bco[sp].roted = true;
					else
						bco[sp].roted = false;
				}
				bco[sp].x = 0;
				bco[sp].y = 0;
				bco[sp].z = 0;
				bco[sp].xz = rot + adrot;
				bco[sp].d(rd);
				int i_62_ = 1;
				if (sptyp == 0 || sptyp == 1) {
					if (sp != 26 && sp != 20) {
						if (rot == -90 || rot == 0)
							i_62_ = -1;
					} else {
						if (sp == 26 && (rot == -90 || rot == 180))
							i_62_ = -1;
						if (sp == 20 && (rot == 90 || rot == 180))
							i_62_ = -1;
					}
					if (seq == 2) {
						bco[sp].xy -= 5 * i_62_;
						if (bco[sp].xy == 0)
							seq = 3;
					}
					if (seq == 1)
						seq = 2;
					if (seq == 0) {
						bco[sp].xy += 5 * i_62_;
						if (bco[sp].xy == 85 * i_62_)
							seq = 1;
					}
				}
				if (sptyp == 2 || sptyp == 3 || sptyp == 4 || sptyp == 6) {
					if (rot == -90 || rot == 180)
						i_62_ = -1;
					if (seq == 2) {
						bco[sp].zy += 5 * i_62_;
						if (bco[sp].zy == 0)
							seq = 3;
					}
					if (seq == 1)
						seq = 2;
					if (seq == 0) {
						bco[sp].zy -= 5 * i_62_;
						if (bco[sp].zy == -(85 * i_62_))
							seq = 1;
					}
				}
				if (sptyp == 5) {
					if (rot == -90 || rot == 180)
						i_62_ = -1;
					boolean bool = false;
					if (rot == -90 || rot == 90)
						bool = true;
					if (!bool)
						bco[sp].xy = 0;
					else
						bco[sp].zy = 0;
					if (seq == 2)
						if (!bool) {
							bco[sp].zy += 5 * i_62_;
							if (bco[sp].zy == 0)
								seq = 3;
						} else {
							bco[sp].xy -= 5 * i_62_;
							if (bco[sp].xy == 0)
								seq = 3;
						}
					if (seq == 1)
						seq = 2;
					if (seq == 0)
						if (!bool) {
							bco[sp].zy -= 5 * i_62_;
							if (bco[sp].zy == -(85 * i_62_))
								seq = 1;
						} else {
							bco[sp].xy += 5 * i_62_;
							if (bco[sp].xy == 85 * i_62_)
								seq = 1;
						}
				}
				if (sp != 66) {
					if (button(Messages.getString("StageMaker.651"), 110, 348, 3, true)) { //$NON-NLS-1$
						boolean bool = false;
						if (rot == 0 && !bool) {
							rot = 90;
							bool = true;
						}
						if (rot == 90 && !bool) {
							rot = 180;
							bool = true;
						}
						if (rot == 180 && !bool) {
							rot = -90;
							bool = true;
						}
						if (rot == -90 && !bool) {
							rot = 0;
							bool = true;
						}
						if (sp == 30 || sp == 31 || sp == 32) {
							if (rot == -90)
								rot = 90;
							if (rot == 180)
								rot = 0;
						}
						seq = 3;
						bco[sp].xy = 0;
						bco[sp].zy = 0;
						epart = false;
						arrng = false;
					}
				} else if (button(Messages.getString("StageMaker.652"), 110, 348, 3, true)) { //$NON-NLS-1$
					pgen = false;
					pwd = 2L + Math.round(Math.random() * 4.0);
					phd = 2L + Math.round(Math.random() * 4.0);
				}
				if (button(Messages.getString("StageMaker.653"), 191, 348, 3, true) && (sptyp == 0 || sptyp == 1 || sptyp == 2 || sptyp == 5)) { //$NON-NLS-1$
					spart++;
					if (spart == part.getItemCount())
						spart = 0;
					part.select(spart);
					epart = false;
					arrng = false;
				}
				if (button(Messages.getString("StageMaker.654"), 28, 348, 3, true) && (sptyp == 0 || sptyp == 1 || sptyp == 2 || sptyp == 5)) { //$NON-NLS-1$
					spart--;
					if (spart == -1)
						spart = part.getItemCount() - 1;
					part.select(spart);
					epart = false;
					arrng = false;
				}
				if (button(Messages.getString("StageMaker.655"), 204, 404, 0, true)) { //$NON-NLS-1$
					epart = false;
					arrng = false;
					if (nundo > 0) {
						nundo--;
						bstage = undos[nundo];
						readstage(0);
					}
				}
				if (button(Messages.getString("StageMaker.656"), 172, 454, 0, true)) { //$NON-NLS-1$
					if (!epart)
						epart = true;
					else
						epart = false;
					arrng = false;
					esp = -1;
				}
				if (button(Messages.getString("StageMaker.657"), 175, 504, 0, true)) { //$NON-NLS-1$
					sx = 0;
					sz = 1500;
				}
				if (button(Messages.getString("StageMaker.658"), 164, 66, 3, false)) //$NON-NLS-1$
					JOptionPane.showMessageDialog(null, discp[sp], Messages.getString("StageMaker.659"), 1); //$NON-NLS-1$
				if (button(Messages.getString("StageMaker.660"), 691, 536, 3, false)) //$NON-NLS-1$
					JOptionPane.showMessageDialog(null,
							Messages.getString("StageMaker.661"), //$NON-NLS-1$
							Messages.getString("StageMaker.662"), 1); //$NON-NLS-1$
				if (button(Messages.getString("StageMaker.663"), 280, 50, 0, false)) { //$NON-NLS-1$
					epart = false;
					arrng = false;
					savefile();
				}
				if (button(Messages.getString("StageMaker.664"), 380, 50, 0, false)) { //$NON-NLS-1$
					epart = false;
					arrng = false;
					savefile();
					hidefields();
					tab = 2;
				}
				rd.setFont(new Font(Messages.getString("StageMaker.665"), 1, 12)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				rd.setColor(new Color(0, 0, 0));
				int i_63_ = 0;
				final int i_64_ = (int) (xnob / 10000.0F * 200.0F); // limits
				int i_65_ = i_64_;
				final int i_66_ = (int) (t.nt / 670000.0F * 200.0F); // limits
				if (i_66_ > i_65_) {
					i_65_ = i_66_;
					i_63_ = 1;
				}
				final int i_67_ = (int) (cp.n / 10000.0F * 200.0F); // limits
				if (i_67_ > i_65_) {
					i_65_ = i_67_;
					i_63_ = 2;
				}
				final int i_68_ = (int) (m.nrw * m.ncl / 9999999.0F * 200.0F); // medium
																				// limit...does
																				// it
																				// exist?
				if (i_68_ > i_65_) {
					i_65_ = i_68_;
					i_63_ = 3;
				}
				if (i_65_ > 200) // may be a limit
					i_65_ = 200;
				if (i_65_ <= 100)
					rd.setColor(new Color(100 + i_65_, 225, 30));
				else
					rd.setColor(new Color(200, 325 - i_65_, 30));
				rd.fillRect(167, 531, i_65_, 9);
				if (button(Messages.getString("StageMaker.666"), 85, 540, 3, false)) //$NON-NLS-1$
					JOptionPane.showMessageDialog(null,
							new StringBuilder().append(Messages.getString("StageMaker.667")) //$NON-NLS-1$
									.append(i_64_ / 2).append(Messages.getString("StageMaker.668")).append(i_66_ / 2) //$NON-NLS-1$
									.append(Messages.getString("StageMaker.669")).append(i_67_ / 2).append(Messages.getString("StageMaker.670")) //$NON-NLS-1$ //$NON-NLS-2$
									.append(i_68_ / 2).append(Messages.getString("StageMaker.671")).toString(), //$NON-NLS-1$
							Messages.getString("StageMaker.672"), 1); //$NON-NLS-1$
				rd.setColor(new Color(0, 0, 0));
				rd.drawRect(167, 531, 200, 9);
				final String[] strings = { Messages.getString("StageMaker.673"), Messages.getString("StageMaker.674"), Messages.getString("StageMaker.675"), Messages.getString("StageMaker.676") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				rd.drawString(strings[i_63_], 267 - ftm.stringWidth(strings[i_63_]) / 2, 540);
				rd.drawString(new StringBuilder().append(Messages.getString("StageMaker.677")).append(i_65_ / 2).append(Messages.getString("StageMaker.678")).toString(), 375, 540); //$NON-NLS-1$ //$NON-NLS-2$
				if (overcan)
					overcan = false;
				if (epart) {
					if (esp == -1) {
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(Messages.getString("StageMaker.679"), 257, 454); //$NON-NLS-1$
						if (button(Messages.getString("StageMaker.680"), 323, 474, 4, false)) //$NON-NLS-1$
							epart = false;
					}
				} else {
					if (hi != -1)
						hi = -1;
					if (esp != -1)
						esp = -1;
				}
				if (arrng) {
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(new StringBuilder().append(Messages.getString("StageMaker.681")).append(arrcnt + 1) //$NON-NLS-1$
							.append(Messages.getString("StageMaker.682")).toString(), 257, 80); //$NON-NLS-1$
					if (button(Messages.getString("StageMaker.683"), 330, 100, 4, false)) //$NON-NLS-1$
						arrng = false;
					if (arrcnt == cp.nsp) {
						sortstage();
						JOptionPane.showMessageDialog(null,
								Messages.getString("StageMaker.684"), //$NON-NLS-1$
								Messages.getString("StageMaker.685"), 1); //$NON-NLS-1$
						arrng = false;
					}
				} else if (chi != -1)
					chi = -1;
			}
			if (tab == 2) {
				if (tabed != tab) {
					m.trk = 0;
					readstage(1);
					setCursor(new Cursor(0));
					setcur = false;
					vxz = 0;
					vx = sx - 400;
					vz = sz - m.cz - 8000;
					vy = -1500;
					dtabed = -1;
				}
				m.trk = 0;
				m.zy = 6;
				m.iw = 10;
				m.w = 790;
				m.ih = 35;
				m.h = 445;
				m.cx = 400;
				m.cy = 215;
				m.xz = vxz;
				m.x = vx;
				m.z = vz;
				m.y = vy;
				m.d(rd);
				int i = 0;
				final int[] is = new int[10000]; // stageselect limit
				for (int i_69_ = 0; i_69_ < nob; i_69_++)
					if (co[i_69_].dist != 0) {
						is[i] = i_69_;
						i++;
					} else
						co[i_69_].d(rd);
				final int[] is_70_ = new int[i];
				for (int i_71_ = 0; i_71_ < i; i_71_++)
					is_70_[i_71_] = 0;
				for (int i_72_ = 0; i_72_ < i; i_72_++)
					for (int i_73_ = i_72_ + 1; i_73_ < i; i_73_++)
						if (co[is[i_72_]].dist != co[is[i_73_]].dist) {
							if (co[is[i_72_]].dist < co[is[i_73_]].dist)
								is_70_[i_72_]++;
							else
								is_70_[i_73_]++;
						} else if (i_73_ > i_72_)
							is_70_[i_72_]++;
						else
							is_70_[i_73_]++;
				for (int i_74_ = 0; i_74_ < i; i_74_++)
					for (int i_75_ = 0; i_75_ < i; i_75_++)
						if (is_70_[i_75_] == i_74_) {
							if (is[i_75_] == hi)
								m.trk = 3;
							co[is[i_75_]].d(rd);
							if (m.trk == 3)
								m.trk = 2;
						}
				if (up) {
					vz += 500.0F * m.cos(m.xz);
					vx += 500.0F * m.sin(m.xz);
				}
				if (down) {
					vz -= 500.0F * m.cos(m.xz);
					vx -= 500.0F * m.sin(m.xz);
				}
				if (left)
					vxz -= 5;
				if (right)
					vxz += 5;
				if (zoomi) {
					vy += 100;
					if (vy > -500)
						vy = -500;
				}
				if (zoomo) {
					vy -= 100;
					if (vy < -5000)
						vy = -5000;
				}
				rd.setColor(new Color(225, 225, 225));
				rd.fillRect(0, 25, 10, 525);
				rd.fillRect(790, 25, 10, 525);
				rd.fillRect(10, 25, 780, 10);
				rd.fillRect(10, 445, 780, 105);
				rd.setFont(new Font(Messages.getString("StageMaker.686"), 1, 12)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				final String[] strings = { Messages.getString("StageMaker.687"), Messages.getString("StageMaker.688"), Messages.getString("StageMaker.689"), Messages.getString("StageMaker.690"), Messages.getString("StageMaker.691"), Messages.getString("StageMaker.692"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
						Messages.getString("StageMaker.693") }; //$NON-NLS-1$
				final int[] is_76_ = { 10, 10, 121, 111 };
				final int[] is_77_ = { 425, 445, 445, 425 };
				for (int i_78_ = 0; i_78_ < 7; i_78_++) {
					rd.setColor(new Color(170, 170, 170));
					if (xm > is_76_[0] && xm < is_76_[3] && ym > 425 && ym < 445)
						rd.setColor(new Color(190, 190, 190));
					if (dtab == i_78_)
						rd.setColor(new Color(225, 225, 225));
					rd.fillPolygon(is_76_, is_77_, 4);
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(strings[i_78_], i_78_ * 111 + 62 - ftm.stringWidth(strings[i_78_]) / 2, 439);
					if (xm > is_76_[0] && xm < is_76_[3] && ym > 425 && ym < 445 && mouses == -1 && mouseon == -1)
						dtab = i_78_;
					for (int i_79_ = 0; i_79_ < 4; i_79_++)
						is_76_[i_79_] += 111;
				}
				if (tabed == tab && dtab != dtabed) {
					if (!ttstage.equals(Messages.getString("StageMaker.694"))) { //$NON-NLS-1$
						tstage = ttstage;
						ttstage = Messages.getString("StageMaker.695"); //$NON-NLS-1$
					}
					readstage(1);
					hidefields();
				}
				if (dtab == 0) {
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.696"), 20, 470); //$NON-NLS-1$
					rd.drawString(
							Messages.getString("StageMaker.697"), //$NON-NLS-1$
							20, 490);
					rd.drawString(
							Messages.getString("StageMaker.698"), //$NON-NLS-1$
							20, 520);
				}
				if (dtab == 2) {
					if (dtabed != dtab) {
						Color.RGBtoHSB(csky[0], csky[1], csky[2], hsb[0]);
						Color.RGBtoHSB(cfade[0], cfade[1], cfade[2], hsb[1]);
						Color.RGBtoHSB(cgrnd[0], cgrnd[1], cgrnd[2], hsb[2]);
						for (int i_80_ = 0; i_80_ < 3; i_80_++) {
							final float f = hsb[i_80_][1];
							hsb[i_80_][1] = hsb[i_80_][2];
							hsb[i_80_][2] = f;
						}
						if (hsb[1][1] == (hsb[0][1] + hsb[2][1]) / 2.0F && hsb[1][0] == hsb[2][0]
								&& hsb[1][2] == hsb[2][2])
							pfog.setState(true);
						else
							pfog.setState(false);
						ttstage = Messages.getString("StageMaker.699"); //$NON-NLS-1$
						mouseon = -1;
					}
					if (mouses != 1) {
						if ((mouseon >= 6 || mouseon < 3) && mouseon != -1) {
							if (ttstage.equals(Messages.getString("StageMaker.700"))) //$NON-NLS-1$
								ttstage = tstage;
							sortop();
							readstage(1);
						}
						mouseon = -1;
					}
					final String[] strings_81_ = { Messages.getString("StageMaker.701"), Messages.getString("StageMaker.702"), Messages.getString("StageMaker.703") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					for (int i_82_ = 0; i_82_ < 3; i_82_++) {
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(strings_81_[i_82_], 107 + 195 * i_82_ - ftm.stringWidth(strings_81_[i_82_]) / 2,
								461);
						for (int i_83_ = 0; i_83_ < 150; i_83_++) {
							rd.setColor(Color.getHSBColor((float) (i_83_ * 0.006667), 1.0F, 1.0F));
							rd.drawLine(32 + i_83_ + 195 * i_82_, 467, 32 + i_83_ + 195 * i_82_, 474);
						}
						for (int i_84_ = 0; i_84_ < 150; i_84_++) {
							rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.5F + i_84_ * 0.00333F));
							rd.drawLine(32 + i_84_ + 195 * i_82_, 483, 32 + i_84_ + 195 * i_82_, 490);
						}
						for (int i_85_ = 0; i_85_ < 150; i_85_++) {
							rd.setColor(
									Color.getHSBColor(hsb[i_82_][0], 0.0F + (float) (i_85_ * 0.001667), hsb[i_82_][1]));
							rd.drawLine(32 + i_85_ + 195 * i_82_, 499, 32 + i_85_ + 195 * i_82_, 506);
						}
						for (int i_86_ = 0; i_86_ < 3; i_86_++) {
							rd.setColor(new Color(0, 0, 0));
							float f = hsb[i_82_][i_86_] * 150.0F;
							if (i_86_ == 1) {
								float f_87_ = 0.75F;
								if (i_82_ == 0)
									f_87_ = 0.85F;
								if (i_82_ == 1)
									f_87_ = 0.8F;
								f = (hsb[i_82_][i_86_] - f_87_) / 0.001F;
							}
							if (i_86_ == 2)
								f = hsb[i_82_][i_86_] * 600.0F;
							if (f < 0.0F)
								f = 0.0F;
							if (f > 150.0F)
								f = 150.0F;
							rd.drawLine((int) (32 + 195 * i_82_ + f), 467 + i_86_ * 16, (int) (32 + 195 * i_82_ + f),
									474 + i_86_ * 16);
							rd.drawLine((int) (33 + 195 * i_82_ + f), 467 + i_86_ * 16, (int) (33 + 195 * i_82_ + f),
									474 + i_86_ * 16);
							rd.fillRect((int) (31 + 195 * i_82_ + f), 475 + i_86_ * 16, 4, 2);
							rd.drawLine((int) (30 + 195 * i_82_ + f), 477 + i_86_ * 16, (int) (35 + 195 * i_82_ + f),
									477 + i_86_ * 16);
							if (xm > 29 + 195 * i_82_ && xm < 185 + 195 * i_82_ && ym > 468 + i_86_ * 16
									&& ym < 477 + i_86_ * 16 && mouses == 1 && mouseon == -1)
								mouseon = i_86_ + i_82_ * 3;
							if (mouseon == i_86_ + i_82_ * 3) {
								if (i_86_ == 0)
									hsb[i_82_][i_86_] = (xm - (32 + 195 * i_82_)) / 150.0F;
								if (i_86_ == 1) {
									float f_88_ = 0.75F;
									if (i_82_ == 0)
										f_88_ = 0.85F;
									if (i_82_ == 1)
										f_88_ = 0.8F;
									hsb[i_82_][i_86_] = f_88_ + (xm - (32 + 195 * i_82_)) * 0.001F;
									if (hsb[i_82_][i_86_] < f_88_)
										hsb[i_82_][i_86_] = f_88_;
									if (hsb[i_82_][i_86_] > f_88_ + 0.15F)
										hsb[i_82_][i_86_] = f_88_ + 0.15F;
								}
								if (i_86_ == 2) {
									hsb[i_82_][i_86_] = (xm - (32 + 195 * i_82_)) / 600.0F;
									if (hsb[i_82_][i_86_] > 0.25)
										hsb[i_82_][i_86_] = 0.25F;
								}
								if (hsb[i_82_][i_86_] > 1.0F)
									hsb[i_82_][i_86_] = 1.0F;
								if (hsb[i_82_][i_86_] < 0.0F)
									hsb[i_82_][i_86_] = 0.0F;
							}
						}
					}
					movefield(pfog, 258, 511, 200, 23);
					if (!pfog.isShowing())
						pfog.setVisible(true);
					if (pfog.getState()) {
						rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
						rd.setColor(new Color(0, 0, 0));
						rd.fillRect(215, 464, 175, 47);
						rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
						hsb[1][1] = (hsb[0][1] + hsb[2][1]) / 2.0F;
						hsb[1][0] = hsb[2][0];
						hsb[1][2] = hsb[2][2];
					}
					Color color = Color.getHSBColor(hsb[0][0], hsb[0][2], hsb[0][1]);
					m.setsky(color.getRed(), color.getGreen(), color.getBlue());
					csky[0] = color.getRed();
					csky[1] = color.getGreen();
					csky[2] = color.getBlue();
					color = Color.getHSBColor(hsb[1][0], hsb[1][2], hsb[1][1]);
					m.setfade(color.getRed(), color.getGreen(), color.getBlue());
					cfade[0] = color.getRed();
					cfade[1] = color.getGreen();
					cfade[2] = color.getBlue();
					color = Color.getHSBColor(hsb[2][0], hsb[2][2], hsb[2][1]);
					m.setgrnd(color.getRed(), color.getGreen(), color.getBlue());
					cgrnd[0] = color.getRed();
					cgrnd[1] = color.getGreen();
					cgrnd[2] = color.getBlue();
					if (button(Messages.getString("StageMaker.704"), 650, 510, 0, true)) { //$NON-NLS-1$
						if (!ttstage.equals(Messages.getString("StageMaker.705"))) { //$NON-NLS-1$
							tstage = ttstage;
							ttstage = Messages.getString("StageMaker.706"); //$NON-NLS-1$
						}
						readstage(1);
						dtabed = -2;
					}
					if (button(Messages.getString("StageMaker.707"), 737, 510, 0, true)) { //$NON-NLS-1$
						sortop();
						ttstage = Messages.getString("StageMaker.708"); //$NON-NLS-1$
						savefile();
					}
				}
				if (dtab == 3) {
					if (dtabed != dtab) {
						Color.RGBtoHSB(cldd[0], cldd[1], cldd[2], hsb[0]);
						Color.RGBtoHSB(texture[0], texture[1], texture[2], hsb[1]);
						mgen.setText(new StringBuilder().append(Messages.getString("StageMaker.709")).append(m.mgen).append(Messages.getString("StageMaker.710")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						mouseon = -1;
						ttstage = Messages.getString("StageMaker.711"); //$NON-NLS-1$
					}
					if (mouses != 1) {
						if (mouseon == 0 || mouseon == 1 || mouseon == 2 || mouseon == 6) {
							if (ttstage.equals(Messages.getString("StageMaker.712"))) //$NON-NLS-1$
								ttstage = tstage;
							sortop();
							readstage(1);
						}
						mouseon = -1;
					}
					rd.setFont(new Font(Messages.getString("StageMaker.713"), 1, 12)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.714"), 32, 461); //$NON-NLS-1$
					for (int i_89_ = 0; i_89_ < 150; i_89_++) {
						rd.setColor(Color.getHSBColor(i_89_ * 0.006667F, 1.0F, 1.0F));
						rd.drawLine(32 + i_89_ + 0, 467, 32 + i_89_ + 0, 474);
					}
					for (int i_90_ = 0; i_90_ < 150; i_90_++) {
						rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.75F + i_90_ * 0.001667F));
						rd.drawLine(32 + i_90_ + 0, 483, 32 + i_90_ + 0, 490);
					}
					for (int i_91_ = 0; i_91_ < 150; i_91_++) {
						rd.setColor(Color.getHSBColor(hsb[0][0], i_91_ * 0.003333F, hsb[0][2]));
						rd.drawLine(32 + i_91_ + 0, 499, 32 + i_91_ + 0, 506);
					}
					rd.setFont(new Font(Messages.getString("StageMaker.715"), 0, 11)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.716"), 32, 529); //$NON-NLS-1$
					rd.setColor(new Color(0, 0, 0));
					rd.fillRect(70, 522, 112, 2);
					rd.fillRect(70, 528, 112, 2);
					float f = 0.0F;
					int i_92_ = 255;
					for (int i_93_ = 0; i_93_ < 112; i_93_++) {
						i_92_ = (int) (255.0F / (f + 1.0F));
						if (i_92_ > 255)
							i_92_ = 255;
						if (i_92_ < 0)
							i_92_ = 0;
						f += 0.02F;
						rd.setColor(new Color(i_92_, i_92_, i_92_));
						rd.drawLine(70 + i_93_, 524, 70 + i_93_, 527);
					}
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.717"), 202 - ftm.stringWidth(Messages.getString("StageMaker.718")) / 2, 461); //$NON-NLS-1$ //$NON-NLS-2$
					rd.drawLine(202, 467, 202, 530);
					for (int i_94_ = 0; i_94_ < 8; i_94_++)
						rd.drawLine(202, 466 + i_94_ * 8, 202 + 8 - i_94_, 466 + i_94_ * 8);
					rd.setFont(new Font(Messages.getString("StageMaker.719"), 1, 12)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.720"), 257, 471); //$NON-NLS-1$
					for (int i_95_ = 0; i_95_ < 150; i_95_++) {
						rd.setColor(Color.getHSBColor(i_95_ * 0.006667F, 1.0F, 1.0F));
						rd.drawLine(32 + i_95_ + 225, 477, 32 + i_95_ + 225, 484);
					}
					for (int i_96_ = 0; i_96_ < 150; i_96_++) {
						rd.setColor(Color.getHSBColor(hsb[1][0], i_96_ * 0.006667F, i_96_ * 0.006667F));
						rd.drawLine(32 + i_96_ + 225, 493, 32 + i_96_ + 225, 500);
					}
					rd.setFont(new Font(Messages.getString("StageMaker.721"), 0, 11)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.722"), 257, 523); //$NON-NLS-1$
					rd.setColor(new Color(0, 0, 0));
					rd.fillRect(295, 516, 112, 2);
					rd.fillRect(295, 522, 112, 2);
					f = 0.0F;
					i_92_ = 255;
					for (int i_97_ = 0; i_97_ < 112; i_97_++) {
						i_92_ = (int) (255.0F / (f + 1.0F));
						if (i_92_ > 255)
							i_92_ = 255;
						if (i_92_ < 0)
							i_92_ = 0;
						f += 0.02F;
						rd.setColor(new Color(i_92_, i_92_, i_92_));
						rd.drawLine(70 + i_97_ + 225, 518, 70 + i_97_ + 225, 521);
					}
					for (int i_98_ = 0; i_98_ < 2; i_98_++) {
						int i_99_ = 3;
						if (i_98_ == 1)
							i_99_ = 2;
						for (int i_100_ = 0; i_100_ < i_99_; i_100_++) {
							int i_101_ = i_100_;
							if (i_100_ == 1)
								i_101_ = 2;
							if (i_100_ == 2)
								i_101_ = 1;
							rd.setColor(new Color(0, 0, 0));
							float f_102_ = hsb[i_98_][i_101_] * 150.0F;
							if (i_100_ == 1 && i_98_ == 0) {
								final float f_103_ = 0.75F;
								f_102_ = (hsb[i_98_][i_101_] - f_103_) / 0.001667F;
							}
							if (i_100_ == 2 && i_98_ == 0)
								f_102_ = hsb[i_98_][i_101_] / 0.003333F;
							if (f_102_ < 0.0F)
								f_102_ = 0.0F;
							if (f_102_ > 150.0F)
								f_102_ = 150.0F;
							rd.drawLine((int) (32 + 225 * i_98_ + f_102_), 467 + i_100_ * 16 + 10 * i_98_,
									(int) (32 + 225 * i_98_ + f_102_), 474 + i_100_ * 16 + 10 * i_98_);
							rd.drawLine((int) (33 + 225 * i_98_ + f_102_), 467 + i_100_ * 16 + 10 * i_98_,
									(int) (33 + 225 * i_98_ + f_102_), 474 + i_100_ * 16 + 10 * i_98_);
							rd.fillRect((int) (31 + 225 * i_98_ + f_102_), 475 + i_100_ * 16 + 10 * i_98_, 4, 2);
							rd.drawLine((int) (30 + 225 * i_98_ + f_102_), 477 + i_100_ * 16 + 10 * i_98_,
									(int) (35 + 225 * i_98_ + f_102_), 477 + i_100_ * 16 + 10 * i_98_);
							if (xm > 29 + 225 * i_98_ && xm < 185 + 225 * i_98_ && ym > 468 + i_100_ * 16 + 10 * i_98_
									&& ym < 477 + i_100_ * 16 + 10 * i_98_ && mouses == 1 && mouseon == -1)
								mouseon = i_100_ + i_98_ * 3;
							if (mouseon == i_100_ + i_98_ * 3) {
								hsb[i_98_][i_101_] = (xm - (32 + 225 * i_98_)) * 0.006667F;
								if (i_100_ == 1 && i_98_ == 1) {
									hsb[i_98_][1] = (xm - (32 + 225 * i_98_)) * 0.006667F;
									if (hsb[i_98_][1] > 1.0F)
										hsb[i_98_][1] = 1.0F;
									if (hsb[i_98_][1] < 0.0F)
										hsb[i_98_][1] = 0.0F;
								}
								if (i_100_ == 1 && i_98_ == 0) {
									final float f_104_ = 0.75F;
									hsb[i_98_][i_101_] = f_104_ + (xm - (32 + 225 * i_98_)) * 0.001667F;
									if (hsb[i_98_][i_101_] < f_104_)
										hsb[i_98_][i_101_] = f_104_;
								}
								if (i_100_ == 2 && i_98_ == 0) {
									hsb[i_98_][i_101_] = (xm - (32 + 225 * i_98_)) * 0.003333F;
									if (hsb[i_98_][i_101_] > 0.5)
										hsb[i_98_][i_101_] = 0.5F;
								}
								if (hsb[i_98_][i_101_] > 1.0F)
									hsb[i_98_][i_101_] = 1.0F;
								if (hsb[i_98_][i_101_] < 0.0F)
									hsb[i_98_][i_101_] = 0.0F;
							}
						}
						rd.setColor(new Color(0, 0, 0));
						float f_105_ = (texture[3] - 20) * 2.8F;
						if (i_98_ == 0)
							f_105_ = cldd[3] * 11.2F;
						if (f_105_ < 0.0F)
							f_105_ = 0.0F;
						if (f_105_ > 112.0F)
							f_105_ = 112.0F;
						rd.drawLine((int) (70 + 225 * i_98_ + f_105_), 522 - 6 * i_98_,
								(int) (70 + 225 * i_98_ + f_105_), 529 - 6 * i_98_);
						rd.drawLine((int) (71 + 225 * i_98_ + f_105_), 522 - 6 * i_98_,
								(int) (71 + 225 * i_98_ + f_105_), 529 - 6 * i_98_);
						rd.fillRect((int) (69 + 225 * i_98_ + f_105_), 530 - 6 * i_98_, 4, 2);
						rd.drawLine((int) (68 + 225 * i_98_ + f_105_), 532 - 6 * i_98_,
								(int) (73 + 225 * i_98_ + f_105_), 532 - 6 * i_98_);
						if (xm > 67 + 225 * i_98_ && xm < 185 + 225 * i_98_ && ym > 522 - 6 * i_98_
								&& ym < 532 - 6 * i_98_ && mouses == 1 && mouseon == -1)
							mouseon = 6 + i_98_;
					}
					if (mouseon == 6) {
						cldd[3] = (int) ((xm - 70) / 11.2F);
						if (cldd[3] < 0)
							cldd[3] = 0;
						if (cldd[3] > 10)
							cldd[3] = 10;
					}
					if (mouseon == 7) {
						texture[3] = (int) ((xm - 70 - 225) / 2.8 + 20.0);
						if (texture[3] < 20)
							texture[3] = 20;
						if (texture[3] > 60)
							texture[3] = 60;
					}
					rd.setColor(new Color(0, 128, 255));
					float f_106_ = (1500 - Math.abs(cldd[4])) / 15.625F;
					if (f_106_ > 64.0F)
						f_106_ = 64.0F;
					if (f_106_ < 0.0F)
						f_106_ = 0.0F;
					rd.drawRect(199, (int) (465.0F + f_106_), 12, 2);
					if (xm > 197 && xm < 213 && ym > 463 && ym < 533 && mouses == 1 && mouseon == -1)
						mouseon = 8;
					if (mouseon == 8) {
						cldd[4] = -(int) ((530 - ym) * 15.625F + 500.0F);
						if (cldd[4] > -500)
							cldd[4] = -500;
						if (cldd[4] < -1500)
							cldd[4] = -1500;
					}
					Color color = Color.getHSBColor(hsb[0][0], hsb[0][1], hsb[0][2]);
					m.setcloads(color.getRed(), color.getGreen(), color.getBlue(), cldd[3], cldd[4]);
					cldd[0] = color.getRed();
					cldd[1] = color.getGreen();
					cldd[2] = color.getBlue();
					color = Color.getHSBColor(hsb[1][0], hsb[1][1], hsb[1][2]);
					m.setexture(color.getRed(), color.getGreen(), color.getBlue(), texture[3]);
					texture[0] = color.getRed();
					texture[1] = color.getGreen();
					texture[2] = color.getBlue();
					rd.setFont(new Font(Messages.getString("StageMaker.723"), 1, 12)); //$NON-NLS-1$
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.724"), 452, 465); //$NON-NLS-1$
					rd.setFont(new Font(Messages.getString("StageMaker.725"), 0, 11)); //$NON-NLS-1$
					rd.drawString(Messages.getString("StageMaker.726"), 452, 480); //$NON-NLS-1$
					movefield(mgen, 452, 484, 120, 20);
					if (mgen.hasFocus())
						focuson = false;
					if (!mgen.isShowing())
						mgen.setVisible(true);
					if (button(Messages.getString("StageMaker.727"), 512, 525, 3, true)) { //$NON-NLS-1$
						m.mgen = (int) (Math.random() * 100000.0);
						mgen.setText(new StringBuilder().append(Messages.getString("StageMaker.728")).append(m.mgen).append(Messages.getString("StageMaker.729")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						if (ttstage.equals(Messages.getString("StageMaker.730"))) //$NON-NLS-1$
							ttstage = tstage;
						sortop();
						readstage(1);
					}
					if (!mgen.getText().equals(new StringBuilder().append(Messages.getString("StageMaker.731")).append(m.mgen).append(Messages.getString("StageMaker.732")).toString())) //$NON-NLS-1$ //$NON-NLS-2$
						try {
							final int i_107_ = Integer.valueOf(mgen.getText()).intValue();
							m.mgen = i_107_;
							if (ttstage.equals(Messages.getString("StageMaker.733"))) //$NON-NLS-1$
								ttstage = tstage;
							sortop();
							readstage(1);
						} catch (final Exception exception) {
							mgen.setText(new StringBuilder().append(Messages.getString("StageMaker.734")).append(m.mgen).append(Messages.getString("StageMaker.735")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						}
					if (button(Messages.getString("StageMaker.736"), 650, 510, 0, true)) { //$NON-NLS-1$
						if (!ttstage.equals(Messages.getString("StageMaker.737"))) { //$NON-NLS-1$
							tstage = ttstage;
							ttstage = Messages.getString("StageMaker.738"); //$NON-NLS-1$
						}
						readstage(1);
						dtabed = -2;
					}
					if (button(Messages.getString("StageMaker.739"), 737, 510, 0, true)) { //$NON-NLS-1$
						sortop();
						ttstage = Messages.getString("StageMaker.740"); //$NON-NLS-1$
						savefile();
					}
				}
				if (dtab == 1) {
					if (dtabed != dtab) {
						for (int i_108_ = 0; i_108_ < 3; i_108_++)
							snap[i_108_] = (int) (m.snap[i_108_] / 1.2F + 50.0F);
						fogn[0] = (8 - ((m.fogd + 1) / 2 - 1)) * 20;
						fogn[1] = (m.fade[0] - 5000) / 30;
					}
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.741"), 20, 461); //$NON-NLS-1$
					rd.setColor(new Color(128, 128, 128));
					rd.drawLine(10, 457, 17, 457);
					rd.drawLine(260, 457, 152, 457);
					rd.drawLine(10, 457, 10, 546);
					rd.drawLine(260, 457, 260, 527);
					rd.drawLine(260, 527, 360, 527);
					rd.drawLine(10, 546, 360, 546);
					rd.drawLine(360, 527, 360, 546);
					final String[] strings_109_ = { Messages.getString("StageMaker.742"), Messages.getString("StageMaker.743"), Messages.getString("StageMaker.744") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					final int[] is_110_ = { 32, 20, 29 };
					int i_111_ = 38;
					int i_112_ = -70;
					for (int i_113_ = 0; i_113_ < 3; i_113_++) {
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(
								new StringBuilder().append(Messages.getString("StageMaker.745")).append(strings_109_[i_113_]).append(Messages.getString("StageMaker.746")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
								is_110_[i_113_], 447 + i_113_ * 24 + i_111_);
						rd.drawLine(140 + i_112_, 443 + i_113_ * 24 + i_111_, 230 + i_112_, 443 + i_113_ * 24 + i_111_);
						for (int i_114_ = 1; i_114_ < 10; i_114_++)
							rd.drawLine(140 + 10 * i_114_ + i_112_, 443 - i_114_ + i_113_ * 24 + i_111_,
									140 + 10 * i_114_ + i_112_, 443 + i_114_ + i_113_ * 24 + i_111_);
						rd.setColor(new Color(255, 0, 0));
						final int i_115_ = (int) (snap[i_113_] / 1.1111F / 10.0F);
						rd.fillRect(138 + (int) (snap[i_113_] / 1.1111F) + i_112_, 443 - i_115_ + i_113_ * 24 + i_111_,
								5, i_115_ * 2 + 1);
						rd.setColor(new Color(255, 128, 0));
						rd.drawRect(139 + (int) (snap[i_113_] / 1.1111F) + i_112_, 434 + i_113_ * 24 + i_111_, 2, 18);
						if (button(Messages.getString("StageMaker.747"), 260 + i_112_, 447 + i_113_ * 24 + i_111_, 4, false)) { //$NON-NLS-1$
							snap[i_113_] -= 2;
							if (snap[i_113_] < 0)
								snap[i_113_] = 0;
						}
						if (button(Messages.getString("StageMaker.748"), 300 + i_112_, 447 + i_113_ * 24 + i_111_, 4, false)) { //$NON-NLS-1$
							if (snap[0] + snap[1] + snap[2] > 200)
								for (int i_116_ = 0; i_116_ < 3; i_116_++)
									if (i_116_ != i_113_) {
										snap[i_116_]--;
										if (snap[i_116_] < 0)
											snap[i_116_] = 0;
									}
							snap[i_113_] += 2;
							if (snap[i_113_] > 100)
								snap[i_113_] = 100;
						}
					}
					if (m.snap[0] != (int) (snap[0] * 1.2F - 60.0F) || m.snap[1] != (int) (snap[1] * 1.2F - 60.0F)
							|| m.snap[2] != (int) (snap[2] * 1.2F - 60.0F)) {
						for (int i_117_ = 0; i_117_ < 3; i_117_++)
							m.snap[i_117_] = (int) (snap[i_117_] * 1.2F - 60.0F);
						readstage(2);
					}
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.749"), 265, 541); //$NON-NLS-1$
					if (snap[0] + snap[1] + snap[2] > 110) {
						rd.drawString(Messages.getString("StageMaker.750"), 335, 541); //$NON-NLS-1$
						m.lightson = false;
					} else {
						rd.setColor(new Color(0, 200, 0));
						rd.drawString(Messages.getString("StageMaker.751"), 335, 541); //$NON-NLS-1$
						m.lightson = true;
					}
					final int i_118_ = 33;
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.752"), 280 + i_118_, 461); //$NON-NLS-1$
					rd.setColor(new Color(128, 128, 128));
					rd.drawLine(270 + i_118_, 457, 277 + i_118_, 457);
					rd.drawLine(540 + i_118_, 457, 393 + i_118_, 457);
					rd.drawLine(270 + i_118_, 457, 270 + i_118_, 522);
					rd.drawLine(540 + i_118_, 457, 540 + i_118_, 522);
					rd.drawLine(270 + i_118_, 522, 540 + i_118_, 522);
					final String[] strings_119_ = { Messages.getString("StageMaker.753"), Messages.getString("StageMaker.754") }; //$NON-NLS-1$ //$NON-NLS-2$
					final int[] is_120_ = { 292 + i_118_, 280 + i_118_ };
					final int[] is_121_ = { 20, 10 };
					i_111_ = 38;
					i_112_ = 210 + i_118_;
					for (int i_122_ = 0; i_122_ < 2; i_122_++) {
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(
								new StringBuilder().append(Messages.getString("StageMaker.755")).append(strings_119_[i_122_]).append(Messages.getString("StageMaker.756")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
								is_120_[i_122_], 447 + i_122_ * 24 + i_111_);
						rd.drawLine(140 + i_112_, 443 + i_122_ * 24 + i_111_, 230 + i_112_, 443 + i_122_ * 24 + i_111_);
						for (int i_123_ = 1; i_123_ < 10; i_123_++)
							rd.drawLine(140 + 10 * i_123_ + i_112_, 443 - i_123_ + i_122_ * 24 + i_111_,
									140 + 10 * i_123_ + i_112_, 443 + i_123_ + i_122_ * 24 + i_111_);
						rd.setColor(new Color(255, 0, 0));
						final int i_124_ = (int) (fogn[i_122_] / 1.1111F / 10.0F);
						rd.fillRect(138 + (int) (fogn[i_122_] / 1.1111F) + i_112_, 443 - i_124_ + i_122_ * 24 + i_111_,
								5, i_124_ * 2 + 1);
						rd.setColor(new Color(255, 128, 0));
						rd.drawRect(139 + (int) (fogn[i_122_] / 1.1111F) + i_112_, 434 + i_122_ * 24 + i_111_, 2, 18);
						if (button(Messages.getString("StageMaker.757"), 260 + i_112_, 447 + i_122_ * 24 + i_111_, 4, false)) { //$NON-NLS-1$
							fogn[i_122_] -= is_121_[i_122_];
							if (fogn[i_122_] < 0)
								fogn[i_122_] = 0;
						}
						if (button(Messages.getString("StageMaker.758"), 300 + i_112_, 447 + i_122_ * 24 + i_111_, 4, false)) { //$NON-NLS-1$
							fogn[i_122_] += is_121_[i_122_];
							if (fogn[i_122_] > 100)
								fogn[i_122_] = 100;
						}
					}
					m.fogd = (8 - fogn[0] / 20 + 1) * 2 - 1;
					m.fadfrom(5000 + fogn[1] * 30);
					origfade = m.fade[0];
					if (button(Messages.getString("StageMaker.759"), 650, 510, 0, true)) //$NON-NLS-1$
						dtabed = -2;
					if (button(Messages.getString("StageMaker.760"), 737, 510, 0, true)) { //$NON-NLS-1$
						sortop();
						savefile();
					}
				}
				if (dtab == 4) {
					if (dtabed != dtab && cp.nlaps - 1 >= 0 && cp.nlaps - 1 <= 14)
						nlaps.select(cp.nlaps - 1);
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.761"), 130, 496); //$NON-NLS-1$
					nlaps.move(348, 480);
					if (!nlaps.isShowing())
						nlaps.setVisible(true);
					if (cp.nlaps != nlaps.getSelectedIndex() + 1) {
						cp.nlaps = nlaps.getSelectedIndex() + 1;
						requestFocus();
					}
					if (button(Messages.getString("StageMaker.762"), 530, 496, 0, true)) //$NON-NLS-1$
						dtabed = -2;
					if (button(Messages.getString("StageMaker.763"), 617, 496, 0, true)) { //$NON-NLS-1$
						sortop();
						savefile();
					}
				}
				if (dtab == 5) {
					if (dtabed != dtab) {
						tracks.removeAll();
						tracks.maxl = 200;
						tracks.add(rd, Messages.getString("StageMaker.764")); //$NON-NLS-1$
						final String[] strings_125_ = new File(Messages.getString("StageMaker.765")).list(); //$NON-NLS-1$
						if (strings_125_ != null)
							for (int i_126_ = 0; i_126_ < strings_125_.length; i_126_++)
								if (strings_125_[i_126_].toLowerCase().endsWith(Messages.getString("StageMaker.766"))) //$NON-NLS-1$
									tracks.add(rd,
											strings_125_[i_126_].substring(0, strings_125_[i_126_].length() - 4));
						if (ltrackname.equals(Messages.getString("StageMaker.767"))) { //$NON-NLS-1$
							if (trackname.equals(Messages.getString("StageMaker.768"))) //$NON-NLS-1$
								tracks.select(0);
							else
								tracks.select(trackname);
						} else
							tracks.select(ltrackname);
						mouseon = -1;
					}
					tracks.move(10, 450);
					if (tracks.getWidth() != 200)
						tracks.setSize(200, 21);
					if (!tracks.isShowing())
						tracks.setVisible(true);
					if (track.playing && track.loaded == 2) {
						if (button(Messages.getString("StageMaker.769"), 110, 495, 2, false)) //$NON-NLS-1$
							track.stop();
						if (!ltrackname.equals(tracks.getSelectedItem()))
							track.stop();
						if (xm > 10 && xm < 210 && ym > 516 && ym < 534) {
							if (mouses == 1)
								mouseon = 1;
							rd.setColor(new Color(0, 164, 242));
						} else
							rd.setColor(new Color(120, 210, 255));
						rd.drawRect(10, 516, 200, 18);
						rd.setColor(new Color(200, 200, 200));
						rd.drawLine(10, 523, 210, 523);
						rd.setColor(new Color(0, 0, 0));
						rd.drawLine(10, 524, 210, 524);
						rd.drawLine(10, 525, 210, 525);
						rd.drawLine(10, 526, 210, 526);
						rd.setColor(new Color(255, 255, 255));
						rd.drawLine(10, 527, 210, 527);
						int i_127_ = (int) ((1.0F - (float) track.sClip.stream.available() / (float) avon) * 200.0F);
						if (mouseon == 1) {
							i_127_ = xm - 10;
							if (i_127_ < 0)
								i_127_ = 0;
							if (i_127_ > 200)
								i_127_ = 200;
							if (mouses != 1) {
								track.sClip.stream.reset();
								track.sClip.stream.skip((long) (i_127_ / 200.0F * avon));
								mouseon = -1;
							}
						}
						rd.setColor(new Color(0, 0, 0));
						rd.drawRect(8 + i_127_, 516, 4, 18);
						rd.setColor(new Color(0, 164, 242));
						rd.drawLine(10 + i_127_, 520, 10 + i_127_, 518);
						rd.drawLine(10 + i_127_, 530, 10 + i_127_, 532);
					} else if (tracks.getSelectedIndex() != 0 && button(Messages.getString("StageMaker.770"), 110, 495, 2, false)) { //$NON-NLS-1$
						if (!ltrackname.equals(tracks.getSelectedItem())) {
							track.unload();
							track = new RadicalMod(new StringBuilder().append(Messages.getString("StageMaker.771")) //$NON-NLS-1$
									.append(tracks.getSelectedItem()).append(Messages.getString("StageMaker.772")).toString(), 300, 8000, 125, true, //$NON-NLS-1$
									false);
							if (track.loaded == 2) {
								avon = track.sClip.stream.available();
								ltrackname = tracks.getSelectedItem();
							} else
								ltrackname = Messages.getString("StageMaker.773"); //$NON-NLS-1$
						}
						if (!ltrackname.equals(Messages.getString("StageMaker.774"))) //$NON-NLS-1$
							track.play();
						else
							JOptionPane.showMessageDialog(null,
									new StringBuilder().append(Messages.getString("StageMaker.775")).append(tracks.getSelectedItem()) //$NON-NLS-1$
											.append(Messages.getString("StageMaker.776")).toString(), //$NON-NLS-1$
									Messages.getString("StageMaker.777"), 1); //$NON-NLS-1$
					}
					if (tracks.getSelectedIndex() != 0) {
						if (button(Messages.getString("StageMaker.778"), 330, 466, 2, false)) { //$NON-NLS-1$
							if (!ltrackname.equals(tracks.getSelectedItem())) {
								track.unload();
								track = new RadicalMod(new StringBuilder().append(Messages.getString("StageMaker.779")) //$NON-NLS-1$
										.append(tracks.getSelectedItem()).append(Messages.getString("StageMaker.780")).toString(), 300, 8000, 125, //$NON-NLS-1$
										true, false);
								if (track.loaded == 2) {
									avon = track.sClip.stream.available();
									ltrackname = tracks.getSelectedItem();
								} else
									ltrackname = Messages.getString("StageMaker.781"); //$NON-NLS-1$
							}
							if (!ltrackname.equals(Messages.getString("StageMaker.782"))) { //$NON-NLS-1$
								trackname = ltrackname;
								trackvol = (int) (220.0F / (track.rvol / 3750.0F));
								try {
									final File file = new File(new StringBuilder().append(Messages.getString("StageMaker.783")) //$NON-NLS-1$
											.append(trackname).append(Messages.getString("StageMaker.784")).toString()); //$NON-NLS-1$
									tracksize = (int) (file.length() / 1024L);
									if (tracksize > 250) {
										JOptionPane.showMessageDialog(null,
												new StringBuilder().append(Messages.getString("StageMaker.785")) //$NON-NLS-1$
														.append(tracks.getSelectedItem())
														.append(Messages.getString("StageMaker.786")) //$NON-NLS-1$
														.toString(),
												Messages.getString("StageMaker.787"), 1); //$NON-NLS-1$
										trackname = Messages.getString("StageMaker.788"); //$NON-NLS-1$
									}
								} catch (final Exception exception) {
									tracksize = 111;
								}
							} else
								JOptionPane.showMessageDialog(null,
										new StringBuilder().append(Messages.getString("StageMaker.789")).append(tracks.getSelectedItem()) //$NON-NLS-1$
												.append(Messages.getString("StageMaker.790")).toString(), //$NON-NLS-1$
										Messages.getString("StageMaker.791"), 1); //$NON-NLS-1$
						}
						if (button(Messages.getString("StageMaker.792"), 258, 495, 2, false) && JOptionPane.showConfirmDialog(null, //$NON-NLS-1$
								new StringBuilder()
										.append(Messages.getString("StageMaker.793")) //$NON-NLS-1$
										.append(tracks.getSelectedItem())
										.append(Messages.getString("StageMaker.794")) //$NON-NLS-1$
										.toString(),
								Messages.getString("StageMaker.795"), 0) == 0) //$NON-NLS-1$
							deltrack();
					}
					if (button(Messages.getString("StageMaker.796"), 330, 530, 0, false) //$NON-NLS-1$
							&& JOptionPane.showConfirmDialog(null,
									Messages.getString("StageMaker.797"), //$NON-NLS-1$
									Messages.getString("StageMaker.798"), 0) == 0) { //$NON-NLS-1$
						File file = null;
						final FileDialog filedialog = new FileDialog(new Frame(),
								Messages.getString("StageMaker.799")); //$NON-NLS-1$
						filedialog.setFile(Messages.getString("StageMaker.800")); //$NON-NLS-1$
						filedialog.setMode(0);
						filedialog.setVisible(true);
						try {
							if (filedialog.getFile() != null)
								file = new File(new StringBuilder().append(Messages.getString("StageMaker.801")).append(filedialog.getDirectory()) //$NON-NLS-1$
										.append(Messages.getString("StageMaker.802")).append(filedialog.getFile()).append(Messages.getString("StageMaker.803")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						} catch (final Exception exception) {
							/* empty */
						}
						if (file != null)
							try {
								if (file.length() / 1024L < 250L) {
									File file_128_ = new File(Messages.getString("StageMaker.804")); //$NON-NLS-1$
									if (!file_128_.exists())
										file_128_.mkdirs();
									file_128_ = new File(new StringBuilder().append(Messages.getString("StageMaker.805")) //$NON-NLS-1$
											.append(file.getName()).append(Messages.getString("StageMaker.806")).toString()); //$NON-NLS-1$
									final FileInputStream fileinputstream = new FileInputStream(file);
									final FileOutputStream fileoutputstream = new FileOutputStream(file_128_);
									final byte[] is_129_ = new byte[1024];
									int i_130_;
									while ((i_130_ = fileinputstream.read(is_129_)) > 0)
										fileoutputstream.write(is_129_, 0, i_130_);
									fileinputstream.close();
									fileoutputstream.close();
									tracks.removeAll();
									tracks.add(rd, Messages.getString("StageMaker.807")); //$NON-NLS-1$
									final String[] strings_131_ = new File(Messages.getString("StageMaker.808")).list(); //$NON-NLS-1$
									if (strings_131_ != null)
										for (int i_132_ = 0; i_132_ < strings_131_.length; i_132_++)
											if (strings_131_[i_132_].toLowerCase().endsWith(Messages.getString("StageMaker.809"))) //$NON-NLS-1$
												tracks.add(rd, strings_131_[i_132_].substring(0,
														strings_131_[i_132_].length() - 4));
									tracks.select(file.getName().substring(0, file.getName().length() - 4));
								} else
									JOptionPane.showMessageDialog(null,
											Messages.getString("StageMaker.810"), //$NON-NLS-1$
											Messages.getString("StageMaker.811"), 1); //$NON-NLS-1$
							} catch (final Exception exception) {
								JOptionPane.showMessageDialog(null, new StringBuilder()
										.append(Messages.getString("StageMaker.812")).append(exception).toString(), //$NON-NLS-1$
										Messages.getString("StageMaker.813"), 1); //$NON-NLS-1$
							}
					}
					final int i_133_ = 200;
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.814"), 280 + i_133_, 461); //$NON-NLS-1$
					String string = trackname;
					if (string.equals(Messages.getString("StageMaker.815"))) //$NON-NLS-1$
						string = Messages.getString("StageMaker.816"); //$NON-NLS-1$
					else if (button(Messages.getString("StageMaker.817"), 378, 495, 2, false)) //$NON-NLS-1$
						trackname = Messages.getString("StageMaker.818"); //$NON-NLS-1$
					rd.drawString(string, 629 - ftm.stringWidth(string) / 2, 482);
					rd.setColor(new Color(128, 128, 128));
					rd.drawLine(270 + i_133_, 457, 277 + i_133_, 457);
					rd.drawLine(589 + i_133_, 457, 353 + i_133_, 457);
					rd.drawLine(270 + i_133_, 457, 270 + i_133_, 497);
					rd.drawLine(589 + i_133_, 457, 589 + i_133_, 497);
					rd.drawLine(270 + i_133_, 497, 589 + i_133_, 497);
					if (button(Messages.getString("StageMaker.819"), 576, 530, 0, true)) { //$NON-NLS-1$
						ltrackname = Messages.getString("StageMaker.820"); //$NON-NLS-1$
						dtabed = -2;
					}
					if (button(Messages.getString("StageMaker.821"), 663, 530, 0, true)) { //$NON-NLS-1$
						sortop();
						savefile();
					}
				}
				if (dtab == 6) {
					rd.setColor(new Color(0, 0, 0));
					rd.setFont(new Font(Messages.getString("StageMaker.822"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("StageMaker.823"), 400 - ftm.stringWidth(Messages.getString("StageMaker.824")) / 2, 470); //$NON-NLS-1$ //$NON-NLS-2$
					witho.move(342, 480);
					if (!witho.isShowing())
						witho.setVisible(true);
					if (button(Messages.getString("StageMaker.825"), 400, 530, 0, true)) { //$NON-NLS-1$
						savefile();
						errd = 0;
						readstage(3);
						if (cp.nsp < 2)
							errd = 7;
						if (errd == 0) {
							Madness.testcar = stagename;
							Madness.testdrive = witho.getSelectedIndex() + 3;
							Madness.game();
						} else
							JOptionPane.showMessageDialog(null,
									new StringBuilder()
											.append(Messages.getString("StageMaker.826")) //$NON-NLS-1$
											.append(errlo[errd - 1]).append(Messages.getString("StageMaker.827")).toString(), //$NON-NLS-1$
									Messages.getString("StageMaker.828"), 0); //$NON-NLS-1$
					}
				}
				if (dtabed != dtab)
					if (dtabed == -2)
						dtabed = -1;
					else
						dtabed = dtab;
			}
			if (tab == 3) {
				rd.setFont(new Font(Messages.getString("StageMaker.829"), 1, 13)); //$NON-NLS-1$
				rd.setColor(new Color(0, 0, 0));
				rd.drawString(
						new StringBuilder().append(Messages.getString("StageMaker.830")).append(stagename).append(Messages.getString("StageMaker.831")).toString(), 30, //$NON-NLS-1$ //$NON-NLS-2$
						50);
				rd.drawString(Messages.getString("StageMaker.832"), 30, 80); //$NON-NLS-1$
				pubtyp.move(150, 63);
				if (!pubtyp.isShowing()) {
					pubtyp.setVisible(true);
					pubtyp.select(1);
				}
				rd.setColor(new Color(0, 0, 0));
				rd.setFont(new Font(Messages.getString("StageMaker.833"), 0, 12)); //$NON-NLS-1$
				if (pubtyp.getSelectedIndex() == 0) {
					rd.drawString(
							Messages.getString("StageMaker.834"), //$NON-NLS-1$
							268, 72);
					rd.drawString(Messages.getString("StageMaker.835"), 268, 88); //$NON-NLS-1$
				}
				if (pubtyp.getSelectedIndex() == 1) {
					rd.drawString(
							Messages.getString("StageMaker.836"), //$NON-NLS-1$
							268, 72);
					rd.drawString(Messages.getString("StageMaker.837"), 268, //$NON-NLS-1$
							88);
				}
				if (pubtyp.getSelectedIndex() == 2) {
					rd.drawString(
							Messages.getString("StageMaker.838"), //$NON-NLS-1$
							268, 72);
					rd.drawString(Messages.getString("StageMaker.839"), 268, 88); //$NON-NLS-1$
				}
				rd.setFont(new Font(Messages.getString("StageMaker.840"), 1, 12)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				rd.drawString(Messages.getString("StageMaker.841"), 180 - ftm.stringWidth(Messages.getString("StageMaker.842")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("StageMaker.843"), 400 - ftm.stringWidth(Messages.getString("StageMaker.844")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("StageMaker.845"), 500 - ftm.stringWidth(Messages.getString("StageMaker.846")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("StageMaker.847"), 600 - ftm.stringWidth(Messages.getString("StageMaker.848")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("StageMaker.849"), 720 - ftm.stringWidth(Messages.getString("StageMaker.850")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawLine(350, 129, 350, 140);
				rd.drawLine(450, 129, 450, 140);
				rd.drawLine(550, 129, 550, 140);
				rd.drawLine(650, 129, 650, 140);
				rd.drawRect(10, 140, 780, 402);
				if (button(Messages.getString("StageMaker.851"), 102, 110, 0, true)) { //$NON-NLS-1$
					if (logged == 0)
						JOptionPane.showMessageDialog(null,
								Messages.getString("StageMaker.852"), Messages.getString("StageMaker.853"), 1); //$NON-NLS-1$ //$NON-NLS-2$
					if (logged == 3 || logged == -1) {
						savefile();
						errd = 0;
						readstage(3);
						if (cp.nsp < 2)
							errd = 7;
						rd.setFont(new Font(Messages.getString("StageMaker.854"), 1, 12)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						if (ftm.stringWidth(stagename) > 274)
							errd = 8;
						if (errd == 0) {
							int i = 0;
							for (int i_134_ = 0; i_134_ < nms; i_134_++)
								if (mystages[i_134_].equals(stagename)
										&& maker[i_134_].toLowerCase().equals(tnick.getText().toLowerCase()))
									i = JOptionPane.showConfirmDialog(null,
											new StringBuilder().append(Messages.getString("StageMaker.855")) //$NON-NLS-1$
													.append(stagename).append(Messages.getString("StageMaker.856")).toString(), //$NON-NLS-1$
											Messages.getString("StageMaker.857"), 0); //$NON-NLS-1$
							if (i == 0) {
								setCursor(new Cursor(3));
								rd.setFont(new Font(Messages.getString("StageMaker.858"), 1, 13)); //$NON-NLS-1$
								ftm = rd.getFontMetrics();
								rd.setColor(new Color(225, 225, 225));
								rd.fillRect(11, 141, 779, 401);
								rd.setColor(new Color(0, 0, 0));
								rd.drawString(Messages.getString("StageMaker.859"), //$NON-NLS-1$
										400 - ftm.stringWidth(Messages.getString("StageMaker.860")) / 2, 250); //$NON-NLS-1$
								repaint();
								int i_135_ = -1;
								try {
									final Socket socket = new Socket(Messages.getString("StageMaker.861"), 7061); //$NON-NLS-1$
									final BufferedReader bufferedreader = new BufferedReader(
											new InputStreamReader(socket.getInputStream()));
									final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
									printwriter.println(new StringBuilder().append(Messages.getString("StageMaker.862")).append(tnick.getText()) //$NON-NLS-1$
											.append(Messages.getString("StageMaker.863")).append(tpass.getText()).append(Messages.getString("StageMaker.864")).append(stagename) //$NON-NLS-1$ //$NON-NLS-2$
											.append(Messages.getString("StageMaker.865")).append(pubtyp.getSelectedIndex()).append(Messages.getString("StageMaker.866")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
									String string = bufferedreader.readLine();
									if (string != null)
										i_135_ = servervalue(string, 0);
									if (i_135_ == 0) {
										String string_136_ = Messages.getString("StageMaker.867"); //$NON-NLS-1$
										final String string_137_ = new StringBuilder().append(Messages.getString("StageMaker.868")).append(tstage) //$NON-NLS-1$
												.append(Messages.getString("StageMaker.869")).append(bstage).append(Messages.getString("StageMaker.870")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
										final DataInputStream datainputstream = new DataInputStream(
												new ByteArrayInputStream(string_137_.getBytes()));
										String string_139_;
										while ((string_139_ = datainputstream.readLine()) != null) {
											string_139_ = string_139_.trim();
											printwriter.println(string_139_);
											rd.setColor(new Color(225, 225, 225));
											rd.fillRect(11, 141, 779, 401);
											rd.setColor(new Color(0, 0, 0));
											rd.drawString(string_136_, 400 - ftm.stringWidth(string_136_) / 2, 250);
											string_136_ = new StringBuilder().append(Messages.getString("StageMaker.871")).append(string_136_) //$NON-NLS-1$
													.append(Messages.getString("StageMaker.872")).toString(); //$NON-NLS-1$
											if (string_136_.equals(
													Messages.getString("StageMaker.873"))) //$NON-NLS-1$
												string_136_ = Messages.getString("StageMaker.874"); //$NON-NLS-1$
											repaint();
											try {
												if (thredo != null) {
													/* empty */
												}
												Thread.sleep(10L);
											} catch (final InterruptedException interruptedexception) {
												/* empty */
											}
										}
										printwriter.println(Messages.getString("StageMaker.875")); //$NON-NLS-1$
										rd.setColor(new Color(225, 225, 225));
										rd.fillRect(11, 141, 779, 401);
										rd.setColor(new Color(0, 0, 0));
										rd.drawString(Messages.getString("StageMaker.876"), //$NON-NLS-1$
												400 - ftm.stringWidth(Messages.getString("StageMaker.877")) / 2, 250); //$NON-NLS-1$
										rd.drawString(Messages.getString("StageMaker.878"), 400 //$NON-NLS-1$
												- ftm.stringWidth(Messages.getString("StageMaker.879")) //$NON-NLS-1$
														/ 2,
												280);
										repaint();
										string = bufferedreader.readLine();
										if (string != null)
											i_135_ = servervalue(string, 0);
										else
											i_135_ = -1;
										if (i_135_ == 0) {
											rd.setColor(new Color(225, 225, 225));
											rd.fillRect(11, 141, 779, 401);
											rd.setColor(new Color(0, 0, 0));
											rd.drawString(Messages.getString("StageMaker.880"), //$NON-NLS-1$
													400 - ftm.stringWidth(Messages.getString("StageMaker.881")) / 2, 250); //$NON-NLS-1$
											rd.drawString(Messages.getString("StageMaker.882"), //$NON-NLS-1$
													400 - ftm.stringWidth(
															Messages.getString("StageMaker.883")) / 2, //$NON-NLS-1$
													280);
											repaint();
											final File file = new File(new StringBuilder().append(Messages.getString("StageMaker.884")) //$NON-NLS-1$
													.append(trackname).append(Messages.getString("StageMaker.885")).toString()); //$NON-NLS-1$
											if (!trackname.equals(Messages.getString("StageMaker.886")) && file.exists()) { //$NON-NLS-1$
												final int i_140_ = (int) file.length();
												printwriter
														.println(new StringBuilder().append(Messages.getString("StageMaker.887")).append(trackname) //$NON-NLS-1$
																.append(Messages.getString("StageMaker.888")).append(i_140_).append(Messages.getString("StageMaker.889")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
												string = bufferedreader.readLine();
												if (string != null)
													i_135_ = servervalue(string, 0);
												else
													i_135_ = -2;
												if (i_135_ == 0) {
													final FileInputStream fileinputstream = new FileInputStream(file);
													final byte[] is = new byte[i_140_];
													fileinputstream.read(is);
													fileinputstream.close();
													final DataOutputStream dataoutputstream = new DataOutputStream(
															socket.getOutputStream());
													dataoutputstream.write(is, 0, i_140_);
													string = bufferedreader.readLine();
													if (string != null)
														i_135_ = servervalue(string, 0);
													else
														i_135_ = -2;
												}
												if (i_135_ == -67)
													i_135_ = 0;
											} else {
												printwriter.println(Messages.getString("StageMaker.890")); //$NON-NLS-1$
												string = bufferedreader.readLine();
											}
										}
									}
									socket.close();
								} catch (final Exception exception) {
									i_135_ = -1;
								}
								setCursor(new Cursor(0));
								boolean bool = false;
								if (i_135_ == 0) {
									logged = 1;
									bool = true;
								}
								if (i_135_ == 3) {
									JOptionPane
											.showMessageDialog(null,
													new StringBuilder().append(Messages.getString("StageMaker.891")) //$NON-NLS-1$
															.append(errlo[8]).append(Messages.getString("StageMaker.892")).toString(), //$NON-NLS-1$
													Messages.getString("StageMaker.893"), 1); //$NON-NLS-1$
									bool = true;
								}
								if (i_135_ == 4) {
									JOptionPane.showMessageDialog(null,
											new StringBuilder()
													.append(Messages.getString("StageMaker.894")) //$NON-NLS-1$
													.append(stagename).append(Messages.getString("StageMaker.895")).append(stagename) //$NON-NLS-1$
													.append(Messages.getString("StageMaker.896")) //$NON-NLS-1$
													.toString(),
											Messages.getString("StageMaker.897"), 1); //$NON-NLS-1$
									bool = true;
								}
								if (i_135_ == 5) {
									JOptionPane.showMessageDialog(null,
											Messages.getString("StageMaker.898"), //$NON-NLS-1$
											Messages.getString("StageMaker.899"), 1); //$NON-NLS-1$
									bool = true;
								}
								if (i_135_ > 5) {
									JOptionPane.showMessageDialog(null,
											Messages.getString("StageMaker.900"), //$NON-NLS-1$
											Messages.getString("StageMaker.901"), 1); //$NON-NLS-1$
									bool = true;
								}
								if (i_135_ == -4) {
									logged = 1;
									JOptionPane.showMessageDialog(null,
											Messages.getString("StageMaker.902"), //$NON-NLS-1$
											Messages.getString("StageMaker.903"), 1); //$NON-NLS-1$
									bool = true;
								}
								if (i_135_ == -3) {
									logged = 1;
									JOptionPane.showMessageDialog(null,
											Messages.getString("StageMaker.904"), //$NON-NLS-1$
											Messages.getString("StageMaker.905"), 1); //$NON-NLS-1$
									bool = true;
								}
								if (i_135_ == -2) {
									logged = 1;
									JOptionPane.showMessageDialog(null,
											Messages.getString("StageMaker.906"), //$NON-NLS-1$
											Messages.getString("StageMaker.907"), 1); //$NON-NLS-1$
									bool = true;
								}
								if (!bool)
									JOptionPane.showMessageDialog(null, Messages.getString("StageMaker.908"), //$NON-NLS-1$
											Messages.getString("StageMaker.909"), 1); //$NON-NLS-1$
							}
						} else
							JOptionPane.showMessageDialog(null,
									new StringBuilder()
											.append(Messages.getString("StageMaker.910")) //$NON-NLS-1$
											.append(errlo[errd - 1]).append(Messages.getString("StageMaker.911")).toString(), //$NON-NLS-1$
									Messages.getString("StageMaker.912"), 0); //$NON-NLS-1$
					}
				}
				if (logged == 3)
					for (int i = 0; i < nms; i++) {
						rd.setColor(new Color(235, 235, 235));
						if (xm > 11 && xm < 789 && ym > 142 + i * 20 && ym < 160 + i * 20)
							rd.setColor(new Color(255, 255, 255));
						rd.fillRect(11, 142 + i * 20, 778, 18);
						rd.setFont(new Font(Messages.getString("StageMaker.913"), 0, 12)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(mystages[i], 180 - ftm.stringWidth(mystages[i]) / 2, 156 + i * 20);
						rd.setColor(new Color(155, 155, 155));
						rd.drawLine(350, 145 + i * 20, 350, 157 + i * 20);
						if (pubt[i] != -1) {
							rd.drawLine(450, 145 + i * 20, 450, 157 + i * 20);
							rd.drawLine(550, 145 + i * 20, 550, 157 + i * 20);
							rd.drawLine(650, 145 + i * 20, 650, 157 + i * 20);
							boolean bool = false;
							if (maker[i].toLowerCase().equals(tnick.getText().toLowerCase())) {
								bool = true;
								rd.setColor(new Color(0, 64, 0));
								rd.drawString(Messages.getString("StageMaker.914"), 400 - ftm.stringWidth(Messages.getString("StageMaker.915")) / 2, 156 + i * 20); //$NON-NLS-1$ //$NON-NLS-2$
							} else {
								rd.setColor(new Color(0, 0, 64));
								rd.drawString(maker[i], 400 - ftm.stringWidth(maker[i]) / 2, 156 + i * 20);
							}
							if (nad[i] > 1) {
								if (ovbutton(
										new StringBuilder().append(Messages.getString("StageMaker.916")).append(nad[i]).append(Messages.getString("StageMaker.917")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
										500, 156 + i * 20)) {
									String string = new StringBuilder().append(Messages.getString("StageMaker.918")).append(mystages[i]) //$NON-NLS-1$
											.append(Messages.getString("StageMaker.919")) //$NON-NLS-1$
											.toString();
									int i_141_ = 0;
									for (int i_142_ = 0; i_142_ < nad[i]; i_142_++) {
										if (++i_141_ == 17) {
											string = new StringBuilder().append(string).append(Messages.getString("StageMaker.920")).toString(); //$NON-NLS-1$
											i_141_ = 1;
										}
										string = new StringBuilder().append(string).append(addeda[i][i_142_])
												.toString();
										if (i_142_ != nad[i] - 1)
											if (i_142_ != nad[i] - 2)
												string = new StringBuilder().append(string).append(Messages.getString("StageMaker.921")).toString(); //$NON-NLS-1$
											else if (i_141_ == 16) {
												string = new StringBuilder().append(string).append(Messages.getString("StageMaker.922")).toString(); //$NON-NLS-1$
												i_141_ = 0;
											} else
												string = new StringBuilder().append(string).append(Messages.getString("StageMaker.923")).toString(); //$NON-NLS-1$
									}
									string = new StringBuilder().append(string).append(Messages.getString("StageMaker.924")).toString(); //$NON-NLS-1$
									JOptionPane.showMessageDialog(null, string, Messages.getString("StageMaker.925"), 1); //$NON-NLS-1$
								}
							} else {
								rd.setColor(new Color(0, 0, 64));
								rd.drawString(Messages.getString("StageMaker.926"), 500 - ftm.stringWidth(Messages.getString("StageMaker.927")) / 2, 156 + i * 20); //$NON-NLS-1$ //$NON-NLS-2$
							}
							if (pubt[i] == 0) {
								rd.setColor(new Color(0, 0, 64));
								rd.drawString(Messages.getString("StageMaker.928"), 600 - ftm.stringWidth(Messages.getString("StageMaker.929")) / 2, 156 + i * 20); //$NON-NLS-1$ //$NON-NLS-2$
							}
							if (pubt[i] == 1) {
								rd.setColor(new Color(0, 0, 64));
								rd.drawString(Messages.getString("StageMaker.930"), 600 - ftm.stringWidth(Messages.getString("StageMaker.931")) / 2, 156 + i * 20); //$NON-NLS-1$ //$NON-NLS-2$
							}
							if (pubt[i] == 2) {
								rd.setColor(new Color(0, 64, 0));
								rd.drawString(Messages.getString("StageMaker.932"), 600 - ftm.stringWidth(Messages.getString("StageMaker.933")) / 2, 156 + i * 20); //$NON-NLS-1$ //$NON-NLS-2$
							}
							if ((pubt[i] == 2 || bool) && ovbutton(Messages.getString("StageMaker.934"), 700, 156 + i * 20)) { //$NON-NLS-1$
								int i_143_ = 0;
								for (int i_144_ = 0; i_144_ < slstage.getItemCount(); i_144_++)
									if (mystages[i].equals(slstage.getItem(i_144_)))
										i_143_ = JOptionPane.showConfirmDialog(null,
												new StringBuilder().append(Messages.getString("StageMaker.935")).append(mystages[i]) //$NON-NLS-1$
														.append(Messages.getString("StageMaker.936")) //$NON-NLS-1$
														.toString(),
												Messages.getString("StageMaker.937"), 0); //$NON-NLS-1$
								if (i_143_ == 0) {
									setCursor(new Cursor(3));
									rd.setFont(new Font(Messages.getString("StageMaker.938"), 1, 13)); //$NON-NLS-1$
									ftm = rd.getFontMetrics();
									rd.setColor(new Color(225, 225, 225));
									rd.fillRect(11, 141, 779, 401);
									rd.setColor(new Color(0, 0, 0));
									rd.drawString(Messages.getString("StageMaker.939"), //$NON-NLS-1$
											400 - ftm.stringWidth(Messages.getString("StageMaker.940")) / 2, 250); //$NON-NLS-1$
									repaint();
									try {
										String string = new StringBuilder()
												.append(Messages.getString("StageMaker.941")) //$NON-NLS-1$
												.append(mystages[i]).append(Messages.getString("StageMaker.942")) //$NON-NLS-1$
												.append((int) (Math.random() * 1000.0)).append(Messages.getString("StageMaker.943")).toString(); //$NON-NLS-1$
										string = string.replace(' ', '_');
										URL url = new URL(string);
										int i_145_ = url.openConnection().getContentLength();
										DataInputStream datainputstream = new DataInputStream(url.openStream());
										byte[] is = new byte[i_145_];
										datainputstream.readFully(is);
										datainputstream.close();
										ZipInputStream zipinputstream;
										if (is[0] == 80 && is[1] == 75 && is[2] == 3)
											zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
										else {
											final byte[] is_146_ = new byte[i_145_ - 40];
											for (int i_147_ = 0; i_147_ < i_145_ - 40; i_147_++) {
												int i_148_ = 20;
												if (i_147_ >= 500)
													i_148_ = 40;
												is_146_[i_147_] = is[i_147_ + i_148_];
											}
											zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_146_));
										}
										final ZipEntry zipentry = zipinputstream.getNextEntry();
										if (zipentry != null) {
											String string_149_ = Messages.getString("StageMaker.944"); //$NON-NLS-1$
											int i_150_ = Integer.valueOf(zipentry.getName()).intValue();
											final byte[] is_151_ = new byte[i_150_];
											int i_152_ = 0;
											int i_153_;
											for (/**/; i_150_ > 0; i_150_ -= i_153_) {
												i_153_ = zipinputstream.read(is_151_, i_152_, i_150_);
												i_152_ += i_153_;
											}
											String string_154_ = new String(is_151_);
											string_154_ = new StringBuilder().append(string_154_).append(Messages.getString("StageMaker.945")) //$NON-NLS-1$
													.toString();
											String string_155_ = Messages.getString("StageMaker.946"); //$NON-NLS-1$
											int i_156_ = 0;
											int i_157_ = string_154_.indexOf(Messages.getString("StageMaker.947"), 0); //$NON-NLS-1$
											while (i_157_ != -1 && i_156_ < string_154_.length()) {
												String string_158_ = string_154_.substring(i_156_, i_157_);
												string_158_ = string_158_.trim();
												i_156_ = i_157_ + 1;
												i_157_ = string_154_.indexOf(Messages.getString("StageMaker.948"), i_156_); //$NON-NLS-1$
												if (!string_158_.startsWith(Messages.getString("StageMaker.949")) //$NON-NLS-1$
														&& !string_158_.startsWith(Messages.getString("StageMaker.950"))) //$NON-NLS-1$
													string_155_ = new StringBuilder().append(string_155_).append(Messages.getString("StageMaker.951")) //$NON-NLS-1$
															.append(string_158_).append(Messages.getString("StageMaker.952")).toString(); //$NON-NLS-1$
												else {
													string_155_ = string_155_.trim();
													string_155_ = new StringBuilder().append(string_155_).append(Messages.getString("StageMaker.953")) //$NON-NLS-1$
															.toString();
												}
												if (string_158_.startsWith(Messages.getString("StageMaker.954"))) //$NON-NLS-1$
													string_149_ = getstring(Messages.getString("StageMaker.955"), string_158_, 0); //$NON-NLS-1$
											}
											string_155_ = string_155_.trim();
											string_155_ = new StringBuilder().append(string_155_).append(Messages.getString("StageMaker.956")) //$NON-NLS-1$
													.toString();
											File file = new File(Messages.getString("StageMaker.957")); //$NON-NLS-1$
											if (!file.exists())
												file.mkdirs();
											file = new File(new StringBuilder().append(Messages.getString("StageMaker.958")).append(mystages[i]) //$NON-NLS-1$
													.append(Messages.getString("StageMaker.959")).toString()); //$NON-NLS-1$
											final BufferedWriter bufferedwriter = new BufferedWriter(
													new FileWriter(file));
											bufferedwriter.write(string_155_);
											bufferedwriter.close();
											zipinputstream.close();
											if (!string_149_.equals(Messages.getString("StageMaker.960"))) //$NON-NLS-1$
												try {
													rd.setColor(new Color(0, 0, 0));
													rd.drawString(Messages.getString("StageMaker.961"), 400 //$NON-NLS-1$
															- ftm.stringWidth(Messages.getString("StageMaker.962")) / 2, //$NON-NLS-1$
															280);
													repaint();
													string = new StringBuilder()
															.append(Messages.getString("StageMaker.963")) //$NON-NLS-1$
															.append(string_149_).append(Messages.getString("StageMaker.964")).toString(); //$NON-NLS-1$
													string = string.replace(' ', '_');
													url = new URL(string);
													i_145_ = url.openConnection().getContentLength();
													file = new File(new StringBuilder().append(Messages.getString("StageMaker.965")) //$NON-NLS-1$
															.append(string_149_).append(Messages.getString("StageMaker.966")).toString()); //$NON-NLS-1$
													if (file.exists())
														if (file.length() == i_145_)
															i_143_ = 1;
														else
															i_143_ = JOptionPane.showConfirmDialog(null,
																	new StringBuilder().append(Messages.getString("StageMaker.967")) //$NON-NLS-1$
																			.append(string_149_)
																			.append(Messages.getString("StageMaker.968")) //$NON-NLS-1$
																			.toString(),
																	Messages.getString("StageMaker.969"), 0); //$NON-NLS-1$
													if (i_143_ == 0) {
														datainputstream = new DataInputStream(url.openStream());
														is = new byte[i_145_];
														datainputstream.readFully(is);
														datainputstream.close();
														final FileOutputStream fileoutputstream = new FileOutputStream(
																file);
														fileoutputstream.write(is);
														fileoutputstream.close();
													}
												} catch (final Exception exception) {
													/* empty */
												}
											setCursor(new Cursor(0));
											JOptionPane.showMessageDialog(null,
													new StringBuilder().append(Messages.getString("StageMaker.970")).append(mystages[i]) //$NON-NLS-1$
															.append(Messages.getString("StageMaker.971")).toString(), //$NON-NLS-1$
													Messages.getString("StageMaker.972"), 1); //$NON-NLS-1$
										} else
											JOptionPane.showMessageDialog(null,
													Messages.getString("StageMaker.973"), //$NON-NLS-1$
													Messages.getString("StageMaker.974"), 1); //$NON-NLS-1$
									} catch (final Exception exception) {
										JOptionPane.showMessageDialog(null,
												Messages.getString("StageMaker.975"), //$NON-NLS-1$
												Messages.getString("StageMaker.976"), 1); //$NON-NLS-1$
									}
								}
							}
						} else
							rd.drawString(Messages.getString("StageMaker.977"), //$NON-NLS-1$
									550 - ftm.stringWidth(Messages.getString("StageMaker.978")) / 2, //$NON-NLS-1$
									156 + i * 20);
						if (ovbutton(Messages.getString("StageMaker.979"), 765, 156 + i * 20) //$NON-NLS-1$
								&& JOptionPane
										.showConfirmDialog(null,
												new StringBuilder().append(Messages.getString("StageMaker.980")).append(mystages[i]) //$NON-NLS-1$
														.append(Messages.getString("StageMaker.981")).toString(), //$NON-NLS-1$
												Messages.getString("StageMaker.982"), 0) == 0) { //$NON-NLS-1$
							setCursor(new Cursor(3));
							int i_160_ = -1;
							try {
								final Socket socket = new Socket(Messages.getString("StageMaker.983"), 7061); //$NON-NLS-1$
								final BufferedReader bufferedreader = new BufferedReader(
										new InputStreamReader(socket.getInputStream()));
								final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
								printwriter.println(new StringBuilder().append(Messages.getString("StageMaker.984")).append(tnick.getText()) //$NON-NLS-1$
										.append(Messages.getString("StageMaker.985")).append(tpass.getText()).append(Messages.getString("StageMaker.986")).append(mystages[i]).append(Messages.getString("StageMaker.987")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
										.toString());
								final String string = bufferedreader.readLine();
								if (string != null)
									i_160_ = servervalue(string, 0);
								socket.close();
							} catch (final Exception exception) {
								i_160_ = -1;
							}
							if (i_160_ == 0)
								logged = 1;
							else {
								setCursor(new Cursor(0));
								JOptionPane.showMessageDialog(null,
										new StringBuilder().append(Messages.getString("StageMaker.988")).append(mystages[i]) //$NON-NLS-1$
												.append(Messages.getString("StageMaker.989")) //$NON-NLS-1$
												.toString(),
										Messages.getString("StageMaker.990"), 1); //$NON-NLS-1$
							}
						}
					}
				if (logged == 2) {
					for (int i = 0; i < nms; i++) {
						rd.setFont(new Font(Messages.getString("StageMaker.991"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.setColor(new Color(225, 225, 225));
						rd.fillRect(50, 150, 600, 150);
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(
								new StringBuilder().append(Messages.getString("StageMaker.992")).append(mystages[i]).append(Messages.getString("StageMaker.993")) //$NON-NLS-1$ //$NON-NLS-2$
										.toString(),
								400 - ftm.stringWidth(new StringBuilder().append(Messages.getString("StageMaker.994")).append(mystages[i]) //$NON-NLS-1$
										.append(Messages.getString("StageMaker.995")).toString()) / 2, //$NON-NLS-1$
								220);
						repaint();
						maker[i] = Messages.getString("StageMaker.996"); //$NON-NLS-1$
						pubt[i] = -1;
						nad[i] = 0;
						String string = Messages.getString("StageMaker.997"); //$NON-NLS-1$
						try {
							String string_161_ = new StringBuilder()
									.append(Messages.getString("StageMaker.998")).append(mystages[i]) //$NON-NLS-1$
									.append(Messages.getString("StageMaker.999")).append((int) (Math.random() * 1000.0)).append(Messages.getString("StageMaker.1000")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
							string_161_ = string_161_.replace(' ', '_');
							final URL url = new URL(string_161_);
							final DataInputStream datainputstream = new DataInputStream(url.openStream());
							while ((string = datainputstream.readLine()) != null) {
								string = new StringBuilder().append(Messages.getString("StageMaker.1001")).append(string.trim()).toString(); //$NON-NLS-1$
								if (string.startsWith(Messages.getString("StageMaker.1002"))) { //$NON-NLS-1$
									maker[i] = getSvalue(Messages.getString("StageMaker.1003"), string, 0); //$NON-NLS-1$
									pubt[i] = getvalue(Messages.getString("StageMaker.1004"), string, 1); //$NON-NLS-1$
									boolean bool = false;
									while (!bool) {
										addeda[i][nad[i]] = getSvalue(Messages.getString("StageMaker.1005"), string, 2 + nad[i]); //$NON-NLS-1$
										if (addeda[i][nad[i]].equals(Messages.getString("StageMaker.1006"))) //$NON-NLS-1$
											bool = true;
										else
											nad[i]++;
									}
								}
							}
						} catch (final Exception exception) {
							/* empty */
						}
					}
					setCursor(new Cursor(0));
					logged = 3;
				}
				if (logged == -1) {
					rd.setFont(new Font(Messages.getString("StageMaker.1007"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.1008"), //$NON-NLS-1$
							400 - ftm.stringWidth(Messages.getString("StageMaker.1009")) / 2, 220); //$NON-NLS-1$
					rd.drawString(Messages.getString("StageMaker.1010"), //$NON-NLS-1$
							400 - ftm.stringWidth(Messages.getString("StageMaker.1011")) / 2, 280); //$NON-NLS-1$
					rd.setFont(new Font(Messages.getString("StageMaker.1012"), 0, 12)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("StageMaker.1013"), //$NON-NLS-1$
							400 - ftm.stringWidth(
									Messages.getString("StageMaker.1014")) / 2, //$NON-NLS-1$
							320);
				}
				if (logged == 1) {
					rd.setColor(new Color(225, 225, 225));
					rd.fillRect(11, 141, 779, 401);
					rd.setFont(new Font(Messages.getString("StageMaker.1015"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("StageMaker.1016"), //$NON-NLS-1$
							400 - ftm.stringWidth(Messages.getString("StageMaker.1017")) / 2, 220); //$NON-NLS-1$
					repaint();
					nms = 0;
					String string = Messages.getString("StageMaker.1018"); //$NON-NLS-1$
					try {
						final URL url = new URL(new StringBuilder()
								.append(Messages.getString("StageMaker.1019")).append(tnick.getText()) //$NON-NLS-1$
								.append(Messages.getString("StageMaker.1020")).append((int) (Math.random() * 1000.0)).append(Messages.getString("StageMaker.1021")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						final DataInputStream datainputstream = new DataInputStream(url.openStream());
						while ((string = datainputstream.readLine()) != null) {
							string = new StringBuilder().append(Messages.getString("StageMaker.1022")).append(string.trim()).toString(); //$NON-NLS-1$
							if (string.startsWith(Messages.getString("StageMaker.1023"))) { //$NON-NLS-1$
								boolean bool = true;
								while (bool && nms < 20) {
									mystages[nms] = getSvalue(Messages.getString("StageMaker.1024"), string, nms); //$NON-NLS-1$
									if (mystages[nms].equals(Messages.getString("StageMaker.1025"))) //$NON-NLS-1$
										bool = false;
									else
										nms++;
								}
							}
						}
						if (nms > 0)
							logged = 2;
						else {
							setCursor(new Cursor(0));
							logged = -1;
						}
						datainputstream.close();
					} catch (final Exception exception) {
						final String string_162_ = new StringBuilder().append(Messages.getString("StageMaker.1026")).append(exception).toString(); //$NON-NLS-1$
						if (string_162_.indexOf(Messages.getString("StageMaker.1027")) != -1) { //$NON-NLS-1$
							setCursor(new Cursor(0));
							logged = -1;
						} else {
							logged = 0;
							JOptionPane.showMessageDialog(null,
									Messages.getString("StageMaker.1028"), //$NON-NLS-1$
									Messages.getString("StageMaker.1029"), 1); //$NON-NLS-1$
						}
					}
				}
				if (logged == 0) {
					rd.setFont(new Font(Messages.getString("StageMaker.1030"), 0, 12)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("StageMaker.1031"), //$NON-NLS-1$
							400 - ftm.stringWidth(
									Messages.getString("StageMaker.1032")) / 2, //$NON-NLS-1$
							180);
					rd.setFont(new Font(Messages.getString("StageMaker.1033"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("StageMaker.1034"), //$NON-NLS-1$
							400 - ftm.stringWidth(Messages.getString("StageMaker.1035")) / 2, 220); //$NON-NLS-1$
					rd.drawString(Messages.getString("StageMaker.1036"), 376 - ftm.stringWidth(Messages.getString("StageMaker.1037")) - 14, 266); //$NON-NLS-1$ //$NON-NLS-2$
					if (!tnick.isShowing())
						tnick.setVisible(true);
					movefield(tnick, 376, 250, 129, 23);
					rd.drawString(Messages.getString("StageMaker.1038"), 376 - ftm.stringWidth(Messages.getString("StageMaker.1039")) - 14, 296); //$NON-NLS-1$ //$NON-NLS-2$
					if (!tpass.isShowing())
						tpass.setVisible(true);
					movefield(tpass, 376, 280, 129, 23);
					if (button(Messages.getString("StageMaker.1040"), 400, 340, 0, true)) { //$NON-NLS-1$
						setCursor(new Cursor(3));
						int i = -1;
						try {
							final Socket socket = new Socket(Messages.getString("StageMaker.1041"), 7061); //$NON-NLS-1$
							final BufferedReader bufferedreader = new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
							final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
							printwriter.println(new StringBuilder().append(Messages.getString("StageMaker.1042")).append(tnick.getText().toLowerCase()) //$NON-NLS-1$
									.append(Messages.getString("StageMaker.1043")).append(tpass.getText()).append(Messages.getString("StageMaker.1044")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
							final String string = bufferedreader.readLine();
							if (string != null)
								i = servervalue(string, 0);
							socket.close();
						} catch (final Exception exception) {
							i = -1;
						}
						if (i == 0 || i == 3 || i > 10) {
							tnick.setVisible(false);
							tpass.setVisible(false);
							logged = 1;
							savesettings();
						}
						if (i == 1 || i == 2) {
							setCursor(new Cursor(0));
							JOptionPane.showMessageDialog(null, Messages.getString("StageMaker.1045"), //$NON-NLS-1$
									Messages.getString("StageMaker.1046"), 0); //$NON-NLS-1$
						}
						if (i == -167) {
							setCursor(new Cursor(0));
							JOptionPane.showMessageDialog(null,
									Messages.getString("StageMaker.1047"), //$NON-NLS-1$
									Messages.getString("StageMaker.1048"), 0); //$NON-NLS-1$
						}
						if (i == -1) {
							setCursor(new Cursor(0));
							JOptionPane.showMessageDialog(null,
									Messages.getString("StageMaker.1049"), //$NON-NLS-1$
									Messages.getString("StageMaker.1050"), 1); //$NON-NLS-1$
						}
					}
					rd.setFont(new Font(Messages.getString("StageMaker.1051"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("StageMaker.1052"), 400 - ftm.stringWidth(Messages.getString("StageMaker.1053")) / 2, 450); //$NON-NLS-1$ //$NON-NLS-2$
					if (button(Messages.getString("StageMaker.1054"), 400, 480, 0, true)) //$NON-NLS-1$
						Madness.openurl(Messages.getString("StageMaker.1055")); //$NON-NLS-1$
					rd.setFont(new Font(Messages.getString("StageMaker.1056"), 0, 12)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("StageMaker.1057"), //$NON-NLS-1$
							400 - ftm.stringWidth(Messages.getString("StageMaker.1058")) / 2, 505); //$NON-NLS-1$
				}
			}
			if (tabed != tab)
				if (tabed == -2)
					tabed = -1;
				else
					tabed = tab;
			rd.setColor(new Color(0, 0, 0));
			rd.fillRect(0, 0, 800, 25);
			if (!onbtgame)
				rd.drawImage(btgame[0], 620, 0, null);
			else
				rd.drawImage(btgame[1], 620, 0, null);
			rd.setFont(new Font(Messages.getString("StageMaker.1059"), 1, 13)); //$NON-NLS-1$
			ftm = rd.getFontMetrics();
			final String[] strings = { Messages.getString("StageMaker.1060"), Messages.getString("StageMaker.1061"), Messages.getString("StageMaker.1062"), Messages.getString("StageMaker.1063") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			final int[] is = { 0, 0, 100, 90 };
			final int[] is_163_ = { 0, 25, 25, 0 };
			int i = 4;
			if (stagename.equals(Messages.getString("StageMaker.1064")) || sfase != 0) { //$NON-NLS-1$
				tab = 0;
				i = 1;
			}
			for (int i_164_ = 0; i_164_ < i; i_164_++) {
				rd.setColor(new Color(170, 170, 170));
				if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25)
					rd.setColor(new Color(200, 200, 200));
				if (tab == i_164_)
					rd.setColor(new Color(225, 225, 225));
				rd.fillPolygon(is, is_163_, 4);
				rd.setColor(new Color(0, 0, 0));
				rd.drawString(strings[i_164_], i_164_ * 100 + 45 - ftm.stringWidth(strings[i_164_]) / 2, 17);
				if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25 && mouses == -1)
					tab = i_164_;
				for (int i_165_ = 0; i_165_ < 4; i_165_++)
					is[i_165_] += 100;
			}
			if (mouses == -1)
				mouses = 0;
			drawms();
			repaint();
			if (!exwist)
				try {
					if (thredo != null) {
						/* empty */
					}
					Thread.sleep(40L);
				} catch (final InterruptedException interruptedexception) {
					/* empty */
				}
		}
		track.unload();
		track = null;
		rd.dispose();
		System.gc();
	}

	public void savefile() {
		try {
			File file = new File(Messages.getString("StageMaker.1065")); //$NON-NLS-1$
			if (!file.exists())
				file.mkdirs();
			file = new File(new StringBuilder().append(Messages.getString("StageMaker.1066")).append(stagename).append(Messages.getString("StageMaker.1067")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
			bufferedwriter.write(tstage);
			bufferedwriter.write(bstage);
			bufferedwriter.close();
		} catch (final Exception exception) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("StageMaker.1068")).append(exception).toString(), //$NON-NLS-1$
					Messages.getString("StageMaker.1069"), 1); //$NON-NLS-1$
		}
		savesettings();
	}

	public void savesettings() {
		if (!sstage.equals(stagename) || !suser.equals(tnick.getText())) {
			final String string = new StringBuilder().append(Messages.getString("StageMaker.1070")).append(stagename).append(Messages.getString("StageMaker.1071")).append(tnick.getText()) //$NON-NLS-1$ //$NON-NLS-2$
					.append(Messages.getString("StageMaker.1072")).toString(); //$NON-NLS-1$
			sstage = stagename;
			suser = tnick.getText();
			try {
				File file = new File(Messages.getString("StageMaker.1073")); //$NON-NLS-1$
				if (!file.exists())
					file.mkdirs();
				file = new File(Messages.getString("StageMaker.1074")); //$NON-NLS-1$
				final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
				bufferedwriter.write(string);
				bufferedwriter.close();
			} catch (final Exception exception) {
				/* empty */
			}
		}
	}

	public String serverSvalue(final String string, final int i) {
		String string_365_ = Messages.getString("StageMaker.1075"); //$NON-NLS-1$
		try {
			int i_366_ = 0;
			int i_367_ = 0;
			int i_368_ = 0;
			String string_369_ = Messages.getString("StageMaker.1076"); //$NON-NLS-1$
			String string_370_ = Messages.getString("StageMaker.1077"); //$NON-NLS-1$
			for (/**/; i_366_ < string.length() && i_368_ != 2; i_366_++) {
				string_369_ = new StringBuilder().append(Messages.getString("StageMaker.1078")).append(string.charAt(i_366_)).toString(); //$NON-NLS-1$
				if (string_369_.equals(Messages.getString("StageMaker.1079"))) { //$NON-NLS-1$
					i_367_++;
					if (i_368_ == 1 || i_367_ > i)
						i_368_ = 2;
				} else if (i_367_ == i) {
					string_370_ = new StringBuilder().append(string_370_).append(string_369_).toString();
					i_368_ = 1;
				}
			}
			string_365_ = string_370_;
		} catch (final Exception exception) {
			/* empty */
		}
		return string_365_;
	}

	public int servervalue(final String string, final int i) {
		int i_359_ = -1;
		try {
			int i_360_ = 0;
			int i_361_ = 0;
			int i_362_ = 0;
			String string_363_ = Messages.getString("StageMaker.1080"); //$NON-NLS-1$
			String string_364_ = Messages.getString("StageMaker.1081"); //$NON-NLS-1$
			for (/**/; i_360_ < string.length() && i_362_ != 2; i_360_++) {
				string_363_ = new StringBuilder().append(Messages.getString("StageMaker.1082")).append(string.charAt(i_360_)).toString(); //$NON-NLS-1$
				if (string_363_.equals(Messages.getString("StageMaker.1083"))) { //$NON-NLS-1$
					i_361_++;
					if (i_362_ == 1 || i_361_ > i)
						i_362_ = 2;
				} else if (i_361_ == i) {
					string_364_ = new StringBuilder().append(string_364_).append(string_363_).toString();
					i_362_ = 1;
				}
			}
			if (string_364_.equals(Messages.getString("StageMaker.1084"))) //$NON-NLS-1$
				string_364_ = Messages.getString("StageMaker.1085"); //$NON-NLS-1$
			i_359_ = Integer.valueOf(string_364_).intValue();
		} catch (final Exception exception) {
			/* empty */
		}
		return i_359_;
	}

	public void sortop() {
		tstage = new StringBuilder().append(Messages.getString("StageMaker.1086")).append(m.snap[0]).append(Messages.getString("StageMaker.1087")).append(m.snap[1]).append(Messages.getString("StageMaker.1088")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(m.snap[2]).append(Messages.getString("StageMaker.1089")).append(csky[0]).append(Messages.getString("StageMaker.1090")).append(csky[1]).append(Messages.getString("StageMaker.1091")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(csky[2]).append(Messages.getString("StageMaker.1092")).append(cfade[0]).append(Messages.getString("StageMaker.1093")).append(cfade[1]).append(Messages.getString("StageMaker.1094")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(cfade[2]).append(Messages.getString("StageMaker.1095")).append(cldd[0]).append(Messages.getString("StageMaker.1096")).append(cldd[1]).append(Messages.getString("StageMaker.1097")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(cldd[2]).append(Messages.getString("StageMaker.1098")).append(cldd[3]).append(Messages.getString("StageMaker.1099")).append(cldd[4]).append(Messages.getString("StageMaker.1100")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(cgrnd[0]).append(Messages.getString("StageMaker.1101")).append(cgrnd[1]).append(Messages.getString("StageMaker.1102")).append(cgrnd[2]).append(Messages.getString("StageMaker.1103")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(texture[0]).append(Messages.getString("StageMaker.1104")).append(texture[1]).append(Messages.getString("StageMaker.1105")).append(texture[2]).append(Messages.getString("StageMaker.1106")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(texture[3]).append(Messages.getString("StageMaker.1107")).append(origfade).append(Messages.getString("StageMaker.1108")) //$NON-NLS-1$ //$NON-NLS-2$
				.append((m.fogd + 1) / 2 - 1).append(Messages.getString("StageMaker.1109")).append(m.mgen).append(Messages.getString("StageMaker.1110")) //$NON-NLS-1$ //$NON-NLS-2$
				.append(cp.nlaps).append(Messages.getString("StageMaker.1111")).toString(); //$NON-NLS-1$
		if (!trackname.equals(Messages.getString("StageMaker.1112"))) { //$NON-NLS-1$
			final StringBuilder stringbuilder = new StringBuilder();
			final StageMaker stagemaker_239_ = this;
			stagemaker_239_.tstage = stringbuilder.append(stagemaker_239_.tstage).append(Messages.getString("StageMaker.1113")) //$NON-NLS-1$
					.append(trackname).append(Messages.getString("StageMaker.1114")).append(trackvol).append(Messages.getString("StageMaker.1115")).append(tracksize).append(Messages.getString("StageMaker.1116")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					.toString();
		}
		for (int i = 0; i < 3; i++)
			snap[i] = (int) (m.snap[i] / 1.2F + 50.0F);
		if (snap[0] + snap[1] + snap[2] <= 110) {
			final StringBuilder stringbuilder = new StringBuilder();
			final StageMaker stagemaker_240_ = this;
			stagemaker_240_.tstage = stringbuilder.append(stagemaker_240_.tstage).append(Messages.getString("StageMaker.1117")).toString(); //$NON-NLS-1$
		}
		final StringBuilder stringbuilder = new StringBuilder();
		final StageMaker stagemaker_241_ = this;
		stagemaker_241_.tstage = stringbuilder.append(stagemaker_241_.tstage).append(Messages.getString("StageMaker.1118")).toString(); //$NON-NLS-1$
	}

	public void sortstage() {
		final int[] is = new int[nob * 2];
		final int[] is_242_ = new int[nob * 2];
		for (int i = 0; i < nob; i++)
			is[i] = 0;
		int i = 0;
		int i_243_ = 0;
		is_242_[i_243_] = 0;
		i_243_++;
		boolean bool = false;
		int i_244_ = 0;
		while (!bool) {
			final int[] is_245_ = { co[i].x + atp[co[i].colok][0], co[i].x + atp[co[i].colok][2] };
			final int[] is_246_ = { co[i].z + atp[co[i].colok][1], co[i].z + atp[co[i].colok][3] };
			int i_247_ = co[i].roofat;
			if (co[i].colok == 2)
				i_247_ += 30;
			if (co[i].colok == 3)
				i_247_ -= 30;
			if (co[i].colok == 15)
				i_247_ -= 90;
			if (co[i].colok == 20)
				i_247_ -= 180;
			if (co[i].colok == 26)
				i_247_ -= 90;
			rot(is_245_, is_246_, co[i].x, co[i].z, i_247_, 2);
			int i_248_ = -1;
			int i_249_ = -1;
			if (i_244_ != 0)
				for (int i_250_ = 0; i_250_ < nob; i_250_++) {
					boolean bool_251_ = false;
					if (i_243_ == 2 && i_250_ == 0)
						bool_251_ = true;
					if (i != i_250_ && !bool_251_ && is[i_250_] == 0
							&& (co[i_250_].colok <= 14 || co[i_250_].colok >= 33)
							&& (co[i_250_].colok < 39 || co[i_250_].colok >= 46) && co[i_250_].colok < 52) {
						int i_252_ = 0;
						if (co[i_250_].colok != 2 && co[i_250_].colok != 3 && co[i_250_].colok != 4
								&& co[i_250_].colok != 7 && co[i_250_].colok != 9) {
							if (i_244_ == 1 && co[i_250_].z > co[i].z && Math.abs(co[i_250_].x - co[i].x) < 1000
									&& (co[i_250_].roofat == 180 || co[i_250_].roofat == 0))
								i_252_ = 1;
							if (i_244_ == 2 && co[i_250_].z < co[i].z && Math.abs(co[i_250_].x - co[i].x) < 1000
									&& (co[i_250_].roofat == 180 || co[i_250_].roofat == 0))
								i_252_ = 1;
							if (i_244_ == 3 && co[i_250_].x > co[i].x && Math.abs(co[i_250_].z - co[i].z) < 1000
									&& (co[i_250_].roofat == 90 || co[i_250_].roofat == -90))
								i_252_ = 1;
							if (i_244_ == 4 && co[i_250_].x < co[i].x && Math.abs(co[i_250_].z - co[i].z) < 1000
									&& (co[i_250_].roofat == 90 || co[i_250_].roofat == -90))
								i_252_ = 1;
						} else
							i_252_ = 2;
						if (i_252_ != 0) {
							final int[] is_253_ = { co[i_250_].x + atp[co[i_250_].colok][0],
									co[i_250_].x + atp[co[i_250_].colok][2] };
							final int[] is_254_ = { co[i_250_].z + atp[co[i_250_].colok][1],
									co[i_250_].z + atp[co[i_250_].colok][3] };
							i_247_ = co[i_250_].roofat;
							if (co[i_250_].colok == 2)
								i_247_ += 30;
							if (co[i_250_].colok == 3)
								i_247_ -= 30;
							if (co[i_250_].colok == 15)
								i_247_ -= 90;
							if (co[i_250_].colok == 20)
								i_247_ -= 180;
							if (co[i_250_].colok == 26)
								i_247_ -= 90;
							rot(is_253_, is_254_, co[i_250_].x, co[i_250_].z, i_247_, 2);
							if (i_250_ != 0) {
								final int i_256_ = pyn(is_253_[0], is_245_[0], is_254_[0], is_246_[0]);
								if (i_256_ >= 0 && (i_256_ < 100 || i_252_ != 2) && (i_256_ < i_248_ || i_248_ == -1)) {
									i_248_ = i_256_;
									i_249_ = i_250_;
								}
							}
							int i_257_ = pyn(is_253_[1], is_245_[0], is_254_[1], is_246_[0]);
							if (i_257_ >= 0 && (i_257_ < 100 || i_252_ != 2) && (i_257_ < i_248_ || i_248_ == -1)) {
								i_248_ = i_257_;
								i_249_ = i_250_;
							}
							if (i != 0) {
								if (i_250_ != 0) {
									i_257_ = pyn(is_253_[0], is_245_[1], is_254_[0], is_246_[1]);
									if (i_257_ >= 0 && (i_257_ < 100 || i_252_ != 2) && i_257_ < i_248_) {
										i_248_ = i_257_;
										i_249_ = i_250_;
									}
								}
								i_257_ = pyn(is_253_[1], is_245_[1], is_254_[1], is_246_[1]);
								if (i_257_ >= 0 && (i_257_ < 100 || i_252_ != 2) && i_257_ < i_248_) {
									i_248_ = i_257_;
									i_249_ = i_250_;
								}
							}
						}
					}
				}
			if (i_249_ == -1)
				for (int i_258_ = 0; i_258_ < nob; i_258_++) {
					boolean bool_259_ = false;
					if (i_243_ == 2 && i_258_ == 0)
						bool_259_ = true;
					if (i != i_258_ && !bool_259_ && is[i_258_] == 0
							&& (co[i_258_].colok <= 14 || co[i_258_].colok >= 33)
							&& (co[i_258_].colok < 39 || co[i_258_].colok >= 46) && co[i_258_].colok < 52) {
						final int[] is_260_ = { co[i_258_].x + atp[co[i_258_].colok][0],
								co[i_258_].x + atp[co[i_258_].colok][2] };
						final int[] is_261_ = { co[i_258_].z + atp[co[i_258_].colok][1],
								co[i_258_].z + atp[co[i_258_].colok][3] };
						i_247_ = co[i_258_].roofat;
						if (co[i_258_].colok == 2)
							i_247_ += 30;
						if (co[i_258_].colok == 3)
							i_247_ -= 30;
						if (co[i_258_].colok == 15)
							i_247_ -= 90;
						if (co[i_258_].colok == 20)
							i_247_ -= 180;
						if (co[i_258_].colok == 26)
							i_247_ -= 90;
						rot(is_260_, is_261_, co[i_258_].x, co[i_258_].z, i_247_, 2);
						if (i_258_ != 0) {
							final int i_263_ = pyn(is_260_[0], is_245_[0], is_261_[0], is_246_[0]);
							if (i_263_ >= 0 && (i_263_ < i_248_ || i_248_ == -1)) {
								i_248_ = i_263_;
								i_249_ = i_258_;
							}
						}
						int i_264_ = pyn(is_260_[1], is_245_[0], is_261_[1], is_246_[0]);
						if (i_264_ >= 0 && (i_264_ < i_248_ || i_248_ == -1)) {
							i_248_ = i_264_;
							i_249_ = i_258_;
						}
						if (i != 0) {
							if (i_258_ != 0) {
								i_264_ = pyn(is_260_[0], is_245_[1], is_261_[0], is_246_[1]);
								if (i_264_ >= 0 && i_264_ < i_248_) {
									i_248_ = i_264_;
									i_249_ = i_258_;
								}
							}
							i_264_ = pyn(is_260_[1], is_245_[1], is_261_[1], is_246_[1]);
							if (i_264_ >= 0 && i_264_ < i_248_) {
								i_248_ = i_264_;
								i_249_ = i_258_;
							}
						}
					}
				}
			if (i_249_ != -1) {
				i_244_ = 0;
				if (co[i_249_].colok != 2 && co[i_249_].colok != 3 && co[i_249_].colok != 4 && co[i_249_].colok != 7
						&& co[i_249_].colok != 9) {
					if ((co[i_249_].roofat == 180 || co[i_249_].roofat == 0) && co[i_249_].z > co[i].z)
						i_244_ = 1;
					if ((co[i_249_].roofat == 180 || co[i_249_].roofat == 0) && co[i_249_].z < co[i].z)
						i_244_ = 2;
					if ((co[i_249_].roofat == 90 || co[i_249_].roofat == -90) && co[i_249_].x > co[i].x)
						i_244_ = 3;
					if ((co[i_249_].roofat == 90 || co[i_249_].roofat == -90) && co[i_249_].x < co[i].x)
						i_244_ = 4;
				}
				if (co[i_249_].colok == 4 || co[i_249_].colok == 7 || co[i_249_].colok == 9)
					is[i_249_] = 2;
				else
					is[i_249_] = 1;
				if (co[i_249_].colok >= 46 && co[i_249_].colok <= 51)
					is[i_249_] = 6;
				i = i_249_;
				if (i_249_ == 0) {
					is[0] = 1;
					bool = true;
				} else {
					is_242_[i_243_] = i_249_;
					i_243_++;
				}
			} else {
				is[0] = 1;
				bool = true;
			}
		}
		for (int i_265_ = 0; i_265_ < nob; i_265_++)
			if (is[i_265_] == 0 && (co[i_265_].colok <= 14 || co[i_265_].colok >= 33)
					&& (co[i_265_].colok < 39 || co[i_265_].colok >= 46) && co[i_265_].colok < 52) {
				is_242_[i_243_] = i_265_;
				i_243_++;
			}
		for (int i_266_ = 0; i_266_ < i_243_; i_266_++)
			if (co[is_242_[i_266_]].colok >= 46 && co[is_242_[i_266_]].colok <= 51)
				for (int i_267_ = i_266_ + 1; i_267_ < i_243_; i_267_++) {
					final int i_268_ = pyn(co[is_242_[i_266_]].x, co[is_242_[i_267_]].x, co[is_242_[i_266_]].z,
							co[is_242_[i_267_]].z);
					if (i_268_ >= 0 && (co[is_242_[i_267_]].colok < 46 || co[is_242_[i_266_]].colok > 51)
							&& i_268_ < (co[is_242_[i_266_]].maxR + co[is_242_[i_267_]].maxR) / 100
									* ((co[is_242_[i_266_]].maxR + co[is_242_[i_267_]].maxR) / 100)) {
						final int i_269_ = is_242_[i_267_];
						for (int i_270_ = i_267_; i_270_ > i_266_; i_270_--)
							is_242_[i_270_] = is_242_[i_270_ - 1];
						is_242_[i_266_] = i_269_;
						is[is_242_[i_266_]] = 0;
						i_266_++;
					}
				}
		int i_271_ = 1;
		for (int i_272_ = 0; i_272_ < cp.nsp; i_272_++)
			for (int i_273_ = 0; i_273_ < nob; i_273_++)
				if (co[i_273_].wh == i_272_ + 1
						&& (co[i_273_].colok == 30 || co[i_273_].colok == 32 || co[i_273_].colok == 54)) {
					int i_274_ = -1;
					int i_275_ = -1;
					for (int i_276_ = i_271_; i_276_ < i_243_; i_276_++)
						if (co[is_242_[i_276_]].colok != 30 && co[is_242_[i_276_]].colok != 32
								&& co[is_242_[i_276_]].colok != 54) {
							final int i_277_ = pyn(co[i_273_].x, co[is_242_[i_276_]].x, co[i_273_].z,
									co[is_242_[i_276_]].z);
							if (i_277_ >= 0 && (i_277_ < i_274_ || i_274_ == -1)) {
								i_274_ = i_277_;
								i_275_ = i_276_;
							}
						}
					if (i_275_ != -1) {
						is[is_242_[i_275_]] = 0;
						for (int i_278_ = i_243_; i_278_ > i_275_; i_278_--)
							is_242_[i_278_] = is_242_[i_278_ - 1];
						is_242_[i_275_ + 1] = i_273_;
						i_271_ = i_275_ + 1;
						i_243_++;
					} else {
						is_242_[i_243_] = i_273_;
						i_271_ = i_243_;
						i_243_++;
					}
				}
		for (int i_279_ = 0; i_279_ < nob; i_279_++)
			if (co[i_279_].wh == 0 && (co[i_279_].colok == 30 || co[i_279_].colok == 32 || co[i_279_].colok == 54)) {
				int i_280_ = -1;
				int i_281_ = -1;
				for (int i_282_ = i_271_; i_282_ < i_243_; i_282_++)
					if (co[is_242_[i_282_]].colok != 30 && co[is_242_[i_282_]].colok != 32
							&& co[is_242_[i_282_]].colok != 54) {
						final int i_283_ = pyn(co[i_279_].x, co[is_242_[i_282_]].x, co[i_279_].z,
								co[is_242_[i_282_]].z);
						if (i_283_ >= 0 && (i_283_ < i_280_ || i_280_ == -1)) {
							i_280_ = i_283_;
							i_281_ = i_282_;
						}
					}
				if (i_281_ != -1) {
					is[is_242_[i_281_]] = 0;
					for (int i_284_ = i_243_; i_284_ > i_281_; i_284_--)
						is_242_[i_284_] = is_242_[i_284_ - 1];
					is_242_[i_281_ + 1] = i_279_;
					i_243_++;
				} else {
					is_242_[i_243_] = i_279_;
					i_243_++;
				}
			}
		for (int i_285_ = 0; i_285_ < nob; i_285_++)
			if (co[i_285_].colok == 31) {
				int i_286_ = -1;
				int i_287_ = -1;
				for (int i_288_ = 0; i_288_ < i_243_; i_288_++) {
					final int i_289_ = pyn(co[i_285_].x, co[is_242_[i_288_]].x, co[i_285_].z, co[is_242_[i_288_]].z);
					if (i_289_ >= 0 && (i_289_ < i_286_ || i_286_ == -1)) {
						i_286_ = i_289_;
						i_287_ = i_288_;
					}
				}
				if (i_287_ != -1) {
					for (int i_290_ = i_243_; i_290_ > i_287_; i_290_--)
						is_242_[i_290_] = is_242_[i_290_ - 1];
					is_242_[i_287_] = i_285_;
					i_243_++;
				} else {
					is_242_[i_243_] = i_285_;
					i_243_++;
				}
			}
		for (int i_291_ = 0; i_291_ < nob; i_291_++)
			if (co[i_291_].colok == 15 || co[i_291_].colok == 27 || co[i_291_].colok == 28 || co[i_291_].colok == 41
					|| co[i_291_].colok == 44 || co[i_291_].colok == 52 || co[i_291_].colok == 53) {
				int i_292_ = -1;
				for (int i_293_ = 0; i_293_ < i_243_; i_293_++)
					if ((co[is_242_[i_293_]].colok <= 14 || co[is_242_[i_293_]].colok >= 33)
							&& co[is_242_[i_293_]].colok < 39) {
						final int i_294_ = pyn(co[i_291_].x, co[is_242_[i_293_]].x, co[i_291_].z,
								co[is_242_[i_293_]].z);
						if (i_294_ >= 0 && i_294_ < (co[i_291_].maxR + co[is_242_[i_293_]].maxR) / 100
								* ((co[i_291_].maxR + co[is_242_[i_293_]].maxR) / 100))
							i_292_ = i_293_;
					}
				if (i_292_ != -1) {
					for (int i_295_ = i_243_; i_295_ > i_292_; i_295_--)
						is_242_[i_295_] = is_242_[i_295_ - 1];
					is_242_[i_292_ + 1] = i_291_;
					i_243_++;
				} else {
					is_242_[i_243_] = i_291_;
					i_243_++;
				}
			}
		for (int i_296_ = 0; i_296_ < nob; i_296_++)
			if (co[i_296_].colok >= 16 && co[i_296_].colok <= 25 || co[i_296_].colok == 40 || co[i_296_].colok == 42
					|| co[i_296_].colok == 43 || co[i_296_].colok == 45) {
				int i_297_ = -1;
				for (int i_298_ = 0; i_298_ < i_243_; i_298_++)
					if ((co[is_242_[i_298_]].colok <= 14 || co[is_242_[i_298_]].colok >= 33)
							&& co[is_242_[i_298_]].colok < 39) {
						final int i_299_ = pyn(co[i_296_].x, co[is_242_[i_298_]].x, co[i_296_].z,
								co[is_242_[i_298_]].z);
						if (i_299_ >= 0 && i_299_ < (co[i_296_].maxR + co[is_242_[i_298_]].maxR) / 100
								* ((co[i_296_].maxR + co[is_242_[i_298_]].maxR) / 100)) {
							if (is[is_242_[i_298_]] != 0) {
								is[is_242_[i_298_]] = 0;
								if (co[i_296_].colok != 20)
									is[i_296_] = 3;
								else
									is[i_296_] = 5;
							}
							i_297_ = i_298_;
						}
					}
				if (i_297_ != -1) {
					/* empty */
				}
				if (i_297_ != -1) {
					for (int i_300_ = i_243_; i_300_ > i_297_; i_300_--)
						is_242_[i_300_] = is_242_[i_300_ - 1];
					is_242_[i_297_ + 1] = i_296_;
					i_243_++;
				} else {
					is_242_[i_243_] = i_296_;
					i_243_++;
				}
			}
		for (int i_301_ = 0; i_301_ < nob; i_301_++)
			if (co[i_301_].colok == 26 || co[i_301_].colok == 39) {
				boolean bool_302_ = false;
				if (Math.random() > Math.random()) {
					bool_302_ = true;
					if (co[i_301_].colok == 39)
						if (Math.random() > Math.random())
							bool_302_ = false;
						else if (Math.random() > Math.random())
							bool_302_ = false;
				}
				int i_303_ = -1;
				for (int i_304_ = 0; i_304_ < i_243_; i_304_++)
					if ((co[is_242_[i_304_]].colok <= 14 || co[is_242_[i_304_]].colok >= 33)
							&& co[is_242_[i_304_]].colok < 39) {
						final int i_305_ = pyn(co[i_301_].x, co[is_242_[i_304_]].x, co[i_301_].z,
								co[is_242_[i_304_]].z);
						if (i_305_ >= 0 && i_305_ < (co[i_301_].maxR + co[is_242_[i_304_]].maxR) / 100
								* ((co[i_301_].maxR + co[is_242_[i_304_]].maxR) / 100)) {
							boolean bool_306_ = false;
							if (co[i_301_].colok == 26) {
								if (co[i_301_].roofat == 90 && co[is_242_[i_304_]].x > co[i_301_].x)
									bool_306_ = true;
								if (co[i_301_].roofat == -90 && co[is_242_[i_304_]].x < co[i_301_].x)
									bool_306_ = true;
								if (co[i_301_].roofat == 0 && co[is_242_[i_304_]].z < co[i_301_].z)
									bool_306_ = true;
								if (co[i_301_].roofat == 180 && co[is_242_[i_304_]].z > co[i_301_].z)
									bool_306_ = true;
							}
							if (co[i_301_].colok == 39) {
								if (co[i_301_].roofat == 90 && co[is_242_[i_304_]].z > co[i_301_].z)
									bool_306_ = true;
								if (co[i_301_].roofat == -90 && co[is_242_[i_304_]].z < co[i_301_].z)
									bool_306_ = true;
								if (co[i_301_].roofat == 0 && co[is_242_[i_304_]].x > co[i_301_].x)
									bool_306_ = true;
								if (co[i_301_].roofat == 180 && co[is_242_[i_304_]].x < co[i_301_].x)
									bool_306_ = true;
							}
							if (bool_306_) {
								if (is[is_242_[i_304_]] == 1 && bool_302_) {
									is[is_242_[i_304_]] = 0;
									is[i_301_] = 4;
								}
								i_303_ = i_304_;
							}
						}
					}
				if (i_303_ != -1) {
					for (int i_307_ = i_243_; i_307_ > i_303_; i_307_--)
						is_242_[i_307_] = is_242_[i_307_ - 1];
					is_242_[i_303_ + 1] = i_301_;
					i_243_++;
				} else {
					is_242_[i_243_] = i_301_;
					i_243_++;
				}
			}
		for (int i_308_ = 0; i_308_ < nob; i_308_++)
			if (co[i_308_].colok >= 55 && co[i_308_].colok <= 65 || co[i_308_].colok == 66) {
				is_242_[i_243_] = i_308_;
				i_243_++;
			}
		int i_309_ = 0;
		int i_310_ = 0;
		int i_311_ = 0;
		int i_312_ = 0;
		bstage = Messages.getString("StageMaker.1119"); //$NON-NLS-1$
		for (int i_313_ = 0; i_313_ < i_243_; i_313_++) {
			if (co[is_242_[i_313_]].colok != 30 && co[is_242_[i_313_]].colok != 31 && co[is_242_[i_313_]].colok != 32
					&& co[is_242_[i_313_]].colok != 54 && co[is_242_[i_313_]].colok != 66) {
				String string = Messages.getString("StageMaker.1120"); //$NON-NLS-1$
				if (is[is_242_[i_313_]] == 1)
					string = Messages.getString("StageMaker.1121"); //$NON-NLS-1$
				if (is[is_242_[i_313_]] == 2)
					string = Messages.getString("StageMaker.1122"); //$NON-NLS-1$
				if (is[is_242_[i_313_]] == 3)
					string = Messages.getString("StageMaker.1123"); //$NON-NLS-1$
				if (is[is_242_[i_313_]] == 4)
					string = Messages.getString("StageMaker.1124"); //$NON-NLS-1$
				if (is[is_242_[i_313_]] == 5)
					string = Messages.getString("StageMaker.1125"); //$NON-NLS-1$
				if (is[is_242_[i_313_]] == 6)
					string = Messages.getString("StageMaker.1126"); //$NON-NLS-1$
				final StringBuilder stringbuilder = new StringBuilder();
				final StageMaker stagemaker_314_ = this;
				stagemaker_314_.bstage = stringbuilder.append(stagemaker_314_.bstage).append(Messages.getString("StageMaker.1127")) //$NON-NLS-1$
						.append(co[is_242_[i_313_]].colok + 10).append(Messages.getString("StageMaker.1128")).append(co[is_242_[i_313_]].x).append(Messages.getString("StageMaker.1129")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(co[is_242_[i_313_]].z).append(Messages.getString("StageMaker.1130")).append(co[is_242_[i_313_]].roofat).append(Messages.getString("StageMaker.1131")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(string).append(Messages.getString("StageMaker.1132")).toString(); //$NON-NLS-1$
			}
			if (co[is_242_[i_313_]].colok == 30 || co[is_242_[i_313_]].colok == 32) {
				if (co[is_242_[i_313_]].roofat == 180)
					co[is_242_[i_313_]].roofat = 0;
				String string = Messages.getString("StageMaker.1133"); //$NON-NLS-1$
				if (co[is_242_[i_313_]].wh != 0)
					string = Messages.getString("StageMaker.1134"); //$NON-NLS-1$
				final StringBuilder stringbuilder = new StringBuilder();
				final StageMaker stagemaker_315_ = this;
				stagemaker_315_.bstage = stringbuilder.append(stagemaker_315_.bstage).append(Messages.getString("StageMaker.1135")) //$NON-NLS-1$
						.append(co[is_242_[i_313_]].colok + 10).append(Messages.getString("StageMaker.1136")).append(co[is_242_[i_313_]].x).append(Messages.getString("StageMaker.1137")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(co[is_242_[i_313_]].z).append(Messages.getString("StageMaker.1138")).append(co[is_242_[i_313_]].roofat).append(Messages.getString("StageMaker.1139")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(string).append(Messages.getString("StageMaker.1140")).toString(); //$NON-NLS-1$
			}
			if (co[is_242_[i_313_]].colok == 54) {
				if (co[is_242_[i_313_]].roofat == 180)
					co[is_242_[i_313_]].roofat = 0;
				String string = Messages.getString("StageMaker.1141"); //$NON-NLS-1$
				if (co[is_242_[i_313_]].wh != 0)
					string = Messages.getString("StageMaker.1142"); //$NON-NLS-1$
				final StringBuilder stringbuilder = new StringBuilder();
				final StageMaker stagemaker_316_ = this;
				stagemaker_316_.bstage = stringbuilder.append(stagemaker_316_.bstage).append(Messages.getString("StageMaker.1143")) //$NON-NLS-1$
						.append(co[is_242_[i_313_]].colok + 10).append(Messages.getString("StageMaker.1144")).append(co[is_242_[i_313_]].x).append(Messages.getString("StageMaker.1145")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(co[is_242_[i_313_]].z).append(Messages.getString("StageMaker.1146")).append(co[is_242_[i_313_]].roofat).append(Messages.getString("StageMaker.1147")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(co[is_242_[i_313_]].y).append(Messages.getString("StageMaker.1148")).append(string).append(Messages.getString("StageMaker.1149")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
			}
			if (co[is_242_[i_313_]].colok == 31) {
				final StringBuilder stringbuilder = new StringBuilder();
				final StageMaker stagemaker_317_ = this;
				stagemaker_317_.bstage = stringbuilder.append(stagemaker_317_.bstage).append(Messages.getString("StageMaker.1150")) //$NON-NLS-1$
						.append(co[is_242_[i_313_]].colok + 10).append(Messages.getString("StageMaker.1151")).append(co[is_242_[i_313_]].x).append(Messages.getString("StageMaker.1152")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(co[is_242_[i_313_]].z).append(Messages.getString("StageMaker.1153")).append(co[is_242_[i_313_]].y).append(Messages.getString("StageMaker.1154")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(co[is_242_[i_313_]].roofat).append(Messages.getString("StageMaker.1155")).toString(); //$NON-NLS-1$
			}
			if (co[is_242_[i_313_]].colok == 66) {
				final StringBuilder stringbuilder = new StringBuilder();
				final StageMaker stagemaker_318_ = this;
				stagemaker_318_.bstage = stringbuilder.append(stagemaker_318_.bstage).append(Messages.getString("StageMaker.1156")) //$NON-NLS-1$
						.append(co[is_242_[i_313_]].srz).append(Messages.getString("StageMaker.1157")).append(co[is_242_[i_313_]].srx).append(Messages.getString("StageMaker.1158")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(co[is_242_[i_313_]].sry).append(Messages.getString("StageMaker.1159")).append(co[is_242_[i_313_]].x).append(Messages.getString("StageMaker.1160")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(co[is_242_[i_313_]].z).append(Messages.getString("StageMaker.1161")).toString(); //$NON-NLS-1$
			}
			if (co[is_242_[i_313_]].x + co[is_242_[i_313_]].maxR > i_309_)
				i_309_ = co[is_242_[i_313_]].x + co[is_242_[i_313_]].maxR;
			if (co[is_242_[i_313_]].x - co[is_242_[i_313_]].maxR < i_311_)
				i_311_ = co[is_242_[i_313_]].x - co[is_242_[i_313_]].maxR;
			if (co[is_242_[i_313_]].z + co[is_242_[i_313_]].maxR > i_310_)
				i_310_ = co[is_242_[i_313_]].z + co[is_242_[i_313_]].maxR;
			if (co[is_242_[i_313_]].z - co[is_242_[i_313_]].maxR < i_312_)
				i_312_ = co[is_242_[i_313_]].z - co[is_242_[i_313_]].maxR;
		}
		int i_319_ = i_311_ - 0;
		int i_320_ = i_309_ + 0;
		final int i_321_ = (int) ((i_320_ - i_319_) / 4800.0F) + 1;
		int i_322_ = (i_321_ * 4800 - (i_320_ - i_319_)) / 2;
		i_319_ -= i_322_;
		i_320_ += i_322_;
		final int i_323_ = i_319_ + 2400;
		int i_324_ = i_312_ - 0;
		int i_325_ = i_310_ + 0;
		final int i_326_ = (int) ((i_325_ - i_324_) / 4800.0F) + 1;
		i_322_ = (i_326_ * 4800 - (i_325_ - i_324_)) / 2;
		i_324_ -= i_322_;
		i_325_ += i_322_;
		final int i_327_ = i_324_ + 2400;
		final StringBuilder stringbuilder = new StringBuilder();
		final StageMaker stagemaker_328_ = this;
		stagemaker_328_.bstage = stringbuilder.append(stagemaker_328_.bstage).append(Messages.getString("StageMaker.1162")).append(i_326_) //$NON-NLS-1$
				.append(Messages.getString("StageMaker.1163")).append(i_319_).append(Messages.getString("StageMaker.1164")).append(i_327_).append(Messages.getString("StageMaker.1165")).append(i_321_).append(Messages.getString("StageMaker.1166")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				.append(i_324_).append(Messages.getString("StageMaker.1167")).append(i_323_).append(Messages.getString("StageMaker.1168")).append(i_326_).append(Messages.getString("StageMaker.1169")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(i_320_).append(Messages.getString("StageMaker.1170")).append(i_327_).append(Messages.getString("StageMaker.1171")).append(i_321_).append(Messages.getString("StageMaker.1172")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				.append(i_325_).append(Messages.getString("StageMaker.1173")).append(i_323_).append(Messages.getString("StageMaker.1174")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public void start() {
		if (thredo == null)
			thredo = new Thread(this);
		thredo.start();
	}

	@Override
	public void stop() {
		exwist = true;
	}

	@Override
	public void update(final Graphics graphics) {
		paint(graphics);
	}

	public int xs(final int i, int i_341_) {
		if (i_341_ < m.cz)
			i_341_ = m.cz;
		return (i_341_ - m.focus_point) * (m.cx - i) / i_341_ + i;
	}

	public int ys(final int i, int i_342_) {
		if (i_342_ < m.cz)
			i_342_ = m.cz;
		return (i_342_ - m.focus_point) * (m.cy - i) / i_342_ + i;
	}
}
