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

public class StageMaker extends Applet implements Runnable {
    CheckPoints cp = new CheckPoints();
    Trackers t = new Trackers();
    //////////////// ------------ REMEMBER NEW PARTS ARE ALWAYS -10 INDEXES SINCE YOU CAN'T SELECT CARS IN THE STAGEMAKER
    //////////////// ------------ REMEMBER ALL PARTS INDEX 33 AND UP ARE SKYLINE PARTS
    //////////////// ------------ IF THEY'RE NOT IN THE TREES/SKYLINE MENU THEY SHOULD BE COMMENTED OUT
    /**
     *
     */
    private static final long serialVersionUID = 2444709970063151411L;
    private final int maxpart = 118; //originally 65 ------ INCREMENT THIS FUCKING THING WHEN YOU WANT A NEW FUCKING PART
    private final int bumppart = maxpart + 1; // bumps aren't even in the version this is just to avoid crashes

    private final static byte PART_ROADS = 0;
    private final static byte PART_RAMPS = 1;
    private final static byte PART_OBSTACLES = 2;
    private final static byte PART_CHECKPOINTS = 3;
    private final static byte PART_FIXHOOPS = 4;
    private final static byte PART_TREES = 5;
    private final static byte PART_BUMP = 6;

    boolean floats = false; // set to false for regular nfmm, set to true for skyline

    /*if (sptyp == 0) // PART ROADS
    	partroads();
    if (sptyp == 1) // PART RAMPS
    	partramps();
    if (sptyp == 2) // PART OBSTACLES
    	partobst();
    if (sptyp == 5) // PART TREES
    	partrees();*/

    private final String[][] addeda = new String[20][5000];
    private int adrot = 0;
    private int apx = 0;
    private int apy = 0;
    private int arrcnt = 0;
    private boolean arrng = false;

    /*
     * "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn",
    			"nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30",
    			"cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp",
    			"halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint",
     * */

