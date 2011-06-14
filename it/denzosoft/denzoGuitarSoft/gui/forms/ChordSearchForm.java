package it.denzosoft.denzoGuitarSoft.gui.forms;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

class ChordSearchForm extends JFrame {

    private Toolkit tk = Toolkit.getDefaultToolkit();
    Container contentPane=null;
    ButtonGroup ChordSearchButtonGroup = new ButtonGroup();

        protected JMenuBar menuBar = new JMenuBar();

        protected JPanel Picture1= null;
        protected JPanel Frame2= null;
        protected ButtonGroup Frame2ButtonGroup = new ButtonGroup();
        protected JList List1= null;
        protected DefaultListModel List1Model= new DefaultListModel();
        protected JPanel Frame1= null;
        protected ButtonGroup Frame1ButtonGroup = new ButtonGroup();
        protected JButton Command1= null;
        protected JComboBox Combo2= null;
        protected JComboBox Combo1= null;
        protected JCheckBox Check2= null;
        protected JCheckBox Check1= null;
        protected JTextField Text2= null;
        protected JTextField Text1= null;
        protected JLabel Label4= null;
        protected JLabel Label3= null;
        protected JLabel Label2= null;
        protected JLabel Label1= null;


    public ChordSearchForm() {
        try {
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLokkAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch(Exception ex) {}

        setTitle("ChordSearch");
        setSize(642, 294);
        //setLocation(22, 22);

        addWindowListener (new WindowListener() {
            public void windowClosing(WindowEvent e){
                ChordSearchFrame_WINDOWCLOSING(e);
                System.exit(0);
            }
            public void windowOpened(WindowEvent e){
                ChordSearchFrame_WINDOWOPENED(e);
            }
            public void windowOpening(WindowEvent e){
                ChordSearchFrame_WINDOWOPENING(e);
            }
            public void windowIconified(WindowEvent e){
                ChordSearchFrame_WINDOWICONIFIED(e);
            }
            public void windowDeiconified(WindowEvent e){
                ChordSearchFrame_WINDOWDEICONIFIED(e);
            }
            public void windowClosed(WindowEvent e){
                ChordSearchFrame_WINDOWCLOSED(e);
            }
            public void windowActivated(WindowEvent e){
                ChordSearchFrame_WINDOWACTIVATED(e);
            }
            public void windowDeactivated(WindowEvent e){
                ChordSearchFrame_WINDOWDEACTIVATED(e);
            }
        });


/*
        addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                ChordSearchFrame_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                ChordSearchFrame_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                ChordSearchFrame_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                ChordSearchFrame_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                ChordSearchFrame_MOUSECLICKED(e);
            }
        });


        addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                ChordSearchFrame_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                ChordSearchFrame_MOUSEDRAGGED(e);
            }
        });


        addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                ChordSearchFrame_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                ChordSearchFrame_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                ChordSearchFrame_KEYTYPED(e);
            }
        });


        addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                ChordSearchFrame_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                ChordSearchFrame_FOCUSLOST(e);
            }
        });


*/

        contentPane=getContentPane();
        contentPane.setLayout(null);


        setJMenuBar(menuBar);

        Picture1= new JPanel() {
            public void paintComponent(Graphics g) {
                Picture1_PAINT(g);
            }
        };
        Picture1.setSize(249,241);
        Picture1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),""));
/*
        Picture1.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Picture1_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Picture1_FOCUSLOST(e);
            }
        });


        Picture1.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Picture1_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Picture1_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Picture1_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Picture1_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Picture1_MOUSECLICKED(e);
            }
        });


        Picture1.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Picture1_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Picture1_MOUSEDRAGGED(e);
            }
        });


        Picture1.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Picture1_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Picture1_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Picture1_KEYTYPED(e);
            }
        });


*/
        Picture1.setLocation(376,16);
        contentPane.add(Picture1);
        Frame2= new JPanel();
        Frame2.setLayout(null);
        Frame2.setSize(225,249);
        Frame2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"SearchResults"));
