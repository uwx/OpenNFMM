
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
    private int actmag = 0;
    private String[][] addeda = new String[20][5000];
    int[] adna = {
            276, 276, 276, 276, 276, 276
    };
    String aply1 = "";
    String aply2 = "";
    private boolean aplyd1 = false;
    private boolean aplyd2 = false;
    int apx = 0;
    int apy = 0;
    int bfo = 0;
    private boolean breakbond = false;
    private Image[] btgame = new Image[2];
    int btn = 0;
    int[] bw = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] bx = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    int[] by = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };
    String carname = "";
    int carsel = 0;
    private int[][] carstat = {
            {
                    110, 81, 131, 98, 100
            }, {
                    200, 200, 88, 16, 16
            }, {
                    108, 80, 93, 114, 125
            }, {
                    146, 119, 100, 83, 72
            }, {
                    109, 85, 141, 96, 93
            }, {
                    128, 98, 102, 109, 123
            }, {
                    115, 139, 96, 117, 133
            }, {
                    120, 81, 145, 126, 128
            }, {
                    140, 122, 101, 113, 124
            }, {
                    110, 144, 100, 154, 92
            }, {
                    133, 122, 144, 115, 126
            }, {
                    107, 96, 96, 192, 189
            }, {
                    192, 200, 106, 92, 90
            }, {
                    88, 104, 88, 200, 200
            }, {
                    148, 150, 197, 95, 90
            }, {
                    112, 128, 120, 192, 128
            }
    };
    String cfont = "Monospaced";
    private boolean changed = false;
    private boolean changed2 = false;
    int[] clas = new int[20];
    Smenu cls = new Smenu(40);
    int clsel = 0;
    int cntchk = 0;
    int cntpls = 0;
    int cntprf = 0;
    Smenu compcar = new Smenu(40);
    private ContO[] compo = new ContO[16];
    int compsel = 0;
    int[] crash = {
            50, 50, 50
    };
    private boolean crashleft = false;
    private boolean crashok = false;
    private soundClip[] crashs = new soundClip[3];
    private boolean crashup = false;
    int crshturn = 0;
    Smenu ctheme = new Smenu(40);
    int cthm = 0;
    Color defb;
    Color deff;
    private boolean defnow = false;
    private boolean down = false;
    int dtab = 0;
    int dtabed = -1;
    private TextArea editor = new TextArea(20, 20);
    Smenu engine = new Smenu(40);
    private boolean engon = false;
    private soundClip[][] engs = new soundClip[5][5];
    int engsel = 0;
    private boolean exwist = false;
    String fcol = "";
    private float[] fhsb = {
            0.5F, 0.5F, 0.5F
    };
    int flk = 0;
    private boolean focuson = true;
    Smenu fontsel = new Smenu(40);
    private boolean forwheels = false;
    private FontMetrics ftm;
    int handling = 140;
    int hitmag = 0;
    private boolean in = false;
    String lastedo = "";
    private boolean left = false;
    private boolean loadedfile = false;
    int logged = 0;
    Image logo;
    private soundClip[] lowcrashs = new soundClip[3];
    Medium m = new Medium();
    private String[] maker = new String[20];
    private boolean minus = false;
    private boolean mirror = false;
    private boolean mousdr = false;
    int mouseon = -1;
    int mouses = 0;
    private boolean multf10 = false;
    private String[] mycars = new String[20];
    int[] nad = new int[20];
    int nmc = 0;
    int npolys = 0;
    ContO o;
    private boolean objfacend = false;
    String ofcol = "";
    Image offImage;
    private boolean onbtgame = false;
    private boolean openm = false;
    int[] oscale = {
            100, 100, 100
    };
    String oscol = "";
    private boolean out = false;
    int ox = 335;
    int oxy = 0;
    int oxz = -90;
    int oy = 40;
    int oz = 800;
    int ozy = 0;
    private boolean[] pessd = {
            false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
            false, false, false, false, false, false, false, false, false
    };
    int pfase = 0;
    private boolean pflk = false;
    int[] phys = {
            50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50
    };
    private boolean plus = false;
    private String[] pname = {
            "Handbrake", "Turning Sensitivity", "Tire Grip", "Bouncing", "Empty", "Lifts Others", "Gets Lifted",
            "Pushes Others", "Gets Pushed", "Aerial Rotation Speed", "Aerial Control/Gliding"
    };
    int[] pnx = {
            62, 20, 76, 71, 60, 38, 44, 20, 33, 320, 324
    };
    int polynum = -1;
    private PopupMenu popupMenu;
    private boolean prefs = false;
    int prflk = 0;
    int[] pubt = new int[20];
    Smenu pubtyp = new Smenu(40);
    private boolean rateh = false;
    int[] rcrash = {
            50, 50, 50
    };
    private Graphics2D rd;
    private boolean right = false;
    private boolean rotl = false;
    private boolean rotr = false;
    int[] rphys = {
            50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50
    };
    private TextField rplc = new TextField("", 15);
    int[] rstat = {
            0, 0, 0, 0, 0
    };
    int[] scale = {
            100, 100, 100
    };
    String scar = "";
    String scol = "";
    int sfase = 0;
    String sfont = "Monospaced";
    private float[] shsb = {
            0.5F, 0.5F, 0.5F
    };
    Smenu simcar = new Smenu(40);
    Smenu slcar = new Smenu(2000);
    int sle = -1;
    int sls = -1;
    int squash = 0;
    private TextField srch = new TextField("", 15);
    int[] stat = {
            100, 100, 100, 100, 100
    };
    private boolean statdef = false;
    int sthm = 0;
    String suser = "Horaks";
    private Trackers t = new Trackers();
    int tab = 0;
    int tabed = -1;
    boolean tested = false;
    Thread thredo;
    private TextField tnick = new TextField("", 15);
    private boolean tomany = false;
    private TextField tpass = new TextField("", 15);
    private boolean tutok = false;
    private boolean up = false;
    private String[] usage = {
            "Handbrake:\nThis defines the hand braking power of the car.\nThe more handbrake the car has the faster it brakes when you press Spacebar while driving.\nBut also the lesser the Handbrake the more the car can drift when you press Spacebar.\n\n",
            "Turning Sensitivity:\nThis defines how fast the car turns (or how fast the wheels respond to turning).\nThe more turning sensitive the faster the car turns and responds.\n\nWhen designing a fast car that is more racing oriented high turning sensitivity is     \nrecommended for the car to be able to take sharp and quick turns.\nHowever too much turning sensitivity can make the car hard to drive!\n\nWhen designing a slower and bigger car (like El King) lower turning sensitivity is\nrecommended for a more realistic effect.\n\n",
            "Tires Grip:\nThis defines the griping power of the car\u2019s wheels on the ground.\n\nThe more griping the more the cars sticks to track.\nThe less gripping the more the car drifts in the turns.\n\nSome drifting can be helpful as it makes the car drive smoother while less drifting can\nmake the car more irritable, it depends on how you like to drive the car and how it\nfeels for you.\n\n",
            "Bouncing:\nThis defines how the car bounces back when it hits the ground or obstacles.\n\nBouncing can help when performing stunts as when you land up side down\nif the car bounces it can be filliped over before landing again to avoid a 'bad landing'.\n\nHowever bouncing is not helpful in controlling the car and in racing.\n\n",
            "If you can read this then you are decompiling the code! Please don\u2019t bother trying to allow the car maker to give you max stats, the stats get check on the server before the car can be accepted. Just to save you sometime.",
            "Lifts Others:\nThis defines if the car lifts up other cars when it collides with them from the front and\nhow high it can lift them.\n\nDoes the car have a pointy nose like MAX Revenge, Radical One or La Vita Crab, a\npointy nose/front part that can go under the wheels of other cars and lift them?\nIf so then give it some Lifts Others.\n\nIf it has a nose/front part that is a block like most cars then give it 0 Lifts Others.\n\n",
            "Gets Lifted:\nThis defines if the car can get lifted over other cars when it collides with them and how\nhigh it can get lifted.\n\nIs the car higher off the ground like Wow Caninaro or has big wheels like Dr Monstaa,\nshould its jump over cars when it collides with them?\nIf so then give it some Gets Lifted depending on how high it should go.\n\nIf the car is lower to the ground like most cars then it should have 0 Gets Lifted\n\n",
            "Pushes Others:\nThis defines if the car pushes other cars away when it collides with them and how far it\ncan push them.\n\nIs the car a heavy car with a strong body like MASHEEN or El King, where when it\ncollides with other cars it pushes them away?\nOr does the car have special bumpers or body parts for pushing cars away like Sword of\nJustice has?\nIf so then give it some Pushes Others depending how strong you think it can push cars.\n\nIf it is a car like any other car, with an average weight and body strength then you should\ngive it 0 Pushes Others.\n\n",
            "Gets Pushed:\nThis defines if the car gets pushed away when it collides with other cars and how far it\ngets pushed away.\n\nIf the car is lighter then most cars, then it should get pushed away when it collides with\nothers cars.\nGetting pushed can be helpful if the car is week because it gets it away from the danger\n(from the car that hit it) faster, making it take lesser hits and escape better.\nHowever getting pushed is not helpful when racing.\n\n",
            "Aerial Rotation Speed:\nThis adjusts how fast the car can rotate and flip in the air when its performing a stunt.\n\nThis variable also depends on how much the \u2018Stunts\u2019 stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf you think the car is rotating too fast or too slow in the air when performing a stunt use\nthis variable to adjust that.\n\nIf the aerial rotation is too fast it can make the car hard to control in the air as it flips and\nhard to land upright.\n\nIf the car is a big and heavy car like MASHHEN or El King then it should have low\naerial rotation for a realistic effect.\n\n",
            "Aerial Control/Gliding:\nThis adjusts the cars ability to push itself in the air and glide when performing stunts!\n\nIf you don\u2019t know, in the game:\nBackward looping pushes the car upwards. \nForward looping pushes the car forwards. \nLeft and right rolling pushes the car left and right. \n\nThis variable adjust the power if this aerial push.\n\nThe variable also depends on how much the \u2018Stunts\u2019 stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf the car has some kind of wings or fins like Radical One or Kool Kat have then it should\nhave higher aerial control and gliding ability.\n\n",
            "Crash Look Test!\nThis defines how the car will look when it gets damaged.\nOr in other words what the car will look like as it gets damaged until it becomes wasted!\n\nIMPORTANT:\nYou need to perform a 'Normal Crash' test with a 'Roof Crash' test until the car gets totally destroyed (gets wasted and burns).\nYou need to also try a 'Normal Crash' test alone (without the roof crash) until the car gets wasted!\nA 'Roof Crash' happens significantly more when the car falls on its roof from a high jumps.\nA 'Normal Crash' is what happens as the car crashes normally with other cars and obstacles.\n\nClick any of adjustment variable names \u2018Radius\u2019, \u2018Magnitude\u2019 and \u2018Roof Destruction\u2019 to learn about their effect.\n\n>  You must perform the crash test more then once in order to make sure that this is how your want the car to look as it gets damaged\nuntil total destruction.",
            "Crash Radius:\nThe radius around the crash at which the polygons/pieces that lay inside it get\naffected.\n\nOr basically in other words the number of pieces that get affected on collision (the pieces\naround the crash location).\n\nIncreasing the radius will result in more pieces/polygons around the point of collision\ngetting crashed and distorted.\nDecreasing the radius means less pieces/polygons around the collision point getting\ndistorted and crashed.\n\n",
            "Crash Magnitude:\nThe magnitude of the distortion and indentation to occur on the effected pieces/polygons.\n\nOr basically in other words the amount of destruction that happens to each piece when\ncrashed.\n\nHigher magnitude means the piece gets more destructed from an amount of damage,\nlower magnitude means the piece gets less destructed from that same amount of damage.\n\n",
            "Roof Destruction:\nThe amount of destruction to occur on the car\u2019s top.\nThe length of indentation and destruction to happen from above.\n\nTo really see this variable's effect try crashing the roof alone (without a normal crash),\ntry more then once while fixing the car and changing the variable\u2019s value to see the\ndifference.\n\nThe roof crash normally happens in the game when the car lands upside down from a\njump or when a big car like Dr Monstaa steps on it.\n\n"
    };
    private boolean waso = false;
    Smenu witho = new Smenu(40);
    private TextField[] wv = new TextField[16];
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
        if (string.equals("Cut")) {
            final StringSelection stringselection = new StringSelection(textcomponent.getSelectedText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
            if (Madness.textid == 18)
                editor.replaceText("", editor.getSelectionStart(), editor.getSelectionEnd());
            else
                textcomponent.setText(new StringBuilder()
                        .append(textcomponent.getText().substring(0, textcomponent.getSelectionStart()))
                        .append(textcomponent.getText().substring(textcomponent.getSelectionEnd(),
                                textcomponent.getText().length()))
                        .toString());
        }
        if (string.equals("Copy")) {
            final StringSelection stringselection = new StringSelection(textcomponent.getSelectedText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
        }
        if (string.equals("Paste"))
            try {
                final String string399 = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
                        .getData(DataFlavor.stringFlavor);
                if (Madness.textid == 18)
                    editor.replaceText(string399, editor.getSelectionStart(), editor.getSelectionEnd());
                else
                    textcomponent
                            .setText(
                                    new StringBuilder()
                                            .append(textcomponent.getText().substring(0,
                                                    textcomponent.getSelectionStart()))
                                            .append(string399)
                                            .append(textcomponent.getText().substring(textcomponent.getSelectionEnd(),
                                                    textcomponent.getText().length()))
                                            .toString());
            } catch (final Exception exception) {
                
            }
        if (string.equals("Select All"))
            textcomponent.selectAll();
    }

    public boolean checko(final String string) {
        loadfile();
        setupo();
        if (o.colok < 2) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Car is not ready for ").append(string)
                            .append("!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.\n")
                            .toString(),
                    "Car Maker", 1);
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
                    new StringBuilder().append("Car is not ready for ").append(string)
                            .append("!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the \u2018Car\u2019 tab to find the tutorial on how to build a car.\n")
                            .toString(),
                    "Car Maker", 1);
            return false;
        }
        if (o.npl > 10000) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Car is not ready for ").append(string)
                            .append("!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 10000.\nPlease use the counter in the \u2018Code Edit\u2019 to decrease the number of polygons (pieces).\n")
                            .toString(),
                    "Car Maker", 1);
            return false;
        }
        if (o.maxR > 40000) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Car is not ready for ").append(string)
                            .append("!\nReason:\nCar scale size is too large!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled down by ")
                            .append((int) ((o.maxR / 400.0F - 1.0F) * 100.0F)).append("%.\n").toString(),
                    "Car Maker", 1);
            return false;
        }
        if (o.maxR < 2) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Car is not ready for ").append(string)
                            .append("!\nReason:\nCar scale size is too small!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled up by ")
                            .append((int) ((120.0F / o.maxR - 1.0F) * 100.0F)).append("%.\n").toString(),
                    "Car Maker", 1);
            return false;
        }
        final String string304 = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
        int i = 0;
        int i305 = string304.indexOf("\n", 0);
        boolean bool306 = false;
        boolean bool307 = false;
        boolean bool308 = false;
        while (i305 != -1 && i < string304.length()) {
            String string309 = string304.substring(i, i305);
            string309 = string309.trim();
            i = i305 + 1;
            i305 = string304.indexOf("\n", i);
            if (string309.startsWith("stat(")) {
                bool306 = true;
                try {
                    int i310 = 0;
                    for (int i311 = 0; i311 < 5; i311++) {
                        stat[i311] = getvalue("stat", string309, i311);
                        if (stat[i311] > 200)
                            bool306 = false;
                        if (stat[i311] < 16)
                            bool306 = false;
                        i310 += stat[i311];
                    }
                    if (i310 != 680 && i310 != 640 && i310 != 600 && i310 != 560 && i310 != 520)
                        bool306 = false;
                } catch (final Exception exception) {
                    bool306 = false;
                }
            }
            if (string309.startsWith("physics(")) {
                bool307 = true;
                try {
                    for (int i312 = 0; i312 < 11; i312++)
                        phys[i312] = getvalue("physics", string309, i312);
                    // if (phys[i312] > 100)
                    // bool307 = false;
                    // if (phys[i312] < 0)
                    // bool307 = false;
                    for (int i313 = 0; i313 < 3; i313++)
                        crash[i313] = getvalue("physics", string309, i313 + 11);
                    // if (i313 != 0 && crash[i313] > 100)
                    // bool307 = false;
                    // if (crash[i313] < 0)
                    // bool307 = false;
                    engsel = getvalue("physics", string309, 14);
                    if (engsel > 4)
                        bool307 = false;
                    if (engsel < 0)
                        bool307 = false;
                } catch (final Exception exception) {
                    bool307 = false;
                }
            }
            if (string309.startsWith("handling(")) {
                bool308 = true;
                try {
                    getvalue("handling", string309, 0);
                } catch (final Exception exception) {
                    bool308 = false;
                }
            }
        }
        if (!bool306) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Car is not ready for ").append(string)
                            .append("!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n")
                            .toString(),
                    "Car Maker", 1);
            return false;
        }
        if (!bool307) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Car is not ready for ").append(string)
                            .append("!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n")
                            .toString(),
                    "Car Maker", 1);
            return false;
        }
        if (!bool308 && string.equals("Publishing")) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Car is not ready for ").append(string)
                            .append("!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n")
                            .toString(),
                    "Car Maker", 1);
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
        for (int i174 = 0; i174 < btn; i174++) {
            if (Math.abs(xm - bx[i174]) < bw[i174] / 2 + 12 && Math.abs(ym - by[i174]) < 14 && mouses == 1)
                pessd[i174] = true;
            else
                pessd[i174] = false;
            if (Math.abs(xm - bx[i174]) < bw[i174] / 2 + 12 && Math.abs(ym - by[i174]) < 14 && mouses == -1)
                i = i174;
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
                    if (!carname.equals("")) {
                        srch.setText(carname);
                        sfase = 2;
                        i = -1;
                        hidefields();
                    } else
                        JOptionPane.showMessageDialog(null, "Please Select a Car to Rename!\n", "Car Maker", 1);
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
                    srch.setText("");
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
                    srch.setText("");
                    sfase = 0;
                    i = -1;
                    hidefields();
                }
            }
            if (sfase == 3) {
                if (i == 0) {
                    File file = null;
                    final FileDialog filedialog = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
                    filedialog.setFile("*.obj");
                    filedialog.setMode(0);
                    filedialog.setVisible(true);
                    try {
                        if (filedialog.getFile() != null)
                            file = new File(new StringBuilder().append("").append(filedialog.getDirectory()).append("")
                                    .append(filedialog.getFile()).append("").toString());
                    } catch (final Exception exception) {
                        
                    }
                    if (file != null) {
                        setCursor(new Cursor(3));
                        int i175 = 0;
                        if (tutok)
                            i175 = -70;
                        rd.setColor(new Color(225, 225, 225));
                        rd.fillRect(116, 246 + i175, 468, 50);
                        rd.setColor(new Color(0, 0, 0));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(
                                new StringBuilder().append("Reading ").append(file.getName()).append(", please wait...")
                                        .toString(),
                                350 - ftm.stringWidth(new StringBuilder().append("Reading ").append(file.getName())
                                        .append(", please wait...").toString()) / 2,
                                276 + i175);
                        repaint();
                        final int[] is = new int[6000];
                        final int[] is176 = new int[6000];
                        final int[] is177 = new int[6000];
                        int i178 = 0;
                        final int[][] is179 = new int[600][100];
                        final int[] is180 = new int[600];
                        int i181 = 0;
                        if (file.exists()) {
                            try {
                                final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                                boolean bool = false;
                                boolean bool182 = false;
                                String string;
                                while ((string = bufferedreader.readLine()) != null) {
                                    if (string.startsWith("v "))
                                        if (i178 < 6000) {
                                            multf10 = true;
                                            is[i178] = objvalue(string, 0);
                                            is176[i178] = objvalue(string, 1);
                                            is177[i178] = objvalue(string, 2);
                                            i178++;
                                        } else
                                            bool = true;
                                    if (string.startsWith("f "))
                                        if (i181 < 600) {
                                            multf10 = false;
                                            objfacend = false;
                                            for (is180[i181] = 0; !objfacend && is180[i181] < 100; is180[i181]++)
                                                is179[i181][is180[i181]] = objvalue(string, is180[i181]);
                                            i181++;
                                        } else
                                            bool182 = true;
                                }
                                if (bool)
                                    JOptionPane.showMessageDialog(null,
                                            new StringBuilder().append("Warning!\nThe number of Vertices in file ")
                                                    .append(file.getName())
                                                    .append(" exceeded the maximum of 6000 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n")
                                                    .toString(),
                                            "Car Maker", 0);
                                if (bool182)
                                    JOptionPane.showMessageDialog(null,
                                            new StringBuilder().append("Warning!\nThe number of Faces in file ")
                                                    .append(file.getName())
                                                    .append(" exceeded the maximum of 600 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n")
                                                    .toString(),
                                            "Car Maker", 0);
                                bufferedreader.close();
                            } catch (final Exception exception) {
                                JOptionPane.showMessageDialog(null, new StringBuilder()
                                        .append("Unable to load file! Error Deatials:\n").append(exception).toString(),
                                        "Car Maker", 1);
                            }
                            rd.setColor(new Color(225, 225, 225));
                            rd.fillRect(116, 246 + i175, 468, 50);
                            rd.setColor(new Color(0, 0, 0));
                            rd.setFont(new Font("Arial", 1, 13));
                            ftm = rd.getFontMetrics();
                            rd.drawString(
                                    new StringBuilder().append("Importing ").append(file.getName())
                                            .append(", please wait...").toString(),
                                    350 - ftm.stringWidth(new StringBuilder().append("Importing ")
                                            .append(file.getName()).append(", please wait...").toString()) / 2,
                                    276 + i175);
                            repaint();
                            carname = file.getName();
                            if (carname.endsWith(".obj"))
                                carname = carname.substring(0, carname.length() - 4);
                            String string = new StringBuilder().append("\n// imported car: ").append(carname)
                                    .append("\n---------------------\n\n// Please read the helpful information about importing cars found at:\n// http://www.needformadness.com/developer/extras.html\n\n\n")
                                    .toString();
                            for (int i184 = 0; i184 < i181; i184++) {
                                string = new StringBuilder().append(string).append("<p>\nc(200,200,220)\n\n")
                                        .toString();
                                for (int i185 = 0; i185 < is180[i184]; i185++)
                                    if (is179[i184][i185] < 6000) {
                                        final int i186 = is179[i184][i185];
                                        string = new StringBuilder().append(string).append("p(").append(is[i186])
                                                .append(",").append(-is176[i186]).append(",").append(is177[i186])
                                                .append(")\n").toString();
                                    }
                                string = new StringBuilder().append(string).append("</p>\n\n").toString();
                            }
                            string = new StringBuilder().append(string).append("\n\n\n\n").toString();
                            file = new File("mycars/");
                            if (!file.exists())
                                file.mkdirs();
                            file = new File(
                                    new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
                            int i187 = 0;
                            if (file.exists())
                                i187 = JOptionPane.showConfirmDialog(null,
                                        new StringBuilder().append("Another car with the name '").append(carname)
                                                .append("' already exists, replace it?      \n").toString(),
                                        "Car Maker", 0);
                            if (i187 == 0)
                                try {
                                    final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                    bufferedwriter.write(string);
                                    bufferedwriter.close();
                                    if (file.exists()) {
                                        sfase = 0;
                                        hidefields();
                                        tabed = -1;
                                    } else {
                                        carname = "";
                                        JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n",
                                                "Car Maker", 1);
                                    }
                                } catch (final Exception exception) {
                                    carname = "";
                                    JOptionPane.showMessageDialog(null,
                                            new StringBuilder().append("Unable to create file! Error Deatials:\n")
                                                    .append(exception).toString(),
                                            "Car Maker", 1);
                                }
                        } else
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error, ")
                                    .append(file.getName()).append(" was not found!").toString(), "Car Maker", 1);
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
                    final FileDialog filedialog = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
                    filedialog.setFile(new StringBuilder().append("").append(carname).append(".obj").toString());
                    filedialog.setMode(1);
                    filedialog.setVisible(true);
                    try {
                        if (filedialog.getFile() != null)
                            file = new File(new StringBuilder().append("").append(filedialog.getDirectory()).append("")
                                    .append(filedialog.getFile()).append("").toString());
                    } catch (final Exception exception) {
                        
                    }
                    if (file != null) {
                        int i188 = 0;
                        if (file.exists())
                            i188 = JOptionPane
                                    .showConfirmDialog(null,
                                            new StringBuilder().append("File ").append(file.getName())
                                                    .append(" already exists, replace it?      \n").toString(),
                                            "Car Maker", 0);
                        if (i188 == 0) {
                            setCursor(new Cursor(3));
                            setupo();
                            final int[] is = new int[6000];
                            final int[] is189 = new int[6000];
                            final int[] is190 = new int[6000];
                            int i191 = 0;
                            String string = "";
                            for (int i192 = 0; i192 < o.npl; i192++)
                                for (int i193 = 0; i193 < o.p[i192].n; i193++) {
                                    boolean bool = false;
                                    for (int i194 = 0; i194 < i191; i194++)
                                        if (is[i194] == o.p[i192].ox[i193] && is189[i194] == o.p[i192].oy[i193]
                                                && is190[i194] == o.p[i192].oz[i193])
                                            bool = true;
                                    if (!bool && i191 < 6000) {
                                        is[i191] = o.p[i192].ox[i193];
                                        is189[i191] = o.p[i192].oy[i193];
                                        is190[i191] = o.p[i192].oz[i193];
                                        i191++;
                                    }
                                }
                            for (int i195 = 0; i195 < i191; i195++)
                                string = new StringBuilder().append(string).append("v ").append(is[i195] / 10.0F)
                                        .append(" ").append(-is189[i195] / 10.0F).append(" ")
                                        .append(is190[i195] / 10.0F).append("\n").toString();
                            for (int i196 = 0; i196 < o.npl; i196++)
                                if (o.p[i196].wz == 0) {
                                    string = new StringBuilder().append(string).append("f").toString();
                                    for (int i197 = 0; i197 < o.p[i196].n; i197++) {
                                        string = new StringBuilder().append(string).append(" ").toString();
                                        for (int i198 = 0; i198 < i191; i198++)
                                            if (is[i198] == o.p[i196].ox[i197] && is189[i198] == o.p[i196].oy[i197]
                                                    && is190[i198] == o.p[i196].oz[i197])
                                                string = new StringBuilder().append(string).append("").append(i198 + 1)
                                                        .toString();
                                    }
                                    string = new StringBuilder().append(string).append("\n").toString();
                                }
                            try {
                                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                bufferedwriter.write(string);
                                bufferedwriter.close();
                                if (file.exists()) {
                                    JOptionPane.showMessageDialog(null,
                                            new StringBuilder().append("Car has been successfully exported to:\n")
                                                    .append(file.getAbsolutePath()).append("          \n \n")
                                                    .toString(),
                                            "Car Maker", 1);
                                    sfase = 0;
                                    hidefields();
                                    tabed = -1;
                                } else
                                    JOptionPane.showMessageDialog(null, "Failed to export car, unknown reason!\n",
                                            "Car Maker", 1);
                            } catch (final Exception exception) {
                                JOptionPane.showMessageDialog(null,
                                        new StringBuilder().append("Unable to create exported file! Error Deatials:\n")
                                                .append(exception).toString(),
                                        "Car Maker", 1);
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
                                
                            }
                            Thread.sleep(100L);
                        } catch (final InterruptedException interruptedexception) {
                            
                        }
                    }
                    i = 3;
                }
                if (i == 3 && !srch.getText().equals("")) {
                    editor.requestFocus();
                    sls = editor.getText().indexOf(srch.getText(), editor.getSelectionEnd());
                    if (sls != -1) {
                        sle = sls + srch.getText().length();
                        editor.select(sls, sle);
                    } else if (!bool)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("Cannot find  '")
                                .append(srch.getText()).append("'  from Cursor position    ").toString(), "Car Maker",
                                1);
                }
            } else {
                if (i == 3 || i == 4 || i == 5) {
                    final String string = new StringBuilder().append("").append(editor.getSelectedText()).append("\n")
                            .toString();
                    String string199 = "\n\n";
                    if (cntpls == 1)
                        string199 = new StringBuilder().append(string199)
                                .append("// Mirror of the polygon above along the ").toString();
                    else
                        string199 = new StringBuilder().append(string199).append("// Mirror of the ").append(cntpls)
                                .append(" polygons above along the ").toString();
                    if (i == 3)
                        string199 = new StringBuilder().append(string199).append("X axis:").toString();
                    if (i == 4)
                        string199 = new StringBuilder().append(string199).append("Y axis:").toString();
                    if (i == 5)
                        string199 = new StringBuilder().append(string199).append("Z axis:").toString();
                    string199 = new StringBuilder().append(string199).append("\n\n").toString();
                    int i200 = 0;
                    int i201 = string.indexOf("\n", 0);
                    while (i201 != -1 && i200 < string.length()) {
                        String string202 = string.substring(i200, i201);
                        string202 = string202.trim();
                        i200 = i201 + 1;
                        i201 = string.indexOf("\n", i200);
                        if (string202.startsWith("fs(-"))
                            string202 = new StringBuilder().append("fs(")
                                    .append(string202.substring(4, string202.length())).append("").toString();
                        else if (string202.startsWith("fs("))
                            string202 = new StringBuilder().append("fs(-")
                                    .append(string202.substring(3, string202.length())).append("").toString();
                        if (i == 3)
                            if (string202.startsWith("p(-"))
                                string202 = new StringBuilder().append("p(")
                                        .append(string202.substring(3, string202.length())).append("").toString();
                            else if (string202.startsWith("p("))
                                string202 = new StringBuilder().append("p(-")
                                        .append(string202.substring(2, string202.length())).append("").toString();
                        if (i == 4 && string202.startsWith("p(")) {
                            final int i203 = string202.indexOf(",", 0);
                            if (i203 >= 0)
                                if (string202.startsWith(",-", i203))
                                    string202 = new StringBuilder().append("").append(string202.substring(0, i203))
                                            .append(",").append(string202.substring(i203 + 2, string202.length()))
                                            .append("").toString();
                                else if (string202.startsWith(",", i203))
                                    string202 = new StringBuilder().append("").append(string202.substring(0, i203))
                                            .append(",-").append(string202.substring(i203 + 1, string202.length()))
                                            .append("").toString();
                        }
                        if (i == 5 && string202.startsWith("p(")) {
                            int i204 = string202.indexOf(",", 0);
                            i204 = string202.indexOf(",", i204 + 1);
                            if (i204 >= 0)
                                if (string202.startsWith(",-", i204))
                                    string202 = new StringBuilder().append("").append(string202.substring(0, i204))
                                            .append(",").append(string202.substring(i204 + 2, string202.length()))
                                            .append("").toString();
                                else if (string202.startsWith(",", i204))
                                    string202 = new StringBuilder().append("").append(string202.substring(0, i204))
                                            .append(",-").append(string202.substring(i204 + 1, string202.length()))
                                            .append("").toString();
                        }
                        string199 = new StringBuilder().append(string199).append("").append(string202).append("\n")
                                .toString();
                    }
                    string199 = new StringBuilder().append(string199).append("\n// End of mirror").toString();
                    editor.insertText(string199, editor.getSelectionEnd());
                }
                if (i == 6) {
                    polynum = 0;
                    int i205 = editor.getText().lastIndexOf("</p>", editor.getSelectionStart());
                    boolean bool = false;
                    for (/**/; i205 >= 0; i205--)
                        if (!bool) {
                            i205 = editor.getText().lastIndexOf("<p>", i205);
                            if (i205 != -1) {
                                bool = true;
                                polynum++;
                            }
                        } else {
                            i205 = editor.getText().lastIndexOf("</p>", i205);
                            if (i205 != -1)
                                bool = false;
                        }
                    prflk = 0;
                    tab = 2;
                }
            }
            i = -1;
        }
        if (tab == 2) {
            int i206 = 0;
            if (dtab == 1)
                if (o.colok != 2) {
                    if (i == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Car Maker will attempt now to find the first and second colors automatically.\nPlease make sure that they are the correct colors!\n\nPlease note that these are also the colors that will be editable in the multiplayer game.      ",
                                "Car Maker", 1);
                        final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        int i207 = 0;
                        int i208 = string.indexOf("\n", 0);
                        int i209 = 0;
                        String string210 = "";
                        String string211 = "";
                        while (i208 != -1 && i207 < string.length() && i209 != 2) {
                            String string212 = string.substring(i207, i208);
                            string212 = string212.trim();
                            i207 = i208 + 1;
                            i208 = string.indexOf("\n", i207);
                            if (string212.startsWith("c(")) {
                                final String string213 = string212.substring(1, string212.indexOf(")") + 1);
                                if (i209 == 1 && !string213.equals(string211)) {
                                    string210 = new StringBuilder().append(string210).append("2ndColor")
                                            .append(string213).append("\n\n\n").toString();
                                    i209 = 2;
                                }
                                if (i209 == 0) {
                                    string211 = string213;
                                    string210 = new StringBuilder().append("1stColor").append(string213).append("\n")
                                            .toString();
                                    i209 = 1;
                                }
                            }
                        }
                        if (i209 == 0) {
                            string210 = "1stColor(255,0,0)\n2ndColor(0,0,255)\n\n\n";
                            i209 = 2;
                        }
                        if (i209 == 1) {
                            string210 = new StringBuilder().append(string210).append("2ndColor(0,0,255)\n\n\n")
                                    .toString();
                            i209 = 2;
                        }
                        final int i214 = editor.getText().indexOf("<p>", 0);
                        editor.insertText(string210, i214);
                        editor.select(i214, i214 + string210.length() - 2);
                        breakbond = true;
                        tab = 1;
                    }
                    i206 = 1;
                } else {
                    if (i == 0) {
                        ofcol = new StringBuilder().append("(").append(o.fcol[0]).append(",").append(o.fcol[1])
                                .append(",").append(o.fcol[2]).append(")").toString();
                        int i215 = editor.getText().indexOf(ofcol, 0);
                        final int i216 = i215;
                        for (/**/; i215 != -1; i215 = editor.getText().indexOf(ofcol, i215 + 1))
                            editor.replaceText(fcol, i215, i215 + ofcol.length());
                        ofcol = fcol;
                        editor.select(i216 - 8, i216 - 8);
                        savefile();
                        o.fcol[0] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getRed();
                        o.fcol[1] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getGreen();
                        o.fcol[2] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getBlue();
                    }
                    if (i == 1) {
                        oscol = new StringBuilder().append("(").append(o.scol[0]).append(",").append(o.scol[1])
                                .append(",").append(o.scol[2]).append(")").toString();
                        int i217 = editor.getText().indexOf(oscol, 0);
                        final int i218 = i217;
                        for (/**/; i217 != -1; i217 = editor.getText().indexOf(oscol, i217 + 1))
                            editor.replaceText(scol, i217, i217 + oscol.length());
                        oscol = scol;
                        editor.select(i218 - 8, i218 - 8);
                        savefile();
                        o.scol[0] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getRed();
                        o.scol[1] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getGreen();
                        o.scol[2] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getBlue();
                    }
                    i206 = 2;
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
                    int i219 = editor.getText().indexOf("\nScaleX(", 0);
                    if (i219 != -1) {
                        i219++;
                        final int i220 = editor.getText().indexOf(")", i219);
                        final int i221 = editor.getText().indexOf("\n", i219);
                        if (i221 > i220)
                            editor.replaceText(
                                    new StringBuilder().append("ScaleX(").append(scale[0]).append(")").toString(), i219,
                                    i220 + 1);
                        else
                            editor.replaceText(
                                    new StringBuilder().append("ScaleX(").append(scale[0]).append(")").toString(), i219,
                                    i221);
                    } else {
                        final int i222 = editor.getText().indexOf("<p>", 0);
                        final int i223 = editor.getText().indexOf("\nScale", 0);
                        if (i223 < i222 && i223 != -1)
                            editor.insertText(
                                    new StringBuilder().append("\nScaleX(").append(scale[0]).append(")").toString(),
                                    i223);
                        else
                            editor.insertText(
                                    new StringBuilder().append("ScaleX(").append(scale[0]).append(")\n\n\n").toString(),
                                    i222);
                    }
                }
                if (i == 2 || i == 3 || i == 6 || i == 7 || i == 9) {
                    if (i == 2 || i == 6)
                        scale[1] -= 5;
                    if (i == 3 || i == 7)
                        scale[1] += 5;
                    if (scale[1] < 0)
                        scale[1] = 0;
                    int i224 = editor.getText().indexOf("\nScaleY(", 0);
                    if (i224 != -1) {
                        i224++;
                        final int i225 = editor.getText().indexOf(")", i224);
                        final int i226 = editor.getText().indexOf("\n", i224);
                        if (i226 > i225)
                            editor.replaceText(
                                    new StringBuilder().append("ScaleY(").append(scale[1]).append(")").toString(), i224,
                                    i225 + 1);
                        else
                            editor.replaceText(
                                    new StringBuilder().append("ScaleY(").append(scale[1]).append(")").toString(), i224,
                                    i226);
                    } else {
                        final int i227 = editor.getText().indexOf("<p>", 0);
                        final int i228 = editor.getText().indexOf("\nScale", 0);
                        if (i228 < i227 && i228 != -1)
                            editor.insertText(
                                    new StringBuilder().append("\nScaleY(").append(scale[1]).append(")").toString(),
                                    i228);
                        else
                            editor.insertText(
                                    new StringBuilder().append("ScaleY(").append(scale[1]).append(")\n\n\n").toString(),
                                    i227);
                    }
                }
                if (i == 4 || i == 5 || i == 6 || i == 7 || i == 9) {
                    if (i == 4 || i == 6)
                        scale[2] -= 5;
                    if (i == 5 || i == 7)
                        scale[2] += 5;
                    if (scale[2] < 0)
                        scale[2] = 0;
                    int i229 = editor.getText().indexOf("\nScaleZ(", 0);
                    if (i229 != -1) {
                        i229++;
                        final int i230 = editor.getText().indexOf(")", i229);
                        final int i231 = editor.getText().indexOf("\n", i229);
                        if (i231 > i230)
                            editor.replaceText(
                                    new StringBuilder().append("ScaleZ(").append(scale[2]).append(")").toString(), i229,
                                    i230 + 1);
                        else
                            editor.replaceText(
                                    new StringBuilder().append("ScaleZ(").append(scale[2]).append(")").toString(), i229,
                                    i231);
                    } else {
                        final int i232 = editor.getText().indexOf("<p>", 0);
                        final int i233 = editor.getText().indexOf("\nScale", 0);
                        if (i233 < i232 && i233 != -1)
                            editor.insertText(
                                    new StringBuilder().append("\nScaleZ(").append(scale[2]).append(")").toString(),
                                    i233);
                        else
                            editor.insertText(
                                    new StringBuilder().append("ScaleZ(").append(scale[2]).append(")\n\n\n").toString(),
                                    i232);
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
                        final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        String string234 = "";
                        int i235 = 0;
                        int i236 = string.indexOf("\n", 0);
                        while (i236 != -1 && i235 < string.length()) {
                            String string237 = string.substring(i235, i236);
                            string237 = string237.trim();
                            i235 = i236 + 1;
                            i236 = string.indexOf("\n", i235);
                            if (string237.startsWith("p(")) {
                                final int i238 = string237.indexOf(",", 0);
                                final int i239 = string237.indexOf(",", i238 + 1);
                                final int i240 = string237.indexOf(")", i239 + 1);
                                if (i238 != -1 && i239 != -1 && i240 != -1) {
                                    int i241 = Float.valueOf(string237.substring(2, i238)).intValue();
                                    int i242 = Float.valueOf(string237.substring(i238 + 1, i239)).intValue();
                                    int i243 = Float.valueOf(string237.substring(i239 + 1, i240)).intValue();
                                    if (i == 10) {
                                        final int i244 = i242;
                                        i242 = i243;
                                        i243 = -i244;
                                    }
                                    if (i == 11)
                                        i241 += 10;
                                    if (i == 12)
                                        i241 -= 10;
                                    if (i == 13) {
                                        final int i245 = i241;
                                        i241 = -i243;
                                        i243 = i245;
                                    }
                                    if (i == 14)
                                        i242 += 10;
                                    if (i == 15)
                                        i242 -= 10;
                                    if (i == 16) {
                                        final int i246 = i242;
                                        i242 = -i241;
                                        i241 = i246;
                                    }
                                    if (i == 17)
                                        i243 += 10;
                                    if (i == 18)
                                        i243 -= 10;
                                    string234 = new StringBuilder().append(string234).append("p(").append(i241)
                                            .append(",").append(i242).append(",").append(i243).append(")")
                                            .append(string237.substring(i240 + 1, string237.length())).append("\n")
                                            .toString();
                                } else
                                    string234 = new StringBuilder().append(string234).append("").append(string237)
                                            .append("\n").toString();
                            } else
                                string234 = new StringBuilder().append(string234).append("").append(string237)
                                        .append("\n").toString();
                        }
                        editor.setText(string234);
                        setupo();
                        changed2 = true;
                    } catch (final Exception exception) {
                        
                    }
                if (i == 19) {
                    editor.setText(lastedo);
                    setupo();
                    changed2 = false;
                }
                if (i == 20 && changed2) {
                    final int i247 = JOptionPane.showConfirmDialog(null,
                            "Saving now will permanently change the point locations & numbers entered in the code!      \n\nContinue?",
                            "Car Maker", 0);
                    if (i247 == 0) {
                        editor.setText(
                                new StringBuilder().append(editor.getText().trim()).append("\n\n\n\n").toString());
                        savefile();
                        changed2 = false;
                    }
                }
                i206 = 21;
            }
            if (dtab == 3) {
                if (i == 0 || i == 2 || defnow) {
                    if (defnow) {
                        defnow = false;
                        repaint();
                        JOptionPane.showMessageDialog(null,
                                "Car Maker will setup default Front and Back Wheels positions and adjustments.\n\nEnter the desired positions and adjustments then press ' Apply ' to view!\nDon't forget to press ' Save ' when finished!",
                                "Car Maker", 1);
                    }
                    int i248 = 0;
                    try {
                        int i249 = Float.valueOf(wv[10].getText()).intValue();
                        if (i249 <= 0)
                            i248 = 1;
                        i249 = Float.valueOf(wv[2].getText()).intValue();
                        if (i249 >= 0)
                            i248 = 2;
                        i249 = Float.valueOf(wv[8].getText()).intValue();
                        if (i249 <= 0)
                            i248 = 3;
                        i249 = Float.valueOf(wv[0].getText()).intValue();
                        if (i249 <= 0)
                            i248 = 4;
                        i249 = Float.valueOf(wv[15].getText()).intValue();
                        if (i249 > 40)
                            wv[15].setText("40");
                        if (i249 < -40)
                            wv[15].setText("-40");
                        i249 = Float.valueOf(wv[7].getText()).intValue();
                        if (i249 > 40)
                            wv[7].setText("40");
                        if (i249 < -40)
                            wv[7].setText("-40");
                    } catch (final Exception exception) {
                        
                    }
                    if (i248 == 1)
                        JOptionPane.showMessageDialog(null,
                                new StringBuilder()
                                        .append("ERROR:\nThe Z location value of the FRONT Wheels must be greater then zero! (it should have a +ve value)\nZ :  '")
                                        .append(wv[10].getText())
                                        .append("'  is less or equal to zero, where it should have +ve value!")
                                        .toString(),
                                "Car Maker", 1);
                    if (i248 == 2)
                        JOptionPane.showMessageDialog(null,
                                new StringBuilder()
                                        .append("ERROR:\nThe Z location value of the BACK Wheels must be smaller then zero! (it should have a -ve value)\nZ :  '")
                                        .append(wv[2].getText())
                                        .append("'  is bigger or equal to zero, where it should have -ve value!")
                                        .toString(),
                                "Car Maker", 1);
                    if (i248 == 3)
                        JOptionPane.showMessageDialog(null,
                                new StringBuilder()
                                        .append("ERROR:\nThe \u00b1X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n\u00b1X :  '")
                                        .append(wv[8].getText())
                                        .append("'  is less or equal to zero, where it should have +ve value!")
                                        .toString(),
                                "Car Maker", 1);
                    if (i248 == 4)
                        JOptionPane.showMessageDialog(null,
                                new StringBuilder()
                                        .append("ERROR:\nThe \u00b1X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n\u00b1X :  '")
                                        .append(wv[0].getText())
                                        .append("'  is less or equal to zero, whenr it should have +ve value!")
                                        .toString(),
                                "Car Maker", 1);
                    if (i248 == 0) {
                        final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        String string250 = "";
                        int i251 = 0;
                        int i252 = string.indexOf("\n", 0);
                        while (i252 != -1 && i251 < string.length()) {
                            String string253 = string.substring(i251, i252);
                            string253 = string253.trim();
                            i251 = i252 + 1;
                            i252 = string.indexOf("\n", i251);
                            if (!string253.startsWith("rims(") && !string253.startsWith("gwgr(")
                                    && !string253.startsWith("w("))
                                string250 = new StringBuilder().append(string250).append("").append(string253)
                                        .append("\n").toString();
                            else {
                                string250 = string250.trim();
                                string250 = new StringBuilder().append(string250).append("\n").toString();
                            }
                        }
                        string250 = string250.trim();
                        string250 = new StringBuilder().append(string250).append("\n\n\ngwgr(").append(wv[15].getText())
                                .append(")\n").toString();
                        String string254 = "140,140,140";
                        if (rplc.getText().startsWith("(") && rplc.getText().endsWith(")"))
                            string254 = rplc.getText().substring(1, rplc.getText().length() - 1);
                        string250 = new StringBuilder().append(string250).append("rims(").append(string254).append(",")
                                .append(wv[13].getText()).append(",").append(wv[14].getText()).append(")\n").toString();
                        string250 = new StringBuilder().append(string250).append("w(-").append(wv[8].getText())
                                .append(",").append(wv[9].getText()).append(",").append(wv[10].getText()).append(",11,")
                                .append(wv[12].getText()).append(",").append(wv[11].getText()).append(")\n").toString();
                        string250 = new StringBuilder().append(string250).append("w(").append(wv[8].getText())
                                .append(",").append(wv[9].getText()).append(",").append(wv[10].getText())
                                .append(",11,-").append(wv[12].getText()).append(",").append(wv[11].getText())
                                .append(")\n").toString();
                        string250 = new StringBuilder().append(string250).append("\ngwgr(").append(wv[7].getText())
                                .append(")\n").toString();
                        string254 = "140,140,140";
                        if (srch.getText().startsWith("(") && srch.getText().endsWith(")"))
                            string254 = srch.getText().substring(1, srch.getText().length() - 1);
                        string250 = new StringBuilder().append(string250).append("rims(").append(string254).append(",")
                                .append(wv[5].getText()).append(",").append(wv[6].getText()).append(")\n").toString();
                        string250 = new StringBuilder().append(string250).append("w(-").append(wv[0].getText())
                                .append(",").append(wv[1].getText()).append(",").append(wv[2].getText()).append(",0,")
                                .append(wv[4].getText()).append(",").append(wv[3].getText()).append(")\n").toString();
                        string250 = new StringBuilder().append(string250).append("w(").append(wv[0].getText())
                                .append(",").append(wv[1].getText()).append(",").append(wv[2].getText()).append(",0,-")
                                .append(wv[4].getText()).append(",").append(wv[3].getText()).append(")\n\n\n\n")
                                .toString();
                        editor.setText(string250);
                        forwheels = true;
                        setupo();
                        forwheels = false;
                        aply1 = new StringBuilder().append("").append(wv[0].getText()).append("")
                                .append(wv[1].getText()).append("").append(wv[2].getText()).append("")
                                .append(wv[3].getText()).append("").append(wv[4].getText()).append("")
                                .append(srch.getText()).append("").append(wv[5].getText()).append("")
                                .append(wv[6].getText()).append("").append(wv[7].getText()).append("").toString();
                        aply2 = new StringBuilder().append("").append(wv[8].getText()).append("")
                                .append(wv[9].getText()).append("").append(wv[10].getText()).append("")
                                .append(wv[11].getText()).append("").append(wv[12].getText()).append("")
                                .append(rplc.getText()).append("").append(wv[13].getText()).append("")
                                .append(wv[14].getText()).append("").append(wv[15].getText()).append("").toString();
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
                        JOptionPane.showMessageDialog(null, "Unable to Save, press  [ Apply ]  to find out why!",
                                "Car Maker", 1);
                i206 = 4;
            }
            if (dtab == 4)
                if (!statdef) {
                    if (i == 0) {
                        carsel = simcar.getSelectedIndex();
                        int i255 = 0;
                        for (int i256 = 0; i256 < 5; i256++) {
                            stat[i256] = carstat[carsel][i256];
                            rstat[i256] = stat[i256];
                            i255 += stat[i256];
                        }
                        clsel = 4 - (i255 - 520) / 40;
                        cls.select(clsel);
                        if (simcar.getItemCount() == 16)
                            simcar.add(rd, "   ");
                        statdef = true;
                        changed2 = true;
                    }
                    i206 = 1;
                } else {
                    for (int i257 = 0; i257 < 5; i257++) {
                        int i258 = 0;
                        if (i == 1 + i257 * 2 && stat[i257] < 200) {
                            i258 = 200 - stat[i257];
                            if (i258 > 4)
                                i258 = 4;
                        }
                        if (i == i257 * 2 && stat[i257] > 16) {
                            i258 = 16 - stat[i257];
                            if (i258 < -4)
                                i258 = -4;
                        }
                        int i259 = 0;
                        while (i258 != 0 && i259 != 5) {
                            i259 = 0;
                            for (int i260 = 0; i260 < 5; i260++)
                                if (i257 != i260 && (stat[i260] <= 200 || i258 > 0) && (stat[i260] >= 16 || i258 < 0)
                                        && i258 != 0) {
                                    if (i258 > 0) {
                                        stat[i257]++;
                                        stat[i260]--;
                                        i258--;
                                    } else {
                                        stat[i257]--;
                                        stat[i260]++;
                                        i258++;
                                    }
                                } else
                                    i259++;
                        }
                    }
                    if (i == 10) {
                        carsel = simcar.getSelectedIndex();
                        int i261 = 0;
                        for (int i262 = 0; i262 < 5; i262++) {
                            stat[i262] = carstat[carsel][i262];
                            i261 += stat[i262];
                        }
                        clsel = 4 - (i261 - 520) / 40;
                        cls.select(clsel);
                    }
                    if (i == 11) {
                        final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        String string263 = "";
                        int i264 = 0;
                        int i265 = string.indexOf("\n", 0);
                        while (i265 != -1 && i264 < string.length()) {
                            String string266 = string.substring(i264, i265);
                            string266 = string266.trim();
                            i264 = i265 + 1;
                            i265 = string.indexOf("\n", i264);
                            if (!string266.startsWith("stat("))
                                string263 = new StringBuilder().append(string263).append("").append(string266)
                                        .append("\n").toString();
                            else {
                                string263 = string263.trim();
                                string263 = new StringBuilder().append(string263).append("\n").toString();
                            }
                        }
                        string263 = string263.trim();
                        string263 = new StringBuilder().append(string263).append("\n\n\nstat(").append(stat[0])
                                .append(",").append(stat[1]).append(",").append(stat[2]).append(",").append(stat[3])
                                .append(",").append(stat[4]).append(")\n\n\n\n").toString();
                        editor.setText(string263);
                        savefile();
                        for (int i267 = 0; i267 < 5; i267++)
                            rstat[i267] = stat[i267];
                        changed2 = false;
                    }
                    if (i == 12)
                        for (int i268 = 0; i268 < 5; i268++)
                            stat[i268] = rstat[i268];
                    i206 = 13;
                }
            if (dtab == 5) {
                if (pfase == 0) {
                    for (int i269 = 0; i269 < 4; i269++) {
                        if (i == 1 + i269 * 2) {
                            phys[i269] += 2;
                            if (phys[i269] > 100)
                                phys[i269] = 100;
                        }
                        if (i == i269 * 2) {
                            phys[i269] -= 2;
                            if (phys[i269] < 0)
                                phys[i269] = 0;
                        }
                    }
                    if (i == 8)
                        for (int i270 = 0; i270 < 5; i270++)
                            phys[i270] = (int) (Math.random() * 100.0);
                    if (i == 9)
                        for (int i271 = 0; i271 < 5; i271++)
                            phys[i271] = rphys[i271];
                    if (i == 10) {
                        pfase = 1;
                        i = -1;
                    }
                    i206 = 11;
                }
                if (pfase == 1) {
                    for (int i272 = 0; i272 < 6; i272++) {
                        if (i == 1 + i272 * 2) {
                            phys[i272 + 5] += 2;
                            if (phys[i272 + 5] > 100)
                                phys[i272 + 5] = 100;
                        }
                        if (i == i272 * 2) {
                            phys[i272 + 5] -= 2;
                            if (phys[i272 + 5] < 0)
                                phys[i272 + 5] = 0;
                        }
                    }
                    if (i == 12)
                        for (int i273 = 0; i273 < 6; i273++)
                            phys[i273 + 5] = (int) (Math.random() * 100.0);
                    if (i == 13)
                        for (int i274 = 0; i274 < 6; i274++)
                            phys[i274 + 5] = rphys[i274 + 5];
                    if (i == 14) {
                        pfase = 0;
                        i = -1;
                    }
                    if (i == 15) {
                        pfase = 2;
                        i = -1;
                    }
                    i206 = 16;
                }
                if (pfase == 2) {
                    for (int i275 = 0; i275 < 3; i275++) {
                        if (i == 1 + i275 * 2) {
                            crash[i275] += 2;
                            if (crash[i275] > 100)
                                crash[i275] = 100;
                        }
                        if (i == i275 * 2) {
                            crash[i275] -= 2;
                            if (crash[i275] < 0)
                                crash[i275] = 0;
                        }
                    }
                    if (i == 6) {
                        int i276 = (int) (150.0 + 600.0 * Math.random());
                        boolean bool = false;
                        boolean bool277 = false;
                        if (Math.random() > Math.random())
                            bool = true;
                        if (Math.random() > Math.random())
                            bool277 = true;
                        final int[] is = {
                                -101, -101, -101, -101
                        };
                        is[0] = (int) (Math.random() * 4.0);
                        if (Math.random() > Math.random()) {
                            if (bool277)
                                is[1] = is[0] + 1;
                            else
                                is[1] = is[0] - 1;
                            if (Math.random() > Math.random()) {
                                if (bool277)
                                    is[2] = is[1] + 1;
                                else
                                    is[2] = is[1] - 1;
                                if (Math.random() > Math.random())
                                    if (bool277)
                                        is[3] = is[2] + 1;
                                    else
                                        is[3] = is[2] - 1;
                            }
                        }
                        if (Math.random() > Math.random())
                            crashup = false;
                        else
                            crashup = true;
                        for (int i278 = 0; i278 < 4; i278++)
                            if (is[i278] != -101) {
                                if (is[i278] >= 4)
                                    is[i278] -= 4;
                                if (is[i278] <= -1)
                                    is[i278] += 4;
                                i276 -= 50 * i278;
                                if (i276 < 150)
                                    i276 = 150;
                                if (bool)
                                    regx(is[i278], i276, false);
                                else
                                    regz(is[i278], i276, false);
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
                        for (int i279 = 0; i279 < 3; i279++)
                            crash[i279] = rcrash[i279];
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
                    i206 = 13;
                }
                if (pfase == 3) {
                    for (int i280 = 0; i280 < 5; i280++) {
                        if (i == i280) {
                            for (int i281 = 0; i281 < 5; i281++)
                                for (int i282 = 0; i282 < 5; i282++)
                                    engs[i282][i281].stop();
                            engs[engsel][i280].loop();
                            engon = true;
                        }
                        if (i == 5) {
                            for (int i283 = 0; i283 < 5; i283++)
                                for (int i284 = 0; i284 < 5; i284++)
                                    engs[i284][i283].stop();
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
                    i206 = 8;
                }
            }
            if (dtab == 6)
                if (!rateh) {
                    if (i == 0 && checko("Test Drive")) {
                        Madness.testcar = carname;
                        Madness.testdrive = witho.getSelectedIndex() + 1;
                        Madness.game();
                    }
                    i206 = 1;
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
                        i206 = 4;
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
                        final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        String string285 = "";
                        int i286 = 0;
                        int i287 = string.indexOf("\n", 0);
                        while (i287 != -1 && i286 < string.length()) {
                            String string288 = string.substring(i286, i287);
                            string288 = string288.trim();
                            i286 = i287 + 1;
                            i287 = string.indexOf("\n", i286);
                            if (!string288.startsWith("handling("))
                                string285 = new StringBuilder().append(string285).append("").append(string288)
                                        .append("\n").toString();
                            else {
                                string285 = string285.trim();
                                string285 = new StringBuilder().append(string285).append("\n").toString();
                            }
                        }
                        string285 = string285.trim();
                        string285 = new StringBuilder().append(string285).append("\n\n\nhandling(").append(handling)
                                .append(")\n\n\n\n").toString();
                        editor.setText(string285);
                        savefile();
                        rateh = false;
                    }
                    if (i == 3)
                        rateh = false;
                    i206 = 4;
                }
            if (i == i206) {
                for (int i289 = 0; i289 < o.npl; i289++) {
                    Color.RGBtoHSB(o.p[i289].c[0], o.p[i289].c[1], o.p[i289].c[2], o.p[i289].hsb);
                    if (o.p[i289].gr == -13)
                        o.p[i289].gr = 1;
                }
                polynum = -1;
            }
            i = -1;
        }
        if (tab == 3) {
            if (i == 0) {
                if (logged == 0)
                    JOptionPane.showMessageDialog(null,
                            "Please login to retrieve your account first before publishing!", "Car Maker", 1);
                if ((logged == 3 || logged == -1) && checko("Publishing")) {
                    int i290 = 0;
                    for (int i291 = 0; i291 < nmc; i291++)
                        if (mycars[i291].equals(carname) && maker[i291].equals(tnick.getText()))
                            i290 = JOptionPane
                                    .showConfirmDialog(null,
                                            new StringBuilder().append("Replace your already online car '")
                                                    .append(carname).append("' with this one?").toString(),
                                            "Car Maker", 0);
                    if (i290 == 0) {
                        setCursor(new Cursor(3));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(225, 225, 225));
                        rd.fillRect(11, 141, 679, 401);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("Connecting to Server...", 350 - ftm.stringWidth("Connecting to Server...") / 2,
                                250);
                        repaint();
                        int i292 = 0;
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        int i293 = 0;
                        int i294 = string.indexOf("\n", 0);
                        while (i294 != -1 && i293 < string.length()) {
                            i293 = i294 + 1;
                            i294 = string.indexOf("\n", i293);
                            i292++;
                        }
                        int i295 = -1;
                        try {
                            final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                            final BufferedReader bufferedreader = new BufferedReader(
                                    new InputStreamReader(socket.getInputStream()));
                            final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                            printwriter.println(new StringBuilder().append("10|").append(tnick.getText()).append("|")
                                    .append(tpass.getText()).append("|").append(carname).append("|")
                                    .append(pubtyp.getSelectedIndex()).append("|").toString());
                            String string296 = bufferedreader.readLine();
                            if (string296 != null)
                                i295 = 0;
                            // i295 = servervalue(string296, 0);
                            if (i295 == 0) {
                                int i297 = 0;
                                string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                        .toString();
                                i293 = 0;
                                i294 = string.indexOf("\n", 0);
                                while (i294 != -1 && i293 < string.length()) {
                                    String string298 = string.substring(i293, i294);
                                    string298 = string298.trim();
                                    printwriter.println(string298);
                                    i293 = i294 + 1;
                                    i294 = string.indexOf("\n", i293);
                                    i297++;
                                    rd.setColor(new Color(225, 225, 225));
                                    rd.fillRect(11, 141, 679, 401);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("Publishing Car...", 350 - ftm.stringWidth("Publishing Car...") / 2,
                                            250);
                                    rd.setColor(new Color(119, 147, 191));
                                    rd.fillRect(250, 270, (int) ((float) i297 / (float) i292 * 200.0F), 7);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawRect(250, 270, 200, 7);
                                    repaint();
                                    try {
                                        if (thredo != null) {
                                            
                                        }
                                        Thread.sleep(10L);
                                    } catch (final InterruptedException interruptedexception) {
                                        
                                    }
                                }
                                printwriter.println("QUITX1111");
                                rd.setColor(new Color(225, 225, 225));
                                rd.fillRect(11, 141, 679, 401);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString("Creating the car online...",
                                        350 - ftm.stringWidth("Creating the car online...") / 2, 250);
                                rd.drawString("This may take a couple of minutes, please wait...",
                                        350 - ftm.stringWidth("This may take a couple of minutes, please wait...") / 2,
                                        280);
                                repaint();
                                string296 = bufferedreader.readLine();
                                if (string296 != null)
                                    i295 = servervalue(string296, 0);
                            }
                            socket.close();
                        } catch (final Exception exception) {
                            i295 = -1;
                        }
                        setCursor(new Cursor(0));
                        boolean bool = false;
                        if (i295 == 0) {
                            logged = 1;
                            bool = true;
                        }
                        if (i295 == 3) {
                            JOptionPane.showMessageDialog(null,
                                    "Unable to publish car.\nReason:\nCar name is too large.  Please rename your car.  Car name must be less then 15 characters.",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 4) {
                            JOptionPane.showMessageDialog(null,
                                    new StringBuilder().append("Unable to publish car.\nReason:  Car name used (")
                                            .append(carname).append(").\nThe name '").append(carname)
                                            .append("' is already used by another published car.  Please rename your car.")
                                            .toString(),
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 6) {
                            JOptionPane.showMessageDialog(null,
                                    "Error Creating Car!\nReason:\nError loading 3D model!  Format maybe incorrect!",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 7) {
                            JOptionPane.showMessageDialog(null,
                                    "Error Creating Car!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 8) {
                            JOptionPane.showMessageDialog(null,
                                    "Error Creating Car!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 9) {
                            JOptionPane.showMessageDialog(null,
                                    "Error Creating Car!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the \u2018Car\u2019 tab to find the tutorial on how to build a car.",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 10) {
                            JOptionPane.showMessageDialog(null,
                                    "Error Creating Car!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 10000.\nPlease use the counter in the \u2018Code Edit\u2019 to decrease the number of polygons (pieces).",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 11) {
                            JOptionPane.showMessageDialog(null,
                                    new StringBuilder()
                                            .append("Error Creating Car!\nReason:\nCar scale size is too large!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled down by ")
                                            .append((int) ((o.maxR / 400.0F - 1.0F) * 100.0F)).append("%.\n")
                                            .toString(),
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 12) {
                            JOptionPane.showMessageDialog(null,
                                    new StringBuilder()
                                            .append("Error Creating Car!\nReason:\nCar scale size is too small!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled up by ")
                                            .append((int) ((120.0F / o.maxR - 1.0F) * 100.0F)).append("%.\n")
                                            .toString(),
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 13) {
                            JOptionPane.showMessageDialog(null,
                                    "Error Creating Car!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 14) {
                            JOptionPane.showMessageDialog(null,
                                    "Error Creating Car!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 == 15) {
                            JOptionPane.showMessageDialog(null,
                                    "Error Creating Car!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (i295 > 15) {
                            JOptionPane.showMessageDialog(null,
                                    "Unable to publish car fully!  Unknown Error.  Please try again later.\n",
                                    "Car Maker", 1);
                            bool = true;
                        }
                        if (!bool)
                            JOptionPane.showMessageDialog(null, "Unable to publish car!  Unknown Error.\n", "Car Maker",
                                    1);
                    }
                }
            }
            if (logged == 0) {
                if (i == 1) {
                    setCursor(new Cursor(3));
                    int i299 = -1;
                    try {
                        final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                        final BufferedReader bufferedreader = new BufferedReader(
                                new InputStreamReader(socket.getInputStream()));
                        final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                        printwriter.println(new StringBuilder().append("1|").append(tnick.getText().toLowerCase())
                                .append("|").append(tpass.getText()).append("|").toString());
                        final String string = bufferedreader.readLine();
                        if (string != null)
                            i299 = servervalue(string, 0);
                        socket.close();
                    } catch (final Exception exception) {
                        i299 = -1;
                    }
                    if (i299 == 0 || i299 == 3 || i299 > 10) {
                        tnick.setVisible(false);
                        tpass.setVisible(false);
                        logged = 1;
                        savesettings();
                    }
                    if (i299 == 1 || i299 == 2) {
                        setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Car Maker", 0);
                    }
                    if (i299 == -167) {
                        setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null,
                                "Sorry.  Trial accounts are not allowed to publish cars & stages, please register a full account!",
                                "Car Maker", 0);
                    }
                    if (i299 == -1) {
                        setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null,
                                "Unable to connect to server at this moment, please try again later.", "Car Maker", 1);
                    }
                }
                if (i == 2)
                    Madness.openurl("http://multiplayer.needformadness.com/register.html");
            }
        }
    }

    public void delcar(final String string) {
        if (string.equals(""))
            JOptionPane.showMessageDialog(null, "Please Select a Car to Delete!\n", "Car Maker", 1);
        else {
            final int i = JOptionPane.showConfirmDialog(null, new StringBuilder()
                    .append("Are you sure you want to delete car :  ").append(string).append(" ?  ").toString(),
                    "Car Maker", 0);
            if (i == 0)
                try {
                    final File file = new File(
                            new StringBuilder().append("mycars/").append(string).append(".rad").toString());
                    file.delete();
                    slcar.remove(string);
                    slcar.select(0);
                } catch (final Exception exception) {
                    JOptionPane.showMessageDialog(null, new StringBuilder()
                            .append("Unable to delete file! Error Deatials:\n").append(exception).toString(),
                            "Car Maker", 1);
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
        final String string360 = "\\";
        String string361 = "";
        int i = 0;
        int i362 = -1;
        for (/**/; i < string.length(); i++) {
            final String string363 = new StringBuilder().append("").append(string.charAt(i)).toString();
            if (string363.equals("|") || string363.equals(",") || string363.equals("(") || string363.equals(")")
                    || string363.equals("#") || string363.equals(string360) || string363.equals("!")
                    || string363.equals("?") || string363.equals("~") || string363.equals(".") || string363.equals("@")
                    || string363.equals("$") || string363.equals("%") || string363.equals("^") || string363.equals("&")
                    || string363.equals("*") || string363.equals("+") || string363.equals("=") || string363.equals(">")
                    || string363.equals("<") || string363.equals("/") || string363.equals("'") || string363.equals(";")
                    || string363.equals(":") || i > 15)
                i362 = i;
            else
                string361 = new StringBuilder().append(string361).append(string363).toString();
        }
        if (i362 != -1) {
            textfield.setText(string361);
            textfield.select(i362, i362);
        }
    }

    public Image getImage(final String string) {
        final Image image = Toolkit.getDefaultToolkit().createImage(string);
        final MediaTracker mediatracker = new MediaTracker(this);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (final Exception exception) {
            
        }
        return image;
    }

    public String getSvalue(final String string, final String string369, final int i) {
        String string370 = "";
        int i371 = 0;
        for (int i372 = string.length() + 1; i372 < string369.length() && i371 <= i; i372++) {
            final String string373 = new StringBuilder().append("").append(string369.charAt(i372)).toString();
            if (string373.equals(",") || string373.equals(")"))
                i371++;
            else if (i371 == i)
                string370 = new StringBuilder().append(string370).append(string373).toString();
        }
        return string370;
    }

    public int getvalue(final String string, final String string364, final int i) {
        int i365 = 0;
        String string366 = "";
        for (int i367 = string.length() + 1; i367 < string364.length(); i367++) {
            final String string368 = new StringBuilder().append("").append(string364.charAt(i367)).toString();
            if (string368.equals(",") || string368.equals(")")) {
                i365++;
                i367++;
            }
            if (i365 == i)
                string366 = new StringBuilder().append(string366).append(string364.charAt(i367)).toString();
        }
        return Float.valueOf(string366).intValue();
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
        slcar.setFont(new Font("Arial", 1, 13));
        slcar.add(rd, "Select a Car...         ");
        slcar.setForeground(new Color(63, 80, 110));
        slcar.setBackground(new Color(209, 217, 230));
        fontsel.setFont(new Font("Arial", 1, 12));
        fontsel.add(rd, "Arial");
        fontsel.add(rd, "Dialog");
        fontsel.add(rd, "DialogInput");
        fontsel.add(rd, "Monospaced");
        fontsel.add(rd, "Serif");
        fontsel.add(rd, "SansSerif");
        fontsel.add(rd, "Verdana");
        fontsel.setBackground(new Color(63, 80, 110));
        fontsel.setForeground(new Color(209, 217, 230));
        ctheme.setFont(new Font("Arial", 1, 12));
        ctheme.add(rd, "Default");
        ctheme.add(rd, "Author");
        ctheme.add(rd, "Dos");
        ctheme.add(rd, "Green");
        ctheme.add(rd, "The Matrix");
        ctheme.add(rd, "Ice Age");
        ctheme.add(rd, "Fire");
        ctheme.add(rd, "Ocean");
        ctheme.setBackground(new Color(63, 80, 110));
        ctheme.setForeground(new Color(209, 217, 230));
        compcar.setFont(new Font("Arial", 1, 12));
        compcar.add(rd, "Compare Car...");
        compcar.add(rd, "Tornado Shark");
        compcar.add(rd, "Formula 7");
        compcar.add(rd, "Wow Caninaro");
        compcar.add(rd, "La Vita Crab");
        compcar.add(rd, "Nimi");
        compcar.add(rd, "MAX Revenge");
        compcar.add(rd, "Lead Oxide");
        compcar.add(rd, "Kool Kat");
        compcar.add(rd, "Drifter X");
        compcar.add(rd, "Sword of Justice");
        compcar.add(rd, "High Rider");
        compcar.add(rd, "EL KING");
        compcar.add(rd, "Mighty Eight");
        compcar.add(rd, "M A S H E E N");
        compcar.add(rd, "Radical One");
        compcar.add(rd, "DR Monstaa");
        compcar.add(rd, " -  None  - ");
        compcar.setBackground(new Color(63, 80, 110));
        compcar.setForeground(new Color(209, 217, 230));
        cls.setFont(new Font("Arial", 1, 12));
        cls.add(rd, "Class A");
        cls.add(rd, "Class A & B");
        cls.add(rd, "Class B");
        cls.add(rd, "Class B & C");
        cls.add(rd, "Class C");
        cls.setBackground(new Color(63, 80, 110));
        cls.setForeground(new Color(209, 217, 230));
        simcar.setFont(new Font("Arial", 1, 12));
        simcar.add(rd, "Tornado Shark");
        simcar.add(rd, "Formula 7");
        simcar.add(rd, "Wow Caninaro");
        simcar.add(rd, "La Vita Crab");
        simcar.add(rd, "Nimi");
        simcar.add(rd, "MAX Revenge");
        simcar.add(rd, "Lead Oxide");
        simcar.add(rd, "Kool Kat");
        simcar.add(rd, "Drifter X");
        simcar.add(rd, "Sword of Justice");
        simcar.add(rd, "High Rider");
        simcar.add(rd, "EL KING");
        simcar.add(rd, "Mighty Eight");
        simcar.add(rd, "M A S H E E N");
        simcar.add(rd, "Radical One");
        simcar.add(rd, "DR Monstaa");
        simcar.setBackground(new Color(63, 80, 110));
        simcar.setForeground(new Color(209, 217, 230));
        witho.setFont(new Font("Arial", 1, 12));
        witho.add(rd, "With other cars");
        witho.add(rd, "Alone");
        witho.setBackground(new Color(63, 80, 110));
        witho.setForeground(new Color(209, 217, 230));
        engine.setFont(new Font("Arial", 1, 12));
        engine.add(rd, "Normal Engine");
        engine.add(rd, "V8 Engine");
        engine.add(rd, "Retro Engine");
        engine.add(rd, "Power Engine");
        engine.add(rd, "Diesel Engine");
        engine.setBackground(new Color(63, 80, 110));
        engine.setForeground(new Color(209, 217, 230));
        final MenuItem menuitem = new MenuItem("Cut");
        final MenuItem menuitem340 = new MenuItem("Copy");
        final MenuItem menuitem341 = new MenuItem("Paste");
        final MenuItem menuitem342 = new MenuItem("Select All");
        popupMenu = new PopupMenu();
        popupMenu.add(menuitem);
        popupMenu.add(menuitem340);
        popupMenu.add(menuitem341);
        popupMenu.add(menuitem342);
        menuitem.addActionListener(this);
        menuitem340.addActionListener(this);
        menuitem341.addActionListener(this);
        menuitem342.addActionListener(this);
        add(popupMenu);
        for (int i = 0; i < 16; i++) {
            wv[i] = new TextField("", 2);
            wv[i].setBackground(new Color(255, 255, 255));
            wv[i].setForeground(new Color(0, 0, 0));
            wv[i].setFont(new Font(cfont, 1, 14));
            wv[i].addMouseListener(new MouseHandler(popupMenu, i));
            add(wv[i]);
        }
        tnick.setFont(new Font("Arial", 1, 13));
        tnick.setBackground(new Color(255, 255, 255));
        tnick.setForeground(new Color(0, 0, 0));
        tpass.setFont(new Font("Arial", 1, 13));
        tpass.setEchoCharacter('*');
        tpass.setBackground(new Color(255, 255, 255));
        tpass.setForeground(new Color(0, 0, 0));
        pubtyp.setFont(new Font("Arial", 1, 13));
        pubtyp.add(rd, "Private");
        pubtyp.add(rd, "Public");
        pubtyp.add(rd, "Super Public");
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
        final String[] strings = {
                "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat",
                "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster"
        };
        try {
            final File file = new File("data/models.zip");
            final ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));
            ZipEntry zipentry = zipinputstream.getNextEntry();
            for (/**/; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = -1;
                for (int i356 = 0; i356 < 16; i356++)
                    if (zipentry.getName().startsWith(strings[i356]))
                        i = i356;
                if (i != -1) {
                    int i357 = (int) zipentry.getSize();
                    final byte[] is = new byte[i357];
                    int i358 = 0;
                    int i359;
                    for (/**/; i357 > 0; i357 -= i359) {
                        i359 = zipinputstream.read(is, i358, i357);
                        i358 += i359;
                    }
                    compo[i] = new ContO(is, m, t);
                    compo[i].shadow = false;
                    compo[i].noline = true;
                }
            }
            zipinputstream.close();
        } catch (final Exception exception) {
            System.out.println(
                    new StringBuilder().append("Error Loading Models from Zip: ").append(exception).toString());
        }
        System.gc();
    }

    public void loadfile() {
        loadedfile = false;
        lastedo = "";
        try {
            final File file = new File(new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
            final BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
            String string;
            while ((string = bufferedreader.readLine()) != null) {
                final StringBuilder stringbuilder = new StringBuilder();
                final CarMaker carmaker300 = this;
                carmaker300.lastedo = stringbuilder.append(carmaker300.lastedo).append("").append(string).append("\n")
                        .toString();
            }
            loadedfile = true;
            bufferedreader.close();
        } catch (final Exception exception) {
            loadedfile = false;
            lastedo = "";
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Unable to load file! Error Deatials:\n").append(exception).toString(),
                    "Car Maker", 1);
        }
        editor.setText(lastedo);
    }

    public void loadsettings() {
        try {
            final File file = new File("mycars/settings.data");
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
                    if (!suser.equals("Horaks"))
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
            
        }
    }

    public void loadsounds() {
        try {
            final File file = new File("data/sounds.zip");
            final FileInputStream fileinputstream = new FileInputStream(file);
            final ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
            for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream
                    .getNextEntry()) {
                int i = (int) zipentry.getSize();
                final String string = zipentry.getName();
                final byte[] is = new byte[i];
                int i350 = 0;
                int i351;
                for (/**/; i > 0; i -= i351) {
                    i351 = zipinputstream.read(is, i350, i);
                    i350 += i351;
                }
                for (int i352 = 0; i352 < 5; i352++)
                    for (int i353 = 0; i353 < 5; i353++)
                        if (string.equals(new StringBuilder().append("").append(i353).append("").append(i352)
                                .append(".wav").toString()))
                            engs[i353][i352] = new soundClip(is);
                for (int i354 = 0; i354 < 3; i354++)
                    if (string.equals(new StringBuilder().append("crash").append(i354 + 1).append(".wav").toString()))
                        crashs[i354] = new soundClip(is);
                for (int i355 = 0; i355 < 3; i355++)
                    if (string
                            .equals(new StringBuilder().append("lowcrash").append(i355 + 1).append(".wav").toString()))
                        lowcrashs[i355] = new soundClip(is);
            }
            fileinputstream.close();
            zipinputstream.close();
        } catch (final Exception exception) {
            System.out.println(new StringBuilder().append("Error Loading Sounds: ").append(exception).toString());
        }
        System.gc();
    }

    @Override
    public boolean lostFocus(final Event event, final Object object) {
        focuson = false;
        return false;
    }

    @Override
    public boolean mouseDown(final Event event, final int i, final int i347) {
        xm = i - apx;
        ym = i347 - apy;
        mouses = 1;
        mousdr = true;
        if (tab != 1)
            requestFocus();
        return false;
    }

    @Override
    public boolean mouseDrag(final Event event, final int i, final int i349) {
        mousdr = true;
        xm = i - apx;
        ym = i349 - apy;
        return false;
    }

    @Override
    public boolean mouseMove(final Event event, final int i, final int i348) {
        xm = i - apx;
        ym = i348 - apy;
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
    public boolean mouseUp(final Event event, final int i, final int i346) {
        xm = i - apx;
        ym = i346 - apy;
        if (waso)
            waso = false;
        else
            mouses = -1;
        mousdr = false;
        if (onbtgame)
            Madness.game();
        return false;
    }

    public void movefield(final Component component, int i, int i343, final int i344, final int i345) {
        i += apx;
        i343 += apy;
        if (component.getX() != i || component.getY() != i343 || component.getWidth() != i344
                || component.getHeight() != i345)
            component.setBounds(i, i343, i344, i345);
    }

    public void newcar(final String string) {
        if (string.equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter a Car Name!\n", "Car Maker", 1);
        else {
            final String string302 = new StringBuilder().append("\n// car: ").append(string)
                    .append("\n---------------------\n\n// To start making you car you must start by reading the tutorial at:\n// http://www.needformadness.com/developer/simplecar.html\n\n\n<p>\nc(100,200,100)\n\np(-40,-50,80)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-50,80)\n</p>\n\n<p>\nc(100,150,200)\n\np(-40,-20,-100)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-20,-100)\n</p>\n\n\n\n")
                    .toString();
            try {
                File file = new File("mycars/");
                if (!file.exists())
                    file.mkdirs();
                carname = string;
                file = new File(new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
                if (!file.exists()) {
                    final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                    bufferedwriter.write(string302);
                    bufferedwriter.close();
                    if (file.exists()) {
                        sfase = 0;
                        hidefields();
                        tabed = -1;
                    } else
                        JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
                } else
                    JOptionPane.showMessageDialog(null,
                            new StringBuilder().append("A car with the name '").append(carname)
                                    .append("' already exists, please choose another name!\n").toString(),
                            "Car Maker", 1);
            } catch (final Exception exception) {
                carname = "";
                JOptionPane.showMessageDialog(null, new StringBuilder()
                        .append("Unable to create file! Error Deatials:\n").append(exception).toString(), "Car Maker",
                        1);
            }
        }
    }

    public int objvalue(final String string, final int i) {
        int i386 = 0;
        try {
            int i387 = 2;
            int i388 = 0;
            int i389 = 0;
            String string390 = "";
            String string391 = "";
            boolean bool = false;
            for (/**/; i387 < string.length() && i389 != 2; i387++) {
                string390 = new StringBuilder().append("").append(string.charAt(i387)).toString();
                if (string390.equals(" ")) {
                    if (bool) {
                        i388++;
                        bool = false;
                    }
                    if (i389 == 1 || i388 > i)
                        i389 = 2;
                } else {
                    if (i388 == i) {
                        string391 = new StringBuilder().append(string391).append(string390).toString();
                        i389 = 1;
                    }
                    bool = true;
                }
            }
            if (i387 >= string.length())
                objfacend = true;
            if (string391.equals(""))
                string391 = "0";
            if (multf10)
                i386 = (int) (Float.valueOf(string391).floatValue() * 10.0F);
            else {
                final int i392 = string391.indexOf("/", 0);
                if (i392 != -1)
                    string391 = string391.substring(0, i392);
                i386 = Float.valueOf(string391).intValue() - 1;
                if (i386 < 0)
                    i386 = 0;
            }
        } catch (final Exception exception) {
            
        }
        return i386;
    }

    public void openelink() {
        Madness.openurl("http://www.needformadness.com/developer/extras.html");
    }

    public void openhlink() {
        Madness.openurl("http://www.needformadness.com/developer/");
    }

    public void openlink() {
        Madness.openurl("http://www.needformadness.com/developer/simplecar.html");
    }

    public boolean ovbutton(final String string, final int i, final int i395) {
        rd.setFont(new Font("Arial", 0, 12));
        ftm = rd.getFontMetrics();
        if (string.equals("X") || string.equals("Download")) {
            rd.setFont(new Font("Arial", 1, 12));
            ftm = rd.getFontMetrics();
        }
        final int i396 = ftm.stringWidth(string);
        final int i397 = 4;
        boolean bool = false;
        boolean bool398 = false;
        if (Math.abs(xm - i) < i396 / 2 + 12 && Math.abs(ym - i395 + 5) < 10 && mouses == 1)
            bool = true;
        else
            bool = false;
        if (Math.abs(xm - i) < i396 / 2 + 12 && Math.abs(ym - i395 + 5) < 10 && mouses == -1) {
            mouses = 0;
            bool398 = true;
        }
        if (!bool) {
            rd.setColor(new Color(220, 220, 220));
            rd.fillRect(i - i396 / 2 - 10, i395 - (17 - i397), i396 + 20, 25 - i397 * 2);
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i396 / 2 - 10, i395 - (17 - i397), i + i396 / 2 + 10, i395 - (17 - i397));
            rd.drawLine(i - i396 / 2 - 10, i395 - (18 - i397), i + i396 / 2 + 10, i395 - (18 - i397));
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i396 / 2 - 9, i395 - (19 - i397), i + i396 / 2 + 9, i395 - (19 - i397));
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i + i396 / 2 + 10, i395 - (17 - i397), i + i396 / 2 + 10, i395 + 7 - i397);
            rd.drawLine(i + i396 / 2 + 11, i395 - (17 - i397), i + i396 / 2 + 11, i395 + 7 - i397);
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i + i396 / 2 + 12, i395 - (16 - i397), i + i396 / 2 + 12, i395 + 6 - i397);
            rd.drawLine(i - i396 / 2 - 10, i395 + 7 - i397, i + i396 / 2 + 10, i395 + 7 - i397);
            rd.drawLine(i - i396 / 2 - 10, i395 + 8 - i397, i + i396 / 2 + 10, i395 + 8 - i397);
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i - i396 / 2 - 9, i395 + 9 - i397, i + i396 / 2 + 9, i395 + 9 - i397);
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i396 / 2 - 10, i395 - (17 - i397), i - i396 / 2 - 10, i395 + 7 - i397);
            rd.drawLine(i - i396 / 2 - 11, i395 - (17 - i397), i - i396 / 2 - 11, i395 + 7 - i397);
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i396 / 2 - 12, i395 - (16 - i397), i - i396 / 2 - 12, i395 + 6 - i397);
            rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                rd.setColor(new Color(0, 64, 128));
            rd.drawString(string, i - i396 / 2, i395);
        } else {
            rd.setColor(new Color(220, 220, 220));
            rd.fillRect(i - i396 / 2 - 10, i395 - (17 - i397), i396 + 20, 25 - i397 * 2);
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - i396 / 2 - 10, i395 - (17 - i397), i + i396 / 2 + 10, i395 - (17 - i397));
            rd.drawLine(i - i396 / 2 - 10, i395 - (18 - i397), i + i396 / 2 + 10, i395 - (18 - i397));
            rd.drawLine(i - i396 / 2 - 9, i395 - (19 - i397), i + i396 / 2 + 9, i395 - (19 - i397));
            rd.setColor(new Color(247, 247, 247));
            rd.drawLine(i + i396 / 2 + 10, i395 - (17 - i397), i + i396 / 2 + 10, i395 + 7 - i397);
            rd.drawLine(i + i396 / 2 + 11, i395 - (17 - i397), i + i396 / 2 + 11, i395 + 7 - i397);
            rd.drawLine(i + i396 / 2 + 12, i395 - (16 - i397), i + i396 / 2 + 12, i395 + 6 - i397);
            rd.drawLine(i - i396 / 2 - 10, i395 + 7 - i397, i + i396 / 2 + 10, i395 + 7 - i397);
            rd.drawLine(i - i396 / 2 - 10, i395 + 8 - i397, i + i396 / 2 + 10, i395 + 8 - i397);
            rd.drawLine(i - i396 / 2 - 9, i395 + 9 - i397, i + i396 / 2 + 9, i395 + 9 - i397);
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - i396 / 2 - 10, i395 - (17 - i397), i - i396 / 2 - 10, i395 + 7 - i397);
            rd.drawLine(i - i396 / 2 - 11, i395 - (17 - i397), i - i396 / 2 - 11, i395 + 7 - i397);
            rd.drawLine(i - i396 / 2 - 12, i395 - (16 - i397), i - i396 / 2 - 12, i395 + 6 - i397);
            rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                rd.setColor(new Color(0, 64, 128));
            rd.drawString(string, i - i396 / 2 + 1, i395 + 1);
        }
        return bool398;
    }

    @Override
    public void paint(final Graphics graphics) {
        apx = getWidth() / 2 - 350;
        apy = getHeight() / 2 - 275;
        graphics.drawImage(offImage, apx, apy, this);
    }

    public int py(final int i, final int i328, final int i329, final int i330) {
        return (i - i328) * (i - i328) + (i329 - i330) * (i329 - i330);
    }

    public void regx(final int i, float f, final boolean bool) {
        hitmag += f;
        if (!bool)
            crash(f);
        f *= 0.3F + crash[1] * 0.005F;
        if (Math.abs(f) > 100.0F) {
            int i315 = (int) (crash[0] * crash[0] * 1.5);
            if (i315 < 1000)
                i315 = 1000;
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            for (int i316 = 0; i316 < o.npl; i316++) {
                float f317 = 0.0F;
                for (int i318 = 0; i318 < o.p[i316].n; i318++)
                    if (o.p[i316].wz == 0 && py(o.keyx[i], o.p[i316].ox[i318], o.keyz[i], o.p[i316].oz[i318]) < i315) {
                        f317 = f / 20.0F * m.random();
                        o.p[i316].oz[i318] -= f317 * m.sin(o.xz) * m.cos(o.zy);
                        o.p[i316].ox[i318] += f317 * m.cos(o.xz) * m.cos(o.xy);
                        if (bool)
                            actmag += Math.abs(f317);
                    }
                if (f317 != 0.0F) {
                    if (Math.abs(f317) >= 1.0F) {
                        o.p[i316].chip = 1;
                        o.p[i316].ctmag = f317;
                    }
                    if (!o.p[i316].nocol && o.p[i316].glass != 1) {
                        if (o.p[i316].bfase > 20 && o.p[i316].hsb[1] > 0.25)
                            o.p[i316].hsb[1] = 0.25F;
                        if (o.p[i316].bfase > 25 && o.p[i316].hsb[2] > 0.7)
                            o.p[i316].hsb[2] = 0.7F;
                        if (o.p[i316].bfase > 30 && o.p[i316].hsb[1] > 0.15)
                            o.p[i316].hsb[1] = 0.15F;
                        if (o.p[i316].bfase > 35 && o.p[i316].hsb[2] > 0.6)
                            o.p[i316].hsb[2] = 0.6F;
                        if (o.p[i316].bfase > 40)
                            o.p[i316].hsb[0] = 0.075F;
                        if (o.p[i316].bfase > 50 && o.p[i316].hsb[2] > 0.5)
                            o.p[i316].hsb[2] = 0.5F;
                        if (o.p[i316].bfase > 60)
                            o.p[i316].hsb[0] = 0.05F;
                        o.p[i316].bfase += Math.abs(f317);
                        new Color(o.p[i316].c[0], o.p[i316].c[1], o.p[i316].c[2]);
                        final Color color = Color.getHSBColor(o.p[i316].hsb[0], o.p[i316].hsb[1], o.p[i316].hsb[2]);
                        o.p[i316].c[0] = color.getRed();
                        o.p[i316].c[1] = color.getGreen();
                        o.p[i316].c[2] = color.getBlue();
                    }
                    if (o.p[i316].glass == 1)
                        o.p[i316].gr += Math.abs(f317 * 1.5);
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
            int i319 = (int) (crash[0] * crash[0] * 1.5);
            if (i319 < 1000)
                i319 = 1000;
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            for (int i320 = 0; i320 < o.npl; i320++) {
                float f321 = 0.0F;
                for (int i322 = 0; i322 < o.p[i320].n; i322++)
                    if (o.p[i320].wz == 0 && py(o.keyx[i], o.p[i320].ox[i322], o.keyz[i], o.p[i320].oz[i322]) < i319) {
                        f321 = f / 20.0F * m.random();
                        o.p[i320].oz[i322] += f321 * m.cos(o.xz) * m.cos(o.zy);
                        o.p[i320].ox[i322] += f321 * m.sin(o.xz) * m.cos(o.xy);
                        if (bool)
                            actmag += Math.abs(f321);
                    }
                if (f321 != 0.0F) {
                    if (Math.abs(f321) >= 1.0F) {
                        o.p[i320].chip = 1;
                        o.p[i320].ctmag = f321;
                    }
                    if (!o.p[i320].nocol && o.p[i320].glass != 1) {
                        if (o.p[i320].bfase > 20 && o.p[i320].hsb[1] > 0.25)
                            o.p[i320].hsb[1] = 0.25F;
                        if (o.p[i320].bfase > 25 && o.p[i320].hsb[2] > 0.7)
                            o.p[i320].hsb[2] = 0.7F;
                        if (o.p[i320].bfase > 30 && o.p[i320].hsb[1] > 0.15)
                            o.p[i320].hsb[1] = 0.15F;
                        if (o.p[i320].bfase > 35 && o.p[i320].hsb[2] > 0.6)
                            o.p[i320].hsb[2] = 0.6F;
                        if (o.p[i320].bfase > 40)
                            o.p[i320].hsb[0] = 0.075F;
                        if (o.p[i320].bfase > 50 && o.p[i320].hsb[2] > 0.5)
                            o.p[i320].hsb[2] = 0.5F;
                        if (o.p[i320].bfase > 60)
                            o.p[i320].hsb[0] = 0.05F;
                        o.p[i320].bfase += Math.abs(f321);
                        new Color(o.p[i320].c[0], o.p[i320].c[1], o.p[i320].c[2]);
                        final Color color = Color.getHSBColor(o.p[i320].hsb[0], o.p[i320].hsb[1], o.p[i320].hsb[2]);
                        o.p[i320].c[0] = color.getRed();
                        o.p[i320].c[1] = color.getGreen();
                        o.p[i320].c[2] = color.getBlue();
                    }
                    if (o.p[i320].glass == 1)
                        o.p[i320].gr += Math.abs(f321 * 1.5);
                }
            }
        }
    }

    public void rencar(final String string) {
        if (string.equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter a New Car Name!\n", "Car Maker", 1);
        else
            try {
                final File file = new File(
                        new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
                final File file303 = new File(
                        new StringBuilder().append("mycars/").append(string).append(".rad").toString());
                if (file.renameTo(file303)) {
                    carname = string;
                    sfase = 0;
                    hidefields();
                    tabed = -1;
                } else
                    JOptionPane
                            .showMessageDialog(null,
                                    new StringBuilder().append("Unable to rename car to: '").append(string)
                                            .append("', possible reason: Car name already used!\n").toString(),
                                    "Car Maker", 1);
            } catch (final Exception exception) {
                JOptionPane.showMessageDialog(null, new StringBuilder()
                        .append("Unable to rename file! Error Deatials:\n").append(exception).toString(), "Car Maker",
                        1);
            }
    }

    public void roofsqsh(float f) {
        if (f > 100.0F) {
            crash(f);
            f -= 100.0F;
            final int i = (int) (2.0 + crash[2] / 7.6);
            int i323 = 0;
            int i324 = 1;
            for (int i325 = 0; i325 < o.npl; i325++) {
                float f326 = 0.0F;
                if (Math.random() > 0.9)
                    f326 = f / 15.0F * m.random();
                for (int i327 = 0; i327 < o.p[i325].n; i327++)
                    if (o.p[i325].wz == 0 && (Math.abs(o.p[i325].oy[i327] - o.roofat - squash) < i * 3
                            || o.p[i325].oy[i327] < o.roofat + squash) && squash < i) {
                        f326 = f / 15.0F * m.random();
                        o.p[i325].oy[i327] += f326;
                        i323 += f326;
                        i324++;
                        hitmag += Math.abs(f326);
                    }
                if (!o.p[i325].nocol && o.p[i325].glass != 1) {
                    if (f326 != 0.0F) {
                        if (o.p[i325].bfase > 20 && o.p[i325].hsb[1] > 0.25)
                            o.p[i325].hsb[1] = 0.25F;
                        if (o.p[i325].bfase > 25 && o.p[i325].hsb[2] > 0.7)
                            o.p[i325].hsb[2] = 0.7F;
                        if (o.p[i325].bfase > 30 && o.p[i325].hsb[1] > 0.15)
                            o.p[i325].hsb[1] = 0.15F;
                        if (o.p[i325].bfase > 35 && o.p[i325].hsb[2] > 0.6)
                            o.p[i325].hsb[2] = 0.6F;
                        if (o.p[i325].bfase > 40)
                            o.p[i325].hsb[0] = 0.075F;
                        if (o.p[i325].bfase > 50 && o.p[i325].hsb[2] > 0.5)
                            o.p[i325].hsb[2] = 0.5F;
                        if (o.p[i325].bfase > 60)
                            o.p[i325].hsb[0] = 0.05F;
                        o.p[i325].bfase += f326;
                        new Color(o.p[i325].c[0], o.p[i325].c[1], o.p[i325].c[2]);
                        final Color color = Color.getHSBColor(o.p[i325].hsb[0], o.p[i325].hsb[1], o.p[i325].hsb[2]);
                        o.p[i325].c[0] = color.getRed();
                        o.p[i325].c[1] = color.getGreen();
                        o.p[i325].c[2] = color.getBlue();
                    }
                } else if (o.p[i325].glass == 1)
                    o.p[i325].gr += 5;
                if (Math.abs(f326) >= 1.0F) {
                    o.p[i325].chip = 1;
                    o.p[i325].ctmag = f326;
                }
            }
            squash += i323 / i324;
        }
    }

    public void rot(final int[] is, final int[] is331, final int i, final int i332, final int i333, final int i334) {
        if (i333 != 0)
            for (int i335 = 0; i335 < i334; i335++) {
                final int i336 = is[i335];
                final int i337 = is331[i335];
                is[i335] = i + (int) ((i336 - i) * m.cos(i333) - (i337 - i332) * m.sin(i333));
                is331[i335] = i332 + (int) ((i336 - i) * m.sin(i333) + (i337 - i332) * m.cos(i333));
            }
    }

    @Override
    public void run() {
        thredo.setPriority(10);
        btgame[0] = getImage("data/backtogame1.gif");
        btgame[1] = getImage("data/backtogame2.gif");
        logo = getImage("data/carmakerlogo.gif");
        m.w = 700;
        m.cx = 350;
        m.y = -240;
        m.z = -400;
        m.zy = 4;
        m.focusPoint = 800;
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
            if (Madness.testcar.equals("Failx12")) {
                JOptionPane.showMessageDialog(null,
                        "Failed to load car! Please make sure car is saved before Test Drive.", "Car Maker", 1);
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
            Madness.testcar = "";
            Madness.testdrive = 0;
        }
        boolean bool = false;
        if (!carname.equals("")) {
            tutok = true;
            bool = true;
        }
        while (!exwist) {
            if (tab != tabed) {
                hidefields();
                if (tab == 1)
                    editor.setEnabled(true);
                else
                    editor.setEnabled(false);
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
                    slcar.add(rd, "Select a Car                      ");
                    final String[] strings = new File("mycars/").list();
                    if (strings != null)
                        for (int i0 = 0; i0 < strings.length; i0++)
                            if (strings[i0].toLowerCase().endsWith(".rad"))
                                slcar.add(rd, strings[i0].substring(0, strings[i0].length() - 4));
                    if (carname.equals(""))
                        slcar.select(0);
                    else {
                        slcar.select(carname);
                        if (carname.equals(slcar.getSelectedItem()))
                            loadfile();
                    }
                    mouseon = -1;
                    srch.setText("");
                    sfase = 0;
                }
                rd.setFont(new Font("Arial", 1, 13));
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
                int i1 = 30;
                int i2 = 0;
                if (tutok) {
                    i1 = 250;
                    i2 = -70;
                }
                if (xm > 76 && xm < 624 && ym > 84 + i1 && ym < 167 + i1 && !openm) {
                    if (mouseon == -1) {
                        mouseon = 1;
                        setCursor(new Cursor(12));
                    }
                } else if (mouseon == 1) {
                    mouseon = -1;
                    setCursor(new Cursor(0));
                }
                int i3 = 0;
                if (!tutok && mouseon != 1 && !bool)
                    if (flk <= 0) {
                        rd.setColor(new Color(255, 0, 0));
                        flk--;
                        if (flk == -2)
                            flk = 1;
                    } else {
                        rd.setColor(new Color(0, 0, 255));
                        i3 = 2;
                        flk++;
                        if (flk == 3)
                            flk = 0;
                    }
                rd.drawLine(76 + i3, 84 + i1, 76 + i3, 167 + i1);
                rd.drawLine(76 + i3, 84 + i1, 95 + i3, 84 + i1);
                rd.drawLine(76 + i3, 167 + i1, 95 + i3, 167 + i1);
                rd.drawLine(624 - i3, 84 + i1, 624 - i3, 167 + i1);
                rd.drawLine(624 - i3, 84 + i1, 605 - i3, 84 + i1);
                rd.drawLine(624 - i3, 167 + i1, 605 - i3, 167 + i1);
                if (mouseon == 1)
                    rd.setColor(new Color(0, 64, 128));
                else
                    rd.setColor(new Color(0, 0, 0));
                rd.drawString("If this is your first time creating a car please follow the tutorial found at:", 106,
                        110 + i1);
                rd.setColor(new Color(0, 128, 255));
                rd.drawString("http://www.needformadness.com/developer/simplecar.html", 106, 130 + i1);
                if (mouseon == 1)
                    rd.setColor(new Color(0, 128, 255));
                else
                    rd.setColor(new Color(0, 64, 128));
                rd.drawLine(106, 131 + i1, 480, 131 + i1);
                if (mouseon == 1)
                    rd.setColor(new Color(0, 64, 128));
                else
                    rd.setColor(new Color(0, 0, 0));
                rd.drawString("It is highly recommended that you follow this tutorial before trying anything!", 106,
                        150 + i1);
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
                rd.drawString("For the Car Maker Homepage, Development Center and Forums :",
                        350 - ftm.stringWidth("For the Car Maker Homepage, Development Center and Forums :") / 2, 480);
                rd.setColor(new Color(0, 128, 255));
                String string = "http://www.needformadness.com/developer/";
                rd.drawString(string, 350 - ftm.stringWidth(string) / 2, 500);
                if (mouseon == 2)
                    rd.setColor(new Color(0, 128, 255));
                else
                    rd.setColor(new Color(0, 64, 128));
                rd.drawLine(350 - ftm.stringWidth(string) / 2, 501, 350 + ftm.stringWidth(string) / 2, 501);
                if (mouseon == 2 && mouses == -1)
                    openhlink();
                int i4 = 0;
                if (sfase == 3)
                    i4 = 100;
                rd.setColor(new Color(0, 0, 0));
                rd.drawRect(177 - i4, 202 + i2, 346 + i4 * 2, 167 + i4 / 5);
                if (sfase == 0) {
                    rd.drawString("Select Car to Edit", 350 - ftm.stringWidth("Select Car to Edit") / 2, 230 + i2);
                    slcar.move(250, 240 + i2);
                    if (slcar.getWidth() != 200)
                        slcar.setSize(200, 21);
                    if (!slcar.isShowing())
                        slcar.setVisible(true);
                    stringbutton("    Make new Car    ", 430, 296 + i2, 0, true);
                    stringbutton("     Rename Car     ", 270, 296 + i2, 0, false);
                    stringbutton("      Delete Car      ", 270, 336 + i2, 0, false);
                    stringbutton("     Import & Export     ", 430, 336 + i2, 0, false);
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
                        carname = "";
                }
                if (sfase == 1) {
                    rd.drawString("Make a new Car", 350 - ftm.stringWidth("Make a new Car") / 2, 230 + i2);
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.drawString("New car name :", 228, 266 + i2);
                    movefield(srch, 335, 250 + i2, 129, 22);
                    if (!srch.isShowing()) {
                        srch.setVisible(true);
                        srch.requestFocus();
                    }
                    fixtext(srch);
                    stringbutton("    Make Car    ", 350, 306 + i2, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i2, 0, false);
                }
                if (sfase == 2) {
                    rd.drawString(new StringBuilder().append("Rename Car :  ").append(carname).append("").toString(),
                            350 - ftm.stringWidth(
                                    new StringBuilder().append("Rename Car :  ").append(carname).append("").toString())
                                    / 2,
                            230 + i2);
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.drawString("New name :", 239, 266 + i2);
                    movefield(srch, 316, 250 + i2, 129, 22);
                    if (!srch.isShowing()) {
                        srch.setVisible(true);
                        srch.requestFocus();
                    }
                    fixtext(srch);
                    stringbutton("   Rename Car   ", 350, 306 + i2, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i2, 0, false);
                }
                if (sfase == 3) {
                    rd.drawString("Import a Wavefront OBJ 3D Model",
                            350 - ftm.stringWidth("Import a Wavefront OBJ 3D Model") / 2, 230 + i2);
                    if (xm > 116 && xm < 584 && ym > 246 + i2 && ym < 290 + i2) {
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
                    rd.drawString("Please read the important information about importing cars found at:",
                            350 - ftm.stringWidth(
                                    "Please read the important information about importing cars, found here :") / 2,
                            260 + i2);
                    rd.setColor(new Color(0, 128, 255));
                    string = "http://www.needformadness.com/developer/extras.html";
                    rd.drawString(string, 350 - ftm.stringWidth(string) / 2, 280 + i2);
                    if (mouseon == 3)
                        rd.setColor(new Color(0, 128, 255));
                    else
                        rd.setColor(new Color(0, 64, 128));
                    rd.drawLine(350 - ftm.stringWidth(string) / 2, 281 + i2, 350 + ftm.stringWidth(string) / 2,
                            281 + i2);
                    if (mouseon == 3 && mouses == -1)
                        openelink();
                    stringbutton("     Import Car     ", 350, 326 + i2, 0, true);
                    stringbutton("  Export >  ", 550, 326 + i2, 0, false);
                    stringbutton("  Cancel  ", 350, 366 + i2, 0, false);
                }
                if (sfase == 4) {
                    rd.drawString("Select Car to Export", 350 - ftm.stringWidth("Select Car to Export") / 2, 230 + i2);
                    slcar.move(250, 240 + i2);
                    if (slcar.getWidth() != 200)
                        slcar.setSize(200, 21);
                    if (!slcar.isShowing())
                        slcar.setVisible(true);
                    stringbutton("     Export Car     ", 350, 306 + i2, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i2, 0, false);
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
                        carname = "";
                }
            }
            if (tab == 1) {
                if (tabed != tab) {
                    srch.setText("");
                    rplc.setText("");
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
                rd.setFont(new Font("Arial", 1, 12));
                if (prefs) {
                    rd.drawString("Code Font:", 10, 446);
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
                        for (int i5 = 0; i5 < 16; i5++)
                            wv[i5].setFont(new Font(cfont, 1, 14));
                        editor.requestFocus();
                    }
                    rd.drawString("Code Theme:", 190, 446);
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
                    stringbutton("<", 400, 446, 3, false);
                    cntprf++;
                    if (cntprf == 200)
                        prefs = false;
                } else {
                    stringbutton("Preferences", 52, 446, 3, false);
                    if (ctheme.isShowing())
                        ctheme.setVisible(false);
                    if (fontsel.isShowing())
                        fontsel.setVisible(false);
                    if (cntprf != 0)
                        cntprf = 0;
                    if (cntchk == 0) {
                        npolys = 0;
                        int i6 = 0;
                        boolean bool7 = false;
                        while (i6 != -1 && mouses != 1) {
                            if (!bool7)
                                i6 = editor.getText().indexOf("<p>", i6);
                            else
                                i6 = editor.getText().indexOf("</p>", i6);
                            if (i6 != -1) {
                                if (!bool7)
                                    bool7 = true;
                                else {
                                    bool7 = false;
                                    npolys++;
                                }
                                i6 += 3;
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
                        rd.drawString(new StringBuilder().append("Number of Polygons :  ").append(npolys)
                                .append(" / 10000").toString(), 200, 446);
                }
                if (!changed && !editor.getText().equals(lastedo))
                    changed = true;
                stringbutton("  Save  ", 490, 455, 0, changed);
                stringbutton("  Save & Preview  >  ", 600, 455, 0, changed);
                mirror = false;
                polynum = -1;
                cntpls = 0;
                String string = "";
                try {
                    string = editor.getSelectedText();
                } catch (final Exception exception) {
                    
                }
                if (!string.equals("")) {
                    int i8 = string.indexOf("<p>", 0);
                    while (i8 != -1 && i8 + 1 < string.length()) {
                        if (!mirror) {
                            i8 = string.indexOf("</p>", i8 + 1);
                            if (i8 != -1) {
                                mirror = true;
                                cntpls++;
                            }
                        }
                        if (mirror) {
                            i8 = string.indexOf("<p>", i8 + 1);
                            if (i8 != -1)
                                mirror = false;
                        }
                    }
                }
                if (!mirror) {
                    rd.setColor(new Color(170, 170, 170));
                    rd.drawRect(5, 474, 494, 70);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Text to find:", 18, 500);
                    movefield(srch, 91, 484, 129, 22);
                    if (!srch.isShowing())
                        srch.setVisible(true);
                    boolean bool9 = false;
                    if (!srch.getText().equals(""))
                        bool9 = true;
                    stringbutton(" Find ", 117, 526, 2, bool9);
                    rd.drawString("Replace with:", 255, 500);
                    movefield(rplc, 338, 484, 129, 22);
                    if (!rplc.isShowing())
                        rplc.setVisible(true);
                    bool9 = false;
                    if (!srch.getText().equals("") && !rplc.getText().equals(""))
                        bool9 = true;
                    stringbutton(" Replace ", 376, 526, 2, bool9);
                } else {
                    if (srch.isShowing())
                        srch.setVisible(false);
                    if (rplc.isShowing())
                        rplc.setVisible(false);
                    rd.setColor(new Color(170, 170, 170));
                    rd.drawRect(5, 474, 450, 70);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Mirror [Selected] polygon(s) along:", 18, 490);
                    stringbutton(" Mirror Along X Axis ", 90, 525, 2, true);
                    stringbutton(" Mirror Along Y Axis ", 230, 525, 2, false);
                    stringbutton(" Mirror Along Z Axis ", 370, 525, 2, false);
                    rd.setColor(new Color(170, 170, 170));
                    rd.drawRect(465, 474, 230, 70);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Show [Selected] polygon(s):", 478, 490);
                    stringbutton(" Show in 3D  > ", 580, 523, 0, true);
                }
                if (npolys > 10000 && !tomany) {
                    repaint();
                    JOptionPane.showMessageDialog(null,
                            "Maximum number of polygons (pieces) allowed has been exceeded!\nThe maximum allowed is 10000 polygons, please decrease.\n",
                            "Car Maker", 1);
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
                        final int[] is = {
                                50 + adna[0], -50 - adna[1], 0, 0, 0, 0
                        };
                        final int[] is10 = {
                                0, 0, 50 + adna[2], -50 - adna[3], 0, 0
                        };
                        final int[] is11 = {
                                0, 0, 0, 0, 50 + adna[4], -50 - adna[5]
                        };
                        for (int i12 = 0; i12 < 6; i12++) {
                            is[i12] += o.x - m.x;
                            is10[i12] += o.y - m.y;
                            is11[i12] += o.z - m.z;
                        }
                        rot(is, is10, o.x - m.x, o.y - m.y, o.xy, 6);
                        rot(is10, is11, o.y - m.y, o.z - m.z, o.zy, 6);
                        rot(is, is11, o.x - m.x, o.z - m.z, o.xz, 6);
                        rot(is, is11, m.cx, m.cz, m.xz, 6);
                        rot(is10, is11, m.cy, m.cz, m.zy, 6);
                        final int[] is13 = new int[6];
                        final int[] is14 = new int[6];
                        for (int i15 = 0; i15 < 6; i15++) {
                            is13[i15] = xs(is[i15], is11[i15]);
                            is14[i15] = ys(is10[i15], is11[i15]);
                        }
                        rd.setColor(new Color(0, 150, 0));
                        rd.drawString("X+", is13[0] - 7, is14[0] + 4);
                        rd.drawString("-X", is13[1] - 5, is14[1] + 4);
                        rd.drawLine(is13[0], is14[0], is13[1], is14[1]);
                        rd.setColor(new Color(150, 0, 0));
                        rd.drawString("Y+", is13[2] - 7, is14[2] + 4);
                        rd.drawString("-Y", is13[3] - 5, is14[3] + 4);
                        rd.drawLine(is13[2], is14[2], is13[3], is14[3]);
                        rd.setColor(new Color(0, 0, 150));
                        rd.drawString("Z+", is13[4] - 7, is14[4] + 4);
                        rd.drawString("-Z", is13[5] - 5, is14[5] + 4);
                        rd.drawLine(is13[4], is14[4], is13[5], is14[5]);
                        for (int i16 = 0; i16 < 6; i16++) {
                            if (Math.abs(is14[i16] - 207) * 1.91F > Math.abs(is13[i16] - 350)) {
                                if (Math.abs(Math.abs(is14[i16] - 207) - 170) > 10)
                                    if (Math.abs(is14[i16] - 207) < 170)
                                        adna[i16] += 10;
                                    else
                                        adna[i16] -= 10;
                            } else if (Math.abs(Math.abs(is13[i16] - 350) - 338) > 10)
                                if (Math.abs(is13[i16] - 350) < 338)
                                    adna[i16] += 10;
                                else
                                    adna[i16] -= 10;
                            if (adna[i16] > 276)
                                adna[i16] = 276;
                            if (adna[i16] < 0)
                                adna[i16] = 0;
                        }
                    }
                }
                rd.setColor(new Color(205, 200, 200));
                rd.fillRect(0, 390, 700, 20);
                rd.setColor(new Color(225, 225, 225));
                rd.fillRect(0, 410, 700, 140);
                rd.setFont(new Font("Arial", 1, 12));
                ftm = rd.getFontMetrics();
                final String[] strings = {
                        "3D Controls", "Color Edit", "Scale & Align", "Wheels", "Stats & Class", "Physics", "Test Drive"
                };
                final int[] is = {
                        0, 0, 100, 90
                };
                final int[] is17 = {
                        390, 410, 410, 390
                };
                for (int i18 = 0; i18 < 7; i18++) {
                    rd.setColor(new Color(170, 170, 170));
                    if (xm > is[0] && xm < is[3] && ym > 390 && ym < 410)
                        rd.setColor(new Color(190, 190, 190));
                    if (dtab == i18)
                        rd.setColor(new Color(225, 225, 225));
                    rd.fillPolygon(is, is17, 4);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(strings[i18], i18 * 100 + 47 - ftm.stringWidth(strings[i18]) / 2, 404);
                    if (xm > is[0] && xm < is[3] && ym > 390 && ym < 410 && mouses == -1)
                        dtab = i18;
                    for (int i19 = 0; i19 < 4; i19++)
                        is[i19] += 100;
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
                    rd.drawString("Rotate Car around its X & Z Axis using:  [ Keyboard Arrows ] ", 20, 440);
                    rd.drawString(
                            "Rotate Car fully around the Y Axis using:    [ < ]  &  [ > ]    or    [ A ]  &  [ D ]    or    [ 4 ]  &  [ 6 ]    Keys",
                            20, 465);
                    rd.drawString("Move Car Up and Down using:    [ - ]  &  [ + ]    Keys", 20, 490);
                    rd.drawString(
                            "Move Car Forwards and Backwards using:    [ W ]  &  [ S ]    or    [ 8 ]  &  [ 2 ]    or    [ Enter ]  &  [ Backspace ]    Keys",
                            20, 515);
                }
                if (dtab == 1)
                    if (o.colok != 2) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("[  First & Second Color not defined yet  ]",
                                350 - ftm.stringWidth("[  First & Second Color not defined yet  ]") / 2, 450);
                        stringbutton(" Define 1st and 2nd Color ", 350, 490, 0, true);
                    } else {
                        if (dtabed != dtab) {
                            fcol = new StringBuilder().append("(").append(o.fcol[0]).append(",").append(o.fcol[1])
                                    .append(",").append(o.fcol[2]).append(")").toString();
                            srch.setText(fcol);
                            ofcol = fcol;
                            Color.RGBtoHSB(o.fcol[0], o.fcol[1], o.fcol[2], fhsb);
                            float f = fhsb[1];
                            fhsb[1] = fhsb[2];
                            fhsb[2] = f;
                            scol = new StringBuilder().append("(").append(o.scol[0]).append(",").append(o.scol[1])
                                    .append(",").append(o.scol[2]).append(")").toString();
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
                        rd.drawString("First Color", 151, 428);
                        rd.drawString("Hue:", 75, 450);
                        rd.drawString("Brightness:", 35, 470);
                        rd.drawString("Saturation:", 38, 490);
                        rd.drawString("RGB Value:", 38, 520);
                        movefield(srch, 106, 504, 129, 22);
                        if (srch.hasFocus())
                            focuson = false;
                        if (!srch.isShowing())
                            srch.setVisible(true);
                        for (int i20 = 0; i20 < 200; i20++) {
                            rd.setColor(Color.getHSBColor((float) (i20 * 0.005), 1.0F, 1.0F));
                            rd.drawLine(110 + i20, 442, 110 + i20, 449);
                        }
                        for (int i21 = 0; i21 < 200; i21++) {
                            rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float) (i21 * 0.004)));
                            rd.drawLine(110 + i21, 462, 110 + i21, 469);
                        }
                        for (int i22 = 0; i22 < 200; i22++) {
                            rd.setColor(Color.getHSBColor(fhsb[0], (float) (i22 * 0.005), fhsb[1]));
                            rd.drawLine(110 + i22, 482, 110 + i22, 489);
                        }
                        for (int i23 = 0; i23 < 3; i23++) {
                            rd.setColor(new Color(0, 0, 0));
                            float f = fhsb[i23] * 200.0F;
                            if (i23 == 1)
                                f = (fhsb[i23] - 0.2F) * 250.0F;
                            rd.drawLine((int) (110.0F + f), 442 + i23 * 20, (int) (110.0F + f), 449 + i23 * 20);
                            rd.drawLine((int) (111.0F + f), 442 + i23 * 20, (int) (111.0F + f), 449 + i23 * 20);
                            rd.fillRect((int) (109.0F + f), 450 + i23 * 20, 4, 2);
                            rd.drawLine((int) (108.0F + f), 452 + i23 * 20, (int) (113.0F + f), 452 + i23 * 20);
                            if (xm > 107 && xm < 313 && ym > 439 + i23 * 20 && ym < 452 + i23 * 20 && mouses == 1
                                    && mouseon == -1)
                                mouseon = i23;
                            if (mouseon == i23) {
                                if (i23 == 1) {
                                    fhsb[i23] = 0.2F + (xm - 110) / 250.0F;
                                    if (fhsb[i23] < 0.2)
                                        fhsb[i23] = 0.2F;
                                } else
                                    fhsb[i23] = (xm - 110) / 200.0F;
                                if (fhsb[i23] > 1.0F)
                                    fhsb[i23] = 1.0F;
                                if (fhsb[i23] < 0.0F)
                                    fhsb[i23] = 0.0F;
                            }
                        }
                        stringbutton(" Save ", 300, 520, 0, !fcol.equals(ofcol));
                        rd.setColor(new Color(170, 170, 170));
                        rd.drawRect(360, 425, 320, 110);
                        rd.setColor(new Color(225, 225, 225));
                        rd.fillRect(472, 419, 95, 9);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("Second Color", 482, 428);
                        rd.drawString("Hue:", 415, 450);
                        rd.drawString("Brightness:", 375, 470);
                        rd.drawString("Saturation:", 378, 490);
                        rd.drawString("RGB Value:", 378, 520);
                        movefield(rplc, 446, 504, 129, 22);
                        if (rplc.hasFocus())
                            focuson = false;
                        if (!rplc.isShowing())
                            rplc.setVisible(true);
                        for (int i24 = 0; i24 < 200; i24++) {
                            rd.setColor(Color.getHSBColor((float) (i24 * 0.005), 1.0F, 1.0F));
                            rd.drawLine(450 + i24, 442, 450 + i24, 449);
                        }
                        for (int i25 = 0; i25 < 200; i25++) {
                            rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float) (i25 * 0.004)));
                            rd.drawLine(450 + i25, 462, 450 + i25, 469);
                        }
                        for (int i26 = 0; i26 < 200; i26++) {
                            rd.setColor(Color.getHSBColor(shsb[0], (float) (i26 * 0.005), shsb[2]));
                            rd.drawLine(450 + i26, 482, 450 + i26, 489);
                        }
                        for (int i27 = 0; i27 < 3; i27++) {
                            rd.setColor(new Color(0, 0, 0));
                            float f = shsb[i27] * 200.0F;
                            if (i27 == 1)
                                f = (shsb[i27] - 0.2F) * 250.0F;
                            rd.drawLine((int) (450.0F + f), 442 + i27 * 20, (int) (450.0F + f), 449 + i27 * 20);
                            rd.drawLine((int) (451.0F + f), 442 + i27 * 20, (int) (451.0F + f), 449 + i27 * 20);
                            rd.fillRect((int) (449.0F + f), 450 + i27 * 20, 4, 2);
                            rd.drawLine((int) (448.0F + f), 452 + i27 * 20, (int) (453.0F + f), 452 + i27 * 20);
                            if (xm > 447 && xm < 653 && ym > 439 + i27 * 20 && ym < 452 + i27 * 20 && mouses == 1
                                    && mouseon == -1)
                                mouseon = i27 + 3;
                            if (mouseon == i27 + 3) {
                                if (i27 == 1) {
                                    shsb[i27] = 0.2F + (xm - 450) / 250.0F;
                                    if (shsb[i27] < 0.2)
                                        shsb[i27] = 0.2F;
                                } else
                                    shsb[i27] = (xm - 450) / 200.0F;
                                if (shsb[i27] > 1.0F)
                                    shsb[i27] = 1.0F;
                                if (shsb[i27] < 0.0F)
                                    shsb[i27] = 0.0F;
                            }
                        }
                        stringbutton(" Save ", 640, 520, 0, !scol.equals(oscol));
                        if (fhsb[1] < 0.2)
                            fhsb[1] = 0.2F;
                        if (shsb[1] < 0.2)
                            shsb[1] = 0.2F;
                        for (int i28 = 0; i28 < o.npl; i28++) {
                            if (o.p[i28].colnum == 1) {
                                o.p[i28].hsb[0] = fhsb[0];
                                o.p[i28].hsb[1] = fhsb[2];
                                o.p[i28].hsb[2] = fhsb[1];
                            }
                            if (o.p[i28].colnum == 2) {
                                o.p[i28].hsb[0] = shsb[0];
                                o.p[i28].hsb[1] = shsb[2];
                                o.p[i28].hsb[2] = shsb[1];
                            }
                        }
                        String string = new StringBuilder().append("(")
                                .append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getRed()).append(",")
                                .append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getGreen()).append(",")
                                .append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getBlue()).append(")").toString();
                        if (!fcol.equals(string)) {
                            fcol = string;
                            srch.setText(fcol);
                        }
                        string = new StringBuilder().append("(")
                                .append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getRed()).append(",")
                                .append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getGreen()).append(",")
                                .append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getBlue()).append(")").toString();
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
                                final int[] is29 = new int[3];
                                boolean bool30 = true;
                                try {
                                    final int i31 = fcol.indexOf(",", 0);
                                    final int i32 = fcol.indexOf(",", i31 + 1);
                                    is29[0] = Integer.valueOf(fcol.substring(1, i31)).intValue();
                                    if (is29[0] < 0)
                                        is29[0] = 0;
                                    if (is29[0] > 255)
                                        is29[0] = 255;
                                    is29[1] = Integer.valueOf(fcol.substring(i31 + 1, i32)).intValue();
                                    if (is29[1] < 0)
                                        is29[1] = 0;
                                    if (is29[1] > 255)
                                        is29[1] = 255;
                                    is29[2] = Integer.valueOf(fcol.substring(i32 + 1, fcol.length() - 1)).intValue();
                                    if (is29[2] < 0)
                                        is29[2] = 0;
                                    if (is29[2] > 255)
                                        is29[2] = 255;
                                } catch (final Exception exception) {
                                    bool30 = false;
                                }
                                if (bool30) {
                                    Color.RGBtoHSB(is29[0], is29[1], is29[2], fhsb);
                                    final float f = fhsb[1];
                                    fhsb[1] = fhsb[2];
                                    fhsb[2] = f;
                                }
                            }
                            if (!rplc.getText().equals(scol)) {
                                scol = rplc.getText();
                                final int[] is33 = new int[3];
                                boolean bool34 = true;
                                try {
                                    final int i35 = scol.indexOf(",", 0);
                                    final int i36 = scol.indexOf(",", i35 + 1);
                                    is33[0] = Integer.valueOf(scol.substring(1, i35)).intValue();
                                    if (is33[0] < 0)
                                        is33[0] = 0;
                                    if (is33[0] > 255)
                                        is33[0] = 255;
                                    is33[1] = Integer.valueOf(scol.substring(i35 + 1, i36)).intValue();
                                    if (is33[1] < 0)
                                        is33[1] = 0;
                                    if (is33[1] > 255)
                                        is33[1] = 255;
                                    is33[2] = Integer.valueOf(scol.substring(i36 + 1, scol.length() - 1)).intValue();
                                    if (is33[2] < 0)
                                        is33[2] = 0;
                                    if (is33[2] > 255)
                                        is33[2] = 255;
                                } catch (final Exception exception) {
                                    bool34 = false;
                                }
                                if (bool34) {
                                    Color.RGBtoHSB(is33[0], is33[1], is33[2], shsb);
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
                        int i37 = editor.getText().indexOf("\nScaleX(", 0);
                        if (i37 != -1) {
                            i37++;
                            try {
                                scale[0] = Integer
                                        .valueOf(
                                                editor.getText().substring(i37 + 7, editor.getText().indexOf(")", i37)))
                                        .intValue();
                            } catch (final Exception exception) {
                                scale[0] = 100;
                            }
                        }
                        oscale[0] = scale[0];
                        scale[1] = 100;
                        i37 = editor.getText().indexOf("\nScaleY(", 0);
                        if (i37 != -1) {
                            i37++;
                            try {
                                scale[1] = Integer
                                        .valueOf(
                                                editor.getText().substring(i37 + 7, editor.getText().indexOf(")", i37)))
                                        .intValue();
                            } catch (final Exception exception) {
                                scale[1] = 100;
                            }
                        }
                        oscale[1] = scale[1];
                        scale[2] = 100;
                        i37 = editor.getText().indexOf("\nScaleZ(", 0);
                        if (i37 != -1) {
                            i37++;
                            try {
                                scale[2] = Integer
                                        .valueOf(
                                                editor.getText().substring(i37 + 7, editor.getText().indexOf(")", i37)))
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
                    rd.drawString("Scale", 129, 428);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Scale X", 25, 450);
                    stringbutton(" - ", 92, 450, 4, false);
                    rd.drawString(new StringBuilder().append("").append(scale[0] / 100.0F).append("").toString(),
                            126 - ftm.stringWidth(
                                    new StringBuilder().append("").append(scale[0] / 100.0F).append("").toString()) / 2,
                            450);
                    stringbutton(" + ", 160, 450, 4, false);
                    rd.drawString("Scale Y", 25, 474);
                    stringbutton(" - ", 92, 474, 4, false);
                    rd.drawString(new StringBuilder().append("").append(scale[1] / 100.0F).append("").toString(),
                            126 - ftm.stringWidth(
                                    new StringBuilder().append("").append(scale[1] / 100.0F).append("").toString()) / 2,
                            474);
                    stringbutton(" + ", 160, 474, 4, false);
                    rd.drawString("Scale Z", 25, 498);
                    stringbutton(" - ", 92, 498, 4, false);
                    rd.drawString(new StringBuilder().append("").append(scale[2] / 100.0F).append("").toString(),
                            126 - ftm.stringWidth(
                                    new StringBuilder().append("").append(scale[2] / 100.0F).append("").toString()) / 2,
                            498);
                    stringbutton(" + ", 160, 498, 4, false);
                    rd.drawString("Scale ALL", 25, 527);
                    stringbutton(" - ", 106, 527, 2, true);
                    stringbutton(" + ", 146, 527, 2, true);
                    stringbutton("   Save   ", 230, 454, 0,
                            oscale[0] != scale[0] || oscale[1] != scale[1] || oscale[2] != scale[2]);
                    stringbutton(" Reset ", 230, 493, 0, false);
                    rd.drawString("Compare scale and", 296, 440);
                    rd.drawString("alignment with:", 308, 455);
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
                    rd.drawString("Align", 541, 428);
                    rd.drawString("Align in X", 433, 450);
                    stringbutton(" Rotate 90\u00b0 ", 535, 450, 4, false);
                    stringbutton("+10", 607, 450, 4, false);
                    stringbutton("-10", 656, 450, 4, false);
                    rd.drawString("Align in Y", 433, 474);
                    stringbutton(" Rotate 90\u00b0 ", 535, 474, 4, false);
                    stringbutton("+10", 607, 474, 4, false);
                    stringbutton("-10", 656, 474, 4, false);
                    rd.drawString("Align in Z", 433, 498);
                    stringbutton(" Rotate 90\u00b0 ", 535, 498, 4, false);
                    stringbutton("+10", 607, 498, 4, false);
                    stringbutton("-10", 656, 498, 4, false);
                    stringbutton(" Reset ", 490, 527, 0, false);
                    stringbutton("      Save      ", 607, 527, 0, changed2);
                }
                if (dtab == 3) {
                    if (dtabed != dtab) {
                        int i38 = 45;
                        int i39 = 45;
                        int i40 = 15;
                        int i41 = 15;
                        int i42 = 76;
                        int i43 = -76;
                        int i44 = 26;
                        int i45 = 26;
                        int i46 = 20;
                        int i47 = 20;
                        int i48 = 18;
                        int i49 = 18;
                        int i50 = 10;
                        int i51 = 10;
                        int i52 = 0;
                        int i53 = 0;
                        String string = "(140,140,140)";
                        String string54 = "(140,140,140)";
                        int i55 = 0;
                        final String string56 = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        int i57 = 0;
                        int i58 = string56.indexOf("\n", 0);
                        int i59 = 0;
                        int i60 = 15;
                        int i61 = 20;
                        String string62 = "(140,140,140)";
                        while (i58 != -1 && i57 < string56.length()) {
                            String string63 = string56.substring(i57, i58);
                            string63 = string63.trim();
                            i57 = i58 + 1;
                            i58 = string56.indexOf("\n", i57);
                            try {
                                if (string63.startsWith("rims(")) {
                                    string62 = new StringBuilder().append("(").append(getvalue("rims", string63, 0))
                                            .append(",").append(getvalue("rims", string63, 1)).append(",")
                                            .append(getvalue("rims", string63, 2)).append(")").toString();
                                    i60 = getvalue("rims", string63, 3);
                                    i61 = getvalue("rims", string63, 4);
                                }
                                if (string63.startsWith("gwgr("))
                                    i59 = getvalue("gwgr", string63, 0);
                                if (string63.startsWith("w(")) {
                                    final int i64 = getvalue("w", string63, 2);
                                    if (i64 > 0) {
                                        i38 = Math.abs(getvalue("w", string63, 0));
                                        i40 = getvalue("w", string63, 1);
                                        i42 = i64;
                                        i44 = Math.abs(getvalue("w", string63, 4));
                                        i46 = Math.abs(getvalue("w", string63, 5));
                                        string = string62;
                                        i48 = i60;
                                        i50 = i61;
                                        i52 = i59;
                                    } else {
                                        i39 = Math.abs(getvalue("w", string63, 0));
                                        i41 = getvalue("w", string63, 1);
                                        i43 = i64;
                                        i45 = Math.abs(getvalue("w", string63, 4));
                                        i47 = Math.abs(getvalue("w", string63, 5));
                                        string54 = string62;
                                        i49 = i60;
                                        i51 = i61;
                                        i53 = i59;
                                    }
                                    i55++;
                                }
                            } catch (final Exception exception) {
                                
                            }
                        }
                        if (i55 != 4)
                            defnow = true;
                        else
                            defnow = false;
                        wv[0].setText(new StringBuilder().append("").append(i39).append("").toString());
                        wv[1].setText(new StringBuilder().append("").append(i41).append("").toString());
                        wv[2].setText(new StringBuilder().append("").append(i43).append("").toString());
                        wv[3].setText(new StringBuilder().append("").append(i47).append("").toString());
                        wv[4].setText(new StringBuilder().append("").append(i45).append("").toString());
                        srch.setText(string54);
                        wv[5].setText(new StringBuilder().append("").append(i49).append("").toString());
                        wv[6].setText(new StringBuilder().append("").append(i51).append("").toString());
                        wv[7].setText(new StringBuilder().append("").append(i53).append("").toString());
                        wv[8].setText(new StringBuilder().append("").append(i38).append("").toString());
                        wv[9].setText(new StringBuilder().append("").append(i40).append("").toString());
                        wv[10].setText(new StringBuilder().append("").append(i42).append("").toString());
                        wv[11].setText(new StringBuilder().append("").append(i46).append("").toString());
                        wv[12].setText(new StringBuilder().append("").append(i44).append("").toString());
                        rplc.setText(string);
                        wv[13].setText(new StringBuilder().append("").append(i48).append("").toString());
                        wv[14].setText(new StringBuilder().append("").append(i50).append("").toString());
                        wv[15].setText(new StringBuilder().append("").append(i52).append("").toString());
                        aply1 = new StringBuilder().append("").append(wv[0].getText()).append("")
                                .append(wv[1].getText()).append("").append(wv[2].getText()).append("")
                                .append(wv[3].getText()).append("").append(wv[4].getText()).append("")
                                .append(srch.getText()).append("").append(wv[5].getText()).append("")
                                .append(wv[6].getText()).append("").append(wv[7].getText()).append("").toString();
                        aply2 = new StringBuilder().append("").append(wv[8].getText()).append("")
                                .append(wv[9].getText()).append("").append(wv[10].getText()).append("")
                                .append(wv[11].getText()).append("").append(wv[12].getText()).append("")
                                .append(rplc.getText()).append("").append(wv[13].getText()).append("")
                                .append(wv[14].getText()).append("").append(wv[15].getText()).append("").toString();
                        aplyd1 = false;
                        aplyd2 = false;
                        changed2 = false;
                        mouseon = -1;
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("BACK Wheels :", 12, 424);
                    rd.drawString("\u00b1X :", 12, 449);
                    movefield(wv[0], 35, 433, 40, 22);
                    rd.drawString("Y :", 86, 449);
                    movefield(wv[1], 101, 433, 40, 22);
                    rd.drawString("Z :", 151, 449);
                    movefield(wv[2], 166, 433, 40, 22);
                    rd.drawString("Height :", 12, 479);
                    movefield(wv[3], 56, 463, 40, 22);
                    rd.drawString("Width :", 107, 479);
                    movefield(wv[4], 148, 463, 40, 22);
                    rd.drawString("Rims RGB Color :", 12, 509);
                    movefield(srch, 109, 493, 129, 22);
                    rd.drawString("Rims Size :", 12, 539);
                    movefield(wv[5], 76, 523, 40, 22);
                    rd.drawString("Rims Depth :", 126, 539);
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
                    rd.drawString("Hide :                ?", 249, 539);
                    movefield(wv[7], 282, 523, 40, 22);
                    stringbutton("   Apply   ", 300, 440, 0, aplyd1);
                    stringbutton("   Save   ", 300, 477, 0, changed2);
                    rd.drawString("FRONT Wheels :", 362, 424);
                    rd.drawString("\u00b1X :", 362, 449);
                    movefield(wv[8], 385, 433, 40, 22);
                    rd.drawString("Y :", 436, 449);
                    movefield(wv[9], 451, 433, 40, 22);
                    rd.drawString("Z :", 501, 449);
                    movefield(wv[10], 516, 433, 40, 22);
                    rd.drawString("Height :", 362, 479);
                    movefield(wv[11], 406, 463, 40, 22);
                    rd.drawString("Width :", 457, 479);
                    movefield(wv[12], 498, 463, 40, 22);
                    rd.drawString("Rims RGB Color :", 362, 509);
                    movefield(rplc, 459, 493, 129, 22);
                    rd.drawString("Rims Size :", 362, 539);
                    movefield(wv[13], 426, 523, 40, 22);
                    rd.drawString("Rims Depth :", 476, 539);
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
                    rd.drawString("Hide :                ?", 599, 539);
                    movefield(wv[15], 632, 523, 40, 22);
                    stringbutton("   Apply   ", 650, 440, 0, aplyd2);
                    stringbutton("   Save   ", 650, 477, 0, changed2);
                    if (mouses == -1 && (mouseon == 1 || mouseon == 2))
                        JOptionPane.showMessageDialog(null,
                                "Use this variable to hide the car wheels inside the car if you need to (if they are getting drawn over the car when they\nshould be drawn behind it).\n\nIf you have created a car model with specific places for the wheels go inside them (inside the car), if when you place the\nwheels there they don\u2019t get drawn inside the car (they get drawn over it instead), use this variable to adjust that.\n\nYou can also use this variable to do the opposite, to make the wheels get drawn over the car if they are getting drawn\nbehind it when they shouldn\u2019t.\n\nThe Hide variable takes values from -40 to 40:\nA +ve value from 1 to 40 makes the wheels more hidden, where 40 is the maximum the car wheel can be hidden.\nA -ve value from -1 to -40 does exactly the opposite and makes the wheels more apparent (this if the car wheels appear\ninside the car when they should be outside).\nA 0 value means do nothing.\nMost of the time you will need to use this variable, it will be to enter +ve values from 1-40 for hiding the car wheels.\n\n",
                                "Car Maker", 1);
                    for (int i65 = 0; i65 < 16; i65++) {
                        if (wv[i65].hasFocus())
                            focuson = false;
                        if (!wv[i65].isShowing())
                            wv[i65].setVisible(true);
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
                        if (!aplyd1 && !aply1.equals(new StringBuilder().append("").append(wv[0].getText()).append("")
                                .append(wv[1].getText()).append("").append(wv[2].getText()).append("")
                                .append(wv[3].getText()).append("").append(wv[4].getText()).append("")
                                .append(srch.getText()).append("").append(wv[5].getText()).append("")
                                .append(wv[6].getText()).append("").append(wv[7].getText()).append("").toString()))
                            aplyd1 = true;
                        if (!aplyd2 && !aply2.equals(new StringBuilder().append("").append(wv[8].getText()).append("")
                                .append(wv[9].getText()).append("").append(wv[10].getText()).append("")
                                .append(wv[11].getText()).append("").append(wv[12].getText()).append("")
                                .append(rplc.getText()).append("").append(wv[13].getText()).append("")
                                .append(wv[14].getText()).append("").append(wv[15].getText()).append("").toString()))
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
                        final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        int i66 = 0;
                        int i67 = string.indexOf("\n", 0);
                        while (i67 != -1 && i66 < string.length()) {
                            String string68 = string.substring(i66, i67);
                            string68 = string68.trim();
                            i66 = i67 + 1;
                            i67 = string.indexOf("\n", i66);
                            try {
                                if (string68.startsWith("stat(")) {
                                    int i69 = 0;
                                    for (int i70 = 0; i70 < 5; i70++) {
                                        stat[i70] = getvalue("stat", string68, i70);
                                        if (stat[i70] > 200)
                                            stat[i70] = 200;
                                        if (stat[i70] < 16)
                                            stat[i70] = 16;
                                        i69 += stat[i70];
                                    }
                                    int i71 = 0;
                                    if (i69 > 680) {
                                        i71 = 680 - i69;
                                        changed2 = true;
                                    }
                                    if (i69 > 640 && i69 < 680) {
                                        i71 = 640 - i69;
                                        changed2 = true;
                                    }
                                    if (i69 > 600 && i69 < 640) {
                                        i71 = 600 - i69;
                                        changed2 = true;
                                    }
                                    if (i69 > 560 && i69 < 600) {
                                        i71 = 560 - i69;
                                        changed2 = true;
                                    }
                                    if (i69 > 520 && i69 < 560) {
                                        i71 = 520 - i69;
                                        changed2 = true;
                                    }
                                    if (i69 < 520) {
                                        i71 = 520 - i69;
                                        changed2 = true;
                                    }
                                    while (i71 != 0)
                                        for (int i72 = 0; i72 < 5; i72++) {
                                            if (i71 > 0 && stat[i72] < 200) {
                                                stat[i72]++;
                                                i71--;
                                            }
                                            if (i71 < 0 && stat[i72] > 16) {
                                                stat[i72]--;
                                                i71++;
                                            }
                                        }
                                    for (int i73 = 0; i73 < 5; i73++)
                                        rstat[i73] = stat[i73];
                                    statdef = true;
                                }
                            } catch (final Exception exception) {
                                statdef = false;
                            }
                        }
                        if (statdef) {
                            if (simcar.getItemCount() == 16)
                                simcar.add(rd, "   ");
                        } else if (simcar.getItemCount() == 17)
                            simcar.remove("   ");
                    }
                    rd.setColor(new Color(0, 0, 0));
                    if (!statdef) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("To start, please select the most similar NFM car to this car", 350
                                - ftm.stringWidth("To start, please select the most similar NFM car to this car") / 2,
                                450);
                        simcar.move(288, 460);
                        if (!simcar.isShowing())
                            simcar.setVisible(true);
                        stringbutton("   OK   ", 350, 515, 0, true);
                    } else {
                        rd.drawString("Car Class", 54, 435);
                        cls.move(34, 440);
                        if (!cls.isShowing())
                            cls.setVisible(true);
                        boolean bool74 = false;
                        int i75 = 0;
                        for (int i76 = 0; i76 < 5; i76++) {
                            i75 += stat[i76];
                            if (stat[i76] != rstat[i76])
                                bool74 = true;
                        }
                        if (clsel != cls.getSelectedIndex()) {
                            clsel = cls.getSelectedIndex();
                            int i77 = (4 - clsel) * 40 + 520 - i75;
                            while (i77 != 0)
                                for (int i78 = 0; i78 < 5; i78++) {
                                    if (i77 > 0 && stat[i78] < 200) {
                                        stat[i78]++;
                                        i77--;
                                    }
                                    if (i77 < 0 && stat[i78] > 16) {
                                        stat[i78]--;
                                        i77++;
                                    }
                                }
                        }
                        if (4 - (i75 - 520) / 40 != cls.getSelectedIndex()) {
                            clsel = 4 - (i75 - 520) / 40;
                            cls.select(clsel);
                        }
                        rd.drawString("Most Similar Car", 36, 490);
                        simcar.move(20, 495);
                        if (!simcar.isShowing())
                            simcar.setVisible(true);
                        if (carsel != simcar.getSelectedIndex()) {
                            carsel = simcar.getSelectedIndex();
                            if (carsel != 16)
                                for (int i79 = 0; i79 < 5; i79++)
                                    stat[i79] = carstat[carsel][i79];
                            requestFocus();
                        }
                        int i80 = 60;
                        int i81 = 16;
                        for (int i82 = 0; i82 < 16; i82++) {
                            int i83 = 0;
                            for (int i84 = 0; i84 < 5; i84++)
                                i83 += Math.abs(carstat[i82][i84] - stat[i84]);
                            if (i83 < i80) {
                                i81 = i82;
                                i80 = i83;
                            }
                        }
                        if (i81 != carsel) {
                            carsel = i81;
                            if (carsel < simcar.getItemCount())
                                simcar.select(carsel);
                        }
                        rd.drawString("Speed :", 196, 435);
                        rd.drawString("Acceleration :", 160, 459);
                        rd.drawString("Stunts :", 195, 483);
                        rd.drawString("Strength :", 183, 507);
                        rd.drawString("Endurance :", 171, 531);
                        for (int i85 = 0; i85 < 5; i85++) {
                            for (int i86 = 0; i86 < stat[i85]; i86++) {
                                rd.setColor(Color.getHSBColor((float) (i86 * 7.0E-4), 1.0F, 1.0F));
                                rd.drawLine(250 + i86, 426 + i85 * 24, 250 + i86, 434 + i85 * 24);
                            }
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawLine(249, 426 + i85 * 24, 249, 434 + i85 * 24);
                            rd.drawLine(450, 426 + i85 * 24, 450, 434 + i85 * 24);
                            rd.drawLine(249, 435 + i85 * 24, 450, 435 + i85 * 24);
                            for (int i87 = 0; i87 < 7; i87++)
                                rd.drawLine(275 + i87 * 25, 434 + i85 * 24, 275 + i87 * 25, 430 + i85 * 24);
                            stringbutton(" - ", 480, 435 + i85 * 24, 4, false);
                            stringbutton(" + ", 520, 435 + i85 * 24, 4, false);
                        }
                        if (carsel < 16 && i80 != 0)
                            stringbutton(" Reselect ", 80, 534, 4, true);
                        else
                            stringbutton(" Reselect ", 80, -1000, 4, true);
                        stringbutton("      Save      ", 620, 459, 0, bool74 || changed2);
                        stringbutton("   Reset   ", 620, 507, 0, false);
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
                            final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                    .toString();
                            int i88 = 0;
                            int i89 = string.indexOf("\n", 0);
                            while (i89 != -1 && i88 < string.length()) {
                                String string90 = string.substring(i88, i89);
                                string90 = string90.trim();
                                i88 = i89 + 1;
                                i89 = string.indexOf("\n", i88);
                                try {
                                    if (string90.startsWith("physics(")) {
                                        for (int i91 = 0; i91 < 11; i91++) {
                                            phys[i91] = getvalue("physics", string90, i91);
                                            if (phys[i91] > 100)
                                                phys[i91] = 100;
                                            if (phys[i91] < 0)
                                                phys[i91] = 0;
                                        }
                                        for (int i92 = 0; i92 < 11; i92++)
                                            rphys[i92] = phys[i92];
                                        for (int i93 = 0; i93 < 3; i93++) {
                                            crash[i93] = getvalue("physics", string90, i93 + 11);
                                            if (crash[i93] > 100)
                                                crash[i93] = 100;
                                            if (crash[i93] < 0)
                                                crash[i93] = 0;
                                        }
                                        for (int i94 = 0; i94 < 3; i94++)
                                            rcrash[i94] = crash[i94];
                                        engsel = getvalue("physics", string90, 14);
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
                    int i95 = -1;
                    if (pfase == 0) {
                        for (int i96 = 0; i96 < 4; i96++) {
                            rd.setColor(new Color(0, 0, 0));
                            if (xm > pnx[i96] && xm < 230 && ym > 433 + i96 * 24 && ym < 453 + i96 * 24) {
                                i95 = i96;
                                rd.setColor(new Color(176, 64, 0));
                                rd.drawLine(pnx[i96], 448 + i96 * 24, 128, 448 + i96 * 24);
                            }
                            rd.drawString(new StringBuilder().append("").append(pname[i96]).append(" :").toString(),
                                    pnx[i96], 447 + i96 * 24);
                            rd.drawLine(140, 443 + i96 * 24, 230, 443 + i96 * 24);
                            for (int i97 = 1; i97 < 10; i97++)
                                rd.drawLine(140 + 10 * i97, 443 - i97 + i96 * 24, 140 + 10 * i97, 443 + i97 + i96 * 24);
                            rd.setColor(new Color(255, 0, 0));
                            final int i98 = (int) (phys[i96] / 1.1111F / 10.0F);
                            rd.fillRect(138 + (int) (phys[i96] / 1.1111F), 443 - i98 + i96 * 24, 5, i98 * 2 + 1);
                            rd.setColor(new Color(255, 128, 0));
                            rd.drawRect(139 + (int) (phys[i96] / 1.1111F), 434 + i96 * 24, 2, 18);
                            stringbutton(" - ", 260, 447 + i96 * 24, 4, false);
                            stringbutton(" + ", 300, 447 + i96 * 24, 4, false);
                        }
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("<  Click on any variable name to learn about its function & use!", 333, 447);
                        stringbutton(" Random ", 380, 496, 0, false);
                        stringbutton(" Reset ", 455, 496, 0, false);
                        stringbutton("       Next  >       ", 570, 496, 0, true);
                    }
                    if (pfase == 1) {
                        for (int i99 = 0; i99 < 4; i99++) {
                            rd.setColor(new Color(0, 0, 0));
                            if (xm > pnx[i99 + 5] && xm < 211 && ym > 433 + i99 * 24 && ym < 453 + i99 * 24) {
                                i95 = i99 + 5;
                                rd.setColor(new Color(176, 64, 0));
                                rd.drawLine(pnx[i99 + 5], 448 + i99 * 24, 109, 448 + i99 * 24);
                            }
                            rd.drawString(new StringBuilder().append("").append(pname[i99 + 5]).append(" :").toString(),
                                    pnx[i99 + 5], 447 + i99 * 24);
                            rd.drawLine(121, 443 + i99 * 24, 211, 443 + i99 * 24);
                            for (int i100 = 1; i100 < 10; i100++)
                                rd.drawLine(121 + 10 * i100, 443 - i100 + i99 * 24, 121 + 10 * i100,
                                        443 + i100 + i99 * 24);
                            rd.setColor(new Color(255, 0, 0));
                            final int i101 = (int) (phys[i99 + 5] / 1.1111F / 10.0F);
                            rd.fillRect(119 + (int) (phys[i99 + 5] / 1.1111F), 443 - i101 + i99 * 24, 5, i101 * 2 + 1);
                            rd.setColor(new Color(255, 128, 0));
                            rd.drawRect(120 + (int) (phys[i99 + 5] / 1.1111F), 434 + i99 * 24, 2, 18);
                            stringbutton(" - ", 241, 447 + i99 * 24, 4, false);
                            stringbutton(" + ", 281, 447 + i99 * 24, 4, false);
                        }
                        for (int i102 = 0; i102 < 2; i102++) {
                            rd.setColor(new Color(0, 0, 0));
                            if (xm > pnx[i102 + 9] && xm < 548 && ym > 433 + i102 * 24 && ym < 453 + i102 * 24) {
                                i95 = i102 + 9;
                                rd.setColor(new Color(176, 64, 0));
                                rd.drawLine(pnx[i102 + 9], 448 + i102 * 24, 446, 448 + i102 * 24);
                            }
                            rd.drawString(
                                    new StringBuilder().append("").append(pname[i102 + 9]).append(" :").toString(),
                                    pnx[i102 + 9], 447 + i102 * 24);
                            rd.drawLine(458, 443 + i102 * 24, 548, 443 + i102 * 24);
                            for (int i103 = 1; i103 < 10; i103++)
                                rd.drawLine(458 + 10 * i103, 443 - i103 + i102 * 24, 458 + 10 * i103,
                                        443 + i103 + i102 * 24);
                            rd.setColor(new Color(255, 0, 0));
                            final int i104 = (int) (phys[i102 + 9] / 1.1111F / 10.0F);
                            rd.fillRect(456 + (int) (phys[i102 + 9] / 1.1111F), 443 - i104 + i102 * 24, 5,
                                    i104 * 2 + 1);
                            rd.setColor(new Color(255, 128, 0));
                            rd.drawRect(457 + (int) (phys[i102 + 9] / 1.1111F), 434 + i102 * 24, 2, 18);
                            stringbutton(" - ", 578, 447 + i102 * 24, 4, false);
                            stringbutton(" + ", 618, 447 + i102 * 24, 4, false);
                        }
                        stringbutton(" Random ", 361, 519, 0, false);
                        stringbutton(" Reset ", 436, 519, 0, false);
                        stringbutton(" <  Back ", 509, 519, 0, false);
                        stringbutton("       Next  >       ", 603, 519, 0, true);
                    }
                    if (pfase == 2) {
                        if (xm > 40 && xm < 670 && ym > 416 && ym < 436) {
                            i95 = 11;
                            rd.setColor(new Color(176, 64, 0));
                            rd.drawLine(596, 431, 669, 431);
                        }
                        rd.drawString(
                                "[   Crash Test,  Damage :                                       ]                                                     What is this?",
                                180, 430);
                        if (hitmag < 0)
                            hitmag = 0;
                        if (hitmag > 17000) {
                            crashok = true;
                            hitmag = 17000;
                            for (int i105 = 0; i105 < o.npl; i105++)
                                if ((o.p[i105].wz == 0 || o.p[i105].gr == -17 || o.p[i105].gr == -16)
                                        && o.p[i105].embos == 0)
                                    o.p[i105].embos = 1;
                        }
                        rd.setColor(new Color(255, (int) (250.0F - hitmag / 68.0F), 0));
                        rd.fillRect(322, 423, (int) (hitmag / 170.0F), 7);
                        rd.setColor(new Color(255, 0, 0));
                        rd.drawRect(322, 423, 100, 7);
                        if (i95 != 11)
                            rd.setColor(new Color(170, 170, 170));
                        else
                            rd.setColor(new Color(176, 64, 0));
                        rd.drawString("Normal Crash", 39, 438);
                        rd.drawString("Roof Crash", 501, 438);
                        rd.drawLine(125, 426, 179, 426);
                        rd.drawLine(125, 426, 125, 440);
                        rd.drawLine(491, 426, 437, 426);
                        rd.drawLine(491, 426, 491, 440);
                        rd.drawRect(19, 440, 276, 91);
                        rd.drawRect(339, 440, 312, 67);
                        rd.setColor(new Color(0, 0, 0));
                        if (xm > 50 && xm < 195 && ym > 446 && ym < 466) {
                            i95 = 12;
                            rd.setColor(new Color(176, 64, 0));
                            rd.drawLine(50, 461, 94, 461);
                        }
                        rd.drawString("Radius :", 50, 460);
                        rd.drawLine(105, 456, 195, 456);
                        for (int i106 = 1; i106 < 10; i106++)
                            rd.drawLine(105 + 10 * i106, 456 - i106, 105 + 10 * i106, 456 + i106);
                        rd.setColor(new Color(255, 0, 0));
                        int i107 = (int) (crash[0] / 1.1111F / 10.0F);
                        rd.fillRect(103 + (int) (crash[0] / 1.1111F), 456 - i107, 5, i107 * 2 + 1);
                        rd.setColor(new Color(255, 128, 0));
                        rd.drawRect(104 + (int) (crash[0] / 1.1111F), 447, 2, 18);
                        stringbutton(" - ", 225, 460, 4, false);
                        stringbutton(" + ", 265, 460, 4, false);
                        rd.setColor(new Color(0, 0, 0));
                        if (xm > 30 && xm < 195 && ym > 470 && ym < 490) {
                            i95 = 13;
                            rd.setColor(new Color(176, 64, 0));
                            rd.drawLine(30, 485, 94, 485);
                        }
                        rd.drawString("Magnitude :", 30, 484);
                        rd.drawLine(105, 480, 195, 480);
                        for (int i108 = 1; i108 < 10; i108++)
                            rd.drawLine(105 + 10 * i108, 480 - i108, 105 + 10 * i108, 480 + i108);
                        rd.setColor(new Color(255, 0, 0));
                        i107 = (int) (crash[1] / 1.1111F / 10.0F);
                        rd.fillRect(103 + (int) (crash[1] / 1.1111F), 480 - i107, 5, i107 * 2 + 1);
                        rd.setColor(new Color(255, 128, 0));
                        rd.drawRect(104 + (int) (crash[1] / 1.1111F), 471, 2, 18);
                        stringbutton(" - ", 225, 484, 4, false);
                        stringbutton(" + ", 265, 484, 4, false);
                        rd.setColor(new Color(0, 0, 0));
                        if (xm > 350 && xm < 551 && ym > 446 && ym < 466) {
                            i95 = 14;
                            rd.setColor(new Color(176, 64, 0));
                            rd.drawLine(350, 461, 450, 461);
                        }
                        rd.drawString("Roof Destruction :", 350, 460);
                        rd.drawLine(461, 456, 551, 456);
                        for (int i109 = 1; i109 < 10; i109++)
                            rd.drawLine(461 + 10 * i109, 456 - i109, 461 + 10 * i109, 456 + i109);
                        rd.setColor(new Color(255, 0, 0));
                        i107 = (int) (crash[2] / 1.1111F / 10.0F);
                        rd.fillRect(459 + (int) (crash[2] / 1.1111F), 456 - i107, 5, i107 * 2 + 1);
                        rd.setColor(new Color(255, 128, 0));
                        rd.drawRect(460 + (int) (crash[2] / 1.1111F), 447, 2, 18);
                        stringbutton(" - ", 581, 460, 4, false);
                        stringbutton(" + ", 621, 460, 4, false);
                        stringbutton("    CRASH!    ", 143, 516, 0, true);
                        stringbutton("  Fix  ", 235, 516, 0, false);
                        stringbutton("    CRASH Roof!    ", 484, 492, 0, true);
                        stringbutton("  Fix  ", 591, 492, 0, false);
                        stringbutton(" Reset ", 435, 535, 0, false);
                        stringbutton(" <  Back ", 508, 535, 0, false);
                        stringbutton("       Next  >       ", 602, 535, 0, true);
                    }
                    if (pfase == 3) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("Select the most suitable engine for your car :", 30, 440);
                        engine.move(293, 424);
                        if (!engine.isShowing()) {
                            engine.setVisible(true);
                            engine.select(engsel);
                        }
                        if (engsel != engine.getSelectedIndex()) {
                            engsel = engine.getSelectedIndex();
                            for (int i110 = 0; i110 < 5; i110++)
                                for (int i111 = 0; i111 < 5; i111++) {
                                    engs[i111][i110].stop();
                                    engs[i111][i110].checkopen();
                                }
                            engon = false;
                        }
                        if (engsel == 0)
                            rd.drawString(
                                    "Normal Engine:  Like Tornado Shark, Sword of Justice or Radical One's engine.", 30,
                                    470);
                        if (engsel == 1)
                            rd.drawString(
                                    "V8 Engine:  High speed engine like Formula 7, Drifter X or Might Eight's engine.",
                                    30, 470);
                        if (engsel == 2)
                            rd.drawString("Retro Engine:  Like Wow Caninaro, Lead Oxide or Kool Kat\u2019s engine.", 30,
                                    470);
                        if (engsel == 3)
                            rd.drawString(
                                    "Power Engine:  Turbo/super charged engine like Max Revenge, High Rider or Dr Monstaa\u2019s engine.",
                                    30, 470);
                        if (engsel == 4)
                            rd.drawString(
                                    "Diesel Engine:  Big diesel powered engine for big cars like EL King or  M A S H E E N .",
                                    30, 470);
                        rd.drawString("LISTEN :", 30, 500);
                        stringbutton(" Idle ", 108, 500, 0, true);
                        stringbutton(" RPM 1 ", 170, 500, 0, true);
                        stringbutton(" RPM 2 ", 240, 500, 0, true);
                        stringbutton(" RPM 3 ", 310, 500, 0, true);
                        stringbutton(" RPM MAX ", 389, 500, 0, true);
                        if (engon)
                            stringbutton("          Stop Engine          ", 240, 535, 0, true);
                        else
                            stringbutton("          Stop Engine          ", 240, -2500, 0, true);
                        stringbutton(" <  Back ", 500, 525, 0, false);
                        stringbutton("     Save & Finish!     ", 610, 525, 0, true);
                    }
                    if (pfase == 4) {
                        rd.drawString("Testing & Setting up Physics...", 265, 470);
                        repaint();
                        try {
                            if (thredo != null) {
                                
                            }
                            Thread.sleep(100L);
                        } catch (final InterruptedException interruptedexception) {
                            
                        }
                        for (int i112 = 0; i112 < 4; i112++) {
                            int i113 = 0;
                            int i114 = 4;
                            if (i112 == 1)
                                i114 = 2;
                            if (i112 == 2)
                                i113 = 2;
                            for (int i115 = 0; i115 < 10; i115++) {
                                setupo();
                                o.xy = 0;
                                hitmag = 0;
                                int i116 = 0;
                                actmag = 0;
                                int i117 = i113;
                                boolean bool118 = false;
                                while (hitmag < 17000) {
                                    if (bool118)
                                        regx(i117, (int) (150.0 + 600.0 * Math.random()), true);
                                    else
                                        regz(i117, (int) (150.0 + 600.0 * Math.random()), true);
                                    if (++i117 == i114) {
                                        o.xz += 45;
                                        o.zy += 45;
                                        i117 = 0;
                                        if (bool118)
                                            bool118 = false;
                                        else
                                            bool118 = true;
                                        if (i116 == actmag)
                                            crash[0] += 10;
                                        i116 = actmag;
                                    }
                                }
                            }
                            float f = 0.0F;
                            for (int i119 = 0; i119 < 10; i119++) {
                                setupo();
                                o.xy = 0;
                                actmag = 0;
                                hitmag = 0;
                                int i120 = i113;
                                boolean bool121 = false;
                                while (hitmag < 17000) {
                                    if (bool121)
                                        regx(i120, (int) (150.0 + 600.0 * Math.random()), true);
                                    else
                                        regz(i120, (int) (150.0 + 600.0 * Math.random()), true);
                                    if (++i120 == i114) {
                                        o.xz += 45;
                                        o.zy += 45;
                                        i120 = 0;
                                        if (bool121)
                                            bool121 = false;
                                        else
                                            bool121 = true;
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
                            float f122 = 0.9F + (stat[4] - 90) * 0.01F;
                            if (f122 < 0.6)
                                f122 = 0.6F;
                            if (stat[4] == 200 && stat[0] <= 88)
                                f122 = 3.0F;
                            final int i123 = (int) (actmag * f122);
                            for (int i124 = 0; i124 < 12; i124++) {
                                setupo();
                                o.xy = 0;
                                o.xz = 90 * i124;
                                if (o.xz >= 360)
                                    o.xz -= 360;
                                hitmag = 0;
                                int i125 = 0;
                                actmag = 0;
                                int i126 = i113;
                                boolean bool127 = false;
                                while (actmag < i123) {
                                    if (bool127)
                                        regx(i126, (int) (150.0 + 600.0 * Math.random()), true);
                                    else
                                        regz(i126, (int) (150.0 + 600.0 * Math.random()), true);
                                    if (++i126 == i114) {
                                        if (bool127)
                                            bool127 = false;
                                        else
                                            bool127 = true;
                                        i126 = 0;
                                        if (i125 == actmag)
                                            crash[0] += 10;
                                        i125 = actmag;
                                    }
                                }
                            }
                            if (i112 == 3) {
                                f = 0.0F;
                                for (int i128 = 0; i128 < 10; i128++) {
                                    setupo();
                                    o.xy = 0;
                                    actmag = 0;
                                    hitmag = 0;
                                    int i129 = i113;
                                    boolean bool130 = false;
                                    while (hitmag < 17000) {
                                        if (bool130)
                                            regx(i129, (int) (150.0 + 600.0 * Math.random()), true);
                                        else
                                            regz(i129, (int) (150.0 + 600.0 * Math.random()), true);
                                        if (++i129 == i114) {
                                            o.xz += 45;
                                            o.zy += 45;
                                            i129 = 0;
                                            if (bool130)
                                                bool130 = false;
                                            else
                                                bool130 = true;
                                        }
                                    }
                                    f += (float) actmag / (float) hitmag;
                                }
                                f /= 10.0F;
                                actmag = (int) (hitmag * f);
                            }
                        }
                        setupo();
                        final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        String string131 = "";
                        int i132 = 0;
                        int i133 = string.indexOf("\n", 0);
                        while (i133 != -1 && i132 < string.length()) {
                            String string134 = string.substring(i132, i133);
                            string134 = string134.trim();
                            i132 = i133 + 1;
                            i133 = string.indexOf("\n", i132);
                            if (!string134.startsWith("physics("))
                                string131 = new StringBuilder().append(string131).append("").append(string134)
                                        .append("\n").toString();
                            else {
                                string131 = string131.trim();
                                string131 = new StringBuilder().append(string131).append("\n").toString();
                            }
                        }
                        string131 = string131.trim();
                        string131 = new StringBuilder().append(string131).append("\n\n\nphysics(").append(phys[0])
                                .append(",").append(phys[1]).append(",").append(phys[2]).append(",").append(phys[3])
                                .append(",").append(phys[4]).append(",").append(phys[5]).append(",").append(phys[6])
                                .append(",").append(phys[7]).append(",").append(phys[8]).append(",").append(phys[9])
                                .append(",").append(phys[10]).append(",").append(crash[0]).append(",").append(crash[1])
                                .append(",").append(crash[2]).append(",").append(engsel).append(",").append(actmag)
                                .append(")\n\n\n\n").toString();
                        editor.setText(string131);
                        savefile();
                        for (int i135 = 0; i135 < 11; i135++)
                            rphys[i135] = phys[i135];
                        for (int i136 = 0; i136 < 3; i136++)
                            rcrash[i136] = crash[i136];
                        pfase = 5;
                    }
                    if (pfase == 5) {
                        rd.drawString("Car physics has been successfully set up!", 231, 450);
                        rd.drawString("Test drive your car to see the results...", 242, 490);
                    }
                    if (i95 != -1) {
                        if (mouseon == -1) {
                            mouseon = i95;
                            setCursor(new Cursor(12));
                        }
                    } else if (mouseon != -1) {
                        mouseon = -1;
                        setCursor(new Cursor(0));
                    }
                    if (mouses == -1 && i95 != -1)
                        JOptionPane.showMessageDialog(null, usage[i95], "Car Maker", 1);
                }
                if (dtab == 6) {
                    if (dtab != dtabed) {
                        final String string = new StringBuilder().append("").append(editor.getText()).append("\n")
                                .toString();
                        int i137 = 0;
                        int i138 = string.indexOf("\n", 0);
                        while (i138 != -1 && i137 < string.length()) {
                            String string139 = string.substring(i137, i138);
                            string139 = string139.trim();
                            i137 = i138 + 1;
                            i138 = string.indexOf("\n", i137);
                            if (string139.startsWith("handling("))
                                try {
                                    handling = getvalue("handling", string139, 0);
                                    if (handling > 200)
                                        handling = 200;
                                    if (handling < 50)
                                        handling = 50;
                                } catch (final Exception exception) {
                                    
                                }
                        }
                        rateh = false;
                    }
                    if (!rateh) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("Test Drive the Car", 350 - ftm.stringWidth("Test Drive the Car") / 2, 445);
                        witho.move(292, 455);
                        if (!witho.isShowing())
                            witho.setVisible(true);
                        stringbutton("     TEST DRIVE!     ", 350, 505, 0, true);
                        if (tested) {
                            stringbutton("  Edit Stats & Class  ", 150, 471, 0, false);
                            stringbutton("  Edit Physics  ", 150, 505, 0, false);
                            stringbutton("     Rate Car Handling     ", 550, 471, 0, true);
                        }
                    } else {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(
                                new StringBuilder().append("Based on you test drive(s), how do your rate ")
                                        .append(carname).append("'s handling?").toString(),
                                350 - ftm.stringWidth(
                                        new StringBuilder().append("Based on your test drive(s), how do you rate ")
                                                .append(carname).append("'s handling?").toString())
                                        / 2,
                                445);
                        rd.setFont(new Font("Arial", 1, 12));
                        rd.drawString("Handling :", 183, 483);
                        for (int i140 = 0; i140 < handling; i140++) {
                            rd.setColor(Color.getHSBColor((float) (i140 * 7.0E-4), 1.0F, 1.0F));
                            rd.drawLine(250 + i140, 474, 250 + i140, 482);
                        }
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawLine(249, 474, 249, 482);
                        rd.drawLine(450, 474, 450, 482);
                        rd.drawLine(249, 483, 450, 483);
                        for (int i141 = 0; i141 < 7; i141++)
                            rd.drawLine(275 + i141 * 25, 482, 275 + i141 * 25, 478);
                        stringbutton(" - ", 480, 483, 4, false);
                        stringbutton(" + ", 520, 483, 4, false);
                        stringbutton("       Save       ", 388, 525, 0, true);
                        stringbutton(" Cancel ", 298, 525, 0, false);
                    }
                }
                if (polynum >= 0 && cntpls > 0) {
                    for (int i142 = 0; i142 < o.npl; i142++)
                        if (i142 >= polynum && i142 < polynum + cntpls) {
                            if (pflk)
                                o.p[i142].hsb[2] = 1.0F;
                            else {
                                o.p[i142].hsb[2] = 0.0F;
                                o.p[i142].hsb[0] = Math.abs(0.5F - o.p[i142].hsb[0]);
                                while (o.p[i142].hsb[0] > 1.0F)
                                    o.p[i142].hsb[0]--;
                            }
                        } else if (prflk > 6 && prflk < 20)
                            o.p[i142].gr = -13;
                        else
                            o.p[i142].gr = 1;
                    if (pflk)
                        pflk = false;
                    else
                        pflk = true;
                    if (prflk < 40)
                        prflk++;
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(
                            new StringBuilder().append("[ Showing ").append(cntpls).append(" Polygons Selected ]")
                                    .toString(),
                            350 - ftm.stringWidth(new StringBuilder().append("[ Showing ").append(cntpls)
                                    .append(" Polygons Selected ]").toString()) / 2,
                            45);
                    stringbutton("  Stop  ", 350, 67, 5, false);
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
                            "Car Wheels not defined or not defined correctly.\nBefore defining the car Physics car Wheels must be defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n",
                            "Car Maker", 1);
                    dtab = 3;
                }
            }
            if (tab == 3) {
                rd.setFont(new Font("Arial", 1, 13));
                rd.setColor(new Color(0, 0, 0));
                rd.drawString(new StringBuilder().append("Publish Car :  [ ").append(carname).append(" ]").toString(),
                        30, 50);
                rd.drawString("Publishing Type :", 30, 80);
                pubtyp.move(150, 63);
                if (!pubtyp.isShowing()) {
                    pubtyp.setVisible(true);
                    pubtyp.select(1);
                }
                stringbutton("       Publish  >       ", 102, 110, 0, true);
                rd.setColor(new Color(0, 0, 0));
                rd.setFont(new Font("Arial", 0, 12));
                if (pubtyp.getSelectedIndex() == 0) {
                    rd.drawString("Private :  This means only you can use your car and no one else can add", 268, 72);
                    rd.drawString("it to their account to play with it !", 268, 88);
                }
                if (pubtyp.getSelectedIndex() == 1) {
                    rd.drawString("Public :  This means anyone can add this car to their account to play with it,", 268,
                            72);
                    rd.drawString(
                            "but only you can download it to your Car Maker (no one else can get it\u2019s code).", 268,
                            88);
                }
                if (pubtyp.getSelectedIndex() == 2) {
                    rd.drawString("Super Public :  This means anyone can add this car to their account to play", 268,
                            72);
                    rd.drawString("with it and anyone can also download it to their Car Maker to get its code.", 268,
                            88);
                }
                rd.setFont(new Font("Arial", 1, 12));
                ftm = rd.getFontMetrics();
                rd.drawString("Car Name", 80 - ftm.stringWidth("Car Name") / 2, 138);
                rd.drawString("Car Class", 200 - ftm.stringWidth("Car Class") / 2, 138);
                rd.drawString("Created By", 300 - ftm.stringWidth("Created By") / 2, 138);
                rd.drawString("Added By", 400 - ftm.stringWidth("Added By") / 2, 138);
                rd.drawString("Publish Type", 500 - ftm.stringWidth("Publish Type") / 2, 138);
                rd.drawString("Options", 620 - ftm.stringWidth("Options") / 2, 138);
                rd.drawLine(150, 129, 150, 140);
                rd.drawLine(250, 129, 250, 140);
                rd.drawLine(350, 129, 350, 140);
                rd.drawLine(450, 129, 450, 140);
                rd.drawLine(550, 129, 550, 140);
                rd.drawRect(10, 140, 680, 402);
                if (logged == 0) {
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.drawString("The maximum number of cars your account can have at once is 20 cars.", 350
                            - ftm.stringWidth("The maximum number of cars your account can have at once is 20 cars.")
                                    / 2,
                            180);
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Login to Retrieve your Account Cars",
                            350 - ftm.stringWidth("Login to Retrieve your Account Cars") / 2, 220);
                    rd.drawString("Nickname:", 326 - ftm.stringWidth("Nickname:") - 14, 266);
                    movefield(tnick, 326, 250, 129, 22);
                    if (!tnick.isShowing())
                        tnick.setVisible(true);
                    rd.drawString("Password:", 326 - ftm.stringWidth("Password:") - 14, 296);
                    movefield(tpass, 326, 280, 129, 22);
                    if (!tpass.isShowing())
                        tpass.setVisible(true);
                    stringbutton("       Login       ", 350, 340, 0, true);
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Not registered yet?", 350 - ftm.stringWidth("Not registered yet?") / 2, 450);
                    stringbutton("   Register Now!   ", 350, 480, 0, true);
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Register to publish your cars to the multiplayer game!",
                            350 - ftm.stringWidth("Register to publish your cars to the multiplayer game!") / 2, 505);
                }
                if (logged == -1) {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Account empty, no published cars found.",
                            350 - ftm.stringWidth("Account empty, no published cars found.") / 2, 220);
                    rd.drawString("Click \u2018Publish\u2019 above to begin.",
                            350 - ftm.stringWidth("Click \u2018Publish\u2019 above to begin.") / 2, 280);
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.drawString("The maximum number of cars your account can have at once is 20 cars.", 350
                            - ftm.stringWidth("The maximum number of cars your account can have at once is 20 cars.")
                                    / 2,
                            320);
                }
                if (logged == 2) {
                    for (int i143 = 0; i143 < nmc; i143++) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(225, 225, 225));
                        rd.fillRect(50, 150, 600, 150);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString(
                                new StringBuilder().append("Loading ").append(mycars[i143]).append("\u2018s info...")
                                        .toString(),
                                350 - ftm.stringWidth(new StringBuilder().append("Loading ").append(mycars[i143])
                                        .append("\u2018s info...").toString()) / 2,
                                220);
                        repaint();
                        maker[i143] = "Unkown";
                        pubt[i143] = -1;
                        clas[i143] = 0;
                        nad[i143] = 0;
                        String string = "";
                        try {
                            String string144 = new StringBuilder().append("http://multiplayer.needformadness.com/cars/")
                                    .append(mycars[i143]).append(".txt?reqlo=").append((int) (Math.random() * 1000.0))
                                    .append("").toString();
                            string144 = string144.replace(' ', '_');
                            final URL url = new URL(string144);
                            final DataInputStream datainputstream = new DataInputStream(url.openStream());
                            while ((string = datainputstream.readLine()) != null) {
                                string = new StringBuilder().append("").append(string.trim()).toString();
                                if (string.startsWith("details")) {
                                    maker[i143] = getSvalue("details", string, 0);
                                    pubt[i143] = getvalue("details", string, 1);
                                    clas[i143] = getvalue("details", string, 2);
                                    boolean bool145 = false;
                                    while (!bool145) {
                                        addeda[i143][nad[i143]] = getSvalue("details", string, 3 + nad[i143]);
                                        if (addeda[i143][nad[i143]].equals(""))
                                            bool145 = true;
                                        else
                                            nad[i143]++;
                                    }
                                }
                            }
                        } catch (final Exception exception) {
                            
                        }
                    }
                    setCursor(new Cursor(0));
                    logged = 3;
                }
                if (logged == 1) {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Loading your account car list...",
                            350 - ftm.stringWidth("Loading your account car list...") / 2, 220);
                    repaint();
                    nmc = 0;
                    String string = "";
                    try {
                        final URL url = new URL(new StringBuilder()
                                .append("http://multiplayer.needformadness.com/cars/lists/").append(tnick.getText())
                                .append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                        final DataInputStream datainputstream = new DataInputStream(url.openStream());
                        while ((string = datainputstream.readLine()) != null) {
                            string = new StringBuilder().append("").append(string.trim()).toString();
                            if (string.startsWith("mycars")) {
                                boolean bool146 = true;
                                while (bool146 && nmc < 20) {
                                    mycars[nmc] = getSvalue("mycars", string, nmc);
                                    if (mycars[nmc].equals(""))
                                        bool146 = false;
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
                        final String string147 = new StringBuilder().append("").append(exception).toString();
                        if (string147.indexOf("FileNotFound") != -1) {
                            setCursor(new Cursor(0));
                            logged = -1;
                        } else {
                            logged = 0;
                            JOptionPane.showMessageDialog(null,
                                    "Unable to connect to server at this moment, please try again later.", "Car Maker",
                                    1);
                        }
                    }
                }
                if (logged == 3)
                    for (int i148 = 0; i148 < nmc; i148++) {
                        rd.setColor(new Color(235, 235, 235));
                        if (xm > 11 && xm < 689 && ym > 142 + i148 * 20 && ym < 160 + i148 * 20)
                            rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(11, 142 + i148 * 20, 678, 18);
                        rd.setFont(new Font("Arial", 0, 12));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString(mycars[i148], 80 - ftm.stringWidth(mycars[i148]) / 2, 156 + i148 * 20);
                        rd.setColor(new Color(155, 155, 155));
                        rd.drawLine(150, 145 + i148 * 20, 150, 157 + i148 * 20);
                        if (pubt[i148] != -1) {
                            rd.drawLine(250, 145 + i148 * 20, 250, 157 + i148 * 20);
                            rd.drawLine(350, 145 + i148 * 20, 350, 157 + i148 * 20);
                            rd.drawLine(450, 145 + i148 * 20, 450, 157 + i148 * 20);
                            rd.drawLine(550, 145 + i148 * 20, 550, 157 + i148 * 20);
                            rd.setColor(new Color(0, 0, 64));
                            String string = "C";
                            if (clas[i148] == 1)
                                string = "B & C";
                            if (clas[i148] == 2)
                                string = "B";
                            if (clas[i148] == 3)
                                string = "A & B";
                            if (clas[i148] == 4)
                                string = "A";
                            rd.drawString(new StringBuilder().append("Class ").append(string).append("").toString(),
                                    200 - ftm.stringWidth(
                                            new StringBuilder().append("Class ").append(string).append("").toString())
                                            / 2,
                                    156 + i148 * 20);
                            boolean bool149 = false;
                            if (maker[i148].toLowerCase().equals(tnick.getText().toLowerCase())) {
                                bool149 = true;
                                rd.setColor(new Color(0, 64, 0));
                                rd.drawString("You", 300 - ftm.stringWidth("You") / 2, 156 + i148 * 20);
                            } else
                                rd.drawString(maker[i148], 300 - ftm.stringWidth(maker[i148]) / 2, 156 + i148 * 20);
                            if (nad[i148] > 1) {
                                if (ovbutton(
                                        new StringBuilder().append("").append(nad[i148]).append(" Players").toString(),
                                        400, 156 + i148 * 20)) {
                                    String string150 = new StringBuilder().append("[ ").append(mycars[i148])
                                            .append(" ]  has been added by the following players to their accounts:     \n\n")
                                            .toString();
                                    int i151 = 0;
                                    for (int i152 = 0; i152 < nad[i148]; i152++) {
                                        if (++i151 == 17) {
                                            string150 = new StringBuilder().append(string150).append("\n").toString();
                                            i151 = 1;
                                        }
                                        string150 = new StringBuilder().append(string150).append(addeda[i148][i152])
                                                .toString();
                                        if (i152 != nad[i148] - 1)
                                            if (i152 != nad[i148] - 2)
                                                string150 = new StringBuilder().append(string150).append(", ")
                                                        .toString();
                                            else if (i151 == 16) {
                                                string150 = new StringBuilder().append(string150).append("\nand ")
                                                        .toString();
                                                i151 = 0;
                                            } else
                                                string150 = new StringBuilder().append(string150).append(" and ")
                                                        .toString();
                                    }
                                    string150 = new StringBuilder().append(string150).append("\n \n \n").toString();
                                    JOptionPane.showMessageDialog(null, string150, "Car Maker", 1);
                                }
                            } else {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("None", 400 - ftm.stringWidth("None") / 2, 156 + i148 * 20);
                            }
                            if (pubt[i148] == 0) {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("Private", 500 - ftm.stringWidth("Private") / 2, 156 + i148 * 20);
                            }
                            if (pubt[i148] == 1) {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("Public", 500 - ftm.stringWidth("Public") / 2, 156 + i148 * 20);
                            }
                            if (pubt[i148] == 2) {
                                rd.setColor(new Color(0, 64, 0));
                                rd.drawString("Super Public", 500 - ftm.stringWidth("Super Public") / 2,
                                        156 + i148 * 20);
                            }
                            if ((pubt[i148] == 2 || bool149) && ovbutton("Download", 600, 156 + i148 * 20)) {
                                int i153 = 0;
                                for (int i154 = 0; i154 < slcar.getItemCount(); i154++)
                                    if (mycars[i148].equals(slcar.getItem(i154)))
                                        i153 = JOptionPane.showConfirmDialog(null,
                                                new StringBuilder().append("Replace the local ").append(mycars[i148])
                                                        .append(" in your 'mycars' folder with the published online copy?")
                                                        .toString(),
                                                "Car Maker", 0);
                                if (i153 == 0) {
                                    setCursor(new Cursor(3));
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.setColor(new Color(225, 225, 225));
                                    rd.fillRect(11, 141, 679, 401);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("Downloading car, please wait...",
                                            350 - ftm.stringWidth("Downloading car, please wait...") / 2, 250);
                                    repaint();
                                    try {
                                        String string155 = new StringBuilder()
                                                .append("http://multiplayer.needformadness.com/cars/")
                                                .append(mycars[i148]).append(".radq?reqlo=")
                                                .append((int) (Math.random() * 1000.0)).append("").toString();
                                        string155 = string155.replace(' ', '_');
                                        final URL url = new URL(string155);
                                        final int i156 = url.openConnection().getContentLength();
                                        final DataInputStream datainputstream = new DataInputStream(url.openStream());
                                        final byte[] is = new byte[i156];
                                        datainputstream.readFully(is);
                                        ZipInputStream zipinputstream;
                                        if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                                            zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                                        else {
                                            final byte[] is157 = new byte[i156 - 40];
                                            for (int i158 = 0; i158 < i156 - 40; i158++) {
                                                int i159 = 20;
                                                if (i158 >= 500)
                                                    i159 = 40;
                                                is157[i158] = is[i158 + i159];
                                            }
                                            zipinputstream = new ZipInputStream(new ByteArrayInputStream(is157));
                                        }
                                        final ZipEntry zipentry = zipinputstream.getNextEntry();
                                        if (zipentry != null) {
                                            int i160 = Integer.valueOf(zipentry.getName()).intValue();
                                            final byte[] is161 = new byte[i160];
                                            int i162 = 0;
                                            int i163;
                                            for (/**/; i160 > 0; i160 -= i163) {
                                                i163 = zipinputstream.read(is161, i162, i160);
                                                i162 += i163;
                                            }
                                            String string164 = new String(is161);
                                            string164 = new StringBuilder().append(string164).append("\n").toString();
                                            String string165 = "";
                                            int i166 = 0;
                                            int i167 = string164.indexOf("\n", 0);
                                            while (i167 != -1 && i166 < string164.length()) {
                                                String string168 = string164.substring(i166, i167);
                                                string168 = string168.trim();
                                                i166 = i167 + 1;
                                                i167 = string164.indexOf("\n", i166);
                                                if (!string168.startsWith("carmaker(")
                                                        && !string168.startsWith("publish("))
                                                    string165 = new StringBuilder().append(string165).append("")
                                                            .append(string168).append("\n").toString();
                                                else {
                                                    string165 = string165.trim();
                                                    string165 = new StringBuilder().append(string165).append("\n")
                                                            .toString();
                                                }
                                            }
                                            string165 = string165.trim();
                                            string165 = new StringBuilder().append(string165).append("\n\n").toString();
                                            File file = new File("mycars/");
                                            if (!file.exists())
                                                file.mkdirs();
                                            file = new File(new StringBuilder().append("mycars/").append(mycars[i148])
                                                    .append(".rad").toString());
                                            final BufferedWriter bufferedwriter = new BufferedWriter(
                                                    new FileWriter(file));
                                            bufferedwriter.write(string165);
                                            bufferedwriter.close();
                                            zipinputstream.close();
                                            if (carname.equals(mycars[i148])) {
                                                editor.setText(string165);
                                                lastedo = string165;
                                            }
                                            setCursor(new Cursor(0));
                                            JOptionPane.showMessageDialog(null,
                                                    new StringBuilder().append("").append(mycars[i148])
                                                            .append(" has been successfully downloaded!").toString(),
                                                    "Car Maker", 1);
                                        } else
                                            JOptionPane.showMessageDialog(null,
                                                    "Unable to download car.  Unknown Error!     \nPlease try again later.",
                                                    "Car Maker", 1);
                                    } catch (final Exception exception) {
                                        JOptionPane.showMessageDialog(null,
                                                "Unable to download car.  Unknown Error!     \nPlease try again later.",
                                                "Car Maker", 1);
                                    }
                                }
                            }
                        } else
                            rd.drawString("-    Error Loading this car's info!    -",
                                    350 - ftm.stringWidth("-    Error Loading this car's info!    -") / 2,
                                    156 + i148 * 20);
                        if (ovbutton("X", 665, 156 + i148 * 20)
                                && JOptionPane
                                        .showConfirmDialog(null,
                                                new StringBuilder().append("Remove ").append(mycars[i148])
                                                        .append(" from your account?").toString(),
                                                "Car Maker", 0) == 0) {
                            setCursor(new Cursor(3));
                            int i169 = -1;
                            try {
                                final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                final BufferedReader bufferedreader = new BufferedReader(
                                        new InputStreamReader(socket.getInputStream()));
                                final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                                printwriter.println(new StringBuilder().append("9|").append(tnick.getText()).append("|")
                                        .append(tpass.getText()).append("|").append(mycars[i148]).append("|")
                                        .toString());
                                final String string = bufferedreader.readLine();
                                if (string != null)
                                    i169 = servervalue(string, 0);
                                socket.close();
                            } catch (final Exception exception) {
                                i169 = -1;
                            }
                            if (i169 == 0)
                                logged = 1;
                            else {
                                setCursor(new Cursor(0));
                                JOptionPane.showMessageDialog(null,
                                        new StringBuilder().append("Failed to remove ").append(mycars[i148])
                                                .append(" from your account.  Unknown Error!     \nPlease try again later.")
                                                .toString(),
                                        "Car Maker", 1);
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
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            final String[] strings = {
                    "Car", "Code Edit", "3D Edit", "Publish"
            };
            final int[] is = {
                    0, 0, 100, 90
            };
            final int[] is170 = {
                    0, 25, 25, 0
            };
            int i171 = 4;
            if (carname.equals("") || !loadedfile || sfase != 0) {
                tab = 0;
                i171 = 1;
            }
            for (int i172 = 0; i172 < i171; i172++) {
                rd.setColor(new Color(170, 170, 170));
                if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25)
                    rd.setColor(new Color(200, 200, 200));
                if (tab == i172)
                    rd.setColor(new Color(225, 225, 225));
                rd.fillPolygon(is, is170, 4);
                rd.setColor(new Color(0, 0, 0));
                rd.drawString(strings[i172], i172 * 100 + 45 - ftm.stringWidth(strings[i172]) / 2, 17);
                if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25 && mouses == -1) {
                    if (tab != i172 && tab == 1)
                        savefile();
                    tab = i172;
                }
                for (int i173 = 0; i173 < 4; i173++)
                    is[i173] += 100;
            }
            drawms();
            ctachm();
            repaint();
            if (!exwist)
                try {
                    if (thredo != null) {
                        
                    }
                    Thread.sleep(i);
                } catch (final InterruptedException interruptedexception) {
                    
                }
        }
        rd.dispose();
        System.gc();
    }

    public void savefile() {
        if (!editor.getText().equals(""))
            try {
                File file = new File("mycars/");
                if (!file.exists())
                    file.mkdirs();
                file = new File(new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(editor.getText());
                bufferedwriter.close();
                changed = false;
                lastedo = editor.getText();
            } catch (final Exception exception) {
                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to save file! Error Deatials:\n")
                        .append(exception).toString(), "Car Maker", 1);
            }
        savesettings();
    }

    public void savesettings() {
        if (!scar.equals(carname) || !suser.equals(tnick.getText()) || !sfont.equals(cfont) || cthm != sthm) {
            final String string = new StringBuilder().append("").append(carname).append("\n").append(tnick.getText())
                    .append("\n").append(cfont).append("\n").append(cthm).append("\n\n").toString();
            scar = carname;
            suser = tnick.getText();
            sfont = cfont;
            sthm = cthm;
            try {
                File file = new File("mycars/");
                if (!file.exists())
                    file.mkdirs();
                file = new File("mycars/settings.data");
                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(string);
                bufferedwriter.close();
            } catch (final Exception exception) {
                
            }
        }
    }

    public String serverSvalue(final String string, final int i) {
        String string380 = "";
        try {
            int i381 = 0;
            int i382 = 0;
            int i383 = 0;
            String string384 = "";
            String string385 = "";
            for (/**/; i381 < string.length() && i383 != 2; i381++) {
                string384 = new StringBuilder().append("").append(string.charAt(i381)).toString();
                if (string384.equals("|")) {
                    i382++;
                    if (i383 == 1 || i382 > i)
                        i383 = 2;
                } else if (i382 == i) {
                    string385 = new StringBuilder().append(string385).append(string384).toString();
                    i383 = 1;
                }
            }
            string380 = string385;
        } catch (final Exception exception) {
            
        }
        return string380;
    }

    public int servervalue(final String string, final int i) {
        int i374 = -1;
        try {
            int i375 = 0;
            int i376 = 0;
            int i377 = 0;
            String string378 = "";
            String string379 = "";
            for (/**/; i375 < string.length() && i377 != 2; i375++) {
                string378 = new StringBuilder().append("").append(string.charAt(i375)).toString();
                if (string378.equals("|")) {
                    i376++;
                    if (i377 == 1 || i376 > i)
                        i377 = 2;
                } else if (i376 == i) {
                    string379 = new StringBuilder().append(string379).append(string378).toString();
                    i377 = 1;
                }
            }
            if (string379.equals(""))
                string379 = "-1";
            i374 = Integer.valueOf(string379).intValue();
        } catch (final Exception exception) {
            
        }
        return i374;
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
        if (o.errd && (!o.err.startsWith("Wheels Error:") || forwheels))
            JOptionPane.showMessageDialog(null, o.err, "Car Maker", 0);
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

    public void stringbutton(final String string, final int i, final int i393, final int i394, final boolean bool) {
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        if (string.indexOf("Publish") != -1) {
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
        }
        bx[btn] = i;
        by[btn] = i393 - 5;
        bw[btn] = ftm.stringWidth(string);
        if (!pessd[btn]) {
            rd.setColor(new Color(220, 220, 220));
            if (bool)
                rd.setColor(new Color(230, 230, 230));
            rd.fillRect(i - bw[btn] / 2 - 10, i393 - (17 - i394), bw[btn] + 20, 25 - i394 * 2);
            rd.setColor(new Color(240, 240, 240));
            if (bool)
                rd.setColor(new Color(255, 255, 255));
            rd.drawLine(i - bw[btn] / 2 - 10, i393 - (17 - i394), i + bw[btn] / 2 + 10, i393 - (17 - i394));
            rd.drawLine(i - bw[btn] / 2 - 10, i393 - (18 - i394), i + bw[btn] / 2 + 10, i393 - (18 - i394));
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 9, i393 - (19 - i394), i + bw[btn] / 2 + 9, i393 - (19 - i394));
            rd.setColor(new Color(200, 200, 200));
            if (bool)
                rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i + bw[btn] / 2 + 10, i393 - (17 - i394), i + bw[btn] / 2 + 10, i393 + 7 - i394);
            rd.drawLine(i + bw[btn] / 2 + 11, i393 - (17 - i394), i + bw[btn] / 2 + 11, i393 + 7 - i394);
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i + bw[btn] / 2 + 12, i393 - (16 - i394), i + bw[btn] / 2 + 12, i393 + 6 - i394);
            if (bool)
                rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - bw[btn] / 2 - 10, i393 + 7 - i394, i + bw[btn] / 2 + 10, i393 + 7 - i394);
            rd.drawLine(i - bw[btn] / 2 - 10, i393 + 8 - i394, i + bw[btn] / 2 + 10, i393 + 8 - i394);
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i - bw[btn] / 2 - 9, i393 + 9 - i394, i + bw[btn] / 2 + 9, i393 + 9 - i394);
            rd.setColor(new Color(240, 240, 240));
            if (bool)
                rd.setColor(new Color(255, 255, 255));
            rd.drawLine(i - bw[btn] / 2 - 10, i393 - (17 - i394), i - bw[btn] / 2 - 10, i393 + 7 - i394);
            rd.drawLine(i - bw[btn] / 2 - 11, i393 - (17 - i394), i - bw[btn] / 2 - 11, i393 + 7 - i394);
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 12, i393 - (16 - i394), i - bw[btn] / 2 - 12, i393 + 6 - i394);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2, i393);
        } else {
            rd.setColor(new Color(220, 220, 220));
            rd.fillRect(i - bw[btn] / 2 - 10, i393 - (17 - i394), bw[btn] + 20, 25 - i394 * 2);
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - bw[btn] / 2 - 10, i393 - (17 - i394), i + bw[btn] / 2 + 10, i393 - (17 - i394));
            rd.drawLine(i - bw[btn] / 2 - 10, i393 - (18 - i394), i + bw[btn] / 2 + 10, i393 - (18 - i394));
            rd.drawLine(i - bw[btn] / 2 - 9, i393 - (19 - i394), i + bw[btn] / 2 + 9, i393 - (19 - i394));
            rd.setColor(new Color(247, 247, 247));
            rd.drawLine(i + bw[btn] / 2 + 10, i393 - (17 - i394), i + bw[btn] / 2 + 10, i393 + 7 - i394);
            rd.drawLine(i + bw[btn] / 2 + 11, i393 - (17 - i394), i + bw[btn] / 2 + 11, i393 + 7 - i394);
            rd.drawLine(i + bw[btn] / 2 + 12, i393 - (16 - i394), i + bw[btn] / 2 + 12, i393 + 6 - i394);
            rd.drawLine(i - bw[btn] / 2 - 10, i393 + 7 - i394, i + bw[btn] / 2 + 10, i393 + 7 - i394);
            rd.drawLine(i - bw[btn] / 2 - 10, i393 + 8 - i394, i + bw[btn] / 2 + 10, i393 + 8 - i394);
            rd.drawLine(i - bw[btn] / 2 - 9, i393 + 9 - i394, i + bw[btn] / 2 + 9, i393 + 9 - i394);
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - bw[btn] / 2 - 10, i393 - (17 - i394), i - bw[btn] / 2 - 10, i393 + 7 - i394);
            rd.drawLine(i - bw[btn] / 2 - 11, i393 - (17 - i394), i - bw[btn] / 2 - 11, i393 + 7 - i394);
            rd.drawLine(i - bw[btn] / 2 - 12, i393 - (16 - i394), i - bw[btn] / 2 - 12, i393 + 6 - i394);
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2 + 1, i393 + 1);
        }
        btn++;
    }

    @Override
    public void update(final Graphics graphics) {
        paint(graphics);
    }

    public int xs(final int i, int i338) {
        if (i338 < m.cz)
            i338 = m.cz;
        return (i338 - m.focusPoint) * (m.cx - i) / i338 + i;
    }

    public int ys(final int i, int i339) {
        if (i339 < m.cz)
            i339 = m.cz;
        return (i339 - m.focusPoint) * (m.cy - i) / i339 + i;
    }
}
