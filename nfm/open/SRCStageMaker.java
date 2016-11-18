package nfm.open;

import static nfm.open.Utility.fEquals;

import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.AbstractListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionListener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import nfm.open.music.RadicalAdapter;

/**
 * The Class StageMaker.
 */
public class SRCStageMaker extends JPanel
        implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
    /* TODO:
       test drive
       part menu
    */

    private static final Gson PART_MENUS_GSON = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();

    //static {
    //    System.err.println("StageMaker is being initialized, fuck");
    //    JOptionPane.showMessageDialog(null, "StageMaker is being initialized, fuck");
    //    System.exit(1);
    //}

    static {
        new Medium();
        new CheckPoints();
        new Trackers();
    }

    private static Graphics2D rd;

    private static float asin_m_xz;
    private static float asin_m_zy;
    private static float asin_m_xy;
    private static float acos_m_xz;
    private static float acos_m_zy;
    private static float acos_m_xy;
    private static int __m_xy = 0;

    private static class SMContO extends ContO {

        public static final float BUMP_RADIUS_MULT = 5f;
        public static final float BUMP_HEIGHT_MULT = 5f;

        /**
         * Previously 'colok'
         */
        int partID;

        /**
         * Previously 'roofat'
         */
        int declaredXZ;

        /**
         * For sorting purposes.
         */
        int declaredPositionInArray = -1;

        /**
         * Instantiates a new cont o.
         *
         * @param is the is
         */
        SMContO(final byte[] is) {
            super(is);
        }

        /**
         * Clones an existing ContO.
         *
         * @param contoClone the conto78
         * @param _x the i
         * @param _y the i79
         * @param _z the i80
         * @param _xz the i81
         */
        public SMContO(final ContO contoClone, final int _x, final int _y, final int _z, final int _xz) {
            super(contoClone, _x, _y, _z, _xz);
        }

        /**
         * Creates a new bump pile.
         *
         * @param i the i
         * @param i90 the i90
         * @param i91 the i91
         * @param i92 the i92
         * @param i93 the i93
         * @param i94 the i94
         */
        public SMContO(final int i, final int i90, final int i91, final int i92, final int i93, final int i94) {
            super(i, i90, i91, i92, i93, i94);
        }

        public boolean dupeOf(final SMContO o) {
            return partID == o.partID && //set id
                    x == o.x && //x
                    y == o.y && //y
                    z == o.z && //z
                    declaredXZ == o.declaredXZ //angle
            //xz == o.xz
            ;
        }
    }

    private static final class FontConstants {

        public static final Font arial_13 = new Font("Arial", 1, 13);
        public static final Font arial_12 = new Font("Arial", 1, 12);
        public static final Font arial_11 = new Font("Arial", 1, 11);

        static {
            if (rd == null) {
                rd = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB).createGraphics();
            }
        }
    }

    private static final class ColorConstants {

        /**
         * Don't let anyone instantiate this class.
         */
        private ColorConstants() {
        }

        public static final Color c_63_80_110 = new Color(63, 80, 110);
        public static final Color c_209_217_230 = new Color(209, 217, 230);
        public static final Color c_220_220_220 = new Color(220, 220, 220);
        public static final Color c_240_240_240 = new Color(240, 240, 240);
        public static final Color c_200_200_200 = new Color(200, 200, 200);
        public static final Color c_0_64_128 = new Color(0, 64, 128);
        public static final Color c_192_192_192 = new Color(192, 192, 192);
        public static final Color c_247_247_247 = new Color(247, 247, 247);
        public static final Color c_0_128_255 = new Color(0, 128, 255);
        public static final Color c_170_170_170 = new Color(170, 170, 170);
        public static final Color c_190_190_190 = new Color(190, 190, 190);
        public static final Color c_255_128_0 = new Color(255, 128, 0);
        public static final Color c_235_235_235 = new Color(235, 235, 235);
        public static final Color c_155_155_155 = new Color(155, 155, 155);
        public static final Color c_0_0_64 = new Color(0, 0, 64);
        public static final Color c_0_64_0 = new Color(0, 64, 0);
        public static final Color c_230_230_230 = new Color(230, 230, 230);
        public static final Color c_207_207_207 = new Color(207, 207, 207);
        public static final Color c_100_100_100 = new Color(100, 100, 100);
        public static final Color c_0_164_255 = new Color(0, 164, 255);
        public static final Color c_138_147_160 = new Color(138, 147, 160);
        public static final Color c_136_148_170 = new Color(136, 148, 170);
        public static final Color c_210_210_210 = new Color(210, 210, 210);
        public static final Color c_128_128_128 = new Color(128, 128, 128);
        public static final Color c_0_200_0 = new Color(0, 200, 0);
        public static final Color c_0_164_242 = new Color(0, 164, 242);
        public static final Color c_120_210_255 = new Color(120, 210, 255);
    }

    private static SRCStageMaker stageMaker;
    //////////////// ------------ REMEMBER NEW PARTS ARE ALWAYS -10 INDEXES SINCE YOU CAN'T SELECT CARS IN THE STAGEMAKER
    //////////////// ------------ REMEMBER ALL PARTS INDEX 33 AND UP ARE SKYLINE PARTS
    //////////////// ------------ IF THEY'RE NOT IN THE TREES/SKYLINE MENU THEY SHOULD BE COMMENTED OUT

    private static final int MAX_UNDO_ACTIONS = 50; //was 5000...
    private static final int FLYING_CHECKPOINT_SET_ID = 161; //64 - 10
    private static final int OFFROAD_CHECKPOINT_SET_ID = 32; //42 - 10
    private static final int ONROAD_CHECKPOINT_SET_ID = 30; //40 - 10
    private static final int FIXHOOP_SET_ID = 31; //41 - 10

    /**
     * serialVersionUID for serial things
     */
    private static final long serialVersionUID = 2444709970063151411L;

    private static final BufferedImage offImage = new BufferedImage(800, 550, BufferedImage.TYPE_INT_ARGB);

    static {
        if (offImage != null) {
            rd = offImage.createGraphics();
        } else {
            throw new Error("this should never happen");
        }
    }

    static class Menus {
        @SerializedName("menus")
        final Map<String, Map<String, String>> menus = new LinkedHashMap<>();

        {
            final Map<String, String> menu = new LinkedHashMap<>();
            menu.put("NormalRoad", "0");
            menu.put("NormalRoad Turn", "4");
            menu.put("NormalRoad End", "13");
            menu.put("NormalRoad TwistedLeft", "3");
            menu.put("NormalRoad TwistedRight", "2");
            menu.put("NormalRoad Edged", "1");
            menu.put("NormalRoad-Raised Ramp", "35");
            menu.put("NormalRoad Raised", "36");
            menu.put("Normal-Off-Road Blend", "10");
            menu.put("OffRoad", "5");
            menu.put("OffRoad Turn", "7");
            menu.put("OffRoad End", "14");
            menu.put("OffRoad BumpyGreen", "6");
            menu.put("OffRoad-BumpySides Start", "34");
            menu.put("OffRoad BumpySides", "33");
            menu.put("Off-Halfpipe-Road Blend", "11");
            menu.put("HalfpipeRoad", "8");
            menu.put("HalfpipeRoad Turn", "9");
            menu.put("HalfpipeRoad-Ramp Filler", "15");
            menu.put("Halfpipe-Normal-Road Blend", "12");

            menus.put("Roads", menu);
        }
    }

    private static Menus menus = new Menus();

    static {
        System.out.println(PART_MENUS_GSON.toJson(menus));
        try {
            menus = PART_MENUS_GSON.fromJson(new FileReader(new File("./data/stagemaker.txt")), Menus.class);
        } catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Contains the set id of any model .rad name (in stagemaker values, so -10)
     */
    private static final TObjectIntMap<String> partNumbers = new TObjectIntHashMap<>();

    static {
        for (int i = 0; i < GameSparker.stageRads.length; i++) {
            partNumbers.put(GameSparker.stageRads[i], i);
        }
    }

    /**
     * Converts all the part numbers to strings
     */
    static {
        for (final Map<String, String> map : menus.menus.values()) {
            map.entrySet().stream().filter(entry -> Utility.isNumeric(entry.getValue())).forEach(entry -> entry.setValue(Utility.findValueKey(partNumbers, Integer.parseInt(entry.getValue()))));
        }
    }

    private final static int[] CHECKPOINT_IDS = { // add checkpoints here
    };

    private static int aMouseState;

    /**
     * boolean for kaffi-nootnoot's settings.
     */
    static boolean kSettings = false;
    private static boolean inPreview = false;
    /**
     * unconvetional perhaps, but it will work.
     */
    private static float speedShift = 1.0F;
    private static float rAccFloat = 0.0F;
    private static float lAccFloat = 0.0F;
    private static float uAccFloat = 0.0F;
    private static float dAccFloat = 0.0F;
    private static float ziAccFloat = 0.0F;
    private static float zoAccFloat = 0.0F;
    /**
     * Mein shit.
     */
    private static boolean isHansen = false;
    private static float tiltLeftAccFloat = 0.0F;
    private static float tiltRightAccFloat = 0.0F;
    private static final int maxpart = 190; //originally 65 ------ INCREMENT THIS FUCKING THING WHEN YOU WANT A NEW FUCKING PART

    private static final int BUMP_SET_ID = maxpart + 1; // bumps aren't even in the version this is just to avoid crashes

    private static final byte PART_ROADS = 0;
    private static final byte PART_RAMPS = 1;
    private static final byte PART_OBSTACLES = 2;
    private static final byte PART_CHECKPOINTS = 3;
    private static final byte PART_TREES = 5;
    private static final boolean floats = false; // set to false for regular nfmm, set to true for skyline

    private static boolean isPartBumps = false;
    private static boolean isPartFixhoops = false;

    private static final String[][] addeda = new String[20][5000];
    private static int adrot = 0;
    private static int apx = 0;
    private static int apy = 0;
    private static int arrcnt = 0;
    private static boolean arrng = false;
    // ------------------ ATTACH POINTS
    // ------------------ INCREMENT THIS FUCKING THING WHEN YOU WANT A NEW FUCKING PART

    // Attach points are: x1, z1, x2, z2

    /**
     * ----------------- ATTACH POINTS <br>
     * ------------------ INCREMENT THIS WHEN YOU WANT A NEW PART<br>
     * Attach points are: x1, z1, x2, z2<br>
     */
    private static final int[][] atp = {
            {
                    0, 2800, 0, -2800
            }, {
                    0, 2800, 0, -2800
            }, {
                    1520, 2830, -1520, -2830
            }, {
                    -1520, 2830, 1520, -2830
            }, {
                    0, -1750, 1750, 0
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, -1750, 1750, 0
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, -1750, 1750, 0
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, 560, 0, -560
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    385, 980, 385, -980
            }, {
                    0, 0, 0, -600
            }, {
                    0, 0, 0, 0
            }, {
                    0, 2164, 0, -2164
            }, {
                    0, 2164, 0, -2164
            }, {
                    0, 3309, 0, -1680
            }, {
                    0, 1680, 0, -3309
            }, {
                    350, 0, -350, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    1810, 980, 1810, -980
            }, {
                    0, 0, 0, 0
            }, {
                    0, 500, 0, -500
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, 1680, 0, -3309
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, 2800, 0, -2800
            }, {
                    0, 2800, 0, -2800
            }, {
                    700, 1400, 700, -1400
            }, {
                    0, -1480, 0, -1480
            }, {
                    0, 0, 0, 0
            }, {
                    350, 0, -350, 0
            }, {
                    0, 0, 0, 0
            }, {
                    700, 0, -700, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, -2198, 0, 1482
            }, {
                    0, -1319, 0, 1391
            }, {
                    0, -1894, 0, 2271
            }, {
                    0, -826, 0, 839
            }, {
                    0, -1400, 0, 1400
            }, {
                    0, -1400, 0, 1400
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            }, {
                    0, 0, 0, 0
            },

            { // ?
                    0, 0, 0, 0
            }, { // bump part
                    0, 0, 0, 0
            }
    };

    private static int avon = 0;
    private static final SMContO[] bco = new SMContO[maxpart + 5];
    static String bstage = "\r\nmaxr(11,28500,-5600)\r\nmaxb(9,-8000,-12300)\r\nmaxl(11,-14700,-5600)\r\nmaxt(9,44800,-12300)\r\n";
    private static final int[] cfade = {
            255, 220, 220
    };

    private static final int[] cgrnd = {
            205, 200, 200
    };

    private static int chi = -1;
    private static final int[] cldd = {
            210, 210, 210, 1, -1000
    };

    private static boolean placeDelay = false;
    private static final SMContO[] co = new SMContO[10000];
    private static final int[] csky = {
            170, 220, 255
    };

    private static boolean down = false;
    private static int dtab = 0;
    private static int dtabed = -1;
    private static boolean epart = false;
    private static int errd = 0;
    private static final String[] errlo = {
            "The maximum allocated memory for the stage's part's details has been exerted.\nPlease decrease the amount of parts in the stage that have more details then average.",
            "The maximum amount of road points allowed in the track has been exceeded.\nPlease remove some of the road parts that are in the circler path of the track (the parts that are between the checkpoints).\nOr try to remove some of the extra checkpoints in the track as well.",
            "The maximum allowed area for a track (the area in between its walls) has been exceeded.\nPlease try to place parts only inside the current allowed area, inside the area between the current maximum wall placements.",
            "The maximum number of parts allowed per stage has been exceeded.\nPlease remove some of the already extra parts placed in order to make space.",
            "The maximum number of Fixing Hoops allowed per stage is 5!\nPlease remove the extra Fixing Hoops from your stage to have only 5 main ones left.",
            "Unknown Error, please make sure the stage you are handling is saved correctly.\nPlease go to the 'Build' tab and press 'Save & Preview'.",
            "There needs to be at least 2 checkpoints in the Stage in order for the game to work.\nPlease go to the 'Build' tab and select 'Checkpoint' in the Part Selection menu to add more checkpoints.",
            "The name of the stage is too long!\nPlease go to the 'Stage' tab, click 'Rename Stage' and give your stage a shorter name."
    };

    private static int esp = -1;
    private static int fgen = 0;
    /**
     * Text field for the fix hoop height.
     */
    private static final TextField fixh = new TextField("2000", 5);
    /**
     * Height of fix hoop.
     */
    private static int flyh = 0;
    private static boolean focuson = true;
    private static final int[] fogn = {
            60, 0
    };

    private static FontMetrics ftm;

    private static int hf = 2000;
    private static int hi = -1;
    private static final float[][] hsb = {
            {
                    0.5F, 0.875F, 0.5F
            }, {
                    0.5F, 0.875F, 0.5F
            }, {
                    0.5F, 0.875F, 0.5F
            }
    };

    private static boolean left = false;
    private static int logged = 0;
    private static Image logo;

    private static int lsp = -1;
    private static String ltrackname = "";
    private static int lxm = 0;
    // Removed unused code found by UCDetector

    //  private static int lym = 0;
    private static final String[] maker = new String[20];
    private static final TextField mgen = new TextField("", 10);
    private static boolean mousdr = false;
    private static int mouseon = -1;
    private static int mousePressed = 0;
    private static final String[] mystages = new String[20];
    private static final int[] nad = new int[20];
    private static final Smenu nlaps = new Smenu(40);
    private static int nms = 0;
    static int nob = 0;
    private static int numUndoActions = 0;
    private static final int[] ocheckp = {
            5, 6, 7, 11, 14, 33, 34, 38
    };

    //private static boolean onbtgame = false;
    // Removed unused code found by UCDetector

    private static int origfade = 5000;
    private static boolean overcan = false;
    private static final Smenu part = new Smenu(500);
    // Removed unused code found by UCDetector
    //  boolean[] pessd = { false, false, false, false, false, false, false, false, false, false, false, false, false,

    //          false, false, false, false, false, false, false, false, false, false, false };
    private static final Checkbox pfog = new Checkbox("Linked Blend");
    private static boolean pgen = false;
    private static float phd = 2L + Math.round(ThreadLocalRandom.current().nextDouble() * 4.0);
    private static boolean preop = false;
    private static final Smenu ptyp = new Smenu(40);
    private static final int[] pubt = new int[20];
    private static final Smenu pubtyp = new Smenu(40);
    private static float pwd = 2L + Math.round(ThreadLocalRandom.current().nextDouble() * 4.0);
    private static final int[] rcheckp = {
            0, 1, 2, 3, 4, 12, 13, 37
    };

    private static boolean right = false;
    private static int rot = 0;
    private static final Image[] sd = new Image[2];
    private static int seq = 0;
    private static boolean seqn = false;
    private static boolean setcur = false;
    private static int sfase = 0;
    private static final Image[] sl = new Image[2];
    private static final Smenu slstage = new Smenu(2000);
    private static final int[] snap = {
            50, 50, 50
    };

    private static int selectedPart = 0;
    private static int selectedMenuPart = 0;
    private static int selectedPartType = 0;
    private static final Image[] sr = new Image[2];
    private static final TextField srch = new TextField("", 38);
    private static String sstage = "";
    private static String stagename = "";
    private static final Smenu strtyp = new Smenu(40);
    private static final Image[] su = new Image[2];
    private static String suser = "Horaks";
    private static int sx = 0;
    private static int sy = -10000;
    private static int sz = 1500;
    private static int tab = 0;
    private static int tabed = -1;
    private static final int[] texture = {
            0, 0, 0, 10
    };

    private static final TextField tnick = new TextField("", 15);
    private static final TextField tpass = new TextField("", 15);
    private static RadicalAdapter track = new RadicalAdapter();
    private static String trackname = "";
    private static final Smenu tracks = new Smenu(2000);
    private static int tracksize = 111;
    private static int trackvol = 200;
    static String tstage = "snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\n\rmountains(" + (int) (ThreadLocalRandom.current().nextDouble() * 100000.0) + ")\r\nnlaps(5)\r\n\r\n";
    private static String ttstage = "";

    private static final int[] undoContoID = new int[MAX_UNDO_ACTIONS];
    private static final int[] undoContoX = new int[MAX_UNDO_ACTIONS];
    private static final int[] undoContoY = new int[MAX_UNDO_ACTIONS];
    private static final int[] undoContoZ = new int[MAX_UNDO_ACTIONS];
    /**
     * Does not need to be specified if it isn't a remove action
     */
    private static final int[] undoContoXZ = new int[MAX_UNDO_ACTIONS];
    private static final boolean[] undoIsRemove = new boolean[MAX_UNDO_ACTIONS];

    private static boolean up = false;
    private static int vx = 0;
    private static int vxz = 0;
    private static int vy = 0;
    private static int vz = 0;
    private static final Smenu witho = new Smenu(40);
    private static int xm = 0;
    private static int xnob = 0;
    private static int ym = 0;
    private static final Image[] zi = new Image[2];
    private static final Image[] zo = new Image[2];
    private static boolean zoomi = false;
    private static boolean zoomo = false;

    private static void medium_rot(final int[] is, final int[] is274, final int i, final int i275, final int i276, final float sin, final float cos, final int i277) {
        if (i276 != 0) {
            for (int i278 = 0; i278 < i277; i278++) {
                final int i279 = is[i278];
                final int i280 = is274[i278];
                is[i278] = i + (int) ((i279 - i) * cos - (i280 - i275) * sin);
                is274[i278] = i275 + (int) ((i279 - i) * sin + (i280 - i275) * cos);
            }
        }
    }

    /**
     * Button.
     *
     * @param string the string
     * @param i the i
     * @param i381 the i381
     * @param i382 the i382
     * @param bool the bool
     * @return true, if successful
     */
    private static boolean button(final String string, final int i, final int i381, final int i382, final boolean bool) {
        rd.setFont(FontConstants.arial_12);
        ftm = rd.getFontMetrics();
        final int i383 = ftm.stringWidth(string);
        boolean bool384;
        boolean bool385 = false;
        if (string.equals(" Cancel ") && epart && Math.abs(xm - i) < i383 / 2 + 12 && Math.abs(ym - i381 + 5) < 10) {
            overcan = true;
        }
        bool384 = Math.abs(xm - i) < i383 / 2 + 12 && Math.abs(ym - i381 + 5) < 10 && mousePressed == 1;
        if (Math.abs(xm - i) < i383 / 2 + 12 && Math.abs(ym - i381 + 5) < 10 && mousePressed == -1) {
            mousePressed = 0;
            bool385 = true;
        }
        boolean bool386 = false;
        if (bool) {
            if (tab == 0) {
                rd.setColor(ColorConstants.c_207_207_207);
            }
            if (tab == 1) {
                rd.setColor(ColorConstants.c_200_200_200);
            }
            if (tab == 2) {
                rd.setColor(ColorConstants.c_170_170_170);
            }
            if (tab != 3) {
                rd.drawRect(i - i383 / 2 - 15, i381 - (22 - i382), i383 + 29, 34 - i382 * 2);
                if (i382 == 2 && tab == 1) {
                    rd.setColor(ColorConstants.c_220_220_220);
                    rd.fillRect(i - i383 / 2 - 15, i381 - (22 - i382), i383 + 29, 34 - i382 * 2);
                }
            } else {
                bool386 = true;
            }
        }
        if (!bool384) {
            rd.setColor(ColorConstants.c_220_220_220);
            if (bool386) {
                rd.setColor(ColorConstants.c_230_230_230);
            }
            rd.fillRect(i - i383 / 2 - 10, i381 - (17 - i382), i383 + 20, 25 - i382 * 2);
            rd.setColor(ColorConstants.c_240_240_240);
            if (bool386) {
                rd.setColor(Color.white);
            }
            rd.drawLine(i - i383 / 2 - 10, i381 - (17 - i382), i + i383 / 2 + 10, i381 - (17 - i382));
            rd.drawLine(i - i383 / 2 - 10, i381 - (18 - i382), i + i383 / 2 + 10, i381 - (18 - i382));
            rd.setColor(ColorConstants.c_240_240_240);
            rd.drawLine(i - i383 / 2 - 9, i381 - (19 - i382), i + i383 / 2 + 9, i381 - (19 - i382));
            rd.setColor(ColorConstants.c_200_200_200);
            if (bool386) {
                rd.setColor(ColorConstants.c_192_192_192);
            }
            rd.drawLine(i + i383 / 2 + 10, i381 - (17 - i382), i + i383 / 2 + 10, i381 + 7 - i382);
            rd.drawLine(i + i383 / 2 + 11, i381 - (17 - i382), i + i383 / 2 + 11, i381 + 7 - i382);
            rd.setColor(ColorConstants.c_200_200_200);
            if (bool386) {
                rd.setColor(ColorConstants.c_192_192_192);
            }
            rd.drawLine(i + i383 / 2 + 12, i381 - (16 - i382), i + i383 / 2 + 12, i381 + 6 - i382);
            rd.drawLine(i - i383 / 2 - 10, i381 + 7 - i382, i + i383 / 2 + 10, i381 + 7 - i382);
            rd.drawLine(i - i383 / 2 - 10, i381 + 8 - i382, i + i383 / 2 + 10, i381 + 8 - i382);
            rd.setColor(ColorConstants.c_200_200_200);
            rd.drawLine(i - i383 / 2 - 9, i381 + 9 - i382, i + i383 / 2 + 9, i381 + 9 - i382);
            rd.setColor(ColorConstants.c_240_240_240);
            if (bool386) {
                rd.setColor(Color.white);
            }
            rd.drawLine(i - i383 / 2 - 10, i381 - (17 - i382), i - i383 / 2 - 10, i381 + 7 - i382);
            rd.drawLine(i - i383 / 2 - 11, i381 - (17 - i382), i - i383 / 2 - 11, i381 + 7 - i382);
            rd.setColor(ColorConstants.c_240_240_240);
            rd.drawLine(i - i383 / 2 - 12, i381 - (16 - i382), i - i383 / 2 - 12, i381 + 6 - i382);
            rd.setColor(Color.black);
            if (string.equals("  Keyboard Controls  ")) {
                rd.setColor(ColorConstants.c_100_100_100);
            }
            rd.drawString(string, i - i383 / 2, i381);
        } else {
            rd.setColor(ColorConstants.c_220_220_220);
            rd.fillRect(i - i383 / 2 - 10, i381 - (17 - i382), i383 + 20, 25 - i382 * 2);
            rd.setColor(ColorConstants.c_192_192_192);
            rd.drawLine(i - i383 / 2 - 10, i381 - (17 - i382), i + i383 / 2 + 10, i381 - (17 - i382));
            rd.drawLine(i - i383 / 2 - 10, i381 - (18 - i382), i + i383 / 2 + 10, i381 - (18 - i382));
            rd.drawLine(i - i383 / 2 - 9, i381 - (19 - i382), i + i383 / 2 + 9, i381 - (19 - i382));
            rd.setColor(ColorConstants.c_247_247_247);
            rd.drawLine(i + i383 / 2 + 10, i381 - (17 - i382), i + i383 / 2 + 10, i381 + 7 - i382);
            rd.drawLine(i + i383 / 2 + 11, i381 - (17 - i382), i + i383 / 2 + 11, i381 + 7 - i382);
            rd.drawLine(i + i383 / 2 + 12, i381 - (16 - i382), i + i383 / 2 + 12, i381 + 6 - i382);
            rd.drawLine(i - i383 / 2 - 10, i381 + 7 - i382, i + i383 / 2 + 10, i381 + 7 - i382);
            rd.drawLine(i - i383 / 2 - 10, i381 + 8 - i382, i + i383 / 2 + 10, i381 + 8 - i382);
            rd.drawLine(i - i383 / 2 - 9, i381 + 9 - i382, i + i383 / 2 + 9, i381 + 9 - i382);
            rd.setColor(ColorConstants.c_192_192_192);
            rd.drawLine(i - i383 / 2 - 10, i381 - (17 - i382), i - i383 / 2 - 10, i381 + 7 - i382);
            rd.drawLine(i - i383 / 2 - 11, i381 - (17 - i382), i - i383 / 2 - 11, i381 + 7 - i382);
            rd.drawLine(i - i383 / 2 - 12, i381 - (16 - i382), i - i383 / 2 - 12, i381 + 6 - i382);
            rd.setColor(Color.black);
            if (string.equals("  Keyboard Controls  ")) {
                rd.setColor(ColorConstants.c_100_100_100);
            }
            rd.drawString(string, i - i383 / 2 + 1, i381 + 1);
        }
        return bool385;
    }

    /**
     * Copyesp.
     *
     * @param bool the bool
     */
    private static void copyesp(final boolean bool) {
        selectedPart = co[esp].partID;
        rot = co[esp].declaredXZ;
        if (selectedPart == 2) {
            rot -= 30;
        }
        if (selectedPart == 3) {
            rot += 30;
        }
        if (selectedPart == 15) {
            rot += 90;
        }
        if (selectedPart == 20) {
            rot += 180;
        }
        if (selectedPart == 26) {
            rot -= 90;
        }
        //        if (selectedPart == 0) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 0;
        //        }
        //        if (selectedPart == 4) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 1;
        //        }
        //        if (selectedPart == 13) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 2;
        //        }
        //        if (selectedPart == 3) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 3;
        //        }
        //        if (selectedPart == 2) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 4;
        //        }
        //        if (selectedPart == 1) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 5;
        //        }
        //
        //        if (selectedPart == 10) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 8;
        //        }
        //        if (selectedPart == 5) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 9;
        //        }
        //        if (selectedPart == 7) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 10;
        //        }
        //        if (selectedPart == 14) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 11;
        //        }
        //        if (selectedPart == 6) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 12;
        //        }
        //
        //        if (selectedPart == 11) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 15;
        //        }
        //        if (selectedPart == 8) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 16;
        //        }
        //        if (selectedPart == 9) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 17;
        //        }
        //        if (selectedPart == 15) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 18;
        //        }
        //        if (selectedPart == 12) {
        //            selectedPartType = 0;
        //            selectedMenuPart = 19;
        //        }
        //
        //        if (selectedPart == 16) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 0;
        //        }
        //        if (selectedPart == 18) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 1;
        //        }
        //        if (selectedPart == 19) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 2;
        //        }
        //        if (selectedPart == 22) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 3;
        //        }
        //        if (selectedPart == 17) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 4;
        //        }
        //        if (selectedPart == 21) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 5;
        //        }
        //        if (selectedPart == 20) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 6;
        //        }
        //
        //        if (selectedPart == 23) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 10;
        //        }
        //        if (selectedPart == 25) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 11;
        //        }
        //        if (selectedPart == 24) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 12;
        //        }
        //
        //        if (selectedPart == 26) {
        //            selectedPartType = 1;
        //            selectedMenuPart = 15;
        //        }
        //        if (selectedPart == 27) {
        //            selectedPartType = 2;
        //            selectedMenuPart = 0;
        //        }
        //        if (selectedPart == 28) {
        //            selectedPartType = 2;
        //            selectedMenuPart = 1;
        //        }
        //
        //        if (selectedPart == 30 || selectedPart == 32) {
        //            selectedPartType = 3;
        //            selectedMenuPart = 0;
        //        }
        //        if (selectedPart == 31) {
        //            selectedPartType = 4;
        //            selectedMenuPart = 0;
        //        }
        //        if (selectedPart == 33) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 0;
        //        }
        //
        //        if (selectedPart == 34) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 1;
        //        }
        //
        //        if (selectedPart == 35) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 2;
        //        }
        //
        //        if (selectedPart == 36) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 3;
        //        }
        //
        //        if (selectedPart == 37) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 4;
        //        }
        //
        //        if (selectedPart == 38) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 5;
        //        }
        //
        //        if (selectedPart == 39) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 6;
        //        }
        //
        //        if (selectedPart == 40) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 7;
        //        }
        //
        //        if (selectedPart == 41) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 8;
        //        }
        //
        //        if (selectedPart == 42) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 9;
        //        }
        //
        //        if (selectedPart == 43) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 10;
        //        }
        //
        //        if (selectedPart == 44) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 11;
        //        }
        //
        //        if (selectedPart == 45) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 12;
        //        }
        //
        //        if (selectedPart == 46) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 13;
        //        }
        //
        //        if (selectedPart == 47) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 14;
        //        }
        //
        //        if (selectedPart == 48) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 15;
        //        }
        //
        //        if (selectedPart == 49) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 16;
        //        }
        //
        //        if (selectedPart == 50) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 17;
        //        }
        //
        //        if (selectedPart == 51) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 18;
        //        }
        //
        //        if (selectedPart == 52) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 19;
        //        }
        //
        //        if (selectedPart == 53) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 20;
        //        }
        //
        //        if (selectedPart == 54) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 21;
        //        }
        //
        //        if (selectedPart == 55) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 22;
        //        }
        //
        //        if (selectedPart == 56) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 23;
        //        }
        //
        //        if (selectedPart == 57) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 24;
        //        }
        //
        //        if (selectedPart == 58) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 25;
        //        }
        //
        //        if (selectedPart == 59) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 26;
        //        }
        //
        //        if (selectedPart == 60) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 27;
        //        }
        //
        //        if (selectedPart == 61) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 28;
        //        }
        //
        //        if (selectedPart == 62) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 29;
        //        }
        //
        //        if (selectedPart == 63) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 30;
        //        }
        //
        //        if (selectedPart == 64) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 31;
        //        }
        //
        //        if (selectedPart == 65) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 32;
        //        }
        //
        //        if (selectedPart == 66) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 33;
        //        }
        //
        //        if (selectedPart == 67) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 34;
        //        }
        //
        //        if (selectedPart == 68) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 35;
        //        }
        //
        //        if (selectedPart == 69) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 36;
        //        }
        //
        //        if (selectedPart == 70) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 37;
        //        }
        //
        //        if (selectedPart == 71) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 38;
        //        }
        //
        //        if (selectedPart == 72) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 39;
        //        }
        //
        //        if (selectedPart == 73) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 40;
        //        }
        //
        //        if (selectedPart == 74) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 41;
        //        }
        //
        //        if (selectedPart == 75) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 42;
        //        }
        //
        //        if (selectedPart == 76) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 43;
        //        }
        //
        //        if (selectedPart == 77) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 44;
        //        }
        //
        //        if (selectedPart == 78) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 45;
        //        }
        //
        //        if (selectedPart == 79) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 46;
        //        }
        //
        //        if (selectedPart == 80) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 47;
        //        }
        //
        //        if (selectedPart == 81) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 48;
        //        }
        //
        //        if (selectedPart == 82) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 49;
        //        }
        //
        //        if (selectedPart == 83) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 50;
        //        }
        //
        //        if (selectedPart == 84) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 51;
        //        }
        //
        //        if (selectedPart == 85) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 52;
        //        }
        //
        //        if (selectedPart == 86) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 53;
        //        }
        //
        //        if (selectedPart == 87) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 54;
        //        }
        //
        //        if (selectedPart == 88) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 55;
        //        }
        //
        //        if (selectedPart == 89) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 56;
        //        }
        //
        //        if (selectedPart == 90) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 57;
        //        }
        //
        //        if (selectedPart == 91) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 58;
        //        }
        //
        //        if (selectedPart == 92) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 59;
        //        }
        //
        //        if (selectedPart == 93) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 60;
        //        }
        //
        //        if (selectedPart == 94) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 61;
        //        }
        //
        //        if (selectedPart == 95) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 62;
        //        }
        //
        //        if (selectedPart == 96) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 63;
        //        }
        //
        //        if (selectedPart == 97) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 64;
        //        }
        //
        //        if (selectedPart == 98) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 65;
        //        }
        //
        //        if (selectedPart == 99) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 66;
        //        }
        //
        //        if (selectedPart == 100) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 67;
        //        }
        //
        //        if (selectedPart == 101) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 68;
        //        }
        //
        //        if (selectedPart == 102) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 69;
        //        }
        //
        //        if (selectedPart == 103) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 70;
        //        }
        //
        //        if (selectedPart == 104) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 71;
        //        }
        //
        //        if (selectedPart == 105) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 72;
        //        }
        //
        //        if (selectedPart == 106) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 73;
        //        }
        //
        //        if (selectedPart == 107) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 74;
        //        }
        //
        //        if (selectedPart == 108) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 75;
        //        }
        //
        //        if (selectedPart == 109) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 76;
        //        }
        //
        //        if (selectedPart == 110) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 77;
        //        }
        //
        //        if (selectedPart == 111) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 78;
        //        }
        //
        //        if (selectedPart == 112) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 79;
        //        }
        //
        //        if (selectedPart == 113) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 80;
        //        }
        //
        //        if (selectedPart == 114) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 81;
        //        }
        //
        //        if (selectedPart == 115) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 82;
        //        }
        //
        //        if (selectedPart == 116) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 83;
        //        }
        //
        //        if (selectedPart == 117) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 84;
        //        }
        //
        //        if (selectedPart == 118) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 85;
        //        }
        //
        //        if (selectedPart == 119) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 86;
        //        }
        //
        //        if (selectedPart == 120) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 87;
        //        }
        //
        //        if (selectedPart == 121) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 88;
        //        }
        //
        //        if (selectedPart == 122) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 89;
        //        }
        //
        //        if (selectedPart == 123) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 90;
        //        }
        //
        //        if (selectedPart == 124) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 91;
        //        }
        //
        //        if (selectedPart == 125) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 92;
        //        }
        //
        //        if (selectedPart == 126) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 93;
        //        }
        //
        //        if (selectedPart == 127) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 94;
        //        }
        //
        //        if (selectedPart == 128) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 95;
        //        }
        //
        //        if (selectedPart == 129) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 96;
        //        }
        //
        //        if (selectedPart == 130) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 97;
        //        }
        //
        //        if (selectedPart == 131) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 98;
        //        }
        //
        //        if (selectedPart == 132) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 99;
        //        }
        //
        //        if (selectedPart == 133) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 100;
        //        }
        //
        //        if (selectedPart == 134) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 101;
        //        }
        //
        //        if (selectedPart == 135) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 102;
        //        }
        //
        //        if (selectedPart == 136) {
        //            selectedPartType = 5;
        //            selectedMenuPart = 103;
        //        }
        //
        //        // ------------------ INCREMENT HERE FOR NEW PARTS
        //        // -----------------------------NO NEED TO INCREMENT ANYMORE I FIXED IT
        //
        //        if (selectedPart > 136) {
        //            selectedPartType = 5;
        //            selectedMenuPart = selectedPart - 33;
        //        }

        /*
        System.out.println("ptyp.getSelectedItem() " + ptyp.getSelectedItem());
        System.out.println("part.getSelectedItem() " + part.getSelectedItem());
        System.out.println("menu selected part  " + menus.menus.get(ptyp.getSelectedItem() //
                ).get(part.getSelectedItem()) //
                );*/

        // select right part

        final String partval = Utility.findValueKey(partNumbers, selectedPart);

        int ctype = 0;
        for (final Map<String, String> map : menus.menus.values()) {
            final String s = Utility.findValueKey(map, partval);
            if (s != null) { // current map contains value 'partval'
                System.out.println("GA");
                if (ctype != ptyp.getSelectedIndex()) { // select whichever map this is
                    System.out.println("GB");
                    selectedPartType = ctype;
                    ptyp.select(selectedPartType);
                    loadPartMenu();
                }

                int cpart = 0;
                for (final String cs : map.keySet()) {
                    if (s.equals(cs)) {
                        System.out.println("GC");
                        selectedMenuPart = cpart;
                        part.select(cpart);
                        break;
                    }

                    cpart++;
                }
                break;
            }
            ctype++;
        }

        //updateSelectedPart();
        if (selectedPart == BUMP_SET_ID) {
            if (bool) {
                fgen = co[esp].srz;
            } else {
                fgen = 0;
            }
            pwd = co[esp].srx;
            phd = co[esp].sry;
            pgen = false;
            selectedPartType = ptyp.getIndex("Ground Pile");
        }
        //        if (selectedPartType == PART_ROADS) {
        //            partroads();
        //            part.setVisible(true);
        //        }
        //        if (selectedPartType == PART_RAMPS) {
        //            partramps();
        //            part.setVisible(true);
        //        }
        //        if (selectedPartType == PART_OBSTACLES) {
        //            partobst();
        //            part.setVisible(true);
        //        }
        //        if (selectedPartType == PART_TREES) {
        //            partrees();
        //            part.setVisible(true);
        //        }
    }

    /**
     * Delstage.
     *
     * @param string the string
     */
    private static void delstage(final String string) {
        try {
            final File file = new File("mystages/" + string + ".txt");
            file.delete();
            slstage.remove(string);
            slstage.select(0);
        } catch (final Exception exception) {
            JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + exception, "Stage Maker", 1);
        }
    }

    /**
     * Deltrack.
     */
    private static void deltrack() {
        try {
            final File file = new File("mystages/mymusic/" + tracks.getSelectedItem() + ".zip");
            file.delete();
            if (trackname.equals(tracks.getSelectedItem())) {
                trackname = "";
                sortop();
                savefile();
            }
            tracks.remove(tracks.getSelectedItem());
            tracks.select(0);
        } catch (final Exception exception) {
            JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + exception, "Stage Maker", 1);
        }
    }

    /**
     * Drawms.
     */
    private static void drawms() {
        boolean bool = false;
        if (pubtyp.draw(rd, xm, ym, mousdr, 550, false)) {
            bool = true;
        }
        if (slstage.draw(rd, xm, ym, mousdr, 550, false)) {
            bool = true;
        }
        if (strtyp.draw(rd, xm, ym, mousdr, 550, false)) {
            bool = true;
        }
        int i = 0;
        if (preop) {
            i = -1000;
        }
        if (part.draw(rd, xm, ym + i, mousdr && !preop, 550, false)) {
            bool = true;
        }
        if (ptyp.draw(rd, xm, ym, mousdr, 550, false)) {
            bool = true;
            preop = true;
        } else {
            preop = false;
        }
        if (nlaps.draw(rd, xm, ym, mousdr, 550, true)) {
            bool = true;
        }
        if (tracks.draw(rd, xm, ym, mousdr, 550, true)) {
            bool = true;
        }
        if (witho.draw(rd, xm, ym, mousdr, 550, true)) {
            bool = true;
        }
        if (bool) {
            mousePressed = 0;
        }
    }

    /**
     * Fixtext.
     *
     * @param textfield the textfield
     */
    private static void fixtext(final TextField textfield) {
        String string = textfield.getText();
        string = string.replace('\"', '#');
        final String string330 = "\\";
        String string331 = "";
        int i = 0;
        int i332 = -1;
        rd.setFont(FontConstants.arial_12);
        ftm = rd.getFontMetrics();
        for (/**/; i < string.length(); i++) {
            final String string333 = "" + string.charAt(i);
            if (string333.equals("|") || string333.equals(",") || string333.equals("(") || string333.equals(")") || string333.equals("#") || string333.equals(string330) || string333.equals("!") || string333.equals("?") || string333.equals("~") || string333.equals(".") || string333.equals("@") || string333.equals("$") || string333.equals("%") || string333.equals("^") || string333.equals("&") || string333.equals("*") || string333.equals("+") || string333.equals("=") || string333.equals(">") || string333.equals("<") || string333.equals("/") || string333.equals(";") || string333.equals(":") || ftm.stringWidth(string331) > 274) {
                i332 = i;
            } else {
                string331 = "" + string331 + string333;
            }
        }
        if (i332 != -1) {
            textfield.setText(string331);
            textfield.select(i332, i332);
        }
    }

    /**
     * Gets the image.
     *
     * @param string the string
     * @return the image
     */
    private static Image getImage(final String string) {
        final Image image = Toolkit.getDefaultToolkit().createImage(string);
        final MediaTracker mediatracker = new MediaTracker(gameFrame);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (final Exception ignored) {

        }
        return image;
    }

    /**
     * Gets the int.
     *
     * @param string the string
     * @param string354 the string354
     * @param i the i
     * @return the int
     */
    private static int getint(final String string, final String string354, final int i) {
        int i355 = 0;
        String string356 = "";
        for (int i357 = string.length() + 1; i357 < string354.length(); i357++) {
            final String string358 = "" + string354.charAt(i357);
            if (string358.equals(",") || string358.equals(")")) {
                i355++;
                i357++;
            }
            if (i355 == i) {
                string356 = "" + string356 + string354.charAt(i357);
            }
        }
        return Integer.parseInt(string356);
    }

    /**
     * Gets the string.
     *
     * @param string the string
     * @param string349 the string349
     * @param i the i
     * @return the string
     */
    private static String getstring(final String string, final String string349, final int i) {
        int i350 = 0;
        String string351 = "";
        for (int i352 = string.length() + 1; i352 < string349.length(); i352++) {
            final String string353 = "" + string349.charAt(i352);
            if (string353.equals(",") || string353.equals(")")) {
                i350++;
                i352++;
            }
            if (i350 == i) {
                string351 = "" + string351 + string349.charAt(i352);
            }
        }
        return string351;
    }

    /**
     * Gets the svalue.
     *
     * @param string the string
     * @param string376 the string376
     * @param i the i
     * @return the svalue
     */
    private static String getSvalue(final String string, final String string376, final int i) {
        String string377 = "";
        int i378 = 0;
        for (int i379 = string.length() + 1; i379 < string376.length() && i378 <= i; i379++) {
            final String string380 = "" + string376.charAt(i379);
            if (string380.equals(",") || string380.equals(")")) {
                i378++;
            } else if (i378 == i) {
                string377 = "" + string377 + string380;
            }
        }
        return string377;
    }

    /**
     * Hidefields.
     */
    private static void hidefields() {
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

        for (final JComponent f : fields) {
            if (f != null) {
                f.setVisible(false);
            }
        }
        hasLostFocus = false;
        scrfield.setVisible(false);
    }

    private static int dragOriginX;
    private static int dragOriginY;

    private static int mouseDragToX;
    private static int mouseDragToY;

    /**
     * Inits the applet.
     */
    private void initApplet() {
        setBackground(Color.black);
        rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        setLayout(null);
        //slstage.setFont(FontConstants.arial_13);
        slstage.add(rd, "Select a Stage...         ");
        slstage.setForeground(ColorConstants.c_63_80_110);
        slstage.setBackground(ColorConstants.c_209_217_230);
        srch.setFont(FontConstants.arial_12);
        srch.setBackground(Color.white);
        srch.setForeground(Color.black);
        //strtyp.setFont(FontConstants.arial_12);
        strtyp.add(rd, "NormalRoad");
        strtyp.add(rd, "OffRoad");
        strtyp.setBackground(ColorConstants.c_63_80_110);
        strtyp.setForeground(ColorConstants.c_209_217_230);
        //ptyp.setFont(FontConstants.arial_12);

        for (final String menu : menus.menus.keySet()) {
            ptyp.add(rd, menu);
        }

        /*ptyp.add(rd, "Roads");
        ptyp.add(rd, "Ramps");
        ptyp.add(rd, "Obstacles");
        ptyp.add(rd, "Checkpoint");
        ptyp.add(rd, "Fixing Hoop");
        ptyp.add(rd, "Skyline");
        ptyp.add(rd, "Ground Pile");*/

        ptyp.setBackground(ColorConstants.c_63_80_110);
        ptyp.setForeground(ColorConstants.c_209_217_230);
        //part.setFont(FontConstants.arial_12);
        part.add(rd, "Halfpipe-Normal-Road Blend");
        part.setBackground(ColorConstants.c_63_80_110);
        part.setForeground(ColorConstants.c_209_217_230);
        fixh.setFont(FontConstants.arial_12);
        fixh.setBackground(Color.white);
        fixh.setForeground(Color.black);
        mgen.setFont(FontConstants.arial_12);
        mgen.setBackground(Color.white);
        mgen.setForeground(Color.black);
        pfog.setFont(FontConstants.arial_12);
        pfog.setBackground(Color.white);
        pfog.setForeground(Color.black);
        //nlaps.setFont(FontConstants.arial_12);
        for (int i = 0; i < 15; i++) {
            nlaps.add(rd, " " + (i + 1) + " ");
        }
        nlaps.setBackground(ColorConstants.c_63_80_110);
        nlaps.setForeground(ColorConstants.c_209_217_230);
        //tracks.setFont(FontConstants.arial_12);
        tracks.add(rd, "Select MOD Track");
        tracks.setForeground(ColorConstants.c_63_80_110);
        tracks.setBackground(ColorConstants.c_209_217_230);
        //witho.setFont(FontConstants.arial_12);
        witho.add(rd, "With other cars");
        witho.add(rd, "Alone");
        witho.setBackground(ColorConstants.c_63_80_110);
        witho.setForeground(ColorConstants.c_209_217_230);
        tnick.setFont(FontConstants.arial_13);
        tnick.setBackground(Color.white);
        tnick.setForeground(Color.black);
        tpass.setFont(FontConstants.arial_13);
        tpass.setEchoChar('*');
        tpass.setBackground(Color.white);
        tpass.setForeground(Color.black);
        //pubtyp.setFont(FontConstants.arial_13);
        pubtyp.add(rd, "Private");
        pubtyp.add(rd, "Public");
        pubtyp.add(rd, "Super Public");
        pubtyp.setBackground(ColorConstants.c_63_80_110);
        pubtyp.setForeground(ColorConstants.c_209_217_230);
        add(tnick);
        add(tpass);
        add(srch);
        add(fixh);
        add(mgen);
        add(pfog);
        hidefields();
    }

    private static boolean toggle_drawpartids = true;
    private static boolean toggle_drawmouse = true;
    private static int fakezy = 6;

    /**
     * Added check to prevent the list reappearing when it has intentionally disappeared
     */
    private static boolean hasLostFocus;

    /**
     * Loadbase.
     */
    private static void loadbase() {
        try {
            final File file = new File(Madness.fpath + "data/models.zip");
            final ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));

            ZipEntry zipentry = zipinputstream.getNextEntry();
            for (; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = -1;
                for (int i176 = 0; i176 < GameSparker.stageRads.length; i176++) {
                    if (zipentry.getName().equals(GameSparker.stageRads[i176] + ".rad")) {
                        i = i176;
                    }
                }
                if (i != -1) {
                    int entrySize = (int) zipentry.getSize();
                    final byte[] b = new byte[entrySize];
                    int totalBytes = 0;
                    int readByte;
                    for (; entrySize > 0; entrySize -= readByte) {
                        readByte = zipinputstream.read(b, totalBytes, entrySize);
                        totalBytes += readByte;
                    }
                    /*try {
                        b = EncryptOurZIPFiles.handleByteArray(b, true);
                    } catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | ClassNotFoundException | ShortBufferException e) {
                        e.printStackTrace();
                    }*/

                    bco[i] = new SMContO(b);
                    for (int i180 = 0; i180 < bco[i].npl; i180++) {
                        bco[i].p[i180].loadprojf();
                        //if (i == 31)
                        //  bco[i].elec = true;
                    }
                } else {
                    System.err.println("Failed to load entry: " + zipentry.getName());
                }
            }
            zipinputstream.close();
            bco[BUMP_SET_ID] = new SMContO((int) (10000.0 * ThreadLocalRandom.current().nextDouble()), (int) pwd, (int) phd, 0, 0, 0);
        } catch (final Exception exception) {
            JOptionPane.showMessageDialog(null, "Unable to load file 'data/models.zip'!\nError:\n" + exception, "Stage Maker", 1);
            exception.printStackTrace();
        }
        System.gc();
    }

    /**
     * Loadsettings.
     */
    private static void loadsettings() {
        try {
            final File file = new File("mystages/settings.data");
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
                    if (!suser.equals("Horaks")) {
                        tnick.setText(suser);
                    }
                }
                bufferedreader.close();
            }
        } catch (final Exception ignored) {

        }
    }

    /**
     * Movefield.
     *
     * @param component the component
     * @param x the i
     * @param y the i169
     * @param w the i170
     * @param h the i171
     */
    private static void movefield(final Component component, int x, int y, final int w, final int h) {
        x += apx;
        y += apy;
        if (component.getX() != x || component.getY() != y || component.getWidth() != w || component.getHeight() != h) {
            component.setBounds(x, y, w, h);
        }
    }

    /**
     * Newstage.
     */
    private static void newstage() {
        if (!srch.getText().equals("")) {
            final File file = new File("mystages/" + srch.getText() + ".txt");
            if (!file.exists()) {
                stagename = srch.getText();
                tstage = "snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\r\nmountains(" + (int) (ThreadLocalRandom.current().nextDouble() * 100000.0) + ")\r\nnlaps(5)\r\n\r\n";
                if (strtyp.getSelectedIndex() == 1) {
                    bstage = "set(48,0,0,250,0)\r\n";
                } else {
                    bstage = "set(47,0,0,250,0)\r\n";
                }
                bstage += "\r\nmaxl(3,-7200,-4800)\r\nmaxb(3,-7200,-4800)\r\nmaxr(3,7200,-4800)\r\nmaxt(3,7200,-4800)\r\n";
                savefile();
                strtyp.setVisible(false);
                srch.setVisible(false);
                sfase = 0;
                tabed = -2;
            } else {
                JOptionPane.showMessageDialog(null, "A stage with that name already exists, please choose another name!", "Stage Maker", 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a stage name first!", "Stage Maker", 1);
        }
    }

    /**
     * Ovbutton.
     *
     * @param string the string
     * @param i the i
     * @param i387 the i387
     * @return true, if successful
     */
    private static boolean ovbutton(final String string, final int i, final int i387) {
        rd.setFont(new Font("Arial", 0, 12));
        ftm = rd.getFontMetrics();
        if (string.equals("X") || string.equals("Download")) {
            rd.setFont(FontConstants.arial_12);
            ftm = rd.getFontMetrics();
        }
        final int i388 = ftm.stringWidth(string);
        final int i389 = 4;
        boolean bool;
        boolean bool390 = false;
        bool = Math.abs(xm - i) < i388 / 2 + 12 && Math.abs(ym - i387 + 5) < 10 && mousePressed == 1;
        if (Math.abs(xm - i) < i388 / 2 + 12 && Math.abs(ym - i387 + 5) < 10 && mousePressed == -1) {
            mousePressed = 0;
            bool390 = true;
        }
        if (!bool) {
            rd.setColor(ColorConstants.c_220_220_220);
            rd.fillRect(i - i388 / 2 - 10, i387 - (17 - i389), i388 + 20, 25 - i389 * 2);
            rd.setColor(ColorConstants.c_240_240_240);
            rd.drawLine(i - i388 / 2 - 10, i387 - (17 - i389), i + i388 / 2 + 10, i387 - (17 - i389));
            rd.drawLine(i - i388 / 2 - 10, i387 - (18 - i389), i + i388 / 2 + 10, i387 - (18 - i389));
            rd.setColor(ColorConstants.c_240_240_240);
            rd.drawLine(i - i388 / 2 - 9, i387 - (19 - i389), i + i388 / 2 + 9, i387 - (19 - i389));
            rd.setColor(ColorConstants.c_200_200_200);
            rd.drawLine(i + i388 / 2 + 10, i387 - (17 - i389), i + i388 / 2 + 10, i387 + 7 - i389);
            rd.drawLine(i + i388 / 2 + 11, i387 - (17 - i389), i + i388 / 2 + 11, i387 + 7 - i389);
            rd.setColor(ColorConstants.c_200_200_200);
            rd.drawLine(i + i388 / 2 + 12, i387 - (16 - i389), i + i388 / 2 + 12, i387 + 6 - i389);
            rd.drawLine(i - i388 / 2 - 10, i387 + 7 - i389, i + i388 / 2 + 10, i387 + 7 - i389);
            rd.drawLine(i - i388 / 2 - 10, i387 + 8 - i389, i + i388 / 2 + 10, i387 + 8 - i389);
            rd.setColor(ColorConstants.c_200_200_200);
            rd.drawLine(i - i388 / 2 - 9, i387 + 9 - i389, i + i388 / 2 + 9, i387 + 9 - i389);
            rd.setColor(ColorConstants.c_240_240_240);
            rd.drawLine(i - i388 / 2 - 10, i387 - (17 - i389), i - i388 / 2 - 10, i387 + 7 - i389);
            rd.drawLine(i - i388 / 2 - 11, i387 - (17 - i389), i - i388 / 2 - 11, i387 + 7 - i389);
            rd.setColor(ColorConstants.c_240_240_240);
            rd.drawLine(i - i388 / 2 - 12, i387 - (16 - i389), i - i388 / 2 - 12, i387 + 6 - i389);
            rd.setColor(Color.black);
            if (string.equals("X")) {
                rd.setColor(Color.red);
            }
            if (string.equals("Download")) {
                rd.setColor(ColorConstants.c_0_64_128);
            }
            rd.drawString(string, i - i388 / 2, i387);
        } else {
            rd.setColor(ColorConstants.c_220_220_220);
            rd.fillRect(i - i388 / 2 - 10, i387 - (17 - i389), i388 + 20, 25 - i389 * 2);
            rd.setColor(ColorConstants.c_192_192_192);
            rd.drawLine(i - i388 / 2 - 10, i387 - (17 - i389), i + i388 / 2 + 10, i387 - (17 - i389));
            rd.drawLine(i - i388 / 2 - 10, i387 - (18 - i389), i + i388 / 2 + 10, i387 - (18 - i389));
            rd.drawLine(i - i388 / 2 - 9, i387 - (19 - i389), i + i388 / 2 + 9, i387 - (19 - i389));
            rd.setColor(ColorConstants.c_247_247_247);
            rd.drawLine(i + i388 / 2 + 10, i387 - (17 - i389), i + i388 / 2 + 10, i387 + 7 - i389);
            rd.drawLine(i + i388 / 2 + 11, i387 - (17 - i389), i + i388 / 2 + 11, i387 + 7 - i389);
            rd.drawLine(i + i388 / 2 + 12, i387 - (16 - i389), i + i388 / 2 + 12, i387 + 6 - i389);
            rd.drawLine(i - i388 / 2 - 10, i387 + 7 - i389, i + i388 / 2 + 10, i387 + 7 - i389);
            rd.drawLine(i - i388 / 2 - 10, i387 + 8 - i389, i + i388 / 2 + 10, i387 + 8 - i389);
            rd.drawLine(i - i388 / 2 - 9, i387 + 9 - i389, i + i388 / 2 + 9, i387 + 9 - i389);
            rd.setColor(ColorConstants.c_192_192_192);
            rd.drawLine(i - i388 / 2 - 10, i387 - (17 - i389), i - i388 / 2 - 10, i387 + 7 - i389);
            rd.drawLine(i - i388 / 2 - 11, i387 - (17 - i389), i - i388 / 2 - 11, i387 + 7 - i389);
            rd.drawLine(i - i388 / 2 - 12, i387 - (16 - i389), i - i388 / 2 - 12, i387 + 6 - i389);
            rd.setColor(Color.black);
            if (string.equals("X")) {
                rd.setColor(Color.red);
            }
            if (string.equals("Download")) {
                rd.setColor(ColorConstants.c_0_64_128);
            }
            rd.drawString(string, i - i388 / 2 + 1, i387 + 1);
        }
        return bool390;
    }

    private final static JFrame gameFrame = new JFrame("Stage Maker");

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        stageMaker = new SRCStageMaker();
        final Toolkit tk = Toolkit.getDefaultToolkit();
        final Dimension screenSize = tk.getScreenSize();
        final Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(gameFrame.getGraphicsConfiguration());
        gameFrame.add(stageMaker, BorderLayout.CENTER);
        gameFrame.setSize(800, 550);
        gameFrame.setResizable(false);
        gameFrame.setPreferredSize(new Dimension(800, 580));

        gameFrame.setLocation(screenSize.width / 2 - 700 / 2, (screenSize.height - scnMax.bottom) / 2 - 450 / 2);
        /**
         * make sure everything closes on close
         */
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setIconImage(Toolkit.getDefaultToolkit().createImage(Madness.fpath + "data/iconsm.png"));
        gameFrame.setIgnoreRepaint(true);

        gameFrame.pack();
        gameFrame.setVisible(true);
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(final Graphics graphics) {
        try {
            gameTick();
        } catch (final Exception e) {
            e.printStackTrace();
            trash();
            System.exit(3);
        }
        apx = getWidth() / 2 - 400;
        apy = getHeight() / 2 - 275;
        graphics.drawImage(offImage, apx, apy, this);
    }

    private void trash() {
        try {
            track.unload();
        } catch (final Exception ignored) {

        }
        track = null;
        try {
            rd.dispose();
        } catch (final Exception ignored) {

        }
        System.gc();
    }

    /**
     * Py.
     *
     * @param i the i
     * @param i343 the i343
     * @param i344 the i344
     * @param i345 the i345
     * @return the int
     */
    private static int py(final int i, final int i343, final int i344, final int i345) {
        return (int) Math.sqrt((i - i343) * (i - i343) + (i344 - i345) * (i344 - i345));
    }

    /**
     * Pyn.
     *
     * @param i the i
     * @param i346 the i346
     * @param i347 the i347
     * @param i348 the i348
     * @return the int
     */
    private static int pyn(final int i, final int i346, final int i347, final int i348) {
        return (i - i346) / 100 * ((i - i346) / 100) + (i347 - i348) / 100 * ((i347 - i348) / 100);
    }

    /**
     * Readstage.
     *
     * @param readstagei the readstagei
     */
    static void readstage(final int readstagei) {
        errd = 0;
        trackname = "";
        nfm.open.Trackers.nt = 0;
        nob = 0;
        xnob = 0;
        nfm.open.CheckPoints.n = 0;
        nfm.open.CheckPoints.nsp = 0;
        nfm.open.CheckPoints.fn = 0;
        nfm.open.CheckPoints.haltall = false;
        nfm.open.CheckPoints.wasted = 0;
        nfm.open.Medium.ground = 250;
        nfm.open.Medium.lightson = false;
        if (readstagei == 0) {
            nfm.open.Medium.snap[0] = 0;
            nfm.open.Medium.snap[1] = 0;
            nfm.open.Medium.snap[2] = 0;
        }
        if (readstagei == 3) {
            tstage = "";
            bstage = "";
        }
        String string = bstage;
        if (readstagei == 1 || readstagei == 2) {
            string = tstage + "\r\n" + bstage;
        }
        int i181 = 0;
        int i182 = 100;
        int i183 = 0;
        int i184 = 100;
        boolean bool = true;
        boolean newline = true;
        String line;

        /**
         * Extremely dirty hack for checking whether a line is valid
         */
        int nobincr;

        try {
            BufferedReader datainputstream;
            if (readstagei == 3) {
                final File file = new File("mystages/" + stagename + ".txt");
                datainputstream = new BufferedReader(new FileReader(file));
                numUndoActions = 0;
            } else {
                datainputstream = new BufferedReader(new StringReader(string));
            }
            String string187;
            while ((string187 = datainputstream.readLine()) != null) {
                line = "" + string187.trim();
                nobincr = nob;
                if (line.startsWith("sky")) {
                    csky[0] = getint("sky", line, 0);
                    csky[1] = getint("sky", line, 1);
                    csky[2] = getint("sky", line, 2);
                    nfm.open.Medium.setsky(csky[0], csky[1], csky[2]);
                    if (readstagei == 3) {
                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("ground")) {
                    cgrnd[0] = getint("ground", line, 0);
                    cgrnd[1] = getint("ground", line, 1);
                    cgrnd[2] = getint("ground", line, 2);
                    nfm.open.Medium.setgrnd(cgrnd[0], cgrnd[1], cgrnd[2]);
                    if (readstagei == 3) {
                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("polys")) {
                    nfm.open.Medium.setpolys(getint("polys", line, 0), getint("polys", line, 1), getint("polys", line, 2));
                    if (readstagei == 3) {
                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("fog")) {
                    cfade[0] = getint("fog", line, 0);
                    cfade[1] = getint("fog", line, 1);
                    cfade[2] = getint("fog", line, 2);
                    nfm.open.Medium.setfade(cfade[0], cfade[1], cfade[2]);
                    if (readstagei == 3) {
                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("texture")) {
                    texture[0] = getint("texture", line, 0);
                    texture[1] = getint("texture", line, 1);
                    texture[2] = getint("texture", line, 2);
                    texture[3] = getint("texture", line, 3);
                    nfm.open.Medium.setexture(texture[0], texture[1], texture[2], texture[3]);
                    if (readstagei == 3) {
                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("clouds")) {
                    cldd[0] = getint("clouds", line, 0);
                    cldd[1] = getint("clouds", line, 1);
                    cldd[2] = getint("clouds", line, 2);
                    cldd[3] = getint("clouds", line, 3);
                    cldd[4] = getint("clouds", line, 4);
                    nfm.open.Medium.setcloads(cldd[0], cldd[1], cldd[2], cldd[3], cldd[4]);
                    if (readstagei == 3) {
                        tstage = tstage + line + "\r\n";
                    }
                }
                if (readstagei != 2 && line.startsWith("snap")) {
                    nfm.open.Medium.setsnap(Utility.getint("snap", line, 0), Utility.getint("snap", line, 1), Utility.getint("snap", line, 2));
                    if (readstagei == 3) {
                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("density")) {
                    nfm.open.Medium.fogd = (getint("density", line, 0) + 1) * 2 - 1;
                    if (nfm.open.Medium.fogd < 1) {
                        nfm.open.Medium.fogd = 1;
                    }
                    if (nfm.open.Medium.fogd > 30) {
                        nfm.open.Medium.fogd = 30;
                    }
                    if (readstagei == 3) {
                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("mountains")) {
                    nfm.open.Medium.mgen = getint("mountains", line, 0);
                    if (readstagei == 3) {

                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("fadefrom")) {
                    nfm.open.Medium.fadfrom(getint("fadefrom", line, 0));
                    origfade = nfm.open.Medium.fade[0];
                    if (readstagei == 3) {

                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("lightson")) {
                    nfm.open.Medium.lightson = true;
                    if (readstagei == 3) {

                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("nlaps")) {
                    nfm.open.CheckPoints.nlaps = getint("nlaps", line, 0);
                    if (nfm.open.CheckPoints.nlaps < 1) {
                        nfm.open.CheckPoints.nlaps = 1;
                    }
                    if (nfm.open.CheckPoints.nlaps > 15) {
                        nfm.open.CheckPoints.nlaps = 15;
                    }
                    if (readstagei == 3) {

                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("soundtrack")) {
                    trackname = getstring("soundtrack", line, 0);
                    trackvol = getint("soundtrack", line, 1);
                    tracksize = getint("soundtrack", line, 2);
                    if (readstagei == 3) {

                        tstage = tstage + line + "\r\n";
                    }
                }
                if (line.startsWith("set")) {
                    int i201 = getint("set", line, 0);
                    if (i201 >= 10 && i201 <= 25) {
                        nfm.open.Medium.loadnew = true;
                    }
                    i201 -= 10;
                    co[nob] = new SMContO(bco[i201], getint("set", line, 1), getint("set", line, 3), getint("set", line, 2), getint("set", line, 4));
                    co[nob].declaredXZ = getint("set", line, 4);
                    co[nob].partID = i201;
                    /*if (line.indexOf(")p") != -1) { //TODO remove maybe?
                        CheckPoints.x[CheckPoints.n] = getint("set", line, 1);
                        CheckPoints.z[CheckPoints.n] = getint("set", line, 2);
                        CheckPoints.y[CheckPoints.n] = 0;
                        CheckPoints.typ[CheckPoints.n] = 0;
                        if (line.indexOf(")pt") != -1) {
                            CheckPoints.typ[CheckPoints.n] = -1;
                        }
                        if (line.indexOf(")pr") != -1) {
                            CheckPoints.typ[CheckPoints.n] = -2;
                        }
                        if (line.indexOf(")po") != -1) {
                            CheckPoints.typ[CheckPoints.n] = -3;
                        }
                        if (line.indexOf(")ph") != -1) {
                            CheckPoints.typ[CheckPoints.n] = -4;
                        }
                        CheckPoints.n++;
                    }*/
                    xnob++;
                    nob++;
                    if (readstagei == 3) {
                        if (newline) {

                            bstage = bstage + "\r\n";
                            newline = false;
                        }

                        bstage = bstage + line + "\r\n";
                    }
                    if (nfm.open.Medium.loadnew) {
                        nfm.open.Medium.loadnew = false;
                    }
                }
                //                if (line.startsWith("base1")) {
                //                    co[nob] = new SMContO(bco[BASE1], getint("base1", line, 0), getint("base1", line, 1), getint("base1", line, 2), 0);
                //                    co[nob].declaredXZ = 0;
                //                    co[nob].partID = BASE1;
                //
                //                    xnob++;
                //                    nob++;
                //                    if (readstagei == 3) {
                //                        if (newline) {
                //                            bstage = bstage + "\r\n";
                //                            newline = false;
                //                        }
                //                        bstage = bstage + line + "\r\n";
                //                    }
                //                }
                //                if (line.startsWith("base2")) {
                //                    co[nob] = new SMContO(bco[BASE2], getint("base2", line, 0), getint("base2", line, 1), getint("base2", line, 2), 0);
                //                    co[nob].declaredXZ = 0;
                //                    co[nob].partID = BASE2;
                //
                //                    xnob++;
                //                    nob++;
                //                    if (readstagei == 3) {
                //                        if (newline) {
                //                            bstage = bstage + "\r\n";
                //                            newline = false;
                //                        }
                //                        bstage = bstage + line + "\r\n";
                //                    }
                //                }
                //                if (line.startsWith("ped_flag1")) {
                //                    co[nob] = new SMContO(bco[PEDESTAL_FLAG1], getint("ped_flag1", line, 0), getint("ped_flag1", line, 1), getint("ped_flag1", line, 2), 0);
                //                    co[nob].declaredXZ = 0;
                //                    co[nob].partID = PEDESTAL_FLAG1;
                //
                //                    xnob++;
                //                    nob++;
                //                    if (readstagei == 3) {
                //                        if (newline) {
                //                            bstage = bstage + "\r\n";
                //                            newline = false;
                //                        }
                //                        bstage = bstage + line + "\r\n";
                //                    }
                //                }
                //                if (line.startsWith("ped_flag2")) {
                //                    co[nob] = new SMContO(bco[PEDESTAL_FLAG2], getint("ped_flag2", line, 0), getint("ped_flag2", line, 1), getint("ped_flag2", line, 2), 0);
                //                    co[nob].declaredXZ = 0;
                //                    co[nob].partID = PEDESTAL_FLAG2;
                //
                //                    xnob++;
                //                    nob++;
                //                    if (readstagei == 3) {
                //                        if (newline) {
                //                            bstage = bstage + "\r\n";
                //                            newline = false;
                //                        }
                //                        bstage = bstage + line + "\r\n";
                //                    }
                //                }
                //                if (line.startsWith("node")) {
                //                    /*int setNum = getint("node", string186, 0);
                //                    if (setNum >= 10 && setNum <= 25) {
                //                        Medium.loadnew = true;
                //                    }
                //                    setNum -= 10;*/
                //                    final int nodeX = getint("node", line, 0);
                //                    final int nodeY = getint("node", line, 1);
                //                    final int nodeZ = getint("node", line, 2);
                //                    //int nodeXZ = getint("node", string186, 4);
                //                    co[nob] = new SMContO(bco[NODE_SET_ID], nodeX, nodeY, nodeZ, 0);
                //                    co[nob].declaredXZ = 0; //declaredXZ is the angle because no cras!
                //                    co[nob].partID = NODE_SET_ID;
                //                    CheckPoints.x[CheckPoints.n] = nodeX;
                //                    CheckPoints.z[CheckPoints.n] = nodeZ;
                //                    CheckPoints.y[CheckPoints.n] = nodeY;
                //                    CheckPoints.typ[CheckPoints.n] = 0;
                //                    if (line.contains(")pt")) {
                //                        CheckPoints.typ[CheckPoints.n] = -1;
                //                    }
                //                    if (line.contains(")pr")) {
                //                        CheckPoints.typ[CheckPoints.n] = -2;
                //                    }
                //                    if (line.contains(")po")) {
                //                        CheckPoints.typ[CheckPoints.n] = -3;
                //                    }
                //                    if (line.contains(")ph")) {
                //                        CheckPoints.typ[CheckPoints.n] = -4;
                //                    }
                //                    co[nob].checkpoint = CheckPoints.nsp + 1;
                //                    if (line.contains(")r")) { // // means this set should stay in its original position in `co[]`
                //                        co[nob].wh = CheckPoints.nsp + 1;
                //                    }
                //                    CheckPoints.n++;
                //                    CheckPoints.nsp++;
                //                    xnob++;
                //                    nob++;
                //                    if (readstagei == 3) {
                //                        if (newline) {
                //
                //                            bstage = bstage + "\r\n";
                //                            newline = false;
                //                        }
                //
                //                        bstage = bstage + line + "\r\n";
                //                    }
                //                    if (Medium.loadnew) {
                //                        Medium.loadnew = false;
                //                    }
                //                }
                if (line.startsWith("chk")) {
                    int i204 = getint("chk", line, 0);
                    i204 -= 10;
                    //int i205 = m.ground - bco[i204].grat;
                    //if (i204 == 54)
                    //  i205 = getint("chk", string186, 4);
                    co[nob] = new SMContO(bco[i204], getint("chk", line, 1), getint("chk", line, 3), getint("chk", line, 2), getint("chk", line, 4));
                    co[nob].declaredXZ = getint("chk", line, 4);
                    co[nob].partID = i204;
                    nfm.open.CheckPoints.x[nfm.open.CheckPoints.n] = getint("chk", line, 1);
                    nfm.open.CheckPoints.z[nfm.open.CheckPoints.n] = getint("chk", line, 2);
                    nfm.open.CheckPoints.y[nfm.open.CheckPoints.n] = getint("chk", line, 3);
                    if (getint("chk", line, 3) == 0) {
                        nfm.open.CheckPoints.typ[nfm.open.CheckPoints.n] = 1;
                    } else {
                        nfm.open.CheckPoints.typ[nfm.open.CheckPoints.n] = 2;
                    }
                    nfm.open.CheckPoints.pcs = nfm.open.CheckPoints.n;
                    nfm.open.CheckPoints.n++;
                    co[nob].checkpoint = nfm.open.CheckPoints.nsp + 1;
                    if (line.contains(")r")) { // means this set should stay in its original position in `co[]`
                        co[nob].wh = nfm.open.CheckPoints.nsp + 1;
                    }
                    nfm.open.CheckPoints.nsp++;
                    xnob++;
                    nob++;
                    if (readstagei == 3) {
                        if (newline) {

                            bstage = bstage + "\r\n";
                            newline = false;
                        }

                        bstage = bstage + line + "\r\n";
                    }
                }
                if (line.startsWith("fix")) {
                    int i208 = getint("fix", line, 0);
                    i208 -= 10;
                    co[nob] = new SMContO(bco[i208], getint("fix", line, 1), getint("fix", line, 3), getint("fix", line, 2), getint("fix", line, 4));
                    co[nob].declaredXZ = getint("fix", line, 4);
                    co[nob].partID = i208;
                    nfm.open.CheckPoints.fx[nfm.open.CheckPoints.fn] = getint("fix", line, 1);
                    nfm.open.CheckPoints.fz[nfm.open.CheckPoints.fn] = getint("fix", line, 2);
                    nfm.open.CheckPoints.fy[nfm.open.CheckPoints.fn] = getint("fix", line, 3);
                    //co[nob].elec = true;
                    if (getint("fix", line, 4) != 0) {
                        nfm.open.CheckPoints.roted[nfm.open.CheckPoints.fn] = true;
                        co[nob].roted = true;
                    } else {
                        nfm.open.CheckPoints.roted[nfm.open.CheckPoints.fn] = false;
                    }
                    nfm.open.CheckPoints.special[nfm.open.CheckPoints.fn] = line.contains(")s");
                    nfm.open.CheckPoints.fn++;
                    xnob++;
                    nob++;
                    if (readstagei == 3) {
                        if (newline) {

                            bstage = bstage + "\r\n";
                            newline = false;
                        }

                        bstage = bstage + line + "\r\n";
                    }
                }
                if (line.startsWith("pile")) { //TODO ADD HERE
                    co[nob] = new SMContO(getint("pile", line, 0), getint("pile", line, 1), getint("pile", line, 2), getint("pile", line, 3), getint("pile", line, 4), nfm.open.Medium.ground);
                    co[nob].srz = getint("pile", line, 0);
                    co[nob].srx = getint("pile", line, 1);
                    co[nob].sry = getint("pile", line, 2);
                    co[nob].partID = BUMP_SET_ID;
                    xnob++;
                    nob++;
                    if (readstagei == 3) {
                        if (newline) {

                            bstage = bstage + "\r\n";
                            newline = false;
                        }

                        bstage = bstage + line + "\r\n";
                    }
                }
                if (line.startsWith("maxr")) {
                    final int i213 = getint("maxr", line, 0);
                    final int i214 = getint("maxr", line, 1);
                    i181 = i214;
                    final int i215 = getint("maxr", line, 2);
                    for (int i216 = 0; i216 < i213; i216++) {
                        co[nob] = new SMContO(bco[29], i214, nfm.open.Medium.ground - bco[29].grat, i216 * 4800 + i215, 0);
                        if (readstagei == 0) {
                            xnob++;
                        } else {
                            nob++;
                        }
                    }
                    if (readstagei == 3) {
                        if (bool) {

                            bstage = bstage + "\r\n";
                            bool = false;
                        }

                        bstage = bstage + line + "\r\n";
                    }
                }
                if (line.startsWith("maxl")) {
                    final int i219 = getint("maxl", line, 0);
                    final int i220 = getint("maxl", line, 1);
                    i182 = i220;
                    final int i221 = getint("maxl", line, 2);
                    for (int i222 = 0; i222 < i219; i222++) {
                        co[nob] = new SMContO(bco[29], i220, nfm.open.Medium.ground - bco[29].grat, i222 * 4800 + i221, 180);
                        if (readstagei == 0) {
                            xnob++;
                        } else {
                            nob++;
                        }
                    }
                    if (readstagei == 3) {
                        if (bool) {

                            bstage = bstage + "\r\n";
                            bool = false;
                        }

                        bstage = bstage + line + "\r\n";
                    }
                }
                if (line.startsWith("maxt")) {
                    final int i225 = getint("maxt", line, 0);
                    final int i226 = getint("maxt", line, 1);
                    i183 = i226;
                    final int i227 = getint("maxt", line, 2);
                    for (int i228 = 0; i228 < i225; i228++) {
                        co[nob] = new SMContO(bco[29], i228 * 4800 + i227, nfm.open.Medium.ground - bco[29].grat, i226, 90);
                        if (readstagei == 0) {
                            xnob++;
                        } else {
                            nob++;
                        }
                    }
                    if (readstagei == 3) {
                        if (bool) {

                            bstage = bstage + "\r\n";
                            bool = false;
                        }

                        bstage = bstage + line + "\r\n";
                    }
                }
                if (line.startsWith("maxb")) {
                    final int i231 = getint("maxb", line, 0);
                    final int i232 = getint("maxb", line, 1);
                    i184 = i232;
                    final int i233 = getint("maxb", line, 2);
                    for (int i234 = 0; i234 < i231; i234++) {
                        co[nob] = new SMContO(bco[29], i234 * 4800 + i233, nfm.open.Medium.ground - bco[29].grat, i232, -90);
                        if (readstagei == 0) {
                            xnob++;
                        } else {
                            nob++;
                        }
                    }
                    if (readstagei == 3) {
                        if (bool) {

                            bstage = bstage + "\r\n";
                            bool = false;
                        }

                        bstage = bstage + line + "\r\n";
                    }
                }
                if (nobincr != nob && !line.startsWith("//") && line.contains(")f=") || line.contains(",f=")) {
                    final String s = line.substring(line.indexOf("f=") + "f=".length());
                    co[nob - 1].declaredPositionInArray = Integer.parseInt(s);
                }
            }
            datainputstream.close();
            nfm.open.Medium.newpolys(i182, i181 - i182, i184, i183 - i184, nob);
            nfm.open.Medium.newclouds(i182, i181, i184, i183);
            nfm.open.Medium.newmountains(i182, i181, i184, i183);
            nfm.open.Medium.newstars();
        } catch (final Exception exception) {
            errd = 6;
            if (nfm.open.CheckPoints.fn >= 5) {
                errd = 5;
            }
            if (nfm.open.Trackers.nt >= 670000) {
                errd = 1;
            }
            if (nfm.open.CheckPoints.n >= 10000) {
                errd = 2;
            }
            if (nob >= 10000) {
                errd = 4;
            }
        }
        // stage size limit
        //if (Medium.nrw * Medium.ncl >= 16000)
        //    errd = 3;
        // piece limit
        if (xnob >= 10000) {
            errd = 4;
        }

    }

    /**
     * Remove stage part.
     */
    private static void removesp() {
        sortstage();
        if (numUndoActions < MAX_UNDO_ACTIONS) {
            undoContoID[numUndoActions] = co[esp].partID;
            undoContoX[numUndoActions] = co[esp].x;
            undoContoY[numUndoActions] = co[esp].y;
            undoContoZ[numUndoActions] = co[esp].z;
            undoContoXZ[numUndoActions] = co[esp].xz; // declaredXZ maybe
            undoIsRemove[numUndoActions] = true;
            numUndoActions++;
        }
        String string;
        // pretty much searches for the stage part
        if (!floats) {
            if (co[esp].partID == FIXHOOP_SET_ID) {
                string = "fix(" + (co[esp].partID + 10) + "," + co[esp].x + "," + co[esp].z + "," + co[esp].y + "," + co[esp].declaredXZ + ")";
            } else if (co[esp].partID == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, co[esp].partID) || co[esp].partID == OFFROAD_CHECKPOINT_SET_ID) {
                string = "chk(" + (co[esp].partID + 10) + "," + co[esp].x + "," + co[esp].z + "," + co[esp].declaredXZ + ")";
            } else if (co[esp].partID == FLYING_CHECKPOINT_SET_ID) {
                string = "chk(" + (co[esp].partID + 10) + "," + co[esp].x + "," + co[esp].z + "," + co[esp].declaredXZ + "," + co[esp].y + ")";
            } else if (co[esp].partID == BUMP_SET_ID) {
                string = "pile(" + co[esp].srz + "," + co[esp].srx + "," + co[esp].sry + "," + co[esp].x + "," + co[esp].z + ")";
            } else {
                string = "set(" + (co[esp].partID + 10) + "," + co[esp].x + "," + co[esp].z + "," + co[esp].declaredXZ + ")";
            }
        } else {
            if (co[esp].partID == FIXHOOP_SET_ID) {
                string = "fix(" + (co[esp].partID + 10) + "," + co[esp].x + "," + co[esp].z + "," + co[esp].y + "," + co[esp].declaredXZ + ")";
            } else if (co[esp].partID == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, co[esp].partID) || co[esp].partID == OFFROAD_CHECKPOINT_SET_ID) {
                string = "chk(" + (co[esp].partID + 10) + "," + co[esp].x + "," + co[esp].z + "," + co[esp].y + "," + co[esp].declaredXZ + ")";
            } else if (co[esp].partID == FLYING_CHECKPOINT_SET_ID) {
                string = "chk(" + (co[esp].partID + 10) + "," + co[esp].x + "," + co[esp].z + "," + co[esp].y + "," + co[esp].declaredXZ + ")";
            } else if (co[esp].partID == BUMP_SET_ID) {
                string = "pile(" + co[esp].srz + "," + co[esp].srx + "," + co[esp].sry + "," + co[esp].x + "," + co[esp].z + ")";
            } else {
                string = "set(" + (co[esp].partID + 10) + "," + co[esp].x + "," + co[esp].z + "," + co[esp].y + "," + co[esp].declaredXZ + ")";
            }
        }
        final int i = bstage.indexOf(string);
        int i166 = i + string.length();
        int i167 = -1;
        int i168 = bstage.indexOf("set", i166);
        if (i168 != -1) {
            i167 = i168;
        }
        i168 = bstage.indexOf("chk", i166);
        if (i168 != -1 && i168 < i167) {
            i167 = i168;
        }
        i168 = bstage.indexOf("fix", i166);
        if (i168 != -1 && i168 < i167) {
            i167 = i168;
        }
        if (i167 == -1) {
            i167 = bstage.indexOf("\r\n", i166);
            if (i167 != -1) {
                i167++;
            }
        }
        if (i167 != -1) {
            i166 = i167;
        }
        if (i != -1) {
            bstage = "" + bstage.substring(0, i) + bstage.substring(i166, bstage.length());
        }
        readstage(0);
    }

    /**
     * Renstage.
     *
     * @param string the string
     */
    private static void renstage(final String string) {
        if (string.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Enter a New Stage Name!\n", "Stage Maker", 1);
        } else {
            try {
                final File file = new File("mystages/" + stagename + ".txt");
                final File file329 = new File("mystages/" + string + ".txt");
                if (file.renameTo(file329)) {
                    stagename = string;
                    sfase = 0;
                    hidefields();
                    tabed = -2;
                } else {
                    JOptionPane.showMessageDialog(null, "Unable to rename stage to: '" + string + "', possible reason: stage name already used!\n", "Stage Maker", 1);
                }
            } catch (final Exception exception) {
                JOptionPane.showMessageDialog(null, "Unable to rename file! Error Deatials:\n" + exception, "Stage Maker", 1);
            }
        }
    }

    /**
     * Rot.
     *
     * @param is the is
     * @param is334 the is334
     * @param i the i
     * @param i335 the i335
     * @param i336 the i336
     * @param i337 the i337
     */
    private static void rot(final int[] is, final int[] is334, final int i, final int i335, final int i336, final int i337) {
        if (i336 != 0) {
            for (int i338 = 0; i338 < i337; i338++) {
                final int i339 = is[i338];
                final int i340 = is334[i338];
                is[i338] = i + (int) ((i339 - i) * nfm.open.Medium.cos(i336) - (i340 - i335) * nfm.open.Medium.sin(i336));
                is334[i338] = i335 + (int) ((i339 - i) * nfm.open.Medium.sin(i336) + (i340 - i335) * nfm.open.Medium.cos(i336));
            }
        }
    }

    /**
     * :P.
     */
    static {
        final String username = System.getProperty("user.name");
        if (username.equals("Kaffeinated")) {
            kSettings = true;
        }
        if (username.equals("Rafael")) {
            isHansen = true;
            System.out.println("Settings set! You're Chris Hansen");
        }
    }

    /**
     * Instantiates a new stage maker.
     */
    private SRCStageMaker() {
        new Medium();
        asin_m_xz = nfm.open.Medium.sin(nfm.open.Medium.xz);
        acos_m_xz = nfm.open.Medium.cos(nfm.open.Medium.xz);
        asin_m_zy = nfm.open.Medium.sin(nfm.open.Medium.zy);
        acos_m_zy = nfm.open.Medium.cos(nfm.open.Medium.zy);
        asin_m_xy = nfm.open.Medium.sin(__m_xy);
        acos_m_xy = nfm.open.Medium.cos(__m_xy);
        new Trackers();
        new TextEditor();
        logo = getImage("data/stagemakerlogo.gif");

        setIgnoreRepaint(true);

        initApplet();

        //btgame[0] = getImage("data/backtogame1.gif");
        //btgame[1] = getImage("data/backtogame2.gif");
        for (int i = 0; i < 2; i++) {
            su[i] = getImage("data/su" + (i + 1) + ".gif");
            sl[i] = getImage("data/sl" + (i + 1) + ".gif");
            sd[i] = getImage("data/sd" + (i + 1) + ".gif");
            sr[i] = getImage("data/sr" + (i + 1) + ".gif");
            zi[i] = getImage("data/zi" + (i + 1) + ".gif");
            zo[i] = getImage("data/zo" + (i + 1) + ".gif");
        }
        loadbase();
        loadsettings();
        requestFocus();
        // my code to print the mouse pos every second || why
        /*new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (false) System.out.println("x: " + ((xm - 505) * (Math.abs(sy) / Medium.focusPoint) + sx));
                    if (false) System.out.println("z: " + ((290 - ym) * (Math.abs(sy) / Medium.focusPoint) + sz));
                    if (false) System.out.println("y: " + (Medium.ground - bco[selectedPart].grat));
                    if (false) System.out.println("rot: " + (rot + adrot));
                    try {
                        sleep(1000L); //time in milisseconds it will wait before printing again
                                      //set this too low and the game will lag like hell
                    } catch (final InterruptedException e) {
                        }
                }
            }
        }.start();*/

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        setFocusable(true);
        requestFocusInWindow();

        final ActionListener theticker = ae -> repaint();
        final Timer timer2 = new Timer(50, theticker);
        timer2.start();

        //bco[selectedPart].x = ;
        //bco[selectedPart].z = ;
        //bco[selectedPart].y =;
        //bco[selectedPart].xz = ;
    }

    /**
     * Game tick.
     */
    private static void gameTick() {
        rd.setColor(Color.white);
        rd.fillRect(0, 25, 800, 525);
        rd.setColor(Color.black);
        if (tab != tabed) {
            hidefields();
        }
        if (tab == 0) {
            if (tabed != tab) {
                slstage.removeAll();
                slstage.maxl = 360;
                slstage.add(rd, "Select a Stage                      ");
                final String[] strings = new File("mystages/").list();
                if (strings != null) {
                    for (final String string : strings) {
                        if (string.toLowerCase().endsWith(".txt")) {
                            slstage.add(rd, string.substring(0, string.length() - 4));
                        }
                    }
                }
                if (stagename.equals("")) {
                    slstage.select(0);
                } else {
                    slstage.select(stagename);
                    if (stagename.equals(slstage.getSelectedItem())) {
                        readstage(3);
                        sx = 0;
                        sz = 1500;
                        sy = -10000;
                    } else {
                        stagename = "";
                        slstage.select(0);
                    }
                }
                mouseon = -1;
                sfase = 0;
            }
            rd.drawImage(logo, 425 - logo.getWidth(null) / 2, 35, null);
            if (xm > 261 && xm < 538 && ym > 35 && ym < 121) {
                if (mouseon == -1) {
                    mouseon = 3;
                    gameFrame.setCursor(new Cursor(12));
                }
            } else if (mouseon == 3) {
                mouseon = -1;
                gameFrame.setCursor(new Cursor(0));
            }
            //if (mouseon == 3 && mousePressed == -1)
            //    openhlink();
            rd.setFont(FontConstants.arial_13);
            ftm = rd.getFontMetrics();
            if (xm > 200 && xm < 550 && ym > 467 && ym < 504) {
                if (mouseon == -1) {
                    mouseon = 2;
                    gameFrame.setCursor(new Cursor(12));
                }
            } else if (mouseon == 2) {
                mouseon = -1;
                gameFrame.setCursor(new Cursor(0));
            }
            if (mouseon == 2) {
                rd.setColor(ColorConstants.c_0_64_128);
            } else {
                rd.setColor(Color.black);
            }
            rd.drawString("For the Stage Maker Homepage, Development Center and Forums :", 400 - ftm.stringWidth("For the Stage Maker Homepage, Development Center and Forums :") / 2, 480);
            rd.setColor(ColorConstants.c_0_128_255);
            String string = "http://www.needformadness.com/developer/";
            rd.drawString(string, 400 - ftm.stringWidth(string) / 2, 500);
            if (mouseon == 2) {
                rd.setColor(ColorConstants.c_0_128_255);
            } else {
                rd.setColor(ColorConstants.c_0_64_128);
            }
            rd.drawLine(400 - ftm.stringWidth(string) / 2, 501, 400 + ftm.stringWidth(string) / 2, 501);
            //if (mouseon == 2 && mousePressed == -1)
            //    openhlink();
            final int i = -110;
            if (xm > 150 && xm < 600 && ym > 467 + i && ym < 504 + i) {
                if (mouseon == -1) {
                    mouseon = 1;
                    gameFrame.setCursor(new Cursor(12));
                }
            } else if (mouseon == 1) {
                mouseon = -1;
                gameFrame.setCursor(new Cursor(0));
            }
            if (mouseon == 1) {
                rd.setColor(ColorConstants.c_0_64_128);
            } else {
                rd.setColor(Color.black);
            }
            rd.drawString("For help and a detailed step by step description on how to use the Stage Maker :", 400 - ftm.stringWidth("For help and a detailed step by step description on how to use the Stage Maker :") / 2, 480 + i);
            rd.setColor(ColorConstants.c_0_128_255);
            string = "http://www.needformadness.com/developer/help.html";
            rd.drawString(string, 400 - ftm.stringWidth(string) / 2, 500 + i);
            if (mouseon == 1) {
                rd.setColor(ColorConstants.c_0_128_255);
            } else {
                rd.setColor(ColorConstants.c_0_64_128);
            }
            rd.drawLine(400 - ftm.stringWidth(string) / 2, 501 + i, 400 + ftm.stringWidth(string) / 2, 501 + i);
            //if (mouseon == 1 && mousePressed == -1)
            //    openlink();
            final int i0 = -60;
            final int i1 = 70;
            rd.setColor(Color.black);
            rd.drawRect(227 - i1, 194 + i0, 346 + i1 * 2, 167 + i1 / 5);
            if (sfase == 0) {
                rd.drawString("Select Stage to Edit", 400 - ftm.stringWidth("Select Stage to Edit") / 2, 230 + i0);
                slstage.move(220, 240 + i0);
                if (slstage.getWidth() != 360) {
                    slstage.setSize(360, 21);
                }
                if (!slstage.isShowing()) {
                    slstage.setVisible(true);
                }
                if (button("    Make new Stage    ", 400, 296 + i0, 0, true)) {
                    srch.setText("");
                    slstage.setVisible(false);
                    sfase = 1;
                }
                if (button("     Rename Stage     ", 325, 336 + i0, 0, false)) {
                    if (!stagename.equals("")) {
                        slstage.setVisible(false);
                        srch.setText(stagename);
                        sfase = 2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a stage to rename first.", "Stage Maker", 1);
                    }
                }
                if (button("      Delete Stage      ", 475, 336 + i0, 0, false)) {
                    if (!stagename.equals("")) {
                        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to permanently delete this stage?\n\n" + stagename + "\n\n", "Stage Maker", 0) == 0) {
                            delstage(stagename);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please select a stage to delete first.", "Stage Maker", 1);
                    }
                }
                if (slstage.getSelectedIndex() != 0) {
                    if (!stagename.equals(slstage.getSelectedItem())) {
                        stagename = slstage.getSelectedItem();
                        readstage(3);
                        sx = 0;
                        sz = 1500;
                        sy = -10000;
                        gameFrame.requestFocus();
                    }
                } else {
                    stagename = "";
                }
            }
            if (sfase == 1) {
                rd.drawString("Make a new Stage", 400 - ftm.stringWidth("Make a new Stage") / 2, 220 + i0);
                rd.setFont(FontConstants.arial_12);
                rd.drawString("New stage name :", 200, 246 + i0);
                movefield(srch, 310, 231 + i0, 290, 23);
                if (!srch.isShowing()) {
                    srch.setVisible(true);
                    srch.requestFocus();
                }
                fixtext(srch);
                rd.drawString("Starting line type :", 293, 272 + i0);
                strtyp.move(408, 256 + i0);
                if (!strtyp.isShowing()) {
                    strtyp.setVisible(true);
                }
                if (button("    Make Stage    ", 400, 311 + i0, 0, true)) {
                    newstage();
                }
                if (button("  Cancel  ", 400, 351 + i0, 0, false)) {
                    strtyp.setVisible(false);
                    srch.setVisible(false);
                    sfase = 0;
                }
            }
            if (sfase == 2) {
                rd.drawString("Rename Stage :  " + stagename, 400 - ftm.stringWidth("Rename Stage :  " + stagename) / 2, 230 + i0);
                rd.setFont(FontConstants.arial_12);
                rd.drawString("New name :", 218, 266 + i0);
                if (!srch.isShowing()) {
                    srch.setVisible(true);
                    srch.requestFocus();
                }
                movefield(srch, 292, 251 + i0, 290, 23);
                fixtext(srch);
                if (button("    Rename Stage    ", 400, 306 + i0, 0, true)) {
                    renstage(srch.getText());
                }
                if (button("  Cancel  ", 400, 346 + i0, 0, false)) {
                    srch.setVisible(false);
                    sfase = 0;
                }
            }
        }
        if (tab == 1) {
            asin_m_xz = nfm.open.Medium.sin(nfm.open.Medium.xz);
            acos_m_xz = nfm.open.Medium.cos(nfm.open.Medium.xz);
            asin_m_zy = nfm.open.Medium.sin(nfm.open.Medium.zy);
            acos_m_zy = nfm.open.Medium.cos(nfm.open.Medium.zy);
            asin_m_xy = nfm.open.Medium.sin(__m_xy);
            acos_m_xy = nfm.open.Medium.cos(__m_xy);
            if (tabed != tab) {
                nfm.open.Medium.trk = 2;
                readstage(0);
                loadPartMenu();
                gameFrame.setCursor(new Cursor(0));
                setcur = false;
                epart = false;
                arrng = false;
                // selects first part for you... meaningless...
                //                if (nob == 1) {
                //                    selectedPartType = 0;
                //                    /*if (co[0].partID == 38) {
                //                        selectedMenuPart = 9;
                //                    } else {
                //                        selectedMenuPart = 0;
                //                    }*/
                //                }
                mouseon = -1;
            }

            //            if (selectedPartType == PART_ROADS) {
            //                if (selectedMenuPart == 0) {
            //                    selectedPart = 0;
            //                } else if (selectedMenuPart == 1) {
            //                    selectedPart = 4;
            //                } else if (selectedMenuPart == 2) {
            //                    selectedPart = 13;
            //                } else if (selectedMenuPart == 3) {
            //                    selectedPart = 3;
            //                } else if (selectedMenuPart == 4) {
            //                    selectedPart = 2;
            //                } else if (selectedMenuPart == 5) {
            //                    selectedPart = 1;
            //                } else if (selectedMenuPart == 6) {
            //                    selectedPart = 35;
            //                } else if (selectedMenuPart == 7) {
            //                    selectedPart = 36;
            //                } else if (selectedMenuPart == 8) {
            //                    selectedPart = 10;
            //                } else if (selectedMenuPart == 9) {
            //                    selectedPart = 5;
            //                } else if (selectedMenuPart == 10) {
            //                    selectedPart = 7;
            //                } else if (selectedMenuPart == 11) {
            //                    selectedPart = 14;
            //                } else if (selectedMenuPart == 12) {
            //                    selectedPart = 6;
            //                } else if (selectedMenuPart == 13) {
            //                    selectedPart = 34;
            //                } else if (selectedMenuPart == 14) {
            //                    selectedPart = 33;
            //                } else if (selectedMenuPart == 15) {
            //                    selectedPart = 11;
            //                } else if (selectedMenuPart == 16) {
            //                    selectedPart = 8;
            //                } else if (selectedMenuPart == 17) {
            //                    selectedPart = 9;
            //                } else if (selectedMenuPart == 18) {
            //                    selectedPart = 15;
            //                } else if (selectedMenuPart == 19) {
            //                    selectedPart = 12;
            //                }
            //
            //            } else if (selectedPartType == PART_RAMPS) {
            //                if (selectedMenuPart == 0) {
            //                    selectedPart = 16;
            //                } else if (selectedMenuPart == 1) {
            //                    selectedPart = 18;
            //                } else if (selectedMenuPart == 2) {
            //                    selectedPart = 19;
            //                } else if (selectedMenuPart == 3) {
            //                    selectedPart = 22;
            //                } else if (selectedMenuPart == 4) {
            //                    selectedPart = 17;
            //                } else if (selectedMenuPart == 5) {
            //                    selectedPart = 21;
            //                } else if (selectedMenuPart == 6) {
            //                    selectedPart = 20;
            //                } else if (selectedMenuPart == 7) {
            //                    selectedPart = 39;
            //                } else if (selectedMenuPart == 8) {
            //                    selectedPart = 42;
            //                } else if (selectedMenuPart == 9) {
            //                    selectedPart = 40;
            //                } else if (selectedMenuPart == 10) {
            //                    selectedPart = 23;
            //                } else if (selectedMenuPart == 11) {
            //                    selectedPart = 25;
            //                } else if (selectedMenuPart == 12) {
            //                    selectedPart = 24;
            //                } else if (selectedMenuPart == 15) {
            //                    selectedPart = 26;
            //                }
            //            } else if (selectedPartType == PART_OBSTACLES) {
            //                if (selectedMenuPart == 0) {
            //                    selectedPart = 27;
            //                } else if (selectedMenuPart == 1) {
            //                    selectedPart = 28;
            //                } else if (selectedMenuPart == 2) {
            //                    selectedPart = 41;
            //                }
            //
            //            } else if (selectedPartType == PART_CHECKPOINTS)
            //                if (!onoff) {
            //                    selectedPart = 30;
            //                } else {
            //                    selectedPart = 32;
            //                }
            //            else if (selectedPartType == PART_FIXHOOPS) {
            //                selectedPart = 31;
            //            } else if (selectedPartType == PART_TREES) {
            //
            //                if (selectedMenuPart == 0) {
            //                    selectedPart = 33;
            //                } else if (selectedMenuPart == 1) {
            //                    selectedPart = 34;
            //                } else if (selectedMenuPart == 2) {
            //                    selectedPart = 35;
            //                } else if (selectedMenuPart == 3) {
            //                    selectedPart = 36;
            //                } else if (selectedMenuPart == 4) {
            //                    selectedPart = 37;
            //                } else if (selectedMenuPart == 5) {
            //                    selectedPart = 38;
            //                } else if (selectedMenuPart == 6) {
            //                    selectedPart = 39;
            //                } else if (selectedMenuPart == 7) {
            //                    selectedPart = 40;
            //                } else if (selectedMenuPart == 8) {
            //                    selectedPart = 41;
            //                } else if (selectedMenuPart == 9) {
            //                    selectedPart = 42;
            //                } else if (selectedMenuPart == 10) {
            //                    selectedPart = 43;
            //                } else if (selectedMenuPart == 11) {
            //                    selectedPart = 44;
            //                } else if (selectedMenuPart == 12) {
            //                    selectedPart = 45;
            //                } else if (selectedMenuPart == 13) {
            //                    selectedPart = 46;
            //                } else if (selectedMenuPart == 14) {
            //                    selectedPart = 47;
            //                } else if (selectedMenuPart == 15) {
            //                    selectedPart = 48;
            //                } else if (selectedMenuPart == 16) {
            //                    selectedPart = 49;
            //                } else if (selectedMenuPart == 17) {
            //                    selectedPart = 50;
            //                } else if (selectedMenuPart == 18) {
            //                    selectedPart = 51;
            //                } else if (selectedMenuPart == 19) {
            //                    selectedPart = 52;
            //                } else if (selectedMenuPart == 20) {
            //                    selectedPart = 53;
            //                } else if (selectedMenuPart == 21) {
            //                    selectedPart = 54;
            //                } else if (selectedMenuPart == 22) {
            //                    selectedPart = 55;
            //                } else if (selectedMenuPart == 23) {
            //                    selectedPart = 56;
            //                } else if (selectedMenuPart == 24) {
            //                    selectedPart = 57;
            //                } else if (selectedMenuPart == 25) {
            //                    selectedPart = 58;
            //                } else if (selectedMenuPart == 26) {
            //                    selectedPart = 59;
            //                } else if (selectedMenuPart == 27) {
            //                    selectedPart = 60;
            //                } else if (selectedMenuPart == 28) {
            //                    selectedPart = 61;
            //                } else if (selectedMenuPart == 29) {
            //                    selectedPart = 62;
            //                } else if (selectedMenuPart == 30) {
            //                    selectedPart = 63;
            //                } else if (selectedMenuPart == 31) {
            //                    selectedPart = 64;
            //                } else if (selectedMenuPart == 32) {
            //                    selectedPart = 65;
            //                } else if (selectedMenuPart == 33) {
            //                    selectedPart = 66;
            //                } else if (selectedMenuPart == 34) {
            //                    selectedPart = 67;
            //                } else if (selectedMenuPart == 35) {
            //                    selectedPart = 68;
            //                } else if (selectedMenuPart == 36) {
            //                    selectedPart = 69;
            //                } else if (selectedMenuPart == 37) {
            //                    selectedPart = 70;
            //                } else if (selectedMenuPart == 38) {
            //                    selectedPart = 71;
            //                } else if (selectedMenuPart == 39) {
            //                    selectedPart = 72;
            //                } else if (selectedMenuPart == 40) {
            //                    selectedPart = 73;
            //                } else if (selectedMenuPart == 41) {
            //                    selectedPart = 74;
            //                } else if (selectedMenuPart == 42) {
            //                    selectedPart = 75;
            //                } else if (selectedMenuPart == 43) {
            //                    selectedPart = 76;
            //                } else if (selectedMenuPart == 44) {
            //                    selectedPart = 77;
            //                } else if (selectedMenuPart == 45) {
            //                    selectedPart = 78;
            //                } else if (selectedMenuPart == 46) {
            //                    selectedPart = 79;
            //                } else if (selectedMenuPart == 47) {
            //                    selectedPart = 80;
            //                } else if (selectedMenuPart == 48) {
            //                    selectedPart = 81;
            //                } else if (selectedMenuPart == 49) {
            //                    selectedPart = 82;
            //                } else if (selectedMenuPart == 50) {
            //                    selectedPart = 83;
            //                } else if (selectedMenuPart == 51) {
            //                    selectedPart = 84;
            //                } else if (selectedMenuPart == 52) {
            //                    selectedPart = 85;
            //                } else if (selectedMenuPart == 53) {
            //                    selectedPart = 86;
            //                } else if (selectedMenuPart == 54) {
            //                    selectedPart = 87;
            //                } else if (selectedMenuPart == 55) {
            //                    selectedPart = 88;
            //                } else if (selectedMenuPart == 56) {
            //                    selectedPart = 89;
            //                } else if (selectedMenuPart == 57) {
            //                    selectedPart = 90;
            //                } else if (selectedMenuPart == 58) {
            //                    selectedPart = 91;
            //                } else if (selectedMenuPart == 59) {
            //                    selectedPart = 92;
            //                } else if (selectedMenuPart == 60) {
            //                    selectedPart = 93;
            //                } else if (selectedMenuPart == 61) {
            //                    selectedPart = 94;
            //                } else if (selectedMenuPart == 62) {
            //                    selectedPart = 95;
            //                } else if (selectedMenuPart == 63) {
            //                    selectedPart = 96;
            //                } else if (selectedMenuPart == 64) {
            //                    selectedPart = 97;
            //                } else if (selectedMenuPart == 65) {
            //                    selectedPart = 98;
            //                } else if (selectedMenuPart == 66) {
            //                    selectedPart = 99;
            //                } else if (selectedMenuPart == 67) {
            //                    selectedPart = 100;
            //                } else if (selectedMenuPart == 68) {
            //                    selectedPart = 101;
            //                } else if (selectedMenuPart == 69) {
            //                    selectedPart = 102;
            //                } else if (selectedMenuPart == 70) {
            //                    selectedPart = 103;
            //                } else if (selectedMenuPart == 71) {
            //                    selectedPart = 104;
            //                } else if (selectedMenuPart == 72) {
            //                    selectedPart = 105;
            //                } else if (selectedMenuPart == 73) {
            //                    selectedPart = 106;
            //                } else if (selectedMenuPart == 74) {
            //                    selectedPart = 107;
            //                } else if (selectedMenuPart == 75) {
            //                    selectedPart = 108;
            //                } else if (selectedMenuPart == 76) {
            //                    selectedPart = 109;
            //                } else if (selectedMenuPart == 77) {
            //                    selectedPart = 110;
            //                } else if (selectedMenuPart == 78) {
            //                    selectedPart = 111;
            //                } else if (selectedMenuPart == 79) {
            //                    selectedPart = 112;
            //                } else if (selectedMenuPart == 80) {
            //                    selectedPart = 113;
            //                } else if (selectedMenuPart == 81) {
            //                    selectedPart = 114;
            //                } else if (selectedMenuPart == 82) {
            //                    selectedPart = 115;
            //                } else if (selectedMenuPart == 83) {
            //                    selectedPart = 116;
            //                } else if (selectedMenuPart == 84) {
            //                    selectedPart = 117;
            //                } else if (selectedMenuPart == 85) {
            //                    selectedPart = 118;
            //                } else if (selectedMenuPart == 86) {
            //                    selectedPart = 119;
            //                } else if (selectedMenuPart == 87) {
            //                    selectedPart = 120;
            //                } else if (selectedMenuPart == 88) {
            //                    selectedPart = 121;
            //                } else if (selectedMenuPart == 89) {
            //                    selectedPart = 122;
            //                } else if (selectedMenuPart == 90) {
            //                    selectedPart = 123;
            //                } else if (selectedMenuPart == 91) {
            //                    selectedPart = 124;
            //                } else if (selectedMenuPart == 92) {
            //                    selectedPart = 125;
            //                } else if (selectedMenuPart == 93) {
            //                    selectedPart = 126;
            //                } else if (selectedMenuPart == 94) {
            //                    selectedPart = 127;
            //                } else if (selectedMenuPart == 95) {
            //                    selectedPart = 128;
            //                } else if (selectedMenuPart == 96) {
            //                    selectedPart = 129;
            //                } else if (selectedMenuPart == 97) {
            //                    selectedPart = 130;
            //                } else if (selectedMenuPart == 98) {
            //                    selectedPart = 131;
            //                } else if (selectedMenuPart == 99) {
            //                    selectedPart = 132;
            //                } else if (selectedMenuPart == 100) {
            //                    selectedPart = 133;
            //                } else if (selectedMenuPart > 100) {
            //                    selectedPart = selectedMenuPart + 33;
            //                    // ------------------ INCREMENT HERE FOR NEW PARTS
            //                    // -----------------------------NO NEED TO INCREMENT ANYMORE I FIXED IT
            //                }
            //            }
            if (selectedPart == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, selectedPart) || selectedPart == FIXHOOP_SET_ID || selectedPart == OFFROAD_CHECKPOINT_SET_ID || selectedPart == FLYING_CHECKPOINT_SET_ID) {
                if (rot == -90) {
                    rot = 90;
                }
                if (rot == 180) {
                    rot = 0;
                }
            }
            adrot = 0;
            if (selectedPart == 2) {
                adrot = -30;
            }
            if (selectedPart == 3) {
                adrot = 30;
            }
            if (selectedPart == 15) {
                adrot = 90;
            }
            if (selectedPart == 20) {
                adrot = 180;
            }
            if (selectedPart == 26) {
                adrot = 90;
            }
            rd.setColor(ColorConstants.c_200_200_200);
            rd.fillRect(248, 63, 514, 454);
            nfm.open.Medium.trk = 2;
            nfm.open.Medium.zy = 90;
            nfm.open.Medium.xz = 0;
            nfm.open.Medium.iw = 248;
            nfm.open.Medium.w = 762;
            nfm.open.Medium.ih = 63;
            nfm.open.Medium.h = 517;
            nfm.open.Medium.cx = 505;
            nfm.open.Medium.cy = 290;
            nfm.open.Medium.x = sx - nfm.open.Medium.cx;
            nfm.open.Medium.z = sz - nfm.open.Medium.cz;
            nfm.open.Medium.y = sy;
            int i = 0;
            final int[] is = new int[10000]; // stageselect limit
            for (int i2 = 0; i2 < nob; i2++) {
                if (co[i2].dist != 0) {
                    is[i] = i2;
                    i++;
                } else {
                    co[i2].d(rd);
                }
            }
            final int[] is3 = new int[i];
            for (int i4 = 0; i4 < i; i4++) {
                is3[i4] = 0;
            }
            for (int i5 = 0; i5 < i; i5++) {
                for (int i6 = i5 + 1; i6 < i; i6++) {
                    if (co[is[i5]].dist != co[is[i6]].dist) {
                        if (co[is[i5]].dist < co[is[i6]].dist) {
                            is3[i5]++;
                        } else {
                            is3[i6]++;
                        }
                    } else if (i6 > i5) {
                        is3[i5]++;
                    } else {
                        is3[i6]++;
                    }
                }
            }
            for (int i7 = 0; i7 < i; i7++) {
                for (int i8 = 0; i8 < i; i8++) {
                    if (is3[i8] == i7) {
                        if (is[i8] == hi) {
                            nfm.open.Medium.trk = 3;
                        }
                        if (is[i8] == chi && !co[is[i8]].errd) {
                            final int i9 = nfm.open.Medium.cx + (int) ((co[is[i8]].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.cos(nfm.open.Medium.xz) - (co[is[i8]].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.xz));
                            final int i10 = nfm.open.Medium.cz + (int) ((co[is[i8]].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.sin(nfm.open.Medium.xz) + (co[is[i8]].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.xz));
                            final int i11 = nfm.open.Medium.cy + (int) ((co[is[i8]].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.cos(nfm.open.Medium.zy) - (i10 - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.zy));
                            final int i12 = nfm.open.Medium.cz + (int) ((co[is[i8]].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.sin(nfm.open.Medium.zy) + (i10 - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.zy));
                            final int i13 = 1000000 / Math.abs(sy);
                            final Graphics2D graphics2d = rd;
                            graphics2d.setComposite(AlphaComposite.getInstance(3, 0.7F));
                            rd.setColor(ColorConstants.c_0_164_255);
                            rd.fillOval(Utility.xs(i9, i12) - i13 / 2, Utility.ys(i11, i12) - i13 / 2, i13, i13);
                            graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
                            rd.setColor(Color.black);
                            rd.setFont(FontConstants.arial_12);
                            ftm = rd.getFontMetrics();
                            rd.drawString("NO# " + (arrcnt + 1), Utility.xs(i9, i12) - ftm.stringWidth("NO# " + (arrcnt + 1)) / 2, Utility.ys(i11, i12) - i13 / 2);
                        }
                        // arrange checkpoints shit
                        if (arrng && (co[is[i8]].partID == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, co[is[i8]].partID) || co[is[i8]].partID == OFFROAD_CHECKPOINT_SET_ID || co[is[i8]].partID == FLYING_CHECKPOINT_SET_ID) && co[is[i8]].errd) {
                            final int i14 = nfm.open.Medium.cx + (int) ((co[is[i8]].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.cos(nfm.open.Medium.xz) - (co[is[i8]].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.xz));
                            final int i15 = nfm.open.Medium.cz + (int) ((co[is[i8]].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.sin(nfm.open.Medium.xz) + (co[is[i8]].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.xz));
                            final int i16 = nfm.open.Medium.cy + (int) ((co[is[i8]].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.cos(nfm.open.Medium.zy) - (i15 - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.zy));
                            final int i17 = nfm.open.Medium.cz + (int) ((co[is[i8]].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.sin(nfm.open.Medium.zy) + (i15 - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.zy));
                            final int i18 = 1000000 / Math.abs(sy);
                            final Graphics2D graphics2d = rd;
                            graphics2d.setComposite(AlphaComposite.getInstance(3, 0.5F));
                            rd.setColor(ColorConstants.c_255_128_0);
                            rd.fillOval(Utility.xs(i14, i17) - i18 / 2, Utility.ys(i16, i17) - i18 / 2, i18, i18);
                            graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
                            rd.setColor(Color.black);
                            rd.setFont(FontConstants.arial_12);
                            ftm = rd.getFontMetrics();
                            rd.drawString("NO# " + co[is[i8]].wh, Utility.xs(i14, i17) - ftm.stringWidth("NO# " + co[is[i8]].wh) / 2, Utility.ys(i16, i17) - i18 / 2);
                        }
                        co[is[i8]].d(rd);
                        if (nfm.open.Medium.trk == 3) {
                            nfm.open.Medium.trk = 2;
                        }
                    }
                }
            }
            drawPlayerPos();
            drawNodePath();
            if (xm > 248 && xm < 762 && ym > 63 && ym < 517) {
                if (!epart && !arrng) { // CALCULATES MOUSE POSITION AND PLACES SHIT
                    bco[selectedPart].x = (xm - 505) * (Math.abs(sy) / nfm.open.Medium.focusPoint) + sx;
                    bco[selectedPart].z = (290 - ym) * (Math.abs(sy) / nfm.open.Medium.focusPoint) + sz;
                    bco[selectedPart].y = nfm.open.Medium.ground - bco[selectedPart].grat;
                    bco[selectedPart].xz = rot + adrot;
                    int i19 = 200;
                    int i20 = 0;
                    int i21 = 0;
                    final int[] attachesX = {
                            bco[selectedPart].x + atp[selectedPart][0], bco[selectedPart].x + atp[selectedPart][2]
                    };
                    final int[] attachesZ = {
                            bco[selectedPart].z + atp[selectedPart][1], bco[selectedPart].z + atp[selectedPart][3]
                    };
                    rot(attachesX, attachesZ, bco[selectedPart].x, bco[selectedPart].z, rot, 2);
                    int i24 = 0;
                    //onfly = false;
                    int i25 = 500;
                    for (int i26 = 0; i26 < nob; i26++) {
                        final int[] attachesAgainstX = {
                                co[i26].x + atp[co[i26].partID][0], co[i26].x + atp[co[i26].partID][2]
                        };
                        final int[] attachesAgainstZ = {
                                co[i26].z + atp[co[i26].partID][1], co[i26].z + atp[co[i26].partID][3]
                        };
                        int i29 = co[i26].declaredXZ;
                        if (co[i26].partID == 2) {
                            i29 += 30;
                        }
                        if (co[i26].partID == 3) {
                            i29 -= 30;
                        }
                        if (co[i26].partID == 15) {
                            i29 -= 90;
                        }
                        if (co[i26].partID == 20) {
                            i29 -= 180;
                        }
                        if (co[i26].partID == 26) {
                            i29 -= 90;
                        }
                        rot(attachesAgainstX, attachesAgainstZ, co[i26].x, co[i26].z, i29, 2);
                        if (selectedPart <= maxpart) {
                            int i30 = py(attachesAgainstX[0], attachesX[0], attachesAgainstZ[0], attachesZ[0]);
                            if (i30 < i19 && i30 != 0) {
                                i19 = i30;
                                i20 = attachesAgainstX[0] - attachesX[0];
                                i21 = attachesAgainstZ[0] - attachesZ[0];
                            }
                            i30 = py(attachesAgainstX[1], attachesX[0], attachesAgainstZ[1], attachesZ[0]);
                            if (i30 < i19 && i30 != 0) {
                                i19 = i30;
                                i20 = attachesAgainstX[1] - attachesX[0];
                                i21 = attachesAgainstZ[1] - attachesZ[0];
                            }
                            i30 = py(attachesAgainstX[1], attachesX[1], attachesAgainstZ[1], attachesZ[1]);
                            if (i30 < i19 && i30 != 0) {
                                i19 = i30;
                                i20 = attachesAgainstX[1] - attachesX[1];
                                i21 = attachesAgainstZ[1] - attachesZ[1];
                            }
                            i30 = py(attachesAgainstX[0], attachesX[1], attachesAgainstZ[0], attachesZ[1]);
                            if (i30 < i19 && i30 != 0) {
                                i19 = i30;
                                i20 = attachesAgainstX[0] - attachesX[1];
                                i21 = attachesAgainstZ[0] - attachesZ[1];
                            }
                        }
                        if (selectedPartType == PART_CHECKPOINTS && py(attachesAgainstX[0], attachesX[0], attachesAgainstZ[0], attachesZ[0]) != 0 && py(attachesAgainstX[1], attachesX[0], attachesAgainstZ[1], attachesZ[0]) != 0) {
                            for (final int element : rcheckp) {
                                if (co[i26].partID == element) {
                                    if (py(attachesAgainstX[0], attachesX[0], attachesAgainstZ[0], attachesZ[0]) <= i24 || i24 == 0) {
                                        i24 = py(attachesAgainstX[0], attachesX[0], attachesAgainstZ[0], attachesZ[0]);
                                    }
                                    if (py(attachesAgainstX[1], attachesX[0], attachesAgainstZ[1], attachesZ[0]) <= i24) {
                                        i24 = py(attachesAgainstX[1], attachesX[0], attachesAgainstZ[1], attachesZ[0]);
                                    }
                                }
                            }
                            for (final int element : ocheckp) {
                                if (co[i26].partID == element) {
                                    if (py(attachesAgainstX[0], attachesX[0], attachesAgainstZ[0], attachesZ[0]) <= i24 || i24 == 0) {
                                        i24 = py(attachesAgainstX[0], attachesX[0], attachesAgainstZ[0], attachesZ[0]);
                                    }
                                    if (py(attachesAgainstX[1], attachesX[0], attachesAgainstZ[1], attachesZ[0]) <= i24) {
                                        i24 = py(attachesAgainstX[1], attachesX[0], attachesAgainstZ[1], attachesZ[0]);
                                    }
                                }
                            }
                        }
                        if (selectedPart > 12 && selectedPart < 33 || selectedPart == 35 || selectedPart == 36 || selectedPart >= 39 && selectedPart <= maxpart) {
                            if ((rot == 0 || rot == 180 || selectedPart == 26 || selectedPart == 15) && (i29 == 0 || i29 == 180 || selectedPart == 26 || selectedPart == 15)) {
                                if (Math.abs(attachesAgainstX[0] - attachesX[0]) < 200) {
                                    i20 = attachesAgainstX[0] - attachesX[0];
                                }
                                if (Math.abs(attachesAgainstX[0] - attachesX[1]) < 200) {
                                    i20 = attachesAgainstX[0] - attachesX[1];
                                }
                                if (Math.abs(attachesAgainstX[1] - attachesX[1]) < 200) {
                                    i20 = attachesAgainstX[1] - attachesX[1];
                                }
                                if (Math.abs(attachesAgainstX[1] - attachesX[0]) < 200) {
                                    i20 = attachesAgainstX[1] - attachesX[0];
                                }
                            }
                            if ((rot == 90 || rot == -90 || selectedPart == 26 || selectedPart == 15) && (i29 == 90 || i29 == -90 || selectedPart == 26 || selectedPart == 15)) {
                                if (Math.abs(attachesAgainstZ[0] - attachesZ[0]) < 200) {
                                    i21 = attachesAgainstZ[0] - attachesZ[0];
                                }
                                if (Math.abs(attachesAgainstZ[0] - attachesZ[1]) < 200) {
                                    i21 = attachesAgainstZ[0] - attachesZ[1];
                                }
                                if (Math.abs(attachesAgainstZ[1] - attachesZ[1]) < 200) {
                                    i21 = attachesAgainstZ[1] - attachesZ[1];
                                }
                                if (Math.abs(attachesAgainstZ[1] - attachesZ[0]) < 200) {
                                    i21 = attachesAgainstZ[1] - attachesZ[0];
                                }
                            }
                        }
                        if (selectedPartType == PART_CHECKPOINTS && co[i26].partID >= 46 && co[i26].partID <= 51) {
                            final int[] is33 = {
                                    2, 3, 5, 2, 3, 3
                            };
                            if ((Math.abs(co[i26].declaredXZ) == 180 || co[i26].declaredXZ == 0) && rot == 0 && Math.abs(bco[selectedPart].x - co[i26].x) < 500 && Math.abs(bco[selectedPart].z - co[i26].z) < 3000) {
                                for (int i34 = 0; i34 < is33[co[i26].partID - 46]; i34++) {
                                    for (int i35 = 0; i35 < co[i26].p[i34].n; i35++) {
                                        if (py(bco[selectedPart].x, co[i26].x, bco[selectedPart].z, co[i26].z + co[i26].p[i34].oz[i35]) < i25) {
                                            i25 = py(bco[selectedPart].x, co[i26].x, bco[selectedPart].z, co[i26].z + co[i26].p[i34].oz[i35]);
                                            flyh = co[i26].p[i34].oy[i35] - 28 + nfm.open.Medium.ground;
                                            i20 = co[i26].x - bco[selectedPart].x;
                                            i21 = co[i26].z + co[i26].p[i34].oz[i35] - bco[selectedPart].z;
                                            //onfly = true;
                                        }
                                    }
                                }
                            }
                            if (Math.abs(co[i26].declaredXZ) == 90 && rot == 90 && Math.abs(bco[selectedPart].z - co[i26].z) < 500 && Math.abs(bco[selectedPart].x - co[i26].x) < 3000) {
                                for (int i36 = 0; i36 < is33[co[i26].partID - 46]; i36++) {
                                    for (int i37 = 0; i37 < co[i26].p[i36].n; i37++) {
                                        if (py(bco[selectedPart].z, co[i26].z, bco[selectedPart].x, co[i26].x + co[i26].p[i36].ox[i37]) < i25) {
                                            i25 = py(bco[selectedPart].z, co[i26].z, bco[selectedPart].x, co[i26].x + co[i26].p[i36].ox[i37]);
                                            flyh = co[i26].p[i36].oy[i37] - 28 + nfm.open.Medium.ground;
                                            i21 = co[i26].z - bco[selectedPart].z;
                                            i20 = co[i26].x + co[i26].p[i36].ox[i37] - bco[selectedPart].x;
                                            //onfly = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    bco[selectedPart].x += i20;
                    bco[selectedPart].z += i21;
                    final int i38 = bco[selectedPart].xy;
                    final int i39 = bco[selectedPart].zy;
                    if (selectedPart == FIXHOOP_SET_ID) {
                        bco[selectedPart].y = -hf;
                        if (bco[selectedPart].y > -500) {
                            bco[selectedPart].y = -500;
                        }
                    } else {
                        bco[selectedPart].xy = 0;
                    }
                    if (selectedPart == FLYING_CHECKPOINT_SET_ID) {
                        bco[selectedPart].y = flyh;
                    }
                    bco[selectedPart].zy = 0;
                    if (!placeDelay) {
                        if (mouseon == -1) {
                            bco[selectedPart].d(rd);
                            if (!setcur) {
                                gameFrame.setCursor(new Cursor(13));
                                setcur = true;
                            }
                            if (mousePressed == -1) {

                                mousePressed = 0;

                                if (bco[selectedPart].xz == 270) {
                                    bco[selectedPart].xz = -90;
                                }
                                if (bco[selectedPart].xz == 360) {
                                    bco[selectedPart].xz = 0;
                                }
                                errd = 0;
                                boolean bool = false;
                                if (xnob < 10000) { //piece limit
                                    if (numUndoActions < MAX_UNDO_ACTIONS) {
                                        //undoContents[numUndoActions] = bstage;
                                        //numUndoActions++;

                                        undoContoID[numUndoActions] = bco[selectedPart].partID;
                                        undoContoX[numUndoActions] = bco[selectedPart].x;
                                        undoContoY[numUndoActions] = bco[selectedPart].y;
                                        undoContoZ[numUndoActions] = bco[selectedPart].z;
                                        undoIsRemove[numUndoActions] = false;
                                        numUndoActions++;
                                    }

                                    if (selectedPart != FIXHOOP_SET_ID && selectedPart != FLYING_CHECKPOINT_SET_ID && selectedPart != BUMP_SET_ID) {
                                        try {
                                            co[nob] = new SMContO(bco[selectedPart], bco[selectedPart].x, nfm.open.Medium.ground - bco[selectedPart].grat, bco[selectedPart].z, bco[selectedPart].xz);
                                            co[nob].declaredXZ = bco[selectedPart].xz;
                                            co[nob].partID = selectedPart;
                                            nob++;
                                        } catch (final Exception exception) {
                                            errd = 1;
                                        }
                                    }
                                    if (selectedPart == FIXHOOP_SET_ID) {
                                        if (nfm.open.CheckPoints.fn < 5) {
                                            co[nob] = new SMContO(bco[selectedPart], bco[selectedPart].x, bco[selectedPart].y, bco[selectedPart].z, bco[selectedPart].xz);
                                            co[nob].declaredXZ = bco[selectedPart].xz;
                                            co[nob].partID = selectedPart;
                                            nob++;
                                            fixh.setText("" + Math.abs(bco[selectedPart].y));
                                        } else {
                                            errd = 5;
                                        }
                                    }
                                    if (selectedPart == FLYING_CHECKPOINT_SET_ID) {
                                        try {
                                            co[nob] = new SMContO(bco[selectedPart], bco[selectedPart].x, bco[selectedPart].y, bco[selectedPart].z, bco[selectedPart].xz);
                                            co[nob].declaredXZ = bco[selectedPart].xz;
                                            co[nob].partID = selectedPart;
                                            nob++;
                                        } catch (final Exception exception) {
                                            errd = 1;
                                        }
                                    }
                                    if (selectedPart == BUMP_SET_ID) {
                                        co[nob] = new SMContO(bco[BUMP_SET_ID].srz, bco[BUMP_SET_ID].srx, bco[BUMP_SET_ID].sry, bco[BUMP_SET_ID].x, bco[BUMP_SET_ID].z, bco[selectedPart].y);
                                        co[nob].srz = bco[BUMP_SET_ID].srz;
                                        co[nob].srx = bco[BUMP_SET_ID].srx;
                                        co[nob].sry = bco[BUMP_SET_ID].sry;
                                        co[nob].partID = selectedPart;
                                        nob++;
                                    }
                                } else {
                                    errd = 4;
                                }
                                if (errd == 0) { ///fucking place part
                                    //sortstage();
                                    //readstage(0);
                                    bool = true;
                                    if (selectedPart == BUMP_SET_ID) {
                                        pgen = false;
                                        updateGroundPile();
                                    }
                                    /*if (selectedPart == 52 || selectedPart == 53 || selectedPart >= 55 && selectedPart <= 65) {
                                        seq = 3;
                                        bco[selectedPart].xy = 0;
                                        bco[selectedPart].zy = 0;
                                        boolean bool40 = false;
                                        if (rot == 0 && !bool40) {
                                            rot = 90;
                                            bool40 = true;
                                        }
                                        if (rot == 90 && !bool40) {
                                            rot = 180;
                                            bool40 = true;
                                        }
                                        if (rot == 180 && !bool40) {
                                            rot = -90;
                                            bool40 = true;
                                        }
                                        if (rot == -90 && !bool40) {
                                            rot = 0;
                                            bool40 = true;
                                        }
                                    }*/
                                }
                                if (errd != 0) {
                                    JOptionPane.showMessageDialog(null, "Error!  Unable to place part!\nReason:\n" + errlo[errd - 1] + "\n\n", "Stage Maker", 0);
                                    if (bool) {
                                        undo();
                                    }
                                }
                                lxm = bco[selectedPart].x;
                                //lym = bco[selectedPart].z;
                                placeDelay = true;
                            }
                        }
                    } else {
                        if (lxm != bco[selectedPart].x && lxm != bco[selectedPart].z) {
                            placeDelay = false;
                        }
                        if (setcur) {
                            gameFrame.setCursor(new Cursor(0));
                            setcur = false;
                        }
                    }
                    bco[selectedPart].xy = i38;
                    bco[selectedPart].zy = i39;
                } else {
                    if (epart) {
                        if (esp == -1 && !overcan) {
                            hi = -1;
                            getHighlightedPiece();
                            if (hi != -1) {
                                if (!setcur) {
                                    gameFrame.setCursor(new Cursor(13));
                                    setcur = true;
                                }
                                if (mousePressed == -1) {
                                    esp = hi;
                                    mousePressed = 0;
                                }
                            } else if (setcur) {
                                gameFrame.setCursor(new Cursor(0));
                                setcur = false;
                            }
                        } else if (setcur) {
                            gameFrame.setCursor(new Cursor(0));
                            setcur = false;
                        }
                    }
                    if (arrng) {
                        chi = -1;
                        int i47 = 5000;
                        for (int i48 = 0; i48 < nob; i48++) {
                            if ((co[i48].partID == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, co[i48].partID) || co[i48].partID == OFFROAD_CHECKPOINT_SET_ID || co[i48].partID == FLYING_CHECKPOINT_SET_ID) && !co[i48].errd) {
                                final int i49 = nfm.open.Medium.cx + (int) ((co[i48].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.cos(nfm.open.Medium.xz) - (co[i48].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.xz));
                                final int i50 = nfm.open.Medium.cz + (int) ((co[i48].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.sin(nfm.open.Medium.xz) + (co[i48].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.xz));
                                final int i51 = nfm.open.Medium.cy + (int) ((co[i48].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.cos(nfm.open.Medium.zy) - (i50 - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.zy));
                                final int i52 = nfm.open.Medium.cz + (int) ((co[i48].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.sin(nfm.open.Medium.zy) + (i50 - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.zy));
                                if (xm > Utility.xs(i49 - co[i48].maxR, i52) && xm < Utility.xs(i49 + co[i48].maxR, i52) && ym > Utility.ys(i51 - co[i48].maxR, i52) && ym < Utility.ys(i51 + co[i48].maxR, i52) && py(xm, Utility.xs(i49, i52), ym, Utility.ys(i51, i52)) <= i47) {
                                    chi = i48;
                                    i47 = py(xm, Utility.xs(i49, i52), ym, Utility.ys(i51, i52));
                                }
                            }
                        }
                        if (chi != -1) {
                            if (!setcur) {
                                gameFrame.setCursor(new Cursor(13));
                                setcur = true;
                            }
                            if (mousePressed == -1) {
                                arrcnt++;
                                co[chi].wh = arrcnt;
                                co[chi].errd = true;
                                mousePressed = 0;
                            }
                        } else if (setcur) {
                            gameFrame.setCursor(new Cursor(0));
                            setcur = false;
                        }
                    }
                }

            } else if (setcur) {
                gameFrame.setCursor(new Cursor(0));
                setcur = false;
            }
            drawpartids();
            drawSelection();

            if (epart && esp != -1) {
                if (co[esp].dist != 0) {
                    nfm.open.Medium.cx = 505;
                    nfm.open.Medium.cy = 290;
                    nfm.open.Medium.x = sx - nfm.open.Medium.cx;
                    nfm.open.Medium.z = sz - nfm.open.Medium.cz;
                    nfm.open.Medium.y = sy;
                    final int i53 = nfm.open.Medium.cx + (int) ((co[esp].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.cos(nfm.open.Medium.xz) - (co[esp].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.xz));
                    final int i54 = nfm.open.Medium.cz + (int) ((co[esp].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.sin(nfm.open.Medium.xz) + (co[esp].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.xz));
                    final int i55 = nfm.open.Medium.cy + (int) ((co[esp].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.cos(nfm.open.Medium.zy) - (i54 - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.zy));
                    final int i56 = nfm.open.Medium.cz + (int) ((co[esp].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.sin(nfm.open.Medium.zy) + (i54 - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.zy));
                    final int i57 = Utility.xs(i53, i56);
                    final int i58 = Utility.ys(i55, i56);
                    rd.setColor(Color.white);
                    rd.fillRect(i57, i58, 90, 88);
                    rd.setColor(ColorConstants.c_138_147_160);
                    rd.drawRect(i57, i58, 90, 88);
                    if (button("   Edit   ", i57 + 45, i58 + 22, 3, false)) {
                        copyesp(true);
                        removesp();
                        lxm = 0;
                        //lym = 0;
                        placeDelay = true;
                        epart = false;
                    }
                    if (button(" Remove ", i57 + 45, i58 + 49, 3, false)) {
                        removesp();
                        esp = -1;
                        mousePressed = 0;
                    }
                    if (button("  Copy  ", i57 + 45, i58 + 76, 3, false)) {
                        copyesp(false);
                        lxm = 0;
                        //lym = 0;
                        placeDelay = true;
                        epart = false;
                    }
                    rd.setColor(Color.red);
                    rd.drawString("x", i57 + 82, i58 - 2);
                    if (xm > 248 && xm < 762 && ym > 63 && ym < 517 && mousePressed == 1 && (xm < i57 || xm > i57 + 90 || ym < i58 || ym > i58 + 88)) {
                        esp = -1;
                        mousePressed = 0;
                    }
                } else {
                    esp = -1;
                }
            }
            rd.setColor(Color.white);
            rd.fillRect(248, 25, 514, 38);
            rd.fillRect(0, 25, 248, 530);
            rd.fillRect(248, 517, 514, 38);
            rd.fillRect(762, 25, 38, 530);
            if (isPartBumps) {
                rd.setColor(Color.black);
                rd.setFont(FontConstants.arial_12);
                rd.drawString("Radius:", 11, 97);
                rd.drawString("Height:", 14, 117);
                boolean bool = false;
                if (xm > 57 && xm < 204 && ym > 90 && ym < 99) {
                    bool = true;
                }
                rd.setColor(ColorConstants.c_136_148_170);
                if (bool || mouseon == 1) {
                    rd.drawRect(57, 90, 147, 8);
                    rd.setColor(Color.black);
                }
                rd.drawLine(57, 94, 204, 94);
                if (mouseon == 1) {
                    pwd = (xm - 57) / 36.75F + 2.0F;
                    if (pwd < 2.0F) {
                        pwd = 2.0F;
                    }
                    if (pwd > 6.0F) {
                        pwd = 6.0F;
                    }
                }
                rd.drawRect((int) (57.0F + (pwd - 2.0F) * 36.75F), 90, 2, 8);
                boolean bool59 = false;
                if (xm > 57 && xm < 204 && ym > 110 && ym < 119) {
                    bool59 = true;
                }
                rd.setColor(ColorConstants.c_136_148_170);
                if (bool59 || mouseon == 2) {
                    rd.drawRect(57, 110, 147, 8);
                    rd.setColor(Color.black);
                }
                rd.drawLine(57, 114, 204, 114);
                if (mouseon == 2) {
                    phd = (xm - 57) / 36.75F + 2.0F;
                    if (phd < 2.0F) {
                        phd = 2.0F;
                    }
                    if (phd > 6.0F) {
                        phd = 6.0F;
                    }
                }
                rd.drawRect((int) (57.0F + (phd - 2.0F) * 36.75F), 110, 2, 8);
                if (mousePressed == 1) {
                    if (bool) {
                        mouseon = 1;
                    }
                    if (bool59) {
                        mouseon = 2;
                    }
                } else {
                    if (mouseon == 1 || mouseon == 2) {
                        pgen = false;
                        updateGroundPile();
                    }
                    mouseon = -1;
                }
            }
            /**
             * up button / key on build screen
             */
            int i60 = 0;
            if (xm > 482 + 80 && xm < 529 + 80 && ym > 35 && ym < 61 || up) {
                i60 = 1;
                if (mousePressed == 1 || up) {
                    if (kSettings) {
                        uAccFloat = 1.0F;
                        if (sy > -30000) {
                            sz += 50 * speedShift;
                        } else if (sy > -50000) {
                            sz += 150 * speedShift;
                        } else {
                            sz += 250 * speedShift;
                        }
                    } else if (isHansen) {
                        sz += 500 * speedShift;
                    } else {
                        sz += 500;
                    }

                }
            }

            rd.drawImage(su[i60], 482 + 80, 35, null);
            /**
             * down button / key on build screen
             */
            i60 = 0;
            if (xm > 482 && xm < 529 && ym > 519 && ym < 545 || down) {
                i60 = 1;
                if (mousePressed == 1 || down) {
                    if (kSettings) {
                        dAccFloat = 1.0F;
                        if (sy > -30000) {
                            sz -= 50 * speedShift;
                        } else if (sy > -50000) {
                            sz -= 150 * speedShift;
                        } else {
                            sz -= 250 * speedShift;
                        }
                    } else if (isHansen) {
                        sz -= 500 * speedShift;
                    } else {
                        sz -= 500;
                    }

                }
            }

            rd.drawImage(sd[i60], 482, 519, null);
            /**
             * left button / key on builc screen
             */
            i60 = 0;
            if (xm > 220 && xm < 246 && ym > 264 && ym < 311 || left) {
                i60 = 1;
                if (mousePressed == 1 || left) {
                    if (kSettings) {
                        lAccFloat = 1.0F;
                        if (sy > -30000) {
                            sx -= 50 * speedShift;
                        } else if (sy > -50000) {
                            sx -= 150 * speedShift;
                        } else {
                            sx -= 250 * speedShift;
                        }
                    } else if (isHansen) {
                        sx -= 500 * speedShift;
                    } else {
                        sx -= 500;
                    }

                }
            }

            rd.drawImage(sl[i60], 220, 264, null);
            /**
             * right button / key on build screen
             */
            i60 = 0;
            if (xm > 764 && xm < 790 && ym > 264 && ym < 311 || right) {
                i60 = 1;
                if (mousePressed == 1 || right) {
                    if (kSettings) {
                        rAccFloat = 1.0F;
                        if (sy > -30000) {
                            sx += 50 * speedShift;
                        } else if (sy > -50000) {
                            sx += 150 * speedShift;
                        } else {
                            sx += 250 * speedShift;
                        }
                    } else if (isHansen) {
                        sx += 500 * speedShift;
                    } else {
                        sx += 500;
                    }

                }
            }

            rd.drawImage(sr[i60], 764, 264, null);
            i60 = 0;
            /**
             * zoom in button TODO: speedshift? I don't think it's needed..
             */
            if (xm > 616 && xm < 677 && ym > 30 && ym < 61 || zoomi) {
                i60 = 1;
                if (mousePressed == 1 || zoomi) {
                    if (kSettings) {
                        ziAccFloat = 1.0F;
                        sy += 450 * speedShift;
                    } else if (isHansen) {
                        sy += 500 * speedShift;
                    } else {
                        sy += 500;
                    }

                    if (sy > -2500) {
                        sy = -2500;
                    }
                }
            }

            /**
             * zoom out button TODO: speedshift? I don't think it's needed..
             */
            rd.drawImage(zi[i60], 616, 30, null);
            i60 = 0;
            if (xm > 690 && xm < 751 && ym > 30 && ym < 61 || zoomo) {
                i60 = 1;
                if (mousePressed == 1 || zoomo) {
                    if (kSettings) {
                        zoAccFloat = 1.0F;
                        sy -= 450 * speedShift;
                        if (sy < -61000) {
                            sy = -61000;
                        }
                    } else if (isHansen) {
                        sy -= 500 * speedShift;
                        if (sy < -80000) {
                            sy = -80000;
                        }
                    } else {
                        sy -= 500;
                        if (sy < -55000) {
                            sy = -55000;
                        }
                    }

                }
            }

            /**
             * acceleration ONLY ENABLED WHEN KAFF'S SETTINGS ARE ON
             */
            if (kSettings) {
                if (uAccFloat > 0.0F) {
                    sz += 200 * speedShift * uAccFloat;
                    uAccFloat -= 0.1F;
                }
                if (dAccFloat > 0.0F) {
                    sz -= 200 * speedShift * dAccFloat;
                    dAccFloat -= 0.1F;
                }
                if (lAccFloat > 0.0F) {
                    sx -= 200 * speedShift * lAccFloat;
                    lAccFloat -= 0.1F;
                }
                if (rAccFloat > 0.0F) {
                    sx += 200 * speedShift * rAccFloat;
                    rAccFloat -= 0.1F;
                }
                if (ziAccFloat > 0.0F) {
                    sy += 50 * speedShift * ziAccFloat;
                    ziAccFloat -= 0.1F;
                }
                if (zoAccFloat > 0.0F) {
                    sy -= 50 * speedShift * zoAccFloat;
                    zoAccFloat -= 0.1F;
                }
            }
            if (isHansen) {

                if (tiltLeftAccFloat > 0.0F) {
                    __m_xy += 10 * speedShift * tiltLeftAccFloat;
                    tiltLeftAccFloat -= 0.1F;
                }
                if (tiltRightAccFloat > 0.0F) {
                    __m_xy -= 10 * speedShift * tiltRightAccFloat;
                    tiltRightAccFloat -= 0.1F;
                }
            }

            rd.drawImage(zo[i60], 690, 30, null);
            if ((epart || arrng) && sy < -36000) {
                sy = -36000;
            }
            rd.setFont(FontConstants.arial_11);
            ftm = rd.getFontMetrics();
            rd.setColor(Color.black);
            rd.drawString("Part Selection", 11, 47);
            rd.setFont(FontConstants.arial_13);
            ftm = rd.getFontMetrics();
            ptyp.move(10, 50);
            if (!ptyp.isShowing()) {
                ptyp.setVisible(true);
                ptyp.select(selectedPartType);
            }
            if (selectedPartType != ptyp.getSelectedIndex()) {
                selectedPartType = ptyp.getSelectedIndex();
                loadPartMenu();
                /*
                if (selectedPartType == PART_ROADS) {
                    partroads();
                    part.setVisible(true);
                }
                if (selectedPartType == PART_RAMPS) {
                    partramps();
                    part.setVisible(true);
                }
                if (selectedPartType == PART_OBSTACLES) {
                    partobst();
                    part.setVisible(true);
                }
                if (selectedPartType == PART_TREES) {
                    partrees();
                    part.setVisible(true);
                }*/
                selectedMenuPart = 0;
                part.select(selectedMenuPart);
                updateSelectedPart();

                gameFrame.requestFocus();
                fixh.setText("2000");
                focuson = false;
            }
            part.move(10, 80);
            part.setSize(200, 21);
            if (!part.isShowing() && !isPartBumps && !isPartFixhoops) {
                part.setVisible(true);
                part.select(selectedMenuPart);
            }
            if (selectedMenuPart != part.getSelectedIndex()) {
                selectedMenuPart = part.getSelectedIndex();
                updateSelectedPart();
                focuson = false;
            }
            if (selectedPartType == PART_CHECKPOINTS) {
                rd.drawString("Checkpoint", 110 - ftm.stringWidth("Checkpoint") / 2, 120);
            }
            if (isPartFixhoops) {
                rd.drawString("Fixing Hoop", 110 - ftm.stringWidth("Fixing Hoop") / 2, 120);
            }
            if (lsp != selectedPart) {
                seq = 3;
                bco[selectedPart].xy = 0;
                bco[selectedPart].zy = 0;
                lsp = selectedPart;
                epart = false;
                arrng = false;
            }
            if (xm > 10 && xm < 210 && ym > 130 && ym < 334) {
                if (seq >= 3) {
                    if (seq == 20 || !seqn) {
                        seq = 0;
                        bco[selectedPart].xy = 0;
                        bco[selectedPart].zy = 0;
                    } else {
                        seq++;
                    }
                }
                seqn = true;
                rd.setColor(ColorConstants.c_210_210_210);
            } else {
                rd.setColor(ColorConstants.c_200_200_200);
                seqn = false;
            }
            rd.fillRect(10, 130, 200, 200);
            if ((selectedPart == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, selectedPart) || selectedPart == OFFROAD_CHECKPOINT_SET_ID || selectedPart == FLYING_CHECKPOINT_SET_ID) && button("  Rearrange Checkpoints  >  ", 110, 315, 2, true)) {
                mousePressed = 0;
                epart = false;
                if (!arrng) {
                    arrcnt = 0;
                    for (int i61 = 0; i61 < nob; i61++) {
                        if (co[i61].partID == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, co[i61].partID) || co[i61].partID == OFFROAD_CHECKPOINT_SET_ID || co[i61].partID == FLYING_CHECKPOINT_SET_ID) {
                            co[i61].errd = false;
                        }
                    }
                    arrng = true;
                } else {
                    arrng = false;
                }
            }
            if (seqn && mousePressed == -1) {
                if (selectedPart != BUMP_SET_ID) {
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
                    }
                    if (selectedPart == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, selectedPart) || selectedPart == FIXHOOP_SET_ID || selectedPart == OFFROAD_CHECKPOINT_SET_ID) {
                        if (rot == -90) {
                            rot = 90;
                        }
                        if (rot == 180) {
                            rot = 0;
                        }
                    }
                    seq = 5;
                    bco[selectedPart].xy = 0;
                    bco[selectedPart].zy = 0;
                    epart = false;
                    arrng = false;
                } else {
                    pgen = false;
                    pwd = 2L + Math.round(ThreadLocalRandom.current().nextDouble() * 4.0);
                    phd = 2L + Math.round(ThreadLocalRandom.current().nextDouble() * 4.0);
                    updateGroundPile();
                }
            }
            if (selectedPart == FIXHOOP_SET_ID) {
                rd.setFont(FontConstants.arial_12);
                rd.setColor(Color.black);
                rd.drawString("Height:", 62, 280);
                movefield(fixh, 107, 266, 50, 20);
                if (fixh.hasFocus()) {
                    focuson = false;
                }
                if (!fixh.isShowing()) {
                    fixh.setVisible(true);
                }
                rd.setFont(new Font("Arial", 0, 11));
                ftm = rd.getFontMetrics();
                rd.drawString("(Height off the ground... )", 110 - ftm.stringWidth("(Height off the ground... )") / 2, 300);
                if (fixh.getText().equals("")) {
                    fixh.setText("0");
                    fixh.select(0, 0);
                }
                try {
                    hf = Integer.parseInt(fixh.getText());
                    if (hf > 8000) {
                        hf = 8000;
                        fixh.setText("8000");
                    }
                } catch (final Exception exception) {
                    hf = 2000;
                    fixh.setText("2000");
                }
            } else if (fixh.isShowing()) {
                fixh.setVisible(false);
            }
            // CAMERA POSITION FOR THE CONTO PREVIEW SHIT
            nfm.open.Medium.trk = 2;
            nfm.open.Medium.zy = 90;
            nfm.open.Medium.xz = 0;
            nfm.open.Medium.iw = 10;
            nfm.open.Medium.w = 210;
            nfm.open.Medium.ih = 130;
            nfm.open.Medium.h = 330;
            nfm.open.Medium.cx = 110;
            nfm.open.Medium.cy = 230;
            nfm.open.Medium.x = -110;
            nfm.open.Medium.z = -230;
            nfm.open.Medium.y = -15000;
            if (selectedPartType == PART_RAMPS && selectedPart != 20 && selectedPart != 21 && selectedPart != 43 && selectedPart != 45) {
                nfm.open.Medium.y = -10000;
            }
            if (selectedPartType == PART_OBSTACLES && selectedPart != 41) {
                nfm.open.Medium.y = -7600;
            }
            if (selectedPartType == PART_CHECKPOINTS || isPartFixhoops) {
                nfm.open.Medium.y = -5000;
            }
            if (selectedPartType >= PART_TREES) {
                //Medium.y = -15000;
                nfm.open.Medium.z = 150;
            }
            if (isPartBumps) {
                nfm.open.Medium.y = -7600;
            }
            if (selectedPart == FIXHOOP_SET_ID) {
                nfm.open.Medium.z = -500;
                bco[selectedPart].roted = rot != 0;
            }
            bco[selectedPart].x = 0;
            bco[selectedPart].y = 0;
            bco[selectedPart].z = 0;
            bco[selectedPart].xz = rot + adrot;
            bco[selectedPart].d(rd);
            int i62 = 1;
            if (selectedPartType == PART_ROADS || selectedPartType == PART_RAMPS) {
                if (selectedPart != 26 && selectedPart != 20) {
                    if (rot == -90 || rot == 0) {
                        i62 = -1;
                    }
                } else {
                    if (selectedPart == 26 && (rot == -90 || rot == 180)) {
                        i62 = -1;
                    }
                    if (selectedPart == 20 && (rot == 90 || rot == 180)) {
                        i62 = -1;
                    }
                }
                if (seq == 2) {
                    bco[selectedPart].xy -= 5 * i62;
                    if (bco[selectedPart].xy == 0) {
                        seq = 3;
                    }
                }
                if (seq == 1) {
                    seq = 2;
                }
                if (seq == 0) {
                    bco[selectedPart].xy += 5 * i62;
                    if (bco[selectedPart].xy == 85 * i62) {
                        seq = 1;
                    }
                }
            }
            if (selectedPartType == PART_OBSTACLES || selectedPartType == PART_CHECKPOINTS || isPartFixhoops || isPartBumps) {
                if (rot == -90 || rot == 180) {
                    i62 = -1;
                }
                if (seq == 2) {
                    bco[selectedPart].zy += 5 * i62;
                    if (bco[selectedPart].zy == 0) {
                        seq = 3;
                    }
                }
                if (seq == 1) {
                    seq = 2;
                }
                if (seq == 0) {
                    bco[selectedPart].zy -= 5 * i62;
                    if (bco[selectedPart].zy == -(85 * i62)) {
                        seq = 1;
                    }
                }
            }
            if (selectedPartType >= PART_TREES) {
                if (rot == -90 || rot == 180) {
                    i62 = -1;
                }
                boolean bool = false;
                if (rot == -90 || rot == 90) {
                    bool = true;
                }
                if (!bool) {
                    bco[selectedPart].xy = 0;
                } else {
                    bco[selectedPart].zy = 0;
                }
                if (seq == 2) {
                    if (!bool) {
                        bco[selectedPart].zy += 5 * i62;
                        if (bco[selectedPart].zy == 0) {
                            seq = 3;
                        }
                    } else {
                        bco[selectedPart].xy -= 5 * i62;
                        if (bco[selectedPart].xy == 0) {
                            seq = 3;
                        }
                    }
                }
                if (seq == 1) {
                    seq = 2;
                }
                if (seq == 0) {
                    if (!bool) {
                        bco[selectedPart].zy -= 5 * i62;
                        if (bco[selectedPart].zy == -(85 * i62)) {
                            seq = 1;
                        }
                    } else {
                        bco[selectedPart].xy += 5 * i62;
                        if (bco[selectedPart].xy == 85 * i62) {
                            seq = 1;
                        }
                    }
                }
            }
            if (selectedPart != BUMP_SET_ID) {
                if (button("  Rotate  ", 110, 348, 3, true)) {
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
                    }
                    if (selectedPart == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, selectedPart) || selectedPart == FIXHOOP_SET_ID || selectedPart == OFFROAD_CHECKPOINT_SET_ID) {
                        if (rot == -90) {
                            rot = 90;
                        }
                        if (rot == 180) {
                            rot = 0;
                        }
                    }
                    seq = 3;
                    bco[selectedPart].xy = 0;
                    bco[selectedPart].zy = 0;
                    epart = false;
                    arrng = false;
                }
                if (button(">", 191, 348, 3, true)) {
                    selectedMenuPart++;
                    if (selectedMenuPart == part.getItemCount()) {
                        selectedMenuPart = 0;
                    }
                    part.select(selectedMenuPart);
                    updateSelectedPart();
                    epart = false;
                    arrng = false;
                }
                if (button("<", 28, 348, 3, true)) {
                    selectedMenuPart--;
                    if (selectedMenuPart == -1) {
                        selectedMenuPart = part.getItemCount() - 1;
                    }
                    part.select(selectedMenuPart);
                    updateSelectedPart();
                    epart = false;
                    arrng = false;
                }
            } else if (button("  Generate New  ", 110, 348, 3, true)) {
                pgen = false;
                pwd = 2L + Math.round(ThreadLocalRandom.current().nextDouble() * 4.0);
                phd = 2L + Math.round(ThreadLocalRandom.current().nextDouble() * 4.0);
                updateGroundPile();
            }
            if (button("   <  Undo   ", 204, 404, 0, true)) {
                epart = false;
                arrng = false;
                undo();
            }
            searchButton();
            if (button("   Remove / Edit  Part   ", 172, 454, 0, true)) {
                epart = !epart;
                arrng = false;
                esp = -1;
            }
            if (button("   Go to >  Startline   ", 175, 504, 0, true)) {
                sx = 0;
                sz = 1500;
            }
            /*if (button(" About Part ", 164, 66, 3, false)) {
                JOptionPane.showMessageDialog(null, "Well, blimey, it appears that nobody cares about these, so I removed 'em. Sorry.", "Stage Maker", 1);
            }*/
            if (button("  Keyboard Controls  ", 691, 536, 3, false)) {
                JOptionPane.showMessageDialog(null, "Instead of clicking the triangular buttons around the Building Area to scroll, you can use:\n[ Keyboard Arrows ]\n\nYou can also zoom in and out using the following keys:\n[+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]\n\n", "Stage Maker", 1);
            }
            if (button("  Save  ", 280, 50, 0, false)) {
                if (nob != 0) {
                    sortstage();
                }
                readstage(0);

                epart = false;
                arrng = false;
                savefile();
            }
            if (button("  Save & Preview  ", 380, 50, 0, false)) {
                if (nob != 0) {
                    sortstage();
                }
                readstage(0);

                epart = false;
                arrng = false;
                savefile();
                hidefields();
                tab = 2;
            }
            if (button("  Sort Stage  ", 495, 50, 0, false)) {
                if (nob != 0) {
                    sortstage();
                    readstage(0);
                } else {
                    JOptionPane.showMessageDialog(gameFrame, "Not enough data to sort! Please place at least one piece first.");
                }
            }
            rd.setFont(FontConstants.arial_12);
            ftm = rd.getFontMetrics();
            rd.setColor(Color.black);
            int i63 = 0;
            final int i64 = (int) (xnob / 10000.0F * 200.0F); // limits
            int i65 = i64;
            final int i66 = (int) (nfm.open.Trackers.nt / 670000.0F * 200.0F); // limits
            if (i66 > i65) {
                i65 = i66;
                i63 = 1;
            }
            final int i67 = (int) (nfm.open.CheckPoints.n / 10000.0F * 200.0F); // limits
            if (i67 > i65) {
                i65 = i67;
                i63 = 2;
            }
            final int i68 = (int) (nfm.open.Medium.nrw * nfm.open.Medium.ncl / 9999999.0F * 200.0F); // medium
            // limit...does
            // it
            // exist?
            if (i68 > i65) {
                i65 = i68;
                i63 = 3;
            }
            if (i65 > 200) {
                i65 = 200;
            }
            if (i65 <= 100) {
                rd.setColor(new Color(100 + i65, 225, 30));
            } else {
                rd.setColor(new Color(200, 325 - i65, 30));
            }
            rd.fillRect(167, 531, i65, 9);
            if (button("Memory Consumption :", 85, 540, 3, false)) {
                JOptionPane.showMessageDialog(null, "Memory Consumption Details\n\nNumber of Parts:  " + i64 / 2 + " %\nPart's Details:  " + i66 / 2 + " %\nRoad Points:  " + i67 / 2 + " %\nStage Area:  " + i68 / 2 + " %\n \n", "Stage Maker", 1);
            }
            rd.setColor(Color.black);
            rd.drawRect(167, 531, 200, 9);
            final String[] strings = {
                    "Number of Parts", "Part's Details", "Road Points", "Stage Area"
            };
            rd.drawString(strings[i63], 267 - ftm.stringWidth(strings[i63]) / 2, 540);
            rd.drawString(i65 / 2 + " %  used", 375, 540);
            if (overcan) {
                overcan = false;
            }
            if (epart) {
                if (esp == -1) {
                    rd.setColor(Color.black);
                    rd.drawString("Click on any part to Edit >", 257, 454);
                    if (button(" Cancel ", 323, 474, 4, false)) {
                        epart = false;
                    }
                }
            } else {
                if (hi != -1) {
                    hi = -1;
                }
                if (esp != -1) {
                    esp = -1;
                }
            }
            if (arrng) {
                rd.setColor(Color.black);
                rd.drawString("Click on Checkpoint NO# " + (arrcnt + 1) + "  >", 257, 80);
                if (button(" Cancel ", 330, 100, 4, false)) {
                    arrng = false;
                }
                if (arrcnt == nfm.open.CheckPoints.nsp) {
                    mousePressed = 0;
                    sortstage();
                    try {
                        new Thread() {
                            @Override
                            public void run() {
                                JOptionPane.showMessageDialog(null, "Checkpoints Arranged!\nPress Save and Test Drive to check the new checkpoint order.\n");
                            }
                        }.start();
                    } catch (final Exception ignored) {

                    }
                    arrng = false;
                }
            } else if (chi != -1) {
                chi = -1;
            }
        }
        inPreview = tab == 2;
        if (tab == 2) {
            asin_m_xz = nfm.open.Medium.sin(nfm.open.Medium.xz);
            acos_m_xz = nfm.open.Medium.cos(nfm.open.Medium.xz);
            asin_m_zy = nfm.open.Medium.sin(nfm.open.Medium.zy);
            acos_m_zy = nfm.open.Medium.cos(nfm.open.Medium.zy);
            asin_m_xy = nfm.open.Medium.sin(__m_xy);
            acos_m_xy = nfm.open.Medium.cos(__m_xy);
            if (tabed != tab) {
                nfm.open.Medium.trk = 0;
                readstage(1);
                gameFrame.setCursor(new Cursor(0));
                setcur = false;
                vxz = 0;
                vx = sx - 400;
                vz = sz - nfm.open.Medium.cz - 8000;
                vy = -1500;
                dtabed = -1;
            }

            if (isHansen && goAround) {
                fakeAroundTrack();
            }
            nfm.open.Medium.trk = 0;
            nfm.open.Medium.zy = fakezy;
            nfm.open.Medium.iw = 10;
            nfm.open.Medium.w = 790;
            nfm.open.Medium.ih = 35;
            nfm.open.Medium.h = 445;
            nfm.open.Medium.cx = 400;
            nfm.open.Medium.cy = 215;
            nfm.open.Medium.xz = vxz;
            nfm.open.Medium.x = vx;
            nfm.open.Medium.z = vz;
            nfm.open.Medium.y = vy;
            nfm.open.Medium.d(rd);
            int i = 0;
            final int[] is = new int[10000]; // stageselect limit
            for (int i69 = 0; i69 < nob; i69++) {
                if (co[i69].dist != 0) {
                    is[i] = i69;
                    i++;
                } else {
                    co[i69].d(rd);
                }
            }
            final int[] is70 = new int[i];
            for (int i71 = 0; i71 < i; i71++) {
                is70[i71] = 0;
            }
            for (int i72 = 0; i72 < i; i72++) {
                for (int i73 = i72 + 1; i73 < i; i73++) {
                    if (co[is[i72]].dist != co[is[i73]].dist) {
                        if (co[is[i72]].dist < co[is[i73]].dist) {
                            is70[i72]++;
                        } else {
                            is70[i73]++;
                        }
                    } else if (i73 > i72) {
                        is70[i72]++;
                    } else {
                        is70[i73]++;
                    }
                }
            }
            for (int i74 = 0; i74 < i; i74++) {
                for (int i75 = 0; i75 < i; i75++) {
                    if (is70[i75] == i74) {
                        if (is[i75] == hi) {
                            nfm.open.Medium.trk = 3;
                        }
                        co[is[i75]].d(rd);
                        if (nfm.open.Medium.trk == 3) {
                            nfm.open.Medium.trk = 2;
                        }
                    }
                }
            }
            drawPlayerPos();
            drawpartids();
            /**
             * Ok so what this is is a redefinition of the keys for the preview screen
             */
            if (zoomi) {
                vy += 50;
                if (vy > -500) {
                    vy = -500;
                }
            }
            if (zoomo) {
                vy -= 50;
                if (vy < -5000) {
                    vy = -5000;
                }
            }

            if (tiltLeft) {
                if (tiltSnap) {
                    tiltLeftAccFloat = 0.0F;
                    __m_xy += 45;
                    tiltLeft = false;
                    if (__m_xy % 45 != 0) { //snaps to angle if smoothed
                        __m_xy = 0;
                    }
                } else {
                    tiltLeftAccFloat = 1.0F;
                    __m_xy += 1;
                }
            }
            if (tiltRight) {
                if (tiltSnap) {
                    tiltRightAccFloat = 0.0F;
                    __m_xy -= 45;
                    tiltRight = false;
                    if (__m_xy % 45 != 0) { //snaps to angle if smoothed
                        __m_xy = 0;
                    }
                } else {
                    tiltRightAccFloat = 1.0F;
                    __m_xy -= 1;
                }
            }

            if (up) {
                if (kSettings) {
                    uAccFloat = 1.0F;
                    vz += 50.0F * nfm.open.Medium.cos(nfm.open.Medium.xz);
                    vx += 50.0F * nfm.open.Medium.sin(nfm.open.Medium.xz);
                } else {
                    vz += 250.0F * nfm.open.Medium.cos(nfm.open.Medium.xz);
                    vx += 250.0F * nfm.open.Medium.sin(nfm.open.Medium.xz);
                }
            }
            if (down) {
                if (kSettings) {
                    dAccFloat = 1.0F;
                    vz -= 50.0F * nfm.open.Medium.cos(nfm.open.Medium.xz);
                    vx -= 50.0F * nfm.open.Medium.sin(nfm.open.Medium.xz);
                } else {
                    vz -= 250.0F * nfm.open.Medium.cos(nfm.open.Medium.xz);
                    vx -= 250.0F * nfm.open.Medium.sin(nfm.open.Medium.xz);
                }
            }
            if (left) {
                if (kSettings) {
                    lAccFloat = 1.0F;
                }
                vxz -= 5;
            }
            if (right) {
                if (kSettings) {
                    rAccFloat = 1.0F;
                }
                vxz += 5;
            }
            if (zoomi) {
                vy += 20;
                if (vy > -500) {
                    vy = -500;
                }
            }
            if (zoomo) {
                vy -= 20;
                if (vy < -5000) {
                    vy = -5000;
                }
            }

            /**
             * acceleration ONLY ENABLED WHEN KAFF'S SETTINGS ARE ON
             */
            if (kSettings) {
                if (uAccFloat > 0.0F) {
                    vz += 200.0F * nfm.open.Medium.cos(nfm.open.Medium.xz) * speedShift * uAccFloat;
                    vx += 200.0F * nfm.open.Medium.sin(nfm.open.Medium.xz) * speedShift * uAccFloat;
                    uAccFloat -= 0.1F;
                }
                if (dAccFloat > 0.0F) {
                    vz -= 200.0F * nfm.open.Medium.cos(nfm.open.Medium.xz) * speedShift * dAccFloat;
                    vx -= 200.0F * nfm.open.Medium.sin(nfm.open.Medium.xz) * speedShift * dAccFloat;
                    dAccFloat -= 0.1F;
                }
                if (lAccFloat > 0.0F) {
                    vxz -= 1 * speedShift * lAccFloat;
                    lAccFloat -= 0.1F;
                }
                if (rAccFloat > 0.0F) {
                    vxz += 1 * speedShift * rAccFloat;
                    rAccFloat -= 0.1F;
                }
                if (ziAccFloat > 0.0F) {
                    vy += 20 * speedShift * ziAccFloat;
                    ziAccFloat -= 0.1F;
                }
                if (zoAccFloat > 0.0F) {
                    vy -= 20 * speedShift * zoAccFloat;
                    zoAccFloat -= 0.1F;
                }
            }
            if (isHansen) {

                if (tiltLeftAccFloat > 0.0F) {
                    __m_xy += 10 * speedShift * tiltLeftAccFloat;
                    tiltLeftAccFloat -= 0.1F;
                }
                if (tiltRightAccFloat > 0.0F) {
                    __m_xy -= 10 * speedShift * tiltRightAccFloat;
                    tiltRightAccFloat -= 0.1F;
                }
            }
            rd.setColor(Color.white);
            rd.fillRect(0, 25, 10, 525);
            rd.fillRect(790, 25, 10, 525);
            rd.fillRect(10, 25, 780, 10);
            rd.fillRect(10, 445, 780, 105);
            rd.setFont(FontConstants.arial_12);
            ftm = rd.getFontMetrics();
            final String[] tabNames = {
                    "Controls", "Atmosphere", "Colors", "Scenery", "Laps", "Sound Track", "Test Drive"
            };
            final int[] tabXZone = {
                    10, 10, 121, 111
            };
            final int[] tabYZone = {
                    425, 445, 445, 425
            };
            for (int _tab = 0; _tab < 7; _tab++) {
                rd.setColor(ColorConstants.c_170_170_170);
                if (xm > tabXZone[0] && xm < tabXZone[3] && ym > 425 && ym < 445) {
                    rd.setColor(ColorConstants.c_190_190_190);
                }
                if (dtab == _tab) {
                    rd.setColor(Color.white);
                }
                rd.fillPolygon(tabXZone, tabYZone, 4);
                rd.setColor(Color.black);
                rd.drawString(tabNames[_tab], _tab * 111 + 62 - ftm.stringWidth(tabNames[_tab]) / 2, 439);
                if (xm > tabXZone[0] && xm < tabXZone[3] && ym > 425 && ym < 445 && mousePressed == -1 && mouseon == -1) {
                    dtab = _tab;
                }
                for (int j = 0; j < 4; j++) {
                    tabXZone[j] += 111;
                }
            }
            if (tabed == tab && dtab != dtabed) {
                if (!ttstage.equals("")) {
                    tstage = ttstage;
                    ttstage = "";
                }
                readstage(1);
                hidefields();
            }
            if (dtab == 0) {
                rd.setColor(Color.black);
                rd.drawString("Use the [ Keyboard Arrows ] to navigate through the stage.", 20, 470);
                rd.drawString("[Left] & [Right] arrows are for rotating.  [Up] & [Down] arrows are for moving forwards and backwards.", 20, 490);
                rd.drawString("For moving vertically down and up use the following keys:  [+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]", 20, 520);
            }
            if (dtab == 2) {
                if (dtabed != dtab) {
                    Color.RGBtoHSB(csky[0], csky[1], csky[2], hsb[0]);
                    Color.RGBtoHSB(cfade[0], cfade[1], cfade[2], hsb[1]);
                    Color.RGBtoHSB(cgrnd[0], cgrnd[1], cgrnd[2], hsb[2]);
                    for (int i80 = 0; i80 < 3; i80++) {
                        final float f = hsb[i80][1];
                        hsb[i80][1] = hsb[i80][2];
                        hsb[i80][2] = f;
                    }
                    if (fEquals(hsb[1][1], (hsb[0][1] + hsb[2][1]) / 2.0F) && fEquals(hsb[1][0], hsb[2][0]) && fEquals(hsb[1][2], hsb[2][2])) {
                        pfog.setState(true);
                    } else {
                        pfog.setState(false);
                    }
                    ttstage = "";
                    mouseon = -1;
                }
                if (mousePressed != 1) {
                    if ((mouseon >= 6 || mouseon < 3) && mouseon != -1) {
                        if (ttstage.equals("")) {
                            ttstage = tstage;
                        }
                        sortop();
                        readstage(1);
                    }
                    mouseon = -1;
                }
                final String[] strings81 = {
                        "Sky", "Dust / Fog", "Ground"
                };
                for (int i82 = 0; i82 < 3; i82++) {
                    rd.setColor(Color.black);
                    rd.drawString(strings81[i82], 107 + 195 * i82 - ftm.stringWidth(strings81[i82]) / 2, 461);
                    for (int i83 = 0; i83 < 150; i83++) {
                        rd.setColor(Color.getHSBColor((float) (i83 * 0.006667), 1.0F, 1.0F));
                        rd.drawLine(32 + i83 + 195 * i82, 467, 32 + i83 + 195 * i82, 474);
                    }
                    for (int i84 = 0; i84 < 150; i84++) {
                        rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.5F + i84 * 0.00333F));
                        rd.drawLine(32 + i84 + 195 * i82, 483, 32 + i84 + 195 * i82, 490);
                    }
                    for (int i85 = 0; i85 < 150; i85++) {
                        rd.setColor(Color.getHSBColor(hsb[i82][0], 0.0F + (float) (i85 * 0.001667), hsb[i82][1]));
                        rd.drawLine(32 + i85 + 195 * i82, 499, 32 + i85 + 195 * i82, 506);
                    }
                    for (int i86 = 0; i86 < 3; i86++) {
                        rd.setColor(Color.black);
                        float f = hsb[i82][i86] * 150.0F;
                        if (i86 == 1) {
                            float f87 = 0.75F;
                            if (i82 == 0) {
                                f87 = 0.85F;
                            }
                            if (i82 == 1) {
                                f87 = 0.8F;
                            }
                            f = (hsb[i82][i86] - f87) / 0.001F;
                        }
                        if (i86 == 2) {
                            f = hsb[i82][i86] * 600.0F;
                        }
                        if (f < 0.0F) {
                            f = 0.0F;
                        }
                        if (f > 150.0F) {
                            f = 150.0F;
                        }
                        rd.drawLine((int) (32 + 195 * i82 + f), 467 + i86 * 16, (int) (32 + 195 * i82 + f), 474 + i86 * 16);
                        rd.drawLine((int) (33 + 195 * i82 + f), 467 + i86 * 16, (int) (33 + 195 * i82 + f), 474 + i86 * 16);
                        rd.fillRect((int) (31 + 195 * i82 + f), 475 + i86 * 16, 4, 2);
                        rd.drawLine((int) (30 + 195 * i82 + f), 477 + i86 * 16, (int) (35 + 195 * i82 + f), 477 + i86 * 16);
                        if (xm > 29 + 195 * i82 && xm < 185 + 195 * i82 && ym > 468 + i86 * 16 && ym < 477 + i86 * 16 && mousePressed == 1 && mouseon == -1) {
                            mouseon = i86 + i82 * 3;
                        }
                        if (mouseon == i86 + i82 * 3) {
                            if (i86 == 0) {
                                hsb[i82][i86] = (xm - (32 + 195 * i82)) / 150.0F;
                            }
                            if (i86 == 1) {
                                float f88 = 0.75F;
                                if (i82 == 0) {
                                    f88 = 0.85F;
                                }
                                if (i82 == 1) {
                                    f88 = 0.8F;
                                }
                                hsb[i82][i86] = f88 + (xm - (32 + 195 * i82)) * 0.001F;
                                if (hsb[i82][i86] < f88) {
                                    hsb[i82][i86] = f88;
                                }
                                if (hsb[i82][i86] > f88 + 0.15F) {
                                    hsb[i82][i86] = f88 + 0.15F;
                                }
                            }
                            if (i86 == 2) {
                                hsb[i82][i86] = (xm - (32 + 195 * i82)) / 600.0F;
                                if (hsb[i82][i86] > 0.25) {
                                    hsb[i82][i86] = 0.25F;
                                }
                            }
                            if (hsb[i82][i86] > 1.0F) {
                                hsb[i82][i86] = 1.0F;
                            }
                            if (hsb[i82][i86] < 0.0F) {
                                hsb[i82][i86] = 0.0F;
                            }
                        }
                    }
                }
                movefield(pfog, 258, 511, 200, 23);
                if (!pfog.isShowing()) {
                    pfog.setVisible(true);
                }
                if (pfog.getState()) {
                    rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                    rd.setColor(Color.black);
                    rd.fillRect(215, 464, 175, 47);
                    rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    hsb[1][1] = (hsb[0][1] + hsb[2][1]) / 2.0F;
                    hsb[1][0] = hsb[2][0];
                    hsb[1][2] = hsb[2][2];
                }
                Color color = Color.getHSBColor(hsb[0][0], hsb[0][2], hsb[0][1]);
                nfm.open.Medium.setsky(color.getRed(), color.getGreen(), color.getBlue());
                csky[0] = color.getRed();
                csky[1] = color.getGreen();
                csky[2] = color.getBlue();
                color = Color.getHSBColor(hsb[1][0], hsb[1][2], hsb[1][1]);
                nfm.open.Medium.setfade(color.getRed(), color.getGreen(), color.getBlue());
                cfade[0] = color.getRed();
                cfade[1] = color.getGreen();
                cfade[2] = color.getBlue();
                color = Color.getHSBColor(hsb[2][0], hsb[2][2], hsb[2][1]);
                nfm.open.Medium.setgrnd(color.getRed(), color.getGreen(), color.getBlue());
                cgrnd[0] = color.getRed();
                cgrnd[1] = color.getGreen();
                cgrnd[2] = color.getBlue();
                if (button(" Reset ", 650, 510, 0, true)) {
                    if (!ttstage.equals("")) {
                        tstage = ttstage;
                        ttstage = "";
                    }
                    readstage(1);
                    dtabed = -2;
                }
                if (button("        Save        ", 737, 510, 0, true)) {
                    sortop();
                    ttstage = "";
                    savefile();
                }
            }
            if (dtab == 3) {
                if (dtabed != dtab) {
                    Color.RGBtoHSB(cldd[0], cldd[1], cldd[2], hsb[0]);
                    Color.RGBtoHSB(texture[0], texture[1], texture[2], hsb[1]);
                    mgen.setText("" + nfm.open.Medium.mgen);
                    mouseon = -1;
                    ttstage = "";
                }
                if (mousePressed != 1) {
                    if (mouseon == 0 || mouseon == 1 || mouseon == 2 || mouseon == 6) {
                        if (ttstage.equals("")) {
                            ttstage = tstage;
                        }
                        sortop();
                        readstage(1);
                    }
                    mouseon = -1;
                }
                rd.setFont(FontConstants.arial_12);
                ftm = rd.getFontMetrics();
                rd.setColor(Color.black);
                rd.drawString("Clouds", 32, 461);
                for (int i89 = 0; i89 < 150; i89++) {
                    rd.setColor(Color.getHSBColor(i89 * 0.006667F, 1.0F, 1.0F));
                    rd.drawLine(32 + i89, 467, 32 + i89, 474);
                }
                for (int i90 = 0; i90 < 150; i90++) {
                    rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.75F + i90 * 0.001667F));
                    rd.drawLine(32 + i90, 483, 32 + i90, 490);
                }
                for (int i91 = 0; i91 < 150; i91++) {
                    rd.setColor(Color.getHSBColor(hsb[0][0], i91 * 0.003333F, hsb[0][2]));
                    rd.drawLine(32 + i91, 499, 32 + i91, 506);
                }
                rd.setFont(new Font("Arial", 0, 11));
                ftm = rd.getFontMetrics();
                rd.setColor(Color.black);
                rd.drawString("Blend:", 32, 529);
                rd.setColor(Color.black);
                rd.fillRect(70, 522, 112, 2);
                rd.fillRect(70, 528, 112, 2);
                float f = 0.0F;
                int i92;
                for (int i93 = 0; i93 < 112; i93++) {
                    i92 = (int) (255.0F / (f + 1.0F));
                    if (i92 > 255) {
                        i92 = 255;
                    }
                    if (i92 < 0) {
                        i92 = 0;
                    }
                    f += 0.02F;
                    rd.setColor(new Color(i92, i92, i92));
                    rd.drawLine(70 + i93, 524, 70 + i93, 527);
                }
                rd.setColor(Color.black);
                rd.drawString("Height", 202 - ftm.stringWidth("Height") / 2, 461);
                rd.drawLine(202, 467, 202, 530);
                for (int i94 = 0; i94 < 8; i94++) {
                    rd.drawLine(202, 466 + i94 * 8, 202 + 8 - i94, 466 + i94 * 8);
                }
                rd.setFont(FontConstants.arial_12);
                ftm = rd.getFontMetrics();
                rd.setColor(Color.black);
                rd.drawString("Ground Texture", 257, 471);
                for (int i95 = 0; i95 < 150; i95++) {
                    rd.setColor(Color.getHSBColor(i95 * 0.006667F, 1.0F, 1.0F));
                    rd.drawLine(32 + i95 + 225, 477, 32 + i95 + 225, 484);
                }
                for (int i96 = 0; i96 < 150; i96++) {
                    rd.setColor(Color.getHSBColor(hsb[1][0], i96 * 0.006667F, i96 * 0.006667F));
                    rd.drawLine(32 + i96 + 225, 493, 32 + i96 + 225, 500);
                }
                rd.setFont(new Font("Arial", 0, 11));
                ftm = rd.getFontMetrics();
                rd.setColor(Color.black);
                rd.drawString("Blend:", 257, 523);
                rd.setColor(Color.black);
                rd.fillRect(295, 516, 112, 2);
                rd.fillRect(295, 522, 112, 2);
                f = 0.0F;
                for (int i97 = 0; i97 < 112; i97++) {
                    i92 = (int) (255.0F / (f + 1.0F));
                    if (i92 > 255) {
                        i92 = 255;
                    }
                    if (i92 < 0) {
                        i92 = 0;
                    }
                    f += 0.02F;
                    rd.setColor(new Color(i92, i92, i92));
                    rd.drawLine(70 + i97 + 225, 518, 70 + i97 + 225, 521);
                }
                for (int i98 = 0; i98 < 2; i98++) {
                    int i99 = 3;
                    if (i98 == 1) {
                        i99 = 2;
                    }
                    for (int i100 = 0; i100 < i99; i100++) {
                        int i101 = i100;
                        if (i100 == 1) {
                            i101 = 2;
                        }
                        if (i100 == 2) {
                            i101 = 1;
                        }
                        rd.setColor(Color.black);
                        float f102 = hsb[i98][i101] * 150.0F;
                        if (i100 == 1 && i98 == 0) {
                            final float f103 = 0.75F;
                            f102 = (hsb[i98][i101] - f103) / 0.001667F;
                        }
                        if (i100 == 2 && i98 == 0) {
                            f102 = hsb[i98][i101] / 0.003333F;
                        }
                        if (f102 < 0.0F) {
                            f102 = 0.0F;
                        }
                        if (f102 > 150.0F) {
                            f102 = 150.0F;
                        }
                        rd.drawLine((int) (32 + 225 * i98 + f102), 467 + i100 * 16 + 10 * i98, (int) (32 + 225 * i98 + f102), 474 + i100 * 16 + 10 * i98);
                        rd.drawLine((int) (33 + 225 * i98 + f102), 467 + i100 * 16 + 10 * i98, (int) (33 + 225 * i98 + f102), 474 + i100 * 16 + 10 * i98);
                        rd.fillRect((int) (31 + 225 * i98 + f102), 475 + i100 * 16 + 10 * i98, 4, 2);
                        rd.drawLine((int) (30 + 225 * i98 + f102), 477 + i100 * 16 + 10 * i98, (int) (35 + 225 * i98 + f102), 477 + i100 * 16 + 10 * i98);
                        if (xm > 29 + 225 * i98 && xm < 185 + 225 * i98 && ym > 468 + i100 * 16 + 10 * i98 && ym < 477 + i100 * 16 + 10 * i98 && mousePressed == 1 && mouseon == -1) {
                            mouseon = i100 + i98 * 3;
                        }
                        if (mouseon == i100 + i98 * 3) {
                            hsb[i98][i101] = (xm - (32 + 225 * i98)) * 0.006667F;
                            if (i100 == 1 && i98 == 1) {
                                hsb[i98][1] = (xm - (32 + 225 * i98)) * 0.006667F;
                                if (hsb[i98][1] > 1.0F) {
                                    hsb[i98][1] = 1.0F;
                                }
                                if (hsb[i98][1] < 0.0F) {
                                    hsb[i98][1] = 0.0F;
                                }
                            }
                            if (i100 == 1 && i98 == 0) {
                                final float f104 = 0.75F;
                                hsb[i98][i101] = f104 + (xm - (32 + 225 * i98)) * 0.001667F;
                                if (hsb[i98][i101] < f104) {
                                    hsb[i98][i101] = f104;
                                }
                            }
                            if (i100 == 2 && i98 == 0) {
                                hsb[i98][i101] = (xm - (32 + 225 * i98)) * 0.003333F;
                                if (hsb[i98][i101] > 0.5) {
                                    hsb[i98][i101] = 0.5F;
                                }
                            }
                            if (hsb[i98][i101] > 1.0F) {
                                hsb[i98][i101] = 1.0F;
                            }
                            if (hsb[i98][i101] < 0.0F) {
                                hsb[i98][i101] = 0.0F;
                            }
                        }
                    }
                    rd.setColor(Color.black);
                    float f105 = (texture[3] - 20) * 2.8F;
                    if (i98 == 0) {
                        f105 = cldd[3] * 11.2F;
                    }
                    if (f105 < 0.0F) {
                        f105 = 0.0F;
                    }
                    if (f105 > 112.0F) {
                        f105 = 112.0F;
                    }
                    rd.drawLine((int) (70 + 225 * i98 + f105), 522 - 6 * i98, (int) (70 + 225 * i98 + f105), 529 - 6 * i98);
                    rd.drawLine((int) (71 + 225 * i98 + f105), 522 - 6 * i98, (int) (71 + 225 * i98 + f105), 529 - 6 * i98);
                    rd.fillRect((int) (69 + 225 * i98 + f105), 530 - 6 * i98, 4, 2);
                    rd.drawLine((int) (68 + 225 * i98 + f105), 532 - 6 * i98, (int) (73 + 225 * i98 + f105), 532 - 6 * i98);
                    if (xm > 67 + 225 * i98 && xm < 185 + 225 * i98 && ym > 522 - 6 * i98 && ym < 532 - 6 * i98 && mousePressed == 1 && mouseon == -1) {
                        mouseon = 6 + i98;
                    }
                }
                if (mouseon == 6) {
                    cldd[3] = (int) ((xm - 70) / 11.2F);
                    if (cldd[3] < 0) {
                        cldd[3] = 0;
                    }
                    if (cldd[3] > 10) {
                        cldd[3] = 10;
                    }
                }
                if (mouseon == 7) {
                    texture[3] = (int) ((xm - 70 - 225) / 2.8 + 20.0);
                    if (texture[3] < 20) {
                        texture[3] = 20;
                    }
                    if (texture[3] > 60) {
                        texture[3] = 60;
                    }
                }
                rd.setColor(ColorConstants.c_0_128_255);
                float f106 = (1500 - Math.abs(cldd[4])) / 15.625F;
                if (f106 > 64.0F) {
                    f106 = 64.0F;
                }
                if (f106 < 0.0F) {
                    f106 = 0.0F;
                }
                rd.drawRect(199, (int) (465.0F + f106), 12, 2);
                if (xm > 197 && xm < 213 && ym > 463 && ym < 533 && mousePressed == 1 && mouseon == -1) {
                    mouseon = 8;
                }
                if (mouseon == 8) {
                    cldd[4] = -(int) ((530 - ym) * 15.625F + 500.0F);
                    if (cldd[4] > -500) {
                        cldd[4] = -500;
                    }
                    if (cldd[4] < -1500) {
                        cldd[4] = -1500;
                    }
                }
                Color color = Color.getHSBColor(hsb[0][0], hsb[0][1], hsb[0][2]);
                nfm.open.Medium.setcloads(color.getRed(), color.getGreen(), color.getBlue(), cldd[3], cldd[4]);
                cldd[0] = color.getRed();
                cldd[1] = color.getGreen();
                cldd[2] = color.getBlue();
                color = Color.getHSBColor(hsb[1][0], hsb[1][1], hsb[1][2]);
                nfm.open.Medium.setexture(color.getRed(), color.getGreen(), color.getBlue(), texture[3]);
                texture[0] = color.getRed();
                texture[1] = color.getGreen();
                texture[2] = color.getBlue();
                rd.setFont(FontConstants.arial_12);
                rd.setColor(Color.black);
                rd.drawString("Mountains", 452, 465);
                rd.setFont(new Font("Arial", 0, 11));
                rd.drawString("Mountain Generator Key:", 452, 480);
                movefield(mgen, 452, 484, 120, 20);
                if (mgen.hasFocus()) {
                    focuson = false;
                }
                if (!mgen.isShowing()) {
                    mgen.setVisible(true);
                }
                if (button("  Generate New  ", 512, 525, 3, true)) {
                    nfm.open.Medium.mgen = (int) (ThreadLocalRandom.current().nextDouble() * 100000.0);
                    mgen.setText("" + nfm.open.Medium.mgen);
                    if (ttstage.equals("")) {
                        ttstage = tstage;
                    }
                    sortop();
                    readstage(1);
                }
                if (!mgen.getText().equals("" + nfm.open.Medium.mgen)) {
                    try {
                        nfm.open.Medium.mgen = Integer.parseInt(mgen.getText());
                        if (ttstage.equals("")) {
                            ttstage = tstage;
                        }
                        sortop();
                        readstage(1);
                    } catch (final Exception exception) {
                        mgen.setText("" + nfm.open.Medium.mgen);
                    }
                }
                if (button(" Reset ", 650, 510, 0, true)) {
                    if (!ttstage.equals("")) {
                        tstage = ttstage;
                        ttstage = "";
                    }
                    readstage(1);
                    dtabed = -2;
                }
                if (button("        Save        ", 737, 510, 0, true)) {
                    sortop();
                    ttstage = "";
                    savefile();
                }
            }
            if (dtab == 1) {
                if (dtabed != dtab) {
                    for (int i108 = 0; i108 < 3; i108++) {
                        snap[i108] = (int) (nfm.open.Medium.snap[i108] / 1.2F + 50.0F);
                    }
                    fogn[0] = (8 - ((nfm.open.Medium.fogd + 1) / 2 - 1)) * 20;
                    fogn[1] = (nfm.open.Medium.fade[0] - 5000) / 30;
                }
                rd.setColor(Color.black);
                rd.drawString("Atmosphere RGB Mask", 20, 461);
                rd.setColor(ColorConstants.c_128_128_128);
                rd.drawLine(10, 457, 17, 457);
                rd.drawLine(260, 457, 152, 457);
                rd.drawLine(10, 457, 10, 546);
                rd.drawLine(260, 457, 260, 527);
                rd.drawLine(260, 527, 360, 527);
                rd.drawLine(10, 546, 360, 546);
                rd.drawLine(360, 527, 360, 546);
                final String[] strings109 = {
                        "Red", "Green", "Blue"
                };
                final int[] is110 = {
                        32, 20, 29
                };
                int i111 = 38;
                int i112 = -70;
                for (int i113 = 0; i113 < 3; i113++) {
                    rd.setColor(Color.black);
                    rd.drawString(strings109[i113] + " :", is110[i113], 447 + i113 * 24 + i111);
                    rd.drawLine(140 + i112, 443 + i113 * 24 + i111, 230 + i112, 443 + i113 * 24 + i111);

                    if (xm > 140 + i112 && xm < 230 + i112 && ym > 443 + i113 * 24 + i111 - 10 && ym < 443 + i113 * 24 + i111 + 10 && mousePressed == 1 && mouseon == -1) {
                        mouseon = 1337 + i113;
                    } else if (mouseon == 1337 + i113 && mousePressed == 0) {
                        mouseon = -1;
                    }
                    if (mouseon == 1337 + i113 && mousePressed != 0) {
                        snap[i113] = xm - (140 + i112) - (230 + i112) + 165;
                        if (snap[i113] > 100) {
                            snap[i113] = 100;
                            mouseon = -1;
                            mousePressed = 0;
                        }
                        if (snap[i113] < 0) {
                            snap[i113] = 0;
                            mouseon = -1;
                            mousePressed = 0;
                        }
                        /*if (Medium.snap[0] != (int) (snap[0] * 1.2F - 60.0F) || Medium.snap[1] != (int) (snap[1] * 1.2F - 60.0F) || Medium.snap[2] != (int) (snap[2] * 1.2F - 60.0F)) {
                            for (int i117 = 0; i117 < 3; i117++) {
                                Medium.snap[i117] = (short) (snap[i117] * 1.2F - 60.0F);
                            }
                            readstage(1);
                        }*/

                        /*if (i86 == 0) {
                            hsb[i82][i86] = (xm - (32 + 195 * i82)) / 150.0F;
                        }
                        if (i86 == 1) {
                            float f88 = 0.75F;
                            if (i82 == 0) {
                                f88 = 0.85F;
                            }
                            if (i82 == 1) {
                                f88 = 0.8F;
                            }
                            hsb[i82][i86] = f88 + (xm - (32 + 195 * i82)) * 0.001F;
                            if (hsb[i82][i86] < f88) {
                                hsb[i82][i86] = f88;
                            }
                            if (hsb[i82][i86] > f88 + 0.15F) {
                                hsb[i82][i86] = f88 + 0.15F;
                            }
                        }
                        if (i86 == 2) {
                            hsb[i82][i86] = (xm - (32 + 195 * i82)) / 600.0F;
                            if (hsb[i82][i86] > 0.25) {
                                hsb[i82][i86] = 0.25F;
                            }
                        }
                        if (hsb[i82][i86] > 1.0F) {
                            hsb[i82][i86] = 1.0F;
                        }
                        if (hsb[i82][i86] < 0.0F) {
                            hsb[i82][i86] = 0.0F;
                        }*/
                    }

                    for (int i114 = 1; i114 < 10; i114++) {
                        rd.drawLine(140 + 10 * i114 + i112, 443 - i114 + i113 * 24 + i111, 140 + 10 * i114 + i112, 443 + i114 + i113 * 24 + i111);
                    }
                    rd.setColor(Color.red);
                    final int i115 = (int) (snap[i113] / 1.1111F / 10.0F);
                    rd.fillRect(138 + (int) (snap[i113] / 1.1111F) + i112, 443 - i115 + i113 * 24 + i111, 5, i115 * 2 + 1);
                    rd.setColor(ColorConstants.c_255_128_0);
                    rd.drawRect(139 + (int) (snap[i113] / 1.1111F) + i112, 434 + i113 * 24 + i111, 2, 18);
                    if (button(" - ", 260 + i112, 447 + i113 * 24 + i111, 4, false)) {
                        snap[i113] -= 2;
                        if (snap[i113] < 0) {
                            snap[i113] = 0;
                        }
                    }
                    if (button(" + ", 300 + i112, 447 + i113 * 24 + i111, 4, false)) {
                        if (snap[0] + snap[1] + snap[2] > 200) {
                            for (int i116 = 0; i116 < 3; i116++) {
                                if (i116 != i113) {
                                    snap[i116]--;
                                    if (snap[i116] < 0) {
                                        snap[i116] = 0;
                                    }
                                }
                            }
                        }
                        snap[i113] += 2;
                        if (snap[i113] > 100/* && !isHansen*/) {
                            snap[i113] = 100;
                        }
                    }
                }
                if (nfm.open.Medium.snap[0] != (int) (snap[0] * 1.2F - 60.0F) || nfm.open.Medium.snap[1] != (int) (snap[1] * 1.2F - 60.0F) || nfm.open.Medium.snap[2] != (int) (snap[2] * 1.2F - 60.0F)) {
                    for (int i117 = 0; i117 < 3; i117++) {
                        nfm.open.Medium.snap[i117] = (short) (snap[i117] * 1.2F - 60.0F);
                    }
                    readstage(2);
                }
                rd.setColor(Color.black);
                rd.drawString("Car Lights :", 265, 541);
                if (snap[0] + snap[1] + snap[2] > 110) {
                    rd.drawString("Off", 335, 541);
                    nfm.open.Medium.lightson = false;
                } else {
                    rd.setColor(ColorConstants.c_0_200_0);
                    rd.drawString("On", 335, 541);
                    nfm.open.Medium.lightson = true;
                }
                final int i118 = 33;
                rd.setColor(Color.black);
                rd.drawString("Dust/Fog Properties", 280 + i118, 461);
                rd.setColor(ColorConstants.c_128_128_128);
                rd.drawLine(270 + i118, 457, 277 + i118, 457);
                rd.drawLine(540 + i118, 457, 393 + i118, 457);
                rd.drawLine(270 + i118, 457, 270 + i118, 522);
                rd.drawLine(540 + i118, 457, 540 + i118, 522);
                rd.drawLine(270 + i118, 522, 540 + i118, 522);
                final String[] strings119 = {
                        "Density", "Near / Far"
                };
                final int[] is120 = {
                        292 + i118, 280 + i118
                };
                final int[] is121 = {
                        20, 10
                };
                i111 = 38;
                i112 = 210 + i118;
                for (int i122 = 0; i122 < 2; i122++) {
                    rd.setColor(Color.black);
                    rd.drawString(strings119[i122] + " :", is120[i122], 447 + i122 * 24 + i111);
                    rd.drawLine(140 + i112, 443 + i122 * 24 + i111, 230 + i112, 443 + i122 * 24 + i111);
                    for (int i123 = 1; i123 < 10; i123++) {
                        rd.drawLine(140 + 10 * i123 + i112, 443 - i123 + i122 * 24 + i111, 140 + 10 * i123 + i112, 443 + i123 + i122 * 24 + i111);
                    }
                    rd.setColor(Color.red);
                    final int i124 = (int) (fogn[i122] / 1.1111F / 10.0F);
                    rd.fillRect(138 + (int) (fogn[i122] / 1.1111F) + i112, 443 - i124 + i122 * 24 + i111, 5, i124 * 2 + 1);
                    rd.setColor(ColorConstants.c_255_128_0);
                    rd.drawRect(139 + (int) (fogn[i122] / 1.1111F) + i112, 434 + i122 * 24 + i111, 2, 18);
                    if (button(" - ", 260 + i112, 447 + i122 * 24 + i111, 4, false)) {
                        fogn[i122] -= is121[i122];
                        if (fogn[i122] < 0) {
                            fogn[i122] = 0;
                        }
                    }
                    if (button(" + ", 300 + i112, 447 + i122 * 24 + i111, 4, false)) {
                        fogn[i122] += is121[i122];
                        if (fogn[i122] > 100 && !isHansen) {
                            fogn[i122] = 100;
                        }
                    }
                }
                nfm.open.Medium.fogd = (8 - fogn[0] / 20 + 1) * 2 - 1;
                nfm.open.Medium.fadfrom(5000 + fogn[1] * 30);
                origfade = nfm.open.Medium.fade[0];
                if (button(" Reset ", 650, 510, 0, true)) {
                    dtabed = -2;
                }
                if (button("        Save        ", 737, 510, 0, true)) {
                    sortop();
                    savefile();
                }
            }
            if (dtab == 4) {
                if (dtabed != dtab && nfm.open.CheckPoints.nlaps - 1 >= 0 && nfm.open.CheckPoints.nlaps - 1 <= 14) {
                    nlaps.select(nfm.open.CheckPoints.nlaps - 1);
                }
                rd.setColor(Color.black);
                rd.drawString("Set the number of laps for this stage:", 130, 496);
                nlaps.move(348, 480);
                if (!nlaps.isShowing()) {
                    nlaps.setVisible(true);
                }
                if (nfm.open.CheckPoints.nlaps != nlaps.getSelectedIndex() + 1) {
                    nfm.open.CheckPoints.nlaps = nlaps.getSelectedIndex() + 1;
                    gameFrame.requestFocus();
                }
                if (button(" Reset ", 530, 496, 0, true)) {
                    dtabed = -2;
                }
                if (button("        Save        ", 617, 496, 0, true)) {
                    sortop();
                    savefile();
                }
            }
            if (dtab == 5) {
                if (dtabed != dtab) {
                    tracks.removeAll();
                    tracks.maxl = 200;
                    tracks.add(rd, "The Play List  -  MOD Tracks");
                    final String[] strings125 = new File("mystages/mymusic/").list();
                    if (strings125 != null) {
                        for (final String element : strings125) {
                            if (element.toLowerCase().endsWith(".zip")) {
                                tracks.add(rd, element.substring(0, element.length() - 4));
                            }
                        }
                    }
                    if (ltrackname.equals("")) {
                        if (trackname.equals("")) {
                            tracks.select(0);
                        } else {
                            tracks.select(trackname);
                        }
                    } else {
                        tracks.select(ltrackname);
                    }
                    mouseon = -1;
                }
                tracks.move(10, 450);
                if (tracks.getWidth() != 200) {
                    tracks.setSize(200, 21);
                }
                if (!tracks.isShowing()) {
                    tracks.setVisible(true);
                }
                if (track.playing && track.loaded == 2) {
                    if (button("      Stop      ", 110, 495, 2, false)) {
                        track.setPaused(true);
                    }
                    if (!ltrackname.equals(tracks.getSelectedItem())) {
                        track.setPaused(true);
                    }
                    if (xm > 10 && xm < 210 && ym > 516 && ym < 534) {
                        if (mousePressed == 1) {
                            mouseon = 1;
                        }
                        rd.setColor(ColorConstants.c_0_164_242);
                    } else {
                        rd.setColor(ColorConstants.c_120_210_255);
                    }
                    rd.drawRect(10, 516, 200, 18);
                    rd.setColor(ColorConstants.c_200_200_200);
                    rd.drawLine(10, 523, 210, 523);
                    rd.setColor(Color.black);
                    rd.drawLine(10, 524, 210, 524);
                    rd.drawLine(10, 525, 210, 525);
                    rd.drawLine(10, 526, 210, 526);
                    rd.setColor(Color.white);
                    rd.drawLine(10, 527, 210, 527);
                    int i127 = (int) ((1.0F - (float) track.sClip.stream.available() / (float) avon) * 200.0F);
                    if (mouseon == 1) {
                        i127 = xm - 10;
                        if (i127 < 0) {
                            i127 = 0;
                        }
                        if (i127 > 200) {
                            i127 = 200;
                        }
                        if (mousePressed != 1) {
                            track.sClip.stream.reset();
                            track.sClip.stream.skip((long) (i127 / 200.0F * avon));
                            mouseon = -1;
                        }
                    }
                    rd.setColor(Color.black);
                    rd.drawRect(8 + i127, 516, 4, 18);
                    rd.setColor(ColorConstants.c_0_164_242);
                    rd.drawLine(10 + i127, 520, 10 + i127, 518);
                    rd.drawLine(10 + i127, 530, 10 + i127, 532);
                } else if (tracks.getSelectedIndex() != 0 && button("      Play  >      ", 110, 495, 2, false)) {
                    if (!ltrackname.equals(tracks.getSelectedItem())) {
                        track.unload();
                        track = new RadicalAdapter();
                        if (track.loaded == 2) {
                            avon = track.sClip.stream.available();
                            ltrackname = tracks.getSelectedItem();
                        } else {
                            ltrackname = "";
                        }
                    }
                    if (!ltrackname.equals("")) {
                        track.play();
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to load '" + tracks.getSelectedItem() + "', please make sure it is a valid MOD Track!", "Stage Maker", 1);
                    }
                }
                if (tracks.getSelectedIndex() != 0) {
                    if (button("   Set as the stage's Sound Track  >   ", 330, 466, 2, false)) {
                        if (!ltrackname.equals(tracks.getSelectedItem())) {
                            track.unload();
                            track = new RadicalAdapter();
                            if (track.loaded == 2) {
                                avon = track.sClip.stream.available();
                                ltrackname = tracks.getSelectedItem();
                            } else {
                                ltrackname = "";
                            }
                        }
                        if (!ltrackname.equals("")) {
                            trackname = ltrackname;
                            trackvol = (int) (220.0F / (track.rvol / 3750.0F));
                            try {
                                final File file = new File("mystages/mymusic/" + trackname + ".zip");
                                tracksize = (int) (file.length() / 1024L);
                                if (tracksize > 250) {
                                    JOptionPane.showMessageDialog(null, "Cannot use '" + tracks.getSelectedItem() + "' as the sound track!\nIts file size is bigger then 250KB.\n\n", "Stage Maker", 1);
                                    trackname = "";
                                }
                            } catch (final Exception exception) {
                                tracksize = 111;
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to load '" + tracks.getSelectedItem() + "', please make sure it is a valid MOD Track!", "Stage Maker", 1);
                        }
                    }
                    if (button("   X Delete   ", 258, 495, 2, false) && JOptionPane.showConfirmDialog(null, "Are you sure you want to permanently delete this MOD Track from your Play List?\n\n" + tracks.getSelectedItem() + "\n\n>  If you delete this Track from the Play List you will not be able to use it for other stages as well!     \n\n", "Stage Maker", 0) == 0) {
                        deltrack();
                    }
                }
                if (button("   Add a new MOD Track from file . . .  ", 330, 530, 0, false) && JOptionPane.showConfirmDialog(null, "The game only accepts MOD format music files for the game ('.mod' file extension).\nA good place to find MOD Tracks is the modarchive.com, all the current MOD Tracks\nthat are distributed with the game are from the modarchive.com.\n\nTo find out more about MOD Tracks and to learn how to compose & remix your own\nmusic, please read the section of the Stage Maker help about it.\n\nThe MOD Track needs to be compressed in a zip file to be added here, please make\nsure the MOD Track you wish to add to your stages sound track play list is zipped before\nadding it here.\nThe ZIP file must also be less then 250KB in size.\n\nIs the track you are about to insert a MOD Track in a ZIP file that is less then 250KB?\n", "Stage Maker", 0) == 0) {
                    File file = null;
                    final FileDialog filedialog = new FileDialog(new Frame(), "Stage Maker - Add MOD Track file to stage sound track play list!");
                    filedialog.setFile("*.zip");
                    filedialog.setMode(0);
                    filedialog.setVisible(true);
                    try {
                        if (filedialog.getFile() != null) {
                            file = new File("" + filedialog.getDirectory() + filedialog.getFile());
                        }
                    } catch (final Exception ignored) {

                    }
                    if (file != null) {
                        try {
                            if (file.length() / 1024L < 250L) {
                                File file128 = new File("mystages/mymusic/");
                                if (!file128.exists()) {
                                    file128.mkdirs();
                                }
                                file128 = new File("mystages/mymusic/" + file.getName());
                                final FileInputStream fileinputstream = new FileInputStream(file);
                                final FileOutputStream fileoutputstream = new FileOutputStream(file128);
                                final byte[] is129 = new byte[1024];
                                int i130;
                                while ((i130 = fileinputstream.read(is129)) > 0) {
                                    fileoutputstream.write(is129, 0, i130);
                                }
                                fileinputstream.close();
                                fileoutputstream.close();
                                tracks.removeAll();
                                tracks.add(rd, "Select MOD Track                      ");
                                final String[] strings131 = new File("mystages/mymusic/").list();
                                if (strings131 != null) {
                                    for (final String element : strings131) {
                                        if (element.toLowerCase().endsWith(".zip")) {
                                            tracks.add(rd, element.substring(0, element.length() - 4));
                                        }
                                    }
                                }
                                tracks.select(file.getName().substring(0, file.getName().length() - 4));
                            } else {
                                JOptionPane.showMessageDialog(null, "The selected file is larger then 250KB in size and therefore cannot be added!", "Stage Maker", 1);
                            }
                        } catch (final Exception exception) {
                            JOptionPane.showMessageDialog(null, "Unable to copy file! Error Deatials:\n" + exception, "Stage Maker", 1);
                        }
                    }
                }
                final int i133 = 200;
                rd.setColor(Color.black);
                rd.drawString("Sound Track", 280 + i133, 461);
                String string = trackname;
                if (string.equals("")) {
                    string = "No Sound Track set.";
                } else if (button("   <  Remove Track   ", 378, 495, 2, false)) {
                    trackname = "";
                }
                rd.drawString(string, 629 - ftm.stringWidth(string) / 2, 482);
                rd.setColor(ColorConstants.c_128_128_128);
                rd.drawLine(270 + i133, 457, 277 + i133, 457);
                rd.drawLine(589 + i133, 457, 353 + i133, 457);
                rd.drawLine(270 + i133, 457, 270 + i133, 497);
                rd.drawLine(589 + i133, 457, 589 + i133, 497);
                rd.drawLine(270 + i133, 497, 589 + i133, 497);
                if (button(" Reset ", 576, 530, 0, true)) {
                    ltrackname = "";
                    dtabed = -2;
                }
                if (button("        Save        ", 663, 530, 0, true)) {
                    sortop();
                    savefile();
                }
            }
            if (dtab == 6) {
                rd.setColor(Color.black);
                rd.setFont(FontConstants.arial_13);
                ftm = rd.getFontMetrics();
                rd.drawString("Test Drive the Stage", 400 - ftm.stringWidth("Test Drive the Stage") / 2, 470);
                witho.move(342, 480);
                if (!witho.isShowing()) {
                    witho.setVisible(true);
                }
                if (button("     TEST DRIVE!     ", 400, 530, 0, true)) {
                    savefile();
                    errd = 0;
                    readstage(3);
                    if (nfm.open.CheckPoints.nsp < 2) {
                        errd = 7;
                    }
                    if (errd == 0) {
                        Madness.testcar = stagename;
                        Madness.testdrive = witho.getSelectedIndex() + 3;
                        //Madness.game();
                        // TODO test drive
                        //Madness.testDrive(gameFrame);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error!  This stage is not ready for a test drive!\nReason:\n" + errlo[errd - 1] + "\n\n", "Stage Maker", 0);
                    }
                }
            }
            if (dtabed != dtab) {
                if (dtabed == -2) {
                    dtabed = -1;
                } else {
                    dtabed = dtab;
                }
            }
        }
        if (tab == 3) {
            rd.setFont(FontConstants.arial_13);
            rd.setColor(Color.black);
            rd.drawString("Publish Stage :  [ " + stagename + " ]", 30, 50);
            rd.drawString("Publishing Type :", 30, 80);
            pubtyp.move(150, 63);
            if (!pubtyp.isShowing()) {
                pubtyp.setVisible(true);
                pubtyp.select(1);
            }
            rd.setColor(Color.black);
            rd.setFont(new Font("Arial", 0, 12));
            if (pubtyp.getSelectedIndex() == 0) {
                rd.drawString("private static :  This means only you can have your stage in your account and no one else can add", 268, 72);
                rd.drawString("it to their account to play it!", 268, 88);
            }
            if (pubtyp.getSelectedIndex() == 1) {
                rd.drawString("Public :  This means anyone can add this stage to their account to play it, but only you can", 268, 72);
                rd.drawString("download it to your Stage Maker and edit it (no one else but you can edit it).", 268, 88);
            }
            if (pubtyp.getSelectedIndex() == 2) {
                rd.drawString("Super Public :  This means anyone can add this stage to their account to play it and can also", 268, 72);
                rd.drawString("download it to their stage Maker, edit it and publish it.", 268, 88);
            }
            rd.setFont(FontConstants.arial_12);
            ftm = rd.getFontMetrics();
            rd.drawString("Stage Name", 180 - ftm.stringWidth("Stage Name") / 2, 138);
            rd.drawString("Created By", 400 - ftm.stringWidth("Created By") / 2, 138);
            rd.drawString("Added By", 500 - ftm.stringWidth("Added By") / 2, 138);
            rd.drawString("Publish Type", 600 - ftm.stringWidth("Publish Type") / 2, 138);
            rd.drawString("Options", 720 - ftm.stringWidth("Options") / 2, 138);
            rd.drawLine(350, 129, 350, 140);
            rd.drawLine(450, 129, 450, 140);
            rd.drawLine(550, 129, 550, 140);
            rd.drawLine(650, 129, 650, 140);
            rd.drawRect(10, 140, 780, 402);
            if (button("       Publish  >       ", 102, 110, 0, true)) {
                if (logged == 0) {
                    JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Stage Maker", 1);
                }
                if (logged == 3 || logged == -1) {
                    savefile();
                    errd = 0;
                    readstage(3);
                    if (nfm.open.CheckPoints.nsp < 2) {
                        errd = 7;
                    }
                    rd.setFont(FontConstants.arial_12);
                    ftm = rd.getFontMetrics();
                    if (ftm.stringWidth(stagename) > 274) {
                        errd = 8;
                    }
                    if (errd == 0) {
                        int i = 0;
                        for (int i134 = 0; i134 < nms; i134++) {
                            if (mystages[i134].equals(stagename) && maker[i134].equalsIgnoreCase(tnick.getText().toLowerCase())) {
                                i = JOptionPane.showConfirmDialog(null, "Replace your already online stage '" + stagename + "' with this one?", "Stage Maker", 0);
                            }
                        }
                        if (i == 0) {
                            gameFrame.setCursor(new Cursor(3));
                            rd.setFont(FontConstants.arial_13);
                            ftm = rd.getFontMetrics();
                            rd.setColor(Color.white);
                            rd.fillRect(11, 141, 779, 401);
                            rd.setColor(Color.black);
                            rd.drawString("Connecting to Server...", 400 - ftm.stringWidth("Connecting to Server...") / 2, 250);
                            //repaint();
                            int i135 = -1;
                            try {
                                final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                final BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                                printwriter.println("20|" + tnick.getText() + "|" + tpass.getText() + "|" + stagename + "|" + pubtyp.getSelectedIndex() + "|");
                                String string = bufferedreader.readLine();
                                if (string != null) {
                                    i135 = servervalue(string, 0);
                                }
                                if (i135 == 0) {
                                    String string136 = " Publishing Stage ";
                                    final String string137 = tstage + "\r\n" + bstage;
                                    final BufferedReader datainputstream = new BufferedReader(new StringReader(string137));
                                    String string139;
                                    while ((string139 = datainputstream.readLine()) != null) {
                                        string139 = string139.trim();
                                        printwriter.println(string139);
                                        rd.setColor(Color.white);
                                        rd.fillRect(11, 141, 779, 401);
                                        rd.setColor(Color.black);
                                        rd.drawString(string136, 400 - ftm.stringWidth(string136) / 2, 250);
                                        string136 = "| " + string136 + " |";
                                        if (string136.equals("| | | | | | | | | | | | | | | | | | | | | | | |  Publishing Stage  | | | | | | | | | | | | | | | | | | | | | | | |")) {
                                            string136 = " Publishing Stage ";
                                        }
                                        //repaint();
                                        try {
                                            Thread.sleep(10L);
                                        } catch (final InterruptedException ignored) {

                                        }
                                    }
                                    printwriter.println("QUITX1111");
                                    rd.setColor(Color.white);
                                    rd.fillRect(11, 141, 779, 401);
                                    rd.setColor(Color.black);
                                    rd.drawString("Creating the stage online...", 400 - ftm.stringWidth("Creating the stage online...") / 2, 250);
                                    rd.drawString("This may take a couple of minutes, please wait...", 400 - ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                                    //repaint();
                                    string = bufferedreader.readLine();
                                    if (string != null) {
                                        i135 = servervalue(string, 0);
                                    } else {
                                        i135 = -1;
                                    }
                                    if (i135 == 0) {
                                        rd.setColor(Color.white);
                                        rd.fillRect(11, 141, 779, 401);
                                        rd.setColor(Color.black);
                                        rd.drawString("Uploading stage's sound track...", 400 - ftm.stringWidth("Uploading Stage's Sound Track...") / 2, 250);
                                        rd.drawString("This may take a couple of minutes, please wait...", 400 - ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                                        //repaint();
                                        final File file = new File("mystages/mymusic/" + trackname + ".zip");
                                        if (!trackname.equals("") && file.exists()) {
                                            final int i140 = (int) file.length();
                                            printwriter.println("track|" + trackname + "|" + i140 + "|");
                                            string = bufferedreader.readLine();
                                            if (string != null) {
                                                i135 = servervalue(string, 0);
                                            } else {
                                                i135 = -2;
                                            }
                                            if (i135 == 0) {
                                                final FileInputStream fileinputstream = new FileInputStream(file);
                                                final byte[] is = new byte[i140];
                                                fileinputstream.read(is);
                                                fileinputstream.close();
                                                final DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());
                                                dataoutputstream.write(is, 0, i140);
                                                string = bufferedreader.readLine();
                                                if (string != null) {
                                                    i135 = servervalue(string, 0);
                                                } else {
                                                    i135 = -2;
                                                }
                                            }
                                            if (i135 == -67) {
                                                i135 = 0;
                                            }
                                        } else {
                                            printwriter.println("END");
                                            string = bufferedreader.readLine();
                                        }
                                    }
                                }
                                socket.close();
                            } catch (final Exception exception) {
                                i135 = -1;
                            }
                            gameFrame.setCursor(new Cursor(0));
                            boolean bool = false;
                            if (i135 == 0) {
                                logged = 1;
                                bool = true;
                            }
                            if (i135 == 3) {
                                JOptionPane.showMessageDialog(null, "Unable to publish stage.\nReason:\n" + errlo[6] + "\n\n", "Stage Maker", 1);
                                bool = true;
                            }
                            if (i135 == 4) {
                                JOptionPane.showMessageDialog(null, "Unable to publish stage.\nReason:\nStage name used (" + stagename + ").\nThe name '" + stagename + "' is already used by another published stage.\nPlease rename your stage.\n\n", "Stage Maker", 1);
                                bool = true;
                            }
                            if (i135 == 5) {
                                JOptionPane.showMessageDialog(null, "Unable to create stage online!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                                bool = true;
                            }
                            if (i135 > 5) {
                                JOptionPane.showMessageDialog(null, "Unable to publish stage fully!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                                bool = true;
                            }
                            if (i135 == -4) {
                                logged = 1;
                                JOptionPane.showMessageDialog(null, "Unable to upload sound track!\nReason:\nAnother MOD Track is already uploaded with the same name, please rename your Track.\nOpen your 'mystages' folder then open 'mymusic' to find your MOD Track to rename it.\n\n", "Stage Maker", 1);
                                bool = true;
                            }
                            if (i135 == -3) {
                                logged = 1;
                                JOptionPane.showMessageDialog(null, "Unable to upload sound track!\nReason:\nYour MOD Track\u2019s file size is too large, Track file size must be less then 250KB to be accepted.\n\n", "Stage Maker", 1);
                                bool = true;
                            }
                            if (i135 == -2) {
                                logged = 1;
                                JOptionPane.showMessageDialog(null, "Unable to upload sound track!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                                bool = true;
                            }
                            if (!bool) {
                                JOptionPane.showMessageDialog(null, "Unable to publish stage!  Unknown Error.", "Stage Maker", 1);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error!  This stage is not ready for publishing!\nReason:\n" + errlo[errd - 1] + "\n\n", "Stage Maker", 0);
                    }
                }
            }
            if (logged == 3) {
                for (int i = 0; i < nms; i++) {
                    rd.setColor(ColorConstants.c_235_235_235);
                    if (xm > 11 && xm < 789 && ym > 142 + i * 20 && ym < 160 + i * 20) {
                        rd.setColor(Color.white);
                    }
                    rd.fillRect(11, 142 + i * 20, 778, 18);
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.setColor(Color.black);
                    rd.drawString(mystages[i], 180 - ftm.stringWidth(mystages[i]) / 2, 156 + i * 20);
                    rd.setColor(ColorConstants.c_155_155_155);
                    rd.drawLine(350, 145 + i * 20, 350, 157 + i * 20);
                    if (pubt[i] != -1) {
                        rd.drawLine(450, 145 + i * 20, 450, 157 + i * 20);
                        rd.drawLine(550, 145 + i * 20, 550, 157 + i * 20);
                        rd.drawLine(650, 145 + i * 20, 650, 157 + i * 20);
                        boolean bool = false;
                        if (maker[i].equalsIgnoreCase(tnick.getText().toLowerCase())) {
                            bool = true;
                            rd.setColor(ColorConstants.c_0_64_0);
                            rd.drawString("You", 400 - ftm.stringWidth("You") / 2, 156 + i * 20);
                        } else {
                            rd.setColor(ColorConstants.c_0_0_64);
                            rd.drawString(maker[i], 400 - ftm.stringWidth(maker[i]) / 2, 156 + i * 20);
                        }
                        if (nad[i] > 1) {
                            if (ovbutton(nad[i] + " Players", 500, 156 + i * 20)) {
                                String string = "[ " + mystages[i] + " ]  has been added by the following players to their accounts:     \n\n";
                                int i141 = 0;
                                for (int i142 = 0; i142 < nad[i]; i142++) {
                                    if (++i141 == 17) {
                                        string = string + "\n";
                                        i141 = 1;
                                    }
                                    string = "" + string + addeda[i][i142];
                                    if (i142 != nad[i] - 1) {
                                        if (i142 != nad[i] - 2) {
                                            string = string + ", ";
                                        } else if (i141 == 16) {
                                            string = string + "\nand ";
                                            i141 = 0;
                                        } else {
                                            string = string + " and ";
                                        }
                                    }
                                }
                                string = string + "\n \n \n";
                                JOptionPane.showMessageDialog(null, string, "Stage Maker", 1);
                            }
                        } else {
                            rd.setColor(ColorConstants.c_0_0_64);
                            rd.drawString("None", 500 - ftm.stringWidth("None") / 2, 156 + i * 20);
                        }
                        if (pubt[i] == 0) {
                            rd.setColor(ColorConstants.c_0_0_64);
                            rd.drawString("Private", 600 - ftm.stringWidth("Private") / 2, 156 + i * 20);
                        }
                        if (pubt[i] == 1) {
                            rd.setColor(ColorConstants.c_0_0_64);
                            rd.drawString("Public", 600 - ftm.stringWidth("Public") / 2, 156 + i * 20);
                        }
                        if (pubt[i] == 2) {
                            rd.setColor(ColorConstants.c_0_64_0);
                            rd.drawString("Super Public", 600 - ftm.stringWidth("Super Public") / 2, 156 + i * 20);
                        }
                        if ((pubt[i] == 2 || bool) && ovbutton("Download", 700, 156 + i * 20)) {
                            int i143 = 0;
                            for (int i144 = 0; i144 < slstage.getItemCount(); i144++) {
                                if (mystages[i].equals(slstage.getItem(i144))) {
                                    i143 = JOptionPane.showConfirmDialog(null, "Replace the local " + mystages[i] + " in your 'mystages' folder with the published online copy?", "Stage Maker", 0);
                                }
                            }
                            if (i143 == 0) {
                                gameFrame.setCursor(new Cursor(3));
                                rd.setFont(FontConstants.arial_13);
                                ftm = rd.getFontMetrics();
                                rd.setColor(Color.white);
                                rd.fillRect(11, 141, 779, 401);
                                rd.setColor(Color.black);
                                rd.drawString("Downloading stage, please wait...", 400 - ftm.stringWidth("Downloading stage, please wait...") / 2, 250);
                                //repaint();
                                try {
                                    String string = "http://multiplayer.needformadness.com/tracks/" + mystages[i] + ".radq?reqlo=" + (int) (ThreadLocalRandom.current().nextDouble() * 1000.0);
                                    string = string.replace(' ', '_');
                                    URL url = new URL(string);
                                    int i145 = url.openConnection().getContentLength();
                                    DataInputStream datainputstream = new DataInputStream(url.openStream());
                                    byte[] is = new byte[i145];
                                    datainputstream.readFully(is);
                                    datainputstream.close();
                                    ZipInputStream zipinputstream;
                                    if (is[0] == 80 && is[1] == 75 && is[2] == 3) {
                                        zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                                    } else {
                                        final byte[] is146 = new byte[i145 - 40];
                                        for (int i147 = 0; i147 < i145 - 40; i147++) {
                                            int i148 = 20;
                                            if (i147 >= 500) {
                                                i148 = 40;
                                            }
                                            is146[i147] = is[i147 + i148];
                                        }
                                        zipinputstream = new ZipInputStream(new ByteArrayInputStream(is146));
                                    }
                                    final ZipEntry zipentry = zipinputstream.getNextEntry();
                                    if (zipentry != null) {
                                        String string149 = "";
                                        int i150 = Integer.parseInt(zipentry.getName());
                                        final byte[] is151 = new byte[i150];
                                        int i152 = 0;
                                        int i153;
                                        for (/**/; i150 > 0; i150 -= i153) {
                                            i153 = zipinputstream.read(is151, i152, i150);
                                            i152 += i153;
                                        }
                                        String string154 = new String(is151);
                                        string154 = string154 + "\n";
                                        String string155 = "";
                                        int i156 = 0;
                                        int i157 = string154.indexOf("\n", 0);
                                        while (i157 != -1 && i156 < string154.length()) {
                                            String string158 = string154.substring(i156, i157);
                                            string158 = string158.trim();
                                            i156 = i157 + 1;
                                            i157 = string154.indexOf("\n", i156);
                                            if (!string158.startsWith("stagemaker(") && !string158.startsWith("publish(")) {
                                                string155 = string155 + string158 + "\r\n";
                                            } else {
                                                string155 = string155.trim();
                                                string155 = string155 + "\r\n";
                                            }
                                            if (string158.startsWith("soundtrack")) {
                                                string149 = getstring("soundtrack", string158, 0);
                                            }
                                        }
                                        string155 = string155.trim();
                                        string155 = string155 + "\r\n\r\n";
                                        File file = new File("mystages/");
                                        if (!file.exists()) {
                                            file.mkdirs();
                                        }
                                        file = new File("mystages/" + mystages[i] + ".txt");
                                        final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                        bufferedwriter.write(string155);
                                        bufferedwriter.close();
                                        zipinputstream.close();
                                        if (!string149.equals("")) {
                                            try {
                                                rd.setColor(Color.black);
                                                rd.drawString("Downloading stage's sound track...", 400 - ftm.stringWidth("Downloading stage's sound track...") / 2, 280);
                                                //repaint();
                                                string = "http://multiplayer.needformadness.com/tracks/music/" + string149 + ".zip";
                                                string = string.replace(' ', '_');
                                                url = new URL(string);
                                                i145 = url.openConnection().getContentLength();
                                                file = new File("mystages/mymusic/" + string149 + ".zip");
                                                if (file.exists()) {
                                                    if (file.length() == i145) {
                                                        i143 = 1;
                                                    } else {
                                                        i143 = JOptionPane.showConfirmDialog(null, "Another track named '" + string149 + "' already exists in your Sound Tracks folder!\nReplace it with the one attached to this stage?", "Stage Maker", 0);
                                                    }
                                                }
                                                if (i143 == 0) {
                                                    datainputstream = new DataInputStream(url.openStream());
                                                    is = new byte[i145];
                                                    datainputstream.readFully(is);
                                                    datainputstream.close();
                                                    final FileOutputStream fileoutputstream = new FileOutputStream(file);
                                                    fileoutputstream.write(is);
                                                    fileoutputstream.close();
                                                }
                                            } catch (final Exception ignored) {

                                            }
                                        }
                                        gameFrame.setCursor(new Cursor(0));
                                        JOptionPane.showMessageDialog(null, mystages[i] + " has been successfully downloaded!", "Stage Maker", 1);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Unable to download stage.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                                    }
                                } catch (final Exception exception) {
                                    JOptionPane.showMessageDialog(null, "Unable to download stage.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                                }
                            }
                        }
                    } else {
                        rd.drawString("-    Error Loading this stage's info!    -", 550 - ftm.stringWidth("-    Error Loading this stage's info!    -") / 2, 156 + i * 20);
                    }
                    if (ovbutton("X", 765, 156 + i * 20) && JOptionPane.showConfirmDialog(null, "Remove " + mystages[i] + " from your account?", "Stage Maker", 0) == 0) {
                        gameFrame.setCursor(new Cursor(3));
                        int i160 = -1;
                        try {
                            final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                            final BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                            printwriter.println("19|" + tnick.getText() + "|" + tpass.getText() + "|" + mystages[i] + "|");
                            final String string = bufferedreader.readLine();
                            if (string != null) {
                                i160 = servervalue(string, 0);
                            }
                            socket.close();
                        } catch (final Exception exception) {
                            i160 = -1;
                        }
                        if (i160 == 0) {
                            logged = 1;
                        } else {
                            gameFrame.setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null, "Failed to remove " + mystages[i] + " from your account.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                        }
                    }
                }
            }
            if (logged == 2) {
                for (int i = 0; i < nms; i++) {
                    rd.setFont(FontConstants.arial_13);
                    ftm = rd.getFontMetrics();
                    rd.setColor(Color.white);
                    rd.fillRect(50, 150, 600, 150);
                    rd.setColor(Color.black);
                    rd.drawString("Loading " + mystages[i] + "\u2018s info...", 400 - ftm.stringWidth("Loading " + mystages[i] + "\u2018s info...") / 2, 220);
                    //repaint();
                    maker[i] = "Unkown";
                    pubt[i] = -1;
                    nad[i] = 0;
                    String string;
                    try {
                        String string161 = "http://multiplayer.needformadness.com/tracks/" + mystages[i] + ".txt?reqlo=" + (int) (ThreadLocalRandom.current().nextDouble() * 1000.0);
                        string161 = string161.replace(' ', '_');
                        final URL url = new URL(string161);
                        final BufferedReader datainputstream = new BufferedReader(new InputStreamReader(new DataInputStream(url.openStream())));
                        while ((string = datainputstream.readLine()) != null) {
                            string = "" + string.trim();
                            if (string.startsWith("details")) {
                                maker[i] = getSvalue("details", string, 0);
                                pubt[i] = Utility.getvalue("details", string, 1);
                                boolean bool = false;
                                while (!bool) {
                                    addeda[i][nad[i]] = getSvalue("details", string, 2 + nad[i]);
                                    if (addeda[i][nad[i]].equals("")) {
                                        bool = true;
                                    } else {
                                        nad[i]++;
                                    }
                                }
                            }
                        }
                    } catch (final Exception ignored) {

                    }
                }
                gameFrame.setCursor(new Cursor(0));
                logged = 3;
            }
            if (logged == -1) {
                rd.setFont(FontConstants.arial_13);
                ftm = rd.getFontMetrics();
                rd.setColor(Color.black);
                rd.drawString("Account empty, no published stages found.", 400 - ftm.stringWidth("Account empty, no published stages found.") / 2, 220);
                rd.drawString("Click \u2018Publish\u2019 above to begin.", 400 - ftm.stringWidth("Click \u2018Publish\u2019 above to begin.") / 2, 280);
                rd.setFont(new Font("Arial", 0, 12));
                ftm = rd.getFontMetrics();
                rd.drawString("The maximum number of stages your account can have at once is 20 stages.", 400 - ftm.stringWidth("The maximum number of stages your account can have at once is 20 stages.") / 2, 320);
            }
            if (logged == 1) {
                rd.setColor(Color.white);
                rd.fillRect(11, 141, 779, 401);
                rd.setFont(FontConstants.arial_13);
                ftm = rd.getFontMetrics();
                rd.setColor(Color.black);
                rd.drawString("Loading your account's stage list...", 400 - ftm.stringWidth("Loading your account's stage list...") / 2, 220);
                //repaint();
                nms = 0;
                String string;
                try {
                    final URL url = new URL("http://multiplayer.needformadness.com/tracks/lists/" + tnick.getText() + ".txt?reqlo=" + (int) (ThreadLocalRandom.current().nextDouble() * 1000.0));
                    final BufferedReader datainputstream = new BufferedReader(new InputStreamReader(new DataInputStream(url.openStream())));
                    while ((string = datainputstream.readLine()) != null) {
                        string = "" + string.trim();
                        if (string.startsWith("mystages")) {
                            boolean bool = true;
                            while (bool && nms < 20) {
                                mystages[nms] = getSvalue("mystages", string, nms);
                                if (mystages[nms].equals("")) {
                                    bool = false;
                                } else {
                                    nms++;
                                }
                            }
                        }
                    }
                    if (nms > 0) {
                        logged = 2;
                    } else {
                        gameFrame.setCursor(new Cursor(0));
                        logged = -1;
                    }
                    datainputstream.close();
                } catch (final Exception exception) {
                    final String string162 = "" + exception;
                    if (string162.contains("FileNotFound")) {
                        gameFrame.setCursor(new Cursor(0));
                        logged = -1;
                    } else {
                        logged = 0;
                        JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Stage Maker", 1);
                    }
                }
            }
            if (logged == 0) {
                rd.setFont(new Font("Arial", 0, 12));
                ftm = rd.getFontMetrics();
                rd.drawString("The maximum number of stages your account can have at once is 20 stages.", 400 - ftm.stringWidth("The maximum number of stages your account can have at once is 20 stages.") / 2, 180);
                rd.setFont(FontConstants.arial_13);
                ftm = rd.getFontMetrics();
                rd.drawString("Login to Retrieve your Account Stages", 400 - ftm.stringWidth("Login to Retrieve your Account Stages") / 2, 220);
                rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 266);
                if (!tnick.isShowing()) {
                    tnick.setVisible(true);
                }
                movefield(tnick, 376, 250, 129, 23);
                rd.drawString("Password:", 376 - ftm.stringWidth("Password:") - 14, 296);
                if (!tpass.isShowing()) {
                    tpass.setVisible(true);
                }
                movefield(tpass, 376, 280, 129, 23);
                if (button("       Login       ", 400, 340, 0, true)) {
                    gameFrame.setCursor(new Cursor(3));
                    int i = -1;
                    try {
                        final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                        final BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                        printwriter.println("1|" + tnick.getText().toLowerCase() + "|" + tpass.getText() + "|");
                        final String string = bufferedreader.readLine();
                        if (string != null) {
                            i = servervalue(string, 0);
                        }
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
                        gameFrame.setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Stage Maker", 0);
                    }
                    if (i == -167) {
                        gameFrame.setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Sorry.  Trial accounts are not allowed to publish cars & stages, please register a full account!", "Stage Maker", 0);
                    }
                    if (i == -1) {
                        gameFrame.setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Stage Maker", 1);
                    }
                }
                rd.setFont(FontConstants.arial_13);
                ftm = rd.getFontMetrics();
                rd.drawString("Not registered yet?", 400 - ftm.stringWidth("Not registered yet?") / 2, 450);
                //if (button("   Register Now!   ", 400, 480, 0, true))
                //    Madness.openurl("http://multiplayer.needformadness.com/register.html");
                rd.setFont(new Font("Arial", 0, 12));
                ftm = rd.getFontMetrics();
                rd.drawString("Register to publish your stages to the multiplayer game!", 400 - ftm.stringWidth("Register to publish your stages to the multiplayer game!") / 2, 505);
            }
        }
        if (tabed != tab) {
            if (tabed == -2) {
                tabed = -1;
            } else {
                tabed = tab;
            }
        }
        rd.setColor(Color.black);
        rd.fillRect(0, 0, 800, 25);
        /*if (!onbtgame) {
            rd.drawImage(btgame[0], 620, 0, null);
        } else {
            rd.drawImage(btgame[1], 620, 0, null);
        }*/
        rd.setFont(FontConstants.arial_13);
        ftm = rd.getFontMetrics();
        final String[] strings = {
                "Stage", "Build", "View & Edit", "Publish"
        };
        final int[] is = {
                0, 0, 100, 90
        };
        final int[] is163 = {
                0, 25, 25, 0
        };
        int i = 4;
        if (stagename.equals("") || sfase != 0) {
            tab = 0;
            i = 1;
        }
        for (int i164 = 0; i164 < i; i164++) {
            rd.setColor(ColorConstants.c_170_170_170);
            if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25) {
                rd.setColor(ColorConstants.c_200_200_200);
            }
            if (tab == i164) {
                rd.setColor(Color.white);
            }
            rd.fillPolygon(is, is163, 4);
            rd.setColor(Color.black);
            rd.drawString(strings[i164], i164 * 100 + 45 - ftm.stringWidth(strings[i164]) / 2, 17);
            if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25 && mousePressed == -1) {
                tab = i164;
            }
            for (int i165 = 0; i165 < 4; i165++) {
                is[i165] += 100;
            }
        }
        if (mousePressed == -1) {
            mousePressed = 0;
        }
        /**
         * do this only on build screen
         */
        if (toggle_drawmouse && tab == 1) {
            rd.drawString("mouse x: " + ((xm - 505) * (Math.abs(sy) / nfm.open.Medium.focusPoint) + sx), 252, 75);
            rd.drawString("mouse z: " + ((290 - ym) * (Math.abs(sy) / nfm.open.Medium.focusPoint) + sz), 252, 90);
            rd.drawString("mouse y: " + (nfm.open.Medium.ground - bco[selectedPart].grat), 252, 105);
            rd.drawString("rotation: " + (rot + adrot), 252, 120);
            rd.drawString("attach points: " + Arrays.toString(atp[selectedPart]), 252, 135);
        }
        drawms();
        //repaint();
        /*if (!exwist) {
            try {
                //Thread.sleep(40L);
            } catch (final InterruptedException interruptedexception) {

            }
        }*/
        lastfield = 0;
        aMouseState = 0;
    }

    private static void searchButton() {
        final String searchdata = inputbox(new FocusListener() {

            @Override
            public void focusLost(final FocusEvent e) {
            }

            @Override
            public void focusGained(final FocusEvent e) {
                if (!scrfield.isShowing() && hasLostFocus) {
                    scrfield.setVisible(true);
                }
            }
        }, "searchbox", "Search here...", 6, 390, 150, 23);

        checkSearchFieldFocus();

        if (searchdata != null) {
            if (searchdata.equals("") || searchdata.equals("Search here...")) { // nothing was searched, so hide search box
                if (scrfield.isShowing()) {
                    scrfield.setVisible(false);
                    hasLostFocus = false;
                }
            } else {

                if (!searchdata.equals(prevsearchdata)) {
                    prevsearchdata = searchdata;
                    results = new Stack<>(); // prevent anonymous class caching

                    int ctype = 0;
                    for (final Map<String, String> map : menus.menus.values()) {
                        int cpart = 0;
                        for (final Entry<String, String> entry : map.entrySet()) {
                            if (entry.getKey().toLowerCase().contains(searchdata.toLowerCase()) && !entry.getKey().startsWith("Placeholder item")) {

                                results.push(new SearchResult(entry.getKey(), partNumbers.get(entry.getValue()), ctype, cpart));

                            }
                            cpart++;
                        }
                        ctype++;
                    }

                    if (results.size() == 0) { // no results, so hide search box
                        if (scrfield.isShowing()) {
                            scrfield.setVisible(false);
                            hasLostFocus = false;
                        }
                    } else {
                        list(e -> { // select whichever part was pciked (not every frame!! that's annoyng!!)

                            final int i = list.getSelectedIndex();
                            if (i >= results.size() || i < 0) {
                                return;
                            }
                            final SearchResult obj = results.get(i); // relyign on the event's data just causes issues...

                            selectedPart = obj.selectedPart;

                            final int ctype1 = obj.selectedPartType;
                            if (ctype1 != ptyp.getSelectedIndex()) { // select whichever map this is
                                selectedPartType = ctype1;
                                ptyp.select(selectedPartType);
                                loadPartMenu();
                            }

                            final int cpart = obj.selectedMenuPart;
                            selectedMenuPart = cpart;
                            part.select(cpart);
                        }, results, 6, 292, 200, 100);
                    }
                }
            }

        }
    }

    private static void checkSearchFieldFocus() {
        if (aMouseState == 1 && scrfield.isShowing() && (xm < scrfield.getX() || ym < scrfield.getY() || xm > scrfield.getX() + scrfield.getWidth() || ym > scrfield.getY() + scrfield.getHeight())) {
            System.out.println("UNFOCUS");
            hasLostFocus = true;
            scrfield.setVisible(false);
            stageMaker.requestFocusInWindow();
        }
    }

    private static class SearchResult {
        final String niceName;
        final int selectedPart;
        final int selectedPartType;
        final int selectedMenuPart;

        SearchResult(final String niceName, final int selectedPart, final int selectedPartType, final int selectedMenuPart) {
            this.niceName = niceName;
            this.selectedPart = selectedPart;
            this.selectedPartType = selectedPartType;
            this.selectedMenuPart = selectedMenuPart;
        }

        @Override
        public String toString() {
            return niceName;
        }
    }

    private static final JComponent[] fields = new JComponent[5];
    private static int lastfield = 0;

    private static String prevsearchdata = "Search here...";

    private static String inputbox(final FocusListener fl, final String name, final String defaultmessage, final int x, final int y, final int w, final int h) {
        /*boolean makingnew = false;
        if (fields[lastfield] == null || !name.equals(fields[lastfield].getName())) {
            makingnew = true;
        }
        String s = inputbox(name, defaultmessage, x, y, w, h);
        if (makingnew) {
            fields[lastfield].addFocusListener(fl);
        }*/

        if (fields[lastfield] == null || !name.equals(fields[lastfield].getName())) {
            fields[lastfield] = new JTextField(defaultmessage);
            fields[lastfield].setName(name);
            fields[lastfield].addFocusListener(fl);
            movefield(fields[lastfield], x, y, w, h);
            stageMaker.add(fields[lastfield]);
        }
        return inputbox(name, defaultmessage, x, y, w, h);
    }

    private static String inputbox(final String name, final String defaultmessage, final int x, final int y, final int w, final int h) {
        if (fields[lastfield] == null || !name.equals(fields[lastfield].getName())) {
            fields[lastfield] = new JTextField(defaultmessage);
            fields[lastfield].setName(name);
            movefield(fields[lastfield], x, y, w, h);
            stageMaker.add(fields[lastfield]);
        }
        if (part.open && y < part.getScreenSize()) {
            if (fields[lastfield].isShowing()) {
                System.err.println("part.getScreenSize() " + part.getScreenSize());
                fields[lastfield].setVisible(false);
                stageMaker.requestFocusInWindow();
            }
        } else if (!fields[lastfield].isShowing()) {
            fields[lastfield].setVisible(true);
        }

        final String inp = ((JTextField) fields[lastfield]).getText();

        lastfield++;

        return !inp.equals(defaultmessage) ? inp : null;
    }

    private static final JScrollPane scrfield = new JScrollPane();
    private static JList<SearchResult> list;

    /**
     * Makes a list of SearchResult but can easily be adapted to suit your generic needs
     */
    private static void list(final ListSelectionListener el, final Vector<SearchResult> contents, final int x, final int y, final int w, final int h) {
        if (scrfield == null || list == null) {

            list = new JList<>(contents);

            list.addListSelectionListener(el);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            scrfield.setViewportView(list);

            movefield(scrfield, x, y, w, h);
            stageMaker.add(scrfield);

        }

        final ListModel<SearchResult> lm = list.getModel();

        if (contents.size() != 0 && (lm.getSize() != contents.size() || !Utility.listModelEquals(lm, contents))) {
            list.setModel(new AbstractListModel<SearchResult>() {
                /***/
                private static final long serialVersionUID = -4480839407585777794L;

                @Override
                public int getSize() {
                    return contents.size();
                }

                @Override
                public SearchResult getElementAt(final int i) {
                    return contents.elementAt(i);
                }
            });
        }

        if (part.open && y < part.getScreenSize()) {
            if (scrfield.isShowing()) {
                System.err.println("part.getScreenSize() " + part.getScreenSize());
                hasLostFocus = false;
                scrfield.setVisible(false);
                stageMaker.requestFocusInWindow();
            }
        } else if (!scrfield.isShowing()) {
            scrfield.setVisible(true);
        }

    }

    private static void updateSelectedPart() {
        System.out.println("ptyp.getSelectedItem() " + ptyp.getSelectedItem());
        System.out.println("part.getSelectedItem() " + part.getSelectedItem());
        System.out.println("menu selected part  " + menus.menus.get(ptyp.getSelectedItem() //
        ).get(part.getSelectedItem()) //
        );
        selectedPart = partNumbers.get( //
                menus.menus.get(ptyp.getSelectedItem() //
                ).get(part.getSelectedItem()) //
        ); //

        isPartFixhoops = ptyp.getSelectedItem().equals("Fix Hoop");

        updateGroundPile();

        part.setVisible(!isPartFixhoops && !isPartBumps);
    }

    private static void updateGroundPile() {
        if (ptyp.getSelectedItem().equals("Ground Pile")) {
            isPartBumps = true;
            if (!pgen) {
                int i = (int) (10000.0 * ThreadLocalRandom.current().nextDouble());
                if (fgen != 0) {
                    i = fgen;
                    fgen = 0;
                }
                bco[BUMP_SET_ID] = new SMContO(i, (int) (pwd * SMContO.BUMP_RADIUS_MULT), (int) (phd * SMContO.BUMP_HEIGHT_MULT), 0, 0, 0);
                bco[BUMP_SET_ID].srz = i;
                bco[BUMP_SET_ID].srx = (int) (pwd * SMContO.BUMP_RADIUS_MULT);
                bco[BUMP_SET_ID].sry = (int) (phd * SMContO.BUMP_HEIGHT_MULT);
                pgen = true;
                seq = 3;
            }
            selectedPart = BUMP_SET_ID;
            rot = 0;
        } else {
            isPartBumps = false;
            if (pgen) {
                pgen = false;
                pwd = 2L + Math.round(ThreadLocalRandom.current().nextDouble() * 4.0);
                phd = 2L + Math.round(ThreadLocalRandom.current().nextDouble() * 4.0);
            }
        }
    }

    private static void loadPartMenu() {
        part.removeAll();

        for (final String s : menus.menus.get(ptyp.getSelectedItem()).keySet()) {
            part.add(rd, s);
        }

    }

    private static void drawSelection() {
        /*
         * it works!
         */
        //rd.setColor(Color.red);
        //rd.drawRect(dragOriginX, dragOriginY, mouseDragToX, mouseDragToY);

        final int[] aX = {
                dragOriginX - nfm.open.Medium.x, mouseDragToX - nfm.open.Medium.x
        };
        final int[] aZ = {
                dragOriginY - nfm.open.Medium.z, mouseDragToY - nfm.open.Medium.z
        };
        final int[] aY = {
                nfm.open.Medium.ground - nfm.open.Medium.y, nfm.open.Medium.ground - nfm.open.Medium.y,
                nfm.open.Medium.ground - nfm.open.Medium.y, nfm.open.Medium.ground - nfm.open.Medium.y
        };

        medium_rot(aX, aZ, nfm.open.Medium.cx, nfm.open.Medium.cz, nfm.open.Medium.xz, asin_m_xz, acos_m_xz, 2);
        medium_rot(aY, aZ, nfm.open.Medium.cy, nfm.open.Medium.cz, nfm.open.Medium.zy, asin_m_zy, acos_m_zy, 2);
        medium_rot(aX, aY, nfm.open.Medium.cx, nfm.open.Medium.cy, __m_xy, asin_m_xy, acos_m_xy, 2);
        final int[] x2d = new int[2];
        final int[] y2d = new int[2];

        x2d[0] = Utility.xs(aX[0], aZ[0]);
        y2d[0] = Utility.mediumYs(aY[0], aZ[0]);
        x2d[1] = Utility.xs(aX[1], aZ[1]);
        y2d[1] = Utility.mediumYs(aY[1], aZ[1]);

        rd.setColor(Color.green);
        if (x2d[1] - x2d[0] < 0 || y2d[1] - y2d[0] < 0) {
            rd.drawRect(x2d[1], y2d[1], (x2d[1] - x2d[0]) * -1, (y2d[1] - y2d[0]) * -1);
        } else {
            rd.drawRect(x2d[0], y2d[0], x2d[1] - x2d[0], y2d[1] - y2d[0]);
        }
    }

    private static void drawPlayerPos() {
        /*
        for (int ii = 0; ii < lastSector - 1; ii++) {
            for (int i = 0; i < lastPlayerPos[ii] - 1; i++) {
        
                final int[] aX = {
                        bestSectorX[ii][i] - Medium.x, bestSectorX[ii][i + 1] - Medium.x
                };
                final int[] aY = {
                        bestSectorX[ii][i] - Medium.y, bestSectorX[ii][i + 1] - Medium.y
                };
                final int[] aZ = {
                        bestSectorX[ii][i] - Medium.z, bestSectorX[ii][i + 1] - Medium.z
                };
        
                medium_rot(aX, aZ, Medium.cx, Medium.cz, Medium.xz, asin_m_xz, acos_m_xz, 2);
                medium_rot(aY, aZ, Medium.cy, Medium.cz, Medium.zy, asin_m_zy, acos_m_zy, 2);
                medium_rot(aX, aY, Medium.cx, Medium.cy, __m_xy, asin_m_xy, acos_m_xy, 2);
                final int[] x2d = new int[2];
                final int[] y2d = new int[2];
        
                x2d[0] = Utility.xs(aX[0], aZ[0]);
                y2d[0] = Utility.mediumYs(aY[0], aZ[0]);
                x2d[1] = Utility.xs(aX[1], aZ[1]);
                y2d[1] = Utility.mediumYs(aY[1], aZ[1]);
        
                rd.setColor(Color.green);
                rd.drawLine(x2d[0], y2d[0], x2d[1], y2d[1]);
        
                if (i == 0) {
                    rd.drawString("Sector " + (ii + 1) + " (" + (sectorTime[ii] / 60D) + " seconds)", x2d[0], y2d[0]);
                }
            }
        }*/

    }

    private static void getHighlightedPiece() {
        int i41 = 0;
        for (int i42 = 0; i42 < nob; i42++) {
            final int i43 = nfm.open.Medium.cx + (int) ((co[i42].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.cos(nfm.open.Medium.xz) - (co[i42].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.xz));
            final int i44 = nfm.open.Medium.cz + (int) ((co[i42].x - nfm.open.Medium.x - nfm.open.Medium.cx) * nfm.open.Medium.sin(nfm.open.Medium.xz) + (co[i42].z - nfm.open.Medium.z - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.xz));
            final int i45 = nfm.open.Medium.cy + (int) ((co[i42].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.cos(nfm.open.Medium.zy) - (i44 - nfm.open.Medium.cz) * nfm.open.Medium.sin(nfm.open.Medium.zy));
            final int i46 = nfm.open.Medium.cz + (int) ((co[i42].y - nfm.open.Medium.y - nfm.open.Medium.cy) * nfm.open.Medium.sin(nfm.open.Medium.zy) + (i44 - nfm.open.Medium.cz) * nfm.open.Medium.cos(nfm.open.Medium.zy));
            if (xm > Utility.xs(i43 - co[i42].maxR, i46) && xm < Utility.xs(i43 + co[i42].maxR, i46) && ym > Utility.ys(i45 - co[i42].maxR, i46) && ym < Utility.ys(i45 + co[i42].maxR, i46) && co[i42].partID != 37 && co[i42].partID != 38) {
                if (hi == -1) {
                    hi = i42;
                    i41 = py(xm, Utility.xs(i43, i46), ym, Utility.ys(i45, i46));
                } else if (py(xm, Utility.xs(i43, i46), ym, Utility.ys(i45, i46)) <= i41) {
                    hi = i42;
                    i41 = py(xm, Utility.xs(i43, i46), ym, Utility.ys(i45, i46));
                }
            }
        }
    }

    private static void undo() {
        if (numUndoActions > 1 && nob > 1) {
            numUndoActions--;

            if (!undoIsRemove[numUndoActions]) {//is not remove action
                for (int j = 0; j < nob; j++) { //xnob or nob?
                    if (undoContoID[numUndoActions] == co[j].partID && //set id
                            undoContoX[numUndoActions] == co[j].x && //x
                            undoContoY[numUndoActions] == co[j].y && //y
                            undoContoZ[numUndoActions] == co[j].z //z
                    ) {
                        co[j].partID = -1337;
                        sortstage();
                        break;
                    }
                }
            } else {//is remove action
                co[nob] = new SMContO(bco[undoContoID[numUndoActions]], undoContoX[numUndoActions], undoContoY[numUndoActions], undoContoZ[numUndoActions], undoContoXZ[numUndoActions]);
                co[nob].declaredXZ = undoContoXZ[numUndoActions];
                co[nob].partID = undoContoID[numUndoActions];
                nob++;
                // dunno why this is needed, it just is
                sortstage();
            }

            readstage(0);
        } else {
            JOptionPane.showMessageDialog(gameFrame, "Cannot remove last piece in stage/not enough actions left!");
        }
    }

    /**
     * Drawpartids.
     */
    private static void drawpartids() {
        if (toggle_drawpartids) {
            rd.setColor(Color.BLACK);
            for (int b = 0; b < nob; b++) {
                //bco[selectedPart].x = (xm - 505) * (Math.abs(sy) / Medium.focusPoint) + sx;
                //bco[selectedPart].z = (290 - ym) * (Math.abs(sy) / Medium.focusPoint) + sz;
                //
                int x = co[b].x - nfm.open.Medium.x - nfm.open.Medium.cx;// / 30;
                int y = co[b].y - nfm.open.Medium.y - nfm.open.Medium.cy;// / 30;
                int z = co[b].z - nfm.open.Medium.z - nfm.open.Medium.cz;// / 30;
                int[] a = rotSingle(x, z, nfm.open.Medium.cx, nfm.open.Medium.cz, nfm.open.Medium.xz, asin_m_xz, acos_m_xz);
                x = a[0];
                z = a[1];
                a = rotSingle(y, z, nfm.open.Medium.cy, nfm.open.Medium.cz, nfm.open.Medium.zy, asin_m_zy, acos_m_zy);
                y = a[0];
                z = a[1];
                a = rotSingle(x, y, nfm.open.Medium.cx, nfm.open.Medium.cy, __m_xy, asin_m_xy, acos_m_xy);
                x = a[0];
                y = a[1];
                final int x2d = Utility.xs(x, z);
                final int y2d = Utility.ys(y, z); //mediumys maybe

                rd.drawString("id: " + b, x2d, y2d);
            }
        }
    }

    /**
     * Savefile.
     */
    private static void savefile() {
        try {
            File file = new File("mystages/");
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File("mystages/" + stagename + ".txt");
            final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            bufferedwriter.write(tstage);
            bufferedwriter.write(bstage);
            bufferedwriter.close();
        } catch (final Exception exception) {
            JOptionPane.showMessageDialog(null, "Unable to save file! Error Deatials:\n" + exception, "Stage Maker", 1);
        }
        savesettings();
    }

    /**
     * Savesettings.
     */
    private static void savesettings() {
        if (!sstage.equals(stagename) || !suser.equals(tnick.getText())) {
            final String string = stagename + "\n" + tnick.getText() + "\n\n";
            sstage = stagename;
            suser = tnick.getText();
            try {
                File file = new File("mystages/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                file = new File("mystages/settings.data");
                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(string);
                bufferedwriter.close();
            } catch (final Exception ignored) {

            }
        }
    }

    public static String serverSvalue(final String string, final int i) {
        String string365 = "";
        try {
            int i366 = 0;
            int i367 = 0;
            int i368 = 0;
            String string369;
            String string370 = "";
            for (/**/; i366 < string.length() && i368 != 2; i366++) {
                string369 = "" + string.charAt(i366);
                if (string369.equals("|")) {
                    i367++;
                    if (i368 == 1 || i367 > i) {
                        i368 = 2;
                    }
                } else if (i367 == i) {
                    string370 = "" + string370 + string369;
                    i368 = 1;
                }
            }
            string365 = string370;
        } catch (final Exception ignored) {

        }
        return string365;
    }

    /**
     * Servervalue.
     *
     * @param string the string
     * @param i the i
     * @return the int
     */
    private static int servervalue(final String string, final int i) {
        int i359 = -1;
        try {
            int i360 = 0;
            int i361 = 0;
            int i362 = 0;
            String string363;
            String string364 = "";
            for (/**/; i360 < string.length() && i362 != 2; i360++) {
                string363 = "" + string.charAt(i360);
                if (string363.equals("|")) {
                    i361++;
                    if (i362 == 1 || i361 > i) {
                        i362 = 2;
                    }
                } else if (i361 == i) {
                    string364 = "" + string364 + string363;
                    i362 = 1;
                }
            }
            if (string364.equals("")) {
                string364 = "-1";
            }
            i359 = Integer.parseInt(string364);
        } catch (final Exception ignored) {

        }
        return i359;
    }

    /**
     * Sortop.
     */
    private static void sortop() {
        tstage = "snap(" + nfm.open.Medium.snap[0] + "," + nfm.open.Medium.snap[1] + "," + nfm.open.Medium.snap[2] + ")\r\nsky(" + csky[0] + "," + csky[1] + "," + csky[2] + ")\r\nfog(" + cfade[0] + "," + cfade[1] + "," + cfade[2] + ")\r\nclouds(" + cldd[0] + "," + cldd[1] + "," + cldd[2] + "," + cldd[3] + "," + cldd[4] + ")\r\nground(" + cgrnd[0] + "," + cgrnd[1] + "," + cgrnd[2] + ")\r\ntexture(" + texture[0] + "," + texture[1] + "," + texture[2] + "," + texture[3] + ")\r\nfadefrom(" + origfade + ")\r\ndensity(" + ((nfm.open.Medium.fogd + 1) / 2 - 1) + ")\r\nmountains(" + nfm.open.Medium.mgen + ")\r\nnlaps(" + nfm.open.CheckPoints.nlaps + ")\r\n";
        if (!trackname.equals("")) {

            tstage = tstage + "soundtrack(" + trackname + "," + trackvol + "," + tracksize + ")\r\n";
        }
        for (int i = 0; i < 3; i++) {
            snap[i] = (int) (nfm.open.Medium.snap[i] / 1.2F + 50.0F);
        }
        if (snap[0] + snap[1] + snap[2] <= 110) {

            tstage = tstage + "lightson()\r\n";
        }

        tstage = tstage + "\r\n";
    }

    /**
     * Sortstage.
     */
    static void sortstage() {
        final byte[] pTyps = new byte[nob * 2]; // )p, )pt, )pr etc
        final int[] cIds2 = new int[nob * 2]; // real pointers to conto ids
        for (int i = 0; i < nob; i++) {
            pTyps[i] = 0;
        }
        int i = 0;
        int t_nob = 0;
        cIds2[t_nob] = 0;
        t_nob++;
        boolean bool = false;
        int i244 = 0;
        while (!bool) {
            final int[] is245 = {
                    co[i].x + atp[co[i].partID][0], co[i].x + atp[co[i].partID][2]
            };
            final int[] is246 = {
                    co[i].z + atp[co[i].partID][1], co[i].z + atp[co[i].partID][3]
            };
            int i247 = co[i].declaredXZ;
            if (co[i].partID == 2) {
                i247 += 30;
            }
            if (co[i].partID == 3) {
                i247 -= 30;
            }
            if (co[i].partID == 15) {
                i247 -= 90;
            }
            if (co[i].partID == 20) {
                i247 -= 180;
            }
            if (co[i].partID == 26) {
                i247 -= 90;
            }
            rot(is245, is246, co[i].x, co[i].z, i247, 2);
            int i248 = -1;
            int i249 = -1;
            if (i244 != 0) {
                for (int i250 = 0; i250 < nob; i250++) {
                    if (co[i250].partID == -1337) {
                        continue;
                    }
                    boolean bool251 = false;
                    if (t_nob == 2 && i250 == 0) {
                        bool251 = true;
                    }
                    if (i != i250 && !bool251 && pTyps[i250] == 0 && (co[i250].partID <= 14 || co[i250].partID >= 33) && (co[i250].partID < 39 || co[i250].partID >= 46) && co[i250].partID < 52) {
                        int i252 = 0;
                        if (co[i250].partID != 2 && co[i250].partID != 3 && co[i250].partID != 4 && co[i250].partID != 7 && co[i250].partID != 9) {
                            if (i244 == 1 && co[i250].z > co[i].z && Math.abs(co[i250].x - co[i].x) < 1000 && (co[i250].declaredXZ == 180 || co[i250].declaredXZ == 0)) {
                                i252 = 1;
                            }
                            if (i244 == 2 && co[i250].z < co[i].z && Math.abs(co[i250].x - co[i].x) < 1000 && (co[i250].declaredXZ == 180 || co[i250].declaredXZ == 0)) {
                                i252 = 1;
                            }
                            if (i244 == 3 && co[i250].x > co[i].x && Math.abs(co[i250].z - co[i].z) < 1000 && (co[i250].declaredXZ == 90 || co[i250].declaredXZ == -90)) {
                                i252 = 1;
                            }
                            if (i244 == 4 && co[i250].x < co[i].x && Math.abs(co[i250].z - co[i].z) < 1000 && (co[i250].declaredXZ == 90 || co[i250].declaredXZ == -90)) {
                                i252 = 1;
                            }
                        } else {
                            i252 = 2;
                        }
                        if (i252 != 0) {
                            final int[] is253 = {
                                    co[i250].x + atp[co[i250].partID][0], co[i250].x + atp[co[i250].partID][2]
                            };
                            final int[] is254 = {
                                    co[i250].z + atp[co[i250].partID][1], co[i250].z + atp[co[i250].partID][3]
                            };
                            i247 = co[i250].declaredXZ;
                            if (co[i250].partID == 2) {
                                i247 += 30;
                            }
                            if (co[i250].partID == 3) {
                                i247 -= 30;
                            }
                            if (co[i250].partID == 15) {
                                i247 -= 90;
                            }
                            if (co[i250].partID == 20) {
                                i247 -= 180;
                            }
                            if (co[i250].partID == 26) {
                                i247 -= 90;
                            }
                            rot(is253, is254, co[i250].x, co[i250].z, i247, 2);
                            if (i250 != 0) {
                                final int i256 = pyn(is253[0], is245[0], is254[0], is246[0]);
                                if (i256 >= 0 && (i256 < 100 || i252 != 2) && (i256 < i248 || i248 == -1)) {
                                    i248 = i256;
                                    i249 = i250;
                                }
                            }
                            int i257 = pyn(is253[1], is245[0], is254[1], is246[0]);
                            if (i257 >= 0 && (i257 < 100 || i252 != 2) && (i257 < i248 || i248 == -1)) {
                                i248 = i257;
                                i249 = i250;
                            }
                            if (i != 0) {
                                if (i250 != 0) {
                                    i257 = pyn(is253[0], is245[1], is254[0], is246[1]);
                                    if (i257 >= 0 && (i257 < 100 || i252 != 2) && i257 < i248) {
                                        i248 = i257;
                                        i249 = i250;
                                    }
                                }
                                i257 = pyn(is253[1], is245[1], is254[1], is246[1]);
                                if (i257 >= 0 && (i257 < 100 || i252 != 2) && i257 < i248) {
                                    i248 = i257;
                                    i249 = i250;
                                }
                            }
                        }
                    }
                }
            }
            if (i249 == -1) {
                for (int i258 = 0; i258 < nob; i258++) {
                    if (co[i258].partID == -1337) {
                        continue;
                    }
                    boolean bool259 = false;
                    if (t_nob == 2 && i258 == 0) {
                        bool259 = true;
                    }
                    if (i != i258 && !bool259 && pTyps[i258] == 0 && (co[i258].partID <= 14 || co[i258].partID >= 33) && (co[i258].partID < 39 || co[i258].partID >= 46) && co[i258].partID < 52) {
                        final int[] is260 = {
                                co[i258].x + atp[co[i258].partID][0], co[i258].x + atp[co[i258].partID][2]
                        };
                        final int[] is261 = {
                                co[i258].z + atp[co[i258].partID][1], co[i258].z + atp[co[i258].partID][3]
                        };
                        i247 = co[i258].declaredXZ;
                        if (co[i258].partID == 2) {
                            i247 += 30;
                        }
                        if (co[i258].partID == 3) {
                            i247 -= 30;
                        }
                        if (co[i258].partID == 15) {
                            i247 -= 90;
                        }
                        if (co[i258].partID == 20) {
                            i247 -= 180;
                        }
                        if (co[i258].partID == 26) {
                            i247 -= 90;
                        }
                        rot(is260, is261, co[i258].x, co[i258].z, i247, 2);
                        if (i258 != 0) {
                            final int i263 = pyn(is260[0], is245[0], is261[0], is246[0]);
                            if (i263 >= 0 && (i263 < i248 || i248 == -1)) {
                                i248 = i263;
                                i249 = i258;
                            }
                        }
                        int i264 = pyn(is260[1], is245[0], is261[1], is246[0]);
                        if (i264 >= 0 && (i264 < i248 || i248 == -1)) {
                            i248 = i264;
                            i249 = i258;
                        }
                        if (i != 0) {
                            if (i258 != 0) {
                                i264 = pyn(is260[0], is245[1], is261[0], is246[1]);
                                if (i264 >= 0 && i264 < i248) {
                                    i248 = i264;
                                    i249 = i258;
                                }
                            }
                            i264 = pyn(is260[1], is245[1], is261[1], is246[1]);
                            if (i264 >= 0 && i264 < i248) {
                                i248 = i264;
                                i249 = i258;
                            }
                        }
                    }
                }
            }
            if (i249 != -1) {
                i244 = 0;
                if (co[i249].partID != 2 && co[i249].partID != 3 && co[i249].partID != 4 && co[i249].partID != 7 && co[i249].partID != 9) {
                    if ((co[i249].declaredXZ == 180 || co[i249].declaredXZ == 0) && co[i249].z > co[i].z) {
                        i244 = 1;
                    }
                    if ((co[i249].declaredXZ == 180 || co[i249].declaredXZ == 0) && co[i249].z < co[i].z) {
                        i244 = 2;
                    }
                    if ((co[i249].declaredXZ == 90 || co[i249].declaredXZ == -90) && co[i249].x > co[i].x) {
                        i244 = 3;
                    }
                    if ((co[i249].declaredXZ == 90 || co[i249].declaredXZ == -90) && co[i249].x < co[i].x) {
                        i244 = 4;
                    }
                }
                if (co[i249].partID == 4 || co[i249].partID == 7 || co[i249].partID == 9) {
                    pTyps[i249] = 2;
                } else {
                    pTyps[i249] = 1;
                }
                if (co[i249].partID >= 46 && co[i249].partID <= 51) {
                    pTyps[i249] = 6;
                }
                i = i249;
                if (i249 == 0) {
                    pTyps[0] = 1;
                    bool = true;
                } else {
                    cIds2[t_nob] = i249;
                    t_nob++;
                }
            } else {
                pTyps[0] = 1;
                bool = true;
            }
        }
        for (int i265 = 0; i265 < nob; i265++) {
            if (pTyps[i265] == 0 && (co[i265].partID <= 14 || co[i265].partID >= 33) && (co[i265].partID < 39 || co[i265].partID >= 46) && co[i265].partID < 52) {
                cIds2[t_nob] = i265;
                t_nob++;
            }
        }
        for (int i266 = 0; i266 < t_nob; i266++) {
            if (co[cIds2[i266]].partID >= 46 && co[cIds2[i266]].partID <= 51) {
                for (int i267 = i266 + 1; i267 < t_nob; i267++) {
                    final int i268 = pyn(co[cIds2[i266]].x, co[cIds2[i267]].x, co[cIds2[i266]].z, co[cIds2[i267]].z);
                    if (i268 >= 0 && (co[cIds2[i267]].partID < 46 || co[cIds2[i266]].partID > 51) && i268 < (co[cIds2[i266]].maxR + co[cIds2[i267]].maxR) / 100 * ((co[cIds2[i266]].maxR + co[cIds2[i267]].maxR) / 100)) {
                        final int i269 = cIds2[i267];
                        System.arraycopy(cIds2, i266, cIds2, i266 + 1, i267 - i266);
                        cIds2[i266] = i269;
                        pTyps[cIds2[i266]] = 0;
                        i266++;
                    }
                }
            }
        }
        int i271 = 1;
        for (int i272 = 0; i272 < nfm.open.CheckPoints.nsp; i272++) {
            for (int i273 = 0; i273 < nob; i273++) {
                if (co[i273].wh == i272 + 1 && (co[i273].partID == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, co[i273].partID) || co[i273].partID == OFFROAD_CHECKPOINT_SET_ID || co[i273].partID == FLYING_CHECKPOINT_SET_ID)) {
                    int i274 = -1;
                    int i275 = -1;
                    for (int i276 = i271; i276 < t_nob; i276++) {
                        if (co[cIds2[i276]].partID != ONROAD_CHECKPOINT_SET_ID && !Utility.arrayContains(CHECKPOINT_IDS, co[cIds2[i276]].partID) && co[cIds2[i276]].partID != OFFROAD_CHECKPOINT_SET_ID && co[cIds2[i276]].partID != FLYING_CHECKPOINT_SET_ID) {
                            final int i277 = pyn(co[i273].x, co[cIds2[i276]].x, co[i273].z, co[cIds2[i276]].z);
                            if (i277 >= 0 && (i277 < i274 || i274 == -1)) {
                                i274 = i277;
                                i275 = i276;
                            }
                        }
                    }
                    if (i275 != -1) {
                        pTyps[cIds2[i275]] = 0;
                        System.arraycopy(cIds2, i275, cIds2, i275 + 1, t_nob - i275);
                        cIds2[i275 + 1] = i273;
                        i271 = i275 + 1;
                        t_nob++;
                    } else {
                        cIds2[t_nob] = i273;
                        i271 = t_nob;
                        t_nob++;
                    }
                }
            }
        }
        for (int i279 = 0; i279 < nob; i279++) {
            if (co[i279].wh == 0 && (co[i279].partID == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, co[i279].partID) || co[i279].partID == OFFROAD_CHECKPOINT_SET_ID || co[i279].partID == FLYING_CHECKPOINT_SET_ID)) {
                int i280 = -1;
                int i281 = -1;
                for (int i282 = i271; i282 < t_nob; i282++) {
                    if (co[cIds2[i282]].partID != ONROAD_CHECKPOINT_SET_ID && !Utility.arrayContains(CHECKPOINT_IDS, co[cIds2[i282]].partID) && co[cIds2[i282]].partID != OFFROAD_CHECKPOINT_SET_ID && co[cIds2[i282]].partID != FLYING_CHECKPOINT_SET_ID) {
                        final int i283 = pyn(co[i279].x, co[cIds2[i282]].x, co[i279].z, co[cIds2[i282]].z);
                        if (i283 >= 0 && (i283 < i280 || i280 == -1)) {
                            i280 = i283;
                            i281 = i282;
                        }
                    }
                }
                if (i281 != -1) {
                    pTyps[cIds2[i281]] = 0;
                    System.arraycopy(cIds2, i281, cIds2, i281 + 1, t_nob - i281);
                    cIds2[i281 + 1] = i279;
                    t_nob++;
                } else {
                    cIds2[t_nob] = i279;
                    t_nob++;
                }
            }
        }
        for (int i285 = 0; i285 < nob; i285++) {
            if (co[i285].partID == FIXHOOP_SET_ID) {
                int i286 = -1;
                int i287 = -1;
                for (int i288 = 0; i288 < t_nob; i288++) {
                    final int i289 = pyn(co[i285].x, co[cIds2[i288]].x, co[i285].z, co[cIds2[i288]].z);
                    if (i289 >= 0 && (i289 < i286 || i286 == -1)) {
                        i286 = i289;
                        i287 = i288;
                    }
                }
                if (i287 != -1) {
                    System.arraycopy(cIds2, i287, cIds2, i287 + 1, t_nob - i287);
                    cIds2[i287] = i285;
                    t_nob++;
                } else {
                    cIds2[t_nob] = i285;
                    t_nob++;
                }
            }
        }
        for (int i291 = 0; i291 < nob; i291++) {
            if (co[i291].partID == 15 || co[i291].partID == 27 || co[i291].partID == 28 || co[i291].partID == 41 || co[i291].partID == 44 || co[i291].partID == 52) {
                int i292 = -1;
                for (int i293 = 0; i293 < t_nob; i293++) {
                    if ((co[cIds2[i293]].partID <= 14 || co[cIds2[i293]].partID >= 33) && co[cIds2[i293]].partID < 39) {
                        final int i294 = pyn(co[i291].x, co[cIds2[i293]].x, co[i291].z, co[cIds2[i293]].z);
                        if (i294 >= 0 && i294 < (co[i291].maxR + co[cIds2[i293]].maxR) / 100 * ((co[i291].maxR + co[cIds2[i293]].maxR) / 100)) {
                            i292 = i293;
                        }
                    }
                }
                if (i292 != -1) {
                    System.arraycopy(cIds2, i292, cIds2, i292 + 1, t_nob - i292);
                    cIds2[i292 + 1] = i291;
                    t_nob++;
                } else {
                    cIds2[t_nob] = i291;
                    t_nob++;
                }
            }
        }
        for (int i296 = 0; i296 < nob; i296++) {
            if (co[i296].partID >= 16 && co[i296].partID <= 25 || co[i296].partID == 40 || co[i296].partID == 42 || co[i296].partID == 43 || co[i296].partID == 45) {
                int i297 = -1;
                for (int i298 = 0; i298 < t_nob; i298++) {
                    if ((co[cIds2[i298]].partID <= 14 || co[cIds2[i298]].partID >= 33) && co[cIds2[i298]].partID < 39) {
                        final int i299 = pyn(co[i296].x, co[cIds2[i298]].x, co[i296].z, co[cIds2[i298]].z);
                        if (i299 >= 0 && i299 < (co[i296].maxR + co[cIds2[i298]].maxR) / 100 * ((co[i296].maxR + co[cIds2[i298]].maxR) / 100)) {
                            if (pTyps[cIds2[i298]] != 0) {
                                pTyps[cIds2[i298]] = 0;
                                if (co[i296].partID != 20) {
                                    pTyps[i296] = 3;
                                } else {
                                    pTyps[i296] = 5;
                                }
                            }
                            i297 = i298;
                        }
                    }
                }
                /*if (i297 != -1) {
                
                }*/
                if (i297 != -1) {
                    System.arraycopy(cIds2, i297, cIds2, i297 + 1, t_nob - i297);
                    cIds2[i297 + 1] = i296;
                    t_nob++;
                } else {
                    cIds2[t_nob] = i296;
                    t_nob++;
                }
            }
        }
        for (int i301 = 0; i301 < nob; i301++) {
            if (co[i301].partID == 26/* || co[i301].partID == 39*/) {
                boolean bool302 = false;
                if (ThreadLocalRandom.current().nextDouble() > ThreadLocalRandom.current().nextDouble()) {
                    bool302 = true;
                    if (co[i301].partID == 39) {
                        if (ThreadLocalRandom.current().nextDouble() > ThreadLocalRandom.current().nextDouble()) {
                            bool302 = false;
                        } else if (ThreadLocalRandom.current().nextDouble() > ThreadLocalRandom.current().nextDouble()) {
                            bool302 = false;
                        }
                    }
                }
                int i303 = -1;
                for (int i304 = 0; i304 < t_nob; i304++) {
                    if ((co[cIds2[i304]].partID <= 14 || co[cIds2[i304]].partID >= 33) && co[cIds2[i304]].partID < 39) {
                        final int i305 = pyn(co[i301].x, co[cIds2[i304]].x, co[i301].z, co[cIds2[i304]].z);
                        if (i305 >= 0 && i305 < (co[i301].maxR + co[cIds2[i304]].maxR) / 100 * ((co[i301].maxR + co[cIds2[i304]].maxR) / 100)) {
                            boolean bool306 = false;
                            if (co[i301].partID == 26) {
                                if (co[i301].declaredXZ == 90 && co[cIds2[i304]].x > co[i301].x) {
                                    bool306 = true;
                                }
                                if (co[i301].declaredXZ == -90 && co[cIds2[i304]].x < co[i301].x) {
                                    bool306 = true;
                                }
                                if (co[i301].declaredXZ == 0 && co[cIds2[i304]].z < co[i301].z) {
                                    bool306 = true;
                                }
                                if (co[i301].declaredXZ == 180 && co[cIds2[i304]].z > co[i301].z) {
                                    bool306 = true;
                                }
                            }
                            if (co[i301].partID == 39) {
                                if (co[i301].declaredXZ == 90 && co[cIds2[i304]].z > co[i301].z) {
                                    bool306 = true;
                                }
                                if (co[i301].declaredXZ == -90 && co[cIds2[i304]].z < co[i301].z) {
                                    bool306 = true;
                                }
                                if (co[i301].declaredXZ == 0 && co[cIds2[i304]].x > co[i301].x) {
                                    bool306 = true;
                                }
                                if (co[i301].declaredXZ == 180 && co[cIds2[i304]].x < co[i301].x) {
                                    bool306 = true;
                                }
                            }
                            if (bool306) {
                                if (pTyps[cIds2[i304]] == 1 && bool302) {
                                    pTyps[cIds2[i304]] = 0;
                                    pTyps[i301] = 4;
                                }
                                i303 = i304;
                            }
                        }
                    }
                }
                if (i303 != -1) {
                    System.arraycopy(cIds2, i303, cIds2, i303 + 1, t_nob - i303);
                    cIds2[i303 + 1] = i301;
                    t_nob++;
                } else {
                    cIds2[t_nob] = i301;
                    t_nob++;
                }
            }
        }
        for (int i308 = 0; i308 < nob; i308++) {
            if (co[i308].partID >= 54 && co[i308].partID <= maxpart && !Utility.arrayContains(CHECKPOINT_IDS, co[i308].partID) || co[i308].partID == BUMP_SET_ID) {
                cIds2[t_nob] = i308;
                t_nob++;
            }
        }

        // fix the dupe bug (remove dupe entries, VERY DIRTY HACK)
        for (int j = 0; j < nob; j++) {
            for (int k = 0; k < nob; k++) {
                if (j != k && cIds2[k] != -1337 && cIds2[j] != -1337 && co[cIds2[j]].dupeOf(co[cIds2[k]])) {
                    cIds2[k] = -1337;
                    //contoIds2 = Utility.removeElement(contoIds2, contoIds2[k]);
                    //i243--;
                }

            }
        }

        final int[] cIds3 = new int[t_nob]; // pointer to conto ids after manual sort

        // fill array with -1
        for (int i1 = 0; i1 < t_nob; i1++) { // SLOW (i guess, pls fix somehow thx)
            cIds3[i1] = -1;
        }

        // first, add the manual sort ones
        for (int i1 = 0; i1 < t_nob; i1++) {
            if (cIds2[i1] == -1337 || co[cIds2[i1]].partID == -1337) {
                continue;
            }

            if (co[cIds2[i1]].declaredPositionInArray != -1) { // OH GOD IS THIS RIGHT?
                cIds3[co[cIds2[i1]].declaredPositionInArray] = cIds2[i1];
            }
        }

        // then, fill the empty spots with the rest of the sets
        for (int i1 = 0, avalidint = 0; i1 < t_nob /*potentially array should be +1*/; i1++/*, avalidint++*/) { // now, add the rest
            if (cIds2[i1] == -1337 || co[cIds2[i1]].partID == -1337 || co[cIds2[i1]].declaredPositionInArray != -1) {
                continue;
            }

            while (cIds3[avalidint] != -1) {
                avalidint++;
            }

            cIds3[avalidint] = cIds2[i1];
        }

        /*
        old algorithm:
        
        for (int i1 = 0; i1 < t_nob; i1++) { // first, add the manual sort ones
            if (cIds2[i1] == -1337 || co[cIds2[i1]].partID == -1337)
                continue;
        
            if (co[cIds2[i1]].declaredPositionInArray != -1) { // OH GOD IS THIS RIGHT?
                cIds3[co[cIds2[i1]].declaredPositionInArray] = cIds2[i1];
            }
        
            lastvalidint++;
        }
        for (int i1 = 0; i1 < t_nob; i1++) { // now, add the rest
            if (cIds2[i1] == -1337 || co[cIds2[i1]].partID == -1337 || co[cIds2[i1]].declaredPositionInArray != -1)
                continue;
        
            cIds3[lastvalidint] = cIds2[i1];
            lastvalidint++;
        }
        */

        int i309 = 0;
        int i310 = 0;
        int i311 = 0;
        int i312 = 0;
        final StringBuilder stageb = new StringBuilder(bstage.length());
        bstage = "";
        for (int i1 = 0; i1 < t_nob; i1++) {

            /*if (cIds3[i1] == -1) { //ignore entries marked as nonexistant
                continue;
            } else *//*if (co[cIds3[i1]].partID == BASE1) {
                     String isSorted = getLineSuffix(co[cIds3[i1]]);
                     stageb.append("base1(").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].y).append(",").append(+co[cIds3[i1]].z).append(")").append(isSorted).append("\r\n");
                     
                     //placeSET(contoIds1, contoIds2, i313);
                     } else if (co[cIds3[i1]].partID == BASE2) {
                     String isSorted = getLineSuffix(co[cIds3[i1]]);
                     stageb.append("base2(").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].y).append(",").append(+co[cIds3[i1]].z).append(")").append(isSorted).append("\r\n");
                     
                     //placeSET(contoIds1, contoIds2, i313);
                     } else if (co[cIds3[i1]].partID == PEDESTAL_FLAG1) {
                     String isSorted = getLineSuffix(co[cIds3[i1]]);
                     stageb.append("ped_flag1(").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].y).append(",").append(+co[cIds3[i1]].z).append(")").append(isSorted).append("\r\n");
                     } else if (co[cIds3[i1]].partID == PEDESTAL_FLAG2) {
                     String isSorted = getLineSuffix(co[cIds3[i1]]);
                     stageb.append("ped_flag2(").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].y).append(",").append(+co[cIds3[i1]].z).append(")").append(isSorted).append("\r\n");
                     } else if (co[cIds3[i1]].partID == NODE_SET_ID) {
                     if (false) {
                     System.out.println("placing node");
                     }
                     if (false) {
                     System.out.println("roof2: " + co[cIds3[i1]].declaredXZ);
                     }
                     //if (!floats) {
                     //    stageb.append("node(" + co[is242[i313]].x + "," + co[is242[i313]].y + "," +  + co[is242[i313]].z + ")" + "\r\n";
                     //} else {
                     String isSorted = getLineSuffix(co[cIds3[i1]]);
                     
                     stageb.append("node(").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].y).append(",").append(+co[cIds3[i1]].z).append(")").append(isSorted).append("\r\n");
                     //}
                     } else */if (co[cIds3[i1]].partID == ONROAD_CHECKPOINT_SET_ID || Utility.arrayContains(CHECKPOINT_IDS, co[cIds3[i1]].partID) || co[cIds3[i1]].partID == OFFROAD_CHECKPOINT_SET_ID) {
                if (co[cIds3[i1]].declaredXZ == 180) {
                    co[cIds3[i1]].declaredXZ = 0;
                }
                final String string = getLineSuffix(co[cIds3[i1]]);

                if (floats) {
                    stageb.append("chk(").append(co[cIds3[i1]].partID + 10).append(",").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].z).append(",").append(co[cIds3[i1]].y).append(",").append(co[cIds3[i1]].declaredXZ).append(")").append(string).append("\r\n");
                } else {
                    stageb.append("chk(").append(co[cIds3[i1]].partID + 10).append(",").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].z).append(",").append(co[cIds3[i1]].declaredXZ).append(")").append(string).append("\r\n");
                }
            } else if (co[cIds3[i1]].partID == FLYING_CHECKPOINT_SET_ID) {
                if (co[cIds3[i1]].declaredXZ == 180) {
                    co[cIds3[i1]].declaredXZ = 0;
                }
                final String string = getLineSuffix(co[cIds3[i1]]);
                //   this.bstage = (this.bstage) + ("chk(")
                //      .append(co[is242[i313]].partID + 10) + (",") + (co[is242[i313]].x) + (",")
                //      .append(co[is242[i313]].z) + (",") + (co[is242[i313]].y) + (",") + (co[is242[i313]].declaredXZ)
                //      .append(")") + (string) + ("\r\n");
                if (floats) {
                    stageb.append("chk(").append(co[cIds3[i1]].partID + 10).append(",").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].z).append(",").append(co[cIds3[i1]].y).append(",").append(co[cIds3[i1]].declaredXZ).append(")").append(string).append("\r\n");
                } else {
                    stageb.append("chk(").append(co[cIds3[i1]].partID + 10).append(",").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].z).append(",").append(co[cIds3[i1]].declaredXZ).append(")").append(string).append("\r\n");
                }
            } else if (co[cIds3[i1]].partID == FIXHOOP_SET_ID) {

                stageb.append("fix(").append(co[cIds3[i1]].partID + 10).append(",").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].z).append(",").append(co[cIds3[i1]].y).append(",").append(co[cIds3[i1]].declaredXZ).append(")\r\n");
            } else if (co[cIds3[i1]].partID == BUMP_SET_ID) {

                stageb.append("pile(").append(co[cIds3[i1]].srz).append(",").append(co[cIds3[i1]].srx).append(",").append(co[cIds3[i1]].sry).append(",").append(co[cIds3[i1]].x).append(",").append(co[cIds3[i1]].z).append(")\r\n");
            } else {
                placeSET(pTyps, cIds3, i1, stageb);
            }
            if (co[cIds3[i1]].x + co[cIds3[i1]].maxR > i309) {
                i309 = co[cIds3[i1]].x + co[cIds3[i1]].maxR;
            }
            if (co[cIds3[i1]].x - co[cIds3[i1]].maxR < i311) {
                i311 = co[cIds3[i1]].x - co[cIds3[i1]].maxR;
            }
            if (co[cIds3[i1]].z + co[cIds3[i1]].maxR > i310) {
                i310 = co[cIds3[i1]].z + co[cIds3[i1]].maxR;
            }
            if (co[cIds3[i1]].z - co[cIds3[i1]].maxR < i312) {
                i312 = co[cIds3[i1]].z - co[cIds3[i1]].maxR;
            }
        }
        int i319 = i311;
        int i320 = i309;
        final int i321 = (int) ((i320 - i319) / 4800.0F) + 1;
        int i322 = (i321 * 4800 - (i320 - i319)) / 2;
        i319 -= i322;
        i320 += i322;
        final int i323 = i319 + 2400;
        int i324 = i312;
        int i325 = i310;
        final int i326 = (int) ((i325 - i324) / 4800.0F) + 1;
        i322 = (i326 * 4800 - (i325 - i324)) / 2;
        i324 -= i322;
        i325 += i322;
        final int i327 = i324 + 2400;
        stageb.append("\r\nmaxl(").append(i326).append(",").append(i319).append(",").append(i327).append(")\r\nmaxb(").append(i321).append(",").append(i324).append(",").append(i323).append(")\r\nmaxr(").append(i326).append(",").append(i320).append(",").append(i327).append(")\r\nmaxt(").append(i321).append(",").append(i325).append(",").append(i323).append(")\r\n");
        bstage = stageb.toString();
    }

    private static String getLineSuffix(final SMContO smContO) {
        String string;
        if (smContO.wh != 0) {
            if (smContO.declaredPositionInArray != -1) {
                string = "r,f=" + smContO.declaredPositionInArray;
            } else {
                string = "r";
            }
        } else {
            string = "f=" + smContO.declaredPositionInArray;
        }
        return string;
    }

    private static void placeSET(final byte[] contoIds1, final int[] contoIds2, final int i313, final StringBuilder stageb) {
        String string = "";
        if (contoIds1[contoIds2[i313]] == 1) {
            string = "p";
        } else if (contoIds1[contoIds2[i313]] == 2) {
            string = "pt";
        } else if (contoIds1[contoIds2[i313]] == 3) {
            string = "pr";
        } else if (contoIds1[contoIds2[i313]] == 4) {
            string = "ph";
        } else if (contoIds1[contoIds2[i313]] == 5) {
            string = "pl";
        } else if (contoIds1[contoIds2[i313]] == 6) {
            string = "pr";
        }

        if (contoIds1[contoIds2[i313]] == 0) {
            string = "f=" + co[contoIds2[i313]].declaredPositionInArray;
        } else {
            string += ",f=" + co[contoIds2[i313]].declaredPositionInArray;
        }

        //}
        if (!floats) {
            stageb.append("set(").append(co[contoIds2[i313]].partID + 10).append(",").append(co[contoIds2[i313]].x).append(",").append(co[contoIds2[i313]].z).append(",").append(co[contoIds2[i313]].declaredXZ).append(")").append(string).append("\r\n");
        } else {
            stageb.append("set(").append(co[contoIds2[i313]].partID + 10).append(",").append(co[contoIds2[i313]].x).append(",").append(co[contoIds2[i313]].z).append(",").append(co[contoIds2[i313]].y).append(",").append(co[contoIds2[i313]].declaredXZ).append(")").append(string).append("\r\n");
        }
    }

    /**
     * Rot single.
     *
     * @param poly1 the poly1
     * @param poly2 the poly2
     * @param center1 the center1
     * @param center2 the center2
     * @param angle the angle
     * @param sin_ang the sin_ang
     * @param cos_ang the cos_ang
     * @return the int[]
     */
    private static int[] rotSingle(int poly1, int poly2, final int center1, final int center2, final int angle, final float sin_ang, final float cos_ang) {
        if (angle != 0) {
            final int j1 = poly1;
            final int k1 = poly2;
            poly1 = center1 + (int) ((j1 - center1) * cos_ang - (k1 - center2) * sin_ang);
            poly2 = center2 + (int) ((j1 - center1) * sin_ang + (k1 - center2) * cos_ang);
        }
        return new int[] {
                poly1, poly2
        };
    }

    /**
     * Move mouse.
     *
     * @param p the p
     */
    private void moveMouse(final Point p) {
        final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final GraphicsDevice[] gs = ge.getScreenDevices();
        // Search the devices for the one that draws the specified point.
        for (final GraphicsDevice device : gs) {
            final GraphicsConfiguration[] configurations = device.getConfigurations();
            for (final GraphicsConfiguration config : configurations) {
                final Rectangle bounds = config.getBounds();
                if (bounds.contains(p)) {
                    // Set point to screen coordinates.
                    final Point b = bounds.getLocation();
                    final Point s = new Point(p.x - b.x, p.y - b.y);
                    try {
                        final Robot r = new Robot(device);
                        r.mouseMove(s.x, s.y);
                    } catch (final AWTException e) {
                        e.printStackTrace();
                    }

                    return;
                }
            }
        }
        // Couldn't move to the point, it may be off screen.
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseDragged(final MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        mousdr = true;
        xm = x - apx;
        ym = y - apy;
        if (!noMouseLock) {
            updateFirstPerson(x, y);
            final Point p = getLocationOnScreen();
            p.x += 400;
            p.y += 225;
            moveMouse(p);
        }
        mouseDragToX = (xm - 505) * (Math.abs(sy) / nfm.open.Medium.focusPoint) + sx;
        mouseDragToY = (290 - ym) * (Math.abs(sy) / nfm.open.Medium.focusPoint) + sz;

    }

    /**
     * Update first person.
     *
     * @param x the x
     * @param y the y
     */
    private static void updateFirstPerson(final int x, final int y) {
        if (x != 400) {
            vxz += (int) ((x - 400) * 0.41F);
        }
        if (y != 225) {
            fakezy += (int) ((y - 225) * 0.41F);
            if (fakezy > 90) {
                fakezy = 90;
            }
            if (fakezy < -90) {
                fakezy = -90;
            }
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseMoved(final MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        xm = x - apx;
        ym = y - apy;
        if (!noMouseLock) {
            updateFirstPerson(x, y);
            final Point p = getLocationOnScreen();
            p.x += 400;
            p.y += 225;
            moveMouse(p);
        }
        /*if (xm > 620 && xm < 774 && ym > 0 && ym < 23) {
            if (!onbtgame) {
                onbtgame = true;
                gameFrame.setCursor(new Cursor(12));
            }
        } else if (onbtgame) {
            onbtgame = false;
            gameFrame.setCursor(new Cursor(0));
        }*/

    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseClicked(final MouseEvent e) {
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseExited(final MouseEvent e) {

    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    @Override
    public void mousePressed(final MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        mousdr = true;
        xm = x - apx;
        ym = y - apy;
        mousePressed = 1;
        aMouseState = 1;
        requestFocus();
        focuson = true;
        dragOriginX = (xm - 505) * (Math.abs(sy) / nfm.open.Medium.focusPoint) + sx;
        dragOriginY = (290 - ym) * (Math.abs(sy) / nfm.open.Medium.focusPoint) + sz;
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    @Override
    public void mouseReleased(final MouseEvent e) {
        final int x = e.getX();
        final int y = e.getY();
        mousdr = false;
        xm = x - apx;
        ym = y - apy;
        if (mousePressed == 1) {
            mousePressed = -1;
        }
        aMouseState = -1;
    }

    private static boolean noMouseLock = true;
    private static boolean goAround = false;
    private static boolean tiltLeft = false;
    private static boolean tiltRight = false;
    private static boolean tiltSnap;

    private static Stack<SearchResult> results;

    /* (non-Javadoc)
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        final int i = e.getKeyCode();
        if (focuson) {
            if (i == KeyEvent.VK_M) {
                noMouseLock = !noMouseLock;
            }
            if (i == KeyEvent.VK_Z) { //z
                toggle_drawpartids = !toggle_drawpartids;
            }
            if (i == KeyEvent.VK_X) { //x
                toggle_drawmouse = !toggle_drawmouse;
            }
            if (kSettings) {
                if (i == KeyEvent.VK_SHIFT) {
                    speedShift = 2.0F;
                }

                if (inPreview && i == KeyEvent.VK_C) {
                    zoomi = true;
                }
                if (inPreview && i == KeyEvent.VK_SPACE) {
                    zoomo = true;
                }
                if (i == KeyEvent.VK_W && !inPreview || inPreview && i == KeyEvent.VK_UP) {
                    up = true;
                }
                if (i == KeyEvent.VK_A && !inPreview || inPreview && i == KeyEvent.VK_LEFT) {
                    left = true;
                }
                if (i == KeyEvent.VK_S && !inPreview || inPreview && i == KeyEvent.VK_DOWN) {
                    down = true;
                }
                if (i == KeyEvent.VK_D && !inPreview || inPreview && i == KeyEvent.VK_RIGHT) {
                    right = true;
                }
            } else if (isHansen) {
                if (i == KeyEvent.VK_W) {
                    up = true;
                }
                if (i == KeyEvent.VK_S) {
                    down = true;
                }
                if (i == KeyEvent.VK_A) {
                    left = true;
                }
                if (i == KeyEvent.VK_D) {
                    right = true;
                }
                if (i == KeyEvent.VK_Q) {
                    if (!inPreview) {
                        zoomi = true;
                    } else {
                        tiltLeft = true;
                    }
                }
                if (i == KeyEvent.VK_E) {
                    if (!inPreview) {
                        zoomo = true;
                    } else {
                        tiltRight = true;
                    }
                }
                // special hansen modifiers
                if (i == KeyEvent.VK_SHIFT) {
                    speedShift = 2.0F;
                    tiltSnap = true;
                }
                if (i == KeyEvent.VK_CONTROL) {
                    speedShift = 0.5F;
                }
                // special hansen settings
                if (i == KeyEvent.VK_N) {
                    goAround = !goAround;
                }
                if (i == KeyEvent.VK_DELETE && tab == 1 && epart) {
                    if (esp == -1) {
                        if (hi == -1) {
                            getHighlightedPiece();
                        }
                        esp = hi;
                    }

                    removesp();
                    esp = -1;
                }
            } else {
                if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87 || i == 43 || i == 61) {
                    zoomi = true;
                }
                if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83 || i == 45) {
                    zoomo = true;
                }
                if (i == KeyEvent.VK_LEFT) {
                    left = true;
                }
                if (i == KeyEvent.VK_RIGHT) {
                    right = true;
                }
                if (i == KeyEvent.VK_DOWN) {
                    down = true;
                }
                if (i == KeyEvent.VK_UP) {
                    up = true;
                }
            }

        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent e) {
        final int i = e.getKeyCode();
        if (kSettings) {
            if (i == KeyEvent.VK_SHIFT) {
                speedShift = 1.0F;
            }

            if (inPreview && i == KeyEvent.VK_C) {
                zoomi = false;
            }
            if (inPreview && i == KeyEvent.VK_SPACE) {
                zoomo = false;
            }
            if (i == KeyEvent.VK_W && !inPreview || inPreview && i == KeyEvent.VK_UP) {
                up = false;
            }
            if (i == KeyEvent.VK_A && !inPreview || inPreview && i == KeyEvent.VK_LEFT) {
                left = false;
            }
            if (i == KeyEvent.VK_S && !inPreview || inPreview && i == KeyEvent.VK_DOWN) {
                down = false;
            }
            if (i == KeyEvent.VK_D && !inPreview || inPreview && i == KeyEvent.VK_RIGHT) {
                right = false;
            }
        } else if (isHansen) {
            if (i == KeyEvent.VK_W) {
                up = false;
            }
            if (i == KeyEvent.VK_S) {
                down = false;
            }
            if (i == KeyEvent.VK_A) {
                left = false;
            }
            if (i == KeyEvent.VK_D) {
                right = false;
            }
            if (i == KeyEvent.VK_Q) {
                if (!inPreview) {
                    zoomi = false;
                } else {
                    tiltLeft = false;
                }
            }
            if (i == KeyEvent.VK_E) {
                if (!inPreview) {
                    zoomo = false;
                } else {
                    tiltRight = false;
                }
            }
            if (i == KeyEvent.VK_SHIFT) {
                tiltSnap = false;
            }
            if (i == KeyEvent.VK_CONTROL || i == KeyEvent.VK_SHIFT) {
                speedShift = 1.0F;
            }
        } else {
            if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87 || i == 43 || i == 61) {
                zoomi = false;
            }
            if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83 || i == 45) {
                zoomo = false;
            }
            if (i == KeyEvent.VK_LEFT) {
                left = false;
            }
            if (i == KeyEvent.VK_RIGHT) {
                right = false;
            }
            if (i == KeyEvent.VK_DOWN) {
                down = false;
            }
            if (i == KeyEvent.VK_UP) {
                up = false;
            }
        }
    }

    /* (non-Javadoc)
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent e) {

    }

    @Override
    public void mouseWheelMoved(final MouseWheelEvent e) {
        final boolean wheelMovedUp = e.getWheelRotation() < 0;
        if (isHansen) {
            if (wheelMovedUp) {
                zoomOnce(false, Math.abs(e.getWheelRotation()));
            } else {
                zoomOnce(true, Math.abs(e.getWheelRotation()));
            }

        }
    }

    private void zoomOnce(final boolean out, final int multiplier) {
        if (tab == 1) {
            if (!out) {
                if (kSettings) {
                    ziAccFloat = 1.0F;
                    sy += 450 * speedShift;
                } else if (isHansen) {
                    sy += 500 * speedShift;
                } else {
                    sy += 500;
                }

                if (sy > -2500) {
                    sy = -2500;
                }
            } else {
                if (kSettings) {
                    zoAccFloat = 1.0F;
                    sy -= 450 * speedShift;
                    if (sy < -61000) {
                        sy = -61000;
                    }
                } else if (isHansen) {
                    sy -= 500 * speedShift;
                    if (sy < -80000) {
                        sy = -80000;
                    }
                } else {
                    sy -= 500;
                    if (sy < -55000) {
                        sy = -55000;
                    }
                }

            }
        } else if (tab == 2) {
            if (!out) {
                vy += 200 * multiplier * speedShift;
                if (vy > -500) {
                    vy = -500;
                }
            } else {
                vy -= 200 * multiplier * speedShift;
                if (vy < -5000) {
                    vy = -5000;
                }
            }
        }
    }

    /**
     * aroundtrack that updates the fake fields.
     */
    private static void fakeAroundTrack() {
        nfm.open.Medium.aroundtrack();
        fakezy = nfm.open.Medium.zy;
        vxz = nfm.open.Medium.xz;
        vx = nfm.open.Medium.x;
        vz = nfm.open.Medium.z;
        vy = nfm.open.Medium.y;
    }

    static void guessWhosBack() {
        if (Madness.testcar.equals("Failx12")) {
            JOptionPane.showMessageDialog(null, "Failed to load stage! Please make sure stage is saved properly before Test Drive.", "Stage Maker", 1);
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
        Madness.testcar = "";
        Madness.testdrive = 0;

        if (offImage != null) {
            rd = offImage.createGraphics();
        } else {
            throw new Error("this should never happen");
            /*
            playerPos = new SMContO[lastPlayerPos];
            for (int i = 0; i < lastPlayerPos; i++) {
            playerPos[i] = new SMContO(bco[NODE_SET_ID], playerX[i], playerY[i], playerZ[i], 0, false);
            }
            */
        }
    }

    private static void drawNodePath() {

        for (int i = 0; i < nfm.open.CheckPoints.n - 1; i++) {
            /*if (playerPos[i].dist == 0) {
                playerPos[i].d(rd);
            }
            playerPos[i].d(rd);*/

            final int[] aX = {
                    nfm.open.CheckPoints.x[i] - nfm.open.Medium.x, nfm.open.CheckPoints.x[i + 1] - nfm.open.Medium.x
            };
            final int[] aY = {
                    nfm.open.CheckPoints.y[i] - nfm.open.Medium.y, nfm.open.CheckPoints.y[i + 1] - nfm.open.Medium.y
            };
            final int[] aZ = {
                    nfm.open.CheckPoints.z[i] - nfm.open.Medium.z, nfm.open.CheckPoints.z[i + 1] - nfm.open.Medium.z
            };

            medium_rot(aX, aZ, nfm.open.Medium.cx, nfm.open.Medium.cz, nfm.open.Medium.xz, asin_m_xz, acos_m_xz, 2);
            medium_rot(aY, aZ, nfm.open.Medium.cy, nfm.open.Medium.cz, nfm.open.Medium.zy, asin_m_zy, acos_m_zy, 2);
            medium_rot(aX, aY, nfm.open.Medium.cx, nfm.open.Medium.cy, __m_xy, asin_m_xy, acos_m_xy, 2);
            final int[] x2d = new int[2];
            final int[] y2d = new int[2];

            x2d[0] = Utility.xs(aX[0], aZ[0]);
            y2d[0] = Utility.mediumYs(aY[0], aZ[0]);
            x2d[1] = Utility.xs(aX[1], aZ[1]);
            y2d[1] = Utility.mediumYs(aY[1], aZ[1]);

            rd.setColor(Color.magenta);
            rd.drawLine(x2d[0], y2d[0], x2d[1], y2d[1]);
        }

        //      CheckPoints.x[CheckPoints.n] = getint("set", line, 1);
        //      CheckPoints.z[CheckPoints.n] = getint("set", line, 2);
        //      CheckPoints.y[CheckPoints.n] = 0;
    }

}
