
/* CarDefine - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CarDefine implements Runnable {
	int ac = -1;
	float[][] acelf = { { 11.0F, 5.0F, 5.0F }, { 14.0F, 7.0F, 5.0F }, { 10.0F, 5.0F, 8.0F }, { 11.0F, 6.0F, 8.0F },
			{ 10.0F, 5.0F, 8.0F }, { 12.0F, 6.0F, 5.0F }, { 7.0F, 9.0F, 4.0F }, { 11.0F, 5.0F, 5.0F },
			{ 12.0F, 7.0F, 4.0F }, { 12.0F, 7.0F, 8.0F }, { 11.5F, 6.5F, 8.0F }, { 9.0F, 5.0F, 5.0F },
			{ 13.0F, 7.0F, 4.5F }, { 13.0F, 8.0F, 5.0F }, { 11.0F, 13.0F, 4.0F }, { 12.0F, 6.0F, 8.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
			{ 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F } };
	String acname = Messages.getString("CarDefine.0"); //$NON-NLS-1$
	int action = 0;
	Thread actionloader;
	int[] adds = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] airc = { 70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	float[] airs = { 1.0F, 1.2F, 0.95F, 1.0F, 2.2F, 1.0F, 0.9F, 0.8F, 1.0F, 0.9F, 1.15F, 0.8F, 1.0F, 3.0F, 1.3F, 1.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F };
	ContO[] bco;
	float[] bounce = { 1.2F, 1.05F, 1.3F, 1.15F, 1.3F, 1.2F, 1.15F, 1.1F, 1.2F, 1.1F, 1.15F, 0.8F, 1.05F, 0.8F, 1.1F,
			1.15F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
	Thread carloader;
	boolean carlon = false;
	int[] cclass = { 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] clrad = { 3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000, 15000, 4000, 7000, 10000, 15000, 5500, 5000,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0 };
	float[] comprad = { 0.5F, 0.4F, 0.8F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5F, 0.5F, 0.8F, 0.5F, 1.5F, 0.5F, 0.8F, 0.5F, 0.8F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F };
	String[] createdby = new String[40];
	float[] dammult = { 0.75F, 0.8F, 0.45F, 0.8F, 0.42F, 0.7F, 0.72F, 0.6F, 0.58F, 0.41F, 0.67F, 0.45F, 0.61F, 0.01F,
			0.38F, 0.52F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
	float[] dishandle = { 0.65F, 0.6F, 0.55F, 0.77F, 0.62F, 0.9F, 0.6F, 0.72F, 0.45F, 0.8F, 0.95F, 0.4F, 0.87F, 0.42F,
			1.0F, 0.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
	int[] enginsignature = { 0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	String fails = Messages.getString("CarDefine.1"); //$NON-NLS-1$
	int[] flipy = { -50, -60, -92, -44, -60, -57, -54, -60, -77, -57, -82, -85, -28, -100, -63, -127, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	float[] grip = { 20.0F, 27.0F, 18.0F, 22.0F, 19.0F, 20.0F, 25.0F, 20.0F, 19.0F, 24.0F, 22.5F, 25.0F, 30.0F, 27.0F,
			25.0F, 27.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
	GameSparker gs;
	int haltload = 0;
	int[] handb = { 7, 10, 7, 15, 12, 8, 9, 10, 5, 7, 8, 10, 8, 12, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	boolean[] include = new boolean[40];
	int inslot = -1;
	String lastcar = Messages.getString("CarDefine.2"); //$NON-NLS-1$
	int lastload = 0;
	int[] lcardate = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] lift = { 0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int loadlist = 0;
	String[] loadnames = new String[20];
	Medium m;
	int[] maxmag = { 7600, 4200, 7200, 6000, 6000, 15000, 17200, 17000, 18000, 11000, 19000, 10700, 13000, 9999999,
			5800, 18000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0 };
	float[] moment = { 1.3F, 0.75F, 1.4F, 1.2F, 1.1F, 1.38F, 1.43F, 1.48F, 1.35F, 1.7F, 1.42F, 2.0F, 1.26F, 5.0F, 1.5F,
			2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
	int msloaded = 0;
	int[] msquash = { 7, 4, 7, 2, 8, 4, 6, 4, 3, 8, 4, 10, 3, 20, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	String[] names = { Messages.getString("CarDefine.3"), Messages.getString("CarDefine.4"), Messages.getString("CarDefine.5"), Messages.getString("CarDefine.6"), Messages.getString("CarDefine.7"), Messages.getString("CarDefine.8"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
			Messages.getString("CarDefine.9"), Messages.getString("CarDefine.10"), Messages.getString("CarDefine.11"), Messages.getString("CarDefine.12"), Messages.getString("CarDefine.13"), Messages.getString("CarDefine.14"), Messages.getString("CarDefine.15"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
			Messages.getString("CarDefine.16"), Messages.getString("CarDefine.17"), Messages.getString("CarDefine.18"), Messages.getString("CarDefine.19"), Messages.getString("CarDefine.20"), Messages.getString("CarDefine.21"), Messages.getString("CarDefine.22"), Messages.getString("CarDefine.23"), Messages.getString("CarDefine.24"), Messages.getString("CarDefine.25"), Messages.getString("CarDefine.26"), Messages.getString("CarDefine.27"), Messages.getString("CarDefine.28"), Messages.getString("CarDefine.29"), Messages.getString("CarDefine.30"), Messages.getString("CarDefine.31"), Messages.getString("CarDefine.32"), Messages.getString("CarDefine.33"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$ //$NON-NLS-17$ //$NON-NLS-18$
			Messages.getString("CarDefine.34"), Messages.getString("CarDefine.35"), Messages.getString("CarDefine.36"), Messages.getString("CarDefine.37"), Messages.getString("CarDefine.38"), Messages.getString("CarDefine.39"), Messages.getString("CarDefine.40"), Messages.getString("CarDefine.41"), Messages.getString("CarDefine.42"), Messages.getString("CarDefine.43"), Messages.getString("CarDefine.44"), Messages.getString("CarDefine.45"), Messages.getString("CarDefine.46"), Messages.getString("CarDefine.47"), Messages.getString("CarDefine.48"), Messages.getString("CarDefine.49"), Messages.getString("CarDefine.50"), Messages.getString("CarDefine.51"), Messages.getString("CarDefine.52"), Messages.getString("CarDefine.53"), Messages.getString("CarDefine.54"), Messages.getString("CarDefine.55"), Messages.getString("CarDefine.56"), Messages.getString("CarDefine.57"), Messages.getString("CarDefine.58") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$ //$NON-NLS-17$ //$NON-NLS-18$ //$NON-NLS-19$ //$NON-NLS-20$ //$NON-NLS-21$ //$NON-NLS-22$ //$NON-NLS-23$ //$NON-NLS-24$ //$NON-NLS-25$
	int nl = 0;
	int nlcars = 0;
	int nlocars = 0;
	int onloadingcar = 0;
	String onstage = Messages.getString("CarDefine.59"); //$NON-NLS-1$
	float[] outdam = { 0.68F, 0.35F, 0.8F, 0.5F, 0.42F, 0.76F, 0.82F, 0.76F, 0.72F, 0.62F, 0.79F, 0.95F, 0.77F, 1.0F,
			0.85F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
	int[] powerloss = { 2500000, 2500000, 3500000, 2500000, 4000000, 2500000, 3200000, 3200000, 2750000, 5500000,
			2750000, 4500000, 3500000, 999999999, 3000000, 5500000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] publish = new int[40];
	int[] push = { 2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int reco = -2;
	int[] revlift = { 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] revpush = { 2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int roundslot = 0;
	float[] simag = { 0.9F, 0.85F, 1.05F, 0.9F, 0.85F, 0.9F, 1.05F, 0.9F, 1.0F, 1.05F, 0.9F, 1.1F, 0.9F, 1.3F, 0.9F,
			1.15F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
			0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
	int staction = 0;
	Thread stageaction;
	int[][] swits = { { 50, 185, 282 }, { 100, 200, 310 }, { 60, 180, 275 }, { 76, 195, 298 }, { 70, 170, 275 },
			{ 70, 202, 293 }, { 60, 170, 289 }, { 70, 206, 291 }, { 90, 210, 295 }, { 90, 190, 276 }, { 70, 200, 295 },
			{ 50, 160, 270 }, { 90, 200, 305 }, { 50, 130, 210 }, { 80, 200, 300 }, { 70, 210, 290 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
			{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	Trackers t;
	String tclan = Messages.getString("CarDefine.60"); //$NON-NLS-1$
	String tclankey = Messages.getString("CarDefine.61"); //$NON-NLS-1$
	String tnickey = Messages.getString("CarDefine.62"); //$NON-NLS-1$
	int[] top20adds = new int[20];
	int[] turn = { 6, 9, 5, 7, 8, 7, 5, 5, 9, 7, 7, 4, 6, 5, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	String viewname = Messages.getString("CarDefine.63"); //$NON-NLS-1$
	int xnlocars = 0;

	public CarDefine(final ContO[] contos, final Medium medium, final Trackers trackers,
			final GameSparker gamesparker) {
		bco = contos;
		m = medium;
		t = trackers;
		gs = gamesparker;
	}

	public String getSvalue(final String string, final String string_26_, final int i) {
		String string_27_ = Messages.getString("CarDefine.64"); //$NON-NLS-1$
		int i_28_ = 0;
		for (int i_29_ = string.length() + 1; i_29_ < string_26_.length() && i_28_ <= i; i_29_++) {
			final String string_30_ = new StringBuilder().append(Messages.getString("CarDefine.65")).append(string_26_.charAt(i_29_)).toString(); //$NON-NLS-1$
			if (string_30_.equals(Messages.getString("CarDefine.66")) || string_30_.equals(Messages.getString("CarDefine.67"))) //$NON-NLS-1$ //$NON-NLS-2$
				i_28_++;
			else if (i_28_ == i)
				string_27_ = new StringBuilder().append(string_27_).append(string_30_).toString();
		}
		return string_27_;
	}

	public int getvalue(final String string, final String string_21_, final int i) {
		int i_22_ = 0;
		String string_23_ = Messages.getString("CarDefine.68"); //$NON-NLS-1$
		for (int i_24_ = string.length() + 1; i_24_ < string_21_.length(); i_24_++) {
			final String string_25_ = new StringBuilder().append(Messages.getString("CarDefine.69")).append(string_21_.charAt(i_24_)).toString(); //$NON-NLS-1$
			if (string_25_.equals(Messages.getString("CarDefine.70")) || string_25_.equals(Messages.getString("CarDefine.71"))) { //$NON-NLS-1$ //$NON-NLS-2$
				i_22_++;
				i_24_++;
			}
			if (i_22_ == i)
				string_23_ = new StringBuilder().append(string_23_).append(string_21_.charAt(i_24_)).toString();
		}
		return Float.valueOf(string_23_).intValue();
	}

	public int loadcar(final String string, int i) {
		try {
			final File file = new File(new StringBuilder().append(Messages.getString("CarDefine.72")).append(Madness.fpath).append(Messages.getString("CarDefine.73")) //$NON-NLS-1$ //$NON-NLS-2$
					.append(string).append(Messages.getString("CarDefine.74")).toString()); //$NON-NLS-1$
			if (file.exists()) {
				String string_73_ = Messages.getString("CarDefine.75"); //$NON-NLS-1$
				final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
				String string_74_;
				while ((string_74_ = bufferedreader.readLine()) != null && !Thread.currentThread().isInterrupted())
					string_73_ = new StringBuilder().append(string_73_).append(Messages.getString("CarDefine.76")).append(string_74_).append(Messages.getString("CarDefine.77")) //$NON-NLS-1$ //$NON-NLS-2$
							.toString();
				bufferedreader.close();
				m.loadnew = true;
				bco[i] = new ContO(string_73_.getBytes(), m, t);
				if (bco[i].errd || bco[i].npl <= 60)
					i = -1;
				if (i != -1) {
					bco[i].shadow = true;
					bco[i].noline = false;
					bco[i].decor = false;
					bco[i].tnt = 0;
					bco[i].disp = 0;
					bco[i].disline = 7;
					bco[i].grounded = 1.0F;
					boolean bool = true;
					if (bco[i].keyz[0] < 0 || bco[i].keyx[0] > 0)
						bool = false;
					if (bco[i].keyz[1] < 0 || bco[i].keyx[1] < 0)
						bool = false;
					if (bco[i].keyz[2] > 0 || bco[i].keyx[2] > 0)
						bool = false;
					if (bco[i].keyz[3] > 0 || bco[i].keyx[3] < 0)
						bool = false;
					if (!bool)
						i = -1;
				}
				if (i != -1) {
					loadstat(string_73_.getBytes(), string, bco[i].maxR, bco[i].roofat, bco[i].wh, i);
					if (names[i].equals(Messages.getString("CarDefine.78"))) //$NON-NLS-1$
						i = -1;
				}
				m.loadnew = false;
			} else
				i = -1;
		} catch (final Exception exception) {
			i = -1;
			System.out.println(new StringBuilder().append(Messages.getString("CarDefine.79")).append(exception).toString()); //$NON-NLS-1$
		}
		System.gc();
		return i;
	}

	public void loadcarmaker() {
		m.csky[0] = 170;
		m.csky[1] = 220;
		m.csky[2] = 255;
		m.cfade[0] = 255;
		m.cfade[1] = 220;
		m.cfade[2] = 220;
		m.snap[0] = 0;
		m.snap[1] = 0;
		m.snap[2] = 0;
		for (int i = 0; i < 40; i++)
			include[i] = false;
		nlcars = 16;
		final File file = new File(new StringBuilder().append(Messages.getString("CarDefine.80")).append(Madness.fpath).append(Messages.getString("CarDefine.81")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
		if (file.exists()) {
			final String[] strings = new File(
					new StringBuilder().append(Messages.getString("CarDefine.82")).append(Madness.fpath).append(Messages.getString("CarDefine.83")).toString()).list(); //$NON-NLS-1$ //$NON-NLS-2$
			for (int i = 0; i < strings.length; i++)
				if (strings[i].toLowerCase().endsWith(Messages.getString("CarDefine.84")) && nlcars < 56 //$NON-NLS-1$
						&& loadcar(strings[i].substring(0, strings[i].length() - 4), nlcars) == nlcars)
					nlcars++;
		}
		System.gc();
		if (nlcars > 16)
			lastload = 1;
	}

	public void loadclanstages(final String string) {
		if (!string.equals(Messages.getString("CarDefine.85"))) { //$NON-NLS-1$
			final String[] strings = new String[700];
			int i = 0;
			String string_69_ = Messages.getString("CarDefine.86"); //$NON-NLS-1$
			try {
				final URL url = new URL(new StringBuilder().append(Messages.getString("CarDefine.87")) //$NON-NLS-1$
						.append(string).append(Messages.getString("CarDefine.88")).toString()); //$NON-NLS-1$
				DataInputStream datainputstream;
				for (datainputstream = new DataInputStream(
						url.openStream()); (string_69_ = datainputstream.readLine()) != null && i < 700; i++)
					strings[i] = string_69_;
				if (i > 0)
					msloaded = 7;
				else
					msloaded = -2;
				datainputstream.close();
			} catch (final Exception exception) {
				final String string_70_ = new StringBuilder().append(Messages.getString("CarDefine.89")).append(exception).toString(); //$NON-NLS-1$
				if (string_70_.indexOf(Messages.getString("CarDefine.90")) != -1) //$NON-NLS-1$
					msloaded = -2;
				else
					msloaded = -1;
			}
			if (msloaded == 7) {
				gs.mstgs.setVisible(false);
				gs.mstgs.removeAll();
				gs.mstgs.add(gs.rd, Messages.getString("CarDefine.91")); //$NON-NLS-1$
				for (int i_71_ = 0; i_71_ < i; i_71_++)
					gs.mstgs.add(gs.rd, strings[i_71_]);
				gs.mstgs.select(0);
				gs.mstgs.setVisible(true);
			}
			if (msloaded == -1) {
				gs.mstgs.setVisible(false);
				gs.mstgs.removeAll();
				gs.mstgs.add(gs.rd, Messages.getString("CarDefine.92")); //$NON-NLS-1$
				gs.mstgs.select(0);
				gs.mstgs.setVisible(true);
			}
			if (msloaded == -2) {
				gs.mstgs.setVisible(false);
				gs.mstgs.removeAll();
				gs.mstgs.add(gs.rd, Messages.getString("CarDefine.93")); //$NON-NLS-1$
				gs.mstgs.select(0);
				gs.mstgs.setVisible(true);
			}
			System.gc();
		} else {
			msloaded = -2;
			gs.mstgs.setVisible(false);
			gs.mstgs.removeAll();
			gs.mstgs.add(gs.rd, Messages.getString("CarDefine.94")); //$NON-NLS-1$
			gs.mstgs.select(0);
			gs.mstgs.setVisible(true);
		}
	}

	public void loadmystages(final CheckPoints checkpoints) {
		final String[] strings = new String[700];
		int i = 0;
		String string = Messages.getString("CarDefine.95"); //$NON-NLS-1$
		try {
			final URL url = new URL(new StringBuilder().append(Messages.getString("CarDefine.96")) //$NON-NLS-1$
					.append(gs.tnick.getText()).append(Messages.getString("CarDefine.97")).append((int) (Math.random() * 1000.0)).append(Messages.getString("CarDefine.98")) //$NON-NLS-1$ //$NON-NLS-2$
					.toString());
			final DataInputStream datainputstream = new DataInputStream(url.openStream());
			while ((string = datainputstream.readLine()) != null && !Thread.currentThread().isInterrupted()) {
				string = new StringBuilder().append(Messages.getString("CarDefine.99")).append(string.trim()).toString(); //$NON-NLS-1$
				if (string.startsWith(Messages.getString("CarDefine.100"))) { //$NON-NLS-1$
					boolean bool = true;
					while (bool && i < 700 && !Thread.currentThread().isInterrupted()) {
						strings[i] = getSvalue(Messages.getString("CarDefine.101"), string, i); //$NON-NLS-1$
						if (strings[i].equals(Messages.getString("CarDefine.102"))) //$NON-NLS-1$
							bool = false;
						else
							i++;
					}
				}
			}
			if (i > 0)
				msloaded = 1;
			else
				msloaded = -2;
			datainputstream.close();
		} catch (final Exception exception) {
			final String string_61_ = new StringBuilder().append(Messages.getString("CarDefine.103")).append(exception).toString(); //$NON-NLS-1$
			if (string_61_.indexOf(Messages.getString("CarDefine.104")) != -1) //$NON-NLS-1$
				msloaded = -2;
			else
				msloaded = -1;
		}
		if (msloaded == 1) {
			gs.mstgs.setVisible(false);
			gs.mstgs.removeAll();
			gs.mstgs.add(gs.rd, Messages.getString("CarDefine.105")); //$NON-NLS-1$
			int i_62_ = 0;
			for (int i_63_ = 0; i_63_ < i; i_63_++) {
				gs.mstgs.add(gs.rd, strings[i_63_]);
				if (checkpoints.name.equals(strings[i_63_])) {
					i_62_ = i_63_ + 1;
					checkpoints.top20 = 0;
				}
			}
			gs.mstgs.select(i_62_);
			gs.mstgs.setVisible(true);
		}
		if (msloaded == -2) {
			gs.mstgs.setVisible(false);
			gs.mstgs.removeAll();
			gs.mstgs.add(gs.rd, Messages.getString("CarDefine.106")); //$NON-NLS-1$
			gs.mstgs.select(0);
			gs.mstgs.setVisible(true);
		}
		if (msloaded == -1) {
			gs.mstgs.setVisible(false);
			gs.mstgs.removeAll();
			gs.mstgs.add(gs.rd, Messages.getString("CarDefine.107")); //$NON-NLS-1$
			gs.mstgs.select(0);
			gs.mstgs.setVisible(true);
		}
		System.gc();
	}

	public int loadonlinecar(final String string, int i) {
		try {
			String string_52_ = new StringBuilder().append(Messages.getString("CarDefine.108")).append(string) //$NON-NLS-1$
					.append(Messages.getString("CarDefine.109")).toString(); //$NON-NLS-1$
			string_52_ = string_52_.replace(' ', '_');
			final URL url = new URL(string_52_);
			final int i_53_ = url.openConnection().getContentLength();
			final DataInputStream datainputstream = new DataInputStream(url.openStream());
			final byte[] is = new byte[i_53_];
			datainputstream.readFully(is);
			ZipInputStream zipinputstream;
			if (is[0] == 80 && is[1] == 75 && is[2] == 3)
				zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
			else {
				final byte[] is_54_ = new byte[i_53_ - 40];
				for (int i_55_ = 0; i_55_ < i_53_ - 40; i_55_++) {
					int i_56_ = 20;
					if (i_55_ >= 500)
						i_56_ = 40;
					is_54_[i_55_] = is[i_55_ + i_56_];
				}
				zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_54_));
			}
			final ZipEntry zipentry = zipinputstream.getNextEntry();
			if (zipentry != null) {
				int i_57_ = Integer.valueOf(zipentry.getName()).intValue();
				final byte[] is_58_ = new byte[i_57_];
				int i_59_ = 0;
				int i_60_;
				for (/**/; i_57_ > 0; i_57_ -= i_60_) {
					i_60_ = zipinputstream.read(is_58_, i_59_, i_57_);
					i_59_ += i_60_;
				}
				m.loadnew = true;
				bco[i] = new ContO(is_58_, m, t);
				if (bco[i].errd || bco[i].npl <= 60 || bco[i].maxR < 120)
					i = -1;
				if (i != -1) {
					bco[i].shadow = true;
					bco[i].noline = false;
					bco[i].decor = false;
					bco[i].tnt = 0;
					bco[i].disp = 0;
					bco[i].disline = 7;
					bco[i].grounded = 1.0F;
					boolean bool = true;
					if (bco[i].keyz[0] < 0 || bco[i].keyx[0] > 0)
						bool = false;
					if (bco[i].keyz[1] < 0 || bco[i].keyx[1] < 0)
						bool = false;
					if (bco[i].keyz[2] > 0 || bco[i].keyx[2] > 0)
						bool = false;
					if (bco[i].keyz[3] > 0 || bco[i].keyx[3] < 0)
						bool = false;
					if (!bool)
						i = -1;
				}
				if (i != -1) {
					loadstat(is_58_, string, bco[i].maxR, bco[i].roofat, bco[i].wh, i);
					if (names[i].equals(Messages.getString("CarDefine.110"))) //$NON-NLS-1$
						i = -1;
				}
				m.loadnew = false;
				datainputstream.close();
				zipinputstream.close();
			} else
				i = -1;
		} catch (final Exception exception) {
			i = -1;
		}
		System.gc();
		return i;
	}

	public void loadready() {
		m.csky[0] = 170;
		m.csky[1] = 220;
		m.csky[2] = 255;
		m.cfade[0] = 255;
		m.cfade[1] = 220;
		m.cfade[2] = 220;
		m.snap[0] = 0;
		m.snap[1] = 0;
		m.snap[2] = 0;
		fails = Messages.getString("CarDefine.111"); //$NON-NLS-1$
		for (int i = 0; i < 20; i++)
			loadnames[i] = Messages.getString("CarDefine.112"); //$NON-NLS-1$
		nl = 0;
		action = 0;
	}

	public void loadstagemaker() {
		gs.mstgs.setVisible(false);
		gs.mstgs.removeAll();
		gs.mstgs.add(gs.rd, Messages.getString("CarDefine.113")); //$NON-NLS-1$
		int i = 0;
		final File file = new File(new StringBuilder().append(Messages.getString("CarDefine.114")).append(Madness.fpath).append(Messages.getString("CarDefine.115")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
		if (file.exists()) {
			final String[] strings = new File(
					new StringBuilder().append(Messages.getString("CarDefine.116")).append(Madness.fpath).append(Messages.getString("CarDefine.117")).toString()).list(); //$NON-NLS-1$ //$NON-NLS-2$
			for (int i_72_ = 0; i_72_ < strings.length; i_72_++)
				if (strings[i_72_].toLowerCase().endsWith(Messages.getString("CarDefine.118")) && i < 200) { //$NON-NLS-1$
					gs.mstgs.add(gs.rd, strings[i_72_].substring(0, strings[i_72_].length() - 4));
					i++;
				}
		}
		if (i != 0)
			msloaded = 2;
		else {
			gs.mstgs.add(gs.rd, Messages.getString("CarDefine.119")); //$NON-NLS-1$
			msloaded = -1;
		}
		gs.mstgs.select(0);
		gs.mstgs.setVisible(true);
	}

	public void loadstat(final byte[] is, final String string, final int i, final int i_0_, final int i_1_,
			final int i_2_) {
		names[i_2_] = string;
		boolean bool = false;
		boolean bool_3_ = false;
		String string_4_ = Messages.getString("CarDefine.120"); //$NON-NLS-1$
		final int[] is_5_ = { 128, 128, 128, 128, 128 };
		int i_6_ = 640;
		final int[] is_7_ = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
		final int[] is_8_ = { 50, 50, 50 };
		enginsignature[i_2_] = 0;
		float f = 0.0F;
		publish[i_2_ - 16] = 0;
		createdby[i_2_ - 16] = Messages.getString("CarDefine.121"); //$NON-NLS-1$
		try {
			final DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(is));
			while ((string_4_ = datainputstream.readLine()) != null && !Thread.currentThread().isInterrupted()) {
				string_4_ = string_4_.trim();
				if (string_4_.startsWith(Messages.getString("CarDefine.122"))) //$NON-NLS-1$
					try {
						i_6_ = 0;
						for (int i_9_ = 0; i_9_ < 5; i_9_++)
							is_5_[i_9_] = getvalue(Messages.getString("CarDefine.123"), string_4_, i_9_); //$NON-NLS-1$
						// if (is_5_[i_9_] > 200)
						// is_5_[i_9_] = 200;
						// if (is_5_[i_9_] < 16)
						// is_5_[i_9_] = 16;
						// i_6_ += is_5_[i_9_];
						bool = true;
					} catch (final Exception exception) {
						bool = false;
					}
				if (string_4_.startsWith(Messages.getString("CarDefine.124"))) //$NON-NLS-1$
					try {
						for (int i_10_ = 0; i_10_ < 11; i_10_++)
							is_7_[i_10_] = getvalue(Messages.getString("CarDefine.125"), string_4_, i_10_); //$NON-NLS-1$
						// if (is_7_[i_10_] > 100)
						// is_7_[i_10_] = 100;
						// if (is_7_[i_10_] < 0)
						// is_7_[i_10_] = 0;
						for (int i_11_ = 0; i_11_ < 3; i_11_++)
							is_8_[i_11_] = getvalue(Messages.getString("CarDefine.126"), string_4_, i_11_ + 11); //$NON-NLS-1$
						// if (i_11_ != 0 && is_8_[i_11_] > 100)
						// is_8_[i_11_] = 100;
						// if (is_8_[i_11_] < 0)
						// is_8_[i_11_] = 0;
						enginsignature[i_2_] = getvalue(Messages.getString("CarDefine.127"), string_4_, 14); //$NON-NLS-1$
						if (enginsignature[i_2_] > 4)
							enginsignature[i_2_] = 0;
						if (enginsignature[i_2_] < 0)
							enginsignature[i_2_] = 0;
						f = getvalue(Messages.getString("CarDefine.128"), string_4_, 15); //$NON-NLS-1$
						if (f > 0.0F)
							bool_3_ = true;
					} catch (final Exception exception) {
						bool_3_ = false;
					}
				if (string_4_.startsWith(Messages.getString("CarDefine.129"))) //$NON-NLS-1$
					try {
						final int i_12_ = getvalue(Messages.getString("CarDefine.130"), string_4_, 0); //$NON-NLS-1$
						// if (i_12_ > 200)
						// i_12_ = 200;
						// if (i_12_ < 50)
						// i_12_ = 50;
						dishandle[i_2_] = i_12_ / 200.0F;
					} catch (final Exception exception) {
						/* empty */
					}
				if (string_4_.startsWith(Messages.getString("CarDefine.131"))) //$NON-NLS-1$
					createdby[i_2_ - 16] = getSvalue(Messages.getString("CarDefine.132"), string_4_, 0); //$NON-NLS-1$
				if (string_4_.startsWith(Messages.getString("CarDefine.133"))) //$NON-NLS-1$
					publish[i_2_ - 16] = getvalue(Messages.getString("CarDefine.134"), string_4_, 0); //$NON-NLS-1$
			}
			datainputstream.close();
		} catch (final Exception exception) {
			System.out.println(new StringBuilder().append(Messages.getString("CarDefine.135")).append(exception).toString()); //$NON-NLS-1$
		}
		if (bool && bool_3_) {
			int i_13_ = 0;
			if (i_6_ > 680)
				i_13_ = 680 - i_6_;
			if (i_6_ > 640 && i_6_ < 680)
				i_13_ = 640 - i_6_;
			if (i_6_ > 600 && i_6_ < 640)
				i_13_ = 600 - i_6_;
			if (i_6_ > 560 && i_6_ < 600)
				i_13_ = 560 - i_6_;
			if (i_6_ > 520 && i_6_ < 560)
				i_13_ = 520 - i_6_;
			if (i_6_ < 520)
				i_13_ = 520 - i_6_;
			while (i_13_ != 0 && !Thread.currentThread().isInterrupted())
				for (int i_14_ = 0; i_14_ < 5; i_14_++) {
					if (i_13_ > 0 && is_5_[i_14_] < 200) {
						is_5_[i_14_]++;
						i_13_--;
					}
					if (i_13_ < 0 && is_5_[i_14_] > 16) {
						is_5_[i_14_]--;
						i_13_++;
					}
				}
			i_6_ = 0;
			for (int i_15_ = 0; i_15_ < 5; i_15_++)
				i_6_ += is_5_[i_15_];
			if (i_6_ == 520)
				cclass[i_2_] = 0;
			if (i_6_ == 560)
				cclass[i_2_] = 1;
			if (i_6_ == 600)
				cclass[i_2_] = 2;
			if (i_6_ == 640)
				cclass[i_2_] = 3;
			if (i_6_ == 680)
				cclass[i_2_] = 4;
			int i_16_ = 0;
			int i_17_ = 0;
			float f_18_ = 0.5F;
			if (is_5_[0] == 200) {
				i_16_ = 1;
				i_17_ = 1;
			}
			if (is_5_[0] > 192 && is_5_[0] < 200) {
				i_16_ = 12;
				i_17_ = 1;
				f_18_ = (is_5_[0] - 192) / 8.0F;
			}
			if (is_5_[0] == 192) {
				i_16_ = 12;
				i_17_ = 12;
			}
			if (is_5_[0] > 148 && is_5_[0] < 192) {
				i_16_ = 14;
				i_17_ = 12;
				f_18_ = (is_5_[0] - 148) / 44.0F;
			}
			if (is_5_[0] == 148) {
				i_16_ = 14;
				i_17_ = 14;
			}
			if (is_5_[0] > 133 && is_5_[0] < 148) {
				i_16_ = 10;
				i_17_ = 14;
				f_18_ = (is_5_[0] - 133) / 15.0F;
			}
			if (is_5_[0] == 133) {
				i_16_ = 10;
				i_17_ = 10;
			}
			if (is_5_[0] > 112 && is_5_[0] < 133) {
				i_16_ = 15;
				i_17_ = 10;
				f_18_ = (is_5_[0] - 112) / 21.0F;
			}
			if (is_5_[0] == 112) {
				i_16_ = 15;
				i_17_ = 15;
			}
			if (is_5_[0] > 107 && is_5_[0] < 112) {
				i_16_ = 11;
				i_17_ = 15;
				f_18_ = (is_5_[0] - 107) / 5.0F;
			}
			if (is_5_[0] == 107) {
				i_16_ = 11;
				i_17_ = 11;
			}
			if (is_5_[0] > 88 && is_5_[0] < 107) {
				i_16_ = 13;
				i_17_ = 11;
				f_18_ = (is_5_[0] - 88) / 19.0F;
			}
			if (is_5_[0] == 88) {
				i_16_ = 13;
				i_17_ = 13;
			}
			if (is_5_[0] > 88) {
				swits[i_2_][0] = (int) ((swits[i_17_][0] - swits[i_16_][0]) * f_18_ + swits[i_16_][0]);
				swits[i_2_][1] = (int) ((swits[i_17_][1] - swits[i_16_][1]) * f_18_ + swits[i_16_][1]);
				swits[i_2_][2] = (int) ((swits[i_17_][2] - swits[i_16_][2]) * f_18_ + swits[i_16_][2]);
			} else {
				f_18_ = is_5_[0] / 88.0F;
				if (f_18_ < 0.76)
					f_18_ = 0.76F;
				swits[i_2_][0] = (int) (150.0F * f_18_);
				swits[i_2_][1] = (int) (250.0F * f_18_);
				swits[i_2_][2] = (int) (500.0F * f_18_);
			}
			i_16_ = 0;
			i_17_ = 0;
			f_18_ = 0.5F;
			if (is_5_[1] == 200) {
				i_16_ = 1;
				i_17_ = 1;
			}
			if (is_5_[1] > 150 && is_5_[1] < 200) {
				i_16_ = 14;
				i_17_ = 1;
				f_18_ = (is_5_[1] - 150) / 150.0F;
			}
			if (is_5_[1] == 150) {
				i_16_ = 14;
				i_17_ = 14;
			}
			if (is_5_[1] > 144 && is_5_[1] < 150) {
				i_16_ = 9;
				i_17_ = 14;
				f_18_ = (is_5_[1] - 144) / 6.0F;
			}
			if (is_5_[1] == 144) {
				i_16_ = 9;
				i_17_ = 9;
			}
			if (is_5_[1] > 139 && is_5_[1] < 144) {
				i_16_ = 6;
				i_17_ = 9;
				f_18_ = (is_5_[1] - 139) / 5.0F;
			}
			if (is_5_[1] == 139) {
				i_16_ = 6;
				i_17_ = 6;
			}
			if (is_5_[1] > 128 && is_5_[1] < 139) {
				i_16_ = 15;
				i_17_ = 6;
				f_18_ = (is_5_[1] - 128) / 11.0F;
			}
			if (is_5_[1] == 128) {
				i_16_ = 15;
				i_17_ = 15;
			}
			if (is_5_[1] > 122 && is_5_[1] < 128) {
				i_16_ = 10;
				i_17_ = 15;
				f_18_ = (is_5_[1] - 122) / 6.0F;
			}
			if (is_5_[1] == 122) {
				i_16_ = 10;
				i_17_ = 10;
			}
			if (is_5_[1] > 119 && is_5_[1] < 122) {
				i_16_ = 3;
				i_17_ = 10;
				f_18_ = (is_5_[1] - 119) / 5.0F;
			}
			if (is_5_[1] == 119) {
				i_16_ = 3;
				i_17_ = 3;
			}
			if (is_5_[1] > 98 && is_5_[1] < 119) {
				i_16_ = 5;
				i_17_ = 3;
				f_18_ = (is_5_[1] - 98) / 21.0F;
			}
			if (is_5_[1] == 98) {
				i_16_ = 5;
				i_17_ = 5;
			}
			if (is_5_[1] > 81 && is_5_[1] < 98) {
				i_16_ = 0;
				i_17_ = 5;
				f_18_ = (is_5_[1] - 81) / 17.0F;
			}
			if (is_5_[1] == 81) {
				i_16_ = 0;
				i_17_ = 0;
			}
			if (is_5_[1] <= 80) {
				i_16_ = 2;
				i_17_ = 2;
			}
			if (is_5_[0] <= 88) {
				i_16_ = 13;
				i_17_ = 13;
			}
			acelf[i_2_][0] = (acelf[i_17_][0] - acelf[i_16_][0]) * f_18_ + acelf[i_16_][0];
			acelf[i_2_][1] = (acelf[i_17_][1] - acelf[i_16_][1]) * f_18_ + acelf[i_16_][1];
			acelf[i_2_][2] = (acelf[i_17_][2] - acelf[i_16_][2]) * f_18_ + acelf[i_16_][2];
			if (is_5_[1] <= 70 && is_5_[0] > 88) {
				acelf[i_2_][0] = 9.0F;
				acelf[i_2_][1] = 4.0F;
				acelf[i_2_][2] = 5.0F;
			}
			f_18_ = (is_5_[2] - 88) / 109.0F;
			if (f_18_ > 1.0F)
				f_18_ = 1.0F;
			if (f_18_ < -0.55)
				f_18_ = -0.55F;
			airs[i_2_] = 0.55F + 0.45F * f_18_ + 0.4F * (is_7_[9] / 100.0F);
			if (airs[i_2_] < 0.3)
				airs[i_2_] = 3.0F;
			airc[i_2_] = (int) (10.0F + 70.0F * f_18_ + 30.0F * (is_7_[10] / 100.0F));
			if (airc[i_2_] < 0)
				airc[i_2_] = 0;
			int i_19_ = (int) (670.0F - (is_7_[9] + is_7_[10]) / 200.0F * 420.0F);
			if (is_5_[0] <= 88)
				i_19_ = (int) (1670.0F - (is_7_[9] + is_7_[10]) / 200.0F * 1420.0F);
			if (is_5_[2] > 190 && i_19_ < 300)
				i_19_ = 300;
			powerloss[i_2_] = i_19_ * 10000;
			moment[i_2_] = 0.7F + (is_5_[3] - 16) / 184.0F * 1.0F;
			if (is_5_[0] < 110)
				moment[i_2_] = 0.75F + (is_5_[3] - 16) / 184.0F * 1.25F;
			if (is_5_[3] == 200 && is_5_[4] == 200 && is_5_[0] <= 88)
				moment[i_2_] = 5.0F;
			float f_20_ = 0.9F + (is_5_[4] - 90) * 0.01F;
			if (f_20_ < 0.6)
				f_20_ = 0.6F;
			if (is_5_[4] == 200 && is_5_[0] <= 88)
				f_20_ = 5.0F;
			maxmag[i_2_] = (int) (f * f_20_);
			outdam[i_2_] = 0.35F + (f_20_ - 0.6F) * 0.5F;
			if (outdam[i_2_] < 0.35)
				outdam[i_2_] = 0.35F;
			if (outdam[i_2_] > 1.0F)
				outdam[i_2_] = 1.0F;
			clrad[i_2_] = (int) (is_8_[0] * is_8_[0] * 1.5);
			if (clrad[i_2_] < 1000)
				clrad[i_2_] = 1000;
			dammult[i_2_] = 3.0F + is_8_[1] * 0.005F;
			msquash[i_2_] = (int) (2.0 + is_8_[2] / 7.6);
			flipy[i_2_] = i_0_;
			handb[i_2_] = (int) (7.0F + is_7_[0] / 100.0F * 8.0F);
			turn[i_2_] = (int) (4.0F + is_7_[1] / 100.0F * 6.0F);
			grip[i_2_] = 16.0F + is_7_[2] / 100.0F * 14.0F;
			if (grip[i_2_] < 21.0F) {
				swits[i_2_][0] += 40.0F * ((21.0F - grip[i_2_]) / 5.0F);
				if (swits[i_2_][0] > 100)
					swits[i_2_][0] = 100;
			}
			bounce[i_2_] = 0.8F + is_7_[3] / 100.0F * 0.6F;
			if (is_7_[3] > 67) {
				airs[i_2_] *= 0.76F + (1.0F - is_7_[3] / 100.0F) * 0.24F;
				airc[i_2_] *= 0.76F + (1.0F - is_7_[3] / 100.0F) * 0.24F;
			}
			lift[i_2_] = (int) ((float) is_7_[5] * (float) is_7_[5] / 10000.0F * 30.0F);
			revlift[i_2_] = (int) (is_7_[6] / 100.0F * 32.0F);
			push[i_2_] = (int) (2.0F + is_7_[7] / 100.0F * 2.0F * ((30 - lift[i_2_]) / 30));
			revpush[i_2_] = (int) (1.0F + is_7_[8] / 100.0F * 2.0F);
			comprad[i_2_] = i / 400.0F + (is_5_[3] - 16) / 184.0F * 0.2F;
			if (comprad[i_2_] < 0.4)
				comprad[i_2_] = 0.4F;
			simag[i_2_] = (i_1_ - 17) * 0.0167F + 0.85F;
		} else
			names[i_2_] = Messages.getString("CarDefine.136"); //$NON-NLS-1$
	}

	public void loadtop20(final int i) {
		final String[] strings = new String[20];
		int i_64_ = 0;
		String string = Messages.getString("CarDefine.137"); //$NON-NLS-1$
		try {
			String string_65_ = Messages.getString("CarDefine.138"); //$NON-NLS-1$
			if (i == 3)
				string_65_ = Messages.getString("CarDefine.139"); //$NON-NLS-1$
			if (i == 4)
				string_65_ = Messages.getString("CarDefine.140"); //$NON-NLS-1$
			final URL url = new URL(new StringBuilder().append(Messages.getString("CarDefine.141")) //$NON-NLS-1$
					.append(string_65_).append(Messages.getString("CarDefine.142")).toString()); //$NON-NLS-1$
			final DataInputStream datainputstream = new DataInputStream(url.openStream());
			while ((string = datainputstream.readLine()) != null && !Thread.currentThread().isInterrupted()) {
				string = new StringBuilder().append(Messages.getString("CarDefine.143")).append(string.trim()).toString(); //$NON-NLS-1$
				if (string.startsWith(Messages.getString("CarDefine.144"))) { //$NON-NLS-1$
					boolean bool = true;
					while (bool && i_64_ < 20 && !Thread.currentThread().isInterrupted()) {
						strings[i_64_] = getSvalue(Messages.getString("CarDefine.145"), string, i_64_); //$NON-NLS-1$
						if (strings[i_64_].equals(Messages.getString("CarDefine.146"))) //$NON-NLS-1$
							bool = false;
						else
							i_64_++;
					}
				}
				if (string.startsWith(Messages.getString("CarDefine.147"))) //$NON-NLS-1$
					for (int i_66_ = 0; i_66_ < i_64_; i_66_++)
						top20adds[i_66_] = getvalue(Messages.getString("CarDefine.148"), string, i_66_); //$NON-NLS-1$
			}
			if (i_64_ > 0)
				msloaded = i;
			else
				msloaded = -2;
			datainputstream.close();
		} catch (final Exception exception) {
			final String string_67_ = new StringBuilder().append(Messages.getString("CarDefine.149")).append(exception).toString(); //$NON-NLS-1$
			if (string_67_.indexOf(Messages.getString("CarDefine.150")) != -1) //$NON-NLS-1$
				msloaded = -2;
			else
				msloaded = -1;
		}
		if (msloaded == i) {
			gs.mstgs.setVisible(false);
			gs.mstgs.removeAll();
			gs.mstgs.add(gs.rd, Messages.getString("CarDefine.151")); //$NON-NLS-1$
			for (int i_68_ = 0; i_68_ < i_64_; i_68_++)
				gs.mstgs.add(gs.rd, new StringBuilder().append(Messages.getString("CarDefine.152")).append(i_68_ + 1).append(Messages.getString("CarDefine.153")) //$NON-NLS-1$ //$NON-NLS-2$
						.append(strings[i_68_]).toString());
			gs.mstgs.select(0);
			gs.mstgs.setVisible(true);
		}
		if (msloaded == -1 || msloaded == -2) {
			gs.mstgs.setVisible(false);
			gs.mstgs.removeAll();
			gs.mstgs.add(gs.rd, Messages.getString("CarDefine.154")); //$NON-NLS-1$
			gs.mstgs.select(0);
			gs.mstgs.setVisible(true);
		}
		System.gc();
	}

	@Override
	public void run() {
		if (Thread.currentThread() == actionloader) {
			if (action == 10) {
				int i = -1;
				try {
					final Socket socket = new Socket(Messages.getString("CarDefine.155"), 7061); //$NON-NLS-1$
					final BufferedReader bufferedreader = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
					printwriter.println(new StringBuilder().append(Messages.getString("CarDefine.156")).append(gs.tnick.getText()).append(Messages.getString("CarDefine.157")) //$NON-NLS-1$ //$NON-NLS-2$
							.append(gs.tpass.getText()).append(Messages.getString("CarDefine.158")).append(names[ac]).append(Messages.getString("CarDefine.159")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
					final String string = bufferedreader.readLine();
					if (string != null)
						i = servervalue(string, 0);
					socket.close();
					bufferedreader.close();
					printwriter.close();
				} catch (final Exception exception) {
					i = -1;
				}
				if (i == 0)
					action = 3;
				else
					action = -10;
				System.gc();
			}
			if (action == 1) {
				reco = -1;
				try {
					final Socket socket = new Socket(Messages.getString("CarDefine.160"), 7061); //$NON-NLS-1$
					final BufferedReader bufferedreader = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
					printwriter.println(new StringBuilder().append(Messages.getString("CarDefine.161")).append(gs.tnick.getText()).append(Messages.getString("CarDefine.162")) //$NON-NLS-1$ //$NON-NLS-2$
							.append(gs.tpass.getText()).append(Messages.getString("CarDefine.163")).toString()); //$NON-NLS-1$
					final String string = bufferedreader.readLine();
					if (string != null) {
						reco = servervalue(string, 0);
						if (reco == 0 || reco == 3 || reco > 10) {
							tnickey = serverSvalue(string, 1);
							if (reco != -167) {
								tclan = serverSvalue(string, 2);
								tclankey = serverSvalue(string, 3);
							} else {
								tclan = Messages.getString("CarDefine.164"); //$NON-NLS-1$
								tclankey = Messages.getString("CarDefine.165"); //$NON-NLS-1$
							}
						}
					}
					socket.close();
					bufferedreader.close();
					printwriter.close();
				} catch (final Exception exception) {
					reco = -1;
				}
				if (reco == 0 || reco == 3 || reco > 10)
					action = 2;
				else
					action = 0;
				System.gc();
			}
			while (action == 2 && !Thread.currentThread().isInterrupted()) {
				/* empty */
			}
			if (action == 3) {
				final String[] strings = new String[700];
				nl = 0;
				String string = Messages.getString("CarDefine.166"); //$NON-NLS-1$
				try {
					final URL url = new URL(new StringBuilder()
							.append(Messages.getString("CarDefine.167")).append(gs.tnick.getText()) //$NON-NLS-1$
							.append(Messages.getString("CarDefine.168")).append((int) (Math.random() * 1000.0)).append(Messages.getString("CarDefine.169")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
					final DataInputStream datainputstream = new DataInputStream(url.openStream());
					while ((string = datainputstream.readLine()) != null && !Thread.currentThread().isInterrupted()) {
						string = new StringBuilder().append(Messages.getString("CarDefine.170")).append(string.trim()).toString(); //$NON-NLS-1$
						if (string.startsWith(Messages.getString("CarDefine.171"))) { //$NON-NLS-1$
							boolean bool = true;
							while (bool && nl < 700 && !Thread.currentThread().isInterrupted()) {
								strings[nl] = getSvalue(Messages.getString("CarDefine.172"), string, nl); //$NON-NLS-1$
								if (strings[nl].equals(Messages.getString("CarDefine.173"))) //$NON-NLS-1$
									bool = false;
								else
									nl++;
							}
						}
					}
					if (nl > 0)
						action = 4;
					else
						action = -1;
					datainputstream.close();
				} catch (final Exception exception) {
					final String string_43_ = new StringBuilder().append(Messages.getString("CarDefine.174")).append(exception).toString(); //$NON-NLS-1$
					if (string_43_.indexOf(Messages.getString("CarDefine.175")) != -1) //$NON-NLS-1$
						action = -1;
					else
						action = -2;
				}
				if (action == 4) {
					gs.mcars.setVisible(false);
					gs.mcars.removeAll();
					for (int i = 0; i < nl; i++)
						gs.mcars.add(gs.rd, strings[i]);
					if (lastcar.equals(Messages.getString("CarDefine.176"))) //$NON-NLS-1$
						gs.mcars.select(0);
					else {
						gs.mcars.select(lastcar);
						lastcar = Messages.getString("CarDefine.177"); //$NON-NLS-1$
					}
					for (int i = 0; i < 40; i++)
						include[i] = false;
					roundslot = 16;
					nlocars = 16;
				}
			}
			if (action == 4) {
				m.csky[0] = 170;
				m.csky[1] = 220;
				m.csky[2] = 255;
				m.cfade[0] = 255;
				m.cfade[1] = 220;
				m.cfade[2] = 220;
				m.snap[0] = 0;
				m.snap[1] = 0;
				m.snap[2] = 0;
				if (loadonlinecar(gs.mcars.getSelectedItem(), roundslot) == roundslot) {
					inslot = roundslot;
					roundslot++;
					if (roundslot == 36)
						roundslot = 16;
					if (nlocars < 36)
						nlocars++;
					lastload = 2;
					action = 5;
				} else {
					if (lastload == 2)
						lastload = 0;
					action = -1;
				}
				System.gc();
			}
			if (action == 6) {
				int i = -1;
				try {
					if (ac != -1)
						acname = names[ac];
					final Socket socket = new Socket(Messages.getString("CarDefine.178"), 7061); //$NON-NLS-1$
					final BufferedReader bufferedreader = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
					printwriter.println(new StringBuilder().append(Messages.getString("CarDefine.179")).append(gs.tnick.getText()).append(Messages.getString("CarDefine.180")) //$NON-NLS-1$ //$NON-NLS-2$
							.append(gs.tpass.getText()).append(Messages.getString("CarDefine.181")).append(acname).append(Messages.getString("CarDefine.182")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
					final String string = bufferedreader.readLine();
					if (string != null)
						i = servervalue(string, 0);
					socket.close();
					bufferedreader.close();
					printwriter.close();
				} catch (final Exception exception) {
					i = -1;
				}
				if (i == 0) {
					if (lastload == 2) {
						lastload = -2;
						lastcar = gs.mcars.getSelectedItem();
					}
					action = 7;
				}
				if (i == 3)
					action = -7;
				if (i == 4)
					action = -8;
				if (action == 6)
					action = -9;
				System.gc();
			}
			if (action == 11) {
				nl = 0;
				String string = Messages.getString("CarDefine.183"); //$NON-NLS-1$
				try {
					String string_44_ = Messages.getString("CarDefine.184"); //$NON-NLS-1$
					if (loadlist == 1)
						string_44_ = Messages.getString("CarDefine.185"); //$NON-NLS-1$
					if (loadlist == 2)
						string_44_ = Messages.getString("CarDefine.186"); //$NON-NLS-1$
					if (loadlist == 3)
						string_44_ = Messages.getString("CarDefine.187"); //$NON-NLS-1$
					if (loadlist == 4)
						string_44_ = Messages.getString("CarDefine.188"); //$NON-NLS-1$
					if (loadlist == 5)
						string_44_ = Messages.getString("CarDefine.189"); //$NON-NLS-1$
					if (loadlist == 6)
						string_44_ = Messages.getString("CarDefine.190"); //$NON-NLS-1$
					if (loadlist == 7)
						string_44_ = Messages.getString("CarDefine.191"); //$NON-NLS-1$
					if (loadlist == 8)
						string_44_ = Messages.getString("CarDefine.192"); //$NON-NLS-1$
					if (loadlist == 9)
						string_44_ = Messages.getString("CarDefine.193"); //$NON-NLS-1$
					if (loadlist == 10)
						string_44_ = Messages.getString("CarDefine.194"); //$NON-NLS-1$
					if (loadlist == 11)
						string_44_ = Messages.getString("CarDefine.195"); //$NON-NLS-1$
					if (loadlist == 12)
						string_44_ = Messages.getString("CarDefine.196"); //$NON-NLS-1$
					if (loadlist == 13)
						string_44_ = Messages.getString("CarDefine.197"); //$NON-NLS-1$
					if (loadlist == 14)
						string_44_ = Messages.getString("CarDefine.198"); //$NON-NLS-1$
					if (loadlist == 15)
						string_44_ = Messages.getString("CarDefine.199"); //$NON-NLS-1$
					if (loadlist == 16)
						string_44_ = Messages.getString("CarDefine.200"); //$NON-NLS-1$
					if (loadlist == 17)
						string_44_ = Messages.getString("CarDefine.201"); //$NON-NLS-1$
					if (loadlist == 18)
						string_44_ = Messages.getString("CarDefine.202"); //$NON-NLS-1$
					if (loadlist == 19)
						string_44_ = Messages.getString("CarDefine.203"); //$NON-NLS-1$
					if (loadlist == 20)
						string_44_ = Messages.getString("CarDefine.204"); //$NON-NLS-1$
					if (loadlist == 21)
						string_44_ = Messages.getString("CarDefine.205"); //$NON-NLS-1$
					if (loadlist == 22)
						string_44_ = Messages.getString("CarDefine.206"); //$NON-NLS-1$
					if (loadlist == 23)
						string_44_ = Messages.getString("CarDefine.207"); //$NON-NLS-1$
					if (loadlist == 24)
						string_44_ = Messages.getString("CarDefine.208"); //$NON-NLS-1$
					final URL url = new URL(
							new StringBuilder().append(Messages.getString("CarDefine.209")) //$NON-NLS-1$
									.append(string_44_).append(Messages.getString("CarDefine.210")).toString()); //$NON-NLS-1$
					final DataInputStream datainputstream = new DataInputStream(url.openStream());
					while ((string = datainputstream.readLine()) != null && !Thread.currentThread().isInterrupted()) {
						string = new StringBuilder().append(Messages.getString("CarDefine.211")).append(string.trim()).toString(); //$NON-NLS-1$
						if (string.startsWith(Messages.getString("CarDefine.212"))) { //$NON-NLS-1$
							boolean bool = true;
							while (bool && nl < 20 && !Thread.currentThread().isInterrupted()) {
								loadnames[nl] = getSvalue(Messages.getString("CarDefine.213"), string, nl); //$NON-NLS-1$
								if (loadnames[nl].equals(Messages.getString("CarDefine.214"))) //$NON-NLS-1$
									bool = false;
								else
									nl++;
							}
						}
						if (string.startsWith(Messages.getString("CarDefine.215"))) //$NON-NLS-1$
							for (int i = 0; i < nl; i++)
								adds[i] = getvalue(Messages.getString("CarDefine.216"), string, i); //$NON-NLS-1$
					}
					if (nl > 0)
						action = 12;
					else
						action = -1;
					datainputstream.close();
				} catch (final Exception exception) {
					action = -1;
				}
				System.gc();
			}
			if (action == 12) {
				m.csky[0] = 170;
				m.csky[1] = 220;
				m.csky[2] = 255;
				m.cfade[0] = 255;
				m.cfade[1] = 220;
				m.cfade[2] = 220;
				m.snap[0] = 0;
				m.snap[1] = 0;
				m.snap[2] = 0;
				xnlocars = 36;
				final int i = nl;
				for (nl = 0; nl < i; nl++)
					if (xnlocars < 56 && loadonlinecar(loadnames[nl], xnlocars) == xnlocars)
						xnlocars++;
				nl = 0;
				if (xnlocars > 36)
					action = 13;
				else
					action = -1;
				System.gc();
			}
			if (action == 101) {
				nl = 0;
				String string = Messages.getString("CarDefine.217"); //$NON-NLS-1$
				try {
					final URL url = new URL(new StringBuilder()
							.append(Messages.getString("CarDefine.218")).append(viewname) //$NON-NLS-1$
							.append(Messages.getString("CarDefine.219")).append((int) (Math.random() * 1000.0)).append(Messages.getString("CarDefine.220")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
					final DataInputStream datainputstream = new DataInputStream(url.openStream());
					while ((string = datainputstream.readLine()) != null && !Thread.currentThread().isInterrupted()) {
						string = new StringBuilder().append(Messages.getString("CarDefine.221")).append(string.trim()).toString(); //$NON-NLS-1$
						if (string.startsWith(Messages.getString("CarDefine.222"))) { //$NON-NLS-1$
							boolean bool = true;
							while (bool && nl < 20 && !Thread.currentThread().isInterrupted()) {
								loadnames[nl] = getSvalue(Messages.getString("CarDefine.223"), string, nl); //$NON-NLS-1$
								if (loadnames[nl].equals(Messages.getString("CarDefine.224"))) //$NON-NLS-1$
									bool = false;
								else
									nl++;
							}
						}
					}
					if (nl > 0)
						action = 102;
					else
						action = -2;
					datainputstream.close();
				} catch (final Exception exception) {
					final String string_45_ = new StringBuilder().append(Messages.getString("CarDefine.225")).append(exception).toString(); //$NON-NLS-1$
					if (string_45_.indexOf(Messages.getString("CarDefine.226")) != -1) //$NON-NLS-1$
						action = -2;
					else
						action = -1;
				}
				System.gc();
			}
			if (action == 102) {
				m.csky[0] = 170;
				m.csky[1] = 220;
				m.csky[2] = 255;
				m.cfade[0] = 255;
				m.cfade[1] = 220;
				m.cfade[2] = 220;
				m.snap[0] = 0;
				m.snap[1] = 0;
				m.snap[2] = 0;
				for (int i = 0; i < 40; i++)
					include[i] = false;
				xnlocars = 36;
				final int i = nl;
				for (nl = 0; nl < i; nl++)
					if (xnlocars < 56 && loadonlinecar(loadnames[nl], xnlocars) == xnlocars)
						xnlocars++;
				nl = 0;
				if (xnlocars > 36)
					action = 103;
				else
					action = -1;
				System.gc();
			}
			actionloader = null;
		}
		if (Thread.currentThread() == carloader) {
			while (nl > 0 && !Thread.currentThread().isInterrupted()) {
				int i = 0;
				for (int i_46_ = 16; i_46_ < 56; i_46_++)
					if (loadnames[nl - 1].equals(names[i_46_]))
						i = -1;
				if (fails.indexOf(
						new StringBuilder().append(Messages.getString("CarDefine.227")).append(loadnames[nl - 1]).append(Messages.getString("CarDefine.228")).toString()) != -1) //$NON-NLS-1$ //$NON-NLS-2$
					i = -1;
				if (i != -1) {
					int i_47_ = lcardate[0];
					int i_48_ = 36;
					if (haltload > 0) {
						i_48_ = 36 + haltload;
						i_47_ = lcardate[haltload];
					}
					i = i_48_;
					for (int i_49_ = i_48_; i_49_ < 56; i_49_++)
						if (lcardate[i_49_ - 36] < i_47_) {
							i_47_ = lcardate[i_49_ - 36];
							i = i_49_;
						}
					onloadingcar = i - 35;
					if (loadonlinecar(loadnames[nl - 1], i) == -1) {
						final StringBuilder stringbuilder = new StringBuilder();
						final CarDefine cardefine_50_ = this;
						cardefine_50_.fails = stringbuilder.append(cardefine_50_.fails).append(Messages.getString("CarDefine.229")) //$NON-NLS-1$
								.append(loadnames[nl - 1]).append(Messages.getString("CarDefine.230")).toString(); //$NON-NLS-1$
					} else
						lcardate[i - 36]++;
					onloadingcar = 0;
				}
				nl--;
				try {
					if (carloader != null) {
						/* empty */
					}
					Thread.sleep(20L);
				} catch (final InterruptedException interruptedexception) {
					/* empty */
				}
			}
			carlon = false;
			carloader = null;
		}
		if (Thread.currentThread() == stageaction) {
			if (staction == 1) {
				int i = -1;
				try {
					final Socket socket = new Socket(Messages.getString("CarDefine.231"), 7061); //$NON-NLS-1$
					final BufferedReader bufferedreader = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
					printwriter.println(new StringBuilder().append(Messages.getString("CarDefine.232")).append(gs.tnick.getText()).append(Messages.getString("CarDefine.233")) //$NON-NLS-1$ //$NON-NLS-2$
							.append(gs.tpass.getText()).append(Messages.getString("CarDefine.234")).append(onstage).append(Messages.getString("CarDefine.235")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
					final String string = bufferedreader.readLine();
					if (string != null)
						i = servervalue(string, 0);
					socket.close();
					bufferedreader.close();
					printwriter.close();
				} catch (final Exception exception) {
					i = -1;
				}
				if (i == 0) {
					try {
						gs.mstgs.remove(onstage);
					} catch (final Exception exception) {
						/* empty */
					}
					gs.mstgs.select(0);
					staction = 0;
				} else
					staction = -1;
			}
			if (staction == 4) {
				reco = -1;
				try {
					final Socket socket = new Socket(Messages.getString("CarDefine.236"), 7061); //$NON-NLS-1$
					final BufferedReader bufferedreader = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
					printwriter.println(new StringBuilder().append(Messages.getString("CarDefine.237")).append(gs.tnick.getText()).append(Messages.getString("CarDefine.238")) //$NON-NLS-1$ //$NON-NLS-2$
							.append(gs.tpass.getText()).append(Messages.getString("CarDefine.239")).toString()); //$NON-NLS-1$
					final String string = bufferedreader.readLine();
					if (string != null) {
						reco = servervalue(string, 0);
						if (reco == 0 || reco == 3 || reco > 10) {
							tnickey = serverSvalue(string, 1);
							if (reco != -167) {
								tclan = serverSvalue(string, 2);
								tclankey = serverSvalue(string, 3);
							} else {
								tclan = Messages.getString("CarDefine.240"); //$NON-NLS-1$
								tclankey = Messages.getString("CarDefine.241"); //$NON-NLS-1$
							}
						}
					}
					socket.close();
					bufferedreader.close();
					printwriter.close();
				} catch (final Exception exception) {
					reco = -1;
				}
				if (reco == 0 || reco == 3 || reco > 10)
					staction = 5;
				else
					staction = 3;
				System.gc();
				while (staction == 5 && !Thread.currentThread().isInterrupted()) {
					/* empty */
				}
			}
			if (staction == 2) {
				int i = -1;
				if (msloaded == 1)
					for (int i_51_ = 1; i_51_ < gs.mstgs.getItemCount(); i_51_++)
						if (gs.mstgs.getItem(i_51_).equals(onstage))
							i = 3;
				if (i == -1)
					try {
						final Socket socket = new Socket(Messages.getString("CarDefine.242"), 7061); //$NON-NLS-1$
						final BufferedReader bufferedreader = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
						printwriter.println(new StringBuilder().append(Messages.getString("CarDefine.243")).append(gs.tnick.getText()).append(Messages.getString("CarDefine.244")) //$NON-NLS-1$ //$NON-NLS-2$
								.append(gs.tpass.getText()).append(Messages.getString("CarDefine.245")).append(onstage).append(Messages.getString("CarDefine.246")).toString()); //$NON-NLS-1$ //$NON-NLS-2$
						final String string = bufferedreader.readLine();
						if (string != null)
							i = servervalue(string, 0);
						socket.close();
						bufferedreader.close();
						printwriter.close();
					} catch (final Exception exception) {
						i = -1;
					}
				staction = -1;
				if (i == 0) {
					staction = 0;
					if (msloaded == 1)
						gs.mstgs.addstg(onstage);
				}
				if (i == 3)
					staction = -2;
				if (i == 4)
					staction = -3;
			}
			stageaction = null;
		}
	}

	public String serverSvalue(final String string, final int i) {
		String string_37_ = Messages.getString("CarDefine.247"); //$NON-NLS-1$
		try {
			int i_38_ = 0;
			int i_39_ = 0;
			int i_40_ = 0;
			String string_41_ = Messages.getString("CarDefine.248"); //$NON-NLS-1$
			String string_42_ = Messages.getString("CarDefine.249"); //$NON-NLS-1$
			for (/**/; i_38_ < string.length() && i_40_ != 2; i_38_++) {
				string_41_ = new StringBuilder().append(Messages.getString("CarDefine.250")).append(string.charAt(i_38_)).toString(); //$NON-NLS-1$
				if (string_41_.equals(Messages.getString("CarDefine.251"))) { //$NON-NLS-1$
					i_39_++;
					if (i_40_ == 1 || i_39_ > i)
						i_40_ = 2;
				} else if (i_39_ == i) {
					string_42_ = new StringBuilder().append(string_42_).append(string_41_).toString();
					i_40_ = 1;
				}
			}
			string_37_ = string_42_;
		} catch (final Exception exception) {
			/* empty */
		}
		return string_37_;
	}

	public int servervalue(final String string, final int i) {
		int i_31_ = -1;
		try {
			int i_32_ = 0;
			int i_33_ = 0;
			int i_34_ = 0;
			String string_35_ = Messages.getString("CarDefine.252"); //$NON-NLS-1$
			String string_36_ = Messages.getString("CarDefine.253"); //$NON-NLS-1$
			for (/**/; i_32_ < string.length() && i_34_ != 2; i_32_++) {
				string_35_ = new StringBuilder().append(Messages.getString("CarDefine.254")).append(string.charAt(i_32_)).toString(); //$NON-NLS-1$
				if (string_35_.equals(Messages.getString("CarDefine.255"))) { //$NON-NLS-1$
					i_33_++;
					if (i_34_ == 1 || i_33_ > i)
						i_34_ = 2;
				} else if (i_33_ == i) {
					string_36_ = new StringBuilder().append(string_36_).append(string_35_).toString();
					i_34_ = 1;
				}
			}
			if (string_36_.equals(Messages.getString("CarDefine.256"))) //$NON-NLS-1$
				string_36_ = Messages.getString("CarDefine.257"); //$NON-NLS-1$
			i_31_ = Integer.valueOf(string_36_).intValue();
		} catch (final Exception exception) {
			/* empty */
		}
		return i_31_;
	}

	public void sparkactionloader() {
		actionloader = new Thread(this);
		actionloader.start();
	}

	public void sparkcarloader() {
		if (!carlon) {
			carloader = new Thread(this);
			carloader.start();
			carlon = true;
		}
	}

	public void sparkstageaction() {
		stageaction = new Thread(this);
		stageaction.start();
	}

	public void stopallnow() {
		staction = 0;
		action = 0;
		if (carloader != null) {
			// carloader.stop();
			carloader.interrupt();
			carloader = null;
		}
		if (actionloader != null) {
			// actionloader.stop();
			actionloader.interrupt();
			actionloader = null;
		}
		if (stageaction != null) {
			// stageaction.stop();
			stageaction.interrupt();
			stageaction = null;
		}
	}
}
