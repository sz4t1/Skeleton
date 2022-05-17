package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends JFrame {

    private JPanel mapPanel;
    private JLabel currentPlayerLabel;


    public GameScreen(){
        super("Game Board");

        setLayout(new BorderLayout());




        //top
        /////////////////////////////////////////////////////////////
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,2));
        JLabel roundNumberLabel = new JLabel("Round: " + "3");
        roundNumberLabel.setHorizontalAlignment(JLabel.LEFT);
        JLabel currentPlayerNameLabel = new JLabel("p1");
        currentPlayerNameLabel.setHorizontalAlignment(JLabel.RIGHT);
        currentPlayerNameLabel.setBackground(Color.lightGray);
        currentPlayerNameLabel.setOpaque(true);

        topPanel.add(roundNumberLabel);
        topPanel.add(currentPlayerNameLabel);



        //map panel
        /////////////////////////////////////////////////////////////

        JPanel mapPanel = new JPanel();
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

        JButton moveButton = new JButton("Move");

        JButton craftButton = new JButton("Craft");

        JButton scanButton = new JButton("Scan");

        JButton pickupButton = new JButton("Pickup");

        JButton dropButton = new JButton("Drop");

        JButton virusButton = new JButton("Use Virus");

        JButton stealButton = new JButton("Steal");

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

        JLabel pTextLabel = new JLabel("Players");
        JLabel p1Label = new JLabel("p1"); //paraméterből kapják
        JLabel p2Label = new JLabel("p2");
        JLabel p3Label = new JLabel("p3");
        JLabel p4Label = new JLabel("p4");
        p4Label.setBackground(Color.red);      //játékos megkülönböztetés példa
        p4Label.setOpaque(true);
        JLabel p5Label = new JLabel("p5");

        playersPanel.add(pTextLabel);
        playersPanel.add(p1Label);
        playersPanel.add(p2Label);
        playersPanel.add(p3Label);
        playersPanel.add(p4Label);
        playersPanel.add(p5Label);

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
        JTextArea mTextArea = new JTextArea("-a\n-b"); //string kell
        mPanel.add(mLabel);
        mPanel.add(mTextArea);
        bottonPanel.add(mPanel);

        /////////////////////////////////////////////////////////////Equipment

        JPanel ePanel = new JPanel();
        ePanel.setLayout(new BoxLayout(ePanel, BoxLayout.Y_AXIS));
        JLabel eLabel = new JLabel("Equipments");
        JTextArea eTextArea = new JTextArea("-a\n-b"); //string kell
        ePanel.add(eLabel);
        ePanel.add(eTextArea);
        bottonPanel.add(ePanel);

        /////////////////////////////////////////////////////////////Viruses

        JPanel vPanel = new JPanel();
        vPanel.setLayout(new BoxLayout(vPanel, BoxLayout.Y_AXIS));
        JLabel vLabel = new JLabel("Viruses");
        JTextArea vTextArea = new JTextArea("-a\n-b"); // string kell
        vPanel.add(vLabel);
        vPanel.add(vTextArea);
        bottonPanel.add(vPanel);

        /////////////////////////////////////////////////////////////Genetic code

        JPanel gPanel = new JPanel();
        gPanel.setLayout(new BoxLayout(gPanel, BoxLayout.Y_AXIS));
        JLabel gLabel = new JLabel("Genetic code");
        JTextArea gTextArea = new JTextArea("5"); // nagyban kell
        gPanel.add(gLabel);
        gPanel.add(gTextArea);
        bottonPanel.add(gPanel);

        ///////////////////////////////////////////////////////////// Effects

        JPanel effPanel = new JPanel();
        effPanel.setLayout(new BoxLayout(effPanel, BoxLayout.Y_AXIS));
        JLabel effLabel = new JLabel("Effects");
        JTextArea effTextArea = new JTextArea("-a\n-b"); // string kell
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

    public void Update(){
        //todo
    }

    public void MapRender(Game game) {
        //todo
    }

    public JButton getAttackButton() {
        return attackButton;
    }

    public JButton getMoveButton() {
        return moveButton;
    }

    public JButton getCraftButton() {
        return craftButton;
    }

    public JButton getScanButton() {
        return scanButton;
    }

    public JButton getPickUpButton() {
        return pickupButton;
    }

    public JButton getDropButton() {
        return dropButton;
    }

    public JButton getUseVirusButton() {
        return virusButton;
    }

    public JButton getStealButton() {
        return stealButton;
    }
    

}