/*
        addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Frame2_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Frame2_FOCUSLOST(e);
            }
        });


        addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Frame2_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Frame2_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Frame2_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Frame2_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Frame2_MOUSECLICKED(e);
            }
        });


        addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Frame2_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Frame2_MOUSEDRAGGED(e);
            }
        });


        addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Frame2_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Frame2_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Frame2_KEYTYPED(e);
            }
        });


*/
        Frame2.setLocation(144,8);
        contentPane.add(Frame2);
        List1= new JList(List1Model);
        //List1= new JList(String[] StringList);
        List1.setSize(209,225);
        List1.setLocation(0,0);
        JScrollPane SP_List1 = new JScrollPane(List1);
        SP_List1.setSize(209,225);
/*
        List1.addListSelectionListener (new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                List1_VALUECHANGED(e);
            }
        });


        List1.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                List1_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                List1_FOCUSLOST(e);
            }
        });


        List1.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                List1_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                List1_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                List1_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                List1_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                List1_MOUSECLICKED(e);
            }
        });


        List1.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                List1_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                List1_MOUSEDRAGGED(e);
            }
        });


        List1.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                List1_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                List1_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                List1_KEYTYPED(e);
            }
        });


*/
        SP_List1.setLocation(8,16);
        Frame2.add(SP_List1);
        Frame1= new JPanel();
        Frame1.setLayout(null);
        Frame1.setSize(129,249);
        Frame1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"ChordParameters"));
/*
        addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Frame1_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Frame1_FOCUSLOST(e);
            }
        });


        addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Frame1_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Frame1_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Frame1_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Frame1_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Frame1_MOUSECLICKED(e);
            }
        });


        addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Frame1_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Frame1_MOUSEDRAGGED(e);
            }
        });


        addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Frame1_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Frame1_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Frame1_KEYTYPED(e);
            }
        });


*/
        Frame1.setLocation(8,8);
        contentPane.add(Frame1);

        Command1= new JButton("Search");
        Command1.setSize(113,25);

        Command1.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Command1_ACTIONPERFORMED(e);
            }
        });


/*
        Command1.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Command1_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Command1_FOCUSLOST(e);
            }
        });


        Command1.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Command1_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Command1_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Command1_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Command1_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Command1_MOUSECLICKED(e);
            }
        });


        Command1.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Command1_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Command1_MOUSEDRAGGED(e);
            }
        });


        Command1.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Command1_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Command1_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Command1_KEYTYPED(e);
            }
        });


*/
        Command1.setLocation(8,216);
        Frame1.add(Command1);

        Combo2= new JComboBox();
        Combo2.setSize(113,21);
        Combo2.setEditable(true);               // to be a real combined box
/*
        Combo2.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Combo2_ACTIONPERFORMED(e);
            }
        });


        Combo2.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Combo2_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Combo2_FOCUSLOST(e);
            }
        });


        Combo2.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Combo2_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Combo2_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Combo2_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Combo2_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Combo2_MOUSECLICKED(e);
            }
        });


        Combo2.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Combo2_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Combo2_MOUSEDRAGGED(e);
            }
        });


        Combo2.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Combo2_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Combo2_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Combo2_KEYTYPED(e);
            }
        });


*/
        Combo2.setLocation(8,72);
        Frame1.add(Combo2);
        Combo1= new JComboBox();
        Combo1.setSize(113,21);
        Combo1.setEditable(true);               // to be a real combined box
/*
        Combo1.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Combo1_ACTIONPERFORMED(e);
            }
        });


        Combo1.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Combo1_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Combo1_FOCUSLOST(e);
            }
        });


        Combo1.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Combo1_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Combo1_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Combo1_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Combo1_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Combo1_MOUSECLICKED(e);
            }
        });


        Combo1.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Combo1_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Combo1_MOUSEDRAGGED(e);
            }
        });


        Combo1.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Combo1_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Combo1_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Combo1_KEYTYPED(e);
            }
        });


*/
        Combo1.setLocation(8,32);
        Frame1.add(Combo1);
        Check2= new JCheckBox("Inversions");
        Check2.setSize(105,17);
