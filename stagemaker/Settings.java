package stagemaker;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings {

	// the objective is to access as many classes as possible
	GameSparker gamesparker;
	xtGraphics xtgraphics;
	CarDefine cardefine;
	ContO[] contos;
	CheckPoints checkpoints;
	Mad[] mads;
	Trackers trackers;
	Medium medium;
	public boolean powerHax;
    MenuBar menubar;
    Menu menuGadgets;
    Menu menuAbout;
	Frame frame;
	int[] backup = null;
	float[] backup2 = null;
	int[] backup3 = null;
	boolean notdead;
    Thread InvincThread;
	
	
	public Settings()
	{
		//isMph = true;
		notdead = true;
		powerHax = false;
	}
	
	public void initMenu(Frame frame) {
		frame = frame;
		menubar = new MenuBar();
        menuGadgets = new Menu("Hacks 1");
        menuAbout = new Menu("Hacked by Chris");
        MenuItem aboutOmar = new MenuItem("And hey JV, you can go eat a dick too");
        menuAbout.add(aboutOmar);
        
        initSpeedoMenu();
        
		menubar.add(menuGadgets);
		menubar.add(menuAbout);
		frame.setMenuBar(menubar);
	}
	
	public void initmads(Mad[] mads) {
		mads = mads;
	}
	
	public void initSpeedoMenu() {
		Menu menuSpeedo = new Menu("Power Hack");
        MenuItem menuItem = new MenuItem("Set insane");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	backup = cardefine.powerloss;
            	for (int i = 0; i < cardefine.powerloss.length; i++)
            		cardefine.powerloss[i] = Integer.MAX_VALUE;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Set normal");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	cardefine.powerloss = backup;
            	backup = null;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuGadgets.add(menuSpeedo);
        
        menuSpeedo = new Menu("Repair me");
        menuItem = new MenuItem("Repair");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	for (int i = 0; i < 7; i++)
            		mads[i].hitmag = 0;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Suicide");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	for (int i = 0; i < 7; i++)
            		mads[i].hitmag = 9999999; // a lot
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("True invincibility");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	notdead = true;
            	InvincThread = new Thread(new Runnable() { public void run() {
            	while(notdead)
            		for (int i = 0; i < 7; i++)
            			mads[i].hitmag = 0;
            	}});
            	InvincThread.start();
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Stop being invincible (may not work)");
        menuItem.addActionListener(new ActionListener() {
        	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
            {
        		notdead = false;
        		try {
        			InvincThread.stop();
        		} catch (Exception ex) {}
            }
        }
);
        menuSpeedo.add(menuItem);
        menuGadgets.add(menuSpeedo);
        menuSpeedo = new Menu("Damage Hack");
        menuItem = new MenuItem("Set insane");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	backup2 = cardefine.moment;
            	for (int i = 0; i < cardefine.moment.length; i++)
            		cardefine.moment[i] = (float)Integer.MAX_VALUE;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Set normal");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	cardefine.moment = backup2;
            	backup = null;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuGadgets.add(menuSpeedo);
        menuSpeedo = new Menu("Set all car classes");
        menuItem = new MenuItem("Class C");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	if (backup3 == null)
            		backup3 = cardefine.cclass;
            	for (int i = 0; i < cardefine.cclass.length; i++)
            		cardefine.cclass[i] = 0;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Class B & C");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	if (backup3 == null)
            		backup3 = cardefine.cclass;
            	for (int i = 0; i < cardefine.cclass.length; i++)
            		cardefine.cclass[i] = 1;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Class B");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	if (backup3 == null)
            		backup3 = cardefine.cclass;
            	for (int i = 0; i < cardefine.cclass.length; i++)
            		cardefine.cclass[i] = 2;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Class A & B");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	if (backup3 == null)
            		backup3 = cardefine.cclass;
            	for (int i = 0; i < cardefine.cclass.length; i++)
            		cardefine.cclass[i] = 3;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Class A");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	if (backup3 == null)
            		backup3 = cardefine.cclass;
            	for (int i = 0; i < cardefine.cclass.length; i++)
            		cardefine.cclass[i] = 4;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuItem = new MenuItem("Reset");
        menuItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
            	cardefine.cclass = backup3;
            	backup3 = null;
            }

        }
);
        menuSpeedo.add(menuItem);
        menuGadgets.add(menuSpeedo);
	}
	
	public void resetMenu()
	{
		frame.setMenuBar(menubar);
	}
	
	public void initclasses(GameSparker gamesparker, xtGraphics xtgraphics, CarDefine cardefine, ContO[] contos,
			CheckPoints checkpoints, Trackers trackers, Medium medium)
	{
		gamesparker = gamesparker;
		xtgraphics = xtgraphics;
		cardefine = cardefine;
		contos = contos;
		checkpoints = checkpoints;
		trackers = trackers;
		medium = medium;
	}
	
	public void updateSetting(String setting, boolean value)
	{
		switch(setting) {
		default:
			System.out.println("Malformed setting!");
		case "powerHax":
			for (int i = 0; i < cardefine.powerloss.length; i++)
				if (value) cardefine.powerloss[i] = Integer.MAX_VALUE;
				else cardefine.powerloss[i] = Integer.MAX_VALUE;
		}
	}
	
	public void updateSetting(String setting, int value)
	{
		switch(setting) {
		default:
			System.out.println("Malformed setting!");
		}
	}
	
}
