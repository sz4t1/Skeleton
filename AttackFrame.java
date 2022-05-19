import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AttackFrame extends JFrame {

    private JComboBox comboBoxAttack;
    private JComboBox comboBoxUsedItem;
    private JRadioButton bVirus;
    private JRadioButton bAxe;
    private ButtonGroup aV;

    private GameScreen parent;

    public AttackFrame(ArrayList<Virologist> virologists, Virologist v, GameScreen g){
        super("Attack");

        parent = g;

        setLayout(new GridLayout(0,1));

        JPanel upper = new JPanel();
        JPanel middle = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout());
        middle.setLayout(new FlowLayout());
        downer.setLayout(new FlowLayout());

        aV = new ButtonGroup();

        JLabel attackLabel = new JLabel("Attack: ");
        JLabel withlLabel = new JLabel("With: ");

        comboBoxAttack = new JComboBox(parent.GetVirologistNames());
        comboBoxUsedItem = new JComboBox(v.GetVirusList());
        JLabel axeLabel = new JLabel("Axe ");
        bVirus = new JRadioButton();
        bAxe = new JRadioButton();

        aV.add(bVirus);
        aV.add(bAxe);

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

        upper.add(attackLabel);
        upper.add(comboBoxAttack);
        upper.add(withlLabel);
        upper.add(comboBoxUsedItem);
        upper.add(bVirus);

        middle.add(axeLabel);
        middle.add(bAxe);

        downer.add(okButton);
        downer.add(cancelButton);

        add(upper);
        add(middle);
        add(downer);

        setSize(350, 200);
        setResizable(false);
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if(choice.equals("Ok")) {
                if (bVirus.isSelected()){
                    parent.AttackCall((String)comboBoxAttack.getSelectedItem(), (String)comboBoxUsedItem.getSelectedItem(), false);
                }
                else if(bAxe.isSelected()){
                    parent.AttackCall((String)comboBoxAttack.getSelectedItem(), null, true);
                }
                dispose();
            }
            else if(choice.equals("Cancel")) {
                dispose();
            }
        }
    }



}
