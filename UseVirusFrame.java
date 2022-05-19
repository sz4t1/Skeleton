import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseVirusFrame extends JFrame {

    private JComboBox comboBoxViruses;

    private GameScreen parent;

    public UseVirusFrame(Virologist v, GameScreen g){
        super("Use up");

        parent = g;

        setLayout(new GridLayout(0,1));

        JPanel upper = new JPanel();
        JPanel downer = new JPanel();
        upper.setLayout(new FlowLayout());
        downer.setLayout(new FlowLayout());

        JLabel useUpLabel = new JLabel("Use virus on self: ");

        comboBoxViruses = new JComboBox(v.GetVirusList());
        //comboBoxViruses.addItem("teszt");

        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

        upper.add(useUpLabel);
        upper.add(comboBoxViruses);

        downer.add(okButton);
        downer.add(cancelButton);

        add(upper);
        add(downer);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(350, 150);
        setResizable(false);
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if(choice.equals("Ok")) {
                parent.UseVirusCall((String) comboBoxViruses.getSelectedItem());
                dispose();
            }
            else if(choice.equals("Cancel")) {
                dispose();
            }
        }
    }
}
