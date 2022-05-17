package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PickUpFrame extends JFrame{

    private JComboBox comboBoxAminoAcid;
    private JComboBox comboBoxNukleodite;

    public PickUpFrame(String[][] materialList, String[] equipmentList){
        super("Pickup");

        JPanel box = new JPanel();
        JPanel buttonPanel = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new FlowLayout());


        JLabel pickupLabel = new JLabel("Pickupable items: ");
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout());
        labelPanel.add(pickupLabel);
        /////////////////////////////////////////////////////////////////

        JPanel row1Panel = new JPanel();
        row1Panel.setLayout(new FlowLayout(0));
        JLabel aminoLabel = new JLabel("-amino acid");
        comboBoxAminoAcid = new JComboBox(comboBoxNumbers(materialList[0][1]));
        JCheckBox aminoCheck = new JCheckBox();
        row1Panel.add(aminoLabel);
        row1Panel.add(comboBoxAminoAcid);
        row1Panel.add(aminoCheck);

        /////////////////////////////////////////////////////////////////

        JPanel row2Panel = new JPanel();
        row2Panel.setLayout(new FlowLayout(0));
        JLabel nukleoditeLabel = new JLabel("-nukleodite");
        comboBoxNukleodite = new JComboBox(comboBoxNumbers(materialList[1][1]));
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


        /////////////////////////////////////////////////////////////////


        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.setActionCommand("PickUpOk");

        box.add(labelPanel);
        box.add(row1Panel);
        box.add(row2Panel);
        box.add(row3Panel);
        box.add(row4Panel);
        box.add(row5Panel);
        box.add(row6Panel);

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        box.add(buttonPanel);

        add(box);

        setSize(250, 400);
        setResizable(false);
        setVisible(true);
    }

    private String[] comboBoxNumbers(String max){
        String[] numbers = new String[Integer.parseInt(max) +1];
        for (int i = 0; i <= Integer.parseInt(max); i++) {
            numbers[i] = String.valueOf(i);
        }
        return numbers;
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
