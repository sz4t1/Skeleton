package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StealFrame extends JFrame {

    private JComboBox comboBoxSteal;
    private JComboBox comboBoxUsedItem;

    private CardLayout crd = new CardLayout();

    private JPanel middle = new JPanel();

    public StealFrame(String[] playerList){
        super("Steal");

        setLayout(new GridLayout(0,2));

        JPanel upper = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout());
        middle.setLayout(crd);
        downer.setLayout(new FlowLayout());

        JLabel stealLabel = new JLabel("Steal from: ");
        comboBoxSteal = new JComboBox(playerList);
        comboBoxSteal.addActionListener(new ComboBoxListener());
        upper.add(stealLabel);
        upper.add(comboBoxSteal);

        //middle
        ///////////////////////////////////////////////////////////////////////

        JLabel a = new JLabel("a");
        JLabel b = new JLabel("b");
        JLabel c = new JLabel("c");


        middle.add("a", a);
        middle.add("b", b);
        middle.add("c", c);






        ///////////////////////////////////////////////////////////////////////

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

        downer.add(okButton);
        downer.add(cancelButton);

        add(upper);
        add(middle);
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

    public class ComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String choice = (String)comboBoxSteal.getSelectedItem();
            crd.show(middle, choice);
            }
    }






}
