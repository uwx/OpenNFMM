package stagemaker;

/* CarDefine - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
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
    int[][] swits = { { 50, 185, 282 }, { 100, 200, 310 }, { 60, 180, 275 }, { 76, 195, 298 }, { 70, 170, 275 }, { 70, 202, 293 }, { 60, 170, 289 }, { 70, 206, 291 }, { 90, 210, 295 }, { 90, 190, 276 }, { 70, 200, 295 }, { 50, 160, 270 }, { 90, 200, 305 }, { 50, 130, 210 }, { 80, 200, 300 }, { 70, 210, 290 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    float[][] acelf = { { 11.0F, 5.0F, 3.0F }, { 14.0F, 7.0F, 5.0F }, { 10.0F, 5.0F, 3.5F }, { 11.0F, 6.0F, 3.5F }, { 10.0F, 5.0F, 3.5F }, { 12.0F, 6.0F, 3.0F }, { 7.0F, 9.0F, 4.0F }, { 11.0F, 5.0F, 3.0F }, { 12.0F, 7.0F, 4.0F }, { 12.0F, 7.0F, 3.5F }, { 11.5F, 6.5F, 3.5F }, { 9.0F, 5.0F, 3.0F }, { 13.0F, 7.0F, 4.5F }, { 7.5F, 3.5F, 3.0F }, { 11.0F, 7.5F, 4.0F }, { 12.0F, 6.0F, 3.5F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F } };
    int[] handb = { 7, 10, 7, 15, 12, 8, 9, 10, 5, 7, 8, 10, 8, 12, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    float[] airs = { 1.0F, 1.2F, 0.95F, 1.0F, 2.2F, 1.0F, 0.9F, 0.8F, 1.0F, 0.9F, 1.15F, 0.8F, 1.0F, 0.3F, 1.3F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    int[] airc = { 70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] turn = { 6, 9, 5, 7, 8, 7, 5, 5, 9, 7, 7, 4, 6, 5, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    float[] grip = { 20.0F, 27.0F, 18.0F, 22.0F, 19.0F, 20.0F, 25.0F, 20.0F, 19.0F, 24.0F, 22.5F, 25.0F, 30.0F, 27.0F, 25.0F, 27.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    float[] bounce = { 1.2F, 1.05F, 1.3F, 1.15F, 1.3F, 1.2F, 1.15F, 1.1F, 1.2F, 1.1F, 1.15F, 0.8F, 1.05F, 0.8F, 1.1F, 1.15F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    float[] simag = { 0.9F, 0.85F, 1.05F, 0.9F, 0.85F, 0.9F, 1.05F, 0.9F, 1.0F, 1.05F, 0.9F, 1.1F, 0.9F, 1.3F, 0.9F, 1.15F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    float[] moment = { 1.3F, 0.75F, 1.4F, 1.2F, 1.1F, 1.38F, 1.43F, 1.48F, 1.35F, 1.7F, 1.42F, 2.0F, 1.26F, 3.0F, 1.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    float[] comprad = { 0.5F, 0.4F, 0.8F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5F, 0.5F, 0.8F, 0.5F, 1.5F, 0.5F, 0.8F, 0.5F, 0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    int[] push = { 2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] revpush = { 2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] lift = { 0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] revlift = { 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] powerloss = { 2500000, 2500000, 3500000, 2500000, 4000000, 2500000, 3200000, 3200000, 2750000, 5500000, 2750000, 4500000, 3500000, 16700000, 3000000, 5500000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] flipy = { -50, -60, -92, -44, -60, -57, -54, -60, -77, -57, -82, -85, -28, -100, -63, -127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] msquash = { 7, 4, 7, 2, 8, 4, 6, 4, 3, 8, 4, 10, 3, 20, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] clrad = { 3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000, 15000, 4000, 7000, 10000, 15000, 5500, 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    float[] dammult = { 0.75F, 0.8F, 0.45F, 0.8F, 0.42F, 0.7F, 0.72F, 0.6F, 0.58F, 0.41F, 0.67F, 0.45F, 0.61F, 0.25F, 0.38F, 0.52F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    int[] maxmag = { 7600, 4200, 7200, 6000, 6000, 15000, 17200, 17000, 18000, 11000, 19000, 10700, 13000, 45000, 5800, 18000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    float[] dishandle = { 0.65F, 0.6F, 0.55F, 0.77F, 0.62F, 0.9F, 0.6F, 0.72F, 0.45F, 0.8F, 0.95F, 0.4F, 0.87F, 0.42F, 1.0F, 0.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    float[] outdam = { 0.68F, 0.35F, 0.8F, 0.5F, 0.42F, 0.76F, 0.82F, 0.76F, 0.72F, 0.62F, 0.79F, 0.95F, 0.77F, 1.0F, 0.85F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    int[] cclass = { 0, 0, 0, 0, 0 /*c*/, 1 /*bc*/, 2, 2, 2, 2/*b*/, 3/*ab*/, 4/*a*/, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    String[] names = { "Tornado Shark", "Formula 7", "Wow Caninaro", "La Vita Crab", "Nimi", "MAX Revenge", "Lead Oxide", "Kool Kat", "Drifter X", "Sword of Justice", "High Rider", "EL KING", "Mighty Eight", "M A S H E E N", "Radical One", "DR Monstaa", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		 //new
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    		, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    int[] enginsignature = { 0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int lastload = 0;
    int nlcars = 0;
    int nlocars = 0;
    boolean[] include = new boolean[40];
    String[] createdby = new String[40];
    int[] publish = new int[40];
    String[] loadnames = new String[20];
    int nl = 0;
    int action = 0;
    boolean carlon = false;
    int reco = -2;
    int[] lcardate = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int ac = -1;
    String acname = "Radical One";
    String fails = "";
    String tnickey = "";
    int loadlist = 0;
    int[] adds = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int staction = 0;
    String onstage = "";
    int msloaded = 0;
    int[] top20adds = new int[20];
    
    public CarDefine(ContO[] contos, Medium medium, Trackers trackers, GameSparker gamesparker) {
        this.bco = contos;
        this.m = medium;
        this.t = trackers;
        this.gs = gamesparker;
    }
    
    public void loadstat(byte[] is, String string, int i, int i_0_, int i_1_, int i_2_) {
        this.names[i_2_] = string;
        boolean bool = false;
        boolean bool_3_ = false;
        String string_4_ = "";
        int[] is_5_ = { 128, 128, 128, 128, 128 };
        int i_6_ = 640;
        int[] is_7_ = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
        int[] is_8_ = { 50, 50, 50 };
        this.enginsignature[i_2_] = 0;
        float f = 0.0F;
        this.publish[i_2_ - 16] = 0;
        this.createdby[i_2_ - 16] = "Unkown User";
        try {
            DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(is));
            while ((string_4_ = datainputstream.readLine()) != null) {
                string_4_ = string_4_.trim();
                if (string_4_.startsWith("stat(")) {
                    try {
                        i_6_ = 0;
                        for (int i_9_ = 0; i_9_ < 5; i_9_++) {
                            is_5_[i_9_] = getvalue("stat", string_4_, i_9_);
                            //if (is_5_[i_9_] > 200)
                            //    is_5_[i_9_] = 200;
                            //if (is_5_[i_9_] < 16)
                            //    is_5_[i_9_] = 16;
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
                            is_7_[i_10_] = getvalue("physics", string_4_, i_10_);
                            //if (is_7_[i_10_] > 100)
                            //    is_7_[i_10_] = 100;
                            //if (is_7_[i_10_] < 0)
                            //    is_7_[i_10_] = 0;
                        }
                        for (int i_11_ = 0; i_11_ < 3; i_11_++) {
                            is_8_[i_11_] = getvalue("physics", string_4_, i_11_ + 11);
                            //if (i_11_ != 0 && is_8_[i_11_] > 100)
                            //    is_8_[i_11_] = 100;
                            //if (is_8_[i_11_] < 0)
                            //    is_8_[i_11_] = 0;
                        }
                        this.enginsignature[i_2_] = getvalue("physics", string_4_, 14);
                        if (this.enginsignature[i_2_] > 4)
                            this.enginsignature[i_2_] = 0;
                        if (this.enginsignature[i_2_] < 0)
                            this.enginsignature[i_2_] = 0;
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
                        //if (i_12_ > 200)
                        //    i_12_ = 200;
                        //if (i_12_ < 50)
                        //    i_12_ = 50;
                        this.dishandle[i_2_] = (float) i_12_ / 200.0F;
                    } catch (Exception exception) {
                        /* empty */
                    }
                }
                if (string_4_.startsWith("carmaker("))
                    this.createdby[i_2_ - 16] = getSvalue("carmaker", string_4_, 0);
                if (string_4_.startsWith("publish("))
                    this.publish[i_2_ - 16] = getvalue("publish", string_4_, 0);
            }
            datainputstream.close();
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Error Loading Car Stat: ").append(exception).toString());
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
                this.cclass[i_2_] = 0;
            if (i_6_ == 560)
                this.cclass[i_2_] = 1;
            if (i_6_ == 600)
                this.cclass[i_2_] = 2;
            if (i_6_ == 640)
                this.cclass[i_2_] = 3;
            if (i_6_ == 680)
                this.cclass[i_2_] = 4;
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
                this.swits[i_2_][0] = (int) ((float) (this.swits[i_17_][0] - this.swits[i_16_][0]) * f_18_ + (float) this.swits[i_16_][0]);
                this.swits[i_2_][1] = (int) ((float) (this.swits[i_17_][1] - this.swits[i_16_][1]) * f_18_ + (float) this.swits[i_16_][1]);
                this.swits[i_2_][2] = (int) ((float) (this.swits[i_17_][2] - this.swits[i_16_][2]) * f_18_ + (float) this.swits[i_16_][2]);
            } else {
                f_18_ = (float) is_5_[0] / 88.0F;
                if ((double) f_18_ < 0.76)
                    f_18_ = 0.76F;
                this.swits[i_2_][0] = (int) (50.0F * f_18_);
                this.swits[i_2_][1] = (int) (130.0F * f_18_);
                this.swits[i_2_][2] = (int) (210.0F * f_18_);
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
            this.acelf[i_2_][0] = (this.acelf[i_17_][0] - this.acelf[i_16_][0]) * f_18_ + this.acelf[i_16_][0];
            this.acelf[i_2_][1] = (this.acelf[i_17_][1] - this.acelf[i_16_][1]) * f_18_ + this.acelf[i_16_][1];
            this.acelf[i_2_][2] = (this.acelf[i_17_][2] - this.acelf[i_16_][2]) * f_18_ + this.acelf[i_16_][2];
            if (is_5_[1] <= 70 && is_5_[0] > 88) {
                this.acelf[i_2_][0] = 9.0F;
                this.acelf[i_2_][1] = 4.0F;
                this.acelf[i_2_][2] = 3.0F;
            }
            f_18_ = (float) (is_5_[2] - 88) / 109.0F;
            if (f_18_ > 1.0F)
                f_18_ = 1.0F;
            if ((double) f_18_ < -0.55)
                f_18_ = -0.55F;
            this.airs[i_2_] = 0.55F + 0.45F * f_18_ + 0.4F * ((float) is_7_[9] / 100.0F);
            if ((double) this.airs[i_2_] < 0.3)
                this.airs[i_2_] = 0.3F;
            this.airc[i_2_] = (int) (10.0F + 70.0F * f_18_ + 30.0F * ((float) is_7_[10] / 100.0F));
            if (this.airc[i_2_] < 0)
                this.airc[i_2_] = 0;
            int i_19_ = (int) (670.0F - (float) (is_7_[9] + is_7_[10]) / 200.0F * 420.0F);
            if (is_5_[0] <= 88)
                i_19_ = (int) (1670.0F - (float) (is_7_[9] + is_7_[10]) / 200.0F * 1420.0F);
            if (is_5_[2] > 190 && i_19_ < 300)
                i_19_ = 300;
            this.powerloss[i_2_] = i_19_ * 10000;
            this.moment[i_2_] = 0.7F + (float) (is_5_[3] - 16) / 184.0F * 1.0F;
            if (is_5_[0] < 110)
                this.moment[i_2_] = 0.75F + (float) (is_5_[3] - 16) / 184.0F * 1.25F;
            if (is_5_[3] == 200 && is_5_[4] == 200 && is_5_[0] <= 88)
                this.moment[i_2_] = 3.0F;
            float f_20_ = 0.9F + (float) (is_5_[4] - 90) * 0.01F;
            if ((double) f_20_ < 0.6)
                f_20_ = 0.6F;
            if (is_5_[4] == 200 && is_5_[0] <= 88)
                f_20_ = 3.0F;
            this.maxmag[i_2_] = (int) (f * f_20_);
            this.outdam[i_2_] = 0.35F + (f_20_ - 0.6F) * 0.5F;
            if ((double) this.outdam[i_2_] < 0.35)
                this.outdam[i_2_] = 0.35F;
            if (this.outdam[i_2_] > 1.0F)
                this.outdam[i_2_] = 1.0F;
            this.clrad[i_2_] = (int) ((double) (is_8_[0] * is_8_[0]) * 1.5);
            if (this.clrad[i_2_] < 1000)
                this.clrad[i_2_] = 1000;
            this.dammult[i_2_] = 0.3F + (float) is_8_[1] * 0.005F;
            this.msquash[i_2_] = (int) (2.0 + (double) (float) is_8_[2] / 7.6);
            this.flipy[i_2_] = i_0_;
            this.handb[i_2_] = (int) (7.0F + (float) is_7_[0] / 100.0F * 8.0F);
            this.turn[i_2_] = (int) (4.0F + (float) is_7_[1] / 100.0F * 6.0F);
            this.grip[i_2_] = 16.0F + (float) is_7_[2] / 100.0F * 14.0F;
            if (this.grip[i_2_] < 21.0F) {
                this.swits[i_2_][0] += 40.0F * ((21.0F - this.grip[i_2_]) / 5.0F);
                if (this.swits[i_2_][0] > 100)
                    this.swits[i_2_][0] = 100;
            }
            this.bounce[i_2_] = 0.8F + (float) is_7_[3] / 100.0F * 0.6F;
            if (is_7_[3] > 67) {
                this.airs[i_2_] *= 0.76F + (1.0F - (float) is_7_[3] / 100.0F) * 0.24F;
                this.airc[i_2_] *= 0.76F + (1.0F - (float) is_7_[3] / 100.0F) * 0.24F;
            }
            this.lift[i_2_] = (int) ((float) is_7_[5] * (float) is_7_[5] / 10000.0F * 30.0F);
            this.revlift[i_2_] = (int) ((float) is_7_[6] / 100.0F * 32.0F);
            this.push[i_2_] = (int) (2.0F + (float) is_7_[7] / 100.0F * 2.0F * (float) ((30 - this.lift[i_2_]) / 30));
            this.revpush[i_2_] = (int) (1.0F + (float) is_7_[8] / 100.0F * 2.0F);
            this.comprad[i_2_] = (float) i / 400.0F + (float) (is_5_[3] - 16) / 184.0F * 0.2F;
            if ((double) this.comprad[i_2_] < 0.4)
                this.comprad[i_2_] = 0.4F;
            this.simag[i_2_] = (float) (i_1_ - 17) * 0.0167F + 0.85F;
        } else
            this.names[i_2_] = "";
    }
    
    public int getvalue(String string, String string_21_, int i) {
        int i_22_ = 0;
        String string_23_ = "";
        for (int i_24_ = string.length() + 1; i_24_ < string_21_.length(); i_24_++) {
            String string_25_ = new StringBuilder().append("").append(string_21_.charAt(i_24_)).toString();
            if (string_25_.equals(",") || string_25_.equals(")")) {
                i_22_++;
                i_24_++;
            }
            if (i_22_ == i)
                string_23_ = new StringBuilder().append(string_23_).append(string_21_.charAt(i_24_)).toString();
        }
        return Float.valueOf(string_23_).intValue();
    }
    
    public String getSvalue(String string, String string_26_, int i) {
        String string_27_ = "";
        int i_28_ = 0;
        for (int i_29_ = string.length() + 1; i_29_ < string_26_.length() && i_28_ <= i; i_29_++) {
            String string_30_ = new StringBuilder().append("").append(string_26_.charAt(i_29_)).toString();
            if (string_30_.equals(",") || string_30_.equals(")"))
                i_28_++;
            else if (i_28_ == i)
                string_27_ = new StringBuilder().append(string_27_).append(string_30_).toString();
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
                string_35_ = new StringBuilder().append("").append(string.charAt(i_32_)).toString();
                if (string_35_.equals("|")) {
                    i_33_++;
                    if (i_34_ == 1 || i_33_ > i)
                        i_34_ = 2;
                } else if (i_33_ == i) {
                    string_36_ = new StringBuilder().append(string_36_).append(string_35_).toString();
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
                string_41_ = new StringBuilder().append("").append(string.charAt(i_38_)).toString();
                if (string_41_.equals("|")) {
                    i_39_++;
                    if (i_40_ == 1 || i_39_ > i)
                        i_40_ = 2;
                } else if (i_39_ == i) {
                    string_42_ = new StringBuilder().append(string_42_).append(string_41_).toString();
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
        (this.m).csky[0] = 170;
        (this.m).csky[1] = 220;
        (this.m).csky[2] = 255;
        (this.m).cfade[0] = 255;
        (this.m).cfade[1] = 220;
        (this.m).cfade[2] = 220;
        (this.m).snap[0] = 0;
        (this.m).snap[1] = 0;
        (this.m).snap[2] = 0;
        this.fails = "";
        for (int i = 0; i < 20; i++)
            this.loadnames[i] = "";
        this.nl = 0;
        this.action = 0;
    }
    
    public void sparkactionloader() {
        this.actionloader = new Thread(this);
        this.actionloader.start();
    }
    
    public void sparkcarloader() {
        if (!this.carlon) {
            this.carloader = new Thread(this);
            this.carloader.start();
            this.carlon = true;
        }
    }
    
    public void sparkstageaction() {
        this.stageaction = new Thread(this);
        this.stageaction.start();
    }
    
    public void stopallnow() {
        this.staction = 0;
        this.action = 0;
        if (this.carloader != null) {
            this.carloader.stop();
            this.carloader = null;
        }
        if (this.actionloader != null) {
            this.actionloader.stop();
            this.actionloader = null;
        }
        if (this.stageaction != null) {
            this.stageaction.stop();
            this.stageaction = null;
        }
    }
    
    public void run() {
        if (Thread.currentThread() == this.actionloader) {
            if (this.action == 10) {
                int i = -1;
                try {
                    Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("9|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(this.names[this.ac]).append("|").toString());
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
                    this.nl = 0;
                    for (int i_43_ = 16; i_43_ < this.nlocars; i_43_++) {
                        if (i_43_ != this.ac) {
                            this.loadnames[this.nl] = this.names[i_43_];
                            this.nl++;
                        }
                    }
                    this.action = 4;
                } else
                    this.action = -10;
                System.gc();
            }
            if (this.action == 1) {
                this.reco = -1;
                try {
                    Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("1|").append((this.gs).tnick.getText().toLowerCase()).append("|").append((this.gs).tpass.getText()).append("|").toString());
                    String string = bufferedreader.readLine();
                    if (string != null) {
                        this.reco = servervalue(string, 0);
                        if (this.reco == 0 || this.reco > 10)
                            this.tnickey = serverSvalue(string, 1);
                    }
                    socket.close();
                    bufferedreader.close();
                    printwriter.close();
                } catch (Exception exception) {
                    this.reco = -1;
                }
                if (this.reco == 0 || this.reco == 3 || this.reco > 10)
                    this.action = 2;
                else
                    this.action = 0;
                System.gc();
            }
            while (this.action == 2) {
                /* empty */
            }
            if (this.action == 3) {
                this.nl = 0;
                String string = "";
                try {
                    URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/cars/lists/").append((this.gs).tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                    DataInputStream datainputstream = new DataInputStream(url.openStream());
                    while ((string = datainputstream.readLine()) != null) {
                        string = new StringBuilder().append("").append(string.trim()).toString();
                        if (string.startsWith("mycars")) {
                            boolean bool = true;
                            while (bool && this.nl < 20) {
                                this.loadnames[this.nl] = getSvalue("mycars", string, this.nl);
                                if (this.loadnames[this.nl].equals(""))
                                    bool = false;
                                else
                                    this.nl++;
                            }
                        }
                    }
                    if (this.nl > 0)
                        this.action = 4;
                    else
                        this.action = -1;
                    datainputstream.close();
                } catch (Exception exception) {
                    String string_44_ = new StringBuilder().append("").append(exception).toString();
                    if (string_44_.indexOf("FileNotFound") != -1)
                        this.action = -1;
                    else
                        this.action = -2;
                }
                System.gc();
            }
            if (this.action == 4) {
                (this.m).csky[0] = 170;
                (this.m).csky[1] = 220;
                (this.m).csky[2] = 255;
                (this.m).cfade[0] = 255;
                (this.m).cfade[1] = 220;
                (this.m).cfade[2] = 220;
                (this.m).snap[0] = 0;
                (this.m).snap[1] = 0;
                (this.m).snap[2] = 0;
                for (int i = 0; i < 40; i++)
                    this.include[i] = false;
                this.nlocars = 16;
                int i = this.nl;
                for (this.nl = 0; this.nl < i; this.nl++) {
                    if (this.nlocars < 36 && loadonlinecar(this.loadnames[this.nl], this.nlocars) == this.nlocars)
                        this.nlocars++;
                }
                this.nl = 0;
                if (this.nlocars > 16) {
                    this.lastload = 2;
                    this.action = 5;
                } else {
                    if (this.lastload == 2)
                        this.lastload = 0;
                    this.action = -1;
                }
                System.gc();
            }
            if (this.action == 6) {
                int i = -1;
                try {
                    if (this.ac != -1)
                        this.acname = this.names[this.ac];
                    Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("8|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(this.acname).append("|").toString());
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
                    if (this.ac == -1 && this.lastload == 2)
                        this.lastload = 0;
                    if (this.lastload == 2 && this.nlocars < 36)
                        copycar();
                    this.action = 7;
                }
                if (i == 3)
                    this.action = -7;
                if (i == 4)
                    this.action = -8;
                if (this.action == 6)
                    this.action = -9;
                System.gc();
            }
            if (this.action == 11) {
                this.nl = 0;
                String string = "";
                try {
                    String string_45_ = "all";
                    if (this.loadlist == 1)
                        string_45_ = "Wall";
                    if (this.loadlist == 2)
                        string_45_ = "WA";
                    if (this.loadlist == 3)
                        string_45_ = "WAB";
                    if (this.loadlist == 4)
                        string_45_ = "WB";
                    if (this.loadlist == 5)
                        string_45_ = "WBC";
                    if (this.loadlist == 6)
                        string_45_ = "WC";
                    if (this.loadlist == 7)
                        string_45_ = "Mall";
                    if (this.loadlist == 8)
                        string_45_ = "MA";
                    if (this.loadlist == 9)
                        string_45_ = "MAB";
                    if (this.loadlist == 10)
                        string_45_ = "MB";
                    if (this.loadlist == 11)
                        string_45_ = "MBC";
                    if (this.loadlist == 12)
                        string_45_ = "MC";
                    if (this.loadlist == 13)
                        string_45_ = "all";
                    if (this.loadlist == 14)
                        string_45_ = "A";
                    if (this.loadlist == 15)
                        string_45_ = "AB";
                    if (this.loadlist == 16)
                        string_45_ = "B";
                    if (this.loadlist == 17)
                        string_45_ = "BC";
                    if (this.loadlist == 18)
                        string_45_ = "C";
                    URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/cars/top20/").append(string_45_).append(".txt").toString());
                    DataInputStream datainputstream = new DataInputStream(url.openStream());
                    while ((string = datainputstream.readLine()) != null) {
                        string = new StringBuilder().append("").append(string.trim()).toString();
                        if (string.startsWith("cars")) {
                            boolean bool = true;
                            while (bool && this.nl < 20) {
                                this.loadnames[this.nl] = getSvalue("cars", string, this.nl);
                                if (this.loadnames[this.nl].equals(""))
                                    bool = false;
                                else
                                    this.nl++;
                            }
                        }
                        if (string.startsWith("adds")) {
                            for (int i = 0; i < this.nl; i++)
                                this.adds[i] = getvalue("adds", string, i);
                        }
                    }
                    if (this.nl > 0)
                        this.action = 12;
                    else
                        this.action = -1;
                    datainputstream.close();
                } catch (Exception exception) {
                    this.action = -1;
                }
                System.gc();
            }
            if (this.action == 12) {
                (this.m).csky[0] = 170;
                (this.m).csky[1] = 220;
                (this.m).csky[2] = 255;
                (this.m).cfade[0] = 255;
                (this.m).cfade[1] = 220;
                (this.m).cfade[2] = 220;
                (this.m).snap[0] = 0;
                (this.m).snap[1] = 0;
                (this.m).snap[2] = 0;
                this.nlocars = 16;
                int i = this.nl;
                for (this.nl = 0; this.nl < i; this.nl++) {
                    if (this.nlocars < 36 && loadonlinecar(this.loadnames[this.nl], this.nlocars) == this.nlocars)
                        this.nlocars++;
                }
                this.nl = 0;
                if (this.nlocars > 16) {
                    this.lastload = 2 + this.loadlist;
                    this.action = 13;
                } else {
                    if (this.lastload >= 2)
                        this.lastload = 0;
                    this.action = -1;
                }
                System.gc();
            }
            this.actionloader = null;
        }
        if (Thread.currentThread() == this.carloader) {
            while (this.nl > 0) {
                int i = 0;
                for (int i_46_ = 16; i_46_ < 56; i_46_++) {
                    if (this.loadnames[this.nl - 1].equals(this.names[i_46_]))
                        i = -1;
                }
                if (this.fails.indexOf(new StringBuilder().append("|").append(this.loadnames[this.nl - 1]).append("|").toString()) != -1)
                    i = -1;
                if (i != -1) {
                    i = 36;
                    int i_47_ = this.lcardate[0];
                    for (int i_48_ = 36; i_48_ < 56; i_48_++) {
                        if (this.lcardate[i_48_ - 36] < i_47_) {
                            i_47_ = this.lcardate[i_48_ - 36];
                            i = i_48_;
                        }
                    }
                    if (loadonlinecar(this.loadnames[this.nl - 1], i) == -1) {
                        StringBuilder stringbuilder = new StringBuilder();
                        CarDefine cardefine_49_ = this;
                        (cardefine_49_).fails = stringbuilder.append((cardefine_49_).fails).append("|").append(this.loadnames[this.nl - 1]).append("|").toString();
                    } else
                        this.lcardate[i - 36]++;
                }
                this.nl--;
                try {
                    if (this.carloader != null) {
                        /* empty */
                    }
                    Thread.sleep(20L);
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
            }
            this.carlon = false;
            this.carloader = null;
        }
        if (Thread.currentThread() == this.stageaction) {
            if (this.staction == 1) {
                int i = -1;
                try {
                    Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("19|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(this.onstage).append("|").toString());
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
                        (this.gs).mstgs.remove(this.onstage);
                    } catch (Exception exception) {
                        /* empty */
                    }
                    (this.gs).mstgs.select(0);
                    this.staction = 0;
                } else
                    this.staction = -1;
            }
            if (this.staction == 4) {
                this.reco = -1;
                try {
                    Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("1|").append((this.gs).tnick.getText().toLowerCase()).append("|").append((this.gs).tpass.getText()).append("|").toString());
                    String string = bufferedreader.readLine();
                    if (string != null) {
                        this.reco = servervalue(string, 0);
                        if (this.reco == 0 || this.reco > 10)
                            this.tnickey = serverSvalue(string, 1);
                    }
                    socket.close();
                    bufferedreader.close();
                    printwriter.close();
                } catch (Exception exception) {
                    this.reco = -1;
                }
                if (this.reco == 0 || this.reco == 3 || this.reco > 10)
                    this.staction = 5;
                else
                    this.staction = 3;
                System.gc();
                while (this.staction == 5) {
                    /* empty */
                }
            }
            if (this.staction == 2) {
                int i = -1;
                if (this.msloaded == 1) {
                    for (int i_50_ = 1; i_50_ < (this.gs).mstgs.getItemCount(); i_50_++) {
                        if ((this.gs).mstgs.getItem(i_50_).equals(this.onstage))
                            i = 3;
                    }
                    if ((this.gs).mstgs.getItemCount() >= 21 && i != 3)
                        i = 4;
                }
                if (i == -1) {
                    try {
                        Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                        printwriter.println(new StringBuilder().append("18|").append((this.gs).tnick.getText()).append("|").append((this.gs).tpass.getText()).append("|").append(this.onstage).append("|").toString());
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
                this.staction = -1;
                if (i == 0) {
                    this.staction = 0;
                    if (this.msloaded == 1)
                        (this.gs).mstgs.add((this.gs).rd, this.onstage);
                }
                if (i == 3)
                    this.staction = -2;
                if (i == 4)
                    this.staction = -3;
            }
            this.stageaction = null;
        }
    }
    
    public int loadonlinecar(String string, int i) {
        try {
            String string_51_ = new StringBuilder().append("http://multiplayer.needformadness.com/cars/").append(string).append(".radq").toString();
            string_51_ = string_51_.replace(' ', '_');
            URL url = new URL(string_51_);
            int i_52_ = url.openConnection().getContentLength();
            DataInputStream datainputstream = new DataInputStream(url.openStream());
            byte[] is = new byte[i_52_];
            datainputstream.readFully(is);
            ZipInputStream zipinputstream;
            if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
            else {
                byte[] is_53_ = new byte[i_52_ - 40];
                for (int i_54_ = 0; i_54_ < i_52_ - 40; i_54_++) {
                    int i_55_ = 20;
                    if (i_54_ >= 500)
                        i_55_ = 40;
                    is_53_[i_54_] = is[i_54_ + i_55_];
                }
                zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_53_));
            }
            ZipEntry zipentry = zipinputstream.getNextEntry();
            if (zipentry != null) {
                int i_56_ = Integer.valueOf(zipentry.getName()).intValue();
                byte[] is_57_ = new byte[i_56_];
                int i_58_ = 0;
                int i_59_;
                for (/**/; i_56_ > 0; i_56_ -= i_59_) {
                    i_59_ = zipinputstream.read(is_57_, i_58_, i_56_);
                    i_58_ += i_59_;
                }
                (this.m).loadnew = true;
                this.bco[i] = new ContO(is_57_, this.m, this.t);
                if ((this.bco[i]).errd || (this.bco[i]).npl <= 60 || (this.bco[i]).maxR < 120)
                    i = -1;
                if (i != -1) {
                    (this.bco[i]).shadow = true;
                    (this.bco[i]).noline = false;
                    (this.bco[i]).decor = false;
                    (this.bco[i]).tnt = 0;
                    (this.bco[i]).disp = 0;
                    (this.bco[i]).disline = 7;
                    (this.bco[i]).grounded = 1.0F;
                    boolean bool = true;
                    if ((this.bco[i]).keyz[0] < 0 || (this.bco[i]).keyx[0] > 0)
                        bool = false;
                    if ((this.bco[i]).keyz[1] < 0 || (this.bco[i]).keyx[1] < 0)
                        bool = false;
                    if ((this.bco[i]).keyz[2] > 0 || (this.bco[i]).keyx[2] > 0)
                        bool = false;
                    if ((this.bco[i]).keyz[3] > 0 || (this.bco[i]).keyx[3] < 0)
                        bool = false;
                    if (!bool)
                        i = -1;
                }
                if (i != -1) {
                    loadstat(is_57_, string, (this.bco[i]).maxR, (this.bco[i]).roofat, (this.bco[i]).wh, i);
                    if (this.names[i].equals(""))
                        i = -1;
                }
                (this.m).loadnew = false;
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
    
    public void copycar() {
        this.swits[this.nlocars][0] = this.swits[this.ac][0];
        this.swits[this.nlocars][1] = this.swits[this.ac][1];
        this.swits[this.nlocars][2] = this.swits[this.ac][2];
        this.acelf[this.nlocars][0] = this.acelf[this.ac][0];
        this.acelf[this.nlocars][1] = this.acelf[this.ac][1];
        this.acelf[this.nlocars][2] = this.acelf[this.ac][2];
        this.handb[this.nlocars] = this.handb[this.ac];
        this.airs[this.nlocars] = this.airs[this.ac];
        this.airc[this.nlocars] = this.airc[this.ac];
        this.turn[this.nlocars] = this.turn[this.ac];
        this.grip[this.nlocars] = this.grip[this.ac];
        this.bounce[this.nlocars] = this.bounce[this.ac];
        this.simag[this.nlocars] = this.simag[this.ac];
        this.moment[this.nlocars] = this.moment[this.ac];
        this.comprad[this.nlocars] = this.comprad[this.ac];
        this.push[this.nlocars] = this.push[this.ac];
        this.revpush[this.nlocars] = this.revpush[this.ac];
        this.lift[this.nlocars] = this.lift[this.ac];
        this.revlift[this.nlocars] = this.revlift[this.ac];
        this.powerloss[this.nlocars] = this.powerloss[this.ac];
        this.flipy[this.nlocars] = this.flipy[this.ac];
        this.msquash[this.nlocars] = this.msquash[this.ac];
        this.clrad[this.nlocars] = this.clrad[this.ac];
        this.dammult[this.nlocars] = this.dammult[this.ac];
        this.maxmag[this.nlocars] = this.maxmag[this.ac];
        this.dishandle[this.nlocars] = this.dishandle[this.ac];
        this.outdam[this.nlocars] = this.outdam[this.ac];
        this.cclass[this.nlocars] = this.cclass[this.ac];
        this.enginsignature[this.nlocars] = this.enginsignature[this.ac];
        this.createdby[this.nlocars - 16] = this.createdby[this.ac - 16];
        this.publish[this.nlocars - 16] = this.publish[this.ac - 16];
        this.bco[this.nlocars] = new ContO(this.bco[this.ac], 0, 0, 0, 0);
        this.names[this.nlocars] = this.names[this.ac];
        this.nlocars++;
        this.names[this.ac] = "";
        if (this.ac > 36)
            this.lcardate[this.ac - 36] = 0;
    }
    
    public void loadmystages(CheckPoints checkpoints) {
        String[] strings = new String[20];
        int i = 0;
        String string = "";
        try {
            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/tracks/lists/").append((this.gs).tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
            DataInputStream datainputstream = new DataInputStream(url.openStream());
            while ((string = datainputstream.readLine()) != null) {
                string = new StringBuilder().append("").append(string.trim()).toString();
                if (string.startsWith("mystages")) {
                    boolean bool = true;
                    while (bool && i < 20) {
                        strings[i] = getSvalue("mystages", string, i);
                        if (strings[i].equals(""))
                            bool = false;
                        else
                            i++;
                    }
                }
            }
            if (i > 0)
                this.msloaded = 1;
            else
                this.msloaded = -2;
            datainputstream.close();
        } catch (Exception exception) {
            String string_60_ = new StringBuilder().append("").append(exception).toString();
            if (string_60_.indexOf("FileNotFound") != -1)
                this.msloaded = -2;
            else
                this.msloaded = -1;
        }
        if (this.msloaded == 1) {
            (this.gs).mstgs.hide();
            (this.gs).mstgs.removeAll();
            (this.gs).mstgs.add((this.gs).rd, "Select Stage");
            int i_61_ = 0;
            for (int i_62_ = 0; i_62_ < i; i_62_++) {
                (this.gs).mstgs.add((this.gs).rd, strings[i_62_]);
                if ((checkpoints).name.equals(strings[i_62_])) {
                    i_61_ = i_62_ + 1;
                    (checkpoints).top20 = 0;
                }
            }
            (this.gs).mstgs.select(i_61_);
            (this.gs).mstgs.show();
        }
        if (this.msloaded == -2) {
            (this.gs).mstgs.hide();
            (this.gs).mstgs.removeAll();
            (this.gs).mstgs.add((this.gs).rd, "You have not published or added any stages...");
            (this.gs).mstgs.select(0);
            (this.gs).mstgs.show();
        }
        if (this.msloaded == -1) {
            (this.gs).mstgs.hide();
            (this.gs).mstgs.removeAll();
            (this.gs).mstgs.add((this.gs).rd, "Failed to load stages, please try again later.");
            (this.gs).mstgs.select(0);
            (this.gs).mstgs.show();
        }
        System.gc();
    }
    
    public void loadtop20(int i) {
        String[] strings = new String[20];
        int i_63_ = 0;
        String string = "";
        try {
            String string_64_ = "A";
            if (i == 3)
                string_64_ = "W";
            if (i == 4)
                string_64_ = "M";
            URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/tracks/top20/").append(string_64_).append(".txt").toString());
            DataInputStream datainputstream = new DataInputStream(url.openStream());
            while ((string = datainputstream.readLine()) != null) {
                string = new StringBuilder().append("").append(string.trim()).toString();
                if (string.startsWith("stages")) {
                    boolean bool = true;
                    while (bool && i_63_ < 20) {
                        strings[i_63_] = getSvalue("stages", string, i_63_);
                        if (strings[i_63_].equals(""))
                            bool = false;
                        else
                            i_63_++;
                    }
                }
                if (string.startsWith("adds")) {
                    for (int i_65_ = 0; i_65_ < i_63_; i_65_++)
                        this.top20adds[i_65_] = getvalue("adds", string, i_65_);
                }
            }
            if (i_63_ > 0)
                this.msloaded = i;
            else
                this.msloaded = -2;
            datainputstream.close();
        } catch (Exception exception) {
            String string_66_ = new StringBuilder().append("").append(exception).toString();
            if (string_66_.indexOf("FileNotFound") != -1)
                this.msloaded = -2;
            else
                this.msloaded = -1;
        }
        if (this.msloaded == i) {
            (this.gs).mstgs.hide();
            (this.gs).mstgs.removeAll();
            (this.gs).mstgs.add((this.gs).rd, "Select Stage");
            for (int i_67_ = 0; i_67_ < i_63_; i_67_++)
                (this.gs).mstgs.add((this.gs).rd, new StringBuilder().append("N#").append(i_67_ + 1).append(" ").append(strings[i_67_]).toString());
            (this.gs).mstgs.select(0);
            (this.gs).mstgs.show();
        }
        if (this.msloaded == -1 || this.msloaded == -2) {
            (this.gs).mstgs.hide();
            (this.gs).mstgs.removeAll();
            (this.gs).mstgs.add((this.gs).rd, "Failed to load Top20 list, please try again later.");
            (this.gs).mstgs.select(0);
            (this.gs).mstgs.show();
        }
        System.gc();
    }
    
    public void loadstagemaker() {
        (this.gs).mstgs.hide();
        (this.gs).mstgs.removeAll();
        (this.gs).mstgs.add((this.gs).rd, "Select Stage");
        int i = 0;
        File file = new File("mystages/");
        if (file.exists()) {
            String[] strings = new File("mystages/").list();
            for (int i_68_ = 0; i_68_ < strings.length; i_68_++) {
                if (strings[i_68_].toLowerCase().endsWith(".txt") && i < 2000) {
                    (this.gs).mstgs.add((this.gs).rd, strings[i_68_].substring(0, strings[i_68_].length() - 4));
                    i++;
                }
            }
        }
        if (i != 0)
            this.msloaded = 2;
        else {
            (this.gs).mstgs.add((this.gs).rd, "No stages where found in your 'mystages' folder.");
            this.msloaded = -1;
        }
        (this.gs).mstgs.select(0);
        (this.gs).mstgs.show();
    }
    
    public void loadcarmaker() {
        (this.m).csky[0] = 170;
        (this.m).csky[1] = 220;
        (this.m).csky[2] = 255;
        (this.m).cfade[0] = 255;
        (this.m).cfade[1] = 220;
        (this.m).cfade[2] = 220;
        (this.m).snap[0] = 0;
        (this.m).snap[1] = 0;
        (this.m).snap[2] = 0;
        for (int i = 0; i < 40; i++)
            this.include[i] = false;
        this.nlcars = 16;
        File file = new File("mycars/");
        if (file.exists()) {
            String[] strings = new File("mycars/").list();
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].toLowerCase().endsWith(".rad") && this.nlcars < 56 && loadcar(strings[i].substring(0, strings[i].length() - 4), this.nlcars) == this.nlcars)
                    this.nlcars++;
            }
        }
        System.gc();
        if (this.nlcars > 16)
            this.lastload = 1;
    }
    
    public int loadcar(String string, int i) {
        try {
            File file = new File(new StringBuilder().append("mycars/").append(string).append(".rad").toString());
            if (file.exists()) {
                String string_69_ = "";
                BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                Object object = null;
                String string_70_;
                while ((string_70_ = bufferedreader.readLine()) != null)
                string_69_ = new StringBuilder().append(string_69_).append("").append(string_70_).append("\n").toString();
                bufferedreader.close();
                Object object_71_ = null;
                (this.m).loadnew = true;
                this.bco[i] = new ContO(string_69_.getBytes(), this.m, this.t);
                if ((this.bco[i]).errd || (this.bco[i]).npl <= 60)
                    i = -1;
                if (i != -1) {
                    (this.bco[i]).shadow = true;
                    (this.bco[i]).noline = false;
                    (this.bco[i]).decor = false;
                    (this.bco[i]).tnt = 0;
                    (this.bco[i]).disp = 0;
                    (this.bco[i]).disline = 7;
                    (this.bco[i]).grounded = 1.0F;
                    boolean bool = true;
                    if ((this.bco[i]).keyz[0] < 0 || (this.bco[i]).keyx[0] > 0)
                        bool = false;
                    if ((this.bco[i]).keyz[1] < 0 || (this.bco[i]).keyx[1] < 0)
                        bool = false;
                    if ((this.bco[i]).keyz[2] > 0 || (this.bco[i]).keyx[2] > 0)
                        bool = false;
                    if ((this.bco[i]).keyz[3] > 0 || (this.bco[i]).keyx[3] < 0)
                        bool = false;
                    if (!bool)
                        i = -1;
                }
                if (i != -1) {
                    loadstat(string_69_.getBytes(), string, (this.bco[i]).maxR, (this.bco[i]).roofat, (this.bco[i]).wh, i);
                    if (this.names[i].equals(""))
                        i = -1;
                }
                (this.m).loadnew = false;
            } else
                i = -1;
        } catch (Exception exception) {
            i = -1;
            System.out.println(new StringBuilder().append("Error Loading Car: ").append(exception).toString());
        }
        System.gc();
        return i;
    }
}
