
/* CarMaker - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.applet.Applet;
import java.awt.AlphaComposite;
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
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JOptionPane;

public class CarMaker extends Applet implements Runnable, ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 7903118983954264757L;
	int actmag = 0;
	String[][] addeda = new String[20][5000];
	int[] adna = { 276, 276, 276, 276, 276, 276 };
	String aply1 = Messages.getString("CarMaker.0"); //$NON-NLS-1$
	String aply2 = Messages.getString("CarMaker.1"); //$NON-NLS-1$
	boolean aplyd1 = false;
	boolean aplyd2 = false;
	int apx = 0;
	int apy = 0;
	int bfo = 0;
	boolean breakbond = false;
	Image[] btgame = new Image[2];
	int btn = 0;
	int[] bw = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] bx = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] by = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	String carname = Messages.getString("CarMaker.2"); //$NON-NLS-1$
	int carsel = 0;
	int[][] carstat = { { 110, 81, 131, 98, 100 }, { 200, 200, 88, 16, 16 }, { 108, 80, 93, 114, 125 },
			{ 146, 119, 100, 83, 72 }, { 109, 85, 141, 96, 93 }, { 128, 98, 102, 109, 123 }, { 115, 139, 96, 117, 133 },
			{ 120, 81, 145, 126, 128 }, { 140, 122, 101, 113, 124 }, { 110, 144, 100, 154, 92 },
			{ 133, 122, 144, 115, 126 }, { 107, 96, 96, 192, 189 }, { 192, 200, 106, 92, 90 },
			{ 88, 104, 88, 200, 200 }, { 148, 150, 197, 95, 90 }, { 112, 128, 120, 192, 128 } };
	String cfont = Messages.getString("CarMaker.3"); //$NON-NLS-1$
	boolean changed = false;
	boolean changed2 = false;
	int[] clas = new int[20];
	Smenu cls = new Smenu(40);
	int clsel = 0;
	int cntchk = 0;
	int cntpls = 0;
	int cntprf = 0;
	Smenu compcar = new Smenu(40);
	ContO[] compo = new ContO[16];
	int compsel = 0;
	int[] crash = { 50, 50, 50 };
	boolean crashleft = false;
	boolean crashok = false;
	soundClip[] crashs = new soundClip[3];
	boolean crashup = false;
	int crshturn = 0;
	Smenu ctheme = new Smenu(40);
	int cthm = 0;
	Color defb;
	Color deff;
	boolean defnow = false;
	boolean down = false;
	int dtab = 0;
	int dtabed = -1;
	TextArea editor = new TextArea(20, 20);
	Smenu engine = new Smenu(40);
	boolean engon = false;
	soundClip[][] engs = new soundClip[5][5];
	int engsel = 0;
	boolean exwist = false;
	String fcol = Messages.getString("CarMaker.4"); //$NON-NLS-1$
	float[] fhsb = { 0.5F, 0.5F, 0.5F };
	int flk = 0;
	boolean focuson = true;
	Smenu fontsel = new Smenu(40);
	boolean forwheels = false;
	FontMetrics ftm;
	int handling = 140;
	int hitmag = 0;
	boolean in = false;
	String lastedo = Messages.getString("CarMaker.5"); //$NON-NLS-1$
	boolean left = false;
	boolean loadedfile = false;
	int logged = 0;
	Image logo;
	soundClip[] lowcrashs = new soundClip[3];
	Medium m = new Medium();
	String[] maker = new String[20];
	boolean minus = false;
	boolean mirror = false;
	boolean mousdr = false;
	int mouseon = -1;
	int mouses = 0;
	boolean multf10 = false;
	String[] mycars = new String[20];
	int[] nad = new int[20];
	int nmc = 0;
	int npolys = 0;
	ContO o;
	boolean objfacend = false;
	String ofcol = Messages.getString("CarMaker.6"); //$NON-NLS-1$
	Image offImage;
	boolean onbtgame = false;
	boolean openm = false;
	int[] oscale = { 100, 100, 100 };
	String oscol = Messages.getString("CarMaker.7"); //$NON-NLS-1$
	boolean out = false;
	int ox = 335;
	int oxy = 0;
	int oxz = -90;
	int oy = 40;
	int oz = 800;
	int ozy = 0;
	boolean[] pessd = { false, false, false, false, false, false, false, false, false, false, false, false, false,
			false, false, false, false, false, false, false, false, false, false, false };
	int pfase = 0;
	boolean pflk = false;
	int[] phys = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
	boolean plus = false;
	String[] pname = { Messages.getString("CarMaker.8"), Messages.getString("CarMaker.9"), Messages.getString("CarMaker.10"), Messages.getString("CarMaker.11"), Messages.getString("CarMaker.12"), Messages.getString("CarMaker.13"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			Messages.getString("CarMaker.14"), Messages.getString("CarMaker.15"), Messages.getString("CarMaker.16"), Messages.getString("CarMaker.17"), Messages.getString("CarMaker.18") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	int[] pnx = { 62, 20, 76, 71, 60, 38, 44, 20, 33, 320, 324 };
	int polynum = -1;
	PopupMenu popupMenu;
	boolean prefs = false;
	int prflk = 0;
	int[] pubt = new int[20];
	Smenu pubtyp = new Smenu(40);
	boolean rateh = false;
	int[] rcrash = { 50, 50, 50 };
	Graphics2D rd;
	boolean right = false;
	boolean rotl = false;
	boolean rotr = false;
	int[] rphys = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
	TextField rplc = new TextField(Messages.getString("CarMaker.19"), 15); //$NON-NLS-1$
	int[] rstat = { 0, 0, 0, 0, 0 };
	int[] scale = { 100, 100, 100 };
	String scar = Messages.getString("CarMaker.20"); //$NON-NLS-1$
	String scol = Messages.getString("CarMaker.21"); //$NON-NLS-1$
	int sfase = 0;
	String sfont = Messages.getString("CarMaker.22"); //$NON-NLS-1$
	float[] shsb = { 0.5F, 0.5F, 0.5F };
	Smenu simcar = new Smenu(40);
	Smenu slcar = new Smenu(2000);
	int sle = -1;
	int sls = -1;
	int squash = 0;
	TextField srch = new TextField(Messages.getString("CarMaker.23"), 15); //$NON-NLS-1$
	int[] stat = { 100, 100, 100, 100, 100 };
	boolean statdef = false;
	int sthm = 0;
	String suser = Messages.getString("CarMaker.24"); //$NON-NLS-1$
	Trackers t = new Trackers();
	int tab = 0;
	int tabed = -1;
	boolean tested = false;
	Thread thredo;
	TextField tnick = new TextField(Messages.getString("CarMaker.25"), 15); //$NON-NLS-1$
	boolean tomany = false;
	TextField tpass = new TextField(Messages.getString("CarMaker.26"), 15); //$NON-NLS-1$
	boolean tutok = false;
	boolean up = false;
	String[] usage = {
			Messages.getString("CarMaker.27"), //$NON-NLS-1$
			Messages.getString("CarMaker.28"), //$NON-NLS-1$
			Messages.getString("CarMaker.29"), //$NON-NLS-1$
			Messages.getString("CarMaker.30"), //$NON-NLS-1$
			Messages.getString("CarMaker.31"), //$NON-NLS-1$
			Messages.getString("CarMaker.32"), //$NON-NLS-1$
			Messages.getString("CarMaker.33"), //$NON-NLS-1$
			Messages.getString("CarMaker.34"), //$NON-NLS-1$
			Messages.getString("CarMaker.35"), //$NON-NLS-1$
			Messages.getString("CarMaker.36"), //$NON-NLS-1$
			Messages.getString("CarMaker.37"), //$NON-NLS-1$
			Messages.getString("CarMaker.38"), //$NON-NLS-1$
			Messages.getString("CarMaker.39"), //$NON-NLS-1$
			Messages.getString("CarMaker.40"), //$NON-NLS-1$
			Messages.getString("CarMaker.41") }; //$NON-NLS-1$
	boolean waso = false;
	Smenu witho = new Smenu(40);
	TextField[] wv = new TextField[16];
	int xm = 0;
	int ym = 0;

	@Override
	public void actionPerformed(final ActionEvent actionevent) {
		TextComponent textcomponent = wv[0];
		if (Madness.textid >= 0 && Madness.textid <= 15)
			textcomponent = wv[Madness.textid];
		if (Madness.textid == 16)
			textcomponent = srch;
		if (Madness.textid == 17)
			textcomponent = rplc;
		if (Madness.textid == 18)
			textcomponent = editor;
		final String string = actionevent.getActionCommand();
		if (string.equals(Messages.getString("CarMaker.42"))) { //$NON-NLS-1$
			final StringSelection stringselection = new StringSelection(textcomponent.getSelectedText());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
			if (Madness.textid == 18)
				editor.replaceText(Messages.getString("CarMaker.43"), editor.getSelectionStart(), editor.getSelectionEnd()); //$NON-NLS-1$
			else
				textcomponent.setText(new StringBuilder()
						.append(textcomponent.getText().substring(0, textcomponent.getSelectionStart()))
						.append(textcomponent.getText().substring(textcomponent.getSelectionEnd(),
								textcomponent.getText().length()))
						.toString());
		}
		if (string.equals(Messages.getString("CarMaker.44"))) { //$NON-NLS-1$
			final StringSelection stringselection = new StringSelection(textcomponent.getSelectedText());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		}
		if (string.equals(Messages.getString("CarMaker.45"))) //$NON-NLS-1$
			try {
				final String string_399_ = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
						.getData(DataFlavor.stringFlavor);
				if (Madness.textid == 18)
					editor.replaceText(string_399_, editor.getSelectionStart(), editor.getSelectionEnd());
				else
					textcomponent.setText(new StringBuilder()
							.append(textcomponent.getText().substring(0, textcomponent.getSelectionStart()))
							.append(string_399_).append(textcomponent.getText()
									.substring(textcomponent.getSelectionEnd(), textcomponent.getText().length()))
							.toString());
			} catch (final Exception exception) {
				/* empty */
			}
		if (string.equals(Messages.getString("CarMaker.46"))) //$NON-NLS-1$
			textcomponent.selectAll();
	}

	public boolean checko(final String string) {
		loadfile();
		setupo();
		if (o.colok < 2) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.47")).append(string) //$NON-NLS-1$
							.append(Messages.getString("CarMaker.48")) //$NON-NLS-1$
							.toString(),
					Messages.getString("CarMaker.49"), 1); //$NON-NLS-1$
			return false;
		}
		/*
		 * boolean bool = true; if ((o).keyz[0] <= 0 || (o).keyx[0] >= 0) bool =
		 * false; if ((o).keyz[1] <= 0 || (o).keyx[1] <= 0) bool = false; if
		 * ((o).keyz[2] >= 0 || (o).keyx[2] >= 0) bool = false; if ((o).keyz[3]
		 * >= 0 || (o).keyx[3] <= 0) bool = false; if (!bool) {
		 * JOptionPane.showMessageDialog(null, new StringBuilder().append(
		 * "Car is not ready for ").append(string).append(
		 * "!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n"
		 * ).toString(), "Car Maker", 1); return false; }
		 */
		if (o.npl <= 0) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.50")).append(string) //$NON-NLS-1$
							.append(Messages.getString("CarMaker.51")) //$NON-NLS-1$
							.toString(),
					Messages.getString("CarMaker.52"), 1); //$NON-NLS-1$
			return false;
		}
		if (o.npl > 10000) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.53")).append(string) //$NON-NLS-1$
							.append(Messages.getString("CarMaker.54")) //$NON-NLS-1$
							.toString(),
					Messages.getString("CarMaker.55"), 1); //$NON-NLS-1$
			return false;
		}
		if (o.maxR > 40000) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.56")).append(string) //$NON-NLS-1$
							.append(Messages.getString("CarMaker.57")) //$NON-NLS-1$
							.append((int) ((o.maxR / 400.0F - 1.0F) * 100.0F)).append(Messages.getString("CarMaker.58")).toString(), //$NON-NLS-1$
					Messages.getString("CarMaker.59"), 1); //$NON-NLS-1$
			return false;
		}
		if (o.maxR < 2) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.60")).append(string) //$NON-NLS-1$
							.append(Messages.getString("CarMaker.61")) //$NON-NLS-1$
							.append((int) ((120.0F / o.maxR - 1.0F) * 100.0F)).append(Messages.getString("CarMaker.62")).toString(), //$NON-NLS-1$
					Messages.getString("CarMaker.63"), 1); //$NON-NLS-1$
			return false;
		}
		final String string_304_ = new StringBuilder().append(Messages.getString("CarMaker.64")).append(editor.getText()).append(Messages.getString("CarMaker.65")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
		int i = 0;
		int i_305_ = string_304_.indexOf(Messages.getString("CarMaker.66"), 0); //$NON-NLS-1$
		boolean bool_306_ = false;
		boolean bool_307_ = false;
		boolean bool_308_ = false;
		while (i_305_ != -1 && i < string_304_.length()) {
			String string_309_ = string_304_.substring(i, i_305_);
			string_309_ = string_309_.trim();
			i = i_305_ + 1;
			i_305_ = string_304_.indexOf(Messages.getString("CarMaker.67"), i); //$NON-NLS-1$
			if (string_309_.startsWith(Messages.getString("CarMaker.68"))) { //$NON-NLS-1$
				bool_306_ = true;
				try {
					int i_310_ = 0;
					for (int i_311_ = 0; i_311_ < 5; i_311_++) {
						stat[i_311_] = getvalue(Messages.getString("CarMaker.69"), string_309_, i_311_); //$NON-NLS-1$
						if (stat[i_311_] > 200)
							bool_306_ = false;
						if (stat[i_311_] < 16)
							bool_306_ = false;
						i_310_ += stat[i_311_];
					}
					if (i_310_ != 680 && i_310_ != 640 && i_310_ != 600 && i_310_ != 560 && i_310_ != 520)
						bool_306_ = false;
				} catch (final Exception exception) {
					bool_306_ = false;
				}
			}
			if (string_309_.startsWith(Messages.getString("CarMaker.70"))) { //$NON-NLS-1$
				bool_307_ = true;
				try {
					for (int i_312_ = 0; i_312_ < 11; i_312_++)
						phys[i_312_] = getvalue(Messages.getString("CarMaker.71"), string_309_, i_312_); //$NON-NLS-1$
					// if (phys[i_312_] > 100)
					// bool_307_ = false;
					// if (phys[i_312_] < 0)
					// bool_307_ = false;
					for (int i_313_ = 0; i_313_ < 3; i_313_++)
						crash[i_313_] = getvalue(Messages.getString("CarMaker.72"), string_309_, i_313_ + 11); //$NON-NLS-1$
					// if (i_313_ != 0 && crash[i_313_] > 100)
					// bool_307_ = false;
					// if (crash[i_313_] < 0)
					// bool_307_ = false;
					engsel = getvalue(Messages.getString("CarMaker.73"), string_309_, 14); //$NON-NLS-1$
					if (engsel > 4)
						bool_307_ = false;
					if (engsel < 0)
						bool_307_ = false;
				} catch (final Exception exception) {
					bool_307_ = false;
				}
			}
			if (string_309_.startsWith(Messages.getString("CarMaker.74"))) { //$NON-NLS-1$
				bool_308_ = true;
				try {
					getvalue(Messages.getString("CarMaker.75"), string_309_, 0); //$NON-NLS-1$
				} catch (final Exception exception) {
					bool_308_ = false;
				}
			}
		}
		if (!bool_306_) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.76")).append(string) //$NON-NLS-1$
							.append(Messages.getString("CarMaker.77")) //$NON-NLS-1$
							.toString(),
					Messages.getString("CarMaker.78"), 1); //$NON-NLS-1$
			return false;
		}
		if (!bool_307_) {
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.79")).append(string) //$NON-NLS-1$
							.append(Messages.getString("CarMaker.80")) //$NON-NLS-1$
							.toString(),
					Messages.getString("CarMaker.81"), 1); //$NON-NLS-1$
			return false;
		}
		if (!bool_308_ && string.equals(Messages.getString("CarMaker.82"))) { //$NON-NLS-1$
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.83")).append(string) //$NON-NLS-1$
							.append(Messages.getString("CarMaker.84")) //$NON-NLS-1$
							.toString(),
					Messages.getString("CarMaker.85"), 1); //$NON-NLS-1$
			return false;
		}
		return true;
	}

	public void crash(float f) {
		if (f > 100.0F)
			f -= 100.0F;
		if (f < -100.0F)
			f += 100.0F;
		if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F)
			lowcrashs[crshturn].play();
		if (Math.abs(f) >= 170.0F)
			crashs[crshturn].play();
		if (Math.abs(f) > 25.0F) {
			if (crashup)
				crshturn--;
			else
				crshturn++;
			if (crshturn == -1)
				crshturn = 2;
			if (crshturn == 3)
				crshturn = 0;
		}
	}

	public void ctachm() {
		int i = -1;
		for (int i_174_ = 0; i_174_ < btn; i_174_++) {
			if (Math.abs(xm - bx[i_174_]) < bw[i_174_] / 2 + 12 && Math.abs(ym - by[i_174_]) < 14 && mouses == 1)
				pessd[i_174_] = true;
			else
				pessd[i_174_] = false;
			if (Math.abs(xm - bx[i_174_]) < bw[i_174_] / 2 + 12 && Math.abs(ym - by[i_174_]) < 14 && mouses == -1)
				i = i_174_;
		}
		if (mouses == -1)
			mouses = 0;
		if (tab == 0) {
			if (sfase == 0) {
				if (i == 0) {
					sfase = 1;
					i = -1;
					hidefields();
				}
				if (i == 1)
					if (!carname.equals(Messages.getString("CarMaker.86"))) { //$NON-NLS-1$
						srch.setText(carname);
						sfase = 2;
						i = -1;
						hidefields();
					} else
						JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.87"), Messages.getString("CarMaker.88"), 1); //$NON-NLS-1$ //$NON-NLS-2$
				if (i == 2)
					delcar(carname);
				if (i == 3) {
					sfase = 3;
					i = -1;
					hidefields();
				}
			}
			if (sfase == 1) {
				if (i == 0) {
					newcar(srch.getText());
					i = -1;
				}
				if (i == 1) {
					srch.setText(Messages.getString("CarMaker.89")); //$NON-NLS-1$
					sfase = 0;
					i = -1;
					hidefields();
				}
			}
			if (sfase == 2) {
				if (i == 0) {
					rencar(srch.getText());
					i = -1;
				}
				if (i == 1) {
					srch.setText(Messages.getString("CarMaker.90")); //$NON-NLS-1$
					sfase = 0;
					i = -1;
					hidefields();
				}
			}
			if (sfase == 3) {
				if (i == 0) {
					File file = null;
					final FileDialog filedialog = new FileDialog(new Frame(), Messages.getString("CarMaker.91")); //$NON-NLS-1$
					filedialog.setFile(Messages.getString("CarMaker.92")); //$NON-NLS-1$
					filedialog.setMode(0);
					filedialog.setVisible(true);
					try {
						if (filedialog.getFile() != null)
							file = new File(new StringBuilder().append(Messages.getString("CarMaker.93")).append(filedialog.getDirectory()).append(Messages.getString("CarMaker.94")) //$NON-NLS-1$ //$NON-NLS-2$
									.append(filedialog.getFile()).append(Messages.getString("CarMaker.95")).toString()); //$NON-NLS-1$
					} catch (final Exception exception) {
						/* empty */
					}
					if (file != null) {
						setCursor(new Cursor(3));
						int i_175_ = 0;
						if (tutok)
							i_175_ = -70;
						rd.setColor(new Color(225, 225, 225));
						rd.fillRect(116, 246 + i_175_, 468, 50);
						rd.setColor(new Color(0, 0, 0));
						rd.setFont(new Font(Messages.getString("CarMaker.96"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.drawString(
								new StringBuilder().append(Messages.getString("CarMaker.97")).append(file.getName()).append(Messages.getString("CarMaker.98")) //$NON-NLS-1$ //$NON-NLS-2$
										.toString(),
								350 - ftm.stringWidth(new StringBuilder().append(Messages.getString("CarMaker.99")).append(file.getName()) //$NON-NLS-1$
										.append(Messages.getString("CarMaker.100")).toString()) / 2, //$NON-NLS-1$
								276 + i_175_);
						repaint();
						final int[] is = new int[6000];
						final int[] is_176_ = new int[6000];
						final int[] is_177_ = new int[6000];
						int i_178_ = 0;
						final int[][] is_179_ = new int[600][100];
						final int[] is_180_ = new int[600];
						int i_181_ = 0;
						if (file.exists()) {
							try {
								final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
								boolean bool = false;
								boolean bool_182_ = false;
								String string;
								while ((string = bufferedreader.readLine()) != null) {
									if (string.startsWith(Messages.getString("CarMaker.101"))) //$NON-NLS-1$
										if (i_178_ < 6000) {
											multf10 = true;
											is[i_178_] = objvalue(string, 0);
											is_176_[i_178_] = objvalue(string, 1);
											is_177_[i_178_] = objvalue(string, 2);
											i_178_++;
										} else
											bool = true;
									if (string.startsWith(Messages.getString("CarMaker.102"))) //$NON-NLS-1$
										if (i_181_ < 600) {
											multf10 = false;
											objfacend = false;
											for (is_180_[i_181_] = 0; !objfacend
													&& is_180_[i_181_] < 100; is_180_[i_181_]++)
												is_179_[i_181_][is_180_[i_181_]] = objvalue(string, is_180_[i_181_]);
											i_181_++;
										} else
											bool_182_ = true;
								}
								if (bool)
									JOptionPane.showMessageDialog(null,
											new StringBuilder().append(Messages.getString("CarMaker.103")) //$NON-NLS-1$
													.append(file.getName())
													.append(Messages.getString("CarMaker.104")) //$NON-NLS-1$
													.toString(),
											Messages.getString("CarMaker.105"), 0); //$NON-NLS-1$
								if (bool_182_)
									JOptionPane.showMessageDialog(null,
											new StringBuilder().append(Messages.getString("CarMaker.106")) //$NON-NLS-1$
													.append(file.getName())
													.append(Messages.getString("CarMaker.107")) //$NON-NLS-1$
													.toString(),
											Messages.getString("CarMaker.108"), 0); //$NON-NLS-1$
								bufferedreader.close();
							} catch (final Exception exception) {
								JOptionPane.showMessageDialog(null, new StringBuilder()
										.append(Messages.getString("CarMaker.109")).append(exception).toString(), //$NON-NLS-1$
										Messages.getString("CarMaker.110"), 1); //$NON-NLS-1$
							}
							rd.setColor(new Color(225, 225, 225));
							rd.fillRect(116, 246 + i_175_, 468, 50);
							rd.setColor(new Color(0, 0, 0));
							rd.setFont(new Font(Messages.getString("CarMaker.111"), 1, 13)); //$NON-NLS-1$
							ftm = rd.getFontMetrics();
							rd.drawString(
									new StringBuilder().append(Messages.getString("CarMaker.112")).append(file.getName()) //$NON-NLS-1$
											.append(Messages.getString("CarMaker.113")).toString(), //$NON-NLS-1$
									350 - ftm.stringWidth(new StringBuilder().append(Messages.getString("CarMaker.114")) //$NON-NLS-1$
											.append(file.getName()).append(Messages.getString("CarMaker.115")).toString()) / 2, //$NON-NLS-1$
									276 + i_175_);
							repaint();
							carname = file.getName();
							if (carname.endsWith(Messages.getString("CarMaker.116"))) //$NON-NLS-1$
								carname = carname.substring(0, carname.length() - 4);
							String string = new StringBuilder().append(Messages.getString("CarMaker.117")).append(carname) //$NON-NLS-1$
									.append(Messages.getString("CarMaker.118")) //$NON-NLS-1$
									.toString();
							for (int i_184_ = 0; i_184_ < i_181_; i_184_++) {
								string = new StringBuilder().append(string).append(Messages.getString("CarMaker.119")) //$NON-NLS-1$
										.toString();
								for (int i_185_ = 0; i_185_ < is_180_[i_184_]; i_185_++)
									if (is_179_[i_184_][i_185_] < 6000) {
										final int i_186_ = is_179_[i_184_][i_185_];
										string = new StringBuilder().append(string).append(Messages.getString("CarMaker.120")).append(is[i_186_]) //$NON-NLS-1$
												.append(Messages.getString("CarMaker.121")).append(-is_176_[i_186_]).append(Messages.getString("CarMaker.122")) //$NON-NLS-1$ //$NON-NLS-2$
												.append(is_177_[i_186_]).append(Messages.getString("CarMaker.123")).toString(); //$NON-NLS-1$
									}
								string = new StringBuilder().append(string).append(Messages.getString("CarMaker.124")).toString(); //$NON-NLS-1$
							}
							string = new StringBuilder().append(string).append(Messages.getString("CarMaker.125")).toString(); //$NON-NLS-1$
							file = new File(Messages.getString("CarMaker.126")); //$NON-NLS-1$
							if (!file.exists())
								file.mkdirs();
							file = new File(
									new StringBuilder().append(Messages.getString("CarMaker.127")).append(carname).append(Messages.getString("CarMaker.128")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
							int i_187_ = 0;
							if (file.exists())
								i_187_ = JOptionPane.showConfirmDialog(null,
										new StringBuilder().append(Messages.getString("CarMaker.129")).append(carname) //$NON-NLS-1$
												.append(Messages.getString("CarMaker.130")).toString(), //$NON-NLS-1$
										Messages.getString("CarMaker.131"), 0); //$NON-NLS-1$
							if (i_187_ == 0)
								try {
									final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
									bufferedwriter.write(string);
									bufferedwriter.close();
									if (file.exists()) {
										sfase = 0;
										hidefields();
										tabed = -1;
									} else {
										carname = Messages.getString("CarMaker.132"); //$NON-NLS-1$
										JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.133"), //$NON-NLS-1$
												Messages.getString("CarMaker.134"), 1); //$NON-NLS-1$
									}
								} catch (final Exception exception) {
									carname = Messages.getString("CarMaker.135"); //$NON-NLS-1$
									JOptionPane.showMessageDialog(null,
											new StringBuilder().append(Messages.getString("CarMaker.136")) //$NON-NLS-1$
													.append(exception).toString(),
											Messages.getString("CarMaker.137"), 1); //$NON-NLS-1$
								}
						} else
							JOptionPane.showMessageDialog(null, new StringBuilder().append(Messages.getString("CarMaker.138")) //$NON-NLS-1$
									.append(file.getName()).append(Messages.getString("CarMaker.139")).toString(), Messages.getString("CarMaker.140"), 1); //$NON-NLS-1$ //$NON-NLS-2$
						setCursor(new Cursor(0));
					}
				}
				if (i == 1) {
					sfase = 4;
					i = -1;
				}
				if (i == 2) {
					sfase = 0;
					i = -1;
				}
			}
			if (sfase == 4) {
				if (i == 0) {
					File file = null;
					final FileDialog filedialog = new FileDialog(new Frame(), Messages.getString("CarMaker.141")); //$NON-NLS-1$
					filedialog.setFile(new StringBuilder().append(Messages.getString("CarMaker.142")).append(carname).append(Messages.getString("CarMaker.143")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
					filedialog.setMode(1);
					filedialog.setVisible(true);
					try {
						if (filedialog.getFile() != null)
							file = new File(new StringBuilder().append(Messages.getString("CarMaker.144")).append(filedialog.getDirectory()).append(Messages.getString("CarMaker.145")) //$NON-NLS-1$ //$NON-NLS-2$
									.append(filedialog.getFile()).append(Messages.getString("CarMaker.146")).toString()); //$NON-NLS-1$
					} catch (final Exception exception) {
						/* empty */
					}
					if (file != null) {
						int i_188_ = 0;
						if (file.exists())
							i_188_ = JOptionPane
									.showConfirmDialog(null,
											new StringBuilder().append(Messages.getString("CarMaker.147")).append(file.getName()) //$NON-NLS-1$
													.append(Messages.getString("CarMaker.148")).toString(), //$NON-NLS-1$
											Messages.getString("CarMaker.149"), 0); //$NON-NLS-1$
						if (i_188_ == 0) {
							setCursor(new Cursor(3));
							setupo();
							final int[] is = new int[6000];
							final int[] is_189_ = new int[6000];
							final int[] is_190_ = new int[6000];
							int i_191_ = 0;
							String string = Messages.getString("CarMaker.150"); //$NON-NLS-1$
							for (int i_192_ = 0; i_192_ < o.npl; i_192_++)
								for (int i_193_ = 0; i_193_ < o.p[i_192_].n; i_193_++) {
									boolean bool = false;
									for (int i_194_ = 0; i_194_ < i_191_; i_194_++)
										if (is[i_194_] == o.p[i_192_].ox[i_193_]
												&& is_189_[i_194_] == o.p[i_192_].oy[i_193_]
												&& is_190_[i_194_] == o.p[i_192_].oz[i_193_])
											bool = true;
									if (!bool && i_191_ < 6000) {
										is[i_191_] = o.p[i_192_].ox[i_193_];
										is_189_[i_191_] = o.p[i_192_].oy[i_193_];
										is_190_[i_191_] = o.p[i_192_].oz[i_193_];
										i_191_++;
									}
								}
							for (int i_195_ = 0; i_195_ < i_191_; i_195_++)
								string = new StringBuilder().append(string).append(Messages.getString("CarMaker.151")).append(is[i_195_] / 10.0F) //$NON-NLS-1$
										.append(Messages.getString("CarMaker.152")).append(-is_189_[i_195_] / 10.0F).append(Messages.getString("CarMaker.153")) //$NON-NLS-1$ //$NON-NLS-2$
										.append(is_190_[i_195_] / 10.0F).append(Messages.getString("CarMaker.154")).toString(); //$NON-NLS-1$
							for (int i_196_ = 0; i_196_ < o.npl; i_196_++)
								if (o.p[i_196_].wz == 0) {
									string = new StringBuilder().append(string).append(Messages.getString("CarMaker.155")).toString(); //$NON-NLS-1$
									for (int i_197_ = 0; i_197_ < o.p[i_196_].n; i_197_++) {
										string = new StringBuilder().append(string).append(Messages.getString("CarMaker.156")).toString(); //$NON-NLS-1$
										for (int i_198_ = 0; i_198_ < i_191_; i_198_++)
											if (is[i_198_] == o.p[i_196_].ox[i_197_]
													&& is_189_[i_198_] == o.p[i_196_].oy[i_197_]
													&& is_190_[i_198_] == o.p[i_196_].oz[i_197_])
												string = new StringBuilder().append(string).append(Messages.getString("CarMaker.157")) //$NON-NLS-1$
														.append(i_198_ + 1).toString();
									}
									string = new StringBuilder().append(string).append(Messages.getString("CarMaker.158")).toString(); //$NON-NLS-1$
								}
							try {
								final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
								bufferedwriter.write(string);
								bufferedwriter.close();
								if (file.exists()) {
									JOptionPane.showMessageDialog(null,
											new StringBuilder().append(Messages.getString("CarMaker.159")) //$NON-NLS-1$
													.append(file.getAbsolutePath()).append(Messages.getString("CarMaker.160")) //$NON-NLS-1$
													.toString(),
											Messages.getString("CarMaker.161"), 1); //$NON-NLS-1$
									sfase = 0;
									hidefields();
									tabed = -1;
								} else
									JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.162"), //$NON-NLS-1$
											Messages.getString("CarMaker.163"), 1); //$NON-NLS-1$
							} catch (final Exception exception) {
								JOptionPane.showMessageDialog(null,
										new StringBuilder().append(Messages.getString("CarMaker.164")) //$NON-NLS-1$
												.append(exception).toString(),
										Messages.getString("CarMaker.165"), 1); //$NON-NLS-1$
							}
							setCursor(new Cursor(0));
						}
					}
				}
				if (i == 1) {
					sfase = 0;
					i = -1;
				}
			}
		}
		if (tab == 1) {
			if (i == 0)
				if (prefs)
					prefs = false;
				else
					prefs = true;
			if (i == 1 || i == 2) {
				savefile();
				if (i == 2)
					tab = 2;
			}
			if (!mirror) {
				boolean bool = false;
				if (i == 4) {
					if (sls != -1 && sle != -1 && editor.getSelectedText().equals(srch.getText())) {
						editor.replaceText(rplc.getText(), sls, sle);
						sls = -1;
						sle = -1;
						bool = true;
						try {
							if (thredo != null) {
								/* empty */
							}
							Thread.sleep(100L);
						} catch (final InterruptedException interruptedexception) {
							/* empty */
						}
					}
					i = 3;
				}
				if (i == 3 && !srch.getText().equals(Messages.getString("CarMaker.166"))) { //$NON-NLS-1$
					editor.requestFocus();
					sls = editor.getText().indexOf(srch.getText(), editor.getSelectionEnd());
					if (sls != -1) {
						sle = sls + srch.getText().length();
						editor.select(sls, sle);
					} else if (!bool)
						JOptionPane.showMessageDialog(null, new StringBuilder().append(Messages.getString("CarMaker.167")) //$NON-NLS-1$
								.append(srch.getText()).append(Messages.getString("CarMaker.168")).toString(), Messages.getString("CarMaker.169"), //$NON-NLS-1$ //$NON-NLS-2$
								1);
				}
			} else {
				if (i == 3 || i == 4 || i == 5) {
					final String string = new StringBuilder().append(Messages.getString("CarMaker.170")).append(editor.getSelectedText()).append(Messages.getString("CarMaker.171")) //$NON-NLS-1$ //$NON-NLS-2$
							.toString();
					String string_199_ = Messages.getString("CarMaker.172"); //$NON-NLS-1$
					if (cntpls == 1)
						string_199_ = new StringBuilder().append(string_199_)
								.append(Messages.getString("CarMaker.173")).toString(); //$NON-NLS-1$
					else
						string_199_ = new StringBuilder().append(string_199_).append(Messages.getString("CarMaker.174")).append(cntpls) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.175")).toString(); //$NON-NLS-1$
					if (i == 3)
						string_199_ = new StringBuilder().append(string_199_).append(Messages.getString("CarMaker.176")).toString(); //$NON-NLS-1$
					if (i == 4)
						string_199_ = new StringBuilder().append(string_199_).append(Messages.getString("CarMaker.177")).toString(); //$NON-NLS-1$
					if (i == 5)
						string_199_ = new StringBuilder().append(string_199_).append(Messages.getString("CarMaker.178")).toString(); //$NON-NLS-1$
					string_199_ = new StringBuilder().append(string_199_).append(Messages.getString("CarMaker.179")).toString(); //$NON-NLS-1$
					int i_200_ = 0;
					int i_201_ = string.indexOf(Messages.getString("CarMaker.180"), 0); //$NON-NLS-1$
					while (i_201_ != -1 && i_200_ < string.length()) {
						String string_202_ = string.substring(i_200_, i_201_);
						string_202_ = string_202_.trim();
						i_200_ = i_201_ + 1;
						i_201_ = string.indexOf(Messages.getString("CarMaker.181"), i_200_); //$NON-NLS-1$
						if (string_202_.startsWith(Messages.getString("CarMaker.182"))) //$NON-NLS-1$
							string_202_ = new StringBuilder().append(Messages.getString("CarMaker.183")) //$NON-NLS-1$
									.append(string_202_.substring(4, string_202_.length())).append(Messages.getString("CarMaker.184")).toString(); //$NON-NLS-1$
						else if (string_202_.startsWith(Messages.getString("CarMaker.185"))) //$NON-NLS-1$
							string_202_ = new StringBuilder().append(Messages.getString("CarMaker.186")) //$NON-NLS-1$
									.append(string_202_.substring(3, string_202_.length())).append(Messages.getString("CarMaker.187")).toString(); //$NON-NLS-1$
						if (i == 3)
							if (string_202_.startsWith(Messages.getString("CarMaker.188"))) //$NON-NLS-1$
								string_202_ = new StringBuilder().append(Messages.getString("CarMaker.189")) //$NON-NLS-1$
										.append(string_202_.substring(3, string_202_.length())).append(Messages.getString("CarMaker.190")).toString(); //$NON-NLS-1$
							else if (string_202_.startsWith(Messages.getString("CarMaker.191"))) //$NON-NLS-1$
								string_202_ = new StringBuilder().append(Messages.getString("CarMaker.192")) //$NON-NLS-1$
										.append(string_202_.substring(2, string_202_.length())).append(Messages.getString("CarMaker.193")).toString(); //$NON-NLS-1$
						if (i == 4 && string_202_.startsWith(Messages.getString("CarMaker.194"))) { //$NON-NLS-1$
							final int i_203_ = string_202_.indexOf(Messages.getString("CarMaker.195"), 0); //$NON-NLS-1$
							if (i_203_ >= 0)
								if (string_202_.startsWith(Messages.getString("CarMaker.196"), i_203_)) //$NON-NLS-1$
									string_202_ = new StringBuilder().append(Messages.getString("CarMaker.197")) //$NON-NLS-1$
											.append(string_202_.substring(0, i_203_)).append(Messages.getString("CarMaker.198")) //$NON-NLS-1$
											.append(string_202_.substring(i_203_ + 2, string_202_.length())).append(Messages.getString("CarMaker.199")) //$NON-NLS-1$
											.toString();
								else if (string_202_.startsWith(Messages.getString("CarMaker.200"), i_203_)) //$NON-NLS-1$
									string_202_ = new StringBuilder().append(Messages.getString("CarMaker.201")) //$NON-NLS-1$
											.append(string_202_.substring(0, i_203_)).append(Messages.getString("CarMaker.202")) //$NON-NLS-1$
											.append(string_202_.substring(i_203_ + 1, string_202_.length())).append(Messages.getString("CarMaker.203")) //$NON-NLS-1$
											.toString();
						}
						if (i == 5 && string_202_.startsWith(Messages.getString("CarMaker.204"))) { //$NON-NLS-1$
							int i_204_ = string_202_.indexOf(Messages.getString("CarMaker.205"), 0); //$NON-NLS-1$
							i_204_ = string_202_.indexOf(Messages.getString("CarMaker.206"), i_204_ + 1); //$NON-NLS-1$
							if (i_204_ >= 0)
								if (string_202_.startsWith(Messages.getString("CarMaker.207"), i_204_)) //$NON-NLS-1$
									string_202_ = new StringBuilder().append(Messages.getString("CarMaker.208")) //$NON-NLS-1$
											.append(string_202_.substring(0, i_204_)).append(Messages.getString("CarMaker.209")) //$NON-NLS-1$
											.append(string_202_.substring(i_204_ + 2, string_202_.length())).append(Messages.getString("CarMaker.210")) //$NON-NLS-1$
											.toString();
								else if (string_202_.startsWith(Messages.getString("CarMaker.211"), i_204_)) //$NON-NLS-1$
									string_202_ = new StringBuilder().append(Messages.getString("CarMaker.212")) //$NON-NLS-1$
											.append(string_202_.substring(0, i_204_)).append(Messages.getString("CarMaker.213")) //$NON-NLS-1$
											.append(string_202_.substring(i_204_ + 1, string_202_.length())).append(Messages.getString("CarMaker.214")) //$NON-NLS-1$
											.toString();
						}
						string_199_ = new StringBuilder().append(string_199_).append(Messages.getString("CarMaker.215")).append(string_202_) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.216")).toString(); //$NON-NLS-1$
					}
					string_199_ = new StringBuilder().append(string_199_).append(Messages.getString("CarMaker.217")).toString(); //$NON-NLS-1$
					editor.insertText(string_199_, editor.getSelectionEnd());
				}
				if (i == 6) {
					polynum = 0;
					int i_205_ = editor.getText().lastIndexOf(Messages.getString("CarMaker.218"), editor.getSelectionStart()); //$NON-NLS-1$
					boolean bool = false;
					for (/**/; i_205_ >= 0; i_205_--)
						if (!bool) {
							i_205_ = editor.getText().lastIndexOf(Messages.getString("CarMaker.219"), i_205_); //$NON-NLS-1$
							if (i_205_ != -1) {
								bool = true;
								polynum++;
							}
						} else {
							i_205_ = editor.getText().lastIndexOf(Messages.getString("CarMaker.220"), i_205_); //$NON-NLS-1$
							if (i_205_ != -1)
								bool = false;
						}
					prflk = 0;
					tab = 2;
				}
			}
			i = -1;
		}
		if (tab == 2) {
			int i_206_ = 0;
			if (dtab == 1)
				if (o.colok != 2) {
					if (i == 0) {
						JOptionPane.showMessageDialog(null,
								Messages.getString("CarMaker.221"), //$NON-NLS-1$
								Messages.getString("CarMaker.222"), 1); //$NON-NLS-1$
						final String string = new StringBuilder().append(Messages.getString("CarMaker.223")).append(editor.getText()).append(Messages.getString("CarMaker.224")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						int i_207_ = 0;
						int i_208_ = string.indexOf(Messages.getString("CarMaker.225"), 0); //$NON-NLS-1$
						int i_209_ = 0;
						String string_210_ = Messages.getString("CarMaker.226"); //$NON-NLS-1$
						String string_211_ = Messages.getString("CarMaker.227"); //$NON-NLS-1$
						while (i_208_ != -1 && i_207_ < string.length() && i_209_ != 2) {
							String string_212_ = string.substring(i_207_, i_208_);
							string_212_ = string_212_.trim();
							i_207_ = i_208_ + 1;
							i_208_ = string.indexOf(Messages.getString("CarMaker.228"), i_207_); //$NON-NLS-1$
							if (string_212_.startsWith(Messages.getString("CarMaker.229"))) { //$NON-NLS-1$
								final String string_213_ = string_212_.substring(1, string_212_.indexOf(Messages.getString("CarMaker.230")) + 1); //$NON-NLS-1$
								if (i_209_ == 1 && !string_213_.equals(string_211_)) {
									string_210_ = new StringBuilder().append(string_210_).append(Messages.getString("CarMaker.231")) //$NON-NLS-1$
											.append(string_213_).append(Messages.getString("CarMaker.232")).toString(); //$NON-NLS-1$
									i_209_ = 2;
								}
								if (i_209_ == 0) {
									string_211_ = string_213_;
									string_210_ = new StringBuilder().append(Messages.getString("CarMaker.233")).append(string_213_) //$NON-NLS-1$
											.append(Messages.getString("CarMaker.234")).toString(); //$NON-NLS-1$
									i_209_ = 1;
								}
							}
						}
						if (i_209_ == 0) {
							string_210_ = Messages.getString("CarMaker.235"); //$NON-NLS-1$
							i_209_ = 2;
						}
						if (i_209_ == 1) {
							string_210_ = new StringBuilder().append(string_210_).append(Messages.getString("CarMaker.236")) //$NON-NLS-1$
									.toString();
							i_209_ = 2;
						}
						final int i_214_ = editor.getText().indexOf(Messages.getString("CarMaker.237"), 0); //$NON-NLS-1$
						editor.insertText(string_210_, i_214_);
						editor.select(i_214_, i_214_ + string_210_.length() - 2);
						breakbond = true;
						tab = 1;
					}
					i_206_ = 1;
				} else {
					if (i == 0) {
						ofcol = new StringBuilder().append(Messages.getString("CarMaker.238")).append(o.fcol[0]).append(Messages.getString("CarMaker.239")).append(o.fcol[1]) //$NON-NLS-1$ //$NON-NLS-2$
								.append(Messages.getString("CarMaker.240")).append(o.fcol[2]).append(Messages.getString("CarMaker.241")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						int i_215_ = editor.getText().indexOf(ofcol, 0);
						final int i_216_ = i_215_;
						for (/**/; i_215_ != -1; i_215_ = editor.getText().indexOf(ofcol, i_215_ + 1))
							editor.replaceText(fcol, i_215_, i_215_ + ofcol.length());
						ofcol = fcol;
						editor.select(i_216_ - 8, i_216_ - 8);
						savefile();
						o.fcol[0] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getRed();
						o.fcol[1] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getGreen();
						o.fcol[2] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getBlue();
					}
					if (i == 1) {
						oscol = new StringBuilder().append(Messages.getString("CarMaker.242")).append(o.scol[0]).append(Messages.getString("CarMaker.243")).append(o.scol[1]) //$NON-NLS-1$ //$NON-NLS-2$
								.append(Messages.getString("CarMaker.244")).append(o.scol[2]).append(Messages.getString("CarMaker.245")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						int i_217_ = editor.getText().indexOf(oscol, 0);
						final int i_218_ = i_217_;
						for (/**/; i_217_ != -1; i_217_ = editor.getText().indexOf(oscol, i_217_ + 1))
							editor.replaceText(scol, i_217_, i_217_ + oscol.length());
						oscol = scol;
						editor.select(i_218_ - 8, i_218_ - 8);
						savefile();
						o.scol[0] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getRed();
						o.scol[1] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getGreen();
						o.scol[2] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getBlue();
					}
					i_206_ = 2;
				}
			if (dtab == 2) {
				if (i == 9) {
					scale[0] = 100;
					scale[1] = 100;
					scale[2] = 100;
				}
				if (i == 0 || i == 1 || i == 6 || i == 7 || i == 9) {
					if (i == 0 || i == 6)
						scale[0] -= 5;
					if (i == 1 || i == 7)
						scale[0] += 5;
					if (scale[0] < 0)
						scale[0] = 0;
					int i_219_ = editor.getText().indexOf(Messages.getString("CarMaker.246"), 0); //$NON-NLS-1$
					if (i_219_ != -1) {
						i_219_++;
						final int i_220_ = editor.getText().indexOf(Messages.getString("CarMaker.247"), i_219_); //$NON-NLS-1$
						final int i_221_ = editor.getText().indexOf(Messages.getString("CarMaker.248"), i_219_); //$NON-NLS-1$
						if (i_221_ > i_220_)
							editor.replaceText(
									new StringBuilder().append(Messages.getString("CarMaker.249")).append(scale[0]).append(Messages.getString("CarMaker.250")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_219_, i_220_ + 1);
						else
							editor.replaceText(
									new StringBuilder().append(Messages.getString("CarMaker.251")).append(scale[0]).append(Messages.getString("CarMaker.252")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_219_, i_221_);
					} else {
						final int i_222_ = editor.getText().indexOf(Messages.getString("CarMaker.253"), 0); //$NON-NLS-1$
						final int i_223_ = editor.getText().indexOf(Messages.getString("CarMaker.254"), 0); //$NON-NLS-1$
						if (i_223_ < i_222_ && i_223_ != -1)
							editor.insertText(
									new StringBuilder().append(Messages.getString("CarMaker.255")).append(scale[0]).append(Messages.getString("CarMaker.256")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_223_);
						else
							editor.insertText(
									new StringBuilder().append(Messages.getString("CarMaker.257")).append(scale[0]).append(Messages.getString("CarMaker.258")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_222_);
					}
				}
				if (i == 2 || i == 3 || i == 6 || i == 7 || i == 9) {
					if (i == 2 || i == 6)
						scale[1] -= 5;
					if (i == 3 || i == 7)
						scale[1] += 5;
					if (scale[1] < 0)
						scale[1] = 0;
					int i_224_ = editor.getText().indexOf(Messages.getString("CarMaker.259"), 0); //$NON-NLS-1$
					if (i_224_ != -1) {
						i_224_++;
						final int i_225_ = editor.getText().indexOf(Messages.getString("CarMaker.260"), i_224_); //$NON-NLS-1$
						final int i_226_ = editor.getText().indexOf(Messages.getString("CarMaker.261"), i_224_); //$NON-NLS-1$
						if (i_226_ > i_225_)
							editor.replaceText(
									new StringBuilder().append(Messages.getString("CarMaker.262")).append(scale[1]).append(Messages.getString("CarMaker.263")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_224_, i_225_ + 1);
						else
							editor.replaceText(
									new StringBuilder().append(Messages.getString("CarMaker.264")).append(scale[1]).append(Messages.getString("CarMaker.265")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_224_, i_226_);
					} else {
						final int i_227_ = editor.getText().indexOf(Messages.getString("CarMaker.266"), 0); //$NON-NLS-1$
						final int i_228_ = editor.getText().indexOf(Messages.getString("CarMaker.267"), 0); //$NON-NLS-1$
						if (i_228_ < i_227_ && i_228_ != -1)
							editor.insertText(
									new StringBuilder().append(Messages.getString("CarMaker.268")).append(scale[1]).append(Messages.getString("CarMaker.269")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_228_);
						else
							editor.insertText(
									new StringBuilder().append(Messages.getString("CarMaker.270")).append(scale[1]).append(Messages.getString("CarMaker.271")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_227_);
					}
				}
				if (i == 4 || i == 5 || i == 6 || i == 7 || i == 9) {
					if (i == 4 || i == 6)
						scale[2] -= 5;
					if (i == 5 || i == 7)
						scale[2] += 5;
					if (scale[2] < 0)
						scale[2] = 0;
					int i_229_ = editor.getText().indexOf(Messages.getString("CarMaker.272"), 0); //$NON-NLS-1$
					if (i_229_ != -1) {
						i_229_++;
						final int i_230_ = editor.getText().indexOf(Messages.getString("CarMaker.273"), i_229_); //$NON-NLS-1$
						final int i_231_ = editor.getText().indexOf(Messages.getString("CarMaker.274"), i_229_); //$NON-NLS-1$
						if (i_231_ > i_230_)
							editor.replaceText(
									new StringBuilder().append(Messages.getString("CarMaker.275")).append(scale[2]).append(Messages.getString("CarMaker.276")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_229_, i_230_ + 1);
						else
							editor.replaceText(
									new StringBuilder().append(Messages.getString("CarMaker.277")).append(scale[2]).append(Messages.getString("CarMaker.278")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_229_, i_231_);
					} else {
						final int i_232_ = editor.getText().indexOf(Messages.getString("CarMaker.279"), 0); //$NON-NLS-1$
						final int i_233_ = editor.getText().indexOf(Messages.getString("CarMaker.280"), 0); //$NON-NLS-1$
						if (i_233_ < i_232_ && i_233_ != -1)
							editor.insertText(
									new StringBuilder().append(Messages.getString("CarMaker.281")).append(scale[2]).append(Messages.getString("CarMaker.282")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_233_);
						else
							editor.insertText(
									new StringBuilder().append(Messages.getString("CarMaker.283")).append(scale[2]).append(Messages.getString("CarMaker.284")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									i_232_);
					}
				}
				if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 9)
					setupo();
				if (i == 8) {
					savefile();
					oscale[0] = scale[0];
					oscale[1] = scale[1];
					oscale[2] = scale[2];
				}
				if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18)
					try {
						final String string = new StringBuilder().append(Messages.getString("CarMaker.285")).append(editor.getText()).append(Messages.getString("CarMaker.286")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						String string_234_ = Messages.getString("CarMaker.287"); //$NON-NLS-1$
						int i_235_ = 0;
						int i_236_ = string.indexOf(Messages.getString("CarMaker.288"), 0); //$NON-NLS-1$
						while (i_236_ != -1 && i_235_ < string.length()) {
							String string_237_ = string.substring(i_235_, i_236_);
							string_237_ = string_237_.trim();
							i_235_ = i_236_ + 1;
							i_236_ = string.indexOf(Messages.getString("CarMaker.289"), i_235_); //$NON-NLS-1$
							if (string_237_.startsWith(Messages.getString("CarMaker.290"))) { //$NON-NLS-1$
								final int i_238_ = string_237_.indexOf(Messages.getString("CarMaker.291"), 0); //$NON-NLS-1$
								final int i_239_ = string_237_.indexOf(Messages.getString("CarMaker.292"), i_238_ + 1); //$NON-NLS-1$
								final int i_240_ = string_237_.indexOf(Messages.getString("CarMaker.293"), i_239_ + 1); //$NON-NLS-1$
								if (i_238_ != -1 && i_239_ != -1 && i_240_ != -1) {
									int i_241_ = Float.valueOf(string_237_.substring(2, i_238_)).intValue();
									int i_242_ = Float.valueOf(string_237_.substring(i_238_ + 1, i_239_)).intValue();
									int i_243_ = Float.valueOf(string_237_.substring(i_239_ + 1, i_240_)).intValue();
									if (i == 10) {
										final int i_244_ = i_242_;
										i_242_ = i_243_;
										i_243_ = -i_244_;
									}
									if (i == 11)
										i_241_ += 10;
									if (i == 12)
										i_241_ -= 10;
									if (i == 13) {
										final int i_245_ = i_241_;
										i_241_ = -i_243_;
										i_243_ = i_245_;
									}
									if (i == 14)
										i_242_ += 10;
									if (i == 15)
										i_242_ -= 10;
									if (i == 16) {
										final int i_246_ = i_242_;
										i_242_ = -i_241_;
										i_241_ = i_246_;
									}
									if (i == 17)
										i_243_ += 10;
									if (i == 18)
										i_243_ -= 10;
									string_234_ = new StringBuilder().append(string_234_).append(Messages.getString("CarMaker.294")).append(i_241_) //$NON-NLS-1$
											.append(Messages.getString("CarMaker.295")).append(i_242_).append(Messages.getString("CarMaker.296")).append(i_243_).append(Messages.getString("CarMaker.297")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
											.append(string_237_.substring(i_240_ + 1, string_237_.length()))
											.append(Messages.getString("CarMaker.298")).toString(); //$NON-NLS-1$
								} else
									string_234_ = new StringBuilder().append(string_234_).append(Messages.getString("CarMaker.299")).append(string_237_) //$NON-NLS-1$
											.append(Messages.getString("CarMaker.300")).toString(); //$NON-NLS-1$
							} else
								string_234_ = new StringBuilder().append(string_234_).append(Messages.getString("CarMaker.301")).append(string_237_) //$NON-NLS-1$
										.append(Messages.getString("CarMaker.302")).toString(); //$NON-NLS-1$
						}
						editor.setText(string_234_);
						setupo();
						changed2 = true;
					} catch (final Exception exception) {
						/* empty */
					}
				if (i == 19) {
					editor.setText(lastedo);
					setupo();
					changed2 = false;
				}
				if (i == 20 && changed2) {
					final int i_247_ = JOptionPane.showConfirmDialog(null,
							Messages.getString("CarMaker.303"), //$NON-NLS-1$
							Messages.getString("CarMaker.304"), 0); //$NON-NLS-1$
					if (i_247_ == 0) {
						editor.setText(
								new StringBuilder().append(editor.getText().trim()).append(Messages.getString("CarMaker.305")).toString()); //$NON-NLS-1$
						savefile();
						changed2 = false;
					}
				}
				i_206_ = 21;
			}
			if (dtab == 3) {
				if (i == 0 || i == 2 || defnow) {
					if (defnow) {
						defnow = false;
						repaint();
						JOptionPane.showMessageDialog(null,
								Messages.getString("CarMaker.306"), //$NON-NLS-1$
								Messages.getString("CarMaker.307"), 1); //$NON-NLS-1$
					}
					int i_248_ = 0;
					try {
						int i_249_ = Float.valueOf(wv[10].getText()).intValue();
						if (i_249_ <= 0)
							i_248_ = 1;
						i_249_ = Float.valueOf(wv[2].getText()).intValue();
						if (i_249_ >= 0)
							i_248_ = 2;
						i_249_ = Float.valueOf(wv[8].getText()).intValue();
						if (i_249_ <= 0)
							i_248_ = 3;
						i_249_ = Float.valueOf(wv[0].getText()).intValue();
						if (i_249_ <= 0)
							i_248_ = 4;
						i_249_ = Float.valueOf(wv[15].getText()).intValue();
						if (i_249_ > 40)
							wv[15].setText(Messages.getString("CarMaker.308")); //$NON-NLS-1$
						if (i_249_ < -40)
							wv[15].setText(Messages.getString("CarMaker.309")); //$NON-NLS-1$
						i_249_ = Float.valueOf(wv[7].getText()).intValue();
						if (i_249_ > 40)
							wv[7].setText(Messages.getString("CarMaker.310")); //$NON-NLS-1$
						if (i_249_ < -40)
							wv[7].setText(Messages.getString("CarMaker.311")); //$NON-NLS-1$
					} catch (final Exception exception) {
						/* empty */
					}
					if (i_248_ == 1)
						JOptionPane.showMessageDialog(null,
								new StringBuilder()
										.append(Messages.getString("CarMaker.312")) //$NON-NLS-1$
										.append(wv[10].getText())
										.append(Messages.getString("CarMaker.313")) //$NON-NLS-1$
										.toString(),
								Messages.getString("CarMaker.314"), 1); //$NON-NLS-1$
					if (i_248_ == 2)
						JOptionPane.showMessageDialog(null,
								new StringBuilder()
										.append(Messages.getString("CarMaker.315")) //$NON-NLS-1$
										.append(wv[2].getText())
										.append(Messages.getString("CarMaker.316")) //$NON-NLS-1$
										.toString(),
								Messages.getString("CarMaker.317"), 1); //$NON-NLS-1$
					if (i_248_ == 3)
						JOptionPane.showMessageDialog(null,
								new StringBuilder()
										.append(Messages.getString("CarMaker.318")) //$NON-NLS-1$
										.append(wv[8].getText())
										.append(Messages.getString("CarMaker.319")) //$NON-NLS-1$
										.toString(),
								Messages.getString("CarMaker.320"), 1); //$NON-NLS-1$
					if (i_248_ == 4)
						JOptionPane.showMessageDialog(null,
								new StringBuilder()
										.append(Messages.getString("CarMaker.321")) //$NON-NLS-1$
										.append(wv[0].getText())
										.append(Messages.getString("CarMaker.322")) //$NON-NLS-1$
										.toString(),
								Messages.getString("CarMaker.323"), 1); //$NON-NLS-1$
					if (i_248_ == 0) {
						final String string = new StringBuilder().append(Messages.getString("CarMaker.324")).append(editor.getText()).append(Messages.getString("CarMaker.325")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						String string_250_ = Messages.getString("CarMaker.326"); //$NON-NLS-1$
						int i_251_ = 0;
						int i_252_ = string.indexOf(Messages.getString("CarMaker.327"), 0); //$NON-NLS-1$
						while (i_252_ != -1 && i_251_ < string.length()) {
							String string_253_ = string.substring(i_251_, i_252_);
							string_253_ = string_253_.trim();
							i_251_ = i_252_ + 1;
							i_252_ = string.indexOf(Messages.getString("CarMaker.328"), i_251_); //$NON-NLS-1$
							if (!string_253_.startsWith(Messages.getString("CarMaker.329")) && !string_253_.startsWith(Messages.getString("CarMaker.330")) //$NON-NLS-1$ //$NON-NLS-2$
									&& !string_253_.startsWith(Messages.getString("CarMaker.331"))) //$NON-NLS-1$
								string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.332")).append(string_253_) //$NON-NLS-1$
										.append(Messages.getString("CarMaker.333")).toString(); //$NON-NLS-1$
							else {
								string_250_ = string_250_.trim();
								string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.334")).toString(); //$NON-NLS-1$
							}
						}
						string_250_ = string_250_.trim();
						string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.335")) //$NON-NLS-1$
								.append(wv[15].getText()).append(Messages.getString("CarMaker.336")).toString(); //$NON-NLS-1$
						String string_254_ = Messages.getString("CarMaker.337"); //$NON-NLS-1$
						if (rplc.getText().startsWith(Messages.getString("CarMaker.338")) && rplc.getText().endsWith(Messages.getString("CarMaker.339"))) //$NON-NLS-1$ //$NON-NLS-2$
							string_254_ = rplc.getText().substring(1, rplc.getText().length() - 1);
						string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.340")).append(string_254_) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.341")).append(wv[13].getText()).append(Messages.getString("CarMaker.342")).append(wv[14].getText()).append(Messages.getString("CarMaker.343")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.toString();
						string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.344")).append(wv[8].getText()) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.345")).append(wv[9].getText()).append(Messages.getString("CarMaker.346")).append(wv[10].getText()).append(Messages.getString("CarMaker.347")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(wv[12].getText()).append(Messages.getString("CarMaker.348")).append(wv[11].getText()).append(Messages.getString("CarMaker.349")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.350")).append(wv[8].getText()) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.351")).append(wv[9].getText()).append(Messages.getString("CarMaker.352")).append(wv[10].getText()) //$NON-NLS-1$ //$NON-NLS-2$
								.append(Messages.getString("CarMaker.353")).append(wv[12].getText()).append(Messages.getString("CarMaker.354")).append(wv[11].getText()) //$NON-NLS-1$ //$NON-NLS-2$
								.append(Messages.getString("CarMaker.355")).toString(); //$NON-NLS-1$
						string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.356")).append(wv[7].getText()) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.357")).toString(); //$NON-NLS-1$
						string_254_ = Messages.getString("CarMaker.358"); //$NON-NLS-1$
						if (srch.getText().startsWith(Messages.getString("CarMaker.359")) && srch.getText().endsWith(Messages.getString("CarMaker.360"))) //$NON-NLS-1$ //$NON-NLS-2$
							string_254_ = srch.getText().substring(1, srch.getText().length() - 1);
						string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.361")).append(string_254_) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.362")).append(wv[5].getText()).append(Messages.getString("CarMaker.363")).append(wv[6].getText()).append(Messages.getString("CarMaker.364")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.toString();
						string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.365")).append(wv[0].getText()) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.366")).append(wv[1].getText()).append(Messages.getString("CarMaker.367")).append(wv[2].getText()).append(Messages.getString("CarMaker.368")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(wv[4].getText()).append(Messages.getString("CarMaker.369")).append(wv[3].getText()).append(Messages.getString("CarMaker.370")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						string_250_ = new StringBuilder().append(string_250_).append(Messages.getString("CarMaker.371")).append(wv[0].getText()) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.372")).append(wv[1].getText()).append(Messages.getString("CarMaker.373")).append(wv[2].getText()).append(Messages.getString("CarMaker.374")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(wv[4].getText()).append(Messages.getString("CarMaker.375")).append(wv[3].getText()).append(Messages.getString("CarMaker.376")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						editor.setText(string_250_);
						forwheels = true;
						setupo();
						forwheels = false;
						aply1 = new StringBuilder().append(Messages.getString("CarMaker.377")).append(wv[0].getText()).append(Messages.getString("CarMaker.378")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[1].getText()).append(Messages.getString("CarMaker.379")).append(wv[2].getText()).append(Messages.getString("CarMaker.380")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[3].getText()).append(Messages.getString("CarMaker.381")).append(wv[4].getText()).append(Messages.getString("CarMaker.382")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(srch.getText()).append(Messages.getString("CarMaker.383")).append(wv[5].getText()).append(Messages.getString("CarMaker.384")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[6].getText()).append(Messages.getString("CarMaker.385")).append(wv[7].getText()).append(Messages.getString("CarMaker.386")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						aply2 = new StringBuilder().append(Messages.getString("CarMaker.387")).append(wv[8].getText()).append(Messages.getString("CarMaker.388")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[9].getText()).append(Messages.getString("CarMaker.389")).append(wv[10].getText()).append(Messages.getString("CarMaker.390")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[11].getText()).append(Messages.getString("CarMaker.391")).append(wv[12].getText()).append(Messages.getString("CarMaker.392")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(rplc.getText()).append(Messages.getString("CarMaker.393")).append(wv[13].getText()).append(Messages.getString("CarMaker.394")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[14].getText()).append(Messages.getString("CarMaker.395")).append(wv[15].getText()).append(Messages.getString("CarMaker.396")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						aplyd1 = false;
						aplyd2 = false;
						changed2 = true;
					}
				}
				if (i == 1 || i == 3)
					if (!o.errd) {
						savefile();
						changed2 = false;
					} else
						JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.397"), //$NON-NLS-1$
								Messages.getString("CarMaker.398"), 1); //$NON-NLS-1$
				i_206_ = 4;
			}
			if (dtab == 4)
				if (!statdef) {
					if (i == 0) {
						carsel = simcar.getSelectedIndex();
						int i_255_ = 0;
						for (int i_256_ = 0; i_256_ < 5; i_256_++) {
							stat[i_256_] = carstat[carsel][i_256_];
							rstat[i_256_] = stat[i_256_];
							i_255_ += stat[i_256_];
						}
						clsel = 4 - (i_255_ - 520) / 40;
						cls.select(clsel);
						if (simcar.getItemCount() == 16)
							simcar.add(rd, Messages.getString("CarMaker.399")); //$NON-NLS-1$
						statdef = true;
						changed2 = true;
					}
					i_206_ = 1;
				} else {
					for (int i_257_ = 0; i_257_ < 5; i_257_++) {
						int i_258_ = 0;
						if (i == 1 + i_257_ * 2 && stat[i_257_] < 200) {
							i_258_ = 200 - stat[i_257_];
							if (i_258_ > 4)
								i_258_ = 4;
						}
						if (i == i_257_ * 2 && stat[i_257_] > 16) {
							i_258_ = 16 - stat[i_257_];
							if (i_258_ < -4)
								i_258_ = -4;
						}
						int i_259_ = 0;
						while (i_258_ != 0 && i_259_ != 5) {
							i_259_ = 0;
							for (int i_260_ = 0; i_260_ < 5; i_260_++)
								if (i_257_ != i_260_ && (stat[i_260_] <= 200 || i_258_ > 0)
										&& (stat[i_260_] >= 16 || i_258_ < 0) && i_258_ != 0) {
									if (i_258_ > 0) {
										stat[i_257_]++;
										stat[i_260_]--;
										i_258_--;
									} else {
										stat[i_257_]--;
										stat[i_260_]++;
										i_258_++;
									}
								} else
									i_259_++;
						}
					}
					if (i == 10) {
						carsel = simcar.getSelectedIndex();
						int i_261_ = 0;
						for (int i_262_ = 0; i_262_ < 5; i_262_++) {
							stat[i_262_] = carstat[carsel][i_262_];
							i_261_ += stat[i_262_];
						}
						clsel = 4 - (i_261_ - 520) / 40;
						cls.select(clsel);
					}
					if (i == 11) {
						final String string = new StringBuilder().append(Messages.getString("CarMaker.400")).append(editor.getText()).append(Messages.getString("CarMaker.401")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						String string_263_ = Messages.getString("CarMaker.402"); //$NON-NLS-1$
						int i_264_ = 0;
						int i_265_ = string.indexOf(Messages.getString("CarMaker.403"), 0); //$NON-NLS-1$
						while (i_265_ != -1 && i_264_ < string.length()) {
							String string_266_ = string.substring(i_264_, i_265_);
							string_266_ = string_266_.trim();
							i_264_ = i_265_ + 1;
							i_265_ = string.indexOf(Messages.getString("CarMaker.404"), i_264_); //$NON-NLS-1$
							if (!string_266_.startsWith(Messages.getString("CarMaker.405"))) //$NON-NLS-1$
								string_263_ = new StringBuilder().append(string_263_).append(Messages.getString("CarMaker.406")).append(string_266_) //$NON-NLS-1$
										.append(Messages.getString("CarMaker.407")).toString(); //$NON-NLS-1$
							else {
								string_263_ = string_263_.trim();
								string_263_ = new StringBuilder().append(string_263_).append(Messages.getString("CarMaker.408")).toString(); //$NON-NLS-1$
							}
						}
						string_263_ = string_263_.trim();
						string_263_ = new StringBuilder().append(string_263_).append(Messages.getString("CarMaker.409")).append(stat[0]) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.410")).append(stat[1]).append(Messages.getString("CarMaker.411")).append(stat[2]).append(Messages.getString("CarMaker.412")).append(stat[3]) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(Messages.getString("CarMaker.413")).append(stat[4]).append(Messages.getString("CarMaker.414")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						editor.setText(string_263_);
						savefile();
						for (int i_267_ = 0; i_267_ < 5; i_267_++)
							rstat[i_267_] = stat[i_267_];
						changed2 = false;
					}
					if (i == 12)
						for (int i_268_ = 0; i_268_ < 5; i_268_++)
							stat[i_268_] = rstat[i_268_];
					i_206_ = 13;
				}
			if (dtab == 5) {
				if (pfase == 0) {
					for (int i_269_ = 0; i_269_ < 4; i_269_++) {
						if (i == 1 + i_269_ * 2) {
							phys[i_269_] += 2;
							if (phys[i_269_] > 100)
								phys[i_269_] = 100;
						}
						if (i == i_269_ * 2) {
							phys[i_269_] -= 2;
							if (phys[i_269_] < 0)
								phys[i_269_] = 0;
						}
					}
					if (i == 8)
						for (int i_270_ = 0; i_270_ < 5; i_270_++)
							phys[i_270_] = (int) (Math.random() * 100.0);
					if (i == 9)
						for (int i_271_ = 0; i_271_ < 5; i_271_++)
							phys[i_271_] = rphys[i_271_];
					if (i == 10) {
						pfase = 1;
						i = -1;
					}
					i_206_ = 11;
				}
				if (pfase == 1) {
					for (int i_272_ = 0; i_272_ < 6; i_272_++) {
						if (i == 1 + i_272_ * 2) {
							phys[i_272_ + 5] += 2;
							if (phys[i_272_ + 5] > 100)
								phys[i_272_ + 5] = 100;
						}
						if (i == i_272_ * 2) {
							phys[i_272_ + 5] -= 2;
							if (phys[i_272_ + 5] < 0)
								phys[i_272_ + 5] = 0;
						}
					}
					if (i == 12)
						for (int i_273_ = 0; i_273_ < 6; i_273_++)
							phys[i_273_ + 5] = (int) (Math.random() * 100.0);
					if (i == 13)
						for (int i_274_ = 0; i_274_ < 6; i_274_++)
							phys[i_274_ + 5] = rphys[i_274_ + 5];
					if (i == 14) {
						pfase = 0;
						i = -1;
					}
					if (i == 15) {
						pfase = 2;
						i = -1;
					}
					i_206_ = 16;
				}
				if (pfase == 2) {
					for (int i_275_ = 0; i_275_ < 3; i_275_++) {
						if (i == 1 + i_275_ * 2) {
							crash[i_275_] += 2;
							if (crash[i_275_] > 100)
								crash[i_275_] = 100;
						}
						if (i == i_275_ * 2) {
							crash[i_275_] -= 2;
							if (crash[i_275_] < 0)
								crash[i_275_] = 0;
						}
					}
					if (i == 6) {
						int i_276_ = (int) (150.0 + 600.0 * Math.random());
						boolean bool = false;
						boolean bool_277_ = false;
						if (Math.random() > Math.random())
							bool = true;
						if (Math.random() > Math.random())
							bool_277_ = true;
						final int[] is = { -101, -101, -101, -101 };
						is[0] = (int) (Math.random() * 4.0);
						if (Math.random() > Math.random()) {
							if (bool_277_)
								is[1] = is[0] + 1;
							else
								is[1] = is[0] - 1;
							if (Math.random() > Math.random()) {
								if (bool_277_)
									is[2] = is[1] + 1;
								else
									is[2] = is[1] - 1;
								if (Math.random() > Math.random())
									if (bool_277_)
										is[3] = is[2] + 1;
									else
										is[3] = is[2] - 1;
							}
						}
						if (Math.random() > Math.random())
							crashup = false;
						else
							crashup = true;
						for (int i_278_ = 0; i_278_ < 4; i_278_++)
							if (is[i_278_] != -101) {
								if (is[i_278_] >= 4)
									is[i_278_] -= 4;
								if (is[i_278_] <= -1)
									is[i_278_] += 4;
								i_276_ -= 50 * i_278_;
								if (i_276_ < 150)
									i_276_ = 150;
								if (bool)
									regx(is[i_278_], i_276_, false);
								else
									regz(is[i_278_], i_276_, false);
							}
						if (hitmag < 17000)
							if (crashleft)
								o.xz += 22;
							else
								o.xz -= 22;
					}
					if (i == 8) {
						if (Math.random() > Math.random())
							crashup = false;
						else
							crashup = true;
						roofsqsh((int) (230.0 + Math.random() * 80.0));
					}
					if (i == 9 || i == 7) {
						setupo();
						if (Math.random() > Math.random())
							crashleft = false;
						else
							crashleft = true;
					}
					if (i == 10)
						for (int i_279_ = 0; i_279_ < 3; i_279_++)
							crash[i_279_] = rcrash[i_279_];
					if (i == 11) {
						setupo();
						pfase = 1;
						i = -1;
					}
					if (i == 12) {
						// if (crashok) {
						setupo();
						pfase = 3;
						i = -1;
						// } else
						// JOptionPane.showMessageDialog(null, usage[11], "Car
						// Maker", 1);
					}
					i_206_ = 13;
				}
				if (pfase == 3) {
					for (int i_280_ = 0; i_280_ < 5; i_280_++) {
						if (i == i_280_) {
							for (int i_281_ = 0; i_281_ < 5; i_281_++)
								for (int i_282_ = 0; i_282_ < 5; i_282_++)
									engs[i_282_][i_281_].stop();
							engs[engsel][i_280_].loop();
							engon = true;
						}
						if (i == 5) {
							for (int i_283_ = 0; i_283_ < 5; i_283_++)
								for (int i_284_ = 0; i_284_ < 5; i_284_++)
									engs[i_284_][i_283_].stop();
							engon = false;
						}
						if (i == 6) {
							pfase = 2;
							i = -1;
							engine.setVisible(false);
						}
						if (i == 7) {
							pfase = 4;
							i = -1;
							engine.setVisible(false);
						}
					}
					i_206_ = 8;
				}
			}
			if (dtab == 6)
				if (!rateh) {
					if (i == 0 && checko(Messages.getString("CarMaker.415"))) { //$NON-NLS-1$
						Madness.testcar = carname;
						Madness.testdrive = witho.getSelectedIndex() + 1;
						Madness.game();
					}
					i_206_ = 1;
					if (tested) {
						if (i == 1) {
							dtab = 4;
							i = -1;
						}
						if (i == 2) {
							dtab = 5;
							i = -1;
						}
						if (i == 3) {
							rateh = true;
							hidefields();
						}
						i_206_ = 4;
					}
				} else {
					if (i == 0) {
						handling -= 2;
						if (handling < 50)
							handling = 50;
					}
					if (i == 1) {
						handling += 2;
						if (handling > 200)
							handling = 200;
					}
					if (i == 2) {
						final String string = new StringBuilder().append(Messages.getString("CarMaker.416")).append(editor.getText()).append(Messages.getString("CarMaker.417")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						String string_285_ = Messages.getString("CarMaker.418"); //$NON-NLS-1$
						int i_286_ = 0;
						int i_287_ = string.indexOf(Messages.getString("CarMaker.419"), 0); //$NON-NLS-1$
						while (i_287_ != -1 && i_286_ < string.length()) {
							String string_288_ = string.substring(i_286_, i_287_);
							string_288_ = string_288_.trim();
							i_286_ = i_287_ + 1;
							i_287_ = string.indexOf(Messages.getString("CarMaker.420"), i_286_); //$NON-NLS-1$
							if (!string_288_.startsWith(Messages.getString("CarMaker.421"))) //$NON-NLS-1$
								string_285_ = new StringBuilder().append(string_285_).append(Messages.getString("CarMaker.422")).append(string_288_) //$NON-NLS-1$
										.append(Messages.getString("CarMaker.423")).toString(); //$NON-NLS-1$
							else {
								string_285_ = string_285_.trim();
								string_285_ = new StringBuilder().append(string_285_).append(Messages.getString("CarMaker.424")).toString(); //$NON-NLS-1$
							}
						}
						string_285_ = string_285_.trim();
						string_285_ = new StringBuilder().append(string_285_).append(Messages.getString("CarMaker.425")).append(handling) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.426")).toString(); //$NON-NLS-1$
						editor.setText(string_285_);
						savefile();
						rateh = false;
					}
					if (i == 3)
						rateh = false;
					i_206_ = 4;
				}
			if (i == i_206_) {
				for (int i_289_ = 0; i_289_ < o.npl; i_289_++) {
					Color.RGBtoHSB(o.p[i_289_].c[0], o.p[i_289_].c[1], o.p[i_289_].c[2], o.p[i_289_].hsb);
					if (o.p[i_289_].gr == -13)
						o.p[i_289_].gr = 1;
				}
				polynum = -1;
			}
			i = -1;
		}
		if (tab == 3) {
			if (i == 0) {
				if (logged == 0)
					JOptionPane.showMessageDialog(null,
							Messages.getString("CarMaker.427"), Messages.getString("CarMaker.428"), 1); //$NON-NLS-1$ //$NON-NLS-2$
				if ((logged == 3 || logged == -1) && checko(Messages.getString("CarMaker.429"))) { //$NON-NLS-1$
					int i_290_ = 0;
					for (int i_291_ = 0; i_291_ < nmc; i_291_++)
						if (mycars[i_291_].equals(carname) && maker[i_291_].equals(tnick.getText()))
							i_290_ = JOptionPane
									.showConfirmDialog(null,
											new StringBuilder().append(Messages.getString("CarMaker.430")) //$NON-NLS-1$
													.append(carname).append(Messages.getString("CarMaker.431")).toString(), //$NON-NLS-1$
											Messages.getString("CarMaker.432"), 0); //$NON-NLS-1$
					if (i_290_ == 0) {
						setCursor(new Cursor(3));
						rd.setFont(new Font(Messages.getString("CarMaker.433"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.setColor(new Color(225, 225, 225));
						rd.fillRect(11, 141, 679, 401);
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(Messages.getString("CarMaker.434"), 350 - ftm.stringWidth(Messages.getString("CarMaker.435")) / 2, //$NON-NLS-1$ //$NON-NLS-2$
								250);
						repaint();
						int i_292_ = 0;
						String string = new StringBuilder().append(Messages.getString("CarMaker.436")).append(editor.getText()).append(Messages.getString("CarMaker.437")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						int i_293_ = 0;
						int i_294_ = string.indexOf(Messages.getString("CarMaker.438"), 0); //$NON-NLS-1$
						while (i_294_ != -1 && i_293_ < string.length()) {
							i_293_ = i_294_ + 1;
							i_294_ = string.indexOf(Messages.getString("CarMaker.439"), i_293_); //$NON-NLS-1$
							i_292_++;
						}
						int i_295_ = -1;
						try {
							final Socket socket = new Socket(Messages.getString("CarMaker.440"), 7061); //$NON-NLS-1$
							final BufferedReader bufferedreader = new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
							final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
							printwriter.println(new StringBuilder().append(Messages.getString("CarMaker.441")).append(tnick.getText()).append(Messages.getString("CarMaker.442")) //$NON-NLS-1$ //$NON-NLS-2$
									.append(tpass.getText()).append(Messages.getString("CarMaker.443")).append(carname).append(Messages.getString("CarMaker.444")) //$NON-NLS-1$ //$NON-NLS-2$
									.append(pubtyp.getSelectedIndex()).append(Messages.getString("CarMaker.445")).toString()); //$NON-NLS-1$
							String string_296_ = bufferedreader.readLine();
							if (string_296_ != null)
								i_295_ = 0;
							// i_295_ = servervalue(string_296_, 0);
							if (i_295_ == 0) {
								int i_297_ = 0;
								string = new StringBuilder().append(Messages.getString("CarMaker.446")).append(editor.getText()).append(Messages.getString("CarMaker.447")) //$NON-NLS-1$ //$NON-NLS-2$
										.toString();
								i_293_ = 0;
								i_294_ = string.indexOf(Messages.getString("CarMaker.448"), 0); //$NON-NLS-1$
								while (i_294_ != -1 && i_293_ < string.length()) {
									String string_298_ = string.substring(i_293_, i_294_);
									string_298_ = string_298_.trim();
									printwriter.println(string_298_);
									i_293_ = i_294_ + 1;
									i_294_ = string.indexOf(Messages.getString("CarMaker.449"), i_293_); //$NON-NLS-1$
									i_297_++;
									rd.setColor(new Color(225, 225, 225));
									rd.fillRect(11, 141, 679, 401);
									rd.setColor(new Color(0, 0, 0));
									rd.drawString(Messages.getString("CarMaker.450"), 350 - ftm.stringWidth(Messages.getString("CarMaker.451")) / 2, //$NON-NLS-1$ //$NON-NLS-2$
											250);
									rd.setColor(new Color(119, 147, 191));
									rd.fillRect(250, 270, (int) ((float) i_297_ / (float) i_292_ * 200.0F), 7);
									rd.setColor(new Color(0, 0, 0));
									rd.drawRect(250, 270, 200, 7);
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
								printwriter.println(Messages.getString("CarMaker.452")); //$NON-NLS-1$
								rd.setColor(new Color(225, 225, 225));
								rd.fillRect(11, 141, 679, 401);
								rd.setColor(new Color(0, 0, 0));
								rd.drawString(Messages.getString("CarMaker.453"), //$NON-NLS-1$
										350 - ftm.stringWidth(Messages.getString("CarMaker.454")) / 2, 250); //$NON-NLS-1$
								rd.drawString(Messages.getString("CarMaker.455"), //$NON-NLS-1$
										350 - ftm.stringWidth(Messages.getString("CarMaker.456")) / 2, //$NON-NLS-1$
										280);
								repaint();
								string_296_ = bufferedreader.readLine();
								if (string_296_ != null)
									i_295_ = servervalue(string_296_, 0);
							}
							socket.close();
						} catch (final Exception exception) {
							i_295_ = -1;
						}
						setCursor(new Cursor(0));
						boolean bool = false;
						if (i_295_ == 0) {
							logged = 1;
							bool = true;
						}
						if (i_295_ == 3) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.457"), //$NON-NLS-1$
									Messages.getString("CarMaker.458"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 4) {
							JOptionPane.showMessageDialog(null,
									new StringBuilder().append(Messages.getString("CarMaker.459")) //$NON-NLS-1$
											.append(carname).append(Messages.getString("CarMaker.460")).append(carname) //$NON-NLS-1$
											.append(Messages.getString("CarMaker.461")) //$NON-NLS-1$
											.toString(),
									Messages.getString("CarMaker.462"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 6) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.463"), //$NON-NLS-1$
									Messages.getString("CarMaker.464"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 7) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.465"), //$NON-NLS-1$
									Messages.getString("CarMaker.466"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 8) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.467"), //$NON-NLS-1$
									Messages.getString("CarMaker.468"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 9) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.469"), //$NON-NLS-1$
									Messages.getString("CarMaker.470"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 10) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.471"), //$NON-NLS-1$
									Messages.getString("CarMaker.472"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 11) {
							JOptionPane.showMessageDialog(null,
									new StringBuilder()
											.append(Messages.getString("CarMaker.473")) //$NON-NLS-1$
											.append((int) ((o.maxR / 400.0F - 1.0F) * 100.0F)).append(Messages.getString("CarMaker.474")) //$NON-NLS-1$
											.toString(),
									Messages.getString("CarMaker.475"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 12) {
							JOptionPane.showMessageDialog(null,
									new StringBuilder()
											.append(Messages.getString("CarMaker.476")) //$NON-NLS-1$
											.append((int) ((120.0F / o.maxR - 1.0F) * 100.0F)).append(Messages.getString("CarMaker.477")) //$NON-NLS-1$
											.toString(),
									Messages.getString("CarMaker.478"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 13) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.479"), //$NON-NLS-1$
									Messages.getString("CarMaker.480"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 14) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.481"), //$NON-NLS-1$
									Messages.getString("CarMaker.482"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ == 15) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.483"), //$NON-NLS-1$
									Messages.getString("CarMaker.484"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (i_295_ > 15) {
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.485"), //$NON-NLS-1$
									Messages.getString("CarMaker.486"), 1); //$NON-NLS-1$
							bool = true;
						}
						if (!bool)
							JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.487"), Messages.getString("CarMaker.488"), //$NON-NLS-1$ //$NON-NLS-2$
									1);
					}
				}
			}
			if (logged == 0) {
				if (i == 1) {
					setCursor(new Cursor(3));
					int i_299_ = -1;
					try {
						final Socket socket = new Socket(Messages.getString("CarMaker.489"), 7061); //$NON-NLS-1$
						final BufferedReader bufferedreader = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
						printwriter.println(new StringBuilder().append(Messages.getString("CarMaker.490")).append(tnick.getText().toLowerCase()) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.491")).append(tpass.getText()).append(Messages.getString("CarMaker.492")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						final String string = bufferedreader.readLine();
						if (string != null)
							i_299_ = servervalue(string, 0);
						socket.close();
					} catch (final Exception exception) {
						i_299_ = -1;
					}
					if (i_299_ == 0 || i_299_ == 3 || i_299_ > 10) {
						tnick.setVisible(false);
						tpass.setVisible(false);
						logged = 1;
						savesettings();
					}
					if (i_299_ == 1 || i_299_ == 2) {
						setCursor(new Cursor(0));
						JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.493"), Messages.getString("CarMaker.494"), 0); //$NON-NLS-1$ //$NON-NLS-2$
					}
					if (i_299_ == -167) {
						setCursor(new Cursor(0));
						JOptionPane.showMessageDialog(null,
								Messages.getString("CarMaker.495"), //$NON-NLS-1$
								Messages.getString("CarMaker.496"), 0); //$NON-NLS-1$
					}
					if (i_299_ == -1) {
						setCursor(new Cursor(0));
						JOptionPane.showMessageDialog(null,
								Messages.getString("CarMaker.497"), Messages.getString("CarMaker.498"), 1); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
				if (i == 2)
					Madness.openurl(Messages.getString("CarMaker.499")); //$NON-NLS-1$
			}
		}
	}

	public void delcar(final String string) {
		if (string.equals(Messages.getString("CarMaker.500"))) //$NON-NLS-1$
			JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.501"), Messages.getString("CarMaker.502"), 1); //$NON-NLS-1$ //$NON-NLS-2$
		else {
			final int i = JOptionPane.showConfirmDialog(null, new StringBuilder()
					.append(Messages.getString("CarMaker.503")).append(string).append(Messages.getString("CarMaker.504")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
					Messages.getString("CarMaker.505"), 0); //$NON-NLS-1$
			if (i == 0)
				try {
					final File file = new File(
							new StringBuilder().append(Messages.getString("CarMaker.506")).append(string).append(Messages.getString("CarMaker.507")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
					file.delete();
					slcar.remove(string);
					slcar.select(0);
				} catch (final Exception exception) {
					JOptionPane.showMessageDialog(null, new StringBuilder()
							.append(Messages.getString("CarMaker.508")).append(exception).toString(), //$NON-NLS-1$
							Messages.getString("CarMaker.509"), 1); //$NON-NLS-1$
				}
		}
	}

	public void drawms() {
		openm = false;
		if (pubtyp.draw(rd, xm, ym, mousdr, 550, false))
			openm = true;
		if (fontsel.draw(rd, xm, ym, mousdr, 550, true))
			openm = true;
		if (ctheme.draw(rd, xm, ym, mousdr, 550, true))
			openm = true;
		if (compcar.draw(rd, xm, ym, mousdr, 550, true))
			openm = true;
		if (cls.draw(rd, xm, ym, mousdr, 550, true))
			openm = true;
		if (simcar.draw(rd, xm, ym, mousdr, 550, true))
			openm = true;
		if (engine.draw(rd, xm, ym, mousdr, 550, false))
			openm = true;
		if (witho.draw(rd, xm, ym, mousdr, 550, true))
			openm = true;
		if (slcar.draw(rd, xm, ym, mousdr, 550, false))
			openm = true;
		if (openm) {
			waso = true;
			mouses = 0;
		}
	}

	public void fixtext(final TextField textfield) {
		String string = textfield.getText();
		string = string.replace('\"', '#');
		final String string_360_ = Messages.getString("CarMaker.510"); //$NON-NLS-1$
		String string_361_ = Messages.getString("CarMaker.511"); //$NON-NLS-1$
		int i = 0;
		int i_362_ = -1;
		for (/**/; i < string.length(); i++) {
			final String string_363_ = new StringBuilder().append(Messages.getString("CarMaker.512")).append(string.charAt(i)).toString(); //$NON-NLS-1$
			if (string_363_.equals(Messages.getString("CarMaker.513")) || string_363_.equals(Messages.getString("CarMaker.514")) || string_363_.equals(Messages.getString("CarMaker.515")) || string_363_.equals(Messages.getString("CarMaker.516")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
					|| string_363_.equals(Messages.getString("CarMaker.517")) || string_363_.equals(string_360_) || string_363_.equals(Messages.getString("CarMaker.518")) //$NON-NLS-1$ //$NON-NLS-2$
					|| string_363_.equals(Messages.getString("CarMaker.519")) || string_363_.equals(Messages.getString("CarMaker.520")) || string_363_.equals(Messages.getString("CarMaker.521")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_363_.equals(Messages.getString("CarMaker.522")) || string_363_.equals(Messages.getString("CarMaker.523")) || string_363_.equals(Messages.getString("CarMaker.524")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_363_.equals(Messages.getString("CarMaker.525")) || string_363_.equals(Messages.getString("CarMaker.526")) || string_363_.equals(Messages.getString("CarMaker.527")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_363_.equals(Messages.getString("CarMaker.528")) || string_363_.equals(Messages.getString("CarMaker.529")) || string_363_.equals(Messages.getString("CarMaker.530")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_363_.equals(Messages.getString("CarMaker.531")) || string_363_.equals(Messages.getString("CarMaker.532")) || string_363_.equals(Messages.getString("CarMaker.533")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					|| string_363_.equals(Messages.getString("CarMaker.534")) || string_363_.equals(Messages.getString("CarMaker.535")) || i > 15) //$NON-NLS-1$ //$NON-NLS-2$
				i_362_ = i;
			else
				string_361_ = new StringBuilder().append(string_361_).append(string_363_).toString();
		}
		if (i_362_ != -1) {
			textfield.setText(string_361_);
			textfield.select(i_362_, i_362_);
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

	public String getSvalue(final String string, final String string_369_, final int i) {
		String string_370_ = Messages.getString("CarMaker.536"); //$NON-NLS-1$
		int i_371_ = 0;
		for (int i_372_ = string.length() + 1; i_372_ < string_369_.length() && i_371_ <= i; i_372_++) {
			final String string_373_ = new StringBuilder().append(Messages.getString("CarMaker.537")).append(string_369_.charAt(i_372_)).toString(); //$NON-NLS-1$
			if (string_373_.equals(Messages.getString("CarMaker.538")) || string_373_.equals(Messages.getString("CarMaker.539"))) //$NON-NLS-1$ //$NON-NLS-2$
				i_371_++;
			else if (i_371_ == i)
				string_370_ = new StringBuilder().append(string_370_).append(string_373_).toString();
		}
		return string_370_;
	}

	public int getvalue(final String string, final String string_364_, final int i) {
		int i_365_ = 0;
		String string_366_ = Messages.getString("CarMaker.540"); //$NON-NLS-1$
		for (int i_367_ = string.length() + 1; i_367_ < string_364_.length(); i_367_++) {
			final String string_368_ = new StringBuilder().append(Messages.getString("CarMaker.541")).append(string_364_.charAt(i_367_)).toString(); //$NON-NLS-1$
			if (string_368_.equals(Messages.getString("CarMaker.542")) || string_368_.equals(Messages.getString("CarMaker.543"))) { //$NON-NLS-1$ //$NON-NLS-2$
				i_365_++;
				i_367_++;
			}
			if (i_365_ == i)
				string_366_ = new StringBuilder().append(string_366_).append(string_364_.charAt(i_367_)).toString();
		}
		return Float.valueOf(string_366_).intValue();
	}

	@Override
	public boolean gotFocus(final Event event, final Object object) {
		focuson = true;
		return false;
	}

	public void hidefields() {
		pubtyp.setVisible(false);
		tpass.setVisible(false);
		tnick.setVisible(false);
		slcar.setVisible(false);
		witho.setVisible(false);
		for (int i = 0; i < 16; i++)
			wv[i].setVisible(false);
		simcar.setVisible(false);
		engine.setVisible(false);
		cls.setVisible(false);
		compcar.setVisible(false);
		editor.setVisible(false);
		fontsel.setVisible(false);
		ctheme.setVisible(false);
		srch.setVisible(false);
		rplc.setVisible(false);
	}

	@Override
	public void init() {
		setBackground(new Color(0, 0, 0));
		offImage = createImage(700, 550);
		if (offImage != null)
			rd = (Graphics2D) offImage.getGraphics();
		rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		setLayout(null);
		slcar.setFont(new Font(Messages.getString("CarMaker.544"), 1, 13)); //$NON-NLS-1$
		slcar.add(rd, Messages.getString("CarMaker.545")); //$NON-NLS-1$
		slcar.setForeground(new Color(63, 80, 110));
		slcar.setBackground(new Color(209, 217, 230));
		fontsel.setFont(new Font(Messages.getString("CarMaker.546"), 1, 12)); //$NON-NLS-1$
		fontsel.add(rd, Messages.getString("CarMaker.547")); //$NON-NLS-1$
		fontsel.add(rd, Messages.getString("CarMaker.548")); //$NON-NLS-1$
		fontsel.add(rd, Messages.getString("CarMaker.549")); //$NON-NLS-1$
		fontsel.add(rd, Messages.getString("CarMaker.550")); //$NON-NLS-1$
		fontsel.add(rd, Messages.getString("CarMaker.551")); //$NON-NLS-1$
		fontsel.add(rd, Messages.getString("CarMaker.552")); //$NON-NLS-1$
		fontsel.add(rd, Messages.getString("CarMaker.553")); //$NON-NLS-1$
		fontsel.setBackground(new Color(63, 80, 110));
		fontsel.setForeground(new Color(209, 217, 230));
		ctheme.setFont(new Font(Messages.getString("CarMaker.554"), 1, 12)); //$NON-NLS-1$
		ctheme.add(rd, Messages.getString("CarMaker.555")); //$NON-NLS-1$
		ctheme.add(rd, Messages.getString("CarMaker.556")); //$NON-NLS-1$
		ctheme.add(rd, Messages.getString("CarMaker.557")); //$NON-NLS-1$
		ctheme.add(rd, Messages.getString("CarMaker.558")); //$NON-NLS-1$
		ctheme.add(rd, Messages.getString("CarMaker.559")); //$NON-NLS-1$
		ctheme.add(rd, Messages.getString("CarMaker.560")); //$NON-NLS-1$
		ctheme.add(rd, Messages.getString("CarMaker.561")); //$NON-NLS-1$
		ctheme.add(rd, Messages.getString("CarMaker.562")); //$NON-NLS-1$
		ctheme.setBackground(new Color(63, 80, 110));
		ctheme.setForeground(new Color(209, 217, 230));
		compcar.setFont(new Font(Messages.getString("CarMaker.563"), 1, 12)); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.564")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.565")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.566")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.567")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.568")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.569")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.570")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.571")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.572")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.573")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.574")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.575")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.576")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.577")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.578")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.579")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.580")); //$NON-NLS-1$
		compcar.add(rd, Messages.getString("CarMaker.581")); //$NON-NLS-1$
		compcar.setBackground(new Color(63, 80, 110));
		compcar.setForeground(new Color(209, 217, 230));
		cls.setFont(new Font(Messages.getString("CarMaker.582"), 1, 12)); //$NON-NLS-1$
		cls.add(rd, Messages.getString("CarMaker.583")); //$NON-NLS-1$
		cls.add(rd, Messages.getString("CarMaker.584")); //$NON-NLS-1$
		cls.add(rd, Messages.getString("CarMaker.585")); //$NON-NLS-1$
		cls.add(rd, Messages.getString("CarMaker.586")); //$NON-NLS-1$
		cls.add(rd, Messages.getString("CarMaker.587")); //$NON-NLS-1$
		cls.setBackground(new Color(63, 80, 110));
		cls.setForeground(new Color(209, 217, 230));
		simcar.setFont(new Font(Messages.getString("CarMaker.588"), 1, 12)); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.589")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.590")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.591")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.592")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.593")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.594")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.595")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.596")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.597")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.598")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.599")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.600")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.601")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.602")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.603")); //$NON-NLS-1$
		simcar.add(rd, Messages.getString("CarMaker.604")); //$NON-NLS-1$
		simcar.setBackground(new Color(63, 80, 110));
		simcar.setForeground(new Color(209, 217, 230));
		witho.setFont(new Font(Messages.getString("CarMaker.605"), 1, 12)); //$NON-NLS-1$
		witho.add(rd, Messages.getString("CarMaker.606")); //$NON-NLS-1$
		witho.add(rd, Messages.getString("CarMaker.607")); //$NON-NLS-1$
		witho.setBackground(new Color(63, 80, 110));
		witho.setForeground(new Color(209, 217, 230));
		engine.setFont(new Font(Messages.getString("CarMaker.608"), 1, 12)); //$NON-NLS-1$
		engine.add(rd, Messages.getString("CarMaker.609")); //$NON-NLS-1$
		engine.add(rd, Messages.getString("CarMaker.610")); //$NON-NLS-1$
		engine.add(rd, Messages.getString("CarMaker.611")); //$NON-NLS-1$
		engine.add(rd, Messages.getString("CarMaker.612")); //$NON-NLS-1$
		engine.add(rd, Messages.getString("CarMaker.613")); //$NON-NLS-1$
		engine.setBackground(new Color(63, 80, 110));
		engine.setForeground(new Color(209, 217, 230));
		final MenuItem menuitem = new MenuItem(Messages.getString("CarMaker.614")); //$NON-NLS-1$
		final MenuItem menuitem_340_ = new MenuItem(Messages.getString("CarMaker.615")); //$NON-NLS-1$
		final MenuItem menuitem_341_ = new MenuItem(Messages.getString("CarMaker.616")); //$NON-NLS-1$
		final MenuItem menuitem_342_ = new MenuItem(Messages.getString("CarMaker.617")); //$NON-NLS-1$
		popupMenu = new PopupMenu();
		popupMenu.add(menuitem);
		popupMenu.add(menuitem_340_);
		popupMenu.add(menuitem_341_);
		popupMenu.add(menuitem_342_);
		menuitem.addActionListener(this);
		menuitem_340_.addActionListener(this);
		menuitem_341_.addActionListener(this);
		menuitem_342_.addActionListener(this);
		add(popupMenu);
		for (int i = 0; i < 16; i++) {
			wv[i] = new TextField(Messages.getString("CarMaker.618"), 2); //$NON-NLS-1$
			wv[i].setBackground(new Color(255, 255, 255));
			wv[i].setForeground(new Color(0, 0, 0));
			wv[i].setFont(new Font(cfont, 1, 14));
			wv[i].addMouseListener(new MouseHandler(popupMenu, i));
			add(wv[i]);
		}
		tnick.setFont(new Font(Messages.getString("CarMaker.619"), 1, 13)); //$NON-NLS-1$
		tnick.setBackground(new Color(255, 255, 255));
		tnick.setForeground(new Color(0, 0, 0));
		tpass.setFont(new Font(Messages.getString("CarMaker.620"), 1, 13)); //$NON-NLS-1$
		tpass.setEchoCharacter('*');
		tpass.setBackground(new Color(255, 255, 255));
		tpass.setForeground(new Color(0, 0, 0));
		pubtyp.setFont(new Font(Messages.getString("CarMaker.621"), 1, 13)); //$NON-NLS-1$
		pubtyp.add(rd, Messages.getString("CarMaker.622")); //$NON-NLS-1$
		pubtyp.add(rd, Messages.getString("CarMaker.623")); //$NON-NLS-1$
		pubtyp.add(rd, Messages.getString("CarMaker.624")); //$NON-NLS-1$
		pubtyp.setBackground(new Color(63, 80, 110));
		pubtyp.setForeground(new Color(209, 217, 230));
		srch.setBackground(new Color(255, 255, 255));
		srch.setForeground(new Color(0, 0, 0));
		srch.addMouseListener(new MouseHandler(popupMenu, 16));
		rplc.setBackground(new Color(255, 255, 255));
		rplc.setForeground(new Color(0, 0, 0));
		rplc.addMouseListener(new MouseHandler(popupMenu, 17));
		editor.addMouseListener(new MouseHandler(popupMenu, 18));
		add(tnick);
		add(tpass);
		add(editor);
		add(srch);
		add(rplc);
		defb = new Color(255, 255, 255);
		deff = new Color(0, 0, 0);
		hidefields();
	}

	@Override
	public boolean keyDown(final Event event, final int i) {
		if (focuson) {
			if (i == 54 || i == 46 || i == 100 || i == 68)
				rotr = true;
			if (i == 52 || i == 44 || i == 97 || i == 65)
				rotl = true;
			if (i == 43 || i == 61)
				plus = true;
			if (i == 45)
				minus = true;
			if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87)
				in = true;
			if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83)
				out = true;
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
		if (i == 54 || i == 46 || i == 100 || i == 68)
			rotr = false;
		if (i == 52 || i == 44 || i == 97 || i == 65)
			rotl = false;
		if (i == 43 || i == 61)
			plus = false;
		if (i == 45)
			minus = false;
		if (i == 42 || i == 10 || i == 56 || i == 119 || i == 97)
			in = false;
		if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83)
			out = false;
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
		final String[] strings = { Messages.getString("CarMaker.625"), Messages.getString("CarMaker.626"), Messages.getString("CarMaker.627"), Messages.getString("CarMaker.628"), Messages.getString("CarMaker.629"), Messages.getString("CarMaker.630"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
				Messages.getString("CarMaker.631"), Messages.getString("CarMaker.632"), Messages.getString("CarMaker.633"), Messages.getString("CarMaker.634"), Messages.getString("CarMaker.635"), Messages.getString("CarMaker.636"), Messages.getString("CarMaker.637"), Messages.getString("CarMaker.638"), Messages.getString("CarMaker.639"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$
				Messages.getString("CarMaker.640") }; //$NON-NLS-1$
		try {
			final File file = new File(Messages.getString("CarMaker.641")); //$NON-NLS-1$
			final ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));
			ZipEntry zipentry = zipinputstream.getNextEntry();
			for (/**/; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
				int i = -1;
				for (int i_356_ = 0; i_356_ < 16; i_356_++)
					if (zipentry.getName().startsWith(strings[i_356_]))
						i = i_356_;
				if (i != -1) {
					int i_357_ = (int) zipentry.getSize();
					final byte[] is = new byte[i_357_];
					int i_358_ = 0;
					int i_359_;
					for (/**/; i_357_ > 0; i_357_ -= i_359_) {
						i_359_ = zipinputstream.read(is, i_358_, i_357_);
						i_358_ += i_359_;
					}
					compo[i] = new ContO(is, m, t);
					compo[i].shadow = false;
					compo[i].noline = true;
				}
			}
			zipinputstream.close();
		} catch (final Exception exception) {
			System.out.println(
					new StringBuilder().append(Messages.getString("CarMaker.642")).append(exception).toString()); //$NON-NLS-1$
		}
		System.gc();
	}

	public void loadfile() {
		loadedfile = false;
		lastedo = Messages.getString("CarMaker.643"); //$NON-NLS-1$
		try {
			final File file = new File(new StringBuilder().append(Messages.getString("CarMaker.644")).append(carname).append(Messages.getString("CarMaker.645")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
			final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
			String string;
			while ((string = bufferedreader.readLine()) != null) {
				final StringBuilder stringbuilder = new StringBuilder();
				final CarMaker carmaker_300_ = this;
				carmaker_300_.lastedo = stringbuilder.append(carmaker_300_.lastedo).append(Messages.getString("CarMaker.646")).append(string) //$NON-NLS-1$
						.append(Messages.getString("CarMaker.647")).toString(); //$NON-NLS-1$
			}
			loadedfile = true;
			bufferedreader.close();
		} catch (final Exception exception) {
			loadedfile = false;
			lastedo = Messages.getString("CarMaker.648"); //$NON-NLS-1$
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append(Messages.getString("CarMaker.649")).append(exception).toString(), //$NON-NLS-1$
					Messages.getString("CarMaker.650"), 1); //$NON-NLS-1$
		}
		editor.setText(lastedo);
	}

	public void loadsettings() {
		try {
			final File file = new File(Messages.getString("CarMaker.651")); //$NON-NLS-1$
			if (file.exists()) {
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string = bufferedreader.readLine();
				if (string != null) {
					scar = string;
					carname = scar;
				}
				string = bufferedreader.readLine();
				if (string != null) {
					suser = string;
					if (!suser.equals(Messages.getString("CarMaker.652"))) //$NON-NLS-1$
						tnick.setText(suser);
				}
				string = bufferedreader.readLine();
				if (string != null) {
					sfont = string;
					cfont = sfont;
				}
				string = bufferedreader.readLine();
				if (string != null) {
					sthm = Float.valueOf(string).intValue();
					cthm = sthm;
				}
				bufferedreader.close();
			}
		} catch (final Exception exception) {
			/* empty */
		}
	}

	public void loadsounds() {
		try {
			final File file = new File(Messages.getString("CarMaker.653")); //$NON-NLS-1$
			final FileInputStream fileinputstream = new FileInputStream(file);
			final ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
			for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream
					.getNextEntry()) {
				int i = (int) zipentry.getSize();
				final String string = zipentry.getName();
				final byte[] is = new byte[i];
				int i_350_ = 0;
				int i_351_;
				for (/**/; i > 0; i -= i_351_) {
					i_351_ = zipinputstream.read(is, i_350_, i);
					i_350_ += i_351_;
				}
				for (int i_352_ = 0; i_352_ < 5; i_352_++)
					for (int i_353_ = 0; i_353_ < 5; i_353_++)
						if (string.equals(new StringBuilder().append(Messages.getString("CarMaker.654")).append(i_353_).append(Messages.getString("CarMaker.655")).append(i_352_) //$NON-NLS-1$ //$NON-NLS-2$
								.append(Messages.getString("CarMaker.656")).toString())) //$NON-NLS-1$
							engs[i_353_][i_352_] = new soundClip(is);
				for (int i_354_ = 0; i_354_ < 3; i_354_++)
					if (string.equals(new StringBuilder().append(Messages.getString("CarMaker.657")).append(i_354_ + 1).append(Messages.getString("CarMaker.658")).toString())) //$NON-NLS-1$ //$NON-NLS-2$
						crashs[i_354_] = new soundClip(is);
				for (int i_355_ = 0; i_355_ < 3; i_355_++)
					if (string.equals(
							new StringBuilder().append(Messages.getString("CarMaker.659")).append(i_355_ + 1).append(Messages.getString("CarMaker.660")).toString())) //$NON-NLS-1$ //$NON-NLS-2$
						lowcrashs[i_355_] = new soundClip(is);
			}
			fileinputstream.close();
			zipinputstream.close();
		} catch (final Exception exception) {
			System.out.println(new StringBuilder().append(Messages.getString("CarMaker.661")).append(exception).toString()); //$NON-NLS-1$
		}
		System.gc();
	}

	@Override
	public boolean lostFocus(final Event event, final Object object) {
		focuson = false;
		return false;
	}

	@Override
	public boolean mouseDown(final Event event, final int i, final int i_347_) {
		xm = i - apx;
		ym = i_347_ - apy;
		mouses = 1;
		mousdr = true;
		if (tab != 1)
			requestFocus();
		return false;
	}

	@Override
	public boolean mouseDrag(final Event event, final int i, final int i_349_) {
		mousdr = true;
		xm = i - apx;
		ym = i_349_ - apy;
		return false;
	}

	@Override
	public boolean mouseMove(final Event event, final int i, final int i_348_) {
		xm = i - apx;
		ym = i_348_ - apy;
		if (xm > 520 && xm < 674 && ym > 0 && ym < 23) {
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
	public boolean mouseUp(final Event event, final int i, final int i_346_) {
		xm = i - apx;
		ym = i_346_ - apy;
		if (waso)
			waso = false;
		else
			mouses = -1;
		mousdr = false;
		if (onbtgame)
			Madness.game();
		return false;
	}

	public void movefield(final Component component, int i, int i_343_, final int i_344_, final int i_345_) {
		i += apx;
		i_343_ += apy;
		if (component.getX() != i || component.getY() != i_343_ || component.getWidth() != i_344_
				|| component.getHeight() != i_345_)
			component.setBounds(i, i_343_, i_344_, i_345_);
	}

	public void newcar(final String string) {
		if (string.equals(Messages.getString("CarMaker.662"))) //$NON-NLS-1$
			JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.663"), Messages.getString("CarMaker.664"), 1); //$NON-NLS-1$ //$NON-NLS-2$
		else {
			final String string_302_ = new StringBuilder().append(Messages.getString("CarMaker.665")).append(string) //$NON-NLS-1$
					.append(Messages.getString("CarMaker.666")) //$NON-NLS-1$
					.toString();
			try {
				File file = new File(Messages.getString("CarMaker.667")); //$NON-NLS-1$
				if (!file.exists())
					file.mkdirs();
				carname = string;
				file = new File(new StringBuilder().append(Messages.getString("CarMaker.668")).append(carname).append(Messages.getString("CarMaker.669")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				if (!file.exists()) {
					final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
					bufferedwriter.write(string_302_);
					bufferedwriter.close();
					if (file.exists()) {
						sfase = 0;
						hidefields();
						tabed = -1;
					} else
						JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.670"), Messages.getString("CarMaker.671"), 1); //$NON-NLS-1$ //$NON-NLS-2$
				} else
					JOptionPane.showMessageDialog(null,
							new StringBuilder().append(Messages.getString("CarMaker.672")).append(carname) //$NON-NLS-1$
									.append(Messages.getString("CarMaker.673")).toString(), //$NON-NLS-1$
							Messages.getString("CarMaker.674"), 1); //$NON-NLS-1$
			} catch (final Exception exception) {
				carname = Messages.getString("CarMaker.675"); //$NON-NLS-1$
				JOptionPane.showMessageDialog(null, new StringBuilder()
						.append(Messages.getString("CarMaker.676")).append(exception).toString(), Messages.getString("CarMaker.677"), //$NON-NLS-1$ //$NON-NLS-2$
						1);
			}
		}
	}

	public int objvalue(final String string, final int i) {
		int i_386_ = 0;
		try {
			int i_387_ = 2;
			int i_388_ = 0;
			int i_389_ = 0;
			String string_390_ = Messages.getString("CarMaker.678"); //$NON-NLS-1$
			String string_391_ = Messages.getString("CarMaker.679"); //$NON-NLS-1$
			boolean bool = false;
			for (/**/; i_387_ < string.length() && i_389_ != 2; i_387_++) {
				string_390_ = new StringBuilder().append(Messages.getString("CarMaker.680")).append(string.charAt(i_387_)).toString(); //$NON-NLS-1$
				if (string_390_.equals(Messages.getString("CarMaker.681"))) { //$NON-NLS-1$
					if (bool) {
						i_388_++;
						bool = false;
					}
					if (i_389_ == 1 || i_388_ > i)
						i_389_ = 2;
				} else {
					if (i_388_ == i) {
						string_391_ = new StringBuilder().append(string_391_).append(string_390_).toString();
						i_389_ = 1;
					}
					bool = true;
				}
			}
			if (i_387_ >= string.length())
				objfacend = true;
			if (string_391_.equals(Messages.getString("CarMaker.682"))) //$NON-NLS-1$
				string_391_ = Messages.getString("CarMaker.683"); //$NON-NLS-1$
			if (multf10)
				i_386_ = (int) (Float.valueOf(string_391_).floatValue() * 10.0F);
			else {
				final int i_392_ = string_391_.indexOf(Messages.getString("CarMaker.684"), 0); //$NON-NLS-1$
				if (i_392_ != -1)
					string_391_ = string_391_.substring(0, i_392_);
				i_386_ = Float.valueOf(string_391_).intValue() - 1;
				if (i_386_ < 0)
					i_386_ = 0;
			}
		} catch (final Exception exception) {
			/* empty */
		}
		return i_386_;
	}

	public void openelink() {
		Madness.openurl(Messages.getString("CarMaker.685")); //$NON-NLS-1$
	}

	public void openhlink() {
		Madness.openurl(Messages.getString("CarMaker.686")); //$NON-NLS-1$
	}

	public void openlink() {
		Madness.openurl(Messages.getString("CarMaker.687")); //$NON-NLS-1$
	}

	public boolean ovbutton(final String string, final int i, final int i_395_) {
		rd.setFont(new Font(Messages.getString("CarMaker.688"), 0, 12)); //$NON-NLS-1$
		ftm = rd.getFontMetrics();
		if (string.equals(Messages.getString("CarMaker.689")) || string.equals(Messages.getString("CarMaker.690"))) { //$NON-NLS-1$ //$NON-NLS-2$
			rd.setFont(new Font(Messages.getString("CarMaker.691"), 1, 12)); //$NON-NLS-1$
			ftm = rd.getFontMetrics();
		}
		final int i_396_ = ftm.stringWidth(string);
		final int i_397_ = 4;
		boolean bool = false;
		boolean bool_398_ = false;
		if (Math.abs(xm - i) < i_396_ / 2 + 12 && Math.abs(ym - i_395_ + 5) < 10 && mouses == 1)
			bool = true;
		else
			bool = false;
		if (Math.abs(xm - i) < i_396_ / 2 + 12 && Math.abs(ym - i_395_ + 5) < 10 && mouses == -1) {
			mouses = 0;
			bool_398_ = true;
		}
		if (!bool) {
			rd.setColor(new Color(220, 220, 220));
			rd.fillRect(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i_396_ + 20, 25 - i_397_ * 2);
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ - (17 - i_397_));
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (18 - i_397_), i + i_396_ / 2 + 10, i_395_ - (18 - i_397_));
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_396_ / 2 - 9, i_395_ - (19 - i_397_), i + i_396_ / 2 + 9, i_395_ - (19 - i_397_));
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i + i_396_ / 2 + 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ + 7 - i_397_);
			rd.drawLine(i + i_396_ / 2 + 11, i_395_ - (17 - i_397_), i + i_396_ / 2 + 11, i_395_ + 7 - i_397_);
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i + i_396_ / 2 + 12, i_395_ - (16 - i_397_), i + i_396_ / 2 + 12, i_395_ + 6 - i_397_);
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ + 7 - i_397_, i + i_396_ / 2 + 10, i_395_ + 7 - i_397_);
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ + 8 - i_397_, i + i_396_ / 2 + 10, i_395_ + 8 - i_397_);
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i - i_396_ / 2 - 9, i_395_ + 9 - i_397_, i + i_396_ / 2 + 9, i_395_ + 9 - i_397_);
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i - i_396_ / 2 - 10, i_395_ + 7 - i_397_);
			rd.drawLine(i - i_396_ / 2 - 11, i_395_ - (17 - i_397_), i - i_396_ / 2 - 11, i_395_ + 7 - i_397_);
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - i_396_ / 2 - 12, i_395_ - (16 - i_397_), i - i_396_ / 2 - 12, i_395_ + 6 - i_397_);
			rd.setColor(new Color(0, 0, 0));
			if (string.equals(Messages.getString("CarMaker.692"))) //$NON-NLS-1$
				rd.setColor(new Color(255, 0, 0));
			if (string.equals(Messages.getString("CarMaker.693"))) //$NON-NLS-1$
				rd.setColor(new Color(0, 64, 128));
			rd.drawString(string, i - i_396_ / 2, i_395_);
		} else {
			rd.setColor(new Color(220, 220, 220));
			rd.fillRect(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i_396_ + 20, 25 - i_397_ * 2);
			rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ - (17 - i_397_));
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (18 - i_397_), i + i_396_ / 2 + 10, i_395_ - (18 - i_397_));
			rd.drawLine(i - i_396_ / 2 - 9, i_395_ - (19 - i_397_), i + i_396_ / 2 + 9, i_395_ - (19 - i_397_));
			rd.setColor(new Color(247, 247, 247));
			rd.drawLine(i + i_396_ / 2 + 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ + 7 - i_397_);
			rd.drawLine(i + i_396_ / 2 + 11, i_395_ - (17 - i_397_), i + i_396_ / 2 + 11, i_395_ + 7 - i_397_);
			rd.drawLine(i + i_396_ / 2 + 12, i_395_ - (16 - i_397_), i + i_396_ / 2 + 12, i_395_ + 6 - i_397_);
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ + 7 - i_397_, i + i_396_ / 2 + 10, i_395_ + 7 - i_397_);
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ + 8 - i_397_, i + i_396_ / 2 + 10, i_395_ + 8 - i_397_);
			rd.drawLine(i - i_396_ / 2 - 9, i_395_ + 9 - i_397_, i + i_396_ / 2 + 9, i_395_ + 9 - i_397_);
			rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i - i_396_ / 2 - 10, i_395_ + 7 - i_397_);
			rd.drawLine(i - i_396_ / 2 - 11, i_395_ - (17 - i_397_), i - i_396_ / 2 - 11, i_395_ + 7 - i_397_);
			rd.drawLine(i - i_396_ / 2 - 12, i_395_ - (16 - i_397_), i - i_396_ / 2 - 12, i_395_ + 6 - i_397_);
			rd.setColor(new Color(0, 0, 0));
			if (string.equals(Messages.getString("CarMaker.694"))) //$NON-NLS-1$
				rd.setColor(new Color(255, 0, 0));
			if (string.equals(Messages.getString("CarMaker.695"))) //$NON-NLS-1$
				rd.setColor(new Color(0, 64, 128));
			rd.drawString(string, i - i_396_ / 2 + 1, i_395_ + 1);
		}
		return bool_398_;
	}

	@Override
	public void paint(final Graphics graphics) {
		apx = getWidth() / 2 - 350;
		apy = getHeight() / 2 - 275;
		graphics.drawImage(offImage, apx, apy, this);
	}

	public int py(final int i, final int i_328_, final int i_329_, final int i_330_) {
		return (i - i_328_) * (i - i_328_) + (i_329_ - i_330_) * (i_329_ - i_330_);
	}

	public void regx(final int i, float f, final boolean bool) {
		hitmag += f;
		if (!bool)
			crash(f);
		f *= 0.3F + crash[1] * 0.005F;
		if (Math.abs(f) > 100.0F) {
			int i_315_ = (int) (crash[0] * crash[0] * 1.5);
			if (i_315_ < 1000)
				i_315_ = 1000;
			if (f > 100.0F)
				f -= 100.0F;
			if (f < -100.0F)
				f += 100.0F;
			for (int i_316_ = 0; i_316_ < o.npl; i_316_++) {
				float f_317_ = 0.0F;
				for (int i_318_ = 0; i_318_ < o.p[i_316_].n; i_318_++)
					if (o.p[i_316_].wz == 0
							&& py(o.keyx[i], o.p[i_316_].ox[i_318_], o.keyz[i], o.p[i_316_].oz[i_318_]) < i_315_) {
						f_317_ = f / 20.0F * m.random();
						o.p[i_316_].oz[i_318_] -= f_317_ * m.sin(o.xz) * m.cos(o.zy);
						o.p[i_316_].ox[i_318_] += f_317_ * m.cos(o.xz) * m.cos(o.xy);
						if (bool)
							actmag += Math.abs(f_317_);
					}
				if (f_317_ != 0.0F) {
					if (Math.abs(f_317_) >= 1.0F) {
						o.p[i_316_].chip = 1;
						o.p[i_316_].ctmag = f_317_;
					}
					if (!o.p[i_316_].nocol && o.p[i_316_].glass != 1) {
						if (o.p[i_316_].bfase > 20 && o.p[i_316_].hsb[1] > 0.25)
							o.p[i_316_].hsb[1] = 0.25F;
						if (o.p[i_316_].bfase > 25 && o.p[i_316_].hsb[2] > 0.7)
							o.p[i_316_].hsb[2] = 0.7F;
						if (o.p[i_316_].bfase > 30 && o.p[i_316_].hsb[1] > 0.15)
							o.p[i_316_].hsb[1] = 0.15F;
						if (o.p[i_316_].bfase > 35 && o.p[i_316_].hsb[2] > 0.6)
							o.p[i_316_].hsb[2] = 0.6F;
						if (o.p[i_316_].bfase > 40)
							o.p[i_316_].hsb[0] = 0.075F;
						if (o.p[i_316_].bfase > 50 && o.p[i_316_].hsb[2] > 0.5)
							o.p[i_316_].hsb[2] = 0.5F;
						if (o.p[i_316_].bfase > 60)
							o.p[i_316_].hsb[0] = 0.05F;
						o.p[i_316_].bfase += Math.abs(f_317_);
						new Color(o.p[i_316_].c[0], o.p[i_316_].c[1], o.p[i_316_].c[2]);
						final Color color = Color.getHSBColor(o.p[i_316_].hsb[0], o.p[i_316_].hsb[1],
								o.p[i_316_].hsb[2]);
						o.p[i_316_].c[0] = color.getRed();
						o.p[i_316_].c[1] = color.getGreen();
						o.p[i_316_].c[2] = color.getBlue();
					}
					if (o.p[i_316_].glass == 1)
						o.p[i_316_].gr += Math.abs(f_317_ * 1.5);
				}
			}
		}
	}

	public void regz(final int i, float f, final boolean bool) {
		hitmag += f;
		if (!bool)
			crash(f);
		f *= 0.3F + crash[1] * 0.005F;
		if (Math.abs(f) > 100.0F) {
			int i_319_ = (int) (crash[0] * crash[0] * 1.5);
			if (i_319_ < 1000)
				i_319_ = 1000;
			if (f > 100.0F)
				f -= 100.0F;
			if (f < -100.0F)
				f += 100.0F;
			for (int i_320_ = 0; i_320_ < o.npl; i_320_++) {
				float f_321_ = 0.0F;
				for (int i_322_ = 0; i_322_ < o.p[i_320_].n; i_322_++)
					if (o.p[i_320_].wz == 0
							&& py(o.keyx[i], o.p[i_320_].ox[i_322_], o.keyz[i], o.p[i_320_].oz[i_322_]) < i_319_) {
						f_321_ = f / 20.0F * m.random();
						o.p[i_320_].oz[i_322_] += f_321_ * m.cos(o.xz) * m.cos(o.zy);
						o.p[i_320_].ox[i_322_] += f_321_ * m.sin(o.xz) * m.cos(o.xy);
						if (bool)
							actmag += Math.abs(f_321_);
					}
				if (f_321_ != 0.0F) {
					if (Math.abs(f_321_) >= 1.0F) {
						o.p[i_320_].chip = 1;
						o.p[i_320_].ctmag = f_321_;
					}
					if (!o.p[i_320_].nocol && o.p[i_320_].glass != 1) {
						if (o.p[i_320_].bfase > 20 && o.p[i_320_].hsb[1] > 0.25)
							o.p[i_320_].hsb[1] = 0.25F;
						if (o.p[i_320_].bfase > 25 && o.p[i_320_].hsb[2] > 0.7)
							o.p[i_320_].hsb[2] = 0.7F;
						if (o.p[i_320_].bfase > 30 && o.p[i_320_].hsb[1] > 0.15)
							o.p[i_320_].hsb[1] = 0.15F;
						if (o.p[i_320_].bfase > 35 && o.p[i_320_].hsb[2] > 0.6)
							o.p[i_320_].hsb[2] = 0.6F;
						if (o.p[i_320_].bfase > 40)
							o.p[i_320_].hsb[0] = 0.075F;
						if (o.p[i_320_].bfase > 50 && o.p[i_320_].hsb[2] > 0.5)
							o.p[i_320_].hsb[2] = 0.5F;
						if (o.p[i_320_].bfase > 60)
							o.p[i_320_].hsb[0] = 0.05F;
						o.p[i_320_].bfase += Math.abs(f_321_);
						new Color(o.p[i_320_].c[0], o.p[i_320_].c[1], o.p[i_320_].c[2]);
						final Color color = Color.getHSBColor(o.p[i_320_].hsb[0], o.p[i_320_].hsb[1],
								o.p[i_320_].hsb[2]);
						o.p[i_320_].c[0] = color.getRed();
						o.p[i_320_].c[1] = color.getGreen();
						o.p[i_320_].c[2] = color.getBlue();
					}
					if (o.p[i_320_].glass == 1)
						o.p[i_320_].gr += Math.abs(f_321_ * 1.5);
				}
			}
		}
	}

	public void rencar(final String string) {
		if (string.equals(Messages.getString("CarMaker.696"))) //$NON-NLS-1$
			JOptionPane.showMessageDialog(null, Messages.getString("CarMaker.697"), Messages.getString("CarMaker.698"), 1); //$NON-NLS-1$ //$NON-NLS-2$
		else
			try {
				final File file = new File(
						new StringBuilder().append(Messages.getString("CarMaker.699")).append(carname).append(Messages.getString("CarMaker.700")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				final File file_303_ = new File(
						new StringBuilder().append(Messages.getString("CarMaker.701")).append(string).append(Messages.getString("CarMaker.702")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				if (file.renameTo(file_303_)) {
					carname = string;
					sfase = 0;
					hidefields();
					tabed = -1;
				} else
					JOptionPane
							.showMessageDialog(null,
									new StringBuilder().append(Messages.getString("CarMaker.703")).append(string) //$NON-NLS-1$
											.append(Messages.getString("CarMaker.704")).toString(), //$NON-NLS-1$
									Messages.getString("CarMaker.705"), 1); //$NON-NLS-1$
			} catch (final Exception exception) {
				JOptionPane.showMessageDialog(null, new StringBuilder()
						.append(Messages.getString("CarMaker.706")).append(exception).toString(), Messages.getString("CarMaker.707"), //$NON-NLS-1$ //$NON-NLS-2$
						1);
			}
	}

	public void roofsqsh(float f) {
		if (f > 100.0F) {
			crash(f);
			f -= 100.0F;
			final int i = (int) (2.0 + crash[2] / 7.6);
			int i_323_ = 0;
			int i_324_ = 1;
			for (int i_325_ = 0; i_325_ < o.npl; i_325_++) {
				float f_326_ = 0.0F;
				if (Math.random() > 0.9)
					f_326_ = f / 15.0F * m.random();
				for (int i_327_ = 0; i_327_ < o.p[i_325_].n; i_327_++)
					if (o.p[i_325_].wz == 0 && (Math.abs(o.p[i_325_].oy[i_327_] - o.roofat - squash) < i * 3
							|| o.p[i_325_].oy[i_327_] < o.roofat + squash) && squash < i) {
						f_326_ = f / 15.0F * m.random();
						o.p[i_325_].oy[i_327_] += f_326_;
						i_323_ += f_326_;
						i_324_++;
						hitmag += Math.abs(f_326_);
					}
				if (!o.p[i_325_].nocol && o.p[i_325_].glass != 1) {
					if (f_326_ != 0.0F) {
						if (o.p[i_325_].bfase > 20 && o.p[i_325_].hsb[1] > 0.25)
							o.p[i_325_].hsb[1] = 0.25F;
						if (o.p[i_325_].bfase > 25 && o.p[i_325_].hsb[2] > 0.7)
							o.p[i_325_].hsb[2] = 0.7F;
						if (o.p[i_325_].bfase > 30 && o.p[i_325_].hsb[1] > 0.15)
							o.p[i_325_].hsb[1] = 0.15F;
						if (o.p[i_325_].bfase > 35 && o.p[i_325_].hsb[2] > 0.6)
							o.p[i_325_].hsb[2] = 0.6F;
						if (o.p[i_325_].bfase > 40)
							o.p[i_325_].hsb[0] = 0.075F;
						if (o.p[i_325_].bfase > 50 && o.p[i_325_].hsb[2] > 0.5)
							o.p[i_325_].hsb[2] = 0.5F;
						if (o.p[i_325_].bfase > 60)
							o.p[i_325_].hsb[0] = 0.05F;
						o.p[i_325_].bfase += f_326_;
						new Color(o.p[i_325_].c[0], o.p[i_325_].c[1], o.p[i_325_].c[2]);
						final Color color = Color.getHSBColor(o.p[i_325_].hsb[0], o.p[i_325_].hsb[1],
								o.p[i_325_].hsb[2]);
						o.p[i_325_].c[0] = color.getRed();
						o.p[i_325_].c[1] = color.getGreen();
						o.p[i_325_].c[2] = color.getBlue();
					}
				} else if (o.p[i_325_].glass == 1)
					o.p[i_325_].gr += 5;
				if (Math.abs(f_326_) >= 1.0F) {
					o.p[i_325_].chip = 1;
					o.p[i_325_].ctmag = f_326_;
				}
			}
			squash += i_323_ / i_324_;
		}
	}

	public void rot(final int[] is, final int[] is_331_, final int i, final int i_332_, final int i_333_,
			final int i_334_) {
		if (i_333_ != 0)
			for (int i_335_ = 0; i_335_ < i_334_; i_335_++) {
				final int i_336_ = is[i_335_];
				final int i_337_ = is_331_[i_335_];
				is[i_335_] = i + (int) ((i_336_ - i) * m.cos(i_333_) - (i_337_ - i_332_) * m.sin(i_333_));
				is_331_[i_335_] = i_332_ + (int) ((i_336_ - i) * m.sin(i_333_) + (i_337_ - i_332_) * m.cos(i_333_));
			}
	}

	@Override
	public void run() {
		thredo.setPriority(10);
		btgame[0] = getImage(Messages.getString("CarMaker.708")); //$NON-NLS-1$
		btgame[1] = getImage(Messages.getString("CarMaker.709")); //$NON-NLS-1$
		logo = getImage(Messages.getString("CarMaker.710")); //$NON-NLS-1$
		m.w = 700;
		m.cx = 350;
		m.y = -240;
		m.z = -400;
		m.zy = 4;
		m.focus_point = 800;
		m.fadfrom(8000);
		m.cfade[0] = 187;
		m.cfade[1] = 210;
		m.cfade[2] = 227;
		loadsounds();
		loadbase();
		m.loadnew = true;
		loadsettings();
		editor.setFont(new Font(cfont, 1, 14));
		srch.setFont(new Font(cfont, 1, 14));
		rplc.setFont(new Font(cfont, 1, 14));
		for (int i = 0; i < 16; i++)
			wv[i].setFont(new Font(cfont, 1, 14));
		setheme();
		if (Madness.testdrive != 0) {
			if (Madness.testcar.equals(Messages.getString("CarMaker.711"))) { //$NON-NLS-1$
				JOptionPane.showMessageDialog(null,
						Messages.getString("CarMaker.712"), Messages.getString("CarMaker.713"), 1); //$NON-NLS-1$ //$NON-NLS-2$
				thredo.stop();
			} else {
				carname = Madness.testcar;
				loadfile();
				if (loadedfile) {
					tested = true;
					tab = 2;
					dtab = 6;
					witho.select(Madness.testdrive - 1);
				}
			}
			Madness.testcar = Messages.getString("CarMaker.714"); //$NON-NLS-1$
			Madness.testdrive = 0;
		}
		boolean bool = false;
		if (!carname.equals(Messages.getString("CarMaker.715"))) { //$NON-NLS-1$
			tutok = true;
			bool = true;
		}
		while (!exwist) {
			if (tab != tabed) {
				hidefields();
				if (tab == 1)
					editor.enable();
				else
					editor.disable();
				if (tabed == 2)
					if (!breakbond) {
						if (!editor.getText().equals(lastedo))
							editor.setText(lastedo);
					} else
						breakbond = false;
				setCursor(new Cursor(0));
			}
			rd.setColor(new Color(225, 225, 225));
			rd.fillRect(0, 0, 700, 550);
			rd.setColor(new Color(0, 0, 0));
			btn = 0;
			int i = 50;
			if (tab == 0) {
				if (tabed != tab) {
					slcar.removeAll();
					slcar.maxl = 200;
					slcar.add(rd, Messages.getString("CarMaker.716")); //$NON-NLS-1$
					final String[] strings = new File(Messages.getString("CarMaker.717")).list(); //$NON-NLS-1$
					if (strings != null)
						for (int i_0_ = 0; i_0_ < strings.length; i_0_++)
							if (strings[i_0_].toLowerCase().endsWith(Messages.getString("CarMaker.718"))) //$NON-NLS-1$
								slcar.add(rd, strings[i_0_].substring(0, strings[i_0_].length() - 4));
					if (carname.equals(Messages.getString("CarMaker.719"))) //$NON-NLS-1$
						slcar.select(0);
					else {
						slcar.select(carname);
						if (carname.equals(slcar.getSelectedItem()))
							loadfile();
					}
					mouseon = -1;
					srch.setText(Messages.getString("CarMaker.720")); //$NON-NLS-1$
					sfase = 0;
				}
				rd.setFont(new Font(Messages.getString("CarMaker.721"), 1, 13)); //$NON-NLS-1$
				rd.setColor(new Color(0, 0, 0));
				rd.drawImage(logo, 214, 35, null);
				if (xm > 214 && xm < 485 && ym > 25 && ym < 104 && !openm) {
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
				int i_1_ = 30;
				int i_2_ = 0;
				if (tutok) {
					i_1_ = 250;
					i_2_ = -70;
				}
				if (xm > 76 && xm < 624 && ym > 84 + i_1_ && ym < 167 + i_1_ && !openm) {
					if (mouseon == -1) {
						mouseon = 1;
						setCursor(new Cursor(12));
					}
				} else if (mouseon == 1) {
					mouseon = -1;
					setCursor(new Cursor(0));
				}
				int i_3_ = 0;
				if (!tutok && mouseon != 1 && !bool)
					if (flk <= 0) {
						rd.setColor(new Color(255, 0, 0));
						flk--;
						if (flk == -2)
							flk = 1;
					} else {
						rd.setColor(new Color(0, 0, 255));
						i_3_ = 2;
						flk++;
						if (flk == 3)
							flk = 0;
					}
				rd.drawLine(76 + i_3_, 84 + i_1_, 76 + i_3_, 167 + i_1_);
				rd.drawLine(76 + i_3_, 84 + i_1_, 95 + i_3_, 84 + i_1_);
				rd.drawLine(76 + i_3_, 167 + i_1_, 95 + i_3_, 167 + i_1_);
				rd.drawLine(624 - i_3_, 84 + i_1_, 624 - i_3_, 167 + i_1_);
				rd.drawLine(624 - i_3_, 84 + i_1_, 605 - i_3_, 84 + i_1_);
				rd.drawLine(624 - i_3_, 167 + i_1_, 605 - i_3_, 167 + i_1_);
				if (mouseon == 1)
					rd.setColor(new Color(0, 64, 128));
				else
					rd.setColor(new Color(0, 0, 0));
				rd.drawString(Messages.getString("CarMaker.722"), 106, //$NON-NLS-1$
						110 + i_1_);
				rd.setColor(new Color(0, 128, 255));
				rd.drawString(Messages.getString("CarMaker.723"), 106, 130 + i_1_); //$NON-NLS-1$
				if (mouseon == 1)
					rd.setColor(new Color(0, 128, 255));
				else
					rd.setColor(new Color(0, 64, 128));
				rd.drawLine(106, 131 + i_1_, 480, 131 + i_1_);
				if (mouseon == 1)
					rd.setColor(new Color(0, 64, 128));
				else
					rd.setColor(new Color(0, 0, 0));
				rd.drawString(Messages.getString("CarMaker.724"), 106, //$NON-NLS-1$
						150 + i_1_);
				if (mouseon == 1 && mouses == -1) {
					openlink();
					bool = true;
				}
				if (xm > 200 && xm < 500 && ym > 467 && ym < 504 && !openm) {
					if (mouseon == -1) {
						mouseon = 2;
						setCursor(new Cursor(12));
					}
				} else if (mouseon == 2) {
					mouseon = -1;
					setCursor(new Cursor(0));
				}
				ftm = rd.getFontMetrics();
				if (mouseon == 2)
					rd.setColor(new Color(0, 64, 128));
				else
					rd.setColor(new Color(0, 0, 0));
				rd.drawString(Messages.getString("CarMaker.725"), //$NON-NLS-1$
						350 - ftm.stringWidth(Messages.getString("CarMaker.726")) / 2, 480); //$NON-NLS-1$
				rd.setColor(new Color(0, 128, 255));
				String string = Messages.getString("CarMaker.727"); //$NON-NLS-1$
				rd.drawString(string, 350 - ftm.stringWidth(string) / 2, 500);
				if (mouseon == 2)
					rd.setColor(new Color(0, 128, 255));
				else
					rd.setColor(new Color(0, 64, 128));
				rd.drawLine(350 - ftm.stringWidth(string) / 2, 501, 350 + ftm.stringWidth(string) / 2, 501);
				if (mouseon == 2 && mouses == -1)
					openhlink();
				int i_4_ = 0;
				if (sfase == 3)
					i_4_ = 100;
				rd.setColor(new Color(0, 0, 0));
				rd.drawRect(177 - i_4_, 202 + i_2_, 346 + i_4_ * 2, 167 + i_4_ / 5);
				if (sfase == 0) {
					rd.drawString(Messages.getString("CarMaker.728"), 350 - ftm.stringWidth(Messages.getString("CarMaker.729")) / 2, 230 + i_2_); //$NON-NLS-1$ //$NON-NLS-2$
					slcar.move(250, 240 + i_2_);
					if (slcar.getWidth() != 200)
						slcar.setSize(200, 21);
					if (!slcar.isShowing())
						slcar.setVisible(true);
					stringbutton(Messages.getString("CarMaker.730"), 430, 296 + i_2_, 0, true); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.731"), 270, 296 + i_2_, 0, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.732"), 270, 336 + i_2_, 0, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.733"), 430, 336 + i_2_, 0, false); //$NON-NLS-1$
					if (slcar.getSelectedIndex() != 0) {
						if (!carname.equals(slcar.getSelectedItem())) {
							tomany = false;
							carname = slcar.getSelectedItem();
							loadfile();
							editor.select(0, 0);
							tested = false;
							requestFocus();
						}
					} else
						carname = Messages.getString("CarMaker.734"); //$NON-NLS-1$
				}
				if (sfase == 1) {
					rd.drawString(Messages.getString("CarMaker.735"), 350 - ftm.stringWidth(Messages.getString("CarMaker.736")) / 2, 230 + i_2_); //$NON-NLS-1$ //$NON-NLS-2$
					rd.setFont(new Font(Messages.getString("CarMaker.737"), 1, 12)); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.738"), 228, 266 + i_2_); //$NON-NLS-1$
					movefield(srch, 335, 250 + i_2_, 129, 22);
					if (!srch.isShowing()) {
						srch.setVisible(true);
						srch.requestFocus();
					}
					fixtext(srch);
					stringbutton(Messages.getString("CarMaker.739"), 350, 306 + i_2_, 0, true); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.740"), 350, 346 + i_2_, 0, false); //$NON-NLS-1$
				}
				if (sfase == 2) {
					rd.drawString(new StringBuilder().append(Messages.getString("CarMaker.741")).append(carname).append(Messages.getString("CarMaker.742")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
							350 - ftm.stringWidth(
									new StringBuilder().append(Messages.getString("CarMaker.743")).append(carname).append(Messages.getString("CarMaker.744")).toString()) //$NON-NLS-1$ //$NON-NLS-2$
									/ 2,
							230 + i_2_);
					rd.setFont(new Font(Messages.getString("CarMaker.745"), 1, 12)); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.746"), 239, 266 + i_2_); //$NON-NLS-1$
					movefield(srch, 316, 250 + i_2_, 129, 22);
					if (!srch.isShowing()) {
						srch.setVisible(true);
						srch.requestFocus();
					}
					fixtext(srch);
					stringbutton(Messages.getString("CarMaker.747"), 350, 306 + i_2_, 0, true); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.748"), 350, 346 + i_2_, 0, false); //$NON-NLS-1$
				}
				if (sfase == 3) {
					rd.drawString(Messages.getString("CarMaker.749"), //$NON-NLS-1$
							350 - ftm.stringWidth(Messages.getString("CarMaker.750")) / 2, 230 + i_2_); //$NON-NLS-1$
					if (xm > 116 && xm < 584 && ym > 246 + i_2_ && ym < 290 + i_2_) {
						if (mouseon == -1) {
							mouseon = 3;
							setCursor(new Cursor(12));
						}
					} else if (mouseon == 3) {
						mouseon = -1;
						setCursor(new Cursor(0));
					}
					ftm = rd.getFontMetrics();
					if (mouseon == 3)
						rd.setColor(new Color(0, 64, 128));
					else
						rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("CarMaker.751"), //$NON-NLS-1$
							350 - ftm.stringWidth(
									Messages.getString("CarMaker.752")) / 2, //$NON-NLS-1$
							260 + i_2_);
					rd.setColor(new Color(0, 128, 255));
					string = Messages.getString("CarMaker.753"); //$NON-NLS-1$
					rd.drawString(string, 350 - ftm.stringWidth(string) / 2, 280 + i_2_);
					if (mouseon == 3)
						rd.setColor(new Color(0, 128, 255));
					else
						rd.setColor(new Color(0, 64, 128));
					rd.drawLine(350 - ftm.stringWidth(string) / 2, 281 + i_2_, 350 + ftm.stringWidth(string) / 2,
							281 + i_2_);
					if (mouseon == 3 && mouses == -1)
						openelink();
					stringbutton(Messages.getString("CarMaker.754"), 350, 326 + i_2_, 0, true); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.755"), 550, 326 + i_2_, 0, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.756"), 350, 366 + i_2_, 0, false); //$NON-NLS-1$
				}
				if (sfase == 4) {
					rd.drawString(Messages.getString("CarMaker.757"), 350 - ftm.stringWidth(Messages.getString("CarMaker.758")) / 2, //$NON-NLS-1$ //$NON-NLS-2$
							230 + i_2_);
					slcar.move(250, 240 + i_2_);
					if (slcar.getWidth() != 200)
						slcar.setSize(200, 21);
					if (!slcar.isShowing())
						slcar.setVisible(true);
					stringbutton(Messages.getString("CarMaker.759"), 350, 306 + i_2_, 0, true); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.760"), 350, 346 + i_2_, 0, false); //$NON-NLS-1$
					if (slcar.getSelectedIndex() != 0) {
						if (!carname.equals(slcar.getSelectedItem())) {
							tomany = false;
							carname = slcar.getSelectedItem();
							loadfile();
							editor.select(0, 0);
							tested = false;
							requestFocus();
						}
					} else
						carname = Messages.getString("CarMaker.761"); //$NON-NLS-1$
				}
			}
			if (tab == 1) {
				if (tabed != tab) {
					srch.setText(Messages.getString("CarMaker.762")); //$NON-NLS-1$
					rplc.setText(Messages.getString("CarMaker.763")); //$NON-NLS-1$
					cntchk = 1;
					npolys = 0;
					prefs = false;
				}
				movefield(editor, 5, 30, 690, 400);
				if (!openm) {
					if (!editor.isShowing()) {
						editor.setVisible(true);
						editor.requestFocus();
					}
				} else if (editor.isShowing())
					editor.setVisible(false);
				rd.setFont(new Font(Messages.getString("CarMaker.764"), 1, 12)); //$NON-NLS-1$
				if (prefs) {
					rd.drawString(Messages.getString("CarMaker.765"), 10, 446); //$NON-NLS-1$
					fontsel.move(76, 430);
					if (!fontsel.isShowing()) {
						fontsel.setVisible(true);
						fontsel.select(cfont);
					}
					if (!cfont.equals(fontsel.getSelectedItem())) {
						cntprf = 0;
						cfont = fontsel.getSelectedItem();
						editor.setFont(new Font(cfont, 1, 14));
						srch.setFont(new Font(cfont, 1, 14));
						rplc.setFont(new Font(cfont, 1, 14));
						for (int i_5_ = 0; i_5_ < 16; i_5_++)
							wv[i_5_].setFont(new Font(cfont, 1, 14));
						editor.requestFocus();
					}
					rd.drawString(Messages.getString("CarMaker.766"), 190, 446); //$NON-NLS-1$
					ctheme.move(271, 430);
					if (!ctheme.isShowing()) {
						ctheme.setVisible(true);
						ctheme.select(cthm);
					}
					if (cthm != ctheme.getSelectedIndex()) {
						cntprf = 0;
						cthm = ctheme.getSelectedIndex();
						setheme();
						editor.requestFocus();
					}
					stringbutton(Messages.getString("CarMaker.767"), 400, 446, 3, false); //$NON-NLS-1$
					cntprf++;
					if (cntprf == 200)
						prefs = false;
				} else {
					stringbutton(Messages.getString("CarMaker.768"), 52, 446, 3, false); //$NON-NLS-1$
					if (ctheme.isShowing())
						ctheme.setVisible(false);
					if (fontsel.isShowing())
						fontsel.setVisible(false);
					if (cntprf != 0)
						cntprf = 0;
					if (cntchk == 0) {
						npolys = 0;
						int i_6_ = 0;
						boolean bool_7_ = false;
						while (i_6_ != -1 && mouses != 1) {
							if (!bool_7_)
								i_6_ = editor.getText().indexOf(Messages.getString("CarMaker.769"), i_6_); //$NON-NLS-1$
							else
								i_6_ = editor.getText().indexOf(Messages.getString("CarMaker.770"), i_6_); //$NON-NLS-1$
							if (i_6_ != -1) {
								if (!bool_7_)
									bool_7_ = true;
								else {
									bool_7_ = false;
									npolys++;
								}
								i_6_ += 3;
							}
						}
						if (mouses == 1)
							npolys = 0;
						cntchk = 30;
					} else
						cntchk--;
					if (npolys > 10000)
						rd.setColor(new Color(255, 0, 0));
					if (npolys != 0)
						rd.drawString(new StringBuilder().append(Messages.getString("CarMaker.771")).append(npolys) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.772")).toString(), 200, 446); //$NON-NLS-1$
				}
				if (!changed && !editor.getText().equals(lastedo))
					changed = true;
				stringbutton(Messages.getString("CarMaker.773"), 490, 455, 0, changed); //$NON-NLS-1$
				stringbutton(Messages.getString("CarMaker.774"), 600, 455, 0, changed); //$NON-NLS-1$
				mirror = false;
				polynum = -1;
				cntpls = 0;
				String string = Messages.getString("CarMaker.775"); //$NON-NLS-1$
				try {
					string = editor.getSelectedText();
				} catch (final Exception exception) {
					/* empty */
				}
				if (!string.equals(Messages.getString("CarMaker.776"))) { //$NON-NLS-1$
					int i_8_ = string.indexOf(Messages.getString("CarMaker.777"), 0); //$NON-NLS-1$
					while (i_8_ != -1 && i_8_ + 1 < string.length()) {
						if (!mirror) {
							i_8_ = string.indexOf(Messages.getString("CarMaker.778"), i_8_ + 1); //$NON-NLS-1$
							if (i_8_ != -1) {
								mirror = true;
								cntpls++;
							}
						}
						if (mirror) {
							i_8_ = string.indexOf(Messages.getString("CarMaker.779"), i_8_ + 1); //$NON-NLS-1$
							if (i_8_ != -1)
								mirror = false;
						}
					}
				}
				if (!mirror) {
					rd.setColor(new Color(170, 170, 170));
					rd.drawRect(5, 474, 494, 70);
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("CarMaker.780"), 18, 500); //$NON-NLS-1$
					movefield(srch, 91, 484, 129, 22);
					if (!srch.isShowing())
						srch.setVisible(true);
					boolean bool_9_ = false;
					if (!srch.getText().equals(Messages.getString("CarMaker.781"))) //$NON-NLS-1$
						bool_9_ = true;
					stringbutton(Messages.getString("CarMaker.782"), 117, 526, 2, bool_9_); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.783"), 255, 500); //$NON-NLS-1$
					movefield(rplc, 338, 484, 129, 22);
					if (!rplc.isShowing())
						rplc.setVisible(true);
					bool_9_ = false;
					if (!srch.getText().equals(Messages.getString("CarMaker.784")) && !rplc.getText().equals(Messages.getString("CarMaker.785"))) //$NON-NLS-1$ //$NON-NLS-2$
						bool_9_ = true;
					stringbutton(Messages.getString("CarMaker.786"), 376, 526, 2, bool_9_); //$NON-NLS-1$
				} else {
					if (srch.isShowing())
						srch.setVisible(false);
					if (rplc.isShowing())
						rplc.setVisible(false);
					rd.setColor(new Color(170, 170, 170));
					rd.drawRect(5, 474, 450, 70);
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("CarMaker.787"), 18, 490); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.788"), 90, 525, 2, true); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.789"), 230, 525, 2, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.790"), 370, 525, 2, false); //$NON-NLS-1$
					rd.setColor(new Color(170, 170, 170));
					rd.drawRect(465, 474, 230, 70);
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("CarMaker.791"), 478, 490); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.792"), 580, 523, 0, true); //$NON-NLS-1$
				}
				if (npolys > 10000 && !tomany) {
					repaint();
					JOptionPane.showMessageDialog(null,
							Messages.getString("CarMaker.793"), //$NON-NLS-1$
							Messages.getString("CarMaker.794"), 1); //$NON-NLS-1$
					tomany = true;
				}
			}
			if (tab == 2) {
				if (tabed != tab) {
					setupo();
					dtabed = -1;
				}
				m.d(rd);
				o.d(rd);
				if (dtab == 2) {
					if (compsel > 0 && compsel <= 16) {
						compo[compsel - 1].x = o.x;
						compo[compsel - 1].y = o.y;
						compo[compsel - 1].z = o.z;
						compo[compsel - 1].xz = o.xz;
						compo[compsel - 1].xy = o.xy;
						compo[compsel - 1].zy = o.zy;
						rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
						compo[compsel - 1].d(rd);
						rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
					}
					if (xm > 420 && xm < 690 && ym > 425 && ym < 540) {
						final int[] is = { 50 + adna[0], -50 - adna[1], 0, 0, 0, 0 };
						final int[] is_10_ = { 0, 0, 50 + adna[2], -50 - adna[3], 0, 0 };
						final int[] is_11_ = { 0, 0, 0, 0, 50 + adna[4], -50 - adna[5] };
						for (int i_12_ = 0; i_12_ < 6; i_12_++) {
							is[i_12_] += o.x - m.x;
							is_10_[i_12_] += o.y - m.y;
							is_11_[i_12_] += o.z - m.z;
						}
						rot(is, is_10_, o.x - m.x, o.y - m.y, o.xy, 6);
						rot(is_10_, is_11_, o.y - m.y, o.z - m.z, o.zy, 6);
						rot(is, is_11_, o.x - m.x, o.z - m.z, o.xz, 6);
						rot(is, is_11_, m.cx, m.cz, m.xz, 6);
						rot(is_10_, is_11_, m.cy, m.cz, m.zy, 6);
						final int[] is_13_ = new int[6];
						final int[] is_14_ = new int[6];
						for (int i_15_ = 0; i_15_ < 6; i_15_++) {
							is_13_[i_15_] = xs(is[i_15_], is_11_[i_15_]);
							is_14_[i_15_] = ys(is_10_[i_15_], is_11_[i_15_]);
						}
						rd.setColor(new Color(0, 150, 0));
						rd.drawString(Messages.getString("CarMaker.795"), is_13_[0] - 7, is_14_[0] + 4); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.796"), is_13_[1] - 5, is_14_[1] + 4); //$NON-NLS-1$
						rd.drawLine(is_13_[0], is_14_[0], is_13_[1], is_14_[1]);
						rd.setColor(new Color(150, 0, 0));
						rd.drawString(Messages.getString("CarMaker.797"), is_13_[2] - 7, is_14_[2] + 4); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.798"), is_13_[3] - 5, is_14_[3] + 4); //$NON-NLS-1$
						rd.drawLine(is_13_[2], is_14_[2], is_13_[3], is_14_[3]);
						rd.setColor(new Color(0, 0, 150));
						rd.drawString(Messages.getString("CarMaker.799"), is_13_[4] - 7, is_14_[4] + 4); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.800"), is_13_[5] - 5, is_14_[5] + 4); //$NON-NLS-1$
						rd.drawLine(is_13_[4], is_14_[4], is_13_[5], is_14_[5]);
						for (int i_16_ = 0; i_16_ < 6; i_16_++) {
							if (Math.abs(is_14_[i_16_] - 207) * 1.91F > Math.abs(is_13_[i_16_] - 350)) {
								if (Math.abs(Math.abs(is_14_[i_16_] - 207) - 170) > 10)
									if (Math.abs(is_14_[i_16_] - 207) < 170)
										adna[i_16_] += 10;
									else
										adna[i_16_] -= 10;
							} else if (Math.abs(Math.abs(is_13_[i_16_] - 350) - 338) > 10)
								if (Math.abs(is_13_[i_16_] - 350) < 338)
									adna[i_16_] += 10;
								else
									adna[i_16_] -= 10;
							if (adna[i_16_] > 276)
								adna[i_16_] = 276;
							if (adna[i_16_] < 0)
								adna[i_16_] = 0;
						}
					}
				}
				rd.setColor(new Color(205, 200, 200));
				rd.fillRect(0, 390, 700, 20);
				rd.setColor(new Color(225, 225, 225));
				rd.fillRect(0, 410, 700, 140);
				rd.setFont(new Font(Messages.getString("CarMaker.801"), 1, 12)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				final String[] strings = { Messages.getString("CarMaker.802"), Messages.getString("CarMaker.803"), Messages.getString("CarMaker.804"), Messages.getString("CarMaker.805"), Messages.getString("CarMaker.806"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
						Messages.getString("CarMaker.807"), Messages.getString("CarMaker.808") }; //$NON-NLS-1$ //$NON-NLS-2$
				final int[] is = { 0, 0, 100, 90 };
				final int[] is_17_ = { 390, 410, 410, 390 };
				for (int i_18_ = 0; i_18_ < 7; i_18_++) {
					rd.setColor(new Color(170, 170, 170));
					if (xm > is[0] && xm < is[3] && ym > 390 && ym < 410)
						rd.setColor(new Color(190, 190, 190));
					if (dtab == i_18_)
						rd.setColor(new Color(225, 225, 225));
					rd.fillPolygon(is, is_17_, 4);
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(strings[i_18_], i_18_ * 100 + 47 - ftm.stringWidth(strings[i_18_]) / 2, 404);
					if (xm > is[0] && xm < is[3] && ym > 390 && ym < 410 && mouses == -1)
						dtab = i_18_;
					for (int i_19_ = 0; i_19_ < 4; i_19_++)
						is[i_19_] += 100;
				}
				if (dtabed != dtab) {
					if (dtabed != -1) {
						if (!editor.getText().equals(lastedo))
							editor.setText(lastedo);
						setupo();
					}
					setCursor(new Cursor(0));
					hidefields();
					requestFocus();
				}
				rd.setColor(new Color(0, 0, 0));
				if (dtab == 0) {
					rd.drawString(Messages.getString("CarMaker.809"), 20, 440); //$NON-NLS-1$
					rd.drawString(
							Messages.getString("CarMaker.810"), //$NON-NLS-1$
							20, 465);
					rd.drawString(Messages.getString("CarMaker.811"), 20, 490); //$NON-NLS-1$
					rd.drawString(
							Messages.getString("CarMaker.812"), //$NON-NLS-1$
							20, 515);
				}
				if (dtab == 1)
					if (o.colok != 2) {
						rd.setFont(new Font(Messages.getString("CarMaker.813"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.drawString(Messages.getString("CarMaker.814"), //$NON-NLS-1$
								350 - ftm.stringWidth(Messages.getString("CarMaker.815")) / 2, 450); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.816"), 350, 490, 0, true); //$NON-NLS-1$
					} else {
						if (dtabed != dtab) {
							fcol = new StringBuilder().append(Messages.getString("CarMaker.817")).append(o.fcol[0]).append(Messages.getString("CarMaker.818")).append(o.fcol[1]) //$NON-NLS-1$ //$NON-NLS-2$
									.append(Messages.getString("CarMaker.819")).append(o.fcol[2]).append(Messages.getString("CarMaker.820")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
							srch.setText(fcol);
							ofcol = fcol;
							Color.RGBtoHSB(o.fcol[0], o.fcol[1], o.fcol[2], fhsb);
							float f = fhsb[1];
							fhsb[1] = fhsb[2];
							fhsb[2] = f;
							scol = new StringBuilder().append(Messages.getString("CarMaker.821")).append(o.scol[0]).append(Messages.getString("CarMaker.822")).append(o.scol[1]) //$NON-NLS-1$ //$NON-NLS-2$
									.append(Messages.getString("CarMaker.823")).append(o.scol[2]).append(Messages.getString("CarMaker.824")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
							rplc.setText(scol);
							oscol = scol;
							Color.RGBtoHSB(o.scol[0], o.scol[1], o.scol[2], shsb);
							f = shsb[1];
							shsb[1] = shsb[2];
							shsb[2] = f;
							bfo = 51;
							mouseon = -1;
						}
						if (mouses != 1)
							mouseon = -1;
						rd.setColor(new Color(170, 170, 170));
						rd.drawRect(20, 425, 320, 110);
						rd.setColor(new Color(225, 225, 225));
						rd.fillRect(141, 419, 77, 9);
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(Messages.getString("CarMaker.825"), 151, 428); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.826"), 75, 450); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.827"), 35, 470); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.828"), 38, 490); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.829"), 38, 520); //$NON-NLS-1$
						movefield(srch, 106, 504, 129, 22);
						if (srch.hasFocus())
							focuson = false;
						if (!srch.isShowing())
							srch.setVisible(true);
						for (int i_20_ = 0; i_20_ < 200; i_20_++) {
							rd.setColor(Color.getHSBColor((float) (i_20_ * 0.005), 1.0F, 1.0F));
							rd.drawLine(110 + i_20_, 442, 110 + i_20_, 449);
						}
						for (int i_21_ = 0; i_21_ < 200; i_21_++) {
							rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float) (i_21_ * 0.004)));
							rd.drawLine(110 + i_21_, 462, 110 + i_21_, 469);
						}
						for (int i_22_ = 0; i_22_ < 200; i_22_++) {
							rd.setColor(Color.getHSBColor(fhsb[0], (float) (i_22_ * 0.005), fhsb[1]));
							rd.drawLine(110 + i_22_, 482, 110 + i_22_, 489);
						}
						for (int i_23_ = 0; i_23_ < 3; i_23_++) {
							rd.setColor(new Color(0, 0, 0));
							float f = fhsb[i_23_] * 200.0F;
							if (i_23_ == 1)
								f = (fhsb[i_23_] - 0.2F) * 250.0F;
							rd.drawLine((int) (110.0F + f), 442 + i_23_ * 20, (int) (110.0F + f), 449 + i_23_ * 20);
							rd.drawLine((int) (111.0F + f), 442 + i_23_ * 20, (int) (111.0F + f), 449 + i_23_ * 20);
							rd.fillRect((int) (109.0F + f), 450 + i_23_ * 20, 4, 2);
							rd.drawLine((int) (108.0F + f), 452 + i_23_ * 20, (int) (113.0F + f), 452 + i_23_ * 20);
							if (xm > 107 && xm < 313 && ym > 439 + i_23_ * 20 && ym < 452 + i_23_ * 20 && mouses == 1
									&& mouseon == -1)
								mouseon = i_23_;
							if (mouseon == i_23_) {
								if (i_23_ == 1) {
									fhsb[i_23_] = 0.2F + (xm - 110) / 250.0F;
									if (fhsb[i_23_] < 0.2)
										fhsb[i_23_] = 0.2F;
								} else
									fhsb[i_23_] = (xm - 110) / 200.0F;
								if (fhsb[i_23_] > 1.0F)
									fhsb[i_23_] = 1.0F;
								if (fhsb[i_23_] < 0.0F)
									fhsb[i_23_] = 0.0F;
							}
						}
						stringbutton(Messages.getString("CarMaker.830"), 300, 520, 0, !fcol.equals(ofcol)); //$NON-NLS-1$
						rd.setColor(new Color(170, 170, 170));
						rd.drawRect(360, 425, 320, 110);
						rd.setColor(new Color(225, 225, 225));
						rd.fillRect(472, 419, 95, 9);
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(Messages.getString("CarMaker.831"), 482, 428); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.832"), 415, 450); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.833"), 375, 470); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.834"), 378, 490); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.835"), 378, 520); //$NON-NLS-1$
						movefield(rplc, 446, 504, 129, 22);
						if (rplc.hasFocus())
							focuson = false;
						if (!rplc.isShowing())
							rplc.setVisible(true);
						for (int i_24_ = 0; i_24_ < 200; i_24_++) {
							rd.setColor(Color.getHSBColor((float) (i_24_ * 0.005), 1.0F, 1.0F));
							rd.drawLine(450 + i_24_, 442, 450 + i_24_, 449);
						}
						for (int i_25_ = 0; i_25_ < 200; i_25_++) {
							rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float) (i_25_ * 0.004)));
							rd.drawLine(450 + i_25_, 462, 450 + i_25_, 469);
						}
						for (int i_26_ = 0; i_26_ < 200; i_26_++) {
							rd.setColor(Color.getHSBColor(shsb[0], (float) (i_26_ * 0.005), shsb[2]));
							rd.drawLine(450 + i_26_, 482, 450 + i_26_, 489);
						}
						for (int i_27_ = 0; i_27_ < 3; i_27_++) {
							rd.setColor(new Color(0, 0, 0));
							float f = shsb[i_27_] * 200.0F;
							if (i_27_ == 1)
								f = (shsb[i_27_] - 0.2F) * 250.0F;
							rd.drawLine((int) (450.0F + f), 442 + i_27_ * 20, (int) (450.0F + f), 449 + i_27_ * 20);
							rd.drawLine((int) (451.0F + f), 442 + i_27_ * 20, (int) (451.0F + f), 449 + i_27_ * 20);
							rd.fillRect((int) (449.0F + f), 450 + i_27_ * 20, 4, 2);
							rd.drawLine((int) (448.0F + f), 452 + i_27_ * 20, (int) (453.0F + f), 452 + i_27_ * 20);
							if (xm > 447 && xm < 653 && ym > 439 + i_27_ * 20 && ym < 452 + i_27_ * 20 && mouses == 1
									&& mouseon == -1)
								mouseon = i_27_ + 3;
							if (mouseon == i_27_ + 3) {
								if (i_27_ == 1) {
									shsb[i_27_] = 0.2F + (xm - 450) / 250.0F;
									if (shsb[i_27_] < 0.2)
										shsb[i_27_] = 0.2F;
								} else
									shsb[i_27_] = (xm - 450) / 200.0F;
								if (shsb[i_27_] > 1.0F)
									shsb[i_27_] = 1.0F;
								if (shsb[i_27_] < 0.0F)
									shsb[i_27_] = 0.0F;
							}
						}
						stringbutton(Messages.getString("CarMaker.836"), 640, 520, 0, !scol.equals(oscol)); //$NON-NLS-1$
						if (fhsb[1] < 0.2)
							fhsb[1] = 0.2F;
						if (shsb[1] < 0.2)
							shsb[1] = 0.2F;
						for (int i_28_ = 0; i_28_ < o.npl; i_28_++) {
							if (o.p[i_28_].colnum == 1) {
								o.p[i_28_].hsb[0] = fhsb[0];
								o.p[i_28_].hsb[1] = fhsb[2];
								o.p[i_28_].hsb[2] = fhsb[1];
							}
							if (o.p[i_28_].colnum == 2) {
								o.p[i_28_].hsb[0] = shsb[0];
								o.p[i_28_].hsb[1] = shsb[2];
								o.p[i_28_].hsb[2] = shsb[1];
							}
						}
						String string = new StringBuilder().append(Messages.getString("CarMaker.837")) //$NON-NLS-1$
								.append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getRed()).append(Messages.getString("CarMaker.838")) //$NON-NLS-1$
								.append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getGreen()).append(Messages.getString("CarMaker.839")) //$NON-NLS-1$
								.append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getBlue()).append(Messages.getString("CarMaker.840")).toString(); //$NON-NLS-1$
						if (!fcol.equals(string)) {
							fcol = string;
							srch.setText(fcol);
						}
						string = new StringBuilder().append(Messages.getString("CarMaker.841")) //$NON-NLS-1$
								.append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getRed()).append(Messages.getString("CarMaker.842")) //$NON-NLS-1$
								.append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getGreen()).append(Messages.getString("CarMaker.843")) //$NON-NLS-1$
								.append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getBlue()).append(Messages.getString("CarMaker.844")).toString(); //$NON-NLS-1$
						if (!scol.equals(string)) {
							scol = string;
							rplc.setText(scol);
						}
						if (srch.getText().equals(fcol) && rplc.getText().equals(scol)) {
							if (bfo < 50)
								bfo++;
							else if (bfo == 50) {
								requestFocus();
								bfo = 51;
							}
						} else {
							bfo = 0;
							if (!srch.getText().equals(fcol)) {
								fcol = srch.getText();
								final int[] is_29_ = new int[3];
								boolean bool_30_ = true;
								try {
									final int i_31_ = fcol.indexOf(Messages.getString("CarMaker.845"), 0); //$NON-NLS-1$
									final int i_32_ = fcol.indexOf(Messages.getString("CarMaker.846"), i_31_ + 1); //$NON-NLS-1$
									is_29_[0] = Integer.valueOf(fcol.substring(1, i_31_)).intValue();
									if (is_29_[0] < 0)
										is_29_[0] = 0;
									if (is_29_[0] > 255)
										is_29_[0] = 255;
									is_29_[1] = Integer.valueOf(fcol.substring(i_31_ + 1, i_32_)).intValue();
									if (is_29_[1] < 0)
										is_29_[1] = 0;
									if (is_29_[1] > 255)
										is_29_[1] = 255;
									is_29_[2] = Integer.valueOf(fcol.substring(i_32_ + 1, fcol.length() - 1))
											.intValue();
									if (is_29_[2] < 0)
										is_29_[2] = 0;
									if (is_29_[2] > 255)
										is_29_[2] = 255;
								} catch (final Exception exception) {
									bool_30_ = false;
								}
								if (bool_30_) {
									Color.RGBtoHSB(is_29_[0], is_29_[1], is_29_[2], fhsb);
									final float f = fhsb[1];
									fhsb[1] = fhsb[2];
									fhsb[2] = f;
								}
							}
							if (!rplc.getText().equals(scol)) {
								scol = rplc.getText();
								final int[] is_33_ = new int[3];
								boolean bool_34_ = true;
								try {
									final int i_35_ = scol.indexOf(Messages.getString("CarMaker.847"), 0); //$NON-NLS-1$
									final int i_36_ = scol.indexOf(Messages.getString("CarMaker.848"), i_35_ + 1); //$NON-NLS-1$
									is_33_[0] = Integer.valueOf(scol.substring(1, i_35_)).intValue();
									if (is_33_[0] < 0)
										is_33_[0] = 0;
									if (is_33_[0] > 255)
										is_33_[0] = 255;
									is_33_[1] = Integer.valueOf(scol.substring(i_35_ + 1, i_36_)).intValue();
									if (is_33_[1] < 0)
										is_33_[1] = 0;
									if (is_33_[1] > 255)
										is_33_[1] = 255;
									is_33_[2] = Integer.valueOf(scol.substring(i_36_ + 1, scol.length() - 1))
											.intValue();
									if (is_33_[2] < 0)
										is_33_[2] = 0;
									if (is_33_[2] > 255)
										is_33_[2] = 255;
								} catch (final Exception exception) {
									bool_34_ = false;
								}
								if (bool_34_) {
									Color.RGBtoHSB(is_33_[0], is_33_[1], is_33_[2], shsb);
									final float f = shsb[1];
									shsb[1] = shsb[2];
									shsb[2] = f;
								}
							}
						}
					}
				if (dtab == 2) {
					if (dtabed != dtab) {
						lastedo = editor.getText();
						scale[0] = 100;
						int i_37_ = editor.getText().indexOf(Messages.getString("CarMaker.849"), 0); //$NON-NLS-1$
						if (i_37_ != -1) {
							i_37_++;
							try {
								scale[0] = Integer.valueOf(
										editor.getText().substring(i_37_ + 7, editor.getText().indexOf(Messages.getString("CarMaker.850"), i_37_))) //$NON-NLS-1$
										.intValue();
							} catch (final Exception exception) {
								scale[0] = 100;
							}
						}
						oscale[0] = scale[0];
						scale[1] = 100;
						i_37_ = editor.getText().indexOf(Messages.getString("CarMaker.851"), 0); //$NON-NLS-1$
						if (i_37_ != -1) {
							i_37_++;
							try {
								scale[1] = Integer.valueOf(
										editor.getText().substring(i_37_ + 7, editor.getText().indexOf(Messages.getString("CarMaker.852"), i_37_))) //$NON-NLS-1$
										.intValue();
							} catch (final Exception exception) {
								scale[1] = 100;
							}
						}
						oscale[1] = scale[1];
						scale[2] = 100;
						i_37_ = editor.getText().indexOf(Messages.getString("CarMaker.853"), 0); //$NON-NLS-1$
						if (i_37_ != -1) {
							i_37_++;
							try {
								scale[2] = Integer.valueOf(
										editor.getText().substring(i_37_ + 7, editor.getText().indexOf(Messages.getString("CarMaker.854"), i_37_))) //$NON-NLS-1$
										.intValue();
							} catch (final Exception exception) {
								scale[2] = 100;
							}
						}
						oscale[2] = scale[2];
						bfo = 0;
						compsel = 0;
						compcar.select(compsel);
						changed2 = false;
					}
					rd.setColor(new Color(170, 170, 170));
					rd.drawRect(9, 425, 270, 115);
					rd.setColor(new Color(225, 225, 225));
					rd.fillRect(119, 419, 51, 9);
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("CarMaker.855"), 129, 428); //$NON-NLS-1$
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("CarMaker.856"), 25, 450); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.857"), 92, 450, 4, false); //$NON-NLS-1$
					rd.drawString(new StringBuilder().append(Messages.getString("CarMaker.858")).append(scale[0] / 100.0F).append(Messages.getString("CarMaker.859")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
							126 - ftm.stringWidth(
									new StringBuilder().append(Messages.getString("CarMaker.860")).append(scale[0] / 100.0F).append(Messages.getString("CarMaker.861")).toString()) / 2, //$NON-NLS-1$ //$NON-NLS-2$
							450);
					stringbutton(Messages.getString("CarMaker.862"), 160, 450, 4, false); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.863"), 25, 474); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.864"), 92, 474, 4, false); //$NON-NLS-1$
					rd.drawString(new StringBuilder().append(Messages.getString("CarMaker.865")).append(scale[1] / 100.0F).append(Messages.getString("CarMaker.866")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
							126 - ftm.stringWidth(
									new StringBuilder().append(Messages.getString("CarMaker.867")).append(scale[1] / 100.0F).append(Messages.getString("CarMaker.868")).toString()) / 2, //$NON-NLS-1$ //$NON-NLS-2$
							474);
					stringbutton(Messages.getString("CarMaker.869"), 160, 474, 4, false); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.870"), 25, 498); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.871"), 92, 498, 4, false); //$NON-NLS-1$
					rd.drawString(new StringBuilder().append(Messages.getString("CarMaker.872")).append(scale[2] / 100.0F).append(Messages.getString("CarMaker.873")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
							126 - ftm.stringWidth(
									new StringBuilder().append(Messages.getString("CarMaker.874")).append(scale[2] / 100.0F).append(Messages.getString("CarMaker.875")).toString()) / 2, //$NON-NLS-1$ //$NON-NLS-2$
							498);
					stringbutton(Messages.getString("CarMaker.876"), 160, 498, 4, false); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.877"), 25, 527); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.878"), 106, 527, 2, true); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.879"), 146, 527, 2, true); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.880"), 230, 454, 0, //$NON-NLS-1$
							oscale[0] != scale[0] || oscale[1] != scale[1] || oscale[2] != scale[2]);
					stringbutton(Messages.getString("CarMaker.881"), 230, 493, 0, false); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.882"), 296, 440); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.883"), 308, 455); //$NON-NLS-1$
					compcar.move(288, 462);
					if (compcar.hasFocus()) {
						focuson = false;
						bfo++;
						if (bfo == 100)
							requestFocus();
					} else
						bfo = 0;
					if (!compcar.isShowing())
						compcar.setVisible(true);
					if (compsel != compcar.getSelectedIndex()) {
						compsel = compcar.getSelectedIndex();
						requestFocus();
					}
					rd.setColor(new Color(170, 170, 170));
					rd.drawRect(420, 425, 270, 115);
					rd.setColor(new Color(225, 225, 225));
					rd.fillRect(531, 419, 47, 9);
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("CarMaker.884"), 541, 428); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.885"), 433, 450); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.886"), 535, 450, 4, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.887"), 607, 450, 4, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.888"), 656, 450, 4, false); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.889"), 433, 474); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.890"), 535, 474, 4, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.891"), 607, 474, 4, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.892"), 656, 474, 4, false); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.893"), 433, 498); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.894"), 535, 498, 4, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.895"), 607, 498, 4, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.896"), 656, 498, 4, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.897"), 490, 527, 0, false); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.898"), 607, 527, 0, changed2); //$NON-NLS-1$
				}
				if (dtab == 3) {
					if (dtabed != dtab) {
						int i_38_ = 45;
						int i_39_ = 45;
						int i_40_ = 15;
						int i_41_ = 15;
						int i_42_ = 76;
						int i_43_ = -76;
						int i_44_ = 26;
						int i_45_ = 26;
						int i_46_ = 20;
						int i_47_ = 20;
						int i_48_ = 18;
						int i_49_ = 18;
						int i_50_ = 10;
						int i_51_ = 10;
						int i_52_ = 0;
						int i_53_ = 0;
						String string = Messages.getString("CarMaker.899"); //$NON-NLS-1$
						String string_54_ = Messages.getString("CarMaker.900"); //$NON-NLS-1$
						int i_55_ = 0;
						final String string_56_ = new StringBuilder().append(Messages.getString("CarMaker.901")).append(editor.getText()).append(Messages.getString("CarMaker.902")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						int i_57_ = 0;
						int i_58_ = string_56_.indexOf(Messages.getString("CarMaker.903"), 0); //$NON-NLS-1$
						int i_59_ = 0;
						int i_60_ = 15;
						int i_61_ = 20;
						String string_62_ = Messages.getString("CarMaker.904"); //$NON-NLS-1$
						while (i_58_ != -1 && i_57_ < string_56_.length()) {
							String string_63_ = string_56_.substring(i_57_, i_58_);
							string_63_ = string_63_.trim();
							i_57_ = i_58_ + 1;
							i_58_ = string_56_.indexOf(Messages.getString("CarMaker.905"), i_57_); //$NON-NLS-1$
							try {
								if (string_63_.startsWith(Messages.getString("CarMaker.906"))) { //$NON-NLS-1$
									string_62_ = new StringBuilder().append(Messages.getString("CarMaker.907")).append(getvalue(Messages.getString("CarMaker.908"), string_63_, 0)) //$NON-NLS-1$ //$NON-NLS-2$
											.append(Messages.getString("CarMaker.909")).append(getvalue(Messages.getString("CarMaker.910"), string_63_, 1)).append(Messages.getString("CarMaker.911")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
											.append(getvalue(Messages.getString("CarMaker.912"), string_63_, 2)).append(Messages.getString("CarMaker.913")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
									i_60_ = getvalue(Messages.getString("CarMaker.914"), string_63_, 3); //$NON-NLS-1$
									i_61_ = getvalue(Messages.getString("CarMaker.915"), string_63_, 4); //$NON-NLS-1$
								}
								if (string_63_.startsWith(Messages.getString("CarMaker.916"))) //$NON-NLS-1$
									i_59_ = getvalue(Messages.getString("CarMaker.917"), string_63_, 0); //$NON-NLS-1$
								if (string_63_.startsWith(Messages.getString("CarMaker.918"))) { //$NON-NLS-1$
									final int i_64_ = getvalue(Messages.getString("CarMaker.919"), string_63_, 2); //$NON-NLS-1$
									if (i_64_ > 0) {
										i_38_ = Math.abs(getvalue(Messages.getString("CarMaker.920"), string_63_, 0)); //$NON-NLS-1$
										i_40_ = getvalue(Messages.getString("CarMaker.921"), string_63_, 1); //$NON-NLS-1$
										i_42_ = i_64_;
										i_44_ = Math.abs(getvalue(Messages.getString("CarMaker.922"), string_63_, 4)); //$NON-NLS-1$
										i_46_ = Math.abs(getvalue(Messages.getString("CarMaker.923"), string_63_, 5)); //$NON-NLS-1$
										string = string_62_;
										i_48_ = i_60_;
										i_50_ = i_61_;
										i_52_ = i_59_;
									} else {
										i_39_ = Math.abs(getvalue(Messages.getString("CarMaker.924"), string_63_, 0)); //$NON-NLS-1$
										i_41_ = getvalue(Messages.getString("CarMaker.925"), string_63_, 1); //$NON-NLS-1$
										i_43_ = i_64_;
										i_45_ = Math.abs(getvalue(Messages.getString("CarMaker.926"), string_63_, 4)); //$NON-NLS-1$
										i_47_ = Math.abs(getvalue(Messages.getString("CarMaker.927"), string_63_, 5)); //$NON-NLS-1$
										string_54_ = string_62_;
										i_49_ = i_60_;
										i_51_ = i_61_;
										i_53_ = i_59_;
									}
									i_55_++;
								}
							} catch (final Exception exception) {
								/* empty */
							}
						}
						if (i_55_ != 4)
							defnow = true;
						else
							defnow = false;
						wv[0].setText(new StringBuilder().append(Messages.getString("CarMaker.928")).append(i_39_).append(Messages.getString("CarMaker.929")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[1].setText(new StringBuilder().append(Messages.getString("CarMaker.930")).append(i_41_).append(Messages.getString("CarMaker.931")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[2].setText(new StringBuilder().append(Messages.getString("CarMaker.932")).append(i_43_).append(Messages.getString("CarMaker.933")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[3].setText(new StringBuilder().append(Messages.getString("CarMaker.934")).append(i_47_).append(Messages.getString("CarMaker.935")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[4].setText(new StringBuilder().append(Messages.getString("CarMaker.936")).append(i_45_).append(Messages.getString("CarMaker.937")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						srch.setText(string_54_);
						wv[5].setText(new StringBuilder().append(Messages.getString("CarMaker.938")).append(i_49_).append(Messages.getString("CarMaker.939")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[6].setText(new StringBuilder().append(Messages.getString("CarMaker.940")).append(i_51_).append(Messages.getString("CarMaker.941")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[7].setText(new StringBuilder().append(Messages.getString("CarMaker.942")).append(i_53_).append(Messages.getString("CarMaker.943")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[8].setText(new StringBuilder().append(Messages.getString("CarMaker.944")).append(i_38_).append(Messages.getString("CarMaker.945")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[9].setText(new StringBuilder().append(Messages.getString("CarMaker.946")).append(i_40_).append(Messages.getString("CarMaker.947")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[10].setText(new StringBuilder().append(Messages.getString("CarMaker.948")).append(i_42_).append(Messages.getString("CarMaker.949")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[11].setText(new StringBuilder().append(Messages.getString("CarMaker.950")).append(i_46_).append(Messages.getString("CarMaker.951")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[12].setText(new StringBuilder().append(Messages.getString("CarMaker.952")).append(i_44_).append(Messages.getString("CarMaker.953")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						rplc.setText(string);
						wv[13].setText(new StringBuilder().append(Messages.getString("CarMaker.954")).append(i_48_).append(Messages.getString("CarMaker.955")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[14].setText(new StringBuilder().append(Messages.getString("CarMaker.956")).append(i_50_).append(Messages.getString("CarMaker.957")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						wv[15].setText(new StringBuilder().append(Messages.getString("CarMaker.958")).append(i_52_).append(Messages.getString("CarMaker.959")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						aply1 = new StringBuilder().append(Messages.getString("CarMaker.960")).append(wv[0].getText()).append(Messages.getString("CarMaker.961")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[1].getText()).append(Messages.getString("CarMaker.962")).append(wv[2].getText()).append(Messages.getString("CarMaker.963")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[3].getText()).append(Messages.getString("CarMaker.964")).append(wv[4].getText()).append(Messages.getString("CarMaker.965")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(srch.getText()).append(Messages.getString("CarMaker.966")).append(wv[5].getText()).append(Messages.getString("CarMaker.967")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[6].getText()).append(Messages.getString("CarMaker.968")).append(wv[7].getText()).append(Messages.getString("CarMaker.969")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						aply2 = new StringBuilder().append(Messages.getString("CarMaker.970")).append(wv[8].getText()).append(Messages.getString("CarMaker.971")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[9].getText()).append(Messages.getString("CarMaker.972")).append(wv[10].getText()).append(Messages.getString("CarMaker.973")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[11].getText()).append(Messages.getString("CarMaker.974")).append(wv[12].getText()).append(Messages.getString("CarMaker.975")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(rplc.getText()).append(Messages.getString("CarMaker.976")).append(wv[13].getText()).append(Messages.getString("CarMaker.977")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[14].getText()).append(Messages.getString("CarMaker.978")).append(wv[15].getText()).append(Messages.getString("CarMaker.979")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
						aplyd1 = false;
						aplyd2 = false;
						changed2 = false;
						mouseon = -1;
					}
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(Messages.getString("CarMaker.980"), 12, 424); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.981"), 12, 449); //$NON-NLS-1$
					movefield(wv[0], 35, 433, 40, 22);
					rd.drawString(Messages.getString("CarMaker.982"), 86, 449); //$NON-NLS-1$
					movefield(wv[1], 101, 433, 40, 22);
					rd.drawString(Messages.getString("CarMaker.983"), 151, 449); //$NON-NLS-1$
					movefield(wv[2], 166, 433, 40, 22);
					rd.drawString(Messages.getString("CarMaker.984"), 12, 479); //$NON-NLS-1$
					movefield(wv[3], 56, 463, 40, 22);
					rd.drawString(Messages.getString("CarMaker.985"), 107, 479); //$NON-NLS-1$
					movefield(wv[4], 148, 463, 40, 22);
					rd.drawString(Messages.getString("CarMaker.986"), 12, 509); //$NON-NLS-1$
					movefield(srch, 109, 493, 129, 22);
					rd.drawString(Messages.getString("CarMaker.987"), 12, 539); //$NON-NLS-1$
					movefield(wv[5], 76, 523, 40, 22);
					rd.drawString(Messages.getString("CarMaker.988"), 126, 539); //$NON-NLS-1$
					movefield(wv[6], 199, 523, 40, 22);
					if (xm > 245 && xm < 336 && ym > 524 && ym < 541) {
						rd.setColor(new Color(255, 0, 0));
						rd.drawLine(248, 540, 279, 540);
						rd.drawLine(327, 540, 334, 540);
						if (mouseon == -1) {
							mouseon = 1;
							setCursor(new Cursor(12));
						}
					} else if (mouseon == 1) {
						mouseon = -1;
						setCursor(new Cursor(0));
					}
					rd.drawString(Messages.getString("CarMaker.989"), 249, 539); //$NON-NLS-1$
					movefield(wv[7], 282, 523, 40, 22);
					stringbutton(Messages.getString("CarMaker.990"), 300, 440, 0, aplyd1); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.991"), 300, 477, 0, changed2); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.992"), 362, 424); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.993"), 362, 449); //$NON-NLS-1$
					movefield(wv[8], 385, 433, 40, 22);
					rd.drawString(Messages.getString("CarMaker.994"), 436, 449); //$NON-NLS-1$
					movefield(wv[9], 451, 433, 40, 22);
					rd.drawString(Messages.getString("CarMaker.995"), 501, 449); //$NON-NLS-1$
					movefield(wv[10], 516, 433, 40, 22);
					rd.drawString(Messages.getString("CarMaker.996"), 362, 479); //$NON-NLS-1$
					movefield(wv[11], 406, 463, 40, 22);
					rd.drawString(Messages.getString("CarMaker.997"), 457, 479); //$NON-NLS-1$
					movefield(wv[12], 498, 463, 40, 22);
					rd.drawString(Messages.getString("CarMaker.998"), 362, 509); //$NON-NLS-1$
					movefield(rplc, 459, 493, 129, 22);
					rd.drawString(Messages.getString("CarMaker.999"), 362, 539); //$NON-NLS-1$
					movefield(wv[13], 426, 523, 40, 22);
					rd.drawString(Messages.getString("CarMaker.1000"), 476, 539); //$NON-NLS-1$
					movefield(wv[14], 549, 523, 40, 22);
					if (xm > 595 && xm < 686 && ym > 524 && ym < 541) {
						rd.setColor(new Color(255, 0, 0));
						rd.drawLine(598, 540, 629, 540);
						rd.drawLine(677, 540, 684, 540);
						if (mouseon == -1) {
							mouseon = 2;
							setCursor(new Cursor(12));
						}
					} else if (mouseon == 2) {
						mouseon = -1;
						setCursor(new Cursor(0));
					}
					rd.drawString(Messages.getString("CarMaker.1001"), 599, 539); //$NON-NLS-1$
					movefield(wv[15], 632, 523, 40, 22);
					stringbutton(Messages.getString("CarMaker.1002"), 650, 440, 0, aplyd2); //$NON-NLS-1$
					stringbutton(Messages.getString("CarMaker.1003"), 650, 477, 0, changed2); //$NON-NLS-1$
					if (mouses == -1 && (mouseon == 1 || mouseon == 2))
						JOptionPane.showMessageDialog(null,
								Messages.getString("CarMaker.1004"), //$NON-NLS-1$
								Messages.getString("CarMaker.1005"), 1); //$NON-NLS-1$
					for (int i_65_ = 0; i_65_ < 16; i_65_++) {
						if (wv[i_65_].hasFocus())
							focuson = false;
						if (!wv[i_65_].isShowing())
							wv[i_65_].setVisible(true);
					}
					if (srch.hasFocus())
						focuson = false;
					if (!srch.isShowing())
						srch.setVisible(true);
					if (rplc.hasFocus())
						focuson = false;
					if (!rplc.isShowing())
						rplc.setVisible(true);
					if (!focuson) {
						if (!aplyd1 && !aply1.equals(new StringBuilder().append(Messages.getString("CarMaker.1006")).append(wv[0].getText()).append(Messages.getString("CarMaker.1007")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[1].getText()).append(Messages.getString("CarMaker.1008")).append(wv[2].getText()).append(Messages.getString("CarMaker.1009")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[3].getText()).append(Messages.getString("CarMaker.1010")).append(wv[4].getText()).append(Messages.getString("CarMaker.1011")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(srch.getText()).append(Messages.getString("CarMaker.1012")).append(wv[5].getText()).append(Messages.getString("CarMaker.1013")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[6].getText()).append(Messages.getString("CarMaker.1014")).append(wv[7].getText()).append(Messages.getString("CarMaker.1015")).toString())) //$NON-NLS-1$ //$NON-NLS-2$
							aplyd1 = true;
						if (!aplyd2 && !aply2.equals(new StringBuilder().append(Messages.getString("CarMaker.1016")).append(wv[8].getText()).append(Messages.getString("CarMaker.1017")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[9].getText()).append(Messages.getString("CarMaker.1018")).append(wv[10].getText()).append(Messages.getString("CarMaker.1019")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[11].getText()).append(Messages.getString("CarMaker.1020")).append(wv[12].getText()).append(Messages.getString("CarMaker.1021")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(rplc.getText()).append(Messages.getString("CarMaker.1022")).append(wv[13].getText()).append(Messages.getString("CarMaker.1023")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(wv[14].getText()).append(Messages.getString("CarMaker.1024")).append(wv[15].getText()).append(Messages.getString("CarMaker.1025")).toString())) //$NON-NLS-1$ //$NON-NLS-2$
							aplyd2 = true;
					}
					rd.setColor(new Color(170, 170, 170));
					rd.drawLine(350, 410, 350, 550);
					rd.drawLine(300, 409, 400, 409);
				}
				if (dtab == 4) {
					if (dtabed != dtab) {
						changed2 = false;
						statdef = false;
						final String string = new StringBuilder().append(Messages.getString("CarMaker.1026")).append(editor.getText()).append(Messages.getString("CarMaker.1027")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						int i_66_ = 0;
						int i_67_ = string.indexOf(Messages.getString("CarMaker.1028"), 0); //$NON-NLS-1$
						while (i_67_ != -1 && i_66_ < string.length()) {
							String string_68_ = string.substring(i_66_, i_67_);
							string_68_ = string_68_.trim();
							i_66_ = i_67_ + 1;
							i_67_ = string.indexOf(Messages.getString("CarMaker.1029"), i_66_); //$NON-NLS-1$
							try {
								if (string_68_.startsWith(Messages.getString("CarMaker.1030"))) { //$NON-NLS-1$
									int i_69_ = 0;
									for (int i_70_ = 0; i_70_ < 5; i_70_++) {
										stat[i_70_] = getvalue(Messages.getString("CarMaker.1031"), string_68_, i_70_); //$NON-NLS-1$
										if (stat[i_70_] > 200)
											stat[i_70_] = 200;
										if (stat[i_70_] < 16)
											stat[i_70_] = 16;
										i_69_ += stat[i_70_];
									}
									int i_71_ = 0;
									if (i_69_ > 680) {
										i_71_ = 680 - i_69_;
										changed2 = true;
									}
									if (i_69_ > 640 && i_69_ < 680) {
										i_71_ = 640 - i_69_;
										changed2 = true;
									}
									if (i_69_ > 600 && i_69_ < 640) {
										i_71_ = 600 - i_69_;
										changed2 = true;
									}
									if (i_69_ > 560 && i_69_ < 600) {
										i_71_ = 560 - i_69_;
										changed2 = true;
									}
									if (i_69_ > 520 && i_69_ < 560) {
										i_71_ = 520 - i_69_;
										changed2 = true;
									}
									if (i_69_ < 520) {
										i_71_ = 520 - i_69_;
										changed2 = true;
									}
									while (i_71_ != 0)
										for (int i_72_ = 0; i_72_ < 5; i_72_++) {
											if (i_71_ > 0 && stat[i_72_] < 200) {
												stat[i_72_]++;
												i_71_--;
											}
											if (i_71_ < 0 && stat[i_72_] > 16) {
												stat[i_72_]--;
												i_71_++;
											}
										}
									for (int i_73_ = 0; i_73_ < 5; i_73_++)
										rstat[i_73_] = stat[i_73_];
									statdef = true;
								}
							} catch (final Exception exception) {
								statdef = false;
							}
						}
						if (statdef) {
							if (simcar.getItemCount() == 16)
								simcar.add(rd, Messages.getString("CarMaker.1032")); //$NON-NLS-1$
						} else if (simcar.getItemCount() == 17)
							simcar.remove(Messages.getString("CarMaker.1033")); //$NON-NLS-1$
					}
					rd.setColor(new Color(0, 0, 0));
					if (!statdef) {
						rd.setFont(new Font(Messages.getString("CarMaker.1034"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.drawString(Messages.getString("CarMaker.1035"), 350 //$NON-NLS-1$
								- ftm.stringWidth(Messages.getString("CarMaker.1036")) / 2, //$NON-NLS-1$
								450);
						simcar.move(288, 460);
						if (!simcar.isShowing())
							simcar.setVisible(true);
						stringbutton(Messages.getString("CarMaker.1037"), 350, 515, 0, true); //$NON-NLS-1$
					} else {
						rd.drawString(Messages.getString("CarMaker.1038"), 54, 435); //$NON-NLS-1$
						cls.move(34, 440);
						if (!cls.isShowing())
							cls.setVisible(true);
						boolean bool_74_ = false;
						int i_75_ = 0;
						for (int i_76_ = 0; i_76_ < 5; i_76_++) {
							i_75_ += stat[i_76_];
							if (stat[i_76_] != rstat[i_76_])
								bool_74_ = true;
						}
						if (clsel != cls.getSelectedIndex()) {
							clsel = cls.getSelectedIndex();
							int i_77_ = (4 - clsel) * 40 + 520 - i_75_;
							while (i_77_ != 0)
								for (int i_78_ = 0; i_78_ < 5; i_78_++) {
									if (i_77_ > 0 && stat[i_78_] < 200) {
										stat[i_78_]++;
										i_77_--;
									}
									if (i_77_ < 0 && stat[i_78_] > 16) {
										stat[i_78_]--;
										i_77_++;
									}
								}
						}
						if (4 - (i_75_ - 520) / 40 != cls.getSelectedIndex()) {
							clsel = 4 - (i_75_ - 520) / 40;
							cls.select(clsel);
						}
						rd.drawString(Messages.getString("CarMaker.1039"), 36, 490); //$NON-NLS-1$
						simcar.move(20, 495);
						if (!simcar.isShowing())
							simcar.setVisible(true);
						if (carsel != simcar.getSelectedIndex()) {
							carsel = simcar.getSelectedIndex();
							if (carsel != 16)
								for (int i_79_ = 0; i_79_ < 5; i_79_++)
									stat[i_79_] = carstat[carsel][i_79_];
							requestFocus();
						}
						int i_80_ = 60;
						int i_81_ = 16;
						for (int i_82_ = 0; i_82_ < 16; i_82_++) {
							int i_83_ = 0;
							for (int i_84_ = 0; i_84_ < 5; i_84_++)
								i_83_ += Math.abs(carstat[i_82_][i_84_] - stat[i_84_]);
							if (i_83_ < i_80_) {
								i_81_ = i_82_;
								i_80_ = i_83_;
							}
						}
						if (i_81_ != carsel) {
							carsel = i_81_;
							if (carsel < simcar.getItemCount())
								simcar.select(carsel);
						}
						rd.drawString(Messages.getString("CarMaker.1040"), 196, 435); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.1041"), 160, 459); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.1042"), 195, 483); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.1043"), 183, 507); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.1044"), 171, 531); //$NON-NLS-1$
						for (int i_85_ = 0; i_85_ < 5; i_85_++) {
							for (int i_86_ = 0; i_86_ < stat[i_85_]; i_86_++) {
								rd.setColor(Color.getHSBColor((float) (i_86_ * 7.0E-4), 1.0F, 1.0F));
								rd.drawLine(250 + i_86_, 426 + i_85_ * 24, 250 + i_86_, 434 + i_85_ * 24);
							}
							rd.setColor(new Color(0, 0, 0));
							rd.drawLine(249, 426 + i_85_ * 24, 249, 434 + i_85_ * 24);
							rd.drawLine(450, 426 + i_85_ * 24, 450, 434 + i_85_ * 24);
							rd.drawLine(249, 435 + i_85_ * 24, 450, 435 + i_85_ * 24);
							for (int i_87_ = 0; i_87_ < 7; i_87_++)
								rd.drawLine(275 + i_87_ * 25, 434 + i_85_ * 24, 275 + i_87_ * 25, 430 + i_85_ * 24);
							stringbutton(Messages.getString("CarMaker.1045"), 480, 435 + i_85_ * 24, 4, false); //$NON-NLS-1$
							stringbutton(Messages.getString("CarMaker.1046"), 520, 435 + i_85_ * 24, 4, false); //$NON-NLS-1$
						}
						if (carsel < 16 && i_80_ != 0)
							stringbutton(Messages.getString("CarMaker.1047"), 80, 534, 4, true); //$NON-NLS-1$
						else
							stringbutton(Messages.getString("CarMaker.1048"), 80, -1000, 4, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1049"), 620, 459, 0, bool_74_ || changed2); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1050"), 620, 507, 0, false); //$NON-NLS-1$
					}
				}
				if (dtab == 5) {
					if (dtabed != dtab) {
						mouseon = -1;
						pfase = 0;
						if (o.keyz[0] <= 0 || o.keyx[0] >= 0)
							pfase = -1;
						if (o.keyz[1] <= 0 || o.keyx[1] <= 0)
							pfase = -1;
						if (o.keyz[2] >= 0 || o.keyx[2] >= 0)
							pfase = -1;
						if (o.keyz[3] >= 0 || o.keyx[3] <= 0)
							pfase = -1;
						crashok = false;
						if (Math.random() > Math.random())
							crashleft = false;
						else
							crashleft = true;
						engsel = 0;
						if (pfase == 0) {
							final String string = new StringBuilder().append(Messages.getString("CarMaker.1051")).append(editor.getText()).append(Messages.getString("CarMaker.1052")) //$NON-NLS-1$ //$NON-NLS-2$
									.toString();
							int i_88_ = 0;
							int i_89_ = string.indexOf(Messages.getString("CarMaker.1053"), 0); //$NON-NLS-1$
							while (i_89_ != -1 && i_88_ < string.length()) {
								String string_90_ = string.substring(i_88_, i_89_);
								string_90_ = string_90_.trim();
								i_88_ = i_89_ + 1;
								i_89_ = string.indexOf(Messages.getString("CarMaker.1054"), i_88_); //$NON-NLS-1$
								try {
									if (string_90_.startsWith(Messages.getString("CarMaker.1055"))) { //$NON-NLS-1$
										for (int i_91_ = 0; i_91_ < 11; i_91_++) {
											phys[i_91_] = getvalue(Messages.getString("CarMaker.1056"), string_90_, i_91_); //$NON-NLS-1$
											if (phys[i_91_] > 100)
												phys[i_91_] = 100;
											if (phys[i_91_] < 0)
												phys[i_91_] = 0;
										}
										for (int i_92_ = 0; i_92_ < 11; i_92_++)
											rphys[i_92_] = phys[i_92_];
										for (int i_93_ = 0; i_93_ < 3; i_93_++) {
											crash[i_93_] = getvalue(Messages.getString("CarMaker.1057"), string_90_, i_93_ + 11); //$NON-NLS-1$
											if (crash[i_93_] > 100)
												crash[i_93_] = 100;
											if (crash[i_93_] < 0)
												crash[i_93_] = 0;
										}
										for (int i_94_ = 0; i_94_ < 3; i_94_++)
											rcrash[i_94_] = crash[i_94_];
										engsel = getvalue(Messages.getString("CarMaker.1058"), string_90_, 14); //$NON-NLS-1$
										if (engsel > 4)
											engsel = 0;
										if (engsel < 0)
											engsel = 0;
										crashok = true;
									}
								} catch (final Exception exception) {
									crashok = false;
								}
							}
						}
						engon = false;
					}
					int i_95_ = -1;
					if (pfase == 0) {
						for (int i_96_ = 0; i_96_ < 4; i_96_++) {
							rd.setColor(new Color(0, 0, 0));
							if (xm > pnx[i_96_] && xm < 230 && ym > 433 + i_96_ * 24 && ym < 453 + i_96_ * 24) {
								i_95_ = i_96_;
								rd.setColor(new Color(176, 64, 0));
								rd.drawLine(pnx[i_96_], 448 + i_96_ * 24, 128, 448 + i_96_ * 24);
							}
							rd.drawString(new StringBuilder().append(Messages.getString("CarMaker.1059")).append(pname[i_96_]).append(Messages.getString("CarMaker.1060")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									pnx[i_96_], 447 + i_96_ * 24);
							rd.drawLine(140, 443 + i_96_ * 24, 230, 443 + i_96_ * 24);
							for (int i_97_ = 1; i_97_ < 10; i_97_++)
								rd.drawLine(140 + 10 * i_97_, 443 - i_97_ + i_96_ * 24, 140 + 10 * i_97_,
										443 + i_97_ + i_96_ * 24);
							rd.setColor(new Color(255, 0, 0));
							final int i_98_ = (int) (phys[i_96_] / 1.1111F / 10.0F);
							rd.fillRect(138 + (int) (phys[i_96_] / 1.1111F), 443 - i_98_ + i_96_ * 24, 5,
									i_98_ * 2 + 1);
							rd.setColor(new Color(255, 128, 0));
							rd.drawRect(139 + (int) (phys[i_96_] / 1.1111F), 434 + i_96_ * 24, 2, 18);
							stringbutton(Messages.getString("CarMaker.1061"), 260, 447 + i_96_ * 24, 4, false); //$NON-NLS-1$
							stringbutton(Messages.getString("CarMaker.1062"), 300, 447 + i_96_ * 24, 4, false); //$NON-NLS-1$
						}
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(Messages.getString("CarMaker.1063"), 333, 447); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1064"), 380, 496, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1065"), 455, 496, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1066"), 570, 496, 0, true); //$NON-NLS-1$
					}
					if (pfase == 1) {
						for (int i_99_ = 0; i_99_ < 4; i_99_++) {
							rd.setColor(new Color(0, 0, 0));
							if (xm > pnx[i_99_ + 5] && xm < 211 && ym > 433 + i_99_ * 24 && ym < 453 + i_99_ * 24) {
								i_95_ = i_99_ + 5;
								rd.setColor(new Color(176, 64, 0));
								rd.drawLine(pnx[i_99_ + 5], 448 + i_99_ * 24, 109, 448 + i_99_ * 24);
							}
							rd.drawString(
									new StringBuilder().append(Messages.getString("CarMaker.1067")).append(pname[i_99_ + 5]).append(Messages.getString("CarMaker.1068")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									pnx[i_99_ + 5], 447 + i_99_ * 24);
							rd.drawLine(121, 443 + i_99_ * 24, 211, 443 + i_99_ * 24);
							for (int i_100_ = 1; i_100_ < 10; i_100_++)
								rd.drawLine(121 + 10 * i_100_, 443 - i_100_ + i_99_ * 24, 121 + 10 * i_100_,
										443 + i_100_ + i_99_ * 24);
							rd.setColor(new Color(255, 0, 0));
							final int i_101_ = (int) (phys[i_99_ + 5] / 1.1111F / 10.0F);
							rd.fillRect(119 + (int) (phys[i_99_ + 5] / 1.1111F), 443 - i_101_ + i_99_ * 24, 5,
									i_101_ * 2 + 1);
							rd.setColor(new Color(255, 128, 0));
							rd.drawRect(120 + (int) (phys[i_99_ + 5] / 1.1111F), 434 + i_99_ * 24, 2, 18);
							stringbutton(Messages.getString("CarMaker.1069"), 241, 447 + i_99_ * 24, 4, false); //$NON-NLS-1$
							stringbutton(Messages.getString("CarMaker.1070"), 281, 447 + i_99_ * 24, 4, false); //$NON-NLS-1$
						}
						for (int i_102_ = 0; i_102_ < 2; i_102_++) {
							rd.setColor(new Color(0, 0, 0));
							if (xm > pnx[i_102_ + 9] && xm < 548 && ym > 433 + i_102_ * 24 && ym < 453 + i_102_ * 24) {
								i_95_ = i_102_ + 9;
								rd.setColor(new Color(176, 64, 0));
								rd.drawLine(pnx[i_102_ + 9], 448 + i_102_ * 24, 446, 448 + i_102_ * 24);
							}
							rd.drawString(
									new StringBuilder().append(Messages.getString("CarMaker.1071")).append(pname[i_102_ + 9]).append(Messages.getString("CarMaker.1072")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									pnx[i_102_ + 9], 447 + i_102_ * 24);
							rd.drawLine(458, 443 + i_102_ * 24, 548, 443 + i_102_ * 24);
							for (int i_103_ = 1; i_103_ < 10; i_103_++)
								rd.drawLine(458 + 10 * i_103_, 443 - i_103_ + i_102_ * 24, 458 + 10 * i_103_,
										443 + i_103_ + i_102_ * 24);
							rd.setColor(new Color(255, 0, 0));
							final int i_104_ = (int) (phys[i_102_ + 9] / 1.1111F / 10.0F);
							rd.fillRect(456 + (int) (phys[i_102_ + 9] / 1.1111F), 443 - i_104_ + i_102_ * 24, 5,
									i_104_ * 2 + 1);
							rd.setColor(new Color(255, 128, 0));
							rd.drawRect(457 + (int) (phys[i_102_ + 9] / 1.1111F), 434 + i_102_ * 24, 2, 18);
							stringbutton(Messages.getString("CarMaker.1073"), 578, 447 + i_102_ * 24, 4, false); //$NON-NLS-1$
							stringbutton(Messages.getString("CarMaker.1074"), 618, 447 + i_102_ * 24, 4, false); //$NON-NLS-1$
						}
						stringbutton(Messages.getString("CarMaker.1075"), 361, 519, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1076"), 436, 519, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1077"), 509, 519, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1078"), 603, 519, 0, true); //$NON-NLS-1$
					}
					if (pfase == 2) {
						if (xm > 40 && xm < 670 && ym > 416 && ym < 436) {
							i_95_ = 11;
							rd.setColor(new Color(176, 64, 0));
							rd.drawLine(596, 431, 669, 431);
						}
						rd.drawString(
								Messages.getString("CarMaker.1079"), //$NON-NLS-1$
								180, 430);
						if (hitmag < 0)
							hitmag = 0;
						if (hitmag > 17000) {
							crashok = true;
							hitmag = 17000;
							for (int i_105_ = 0; i_105_ < o.npl; i_105_++)
								if ((o.p[i_105_].wz == 0 || o.p[i_105_].gr == -17 || o.p[i_105_].gr == -16)
										&& o.p[i_105_].embos == 0)
									o.p[i_105_].embos = 1;
						}
						rd.setColor(new Color(255, (int) (250.0F - hitmag / 68.0F), 0));
						rd.fillRect(322, 423, (int) (hitmag / 170.0F), 7);
						rd.setColor(new Color(255, 0, 0));
						rd.drawRect(322, 423, 100, 7);
						if (i_95_ != 11)
							rd.setColor(new Color(170, 170, 170));
						else
							rd.setColor(new Color(176, 64, 0));
						rd.drawString(Messages.getString("CarMaker.1080"), 39, 438); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.1081"), 501, 438); //$NON-NLS-1$
						rd.drawLine(125, 426, 179, 426);
						rd.drawLine(125, 426, 125, 440);
						rd.drawLine(491, 426, 437, 426);
						rd.drawLine(491, 426, 491, 440);
						rd.drawRect(19, 440, 276, 91);
						rd.drawRect(339, 440, 312, 67);
						rd.setColor(new Color(0, 0, 0));
						if (xm > 50 && xm < 195 && ym > 446 && ym < 466) {
							i_95_ = 12;
							rd.setColor(new Color(176, 64, 0));
							rd.drawLine(50, 461, 94, 461);
						}
						rd.drawString(Messages.getString("CarMaker.1082"), 50, 460); //$NON-NLS-1$
						rd.drawLine(105, 456, 195, 456);
						for (int i_106_ = 1; i_106_ < 10; i_106_++)
							rd.drawLine(105 + 10 * i_106_, 456 - i_106_, 105 + 10 * i_106_, 456 + i_106_);
						rd.setColor(new Color(255, 0, 0));
						int i_107_ = (int) (crash[0] / 1.1111F / 10.0F);
						rd.fillRect(103 + (int) (crash[0] / 1.1111F), 456 - i_107_, 5, i_107_ * 2 + 1);
						rd.setColor(new Color(255, 128, 0));
						rd.drawRect(104 + (int) (crash[0] / 1.1111F), 447, 2, 18);
						stringbutton(Messages.getString("CarMaker.1083"), 225, 460, 4, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1084"), 265, 460, 4, false); //$NON-NLS-1$
						rd.setColor(new Color(0, 0, 0));
						if (xm > 30 && xm < 195 && ym > 470 && ym < 490) {
							i_95_ = 13;
							rd.setColor(new Color(176, 64, 0));
							rd.drawLine(30, 485, 94, 485);
						}
						rd.drawString(Messages.getString("CarMaker.1085"), 30, 484); //$NON-NLS-1$
						rd.drawLine(105, 480, 195, 480);
						for (int i_108_ = 1; i_108_ < 10; i_108_++)
							rd.drawLine(105 + 10 * i_108_, 480 - i_108_, 105 + 10 * i_108_, 480 + i_108_);
						rd.setColor(new Color(255, 0, 0));
						i_107_ = (int) (crash[1] / 1.1111F / 10.0F);
						rd.fillRect(103 + (int) (crash[1] / 1.1111F), 480 - i_107_, 5, i_107_ * 2 + 1);
						rd.setColor(new Color(255, 128, 0));
						rd.drawRect(104 + (int) (crash[1] / 1.1111F), 471, 2, 18);
						stringbutton(Messages.getString("CarMaker.1086"), 225, 484, 4, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1087"), 265, 484, 4, false); //$NON-NLS-1$
						rd.setColor(new Color(0, 0, 0));
						if (xm > 350 && xm < 551 && ym > 446 && ym < 466) {
							i_95_ = 14;
							rd.setColor(new Color(176, 64, 0));
							rd.drawLine(350, 461, 450, 461);
						}
						rd.drawString(Messages.getString("CarMaker.1088"), 350, 460); //$NON-NLS-1$
						rd.drawLine(461, 456, 551, 456);
						for (int i_109_ = 1; i_109_ < 10; i_109_++)
							rd.drawLine(461 + 10 * i_109_, 456 - i_109_, 461 + 10 * i_109_, 456 + i_109_);
						rd.setColor(new Color(255, 0, 0));
						i_107_ = (int) (crash[2] / 1.1111F / 10.0F);
						rd.fillRect(459 + (int) (crash[2] / 1.1111F), 456 - i_107_, 5, i_107_ * 2 + 1);
						rd.setColor(new Color(255, 128, 0));
						rd.drawRect(460 + (int) (crash[2] / 1.1111F), 447, 2, 18);
						stringbutton(Messages.getString("CarMaker.1089"), 581, 460, 4, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1090"), 621, 460, 4, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1091"), 143, 516, 0, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1092"), 235, 516, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1093"), 484, 492, 0, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1094"), 591, 492, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1095"), 435, 535, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1096"), 508, 535, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1097"), 602, 535, 0, true); //$NON-NLS-1$
					}
					if (pfase == 3) {
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(Messages.getString("CarMaker.1098"), 30, 440); //$NON-NLS-1$
						engine.move(293, 424);
						if (!engine.isShowing()) {
							engine.setVisible(true);
							engine.select(engsel);
						}
						if (engsel != engine.getSelectedIndex()) {
							engsel = engine.getSelectedIndex();
							for (int i_110_ = 0; i_110_ < 5; i_110_++)
								for (int i_111_ = 0; i_111_ < 5; i_111_++) {
									engs[i_111_][i_110_].stop();
									engs[i_111_][i_110_].checkopen();
								}
							engon = false;
						}
						if (engsel == 0)
							rd.drawString(
									Messages.getString("CarMaker.1099"), 30, //$NON-NLS-1$
									470);
						if (engsel == 1)
							rd.drawString(
									Messages.getString("CarMaker.1100"), //$NON-NLS-1$
									30, 470);
						if (engsel == 2)
							rd.drawString(Messages.getString("CarMaker.1101"), 30, //$NON-NLS-1$
									470);
						if (engsel == 3)
							rd.drawString(
									Messages.getString("CarMaker.1102"), //$NON-NLS-1$
									30, 470);
						if (engsel == 4)
							rd.drawString(
									Messages.getString("CarMaker.1103"), //$NON-NLS-1$
									30, 470);
						rd.drawString(Messages.getString("CarMaker.1104"), 30, 500); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1105"), 108, 500, 0, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1106"), 170, 500, 0, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1107"), 240, 500, 0, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1108"), 310, 500, 0, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1109"), 389, 500, 0, true); //$NON-NLS-1$
						if (engon)
							stringbutton(Messages.getString("CarMaker.1110"), 240, 535, 0, true); //$NON-NLS-1$
						else
							stringbutton(Messages.getString("CarMaker.1111"), 240, -2500, 0, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1112"), 500, 525, 0, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1113"), 610, 525, 0, true); //$NON-NLS-1$
					}
					if (pfase == 4) {
						rd.drawString(Messages.getString("CarMaker.1114"), 265, 470); //$NON-NLS-1$
						repaint();
						try {
							if (thredo != null) {
								/* empty */
							}
							Thread.sleep(100L);
						} catch (final InterruptedException interruptedexception) {
							/* empty */
						}
						for (int i_112_ = 0; i_112_ < 4; i_112_++) {
							int i_113_ = 0;
							int i_114_ = 4;
							if (i_112_ == 1)
								i_114_ = 2;
							if (i_112_ == 2)
								i_113_ = 2;
							for (int i_115_ = 0; i_115_ < 10; i_115_++) {
								setupo();
								o.xy = 0;
								hitmag = 0;
								int i_116_ = 0;
								actmag = 0;
								int i_117_ = i_113_;
								boolean bool_118_ = false;
								while (hitmag < 17000) {
									if (bool_118_)
										regx(i_117_, (int) (150.0 + 600.0 * Math.random()), true);
									else
										regz(i_117_, (int) (150.0 + 600.0 * Math.random()), true);
									if (++i_117_ == i_114_) {
										o.xz += 45;
										o.zy += 45;
										i_117_ = 0;
										if (bool_118_)
											bool_118_ = false;
										else
											bool_118_ = true;
										if (i_116_ == actmag)
											crash[0] += 10;
										i_116_ = actmag;
									}
								}
							}
							float f = 0.0F;
							for (int i_119_ = 0; i_119_ < 10; i_119_++) {
								setupo();
								o.xy = 0;
								actmag = 0;
								hitmag = 0;
								int i_120_ = i_113_;
								boolean bool_121_ = false;
								while (hitmag < 17000) {
									if (bool_121_)
										regx(i_120_, (int) (150.0 + 600.0 * Math.random()), true);
									else
										regz(i_120_, (int) (150.0 + 600.0 * Math.random()), true);
									if (++i_120_ == i_114_) {
										o.xz += 45;
										o.zy += 45;
										i_120_ = 0;
										if (bool_121_)
											bool_121_ = false;
										else
											bool_121_ = true;
									}
								}
								f += (float) actmag / (float) hitmag;
							}
							f /= 10.0F;
							actmag = (int) (hitmag * f);
							// if (stat[4] > 200)
							// stat[4] = 200;
							if (stat[4] < 16)
								stat[4] = 16;
							float f_122_ = 0.9F + (stat[4] - 90) * 0.01F;
							if (f_122_ < 0.6)
								f_122_ = 0.6F;
							if (stat[4] == 200 && stat[0] <= 88)
								f_122_ = 3.0F;
							final int i_123_ = (int) (actmag * f_122_);
							for (int i_124_ = 0; i_124_ < 12; i_124_++) {
								setupo();
								o.xy = 0;
								o.xz = 90 * i_124_;
								if (o.xz >= 360)
									o.xz -= 360;
								hitmag = 0;
								int i_125_ = 0;
								actmag = 0;
								int i_126_ = i_113_;
								boolean bool_127_ = false;
								while (actmag < i_123_) {
									if (bool_127_)
										regx(i_126_, (int) (150.0 + 600.0 * Math.random()), true);
									else
										regz(i_126_, (int) (150.0 + 600.0 * Math.random()), true);
									if (++i_126_ == i_114_) {
										if (bool_127_)
											bool_127_ = false;
										else
											bool_127_ = true;
										i_126_ = 0;
										if (i_125_ == actmag)
											crash[0] += 10;
										i_125_ = actmag;
									}
								}
							}
							if (i_112_ == 3) {
								f = 0.0F;
								for (int i_128_ = 0; i_128_ < 10; i_128_++) {
									setupo();
									o.xy = 0;
									actmag = 0;
									hitmag = 0;
									int i_129_ = i_113_;
									boolean bool_130_ = false;
									while (hitmag < 17000) {
										if (bool_130_)
											regx(i_129_, (int) (150.0 + 600.0 * Math.random()), true);
										else
											regz(i_129_, (int) (150.0 + 600.0 * Math.random()), true);
										if (++i_129_ == i_114_) {
											o.xz += 45;
											o.zy += 45;
											i_129_ = 0;
											if (bool_130_)
												bool_130_ = false;
											else
												bool_130_ = true;
										}
									}
									f += (float) actmag / (float) hitmag;
								}
								f /= 10.0F;
								actmag = (int) (hitmag * f);
							}
						}
						setupo();
						final String string = new StringBuilder().append(Messages.getString("CarMaker.1115")).append(editor.getText()).append(Messages.getString("CarMaker.1116")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						String string_131_ = Messages.getString("CarMaker.1117"); //$NON-NLS-1$
						int i_132_ = 0;
						int i_133_ = string.indexOf(Messages.getString("CarMaker.1118"), 0); //$NON-NLS-1$
						while (i_133_ != -1 && i_132_ < string.length()) {
							String string_134_ = string.substring(i_132_, i_133_);
							string_134_ = string_134_.trim();
							i_132_ = i_133_ + 1;
							i_133_ = string.indexOf(Messages.getString("CarMaker.1119"), i_132_); //$NON-NLS-1$
							if (!string_134_.startsWith(Messages.getString("CarMaker.1120"))) //$NON-NLS-1$
								string_131_ = new StringBuilder().append(string_131_).append(Messages.getString("CarMaker.1121")).append(string_134_) //$NON-NLS-1$
										.append(Messages.getString("CarMaker.1122")).toString(); //$NON-NLS-1$
							else {
								string_131_ = string_131_.trim();
								string_131_ = new StringBuilder().append(string_131_).append(Messages.getString("CarMaker.1123")).toString(); //$NON-NLS-1$
							}
						}
						string_131_ = string_131_.trim();
						string_131_ = new StringBuilder().append(string_131_).append(Messages.getString("CarMaker.1124")).append(phys[0]) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.1125")).append(phys[1]).append(Messages.getString("CarMaker.1126")).append(phys[2]).append(Messages.getString("CarMaker.1127")).append(phys[3]) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(Messages.getString("CarMaker.1128")).append(phys[4]).append(Messages.getString("CarMaker.1129")).append(phys[5]).append(Messages.getString("CarMaker.1130")).append(phys[6]) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(Messages.getString("CarMaker.1131")).append(phys[7]).append(Messages.getString("CarMaker.1132")).append(phys[8]).append(Messages.getString("CarMaker.1133")).append(phys[9]) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(Messages.getString("CarMaker.1134")).append(phys[10]).append(Messages.getString("CarMaker.1135")).append(crash[0]).append(Messages.getString("CarMaker.1136")).append(crash[1]) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(Messages.getString("CarMaker.1137")).append(crash[2]).append(Messages.getString("CarMaker.1138")).append(engsel).append(Messages.getString("CarMaker.1139")).append(actmag) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
								.append(Messages.getString("CarMaker.1140")).toString(); //$NON-NLS-1$
						editor.setText(string_131_);
						savefile();
						for (int i_135_ = 0; i_135_ < 11; i_135_++)
							rphys[i_135_] = phys[i_135_];
						for (int i_136_ = 0; i_136_ < 3; i_136_++)
							rcrash[i_136_] = crash[i_136_];
						pfase = 5;
					}
					if (pfase == 5) {
						rd.drawString(Messages.getString("CarMaker.1141"), 231, 450); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.1142"), 242, 490); //$NON-NLS-1$
					}
					if (i_95_ != -1) {
						if (mouseon == -1) {
							mouseon = i_95_;
							setCursor(new Cursor(12));
						}
					} else if (mouseon != -1) {
						mouseon = -1;
						setCursor(new Cursor(0));
					}
					if (mouses == -1 && i_95_ != -1)
						JOptionPane.showMessageDialog(null, usage[i_95_], Messages.getString("CarMaker.1143"), 1); //$NON-NLS-1$
				}
				if (dtab == 6) {
					if (dtab != dtabed) {
						final String string = new StringBuilder().append(Messages.getString("CarMaker.1144")).append(editor.getText()).append(Messages.getString("CarMaker.1145")) //$NON-NLS-1$ //$NON-NLS-2$
								.toString();
						int i_137_ = 0;
						int i_138_ = string.indexOf(Messages.getString("CarMaker.1146"), 0); //$NON-NLS-1$
						while (i_138_ != -1 && i_137_ < string.length()) {
							String string_139_ = string.substring(i_137_, i_138_);
							string_139_ = string_139_.trim();
							i_137_ = i_138_ + 1;
							i_138_ = string.indexOf(Messages.getString("CarMaker.1147"), i_137_); //$NON-NLS-1$
							if (string_139_.startsWith(Messages.getString("CarMaker.1148"))) //$NON-NLS-1$
								try {
									handling = getvalue(Messages.getString("CarMaker.1149"), string_139_, 0); //$NON-NLS-1$
									if (handling > 200)
										handling = 200;
									if (handling < 50)
										handling = 50;
								} catch (final Exception exception) {
									/* empty */
								}
						}
						rateh = false;
					}
					if (!rateh) {
						rd.setFont(new Font(Messages.getString("CarMaker.1150"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.drawString(Messages.getString("CarMaker.1151"), 350 - ftm.stringWidth(Messages.getString("CarMaker.1152")) / 2, 445); //$NON-NLS-1$ //$NON-NLS-2$
						witho.move(292, 455);
						if (!witho.isShowing())
							witho.setVisible(true);
						stringbutton(Messages.getString("CarMaker.1153"), 350, 505, 0, true); //$NON-NLS-1$
						if (tested) {
							stringbutton(Messages.getString("CarMaker.1154"), 150, 471, 0, false); //$NON-NLS-1$
							stringbutton(Messages.getString("CarMaker.1155"), 150, 505, 0, false); //$NON-NLS-1$
							stringbutton(Messages.getString("CarMaker.1156"), 550, 471, 0, true); //$NON-NLS-1$
						}
					} else {
						rd.setFont(new Font(Messages.getString("CarMaker.1157"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.drawString(
								new StringBuilder().append(Messages.getString("CarMaker.1158")) //$NON-NLS-1$
										.append(carname).append(Messages.getString("CarMaker.1159")).toString(), //$NON-NLS-1$
								350 - ftm.stringWidth(
										new StringBuilder().append(Messages.getString("CarMaker.1160")) //$NON-NLS-1$
												.append(carname).append(Messages.getString("CarMaker.1161")).toString()) //$NON-NLS-1$
										/ 2,
								445);
						rd.setFont(new Font(Messages.getString("CarMaker.1162"), 1, 12)); //$NON-NLS-1$
						rd.drawString(Messages.getString("CarMaker.1163"), 183, 483); //$NON-NLS-1$
						for (int i_140_ = 0; i_140_ < handling; i_140_++) {
							rd.setColor(Color.getHSBColor((float) (i_140_ * 7.0E-4), 1.0F, 1.0F));
							rd.drawLine(250 + i_140_, 474, 250 + i_140_, 482);
						}
						rd.setColor(new Color(0, 0, 0));
						rd.drawLine(249, 474, 249, 482);
						rd.drawLine(450, 474, 450, 482);
						rd.drawLine(249, 483, 450, 483);
						for (int i_141_ = 0; i_141_ < 7; i_141_++)
							rd.drawLine(275 + i_141_ * 25, 482, 275 + i_141_ * 25, 478);
						stringbutton(Messages.getString("CarMaker.1164"), 480, 483, 4, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1165"), 520, 483, 4, false); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1166"), 388, 525, 0, true); //$NON-NLS-1$
						stringbutton(Messages.getString("CarMaker.1167"), 298, 525, 0, false); //$NON-NLS-1$
					}
				}
				if (polynum >= 0 && cntpls > 0) {
					for (int i_142_ = 0; i_142_ < o.npl; i_142_++)
						if (i_142_ >= polynum && i_142_ < polynum + cntpls) {
							if (pflk)
								o.p[i_142_].hsb[2] = 1.0F;
							else {
								o.p[i_142_].hsb[2] = 0.0F;
								o.p[i_142_].hsb[0] = Math.abs(0.5F - o.p[i_142_].hsb[0]);
								while (o.p[i_142_].hsb[0] > 1.0F)
									o.p[i_142_].hsb[0]--;
							}
						} else if (prflk > 6 && prflk < 20)
							o.p[i_142_].gr = -13;
						else
							o.p[i_142_].gr = 1;
					if (pflk)
						pflk = false;
					else
						pflk = true;
					if (prflk < 40)
						prflk++;
					rd.setFont(new Font(Messages.getString("CarMaker.1168"), 1, 12)); //$NON-NLS-1$
					rd.setColor(new Color(0, 0, 0));
					rd.drawString(
							new StringBuilder().append(Messages.getString("CarMaker.1169")).append(cntpls).append(Messages.getString("CarMaker.1170")) //$NON-NLS-1$ //$NON-NLS-2$
									.toString(),
							350 - ftm.stringWidth(new StringBuilder().append(Messages.getString("CarMaker.1171")).append(cntpls) //$NON-NLS-1$
									.append(Messages.getString("CarMaker.1172")).toString()) / 2, //$NON-NLS-1$
							45);
					stringbutton(Messages.getString("CarMaker.1173"), 350, 67, 5, false); //$NON-NLS-1$
				}
				i = 50;
				if (rotr) {
					o.xz -= 5;
					i = 15;
				}
				if (rotl) {
					o.xz += 5;
					i = 15;
				}
				if (left) {
					o.xy -= 5;
					i = 15;
				}
				if (right) {
					o.xy += 5;
					i = 15;
				}
				if (up) {
					o.zy -= 5;
					i = 15;
				}
				if (down) {
					o.zy += 5;
					i = 15;
				}
				if (plus) {
					o.y += 5;
					i = 15;
				}
				if (minus) {
					o.y -= 5;
					i = 15;
				}
				if (in) {
					o.z += 10;
					i = 15;
				}
				if (out) {
					o.z -= 10;
					i = 15;
				}
				ox = o.x;
				oy = o.y;
				oz = o.z;
				oxz = o.xz;
				oxy = o.xy;
				ozy = o.zy;
				if (dtabed != dtab)
					dtabed = dtab;
				if (dtab == 5 && pfase == -1) {
					repaint();
					JOptionPane.showMessageDialog(null,
							Messages.getString("CarMaker.1174"), //$NON-NLS-1$
							Messages.getString("CarMaker.1175"), 1); //$NON-NLS-1$
					dtab = 3;
				}
			}
			if (tab == 3) {
				rd.setFont(new Font(Messages.getString("CarMaker.1176"), 1, 13)); //$NON-NLS-1$
				rd.setColor(new Color(0, 0, 0));
				rd.drawString(new StringBuilder().append(Messages.getString("CarMaker.1177")).append(carname).append(Messages.getString("CarMaker.1178")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
						30, 50);
				rd.drawString(Messages.getString("CarMaker.1179"), 30, 80); //$NON-NLS-1$
				pubtyp.move(150, 63);
				if (!pubtyp.isShowing()) {
					pubtyp.setVisible(true);
					pubtyp.select(1);
				}
				stringbutton(Messages.getString("CarMaker.1180"), 102, 110, 0, true); //$NON-NLS-1$
				rd.setColor(new Color(0, 0, 0));
				rd.setFont(new Font(Messages.getString("CarMaker.1181"), 0, 12)); //$NON-NLS-1$
				if (pubtyp.getSelectedIndex() == 0) {
					rd.drawString(Messages.getString("CarMaker.1182"), 268, 72); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.1183"), 268, 88); //$NON-NLS-1$
				}
				if (pubtyp.getSelectedIndex() == 1) {
					rd.drawString(Messages.getString("CarMaker.1184"), 268, //$NON-NLS-1$
							72);
					rd.drawString(
							Messages.getString("CarMaker.1185"), 268, //$NON-NLS-1$
							88);
				}
				if (pubtyp.getSelectedIndex() == 2) {
					rd.drawString(Messages.getString("CarMaker.1186"), 268, //$NON-NLS-1$
							72);
					rd.drawString(Messages.getString("CarMaker.1187"), 268, //$NON-NLS-1$
							88);
				}
				rd.setFont(new Font(Messages.getString("CarMaker.1188"), 1, 12)); //$NON-NLS-1$
				ftm = rd.getFontMetrics();
				rd.drawString(Messages.getString("CarMaker.1189"), 80 - ftm.stringWidth(Messages.getString("CarMaker.1190")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("CarMaker.1191"), 200 - ftm.stringWidth(Messages.getString("CarMaker.1192")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("CarMaker.1193"), 300 - ftm.stringWidth(Messages.getString("CarMaker.1194")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("CarMaker.1195"), 400 - ftm.stringWidth(Messages.getString("CarMaker.1196")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("CarMaker.1197"), 500 - ftm.stringWidth(Messages.getString("CarMaker.1198")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawString(Messages.getString("CarMaker.1199"), 620 - ftm.stringWidth(Messages.getString("CarMaker.1200")) / 2, 138); //$NON-NLS-1$ //$NON-NLS-2$
				rd.drawLine(150, 129, 150, 140);
				rd.drawLine(250, 129, 250, 140);
				rd.drawLine(350, 129, 350, 140);
				rd.drawLine(450, 129, 450, 140);
				rd.drawLine(550, 129, 550, 140);
				rd.drawRect(10, 140, 680, 402);
				if (logged == 0) {
					rd.setFont(new Font(Messages.getString("CarMaker.1201"), 0, 12)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("CarMaker.1202"), 350 //$NON-NLS-1$
							- ftm.stringWidth(Messages.getString("CarMaker.1203")) //$NON-NLS-1$
									/ 2,
							180);
					rd.setFont(new Font(Messages.getString("CarMaker.1204"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("CarMaker.1205"), //$NON-NLS-1$
							350 - ftm.stringWidth(Messages.getString("CarMaker.1206")) / 2, 220); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.1207"), 326 - ftm.stringWidth(Messages.getString("CarMaker.1208")) - 14, 266); //$NON-NLS-1$ //$NON-NLS-2$
					movefield(tnick, 326, 250, 129, 22);
					if (!tnick.isShowing())
						tnick.setVisible(true);
					rd.drawString(Messages.getString("CarMaker.1209"), 326 - ftm.stringWidth(Messages.getString("CarMaker.1210")) - 14, 296); //$NON-NLS-1$ //$NON-NLS-2$
					movefield(tpass, 326, 280, 129, 22);
					if (!tpass.isShowing())
						tpass.setVisible(true);
					stringbutton(Messages.getString("CarMaker.1211"), 350, 340, 0, true); //$NON-NLS-1$
					rd.setFont(new Font(Messages.getString("CarMaker.1212"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("CarMaker.1213"), 350 - ftm.stringWidth(Messages.getString("CarMaker.1214")) / 2, 450); //$NON-NLS-1$ //$NON-NLS-2$
					stringbutton(Messages.getString("CarMaker.1215"), 350, 480, 0, true); //$NON-NLS-1$
					rd.setFont(new Font(Messages.getString("CarMaker.1216"), 0, 12)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("CarMaker.1217"), //$NON-NLS-1$
							350 - ftm.stringWidth(Messages.getString("CarMaker.1218")) / 2, 505); //$NON-NLS-1$
				}
				if (logged == -1) {
					rd.setFont(new Font(Messages.getString("CarMaker.1219"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("CarMaker.1220"), //$NON-NLS-1$
							350 - ftm.stringWidth(Messages.getString("CarMaker.1221")) / 2, 220); //$NON-NLS-1$
					rd.drawString(Messages.getString("CarMaker.1222"), //$NON-NLS-1$
							350 - ftm.stringWidth(Messages.getString("CarMaker.1223")) / 2, 280); //$NON-NLS-1$
					rd.setFont(new Font(Messages.getString("CarMaker.1224"), 0, 12)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("CarMaker.1225"), 350 //$NON-NLS-1$
							- ftm.stringWidth(Messages.getString("CarMaker.1226")) //$NON-NLS-1$
									/ 2,
							320);
				}
				if (logged == 2) {
					for (int i_143_ = 0; i_143_ < nmc; i_143_++) {
						rd.setFont(new Font(Messages.getString("CarMaker.1227"), 1, 13)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.setColor(new Color(225, 225, 225));
						rd.fillRect(50, 150, 600, 150);
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(
								new StringBuilder().append(Messages.getString("CarMaker.1228")).append(mycars[i_143_]).append(Messages.getString("CarMaker.1229")) //$NON-NLS-1$ //$NON-NLS-2$
										.toString(),
								350 - ftm.stringWidth(new StringBuilder().append(Messages.getString("CarMaker.1230")).append(mycars[i_143_]) //$NON-NLS-1$
										.append(Messages.getString("CarMaker.1231")).toString()) / 2, //$NON-NLS-1$
								220);
						repaint();
						maker[i_143_] = Messages.getString("CarMaker.1232"); //$NON-NLS-1$
						pubt[i_143_] = -1;
						clas[i_143_] = 0;
						nad[i_143_] = 0;
						String string = Messages.getString("CarMaker.1233"); //$NON-NLS-1$
						try {
							String string_144_ = new StringBuilder()
									.append(Messages.getString("CarMaker.1234")).append(mycars[i_143_]) //$NON-NLS-1$
									.append(Messages.getString("CarMaker.1235")).append((int) (Math.random() * 1000.0)).append(Messages.getString("CarMaker.1236")).toString(); //$NON-NLS-1$ //$NON-NLS-2$
							string_144_ = string_144_.replace(' ', '_');
							final URL url = new URL(string_144_);
							final DataInputStream datainputstream = new DataInputStream(url.openStream());
							while ((string = datainputstream.readLine()) != null) {
								string = new StringBuilder().append(Messages.getString("CarMaker.1237")).append(string.trim()).toString(); //$NON-NLS-1$
								if (string.startsWith(Messages.getString("CarMaker.1238"))) { //$NON-NLS-1$
									maker[i_143_] = getSvalue(Messages.getString("CarMaker.1239"), string, 0); //$NON-NLS-1$
									pubt[i_143_] = getvalue(Messages.getString("CarMaker.1240"), string, 1); //$NON-NLS-1$
									clas[i_143_] = getvalue(Messages.getString("CarMaker.1241"), string, 2); //$NON-NLS-1$
									boolean bool_145_ = false;
									while (!bool_145_) {
										addeda[i_143_][nad[i_143_]] = getSvalue(Messages.getString("CarMaker.1242"), string, 3 + nad[i_143_]); //$NON-NLS-1$
										if (addeda[i_143_][nad[i_143_]].equals(Messages.getString("CarMaker.1243"))) //$NON-NLS-1$
											bool_145_ = true;
										else
											nad[i_143_]++;
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
				if (logged == 1) {
					rd.setFont(new Font(Messages.getString("CarMaker.1244"), 1, 13)); //$NON-NLS-1$
					ftm = rd.getFontMetrics();
					rd.drawString(Messages.getString("CarMaker.1245"), //$NON-NLS-1$
							350 - ftm.stringWidth(Messages.getString("CarMaker.1246")) / 2, 220); //$NON-NLS-1$
					repaint();
					nmc = 0;
					String string = Messages.getString("CarMaker.1247"); //$NON-NLS-1$
					try {
						final URL url = new URL(new StringBuilder()
								.append(Messages.getString("CarMaker.1248")).append(tnick.getText()) //$NON-NLS-1$
								.append(Messages.getString("CarMaker.1249")).append((int) (Math.random() * 1000.0)).append(Messages.getString("CarMaker.1250")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						final DataInputStream datainputstream = new DataInputStream(url.openStream());
						while ((string = datainputstream.readLine()) != null) {
							string = new StringBuilder().append(Messages.getString("CarMaker.1251")).append(string.trim()).toString(); //$NON-NLS-1$
							if (string.startsWith(Messages.getString("CarMaker.1252"))) { //$NON-NLS-1$
								boolean bool_146_ = true;
								while (bool_146_ && nmc < 20) {
									mycars[nmc] = getSvalue(Messages.getString("CarMaker.1253"), string, nmc); //$NON-NLS-1$
									if (mycars[nmc].equals(Messages.getString("CarMaker.1254"))) //$NON-NLS-1$
										bool_146_ = false;
									else
										nmc++;
								}
							}
						}
						if (nmc > 0)
							logged = 2;
						else {
							setCursor(new Cursor(0));
							logged = -1;
						}
						datainputstream.close();
					} catch (final Exception exception) {
						final String string_147_ = new StringBuilder().append(Messages.getString("CarMaker.1255")).append(exception).toString(); //$NON-NLS-1$
						if (string_147_.indexOf(Messages.getString("CarMaker.1256")) != -1) { //$NON-NLS-1$
							setCursor(new Cursor(0));
							logged = -1;
						} else {
							logged = 0;
							JOptionPane.showMessageDialog(null,
									Messages.getString("CarMaker.1257"), Messages.getString("CarMaker.1258"), //$NON-NLS-1$ //$NON-NLS-2$
									1);
						}
					}
				}
				if (logged == 3)
					for (int i_148_ = 0; i_148_ < nmc; i_148_++) {
						rd.setColor(new Color(235, 235, 235));
						if (xm > 11 && xm < 689 && ym > 142 + i_148_ * 20 && ym < 160 + i_148_ * 20)
							rd.setColor(new Color(255, 255, 255));
						rd.fillRect(11, 142 + i_148_ * 20, 678, 18);
						rd.setFont(new Font(Messages.getString("CarMaker.1259"), 0, 12)); //$NON-NLS-1$
						ftm = rd.getFontMetrics();
						rd.setColor(new Color(0, 0, 0));
						rd.drawString(mycars[i_148_], 80 - ftm.stringWidth(mycars[i_148_]) / 2, 156 + i_148_ * 20);
						rd.setColor(new Color(155, 155, 155));
						rd.drawLine(150, 145 + i_148_ * 20, 150, 157 + i_148_ * 20);
						if (pubt[i_148_] != -1) {
							rd.drawLine(250, 145 + i_148_ * 20, 250, 157 + i_148_ * 20);
							rd.drawLine(350, 145 + i_148_ * 20, 350, 157 + i_148_ * 20);
							rd.drawLine(450, 145 + i_148_ * 20, 450, 157 + i_148_ * 20);
							rd.drawLine(550, 145 + i_148_ * 20, 550, 157 + i_148_ * 20);
							rd.setColor(new Color(0, 0, 64));
							String string = Messages.getString("CarMaker.1260"); //$NON-NLS-1$
							if (clas[i_148_] == 1)
								string = Messages.getString("CarMaker.1261"); //$NON-NLS-1$
							if (clas[i_148_] == 2)
								string = Messages.getString("CarMaker.1262"); //$NON-NLS-1$
							if (clas[i_148_] == 3)
								string = Messages.getString("CarMaker.1263"); //$NON-NLS-1$
							if (clas[i_148_] == 4)
								string = Messages.getString("CarMaker.1264"); //$NON-NLS-1$
							rd.drawString(new StringBuilder().append(Messages.getString("CarMaker.1265")).append(string).append(Messages.getString("CarMaker.1266")).toString(), //$NON-NLS-1$ //$NON-NLS-2$
									200 - ftm.stringWidth(
											new StringBuilder().append(Messages.getString("CarMaker.1267")).append(string).append(Messages.getString("CarMaker.1268")).toString()) //$NON-NLS-1$ //$NON-NLS-2$
											/ 2,
									156 + i_148_ * 20);
							boolean bool_149_ = false;
							if (maker[i_148_].toLowerCase().equals(tnick.getText().toLowerCase())) {
								bool_149_ = true;
								rd.setColor(new Color(0, 64, 0));
								rd.drawString(Messages.getString("CarMaker.1269"), 300 - ftm.stringWidth(Messages.getString("CarMaker.1270")) / 2, 156 + i_148_ * 20); //$NON-NLS-1$ //$NON-NLS-2$
							} else
								rd.drawString(maker[i_148_], 300 - ftm.stringWidth(maker[i_148_]) / 2,
										156 + i_148_ * 20);
							if (nad[i_148_] > 1) {
								if (ovbutton(new StringBuilder().append(Messages.getString("CarMaker.1271")).append(nad[i_148_]).append(Messages.getString("CarMaker.1272")) //$NON-NLS-1$ //$NON-NLS-2$
										.toString(), 400, 156 + i_148_ * 20)) {
									String string_150_ = new StringBuilder().append(Messages.getString("CarMaker.1273")).append(mycars[i_148_]) //$NON-NLS-1$
											.append(Messages.getString("CarMaker.1274")) //$NON-NLS-1$
											.toString();
									int i_151_ = 0;
									for (int i_152_ = 0; i_152_ < nad[i_148_]; i_152_++) {
										if (++i_151_ == 17) {
											string_150_ = new StringBuilder().append(string_150_).append(Messages.getString("CarMaker.1275")) //$NON-NLS-1$
													.toString();
											i_151_ = 1;
										}
										string_150_ = new StringBuilder().append(string_150_)
												.append(addeda[i_148_][i_152_]).toString();
										if (i_152_ != nad[i_148_] - 1)
											if (i_152_ != nad[i_148_] - 2)
												string_150_ = new StringBuilder().append(string_150_).append(Messages.getString("CarMaker.1276")) //$NON-NLS-1$
														.toString();
											else if (i_151_ == 16) {
												string_150_ = new StringBuilder().append(string_150_).append(Messages.getString("CarMaker.1277")) //$NON-NLS-1$
														.toString();
												i_151_ = 0;
											} else
												string_150_ = new StringBuilder().append(string_150_).append(Messages.getString("CarMaker.1278")) //$NON-NLS-1$
														.toString();
									}
									string_150_ = new StringBuilder().append(string_150_).append(Messages.getString("CarMaker.1279")).toString(); //$NON-NLS-1$
									JOptionPane.showMessageDialog(null, string_150_, Messages.getString("CarMaker.1280"), 1); //$NON-NLS-1$
								}
							} else {
								rd.setColor(new Color(0, 0, 64));
								rd.drawString(Messages.getString("CarMaker.1281"), 400 - ftm.stringWidth(Messages.getString("CarMaker.1282")) / 2, 156 + i_148_ * 20); //$NON-NLS-1$ //$NON-NLS-2$
							}
							if (pubt[i_148_] == 0) {
								rd.setColor(new Color(0, 0, 64));
								rd.drawString(Messages.getString("CarMaker.1283"), 500 - ftm.stringWidth(Messages.getString("CarMaker.1284")) / 2, 156 + i_148_ * 20); //$NON-NLS-1$ //$NON-NLS-2$
							}
							if (pubt[i_148_] == 1) {
								rd.setColor(new Color(0, 0, 64));
								rd.drawString(Messages.getString("CarMaker.1285"), 500 - ftm.stringWidth(Messages.getString("CarMaker.1286")) / 2, 156 + i_148_ * 20); //$NON-NLS-1$ //$NON-NLS-2$
							}
							if (pubt[i_148_] == 2) {
								rd.setColor(new Color(0, 64, 0));
								rd.drawString(Messages.getString("CarMaker.1287"), 500 - ftm.stringWidth(Messages.getString("CarMaker.1288")) / 2, //$NON-NLS-1$ //$NON-NLS-2$
										156 + i_148_ * 20);
							}
							if ((pubt[i_148_] == 2 || bool_149_) && ovbutton(Messages.getString("CarMaker.1289"), 600, 156 + i_148_ * 20)) { //$NON-NLS-1$
								int i_153_ = 0;
								for (int i_154_ = 0; i_154_ < slcar.getItemCount(); i_154_++)
									if (mycars[i_148_].equals(slcar.getItem(i_154_)))
										i_153_ = JOptionPane.showConfirmDialog(null,
												new StringBuilder().append(Messages.getString("CarMaker.1290")).append(mycars[i_148_]) //$NON-NLS-1$
														.append(Messages.getString("CarMaker.1291")) //$NON-NLS-1$
														.toString(),
												Messages.getString("CarMaker.1292"), 0); //$NON-NLS-1$
								if (i_153_ == 0) {
									setCursor(new Cursor(3));
									rd.setFont(new Font(Messages.getString("CarMaker.1293"), 1, 13)); //$NON-NLS-1$
									ftm = rd.getFontMetrics();
									rd.setColor(new Color(225, 225, 225));
									rd.fillRect(11, 141, 679, 401);
									rd.setColor(new Color(0, 0, 0));
									rd.drawString(Messages.getString("CarMaker.1294"), //$NON-NLS-1$
											350 - ftm.stringWidth(Messages.getString("CarMaker.1295")) / 2, 250); //$NON-NLS-1$
									repaint();
									try {
										String string_155_ = new StringBuilder()
												.append(Messages.getString("CarMaker.1296")) //$NON-NLS-1$
												.append(mycars[i_148_]).append(Messages.getString("CarMaker.1297")) //$NON-NLS-1$
												.append((int) (Math.random() * 1000.0)).append(Messages.getString("CarMaker.1298")).toString(); //$NON-NLS-1$
										string_155_ = string_155_.replace(' ', '_');
										final URL url = new URL(string_155_);
										final int i_156_ = url.openConnection().getContentLength();
										final DataInputStream datainputstream = new DataInputStream(url.openStream());
										final byte[] is = new byte[i_156_];
										datainputstream.readFully(is);
										ZipInputStream zipinputstream;
										if (is[0] == 80 && is[1] == 75 && is[2] == 3)
											zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
										else {
											final byte[] is_157_ = new byte[i_156_ - 40];
											for (int i_158_ = 0; i_158_ < i_156_ - 40; i_158_++) {
												int i_159_ = 20;
												if (i_158_ >= 500)
													i_159_ = 40;
												is_157_[i_158_] = is[i_158_ + i_159_];
											}
											zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_157_));
										}
										final ZipEntry zipentry = zipinputstream.getNextEntry();
										if (zipentry != null) {
											int i_160_ = Integer.valueOf(zipentry.getName()).intValue();
											final byte[] is_161_ = new byte[i_160_];
											int i_162_ = 0;
											int i_163_;
											for (/**/; i_160_ > 0; i_160_ -= i_163_) {
												i_163_ = zipinputstream.read(is_161_, i_162_, i_160_);
												i_162_ += i_163_;
											}
											String string_164_ = new String(is_161_);
											string_164_ = new StringBuilder().append(string_164_).append(Messages.getString("CarMaker.1299")) //$NON-NLS-1$
													.toString();
											String string_165_ = Messages.getString("CarMaker.1300"); //$NON-NLS-1$
											int i_166_ = 0;
											int i_167_ = string_164_.indexOf(Messages.getString("CarMaker.1301"), 0); //$NON-NLS-1$
											while (i_167_ != -1 && i_166_ < string_164_.length()) {
												String string_168_ = string_164_.substring(i_166_, i_167_);
												string_168_ = string_168_.trim();
												i_166_ = i_167_ + 1;
												i_167_ = string_164_.indexOf(Messages.getString("CarMaker.1302"), i_166_); //$NON-NLS-1$
												if (!string_168_.startsWith(Messages.getString("CarMaker.1303")) //$NON-NLS-1$
														&& !string_168_.startsWith(Messages.getString("CarMaker.1304"))) //$NON-NLS-1$
													string_165_ = new StringBuilder().append(string_165_).append(Messages.getString("CarMaker.1305")) //$NON-NLS-1$
															.append(string_168_).append(Messages.getString("CarMaker.1306")).toString(); //$NON-NLS-1$
												else {
													string_165_ = string_165_.trim();
													string_165_ = new StringBuilder().append(string_165_).append(Messages.getString("CarMaker.1307")) //$NON-NLS-1$
															.toString();
												}
											}
											string_165_ = string_165_.trim();
											string_165_ = new StringBuilder().append(string_165_).append(Messages.getString("CarMaker.1308")) //$NON-NLS-1$
													.toString();
											File file = new File(Messages.getString("CarMaker.1309")); //$NON-NLS-1$
											if (!file.exists())
												file.mkdirs();
											file = new File(new StringBuilder().append(Messages.getString("CarMaker.1310")).append(mycars[i_148_]) //$NON-NLS-1$
													.append(Messages.getString("CarMaker.1311")).toString()); //$NON-NLS-1$
											final BufferedWriter bufferedwriter = new BufferedWriter(
													new FileWriter(file));
											bufferedwriter.write(string_165_);
											bufferedwriter.close();
											zipinputstream.close();
											if (carname.equals(mycars[i_148_])) {
												editor.setText(string_165_);
												lastedo = string_165_;
											}
											setCursor(new Cursor(0));
											JOptionPane.showMessageDialog(null,
													new StringBuilder().append(Messages.getString("CarMaker.1312")).append(mycars[i_148_]) //$NON-NLS-1$
															.append(Messages.getString("CarMaker.1313")).toString(), //$NON-NLS-1$
													Messages.getString("CarMaker.1314"), 1); //$NON-NLS-1$
										} else
											JOptionPane.showMessageDialog(null,
													Messages.getString("CarMaker.1315"), //$NON-NLS-1$
													Messages.getString("CarMaker.1316"), 1); //$NON-NLS-1$
									} catch (final Exception exception) {
										JOptionPane.showMessageDialog(null,
												Messages.getString("CarMaker.1317"), //$NON-NLS-1$
												Messages.getString("CarMaker.1318"), 1); //$NON-NLS-1$
									}
								}
							}
						} else
							rd.drawString(Messages.getString("CarMaker.1319"), //$NON-NLS-1$
									350 - ftm.stringWidth(Messages.getString("CarMaker.1320")) / 2, //$NON-NLS-1$
									156 + i_148_ * 20);
						if (ovbutton(Messages.getString("CarMaker.1321"), 665, 156 + i_148_ * 20) //$NON-NLS-1$
								&& JOptionPane
										.showConfirmDialog(null,
												new StringBuilder().append(Messages.getString("CarMaker.1322")).append(mycars[i_148_]) //$NON-NLS-1$
														.append(Messages.getString("CarMaker.1323")).toString(), //$NON-NLS-1$
												Messages.getString("CarMaker.1324"), 0) == 0) { //$NON-NLS-1$
							setCursor(new Cursor(3));
							int i_169_ = -1;
							try {
								final Socket socket = new Socket(Messages.getString("CarMaker.1325"), 7061); //$NON-NLS-1$
								final BufferedReader bufferedreader = new BufferedReader(
										new InputStreamReader(socket.getInputStream()));
								final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
								printwriter.println(new StringBuilder().append(Messages.getString("CarMaker.1326")).append(tnick.getText()).append(Messages.getString("CarMaker.1327")) //$NON-NLS-1$ //$NON-NLS-2$
										.append(tpass.getText()).append(Messages.getString("CarMaker.1328")).append(mycars[i_148_]).append(Messages.getString("CarMaker.1329")) //$NON-NLS-1$ //$NON-NLS-2$
										.toString());
								final String string = bufferedreader.readLine();
								if (string != null)
									i_169_ = servervalue(string, 0);
								socket.close();
							} catch (final Exception exception) {
								i_169_ = -1;
							}
							if (i_169_ == 0)
								logged = 1;
							else {
								setCursor(new Cursor(0));
								JOptionPane.showMessageDialog(null,
										new StringBuilder().append(Messages.getString("CarMaker.1330")).append(mycars[i_148_]) //$NON-NLS-1$
												.append(Messages.getString("CarMaker.1331")) //$NON-NLS-1$
												.toString(),
										Messages.getString("CarMaker.1332"), 1); //$NON-NLS-1$
							}
						}
					}
			}
			if (tabed != tab)
				tabed = tab;
			rd.setColor(new Color(0, 0, 0));
			rd.fillRect(0, 0, 700, 25);
			if (!onbtgame)
				rd.drawImage(btgame[0], 520, 0, null);
			else
				rd.drawImage(btgame[1], 520, 0, null);
			rd.setFont(new Font(Messages.getString("CarMaker.1333"), 1, 13)); //$NON-NLS-1$
			ftm = rd.getFontMetrics();
			final String[] strings = { Messages.getString("CarMaker.1334"), Messages.getString("CarMaker.1335"), Messages.getString("CarMaker.1336"), Messages.getString("CarMaker.1337") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			final int[] is = { 0, 0, 100, 90 };
			final int[] is_170_ = { 0, 25, 25, 0 };
			int i_171_ = 4;
			if (carname.equals(Messages.getString("CarMaker.1338")) || !loadedfile || sfase != 0) { //$NON-NLS-1$
				tab = 0;
				i_171_ = 1;
			}
			for (int i_172_ = 0; i_172_ < i_171_; i_172_++) {
				rd.setColor(new Color(170, 170, 170));
				if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25)
					rd.setColor(new Color(200, 200, 200));
				if (tab == i_172_)
					rd.setColor(new Color(225, 225, 225));
				rd.fillPolygon(is, is_170_, 4);
				rd.setColor(new Color(0, 0, 0));
				rd.drawString(strings[i_172_], i_172_ * 100 + 45 - ftm.stringWidth(strings[i_172_]) / 2, 17);
				if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25 && mouses == -1) {
					if (tab != i_172_ && tab == 1)
						savefile();
					tab = i_172_;
				}
				for (int i_173_ = 0; i_173_ < 4; i_173_++)
					is[i_173_] += 100;
			}
			drawms();
			ctachm();
			repaint();
			if (!exwist)
				try {
					if (thredo != null) {
						/* empty */
					}
					Thread.sleep(i);
				} catch (final InterruptedException interruptedexception) {
					/* empty */
				}
		}
		rd.dispose();
		System.gc();
	}

	public void savefile() {
		if (!editor.getText().equals(Messages.getString("CarMaker.1339"))) //$NON-NLS-1$
			try {
				File file = new File(Messages.getString("CarMaker.1340")); //$NON-NLS-1$
				if (!file.exists())
					file.mkdirs();
				file = new File(new StringBuilder().append(Messages.getString("CarMaker.1341")).append(carname).append(Messages.getString("CarMaker.1342")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
				final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
				bufferedwriter.write(editor.getText());
				bufferedwriter.close();
				changed = false;
				lastedo = editor.getText();
			} catch (final Exception exception) {
				JOptionPane.showMessageDialog(null, new StringBuilder().append(Messages.getString("CarMaker.1343")) //$NON-NLS-1$
						.append(exception).toString(), Messages.getString("CarMaker.1344"), 1); //$NON-NLS-1$
			}
		savesettings();
	}

	public void savesettings() {
		if (!scar.equals(carname) || !suser.equals(tnick.getText()) || !sfont.equals(cfont) || cthm != sthm) {
			final String string = new StringBuilder().append(Messages.getString("CarMaker.1345")).append(carname).append(Messages.getString("CarMaker.1346")).append(tnick.getText()) //$NON-NLS-1$ //$NON-NLS-2$
					.append(Messages.getString("CarMaker.1347")).append(cfont).append(Messages.getString("CarMaker.1348")).append(cthm).append(Messages.getString("CarMaker.1349")).toString(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			scar = carname;
			suser = tnick.getText();
			sfont = cfont;
			sthm = cthm;
			try {
				File file = new File(Messages.getString("CarMaker.1350")); //$NON-NLS-1$
				if (!file.exists())
					file.mkdirs();
				file = new File(Messages.getString("CarMaker.1351")); //$NON-NLS-1$
				final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
				bufferedwriter.write(string);
				bufferedwriter.close();
			} catch (final Exception exception) {
				/* empty */
			}
		}
	}

	public String serverSvalue(final String string, final int i) {
		String string_380_ = Messages.getString("CarMaker.1352"); //$NON-NLS-1$
		try {
			int i_381_ = 0;
			int i_382_ = 0;
			int i_383_ = 0;
			String string_384_ = Messages.getString("CarMaker.1353"); //$NON-NLS-1$
			String string_385_ = Messages.getString("CarMaker.1354"); //$NON-NLS-1$
			for (/**/; i_381_ < string.length() && i_383_ != 2; i_381_++) {
				string_384_ = new StringBuilder().append(Messages.getString("CarMaker.1355")).append(string.charAt(i_381_)).toString(); //$NON-NLS-1$
				if (string_384_.equals(Messages.getString("CarMaker.1356"))) { //$NON-NLS-1$
					i_382_++;
					if (i_383_ == 1 || i_382_ > i)
						i_383_ = 2;
				} else if (i_382_ == i) {
					string_385_ = new StringBuilder().append(string_385_).append(string_384_).toString();
					i_383_ = 1;
				}
			}
			string_380_ = string_385_;
		} catch (final Exception exception) {
			/* empty */
		}
		return string_380_;
	}

	public int servervalue(final String string, final int i) {
		int i_374_ = -1;
		try {
			int i_375_ = 0;
			int i_376_ = 0;
			int i_377_ = 0;
			String string_378_ = Messages.getString("CarMaker.1357"); //$NON-NLS-1$
			String string_379_ = Messages.getString("CarMaker.1358"); //$NON-NLS-1$
			for (/**/; i_375_ < string.length() && i_377_ != 2; i_375_++) {
				string_378_ = new StringBuilder().append(Messages.getString("CarMaker.1359")).append(string.charAt(i_375_)).toString(); //$NON-NLS-1$
				if (string_378_.equals(Messages.getString("CarMaker.1360"))) { //$NON-NLS-1$
					i_376_++;
					if (i_377_ == 1 || i_376_ > i)
						i_377_ = 2;
				} else if (i_376_ == i) {
					string_379_ = new StringBuilder().append(string_379_).append(string_378_).toString();
					i_377_ = 1;
				}
			}
			if (string_379_.equals(Messages.getString("CarMaker.1361"))) //$NON-NLS-1$
				string_379_ = Messages.getString("CarMaker.1362"); //$NON-NLS-1$
			i_374_ = Integer.valueOf(string_379_).intValue();
		} catch (final Exception exception) {
			/* empty */
		}
		return i_374_;
	}

	public void setheme() {
		if (cthm == 0) {
			editor.setForeground(deff);
			editor.setBackground(defb);
		}
		if (cthm == 1) {
			editor.setForeground(new Color(0, 0, 0));
			editor.setBackground(new Color(192, 192, 192));
		}
		if (cthm == 2) {
			editor.setForeground(new Color(192, 192, 192));
			editor.setBackground(new Color(0, 0, 0));
		}
		if (cthm == 3) {
			editor.setForeground(new Color(0, 0, 0));
			editor.setBackground(new Color(50, 200, 0));
		}
		if (cthm == 4) {
			editor.setForeground(new Color(67, 255, 77));
			editor.setBackground(new Color(0, 0, 0));
		}
		if (cthm == 5) {
			editor.setForeground(new Color(0, 172, 255));
			editor.setBackground(new Color(210, 234, 255));
		}
		if (cthm == 6) {
			editor.setForeground(new Color(255, 230, 0));
			editor.setBackground(new Color(255, 77, 67));
		}
		if (cthm == 7) {
			editor.setForeground(new Color(0, 159, 255));
			editor.setBackground(new Color(9, 47, 104));
		}
	}

	public void setupo() {
		o = new ContO(editor.getText().getBytes(), m, t);
		o.x = ox;
		o.y = oy;
		o.z = oz;
		o.xz = oxz;
		o.xy = oxy;
		o.zy = ozy;
		o.shadow = true;
		o.tnt = 0;
		o.disp = 0;
		o.disline = 7;
		o.grounded = 1.0F;
		o.noline = false;
		o.decor = false;
		if (o.errd && (!o.err.startsWith(Messages.getString("CarMaker.1363")) || forwheels)) //$NON-NLS-1$
			JOptionPane.showMessageDialog(null, o.err, Messages.getString("CarMaker.1364"), 0); //$NON-NLS-1$
		if (o.maxR == 0)
			o.maxR = 100;
		squash = 0;
		hitmag = 0;
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

	public void stringbutton(final String string, final int i, final int i_393_, final int i_394_, final boolean bool) {
		rd.setFont(new Font(Messages.getString("CarMaker.1365"), 1, 12)); //$NON-NLS-1$
		ftm = rd.getFontMetrics();
		if (string.indexOf(Messages.getString("CarMaker.1366")) != -1) { //$NON-NLS-1$
			rd.setFont(new Font(Messages.getString("CarMaker.1367"), 1, 13)); //$NON-NLS-1$
			ftm = rd.getFontMetrics();
		}
		bx[btn] = i;
		by[btn] = i_393_ - 5;
		bw[btn] = ftm.stringWidth(string);
		if (!pessd[btn]) {
			rd.setColor(new Color(220, 220, 220));
			if (bool)
				rd.setColor(new Color(230, 230, 230));
			rd.fillRect(i - bw[btn] / 2 - 10, i_393_ - (17 - i_394_), bw[btn] + 20, 25 - i_394_ * 2);
			rd.setColor(new Color(240, 240, 240));
			if (bool)
				rd.setColor(new Color(255, 255, 255));
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 10, i_393_ - (17 - i_394_));
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ - (18 - i_394_), i + bw[btn] / 2 + 10, i_393_ - (18 - i_394_));
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - bw[btn] / 2 - 9, i_393_ - (19 - i_394_), i + bw[btn] / 2 + 9, i_393_ - (19 - i_394_));
			rd.setColor(new Color(200, 200, 200));
			if (bool)
				rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i + bw[btn] / 2 + 10, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 10, i_393_ + 7 - i_394_);
			rd.drawLine(i + bw[btn] / 2 + 11, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 11, i_393_ + 7 - i_394_);
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i + bw[btn] / 2 + 12, i_393_ - (16 - i_394_), i + bw[btn] / 2 + 12, i_393_ + 6 - i_394_);
			if (bool)
				rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ + 7 - i_394_, i + bw[btn] / 2 + 10, i_393_ + 7 - i_394_);
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ + 8 - i_394_, i + bw[btn] / 2 + 10, i_393_ + 8 - i_394_);
			rd.setColor(new Color(200, 200, 200));
			rd.drawLine(i - bw[btn] / 2 - 9, i_393_ + 9 - i_394_, i + bw[btn] / 2 + 9, i_393_ + 9 - i_394_);
			rd.setColor(new Color(240, 240, 240));
			if (bool)
				rd.setColor(new Color(255, 255, 255));
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ - (17 - i_394_), i - bw[btn] / 2 - 10, i_393_ + 7 - i_394_);
			rd.drawLine(i - bw[btn] / 2 - 11, i_393_ - (17 - i_394_), i - bw[btn] / 2 - 11, i_393_ + 7 - i_394_);
			rd.setColor(new Color(240, 240, 240));
			rd.drawLine(i - bw[btn] / 2 - 12, i_393_ - (16 - i_394_), i - bw[btn] / 2 - 12, i_393_ + 6 - i_394_);
			rd.setColor(new Color(0, 0, 0));
			rd.drawString(string, i - bw[btn] / 2, i_393_);
		} else {
			rd.setColor(new Color(220, 220, 220));
			rd.fillRect(i - bw[btn] / 2 - 10, i_393_ - (17 - i_394_), bw[btn] + 20, 25 - i_394_ * 2);
			rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 10, i_393_ - (17 - i_394_));
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ - (18 - i_394_), i + bw[btn] / 2 + 10, i_393_ - (18 - i_394_));
			rd.drawLine(i - bw[btn] / 2 - 9, i_393_ - (19 - i_394_), i + bw[btn] / 2 + 9, i_393_ - (19 - i_394_));
			rd.setColor(new Color(247, 247, 247));
			rd.drawLine(i + bw[btn] / 2 + 10, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 10, i_393_ + 7 - i_394_);
			rd.drawLine(i + bw[btn] / 2 + 11, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 11, i_393_ + 7 - i_394_);
			rd.drawLine(i + bw[btn] / 2 + 12, i_393_ - (16 - i_394_), i + bw[btn] / 2 + 12, i_393_ + 6 - i_394_);
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ + 7 - i_394_, i + bw[btn] / 2 + 10, i_393_ + 7 - i_394_);
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ + 8 - i_394_, i + bw[btn] / 2 + 10, i_393_ + 8 - i_394_);
			rd.drawLine(i - bw[btn] / 2 - 9, i_393_ + 9 - i_394_, i + bw[btn] / 2 + 9, i_393_ + 9 - i_394_);
			rd.setColor(new Color(192, 192, 192));
			rd.drawLine(i - bw[btn] / 2 - 10, i_393_ - (17 - i_394_), i - bw[btn] / 2 - 10, i_393_ + 7 - i_394_);
			rd.drawLine(i - bw[btn] / 2 - 11, i_393_ - (17 - i_394_), i - bw[btn] / 2 - 11, i_393_ + 7 - i_394_);
			rd.drawLine(i - bw[btn] / 2 - 12, i_393_ - (16 - i_394_), i - bw[btn] / 2 - 12, i_393_ + 6 - i_394_);
			rd.setColor(new Color(0, 0, 0));
			rd.drawString(string, i - bw[btn] / 2 + 1, i_393_ + 1);
		}
		btn++;
	}

	@Override
	public void update(final Graphics graphics) {
		paint(graphics);
	}

	public int xs(final int i, int i_338_) {
		if (i_338_ < m.cz)
			i_338_ = m.cz;
		return (i_338_ - m.focus_point) * (m.cx - i) / i_338_ + i;
	}

	public int ys(final int i, int i_339_) {
		if (i_339_ < m.cz)
			i_339_ = m.cz;
		return (i_339_ - m.focus_point) * (m.cy - i) / i_339_ + i;
	}
}
