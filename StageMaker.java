/* StageMaker - Decompiled by JODE extended
 * DragShot Software
 * JODE (c) 1998-2001 Jochen Hoenicke
 */
import java.applet.Applet;
import java.awt.AlphaComposite;
import java.awt.Checkbox;
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
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.swing.JOptionPane;
public class StageMaker extends Applet implements Runnable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2444709970063151411L;
	Graphics2D rd;
    Image offImage;
    Thread thredo;
    boolean exwist = false;
    FontMetrics ftm;
    int apx = 0;
    int apy = 0;
    String sstage = "";
    String suser = "Horaks";
    int tab = 0;
    int tabed = -1;
    Image[] btgame = new Image[2];
    Image logo;
    boolean onbtgame = false;
    boolean focuson = true;
    boolean overcan = false;
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;
    boolean zoomi = false;
    boolean zoomo = false;
    String stagename = "";
    String tstage = new StringBuilder().append("snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\n\rmountains(").append((int) (Math.random() * 100000.0)).append(")\r\nnlaps(5)\r\n\r\n").toString();
    String bstage = "set(47,0,0,0)\r\nmaxr(11,28500,-5600)\r\nmaxb(9,-8000,-12300)\r\nmaxl(11,-14700,-5600)\r\nmaxt(9,44800,-12300)\r\n";
    String[] undos = new String[5000];
    int nundo = 0;
    Medium m = new Medium();
    CheckPoints cp = new CheckPoints();
    Trackers t = new Trackers();
    ContO[] bco = new ContO[67];
    ContO[] co = new ContO[10000];
    int nob = 0;
    int xnob = 0;
    int errd = 0;
    int origfade = 5000;
    int sfase = 0;
    Smenu slstage = new Smenu(2000);
    TextField srch = new TextField("", 38);
    Smenu strtyp = new Smenu(40);
    Smenu ptyp = new Smenu(40);
    Smenu part = new Smenu(40);
    int sptyp = 0;
    int spart = 0;
    int sp = 0;
    int lsp = -1;
    int seq = 0;
    boolean setcur = false;
    boolean epart = false;
    boolean arrng = false;
    int esp = -1;
    int hi = -1;
    int arrcnt = 0;
    int chi = -1;
    boolean seqn = false;
    int rot = 0;
    int adrot = 0;
    Image[] su = new Image[2];
    Image[] sl = new Image[2];
    Image[] sd = new Image[2];
    Image[] sr = new Image[2];
    Image[] zi = new Image[2];
    Image[] zo = new Image[2];
    boolean pgen = false;
    float pwd = (float) (2L + Math.round(Math.random() * 4.0));
    float phd = (float) (2L + Math.round(Math.random() * 4.0));
    int fgen = 0;
    int sx = 0;
    int sz = 1500;
    int sy = -10000;
    TextField fixh = new TextField("2000", 5);
    int hf = 2000;
    int[][] atp = { { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 1520, 2830, -1520, -2830 }, { -1520, 2830, 1520, -2830 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 560, 0, -560 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 385, 980, 385, -980 }, { 0, 0, 0, -600 }, { 0, 0, 0, 0 }, { 0, 2164, 0, -2164 }, { 0, 2164, 0, -2164 }, { 0, 3309, 0, -1680 }, { 0, 1680, 0, -3309 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1810, 980, 1810, -980 }, { 0, 0, 0, 0 }, { 0, 500, 0, -500 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 1680, 0, -3309 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 700, 1400, 700, -1400 }, { 0, -1480, 0, -1480 }, { 0, 0, 0, 0 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 700, 0, -700, 0 }, { 0, 0, 0, 0 }, { 0, -2198, 0, 1482 }, { 0, -1319, 0, 1391 }, { 0, -1894, 0, 2271 }, { 0, -826, 0, 839 }, { 0, -1400, 0, 1400 }, { 0, -1400, 0, 1400 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
    String[] discp = { "NormalRoad :  Basic asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',  'NormalRoad Edged',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad Edged :  Asphalt road with edged side blocks (a destructive road).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad TwistedRight :  Asphalt road twisted towards the right.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad Twistedleft',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad TwistedLeft :  Asphalt road twisted towards the left.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad Turn :  Asphalt corner road turn.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp', 'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "OffRoad :  Basic sandy dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "OffRoad BumpyGreen :  Dirt-road with bumpy greenery in the middle.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "OffRoad Turn :  Dirt-road corner turn.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand 'Normal-Off-Road Blend'\n\n", "HalfpipeRoad :  Basic road for the half-pipe ramp.\nAttaches correctly to the following other parts :\n\n'Off-Halfpipe-Road Blend',  'HalfpipeRoad',  'HalfpipeRoad Turn',  'HalfpipeRoad-Ramp Filler'\nand  'Halfpipe-Normal-Road Blend'\n\n", "HalfpipeRoad Turn :  Half-pipe corner road turn.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'  and  'Halfpipe-Normal-Road Blend'\n\n", "Normal-Off-Road Blend :  Road blend between the normal asphalt road and the dirt-road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp', 'Halfpipe-Normal-Road Blend' 'OffRoad',  'OffRoad Turn',\n'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start'  and  'Off-Halfpipe-Road Blend'\n\n", "Off-Halfpipe-Road Blend :  Road blend between the dirt-road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',\n'HalfpipeRoad',  'HalfpipeRoad Turn',  'Halfpipe-Normal-Road Blend'  and  'Normal-Off-Road Blend'\n\n", "Halfpipe-Normal-Road Blend :  Road blend between the normal asphalt road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp',  'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'\nand  'Off-Halfpipe-Road Blend'\n\n", "NormalRoad End :  The end part of the normal asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "OffRoad End :  The end part of the dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "HalfpipeRoad-Ramp Filler :  A part that gets placed between the half-pipe road and the half-pipe ramp to extend the distance in between.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad'  and  'Halfpipe'\n\n", "Basic Ramp :  Basic 30 degree asphalt ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Crash Ramp :  A 35 degree ramp with big side blocks for crashing into.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Two-Way Ramp :  Two way 15 degree inclined ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Two-Way High-Low Ramp :  Two way 15 degree inclined ramp, with peeked side for an optional higher car jump.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Landing Ramp :  A ramp that is both a landing inclination and an obstacle as well, it is usually placed just after another normal ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Big-Takeoff Ramp:  A big takeoff ramp for getting huge heights with the cars.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Small Ramp :  A small ramp that can be placed on either side of the road.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Offroad Bump Ramp :  A small bump ramp that is to be placed over the off-road dirt tracks.\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Offroad Big Ramp :  The big off-road dirt mountain like ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Offroad Ramp :  Normal sized off-road dirt track ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Halfpipe :  The Half-pipe ramp, two of these ramps opposite each other create a half-pipe for the cars!\nAttaches correctly over and to the following other parts :\n\n'HalfpipeRoad',  'HalfpipeRoad Turn'  and  'HalfpipeRoad-Ramp Filler'\n\n", "Spiky Pillars :  An obstacle that is usually placed after a ramp for the cars to crash onto if they did not jump high or far enough!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Rail Doorway :  A rail doorway that works as an obstacle for cars flying above it or cars driving through it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "The Wall", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "Fixing Hoop :  The fixing hoop that fixes a car when it flies through it! You can add a max of 5 fixing hoops per stage.\nPlace it anywhere in the stage at an height your choose, the only important thing is that it needs to be reachable by the cars.", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "OffRoad BumpySides :  Off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad-BumpySides Start'\n\n", "OffRoad-BumpySides Start: The start of the off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides',\n'Off-Halfpipe-Road Blend'  and  'Normal-Off-Road Blend'\n\n", "NormalRoad-Raised Ramp:  The start of the raised above the ground road (NormalRoad Raised).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight'  and  'NormalRoad Raised'\n\n", "NormalRoad Raised :  Normal road raised above the ground, cars must avoid falling off it when driving on it.\nAttaches correctly to the following other parts :\n\n'NormalRoad-Raised Ramp'\n\n", "The Start1", "The Start2", "Tunnel Side Ramp:  A ramp that can be used to create a tunnel like road with an open top or can be used as a wall ramp!\nAttaches correctly over only the 'NormalRoad' part.", "Launch Pad Ramp:  A ramp that launches your car fully upwards like a rocket, it also has sides to lock any car climbing it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "The Net:  An obstacle part that is to be placed in the center of the road right after a ramp, the idea is that the\ncars jumping the ramp should try to go over it or through it without getting caught crashing (without getting\ncaught in it, getting caught in the net!).\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Speed Ramp:  A ramp that is designed to have the perfect angle to catapult your car the furthest when doing forward loops, it is half the roads width.\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Offroad Hill Ramp:  An offroad hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Bump Slide:  A small bump obstacle that is to be placed on the sides of the road or in the center.\nAttaches correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Offroad Big Hill Ramp:  An offroad big hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Rollercoaster Start/End:  The ramp that starts the Rollercoaster Road and ends it.\nAttaches correctly over and to following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n 'NormalRoad TwistedRight'  and  'Rollercoaster Start/End'\n\n", "Rollercoaster Road1\nAttaches correctly to only 'Rollercoaster Start/End', 'Rollercoaster Road2' and itself.\n\n", "Rollercoaster Road3\nAttaches correctly to only 'Rollercoaster Road2', 'Rollercoaster Road4' and itself.\n\n", "Rollercoaster Road4\nAttaches correctly to only 'Rollercoaster Road3', 'Rollercoaster Road5' and itself.\n\n", "Rollercoaster Road2\nAttaches correctly to only 'Rollercoaster Road1', 'Rollercoaster Road3' and itself.\n\n", "Rollercoaster Road5\nAttaches correctly to only 'Rollercoaster Road4' and itself.\n\n", "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n", "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Ground Piles are to be paced outside the race track on the ground and NEVER on any road part or ramp!\nThey are to be used as ground decoration and out of race course obstacles (ground obstacles)!\n\n" };
    String[] errlo = { "The maximum allocated memory for the stage's part's details has been exerted.\nPlease decrease the amount of parts in the stage that have more details then average.", "The maximum amount of road points allowed in the track has been exceeded.\nPlease remove some of the road parts that are in the circler path of the track (the parts that are between the checkpoints).\nOr try to remove some of the extra checkpoints in the track as well.", "The maximum allowed area for a track (the area in between its walls) has been exceeded.\nPlease try to place parts only inside the current allowed area, inside the area between the current maximum wall placements.", "The maximum number of parts allowed per stage has been exceeded.\nPlease remove some of the already extra parts placed in order to make space.", "The maximum number of Fixing Hoops allowed per stage is 5!\nPlease remove the extra Fixing Hoops from your stage to have only 5 main ones left.", "Unknown Error, please make sure the stage you are handling is saved correctly.\nPlease go to the 'Build' tab and press 'Save & Preview'.", "There needs to be at least 2 checkpoints in the Stage in order for the game to work.\nPlease go to the 'Build' tab and select 'Checkpoint' in the Part Selection menu to add more checkpoints.", "The name of the stage is too long!\nPlease go to the 'Stage' tab, click 'Rename Stage' and give your stage a shorter name." };
    int[] rcheckp = { 0, 1, 2, 3, 4, 12, 13, 37 };
    int[] ocheckp = { 5, 6, 7, 11, 14, 33, 34, 38 };
    boolean onoff = false;
    boolean onfly = false;
    int flyh = 0;
    int[] csky = { 170, 220, 255 };
    int[] cgrnd = { 205, 200, 200 };
    int[] cfade = { 255, 220, 220 };
    int[] texture = { 0, 0, 0, 10 };
    int[] cldd = { 210, 210, 210, 1, -1000 };
    TextField mgen = new TextField("", 10);
    int vxz = 0;
    int vx = 0;
    int vz = 0;
    int vy = 0;
    int dtab = 0;
    int dtabed = -1;
    int mouseon = -1;
    float[][] hsb = { { 0.5F, 0.875F, 0.5F }, { 0.5F, 0.875F, 0.5F }, { 0.5F, 0.875F, 0.5F } };
    Checkbox pfog = new Checkbox("Linked Blend");
    int[] snap = { 50, 50, 50 };
    int[] fogn = { 60, 0 };
    Smenu nlaps = new Smenu(40);
    Smenu tracks = new Smenu(2000);
    String trackname = "";
    String ltrackname = "";
    int trackvol = 200;
    int tracksize = 111;
    RadicalMod track = new RadicalMod();
    int avon = 0;
    Smenu witho = new Smenu(40);
    int logged = 0;
    TextField tnick = new TextField("", 15);
    TextField tpass = new TextField("", 15);
    Smenu pubtyp = new Smenu(40);
    int nms = 0;
    String[] mystages = new String[20];
    String[] maker = new String[20];
    int[] pubt = new int[20];
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
    int lxm = 0;
    int lym = 0;
    int cntout = 0;
    boolean preop = false;
    boolean mousdr = false;
    String ttstage = "";
    
    public void run() {
        this.thredo.setPriority(10);
        this.btgame[0] = getImage("data/backtogame1.gif");
        this.btgame[1] = getImage("data/backtogame2.gif");
        this.logo = getImage("data/stagemakerlogo.gif");
        for (int i = 0; i < 2; i++) {
            this.su[i] = getImage(new StringBuilder().append("data/su").append(i + 1).append(".gif").toString());
            this.sl[i] = getImage(new StringBuilder().append("data/sl").append(i + 1).append(".gif").toString());
            this.sd[i] = getImage(new StringBuilder().append("data/sd").append(i + 1).append(".gif").toString());
            this.sr[i] = getImage(new StringBuilder().append("data/sr").append(i + 1).append(".gif").toString());
            this.zi[i] = getImage(new StringBuilder().append("data/zi").append(i + 1).append(".gif").toString());
            this.zo[i] = getImage(new StringBuilder().append("data/zo").append(i + 1).append(".gif").toString());
        }
        loadbase();
        loadsettings();
        if (Madness.testdrive != 0) {
            if (Madness.testcar.equals("Failx12")) {
                JOptionPane.showMessageDialog(null, "Failed to load stage! Please make sure stage is saved properly before Test Drive.", "Stage Maker", 1);
                this.thredo.stop();
            } else {
                this.stagename = Madness.testcar;
                this.errd = 0;
                readstage(3);
                if (this.errd == 0) {
                    this.tab = 2;
                    this.dtab = 6;
                    this.witho.select(Madness.testdrive - 3);
                }
            }
            Madness.testcar = "";
            Madness.testdrive = 0;
        }
        requestFocus();
        while (!this.exwist) {
            this.rd.setColor(new Color(225, 225, 225));
            this.rd.fillRect(0, 25, 800, 525);
            this.rd.setColor(new Color(0, 0, 0));
            if (this.tab != this.tabed)
                hidefields();
            if (this.tab == 0) {
                if (this.tabed != this.tab) {
                    this.slstage.removeAll();
                    (this.slstage).maxl = 360;
                    this.slstage.add(this.rd, "Select a Stage                      ");
                    String[] strings = new File("mystages/").list();
                    if (strings != null) {
                        for (int i = 0; i < strings.length; i++) {
                            if (strings[i].toLowerCase().endsWith(".txt"))
                                this.slstage.add(this.rd, strings[i].substring(0, strings[i].length() - 4));
                        }
                    }
                    if (this.stagename.equals(""))
                        this.slstage.select(0);
                    else {
                        this.slstage.select(this.stagename);
                        if (this.stagename.equals(this.slstage.getSelectedItem())) {
                            readstage(3);
                            this.sx = 0;
                            this.sz = 1500;
                            this.sy = -10000;
                        } else {
                            this.stagename = "";
                            this.slstage.select(0);
                        }
                    }
                    this.mouseon = -1;
                    this.sfase = 0;
                }
                this.rd.drawImage(this.logo, 261, 35, null);
                if (this.xm > 261 && this.xm < 538 && this.ym > 35 && this.ym < 121) {
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
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.xm > 200 && this.xm < 550 && this.ym > 467 && this.ym < 504) {
                    if (this.mouseon == -1) {
                        this.mouseon = 2;
                        setCursor(new Cursor(12));
                    }
                } else if (this.mouseon == 2) {
                    this.mouseon = -1;
                    setCursor(new Cursor(0));
                }
                if (this.mouseon == 2)
                    this.rd.setColor(new Color(0, 64, 128));
                else
                    this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("For the Stage Maker Homepage, Development Center and Forums :", 400 - this.ftm.stringWidth("For the Stage Maker Homepage, Development Center and Forums :") / 2, 480);
                this.rd.setColor(new Color(0, 128, 255));
                String string = "http://www.needformadness.com/developer/";
                this.rd.drawString(string, 400 - this.ftm.stringWidth(string) / 2, 500);
                if (this.mouseon == 2)
                    this.rd.setColor(new Color(0, 128, 255));
                else
                    this.rd.setColor(new Color(0, 64, 128));
                this.rd.drawLine(400 - this.ftm.stringWidth(string) / 2, 501, 400 + this.ftm.stringWidth(string) / 2, 501);
                if (this.mouseon == 2 && this.mouses == -1)
                    openhlink();
                int i = -110;
                if (this.xm > 150 && this.xm < 600 && this.ym > 467 + i && this.ym < 504 + i) {
                    if (this.mouseon == -1) {
                        this.mouseon = 1;
                        setCursor(new Cursor(12));
                    }
                } else if (this.mouseon == 1) {
                    this.mouseon = -1;
                    setCursor(new Cursor(0));
                }
                if (this.mouseon == 1)
                    this.rd.setColor(new Color(0, 64, 128));
                else
                    this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("For help and a detailed step by step description on how to use the Stage Maker :", 400 - this.ftm.stringWidth("For help and a detailed step by step description on how to use the Stage Maker :") / 2, 480 + i);
                this.rd.setColor(new Color(0, 128, 255));
                string = "http://www.needformadness.com/developer/help.html";
                this.rd.drawString(string, 400 - this.ftm.stringWidth(string) / 2, 500 + i);
                if (this.mouseon == 1)
                    this.rd.setColor(new Color(0, 128, 255));
                else
                    this.rd.setColor(new Color(0, 64, 128));
                this.rd.drawLine(400 - this.ftm.stringWidth(string) / 2, 501 + i, 400 + this.ftm.stringWidth(string) / 2, 501 + i);
                if (this.mouseon == 1 && this.mouses == -1)
                    openlink();
                int i_0_ = -60;
                int i_1_ = 70;
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRect(227 - i_1_, 194 + i_0_, 346 + i_1_ * 2, 167 + i_1_ / 5);
                if (this.sfase == 0) {
                    this.rd.drawString("Select Stage to Edit", 400 - this.ftm.stringWidth("Select Stage to Edit") / 2, 230 + i_0_);
                    this.slstage.move(220, 240 + i_0_);
                    if (this.slstage.getWidth() != 360)
                        this.slstage.setSize(360, 21);
                    if (!this.slstage.isShowing())
                        this.slstage.show();
                    if (button("    Make new Stage    ", 400, 296 + i_0_, 0, true)) {
                        this.srch.setText("");
                        this.slstage.hide();
                        this.sfase = 1;
                    }
                    if (button("     Rename Stage     ", 325, 336 + i_0_, 0, false)) {
                        if (!this.stagename.equals("")) {
                            this.slstage.hide();
                            this.srch.setText(this.stagename);
                            this.sfase = 2;
                        } else
                            JOptionPane.showMessageDialog(null, "Please select a stage to rename first.", "Stage Maker", 1);
                    }
                    if (button("      Delete Stage      ", 475, 336 + i_0_, 0, false)) {
                        if (!this.stagename.equals("")) {
                            if (JOptionPane.showConfirmDialog(null, new StringBuilder().append("Are you sure you want to permanently delete this stage?\n\n").append(this.stagename).append("\n\n").toString(), "Stage Maker", 0) == 0)
                                delstage(this.stagename);
                        } else
                            JOptionPane.showMessageDialog(null, "Please select a stage to delete first.", "Stage Maker", 1);
                    }
                    if (this.slstage.getSelectedIndex() != 0) {
                        if (!this.stagename.equals(this.slstage.getSelectedItem())) {
                            this.stagename = this.slstage.getSelectedItem();
                            readstage(3);
                            this.sx = 0;
                            this.sz = 1500;
                            this.sy = -10000;
                            requestFocus();
                        }
                    } else
                        this.stagename = "";
                }
                if (this.sfase == 1) {
                    this.rd.drawString("Make a new Stage", 400 - this.ftm.stringWidth("Make a new Stage") / 2, 220 + i_0_);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("New stage name :", 200, 246 + i_0_);
                    movefield(this.srch, 310, 231 + i_0_, 290, 23);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                        this.srch.requestFocus();
                    }
                    fixtext(this.srch);
                    this.rd.drawString("Starting line type :", 293, 272 + i_0_);
                    this.strtyp.move(408, 256 + i_0_);
                    if (!this.strtyp.isShowing())
                        this.strtyp.show();
                    if (button("    Make Stage    ", 400, 311 + i_0_, 0, true))
                        newstage();
                    if (button("  Cancel  ", 400, 351 + i_0_, 0, false)) {
                        this.strtyp.hide();
                        this.srch.hide();
                        this.sfase = 0;
                    }
                }
                if (this.sfase == 2) {
                    this.rd.drawString(new StringBuilder().append("Rename Stage :  ").append(this.stagename).append("").toString(), 400 - this.ftm.stringWidth(new StringBuilder().append("Rename Stage :  ").append(this.stagename).append("").toString()) / 2, 230 + i_0_);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("New name :", 218, 266 + i_0_);
                    if (!this.srch.isShowing()) {
                        this.srch.show();
                        this.srch.requestFocus();
                    }
                    movefield(this.srch, 292, 251 + i_0_, 290, 23);
                    fixtext(this.srch);
                    if (button("    Rename Stage    ", 400, 306 + i_0_, 0, true))
                        renstage(this.srch.getText());
                    if (button("  Cancel  ", 400, 346 + i_0_, 0, false)) {
                        this.srch.hide();
                        this.sfase = 0;
                    }
                }
            }
            if (this.tab == 1) {
                if (this.tabed != this.tab) {
                    (this.m).trk = 2;
                    readstage(0);
                    if (this.sptyp == 0)
                        partroads();
                    if (this.sptyp == 1)
                        partramps();
                    if (this.sptyp == 2)
                        partobst();
                    if (this.sptyp == 5)
                        partrees();
                    this.onoff = false;
                    setCursor(new Cursor(0));
                    this.setcur = false;
                    this.epart = false;
                    this.arrng = false;
                    if (this.nob == 1) {
                        this.sptyp = 0;
                        if ((this.co[0]).colok == 38)
                            this.spart = 9;
                        else
                            this.spart = 0;
                    }
                    this.mouseon = -1;
                }
                if (this.sptyp == 0) {
                    if (this.spart == 0)
                        this.sp = 0;
                    if (this.spart == 1)
                        this.sp = 4;
                    if (this.spart == 2)
                        this.sp = 13;
                    if (this.spart == 3)
                        this.sp = 3;
                    if (this.spart == 4)
                        this.sp = 2;
                    if (this.spart == 5)
                        this.sp = 1;
                    if (this.spart == 6)
                        this.sp = 35;
                    if (this.spart == 7)
                        this.sp = 36;
                    if (this.spart == 8)
                        this.sp = 10;
                    if (this.spart == 9)
                        this.sp = 5;
                    if (this.spart == 10)
                        this.sp = 7;
                    if (this.spart == 11)
                        this.sp = 14;
                    if (this.spart == 12)
                        this.sp = 6;
                    if (this.spart == 13)
                        this.sp = 34;
                    if (this.spart == 14)
                        this.sp = 33;
                    if (this.spart == 15)
                        this.sp = 11;
                    if (this.spart == 16)
                        this.sp = 8;
                    if (this.spart == 17)
                        this.sp = 9;
                    if (this.spart == 18)
                        this.sp = 15;
                    if (this.spart == 19)
                        this.sp = 12;
                    if (this.spart == 20)
                        this.sp = 46;
                    if (this.spart == 21)
                        this.sp = 47;
                    if (this.spart == 22)
                        this.sp = 50;
                    if (this.spart == 23)
                        this.sp = 48;
                    if (this.spart == 24)
                        this.sp = 49;
                    if (this.spart == 25)
                        this.sp = 51;
                }
                if (this.sptyp == 1) {
                    if (this.spart == 0)
                        this.sp = 16;
                    if (this.spart == 1)
                        this.sp = 18;
                    if (this.spart == 2)
                        this.sp = 19;
                    if (this.spart == 3)
                        this.sp = 22;
                    if (this.spart == 4)
                        this.sp = 17;
                    if (this.spart == 5)
                        this.sp = 21;
                    if (this.spart == 6)
                        this.sp = 20;
                    if (this.spart == 7)
                        this.sp = 39;
                    if (this.spart == 8)
                        this.sp = 42;
                    if (this.spart == 9)
                        this.sp = 40;
                    if (this.spart == 10)
                        this.sp = 23;
                    if (this.spart == 11)
                        this.sp = 25;
                    if (this.spart == 12)
                        this.sp = 24;
                    if (this.spart == 13)
                        this.sp = 43;
                    if (this.spart == 14)
                        this.sp = 45;
                    if (this.spart == 15)
                        this.sp = 26;
                }
                if (this.sptyp == 2) {
                    if (this.spart == 0)
                        this.sp = 27;
                    if (this.spart == 1)
                        this.sp = 28;
                    if (this.spart == 2)
                        this.sp = 41;
                    if (this.spart == 3)
                        this.sp = 44;
                    if (this.spart == 4)
                        this.sp = 52;
                    if (this.spart == 5)
                        this.sp = 53;
                }
                if (this.sptyp == 3) {
                    if (this.onfly)
                        this.sp = 54;
                    else if (!this.onoff)
                        this.sp = 30;
                    else
                        this.sp = 32;
                }
                if (this.sptyp == 4)
                    this.sp = 31;
                if (this.sptyp == 5) {
                    if (this.spart == 0)
                        this.sp = 55;
                    if (this.spart == 1)
                        this.sp = 56;
                    if (this.spart == 2)
                        this.sp = 57;
                    if (this.spart == 3)
                        this.sp = 58;
                    if (this.spart == 4)
                        this.sp = 59;
                    if (this.spart == 5)
                        this.sp = 60;
                    if (this.spart == 6)
                        this.sp = 61;
                    if (this.spart == 7)
                        this.sp = 62;
                    if (this.spart == 8)
                        this.sp = 63;
                    if (this.spart == 9)
                        this.sp = 64;
                    if (this.spart == 10)
                        this.sp = 65;
                }
                if (this.sptyp == 6) {
                    if (!this.pgen) {
                        int i = (int) (10000.0 * Math.random());
                        if (this.fgen != 0) {
                            i = this.fgen;
                            this.fgen = 0;
                        }
                        this.bco[66] = new ContO(i, (int) this.pwd, (int) this.phd, this.m, this.t, 0, 0, 0);
                        (this.bco[66]).srz = i;
                        (this.bco[66]).srx = (int) this.pwd;
                        (this.bco[66]).sry = (int) this.phd;
                        this.pgen = true;
                        this.seq = 3;
                    }
                    this.sp = 66;
                    this.rot = 0;
                } else if (this.pgen) {
                    this.pgen = false;
                    this.pwd = (float) (2L + Math.round(Math.random() * 4.0));
                    this.phd = (float) (2L + Math.round(Math.random() * 4.0));
                }
                if (this.sp == 30 || this.sp == 31 || this.sp == 32 || this.sp == 54) {
                    if (this.rot == -90)
                        this.rot = 90;
                    if (this.rot == 180)
                        this.rot = 0;
                }
                this.adrot = 0;
                if (this.sp == 2)
                    this.adrot = -30;
                if (this.sp == 3)
                    this.adrot = 30;
                if (this.sp == 15)
                    this.adrot = 90;
                if (this.sp == 20)
                    this.adrot = 180;
                if (this.sp == 26)
                    this.adrot = 90;
                this.rd.setColor(new Color(200, 200, 200));
                this.rd.fillRect(248, 63, 514, 454);
                (this.m).trk = 2;
                (this.m).zy = 90;
                (this.m).xz = 0;
                (this.m).iw = 248;
                (this.m).w = 762;
                (this.m).ih = 63;
                (this.m).h = 517;
                (this.m).cx = 505;
                (this.m).cy = 290;
                (this.m).x = this.sx - (this.m).cx;
                (this.m).z = this.sz - (this.m).cz;
                (this.m).y = this.sy;
                int i = 0;
                int[] is = new int[10000]; // stageselect limit
                for (int i_2_ = 0; i_2_ < this.nob; i_2_++) {
                    if ((this.co[i_2_]).dist != 0) {
                        is[i] = i_2_;
                        i++;
                    } else
                        this.co[i_2_].d(this.rd);
                }
                int[] is_3_ = new int[i];
                for (int i_4_ = 0; i_4_ < i; i_4_++)
                    is_3_[i_4_] = 0;
                for (int i_5_ = 0; i_5_ < i; i_5_++) {
                    for (int i_6_ = i_5_ + 1; i_6_ < i; i_6_++) {
                        if ((this.co[is[i_5_]]).dist != (this.co[is[i_6_]]).dist) {
                            if ((this.co[is[i_5_]]).dist < (this.co[is[i_6_]]).dist)
                                is_3_[i_5_]++;
                            else
                                is_3_[i_6_]++;
                        } else if (i_6_ > i_5_)
                            is_3_[i_5_]++;
                        else
                            is_3_[i_6_]++;
                    }
                }
                for (int i_7_ = 0; i_7_ < i; i_7_++) {
                    for (int i_8_ = 0; i_8_ < i; i_8_++) {
                        if (is_3_[i_8_] == i_7_) {
                            if (is[i_8_] == this.hi)
                                (this.m).trk = 3;
                            if (is[i_8_] == this.chi && !(this.co[is[i_8_]]).errd) {
                                int i_9_ = (this.m).cx + (int) ((float) ((this.co[is[i_8_]]).x - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) ((this.co[is[i_8_]]).z - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
                                int i_10_ = (this.m).cz + (int) ((float) ((this.co[is[i_8_]]).x - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) ((this.co[is[i_8_]]).z - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
                                int i_11_ = (this.m).cy + (int) ((float) ((this.co[is[i_8_]]).y - (this.m).y - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_10_ - (this.m).cz) * this.m.sin((this.m).zy));
                                int i_12_ = (this.m).cz + (int) ((float) ((this.co[is[i_8_]]).y - (this.m).y - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_10_ - (this.m).cz) * this.m.cos((this.m).zy));
                                int i_13_ = 1000000 / Math.abs(this.sy);
                                Graphics2D graphics2d = this.rd;
                                graphics2d.setComposite(AlphaComposite.getInstance(3, 0.7F));
                                this.rd.setColor(new Color(0, 164, 255));
                                this.rd.fillOval(xs(i_9_, i_12_) - i_13_ / 2, ys(i_11_, i_12_) - i_13_ / 2, i_13_, i_13_);
                                graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(new StringBuilder().append("NO# ").append(this.arrcnt + 1).append("").toString(), xs(i_9_, i_12_) - this.ftm.stringWidth(new StringBuilder().append("NO# ").append(this.arrcnt + 1).append("").toString()) / 2, ys(i_11_, i_12_) - i_13_ / 2);
                            }
                            if (this.arrng && ((this.co[is[i_8_]]).colok == 30 || (this.co[is[i_8_]]).colok == 32 || (this.co[is[i_8_]]).colok == 54) && (this.co[is[i_8_]]).errd) {
                                int i_14_ = (this.m).cx + (int) ((float) ((this.co[is[i_8_]]).x - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) ((this.co[is[i_8_]]).z - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
                                int i_15_ = (this.m).cz + (int) ((float) ((this.co[is[i_8_]]).x - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) ((this.co[is[i_8_]]).z - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
                                int i_16_ = (this.m).cy + (int) ((float) ((this.co[is[i_8_]]).y - (this.m).y - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_15_ - (this.m).cz) * this.m.sin((this.m).zy));
                                int i_17_ = (this.m).cz + (int) ((float) ((this.co[is[i_8_]]).y - (this.m).y - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_15_ - (this.m).cz) * this.m.cos((this.m).zy));
                                int i_18_ = 1000000 / Math.abs(this.sy);
                                Graphics2D graphics2d = this.rd;
                                graphics2d.setComposite(AlphaComposite.getInstance(3, 0.5F));
                                this.rd.setColor(new Color(255, 128, 0));
                                this.rd.fillOval(xs(i_14_, i_17_) - i_18_ / 2, ys(i_16_, i_17_) - i_18_ / 2, i_18_, i_18_);
                                graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString(new StringBuilder().append("NO# ").append((this.co[is[i_8_]]).wh).append("").toString(), xs(i_14_, i_17_) - this.ftm.stringWidth(new StringBuilder().append("NO# ").append((this.co[is[i_8_]]).wh).append("").toString()) / 2, ys(i_16_, i_17_) - i_18_ / 2);
                            }
                            this.co[is[i_8_]].d(this.rd);
                            if ((this.m).trk == 3)
                                (this.m).trk = 2;
                        }
                    }
                }
                if (this.xm > 248 && this.xm < 762 && this.ym > 63 && this.ym < 517) {
                    if (!this.epart && !this.arrng) {
                        (this.bco[this.sp]).x = (this.xm - 505) * (Math.abs(this.sy) / (this.m).focus_point) + this.sx;
                        (this.bco[this.sp]).z = (290 - this.ym) * (Math.abs(this.sy) / (this.m).focus_point) + this.sz;
                        (this.bco[this.sp]).y = (this.m).ground - (this.bco[this.sp]).grat;
                        (this.bco[this.sp]).xz = this.rot + this.adrot;
                        int i_19_ = 200;
                        int i_20_ = 0;
                        int i_21_ = 0;
                        int[] is_22_ = { (this.bco[this.sp]).x + this.atp[this.sp][0], (this.bco[this.sp]).x + this.atp[this.sp][2] };
                        int[] is_23_ = { (this.bco[this.sp]).z + this.atp[this.sp][1], (this.bco[this.sp]).z + this.atp[this.sp][3] };
                        rot(is_22_, is_23_, (this.bco[this.sp]).x, (this.bco[this.sp]).z, this.rot, 2);
                        int i_24_ = 0;
                        this.onfly = false;
                        int i_25_ = 500;
                        for (int i_26_ = 0; i_26_ < this.nob; i_26_++) {
                            int[] is_27_ = { (this.co[i_26_]).x + this.atp[(this.co[i_26_]).colok][0], (this.co[i_26_]).x + this.atp[(this.co[i_26_]).colok][2] };
                            int[] is_28_ = { (this.co[i_26_]).z + this.atp[(this.co[i_26_]).colok][1], (this.co[i_26_]).z + this.atp[(this.co[i_26_]).colok][3] };
                            int i_29_ = (this.co[i_26_]).roofat;
                            if ((this.co[i_26_]).colok == 2)
                                i_29_ += 30;
                            if ((this.co[i_26_]).colok == 3)
                                i_29_ -= 30;
                            if ((this.co[i_26_]).colok == 15)
                                i_29_ -= 90;
                            if ((this.co[i_26_]).colok == 20)
                                i_29_ -= 180;
                            if ((this.co[i_26_]).colok == 26)
                                i_29_ -= 90;
                            rot(is_27_, is_28_, (this.co[i_26_]).x, (this.co[i_26_]).z, i_29_, 2);
                            if (this.sp <= 54) {
                                int i_30_ = py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]);
                                if (i_30_ < i_19_ && i_30_ != 0) {
                                    i_19_ = i_30_;
                                    i_20_ = is_27_[0] - is_22_[0];
                                    i_21_ = is_28_[0] - is_23_[0];
                                }
                                i_30_ = py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]);
                                if (i_30_ < i_19_ && i_30_ != 0) {
                                    i_19_ = i_30_;
                                    i_20_ = is_27_[1] - is_22_[0];
                                    i_21_ = is_28_[1] - is_23_[0];
                                }
                                i_30_ = py(is_27_[1], is_22_[1], is_28_[1], is_23_[1]);
                                if (i_30_ < i_19_ && i_30_ != 0) {
                                    i_19_ = i_30_;
                                    i_20_ = is_27_[1] - is_22_[1];
                                    i_21_ = is_28_[1] - is_23_[1];
                                }
                                i_30_ = py(is_27_[0], is_22_[1], is_28_[0], is_23_[1]);
                                if (i_30_ < i_19_ && i_30_ != 0) {
                                    i_19_ = i_30_;
                                    i_20_ = is_27_[0] - is_22_[1];
                                    i_21_ = is_28_[0] - is_23_[1];
                                }
                            }
                            if (this.sptyp == 3 && py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) != 0 && py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) != 0) {
                                for (int i_31_ = 0; i_31_ < this.rcheckp.length; i_31_++) {
                                    if ((this.co[i_26_]).colok == this.rcheckp[i_31_]) {
                                        if (py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) <= i_24_ || i_24_ == 0) {
                                            i_24_ = py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]);
                                            this.onoff = false;
                                        }
                                        if (py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) <= i_24_) {
                                            i_24_ = py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]);
                                            this.onoff = false;
                                        }
                                    }
                                }
                                for (int i_32_ = 0; i_32_ < this.ocheckp.length; i_32_++) {
                                    if ((this.co[i_26_]).colok == this.ocheckp[i_32_]) {
                                        if (py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) <= i_24_ || i_24_ == 0) {
                                            i_24_ = py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]);
                                            this.onoff = true;
                                        }
                                        if (py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) <= i_24_) {
                                            i_24_ = py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]);
                                            this.onoff = true;
                                        }
                                    }
                                }
                            }
                            if (this.sp > 12 && this.sp < 33 || this.sp == 35 || this.sp == 36 || this.sp >= 39 && this.sp <= 54) {
                                if ((this.rot == 0 || this.rot == 180 || this.sp == 26 || this.sp == 15) && (i_29_ == 0 || i_29_ == 180 || this.sp == 26 || this.sp == 15)) {
                                    if (Math.abs(is_27_[0] - is_22_[0]) < 200)
                                        i_20_ = is_27_[0] - is_22_[0];
                                    if (Math.abs(is_27_[0] - is_22_[1]) < 200)
                                        i_20_ = is_27_[0] - is_22_[1];
                                    if (Math.abs(is_27_[1] - is_22_[1]) < 200)
                                        i_20_ = is_27_[1] - is_22_[1];
                                    if (Math.abs(is_27_[1] - is_22_[0]) < 200)
                                        i_20_ = is_27_[1] - is_22_[0];
                                }
                                if ((this.rot == 90 || this.rot == -90 || this.sp == 26 || this.sp == 15) && (i_29_ == 90 || i_29_ == -90 || this.sp == 26 || this.sp == 15)) {
                                    if (Math.abs(is_28_[0] - is_23_[0]) < 200)
                                        i_21_ = is_28_[0] - is_23_[0];
                                    if (Math.abs(is_28_[0] - is_23_[1]) < 200)
                                        i_21_ = is_28_[0] - is_23_[1];
                                    if (Math.abs(is_28_[1] - is_23_[1]) < 200)
                                        i_21_ = is_28_[1] - is_23_[1];
                                    if (Math.abs(is_28_[1] - is_23_[0]) < 200)
                                        i_21_ = is_28_[1] - is_23_[0];
                                }
                            }
                            if (this.sptyp == 3 && (this.co[i_26_]).colok >= 46 && (this.co[i_26_]).colok <= 51) {
                                int[] is_33_ = { 2, 3, 5, 2, 3, 3 };
                                if ((Math.abs((this.co[i_26_]).roofat) == 180 || (this.co[i_26_]).roofat == 0) && this.rot == 0 && Math.abs((this.bco[this.sp]).x - (this.co[i_26_]).x) < 500 && Math.abs((this.bco[this.sp]).z - (this.co[i_26_]).z) < 3000) {
                                    for (int i_34_ = 0; i_34_ < is_33_[(this.co[i_26_]).colok - 46]; i_34_++) {
                                        for (int i_35_ = 0; i_35_ < ((this.co[i_26_]).p[i_34_]).n; i_35_++) {
                                            if (py((this.bco[this.sp]).x, (this.co[i_26_]).x, (this.bco[this.sp]).z, (this.co[i_26_]).z + ((this.co[i_26_]).p[i_34_]).oz[i_35_]) < i_25_) {
                                                i_25_ = py((this.bco[this.sp]).x, (this.co[i_26_]).x, (this.bco[this.sp]).z, (this.co[i_26_]).z + ((this.co[i_26_]).p[i_34_]).oz[i_35_]);
                                                this.flyh = ((this.co[i_26_]).p[i_34_]).oy[i_35_] - 28 + (this.m).ground;
                                                i_20_ = (this.co[i_26_]).x - (this.bco[this.sp]).x;
                                                i_21_ = (this.co[i_26_]).z + ((this.co[i_26_]).p[i_34_]).oz[i_35_] - (this.bco[this.sp]).z;
                                                this.onfly = true;
                                            }
                                        }
                                    }
                                }
                                if (Math.abs((this.co[i_26_]).roofat) == 90 && this.rot == 90 && Math.abs((this.bco[this.sp]).z - (this.co[i_26_]).z) < 500 && Math.abs((this.bco[this.sp]).x - (this.co[i_26_]).x) < 3000) {
                                    for (int i_36_ = 0; i_36_ < is_33_[(this.co[i_26_]).colok - 46]; i_36_++) {
                                        for (int i_37_ = 0; i_37_ < ((this.co[i_26_]).p[i_36_]).n; i_37_++) {
                                            if (py((this.bco[this.sp]).z, (this.co[i_26_]).z, (this.bco[this.sp]).x, (this.co[i_26_]).x + ((this.co[i_26_]).p[i_36_]).ox[i_37_]) < i_25_) {
                                                i_25_ = py((this.bco[this.sp]).z, (this.co[i_26_]).z, (this.bco[this.sp]).x, (this.co[i_26_]).x + ((this.co[i_26_]).p[i_36_]).ox[i_37_]);
                                                this.flyh = ((this.co[i_26_]).p[i_36_]).oy[i_37_] - 28 + (this.m).ground;
                                                i_21_ = (this.co[i_26_]).z - (this.bco[this.sp]).z;
                                                i_20_ = (this.co[i_26_]).x + ((this.co[i_26_]).p[i_36_]).ox[i_37_] - (this.bco[this.sp]).x;
                                                this.onfly = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        (this.bco[this.sp]).x += i_20_;
                        (this.bco[this.sp]).z += i_21_;
                        int i_38_ = (this.bco[this.sp]).xy;
                        int i_39_ = (this.bco[this.sp]).zy;
                        if (this.sp == 31) {
                            (this.bco[this.sp]).y = -this.hf;
                            if ((this.bco[this.sp]).y > -500)
                                (this.bco[this.sp]).y = -500;
                        } else
                            (this.bco[this.sp]).xy = 0;
                        if (this.sp == 54)
                            (this.bco[this.sp]).y = this.flyh;
                        (this.bco[this.sp]).zy = 0;
                        if (this.cntout == 0) {
                            if (this.mouseon == -1) {
                                this.bco[this.sp].d(this.rd);
                                if (!this.setcur) {
                                    setCursor(new Cursor(13));
                                    this.setcur = true;
                                }
                                if (this.mouses == -1) {
                                    if (this.nundo < 5000) {
                                        this.undos[this.nundo] = this.bstage;
                                        this.nundo++;
                                    }
                                    if ((this.bco[this.sp]).xz == 270)
                                        (this.bco[this.sp]).xz = -90;
                                    if ((this.bco[this.sp]).xz == 360)
                                        (this.bco[this.sp]).xz = 0;
                                    this.errd = 0;
                                    boolean bool = false;
                                    if (this.xnob < 10000) {
                                        if (this.sp != 31 && this.sp != 54 && this.sp != 66) {
                                            try {
                                                this.co[this.nob] = new ContO(this.bco[this.sp], (this.bco[this.sp]).x, (this.m).ground - (this.bco[this.sp]).grat, (this.bco[this.sp]).z, (this.bco[this.sp]).xz);
                                                (this.co[this.nob]).roofat = (this.bco[this.sp]).xz;
                                                (this.co[this.nob]).colok = this.sp;
                                                this.nob++;
                                            } catch (Exception exception) {
                                                this.errd = 1;
                                            }
                                        }
                                        if (this.sp == 31) {
                                            if ((this.cp).fn < 5) {
                                                this.co[this.nob] = new ContO(this.bco[this.sp], (this.bco[this.sp]).x, (this.bco[this.sp]).y, (this.bco[this.sp]).z, (this.bco[this.sp]).xz);
                                                (this.co[this.nob]).roofat = (this.bco[this.sp]).xz;
                                                (this.co[this.nob]).colok = this.sp;
                                                this.nob++;
                                                this.fixh.setText(new StringBuilder().append("").append(Math.abs((this.bco[this.sp]).y)).append("").toString());
                                            } else
                                                this.errd = 5;
                                        }
                                        if (this.sp == 54) {
                                            try {
                                                this.co[this.nob] = new ContO(this.bco[this.sp], (this.bco[this.sp]).x, (this.bco[this.sp]).y, (this.bco[this.sp]).z, (this.bco[this.sp]).xz);
                                                (this.co[this.nob]).roofat = (this.bco[this.sp]).xz;
                                                (this.co[this.nob]).colok = this.sp;
                                                this.nob++;
                                            } catch (Exception exception) {
                                                this.errd = 1;
                                            }
                                        }
                                        if (this.sp == 66) {
                                            this.co[this.nob] = new ContO((this.bco[66]).srz, (this.bco[66]).srx, (this.bco[66]).sry, this.m, this.t, (this.bco[66]).x, (this.bco[66]).z, (this.bco[this.sp]).y);
                                            (this.co[this.nob]).srz = (this.bco[66]).srz;
                                            (this.co[this.nob]).srx = (this.bco[66]).srx;
                                            (this.co[this.nob]).sry = (this.bco[66]).sry;
                                            (this.co[this.nob]).colok = this.sp;
                                            this.nob++;
                                        }
                                    } else
                                        this.errd = 4;
                                    if (this.errd == 0) {
                                        sortstage();
                                        readstage(0);
                                        bool = true;
                                        if (this.sp == 66)
                                            this.pgen = false;
                                        if (this.sp == 52 || this.sp == 53 || this.sp >= 55 && this.sp <= 65) {
                                            this.seq = 3;
                                            (this.bco[this.sp]).xy = 0;
                                            (this.bco[this.sp]).zy = 0;
                                            boolean bool_40_ = false;
                                            if (this.rot == 0 && !bool_40_) {
                                                this.rot = 90;
                                                bool_40_ = true;
                                            }
                                            if (this.rot == 90 && !bool_40_) {
                                                this.rot = 180;
                                                bool_40_ = true;
                                            }
                                            if (this.rot == 180 && !bool_40_) {
                                                this.rot = -90;
                                                bool_40_ = true;
                                            }
                                            if (this.rot == -90 && !bool_40_) {
                                                this.rot = 0;
                                                bool_40_ = true;
                                            }
                                        }
                                    }
                                    if (this.errd != 0) {
                                        JOptionPane.showMessageDialog(null, new StringBuilder().append("Error!  Unable to place part!\nReason:\n").append(this.errlo[this.errd - 1]).append("\n\n").toString(), "Stage Maker", 0);
                                        if (bool) {
                                            this.nundo--;
                                            this.bstage = this.undos[this.nundo];
                                            readstage(0);
                                        }
                                    }
                                    this.lxm = (this.bco[this.sp]).x;
                                    this.lym = (this.bco[this.sp]).z;
                                    this.cntout = 10;
                                }
                            }
                        } else {
                            if (this.lxm != (this.bco[this.sp]).x && this.lxm != (this.bco[this.sp]).z)
                                this.cntout--;
                            if (this.setcur) {
                                setCursor(new Cursor(0));
                                this.setcur = false;
                            }
                        }
                        (this.bco[this.sp]).xy = i_38_;
                        (this.bco[this.sp]).zy = i_39_;
                    } else {
                        if (this.epart) {
                            if (this.esp == -1 && !this.overcan) {
                                this.hi = -1;
                                int i_41_ = 0;
                                for (int i_42_ = 0; i_42_ < this.nob; i_42_++) {
                                    int i_43_ = (this.m).cx + (int) ((float) ((this.co[i_42_]).x - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) ((this.co[i_42_]).z - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
                                    int i_44_ = (this.m).cz + (int) ((float) ((this.co[i_42_]).x - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) ((this.co[i_42_]).z - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
                                    int i_45_ = (this.m).cy + (int) ((float) ((this.co[i_42_]).y - (this.m).y - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_44_ - (this.m).cz) * this.m.sin((this.m).zy));
                                    int i_46_ = (this.m).cz + (int) ((float) ((this.co[i_42_]).y - (this.m).y - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_44_ - (this.m).cz) * this.m.cos((this.m).zy));
                                    if (this.xm > xs(i_43_ - (this.co[i_42_]).maxR, i_46_) && this.xm < xs(i_43_ + (this.co[i_42_]).maxR, i_46_) && this.ym > ys(i_45_ - (this.co[i_42_]).maxR, i_46_) && this.ym < ys(i_45_ + (this.co[i_42_]).maxR, i_46_) && (this.co[i_42_]).colok != 37 && (this.co[i_42_]).colok != 38) {
                                        if (this.hi == -1) {
                                            this.hi = i_42_;
                                            i_41_ = py(this.xm, xs(i_43_, i_46_), this.ym, ys(i_45_, i_46_));
                                        } else if (py(this.xm, xs(i_43_, i_46_), this.ym, ys(i_45_, i_46_)) <= i_41_) {
                                            this.hi = i_42_;
                                            i_41_ = py(this.xm, xs(i_43_, i_46_), this.ym, ys(i_45_, i_46_));
                                        }
                                    }
                                }
                                if (this.hi != -1) {
                                    if (!this.setcur) {
                                        setCursor(new Cursor(13));
                                        this.setcur = true;
                                    }
                                    if (this.mouses == -1) {
                                        this.esp = this.hi;
                                        this.mouses = 0;
                                    }
                                } else if (this.setcur) {
                                    setCursor(new Cursor(0));
                                    this.setcur = false;
                                }
                            } else if (this.setcur) {
                                setCursor(new Cursor(0));
                                this.setcur = false;
                            }
                        }
                        if (this.arrng) {
                            this.chi = -1;
                            int i_47_ = 5000;
                            for (int i_48_ = 0; i_48_ < this.nob; i_48_++) {
                                if (((this.co[i_48_]).colok == 30 || (this.co[i_48_]).colok == 32 || (this.co[i_48_]).colok == 54) && !(this.co[i_48_]).errd) {
                                    int i_49_ = (this.m).cx + (int) ((float) ((this.co[i_48_]).x - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) ((this.co[i_48_]).z - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
                                    int i_50_ = (this.m).cz + (int) ((float) ((this.co[i_48_]).x - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) ((this.co[i_48_]).z - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
                                    int i_51_ = (this.m).cy + (int) ((float) ((this.co[i_48_]).y - (this.m).y - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_50_ - (this.m).cz) * this.m.sin((this.m).zy));
                                    int i_52_ = (this.m).cz + (int) ((float) ((this.co[i_48_]).y - (this.m).y - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_50_ - (this.m).cz) * this.m.cos((this.m).zy));
                                    if (this.xm > xs(i_49_ - (this.co[i_48_]).maxR, i_52_) && this.xm < xs(i_49_ + (this.co[i_48_]).maxR, i_52_) && this.ym > ys(i_51_ - (this.co[i_48_]).maxR, i_52_) && this.ym < ys(i_51_ + (this.co[i_48_]).maxR, i_52_) && py(this.xm, xs(i_49_, i_52_), this.ym, ys(i_51_, i_52_)) <= i_47_) {
                                        this.chi = i_48_;
                                        i_47_ = py(this.xm, xs(i_49_, i_52_), this.ym, ys(i_51_, i_52_));
                                    }
                                }
                            }
                            if (this.chi != -1) {
                                if (!this.setcur) {
                                    setCursor(new Cursor(13));
                                    this.setcur = true;
                                }
                                if (this.mouses == -1) {
                                    this.arrcnt++;
                                    (this.co[this.chi]).wh = this.arrcnt;
                                    (this.co[this.chi]).errd = true;
                                    this.mouses = 0;
                                }
                            } else if (this.setcur) {
                                setCursor(new Cursor(0));
                                this.setcur = false;
                            }
                        }
                    }
                } else if (this.setcur) {
                    setCursor(new Cursor(0));
                    this.setcur = false;
                }
                if (this.epart && this.esp != -1) {
                    if ((this.co[this.esp]).dist != 0) {
                        (this.m).cx = 505;
                        (this.m).cy = 290;
                        (this.m).x = this.sx - (this.m).cx;
                        (this.m).z = this.sz - (this.m).cz;
                        (this.m).y = this.sy;
                        int i_53_ = (this.m).cx + (int) ((float) ((this.co[this.esp]).x - (this.m).x - (this.m).cx) * this.m.cos((this.m).xz) - (float) ((this.co[this.esp]).z - (this.m).z - (this.m).cz) * this.m.sin((this.m).xz));
                        int i_54_ = (this.m).cz + (int) ((float) ((this.co[this.esp]).x - (this.m).x - (this.m).cx) * this.m.sin((this.m).xz) + (float) ((this.co[this.esp]).z - (this.m).z - (this.m).cz) * this.m.cos((this.m).xz));
                        int i_55_ = (this.m).cy + (int) ((float) ((this.co[this.esp]).y - (this.m).y - (this.m).cy) * this.m.cos((this.m).zy) - (float) (i_54_ - (this.m).cz) * this.m.sin((this.m).zy));
                        int i_56_ = (this.m).cz + (int) ((float) ((this.co[this.esp]).y - (this.m).y - (this.m).cy) * this.m.sin((this.m).zy) + (float) (i_54_ - (this.m).cz) * this.m.cos((this.m).zy));
                        int i_57_ = xs(i_53_, i_56_);
                        int i_58_ = ys(i_55_, i_56_);
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(i_57_, i_58_, 90, 88);
                        this.rd.setColor(new Color(138, 147, 160));
                        this.rd.drawRect(i_57_, i_58_, 90, 88);
                        if (button("   Edit   ", i_57_ + 45, i_58_ + 22, 3, false)) {
                            copyesp(true);
                            removesp();
                            this.lxm = 0;
                            this.lym = 0;
                            this.cntout = 2;
                            this.epart = false;
                        }
                        if (button(" Remove ", i_57_ + 45, i_58_ + 49, 3, false)) {
                            removesp();
                            this.esp = -1;
                            this.mouses = 0;
                        }
                        if (button("  Copy  ", i_57_ + 45, i_58_ + 76, 3, false)) {
                            copyesp(false);
                            this.lxm = 0;
                            this.lym = 0;
                            this.cntout = 2;
                            this.epart = false;
                        }
                        this.rd.setColor(new Color(255, 0, 0));
                        this.rd.drawString("x", i_57_ + 82, i_58_ - 2);
                        if (this.xm > 248 && this.xm < 762 && this.ym > 63 && this.ym < 517 && this.mouses == 1 && (this.xm < i_57_ || this.xm > i_57_ + 90 || this.ym < i_58_ || this.ym > i_58_ + 88)) {
                            this.esp = -1;
                            this.mouses = 0;
                        }
                    } else
                        this.esp = -1;
                }
                this.rd.setColor(new Color(225, 225, 225));
                this.rd.fillRect(248, 25, 514, 38);
                this.rd.fillRect(0, 25, 248, 530);
                this.rd.fillRect(248, 517, 514, 38);
                this.rd.fillRect(762, 25, 38, 530);
                if (this.sptyp == 6) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("Radius:", 11, 97);
                    this.rd.drawString("Height:", 14, 117);
                    boolean bool = false;
                    if (this.xm > 57 && this.xm < 204 && this.ym > 90 && this.ym < 99)
                        bool = true;
                    this.rd.setColor(new Color(136, 148, 170));
                    if (bool || this.mouseon == 1) {
                        this.rd.drawRect(57, 90, 147, 8);
                        this.rd.setColor(new Color(0, 0, 0));
                    }
                    this.rd.drawLine(57, 94, 204, 94);
                    if (this.mouseon == 1) {
                        this.pwd = (float) (this.xm - 57) / 36.75F + 2.0F;
                        if (this.pwd < 2.0F)
                            this.pwd = 2.0F;
                        if (this.pwd > 6.0F)
                            this.pwd = 6.0F;
                    }
                    this.rd.drawRect((int) (57.0F + (this.pwd - 2.0F) * 36.75F), 90, 2, 8);
                    boolean bool_59_ = false;
                    if (this.xm > 57 && this.xm < 204 && this.ym > 110 && this.ym < 119)
                        bool_59_ = true;
                    this.rd.setColor(new Color(136, 148, 170));
                    if (bool_59_ || this.mouseon == 2) {
                        this.rd.drawRect(57, 110, 147, 8);
                        this.rd.setColor(new Color(0, 0, 0));
                    }
                    this.rd.drawLine(57, 114, 204, 114);
                    if (this.mouseon == 2) {
                        this.phd = (float) (this.xm - 57) / 36.75F + 2.0F;
                        if (this.phd < 2.0F)
                            this.phd = 2.0F;
                        if (this.phd > 6.0F)
                            this.phd = 6.0F;
                    }
                    this.rd.drawRect((int) (57.0F + (this.phd - 2.0F) * 36.75F), 110, 2, 8);
                    if (this.mouses == 1) {
                        if (bool)
                            this.mouseon = 1;
                        if (bool_59_)
                            this.mouseon = 2;
                    } else {
                        if (this.mouseon == 1 || this.mouseon == 2)
                            this.pgen = false;
                        this.mouseon = -1;
                    }
                }
                int i_60_ = 0;
                if (this.xm > 482 && this.xm < 529 && this.ym > 35 && this.ym < 61 || this.up) {
                    i_60_ = 1;
                    if (this.mouses == 1 || this.up)
                        this.sz += 500;
                }
                this.rd.drawImage(this.su[i_60_], 482, 35, null);
                i_60_ = 0;
                if (this.xm > 482 && this.xm < 529 && this.ym > 519 && this.ym < 545 || this.down) {
                    i_60_ = 1;
                    if (this.mouses == 1 || this.down)
                        this.sz -= 500;
                }
                this.rd.drawImage(this.sd[i_60_], 482, 519, null);
                i_60_ = 0;
                if (this.xm > 220 && this.xm < 246 && this.ym > 264 && this.ym < 311 || this.left) {
                    i_60_ = 1;
                    if (this.mouses == 1 || this.left)
                        this.sx -= 500;
                }
                this.rd.drawImage(this.sl[i_60_], 220, 264, null);
                i_60_ = 0;
                if (this.xm > 764 && this.xm < 790 && this.ym > 264 && this.ym < 311 || this.right) {
                    i_60_ = 1;
                    if (this.mouses == 1 || this.right)
                        this.sx += 500;
                }
                this.rd.drawImage(this.sr[i_60_], 764, 264, null);
                i_60_ = 0;
                if (this.xm > 616 && this.xm < 677 && this.ym > 30 && this.ym < 61 || this.zoomi) {
                    i_60_ = 1;
                    if (this.mouses == 1 || this.zoomi) {
                        this.sy += 500;
                        if (this.sy > -2500)
                            this.sy = -2500;
                    }
                }
                this.rd.drawImage(this.zi[i_60_], 616, 30, null);
                i_60_ = 0;
                if (this.xm > 690 && this.xm < 751 && this.ym > 30 && this.ym < 61 || this.zoomo) {
                    i_60_ = 1;
                    if (this.mouses == 1 || this.zoomo) {
                        this.sy -= 500;
                        if (this.sy < -55000)
                            this.sy = -55000;
                    }
                }
                this.rd.drawImage(this.zo[i_60_], 690, 30, null);
                if ((this.epart || this.arrng) && this.sy < -36000)
                    this.sy = -36000;
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("Part Selection", 11, 47);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                this.ptyp.move(10, 50);
                if (!this.ptyp.isShowing()) {
                    this.ptyp.show();
                    this.ptyp.select(this.sptyp);
                }
                if (this.sptyp != this.ptyp.getSelectedIndex()) {
                    this.sptyp = this.ptyp.getSelectedIndex();
                    if (this.sptyp == 0) {
                        partroads();
                        this.part.show();
                    }
                    if (this.sptyp == 1) {
                        partramps();
                        this.part.show();
                    }
                    if (this.sptyp == 2) {
                        partobst();
                        this.part.show();
                    }
                    if (this.sptyp == 5) {
                        partrees();
                        this.part.show();
                    }
                    this.spart = 0;
                    this.part.select(this.spart);
                    requestFocus();
                    this.fixh.setText("2000");
                    this.focuson = false;
                }
                this.part.move(10, 80);
                this.part.setSize(200, 21);
                if (this.sptyp == 0 || this.sptyp == 1 || this.sptyp == 2 || this.sptyp == 5) {
                    if (!this.part.isShowing()) {
                        this.part.show();
                        this.part.select(this.spart);
                    }
                } else if (this.part.isShowing())
                    this.part.hide();
                if (this.spart != this.part.getSelectedIndex()) {
                    this.spart = this.part.getSelectedIndex();
                    this.focuson = false;
                }
                if (this.sptyp == 3)
                    this.rd.drawString("Checkpoint", 110 - this.ftm.stringWidth("Checkpoint") / 2, 120);
                if (this.sptyp == 4)
                    this.rd.drawString("Fixing Hoop", 110 - this.ftm.stringWidth("Fixing Hoop") / 2, 120);
                if (this.lsp != this.sp) {
                    this.seq = 3;
                    (this.bco[this.sp]).xy = 0;
                    (this.bco[this.sp]).zy = 0;
                    this.lsp = this.sp;
                    this.epart = false;
                    this.arrng = false;
                }
                if (this.xm > 10 && this.xm < 210 && this.ym > 130 && this.ym < 334) {
                    if (this.seq >= 3) {
                        if (this.seq == 20 || !this.seqn) {
                            this.seq = 0;
                            (this.bco[this.sp]).xy = 0;
                            (this.bco[this.sp]).zy = 0;
                        } else
                            this.seq++;
                    }
                    this.seqn = true;
                    this.rd.setColor(new Color(210, 210, 210));
                } else {
                    this.rd.setColor(new Color(200, 200, 200));
                    this.seqn = false;
                }
                this.rd.fillRect(10, 130, 200, 200);
                if ((this.sp == 30 || this.sp == 32 || this.sp == 54) && button("  Rearrange Checkpoints  >  ", 110, 315, 2, true)) {
                    this.mouses = 0;
                    this.epart = false;
                    if (!this.arrng) {
                        this.arrcnt = 0;
                        for (int i_61_ = 0; i_61_ < this.nob; i_61_++) {
                            if ((this.co[i_61_]).colok == 30 || (this.co[i_61_]).colok == 32 || (this.co[i_61_]).colok == 54)
                                (this.co[i_61_]).errd = false;
                        }
                        this.arrng = true;
                    } else
                        this.arrng = false;
                }
                if (this.seqn && this.mouses == -1) {
                    if (this.sp != 66) {
                        boolean bool = false;
                        if (this.rot == 0 && !bool) {
                            this.rot = 90;
                            bool = true;
                        }
                        if (this.rot == 90 && !bool) {
                            this.rot = 180;
                            bool = true;
                        }
                        if (this.rot == 180 && !bool) {
                            this.rot = -90;
                            bool = true;
                        }
                        if (this.rot == -90 && !bool) {
                            this.rot = 0;
                            bool = true;
                        }
                        if (this.sp == 30 || this.sp == 31 || this.sp == 32) {
                            if (this.rot == -90)
                                this.rot = 90;
                            if (this.rot == 180)
                                this.rot = 0;
                        }
                        this.seq = 5;
                        (this.bco[this.sp]).xy = 0;
                        (this.bco[this.sp]).zy = 0;
                        this.epart = false;
                        this.arrng = false;
                    } else {
                        this.pgen = false;
                        this.pwd = (float) (2L + Math.round(Math.random() * 4.0));
                        this.phd = (float) (2L + Math.round(Math.random() * 4.0));
                    }
                }
                if (this.sp == 31) {
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Height:", 62, 280);
                    movefield(this.fixh, 107, 266, 50, 20);
                    if (this.fixh.hasFocus())
                        this.focuson = false;
                    if (!this.fixh.isShowing())
                        this.fixh.show();
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("(Height off the ground... )", 110 - this.ftm.stringWidth("(Height off the ground... )") / 2, 300);
                    if (this.fixh.getText().equals("")) {
                        this.fixh.setText("0");
                        this.fixh.select(0, 0);
                    }
                    try {
                        this.hf = Integer.valueOf(this.fixh.getText()).intValue();
                        if (this.hf > 8000) {
                            this.hf = 8000;
                            this.fixh.setText("8000");
                        }
                    } catch (Exception exception) {
                        this.hf = 2000;
                        this.fixh.setText("2000");
                    }
                } else if (this.fixh.isShowing())
                    this.fixh.hide();
                (this.m).trk = 2;
                (this.m).zy = 90;
                (this.m).xz = 0;
                (this.m).iw = 10;
                (this.m).w = 210;
                (this.m).ih = 130;
                (this.m).h = 330;
                (this.m).cx = 110;
                (this.m).cy = 230;
                (this.m).x = -110;
                (this.m).z = -230;
                (this.m).y = -15000;
                if (this.sptyp == 1 && this.sp != 20 && this.sp != 21 && this.sp != 43 && this.sp != 45)
                    (this.m).y = -10000;
                if (this.sptyp == 2 && this.sp != 41)
                    (this.m).y = -7600;
                if (this.sptyp == 3 || this.sptyp == 4)
                    (this.m).y = -5000;
                if (this.sptyp == 5) {
                    (this.m).y = -3000;
                    (this.m).z = 150;
                }
                if (this.sptyp == 6)
                    (this.m).y = -7600;
                if (this.sp == 31) {
                    (this.m).z = -500;
                    if (this.rot != 0)
                        (this.bco[this.sp]).roted = true;
                    else
                        (this.bco[this.sp]).roted = false;
                }
                (this.bco[this.sp]).x = 0;
                (this.bco[this.sp]).y = 0;
                (this.bco[this.sp]).z = 0;
                (this.bco[this.sp]).xz = this.rot + this.adrot;
                this.bco[this.sp].d(this.rd);
                int i_62_ = 1;
                if (this.sptyp == 0 || this.sptyp == 1) {
                    if (this.sp != 26 && this.sp != 20) {
                        if (this.rot == -90 || this.rot == 0)
                            i_62_ = -1;
                    } else {
                        if (this.sp == 26 && (this.rot == -90 || this.rot == 180))
                            i_62_ = -1;
                        if (this.sp == 20 && (this.rot == 90 || this.rot == 180))
                            i_62_ = -1;
                    }
                    if (this.seq == 2) {
                        (this.bco[this.sp]).xy -= 5 * i_62_;
                        if ((this.bco[this.sp]).xy == 0)
                            this.seq = 3;
                    }
                    if (this.seq == 1)
                        this.seq = 2;
                    if (this.seq == 0) {
                        (this.bco[this.sp]).xy += 5 * i_62_;
                        if ((this.bco[this.sp]).xy == 85 * i_62_)
                            this.seq = 1;
                    }
                }
                if (this.sptyp == 2 || this.sptyp == 3 || this.sptyp == 4 || this.sptyp == 6) {
                    if (this.rot == -90 || this.rot == 180)
                        i_62_ = -1;
                    if (this.seq == 2) {
                        (this.bco[this.sp]).zy += 5 * i_62_;
                        if ((this.bco[this.sp]).zy == 0)
                            this.seq = 3;
                    }
                    if (this.seq == 1)
                        this.seq = 2;
                    if (this.seq == 0) {
                        (this.bco[this.sp]).zy -= 5 * i_62_;
                        if ((this.bco[this.sp]).zy == -(85 * i_62_))
                            this.seq = 1;
                    }
                }
                if (this.sptyp == 5) {
                    if (this.rot == -90 || this.rot == 180)
                        i_62_ = -1;
                    boolean bool = false;
                    if (this.rot == -90 || this.rot == 90)
                        bool = true;
                    if (!bool)
                        (this.bco[this.sp]).xy = 0;
                    else
                        (this.bco[this.sp]).zy = 0;
                    if (this.seq == 2) {
                        if (!bool) {
                            (this.bco[this.sp]).zy += 5 * i_62_;
                            if ((this.bco[this.sp]).zy == 0)
                                this.seq = 3;
                        } else {
                            (this.bco[this.sp]).xy -= 5 * i_62_;
                            if ((this.bco[this.sp]).xy == 0)
                                this.seq = 3;
                        }
                    }
                    if (this.seq == 1)
                        this.seq = 2;
                    if (this.seq == 0) {
                        if (!bool) {
                            (this.bco[this.sp]).zy -= 5 * i_62_;
                            if ((this.bco[this.sp]).zy == -(85 * i_62_))
                                this.seq = 1;
                        } else {
                            (this.bco[this.sp]).xy += 5 * i_62_;
                            if ((this.bco[this.sp]).xy == 85 * i_62_)
                                this.seq = 1;
                        }
                    }
                }
                if (this.sp != 66) {
                    if (button("  Rotate  ", 110, 348, 3, true)) {
                        boolean bool = false;
                        if (this.rot == 0 && !bool) {
                            this.rot = 90;
                            bool = true;
                        }
                        if (this.rot == 90 && !bool) {
                            this.rot = 180;
                            bool = true;
                        }
                        if (this.rot == 180 && !bool) {
                            this.rot = -90;
                            bool = true;
                        }
                        if (this.rot == -90 && !bool) {
                            this.rot = 0;
                            bool = true;
                        }
                        if (this.sp == 30 || this.sp == 31 || this.sp == 32) {
                            if (this.rot == -90)
                                this.rot = 90;
                            if (this.rot == 180)
                                this.rot = 0;
                        }
                        this.seq = 3;
                        (this.bco[this.sp]).xy = 0;
                        (this.bco[this.sp]).zy = 0;
                        this.epart = false;
                        this.arrng = false;
                    }
                } else if (button("  Generate New  ", 110, 348, 3, true)) {
                    this.pgen = false;
                    this.pwd = (float) (2L + Math.round(Math.random() * 4.0));
                    this.phd = (float) (2L + Math.round(Math.random() * 4.0));
                }
                if (button(">", 191, 348, 3, true) && (this.sptyp == 0 || this.sptyp == 1 || this.sptyp == 2 || this.sptyp == 5)) {
                    this.spart++;
                    if (this.spart == this.part.getItemCount())
                        this.spart = 0;
                    this.part.select(this.spart);
                    this.epart = false;
                    this.arrng = false;
                }
                if (button("<", 28, 348, 3, true) && (this.sptyp == 0 || this.sptyp == 1 || this.sptyp == 2 || this.sptyp == 5)) {
                    this.spart--;
                    if (this.spart == -1)
                        this.spart = this.part.getItemCount() - 1;
                    this.part.select(this.spart);
                    this.epart = false;
                    this.arrng = false;
                }
                if (button("   <  Undo   ", 204, 404, 0, true)) {
                    this.epart = false;
                    this.arrng = false;
                    if (this.nundo > 0) {
                        this.nundo--;
                        this.bstage = this.undos[this.nundo];
                        readstage(0);
                    }
                }
                if (button("   Remove / Edit  Part   ", 172, 454, 0, true)) {
                    if (!this.epart)
                        this.epart = true;
                    else
                        this.epart = false;
                    this.arrng = false;
                    this.esp = -1;
                }
                if (button("   Go to >  Startline   ", 175, 504, 0, true)) {
                    this.sx = 0;
                    this.sz = 1500;
                }
                if (button(" About Part ", 164, 66, 3, false))
                    JOptionPane.showMessageDialog(null, this.discp[this.sp], "Stage Maker", 1);
                if (button("  Keyboard Controls  ", 691, 536, 3, false))
                    JOptionPane.showMessageDialog(null, "Instead of clicking the triangular buttons around the Building Area to scroll, you can use:\n[ Keyboard Arrows ]\n\nYou can also zoom in and out using the following keys:\n[+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]\n\n", "Stage Maker", 1);
                if (button("  Save  ", 280, 50, 0, false)) {
                    this.epart = false;
                    this.arrng = false;
                    savefile();
                }
                if (button("  Save & Preview  ", 380, 50, 0, false)) {
                    this.epart = false;
                    this.arrng = false;
                    savefile();
                    hidefields();
                    this.tab = 2;
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                boolean bool = false;
                int i_63_ = 0;
                int i_64_ = (int) ((float) this.xnob / 10000.0F * 200.0F); //limits
                int i_65_ = i_64_;
                int i_66_ = (int) ((float) (this.t).nt / 6700000.0F * 200.0F); //limits
                if (i_66_ > i_65_) {
                    i_65_ = i_66_;
                    i_63_ = 1;
                }
                int i_67_ = (int) ((float) (this.cp).n / 10000.0F * 200.0F); //limits
                if (i_67_ > i_65_) {
                    i_65_ = i_67_;
                    i_63_ = 2;
                }
                int i_68_ = (int) ((float) ((this.m).nrw * (this.m).ncl) / 9999999.0F * 200.0F); //medium limit...does it exist?
                if (i_68_ > i_65_) {
                    i_65_ = i_68_;
                    i_63_ = 3;
                }
                if (i_65_ > 200) //may be a limit
                    i_65_ = 200;
                if (i_65_ <= 100)
                    this.rd.setColor(new Color(100 + i_65_, 225, 30));
                else
                    this.rd.setColor(new Color(200, 325 - i_65_, 30));
                this.rd.fillRect(167, 531, i_65_, 9);
                if (button("Memory Consumption :", 85, 540, 3, false))
                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Memory Consumption Details\n\nNumber of Parts:  ").append(i_64_ / 2).append(" %\nPart's Details:  ").append(i_66_ / 2).append(" %\nRoad Points:  ").append(i_67_ / 2).append(" %\nStage Area:  ").append(i_68_ / 2).append(" %\n \n").toString(), "Stage Maker", 1);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRect(167, 531, 200, 9);
                String[] strings = { "Number of Parts", "Part's Details", "Road Points", "Stage Area" };
                this.rd.drawString(strings[i_63_], 267 - this.ftm.stringWidth(strings[i_63_]) / 2, 540);
                this.rd.drawString(new StringBuilder().append("").append(i_65_ / 2).append(" %  used").toString(), 375, 540);
                if (this.overcan)
                    this.overcan = false;
                if (this.epart) {
                    if (this.esp == -1) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Click on any part to Edit >", 257, 454);
                        if (button(" Cancel ", 323, 474, 4, false))
                            this.epart = false;
                    }
                } else {
                    if (this.hi != -1)
                        this.hi = -1;
                    if (this.esp != -1)
                        this.esp = -1;
                }
                if (this.arrng) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(new StringBuilder().append("Click on Checkpoint NO# ").append(this.arrcnt + 1).append("  >").toString(), 257, 80);
                    if (button(" Cancel ", 330, 100, 4, false))
                        this.arrng = false;
                    if (this.arrcnt == (this.cp).nsp) {
                        sortstage();
                        JOptionPane.showMessageDialog(null, "Checkpoints Arranged!\nPress Save and Test Drive to check the new checkpoint order.\n", "Stage Maker", 1);
                        this.arrng = false;
                    }
                } else if (this.chi != -1)
                    this.chi = -1;
            }
            if (this.tab == 2) {
                if (this.tabed != this.tab) {
                    (this.m).trk = 0;
                    readstage(1);
                    setCursor(new Cursor(0));
                    this.setcur = false;
                    this.vxz = 0;
                    this.vx = this.sx - 400;
                    this.vz = this.sz - (this.m).cz - 8000;
                    this.vy = -1500;
                    this.dtabed = -1;
                }
                (this.m).trk = 0;
                (this.m).zy = 6;
                (this.m).iw = 10;
                (this.m).w = 790;
                (this.m).ih = 35;
                (this.m).h = 445;
                (this.m).cx = 400;
                (this.m).cy = 215;
                (this.m).xz = this.vxz;
                (this.m).x = this.vx;
                (this.m).z = this.vz;
                (this.m).y = this.vy;
                this.m.d(this.rd);
                int i = 0;
                int[] is = new int[10000]; // stageselect limit
                for (int i_69_ = 0; i_69_ < this.nob; i_69_++) {
                    if ((this.co[i_69_]).dist != 0) {
                        is[i] = i_69_;
                        i++;
                    } else
                        this.co[i_69_].d(this.rd);
                }
                int[] is_70_ = new int[i];
                for (int i_71_ = 0; i_71_ < i; i_71_++)
                    is_70_[i_71_] = 0;
                for (int i_72_ = 0; i_72_ < i; i_72_++) {
                    for (int i_73_ = i_72_ + 1; i_73_ < i; i_73_++) {
                        if ((this.co[is[i_72_]]).dist != (this.co[is[i_73_]]).dist) {
                            if ((this.co[is[i_72_]]).dist < (this.co[is[i_73_]]).dist)
                                is_70_[i_72_]++;
                            else
                                is_70_[i_73_]++;
                        } else if (i_73_ > i_72_)
                            is_70_[i_72_]++;
                        else
                            is_70_[i_73_]++;
                    }
                }
                for (int i_74_ = 0; i_74_ < i; i_74_++) {
                    for (int i_75_ = 0; i_75_ < i; i_75_++) {
                        if (is_70_[i_75_] == i_74_) {
                            if (is[i_75_] == this.hi)
                                (this.m).trk = 3;
                            this.co[is[i_75_]].d(this.rd);
                            if ((this.m).trk == 3)
                                (this.m).trk = 2;
                        }
                    }
                }
                if (this.up) {
                    this.vz += 500.0F * this.m.cos((this.m).xz);
                    this.vx += 500.0F * this.m.sin((this.m).xz);
                }
                if (this.down) {
                    this.vz -= 500.0F * this.m.cos((this.m).xz);
                    this.vx -= 500.0F * this.m.sin((this.m).xz);
                }
                if (this.left)
                    this.vxz -= 5;
                if (this.right)
                    this.vxz += 5;
                if (this.zoomi) {
                    this.vy += 100;
                    if (this.vy > -500)
                        this.vy = -500;
                }
                if (this.zoomo) {
                    this.vy -= 100;
                    if (this.vy < -5000)
                        this.vy = -5000;
                }
                this.rd.setColor(new Color(225, 225, 225));
                this.rd.fillRect(0, 25, 10, 525);
                this.rd.fillRect(790, 25, 10, 525);
                this.rd.fillRect(10, 25, 780, 10);
                this.rd.fillRect(10, 445, 780, 105);
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                String[] strings = { "Controls", "Atmosphere", "Colors", "Scenery", "Laps", "Sound Track", "Test Drive" };
                int[] is_76_ = { 10, 10, 121, 111 };
                int[] is_77_ = { 425, 445, 445, 425 };
                for (int i_78_ = 0; i_78_ < 7; i_78_++) {
                    this.rd.setColor(new Color(170, 170, 170));
                    if (this.xm > is_76_[0] && this.xm < is_76_[3] && this.ym > 425 && this.ym < 445)
                        this.rd.setColor(new Color(190, 190, 190));
                    if (this.dtab == i_78_)
                        this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillPolygon(is_76_, is_77_, 4);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(strings[i_78_], i_78_ * 111 + 62 - this.ftm.stringWidth(strings[i_78_]) / 2, 439);
                    if (this.xm > is_76_[0] && this.xm < is_76_[3] && this.ym > 425 && this.ym < 445 && this.mouses == -1 && this.mouseon == -1)
                        this.dtab = i_78_;
                    for (int i_79_ = 0; i_79_ < 4; i_79_++)
                        is_76_[i_79_] += 111;
                }
                if (this.tabed == this.tab && this.dtab != this.dtabed) {
                    if (!this.ttstage.equals("")) {
                        this.tstage = this.ttstage;
                        this.ttstage = "";
                    }
                    readstage(1);
                    hidefields();
                }
                if (this.dtab == 0) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Use the [ Keyboard Arrows ] to navigate through the stage.", 20, 470);
                    this.rd.drawString("[Left] & [Right] arrows are for rotating.  [Up] & [Down] arrows are for moving forwards and backwards.", 20, 490);
                    this.rd.drawString("For moving vertically down and up use the following keys:  [+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]", 20, 520);
                }
                if (this.dtab == 2) {
                    if (this.dtabed != this.dtab) {
                        Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], this.hsb[0]);
                        Color.RGBtoHSB(this.cfade[0], this.cfade[1], this.cfade[2], this.hsb[1]);
                        Color.RGBtoHSB(this.cgrnd[0], this.cgrnd[1], this.cgrnd[2], this.hsb[2]);
                        for (int i_80_ = 0; i_80_ < 3; i_80_++) {
                            float f = this.hsb[i_80_][1];
                            this.hsb[i_80_][1] = this.hsb[i_80_][2];
                            this.hsb[i_80_][2] = f;
                        }
                        if (this.hsb[1][1] == (this.hsb[0][1] + this.hsb[2][1]) / 2.0F && this.hsb[1][0] == this.hsb[2][0] && this.hsb[1][2] == this.hsb[2][2])
                            this.pfog.setState(true);
                        else
                            this.pfog.setState(false);
                        this.ttstage = "";
                        this.mouseon = -1;
                    }
                    if (this.mouses != 1) {
                        if ((this.mouseon >= 6 || this.mouseon < 3) && this.mouseon != -1) {
                            if (this.ttstage.equals(""))
                                this.ttstage = this.tstage;
                            sortop();
                            readstage(1);
                        }
                        this.mouseon = -1;
                    }
                    String[] strings_81_ = { "Sky", "Dust / Fog", "Ground" };
                    for (int i_82_ = 0; i_82_ < 3; i_82_++) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(strings_81_[i_82_], 107 + 195 * i_82_ - this.ftm.stringWidth(strings_81_[i_82_]) / 2, 461);
                        for (int i_83_ = 0; i_83_ < 150; i_83_++) {
                            this.rd.setColor(Color.getHSBColor((float) ((double) (float) i_83_ * 0.006667), 1.0F, 1.0F));
                            this.rd.drawLine(32 + i_83_ + 195 * i_82_, 467, 32 + i_83_ + 195 * i_82_, 474);
                        }
                        for (int i_84_ = 0; i_84_ < 150; i_84_++) {
                            this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.5F + (float) i_84_ * 0.00333F));
                            this.rd.drawLine(32 + i_84_ + 195 * i_82_, 483, 32 + i_84_ + 195 * i_82_, 490);
                        }
                        for (int i_85_ = 0; i_85_ < 150; i_85_++) {
                            this.rd.setColor(Color.getHSBColor(this.hsb[i_82_][0], 0.0F + (float) ((double) (float) i_85_ * 0.001667), this.hsb[i_82_][1]));
                            this.rd.drawLine(32 + i_85_ + 195 * i_82_, 499, 32 + i_85_ + 195 * i_82_, 506);
                        }
                        for (int i_86_ = 0; i_86_ < 3; i_86_++) {
                            this.rd.setColor(new Color(0, 0, 0));
                            float f = this.hsb[i_82_][i_86_] * 150.0F;
                            if (i_86_ == 1) {
                                float f_87_ = 0.75F;
                                if (i_82_ == 0)
                                    f_87_ = 0.85F;
                                if (i_82_ == 1)
                                    f_87_ = 0.8F;
                                f = (this.hsb[i_82_][i_86_] - f_87_) / 0.001F;
                            }
                            if (i_86_ == 2)
                                f = this.hsb[i_82_][i_86_] * 600.0F;
                            if (f < 0.0F)
                                f = 0.0F;
                            if (f > 150.0F)
                                f = 150.0F;
                            this.rd.drawLine((int) ((float) (32 + 195 * i_82_) + f), 467 + i_86_ * 16, (int) ((float) (32 + 195 * i_82_) + f), 474 + i_86_ * 16);
                            this.rd.drawLine((int) ((float) (33 + 195 * i_82_) + f), 467 + i_86_ * 16, (int) ((float) (33 + 195 * i_82_) + f), 474 + i_86_ * 16);
                            this.rd.fillRect((int) ((float) (31 + 195 * i_82_) + f), 475 + i_86_ * 16, 4, 2);
                            this.rd.drawLine((int) ((float) (30 + 195 * i_82_) + f), 477 + i_86_ * 16, (int) ((float) (35 + 195 * i_82_) + f), 477 + i_86_ * 16);
                            if (this.xm > 29 + 195 * i_82_ && this.xm < 185 + 195 * i_82_ && this.ym > 468 + i_86_ * 16 && this.ym < 477 + i_86_ * 16 && this.mouses == 1 && this.mouseon == -1)
                                this.mouseon = i_86_ + i_82_ * 3;
                            if (this.mouseon == i_86_ + i_82_ * 3) {
                                if (i_86_ == 0)
                                    this.hsb[i_82_][i_86_] = (float) (this.xm - (32 + 195 * i_82_)) / 150.0F;
                                if (i_86_ == 1) {
                                    float f_88_ = 0.75F;
                                    if (i_82_ == 0)
                                        f_88_ = 0.85F;
                                    if (i_82_ == 1)
                                        f_88_ = 0.8F;
                                    this.hsb[i_82_][i_86_] = f_88_ + (float) (this.xm - (32 + 195 * i_82_)) * 0.001F;
                                    if (this.hsb[i_82_][i_86_] < f_88_)
                                        this.hsb[i_82_][i_86_] = f_88_;
                                    if (this.hsb[i_82_][i_86_] > f_88_ + 0.15F)
                                        this.hsb[i_82_][i_86_] = f_88_ + 0.15F;
                                }
                                if (i_86_ == 2) {
                                    this.hsb[i_82_][i_86_] = (float) (this.xm - (32 + 195 * i_82_)) / 600.0F;
                                    if ((double) this.hsb[i_82_][i_86_] > 0.25)
                                        this.hsb[i_82_][i_86_] = 0.25F;
                                }
                                if (this.hsb[i_82_][i_86_] > 1.0F)
                                    this.hsb[i_82_][i_86_] = 1.0F;
                                if (this.hsb[i_82_][i_86_] < 0.0F)
                                    this.hsb[i_82_][i_86_] = 0.0F;
                            }
                        }
                    }
                    movefield(this.pfog, 258, 511, 200, 23);
                    if (!this.pfog.isShowing())
                        this.pfog.show();
                    if (this.pfog.getState()) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(215, 464, 175, 47);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.hsb[1][1] = (this.hsb[0][1] + this.hsb[2][1]) / 2.0F;
                        this.hsb[1][0] = this.hsb[2][0];
                        this.hsb[1][2] = this.hsb[2][2];
                    }
                    Color color = Color.getHSBColor(this.hsb[0][0], this.hsb[0][2], this.hsb[0][1]);
                    this.m.setsky(color.getRed(), color.getGreen(), color.getBlue());
                    this.csky[0] = color.getRed();
                    this.csky[1] = color.getGreen();
                    this.csky[2] = color.getBlue();
                    color = Color.getHSBColor(this.hsb[1][0], this.hsb[1][2], this.hsb[1][1]);
                    this.m.setfade(color.getRed(), color.getGreen(), color.getBlue());
                    this.cfade[0] = color.getRed();
                    this.cfade[1] = color.getGreen();
                    this.cfade[2] = color.getBlue();
                    color = Color.getHSBColor(this.hsb[2][0], this.hsb[2][2], this.hsb[2][1]);
                    this.m.setgrnd(color.getRed(), color.getGreen(), color.getBlue());
                    this.cgrnd[0] = color.getRed();
                    this.cgrnd[1] = color.getGreen();
                    this.cgrnd[2] = color.getBlue();
                    if (button(" Reset ", 650, 510, 0, true)) {
                        if (!this.ttstage.equals("")) {
                            this.tstage = this.ttstage;
                            this.ttstage = "";
                        }
                        readstage(1);
                        this.dtabed = -2;
                    }
                    if (button("        Save        ", 737, 510, 0, true)) {
                        sortop();
                        this.ttstage = "";
                        savefile();
                    }
                }
                if (this.dtab == 3) {
                    if (this.dtabed != this.dtab) {
                        Color.RGBtoHSB(this.cldd[0], this.cldd[1], this.cldd[2], this.hsb[0]);
                        Color.RGBtoHSB(this.texture[0], this.texture[1], this.texture[2], this.hsb[1]);
                        this.mgen.setText(new StringBuilder().append("").append((this.m).mgen).append("").toString());
                        this.mouseon = -1;
                        this.ttstage = "";
                    }
                    if (this.mouses != 1) {
                        if (this.mouseon == 0 || this.mouseon == 1 || this.mouseon == 2 || this.mouseon == 6) {
                            if (this.ttstage.equals(""))
                                this.ttstage = this.tstage;
                            sortop();
                            readstage(1);
                        }
                        this.mouseon = -1;
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Clouds", 32, 461);
                    for (int i_89_ = 0; i_89_ < 150; i_89_++) {
                        this.rd.setColor(Color.getHSBColor((float) i_89_ * 0.006667F, 1.0F, 1.0F));
                        this.rd.drawLine(32 + i_89_ + 0, 467, 32 + i_89_ + 0, 474);
                    }
                    for (int i_90_ = 0; i_90_ < 150; i_90_++) {
                        this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.75F + (float) i_90_ * 0.001667F));
                        this.rd.drawLine(32 + i_90_ + 0, 483, 32 + i_90_ + 0, 490);
                    }
                    for (int i_91_ = 0; i_91_ < 150; i_91_++) {
                        this.rd.setColor(Color.getHSBColor(this.hsb[0][0], (float) i_91_ * 0.003333F, this.hsb[0][2]));
                        this.rd.drawLine(32 + i_91_ + 0, 499, 32 + i_91_ + 0, 506);
                    }
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Blend:", 32, 529);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(70, 522, 112, 2);
                    this.rd.fillRect(70, 528, 112, 2);
                    float f = 0.0F;
                    int i_92_ = 255;
                    for (int i_93_ = 0; i_93_ < 112; i_93_++) {
                        i_92_ = (int) (255.0F / (f + 1.0F));
                        if (i_92_ > 255)
                            i_92_ = 255;
                        if (i_92_ < 0)
                            i_92_ = 0;
                        f += 0.02F;
                        this.rd.setColor(new Color(i_92_, i_92_, i_92_));
                        this.rd.drawLine(70 + i_93_, 524, 70 + i_93_, 527);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Height", 202 - this.ftm.stringWidth("Height") / 2, 461);
                    this.rd.drawLine(202, 467, 202, 530);
                    for (int i_94_ = 0; i_94_ < 8; i_94_++)
                        this.rd.drawLine(202, 466 + i_94_ * 8, 202 + (8 - i_94_), 466 + i_94_ * 8);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Ground Texture", 257, 471);
                    for (int i_95_ = 0; i_95_ < 150; i_95_++) {
                        this.rd.setColor(Color.getHSBColor((float) i_95_ * 0.006667F, 1.0F, 1.0F));
                        this.rd.drawLine(32 + i_95_ + 225, 477, 32 + i_95_ + 225, 484);
                    }
                    for (int i_96_ = 0; i_96_ < 150; i_96_++) {
                        this.rd.setColor(Color.getHSBColor(this.hsb[1][0], (float) i_96_ * 0.006667F, (float) i_96_ * 0.006667F));
                        this.rd.drawLine(32 + i_96_ + 225, 493, 32 + i_96_ + 225, 500);
                    }
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Blend:", 257, 523);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(295, 516, 112, 2);
                    this.rd.fillRect(295, 522, 112, 2);
                    f = 0.0F;
                    i_92_ = 255;
                    for (int i_97_ = 0; i_97_ < 112; i_97_++) {
                        i_92_ = (int) (255.0F / (f + 1.0F));
                        if (i_92_ > 255)
                            i_92_ = 255;
                        if (i_92_ < 0)
                            i_92_ = 0;
                        f += 0.02F;
                        this.rd.setColor(new Color(i_92_, i_92_, i_92_));
                        this.rd.drawLine(70 + i_97_ + 225, 518, 70 + i_97_ + 225, 521);
                    }
                    for (int i_98_ = 0; i_98_ < 2; i_98_++) {
                        int i_99_ = 3;
                        if (i_98_ == 1)
                            i_99_ = 2;
                        for (int i_100_ = 0; i_100_ < i_99_; i_100_++) {
                            int i_101_ = i_100_;
                            if (i_100_ == 1)
                                i_101_ = 2;
                            if (i_100_ == 2)
                                i_101_ = 1;
                            this.rd.setColor(new Color(0, 0, 0));
                            float f_102_ = this.hsb[i_98_][i_101_] * 150.0F;
                            if (i_100_ == 1 && i_98_ == 0) {
                                float f_103_ = 0.75F;
                                f_102_ = (this.hsb[i_98_][i_101_] - f_103_) / 0.001667F;
                            }
                            if (i_100_ == 2 && i_98_ == 0)
                                f_102_ = this.hsb[i_98_][i_101_] / 0.003333F;
                            if (f_102_ < 0.0F)
                                f_102_ = 0.0F;
                            if (f_102_ > 150.0F)
                                f_102_ = 150.0F;
                            this.rd.drawLine((int) ((float) (32 + 225 * i_98_) + f_102_), 467 + i_100_ * 16 + 10 * i_98_, (int) ((float) (32 + 225 * i_98_) + f_102_), 474 + i_100_ * 16 + 10 * i_98_);
                            this.rd.drawLine((int) ((float) (33 + 225 * i_98_) + f_102_), 467 + i_100_ * 16 + 10 * i_98_, (int) ((float) (33 + 225 * i_98_) + f_102_), 474 + i_100_ * 16 + 10 * i_98_);
                            this.rd.fillRect((int) ((float) (31 + 225 * i_98_) + f_102_), 475 + i_100_ * 16 + 10 * i_98_, 4, 2);
                            this.rd.drawLine((int) ((float) (30 + 225 * i_98_) + f_102_), 477 + i_100_ * 16 + 10 * i_98_, (int) ((float) (35 + 225 * i_98_) + f_102_), 477 + i_100_ * 16 + 10 * i_98_);
                            if (this.xm > 29 + 225 * i_98_ && this.xm < 185 + 225 * i_98_ && this.ym > 468 + i_100_ * 16 + 10 * i_98_ && this.ym < 477 + i_100_ * 16 + 10 * i_98_ && this.mouses == 1 && this.mouseon == -1)
                                this.mouseon = i_100_ + i_98_ * 3;
                            if (this.mouseon == i_100_ + i_98_ * 3) {
                                this.hsb[i_98_][i_101_] = (float) (this.xm - (32 + 225 * i_98_)) * 0.006667F;
                                if (i_100_ == 1 && i_98_ == 1) {
                                    this.hsb[i_98_][1] = (float) (this.xm - (32 + 225 * i_98_)) * 0.006667F;
                                    if (this.hsb[i_98_][1] > 1.0F)
                                        this.hsb[i_98_][1] = 1.0F;
                                    if (this.hsb[i_98_][1] < 0.0F)
                                        this.hsb[i_98_][1] = 0.0F;
                                }
                                if (i_100_ == 1 && i_98_ == 0) {
                                    float f_104_ = 0.75F;
                                    this.hsb[i_98_][i_101_] = f_104_ + (float) (this.xm - (32 + 225 * i_98_)) * 0.001667F;
                                    if (this.hsb[i_98_][i_101_] < f_104_)
                                        this.hsb[i_98_][i_101_] = f_104_;
                                }
                                if (i_100_ == 2 && i_98_ == 0) {
                                    this.hsb[i_98_][i_101_] = (float) (this.xm - (32 + 225 * i_98_)) * 0.003333F;
                                    if ((double) this.hsb[i_98_][i_101_] > 0.5)
                                        this.hsb[i_98_][i_101_] = 0.5F;
                                }
                                if (this.hsb[i_98_][i_101_] > 1.0F)
                                    this.hsb[i_98_][i_101_] = 1.0F;
                                if (this.hsb[i_98_][i_101_] < 0.0F)
                                    this.hsb[i_98_][i_101_] = 0.0F;
                            }
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        float f_105_ = (float) (this.texture[3] - 20) * 2.8F;
                        if (i_98_ == 0)
                            f_105_ = (float) this.cldd[3] * 11.2F;
                        if (f_105_ < 0.0F)
                            f_105_ = 0.0F;
                        if (f_105_ > 112.0F)
                            f_105_ = 112.0F;
                        this.rd.drawLine((int) ((float) (70 + 225 * i_98_) + f_105_), 522 - 6 * i_98_, (int) ((float) (70 + 225 * i_98_) + f_105_), 529 - 6 * i_98_);
                        this.rd.drawLine((int) ((float) (71 + 225 * i_98_) + f_105_), 522 - 6 * i_98_, (int) ((float) (71 + 225 * i_98_) + f_105_), 529 - 6 * i_98_);
                        this.rd.fillRect((int) ((float) (69 + 225 * i_98_) + f_105_), 530 - 6 * i_98_, 4, 2);
                        this.rd.drawLine((int) ((float) (68 + 225 * i_98_) + f_105_), 532 - 6 * i_98_, (int) ((float) (73 + 225 * i_98_) + f_105_), 532 - 6 * i_98_);
                        if (this.xm > 67 + 225 * i_98_ && this.xm < 185 + 225 * i_98_ && this.ym > 522 - 6 * i_98_ && this.ym < 532 - 6 * i_98_ && this.mouses == 1 && this.mouseon == -1)
                            this.mouseon = 6 + i_98_;
                    }
                    if (this.mouseon == 6) {
                        this.cldd[3] = (int) ((float) (this.xm - 70) / 11.2F);
                        if (this.cldd[3] < 0)
                            this.cldd[3] = 0;
                        if (this.cldd[3] > 10)
                            this.cldd[3] = 10;
                    }
                    if (this.mouseon == 7) {
                        this.texture[3] = (int) ((double) (this.xm - 70 - 225) / 2.8 + 20.0);
                        if (this.texture[3] < 20)
                            this.texture[3] = 20;
                        if (this.texture[3] > 60)
                            this.texture[3] = 60;
                    }
                    this.rd.setColor(new Color(0, 128, 255));
                    float f_106_ = (float) (1500 - Math.abs(this.cldd[4])) / 15.625F;
                    if (f_106_ > 64.0F)
                        f_106_ = 64.0F;
                    if (f_106_ < 0.0F)
                        f_106_ = 0.0F;
                    this.rd.drawRect(199, (int) (465.0F + f_106_), 12, 2);
                    if (this.xm > 197 && this.xm < 213 && this.ym > 463 && this.ym < 533 && this.mouses == 1 && this.mouseon == -1)
                        this.mouseon = 8;
                    if (this.mouseon == 8) {
                        this.cldd[4] = -(int) ((float) (530 - this.ym) * 15.625F + 500.0F);
                        if (this.cldd[4] > -500)
                            this.cldd[4] = -500;
                        if (this.cldd[4] < -1500)
                            this.cldd[4] = -1500;
                    }
                    Color color = Color.getHSBColor(this.hsb[0][0], this.hsb[0][1], this.hsb[0][2]);
                    this.m.setcloads(color.getRed(), color.getGreen(), color.getBlue(), this.cldd[3], this.cldd[4]);
                    this.cldd[0] = color.getRed();
                    this.cldd[1] = color.getGreen();
                    this.cldd[2] = color.getBlue();
                    color = Color.getHSBColor(this.hsb[1][0], this.hsb[1][1], this.hsb[1][2]);
                    this.m.setexture(color.getRed(), color.getGreen(), color.getBlue(), this.texture[3]);
                    this.texture[0] = color.getRed();
                    this.texture[1] = color.getGreen();
                    this.texture[2] = color.getBlue();
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Mountains", 452, 465);
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.rd.drawString("Mountain Generator Key:", 452, 480);
                    movefield(this.mgen, 452, 484, 120, 20);
                    if (this.mgen.hasFocus())
                        this.focuson = false;
                    if (!this.mgen.isShowing())
                        this.mgen.show();
                    if (button("  Generate New  ", 512, 525, 3, true)) {
                        (this.m).mgen = (int) (Math.random() * 100000.0);
                        this.mgen.setText(new StringBuilder().append("").append((this.m).mgen).append("").toString());
                        if (this.ttstage.equals(""))
                            this.ttstage = this.tstage;
                        sortop();
                        readstage(1);
                    }
                    if (!this.mgen.getText().equals(new StringBuilder().append("").append((this.m).mgen).append("").toString())) {
                        try {
                            int i_107_ = Integer.valueOf(this.mgen.getText()).intValue();
                            (this.m).mgen = i_107_;
                            if (this.ttstage.equals(""))
                                this.ttstage = this.tstage;
                            sortop();
                            readstage(1);
                        } catch (Exception exception) {
                            this.mgen.setText(new StringBuilder().append("").append((this.m).mgen).append("").toString());
                        }
                    }
                    if (button(" Reset ", 650, 510, 0, true)) {
                        if (!this.ttstage.equals("")) {
                            this.tstage = this.ttstage;
                            this.ttstage = "";
                        }
                        readstage(1);
                        this.dtabed = -2;
                    }
                    if (button("        Save        ", 737, 510, 0, true)) {
                        sortop();
                        this.ttstage = "";
                        savefile();
                    }
                }
                if (this.dtab == 1) {
                    if (this.dtabed != this.dtab) {
                        for (int i_108_ = 0; i_108_ < 3; i_108_++)
                            this.snap[i_108_] = (int) ((float) (this.m).snap[i_108_] / 1.2F + 50.0F);
                        this.fogn[0] = (8 - (((this.m).fogd + 1) / 2 - 1)) * 20;
                        this.fogn[1] = ((this.m).fade[0] - 5000) / 30;
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Atmosphere RGB Mask", 20, 461);
                    this.rd.setColor(new Color(128, 128, 128));
                    this.rd.drawLine(10, 457, 17, 457);
                    this.rd.drawLine(260, 457, 152, 457);
                    this.rd.drawLine(10, 457, 10, 546);
                    this.rd.drawLine(260, 457, 260, 527);
                    this.rd.drawLine(260, 527, 360, 527);
                    this.rd.drawLine(10, 546, 360, 546);
                    this.rd.drawLine(360, 527, 360, 546);
                    String[] strings_109_ = { "Red", "Green", "Blue" };
                    int[] is_110_ = { 32, 20, 29 };
                    int i_111_ = 38;
                    int i_112_ = -70;
                    for (int i_113_ = 0; i_113_ < 3; i_113_++) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(new StringBuilder().append("").append(strings_109_[i_113_]).append(" :").toString(), is_110_[i_113_], 447 + i_113_ * 24 + i_111_);
                        this.rd.drawLine(140 + i_112_, 443 + (i_113_ * 24 + i_111_), 230 + i_112_, 443 + i_113_ * 24 + i_111_);
                        for (int i_114_ = 1; i_114_ < 10; i_114_++)
                            this.rd.drawLine(140 + 10 * i_114_ + i_112_, 443 - i_114_ + i_113_ * 24 + i_111_, 140 + 10 * i_114_ + i_112_, 443 + i_114_ + i_113_ * 24 + i_111_);
                        this.rd.setColor(new Color(255, 0, 0));
                        int i_115_ = (int) ((float) this.snap[i_113_] / 1.1111F / 10.0F);
                        this.rd.fillRect(138 + (int) ((float) this.snap[i_113_] / 1.1111F) + i_112_, 443 - i_115_ + i_113_ * 24 + i_111_, 5, i_115_ * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(139 + (int) ((float) this.snap[i_113_] / 1.1111F) + i_112_, 434 + i_113_ * 24 + i_111_, 2, 18);
                        if (button(" - ", 260 + i_112_, 447 + i_113_ * 24 + i_111_, 4, false)) {
                            this.snap[i_113_] -= 2;
                            if (this.snap[i_113_] < 0)
                                this.snap[i_113_] = 0;
                        }
                        if (button(" + ", 300 + i_112_, 447 + i_113_ * 24 + i_111_, 4, false)) {
                            if (this.snap[0] + this.snap[1] + this.snap[2] > 200) {
                                for (int i_116_ = 0; i_116_ < 3; i_116_++) {
                                    if (i_116_ != i_113_) {
                                        this.snap[i_116_]--;
                                        if (this.snap[i_116_] < 0)
                                            this.snap[i_116_] = 0;
                                    }
                                }
                            }
                            this.snap[i_113_] += 2;
                            if (this.snap[i_113_] > 100)
                                this.snap[i_113_] = 100;
                        }
                    }
                    if ((this.m).snap[0] != (int) ((float) this.snap[0] * 1.2F - 60.0F) || (this.m).snap[1] != (int) ((float) this.snap[1] * 1.2F - 60.0F) || (this.m).snap[2] != (int) ((float) this.snap[2] * 1.2F - 60.0F)) {
                        for (int i_117_ = 0; i_117_ < 3; i_117_++)
                            (this.m).snap[i_117_] = (int) ((float) this.snap[i_117_] * 1.2F - 60.0F);
                        readstage(2);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Car Lights :", 265, 541);
                    if (this.snap[0] + this.snap[1] + this.snap[2] > 110) {
                        this.rd.drawString("Off", 335, 541);
                        (this.m).lightson = false;
                    } else {
                        this.rd.setColor(new Color(0, 200, 0));
                        this.rd.drawString("On", 335, 541);
                        (this.m).lightson = true;
                    }
                    int i_118_ = 33;
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Dust/Fog Properties", 280 + i_118_, 461);
                    this.rd.setColor(new Color(128, 128, 128));
                    this.rd.drawLine(270 + i_118_, 457, 277 + i_118_, 457);
                    this.rd.drawLine(540 + i_118_, 457, 393 + i_118_, 457);
                    this.rd.drawLine(270 + i_118_, 457, 270 + i_118_, 522);
                    this.rd.drawLine(540 + i_118_, 457, 540 + i_118_, 522);
                    this.rd.drawLine(270 + i_118_, 522, 540 + i_118_, 522);
                    String[] strings_119_ = { "Density", "Near / Far" };
                    int[] is_120_ = { 292 + i_118_, 280 + i_118_ };
                    int[] is_121_ = { 20, 10 };
                    i_111_ = 38;
                    i_112_ = 210 + i_118_;
                    for (int i_122_ = 0; i_122_ < 2; i_122_++) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(new StringBuilder().append("").append(strings_119_[i_122_]).append(" :").toString(), is_120_[i_122_], 447 + i_122_ * 24 + i_111_);
                        this.rd.drawLine(140 + i_112_, 443 + (i_122_ * 24 + i_111_), 230 + i_112_, 443 + i_122_ * 24 + i_111_);
                        for (int i_123_ = 1; i_123_ < 10; i_123_++)
                            this.rd.drawLine(140 + 10 * i_123_ + i_112_, 443 - i_123_ + i_122_ * 24 + i_111_, 140 + 10 * i_123_ + i_112_, 443 + i_123_ + i_122_ * 24 + i_111_);
                        this.rd.setColor(new Color(255, 0, 0));
                        int i_124_ = (int) ((float) this.fogn[i_122_] / 1.1111F / 10.0F);
                        this.rd.fillRect(138 + (int) ((float) this.fogn[i_122_] / 1.1111F) + i_112_, 443 - i_124_ + i_122_ * 24 + i_111_, 5, i_124_ * 2 + 1);
                        this.rd.setColor(new Color(255, 128, 0));
                        this.rd.drawRect(139 + (int) ((float) this.fogn[i_122_] / 1.1111F) + i_112_, 434 + i_122_ * 24 + i_111_, 2, 18);
                        if (button(" - ", 260 + i_112_, 447 + i_122_ * 24 + i_111_, 4, false)) {
                            this.fogn[i_122_] -= is_121_[i_122_];
                            if (this.fogn[i_122_] < 0)
                                this.fogn[i_122_] = 0;
                        }
                        if (button(" + ", 300 + i_112_, 447 + i_122_ * 24 + i_111_, 4, false)) {
                            this.fogn[i_122_] += is_121_[i_122_];
                            if (this.fogn[i_122_] > 100)
                                this.fogn[i_122_] = 100;
                        }
                    }
                    (this.m).fogd = (8 - this.fogn[0] / 20 + 1) * 2 - 1;
                    this.m.fadfrom(5000 + this.fogn[1] * 30);
                    this.origfade = (this.m).fade[0];
                    if (button(" Reset ", 650, 510, 0, true))
                        this.dtabed = -2;
                    if (button("        Save        ", 737, 510, 0, true)) {
                        sortop();
                        savefile();
                    }
                }
                if (this.dtab == 4) {
                    if (this.dtabed != this.dtab && (this.cp).nlaps - 1 >= 0 && (this.cp).nlaps - 1 <= 14)
                        this.nlaps.select((this.cp).nlaps - 1);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Set the number of laps for this stage:", 130, 496);
                    this.nlaps.move(348, 480);
                    if (!this.nlaps.isShowing())
                        this.nlaps.show();
                    if ((this.cp).nlaps != this.nlaps.getSelectedIndex() + 1) {
                        (this.cp).nlaps = this.nlaps.getSelectedIndex() + 1;
                        requestFocus();
                    }
                    if (button(" Reset ", 530, 496, 0, true))
                        this.dtabed = -2;
                    if (button("        Save        ", 617, 496, 0, true)) {
                        sortop();
                        savefile();
                    }
                }
                if (this.dtab == 5) {
                    if (this.dtabed != this.dtab) {
                        this.tracks.removeAll();
                        (this.tracks).maxl = 200;
                        this.tracks.add(this.rd, "The Play List  -  MOD Tracks");
                        String[] strings_125_ = new File("mystages/mymusic/").list();
                        if (strings_125_ != null) {
                            for (int i_126_ = 0; i_126_ < strings_125_.length; i_126_++) {
                                if (strings_125_[i_126_].toLowerCase().endsWith(".zip"))
                                    this.tracks.add(this.rd, strings_125_[i_126_].substring(0, strings_125_[i_126_].length() - 4));
                            }
                        }
                        if (this.ltrackname.equals("")) {
                            if (this.trackname.equals(""))
                                this.tracks.select(0);
                            else
                                this.tracks.select(this.trackname);
                        } else
                            this.tracks.select(this.ltrackname);
                        this.mouseon = -1;
                    }
                    this.tracks.move(10, 450);
                    if (this.tracks.getWidth() != 200)
                        this.tracks.setSize(200, 21);
                    if (!this.tracks.isShowing())
                        this.tracks.show();
                    if ((this.track).playing && (this.track).loaded == 2) {
                        if (button("      Stop      ", 110, 495, 2, false))
                            this.track.stop();
                        if (!this.ltrackname.equals(this.tracks.getSelectedItem()))
                            this.track.stop();
                        if (this.xm > 10 && this.xm < 210 && this.ym > 516 && this.ym < 534) {
                            if (this.mouses == 1)
                                this.mouseon = 1;
                            this.rd.setColor(new Color(0, 164, 242));
                        } else
                            this.rd.setColor(new Color(120, 210, 255));
                        this.rd.drawRect(10, 516, 200, 18);
                        this.rd.setColor(new Color(200, 200, 200));
                        this.rd.drawLine(10, 523, 210, 523);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawLine(10, 524, 210, 524);
                        this.rd.drawLine(10, 525, 210, 525);
                        this.rd.drawLine(10, 526, 210, 526);
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.drawLine(10, 527, 210, 527);
                        int i_127_ = (int) ((1.0F - (float) ((this.track).sClip).stream.available() / (float) this.avon) * 200.0F);
                        if (this.mouseon == 1) {
                            i_127_ = this.xm - 10;
                            if (i_127_ < 0)
                                i_127_ = 0;
                            if (i_127_ > 200)
                                i_127_ = 200;
                            if (this.mouses != 1) {
                                ((this.track).sClip).stream.reset();
                                ((this.track).sClip).stream.skip((long) ((float) i_127_ / 200.0F * (float) this.avon));
                                this.mouseon = -1;
                            }
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(8 + i_127_, 516, 4, 18);
                        this.rd.setColor(new Color(0, 164, 242));
                        this.rd.drawLine(10 + i_127_, 520, 10 + i_127_, 518);
                        this.rd.drawLine(10 + i_127_, 530, 10 + i_127_, 532);
                    } else if (this.tracks.getSelectedIndex() != 0 && button("      Play  >      ", 110, 495, 2, false)) {
                        if (!this.ltrackname.equals(this.tracks.getSelectedItem())) {
                            this.track.unload();
                            this.track = new RadicalMod(new StringBuilder().append("mystages/mymusic/").append(this.tracks.getSelectedItem()).append(".zip").toString(), 300, 8000, 125, true, false);
                            if ((this.track).loaded == 2) {
                                this.avon = ((this.track).sClip).stream.available();
                                this.ltrackname = this.tracks.getSelectedItem();
                            } else
                                this.ltrackname = "";
                        }
                        if (!this.ltrackname.equals(""))
                            this.track.play();
                        else
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Failed to load '").append(this.tracks.getSelectedItem()).append("', please make sure it is a valid MOD Track!").toString(), "Stage Maker", 1);
                    }
                    if (this.tracks.getSelectedIndex() != 0) {
                        if (button("   Set as the stage's Sound Track  >   ", 330, 466, 2, false)) {
                            if (!this.ltrackname.equals(this.tracks.getSelectedItem())) {
                                this.track.unload();
                                this.track = new RadicalMod(new StringBuilder().append("mystages/mymusic/").append(this.tracks.getSelectedItem()).append(".zip").toString(), 300, 8000, 125, true, false);
                                if ((this.track).loaded == 2) {
                                    this.avon = ((this.track).sClip).stream.available();
                                    this.ltrackname = this.tracks.getSelectedItem();
                                } else
                                    this.ltrackname = "";
                            }
                            if (!this.ltrackname.equals("")) {
                                this.trackname = this.ltrackname;
                                this.trackvol = (int) (220.0F / ((float) (this.track).rvol / 3750.0F));
                                try {
                                    File file = new File(new StringBuilder().append("mystages/mymusic/").append(this.trackname).append(".zip").toString());
                                    this.tracksize = (int) (file.length() / 1024L);
                                    if (this.tracksize > 250) {
                                        JOptionPane.showMessageDialog(null, new StringBuilder().append("Cannot use '").append(this.tracks.getSelectedItem()).append("' as the sound track!\nIts file size is bigger then 250KB.\n\n").toString(), "Stage Maker", 1);
                                        this.trackname = "";
                                    }
                                } catch (Exception exception) {
                                    this.tracksize = 111;
                                }
                            } else
                                JOptionPane.showMessageDialog(null, new StringBuilder().append("Failed to load '").append(this.tracks.getSelectedItem()).append("', please make sure it is a valid MOD Track!").toString(), "Stage Maker", 1);
                        }
                        if (button("   X Delete   ", 258, 495, 2, false) && JOptionPane.showConfirmDialog(null, new StringBuilder().append("Are you sure you want to permanently delete this MOD Track from your Play List?\n\n").append(this.tracks.getSelectedItem()).append("\n\n>  If you delete this Track from the Play List you will not be able to use it for other stages as well!     \n\n").toString(), "Stage Maker", 0) == 0)
                            deltrack();
                    }
                    if (button("   Add a new MOD Track from file . . .  ", 330, 530, 0, false) && JOptionPane.showConfirmDialog(null, "The game only accepts MOD format music files for the game ('.mod' file extension).\nA good place to find MOD Tracks is the modarchive.com, all the current MOD Tracks\nthat are distributed with the game are from the modarchive.com.\n\nTo find out more about MOD Tracks and to learn how to compose & remix your own\nmusic, please read the section of the Stage Maker help about it.\n\nThe MOD Track needs to be compressed in a zip file to be added here, please make\nsure the MOD Track you wish to add to your stages sound track play list is zipped before\nadding it here.\nThe ZIP file must also be less then 250KB in size.\n\nIs the track you are about to insert a MOD Track in a ZIP file that is less then 250KB?\n", "Stage Maker", 0) == 0) {
                        File file = null;
                        FileDialog filedialog = new FileDialog(new Frame(), "Stage Maker - Add MOD Track file to stage sound track play list!");
                        filedialog.setFile("*.zip");
                        filedialog.setMode(0);
                        filedialog.setVisible(true);
                        try {
                            if (filedialog.getFile() != null)
                                file = new File(new StringBuilder().append("").append(filedialog.getDirectory()).append("").append(filedialog.getFile()).append("").toString());
                        } catch (Exception exception) {
                            /* empty */
                        }
                        if (file != null) {
                            try {
                                if (file.length() / 1024L < 250L) {
                                    File file_128_ = new File("mystages/mymusic/");
                                    if (!file_128_.exists())
                                        file_128_.mkdirs();
                                    file_128_ = new File(new StringBuilder().append("mystages/mymusic/").append(file.getName()).append("").toString());
                                    FileInputStream fileinputstream = new FileInputStream(file);
                                    FileOutputStream fileoutputstream = new FileOutputStream(file_128_);
                                    byte[] is_129_ = new byte[1024];
                                    int i_130_;
                                    while ((i_130_ = fileinputstream.read(is_129_)) > 0)
                                    fileoutputstream.write(is_129_, 0, i_130_);
                                    fileinputstream.close();
                                    fileoutputstream.close();
                                    this.tracks.removeAll();
                                    this.tracks.add(this.rd, "Select MOD Track                      ");
                                    String[] strings_131_ = new File("mystages/mymusic/").list();
                                    if (strings_131_ != null) {
                                        for (int i_132_ = 0; i_132_ < strings_131_.length; i_132_++) {
                                            if (strings_131_[i_132_].toLowerCase().endsWith(".zip"))
                                                this.tracks.add(this.rd, strings_131_[i_132_].substring(0, strings_131_[i_132_].length() - 4));
                                        }
                                    }
                                    this.tracks.select(file.getName().substring(0, file.getName().length() - 4));
                                } else
                                    JOptionPane.showMessageDialog(null, "The selected file is larger then 250KB in size and therefore cannot be added!", "Stage Maker", 1);
                            } catch (Exception exception) {
                                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to copy file! Error Deatials:\n").append(exception).toString(), "Stage Maker", 1);
                            }
                        }
                    }
                    int i_133_ = 200;
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Sound Track", 280 + i_133_, 461);
                    String string = this.trackname;
                    if (string.equals(""))
                        string = "No Sound Track set.";
                    else if (button("   <  Remove Track   ", 378, 495, 2, false))
                        this.trackname = "";
                    this.rd.drawString(string, 629 - this.ftm.stringWidth(string) / 2, 482);
                    this.rd.setColor(new Color(128, 128, 128));
                    this.rd.drawLine(270 + i_133_, 457, 277 + i_133_, 457);
                    this.rd.drawLine(589 + i_133_, 457, 353 + i_133_, 457);
                    this.rd.drawLine(270 + i_133_, 457, 270 + i_133_, 497);
                    this.rd.drawLine(589 + i_133_, 457, 589 + i_133_, 497);
                    this.rd.drawLine(270 + i_133_, 497, 589 + i_133_, 497);
                    if (button(" Reset ", 576, 530, 0, true)) {
                        this.ltrackname = "";
                        this.dtabed = -2;
                    }
                    if (button("        Save        ", 663, 530, 0, true)) {
                        sortop();
                        savefile();
                    }
                }
                if (this.dtab == 6) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Test Drive the Stage", 400 - this.ftm.stringWidth("Test Drive the Stage") / 2, 470);
                    this.witho.move(342, 480);
                    if (!this.witho.isShowing())
                        this.witho.show();
                    if (button("     TEST DRIVE!     ", 400, 530, 0, true)) {
                        savefile();
                        this.errd = 0;
                        readstage(3);
                        if ((this.cp).nsp < 2)
                            this.errd = 7;
                        if (this.errd == 0) {
                            Madness.testcar = this.stagename;
                            Madness.testdrive = this.witho.getSelectedIndex() + 3;
                            Madness.game();
                        } else
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error!  This stage is not ready for a test drive!\nReason:\n").append(this.errlo[this.errd - 1]).append("\n\n").toString(), "Stage Maker", 0);
                    }
                }
                if (this.dtabed != this.dtab) {
                    if (this.dtabed == -2)
                        this.dtabed = -1;
                    else
                        this.dtabed = this.dtab;
                }
            }
            if (this.tab == 3) {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString(new StringBuilder().append("Publish Stage :  [ ").append(this.stagename).append(" ]").toString(), 30, 50);
                this.rd.drawString("Publishing Type :", 30, 80);
                this.pubtyp.move(150, 63);
                if (!this.pubtyp.isShowing()) {
                    this.pubtyp.show();
                    this.pubtyp.select(1);
                }
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.setFont(new Font("Arial", 0, 12));
                if (this.pubtyp.getSelectedIndex() == 0) {
                    this.rd.drawString("Private :  This means only you can have your stage in your account and no one else can add", 268, 72);
                    this.rd.drawString("it to their account to play it!", 268, 88);
                }
                if (this.pubtyp.getSelectedIndex() == 1) {
                    this.rd.drawString("Public :  This means anyone can add this stage to their account to play it, but only you can", 268, 72);
                    this.rd.drawString("download it to your Stage Maker and edit it (no one else but you can edit it).", 268, 88);
                }
                if (this.pubtyp.getSelectedIndex() == 2) {
                    this.rd.drawString("Super Public :  This means anyone can add this stage to their account to play it and can also", 268, 72);
                    this.rd.drawString("download it to their stage Maker, edit it and publish it.", 268, 88);
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                this.rd.drawString("Stage Name", 180 - this.ftm.stringWidth("Stage Name") / 2, 138);
                this.rd.drawString("Created By", 400 - this.ftm.stringWidth("Created By") / 2, 138);
                this.rd.drawString("Added By", 500 - this.ftm.stringWidth("Added By") / 2, 138);
                this.rd.drawString("Publish Type", 600 - this.ftm.stringWidth("Publish Type") / 2, 138);
                this.rd.drawString("Options", 720 - this.ftm.stringWidth("Options") / 2, 138);
                this.rd.drawLine(350, 129, 350, 140);
                this.rd.drawLine(450, 129, 450, 140);
                this.rd.drawLine(550, 129, 550, 140);
                this.rd.drawLine(650, 129, 650, 140);
                this.rd.drawRect(10, 140, 780, 402);
                if (button("       Publish  >       ", 102, 110, 0, true)) {
                    if (this.logged == 0)
                        JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Stage Maker", 1);
                    if (this.logged == 3 || this.logged == -1) {
                        savefile();
                        this.errd = 0;
                        readstage(3);
                        if ((this.cp).nsp < 2)
                            this.errd = 7;
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.ftm.stringWidth(this.stagename) > 274)
                            this.errd = 8;
                        if (this.errd == 0) {
                            int i = 0;
                            for (int i_134_ = 0; i_134_ < this.nms; i_134_++) {
                                if (this.mystages[i_134_].equals(this.stagename) && this.maker[i_134_].toLowerCase().equals(this.tnick.getText().toLowerCase()))
                                    i = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Replace your already online stage '").append(this.stagename).append("' with this one?").toString(), "Stage Maker", 0);
                            }
                            if (i == 0) {
                                setCursor(new Cursor(3));
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(225, 225, 225));
                                this.rd.fillRect(11, 141, 779, 401);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("Connecting to Server...", 400 - this.ftm.stringWidth("Connecting to Server...") / 2, 250);
                                repaint();
                                int i_135_ = -1;
                                try {
                                    Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                    PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                                    Object object = null;
                                    printwriter.println(new StringBuilder().append("20|").append(this.tnick.getText()).append("|").append(this.tpass.getText()).append("|").append(this.stagename).append("|").append(this.pubtyp.getSelectedIndex()).append("|").toString());
                                    String string = bufferedreader.readLine();
                                    if (string != null)
                                        i_135_ = servervalue(string, 0);
                                    if (i_135_ == 0) {
                                        String string_136_ = " Publishing Stage ";
                                        String string_137_ = new StringBuilder().append("").append(this.tstage).append("\r\n").append(this.bstage).append("").toString();
                                        DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(string_137_.getBytes()));
                                        Object object_138_ = null;
                                        String string_139_;
                                        while ((string_139_ = datainputstream.readLine()) != null) {
                                            string_139_ = string_139_.trim();
                                            printwriter.println(string_139_);
                                            this.rd.setColor(new Color(225, 225, 225));
                                            this.rd.fillRect(11, 141, 779, 401);
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.drawString(string_136_, 400 - this.ftm.stringWidth(string_136_) / 2, 250);
                                            string_136_ = new StringBuilder().append("| ").append(string_136_).append(" |").toString();
                                            if (string_136_.equals("| | | | | | | | | | | | | | | | | | | | | | | |  Publishing Stage  | | | | | | | | | | | | | | | | | | | | | | | |"))
                                                string_136_ = " Publishing Stage ";
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
                                        this.rd.fillRect(11, 141, 779, 401);
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString("Creating the stage online...", 400 - this.ftm.stringWidth("Creating the stage online...") / 2, 250);
                                        this.rd.drawString("This may take a couple of minutes, please wait...", 400 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                                        repaint();
                                        string = bufferedreader.readLine();
                                        if (string != null)
                                            i_135_ = servervalue(string, 0);
                                        else
                                            i_135_ = -1;
                                        if (i_135_ == 0) {
                                            this.rd.setColor(new Color(225, 225, 225));
                                            this.rd.fillRect(11, 141, 779, 401);
                                            this.rd.setColor(new Color(0, 0, 0));
                                            this.rd.drawString("Uploading stage's sound track...", 400 - this.ftm.stringWidth("Uploading Stage's Sound Track...") / 2, 250);
                                            this.rd.drawString("This may take a couple of minutes, please wait...", 400 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                                            repaint();
                                            File file = new File(new StringBuilder().append("mystages/mymusic/").append(this.trackname).append(".zip").toString());
                                            if (!this.trackname.equals("") && file.exists()) {
                                                int i_140_ = (int) file.length();
                                                printwriter.println(new StringBuilder().append("track|").append(this.trackname).append("|").append(i_140_).append("|").toString());
                                                string = bufferedreader.readLine();
                                                if (string != null)
                                                    i_135_ = servervalue(string, 0);
                                                else
                                                    i_135_ = -2;
                                                if (i_135_ == 0) {
                                                    FileInputStream fileinputstream = new FileInputStream(file);
                                                    byte[] is = new byte[i_140_];
                                                    fileinputstream.read(is);
                                                    fileinputstream.close();
                                                    DataOutputStream dataoutputstream = new DataOutputStream(socket.getOutputStream());
                                                    dataoutputstream.write(is, 0, i_140_);
                                                    string = bufferedreader.readLine();
                                                    if (string != null)
                                                        i_135_ = servervalue(string, 0);
                                                    else
                                                        i_135_ = -2;
                                                }
                                                if (i_135_ == -67)
                                                    i_135_ = 0;
                                            } else {
                                                printwriter.println("END");
                                                string = bufferedreader.readLine();
                                            }
                                        }
                                    }
                                    socket.close();
                                } catch (Exception exception) {
                                    i_135_ = -1;
                                }
                                setCursor(new Cursor(0));
                                boolean bool = false;
                                if (i_135_ == 0) {
                                    this.logged = 1;
                                    bool = true;
                                }
                                if (i_135_ == 3) {
                                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to publish stage.\nReason:\n").append(this.errlo[8]).append("\n\n").toString(), "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == 4) {
                                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to publish stage.\nReason:\nStage name used (").append(this.stagename).append(").\nThe name '").append(this.stagename).append("' is already used by another published stage.\nPlease rename your stage.\n\n").toString(), "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == 5) {
                                    JOptionPane.showMessageDialog(null, "Unable to create stage online!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ > 5) {
                                    JOptionPane.showMessageDialog(null, "Unable to publish stage fully!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == -4) {
                                    this.logged = 1;
                                    JOptionPane.showMessageDialog(null, "Unable to upload sound track!\nReason:\nAnother MOD Track is already uploaded with the same name, please rename your Track.\nOpen your 'mystages' folder then open 'mymusic' to find your MOD Track to rename it.\n\n", "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == -3) {
                                    this.logged = 1;
                                    JOptionPane.showMessageDialog(null, "Unable to upload sound track!\nReason:\nYour MOD Track\u2019s file size is too large, Track file size must be less then 250KB to be accepted.\n\n", "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == -2) {
                                    this.logged = 1;
                                    JOptionPane.showMessageDialog(null, "Unable to upload sound track!  Unknown Error.  Please try again later.", "Stage Maker", 1);
                                    bool = true;
                                }
                                if (!bool)
                                    JOptionPane.showMessageDialog(null, "Unable to publish stage!  Unknown Error.", "Stage Maker", 1);
                            }
                        } else
                            JOptionPane.showMessageDialog(null, new StringBuilder().append("Error!  This stage is not ready for publishing!\nReason:\n").append(this.errlo[this.errd - 1]).append("\n\n").toString(), "Stage Maker", 0);
                    }
                }
                if (this.logged == 3) {
                    for (int i = 0; i < this.nms; i++) {
                        this.rd.setColor(new Color(235, 235, 235));
                        if (this.xm > 11 && this.xm < 789 && this.ym > 142 + i * 20 && this.ym < 160 + i * 20)
                            this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(11, 142 + i * 20, 778, 18);
                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.mystages[i], 180 - this.ftm.stringWidth(this.mystages[i]) / 2, 156 + i * 20);
                        this.rd.setColor(new Color(155, 155, 155));
                        this.rd.drawLine(350, 145 + i * 20, 350, 157 + i * 20);
                        if (this.pubt[i] != -1) {
                            this.rd.drawLine(450, 145 + i * 20, 450, 157 + i * 20);
                            this.rd.drawLine(550, 145 + i * 20, 550, 157 + i * 20);
                            this.rd.drawLine(650, 145 + i * 20, 650, 157 + i * 20);
                            boolean bool = false;
                            if (this.maker[i].toLowerCase().equals(this.tnick.getText().toLowerCase())) {
                                bool = true;
                                this.rd.setColor(new Color(0, 64, 0));
                                this.rd.drawString("You", 400 - this.ftm.stringWidth("You") / 2, 156 + i * 20);
                            } else {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString(this.maker[i], 400 - this.ftm.stringWidth(this.maker[i]) / 2, 156 + i * 20);
                            }
                            if (this.nad[i] > 1) {
                                if (ovbutton(new StringBuilder().append("").append(this.nad[i]).append(" Players").toString(), 500, 156 + i * 20)) {
                                    String string = new StringBuilder().append("[ ").append(this.mystages[i]).append(" ]  has been added by the following players to their accounts:     \n\n").toString();
                                    int i_141_ = 0;
                                    for (int i_142_ = 0; i_142_ < this.nad[i]; i_142_++) {
                                        if (++i_141_ == 17) {
                                            string = new StringBuilder().append(string).append("\n").toString();
                                            i_141_ = 1;
                                        }
                                        string = new StringBuilder().append(string).append(this.addeda[i][i_142_]).toString();
                                        if (i_142_ != this.nad[i] - 1) {
                                            if (i_142_ != this.nad[i] - 2)
                                                string = new StringBuilder().append(string).append(", ").toString();
                                            else if (i_141_ == 16) {
                                                string = new StringBuilder().append(string).append("\nand ").toString();
                                                i_141_ = 0;
                                            } else
                                                string = new StringBuilder().append(string).append(" and ").toString();
                                        }
                                    }
                                    string = new StringBuilder().append(string).append("\n \n \n").toString();
                                    JOptionPane.showMessageDialog(null, string, "Stage Maker", 1);
                                }
                            } else {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("None", 500 - this.ftm.stringWidth("None") / 2, 156 + i * 20);
                            }
                            if (this.pubt[i] == 0) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("Private", 600 - this.ftm.stringWidth("Private") / 2, 156 + i * 20);
                            }
                            if (this.pubt[i] == 1) {
                                this.rd.setColor(new Color(0, 0, 64));
                                this.rd.drawString("Public", 600 - this.ftm.stringWidth("Public") / 2, 156 + i * 20);
                            }
                            if (this.pubt[i] == 2) {
                                this.rd.setColor(new Color(0, 64, 0));
                                this.rd.drawString("Super Public", 600 - this.ftm.stringWidth("Super Public") / 2, 156 + i * 20);
                            }
                            if ((this.pubt[i] == 2 || bool) && ovbutton("Download", 700, 156 + i * 20)) {
                                int i_143_ = 0;
                                for (int i_144_ = 0; i_144_ < this.slstage.getItemCount(); i_144_++) {
                                    if (this.mystages[i].equals(this.slstage.getItem(i_144_)))
                                        i_143_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Replace the local ").append(this.mystages[i]).append(" in your 'mystages' folder with the published online copy?").toString(), "Stage Maker", 0);
                                }
                                if (i_143_ == 0) {
                                    setCursor(new Cursor(3));
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(225, 225, 225));
                                    this.rd.fillRect(11, 141, 779, 401);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Downloading stage, please wait...", 400 - this.ftm.stringWidth("Downloading stage, please wait...") / 2, 250);
                                    repaint();
                                    try {
                                        String string = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/").append(this.mystages[i]).append(".radq?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
                                        string = string.replace(' ', '_');
                                        URL url = new URL(string);
                                        int i_145_ = url.openConnection().getContentLength();
                                        DataInputStream datainputstream = new DataInputStream(url.openStream());
                                        byte[] is = new byte[i_145_];
                                        datainputstream.readFully(is);
                                        datainputstream.close();
                                        ZipInputStream zipinputstream;
                                        if (is[0] == 80 && is[1] == 75 && is[2] == 3)
                                            zipinputstream = new ZipInputStream(new ByteArrayInputStream(is));
                                        else {
                                            byte[] is_146_ = new byte[i_145_ - 40];
                                            for (int i_147_ = 0; i_147_ < i_145_ - 40; i_147_++) {
                                                int i_148_ = 20;
                                                if (i_147_ >= 500)
                                                    i_148_ = 40;
                                                is_146_[i_147_] = is[i_147_ + i_148_];
                                            }
                                            zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_146_));
                                        }
                                        ZipEntry zipentry = zipinputstream.getNextEntry();
                                        if (zipentry != null) {
                                            String string_149_ = "";
                                            int i_150_ = Integer.valueOf(zipentry.getName()).intValue();
                                            byte[] is_151_ = new byte[i_150_];
                                            int i_152_ = 0;
                                            int i_153_;
                                            for (/**/; i_150_ > 0; i_150_ -= i_153_) {
                                                i_153_ = zipinputstream.read(is_151_, i_152_, i_150_);
                                                i_152_ += i_153_;
                                            }
                                            String string_154_ = new String(is_151_);
                                            string_154_ = new StringBuilder().append(string_154_).append("\n").toString();
                                            String string_155_ = "";
                                            int i_156_ = 0;
                                            int i_157_ = string_154_.indexOf("\n", 0);
                                            while (i_157_ != -1 && i_156_ < string_154_.length()) {
                                                String string_158_ = string_154_.substring(i_156_, i_157_);
                                                string_158_ = string_158_.trim();
                                                i_156_ = i_157_ + 1;
                                                i_157_ = string_154_.indexOf("\n", i_156_);
                                                if (!string_158_.startsWith("stagemaker(") && !string_158_.startsWith("publish("))
                                                    string_155_ = new StringBuilder().append(string_155_).append("").append(string_158_).append("\r\n").toString();
                                                else {
                                                    string_155_ = string_155_.trim();
                                                    string_155_ = new StringBuilder().append(string_155_).append("\r\n").toString();
                                                }
                                                if (string_158_.startsWith("soundtrack"))
                                                    string_149_ = getstring("soundtrack", string_158_, 0);
                                            }
                                            string_155_ = string_155_.trim();
                                            string_155_ = new StringBuilder().append(string_155_).append("\r\n\r\n").toString();
                                            File file = new File("mystages/");
                                            if (!file.exists())
                                                file.mkdirs();
                                            file = new File(new StringBuilder().append("mystages/").append(this.mystages[i]).append(".txt").toString());
                                            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                                            bufferedwriter.write(string_155_);
                                            bufferedwriter.close();
                                            Object object = null;
                                            zipinputstream.close();
                                            if (!string_149_.equals("")) {
                                                try {
                                                    this.rd.setColor(new Color(0, 0, 0));
                                                    this.rd.drawString("Downloading stage's sound track...", 400 - this.ftm.stringWidth("Downloading stage's sound track...") / 2, 280);
                                                    repaint();
                                                    string = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/music/").append(string_149_).append(".zip").toString();
                                                    string = string.replace(' ', '_');
                                                    url = new URL(string);
                                                    i_145_ = url.openConnection().getContentLength();
                                                    file = new File(new StringBuilder().append("mystages/mymusic/").append(string_149_).append(".zip").toString());
                                                    if (file.exists()) {
                                                        if (file.length() == (long) i_145_)
                                                            i_143_ = 1;
                                                        else
                                                            i_143_ = JOptionPane.showConfirmDialog(null, new StringBuilder().append("Another track named '").append(string_149_).append("' already exists in your Sound Tracks folder!\nReplace it with the one attached to this stage?").toString(), "Stage Maker", 0);
                                                    }
                                                    if (i_143_ == 0) {
                                                        datainputstream = new DataInputStream(url.openStream());
                                                        is = new byte[i_145_];
                                                        datainputstream.readFully(is);
                                                        datainputstream.close();
                                                        FileOutputStream fileoutputstream = new FileOutputStream(file);
                                                        fileoutputstream.write(is);
                                                        fileoutputstream.close();
                                                        Object object_159_ = null;
                                                    }
                                                } catch (Exception exception) {
                                                    /* empty */
                                                }
                                            }
                                            setCursor(new Cursor(0));
                                            JOptionPane.showMessageDialog(null, new StringBuilder().append("").append(this.mystages[i]).append(" has been successfully downloaded!").toString(), "Stage Maker", 1);
                                        } else
                                            JOptionPane.showMessageDialog(null, "Unable to download stage.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                                    } catch (Exception exception) {
                                        JOptionPane.showMessageDialog(null, "Unable to download stage.  Unknown Error!     \nPlease try again later.", "Stage Maker", 1);
                                    }
                                }
                            }
                        } else
                            this.rd.drawString("-    Error Loading this stage's info!    -", 550 - this.ftm.stringWidth("-    Error Loading this stage's info!    -") / 2, 156 + i * 20);
                        if (ovbutton("X", 765, 156 + i * 20) && JOptionPane.showConfirmDialog(null, new StringBuilder().append("Remove ").append(this.mystages[i]).append(" from your account?").toString(), "Stage Maker", 0) == 0) {
                            setCursor(new Cursor(3));
                            int i_160_ = -1;
                            try {
                                Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                                PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                                printwriter.println(new StringBuilder().append("19|").append(this.tnick.getText()).append("|").append(this.tpass.getText()).append("|").append(this.mystages[i]).append("|").toString());
                                String string = bufferedreader.readLine();
                                if (string != null)
                                    i_160_ = servervalue(string, 0);
                                socket.close();
                            } catch (Exception exception) {
                                i_160_ = -1;
                            }
                            if (i_160_ == 0)
                                this.logged = 1;
                            else {
                                setCursor(new Cursor(0));
                                JOptionPane.showMessageDialog(null, new StringBuilder().append("Failed to remove ").append(this.mystages[i]).append(" from your account.  Unknown Error!     \nPlease try again later.").toString(), "Stage Maker", 1);
                            }
                        }
                    }
                }
                if (this.logged == 2) {
                    for (int i = 0; i < this.nms; i++) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(225, 225, 225));
                        this.rd.fillRect(50, 150, 600, 150);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(new StringBuilder().append("Loading ").append(this.mystages[i]).append("\u2018s info...").toString(), 400 - this.ftm.stringWidth(new StringBuilder().append("Loading ").append(this.mystages[i]).append("\u2018s info...").toString()) / 2, 220);
                        repaint();
                        this.maker[i] = "Unkown";
                        this.pubt[i] = -1;
                        this.nad[i] = 0;
                        String string = "";
                        try {
                            String string_161_ = new StringBuilder().append("http://multiplayer.needformadness.com/tracks/").append(this.mystages[i]).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
                            string_161_ = string_161_.replace(' ', '_');
                            URL url = new URL(string_161_);
                            DataInputStream datainputstream = new DataInputStream(url.openStream());
                            while ((string = datainputstream.readLine()) != null) {
                                string = new StringBuilder().append("").append(string.trim()).toString();
                                if (string.startsWith("details")) {
                                    this.maker[i] = getSvalue("details", string, 0);
                                    this.pubt[i] = getvalue("details", string, 1);
                                    boolean bool = false;
                                    while (!bool) {
                                        this.addeda[i][this.nad[i]] = getSvalue("details", string, 2 + this.nad[i]);
                                        if (this.addeda[i][this.nad[i]].equals(""))
                                            bool = true;
                                        else
                                            this.nad[i]++;
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
                if (this.logged == -1) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Account empty, no published stages found.", 400 - this.ftm.stringWidth("Account empty, no published stages found.") / 2, 220);
                    this.rd.drawString("Click \u2018Publish\u2019 above to begin.", 400 - this.ftm.stringWidth("Click \u2018Publish\u2019 above to begin.") / 2, 280);
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("The maximum number of stages your account can have at once is 20 stages.", 400 - this.ftm.stringWidth("The maximum number of stages your account can have at once is 20 stages.") / 2, 320);
                }
                if (this.logged == 1) {
                    this.rd.setColor(new Color(225, 225, 225));
                    this.rd.fillRect(11, 141, 779, 401);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Loading your account's stage list...", 400 - this.ftm.stringWidth("Loading your account's stage list...") / 2, 220);
                    repaint();
                    this.nms = 0;
                    String string = "";
                    try {
                        URL url = new URL(new StringBuilder().append("http://multiplayer.needformadness.com/tracks/lists/").append(this.tnick.getText()).append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                        DataInputStream datainputstream = new DataInputStream(url.openStream());
                        while ((string = datainputstream.readLine()) != null) {
                            string = new StringBuilder().append("").append(string.trim()).toString();
                            if (string.startsWith("mystages")) {
                                boolean bool = true;
                                while (bool && this.nms < 20) {
                                    this.mystages[this.nms] = getSvalue("mystages", string, this.nms);
                                    if (this.mystages[this.nms].equals(""))
                                        bool = false;
                                    else
                                        this.nms++;
                                }
                            }
                        }
                        if (this.nms > 0)
                            this.logged = 2;
                        else {
                            setCursor(new Cursor(0));
                            this.logged = -1;
                        }
                        datainputstream.close();
                    } catch (Exception exception) {
                        String string_162_ = new StringBuilder().append("").append(exception).toString();
                        if (string_162_.indexOf("FileNotFound") != -1) {
                            setCursor(new Cursor(0));
                            this.logged = -1;
                        } else {
                            this.logged = 0;
                            JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Stage Maker", 1);
                        }
                    }
                }
                if (this.logged == 0) {
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("The maximum number of stages your account can have at once is 20 stages.", 400 - this.ftm.stringWidth("The maximum number of stages your account can have at once is 20 stages.") / 2, 180);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Login to Retrieve your Account Stages", 400 - this.ftm.stringWidth("Login to Retrieve your Account Stages") / 2, 220);
                    this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 266);
                    if (!this.tnick.isShowing())
                        this.tnick.show();
                    movefield(this.tnick, 376, 250, 129, 23);
                    this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 296);
                    if (!this.tpass.isShowing())
                        this.tpass.show();
                    movefield(this.tpass, 376, 280, 129, 23);
                    if (button("       Login       ", 400, 340, 0, true)) {
                        setCursor(new Cursor(3));
                        int i = -1;
                        try {
                            Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                            printwriter.println(new StringBuilder().append("1|").append(this.tnick.getText().toLowerCase()).append("|").append(this.tpass.getText()).append("|").toString());
                            String string = bufferedreader.readLine();
                            if (string != null)
                                i = servervalue(string, 0);
                            socket.close();
                        } catch (Exception exception) {
                            i = -1;
                        }
                        if (i == 0 || i == 3 || i > 10) {
                            this.tnick.hide();
                            this.tpass.hide();
                            this.logged = 1;
                            savesettings();
                        }
                        if (i == 1 || i == 2) {
                            setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Stage Maker", 0);
                        }
                        if (i == -167) {
                            setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null, "Sorry.  Trial accounts are not allowed to publish cars & stages, please register a full account!", "Stage Maker", 0);
                        }
                        if (i == -1) {
                            setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Stage Maker", 1);
                        }
                    }
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Not registered yet?", 400 - this.ftm.stringWidth("Not registered yet?") / 2, 450);
                    if (button("   Register Now!   ", 400, 480, 0, true))
                        Madness.openurl("http://multiplayer.needformadness.com/register.html");
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Register to publish your stages to the multiplayer game!", 400 - this.ftm.stringWidth("Register to publish your stages to the multiplayer game!") / 2, 505);
                }
            }
            if (this.tabed != this.tab) {
                if (this.tabed == -2)
                    this.tabed = -1;
                else
                    this.tabed = this.tab;
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 800, 25);
            if (!this.onbtgame)
                this.rd.drawImage(this.btgame[0], 620, 0, null);
            else
                this.rd.drawImage(this.btgame[1], 620, 0, null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            String[] strings = { "Stage", "Build", "View & Edit", "Publish" };
            int[] is = { 0, 0, 100, 90 };
            int[] is_163_ = { 0, 25, 25, 0 };
            int i = 4;
            if (this.stagename.equals("") || this.sfase != 0) {
                this.tab = 0;
                i = 1;
            }
            for (int i_164_ = 0; i_164_ < i; i_164_++) {
                this.rd.setColor(new Color(170, 170, 170));
                if (this.xm > is[0] && this.xm < is[3] && this.ym > 0 && this.ym < 25)
                    this.rd.setColor(new Color(200, 200, 200));
                if (this.tab == i_164_)
                    this.rd.setColor(new Color(225, 225, 225));
                this.rd.fillPolygon(is, is_163_, 4);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString(strings[i_164_], i_164_ * 100 + 45 - this.ftm.stringWidth(strings[i_164_]) / 2, 17);
                if (this.xm > is[0] && this.xm < is[3] && this.ym > 0 && this.ym < 25 && this.mouses == -1)
                    this.tab = i_164_;
                for (int i_165_ = 0; i_165_ < 4; i_165_++)
                    is[i_165_] += 100;
            }
            if (this.mouses == -1)
                this.mouses = 0;
            drawms();
            repaint();
            if (!this.exwist) {
                try {
                    if (this.thredo != null) {
                        /* empty */
                    }
                    Thread.sleep(40L);
                } catch (InterruptedException interruptedexception) {
                    /* empty */
                }
            }
        }
        this.track.unload();
        this.track = null;
        this.rd.dispose();
        System.gc();
    }
    
    public void removesp() {
        if (this.nundo < 5000) {
            this.undos[this.nundo] = this.bstage;
            this.nundo++;
        }
        String string = "";
        if ((this.co[this.esp]).colok != 30 && (this.co[this.esp]).colok != 31 && (this.co[this.esp]).colok != 32 && (this.co[this.esp]).colok != 66)
            string = new StringBuilder().append("set(").append((this.co[this.esp]).colok + 10).append(",").append((this.co[this.esp]).x).append(",").append((this.co[this.esp]).z).append(",").append((this.co[this.esp]).roofat).append(")").toString();
        if ((this.co[this.esp]).colok == 31)
            string = new StringBuilder().append("fix(").append((this.co[this.esp]).colok + 10).append(",").append((this.co[this.esp]).x).append(",").append((this.co[this.esp]).z).append(",").append((this.co[this.esp]).y).append(",").append((this.co[this.esp]).roofat).append(")").toString();
        if ((this.co[this.esp]).colok == 30 || (this.co[this.esp]).colok == 32)
            string = new StringBuilder().append("chk(").append((this.co[this.esp]).colok + 10).append(",").append((this.co[this.esp]).x).append(",").append((this.co[this.esp]).z).append(",").append((this.co[this.esp]).roofat).append(")").toString();
        if ((this.co[this.esp]).colok == 54)
            string = new StringBuilder().append("chk(").append((this.co[this.esp]).colok + 10).append(",").append((this.co[this.esp]).x).append(",").append((this.co[this.esp]).z).append(",").append((this.co[this.esp]).roofat).append(",").append((this.co[this.esp]).y).append(")").toString();
        if ((this.co[this.esp]).colok == 66)
            string = new StringBuilder().append("pile(").append((this.co[this.esp]).srz).append(",").append((this.co[this.esp]).srx).append(",").append((this.co[this.esp]).sry).append(",").append((this.co[this.esp]).x).append(",").append((this.co[this.esp]).z).append(")").toString();
        int i = this.bstage.indexOf(string);
        int i_166_ = i + string.length();
        int i_167_ = -1;
        int i_168_ = this.bstage.indexOf("set", i_166_);
        if (i_168_ != -1)
            i_167_ = i_168_;
        i_168_ = this.bstage.indexOf("chk", i_166_);
        if (i_168_ != -1 && i_168_ < i_167_)
            i_167_ = i_168_;
        i_168_ = this.bstage.indexOf("fix", i_166_);
        if (i_168_ != -1 && i_168_ < i_167_)
            i_167_ = i_168_;
        if (i_167_ == -1) {
            i_167_ = this.bstage.indexOf("\r\n", i_166_);
            if (i_167_ != -1)
                i_167_++;
        }
        if (i_167_ != -1)
            i_166_ = i_167_;
        if (i != -1)
            this.bstage = new StringBuilder().append("").append(this.bstage.substring(0, i)).append("").append(this.bstage.substring(i_166_, this.bstage.length())).append("").toString();
        readstage(0);
    }
    
    public void copyesp(boolean bool) {
        this.sp = (this.co[this.esp]).colok;
        this.rot = (this.co[this.esp]).roofat;
        if (this.sp == 2)
            this.rot -= 30;
        if (this.sp == 3)
            this.rot += 30;
        if (this.sp == 15)
            this.rot += 90;
        if (this.sp == 20)
            this.rot += 180;
        if (this.sp == 26)
            this.rot -= 90;
        if (this.sp == 0) {
            this.sptyp = 0;
            this.spart = 0;
        }
        if (this.sp == 4) {
            this.sptyp = 0;
            this.spart = 1;
        }
        if (this.sp == 13) {
            this.sptyp = 0;
            this.spart = 2;
        }
        if (this.sp == 3) {
            this.sptyp = 0;
            this.spart = 3;
        }
        if (this.sp == 2) {
            this.sptyp = 0;
            this.spart = 4;
        }
        if (this.sp == 1) {
            this.sptyp = 0;
            this.spart = 5;
        }
        if (this.sp == 35) {
            this.sptyp = 0;
            this.spart = 6;
        }
        if (this.sp == 36) {
            this.sptyp = 0;
            this.spart = 7;
        }
        if (this.sp == 10) {
            this.sptyp = 0;
            this.spart = 8;
        }
        if (this.sp == 5) {
            this.sptyp = 0;
            this.spart = 9;
        }
        if (this.sp == 7) {
            this.sptyp = 0;
            this.spart = 10;
        }
        if (this.sp == 14) {
            this.sptyp = 0;
            this.spart = 11;
        }
        if (this.sp == 6) {
            this.sptyp = 0;
            this.spart = 12;
        }
        if (this.sp == 34) {
            this.sptyp = 0;
            this.spart = 13;
        }
        if (this.sp == 33) {
            this.sptyp = 0;
            this.spart = 14;
        }
        if (this.sp == 11) {
            this.sptyp = 0;
            this.spart = 15;
        }
        if (this.sp == 8) {
            this.sptyp = 0;
            this.spart = 16;
        }
        if (this.sp == 9) {
            this.sptyp = 0;
            this.spart = 17;
        }
        if (this.sp == 15) {
            this.sptyp = 0;
            this.spart = 18;
        }
        if (this.sp == 12) {
            this.sptyp = 0;
            this.spart = 19;
        }
        if (this.sp == 46) {
            this.sptyp = 0;
            this.spart = 20;
        }
        if (this.sp == 47) {
            this.sptyp = 0;
            this.spart = 21;
        }
        if (this.sp == 48) {
            this.sptyp = 0;
            this.spart = 23;
        }
        if (this.sp == 49) {
            this.sptyp = 0;
            this.spart = 24;
        }
        if (this.sp == 50) {
            this.sptyp = 0;
            this.spart = 22;
        }
        if (this.sp == 51) {
            this.sptyp = 0;
            this.spart = 25;
        }
        if (this.sp == 16) {
            this.sptyp = 1;
            this.spart = 0;
        }
        if (this.sp == 18) {
            this.sptyp = 1;
            this.spart = 1;
        }
        if (this.sp == 19) {
            this.sptyp = 1;
            this.spart = 2;
        }
        if (this.sp == 22) {
            this.sptyp = 1;
            this.spart = 3;
        }
        if (this.sp == 17) {
            this.sptyp = 1;
            this.spart = 4;
        }
        if (this.sp == 21) {
            this.sptyp = 1;
            this.spart = 5;
        }
        if (this.sp == 20) {
            this.sptyp = 1;
            this.spart = 6;
        }
        if (this.sp == 39) {
            this.sptyp = 1;
            this.spart = 7;
        }
        if (this.sp == 42) {
            this.sptyp = 1;
            this.spart = 8;
        }
        if (this.sp == 40) {
            this.sptyp = 1;
            this.spart = 9;
        }
        if (this.sp == 23) {
            this.sptyp = 1;
            this.spart = 10;
        }
        if (this.sp == 25) {
            this.sptyp = 1;
            this.spart = 11;
        }
        if (this.sp == 24) {
            this.sptyp = 1;
            this.spart = 12;
        }
        if (this.sp == 43) {
            this.sptyp = 1;
            this.spart = 13;
        }
        if (this.sp == 45) {
            this.sptyp = 1;
            this.spart = 14;
        }
        if (this.sp == 26) {
            this.sptyp = 1;
            this.spart = 15;
        }
        if (this.sp == 27) {
            this.sptyp = 2;
            this.spart = 0;
        }
        if (this.sp == 28) {
            this.sptyp = 2;
            this.spart = 1;
        }
        if (this.sp == 41) {
            this.sptyp = 2;
            this.spart = 2;
        }
        if (this.sp == 44) {
            this.sptyp = 2;
            this.spart = 3;
        }
        if (this.sp == 52) {
            this.sptyp = 2;
            this.spart = 4;
        }
        if (this.sp == 53) {
            this.sptyp = 2;
            this.spart = 5;
        }
        if (this.sp == 30 || this.sp == 32 || this.sp == 54) {
            this.sptyp = 3;
            this.spart = 0;
        }
        if (this.sp == 31) {
            this.sptyp = 4;
            this.spart = 0;
        }
        if (this.sp == 55) {
            this.sptyp = 5;
            this.spart = 0;
        }
        if (this.sp == 56) {
            this.sptyp = 5;
            this.spart = 1;
        }
        if (this.sp == 57) {
            this.sptyp = 5;
            this.spart = 2;
        }
        if (this.sp == 58) {
            this.sptyp = 5;
            this.spart = 3;
        }
        if (this.sp == 59) {
            this.sptyp = 5;
            this.spart = 4;
        }
        if (this.sp == 60) {
            this.sptyp = 5;
            this.spart = 5;
        }
        if (this.sp == 61) {
            this.sptyp = 5;
            this.spart = 6;
        }
        if (this.sp == 62) {
            this.sptyp = 5;
            this.spart = 7;
        }
        if (this.sp == 63) {
            this.sptyp = 5;
            this.spart = 8;
        }
        if (this.sp == 64) {
            this.sptyp = 5;
            this.spart = 9;
        }
        if (this.sp == 65) {
            this.sptyp = 5;
            this.spart = 10;
        }
        if (this.sp == 66) {
            if (bool)
                this.fgen = (this.co[this.esp]).srz;
            else
                this.fgen = 0;
            this.pwd = (float) (this.co[this.esp]).srx;
            this.phd = (float) (this.co[this.esp]).sry;
            this.pgen = false;
            this.sptyp = 6;
        }
        if (this.sptyp == 0) {
            partroads();
            this.part.show();
        }
        if (this.sptyp == 1) {
            partramps();
            this.part.show();
        }
        if (this.sptyp == 2) {
            partobst();
            this.part.show();
        }
        if (this.sptyp == 5) {
            partrees();
            this.part.show();
        }
        this.ptyp.select(this.sptyp);
        this.part.select(this.spart);
    }
    
    public void partrees() {
        this.part.removeAll();
        this.part.add(this.rd, "Tree 1");
        this.part.add(this.rd, "Tree 2");
        this.part.add(this.rd, "Tree 3");
        this.part.add(this.rd, "Tree 4");
        this.part.add(this.rd, "Tree 5");
        this.part.add(this.rd, "Palm Tree 1");
        this.part.add(this.rd, "Palm Tree 2");
        this.part.add(this.rd, "Palm Tree 3");
        this.part.add(this.rd, "Cactus 1");
        this.part.add(this.rd, "Cactus 2");
        this.part.add(this.rd, "Cactus 3");
    }
    
    public void partroads() {
        this.part.removeAll();
        this.part.add(this.rd, "NormalRoad");
        this.part.add(this.rd, "NormalRoad Turn");
        this.part.add(this.rd, "NormalRoad End");
        this.part.add(this.rd, "NormalRoad TwistedLeft");
        this.part.add(this.rd, "NormalRoad TwistedRight");
        this.part.add(this.rd, "NormalRoad Edged");
        this.part.add(this.rd, "NormalRoad-Raised Ramp");
        this.part.add(this.rd, "NormalRoad Raised");
        this.part.add(this.rd, "Normal-Off-Road Blend");
        this.part.add(this.rd, "OffRoad");
        this.part.add(this.rd, "OffRoad Turn");
        this.part.add(this.rd, "OffRoad End");
        this.part.add(this.rd, "OffRoad BumpyGreen");
        this.part.add(this.rd, "OffRoad-BumpySides Start");
        this.part.add(this.rd, "OffRoad BumpySides");
        this.part.add(this.rd, "Off-Halfpipe-Road Blend");
        this.part.add(this.rd, "HalfpipeRoad");
        this.part.add(this.rd, "HalfpipeRoad Turn");
        this.part.add(this.rd, "HalfpipeRoad-Ramp Filler");
        this.part.add(this.rd, "Halfpipe-Normal-Road Blend");
        this.part.add(this.rd, "Rollercoaster Start/End");
        this.part.add(this.rd, "Rollercoaster Road1");
        this.part.add(this.rd, "Rollercoaster Road2");
        this.part.add(this.rd, "Rollercoaster Road3");
        this.part.add(this.rd, "Rollercoaster Road4");
        this.part.add(this.rd, "Rollercoaster Road5");
    }
    
    public void partramps() {
        this.part.removeAll();
        this.part.add(this.rd, "Basic Ramp");
        this.part.add(this.rd, "Two-Way Ramp");
        this.part.add(this.rd, "Two-Way High-Low Ramp");
        this.part.add(this.rd, "Small Ramp");
        this.part.add(this.rd, "Crash Ramp");
        this.part.add(this.rd, "Big-Takeoff Ramp");
        this.part.add(this.rd, "Landing Ramp");
        this.part.add(this.rd, "Tunnel Side Ramp");
        this.part.add(this.rd, "Speed Ramp");
        this.part.add(this.rd, "Launch Pad Ramp");
        this.part.add(this.rd, "Offroad Bump Ramp");
        this.part.add(this.rd, "Offroad Ramp");
        this.part.add(this.rd, "Offroad Big Ramp");
        this.part.add(this.rd, "Offroad Hill Ramp");
        this.part.add(this.rd, "Offroad Big Hill Ramp");
        this.part.add(this.rd, "Halfpipe");
    }
    
    public void partobst() {
        this.part.removeAll();
        this.part.add(this.rd, "Spiky Pillars");
        this.part.add(this.rd, "Rail Doorway");
        this.part.add(this.rd, "The Net");
        this.part.add(this.rd, "Bump Slide");
        this.part.add(this.rd, "Offroad Dirt-Pile 1");
        this.part.add(this.rd, "Offroad Dirt-Pile 2");
    }
    
    public void init() {
        setBackground(new Color(0, 0, 0));
        this.offImage = createImage(800, 550);
        if (this.offImage != null)
            this.rd = (Graphics2D) this.offImage.getGraphics();
        this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        setLayout(null);
        this.slstage.setFont(new Font("Arial", 1, 13));
        this.slstage.add(this.rd, "Select a Stage...         ");
        this.slstage.setForeground(new Color(63, 80, 110));
        this.slstage.setBackground(new Color(209, 217, 230));
        this.srch.setFont(new Font("Arial", 1, 12));
        this.srch.setBackground(new Color(255, 255, 255));
        this.srch.setForeground(new Color(0, 0, 0));
        this.strtyp.setFont(new Font("Arial", 1, 12));
        this.strtyp.add(this.rd, "NormalRoad");
        this.strtyp.add(this.rd, "OffRoad");
        this.strtyp.setBackground(new Color(63, 80, 110));
        this.strtyp.setForeground(new Color(209, 217, 230));
        this.ptyp.setFont(new Font("Arial", 1, 12));
        this.ptyp.add(this.rd, "Roads");
        this.ptyp.add(this.rd, "Ramps");
        this.ptyp.add(this.rd, "Obstacles");
        this.ptyp.add(this.rd, "Checkpoint");
        this.ptyp.add(this.rd, "Fixing Hoop");
        this.ptyp.add(this.rd, "Trees");
        this.ptyp.add(this.rd, "Ground Pile");
        this.ptyp.setBackground(new Color(63, 80, 110));
        this.ptyp.setForeground(new Color(209, 217, 230));
        this.part.setFont(new Font("Arial", 1, 12));
        this.part.add(this.rd, "Halfpipe-Normal-Road Blend");
        this.part.setBackground(new Color(63, 80, 110));
        this.part.setForeground(new Color(209, 217, 230));
        this.fixh.setFont(new Font("Arial", 1, 12));
        this.fixh.setBackground(new Color(255, 255, 255));
        this.fixh.setForeground(new Color(0, 0, 0));
        this.mgen.setFont(new Font("Arial", 1, 12));
        this.mgen.setBackground(new Color(255, 255, 255));
        this.mgen.setForeground(new Color(0, 0, 0));
        this.pfog.setFont(new Font("Arial", 1, 12));
        this.pfog.setBackground(new Color(225, 225, 225));
        this.pfog.setForeground(new Color(0, 0, 0));
        this.nlaps.setFont(new Font("Arial", 1, 12));
        for (int i = 0; i < 15; i++)
            this.nlaps.add(this.rd, new StringBuilder().append(" ").append(i + 1).append(" ").toString());
        this.nlaps.setBackground(new Color(63, 80, 110));
        this.nlaps.setForeground(new Color(209, 217, 230));
        this.tracks.setFont(new Font("Arial", 1, 12));
        this.tracks.add(this.rd, "Select MOD Track");
        this.tracks.setForeground(new Color(63, 80, 110));
        this.tracks.setBackground(new Color(209, 217, 230));
        this.witho.setFont(new Font("Arial", 1, 12));
        this.witho.add(this.rd, "With other cars");
        this.witho.add(this.rd, "Alone");
        this.witho.setBackground(new Color(63, 80, 110));
        this.witho.setForeground(new Color(209, 217, 230));
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
        add(this.tnick);
        add(this.tpass);
        add(this.srch);
        add(this.fixh);
        add(this.mgen);
        add(this.pfog);
        hidefields();
    }
    
    public void hidefields() {
        this.pubtyp.hide();
        this.tpass.hide();
        this.tnick.hide();
        this.witho.hide();
        this.strtyp.hide();
        this.srch.hide();
        this.slstage.hide();
        this.tracks.hide();
        this.nlaps.hide();
        this.pfog.hide();
        this.fixh.hide();
        this.mgen.hide();
        this.ptyp.hide();
        this.part.hide();
    }
    
    public void movefield(Component component, int i, int i_169_, int i_170_, int i_171_) {
        i += this.apx;
        i_169_ += this.apy;
        if (component.getX() != i || component.getY() != i_169_ || component.getWidth() != i_170_ || component.getHeight() != i_171_)
            component.setBounds(i, i_169_, i_170_, i_171_);
    }
    
    public void drawms() {
        boolean bool = false;
        if (this.pubtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false))
            bool = true;
        if (this.slstage.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false))
            bool = true;
        if (this.strtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false))
            bool = true;
        int i = 0;
        if (this.preop)
            i = -1000;
        if (this.part.draw(this.rd, this.xm, this.ym + i, this.mousdr && !this.preop, 550, false))
            bool = true;
        if (this.ptyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) {
            bool = true;
            this.preop = true;
        } else
            this.preop = false;
        if (this.nlaps.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            bool = true;
        if (this.tracks.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            bool = true;
        if (this.witho.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true))
            bool = true;
        if (bool)
            this.mouses = 0;
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
        this.apx = getWidth() / 2 - 400;
        this.apy = getHeight() / 2 - 275;
        graphics.drawImage(this.offImage, this.apx, this.apy, this);
    }
    
    public void update(Graphics graphics) {
        paint(graphics);
    }
    
    public boolean mouseUp(Event event, int i, int i_172_) {
        this.mousdr = false;
        this.xm = i - this.apx;
        this.ym = i_172_ - this.apy;
        if (this.mouses == 1)
            this.mouses = -1;
        if (this.onbtgame)
            Madness.game();
        return false;
    }
    
    public boolean mouseDown(Event event, int i, int i_173_) {
        this.mousdr = true;
        this.xm = i - this.apx;
        this.ym = i_173_ - this.apy;
        this.mouses = 1;
        requestFocus();
        this.focuson = true;
        return false;
    }
    
    public boolean mouseMove(Event event, int i, int i_174_) {
        this.xm = i - this.apx;
        this.ym = i_174_ - this.apy;
        if (this.xm > 620 && this.xm < 774 && this.ym > 0 && this.ym < 23) {
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
    
    public boolean mouseDrag(Event event, int i, int i_175_) {
        this.mousdr = true;
        this.xm = i - this.apx;
        this.ym = i_175_ - this.apy;
        return false;
    }
    
    public boolean keyDown(Event event, int i) {
        if (this.focuson) {
            if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87 || i == 43 || i == 61)
                this.zoomi = true;
            if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83 || i == 45)
                this.zoomo = true;
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
        if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87 || i == 43 || i == 61)
            this.zoomi = false;
        if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83 || i == 45)
            this.zoomo = false;
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
    
    public void loadbase() {
        String[] strings = { "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "tside", "launchpad", "thenet", "speedramp", "offhill", "slider", "uphill", "roll1", "roll2", "roll3", "roll4", "roll5", "roll6", "opile1", "opile2", "aircheckpoint", "tree1", "tree2", "tree3", "tree4", "tree5", "tree6", "tree7", "tree8", "cac1", "cac2", "cac3" };
        try {
            File file = new File("data/models.zip");
            ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));
            ZipEntry zipentry = zipinputstream.getNextEntry();
            Object object = null;
            for (/**/; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = -1;
                for (int i_176_ = 0; i_176_ < 66; i_176_++) {
                    if (zipentry.getName().startsWith(strings[i_176_]))
                        i = i_176_;
                }
                if (i != -1) {
                    int i_177_ = (int) zipentry.getSize();
                    byte[] is = new byte[i_177_];
                    int i_178_ = 0;
                    int i_179_;
                    for (/**/; i_177_ > 0; i_177_ -= i_179_) {
                        i_179_ = zipinputstream.read(is, i_178_, i_177_);
                        i_178_ += i_179_;
                    }
                    this.bco[i] = new ContO(is, this.m, this.t);
                    for (int i_180_ = 0; i_180_ < (this.bco[i]).npl; i_180_++)
                        (this.bco[i]).p[i_180_].loadprojf();
                    if (i == 31)
                        (this.bco[i]).elec = true;
                }
            }
            zipinputstream.close();
            this.bco[66] = new ContO((int) (10000.0 * Math.random()), (int) this.pwd, (int) this.phd, this.m, this.t, 0, 0, 0);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to load file 'data/models.zip'!\nError:\n").append(exception).toString(), "Stage Maker", 1);
        }
        System.gc();
    }
    
    public void readstage(int i) {
        this.errd = 0;
        this.trackname = "";
        (this.t).nt = 0;
        this.nob = 0;
        this.xnob = 0;
        (this.cp).n = 0;
        (this.cp).nsp = 0;
        (this.cp).fn = 0;
        (this.cp).haltall = false;
        (this.cp).wasted = 0;
        (this.cp).catchfin = 0;
        (this.m).ground = 250;
        (this.m).lightson = false;
        if (i == 0) {
            (this.m).snap[0] = 0;
            (this.m).snap[1] = 0;
            (this.m).snap[2] = 0;
        }
        if (i == 3) {
            this.tstage = "";
            this.bstage = "";
        }
        String string = this.bstage;
        if (i == 1 || i == 2)
            string = new StringBuilder().append("").append(this.tstage).append("\r\n").append(this.bstage).append("").toString();
        int i_181_ = 0;
        int i_182_ = 100;
        int i_183_ = 0;
        int i_184_ = 100;
        boolean bool = true;
        boolean bool_185_ = true;
        String string_186_ = "";
        try {
            Object object = null;
            DataInputStream datainputstream;
            if (i == 3) {
                File file = new File(new StringBuilder().append("mystages/").append(this.stagename).append(".txt").toString());
                datainputstream = new DataInputStream(new FileInputStream(file));
                this.nundo = 0;
            } else
                datainputstream = new DataInputStream(new ByteArrayInputStream(string.getBytes()));
            String string_187_;
            while ((string_187_ = datainputstream.readLine()) != null) {
                string_186_ = new StringBuilder().append("").append(string_187_.trim()).toString();
                if (string_186_.startsWith("sky")) {
                    this.csky[0] = getint("sky", string_186_, 0);
                    this.csky[1] = getint("sky", string_186_, 1);
                    this.csky[2] = getint("sky", string_186_, 2);
                    this.m.setsky(this.csky[0], this.csky[1], this.csky[2]);
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_188_ = this;
                        (stagemaker_188_).tstage = stringbuilder.append((stagemaker_188_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("ground")) {
                    this.cgrnd[0] = getint("ground", string_186_, 0);
                    this.cgrnd[1] = getint("ground", string_186_, 1);
                    this.cgrnd[2] = getint("ground", string_186_, 2);
                    this.m.setgrnd(this.cgrnd[0], this.cgrnd[1], this.cgrnd[2]);
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_189_ = this;
                        (stagemaker_189_).tstage = stringbuilder.append((stagemaker_189_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("polys")) {
                    this.m.setpolys(getint("polys", string_186_, 0), getint("polys", string_186_, 1), getint("polys", string_186_, 2));
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_190_ = this;
                        (stagemaker_190_).tstage = stringbuilder.append((stagemaker_190_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("fog")) {
                    this.cfade[0] = getint("fog", string_186_, 0);
                    this.cfade[1] = getint("fog", string_186_, 1);
                    this.cfade[2] = getint("fog", string_186_, 2);
                    this.m.setfade(this.cfade[0], this.cfade[1], this.cfade[2]);
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_191_ = this;
                        (stagemaker_191_).tstage = stringbuilder.append((stagemaker_191_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("texture")) {
                    this.texture[0] = getint("texture", string_186_, 0);
                    this.texture[1] = getint("texture", string_186_, 1);
                    this.texture[2] = getint("texture", string_186_, 2);
                    this.texture[3] = getint("texture", string_186_, 3);
                    this.m.setexture(this.texture[0], this.texture[1], this.texture[2], this.texture[3]);
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_192_ = this;
                        (stagemaker_192_).tstage = stringbuilder.append((stagemaker_192_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("clouds")) {
                    this.cldd[0] = getint("clouds", string_186_, 0);
                    this.cldd[1] = getint("clouds", string_186_, 1);
                    this.cldd[2] = getint("clouds", string_186_, 2);
                    this.cldd[3] = getint("clouds", string_186_, 3);
                    this.cldd[4] = getint("clouds", string_186_, 4);
                    this.m.setcloads(this.cldd[0], this.cldd[1], this.cldd[2], this.cldd[3], this.cldd[4]);
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_193_ = this;
                        (stagemaker_193_).tstage = stringbuilder.append((stagemaker_193_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (i != 2 && string_186_.startsWith("snap")) {
                    this.m.setsnap(getint("snap", string_186_, 0), getint("snap", string_186_, 1), getint("snap", string_186_, 2));
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_194_ = this;
                        (stagemaker_194_).tstage = stringbuilder.append((stagemaker_194_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("density")) {
                    (this.m).fogd = (getint("density", string_186_, 0) + 1) * 2 - 1;
                    if ((this.m).fogd < 1)
                        (this.m).fogd = 1;
                    if ((this.m).fogd > 30)
                        (this.m).fogd = 30;
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_195_ = this;
                        (stagemaker_195_).tstage = stringbuilder.append((stagemaker_195_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("mountains")) {
                    (this.m).mgen = getint("mountains", string_186_, 0);
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_196_ = this;
                        (stagemaker_196_).tstage = stringbuilder.append((stagemaker_196_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("fadefrom")) {
                    this.m.fadfrom(getint("fadefrom", string_186_, 0));
                    this.origfade = (this.m).fade[0];
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_197_ = this;
                        (stagemaker_197_).tstage = stringbuilder.append((stagemaker_197_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("lightson")) {
                    (this.m).lightson = true;
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_198_ = this;
                        (stagemaker_198_).tstage = stringbuilder.append((stagemaker_198_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("nlaps")) {
                    (this.cp).nlaps = getint("nlaps", string_186_, 0);
                    if ((this.cp).nlaps < 1)
                        (this.cp).nlaps = 1;
                    if ((this.cp).nlaps > 15)
                        (this.cp).nlaps = 15;
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_199_ = this;
                        (stagemaker_199_).tstage = stringbuilder.append((stagemaker_199_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("soundtrack")) {
                    this.trackname = getstring("soundtrack", string_186_, 0);
                    this.trackvol = getint("soundtrack", string_186_, 1);
                    this.tracksize = getint("soundtrack", string_186_, 2);
                    if (i == 3) {
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_200_ = this;
                        (stagemaker_200_).tstage = stringbuilder.append((stagemaker_200_).tstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("set")) {
                    int i_201_ = getint("set", string_186_, 0);
                    if (i_201_ >= 10 && i_201_ <= 25)
                        (this.m).loadnew = true;
                    i_201_ -= 10;
                    this.co[this.nob] = new ContO(this.bco[i_201_], getint("set", string_186_, 1), (this.m).ground - (this.bco[i_201_]).grat, getint("set", string_186_, 2), getint("set", string_186_, 3));
                    (this.co[this.nob]).roofat = getint("set", string_186_, 3);
                    (this.co[this.nob]).colok = i_201_;
                    if (string_186_.indexOf(")p") != -1) {
                        (this.cp).x[(this.cp).n] = getint("chk", string_186_, 1);
                        (this.cp).z[(this.cp).n] = getint("chk", string_186_, 2);
                        (this.cp).y[(this.cp).n] = 0;
                        (this.cp).typ[(this.cp).n] = 0;
                        if (string_186_.indexOf(")pt") != -1)
                            (this.cp).typ[(this.cp).n] = -1;
                        if (string_186_.indexOf(")pr") != -1)
                            (this.cp).typ[(this.cp).n] = -2;
                        if (string_186_.indexOf(")po") != -1)
                            (this.cp).typ[(this.cp).n] = -3;
                        if (string_186_.indexOf(")ph") != -1)
                            (this.cp).typ[(this.cp).n] = -4;
                        (this.cp).n++;
                    }
                    this.xnob++;
                    this.nob++;
                    if (i == 3) {
                        if (bool_185_) {
                            StringBuilder stringbuilder = new StringBuilder();
                            StageMaker stagemaker_202_ = this;
                            (stagemaker_202_).bstage = stringbuilder.append((stagemaker_202_).bstage).append("\r\n").toString();
                            bool_185_ = false;
                        }
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_203_ = this;
                        (stagemaker_203_).bstage = stringbuilder.append((stagemaker_203_).bstage).append("").append(string_186_).append("\r\n").toString();
                    }
                    if ((this.m).loadnew)
                        (this.m).loadnew = false;
                }
                if (string_186_.startsWith("chk")) {
                    int i_204_ = getint("chk", string_186_, 0);
                    i_204_ -= 10;
                    int i_205_ = (this.m).ground - (this.bco[i_204_]).grat;
                    if (i_204_ == 54)
                        i_205_ = getint("chk", string_186_, 4);
                    this.co[this.nob] = new ContO(this.bco[i_204_], getint("chk", string_186_, 1), i_205_, getint("chk", string_186_, 2), getint("chk", string_186_, 3));
                    (this.co[this.nob]).roofat = getint("chk", string_186_, 3);
                    (this.co[this.nob]).colok = i_204_;
                    (this.cp).x[(this.cp).n] = getint("chk", string_186_, 1);
                    (this.cp).z[(this.cp).n] = getint("chk", string_186_, 2);
                    (this.cp).y[(this.cp).n] = i_205_;
                    if (getint("chk", string_186_, 3) == 0)
                        (this.cp).typ[(this.cp).n] = 1;
                    else
                        (this.cp).typ[(this.cp).n] = 2;
                    (this.cp).pcs = (this.cp).n;
                    (this.cp).n++;
                    (this.co[this.nob]).checkpoint = (this.cp).nsp + 1;
                    if (string_186_.indexOf(")r") != -1)
                        (this.co[this.nob]).wh = (this.cp).nsp + 1;
                    (this.cp).nsp++;
                    this.xnob++;
                    this.nob++;
                    if (i == 3) {
                        if (bool_185_) {
                            StringBuilder stringbuilder = new StringBuilder();
                            StageMaker stagemaker_206_ = this;
                            (stagemaker_206_).bstage = stringbuilder.append((stagemaker_206_).bstage).append("\r\n").toString();
                            bool_185_ = false;
                        }
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_207_ = this;
                        (stagemaker_207_).bstage = stringbuilder.append((stagemaker_207_).bstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("fix")) {
                    int i_208_ = getint("fix", string_186_, 0);
                    i_208_ -= 10;
                    this.co[this.nob] = new ContO(this.bco[i_208_], getint("fix", string_186_, 1), getint("fix", string_186_, 3), getint("fix", string_186_, 2), getint("fix", string_186_, 4));
                    (this.co[this.nob]).roofat = getint("fix", string_186_, 4);
                    (this.co[this.nob]).colok = i_208_;
                    (this.cp).fx[(this.cp).fn] = getint("fix", string_186_, 1);
                    (this.cp).fz[(this.cp).fn] = getint("fix", string_186_, 2);
                    (this.cp).fy[(this.cp).fn] = getint("fix", string_186_, 3);
                    (this.co[this.nob]).elec = true;
                    if (getint("fix", string_186_, 4) != 0) {
                        (this.cp).roted[(this.cp).fn] = true;
                        (this.co[this.nob]).roted = true;
                    } else
                        (this.cp).roted[(this.cp).fn] = false;
                    if (string_186_.indexOf(")s") != -1)
                        (this.cp).special[(this.cp).fn] = true;
                    else
                        (this.cp).special[(this.cp).fn] = false;
                    (this.cp).fn++;
                    this.xnob++;
                    this.nob++;
                    if (i == 3) {
                        if (bool_185_) {
                            StringBuilder stringbuilder = new StringBuilder();
                            StageMaker stagemaker_209_ = this;
                            (stagemaker_209_).bstage = stringbuilder.append((stagemaker_209_).bstage).append("\r\n").toString();
                            bool_185_ = false;
                        }
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_210_ = this;
                        (stagemaker_210_).bstage = stringbuilder.append((stagemaker_210_).bstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("pile")) {
                    this.co[this.nob] = new ContO(getint("pile", string_186_, 0), getint("pile", string_186_, 1), getint("pile", string_186_, 2), this.m, this.t, getint("pile", string_186_, 3), getint("pile", string_186_, 4), (this.m).ground);
                    (this.co[this.nob]).srz = getint("pile", string_186_, 0);
                    (this.co[this.nob]).srx = getint("pile", string_186_, 1);
                    (this.co[this.nob]).sry = getint("pile", string_186_, 2);
                    (this.co[this.nob]).colok = 66;
                    this.xnob++;
                    this.nob++;
                    if (i == 3) {
                        if (bool_185_) {
                            StringBuilder stringbuilder = new StringBuilder();
                            StageMaker stagemaker_211_ = this;
                            (stagemaker_211_).bstage = stringbuilder.append((stagemaker_211_).bstage).append("\r\n").toString();
                            bool_185_ = false;
                        }
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_212_ = this;
                        (stagemaker_212_).bstage = stringbuilder.append((stagemaker_212_).bstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("maxr")) {
                    int i_213_ = getint("maxr", string_186_, 0);
                    int i_214_ = getint("maxr", string_186_, 1);
                    i_181_ = i_214_;
                    int i_215_ = getint("maxr", string_186_, 2);
                    for (int i_216_ = 0; i_216_ < i_213_; i_216_++) {
                        this.co[this.nob] = new ContO(this.bco[29], i_214_, (this.m).ground - (this.bco[29]).grat, i_216_ * 4800 + i_215_, 0);
                        if (i == 0)
                            this.xnob++;
                        else
                            this.nob++;
                    }
                    if (i == 3) {
                        if (bool) {
                            StringBuilder stringbuilder = new StringBuilder();
                            StageMaker stagemaker_217_ = this;
                            (stagemaker_217_).bstage = stringbuilder.append((stagemaker_217_).bstage).append("\r\n").toString();
                            bool = false;
                        }
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_218_ = this;
                        (stagemaker_218_).bstage = stringbuilder.append((stagemaker_218_).bstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("maxl")) {
                    int i_219_ = getint("maxl", string_186_, 0);
                    int i_220_ = getint("maxl", string_186_, 1);
                    i_182_ = i_220_;
                    int i_221_ = getint("maxl", string_186_, 2);
                    for (int i_222_ = 0; i_222_ < i_219_; i_222_++) {
                        this.co[this.nob] = new ContO(this.bco[29], i_220_, (this.m).ground - (this.bco[29]).grat, i_222_ * 4800 + i_221_, 180);
                        if (i == 0)
                            this.xnob++;
                        else
                            this.nob++;
                    }
                    if (i == 3) {
                        if (bool) {
                            StringBuilder stringbuilder = new StringBuilder();
                            StageMaker stagemaker_223_ = this;
                            (stagemaker_223_).bstage = stringbuilder.append((stagemaker_223_).bstage).append("\r\n").toString();
                            bool = false;
                        }
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_224_ = this;
                        (stagemaker_224_).bstage = stringbuilder.append((stagemaker_224_).bstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("maxt")) {
                    int i_225_ = getint("maxt", string_186_, 0);
                    int i_226_ = getint("maxt", string_186_, 1);
                    i_183_ = i_226_;
                    int i_227_ = getint("maxt", string_186_, 2);
                    for (int i_228_ = 0; i_228_ < i_225_; i_228_++) {
                        this.co[this.nob] = new ContO(this.bco[29], i_228_ * 4800 + i_227_, (this.m).ground - (this.bco[29]).grat, i_226_, 90);
                        if (i == 0)
                            this.xnob++;
                        else
                            this.nob++;
                    }
                    if (i == 3) {
                        if (bool) {
                            StringBuilder stringbuilder = new StringBuilder();
                            StageMaker stagemaker_229_ = this;
                            (stagemaker_229_).bstage = stringbuilder.append((stagemaker_229_).bstage).append("\r\n").toString();
                            bool = false;
                        }
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_230_ = this;
                        (stagemaker_230_).bstage = stringbuilder.append((stagemaker_230_).bstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("maxb")) {
                    int i_231_ = getint("maxb", string_186_, 0);
                    int i_232_ = getint("maxb", string_186_, 1);
                    i_184_ = i_232_;
                    int i_233_ = getint("maxb", string_186_, 2);
                    for (int i_234_ = 0; i_234_ < i_231_; i_234_++) {
                        this.co[this.nob] = new ContO(this.bco[29], i_234_ * 4800 + i_233_, (this.m).ground - (this.bco[29]).grat, i_232_, -90);
                        if (i == 0)
                            this.xnob++;
                        else
                            this.nob++;
                    }
                    if (i == 3) {
                        if (bool) {
                            StringBuilder stringbuilder = new StringBuilder();
                            StageMaker stagemaker_235_ = this;
                            (stagemaker_235_).bstage = stringbuilder.append((stagemaker_235_).bstage).append("\r\n").toString();
                            bool = false;
                        }
                        StringBuilder stringbuilder = new StringBuilder();
                        StageMaker stagemaker_236_ = this;
                        (stagemaker_236_).bstage = stringbuilder.append((stagemaker_236_).bstage).append("").append(string_186_).append("\r\n").toString();
                    }
                }
            }
            datainputstream.close();
            this.m.newpolys(i_182_, i_181_ - i_182_, i_184_, i_183_ - i_184_, this.t, this.nob);
            this.m.newclouds(i_182_, i_181_, i_184_, i_183_);
            this.m.newmountains(i_182_, i_181_, i_184_, i_183_);
            this.m.newstars();
        } catch (Exception exception) {
            System.out.println(new StringBuilder().append("Error in stage ").append(this.stagename).toString());
            System.out.println(new StringBuilder().append("").append(exception).toString());
            System.out.println(new StringBuilder().append("At line: ").append(string_186_).toString());
            this.errd = 6;
            if ((this.cp).fn >= 5) //file name size????
                this.errd = 5;
            if ((this.t).nt >= 6700000) //trackers limit
                this.errd = 1;
            if ((this.cp).n >= 10000) // )p etc limit
                this.errd = 2;
            if (this.nob >= 10000) //part limit
                this.errd = 4;
        }
        if ((this.m).nrw * (this.m).ncl >= 16000)
            this.errd = 3;
        if (this.xnob >= 10000)
            this.errd = 4;
        if (i == 3 && this.bstage.indexOf("set(47,0,0,0)") == -1 && this.bstage.indexOf("set(48,0,0,0)") == -1) {
            StringBuilder stringbuilder = new StringBuilder();
            StageMaker stagemaker_237_ = this;
            (stagemaker_237_).bstage = stringbuilder.append((stagemaker_237_).bstage).append("set(47,0,0,0)\r\n").toString();
        }
    }
    
    public void newstage() {
        if (!this.srch.getText().equals("")) {
            File file = new File(new StringBuilder().append("mystages/").append(this.srch.getText()).append(".txt").toString());
            if (!file.exists()) {
                this.stagename = this.srch.getText();
                this.tstage = new StringBuilder().append("snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\r\nmountains(").append((int) (Math.random() * 100000.0)).append(")\r\nnlaps(5)\r\n\r\n").toString();
                if (this.strtyp.getSelectedIndex() == 1)
                    this.bstage = "set(48,0,0,0)\r\n";
                else
                    this.bstage = "set(47,0,0,0)\r\n";
                StringBuilder stringbuilder = new StringBuilder();
                StageMaker stagemaker_238_ = this;
                (stagemaker_238_).bstage = stringbuilder.append((stagemaker_238_).bstage).append("\r\nmaxl(3,-7200,-4800)\r\nmaxb(3,-7200,-4800)\r\nmaxr(3,7200,-4800)\r\nmaxt(3,7200,-4800)\r\n").toString();
                savefile();
                this.strtyp.hide();
                this.srch.hide();
                this.sfase = 0;
                this.tabed = -2;
            } else
                JOptionPane.showMessageDialog(null, "A stage with that name already exists, please choose another name!", "Stage Maker", 1);
        } else
            JOptionPane.showMessageDialog(null, "Please enter a stage name first!", "Stage Maker", 1);
    }
    
    public void sortop() {
        this.tstage = new StringBuilder().append("snap(").append((this.m).snap[0]).append(",").append((this.m).snap[1]).append(",").append((this.m).snap[2]).append(")\r\nsky(").append(this.csky[0]).append(",").append(this.csky[1]).append(",").append(this.csky[2]).append(")\r\nfog(").append(this.cfade[0]).append(",").append(this.cfade[1]).append(",").append(this.cfade[2]).append(")\r\nclouds(").append(this.cldd[0]).append(",").append(this.cldd[1]).append(",").append(this.cldd[2]).append(",").append(this.cldd[3]).append(",").append(this.cldd[4]).append(")\r\nground(").append(this.cgrnd[0]).append(",").append(this.cgrnd[1]).append(",").append(this.cgrnd[2]).append(")\r\ntexture(").append(this.texture[0]).append(",").append(this.texture[1]).append(",").append(this.texture[2]).append(",").append(this.texture[3]).append(")\r\nfadefrom(").append(this.origfade).append(")\r\ndensity(").append(((this.m).fogd + 1) / 2 - 1).append(")\r\nmountains(").append((this.m).mgen).append(")\r\nnlaps(").append((this.cp).nlaps).append(")\r\n").toString();
        if (!this.trackname.equals("")) {
            StringBuilder stringbuilder = new StringBuilder();
            StageMaker stagemaker_239_ = this;
            (stagemaker_239_).tstage = stringbuilder.append((stagemaker_239_).tstage).append("soundtrack(").append(this.trackname).append(",").append(this.trackvol).append(",").append(this.tracksize).append(")\r\n").toString();
        }
        for (int i = 0; i < 3; i++)
            this.snap[i] = (int) ((float) (this.m).snap[i] / 1.2F + 50.0F);
        if (this.snap[0] + this.snap[1] + this.snap[2] <= 110) {
            StringBuilder stringbuilder = new StringBuilder();
            StageMaker stagemaker_240_ = this;
            (stagemaker_240_).tstage = stringbuilder.append((stagemaker_240_).tstage).append("lightson()\r\n").toString();
        }
        StringBuilder stringbuilder = new StringBuilder();
        StageMaker stagemaker_241_ = this;
        (stagemaker_241_).tstage = stringbuilder.append((stagemaker_241_).tstage).append("\r\n").toString();
    }
    
    public void sortstage() {
        int[] is = new int[this.nob * 2];
        int[] is_242_ = new int[this.nob * 2];
        for (int i = 0; i < this.nob; i++)
            is[i] = 0;
        int i = 0;
        int i_243_ = 0;
        is_242_[i_243_] = 0;
        i_243_++;
        boolean bool = false;
        int i_244_ = 0;
        while (!bool) {
            int[] is_245_ = { (this.co[i]).x + this.atp[(this.co[i]).colok][0], (this.co[i]).x + this.atp[(this.co[i]).colok][2] };
            int[] is_246_ = { (this.co[i]).z + this.atp[(this.co[i]).colok][1], (this.co[i]).z + this.atp[(this.co[i]).colok][3] };
            int i_247_ = (this.co[i]).roofat;
            if ((this.co[i]).colok == 2)
                i_247_ += 30;
            if ((this.co[i]).colok == 3)
                i_247_ -= 30;
            if ((this.co[i]).colok == 15)
                i_247_ -= 90;
            if ((this.co[i]).colok == 20)
                i_247_ -= 180;
            if ((this.co[i]).colok == 26)
                i_247_ -= 90;
            rot(is_245_, is_246_, (this.co[i]).x, (this.co[i]).z, i_247_, 2);
            int i_248_ = -1;
            int i_249_ = -1;
            if (i_244_ != 0) {
                for (int i_250_ = 0; i_250_ < this.nob; i_250_++) {
                    boolean bool_251_ = false;
                    if (i_243_ == 2 && i_250_ == 0)
                        bool_251_ = true;
                    if (i != i_250_ && !bool_251_ && is[i_250_] == 0 && ((this.co[i_250_]).colok <= 14 || (this.co[i_250_]).colok >= 33) && ((this.co[i_250_]).colok < 39 || (this.co[i_250_]).colok >= 46) && (this.co[i_250_]).colok < 52) {
                        int i_252_ = 0;
                        if ((this.co[i_250_]).colok != 2 && (this.co[i_250_]).colok != 3 && (this.co[i_250_]).colok != 4 && (this.co[i_250_]).colok != 7 && (this.co[i_250_]).colok != 9) {
                            if (i_244_ == 1 && (this.co[i_250_]).z > (this.co[i]).z && Math.abs((this.co[i_250_]).x - (this.co[i]).x) < 1000 && ((this.co[i_250_]).roofat == 180 || (this.co[i_250_]).roofat == 0))
                                i_252_ = 1;
                            if (i_244_ == 2 && (this.co[i_250_]).z < (this.co[i]).z && Math.abs((this.co[i_250_]).x - (this.co[i]).x) < 1000 && ((this.co[i_250_]).roofat == 180 || (this.co[i_250_]).roofat == 0))
                                i_252_ = 1;
                            if (i_244_ == 3 && (this.co[i_250_]).x > (this.co[i]).x && Math.abs((this.co[i_250_]).z - (this.co[i]).z) < 1000 && ((this.co[i_250_]).roofat == 90 || (this.co[i_250_]).roofat == -90))
                                i_252_ = 1;
                            if (i_244_ == 4 && (this.co[i_250_]).x < (this.co[i]).x && Math.abs((this.co[i_250_]).z - (this.co[i]).z) < 1000 && ((this.co[i_250_]).roofat == 90 || (this.co[i_250_]).roofat == -90))
                                i_252_ = 1;
                        } else
                            i_252_ = 2;
                        if (i_252_ != 0) {
                            int[] is_253_ = { (this.co[i_250_]).x + this.atp[(this.co[i_250_]).colok][0], (this.co[i_250_]).x + this.atp[(this.co[i_250_]).colok][2] };
                            int[] is_254_ = { (this.co[i_250_]).z + this.atp[(this.co[i_250_]).colok][1], (this.co[i_250_]).z + this.atp[(this.co[i_250_]).colok][3] };
                            i_247_ = (this.co[i_250_]).roofat;
                            if ((this.co[i_250_]).colok == 2)
                                i_247_ += 30;
                            if ((this.co[i_250_]).colok == 3)
                                i_247_ -= 30;
                            if ((this.co[i_250_]).colok == 15)
                                i_247_ -= 90;
                            if ((this.co[i_250_]).colok == 20)
                                i_247_ -= 180;
                            if ((this.co[i_250_]).colok == 26)
                                i_247_ -= 90;
                            rot(is_253_, is_254_, (this.co[i_250_]).x, (this.co[i_250_]).z, i_247_, 2);
                            boolean bool_255_ = false;
                            if (i_250_ != 0) {
                                int i_256_ = pyn(is_253_[0], is_245_[0], is_254_[0], is_246_[0]);
                                if (i_256_ >= 0 && (i_256_ < 100 || i_252_ != 2) && (i_256_ < i_248_ || i_248_ == -1)) {
                                    i_248_ = i_256_;
                                    i_249_ = i_250_;
                                }
                            }
                            int i_257_ = pyn(is_253_[1], is_245_[0], is_254_[1], is_246_[0]);
                            if (i_257_ >= 0 && (i_257_ < 100 || i_252_ != 2) && (i_257_ < i_248_ || i_248_ == -1)) {
                                i_248_ = i_257_;
                                i_249_ = i_250_;
                            }
                            if (i != 0) {
                                if (i_250_ != 0) {
                                    i_257_ = pyn(is_253_[0], is_245_[1], is_254_[0], is_246_[1]);
                                    if (i_257_ >= 0 && (i_257_ < 100 || i_252_ != 2) && i_257_ < i_248_) {
                                        i_248_ = i_257_;
                                        i_249_ = i_250_;
                                    }
                                }
                                i_257_ = pyn(is_253_[1], is_245_[1], is_254_[1], is_246_[1]);
                                if (i_257_ >= 0 && (i_257_ < 100 || i_252_ != 2) && i_257_ < i_248_) {
                                    i_248_ = i_257_;
                                    i_249_ = i_250_;
                                }
                            }
                        }
                    }
                }
            }
            if (i_249_ == -1) {
                for (int i_258_ = 0; i_258_ < this.nob; i_258_++) {
                    boolean bool_259_ = false;
                    if (i_243_ == 2 && i_258_ == 0)
                        bool_259_ = true;
                    if (i != i_258_ && !bool_259_ && is[i_258_] == 0 && ((this.co[i_258_]).colok <= 14 || (this.co[i_258_]).colok >= 33) && ((this.co[i_258_]).colok < 39 || (this.co[i_258_]).colok >= 46) && (this.co[i_258_]).colok < 52) {
                        int[] is_260_ = { (this.co[i_258_]).x + this.atp[(this.co[i_258_]).colok][0], (this.co[i_258_]).x + this.atp[(this.co[i_258_]).colok][2] };
                        int[] is_261_ = { (this.co[i_258_]).z + this.atp[(this.co[i_258_]).colok][1], (this.co[i_258_]).z + this.atp[(this.co[i_258_]).colok][3] };
                        i_247_ = (this.co[i_258_]).roofat;
                        if ((this.co[i_258_]).colok == 2)
                            i_247_ += 30;
                        if ((this.co[i_258_]).colok == 3)
                            i_247_ -= 30;
                        if ((this.co[i_258_]).colok == 15)
                            i_247_ -= 90;
                        if ((this.co[i_258_]).colok == 20)
                            i_247_ -= 180;
                        if ((this.co[i_258_]).colok == 26)
                            i_247_ -= 90;
                        rot(is_260_, is_261_, (this.co[i_258_]).x, (this.co[i_258_]).z, i_247_, 2);
                        boolean bool_262_ = false;
                        if (i_258_ != 0) {
                            int i_263_ = pyn(is_260_[0], is_245_[0], is_261_[0], is_246_[0]);
                            if (i_263_ >= 0 && (i_263_ < i_248_ || i_248_ == -1)) {
                                i_248_ = i_263_;
                                i_249_ = i_258_;
                            }
                        }
                        int i_264_ = pyn(is_260_[1], is_245_[0], is_261_[1], is_246_[0]);
                        if (i_264_ >= 0 && (i_264_ < i_248_ || i_248_ == -1)) {
                            i_248_ = i_264_;
                            i_249_ = i_258_;
                        }
                        if (i != 0) {
                            if (i_258_ != 0) {
                                i_264_ = pyn(is_260_[0], is_245_[1], is_261_[0], is_246_[1]);
                                if (i_264_ >= 0 && i_264_ < i_248_) {
                                    i_248_ = i_264_;
                                    i_249_ = i_258_;
                                }
                            }
                            i_264_ = pyn(is_260_[1], is_245_[1], is_261_[1], is_246_[1]);
                            if (i_264_ >= 0 && i_264_ < i_248_) {
                                i_248_ = i_264_;
                                i_249_ = i_258_;
                            }
                        }
                    }
                }
            }
            if (i_249_ != -1) {
                i_244_ = 0;
                if ((this.co[i_249_]).colok != 2 && (this.co[i_249_]).colok != 3 && (this.co[i_249_]).colok != 4 && (this.co[i_249_]).colok != 7 && (this.co[i_249_]).colok != 9) {
                    if (((this.co[i_249_]).roofat == 180 || (this.co[i_249_]).roofat == 0) && (this.co[i_249_]).z > (this.co[i]).z)
                        i_244_ = 1;
                    if (((this.co[i_249_]).roofat == 180 || (this.co[i_249_]).roofat == 0) && (this.co[i_249_]).z < (this.co[i]).z)
                        i_244_ = 2;
                    if (((this.co[i_249_]).roofat == 90 || (this.co[i_249_]).roofat == -90) && (this.co[i_249_]).x > (this.co[i]).x)
                        i_244_ = 3;
                    if (((this.co[i_249_]).roofat == 90 || (this.co[i_249_]).roofat == -90) && (this.co[i_249_]).x < (this.co[i]).x)
                        i_244_ = 4;
                }
                if ((this.co[i_249_]).colok == 4 || (this.co[i_249_]).colok == 7 || (this.co[i_249_]).colok == 9)
                    is[i_249_] = 2;
                else
                    is[i_249_] = 1;
                if ((this.co[i_249_]).colok >= 46 && (this.co[i_249_]).colok <= 51)
                    is[i_249_] = 6;
                i = i_249_;
                if (i_249_ == 0) {
                    is[0] = 1;
                    bool = true;
                } else {
                    is_242_[i_243_] = i_249_;
                    i_243_++;
                }
            } else {
                is[0] = 1;
                bool = true;
            }
        }
        for (int i_265_ = 0; i_265_ < this.nob; i_265_++) {
            if (is[i_265_] == 0 && ((this.co[i_265_]).colok <= 14 || (this.co[i_265_]).colok >= 33) && ((this.co[i_265_]).colok < 39 || (this.co[i_265_]).colok >= 46) && (this.co[i_265_]).colok < 52) {
                is_242_[i_243_] = i_265_;
                i_243_++;
            }
        }
        for (int i_266_ = 0; i_266_ < i_243_; i_266_++) {
            if ((this.co[is_242_[i_266_]]).colok >= 46 && (this.co[is_242_[i_266_]]).colok <= 51) {
                for (int i_267_ = i_266_ + 1; i_267_ < i_243_; i_267_++) {
                    int i_268_ = pyn((this.co[is_242_[i_266_]]).x, (this.co[is_242_[i_267_]]).x, (this.co[is_242_[i_266_]]).z, (this.co[is_242_[i_267_]]).z);
                    if (i_268_ >= 0 && ((this.co[is_242_[i_267_]]).colok < 46 || (this.co[is_242_[i_266_]]).colok > 51) && i_268_ < ((this.co[is_242_[i_266_]]).maxR + (this.co[is_242_[i_267_]]).maxR) / 100 * (((this.co[is_242_[i_266_]]).maxR + (this.co[is_242_[i_267_]]).maxR) / 100)) {
                        int i_269_ = is_242_[i_267_];
                        for (int i_270_ = i_267_; i_270_ > i_266_; i_270_--)
                            is_242_[i_270_] = is_242_[i_270_ - 1];
                        is_242_[i_266_] = i_269_;
                        is[is_242_[i_266_]] = 0;
                        i_266_++;
                    }
                }
            }
        }
        int i_271_ = 1;
        for (int i_272_ = 0; i_272_ < (this.cp).nsp; i_272_++) {
            for (int i_273_ = 0; i_273_ < this.nob; i_273_++) {
                if ((this.co[i_273_]).wh == i_272_ + 1 && ((this.co[i_273_]).colok == 30 || (this.co[i_273_]).colok == 32 || (this.co[i_273_]).colok == 54)) {
                    int i_274_ = -1;
                    int i_275_ = -1;
                    for (int i_276_ = i_271_; i_276_ < i_243_; i_276_++) {
                        if ((this.co[is_242_[i_276_]]).colok != 30 && (this.co[is_242_[i_276_]]).colok != 32 && (this.co[is_242_[i_276_]]).colok != 54) {
                            int i_277_ = pyn((this.co[i_273_]).x, (this.co[is_242_[i_276_]]).x, (this.co[i_273_]).z, (this.co[is_242_[i_276_]]).z);
                            if (i_277_ >= 0 && (i_277_ < i_274_ || i_274_ == -1)) {
                                i_274_ = i_277_;
                                i_275_ = i_276_;
                            }
                        }
                    }
                    if (i_275_ != -1) {
                        is[is_242_[i_275_]] = 0;
                        for (int i_278_ = i_243_; i_278_ > i_275_; i_278_--)
                            is_242_[i_278_] = is_242_[i_278_ - 1];
                        is_242_[i_275_ + 1] = i_273_;
                        i_271_ = i_275_ + 1;
                        i_243_++;
                    } else {
                        is_242_[i_243_] = i_273_;
                        i_271_ = i_243_;
                        i_243_++;
                    }
                }
            }
        }
        for (int i_279_ = 0; i_279_ < this.nob; i_279_++) {
            if ((this.co[i_279_]).wh == 0 && ((this.co[i_279_]).colok == 30 || (this.co[i_279_]).colok == 32 || (this.co[i_279_]).colok == 54)) {
                int i_280_ = -1;
                int i_281_ = -1;
                for (int i_282_ = i_271_; i_282_ < i_243_; i_282_++) {
                    if ((this.co[is_242_[i_282_]]).colok != 30 && (this.co[is_242_[i_282_]]).colok != 32 && (this.co[is_242_[i_282_]]).colok != 54) {
                        int i_283_ = pyn((this.co[i_279_]).x, (this.co[is_242_[i_282_]]).x, (this.co[i_279_]).z, (this.co[is_242_[i_282_]]).z);
                        if (i_283_ >= 0 && (i_283_ < i_280_ || i_280_ == -1)) {
                            i_280_ = i_283_;
                            i_281_ = i_282_;
                        }
                    }
                }
                if (i_281_ != -1) {
                    is[is_242_[i_281_]] = 0;
                    for (int i_284_ = i_243_; i_284_ > i_281_; i_284_--)
                        is_242_[i_284_] = is_242_[i_284_ - 1];
                    is_242_[i_281_ + 1] = i_279_;
                    i_243_++;
                } else {
                    is_242_[i_243_] = i_279_;
                    i_243_++;
                }
            }
        }
        for (int i_285_ = 0; i_285_ < this.nob; i_285_++) {
            if ((this.co[i_285_]).colok == 31) {
                int i_286_ = -1;
                int i_287_ = -1;
                for (int i_288_ = 0; i_288_ < i_243_; i_288_++) {
                    int i_289_ = pyn((this.co[i_285_]).x, (this.co[is_242_[i_288_]]).x, (this.co[i_285_]).z, (this.co[is_242_[i_288_]]).z);
                    if (i_289_ >= 0 && (i_289_ < i_286_ || i_286_ == -1)) {
                        i_286_ = i_289_;
                        i_287_ = i_288_;
                    }
                }
                if (i_287_ != -1) {
                    for (int i_290_ = i_243_; i_290_ > i_287_; i_290_--)
                        is_242_[i_290_] = is_242_[i_290_ - 1];
                    is_242_[i_287_] = i_285_;
                    i_243_++;
                } else {
                    is_242_[i_243_] = i_285_;
                    i_243_++;
                }
            }
        }
        for (int i_291_ = 0; i_291_ < this.nob; i_291_++) {
            if ((this.co[i_291_]).colok == 15 || (this.co[i_291_]).colok == 27 || (this.co[i_291_]).colok == 28 || (this.co[i_291_]).colok == 41 || (this.co[i_291_]).colok == 44 || (this.co[i_291_]).colok == 52 || (this.co[i_291_]).colok == 53) {
                int i_292_ = -1;
                for (int i_293_ = 0; i_293_ < i_243_; i_293_++) {
                    if (((this.co[is_242_[i_293_]]).colok <= 14 || (this.co[is_242_[i_293_]]).colok >= 33) && (this.co[is_242_[i_293_]]).colok < 39) {
                        int i_294_ = pyn((this.co[i_291_]).x, (this.co[is_242_[i_293_]]).x, (this.co[i_291_]).z, (this.co[is_242_[i_293_]]).z);
                        if (i_294_ >= 0 && i_294_ < ((this.co[i_291_]).maxR + (this.co[is_242_[i_293_]]).maxR) / 100 * (((this.co[i_291_]).maxR + (this.co[is_242_[i_293_]]).maxR) / 100))
                            i_292_ = i_293_;
                    }
                }
                if (i_292_ != -1) {
                    for (int i_295_ = i_243_; i_295_ > i_292_; i_295_--)
                        is_242_[i_295_] = is_242_[i_295_ - 1];
                    is_242_[i_292_ + 1] = i_291_;
                    i_243_++;
                } else {
                    is_242_[i_243_] = i_291_;
                    i_243_++;
                }
            }
        }
        for (int i_296_ = 0; i_296_ < this.nob; i_296_++) {
            if ((this.co[i_296_]).colok >= 16 && (this.co[i_296_]).colok <= 25 || (this.co[i_296_]).colok == 40 || (this.co[i_296_]).colok == 42 || (this.co[i_296_]).colok == 43 || (this.co[i_296_]).colok == 45) {
                int i_297_ = -1;
                for (int i_298_ = 0; i_298_ < i_243_; i_298_++) {
                    if (((this.co[is_242_[i_298_]]).colok <= 14 || (this.co[is_242_[i_298_]]).colok >= 33) && (this.co[is_242_[i_298_]]).colok < 39) {
                        int i_299_ = pyn((this.co[i_296_]).x, (this.co[is_242_[i_298_]]).x, (this.co[i_296_]).z, (this.co[is_242_[i_298_]]).z);
                        if (i_299_ >= 0 && i_299_ < ((this.co[i_296_]).maxR + (this.co[is_242_[i_298_]]).maxR) / 100 * (((this.co[i_296_]).maxR + (this.co[is_242_[i_298_]]).maxR) / 100)) {
                            if (is[is_242_[i_298_]] != 0) {
                                is[is_242_[i_298_]] = 0;
                                if ((this.co[i_296_]).colok != 20)
                                    is[i_296_] = 3;
                                else
                                    is[i_296_] = 5;
                            }
                            i_297_ = i_298_;
                        }
                    }
                }
                if (i_297_ != -1) {
                    /* empty */
                }
                if (i_297_ != -1) {
                    for (int i_300_ = i_243_; i_300_ > i_297_; i_300_--)
                        is_242_[i_300_] = is_242_[i_300_ - 1];
                    is_242_[i_297_ + 1] = i_296_;
                    i_243_++;
                } else {
                    is_242_[i_243_] = i_296_;
                    i_243_++;
                }
            }
        }
        for (int i_301_ = 0; i_301_ < this.nob; i_301_++) {
            if ((this.co[i_301_]).colok == 26 || (this.co[i_301_]).colok == 39) {
                boolean bool_302_ = false;
                if (Math.random() > Math.random()) {
                    bool_302_ = true;
                    if ((this.co[i_301_]).colok == 39) {
                        if (Math.random() > Math.random())
                            bool_302_ = false;
                        else if (Math.random() > Math.random())
                            bool_302_ = false;
                    }
                }
                int i_303_ = -1;
                for (int i_304_ = 0; i_304_ < i_243_; i_304_++) {
                    if (((this.co[is_242_[i_304_]]).colok <= 14 || (this.co[is_242_[i_304_]]).colok >= 33) && (this.co[is_242_[i_304_]]).colok < 39) {
                        int i_305_ = pyn((this.co[i_301_]).x, (this.co[is_242_[i_304_]]).x, (this.co[i_301_]).z, (this.co[is_242_[i_304_]]).z);
                        if (i_305_ >= 0 && i_305_ < ((this.co[i_301_]).maxR + (this.co[is_242_[i_304_]]).maxR) / 100 * (((this.co[i_301_]).maxR + (this.co[is_242_[i_304_]]).maxR) / 100)) {
                            boolean bool_306_ = false;
                            if ((this.co[i_301_]).colok == 26) {
                                if ((this.co[i_301_]).roofat == 90 && (this.co[is_242_[i_304_]]).x > (this.co[i_301_]).x)
                                    bool_306_ = true;
                                if ((this.co[i_301_]).roofat == -90 && (this.co[is_242_[i_304_]]).x < (this.co[i_301_]).x)
                                    bool_306_ = true;
                                if ((this.co[i_301_]).roofat == 0 && (this.co[is_242_[i_304_]]).z < (this.co[i_301_]).z)
                                    bool_306_ = true;
                                if ((this.co[i_301_]).roofat == 180 && (this.co[is_242_[i_304_]]).z > (this.co[i_301_]).z)
                                    bool_306_ = true;
                            }
                            if ((this.co[i_301_]).colok == 39) {
                                if ((this.co[i_301_]).roofat == 90 && (this.co[is_242_[i_304_]]).z > (this.co[i_301_]).z)
                                    bool_306_ = true;
                                if ((this.co[i_301_]).roofat == -90 && (this.co[is_242_[i_304_]]).z < (this.co[i_301_]).z)
                                    bool_306_ = true;
                                if ((this.co[i_301_]).roofat == 0 && (this.co[is_242_[i_304_]]).x > (this.co[i_301_]).x)
                                    bool_306_ = true;
                                if ((this.co[i_301_]).roofat == 180 && (this.co[is_242_[i_304_]]).x < (this.co[i_301_]).x)
                                    bool_306_ = true;
                            }
                            if (bool_306_) {
                                if (is[is_242_[i_304_]] == 1 && bool_302_) {
                                    is[is_242_[i_304_]] = 0;
                                    is[i_301_] = 4;
                                }
                                i_303_ = i_304_;
                            }
                        }
                    }
                }
                if (i_303_ != -1) {
                    for (int i_307_ = i_243_; i_307_ > i_303_; i_307_--)
                        is_242_[i_307_] = is_242_[i_307_ - 1];
                    is_242_[i_303_ + 1] = i_301_;
                    i_243_++;
                } else {
                    is_242_[i_243_] = i_301_;
                    i_243_++;
                }
            }
        }
        for (int i_308_ = 0; i_308_ < this.nob; i_308_++) {
            if ((this.co[i_308_]).colok >= 55 && (this.co[i_308_]).colok <= 65 || (this.co[i_308_]).colok == 66) {
                is_242_[i_243_] = i_308_;
                i_243_++;
            }
        }
        int i_309_ = 0;
        int i_310_ = 0;
        int i_311_ = 0;
        int i_312_ = 0;
        this.bstage = "";
        for (int i_313_ = 0; i_313_ < i_243_; i_313_++) {
            if ((this.co[is_242_[i_313_]]).colok != 30 && (this.co[is_242_[i_313_]]).colok != 31 && (this.co[is_242_[i_313_]]).colok != 32 && (this.co[is_242_[i_313_]]).colok != 54 && (this.co[is_242_[i_313_]]).colok != 66) {
                String string = "";
                if (is[is_242_[i_313_]] == 1)
                    string = "p";
                if (is[is_242_[i_313_]] == 2)
                    string = "pt";
                if (is[is_242_[i_313_]] == 3)
                    string = "pr";
                if (is[is_242_[i_313_]] == 4)
                    string = "ph";
                if (is[is_242_[i_313_]] == 5)
                    string = "pl";
                if (is[is_242_[i_313_]] == 6)
                    string = "pr";
                StringBuilder stringbuilder = new StringBuilder();
                StageMaker stagemaker_314_ = this;
                (stagemaker_314_).bstage = stringbuilder.append((stagemaker_314_).bstage).append("set(").append((this.co[is_242_[i_313_]]).colok + 10).append(",").append((this.co[is_242_[i_313_]]).x).append(",").append((this.co[is_242_[i_313_]]).z).append(",").append((this.co[is_242_[i_313_]]).roofat).append(")").append(string).append("\r\n").toString();
            }
            if ((this.co[is_242_[i_313_]]).colok == 30 || (this.co[is_242_[i_313_]]).colok == 32) {
                if ((this.co[is_242_[i_313_]]).roofat == 180)
                    (this.co[is_242_[i_313_]]).roofat = 0;
                String string = "";
                if ((this.co[is_242_[i_313_]]).wh != 0)
                    string = "r";
                StringBuilder stringbuilder = new StringBuilder();
                StageMaker stagemaker_315_ = this;
                (stagemaker_315_).bstage = stringbuilder.append((stagemaker_315_).bstage).append("chk(").append((this.co[is_242_[i_313_]]).colok + 10).append(",").append((this.co[is_242_[i_313_]]).x).append(",").append((this.co[is_242_[i_313_]]).z).append(",").append((this.co[is_242_[i_313_]]).roofat).append(")").append(string).append("\r\n").toString();
            }
            if ((this.co[is_242_[i_313_]]).colok == 54) {
                if ((this.co[is_242_[i_313_]]).roofat == 180)
                    (this.co[is_242_[i_313_]]).roofat = 0;
                String string = "";
                if ((this.co[is_242_[i_313_]]).wh != 0)
                    string = "r";
                StringBuilder stringbuilder = new StringBuilder();
                StageMaker stagemaker_316_ = this;
                (stagemaker_316_).bstage = stringbuilder.append((stagemaker_316_).bstage).append("chk(").append((this.co[is_242_[i_313_]]).colok + 10).append(",").append((this.co[is_242_[i_313_]]).x).append(",").append((this.co[is_242_[i_313_]]).z).append(",").append((this.co[is_242_[i_313_]]).roofat).append(",").append((this.co[is_242_[i_313_]]).y).append(")").append(string).append("\r\n").toString();
            }
            if ((this.co[is_242_[i_313_]]).colok == 31) {
                StringBuilder stringbuilder = new StringBuilder();
                StageMaker stagemaker_317_ = this;
                (stagemaker_317_).bstage = stringbuilder.append((stagemaker_317_).bstage).append("fix(").append((this.co[is_242_[i_313_]]).colok + 10).append(",").append((this.co[is_242_[i_313_]]).x).append(",").append((this.co[is_242_[i_313_]]).z).append(",").append((this.co[is_242_[i_313_]]).y).append(",").append((this.co[is_242_[i_313_]]).roofat).append(")\r\n").toString();
            }
            if ((this.co[is_242_[i_313_]]).colok == 66) {
                StringBuilder stringbuilder = new StringBuilder();
                StageMaker stagemaker_318_ = this;
                (stagemaker_318_).bstage = stringbuilder.append((stagemaker_318_).bstage).append("pile(").append((this.co[is_242_[i_313_]]).srz).append(",").append((this.co[is_242_[i_313_]]).srx).append(",").append((this.co[is_242_[i_313_]]).sry).append(",").append((this.co[is_242_[i_313_]]).x).append(",").append((this.co[is_242_[i_313_]]).z).append(")\r\n").toString();
            }
            if ((this.co[is_242_[i_313_]]).x + (this.co[is_242_[i_313_]]).maxR > i_309_)
                i_309_ = (this.co[is_242_[i_313_]]).x + (this.co[is_242_[i_313_]]).maxR;
            if ((this.co[is_242_[i_313_]]).x - (this.co[is_242_[i_313_]]).maxR < i_311_)
                i_311_ = (this.co[is_242_[i_313_]]).x - (this.co[is_242_[i_313_]]).maxR;
            if ((this.co[is_242_[i_313_]]).z + (this.co[is_242_[i_313_]]).maxR > i_310_)
                i_310_ = (this.co[is_242_[i_313_]]).z + (this.co[is_242_[i_313_]]).maxR;
            if ((this.co[is_242_[i_313_]]).z - (this.co[is_242_[i_313_]]).maxR < i_312_)
                i_312_ = (this.co[is_242_[i_313_]]).z - (this.co[is_242_[i_313_]]).maxR;
        }
        int i_319_ = i_311_ - 0;
        int i_320_ = i_309_ + 0;
        int i_321_ = (int) ((float) (i_320_ - i_319_) / 4800.0F) + 1;
        int i_322_ = (i_321_ * 4800 - (i_320_ - i_319_)) / 2;
        i_319_ -= i_322_;
        i_320_ += i_322_;
        int i_323_ = i_319_ + 2400;
        int i_324_ = i_312_ - 0;
        int i_325_ = i_310_ + 0;
        int i_326_ = (int) ((float) (i_325_ - i_324_) / 4800.0F) + 1;
        i_322_ = (i_326_ * 4800 - (i_325_ - i_324_)) / 2;
        i_324_ -= i_322_;
        i_325_ += i_322_;
        int i_327_ = i_324_ + 2400;
        StringBuilder stringbuilder = new StringBuilder();
        StageMaker stagemaker_328_ = this;
        (stagemaker_328_).bstage = stringbuilder.append((stagemaker_328_).bstage).append("\r\nmaxl(").append(i_326_).append(",").append(i_319_).append(",").append(i_327_).append(")\r\nmaxb(").append(i_321_).append(",").append(i_324_).append(",").append(i_323_).append(")\r\nmaxr(").append(i_326_).append(",").append(i_320_).append(",").append(i_327_).append(")\r\nmaxt(").append(i_321_).append(",").append(i_325_).append(",").append(i_323_).append(")\r\n").toString();
    }
    
    public void savefile() {
        try {
            File file = new File("mystages/");
            if (!file.exists())
                file.mkdirs();
            file = new File(new StringBuilder().append("mystages/").append(this.stagename).append(".txt").toString());
            BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            bufferedwriter.write(this.tstage);
            bufferedwriter.write(this.bstage);
            bufferedwriter.close();
            Object object = null;
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to save file! Error Deatials:\n").append(exception).toString(), "Stage Maker", 1);
        }
        savesettings();
    }
    
    public void renstage(String string) {
        if (string.equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter a New Stage Name!\n", "Stage Maker", 1);
        else {
            try {
                File file = new File(new StringBuilder().append("mystages/").append(this.stagename).append(".txt").toString());
                File file_329_ = new File(new StringBuilder().append("mystages/").append(string).append(".txt").toString());
                if (file.renameTo(file_329_)) {
                    this.stagename = string;
                    this.sfase = 0;
                    hidefields();
                    this.tabed = -2;
                } else
                    JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to rename stage to: '").append(string).append("', possible reason: stage name already used!\n").toString(), "Stage Maker", 1);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to rename file! Error Deatials:\n").append(exception).toString(), "Stage Maker", 1);
            }
        }
    }
    
    public void delstage(String string) {
        try {
            File file = new File(new StringBuilder().append("mystages/").append(string).append(".txt").toString());
            file.delete();
            this.slstage.remove(string);
            this.slstage.select(0);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to delete file! Error Deatials:\n").append(exception).toString(), "Stage Maker", 1);
        }
    }
    
    public void deltrack() {
        try {
            File file = new File(new StringBuilder().append("mystages/mymusic/").append(this.tracks.getSelectedItem()).append(".zip").toString());
            file.delete();
            if (this.trackname.equals(this.tracks.getSelectedItem())) {
                this.trackname = "";
                sortop();
                savefile();
            }
            this.tracks.remove(this.tracks.getSelectedItem());
            this.tracks.select(0);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, new StringBuilder().append("Unable to delete file! Error Deatials:\n").append(exception).toString(), "Stage Maker", 1);
        }
    }
    
    public void loadsettings() {
        try {
            File file = new File("mystages/settings.data");
            if (file.exists()) {
                BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
                String string = bufferedreader.readLine();
                if (string != null) {
                    this.sstage = string;
                    this.stagename = this.sstage;
                }
                string = bufferedreader.readLine();
                if (string != null) {
                    this.suser = string;
                    if (!this.suser.equals("Horaks"))
                        this.tnick.setText(this.suser);
                }
                bufferedreader.close();
                Object object = null;
            }
        } catch (Exception exception) {
            /* empty */
        }
    }
    
    public void savesettings() {
        if (!this.sstage.equals(this.stagename) || !this.suser.equals(this.tnick.getText())) {
            String string = new StringBuilder().append("").append(this.stagename).append("\n").append(this.tnick.getText()).append("\n\n").toString();
            this.sstage = this.stagename;
            this.suser = this.tnick.getText();
            try {
                File file = new File("mystages/");
                if (!file.exists())
                    file.mkdirs();
                file = new File("mystages/settings.data");
                BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(string);
                bufferedwriter.close();
                Object object = null;
            } catch (Exception exception) {
                /* empty */
            }
        }
    }
    
    public void fixtext(TextField textfield) {
        String string = textfield.getText();
        string = string.replace('\"', '#');
        String string_330_ = "\\";
        String string_331_ = "";
        int i = 0;
        int i_332_ = -1;
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        for (/**/; i < string.length(); i++) {
            String string_333_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            if (string_333_.equals("|") || string_333_.equals(",") || string_333_.equals("(") || string_333_.equals(")") || string_333_.equals("#") || string_333_.equals(string_330_) || string_333_.equals("!") || string_333_.equals("?") || string_333_.equals("~") || string_333_.equals(".") || string_333_.equals("@") || string_333_.equals("$") || string_333_.equals("%") || string_333_.equals("^") || string_333_.equals("&") || string_333_.equals("*") || string_333_.equals("+") || string_333_.equals("=") || string_333_.equals(">") || string_333_.equals("<") || string_333_.equals("/") || string_333_.equals(";") || string_333_.equals(":") || this.ftm.stringWidth(string_331_) > 274)
                i_332_ = i;
            else
                string_331_ = new StringBuilder().append(string_331_).append(string_333_).toString();
        }
        if (i_332_ != -1) {
            textfield.setText(string_331_);
            textfield.select(i_332_, i_332_);
        }
    }
    
    public void rot(int[] is, int[] is_334_, int i, int i_335_, int i_336_, int i_337_) {
        if (i_336_ != 0) {
            for (int i_338_ = 0; i_338_ < i_337_; i_338_++) {
                int i_339_ = is[i_338_];
                int i_340_ = is_334_[i_338_];
                is[i_338_] = i + (int) ((float) (i_339_ - i) * this.m.cos(i_336_) - (float) (i_340_ - i_335_) * this.m.sin(i_336_));
                is_334_[i_338_] = i_335_ + (int) ((float) (i_339_ - i) * this.m.sin(i_336_) + (float) (i_340_ - i_335_) * this.m.cos(i_336_));
            }
        }
    }
    
    public int xs(int i, int i_341_) {
        if (i_341_ < (this.m).cz)
            i_341_ = (this.m).cz;
        return (i_341_ - (this.m).focus_point) * ((this.m).cx - i) / i_341_ + i;
    }
    
    public int ys(int i, int i_342_) {
        if (i_342_ < (this.m).cz)
            i_342_ = (this.m).cz;
        return (i_342_ - (this.m).focus_point) * ((this.m).cy - i) / i_342_ + i;
    }
    
    public int py(int i, int i_343_, int i_344_, int i_345_) {
        return (int) Math.sqrt((double) ((i - i_343_) * (i - i_343_) + (i_344_ - i_345_) * (i_344_ - i_345_)));
    }
    
    public int pyn(int i, int i_346_, int i_347_, int i_348_) {
        return (i - i_346_) / 100 * ((i - i_346_) / 100) + (i_347_ - i_348_) / 100 * ((i_347_ - i_348_) / 100);
    }
    
    public String getstring(String string, String string_349_, int i) {
        int i_350_ = 0;
        String string_351_ = "";
        for (int i_352_ = string.length() + 1; i_352_ < string_349_.length(); i_352_++) {
            String string_353_ = new StringBuilder().append("").append(string_349_.charAt(i_352_)).toString();
            if (string_353_.equals(",") || string_353_.equals(")")) {
                i_350_++;
                i_352_++;
            }
            if (i_350_ == i)
                string_351_ = new StringBuilder().append(string_351_).append(string_349_.charAt(i_352_)).toString();
        }
        return string_351_;
    }
    
    public int getint(String string, String string_354_, int i) {
        int i_355_ = 0;
        String string_356_ = "";
        for (int i_357_ = string.length() + 1; i_357_ < string_354_.length(); i_357_++) {
            String string_358_ = new StringBuilder().append("").append(string_354_.charAt(i_357_)).toString();
            if (string_358_.equals(",") || string_358_.equals(")")) {
                i_355_++;
                i_357_++;
            }
            if (i_355_ == i)
                string_356_ = new StringBuilder().append(string_356_).append(string_354_.charAt(i_357_)).toString();
        }
        return Integer.valueOf(string_356_).intValue();
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
    
    public int servervalue(String string, int i) {
        int i_359_ = -1;
        try {
            int i_360_ = 0;
            int i_361_ = 0;
            int i_362_ = 0;
            String string_363_ = "";
            String string_364_ = "";
            for (/**/; i_360_ < string.length() && i_362_ != 2; i_360_++) {
                string_363_ = new StringBuilder().append("").append(string.charAt(i_360_)).toString();
                if (string_363_.equals("|")) {
                    i_361_++;
                    if (i_362_ == 1 || i_361_ > i)
                        i_362_ = 2;
                } else if (i_361_ == i) {
                    string_364_ = new StringBuilder().append(string_364_).append(string_363_).toString();
                    i_362_ = 1;
                }
            }
            if (string_364_.equals(""))
                string_364_ = "-1";
            i_359_ = Integer.valueOf(string_364_).intValue();
        } catch (Exception exception) {
            /* empty */
        }
        return i_359_;
    }
    
    public String serverSvalue(String string, int i) {
        String string_365_ = "";
        try {
            int i_366_ = 0;
            int i_367_ = 0;
            int i_368_ = 0;
            String string_369_ = "";
            String string_370_ = "";
            for (/**/; i_366_ < string.length() && i_368_ != 2; i_366_++) {
                string_369_ = new StringBuilder().append("").append(string.charAt(i_366_)).toString();
                if (string_369_.equals("|")) {
                    i_367_++;
                    if (i_368_ == 1 || i_367_ > i)
                        i_368_ = 2;
                } else if (i_367_ == i) {
                    string_370_ = new StringBuilder().append(string_370_).append(string_369_).toString();
                    i_368_ = 1;
                }
            }
            string_365_ = string_370_;
        } catch (Exception exception) {
            /* empty */
        }
        return string_365_;
    }
    
    public int getvalue(String string, String string_371_, int i) {
        int i_372_ = 0;
        String string_373_ = "";
        for (int i_374_ = string.length() + 1; i_374_ < string_371_.length(); i_374_++) {
            String string_375_ = new StringBuilder().append("").append(string_371_.charAt(i_374_)).toString();
            if (string_375_.equals(",") || string_375_.equals(")")) {
                i_372_++;
                i_374_++;
            }
            if (i_372_ == i)
                string_373_ = new StringBuilder().append(string_373_).append(string_371_.charAt(i_374_)).toString();
        }
        return Float.valueOf(string_373_).intValue();
    }
    
    public String getSvalue(String string, String string_376_, int i) {
        String string_377_ = "";
        int i_378_ = 0;
        for (int i_379_ = string.length() + 1; i_379_ < string_376_.length() && i_378_ <= i; i_379_++) {
            String string_380_ = new StringBuilder().append("").append(string_376_.charAt(i_379_)).toString();
            if (string_380_.equals(",") || string_380_.equals(")"))
                i_378_++;
            else if (i_378_ == i)
                string_377_ = new StringBuilder().append(string_377_).append(string_380_).toString();
        }
        return string_377_;
    }
    
    public boolean button(String string, int i, int i_381_, int i_382_, boolean bool) {
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        int i_383_ = this.ftm.stringWidth(string);
        boolean bool_384_ = false;
        boolean bool_385_ = false;
        if (string.equals(" Cancel ") && this.epart && Math.abs(this.xm - i) < i_383_ / 2 + 12 && Math.abs(this.ym - i_381_ + 5) < 10)
            this.overcan = true;
        if (Math.abs(this.xm - i) < i_383_ / 2 + 12 && Math.abs(this.ym - i_381_ + 5) < 10 && this.mouses == 1)
            bool_384_ = true;
        else
            bool_384_ = false;
        if (Math.abs(this.xm - i) < i_383_ / 2 + 12 && Math.abs(this.ym - i_381_ + 5) < 10 && this.mouses == -1) {
            this.mouses = 0;
            bool_385_ = true;
        }
        boolean bool_386_ = false;
        if (bool) {
            if (this.tab == 0)
                this.rd.setColor(new Color(207, 207, 207));
            if (this.tab == 1)
                this.rd.setColor(new Color(200, 200, 200));
            if (this.tab == 2)
                this.rd.setColor(new Color(170, 170, 170));
            if (this.tab != 3) {
                this.rd.drawRect(i - i_383_ / 2 - 15, i_381_ - (22 - i_382_), i_383_ + 29, 34 - i_382_ * 2);
                if (i_382_ == 2 && this.tab == 1) {
                    this.rd.setColor(new Color(220, 220, 220));
                    this.rd.fillRect(i - i_383_ / 2 - 15, i_381_ - (22 - i_382_), i_383_ + 29, 34 - i_382_ * 2);
                }
            } else
                bool_386_ = true;
        }
        if (!bool_384_) {
            this.rd.setColor(new Color(220, 220, 220));
            if (bool_386_)
                this.rd.setColor(new Color(230, 230, 230));
            this.rd.fillRect(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i_383_ + 20, 25 - i_382_ * 2);
            this.rd.setColor(new Color(240, 240, 240));
            if (bool_386_)
                this.rd.setColor(new Color(255, 255, 255));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ - (17 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (18 - i_382_), i + i_383_ / 2 + 10, i_381_ - (18 - i_382_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_383_ / 2 - 9, i_381_ - (19 - i_382_), i + i_383_ / 2 + 9, i_381_ - (19 - i_382_));
            this.rd.setColor(new Color(200, 200, 200));
            if (bool_386_)
                this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i + i_383_ / 2 + 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ + (7 - i_382_));
            this.rd.drawLine(i + i_383_ / 2 + 11, i_381_ - (17 - i_382_), i + i_383_ / 2 + 11, i_381_ + (7 - i_382_));
            this.rd.setColor(new Color(200, 200, 200));
            if (bool_386_)
                this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i + i_383_ / 2 + 12, i_381_ - (16 - i_382_), i + i_383_ / 2 + 12, i_381_ + (6 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ + (7 - i_382_), i + i_383_ / 2 + 10, i_381_ + (7 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ + (8 - i_382_), i + i_383_ / 2 + 10, i_381_ + (8 - i_382_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i - i_383_ / 2 - 9, i_381_ + (9 - i_382_), i + i_383_ / 2 + 9, i_381_ + (9 - i_382_));
            this.rd.setColor(new Color(240, 240, 240));
            if (bool_386_)
                this.rd.setColor(new Color(255, 255, 255));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i - i_383_ / 2 - 10, i_381_ + (7 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 11, i_381_ - (17 - i_382_), i - i_383_ / 2 - 11, i_381_ + (7 - i_382_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_383_ / 2 - 12, i_381_ - (16 - i_382_), i - i_383_ / 2 - 12, i_381_ + (6 - i_382_));
            this.rd.setColor(new Color(0, 0, 0));
            if (string.equals("  Keyboard Controls  "))
                this.rd.setColor(new Color(100, 100, 100));
            this.rd.drawString(string, i - i_383_ / 2, i_381_);
        } else {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i_383_ + 20, 25 - i_382_ * 2);
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ - (17 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (18 - i_382_), i + i_383_ / 2 + 10, i_381_ - (18 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 9, i_381_ - (19 - i_382_), i + i_383_ / 2 + 9, i_381_ - (19 - i_382_));
            this.rd.setColor(new Color(247, 247, 247));
            this.rd.drawLine(i + i_383_ / 2 + 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ + (7 - i_382_));
            this.rd.drawLine(i + i_383_ / 2 + 11, i_381_ - (17 - i_382_), i + i_383_ / 2 + 11, i_381_ + (7 - i_382_));
            this.rd.drawLine(i + i_383_ / 2 + 12, i_381_ - (16 - i_382_), i + i_383_ / 2 + 12, i_381_ + (6 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ + (7 - i_382_), i + i_383_ / 2 + 10, i_381_ + (7 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ + (8 - i_382_), i + i_383_ / 2 + 10, i_381_ + (8 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 9, i_381_ + (9 - i_382_), i + i_383_ / 2 + 9, i_381_ + (9 - i_382_));
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i - i_383_ / 2 - 10, i_381_ + (7 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 11, i_381_ - (17 - i_382_), i - i_383_ / 2 - 11, i_381_ + (7 - i_382_));
            this.rd.drawLine(i - i_383_ / 2 - 12, i_381_ - (16 - i_382_), i - i_383_ / 2 - 12, i_381_ + (6 - i_382_));
            this.rd.setColor(new Color(0, 0, 0));
            if (string.equals("  Keyboard Controls  "))
                this.rd.setColor(new Color(100, 100, 100));
            this.rd.drawString(string, i - i_383_ / 2 + 1, i_381_ + 1);
        }
        return bool_385_;
    }
    
    public boolean ovbutton(String string, int i, int i_387_) {
        this.rd.setFont(new Font("Arial", 0, 12));
        this.ftm = this.rd.getFontMetrics();
        if (string.equals("X") || string.equals("Download")) {
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
        }
        int i_388_ = this.ftm.stringWidth(string);
        int i_389_ = 4;
        boolean bool = false;
        boolean bool_390_ = false;
        if (Math.abs(this.xm - i) < i_388_ / 2 + 12 && Math.abs(this.ym - i_387_ + 5) < 10 && this.mouses == 1)
            bool = true;
        else
            bool = false;
        if (Math.abs(this.xm - i) < i_388_ / 2 + 12 && Math.abs(this.ym - i_387_ + 5) < 10 && this.mouses == -1) {
            this.mouses = 0;
            bool_390_ = true;
        }
        if (!bool) {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i_388_ + 20, 25 - i_389_ * 2);
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ - (17 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (18 - i_389_), i + i_388_ / 2 + 10, i_387_ - (18 - i_389_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_388_ / 2 - 9, i_387_ - (19 - i_389_), i + i_388_ / 2 + 9, i_387_ - (19 - i_389_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i + i_388_ / 2 + 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ + (7 - i_389_));
            this.rd.drawLine(i + i_388_ / 2 + 11, i_387_ - (17 - i_389_), i + i_388_ / 2 + 11, i_387_ + (7 - i_389_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i + i_388_ / 2 + 12, i_387_ - (16 - i_389_), i + i_388_ / 2 + 12, i_387_ + (6 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ + (7 - i_389_), i + i_388_ / 2 + 10, i_387_ + (7 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ + (8 - i_389_), i + i_388_ / 2 + 10, i_387_ + (8 - i_389_));
            this.rd.setColor(new Color(200, 200, 200));
            this.rd.drawLine(i - i_388_ / 2 - 9, i_387_ + (9 - i_389_), i + i_388_ / 2 + 9, i_387_ + (9 - i_389_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i - i_388_ / 2 - 10, i_387_ + (7 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 11, i_387_ - (17 - i_389_), i - i_388_ / 2 - 11, i_387_ + (7 - i_389_));
            this.rd.setColor(new Color(240, 240, 240));
            this.rd.drawLine(i - i_388_ / 2 - 12, i_387_ - (16 - i_389_), i - i_388_ / 2 - 12, i_387_ + (6 - i_389_));
            this.rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                this.rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                this.rd.setColor(new Color(0, 64, 128));
            this.rd.drawString(string, i - i_388_ / 2, i_387_);
        } else {
            this.rd.setColor(new Color(220, 220, 220));
            this.rd.fillRect(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i_388_ + 20, 25 - i_389_ * 2);
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ - (17 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (18 - i_389_), i + i_388_ / 2 + 10, i_387_ - (18 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 9, i_387_ - (19 - i_389_), i + i_388_ / 2 + 9, i_387_ - (19 - i_389_));
            this.rd.setColor(new Color(247, 247, 247));
            this.rd.drawLine(i + i_388_ / 2 + 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ + (7 - i_389_));
            this.rd.drawLine(i + i_388_ / 2 + 11, i_387_ - (17 - i_389_), i + i_388_ / 2 + 11, i_387_ + (7 - i_389_));
            this.rd.drawLine(i + i_388_ / 2 + 12, i_387_ - (16 - i_389_), i + i_388_ / 2 + 12, i_387_ + (6 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ + (7 - i_389_), i + i_388_ / 2 + 10, i_387_ + (7 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ + (8 - i_389_), i + i_388_ / 2 + 10, i_387_ + (8 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 9, i_387_ + (9 - i_389_), i + i_388_ / 2 + 9, i_387_ + (9 - i_389_));
            this.rd.setColor(new Color(192, 192, 192));
            this.rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i - i_388_ / 2 - 10, i_387_ + (7 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 11, i_387_ - (17 - i_389_), i - i_388_ / 2 - 11, i_387_ + (7 - i_389_));
            this.rd.drawLine(i - i_388_ / 2 - 12, i_387_ - (16 - i_389_), i - i_388_ / 2 - 12, i_387_ + (6 - i_389_));
            this.rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                this.rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                this.rd.setColor(new Color(0, 64, 128));
            this.rd.drawString(string, i - i_388_ / 2 + 1, i_387_ + 1);
        }
        return bool_390_;
    }
    
    public void openlink() {
        Madness.openurl("http://www.needformadness.com/developer/help.html");
    }
    
    public void openhlink() {
        Madness.openurl("http://www.needformadness.com/developer/");
    }
}
