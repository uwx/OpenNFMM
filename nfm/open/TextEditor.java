package nfm.open;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rtextarea.SearchContext;
import org.fife.ui.rtextarea.SearchEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * The Class TextEditor.
 */
/*
 * A simple Text Editor. This demonstrates the use of a JFileChooser for the user to select a file to read from or write to. It also demonstrates reading and writing text files.
 */
class TextEditor implements ActionListener {

    // Size of editing text area.
    private static final int NUM_ROWS = 25;
    private static final int NUM_AROWS = 25;
    private static final int NUM_COLS = 50;
    private static final int NUM_ACOLS = 20;
    private final static int fontsize = 24;
    // Buttons to save and load files.
    private final static JButton saveButton, loadButton;

    private static final JMenuItem newButton;

    // Area where the user does the editing
    private final static RSyntaxTextArea text;

    // bstage area
    private final static RSyntaxTextArea btext;

    private final static JTextField textField;

    private final static JLabel lblFontSize;

    private final static JButton prevButton, nextButton;
    // private final static JButton btnShowSelection;

    private final static JTextField searchField;

    private final static JCheckBox regexCB;

    private final static JCheckBox matchCaseCB;

    private final static JPanel panel_1;

    private final static JPanel buttonpanel;

    private final static JMenuBar menuBar;

    private final static JMenu mnFile;

    // private final static JMenuItem mntmLoad;
    private final static JMenu mnSettings;

    private final static JPanel panel_4;

    private final static JMenu mnTools;

    private static boolean fffff = false;
    private final static JButton refreshButton;
    // private final static JCheckBox chckbxSchizznti;
    private final static JPanel panel_2;

    private final static JPanel textpanel;

    private final static JButton kSet;

    /**
     * Instantiates a new text editor.
     *
     * @param sm the sm
     */
    // Creates the GUI
    static {

        final JFrame frame = new JFrame("Editor");
        try {
            //Set the required look and feel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //Update the component tree - associate the look and feel with the given frame.
            SwingUtilities.updateComponentTreeUI(frame);
        } //end try
        catch (final Exception ex) {
            ex.printStackTrace();
        } //end catch

        final Toolkit tk = Toolkit.getDefaultToolkit();
        final Dimension screenSize = tk.getScreenSize();
        final Insets scnMax = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());
        frame.setSize(screenSize.width / 2, screenSize.height - scnMax.bottom);
        // frame.setResizable(true);

        final JPanel atextpanel = new JPanel();
        frame.getContentPane().add(atextpanel, BorderLayout.CENTER);

