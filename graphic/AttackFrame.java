package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackFrame extends JFrame {

    private JComboBox comboBoxAttack;
    private JComboBox comboBoxUsedItem;

    public AttackFrame(String[] playerList, String[] itemList){
        super("Attack");

        setLayout(new GridLayout(0,1));

        JPanel upper = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout());
        downer.setLayout(new FlowLayout());

        JLabel attackLabel = new JLabel("Attack: ");
        JLabel withlLabel = new JLabel("With: ");

        comboBoxAttack = new JComboBox(playerList);
        comboBoxUsedItem = new JComboBox(itemList);

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

        upper.add(attackLabel);
        upper.add(comboBoxAttack);
        upper.add(withlLabel);
        upper.add(comboBoxUsedItem);

        downer.add(okButton);
        downer.add(cancelButton);

        add(upper);
        add(downer);

        setSize(350, 150);
        setResizable(false);
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if(choice.equals("Apply")) {

            }
            else if(choice.equals("Cancel")) {
                dispose();
            }
        }
    }
}
