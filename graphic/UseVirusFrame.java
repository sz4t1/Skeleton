package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseVirusFrame extends JFrame {

    private JComboBox comboBoxViruses;
    private JButton okButton;
    private JButton cancelButton;

    public UseVirusFrame(String[] virusList){
        super("Use up");

        setLayout(new GridLayout(0,1));

        JPanel upper = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout());
        downer.setLayout(new FlowLayout());

        JLabel useUpLabel = new JLabel("Use virus on self: ");

        comboBoxViruses = new JComboBox(virusList);

        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");

        okButton.setActionCommand("UseViruskOk");

        upper.add(useUpLabel);
        upper.add(comboBoxViruses);

        downer.add(okButton);
        downer.add(cancelButton);

        add(upper);
        add(downer);

        setSize(350, 150);
        setResizable(false);
        setVisible(true);
    }

    public JButton getOkButton() {
        return okButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
