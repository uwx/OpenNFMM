import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Globe implements Runnable {
	String[] aboutxt = new String[3];
	int addopy = 0;
	int addstage = 0;
	int ados = 0;
	int ascore = 0;
	boolean attachetoclan = false;
	Image avatar;
	boolean avatarl = false;
	boolean badlang = false;
	ContO[] bco;
	float bgf = 0.0F;
	boolean bgup = false;
	int[] bgx = { 0, 670, 1340 };
	int blockb = 0;
	String blockname = "";
	int blocknote = 0;
	int cadmin = 0;
	boolean canredo = false;
	CarDefine cd;
	int cfase = 0;
	int champ = -1;
	String claname = "EvilOnes";
	Image clanbg;
	boolean clanbgl = false;
	String[] clanlo = new String[20];
	Image clanlogo;
	String[] clname = new String[20];
	long[] cmctimes = new long[1000];
	String[] cmline = new String[1000];
	int[] cmlinetyp = new int[1000];
	String[] cmtimes = new String[1000];
	String[] cnames = new String[21];
	String[] cnfname = new String[10];
	int cnml = 0;
	int cntf = 0;
	ContO[] co;
	int comesoon = 0;
	String[] conclan;
	Thread connector;
	CheckPoints cp;
	int ctab = 0;
	String[] ctime = new String[21];
	int cur = 0;
	int curs = 0;
	boolean darker = false;
	String dgcar = "";
	BufferedReader din;
	int dispi = 0;
	int doi = 0;
	boolean dommsg = false;
	boolean domon = false;
	boolean donemsg = false;
	boolean donewc = false;
	boolean dorank = false;
	boolean dosrch = false;
	PrintWriter dout;
	boolean doweb1 = false;
	boolean doweb2 = false;
	String dtcar = "";
	String dwarn = "";
	int edit = 0;
	int editc = 0;
	int em = 0;
	int eng = -1;
	int engo = 0;
	int fase = 0;
	String filename = "";
	boolean flg = false;
	int flk = 0;
	int flkn = 0;
	int flko = 0;
	String[] fname = new String[900];
	boolean forcsel = false;
	int freq = 0;
	String freqname = "";
	boolean frkl = false;
	FontMetrics ftm;
	int gameturn = -1;
	String gameturndisp = "";
	Image gImage;
	GameSparker gs;
	String hasmsgs = "";
	String[] icheck = new String[200];
	boolean ichlng = false;
	String[] iclan = new String[200];
	String[] iconvo = new String[200];
	long[] ictime = new long[200];
	long[] ictimes = new long[1000];
	int ifas = 0;
	int iflk = 0;
	String[] igcar = new String[200];
	String igive = "";
	int il = 0;
	String[] iline = new String[1000];
	int[] ilinetyp = new int[1000];
	String imsg = "";
	boolean inishsel = false;
	String intclan = "";
	Image intclanbg = null;
	boolean intclanbgloaded = false;
	String intclanlo = "";
	int intsel = 0;
	int isel = 0;
	String[] istat = new String[200];
	String[] isub = new String[200];
	int itab = 0;
	String itake = "";
	String[] itcar = new String[200];
	int itemsel = 0;
	String[] itime = new String[200];
	String[] itimes = new String[1000];
	String[] iwarn = new String[200];
	String lastint = "";
	String lastsub = "";
	String lccnam = "";
	String ldes = "";
	int leader = -1;
	int leadsby = 0;
	Login lg;
	String[][][] link = new String[300][4][2];
	int litab = -1;
	boolean loadedc = false;
	int loadedcar = 0;
	int loadedcars = -1;
	boolean loadedcm = false;
	boolean loadedlink = false;
	int loadedmyclanbg = 0;
	int loadednews = 0;
	boolean loadedp = false;
	boolean loadedpstage = false;
	int loadedstage = 0;
	int loadedstages = -1;
	int loadinter = -1;
	int loaditem = 0;
	int loadmsgs = -1;
	int loadpst = 0;
	String loadpstage = "";
	int loadwbgames = 0;
	int loadwstat = 0;
	Image[] logoi = new Image[200];
	boolean logol = false;
	boolean[] logon = new boolean[200];
	String[] logos = new String[200];
	int lspos = 0;
	int lspos2 = 0;
	int lspos3 = 0;
	int lspos4 = 0;
	int lspos5 = 0;
	int lspos6 = 0;
	int lspos6w = 0;
	String ltit = "";
	String lurl = "";
	String lwbwinner = "";
	Medium m;
	int maxclans = 1000;
	String[] mconvo = new String[200];
	long[] mctime = new long[200];
	long[] mctimes = new long[1000];
	String[] member = new String[20];
	int[] mlevel = new int[20];
	String[] mline = new String[1000];
	int[] mlinetyp = new int[1000];
	String[] mname = new String[200];
	String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
			"November", "December" };
	int mouson = -1;
	String[] mrank = new String[20];
	int mrot = 0;
	int mscro = 825;
	int mscro2 = 825;
	int mscro3 = 825;
	int mscro4 = 825;
	int mscro5 = 825;
	String msg = "";
	String[] msub = new String[200];
	MediaTracker mt;
	String[] mtime = new String[200];
	String[] mtimes = new String[1000];
	int[] mtyp = new int[200];
	Image myclanbg = null;
	int nab = 0;
	int ncc = 0;
	int ncln = 0;
	int nclns = 0;
	int ncnf = 0;
	long[] nctime = new long[21];
	String[] newplayers = { "", "", "", "", "" };
	int ni = 0;
	int nil = 0;
	String[] nlclan = new String[5];
	int nlg = 0;
	int[] nln = new int[300];
	int[] nlosp = new int[5];
	int nm = 0;
	int nmb = 0;
	int nml = 0;
	boolean notclan = false;
	int npf = -1;
	int npo = -1;
	int nrmb = 0;
	int ntab = 0;
	long ntime = 0L;
	String[] nttime = new String[300];
	int[] nvc;
	int nvgames1 = 0;
	int nvgames2 = 0;
	int[] nwarbs = { -1, -1, -1, -1, -1 };
	String[] nwclan = new String[5];
	String[] nwinob = new String[5];
	int[] nwinp = new int[5];
	String[] nwtime = new String[5];
	ImageObserver ob;
	boolean onp = false;
	int open = 0;
	int openc = 0;
	int openi = 0;
	int oph = 0;
	String opname = "";
	int opy = 0;
	int[] ord;
	int overit = 0;
	int perc = 0;
	String perry = "";
	int playt = 0;
	String[] pname = new String[900];
	int[][] points;
	String proclan = "";
	String proname = "";
	int[] proom = new int[900];
	int protab = 0;
	int[] pserver = new int[900];
	int ptab = 0;
	int racing = 50;
	Graphics2D rd;
	Graphics2D rdo;
	int readclan = 0;
	int readint = 0;
	int readmsg = 0;
	boolean redif = false;
	boolean refresh = false;
	String[] rmember = new String[100];
	int[][] roomf = new int[3][5];
	int scro = 0;
	int sdist = 0;
	String selcar = "";
	String selstage = "";
	int sendcmsg = 0;
	int sendint = 0;
	int sendmsg = 0;
	String sendwar = "";
	boolean sendwarnum = false;
	String sentance = "";
	int sentchange = 0;
	String[] sentn = new String[21];
	int sfreq = 0;
	String sfreqname = "";
	boolean showreqs = false;
	String sltit = "";
	String smsg = "";
	Socket socket;
	int spos = 0;
	int spos2 = 0;
	int spos3 = 0;
	int spos4 = 208;
	int spos5 = 0;
	int spos6 = 0;
	int tab = 3;
	String[] text = new String[300];
	String themesong = "";
	int[] totp;
	String trackname = "";
	int trackvol = 0;
	String unblockname = "";
	int underc = 0;
	int updatec = -1;
	int upload = 0;
	int uploadt = 0;
	boolean upo = false;
	String vclan = "";
	String[][] verclan;
	String viewcar = "";
	int viewgame1 = 0;
	int viewgame2 = 0;
	String viewwar1 = "";
	String viewwar2 = "";
	int vscore = 0;
	int[] vwcars1 = new int[10];
	int[] vwcars2 = new int[10];
	int[] vwclass1 = new int[10];
	int[] vwclass2 = new int[10];
	int[] vwfix1 = new int[10];
	int[] vwfix2 = new int[10];
	String[] vwinner = new String[10];
	int[] vwlaps1 = new int[10];
	int[] vwlaps2 = new int[10];
	int vwscorei = 0;
	int vwscorex = 0;
	String[] vwstages1 = new String[10];
	String[] vwstages2 = new String[10];
	int wag = 0;
	int waitlink = 0;
	int warb = 0;
	String warbnum = "";
	String warnum = "";
	int wasting = 150;
	int[] wbcars = new int[10];
	int[] wbclass = new int[10];
	int[] wbfix = new int[10];
	int[] wblaps = new int[10];
	int[] wbstage = new int[10];
	String[] wbstages = new String[10];
	int[] wcars = new int[5];
	int[] wclass = new int[5];
	String[] wday = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	int[] wfix = new int[5];
	int[] wlaps = new int[5];
	String[] wstages = new String[5];
	String xclan = "";
	xtGraphics xt;

	public Globe(final Graphics2D graphics2d, final xtGraphics var_xtGraphics, final Medium medium, final Login login,
			final CarDefine cardefine, final CheckPoints checkpoints, final ContO[] contos, final ContO[] contos_0_,
			final GameSparker gamesparker) {
	}

	public void avatarpng() {
	}

	public void clanbgpng() {
	}

	public void clanlogopng(final String string) {
	}

	public Color color2k(final int i, final int i_734_, final int i_735_) {
		return new Color(0, 0, 0);
	}

	public Color colorb2k(final boolean bool, final int i, final int i_736_, final int i_737_) {
		return new Color(0, 0, 0);
	}

	public String contime(final long l) {
		return "";
	}

	public void dome(final int i, final int i_1_, final int i_2_, final boolean bool, final Control control) {
	}

	public void domelogos() {
	}

	public void dotab2(final int i, final int i_197_, final boolean bool) {
	}

	public void dotab3(final int i, final int i_94_, final boolean bool) {
	}

	public boolean drawbutton(final Image image, final int i, final int i_718_, final int i_719_, final int i_720_,
			final boolean bool) {
		return false;
	}

	public boolean drawl(final Graphics2D graphics2d, final String string, final int i, final int i_615_,
			final boolean bool) {
		return false;
	}

	public String getfuncSvalue(final String string, final String string_766_, final int i) {
		return "";
	}

	public int getfuncvalue(final String string, final String string_761_, final int i) {
		return 0;
	}

	public long getLvalue(final String string, final int i) {
		return 0L;
	}

	public String getSvalue(final String string, final int i) {
		return "";
	}

	public int getvalue(final String string, final int i) {
		return 0;
	}

	public void intclanbgpng(final String string) {
	}

	public int loadaddcars() {
		return 0;
	}

	public int loadaddstages() {
		return 0;
	}

	public void loadchamps() {
	}

	public void loadclan() {
	}

	public int loadclancars() {
		return 0;
	}

	public void loadclanlink() {
	}

	public int loadclanstages() {
		return 0;
	}

	public void loadfclan() {
	}

	public void loadfriends() {
	}

	public void loadiclancars(final String string) {
	}

	public void loadiclanstages(final String string) {
	}

	public void loadnews() {
	}

	public void loadproinfo() {
	}

	public void loadprostages() {
	}

	public void loadwarb() {
	}

	public void loadwgames() {
	}

	public void logopng() {
	}

	public void onexit() {
	}

	public void onexitpro() {
	}

	public void redogame() {
	}

	public void roomlogos(final String[] strings, final int i) {
	}

	@Override
	public void run() {
	}

	public void stopallnow() {
	}

	public boolean stringbutton(final Graphics2D graphics2d, final String string, final int i, final int i_724_,
			final int i_725_, final int i_726_, final int i_727_, final boolean bool, final int i_728_,
			final int i_729_) {
		return false;
	}

	public void tlink(final Graphics2D graphics2d, final int i, final int i_693_, final String string,
			final String string_694_, final int i_695_, final int i_696_, final boolean bool, final int i_697_,
			final int i_698_, final int i_699_, final String string_700_, final String string_701_) {
	}

	public void trunsent() {
	}
}