    // ------------------ ATTACH POINTS
    // ------------------ INCREMENT THIS FUCKING THING WHEN YOU WANT A NEW FUCKING PART
    // Attach points are: x1, z1, x2, z2
    int[][] atp = { { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 1520, 2830, -1520, -2830 },
            { -1520, 2830, 1520, -2830 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 },
            { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 },
            { 0, 2800, 0, -2800 }, { 0, 560, 0, -560 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 385, 980, 385, -980 },
            { 0, 0, 0, -600 }, { 0, 0, 0, 0 }, { 0, 2164, 0, -2164 }, { 0, 2164, 0, -2164 }, { 0, 3309, 0, -1680 },
            { 0, 1680, 0, -3309 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
            { 1810, 980, 1810, -980 }, { 0, 0, 0, 0 }, { 0, 500, 0, -500 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 1680, 0, -3309 },
            { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 700, 1400, 700, -1400 },
            { 0, -1480, 0, -1480 }, { 0, 0, 0, 0 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 700, 0, -700, 0 },
            { 0, 0, 0, 0 }, { 0, -2198, 0, 1482 }, { 0, -1319, 0, 1391 }, { 0, -1894, 0, 2271 }, { 0, -826, 0, 839 },
            { 0, -1400, 0, 1400 }, { 0, -1400, 0, 1400 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
            { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
    private int avon = 0;
    private final ContO[] bco = new ContO[maxpart + 5];
    private String bstage = "\r\nmaxr(11,28500,-5600)\r\nmaxb(9,-8000,-12300)\r\nmaxl(11,-14700,-5600)\r\nmaxt(9,44800,-12300)\r\n";
    private final Image[] btgame = new Image[2];
    // Removed unused code found by UCDetector
    // 	int btn = 0;
    // Removed unused code found by UCDetector
    // 	int[] bw = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    // Removed unused code found by UCDetector
    // 	int[] bx = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    // Removed unused code found by UCDetector
    // 	int[] by = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    private final int[] cfade = {
            255, 220, 220
    };
    private final int[] cgrnd = {
            205, 200, 200
    };
    private int chi = -1;
    private final int[] cldd = {
            210, 210, 210, 1, -1000
    };
    private int cntout = 0;
    private final ContO[] co = new ContO[10000];
    private final int[] csky = {
            170, 220, 255
    };

    // ------------------ PART DESCRIPTIONS, LEAVE THESE AS INFO N/A
    private final String[] discp = {
            "NormalRoad :  Basic asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',  'NormalRoad Edged',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
            "NormalRoad Edged :  Asphalt road with edged side blocks (a destructive road).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
            "NormalRoad TwistedRight :  Asphalt road twisted towards the right.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad Twistedleft',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
            "NormalRoad TwistedLeft :  Asphalt road twisted towards the left.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
            "NormalRoad Turn :  Asphalt corner road turn.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp', 'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
            "OffRoad :  Basic sandy dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n",
            "OffRoad BumpyGreen :  Dirt-road with bumpy greenery in the middle.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n",
            "OffRoad Turn :  Dirt-road corner turn.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand 'Normal-Off-Road Blend'\n\n",
            "HalfpipeRoad :  Basic road for the half-pipe ramp.\nAttaches correctly to the following other parts :\n\n'Off-Halfpipe-Road Blend',  'HalfpipeRoad',  'HalfpipeRoad Turn',  'HalfpipeRoad-Ramp Filler'\nand  'Halfpipe-Normal-Road Blend'\n\n",
            "HalfpipeRoad Turn :  Half-pipe corner road turn.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'  and  'Halfpipe-Normal-Road Blend'\n\n",
            "Normal-Off-Road Blend :  Road blend between the normal asphalt road and the dirt-road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp', 'Halfpipe-Normal-Road Blend' 'OffRoad',  'OffRoad Turn',\n'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start'  and  'Off-Halfpipe-Road Blend'\n\n",
            "Off-Halfpipe-Road Blend :  Road blend between the dirt-road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',\n'HalfpipeRoad',  'HalfpipeRoad Turn',  'Halfpipe-Normal-Road Blend'  and  'Normal-Off-Road Blend'\n\n",
            "Halfpipe-Normal-Road Blend :  Road blend between the normal asphalt road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp',  'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'\nand  'Off-Halfpipe-Road Blend'\n\n",
            "NormalRoad End :  The end part of the normal asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n",
            "OffRoad End :  The end part of the dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n",
            "HalfpipeRoad-Ramp Filler :  A part that gets placed between the half-pipe road and the half-pipe ramp to extend the distance in between.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad'  and  'Halfpipe'\n\n",
            "Basic Ramp :  Basic 30 degree asphalt ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "Crash Ramp :  A 35 degree ramp with big side blocks for crashing into.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "Two-Way Ramp :  Two way 15 degree inclined ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "Two-Way High-Low Ramp :  Two way 15 degree inclined ramp, with peeked side for an optional higher car jump.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "Landing Ramp :  A ramp that is both a landing inclination and an obstacle as well, it is usually placed just after another normal ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n",
            "Big-Takeoff Ramp:  A big takeoff ramp for getting huge heights with the cars.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n",
            "Small Ramp :  A small ramp that can be placed on either side of the road.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n",
            "Offroad Bump Ramp :  A small bump ramp that is to be placed over the off-road dirt tracks.\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
            "Offroad Big Ramp :  The big off-road dirt mountain like ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
            "Offroad Ramp :  Normal sized off-road dirt track ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
            "Halfpipe :  The Half-pipe ramp, two of these ramps opposite each other create a half-pipe for the cars!\nAttaches correctly over and to the following other parts :\n\n'HalfpipeRoad',  'HalfpipeRoad Turn'  and  'HalfpipeRoad-Ramp Filler'\n\n",
            "Spiky Pillars :  An obstacle that is usually placed after a ramp for the cars to crash onto if they did not jump high or far enough!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "Rail Doorway :  A rail doorway that works as an obstacle for cars flying above it or cars driving through it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "The Wall",
            "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n",
            "Fixing Hoop :  The fixing hoop that fixes a car when it flies through it! You can add a max of 5 fixing hoops per stage.\nPlace it anywhere in the stage at an height your choose, the only important thing is that it needs to be reachable by the cars.",
            "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n",
            "OffRoad BumpySides :  Off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad-BumpySides Start'\n\n",
            "OffRoad-BumpySides Start: The start of the off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides',\n'Off-Halfpipe-Road Blend'  and  'Normal-Off-Road Blend'\n\n",
            "NormalRoad-Raised Ramp:  The start of the raised above the ground road (NormalRoad Raised).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight'  and  'NormalRoad Raised'\n\n",
            "NormalRoad Raised :  Normal road raised above the ground, cars must avoid falling off it when driving on it.\nAttaches correctly to the following other parts :\n\n'NormalRoad-Raised Ramp'\n\n",
            "The Start1", "The Start2",
            "Tunnel Side Ramp:  A ramp that can be used to create a tunnel like road with an open top or can be used as a wall ramp!\nAttaches correctly over only the 'NormalRoad' part.",
            "Launch Pad Ramp:  A ramp that launches your car fully upwards like a rocket, it also has sides to lock any car climbing it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "The Net:  An obstacle part that is to be placed in the center of the road right after a ramp, the idea is that the\ncars jumping the ramp should try to go over it or through it without getting caught crashing (without getting\ncaught in it, getting caught in the net!).\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "Speed Ramp:  A ramp that is designed to have the perfect angle to catapult your car the furthest when doing forward loops, it is half the roads width.\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "Offroad Hill Ramp:  An offroad hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
            "Bump Slide:  A small bump obstacle that is to be placed on the sides of the road or in the center.\nAttaches correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n",
            "Offroad Big Hill Ramp:  An offroad big hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n",
            "Rollercoaster Start/End:  The ramp that starts the Rollercoaster Road and ends it.\nAttaches correctly over and to following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n 'NormalRoad TwistedRight'  and  'Rollercoaster Start/End'\n\n",
            "Rollercoaster Road1\nAttaches correctly to only 'Rollercoaster Start/End', 'Rollercoaster Road2' and itself.\n\n",
            "Rollercoaster Road3\nAttaches correctly to only 'Rollercoaster Road2', 'Rollercoaster Road4' and itself.\n\n",
            "Rollercoaster Road4\nAttaches correctly to only 'Rollercoaster Road3', 'Rollercoaster Road5' and itself.\n\n",
            "Rollercoaster Road2\nAttaches correctly to only 'Rollercoaster Road1', 'Rollercoaster Road3' and itself.\n\n",
            "Rollercoaster Road5\nAttaches correctly to only 'Rollercoaster Road4' and itself.\n\n",
            "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n",
            "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n",
            "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",
            "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n",

            "Ground Piles are to be paced outside the race track on the ground and NEVER on any road part or ramp!\nThey are to be used as ground decoration and out of race course obstacles (ground obstacles)!\n\n"
    };
    private boolean down = false;
    private int dtab = 0;
    private int dtabed = -1;
    private boolean epart = false;
    private int errd = 0;
    private final String[] errlo = {
            "The maximum allocated memory for the stage's part's details has been exerted.\nPlease decrease the amount of parts in the stage that have more details then average.",
            "The maximum amount of road points allowed in the track has been exceeded.\nPlease remove some of the road parts that are in the circler path of the track (the parts that are between the checkpoints).\nOr try to remove some of the extra checkpoints in the track as well.",
            "The maximum allowed area for a track (the area in between its walls) has been exceeded.\nPlease try to place parts only inside the current allowed area, inside the area between the current maximum wall placements.",
            "The maximum number of parts allowed per stage has been exceeded.\nPlease remove some of the already extra parts placed in order to make space.",
            "The maximum number of Fixing Hoops allowed per stage is 5!\nPlease remove the extra Fixing Hoops from your stage to have only 5 main ones left.",
            "Unknown Error, please make sure the stage you are handling is saved correctly.\nPlease go to the 'Build' tab and press 'Save & Preview'.",
            "There needs to be at least 2 checkpoints in the Stage in order for the game to work.\nPlease go to the 'Build' tab and select 'Checkpoint' in the Part Selection menu to add more cp.",
            "The name of the stage is too long!\nPlease go to the 'Stage' tab, click 'Rename Stage' and give your stage a shorter name."
    };
    private int esp = -1;
    private boolean exwist = false;
    private int fgen = 0;
    private final TextField fixh = new TextField("2000", 5);
    private int flyh = 0;
    private boolean focuson = true;
    private final int[] fogn = {
            60, 0
    };
    private FontMetrics ftm;
    private int hf = 2000;
    private int hi = -1;
    private final float[][] hsb = {
            {
                    0.5F, 0.875F, 0.5F
            }, {
                    0.5F, 0.875F, 0.5F
            }, {
                    0.5F, 0.875F, 0.5F
            }
    };
    private boolean left = false;
    private int logged = 0;
    private Image logo;
    private int lsp = -1;
    private String ltrackname = "";
    private int lxm = 0;
    // Removed unused code found by UCDetector
    // 	private int lym = 0;
    private final Medium m = new Medium();
    private final String[] maker = new String[20];
    private final TextField mgen = new TextField("", 10);
    private boolean mousdr = false;
    private int mouseon = -1;
    private int mousePressed = 0;
    private final String[] mystages = new String[20];
    private final int[] nad = new int[20];
    private final Smenu nlaps = new Smenu(40);
    private int nms = 0;
    private int nob = 0;
    private int nundo = 0;
    private final int[] ocheckp = {
            5, 6, 7, 11, 14, 33, 34, 38
    };
    private Image offImage;
    private boolean onbtgame = false;
    // Removed unused code found by UCDetector
    // 	private boolean onfly = false;
    private boolean onoff = false;
    private int origfade = 5000;
    private boolean overcan = false;
    private final Smenu part = new Smenu(500);
    // Removed unused code found by UCDetector
    // 	boolean[] pessd = { false, false, false, false, false, false, false, false, false, false, false, false, false,
    // 			false, false, false, false, false, false, false, false, false, false, false };
    private final Checkbox pfog = new Checkbox("Linked Blend");
    private boolean pgen = false;
    private float phd = 2L + Math.round(Math.random() * 4.0);
    private boolean preop = false;
    private final Smenu ptyp = new Smenu(40);
    private final int[] pubt = new int[20];
    private final Smenu pubtyp = new Smenu(40);
    private float pwd = 2L + Math.round(Math.random() * 4.0);
    private final int[] rcheckp = {
            0, 1, 2, 3, 4, 12, 13, 37
    };
    private Graphics2D rd;
    private boolean right = false;
    private int rot = 0;
    private final Image[] sd = new Image[2];
    private int seq = 0;
    private boolean seqn = false;
    private boolean setcur = false;
    private int sfase = 0;
    private final Image[] sl = new Image[2];
    private final Smenu slstage = new Smenu(2000);
    private final int[] snap = {
            50, 50, 50
    };
    private int selectedPart = 0;
    private int selectedMenuPart = 0;
    private int selectedPartType = 0;
    private final Image[] sr = new Image[2];
    private final TextField srch = new TextField("", 38);
    private String sstage = "";
    private String stagename = "";
    private final Smenu strtyp = new Smenu(40);
    private final Image[] su = new Image[2];
    private String suser = "Horaks";
    private int sx = 0;
    private int sy = -10000;
    private int sz = 1500;
    private int tab = 0;
    private int tabed = -1;
    private final int[] texture = {
            0, 0, 0, 10
    };
    private Thread thredo;
    private final TextField tnick = new TextField("", 15);
    private final TextField tpass = new TextField("", 15);
    private RadicalMod track = new RadicalMod();
    private String trackname = "";
    private final Smenu tracks = new Smenu(2000);
    private int tracksize = 111;
    private int trackvol = 200;
    private String tstage = new StringBuilder()
            .append("snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\n\rmountains(")
            .append((int) (Math.random() * 100000.0)).append(")\r\nnlaps(5)\r\n\r\n").toString();
    private String ttstage = "";
    private final String[] undos = new String[5000];
    private boolean up = false;
    private int vx = 0;
    private int vxz = 0;
    private int vy = 0;
    private int vz = 0;
    private final Smenu witho = new Smenu(40);
    private int xm = 0;
    private int xnob = 0;
    private int ym = 0;
    private final Image[] zi = new Image[2];
    private final Image[] zo = new Image[2];
    private boolean zoomi = false;
    private boolean zoomo = false;

    public boolean button(final String string, final int i, final int i_381_, final int i_382_, final boolean bool) {
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        final int i_383_ = ftm.stringWidth(string);
        boolean bool_384_ = false;
        boolean bool_385_ = false;
        if (string.equals(" Cancel ") && epart && Math.abs(xm - i) < i_383_ / 2 + 12 && Math.abs(ym - i_381_ + 5) < 10)
            overcan = true;
        if (Math.abs(xm - i) < i_383_ / 2 + 12 && Math.abs(ym - i_381_ + 5) < 10 && mousePressed == 1)
            bool_384_ = true;
        else
            bool_384_ = false;
        if (Math.abs(xm - i) < i_383_ / 2 + 12 && Math.abs(ym - i_381_ + 5) < 10 && mousePressed == -1) {
            mousePressed = 0;
            bool_385_ = true;
        }
        boolean bool_386_ = false;
        if (bool) {
            if (tab == 0)
                rd.setColor(new Color(207, 207, 207));
            if (tab == 1)
                rd.setColor(new Color(200, 200, 200));
            if (tab == 2)
                rd.setColor(new Color(170, 170, 170));
            if (tab != 3) {
                rd.drawRect(i - i_383_ / 2 - 15, i_381_ - (22 - i_382_), i_383_ + 29, 34 - i_382_ * 2);
                if (i_382_ == 2 && tab == 1) {
                    rd.setColor(new Color(220, 220, 220));
                    rd.fillRect(i - i_383_ / 2 - 15, i_381_ - (22 - i_382_), i_383_ + 29, 34 - i_382_ * 2);
                }
            } else
                bool_386_ = true;
        }
        if (!bool_384_) {
            rd.setColor(new Color(220, 220, 220));
            if (bool_386_)
                rd.setColor(new Color(230, 230, 230));
            rd.fillRect(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i_383_ + 20, 25 - i_382_ * 2);
            rd.setColor(new Color(240, 240, 240));
            if (bool_386_)
                rd.setColor(new Color(255, 255, 255));
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ - (17 - i_382_));
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (18 - i_382_), i + i_383_ / 2 + 10, i_381_ - (18 - i_382_));
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i_383_ / 2 - 9, i_381_ - (19 - i_382_), i + i_383_ / 2 + 9, i_381_ - (19 - i_382_));
            rd.setColor(new Color(200, 200, 200));
            if (bool_386_)
                rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i + i_383_ / 2 + 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ + 7 - i_382_);
            rd.drawLine(i + i_383_ / 2 + 11, i_381_ - (17 - i_382_), i + i_383_ / 2 + 11, i_381_ + 7 - i_382_);
            rd.setColor(new Color(200, 200, 200));
            if (bool_386_)
                rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i + i_383_ / 2 + 12, i_381_ - (16 - i_382_), i + i_383_ / 2 + 12, i_381_ + 6 - i_382_);
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ + 7 - i_382_, i + i_383_ / 2 + 10, i_381_ + 7 - i_382_);
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ + 8 - i_382_, i + i_383_ / 2 + 10, i_381_ + 8 - i_382_);
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i - i_383_ / 2 - 9, i_381_ + 9 - i_382_, i + i_383_ / 2 + 9, i_381_ + 9 - i_382_);
            rd.setColor(new Color(240, 240, 240));
            if (bool_386_)
                rd.setColor(new Color(255, 255, 255));
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i - i_383_ / 2 - 10, i_381_ + 7 - i_382_);
            rd.drawLine(i - i_383_ / 2 - 11, i_381_ - (17 - i_382_), i - i_383_ / 2 - 11, i_381_ + 7 - i_382_);
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i_383_ / 2 - 12, i_381_ - (16 - i_382_), i - i_383_ / 2 - 12, i_381_ + 6 - i_382_);
            rd.setColor(new Color(0, 0, 0));
            if (string.equals("  Keyboard Controls  "))
                rd.setColor(new Color(100, 100, 100));
            rd.drawString(string, i - i_383_ / 2, i_381_);
        } else {
            rd.setColor(new Color(220, 220, 220));
            rd.fillRect(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i_383_ + 20, 25 - i_382_ * 2);
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ - (17 - i_382_));
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (18 - i_382_), i + i_383_ / 2 + 10, i_381_ - (18 - i_382_));
            rd.drawLine(i - i_383_ / 2 - 9, i_381_ - (19 - i_382_), i + i_383_ / 2 + 9, i_381_ - (19 - i_382_));
            rd.setColor(new Color(247, 247, 247));
            rd.drawLine(i + i_383_ / 2 + 10, i_381_ - (17 - i_382_), i + i_383_ / 2 + 10, i_381_ + 7 - i_382_);
            rd.drawLine(i + i_383_ / 2 + 11, i_381_ - (17 - i_382_), i + i_383_ / 2 + 11, i_381_ + 7 - i_382_);
            rd.drawLine(i + i_383_ / 2 + 12, i_381_ - (16 - i_382_), i + i_383_ / 2 + 12, i_381_ + 6 - i_382_);
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ + 7 - i_382_, i + i_383_ / 2 + 10, i_381_ + 7 - i_382_);
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ + 8 - i_382_, i + i_383_ / 2 + 10, i_381_ + 8 - i_382_);
            rd.drawLine(i - i_383_ / 2 - 9, i_381_ + 9 - i_382_, i + i_383_ / 2 + 9, i_381_ + 9 - i_382_);
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - i_383_ / 2 - 10, i_381_ - (17 - i_382_), i - i_383_ / 2 - 10, i_381_ + 7 - i_382_);
            rd.drawLine(i - i_383_ / 2 - 11, i_381_ - (17 - i_382_), i - i_383_ / 2 - 11, i_381_ + 7 - i_382_);
            rd.drawLine(i - i_383_ / 2 - 12, i_381_ - (16 - i_382_), i - i_383_ / 2 - 12, i_381_ + 6 - i_382_);
            rd.setColor(new Color(0, 0, 0));
            if (string.equals("  Keyboard Controls  "))
                rd.setColor(new Color(100, 100, 100));
            rd.drawString(string, i - i_383_ / 2 + 1, i_381_ + 1);
        }
        return bool_385_;
    }

    public void copyesp(final boolean bool) {
        selectedPart = co[esp].colok;
        rot = co[esp].roofat;
        if (selectedPart == 2)
            rot -= 30;
        if (selectedPart == 3)
            rot += 30;
        if (selectedPart == 15)
            rot += 90;
        if (selectedPart == 20)
            rot += 180;
        if (selectedPart == 26)
            rot -= 90;
        if (selectedPart == 0) {
            selectedPartType = 0;
            selectedMenuPart = 0;
        }
        if (selectedPart == 4) {
            selectedPartType = 0;
            selectedMenuPart = 1;
        }
        if (selectedPart == 13) {
            selectedPartType = 0;
            selectedMenuPart = 2;
        }
        if (selectedPart == 3) {
            selectedPartType = 0;
            selectedMenuPart = 3;
        }
        if (selectedPart == 2) {
            selectedPartType = 0;
            selectedMenuPart = 4;
        }
        if (selectedPart == 1) {
            selectedPartType = 0;
            selectedMenuPart = 5;
        }
        /*if (selectedPart == 35) {
        	selectedPartType = 0;
        	selectedMenuPart = 6;
        }
        if (selectedPart == 36) {
        	selectedPartType = 0;
        	selectedMenuPart = 7;
        }*/
        if (selectedPart == 10) {
            selectedPartType = 0;
            selectedMenuPart = 8;
        }
        if (selectedPart == 5) {
            selectedPartType = 0;
            selectedMenuPart = 9;
        }
        if (selectedPart == 7) {
            selectedPartType = 0;
            selectedMenuPart = 10;
        }
        if (selectedPart == 14) {
            selectedPartType = 0;
            selectedMenuPart = 11;
        }
        if (selectedPart == 6) {
            selectedPartType = 0;
            selectedMenuPart = 12;
        }
        /*if (selectedPart == 34) {
        	selectedPartType = 0;
        	selectedMenuPart = 13;
        }
        if (selectedPart == 33) {
        	selectedPartType = 0;
        	selectedMenuPart = 14;
        }*/
        if (selectedPart == 11) {
            selectedPartType = 0;
            selectedMenuPart = 15;
        }
        if (selectedPart == 8) {
            selectedPartType = 0;
            selectedMenuPart = 16;
        }
        if (selectedPart == 9) {
            selectedPartType = 0;
            selectedMenuPart = 17;
        }
        if (selectedPart == 15) {
            selectedPartType = 0;
            selectedMenuPart = 18;
        }
        if (selectedPart == 12) {
            selectedPartType = 0;
            selectedMenuPart = 19;
        }
        /*if (selectedPart == 46) {
        	selectedPartType = 0;
        	selectedMenuPart = 20;
        }
        if (selectedPart == 47) {
        	selectedPartType = 0;
        	selectedMenuPart = 21;
        }
        if (selectedPart == 48) {
        	selectedPartType = 0;
        	selectedMenuPart = 23;
        }
        if (selectedPart == 49) {
        	selectedPartType = 0;
        	selectedMenuPart = 24;
        }*/
        /*if (selectedPart == 50) {
        	selectedPartType = 0;
        	selectedMenuPart = 22;
        }
        if (selectedPart == 51) {
        	selectedPartType = 0;
        	selectedMenuPart = 25;
        }*/
        if (selectedPart == 16) {
            selectedPartType = 1;
            selectedMenuPart = 0;
        }
        if (selectedPart == 18) {
            selectedPartType = 1;
            selectedMenuPart = 1;
        }
        if (selectedPart == 19) {
            selectedPartType = 1;
            selectedMenuPart = 2;
        }
        if (selectedPart == 22) {
            selectedPartType = 1;
            selectedMenuPart = 3;
        }
        if (selectedPart == 17) {
            selectedPartType = 1;
            selectedMenuPart = 4;
        }
        if (selectedPart == 21) {
            selectedPartType = 1;
            selectedMenuPart = 5;
        }
        if (selectedPart == 20) {
            selectedPartType = 1;
            selectedMenuPart = 6;
        }
        /*if (selectedPart == 39) {
        	selectedPartType = 1;
        	selectedMenuPart = 7;
        }
        if (selectedPart == 42) {
        	selectedPartType = 1;
        	selectedMenuPart = 8;
        }*/
        /*if (selectedPart == 40) {
        	selectedPartType = 1;
        	selectedMenuPart = 9;
        }*/
        if (selectedPart == 23) {
            selectedPartType = 1;
            selectedMenuPart = 10;
        }
        if (selectedPart == 25) {
            selectedPartType = 1;
            selectedMenuPart = 11;
        }
        if (selectedPart == 24) {
            selectedPartType = 1;
            selectedMenuPart = 12;
        }
        /*if (selectedPart == 43) {
        	selectedPartType = 1;
        	selectedMenuPart = 13;
        }
        if (selectedPart == 45) {
        	selectedPartType = 1;
        	selectedMenuPart = 14;
        }*/
        if (selectedPart == 26) {
            selectedPartType = 1;
            selectedMenuPart = 15;
        }
        if (selectedPart == 27) {
            selectedPartType = 2;
            selectedMenuPart = 0;
        }
        if (selectedPart == 28) {
            selectedPartType = 2;
            selectedMenuPart = 1;
        }
        /*if (selectedPart == 41) {
        	selectedPartType = 2;
        	selectedMenuPart = 2;
        }*/
        /*if (selectedPart == 44) {
        	selectedPartType = 2;
        	selectedMenuPart = 3;
        }
        if (selectedPart == 52) {
        	selectedPartType = 2;
        	selectedMenuPart = 4;
        }
        if (selectedPart == 53) {
        	selectedPartType = 2;
        	selectedMenuPart = 5;
        }*/
        if (selectedPart == 30 || selectedPart == 32/* || selectedPart == 54*/) {
            selectedPartType = 3;
            selectedMenuPart = 0;
        }
        if (selectedPart == 31) {
            selectedPartType = 4;
            selectedMenuPart = 0;
        }
        if (selectedPart == 33) {
            selectedPartType = 5;
            selectedMenuPart = 0;
        }

        if (selectedPart == 34) {
            selectedPartType = 5;
            selectedMenuPart = 1;
        }

        if (selectedPart == 35) {
            selectedPartType = 5;
            selectedMenuPart = 2;
        }

        if (selectedPart == 36) {
            selectedPartType = 5;
            selectedMenuPart = 3;
        }

        if (selectedPart == 37) {
            selectedPartType = 5;
            selectedMenuPart = 4;
        }

        if (selectedPart == 38) {
            selectedPartType = 5;
            selectedMenuPart = 5;
        }

        if (selectedPart == 39) {
            selectedPartType = 5;
            selectedMenuPart = 6;
        }

        if (selectedPart == 40) {
            selectedPartType = 5;
            selectedMenuPart = 7;
        }

        if (selectedPart == 41) {
            selectedPartType = 5;
            selectedMenuPart = 8;
        }

        if (selectedPart == 42) {
            selectedPartType = 5;
            selectedMenuPart = 9;
        }

        if (selectedPart == 43) {
            selectedPartType = 5;
            selectedMenuPart = 10;
        }

        if (selectedPart == 44) {
            selectedPartType = 5;
            selectedMenuPart = 11;
        }

        if (selectedPart == 45) {
            selectedPartType = 5;
            selectedMenuPart = 12;
        }

        if (selectedPart == 46) {
            selectedPartType = 5;
            selectedMenuPart = 13;
        }

        if (selectedPart == 47) {
            selectedPartType = 5;
            selectedMenuPart = 14;
        }

        if (selectedPart == 48) {
            selectedPartType = 5;
            selectedMenuPart = 15;
        }

        if (selectedPart == 49) {
            selectedPartType = 5;
            selectedMenuPart = 16;
        }

        if (selectedPart == 50) {
            selectedPartType = 5;
            selectedMenuPart = 17;
        }

        if (selectedPart == 51) {
            selectedPartType = 5;
            selectedMenuPart = 18;
        }

        if (selectedPart == 52) {
            selectedPartType = 5;
            selectedMenuPart = 19;
        }

        if (selectedPart == 53) {
            selectedPartType = 5;
            selectedMenuPart = 20;
        }

        if (selectedPart == 54) {
            selectedPartType = 5;
            selectedMenuPart = 21;
        }

        if (selectedPart == 55) {
            selectedPartType = 5;
            selectedMenuPart = 22;
        }

        if (selectedPart == 56) {
            selectedPartType = 5;
            selectedMenuPart = 23;
        }

        if (selectedPart == 57) {
            selectedPartType = 5;
            selectedMenuPart = 24;
        }

        if (selectedPart == 58) {
            selectedPartType = 5;
            selectedMenuPart = 25;
        }

        if (selectedPart == 59) {
            selectedPartType = 5;
            selectedMenuPart = 26;
        }

        if (selectedPart == 60) {
            selectedPartType = 5;
            selectedMenuPart = 27;
        }

        if (selectedPart == 61) {
            selectedPartType = 5;
            selectedMenuPart = 28;
        }

        if (selectedPart == 62) {
            selectedPartType = 5;
            selectedMenuPart = 29;
        }

        if (selectedPart == 63) {
            selectedPartType = 5;
            selectedMenuPart = 30;
        }

        if (selectedPart == 64) {
            selectedPartType = 5;
            selectedMenuPart = 31;
        }

        if (selectedPart == 65) {
            selectedPartType = 5;
            selectedMenuPart = 32;
        }

        if (selectedPart == 66) {
            selectedPartType = 5;
            selectedMenuPart = 33;
        }

        if (selectedPart == 67) {
            selectedPartType = 5;
            selectedMenuPart = 34;
        }

        if (selectedPart == 68) {
            selectedPartType = 5;
            selectedMenuPart = 35;
        }

        if (selectedPart == 69) {
            selectedPartType = 5;
            selectedMenuPart = 36;
        }

        if (selectedPart == 70) {
            selectedPartType = 5;
            selectedMenuPart = 37;
        }

        if (selectedPart == 71) {
            selectedPartType = 5;
            selectedMenuPart = 38;
        }

        if (selectedPart == 72) {
            selectedPartType = 5;
            selectedMenuPart = 39;
        }

        if (selectedPart == 73) {
            selectedPartType = 5;
            selectedMenuPart = 40;
        }

        if (selectedPart == 74) {
            selectedPartType = 5;
            selectedMenuPart = 41;
        }

        if (selectedPart == 75) {
            selectedPartType = 5;
            selectedMenuPart = 42;
        }

        if (selectedPart == 76) {
            selectedPartType = 5;
            selectedMenuPart = 43;
        }

        if (selectedPart == 77) {
            selectedPartType = 5;
            selectedMenuPart = 44;
        }

        if (selectedPart == 78) {
            selectedPartType = 5;
            selectedMenuPart = 45;
        }

        if (selectedPart == 79) {
            selectedPartType = 5;
            selectedMenuPart = 46;
        }

        if (selectedPart == 80) {
            selectedPartType = 5;
            selectedMenuPart = 47;
        }

        if (selectedPart == 81) {
            selectedPartType = 5;
            selectedMenuPart = 48;
        }

        if (selectedPart == 82) {
            selectedPartType = 5;
            selectedMenuPart = 49;
        }

        if (selectedPart == 83) {
            selectedPartType = 5;
            selectedMenuPart = 50;
        }

        if (selectedPart == 84) {
            selectedPartType = 5;
            selectedMenuPart = 51;
        }

        if (selectedPart == 85) {
            selectedPartType = 5;
            selectedMenuPart = 52;
        }

        if (selectedPart == 86) {
            selectedPartType = 5;
            selectedMenuPart = 53;
        }

        if (selectedPart == 87) {
            selectedPartType = 5;
            selectedMenuPart = 54;
        }

        if (selectedPart == 88) {
            selectedPartType = 5;
            selectedMenuPart = 55;
        }

        if (selectedPart == 89) {
            selectedPartType = 5;
            selectedMenuPart = 56;
        }

        if (selectedPart == 90) {
            selectedPartType = 5;
            selectedMenuPart = 57;
        }

        if (selectedPart == 91) {
            selectedPartType = 5;
            selectedMenuPart = 58;
        }

        if (selectedPart == 92) {
            selectedPartType = 5;
            selectedMenuPart = 59;
        }

        if (selectedPart == 93) {
            selectedPartType = 5;
            selectedMenuPart = 60;
        }

        if (selectedPart == 94) {
            selectedPartType = 5;
            selectedMenuPart = 61;
        }

        if (selectedPart == 95) {
            selectedPartType = 5;
            selectedMenuPart = 62;
        }

        if (selectedPart == 96) {
            selectedPartType = 5;
            selectedMenuPart = 63;
        }

        if (selectedPart == 97) {
            selectedPartType = 5;
            selectedMenuPart = 64;
        }

        if (selectedPart == 98) {
            selectedPartType = 5;
            selectedMenuPart = 65;
        }

        if (selectedPart == 99) {
            selectedPartType = 5;
            selectedMenuPart = 66;
        }

        if (selectedPart == 100) {
            selectedPartType = 5;
            selectedMenuPart = 67;
        }

        if (selectedPart == 101) {
            selectedPartType = 5;
            selectedMenuPart = 68;
        }

        if (selectedPart == 102) {
            selectedPartType = 5;
            selectedMenuPart = 69;
        }

        if (selectedPart == 103) {
            selectedPartType = 5;
            selectedMenuPart = 70;
        }

        if (selectedPart == 104) {
            selectedPartType = 5;
            selectedMenuPart = 71;
        }

        if (selectedPart == 105) {
            selectedPartType = 5;
            selectedMenuPart = 72;
        }

        if (selectedPart == 106) {
            selectedPartType = 5;
            selectedMenuPart = 73;
        }

        if (selectedPart == 107) {
            selectedPartType = 5;
            selectedMenuPart = 74;
        }

        if (selectedPart == 108) {
            selectedPartType = 5;
            selectedMenuPart = 75;
        }

        if (selectedPart == 109) {
            selectedPartType = 5;
            selectedMenuPart = 76;
        }

        if (selectedPart == 110) {
            selectedPartType = 5;
            selectedMenuPart = 77;
        }

        if (selectedPart == 111) {
            selectedPartType = 5;
            selectedMenuPart = 78;
        }

        if (selectedPart == 112) {
            selectedPartType = 5;
            selectedMenuPart = 79;
        }

        if (selectedPart == 113) {
            selectedPartType = 5;
            selectedMenuPart = 80;
        }

        if (selectedPart == 114) {
            selectedPartType = 5;
            selectedMenuPart = 81;
        }

        if (selectedPart == 115) {
            selectedPartType = 5;
            selectedMenuPart = 82;
        }

        if (selectedPart == 116) {
            selectedPartType = 5;
            selectedMenuPart = 83;
        }

        if (selectedPart == 117) {
            selectedPartType = 5;
            selectedMenuPart = 84;
        }

        if (selectedPart == 118) {
            selectedPartType = 5;
            selectedMenuPart = 85;
        }

        if (selectedPart == 119) {
            selectedPartType = 5;
            selectedMenuPart = 86;
        }

        if (selectedPart == 120) {
            selectedPartType = 5;
            selectedMenuPart = 87;
        }

        if (selectedPart == 121) {
            selectedPartType = 5;
            selectedMenuPart = 88;
        }

        if (selectedPart == 122) {
            selectedPartType = 5;
            selectedMenuPart = 89;
        }

        if (selectedPart == 123) {
            selectedPartType = 5;
            selectedMenuPart = 90;
        }

        if (selectedPart == 124) {
            selectedPartType = 5;
            selectedMenuPart = 91;
        }

        if (selectedPart == 125) {
            selectedPartType = 5;
            selectedMenuPart = 92;
        }

        if (selectedPart == 126) {
            selectedPartType = 5;
            selectedMenuPart = 93;
        }

        if (selectedPart == 127) {
            selectedPartType = 5;
            selectedMenuPart = 94;
        }

        if (selectedPart == 128) {
            selectedPartType = 5;
            selectedMenuPart = 95;
        }

        if (selectedPart == 129) {
            selectedPartType = 5;
            selectedMenuPart = 96;
        }

        if (selectedPart == 130) {
            selectedPartType = 5;
            selectedMenuPart = 97;
        }

        if (selectedPart == 131) {
            selectedPartType = 5;
            selectedMenuPart = 98;
        }

        if (selectedPart == 132) {
            selectedPartType = 5;
            selectedMenuPart = 99;
        }

        if (selectedPart == 133) {
            selectedPartType = 5;
            selectedMenuPart = 100;
        }

        // ------------------ INCREMENT HERE FOR NEW PARTS
        // -----------------------------NO NEED TO INCREMENT ANYMORE I FIXED IT

        if (selectedPart > 133) {
            selectedPartType = 5;
            selectedMenuPart = selectedPart - 33;
        }

        /*if (selectedPart == 55) {
        	selectedPartType = 5;
        	selectedMenuPart = 0;
        }
        if (selectedPart == 56) {
        	selectedPartType = 5;
        	selectedMenuPart = 1;
        }
        if (selectedPart == 57) {
        	selectedPartType = 5;
        	selectedMenuPart = 2;
        }
        if (selectedPart == 58) {
        	selectedPartType = 5;
        	selectedMenuPart = 3;
        }
        if (selectedPart == 59) {
        	selectedPartType = 5;
        	selectedMenuPart = 4;
        }
        if (selectedPart == 60) {
        	selectedPartType = 5;
        	selectedMenuPart = 5;
        }
        if (selectedPart == 61) {
        	selectedPartType = 5;
        	selectedMenuPart = 6;
        }
        if (selectedPart == 62) {
        	selectedPartType = 5;
        	selectedMenuPart = 7;
        }
        if (selectedPart == 63) {
        	selectedPartType = 5;
        	selectedMenuPart = 8;
        }
        if (selectedPart == 64) {
        	selectedPartType = 5;
        	selectedMenuPart = 9;
        }
        if (selectedPart == 65) {
        	selectedPartType = 5;
        	selectedMenuPart = 10;
        }
        if (selectedPart == 66) {
        	selectedPartType = 5;
        	selectedMenuPart = 11;
        }*/
        if (selectedPart == bumppart) {
            if (bool)
                fgen = co[esp].srz;
            else
                fgen = 0;
            pwd = co[esp].srx;
            phd = co[esp].sry;
            pgen = false;
            selectedPartType = 6;
        }
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
        }
        ptyp.select(selectedPartType);
        part.select(selectedMenuPart);
    }

    public void delstage(final String string) {
        try {
            final File file = new File(
                    new StringBuilder().append("mystages/").append(string).append(".txt").toString());
            file.delete();
            slstage.remove(string);
            slstage.select(0);
        } catch (final Exception exception) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Unable to delete file! Error Deatials:\n").append(exception).toString(),
                    "Stage Maker", 1);
        }
    }

    public void deltrack() {
        try {
            final File file = new File(new StringBuilder().append("mystages/mymusic/").append(tracks.getSelectedItem())
                    .append(".zip").toString());
            file.delete();
            if (trackname.equals(tracks.getSelectedItem())) {
                trackname = "";
                sortop();
                savefile();
            }
            tracks.remove(tracks.getSelectedItem());
            tracks.select(0);
        } catch (final Exception exception) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Unable to delete file! Error Deatials:\n").append(exception).toString(),
                    "Stage Maker", 1);
        }
    }

    public void drawms() {
        boolean bool = false;
        if (pubtyp.draw(rd, xm, ym, mousdr, 550, false))
            bool = true;
        if (slstage.draw(rd, xm, ym, mousdr, 550, false))
            bool = true;
        if (strtyp.draw(rd, xm, ym, mousdr, 550, false))
            bool = true;
        int i = 0;
        if (preop)
            i = -1000;
        if (part.draw(rd, xm, ym + i, mousdr && !preop, 550, false))
            bool = true;
        if (ptyp.draw(rd, xm, ym, mousdr, 550, false)) {
            bool = true;
            preop = true;
        } else
            preop = false;
        if (nlaps.draw(rd, xm, ym, mousdr, 550, true))
            bool = true;
        if (tracks.draw(rd, xm, ym, mousdr, 550, true))
            bool = true;
        if (witho.draw(rd, xm, ym, mousdr, 550, true))
            bool = true;
        if (bool)
            mousePressed = 0;
    }

    public void fixtext(final TextField textfield) {
        String string = textfield.getText();
        string = string.replace('\"', '#');
        final String string_330_ = "\\";
        String string_331_ = "";
        int i = 0;
        int i_332_ = -1;
        rd.setFont(new Font("Arial", 1, 12));
        ftm = rd.getFontMetrics();
        for (/**/; i < string.length(); i++) {
            final String string_333_ = new StringBuilder().append("").append(string.charAt(i)).toString();
            if (string_333_.equals("|") || string_333_.equals(",") || string_333_.equals("(") || string_333_.equals(")")
                    || string_333_.equals("#") || string_333_.equals(string_330_) || string_333_.equals("!")
                    || string_333_.equals("?") || string_333_.equals("~") || string_333_.equals(".")
                    || string_333_.equals("@") || string_333_.equals("$") || string_333_.equals("%")
                    || string_333_.equals("^") || string_333_.equals("&") || string_333_.equals("*")
                    || string_333_.equals("+") || string_333_.equals("=") || string_333_.equals(">")
                    || string_333_.equals("<") || string_333_.equals("/") || string_333_.equals(";")
                    || string_333_.equals(":") || ftm.stringWidth(string_331_) > 274)
                i_332_ = i;
            else
                string_331_ = new StringBuilder().append(string_331_).append(string_333_).toString();
        }
        if (i_332_ != -1) {
            textfield.setText(string_331_);
            textfield.select(i_332_, i_332_);
        }
    }

    public Image getImage(final String string) {
        final Image image = Toolkit.getDefaultToolkit().createImage(string);
        final MediaTracker mediatracker = new MediaTracker(this);
        mediatracker.addImage(image, 0);
        try {
            mediatracker.waitForID(0);
        } catch (final Exception exception) {
            /* empty */
        }
        return image;
    }

    public int getint(final String string, final String string_354_, final int i) {
        int i_355_ = 0;
        String string_356_ = "";
        for (int i_357_ = string.length() + 1; i_357_ < string_354_.length(); i_357_++) {
            final String string_358_ = new StringBuilder().append("").append(string_354_.charAt(i_357_)).toString();
            if (string_358_.equals(",") || string_358_.equals(")")) {
                i_355_++;
                i_357_++;
            }
            if (i_355_ == i)
                string_356_ = new StringBuilder().append(string_356_).append(string_354_.charAt(i_357_)).toString();
        }
        return Integer.valueOf(string_356_).intValue();
    }

    public String getstring(final String string, final String string_349_, final int i) {
        int i_350_ = 0;
        String string_351_ = "";
        for (int i_352_ = string.length() + 1; i_352_ < string_349_.length(); i_352_++) {
            final String string_353_ = new StringBuilder().append("").append(string_349_.charAt(i_352_)).toString();
            if (string_353_.equals(",") || string_353_.equals(")")) {
                i_350_++;
                i_352_++;
            }
            if (i_350_ == i)
                string_351_ = new StringBuilder().append(string_351_).append(string_349_.charAt(i_352_)).toString();
        }
        return string_351_;
    }

    public String getSvalue(final String string, final String string_376_, final int i) {
        String string_377_ = "";
        int i_378_ = 0;
        for (int i_379_ = string.length() + 1; i_379_ < string_376_.length() && i_378_ <= i; i_379_++) {
            final String string_380_ = new StringBuilder().append("").append(string_376_.charAt(i_379_)).toString();
            if (string_380_.equals(",") || string_380_.equals(")"))
                i_378_++;
            else if (i_378_ == i)
                string_377_ = new StringBuilder().append(string_377_).append(string_380_).toString();
        }
        return string_377_;
    }

    public void hidefields() {
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
    }

    @Override
    public void init() {
        setBackground(new Color(0, 0, 0));
        offImage = createImage(800, 550);
        if (offImage != null)
            rd = (Graphics2D) offImage.getGraphics();
        rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        setLayout(null);
        slstage.setFont(new Font("Arial", 1, 13));
        slstage.add(rd, "Select a Stage...         ");
        slstage.setForeground(new Color(63, 80, 110));
        slstage.setBackground(new Color(209, 217, 230));
        srch.setFont(new Font("Arial", 1, 12));
        srch.setBackground(new Color(255, 255, 255));
        srch.setForeground(new Color(0, 0, 0));
        strtyp.setFont(new Font("Arial", 1, 12));
        strtyp.add(rd, "NormalRoad");
        strtyp.add(rd, "OffRoad");
        strtyp.setBackground(new Color(63, 80, 110));
        strtyp.setForeground(new Color(209, 217, 230));
        ptyp.setFont(new Font("Arial", 1, 12));
        ptyp.add(rd, "Roads");
        ptyp.add(rd, "Ramps");
        ptyp.add(rd, "Obstacles");
        ptyp.add(rd, "Checkpoint");
        ptyp.add(rd, "Fixing Hoop");
        ptyp.add(rd, "Trees");
        ptyp.add(rd, "Ground Pile");
        ptyp.setBackground(new Color(63, 80, 110));
        ptyp.setForeground(new Color(209, 217, 230));
        part.setFont(new Font("Arial", 1, 12));
        part.add(rd, "Halfpipe-Normal-Road Blend");
        part.setBackground(new Color(63, 80, 110));
        part.setForeground(new Color(209, 217, 230));
        fixh.setFont(new Font("Arial", 1, 12));
        fixh.setBackground(new Color(255, 255, 255));
        fixh.setForeground(new Color(0, 0, 0));
        mgen.setFont(new Font("Arial", 1, 12));
        mgen.setBackground(new Color(255, 255, 255));
        mgen.setForeground(new Color(0, 0, 0));
        pfog.setFont(new Font("Arial", 1, 12));
        pfog.setBackground(new Color(225, 225, 225));
        pfog.setForeground(new Color(0, 0, 0));
        nlaps.setFont(new Font("Arial", 1, 12));
        for (int i = 0; i < 15; i++)
            nlaps.add(rd, new StringBuilder().append(" ").append(i + 1).append(" ").toString());
        nlaps.setBackground(new Color(63, 80, 110));
        nlaps.setForeground(new Color(209, 217, 230));
        tracks.setFont(new Font("Arial", 1, 12));
        tracks.add(rd, "Select MOD Track");
        tracks.setForeground(new Color(63, 80, 110));
        tracks.setBackground(new Color(209, 217, 230));
        witho.setFont(new Font("Arial", 1, 12));
        witho.add(rd, "With other cars");
        witho.add(rd, "Alone");
        witho.setBackground(new Color(63, 80, 110));
        witho.setForeground(new Color(209, 217, 230));
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
        add(tnick);
        add(tpass);
        add(srch);
        add(fixh);
        add(mgen);
        add(pfog);
        hidefields();
    }

    @Override
    public boolean keyDown(final Event event, final int i) {
        if (focuson) {
            if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87 || i == 43 || i == 61)
                zoomi = true;
            if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83 || i == 45)
                zoomo = true;
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
        if (i == 42 || i == 10 || i == 56 || i == 119 || i == 87 || i == 43 || i == 61)
            zoomi = false;
        if (i == 47 || i == 8 || i == 50 || i == 115 || i == 83 || i == 45)
            zoomo = false;
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
                "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn",
                "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15",
                "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes",
                "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint",


                "sideoff",
                "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "tside", "launchpad", "thenet", "speedramp",
                "offhill", "slider", "uphill", "roll1", "roll2", "roll3", "roll4", "roll5", "roll6", "opile1", "opile2",
                "aircheckpoint", "tree1", "tree2", "tree3", "tree4", "tree5", "tree6", "tree7", "tree8", "cac1", "cac2",
                "cac3"//, "housetest"
        };
        try {
            final File file = new File("data/models.zip");
            final ZipInputStream zipinputstream = new ZipInputStream(new FileInputStream(file));
            ZipEntry zipentry = zipinputstream.getNextEntry();
            for (/**/; zipentry != null; zipentry = zipinputstream.getNextEntry()) {
                int i = -1;
                for (int i_176_ = 0; i_176_ < strings.length; i_176_++)
                    if (zipentry.getName().startsWith(strings[i_176_]))
                        i = i_176_;
                if (i != -1) {
                    int i_177_ = (int) zipentry.getSize();
                    final byte[] is = new byte[i_177_];
                    int i_178_ = 0;
                    int i_179_;
                    for (/**/; i_177_ > 0; i_177_ -= i_179_) {
                        i_179_ = zipinputstream.read(is, i_178_, i_177_);
                        i_178_ += i_179_;
                    }
                    bco[i] = new ContO(is, m, t);
                    for (int i_180_ = 0; i_180_ < bco[i].npl; i_180_++)
                        bco[i].p[i_180_].loadprojf();
                    //if (i == 31)
                    //	bco[i].elec = true;
                }
            }
            zipinputstream.close();
            bco[bumppart] = new ContO((int) (10000.0 * Math.random()), (int) pwd, (int) phd, m, t, 0, 0, 0);
        } catch (final Exception exception) {
            JOptionPane.showMessageDialog(null, new StringBuilder()
                    .append("Unable to load file 'data/models.zip'!\nError:\n").append(exception).toString(),
                    "Stage Maker", 1);
        }
        System.gc();
    }

    public void loadsettings() {
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
                    if (!suser.equals("Horaks"))
                        tnick.setText(suser);
                }
                bufferedreader.close();
            }
        } catch (final Exception exception) {
            /* empty */
        }
    }

    @Override
    public boolean mouseDown(final Event event, final int x, final int y) {
        mousdr = true;
        xm = x - apx;
        ym = y - apy;
        mousePressed = 1;
        requestFocus();
        focuson = true;
        return false;
    }

    @Override
    public boolean mouseDrag(final Event event, final int x, final int y) {
        mousdr = true;
        xm = x - apx;
        ym = y - apy;
        return false;
    }

    @Override
    public boolean mouseMove(final Event event, final int x, final int y) {
        xm = x - apx;
        ym = y - apy;
        if (xm > 620 && xm < 774 && ym > 0 && ym < 23) {
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
    public boolean mouseUp(final Event event, final int i, final int i_172_) {
        mousdr = false;
        xm = i - apx;
        ym = i_172_ - apy;
        if (mousePressed == 1)
            mousePressed = -1;
        if (onbtgame)
            Madness.game();
        return false;
    }

    public void movefield(final Component component, int i, int i_169_, final int i_170_, final int i_171_) {
        i += apx;
        i_169_ += apy;
        if (component.getX() != i || component.getY() != i_169_ || component.getWidth() != i_170_
                || component.getHeight() != i_171_)
            component.setBounds(i, i_169_, i_170_, i_171_);
    }

    public void newstage() {
        if (!srch.getText().equals("")) {
            final File file = new File(
                    new StringBuilder().append("mystages/").append(srch.getText()).append(".txt").toString());
            if (!file.exists()) {
                stagename = srch.getText();
                tstage = new StringBuilder()
                        .append("snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\r\nmountains(")
                        .append((int) (Math.random() * 100000.0)).append(")\r\nnlaps(5)\r\n\r\n").toString();
                //if (strtyp.getSelectedIndex() == 1)
                //	bstage = "set(48,0,0,250,0)\r\n";
                //else
                //	bstage = "set(47,0,0,250,0)\r\n";
                final StringBuilder stringbuilder = new StringBuilder();
                final StageMaker stagemaker_238_ = this;
                stagemaker_238_.bstage = stringbuilder.append(stagemaker_238_.bstage)
                        .append("\r\nmaxl(3,-7200,-4800)\r\nmaxb(3,-7200,-4800)\r\nmaxr(3,7200,-4800)\r\nmaxt(3,7200,-4800)\r\n")
                        .toString();
                savefile();
                strtyp.setVisible(false);
                srch.setVisible(false);
                sfase = 0;
                tabed = -2;
            } else
                JOptionPane.showMessageDialog(null,
                        "A stage with that name already exists, please choose another name!", "Stage Maker", 1);
        } else
            JOptionPane.showMessageDialog(null, "Please enter a stage name first!", "Stage Maker", 1);
    }

    public void openhlink() {
        Madness.openurl("http://www.needformadness.com/developer/");
    }

    public void openlink() {
        Madness.openurl("http://www.needformadness.com/developer/help.html");
    }

    public boolean ovbutton(final String string, final int i, final int i_387_) {
        rd.setFont(new Font("Arial", 0, 12));
        ftm = rd.getFontMetrics();
        if (string.equals("X") || string.equals("Download")) {
            rd.setFont(new Font("Arial", 1, 12));
            ftm = rd.getFontMetrics();
        }
        final int i_388_ = ftm.stringWidth(string);
        final int i_389_ = 4;
        boolean bool = false;
        boolean bool_390_ = false;
        if (Math.abs(xm - i) < i_388_ / 2 + 12 && Math.abs(ym - i_387_ + 5) < 10 && mousePressed == 1)
            bool = true;
        else
            bool = false;
        if (Math.abs(xm - i) < i_388_ / 2 + 12 && Math.abs(ym - i_387_ + 5) < 10 && mousePressed == -1) {
            mousePressed = 0;
            bool_390_ = true;
        }
        if (!bool) {
            rd.setColor(new Color(220, 220, 220));
            rd.fillRect(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i_388_ + 20, 25 - i_389_ * 2);
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ - (17 - i_389_));
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (18 - i_389_), i + i_388_ / 2 + 10, i_387_ - (18 - i_389_));
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i_388_ / 2 - 9, i_387_ - (19 - i_389_), i + i_388_ / 2 + 9, i_387_ - (19 - i_389_));
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i + i_388_ / 2 + 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ + 7 - i_389_);
            rd.drawLine(i + i_388_ / 2 + 11, i_387_ - (17 - i_389_), i + i_388_ / 2 + 11, i_387_ + 7 - i_389_);
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i + i_388_ / 2 + 12, i_387_ - (16 - i_389_), i + i_388_ / 2 + 12, i_387_ + 6 - i_389_);
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ + 7 - i_389_, i + i_388_ / 2 + 10, i_387_ + 7 - i_389_);
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ + 8 - i_389_, i + i_388_ / 2 + 10, i_387_ + 8 - i_389_);
            rd.setColor(new Color(200, 200, 200));
            rd.drawLine(i - i_388_ / 2 - 9, i_387_ + 9 - i_389_, i + i_388_ / 2 + 9, i_387_ + 9 - i_389_);
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i - i_388_ / 2 - 10, i_387_ + 7 - i_389_);
            rd.drawLine(i - i_388_ / 2 - 11, i_387_ - (17 - i_389_), i - i_388_ / 2 - 11, i_387_ + 7 - i_389_);
            rd.setColor(new Color(240, 240, 240));
            rd.drawLine(i - i_388_ / 2 - 12, i_387_ - (16 - i_389_), i - i_388_ / 2 - 12, i_387_ + 6 - i_389_);
            rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                rd.setColor(new Color(0, 64, 128));
            rd.drawString(string, i - i_388_ / 2, i_387_);
        } else {
            rd.setColor(new Color(220, 220, 220));
            rd.fillRect(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i_388_ + 20, 25 - i_389_ * 2);
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ - (17 - i_389_));
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (18 - i_389_), i + i_388_ / 2 + 10, i_387_ - (18 - i_389_));
            rd.drawLine(i - i_388_ / 2 - 9, i_387_ - (19 - i_389_), i + i_388_ / 2 + 9, i_387_ - (19 - i_389_));
            rd.setColor(new Color(247, 247, 247));
            rd.drawLine(i + i_388_ / 2 + 10, i_387_ - (17 - i_389_), i + i_388_ / 2 + 10, i_387_ + 7 - i_389_);
            rd.drawLine(i + i_388_ / 2 + 11, i_387_ - (17 - i_389_), i + i_388_ / 2 + 11, i_387_ + 7 - i_389_);
            rd.drawLine(i + i_388_ / 2 + 12, i_387_ - (16 - i_389_), i + i_388_ / 2 + 12, i_387_ + 6 - i_389_);
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ + 7 - i_389_, i + i_388_ / 2 + 10, i_387_ + 7 - i_389_);
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ + 8 - i_389_, i + i_388_ / 2 + 10, i_387_ + 8 - i_389_);
            rd.drawLine(i - i_388_ / 2 - 9, i_387_ + 9 - i_389_, i + i_388_ / 2 + 9, i_387_ + 9 - i_389_);
            rd.setColor(new Color(192, 192, 192));
            rd.drawLine(i - i_388_ / 2 - 10, i_387_ - (17 - i_389_), i - i_388_ / 2 - 10, i_387_ + 7 - i_389_);
            rd.drawLine(i - i_388_ / 2 - 11, i_387_ - (17 - i_389_), i - i_388_ / 2 - 11, i_387_ + 7 - i_389_);
            rd.drawLine(i - i_388_ / 2 - 12, i_387_ - (16 - i_389_), i - i_388_ / 2 - 12, i_387_ + 6 - i_389_);
            rd.setColor(new Color(0, 0, 0));
            if (string.equals("X"))
                rd.setColor(new Color(255, 0, 0));
            if (string.equals("Download"))
                rd.setColor(new Color(0, 64, 128));
            rd.drawString(string, i - i_388_ / 2 + 1, i_387_ + 1);
        }
        return bool_390_;
    }

    @Override
    public void paint(final Graphics graphics) {
        apx = getWidth() / 2 - 400;
        apy = getHeight() / 2 - 275;
        graphics.drawImage(offImage, apx, apy, this);
    }

    public void partobst() {
        part.removeAll();
        part.add(rd, "Spiky Pillars");
        part.add(rd, "Rail Doorway");
        part.add(rd, "The Net");
        part.add(rd, "Bump Slide");
        part.add(rd, "Offroad Dirt-Pile 1");
        part.add(rd, "Offroad Dirt-Pile 2");
    }

    public void partramps() {
        part.removeAll();
        part.add(rd, "Basic Ramp");
        part.add(rd, "Two-Way Ramp");
        part.add(rd, "Two-Way High-Low Ramp");
        part.add(rd, "Small Ramp");
        part.add(rd, "Crash Ramp");
        part.add(rd, "Big-Takeoff Ramp");
        part.add(rd, "Landing Ramp");
        part.add(rd, "Tunnel Side Ramp");
        part.add(rd, "Speed Ramp");
        part.add(rd, "Launch Pad Ramp");
        part.add(rd, "Offroad Bump Ramp");
        part.add(rd, "Offroad Ramp");
        part.add(rd, "Offroad Big Ramp");
        part.add(rd, "Offroad Hill Ramp");
        part.add(rd, "Offroad Big Hill Ramp");
        part.add(rd, "Halfpipe");
    }

    public void partrees() {
        part.removeAll();
        /*		part.add(rd, "Tree 1");
        		part.add(rd, "Tree 2");
        		part.add(rd, "Tree 3");
        		part.add(rd, "Tree 4");
        		part.add(rd, "Tree 5");
        		part.add(rd, "Palm Tree 1");
        		part.add(rd, "Palm Tree 2");
        		part.add(rd, "Palm Tree 3");
        		part.add(rd, "Cactus 1");
        		part.add(rd, "Cactus 2");
        		part.add(rd, "Cactus 3");
        		part.add(rd, "House test");*/
        part.add(rd, "T-Junction");
        part.add(rd, "X-Junction");
        part.add(rd, "Highway Straight");
        part.add(rd, "Highway Turn");
        part.add(rd, "Drawbridge");
        part.add(rd, "Tollbooth 1");
        part.add(rd, "Tollbooth 2");
        part.add(rd, "Highway Escape");
        part.add(rd, "Carrier Jump");
        part.add(rd, "Dock Straight");
        part.add(rd, "Dock Jump 1");
        part.add(rd, "Dock Jump 2");
        part.add(rd, "Dockinside");
        part.add(rd, "Dockoutside");
        part.add(rd, "Canyon Straight");
        part.add(rd, "Canyon End");
        part.add(rd, "Canyon Bridge");
        part.add(rd, "Canyon Edge Inside");
        part.add(rd, "Canyon Edge Outside");
        part.add(rd, "Canyon Top");
        part.add(rd, "Canyon Checkpoint");
        part.add(rd, "Canyon Entrance");
        part.add(rd, "Tunnel Straight");
        part.add(rd, "Tunnel Turn");
        part.add(rd, "Building Straight");
        part.add(rd, "Building Overpass");
        part.add(rd, "Supeshop");
        part.add(rd, "Turbo");
        part.add(rd, "understraight");
        part.add(rd, "underturn");
        part.add(rd, "underntrance");
        part.add(rd, "subwaystraight");
        part.add(rd, "subwaytrain");
        part.add(rd, "subwayturn");
        part.add(rd, "substation");
        part.add(rd, "subarea2");
        part.add(rd, "subarea3");
        part.add(rd, "subentrance");
        part.add(rd, "subarea1");
        part.add(rd, "subtrain");
        part.add(rd, "subtrain2");
        part.add(rd, "House 1"); //house0
        part.add(rd, "House 2"); //house1
        part.add(rd, "House 3"); //house2
        part.add(rd, "Condo 1");
        part.add(rd, "Condo 2");
        part.add(rd, "Skyscraper 1");
        part.add(rd, "Skyscraper 2");
        part.add(rd, "Skyscraper 3");
        part.add(rd, "warehouse1");
        part.add(rd, "citywall1");
        part.add(rd, "chainfence");
        part.add(rd, "desertwall");
        part.add(rd, "desertwallturn");
        part.add(rd, "waterroute");
        part.add(rd, "sewerjump");
        part.add(rd, "tree");
        part.add(rd, "streetlamp");
        part.add(rd, "hatchback");
        part.add(rd, "sedan");
        part.add(rd, "sports");
        part.add(rd, "coupe");
        part.add(rd, "super");
        part.add(rd, "dapigs");
        part.add(rd, "rdblkpigs");
        part.add(rd, "supapigs");
        part.add(rd, "Rdblkgate1");
        part.add(rd, "rdblkbarrier1");
        part.add(rd, "spikestrip");
        part.add(rd, "suspensionbridge");
        part.add(rd, "roofjump");
        part.add(rd, "urbanramp");
        part.add(rd, "urbanstraight");
        part.add(rd, "urbanX");
        part.add(rd, "canyonroadend2");
        part.add(rd, "Large Dumpster");
        part.add(rd, "urbanT");
        part.add(rd, "urbanTurn");
        part.add(rd, "urbanEnd");
        part.add(rd, "tunnelramp");
        part.add(rd, "grandstand");
        part.add(rd, "canyonntrance2");
        part.add(rd, "rocktotunnel");
        part.add(rd, "dirtWaterX");
        part.add(rd, "docksTurban");
        // ------------------ INCREMENT HERE FOR NEW PARTS
        // ------------------ THE NAME IN QUOTES IS THE NAME THAT APPEARS
    }

    public void partroads() {
        part.removeAll();
        part.add(rd, "NormalRoad");
        part.add(rd, "NormalRoad Turn");
        part.add(rd, "NormalRoad End");
        part.add(rd, "NormalRoad TwistedLeft");
        part.add(rd, "NormalRoad TwistedRight");
        part.add(rd, "NormalRoad Edged");
        part.add(rd, "NormalRoad-Raised Ramp");
        part.add(rd, "NormalRoad Raised");
        part.add(rd, "Normal-Off-Road Blend");
        part.add(rd, "OffRoad");
        part.add(rd, "OffRoad Turn");
        part.add(rd, "OffRoad End");
        part.add(rd, "OffRoad BumpyGreen");
        part.add(rd, "OffRoad-BumpySides Start");
        part.add(rd, "OffRoad BumpySides");
        part.add(rd, "Off-Halfpipe-Road Blend");
        part.add(rd, "HalfpipeRoad");
        part.add(rd, "HalfpipeRoad Turn");
        part.add(rd, "HalfpipeRoad-Ramp Filler");
        part.add(rd, "Halfpipe-Normal-Road Blend");
        part.add(rd, "Rollercoaster Start/End");
        part.add(rd, "Rollercoaster Road1");
        part.add(rd, "Rollercoaster Road2");
        part.add(rd, "Rollercoaster Road3");
        part.add(rd, "Rollercoaster Road4");
        part.add(rd, "Rollercoaster Road5");
    }

    public int py(final int i, final int i_343_, final int i_344_, final int i_345_) {
        return (int) Math.sqrt((i - i_343_) * (i - i_343_) + (i_344_ - i_345_) * (i_344_ - i_345_));
    }

    public int pyn(final int i, final int i_346_, final int i_347_, final int i_348_) {
        return (i - i_346_) / 100 * ((i - i_346_) / 100) + (i_347_ - i_348_) / 100 * ((i_347_ - i_348_) / 100);
    }

    public void readstage(final int i) {
        errd = 0;
        trackname = "";
        t.nt = 0;
        nob = 0;
        xnob = 0;
        cp.n = 0;
        cp.nsp = 0;
        cp.fn = 0;
        cp.haltall = false;
        cp.wasted = 0;
        cp.catchfin = 0;
        m.ground = 250;
        m.lightson = false;
        if (i == 0) {
            m.snap[0] = 0;
            m.snap[1] = 0;
            m.snap[2] = 0;
        }
        if (i == 3) {
            tstage = "";
            bstage = "";
        }
        String string = bstage;
        if (i == 1 || i == 2)
            string = new StringBuilder().append("").append(tstage).append("\r\n").append(bstage).append("").toString();
        int i_181_ = 0;
        int i_182_ = 100;
        int i_183_ = 0;
        int i_184_ = 100;
        boolean bool = true;
        boolean bool_185_ = true;
        String string_186_ = "";
        try {
            DataInputStream datainputstream;
            if (i == 3) {
                final File file = new File(
                        new StringBuilder().append("mystages/").append(stagename).append(".txt").toString());
                datainputstream = new DataInputStream(new FileInputStream(file));
                nundo = 0;
            } else
                datainputstream = new DataInputStream(new ByteArrayInputStream(string.getBytes()));
            String string_187_;
            while ((string_187_ = datainputstream.readLine()) != null) {
                string_186_ = new StringBuilder().append("").append(string_187_.trim()).toString();
                if (string_186_.startsWith("sky")) {
                    csky[0] = getint("sky", string_186_, 0);
                    csky[1] = getint("sky", string_186_, 1);
                    csky[2] = getint("sky", string_186_, 2);
                    m.setsky(csky[0], csky[1], csky[2]);
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_188_ = this;
                        stagemaker_188_.tstage = stringbuilder.append(stagemaker_188_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("ground")) {
                    cgrnd[0] = getint("ground", string_186_, 0);
                    cgrnd[1] = getint("ground", string_186_, 1);
                    cgrnd[2] = getint("ground", string_186_, 2);
                    m.setgrnd(cgrnd[0], cgrnd[1], cgrnd[2]);
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_189_ = this;
                        stagemaker_189_.tstage = stringbuilder.append(stagemaker_189_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("polys")) {
                    m.setpolys(getint("polys", string_186_, 0), getint("polys", string_186_, 1),
                            getint("polys", string_186_, 2));
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_190_ = this;
                        stagemaker_190_.tstage = stringbuilder.append(stagemaker_190_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("fog")) {
                    cfade[0] = getint("fog", string_186_, 0);
                    cfade[1] = getint("fog", string_186_, 1);
                    cfade[2] = getint("fog", string_186_, 2);
                    m.setfade(cfade[0], cfade[1], cfade[2]);
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_191_ = this;
                        stagemaker_191_.tstage = stringbuilder.append(stagemaker_191_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("texture")) {
                    texture[0] = getint("texture", string_186_, 0);
                    texture[1] = getint("texture", string_186_, 1);
                    texture[2] = getint("texture", string_186_, 2);
                    texture[3] = getint("texture", string_186_, 3);
                    m.setexture(texture[0], texture[1], texture[2], texture[3]);
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_192_ = this;
                        stagemaker_192_.tstage = stringbuilder.append(stagemaker_192_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("clouds")) {
                    cldd[0] = getint("clouds", string_186_, 0);
                    cldd[1] = getint("clouds", string_186_, 1);
                    cldd[2] = getint("clouds", string_186_, 2);
                    cldd[3] = getint("clouds", string_186_, 3);
                    cldd[4] = getint("clouds", string_186_, 4);
                    m.setcloads(cldd[0], cldd[1], cldd[2], cldd[3], cldd[4]);
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_193_ = this;
                        stagemaker_193_.tstage = stringbuilder.append(stagemaker_193_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (i != 2 && string_186_.startsWith("snap")) {
                    m.setsnap(getint("snap", string_186_, 0), getint("snap", string_186_, 1),
                            getint("snap", string_186_, 2));
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_194_ = this;
                        stagemaker_194_.tstage = stringbuilder.append(stagemaker_194_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("density")) {
                    m.fogd = (getint("density", string_186_, 0) + 1) * 2 - 1;
                    if (m.fogd < 1)
                        m.fogd = 1;
                    if (m.fogd > 30)
                        m.fogd = 30;
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_195_ = this;
                        stagemaker_195_.tstage = stringbuilder.append(stagemaker_195_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("mountains")) {
                    m.mgen = getint("mountains", string_186_, 0);
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_196_ = this;
                        stagemaker_196_.tstage = stringbuilder.append(stagemaker_196_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("fadefrom")) {
                    m.fadfrom(getint("fadefrom", string_186_, 0));
                    origfade = m.fade[0];
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_197_ = this;
                        stagemaker_197_.tstage = stringbuilder.append(stagemaker_197_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("lightson")) {
                    m.lightson = true;
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_198_ = this;
                        stagemaker_198_.tstage = stringbuilder.append(stagemaker_198_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("nlaps")) {
                    cp.nlaps = getint("nlaps", string_186_, 0);
                    if (cp.nlaps < 1)
                        cp.nlaps = 1;
                    if (cp.nlaps > 15)
                        cp.nlaps = 15;
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_199_ = this;
                        stagemaker_199_.tstage = stringbuilder.append(stagemaker_199_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("soundtrack")) {
                    trackname = getstring("soundtrack", string_186_, 0);
                    trackvol = getint("soundtrack", string_186_, 1);
                    tracksize = getint("soundtrack", string_186_, 2);
                    if (i == 3) {
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_200_ = this;
                        stagemaker_200_.tstage = stringbuilder.append(stagemaker_200_.tstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("set")) {
                    int i_201_ = getint("set", string_186_, 0);
                    if (i_201_ >= 10 && i_201_ <= 25)
                        m.loadnew = true;
                    i_201_ -= 10;
                    co[nob] = new ContO(bco[i_201_], getint("set", string_186_, 1), getint("set", string_186_, 3),
                            getint("set", string_186_, 2), getint("set", string_186_, 4));
                    co[nob].roofat = getint("set", string_186_, 4);
                    co[nob].colok = i_201_;
                    if (string_186_.indexOf(")p") != -1) {
                        cp.x[cp.n] = getint("set", string_186_, 1);
                        cp.z[cp.n] = getint("set", string_186_, 2);
                        cp.y[cp.n] = 0;
                        cp.typ[cp.n] = 0;
                        if (string_186_.indexOf(")pt") != -1)
                            cp.typ[cp.n] = -1;
                        if (string_186_.indexOf(")pr") != -1)
                            cp.typ[cp.n] = -2;
                        if (string_186_.indexOf(")po") != -1)
                            cp.typ[cp.n] = -3;
                        if (string_186_.indexOf(")ph") != -1)
                            cp.typ[cp.n] = -4;
                        cp.n++;
                    }
                    xnob++;
                    nob++;
                    if (i == 3) {
                        if (bool_185_) {
                            final StringBuilder stringbuilder = new StringBuilder();
                            final StageMaker stagemaker_202_ = this;
                            stagemaker_202_.bstage = stringbuilder.append(stagemaker_202_.bstage).append("\r\n")
                                    .toString();
                            bool_185_ = false;
                        }
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_203_ = this;
                        stagemaker_203_.bstage = stringbuilder.append(stagemaker_203_.bstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                    if (m.loadnew)
                        m.loadnew = false;
                }
                if (string_186_.startsWith("chk")) {
                    int i_204_ = getint("chk", string_186_, 0);
                    i_204_ -= 10;
                    //int i_205_ = m.ground - bco[i_204_].grat;
                    //if (i_204_ == 54)
                    //	i_205_ = getint("chk", string_186_, 4);
                    co[nob] = new ContO(bco[i_204_], getint("chk", string_186_, 1), getint("chk", string_186_, 3),
                            getint("set", string_186_, 2), getint("chk", string_186_, 4));
                    co[nob].roofat = getint("chk", string_186_, 4);
                    co[nob].colok = i_204_;
                    cp.x[cp.n] = getint("chk", string_186_, 1);
                    cp.z[cp.n] = getint("chk", string_186_, 2);
                    cp.y[cp.n] = getint("chk", string_186_, 3);
                    if (getint("chk", string_186_, 3) == 0)
                        cp.typ[cp.n] = 1;
                    else
                        cp.typ[cp.n] = 2;
                    cp.pcs = cp.n;
                    cp.n++;
                    co[nob].checkpoint = cp.nsp + 1;
                    if (string_186_.indexOf(")r") != -1)
                        co[nob].wh = cp.nsp + 1;
                    cp.nsp++;
                    xnob++;
                    nob++;
                    if (i == 3) {
                        if (bool_185_) {
                            final StringBuilder stringbuilder = new StringBuilder();
                            final StageMaker stagemaker_206_ = this;
                            stagemaker_206_.bstage = stringbuilder.append(stagemaker_206_.bstage).append("\r\n")
                                    .toString();
                            bool_185_ = false;
                        }
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_207_ = this;
                        stagemaker_207_.bstage = stringbuilder.append(stagemaker_207_.bstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("fix")) {
                    int i_208_ = getint("fix", string_186_, 0);
                    i_208_ -= 10;
                    co[nob] = new ContO(bco[i_208_], getint("fix", string_186_, 1), getint("fix", string_186_, 3),
                            getint("fix", string_186_, 2), getint("fix", string_186_, 4));
                    co[nob].roofat = getint("fix", string_186_, 4);
                    co[nob].colok = i_208_;
                    cp.fx[cp.fn] = getint("fix", string_186_, 1);
                    cp.fz[cp.fn] = getint("fix", string_186_, 2);
                    cp.fy[cp.fn] = getint("fix", string_186_, 3);
                    //co[nob].elec = true;
                    if (getint("fix", string_186_, 4) != 0) {
                        cp.roted[cp.fn] = true;
                        co[nob].roted = true;
                    } else
                        cp.roted[cp.fn] = false;
                    if (string_186_.indexOf(")s") != -1)
                        cp.special[cp.fn] = true;
                    else
                        cp.special[cp.fn] = false;
                    cp.fn++;
                    xnob++;
                    nob++;
                    if (i == 3) {
                        if (bool_185_) {
                            final StringBuilder stringbuilder = new StringBuilder();
                            final StageMaker stagemaker_209_ = this;
                            stagemaker_209_.bstage = stringbuilder.append(stagemaker_209_.bstage).append("\r\n")
                                    .toString();
                            bool_185_ = false;
                        }
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_210_ = this;
                        stagemaker_210_.bstage = stringbuilder.append(stagemaker_210_.bstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("pile")) {
                    co[nob] = new ContO(getint("pile", string_186_, 0), getint("pile", string_186_, 1),
                            getint("pile", string_186_, 2), m, t, getint("pile", string_186_, 3),
                            getint("pile", string_186_, 4), m.ground);
                    co[nob].srz = getint("pile", string_186_, 0);
                    co[nob].srx = getint("pile", string_186_, 1);
                    co[nob].sry = getint("pile", string_186_, 2);
                    co[nob].colok = bumppart;
                    xnob++;
                    nob++;
                    if (i == 3) {
                        if (bool_185_) {
                            final StringBuilder stringbuilder = new StringBuilder();
                            final StageMaker stagemaker_211_ = this;
                            stagemaker_211_.bstage = stringbuilder.append(stagemaker_211_.bstage).append("\r\n")
                                    .toString();
                            bool_185_ = false;
                        }
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_212_ = this;
                        stagemaker_212_.bstage = stringbuilder.append(stagemaker_212_.bstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("maxr")) {
                    final int i_213_ = getint("maxr", string_186_, 0);
                    final int i_214_ = getint("maxr", string_186_, 1);
                    i_181_ = i_214_;
                    final int i_215_ = getint("maxr", string_186_, 2);
                    for (int i_216_ = 0; i_216_ < i_213_; i_216_++) {
                        co[nob] = new ContO(bco[29], i_214_, m.ground - bco[29].grat, i_216_ * 4800 + i_215_, 0);
                        if (i == 0)
                            xnob++;
                        else
                            nob++;
                    }
                    if (i == 3) {
                        if (bool) {
                            final StringBuilder stringbuilder = new StringBuilder();
                            final StageMaker stagemaker_217_ = this;
                            stagemaker_217_.bstage = stringbuilder.append(stagemaker_217_.bstage).append("\r\n")
                                    .toString();
                            bool = false;
                        }
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_218_ = this;
                        stagemaker_218_.bstage = stringbuilder.append(stagemaker_218_.bstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("maxl")) {
                    final int i_219_ = getint("maxl", string_186_, 0);
                    final int i_220_ = getint("maxl", string_186_, 1);
                    i_182_ = i_220_;
                    final int i_221_ = getint("maxl", string_186_, 2);
                    for (int i_222_ = 0; i_222_ < i_219_; i_222_++) {
                        co[nob] = new ContO(bco[29], i_220_, m.ground - bco[29].grat, i_222_ * 4800 + i_221_, 180);
                        if (i == 0)
                            xnob++;
                        else
                            nob++;
                    }
                    if (i == 3) {
                        if (bool) {
                            final StringBuilder stringbuilder = new StringBuilder();
                            final StageMaker stagemaker_223_ = this;
                            stagemaker_223_.bstage = stringbuilder.append(stagemaker_223_.bstage).append("\r\n")
                                    .toString();
                            bool = false;
                        }
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_224_ = this;
                        stagemaker_224_.bstage = stringbuilder.append(stagemaker_224_.bstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("maxt")) {
                    final int i_225_ = getint("maxt", string_186_, 0);
                    final int i_226_ = getint("maxt", string_186_, 1);
                    i_183_ = i_226_;
                    final int i_227_ = getint("maxt", string_186_, 2);
                    for (int i_228_ = 0; i_228_ < i_225_; i_228_++) {
                        co[nob] = new ContO(bco[29], i_228_ * 4800 + i_227_, m.ground - bco[29].grat, i_226_, 90);
                        if (i == 0)
                            xnob++;
                        else
                            nob++;
                    }
                    if (i == 3) {
                        if (bool) {
                            final StringBuilder stringbuilder = new StringBuilder();
                            final StageMaker stagemaker_229_ = this;
                            stagemaker_229_.bstage = stringbuilder.append(stagemaker_229_.bstage).append("\r\n")
                                    .toString();
                            bool = false;
                        }
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_230_ = this;
                        stagemaker_230_.bstage = stringbuilder.append(stagemaker_230_.bstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
                if (string_186_.startsWith("maxb")) {
                    final int i_231_ = getint("maxb", string_186_, 0);
                    final int i_232_ = getint("maxb", string_186_, 1);
                    i_184_ = i_232_;
                    final int i_233_ = getint("maxb", string_186_, 2);
                    for (int i_234_ = 0; i_234_ < i_231_; i_234_++) {
                        co[nob] = new ContO(bco[29], i_234_ * 4800 + i_233_, m.ground - bco[29].grat, i_232_, -90);
                        if (i == 0)
                            xnob++;
                        else
                            nob++;
                    }
                    if (i == 3) {
                        if (bool) {
                            final StringBuilder stringbuilder = new StringBuilder();
                            final StageMaker stagemaker_235_ = this;
                            stagemaker_235_.bstage = stringbuilder.append(stagemaker_235_.bstage).append("\r\n")
                                    .toString();
                            bool = false;
                        }
                        final StringBuilder stringbuilder = new StringBuilder();
                        final StageMaker stagemaker_236_ = this;
                        stagemaker_236_.bstage = stringbuilder.append(stagemaker_236_.bstage).append("")
                                .append(string_186_).append("\r\n").toString();
                    }
                }
            }
            datainputstream.close();
            m.newpolys(i_182_, i_181_ - i_182_, i_184_, i_183_ - i_184_, t, nob);
            m.newclouds(i_182_, i_181_, i_184_, i_183_);
            m.newmountains(i_182_, i_181_, i_184_, i_183_);
            m.newstars();
        } catch (final Exception exception) {
            System.out.println(new StringBuilder().append("Error in stage ").append(stagename).toString());
            System.out.println(new StringBuilder().append("").append(exception).toString());
            System.out.println(new StringBuilder().append("At line: ").append(string_186_).toString());
            errd = 6;
            if (cp.fn >= 5) // file name size????
                errd = 5;
            if (t.nt >= 670000) // trackers limit
                errd = 1;
            if (cp.n >= 10000) // )p etc limit
                errd = 2;
            if (nob >= 10000) // part limit
                errd = 4;
        }
        if (m.nrw * m.ncl >= 16000)
            errd = 3;
        if (xnob >= 10000)
            errd = 4;
        /*if (i == 3 && bstage.indexOf("set(47,0,0,250,0)") == -1 && bstage.indexOf("set(48,0,0,250,0)") == -1) {
        	final StringBuilder stringbuilder = new StringBuilder();
        	final StageMaker stagemaker_237_ = this;
        	stagemaker_237_.bstage = stringbuilder.append(stagemaker_237_.bstage).append("set(47,0,0,250,0)\r\n")
        			.toString();
        }*/
    }

    public void removesp() {
        if (nundo < 5000) {
            undos[nundo] = bstage;
            nundo++;
        }
        String string = "";
        System.out.println("roof: " + co[esp].roofat);
        if (!floats) {
            if (co[esp].colok != 30 && co[esp].colok != 31 && co[esp].colok != 32 && co[esp].colok != bumppart)
                string = new StringBuilder().append("set(").append(co[esp].colok + 10).append(",").append(co[esp].x)
                        .append(",").append(co[esp].z).append(",").append(co[esp].roofat).append(")").toString();
            if (co[esp].colok == 31)
                string = new StringBuilder().append("fix(").append(co[esp].colok + 10).append(",").append(co[esp].x)
                        .append(",").append(co[esp].z).append(",").append(co[esp].y).append(",").append(co[esp].roofat)
                        .append(")").toString();
            if (co[esp].colok == 30 || co[esp].colok == 32)
                string = new StringBuilder().append("chk(").append(co[esp].colok + 10).append(",").append(co[esp].x)
                        .append(",").append(co[esp].z).append(",").append(co[esp].roofat).append(")").toString();
            if (co[esp].colok == 54)
                string = new StringBuilder().append("chk(").append(co[esp].colok + 10).append(",").append(co[esp].x)
                        .append(",").append(co[esp].z).append(",").append(co[esp].roofat).append(",").append(co[esp].y)
                        .append(")").toString();
            if (co[esp].colok == bumppart)
                string = new StringBuilder().append("pile(").append(co[esp].srz).append(",").append(co[esp].srx)
                        .append(",").append(co[esp].sry).append(",").append(co[esp].x).append(",").append(co[esp].z)
                        .append(")").toString();
        } else {
            if (co[esp].colok != 30 && co[esp].colok != 31 && co[esp].colok != 32 && co[esp].colok != bumppart)
                string = new StringBuilder().append("set(").append(co[esp].colok + 10).append(",").append(co[esp].x)
                        .append(",").append(co[esp].z).append(",").append(co[esp].y).append(",").append(co[esp].roofat)
                        .append(")").toString();
            if (co[esp].colok == 31)
                string = new StringBuilder().append("fix(").append(co[esp].colok + 10).append(",").append(co[esp].x)
                        .append(",").append(co[esp].z).append(",").append(co[esp].y).append(",").append(co[esp].roofat)
                        .append(")").toString();
            if (co[esp].colok == 30 || co[esp].colok == 32)
                string = new StringBuilder().append("chk(").append(co[esp].colok + 10).append(",").append(co[esp].x)
                        .append(",").append(co[esp].z).append(",").append(co[esp].y).append(",").append(co[esp].roofat)
                        .append(")").toString();
            if (co[esp].colok == 54)
                string = new StringBuilder().append("chk(").append(co[esp].colok + 10).append(",").append(co[esp].x)
                        .append(",").append(co[esp].z).append(",").append(co[esp].y).append(",").append(co[esp].roofat)
                        .append(")").toString();
            if (co[esp].colok == bumppart)
                string = new StringBuilder().append("pile(").append(co[esp].srz).append(",").append(co[esp].srx)
                        .append(",").append(co[esp].sry).append(",").append(co[esp].x).append(",").append(co[esp].z)
                        .append(")").toString();
        }
        final int i = bstage.indexOf(string);
        int i_166_ = i + string.length();
        int i_167_ = -1;
        int i_168_ = bstage.indexOf("set", i_166_);
        if (i_168_ != -1)
            i_167_ = i_168_;
        i_168_ = bstage.indexOf("chk", i_166_);
        if (i_168_ != -1 && i_168_ < i_167_)
            i_167_ = i_168_;
        i_168_ = bstage.indexOf("fix", i_166_);
        if (i_168_ != -1 && i_168_ < i_167_)
            i_167_ = i_168_;
        if (i_167_ == -1) {
            i_167_ = bstage.indexOf("\r\n", i_166_);
            if (i_167_ != -1)
                i_167_++;
        }
        if (i_167_ != -1)
            i_166_ = i_167_;
        if (i != -1)
            bstage = new StringBuilder().append("").append(bstage.substring(0, i)).append("")
                    .append(bstage.substring(i_166_, bstage.length())).append("").toString();
        readstage(0);
    }

    public void renstage(final String string) {
        if (string.equals(""))
            JOptionPane.showMessageDialog(null, "Please Enter a New Stage Name!\n", "Stage Maker", 1);
        else
            try {
                final File file = new File(
                        new StringBuilder().append("mystages/").append(stagename).append(".txt").toString());
                final File file_329_ = new File(
                        new StringBuilder().append("mystages/").append(string).append(".txt").toString());
                if (file.renameTo(file_329_)) {
                    stagename = string;
                    sfase = 0;
                    hidefields();
                    tabed = -2;
                } else
                    JOptionPane.showMessageDialog(null,
                            new StringBuilder().append("Unable to rename stage to: '").append(string)
                                    .append("', possible reason: stage name already used!\n").toString(),
                            "Stage Maker", 1);
            } catch (final Exception exception) {
                JOptionPane.showMessageDialog(null, new StringBuilder()
                        .append("Unable to rename file! Error Deatials:\n").append(exception).toString(), "Stage Maker",
                        1);
            }
    }

    public void rot(final int[] is, final int[] is_334_, final int i, final int i_335_, final int i_336_,
            final int i_337_) {
        if (i_336_ != 0)
            for (int i_338_ = 0; i_338_ < i_337_; i_338_++) {
                final int i_339_ = is[i_338_];
                final int i_340_ = is_334_[i_338_];
                is[i_338_] = i + (int) ((i_339_ - i) * m.cos(i_336_) - (i_340_ - i_335_) * m.sin(i_336_));
                is_334_[i_338_] = i_335_
                        + (int) ((i_339_ - i) * m.sin(i_336_) + (i_340_ - i_335_) * m.cos(i_336_));
            }
    }

    @Override
    public void run() {
        thredo.setPriority(10);
        btgame[0] = getImage("data/backtogame1.gif");
        btgame[1] = getImage("data/backtogame2.gif");
        logo = getImage("data/stagemakerlogo.gif");
        for (int i = 0; i < 2; i++) {
            su[i] = getImage(new StringBuilder().append("data/su").append(i + 1).append(".gif").toString());
            sl[i] = getImage(new StringBuilder().append("data/sl").append(i + 1).append(".gif").toString());
            sd[i] = getImage(new StringBuilder().append("data/sd").append(i + 1).append(".gif").toString());
            sr[i] = getImage(new StringBuilder().append("data/sr").append(i + 1).append(".gif").toString());
            zi[i] = getImage(new StringBuilder().append("data/zi").append(i + 1).append(".gif").toString());
            zo[i] = getImage(new StringBuilder().append("data/zo").append(i + 1).append(".gif").toString());
        }
        loadbase();
        loadsettings();
        if (Madness.testdrive != 0) {
            if (Madness.testcar.equals("Failx12")) {
                JOptionPane.showMessageDialog(null,
                        "Failed to load stage! Please make sure stage is saved properly before Test Drive.",
                        "Stage Maker", 1);
                thredo.stop();
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
        }
        requestFocus();
        // my code to print the mouse pos every second
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("x: " + ((xm - 505) * (Math.abs(sy) / m.focus_point) + sx));
                    System.out.println("z: " + ((290 - ym) * (Math.abs(sy) / m.focus_point) + sz));
                    System.out.println("y: " + (m.ground - bco[selectedPart].grat));
                    System.out.println("rot: " + (rot + adrot));
                    try {
                        sleep(1000L); //time in milisseconds it will wait before printing again
                                      //set this too low and the game will lag like hell
                    } catch (final InterruptedException e) {
                        /**/}
                }
            }
        }.start();

        while (!exwist) {
            rd.setColor(new Color(225, 225, 225));
            rd.fillRect(0, 25, 800, 525);
            rd.setColor(new Color(0, 0, 0));
            if (tab != tabed)
                hidefields();
            if (tab == 0) {
                if (tabed != tab) {
                    slstage.removeAll();
                    slstage.maxl = 360;
                    slstage.add(rd, "Select a Stage                      ");
                    final String[] strings = new File("mystages/").list();
                    if (strings != null)
                        for (int i = 0; i < strings.length; i++)
                            if (strings[i].toLowerCase().endsWith(".txt"))
                                slstage.add(rd, strings[i].substring(0, strings[i].length() - 4));
                    if (stagename.equals(""))
                        slstage.select(0);
                    else {
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
                rd.drawImage(logo, 261, 35, null);
                if (xm > 261 && xm < 538 && ym > 35 && ym < 121) {
                    if (mouseon == -1) {
                        mouseon = 3;
                        setCursor(new Cursor(12));
                    }
                } else if (mouseon == 3) {
                    mouseon = -1;
                    setCursor(new Cursor(0));
                }
                if (mouseon == 3 && mousePressed == -1)
                    openhlink();
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                if (xm > 200 && xm < 550 && ym > 467 && ym < 504) {
                    if (mouseon == -1) {
                        mouseon = 2;
                        setCursor(new Cursor(12));
                    }
                } else if (mouseon == 2) {
                    mouseon = -1;
                    setCursor(new Cursor(0));
                }
                if (mouseon == 2)
                    rd.setColor(new Color(0, 64, 128));
                else
                    rd.setColor(new Color(0, 0, 0));
                rd.drawString("For the Stage Maker Homepage, Development Center and Forums :",
                        400 - ftm.stringWidth("For the Stage Maker Homepage, Development Center and Forums :") / 2,
                        480);
                rd.setColor(new Color(0, 128, 255));
                String string = "http://www.needformadness.com/developer/";
                rd.drawString(string, 400 - ftm.stringWidth(string) / 2, 500);
                if (mouseon == 2)
                    rd.setColor(new Color(0, 128, 255));
                else
                    rd.setColor(new Color(0, 64, 128));
                rd.drawLine(400 - ftm.stringWidth(string) / 2, 501, 400 + ftm.stringWidth(string) / 2, 501);
                if (mouseon == 2 && mousePressed == -1)
                    openhlink();
                final int i = -110;
                if (xm > 150 && xm < 600 && ym > 467 + i && ym < 504 + i) {
                    if (mouseon == -1) {
                        mouseon = 1;
                        setCursor(new Cursor(12));
                    }
                } else if (mouseon == 1) {
                    mouseon = -1;
                    setCursor(new Cursor(0));
                }
                if (mouseon == 1)
                    rd.setColor(new Color(0, 64, 128));
                else
                    rd.setColor(new Color(0, 0, 0));
                rd.drawString("For help and a detailed step by step description on how to use the Stage Maker :",
                        400 - ftm.stringWidth(
                                "For help and a detailed step by step description on how to use the Stage Maker :") / 2,
                        480 + i);
                rd.setColor(new Color(0, 128, 255));
                string = "http://www.needformadness.com/developer/help.html";
                rd.drawString(string, 400 - ftm.stringWidth(string) / 2, 500 + i);
                if (mouseon == 1)
                    rd.setColor(new Color(0, 128, 255));
                else
                    rd.setColor(new Color(0, 64, 128));
                rd.drawLine(400 - ftm.stringWidth(string) / 2, 501 + i, 400 + ftm.stringWidth(string) / 2, 501 + i);
                if (mouseon == 1 && mousePressed == -1)
                    openlink();
                final int i_0_ = -60;
                final int i_1_ = 70;
                rd.setColor(new Color(0, 0, 0));
                rd.drawRect(227 - i_1_, 194 + i_0_, 346 + i_1_ * 2, 167 + i_1_ / 5);
                if (sfase == 0) {
                    rd.drawString("Select Stage to Edit", 400 - ftm.stringWidth("Select Stage to Edit") / 2,
                            230 + i_0_);
                    slstage.move(220, 240 + i_0_);
                    if (slstage.getWidth() != 360)
                        slstage.setSize(360, 21);
                    if (!slstage.isShowing())
                        slstage.setVisible(true);
                    if (button("    Make new Stage    ", 400, 296 + i_0_, 0, true)) {
                        srch.setText("");
                        slstage.setVisible(false);
                        sfase = 1;
                    }
                    if (button("     Rename Stage     ", 325, 336 + i_0_, 0, false))
                        if (!stagename.equals("")) {
                            slstage.setVisible(false);
                            srch.setText(stagename);
                            sfase = 2;
                        } else
                            JOptionPane.showMessageDialog(null, "Please select a stage to rename first.", "Stage Maker",
                                    1);
                    if (button("      Delete Stage      ", 475, 336 + i_0_, 0, false))
                        if (!stagename.equals("")) {
                            if (JOptionPane.showConfirmDialog(null,
                                    new StringBuilder()
                                            .append("Are you sure you want to permanently delete this stage?\n\n")
                                            .append(stagename).append("\n\n").toString(),
                                    "Stage Maker", 0) == 0)
                                delstage(stagename);
                        } else
                            JOptionPane.showMessageDialog(null, "Please select a stage to delete first.", "Stage Maker",
                                    1);
                    if (slstage.getSelectedIndex() != 0) {
                        if (!stagename.equals(slstage.getSelectedItem())) {
                            stagename = slstage.getSelectedItem();
                            readstage(3);
                            sx = 0;
                            sz = 1500;
                            sy = -10000;
                            requestFocus();
                        }
                    } else
                        stagename = "";
                }
                if (sfase == 1) {
                    rd.drawString("Make a new Stage", 400 - ftm.stringWidth("Make a new Stage") / 2, 220 + i_0_);
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.drawString("New stage name :", 200, 246 + i_0_);
                    movefield(srch, 310, 231 + i_0_, 290, 23);
                    if (!srch.isShowing()) {
                        srch.setVisible(true);
                        srch.requestFocus();
                    }
                    fixtext(srch);
                    rd.drawString("Starting line type :", 293, 272 + i_0_);
                    strtyp.move(408, 256 + i_0_);
                    if (!strtyp.isShowing())
                        strtyp.setVisible(true);
                    if (button("    Make Stage    ", 400, 311 + i_0_, 0, true))
                        newstage();
                    if (button("  Cancel  ", 400, 351 + i_0_, 0, false)) {
                        strtyp.setVisible(false);
                        srch.setVisible(false);
                        sfase = 0;
                    }
                }
                if (sfase == 2) {
                    rd.drawString(
                            new StringBuilder().append("Rename Stage :  ").append(stagename).append("").toString(),
                            400 - ftm.stringWidth(new StringBuilder().append("Rename Stage :  ").append(stagename)
                                    .append("").toString()) / 2,
                            230 + i_0_);
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.drawString("New name :", 218, 266 + i_0_);
                    if (!srch.isShowing()) {
                        srch.setVisible(true);
                        srch.requestFocus();
                    }
                    movefield(srch, 292, 251 + i_0_, 290, 23);
                    fixtext(srch);
                    if (button("    Rename Stage    ", 400, 306 + i_0_, 0, true))
                        renstage(srch.getText());
                    if (button("  Cancel  ", 400, 346 + i_0_, 0, false)) {
                        srch.setVisible(false);
                        sfase = 0;
                    }
                }
            }
            if (tab == 1) {
                if (tabed != tab) {
                    m.trk = 2;
                    readstage(0);
                    if (selectedPartType == PART_ROADS) // PART ROADS
                        partroads();
                    if (selectedPartType == PART_RAMPS) // PART RAMPS
                        partramps();
                    if (selectedPartType == PART_OBSTACLES) // PART OBSTACLES
                        partobst();
                    if (selectedPartType == PART_TREES) // PART TREES
                        partrees();
                    onoff = false;
                    setCursor(new Cursor(0));
                    setcur = false;
                    epart = false;
                    arrng = false;
                    if (nob == 1) {
                        selectedPartType = 0;
                        if (co[0].colok == 38)
                            selectedMenuPart = 9;
                        else
                            selectedMenuPart = 0;
                    }
                    mouseon = -1;
                }
                if (selectedPartType == PART_ROADS) {
                    if (selectedMenuPart == 0)
                        selectedPart = 0;
                    if (selectedMenuPart == 1)
                        selectedPart = 4;
                    if (selectedMenuPart == 2)
                        selectedPart = 13;
                    if (selectedMenuPart == 3)
                        selectedPart = 3;
                    if (selectedMenuPart == 4)
                        selectedPart = 2;
                    if (selectedMenuPart == 5)
                        selectedPart = 1;
                    if (selectedMenuPart == 6)
                        selectedPart = 35;
                    if (selectedMenuPart == 7)
                        selectedPart = 36;
                    if (selectedMenuPart == 8)
                        selectedPart = 10;
                    if (selectedMenuPart == 9)
                        selectedPart = 5;
                    if (selectedMenuPart == 10)
                        selectedPart = 7;
                    if (selectedMenuPart == 11)
                        selectedPart = 14;
                    if (selectedMenuPart == 12)
                        selectedPart = 6;
                    if (selectedMenuPart == 13)
                        selectedPart = 34;
                    if (selectedMenuPart == 14)
                        selectedPart = 33;
                    if (selectedMenuPart == 15)
                        selectedPart = 11;
                    if (selectedMenuPart == 16)
                        selectedPart = 8;
                    if (selectedMenuPart == 17)
                        selectedPart = 9;
                    if (selectedMenuPart == 18)
                        selectedPart = 15;
                    if (selectedMenuPart == 19)
                        selectedPart = 12;
                    /*if (selectedMenuPart == 20)
                    	selectedPart = 46;
                    if (selectedMenuPart == 21)
                    	selectedPart = 47;
                    if (selectedMenuPart == 22)
                    	selectedPart = 50;
                    if (selectedMenuPart == 23)
                    	selectedPart = 48;
                    if (selectedMenuPart == 24)
                    	selectedPart = 49;
                    if (selectedMenuPart == 25)
                    	selectedPart = 51;*/
                }
                if (selectedPartType == PART_RAMPS) {
                    if (selectedMenuPart == 0)
                        selectedPart = 16;
                    if (selectedMenuPart == 1)
                        selectedPart = 18;
                    if (selectedMenuPart == 2)
                        selectedPart = 19;
                    if (selectedMenuPart == 3)
                        selectedPart = 22;
                    if (selectedMenuPart == 4)
                        selectedPart = 17;
                    if (selectedMenuPart == 5)
                        selectedPart = 21;
                    if (selectedMenuPart == 6)
                        selectedPart = 20;
                    if (selectedMenuPart == 7)
                        selectedPart = 39;
                    if (selectedMenuPart == 8)
                        selectedPart = 42;
                    if (selectedMenuPart == 9)
                        selectedPart = 40;
                    if (selectedMenuPart == 10)
                        selectedPart = 23;
                    if (selectedMenuPart == 11)
                        selectedPart = 25;
                    if (selectedMenuPart == 12)
                        selectedPart = 24;
                    /*if (selectedMenuPart == 13)
                    	selectedPart = 43;
                    if (selectedMenuPart == 14)
                    	selectedPart = 45;*/
                    if (selectedMenuPart == 15)
                        selectedPart = 26;
                }
                if (selectedPartType == PART_OBSTACLES) {
                    if (selectedMenuPart == 0)
                        selectedPart = 27;
                    if (selectedMenuPart == 1)
                        selectedPart = 28;
                    if (selectedMenuPart == 2)
                        selectedPart = 41;
                    /*if (selectedMenuPart == 3)
                    	selectedPart = 44;*/
                    /*if (selectedMenuPart == 4)
                    	selectedPart = 52;
                    if (selectedMenuPart == 5)
                    	selectedPart = 53;*/
                }
                if (selectedPartType == PART_CHECKPOINTS) /*if (onfly)
                                                          	selectedPart = 54;
                                                          else*/ if (!onoff)
                        selectedPart = 30;
                    else
                        selectedPart = 32;
                if (selectedPartType == PART_FIXHOOPS)
                    selectedPart = 31;
                if (selectedPartType == PART_TREES) {
                    /*if (selectedMenuPart == 0)
                    	selectedPart = 55;
                    if (selectedMenuPart == 1)
                    	selectedPart = 56;
                    if (selectedMenuPart == 2)
                    	selectedPart = 57;
                    if (selectedMenuPart == 3)
                    	selectedPart = 58;
                    if (selectedMenuPart == 4)
                    	selectedPart = 59;
                    if (selectedMenuPart == 5)
                    	selectedPart = 60;
                    if (selectedMenuPart == 6)
                    	selectedPart = 61;
                    if (selectedMenuPart == 7)
                    	selectedPart = 62;
                    if (selectedMenuPart == 8)
                    	selectedPart = 63;
                    if (selectedMenuPart == 9)
                    	selectedPart = 64;
                    if (selectedMenuPart == 10)
                    	selectedPart = 65;
                    if (selectedMenuPart == 11)
                    	selectedPart = 66;*/
                    if (selectedMenuPart == 0)
                        selectedPart = 33;
                    if (selectedMenuPart == 1)
                        selectedPart = 34;
                    if (selectedMenuPart == 2)
                        selectedPart = 35;
                    if (selectedMenuPart == 3)
                        selectedPart = 36;
                    if (selectedMenuPart == 4)
                        selectedPart = 37;
                    if (selectedMenuPart == 5)
                        selectedPart = 38;
                    if (selectedMenuPart == 6)
                        selectedPart = 39;
                    if (selectedMenuPart == 7)
                        selectedPart = 40;
                    if (selectedMenuPart == 8)
                        selectedPart = 41;
                    if (selectedMenuPart == 9)
                        selectedPart = 42;
                    if (selectedMenuPart == 10)
                        selectedPart = 43;
                    if (selectedMenuPart == 11)
                        selectedPart = 44;
                    if (selectedMenuPart == 12)
                        selectedPart = 45;
                    if (selectedMenuPart == 13)
                        selectedPart = 46;
                    if (selectedMenuPart == 14)
                        selectedPart = 47;
                    if (selectedMenuPart == 15)
                        selectedPart = 48;
                    if (selectedMenuPart == 16)
                        selectedPart = 49;
                    if (selectedMenuPart == 17)
                        selectedPart = 50;
                    if (selectedMenuPart == 18)
                        selectedPart = 51;
                    if (selectedMenuPart == 19)
                        selectedPart = 52;
                    if (selectedMenuPart == 20)
                        selectedPart = 53;
                    if (selectedMenuPart == 21)
                        selectedPart = 54;
                    if (selectedMenuPart == 22)
                        selectedPart = 55;
                    if (selectedMenuPart == 23)
                        selectedPart = 56;
                    if (selectedMenuPart == 24)
                        selectedPart = 57;
                    if (selectedMenuPart == 25)
                        selectedPart = 58;
                    if (selectedMenuPart == 26)
                        selectedPart = 59;
                    if (selectedMenuPart == 27)
                        selectedPart = 60;
                    if (selectedMenuPart == 28)
                        selectedPart = 61;
                    if (selectedMenuPart == 29)
                        selectedPart = 62;
                    if (selectedMenuPart == 30)
                        selectedPart = 63;
                    if (selectedMenuPart == 31)
                        selectedPart = 64;
                    if (selectedMenuPart == 32)
                        selectedPart = 65;
                    if (selectedMenuPart == 33)
                        selectedPart = 66;
                    if (selectedMenuPart == 34)
                        selectedPart = 67;
                    if (selectedMenuPart == 35)
                        selectedPart = 68;
                    if (selectedMenuPart == 36)
                        selectedPart = 69;
                    if (selectedMenuPart == 37)
                        selectedPart = 70;
                    if (selectedMenuPart == 38)
                        selectedPart = 71;
                    if (selectedMenuPart == 39)
                        selectedPart = 72;
                    if (selectedMenuPart == 40)
                        selectedPart = 73;
                    if (selectedMenuPart == 41)
                        selectedPart = 74;
                    if (selectedMenuPart == 42)
                        selectedPart = 75;
                    if (selectedMenuPart == 43)
                        selectedPart = 76;
                    if (selectedMenuPart == 44)
                        selectedPart = 77;
                    if (selectedMenuPart == 45)
                        selectedPart = 78;
                    if (selectedMenuPart == 46)
                        selectedPart = 79;
                    if (selectedMenuPart == 47)
                        selectedPart = 80;
                    if (selectedMenuPart == 48)
                        selectedPart = 81;
                    if (selectedMenuPart == 49)
                        selectedPart = 82;
                    if (selectedMenuPart == 50)
                        selectedPart = 83;
                    if (selectedMenuPart == 51)
                        selectedPart = 84;
                    if (selectedMenuPart == 52)
                        selectedPart = 85;
                    if (selectedMenuPart == 53)
                        selectedPart = 86;
                    if (selectedMenuPart == 54)
                        selectedPart = 87;
                    if (selectedMenuPart == 55)
                        selectedPart = 88;
                    if (selectedMenuPart == 56)
                        selectedPart = 89;
                    if (selectedMenuPart == 57)
                        selectedPart = 90;
                    if (selectedMenuPart == 58)
                        selectedPart = 91;
                    if (selectedMenuPart == 59)
                        selectedPart = 92;
                    if (selectedMenuPart == 60)
                        selectedPart = 93;
                    if (selectedMenuPart == 61)
                        selectedPart = 94;
                    if (selectedMenuPart == 62)
                        selectedPart = 95;
                    if (selectedMenuPart == 63)
                        selectedPart = 96;
                    if (selectedMenuPart == 64)
                        selectedPart = 97;
                    if (selectedMenuPart == 65)
                        selectedPart = 98;
                    if (selectedMenuPart == 66)
                        selectedPart = 99;
                    if (selectedMenuPart == 67)
                        selectedPart = 100;
                    if (selectedMenuPart == 68)
                        selectedPart = 101;
                    if (selectedMenuPart == 69)
                        selectedPart = 102;
                    if (selectedMenuPart == 70)
                        selectedPart = 103;
                    if (selectedMenuPart == 71)
                        selectedPart = 104;
                    if (selectedMenuPart == 72)
                        selectedPart = 105;
                    if (selectedMenuPart == 73)
                        selectedPart = 106;
                    if (selectedMenuPart == 74)
                        selectedPart = 107;
                    if (selectedMenuPart == 75)
                        selectedPart = 108;
                    if (selectedMenuPart == 76)
                        selectedPart = 109;
                    if (selectedMenuPart == 77)
                        selectedPart = 110;
                    if (selectedMenuPart == 78)
                        selectedPart = 111;
                    if (selectedMenuPart == 79)
                        selectedPart = 112;
                    if (selectedMenuPart == 80)
                        selectedPart = 113;
                    if (selectedMenuPart == 81)
                        selectedPart = 114;
                    if (selectedMenuPart == 82)
                        selectedPart = 115;
                    if (selectedMenuPart == 83)
                        selectedPart = 116;
                    if (selectedMenuPart == 84)
                        selectedPart = 117;
                    if (selectedMenuPart == 85)
                        selectedPart = 118;
                    if (selectedMenuPart == 86)
                        selectedPart = 119;
                    if (selectedMenuPart == 87)
                        selectedPart = 120;
                    if (selectedMenuPart == 88)
                        selectedPart = 121;
                    if (selectedMenuPart == 89)
                        selectedPart = 122;
                    if (selectedMenuPart == 90)
                        selectedPart = 123;
                    if (selectedMenuPart == 91)
                        selectedPart = 124;
                    if (selectedMenuPart == 92)
                        selectedPart = 125;
                    if (selectedMenuPart == 93)
                        selectedPart = 126;
                    if (selectedMenuPart == 94)
                        selectedPart = 127;
                    if (selectedMenuPart == 95)
                        selectedPart = 128;
                    if (selectedMenuPart == 96)
                        selectedPart = 129;
                    if (selectedMenuPart == 97)
                        selectedPart = 130;
                    if (selectedMenuPart == 98)
                        selectedPart = 131;
                    if (selectedMenuPart == 99)
                        selectedPart = 132;
                    if (selectedMenuPart == 100)
                        selectedPart = 133;
                    if (selectedMenuPart > 100)
                        selectedPart = selectedMenuPart + 33;
                    // ------------------ INCREMENT HERE FOR NEW PARTS
                    // -----------------------------NO NEED TO INCREMENT ANYMORE I FIXED IT
                }
                if (selectedPartType == PART_BUMP) {
                    if (!pgen) {
                        int i = (int) (10000.0 * Math.random());
                        if (fgen != 0) {
                            i = fgen;
                            fgen = 0;
                        }
                        bco[bumppart] = new ContO(i, (int) pwd, (int) phd, m, t, 0, 0, 0);
                        bco[bumppart].srz = i;
                        bco[bumppart].srx = (int) pwd;
                        bco[bumppart].sry = (int) phd;
                        pgen = true;
                        seq = 3;
                    }
                    selectedPart = bumppart;
                    rot = 0;
                } else if (pgen) {
                    pgen = false;
                    pwd = 2L + Math.round(Math.random() * 4.0);
                    phd = 2L + Math.round(Math.random() * 4.0);
                }
                if (selectedPart == 30 || selectedPart == 31 || selectedPart == 32 || selectedPart == 54) {
                    if (rot == -90)
                        rot = 90;
                    if (rot == 180)
                        rot = 0;
                }
                adrot = 0;
                if (selectedPart == 2)
                    adrot = -30;
                if (selectedPart == 3)
                    adrot = 30;
                if (selectedPart == 15)
                    adrot = 90;
                if (selectedPart == 20)
                    adrot = 180;
                if (selectedPart == 26)
                    adrot = 90;
                rd.setColor(new Color(200, 200, 200));
                rd.fillRect(248, 63, 514, 454);
                m.trk = 2;
                m.zy = 90;
                m.xz = 0;
                m.iw = 248;
                m.w = 762;
                m.ih = 63;
                m.h = 517;
                m.cx = 505;
                m.cy = 290;
                m.x = sx - m.cx;
                m.z = sz - m.cz;
                m.y = sy;
                int i = 0;
                final int[] is = new int[10000]; // stageselect limit
                for (int i_2_ = 0; i_2_ < nob; i_2_++)
                    if (co[i_2_].dist != 0) {
                        is[i] = i_2_;
                        i++;
                    } else
                        co[i_2_].d(rd);
                final int[] is_3_ = new int[i];
                for (int i_4_ = 0; i_4_ < i; i_4_++)
                    is_3_[i_4_] = 0;
                for (int i_5_ = 0; i_5_ < i; i_5_++)
                    for (int i_6_ = i_5_ + 1; i_6_ < i; i_6_++)
                        if (co[is[i_5_]].dist != co[is[i_6_]].dist) {
                            if (co[is[i_5_]].dist < co[is[i_6_]].dist)
                                is_3_[i_5_]++;
                            else
                                is_3_[i_6_]++;
                        } else if (i_6_ > i_5_)
                            is_3_[i_5_]++;
                        else
                            is_3_[i_6_]++;
                for (int i_7_ = 0; i_7_ < i; i_7_++)
                    for (int i_8_ = 0; i_8_ < i; i_8_++)
                        if (is_3_[i_8_] == i_7_) {
                            if (is[i_8_] == hi)
                                m.trk = 3;
                            if (is[i_8_] == chi && !co[is[i_8_]].errd) {
                                final int i_9_ = m.cx
                                        + (int) ((co[is[i_8_]].x - m.x - m.cx) * m.cos(m.xz)
                                                - (co[is[i_8_]].z - m.z - m.cz) * m.sin(m.xz));
                                final int i_10_ = m.cz
                                        + (int) ((co[is[i_8_]].x - m.x - m.cx) * m.sin(m.xz)
                                                + (co[is[i_8_]].z - m.z - m.cz) * m.cos(m.xz));
                                final int i_11_ = m.cy
                                        + (int) ((co[is[i_8_]].y - m.y - m.cy) * m.cos(m.zy)
                                                - (i_10_ - m.cz) * m.sin(m.zy));
                                final int i_12_ = m.cz
                                        + (int) ((co[is[i_8_]].y - m.y - m.cy) * m.sin(m.zy)
                                                + (i_10_ - m.cz) * m.cos(m.zy));
                                final int i_13_ = 1000000 / Math.abs(sy);
                                final Graphics2D graphics2d = rd;
                                graphics2d.setComposite(AlphaComposite.getInstance(3, 0.7F));
                                rd.setColor(new Color(0, 164, 255));
                                rd.fillOval(Utility.xs(i_9_, i_12_, m) - i_13_ / 2, Utility.ys(i_11_, i_12_, m) - i_13_ / 2,
                                        i_13_, i_13_);
                                graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString(
                                        new StringBuilder().append("NO# ").append(arrcnt + 1).append("").toString(),
                                        Utility.xs(i_9_, i_12_, m) - ftm.stringWidth(new StringBuilder().append("NO# ")
                                                .append(arrcnt + 1).append("").toString()) / 2,
                                        Utility.ys(i_11_, i_12_, m) - i_13_ / 2);
                            }
                            if (arrng && (co[is[i_8_]].colok == 30 || co[is[i_8_]].colok == 32
                                    || co[is[i_8_]].colok == 54) && co[is[i_8_]].errd) {
                                final int i_14_ = m.cx
                                        + (int) ((co[is[i_8_]].x - m.x - m.cx) * m.cos(m.xz)
                                                - (co[is[i_8_]].z - m.z - m.cz) * m.sin(m.xz));
                                final int i_15_ = m.cz
                                        + (int) ((co[is[i_8_]].x - m.x - m.cx) * m.sin(m.xz)
                                                + (co[is[i_8_]].z - m.z - m.cz) * m.cos(m.xz));
                                final int i_16_ = m.cy
                                        + (int) ((co[is[i_8_]].y - m.y - m.cy) * m.cos(m.zy)
                                                - (i_15_ - m.cz) * m.sin(m.zy));
                                final int i_17_ = m.cz
                                        + (int) ((co[is[i_8_]].y - m.y - m.cy) * m.sin(m.zy)
                                                + (i_15_ - m.cz) * m.cos(m.zy));
                                final int i_18_ = 1000000 / Math.abs(sy);
                                final Graphics2D graphics2d = rd;
                                graphics2d.setComposite(AlphaComposite.getInstance(3, 0.5F));
                                rd.setColor(new Color(255, 128, 0));
                                rd.fillOval(Utility.xs(i_14_, i_17_, m) - i_18_ / 2, Utility.ys(i_16_, i_17_, m) - i_18_ / 2,
                                        i_18_, i_18_);
                                graphics2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                rd.setColor(new Color(0, 0, 0));
                                rd.setFont(new Font("Arial", 1, 12));
                                ftm = rd.getFontMetrics();
                                rd.drawString(
                                        new StringBuilder().append("NO# ").append(co[is[i_8_]].wh).append("")
                                                .toString(),
                                        Utility.xs(i_14_, i_17_, m) - ftm.stringWidth(new StringBuilder().append("NO# ")
                                                .append(co[is[i_8_]].wh).append("").toString()) / 2,
                                        Utility.ys(i_16_, i_17_, m) - i_18_ / 2);
                            }
                            co[is[i_8_]].d(rd);
                            if (m.trk == 3)
                                m.trk = 2;
                        }
                if (xm > 248 && xm < 762 && ym > 63 && ym < 517) {
                    if (!epart && !arrng) {
                        bco[selectedPart].x = (xm - 505) * (Math.abs(sy) / m.focus_point) + sx;
                        bco[selectedPart].z = (290 - ym) * (Math.abs(sy) / m.focus_point) + sz;
                        bco[selectedPart].y = m.ground - bco[selectedPart].grat;
                        bco[selectedPart].xz = rot + adrot;
                        int i_19_ = 200;
                        int i_20_ = 0;
                        int i_21_ = 0;
                        final int[] is_22_ = {
                                bco[selectedPart].x + atp[selectedPart][0], bco[selectedPart].x + atp[selectedPart][2]
                        };
                        final int[] is_23_ = {
                                bco[selectedPart].z + atp[selectedPart][1], bco[selectedPart].z + atp[selectedPart][3]
                        };
                        rot(is_22_, is_23_, bco[selectedPart].x, bco[selectedPart].z, rot, 2);
                        int i_24_ = 0;
                        //onfly = false;
                        int i_25_ = 500;
                        for (int i_26_ = 0; i_26_ < nob; i_26_++) {
                            final int[] is_27_ = {
                                    co[i_26_].x + atp[co[i_26_].colok][0], co[i_26_].x + atp[co[i_26_].colok][2]
                            };
                            final int[] is_28_ = {
                                    co[i_26_].z + atp[co[i_26_].colok][1], co[i_26_].z + atp[co[i_26_].colok][3]
                            };
                            int i_29_ = co[i_26_].roofat;
                            if (co[i_26_].colok == 2)
                                i_29_ += 30;
                            if (co[i_26_].colok == 3)
                                i_29_ -= 30;
                            if (co[i_26_].colok == 15)
                                i_29_ -= 90;
                            if (co[i_26_].colok == 20)
                                i_29_ -= 180;
                            if (co[i_26_].colok == 26)
                                i_29_ -= 90;
                            rot(is_27_, is_28_, co[i_26_].x, co[i_26_].z, i_29_, 2);
                            if (selectedPart <= 54) {
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
                            if (selectedPartType == PART_CHECKPOINTS
                                    && py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) != 0
                                    && py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) != 0) {
                                for (int i_31_ = 0; i_31_ < rcheckp.length; i_31_++)
                                    if (co[i_26_].colok == rcheckp[i_31_]) {
                                        if (py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) <= i_24_ || i_24_ == 0) {
                                            i_24_ = py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]);
                                            onoff = false;
                                        }
                                        if (py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) <= i_24_) {
                                            i_24_ = py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]);
                                            onoff = false;
                                        }
                                    }
                                for (int i_32_ = 0; i_32_ < ocheckp.length; i_32_++)
                                    if (co[i_26_].colok == ocheckp[i_32_]) {
                                        if (py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]) <= i_24_ || i_24_ == 0) {
                                            i_24_ = py(is_27_[0], is_22_[0], is_28_[0], is_23_[0]);
                                            onoff = true;
                                        }
                                        if (py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]) <= i_24_) {
                                            i_24_ = py(is_27_[1], is_22_[0], is_28_[1], is_23_[0]);
                                            onoff = true;
                                        }
                                    }
                            }
                            if (selectedPart > 12 && selectedPart < 33 || selectedPart == 35 || selectedPart == 36
                                    || selectedPart >= 39 && selectedPart <= 54) {
                                if ((rot == 0 || rot == 180 || selectedPart == 26 || selectedPart == 15)
                                        && (i_29_ == 0 || i_29_ == 180 || selectedPart == 26 || selectedPart == 15)) {
                                    if (Math.abs(is_27_[0] - is_22_[0]) < 200)
                                        i_20_ = is_27_[0] - is_22_[0];
                                    if (Math.abs(is_27_[0] - is_22_[1]) < 200)
                                        i_20_ = is_27_[0] - is_22_[1];
                                    if (Math.abs(is_27_[1] - is_22_[1]) < 200)
                                        i_20_ = is_27_[1] - is_22_[1];
                                    if (Math.abs(is_27_[1] - is_22_[0]) < 200)
                                        i_20_ = is_27_[1] - is_22_[0];
                                }
                                if ((rot == 90 || rot == -90 || selectedPart == 26 || selectedPart == 15)
                                        && (i_29_ == 90 || i_29_ == -90 || selectedPart == 26 || selectedPart == 15)) {
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
                            if (selectedPartType == PART_CHECKPOINTS && co[i_26_].colok >= 46
                                    && co[i_26_].colok <= 51) {
                                final int[] is_33_ = {
                                        2, 3, 5, 2, 3, 3
                                };
                                if ((Math.abs(co[i_26_].roofat) == 180 || co[i_26_].roofat == 0) && rot == 0
                                        && Math.abs(bco[selectedPart].x - co[i_26_].x) < 500
                                        && Math.abs(bco[selectedPart].z - co[i_26_].z) < 3000)
                                    for (int i_34_ = 0; i_34_ < is_33_[co[i_26_].colok - 46]; i_34_++)
                                        for (int i_35_ = 0; i_35_ < co[i_26_].p[i_34_].n; i_35_++)
                                            if (py(bco[selectedPart].x, co[i_26_].x, bco[selectedPart].z,
                                                    co[i_26_].z + co[i_26_].p[i_34_].oz[i_35_]) < i_25_) {
                                                i_25_ = py(bco[selectedPart].x, co[i_26_].x, bco[selectedPart].z,
                                                        co[i_26_].z + co[i_26_].p[i_34_].oz[i_35_]);
                                                flyh = co[i_26_].p[i_34_].oy[i_35_] - 28 + m.ground;
                                                i_20_ = co[i_26_].x - bco[selectedPart].x;
                                                i_21_ = co[i_26_].z + co[i_26_].p[i_34_].oz[i_35_]
                                                        - bco[selectedPart].z;
                                                //onfly = true;
                                            }
                                if (Math.abs(co[i_26_].roofat) == 90 && rot == 90
                                        && Math.abs(bco[selectedPart].z - co[i_26_].z) < 500
                                        && Math.abs(bco[selectedPart].x - co[i_26_].x) < 3000)
                                    for (int i_36_ = 0; i_36_ < is_33_[co[i_26_].colok - 46]; i_36_++)
                                        for (int i_37_ = 0; i_37_ < co[i_26_].p[i_36_].n; i_37_++)
                                            if (py(bco[selectedPart].z, co[i_26_].z, bco[selectedPart].x,
                                                    co[i_26_].x + co[i_26_].p[i_36_].ox[i_37_]) < i_25_) {
                                                i_25_ = py(bco[selectedPart].z, co[i_26_].z, bco[selectedPart].x,
                                                        co[i_26_].x + co[i_26_].p[i_36_].ox[i_37_]);
                                                flyh = co[i_26_].p[i_36_].oy[i_37_] - 28 + m.ground;
                                                i_21_ = co[i_26_].z - bco[selectedPart].z;
                                                i_20_ = co[i_26_].x + co[i_26_].p[i_36_].ox[i_37_]
                                                        - bco[selectedPart].x;
                                                //onfly = true;
                                            }
                            }
                        }
                        bco[selectedPart].x += i_20_;
                        bco[selectedPart].z += i_21_;
                        final int i_38_ = bco[selectedPart].xy;
                        final int i_39_ = bco[selectedPart].zy;
                        if (selectedPart == 31) {
                            bco[selectedPart].y = -hf;
                            if (bco[selectedPart].y > -500)
                                bco[selectedPart].y = -500;
                        } else
                            bco[selectedPart].xy = 0;
                        if (selectedPart == 54)
                            bco[selectedPart].y = flyh;
                        bco[selectedPart].zy = 0;
                        if (cntout == 0) {
                            if (mouseon == -1) {
                                bco[selectedPart].d(rd);
                                if (!setcur) {
                                    setCursor(new Cursor(13));
                                    setcur = true;
                                }
                                if (mousePressed == -1) {
                                    if (nundo < 5000) {
                                        undos[nundo] = bstage;
                                        nundo++;
                                    }
                                    if (bco[selectedPart].xz == 270)
                                        bco[selectedPart].xz = -90;
                                    if (bco[selectedPart].xz == 360)
                                        bco[selectedPart].xz = 0;
                                    errd = 0;
                                    boolean bool = false;
                                    if (xnob < 10000) { //piece limit
                                        System.out.println("place check");
                                        if (selectedPart != 31 && selectedPart != 54 && selectedPart != bumppart)
                                            try {
                                                System.out.println("placed");
                                                System.out.println("" + selectedPart);
                                                System.out.println("" + bco[selectedPart]);
                                                co[nob] = new ContO(bco[selectedPart], bco[selectedPart].x,
                                                        m.ground - bco[selectedPart].grat, bco[selectedPart].z,
                                                        bco[selectedPart].xz);
                                                co[nob].roofat = bco[selectedPart].xz;
                                                co[nob].colok = selectedPart;
                                                nob++;
                                            } catch (final Exception exception) {
                                                errd = 1;
                                            }
                                        if (selectedPart == 31)
                                            if (cp.fn < 5) {
                                                co[nob] = new ContO(bco[selectedPart], bco[selectedPart].x,
                                                        bco[selectedPart].y, bco[selectedPart].z, bco[selectedPart].xz);
                                                co[nob].roofat = bco[selectedPart].xz;
                                                co[nob].colok = selectedPart;
                                                nob++;
                                                fixh.setText(new StringBuilder().append("")
                                                        .append(Math.abs(bco[selectedPart].y)).append("").toString());
                                            } else
                                                errd = 5;
                                        if (selectedPart == 54)
                                            try {
                                                co[nob] = new ContO(bco[selectedPart], bco[selectedPart].x,
                                                        bco[selectedPart].y, bco[selectedPart].z, bco[selectedPart].xz);
                                                co[nob].roofat = bco[selectedPart].xz;
                                                co[nob].colok = selectedPart;
                                                nob++;
                                            } catch (final Exception exception) {
                                                errd = 1;
                                            }
                                        if (selectedPart == bumppart) {
                                            co[nob] = new ContO(bco[bumppart].srz, bco[bumppart].srx, bco[bumppart].sry,
                                                    m, t, bco[bumppart].x, bco[bumppart].z, bco[selectedPart].y);
                                            co[nob].srz = bco[bumppart].srz;
                                            co[nob].srx = bco[bumppart].srx;
                                            co[nob].sry = bco[bumppart].sry;
                                            co[nob].colok = selectedPart;
                                            nob++;
                                        }
                                    } else
                                        errd = 4;
                                    if (errd == 0) {
                                        sortstage();
                                        readstage(0);
                                        bool = true;
                                        if (selectedPart == bumppart)
                                            pgen = false;
                                        if (selectedPart == 52 || selectedPart == 53
                                                || selectedPart >= 55 && selectedPart <= 65) {
                                            seq = 3;
                                            bco[selectedPart].xy = 0;
                                            bco[selectedPart].zy = 0;
                                            boolean bool_40_ = false;
                                            if (rot == 0 && !bool_40_) {
                                                rot = 90;
                                                bool_40_ = true;
                                            }
                                            if (rot == 90 && !bool_40_) {
                                                rot = 180;
                                                bool_40_ = true;
                                            }
                                            if (rot == 180 && !bool_40_) {
                                                rot = -90;
                                                bool_40_ = true;
                                            }
                                            if (rot == -90 && !bool_40_) {
                                                rot = 0;
                                                bool_40_ = true;
                                            }
                                        }
                                    }
                                    if (errd != 0) {
                                        JOptionPane.showMessageDialog(null,
                                                new StringBuilder().append("Error!  Unable to place part!\nReason:\n")
                                                        .append(errlo[errd - 1]).append("\n\n").toString(),
                                                "Stage Maker", 0);
                                        if (bool) {
                                            nundo--;
                                            bstage = undos[nundo];
                                            readstage(0);
                                        }
                                    }
                                    lxm = bco[selectedPart].x;
                                    //lym = bco[selectedPart].z;
                                    cntout = 10;
                                }
                            }
                        } else {
                            if (lxm != bco[selectedPart].x && lxm != bco[selectedPart].z)
                                cntout--;
                            if (setcur) {
                                setCursor(new Cursor(0));
                                setcur = false;
                            }
                        }
                        bco[selectedPart].xy = i_38_;
                        bco[selectedPart].zy = i_39_;
                    } else {
                        if (epart)
                            if (esp == -1 && !overcan) {
                                hi = -1;
                                int i_41_ = 0;
                                for (int i_42_ = 0; i_42_ < nob; i_42_++) {
                                    final int i_43_ = m.cx
                                            + (int) ((co[i_42_].x - m.x - m.cx) * m.cos(m.xz)
                                                    - (co[i_42_].z - m.z - m.cz) * m.sin(m.xz));
                                    final int i_44_ = m.cz
                                            + (int) ((co[i_42_].x - m.x - m.cx) * m.sin(m.xz)
                                                    + (co[i_42_].z - m.z - m.cz) * m.cos(m.xz));
                                    final int i_45_ = m.cy
                                            + (int) ((co[i_42_].y - m.y - m.cy) * m.cos(m.zy)
                                                    - (i_44_ - m.cz) * m.sin(m.zy));
                                    final int i_46_ = m.cz
                                            + (int) ((co[i_42_].y - m.y - m.cy) * m.sin(m.zy)
                                                    + (i_44_ - m.cz) * m.cos(m.zy));
                                    if (xm > Utility.xs(i_43_ - co[i_42_].maxR, i_46_, m)
                                            && xm < Utility.xs(i_43_ + co[i_42_].maxR, i_46_, m)
                                            && ym > Utility.ys(i_45_ - co[i_42_].maxR, i_46_, m)
                                            && ym < Utility.ys(i_45_ + co[i_42_].maxR, i_46_, m) && co[i_42_].colok != 37
                                            && co[i_42_].colok != 38)
                                        if (hi == -1) {
                                            hi = i_42_;
                                            i_41_ = py(xm, Utility.xs(i_43_, i_46_, m), ym, Utility.ys(i_45_, i_46_, m));
                                        } else if (py(xm, Utility.xs(i_43_, i_46_, m), ym,
                                                Utility.ys(i_45_, i_46_, m)) <= i_41_) {
                                            hi = i_42_;
                                            i_41_ = py(xm, Utility.xs(i_43_, i_46_, m), ym, Utility.ys(i_45_, i_46_, m));
                                        }
                                }
                                if (hi != -1) {
                                    if (!setcur) {
                                        setCursor(new Cursor(13));
                                        setcur = true;
                                    }
                                    if (mousePressed == -1) {
                                        esp = hi;
                                        mousePressed = 0;
                                    }
                                } else if (setcur) {
                                    setCursor(new Cursor(0));
                                    setcur = false;
                                }
                            } else if (setcur) {
                                setCursor(new Cursor(0));
                                setcur = false;
                            }
                        if (arrng) {
                            chi = -1;
                            int i_47_ = 5000;
                            for (int i_48_ = 0; i_48_ < nob; i_48_++)
                                if ((co[i_48_].colok == 30 || co[i_48_].colok == 32 || co[i_48_].colok == 54)
                                        && !co[i_48_].errd) {
                                    final int i_49_ = m.cx
                                            + (int) ((co[i_48_].x - m.x - m.cx) * m.cos(m.xz)
                                                    - (co[i_48_].z - m.z - m.cz) * m.sin(m.xz));
                                    final int i_50_ = m.cz
                                            + (int) ((co[i_48_].x - m.x - m.cx) * m.sin(m.xz)
                                                    + (co[i_48_].z - m.z - m.cz) * m.cos(m.xz));
                                    final int i_51_ = m.cy
                                            + (int) ((co[i_48_].y - m.y - m.cy) * m.cos(m.zy)
                                                    - (i_50_ - m.cz) * m.sin(m.zy));
                                    final int i_52_ = m.cz
                                            + (int) ((co[i_48_].y - m.y - m.cy) * m.sin(m.zy)
                                                    + (i_50_ - m.cz) * m.cos(m.zy));
                                    if (xm > Utility.xs(i_49_ - co[i_48_].maxR, i_52_, m)
                                            && xm < Utility.xs(i_49_ + co[i_48_].maxR, i_52_, m)
                                            && ym > Utility.ys(i_51_ - co[i_48_].maxR, i_52_, m)
                                            && ym < Utility.ys(i_51_ + co[i_48_].maxR, i_52_, m) && py(xm,
                                                    Utility.xs(i_49_, i_52_, m), ym, Utility.ys(i_51_, i_52_, m)) <= i_47_) {
                                        chi = i_48_;
                                        i_47_ = py(xm, Utility.xs(i_49_, i_52_, m), ym, Utility.ys(i_51_, i_52_, m));
                                    }
                                }
                            if (chi != -1) {
                                if (!setcur) {
                                    setCursor(new Cursor(13));
                                    setcur = true;
                                }
                                if (mousePressed == -1) {
                                    arrcnt++;
                                    co[chi].wh = arrcnt;
                                    co[chi].errd = true;
                                    mousePressed = 0;
                                }
                            } else if (setcur) {
                                setCursor(new Cursor(0));
                                setcur = false;
                            }
                        }
                    }

                } else if (setcur) {
                    setCursor(new Cursor(0));
                    setcur = false;
                }
                if (epart && esp != -1)
                    if (co[esp].dist != 0) {
                        m.cx = 505;
                        m.cy = 290;
                        m.x = sx - m.cx;
                        m.z = sz - m.cz;
                        m.y = sy;
                        final int i_53_ = m.cx + (int) ((co[esp].x - m.x - m.cx) * m.cos(m.xz)
                                - (co[esp].z - m.z - m.cz) * m.sin(m.xz));
                        final int i_54_ = m.cz + (int) ((co[esp].x - m.x - m.cx) * m.sin(m.xz)
                                + (co[esp].z - m.z - m.cz) * m.cos(m.xz));
                        final int i_55_ = m.cy + (int) ((co[esp].y - m.y - m.cy) * m.cos(m.zy)
                                - (i_54_ - m.cz) * m.sin(m.zy));
                        final int i_56_ = m.cz + (int) ((co[esp].y - m.y - m.cy) * m.sin(m.zy)
                                + (i_54_ - m.cz) * m.cos(m.zy));
                        final int i_57_ = Utility.xs(i_53_, i_56_, m);
                        final int i_58_ = Utility.ys(i_55_, i_56_, m);
                        rd.setColor(new Color(225, 225, 225));
                        rd.fillRect(i_57_, i_58_, 90, 88);
                        rd.setColor(new Color(138, 147, 160));
                        rd.drawRect(i_57_, i_58_, 90, 88);
                        if (button("   Edit   ", i_57_ + 45, i_58_ + 22, 3, false)) {
                            copyesp(true);
                            removesp();
                            lxm = 0;
                            //lym = 0;
                            cntout = 2;
                            epart = false;
                        }
                        if (button(" Remove ", i_57_ + 45, i_58_ + 49, 3, false)) {
                            removesp();
                            esp = -1;
                            mousePressed = 0;
                        }
                        if (button("  Copy  ", i_57_ + 45, i_58_ + 76, 3, false)) {
                            copyesp(false);
                            lxm = 0;
                            //lym = 0;
                            cntout = 2;
                            epart = false;
                        }
                        rd.setColor(new Color(255, 0, 0));
                        rd.drawString("x", i_57_ + 82, i_58_ - 2);
                        if (xm > 248 && xm < 762 && ym > 63 && ym < 517 && mousePressed == 1
                                && (xm < i_57_ || xm > i_57_ + 90 || ym < i_58_ || ym > i_58_ + 88)) {
                            esp = -1;
                            mousePressed = 0;
                        }
                    } else
                        esp = -1;
                rd.setColor(new Color(225, 225, 225));
                rd.fillRect(248, 25, 514, 38);
                rd.fillRect(0, 25, 248, 530);
                rd.fillRect(248, 517, 514, 38);
                rd.fillRect(762, 25, 38, 530);
                if (selectedPartType == PART_BUMP) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.drawString("Radius:", 11, 97);
                    rd.drawString("Height:", 14, 117);
                    boolean bool = false;
                    if (xm > 57 && xm < 204 && ym > 90 && ym < 99)
                        bool = true;
                    rd.setColor(new Color(136, 148, 170));
                    if (bool || mouseon == 1) {
                        rd.drawRect(57, 90, 147, 8);
                        rd.setColor(new Color(0, 0, 0));
                    }
                    rd.drawLine(57, 94, 204, 94);
                    if (mouseon == 1) {
                        pwd = (xm - 57) / 36.75F + 2.0F;
                        if (pwd < 2.0F)
                            pwd = 2.0F;
                        if (pwd > 6.0F)
                            pwd = 6.0F;
                    }
                    rd.drawRect((int) (57.0F + (pwd - 2.0F) * 36.75F), 90, 2, 8);
                    boolean bool_59_ = false;
                    if (xm > 57 && xm < 204 && ym > 110 && ym < 119)
                        bool_59_ = true;
                    rd.setColor(new Color(136, 148, 170));
                    if (bool_59_ || mouseon == 2) {
                        rd.drawRect(57, 110, 147, 8);
                        rd.setColor(new Color(0, 0, 0));
                    }
                    rd.drawLine(57, 114, 204, 114);
                    if (mouseon == 2) {
                        phd = (xm - 57) / 36.75F + 2.0F;
                        if (phd < 2.0F)
                            phd = 2.0F;
                        if (phd > 6.0F)
                            phd = 6.0F;
                    }
                    rd.drawRect((int) (57.0F + (phd - 2.0F) * 36.75F), 110, 2, 8);
                    if (mousePressed == 1) {
                        if (bool)
                            mouseon = 1;
                        if (bool_59_)
                            mouseon = 2;
                    } else {
                        if (mouseon == 1 || mouseon == 2)
                            pgen = false;
                        mouseon = -1;
                    }
                }
                int i_60_ = 0;
                if (xm > 482 && xm < 529 && ym > 35 && ym < 61 || up) {
                    i_60_ = 1;
                    if (mousePressed == 1 || up)
                        sz += 500;
                }
                rd.drawImage(su[i_60_], 482, 35, null);
                i_60_ = 0;
                if (xm > 482 && xm < 529 && ym > 519 && ym < 545 || down) {
                    i_60_ = 1;
                    if (mousePressed == 1 || down)
                        sz -= 500;
                }
                rd.drawImage(sd[i_60_], 482, 519, null);
                i_60_ = 0;
                if (xm > 220 && xm < 246 && ym > 264 && ym < 311 || left) {
                    i_60_ = 1;
                    if (mousePressed == 1 || left)
                        sx -= 500;
                }
                rd.drawImage(sl[i_60_], 220, 264, null);
                i_60_ = 0;
                if (xm > 764 && xm < 790 && ym > 264 && ym < 311 || right) {
                    i_60_ = 1;
                    if (mousePressed == 1 || right)
                        sx += 500;
                }
                rd.drawImage(sr[i_60_], 764, 264, null);
                i_60_ = 0;
                if (xm > 616 && xm < 677 && ym > 30 && ym < 61 || zoomi) {
                    i_60_ = 1;
                    if (mousePressed == 1 || zoomi) {
                        sy += 500;
                        if (sy > -2500)
                            sy = -2500;
                    }
                }
                rd.drawImage(zi[i_60_], 616, 30, null);
                i_60_ = 0;
                if (xm > 690 && xm < 751 && ym > 30 && ym < 61 || zoomo) {
                    i_60_ = 1;
                    if (mousePressed == 1 || zoomo) {
                        sy -= 500;
                        if (sy < -55000)
                            sy = -55000;
                    }
                }
                rd.drawImage(zo[i_60_], 690, 30, null);
                if ((epart || arrng) && sy < -36000)
                    sy = -36000;
                rd.setFont(new Font("Arial", 1, 11));
                ftm = rd.getFontMetrics();
                rd.setColor(new Color(0, 0, 0));
                rd.drawString("Part Selection", 11, 47);
                rd.setFont(new Font("Arial", 1, 13));
                ftm = rd.getFontMetrics();
                ptyp.move(10, 50);
                if (!ptyp.isShowing()) {
                    ptyp.setVisible(true);
                    ptyp.select(selectedPartType);
                }
                if (selectedPartType != ptyp.getSelectedIndex()) {
                    selectedPartType = ptyp.getSelectedIndex();
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
                    }
                    selectedMenuPart = 0;
                    part.select(selectedMenuPart);
                    requestFocus();
                    fixh.setText("2000");
                    focuson = false;
                }
                part.move(10, 80);
                part.setSize(200, 21);
                if (selectedPartType == PART_ROADS || selectedPartType == PART_RAMPS
                        || selectedPartType == PART_OBSTACLES || selectedPartType == PART_TREES) {
                    if (!part.isShowing()) {
                        part.setVisible(true);
                        part.select(selectedMenuPart);
                    }
                } else if (part.isShowing())
                    part.setVisible(false);
                if (selectedMenuPart != part.getSelectedIndex()) {
                    selectedMenuPart = part.getSelectedIndex();
                    focuson = false;
                }
                if (selectedPartType == PART_CHECKPOINTS)
                    rd.drawString("Checkpoint", 110 - ftm.stringWidth("Checkpoint") / 2, 120);
                if (selectedPartType == PART_FIXHOOPS)
                    rd.drawString("Fixing Hoop", 110 - ftm.stringWidth("Fixing Hoop") / 2, 120);
                if (lsp != selectedPart) {
                    seq = 3;
                    bco[selectedPart].xy = 0;
                    bco[selectedPart].zy = 0;
                    lsp = selectedPart;
                    epart = false;
                    arrng = false;
                }
                if (xm > 10 && xm < 210 && ym > 130 && ym < 334) {
                    if (seq >= 3)
                        if (seq == 20 || !seqn) {
                            seq = 0;
                            bco[selectedPart].xy = 0;
                            bco[selectedPart].zy = 0;
                        } else
                            seq++;
                    seqn = true;
                    rd.setColor(new Color(210, 210, 210));
                } else {
                    rd.setColor(new Color(200, 200, 200));
                    seqn = false;
                }
                rd.fillRect(10, 130, 200, 200);
                if ((selectedPart == 30 || selectedPart == 32 || selectedPart == 54)
                        && button("  Rearrange Checkpoints  >  ", 110, 315, 2, true)) {
                    mousePressed = 0;
                    epart = false;
                    if (!arrng) {
                        arrcnt = 0;
                        for (int i_61_ = 0; i_61_ < nob; i_61_++)
                            if (co[i_61_].colok == 30 || co[i_61_].colok == 32 || co[i_61_].colok == 54)
                                co[i_61_].errd = false;
                        arrng = true;
                    } else
                        arrng = false;
                }
                if (seqn && mousePressed == -1)
                    if (selectedPart != bumppart) {
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
                            bool = true;
                        }
                        if (selectedPart == 30 || selectedPart == 31 || selectedPart == 32) {
                            if (rot == -90)
                                rot = 90;
                            if (rot == 180)
                                rot = 0;
                        }
                        seq = 5;
                        bco[selectedPart].xy = 0;
                        bco[selectedPart].zy = 0;
                        epart = false;
                        arrng = false;
                    } else {
                        pgen = false;
                        pwd = 2L + Math.round(Math.random() * 4.0);
                        phd = 2L + Math.round(Math.random() * 4.0);
                    }
                if (selectedPart == 31) {
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Height:", 62, 280);
                    movefield(fixh, 107, 266, 50, 20);
                    if (fixh.hasFocus())
                        focuson = false;
                    if (!fixh.isShowing())
                        fixh.setVisible(true);
                    rd.setFont(new Font("Arial", 0, 11));
                    ftm = rd.getFontMetrics();
                    rd.drawString("(Height off the ground... )",
                            110 - ftm.stringWidth("(Height off the ground... )") / 2, 300);
                    if (fixh.getText().equals("")) {
                        fixh.setText("0");
                        fixh.select(0, 0);
                    }
                    try {
                        hf = Integer.valueOf(fixh.getText()).intValue();
                        if (hf > 8000) {
                            hf = 8000;
                            fixh.setText("8000");
                        }
                    } catch (final Exception exception) {
                        hf = 2000;
                        fixh.setText("2000");
                    }
                } else if (fixh.isShowing())
                    fixh.setVisible(false);
                m.trk = 2;
                m.zy = 90;
                m.xz = 0;
                m.iw = 10;
                m.w = 210;
                m.ih = 130;
                m.h = 330;
                m.cx = 110;
                m.cy = 230;
                m.x = -110;
                m.z = -230;
                m.y = -15000;
                if (selectedPartType == PART_RAMPS && selectedPart != 20 && selectedPart != 21 && selectedPart != 43
                        && selectedPart != 45)
                    m.y = -10000;
                if (selectedPartType == PART_OBSTACLES && selectedPart != 41)
                    m.y = -7600;
                if (selectedPartType == PART_CHECKPOINTS || selectedPartType == PART_FIXHOOPS)
                    m.y = -5000;
                if (selectedPartType == PART_TREES) {
                    m.y = -3000;
                    m.z = 150;
                }
                if (selectedPartType == PART_BUMP)
                    m.y = -7600;
                if (selectedPart == 31) {
                    m.z = -500;
                    if (rot != 0)
                        bco[selectedPart].roted = true;
                    else
                        bco[selectedPart].roted = false;
                }
                bco[selectedPart].x = 0;
                bco[selectedPart].y = 0;
                bco[selectedPart].z = 0;
                bco[selectedPart].xz = rot + adrot;
                bco[selectedPart].d(rd);
                int i_62_ = 1;
                if (selectedPartType == PART_ROADS || selectedPartType == PART_RAMPS) {
                    if (selectedPart != 26 && selectedPart != 20) {
                        if (rot == -90 || rot == 0)
                            i_62_ = -1;
                    } else {
                        if (selectedPart == 26 && (rot == -90 || rot == 180))
                            i_62_ = -1;
                        if (selectedPart == 20 && (rot == 90 || rot == 180))
                            i_62_ = -1;
                    }
                    if (seq == 2) {
                        bco[selectedPart].xy -= 5 * i_62_;
                        if (bco[selectedPart].xy == 0)
                            seq = 3;
                    }
                    if (seq == 1)
                        seq = 2;
                    if (seq == 0) {
                        bco[selectedPart].xy += 5 * i_62_;
                        if (bco[selectedPart].xy == 85 * i_62_)
                            seq = 1;
                    }
                }
                if (selectedPartType == PART_OBSTACLES || selectedPartType == PART_CHECKPOINTS
                        || selectedPartType == PART_FIXHOOPS || selectedPartType == PART_BUMP) {
                    if (rot == -90 || rot == 180)
                        i_62_ = -1;
                    if (seq == 2) {
                        bco[selectedPart].zy += 5 * i_62_;
                        if (bco[selectedPart].zy == 0)
                            seq = 3;
                    }
                    if (seq == 1)
                        seq = 2;
                    if (seq == 0) {
                        bco[selectedPart].zy -= 5 * i_62_;
                        if (bco[selectedPart].zy == -(85 * i_62_))
                            seq = 1;
                    }
                }
                if (selectedPartType == PART_TREES) {
                    if (rot == -90 || rot == 180)
                        i_62_ = -1;
                    boolean bool = false;
                    if (rot == -90 || rot == 90)
                        bool = true;
                    if (!bool)
                        bco[selectedPart].xy = 0;
                    else
                        bco[selectedPart].zy = 0;
                    if (seq == 2)
                        if (!bool) {
                            bco[selectedPart].zy += 5 * i_62_;
                            if (bco[selectedPart].zy == 0)
                                seq = 3;
                        } else {
                            bco[selectedPart].xy -= 5 * i_62_;
                            if (bco[selectedPart].xy == 0)
                                seq = 3;
                        }
                    if (seq == 1)
                        seq = 2;
                    if (seq == 0)
                        if (!bool) {
                            bco[selectedPart].zy -= 5 * i_62_;
                            if (bco[selectedPart].zy == -(85 * i_62_))
                                seq = 1;
                        } else {
                            bco[selectedPart].xy += 5 * i_62_;
                            if (bco[selectedPart].xy == 85 * i_62_)
                                seq = 1;
                        }
                }
                if (selectedPart != bumppart) {
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
                            bool = true;
                        }
                        if (selectedPart == 30 || selectedPart == 31 || selectedPart == 32) {
                            if (rot == -90)
                                rot = 90;
                            if (rot == 180)
                                rot = 0;
                        }
                        seq = 3;
                        bco[selectedPart].xy = 0;
                        bco[selectedPart].zy = 0;
                        epart = false;
                        arrng = false;
                    }
                } else if (button("  Generate New  ", 110, 348, 3, true)) {
                    pgen = false;
                    pwd = 2L + Math.round(Math.random() * 4.0);
                    phd = 2L + Math.round(Math.random() * 4.0);
                }
                if (button(">", 191, 348, 3, true) && (selectedPartType == PART_ROADS || selectedPartType == PART_RAMPS
                        || selectedPartType == PART_OBSTACLES || selectedPartType == PART_TREES)) {
                    selectedMenuPart++;
                    if (selectedMenuPart == part.getItemCount())
                        selectedMenuPart = 0;
                    part.select(selectedMenuPart);
                    epart = false;
                    arrng = false;
                }
                if (button("<", 28, 348, 3, true) && (selectedPartType == PART_ROADS || selectedPartType == PART_RAMPS
                        || selectedPartType == PART_OBSTACLES || selectedPartType == PART_TREES)) {
                    selectedMenuPart--;
                    if (selectedMenuPart == -1)
                        selectedMenuPart = part.getItemCount() - 1;
                    part.select(selectedMenuPart);
                    epart = false;
                    arrng = false;
                }
                if (button("   <  Undo   ", 204, 404, 0, true)) {
                    epart = false;
                    arrng = false;
                    if (nundo > 0) {
                        nundo--;
                        bstage = undos[nundo];
                        readstage(0);
                    }
                }
                if (button("   Remove / Edit  Part   ", 172, 454, 0, true)) {
                    if (!epart)
                        epart = true;
                    else
                        epart = false;
                    arrng = false;
                    esp = -1;
                }
                if (button("   Go to >  Startline   ", 175, 504, 0, true)) {
                    sx = 0;
                    sz = 1500;
                }
                if (button(" About Part ", 164, 66, 3, false))
                    JOptionPane.showMessageDialog(null, discp[selectedPart], "Stage Maker", 1);
                if (button("  Keyboard Controls  ", 691, 536, 3, false))
                    JOptionPane.showMessageDialog(null,
                            "Instead of clicking the triangular buttons around the Building Area to scroll, you can use:\n[ Keyboard Arrows ]\n\nYou can also zoom in and out using the following keys:\n[+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]\n\n",
                            "Stage Maker", 1);
                if (button("  Save  ", 280, 50, 0, false)) {
                    epart = false;
                    arrng = false;
                    savefile();
                }
                if (button("  Save & Preview  ", 380, 50, 0, false)) {
                    epart = false;
                    arrng = false;
                    savefile();
                    hidefields();
                    tab = 2;
                }
                rd.setFont(new Font("Arial", 1, 12));
                ftm = rd.getFontMetrics();
                rd.setColor(new Color(0, 0, 0));
                int i_63_ = 0;
                final int i_64_ = (int) (xnob / 10000.0F * 200.0F); // limits
                int i_65_ = i_64_;
                final int i_66_ = (int) (t.nt / 670000.0F * 200.0F); // limits
                if (i_66_ > i_65_) {
                    i_65_ = i_66_;
                    i_63_ = 1;
                }
                final int i_67_ = (int) (cp.n / 10000.0F * 200.0F); // limits
                if (i_67_ > i_65_) {
                    i_65_ = i_67_;
                    i_63_ = 2;
                }
                final int i_68_ = (int) (m.nrw * m.ncl / 9999999.0F * 200.0F); // medium
                // limit...does
                // it
                // exist?
                if (i_68_ > i_65_) {
                    i_65_ = i_68_;
                    i_63_ = 3;
                }
                if (i_65_ > 200) // may be a limit
                    i_65_ = 200;
                if (i_65_ <= 100)
                    rd.setColor(new Color(100 + i_65_, 225, 30));
                else
                    rd.setColor(new Color(200, 325 - i_65_, 30));
                rd.fillRect(167, 531, i_65_, 9);
                if (button("Memory Consumption :", 85, 540, 3, false))
                    JOptionPane.showMessageDialog(null,
                            new StringBuilder().append("Memory Consumption Details\n\nNumber of Parts:  ")
                                    .append(i_64_ / 2).append(" %\nPart's Details:  ").append(i_66_ / 2)
                                    .append(" %\nRoad Points:  ").append(i_67_ / 2).append(" %\nStage Area:  ")
                                    .append(i_68_ / 2).append(" %\n \n").toString(),
                            "Stage Maker", 1);
                rd.setColor(new Color(0, 0, 0));
                rd.drawRect(167, 531, 200, 9);
                final String[] strings = {
                        "Number of Parts", "Part's Details", "Road Points", "Stage Area"
                };
                rd.drawString(strings[i_63_], 267 - ftm.stringWidth(strings[i_63_]) / 2, 540);
                rd.drawString(new StringBuilder().append("").append(i_65_ / 2).append(" %  used").toString(), 375, 540);
                if (overcan)
                    overcan = false;
                if (epart) {
                    if (esp == -1) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString("Click on any part to Edit >", 257, 454);
                        if (button(" Cancel ", 323, 474, 4, false))
                            epart = false;
                    }
                } else {
                    if (hi != -1)
                        hi = -1;
                    if (esp != -1)
                        esp = -1;
                }
                if (arrng) {
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(new StringBuilder().append("Click on Checkpoint NO# ").append(arrcnt + 1)
                            .append("  >").toString(), 257, 80);
                    if (button(" Cancel ", 330, 100, 4, false))
                        arrng = false;
                    if (arrcnt == cp.nsp) {
                        sortstage();
                        JOptionPane.showMessageDialog(null,
                                "Checkpoints Arranged!\nPress Save and Test Drive to check the new checkpoint order.\n",
                                "Stage Maker", 1);
                        arrng = false;
                    }
                } else if (chi != -1)
                    chi = -1;
            }
            if (tab == 2) {
                if (tabed != tab) {
                    m.trk = 0;
                    readstage(1);
                    setCursor(new Cursor(0));
                    setcur = false;
                    vxz = 0;
                    vx = sx - 400;
                    vz = sz - m.cz - 8000;
                    vy = -1500;
                    dtabed = -1;
                }
                m.trk = 0;
                m.zy = 6;
                m.iw = 10;
                m.w = 790;
                m.ih = 35;
                m.h = 445;
                m.cx = 400;
                m.cy = 215;
                m.xz = vxz;
                m.x = vx;
                m.z = vz;
                m.y = vy;
                m.d(rd);
                int i = 0;
                final int[] is = new int[10000]; // stageselect limit
                for (int i_69_ = 0; i_69_ < nob; i_69_++)
                    if (co[i_69_].dist != 0) {
                        is[i] = i_69_;
                        i++;
                    } else
                        co[i_69_].d(rd);
                final int[] is_70_ = new int[i];
                for (int i_71_ = 0; i_71_ < i; i_71_++)
                    is_70_[i_71_] = 0;
                for (int i_72_ = 0; i_72_ < i; i_72_++)
                    for (int i_73_ = i_72_ + 1; i_73_ < i; i_73_++)
                        if (co[is[i_72_]].dist != co[is[i_73_]].dist) {
                            if (co[is[i_72_]].dist < co[is[i_73_]].dist)
                                is_70_[i_72_]++;
                            else
                                is_70_[i_73_]++;
                        } else if (i_73_ > i_72_)
                            is_70_[i_72_]++;
                        else
                            is_70_[i_73_]++;
                for (int i_74_ = 0; i_74_ < i; i_74_++)
                    for (int i_75_ = 0; i_75_ < i; i_75_++)
                        if (is_70_[i_75_] == i_74_) {
                            if (is[i_75_] == hi)
                                m.trk = 3;
                            co[is[i_75_]].d(rd);
                            if (m.trk == 3)
                                m.trk = 2;
                        }
                if (up) {
                    vz += 500.0F * m.cos(m.xz);
                    vx += 500.0F * m.sin(m.xz);
                }
                if (down) {
                    vz -= 500.0F * m.cos(m.xz);
                    vx -= 500.0F * m.sin(m.xz);
                }
                if (left)
                    vxz -= 5;
                if (right)
                    vxz += 5;
                if (zoomi) {
                    vy += 100;
                    if (vy > -500)
                        vy = -500;
                }
                if (zoomo) {
                    vy -= 100;
                    if (vy < -5000)
                        vy = -5000;
                }
                rd.setColor(new Color(225, 225, 225));
                rd.fillRect(0, 25, 10, 525);
                rd.fillRect(790, 25, 10, 525);
                rd.fillRect(10, 25, 780, 10);
                rd.fillRect(10, 445, 780, 105);
                rd.setFont(new Font("Arial", 1, 12));
                ftm = rd.getFontMetrics();
                final String[] strings = {
                        "Controls", "Atmosphere", "Colors", "Scenery", "Laps", "Sound Track", "Test Drive"
                };
                final int[] is_76_ = {
                        10, 10, 121, 111
                };
                final int[] is_77_ = {
                        425, 445, 445, 425
                };
                for (int i_78_ = 0; i_78_ < 7; i_78_++) {
                    rd.setColor(new Color(170, 170, 170));
                    if (xm > is_76_[0] && xm < is_76_[3] && ym > 425 && ym < 445)
                        rd.setColor(new Color(190, 190, 190));
                    if (dtab == i_78_)
                        rd.setColor(new Color(225, 225, 225));
                    rd.fillPolygon(is_76_, is_77_, 4);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString(strings[i_78_], i_78_ * 111 + 62 - ftm.stringWidth(strings[i_78_]) / 2, 439);
                    if (xm > is_76_[0] && xm < is_76_[3] && ym > 425 && ym < 445 && mousePressed == -1 && mouseon == -1)
                        dtab = i_78_;
                    for (int i_79_ = 0; i_79_ < 4; i_79_++)
                        is_76_[i_79_] += 111;
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
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Use the [ Keyboard Arrows ] to navigate through the stage.", 20, 470);
                    rd.drawString(
                            "[Left] & [Right] arrows are for rotating.  [Up] & [Down] arrows are for moving forwards and backwards.",
                            20, 490);
                    rd.drawString(
                            "For moving vertically down and up use the following keys:  [+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]",
                            20, 520);
                }
                if (dtab == 2) {
                    if (dtabed != dtab) {
                        Color.RGBtoHSB(csky[0], csky[1], csky[2], hsb[0]);
                        Color.RGBtoHSB(cfade[0], cfade[1], cfade[2], hsb[1]);
                        Color.RGBtoHSB(cgrnd[0], cgrnd[1], cgrnd[2], hsb[2]);
                        for (int i_80_ = 0; i_80_ < 3; i_80_++) {
                            final float f = hsb[i_80_][1];
                            hsb[i_80_][1] = hsb[i_80_][2];
                            hsb[i_80_][2] = f;
                        }
                        if (hsb[1][1] == (hsb[0][1] + hsb[2][1]) / 2.0F && hsb[1][0] == hsb[2][0]
                                && hsb[1][2] == hsb[2][2])
                            pfog.setState(true);
                        else
                            pfog.setState(false);
                        ttstage = "";
                        mouseon = -1;
                    }
                    if (mousePressed != 1) {
                        if ((mouseon >= 6 || mouseon < 3) && mouseon != -1) {
                            if (ttstage.equals(""))
                                ttstage = tstage;
                            sortop();
                            readstage(1);
                        }
                        mouseon = -1;
                    }
                    final String[] strings_81_ = {
                            "Sky", "Dust / Fog", "Ground"
                    };
                    for (int i_82_ = 0; i_82_ < 3; i_82_++) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString(strings_81_[i_82_], 107 + 195 * i_82_ - ftm.stringWidth(strings_81_[i_82_]) / 2,
                                461);
                        for (int i_83_ = 0; i_83_ < 150; i_83_++) {
                            rd.setColor(Color.getHSBColor((float) (i_83_ * 0.006667), 1.0F, 1.0F));
                            rd.drawLine(32 + i_83_ + 195 * i_82_, 467, 32 + i_83_ + 195 * i_82_, 474);
                        }
                        for (int i_84_ = 0; i_84_ < 150; i_84_++) {
                            rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.5F + i_84_ * 0.00333F));
                            rd.drawLine(32 + i_84_ + 195 * i_82_, 483, 32 + i_84_ + 195 * i_82_, 490);
                        }
                        for (int i_85_ = 0; i_85_ < 150; i_85_++) {
                            rd.setColor(
                                    Color.getHSBColor(hsb[i_82_][0], 0.0F + (float) (i_85_ * 0.001667), hsb[i_82_][1]));
                            rd.drawLine(32 + i_85_ + 195 * i_82_, 499, 32 + i_85_ + 195 * i_82_, 506);
                        }
                        for (int i_86_ = 0; i_86_ < 3; i_86_++) {
                            rd.setColor(new Color(0, 0, 0));
                            float f = hsb[i_82_][i_86_] * 150.0F;
                            if (i_86_ == 1) {
                                float f_87_ = 0.75F;
                                if (i_82_ == 0)
                                    f_87_ = 0.85F;
                                if (i_82_ == 1)
                                    f_87_ = 0.8F;
                                f = (hsb[i_82_][i_86_] - f_87_) / 0.001F;
                            }
                            if (i_86_ == 2)
                                f = hsb[i_82_][i_86_] * 600.0F;
                            if (f < 0.0F)
                                f = 0.0F;
                            if (f > 150.0F)
                                f = 150.0F;
                            rd.drawLine((int) (32 + 195 * i_82_ + f), 467 + i_86_ * 16, (int) (32 + 195 * i_82_ + f),
                                    474 + i_86_ * 16);
                            rd.drawLine((int) (33 + 195 * i_82_ + f), 467 + i_86_ * 16, (int) (33 + 195 * i_82_ + f),
                                    474 + i_86_ * 16);
                            rd.fillRect((int) (31 + 195 * i_82_ + f), 475 + i_86_ * 16, 4, 2);
                            rd.drawLine((int) (30 + 195 * i_82_ + f), 477 + i_86_ * 16, (int) (35 + 195 * i_82_ + f),
                                    477 + i_86_ * 16);
                            if (xm > 29 + 195 * i_82_ && xm < 185 + 195 * i_82_ && ym > 468 + i_86_ * 16
                                    && ym < 477 + i_86_ * 16 && mousePressed == 1 && mouseon == -1)
                                mouseon = i_86_ + i_82_ * 3;
                            if (mouseon == i_86_ + i_82_ * 3) {
                                if (i_86_ == 0)
                                    hsb[i_82_][i_86_] = (xm - (32 + 195 * i_82_)) / 150.0F;
                                if (i_86_ == 1) {
                                    float f_88_ = 0.75F;
                                    if (i_82_ == 0)
                                        f_88_ = 0.85F;
                                    if (i_82_ == 1)
                                        f_88_ = 0.8F;
                                    hsb[i_82_][i_86_] = f_88_ + (xm - (32 + 195 * i_82_)) * 0.001F;
                                    if (hsb[i_82_][i_86_] < f_88_)
                                        hsb[i_82_][i_86_] = f_88_;
                                    if (hsb[i_82_][i_86_] > f_88_ + 0.15F)
                                        hsb[i_82_][i_86_] = f_88_ + 0.15F;
                                }
                                if (i_86_ == 2) {
                                    hsb[i_82_][i_86_] = (xm - (32 + 195 * i_82_)) / 600.0F;
                                    if (hsb[i_82_][i_86_] > 0.25)
                                        hsb[i_82_][i_86_] = 0.25F;
                                }
                                if (hsb[i_82_][i_86_] > 1.0F)
                                    hsb[i_82_][i_86_] = 1.0F;
                                if (hsb[i_82_][i_86_] < 0.0F)
                                    hsb[i_82_][i_86_] = 0.0F;
                            }
                        }
                    }
                    movefield(pfog, 258, 511, 200, 23);
                    if (!pfog.isShowing())
                        pfog.setVisible(true);
                    if (pfog.getState()) {
                        rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                        rd.setColor(new Color(0, 0, 0));
                        rd.fillRect(215, 464, 175, 47);
                        rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        hsb[1][1] = (hsb[0][1] + hsb[2][1]) / 2.0F;
                        hsb[1][0] = hsb[2][0];
                        hsb[1][2] = hsb[2][2];
                    }
                    Color color = Color.getHSBColor(hsb[0][0], hsb[0][2], hsb[0][1]);
                    m.setsky(color.getRed(), color.getGreen(), color.getBlue());
                    csky[0] = color.getRed();
                    csky[1] = color.getGreen();
                    csky[2] = color.getBlue();
                    color = Color.getHSBColor(hsb[1][0], hsb[1][2], hsb[1][1]);
                    m.setfade(color.getRed(), color.getGreen(), color.getBlue());
                    cfade[0] = color.getRed();
                    cfade[1] = color.getGreen();
                    cfade[2] = color.getBlue();
                    color = Color.getHSBColor(hsb[2][0], hsb[2][2], hsb[2][1]);
                    m.setgrnd(color.getRed(), color.getGreen(), color.getBlue());
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
                        mgen.setText(new StringBuilder().append("").append(m.mgen).append("").toString());
                        mouseon = -1;
                        ttstage = "";
                    }
                    if (mousePressed != 1) {
                        if (mouseon == 0 || mouseon == 1 || mouseon == 2 || mouseon == 6) {
                            if (ttstage.equals(""))
                                ttstage = tstage;
                            sortop();
                            readstage(1);
                        }
                        mouseon = -1;
                    }
                    rd.setFont(new Font("Arial", 1, 12));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Clouds", 32, 461);
                    for (int i_89_ = 0; i_89_ < 150; i_89_++) {
                        rd.setColor(Color.getHSBColor(i_89_ * 0.006667F, 1.0F, 1.0F));
                        rd.drawLine(32 + i_89_ + 0, 467, 32 + i_89_ + 0, 474);
                    }
                    for (int i_90_ = 0; i_90_ < 150; i_90_++) {
                        rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.75F + i_90_ * 0.001667F));
                        rd.drawLine(32 + i_90_ + 0, 483, 32 + i_90_ + 0, 490);
                    }
                    for (int i_91_ = 0; i_91_ < 150; i_91_++) {
                        rd.setColor(Color.getHSBColor(hsb[0][0], i_91_ * 0.003333F, hsb[0][2]));
                        rd.drawLine(32 + i_91_ + 0, 499, 32 + i_91_ + 0, 506);
                    }
                    rd.setFont(new Font("Arial", 0, 11));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Blend:", 32, 529);
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(70, 522, 112, 2);
                    rd.fillRect(70, 528, 112, 2);
                    float f = 0.0F;
                    int i_92_ = 255;
                    for (int i_93_ = 0; i_93_ < 112; i_93_++) {
                        i_92_ = (int) (255.0F / (f + 1.0F));
                        if (i_92_ > 255)
                            i_92_ = 255;
                        if (i_92_ < 0)
                            i_92_ = 0;
                        f += 0.02F;
                        rd.setColor(new Color(i_92_, i_92_, i_92_));
                        rd.drawLine(70 + i_93_, 524, 70 + i_93_, 527);
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Height", 202 - ftm.stringWidth("Height") / 2, 461);
                    rd.drawLine(202, 467, 202, 530);
                    for (int i_94_ = 0; i_94_ < 8; i_94_++)
                        rd.drawLine(202, 466 + i_94_ * 8, 202 + 8 - i_94_, 466 + i_94_ * 8);
                    rd.setFont(new Font("Arial", 1, 12));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Ground Texture", 257, 471);
                    for (int i_95_ = 0; i_95_ < 150; i_95_++) {
                        rd.setColor(Color.getHSBColor(i_95_ * 0.006667F, 1.0F, 1.0F));
                        rd.drawLine(32 + i_95_ + 225, 477, 32 + i_95_ + 225, 484);
                    }
                    for (int i_96_ = 0; i_96_ < 150; i_96_++) {
                        rd.setColor(Color.getHSBColor(hsb[1][0], i_96_ * 0.006667F, i_96_ * 0.006667F));
                        rd.drawLine(32 + i_96_ + 225, 493, 32 + i_96_ + 225, 500);
                    }
                    rd.setFont(new Font("Arial", 0, 11));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Blend:", 257, 523);
                    rd.setColor(new Color(0, 0, 0));
                    rd.fillRect(295, 516, 112, 2);
                    rd.fillRect(295, 522, 112, 2);
                    f = 0.0F;
                    i_92_ = 255;
                    for (int i_97_ = 0; i_97_ < 112; i_97_++) {
                        i_92_ = (int) (255.0F / (f + 1.0F));
                        if (i_92_ > 255)
                            i_92_ = 255;
                        if (i_92_ < 0)
                            i_92_ = 0;
                        f += 0.02F;
                        rd.setColor(new Color(i_92_, i_92_, i_92_));
                        rd.drawLine(70 + i_97_ + 225, 518, 70 + i_97_ + 225, 521);
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
                            rd.setColor(new Color(0, 0, 0));
                            float f_102_ = hsb[i_98_][i_101_] * 150.0F;
                            if (i_100_ == 1 && i_98_ == 0) {
                                final float f_103_ = 0.75F;
                                f_102_ = (hsb[i_98_][i_101_] - f_103_) / 0.001667F;
                            }
                            if (i_100_ == 2 && i_98_ == 0)
                                f_102_ = hsb[i_98_][i_101_] / 0.003333F;
                            if (f_102_ < 0.0F)
                                f_102_ = 0.0F;
                            if (f_102_ > 150.0F)
                                f_102_ = 150.0F;
                            rd.drawLine((int) (32 + 225 * i_98_ + f_102_), 467 + i_100_ * 16 + 10 * i_98_,
                                    (int) (32 + 225 * i_98_ + f_102_), 474 + i_100_ * 16 + 10 * i_98_);
                            rd.drawLine((int) (33 + 225 * i_98_ + f_102_), 467 + i_100_ * 16 + 10 * i_98_,
                                    (int) (33 + 225 * i_98_ + f_102_), 474 + i_100_ * 16 + 10 * i_98_);
                            rd.fillRect((int) (31 + 225 * i_98_ + f_102_), 475 + i_100_ * 16 + 10 * i_98_, 4, 2);
                            rd.drawLine((int) (30 + 225 * i_98_ + f_102_), 477 + i_100_ * 16 + 10 * i_98_,
                                    (int) (35 + 225 * i_98_ + f_102_), 477 + i_100_ * 16 + 10 * i_98_);
                            if (xm > 29 + 225 * i_98_ && xm < 185 + 225 * i_98_ && ym > 468 + i_100_ * 16 + 10 * i_98_
                                    && ym < 477 + i_100_ * 16 + 10 * i_98_ && mousePressed == 1 && mouseon == -1)
                                mouseon = i_100_ + i_98_ * 3;
                            if (mouseon == i_100_ + i_98_ * 3) {
                                hsb[i_98_][i_101_] = (xm - (32 + 225 * i_98_)) * 0.006667F;
                                if (i_100_ == 1 && i_98_ == 1) {
                                    hsb[i_98_][1] = (xm - (32 + 225 * i_98_)) * 0.006667F;
                                    if (hsb[i_98_][1] > 1.0F)
                                        hsb[i_98_][1] = 1.0F;
                                    if (hsb[i_98_][1] < 0.0F)
                                        hsb[i_98_][1] = 0.0F;
                                }
                                if (i_100_ == 1 && i_98_ == 0) {
                                    final float f_104_ = 0.75F;
                                    hsb[i_98_][i_101_] = f_104_ + (xm - (32 + 225 * i_98_)) * 0.001667F;
                                    if (hsb[i_98_][i_101_] < f_104_)
                                        hsb[i_98_][i_101_] = f_104_;
                                }
                                if (i_100_ == 2 && i_98_ == 0) {
                                    hsb[i_98_][i_101_] = (xm - (32 + 225 * i_98_)) * 0.003333F;
                                    if (hsb[i_98_][i_101_] > 0.5)
                                        hsb[i_98_][i_101_] = 0.5F;
                                }
                                if (hsb[i_98_][i_101_] > 1.0F)
                                    hsb[i_98_][i_101_] = 1.0F;
                                if (hsb[i_98_][i_101_] < 0.0F)
                                    hsb[i_98_][i_101_] = 0.0F;
                            }
                        }
                        rd.setColor(new Color(0, 0, 0));
                        float f_105_ = (texture[3] - 20) * 2.8F;
                        if (i_98_ == 0)
                            f_105_ = cldd[3] * 11.2F;
                        if (f_105_ < 0.0F)
                            f_105_ = 0.0F;
                        if (f_105_ > 112.0F)
                            f_105_ = 112.0F;
                        rd.drawLine((int) (70 + 225 * i_98_ + f_105_), 522 - 6 * i_98_,
                                (int) (70 + 225 * i_98_ + f_105_), 529 - 6 * i_98_);
                        rd.drawLine((int) (71 + 225 * i_98_ + f_105_), 522 - 6 * i_98_,
                                (int) (71 + 225 * i_98_ + f_105_), 529 - 6 * i_98_);
                        rd.fillRect((int) (69 + 225 * i_98_ + f_105_), 530 - 6 * i_98_, 4, 2);
                        rd.drawLine((int) (68 + 225 * i_98_ + f_105_), 532 - 6 * i_98_,
                                (int) (73 + 225 * i_98_ + f_105_), 532 - 6 * i_98_);
                        if (xm > 67 + 225 * i_98_ && xm < 185 + 225 * i_98_ && ym > 522 - 6 * i_98_
                                && ym < 532 - 6 * i_98_ && mousePressed == 1 && mouseon == -1)
                            mouseon = 6 + i_98_;
                    }
                    if (mouseon == 6) {
                        cldd[3] = (int) ((xm - 70) / 11.2F);
                        if (cldd[3] < 0)
                            cldd[3] = 0;
                        if (cldd[3] > 10)
                            cldd[3] = 10;
                    }
                    if (mouseon == 7) {
                        texture[3] = (int) ((xm - 70 - 225) / 2.8 + 20.0);
                        if (texture[3] < 20)
                            texture[3] = 20;
                        if (texture[3] > 60)
                            texture[3] = 60;
                    }
                    rd.setColor(new Color(0, 128, 255));
                    float f_106_ = (1500 - Math.abs(cldd[4])) / 15.625F;
                    if (f_106_ > 64.0F)
                        f_106_ = 64.0F;
                    if (f_106_ < 0.0F)
                        f_106_ = 0.0F;
                    rd.drawRect(199, (int) (465.0F + f_106_), 12, 2);
                    if (xm > 197 && xm < 213 && ym > 463 && ym < 533 && mousePressed == 1 && mouseon == -1)
                        mouseon = 8;
                    if (mouseon == 8) {
                        cldd[4] = -(int) ((530 - ym) * 15.625F + 500.0F);
                        if (cldd[4] > -500)
                            cldd[4] = -500;
                        if (cldd[4] < -1500)
                            cldd[4] = -1500;
                    }
                    Color color = Color.getHSBColor(hsb[0][0], hsb[0][1], hsb[0][2]);
                    m.setcloads(color.getRed(), color.getGreen(), color.getBlue(), cldd[3], cldd[4]);
                    cldd[0] = color.getRed();
                    cldd[1] = color.getGreen();
                    cldd[2] = color.getBlue();
                    color = Color.getHSBColor(hsb[1][0], hsb[1][1], hsb[1][2]);
                    m.setexture(color.getRed(), color.getGreen(), color.getBlue(), texture[3]);
                    texture[0] = color.getRed();
                    texture[1] = color.getGreen();
                    texture[2] = color.getBlue();
                    rd.setFont(new Font("Arial", 1, 12));
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Mountains", 452, 465);
                    rd.setFont(new Font("Arial", 0, 11));
                    rd.drawString("Mountain Generator Key:", 452, 480);
                    movefield(mgen, 452, 484, 120, 20);
                    if (mgen.hasFocus())
                        focuson = false;
                    if (!mgen.isShowing())
                        mgen.setVisible(true);
                    if (button("  Generate New  ", 512, 525, 3, true)) {
                        m.mgen = (int) (Math.random() * 100000.0);
                        mgen.setText(new StringBuilder().append("").append(m.mgen).append("").toString());
                        if (ttstage.equals(""))
                            ttstage = tstage;
                        sortop();
                        readstage(1);
                    }
                    if (!mgen.getText()
                            .equals(new StringBuilder().append("").append(m.mgen).append("").toString()))
                        try {
                            final int i_107_ = Integer.valueOf(mgen.getText()).intValue();
                            m.mgen = i_107_;
                            if (ttstage.equals(""))
                                ttstage = tstage;
                            sortop();
                            readstage(1);
                        } catch (final Exception exception) {
                            mgen.setText(new StringBuilder().append("").append(m.mgen).append("").toString());
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
                        for (int i_108_ = 0; i_108_ < 3; i_108_++)
                            snap[i_108_] = (int) (m.snap[i_108_] / 1.2F + 50.0F);
                        fogn[0] = (8 - ((m.fogd + 1) / 2 - 1)) * 20;
                        fogn[1] = (m.fade[0] - 5000) / 30;
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Atmosphere RGB Mask", 20, 461);
                    rd.setColor(new Color(128, 128, 128));
                    rd.drawLine(10, 457, 17, 457);
                    rd.drawLine(260, 457, 152, 457);
                    rd.drawLine(10, 457, 10, 546);
                    rd.drawLine(260, 457, 260, 527);
                    rd.drawLine(260, 527, 360, 527);
                    rd.drawLine(10, 546, 360, 546);
                    rd.drawLine(360, 527, 360, 546);
                    final String[] strings_109_ = {
                            "Red", "Green", "Blue"
                    };
                    final int[] is_110_ = {
                            32, 20, 29
                    };
                    int i_111_ = 38;
                    int i_112_ = -70;
                    for (int i_113_ = 0; i_113_ < 3; i_113_++) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString(
                                new StringBuilder().append("").append(strings_109_[i_113_]).append(" :").toString(),
                                is_110_[i_113_], 447 + i_113_ * 24 + i_111_);
                        rd.drawLine(140 + i_112_, 443 + i_113_ * 24 + i_111_, 230 + i_112_, 443 + i_113_ * 24 + i_111_);
                        for (int i_114_ = 1; i_114_ < 10; i_114_++)
                            rd.drawLine(140 + 10 * i_114_ + i_112_, 443 - i_114_ + i_113_ * 24 + i_111_,
                                    140 + 10 * i_114_ + i_112_, 443 + i_114_ + i_113_ * 24 + i_111_);
                        rd.setColor(new Color(255, 0, 0));
                        final int i_115_ = (int) (snap[i_113_] / 1.1111F / 10.0F);
                        rd.fillRect(138 + (int) (snap[i_113_] / 1.1111F) + i_112_, 443 - i_115_ + i_113_ * 24 + i_111_,
                                5, i_115_ * 2 + 1);
                        rd.setColor(new Color(255, 128, 0));
                        rd.drawRect(139 + (int) (snap[i_113_] / 1.1111F) + i_112_, 434 + i_113_ * 24 + i_111_, 2, 18);
                        if (button(" - ", 260 + i_112_, 447 + i_113_ * 24 + i_111_, 4, false)) {
                            snap[i_113_] -= 2;
                            if (snap[i_113_] < 0)
                                snap[i_113_] = 0;
                        }
                        if (button(" + ", 300 + i_112_, 447 + i_113_ * 24 + i_111_, 4, false)) {
                            if (snap[0] + snap[1] + snap[2] > 200)
                                for (int i_116_ = 0; i_116_ < 3; i_116_++)
                                    if (i_116_ != i_113_) {
                                        snap[i_116_]--;
                                        if (snap[i_116_] < 0)
                                            snap[i_116_] = 0;
                                    }
                            snap[i_113_] += 2;
                            if (snap[i_113_] > 100)
                                snap[i_113_] = 100;
                        }
                    }
                    if (m.snap[0] != (int) (snap[0] * 1.2F - 60.0F)
                            || m.snap[1] != (int) (snap[1] * 1.2F - 60.0F)
                            || m.snap[2] != (int) (snap[2] * 1.2F - 60.0F)) {
                        for (int i_117_ = 0; i_117_ < 3; i_117_++)
                            m.snap[i_117_] = (int) (snap[i_117_] * 1.2F - 60.0F);
                        readstage(2);
                    }
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Car Lights :", 265, 541);
                    if (snap[0] + snap[1] + snap[2] > 110) {
                        rd.drawString("Off", 335, 541);
                        m.lightson = false;
                    } else {
                        rd.setColor(new Color(0, 200, 0));
                        rd.drawString("On", 335, 541);
                        m.lightson = true;
                    }
                    final int i_118_ = 33;
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Dust/Fog Properties", 280 + i_118_, 461);
                    rd.setColor(new Color(128, 128, 128));
                    rd.drawLine(270 + i_118_, 457, 277 + i_118_, 457);
                    rd.drawLine(540 + i_118_, 457, 393 + i_118_, 457);
                    rd.drawLine(270 + i_118_, 457, 270 + i_118_, 522);
                    rd.drawLine(540 + i_118_, 457, 540 + i_118_, 522);
                    rd.drawLine(270 + i_118_, 522, 540 + i_118_, 522);
                    final String[] strings_119_ = {
                            "Density", "Near / Far"
                    };
                    final int[] is_120_ = {
                            292 + i_118_, 280 + i_118_
                    };
                    final int[] is_121_ = {
                            20, 10
                    };
                    i_111_ = 38;
                    i_112_ = 210 + i_118_;
                    for (int i_122_ = 0; i_122_ < 2; i_122_++) {
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString(
                                new StringBuilder().append("").append(strings_119_[i_122_]).append(" :").toString(),
                                is_120_[i_122_], 447 + i_122_ * 24 + i_111_);
                        rd.drawLine(140 + i_112_, 443 + i_122_ * 24 + i_111_, 230 + i_112_, 443 + i_122_ * 24 + i_111_);
                        for (int i_123_ = 1; i_123_ < 10; i_123_++)
                            rd.drawLine(140 + 10 * i_123_ + i_112_, 443 - i_123_ + i_122_ * 24 + i_111_,
                                    140 + 10 * i_123_ + i_112_, 443 + i_123_ + i_122_ * 24 + i_111_);
                        rd.setColor(new Color(255, 0, 0));
                        final int i_124_ = (int) (fogn[i_122_] / 1.1111F / 10.0F);
                        rd.fillRect(138 + (int) (fogn[i_122_] / 1.1111F) + i_112_, 443 - i_124_ + i_122_ * 24 + i_111_,
                                5, i_124_ * 2 + 1);
                        rd.setColor(new Color(255, 128, 0));
                        rd.drawRect(139 + (int) (fogn[i_122_] / 1.1111F) + i_112_, 434 + i_122_ * 24 + i_111_, 2, 18);
                        if (button(" - ", 260 + i_112_, 447 + i_122_ * 24 + i_111_, 4, false)) {
                            fogn[i_122_] -= is_121_[i_122_];
                            if (fogn[i_122_] < 0)
                                fogn[i_122_] = 0;
                        }
                        if (button(" + ", 300 + i_112_, 447 + i_122_ * 24 + i_111_, 4, false)) {
                            fogn[i_122_] += is_121_[i_122_];
                            if (fogn[i_122_] > 100)
                                fogn[i_122_] = 100;
                        }
                    }
                    m.fogd = (8 - fogn[0] / 20 + 1) * 2 - 1;
                    m.fadfrom(5000 + fogn[1] * 30);
                    origfade = m.fade[0];
                    if (button(" Reset ", 650, 510, 0, true))
                        dtabed = -2;
                    if (button("        Save        ", 737, 510, 0, true)) {
                        sortop();
                        savefile();
                    }
                }
                if (dtab == 4) {
                    if (dtabed != dtab && cp.nlaps - 1 >= 0 && cp.nlaps - 1 <= 14)
                        nlaps.select(cp.nlaps - 1);
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Set the number of laps for this stage:", 130, 496);
                    nlaps.move(348, 480);
                    if (!nlaps.isShowing())
                        nlaps.setVisible(true);
                    if (cp.nlaps != nlaps.getSelectedIndex() + 1) {
                        cp.nlaps = nlaps.getSelectedIndex() + 1;
                        requestFocus();
                    }
                    if (button(" Reset ", 530, 496, 0, true))
                        dtabed = -2;
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
                        final String[] strings_125_ = new File("mystages/mymusic/").list();
                        if (strings_125_ != null)
                            for (int i_126_ = 0; i_126_ < strings_125_.length; i_126_++)
                                if (strings_125_[i_126_].toLowerCase().endsWith(".zip"))
                                    tracks.add(rd,
                                            strings_125_[i_126_].substring(0, strings_125_[i_126_].length() - 4));
                        if (ltrackname.equals("")) {
                            if (trackname.equals(""))
                                tracks.select(0);
                            else
                                tracks.select(trackname);
                        } else
                            tracks.select(ltrackname);
                        mouseon = -1;
                    }
                    tracks.move(10, 450);
                    if (tracks.getWidth() != 200)
                        tracks.setSize(200, 21);
                    if (!tracks.isShowing())
                        tracks.setVisible(true);
                    if (track.playing && track.loaded == 2) {
                        if (button("      Stop      ", 110, 495, 2, false))
                            track.stop();
                        if (!ltrackname.equals(tracks.getSelectedItem()))
                            track.stop();
                        if (xm > 10 && xm < 210 && ym > 516 && ym < 534) {
                            if (mousePressed == 1)
                                mouseon = 1;
                            rd.setColor(new Color(0, 164, 242));
                        } else
                            rd.setColor(new Color(120, 210, 255));
                        rd.drawRect(10, 516, 200, 18);
                        rd.setColor(new Color(200, 200, 200));
                        rd.drawLine(10, 523, 210, 523);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawLine(10, 524, 210, 524);
                        rd.drawLine(10, 525, 210, 525);
                        rd.drawLine(10, 526, 210, 526);
                        rd.setColor(new Color(255, 255, 255));
                        rd.drawLine(10, 527, 210, 527);
                        int i_127_ = (int) ((1.0F - (float) track.sClip.stream.available() / (float) avon) * 200.0F);
                        if (mouseon == 1) {
                            i_127_ = xm - 10;
                            if (i_127_ < 0)
                                i_127_ = 0;
                            if (i_127_ > 200)
                                i_127_ = 200;
                            if (mousePressed != 1) {
                                track.sClip.stream.reset();
                                track.sClip.stream.skip((long) (i_127_ / 200.0F * avon));
                                mouseon = -1;
                            }
                        }
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawRect(8 + i_127_, 516, 4, 18);
                        rd.setColor(new Color(0, 164, 242));
                        rd.drawLine(10 + i_127_, 520, 10 + i_127_, 518);
                        rd.drawLine(10 + i_127_, 530, 10 + i_127_, 532);
                    } else if (tracks.getSelectedIndex() != 0 && button("      Play  >      ", 110, 495, 2, false)) {
                        if (!ltrackname.equals(tracks.getSelectedItem())) {
                            track.unload();
                            track = new RadicalMod(new StringBuilder().append("mystages/mymusic/")
                                    .append(tracks.getSelectedItem()).append(".zip").toString(), 300, 8000, 125, true,
                                    false);
                            if (track.loaded == 2) {
                                avon = track.sClip.stream.available();
                                ltrackname = tracks.getSelectedItem();
                            } else
                                ltrackname = "";
                        }
                        if (!ltrackname.equals(""))
                            track.play();
                        else
                            JOptionPane.showMessageDialog(null,
                                    new StringBuilder().append("Failed to load '").append(tracks.getSelectedItem())
                                            .append("', please make sure it is a valid MOD Track!").toString(),
                                    "Stage Maker", 1);
                    }
                    if (tracks.getSelectedIndex() != 0) {
                        if (button("   Set as the stage's Sound Track  >   ", 330, 466, 2, false)) {
                            if (!ltrackname.equals(tracks.getSelectedItem())) {
                                track.unload();
                                track = new RadicalMod(new StringBuilder().append("mystages/mymusic/")
                                        .append(tracks.getSelectedItem()).append(".zip").toString(), 300, 8000, 125,
                                        true, false);
                                if (track.loaded == 2) {
                                    avon = track.sClip.stream.available();
                                    ltrackname = tracks.getSelectedItem();
                                } else
                                    ltrackname = "";
                            }
                            if (!ltrackname.equals("")) {
                                trackname = ltrackname;
                                trackvol = (int) (220.0F / (track.rvol / 3750.0F));
                                try {
                                    final File file = new File(new StringBuilder().append("mystages/mymusic/")
                                            .append(trackname).append(".zip").toString());
                                    tracksize = (int) (file.length() / 1024L);
                                    if (tracksize > 250) {
                                        JOptionPane.showMessageDialog(null,
                                                new StringBuilder().append("Cannot use '")
                                                        .append(tracks.getSelectedItem())
                                                        .append("' as the sound track!\nIts file size is bigger then 250KB.\n\n")
                                                        .toString(),
                                                "Stage Maker", 1);
                                        trackname = "";
                                    }
                                } catch (final Exception exception) {
                                    tracksize = 111;
                                }
                            } else
                                JOptionPane.showMessageDialog(null,
                                        new StringBuilder().append("Failed to load '").append(tracks.getSelectedItem())
                                                .append("', please make sure it is a valid MOD Track!").toString(),
                                        "Stage Maker", 1);
                        }
                        if (button("   X Delete   ", 258, 495, 2, false) && JOptionPane.showConfirmDialog(null,
                                new StringBuilder()
                                        .append("Are you sure you want to permanently delete this MOD Track from your Play List?\n\n")
                                        .append(tracks.getSelectedItem())
                                        .append("\n\n>  If you delete this Track from the Play List you will not be able to use it for other stages as well!     \n\n")
                                        .toString(),
                                "Stage Maker", 0) == 0)
                            deltrack();
                    }
                    if (button("   Add a new MOD Track from file . . .  ", 330, 530, 0, false)
                            && JOptionPane.showConfirmDialog(null,
                                    "The game only accepts MOD format music files for the game ('.mod' file extension).\nA good place to find MOD Tracks is the modarchive.com, all the current MOD Tracks\nthat are distributed with the game are from the modarchive.com.\n\nTo find out more about MOD Tracks and to learn how to compose & remix your own\nmusic, please read the section of the Stage Maker help about it.\n\nThe MOD Track needs to be compressed in a zip file to be added here, please make\nsure the MOD Track you wish to add to your stages sound track play list is zipped before\nadding it here.\nThe ZIP file must also be less then 250KB in size.\n\nIs the track you are about to insert a MOD Track in a ZIP file that is less then 250KB?\n",
                                    "Stage Maker", 0) == 0) {
                        File file = null;
                        final FileDialog filedialog = new FileDialog(new Frame(),
                                "Stage Maker - Add MOD Track file to stage sound track play list!");
                        filedialog.setFile("*.zip");
                        filedialog.setMode(0);
                        filedialog.setVisible(true);
                        try {
                            if (filedialog.getFile() != null)
                                file = new File(new StringBuilder().append("").append(filedialog.getDirectory())
                                        .append("").append(filedialog.getFile()).append("").toString());
                        } catch (final Exception exception) {
                            /* empty */
                        }
                        if (file != null)
                            try {
                                if (file.length() / 1024L < 250L) {
                                    File file_128_ = new File("mystages/mymusic/");
                                    if (!file_128_.exists())
                                        file_128_.mkdirs();
                                    file_128_ = new File(new StringBuilder().append("mystages/mymusic/")
                                            .append(file.getName()).append("").toString());
                                    final FileInputStream fileinputstream = new FileInputStream(file);
                                    final FileOutputStream fileoutputstream = new FileOutputStream(file_128_);
                                    final byte[] is_129_ = new byte[1024];
                                    int i_130_;
                                    while ((i_130_ = fileinputstream.read(is_129_)) > 0)
                                        fileoutputstream.write(is_129_, 0, i_130_);
                                    fileinputstream.close();
                                    fileoutputstream.close();
                                    tracks.removeAll();
                                    tracks.add(rd, "Select MOD Track                      ");
                                    final String[] strings_131_ = new File("mystages/mymusic/").list();
                                    if (strings_131_ != null)
                                        for (int i_132_ = 0; i_132_ < strings_131_.length; i_132_++)
                                            if (strings_131_[i_132_].toLowerCase().endsWith(".zip"))
                                                tracks.add(rd, strings_131_[i_132_].substring(0,
                                                        strings_131_[i_132_].length() - 4));
                                    tracks.select(file.getName().substring(0, file.getName().length() - 4));
                                } else
                                    JOptionPane.showMessageDialog(null,
                                            "The selected file is larger then 250KB in size and therefore cannot be added!",
                                            "Stage Maker", 1);
                            } catch (final Exception exception) {
                                JOptionPane.showMessageDialog(null, new StringBuilder()
                                        .append("Unable to copy file! Error Deatials:\n").append(exception).toString(),
                                        "Stage Maker", 1);
                            }
                    }
                    final int i_133_ = 200;
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Sound Track", 280 + i_133_, 461);
                    String string = trackname;
                    if (string.equals(""))
                        string = "No Sound Track set.";
                    else if (button("   <  Remove Track   ", 378, 495, 2, false))
                        trackname = "";
                    rd.drawString(string, 629 - ftm.stringWidth(string) / 2, 482);
                    rd.setColor(new Color(128, 128, 128));
                    rd.drawLine(270 + i_133_, 457, 277 + i_133_, 457);
                    rd.drawLine(589 + i_133_, 457, 353 + i_133_, 457);
                    rd.drawLine(270 + i_133_, 457, 270 + i_133_, 497);
                    rd.drawLine(589 + i_133_, 457, 589 + i_133_, 497);
                    rd.drawLine(270 + i_133_, 497, 589 + i_133_, 497);
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
                    rd.setColor(new Color(0, 0, 0));
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Test Drive the Stage", 400 - ftm.stringWidth("Test Drive the Stage") / 2, 470);
                    witho.move(342, 480);
                    if (!witho.isShowing())
                        witho.setVisible(true);
                    if (button("     TEST DRIVE!     ", 400, 530, 0, true)) {
                        savefile();
                        errd = 0;
                        readstage(3);
                        if (cp.nsp < 2)
                            errd = 7;
                        if (errd == 0) {
                            Madness.testcar = stagename;
                            Madness.testdrive = witho.getSelectedIndex() + 3;
                            Madness.game();
                        } else
                            JOptionPane.showMessageDialog(null,
                                    new StringBuilder()
                                            .append("Error!  This stage is not ready for a test drive!\nReason:\n")
                                            .append(errlo[errd - 1]).append("\n\n").toString(),
                                    "Stage Maker", 0);
                    }
                }
                if (dtabed != dtab)
                    if (dtabed == -2)
                        dtabed = -1;
                    else
                        dtabed = dtab;
            }
            if (tab == 3) {
                rd.setFont(new Font("Arial", 1, 13));
                rd.setColor(new Color(0, 0, 0));
                rd.drawString(
                        new StringBuilder().append("Publish Stage :  [ ").append(stagename).append(" ]").toString(), 30,
                        50);
                rd.drawString("Publishing Type :", 30, 80);
                pubtyp.move(150, 63);
                if (!pubtyp.isShowing()) {
                    pubtyp.setVisible(true);
                    pubtyp.select(1);
                }
                rd.setColor(new Color(0, 0, 0));
                rd.setFont(new Font("Arial", 0, 12));
                if (pubtyp.getSelectedIndex() == 0) {
                    rd.drawString(
                            "Private :  This means only you can have your stage in your account and no one else can add",
                            268, 72);
                    rd.drawString("it to their account to play it!", 268, 88);
                }
                if (pubtyp.getSelectedIndex() == 1) {
                    rd.drawString(
                            "Public :  This means anyone can add this stage to their account to play it, but only you can",
                            268, 72);
                    rd.drawString("download it to your Stage Maker and edit it (no one else but you can edit it).", 268,
                            88);
                }
                if (pubtyp.getSelectedIndex() == 2) {
                    rd.drawString(
                            "Super Public :  This means anyone can add this stage to their account to play it and can also",
                            268, 72);
                    rd.drawString("download it to their stage Maker, edit it and publish it.", 268, 88);
                }
                rd.setFont(new Font("Arial", 1, 12));
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
                    if (logged == 0)
                        JOptionPane.showMessageDialog(null,
                                "Please login to retrieve your account first before publishing!", "Stage Maker", 1);
                    if (logged == 3 || logged == -1) {
                        savefile();
                        errd = 0;
                        readstage(3);
                        if (cp.nsp < 2)
                            errd = 7;
                        rd.setFont(new Font("Arial", 1, 12));
                        ftm = rd.getFontMetrics();
                        if (ftm.stringWidth(stagename) > 274)
                            errd = 8;
                        if (errd == 0) {
                            int i = 0;
                            for (int i_134_ = 0; i_134_ < nms; i_134_++)
                                if (mystages[i_134_].equals(stagename)
                                        && maker[i_134_].toLowerCase().equals(tnick.getText().toLowerCase()))
                                    i = JOptionPane.showConfirmDialog(null,
                                            new StringBuilder().append("Replace your already online stage '")
                                                    .append(stagename).append("' with this one?").toString(),
                                            "Stage Maker", 0);
                            if (i == 0) {
                                setCursor(new Cursor(3));
                                rd.setFont(new Font("Arial", 1, 13));
                                ftm = rd.getFontMetrics();
                                rd.setColor(new Color(225, 225, 225));
                                rd.fillRect(11, 141, 779, 401);
                                rd.setColor(new Color(0, 0, 0));
                                rd.drawString("Connecting to Server...",
                                        400 - ftm.stringWidth("Connecting to Server...") / 2, 250);
                                repaint();
                                int i_135_ = -1;
                                try {
                                    final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                    final BufferedReader bufferedreader = new BufferedReader(
                                            new InputStreamReader(socket.getInputStream()));
                                    final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                                    printwriter.println(new StringBuilder().append("20|").append(tnick.getText())
                                            .append("|").append(tpass.getText()).append("|").append(stagename)
                                            .append("|").append(pubtyp.getSelectedIndex()).append("|").toString());
                                    String string = bufferedreader.readLine();
                                    if (string != null)
                                        i_135_ = servervalue(string, 0);
                                    if (i_135_ == 0) {
                                        String string_136_ = " Publishing Stage ";
                                        final String string_137_ = new StringBuilder().append("").append(tstage)
                                                .append("\r\n").append(bstage).append("").toString();
                                        final DataInputStream datainputstream = new DataInputStream(
                                                new ByteArrayInputStream(string_137_.getBytes()));
                                        String string_139_;
                                        while ((string_139_ = datainputstream.readLine()) != null) {
                                            string_139_ = string_139_.trim();
                                            printwriter.println(string_139_);
                                            rd.setColor(new Color(225, 225, 225));
                                            rd.fillRect(11, 141, 779, 401);
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.drawString(string_136_, 400 - ftm.stringWidth(string_136_) / 2, 250);
                                            string_136_ = new StringBuilder().append("| ").append(string_136_)
                                                    .append(" |").toString();
                                            if (string_136_.equals(
                                                    "| | | | | | | | | | | | | | | | | | | | | | | |  Publishing Stage  | | | | | | | | | | | | | | | | | | | | | | | |"))
                                                string_136_ = " Publishing Stage ";
                                            repaint();
                                            try {
                                                if (thredo != null) {
                                                    /* empty */
                                                }
                                                Thread.sleep(10L);
                                            } catch (final InterruptedException interruptedexception) {
                                                /* empty */
                                            }
                                        }
                                        printwriter.println("QUITX1111");
                                        rd.setColor(new Color(225, 225, 225));
                                        rd.fillRect(11, 141, 779, 401);
                                        rd.setColor(new Color(0, 0, 0));
                                        rd.drawString("Creating the stage online...",
                                                400 - ftm.stringWidth("Creating the stage online...") / 2, 250);
                                        rd.drawString("This may take a couple of minutes, please wait...", 400
                                                - ftm.stringWidth("This may take a couple of minutes, please wait...")
                                                        / 2,
                                                280);
                                        repaint();
                                        string = bufferedreader.readLine();
                                        if (string != null)
                                            i_135_ = servervalue(string, 0);
                                        else
                                            i_135_ = -1;
                                        if (i_135_ == 0) {
                                            rd.setColor(new Color(225, 225, 225));
                                            rd.fillRect(11, 141, 779, 401);
                                            rd.setColor(new Color(0, 0, 0));
                                            rd.drawString("Uploading stage's sound track...",
                                                    400 - ftm.stringWidth("Uploading Stage's Sound Track...") / 2, 250);
                                            rd.drawString("This may take a couple of minutes, please wait...",
                                                    400 - ftm.stringWidth(
                                                            "This may take a couple of minutes, please wait...") / 2,
                                                    280);
                                            repaint();
                                            final File file = new File(new StringBuilder().append("mystages/mymusic/")
                                                    .append(trackname).append(".zip").toString());
                                            if (!trackname.equals("") && file.exists()) {
                                                final int i_140_ = (int) file.length();
                                                printwriter
                                                        .println(new StringBuilder().append("track|").append(trackname)
                                                                .append("|").append(i_140_).append("|").toString());
                                                string = bufferedreader.readLine();
                                                if (string != null)
                                                    i_135_ = servervalue(string, 0);
                                                else
                                                    i_135_ = -2;
                                                if (i_135_ == 0) {
                                                    final FileInputStream fileinputstream = new FileInputStream(file);
                                                    final byte[] is = new byte[i_140_];
                                                    fileinputstream.read(is);
                                                    fileinputstream.close();
                                                    final DataOutputStream dataoutputstream = new DataOutputStream(
                                                            socket.getOutputStream());
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
                                } catch (final Exception exception) {
                                    i_135_ = -1;
                                }
                                setCursor(new Cursor(0));
                                boolean bool = false;
                                if (i_135_ == 0) {
                                    logged = 1;
                                    bool = true;
                                }
                                if (i_135_ == 3) {
                                    JOptionPane
                                            .showMessageDialog(null,
                                                    new StringBuilder().append("Unable to publish stage.\nReason:\n")
                                                            .append(errlo[6]).append("\n\n").toString(),
                                                    "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == 4) {
                                    JOptionPane.showMessageDialog(null,
                                            new StringBuilder()
                                                    .append("Unable to publish stage.\nReason:\nStage name used (")
                                                    .append(stagename).append(").\nThe name '").append(stagename)
                                                    .append("' is already used by another published stage.\nPlease rename your stage.\n\n")
                                                    .toString(),
                                            "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == 5) {
                                    JOptionPane.showMessageDialog(null,
                                            "Unable to create stage online!  Unknown Error.  Please try again later.",
                                            "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ > 5) {
                                    JOptionPane.showMessageDialog(null,
                                            "Unable to publish stage fully!  Unknown Error.  Please try again later.",
                                            "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == -4) {
                                    logged = 1;
                                    JOptionPane.showMessageDialog(null,
                                            "Unable to upload sound track!\nReason:\nAnother MOD Track is already uploaded with the same name, please rename your Track.\nOpen your 'mystages' folder then open 'mymusic' to find your MOD Track to rename it.\n\n",
                                            "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == -3) {
                                    logged = 1;
                                    JOptionPane.showMessageDialog(null,
                                            "Unable to upload sound track!\nReason:\nYour MOD Track\u2019s file size is too large, Track file size must be less then 250KB to be accepted.\n\n",
                                            "Stage Maker", 1);
                                    bool = true;
                                }
                                if (i_135_ == -2) {
                                    logged = 1;
                                    JOptionPane.showMessageDialog(null,
                                            "Unable to upload sound track!  Unknown Error.  Please try again later.",
                                            "Stage Maker", 1);
                                    bool = true;
                                }
                                if (!bool)
                                    JOptionPane.showMessageDialog(null, "Unable to publish stage!  Unknown Error.",
                                            "Stage Maker", 1);
                            }
                        } else
                            JOptionPane.showMessageDialog(null,
                                    new StringBuilder()
                                            .append("Error!  This stage is not ready for publishing!\nReason:\n")
                                            .append(errlo[errd - 1]).append("\n\n").toString(),
                                    "Stage Maker", 0);
                    }
                }
                if (logged == 3)
                    for (int i = 0; i < nms; i++) {
                        rd.setColor(new Color(235, 235, 235));
                        if (xm > 11 && xm < 789 && ym > 142 + i * 20 && ym < 160 + i * 20)
                            rd.setColor(new Color(255, 255, 255));
                        rd.fillRect(11, 142 + i * 20, 778, 18);
                        rd.setFont(new Font("Arial", 0, 12));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString(mystages[i], 180 - ftm.stringWidth(mystages[i]) / 2, 156 + i * 20);
                        rd.setColor(new Color(155, 155, 155));
                        rd.drawLine(350, 145 + i * 20, 350, 157 + i * 20);
                        if (pubt[i] != -1) {
                            rd.drawLine(450, 145 + i * 20, 450, 157 + i * 20);
                            rd.drawLine(550, 145 + i * 20, 550, 157 + i * 20);
                            rd.drawLine(650, 145 + i * 20, 650, 157 + i * 20);
                            boolean bool = false;
                            if (maker[i].toLowerCase().equals(tnick.getText().toLowerCase())) {
                                bool = true;
                                rd.setColor(new Color(0, 64, 0));
                                rd.drawString("You", 400 - ftm.stringWidth("You") / 2, 156 + i * 20);
                            } else {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString(maker[i], 400 - ftm.stringWidth(maker[i]) / 2, 156 + i * 20);
                            }
                            if (nad[i] > 1) {
                                if (ovbutton(
                                        new StringBuilder().append("").append(nad[i]).append(" Players").toString(),
                                        500, 156 + i * 20)) {
                                    String string = new StringBuilder().append("[ ").append(mystages[i])
                                            .append(" ]  has been added by the following players to their accounts:     \n\n")
                                            .toString();
                                    int i_141_ = 0;
                                    for (int i_142_ = 0; i_142_ < nad[i]; i_142_++) {
                                        if (++i_141_ == 17) {
                                            string = new StringBuilder().append(string).append("\n").toString();
                                            i_141_ = 1;
                                        }
                                        string = new StringBuilder().append(string).append(addeda[i][i_142_])
                                                .toString();
                                        if (i_142_ != nad[i] - 1)
                                            if (i_142_ != nad[i] - 2)
                                                string = new StringBuilder().append(string).append(", ").toString();
                                            else if (i_141_ == 16) {
                                                string = new StringBuilder().append(string).append("\nand ").toString();
                                                i_141_ = 0;
                                            } else
                                                string = new StringBuilder().append(string).append(" and ").toString();
                                    }
                                    string = new StringBuilder().append(string).append("\n \n \n").toString();
                                    JOptionPane.showMessageDialog(null, string, "Stage Maker", 1);
                                }
                            } else {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("None", 500 - ftm.stringWidth("None") / 2, 156 + i * 20);
                            }
                            if (pubt[i] == 0) {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("Private", 600 - ftm.stringWidth("Private") / 2, 156 + i * 20);
                            }
                            if (pubt[i] == 1) {
                                rd.setColor(new Color(0, 0, 64));
                                rd.drawString("Public", 600 - ftm.stringWidth("Public") / 2, 156 + i * 20);
                            }
                            if (pubt[i] == 2) {
                                rd.setColor(new Color(0, 64, 0));
                                rd.drawString("Super Public", 600 - ftm.stringWidth("Super Public") / 2, 156 + i * 20);
                            }
                            if ((pubt[i] == 2 || bool) && ovbutton("Download", 700, 156 + i * 20)) {
                                int i_143_ = 0;
                                for (int i_144_ = 0; i_144_ < slstage.getItemCount(); i_144_++)
                                    if (mystages[i].equals(slstage.getItem(i_144_)))
                                        i_143_ = JOptionPane.showConfirmDialog(null,
                                                new StringBuilder().append("Replace the local ").append(mystages[i])
                                                        .append(" in your 'mystages' folder with the published online copy?")
                                                        .toString(),
                                                "Stage Maker", 0);
                                if (i_143_ == 0) {
                                    setCursor(new Cursor(3));
                                    rd.setFont(new Font("Arial", 1, 13));
                                    ftm = rd.getFontMetrics();
                                    rd.setColor(new Color(225, 225, 225));
                                    rd.fillRect(11, 141, 779, 401);
                                    rd.setColor(new Color(0, 0, 0));
                                    rd.drawString("Downloading stage, please wait...",
                                            400 - ftm.stringWidth("Downloading stage, please wait...") / 2, 250);
                                    repaint();
                                    try {
                                        String string = new StringBuilder()
                                                .append("http://multiplayer.needformadness.com/tracks/")
                                                .append(mystages[i]).append(".radq?reqlo=")
                                                .append((int) (Math.random() * 1000.0)).append("").toString();
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
                                            final byte[] is_146_ = new byte[i_145_ - 40];
                                            for (int i_147_ = 0; i_147_ < i_145_ - 40; i_147_++) {
                                                int i_148_ = 20;
                                                if (i_147_ >= 500)
                                                    i_148_ = 40;
                                                is_146_[i_147_] = is[i_147_ + i_148_];
                                            }
                                            zipinputstream = new ZipInputStream(new ByteArrayInputStream(is_146_));
                                        }
                                        final ZipEntry zipentry = zipinputstream.getNextEntry();
                                        if (zipentry != null) {
                                            String string_149_ = "";
                                            int i_150_ = Integer.valueOf(zipentry.getName()).intValue();
                                            final byte[] is_151_ = new byte[i_150_];
                                            int i_152_ = 0;
                                            int i_153_;
                                            for (/**/; i_150_ > 0; i_150_ -= i_153_) {
                                                i_153_ = zipinputstream.read(is_151_, i_152_, i_150_);
                                                i_152_ += i_153_;
                                            }
                                            String string_154_ = new String(is_151_);
                                            string_154_ = new StringBuilder().append(string_154_).append("\n")
                                                    .toString();
                                            String string_155_ = "";
                                            int i_156_ = 0;
                                            int i_157_ = string_154_.indexOf("\n", 0);
                                            while (i_157_ != -1 && i_156_ < string_154_.length()) {
                                                String string_158_ = string_154_.substring(i_156_, i_157_);
                                                string_158_ = string_158_.trim();
                                                i_156_ = i_157_ + 1;
                                                i_157_ = string_154_.indexOf("\n", i_156_);
                                                if (!string_158_.startsWith("stagemaker(")
                                                        && !string_158_.startsWith("publish("))
                                                    string_155_ = new StringBuilder().append(string_155_).append("")
                                                            .append(string_158_).append("\r\n").toString();
                                                else {
                                                    string_155_ = string_155_.trim();
                                                    string_155_ = new StringBuilder().append(string_155_).append("\r\n")
                                                            .toString();
                                                }
                                                if (string_158_.startsWith("soundtrack"))
                                                    string_149_ = getstring("soundtrack", string_158_, 0);
                                            }
                                            string_155_ = string_155_.trim();
                                            string_155_ = new StringBuilder().append(string_155_).append("\r\n\r\n")
                                                    .toString();
                                            File file = new File("mystages/");
                                            if (!file.exists())
                                                file.mkdirs();
                                            file = new File(new StringBuilder().append("mystages/").append(mystages[i])
                                                    .append(".txt").toString());
                                            final BufferedWriter bufferedwriter = new BufferedWriter(
                                                    new FileWriter(file));
                                            bufferedwriter.write(string_155_);
                                            bufferedwriter.close();
                                            zipinputstream.close();
                                            if (!string_149_.equals(""))
                                                try {
                                                    rd.setColor(new Color(0, 0, 0));
                                                    rd.drawString("Downloading stage's sound track...", 400
                                                            - ftm.stringWidth("Downloading stage's sound track...") / 2,
                                                            280);
                                                    repaint();
                                                    string = new StringBuilder()
                                                            .append("http://multiplayer.needformadness.com/tracks/music/")
                                                            .append(string_149_).append(".zip").toString();
                                                    string = string.replace(' ', '_');
                                                    url = new URL(string);
                                                    i_145_ = url.openConnection().getContentLength();
                                                    file = new File(new StringBuilder().append("mystages/mymusic/")
                                                            .append(string_149_).append(".zip").toString());
                                                    if (file.exists())
                                                        if (file.length() == i_145_)
                                                            i_143_ = 1;
                                                        else
                                                            i_143_ = JOptionPane.showConfirmDialog(null,
                                                                    new StringBuilder().append("Another track named '")
                                                                            .append(string_149_)
                                                                            .append("' already exists in your Sound Tracks folder!\nReplace it with the one attached to this stage?")
                                                                            .toString(),
                                                                    "Stage Maker", 0);
                                                    if (i_143_ == 0) {
                                                        datainputstream = new DataInputStream(url.openStream());
                                                        is = new byte[i_145_];
                                                        datainputstream.readFully(is);
                                                        datainputstream.close();
                                                        final FileOutputStream fileoutputstream = new FileOutputStream(
                                                                file);
                                                        fileoutputstream.write(is);
                                                        fileoutputstream.close();
                                                    }
                                                } catch (final Exception exception) {
                                                    /* empty */
                                                }
                                            setCursor(new Cursor(0));
                                            JOptionPane.showMessageDialog(null,
                                                    new StringBuilder().append("").append(mystages[i])
                                                            .append(" has been successfully downloaded!").toString(),
                                                    "Stage Maker", 1);
                                        } else
                                            JOptionPane.showMessageDialog(null,
                                                    "Unable to download stage.  Unknown Error!     \nPlease try again later.",
                                                    "Stage Maker", 1);
                                    } catch (final Exception exception) {
                                        JOptionPane.showMessageDialog(null,
                                                "Unable to download stage.  Unknown Error!     \nPlease try again later.",
                                                "Stage Maker", 1);
                                    }
                                }
                            }
                        } else
                            rd.drawString("-    Error Loading this stage's info!    -",
                                    550 - ftm.stringWidth("-    Error Loading this stage's info!    -") / 2,
                                    156 + i * 20);
                        if (ovbutton("X", 765, 156 + i * 20)
                                && JOptionPane
                                        .showConfirmDialog(null,
                                                new StringBuilder().append("Remove ").append(mystages[i])
                                                        .append(" from your account?").toString(),
                                                "Stage Maker", 0) == 0) {
                            setCursor(new Cursor(3));
                            int i_160_ = -1;
                            try {
                                final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                                final BufferedReader bufferedreader = new BufferedReader(
                                        new InputStreamReader(socket.getInputStream()));
                                final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                                printwriter.println(new StringBuilder().append("19|").append(tnick.getText())
                                        .append("|").append(tpass.getText()).append("|").append(mystages[i]).append("|")
                                        .toString());
                                final String string = bufferedreader.readLine();
                                if (string != null)
                                    i_160_ = servervalue(string, 0);
                                socket.close();
                            } catch (final Exception exception) {
                                i_160_ = -1;
                            }
                            if (i_160_ == 0)
                                logged = 1;
                            else {
                                setCursor(new Cursor(0));
                                JOptionPane.showMessageDialog(null,
                                        new StringBuilder().append("Failed to remove ").append(mystages[i])
                                                .append(" from your account.  Unknown Error!     \nPlease try again later.")
                                                .toString(),
                                        "Stage Maker", 1);
                            }
                        }
                    }
                if (logged == 2) {
                    for (int i = 0; i < nms; i++) {
                        rd.setFont(new Font("Arial", 1, 13));
                        ftm = rd.getFontMetrics();
                        rd.setColor(new Color(225, 225, 225));
                        rd.fillRect(50, 150, 600, 150);
                        rd.setColor(new Color(0, 0, 0));
                        rd.drawString(
                                new StringBuilder().append("Loading ").append(mystages[i]).append("\u2018s info...")
                                        .toString(),
                                400 - ftm.stringWidth(new StringBuilder().append("Loading ").append(mystages[i])
                                        .append("\u2018s info...").toString()) / 2,
                                220);
                        repaint();
                        maker[i] = "Unkown";
                        pubt[i] = -1;
                        nad[i] = 0;
                        String string = "";
                        try {
                            String string_161_ = new StringBuilder()
                                    .append("http://multiplayer.needformadness.com/tracks/").append(mystages[i])
                                    .append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString();
                            string_161_ = string_161_.replace(' ', '_');
                            final URL url = new URL(string_161_);
                            final DataInputStream datainputstream = new DataInputStream(url.openStream());
                            while ((string = datainputstream.readLine()) != null) {
                                string = new StringBuilder().append("").append(string.trim()).toString();
                                if (string.startsWith("details")) {
                                    maker[i] = getSvalue("details", string, 0);
                                    pubt[i] = Utility.getvalue("details", string, 1);
                                    boolean bool = false;
                                    while (!bool) {
                                        addeda[i][nad[i]] = getSvalue("details", string, 2 + nad[i]);
                                        if (addeda[i][nad[i]].equals(""))
                                            bool = true;
                                        else
                                            nad[i]++;
                                    }
                                }
                            }
                        } catch (final Exception exception) {
                            /* empty */
                        }
                    }
                    setCursor(new Cursor(0));
                    logged = 3;
                }
                if (logged == -1) {
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Account empty, no published stages found.",
                            400 - ftm.stringWidth("Account empty, no published stages found.") / 2, 220);
                    rd.drawString("Click \u2018Publish\u2019 above to begin.",
                            400 - ftm.stringWidth("Click \u2018Publish\u2019 above to begin.") / 2, 280);
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.drawString("The maximum number of stages your account can have at once is 20 stages.",
                            400 - ftm.stringWidth(
                                    "The maximum number of stages your account can have at once is 20 stages.") / 2,
                            320);
                }
                if (logged == 1) {
                    rd.setColor(new Color(225, 225, 225));
                    rd.fillRect(11, 141, 779, 401);
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.setColor(new Color(0, 0, 0));
                    rd.drawString("Loading your account's stage list...",
                            400 - ftm.stringWidth("Loading your account's stage list...") / 2, 220);
                    repaint();
                    nms = 0;
                    String string = "";
                    try {
                        final URL url = new URL(new StringBuilder()
                                .append("http://multiplayer.needformadness.com/tracks/lists/").append(tnick.getText())
                                .append(".txt?reqlo=").append((int) (Math.random() * 1000.0)).append("").toString());
                        final DataInputStream datainputstream = new DataInputStream(url.openStream());
                        while ((string = datainputstream.readLine()) != null) {
                            string = new StringBuilder().append("").append(string.trim()).toString();
                            if (string.startsWith("mystages")) {
                                boolean bool = true;
                                while (bool && nms < 20) {
                                    mystages[nms] = getSvalue("mystages", string, nms);
                                    if (mystages[nms].equals(""))
                                        bool = false;
                                    else
                                        nms++;
                                }
                            }
                        }
                        if (nms > 0)
                            logged = 2;
                        else {
                            setCursor(new Cursor(0));
                            logged = -1;
                        }
                        datainputstream.close();
                    } catch (final Exception exception) {
                        final String string_162_ = new StringBuilder().append("").append(exception).toString();
                        if (string_162_.indexOf("FileNotFound") != -1) {
                            setCursor(new Cursor(0));
                            logged = -1;
                        } else {
                            logged = 0;
                            JOptionPane.showMessageDialog(null,
                                    "Unable to connect to server at this moment, please try again later.",
                                    "Stage Maker", 1);
                        }
                    }
                }
                if (logged == 0) {
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.drawString("The maximum number of stages your account can have at once is 20 stages.",
                            400 - ftm.stringWidth(
                                    "The maximum number of stages your account can have at once is 20 stages.") / 2,
                            180);
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Login to Retrieve your Account Stages",
                            400 - ftm.stringWidth("Login to Retrieve your Account Stages") / 2, 220);
                    rd.drawString("Nickname:", 376 - ftm.stringWidth("Nickname:") - 14, 266);
                    if (!tnick.isShowing())
                        tnick.setVisible(true);
                    movefield(tnick, 376, 250, 129, 23);
                    rd.drawString("Password:", 376 - ftm.stringWidth("Password:") - 14, 296);
                    if (!tpass.isShowing())
                        tpass.setVisible(true);
                    movefield(tpass, 376, 280, 129, 23);
                    if (button("       Login       ", 400, 340, 0, true)) {
                        setCursor(new Cursor(3));
                        int i = -1;
                        try {
                            final Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                            final BufferedReader bufferedreader = new BufferedReader(
                                    new InputStreamReader(socket.getInputStream()));
                            final PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
                            printwriter.println(new StringBuilder().append("1|").append(tnick.getText().toLowerCase())
                                    .append("|").append(tpass.getText()).append("|").toString());
                            final String string = bufferedreader.readLine();
                            if (string != null)
                                i = servervalue(string, 0);
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
                            setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!",
                                    "Stage Maker", 0);
                        }
                        if (i == -167) {
                            setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null,
                                    "Sorry.  Trial accounts are not allowed to publish cars & stages, please register a full account!",
                                    "Stage Maker", 0);
                        }
                        if (i == -1) {
                            setCursor(new Cursor(0));
                            JOptionPane.showMessageDialog(null,
                                    "Unable to connect to server at this moment, please try again later.",
                                    "Stage Maker", 1);
                        }
                    }
                    rd.setFont(new Font("Arial", 1, 13));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Not registered yet?", 400 - ftm.stringWidth("Not registered yet?") / 2, 450);
                    if (button("   Register Now!   ", 400, 480, 0, true))
                        Madness.openurl("http://multiplayer.needformadness.com/register.html");
                    rd.setFont(new Font("Arial", 0, 12));
                    ftm = rd.getFontMetrics();
                    rd.drawString("Register to publish your stages to the multiplayer game!",
                            400 - ftm.stringWidth("Register to publish your stages to the multiplayer game!") / 2, 505);
                }
            }
            if (tabed != tab)
                if (tabed == -2)
                    tabed = -1;
                else
                    tabed = tab;
            rd.setColor(new Color(0, 0, 0));
            rd.fillRect(0, 0, 800, 25);
            if (!onbtgame)
                rd.drawImage(btgame[0], 620, 0, null);
            else
                rd.drawImage(btgame[1], 620, 0, null);
            rd.setFont(new Font("Arial", 1, 13));
            ftm = rd.getFontMetrics();
            final String[] strings = {
                    "Stage", "Build", "View & Edit", "Publish"
            };
            final int[] is = {
                    0, 0, 100, 90
            };
            final int[] is_163_ = {
                    0, 25, 25, 0
            };
            int i = 4;
            if (stagename.equals("") || sfase != 0) {
                tab = 0;
                i = 1;
            }
            for (int i_164_ = 0; i_164_ < i; i_164_++) {
                rd.setColor(new Color(170, 170, 170));
                if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25)
                    rd.setColor(new Color(200, 200, 200));
                if (tab == i_164_)
                    rd.setColor(new Color(225, 225, 225));
                rd.fillPolygon(is, is_163_, 4);
                rd.setColor(new Color(0, 0, 0));
                rd.drawString(strings[i_164_], i_164_ * 100 + 45 - ftm.stringWidth(strings[i_164_]) / 2, 17);
                if (xm > is[0] && xm < is[3] && ym > 0 && ym < 25 && mousePressed == -1)
                    tab = i_164_;
                for (int i_165_ = 0; i_165_ < 4; i_165_++)
                    is[i_165_] += 100;
            }
            if (mousePressed == -1)
                mousePressed = 0;
            drawms();
            repaint();
            if (!exwist)
                try {
                    if (thredo != null) {
                        /* empty */
                    }
                    Thread.sleep(40L);
                } catch (final InterruptedException interruptedexception) {
                    /* empty */
                }
        }
        track.unload();
        track = null;
        rd.dispose();
        System.gc();
        //bco[selectedPart].x = ;
        //bco[selectedPart].z = ;
        //bco[selectedPart].y =;
        //bco[selectedPart].xz = ;
    }

    public void savefile() {
        try {
            File file = new File("mystages/");
            if (!file.exists())
                file.mkdirs();
            file = new File(new StringBuilder().append("mystages/").append(stagename).append(".txt").toString());
            final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
            bufferedwriter.write(tstage);
            bufferedwriter.write(bstage);
            bufferedwriter.close();
        } catch (final Exception exception) {
            JOptionPane.showMessageDialog(null,
                    new StringBuilder().append("Unable to save file! Error Deatials:\n").append(exception).toString(),
                    "Stage Maker", 1);
        }
        savesettings();
    }

    public void savesettings() {
        if (!sstage.equals(stagename) || !suser.equals(tnick.getText())) {
            final String string = new StringBuilder().append("").append(stagename).append("\n").append(tnick.getText())
                    .append("\n\n").toString();
            sstage = stagename;
            suser = tnick.getText();
            try {
                File file = new File("mystages/");
                if (!file.exists())
                    file.mkdirs();
                file = new File("mystages/settings.data");
                final BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file));
                bufferedwriter.write(string);
                bufferedwriter.close();
            } catch (final Exception exception) {
                /* empty */
            }
        }
    }

    // Removed unused code found by UCDetector
    // 	public String serverSvalue(final String string, final int i) {
    // 		String string_365_ = "";
    // 		try {
    // 			int i_366_ = 0;
    // 			int i_367_ = 0;
    // 			int i_368_ = 0;
    // 			String string_369_ = "";
    // 			String string_370_ = "";
    // 			for (/**/; i_366_ < string.length() && i_368_ != 2; i_366_++) {
    // 				string_369_ = new StringBuilder().append("").append(string.charAt(i_366_)).toString();
    // 				if (string_369_.equals("|")) {
    // 					i_367_++;
    // 					if (i_368_ == 1 || i_367_ > i)
    // 						i_368_ = 2;
    // 				} else if (i_367_ == i) {
    // 					string_370_ = new StringBuilder().append(string_370_).append(string_369_).toString();
    // 					i_368_ = 1;
    // 				}
    // 			}
    // 			string_365_ = string_370_;
    // 		} catch (final Exception exception) {
    // 			/* empty */
    // 		}
    // 		return string_365_;
    // 	}

    public int servervalue(final String string, final int i) {
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
        } catch (final Exception exception) {
            /* empty */
        }
        return i_359_;
    }

    public void sortop() {
        tstage = new StringBuilder().append("snap(").append(m.snap[0]).append(",").append(m.snap[1])
                .append(",").append(m.snap[2]).append(")\r\nsky(").append(csky[0]).append(",").append(csky[1])
                .append(",").append(csky[2]).append(")\r\nfog(").append(cfade[0]).append(",").append(cfade[1])
                .append(",").append(cfade[2]).append(")\r\nclouds(").append(cldd[0]).append(",").append(cldd[1])
                .append(",").append(cldd[2]).append(",").append(cldd[3]).append(",").append(cldd[4])
                .append(")\r\nground(").append(cgrnd[0]).append(",").append(cgrnd[1]).append(",").append(cgrnd[2])
                .append(")\r\ntexture(").append(texture[0]).append(",").append(texture[1]).append(",")
                .append(texture[2]).append(",").append(texture[3]).append(")\r\nfadefrom(").append(origfade)
                .append(")\r\ndensity(").append((m.fogd + 1) / 2 - 1).append(")\r\nmountains(").append(m.mgen)
                .append(")\r\nnlaps(").append(cp.nlaps).append(")\r\n").toString();
        if (!trackname.equals("")) {
            final StringBuilder stringbuilder = new StringBuilder();
            final StageMaker stagemaker_239_ = this;
            stagemaker_239_.tstage = stringbuilder.append(stagemaker_239_.tstage).append("soundtrack(")
                    .append(trackname).append(",").append(trackvol).append(",").append(tracksize).append(")\r\n")
                    .toString();
        }
        for (int i = 0; i < 3; i++)
            snap[i] = (int) (m.snap[i] / 1.2F + 50.0F);
        if (snap[0] + snap[1] + snap[2] <= 110) {
            final StringBuilder stringbuilder = new StringBuilder();
            final StageMaker stagemaker_240_ = this;
            stagemaker_240_.tstage = stringbuilder.append(stagemaker_240_.tstage).append("lightson()\r\n").toString();
        }
        final StringBuilder stringbuilder = new StringBuilder();
        final StageMaker stagemaker_241_ = this;
        stagemaker_241_.tstage = stringbuilder.append(stagemaker_241_.tstage).append("\r\n").toString();
    }

    public void sortstage() {
        final int[] is = new int[nob * 2];
        final int[] is_242_ = new int[nob * 2];
        for (int i = 0; i < nob; i++)
            is[i] = 0;
        int i = 0;
        int i_243_ = 0;
        is_242_[i_243_] = 0;
        i_243_++;
        boolean bool = false;
        int i_244_ = 0;
        while (!bool) {
            final int[] is_245_ = {
                    co[i].x + atp[co[i].colok][0], co[i].x + atp[co[i].colok][2]
            };
            final int[] is_246_ = {
                    co[i].z + atp[co[i].colok][1], co[i].z + atp[co[i].colok][3]
            };
            int i_247_ = co[i].roofat;
            if (co[i].colok == 2)
                i_247_ += 30;
            if (co[i].colok == 3)
                i_247_ -= 30;
            if (co[i].colok == 15)
                i_247_ -= 90;
            if (co[i].colok == 20)
                i_247_ -= 180;
            if (co[i].colok == 26)
                i_247_ -= 90;
            rot(is_245_, is_246_, co[i].x, co[i].z, i_247_, 2);
            int i_248_ = -1;
            int i_249_ = -1;
            if (i_244_ != 0)
                for (int i_250_ = 0; i_250_ < nob; i_250_++) {
                    boolean bool_251_ = false;
                    if (i_243_ == 2 && i_250_ == 0)
                        bool_251_ = true;
                    if (i != i_250_ && !bool_251_ && is[i_250_] == 0
                            && (co[i_250_].colok <= 14 || co[i_250_].colok >= 33)
                            && (co[i_250_].colok < 39 || co[i_250_].colok >= 46) && co[i_250_].colok < 52) {
                        int i_252_ = 0;
                        if (co[i_250_].colok != 2 && co[i_250_].colok != 3 && co[i_250_].colok != 4
                                && co[i_250_].colok != 7 && co[i_250_].colok != 9) {
                            if (i_244_ == 1 && co[i_250_].z > co[i].z && Math.abs(co[i_250_].x - co[i].x) < 1000
                                    && (co[i_250_].roofat == 180 || co[i_250_].roofat == 0))
                                i_252_ = 1;
                            if (i_244_ == 2 && co[i_250_].z < co[i].z && Math.abs(co[i_250_].x - co[i].x) < 1000
                                    && (co[i_250_].roofat == 180 || co[i_250_].roofat == 0))
                                i_252_ = 1;
                            if (i_244_ == 3 && co[i_250_].x > co[i].x && Math.abs(co[i_250_].z - co[i].z) < 1000
                                    && (co[i_250_].roofat == 90 || co[i_250_].roofat == -90))
                                i_252_ = 1;
                            if (i_244_ == 4 && co[i_250_].x < co[i].x && Math.abs(co[i_250_].z - co[i].z) < 1000
                                    && (co[i_250_].roofat == 90 || co[i_250_].roofat == -90))
                                i_252_ = 1;
                        } else
                            i_252_ = 2;
                        if (i_252_ != 0) {
                            final int[] is_253_ = {
                                    co[i_250_].x + atp[co[i_250_].colok][0], co[i_250_].x + atp[co[i_250_].colok][2]
                            };
                            final int[] is_254_ = {
                                    co[i_250_].z + atp[co[i_250_].colok][1], co[i_250_].z + atp[co[i_250_].colok][3]
                            };
                            i_247_ = co[i_250_].roofat;
                            if (co[i_250_].colok == 2)
                                i_247_ += 30;
                            if (co[i_250_].colok == 3)
                                i_247_ -= 30;
                            if (co[i_250_].colok == 15)
                                i_247_ -= 90;
                            if (co[i_250_].colok == 20)
                                i_247_ -= 180;
                            if (co[i_250_].colok == 26)
                                i_247_ -= 90;
                            rot(is_253_, is_254_, co[i_250_].x, co[i_250_].z, i_247_, 2);
                            if (i_250_ != 0) {
                                final int i_256_ = pyn(is_253_[0], is_245_[0], is_254_[0], is_246_[0]);
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
            if (i_249_ == -1)
                for (int i_258_ = 0; i_258_ < nob; i_258_++) {
                    boolean bool_259_ = false;
                    if (i_243_ == 2 && i_258_ == 0)
                        bool_259_ = true;
                    if (i != i_258_ && !bool_259_ && is[i_258_] == 0
                            && (co[i_258_].colok <= 14 || co[i_258_].colok >= 33)
                            && (co[i_258_].colok < 39 || co[i_258_].colok >= 46) && co[i_258_].colok < 52) {
                        final int[] is_260_ = {
                                co[i_258_].x + atp[co[i_258_].colok][0], co[i_258_].x + atp[co[i_258_].colok][2]
                        };
                        final int[] is_261_ = {
                                co[i_258_].z + atp[co[i_258_].colok][1], co[i_258_].z + atp[co[i_258_].colok][3]
                        };
                        i_247_ = co[i_258_].roofat;
                        if (co[i_258_].colok == 2)
                            i_247_ += 30;
                        if (co[i_258_].colok == 3)
                            i_247_ -= 30;
                        if (co[i_258_].colok == 15)
                            i_247_ -= 90;
                        if (co[i_258_].colok == 20)
                            i_247_ -= 180;
                        if (co[i_258_].colok == 26)
                            i_247_ -= 90;
                        rot(is_260_, is_261_, co[i_258_].x, co[i_258_].z, i_247_, 2);
                        if (i_258_ != 0) {
                            final int i_263_ = pyn(is_260_[0], is_245_[0], is_261_[0], is_246_[0]);
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
            if (i_249_ != -1) {
                i_244_ = 0;
                if (co[i_249_].colok != 2 && co[i_249_].colok != 3 && co[i_249_].colok != 4 && co[i_249_].colok != 7
                        && co[i_249_].colok != 9) {
                    if ((co[i_249_].roofat == 180 || co[i_249_].roofat == 0) && co[i_249_].z > co[i].z)
                        i_244_ = 1;
                    if ((co[i_249_].roofat == 180 || co[i_249_].roofat == 0) && co[i_249_].z < co[i].z)
                        i_244_ = 2;
                    if ((co[i_249_].roofat == 90 || co[i_249_].roofat == -90) && co[i_249_].x > co[i].x)
                        i_244_ = 3;
                    if ((co[i_249_].roofat == 90 || co[i_249_].roofat == -90) && co[i_249_].x < co[i].x)
                        i_244_ = 4;
                }
                if (co[i_249_].colok == 4 || co[i_249_].colok == 7 || co[i_249_].colok == 9)
                    is[i_249_] = 2;
                else
                    is[i_249_] = 1;
                if (co[i_249_].colok >= 46 && co[i_249_].colok <= 51)
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
        for (int i_265_ = 0; i_265_ < nob; i_265_++)
            if (is[i_265_] == 0 && (co[i_265_].colok <= 14 || co[i_265_].colok >= 33)
                    && (co[i_265_].colok < 39 || co[i_265_].colok >= 46) && co[i_265_].colok < 52) {
                is_242_[i_243_] = i_265_;
                i_243_++;
            }
        for (int i_266_ = 0; i_266_ < i_243_; i_266_++)
            if (co[is_242_[i_266_]].colok >= 46 && co[is_242_[i_266_]].colok <= 51)
                for (int i_267_ = i_266_ + 1; i_267_ < i_243_; i_267_++) {
                    final int i_268_ = pyn(co[is_242_[i_266_]].x, co[is_242_[i_267_]].x, co[is_242_[i_266_]].z,
                            co[is_242_[i_267_]].z);
                    if (i_268_ >= 0 && (co[is_242_[i_267_]].colok < 46 || co[is_242_[i_266_]].colok > 51)
                            && i_268_ < (co[is_242_[i_266_]].maxR + co[is_242_[i_267_]].maxR) / 100
                                    * ((co[is_242_[i_266_]].maxR + co[is_242_[i_267_]].maxR) / 100)) {
                        final int i_269_ = is_242_[i_267_];
                        for (int i_270_ = i_267_; i_270_ > i_266_; i_270_--)
                            is_242_[i_270_] = is_242_[i_270_ - 1];
                        is_242_[i_266_] = i_269_;
                        is[is_242_[i_266_]] = 0;
                        i_266_++;
                    }
                }
        int i_271_ = 1;
        for (int i_272_ = 0; i_272_ < cp.nsp; i_272_++)
            for (int i_273_ = 0; i_273_ < nob; i_273_++)
                if (co[i_273_].wh == i_272_ + 1
                        && (co[i_273_].colok == 30 || co[i_273_].colok == 32 || co[i_273_].colok == 54)) {
                    int i_274_ = -1;
                    int i_275_ = -1;
                    for (int i_276_ = i_271_; i_276_ < i_243_; i_276_++)
                        if (co[is_242_[i_276_]].colok != 30 && co[is_242_[i_276_]].colok != 32
                                && co[is_242_[i_276_]].colok != 54) {
                            final int i_277_ = pyn(co[i_273_].x, co[is_242_[i_276_]].x, co[i_273_].z,
                                    co[is_242_[i_276_]].z);
                            if (i_277_ >= 0 && (i_277_ < i_274_ || i_274_ == -1)) {
                                i_274_ = i_277_;
                                i_275_ = i_276_;
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
        for (int i_279_ = 0; i_279_ < nob; i_279_++)
            if (co[i_279_].wh == 0 && (co[i_279_].colok == 30 || co[i_279_].colok == 32 || co[i_279_].colok == 54)) {
                int i_280_ = -1;
                int i_281_ = -1;
                for (int i_282_ = i_271_; i_282_ < i_243_; i_282_++)
                    if (co[is_242_[i_282_]].colok != 30 && co[is_242_[i_282_]].colok != 32
                            && co[is_242_[i_282_]].colok != 54) {
                        final int i_283_ = pyn(co[i_279_].x, co[is_242_[i_282_]].x, co[i_279_].z,
                                co[is_242_[i_282_]].z);
                        if (i_283_ >= 0 && (i_283_ < i_280_ || i_280_ == -1)) {
                            i_280_ = i_283_;
                            i_281_ = i_282_;
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
        for (int i_285_ = 0; i_285_ < nob; i_285_++)
            if (co[i_285_].colok == 31) {
                int i_286_ = -1;
                int i_287_ = -1;
                for (int i_288_ = 0; i_288_ < i_243_; i_288_++) {
                    final int i_289_ = pyn(co[i_285_].x, co[is_242_[i_288_]].x, co[i_285_].z, co[is_242_[i_288_]].z);
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
        for (int i_291_ = 0; i_291_ < nob; i_291_++)
            if (co[i_291_].colok == 15 || co[i_291_].colok == 27 || co[i_291_].colok == 28 || co[i_291_].colok == 41
                    || co[i_291_].colok == 44 || co[i_291_].colok == 52 || co[i_291_].colok == 53) {
                int i_292_ = -1;
                for (int i_293_ = 0; i_293_ < i_243_; i_293_++)
                    if ((co[is_242_[i_293_]].colok <= 14 || co[is_242_[i_293_]].colok >= 33)
                            && co[is_242_[i_293_]].colok < 39) {
                        final int i_294_ = pyn(co[i_291_].x, co[is_242_[i_293_]].x, co[i_291_].z,
                                co[is_242_[i_293_]].z);
                        if (i_294_ >= 0 && i_294_ < (co[i_291_].maxR + co[is_242_[i_293_]].maxR) / 100
                                * ((co[i_291_].maxR + co[is_242_[i_293_]].maxR) / 100))
                            i_292_ = i_293_;
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
        for (int i_296_ = 0; i_296_ < nob; i_296_++)
            if (co[i_296_].colok >= 16 && co[i_296_].colok <= 25 || co[i_296_].colok == 40 || co[i_296_].colok == 42
                    || co[i_296_].colok == 43 || co[i_296_].colok == 45) {
                int i_297_ = -1;
                for (int i_298_ = 0; i_298_ < i_243_; i_298_++)
                    if ((co[is_242_[i_298_]].colok <= 14 || co[is_242_[i_298_]].colok >= 33)
                            && co[is_242_[i_298_]].colok < 39) {
                        final int i_299_ = pyn(co[i_296_].x, co[is_242_[i_298_]].x, co[i_296_].z,
                                co[is_242_[i_298_]].z);
                        if (i_299_ >= 0 && i_299_ < (co[i_296_].maxR + co[is_242_[i_298_]].maxR) / 100
                                * ((co[i_296_].maxR + co[is_242_[i_298_]].maxR) / 100)) {
                            if (is[is_242_[i_298_]] != 0) {
                                is[is_242_[i_298_]] = 0;
                                if (co[i_296_].colok != 20)
                                    is[i_296_] = 3;
                                else
                                    is[i_296_] = 5;
                            }
                            i_297_ = i_298_;
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
        for (int i_301_ = 0; i_301_ < nob; i_301_++)
            if (co[i_301_].colok == 26 || co[i_301_].colok == 39) {
                boolean bool_302_ = false;
                if (Math.random() > Math.random()) {
                    bool_302_ = true;
                    if (co[i_301_].colok == 39)
                        if (Math.random() > Math.random())
                            bool_302_ = false;
                        else if (Math.random() > Math.random())
                            bool_302_ = false;
                }
                int i_303_ = -1;
                for (int i_304_ = 0; i_304_ < i_243_; i_304_++)
                    if ((co[is_242_[i_304_]].colok <= 14 || co[is_242_[i_304_]].colok >= 33)
                            && co[is_242_[i_304_]].colok < 39) {
                        final int i_305_ = pyn(co[i_301_].x, co[is_242_[i_304_]].x, co[i_301_].z,
                                co[is_242_[i_304_]].z);
                        if (i_305_ >= 0 && i_305_ < (co[i_301_].maxR + co[is_242_[i_304_]].maxR) / 100
                                * ((co[i_301_].maxR + co[is_242_[i_304_]].maxR) / 100)) {
                            boolean bool_306_ = false;
                            if (co[i_301_].colok == 26) {
                                if (co[i_301_].roofat == 90 && co[is_242_[i_304_]].x > co[i_301_].x)
                                    bool_306_ = true;
                                if (co[i_301_].roofat == -90 && co[is_242_[i_304_]].x < co[i_301_].x)
                                    bool_306_ = true;
                                if (co[i_301_].roofat == 0 && co[is_242_[i_304_]].z < co[i_301_].z)
                                    bool_306_ = true;
                                if (co[i_301_].roofat == 180 && co[is_242_[i_304_]].z > co[i_301_].z)
                                    bool_306_ = true;
                            }
                            if (co[i_301_].colok == 39) {
                                if (co[i_301_].roofat == 90 && co[is_242_[i_304_]].z > co[i_301_].z)
                                    bool_306_ = true;
                                if (co[i_301_].roofat == -90 && co[is_242_[i_304_]].z < co[i_301_].z)
                                    bool_306_ = true;
                                if (co[i_301_].roofat == 0 && co[is_242_[i_304_]].x > co[i_301_].x)
                                    bool_306_ = true;
                                if (co[i_301_].roofat == 180 && co[is_242_[i_304_]].x < co[i_301_].x)
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
        for (int i_308_ = 0; i_308_ < nob; i_308_++)
            if (co[i_308_].colok >= 55 && co[i_308_].colok <= maxpart || co[i_308_].colok == bumppart) {
                is_242_[i_243_] = i_308_;
                i_243_++;
            }
        int i_309_ = 0;
        int i_310_ = 0;
        int i_311_ = 0;
        int i_312_ = 0;
        bstage = "";
        for (int i_313_ = 0; i_313_ < i_243_; i_313_++) {
            if (co[is_242_[i_313_]].colok != 30 && co[is_242_[i_313_]].colok != 31 && co[is_242_[i_313_]].colok != 32
                    && co[is_242_[i_313_]].colok != 54 && co[is_242_[i_313_]].colok != bumppart) {
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
                final StringBuilder stringbuilder = new StringBuilder();
                final StageMaker stagemaker_314_ = this;
                System.out.println("placing");
                System.out.println("roof2: " + co[is_242_[i_313_]].roofat);
                if (co[is_242_[i_313_]].roofat == 250) {

                }
                if (!floats)
                    stagemaker_314_.bstage = stringbuilder.append(stagemaker_314_.bstage).append("set(")
                            .append(co[is_242_[i_313_]].colok + 10).append(",").append(co[is_242_[i_313_]].x)
                            .append(",").append(co[is_242_[i_313_]].z).append(",").append(co[is_242_[i_313_]].roofat)
                            .append(")").append(string).append("\r\n").toString();
                else
                    stagemaker_314_.bstage = stringbuilder.append(stagemaker_314_.bstage).append("set(")
                            .append(co[is_242_[i_313_]].colok + 10).append(",").append(co[is_242_[i_313_]].x)
                            .append(",").append(co[is_242_[i_313_]].z).append(",").append(co[is_242_[i_313_]].y)
                            .append(",").append(co[is_242_[i_313_]].roofat).append(")").append(string).append("\r\n")
                            .toString();
            }
            if (co[is_242_[i_313_]].colok == 30 || co[is_242_[i_313_]].colok == 32) {
                if (co[is_242_[i_313_]].roofat == 180)
                    co[is_242_[i_313_]].roofat = 0;
                String string = "";
                if (co[is_242_[i_313_]].wh != 0)
                    string = "r";
                final StringBuilder stringbuilder = new StringBuilder();
                final StageMaker stagemaker_315_ = this;
                if (floats)
                    stagemaker_315_.bstage = stringbuilder.append(stagemaker_315_.bstage).append("chk(")
                            .append(co[is_242_[i_313_]].colok + 10).append(",").append(co[is_242_[i_313_]].x)
                            .append(",").append(co[is_242_[i_313_]].z).append(",").append(co[is_242_[i_313_]].y)
                            .append(",").append(co[is_242_[i_313_]].roofat).append(")").append(string).append("\r\n")
                            .toString();
                else
                    stagemaker_315_.bstage = stringbuilder.append(stagemaker_315_.bstage).append("chk(")
                            .append(co[is_242_[i_313_]].colok + 10).append(",").append(co[is_242_[i_313_]].x)
                            .append(",").append(co[is_242_[i_313_]].z).append(",").append(co[is_242_[i_313_]].roofat)
                            .append(")").append(string).append("\r\n").toString();
            }
            if (co[is_242_[i_313_]].colok == 54) {
                if (co[is_242_[i_313_]].roofat == 180)
                    co[is_242_[i_313_]].roofat = 0;
                String string = "";
                if (co[is_242_[i_313_]].wh != 0)
                    string = "r";
                final StringBuilder stringbuilder = new StringBuilder();
                final StageMaker stagemaker_316_ = this;
                //   stagemaker_316_.bstage = stringbuilder.append(stagemaker_316_.bstage).append("chk(")
                //		.append(co[is_242_[i_313_]].colok + 10).append(",").append(co[is_242_[i_313_]].x).append(",")
                //		.append(co[is_242_[i_313_]].z).append(",").append(co[is_242_[i_313_]].y).append(",").append(co[is_242_[i_313_]].roofat)
                //		.append(")").append(string).append("\r\n").toString();
                if (floats)
                    stagemaker_316_.bstage = stringbuilder.append(stagemaker_316_.bstage).append("chk(")
                            .append(co[is_242_[i_313_]].colok + 10).append(",").append(co[is_242_[i_313_]].x)
                            .append(",").append(co[is_242_[i_313_]].z).append(",").append(co[is_242_[i_313_]].y)
                            .append(",").append(co[is_242_[i_313_]].roofat).append(")").append(string).append("\r\n")
                            .toString();
                else
                    stagemaker_316_.bstage = stringbuilder.append(stagemaker_316_.bstage).append("chk(")
                            .append(co[is_242_[i_313_]].colok + 10).append(",").append(co[is_242_[i_313_]].x)
                            .append(",").append(co[is_242_[i_313_]].z).append(",").append(co[is_242_[i_313_]].roofat)
                            .append(")").append(string).append("\r\n").toString();
            }
            if (co[is_242_[i_313_]].colok == 31) {
                final StringBuilder stringbuilder = new StringBuilder();
                final StageMaker stagemaker_317_ = this;
                stagemaker_317_.bstage = stringbuilder.append(stagemaker_317_.bstage).append("fix(")
                        .append(co[is_242_[i_313_]].colok + 10).append(",").append(co[is_242_[i_313_]].x).append(",")
                        .append(co[is_242_[i_313_]].z).append(",").append(co[is_242_[i_313_]].y).append(",")
                        .append(co[is_242_[i_313_]].roofat).append(")\r\n").toString();
            }
            if (co[is_242_[i_313_]].colok == bumppart) {
                final StringBuilder stringbuilder = new StringBuilder();
                final StageMaker stagemaker_318_ = this;
                stagemaker_318_.bstage = stringbuilder.append(stagemaker_318_.bstage).append("pile(")
                        .append(co[is_242_[i_313_]].srz).append(",").append(co[is_242_[i_313_]].srx).append(",")
                        .append(co[is_242_[i_313_]].sry).append(",").append(co[is_242_[i_313_]].x).append(",")
                        .append(co[is_242_[i_313_]].z).append(")\r\n").toString();
            }
            if (co[is_242_[i_313_]].x + co[is_242_[i_313_]].maxR > i_309_)
                i_309_ = co[is_242_[i_313_]].x + co[is_242_[i_313_]].maxR;
            if (co[is_242_[i_313_]].x - co[is_242_[i_313_]].maxR < i_311_)
                i_311_ = co[is_242_[i_313_]].x - co[is_242_[i_313_]].maxR;
            if (co[is_242_[i_313_]].z + co[is_242_[i_313_]].maxR > i_310_)
                i_310_ = co[is_242_[i_313_]].z + co[is_242_[i_313_]].maxR;
            if (co[is_242_[i_313_]].z - co[is_242_[i_313_]].maxR < i_312_)
                i_312_ = co[is_242_[i_313_]].z - co[is_242_[i_313_]].maxR;
        }
        int i_319_ = i_311_ - 0;
        int i_320_ = i_309_ + 0;
        final int i_321_ = (int) ((i_320_ - i_319_) / 4800.0F) + 1;
        int i_322_ = (i_321_ * 4800 - (i_320_ - i_319_)) / 2;
        i_319_ -= i_322_;
        i_320_ += i_322_;
        final int i_323_ = i_319_ + 2400;
        int i_324_ = i_312_ - 0;
        int i_325_ = i_310_ + 0;
        final int i_326_ = (int) ((i_325_ - i_324_) / 4800.0F) + 1;
        i_322_ = (i_326_ * 4800 - (i_325_ - i_324_)) / 2;
        i_324_ -= i_322_;
        i_325_ += i_322_;
        final int i_327_ = i_324_ + 2400;
        final StringBuilder stringbuilder = new StringBuilder();
        final StageMaker stagemaker_328_ = this;
        stagemaker_328_.bstage = stringbuilder.append(stagemaker_328_.bstage).append("\r\nmaxl(").append(i_326_)
                .append(",").append(i_319_).append(",").append(i_327_).append(")\r\nmaxb(").append(i_321_).append(",")
                .append(i_324_).append(",").append(i_323_).append(")\r\nmaxr(").append(i_326_).append(",")
                .append(i_320_).append(",").append(i_327_).append(")\r\nmaxt(").append(i_321_).append(",")
                .append(i_325_).append(",").append(i_323_).append(")\r\n").toString();
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

    @Override
    public void update(final Graphics graphics) {
        paint(graphics);
    }
}
