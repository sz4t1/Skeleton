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
    private Game game;
    ArrayList<DrawField> drawFields= new ArrayList<>();
    public GameScreen(Game game){
        super("Game Board");

        //Connect the game with gamescreen
        this.game = game;
        game.setGameScreen(this);

        currentPlayerIndex = 0;
        virologists = game.getVirologists();
        System.out.println("virologusok pipa");
        fields = game.getFields();
        System.out.println("fieldek pipa");

        setLayout(new BorderLayout());

        //top
        /////////////////////////////////////////////////////////////
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,2));

        roundNumberLabel = new JLabel("Round: " + game.GetRound());

        roundNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        currentPlayerNameLabel = new JLabel(virologists.get(1).GetName());
        currentPlayerNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        currentPlayerNameLabel.setBackground(Color.YELLOW);
        currentPlayerNameLabel.setOpaque(true);

        topPanel.add(roundNumberLabel);
        topPanel.add(currentPlayerNameLabel);

        //map panel
        /////////////////////////////////////////////////////////////

        JPanel mapPanel = new JPanel();
        GridLayout gameGrid= new GridLayout(5,5);
        gameGrid.setVgap(5);
        gameGrid.setHgap(5);
        mapPanel.setLayout(gameGrid);
        for(int i=0;i<25;i++)
        {
            switch(i){
                case 4: case 10: case 11: case 21: case 24:{ drawFields.add(new DrawLaboratory()); break;}
                case 0: case 23: {drawFields.add(new DrawShelter());break;}
                case 1: case 12: case 14: case 20:{ drawFields.add(new DrawWarehouse());break;}
                default:{ drawFields.add(new DrawField()); break; }
            }
        }
        drawFields.get(0).setFieldOnce(game.getField("Shelter1"));
        drawFields.get(1).setFieldOnce(game.getField("Warehouse4"));
        drawFields.get(2).setFieldOnce(game.getField("Field1"));
        drawFields.get(3).setFieldOnce(game.getField("Field2"));
        drawFields.get(4).setFieldOnce(game.getField("Laboratory3"));

        drawFields.get(5).setFieldOnce(game.getField("Field3"));
        drawFields.get(6).setFieldOnce(game.getField("Field4"));
        drawFields.get(7).setFieldOnce(game.getField("Field5"));
        drawFields.get(8).setFieldOnce(game.getField("Field6"));
        drawFields.get(9).setFieldOnce(game.getField("Field7"));

        drawFields.get(10).setFieldOnce(game.getField("Laboratory5"));
        drawFields.get(11).setFieldOnce(game.getField("Laboratory4"));
        drawFields.get(12).setFieldOnce(game.getField("Warehouse1"));
        drawFields.get(13).setFieldOnce(game.getField("Field8"));
        drawFields.get(14).setFieldOnce(game.getField("Warehouse3"));

        drawFields.get(15).setFieldOnce(game.getField("Field9"));
        drawFields.get(16).setFieldOnce(game.getField("Field10"));
        drawFields.get(17).setFieldOnce(game.getField("Field11"));
        drawFields.get(18).setFieldOnce(game.getField("Field12"));
        drawFields.get(19).setFieldOnce(game.getField("Field13"));

        drawFields.get(20).setFieldOnce(game.getField("Warehouse2"));
        drawFields.get(21).setFieldOnce(game.getField("Laboratory1"));
        drawFields.get(22).setFieldOnce(game.getField("Field14"));
        drawFields.get(23).setFieldOnce(game.getField("Shelter2"));
        drawFields.get(24).setFieldOnce(game.getField("Laboratory2"));
        for(int i=0;i<25;i++)
        {
            switch(i){
                case 4: case 10: case 11: case 21: case 24:{ mapPanel.add(drawFields.get(i)); break;}
                case 0: case 23: {mapPanel.add(drawFields.get(i));break;}
                case 1: case 12: case 14: case 20:{mapPanel.add(drawFields.get(i));break;}
                default:{mapPanel.add(drawFields.get(i)); break; }
            }
        }

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

        /////////////////////////////////////////////////////////////J??t??kosok

        JPanel playersPanel = new JPanel();
        playersPanel.setLayout(new BoxLayout(playersPanel, BoxLayout.Y_AXIS));
        playersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        /**
         * Felt??lti a j??t??kos label-ket.
         */

        JLabel pTextLabel = new JLabel("Players:");
        playersPanel.add(pTextLabel);
        for (int i = 0; i < virologists.size(); i++) {
            playersPanel.add(new JLabel(virologists.get(i).GetName()));
        }

        rightPanel.add(playersPanel);

        //botton
        /////////////////////////////////////////////////////////////
        JPanel bottonPanel = new JPanel();
        bottonPanel.setLayout(new GridLayout(1 , 6));
        JLabel inventoryLabel = new JLabel("Inventory:");
        bottonPanel.add(inventoryLabel, BorderLayout.PAGE_END);

        /////////////////////////////////////////////////////////////Material

        JPanel mPanel = new JPanel();
        mPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mPanel.setLayout(new BorderLayout());
        JLabel mLabel = new JLabel("Materials");
        mTextArea = new JTextArea();
        mTextArea.setEditable(false);
