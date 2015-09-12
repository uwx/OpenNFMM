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
	MediaTracker mt;
	Graphics2D rd;
	xtGraphics xt;
	FontMetrics ftm;
	ImageObserver ob;
	GameSparker gs;
	Login lg;
	CarDefine cd;
	Medium m;
	Graphics2D rdo;
	Image gImage;
	Thread connector;
	boolean domon = false;
	Socket socket;
	BufferedReader din;
	PrintWriter dout;
	int fase = 0;
	int open = 0;
	boolean upo = false;
	int tab = 3;
	boolean onp = false;
	int ptab = 0;
	int spos = 0;
	int lspos = 0;
	int mscro = 825;
	int spos2 = 0;
	int lspos2 = 0;
	int mscro2 = 825;
	int spos3 = 0;
	int lspos3 = 0;
	int mscro3 = 825;
	int spos4 = 208;
	int lspos4 = 0;
	int mscro4 = 825;
	int spos5 = 0;
	int lspos5 = 0;
	int mscro5 = 825;
	int overit = 0;
	int flk = 0;
	int flko = 0;
	boolean flg = false;
	int curs = 0;
	int waitlink = 0;
	int addstage = 0;
	boolean darker = false;
	int npo = -1;
	String[] pname = new String[900];
	int[] proom = new int[900];
	int[] pserver = new int[900];
	int[][] roomf = new int[3][5];
	int npf = -1;
	String[] fname = new String[900];
	String[] cnfname = new String[10];
	int ncnf = 0;
	int freq = 0;
	int sfreq = 0;
	String freqname = "";
	String sfreqname = "";
	int cntf = 0;
	String[] cnames = new String[21];
	String[] sentn = new String[21];
	String[] ctime = new String[21];
	long[] nctime = new long[21];
	int updatec = -1;
	String proname = "";
	boolean loadedp = false;
	int edit = 0;
	int upload = 0;
	int perc = 0;
	int playt = 0;
	int uploadt = 0;
	String filename = "";
	String msg = "";
	String trackname = "";
	boolean refresh = false;
	boolean logol = false;
	boolean avatarl = false;
	int sentchange = 0;
	boolean badlang = false;
	String[] aboutxt = new String[3];
	int nab = 0;
	Image clanlogo;
	Image avatar;
	int racing = 50;
	int wasting = 150;
	String themesong = "";
	String sentance = "";
	int trackvol = 0;
	int comesoon = 0;
	String proclan = "";
	int protab = 0;
	int loadpst = 0;
	String loadpstage = "";
	boolean loadedpstage = false;
	int nlg = 0;
	String[] logos = new String[200];
	boolean[] logon = new boolean[200];
	Image[] logoi = new Image[200];
	int loadmsgs = -1;
	String hasmsgs = "";
	String lastsub = "";
	int nm = 0;
	String[] mname = new String[200];
	String[] mconvo = new String[200];
	String[] msub = new String[200];
	int[] mtyp = new int[200];
	String[] mtime = new String[200];
	long[] mctime = new long[200];
	int openc = 0;
	int opy = 0;
	int addopy = 0;
	int oph = 0;
	int itemsel = 0;
	int loaditem = 0;
	String[] mline = new String[1000];
	int[] mlinetyp = new int[1000];
	long[] mctimes = new long[1000];
	String[] mtimes = new String[1000];
	int nml = 0;
	int readmsg = 0;
	String opname = "";
	String blockname = "";
	String unblockname = "";
	int sendmsg = 0;
	String[] wday = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
	String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
			"November", "December" };
	int itab = 0;
	int litab = -1;
	int cadmin = 0;
	String[] cmline = new String[1000];
	int[] cmlinetyp = new int[1000];
	long[] cmctimes = new long[1000];
	String[] cmtimes = new String[1000];
	int cnml = 0;
	int readclan = 0;
	int sendcmsg = 0;
	int loadinter = -1;
	int ni = 0;
	String[] iclan = new String[200];
	String[] iconvo = new String[200];
	String[] isub = new String[200];
	String[] icheck = new String[200];
	String[] itime = new String[200];
	long[] ictime = new long[200];
	String[] istat = new String[200];
	String[] itcar = new String[200];
	String[] igcar = new String[200];
	String[] iwarn = new String[200];
	int openi = 0;
	int readint = 0;
	String intclan = "";
	String lastint = "";
	int dispi = 0;
	String dwarn = "";
	String dtcar = "";
	String dgcar = "";
	int nil = 0;
	String[] iline = new String[1000];
	int[] ilinetyp = new int[1000];
	long[] ictimes = new long[1000];
	String[] itimes = new String[1000];
	int intsel = 0;
	int isel = 0;
	int ifas = 0;
	int leader = -1;
	int sendint = 0;
	boolean inishsel = false;
	boolean redif = false;
	String imsg = "";
	int wag = 0;
	int iflk = 0;
	String itake = "";
	String igive = "";
	String viewcar = "";
	String warnum = "";
	boolean sendwarnum = false;
	String[] wstages = new String[5];
	int[] wlaps = new int[5];
	int[] wcars = new int[5];
	int[] wclass = new int[5];
	int[] wfix = new int[5];
	int nvgames1 = 0;
	int nvgames2 = 0;
	int viewgame1 = 0;
	int viewgame2 = 0;
	String viewwar1 = "";
	String viewwar2 = "";
	String xclan = "";
	String sendwar = "";
	boolean ichlng = false;
	String[] vwstages1 = new String[10];
	int[] vwlaps1 = new int[10];
	int[] vwcars1 = new int[10];
	int[] vwclass1 = new int[10];
	int[] vwfix1 = new int[10];
	String[] vwstages2 = new String[10];
	int[] vwlaps2 = new int[10];
	int[] vwcars2 = new int[10];
	int[] vwclass2 = new int[10];
	int[] vwfix2 = new int[10];
	String[] vwinner = new String[10];
	int vwscorex = 0;
	int vwscorei = 0;
	Image intclanbg = null;
	String intclanlo = "";
	boolean intclanbgloaded = false;
	Image myclanbg = null;
	int loadedmyclanbg = 0;
	int cfase = 0;
	boolean notclan = false;
	String claname = "EvilOnes";
	boolean loadedc = false;
	boolean clanbgl = false;
	Image clanbg;
	int editc = 0;
	int em = 0;
	int ctab = 0;
	int nmb = 0;
	String lccnam = "";
	String[] member = new String[20];
	int[] mlevel = new int[20];
	String[] mrank = new String[20];
	int nrmb = 0;
	String[] rmember = new String[100];
	boolean showreqs = false;
	int blocknote = 0;
	int blockb = 0;
	boolean loadedcm = false;
	int ncln = 0;
	String[] clname = new String[20];
	String smsg = "";
	String sltit = "";
	boolean attachetoclan = false;
	boolean loadedlink = false;
	int loadedcars = -1;
	int loadedcar = 0;
	String ltit = "";
	String ldes = "";
	String lurl = "";
	boolean forcsel = false;
	String selcar = "";
	String selstage = "";
	String perry = "";
	int mrot = 0;
	int loadedstages = -1;
	int loadedstage = 0;
	CheckPoints cp;
	ContO[] bco;
	ContO[] co;
	int mouson = -1;
	int nclns = 0;
	String[] clanlo = new String[20];
	int ntab = 0;
	int loadednews = 0;
	int spos6 = 0;
	int lspos6 = 0;
	String[] newplayers = { "", "", "", "", "" };
	int[] nwarbs = { -1, -1, -1, -1, -1 };
	String[] nwclan = new String[5];
	String[] nlclan = new String[5];
	String[] nwinob = new String[5];
	int[] nwinp = new int[5];
	int[] nlosp = new int[5];
	String[] nwtime = new String[5];
	int il = 0;
	String[] nttime = new String[300];
	String[] text = new String[300];
	int[] nln = new int[300];
	String[][][] link = new String[300][4][2];
	int maxclans = 1000;
	int loadwstat = 0;
	int ncc = 0;
	int champ = -1;
	int leadsby = 0;
	String[] conclan;
	int[] totp;
	int[] ord;
	int[] nvc;
	int[][] points;
	String[][] verclan;
	int eng = -1;
	int engo = 0;
	boolean frkl = false;
	int underc = 0;
	float bgf = 0.0F;
	boolean bgup = false;
	int[] bgx = { 0, 670, 1340 };
	int flkn = 0;
	int cur = 0;
	int sdist = 0;
	int scro = 0;
	boolean donewc = false;
	boolean dosrch = false;
	boolean dorank = false;
	boolean doweb1 = false;
	boolean doweb2 = false;
	boolean dommsg = false;
	boolean donemsg = false;
	int doi = 0;
	int ados = 0;
	int lspos6w = 0;
	long ntime = 0L;
	int loadwbgames = 0;
	int warb = 0;
	int gameturn = -1;
	String warbnum = "";
	String vclan = "";
	String[] wbstages = new String[10];
	int[] wbstage = new int[10];
	int[] wblaps = new int[10];
	int[] wbcars = new int[10];
	int[] wbclass = new int[10];
	int[] wbfix = new int[10];
	String gameturndisp = "";
	int ascore = 0;
	int vscore = 0;
	String lwbwinner = "";
	boolean canredo = false;

	public Globe(final Graphics2D graphics2d, final xtGraphics var_xtGraphics, final Medium medium, final Login login,
			final CarDefine cardefine, final CheckPoints checkpoints, final ContO[] contos, final ContO[] contos_0_,
			final GameSparker gamesparker) {
	}

	public void dome(final int i, final int i_1_, final int i_2_, final boolean bool, final Control control) {
	}

	public void dotab3(final int i, final int i_94_, final boolean bool) {
	}

	public void dotab2(final int i, final int i_197_, final boolean bool) {
	}

	@Override
	public void run() {
	}

	public void onexit() {
	}

	public void onexitpro() {
	}

	public void stopallnow() {
	}

	public void trunsent() {
	}

	public void roomlogos(final String[] strings, final int i) {
	}

	public void domelogos() {
	}

	public boolean drawl(final Graphics2D graphics2d, final String string, final int i, final int i_615_,
			final boolean bool) {
		return false;
	}

	public void logopng() {
	}

	public void clanlogopng(final String string) {
	}

	public void avatarpng() {
	}

	public void clanbgpng() {
	}

	public void intclanbgpng(final String string) {
	}

	public void loadclan() {
	}

	public void loadclanlink() {
	}

	public void loadfclan() {
	}

	public int loadclancars() {
		return 0;
	}

	public int loadaddcars() {
		return 0;
	}

	public void loadiclancars(final String string) {
	}

	public int loadclanstages() {
		return 0;
	}

	public int loadaddstages() {
		return 0;
	}

	public void loadiclanstages(final String string) {
	}

	public void loadproinfo() {
	}

	public void loadprostages() {
	}

	public void loadfriends() {
	}

	public void loadnews() {
	}

	public void loadchamps() {
	}

	public String contime(final long l) {
		return "";
	}

	public void tlink(final Graphics2D graphics2d, final int i, final int i_693_, final String string,
			final String string_694_, final int i_695_, final int i_696_, final boolean bool, final int i_697_,
			final int i_698_, final int i_699_, final String string_700_, final String string_701_) {
	}

	public void loadwarb() {
	}

	public void loadwgames() {
	}

	public void redogame() {
	}

	public boolean drawbutton(final Image image, final int i, final int i_718_, final int i_719_, final int i_720_,
			final boolean bool) {
		return false;
	}

	public boolean stringbutton(final Graphics2D graphics2d, final String string, final int i, final int i_724_,
			final int i_725_, final int i_726_, final int i_727_, final boolean bool, final int i_728_,
			final int i_729_) {
		return false;
	}

	public Color color2k(final int i, final int i_734_, final int i_735_) {
		return new Color(0, 0, 0);
	}

	public Color colorb2k(final boolean bool, final int i, final int i_736_, final int i_737_) {
		return new Color(0, 0, 0);
	}

	public int getvalue(final String string, final int i) {
		return 0;
	}

	public String getSvalue(final String string, final int i) {
		return "";
	}

	public long getLvalue(final String string, final int i) {
		return 0L;
	}

	public int getfuncvalue(final String string, final String string_761_, final int i) {
		return 0;
	}

	public String getfuncSvalue(final String string, final String string_766_, final int i) {
		return "";
	}
}