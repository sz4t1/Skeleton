package graphic;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CraftFrame extends  JFrame{

    private JTextArea textvirusMaterial;
    private JComboBox comboBoxViruses;

    public CraftFrame(String[] virusList) {
        super("Craft Virus");

        setLayout(new GridLayout(0,1));

        JPanel upper = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout());
        downer.setLayout(new FlowLayout());

        JLabel craftingLabel = new JLabel("Crafting: ");
        JLabel materialLabel = new JLabel("Needed materials: ");

        comboBoxViruses = new JComboBox(virusList);
        comboBoxViruses.addActionListener(new ComboBoxListener());
        textvirusMaterial = new JTextArea();

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.setActionCommand("CraftkOk");

        upper.add(craftingLabel);
        upper.add(comboBoxViruses);
        upper.add(materialLabel);
        upper.add(textvirusMaterial);

        downer.add(okButton);
        downer.add(cancelButton);

        add(upper);
        add(downer);

        setSize(350, 150);
        setResizable(false);
        setVisible(true);

    }

    public class ComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String choice = (String)comboBoxViruses.getSelectedItem();
            switch (choice){
                case "Amnesia":
                    textvirusMaterial.setText("5x amino acid \n5x nukleotide" );
                    break;
                case "Protection":
                    textvirusMaterial.setText("2x amino acid \n2x nukleotide" );
                    break;
                case "Paralyzing":
                    textvirusMaterial.setText("3x amino acid \n4x nukleotide" );
                    break;
                case "Dance":
                    textvirusMaterial.setText("1x amino acid \n1x nukleotide" );
                    break;
                default:
                    textvirusMaterial.setText("");
            }

        }

    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

}
