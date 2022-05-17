package graphic;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuScreen extends JFrame {

    private JComboBox playerNumbersComboBox;

    public MainMenuScreen() {
        setLayout(new GridLayout(0,1));

        JPanel upper = new JPanel();
        JPanel lower = new JPanel();
        upper.setLayout(new GridBagLayout());
        lower.setLayout(new GridLayout(1, 3));

        GridBagConstraints gbc = new GridBagConstraints();

        upper.setBackground(Color.green);

        JPanel lowerLeft = new JPanel();
        JPanel lowerMid = new JPanel();
        JPanel lowerRight = new JPanel();

        lowerMid.setLayout(new BoxLayout(lowerMid, BoxLayout.Y_AXIS));
        lowerRight.setLayout(new BoxLayout(lowerRight, BoxLayout.Y_AXIS));

        lowerLeft.setBackground(Color.green);
        lowerMid.setBackground(Color.green);
        lowerRight.setBackground(Color.green);

        JLabel titleLabel = new JLabel("The World of Worldless");
        titleLabel.setFont(new Font("ARIAL", Font.BOLD, 30));
        JLabel playerNumberLabel = new JLabel("Number of players:");

        Integer[] numbers = {1, 2, 3, 4, 5};
        playerNumbersComboBox = new JComboBox(numbers);

        JButton playButton = new JButton("Play");
        JButton helpButton = new JButton("Help");

        playButton.addActionListener(new ButtonListener());
        helpButton.addActionListener(new ButtonListener());

        upper.add(titleLabel, gbc);

        lowerMid.add(playButton);
        lowerMid.add(helpButton);
        lowerRight.add(playerNumberLabel);
        lowerRight.add(playerNumbersComboBox);

        lower.add(lowerLeft);
        lower.add(lowerMid);
        lower.add(lowerRight);

        add(upper);
        add(lower);

        setSize(800, 600);
        setVisible(true);
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if(choice.equals("Play")) {

            }
            else if(choice.equals("Help")) {

            }
        }
    }



}