/*
        Check2.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Check2_ACTIONPERFORMED(e);
            }
        });


        Check2.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Check2_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Check2_FOCUSLOST(e);
            }
        });


        Check2.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Check2_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Check2_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Check2_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Check2_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Check2_MOUSECLICKED(e);
            }
        });


        Check2.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Check2_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Check2_MOUSEDRAGGED(e);
            }
        });


        Check2.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Check2_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Check2_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Check2_KEYTYPED(e);
            }
        });


*/
        Check2.setLocation(8,184);
        Frame1.add(Check2);
        Check1= new JCheckBox("AllowOpenStrings");
        Check1.setSize(105,17);
/*
        Check1.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Check1_ACTIONPERFORMED(e);
            }
        });


        Check1.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Check1_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Check1_FOCUSLOST(e);
            }
        });


        Check1.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Check1_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Check1_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Check1_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Check1_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Check1_MOUSECLICKED(e);
            }
        });


        Check1.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Check1_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Check1_MOUSEDRAGGED(e);
            }
        });


        Check1.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Check1_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Check1_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Check1_KEYTYPED(e);
            }
        });


*/
        Check1.setLocation(8,160);
        Frame1.add(Check1);
        Text2= new JTextField("Text1", 18);
        Text2.setSize(25,19);

/*
        Text2.getDocument().addDocumentListener (new DocumentListener() {
            public void changedUpdate(DocumentEvent e){
                Text2_CHANGEDUPDATE(e);
            }
            public void insertUpdate(DocumentEvent e){
                Text2_INSERTUPDATE(e);
            }
            public void removeUpdate(DocumentEvent e){
                Text2_REMOVEUPDATE(e);
            }
        });


*/
        contentPane.add(Text2);
        Text2.setLocation(88,136);
        Frame1.add(Text2);
/*
        Text2.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Text2_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Text2_FOCUSLOST(e);
            }
        });


        Text2.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Text2_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Text2_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Text2_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Text2_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Text2_MOUSECLICKED(e);
            }
        });


        Text2.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Text2_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Text2_MOUSEDRAGGED(e);
            }
        });


        Text2.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Text2_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Text2_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Text2_KEYTYPED(e);
            }
        });


*/
        Text1= new JTextField("Text1", 18);
        Text1.setSize(25,19);

/*
        Text1.getDocument().addDocumentListener (new DocumentListener() {
            public void changedUpdate(DocumentEvent e){
                Text1_CHANGEDUPDATE(e);
            }
            public void insertUpdate(DocumentEvent e){
                Text1_INSERTUPDATE(e);
            }
            public void removeUpdate(DocumentEvent e){
                Text1_REMOVEUPDATE(e);
            }
        });


*/
        contentPane.add(Text1);
        Text1.setLocation(88,112);
        Frame1.add(Text1);
