import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * This popup frame will start the crafting action
 */
public class CraftFrame extends  JFrame{

    private JTextArea textvirusMaterial;
    private JComboBox comboBoxViruses;

    private GameScreen parent;

    private String[] viruses = {"Amnesia", "Protection", "Paralyzing", "Dance"};

    public CraftFrame(GameScreen g) {
        super("Craft Virus");

        parent = g;

        setLayout(new GridLayout(0,1));

        JPanel upper = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout());
        downer.setLayout(new FlowLayout());

        JLabel craftingLabel = new JLabel("Crafting: ");
        JLabel materialLabel = new JLabel("Needed materials: ");

        comboBoxViruses = new JComboBox(viruses);
        comboBoxViruses.addActionListener(new ComboBoxListener());
        textvirusMaterial = new JTextArea();

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

        upper.add(craftingLabel);
        upper.add(comboBoxViruses);
        upper.add(materialLabel);
        upper.add(textvirusMaterial);

        downer.add(okButton);
        downer.add(cancelButton);

        add(upper);
        add(downer);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(375, 125);
        setResizable(false);
        setVisible(true);

    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if(choice.equals("Ok")) {
                parent.CraftCall((String)comboBoxViruses.getSelectedItem());
                dispose();
            }
            else if(choice.equals("Cancel")) {
                dispose();
            }
        }
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
                    textvirusMaterial.setText("8x amino acid \n8x nukleotide" );
                    break;
                case "Dance":
                    textvirusMaterial.setText("1x amino acid \n1x nukleotide" );
                    break;
                default:
                    textvirusMaterial.setText("");
            }

        }

    }

}
