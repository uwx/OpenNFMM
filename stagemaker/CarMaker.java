package stagemaker;

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
        this.thredo.setPriority(10);
        this.btgame[0] = getImage("data/backtogame1.gif");
        this.btgame[1] = getImage("data/backtogame2.gif");
        this.logo = getImage("data/carmakerlogo.gif");
        (this.m).w = 700;
        (this.m).cx = 350;
        (this.m).y = -240;
        (this.m).z = -400;
        (this.m).zy = 4;
        (this.m).focus_point = 800;
        this.m.fadfrom(8000);
        (this.m).cfade[0] = 187;
        (this.m).cfade[1] = 210;
        (this.m).cfade[2] = 227;
        loadsounds();
        loadbase();
        (this.m).loadnew = true;
        loadsettings();
        this.editor.setFont(new Font(this.cfont, 1, 14));
        this.srch.setFont(new Font(this.cfont, 1, 14));
        this.rplc.setFont(new Font(this.cfont, 1, 14));
        for (int i = 0; i < 16; i++)
            this.wv[i].setFont(new Font(this.cfont, 1, 14));
        setheme();
        if (Madness.testdrive != 0) {
            if (Madness.testcar.equals("Failx12")) {
                JOptionPane.showMessageDialog(null, "Failed to load car! Please make sure car is saved before Test Drive.", "Car Maker", 1);
                this.thredo.stop();
            } else {
                this.carname = Madness.testcar;
                loadfile();
                if (this.loadedfile) {
                    this.tested = true;
                    this.tab = 2;
                    this.dtab = 6;
                    this.witho.select(Madness.testdrive - 1);
                }
            }
            Madness.testcar = "";
            Madness.testdrive = 0;
        }
        boolean bool = false;
        if (!this.carname.equals("")) {
            this.tutok = true;
            bool = true;
        }
        while (!this.exwist) {
            if (this.tab != this.tabed) {
                hidefields();
                if (this.tab == 1)
                    this.editor.enable();
                else
                    this.editor.disable();
                if (this.tabed == 2) {
                    if (!this.breakbond) {
                        if (!this.editor.getText().equals(this.lastedo))
                            this.editor.setText(this.lastedo);
                    } else
                        this.breakbond = false;
                }
                setCursor(new Cursor(0));
            }
            this.rd.setColor(new Color(225, 225, 225));
            this.rd.fillRect(0, 0, 700, 550);
            this.rd.setColor(new Color(0, 0, 0));
            this.btn = 0;
            int i = 50;
            if (this.tab == 0) {
                if (this.tabed != this.tab) {
                    this.slcar.removeAll();
                    (this.slcar).maxl = 200;
                    this.slcar.add(this.rd, "Select a Car                      ");
                    String[] strings = new File("mycars/").list();
                    if (strings != null) {
                        for (int i_0_ = 0; i_0_ < strings.length; i_0_++) {
                            if (strings[i_0_].toLowerCase().endsWith(".rad"))
                                this.slcar.add(this.rd, strings[i_0_].substring(0, strings[i_0_].length() - 4));
                        }
                    }
                    if (this.carname.equals(""))
                        this.slcar.select(0);
                    else {
                        this.slcar.select(this.carname);
                        if (this.carname.equals(this.slcar.getSelectedItem()))
                            loadfile();
                    }
                    this.mouseon = -1;
                    this.srch.setText("");
                    this.sfase = 0;
                }
                this.rd.setFont(new Font("Arial", 1, 13));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawImage(this.logo, 214, 35, null);
                if (this.xm > 214 && this.xm < 485 && this.ym > 25 && this.ym < 104 && !this.openm) {
                    if (this.mouseon == -1) {
                        this.mouseon = 3;
                        setCursor(new Cursor(12));
                    }
                } else if (this.mouseon == 3) {
                    this.mouseon = -1;
                    setCursor(new Cursor(0));
                }
                if (this.mouseon == 3 && this.mouses == -1)
                    openhlink();
                int i_1_ = 30;
                int i_2_ = 0;
                if (this.tutok) {
                    i_1_ = 250;
                    i_2_ = -70;
                }
                if (this.xm > 76 && this.xm < 624 && this.ym > 84 + i_1_ && this.ym < 167 + i_1_ && !this.openm) {
                    if (this.mouseon == -1) {
                        this.mouseon = 1;
                        setCursor(new Cursor(12));
                    }
                } else if (this.mouseon == 1) {
                    this.mouseon = -1;
                    setCursor(new Cursor(0));
                }
                int i_3_ = 0;
                if (!this.tutok && this.mouseon != 1 && !bool) {
                    if (this.flk <= 0) {
                        this.rd.setColor(new Color(255, 0, 0));
                        this.flk--;
                        if (this.flk == -2)
                            this.flk = 1;
                    } else {
                        this.rd.setColor(new Color(0, 0, 255));
                        i_3_ = 2;
                        this.flk++;
                        if (this.flk == 3)
                            this.flk = 0;
                    }
                }
                this.rd.drawLine(76 + i_3_, 84 + i_1_, 76 + i_3_, 167 + i_1_);
                this.rd.drawLine(76 + i_3_, 84 + i_1_, 95 + i_3_, 84 + i_1_);
                this.rd.drawLine(76 + i_3_, 167 + i_1_, 95 + i_3_, 167 + i_1_);
                this.rd.drawLine(624 - i_3_, 84 + i_1_, 624 - i_3_, 167 + i_1_);
                this.rd.drawLine(624 - i_3_, 84 + i_1_, 605 - i_3_, 84 + i_1_);
                this.rd.drawLine(624 - i_3_, 167 + i_1_, 605 - i_3_, 167 + i_1_);
                if (this.mouseon == 1)
                    this.rd.setColor(new Color(0, 64, 128));
                else
                    this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("If this is your first time creating a car please follow the tutorial found at:", 106, 110 + i_1_);
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("http://www.needformadness.com/developer/simplecar.html", 106, 130 + i_1_);
                if (this.mouseon == 1)
                    this.rd.setColor(new Color(0, 128, 255));
                else
                    this.rd.setColor(new Color(0, 64, 128));
                this.rd.drawLine(106, 131 + i_1_, 480, 131 + i_1_);
                if (this.mouseon == 1)
                    this.rd.setColor(new Color(0, 64, 128));
                else
                    this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("It is highly recommended that you follow this tutorial before trying anything!", 106, 150 + i_1_);
                if (this.mouseon == 1 && this.mouses == -1) {
                    openlink();
                    bool = true;
                }
                if (this.xm > 200 && this.xm < 500 && this.ym > 467 && this.ym < 504 && !this.openm) {
                    if (this.mouseon == -1) {
                        this.mouseon = 2;
                        setCursor(new Cursor(12));
                    }
                } else if (this.mouseon == 2) {
                    this.mouseon = -1;
                    setCursor(new Cursor(0));
                }
                this.ftm = this.rd.getFontMetrics();
                if (this.mouseon == 2)
                    this.rd.setColor(new Color(0, 64, 128));
                else
                    this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("For the Car Maker Homepage, Development Center and Forums :", 350 - this.ftm.stringWidth("For the Car Maker Homepage, Development Center and Forums :") / 2, 480);
                this.rd.setColor(new Color(0, 128, 255));
                String string = "http://www.needformadness.com/developer/";
                this.rd.drawString(string, 350 - this.ftm.stringWidth(string) / 2, 500);
                if (this.mouseon == 2)
                    this.rd.setColor(new Color(0, 128, 255));
                else
                    this.rd.setColor(new Color(0, 64, 128));
                this.rd.drawLine(350 - this.ftm.stringWidth(string) / 2, 501, 350 + this.ftm.stringWidth(string) / 2, 501);
                if (this.mouseon == 2 && this.mouses == -1)
                    openhlink();
                int i_4_ = 0;
                if (this.sfase == 3)
                    i_4_ = 100;
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRect(177 - i_4_, 202 + i_2_, 346 + i_4_ * 2, 167 + i_4_ / 5);
                if (this.sfase == 0) {
                    this.rd.drawString("Select Car to Edit", 350 - this.ftm.stringWidth("Select Car to Edit") / 2, 230 + i_2_);
                    this.slcar.move(250, 240 + i_2_);
                    if (this.slcar.getWidth() != 200)
                        this.slcar.setSize(200, 21);
                    if (!this.slcar.isShowing())
                        this.slcar.show();
                    stringbutton("    Make new Car    ", 430, 296 + i_2_, 0, true);
                    stringbutton("     Rename Car     ", 270, 296 + i_2_, 0, false);
                    stringbutton("      Delete Car      ", 270, 336 + i_2_, 0, false);
                    stringbutton("     Import & Export     ", 430, 336 + i_2_, 0, false);
                    if (this.slcar.getSelectedIndex() != 0) {
                        if (!this.carname.equals(this.slcar.getSelectedItem())) {
                            this.tomany = false;
                            this.carname = this.slcar.getSelectedItem();
                            loadfile();
                            this.editor.select(0, 0);
                            this.tested = false;
                            requestFocus();
                        }
                    } else
                        this.carname = "";
                }
                if (this.sfase == 1) {
                    this.rd.drawString("Make a new Car", 350 - this.ftm.stringWidth("Make a new Car") / 2, 230 + i_2_);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("New car name :", 228, 266 + i_2_);
                    movefield(this.srch, 335, 250 + i_2_, 129, 22);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                        this.srch.requestFocus();
                    }
                    fixtext(this.srch);
                    stringbutton("    Make Car    ", 350, 306 + i_2_, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i_2_, 0, false);
                }
                if (this.sfase == 2) {
                    this.rd.drawString(new StringBuilder().append("Rename Car :  ").append(this.carname).append("").toString(), 350 - this.ftm.stringWidth(new StringBuilder().append("Rename Car :  ").append(this.carname).append("").toString()) / 2, 230 + i_2_);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("New name :", 239, 266 + i_2_);
                    movefield(this.srch, 316, 250 + i_2_, 129, 22);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                        this.srch.requestFocus();
                    }
                    fixtext(this.srch);
                    stringbutton("   Rename Car   ", 350, 306 + i_2_, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i_2_, 0, false);
                }
                if (this.sfase == 3) {
                    this.rd.drawString("Import a Wavefront OBJ 3D Model", 350 - this.ftm.stringWidth("Import a Wavefront OBJ 3D Model") / 2, 230 + i_2_);
                    if (this.xm > 116 && this.xm < 584 && this.ym > 246 + i_2_ && this.ym < 290 + i_2_) {
                        if (this.mouseon == -1) {
                            this.mouseon = 3;
                            setCursor(new Cursor(12));
                        }
                    } else if (this.mouseon == 3) {
                        this.mouseon = -1;
                        setCursor(new Cursor(0));
                    }
                    this.ftm = this.rd.getFontMetrics();
                    if (this.mouseon == 3)
                        this.rd.setColor(new Color(0, 64, 128));
                    else
                        this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Please read the important information about importing cars found at:", 350 - this.ftm.stringWidth("Please read the important information about importing cars, found here :") / 2, 260 + i_2_);
                    this.rd.setColor(new Color(0, 128, 255));
                    string = "http://www.needformadness.com/developer/extras.html";
                    this.rd.drawString(string, 350 - this.ftm.stringWidth(string) / 2, 280 + i_2_);
                    if (this.mouseon == 3)
                        this.rd.setColor(new Color(0, 128, 255));
                    else
                        this.rd.setColor(new Color(0, 64, 128));
                    this.rd.drawLine(350 - this.ftm.stringWidth(string) / 2, 281 + i_2_, 350 + this.ftm.stringWidth(string) / 2, 281 + i_2_);
                    if (this.mouseon == 3 && this.mouses == -1)
                        openelink();
                    stringbutton("     Import Car     ", 350, 326 + i_2_, 0, true);
                    stringbutton("  Export >  ", 550, 326 + i_2_, 0, false);
                    stringbutton("  Cancel  ", 350, 366 + i_2_, 0, false);
                }
                if (this.sfase == 4) {
                    this.rd.drawString("Select Car to Export", 350 - this.ftm.stringWidth("Select Car to Export") / 2, 230 + i_2_);
                    this.slcar.move(250, 240 + i_2_);
                    if (this.slcar.getWidth() != 200)
                        this.slcar.setSize(200, 21);
                    if (!this.slcar.isShowing())
                        this.slcar.show();
                    stringbutton("     Export Car     ", 350, 306 + i_2_, 0, true);
                    stringbutton("  Cancel  ", 350, 346 + i_2_, 0, false);
                    if (this.slcar.getSelectedIndex() != 0) {
                        if (!this.carname.equals(this.slcar.getSelectedItem())) {
                            this.tomany = false;
                            this.carname = this.slcar.getSelectedItem();
                            loadfile();
                            this.editor.select(0, 0);
                            this.tested = false;
                            requestFocus();
                        }
                    } else
                        this.carname = "";
                }
            }
            if (this.tab == 1) {
                if (this.tabed != this.tab) {
                    this.srch.setText("");
                    this.rplc.setText("");
                    this.cntchk = 1;
                    this.npolys = 0;
                    this.prefs = false;
                }
                movefield(this.editor, 5, 30, 690, 400);
                if (!this.openm) {
                    if (!this.editor.isShowing()) {
                        this.editor.show();
                        this.editor.requestFocus();
                    }
                } else if (this.editor.isShowing())
                    this.editor.hide();
                this.rd.setFont(new Font("Arial", 1, 12));
                if (this.prefs) {
                    this.rd.drawString("Code Font:", 10, 446);
                    this.fontsel.move(76, 430);
                    if (!this.fontsel.isShowing()) {
                        this.fontsel.show();
                        this.fontsel.select(this.cfont);
                    }
                    if (!this.cfont.equals(this.fontsel.getSelectedItem())) {
                        this.cntprf = 0;
                        this.cfont = this.fontsel.getSelectedItem();
                        this.editor.setFont(new Font(this.cfont, 1, 14));
                        this.srch.setFont(new Font(this.cfont, 1, 14));
                        this.rplc.setFont(new Font(this.cfont, 1, 14));
                        for (int i_5_ = 0; i_5_ < 16; i_5_++)
                            this.wv[i_5_].setFont(new Font(this.cfont, 1, 14));
                        this.editor.requestFocus();
                    }
                    this.rd.drawString("Code Theme:", 190, 446);
                    this.ctheme.move(271, 430);
                    if (!this.ctheme.isShowing()) {
                        this.ctheme.show();
                        this.ctheme.select(this.cthm);
                    }
                    if (this.cthm != this.ctheme.getSelectedIndex()) {
                        this.cntprf = 0;
                        this.cthm = this.ctheme.getSelectedIndex();
                        setheme();
                        this.editor.requestFocus();
                    }
                    stringbutton("<", 400, 446, 3, false);
                    this.cntprf++;
                    if (this.cntprf == 200)
                        this.prefs = false;
                } else {
                    stringbutton("Preferences", 52, 446, 3, false);
                    if (this.ctheme.isShowing())
                        this.ctheme.hide();
                    if (this.fontsel.isShowing())
                        this.fontsel.hide();
                    if (this.cntprf != 0)
                        this.cntprf = 0;
                    if (this.cntchk == 0) {
                        this.npolys = 0;
                        int i_6_ = 0;
                        boolean bool_7_ = false;
                        while (i_6_ != -1 && this.mouses != 1) {
                            if (!bool_7_)
                                i_6_ = this.editor.getText().indexOf("<p>", i_6_);
                            else
                                i_6_ = this.editor.getText().indexOf("</p>", i_6_);
                            if (i_6_ != -1) {
                                if (!bool_7_)
                                    bool_7_ = true;
                                else {
                                    bool_7_ = false;
                                    this.npolys++;
                                }
                                i_6_ += 3;
                            }
                        }
                        if (this.mouses == 1)
                            this.npolys = 0;
                        this.cntchk = 30;
                    } else
                        this.cntchk--;
                    if (this.npolys > 10000)
                        this.rd.setColor(new Color(255, 0, 0));
                    if (this.npolys != 0)
                        this.rd.drawString(new StringBuilder().append("Number of Polygons :  ").append(this.npolys).append(" / 10000").toString(), 200, 446);
                }
                if (!this.changed && !this.editor.getText().equals(this.lastedo))
                    this.changed = true;
                stringbutton("  Save  ", 490, 455, 0, this.changed);
                stringbutton("  Save & Preview  >  ", 600, 455, 0, this.changed);
                this.mirror = false;
                this.polynum = -1;
                this.cntpls = 0;
                String string = "";
                try {
                    string = this.editor.getSelectedText();
                } catch (Exception exception) {
                    /* empty */
                }
                if (!string.equals("")) {
                    int i_8_ = string.indexOf("<p>", 0);
                    while (i_8_ != -1 && i_8_ + 1 < string.length()) {
                        if (!this.mirror) {
                            i_8_ = string.indexOf("</p>", i_8_ + 1);
                            if (i_8_ != -1) {
                                this.mirror = true;
                                this.cntpls++;
                            }
                        }
                        if (this.mirror) {
                            i_8_ = string.indexOf("<p>", i_8_ + 1);
                            if (i_8_ != -1)
                                this.mirror = false;
                        }
                    }
                }
                if (!this.mirror) {
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(5, 474, 494, 70);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Text to find:", 18, 500);
                    movefield(this.srch, 91, 484, 129, 22);
                    if (!this.srch.isShowing())
                        this.srch.show();
                    boolean bool_9_ = false;
                    if (!this.srch.getText().equals(""))
                        bool_9_ = true;
                    stringbutton(" Find ", 117, 526, 2, bool_9_);
                    this.rd.drawString("Replace with:", 255, 500);
                    movefield(this.rplc, 338, 484, 129, 22);
                    if (!this.rplc.isShowing())
                        this.rplc.show();
                    bool_9_ = false;
                    if (!this.srch.getText().equals("") && !this.rplc.getText().equals(""))
                        bool_9_ = true;
                    stringbutton(" Replace ", 376, 526, 2, bool_9_);
                } else {
                    if (this.srch.isShowing())
                        this.srch.hide();
                    if (this.rplc.isShowing())
                        this.rplc.hide();
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(5, 474, 450, 70);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Mirror [Selected] polygon(s) along:", 18, 490);
                    stringbutton(" Mirror Along X Axis ", 90, 525, 2, true);
                    stringbutton(" Mirror Along Y Axis ", 230, 525, 2, false);
                    stringbutton(" Mirror Along Z Axis ", 370, 525, 2, false);
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(465, 474, 230, 70);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Show [Selected] polygon(s):", 478, 490);
                    stringbutton(" Show in 3D  > ", 580, 523, 0, true);
                }
                if (this.npolys > 10000 && !this.tomany) {
                    repaint();
                    JOptionPane.showMessageDialog(null, "Maximum number of polygons (pieces) allowed has been exceeded!\nThe maximum allowed is 10000 polygons, please decrease.\n", "Car Maker", 1);
                    this.tomany = true;
                }
            }
            if (this.tab == 2) {
                if (this.tabed != this.tab) {
                    setupo();
                    this.dtabed = -1;
                }
                this.m.d(this.rd);
                this.o.d(this.rd);
                if (this.dtab == 2) {
                    if (this.compsel > 0 && this.compsel <= 16) {
                        (this.compo[this.compsel - 1]).x = (this.o).x;
                        (this.compo[this.compsel - 1]).y = (this.o).y;
                        (this.compo[this.compsel - 1]).z = (this.o).z;
                        (this.compo[this.compsel - 1]).xz = (this.o).xz;
                        (this.compo[this.compsel - 1]).xy = (this.o).xy;
                        (this.compo[this.compsel - 1]).zy = (this.o).zy;
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                        this.compo[this.compsel - 1].d(this.rd);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    if (this.xm > 420 && this.xm < 690 && this.ym > 425 && this.ym < 540) {
                        int[] is = { 50 + this.adna[0], -50 - this.adna[1], 0, 0, 0, 0 };
                        int[] is_10_ = { 0, 0, 50 + this.adna[2], -50 - this.adna[3], 0, 0 };
                        int[] is_11_ = { 0, 0, 0, 0, 50 + this.adna[4], -50 - this.adna[5] };
                        for (int i_12_ = 0; i_12_ < 6; i_12_++) {
                            is[i_12_] += (this.o).x - (this.m).x;
                            is_10_[i_12_] += (this.o).y - (this.m).y;
                            is_11_[i_12_] += (this.o).z - (this.m).z;
                        }
                        rot(is, is_10_, (this.o).x - (this.m).x, (this.o).y - (this.m).y, (this.o).xy, 6);
                        rot(is_10_, is_11_, (this.o).y - (this.m).y, (this.o).z - (this.m).z, (this.o).zy, 6);
                        rot(is, is_11_, (this.o).x - (this.m).x, (this.o).z - (this.m).z, (this.o).xz, 6);
                        rot(is, is_11_, (this.m).cx, (this.m).cz, (this.m).xz, 6);
                        rot(is_10_, is_11_, (this.m).cy, (this.m).cz, (this.m).zy, 6);
                        int[] is_13_ = new int[6];
                        int[] is_14_ = new int[6];
                        for (int i_15_ = 0; i_15_ < 6; i_15_++) {
                            is_13_[i_15_] = xs(is[i_15_], is_11_[i_15_]);
                            is_14_[i_15_] = ys(is_10_[i_15_], is_11_[i_15_]);
                        }
                        this.rd.setColor(new Color(0, 150, 0));
                        this.rd.drawString("X+", is_13_[0] - 7, is_14_[0] + 4);
                        this.rd.drawString("-X", is_13_[1] - 5, is_14_[1] + 4);
                        this.rd.drawLine(is_13_[0], is_14_[0], is_13_[1], is_14_[1]);
                        this.rd.setColor(new Color(150, 0, 0));
                        this.rd.drawString("Y+", is_13_[2] - 7, is_14_[2] + 4);
                        this.rd.drawString("-Y", is_13_[3] - 5, is_14_[3] + 4);
                        this.rd.drawLine(is_13_[2], is_14_[2], is_13_[3], is_14_[3]);
                        this.rd.setColor(new Color(0, 0, 150));
                        this.rd.drawString("Z+", is_13_[4] - 7, is_14_[4] + 4);
                        this.rd.drawString("-Z", is_13_[5] - 5, is_14_[5] + 4);
                        this.rd.drawLine(is_13_[4], is_14_[4], is_13_[5], is_14_[5]);
                        for (int i_16_ = 0; i_16_ < 6; i_16_++) {
                            if ((float) Math.abs(is_14_[i_16_] - 207) * 1.91F > (float) Math.abs(is_13_[i_16_] - 350)) {
                                if (Math.abs(Math.abs(is_14_[i_16_] - 207) - 170) > 10) {
                                    if (Math.abs(is_14_[i_16_] - 207) < 170)
                                        this.adna[i_16_] += 10;
                                    else
                                        this.adna[i_16_] -= 10;
                                }
                            } else if (Math.abs(Math.abs(is_13_[i_16_] - 350) - 338) > 10) {
                                if (Math.abs(is_13_[i_16_] - 350) < 338)
                                    this.adna[i_16_] += 10;
                                else
                                    this.adna[i_16_] -= 10;
                            }
                            if (this.adna[i_16_] > 276)
                                this.adna[i_16_] = 276;
                            if (this.adna[i_16_] < 0)
                                this.adna[i_16_] = 0;
                        }
                    }
                }
                this.rd.setColor(new Color(205, 200, 200));
                this.rd.fillRect(0, 390, 700, 20);
                this.rd.setColor(new Color(225, 225, 225));
                this.rd.fillRect(0, 410, 700, 140);
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                String[] strings = { "3D Controls", "Color Edit", "Scale & Align", "Wheels", "Stats & Class", "Physics", "Test Drive" };
                int[] is = { 0, 0, 100, 90 };
                int[] is_17_ = { 390, 410, 410, 390 };
                for (int i_18_ = 0; i_18_ < 7; i_18_++) {
                    this.rd.setColor(new Color(170, 170, 170));
                    if (this.xm > is[0] && this.xm < is[3] && this.ym > 390 && this.ym < 410)
                        this.rd.setColor(new Color(190, 190, 190));
                    if (this.dtab == i_18_)
                        this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillPolygon(is, is_17_, 4);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(strings[i_18_], i_18_ * 100 + 47 - this.ftm.stringWidth(strings[i_18_]) / 2, 404);
                    if (this.xm > is[0] && this.xm < is[3] && this.ym > 390 && this.ym < 410 && this.mouses == -1)
                        this.dtab = i_18_;
                    for (int i_19_ = 0; i_19_ < 4; i_19_++)
                        is[i_19_] += 100;
                }
                if (this.dtabed != this.dtab) {
                    if (this.dtabed != -1) {
                        if (!this.editor.getText().equals(this.lastedo))
                            this.editor.setText(this.lastedo);
                        setupo();
                    }
                    setCursor(new Cursor(0));
                    hidefields();
                    requestFocus();
                }
                this.rd.setColor(new Color(0, 0, 0));
                if (this.dtab == 0) {
                    this.rd.drawString("Rotate Car around its X & Z Axis using:  [ Keyboard Arrows ] ", 20, 440);
                    this.rd.drawString("Rotate Car fully around the Y Axis using:    [ < ]  &  [ > ]    or    [ A ]  &  [ D ]    or    [ 4 ]  &  [ 6 ]    Keys", 20, 465);
                    this.rd.drawString("Move Car Up and Down using:    [ - ]  &  [ + ]    Keys", 20, 490);
                    this.rd.drawString("Move Car Forwards and Backwards using:    [ W ]  &  [ S ]    or    [ 8 ]  &  [ 2 ]    or    [ Enter ]  &  [ Backspace ]    Keys", 20, 515);
                }
                if (this.dtab == 1) {
                    if ((this.o).colok != 2) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("[  First & Second Color not defined yet  ]", 350 - this.ftm.stringWidth("[  First & Second Color not defined yet  ]") / 2, 450);
                        stringbutton(" Define 1st and 2nd Color ", 350, 490, 0, true);
                    } else {
                        if (this.dtabed != this.dtab) {
                            this.fcol = new StringBuilder().append("(").append((this.o).fcol[0]).append(",").append((this.o).fcol[1]).append(",").append((this.o).fcol[2]).append(")").toString();
                            this.srch.setText(this.fcol);
                            this.ofcol = this.fcol;
                            Color.RGBtoHSB((this.o).fcol[0], (this.o).fcol[1], (this.o).fcol[2], this.fhsb);
                            float f = this.fhsb[1];
                            this.fhsb[1] = this.fhsb[2];
                            this.fhsb[2] = f;
                            this.scol = new StringBuilder().append("(").append((this.o).scol[0]).append(",").append((this.o).scol[1]).append(",").append((this.o).scol[2]).append(")").toString();
                            this.rplc.setText(this.scol);
                            this.oscol = this.scol;
                            Color.RGBtoHSB((this.o).scol[0], (this.o).scol[1], (this.o).scol[2], this.shsb);
                            f = this.shsb[1];
                            this.shsb[1] = this.shsb[2];
                            this.shsb[2] = f;
                            this.bfo = 51;
                            this.mouseon = -1;
                        }
                        if (this.mouses != 1)
                            this.mouseon = -1;
                        this.rd.setColor(new Color(170, 170, 170));
                        this.rd.drawRect(20, 425, 320, 110);
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(141, 419, 77, 9);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("First Color", 151, 428);
                        this.rd.drawString("Hue:", 75, 450);
                        this.rd.drawString("Brightness:", 35, 470);
                        this.rd.drawString("Saturation:", 38, 490);
                        this.rd.drawString("RGB Value:", 38, 520);
                        movefield(this.srch, 106, 504, 129, 22);
                        if (this.srch.hasFocus())
                            this.focuson = false;
                        if (!this.srch.isShowing())
                            this.srch.show();
                        for (int i_20_ = 0; i_20_ < 200; i_20_++) {
                            this.rd.setColor(Color.getHSBColor((float) ((double) (float) i_20_ * 0.005), 1.0F, 1.0F));
                            this.rd.drawLine(110 + i_20_, 442, 110 + i_20_, 449);
                        }
                        for (int i_21_ = 0; i_21_ < 200; i_21_++) {
                            this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float) ((double) (float) i_21_ * 0.004)));
                            this.rd.drawLine(110 + i_21_, 462, 110 + i_21_, 469);
                        }
                        for (int i_22_ = 0; i_22_ < 200; i_22_++) {
                            this.rd.setColor(Color.getHSBColor(this.fhsb[0], (float) ((double) (float) i_22_ * 0.005), this.fhsb[1]));
                            this.rd.drawLine(110 + i_22_, 482, 110 + i_22_, 489);
                        }
                        for (int i_23_ = 0; i_23_ < 3; i_23_++) {
                            this.rd.setColor(new Color(0, 0, 0));
                            float f = this.fhsb[i_23_] * 200.0F;
                            if (i_23_ == 1)
                                f = (this.fhsb[i_23_] - 0.2F) * 250.0F;
                            this.rd.drawLine((int) (110.0F + f), 442 + i_23_ * 20, (int) (110.0F + f), 449 + i_23_ * 20);
                            this.rd.drawLine((int) (111.0F + f), 442 + i_23_ * 20, (int) (111.0F + f), 449 + i_23_ * 20);
                            this.rd.fillRect((int) (109.0F + f), 450 + i_23_ * 20, 4, 2);
                            this.rd.drawLine((int) (108.0F + f), 452 + i_23_ * 20, (int) (113.0F + f), 452 + i_23_ * 20);
                            if (this.xm > 107 && this.xm < 313 && this.ym > 439 + i_23_ * 20 && this.ym < 452 + i_23_ * 20 && this.mouses == 1 && this.mouseon == -1)
                                this.mouseon = i_23_;
                            if (this.mouseon == i_23_) {
                                if (i_23_ == 1) {
                                    this.fhsb[i_23_] = 0.2F + (float) (this.xm - 110) / 250.0F;
                                    if ((double) this.fhsb[i_23_] < 0.2)
                                        this.fhsb[i_23_] = 0.2F;
                                } else
                                    this.fhsb[i_23_] = (float) (this.xm - 110) / 200.0F;
                                if (this.fhsb[i_23_] > 1.0F)
                                    this.fhsb[i_23_] = 1.0F;
                                if (this.fhsb[i_23_] < 0.0F)
                                    this.fhsb[i_23_] = 0.0F;
                            }
                        }
                        stringbutton(" Save ", 300, 520, 0, !this.fcol.equals(this.ofcol));
                        this.rd.setColor(new Color(170, 170, 170));
                        this.rd.drawRect(360, 425, 320, 110);
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(472, 419, 95, 9);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Second Color", 482, 428);
                        this.rd.drawString("Hue:", 415, 450);
                        this.rd.drawString("Brightness:", 375, 470);
                        this.rd.drawString("Saturation:", 378, 490);
                        this.rd.drawString("RGB Value:", 378, 520);
                        movefield(this.rplc, 446, 504, 129, 22);
                        if (this.rplc.hasFocus())
                            this.focuson = false;
                        if (!this.rplc.isShowing())
                            this.rplc.show();
                        for (int i_24_ = 0; i_24_ < 200; i_24_++) {
                            this.rd.setColor(Color.getHSBColor((float) ((double) (float) i_24_ * 0.005), 1.0F, 1.0F));
                            this.rd.drawLine(450 + i_24_, 442, 450 + i_24_, 449);
                        }
                        for (int i_25_ = 0; i_25_ < 200; i_25_++) {
                            this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float) ((double) (float) i_25_ * 0.004)));
                            this.rd.drawLine(450 + i_25_, 462, 450 + i_25_, 469);
                        }
                        for (int i_26_ = 0; i_26_ < 200; i_26_++) {
                            this.rd.setColor(Color.getHSBColor(this.shsb[0], (float) ((double) (float) i_26_ * 0.005), this.shsb[2]));
                            this.rd.drawLine(450 + i_26_, 482, 450 + i_26_, 489);
                        }
                        for (int i_27_ = 0; i_27_ < 3; i_27_++) {
                            this.rd.setColor(new Color(0, 0, 0));
                            float f = this.shsb[i_27_] * 200.0F;
                            if (i_27_ == 1)
                                f = (this.shsb[i_27_] - 0.2F) * 250.0F;
                            this.rd.drawLine((int) (450.0F + f), 442 + i_27_ * 20, (int) (450.0F + f), 449 + i_27_ * 20);
                            this.rd.drawLine((int) (451.0F + f), 442 + i_27_ * 20, (int) (451.0F + f), 449 + i_27_ * 20);
                            this.rd.fillRect((int) (449.0F + f), 450 + i_27_ * 20, 4, 2);
                            this.rd.drawLine((int) (448.0F + f), 452 + i_27_ * 20, (int) (453.0F + f), 452 + i_27_ * 20);
                            if (this.xm > 447 && this.xm < 653 && this.ym > 439 + i_27_ * 20 && this.ym < 452 + i_27_ * 20 && this.mouses == 1 && this.mouseon == -1)
                                this.mouseon = i_27_ + 3;
                            if (this.mouseon == i_27_ + 3) {
                                if (i_27_ == 1) {
                                    this.shsb[i_27_] = 0.2F + (float) (this.xm - 450) / 250.0F;
                                    if ((double) this.shsb[i_27_] < 0.2)
                                        this.shsb[i_27_] = 0.2F;
                                } else
                                    this.shsb[i_27_] = (float) (this.xm - 450) / 200.0F;
                                if (this.shsb[i_27_] > 1.0F)
                                    this.shsb[i_27_] = 1.0F;
                                if (this.shsb[i_27_] < 0.0F)
                                    this.shsb[i_27_] = 0.0F;
                            }
                        }
                        stringbutton(" Save ", 640, 520, 0, !this.scol.equals(this.oscol));
                        if ((double) this.fhsb[1] < 0.2)
                            this.fhsb[1] = 0.2F;
                        if ((double) this.shsb[1] < 0.2)
                            this.shsb[1] = 0.2F;
                        for (int i_28_ = 0; i_28_ < (this.o).npl; i_28_++) {
                            if (((this.o).p[i_28_]).colnum == 1) {
                                ((this.o).p[i_28_]).hsb[0] = this.fhsb[0];
                                ((this.o).p[i_28_]).hsb[1] = this.fhsb[2];
                                ((this.o).p[i_28_]).hsb[2] = this.fhsb[1];
                            }
                            if (((this.o).p[i_28_]).colnum == 2) {
                                ((this.o).p[i_28_]).hsb[0] = this.shsb[0];
                                ((this.o).p[i_28_]).hsb[1] = this.shsb[2];
                                ((this.o).p[i_28_]).hsb[2] = this.shsb[1];
                            }
                        }
                        String string = new StringBuilder().append("(").append(Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getRed()).append(",").append(Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getGreen()).append(",").append(Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getBlue()).append(")").toString();
                        if (!this.fcol.equals(string)) {
                            this.fcol = string;
                            this.srch.setText(this.fcol);
                        }
                        string = new StringBuilder().append("(").append(Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getRed()).append(",").append(Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getGreen()).append(",").append(Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getBlue()).append(")").toString();
                        if (!this.scol.equals(string)) {
                            this.scol = string;
                            this.rplc.setText(this.scol);
                        }
                        if (this.srch.getText().equals(this.fcol) && this.rplc.getText().equals(this.scol)) {
                            if (this.bfo < 50)
                                this.bfo++;
                            else if (this.bfo == 50) {
                                requestFocus();
                                this.bfo = 51;
                            }
                        } else {
                            this.bfo = 0;
                            if (!this.srch.getText().equals(this.fcol)) {
                                this.fcol = this.srch.getText();
                                int[] is_29_ = new int[3];
                                boolean bool_30_ = true;
                                try {
                                    int i_31_ = this.fcol.indexOf(",", 0);
                                    int i_32_ = this.fcol.indexOf(",", i_31_ + 1);
                                    is_29_[0] = Integer.valueOf(this.fcol.substring(1, i_31_)).intValue();
                                    if (is_29_[0] < 0)
                                        is_29_[0] = 0;
                                    if (is_29_[0] > 255)
                                        is_29_[0] = 255;
                                    is_29_[1] = Integer.valueOf(this.fcol.substring(i_31_ + 1, i_32_)).intValue();
                                    if (is_29_[1] < 0)
                                        is_29_[1] = 0;
                                    if (is_29_[1] > 255)
                                        is_29_[1] = 255;
                                    is_29_[2] = Integer.valueOf(this.fcol.substring(i_32_ + 1, this.fcol.length() - 1)).intValue();
                                    if (is_29_[2] < 0)
                                        is_29_[2] = 0;
                                    if (is_29_[2] > 255)
                                        is_29_[2] = 255;
                                } catch (Exception exception) {
                                    bool_30_ = false;
                                }
                                if (bool_30_) {
                                    Color.RGBtoHSB(is_29_[0], is_29_[1], is_29_[2], this.fhsb);
                                    float f = this.fhsb[1];
                                    this.fhsb[1] = this.fhsb[2];
                                    this.fhsb[2] = f;
                                }
                            }
                            if (!this.rplc.getText().equals(this.scol)) {
                                this.scol = this.rplc.getText();
                                int[] is_33_ = new int[3];
                                boolean bool_34_ = true;
                                try {
                                    int i_35_ = this.scol.indexOf(",", 0);
                                    int i_36_ = this.scol.indexOf(",", i_35_ + 1);
                                    is_33_[0] = Integer.valueOf(this.scol.substring(1, i_35_)).intValue();
                                    if (is_33_[0] < 0)
                                        is_33_[0] = 0;
                                    if (is_33_[0] > 255)
                                        is_33_[0] = 255;
                                    is_33_[1] = Integer.valueOf(this.scol.substring(i_35_ + 1, i_36_)).intValue();
                                    if (is_33_[1] < 0)
                                        is_33_[1] = 0;
                                    if (is_33_[1] > 255)
                                        is_33_[1] = 255;
                                    is_33_[2] = Integer.valueOf(this.scol.substring(i_36_ + 1, this.scol.length() - 1)).intValue();
                                    if (is_33_[2] < 0)
                                        is_33_[2] = 0;
                                    if (is_33_[2] > 255)
                                        is_33_[2] = 255;
                                } catch (Exception exception) {
                                    bool_34_ = false;
                                }
                                if (bool_34_) {
                                    Color.RGBtoHSB(is_33_[0], is_33_[1], is_33_[2], this.shsb);
                                    float f = this.shsb[1];
                                    this.shsb[1] = this.shsb[2];
                                    this.shsb[2] = f;
                                }
                            }
                        }
                    }
                }
                if (this.dtab == 2) {
                    if (this.dtabed != this.dtab) {
                        this.lastedo = this.editor.getText();
                        this.scale[0] = 100;
                        int i_37_ = this.editor.getText().indexOf("\nScaleX(", 0);
                        if (i_37_ != -1) {
                            i_37_++;
                            try {
                                this.scale[0] = Integer.valueOf(this.editor.getText().substring(i_37_ + 7, this.editor.getText().indexOf(")", i_37_))).intValue();
                            } catch (Exception exception) {
                                this.scale[0] = 100;
                            }
                        }
                        this.oscale[0] = this.scale[0];
                        this.scale[1] = 100;
                        i_37_ = this.editor.getText().indexOf("\nScaleY(", 0);
                        if (i_37_ != -1) {
                            i_37_++;
                            try {
                                this.scale[1] = Integer.valueOf(this.editor.getText().substring(i_37_ + 7, this.editor.getText().indexOf(")", i_37_))).intValue();
                            } catch (Exception exception) {
                                this.scale[1] = 100;
                            }
                        }
                        this.oscale[1] = this.scale[1];
                        this.scale[2] = 100;
                        i_37_ = this.editor.getText().indexOf("\nScaleZ(", 0);
                        if (i_37_ != -1) {
                            i_37_++;
                            try {
                                this.scale[2] = Integer.valueOf(this.editor.getText().substring(i_37_ + 7, this.editor.getText().indexOf(")", i_37_))).intValue();
                            } catch (Exception exception) {
                                this.scale[2] = 100;
                            }
                        }
                        this.oscale[2] = this.scale[2];
                        this.bfo = 0;
                        this.compsel = 0;
                        this.compcar.select(this.compsel);
                        this.changed2 = false;
                    }
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(9, 425, 270, 115);
                    this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillRect(119, 419, 51, 9);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Scale", 129, 428);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Scale X", 25, 450);
                    stringbutton(" - ", 92, 450, 4, false);
                    this.rd.drawString(new StringBuilder().append("").append((float) this.scale[0] / 100.0F).append("").toString(), 126 - this.ftm.stringWidth(new StringBuilder().append("").append((float) this.scale[0] / 100.0F).append("").toString()) / 2, 450);
                    stringbutton(" + ", 160, 450, 4, false);
                    this.rd.drawString("Scale Y", 25, 474);
                    stringbutton(" - ", 92, 474, 4, false);
                    this.rd.drawString(new StringBuilder().append("").append((float) this.scale[1] / 100.0F).append("").toString(), 126 - this.ftm.stringWidth(new StringBuilder().append("").append((float) this.scale[1] / 100.0F).append("").toString()) / 2, 474);
                    stringbutton(" + ", 160, 474, 4, false);
                    this.rd.drawString("Scale Z", 25, 498);
                    stringbutton(" - ", 92, 498, 4, false);
                    this.rd.drawString(new StringBuilder().append("").append((float) this.scale[2] / 100.0F).append("").toString(), 126 - this.ftm.stringWidth(new StringBuilder().append("").append((float) this.scale[2] / 100.0F).append("").toString()) / 2, 498);
                    stringbutton(" + ", 160, 498, 4, false);
                    this.rd.drawString("Scale ALL", 25, 527);
                    stringbutton(" - ", 106, 527, 2, true);
                    stringbutton(" + ", 146, 527, 2, true);
                    stringbutton("   Save   ", 230, 454, 0, this.oscale[0] != this.scale[0] || this.oscale[1] != this.scale[1] || this.oscale[2] != this.scale[2]);
                    stringbutton(" Reset ", 230, 493, 0, false);
                    this.rd.drawString("Compare scale and", 296, 440);
                    this.rd.drawString("alignment with:", 308, 455);
                    this.compcar.move(288, 462);
                    if (this.compcar.hasFocus()) {
                        this.focuson = false;
                        this.bfo++;
                        if (this.bfo == 100)
                            requestFocus();
                    } else
                        this.bfo = 0;
                    if (!this.compcar.isShowing())
                        this.compcar.show();
                    if (this.compsel != this.compcar.getSelectedIndex()) {
                        this.compsel = this.compcar.getSelectedIndex();
                        requestFocus();
                    }
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawRect(420, 425, 270, 115);
                    this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillRect(531, 419, 47, 9);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Align", 541, 428);
                    this.rd.drawString("Align in X", 433, 450);
                    stringbutton(" Rotate 90\u00b0 ", 535, 450, 4, false);
                    stringbutton("+10", 607, 450, 4, false);
                    stringbutton("-10", 656, 450, 4, false);
                    this.rd.drawString("Align in Y", 433, 474);
                    stringbutton(" Rotate 90\u00b0 ", 535, 474, 4, false);
                    stringbutton("+10", 607, 474, 4, false);
                    stringbutton("-10", 656, 474, 4, false);
                    this.rd.drawString("Align in Z", 433, 498);
                    stringbutton(" Rotate 90\u00b0 ", 535, 498, 4, false);
                    stringbutton("+10", 607, 498, 4, false);
                    stringbutton("-10", 656, 498, 4, false);
                    stringbutton(" Reset ", 490, 527, 0, false);
                    stringbutton("      Save      ", 607, 527, 0, this.changed2);
                }
                if (this.dtab == 3) {
                    if (this.dtabed != this.dtab) {
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
                        String string_56_ = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                            this.defnow = true;
                        else
                            this.defnow = false;
                        this.wv[0].setText(new StringBuilder().append("").append(i_39_).append("").toString());
                        this.wv[1].setText(new StringBuilder().append("").append(i_41_).append("").toString());
                        this.wv[2].setText(new StringBuilder().append("").append(i_43_).append("").toString());
                        this.wv[3].setText(new StringBuilder().append("").append(i_47_).append("").toString());
                        this.wv[4].setText(new StringBuilder().append("").append(i_45_).append("").toString());
                        this.srch.setText(string_54_);
                        this.wv[5].setText(new StringBuilder().append("").append(i_49_).append("").toString());
                        this.wv[6].setText(new StringBuilder().append("").append(i_51_).append("").toString());
                        this.wv[7].setText(new StringBuilder().append("").append(i_53_).append("").toString());
                        this.wv[8].setText(new StringBuilder().append("").append(i_38_).append("").toString());
                        this.wv[9].setText(new StringBuilder().append("").append(i_40_).append("").toString());
                        this.wv[10].setText(new StringBuilder().append("").append(i_42_).append("").toString());
                        this.wv[11].setText(new StringBuilder().append("").append(i_46_).append("").toString());
                        this.wv[12].setText(new StringBuilder().append("").append(i_44_).append("").toString());
                        this.rplc.setText(string);
                        this.wv[13].setText(new StringBuilder().append("").append(i_48_).append("").toString());
                        this.wv[14].setText(new StringBuilder().append("").append(i_50_).append("").toString());
                        this.wv[15].setText(new StringBuilder().append("").append(i_52_).append("").toString());
                        this.aply1 = new StringBuilder().append("").append(this.wv[0].getText()).append("").append(this.wv[1].getText()).append("").append(this.wv[2].getText()).append("").append(this.wv[3].getText()).append("").append(this.wv[4].getText()).append("").append(this.srch.getText()).append("").append(this.wv[5].getText()).append("").append(this.wv[6].getText()).append("").append(this.wv[7].getText()).append("").toString();
                        this.aply2 = new StringBuilder().append("").append(this.wv[8].getText()).append("").append(this.wv[9].getText()).append("").append(this.wv[10].getText()).append("").append(this.wv[11].getText()).append("").append(this.wv[12].getText()).append("").append(this.rplc.getText()).append("").append(this.wv[13].getText()).append("").append(this.wv[14].getText()).append("").append(this.wv[15].getText()).append("").toString();
                        this.aplyd1 = false;
                        this.aplyd2 = false;
                        this.changed2 = false;
                        this.mouseon = -1;
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("BACK Wheels :", 12, 424);
                    this.rd.drawString("\u00b1X :", 12, 449);
                    movefield(this.wv[0], 35, 433, 40, 22);
                    this.rd.drawString("Y :", 86, 449);
                    movefield(this.wv[1], 101, 433, 40, 22);
                    this.rd.drawString("Z :", 151, 449);
                    movefield(this.wv[2], 166, 433, 40, 22);
                    this.rd.drawString("Height :", 12, 479);
                    movefield(this.wv[3], 56, 463, 40, 22);
                    this.rd.drawString("Width :", 107, 479);
                    movefield(this.wv[4], 148, 463, 40, 22);
                    this.rd.drawString("Rims RGB Color :", 12, 509);
                    movefield(this.srch, 109, 493, 129, 22);
                    this.rd.drawString("Rims Size :", 12, 539);
                    movefield(this.wv[5], 76, 523, 40, 22);
                    this.rd.drawString("Rims Depth :", 126, 539);
                    movefield(this.wv[6], 199, 523, 40, 22);
                    if (this.xm > 245 && this.xm < 336 && this.ym > 524 && this.ym < 541) {
                        this.rd.setColor(new Color(255, 0, 0));
                        this.rd.drawLine(248, 540, 279, 540);
                        this.rd.drawLine(327, 540, 334, 540);
                        if (this.mouseon == -1) {
                            this.mouseon = 1;
                            setCursor(new Cursor(12));
                        }
                    } else if (this.mouseon == 1) {
                        this.mouseon = -1;
                        setCursor(new Cursor(0));
                    }
                    this.rd.drawString("Hide :                ?", 249, 539);
                    movefield(this.wv[7], 282, 523, 40, 22);
                    stringbutton("   Apply   ", 300, 440, 0, this.aplyd1);
                    stringbutton("   Save   ", 300, 477, 0, this.changed2);
                    this.rd.drawString("FRONT Wheels :", 362, 424);
                    this.rd.drawString("\u00b1X :", 362, 449);
                    movefield(this.wv[8], 385, 433, 40, 22);
                    this.rd.drawString("Y :", 436, 449);
                    movefield(this.wv[9], 451, 433, 40, 22);
                    this.rd.drawString("Z :", 501, 449);
                    movefield(this.wv[10], 516, 433, 40, 22);
                    this.rd.drawString("Height :", 362, 479);
                    movefield(this.wv[11], 406, 463, 40, 22);
                    this.rd.drawString("Width :", 457, 479);
                    movefield(this.wv[12], 498, 463, 40, 22);
                    this.rd.drawString("Rims RGB Color :", 362, 509);
                    movefield(this.rplc, 459, 493, 129, 22);
                    this.rd.drawString("Rims Size :", 362, 539);
                    movefield(this.wv[13], 426, 523, 40, 22);
                    this.rd.drawString("Rims Depth :", 476, 539);
                    movefield(this.wv[14], 549, 523, 40, 22);
                    if (this.xm > 595 && this.xm < 686 && this.ym > 524 && this.ym < 541) {
                        this.rd.setColor(new Color(255, 0, 0));
                        this.rd.drawLine(598, 540, 629, 540);
                        this.rd.drawLine(677, 540, 684, 540);
                        if (this.mouseon == -1) {
                            this.mouseon = 2;
                            setCursor(new Cursor(12));
                        }
                    } else if (this.mouseon == 2) {
                        this.mouseon = -1;
                        setCursor(new Cursor(0));
                    }
                    this.rd.drawString("Hide :                ?", 599, 539);
                    movefield(this.wv[15], 632, 523, 40, 22);
                    stringbutton("   Apply   ", 650, 440, 0, this.aplyd2);
                    stringbutton("   Save   ", 650, 477, 0, this.changed2);
                    if (this.mouses == -1 && (this.mouseon == 1 || this.mouseon == 2))
                        JOptionPane.showMessageDialog(null, "Use this variable to hide the car wheels inside the car if you need to (if they are getting drawn over the car when they\nshould be drawn behind it).\n\nIf you have created a car model with specific places for the wheels go inside them (inside the car), if when you place the\nwheels there they don\u2019t get drawn inside the car (they get drawn over it instead), use this variable to adjust that.\n\nYou can also use this variable to do the opposite, to make the wheels get drawn over the car if they are getting drawn\nbehind it when they shouldn\u2019t.\n\nThe Hide variable takes values from -40 to 40:\nA +ve value from 1 to 40 makes the wheels more hidden, where 40 is the maximum the car wheel can be hidden.\nA -ve value from -1 to -40 does exactly the opposite and makes the wheels more apparent (this if the car wheels appear\ninside the car when they should be outside).\nA 0 value means do nothing.\nMost of the time you will need to use this variable, it will be to enter +ve values from 1-40 for hiding the car wheels.\n\n", "Car Maker", 1);
                    for (int i_65_ = 0; i_65_ < 16; i_65_++) {
                        if (this.wv[i_65_].hasFocus())
                            this.focuson = false;
                        if (!this.wv[i_65_].isShowing())
                            this.wv[i_65_].show();
                    }
                    if (this.srch.hasFocus())
                        this.focuson = false;
                    if (!this.srch.isShowing())
                        this.srch.show();
                    if (this.rplc.hasFocus())
                        this.focuson = false;
                    if (!this.rplc.isShowing())
                        this.rplc.show();
                    if (!this.focuson) {
                        if (!this.aplyd1 && !this.aply1.equals(new StringBuilder().append("").append(this.wv[0].getText()).append("").append(this.wv[1].getText()).append("").append(this.wv[2].getText()).append("").append(this.wv[3].getText()).append("").append(this.wv[4].getText()).append("").append(this.srch.getText()).append("").append(this.wv[5].getText()).append("").append(this.wv[6].getText()).append("").append(this.wv[7].getText()).append("").toString()))
                            this.aplyd1 = true;
                        if (!this.aplyd2 && !this.aply2.equals(new StringBuilder().append("").append(this.wv[8].getText()).append("").append(this.wv[9].getText()).append("").append(this.wv[10].getText()).append("").append(this.wv[11].getText()).append("").append(this.wv[12].getText()).append("").append(this.rplc.getText()).append("").append(this.wv[13].getText()).append("").append(this.wv[14].getText()).append("").append(this.wv[15].getText()).append("").toString()))
                            this.aplyd2 = true;
                    }
                    this.rd.setColor(new Color(170, 170, 170));
                    this.rd.drawLine(350, 410, 350, 550);
                    this.rd.drawLine(300, 409, 400, 409);
                }
                if (this.dtab == 4) {
                    if (this.dtabed != this.dtab) {
                        this.changed2 = false;
                        this.statdef = false;
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                                        this.stat[i_70_] = getvalue("stat", string_68_, i_70_);
                                        if (this.stat[i_70_] > 200)
                                            this.stat[i_70_] = 200;
                                        if (this.stat[i_70_] < 16)
                                            this.stat[i_70_] = 16;
                                        i_69_ += this.stat[i_70_];
                                    }
                                    int i_71_ = 0;
                                    if (i_69_ > 680) {
                                        i_71_ = 680 - i_69_;
                                        this.changed2 = true;
                                    }
                                    if (i_69_ > 640 && i_69_ < 680) {
                                        i_71_ = 640 - i_69_;
                                        this.changed2 = true;
                                    }
                                    if (i_69_ > 600 && i_69_ < 640) {
                                        i_71_ = 600 - i_69_;
                                        this.changed2 = true;
                                    }
                                    if (i_69_ > 560 && i_69_ < 600) {
                                        i_71_ = 560 - i_69_;
                                        this.changed2 = true;
                                    }
                                    if (i_69_ > 520 && i_69_ < 560) {
                                        i_71_ = 520 - i_69_;
                                        this.changed2 = true;
                                    }
                                    if (i_69_ < 520) {
                                        i_71_ = 520 - i_69_;
                                        this.changed2 = true;
                                    }
                                    while (i_71_ != 0) {
                                        for (int i_72_ = 0; i_72_ < 5; i_72_++) {
                                            if (i_71_ > 0 && this.stat[i_72_] < 200) {
                                                this.stat[i_72_]++;
                                                i_71_--;
                                            }
                                            if (i_71_ < 0 && this.stat[i_72_] > 16) {
                                                this.stat[i_72_]--;
                                                i_71_++;
                                            }
                                        }
                                    }
                                    for (int i_73_ = 0; i_73_ < 5; i_73_++)
                                        this.rstat[i_73_] = this.stat[i_73_];
                                    this.statdef = true;
                                }
                            } catch (Exception exception) {
                                this.statdef = false;
                            }
                        }
                        if (this.statdef) {
                            if (this.simcar.getItemCount() == 16)
                                this.simcar.add(this.rd, "   ");
                        } else if (this.simcar.getItemCount() == 17)
                            this.simcar.remove("   ");
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    if (!this.statdef) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("To start, please select the most similar NFM car to this car", 350 - this.ftm.stringWidth("To start, please select the most similar NFM car to this car") / 2, 450);
                        this.simcar.move(288, 460);
                        if (!this.simcar.isShowing())
                            this.simcar.show();
                        stringbutton("   OK   ", 350, 515, 0, true);
                    } else {
                        this.rd.drawString("Car Class", 54, 435);
                        this.cls.move(34, 440);
                        if (!this.cls.isShowing())
                            this.cls.show();
                        boolean bool_74_ = false;
                        int i_75_ = 0;
                        for (int i_76_ = 0; i_76_ < 5; i_76_++) {
                            i_75_ += this.stat[i_76_];
                            if (this.stat[i_76_] != this.rstat[i_76_])
                                bool_74_ = true;
                        }
                        if (this.clsel != this.cls.getSelectedIndex()) {
                            this.clsel = this.cls.getSelectedIndex();
                            int i_77_ = (4 - this.clsel) * 40 + 520 - i_75_;
                            while (i_77_ != 0) {
                                for (int i_78_ = 0; i_78_ < 5; i_78_++) {
                                    if (i_77_ > 0 && this.stat[i_78_] < 200) {
                                        this.stat[i_78_]++;
                                        i_77_--;
                                    }
                                    if (i_77_ < 0 && this.stat[i_78_] > 16) {
                                        this.stat[i_78_]--;
                                        i_77_++;
                                    }
                                }
                            }
                        }
                        if (4 - (i_75_ - 520) / 40 != this.cls.getSelectedIndex()) {
                            this.clsel = 4 - (i_75_ - 520) / 40;
                            this.cls.select(this.clsel);
                        }
                        this.rd.drawString("Most Similar Car", 36, 490);
                        this.simcar.move(20, 495);
                        if (!this.simcar.isShowing())
                            this.simcar.show();
                        if (this.carsel != this.simcar.getSelectedIndex()) {
                            this.carsel = this.simcar.getSelectedIndex();
                            if (this.carsel != 16) {
                                for (int i_79_ = 0; i_79_ < 5; i_79_++)
                                    this.stat[i_79_] = this.carstat[this.carsel][i_79_];
                            }
                            requestFocus();
                        }
                        int i_80_ = 60;
                        int i_81_ = 16;
                        for (int i_82_ = 0; i_82_ < 16; i_82_++) {
                            int i_83_ = 0;
                            for (int i_84_ = 0; i_84_ < 5; i_84_++)
                                i_83_ += Math.abs(this.carstat[i_82_][i_84_] - this.stat[i_84_]);
                            if (i_83_ < i_80_) {
                                i_81_ = i_82_;
                                i_80_ = i_83_;
                            }
                        }
                        if (i_81_ != this.carsel) {
                            this.carsel = i_81_;
                            if (this.carsel < this.simcar.getItemCount())
                                this.simcar.select(this.carsel);
                        }
                        this.rd.drawString("Speed :", 196, 435);
                        this.rd.drawString("Acceleration :", 160, 459);
                        this.rd.drawString("Stunts :", 195, 483);
                        this.rd.drawString("Strength :", 183, 507);
                        this.rd.drawString("Endurance :", 171, 531);
                        for (int i_85_ = 0; i_85_ < 5; i_85_++) {
                            for (int i_86_ = 0; i_86_ < this.stat[i_85_]; i_86_++) {
                                this.rd.setColor(Color.getHSBColor((float) ((double) (float) i_86_ * 7.0E-4), 1.0F, 1.0F));
                                this.rd.drawLine(250 + i_86_, 426 + i_85_ * 24, 250 + i_86_, 434 + i_85_ * 24);
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawLine(249, 426 + i_85_ * 24, 249, 434 + i_85_ * 24);
                            this.rd.drawLine(450, 426 + i_85_ * 24, 450, 434 + i_85_ * 24);
                            this.rd.drawLine(249, 435 + i_85_ * 24, 450, 435 + i_85_ * 24);
                            for (int i_87_ = 0; i_87_ < 7; i_87_++)
                                this.rd.drawLine(275 + i_87_ * 25, 434 + i_85_ * 24, 275 + i_87_ * 25, 430 + i_85_ * 24);
                            stringbutton(" - ", 480, 435 + i_85_ * 24, 4, false);
                            stringbutton(" + ", 520, 435 + i_85_ * 24, 4, false);
                        }
                        if (this.carsel < 16 && i_80_ != 0)
                            stringbutton(" Reselect ", 80, 534, 4, true);
                        else
                            stringbutton(" Reselect ", 80, -1000, 4, true);
                        stringbutton("      Save      ", 620, 459, 0, bool_74_ || this.changed2);
                        stringbutton("   Reset   ", 620, 507, 0, false);
                    }
                }
                if (this.dtab == 5) {
                    if (this.dtabed != this.dtab) {
                        this.mouseon = -1;
                        this.pfase = 0;
                        if ((this.o).keyz[0] <= 0 || (this.o).keyx[0] >= 0)
                            this.pfase = -1;
                        if ((this.o).keyz[1] <= 0 || (this.o).keyx[1] <= 0)
                            this.pfase = -1;
                        if ((this.o).keyz[2] >= 0 || (this.o).keyx[2] >= 0)
                            this.pfase = -1;
                        if ((this.o).keyz[3] >= 0 || (this.o).keyx[3] <= 0)
                            this.pfase = -1;
                        this.crashok = false;
                        if (Math.random() > Math.random())
                            this.crashleft = false;
                        else
                            this.crashleft = true;
                        this.engsel = 0;
                        if (this.pfase == 0) {
                            String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                                            this.phys[i_91_] = getvalue("physics", string_90_, i_91_);
                                            if (this.phys[i_91_] > 100)
                                                this.phys[i_91_] = 100;
                                            if (this.phys[i_91_] < 0)
                                                this.phys[i_91_] = 0;
                                        }
                                        for (int i_92_ = 0; i_92_ < 11; i_92_++)
                                            this.rphys[i_92_] = this.phys[i_92_];
                                        for (int i_93_ = 0; i_93_ < 3; i_93_++) {
                                            this.crash[i_93_] = getvalue("physics", string_90_, i_93_ + 11);
                                            if (this.crash[i_93_] > 100)
                                                this.crash[i_93_] = 100;
                                            if (this.crash[i_93_] < 0)
                                                this.crash[i_93_] = 0;
                                        }
                                        for (int i_94_ = 0; i_94_ < 3; i_94_++)
                                            this.rcrash[i_94_] = this.crash[i_94_];
                                        this.engsel = getvalue("physics", string_90_, 14);
                                        if (this.engsel > 4)
                                            this.engsel = 0;
                                        if (this.engsel < 0)
                                            this.engsel = 0;
                                        this.crashok = true;
                                    }
                                } catch (Exception exception) {
                                    this.crashok = false;
                                }
                            }
                        }
                        this.engon = false;
                    }
                    int i_95_ = -1;
                    if (this.pfase == 0) {
                        for (int i_96_ = 0; i_96_ < 4; i_96_++) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.xm > this.pnx[i_96_] && this.xm < 230 && this.ym > 433 + i_96_ * 24 && this.ym < 453 + i_96_ * 24) {
                                i_95_ = i_96_;
                                this.rd.setColor(new Color(176, 64, 0));
                                this.rd.drawLine(this.pnx[i_96_], 448 + i_96_ * 24, 128, 448 + i_96_ * 24);
                            }
                            this.rd.drawString(new StringBuilder().append("").append(this.pname[i_96_]).append(" :").toString(), this.pnx[i_96_], 447 + i_96_ * 24);
                            this.rd.drawLine(140, 443 + i_96_ * 24, 230, 443 + i_96_ * 24);
                            for (int i_97_ = 1; i_97_ < 10; i_97_++)
                                this.rd.drawLine(140 + 10 * i_97_, 443 - i_97_ + i_96_ * 24, 140 + 10 * i_97_, 443 + i_97_ + i_96_ * 24);
                            this.rd.setColor(new Color(255, 0, 0));
                            int i_98_ = (int) ((float) this.phys[i_96_] / 1.1111F / 10.0F);
                            this.rd.fillRect(138 + (int) ((float) this.phys[i_96_] / 1.1111F), 443 - i_98_ + i_96_ * 24, 5, i_98_ * 2 + 1);
                            this.rd.setColor(new Color(255, 128, 0));
                            this.rd.drawRect(139 + (int) ((float) this.phys[i_96_] / 1.1111F), 434 + i_96_ * 24, 2, 18);
                            stringbutton(" - ", 260, 447 + i_96_ * 24, 4, false);
                            stringbutton(" + ", 300, 447 + i_96_ * 24, 4, false);
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("<  Click on any variable name to learn about its function & use!", 333, 447);
                        stringbutton(" Random ", 380, 496, 0, false);
                        stringbutton(" Reset ", 455, 496, 0, false);
                        stringbutton("       Next  >       ", 570, 496, 0, true);
                    }
                    if (this.pfase == 1) {
                        for (int i_99_ = 0; i_99_ < 4; i_99_++) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.xm > this.pnx[i_99_ + 5] && this.xm < 211 && this.ym > 433 + i_99_ * 24 && this.ym < 453 + i_99_ * 24) {
                                i_95_ = i_99_ + 5;
                                this.rd.setColor(new Color(176, 64, 0));
                                this.rd.drawLine(this.pnx[i_99_ + 5], 448 + i_99_ * 24, 109, 448 + i_99_ * 24);
                            }
                            this.rd.drawString(new StringBuilder().append("").append(this.pname[i_99_ + 5]).append(" :").toString(), this.pnx[i_99_ + 5], 447 + i_99_ * 24);
                            this.rd.drawLine(121, 443 + i_99_ * 24, 211, 443 + i_99_ * 24);
                            for (int i_100_ = 1; i_100_ < 10; i_100_++)
                                this.rd.drawLine(121 + 10 * i_100_, 443 - i_100_ + i_99_ * 24, 121 + 10 * i_100_, 443 + i_100_ + i_99_ * 24);
                            this.rd.setColor(new Color(255, 0, 0));
                            int i_101_ = (int) ((float) this.phys[i_99_ + 5] / 1.1111F / 10.0F);
                            this.rd.fillRect(119 + (int) ((float) this.phys[i_99_ + 5] / 1.1111F), 443 - i_101_ + i_99_ * 24, 5, i_101_ * 2 + 1);
                            this.rd.setColor(new Color(255, 128, 0));
                            this.rd.drawRect(120 + (int) ((float) this.phys[i_99_ + 5] / 1.1111F), 434 + i_99_ * 24, 2, 18);
                            stringbutton(" - ", 241, 447 + i_99_ * 24, 4, false);
                            stringbutton(" + ", 281, 447 + i_99_ * 24, 4, false);
                        }
                        for (int i_102_ = 0; i_102_ < 2; i_102_++) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.xm > this.pnx[i_102_ + 9] && this.xm < 548 && this.ym > 433 + i_102_ * 24 && this.ym < 453 + i_102_ * 24) {
                                i_95_ = i_102_ + 9;
                                this.rd.setColor(new Color(176, 64, 0));
                                this.rd.drawLine(this.pnx[i_102_ + 9], 448 + i_102_ * 24, 446, 448 + i_102_ * 24);
                            }
                            this.rd.drawString(new StringBuilder().append("").append(this.pname[i_102_ + 9]).append(" :").toString(), this.pnx[i_102_ + 9], 447 + i_102_ * 24);
                            this.rd.drawLine(458, 443 + i_102_ * 24, 548, 443 + i_102_ * 24);
                            for (int i_103_ = 1; i_103_ < 10; i_103_++)
                                this.rd.drawLine(458 + 10 * i_103_, 443 - i_103_ + i_102_ * 24, 458 + 10 * i_103_, 443 + i_103_ + i_102_ * 24);
                            this.rd.setColor(new Color(255, 0, 0));
                            int i_104_ = (int) ((float) this.phys[i_102_ + 9] / 1.1111F / 10.0F);
                            this.rd.fillRect(456 + (int) ((float) this.phys[i_102_ + 9] / 1.1111F), 443 - i_104_ + i_102_ * 24, 5, i_104_ * 2 + 1);
                            this.rd.setColor(new Color(255, 128, 0));
                            this.rd.drawRect(457 + (int) ((float) this.phys[i_102_ + 9] / 1.1111F), 434 + i_102_ * 24, 2, 18);
                            stringbutton(" - ", 578, 447 + i_102_ * 24, 4, false);
                            stringbutton(" + ", 618, 447 + i_102_ * 24, 4, false);
                        }
                        stringbutton(" Random ", 361, 519, 0, false);
                        stringbutton(" Reset ", 436, 519, 0, false);
                        stringbutton(" <  Back ", 509, 519, 0, false);
                        stringbutton("       Next  >       ", 603, 519, 0, true);
                    }
                    if (this.pfase == 2) {
                        if (this.xm > 40 && this.xm < 670 && this.ym > 416 && this.ym < 436) {
                            i_95_ = 11;
                            this.rd.setColor(new Color(176, 64, 0));
                            this.rd.drawLine(596, 431, 669, 431);
                        }
                        this.rd.drawString("[   Crash Test,  Damage :                                       ]                                                     What is this?", 180, 430);
                        if (this.hitmag < 0)
                            this.hitmag = 0;
                        if (this.hitmag > 17000) {
                            this.crashok = true;
                            this.hitmag = 17000;
                            for (int i_105_ = 0; i_105_ < (this.o).npl; i_105_++) {
                                if ((((this.o).p[i_105_]).wz == 0 || ((this.o).p[i_105_]).gr == -17 || ((this.o).p[i_105_]).gr == -16) && ((this.o).p[i_105_]).embos == 0)
                                    ((this.o).p[i_105_]).embos = 1;
                            }
                        }
                        this.rd.setColor(new Color(255, (int) (250.0F - (float) this.hitmag / 68.0F), 0));
                        this.rd.fillRect(322, 423, (int) ((float) this.hitmag / 170.0F), 7);
                        this.rd.setColor(new Color(255, 0, 0));
                        this.rd.drawRect(322, 423, 100, 7);
                        if (i_95_ != 11)
                            this.rd.setColor(new Color(170, 170, 170));
                        else
                            this.rd.setColor(new Color(176, 64, 0));
                        this.rd.drawString("Normal Crash", 39, 438);
                        this.rd.drawString("Roof Crash", 501, 438);
                        this.rd.drawLine(125, 426, 179, 426);
                        this.rd.drawLine(125, 426, 125, 440);
                        this.rd.drawLine(491, 426, 437, 426);
                        this.rd.drawLine(491, 426, 491, 440);
                        this.rd.drawRect(19, 440, 276, 91);
                        this.rd.drawRect(339, 440, 312, 67);
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.xm > 50 && this.xm < 195 && this.ym > 446 && this.ym < 466) {
                            i_95_ = 12;
                            this.rd.setColor(new Color(176, 64, 0));
                            this.rd.drawLine(50, 461, 94, 461);
                        }
                        this.rd.drawString("Radius :", 50, 460);
                        this.rd.drawLine(105, 456, 195, 456);
                        for (int i_106_ = 1; i_106_ < 10; i_106_++)
                            this.rd.drawLine(105 + 10 * i_106_, 456 - i_106_, 105 + 10 * i_106_, 456 + i_106_);
                        this.rd.setColor(new Color(255, 0, 0));
                        int i_107_ = (int) ((float) this.crash[0] / 1.1111F / 10.0F);
                        this.rd.fillRect(103 + (int) ((float) this.crash[0] / 1.1111F), 456 - i_107_, 5, i_107_ * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(104 + (int) ((float) this.crash[0] / 1.1111F), 447, 2, 18);
                        stringbutton(" - ", 225, 460, 4, false);
                        stringbutton(" + ", 265, 460, 4, false);
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.xm > 30 && this.xm < 195 && this.ym > 470 && this.ym < 490) {
                            i_95_ = 13;
                            this.rd.setColor(new Color(176, 64, 0));
                            this.rd.drawLine(30, 485, 94, 485);
                        }
                        this.rd.drawString("Magnitude :", 30, 484);
                        this.rd.drawLine(105, 480, 195, 480);
                        for (int i_108_ = 1; i_108_ < 10; i_108_++)
                            this.rd.drawLine(105 + 10 * i_108_, 480 - i_108_, 105 + 10 * i_108_, 480 + i_108_);
                        this.rd.setColor(new Color(255, 0, 0));
                        i_107_ = (int) ((float) this.crash[1] / 1.1111F / 10.0F);
                        this.rd.fillRect(103 + (int) ((float) this.crash[1] / 1.1111F), 480 - i_107_, 5, i_107_ * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(104 + (int) ((float) this.crash[1] / 1.1111F), 471, 2, 18);
                        stringbutton(" - ", 225, 484, 4, false);
                        stringbutton(" + ", 265, 484, 4, false);
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.xm > 350 && this.xm < 551 && this.ym > 446 && this.ym < 466) {
                            i_95_ = 14;
                            this.rd.setColor(new Color(176, 64, 0));
                            this.rd.drawLine(350, 461, 450, 461);
                        }
                        this.rd.drawString("Roof Destruction :", 350, 460);
                        this.rd.drawLine(461, 456, 551, 456);
                        for (int i_109_ = 1; i_109_ < 10; i_109_++)
                            this.rd.drawLine(461 + 10 * i_109_, 456 - i_109_, 461 + 10 * i_109_, 456 + i_109_);
                        this.rd.setColor(new Color(255, 0, 0));
                        i_107_ = (int) ((float) this.crash[2] / 1.1111F / 10.0F);
                        this.rd.fillRect(459 + (int) ((float) this.crash[2] / 1.1111F), 456 - i_107_, 5, i_107_ * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(460 + (int) ((float) this.crash[2] / 1.1111F), 447, 2, 18);
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
                    if (this.pfase == 3) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Select the most suitable engine for your car :", 30, 440);
                        this.engine.move(293, 424);
                        if (!this.engine.isShowing()) {
                            this.engine.show();
                            this.engine.select(this.engsel);
                        }
                        if (this.engsel != this.engine.getSelectedIndex()) {
                            this.engsel = this.engine.getSelectedIndex();
                            for (int i_110_ = 0; i_110_ < 5; i_110_++) {
                                for (int i_111_ = 0; i_111_ < 5; i_111_++) {
                                    this.engs[i_111_][i_110_].stop();
                                    this.engs[i_111_][i_110_].checkopen();
                                }
                            }
                            this.engon = false;
                        }
                        if (this.engsel == 0)
                            this.rd.drawString("Normal Engine:  Like Tornado Shark, Sword of Justice or Radical One's engine.", 30, 470);
                        if (this.engsel == 1)
                            this.rd.drawString("V8 Engine:  High speed engine like Formula 7, Drifter X or Might Eight's engine.", 30, 470);
                        if (this.engsel == 2)
                            this.rd.drawString("Retro Engine:  Like Wow Caninaro, Lead Oxide or Kool Kat\u2019s engine.", 30, 470);
                        if (this.engsel == 3)
                            this.rd.drawString("Power Engine:  Turbo/super charged engine like Max Revenge, High Rider or Dr Monstaa\u2019s engine.", 30, 470);
                        if (this.engsel == 4)
                            this.rd.drawString("Diesel Engine:  Big diesel powered engine for big cars like EL King or  M A S H E E N .", 30, 470);
                        this.rd.drawString("LISTEN :", 30, 500);
                        stringbutton(" Idle ", 108, 500, 0, true);
                        stringbutton(" RPM 1 ", 170, 500, 0, true);
                        stringbutton(" RPM 2 ", 240, 500, 0, true);
                        stringbutton(" RPM 3 ", 310, 500, 0, true);
                        stringbutton(" RPM MAX ", 389, 500, 0, true);
                        if (this.engon)
                            stringbutton("          Stop Engine          ", 240, 535, 0, true);
                        else
                            stringbutton("          Stop Engine          ", 240, -2500, 0, true);
                        stringbutton(" <  Back ", 500, 525, 0, false);
                        stringbutton("     Save & Finish!     ", 610, 525, 0, true);
                    }
                    if (this.pfase == 4) {
                        this.rd.drawString("Testing & Setting up Physics...", 265, 470);
                        repaint();
                        try {
                            if (this.thredo != null) {
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
                                (this.o).xy = 0;
                                this.hitmag = 0;
                                int i_116_ = 0;
                                this.actmag = 0;
                                int i_117_ = i_113_;
                                boolean bool_118_ = false;
                                while (this.hitmag < 17000) {
                                    if (bool_118_)
                                        regx(i_117_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    else
                                        regz(i_117_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    if (++i_117_ == i_114_) {
                                        (this.o).xz += 45;
                                        (this.o).zy += 45;
                                        i_117_ = 0;
                                        if (bool_118_)
                                            bool_118_ = false;
                                        else
                                            bool_118_ = true;
                                        if (i_116_ == this.actmag)
                                            this.crash[0] += 10;
                                        i_116_ = this.actmag;
                                    }
                                }
                            }
                            float f = 0.0F;
                            for (int i_119_ = 0; i_119_ < 10; i_119_++) {
                                setupo();
                                (this.o).xy = 0;
                                this.actmag = 0;
                                this.hitmag = 0;
                                int i_120_ = i_113_;
                                boolean bool_121_ = false;
                                while (this.hitmag < 17000) {
                                    if (bool_121_)
                                        regx(i_120_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    else
                                        regz(i_120_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                    if (++i_120_ == i_114_) {
                                        (this.o).xz += 45;
                                        (this.o).zy += 45;
                                        i_120_ = 0;
                                        if (bool_121_)
                                            bool_121_ = false;
                                        else
                                            bool_121_ = true;
                                    }
                                }
                                f += (float) this.actmag / (float) this.hitmag;
                            }
                            f /= 10.0F;
                            this.actmag = (int) ((float) this.hitmag * f);
                            //if (this.stat[4] > 200)
                            //    this.stat[4] = 200;
                            if (this.stat[4] < 16)
                                this.stat[4] = 16;
                            float f_122_ = 0.9F + (float) (this.stat[4] - 90) * 0.01F;
                            if ((double) f_122_ < 0.6)
                                f_122_ = 0.6F;
                            if (this.stat[4] == 200 && this.stat[0] <= 88)
                                f_122_ = 3.0F;
                            int i_123_ = (int) ((float) this.actmag * f_122_);
                            for (int i_124_ = 0; i_124_ < 12; i_124_++) {
                                setupo();
                                (this.o).xy = 0;
                                (this.o).xz = 90 * i_124_;
                                if ((this.o).xz >= 360)
                                    (this.o).xz -= 360;
                                this.hitmag = 0;
                                int i_125_ = 0;
                                this.actmag = 0;
                                int i_126_ = i_113_;
                                boolean bool_127_ = false;
                                while (this.actmag < i_123_) {
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
                                        if (i_125_ == this.actmag)
                                            this.crash[0] += 10;
                                        i_125_ = this.actmag;
                                    }
                                }
                            }
                            if (i_112_ == 3) {
                                f = 0.0F;
                                for (int i_128_ = 0; i_128_ < 10; i_128_++) {
                                    setupo();
                                    (this.o).xy = 0;
                                    this.actmag = 0;
                                    this.hitmag = 0;
                                    int i_129_ = i_113_;
                                    boolean bool_130_ = false;
                                    while (this.hitmag < 17000) {
                                        if (bool_130_)
                                            regx(i_129_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                        else
                                            regz(i_129_, (float) (int) (150.0 + 600.0 * Math.random()), true);
                                        if (++i_129_ == i_114_) {
                                            (this.o).xz += 45;
                                            (this.o).zy += 45;
                                            i_129_ = 0;
                                            if (bool_130_)
                                                bool_130_ = false;
                                            else
                                                bool_130_ = true;
                                        }
                                    }
                                    f += (float) this.actmag / (float) this.hitmag;
                                }
                                f /= 10.0F;
                                this.actmag = (int) ((float) this.hitmag * f);
                            }
                        }
                        setupo();
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                        string_131_ = new StringBuilder().append(string_131_).append("\n\n\nphysics(").append(this.phys[0]).append(",").append(this.phys[1]).append(",").append(this.phys[2]).append(",").append(this.phys[3]).append(",").append(this.phys[4]).append(",").append(this.phys[5]).append(",").append(this.phys[6]).append(",").append(this.phys[7]).append(",").append(this.phys[8]).append(",").append(this.phys[9]).append(",").append(this.phys[10]).append(",").append(this.crash[0]).append(",").append(this.crash[1]).append(",").append(this.crash[2]).append(",").append(this.engsel).append(",").append(this.actmag).append(")\n\n\n\n").toString();
                        this.editor.setText(string_131_);
                        savefile();
                        for (int i_135_ = 0; i_135_ < 11; i_135_++)
                            this.rphys[i_135_] = this.phys[i_135_];
                        for (int i_136_ = 0; i_136_ < 3; i_136_++)
                            this.rcrash[i_136_] = this.crash[i_136_];
                        this.pfase = 5;
                    }
                    if (this.pfase == 5) {
                        this.rd.drawString("Car physics has been successfully set up!", 231, 450);
                        this.rd.drawString("Test drive your car to see the results...", 242, 490);
                    }
                    if (i_95_ != -1) {
                        if (this.mouseon == -1) {
                            this.mouseon = i_95_;
                            setCursor(new Cursor(12));
                        }
                    } else if (this.mouseon != -1) {
                        this.mouseon = -1;
                        setCursor(new Cursor(0));
                    }
                    if (this.mouses == -1 && i_95_ != -1)
                        JOptionPane.showMessageDialog(null, this.usage[i_95_], "Car Maker", 1);
                }
                if (this.dtab == 6) {
                    if (this.dtab != this.dtabed) {
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
                        int i_137_ = 0;
                        int i_138_ = string.indexOf("\n", 0);
                        while (i_138_ != -1 && i_137_ < string.length()) {
                            String string_139_ = string.substring(i_137_, i_138_);
                            string_139_ = string_139_.trim();
                            i_137_ = i_138_ + 1;
                            i_138_ = string.indexOf("\n", i_137_);
                            if (string_139_.startsWith("handling(")) {
                                try {
                                    this.handling = getvalue("handling", string_139_, 0);
                                    if (this.handling > 200)
                                        this.handling = 200;
                                    if (this.handling < 50)
                                        this.handling = 50;
                                } catch (Exception exception) {
                                    /* empty */
                                }
                            }
                        }
                        this.rateh = false;
                    }
                    if (!this.rateh) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Test Drive the Car", 350 - this.ftm.stringWidth("Test Drive the Car") / 2, 445);
                        this.witho.move(292, 455);
                        if (!this.witho.isShowing())
                            this.witho.show();
                        stringbutton("     TEST DRIVE!     ", 350, 505, 0, true);
                        if (this.tested) {
                            stringbutton("  Edit Stats & Class  ", 150, 471, 0, false);
                            stringbutton("  Edit Physics  ", 150, 505, 0, false);
                            stringbutton("     Rate Car Handling     ", 550, 471, 0, true);
                        }
                    } else {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(new StringBuilder().append("Based on you test drive(s), how do your rate ").append(this.carname).append("'s handling?").toString(), 350 - this.ftm.stringWidth(new StringBuilder().append("Based on your test drive(s), how do you rate ").append(this.carname).append("'s handling?").toString()) / 2, 445);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.rd.drawString("Handling :", 183, 483);
                        for (int i_140_ = 0; i_140_ < this.handling; i_140_++) {
                            this.rd.setColor(Color.getHSBColor((float) ((double) (float) i_140_ * 7.0E-4), 1.0F, 1.0F));
                            this.rd.drawLine(250 + i_140_, 474, 250 + i_140_, 482);
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawLine(249, 474, 249, 482);
                        this.rd.drawLine(450, 474, 450, 482);
                        this.rd.drawLine(249, 483, 450, 483);
                        for (int i_141_ = 0; i_141_ < 7; i_141_++)
                            this.rd.drawLine(275 + i_141_ * 25, 482, 275 + i_141_ * 25, 478);
                        stringbutton(" - ", 480, 483, 4, false);
                        stringbutton(" + ", 520, 483, 4, false);
                        stringbutton("       Save       ", 388, 525, 0, true);
                        stringbutton(" Cancel ", 298, 525, 0, false);
                    }
                }
                if (this.polynum >= 0 && this.cntpls > 0) {
                    for (int i_142_ = 0; i_142_ < (this.o).npl; i_142_++) {
                        if (i_142_ >= this.polynum && i_142_ < this.polynum + this.cntpls) {
                            if (this.pflk)
                                ((this.o).p[i_142_]).hsb[2] = 1.0F;
                            else {
                                ((this.o).p[i_142_]).hsb[2] = 0.0F;
                                ((this.o).p[i_142_]).hsb[0] = Math.abs(0.5F - ((this.o).p[i_142_]).hsb[0]);
                                while (((this.o).p[i_142_]).hsb[0] > 1.0F)
                                ((this.o).p[i_142_]).hsb[0]--;
                            }
                        } else if (this.prflk > 6 && this.prflk < 20)
                            ((this.o).p[i_142_]).gr = -13;
                        else
                            ((this.o).p[i_142_]).gr = 1;
                    }
                    if (this.pflk)
                        this.pflk = false;
                    else
                        this.pflk = true;
                    if (this.prflk < 40)
                        this.prflk++;
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(new StringBuilder().append("[ Showing ").append(this.cntpls).append(" Polygons Selected ]").toString(), 350 - this.ftm.stringWidth(new StringBuilder().append("[ Showing ").append(this.cntpls).append(" Polygons Selected ]").toString()) / 2, 45);
                    stringbutton("  Stop  ", 350, 67, 5, false);
                }
                i = 50;
                if (this.rotr) {
                    (this.o).xz -= 5;
                    i = 15;
                }
                if (this.rotl) {
                    (this.o).xz += 5;
                    i = 15;
                }
                if (this.left) {
                    (this.o).xy -= 5;
                    i = 15;
                }
                if (this.right) {
                    (this.o).xy += 5;
                    i = 15;
                }
                if (this.up) {
                    (this.o).zy -= 5;
                    i = 15;
                }
                if (this.down) {
                    (this.o).zy += 5;
                    i = 15;
                }
                if (this.plus) {
                    (this.o).y += 5;
                    i = 15;
                }
                if (this.minus) {
                    (this.o).y -= 5;
                    i = 15;
                }
                if (this.in) {
                    (this.o).z += 10;
                    i = 15;
                }
                if (this.out) {
                    (this.o).z -= 10;
                    i = 15;
                }
                this.ox = (this.o).x;
                this.oy = (this.o).y;
                this.oz = (this.o).z;
                this.oxz = (this.o).xz;
                this.oxy = (this.o).xy;
                this.ozy = (this.o).zy;
                if (this.dtabed != this.dtab)
                    this.dtabed = this.dtab;
                if (this.dtab == 5 && this.pfase == -1) {
                    repaint();
                    JOptionPane.showMessageDialog(null, "Car Wheels not defined or not defined correctly.\nBefore defining the car Physics car Wheels must be defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n", "Car Maker", 1);
                    this.dtab = 3;
                }
            }
            if (this.tab == 3) {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString(new StringBuilder().append("Publish Car :  [ ").append(this.carname).append(" ]").toString(), 30, 50);
                this.rd.drawString("Publishing Type :", 30, 80);
                this.pubtyp.move(150, 63);
                if (!this.pubtyp.isShowing()) {
                    this.pubtyp.show();
                    this.pubtyp.select(1);
                }
                stringbutton("       Publish  >       ", 102, 110, 0, true);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.setFont(new Font("Arial", 0, 12));
                if (this.pubtyp.getSelectedIndex() == 0) {
                    this.rd.drawString("Private :  This means only you can use your car and no one else can add", 268, 72);
                    this.rd.drawString("it to their account to play with it !", 268, 88);
                }
                if (this.pubtyp.getSelectedIndex() == 1) {
                    this.rd.drawString("Public :  This means anyone can add this car to their account to play with it,", 268, 72);
                    this.rd.drawString("but only you can download it to your Car Maker (no one else can get it\u2019s code).", 268, 88);
                }
                if (this.pubtyp.getSelectedIndex() == 2) {
                    this.rd.drawString("Super Public :  This means anyone can add this car to their account to play", 268, 72);
                    this.rd.drawString("with it and anyone can also download it to their Car Maker to get its code.", 268, 88);
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                this.rd.drawString("Car Name", 80 - this.ftm.stringWidth("Car Name") / 2, 138);
                this.rd.drawString("Car Class", 200 - this.ftm.stringWidth("Car Class") / 2, 138);
                this.rd.drawString("Created By", 300 - this.ftm.stringWidth("Created By") / 2, 138);
                this.rd.drawString("Added By", 400 - this.ftm.stringWidth("Added By") / 2, 138);
                this.rd.drawString("Publish Type", 500 - this.ftm.stringWidth("Publish Type") / 2, 138);
                this.rd.drawString("Options", 620 - this.ftm.stringWidth("Options") / 2, 138);
                this.rd.drawLine(150, 129, 150, 140);
                this.rd.drawLine(250, 129, 250, 140);
                this.rd.drawLine(350, 129, 350, 140);
                this.rd.drawLine(450, 129, 450, 140);
                this.rd.drawLine(550, 129, 550, 140);
                this.rd.drawRect(10, 140, 680, 402);
                if (this.logged == 0) {
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("The maximum number of cars your account can have at once is 20 cars.", 350 - this.ftm.stringWidth("The maximum number of cars your account can have at once is 20 cars.") / 2, 180);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Login to Retrieve your Account Cars", 350 - this.ftm.stringWidth("Login to Retrieve your Account Cars") / 2, 220);
                    this.rd.drawString("Nickname:", 326 - this.ftm.stringWidth("Nickname:") - 14, 266);
                    movefield(this.tnick, 326, 250, 129, 22);
                    if (!this.tnick.isShowing())
                        this.tnick.show();
                    this.rd.drawString("Password:", 326 - this.ftm.stringWidth("Password:") - 14, 296);
                    movefield(this.tpass, 326, 280, 129, 22);
                    if (!this.tpass.isShowing())
                        this.tpass.show();
                    stringbutton("       Login       ", 350, 340, 0, true);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Not registered yet?", 350 - this.ftm.stringWidth("Not registered yet?") / 2, 450);
                    stringbutton("   Register Now!   ", 350, 480, 0, true);
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Register to publish your cars to the multiplayer game!", 350 - this.ftm.stringWidth("Register to publish your cars to the multiplayer game!") / 2, 505);
                }
                if (this.logged == -1) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Account empty, no published cars found.", 350 - this.ftm.stringWidth("Account empty, no published cars found.") / 2, 220);
                    this.rd.drawString("Click \u2018Publish\u2019 above to begin.", 350 - this.ftm.stringWidth("Click \u2018Publish\u2019 above to begin.") / 2, 280);
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("The maximum number of cars your account can have at once is 20 cars.", 350 - this.ftm.stringWidth("The maximum number of cars your account can have at once is 20 cars.") / 2, 320);
                }
                if (this.logged == 2) {
                    for (int i_143_ = 0; i_143_ < this.nmc; i_143_++) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(50, 150, 600, 150);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(new StringBuilder().append("Loading ").append(this.mycars[i_143_]).append("\u2018s info...").toString(), 350 - this.ftm.stringWidth(new StringBuilder().append("Loading ").append(this.mycars[i_143_]).append("\u2018s info...").toString()) / 2, 220);
                        repaint();
                        this.maker[i_143_] = "Unkown";
                        this.pubt[i_143_] = -1;
                        this.clas[i_143_] = 0;
                        this.nad[i_143_] = 0;
                        String string = "";
                        try {
                            String string_144_ = new StringBuilder().append("http://multiplayer.needformadness.com/cars/").append(this.mycars[i_143_]).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
                            string_144_ = string_144_.replace(' ', '_');
                            URL url = new URL(string_144_);
                            DataInputStream datainputstream = new DataInputStream(url.openStream());
                            while ((string = datainputstream.readLine()) != null) {
                                string = new StringBuilder().append("").append(string.trim()).toString();
                                if (string.startsWith("details")) {
                                    this.maker[i_143_] = getSvalue("details", string, 0);
                                    this.pubt[i_143_] = getvalue("details", string, 1);
                                    this.clas[i_143_] = getvalue("details", string, 2);
                                    boolean bool_145_ = false;
                                    while (!bool_145_) {
                                        this.addeda[i_143_][this.nad[i_143_]] = getSvalue("details", string, 3 + this.nad[i_143_]);
                                        if (this.addeda[i_143_][this.nad[i_143_]].equals(""))
                                            bool_145_ = true;
                                        else
                                            this.nad[i_143_]++;
                                    }
                                }
                            }
                        } catch (Exception exception) {
                            /* empty */
                        }
                    }
                    setCursor(new Cursor(0));
                    this.logged = 3;
                }
                if (this.logged == 1) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Loading your account car list...", 350 - this.ftm.stringWidth("Loading your account car list...") / 2, 220);
                    repaint();
                    this.nmc = 0;
                    String string = "";
                    try {
                        URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/cars/lists/").append(this.tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                        DataInputStream datainputstream = new DataInputStream(url.openStream());
                        while ((string = datainputstream.readLine()) != null) {
                            string = new StringBuilder().append("").append(string.trim()).toString();
                            if (string.startsWith("mycars")) {
                                boolean bool_146_ = true;
                                while (bool_146_ && this.nmc < 20) {
                                    this.mycars[this.nmc] = getSvalue("mycars", string, this.nmc);
                                    if (this.mycars[this.nmc].equals(""))
                                        bool_146_ = false;
                                    else
                                        this.nmc++;
                                }
                            }
                        }
                        if (this.nmc > 0)
                            this.logged = 2;
                        else {
                            setCursor(new Cursor(0));
                            this.logged = -1;
                        }
                        datainputstream.close();
                    } catch (Exception exception) {
                        String string_147_ = new StringBuilder().append("").append(exception).toString();
                        if (string_147_.indexOf("FileNotFound") != -1) {
                            setCursor(new Cursor(0));
                            this.logged = -1;
                        } else {
                            this.logged = 0;
                            JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1);
                        }
                    }
                }
                if (this.logged == 3) {
                    for (int i_148_ = 0; i_148_ < this.nmc; i_148_++) {
                        this.rd.setColor(new Color(235, 235, 235));
                        if (this.xm > 11 && this.xm < 689 && this.ym > 142 + i_148_ * 20 && this.ym < 160 + i_148_ * 20)
                            this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(11, 142 + i_148_ * 20, 678, 18);
                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.mycars[i_148_], 80 - this.ftm.stringWidth(this.mycars[i_148_]) / 2, 156 + i_148_ * 20);
                        this.rd.setColor(new Color(155, 155, 155));
                        this.rd.drawLine(150, 145 + i_148_ * 20, 150, 157 + i_148_ * 20);
                        if (this.pubt[i_148_] != -1) {
                            this.rd.drawLine(250, 145 + i_148_ * 20, 250, 157 + i_148_ * 20);
                            this.rd.drawLine(350, 145 + i_148_ * 20, 350, 157 + i_148_ * 20);
                            this.rd.drawLine(450, 145 + i_148_ * 20, 450, 157 + i_148_ * 20);
                            this.rd.drawLine(550, 145 + i_148_ * 20, 550, 157 + i_148_ * 20);
                            this.rd.setColor(new Color(0, 0, 64));
                            String string = "C";
                            if (this.clas[i_148_] == 1)
                                string = "B & C";
                            if (this.clas[i_148_] == 2)
                                string = "B";
                            if (this.clas[i_148_] == 3)
                                string = "A & B";
                            if (this.clas[i_148_] == 4)
                                string = "A";
                            this.rd.drawString(new StringBuilder().append("Class ").append(string).append("").toString(), 200 - this.ftm.stringWidth(new StringBuilder().append("Class ").append(string).append("").toString()) / 2, 156 + i_148_ * 20);
                            boolean bool_149_ = false;
                            if (this.maker[i_148_].toLowerCase().equals(this.tnick.getText().toLowerCase())) {
                                bool_149_ = true;
                                this.rd.setColor(new Color(0, 64, 0));
                                this.rd.drawString("You", 300 - this.ftm.stringWidth("You") / 2, 156 + i_148_ * 20);
                            } else
                                this.rd.drawString(this.maker[i_148_], 300 - this.ftm.stringWidth(this.maker[i_148_]) / 2, 156 + i_148_ * 20);
                            if (this.nad[i_148_] > 1) {
                                if (ovbutton(new StringBuilder().append("").append(this.nad[i_148_]).append(" Players").toString(), 400, 156 + i_148_ * 20)) {
                                    String string_150_ = new StringBuilder().append("[ ").append(this.mycars[i_148_]).append(" ]  has been added by the following players to their accounts:     \n\n").toString();
                                    int i_151_ = 0;
                                    for (int i_152_ = 0; i_152_ < this.nad[i_148_]; i_152_++) {
                                        if (++i_151_ == 17) {
                                            string_150_ = new StringBuilder().append(string_150_).append("\n").toString();
                                            i_151_ = 1;
                                        }
                                        string_150_ = new StringBuilder().append(string_150_).append(this.addeda[i_148_][i_152_]).toString();
                                        if (i_152_ != this.nad[i_148_] - 1) {
                                            if (i_152_ != this.nad[i_148_] - 2)
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
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("None", 400 - this.ftm.stringWidth("None") / 2, 156 + i_148_ * 20);
                            }
                            if (this.pubt[i_148_] == 0) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("Private", 500 - this.ftm.stringWidth("Private") / 2, 156 + i_148_ * 20);
                            }
                            if (this.pubt[i_148_] == 1) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("Public", 500 - this.ftm.stringWidth("Public") / 2, 156 + i_148_ * 20);
                            }
                            if (this.pubt[i_148_] == 2) {
                                this.rd.setColor(new Color(0, 64, 0));
                                this.rd.drawString("Super Public", 500 - this.ftm.stringWidth("Super Public") / 2, 156 + i_148_ * 20);
                            }
                            if ((this.pubt[i_148_] == 2 || bool_149_) && ovbutton("Download", 600, 156 + i_148_ * 20)) {
                                int i_153_ = 0;
                                for (int i_154_ = 0; i_154_ < this.slcar.getItemCount(); i_154_++) {
                                    if (this.mycars[i_148_].equals(this.slcar.getItem(i_154_)))
                                        i_153_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Replace the local ").append(this.mycars[i_148_]).append(" in your 'mycars' folder with the published online copy?").toString(), "Car Maker", 0);
                                }
                                if (i_153_ == 0) {
                                    setCursor(new Cursor(3));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(225, 225, 225));
                                    this.rd.fillRect(11, 141, 679, 401);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Downloading car, please wait...", 350 - this.ftm.stringWidth("Downloading car, please wait...") / 2, 250);
                                    repaint();
                                    try {
                                        String string_155_ = new StringBuilder().append("http://multiplayer.needformadness.com/cars/").append(this.mycars[i_148_]).append(".radq?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
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
                                            file = new File(new StringBuilder().append("mycars/").append(this.mycars[i_148_]).append(".rad").toString());
                                            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                            bufferedwriter.write(string_165_);
                                            bufferedwriter.close();
                                            Object object = null;
                                            zipinputstream.close();
                                            if (this.carname.equals(this.mycars[i_148_])) {
                                                this.editor.setText(string_165_);
                                                this.lastedo = string_165_;
                                            }
                                            setCursor(new Cursor(0));
                                            JOptionPane.showMessageDialog(null, new StringBuilder().append("").append(this.mycars[i_148_]).append(" has been successfully downloaded!").toString(), "Car Maker", 1);
                                        } else
                                            JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                                    } catch (Exception exception) {
                                        JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1);
                                    }
                                }
                            }
                        } else
                            this.rd.drawString("-    Error Loading this car's info!    -", 350 - this.ftm.stringWidth("-    Error Loading this car's info!    -") / 2, 156 + i_148_ * 20);
                        if (ovbutton("X", 665, 156 + i_148_ * 20) && JOptionPane.showConfirmDialog(null, new StringBuilder().append("Remove ").append(this.mycars[i_148_]).append(" from your account?").toString(), "Car Maker", 0) == 0) {
                            setCursor(new Cursor(3));
                            int i_169_ = -1;
                            try {
                                Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                                printwriter.println(new StringBuilder().append("9|").append(this.tnick.getText()).append("|").append(this.tpass.getText()).append("|").append(this.mycars[i_148_]).append("|").toString());
                                String string = bufferedreader.readLine();
                                if (string != null)
                                    i_169_ = servervalue(string, 0);
                                socket.close();
                            } catch (Exception exception) {
                                i_169_ = -1;
                            }
                            if (i_169_ == 0)
                                this.logged = 1;
                            else {
                                setCursor(new Cursor(0));
                                JOptionPane.showMessageDialog(null, new StringBuilder().append("Failed to remove ").append(this.mycars[i_148_]).append(" from your account.  Unknown Error!     \nPlease try again later.").toString(), "Car Maker", 1);
                            }
                        }
                    }
                }
            }
            if (this.tabed != this.tab)
                this.tabed = this.tab;
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 700, 25);
            if (!this.onbtgame)
                this.rd.drawImage(this.btgame[0], 520, 0, null);
            else
                this.rd.drawImage(this.btgame[1], 520, 0, null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            String[] strings = { "Car", "Code Edit", "3D Edit", "Publish" };
            int[] is = { 0, 0, 100, 90 };
            int[] is_170_ = { 0, 25, 25, 0 };
            int i_171_ = 4;
            if (this.carname.equals("") || !this.loadedfile || this.sfase != 0) {
                this.tab = 0;
                i_171_ = 1;
            }
            for (int i_172_ = 0; i_172_ < i_171_; i_172_++) {
                this.rd.setColor(new Color(170, 170, 170));
                if (this.xm > is[0] && this.xm < is[3] && this.ym > 0 && this.ym < 25)
                    this.rd.setColor(new Color(200, 200, 200));
                if (this.tab == i_172_)
                    this.rd.setColor(new Color(225, 225, 225));
                this.rd.fillPolygon(is, is_170_, 4);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString(strings[i_172_], i_172_ * 100 + 45 - this.ftm.stringWidth(strings[i_172_]) / 2, 17);
                if (this.xm > is[0] && this.xm < is[3] && this.ym > 0 && this.ym < 25 && this.mouses == -1) {
                    if (this.tab != i_172_ && this.tab == 1)
                        savefile();
                    this.tab = i_172_;
                }
                for (int i_173_ = 0; i_173_ < 4; i_173_++)
                    is[i_173_] += 100;
            }
            drawms();
            ctachm();
            repaint();
            if (!this.exwist) {
                try {
                    if (this.thredo != null) {
                        /* empty */
                    }
                    Thread.sleep((long) i);
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
            }
        }
        this.rd.dispose();
        System.gc();
    }
    
    public void ctachm() {
        int i = -1;
        for (int i_174_ = 0; i_174_ < this.btn; i_174_++) {
            if (Math.abs(this.xm - this.bx[i_174_]) < this.bw[i_174_] / 2 + 12 && Math.abs(this.ym - this.by[i_174_]) < 14 && this.mouses == 1)
                this.pessd[i_174_] = true;
            else
                this.pessd[i_174_] = false;
            if (Math.abs(this.xm - this.bx[i_174_]) < this.bw[i_174_] / 2 + 12 && Math.abs(this.ym - this.by[i_174_]) < 14 && this.mouses == -1)
                i = i_174_;
        }
        if (this.mouses == -1)
            this.mouses = 0;
        if (this.tab == 0) {
            if (this.sfase == 0) {
                if (i == 0) {
                    this.sfase = 1;
                    i = -1;
                    hidefields();
                }
                if (i == 1) {
                    if (!this.carname.equals("")) {
                        this.srch.setText(this.carname);
                        this.sfase = 2;
                        i = -1;
                        hidefields();
                    } else
                        JOptionPane.showMessageDialog(null, "Please Select a Car to Rename!\n", "Car Maker", 1);
                }
                if (i == 2)
                    delcar(this.carname);
                if (i == 3) {
                    this.sfase = 3;
                    i = -1;
                    hidefields();
                }
            }
            if (this.sfase == 1) {
                if (i == 0) {
                    newcar(this.srch.getText());
                    i = -1;
                }
                if (i == 1) {
                    this.srch.setText("");
                    this.sfase = 0;
                    i = -1;
                    hidefields();
                }
            }
            if (this.sfase == 2) {
                if (i == 0) {
                    rencar(this.srch.getText());
                    i = -1;
                }
                if (i == 1) {
                    this.srch.setText("");
                    this.sfase = 0;
                    i = -1;
                    hidefields();
                }
            }
            if (this.sfase == 3) {
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
                        if (this.tutok)
                            i_175_ = -70;
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(116, 246 + i_175_, 468, 50);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString(new StringBuilder().append("Reading ").append(file.getName()).append(", please wait...").toString(), 350 - this.ftm.stringWidth(new StringBuilder().append("Reading ").append(file.getName()).append(", please wait...").toString()) / 2, 276 + i_175_);
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
                                Object object = null;
                                boolean bool = false;
                                boolean bool_182_ = false;
                                String string;
                                while ((string = bufferedreader.readLine()) != null) {
                                    if (string.startsWith("v ")) {
                                        if (i_178_ < 6000) {
                                            this.multf10 = true;
                                            is[i_178_] = objvalue(string, 0);
                                            is_176_[i_178_] = objvalue(string, 1);
                                            is_177_[i_178_] = objvalue(string, 2);
                                            i_178_++;
                                        } else
                                            bool = true;
                                    }
                                    if (string.startsWith("f ")) {
                                        if (i_181_ < 600) {
                                            this.multf10 = false;
                                            this.objfacend = false;
                                            for (is_180_[i_181_] = 0; !this.objfacend && is_180_[i_181_] < 100; is_180_[i_181_]++)
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
                                Object object_183_ = null;
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to load file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
                            }
                            this.rd.setColor(new Color(225, 225, 225));
                            this.rd.fillRect(116, 246 + i_175_, 468, 50);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString(new StringBuilder().append("Importing ").append(file.getName()).append(", please wait...").toString(), 350 - this.ftm.stringWidth(new StringBuilder().append("Importing ").append(file.getName()).append(", please wait...").toString()) / 2, 276 + i_175_);
                            repaint();
                            this.carname = file.getName();
                            if (this.carname.endsWith(".obj"))
                                this.carname = this.carname.substring(0, this.carname.length() - 4);
                            String string = new StringBuilder().append("\n// imported car: ").append(this.carname).append("\n---------------------\n\n// Please read the helpful information about importing cars found at:\n// http://www.needformadness.com/developer/extras.html\n\n\n").toString();
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
                            file = new File(new StringBuilder().append("mycars/").append(this.carname).append(".rad").toString());
                            int i_187_ = 0;
                            if (file.exists())
                                i_187_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Another car with the name '").append(this.carname).append("' already exists, replace it?      \n").toString(), "Car Maker", 0);
                            if (i_187_ == 0) {
                                try {
                                    BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                    bufferedwriter.write(string);
                                    bufferedwriter.close();
                                    Object object = null;
                                    if (file.exists()) {
                                        this.sfase = 0;
                                        hidefields();
                                        this.tabed = -1;
                                    } else {
                                        this.carname = "";
                                        JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
                                    }
                                } catch (Exception exception) {
                                    this.carname = "";
                                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to create file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
                                }
                            }
                        } else
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error, ").append(file.getName()).append(" was not found!").toString(), "Car Maker", 1);
                        setCursor(new Cursor(0));
                    }
                }
                if (i == 1) {
                    this.sfase = 4;
                    i = -1;
                }
                if (i == 2) {
                    this.sfase = 0;
                    i = -1;
                }
            }
            if (this.sfase == 4) {
                if (i == 0) {
                    File file = null;
                    FileDialog filedialog = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
                    filedialog.setFile(new StringBuilder().append("").append(this.carname).append(".obj").toString());
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
                            for (int i_192_ = 0; i_192_ < (this.o).npl; i_192_++) {
                                for (int i_193_ = 0; i_193_ < ((this.o).p[i_192_]).n; i_193_++) {
                                    boolean bool = false;
                                    for (int i_194_ = 0; i_194_ < i_191_; i_194_++) {
                                        if (is[i_194_] == ((this.o).p[i_192_]).ox[i_193_] && is_189_[i_194_] == ((this.o).p[i_192_]).oy[i_193_] && is_190_[i_194_] == ((this.o).p[i_192_]).oz[i_193_])
                                            bool = true;
                                    }
                                    if (!bool && i_191_ < 6000) {
                                        is[i_191_] = ((this.o).p[i_192_]).ox[i_193_];
                                        is_189_[i_191_] = ((this.o).p[i_192_]).oy[i_193_];
                                        is_190_[i_191_] = ((this.o).p[i_192_]).oz[i_193_];
                                        i_191_++;
                                    }
                                }
                            }
                            for (int i_195_ = 0; i_195_ < i_191_; i_195_++)
                                string = new StringBuilder().append(string).append("v ").append((float) is[i_195_] / 10.0F).append(" ").append((float) -is_189_[i_195_] / 10.0F).append(" ").append((float) is_190_[i_195_] / 10.0F).append("\n").toString();
                            for (int i_196_ = 0; i_196_ < (this.o).npl; i_196_++) {
                                if (((this.o).p[i_196_]).wz == 0) {
                                    string = new StringBuilder().append(string).append("f").toString();
                                    for (int i_197_ = 0; i_197_ < ((this.o).p[i_196_]).n; i_197_++) {
                                        string = new StringBuilder().append(string).append(" ").toString();
                                        for (int i_198_ = 0; i_198_ < i_191_; i_198_++) {
                                            if (is[i_198_] == ((this.o).p[i_196_]).ox[i_197_] && is_189_[i_198_] == ((this.o).p[i_196_]).oy[i_197_] && is_190_[i_198_] == ((this.o).p[i_196_]).oz[i_197_])
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
                                Object object = null;
                                if (file.exists()) {
                                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Car has been successfully exported to:\n").append(file.getAbsolutePath()).append("          \n \n").toString(), "Car Maker", 1);
                                    this.sfase = 0;
                                    hidefields();
                                    this.tabed = -1;
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
                    this.sfase = 0;
                    i = -1;
                }
            }
        }
        if (this.tab == 1) {
            if (i == 0) {
                if (this.prefs)
                    this.prefs = false;
                else
                    this.prefs = true;
            }
            if (i == 1 || i == 2) {
                savefile();
                if (i == 2)
                    this.tab = 2;
            }
            if (!this.mirror) {
                boolean bool = false;
                if (i == 4) {
                    if (this.sls != -1 && this.sle != -1 && this.editor.getSelectedText().equals(this.srch.getText())) {
                        this.editor.replaceText(this.rplc.getText(), this.sls, this.sle);
                        this.sls = -1;
                        this.sle = -1;
                        bool = true;
                        try {
                            if (this.thredo != null) {
                                /* empty */
                            }
                            Thread.sleep(100L);
                        } catch (InterruptedException interruptedexception) {
                            /* empty */
                        }
                    }
                    i = 3;
                }
                if (i == 3 && !this.srch.getText().equals("")) {
                    this.editor.requestFocus();
                    this.sls = this.editor.getText().indexOf(this.srch.getText(), this.editor.getSelectionEnd());
                    if (this.sls != -1) {
                        this.sle = this.sls + this.srch.getText().length();
                        this.editor.select(this.sls, this.sle);
                    } else if (!bool)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("Cannot find  '").append(this.srch.getText()).append("'  from Cursor position    ").toString(), "Car Maker", 1);
                }
            } else {
                if (i == 3 || i == 4 || i == 5) {
                    String string = new StringBuilder().append("").append(this.editor.getSelectedText()).append("\n").toString();
                    String string_199_ = "\n\n";
                    if (this.cntpls == 1)
                        string_199_ = new StringBuilder().append(string_199_).append("// Mirror of the polygon above along the ").toString();
                    else
                        string_199_ = new StringBuilder().append(string_199_).append("// Mirror of the ").append(this.cntpls).append(" polygons above along the ").toString();
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
                    this.editor.insertText(string_199_, this.editor.getSelectionEnd());
                }
                if (i == 6) {
                    this.polynum = 0;
                    int i_205_ = this.editor.getText().lastIndexOf("</p>", this.editor.getSelectionStart());
                    boolean bool = false;
                    for (/**/; i_205_ >= 0; i_205_--) {
                        if (!bool) {
                            i_205_ = this.editor.getText().lastIndexOf("<p>", i_205_);
                            if (i_205_ != -1) {
                                bool = true;
                                this.polynum++;
                            }
                        } else {
                            i_205_ = this.editor.getText().lastIndexOf("</p>", i_205_);
                            if (i_205_ != -1)
                                bool = false;
                        }
                    }
                    this.prflk = 0;
                    this.tab = 2;
                }
            }
            i = -1;
        }
        if (this.tab == 2) {
            int i_206_ = 0;
            if (this.dtab == 1) {
                if ((this.o).colok != 2) {
                    if (i == 0) {
                        JOptionPane.showMessageDialog(null, "Car Maker will attempt now to find the first and second colors automatically.\nPlease make sure that they are the correct colors!\n\nPlease note that these are also the colors that will be editable in the multiplayer game.      ", "Car Maker", 1);
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                        int i_214_ = this.editor.getText().indexOf("<p>", 0);
                        this.editor.insertText(string_210_, i_214_);
                        this.editor.select(i_214_, i_214_ + string_210_.length() - 2);
                        this.breakbond = true;
                        this.tab = 1;
                    }
                    i_206_ = 1;
                } else {
                    if (i == 0) {
                        this.ofcol = new StringBuilder().append("(").append((this.o).fcol[0]).append(",").append((this.o).fcol[1]).append(",").append((this.o).fcol[2]).append(")").toString();
                        int i_215_ = this.editor.getText().indexOf(this.ofcol, 0);
                        int i_216_ = i_215_;
                        for (/**/; i_215_ != -1; i_215_ = this.editor.getText().indexOf(this.ofcol, i_215_ + 1))
                            this.editor.replaceText(this.fcol, i_215_, i_215_ + this.ofcol.length());
                        this.ofcol = this.fcol;
                        this.editor.select(i_216_ - 8, i_216_ - 8);
                        savefile();
                        (this.o).fcol[0] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getRed();
                        (this.o).fcol[1] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getGreen();
                        (this.o).fcol[2] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getBlue();
                    }
                    if (i == 1) {
                        this.oscol = new StringBuilder().append("(").append((this.o).scol[0]).append(",").append((this.o).scol[1]).append(",").append((this.o).scol[2]).append(")").toString();
                        int i_217_ = this.editor.getText().indexOf(this.oscol, 0);
                        int i_218_ = i_217_;
                        for (/**/; i_217_ != -1; i_217_ = this.editor.getText().indexOf(this.oscol, i_217_ + 1))
                            this.editor.replaceText(this.scol, i_217_, i_217_ + this.oscol.length());
                        this.oscol = this.scol;
                        this.editor.select(i_218_ - 8, i_218_ - 8);
                        savefile();
                        (this.o).scol[0] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getRed();
                        (this.o).scol[1] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getGreen();
                        (this.o).scol[2] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getBlue();
                    }
                    i_206_ = 2;
                }
            }
            if (this.dtab == 2) {
                if (i == 9) {
                    this.scale[0] = 100;
                    this.scale[1] = 100;
                    this.scale[2] = 100;
                }
                if (i == 0 || i == 1 || i == 6 || i == 7 || i == 9) {
                    if (i == 0 || i == 6)
                        this.scale[0] -= 5;
                    if (i == 1 || i == 7)
                        this.scale[0] += 5;
                    if (this.scale[0] < 0)
                        this.scale[0] = 0;
                    int i_219_ = this.editor.getText().indexOf("\nScaleX(", 0);
                    if (i_219_ != -1) {
                        i_219_++;
                        int i_220_ = this.editor.getText().indexOf(")", i_219_);
                        int i_221_ = this.editor.getText().indexOf("\n", i_219_);
                        if (i_221_ > i_220_)
                            this.editor.replaceText(new StringBuilder().append("ScaleX(").append(this.scale[0]).append(")").toString(), i_219_, i_220_ + 1);
                        else
                            this.editor.replaceText(new StringBuilder().append("ScaleX(").append(this.scale[0]).append(")").toString(), i_219_, i_221_);
                    } else {
                        int i_222_ = this.editor.getText().indexOf("<p>", 0);
                        int i_223_ = this.editor.getText().indexOf("\nScale", 0);
                        if (i_223_ < i_222_ && i_223_ != -1)
                            this.editor.insertText(new StringBuilder().append("\nScaleX(").append(this.scale[0]).append(")").toString(), i_223_);
                        else
                            this.editor.insertText(new StringBuilder().append("ScaleX(").append(this.scale[0]).append(")\n\n\n").toString(), i_222_);
                    }
                }
                if (i == 2 || i == 3 || i == 6 || i == 7 || i == 9) {
                    if (i == 2 || i == 6)
                        this.scale[1] -= 5;
                    if (i == 3 || i == 7)
                        this.scale[1] += 5;
                    if (this.scale[1] < 0)
                        this.scale[1] = 0;
                    int i_224_ = this.editor.getText().indexOf("\nScaleY(", 0);
                    if (i_224_ != -1) {
                        i_224_++;
                        int i_225_ = this.editor.getText().indexOf(")", i_224_);
                        int i_226_ = this.editor.getText().indexOf("\n", i_224_);
                        if (i_226_ > i_225_)
                            this.editor.replaceText(new StringBuilder().append("ScaleY(").append(this.scale[1]).append(")").toString(), i_224_, i_225_ + 1);
                        else
                            this.editor.replaceText(new StringBuilder().append("ScaleY(").append(this.scale[1]).append(")").toString(), i_224_, i_226_);
                    } else {
                        int i_227_ = this.editor.getText().indexOf("<p>", 0);
                        int i_228_ = this.editor.getText().indexOf("\nScale", 0);
                        if (i_228_ < i_227_ && i_228_ != -1)
                            this.editor.insertText(new StringBuilder().append("\nScaleY(").append(this.scale[1]).append(")").toString(), i_228_);
                        else
                            this.editor.insertText(new StringBuilder().append("ScaleY(").append(this.scale[1]).append(")\n\n\n").toString(), i_227_);
                    }
                }
                if (i == 4 || i == 5 || i == 6 || i == 7 || i == 9) {
                    if (i == 4 || i == 6)
                        this.scale[2] -= 5;
                    if (i == 5 || i == 7)
                        this.scale[2] += 5;
                    if (this.scale[2] < 0)
                        this.scale[2] = 0;
                    int i_229_ = this.editor.getText().indexOf("\nScaleZ(", 0);
                    if (i_229_ != -1) {
                        i_229_++;
                        int i_230_ = this.editor.getText().indexOf(")", i_229_);
                        int i_231_ = this.editor.getText().indexOf("\n", i_229_);
                        if (i_231_ > i_230_)
                            this.editor.replaceText(new StringBuilder().append("ScaleZ(").append(this.scale[2]).append(")").toString(), i_229_, i_230_ + 1);
                        else
                            this.editor.replaceText(new StringBuilder().append("ScaleZ(").append(this.scale[2]).append(")").toString(), i_229_, i_231_);
                    } else {
                        int i_232_ = this.editor.getText().indexOf("<p>", 0);
                        int i_233_ = this.editor.getText().indexOf("\nScale", 0);
                        if (i_233_ < i_232_ && i_233_ != -1)
                            this.editor.insertText(new StringBuilder().append("\nScaleZ(").append(this.scale[2]).append(")").toString(), i_233_);
                        else
                            this.editor.insertText(new StringBuilder().append("ScaleZ(").append(this.scale[2]).append(")\n\n\n").toString(), i_232_);
                    }
                }
                if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 9)
                    setupo();
                if (i == 8) {
                    savefile();
                    this.oscale[0] = this.scale[0];
                    this.oscale[1] = this.scale[1];
                    this.oscale[2] = this.scale[2];
                }
                if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18) {
                    try {
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                        this.editor.setText(string_234_);
                        setupo();
                        this.changed2 = true;
                    } catch (Exception exception) {
                        /* empty */
                    }
                }
                if (i == 19) {
                    this.editor.setText(this.lastedo);
                    setupo();
                    this.changed2 = false;
                }
                if (i == 20 && this.changed2) {
                    int i_247_ = JOptionPane.showConfirmDialog(null, "Saving now will permanently change the point locations & numbers entered in the code!      \n\nContinue?", "Car Maker", 0);
                    if (i_247_ == 0) {
                        this.editor.setText(new StringBuilder().append(this.editor.getText().trim()).append("\n\n\n\n").toString());
                        savefile();
                        this.changed2 = false;
                    }
                }
                i_206_ = 21;
            }
            if (this.dtab == 3) {
                if (i == 0 || i == 2 || this.defnow) {
                    if (this.defnow) {
                        this.defnow = false;
                        repaint();
                        JOptionPane.showMessageDialog(null, "Car Maker will setup default Front and Back Wheels positions and adjustments.\n\nEnter the desired positions and adjustments then press ' Apply ' to view!\nDon't forget to press ' Save ' when finished!", "Car Maker", 1);
                    }
                    int i_248_ = 0;
                    try {
                        int i_249_ = Float.valueOf(this.wv[10].getText()).intValue();
                        if (i_249_ <= 0)
                            i_248_ = 1;
                        i_249_ = Float.valueOf(this.wv[2].getText()).intValue();
                        if (i_249_ >= 0)
                            i_248_ = 2;
                        i_249_ = Float.valueOf(this.wv[8].getText()).intValue();
                        if (i_249_ <= 0)
                            i_248_ = 3;
                        i_249_ = Float.valueOf(this.wv[0].getText()).intValue();
                        if (i_249_ <= 0)
                            i_248_ = 4;
                        i_249_ = Float.valueOf(this.wv[15].getText()).intValue();
                        if (i_249_ > 40)
                            this.wv[15].setText("40");
                        if (i_249_ < -40)
                            this.wv[15].setText("-40");
                        i_249_ = Float.valueOf(this.wv[7].getText()).intValue();
                        if (i_249_ > 40)
                            this.wv[7].setText("40");
                        if (i_249_ < -40)
                            this.wv[7].setText("-40");
                    } catch (Exception exception) {
                        /* empty */
                    }
                    if (i_248_ == 1)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("ERROR:\nThe Z location value of the FRONT Wheels must be greater then zero! (it should have a +ve value)\nZ :  '").append(this.wv[10].getText()).append("'  is less or equal to zero, where it should have +ve value!").toString(), "Car Maker", 1);
                    if (i_248_ == 2)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("ERROR:\nThe Z location value of the BACK Wheels must be smaller then zero! (it should have a -ve value)\nZ :  '").append(this.wv[2].getText()).append("'  is bigger or equal to zero, where it should have -ve value!").toString(), "Car Maker", 1);
                    if (i_248_ == 3)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("ERROR:\nThe \u00b1X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n\u00b1X :  '").append(this.wv[8].getText()).append("'  is less or equal to zero, where it should have +ve value!").toString(), "Car Maker", 1);
                    if (i_248_ == 4)
                        JOptionPane.showMessageDialog(null, new StringBuilder().append("ERROR:\nThe \u00b1X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n\u00b1X :  '").append(this.wv[0].getText()).append("'  is less or equal to zero, whenr it should have +ve value!").toString(), "Car Maker", 1);
                    if (i_248_ == 0) {
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                        string_250_ = new StringBuilder().append(string_250_).append("\n\n\ngwgr(").append(this.wv[15].getText()).append(")\n").toString();
                        String string_254_ = "140,140,140";
                        if (this.rplc.getText().startsWith("(") && this.rplc.getText().endsWith(")"))
                            string_254_ = this.rplc.getText().substring(1, this.rplc.getText().length() - 1);
                        string_250_ = new StringBuilder().append(string_250_).append("rims(").append(string_254_).append(",").append(this.wv[13].getText()).append(",").append(this.wv[14].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("w(-").append(this.wv[8].getText()).append(",").append(this.wv[9].getText()).append(",").append(this.wv[10].getText()).append(",11,").append(this.wv[12].getText()).append(",").append(this.wv[11].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("w(").append(this.wv[8].getText()).append(",").append(this.wv[9].getText()).append(",").append(this.wv[10].getText()).append(",11,-").append(this.wv[12].getText()).append(",").append(this.wv[11].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("\ngwgr(").append(this.wv[7].getText()).append(")\n").toString();
                        string_254_ = "140,140,140";
                        if (this.srch.getText().startsWith("(") && this.srch.getText().endsWith(")"))
                            string_254_ = this.srch.getText().substring(1, this.srch.getText().length() - 1);
                        string_250_ = new StringBuilder().append(string_250_).append("rims(").append(string_254_).append(",").append(this.wv[5].getText()).append(",").append(this.wv[6].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("w(-").append(this.wv[0].getText()).append(",").append(this.wv[1].getText()).append(",").append(this.wv[2].getText()).append(",0,").append(this.wv[4].getText()).append(",").append(this.wv[3].getText()).append(")\n").toString();
                        string_250_ = new StringBuilder().append(string_250_).append("w(").append(this.wv[0].getText()).append(",").append(this.wv[1].getText()).append(",").append(this.wv[2].getText()).append(",0,-").append(this.wv[4].getText()).append(",").append(this.wv[3].getText()).append(")\n\n\n\n").toString();
                        this.editor.setText(string_250_);
                        this.forwheels = true;
                        setupo();
                        this.forwheels = false;
                        this.aply1 = new StringBuilder().append("").append(this.wv[0].getText()).append("").append(this.wv[1].getText()).append("").append(this.wv[2].getText()).append("").append(this.wv[3].getText()).append("").append(this.wv[4].getText()).append("").append(this.srch.getText()).append("").append(this.wv[5].getText()).append("").append(this.wv[6].getText()).append("").append(this.wv[7].getText()).append("").toString();
                        this.aply2 = new StringBuilder().append("").append(this.wv[8].getText()).append("").append(this.wv[9].getText()).append("").append(this.wv[10].getText()).append("").append(this.wv[11].getText()).append("").append(this.wv[12].getText()).append("").append(this.rplc.getText()).append("").append(this.wv[13].getText()).append("").append(this.wv[14].getText()).append("").append(this.wv[15].getText()).append("").toString();
                        this.aplyd1 = false;
                        this.aplyd2 = false;
                        this.changed2 = true;
                    }
                }
                if (i == 1 || i == 3) {
                    if (!(this.o).errd) {
                        savefile();
                        this.changed2 = false;
                    } else
                        JOptionPane.showMessageDialog(null, "Unable to Save, press  [ Apply ]  to find out why!", "Car Maker", 1);
                }
                i_206_ = 4;
            }
            if (this.dtab == 4) {
                if (!this.statdef) {
                    if (i == 0) {
                        this.carsel = this.simcar.getSelectedIndex();
                        int i_255_ = 0;
                        for (int i_256_ = 0; i_256_ < 5; i_256_++) {
                            this.stat[i_256_] = this.carstat[this.carsel][i_256_];
                            this.rstat[i_256_] = this.stat[i_256_];
                            i_255_ += this.stat[i_256_];
                        }
                        this.clsel = 4 - (i_255_ - 520) / 40;
                        this.cls.select(this.clsel);
                        if (this.simcar.getItemCount() == 16)
                            this.simcar.add(this.rd, "   ");
                        this.statdef = true;
                        this.changed2 = true;
                    }
                    i_206_ = 1;
                } else {
                    for (int i_257_ = 0; i_257_ < 5; i_257_++) {
                        int i_258_ = 0;
                        if (i == 1 + i_257_ * 2 && this.stat[i_257_] < 200) {
                            i_258_ = 200 - this.stat[i_257_];
                            if (i_258_ > 4)
                                i_258_ = 4;
                        }
                        if (i == i_257_ * 2 && this.stat[i_257_] > 16) {
                            i_258_ = 16 - this.stat[i_257_];
                            if (i_258_ < -4)
                                i_258_ = -4;
                        }
                        int i_259_ = 0;
                        while (i_258_ != 0 && i_259_ != 5) {
                            i_259_ = 0;
                            for (int i_260_ = 0; i_260_ < 5; i_260_++) {
                                if (i_257_ != i_260_ && (this.stat[i_260_] <= 200 || i_258_ > 0) && (this.stat[i_260_] >= 16 || i_258_ < 0) && i_258_ != 0) {
                                    if (i_258_ > 0) {
                                        this.stat[i_257_]++;
                                        this.stat[i_260_]--;
                                        i_258_--;
                                    } else {
                                        this.stat[i_257_]--;
                                        this.stat[i_260_]++;
                                        i_258_++;
                                    }
                                } else
                                    i_259_++;
                            }
                        }
                    }
                    if (i == 10) {
                        this.carsel = this.simcar.getSelectedIndex();
                        int i_261_ = 0;
                        for (int i_262_ = 0; i_262_ < 5; i_262_++) {
                            this.stat[i_262_] = this.carstat[this.carsel][i_262_];
                            i_261_ += this.stat[i_262_];
                        }
                        this.clsel = 4 - (i_261_ - 520) / 40;
                        this.cls.select(this.clsel);
                    }
                    if (i == 11) {
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                        string_263_ = new StringBuilder().append(string_263_).append("\n\n\nstat(").append(this.stat[0]).append(",").append(this.stat[1]).append(",").append(this.stat[2]).append(",").append(this.stat[3]).append(",").append(this.stat[4]).append(")\n\n\n\n").toString();
                        this.editor.setText(string_263_);
                        savefile();
                        for (int i_267_ = 0; i_267_ < 5; i_267_++)
                            this.rstat[i_267_] = this.stat[i_267_];
                        this.changed2 = false;
                    }
                    if (i == 12) {
                        for (int i_268_ = 0; i_268_ < 5; i_268_++)
                            this.stat[i_268_] = this.rstat[i_268_];
                    }
                    i_206_ = 13;
                }
            }
            if (this.dtab == 5) {
                if (this.pfase == 0) {
                    for (int i_269_ = 0; i_269_ < 4; i_269_++) {
                        if (i == 1 + i_269_ * 2) {
                            this.phys[i_269_] += 2;
                            if (this.phys[i_269_] > 100)
                                this.phys[i_269_] = 100;
                        }
                        if (i == i_269_ * 2) {
                            this.phys[i_269_] -= 2;
                            if (this.phys[i_269_] < 0)
                                this.phys[i_269_] = 0;
                        }
                    }
                    if (i == 8) {
                        for (int i_270_ = 0; i_270_ < 5; i_270_++)
                            this.phys[i_270_] = (int) (Math.random() * 100.0);
                    }
                    if (i == 9) {
                        for (int i_271_ = 0; i_271_ < 5; i_271_++)
                            this.phys[i_271_] = this.rphys[i_271_];
                    }
                    if (i == 10) {
                        this.pfase = 1;
                        i = -1;
                    }
                    i_206_ = 11;
                }
                if (this.pfase == 1) {
                    for (int i_272_ = 0; i_272_ < 6; i_272_++) {
                        if (i == 1 + i_272_ * 2) {
                            this.phys[i_272_ + 5] += 2;
                            if (this.phys[i_272_ + 5] > 100)
                                this.phys[i_272_ + 5] = 100;
                        }
                        if (i == i_272_ * 2) {
                            this.phys[i_272_ + 5] -= 2;
                            if (this.phys[i_272_ + 5] < 0)
                                this.phys[i_272_ + 5] = 0;
                        }
                    }
                    if (i == 12) {
                        for (int i_273_ = 0; i_273_ < 6; i_273_++)
                            this.phys[i_273_ + 5] = (int) (Math.random() * 100.0);
                    }
                    if (i == 13) {
                        for (int i_274_ = 0; i_274_ < 6; i_274_++)
                            this.phys[i_274_ + 5] = this.rphys[i_274_ + 5];
                    }
                    if (i == 14) {
                        this.pfase = 0;
                        i = -1;
                    }
                    if (i == 15) {
                        this.pfase = 2;
                        i = -1;
                    }
                    i_206_ = 16;
                }
                if (this.pfase == 2) {
                    for (int i_275_ = 0; i_275_ < 3; i_275_++) {
                        if (i == 1 + i_275_ * 2) {
                            this.crash[i_275_] += 2;
                            if (this.crash[i_275_] > 100)
                                this.crash[i_275_] = 100;
                        }
                        if (i == i_275_ * 2) {
                            this.crash[i_275_] -= 2;
                            if (this.crash[i_275_] < 0)
                                this.crash[i_275_] = 0;
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
                            this.crashup = false;
                        else
                            this.crashup = true;
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
                        if (this.hitmag < 17000) {
                            if (this.crashleft)
                                (this.o).xz += 22;
                            else
                                (this.o).xz -= 22;
                        }
                    }
                    if (i == 8) {
                        if (Math.random() > Math.random())
                            this.crashup = false;
                        else
                            this.crashup = true;
                        roofsqsh((float) (int) (230.0 + Math.random() * 80.0));
                    }
                    if (i == 9 || i == 7) {
                        setupo();
                        if (Math.random() > Math.random())
                            this.crashleft = false;
                        else
                            this.crashleft = true;
                    }
                    if (i == 10) {
                        for (int i_279_ = 0; i_279_ < 3; i_279_++)
                            this.crash[i_279_] = this.rcrash[i_279_];
                    }
                    if (i == 11) {
                        setupo();
                        this.pfase = 1;
                        i = -1;
                    }
                    if (i == 12) {
                        //if (this.crashok) {
                            setupo();
                            this.pfase = 3;
                            i = -1;
                        //} else
                        //    JOptionPane.showMessageDialog(null, this.usage[11], "Car Maker", 1);
                    }
                    i_206_ = 13;
                }
                if (this.pfase == 3) {
                    for (int i_280_ = 0; i_280_ < 5; i_280_++) {
                        if (i == i_280_) {
                            for (int i_281_ = 0; i_281_ < 5; i_281_++) {
                                for (int i_282_ = 0; i_282_ < 5; i_282_++)
                                    this.engs[i_282_][i_281_].stop();
                            }
                            this.engs[this.engsel][i_280_].loop();
                            this.engon = true;
                        }
                        if (i == 5) {
                            for (int i_283_ = 0; i_283_ < 5; i_283_++) {
                                for (int i_284_ = 0; i_284_ < 5; i_284_++)
                                    this.engs[i_284_][i_283_].stop();
                            }
                            this.engon = false;
                        }
                        if (i == 6) {
                            this.pfase = 2;
                            i = -1;
                            this.engine.hide();
                        }
                        if (i == 7) {
                            this.pfase = 4;
                            i = -1;
                            this.engine.hide();
                        }
                    }
                    i_206_ = 8;
                }
            }
            if (this.dtab == 6) {
                if (!this.rateh) {
                    if (i == 0 && checko("Test Drive")) {
                        Madness.testcar = this.carname;
                        Madness.testdrive = this.witho.getSelectedIndex() + 1;
                        Madness.game();
                    }
                    i_206_ = 1;
                    if (this.tested) {
                        if (i == 1) {
                            this.dtab = 4;
                            i = -1;
                        }
                        if (i == 2) {
                            this.dtab = 5;
                            i = -1;
                        }
                        if (i == 3) {
                            this.rateh = true;
                            hidefields();
                        }
                        i_206_ = 4;
                    }
                } else {
                    if (i == 0) {
                        this.handling -= 2;
                        if (this.handling < 50)
                            this.handling = 50;
                    }
                    if (i == 1) {
                        this.handling += 2;
                        if (this.handling > 200)
                            this.handling = 200;
                    }
                    if (i == 2) {
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                        string_285_ = new StringBuilder().append(string_285_).append("\n\n\nhandling(").append(this.handling).append(")\n\n\n\n").toString();
                        this.editor.setText(string_285_);
                        savefile();
                        this.rateh = false;
                    }
                    if (i == 3)
                        this.rateh = false;
                    i_206_ = 4;
                }
            }
            if (i == i_206_) {
                for (int i_289_ = 0; i_289_ < (this.o).npl; i_289_++) {
                    Color.RGBtoHSB(((this.o).p[i_289_]).c[0], ((this.o).p[i_289_]).c[1], ((this.o).p[i_289_]).c[2], ((this.o).p[i_289_]).hsb);
                    if (((this.o).p[i_289_]).gr == -13)
                        ((this.o).p[i_289_]).gr = 1;
                }
                this.polynum = -1;
            }
            i = -1;
        }
        if (this.tab == 3) {
            if (i == 0) {
                if (this.logged == 0)
                    JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Car Maker", 1);
                if ((this.logged == 3 || this.logged == -1) && checko("Publishing")) {
                    int i_290_ = 0;
                    for (int i_291_ = 0; i_291_ < this.nmc; i_291_++) {
                        if (this.mycars[i_291_].equals(this.carname) && this.maker[i_291_].equals(this.tnick.getText()))
                            i_290_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Replace your already online car '").append(this.carname).append("' with this one?").toString(), "Car Maker", 0);
                    }
                    if (i_290_ == 0) {
                        setCursor(new Cursor(3));
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(11, 141, 679, 401);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Connecting to Server...", 350 - this.ftm.stringWidth("Connecting to Server...") / 2, 250);
                        repaint();
                        int i_292_ = 0;
                        String string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                            printwriter.println(new StringBuilder().append("10|").append(this.tnick.getText()).append("|").append(this.tpass.getText()).append("|").append(this.carname).append("|").append(this.pubtyp.getSelectedIndex()).append("|").toString());
                            String string_296_ = bufferedreader.readLine();
                            if (string_296_ != null)
                                i_295_ = 0;
                            	//i_295_ = servervalue(string_296_, 0);
                            if (i_295_ == 0) {
                                int i_297_ = 0;
                                string = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
                                i_293_ = 0;
                                i_294_ = string.indexOf("\n", 0);
                                while (i_294_ != -1 && i_293_ < string.length()) {
                                    String string_298_ = string.substring(i_293_, i_294_);
                                    string_298_ = string_298_.trim();
                                    printwriter.println(string_298_);
                                    i_293_ = i_294_ + 1;
                                    i_294_ = string.indexOf("\n", i_293_);
                                    i_297_++;
                                    this.rd.setColor(new Color(225, 225, 225));
                                    this.rd.fillRect(11, 141, 679, 401);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Publishing Car...", 350 - this.ftm.stringWidth("Publishing Car...") / 2, 250);
                                    this.rd.setColor(new Color(119, 147, 191));
                                    this.rd.fillRect(250, 270, (int) ((float) i_297_ / (float) i_292_ * 200.0F), 7);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawRect(250, 270, 200, 7);
                                    repaint();
                                    try {
                                        if (this.thredo != null) {
                                            /* empty */
                                        }
                                        Thread.sleep(10L);
                                    } catch (InterruptedException interruptedexception) {
                                        /* empty */
                                    }
                                }
                                printwriter.println("QUITX1111");
                                this.rd.setColor(new Color(225, 225, 225));
                                this.rd.fillRect(11, 141, 679, 401);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Creating the car online...", 350 - this.ftm.stringWidth("Creating the car online...") / 2, 250);
                                this.rd.drawString("This may take a couple of minutes, please wait...", 350 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
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
                            this.logged = 1;
                            bool = true;
                        }
                        if (i_295_ == 3) {
                            JOptionPane.showMessageDialog(null, "Unable to publish car.\nReason:\nCar name is too large.  Please rename your car.  Car name must be less then 15 characters.", "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 4) {
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to publish car.\nReason:  Car name used (").append(this.carname).append(").\nThe name '").append(this.carname).append("' is already used by another published car.  Please rename your car.").toString(), "Car Maker", 1);
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
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error Creating Car!\nReason:\nCar scale size is too large!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled down by ").append((int) (((float) (this.o).maxR / 400.0F - 1.0F) * 100.0F)).append("%.\n").toString(), "Car Maker", 1);
                            bool = true;
                        }
                        if (i_295_ == 12) {
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error Creating Car!\nReason:\nCar scale size is too small!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled up by ").append((int) ((120.0F / (float) (this.o).maxR - 1.0F) * 100.0F)).append("%.\n").toString(), "Car Maker", 1);
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
            if (this.logged == 0) {
                if (i == 1) {
                    setCursor(new Cursor(3));
                    int i_299_ = -1;
                    try {
                        Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                        printwriter.println(new StringBuilder().append("1|").append(this.tnick.getText().toLowerCase()).append("|").append(this.tpass.getText()).append("|").toString());
                        String string = bufferedreader.readLine();
                        if (string != null)
                            i_299_ = servervalue(string, 0);
                        socket.close();
                    } catch (Exception exception) {
                        i_299_ = -1;
                    }
                    if (i_299_ == 0 || i_299_ == 3 || i_299_ > 10) {
                        this.tnick.hide();
                        this.tpass.hide();
                        this.logged = 1;
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
        this.o = new ContO(this.editor.getText().getBytes(), this.m, this.t);
        (this.o).x = this.ox;
        (this.o).y = this.oy;
        (this.o).z = this.oz;
        (this.o).xz = this.oxz;
        (this.o).xy = this.oxy;
        (this.o).zy = this.ozy;
        (this.o).shadow = true;
        (this.o).tnt = 0;
        (this.o).disp = 0;
        (this.o).disline = 7;
        (this.o).grounded = 1.0F;
        (this.o).noline = false;
        (this.o).decor = false;
        if ((this.o).errd && (!(this.o).err.startsWith("Wheels Error:") || this.forwheels))
            JOptionPane.showMessageDialog(null, (this.o).err, "Car Maker", 0);
        if ((this.o).maxR == 0)
            (this.o).maxR = 100;
        this.squash = 0;
        this.hitmag = 0;
    }
    
    public void loadfile() {
        this.loadedfile = false;
        this.lastedo = "";
        try {
            File file = new File(new StringBuilder().append("mycars/").append(this.carname).append(".rad").toString());
            BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
            Object object = null;
            String string;
            while ((string = bufferedreader.readLine()) != null) {
                StringBuilder stringbuilder = new StringBuilder();
                CarMaker carmaker_300_ = this;
                (carmaker_300_).lastedo = stringbuilder.append((carmaker_300_).lastedo).append("").append(string).append("\n").toString();
            }
            this.loadedfile = true;
            bufferedreader.close();
            Object object_301_ = null;
        } catch (Exception exception) {
            this.loadedfile = false;
            this.lastedo = "";
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to load file! Error Deatials:\n").append(exception).toString(), "Car Maker", 1);
        }
        this.editor.setText(this.lastedo);
    }
    
    public void savefile() {
        if (!this.editor.getText().equals("")) {
            try {
                File file = new File("mycars/");
                if (!file.exists())
                    file.mkdirs();
                file = new File(new StringBuilder().append("mycars/").append(this.carname).append(".rad").toString());
                BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(this.editor.getText());
                bufferedwriter.close();
                Object object = null;
                this.changed = false;
                this.lastedo = this.editor.getText();
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
                this.carname = string;
                file = new File(new StringBuilder().append("mycars/").append(this.carname).append(".rad").toString());
                if (!file.exists()) {
                    BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                    bufferedwriter.write(string_302_);
                    bufferedwriter.close();
                    Object object = null;
                    if (file.exists()) {
                        this.sfase = 0;
                        hidefields();
                        this.tabed = -1;
                    } else
                        JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1);
                } else
                    JOptionPane.showMessageDialog(null, new StringBuilder().append("A car with the name '").append(this.carname).append("' already exists, please choose another name!\n").toString(), "Car Maker", 1);
            } catch (Exception exception) {
                this.carname = "";
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
                    this.slcar.remove(string);
                    this.slcar.select(0);
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
                File file = new File(new StringBuilder().append("mycars/").append(this.carname).append(".rad").toString());
                File file_303_ = new File(new StringBuilder().append("mycars/").append(string).append(".rad").toString());
                if (file.renameTo(file_303_)) {
                    this.carname = string;
                    this.sfase = 0;
                    hidefields();
                    this.tabed = -1;
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
                    this.scar = string;
                    this.carname = this.scar;
                }
                string = bufferedreader.readLine();
                if (string != null) {
                    this.suser = string;
                    if (!this.suser.equals("Horaks"))
                        this.tnick.setText(this.suser);
                }
                string = bufferedreader.readLine();
                if (string != null) {
                    this.sfont = string;
                    this.cfont = this.sfont;
                }
                string = bufferedreader.readLine();
                if (string != null) {
                    this.sthm = Float.valueOf(string).intValue();
                    this.cthm = this.sthm;
                }
                bufferedreader.close();
                Object object = null;
            }
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void savesettings() {
        if (!this.scar.equals(this.carname) || !this.suser.equals(this.tnick.getText()) || !this.sfont.equals(this.cfont) || this.cthm != this.sthm) {
            String string = new StringBuilder().append("").append(this.carname).append("\n").append(this.tnick.getText()).append("\n").append(this.cfont).append("\n").append(this.cthm).append("\n\n").toString();
            this.scar = this.carname;
            this.suser = this.tnick.getText();
            this.sfont = this.cfont;
            this.sthm = this.cthm;
            try {
                File file = new File("mycars/");
                if (!file.exists())
                    file.mkdirs();
                file = new File("mycars/settings.data");
                BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(string);
                bufferedwriter.close();
                Object object = null;
            } catch (Exception exception) {
                /* empty */
            }
        }
    }
    
    public boolean checko(String string) {
        loadfile();
        setupo();
        if ((this.o).colok < 2) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.\n").toString(), "Car Maker", 1);
            return false;
        }
        /*boolean bool = true;
        if ((this.o).keyz[0] <= 0 || (this.o).keyx[0] >= 0)
            bool = false;
        if ((this.o).keyz[1] <= 0 || (this.o).keyx[1] <= 0)
            bool = false;
        if ((this.o).keyz[2] >= 0 || (this.o).keyx[2] >= 0)
            bool = false;
        if ((this.o).keyz[3] >= 0 || (this.o).keyx[3] <= 0)
            bool = false;
        if (!bool) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the \u2018Wheels\u2019 tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n").toString(), "Car Maker", 1);
            return false;
        }*/
        if ((this.o).npl <= 0) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the \u2018Car\u2019 tab to find the tutorial on how to build a car.\n").toString(), "Car Maker", 1);
            return false;
        }
        if ((this.o).npl > 10000) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 10000.\nPlease use the counter in the \u2018Code Edit\u2019 to decrease the number of polygons (pieces).\n").toString(), "Car Maker", 1);
            return false;
        }
        if ((this.o).maxR > 40000) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar scale size is too large!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled down by ").append((int) (((float) (this.o).maxR / 400.0F - 1.0F) * 100.0F)).append("%.\n").toString(), "Car Maker", 1);
            return false;
        }
        if ((this.o).maxR < 2) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Car is not ready for ").append(string).append("!\nReason:\nCar scale size is too small!\nPlease use the \u2018Scale All\u2019 option in the \u2018Scale & Align\u2019 tab to resize your car to suitable size.       \nCompare it to other NFM cars using the \u2018Compare Car...\u2019 option.\nCurrently you car needs to be scaled up by ").append((int) ((120.0F / (float) (this.o).maxR - 1.0F) * 100.0F)).append("%.\n").toString(), "Car Maker", 1);
            return false;
        }
        String string_304_ = new StringBuilder().append("").append(this.editor.getText()).append("\n").toString();
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
                        this.stat[i_311_] = getvalue("stat", string_309_, i_311_);
                        if (this.stat[i_311_] > 200)
                            bool_306_ = false;
                        if (this.stat[i_311_] < 16)
                            bool_306_ = false;
                        i_310_ += this.stat[i_311_];
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
                        this.phys[i_312_] = getvalue("physics", string_309_, i_312_);
                        //if (this.phys[i_312_] > 100)
                        //    bool_307_ = false;
                        //if (this.phys[i_312_] < 0)
                        //    bool_307_ = false;
                    }
                    for (int i_313_ = 0; i_313_ < 3; i_313_++) {
                        this.crash[i_313_] = getvalue("physics", string_309_, i_313_ + 11);
                        //if (i_313_ != 0 && this.crash[i_313_] > 100)
                        //    bool_307_ = false;
                        //if (this.crash[i_313_] < 0)
                        //    bool_307_ = false;
                    }
                    this.engsel = getvalue("physics", string_309_, 14);
                    if (this.engsel > 4)
                        bool_307_ = false;
                    if (this.engsel < 0)
                        bool_307_ = false;
                } catch (Exception exception) {
                    bool_307_ = false;
                }
            }
            if (string_309_.startsWith("handling(")) {
                bool_308_ = true;
                try {
                    int i_314_ = getvalue("handling", string_309_, 0);
                    //if (i_314_ > 200)
                    //    bool_308_ = false;
                    //if (i_314_ < 0)
                    //    bool_308_ = false;
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
        this.hitmag += f;
        if (!bool)
            crash(f);
        f *= 0.3F + (float) this.crash[1] * 0.005F;
        if (Math.abs(f) > 100.0F) {
            int i_315_ = (int) ((double) (this.crash[0] * this.crash[0]) * 1.5);
            if (i_315_ < 1000)
                i_315_ = 1000;
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            for (int i_316_ = 0; i_316_ < (this.o).npl; i_316_++) {
                float f_317_ = 0.0F;
                for (int i_318_ = 0; i_318_ < ((this.o).p[i_316_]).n; i_318_++) {
                    if (((this.o).p[i_316_]).wz == 0 && py((this.o).keyx[i], ((this.o).p[i_316_]).ox[i_318_], (this.o).keyz[i], ((this.o).p[i_316_]).oz[i_318_]) < i_315_) {
                        f_317_ = f / 20.0F * this.m.random();
                        ((this.o).p[i_316_]).oz[i_318_] -= f_317_ * this.m.sin((this.o).xz) * this.m.cos((this.o).zy);
                        ((this.o).p[i_316_]).ox[i_318_] += f_317_ * this.m.cos((this.o).xz) * this.m.cos((this.o).xy);
                        if (bool)
                            this.actmag += Math.abs(f_317_);
                    }
                }
                if (f_317_ != 0.0F) {
                    if (Math.abs(f_317_) >= 1.0F) {
                        ((this.o).p[i_316_]).chip = 1;
                        ((this.o).p[i_316_]).ctmag = f_317_;
                    }
                    if (!((this.o).p[i_316_]).nocol && ((this.o).p[i_316_]).glass != 1) {
                        if (((this.o).p[i_316_]).bfase > 20 && (double) ((this.o).p[i_316_]).hsb[1] > 0.25)
                            ((this.o).p[i_316_]).hsb[1] = 0.25F;
                        if (((this.o).p[i_316_]).bfase > 25 && (double) ((this.o).p[i_316_]).hsb[2] > 0.7)
                            ((this.o).p[i_316_]).hsb[2] = 0.7F;
                        if (((this.o).p[i_316_]).bfase > 30 && (double) ((this.o).p[i_316_]).hsb[1] > 0.15)
                            ((this.o).p[i_316_]).hsb[1] = 0.15F;
                        if (((this.o).p[i_316_]).bfase > 35 && (double) ((this.o).p[i_316_]).hsb[2] > 0.6)
                            ((this.o).p[i_316_]).hsb[2] = 0.6F;
                        if (((this.o).p[i_316_]).bfase > 40)
                            ((this.o).p[i_316_]).hsb[0] = 0.075F;
                        if (((this.o).p[i_316_]).bfase > 50 && (double) ((this.o).p[i_316_]).hsb[2] > 0.5)
                            ((this.o).p[i_316_]).hsb[2] = 0.5F;
                        if (((this.o).p[i_316_]).bfase > 60)
                            ((this.o).p[i_316_]).hsb[0] = 0.05F;
                        ((this.o).p[i_316_]).bfase += Math.abs(f_317_);
                        new Color(((this.o).p[i_316_]).c[0], ((this.o).p[i_316_]).c[1], ((this.o).p[i_316_]).c[2]);
                        Color color = Color.getHSBColor(((this.o).p[i_316_]).hsb[0], ((this.o).p[i_316_]).hsb[1], ((this.o).p[i_316_]).hsb[2]);
                        ((this.o).p[i_316_]).c[0] = color.getRed();
                        ((this.o).p[i_316_]).c[1] = color.getGreen();
                        ((this.o).p[i_316_]).c[2] = color.getBlue();
                    }
                    if (((this.o).p[i_316_]).glass == 1)
                        ((this.o).p[i_316_]).gr += Math.abs((double) f_317_ * 1.5);
                }
            }
        }
    }
    
    public void regz(int i, float f, boolean bool) {
        this.hitmag += f;
        if (!bool)
            crash(f);
        f *= 0.3F + (float) this.crash[1] * 0.005F;
        if (Math.abs(f) > 100.0F) {
            int i_319_ = (int) ((double) (this.crash[0] * this.crash[0]) * 1.5);
            if (i_319_ < 1000)
                i_319_ = 1000;
            if (f > 100.0F)
                f -= 100.0F;
            if (f < -100.0F)
                f += 100.0F;
            for (int i_320_ = 0; i_320_ < (this.o).npl; i_320_++) {
                float f_321_ = 0.0F;
                for (int i_322_ = 0; i_322_ < ((this.o).p[i_320_]).n; i_322_++) {
                    if (((this.o).p[i_320_]).wz == 0 && py((this.o).keyx[i], ((this.o).p[i_320_]).ox[i_322_], (this.o).keyz[i], ((this.o).p[i_320_]).oz[i_322_]) < i_319_) {
                        f_321_ = f / 20.0F * this.m.random();
                        ((this.o).p[i_320_]).oz[i_322_] += f_321_ * this.m.cos((this.o).xz) * this.m.cos((this.o).zy);
                        ((this.o).p[i_320_]).ox[i_322_] += f_321_ * this.m.sin((this.o).xz) * this.m.cos((this.o).xy);
                        if (bool)
                            this.actmag += Math.abs(f_321_);
                    }
                }
                if (f_321_ != 0.0F) {
                    if (Math.abs(f_321_) >= 1.0F) {
                        ((this.o).p[i_320_]).chip = 1;
                        ((this.o).p[i_320_]).ctmag = f_321_;
                    }
                    if (!((this.o).p[i_320_]).nocol && ((this.o).p[i_320_]).glass != 1) {
                        if (((this.o).p[i_320_]).bfase > 20 && (double) ((this.o).p[i_320_]).hsb[1] > 0.25)
                            ((this.o).p[i_320_]).hsb[1] = 0.25F;
                        if (((this.o).p[i_320_]).bfase > 25 && (double) ((this.o).p[i_320_]).hsb[2] > 0.7)
                            ((this.o).p[i_320_]).hsb[2] = 0.7F;
                        if (((this.o).p[i_320_]).bfase > 30 && (double) ((this.o).p[i_320_]).hsb[1] > 0.15)
                            ((this.o).p[i_320_]).hsb[1] = 0.15F;
                        if (((this.o).p[i_320_]).bfase > 35 && (double) ((this.o).p[i_320_]).hsb[2] > 0.6)
                            ((this.o).p[i_320_]).hsb[2] = 0.6F;
                        if (((this.o).p[i_320_]).bfase > 40)
                            ((this.o).p[i_320_]).hsb[0] = 0.075F;
                        if (((this.o).p[i_320_]).bfase > 50 && (double) ((this.o).p[i_320_]).hsb[2] > 0.5)
                            ((this.o).p[i_320_]).hsb[2] = 0.5F;
                        if (((this.o).p[i_320_]).bfase > 60)
                            ((this.o).p[i_320_]).hsb[0] = 0.05F;
                        ((this.o).p[i_320_]).bfase += Math.abs(f_321_);
                        new Color(((this.o).p[i_320_]).c[0], ((this.o).p[i_320_]).c[1], ((this.o).p[i_320_]).c[2]);
                        Color color = Color.getHSBColor(((this.o).p[i_320_]).hsb[0], ((this.o).p[i_320_]).hsb[1], ((this.o).p[i_320_]).hsb[2]);
                        ((this.o).p[i_320_]).c[0] = color.getRed();
                        ((this.o).p[i_320_]).c[1] = color.getGreen();
                        ((this.o).p[i_320_]).c[2] = color.getBlue();
                    }
                    if (((this.o).p[i_320_]).glass == 1)
                        ((this.o).p[i_320_]).gr += Math.abs((double) f_321_ * 1.5);
                }
            }
        }
    }
    
    public void roofsqsh(float f) {
        if (f > 100.0F) {
            crash(f);
            f -= 100.0F;
            int i = (int) (2.0 + (double) (float) this.crash[2] / 7.6);
            int i_323_ = 0;
            int i_324_ = 1;
            for (int i_325_ = 0; i_325_ < (this.o).npl; i_325_++) {
                float f_326_ = 0.0F;
                if (Math.random() > 0.9)
                    f_326_ = f / 15.0F * this.m.random();
                for (int i_327_ = 0; i_327_ < ((this.o).p[i_325_]).n; i_327_++) {
                    if (((this.o).p[i_325_]).wz == 0 && (Math.abs(((this.o).p[i_325_]).oy[i_327_] - (this.o).roofat - this.squash) < i * 3 || ((this.o).p[i_325_]).oy[i_327_] < (this.o).roofat + this.squash) && this.squash < i) {
                        f_326_ = f / 15.0F * this.m.random();
                        ((this.o).p[i_325_]).oy[i_327_] += f_326_;
                        i_323_ += f_326_;
                        i_324_++;
                        this.hitmag += Math.abs(f_326_);
                    }
                }
                if (!((this.o).p[i_325_]).nocol && ((this.o).p[i_325_]).glass != 1) {
                    if (f_326_ != 0.0F) {
                        if (((this.o).p[i_325_]).bfase > 20 && (double) ((this.o).p[i_325_]).hsb[1] > 0.25)
                            ((this.o).p[i_325_]).hsb[1] = 0.25F;
                        if (((this.o).p[i_325_]).bfase > 25 && (double) ((this.o).p[i_325_]).hsb[2] > 0.7)
                            ((this.o).p[i_325_]).hsb[2] = 0.7F;
                        if (((this.o).p[i_325_]).bfase > 30 && (double) ((this.o).p[i_325_]).hsb[1] > 0.15)
                            ((this.o).p[i_325_]).hsb[1] = 0.15F;
                        if (((this.o).p[i_325_]).bfase > 35 && (double) ((this.o).p[i_325_]).hsb[2] > 0.6)
                            ((this.o).p[i_325_]).hsb[2] = 0.6F;
                        if (((this.o).p[i_325_]).bfase > 40)
                            ((this.o).p[i_325_]).hsb[0] = 0.075F;
                        if (((this.o).p[i_325_]).bfase > 50 && (double) ((this.o).p[i_325_]).hsb[2] > 0.5)
                            ((this.o).p[i_325_]).hsb[2] = 0.5F;
                        if (((this.o).p[i_325_]).bfase > 60)
                            ((this.o).p[i_325_]).hsb[0] = 0.05F;
                        ((this.o).p[i_325_]).bfase += f_326_;
                        new Color(((this.o).p[i_325_]).c[0], ((this.o).p[i_325_]).c[1], ((this.o).p[i_325_]).c[2]);
                        Color color = Color.getHSBColor(((this.o).p[i_325_]).hsb[0], ((this.o).p[i_325_]).hsb[1], ((this.o).p[i_325_]).hsb[2]);
                        ((this.o).p[i_325_]).c[0] = color.getRed();
                        ((this.o).p[i_325_]).c[1] = color.getGreen();
                        ((this.o).p[i_325_]).c[2] = color.getBlue();
                    }
                } else if (((this.o).p[i_325_]).glass == 1)
                    ((this.o).p[i_325_]).gr += 5;
                if (Math.abs(f_326_) >= 1.0F) {
                    ((this.o).p[i_325_]).chip = 1;
                    ((this.o).p[i_325_]).ctmag = f_326_;
                }
            }
            this.squash += i_323_ / i_324_;
        }
    }
    
    public void crash(float f) {
        if (f > 100.0F)
            f -= 100.0F;
        if (f < -100.0F)
            f += 100.0F;
        if (Math.abs(f) > 25.0F && Math.abs(f) < 170.0F)
            this.lowcrashs[this.crshturn].play();
        if (Math.abs(f) >= 170.0F)
            this.crashs[this.crshturn].play();
        if (Math.abs(f) > 25.0F) {
            if (this.crashup)
                this.crshturn--;
            else
                this.crshturn++;
            if (this.crshturn == -1)
                this.crshturn = 2;
            if (this.crshturn == 3)
                this.crshturn = 0;
        }
    }
    
    public void setheme() {
        if (this.cthm == 0) {
            this.editor.setForeground(this.deff);
            this.editor.setBackground(this.defb);
        }
        if (this.cthm == 1) {
            this.editor.setForeground(new Color(0, 0, 0));
            this.editor.setBackground(new Color(192, 192, 192));
        }
        if (this.cthm == 2) {
            this.editor.setForeground(new Color(192, 192, 192));
            this.editor.setBackground(new Color(0, 0, 0));
        }
        if (this.cthm == 3) {
            this.editor.setForeground(new Color(0, 0, 0));
            this.editor.setBackground(new Color(50, 200, 0));
        }
        if (this.cthm == 4) {
            this.editor.setForeground(new Color(67, 255, 77));
            this.editor.setBackground(new Color(0, 0, 0));
        }
        if (this.cthm == 5) {
            this.editor.setForeground(new Color(0, 172, 255));
            this.editor.setBackground(new Color(210, 234, 255));
        }
        if (this.cthm == 6) {
            this.editor.setForeground(new Color(255, 230, 0));
            this.editor.setBackground(new Color(255, 77, 67));
        }
        if (this.cthm == 7) {
            this.editor.setForeground(new Color(0, 159, 255));
            this.editor.setBackground(new Color(9, 47, 104));
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
                is[i_335_] = i + (int) ((float) (i_336_ - i) * this.m.cos(i_333_) - (float) (i_337_ - i_332_) * this.m.sin(i_333_));
                is_331_[i_335_] = i_332_ + (int) ((float) (i_336_ - i) * this.m.sin(i_333_) + (float) (i_337_ - i_332_) * this.m.cos(i_333_));
            }
        }
    }
    
    public int xs(int i, int i_338_) {
        if (i_338_ < (this.m).cz)
            i_338_ = (this.m).cz;
        return (i_338_ - (this.m).focus_point) * ((this.m).cx - i) / i_338_ + i;
    }
    
    public int ys(int i, int i_339_) {
        if (i_339_ < (this.m).cz)
            i_339_ = (this.m).cz;
        return (i_339_ - (this.m).focus_point) * ((this.m).cy - i) / i_339_ + i;
    }
    
    public void init() {
        setBackground(new Color(0, 0, 0));
        this.offImage = createImage(700, 550);
        if (this.offImage != null)
            this.rd = (Graphics2D) this.offImage.getGraphics();
        this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        setLayout(null);
        this.slcar.setFont(new Font("Arial", 1, 13));
        this.slcar.add(this.rd, "Select a Car...         ");
        this.slcar.setForeground(new Color(63, 80, 110));
        this.slcar.setBackground(new Color(209, 217, 230));
        this.fontsel.setFont(new Font("Arial", 1, 12));
        this.fontsel.add(this.rd, "Arial");
        this.fontsel.add(this.rd, "Dialog");
        this.fontsel.add(this.rd, "DialogInput");
        this.fontsel.add(this.rd, "Monospaced");
        this.fontsel.add(this.rd, "Serif");
        this.fontsel.add(this.rd, "SansSerif");
        this.fontsel.add(this.rd, "Verdana");
        this.fontsel.setBackground(new Color(63, 80, 110));
        this.fontsel.setForeground(new Color(209, 217, 230));
        this.ctheme.setFont(new Font("Arial", 1, 12));
        this.ctheme.add(this.rd, "Default");
        this.ctheme.add(this.rd, "Author");
        this.ctheme.add(this.rd, "Dos");
        this.ctheme.add(this.rd, "Green");
        this.ctheme.add(this.rd, "The Matrix");
        this.ctheme.add(this.rd, "Ice Age");
        this.ctheme.add(this.rd, "Fire");
        this.ctheme.add(this.rd, "Ocean");
        this.ctheme.setBackground(new Color(63, 80, 110));
        this.ctheme.setForeground(new Color(209, 217, 230));
        this.compcar.setFont(new Font("Arial", 1, 12));
        this.compcar.add(this.rd, "Compare Car...");
        this.compcar.add(this.rd, "Tornado Shark");
        this.compcar.add(this.rd, "Formula 7");
        this.compcar.add(this.rd, "Wow Caninaro");
        this.compcar.add(this.rd, "La Vita Crab");
        this.compcar.add(this.rd, "Nimi");
        this.compcar.add(this.rd, "MAX Revenge");
        this.compcar.add(this.rd, "Lead Oxide");
        this.compcar.add(this.rd, "Kool Kat");
        this.compcar.add(this.rd, "Drifter X");
        this.compcar.add(this.rd, "Sword of Justice");
        this.compcar.add(this.rd, "High Rider");
        this.compcar.add(this.rd, "EL KING");
        this.compcar.add(this.rd, "Mighty Eight");
        this.compcar.add(this.rd, "M A S H E E N");
        this.compcar.add(this.rd, "Radical One");
        this.compcar.add(this.rd, "DR Monstaa");
        this.compcar.add(this.rd, " -  None  - ");
        this.compcar.setBackground(new Color(63, 80, 110));
        this.compcar.setForeground(new Color(209, 217, 230));
        this.cls.setFont(new Font("Arial", 1, 12));
        this.cls.add(this.rd, "Class A");
        this.cls.add(this.rd, "Class A & B");
        this.cls.add(this.rd, "Class B");
        this.cls.add(this.rd, "Class B & C");
        this.cls.add(this.rd, "Class C");
        this.cls.setBackground(new Color(63, 80, 110));
        this.cls.setForeground(new Color(209, 217, 230));
        this.simcar.setFont(new Font("Arial", 1, 12));
        this.simcar.add(this.rd, "Tornado Shark");
        this.simcar.add(this.rd, "Formula 7");
        this.simcar.add(this.rd, "Wow Caninaro");
        this.simcar.add(this.rd, "La Vita Crab");
        this.simcar.add(this.rd, "Nimi");
        this.simcar.add(this.rd, "MAX Revenge");
        this.simcar.add(this.rd, "Lead Oxide");
        this.simcar.add(this.rd, "Kool Kat");
        this.simcar.add(this.rd, "Drifter X");
        this.simcar.add(this.rd, "Sword of Justice");
        this.simcar.add(this.rd, "High Rider");
        this.simcar.add(this.rd, "EL KING");
        this.simcar.add(this.rd, "Mighty Eight");
        this.simcar.add(this.rd, "M A S H E E N");
        this.simcar.add(this.rd, "Radical One");
        this.simcar.add(this.rd, "DR Monstaa");
        this.simcar.setBackground(new Color(63, 80, 110));
        this.simcar.setForeground(new Color(209, 217, 230));
        this.witho.setFont(new Font("Arial", 1, 12));
        this.witho.add(this.rd, "With other cars");
        this.witho.add(this.rd, "Alone");
        this.witho.setBackground(new Color(63, 80, 110));
        this.witho.setForeground(new Color(209, 217, 230));
        this.engine.setFont(new Font("Arial", 1, 12));
        this.engine.add(this.rd, "Normal Engine");
        this.engine.add(this.rd, "V8 Engine");
        this.engine.add(this.rd, "Retro Engine");
        this.engine.add(this.rd, "Power Engine");
        this.engine.add(this.rd, "Diesel Engine");
        this.engine.setBackground(new Color(63, 80, 110));
        this.engine.setForeground(new Color(209, 217, 230));
        MenuItem menuitem = new MenuItem("Cut");
        MenuItem menuitem_340_ = new MenuItem("Copy");
        MenuItem menuitem_341_ = new MenuItem("Paste");
        MenuItem menuitem_342_ = new MenuItem("Select All");
        this.popupMenu = new PopupMenu();
        this.popupMenu.add(menuitem);
        this.popupMenu.add(menuitem_340_);
        this.popupMenu.add(menuitem_341_);
        this.popupMenu.add(menuitem_342_);
        menuitem.addActionListener(this);
        menuitem_340_.addActionListener(this);
        menuitem_341_.addActionListener(this);
        menuitem_342_.addActionListener(this);
        add(this.popupMenu);
        for (int i = 0; i < 16; i++) {
            this.wv[i] = new TextField("", 2);
            this.wv[i].setBackground(new Color(255, 255, 255));
            this.wv[i].setForeground(new Color(0, 0, 0));
            this.wv[i].setFont(new Font(this.cfont, 1, 14));
            this.wv[i].addMouseListener(new MouseHandler(this.popupMenu, i));
            add(this.wv[i]);
        }
        this.tnick.setFont(new Font("Arial", 1, 13));
        this.tnick.setBackground(new Color(255, 255, 255));
        this.tnick.setForeground(new Color(0, 0, 0));
        this.tpass.setFont(new Font("Arial", 1, 13));
        this.tpass.setEchoCharacter('*');
        this.tpass.setBackground(new Color(255, 255, 255));
        this.tpass.setForeground(new Color(0, 0, 0));
        this.pubtyp.setFont(new Font("Arial", 1, 13));
        this.pubtyp.add(this.rd, "Private");
        this.pubtyp.add(this.rd, "Public");
        this.pubtyp.add(this.rd, "Super Public");
        this.pubtyp.setBackground(new Color(63, 80, 110));
        this.pubtyp.setForeground(new Color(209, 217, 230));
        this.srch.setBackground(new Color(255, 255, 255));
        this.srch.setForeground(new Color(0, 0, 0));
        this.srch.addMouseListener(new MouseHandler(this.popupMenu, 16));
        this.rplc.setBackground(new Color(255, 255, 255));
        this.rplc.setForeground(new Color(0, 0, 0));
        this.rplc.addMouseListener(new MouseHandler(this.popupMenu, 17));
        this.editor.addMouseListener(new MouseHandler(this.popupMenu, 18));
        add(this.tnick);
        add(this.tpass);
        add(this.editor);
        add(this.srch);
        add(this.rplc);
        this.defb = new Color(255, 255, 255);
        this.deff = new Color(0, 0, 0);
        hidefields();
    }
    
    public void hidefields() {
        this.pubtyp.hide();
        this.tpass.hide();
        this.tnick.hide();
        this.slcar.hide();
        this.witho.hide();
        for (int i = 0; i < 16; i++)
            this.wv[i].hide();
        this.simcar.hide();
        this.engine.hide();
        this.cls.hide();
        this.compcar.hide();
        this.editor.hide();
        this.fontsel.hide();
        this.ctheme.hide();
        this.srch.hide();
        this.rplc.hide();
    }
    
    public void movefield(Component component, int i, int i_343_, int i_344_, int i_345_) {
        i += this.apx;
        i_343_ += this.apy;
        if (component.getX() != i || component.getY() != i_343_ || component.getWidth() != i_344_ || component.getHeight() != i_345_)
            component.setBounds(i, i_343_, i_344_, i_345_);
    }
    
    public void drawms() {
        this.openm = false;
        if (this.pubtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false))
            this.openm = true;
        if (this.fontsel.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            this.openm = true;
        if (this.ctheme.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            this.openm = true;
        if (this.compcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            this.openm = true;
        if (this.cls.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            this.openm = true;
        if (this.simcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            this.openm = true;
        if (this.engine.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false))
            this.openm = true;
        if (this.witho.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            this.openm = true;
        if (this.slcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false))
            this.openm = true;
        if (this.openm) {
            this.waso = true;
            this.mouses = 0;
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
        if (this.thredo == null)
            this.thredo = new Thread(this);
        this.thredo.start();
    }
    
    public void stop() {
        this.exwist = true;
    }
    
    public void paint(Graphics graphics) {
        this.apx = getWidth() / 2 - 350;
        this.apy = getHeight() / 2 - 275;
        graphics.drawImage(this.offImage, this.apx, this.apy, this);
    }
    
    public void update(Graphics graphics) {
        paint(graphics);
    }
    
    public boolean mouseUp(Event event, int i, int i_346_) {
        this.xm = i - this.apx;
        this.ym = i_346_ - this.apy;
        if (this.waso)
            this.waso = false;
        else
            this.mouses = -1;
        this.mousdr = false;
        if (this.onbtgame)
            Madness.game();
        return false;
    }
    
    public boolean mouseDown(Event event, int i, int i_347_) {
        this.xm = i - this.apx;
        this.ym = i_347_ - this.apy;
        this.mouses = 1;
        this.mousdr = true;
        if (this.tab != 1)
            requestFocus();
        return false;
    }
    
    public boolean mouseMove(Event event, int i, int i_348_) {
        this.xm = i - this.apx;
        this.ym = i_348_ - this.apy;
        if (this.xm > 520 && this.xm < 674 && this.ym > 0 && this.ym < 23) {
            if (!this.onbtgame) {
                this.onbtgame = true;
                setCursor(new Cursor(12));
            }
        } else if (this.onbtgame) {
            this.onbtgame = false;
            setCursor(new Cursor(0));
        }
        return false;
    }
    
    public boolean mouseDrag(Event event, int i, int i_349_) {
        this.mousdr = true;
        this.xm = i - this.apx;
        this.ym = i_349_ - this.apy;
        return false;
    }
    
    public boolean lostFocus(Event event, Object object) {
        this.focuson = false;
        return false;
    }
    
    public boolean gotFocus(Event event, Object object) {
        this.focuson = true;
        return false;
    }
    
    public boolean keyDown(Event event, int i) {
        if (this.focuson) {
            if (i == 54 || i == 46 || i == 100 || i == 68)
                this.rotr = true;
            if (i == 52 || i == 44 || i == 97 || i == 65)
                this.rotl = true;
            if (i == 43 || i == 61)
                this.plus = true;
            if (i == 45)
                this.minus = true;
            if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87)
                this.in = true;
            if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83)
                this.out = true;
            if (i == 1006)
                this.left = true;
            if (i == 1007)
                this.right = true;
            if (i == 1005)
                this.down = true;
            if (i == 1004)
                this.up = true;
        }
        return false;
    }
    
    public boolean keyUp(Event event, int i) {
        if (i == 54 || i == 46 || i == 100 || i == 68)
            this.rotr = false;
        if (i == 52 || i == 44 || i == 97 || i == 65)
            this.rotl = false;
        if (i == 43 || i == 61)
            this.plus = false;
        if (i == 45)
            this.minus = false;
        if (i == 42 || i == 10 || i == 56 || i == 119 || i == 97)
            this.in = false;
        if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83)
            this.out = false;
        if (i == 1006)
            this.left = false;
        if (i == 1007)
            this.right = false;
        if (i == 1005)
            this.down = false;
        if (i == 1004)
            this.up = false;
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
                            this.engs[i_353_][i_352_] = new soundClip(is);
                    }
                }
                for (int i_354_ = 0; i_354_ < 3; i_354_++) {
                    if (string.equals(new StringBuilder().append("crash").append(i_354_ + 1).append(".wav").toString()))
                        this.crashs[i_354_] = new soundClip(is);
                }
                for (int i_355_ = 0; i_355_ < 3; i_355_++) {
                    if (string.equals(new StringBuilder().append("lowcrash").append(i_355_ + 1).append(".wav").toString()))
                        this.lowcrashs[i_355_] = new soundClip(is);
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
            Object object = null;
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
                    this.compo[i] = new ContO(is, this.m, this.t);
                    (this.compo[i]).shadow = false;
                    (this.compo[i]).noline = true;
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
                this.objfacend = true;
            if (string_391_.equals(""))
                string_391_ = "0";
            if (this.multf10)
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
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        if (string.indexOf("Publish") != -1) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
        }
        this.bx[this.btn] = i;
        this.by[this.btn] = i_393_ - 5;
        this.bw[this.btn] = this.ftm.stringWidth(string);
        if (!this.pessd[this.btn]) {
            this.rd.setColor(new Color(220, 220, 220));
            if (bool)
                this.rd.setColor(new Color(230, 230, 230));
            this.rd.fillRect(i - this.bw[this.btn] / 2 - 10, i_393_ - (17 - i_394_), this.bw[this.btn] + 20, 25 - i_394_ * 2);
            this.rd.setColor(new Color(240, 240, 240));
            if (bool)
                this.rd.setColor(new Color(255, 255, 255));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ - (17 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ - (17 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ - (18 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ - (18 - i_394_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_393_ - (19 - i_394_), i + this.bw[this.btn] / 2 + 9, i_393_ - (19 - i_394_));
            this.rd.setColor(new Color(200, 200, 200));
            if (bool)
                this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 10, i_393_ - (17 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ + (7 - i_394_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 11, i_393_ - (17 - i_394_), i + this.bw[this.btn] / 2 + 11, i_393_ + (7 - i_394_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 12, i_393_ - (16 - i_394_), i + this.bw[this.btn] / 2 + 12, i_393_ + (6 - i_394_));
            if (bool)
                this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ + (7 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ + (7 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ + (8 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ + (8 - i_394_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_393_ + (9 - i_394_), i + this.bw[this.btn] / 2 + 9, i_393_ + (9 - i_394_));
            this.rd.setColor(new Color(240, 240, 240));
            if (bool)
                this.rd.setColor(new Color(255, 255, 255));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ - (17 - i_394_), i - this.bw[this.btn] / 2 - 10, i_393_ + (7 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 11, i_393_ - (17 - i_394_), i - this.bw[this.btn] / 2 - 11, i_393_ + (7 - i_394_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 12, i_393_ - (16 - i_394_), i - this.bw[this.btn] / 2 - 12, i_393_ + (6 - i_394_));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, i - this.bw[this.btn] / 2, i_393_);
        } else {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(i - this.bw[this.btn] / 2 - 10, i_393_ - (17 - i_394_), this.bw[this.btn] + 20, 25 - i_394_ * 2);
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ - (17 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ - (17 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ - (18 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ - (18 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_393_ - (19 - i_394_), i + this.bw[this.btn] / 2 + 9, i_393_ - (19 - i_394_));
            this.rd.setColor(new Color(247, 247, 247));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 10, i_393_ - (17 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ + (7 - i_394_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 11, i_393_ - (17 - i_394_), i + this.bw[this.btn] / 2 + 11, i_393_ + (7 - i_394_));
            this.rd.drawLine(i + this.bw[this.btn] / 2 + 12, i_393_ - (16 - i_394_), i + this.bw[this.btn] / 2 + 12, i_393_ + (6 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ + (7 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ + (7 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ + (8 - i_394_), i + this.bw[this.btn] / 2 + 10, i_393_ + (8 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 9, i_393_ + (9 - i_394_), i + this.bw[this.btn] / 2 + 9, i_393_ + (9 - i_394_));
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 10, i_393_ - (17 - i_394_), i - this.bw[this.btn] / 2 - 10, i_393_ + (7 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 11, i_393_ - (17 - i_394_), i - this.bw[this.btn] / 2 - 11, i_393_ + (7 - i_394_));
            this.rd.drawLine(i - this.bw[this.btn] / 2 - 12, i_393_ - (16 - i_394_), i - this.bw[this.btn] / 2 - 12, i_393_ + (6 - i_394_));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(string, i - this.bw[this.btn] / 2 + 1, i_393_ + 1);
        }
        this.btn++;
    }
    
    public boolean ovbutton(String string, int i, int i_395_) {
        this.rd.setFont(new Font("Arial", 0, 12));
        this.ftm = this.rd.getFontMetrics();
        if (string.equals("X") || string.equals("Download")) {
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
        }
        int i_396_ = this.ftm.stringWidth(string);
        int i_397_ = 4;
        boolean bool = false;
        boolean bool_398_ = false;
        if (Math.abs(this.xm - i) < i_396_ / 2 + 12 && Math.abs(this.ym - i_395_ + 5) < 10 && this.mouses == 1)
            bool = true;
        else
            bool = false;
        if (Math.abs(this.xm - i) < i_396_ / 2 + 12 && Math.abs(this.ym - i_395_ + 5) < 10 && this.mouses == -1) {
            this.mouses = 0;
            bool_398_ = true;
        }
        if (!bool) {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i_396_ + 20, 25 - i_397_ * 2);
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ - (17 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (18 - i_397_), i + i_396_ / 2 + 10, i_395_ - (18 - i_397_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_396_ / 2 - 9, i_395_ - (19 - i_397_), i + i_396_ / 2 + 9, i_395_ - (19 - i_397_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i + i_396_ / 2 + 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ + (7 - i_397_));
            this.rd.drawLine(i + i_396_ / 2 + 11, i_395_ - (17 - i_397_), i + i_396_ / 2 + 11, i_395_ + (7 - i_397_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i + i_396_ / 2 + 12, i_395_ - (16 - i_397_), i + i_396_ / 2 + 12, i_395_ + (6 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ + (7 - i_397_), i + i_396_ / 2 + 10, i_395_ + (7 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ + (8 - i_397_), i + i_396_ / 2 + 10, i_395_ + (8 - i_397_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i - i_396_ / 2 - 9, i_395_ + (9 - i_397_), i + i_396_ / 2 + 9, i_395_ + (9 - i_397_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i - i_396_ / 2 - 10, i_395_ + (7 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 11, i_395_ - (17 - i_397_), i - i_396_ / 2 - 11, i_395_ + (7 - i_397_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_396_ / 2 - 12, i_395_ - (16 - i_397_), i - i_396_ / 2 - 12, i_395_ + (6 - i_397_));
            this.rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                this.rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                this.rd.setColor(new Color(0, 64, 128));
            this.rd.drawString(string, i - i_396_ / 2, i_395_);
        } else {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i_396_ + 20, 25 - i_397_ * 2);
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ - (17 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (18 - i_397_), i + i_396_ / 2 + 10, i_395_ - (18 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 9, i_395_ - (19 - i_397_), i + i_396_ / 2 + 9, i_395_ - (19 - i_397_));
            this.rd.setColor(new Color(247, 247, 247));
            this.rd.drawLine(i + i_396_ / 2 + 10, i_395_ - (17 - i_397_), i + i_396_ / 2 + 10, i_395_ + (7 - i_397_));
            this.rd.drawLine(i + i_396_ / 2 + 11, i_395_ - (17 - i_397_), i + i_396_ / 2 + 11, i_395_ + (7 - i_397_));
            this.rd.drawLine(i + i_396_ / 2 + 12, i_395_ - (16 - i_397_), i + i_396_ / 2 + 12, i_395_ + (6 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ + (7 - i_397_), i + i_396_ / 2 + 10, i_395_ + (7 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ + (8 - i_397_), i + i_396_ / 2 + 10, i_395_ + (8 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 9, i_395_ + (9 - i_397_), i + i_396_ / 2 + 9, i_395_ + (9 - i_397_));
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - i_396_ / 2 - 10, i_395_ - (17 - i_397_), i - i_396_ / 2 - 10, i_395_ + (7 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 11, i_395_ - (17 - i_397_), i - i_396_ / 2 - 11, i_395_ + (7 - i_397_));
            this.rd.drawLine(i - i_396_ / 2 - 12, i_395_ - (16 - i_397_), i - i_396_ / 2 - 12, i_395_ + (6 - i_397_));
            this.rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                this.rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                this.rd.setColor(new Color(0, 64, 128));
            this.rd.drawString(string, i - i_396_ / 2 + 1, i_395_ + 1);
        }
        return bool_398_;
    }
    
    public void actionPerformed(ActionEvent actionevent) {
        TextComponent textcomponent = this.wv[0];
        if (Madness.textid >= 0 && Madness.textid <= 15)
            textcomponent = this.wv[Madness.textid];
        if (Madness.textid == 16)
            textcomponent = this.srch;
        if (Madness.textid == 17)
            textcomponent = this.rplc;
        if (Madness.textid == 18)
            textcomponent = this.editor;
        String string = actionevent.getActionCommand();
        if (string.equals("Cut")) {
            StringSelection stringselection = new StringSelection(textcomponent.getSelectedText());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
            if (Madness.textid == 18)
                this.editor.replaceText("", this.editor.getSelectionStart(), this.editor.getSelectionEnd());
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
                    this.editor.replaceText(string_399_, this.editor.getSelectionStart(), this.editor.getSelectionEnd());
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
