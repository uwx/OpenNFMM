import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class ServerThing {
    
    public static void main(String[] args) {
        try {
            findStages();
        } catch (IOException e) {
        }
        
        JFrame f = new JFrame("LAN Server");
        f.getContentPane().setLayout(null);

        f.setPreferredSize(new Dimension(800, 450));
        f.setSize(new Dimension(817, 492));
        
        JPanel p = makePanels(0, 0);
        f.getContentPane().add(p);
        f.setVisible(true);
    }

    static JPanel makePanels(int x, int y) {
        panel = new JPanel();
        panel.setBounds(x, y, 800, 450);
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 11, 118, 30);
        panel.add(panel_1);
        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblMaxPlayers = new JLabel("Max players");
        panel_1.add(lblMaxPlayers);
        
        selectedPlayers = new JComboBox<Integer>(new DefaultComboBoxModel<Integer>(new Integer[] {2, 3, 4, 5, 6, 7, 8}));
        panel_1.add(selectedPlayers);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 52, 406, 30);
        panel.add(panel_2);
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblStage = new JLabel("Stage");
        panel_2.add(lblStage);
        
        selectedStage = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"The Introductory Stage", "Contrary To Popular Belief", "Do The Snake Dance", "Grapefruit Power", "He Is Coming For You Next", "Paninaro, Caninaro, Let's fly!", "When In Danger Just Chill Out", "The Fast & The Furious + The Radical", "The Beach Arcade Dream", "Confusion In An Illusion", "Introductory Stage", "Let the Dream Begin", "Arrested by the Man", "Twisted Revenge", "Centrifugal Rush, Under Water?", "The Stretch", "The Garden of the King", "Maximum Overfly", "Majestic Duty", "Ghosts and Magic", "Rolling with the Big Boys", "Suddenly the King becomes Santa's Little Helper", "Digger's Revenge", "The Gun Run", "Dances with Monsters", "Four Dimensional Vertigo", "The Mad Party", "Rocket Arena", "The Evil Clown", "Quake Ownage", "Space Walk", "Fair Ground"}));
        panel_2.add(selectedStage);
        selectedStage.setSelectedIndex(ThreadLocalRandom.current().nextInt(32));
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 93, 118, 30);
        panel.add(panel_3);
        panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblLaps = new JLabel("Laps");
        panel_3.add(lblLaps);
        
        selectedLaps = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
        panel_3.add(selectedLaps);
        selectedLaps.setSelectedIndex(4);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(10, 134, 118, 30);
        panel.add(panel_4);
        panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblMaxFixes = new JLabel("Max. Fixes");
        panel_4.add(lblMaxFixes);
        
        selectedFixes = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
        panel_4.add(selectedFixes);
        selectedFixes.setSelectedIndex(4);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBounds(10, 175, 118, 30);
        panel.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        checkbox = new JCheckBox("Trees and bumps");
        panel_5.add(checkbox);
        checkbox.setSelected(true);
        
        btnStartServer = new JButton("Start Server");
        btnStartServer.setBounds(10, 398, 118, 23);
        panel.add(btnStartServer);
        
        serverStatus = new JLabel("Status: Server closed");
        serverStatus.setBounds(10, 425, 780, 14);
        panel.add(serverStatus);
        
        serverInfo = new JLabel("Info N/A");
        serverInfo.setVerticalAlignment(SwingConstants.TOP);
        serverInfo.setBounds(633, 11, 157, 153);
        panel.add(serverInfo);
        
        return panel;
    }
    
    static final ArrayList<String> stageList = new ArrayList<String>();
    static JPanel panel;
    static JComboBox<Integer> selectedPlayers;
    static JComboBox<String> selectedStage;
    static JComboBox<String> selectedLaps;
    static JComboBox<String> selectedFixes;
    static JLabel serverStatus;
    static JCheckBox checkbox;
    static JButton btnStartServer;
    static JLabel serverInfo;
    
    private static void findStages() throws IOException {
        for (int i = 1; i <= 32; i++) {
            BufferedReader stageDataReader;
            String customStagePath = "stages/" + i;
            final File customStageFile = new File("" + Madness.fpath + "" + customStagePath + ".txt");
            stageDataReader = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(customStageFile))));
            String line, string;
            while ((line = stageDataReader.readLine()) != null) {
                string = "" + line.trim();
                if (string.startsWith("name")) {
                    stageList.add(GameSparker.getstring("name", string, 0));
                }
            }
            stageDataReader.close();
        }
        System.out.println(Arrays.toString(stageList.toArray(new String[0])));
    }
}