        text = new RSyntaxTextArea(NUM_AROWS, NUM_ACOLS);
        text.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent e) {
                // countPolys();
            }
        });
        text.setFont(new Font("Courier New", Font.PLAIN, fontsize));
        final RTextScrollPane textScroller = new RTextScrollPane(text);
        atextpanel.add(textScroller, BorderLayout.CENTER);
        //final Container altContentPane = frame.getContentPane();
        buttonpanel = new JPanel();
        frame.getContentPane().add(buttonpanel, BorderLayout.NORTH);
        buttonpanel.setLayout(new BorderLayout(0, 0));

        // Create a toolbar with searching options.
        final JPanel toolBar = new JPanel();
        buttonpanel.add(toolBar, BorderLayout.SOUTH);
        toolBar.setLayout(new BorderLayout(0, 0));

        panel_1 = new JPanel();
        toolBar.add(panel_1, BorderLayout.NORTH);
        searchField = new JTextField(30);
        panel_1.add(searchField);
        nextButton = new JButton("Find Next");
        panel_1.add(nextButton);
        nextButton.setActionCommand("FindNext");
        prevButton = new JButton("Find Previous");
        panel_1.add(prevButton);
        prevButton.setActionCommand("FindPrev");
        regexCB = new JCheckBox("Regex");
        panel_1.add(regexCB);
        matchCaseCB = new JCheckBox("Match Case");
        panel_1.add(matchCaseCB);
        final TextEditor listenerHolder = new TextEditor();
        prevButton.addActionListener(listenerHolder);
        nextButton.addActionListener(listenerHolder);
        searchField.addActionListener(e -> nextButton.doClick(0));
        final JPanel buttonPanel = new JPanel();
        buttonpanel.add(buttonPanel);

        // create an Action doing what you want
        final AbstractAction saveAction = new AbstractAction("doSomething") {

            private static final long serialVersionUID = -1507795546151323861L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                if (false) {
                    System.out.println("triggered the action");
                }
                saveFile();
            }

        };
        // configure the Action with the accelerator (aka: short cut)
        saveAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));

        // create an Action doing what you want
        final AbstractAction reloadAction = new AbstractAction("doSomething") {

            private static final long serialVersionUID = -1507795546151323861L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                if (false) {
                    System.out.println("triggered the action");
                }
                refresh();
            }

        };
        // configure the Action with the accelerator (aka: short cut)
        reloadAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control R"));

        // create an Action doing what you want
        final AbstractAction newAction = new AbstractAction("doSomething") {

            private static final long serialVersionUID = -1507795546151323861L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                if (false) {
                    System.out.println("triggered the action");
                }
                if (!fffff) {
                    newFile();
                }
                fffff = !fffff;
            }

        };
        // configure the Action with the accelerator (aka: short cut)
        newAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control N"));

        saveButton = new JButton(saveAction);
        saveButton.setText("Save");

        saveButton.getActionMap().put("saveAction", saveAction);
        saveButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) saveAction.getValue(Action.ACCELERATOR_KEY), "saveAction");

        loadButton = new JButton(reloadAction);
        loadButton.setText("Refresh Stage Code (you may need to sort it first)");

        refreshButton = new JButton(new AbstractAction("doSomething") {

            private static final long serialVersionUID = -1507795546151323861L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                if (SRCStageMaker.nob != 0) {
                    SRCStageMaker.sortstage();
                } else {
                    JOptionPane.showMessageDialog(refreshButton, "Not enough data to sort! Please place at least one piece first.");
                }
            }

        });
        refreshButton.setText("Sort stage");

        loadButton.getActionMap().put("reloadAction", reloadAction);
        loadButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) reloadAction.getValue(Action.ACCELERATOR_KEY), "reloadAction");
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(refreshButton);

        menuBar = new JMenuBar();
        buttonpanel.add(menuBar, BorderLayout.NORTH);

        mnFile = new JMenu("File");
        menuBar.add(mnFile);

        newButton = new JMenuItem(newAction);
        mnFile.add(newButton);
        newButton.setText("New");

        mnSettings = new JMenu("Settings");
        menuBar.add(mnSettings);

        panel_4 = new JPanel();
        mnSettings.add(panel_4);

        lblFontSize = new JLabel("Font size");
        textField = new JTextField();
        textField.setToolTipText("Enter to apply");
        textField.setText("24");
        textField.addActionListener(e -> {
            try {
                final int fsize = Integer.parseInt(textField.getText());
                text.setFont(new Font("Courier New", Font.PLAIN, fsize));
            } catch (final Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid number " + textField.getText());
            }
        });
        textField.setColumns(3);
        panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel_4.add(lblFontSize);
        panel_4.add(textField);

        panel_2 = new JPanel();
        mnSettings.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

        kSet = new JButton("Kaff's Settings");
        kSet.addActionListener(arg0 -> SRCStageMaker.kSettings = !SRCStageMaker.kSettings);
        panel_2.add(kSet);

        mnTools = new JMenu("Tools");
        menuBar.add(mnTools);

        textpanel = new JPanel();
        frame.getContentPane().add(textpanel, BorderLayout.WEST);

        // bstage
        btext = new RSyntaxTextArea(NUM_ROWS, NUM_COLS);
        btext.setFont(new Font("Courier New", Font.PLAIN, fontsize));
        final RTextScrollPane altTextScroller = new RTextScrollPane(btext);
        textpanel.add(altTextScroller);

        newButton.getActionMap().put("newAction", newAction);
        newButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) newAction.getValue(Action.ACCELERATOR_KEY), "newAction");
        newButton.addActionListener(newAction);

        saveButton.addActionListener(saveAction);
        loadButton.addActionListener(reloadAction);

        /*
         * btnMirrorXAxis = new JButton("Mirror X Axis"); btnMirrorXAxis.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { //mirror(3); } }); buttonPanel.add(btnMirrorXAxis); btnMirrorYAxis = new JButton("Mirror Y Axis"); btnMirrorYAxis.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { //mirror(4); } }); buttonPanel.add(btnMirrorYAxis); btnMirrorZAxis = new JButton("Mirror Z Axis"); btnMirrorZAxis.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { //mirror(5); } }); buttonPanel.add(btnMirrorZAxis);
         */

        /*
         * btnShowSelection = new JButton("View Selection"); btnShowSelection.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { runapp.showSelectedPolygons(text.getText(), text.getSelectedText()); } }); buttonPanel.add(btnShowSelection);
         */

        /*
         * mntmLoad = new JMenuItem("Open"); mntmLoad.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { final FileDialog fd = new FileDialog(frame, "Choose a file", FileDialog.LOAD); fd.setDirectory(new File("./").getPath()); fd.setFile("*.rad"); fd.setVisible(true); //String filename = fd.getFile(); final File[] files = fd.getFiles(); if (files.length == 0) if (false) System.out.println("You cancelled the choice"); else try { if (false) System.out.println("You chose " + files[0]); F51.contofile = files[0]; loadFile(); countPolys();
         * f51.remake(text.getText()); } catch (final Exception er) { System.err.println("Error loading ContO: " + er); RunApp.postMsg("Error loading ContO: " + er + "\r\nIf you're sure this isn't your fault, tell rafa something went wrong and give him the full console log"); er.printStackTrace(); } } }); mnFile.add(mntmLoad);
         */

        /*
         * chckbxSchizznti = new JCheckBox("Hide error msgs"); chckbxSchizznti.addItemListener(new ItemListener() {
         * @Override public void itemStateChanged(final ItemEvent e) { if (e.getStateChange() == ItemEvent.DESELECTED) ; RunApp.suppressErrorMessages = false; if (e.getStateChange() == ItemEvent.SELECTED) ; RunApp.suppressErrorMessages = true; } }); panel_2.add(chckbxSchizznti);
         */

        /*
         * btnSolidifyRoofna = new JMenuItem("Solidify roof (N/A)"); mnTools.add(btnSolidifyRoofna); btnSolidifyRoad = new JMenuItem("Solidify road"); mnTools.add(btnSolidifyRoad); btnSolidifyRoadOld = new JMenuItem("Solidify road old"); mnTools.add(btnSolidifyRoadOld); btnSolidifyWall = new JMenuItem("Solidify wall"); mnTools.add(btnSolidifyWall); btnSolidifyWallOld = new JMenuItem("Solidify wall old"); mnTools.add(btnSolidifyWallOld); btnGet = new JMenuItem("get <tracks>");
         * mnTools.add(btnGet); btnGet.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { getTracks(); } }); btnSolidifyWallOld.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { solidifyWallOld(); } }); btnSolidifyWall.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { solidifyWall(); } }); btnSolidifyRoadOld.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { solidifyRoadOld(); } }); btnSolidifyRoad.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { solidifyRoad(); } }); btnSolidifyRoofna.addActionListener(new ActionListener() {
         * @Override public void actionPerformed(final ActionEvent e) { solidifyRoof(); } });
         */
        // rip
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Refresh.
     */
    private static void refresh() {
        text.setText(SRCStageMaker.tstage);
        btext.setText(SRCStageMaker.bstage);
    }

    // Listener for button clicks that loads the
    // specified files and puts it in the
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    // editor.
    @Override
    public void actionPerformed(final ActionEvent event) {
        if (event.getSource() == prevButton || event.getSource() == nextButton) {
            final String command = event.getActionCommand();
            final boolean forward = "FindNext".equals(command);
            // Create an object defining our search parameters.
            final SearchContext context = new SearchContext();
            final String text = searchField.getText();
            if (text.length() == 0)
                return;
            context.setSearchFor(text);
            context.setMatchCase(matchCaseCB.isSelected());
            context.setRegularExpression(regexCB.isSelected());
            context.setSearchForward(forward);
            context.setWholeWord(false);

            final boolean found = SearchEngine.find(btext, context).wasFound();
            if (!found) {
                JOptionPane.showMessageDialog(null, "Text not found");
            }
        }
    }

    /**
     * Gets the valueintext.
     *
     * @param s the s
     * @return the valueintext
     */
    public static int getvalueintext(final String s) {
        try {
            final BufferedReader reader = new BufferedReader(new StringReader(btext.getText()));
            String benis2 = reader.readLine();
            while (benis2 != null) {
                if (benis2.startsWith(s))
                    return getvalue(s, benis2, 0);
                benis2 = reader.readLine();
            }

        } catch (final IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("could not get value " + s + " in text");
    }

    /**
     * Gets the value.
     *
     * @param s  the s
     * @param s1 the s1
     * @param i  the i
     * @return the value
     */
    private static int getvalue(final String s, final String s1, final int i) {
        int k = 0;
        String s3 = "";
        for (int j = s.length() + 1; j < s1.length(); j++) {
            final String s2 = String.valueOf(s1.charAt(j));
            if (s2.equals(",") || s2.equals(")")) {
                k++;
                j++;
            }
            if (k == i) {
                s3 = s3 + s1.charAt(j);
            }
        }

        return Integer.valueOf(s3);
    }

    /**
     * New file.
     */
    private static void newFile() { // doesn't (and shouldn't) save
        /*
         * final int opt = JOptionPane.showConfirmDialog(null, "This will discard all unsaved changes!", "Create new file", JOptionPane.OK_CANCEL_OPTION); if (opt == JOptionPane.OK_OPTION) { final FileDialog fd = new FileDialog(RunApp.frame, "Choose a file", FileDialog.SAVE); fd.setDirectory(new File("./").getPath()); fd.setFile("*.rad"); fd.setVisible(true); //String filename = fd.getFile(); final File[] files = fd.getFiles(); if (files.length == 0) if (false) System.out.println("You cancelled the choice"
         * ); else { if (false) System.out.println("You chose " + files[0]); F51.contofile = files[0]; text.setText( "MaxRadius(300)\r\nshadow()\r\ndiv(24)\r\n\r\n\r\n\r\n\r\n\r\nw(-33,0,55,11,10,10,1)\r\nw(33,0,55,11,-10,10,1)\r\nw(-31,-1,-60,1,16,11,1)\r\nw(31,-1,-60,1,-16,11,1)"); try { f51.remake(text.getText()); } catch (final Exception e) { JOptionPane.showMessageDialog(RunApp.frame, "Something went horribly wrong.\r\nTell rafa the \"new\" dialog threw an exception and give him the full console log"
         * ); e.printStackTrace(); } countPolys(); saveFile(); } } //f51.remake(); //countPolys();
         */
    }

    // Display a file chooser so the user can select a file
    // to save to. Then write the contents of the text area
    // to that file. Does nothing if the user cancels out

    /**
     * Save file.
     */
    // of the file chooser.
    private static void saveFile() {
        SRCStageMaker.tstage = text.getText();
        SRCStageMaker.bstage = btext.getText();
        SRCStageMaker.readstage(0);
        /*
         * final File file = F51.contofile; try { // Now write to the file final PrintWriter output = new PrintWriter(new FileWriter(file)); output.println(text.getText()); output.close(); } catch (final IOException e) { JOptionPane.showMessageDialog(null, "Can't save file " + e.getMessage()); } try { f51.remake(text.getText()); } catch (final Exception er) { System.err.println("Error loading ContO: " + er); JOptionPane.showMessageDialog(RunApp.frame, "Error loading ContO: " + er +
         * "\r\nIf you're sure this isn't your fault, tell rafa something went wrong and give him the full console log"); er.printStackTrace(); }
         */
    }

}
