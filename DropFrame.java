import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropFrame extends JFrame{

    private JComboBox comboBoxAminoAcid;
    private JComboBox comboBoxNukleodite;
    private JComboBox comboBoxAxe;
    private JComboBox comboBoxSack;
    private JComboBox comboBoxGlove;
    private JComboBox comboBoxCape;

    private GameScreen parent;

    public DropFrame(Virologist v, GameScreen g){
        super("Drop");

        parent = g;

        JPanel box = new JPanel();
        JPanel buttonPanel = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new FlowLayout());


        JLabel pickupLabel = new JLabel("Drop items: ");
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout());
        labelPanel.add(pickupLabel);
        /////////////////////////////////////////////////////////////////

        JPanel row1Panel = new JPanel();
        row1Panel.setLayout(new FlowLayout(0));
        JLabel aminoLabel = new JLabel("-amino acid");
        comboBoxAminoAcid = new JComboBox(comboBoxNumbers(Integer.toString(v.GetAminoAcidCount()) ));

        row1Panel.add(aminoLabel);
        row1Panel.add(comboBoxAminoAcid);


        /////////////////////////////////////////////////////////////////

        JPanel row2Panel = new JPanel();
        row2Panel.setLayout(new FlowLayout(0));
        JLabel nukleoditeLabel = new JLabel("-nukleodite");
        comboBoxNukleodite = new JComboBox(comboBoxNumbers(Integer.toString(v.GetNukleoditeCount())));

        row2Panel.add(nukleoditeLabel);
        row2Panel.add(comboBoxNukleodite);


        /////////////////////////////////////////////////////////////////

        //virusok is kellenek ide, még kigondolom hogyan!



        /////////////////////////////////////////////////////////////////
        JPanel row3Panel = new JPanel();
        row3Panel.setLayout(new FlowLayout(0));
        JLabel axeLabel = new JLabel("-axe ");
        comboBoxAxe = new JComboBox(comboBoxNumbers(Integer.toString(v.getAxeCount())));

        row3Panel.add(axeLabel);
        row3Panel.add(comboBoxAxe);



        /////////////////////////////////////////////////////////////////
        JPanel row4Panel = new JPanel();
        row4Panel.setLayout(new FlowLayout(0));
        JLabel sackLabel = new JLabel("-sack ");
        comboBoxSack = new JComboBox(comboBoxNumbers(Integer.toString(v.getSackCount())));

        row4Panel.add(sackLabel);
        row4Panel.add(comboBoxSack);



        /////////////////////////////////////////////////////////////////
        JPanel row5Panel = new JPanel();
        row5Panel.setLayout(new FlowLayout(0));
        JLabel gloveLabel = new JLabel("-glove ");
        comboBoxGlove = new JComboBox(comboBoxNumbers(Integer.toString(v.getGloveCount())));

        row5Panel.add(gloveLabel);
        row5Panel.add(comboBoxGlove);


        /////////////////////////////////////////////////////////////////
        JPanel row6Panel = new JPanel();
        row6Panel.setLayout(new FlowLayout(0));
        JLabel capeLabel = new JLabel("-cape ");
        comboBoxCape = new JComboBox(comboBoxNumbers(Integer.toString(v.getCapeCount())));

        row6Panel.add(capeLabel);
        row6Panel.add(comboBoxCape);



        /////////////////////////////////////////////////////////////////


        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

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

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(250, 425);
        setResizable(false);
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if(choice.equals("Ok")) {
                parent.DropCall( Integer.parseInt((String)comboBoxAminoAcid.getSelectedItem()),
                        Integer.parseInt((String)comboBoxNukleodite.getSelectedItem()),
                        Integer.parseInt((String)comboBoxAxe.getSelectedItem()),
                        Integer.parseInt((String)comboBoxSack.getSelectedItem()),
                        Integer.parseInt((String)comboBoxGlove.getSelectedItem()),
                                Integer.parseInt((String)comboBoxCape.getSelectedItem())
                );
                dispose();
            }
            else if(choice.equals("Cancel")) {
                dispose();
            }
        }
    }

    private String[] comboBoxNumbers(String max){
        String[] numbers = new String[Integer.parseInt(max) +1];
        for (int i = 0; i <= Integer.parseInt(max); i++) {
            numbers[i] = String.valueOf(i);
        }
        return numbers;
    }

}
