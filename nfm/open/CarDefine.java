package nfm.open;/* nfm.open.CarDefine - Decompiled by JODE
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

public class CarDefine implements Runnable
{
    Trackers t;
    GameSparker gs;
    ContO[] bco;
    Medium m;
    Thread carloader;
    Thread actionloader;
    Thread stageaction;
    int[][] swits
    = { { 50, 185, 282 }, { 100, 200, 310 }, { 60, 180, 275 },
        { 76, 195, 298 }, { 70, 170, 275 }, { 70, 202, 293 },
        { 60, 170, 289 }, { 70, 206, 291 }, { 90, 210, 295 },
        { 90, 190, 276 }, { 70, 200, 295 }, { 50, 160, 270 },
        { 90, 200, 305 }, { 50, 130, 210 }, { 80, 200, 300 },
        { 70, 210, 290 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
        { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
        { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
        { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
        { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
        { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
        { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
        { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
        { 0, 0, 0 }, { 0, 0, 0 } };
    float[][] acelf
    = { { 11.0F, 5.0F, 3.0F }, { 14.0F, 7.0F, 5.0F },
        { 10.0F, 5.0F, 3.5F }, { 11.0F, 6.0F, 3.5F },
        { 10.0F, 5.0F, 3.5F }, { 12.0F, 6.0F, 3.0F }, { 7.0F, 9.0F, 4.0F },
        { 11.0F, 5.0F, 3.0F }, { 12.0F, 7.0F, 4.0F },
        { 12.0F, 7.0F, 3.5F }, { 11.5F, 6.5F, 3.5F }, { 9.0F, 5.0F, 3.0F },
        { 13.0F, 7.0F, 4.5F }, { 7.5F, 3.5F, 3.0F }, { 11.0F, 7.5F, 4.0F },
        { 12.0F, 6.0F, 3.5F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F },
        { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F } };
    int[] handb = { 7, 10, 7, 15, 12, 8, 9, 10, 5, 7, 8, 10, 8, 12, 7, 7, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    float[] airs
    = { 1.0F, 1.2F, 0.95F, 1.0F, 2.2F, 1.0F, 0.9F, 0.8F, 1.0F, 0.9F, 1.15F,
        0.8F, 1.0F, 0.3F, 1.3F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F };
    int[] airc
    = { 70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] turn = { 6, 9, 5, 7, 8, 7, 5, 5, 9, 7, 7, 4, 6, 5, 7, 6, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    float[] grip
    = { 20.0F, 27.0F, 18.0F, 22.0F, 19.0F, 20.0F, 25.0F, 20.0F, 19.0F,
        24.0F, 22.5F, 25.0F, 30.0F, 27.0F, 25.0F, 27.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F };
    float[] bounce
    = { 1.2F, 1.05F, 1.3F, 1.15F, 1.3F, 1.2F, 1.15F, 1.1F, 1.2F, 1.1F,
        1.15F, 0.8F, 1.05F, 0.8F, 1.1F, 1.15F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F };
    float[] simag
    = { 0.9F, 0.85F, 1.05F, 0.9F, 0.85F, 0.9F, 1.05F, 0.9F, 1.0F, 1.05F,
        0.9F, 1.1F, 0.9F, 1.3F, 0.9F, 1.15F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F };
    float[] moment
    = { 1.3F, 0.75F, 1.4F, 1.2F, 1.1F, 1.38F, 1.43F, 1.48F, 1.35F, 1.7F,
        1.42F, 2.0F, 1.26F, 3.0F, 1.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F };
    float[] comprad
    = { 0.5F, 0.4F, 0.8F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5F, 0.5F, 0.8F, 0.5F,
        1.5F, 0.5F, 0.8F, 0.5F, 0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F };
    int[] push = { 2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] revpush = { 2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 0, 0, 0,
              0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
              0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] lift = { 0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
           0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] revlift
    = { 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] powerloss = { 2500000, 2500000, 3500000, 2500000, 4000000, 2500000,
            3200000, 3200000, 2750000, 5500000, 2750000, 4500000,
            3500000, 16700000, 3000000, 5500000, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] flipy = { -50, -60, -92, -44, -60, -57, -54, -60, -77, -57, -82, -85,
            -28, -100, -63, -127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0 };
    int[] msquash
    = { 7, 4, 7, 2, 8, 4, 6, 4, 3, 8, 4, 10, 3, 20, 3, 8, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] clrad = { 3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000,
            15000, 4000, 7000, 10000, 15000, 5500, 5000, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    float[] dammult
    = { 0.75F, 0.8F, 0.45F, 0.8F, 0.42F, 0.7F, 0.72F, 0.6F, 0.58F, 0.41F,
        0.67F, 0.45F, 0.61F, 0.25F, 0.38F, 0.52F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F };
    int[] maxmag = { 7600, 4200, 7200, 6000, 6000, 15000, 17200, 17000, 18000,
             11000, 19000, 10700, 13000, 45000, 5800, 18000, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    float[] dishandle
    = { 0.65F, 0.6F, 0.55F, 0.77F, 0.62F, 0.9F, 0.6F, 0.72F, 0.45F, 0.8F,
        0.95F, 0.4F, 0.87F, 0.42F, 1.0F, 0.95F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F };
    float[] outdam
    = { 0.68F, 0.35F, 0.8F, 0.5F, 0.42F, 0.76F, 0.82F, 0.76F, 0.72F, 0.62F,
        0.79F, 0.95F, 0.77F, 1.0F, 0.85F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
        0.0F, 0.0F, 0.0F };
    int[] cclass = { 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
             0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    String[] names
    = { "Tornado Shark", "Formula 7", "Wow Caninaro", "La Vita Crab",
        "Nimi", "MAX Revenge", "Lead Oxide", "Kool Kat", "Drifter X",
        "Sword of Justice", "High Rider", "EL KING", "Mighty Eight",
        "M A S H E E N", "Radical One", "DR Monstaa", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
        "" };
    int[] enginsignature
    = { 0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int lastload = 0;
    int nlcars = 0;
    int nlocars = 0;
    int xnlocars = 0;
    boolean[] include = new boolean[40];
    String[] createdby = new String[40];
    int[] publish = new int[40];
    String[] loadnames = new String[20];
    int nl = 0;
    int action = 0;
    boolean carlon = false;
    int reco = -2;
    int[] lcardate
    = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int haltload = 0;
    int onloadingcar = 0;
    int ac = -1;
    String acname = "Radical One";
    String fails = "";
    String tnickey = "";
    String tclan = "";
    String tclankey = "";
    int loadlist = 0;
    int[] adds
    = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    String viewname = "";
    int staction = 0;
    String onstage = "";
    int inslot = -1;
    int roundslot = 0;
    String lastcar = "";
    int msloaded = 0;
    int[] top20adds = new int[20];

    public CarDefine(ContO[] contos, Medium medium, Trackers trackers,
             GameSparker gamesparker) {
    ((CarDefine) this).bco = contos;
    ((CarDefine) this).m = medium;
    ((CarDefine) this).t = trackers;
    ((CarDefine) this).gs = gamesparker;
    }

    public void loadstat(byte[] is, String string, int i, int i_0_, int i_1_,
             int i_2_) {
    ((CarDefine) this).names[i_2_] = string;
    boolean bool = false;
    boolean bool_3_ = false;
    String string_4_ = "";
    int[] is_5_ = { 128, 128, 128, 128, 128 };
    int i_6_ = 640;
    int[] is_7_ = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
    int[] is_8_ = { 50, 50, 50 };
    ((CarDefine) this).enginsignature[i_2_] = 0;
    float f = 0.0F;
    ((CarDefine) this).publish[i_2_ - 16] = 0;
    ((CarDefine) this).createdby[i_2_ - 16] = "Unkown User";
    try {
        DataInputStream datainputstream
        = new DataInputStream(new ByteArrayInputStream(is));
        while ((string_4_ = datainputstream.readLine()) != null) {
        string_4_ = string_4_.trim();
        if (string_4_.startsWith("stat(")) {
            try {
            i_6_ = 0;
            for (int i_9_ = 0; i_9_ < 5; i_9_++) {
                is_5_[i_9_] = getvalue("stat", string_4_, i_9_);
                if (is_5_[i_9_] > 200)
                is_5_[i_9_] = 200;
                if (is_5_[i_9_] < 16)
                is_5_[i_9_] = 16;
                i_6_ += is_5_[i_9_];
            }
            bool = true;
            } catch (Exception exception) {
            bool = false;
            }
        }
        if (string_4_.startsWith("physics(")) {
            try {
            for (int i_10_ = 0; i_10_ < 11; i_10_++) {
                is_7_[i_10_]
                = getvalue("physics", string_4_, i_10_);
                if (is_7_[i_10_] > 100)
                is_7_[i_10_] = 100;
                if (is_7_[i_10_] < 0)
                is_7_[i_10_] = 0;
            }
            for (int i_11_ = 0; i_11_ < 3; i_11_++) {
                is_8_[i_11_]
                = getvalue("physics", string_4_, i_11_ + 11);
                if (i_11_ != 0 && is_8_[i_11_] > 100)
                is_8_[i_11_] = 100;
                if (is_8_[i_11_] < 0)
                is_8_[i_11_] = 0;
            }
            ((CarDefine) this).enginsignature[i_2_]
                = getvalue("physics", string_4_, 14);
            if (((CarDefine) this).enginsignature[i_2_] > 4)
                ((CarDefine) this).enginsignature[i_2_] = 0;
            if (((CarDefine) this).enginsignature[i_2_] < 0)
                ((CarDefine) this).enginsignature[i_2_] = 0;
            f = (float) getvalue("physics", string_4_, 15);
            if (f > 0.0F)
                bool_3_ = true;
            } catch (Exception exception) {
            bool_3_ = false;
            }
        }
        if (string_4_.startsWith("handling(")) {
            try {
            int i_12_ = getvalue("handling", string_4_, 0);
            if (i_12_ > 200)
                i_12_ = 200;
            if (i_12_ < 50)
                i_12_ = 50;
            ((CarDefine) this).dishandle[i_2_]
                = (float) i_12_ / 200.0F;
            } catch (Exception exception) {
            /* empty */
            }
        }
        if (string_4_.startsWith("carmaker("))
            ((CarDefine) this).createdby[i_2_ - 16]
            = getSvalue("carmaker", string_4_, 0);
        if (string_4_.startsWith("publish("))
            ((CarDefine) this).publish[i_2_ - 16]
            = getvalue("publish", string_4_, 0);
        }
        datainputstream.close();
    } catch (Exception exception) {
        System.out.println(new StringBuilder().append
                   ("Error Loading Car Stat: ").append
                   (exception).toString());
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
        while (i_13_ != 0) {
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
        }
        i_6_ = 0;
        for (int i_15_ = 0; i_15_ < 5; i_15_++)
        i_6_ += is_5_[i_15_];
        if (i_6_ == 520)
        ((CarDefine) this).cclass[i_2_] = 0;
        if (i_6_ == 560)
        ((CarDefine) this).cclass[i_2_] = 1;
        if (i_6_ == 600)
        ((CarDefine) this).cclass[i_2_] = 2;
        if (i_6_ == 640)
        ((CarDefine) this).cclass[i_2_] = 3;
        if (i_6_ == 680)
        ((CarDefine) this).cclass[i_2_] = 4;
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
        f_18_ = (float) (is_5_[0] - 192) / 8.0F;
        }
        if (is_5_[0] == 192) {
        i_16_ = 12;
        i_17_ = 12;
        }
        if (is_5_[0] > 148 && is_5_[0] < 192) {
        i_16_ = 14;
        i_17_ = 12;
        f_18_ = (float) (is_5_[0] - 148) / 44.0F;
        }
        if (is_5_[0] == 148) {
        i_16_ = 14;
        i_17_ = 14;
        }
        if (is_5_[0] > 133 && is_5_[0] < 148) {
        i_16_ = 10;
        i_17_ = 14;
        f_18_ = (float) (is_5_[0] - 133) / 15.0F;
        }
        if (is_5_[0] == 133) {
        i_16_ = 10;
        i_17_ = 10;
        }
        if (is_5_[0] > 112 && is_5_[0] < 133) {
        i_16_ = 15;
        i_17_ = 10;
        f_18_ = (float) (is_5_[0] - 112) / 21.0F;
        }
        if (is_5_[0] == 112) {
        i_16_ = 15;
        i_17_ = 15;
        }
        if (is_5_[0] > 107 && is_5_[0] < 112) {
        i_16_ = 11;
        i_17_ = 15;
        f_18_ = (float) (is_5_[0] - 107) / 5.0F;
        }
        if (is_5_[0] == 107) {
        i_16_ = 11;
        i_17_ = 11;
        }
        if (is_5_[0] > 88 && is_5_[0] < 107) {
        i_16_ = 13;
        i_17_ = 11;
        f_18_ = (float) (is_5_[0] - 88) / 19.0F;
        }
        if (is_5_[0] == 88) {
        i_16_ = 13;
        i_17_ = 13;
        }
        if (is_5_[0] > 88) {
        ((CarDefine) this).swits[i_2_][0]
            = (int) (((float) (((CarDefine) this).swits[i_17_][0]
                       - ((CarDefine) this).swits[i_16_][0])
                  * f_18_)
                 + (float) ((CarDefine) this).swits[i_16_][0]);
        ((CarDefine) this).swits[i_2_][1]
            = (int) (((float) (((CarDefine) this).swits[i_17_][1]
                       - ((CarDefine) this).swits[i_16_][1])
                  * f_18_)
                 + (float) ((CarDefine) this).swits[i_16_][1]);
        ((CarDefine) this).swits[i_2_][2]
            = (int) (((float) (((CarDefine) this).swits[i_17_][2]
                       - ((CarDefine) this).swits[i_16_][2])
                  * f_18_)
                 + (float) ((CarDefine) this).swits[i_16_][2]);
        } else {
        f_18_ = (float) is_5_[0] / 88.0F;
        if ((double) f_18_ < 0.76)
            f_18_ = 0.76F;
        ((CarDefine) this).swits[i_2_][0] = (int) (50.0F * f_18_);
        ((CarDefine) this).swits[i_2_][1] = (int) (130.0F * f_18_);
        ((CarDefine) this).swits[i_2_][2] = (int) (210.0F * f_18_);
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
        f_18_ = (float) (is_5_[1] - 150) / 50.0F;
        }
        if (is_5_[1] == 150) {
        i_16_ = 14;
        i_17_ = 14;
        }
        if (is_5_[1] > 144 && is_5_[1] < 150) {
        i_16_ = 9;
        i_17_ = 14;
        f_18_ = (float) (is_5_[1] - 144) / 6.0F;
        }
        if (is_5_[1] == 144) {
        i_16_ = 9;
        i_17_ = 9;
        }
        if (is_5_[1] > 139 && is_5_[1] < 144) {
        i_16_ = 6;
        i_17_ = 9;
        f_18_ = (float) (is_5_[1] - 139) / 5.0F;
        }
        if (is_5_[1] == 139) {
        i_16_ = 6;
        i_17_ = 6;
        }
        if (is_5_[1] > 128 && is_5_[1] < 139) {
        i_16_ = 15;
        i_17_ = 6;
        f_18_ = (float) (is_5_[1] - 128) / 11.0F;
        }
        if (is_5_[1] == 128) {
        i_16_ = 15;
        i_17_ = 15;
        }
        if (is_5_[1] > 122 && is_5_[1] < 128) {
        i_16_ = 10;
        i_17_ = 15;
        f_18_ = (float) (is_5_[1] - 122) / 6.0F;
        }
        if (is_5_[1] == 122) {
        i_16_ = 10;
        i_17_ = 10;
        }
        if (is_5_[1] > 119 && is_5_[1] < 122) {
        i_16_ = 3;
        i_17_ = 10;
        f_18_ = (float) (is_5_[1] - 119) / 3.0F;
        }
        if (is_5_[1] == 119) {
        i_16_ = 3;
        i_17_ = 3;
        }
        if (is_5_[1] > 98 && is_5_[1] < 119) {
        i_16_ = 5;
        i_17_ = 3;
        f_18_ = (float) (is_5_[1] - 98) / 21.0F;
        }
        if (is_5_[1] == 98) {
        i_16_ = 5;
        i_17_ = 5;
        }
        if (is_5_[1] > 81 && is_5_[1] < 98) {
        i_16_ = 0;
        i_17_ = 5;
        f_18_ = (float) (is_5_[1] - 81) / 17.0F;
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
        ((CarDefine) this).acelf[i_2_][0]
        = ((((CarDefine) this).acelf[i_17_][0]
            - ((CarDefine) this).acelf[i_16_][0]) * f_18_
           + ((CarDefine) this).acelf[i_16_][0]);
        ((CarDefine) this).acelf[i_2_][1]
        = ((((CarDefine) this).acelf[i_17_][1]
            - ((CarDefine) this).acelf[i_16_][1]) * f_18_
           + ((CarDefine) this).acelf[i_16_][1]);
        ((CarDefine) this).acelf[i_2_][2]
        = ((((CarDefine) this).acelf[i_17_][2]
            - ((CarDefine) this).acelf[i_16_][2]) * f_18_
           + ((CarDefine) this).acelf[i_16_][2]);
        if (is_5_[1] <= 70 && is_5_[0] > 88) {
        ((CarDefine) this).acelf[i_2_][0] = 9.0F;
        ((CarDefine) this).acelf[i_2_][1] = 4.0F;
        ((CarDefine) this).acelf[i_2_][2] = 3.0F;
        }
        f_18_ = (float) (is_5_[2] - 88) / 109.0F;
        if (f_18_ > 1.0F)
        f_18_ = 1.0F;
        if ((double) f_18_ < -0.55)
        f_18_ = -0.55F;
        ((CarDefine) this).airs[i_2_]
        = 0.55F + 0.45F * f_18_ + 0.4F * ((float) is_7_[9] / 100.0F);
        if ((double) ((CarDefine) this).airs[i_2_] < 0.3)
        ((CarDefine) this).airs[i_2_] = 0.3F;
        ((CarDefine) this).airc[i_2_]
        = (int) (10.0F + 70.0F * f_18_
             + 30.0F * ((float) is_7_[10] / 100.0F));
        if (((CarDefine) this).airc[i_2_] < 0)
        ((CarDefine) this).airc[i_2_] = 0;
        int i_19_
        = (int) (670.0F
             - (float) (is_7_[9] + is_7_[10]) / 200.0F * 420.0F);
        if (is_5_[0] <= 88)
        i_19_ = (int) (1670.0F - ((float) (is_7_[9] + is_7_[10])
                      / 200.0F * 1420.0F));
        if (is_5_[2] > 190 && i_19_ < 300)
        i_19_ = 300;
        ((CarDefine) this).powerloss[i_2_] = i_19_ * 10000;
        ((CarDefine) this).moment[i_2_]
        = 0.7F + (float) (is_5_[3] - 16) / 184.0F * 1.0F;
        if (is_5_[0] < 110)
        ((CarDefine) this).moment[i_2_]
            = 0.75F + (float) (is_5_[3] - 16) / 184.0F * 1.25F;
        if (is_5_[3] == 200 && is_5_[4] == 200 && is_5_[0] <= 88)
        ((CarDefine) this).moment[i_2_] = 3.0F;
        float f_20_ = 0.9F + (float) (is_5_[4] - 90) * 0.01F;
        if ((double) f_20_ < 0.6)
        f_20_ = 0.6F;
        if (is_5_[4] == 200 && is_5_[0] <= 88)
        f_20_ = 3.0F;
        ((CarDefine) this).maxmag[i_2_] = (int) (f * f_20_);
        ((CarDefine) this).outdam[i_2_] = 0.35F + (f_20_ - 0.6F) * 0.5F;
        if ((double) ((CarDefine) this).outdam[i_2_] < 0.35)
        ((CarDefine) this).outdam[i_2_] = 0.35F;
        if (((CarDefine) this).outdam[i_2_] > 1.0F)
        ((CarDefine) this).outdam[i_2_] = 1.0F;
        ((CarDefine) this).clrad[i_2_]
        = (int) ((double) (is_8_[0] * is_8_[0]) * 1.5);
        if (((CarDefine) this).clrad[i_2_] < 1000)
        ((CarDefine) this).clrad[i_2_] = 1000;
        ((CarDefine) this).dammult[i_2_]
        = 0.3F + (float) is_8_[1] * 0.005F;
        ((CarDefine) this).msquash[i_2_]
        = (int) (2.0 + (double) (float) is_8_[2] / 7.6);
        ((CarDefine) this).flipy[i_2_] = i_0_;
        ((CarDefine) this).handb[i_2_]
        = (int) (7.0F + (float) is_7_[0] / 100.0F * 8.0F);
        ((CarDefine) this).turn[i_2_]
        = (int) (4.0F + (float) is_7_[1] / 100.0F * 6.0F);
        ((CarDefine) this).grip[i_2_]
        = 16.0F + (float) is_7_[2] / 100.0F * 14.0F;
        if (((CarDefine) this).grip[i_2_] < 21.0F) {
        ((CarDefine) this).swits[i_2_][0]
            += 40.0F * ((21.0F - ((CarDefine) this).grip[i_2_])
                / 5.0F);
        if (((CarDefine) this).swits[i_2_][0] > 100)
            ((CarDefine) this).swits[i_2_][0] = 100;
        }
        ((CarDefine) this).bounce[i_2_]
        = 0.8F + (float) is_7_[3] / 100.0F * 0.6F;
        if (is_7_[3] > 67) {
        ((CarDefine) this).airs[i_2_]
            *= 0.76F + (1.0F - (float) is_7_[3] / 100.0F) * 0.24F;
        ((CarDefine) this).airc[i_2_]
            *= 0.76F + (1.0F - (float) is_7_[3] / 100.0F) * 0.24F;
        }
        ((CarDefine) this).lift[i_2_]
        = (int) ((float) is_7_[5] * (float) is_7_[5] / 10000.0F
             * 30.0F);
        ((CarDefine) this).revlift[i_2_]
        = (int) ((float) is_7_[6] / 100.0F * 32.0F);
        ((CarDefine) this).push[i_2_]
        = (int) (2.0F
             + ((float) is_7_[7] / 100.0F * 2.0F
                * (float) ((30 - ((CarDefine) this).lift[i_2_])
                       / 30)));
        ((CarDefine) this).revpush[i_2_]
        = (int) (1.0F + (float) is_7_[8] / 100.0F * 2.0F);
        ((CarDefine) this).comprad[i_2_]
        = (float) i / 400.0F + (float) (is_5_[3] - 16) / 184.0F * 0.2F;
        if ((double) ((CarDefine) this).comprad[i_2_] < 0.4)
        ((CarDefine) this).comprad[i_2_] = 0.4F;
        ((CarDefine) this).simag[i_2_]
        = (float) (i_1_ - 17) * 0.0167F + 0.85F;
    } else
        ((CarDefine) this).names[i_2_] = "";
    }

    public int getvalue(String string, String string_21_, int i) {
    int i_22_ = 0;
    String string_23_ = "";
    for (int i_24_ = string.length() + 1; i_24_ < string_21_.length();
         i_24_++) {
        String string_25_ = new StringBuilder().append("").append
                    (string_21_.charAt(i_24_)).toString();
        if (string_25_.equals(",") || string_25_.equals(")")) {
        i_22_++;
        i_24_++;
        }
        if (i_22_ == i)
        string_23_ = new StringBuilder().append(string_23_).append
                 (string_21_.charAt(i_24_)).toString();
    }
    return Float.valueOf(string_23_).intValue();
    }

    public String getSvalue(String string, String string_26_, int i) {
    String string_27_ = "";
    int i_28_ = 0;
    for (int i_29_ = string.length() + 1;
         i_29_ < string_26_.length() && i_28_ <= i; i_29_++) {
        String string_30_ = new StringBuilder().append("").append
                    (string_26_.charAt(i_29_)).toString();
        if (string_30_.equals(",") || string_30_.equals(")"))
        i_28_++;
        else if (i_28_ == i)
        string_27_ = new StringBuilder().append(string_27_).append
                 (string_30_).toString();
    }
    return string_27_;
    }

    public int servervalue(String string, int i) {
    int i_31_ = -1;
    try {
        int i_32_ = 0;
        int i_33_ = 0;
        int i_34_ = 0;
        String string_35_ = "";
        String string_36_ = "";
        for (/**/; i_32_ < string.length() && i_34_ != 2; i_32_++) {
        string_35_ = new StringBuilder().append("").append
                 (string.charAt(i_32_)).toString();
        if (string_35_.equals("|")) {
            i_33_++;
            if (i_34_ == 1 || i_33_ > i)
            i_34_ = 2;
        } else if (i_33_ == i) {
            string_36_ = new StringBuilder().append(string_36_).append
                     (string_35_).toString();
            i_34_ = 1;
        }
        }
        if (string_36_.equals(""))
        string_36_ = "-1";
        i_31_ = Integer.valueOf(string_36_).intValue();
    } catch (Exception exception) {
        /* empty */
    }
    return i_31_;
    }

    public String serverSvalue(String string, int i) {
    String string_37_ = "";
    try {
        int i_38_ = 0;
        int i_39_ = 0;
        int i_40_ = 0;
        String string_41_ = "";
        String string_42_ = "";
        for (/**/; i_38_ < string.length() && i_40_ != 2; i_38_++) {
        string_41_ = new StringBuilder().append("").append
                 (string.charAt(i_38_)).toString();
        if (string_41_.equals("|")) {
            i_39_++;
            if (i_40_ == 1 || i_39_ > i)
            i_40_ = 2;
        } else if (i_39_ == i) {
            string_42_ = new StringBuilder().append(string_42_).append
                     (string_41_).toString();
            i_40_ = 1;
        }
        }
        string_37_ = string_42_;
    } catch (Exception exception) {
        /* empty */
    }
    return string_37_;
    }

    public void loadready() {
    ((Medium) ((CarDefine) this).m).csky[0] = 170;
    ((Medium) ((CarDefine) this).m).csky[1] = 220;
    ((Medium) ((CarDefine) this).m).csky[2] = 255;
    ((Medium) ((CarDefine) this).m).cfade[0] = 255;
    ((Medium) ((CarDefine) this).m).cfade[1] = 220;
    ((Medium) ((CarDefine) this).m).cfade[2] = 220;
    ((Medium) ((CarDefine) this).m).snap[0] = 0;
    ((Medium) ((CarDefine) this).m).snap[1] = 0;
    ((Medium) ((CarDefine) this).m).snap[2] = 0;
    ((CarDefine) this).fails = "";
    for (int i = 0; i < 20; i++)
        ((CarDefine) this).loadnames[i] = "";
    ((CarDefine) this).nl = 0;
    ((CarDefine) this).action = 0;
    }

    public void sparkactionloader() {
    ((CarDefine) this).actionloader = new Thread(this);
    ((CarDefine) this).actionloader.start();
    }

    public void sparkcarloader() {
    if (!((CarDefine) this).carlon) {
        ((CarDefine) this).carloader = new Thread(this);
        ((CarDefine) this).carloader.start();
        ((CarDefine) this).carlon = true;
    }
    }

    public void sparkstageaction() {
    ((CarDefine) this).stageaction = new Thread(this);
    ((CarDefine) this).stageaction.start();
    }

    public void stopallnow() {
    ((CarDefine) this).staction = 0;
    ((CarDefine) this).action = 0;
    if (((CarDefine) this).carloader != null) {
        ((CarDefine) this).carloader.stop();
        ((CarDefine) this).carloader = null;
    }
    if (((CarDefine) this).actionloader != null) {
        ((CarDefine) this).actionloader.stop();
        ((CarDefine) this).actionloader = null;
    }
    if (((CarDefine) this).stageaction != null) {
        ((CarDefine) this).stageaction.stop();
        ((CarDefine) this).stageaction = null;
    }
    }

    public void run() {
    if (Thread.currentThread() == ((CarDefine) this).actionloader) {
        if (((CarDefine) this).action == 10) {
        int i = -1;
        try {
            Socket socket
            = new Socket("multiplayer.needformadness.com", 7061);
            BufferedReader bufferedreader
            = (new BufferedReader
               (new InputStreamReader(socket.getInputStream())));
            PrintWriter printwriter
            = new PrintWriter(socket.getOutputStream(), true);
            printwriter.println
            (new StringBuilder().append("9|").append
                 (((GameSparker) ((CarDefine) this).gs).tnick
                  .getText())
                 .append
                 ("|").append
                 (((GameSparker) ((CarDefine) this).gs).tpass
                  .getText())
                 .append
                 ("|").append
                 (((CarDefine) this).names[((CarDefine) this).ac])
                 .append
                 ("|").toString());
            String string = bufferedreader.readLine();
            if (string != null)
            i = servervalue(string, 0);
            socket.close();
            bufferedreader.close();
            printwriter.close();
        } catch (Exception exception) {
            i = -1;
        }
        if (i == 0)
            ((CarDefine) this).action = 3;
        else
            ((CarDefine) this).action = -10;
        System.gc();
        }
        if (((CarDefine) this).action == 1) {
        ((CarDefine) this).reco = -1;
        try {
            Socket socket
            = new Socket("multiplayer.needformadness.com", 7061);
            BufferedReader bufferedreader
            = (new BufferedReader
               (new InputStreamReader(socket.getInputStream())));
            PrintWriter printwriter
            = new PrintWriter(socket.getOutputStream(), true);
            printwriter.println(new StringBuilder().append("1|").append
                        (((GameSparker)
                          ((CarDefine) this).gs)
                         .tnick.getText())
                        .append
                        ("|").append
                        (((GameSparker)
                          ((CarDefine) this).gs)
                         .tpass.getText())
                        .append
                        ("|").toString());
            String string = bufferedreader.readLine();
            if (string != null) {
            ((CarDefine) this).reco = servervalue(string, 0);
            if (((CarDefine) this).reco == 0
                || ((CarDefine) this).reco == 3
                || ((CarDefine) this).reco > 10) {
                ((CarDefine) this).tnickey
                = serverSvalue(string, 1);
                if (((CarDefine) this).reco != -167) {
                ((CarDefine) this).tclan
                    = serverSvalue(string, 2);
                ((CarDefine) this).tclankey
                    = serverSvalue(string, 3);
                } else {
                ((CarDefine) this).tclan = "";
                ((CarDefine) this).tclankey = "";
                }
            }
            }
            socket.close();
            bufferedreader.close();
            printwriter.close();
        } catch (Exception exception) {
            ((CarDefine) this).reco = -1;
        }
        if (((CarDefine) this).reco == 0
            || ((CarDefine) this).reco == 3
            || ((CarDefine) this).reco > 10)
            ((CarDefine) this).action = 2;
        else
            ((CarDefine) this).action = 0;
        System.gc();
        }
        while (((CarDefine) this).action == 2) {
        /* empty */
        }
        if (((CarDefine) this).action == 3) {
        String[] strings = new String[700];
        ((CarDefine) this).nl = 0;
        String string = "";
        try {
            URL url
            = (new URL
               (new StringBuilder().append
                ("http://multiplayer.needformadness.com/cars/lists/")
                .append
                (((GameSparker) ((CarDefine) this).gs)
                     .tnick.getText())
                .append
                (".txt?reqlo=").append
                ((int) (Math.random() * 1000.0)).append
                ("").toString()));
            DataInputStream datainputstream
            = new DataInputStream(url.openStream());
            while ((string = datainputstream.readLine()) != null) {
            string = new StringBuilder().append("").append
                     (string.trim()).toString();
            if (string.startsWith("mycars")) {
                boolean bool = true;
                while (bool && ((CarDefine) this).nl < 700) {
                strings[((CarDefine) this).nl]
                    = getSvalue("mycars", string,
                        ((CarDefine) this).nl);
                if (strings[((CarDefine) this).nl].equals(""))
                    bool = false;
                else
                    ((CarDefine) this).nl++;
                }
            }
            }
            if (((CarDefine) this).nl > 0)
            ((CarDefine) this).action = 4;
            else
            ((CarDefine) this).action = -1;
            datainputstream.close();
        } catch (Exception exception) {
            String string_43_ = new StringBuilder().append("").append
                        (exception).toString();
            if (string_43_.indexOf("FileNotFound") != -1)
            ((CarDefine) this).action = -1;
            else
            ((CarDefine) this).action = -2;
        }
        if (((CarDefine) this).action == 4) {
            ((GameSparker) ((CarDefine) this).gs).mcars.hide();
            ((GameSparker) ((CarDefine) this).gs).mcars.removeAll();
            for (int i = 0; i < ((CarDefine) this).nl; i++)
            ((GameSparker) ((CarDefine) this).gs).mcars.add
                (((GameSparker) ((CarDefine) this).gs).rd,
                 strings[i]);
            if (((CarDefine) this).lastcar.equals(""))
            ((GameSparker) ((CarDefine) this).gs).mcars.select(0);
            else {
            ((GameSparker) ((CarDefine) this).gs).mcars
                .select(((CarDefine) this).lastcar);
            ((CarDefine) this).lastcar = "";
            }
            for (int i = 0; i < 40; i++)
            ((CarDefine) this).include[i] = false;
            ((CarDefine) this).roundslot = 16;
            ((CarDefine) this).nlocars = 16;
        }
        }
        if (((CarDefine) this).action == 4) {
        ((Medium) ((CarDefine) this).m).csky[0] = 170;
        ((Medium) ((CarDefine) this).m).csky[1] = 220;
        ((Medium) ((CarDefine) this).m).csky[2] = 255;
        ((Medium) ((CarDefine) this).m).cfade[0] = 255;
        ((Medium) ((CarDefine) this).m).cfade[1] = 220;
        ((Medium) ((CarDefine) this).m).cfade[2] = 220;
        ((Medium) ((CarDefine) this).m).snap[0] = 0;
        ((Medium) ((CarDefine) this).m).snap[1] = 0;
        ((Medium) ((CarDefine) this).m).snap[2] = 0;
        if (loadonlinecar(((GameSparker) ((CarDefine) this).gs)
                      .mcars.getSelectedItem(),
                  ((CarDefine) this).roundslot)
            == ((CarDefine) this).roundslot) {
            ((CarDefine) this).inslot = ((CarDefine) this).roundslot;
            ((CarDefine) this).roundslot++;
            if (((CarDefine) this).roundslot == 36)
            ((CarDefine) this).roundslot = 16;
            if (((CarDefine) this).nlocars < 36)
            ((CarDefine) this).nlocars++;
            ((CarDefine) this).lastload = 2;
            ((CarDefine) this).action = 5;
        } else {
            if (((CarDefine) this).lastload == 2)
            ((CarDefine) this).lastload = 0;
            ((CarDefine) this).action = -1;
        }
        System.gc();
        }
        if (((CarDefine) this).action == 6) {
        int i = -1;
        try {
            if (((CarDefine) this).ac != -1)
            ((CarDefine) this).acname
                = ((CarDefine) this).names[((CarDefine) this).ac];
            Socket socket
            = new Socket("multiplayer.needformadness.com", 7061);
            BufferedReader bufferedreader
            = (new BufferedReader
               (new InputStreamReader(socket.getInputStream())));
            PrintWriter printwriter
            = new PrintWriter(socket.getOutputStream(), true);
            printwriter.println(new StringBuilder().append("8|").append
                        (((GameSparker)
                          ((CarDefine) this).gs)
                         .tnick.getText())
                        .append
                        ("|").append
                        (((GameSparker)
                          ((CarDefine) this).gs)
                         .tpass.getText())
                        .append
                        ("|").append
                        (((CarDefine) this).acname).append
                        ("|").toString());
            String string = bufferedreader.readLine();
            if (string != null)
            i = servervalue(string, 0);
            socket.close();
            bufferedreader.close();
            printwriter.close();
        } catch (Exception exception) {
            i = -1;
        }
        if (i == 0) {
            if (((CarDefine) this).lastload == 2) {
            ((CarDefine) this).lastload = -2;
            ((CarDefine) this).lastcar
                = ((GameSparker) ((CarDefine) this).gs).mcars
                  .getSelectedItem();
            }
            ((CarDefine) this).action = 7;
        }
        if (i == 3)
            ((CarDefine) this).action = -7;
        if (i == 4)
            ((CarDefine) this).action = -8;
        if (((CarDefine) this).action == 6)
            ((CarDefine) this).action = -9;
        System.gc();
        }
        if (((CarDefine) this).action == 11) {
        ((CarDefine) this).nl = 0;
        String string = "";
        try {
            String string_44_ = "all";
            if (((CarDefine) this).loadlist == 1)
            string_44_ = "Wall";
            if (((CarDefine) this).loadlist == 2)
            string_44_ = "WA";
            if (((CarDefine) this).loadlist == 3)
            string_44_ = "WAB";
            if (((CarDefine) this).loadlist == 4)
            string_44_ = "WB";
            if (((CarDefine) this).loadlist == 5)
            string_44_ = "WBC";
            if (((CarDefine) this).loadlist == 6)
            string_44_ = "WC";
            if (((CarDefine) this).loadlist == 7)
            string_44_ = "Mall";
            if (((CarDefine) this).loadlist == 8)
            string_44_ = "MA";
            if (((CarDefine) this).loadlist == 9)
            string_44_ = "MAB";
            if (((CarDefine) this).loadlist == 10)
            string_44_ = "MB";
            if (((CarDefine) this).loadlist == 11)
            string_44_ = "MBC";
            if (((CarDefine) this).loadlist == 12)
            string_44_ = "MC";
            if (((CarDefine) this).loadlist == 13)
            string_44_ = "Sall";
            if (((CarDefine) this).loadlist == 14)
            string_44_ = "SA";
            if (((CarDefine) this).loadlist == 15)
            string_44_ = "SAB";
            if (((CarDefine) this).loadlist == 16)
            string_44_ = "SB";
            if (((CarDefine) this).loadlist == 17)
            string_44_ = "SBC";
            if (((CarDefine) this).loadlist == 18)
            string_44_ = "SC";
            if (((CarDefine) this).loadlist == 19)
            string_44_ = "Aall";
            if (((CarDefine) this).loadlist == 20)
            string_44_ = "AA";
            if (((CarDefine) this).loadlist == 21)
            string_44_ = "AAB";
            if (((CarDefine) this).loadlist == 22)
            string_44_ = "AB";
            if (((CarDefine) this).loadlist == 23)
            string_44_ = "ABC";
            if (((CarDefine) this).loadlist == 24)
            string_44_ = "AC";
            URL url
            = (new URL
               (new StringBuilder().append
                ("http://multiplayer.needformadness.com/cars/top20/")
                .append
                (string_44_).append
                (".txt").toString()));
            DataInputStream datainputstream
            = new DataInputStream(url.openStream());
            while ((string = datainputstream.readLine()) != null) {
            string = new StringBuilder().append("").append
                     (string.trim()).toString();
            if (string.startsWith("cars")) {
                boolean bool = true;
                while (bool && ((CarDefine) this).nl < 20) {
                ((CarDefine) this).loadnames
                    [((CarDefine) this).nl]
                    = getSvalue("cars", string,
                        ((CarDefine) this).nl);
                if (((CarDefine) this).loadnames
                    [((CarDefine) this).nl].equals(""))
                    bool = false;
                else
                    ((CarDefine) this).nl++;
                }
            }
            if (string.startsWith("adds")) {
                for (int i = 0; i < ((CarDefine) this).nl; i++)
                ((CarDefine) this).adds[i]
                    = getvalue("adds", string, i);
            }
            }
            if (((CarDefine) this).nl > 0)
            ((CarDefine) this).action = 12;
            else
            ((CarDefine) this).action = -1;
            datainputstream.close();
        } catch (Exception exception) {
            ((CarDefine) this).action = -1;
        }
        System.gc();
        }
        if (((CarDefine) this).action == 12) {
        ((Medium) ((CarDefine) this).m).csky[0] = 170;
        ((Medium) ((CarDefine) this).m).csky[1] = 220;
        ((Medium) ((CarDefine) this).m).csky[2] = 255;
        ((Medium) ((CarDefine) this).m).cfade[0] = 255;
        ((Medium) ((CarDefine) this).m).cfade[1] = 220;
        ((Medium) ((CarDefine) this).m).cfade[2] = 220;
        ((Medium) ((CarDefine) this).m).snap[0] = 0;
        ((Medium) ((CarDefine) this).m).snap[1] = 0;
        ((Medium) ((CarDefine) this).m).snap[2] = 0;
        ((CarDefine) this).xnlocars = 36;
        int i = ((CarDefine) this).nl;
        for (((CarDefine) this).nl = 0; ((CarDefine) this).nl < i;
             ((CarDefine) this).nl++) {
            if (((CarDefine) this).xnlocars < 56
            && (loadonlinecar((((CarDefine) this).loadnames
                       [((CarDefine) this).nl]),
                      ((CarDefine) this).xnlocars)
                == ((CarDefine) this).xnlocars))
            ((CarDefine) this).xnlocars++;
        }
        ((CarDefine) this).nl = 0;
        if (((CarDefine) this).xnlocars > 36)
            ((CarDefine) this).action = 13;
        else
            ((CarDefine) this).action = -1;
        System.gc();
        }
        if (((CarDefine) this).action == 101) {
        ((CarDefine) this).nl = 0;
        String string = "";
        try {
            URL url
            = (new URL
               (new StringBuilder().append
                ("http://multiplayer.needformadness.com/cars/lists/")
                .append
                (((CarDefine) this).viewname).append
                (".txt?reqlo=").append
                ((int) (Math.random() * 1000.0)).append
                ("").toString()));
            DataInputStream datainputstream
            = new DataInputStream(url.openStream());
            while ((string = datainputstream.readLine()) != null) {
            string = new StringBuilder().append("").append
                     (string.trim()).toString();
            if (string.startsWith("mycars")) {
                boolean bool = true;
                while (bool && ((CarDefine) this).nl < 20) {
                ((CarDefine) this).loadnames
                    [((CarDefine) this).nl]
                    = getSvalue("mycars", string,
                        ((CarDefine) this).nl);
                if (((CarDefine) this).loadnames
                    [((CarDefine) this).nl].equals(""))
                    bool = false;
                else
                    ((CarDefine) this).nl++;
                }
            }
            }
            if (((CarDefine) this).nl > 0)
            ((CarDefine) this).action = 102;
            else
            ((CarDefine) this).action = -2;
            datainputstream.close();
        } catch (Exception exception) {
            String string_45_ = new StringBuilder().append("").append
                        (exception).toString();
            if (string_45_.indexOf("FileNotFound") != -1)
            ((CarDefine) this).action = -2;
            else
            ((CarDefine) this).action = -1;
        }
        System.gc();
        }
        if (((CarDefine) this).action == 102) {
        ((Medium) ((CarDefine) this).m).csky[0] = 170;
        ((Medium) ((CarDefine) this).m).csky[1] = 220;
        ((Medium) ((CarDefine) this).m).csky[2] = 255;
        ((Medium) ((CarDefine) this).m).cfade[0] = 255;
        ((Medium) ((CarDefine) this).m).cfade[1] = 220;
        ((Medium) ((CarDefine) this).m).cfade[2] = 220;
        ((Medium) ((CarDefine) this).m).snap[0] = 0;
        ((Medium) ((CarDefine) this).m).snap[1] = 0;
        ((Medium) ((CarDefine) this).m).snap[2] = 0;
        for (int i = 0; i < 40; i++)
            ((CarDefine) this).include[i] = false;
        ((CarDefine) this).xnlocars = 36;
        int i = ((CarDefine) this).nl;
        for (((CarDefine) this).nl = 0; ((CarDefine) this).nl < i;
             ((CarDefine) this).nl++) {
            if (((CarDefine) this).xnlocars < 56
            && (loadonlinecar((((CarDefine) this).loadnames
                       [((CarDefine) this).nl]),
                      ((CarDefine) this).xnlocars)
                == ((CarDefine) this).xnlocars))
            ((CarDefine) this).xnlocars++;
        }
        ((CarDefine) this).nl = 0;
        if (((CarDefine) this).xnlocars > 36)
            ((CarDefine) this).action = 103;
        else
            ((CarDefine) this).action = -1;
        System.gc();
        }
        ((CarDefine) this).actionloader = null;
    }
    if (Thread.currentThread() == ((CarDefine) this).carloader) {
        while (((CarDefine) this).nl > 0) {
        int i = 0;
        for (int i_46_ = 16; i_46_ < 56; i_46_++) {
            if (((CarDefine) this).loadnames
                [((CarDefine) this).nl - 1]
                .equals(((CarDefine) this).names[i_46_]))
            i = -1;
        }
        if (((CarDefine) this).fails.indexOf(new StringBuilder().append
                             ("|").append
                             (((CarDefine) this)
                              .loadnames
                              [(((CarDefine) this)
                                .nl) - 1])
                             .append
                             ("|").toString())
            != -1)
            i = -1;
        if (i != -1) {
            int i_47_ = ((CarDefine) this).lcardate[0];
            int i_48_ = 36;
            if (((CarDefine) this).haltload > 0) {
            i_48_ = 36 + ((CarDefine) this).haltload;
            i_47_ = (((CarDefine) this).lcardate
                 [((CarDefine) this).haltload]);
            }
            i = i_48_;
            for (int i_49_ = i_48_; i_49_ < 56; i_49_++) {
            if (((CarDefine) this).lcardate[i_49_ - 36] < i_47_) {
                i_47_ = ((CarDefine) this).lcardate[i_49_ - 36];
                i = i_49_;
            }
            }
            ((CarDefine) this).onloadingcar = i - 35;
            if (loadonlinecar((((CarDefine) this).loadnames
                       [((CarDefine) this).nl - 1]),
                      i)
            == -1) {
            StringBuilder stringbuilder = new StringBuilder();
            CarDefine cardefine_50_ = this;
            ((CarDefine) cardefine_50_).fails
                = stringbuilder.append
                  (((CarDefine) cardefine_50_).fails).append
                  ("|").append
                  (((CarDefine) this).loadnames
                   [((CarDefine) this).nl - 1])
                  .append
                  ("|").toString();
            } else
            ((CarDefine) this).lcardate[i - 36]++;
            ((CarDefine) this).onloadingcar = 0;
        }
        ((CarDefine) this).nl--;
        try {
            if (((CarDefine) this).carloader != null) {
            /* empty */
            }
            Thread.sleep(20L);
        } catch (InterruptedException interruptedexception) {
            /* empty */
        }
        }
        ((CarDefine) this).carlon = false;
        ((CarDefine) this).carloader = null;
    }
    if (Thread.currentThread() == ((CarDefine) this).stageaction) {
        if (((CarDefine) this).staction == 1) {
        int i = -1;
        try {
            Socket socket
            = new Socket("multiplayer.needformadness.com", 7061);
            BufferedReader bufferedreader
            = (new BufferedReader
               (new InputStreamReader(socket.getInputStream())));
            PrintWriter printwriter
            = new PrintWriter(socket.getOutputStream(), true);
            printwriter.println(new StringBuilder().append("19|")
                        .append
                        (((GameSparker)
                          ((CarDefine) this).gs)
                         .tnick.getText())
                        .append
                        ("|").append
                        (((GameSparker)
                          ((CarDefine) this).gs)
                         .tpass.getText())
                        .append
                        ("|").append
                        (((CarDefine) this).onstage).append
                        ("|").toString());
            String string = bufferedreader.readLine();
            if (string != null)
            i = servervalue(string, 0);
            socket.close();
            bufferedreader.close();
            printwriter.close();
        } catch (Exception exception) {
            i = -1;
        }
        if (i == 0) {
            try {
            ((GameSparker) ((CarDefine) this).gs).mstgs
                .remove(((CarDefine) this).onstage);
            } catch (Exception exception) {
            /* empty */
            }
            ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
            ((CarDefine) this).staction = 0;
        } else
            ((CarDefine) this).staction = -1;
        }
        if (((CarDefine) this).staction == 4) {
        ((CarDefine) this).reco = -1;
        try {
            Socket socket
            = new Socket("multiplayer.needformadness.com", 7061);
            BufferedReader bufferedreader
            = (new BufferedReader
               (new InputStreamReader(socket.getInputStream())));
            PrintWriter printwriter
            = new PrintWriter(socket.getOutputStream(), true);
            printwriter.println(new StringBuilder().append("1|").append
                        (((GameSparker)
                          ((CarDefine) this).gs)
                         .tnick.getText())
                        .append
                        ("|").append
                        (((GameSparker)
                          ((CarDefine) this).gs)
                         .tpass.getText())
                        .append
                        ("|").toString());
            String string = bufferedreader.readLine();
            if (string != null) {
            ((CarDefine) this).reco = servervalue(string, 0);
            if (((CarDefine) this).reco == 0
                || ((CarDefine) this).reco == 3
                || ((CarDefine) this).reco > 10) {
                ((CarDefine) this).tnickey
                = serverSvalue(string, 1);
                if (((CarDefine) this).reco != -167) {
                ((CarDefine) this).tclan
                    = serverSvalue(string, 2);
                ((CarDefine) this).tclankey
                    = serverSvalue(string, 3);
                } else {
                ((CarDefine) this).tclan = "";
                ((CarDefine) this).tclankey = "";
                }
            }
            }
            socket.close();
            bufferedreader.close();
            printwriter.close();
        } catch (Exception exception) {
            ((CarDefine) this).reco = -1;
        }
        if (((CarDefine) this).reco == 0
            || ((CarDefine) this).reco == 3
            || ((CarDefine) this).reco > 10)
            ((CarDefine) this).staction = 5;
        else
            ((CarDefine) this).staction = 3;
        System.gc();
        while (((CarDefine) this).staction == 5) {
            /* empty */
        }
        }
        if (((CarDefine) this).staction == 2) {
        int i = -1;
        if (((CarDefine) this).msloaded == 1) {
            for (int i_51_ = 1;
             i_51_ < ((GameSparker) ((CarDefine) this).gs)
                     .mstgs.getItemCount();
             i_51_++) {
            if (((GameSparker) ((CarDefine) this).gs).mstgs.getItem
                (i_51_).equals(((CarDefine) this).onstage))
                i = 3;
            }
        }
        if (i == -1) {
            try {
            Socket socket
                = new Socket("multiplayer.needformadness.com",
                     7061);
            BufferedReader bufferedreader
                = new BufferedReader(new InputStreamReader
                         (socket.getInputStream()));
            PrintWriter printwriter
                = new PrintWriter(socket.getOutputStream(), true);
            printwriter.println
                (new StringBuilder().append("18|").append
                 (((GameSparker) ((CarDefine) this).gs)
                      .tnick.getText())
                 .append
                 ("|").append
                 (((GameSparker) ((CarDefine) this).gs)
                      .tpass.getText())
                 .append
                 ("|").append
                 (((CarDefine) this).onstage).append
                 ("|").toString());
            String string = bufferedreader.readLine();
            if (string != null)
                i = servervalue(string, 0);
            socket.close();
            bufferedreader.close();
            printwriter.close();
            } catch (Exception exception) {
            i = -1;
            }
        }
        ((CarDefine) this).staction = -1;
        if (i == 0) {
            ((CarDefine) this).staction = 0;
            if (((CarDefine) this).msloaded == 1)
            ((GameSparker) ((CarDefine) this).gs).mstgs
                .addstg(((CarDefine) this).onstage);
        }
        if (i == 3)
            ((CarDefine) this).staction = -2;
        if (i == 4)
            ((CarDefine) this).staction = -3;
        }
        ((CarDefine) this).stageaction = null;
    }
    }

    public int loadonlinecar(String string, int i) {
    try {
        String string_52_
        = new StringBuilder().append
              ("http://multiplayer.needformadness.com/cars/").append
              (string).append
              (".radq").toString();
        string_52_ = string_52_.replace(' ', '_');
        URL url = new URL(string_52_);
        int i_53_ = url.openConnection().getContentLength();
        DataInputStream datainputstream
        = new DataInputStream(url.openStream());
        byte[] is = new byte[i_53_];
        datainputstream.readFully(is);
        ZipInputStream zipinputstream;
        if (is[0] == 80 && is[1] == 75 && is[2] == 3)
        zipinputstream
            = new ZipInputStream(new ByteArrayInputStream(is));
        else {
        byte[] is_54_ = new byte[i_53_ - 40];
        for (int i_55_ = 0; i_55_ < i_53_ - 40; i_55_++) {
            int i_56_ = 20;
            if (i_55_ >= 500)
            i_56_ = 40;
            is_54_[i_55_] = is[i_55_ + i_56_];
        }
        zipinputstream
            = new ZipInputStream(new ByteArrayInputStream(is_54_));
        }
        ZipEntry zipentry = zipinputstream.getNextEntry();
        if (zipentry != null) {
        int i_57_ = Integer.valueOf(zipentry.getName()).intValue();
        byte[] is_58_ = new byte[i_57_];
        int i_59_ = 0;
        int i_60_;
        for (/**/; i_57_ > 0; i_57_ -= i_60_) {
            i_60_ = zipinputstream.read(is_58_, i_59_, i_57_);
            i_59_ += i_60_;
        }
        ((Medium) ((CarDefine) this).m).loadnew = true;
        ((CarDefine) this).bco[i]
            = new ContO(is_58_, ((CarDefine) this).m,
                ((CarDefine) this).t);
        if (((ContO) ((CarDefine) this).bco[i]).errd
            || ((ContO) ((CarDefine) this).bco[i]).npl <= 60
            || ((ContO) ((CarDefine) this).bco[i]).maxR < 120)
            i = -1;
        if (i != -1) {
            ((ContO) ((CarDefine) this).bco[i]).shadow = true;
            ((ContO) ((CarDefine) this).bco[i]).noline = false;
            ((ContO) ((CarDefine) this).bco[i]).decor = false;
            ((ContO) ((CarDefine) this).bco[i]).tnt = 0;
            ((ContO) ((CarDefine) this).bco[i]).disp = 0;
            ((ContO) ((CarDefine) this).bco[i]).disline = 7;
            ((ContO) ((CarDefine) this).bco[i]).grounded = 1.0F;
            boolean bool = true;
            if (((ContO) ((CarDefine) this).bco[i]).keyz[0] < 0
            || ((ContO) ((CarDefine) this).bco[i]).keyx[0] > 0)
            bool = false;
            if (((ContO) ((CarDefine) this).bco[i]).keyz[1] < 0
            || ((ContO) ((CarDefine) this).bco[i]).keyx[1] < 0)
            bool = false;
            if (((ContO) ((CarDefine) this).bco[i]).keyz[2] > 0
            || ((ContO) ((CarDefine) this).bco[i]).keyx[2] > 0)
            bool = false;
            if (((ContO) ((CarDefine) this).bco[i]).keyz[3] > 0
            || ((ContO) ((CarDefine) this).bco[i]).keyx[3] < 0)
            bool = false;
            if (!bool)
            i = -1;
        }
        if (i != -1) {
            loadstat(is_58_, string,
                 ((ContO) ((CarDefine) this).bco[i]).maxR,
                 ((ContO) ((CarDefine) this).bco[i]).roofat,
                 ((ContO) ((CarDefine) this).bco[i]).wh, i);
            if (((CarDefine) this).names[i].equals(""))
            i = -1;
        }
        ((Medium) ((CarDefine) this).m).loadnew = false;
        datainputstream.close();
        zipinputstream.close();
        } else
        i = -1;
    } catch (Exception exception) {
        i = -1;
    }
    System.gc();
    return i;
    }

    public void loadmystages(CheckPoints checkpoints) {
    String[] strings = new String[700];
    int i = 0;
    String string = "";
    try {
        URL url
        = (new URL
           (new StringBuilder().append
            ("http://multiplayer.needformadness.com/tracks/lists/")
            .append
            (((GameSparker) ((CarDefine) this).gs).tnick.getText())
            .append
            (".txt?reqlo=").append
            ((int) (Math.random() * 1000.0)).append
            ("").toString()));
        DataInputStream datainputstream
        = new DataInputStream(url.openStream());
        while ((string = datainputstream.readLine()) != null) {
        string = new StringBuilder().append("").append
                 (string.trim()).toString();
        if (string.startsWith("mystages")) {
            boolean bool = true;
            while (bool && i < 700) {
            strings[i] = getSvalue("mystages", string, i);
            if (strings[i].equals(""))
                bool = false;
            else
                i++;
            }
        }
        }
        if (i > 0)
        ((CarDefine) this).msloaded = 1;
        else
        ((CarDefine) this).msloaded = -2;
        datainputstream.close();
    } catch (Exception exception) {
        String string_61_
        = new StringBuilder().append("").append(exception).toString();
        if (string_61_.indexOf("FileNotFound") != -1)
        ((CarDefine) this).msloaded = -2;
        else
        ((CarDefine) this).msloaded = -1;
    }
    if (((CarDefine) this).msloaded == 1) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs
        .add(((GameSparker) ((CarDefine) this).gs).rd, "Select Stage");
        int i_62_ = 0;
        for (int i_63_ = 0; i_63_ < i; i_63_++) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
            (((GameSparker) ((CarDefine) this).gs).rd, strings[i_63_]);
        if (((CheckPoints) checkpoints).name.equals(strings[i_63_])) {
            i_62_ = i_63_ + 1;
            ((CheckPoints) checkpoints).top20 = 0;
        }
        }
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(i_62_);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
    }
    if (((CarDefine) this).msloaded == -2) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
        (((GameSparker) ((CarDefine) this).gs).rd,
         "You have not published or added any stages...");
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
    }
    if (((CarDefine) this).msloaded == -1) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
        (((GameSparker) ((CarDefine) this).gs).rd,
         "Failed to load stages, please try again later.");
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
    }
    System.gc();
    }

    public void loadtop20(int i) {
    String[] strings = new String[20];
    int i_64_ = 0;
    String string = "";
    try {
        String string_65_ = "A";
        if (i == 3)
        string_65_ = "W";
        if (i == 4)
        string_65_ = "M";
        URL url
        = (new URL
           (new StringBuilder().append
            ("http://multiplayer.needformadness.com/tracks/top20/")
            .append
            (string_65_).append
            (".txt").toString()));
        DataInputStream datainputstream
        = new DataInputStream(url.openStream());
        while ((string = datainputstream.readLine()) != null) {
        string = new StringBuilder().append("").append
                 (string.trim()).toString();
        if (string.startsWith("stages")) {
            boolean bool = true;
            while (bool && i_64_ < 20) {
            strings[i_64_] = getSvalue("stages", string, i_64_);
            if (strings[i_64_].equals(""))
                bool = false;
            else
                i_64_++;
            }
        }
        if (string.startsWith("adds")) {
            for (int i_66_ = 0; i_66_ < i_64_; i_66_++)
            ((CarDefine) this).top20adds[i_66_]
                = getvalue("adds", string, i_66_);
        }
        }
        if (i_64_ > 0)
        ((CarDefine) this).msloaded = i;
        else
        ((CarDefine) this).msloaded = -2;
        datainputstream.close();
    } catch (Exception exception) {
        String string_67_
        = new StringBuilder().append("").append(exception).toString();
        if (string_67_.indexOf("FileNotFound") != -1)
        ((CarDefine) this).msloaded = -2;
        else
        ((CarDefine) this).msloaded = -1;
    }
    if (((CarDefine) this).msloaded == i) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs
        .add(((GameSparker) ((CarDefine) this).gs).rd, "Select Stage");
        for (int i_68_ = 0; i_68_ < i_64_; i_68_++)
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
            (((GameSparker) ((CarDefine) this).gs).rd,
             new StringBuilder().append("N#").append(i_68_ + 1).append
             (" ").append
             (strings[i_68_]).toString());
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
    }
    if (((CarDefine) this).msloaded == -1
        || ((CarDefine) this).msloaded == -2) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
        (((GameSparker) ((CarDefine) this).gs).rd,
         "Failed to load Top20 list, please try again later.");
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
    }
    System.gc();
    }

    public void loadclanstages(String string) {
    if (!string.equals("")) {
        String[] strings = new String[700];
        int i = 0;
        String string_69_ = "";
        try {
        URL url
            = (new URL
               (new StringBuilder().append
                ("http://multiplayer.needformadness.com/clans/")
                .append
                (string).append
                ("/stages.txt").toString()));
        DataInputStream datainputstream;
        for (datainputstream = new DataInputStream(url.openStream());
             ((string_69_ = datainputstream.readLine()) != null
              && i < 700);
             i++)
            strings[i] = string_69_;
        if (i > 0)
            ((CarDefine) this).msloaded = 7;
        else
            ((CarDefine) this).msloaded = -2;
        datainputstream.close();
        } catch (Exception exception) {
        String string_70_ = new StringBuilder().append("").append
                    (exception).toString();
        if (string_70_.indexOf("FileNotFound") != -1)
            ((CarDefine) this).msloaded = -2;
        else
            ((CarDefine) this).msloaded = -1;
        }
        if (((CarDefine) this).msloaded == 7) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
            (((GameSparker) ((CarDefine) this).gs).rd, "Select Stage");
        for (int i_71_ = 0; i_71_ < i; i_71_++)
            ((GameSparker) ((CarDefine) this).gs).mstgs.add
            (((GameSparker) ((CarDefine) this).gs).rd,
             strings[i_71_]);
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
        }
        if (((CarDefine) this).msloaded == -1) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
            (((GameSparker) ((CarDefine) this).gs).rd,
             "Failed to load clan stages, please try again later.");
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
        }
        if (((CarDefine) this).msloaded == -2) {
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
            (((GameSparker) ((CarDefine) this).gs).rd,
             "No stages have been added to your clan yet.");
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
        }
        System.gc();
    } else {
        ((CarDefine) this).msloaded = -2;
        ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
        ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
        (((GameSparker) ((CarDefine) this).gs).rd,
         "You are not a member of any clan yet.");
        ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
        ((GameSparker) ((CarDefine) this).gs).mstgs.show();
    }
    }

    public void loadstagemaker() {
    ((GameSparker) ((CarDefine) this).gs).mstgs.hide();
    ((GameSparker) ((CarDefine) this).gs).mstgs.removeAll();
    ((GameSparker) ((CarDefine) this).gs).mstgs
        .add(((GameSparker) ((CarDefine) this).gs).rd, "Select Stage");
    int i = 0;
    File file = new File(new StringBuilder().append("").append
                 (Madness.fpath).append
                 ("mystages/").toString());
    if (file.exists()) {
        String[] strings = new File(new StringBuilder().append("").append
                        (Madness.fpath).append
                        ("mystages/").toString()).list();
        for (int i_72_ = 0; i_72_ < strings.length; i_72_++) {
        if (strings[i_72_].toLowerCase().endsWith(".txt") && i < 200) {
            ((GameSparker) ((CarDefine) this).gs).mstgs.add
            (((GameSparker) ((CarDefine) this).gs).rd,
             strings[i_72_]
                 .substring(0, strings[i_72_].length() - 4));
            i++;
        }
        }
    }
    if (i != 0)
        ((CarDefine) this).msloaded = 2;
    else {
        ((GameSparker) ((CarDefine) this).gs).mstgs.add
        (((GameSparker) ((CarDefine) this).gs).rd,
         "No stages where found in your 'mystages' folder.");
        ((CarDefine) this).msloaded = -1;
    }
    ((GameSparker) ((CarDefine) this).gs).mstgs.select(0);
    ((GameSparker) ((CarDefine) this).gs).mstgs.show();
    }

    public void loadcarmaker() {
    ((Medium) ((CarDefine) this).m).csky[0] = 170;
    ((Medium) ((CarDefine) this).m).csky[1] = 220;
    ((Medium) ((CarDefine) this).m).csky[2] = 255;
    ((Medium) ((CarDefine) this).m).cfade[0] = 255;
    ((Medium) ((CarDefine) this).m).cfade[1] = 220;
    ((Medium) ((CarDefine) this).m).cfade[2] = 220;
    ((Medium) ((CarDefine) this).m).snap[0] = 0;
    ((Medium) ((CarDefine) this).m).snap[1] = 0;
    ((Medium) ((CarDefine) this).m).snap[2] = 0;
    for (int i = 0; i < 40; i++)
        ((CarDefine) this).include[i] = false;
    ((CarDefine) this).nlcars = 16;
    File file = new File(new StringBuilder().append("").append
                 (Madness.fpath).append
                 ("mycars/").toString());
    if (file.exists()) {
        String[] strings = new File(new StringBuilder().append("").append
                        (Madness.fpath).append
                        ("mycars/").toString()).list();
        for (int i = 0; i < strings.length; i++) {
        if (strings[i].toLowerCase().endsWith(".rad")
            && ((CarDefine) this).nlcars < 56
            && (loadcar(strings[i].substring(0,
                             strings[i].length() - 4),
                ((CarDefine) this).nlcars)
            == ((CarDefine) this).nlcars))
            ((CarDefine) this).nlcars++;
        }
    }
    System.gc();
    if (((CarDefine) this).nlcars > 16)
        ((CarDefine) this).lastload = 1;
    }

    public int loadcar(String string, int i) {
    try {
        File file = new File(new StringBuilder().append("").append
                     (Madness.fpath).append
                     ("mycars/").append
                     (string).append
                     (".rad").toString());
        if (file.exists()) {
        String string_73_ = "";
        BufferedReader bufferedreader
            = new BufferedReader(new FileReader(file));
        Object object = null;
        String string_74_;
        while ((string_74_ = bufferedreader.readLine()) != null)
            string_73_ = new StringBuilder().append(string_73_).append
                     ("").append
                     (string_74_).append
                     ("\n").toString();
        bufferedreader.close();
        Object object_75_ = null;
        ((Medium) ((CarDefine) this).m).loadnew = true;
        ((CarDefine) this).bco[i]
            = new ContO(string_73_.getBytes(), ((CarDefine) this).m,
                ((CarDefine) this).t);
        if (((ContO) ((CarDefine) this).bco[i]).errd
            || ((ContO) ((CarDefine) this).bco[i]).npl <= 60)
            i = -1;
        if (i != -1) {
            ((ContO) ((CarDefine) this).bco[i]).shadow = true;
            ((ContO) ((CarDefine) this).bco[i]).noline = false;
            ((ContO) ((CarDefine) this).bco[i]).decor = false;
            ((ContO) ((CarDefine) this).bco[i]).tnt = 0;
            ((ContO) ((CarDefine) this).bco[i]).disp = 0;
            ((ContO) ((CarDefine) this).bco[i]).disline = 7;
            ((ContO) ((CarDefine) this).bco[i]).grounded = 1.0F;
            boolean bool = true;
            if (((ContO) ((CarDefine) this).bco[i]).keyz[0] < 0
            || ((ContO) ((CarDefine) this).bco[i]).keyx[0] > 0)
            bool = false;
            if (((ContO) ((CarDefine) this).bco[i]).keyz[1] < 0
            || ((ContO) ((CarDefine) this).bco[i]).keyx[1] < 0)
            bool = false;
            if (((ContO) ((CarDefine) this).bco[i]).keyz[2] > 0
            || ((ContO) ((CarDefine) this).bco[i]).keyx[2] > 0)
            bool = false;
            if (((ContO) ((CarDefine) this).bco[i]).keyz[3] > 0
            || ((ContO) ((CarDefine) this).bco[i]).keyx[3] < 0)
            bool = false;
            if (!bool)
            i = -1;
        }
        if (i != -1) {
            loadstat(string_73_.getBytes(), string,
                 ((ContO) ((CarDefine) this).bco[i]).maxR,
                 ((ContO) ((CarDefine) this).bco[i]).roofat,
                 ((ContO) ((CarDefine) this).bco[i]).wh, i);
            if (((CarDefine) this).names[i].equals(""))
            i = -1;
        }
        ((Medium) ((CarDefine) this).m).loadnew = false;
        } else
        i = -1;
    } catch (Exception exception) {
        i = -1;
        System.out.println(new StringBuilder().append
                   ("Error Loading Car: ").append
                   (exception).toString());
    }
    System.gc();
    return i;
    }
}