//        mTextArea = new JTextArea("-amino acid X " + virologists.get(0).GetAminoAcidCount()+
//                                "\n-nukleodite X " +virologists.get(0).GetNukleoditeCount());
        mPanel.add(mLabel, BorderLayout.PAGE_START);
        mPanel.add(mTextArea, BorderLayout.CENTER);
        bottonPanel.add(mPanel);

        /////////////////////////////////////////////////////////////Equipment

        JPanel ePanel = new JPanel();
        ePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        ePanel.setLayout(new BorderLayout());
        JLabel eLabel = new JLabel("Equipments");
        eTextArea = new JTextArea();
        eTextArea.setEditable(false);

        ePanel.add(eLabel, BorderLayout.PAGE_START);
        ePanel.add(eTextArea, BorderLayout.CENTER);
        bottonPanel.add(ePanel);

        /////////////////////////////////////////////////////////////Viruses

        JPanel vPanel = new JPanel();
        vPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //vPanel.setLayout(new BoxLayout(vPanel, BoxLayout.Y_AXIS));
        vPanel.setLayout(new BorderLayout());
        JLabel vLabel = new JLabel("Viruses");
        vTextArea = new JTextArea();
        vTextArea.setEditable(false);

        vPanel.add(vLabel, BorderLayout.PAGE_START);
        vPanel.add(vTextArea, BorderLayout.CENTER);
        bottonPanel.add(vPanel);

        /////////////////////////////////////////////////////////////Genetic code

        JPanel gPanel = new JPanel();
        gPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        gPanel.setLayout(new BorderLayout());
        JLabel gLabel = new JLabel("Genetic code");
        gTextArea = new JTextArea();
        gTextArea.setFont(new Font("Monospaced", Font.PLAIN, 50));
        gTextArea.setEditable(false);

        gPanel.add(gLabel, BorderLayout.PAGE_START);
        gPanel.add(gTextArea, BorderLayout.CENTER);
        bottonPanel.add(gPanel);

        ///////////////////////////////////////////////////////////// Effects

        JPanel effPanel = new JPanel();
        effPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        effPanel.setLayout(new BorderLayout());
        JLabel effLabel = new JLabel("Effects");
        effTextArea = new JTextArea();
        effTextArea.setLineWrap(true);
        effTextArea.setWrapStyleWord(true);
        effTextArea.setEditable(false);

        effPanel.add(effLabel, BorderLayout.PAGE_START);
        effPanel.add(effTextArea, BorderLayout.CENTER);
        bottonPanel.add(effPanel);

        /////////////////////////////////////////////////////////////

        //felvesz
        add(topPanel, BorderLayout.PAGE_START);
        add(mapPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.LINE_END);
        add(bottonPanel, BorderLayout.PAGE_END);

        UpdateScreenData(virologists.get(0));

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 700);
        setResizable(false);
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();

            //EZ NEM TOM MIT, HOGYAN CSINaL
            //FUTTAT??S ??RDEK??BEN EGYENL??RE KIKOMMENTEZVE

            switch (choice) {
                case "Use Virus":
                    UseVirusFrame virus = new UseVirusFrame(virologists.get(game.getActiveVirologistIndex()),  GetGameScreen());
                    break;
                case "Attack":
                    AttackFrame attack = new AttackFrame(virologists.get(game.getActiveVirologistIndex()).getField().getVirologists() , virologists.get(game.getActiveVirologistIndex()), GetGameScreen());
                    break;
                case "Move":
                    MoveFrame move = new MoveFrame(virologists.get(game.getActiveVirologistIndex()).getField().getNeighbours(), GetGameScreen()); //itt vissza kapjuk merre akart mozogni
                    break;
                case "Craft":
                    CraftFrame craft = new CraftFrame(GetGameScreen()); //
                    break;
                case "Scan":
                    game.ScanCommand();
                    break;
                case "Pickup":
                    PickUpFrame pickup = new PickUpFrame(virologists.get(game.getActiveVirologistIndex()).getField(), GetGameScreen()); //Ide k??ne m??g a fieldben l??v?? elemek
                      break;
                case "Drop":
                    DropFrame drop = new DropFrame(virologists.get(game.getActiveVirologistIndex()), GetGameScreen());
                    break;
                case "Steal":
                    StealFrame steal = new StealFrame(virologists, GetGameScreen());
                    break;
                default:
                    //do nothing
                    break;
            }
        }
    }

    public void UpdateScreenData(Virologist v){
        //materials
        mTextArea.setText("-amino acid X " + v.GetAminoAcidCount()+
                                "\n-nukleodite X " + v.GetNukleoditeCount());
        //equipments
        eTextArea.setText("-Axe X " + v.getAxeCount()+
                "\n-Cape X " + v.getCapeCount()+
                "\n-Sack X " + v.getSackCount()+
                "\n-Glove X " + v.getGloveCount());
        //viruses
        vTextArea.setText("-Dance X " + v.getVDanceCount()+
                "\n-Paralyzing X " + v.getVParalyzingCount()+
                "\n-Protection X " + v.getVProtectionCount()+
                "\n-Amnesia X " + v.getVAmnesiaCount());
        //Genetic Code
        gTextArea.setText(Integer.toString(v.getGenCodesAmmount()));
        //effects
        effTextArea.setText(v.getCurrentEffect());
        //Table
        for(int i=0;i<25;i++) {
            drawFields.get(i).repaint();
            drawFields.get(i).validate();
        }
        //Round label
        roundNumberLabel.setText("Round: " + game.GetRound());
        //Active Virologist
        currentPlayerNameLabel.setText(game.getActiveVirologistName());

    }

    public String[] GetVirologistNames(){
        int size = virologists.size()-1;
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            if (!(virologists.get(game.getActiveVirologistIndex()).GetName().equals(virologists.get(i).GetName()))){
                names[i] = virologists.get(i).GetName();
            }
        }
        return names;
    }

    private GameScreen GetGameScreen(){
        return this;
    }

    public void UseVirusCall(String virus){
        game.UseVirusCommand(virus);
    }

    public void AttackCall(String attackViro, String virus, boolean axe){
        game.AttackCommand(attackViro, virus, axe);
    }

    public  void DropCall(int amino, int nukle, int axe, int sack, int glove, int cape){
        game.DropCommand(amino, nukle, axe, cape, glove, sack);
    }

    public  void StealCall(String viroName ,int amino, int nukle, int axe, int sack, int glove, int cape){
        game.StealCommand(viroName, amino, nukle, axe, cape, glove, sack);
    }

    public void CraftCall(String virus){
       game.CraftCommand(virus);
    }

    public void PickUpCall(int amino, int nukle, int axe, int sack, int glove, int cape){
        game.PickUpCommand(amino, nukle, axe, cape, glove, sack);
    }

    public void  MoveCall(String fieldname){
        game.MoveCommand(fieldname);
    }
}