/*
        Text1.addFocusListener (new FocusListener() {
            public void focusGained(FocusEvent e){
                Text1_FOCUSGAINED(e);
            }
            public void focusLost(FocusEvent e){
                Text1_FOCUSLOST(e);
            }
        });


        Text1.addMouseListener (new MouseListener() {
            public void mousePressed(MouseEvent e){
                Text1_MOUSEPRESSED(e);
            }
            public void mouseReleased(MouseEvent e){
                Text1_MOUSERELEASED(e);
            }
            public void mouseEntered(MouseEvent e){
                Text1_MOUSEENTERED(e);
            }
            public void mouseExited(MouseEvent e){
                Text1_MOUSEEXITED(e);
            }
            public void mouseClicked(MouseEvent e){
                Text1_MOUSECLICKED(e);
            }
        });


        Text1.addMouseMotionListener (new MouseMotionListener() {
            public void mouseMoved(MouseEvent e){
                Text1_MOUSEMOVED(e);
            }
            public void mouseDragged(MouseEvent e){
                Text1_MOUSEDRAGGED(e);
            }
        });


        Text1.addKeyListener (new KeyListener() {
            public void keyPressed(KeyEvent e){
                Text1_KEYPRESSED(e);
            }
            public void keyReleased(KeyEvent e){
                Text1_KEYRELEASED(e);
            }
            public void keyTyped(KeyEvent e){
                Text1_KEYTYPED(e);
            }
        });


*/
        Label4= new JLabel("Type",SwingConstants.LEFT);
        Label4.setSize(113,17);
        Label4.setLocation(8,56);
        Frame1.add(Label4);
        Label3= new JLabel("Root",SwingConstants.LEFT);
        Label3.setSize(113,17);
        Label3.setLocation(8,16);
        Frame1.add(Label3);
        Label2= new JLabel("MaxFret",SwingConstants.LEFT);
        Label2.setSize(73,17);
        Label2.setLocation(8,136);
        Frame1.add(Label2);
        Label1= new JLabel("MinFret",SwingConstants.LEFT);
        Label1.setSize(73,17);
        Label1.setLocation(8,112);
        Frame1.add(Label1);
        Frame_Load();
    }


    public void Frame_Load() {
    }
    protected void ChordSearchFrame_WINDOWCLOSING(WindowEvent e){
        this.setTitle("ChordSearchFrame_WINDOWCLOSING");
    }
    protected void ChordSearchFrame_WINDOWOPENED(WindowEvent e){
        this.setTitle("ChordSearchFrame_WINDOWOPENED");
    }
    protected void ChordSearchFrame_WINDOWOPENING(WindowEvent e){
        this.setTitle("ChordSearchFrame_WINDOWOPENING");
    }
    protected void ChordSearchFrame_WINDOWICONIFIED(WindowEvent e){
        this.setTitle("ChordSearchFrame_WINDOWICONIFIED");
    }
    protected void ChordSearchFrame_WINDOWDEICONIFIED(WindowEvent e){
        this.setTitle("ChordSearchFrame_WINDOWDEICONIFIED");
    }
    protected void ChordSearchFrame_WINDOWCLOSED(WindowEvent e){
        this.setTitle("ChordSearchFrame_WINDOWCLOSED");
    }
    protected void ChordSearchFrame_WINDOWACTIVATED(WindowEvent e){
        this.setTitle("ChordSearchFrame_WINDOWACTIVATED");
    }
    protected void ChordSearchFrame_WINDOWDEACTIVATED(WindowEvent e){
        this.setTitle("ChordSearchFrame_WINDOWDEACTIVATED");
    }


    protected void ChordSearchFrame_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("ChordSearchFrame_MOUSEPRESSED");
    }
    protected void ChordSearchFrame_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("ChordSearchFrame_MOUSERELEASED");
    }
    protected void ChordSearchFrame_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("ChordSearchFrame_MOUSEENTERED");
    }
    protected void ChordSearchFrame_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("ChordSearchFrame_MOUSEEXITED");
    }
    protected void ChordSearchFrame_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("ChordSearchFrame_MOUSECLICKED");
    }


    protected void ChordSearchFrame_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("ChordSearchFrame_MOUSEMOVED");
    }
    protected void ChordSearchFrame_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("ChordSearchFrame_MOUSEDRAGGED");
    }


    protected void ChordSearchFrame_KEYPRESSED(KeyEvent e){
        this.setTitle("ChordSearchFrame_KEYPRESSED");
    }
    protected void ChordSearchFrame_KEYRELEASED(KeyEvent e){
        this.setTitle("ChordSearchFrame_KEYRELEASED");
    }
    protected void ChordSearchFrame_KEYTYPED(KeyEvent e){
        this.setTitle("ChordSearchFrame_KEYTYPED");
    }


    protected void ChordSearchFrame_FOCUSGAINED(FocusEvent e){
        this.setTitle("ChordSearchFrame_FOCUSGAINED");
    }
    protected void ChordSearchFrame_FOCUSLOST(FocusEvent e){
        this.setTitle("ChordSearchFrame_FOCUSLOST");
    }




    public void Picture1_PAINT(Graphics g) {
        this.setTitle("Painting");
    }

    protected void Picture1_ACTIONPERFORMED(ActionEvent e){
        this.setTitle("Picture1_ACTIONPERFORMED");
    }


    protected void Picture1_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Picture1_MOUSEPRESSED");
    }
    protected void Picture1_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Picture1_MOUSERELEASED");
    }
    protected void Picture1_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Picture1_MOUSEENTERED");
    }
    protected void Picture1_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Picture1_MOUSEEXITED");
    }
    protected void Picture1_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Picture1_MOUSECLICKED");
    }


    protected void Picture1_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Picture1_MOUSEMOVED");
    }
    protected void Picture1_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Picture1_MOUSEDRAGGED");
    }


    protected void Picture1_KEYPRESSED(KeyEvent e){
        this.setTitle("Picture1_KEYPRESSED");
    }
    protected void Picture1_KEYRELEASED(KeyEvent e){
        this.setTitle("Picture1_KEYRELEASED");
    }
    protected void Picture1_KEYTYPED(KeyEvent e){
        this.setTitle("Picture1_KEYTYPED");
    }


    protected void Picture1_FOCUSGAINED(FocusEvent e){
        this.setTitle("Picture1_FOCUSGAINED");
    }
    protected void Picture1_FOCUSLOST(FocusEvent e){
        this.setTitle("Picture1_FOCUSLOST");
    }


    protected void Frame2_FOCUSGAINED(FocusEvent e){
        this.setTitle("Frame2_FOCUSGAINED");
    }
    protected void Frame2_FOCUSLOST(FocusEvent e){
        this.setTitle("Frame2_FOCUSLOST");
    }


    protected void Frame2_KEYPRESSED(KeyEvent e){
        this.setTitle("Frame2_KEYPRESSED");
    }
    protected void Frame2_KEYRELEASED(KeyEvent e){
        this.setTitle("Frame2_KEYRELEASED");
    }
    protected void Frame2_KEYTYPED(KeyEvent e){
        this.setTitle("Frame2_KEYTYPED");
    }


    protected void Frame2_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame2_MOUSEPRESSED");
    }
    protected void Frame2_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame2_MOUSERELEASED");
    }
    protected void Frame2_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame2_MOUSEENTERED");
    }
    protected void Frame2_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame2_MOUSEEXITED");
    }
    protected void Frame2_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame2_MOUSECLICKED");
    }


    protected void Frame2_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame2_MOUSEMOVED");
    }
    protected void Frame2_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame2_MOUSEDRAGGED");
    }


    protected void List1_VALUECHANGED(ListSelectionEvent e){
        this.setTitle("List1_VALUECHANGED");
    }


    protected void List1_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("List1_MOUSEPRESSED");
    }
    protected void List1_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("List1_MOUSERELEASED");
    }
    protected void List1_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("List1_MOUSEENTERED");
    }
    protected void List1_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("List1_MOUSEEXITED");
    }
    protected void List1_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("List1_MOUSECLICKED");
    }


    protected void List1_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("List1_MOUSEMOVED");
    }
    protected void List1_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("List1_MOUSEDRAGGED");
    }


    protected void List1_KEYPRESSED(KeyEvent e){
        this.setTitle("List1_KEYPRESSED");
    }
    protected void List1_KEYRELEASED(KeyEvent e){
        this.setTitle("List1_KEYRELEASED");
    }
    protected void List1_KEYTYPED(KeyEvent e){
        this.setTitle("List1_KEYTYPED");
    }


    protected void List1_FOCUSGAINED(FocusEvent e){
        this.setTitle("List1_FOCUSGAINED");
    }
    protected void List1_FOCUSLOST(FocusEvent e){
        this.setTitle("List1_FOCUSLOST");
    }


    protected void Frame1_FOCUSGAINED(FocusEvent e){
        this.setTitle("Frame1_FOCUSGAINED");
    }
    protected void Frame1_FOCUSLOST(FocusEvent e){
        this.setTitle("Frame1_FOCUSLOST");
    }


    protected void Frame1_KEYPRESSED(KeyEvent e){
        this.setTitle("Frame1_KEYPRESSED");
    }
    protected void Frame1_KEYRELEASED(KeyEvent e){
        this.setTitle("Frame1_KEYRELEASED");
    }
    protected void Frame1_KEYTYPED(KeyEvent e){
        this.setTitle("Frame1_KEYTYPED");
    }


    protected void Frame1_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame1_MOUSEPRESSED");
    }
    protected void Frame1_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame1_MOUSERELEASED");
    }
    protected void Frame1_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame1_MOUSEENTERED");
    }
    protected void Frame1_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame1_MOUSEEXITED");
    }
    protected void Frame1_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame1_MOUSECLICKED");
    }


    protected void Frame1_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame1_MOUSEMOVED");
    }
    protected void Frame1_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Frame1_MOUSEDRAGGED");
    }


    protected void Command1_ACTIONPERFORMED(ActionEvent e){
        this.setTitle("Command1_ACTIONPERFORMED");
    }


    protected void Command1_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Command1_MOUSEPRESSED");
    }
    protected void Command1_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Command1_MOUSERELEASED");
    }
    protected void Command1_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Command1_MOUSEENTERED");
    }
    protected void Command1_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Command1_MOUSEEXITED");
    }
    protected void Command1_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Command1_MOUSECLICKED");
    }


    protected void Command1_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Command1_MOUSEMOVED");
    }
    protected void Command1_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Command1_MOUSEDRAGGED");
    }


    protected void Command1_KEYPRESSED(KeyEvent e){
        this.setTitle("Command1_KEYPRESSED");
    }
    protected void Command1_KEYRELEASED(KeyEvent e){
        this.setTitle("Command1_KEYRELEASED");
    }
    protected void Command1_KEYTYPED(KeyEvent e){
        this.setTitle("Command1_KEYTYPED");
    }


    protected void Command1_FOCUSGAINED(FocusEvent e){
        this.setTitle("Command1_FOCUSGAINED");
    }
    protected void Command1_FOCUSLOST(FocusEvent e){
        this.setTitle("Command1_FOCUSLOST");
    }


    protected void Combo2_ACTIONPERFORMED(ActionEvent e){
        this.setTitle("Combo2_ACTIONPERFORMED");
    }


    protected void Combo2_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo2_MOUSEPRESSED");
    }
    protected void Combo2_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo2_MOUSERELEASED");
    }
    protected void Combo2_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo2_MOUSEENTERED");
    }
    protected void Combo2_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo2_MOUSEEXITED");
    }
    protected void Combo2_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo2_MOUSECLICKED");
    }


    protected void Combo2_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo2_MOUSEMOVED");
    }
    protected void Combo2_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo2_MOUSEDRAGGED");
    }


    protected void Combo2_KEYPRESSED(KeyEvent e){
        this.setTitle("Combo2_KEYPRESSED");
    }
    protected void Combo2_KEYRELEASED(KeyEvent e){
        this.setTitle("Combo2_KEYRELEASED");
    }
    protected void Combo2_KEYTYPED(KeyEvent e){
        this.setTitle("Combo2_KEYTYPED");
    }


    protected void Combo2_FOCUSGAINED(FocusEvent e){
        this.setTitle("Combo2_FOCUSGAINED");
    }
    protected void Combo2_FOCUSLOST(FocusEvent e){
        this.setTitle("Combo2_FOCUSLOST");
    }


    protected void Combo1_ACTIONPERFORMED(ActionEvent e){
        this.setTitle("Combo1_ACTIONPERFORMED");
    }


    protected void Combo1_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo1_MOUSEPRESSED");
    }
    protected void Combo1_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo1_MOUSERELEASED");
    }
    protected void Combo1_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo1_MOUSEENTERED");
    }
    protected void Combo1_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo1_MOUSEEXITED");
    }
    protected void Combo1_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo1_MOUSECLICKED");
    }


    protected void Combo1_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo1_MOUSEMOVED");
    }
    protected void Combo1_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Combo1_MOUSEDRAGGED");
    }


    protected void Combo1_KEYPRESSED(KeyEvent e){
        this.setTitle("Combo1_KEYPRESSED");
    }
    protected void Combo1_KEYRELEASED(KeyEvent e){
        this.setTitle("Combo1_KEYRELEASED");
    }
    protected void Combo1_KEYTYPED(KeyEvent e){
        this.setTitle("Combo1_KEYTYPED");
    }


    protected void Combo1_FOCUSGAINED(FocusEvent e){
        this.setTitle("Combo1_FOCUSGAINED");
    }
    protected void Combo1_FOCUSLOST(FocusEvent e){
        this.setTitle("Combo1_FOCUSLOST");
    }


    protected void Check2_ACTIONPERFORMED(ActionEvent e){
        this.setTitle("Check2_ACTIONPERFORMED");
    }


    protected void Check2_FOCUSGAINED(FocusEvent e){
        this.setTitle("Check2_FOCUSGAINED");
    }
    protected void Check2_FOCUSLOST(FocusEvent e){
        this.setTitle("Check2_FOCUSLOST");
    }


    protected void Check2_KEYPRESSED(KeyEvent e){
        this.setTitle("Check2_KEYPRESSED");
    }
    protected void Check2_KEYRELEASED(KeyEvent e){
        this.setTitle("Check2_KEYRELEASED");
    }
    protected void Check2_KEYTYPED(KeyEvent e){
        this.setTitle("Check2_KEYTYPED");
    }


    protected void Check2_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check2_MOUSEPRESSED");
    }
    protected void Check2_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check2_MOUSERELEASED");
    }
    protected void Check2_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check2_MOUSEENTERED");
    }
    protected void Check2_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check2_MOUSEEXITED");
    }
    protected void Check2_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check2_MOUSECLICKED");
    }


    protected void Check2_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check2_MOUSEMOVED");
    }
    protected void Check2_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check2_MOUSEDRAGGED");
    }


    protected void Check1_ACTIONPERFORMED(ActionEvent e){
        this.setTitle("Check1_ACTIONPERFORMED");
    }


    protected void Check1_FOCUSGAINED(FocusEvent e){
        this.setTitle("Check1_FOCUSGAINED");
    }
    protected void Check1_FOCUSLOST(FocusEvent e){
        this.setTitle("Check1_FOCUSLOST");
    }


    protected void Check1_KEYPRESSED(KeyEvent e){
        this.setTitle("Check1_KEYPRESSED");
    }
    protected void Check1_KEYRELEASED(KeyEvent e){
        this.setTitle("Check1_KEYRELEASED");
    }
    protected void Check1_KEYTYPED(KeyEvent e){
        this.setTitle("Check1_KEYTYPED");
    }


    protected void Check1_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check1_MOUSEPRESSED");
    }
    protected void Check1_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check1_MOUSERELEASED");
    }
    protected void Check1_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check1_MOUSEENTERED");
    }
    protected void Check1_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check1_MOUSEEXITED");
    }
    protected void Check1_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check1_MOUSECLICKED");
    }


    protected void Check1_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check1_MOUSEMOVED");
    }
    protected void Check1_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Check1_MOUSEDRAGGED");
    }


    protected void Text2_CHANGEDUPDATE(DocumentEvent e){
        /*String text = null;
        try {
            text = e.getDocument().getText(0,e.getDocument().getLength());
        } catch(Exception ex) {} */

        this.setTitle("Text2_CHANGEDUPDATE");
    }
    protected void Text2_INSERTUPDATE(DocumentEvent e){
        /*String text = null;
        try {
            text = e.getDocument().getText(0,e.getDocument().getLength());
        } catch(Exception ex) {} */

        this.setTitle("Text2_INSERTUPDATE");
    }
    protected void Text2_REMOVEUPDATE(DocumentEvent e){
        /*String text = null;
        try {
            text = e.getDocument().getText(0,e.getDocument().getLength());
        } catch(Exception ex) {} */

        this.setTitle("Text2_REMOVEUPDATE");
    }


    protected void Text2_KEYPRESSED(KeyEvent e){
        this.setTitle("Text2_KEYPRESSED");
    }
    protected void Text2_KEYRELEASED(KeyEvent e){
        this.setTitle("Text2_KEYRELEASED");
    }
    protected void Text2_KEYTYPED(KeyEvent e){
        this.setTitle("Text2_KEYTYPED");
    }


    protected void Text2_FOCUSGAINED(FocusEvent e){
        this.setTitle("Text2_FOCUSGAINED");
    }
    protected void Text2_FOCUSLOST(FocusEvent e){
        this.setTitle("Text2_FOCUSLOST");
    }


    protected void Text2_ACTIONPERFORMED(ActionEvent e){
        this.setTitle("Text2_ACTIONPERFORMED");
    }


    protected void Text2_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text2_MOUSEPRESSED");
    }
    protected void Text2_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text2_MOUSERELEASED");
    }
    protected void Text2_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text2_MOUSEENTERED");
    }
    protected void Text2_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text2_MOUSEEXITED");
    }
    protected void Text2_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text2_MOUSECLICKED");
    }


    protected void Text2_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text2_MOUSEMOVED");
    }
    protected void Text2_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text2_MOUSEDRAGGED");
    }


    protected void Text1_CHANGEDUPDATE(DocumentEvent e){
        /*String text = null;
        try {
            text = e.getDocument().getText(0,e.getDocument().getLength());
        } catch(Exception ex) {} */

        this.setTitle("Text1_CHANGEDUPDATE");
    }
    protected void Text1_INSERTUPDATE(DocumentEvent e){
        /*String text = null;
        try {
            text = e.getDocument().getText(0,e.getDocument().getLength());
        } catch(Exception ex) {} */

        this.setTitle("Text1_INSERTUPDATE");
    }
    protected void Text1_REMOVEUPDATE(DocumentEvent e){
        /*String text = null;
        try {
            text = e.getDocument().getText(0,e.getDocument().getLength());
        } catch(Exception ex) {} */

        this.setTitle("Text1_REMOVEUPDATE");
    }


    protected void Text1_KEYPRESSED(KeyEvent e){
        this.setTitle("Text1_KEYPRESSED");
    }
    protected void Text1_KEYRELEASED(KeyEvent e){
        this.setTitle("Text1_KEYRELEASED");
    }
    protected void Text1_KEYTYPED(KeyEvent e){
        this.setTitle("Text1_KEYTYPED");
    }


    protected void Text1_FOCUSGAINED(FocusEvent e){
        this.setTitle("Text1_FOCUSGAINED");
    }
    protected void Text1_FOCUSLOST(FocusEvent e){
        this.setTitle("Text1_FOCUSLOST");
    }


    protected void Text1_ACTIONPERFORMED(ActionEvent e){
        this.setTitle("Text1_ACTIONPERFORMED");
    }


    protected void Text1_MOUSEPRESSED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text1_MOUSEPRESSED");
    }
    protected void Text1_MOUSERELEASED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text1_MOUSERELEASED");
    }
    protected void Text1_MOUSEENTERED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text1_MOUSEENTERED");
    }
    protected void Text1_MOUSEEXITED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text1_MOUSEEXITED");
    }
    protected void Text1_MOUSECLICKED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text1_MOUSECLICKED");
    }


    protected void Text1_MOUSEMOVED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text1_MOUSEMOVED");
    }
    protected void Text1_MOUSEDRAGGED(MouseEvent e){
        //int clickCount = e.getClickCount();
        //int x = e.getX();
        //int y = e.getY();
        //boolean lButton = (e.getModifier() & InputEvent.BUTTON1_MASK);
        //boolean rButton = (e.getModifier() & InputEvent.BUTTON3_MASK);
        //boolean shift = e.isShiftDown();
        //boolean alt = e.isAltDown();
        //boolean ctrl = e.isControlDown();
        //boolean meta = e.isMetaDown();

        this.setTitle("Text1_MOUSEDRAGGED");
    }



    public static void main(String[] args) {
        JFrame ChordSearch = new ChordSearchForm();
        ChordSearch.show();
    }
}
