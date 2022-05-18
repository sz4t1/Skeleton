import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameScreen extends JFrame {

    private JPanel mapPanel;
    private JLabel currentPlayerLabel;

    private JLabel roundNumberLabel;
    private JLabel currentPlayerNameLabel;
    private int currentPlayerIndex;

    private JTextArea mTextArea;
    private JTextArea eTextArea;
    private JTextArea vTextArea;
    private JTextArea gTextArea;
    private JTextArea effTextArea;

    private ArrayList<Virologist> virologists;
    private ArrayList<Field> fields;

    public GameScreen(ArrayList<Field> f, ArrayList<Virologist> v){
        super("Game Board");

        currentPlayerIndex = 0;
        virologists = v;
        fields = f;

        setLayout(new BorderLayout());


        //top
        /////////////////////////////////////////////////////////////
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,2));
        roundNumberLabel = new JLabel("Round: " + game.GetRound());
        roundNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        currentPlayerNameLabel = new JLabel(v.get(0).GetName());
        currentPlayerNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        currentPlayerNameLabel.setBackground(Color.lightGray);
        currentPlayerNameLabel.setOpaque(true);

        topPanel.add(roundNumberLabel);
        topPanel.add(currentPlayerNameLabel);



        //map panel
        /////////////////////////////////////////////////////////////

        JPanel mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(5,5));
        mapPanel.setBackground(Color.gray);
        mapPanel.setOpaque(true);



        /////////////////////////////////////////////////////////////



        //right side
        /////////////////////////////////////////////////////////////
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));


        /////////////////////////////////////////////////////////////Gombok
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(4, 2));

        /////////////////////////////////////////////////////////////
        JButton attackButton = new JButton("Attack");
        attackButton.addActionListener(new ButtonListener());

        JButton moveButton = new JButton("Move");
        moveButton.addActionListener(new ButtonListener());

        JButton craftButton = new JButton("Craft");
        craftButton.addActionListener(new ButtonListener());

        JButton scanButton = new JButton("Scan");
        scanButton.addActionListener(new ButtonListener());

        JButton pickupButton = new JButton("Pickup");
        pickupButton.addActionListener(new ButtonListener());

        JButton dropButton = new JButton("Drop");
        dropButton.addActionListener(new ButtonListener());

        JButton virusButton = new JButton("Use Virus");
        virusButton.addActionListener(new ButtonListener());

        JButton stealButton = new JButton("Steal");
        stealButton.addActionListener(new ButtonListener());

        buttonsPanel.add(attackButton);
        buttonsPanel.add(moveButton);
        buttonsPanel.add(craftButton);
        buttonsPanel.add(scanButton);
        buttonsPanel.add(pickupButton);
        buttonsPanel.add(dropButton);
        buttonsPanel.add(virusButton);
        buttonsPanel.add(stealButton);

        rightPanel.add(buttonsPanel);

        /////////////////////////////////////////////////////////////Játékosok

        JPanel playersPanel = new JPanel();
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        playersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        /**
         * Feltölti a játékos label-ket.
         */
        JLabel pTextLabel = new JLabel("Players");
        for (int i = 0; i < v.size(); i++) {
            playersPanel.add(new JLabel(v.get(i).GetName()));
        }
//        JLabel p1Label = new JLabel(virologists.get(0).getName()); //paraméterből kapják
//        JLabel p2Label = new JLabel("p2");
//        JLabel p3Label = new JLabel("p3");
//        JLabel p4Label = new JLabel("p4");
//        p4Label.setBackground(Color.red);      //játékos megkülönböztetés példa
//        p4Label.setOpaque(true);
//        JLabel p5Label = new JLabel("p5");

        playersPanel.add(pTextLabel);
