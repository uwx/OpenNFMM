
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
    Trackers t;
    GameSparker gs;
    ContO[] bco;
    Medium m;
    Thread carloader;
    Thread actionloader;
    Thread stageaction;
    int[][] swits = {
            {
                    50, 185, 282
            }, {
                    100, 200, 310
            }, {
                    60, 180, 275
            }, {
                    76, 195, 298
            }, {
                    70, 170, 275
            }, {
                    70, 202, 293
            }, {
                    60, 170, 289
            }, {
                    70, 206, 291
            }, {
                    90, 210, 295
            }, {
                    90, 190, 276
            }, {
                    70, 200, 295
            }, {
                    50, 160, 270
            }, {
                    90, 200, 305
            }, {
                    50, 130, 210
            }, {
                    80, 200, 300
            }, {
                    70, 210, 290
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }, {
                    0, 0, 0
            }
    };
    float[][] acelf = {
            {
                    11.0F, 5.0F, 3.0F
            }, {
                    14.0F, 7.0F, 5.0F
            }, {
                    10.0F, 5.0F, 3.5F
            }, {
                    11.0F, 6.0F, 3.5F
            }, {
                    10.0F, 5.0F, 3.5F
            }, {
                    12.0F, 6.0F, 3.0F
            }, {
                    7.0F, 9.0F, 4.0F
            }, {
                    11.0F, 5.0F, 3.0F
            }, {
                    12.0F, 7.0F, 4.0F
            }, {
                    12.0F, 7.0F, 3.5F
            }, {
                    11.5F, 6.5F, 3.5F
            }, {
                    9.0F, 5.0F, 3.0F
            }, {
                    13.0F, 7.0F, 4.5F
            }, {
                    7.5F, 3.5F, 3.0F
            }, {
                    11.0F, 7.5F, 4.0F
            }, {
                    12.0F, 6.0F, 3.5F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }, {
                    0.0F, 0.0F, 0.0F
            }
    };
    int[] handb = {
            7, 10, 7, 15, 12, 8, 9, 10, 5, 7, 8, 10, 8, 12, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    float[] airs = {
            1.0F, 1.2F, 0.95F, 1.0F, 2.2F, 1.0F, 0.9F, 0.8F, 1.0F, 0.9F, 1.15F, 0.8F, 1.0F, 0.3F, 1.3F, 1.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F
    };
    int[] airc = {
            70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] turn = {
            6, 9, 5, 7, 8, 7, 5, 5, 9, 7, 7, 4, 6, 5, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    float[] grip = {
            20.0F, 27.0F, 18.0F, 22.0F, 19.0F, 20.0F, 25.0F, 20.0F, 19.0F, 24.0F, 22.5F, 25.0F, 30.0F, 27.0F, 25.0F,
            27.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F
    };
    float[] bounce = {
            1.2F, 1.05F, 1.3F, 1.15F, 1.3F, 1.2F, 1.15F, 1.1F, 1.2F, 1.1F, 1.15F, 0.8F, 1.05F, 0.8F, 1.1F, 1.15F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F
    };
    float[] simag = {
            0.9F, 0.85F, 1.05F, 0.9F, 0.85F, 0.9F, 1.05F, 0.9F, 1.0F, 1.05F, 0.9F, 1.1F, 0.9F, 1.3F, 0.9F, 1.15F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F
    };
    float[] moment = {
            1.3F, 0.75F, 1.4F, 1.2F, 1.1F, 1.38F, 1.43F, 1.48F, 1.35F, 1.7F, 1.42F, 2.0F, 1.26F, 3.0F, 1.5F, 2.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F
    };
    float[] comprad = {
            0.5F, 0.4F, 0.8F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5F, 0.5F, 0.8F, 0.5F, 1.5F, 0.5F, 0.8F, 0.5F, 0.8F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F
    };
    int[] push = {
            2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] revpush = {
            2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] lift = {
            0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] revlift = {
            0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] powerloss = {
            2500000, 2500000, 3500000, 2500000, 4000000, 2500000, 3200000, 3200000, 2750000, 5500000, 2750000, 4500000,
            3500000, 16700000, 3000000, 5500000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] flipy = {
            -50, -60, -92, -44, -60, -57, -54, -60, -77, -57, -82, -85, -28, -100, -63, -127, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] msquash = {
            7, 4, 7, 2, 8, 4, 6, 4, 3, 8, 4, 10, 3, 20, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] clrad = {
            3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000, 15000, 4000, 7000, 10000, 15000, 5500, 5000, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0
    };
    float[] dammult = {
            0.75F, 0.8F, 0.45F, 0.8F, 0.42F, 0.7F, 0.72F, 0.6F, 0.58F, 0.41F, 0.67F, 0.45F, 0.61F, 0.25F, 0.38F, 0.52F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F
    };
    int[] maxmag = {
            7600, 4200, 7200, 6000, 6000, 15000, 17200, 17000, 18000, 11000, 19000, 10700, 13000, 45000, 5800, 18000, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0
    };
    float[] dishandle = {
            0.65F, 0.6F, 0.55F, 0.77F, 0.62F, 0.9F, 0.6F, 0.72F, 0.45F, 0.8F, 0.95F, 0.4F, 0.87F, 0.42F, 1.0F, 0.95F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F
    };
    float[] outdam = {
            0.68F, 0.35F, 0.8F, 0.5F, 0.42F, 0.76F, 0.82F, 0.76F, 0.72F, 0.62F, 0.79F, 0.95F, 0.77F, 1.0F, 0.85F, 1.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
            0.0F, 0.0F, 0.0F, 0.0F
    };
    int[] cclass = {
            0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    String[] names = {
            "Tornado Shark", "Formula 7", "Wow Caninaro", "La Vita Crab", "Nimi", "MAX Revenge", "Lead Oxide",
            "Kool Kat", "Drifter X", "Sword of Justice", "High Rider", "EL KING", "Mighty Eight", "M A S H E E N",
            "Radical One", "DR Monstaa", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
    };
    int[] enginsignature = {
            0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
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
    int[] lcardate = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int haltload = 0;
    int onloadingcar = 0;
    int ac = -1;
    String acname = "Radical One";
    String fails = "";
    String tnickey = "";
    String tclan = "";
    String tclankey = "";
    int loadlist = 0;
    int[] adds = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    String viewname = "";
    int staction = 0;
    String onstage = "";
    int inslot = -1;
    int roundslot = 0;
    String lastcar = "";
    int msloaded = 0;
    int[] top20adds = new int[20];

    public CarDefine(final ContO[] contos, final Medium medium, final Trackers trackers,
            final GameSparker gamesparker) {
        bco = contos;
        m = medium;
        t = trackers;
        gs = gamesparker;
    }

    public void loadstat(final byte[] is, final String string, final int i, final int i0, final int i1,
            final int i2) {
        names[i2] = string;
        boolean bool = false;
        boolean bool3 = false;
        String string4 = "";
        final int[] is5 = {
                128, 128, 128, 128, 128
        };
        int i6 = 640;
        final int[] is7 = {
                50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50
        };
        final int[] is8 = {
                50, 50, 50
        };
        enginsignature[i2] = 0;
        float f = 0.0F;
        publish[i2 - 16] = 0;
        createdby[i2 - 16] = "Unkown User";
        try {
            final DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(is));
            while ((string4 = datainputstream.readLine()) != null) {
                string4 = string4.trim();
                if (string4.startsWith("stat("))
                    try {
                        i6 = 0;
                        for (int i9 = 0; i9 < 5; i9++) {
                            is5[i9] = getvalue("stat", string4, i9);
                            if (is5[i9] > 200)
                                is5[i9] = 200;
                            if (is5[i9] < 16)
                                is5[i9] = 16;
                            i6 += is5[i9];
                        }
                        bool = true;
                    } catch (final Exception exception) {
                        bool = false;
                    }
                if (string4.startsWith("physics("))
                    try {
                        for (int i10 = 0; i10 < 11; i10++) {
                            is7[i10] = getvalue("physics", string4, i10);
                            if (is7[i10] > 100)
                                is7[i10] = 100;
                            if (is7[i10] < 0)
                                is7[i10] = 0;
                        }
                        for (int i11 = 0; i11 < 3; i11++) {
                            is8[i11] = getvalue("physics", string4, i11 + 11);
                            if (i11 != 0 && is8[i11] > 100)
                                is8[i11] = 100;
                            if (is8[i11] < 0)
                                is8[i11] = 0;
                        }
                        enginsignature[i2] = getvalue("physics", string4, 14);
                        if (enginsignature[i2] > 4)
                            enginsignature[i2] = 0;
                        if (enginsignature[i2] < 0)
                            enginsignature[i2] = 0;
                        f = getvalue("physics", string4, 15);
                        if (f > 0.0F)
                            bool3 = true;
                    } catch (final Exception exception) {
                        bool3 = false;
                    }
                if (string4.startsWith("handling("))
                    try {
                        int i12 = getvalue("handling", string4, 0);
                        if (i12 > 200)
                            i12 = 200;
                        if (i12 < 50)
                            i12 = 50;
                        dishandle[i2] = i12 / 200.0F;
                    } catch (final Exception exception) {
                        /* empty */
                    }
                if (string4.startsWith("carmaker("))
                    createdby[i2 - 16] = getSvalue("carmaker", string4, 0);
                if (string4.startsWith("publish("))
                    publish[i2 - 16] = getvalue("publish", string4, 0);
            }
            datainputstream.close();
        } catch (final Exception exception) {
            System.out.println(new StringBuilder().append("Error Loading Car Stat: ").append(exception).toString());
        }
        if (bool && bool3) {
            int i13 = 0;
            if (i6 > 680)
                i13 = 680 - i6;
            if (i6 > 640 && i6 < 680)
                i13 = 640 - i6;
            if (i6 > 600 && i6 < 640)
                i13 = 600 - i6;
            if (i6 > 560 && i6 < 600)
                i13 = 560 - i6;
            if (i6 > 520 && i6 < 560)
                i13 = 520 - i6;
            if (i6 < 520)
                i13 = 520 - i6;
            while (i13 != 0)
                for (int i14 = 0; i14 < 5; i14++) {
                    if (i13 > 0 && is5[i14] < 200) {
                        is5[i14]++;
                        i13--;
                    }
                    if (i13 < 0 && is5[i14] > 16) {
                        is5[i14]--;
                        i13++;
                    }
                }
            i6 = 0;
            for (int i15 = 0; i15 < 5; i15++)
                i6 += is5[i15];
            if (i6 == 520)
                cclass[i2] = 0;
            if (i6 == 560)
                cclass[i2] = 1;
            if (i6 == 600)
                cclass[i2] = 2;
            if (i6 == 640)
                cclass[i2] = 3;
            if (i6 == 680)
                cclass[i2] = 4;
            int i16 = 0;
            int i17 = 0;
            float f18 = 0.5F;
            if (is5[0] == 200) {
                i16 = 1;
                i17 = 1;
            }
            if (is5[0] > 192 && is5[0] < 200) {
                i16 = 12;
                i17 = 1;
                f18 = (is5[0] - 192) / 8.0F;
            }
            if (is5[0] == 192) {
                i16 = 12;
                i17 = 12;
            }
            if (is5[0] > 148 && is5[0] < 192) {
                i16 = 14;
                i17 = 12;
                f18 = (is5[0] - 148) / 44.0F;
            }
            if (is5[0] == 148) {
                i16 = 14;
                i17 = 14;
            }
            if (is5[0] > 133 && is5[0] < 148) {
                i16 = 10;
                i17 = 14;
                f18 = (is5[0] - 133) / 15.0F;
            }
            if (is5[0] == 133) {
                i16 = 10;
                i17 = 10;
            }
            if (is5[0] > 112 && is5[0] < 133) {
                i16 = 15;
                i17 = 10;
                f18 = (is5[0] - 112) / 21.0F;
            }
            if (is5[0] == 112) {
                i16 = 15;
                i17 = 15;
            }
            if (is5[0] > 107 && is5[0] < 112) {
                i16 = 11;
                i17 = 15;
                f18 = (is5[0] - 107) / 5.0F;
            }
            if (is5[0] == 107) {
                i16 = 11;
                i17 = 11;
            }
            if (is5[0] > 88 && is5[0] < 107) {
                i16 = 13;
                i17 = 11;
                f18 = (is5[0] - 88) / 19.0F;
            }
            if (is5[0] == 88) {
                i16 = 13;
                i17 = 13;
            }
            if (is5[0] > 88) {
                swits[i2][0] = (int) ((swits[i17][0] - swits[i16][0]) * f18 + swits[i16][0]);
                swits[i2][1] = (int) ((swits[i17][1] - swits[i16][1]) * f18 + swits[i16][1]);
                swits[i2][2] = (int) ((swits[i17][2] - swits[i16][2]) * f18 + swits[i16][2]);
            } else {
                f18 = is5[0] / 88.0F;
                if (f18 < 0.76)
                    f18 = 0.76F;
                swits[i2][0] = (int) (50.0F * f18);
                swits[i2][1] = (int) (130.0F * f18);
                swits[i2][2] = (int) (210.0F * f18);
            }
            i16 = 0;
            i17 = 0;
            f18 = 0.5F;
            if (is5[1] == 200) {
                i16 = 1;
                i17 = 1;
            }
            if (is5[1] > 150 && is5[1] < 200) {
                i16 = 14;
                i17 = 1;
                f18 = (is5[1] - 150) / 50.0F;
            }
            if (is5[1] == 150) {
                i16 = 14;
                i17 = 14;
            }
            if (is5[1] > 144 && is5[1] < 150) {
                i16 = 9;
                i17 = 14;
                f18 = (is5[1] - 144) / 6.0F;
            }
            if (is5[1] == 144) {
                i16 = 9;
                i17 = 9;
            }
            if (is5[1] > 139 && is5[1] < 144) {
                i16 = 6;
                i17 = 9;
                f18 = (is5[1] - 139) / 5.0F;
            }
            if (is5[1] == 139) {
                i16 = 6;
                i17 = 6;
            }
            if (is5[1] > 128 && is5[1] < 139) {
                i16 = 15;
                i17 = 6;
                f18 = (is5[1] - 128) / 11.0F;
            }
            if (is5[1] == 128) {
                i16 = 15;
                i17 = 15;
            }
            if (is5[1] > 122 && is5[1] < 128) {
                i16 = 10;
                i17 = 15;
                f18 = (is5[1] - 122) / 6.0F;
            }
            if (is5[1] == 122) {
                i16 = 10;
                i17 = 10;
            }
            if (is5[1] > 119 && is5[1] < 122) {
                i16 = 3;
                i17 = 10;
                f18 = (is5[1] - 119) / 3.0F;
            }
            if (is5[1] == 119) {
                i16 = 3;
                i17 = 3;
            }
            if (is5[1] > 98 && is5[1] < 119) {
                i16 = 5;
                i17 = 3;
                f18 = (is5[1] - 98) / 21.0F;
            }
            if (is5[1] == 98) {
                i16 = 5;
                i17 = 5;
            }
            if (is5[1] > 81 && is5[1] < 98) {
                i16 = 0;
                i17 = 5;
                f18 = (is5[1] - 81) / 17.0F;
            }
            if (is5[1] == 81) {
                i16 = 0;
                i17 = 0;
            }
            if (is5[1] <= 80) {
                i16 = 2;
                i17 = 2;
            }
            if (is5[0] <= 88) {
                i16 = 13;
                i17 = 13;
            }
            acelf[i2][0] = (acelf[i17][0] - acelf[i16][0]) * f18 + acelf[i16][0];
            acelf[i2][1] = (acelf[i17][1] - acelf[i16][1]) * f18 + acelf[i16][1];
            acelf[i2][2] = (acelf[i17][2] - acelf[i16][2]) * f18 + acelf[i16][2];
            if (is5[1] <= 70 && is5[0] > 88) {
                acelf[i2][0] = 9.0F;
                acelf[i2][1] = 4.0F;
                acelf[i2][2] = 3.0F;
            }
            f18 = (is5[2] - 88) / 109.0F;
            if (f18 > 1.0F)
                f18 = 1.0F;
            if (f18 < -0.55)
                f18 = -0.55F;
            airs[i2] = 0.55F + 0.45F * f18 + 0.4F * (is7[9] / 100.0F);
            if (airs[i2] < 0.3)
                airs[i2] = 0.3F;
            airc[i2] = (int) (10.0F + 70.0F * f18 + 30.0F * (is7[10] / 100.0F));
            if (airc[i2] < 0)
                airc[i2] = 0;
            int i19 = (int) (670.0F - (is7[9] + is7[10]) / 200.0F * 420.0F);
            if (is5[0] <= 88)
                i19 = (int) (1670.0F - (is7[9] + is7[10]) / 200.0F * 1420.0F);
            if (is5[2] > 190 && i19 < 300)
                i19 = 300;
            powerloss[i2] = i19 * 10000;
            moment[i2] = 0.7F + (is5[3] - 16) / 184.0F * 1.0F;
            if (is5[0] < 110)
                moment[i2] = 0.75F + (is5[3] - 16) / 184.0F * 1.25F;
            if (is5[3] == 200 && is5[4] == 200 && is5[0] <= 88)
                moment[i2] = 3.0F;
            float f20 = 0.9F + (is5[4] - 90) * 0.01F;
            if (f20 < 0.6)
                f20 = 0.6F;
            if (is5[4] == 200 && is5[0] <= 88)
                f20 = 3.0F;
            maxmag[i2] = (int) (f * f20);
            outdam[i2] = 0.35F + (f20 - 0.6F) * 0.5F;
            if (outdam[i2] < 0.35)
                outdam[i2] = 0.35F;
            if (outdam[i2] > 1.0F)
                outdam[i2] = 1.0F;
            clrad[i2] = (int) (is8[0] * is8[0] * 1.5);
            if (clrad[i2] < 1000)
                clrad[i2] = 1000;
            dammult[i2] = 0.3F + is8[1] * 0.005F;
            msquash[i2] = (int) (2.0 + is8[2] / 7.6);
            flipy[i2] = i0;
            handb[i2] = (int) (7.0F + is7[0] / 100.0F * 8.0F);
            turn[i2] = (int) (4.0F + is7[1] / 100.0F * 6.0F);
            grip[i2] = 16.0F + is7[2] / 100.0F * 14.0F;
            if (grip[i2] < 21.0F) {
                swits[i2][0] += 40.0F * ((21.0F - grip[i2]) / 5.0F);
                if (swits[i2][0] > 100)
                    swits[i2][0] = 100;
            }
            bounce[i2] = 0.8F + is7[3] / 100.0F * 0.6F;
            if (is7[3] > 67) {
                airs[i2] *= 0.76F + (1.0F - is7[3] / 100.0F) * 0.24F;
                airc[i2] *= 0.76F + (1.0F - is7[3] / 100.0F) * 0.24F;
            }
            lift[i2] = (int) ((float) is7[5] * (float) is7[5] / 10000.0F * 30.0F);
            revlift[i2] = (int) (is7[6] / 100.0F * 32.0F);
            push[i2] = (int) (2.0F + is7[7] / 100.0F * 2.0F * ((30 - lift[i2]) / 30));
            revpush[i2] = (int) (1.0F + is7[8] / 100.0F * 2.0F);
            comprad[i2] = i / 400.0F + (is5[3] - 16) / 184.0F * 0.2F;
            if (comprad[i2] < 0.4)
                comprad[i2] = 0.4F;
            simag[i2] = (i1 - 17) * 0.0167F + 0.85F;
        } else
            names[i2] = "";
    }

    public int getvalue(final String string, final String string21, final int i) {
        int i22 = 0;
        String string23 = "";
        for (int i24 = string.length() + 1; i24 < string21.length(); i24++) {
            final String string25 = new StringBuilder().append("").append(string21.charAt(i24)).toString();
            if (string25.equals(",") || string25.equals(")")) {
                i22++;
                i24++;
            }
            if (i22 == i)
                string23 = new StringBuilder().append(string23).append(string21.charAt(i24)).toString();
        }
        return Float.valueOf(string23).intValue();
    }

    public String getSvalue(final String string, final String string26, final int i) {
        String string27 = "";
        int i28 = 0;
        for (int i29 = string.length() + 1; i29 < string26.length() && i28 <= i; i29++) {
            final String string30 = new StringBuilder().append("").append(string26.charAt(i29)).toString();
            if (string30.equals(",") || string30.equals(")"))
                i28++;
            else if (i28 == i)
                string27 = new StringBuilder().append(string27).append(string30).toString();
        }
        return string27;
    }

    public int servervalue(final String string, final int i) {
        int i31 = -1;
        try {
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            String string35 = "";
            String string36 = "";
            for (/**/; i32 < string.length() && i34 != 2; i32++) {
                string35 = new StringBuilder().append("").append(string.charAt(i32)).toString();
                if (string35.equals("|")) {
                    i33++;
                    if (i34 == 1 || i33 > i)
                        i34 = 2;
                } else if (i33 == i) {
                    string36 = new StringBuilder().append(string36).append(string35).toString();
                    i34 = 1;
                }
            }
            if (string36.equals(""))
                string36 = "-1";
            i31 = Integer.valueOf(string36).intValue();
        } catch (final Exception exception) {
            /* empty */
        }
        return i31;
    }

    public String serverSvalue(final String string, final int i) {
        String string37 = "";
        try {
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            String string41 = "";
            String string42 = "";
            for (/**/; i38 < string.length() && i40 != 2; i38++) {
                string41 = new StringBuilder().append("").append(string.charAt(i38)).toString();
                if (string41.equals("|")) {
                    i39++;
                    if (i40 == 1 || i39 > i)
                        i40 = 2;
                } else if (i39 == i) {
                    string42 = new StringBuilder().append(string42).append(string41).toString();
                    i40 = 1;
                }
            }
            string37 = string42;
        } catch (final Exception exception) {
            /* empty */
        }
        return string37;
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
        fails = "";
        for (int i = 0; i < 20; i++)
            loadnames[i] = "";
        nl = 0;
        action = 0;
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
            carloader.stop();
            carloader = null;
        }
        if (actionloader != null) {
            actionloader.stop();
            actionloader = null;
        }
        if (stageaction != null) {
            stageaction.stop();
            stageaction = null;
        }
    }

    @Override
    public void run() {
        if (Thread.currentThread() == actionloader) {
            if (action == 10) {
                int i = -1;
                try {
                    final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedreader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("9|").append(gs.tnick.getText()).append("|")
                            .append(gs.tpass.getText()).append("|").append(names[ac]).append("|").toString());
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
                    final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedreader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("1|").append(gs.tnick.getText()).append("|")
                            .append(gs.tpass.getText()).append("|").toString());
                    final String string = bufferedreader.readLine();
                    if (string != null) {
                        reco = servervalue(string, 0);
                        if (reco == 0 || reco == 3 || reco > 10) {
                            tnickey = serverSvalue(string, 1);
                            if (reco != -167) {
                                tclan = serverSvalue(string, 2);
                                tclankey = serverSvalue(string, 3);
                            } else {
                                tclan = "";
                                tclankey = "";
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
            while (action == 2) {
                /* empty */
            }
            if (action == 3) {
                final String[] strings = new String[700];
                nl = 0;
                String string = "";
                try {
                    final URL url = new URL(new StringBuilder()
                            .append("http://multiplayer.needformadness.com/cars/lists/").append(gs.tnick.getText())
                            .append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                    final DataInputStream datainputstream = new DataInputStream(url.openStream());
                    while ((string = datainputstream.readLine()) != null) {
                        string = new StringBuilder().append("").append(string.trim()).toString();
                        if (string.startsWith("mycars")) {
                            boolean bool = true;
                            while (bool && nl < 700) {
                                strings[nl] = getSvalue("mycars", string, nl);
                                if (strings[nl].equals(""))
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
                    final String string43 = new StringBuilder().append("").append(exception).toString();
                    if (string43.indexOf("FileNotFound") != -1)
                        action = -1;
                    else
                        action = -2;
                }
                if (action == 4) {
                    gs.mcars.setVisible(false);
                    gs.mcars.removeAll();
                    for (int i = 0; i < nl; i++)
                        gs.mcars.add(gs.rd, strings[i]);
                    if (lastcar.equals(""))
                        gs.mcars.select(0);
                    else {
                        gs.mcars.select(lastcar);
                        lastcar = "";
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
                    final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedreader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("8|").append(gs.tnick.getText()).append("|")
                            .append(gs.tpass.getText()).append("|").append(acname).append("|").toString());
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
                String string = "";
                try {
                    String string44 = "all";
                    if (loadlist == 1)
                        string44 = "Wall";
                    if (loadlist == 2)
                        string44 = "WA";
                    if (loadlist == 3)
                        string44 = "WAB";
                    if (loadlist == 4)
                        string44 = "WB";
                    if (loadlist == 5)
                        string44 = "WBC";
                    if (loadlist == 6)
                        string44 = "WC";
                    if (loadlist == 7)
                        string44 = "Mall";
                    if (loadlist == 8)
                        string44 = "MA";
                    if (loadlist == 9)
                        string44 = "MAB";
                    if (loadlist == 10)
                        string44 = "MB";
                    if (loadlist == 11)
                        string44 = "MBC";
                    if (loadlist == 12)
                        string44 = "MC";
                    if (loadlist == 13)
                        string44 = "Sall";
                    if (loadlist == 14)
                        string44 = "SA";
                    if (loadlist == 15)
                        string44 = "SAB";
                    if (loadlist == 16)
                        string44 = "SB";
                    if (loadlist == 17)
                        string44 = "SBC";
                    if (loadlist == 18)
                        string44 = "SC";
                    if (loadlist == 19)
                        string44 = "Aall";
                    if (loadlist == 20)
                        string44 = "AA";
                    if (loadlist == 21)
                        string44 = "AAB";
                    if (loadlist == 22)
                        string44 = "AB";
                    if (loadlist == 23)
                        string44 = "ABC";
                    if (loadlist == 24)
                        string44 = "AC";
                    final URL url = new URL(
                            new StringBuilder().append("http://multiplayer.needformadness.com/cars/top20/")
                                    .append(string44).append(".txt").toString());
                    final DataInputStream datainputstream = new DataInputStream(url.openStream());
                    while ((string = datainputstream.readLine()) != null) {
                        string = new StringBuilder().append("").append(string.trim()).toString();
                        if (string.startsWith("cars")) {
                            boolean bool = true;
                            while (bool && nl < 20) {
                                loadnames[nl] = getSvalue("cars", string, nl);
                                if (loadnames[nl].equals(""))
                                    bool = false;
                                else
                                    nl++;
                            }
                        }
                        if (string.startsWith("adds"))
                            for (int i = 0; i < nl; i++)
                                adds[i] = getvalue("adds", string, i);
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
                String string = "";
                try {
                    final URL url = new URL(new StringBuilder()
                            .append("http://multiplayer.needformadness.com/cars/lists/").append(viewname)
                            .append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                    final DataInputStream datainputstream = new DataInputStream(url.openStream());
                    while ((string = datainputstream.readLine()) != null) {
                        string = new StringBuilder().append("").append(string.trim()).toString();
                        if (string.startsWith("mycars")) {
                            boolean bool = true;
                            while (bool && nl < 20) {
                                loadnames[nl] = getSvalue("mycars", string, nl);
                                if (loadnames[nl].equals(""))
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
                    final String string45 = new StringBuilder().append("").append(exception).toString();
                    if (string45.indexOf("FileNotFound") != -1)
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
            while (nl > 0) {
                int i = 0;
                for (int i46 = 16; i46 < 56; i46++)
                    if (loadnames[nl - 1].equals(names[i46]))
                        i = -1;
                if (fails.indexOf(
                        new StringBuilder().append("|").append(loadnames[nl - 1]).append("|").toString()) != -1)
                    i = -1;
                if (i != -1) {
                    int i47 = lcardate[0];
                    int i48 = 36;
                    if (haltload > 0) {
                        i48 = 36 + haltload;
                        i47 = lcardate[haltload];
                    }
                    i = i48;
                    for (int i49 = i48; i49 < 56; i49++)
                        if (lcardate[i49 - 36] < i47) {
                            i47 = lcardate[i49 - 36];
                            i = i49;
                        }
                    onloadingcar = i - 35;
                    if (loadonlinecar(loadnames[nl - 1], i) == -1) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final CarDefine cardefine50 = this;
                        cardefine50.fails = stringbuilder.append(cardefine50.fails).append("|")
                                .append(loadnames[nl - 1]).append("|").toString();
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
                    final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedreader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("19|").append(gs.tnick.getText()).append("|")
                            .append(gs.tpass.getText()).append("|").append(onstage).append("|").toString());
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
                    final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                    final BufferedReader bufferedreader = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                    printwriter.println(new StringBuilder().append("1|").append(gs.tnick.getText()).append("|")
                            .append(gs.tpass.getText()).append("|").toString());
                    final String string = bufferedreader.readLine();
                    if (string != null) {
                        reco = servervalue(string, 0);
                        if (reco == 0 || reco == 3 || reco > 10) {
                            tnickey = serverSvalue(string, 1);
                            if (reco != -167) {
                                tclan = serverSvalue(string, 2);
                                tclankey = serverSvalue(string, 3);
                            } else {
                                tclan = "";
                                tclankey = "";
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
                while (staction == 5) {
                    /* empty */
                }
            }
            if (staction == 2) {
                int i = -1;
                if (msloaded == 1)
                    for (int i51 = 1; i51 < gs.mstgs.getItemCount(); i51++)
                        if (gs.mstgs.getItem(i51).equals(onstage))
                            i = 3;
                if (i == -1)
                    try {
                        final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                        final BufferedReader bufferedreader = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
                        final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                        printwriter.println(new StringBuilder().append("18|").append(gs.tnick.getText()).append("|")
                                .append(gs.tpass.getText()).append("|").append(onstage).append("|").toString());
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

    public int loadonlinecar(final String string, int i) {
        try {
            String string52 = new StringBuilder().append("http://multiplayer.needformadness.com/cars/").append(string)
                    .append(".radq").toString();
            string52 = string52.replace(' ', '_');
            final URL url = new URL(string52);
            final int i53 = url.openConnection().getContentLength();
            final DataInputStream datainputstream = new DataInputStream(url.openStream());
            final byte[] is = new byte[i53];
            datainputstream.readFully(is);
            ZipInputStream zipinputstream;
            if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
            else {
                final byte[] is54 = new byte[i53 - 40];
                for (int i55 = 0; i55 < i53 - 40; i55++) {
                    int i56 = 20;
                    if (i55 >= 500)
                        i56 = 40;
                    is54[i55] = is[i55 + i56];
                }
                zipinputstream = new ZipInputStream(new ByteArrayInputStream(is54));
            }
            final ZipEntry zipentry = zipinputstream.getNextEntry();
            if (zipentry != null) {
                int i57 = Integer.valueOf(zipentry.getName()).intValue();
                final byte[] is58 = new byte[i57];
                int i59 = 0;
                int i60;
                for (/**/; i57 > 0; i57 -= i60) {
                    i60 = zipinputstream.read(is58, i59, i57);
                    i59 += i60;
                }
                m.loadnew = true;
                bco[i] = new ContO(is58, m, t);
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
                    loadstat(is58, string, bco[i].maxR, bco[i].roofat, bco[i].wh, i);
                    if (names[i].equals(""))
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

    public void loadmystages(final CheckPoints checkpoints) {
        final String[] strings = new String[700];
        int i = 0;
        String string = "";
        try {
            final URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/tracks/lists/")
                    .append(gs.tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("")
                    .toString());
            final DataInputStream datainputstream = new DataInputStream(url.openStream());
            while ((string = datainputstream.readLine()) != null) {
                string = new StringBuilder().append("").append(string.trim()).toString();
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
                msloaded = 1;
            else
                msloaded = -2;
            datainputstream.close();
        } catch (final Exception exception) {
            final String string61 = new StringBuilder().append("").append(exception).toString();
            if (string61.indexOf("FileNotFound") != -1)
                msloaded = -2;
            else
                msloaded = -1;
        }
        if (msloaded == 1) {
            gs.mstgs.setVisible(false);
            gs.mstgs.removeAll();
            gs.mstgs.add(gs.rd, "Select Stage");
            int i62 = 0;
            for (int i63 = 0; i63 < i; i63++) {
                gs.mstgs.add(gs.rd, strings[i63]);
                if (checkpoints.name.equals(strings[i63])) {
                    i62 = i63 + 1;
                    checkpoints.top20 = 0;
                }
            }
            gs.mstgs.select(i62);
            gs.mstgs.setVisible(true);
        }
        if (msloaded == -2) {
            gs.mstgs.setVisible(false);
            gs.mstgs.removeAll();
            gs.mstgs.add(gs.rd, "You have not published or added any stages...");
            gs.mstgs.select(0);
            gs.mstgs.setVisible(true);
        }
        if (msloaded == -1) {
            gs.mstgs.setVisible(false);
            gs.mstgs.removeAll();
            gs.mstgs.add(gs.rd, "Failed to load stages, please try again later.");
            gs.mstgs.select(0);
            gs.mstgs.setVisible(true);
        }
        System.gc();
    }

    public void loadtop20(final int i) {
        final String[] strings = new String[20];
        int i64 = 0;
        String string = "";
        try {
            String string65 = "A";
            if (i == 3)
                string65 = "W";
            if (i == 4)
                string65 = "M";
            final URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/tracks/top20/")
                    .append(string65).append(".txt").toString());
            final DataInputStream datainputstream = new DataInputStream(url.openStream());
            while ((string = datainputstream.readLine()) != null) {
                string = new StringBuilder().append("").append(string.trim()).toString();
                if (string.startsWith("stages")) {
                    boolean bool = true;
                    while (bool && i64 < 20) {
                        strings[i64] = getSvalue("stages", string, i64);
                        if (strings[i64].equals(""))
                            bool = false;
                        else
                            i64++;
                    }
                }
                if (string.startsWith("adds"))
                    for (int i66 = 0; i66 < i64; i66++)
                        top20adds[i66] = getvalue("adds", string, i66);
            }
            if (i64 > 0)
                msloaded = i;
            else
                msloaded = -2;
            datainputstream.close();
        } catch (final Exception exception) {
            final String string67 = new StringBuilder().append("").append(exception).toString();
            if (string67.indexOf("FileNotFound") != -1)
                msloaded = -2;
            else
                msloaded = -1;
        }
        if (msloaded == i) {
            gs.mstgs.setVisible(false);
            gs.mstgs.removeAll();
            gs.mstgs.add(gs.rd, "Select Stage");
            for (int i68 = 0; i68 < i64; i68++)
                gs.mstgs.add(gs.rd, new StringBuilder().append("N#").append(i68 + 1).append(" ")
                        .append(strings[i68]).toString());
            gs.mstgs.select(0);
            gs.mstgs.setVisible(true);
        }
        if (msloaded == -1 || msloaded == -2) {
            gs.mstgs.setVisible(false);
            gs.mstgs.removeAll();
            gs.mstgs.add(gs.rd, "Failed to load Top20 list, please try again later.");
            gs.mstgs.select(0);
            gs.mstgs.setVisible(true);
        }
        System.gc();
    }

    public void loadclanstages(final String string) {
        if (!string.equals("")) {
            final String[] strings = new String[700];
            int i = 0;
            String string69 = "";
            try {
                final URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/clans/")
                        .append(string).append("/stages.txt").toString());
                DataInputStream datainputstream;
                for (datainputstream = new DataInputStream(
                        url.openStream()); (string69 = datainputstream.readLine()) != null && i < 700; i++)
                    strings[i] = string69;
                if (i > 0)
                    msloaded = 7;
                else
                    msloaded = -2;
                datainputstream.close();
            } catch (final Exception exception) {
                final String string70 = new StringBuilder().append("").append(exception).toString();
                if (string70.indexOf("FileNotFound") != -1)
                    msloaded = -2;
                else
                    msloaded = -1;
            }
            if (msloaded == 7) {
                gs.mstgs.setVisible(false);
                gs.mstgs.removeAll();
                gs.mstgs.add(gs.rd, "Select Stage");
                for (int i71 = 0; i71 < i; i71++)
                    gs.mstgs.add(gs.rd, strings[i71]);
                gs.mstgs.select(0);
                gs.mstgs.setVisible(true);
            }
            if (msloaded == -1) {
                gs.mstgs.setVisible(false);
                gs.mstgs.removeAll();
                gs.mstgs.add(gs.rd, "Failed to load clan stages, please try again later.");
                gs.mstgs.select(0);
                gs.mstgs.setVisible(true);
            }
            if (msloaded == -2) {
                gs.mstgs.setVisible(false);
                gs.mstgs.removeAll();
                gs.mstgs.add(gs.rd, "No stages have been added to your clan yet.");
                gs.mstgs.select(0);
                gs.mstgs.setVisible(true);
            }
            System.gc();
        } else {
            msloaded = -2;
            gs.mstgs.setVisible(false);
            gs.mstgs.removeAll();
            gs.mstgs.add(gs.rd, "You are not a member of any clan yet.");
            gs.mstgs.select(0);
            gs.mstgs.setVisible(true);
        }
    }

    public void loadstagemaker() {
        gs.mstgs.setVisible(false);
        gs.mstgs.removeAll();
        gs.mstgs.add(gs.rd, "Select Stage");
        int i = 0;
        final File file = new File(new StringBuilder().append("").append(Madness.fpath).append("mystages/").toString());
        if (file.exists()) {
            final String[] strings = new File(
                    new StringBuilder().append("").append(Madness.fpath).append("mystages/").toString()).list();
            for (int i72 = 0; i72 < strings.length; i72++)
                if (strings[i72].toLowerCase().endsWith(".txt") && i < 200) {
                    gs.mstgs.add(gs.rd, strings[i72].substring(0, strings[i72].length() - 4));
                    i++;
                }
        }
        if (i != 0)
            msloaded = 2;
        else {
            gs.mstgs.add(gs.rd, "No stages where found in your 'mystages' folder.");
            msloaded = -1;
        }
        gs.mstgs.select(0);
        gs.mstgs.setVisible(true);
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
        final File file = new File(new StringBuilder().append("").append(Madness.fpath).append("mycars/").toString());
        if (file.exists()) {
            final String[] strings = new File(
                    new StringBuilder().append("").append(Madness.fpath).append("mycars/").toString()).list();
            for (int i = 0; i < strings.length; i++)
                if (strings[i].toLowerCase().endsWith(".rad") && nlcars < 56
                        && loadcar(strings[i].substring(0, strings[i].length() - 4), nlcars) == nlcars)
                    nlcars++;
        }
        System.gc();
        if (nlcars > 16)
            lastload = 1;
    }

    public int loadcar(final String string, int i) {
        try {
            final File file = new File(new StringBuilder().append("").append(Madness.fpath).append("mycars/")
                    .append(string).append(".rad").toString());
            if (file.exists()) {
                String string73 = "";
                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                final Object object = null;
                String string74;
                while ((string74 = bufferedreader.readLine()) != null)
                    string73 = new StringBuilder().append(string73).append("").append(string74).append("\n")
                            .toString();
                bufferedreader.close();
                final Object object75 = null;
                m.loadnew = true;
                bco[i] = new ContO(string73.getBytes(), m, t);
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
                    loadstat(string73.getBytes(), string, bco[i].maxR, bco[i].roofat, bco[i].wh, i);
                    if (names[i].equals(""))
                        i = -1;
                }
                m.loadnew = false;
            } else
                i = -1;
        } catch (final Exception exception) {
            i = -1;
            System.out.println(new StringBuilder().append("Error Loading Car: ").append(exception).toString());
        }
        System.gc();
        return i;
    }
}
