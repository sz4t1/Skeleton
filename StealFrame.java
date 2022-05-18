import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StealFrame extends JFrame {

    private JComboBox comboBoxSteal;
    private JComboBox comboBoxAminoAcid;
    private JComboBox comboBoxNukleodite;
    private JComboBox comboBoxAxe;
    private JComboBox comboBoxSack;
    private JComboBox comboBoxGlove;
    private JComboBox comboBoxCape;

    private ArrayList<Virologist> viro;

    public StealFrame(ArrayList<Virologist> v){
        super("Steal");
        this.viro = v;

        setLayout(new BorderLayout());

        JPanel upper = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout());
        downer.setLayout(new FlowLayout());

        JLabel stealLabel = new JLabel("Steal from: ");
        comboBoxSteal = new JComboBox(comboBoxNames(this.viro));
        comboBoxSteal.addActionListener(new ComboBoxListener());
        upper.add(stealLabel);
        upper.add(comboBoxSteal);

        //middle
        ///////////////////////////////////////////////////////////////////////

        JPanel playerinvenotyPanel = new JPanel();
        playerinvenotyPanel.setLayout(new BoxLayout(playerinvenotyPanel, BoxLayout.Y_AXIS));

        JLabel inventoryLabel = new JLabel("Inventory: ");
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout());
        labelPanel.add(inventoryLabel);

        /////////////////////////////////////////////////////////////////

        JPanel row1Panel = new JPanel();
        row1Panel.setLayout(new FlowLayout(0));
        JLabel aminoLabel = new JLabel("-amino acid");
        comboBoxAminoAcid = new JComboBox(comboBoxNumbers(String.valueOf(viro.get(0).GetAminoAcidCount())));  //viros.get(0).getAminoacidNumber()
        JCheckBox aminoCheck = new JCheckBox();
        row1Panel.add(aminoLabel);
        row1Panel.add(comboBoxAminoAcid);
        row1Panel.add(aminoCheck);

        /////////////////////////////////////////////////////////////////

        JPanel row2Panel = new JPanel();
        row2Panel.setLayout(new FlowLayout(0));
        JLabel nukleoditeLabel = new JLabel("-nukleodite");
        comboBoxNukleodite = new JComboBox(comboBoxNumbers(String.valueOf(viro.get(0).GetNukleoditeCount()))); //todo
        JCheckBox nukleoditeCheck = new JCheckBox();
        row2Panel.add(nukleoditeLabel);
        row2Panel.add(comboBoxNukleodite);
        row2Panel.add(nukleoditeCheck);


        /////////////////////////////////////////////////////////////////
        JPanel row3Panel = new JPanel();
        row3Panel.setLayout(new FlowLayout(0));
        JLabel axeLabel = new JLabel("-axe ");
        JCheckBox axeCheck = new JCheckBox();
        row3Panel.add(axeLabel);
        row3Panel.add(axeCheck);


        /////////////////////////////////////////////////////////////////
        JPanel row4Panel = new JPanel();
        row4Panel.setLayout(new FlowLayout(0));
        JLabel sackLabel = new JLabel("-sack ");
        JCheckBox sackCheck = new JCheckBox();
        row4Panel.add(sackLabel);
        row4Panel.add(sackCheck);


        /////////////////////////////////////////////////////////////////
        JPanel row5Panel = new JPanel();
        row5Panel.setLayout(new FlowLayout(0));
        JLabel gloveLabel = new JLabel("-glove ");
        JCheckBox gloveCheck = new JCheckBox();
        row5Panel.add(gloveLabel);
        row5Panel.add(gloveCheck);

        /////////////////////////////////////////////////////////////////
        JPanel row6Panel = new JPanel();
        row6Panel.setLayout(new FlowLayout(0));
        JLabel capeLabel = new JLabel("-cape ");
        JCheckBox capeCheck = new JCheckBox();
        row6Panel.add(capeLabel);
        row6Panel.add(capeCheck);


        ///////////////////////////////////////////////////////////////////////

        playerinvenotyPanel.add(labelPanel);
        playerinvenotyPanel.add(row1Panel);
        playerinvenotyPanel.add(row2Panel);
        playerinvenotyPanel.add(row3Panel);
        playerinvenotyPanel.add(row4Panel);
        playerinvenotyPanel.add(row5Panel);
        playerinvenotyPanel.add(row6Panel);


        ///////////////////////////////////////////////////////////////////////

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

        downer.add(okButton);
        downer.add(cancelButton);

        add(upper, BorderLayout.PAGE_START);
        add(playerinvenotyPanel, BorderLayout.CENTER);
        add(downer, BorderLayout.PAGE_END);

        setSize(250, 450);
        setResizable(true);
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
            int choice = comboBoxSteal.getSelectedIndex();
            //System.out.print(choice);
            ChangeInventory(viro.get(choice));

        }
    }


    private String[] comboBoxNumbers(String max){
        String[] numbers = new String[Integer.parseInt(max) +1];
        for (int i = 0; i <= Integer.parseInt(max); i++) {
            numbers[i] = String.valueOf(i);
        }
        return numbers;
    }

    private String[] comboBoxNames(ArrayList<Virologist> viro) {
        String[] nameStrings = new String[viro.size()];
        for (int i = 0; i < viro.size(); i++) {
            nameStrings[i] = viro.get(i).toString();    //EZ NEM VÉGLEGES!!!!!!!
        }
        return nameStrings;
    }

    private void ChangeInventory(Virologist v) {
        //todo

    }
}
