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
public class CarMaker extends Applet implements Runnable, ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7903118983954264757L;
	Graphics2D rd;
    Image offImage;
    Thread thredo;
    boolean exwist = false;
    FontMetrics ftm;
    int apx = 0;
    int apy = 0;
    boolean focuson = true;
    Image[] btgame = new Image[2];
    Image logo;
    boolean onbtgame = false;
    int tab = 0;
    int tabed = -1;
    boolean loadedfile = false;
    String carname = "";
    String scar = "";
    String suser = "Horaks";
    String sfont = "Monospaced";
    int sthm = 0;
    int sfase = 0;
    Smenu slcar = new Smenu(2000);
    boolean tutok = false;
    int flk = 0;
    boolean changed = false;
    String lastedo = "";
    boolean prefs = false;
    boolean mirror = false;
    PopupMenu popupMenu;
    TextArea editor = new TextArea(20, 20);
    TextField srch = new TextField("", 15);
    TextField rplc = new TextField("", 15);
    Smenu fontsel = new Smenu(40);
    String cfont = "Monospaced";
    Smenu ctheme = new Smenu(40);
    Color defb;
    Color deff;
    int cthm = 0;
    int cntprf = 0;
    int cntpls = 0;
    int cntchk = 0;
    int npolys = 0;
    boolean tomany = false;
    int ox = 335;
    int oy = 40;
    int oz = 800;
    int oxz = -90;
    int oxy = 0;
    int ozy = 0;
    Medium m = new Medium();
    Trackers t = new Trackers();
    ContO o;
    ContO[] compo = new ContO[16];
    boolean right = false;
    boolean left = false;
    boolean up = false;
    boolean down = false;
    boolean rotl = false;
    boolean rotr = false;
    boolean plus = false;
    boolean minus = false;
    boolean in = false;
    boolean out = false;
    boolean pflk = false;
    boolean breakbond = false;
    int polynum = -1;
    int prflk = 0;
    int bfo = 0;
    int dtab = 0;
    int dtabed = -1;
    int mouseon = -1;
    String fcol = "";
    String ofcol = "";
    String scol = "";
    String oscol = "";
    float[] fhsb = { 0.5F, 0.5F, 0.5F };
    float[] shsb = { 0.5F, 0.5F, 0.5F };
    int[] scale = { 100, 100, 100 };
    int[] oscale = { 100, 100, 100 };
    Smenu compcar = new Smenu(40);
    int compsel = 0;
    int[] adna = { 276, 276, 276, 276, 276, 276 };
    boolean changed2 = false;
    TextField[] wv = new TextField[16];
    boolean defnow = false;
    String aply1 = "";
    String aply2 = "";
    boolean aplyd1 = false;
    boolean aplyd2 = false;
    boolean forwheels = false;
    Smenu cls = new Smenu(40);
    Smenu simcar = new Smenu(40);
    int[] stat = { 100, 100, 100, 100, 100 };
    int[] rstat = { 0, 0, 0, 0, 0 };
    int[][] carstat = { { 110, 81, 131, 98, 100 }, { 200, 200, 88, 16, 16 }, { 108, 80, 93, 114, 125 }, { 146, 119, 100, 83, 72 }, { 109, 85, 141, 96, 93 }, { 128, 98, 102, 109, 123 }, { 115, 139, 96, 117, 133 }, { 120, 81, 145, 126, 128 }, { 140, 122, 101, 113, 124 }, { 110, 144, 100, 154, 92 }, { 133, 122, 144, 115, 126 }, { 107, 96, 96, 192, 189 }, { 192, 200, 106, 92, 90 }, { 88, 104, 88, 200, 200 }, { 148, 150, 197, 95, 90 }, { 112, 128, 120, 192, 128 } };
    int carsel = 0;
    int clsel = 0;
    boolean statdef = false;
    int pfase = 0;
    int[] phys = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
    int[] rphys = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
    int[] crash = { 50, 50, 50 };
    int[] rcrash = { 50, 50, 50 };
    String[] pname = { "Handbrake", "Turning Sensitivity", "Tire Grip", "Bouncing", "Empty", "Lifts Others", "Gets Lifted", "Pushes Others", "Gets Pushed", "Aerial Rotation Speed", "Aerial Control/Gliding" };
    int[] pnx = { 62, 20, 76, 71, 60, 38, 44, 20, 33, 320, 324 };
    String[] usage = { "Handbrake:\nThis defines the hand braking power of the car.\nThe more handbrake the car has the faster it brakes when you press Spacebar while driving.\nBut also the lesser the Handbrake the more the car can drift when you press Spacebar.\n\n", "Turning Sensitivity:\nThis defines how fast the car turns (or how fast the wheels respond to turning).\nThe more turning sensitive the faster the car turns and responds.\n\nWhen designing a fast car that is more racing oriented high turning sensitivity is     \nrecommended for the car to be able to take sharp and quick turns.\nHowever too much turning sensitivity can make the car hard to drive!\n\nWhen designing a slower and bigger car (like El King) lower turning sensitivity is\nrecommended for a more realistic effect.\n\n", "Tires Grip:\nThis defines the griping power of the car\u2019s wheels on the ground.\n\nThe more griping the more the cars sticks to track.\nThe less gripping the more the car drifts in the turns.\n\nSome drifting can be helpful as it makes the car drive smoother while less drifting can\nmake the car more irritable, it depends on how you like to drive the car and how it\nfeels for you.\n\n", "Bouncing:\nThis defines how the car bounces back when it hits the ground or obstacles.\n\nBouncing can help when performing stunts as when you land up side down\nif the car bounces it can be filliped over before landing again to avoid a 'bad landing'.\n\nHowever bouncing is not helpful in controlling the car and in racing.\n\n", "If you can read this then you are decompiling the code! Please don\u2019t bother trying to allow the car maker to give you max stats, the stats get check on the server before the car can be accepted. Just to save you sometime.", "Lifts Others:\nThis defines if the car lifts up other cars when it collides with them from the front and\nhow high it can lift them.\n\nDoes the car have a pointy nose like MAX Revenge, Radical One or La Vita Crab, a\npointy nose/front part that can go under the wheels of other cars and lift them?\nIf so then give it some Lifts Others.\n\nIf it has a nose/front part that is a block like most cars then give it 0 Lifts Others.\n\n", "Gets Lifted:\nThis defines if the car can get lifted over other cars when it collides with them and how\nhigh it can get lifted.\n\nIs the car higher off the ground like Wow Caninaro or has big wheels like Dr Monstaa,\nshould its jump over cars when it collides with them?\nIf so then give it some Gets Lifted depending on how high it should go.\n\nIf the car is lower to the ground like most cars then it should have 0 Gets Lifted\n\n", "Pushes Others:\nThis defines if the car pushes other cars away when it collides with them and how far it\ncan push them.\n\nIs the car a heavy car with a strong body like MASHEEN or El King, where when it\ncollides with other cars it pushes them away?\nOr does the car have special bumpers or body parts for pushing cars away like Sword of\nJustice has?\nIf so then give it some Pushes Others depending how strong you think it can push cars.\n\nIf it is a car like any other car, with an average weight and body strength then you should\ngive it 0 Pushes Others.\n\n", "Gets Pushed:\nThis defines if the car gets pushed away when it collides with other cars and how far it\ngets pushed away.\n\nIf the car is lighter then most cars, then it should get pushed away when it collides with\nothers cars.\nGetting pushed can be helpful if the car is week because it gets it away from the danger\n(from the car that hit it) faster, making it take lesser hits and escape better.\nHowever getting pushed is not helpful when racing.\n\n", "Aerial Rotation Speed:\nThis adjusts how fast the car can rotate and flip in the air when its performing a stunt.\n\nThis variable also depends on how much the \u2018Stunts\u2019 stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf you think the car is rotating too fast or too slow in the air when performing a stunt use\nthis variable to adjust that.\n\nIf the aerial rotation is too fast it can make the car hard to control in the air as it flips and\nhard to land upright.\n\nIf the car is a big and heavy car like MASHHEN or El King then it should have low\naerial rotation for a realistic effect.\n\n", "Aerial Control/Gliding:\nThis adjusts the cars ability to push itself in the air and glide when performing stunts!\n\nIf you don\u2019t know, in the game:\nBackward looping pushes the car upwards. \nForward looping pushes the car forwards. \nLeft and right rolling pushes the car left and right. \n\nThis variable adjust the power if this aerial push.\n\nThe variable also depends on how much the \u2018Stunts\u2019 stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf the car has some kind of wings or fins like Radical One or Kool Kat have then it should\nhave higher aerial control and gliding ability.\n\n", "Crash Look Test!\nThis defines how the car will look when it gets damaged.\nOr in other words what the car will look like as it gets damaged until it becomes wasted!\n\nIMPORTANT:\nYou need to perform a 'Normal Crash' test with a 'Roof Crash' test until the car gets totally destroyed (gets wasted and burns).\nYou need to also try a 'Normal Crash' test alone (without the roof crash) until the car gets wasted!\nA 'Roof Crash' happens significantly more when the car falls on its roof from a high jumps.\nA 'Normal Crash' is what happens as the car crashes normally with other cars and obstacles.\n\nClick any of adjustment variable names \u2018Radius\u2019, \u2018Magnitude\u2019 and \u2018Roof Destruction\u2019 to learn about their effect.\n\n>  You must perform the crash test more then once in order to make sure that this is how your want the car to look as it gets damaged\nuntil total destruction.", "Crash Radius:\nThe radius around the crash at which the polygons/pieces that lay inside it get\naffected.\n\nOr basically in other words the number of pieces that get affected on collision (the pieces\naround the crash location).\n\nIncreasing the radius will result in more pieces/polygons around the point of collision\ngetting crashed and distorted.\nDecreasing the radius means less pieces/polygons around the collision point getting\ndistorted and crashed.\n\n", "Crash Magnitude:\nThe magnitude of the distortion and indentation to occur on the effected pieces/polygons.\n\nOr basically in other words the amount of destruction that happens to each piece when\ncrashed.\n\nHigher magnitude means the piece gets more destructed from an amount of damage,\nlower magnitude means the piece gets less destructed from that same amount of damage.\n\n", "Roof Destruction:\nThe amount of destruction to occur on the car\u2019s top.\nThe length of indentation and destruction to happen from above.\n\nTo really see this variable's effect try crashing the roof alone (without a normal crash),\ntry more then once while fixing the car and changing the variable\u2019s value to see the\ndifference.\n\nThe roof crash normally happens in the game when the car lands upside down from a\njump or when a big car like Dr Monstaa steps on it.\n\n" };
    int hitmag = 0;
    int actmag = 0;
    int squash = 0;
    boolean crashok = false;
    boolean crashleft = false;
    soundClip[] crashs = new soundClip[3];
    soundClip[] lowcrashs = new soundClip[3];
    Smenu engine = new Smenu(40);
    soundClip[][] engs = new soundClip[5][5];
    int engsel = 0;
    boolean engon = false;
    Smenu witho = new Smenu(40);
    boolean tested = false;
    boolean rateh = false;
    int handling = 140;
    int logged = 0;
    TextField tnick = new TextField("", 15);
    TextField tpass = new TextField("", 15);
    Smenu pubtyp = new Smenu(40);
    int nmc = 0;
    String[] mycars = new String[20];
    String[] maker = new String[20];
    int[] pubt = new int[20];
    int[] clas = new int[20];
    String[][] addeda = new String[20][5000];
    int[] nad = new int[20];
    boolean[] pessd = { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false };
    int[] bx = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] by = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int[] bw = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    int btn = 0;
    int mouses = 0;
    int xm = 0;
    int ym = 0;
    int sls = -1;
    int sle = -1;
    int crshturn = 0;
    boolean crashup = false;
    boolean openm = false;
    boolean mousdr = false;
    boolean waso = false;
    boolean objfacend = false;
    boolean multf10 = false;
    
    public void run() {
        thredo.setPriority(10);
        btgame[0] = getImage("data/backtogame1.gif");
        btgame[1] = getImage("data/backtogame2.gif");
        logo = getImage("data/carmakerlogo.gif");
        (m).w = 700;
        (m).cx = 350;
        (m).y = -240;
        (m).z = -400;
        (m).zy = 4;
        (m).focus_point = 800;
        m.fadfrom(8000);
        (m).cfade[0] = 187;
        (m).cfade[1] = 210;
        (m).cfade[2] = 227;
        loadsounds();
        loadbase();
        (m).loadnew = true;
        loadsettings();
        editor.setFont(new Font(cfont, 1, 14));
        srch.setFont(new Font(cfont, 1, 14));
        rplc.setFont(new Font(cfont, 1, 14));
        for (int i = 0; i < 16; i++)
            wv[i].setFont(new Font(cfont, 1, 14));
        setheme();
        if (Madness.testdrive != 0) {
            if (Madness.testcar.equals("Failx12")) {
                JOptionPane.showMessageDialog(null, "Failed to load car! Please make sure car is saved before Test Drive.", "Car Maker", 1);
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
                    editor.enable();
                else
                    editor.disable();
                if (tabed == 2) {
                    if (!breakbond) {
                        if (!editor.getText().equals(lastedo))
                            editor.setText(lastedo);
                    } else
                        breakbond = false;
                }
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
                    (slcar).maxl = 200;
                    slcar.add(rd, "Select a Car                      ");
                    String[] strings = new File("mycars/").list();
                    if (strings != null) {
                        for (int i_0_ = 0; i_0_ < strings.length; i_0_++) {
                            if (strings[i_0_].toLowerCase().endsWith(".rad"))
                                slcar.add(rd, strings[i_0_].substring(0, strings[i_0_].length() - 4));
                        }
                    }
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
                if (!tutok && mouseon != 1 && !bool) {
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
                rd.drawString("If this is your first time creating a car please follow the tutorial found at:", 106, 110 + i_1_);
                rd.setColor(new Color(0, 128, 255));
                rd.drawString("http://www.needformadness.com/developer/simplecar.html", 106, 130 + i_1_);
                if (mouseon == 1)
                    rd.setColor(new Color(0, 128, 255));
                else
                    rd.setColor(new Color(0, 64, 128));
                rd.drawLine(106, 131 + i_1_, 480, 131 + i_1_);
                if (mouseon == 1)
                    rd.setColor(new Color(0, 64, 128));
                else
                    rd.setColor(new Color(0, 0, 0));
                rd.drawString("It is highly recommended that you follow this tutorial before trying anything!", 106, 150 + i_1_);
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
                rd.drawString("For the Car Maker Homepage, Development Center and Forums :", 350 - ftm.stringWidth("For the Car Maker Homepage, Development Center and Forums :") / 2, 480);
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
                int i_4_ = 0;
                if (sfase == 3)
                    i_4_ = 100;
                rd.setColor(new Color(0, 0, 0));
                rd.drawRect(177 - i_4_, 202 + i_2_, 346 + i_4_ * 2, 167 + i_4_ / 5);
                if (sfase == 0) {
                    rd.drawString("Select Car to Edit", 350 - ftm.stringWidth("Select Car to Edit") / 2, 230 + i_2_);
                    slcar.move(250, 240 + i_2_);
                    if (slcar.getWidth() != 200)
                        slcar.setSize(200, 21);
                    if (!slcar.isShowing())
                        slcar.show();
                    stringbutton("    Make new Car    ", 430, 296 + i_2_, 0, true);
                    stringbutton("     Rename Car     ", 270, 296 + i_2_, 0, false);
                    stringbutton("      Delete Car      ", 270, 336 + i_2_, 0, false);
                    stringbutton("     Import & Export     ", 430, 336 + i_2_, 0, false);
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
                    rd.drawString("Make a new Car", 350 - ftm.stringWidth("Make a new Car") / 2, 230 + i_2_);
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.drawString("New car name :", 228, 266 + i_2_);
                    movefield(srch, 335, 250 + i_2_, 129, 22);
                    if (!srch.isShowing()) {
                        srch.show();
                        srch.requestFocus();
                    }
                    fixtext(srch);
                    stringbutton("    Make Car    ", 350, 306 + i_2_, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i_2_, 0, false);
                }
                if (sfase == 2) {
                    rd.drawString(new StringBuilder().append("Rename Car :  ").append(carname).append("").toString(), 350 - ftm.stringWidth(new StringBuilder().append("Rename Car :  ").append(carname).append("").toString()) / 2, 230 + i_2_);
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.drawString("New name :", 239, 266 + i_2_);
                    movefield(srch, 316, 250 + i_2_, 129, 22);
                    if (!srch.isShowing()) {
                        srch.show();
                        srch.requestFocus();
                    }
                    fixtext(srch);
                    stringbutton("   Rename Car   ", 350, 306 + i_2_, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i_2_, 0, false);
                }
                if (sfase == 3) {
                    rd.drawString("Import a Wavefront OBJ 3D Model", 350 - ftm.stringWidth("Import a Wavefront OBJ 3D Model") / 2, 230 + i_2_);
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
                    rd.drawString("Please read the important information about importing cars found at:", 350 - ftm.stringWidth("Please read the important information about importing cars, found here :") / 2, 260 + i_2_);
                    rd.setColor(new Color(0, 128, 255));
                    string = "http://www.needformadness.com/developer/extras.html";
                    rd.drawString(string, 350 - ftm.stringWidth(string) / 2, 280 + i_2_);
                    if (mouseon == 3)
                        rd.setColor(new Color(0, 128, 255));
                    else
                        rd.setColor(new Color(0, 64, 128));
                    rd.drawLine(350 - ftm.stringWidth(string) / 2, 281 + i_2_, 350 + ftm.stringWidth(string) / 2, 281 + i_2_);
                    if (mouseon == 3 && mouses == -1)
                        openelink();
                    stringbutton("     Import Car     ", 350, 326 + i_2_, 0, true);
                    stringbutton("  Export >  ", 550, 326 + i_2_, 0, false);
                    stringbutton("  Cancel  ", 350, 366 + i_2_, 0, false);
                }
                if (sfase == 4) {
                    rd.drawString("Select Car to Export", 350 - ftm.stringWidth("Select Car to Export") / 2, 230 + i_2_);
                    slcar.move(250, 240 + i_2_);
                    if (slcar.getWidth() != 200)
                        slcar.setSize(200, 21);
                    if (!slcar.isShowing())
                        slcar.show();
                    stringbutton("     Export Car     ", 350, 306 + i_2_, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i_2_, 0, false);
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
                        editor.show();
                        editor.requestFocus();
                    }
                } else if (editor.isShowing())
                    editor.hide();
                rd.setFont(new Font("Arial", 1, 12));
                if (prefs) {
                    rd.drawString("Code Font:", 10, 446);
                    fontsel.move(76, 430);
                    if (!fontsel.isShowing()) {
                        fontsel.show();
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
                    rd.drawString("Code Theme:", 190, 446);
                    ctheme.move(271, 430);
                    if (!ctheme.isShowing()) {
                        ctheme.show();
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
                        ctheme.hide();
                    if (fontsel.isShowing())
                        fontsel.hide();
                    if (cntprf != 0)
                        cntprf = 0;
                    if (cntchk == 0) {
                        npolys = 0;
                        int i_6_ = 0;
                        boolean bool_7_ = false;
                        while (i_6_ != -1 && mouses != 1) {
                            if (!bool_7_)
                                i_6_ = editor.getText().indexOf("<p>", i_6_);
                            else
                                i_6_ = editor.getText().indexOf("</p>", i_6_);
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
                        rd.drawString(new StringBuilder().append("Number of Polygons :  ").append(npolys).append(" / 10000").toString(), 200, 446);
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
                } catch (Exception exception) {
                    /* empty */
                }
                if (!string.equals("")) {
                    int i_8_ = string.indexOf("<p>", 0);
                    while (i_8_ != -1 && i_8_ + 1 < string.length()) {
                        if (!mirror) {
                            i_8_ = string.indexOf("</p>", i_8_ + 1);
                            if (i_8_ != -1) {
                                mirror = true;
                                cntpls++;
                            }
                        }
                        if (mirror) {
                            i_8_ = string.indexOf("<p>", i_8_ + 1);
                            if (i_8_ != -1)
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
                        srch.show();
                    boolean bool_9_ = false;
                    if (!srch.getText().equals(""))
                        bool_9_ = true;
                    stringbutton(" Find ", 117, 526, 2, bool_9_);
                    rd.drawString("Replace with:", 255, 500);
                    movefield(rplc, 338, 484, 129, 22);
                    if (!rplc.isShowing())
                        rplc.show();
                    bool_9_ = false;
                    if (!srch.getText().equals("") && !rplc.getText().equals(""))
                        bool_9_ = true;
                    stringbutton(" Replace ", 376, 526, 2, bool_9_);
                } else {
                    if (srch.isShowing())
                        srch.hide();
                    if (rplc.isShowing())
                        rplc.hide();
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
                    JOptionPane.showMessageDialog(null, "Maximum number of polygons (pieces) allowed has been exceeded!\nThe maximum allowed is 10000 polygons, please decrease.\n", "Car Maker", 1);
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
                        (compo[compsel - 1]).x = (o).x;
                        (compo[compsel - 1]).y = (o).y;
                        (compo[compsel - 1]).z = (o).z;
                        (compo[compsel - 1]).xz = (o).xz;
                        (compo[compsel - 1]).xy = (o).xy;
                        (compo[compsel - 1]).zy = (o).zy;
                        rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        compo[compsel - 1].d(rd);
                        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    if (xm > 420 && xm < 690 && ym > 425 && ym < 540) {
                        int[] is = { 50 + adna[0], -50 - adna[1], 0, 0, 0, 0 };
                        int[] is_10_ = { 0, 0, 50 + adna[2], -50 - adna[3], 0, 0 };
                        int[] is_11_ = { 0, 0, 0, 0, 50 + adna[4], -50 - adna[5] };
                        for (int i_12_ = 0; i_12_ < 6; i_12_++) {
                            is[i_12_] += (o).x - (m).x;
                            is_10_[i_12_] += (o).y - (m).y;
                            is_11_[i_12_] += (o).z - (m).z;
                        }
                        rot(is, is_10_, (o).x - (m).x, (o).y - (m).y, (o).xy, 6);
                        rot(is_10_, is_11_, (o).y - (m).y, (o).z - (m).z, (o).zy, 6);
                        rot(is, is_11_, (o).x - (m).x, (o).z - (m).z, (o).xz, 6);
                        rot(is, is_11_, (m).cx, (m).cz, (m).xz, 6);
                        rot(is_10_, is_11_, (m).cy, (m).cz, (m).zy, 6);
                        int[] is_13_ = new int[6];
                        int[] is_14_ = new int[6];
                        for (int i_15_ = 0; i_15_ < 6; i_15_++) {
                            is_13_[i_15_] = xs(is[i_15_], is_11_[i_15_]);
                            is_14_[i_15_] = ys(is_10_[i_15_], is_11_[i_15_]);
                        }
                        rd.setColor(new Color(0, 150, 0));
                        rd.drawString("X+", is_13_[0] - 7, is_14_[0] + 4);
                        rd.drawString("-X", is_13_[1] - 5, is_14_[1] + 4);
                        rd.drawLine(is_13_[0], is_14_[0], is_13_[1], is_14_[1]);
                        rd.setColor(new Color(150, 0, 0));
                        rd.drawString("Y+", is_13_[2] - 7, is_14_[2] + 4);
                        rd.drawString("-Y", is_13_[3] - 5, is_14_[3] + 4);
                        rd.drawLine(is_13_[2], is_14_[2], is_13_[3], is_14_[3]);
                        rd.setColor(new Color(0, 0, 150));
                        rd.drawString("Z+", is_13_[4] - 7, is_14_[4] + 4);
                        rd.drawString("-Z", is_13_[5] - 5, is_14_[5] + 4);
                        rd.drawLine(is_13_[4], is_14_[4], is_13_[5], is_14_[5]);
                        for (int i_16_ = 0; i_16_ < 6; i_16_++) {
                            if ((float) Math.abs(is_14_[i_16_] - 207) * 1.91F > (float) Math.abs(is_13_[i_16_] - 350)) {
                                if (Math.abs(Math.abs(is_14_[i_16_] - 207) - 170) > 10) {
                                    if (Math.abs(is_14_[i_16_] - 207) < 170)
                                        adna[i_16_] += 10;
                                    else
                                        adna[i_16_] -= 10;
                                }
                            } else if (Math.abs(Math.abs(is_13_[i_16_] - 350) - 338) > 10) {
                                if (Math.abs(is_13_[i_16_] - 350) < 338)
                                    adna[i_16_] += 10;
                                else
                                    adna[i_16_] -= 10;
                            }
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
                rd.setFont(new Font("Arial", 1, 12));
                ftm = rd.getFontMetrics();
                String[] strings = { "3D Controls", "Color Edit", "Scale & Align", "Wheels", "Stats & Class", "Physics", "Test Drive" };
                int[] is = { 0, 0, 100, 90 };
                int[] is_17_ = { 390, 410, 410, 390 };
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
                    rd.drawString("Rotate Car around its X & Z Axis using:  [ Keyboard Arrows ] ", 20, 440);
                    rd.drawString("Rotate Car fully around the Y Axis using:    [ < ]  &  [ > ]    or    [ A ]  &  [ D ]    or    [ 4 ]  &  [ 6 ]    Keys", 20, 465);
                    rd.drawString("Move Car Up and Down using:    [ - ]  &  [ + ]    Keys", 20, 490);
                    rd.drawString("Move Car Forwards and Backwards using:    [ W ]  &  [ S ]    or    [ 8 ]  &  [ 2 ]    or    [ Enter ]  &  [ Backspace ]    Keys", 20, 515);
                }
                if (dtab == 1) {
                    if ((o).colok != 2) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString("[  First & Second Color not defined yet  ]", 350 - ftm.stringWidth("[  First & Second Color not defined yet  ]") / 2, 450);
                        stringbutton(" Define 1st and 2nd Color ", 350, 490, 0, true);
                    } else {
                        if (dtabed != dtab) {
                            fcol = new StringBuilder().append("(").append((o).fcol[0]).append(",").append((o).fcol[1]).append(",").append((o).fcol[2]).append(")").toString();
                            srch.setText(fcol);
                            ofcol = fcol;
                            Color.RGBtoHSB((o).fcol[0], (o).fcol[1], (o).fcol[2], fhsb);
                            float f = fhsb[1];
                            fhsb[1] = fhsb[2];
                            fhsb[2] = f;
                            scol = new StringBuilder().append("(").append((o).scol[0]).append(",").append((o).scol[1]).append(",").append((o).scol[2]).append(")").toString();
                            rplc.setText(scol);
                            oscol = scol;
                            Color.RGBtoHSB((o).scol[0], (o).scol[1], (o).scol[2], shsb);
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
                            srch.show();
                        for (int i_20_ = 0; i_20_ < 200; i_20_++) {
                            rd.setColor(Color.getHSBColor((float) ((double) (float) i_20_ * 0.005), 1.0F, 1.0F));
                            rd.drawLine(110 + i_20_, 442, 110 + i_20_, 449);
                        }
                        for (int i_21_ = 0; i_21_ < 200; i_21_++) {
                            rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float) ((double) (float) i_21_ * 0.004)));
                            rd.drawLine(110 + i_21_, 462, 110 + i_21_, 469);
                        }
                        for (int i_22_ = 0; i_22_ < 200; i_22_++) {
                            rd.setColor(Color.getHSBColor(fhsb[0], (float) ((double) (float) i_22_ * 0.005), fhsb[1]));
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
                            if (xm > 107 && xm < 313 && ym > 439 + i_23_ * 20 && ym < 452 + i_23_ * 20 && mouses == 1 && mouseon == -1)
                                mouseon = i_23_;
                            if (mouseon == i_23_) {
                                if (i_23_ == 1) {
                                    fhsb[i_23_] = 0.2F + (float) (xm - 110) / 250.0F;
                                    if ((double) fhsb[i_23_] < 0.2)
                                        fhsb[i_23_] = 0.2F;
                                } else
                                    fhsb[i_23_] = (float) (xm - 110) / 200.0F;
                                if (fhsb[i_23_] > 1.0F)
                                    fhsb[i_23_] = 1.0F;
                                if (fhsb[i_23_] < 0.0F)
                                    fhsb[i_23_] = 0.0F;
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
                            rplc.show();
                        for (int i_24_ = 0; i_24_ < 200; i_24_++) {
                            rd.setColor(Color.getHSBColor((float) ((double) (float) i_24_ * 0.005), 1.0F, 1.0F));
                            rd.drawLine(450 + i_24_, 442, 450 + i_24_, 449);
                        }
                        for (int i_25_ = 0; i_25_ < 200; i_25_++) {
                            rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float) ((double) (float) i_25_ * 0.004)));
                            rd.drawLine(450 + i_25_, 462, 450 + i_25_, 469);
                        }
                        for (int i_26_ = 0; i_26_ < 200; i_26_++) {
                            rd.setColor(Color.getHSBColor(shsb[0], (float) ((double) (float) i_26_ * 0.005), shsb[2]));
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
                            if (xm > 447 && xm < 653 && ym > 439 + i_27_ * 20 && ym < 452 + i_27_ * 20 && mouses == 1 && mouseon == -1)
                                mouseon = i_27_ + 3;
                            if (mouseon == i_27_ + 3) {
                                if (i_27_ == 1) {
                                    shsb[i_27_] = 0.2F + (float) (xm - 450) / 250.0F;
                                    if ((double) shsb[i_27_] < 0.2)
                                        shsb[i_27_] = 0.2F;
                                } else
                                    shsb[i_27_] = (float) (xm - 450) / 200.0F;
                                if (shsb[i_27_] > 1.0F)
                                    shsb[i_27_] = 1.0F;
                                if (shsb[i_27_] < 0.0F)
                                    shsb[i_27_] = 0.0F;
                            }
                        }
                        stringbutton(" Save ", 640, 520, 0, !scol.equals(oscol));
                        if ((double) fhsb[1] < 0.2)
                            fhsb[1] = 0.2F;
                        if ((double) shsb[1] < 0.2)
                            shsb[1] = 0.2F;
                        for (int i_28_ = 0; i_28_ < (o).npl; i_28_++) {
                            if (((o).p[i_28_]).colnum == 1) {
                                ((o).p[i_28_]).hsb[0] = fhsb[0];
                                ((o).p[i_28_]).hsb[1] = fhsb[2];
                                ((o).p[i_28_]).hsb[2] = fhsb[1];
                            }
                            if (((o).p[i_28_]).colnum == 2) {
                                ((o).p[i_28_]).hsb[0] = shsb[0];
                                ((o).p[i_28_]).hsb[1] = shsb[2];
                                ((o).p[i_28_]).hsb[2] = shsb[1];
                            }
                        }
                        String string = new StringBuilder().append("(").append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getRed()).append(",").append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getGreen()).append(",").append(Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getBlue()).append(")").toString();
                        if (!fcol.equals(string)) {
                            fcol = string;
                            srch.setText(fcol);
                        }
                        string = new StringBuilder().append("(").append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getRed()).append(",").append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getGreen()).append(",").append(Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getBlue()).append(")").toString();
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
                                int[] is_29_ = new int[3];
                                boolean bool_30_ = true;
                                try {
                                    int i_31_ = fcol.indexOf(",", 0);
                                    int i_32_ = fcol.indexOf(",", i_31_ + 1);
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
                                    is_29_[2] = Integer.valueOf(fcol.substring(i_32_ + 1, fcol.length() - 1)).intValue();
                                    if (is_29_[2] < 0)
                                        is_29_[2] = 0;
                                    if (is_29_[2] > 255)
                                        is_29_[2] = 255;
                                } catch (Exception exception) {
                                    bool_30_ = false;
                                }
                                if (bool_30_) {
                                    Color.RGBtoHSB(is_29_[0], is_29_[1], is_29_[2], fhsb);
                                    float f = fhsb[1];
                                    fhsb[1] = fhsb[2];
                                    fhsb[2] = f;
                                }
                            }
                            if (!rplc.getText().equals(scol)) {
                                scol = rplc.getText();
                                int[] is_33_ = new int[3];
                                boolean bool_34_ = true;
                                try {
                                    int i_35_ = scol.indexOf(",", 0);
                                    int i_36_ = scol.indexOf(",", i_35_ + 1);
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
                                    is_33_[2] = Integer.valueOf(scol.substring(i_36_ + 1, scol.length() - 1)).intValue();
                                    if (is_33_[2] < 0)
                                        is_33_[2] = 0;
                                    if (is_33_[2] > 255)
                                        is_33_[2] = 255;
                                } catch (Exception exception) {
                                    bool_34_ = false;
                                }
                                if (bool_34_) {
                                    Color.RGBtoHSB(is_33_[0], is_33_[1], is_33_[2], shsb);
                                    float f = shsb[1];
                                    shsb[1] = shsb[2];
                                    shsb[2] = f;
                                }
                            }
                        }
                    }
                }
                if (dtab == 2) {
                    if (dtabed != dtab) {
                        lastedo = editor.getText();
                        scale[0] = 100;
                        int i_37_ = editor.getText().indexOf("\nScaleX(", 0);
                        if (i_37_ != -1) {
                            i_37_++;
                            try {
                                scale[0] = Integer.valueOf(editor.getText().substring(i_37_ + 7, editor.getText().indexOf(")", i_37_))).intValue();
                            } catch (Exception exception) {
                                scale[0] = 100;
                            }
                        }
                        oscale[0] = scale[0];
                        scale[1] = 100;
                        i_37_ = editor.getText().indexOf("\nScaleY(", 0);
                        if (i_37_ != -1) {
                            i_37_++;
                            try {
                                scale[1] = Integer.valueOf(editor.getText().substring(i_37_ + 7, editor.getText().indexOf(")", i_37_))).intValue();
                            } catch (Exception exception) {
                                scale[1] = 100;
                            }
                        }
                        oscale[1] = scale[1];
                        scale[2] = 100;
                        i_37_ = editor.getText().indexOf("\nScaleZ(", 0);
                        if (i_37_ != -1) {
                            i_37_++;
                            try {
                                scale[2] = Integer.valueOf(editor.getText().substring(i_37_ + 7, editor.getText().indexOf(")", i_37_))).intValue();
                            } catch (Exception exception) {
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
                    rd.drawString(new StringBuilder().append("").append((float) scale[0] / 100.0F).append("").toString(), 126 - ftm.stringWidth(new StringBuilder().append("").append((float) scale[0] / 100.0F).append("").toString()) / 2, 450);
                    stringbutton(" + ", 160, 450, 4, false);
                    rd.drawString("Scale Y", 25, 474);
                    stringbutton(" - ", 92, 474, 4, false);
                    rd.drawString(new StringBuilder().append("").append((float) scale[1] / 100.0F).append("").toString(), 126 - ftm.stringWidth(new StringBuilder().append("").append((float) scale[1] / 100.0F).append("").toString()) / 2, 474);
                    stringbutton(" + ", 160, 474, 4, false);
                    rd.drawString("Scale Z", 25, 498);
                    stringbutton(" - ", 92, 498, 4, false);
                    rd.drawString(new StringBuilder().append("").append((float) scale[2] / 100.0F).append("").toString(), 126 - ftm.stringWidth(new StringBuilder().append("").append((float) scale[2] / 100.0F).append("").toString()) / 2, 498);
                    stringbutton(" + ", 160, 498, 4, false);
                    rd.drawString("Scale ALL", 25, 527);
                    stringbutton(" - ", 106, 527, 2, true);
                    stringbutton(" + ", 146, 527, 2, true);
                    stringbutton("   Save   ", 230, 454, 0, oscale[0] != scale[0] || oscale[1] != scale[1] || oscale[2] != scale[2]);
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
                        compcar.show();
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
                        String string = "(140,140,140)";
                        String string_54_ = "(140,140,140)";
                        int i_55_ = 0;
                        String string_56_ = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        int i_57_ = 0;
                        int i_58_ = string_56_.indexOf("\n", 0);
                        int i_59_ = 0;
                        int i_60_ = 15;
                        int i_61_ = 20;
                        String string_62_ = "(140,140,140)";
                        while (i_58_ != -1 && i_57_ < string_56_.length()) {
                            String string_63_ = string_56_.substring(i_57_, i_58_);
                            string_63_ = string_63_.trim();
                            i_57_ = i_58_ + 1;
                            i_58_ = string_56_.indexOf("\n", i_57_);
                            try {
                                if (string_63_.startsWith("rims(")) {
                                    string_62_ = new StringBuilder().append("(").append(getvalue("rims", string_63_, 0)).append(",").append(getvalue("rims", string_63_, 1)).append(",").append(getvalue("rims", string_63_, 2)).append(")").toString();
                                    i_60_ = getvalue("rims", string_63_, 3);
                                    i_61_ = getvalue("rims", string_63_, 4);
                                }
                                if (string_63_.startsWith("gwgr("))
                                    i_59_ = getvalue("gwgr", string_63_, 0);
                                if (string_63_.startsWith("w(")) {
                                    int i_64_ = getvalue("w", string_63_, 2);
                                    if (i_64_ > 0) {
                                        i_38_ = Math.abs(getvalue("w", string_63_, 0));
                                        i_40_ = getvalue("w", string_63_, 1);
                                        i_42_ = i_64_;
                                        i_44_ = Math.abs(getvalue("w", string_63_, 4));
                                        i_46_ = Math.abs(getvalue("w", string_63_, 5));
                                        string = string_62_;
                                        i_48_ = i_60_;
                                        i_50_ = i_61_;
                                        i_52_ = i_59_;
                                    } else {
                                        i_39_ = Math.abs(getvalue("w", string_63_, 0));
                                        i_41_ = getvalue("w", string_63_, 1);
                                        i_43_ = i_64_;
                                        i_45_ = Math.abs(getvalue("w", string_63_, 4));
                                        i_47_ = Math.abs(getvalue("w", string_63_, 5));
                                        string_54_ = string_62_;
                                        i_49_ = i_60_;
                                        i_51_ = i_61_;
                                        i_53_ = i_59_;
                                    }
                                    i_55_++;
                                }
                            } catch (Exception exception) {
                                /* empty */
                            }
                        }
                        if (i_55_ != 4)
                            defnow = true;
                        else
                            defnow = false;
                        wv[0].setText(new StringBuilder().append("").append(i_39_).append("").toString());
                        wv[1].setText(new StringBuilder().append("").append(i_41_).append("").toString());
                        wv[2].setText(new StringBuilder().append("").append(i_43_).append("").toString());
                        wv[3].setText(new StringBuilder().append("").append(i_47_).append("").toString());
                        wv[4].setText(new StringBuilder().append("").append(i_45_).append("").toString());
                        srch.setText(string_54_);
                        wv[5].setText(new StringBuilder().append("").append(i_49_).append("").toString());
                        wv[6].setText(new StringBuilder().append("").append(i_51_).append("").toString());
                        wv[7].setText(new StringBuilder().append("").append(i_53_).append("").toString());
                        wv[8].setText(new StringBuilder().append("").append(i_38_).append("").toString());
                        wv[9].setText(new StringBuilder().append("").append(i_40_).append("").toString());
                        wv[10].setText(new StringBuilder().append("").append(i_42_).append("").toString());
                        wv[11].setText(new StringBuilder().append("").append(i_46_).append("").toString());
                        wv[12].setText(new StringBuilder().append("").append(i_44_).append("").toString());
                        rplc.setText(string);
                        wv[13].setText(new StringBuilder().append("").append(i_48_).append("").toString());
                        wv[14].setText(new StringBuilder().append("").append(i_50_).append("").toString());
                        wv[15].setText(new StringBuilder().append("").append(i_52_).append("").toString());
                        aply1 = new StringBuilder().append("").append(wv[0].getText()).append("").append(wv[1].getText()).append("").append(wv[2].getText()).append("").append(wv[3].getText()).append("").append(wv[4].getText()).append("").append(srch.getText()).append("").append(wv[5].getText()).append("").append(wv[6].getText()).append("").append(wv[7].getText()).append("").toString();
                        aply2 = new StringBuilder().append("").append(wv[8].getText()).append("").append(wv[9].getText()).append("").append(wv[10].getText()).append("").append(wv[11].getText()).append("").append(wv[12].getText()).append("").append(rplc.getText()).append("").append(wv[13].getText()).append("").append(wv[14].getText()).append("").append(wv[15].getText()).append("").toString();
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
                        JOptionPane.showMessageDialog(null, "Use this variable to hide the car wheels inside the car if you need to (if they are getting drawn over the car when they\nshould be drawn behind it).\n\nIf you have created a car model with specific places for the wheels go inside them (inside the car), if when you place the\nwheels there they don\u2019t get drawn inside the car (they get drawn over it instead), use this variable to adjust that.\n\nYou can also use this variable to do the opposite, to make the wheels get drawn over the car if they are getting drawn\nbehind it when they shouldn\u2019t.\n\nThe Hide variable takes values from -40 to 40:\nA +ve value from 1 to 40 makes the wheels more hidden, where 40 is the maximum the car wheel can be hidden.\nA -ve value from -1 to -40 does exactly the opposite and makes the wheels more apparent (this if the car wheels appear\ninside the car when they should be outside).\nA 0 value means do nothing.\nMost of the time you will need to use this variable, it will be to enter +ve values from 1-40 for hiding the car wheels.\n\n", "Car Maker", 1);
                    for (int i_65_ = 0; i_65_ < 16; i_65_++) {
                        if (wv[i_65_].hasFocus())
                            focuson = false;
                        if (!wv[i_65_].isShowing())
                            wv[i_65_].show();
                    }
                    if (srch.hasFocus())
                        focuson = false;
                    if (!srch.isShowing())
                        srch.show();
                    if (rplc.hasFocus())
                        focuson = false;
                    if (!rplc.isShowing())
                        rplc.show();
                    if (!focuson) {
                        if (!aplyd1 && !aply1.equals(new StringBuilder().append("").append(wv[0].getText()).append("").append(wv[1].getText()).append("").append(wv[2].getText()).append("").append(wv[3].getText()).append("").append(wv[4].getText()).append("").append(srch.getText()).append("").append(wv[5].getText()).append("").append(wv[6].getText()).append("").append(wv[7].getText()).append("").toString()))
                            aplyd1 = true;
                        if (!aplyd2 && !aply2.equals(new StringBuilder().append("").append(wv[8].getText()).append("").append(wv[9].getText()).append("").append(wv[10].getText()).append("").append(wv[11].getText()).append("").append(wv[12].getText()).append("").append(rplc.getText()).append("").append(wv[13].getText()).append("").append(wv[14].getText()).append("").append(wv[15].getText()).append("").toString()))
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
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        int i_66_ = 0;
                        int i_67_ = string.indexOf("\n", 0);
                        while (i_67_ != -1 && i_66_ < string.length()) {
                            String string_68_ = string.substring(i_66_, i_67_);
                            string_68_ = string_68_.trim();
                            i_66_ = i_67_ + 1;
                            i_67_ = string.indexOf("\n", i_66_);
                            try {
                                if (string_68_.startsWith("stat(")) {
                                    int i_69_ = 0;
                                    for (int i_70_ = 0; i_70_ < 5; i_70_++) {
                                        stat[i_70_] = getvalue("stat", string_68_, i_70_);
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
                                    while (i_71_ != 0) {
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
                                    }
                                    for (int i_73_ = 0; i_73_ < 5; i_73_++)
                                        rstat[i_73_] = stat[i_73_];
                                    statdef = true;
                                }
                            } catch (Exception exception) {
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
                        rd.drawString("To start, please select the most similar NFM car to this car", 350 - ftm.stringWidth("To start, please select the most similar NFM car to this car") / 2, 450);
                        simcar.move(288, 460);
                        if (!simcar.isShowing())
                            simcar.show();
                        stringbutton("   OK   ", 350, 515, 0, true);
                    } else {
                        rd.drawString("Car Class", 54, 435);
                        cls.move(34, 440);
                        if (!cls.isShowing())
                            cls.show();
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
                            while (i_77_ != 0) {
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
                        }
                        if (4 - (i_75_ - 520) / 40 != cls.getSelectedIndex()) {
                            clsel = 4 - (i_75_ - 520) / 40;
                            cls.select(clsel);
                        }
                        rd.drawString("Most Similar Car", 36, 490);
                        simcar.move(20, 495);
                        if (!simcar.isShowing())
                            simcar.show();
                        if (carsel != simcar.getSelectedIndex()) {
                            carsel = simcar.getSelectedIndex();
                            if (carsel != 16) {
                                for (int i_79_ = 0; i_79_ < 5; i_79_++)
                                    stat[i_79_] = carstat[carsel][i_79_];
                            }
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
                        rd.drawString("Speed :", 196, 435);
                        rd.drawString("Acceleration :", 160, 459);
                        rd.drawString("Stunts :", 195, 483);
                        rd.drawString("Strength :", 183, 507);
                        rd.drawString("Endurance :", 171, 531);
                        for (int i_85_ = 0; i_85_ < 5; i_85_++) {
                            for (int i_86_ = 0; i_86_ < stat[i_85_]; i_86_++) {
                                rd.setColor(Color.getHSBColor((float) ((double) (float) i_86_ * 7.0E-4), 1.0F, 1.0F));
                                rd.drawLine(250 + i_86_, 426 + i_85_ * 24, 250 + i_86_, 434 + i_85_ * 24);
                            }
                            rd.setColor(new Color(0, 0, 0));
                            rd.drawLine(249, 426 + i_85_ * 24, 249, 434 + i_85_ * 24);
                            rd.drawLine(450, 426 + i_85_ * 24, 450, 434 + i_85_ * 24);
                            rd.drawLine(249, 435 + i_85_ * 24, 450, 435 + i_85_ * 24);
                            for (int i_87_ = 0; i_87_ < 7; i_87_++)
                                rd.drawLine(275 + i_87_ * 25, 434 + i_85_ * 24, 275 + i_87_ * 25, 430 + i_85_ * 24);
                            stringbutton(" - ", 480, 435 + i_85_ * 24, 4, false);
                            stringbutton(" + ", 520, 435 + i_85_ * 24, 4, false);
                        }
                        if (carsel < 16 && i_80_ != 0)
                            stringbutton(" Reselect ", 80, 534, 4, true);
                        else
                            stringbutton(" Reselect ", 80, -1000, 4, true);
                        stringbutton("      Save      ", 620, 459, 0, bool_74_ || changed2);
                        stringbutton("   Reset   ", 620, 507, 0, false);
                    }
                }
                if (dtab == 5) {
                    if (dtabed != dtab) {
                        mouseon = -1;
                        pfase = 0;
                        if ((o).keyz[0] <= 0 || (o).keyx[0] >= 0)
                            pfase = -1;
                        if ((o).keyz[1] <= 0 || (o).keyx[1] <= 0)
                            pfase = -1;
                        if ((o).keyz[2] >= 0 || (o).keyx[2] >= 0)
                            pfase = -1;
                        if ((o).keyz[3] >= 0 || (o).keyx[3] <= 0)
                            pfase = -1;
                        crashok = false;
                        if (Math.random() > Math.random())
                            crashleft = false;
                        else
                            crashleft = true;
                        engsel = 0;
                        if (pfase == 0) {
                            String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                            int i_88_ = 0;
                            int i_89_ = string.indexOf("\n", 0);
                            while (i_89_ != -1 && i_88_ < string.length()) {
                                String string_90_ = string.substring(i_88_, i_89_);
                                string_90_ = string_90_.trim();
                                i_88_ = i_89_ + 1;
                                i_89_ = string.indexOf("\n", i_88_);
                                try {
                                    if (string_90_.startsWith("physics(")) {
                                        for (int i_91_ = 0; i_91_ < 11; i_91_++) {
                                            phys[i_91_] = getvalue("physics", string_90_, i_91_);
                                            if (phys[i_91_] > 100)
                                                phys[i_91_] = 100;
                                            if (phys[i_91_] < 0)
                                                phys[i_91_] = 0;
                                        }
                                        for (int i_92_ = 0; i_92_ < 11; i_92_++)
                                            rphys[i_92_] = phys[i_92_];
                                        for (int i_93_ = 0; i_93_ < 3; i_93_++) {
                                            crash[i_93_] = getvalue("physics", string_90_, i_93_ + 11);
                                            if (crash[i_93_] > 100)
                                                crash[i_93_] = 100;
                                            if (crash[i_93_] < 0)
                                                crash[i_93_] = 0;
                                        }
                                        for (int i_94_ = 0; i_94_ < 3; i_94_++)
                                            rcrash[i_94_] = crash[i_94_];
                                        engsel = getvalue("physics", string_90_, 14);
                                        if (engsel > 4)
                                            engsel = 0;
                                        if (engsel < 0)
                                            engsel = 0;
                                        crashok = true;
                                    }
                                } catch (Exception exception) {
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
                            rd.drawString(new StringBuilder().append("").append(pname[i_96_]).append(" :").toString(), pnx[i_96_], 447 + i_96_ * 24);
                            rd.drawLine(140, 443 + i_96_ * 24, 230, 443 + i_96_ * 24);
                            for (int i_97_ = 1; i_97_ < 10; i_97_++)
                                rd.drawLine(140 + 10 * i_97_, 443 - i_97_ + i_96_ * 24, 140 + 10 * i_97_, 443 + i_97_ + i_96_ * 24);
                            rd.setColor(new Color(255, 0, 0));
                            int i_98_ = (int) ((float) phys[i_96_] / 1.1111F / 10.0F);
                            rd.fillRect(138 + (int) ((float) phys[i_96_] / 1.1111F), 443 - i_98_ + i_96_ * 24, 5, i_98_ * 2 + 1);
                            rd.setColor(new Color(255, 128, 0));
                            rd.drawRect(139 + (int) ((float) phys[i_96_] / 1.1111F), 434 + i_96_ * 24, 2, 18);
                            stringbutton(" - ", 260, 447 + i_96_ * 24, 4, false);
                            stringbutton(" + ", 300, 447 + i_96_ * 24, 4, false);
                        }
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("<  Click on any variable name to learn about its function & use!", 333, 447);
                        stringbutton(" Random ", 380, 496, 0, false);
                        stringbutton(" Reset ", 455, 496, 0, false);
                        stringbutton("       Next  >       ", 570, 496, 0, true);
                    }
                    if (pfase == 1) {
                        for (int i_99_ = 0; i_99_ < 4; i_99_++) {
                            rd.setColor(new Color(0, 0, 0));
                            if (xm > pnx[i_99_ + 5] && xm < 211 && ym > 433 + i_99_ * 24 && ym < 453 + i_99_ * 24) {
                                i_95_ = i_99_ + 5;
                                rd.setColor(new Color(176, 64, 0));
                                rd.drawLine(pnx[i_99_ + 5], 448 + i_99_ * 24, 109, 448 + i_99_ * 24);
                            }
                            rd.drawString(new StringBuilder().append("").append(pname[i_99_ + 5]).append(" :").toString(), pnx[i_99_ + 5], 447 + i_99_ * 24);
                            rd.drawLine(121, 443 + i_99_ * 24, 211, 443 + i_99_ * 24);
                            for (int i_100_ = 1; i_100_ < 10; i_100_++)
                                rd.drawLine(121 + 10 * i_100_, 443 - i_100_ + i_99_ * 24, 121 + 10 * i_100_, 443 + i_100_ + i_99_ * 24);
                            rd.setColor(new Color(255, 0, 0));
                            int i_101_ = (int) ((float) phys[i_99_ + 5] / 1.1111F / 10.0F);
                            rd.fillRect(119 + (int) ((float) phys[i_99_ + 5] / 1.1111F), 443 - i_101_ + i_99_ * 24, 5, i_101_ * 2 + 1);
                            rd.setColor(new Color(255, 128, 0));
                            rd.drawRect(120 + (int) ((float) phys[i_99_ + 5] / 1.1111F), 434 + i_99_ * 24, 2, 18);
                            stringbutton(" - ", 241, 447 + i_99_ * 24, 4, false);
                            stringbutton(" + ", 281, 447 + i_99_ * 24, 4, false);
                        }
                        for (int i_102_ = 0; i_102_ < 2; i_102_++) {
                            rd.setColor(new Color(0, 0, 0));
                            if (xm > pnx[i_102_ + 9] && xm < 548 && ym > 433 + i_102_ * 24 && ym < 453 + i_102_ * 24) {
                                i_95_ = i_102_ + 9;
                                rd.setColor(new Color(176, 64, 0));
                                rd.drawLine(pnx[i_102_ + 9], 448 + i_102_ * 24, 446, 448 + i_102_ * 24);
                            }
                            rd.drawString(new StringBuilder().append("").append(pname[i_102_ + 9]).append(" :").toString(), pnx[i_102_ + 9], 447 + i_102_ * 24);
                            rd.drawLine(458, 443 + i_102_ * 24, 548, 443 + i_102_ * 24);
                            for (int i_103_ = 1; i_103_ < 10; i_103_++)
                                rd.drawLine(458 + 10 * i_103_, 443 - i_103_ + i_102_ * 24, 458 + 10 * i_103_, 443 + i_103_ + i_102_ * 24);
                            rd.setColor(new Color(255, 0, 0));
                            int i_104_ = (int) ((float) phys[i_102_ + 9] / 1.1111F / 10.0F);
                            rd.fillRect(456 + (int) ((float) phys[i_102_ + 9] / 1.1111F), 443 - i_104_ + i_102_ * 24, 5, i_104_ * 2 + 1);
                            rd.setColor(new Color(255, 128, 0));
                            rd.drawRect(457 + (int) ((float) phys[i_102_ + 9] / 1.1111F), 434 + i_102_ * 24, 2, 18);
                            stringbutton(" - ", 578, 447 + i_102_ * 24, 4, false);
                            stringbutton(" + ", 618, 447 + i_102_ * 24, 4, false);
                        }
                        stringbutton(" Random ", 361, 519, 0, false);
                        stringbutton(" Reset ", 436, 519, 0, false);
                        stringbutton(" <  Back ", 509, 519, 0, false);
                        stringbutton("       Next  >       ", 603, 519, 0, true);
                    }
                    if (pfase == 2) {
                        if (xm > 40 && xm < 670 && ym > 416 && ym < 436) {
                            i_95_ = 11;
                            rd.setColor(new Color(176, 64, 0));
                            rd.drawLine(596, 431, 669, 431);
                        }
                        rd.drawString("[   Crash Test,  Damage :                                       ]                                                     What is this?", 180, 430);
                        if (hitmag < 0)
                            hitmag = 0;
                        if (hitmag > 17000) {
                            crashok = true;
                            hitmag = 17000;
                            for (int i_105_ = 0; i_105_ < (o).npl; i_105_++) {
                                if ((((o).p[i_105_]).wz == 0 || ((o).p[i_105_]).gr == -17 || ((o).p[i_105_]).gr == -16) && ((o).p[i_105_]).embos == 0)
                                    ((o).p[i_105_]).embos = 1;
                            }
                        }
                        rd.setColor(new Color(255, (int) (250.0F - (float) hitmag / 68.0F), 0));
                        rd.fillRect(322, 423, (int) ((float) hitmag / 170.0F), 7);
                        rd.setColor(new Color(255, 0, 0));
                        rd.drawRect(322, 423, 100, 7);
                        if (i_95_ != 11)
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
                            i_95_ = 12;
                            rd.setColor(new Color(176, 64, 0));
                            rd.drawLine(50, 461, 94, 461);
                        }
                        rd.drawString("Radius :", 50, 460);
                        rd.drawLine(105, 456, 195, 456);
                        for (int i_106_ = 1; i_106_ < 10; i_106_++)
                            rd.drawLine(105 + 10 * i_106_, 456 - i_106_, 105 + 10 * i_106_, 456 + i_106_);
                        rd.setColor(new Color(255, 0, 0));
                        int i_107_ = (int) ((float) crash[0] / 1.1111F / 10.0F);
                        rd.fillRect(103 + (int) ((float) crash[0] / 1.1111F), 456 - i_107_, 5, i_107_ * 2 + 1);
                        rd.setColor(new Color(255, 128, 0));
                        rd.drawRect(104 + (int) ((float) crash[0] / 1.1111F), 447, 2, 18);
                        stringbutton(" - ", 225, 460, 4, false);
                        stringbutton(" + ", 265, 460, 4, false);
                        rd.setColor(new Color(0, 0, 0));
                        if (xm > 30 && xm < 195 && ym > 470 && ym < 490) {
                            i_95_ = 13;
                            rd.setColor(new Color(176, 64, 0));
                            rd.drawLine(30, 485, 94, 485);
                        }
                        rd.drawString("Magnitude :", 30, 484);
                        rd.drawLine(105, 480, 195, 480);
                        for (int i_108_ = 1; i_108_ < 10; i_108_++)
                            rd.drawLine(105 + 10 * i_108_, 480 - i_108_, 105 + 10 * i_108_, 480 + i_108_);
                        rd.setColor(new Color(255, 0, 0));
                        i_107_ = (int) ((float) crash[1] / 1.1111F / 10.0F);
                        rd.fillRect(103 + (int) ((float) crash[1] / 1.1111F), 480 - i_107_, 5, i_107_ * 2 + 1);
                        rd.setColor(new Color(255, 128, 0));
                        rd.drawRect(104 + (int) ((float) crash[1] / 1.1111F), 471, 2, 18);
                        stringbutton(" - ", 225, 484, 4, false);
                        stringbutton(" + ", 265, 484, 4, false);
                        rd.setColor(new Color(0, 0, 0));
                        if (xm > 350 && xm < 551 && ym > 446 && ym < 466) {
                            i_95_ = 14;
                            rd.setColor(new Color(176, 64, 0));
                            rd.drawLine(350, 461, 450, 461);
                        }
                        rd.drawString("Roof Destruction :", 350, 460);
                        rd.drawLine(461, 456, 551, 456);
                        for (int i_109_ = 1; i_109_ < 10; i_109_++)
                            rd.drawLine(461 + 10 * i_109_, 456 - i_109_, 461 + 10 * i_109_, 456 + i_109_);
                        rd.setColor(new Color(255, 0, 0));
                        i_107_ = (int) ((float) crash[2] / 1.1111F / 10.0F);
                        rd.fillRect(459 + (int) ((float) crash[2] / 1.1111F), 456 - i_107_, 5, i_107_ * 2 + 1);
                        rd.setColor(new Color(255, 128, 0));
                        rd.drawRect(460 + (int) ((float) crash[2] / 1.1111F), 447, 2, 18);
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
                            engine.show();
                            engine.select(engsel);
                        }
                        if (engsel != engine.getSelectedIndex()) {
                            engsel = engine.getSelectedIndex();
                            for (int i_110_ = 0; i_110_ < 5; i_110_++) {
                                for (int i_111_ = 0; i_111_ < 5; i_111_++) {
                                    engs[i_111_][i_110_].stop();
                                    engs[i_111_][i_110_].checkopen();
                                }
                            }
                            engon = false;
                        }
                        if (engsel == 0)
                            rd.drawString("Normal Engine:  Like Tornado Shark, Sword of Justice or Radical One's engine.", 30, 470);
                        if (engsel == 1)
                            rd.drawString("V8 Engine:  High speed engine like Formula 7, Drifter X or Might Eight's engine.", 30, 470);
                        if (engsel == 2)
                            rd.drawString("Retro Engine:  Like Wow Caninaro, Lead Oxide or Kool Kat\u2019s engine.", 30, 470);
                        if (engsel == 3)
                            rd.drawString("Power Engine:  Turbo/super charged engine like Max Revenge, High Rider or Dr Monstaa\u2019s engine.", 30, 470);
                        if (engsel == 4)
                            rd.drawString("Diesel Engine:  Big diesel powered engine for big cars like EL King or  M A S H E E N .", 30, 470);
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
                                /* empty */
                            }
                            Thread.sleep(100L);
                        } catch (InterruptedException interruptedexception) {
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
                                (o).xy = 0;
                                hitmag = 0;
                                int i_116_ = 0;
                                actmag = 0;
                                int i_117_ = i_113_;
                                boolean bool_118_ = false;
                                while (hitmag < 17000) {
                                    if (bool_118_)
                                        regx(i_117_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    else
                                        regz(i_117_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    if (++i_117_ == i_114_) {
                                        (o).xz += 45;
                                        (o).zy += 45;
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
                                (o).xy = 0;
                                actmag = 0;
                                hitmag = 0;
                                int i_120_ = i_113_;
                                boolean bool_121_ = false;
                                while (hitmag < 17000) {
                                    if (bool_121_)
                                        regx(i_120_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    else
                                        regz(i_120_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    if (++i_120_ == i_114_) {
                                        (o).xz += 45;
                                        (o).zy += 45;
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
                            actmag = (int) ((float) hitmag * f);
                            //if (stat[4] > 200)
                            //    stat[4] = 200;
                            if (stat[4] < 16)
                                stat[4] = 16;
                            float f_122_ = 0.9F + (float) (stat[4] - 90) * 0.01F;
                            if ((double) f_122_ < 0.6)
                                f_122_ = 0.6F;
                            if (stat[4] == 200 && stat[0] <= 88)
                                f_122_ = 3.0F;
                            int i_123_ = (int) ((float) actmag * f_122_);
                            for (int i_124_ = 0; i_124_ < 12; i_124_++) {
                                setupo();
                                (o).xy = 0;
                                (o).xz = 90 * i_124_;
                                if ((o).xz >= 360)
                                    (o).xz -= 360;
                                hitmag = 0;
                                int i_125_ = 0;
                                actmag = 0;
                                int i_126_ = i_113_;
                                boolean bool_127_ = false;
                                while (actmag < i_123_) {
                                    if (bool_127_)
                                        regx(i_126_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    else
                                        regz(i_126_, (float) (int) (150.0 + 600.0 * Math.random()), true);
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
                                    (o).xy = 0;
                                    actmag = 0;
                                    hitmag = 0;
                                    int i_129_ = i_113_;
                                    boolean bool_130_ = false;
                                    while (hitmag < 17000) {
                                        if (bool_130_)
                                            regx(i_129_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                        else
                                            regz(i_129_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                        if (++i_129_ == i_114_) {
                                            (o).xz += 45;
                                            (o).zy += 45;
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
                                actmag = (int) ((float) hitmag * f);
                            }
                        }
                        setupo();
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        String string_131_ = "";
                        int i_132_ = 0;
                        int i_133_ = string.indexOf("\n", 0);
                        while (i_133_ != -1 && i_132_ < string.length()) {
                            String string_134_ = string.substring(i_132_, i_133_);
                            string_134_ = string_134_.trim();
                            i_132_ = i_133_ + 1;
                            i_133_ = string.indexOf("\n", i_132_);
                            if (!string_134_.startsWith("physics("))
                                string_131_ = new StringBuilder().append(string_131_).append("").append(string_134_).append("\n").toString();
                            else {
                                string_131_ = string_131_.trim();
                                string_131_ = new StringBuilder().append(string_131_).append("\n").toString();
                            }
                        }
                        string_131_ = string_131_.trim();
                        string_131_ = new StringBuilder().append(string_131_).append("\n\n\nphysics(").append(phys[0]).append(",").append(phys[1]).append(",").append(phys[2]).append(",").append(phys[3]).append(",").append(phys[4]).append(",").append(phys[5]).append(",").append(phys[6]).append(",").append(phys[7]).append(",").append(phys[8]).append(",").append(phys[9]).append(",").append(phys[10]).append(",").append(crash[0]).append(",").append(crash[1]).append(",").append(crash[2]).append(",").append(engsel).append(",").append(actmag).append(")\n\n\n\n").toString();
                        editor.setText(string_131_);
                        savefile();
                        for (int i_135_ = 0; i_135_ < 11; i_135_++)
                            rphys[i_135_] = phys[i_135_];
                        for (int i_136_ = 0; i_136_ < 3; i_136_++)
                            rcrash[i_136_] = crash[i_136_];
                        pfase = 5;
                    }
                    if (pfase == 5) {
                        rd.drawString("Car physics has been successfully set up!", 231, 450);
                        rd.drawString("Test drive your car to see the results...", 242, 490);
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
                        JOptionPane.showMessageDialog(null, usage[i_95_], "Car Maker", 1);
                }
                if (dtab == 6) {
                    if (dtab != dtabed) {
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        int i_137_ = 0;
                        int i_138_ = string.indexOf("\n", 0);
                        while (i_138_ != -1 && i_137_ < string.length()) {
                            String string_139_ = string.substring(i_137_, i_138_);
                            string_139_ = string_139_.trim();
                            i_137_ = i_138_ + 1;
                            i_138_ = string.indexOf("\n", i_137_);
                            if (string_139_.startsWith("handling(")) {
                                try {
                                    handling = getvalue("handling", string_139_, 0);
                                    if (handling > 200)
                                        handling = 200;
                                    if (handling < 50)
                                        handling = 50;
                                } catch (Exception exception) {
                                    /* empty */
                                }
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
                            witho.show();
                        stringbutton("     TEST DRIVE!     ", 350, 505, 0, true);
                        if (tested) {
                            stringbutton("  Edit Stats & Class  ", 150, 471, 0, false);
                            stringbutton("  Edit Physics  ", 150, 505, 0, false);
                            stringbutton("     Rate Car Handling     ", 550, 471, 0, true);
                        }
                    } else {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(new StringBuilder().append("Based on you test drive(s), how do your rate ").append(carname).append("'s handling?").toString(), 350 - ftm.stringWidth(new StringBuilder().append("Based on your test drive(s), how do you rate ").append(carname).append("'s handling?").toString()) / 2, 445);
                        rd.setFont(new Font("Arial", 1, 12));
                        rd.drawString("Handling :", 183, 483);
                        for (int i_140_ = 0; i_140_ < handling; i_140_++) {
                            rd.setColor(Color.getHSBColor((float) ((double) (float) i_140_ * 7.0E-4), 1.0F, 1.0F));
                            rd.drawLine(250 + i_140_, 474, 250 + i_140_, 482);
                        }
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawLine(249, 474, 249, 482);
                        rd.drawLine(450, 474, 450, 482);
                        rd.drawLine(249, 483, 450, 483);
                        for (int i_141_ = 0; i_141_ < 7; i_141_++)
                            rd.drawLine(275 + i_141_ * 25, 482, 275 + i_141_ * 25, 478);
                        stringbutton(" - ", 480, 483, 4, false);
                        stringbutton(" + ", 520, 483, 4, false);
                        stringbutton("       Save       ", 388, 525, 0, true);
                        stringbutton(" Cancel ", 298, 525, 0, false);
                    }
                }
                if (polynum >= 0 && cntpls > 0) {
                    for (int i_142_ = 0; i_142_ < (o).npl; i_142_++) {
                        if (i_142_ >= polynum && i_142_ < polynum + cntpls) {
                            if (pflk)
                                ((o).p[i_142_]).hsb[2] = 1.0F;
                            else {
                                ((o).p[i_142_]).hsb[2] = 0.0F;
                                ((o).p[i_142_]).hsb[0] = Math.abs(0.5F - ((o).p[i_142_]).hsb[0]);
                                while (((o).p[i_142_]).hsb[0] > 1.0F)
                                ((o).p[i_142_]).hsb[0]--;
                            }
                        } else if (prflk > 6 && prflk < 20)
                            ((o).p[i_142_]).gr = -13;
                        else
                            ((o).p[i_142_]).gr = 1;
                    }
                    if (pflk)
                        pflk = false;
                    else
                        pflk = true;
                    if (prflk < 40)
                        prflk++;
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(new StringBuilder().append("[ Showing ").append(cntpls).append(" Polygons Selected ]").toString(), 350 - ftm.stringWidth(new StringBuilder().append("[ Showing ").append(cntpls).append(" Polygons Selected ]").toString()) / 2, 45);
                    stringbutton("  Stop  ", 350, 67, 5, false);
                }
                i = 50;
                if (rotr) {
                    (o).xz -= 5;
                    i = 15;
                }
                if (rotl) {
                    (o).xz += 5;
                    i = 15;
                }
                if (left) {
                    (o).xy -= 5;
                    i = 15;
                }
                if (right) {
                    (o).xy += 5;
                    i = 15;
                }
                if (up) {
                    (o).zy -= 5;
                    i = 15;
                }
                if (down) {
                    (o).zy += 5;
                    i = 15;
                }
                if (plus) {
                    (o).y += 5;
                    i = 15;
                }
                if (minus) {
                    (o).y -= 5;
                    i = 15;
                }
                if (in) {
                    (o).z += 10;
                    i = 15;
                }
                if (out) {
                    (o).z -= 10;
                    i = 15;
                }
                ox = (o).x;
                oy = (o).y;
                oz = (o).z;
                oxz = (o).xz;
                oxy = (o).xy;
                ozy = (o).zy;
                if (dtabed != dtab)
                    dtabed = dtab;
                if (dtab == 5 && pfase == -1) {
                    repaint();
                    JOptionPane.showMessageDialog(null, "Car Wheels not defined or not defined correctly.\nBefore defining the car Physics car Wheels must be defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n", "Car Maker", 1);
                    dtab = 3;
                }
            }
            if (tab == 3) {
                rd.setFont(new Font("Arial", 1, 13));
                rd.setColor(new Color(0, 0, 0));
                rd.drawString(new StringBuilder().append("Publish Car :  [ ").append(carname).append(" ]").toString(), 30, 50);
                rd.drawString("Publishing Type :", 30, 80);
                pubtyp.move(150, 63);
                if (!pubtyp.isShowing()) {
                    pubtyp.show();
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
                    rd.drawString("Public :  This means anyone can add this car to their account to play with it,", 268, 72);
                    rd.drawString("but only you can download it to your Car Maker (no one else can get it\u2019s code).", 268, 88);
                }
                if (pubtyp.getSelectedIndex() == 2) {
                    rd.drawString("Super Public :  This means anyone can add this car to their account to play", 268, 72);
                    rd.drawString("with it and anyone can also download it to their Car Maker to get its code.", 268, 88);
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
                    rd.drawString("The maximum number of cars your account can have at once is 20 cars.", 350 - ftm.stringWidth("The maximum number of cars your account can have at once is 20 cars.") / 2, 180);
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Login to Retrieve your Account Cars", 350 - ftm.stringWidth("Login to Retrieve your Account Cars") / 2, 220);
                    rd.drawString("Nickname:", 326 - ftm.stringWidth("Nickname:") - 14, 266);
                    movefield(tnick, 326, 250, 129, 22);
                    if (!tnick.isShowing())
                        tnick.show();
                    rd.drawString("Password:", 326 - ftm.stringWidth("Password:") - 14, 296);
                    movefield(tpass, 326, 280, 129, 22);
                    if (!tpass.isShowing())
                        tpass.show();
                    stringbutton("       Login       ", 350, 340, 0, true);
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Not registered yet?", 350 - ftm.stringWidth("Not registered yet?") / 2, 450);
                    stringbutton("   Register Now!   ", 350, 480, 0, true);
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Register to publish your cars to the multiplayer game!", 350 - ftm.stringWidth("Register to publish your cars to the multiplayer game!") / 2, 505);
                }
                if (logged == -1) {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Account empty, no published cars found.", 350 - ftm.stringWidth("Account empty, no published cars found.") / 2, 220);
                    rd.drawString("Click \u2018Publish\u2019 above to begin.", 350 - ftm.stringWidth("Click \u2018Publish\u2019 above to begin.") / 2, 280);
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.drawString("The maximum number of cars your account can have at once is 20 cars.", 350 - ftm.stringWidth("The maximum number of cars your account can have at once is 20 cars.") / 2, 320);
                }
                if (logged == 2) {
                    for (int i_143_ = 0; i_143_ < nmc; i_143_++) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(225, 225, 225));
                        rd.fillRect(50, 150, 600, 150);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString(new StringBuilder().append("Loading ").append(mycars[i_143_]).append("\u2018s info...").toString(), 350 - ftm.stringWidth(new StringBuilder().append("Loading ").append(mycars[i_143_]).append("\u2018s info...").toString()) / 2, 220);
                        repaint();
                        maker[i_143_] = "Unkown";
                        pubt[i_143_] = -1;
                        clas[i_143_] = 0;
                        nad[i_143_] = 0;
                        String string = "";
                        try {
                            String string_144_ = new StringBuilder().append("http://multiplayer.needformadness.com/cars/").append(mycars[i_143_]).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
                            string_144_ = string_144_.replace(' ', '_');
                            URL url = new URL(string_144_);
                            DataInputStream datainputstream = new DataInputStream(url.openStream());
                            while ((string = datainputstream.readLine()) != null) {
                                string = new StringBuilder().append("").append(string.trim()).toString();
                                if (string.startsWith("details")) {
                                    maker[i_143_] = getSvalue("details", string, 0);
                                    pubt[i_143_] = getvalue("details", string, 1);
                                    clas[i_143_] = getvalue("details", string, 2);
                                    boolean bool_145_ = false;
                                    while (!bool_145_) {
                                        addeda[i_143_][nad[i_143_]] = getSvalue("details", string, 3 + nad[i_143_]);
                                        if (addeda[i_143_][nad[i_143_]].equals(""))
                                            bool_145_ = true;
                                        else
                                            nad[i_143_]++;
                                    }
                                }
                            }
                        } catch (Exception exception) {
                            /* empty */
                        }
                    }
                    setCursor(new Cursor(0));
                    logged = 3;
                }
                if (logged == 1) {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Loading your account car list...", 350 - ftm.stringWidth("Loading your account car list...") / 2, 220);
                    repaint();
                    nmc = 0;
                    String string = "";
                    try {
                        URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/cars/lists/").append(tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                        DataInputStream datainputstream = new DataInputStream(url.openStream());
                        while ((string = datainputstream.readLine()) != null) {
                            string = new StringBuilder().append("").append(string.trim()).toString();
                            if (string.startsWith("mycars")) {
                                boolean bool_146_ = true;
                                while (bool_146_ && nmc < 20) {
                                    mycars[nmc] = getSvalue("mycars", string, nmc);
                                    if (mycars[nmc].equals(""))
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
                    } catch (Exception exception) {
                        String string_147_ = new StringBuilder().append("").append(exception).toString();
                        if (string_147_.indexOf("FileNotFound") != -1) {
                            setCursor(new Cursor(0));
                            logged = -1;
                        } else {
                            logged = 0;
                            JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1);
                        }
                    }
                }
                if (logged == 3) {
                    for (int i_148_ = 0; i_148_ < nmc; i_148_++) {
                        rd.setColor(new Color(235, 235, 235));
                        if (xm > 11 && xm < 689 && ym > 142 + i_148_ * 20 && ym < 160 + i_148_ * 20)
                            rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(11, 142 + i_148_ * 20, 678, 18);
                        rd.setFont(new Font("Arial", 0, 12));
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
                            String string = "C";
                            if (clas[i_148_] == 1)
                                string = "B & C";
                            if (clas[i_148_] == 2)
                                string = "B";
                            if (clas[i_148_] == 3)
                                string = "A & B";
                            if (clas[i_148_] == 4)
                                string = "A";
                            rd.drawString(new StringBuilder().append("Class ").append(string).append("").toString(), 200 - ftm.stringWidth(new StringBuilder().append("Class ").append(string).append("").toString()) / 2, 156 + i_148_ * 20);
                            boolean bool_149_ = false;
                            if (maker[i_148_].toLowerCase().equals(tnick.getText().toLowerCase())) {
                                bool_149_ = true;
                                rd.setColor(new Color(0, 64, 0));
                                rd.drawString("You", 300 - ftm.stringWidth("You") / 2, 156 + i_148_ * 20);
                            } else
                                rd.drawString(maker[i_148_], 300 - ftm.stringWidth(maker[i_148_]) / 2, 156 + i_148_ * 20);
                            if (nad[i_148_] > 1) {
                                if (ovbutton(new StringBuilder().append("").append(nad[i_148_]).append(" Players").toString(), 400, 156 + i_148_ * 20)) {
                                    String string_150_ = new StringBuilder().append("[ ").append(mycars[i_148_]).append(" ]  has been added by the following players to their accounts:     \n\n").toString();
                                    int i_151_ = 0;
                                    for (int i_152_ = 0; i_152_ < nad[i_148_]; i_152_++) {
                                        if (++i_151_ == 17) {
                                            string_150_ = new StringBuilder().append(string_150_).append("\n").toString();
                                            i_151_ = 1;
                                        }
                                        string_150_ = new StringBuilder().append(string_150_).append(addeda[i_148_][i_152_]).toString();
                                        if (i_152_ != nad[i_148_] - 1) {
                                            if (i_152_ != nad[i_148_] - 2)
                                                string_150_ = new StringBuilder().append(string_150_).append(", ").toString();
                                            else if (i_151_ == 16) {
                                                string_150_ = new StringBuilder().append(string_150_).append("\nand ").toString();
                                                i_151_ = 0;
                                            } else
                                                string_150_ = new StringBuilder().append(string_150_).append(" and ").toString();
                                        }
                                    }
                                    string_150_ = new StringBuilder().append(string_150_).append("\n \n \n").toString();
                                    JOptionPane.showMessageDialog(null, string_150_, "Car Maker", 1);
                                }
                            } else {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("None", 400 - ftm.stringWidth("None") / 2, 156 + i_148_ * 20);
                            }
                            if (pubt[i_148_] == 0) {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("Private", 500 - ftm.stringWidth("Private") / 2, 156 + i_148_ * 20);
                            }
                            if (pubt[i_148_] == 1) {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("Public", 500 - ftm.stringWidth("Public") / 2, 156 + i_148_ * 20);
                            }
                            if (pubt[i_148_] == 2) {
                                rd.setColor(new Color(0, 64, 0));
                                rd.drawString("Super Public", 500 - ftm.stringWidth("Super Public") / 2, 156 + i_148_ * 20);
                            }
                            if ((pubt[i_148_] == 2 || bool_149_) && ovbutton("Download", 600, 156 + i_148_ * 20)) {
                                int i_153_ = 0;
                                for (int i_154_ = 0; i_154_ < slcar.getItemCount(); i_154_++) {
                                    if (mycars[i_148_].equals(slcar.getItem(i_154_)))
                                        i_153_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Replace the local ").append(mycars[i_148_]).append(" in your 'mycars' folder with the published online copy?").toString(), "Car Maker", 0);
                                }
                                if (i_153_ == 0) {
                                    setCursor(new Cursor(3));
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.setColor(new Color(225, 225, 225));
                                    rd.fillRect(11, 141, 679, 401);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("Downloading car, please wait...", 350 - ftm.stringWidth("Downloading car, please wait...") / 2, 250);
                                    repaint();
                                    try {
                                        String string_155_ = new StringBuilder().append("http://multiplayer.needformadness.com/cars/").append(mycars[i_148_]).append(".radq?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
                                        string_155_ = string_155_.replace(' ', '_');
                                        URL url = new URL(string_155_);
                                        int i_156_ = url.openConnection().getContentLength();
                                        DataInputStream datainputstream = new DataInputStream(url.openStream());
                                        byte[] is = new byte[i_156_];
                                        datainputstream.readFully(is);
                                        ZipInputStream zipinputstream;
                                        if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                                            zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                                        else {
                                            byte[] is_157_ = new byte[i_156_ - 40];
                                            for (int i_158_ = 0; i_158_ < i_156_ - 40; i_158_++) {
                                                int i_159_ = 20;
                                                if (i_158_ >= 500)
                                                    i_159_ = 40;
                                                is_157_[i_158_] = is[i_158_ + i_159_];
                                            }
                                            zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_157_));
                                        }
                                        ZipEntry zipentry = zipinputstream.getNextEntry();
                                        if (zipentry != null) {
                                            int i_160_ = Integer.valueOf(zipentry.getName()).intValue();
                                            byte[] is_161_ = new byte[i_160_];
                                            int i_162_ = 0;
                                            int i_163_;
                                            for (/**/; i_160_ > 0; i_160_ -= i_163_) {
                                                i_163_ = zipinputstream.read(is_161_, i_162_, i_160_);
                                                i_162_ += i_163_;
                                            }
                                            String string_164_ = new String(is_161_);
                                            string_164_ = new StringBuilder().append(string_164_).append("\n").toString();
                                            String string_165_ = "";
                                            int i_166_ = 0;
                                            int i_167_ = string_164_.indexOf("\n", 0);
                                            while (i_167_ != -1 && i_166_ < string_164_.length()) {
                                                String string_168_ = string_164_.substring(i_166_, i_167_);
                                                string_168_ = string_168_.trim();
                                                i_166_ = i_167_ + 1;
                                                i_167_ = string_164_.indexOf("\n", i_166_);
                                                if (!string_168_.startsWith("carmaker(") && !string_168_.startsWith("publish("))
                                                    string_165_ = new StringBuilder().append(string_165_).append("").append(string_168_).append("\n").toString();
                                                else {
                                                    string_165_ = string_165_.trim();
                                                    string_165_ = new StringBuilder().append(string_165_).append("\n").toString();
                                                }
                                            }
                                            string_165_ = string_165_.trim();
                                            string_165_ = new StringBuilder().append(string_165_).append("\n\n").toString();
                                            File file = new File("mycars/");
                                            if (!file.exists())
                                                file.mkdirs();
                                            file = new File(new StringBuilder().append("mycars/").append(mycars[i_148_]).append(".rad").toString());
                                            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                            bufferedwriter.write(string_165_);
                                            bufferedwriter.close();
                                            zipinputstream.close();
                                            if (carname.equals(mycars[i_148_])) {
                                                editor.setText(string_165_);
                                                lastedo = string_165_;
                                            }
                                            setCursor(new Cursor(0));
                                            JOptionPane.showMessageDialog(null, new StringBuilder().append("").append(mycars[i_148_]).append(" has been successfully downloaded!").toString(), "Car Maker", 1);
                                        } else
                                            JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                                    } catch (Exception exception) {
                                        JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                                    }
                                }
                            }
                        } else
                            rd.drawString("-    Error Loading this car's info!    -", 350 - ftm.stringWidth("-    Error Loading this car's info!    -") / 2, 156 + i_148_ * 20);
                        if (ovbutton("X", 665, 156 + i_148_ * 20) && JOptionPane.showConfirmDialog(null, new StringBuilder().append("Remove ").append(mycars[i_148_]).append(" from your account?").toString(), "Car Maker", 0) == 0) {
                            setCursor(new Cursor(3));
                            int i_169_ = -1;
                            try {
                                Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                                printwriter.println(new StringBuilder().append("9|").append(tnick.getText()).append("|").append(tpass.getText()).append("|").append(mycars[i_148_]).append("|").toString());
                                String string = bufferedreader.readLine();
                                if (string != null)
                                    i_169_ = servervalue(string, 0);
                                socket.close();
                            } catch (Exception exception) {
                                i_169_ = -1;
                            }
                            if (i_169_ == 0)
                                logged = 1;
                            else {
                                setCursor(new Cursor(0));
                                JOptionPane.showMessageDialog(null, new StringBuilder().append("Failed to remove ").append(mycars[i_148_]).append(" from your account.  Unknown Error!     \nPlease try again later.").toString(), "Car Maker", 1);
                            }
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
            String[] strings = { "Car", "Code Edit", "3D Edit", "Publish" };
            int[] is = { 0, 0, 100, 90 };
            int[] is_170_ = { 0, 25, 25, 0 };
            int i_171_ = 4;
            if (carname.equals("") || !loadedfile || sfase != 0) {
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
            if (!exwist) {
                try {
                    if (thredo != null) {
                        /* empty */
                    }
                    Thread.sleep((long) i);
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
            }
        }
        rd.dispose();
        System.gc();
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
                if (i == 1) {
                    if (!carname.equals("")) {
                        srch.setText(carname);
                        sfase = 2;
                        i = -1;
                        hidefields();
                    } else
                        JOptionPane.showMessageDialog(null, "Please Select a Car to Rename!\n", "Car Maker", 1);
                }
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
                    FileDialog filedialog = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
                    filedialog.setFile("*.obj");
                    filedialog.setMode(0);
                    filedialog.setVisible(true);
                    try {
                        if (filedialog.getFile() != null)
                            file = new File(new StringBuilder().append("").append(filedialog.getDirectory()).append("").append(filedialog.getFile()).append("").toString());
                    } catch (Exception exception) {
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
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.drawString(new StringBuilder().append("Reading ").append(file.getName()).append(", please wait...").toString(), 350 - ftm.stringWidth(new StringBuilder().append("Reading ").append(file.getName()).append(", please wait...").toString()) / 2, 276 + i_175_);
                        repaint();
                        int[] is = new int[6000];
                        int[] is_176_ = new int[6000];
                        int[] is_177_ = new int[6000];
                        int i_178_ = 0;
                        int[][] is_179_ = new int[600][100];
                        int[] is_180_ = new int[600];
                        int i_181_ = 0;
                        if (file.exists()) {
                            try {
                                BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                                boolean bool = false;
                                boolean bool_182_ = false;
                                String string;
                                while ((string = bufferedreader.readLine()) != null) {
                                    if (string.startsWith("v ")) {
                                        if (i_178_ < 6000) {
                                            multf10 = true;
                                            is[i_178_] = objvalue(string, 0);
                                            is_176_[i_178_] = objvalue(string, 1);
                                            is_177_[i_178_] = objvalue(string, 2);
                                            i_178_++;
                                        } else
                                            bool = true;
                                    }
                                    if (string.startsWith("f ")) {
                                        if (i_181_ < 600) {
                                            multf10 = false;
                                            objfacend = false;
                                            for (is_180_[i_181_] = 0; !objfacend && is_180_[i_181_] < 100; is_180_[i_181_]++)
                                                is_179_[i_181_][is_180_[i_181_]] = objvalue(string, is_180_[i_181_]);
                                            i_181_++;
                                        } else
                                            bool_182_ = true;
                                    }
                                }
                                if (bool)
                                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Warning!\nThe number of Vertices in file ").append(file.getName()).append(" exceeded the maximum of 6000 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n").toString(), "Car Maker", 0);
                                if (bool_182_)
                                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Warning!\nThe number of Faces in file ").append(file.getName()).append(" exceeded the maximum of 600 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n").toString(), "Car Maker", 0);
                                bufferedreader.close();
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to load file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
                            }
                            rd.setColor(new Color(225, 225, 225));
                            rd.fillRect(116, 246 + i_175_, 468, 50);
                            rd.setColor(new Color(0, 0, 0));
                            rd.setFont(new Font("Arial", 1, 13));
                            ftm = rd.getFontMetrics();
                            rd.drawString(new StringBuilder().append("Importing ").append(file.getName()).append(", please wait...").toString(), 350 - ftm.stringWidth(new StringBuilder().append("Importing ").append(file.getName()).append(", please wait...").toString()) / 2, 276 + i_175_);
                            repaint();
                            carname = file.getName();
                            if (carname.endsWith(".obj"))
                                carname = carname.substring(0, carname.length() - 4);
                            String string = new StringBuilder().append("\n// imported car: ").append(carname).append("\n---------------------\n\n// Please read the helpful information about importing cars found at:\n// http://www.needformadness.com/developer/extras.html\n\n\n").toString();
                            for (int i_184_ = 0; i_184_ < i_181_; i_184_++) {
                                string = new StringBuilder().append(string).append("<p>\nc(200,200,220)\n\n").toString();
                                for (int i_185_ = 0; i_185_ < is_180_[i_184_]; i_185_++) {
                                    if (is_179_[i_184_][i_185_] < 6000) {
                                        int i_186_ = is_179_[i_184_][i_185_];
                                        string = new StringBuilder().append(string).append("p(").append(is[i_186_]).append(",").append(-is_176_[i_186_]).append(",").append(is_177_[i_186_]).append(")\n").toString();
                                    }
                                }
                                string = new StringBuilder().append(string).append("</p>\n\n").toString();
                            }
                            string = new StringBuilder().append(string).append("\n\n\n\n").toString();
                            file = new File("mycars/");
                            if (!file.exists())
                                file.mkdirs();
                            file = new File(new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
                            int i_187_ = 0;
                            if (file.exists())
                                i_187_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Another car with the name '").append(carname).append("' already exists, replace it?      \n").toString(), "Car Maker", 0);
                            if (i_187_ == 0) {
                                try {
                                    BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                    bufferedwriter.write(string);
                                    bufferedwriter.close();
                                    if (file.exists()) {
                                        sfase = 0;
                                        hidefields();
                                        tabed = -1;
                                    } else {
                                        carname = "";
                                        JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
                                    }
                                } catch (Exception exception) {
                                    carname = "";
                                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to create file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error, ").append(file.getName()).append(" was not found!").toString(), "Car Maker", 1);
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
                    FileDialog filedialog = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
                    filedialog.setFile(new StringBuilder().append("").append(carname).append(".obj").toString());
                    filedialog.setMode(1);
                    filedialog.setVisible(true);
                    try {
                        if (filedialog.getFile() != null)
                            file = new File(new StringBuilder().append("").append(filedialog.getDirectory()).append("").append(filedialog.getFile()).append("").toString());
                    } catch (Exception exception) {
                        /* empty */
                    }
                    if (file != null) {
                        int i_188_ = 0;
                        if (file.exists())
                            i_188_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("File ").append(file.getName()).append(" already exists, replace it?      \n").toString(), "Car Maker", 0);
                        if (i_188_ == 0) {
                            setCursor(new Cursor(3));
                            setupo();
                            int[] is = new int[6000];
                            int[] is_189_ = new int[6000];
                            int[] is_190_ = new int[6000];
                            int i_191_ = 0;
                            String string = "";
                            for (int i_192_ = 0; i_192_ < (o).npl; i_192_++) {
                                for (int i_193_ = 0; i_193_ < ((o).p[i_192_]).n; i_193_++) {
                                    boolean bool = false;
                                    for (int i_194_ = 0; i_194_ < i_191_; i_194_++) {
                                        if (is[i_194_] == ((o).p[i_192_]).ox[i_193_] && is_189_[i_194_] == ((o).p[i_192_]).oy[i_193_] && is_190_[i_194_] == ((o).p[i_192_]).oz[i_193_])
                                            bool = true;
                                    }
                                    if (!bool && i_191_ < 6000) {
                                        is[i_191_] = ((o).p[i_192_]).ox[i_193_];
                                        is_189_[i_191_] = ((o).p[i_192_]).oy[i_193_];
                                        is_190_[i_191_] = ((o).p[i_192_]).oz[i_193_];
                                        i_191_++;
                                    }
                                }
                            }
                            for (int i_195_ = 0; i_195_ < i_191_; i_195_++)
                                string = new StringBuilder().append(string).append("v ").append((float) is[i_195_] / 10.0F).append(" ").append((float) -is_189_[i_195_] / 10.0F).append(" ").append((float) is_190_[i_195_] / 10.0F).append("\n").toString();
                            for (int i_196_ = 0; i_196_ < (o).npl; i_196_++) {
                                if (((o).p[i_196_]).wz == 0) {
                                    string = new StringBuilder().append(string).append("f").toString();
                                    for (int i_197_ = 0; i_197_ < ((o).p[i_196_]).n; i_197_++) {
                                        string = new StringBuilder().append(string).append(" ").toString();
                                        for (int i_198_ = 0; i_198_ < i_191_; i_198_++) {
                                            if (is[i_198_] == ((o).p[i_196_]).ox[i_197_] && is_189_[i_198_] == ((o).p[i_196_]).oy[i_197_] && is_190_[i_198_] == ((o).p[i_196_]).oz[i_197_])
                                                string = new StringBuilder().append(string).append("").append(i_198_ + 1).toString();
                                        }
                                    }
                                    string = new StringBuilder().append(string).append("\n").toString();
                                }
                            }
                            try {
                                BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                bufferedwriter.write(string);
                                bufferedwriter.close();
                                if (file.exists()) {
                                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Car has been successfully exported to:\n").append(file.getAbsolutePath()).append("          \n \n").toString(), "Car Maker", 1);
                                    sfase = 0;
                                    hidefields();
                                    tabed = -1;
                                } else
                                    JOptionPane.showMessageDialog(null, "Failed to export car, unknown reason!\n", "Car Maker", 1);
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to create exported file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
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
            if (i == 0) {
                if (prefs)
                    prefs = false;
                else
                    prefs = true;
            }
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
                        } catch (InterruptedException interruptedexception) {
                            /* empty */
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
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("Cannot find  '").append(srch.getText()).append("'  from Cursor position    ").toString(), "Car Maker", 1);
                }
            } else {
                if (i == 3 || i == 4 || i == 5) {
                    String string = new StringBuilder().append("").append(editor.getSelectedText()).append("\n").toString();
                    String string_199_ = "\n\n";
                    if (cntpls == 1)
                        string_199_ = new StringBuilder().append(string_199_).append("// Mirror of the polygon above along the ").toString();
                    else
                        string_199_ = new StringBuilder().append(string_199_).append("// Mirror of the ").append(cntpls).append(" polygons above along the ").toString();
                    if (i == 3)
                        string_199_ = new StringBuilder().append(string_199_).append("X axis:").toString();
                    if (i == 4)
                        string_199_ = new StringBuilder().append(string_199_).append("Y axis:").toString();
                    if (i == 5)
                        string_199_ = new StringBuilder().append(string_199_).append("Z axis:").toString();
                    string_199_ = new StringBuilder().append(string_199_).append("\n\n").toString();
                    int i_200_ = 0;
                    int i_201_ = string.indexOf("\n", 0);
                    while (i_201_ != -1 && i_200_ < string.length()) {
                        String string_202_ = string.substring(i_200_, i_201_);
                        string_202_ = string_202_.trim();
                        i_200_ = i_201_ + 1;
                        i_201_ = string.indexOf("\n", i_200_);
                        if (string_202_.startsWith("fs(-"))
                            string_202_ = new StringBuilder().append("fs(").append(string_202_.substring(4, string_202_.length())).append("").toString();
                        else if (string_202_.startsWith("fs("))
                            string_202_ = new StringBuilder().append("fs(-").append(string_202_.substring(3, string_202_.length())).append("").toString();
                        if (i == 3) {
                            if (string_202_.startsWith("p(-"))
                                string_202_ = new StringBuilder().append("p(").append(string_202_.substring(3, string_202_.length())).append("").toString();
                            else if (string_202_.startsWith("p("))
                                string_202_ = new StringBuilder().append("p(-").append(string_202_.substring(2, string_202_.length())).append("").toString();
                        }
                        if (i == 4 && string_202_.startsWith("p(")) {
                            int i_203_ = string_202_.indexOf(",", 0);
                            if (i_203_ >= 0) {
                                if (string_202_.startsWith(",-", i_203_))
                                    string_202_ = new StringBuilder().append("").append(string_202_.substring(0, i_203_)).append(",").append(string_202_.substring(i_203_ + 2, string_202_.length())).append("").toString();
                                else if (string_202_.startsWith(",", i_203_))
                                    string_202_ = new StringBuilder().append("").append(string_202_.substring(0, i_203_)).append(",-").append(string_202_.substring(i_203_ + 1, string_202_.length())).append("").toString();
                            }
                        }
                        if (i == 5 && string_202_.startsWith("p(")) {
                            int i_204_ = string_202_.indexOf(",", 0);
                            i_204_ = string_202_.indexOf(",", i_204_ + 1);
                            if (i_204_ >= 0) {
                                if (string_202_.startsWith(",-", i_204_))
                                    string_202_ = new StringBuilder().append("").append(string_202_.substring(0, i_204_)).append(",").append(string_202_.substring(i_204_ + 2, string_202_.length())).append("").toString();
                                else if (string_202_.startsWith(",", i_204_))
                                    string_202_ = new StringBuilder().append("").append(string_202_.substring(0, i_204_)).append(",-").append(string_202_.substring(i_204_ + 1, string_202_.length())).append("").toString();
                            }
                        }
                        string_199_ = new StringBuilder().append(string_199_).append("").append(string_202_).append("\n").toString();
                    }
                    string_199_ = new StringBuilder().append(string_199_).append("\n// End of mirror").toString();
                    editor.insertText(string_199_, editor.getSelectionEnd());
                }
                if (i == 6) {
                    polynum = 0;
                    int i_205_ = editor.getText().lastIndexOf("</p>", editor.getSelectionStart());
                    boolean bool = false;
                    for (/**/; i_205_ >= 0; i_205_--) {
                        if (!bool) {
                            i_205_ = editor.getText().lastIndexOf("<p>", i_205_);
                            if (i_205_ != -1) {
                                bool = true;
                                polynum++;
                            }
                        } else {
                            i_205_ = editor.getText().lastIndexOf("</p>", i_205_);
                            if (i_205_ != -1)
                                bool = false;
                        }
                    }
                    prflk = 0;
                    tab = 2;
                }
            }
            i = -1;
        }
        if (tab == 2) {
            int i_206_ = 0;
            if (dtab == 1) {
                if ((o).colok != 2) {
                    if (i == 0) {
                        JOptionPane.showMessageDialog(null, "Car Maker will attempt now to find the first and second colors automatically.\nPlease make sure that they are the correct colors!\n\nPlease note that these are also the colors that will be editable in the multiplayer game.      ", "Car Maker", 1);
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        int i_207_ = 0;
                        int i_208_ = string.indexOf("\n", 0);
                        int i_209_ = 0;
                        String string_210_ = "";
                        String string_211_ = "";
                        while (i_208_ != -1 && i_207_ < string.length() && i_209_ != 2) {
                            String string_212_ = string.substring(i_207_, i_208_);
                            string_212_ = string_212_.trim();
                            i_207_ = i_208_ + 1;
                            i_208_ = string.indexOf("\n", i_207_);
                            if (string_212_.startsWith("c(")) {
                                String string_213_ = string_212_.substring(1, string_212_.indexOf(")") + 1);
                                if (i_209_ == 1 && !string_213_.equals(string_211_)) {
                                    string_210_ = new StringBuilder().append(string_210_).append("2ndColor").append(string_213_).append("\n\n\n").toString();
                                    i_209_ = 2;
                                }
                                if (i_209_ == 0) {
                                    string_211_ = string_213_;
                                    string_210_ = new StringBuilder().append("1stColor").append(string_213_).append("\n").toString();
                                    i_209_ = 1;
                                }
                            }
                        }
                        if (i_209_ == 0) {
                            string_210_ = "1stColor(255,0,0)\n2ndColor(0,0,255)\n\n\n";
                            i_209_ = 2;
                        }
                        if (i_209_ == 1) {
                            string_210_ = new StringBuilder().append(string_210_).append("2ndColor(0,0,255)\n\n\n").toString();
                            i_209_ = 2;
                        }
                        int i_214_ = editor.getText().indexOf("<p>", 0);
                        editor.insertText(string_210_, i_214_);
                        editor.select(i_214_, i_214_ + string_210_.length() - 2);
                        breakbond = true;
                        tab = 1;
                    }
                    i_206_ = 1;
                } else {
                    if (i == 0) {
                        ofcol = new StringBuilder().append("(").append((o).fcol[0]).append(",").append((o).fcol[1]).append(",").append((o).fcol[2]).append(")").toString();
                        int i_215_ = editor.getText().indexOf(ofcol, 0);
                        int i_216_ = i_215_;
                        for (/**/; i_215_ != -1; i_215_ = editor.getText().indexOf(ofcol, i_215_ + 1))
                            editor.replaceText(fcol, i_215_, i_215_ + ofcol.length());
                        ofcol = fcol;
                        editor.select(i_216_ - 8, i_216_ - 8);
                        savefile();
                        (o).fcol[0] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getRed();
                        (o).fcol[1] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getGreen();
                        (o).fcol[2] = Color.getHSBColor(fhsb[0], fhsb[2], fhsb[1]).getBlue();
                    }
                    if (i == 1) {
                        oscol = new StringBuilder().append("(").append((o).scol[0]).append(",").append((o).scol[1]).append(",").append((o).scol[2]).append(")").toString();
                        int i_217_ = editor.getText().indexOf(oscol, 0);
                        int i_218_ = i_217_;
                        for (/**/; i_217_ != -1; i_217_ = editor.getText().indexOf(oscol, i_217_ + 1))
                            editor.replaceText(scol, i_217_, i_217_ + oscol.length());
                        oscol = scol;
                        editor.select(i_218_ - 8, i_218_ - 8);
                        savefile();
                        (o).scol[0] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getRed();
                        (o).scol[1] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getGreen();
                        (o).scol[2] = Color.getHSBColor(shsb[0], shsb[2], shsb[1]).getBlue();
                    }
                    i_206_ = 2;
                }
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
                    int i_219_ = editor.getText().indexOf("\nScaleX(", 0);
                    if (i_219_ != -1) {
                        i_219_++;
                        int i_220_ = editor.getText().indexOf(")", i_219_);
                        int i_221_ = editor.getText().indexOf("\n", i_219_);
                        if (i_221_ > i_220_)
                            editor.replaceText(new StringBuilder().append("ScaleX(").append(scale[0]).append(")").toString(), i_219_, i_220_ + 1);
                        else
                            editor.replaceText(new StringBuilder().append("ScaleX(").append(scale[0]).append(")").toString(), i_219_, i_221_);
                    } else {
                        int i_222_ = editor.getText().indexOf("<p>", 0);
                        int i_223_ = editor.getText().indexOf("\nScale", 0);
                        if (i_223_ < i_222_ && i_223_ != -1)
                            editor.insertText(new StringBuilder().append("\nScaleX(").append(scale[0]).append(")").toString(), i_223_);
                        else
                            editor.insertText(new StringBuilder().append("ScaleX(").append(scale[0]).append(")\n\n\n").toString(), i_222_);
                    }
                }
                if (i == 2 || i == 3 || i == 6 || i == 7 || i == 9) {
                    if (i == 2 || i == 6)
                        scale[1] -= 5;
                    if (i == 3 || i == 7)
                        scale[1] += 5;
                    if (scale[1] < 0)
                        scale[1] = 0;
                    int i_224_ = editor.getText().indexOf("\nScaleY(", 0);
                    if (i_224_ != -1) {
                        i_224_++;
                        int i_225_ = editor.getText().indexOf(")", i_224_);
                        int i_226_ = editor.getText().indexOf("\n", i_224_);
                        if (i_226_ > i_225_)
                            editor.replaceText(new StringBuilder().append("ScaleY(").append(scale[1]).append(")").toString(), i_224_, i_225_ + 1);
                        else
                            editor.replaceText(new StringBuilder().append("ScaleY(").append(scale[1]).append(")").toString(), i_224_, i_226_);
                    } else {
                        int i_227_ = editor.getText().indexOf("<p>", 0);
                        int i_228_ = editor.getText().indexOf("\nScale", 0);
                        if (i_228_ < i_227_ && i_228_ != -1)
                            editor.insertText(new StringBuilder().append("\nScaleY(").append(scale[1]).append(")").toString(), i_228_);
                        else
                            editor.insertText(new StringBuilder().append("ScaleY(").append(scale[1]).append(")\n\n\n").toString(), i_227_);
                    }
                }
                if (i == 4 || i == 5 || i == 6 || i == 7 || i == 9) {
                    if (i == 4 || i == 6)
                        scale[2] -= 5;
                    if (i == 5 || i == 7)
                        scale[2] += 5;
                    if (scale[2] < 0)
                        scale[2] = 0;
                    int i_229_ = editor.getText().indexOf("\nScaleZ(", 0);
                    if (i_229_ != -1) {
                        i_229_++;
                        int i_230_ = editor.getText().indexOf(")", i_229_);
                        int i_231_ = editor.getText().indexOf("\n", i_229_);
                        if (i_231_ > i_230_)
                            editor.replaceText(new StringBuilder().append("ScaleZ(").append(scale[2]).append(")").toString(), i_229_, i_230_ + 1);
                        else
                            editor.replaceText(new StringBuilder().append("ScaleZ(").append(scale[2]).append(")").toString(), i_229_, i_231_);
                    } else {
                        int i_232_ = editor.getText().indexOf("<p>", 0);
                        int i_233_ = editor.getText().indexOf("\nScale", 0);
                        if (i_233_ < i_232_ && i_233_ != -1)
                            editor.insertText(new StringBuilder().append("\nScaleZ(").append(scale[2]).append(")").toString(), i_233_);
                        else
                            editor.insertText(new StringBuilder().append("ScaleZ(").append(scale[2]).append(")\n\n\n").toString(), i_232_);
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
                if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18) {
                    try {
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        String string_234_ = "";
                        int i_235_ = 0;
                        int i_236_ = string.indexOf("\n", 0);
                        while (i_236_ != -1 && i_235_ < string.length()) {
                            String string_237_ = string.substring(i_235_, i_236_);
                            string_237_ = string_237_.trim();
                            i_235_ = i_236_ + 1;
                            i_236_ = string.indexOf("\n", i_235_);
                            if (string_237_.startsWith("p(")) {
                                int i_238_ = string_237_.indexOf(",", 0);
                                int i_239_ = string_237_.indexOf(",", i_238_ + 1);
                                int i_240_ = string_237_.indexOf(")", i_239_ + 1);
                                if (i_238_ != -1 && i_239_ != -1 && i_240_ != -1) {
                                    int i_241_ = Float.valueOf(string_237_.substring(2, i_238_)).intValue();
                                    int i_242_ = Float.valueOf(string_237_.substring(i_238_ + 1, i_239_)).intValue();
                                    int i_243_ = Float.valueOf(string_237_.substring(i_239_ + 1, i_240_)).intValue();
                                    if (i == 10) {
                                        int i_244_ = i_242_;
                                        i_242_ = i_243_;
                                        i_243_ = -i_244_;
                                    }
                                    if (i == 11)
                                        i_241_ += 10;
                                    if (i == 12)
                                        i_241_ -= 10;
                                    if (i == 13) {
                                        int i_245_ = i_241_;
                                        i_241_ = -i_243_;
                                        i_243_ = i_245_;
                                    }
                                    if (i == 14)
                                        i_242_ += 10;
                                    if (i == 15)
                                        i_242_ -= 10;
                                    if (i == 16) {
                                        int i_246_ = i_242_;
                                        i_242_ = -i_241_;
                                        i_241_ = i_246_;
                                    }
                                    if (i == 17)
                                        i_243_ += 10;
                                    if (i == 18)
                                        i_243_ -= 10;
                                    string_234_ = new StringBuilder().append(string_234_).append("p(").append(i_241_).append(",").append(i_242_).append(",").append(i_243_).append(")").append(string_237_.substring(i_240_ + 1, string_237_.length())).append("\n").toString();
                                } else
                                    string_234_ = new StringBuilder().append(string_234_).append("").append(string_237_).append("\n").toString();
                            } else
                                string_234_ = new StringBuilder().append(string_234_).append("").append(string_237_).append("\n").toString();
                        }
                        editor.setText(string_234_);
                        setupo();
                        changed2 = true;
                    } catch (Exception exception) {
                        /* empty */
                    }
                }
                if (i == 19) {
                    editor.setText(lastedo);
                    setupo();
                    changed2 = false;
                }
                if (i == 20 && changed2) {
                    int i_247_ = JOptionPane.showConfirmDialog(null, "Saving now will permanently change the point locations & numbers entered in the code!      \n\nContinue?", "Car Maker", 0);
                    if (i_247_ == 0) {
                        editor.setText(new StringBuilder().append(editor.getText().trim()).append("\n\n\n\n").toString());
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
                        JOptionPane.showMessageDialog(null, "Car Maker will setup default Front and Back Wheels positions and adjustments.\n\nEnter the desired positions and adjustments then press ' Apply ' to view!\nDon't forget to press ' Save ' when finished!", "Car Maker", 1);
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
                            wv[15].setText("40");
                        if (i_249_ < -40)
                            wv[15].setText("-40");
                        i_249_ = Float.valueOf(wv[7].getText()).intValue();
                        if (i_249_ > 40)
                            wv[7].setText("40");
                        if (i_249_ < -40)
                            wv[7].setText("-40");
                    } catch (Exception exception) {
                        /* empty */
                    }
                    if (i_248_ == 1)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("ERROR:\nThe Z location value of the FRONT Wheels must be greater then zero! (it should have a +ve value)\nZ :  '").append(wv[10].getText()).append("'  is less or equal to zero, where it should have +ve value!").toString(), "Car Maker", 1);
                    if (i_248_ == 2)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("ERROR:\nThe Z location value of the BACK Wheels must be smaller then zero! (it should have a -ve value)\nZ :  '").append(wv[2].getText()).append("'  is bigger or equal to zero, where it should have -ve value!").toString(), "Car Maker", 1);
                    if (i_248_ == 3)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("ERROR:\nThe \u00b1X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n\u00b1X :  '").append(wv[8].getText()).append("'  is less or equal to zero, where it should have +ve value!").toString(), "Car Maker", 1);
                    if (i_248_ == 4)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("ERROR:\nThe \u00b1X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n\u00b1X :  '").append(wv[0].getText()).append("'  is less or equal to zero, whenr it should have +ve value!").toString(), "Car Maker", 1);
                    if (i_248_ == 0) {
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        String string_250_ = "";
                        int i_251_ = 0;
                        int i_252_ = string.indexOf("\n", 0);
                        while (i_252_ != -1 && i_251_ < string.length()) {
                            String string_253_ = string.substring(i_251_, i_252_);
                            string_253_ = string_253_.trim();
                            i_251_ = i_252_ + 1;
                            i_252_ = string.indexOf("\n", i_251_);
                            if (!string_253_.startsWith("rims(") && !string_253_.startsWith("gwgr(") && !string_253_.startsWith("w("))
                                string_250_ = new StringBuilder().append(string_250_).append("").append(string_253_).append("\n").toString();
                            else {
                                string_250_ = string_250_.trim();
                                string_250_ = new StringBuilder().append(string_250_).append("\n").toString();
                            }
                        }
                        string_250_ = string_250_.trim();
                        string_250_ = new StringBuilder().append(string_250_).append("\n\n\ngwgr(").append(wv[15].getText()).append(")\n").toString();
                        String string_254_ = "140,140,140";
                        if (rplc.getText().startsWith("(") && rplc.getText().endsWith(")"))
                            string_254_ = rplc.getText().substring(1, rplc.getText().length() - 1);
                        string_250_ = new StringBuilder().append(string_250_).append("rims(").append(string_254_).append(",").append(wv[13].getText()).append(",").append(wv[14].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("w(-").append(wv[8].getText()).append(",").append(wv[9].getText()).append(",").append(wv[10].getText()).append(",11,").append(wv[12].getText()).append(",").append(wv[11].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("w(").append(wv[8].getText()).append(",").append(wv[9].getText()).append(",").append(wv[10].getText()).append(",11,-").append(wv[12].getText()).append(",").append(wv[11].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("\ngwgr(").append(wv[7].getText()).append(")\n").toString();
                        string_254_ = "140,140,140";
                        if (srch.getText().startsWith("(") && srch.getText().endsWith(")"))
                            string_254_ = srch.getText().substring(1, srch.getText().length() - 1);
                        string_250_ = new StringBuilder().append(string_250_).append("rims(").append(string_254_).append(",").append(wv[5].getText()).append(",").append(wv[6].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("w(-").append(wv[0].getText()).append(",").append(wv[1].getText()).append(",").append(wv[2].getText()).append(",0,").append(wv[4].getText()).append(",").append(wv[3].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("w(").append(wv[0].getText()).append(",").append(wv[1].getText()).append(",").append(wv[2].getText()).append(",0,-").append(wv[4].getText()).append(",").append(wv[3].getText()).append(")\n\n\n\n").toString();
                        editor.setText(string_250_);
                        forwheels = true;
                        setupo();
                        forwheels = false;
                        aply1 = new StringBuilder().append("").append(wv[0].getText()).append("").append(wv[1].getText()).append("").append(wv[2].getText()).append("").append(wv[3].getText()).append("").append(wv[4].getText()).append("").append(srch.getText()).append("").append(wv[5].getText()).append("").append(wv[6].getText()).append("").append(wv[7].getText()).append("").toString();
                        aply2 = new StringBuilder().append("").append(wv[8].getText()).append("").append(wv[9].getText()).append("").append(wv[10].getText()).append("").append(wv[11].getText()).append("").append(wv[12].getText()).append("").append(rplc.getText()).append("").append(wv[13].getText()).append("").append(wv[14].getText()).append("").append(wv[15].getText()).append("").toString();
                        aplyd1 = false;
                        aplyd2 = false;
                        changed2 = true;
                    }
                }
                if (i == 1 || i == 3) {
                    if (!(o).errd) {
                        savefile();
                        changed2 = false;
                    } else
                        JOptionPane.showMessageDialog(null, "Unable to Save, press  [ Apply ]  to find out why!", "Car Maker", 1);
                }
                i_206_ = 4;
            }
            if (dtab == 4) {
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
                            simcar.add(rd, "   ");
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
                            for (int i_260_ = 0; i_260_ < 5; i_260_++) {
                                if (i_257_ != i_260_ && (stat[i_260_] <= 200 || i_258_ > 0) && (stat[i_260_] >= 16 || i_258_ < 0) && i_258_ != 0) {
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
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        String string_263_ = "";
                        int i_264_ = 0;
                        int i_265_ = string.indexOf("\n", 0);
                        while (i_265_ != -1 && i_264_ < string.length()) {
                            String string_266_ = string.substring(i_264_, i_265_);
                            string_266_ = string_266_.trim();
                            i_264_ = i_265_ + 1;
                            i_265_ = string.indexOf("\n", i_264_);
                            if (!string_266_.startsWith("stat("))
                                string_263_ = new StringBuilder().append(string_263_).append("").append(string_266_).append("\n").toString();
                            else {
                                string_263_ = string_263_.trim();
                                string_263_ = new StringBuilder().append(string_263_).append("\n").toString();
                            }
                        }
                        string_263_ = string_263_.trim();
                        string_263_ = new StringBuilder().append(string_263_).append("\n\n\nstat(").append(stat[0]).append(",").append(stat[1]).append(",").append(stat[2]).append(",").append(stat[3]).append(",").append(stat[4]).append(")\n\n\n\n").toString();
                        editor.setText(string_263_);
                        savefile();
                        for (int i_267_ = 0; i_267_ < 5; i_267_++)
                            rstat[i_267_] = stat[i_267_];
                        changed2 = false;
                    }
                    if (i == 12) {
                        for (int i_268_ = 0; i_268_ < 5; i_268_++)
                            stat[i_268_] = rstat[i_268_];
                    }
                    i_206_ = 13;
                }
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
                    if (i == 8) {
                        for (int i_270_ = 0; i_270_ < 5; i_270_++)
                            phys[i_270_] = (int) (Math.random() * 100.0);
                    }
                    if (i == 9) {
                        for (int i_271_ = 0; i_271_ < 5; i_271_++)
                            phys[i_271_] = rphys[i_271_];
                    }
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
                    if (i == 12) {
                        for (int i_273_ = 0; i_273_ < 6; i_273_++)
                            phys[i_273_ + 5] = (int) (Math.random() * 100.0);
                    }
                    if (i == 13) {
                        for (int i_274_ = 0; i_274_ < 6; i_274_++)
                            phys[i_274_ + 5] = rphys[i_274_ + 5];
                    }
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
                        int[] is = { -101, -101, -101, -101 };
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
                                if (Math.random() > Math.random()) {
                                    if (bool_277_)
                                        is[3] = is[2] + 1;
                                    else
                                        is[3] = is[2] - 1;
                                }
                            }
                        }
                        if (Math.random() > Math.random())
                            crashup = false;
                        else
                            crashup = true;
                        for (int i_278_ = 0; i_278_ < 4; i_278_++) {
                            if (is[i_278_] != -101) {
                                if (is[i_278_] >= 4)
                                    is[i_278_] -= 4;
                                if (is[i_278_] <= -1)
                                    is[i_278_] += 4;
                                i_276_ -= 50 * i_278_;
                                if (i_276_ < 150)
                                    i_276_ = 150;
                                if (bool)
                                    regx(is[i_278_], (float) i_276_, false);
                                else
                                    regz(is[i_278_], (float) i_276_, false);
                            }
                        }
                        if (hitmag < 17000) {
                            if (crashleft)
                                (o).xz += 22;
                            else
                                (o).xz -= 22;
                        }
                    }
                    if (i == 8) {
                        if (Math.random() > Math.random())
                            crashup = false;
                        else
                            crashup = true;
                        roofsqsh((float) (int) (230.0 + Math.random() * 80.0));
                    }
                    if (i == 9 || i == 7) {
                        setupo();
                        if (Math.random() > Math.random())
                            crashleft = false;
                        else
                            crashleft = true;
                    }
                    if (i == 10) {
                        for (int i_279_ = 0; i_279_ < 3; i_279_++)
                            crash[i_279_] = rcrash[i_279_];
                    }
                    if (i == 11) {
                        setupo();
                        pfase = 1;
                        i = -1;
                    }
                    if (i == 12) {
                        //if (crashok) {
                            setupo();
                            pfase = 3;
                            i = -1;
                        //} else
                        //    JOptionPane.showMessageDialog(null, usage[11], "Car Maker", 1);
                    }
                    i_206_ = 13;
                }
                if (pfase == 3) {
                    for (int i_280_ = 0; i_280_ < 5; i_280_++) {
                        if (i == i_280_) {
                            for (int i_281_ = 0; i_281_ < 5; i_281_++) {
                                for (int i_282_ = 0; i_282_ < 5; i_282_++)
                                    engs[i_282_][i_281_].stop();
                            }
                            engs[engsel][i_280_].loop();
                            engon = true;
                        }
                        if (i == 5) {
                            for (int i_283_ = 0; i_283_ < 5; i_283_++) {
                                for (int i_284_ = 0; i_284_ < 5; i_284_++)
                                    engs[i_284_][i_283_].stop();
                            }
                            engon = false;
                        }
                        if (i == 6) {
                            pfase = 2;
                            i = -1;
                            engine.hide();
                        }
                        if (i == 7) {
                            pfase = 4;
                            i = -1;
                            engine.hide();
                        }
                    }
                    i_206_ = 8;
                }
            }
            if (dtab == 6) {
                if (!rateh) {
                    if (i == 0 && checko("Test Drive")) {
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
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        String string_285_ = "";
                        int i_286_ = 0;
                        int i_287_ = string.indexOf("\n", 0);
                        while (i_287_ != -1 && i_286_ < string.length()) {
                            String string_288_ = string.substring(i_286_, i_287_);
                            string_288_ = string_288_.trim();
                            i_286_ = i_287_ + 1;
                            i_287_ = string.indexOf("\n", i_286_);
                            if (!string_288_.startsWith("handling("))
                                string_285_ = new StringBuilder().append(string_285_).append("").append(string_288_).append("\n").toString();
                            else {
                                string_285_ = string_285_.trim();
                                string_285_ = new StringBuilder().append(string_285_).append("\n").toString();
                            }
                        }
                        string_285_ = string_285_.trim();
                        string_285_ = new StringBuilder().append(string_285_).append("\n\n\nhandling(").append(handling).append(")\n\n\n\n").toString();
                        editor.setText(string_285_);
                        savefile();
                        rateh = false;
                    }
                    if (i == 3)
                        rateh = false;
                    i_206_ = 4;
                }
            }
            if (i == i_206_) {
                for (int i_289_ = 0; i_289_ < (o).npl; i_289_++) {
                    Color.RGBtoHSB(((o).p[i_289_]).c[0], ((o).p[i_289_]).c[1], ((o).p[i_289_]).c[2], ((o).p[i_289_]).hsb);
                    if (((o).p[i_289_]).gr == -13)
                        ((o).p[i_289_]).gr = 1;
                }
                polynum = -1;
            }
            i = -1;
        }
        if (tab == 3) {
            if (i == 0) {
                if (logged == 0)
                    JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Car Maker", 1);
                if ((logged == 3 || logged == -1) && checko("Publishing")) {
                    int i_290_ = 0;
                    for (int i_291_ = 0; i_291_ < nmc; i_291_++) {
                        if (mycars[i_291_].equals(carname) && maker[i_291_].equals(tnick.getText()))
                            i_290_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Replace your already online car '").append(carname).append("' with this one?").toString(), "Car Maker", 0);
                    }
                    if (i_290_ == 0) {
                        setCursor(new Cursor(3));
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(225, 225, 225));
                        rd.fillRect(11, 141, 679, 401);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("Connecting to Server...", 350 - ftm.stringWidth("Connecting to Server...") / 2, 250);
                        repaint();
                        int i_292_ = 0;
                        String string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                        int i_293_ = 0;
                        int i_294_ = string.indexOf("\n", 0);
                        while (i_294_ != -1 && i_293_ < string.length()) {
                            i_293_ = i_294_ + 1;
                            i_294_ = string.indexOf("\n", i_293_);
                            i_292_++;
                        }
                        int i_295_ = -1;
                        try {
                            Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                            printwriter.println(new StringBuilder().append("10|").append(tnick.getText()).append("|").append(tpass.getText()).append("|").append(carname).append("|").append(pubtyp.getSelectedIndex()).append("|").toString());
                            String string_296_ = bufferedreader.readLine();
                            if (string_296_ != null)
                                i_295_ = 0;
                            	//i_295_ = servervalue(string_296_, 0);
                            if (i_295_ == 0) {
                                int i_297_ = 0;
                                string = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
                                i_293_ = 0;
                                i_294_ = string.indexOf("\n", 0);
                                while (i_294_ != -1 && i_293_ < string.length()) {
                                    String string_298_ = string.substring(i_293_, i_294_);
                                    string_298_ = string_298_.trim();
                                    printwriter.println(string_298_);
                                    i_293_ = i_294_ + 1;
                                    i_294_ = string.indexOf("\n", i_293_);
                                    i_297_++;
                                    rd.setColor(new Color(225, 225, 225));
                                    rd.fillRect(11, 141, 679, 401);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("Publishing Car...", 350 - ftm.stringWidth("Publishing Car...") / 2, 250);
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
                                    } catch (InterruptedException interruptedexception) {
                                        /* empty */
                                    }
                                }
                                printwriter.println("QUITX1111");
                                rd.setColor(new Color(225, 225, 225));
                                rd.fillRect(11, 141, 679, 401);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString("Creating the car online...", 350 - ftm.stringWidth("Creating the car online...") / 2, 250);
                                rd.drawString("This may take a couple of minutes, please wait...", 350 - ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                                repaint();
                                string_296_ = bufferedreader.readLine();
                                if (string_296_ != null)
                                    i_295_ = servervalue(string_296_, 0);
                            }
                            socket.close();
                        } catch (Exception exception) {
                            i_295_ = -1;
                        }
                        setCursor(new Cursor(0));
                        boolean bool = false;
                        if (i_295_ == 0) {
                            logged = 1;
                            bool = true;
                        }
                        if (i_295_ == 3) {
                            JOptionPane.showMessageDialog(null, "Unable to publish car.\nReason:\nCar name is too large.  Please rename your car.  Car name must be less then 15 characters.", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 4) {
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to publish car.\nReason:  Car name used (").append(carname).append(").\nThe name '").append(carname).append("' is already used by another published car.  Please rename your car.").toString(), "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 6) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nError loading 3D model!  Format maybe incorrect!", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 7) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 8) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 9) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the \u2018Car\u2019 tab to find the tutorial on how to build a car.", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 10) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 10000.\nPlease use the counter in the \u2018Code Edit\u2019 to decrease the number of polygons (pieces).", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 11) {
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error Creating Car!\nReason:\nCar scale size is too large!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled down by ").append((int) (((float) (o).maxR / 400.0F - 1.0F) * 100.0F)).append("%.\n").toString(), "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 12) {
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error Creating Car!\nReason:\nCar scale size is too small!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled up by ").append((int) ((120.0F / (float) (o).maxR - 1.0F) * 100.0F)).append("%.\n").toString(), "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 13) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 14) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 15) {
                            JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ > 15) {
                            JOptionPane.showMessageDialog(null, "Unable to publish car fully!  Unknown Error.  Please try again later.\n", "Car Maker", 1);
                            bool = true;
                        }
                        if (!bool)
                            JOptionPane.showMessageDialog(null, "Unable to publish car!  Unknown Error.\n", "Car Maker", 1);
                    }
                }
            }
            if (logged == 0) {
                if (i == 1) {
                    setCursor(new Cursor(3));
                    int i_299_ = -1;
                    try {
                        Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                        printwriter.println(new StringBuilder().append("1|").append(tnick.getText().toLowerCase()).append("|").append(tpass.getText()).append("|").toString());
                        String string = bufferedreader.readLine();
                        if (string != null)
                            i_299_ = servervalue(string, 0);
                        socket.close();
                    } catch (Exception exception) {
                        i_299_ = -1;
                    }
                    if (i_299_ == 0 || i_299_ == 3 || i_299_ > 10) {
                        tnick.hide();
                        tpass.hide();
                        logged = 1;
                        savesettings();
                    }
                    if (i_299_ == 1 || i_299_ == 2) {
                        setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Car Maker", 0);
                    }
                    if (i_299_ == -167) {
                        setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Sorry.  Trial accounts are not allowed to publish cars & stages, please register a full account!", "Car Maker", 0);
                    }
                    if (i_299_ == -1) {
                        setCursor(new Cursor(0));
                        JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1);
                    }
                }
                if (i == 2)
                    Madness.openurl("http://multiplayer.needformadness.com/register.html");
            }
        }
    }
    
    public void setupo() {
        o = new ContO(editor.getText().getBytes(), m, t);
        (o).x = ox;
        (o).y = oy;
        (o).z = oz;
        (o).xz = oxz;
        (o).xy = oxy;
        (o).zy = ozy;
        (o).shadow = true;
        (o).tnt = 0;
        (o).disp = 0;
        (o).disline = 7;
        (o).grounded = 1.0F;
        (o).noline = false;
        (o).decor = false;
        if ((o).errd && (!(o).err.startsWith("Wheels Error:") || forwheels))
            JOptionPane.showMessageDialog(null, (o).err, "Car Maker", 0);
        if ((o).maxR == 0)
            (o).maxR = 100;
        squash = 0;
        hitmag = 0;
    }
    
    public void loadfile() {
        loadedfile = false;
        lastedo = "";
        try {
            File file = new File(new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
            BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
            String string;
            while ((string = bufferedreader.readLine()) != null) {
                StringBuilder stringbuilder = new StringBuilder();
                CarMaker carmaker_300_ = this;
                (carmaker_300_).lastedo = stringbuilder.append((carmaker_300_).lastedo).append("").append(string).append("\n").toString();
            }
            loadedfile = true;
            bufferedreader.close();
        } catch (Exception exception) {
            loadedfile = false;
            lastedo = "";
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to load file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
        }
        editor.setText(lastedo);
    }
    
    public void savefile() {
        if (!editor.getText().equals("")) {
            try {
                File file = new File("mycars/");
                if (!file.exists())
                    file.mkdirs();
                file = new File(new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
                BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(editor.getText());
                bufferedwriter.close();
                changed = false;
                lastedo = editor.getText();
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to save file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
            }
        }
        savesettings();
    }
    
    public void newcar(String string) {
        if (string.equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter a Car Name!\n", "Car Maker", 1);
        else {
            String string_302_ = new StringBuilder().append("\n// car: ").append(string).append("\n---------------------\n\n// To start making you car you must start by reading the tutorial at:\n// http://www.needformadness.com/developer/simplecar.html\n\n\n<p>\nc(100,200,100)\n\np(-40,-50,80)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-50,80)\n</p>\n\n<p>\nc(100,150,200)\n\np(-40,-20,-100)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-20,-100)\n</p>\n\n\n\n").toString();
            try {
                File file = new File("mycars/");
                if (!file.exists())
                    file.mkdirs();
                carname = string;
                file = new File(new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
                if (!file.exists()) {
                    BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                    bufferedwriter.write(string_302_);
                    bufferedwriter.close();
                    if (file.exists()) {
                        sfase = 0;
                        hidefields();
                        tabed = -1;
                    } else
                        JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
                } else
                    JOptionPane.showMessageDialog(null, new StringBuilder().append("A car with the name '").append(carname).append("' already exists, please choose another name!\n").toString(), "Car Maker", 1);
            } catch (Exception exception) {
                carname = "";
                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to create file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
            }
        }
    }
    
    public void delcar(String string) {
        if (string.equals(""))
            JOptionPane.showMessageDialog(null, "Please Select a Car to Delete!\n", "Car Maker", 1);
        else {
            int i = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Are you sure you want to delete car :  ").append(string).append(" ?  ").toString(), "Car Maker", 0);
            if (i == 0) {
                try {
                    File file = new File(new StringBuilder().append("mycars/").append(string).append(".rad").toString());
                    file.delete();
                    slcar.remove(string);
                    slcar.select(0);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to delete file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
                }
            }
        }
    }
    
    public void rencar(String string) {
        if (string.equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter a New Car Name!\n", "Car Maker", 1);
        else {
            try {
                File file = new File(new StringBuilder().append("mycars/").append(carname).append(".rad").toString());
                File file_303_ = new File(new StringBuilder().append("mycars/").append(string).append(".rad").toString());
                if (file.renameTo(file_303_)) {
                    carname = string;
                    sfase = 0;
                    hidefields();
                    tabed = -1;
                } else
                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to rename car to: '").append(string).append("', possible reason: Car name already used!\n").toString(), "Car Maker", 1);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to rename file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
            }
        }
    }
    
    public void loadsettings() {
        try {
            File file = new File("mycars/settings.data");
            if (file.exists()) {
                BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
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
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void savesettings() {
        if (!scar.equals(carname) || !suser.equals(tnick.getText()) || !sfont.equals(cfont) || cthm != sthm) {
            String string = new StringBuilder().append("").append(carname).append("\n").append(tnick.getText()).append("\n").append(cfont).append("\n").append(cthm).append("\n\n").toString();
            scar = carname;
            suser = tnick.getText();
            sfont = cfont;
            sthm = cthm;
            try {
                File file = new File("mycars/");
                if (!file.exists())
                    file.mkdirs();
                file = new File("mycars/settings.data");
                BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(string);
                bufferedwriter.close();
            } catch (Exception exception) {
                /* empty */
            }
        }
    }
    
    public boolean checko(String string) {
        loadfile();
        setupo();
        if ((o).colok < 2) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.\n").toString(), "Car Maker", 1);
            return false;
        }
        /*boolean bool = true;
        if ((o).keyz[0] <= 0 || (o).keyx[0] >= 0)
            bool = false;
        if ((o).keyz[1] <= 0 || (o).keyx[1] <= 0)
            bool = false;
        if ((o).keyz[2] >= 0 || (o).keyx[2] >= 0)
            bool = false;
        if ((o).keyz[3] >= 0 || (o).keyx[3] <= 0)
            bool = false;
        if (!bool) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n").toString(), "Car Maker", 1);
            return false;
        }*/
        if ((o).npl <= 0) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the \u2018Car\u2019 tab to find the tutorial on how to build a car.\n").toString(), "Car Maker", 1);
            return false;
        }
        if ((o).npl > 10000) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 10000.\nPlease use the counter in the \u2018Code Edit\u2019 to decrease the number of polygons (pieces).\n").toString(), "Car Maker", 1);
            return false;
        }
        if ((o).maxR > 40000) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar scale size is too large!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled down by ").append((int) (((float) (o).maxR / 400.0F - 1.0F) * 100.0F)).append("%.\n").toString(), "Car Maker", 1);
            return false;
        }
        if ((o).maxR < 2) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar scale size is too small!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled up by ").append((int) ((120.0F / (float) (o).maxR - 1.0F) * 100.0F)).append("%.\n").toString(), "Car Maker", 1);
            return false;
        }
        String string_304_ = new StringBuilder().append("").append(editor.getText()).append("\n").toString();
        int i = 0;
        int i_305_ = string_304_.indexOf("\n", 0);
        boolean bool_306_ = false;
        boolean bool_307_ = false;
        boolean bool_308_ = false;
        while (i_305_ != -1 && i < string_304_.length()) {
            String string_309_ = string_304_.substring(i, i_305_);
            string_309_ = string_309_.trim();
            i = i_305_ + 1;
            i_305_ = string_304_.indexOf("\n", i);
            if (string_309_.startsWith("stat(")) {
                bool_306_ = true;
                try {
                    int i_310_ = 0;
                    for (int i_311_ = 0; i_311_ < 5; i_311_++) {
                        stat[i_311_] = getvalue("stat", string_309_, i_311_);
                        if (stat[i_311_] > 200)
                            bool_306_ = false;
                        if (stat[i_311_] < 16)
                            bool_306_ = false;
                        i_310_ += stat[i_311_];
                    }
                    if (i_310_ != 680 && i_310_ != 640 && i_310_ != 600 && i_310_ != 560 && i_310_ != 520)
                        bool_306_ = false;
                } catch (Exception exception) {
                    bool_306_ = false;
                }
            }
            if (string_309_.startsWith("physics(")) {
                bool_307_ = true;
                try {
                    for (int i_312_ = 0; i_312_ < 11; i_312_++) {
                        phys[i_312_] = getvalue("physics", string_309_, i_312_);
                        //if (phys[i_312_] > 100)
                        //    bool_307_ = false;
                        //if (phys[i_312_] < 0)
                        //    bool_307_ = false;
                    }
                    for (int i_313_ = 0; i_313_ < 3; i_313_++) {
                        crash[i_313_] = getvalue("physics", string_309_, i_313_ + 11);
                        //if (i_313_ != 0 && crash[i_313_] > 100)
                        //    bool_307_ = false;
                        //if (crash[i_313_] < 0)
                        //    bool_307_ = false;
                    }
                    engsel = getvalue("physics", string_309_, 14);
                    if (engsel > 4)
                        bool_307_ = false;
                    if (engsel < 0)
                        bool_307_ = false;
                } catch (Exception exception) {
                    bool_307_ = false;
                }
            }
            if (string_309_.startsWith("handling(")) {
                bool_308_ = true;
                try {
                    getvalue("handling", string_309_, 0);
                } catch (Exception exception) {
                    bool_308_ = false;
                }
            }
        }
        if (!bool_306_) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n").toString(), "Car Maker", 1);
            return false;
        }
        if (!bool_307_) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n").toString(), "Car Maker", 1);
            return false;
        }
        if (!bool_308_ && string.equals("Publishing")) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n").toString(), "Car Maker", 1);
            return false;
        }
        return true;
    }
    
    public void regx(int i, float f, boolean bool) {
        hitmag += f;
        if (!bool)
            crash(f);
        f *= 0.3F + (float) crash[1] * 0.005F;
        if (Math.abs(f) > 100.0F) {
            int i_315_ = (int) ((double) (crash[0] * crash[0]) * 1.5);
            if (i_315_ < 1000)
                i_315_ = 1000;
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            for (int i_316_ = 0; i_316_ < (o).npl; i_316_++) {
                float f_317_ = 0.0F;
                for (int i_318_ = 0; i_318_ < ((o).p[i_316_]).n; i_318_++) {
                    if (((o).p[i_316_]).wz == 0 && py((o).keyx[i], ((o).p[i_316_]).ox[i_318_], (o).keyz[i], ((o).p[i_316_]).oz[i_318_]) < i_315_) {
                        f_317_ = f / 20.0F * m.random();
                        ((o).p[i_316_]).oz[i_318_] -= f_317_ * m.sin((o).xz) * m.cos((o).zy);
                        ((o).p[i_316_]).ox[i_318_] += f_317_ * m.cos((o).xz) * m.cos((o).xy);
                        if (bool)
                            actmag += Math.abs(f_317_);
                    }
                }
                if (f_317_ != 0.0F) {
                    if (Math.abs(f_317_) >= 1.0F) {
                        ((o).p[i_316_]).chip = 1;
                        ((o).p[i_316_]).ctmag = f_317_;
                    }
                    if (!((o).p[i_316_]).nocol && ((o).p[i_316_]).glass != 1) {
                        if (((o).p[i_316_]).bfase > 20 && (double) ((o).p[i_316_]).hsb[1] > 0.25)
                            ((o).p[i_316_]).hsb[1] = 0.25F;
                        if (((o).p[i_316_]).bfase > 25 && (double) ((o).p[i_316_]).hsb[2] > 0.7)
                            ((o).p[i_316_]).hsb[2] = 0.7F;
                        if (((o).p[i_316_]).bfase > 30 && (double) ((o).p[i_316_]).hsb[1] > 0.15)
                            ((o).p[i_316_]).hsb[1] = 0.15F;
                        if (((o).p[i_316_]).bfase > 35 && (double) ((o).p[i_316_]).hsb[2] > 0.6)
                            ((o).p[i_316_]).hsb[2] = 0.6F;
                        if (((o).p[i_316_]).bfase > 40)
                            ((o).p[i_316_]).hsb[0] = 0.075F;
                        if (((o).p[i_316_]).bfase > 50 && (double) ((o).p[i_316_]).hsb[2] > 0.5)
                            ((o).p[i_316_]).hsb[2] = 0.5F;
                        if (((o).p[i_316_]).bfase > 60)
                            ((o).p[i_316_]).hsb[0] = 0.05F;
                        ((o).p[i_316_]).bfase += Math.abs(f_317_);
                        new Color(((o).p[i_316_]).c[0], ((o).p[i_316_]).c[1], ((o).p[i_316_]).c[2]);
                        Color color = Color.getHSBColor(((o).p[i_316_]).hsb[0], ((o).p[i_316_]).hsb[1], ((o).p[i_316_]).hsb[2]);
                        ((o).p[i_316_]).c[0] = color.getRed();
                        ((o).p[i_316_]).c[1] = color.getGreen();
                        ((o).p[i_316_]).c[2] = color.getBlue();
                    }
                    if (((o).p[i_316_]).glass == 1)
                        ((o).p[i_316_]).gr += Math.abs((double) f_317_ * 1.5);
                }
            }
        }
    }
    
    public void regz(int i, float f, boolean bool) {
        hitmag += f;
        if (!bool)
            crash(f);
        f *= 0.3F + (float) crash[1] * 0.005F;
        if (Math.abs(f) > 100.0F) {
            int i_319_ = (int) ((double) (crash[0] * crash[0]) * 1.5);
            if (i_319_ < 1000)
                i_319_ = 1000;
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            for (int i_320_ = 0; i_320_ < (o).npl; i_320_++) {
                float f_321_ = 0.0F;
                for (int i_322_ = 0; i_322_ < ((o).p[i_320_]).n; i_322_++) {
                    if (((o).p[i_320_]).wz == 0 && py((o).keyx[i], ((o).p[i_320_]).ox[i_322_], (o).keyz[i], ((o).p[i_320_]).oz[i_322_]) < i_319_) {
                        f_321_ = f / 20.0F * m.random();
                        ((o).p[i_320_]).oz[i_322_] += f_321_ * m.cos((o).xz) * m.cos((o).zy);
                        ((o).p[i_320_]).ox[i_322_] += f_321_ * m.sin((o).xz) * m.cos((o).xy);
                        if (bool)
                            actmag += Math.abs(f_321_);
                    }
                }
                if (f_321_ != 0.0F) {
                    if (Math.abs(f_321_) >= 1.0F) {
                        ((o).p[i_320_]).chip = 1;
                        ((o).p[i_320_]).ctmag = f_321_;
                    }
                    if (!((o).p[i_320_]).nocol && ((o).p[i_320_]).glass != 1) {
                        if (((o).p[i_320_]).bfase > 20 && (double) ((o).p[i_320_]).hsb[1] > 0.25)
                            ((o).p[i_320_]).hsb[1] = 0.25F;
                        if (((o).p[i_320_]).bfase > 25 && (double) ((o).p[i_320_]).hsb[2] > 0.7)
                            ((o).p[i_320_]).hsb[2] = 0.7F;
                        if (((o).p[i_320_]).bfase > 30 && (double) ((o).p[i_320_]).hsb[1] > 0.15)
                            ((o).p[i_320_]).hsb[1] = 0.15F;
                        if (((o).p[i_320_]).bfase > 35 && (double) ((o).p[i_320_]).hsb[2] > 0.6)
                            ((o).p[i_320_]).hsb[2] = 0.6F;
                        if (((o).p[i_320_]).bfase > 40)
                            ((o).p[i_320_]).hsb[0] = 0.075F;
                        if (((o).p[i_320_]).bfase > 50 && (double) ((o).p[i_320_]).hsb[2] > 0.5)
                            ((o).p[i_320_]).hsb[2] = 0.5F;
                        if (((o).p[i_320_]).bfase > 60)
                            ((o).p[i_320_]).hsb[0] = 0.05F;
                        ((o).p[i_320_]).bfase += Math.abs(f_321_);
                        new Color(((o).p[i_320_]).c[0], ((o).p[i_320_]).c[1], ((o).p[i_320_]).c[2]);
                        Color color = Color.getHSBColor(((o).p[i_320_]).hsb[0], ((o).p[i_320_]).hsb[1], ((o).p[i_320_]).hsb[2]);
                        ((o).p[i_320_]).c[0] = color.getRed();
                        ((o).p[i_320_]).c[1] = color.getGreen();
                        ((o).p[i_320_]).c[2] = color.getBlue();
                    }
                    if (((o).p[i_320_]).glass == 1)
                        ((o).p[i_320_]).gr += Math.abs((double) f_321_ * 1.5);
                }
            }
        }
    }
    
    public void roofsqsh(float f) {
        if (f > 100.0F) {
            crash(f);
            f -= 100.0F;
            int i = (int) (2.0 + (double) (float) crash[2] / 7.6);
            int i_323_ = 0;
            int i_324_ = 1;
            for (int i_325_ = 0; i_325_ < (o).npl; i_325_++) {
                float f_326_ = 0.0F;
                if (Math.random() > 0.9)
                    f_326_ = f / 15.0F * m.random();
                for (int i_327_ = 0; i_327_ < ((o).p[i_325_]).n; i_327_++) {
                    if (((o).p[i_325_]).wz == 0 && (Math.abs(((o).p[i_325_]).oy[i_327_] - (o).roofat - squash) < i * 3 || ((o).p[i_325_]).oy[i_327_] < (o).roofat + squash) && squash < i) {
                        f_326_ = f / 15.0F * m.random();
                        ((o).p[i_325_]).oy[i_327_] += f_326_;
                        i_323_ += f_326_;
                        i_324_++;
                        hitmag += Math.abs(f_326_);
                    }
                }
                if (!((o).p[i_325_]).nocol && ((o).p[i_325_]).glass != 1) {
                    if (f_326_ != 0.0F) {
                        if (((o).p[i_325_]).bfase > 20 && (double) ((o).p[i_325_]).hsb[1] > 0.25)
                            ((o).p[i_325_]).hsb[1] = 0.25F;
                        if (((o).p[i_325_]).bfase > 25 && (double) ((o).p[i_325_]).hsb[2] > 0.7)
                            ((o).p[i_325_]).hsb[2] = 0.7F;
                        if (((o).p[i_325_]).bfase > 30 && (double) ((o).p[i_325_]).hsb[1] > 0.15)
                            ((o).p[i_325_]).hsb[1] = 0.15F;
                        if (((o).p[i_325_]).bfase > 35 && (double) ((o).p[i_325_]).hsb[2] > 0.6)
                            ((o).p[i_325_]).hsb[2] = 0.6F;
                        if (((o).p[i_325_]).bfase > 40)
                            ((o).p[i_325_]).hsb[0] = 0.075F;
                        if (((o).p[i_325_]).bfase > 50 && (double) ((o).p[i_325_]).hsb[2] > 0.5)
                            ((o).p[i_325_]).hsb[2] = 0.5F;
                        if (((o).p[i_325_]).bfase > 60)
                            ((o).p[i_325_]).hsb[0] = 0.05F;
                        ((o).p[i_325_]).bfase += f_326_;
                        new Color(((o).p[i_325_]).c[0], ((o).p[i_325_]).c[1], ((o).p[i_325_]).c[2]);
                        Color color = Color.getHSBColor(((o).p[i_325_]).hsb[0], ((o).p[i_325_]).hsb[1], ((o).p[i_325_]).hsb[2]);
                        ((o).p[i_325_]).c[0] = color.getRed();
                        ((o).p[i_325_]).c[1] = color.getGreen();
                        ((o).p[i_325_]).c[2] = color.getBlue();
                    }
                } else if (((o).p[i_325_]).glass == 1)
                    ((o).p[i_325_]).gr += 5;
                if (Math.abs(f_326_) >= 1.0F) {
                    ((o).p[i_325_]).chip = 1;
                    ((o).p[i_325_]).ctmag = f_326_;
                }
            }
            squash += i_323_ / i_324_;
        }
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
    
    public int py(int i, int i_328_, int i_329_, int i_330_) {
        return (i - i_328_) * (i - i_328_) + (i_329_ - i_330_) * (i_329_ - i_330_);
    }
    
    public void rot(int[] is, int[] is_331_, int i, int i_332_, int i_333_, int i_334_) {
        if (i_333_ != 0) {
            for (int i_335_ = 0; i_335_ < i_334_; i_335_++) {
                int i_336_ = is[i_335_];
                int i_337_ = is_331_[i_335_];
                is[i_335_] = i + (int) ((float) (i_336_ - i) * m.cos(i_333_) - (float) (i_337_ - i_332_) * m.sin(i_333_));
                is_331_[i_335_] = i_332_ + (int) ((float) (i_336_ - i) * m.sin(i_333_) + (float) (i_337_ - i_332_) * m.cos(i_333_));
            }
        }
    }
    
    public int xs(int i, int i_338_) {
        if (i_338_ < (m).cz)
            i_338_ = (m).cz;
        return (i_338_ - (m).focus_point) * ((m).cx - i) / i_338_ + i;
    }
    
    public int ys(int i, int i_339_) {
        if (i_339_ < (m).cz)
            i_339_ = (m).cz;
        return (i_339_ - (m).focus_point) * ((m).cy - i) / i_339_ + i;
    }
    
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
        MenuItem menuitem = new MenuItem("Cut");
        MenuItem menuitem_340_ = new MenuItem("Copy");
        MenuItem menuitem_341_ = new MenuItem("Paste");
        MenuItem menuitem_342_ = new MenuItem("Select All");
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
    
    public void hidefields() {
        pubtyp.hide();
        tpass.hide();
        tnick.hide();
        slcar.hide();
        witho.hide();
        for (int i = 0; i < 16; i++)
            wv[i].hide();
        simcar.hide();
        engine.hide();
        cls.hide();
        compcar.hide();
        editor.hide();
        fontsel.hide();
        ctheme.hide();
        srch.hide();
        rplc.hide();
    }
    
    public void movefield(Component component, int i, int i_343_, int i_344_, int i_345_) {
        i += apx;
        i_343_ += apy;
        if (component.getX() != i || component.getY() != i_343_ || component.getWidth() != i_344_ || component.getHeight() != i_345_)
            component.setBounds(i, i_343_, i_344_, i_345_);
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
    
    public void openlink() {
        Madness.openurl("http://www.needformadness.com/developer/simplecar.html");
    }
    
    public void openhlink() {
        Madness.openurl("http://www.needformadness.com/developer/");
    }
    
    public void openelink() {
        Madness.openurl("http://www.needformadness.com/developer/extras.html");
    }
    
    public void start() {
        if (thredo == null)
            thredo = new Thread(this);
        thredo.start();
    }
    
    public void stop() {
        exwist = true;
    }
    
    public void paint(Graphics graphics) {
        apx = getWidth() / 2 - 350;
        apy = getHeight() / 2 - 275;
        graphics.drawImage(offImage, apx, apy, this);
    }
    
    public void update(Graphics graphics) {
        paint(graphics);
    }
    
    public boolean mouseUp(Event event, int i, int i_346_) {
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
    
    public boolean mouseDown(Event event, int i, int i_347_) {
        xm = i - apx;
        ym = i_347_ - apy;
        mouses = 1;
        mousdr = true;
        if (tab != 1)
            requestFocus();
        return false;
    }
    
    public boolean mouseMove(Event event, int i, int i_348_) {
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
    
    public boolean mouseDrag(Event event, int i, int i_349_) {
        mousdr = true;
        xm = i - apx;
        ym = i_349_ - apy;
        return false;
    }
    
    public boolean lostFocus(Event event, Object object) {
        focuson = false;
        return false;
    }
    
    public boolean gotFocus(Event event, Object object) {
        focuson = true;
        return false;
    }
    
    public boolean keyDown(Event event, int i) {
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
    
    public boolean keyUp(Event event, int i) {
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
    
    public void loadsounds() {
        try {
            File file = new File("data/sounds.zip");
            FileInputStream fileinputstream = new FileInputStream(file);
            ZipInputStream zipinputstream = new ZipInputStream(fileinputstream);
            for (ZipEntry zipentry = zipinputstream.getNextEntry(); zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = (int) zipentry.getSize();
                String string = zipentry.getName();
                byte[] is = new byte[i];
                int i_350_ = 0;
                int i_351_;
                for (/**/; i > 0; i -= i_351_) {
                    i_351_ = zipinputstream.read(is, i_350_, i);
                    i_350_ += i_351_;
                }
                for (int i_352_ = 0; i_352_ < 5; i_352_++) {
                    for (int i_353_ = 0; i_353_ < 5; i_353_++) {
                        if (string.equals(new StringBuilder().append("").append(i_353_).append("").append(i_352_).append(".wav").toString()))
                            engs[i_353_][i_352_] = new soundClip(is);
                    }
                }
                for (int i_354_ = 0; i_354_ < 3; i_354_++) {
                    if (string.equals(new StringBuilder().append("crash").append(i_354_ + 1).append(".wav").toString()))
                        crashs[i_354_] = new soundClip(is);
                }
                for (int i_355_ = 0; i_355_ < 3; i_355_++) {
                    if (string.equals(new StringBuilder().append("lowcrash").append(i_355_ + 1).append(".wav").toString()))
                        lowcrashs[i_355_] = new soundClip(is);
                }
            }
            fileinputstream.close();
            zipinputstream.close();
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Error Loading Sounds: ").append(exception).toString());
        }
        System.gc();
    }
    
    public void loadbase() {
        String[] strings = { "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster" };
        try {
            File file = new File("data/models.zip");
            ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));
            ZipEntry zipentry = zipinputstream.getNextEntry();
            for (/**/; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = -1;
                for (int i_356_ = 0; i_356_ < 16; i_356_++) {
                    if (zipentry.getName().startsWith(strings[i_356_]))
                        i = i_356_;
                }
                if (i != -1) {
                    int i_357_ = (int) zipentry.getSize();
                    byte[] is = new byte[i_357_];
                    int i_358_ = 0;
                    int i_359_;
                    for (/**/; i_357_ > 0; i_357_ -= i_359_) {
                        i_359_ = zipinputstream.read(is, i_358_, i_357_);
                        i_358_ += i_359_;
                    }
                    compo[i] = new ContO(is, m, t);
                    (compo[i]).shadow = false;
                    (compo[i]).noline = true;
                }
            }
            zipinputstream.close();
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Error Loading Models from Zip: ").append(exception).toString());
        }
        System.gc();
    }
    
    public void fixtext(TextField textfield) {
        String string = textfield.getText();
        string = string.replace('\"', '#');
        String string_360_ = "\\";
        String string_361_ = "";
        int i = 0;
        int i_362_ = -1;
        for (/**/; i < string.length(); i++) {
            String string_363_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            if (string_363_.equals("|") || string_363_.equals(",") || string_363_.equals("(") || string_363_.equals(")") || string_363_.equals("#") || string_363_.equals(string_360_) || string_363_.equals("!") || string_363_.equals("?") || string_363_.equals("~") || string_363_.equals(".") || string_363_.equals("@") || string_363_.equals("$") || string_363_.equals("%") || string_363_.equals("^") || string_363_.equals("&") || string_363_.equals("*") || string_363_.equals("+") || string_363_.equals("=") || string_363_.equals(">") || string_363_.equals("<") || string_363_.equals("/") || string_363_.equals("'") || string_363_.equals(";") || string_363_.equals(":") || i > 15)
                i_362_ = i;
            else
                string_361_ = new StringBuilder().append(string_361_).append(string_363_).toString();
        }
        if (i_362_ != -1) {
            textfield.setText(string_361_);
            textfield.select(i_362_, i_362_);
        }
    }
    
    public int getvalue(String string, String string_364_, int i) {
        int i_365_ = 0;
        String string_366_ = "";
        for (int i_367_ = string.length() + 1; i_367_ < string_364_.length(); i_367_++) {
            String string_368_ = new StringBuilder().append("").append(string_364_.charAt(i_367_)).toString();
            if (string_368_.equals(",") || string_368_.equals(")")) {
                i_365_++;
                i_367_++;
            }
            if (i_365_ == i)
                string_366_ = new StringBuilder().append(string_366_).append(string_364_.charAt(i_367_)).toString();
        }
        return Float.valueOf(string_366_).intValue();
    }
    
    public String getSvalue(String string, String string_369_, int i) {
        String string_370_ = "";
        int i_371_ = 0;
        for (int i_372_ = string.length() + 1; i_372_ < string_369_.length() && i_371_ <= i; i_372_++) {
            String string_373_ = new StringBuilder().append("").append(string_369_.charAt(i_372_)).toString();
            if (string_373_.equals(",") || string_373_.equals(")"))
                i_371_++;
            else if (i_371_ == i)
                string_370_ = new StringBuilder().append(string_370_).append(string_373_).toString();
        }
        return string_370_;
    }
    
    public int servervalue(String string, int i) {
        int i_374_ = -1;
        try {
            int i_375_ = 0;
            int i_376_ = 0;
            int i_377_ = 0;
            String string_378_ = "";
            String string_379_ = "";
            for (/**/; i_375_ < string.length() && i_377_ != 2; i_375_++) {
                string_378_ = new StringBuilder().append("").append(string.charAt(i_375_)).toString();
                if (string_378_.equals("|")) {
                    i_376_++;
                    if (i_377_ == 1 || i_376_ > i)
                        i_377_ = 2;
                } else if (i_376_ == i) {
                    string_379_ = new StringBuilder().append(string_379_).append(string_378_).toString();
                    i_377_ = 1;
                }
            }
            if (string_379_.equals(""))
                string_379_ = "-1";
            i_374_ = Integer.valueOf(string_379_).intValue();
        } catch (Exception exception) {
            /* empty */
        }
        return i_374_;
    }
    
    public String serverSvalue(String string, int i) {
        String string_380_ = "";
        try {
            int i_381_ = 0;
            int i_382_ = 0;
            int i_383_ = 0;
            String string_384_ = "";
            String string_385_ = "";
            for (/**/; i_381_ < string.length() && i_383_ != 2; i_381_++) {
                string_384_ = new StringBuilder().append("").append(string.charAt(i_381_)).toString();
                if (string_384_.equals("|")) {
                    i_382_++;
                    if (i_383_ == 1 || i_382_ > i)
                        i_383_ = 2;
                } else if (i_382_ == i) {
                    string_385_ = new StringBuilder().append(string_385_).append(string_384_).toString();
                    i_383_ = 1;
                }
            }
            string_380_ = string_385_;
        } catch (Exception exception) {
            /* empty */
        }
        return string_380_;
    }
    
    public int objvalue(String string, int i) {
        int i_386_ = 0;
        try {
            int i_387_ = 2;
            int i_388_ = 0;
            int i_389_ = 0;
            String string_390_ = "";
            String string_391_ = "";
            boolean bool = false;
            for (/**/; i_387_ < string.length() && i_389_ != 2; i_387_++) {
                string_390_ = new StringBuilder().append("").append(string.charAt(i_387_)).toString();
                if (string_390_.equals(" ")) {
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
            if (string_391_.equals(""))
                string_391_ = "0";
            if (multf10)
                i_386_ = (int) (Float.valueOf(string_391_).floatValue() * 10.0F);
            else {
                int i_392_ = string_391_.indexOf("/", 0);
                if (i_392_ != -1)
                    string_391_ = string_391_.substring(0, i_392_);
                i_386_ = Float.valueOf(string_391_).intValue() - 1;
                if (i_386_ < 0)
                    i_386_ = 0;
            }
        } catch (Exception exception) {
            /* empty */
        }
        return i_386_;
    }
    
    public Image getImage(String string) {
        Image image = Toolkit.getDefaultToolkit().createImage(string);
        MediaTracker mediatracker = new MediaTracker(this);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (Exception exception) {
            /* empty */
        }
        return image;
    }
    
    public void stringbutton(String string, int i, int i_393_, int i_394_, boolean bool) {
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        if (string.indexOf("Publish") != -1) {
            rd.setFont(new Font("Arial", 1, 13));
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
            rd.drawLine(i + bw[btn] / 2 + 10, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 10, i_393_ + (7 - i_394_));
            rd.drawLine(i + bw[btn] / 2 + 11, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 11, i_393_ + (7 - i_394_));
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i + bw[btn] / 2 + 12, i_393_ - (16 - i_394_), i + bw[btn] / 2 + 12, i_393_ + (6 - i_394_));
            if (bool)
                rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - bw[btn] / 2 - 10, i_393_ + (7 - i_394_), i + bw[btn] / 2 + 10, i_393_ + (7 - i_394_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_393_ + (8 - i_394_), i + bw[btn] / 2 + 10, i_393_ + (8 - i_394_));
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i - bw[btn] / 2 - 9, i_393_ + (9 - i_394_), i + bw[btn] / 2 + 9, i_393_ + (9 - i_394_));
            rd.setColor(new Color(240, 240, 240));
            if (bool)
                rd.setColor(new Color(255, 255, 255));
            rd.drawLine(i - bw[btn] / 2 - 10, i_393_ - (17 - i_394_), i - bw[btn] / 2 - 10, i_393_ + (7 - i_394_));
            rd.drawLine(i - bw[btn] / 2 - 11, i_393_ - (17 - i_394_), i - bw[btn] / 2 - 11, i_393_ + (7 - i_394_));
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - bw[btn] / 2 - 12, i_393_ - (16 - i_394_), i - bw[btn] / 2 - 12, i_393_ + (6 - i_394_));
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
            rd.drawLine(i + bw[btn] / 2 + 10, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 10, i_393_ + (7 - i_394_));
            rd.drawLine(i + bw[btn] / 2 + 11, i_393_ - (17 - i_394_), i + bw[btn] / 2 + 11, i_393_ + (7 - i_394_));
            rd.drawLine(i + bw[btn] / 2 + 12, i_393_ - (16 - i_394_), i + bw[btn] / 2 + 12, i_393_ + (6 - i_394_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_393_ + (7 - i_394_), i + bw[btn] / 2 + 10, i_393_ + (7 - i_394_));
            rd.drawLine(i - bw[btn] / 2 - 10, i_393_ + (8 - i_394_), i + bw[btn] / 2 + 10, i_393_ + (8 - i_394_));
            rd.drawLine(i - bw[btn] / 2 - 9, i_393_ + (9 - i_394_), i + bw[btn] / 2 + 9, i_393_ + (9 - i_394_));
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - bw[btn] / 2 - 10, i_393_ - (17 - i_394_), i - bw[btn] / 2 - 10, i_393_ + (7 - i_394_));
            rd.drawLine(i - bw[btn] / 2 - 11, i_393_ - (17 - i_394_), i - bw[btn] / 2 - 11, i_393_ + (7 - i_394_));
            rd.drawLine(i - bw[btn] / 2 - 12, i_393_ - (16 - i_394_), i - bw[btn] / 2 - 12, i_393_ + (6 - i_394_));
            rd.setColor(new Color(0, 0, 0));
            rd.drawString(string, i - bw[btn] / 2 + 1, i_393_ + 1);
        }
        btn++;
    }
    
    public boolean ovbutton(String string, int i, int i_395_) {
        rd.setFont(new Font("Arial", 0, 12));
        ftm = rd.getFontMetrics();
        if (string.equals("X") || string.equals("Download")) {
            rd.setFont(new Font("Arial", 1, 12));
            ftm = rd.getFontMetrics();
        }
        int i_396_ = ftm.stringWidth(string);
        int i_397_ = 4;
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
            rd.drawLine(i + i_396_ / 2 + 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ + (7 - i_397_));
            rd.drawLine(i + i_396_ / 2 + 11, i_395_ - (17 - i_397_), i + i_396_ / 2 + 11, i_395_ + (7 - i_397_));
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i + i_396_ / 2 + 12, i_395_ - (16 - i_397_), i + i_396_ / 2 + 12, i_395_ + (6 - i_397_));
            rd.drawLine(i - i_396_ / 2 - 10, i_395_ + (7 - i_397_), i + i_396_ / 2 + 10, i_395_ + (7 - i_397_));
            rd.drawLine(i - i_396_ / 2 - 10, i_395_ + (8 - i_397_), i + i_396_ / 2 + 10, i_395_ + (8 - i_397_));
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i - i_396_ / 2 - 9, i_395_ + (9 - i_397_), i + i_396_ / 2 + 9, i_395_ + (9 - i_397_));
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i - i_396_ / 2 - 10, i_395_ + (7 - i_397_));
            rd.drawLine(i - i_396_ / 2 - 11, i_395_ - (17 - i_397_), i - i_396_ / 2 - 11, i_395_ + (7 - i_397_));
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i_396_ / 2 - 12, i_395_ - (16 - i_397_), i - i_396_ / 2 - 12, i_395_ + (6 - i_397_));
            rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
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
            rd.drawLine(i + i_396_ / 2 + 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ + (7 - i_397_));
            rd.drawLine(i + i_396_ / 2 + 11, i_395_ - (17 - i_397_), i + i_396_ / 2 + 11, i_395_ + (7 - i_397_));
            rd.drawLine(i + i_396_ / 2 + 12, i_395_ - (16 - i_397_), i + i_396_ / 2 + 12, i_395_ + (6 - i_397_));
            rd.drawLine(i - i_396_ / 2 - 10, i_395_ + (7 - i_397_), i + i_396_ / 2 + 10, i_395_ + (7 - i_397_));
            rd.drawLine(i - i_396_ / 2 - 10, i_395_ + (8 - i_397_), i + i_396_ / 2 + 10, i_395_ + (8 - i_397_));
            rd.drawLine(i - i_396_ / 2 - 9, i_395_ + (9 - i_397_), i + i_396_ / 2 + 9, i_395_ + (9 - i_397_));
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i - i_396_ / 2 - 10, i_395_ + (7 - i_397_));
            rd.drawLine(i - i_396_ / 2 - 11, i_395_ - (17 - i_397_), i - i_396_ / 2 - 11, i_395_ + (7 - i_397_));
            rd.drawLine(i - i_396_ / 2 - 12, i_395_ - (16 - i_397_), i - i_396_ / 2 - 12, i_395_ + (6 - i_397_));
            rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                rd.setColor(new Color(0, 64, 128));
            rd.drawString(string, i - i_396_ / 2 + 1, i_395_ + 1);
        }
        return bool_398_;
    }
    
    public void actionPerformed(ActionEvent actionevent) {
        TextComponent textcomponent = wv[0];
        if (Madness.textid >= 0 && Madness.textid <= 15)
            textcomponent = wv[Madness.textid];
        if (Madness.textid == 16)
            textcomponent = srch;
        if (Madness.textid == 17)
            textcomponent = rplc;
        if (Madness.textid == 18)
            textcomponent = editor;
        String string = actionevent.getActionCommand();
        if (string.equals("Cut")) {
            StringSelection stringselection = new StringSelection(textcomponent.getSelectedText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
            if (Madness.textid == 18)
                editor.replaceText("", editor.getSelectionStart(), editor.getSelectionEnd());
            else
                textcomponent.setText(new StringBuilder().append(textcomponent.getText().substring(0, textcomponent.getSelectionStart())).append(textcomponent.getText().substring(textcomponent.getSelectionEnd(), textcomponent.getText().length())).toString());
        }
        if (string.equals("Copy")) {
            StringSelection stringselection = new StringSelection(textcomponent.getSelectedText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
        }
        if (string.equals("Paste")) {
            try {
                String string_399_ = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                if (Madness.textid == 18)
                    editor.replaceText(string_399_, editor.getSelectionStart(), editor.getSelectionEnd());
                else
                    textcomponent.setText(new StringBuilder().append(textcomponent.getText().substring(0, textcomponent.getSelectionStart())).append(string_399_).append(textcomponent.getText().substring(textcomponent.getSelectionEnd(), textcomponent.getText().length())).toString());
            } catch (Exception exception) {
                /* empty */
            }
        }
        if (string.equals("Select All"))
            textcomponent.selectAll();
    }
}