//        playersPanel.add(p1Label);
//        playersPanel.add(p2Label);
//        playersPanel.add(p3Label);
//        playersPanel.add(p4Label);
//        playersPanel.add(p5Label);

        rightPanel.add(playersPanel);



        /////////////////////////////////////////////////////////////











        //botton
        /////////////////////////////////////////////////////////////
        JPanel bottonPanel = new JPanel();
        bottonPanel.setLayout(new FlowLayout());
        JLabel inventoryLabel = new JLabel("Inventory:");
        bottonPanel.add(inventoryLabel, BorderLayout.PAGE_END);

        /////////////////////////////////////////////////////////////Material

        JPanel mPanel = new JPanel();
        mPanel.setLayout(new BoxLayout(mPanel, BoxLayout.Y_AXIS));
        JLabel mLabel = new JLabel("Materials");
        mTextArea = new JTextArea("-amino acid X " + v.get(0).getAminoAcidCount()+
                                "\n-nukleodite X " +v.get(0).getNuklediteCount());
        mPanel.add(mLabel);
        mPanel.add(mTextArea);
        bottonPanel.add(mPanel);

        /////////////////////////////////////////////////////////////Equipment

        JPanel ePanel = new JPanel();
        ePanel.setLayout(new BoxLayout(ePanel, BoxLayout.Y_AXIS));
        JLabel eLabel = new JLabel("Equipments");
        eTextArea = new JTextArea("-Axe X " v.get(0).getAxeCount()+
                                    "\n-Cape X " + v.get(0).getCapeCount()+
                                    "\n-Sack X " + v.get(0).getSackCount()+
                                    "\n-Glove X " + v.get(0).getGloveCount());
        ePanel.add(eLabel);
        ePanel.add(eTextArea);
        bottonPanel.add(ePanel);

        /////////////////////////////////////////////////////////////Viruses

        JPanel vPanel = new JPanel();
        vPanel.setLayout(new BoxLayout(vPanel, BoxLayout.Y_AXIS));
        JLabel vLabel = new JLabel("Viruses");
        vTextArea = new JTextArea("-Dance X " v.get(0).getVDanceCount()+
                                "\n-Paralyzing X " + v.get(0).getVParalyzingCount()+
                                "\n-Protection X " + v.get(0).getVProtectionCount()+
                                "\n-Amnesia X " + v.get(0).getVAmnesiaCount()); // string kell
        vPanel.add(vLabel);
        vPanel.add(vTextArea);
        bottonPanel.add(vPanel);

        /////////////////////////////////////////////////////////////Genetic code

        JPanel gPanel = new JPanel();
        gPanel.setLayout(new BoxLayout(gPanel, BoxLayout.Y_AXIS));
        JLabel gLabel = new JLabel("Genetic code");
        gTextArea = new JTextArea(v.get(0).getGeneticCodeCount()); // nagyban kell
        gPanel.add(gLabel);
        gPanel.add(gTextArea);
        bottonPanel.add(gPanel);

        ///////////////////////////////////////////////////////////// Effects

        JPanel effPanel = new JPanel();
        effPanel.setLayout(new BoxLayout(effPanel, BoxLayout.Y_AXIS));
        JLabel effLabel = new JLabel("Effects");
        effTextArea = new JTextArea(v.get(0).getCurrentEffect); // string kell
        effPanel.add(effLabel);
        effPanel.add(effTextArea);
        bottonPanel.add(effPanel);

        /////////////////////////////////////////////////////////////



        //felvesz
        add(topPanel, BorderLayout.PAGE_START);
        add(mapPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
        add(bottonPanel, BorderLayout.PAGE_END);

        setSize(800, 400);
        setResizable(false);
        setVisible(true);

    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            switch (choice) {
                case "Use Virus":
                    UseVirusFrame virus = new UseVirusFrame(virologists.get(currentPlayerIndex));
                    break;
                case "Attack":
                    AttackFrame attack = new AttackFrame(virologists, virologists.get(currentPlayerIndex));
                    break;
                case "Move":
                    MoveFrame move = new MoveFrame(); //itt vissza kapjuk merre akart mozogni
                    break;
                case "Craft":
                    CraftFrame craft = new CraftFrame(valami.getVirusList); //
                    break;
                case "Scan":
                    if (fields.get(standingField).getGeneticCode() != null){
                        virologists.get(currentPlayerIndex).AddGeneticCode;
                    }
                    break;
                case "Pickup":
                    PickUpFrame pickup = new PickUpFrame(fields.get(standingField));
                    break;
                case "Drop":
                    DropFrame drop = new DropFrame(virologists.get(currentPlayerIndex));
                    break;
                case "Steal":
                    StealFrame steal = new StealFrame(virologists);
                    break;
                default:
                    //do nothing
                    break;
            }
        }
    }

    public void Update(){
        //todo
    }



}
