import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MoveFrame extends JFrame{

    private JRadioButton c1Button;
    private JRadioButton c2Button;
    private JRadioButton c3Button;
    private JRadioButton c4Button;

    private ButtonGroup moveButtons;

    private GameScreen parent;

    public MoveFrame(ArrayList<Field> neighbours, GameScreen g) {
        super("Move");

        parent = g;

        setLayout(new BorderLayout());

        moveButtons = new ButtonGroup();

        JPanel downerPanel = new JPanel();
        downerPanel.setLayout(new FlowLayout());

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2,2));


        switch (neighbours.size()){
            case 2:
                c1Button = new JRadioButton(neighbours.get(0).getName());
                c2Button = new JRadioButton(neighbours.get(1).getName());
                c3Button = new JRadioButton("Border");
                c4Button = new JRadioButton("Border");
                break;
            case 3:
                c1Button = new JRadioButton(neighbours.get(0).getName());
                c2Button = new JRadioButton(neighbours.get(1).getName());
                c3Button = new JRadioButton(neighbours.get(2).getName());
                c4Button = new JRadioButton("Border");

                break;
            case 4:
                c1Button = new JRadioButton(neighbours.get(0).getName());
                c2Button = new JRadioButton(neighbours.get(1).getName());
                c3Button = new JRadioButton(neighbours.get(2).getName());
                c4Button = new JRadioButton(neighbours.get(3).getName());
                break;
            default:
                c1Button = new JRadioButton("Out of bounds");
                c2Button = new JRadioButton("Out of bounds");
                c3Button = new JRadioButton("Out of bounds");
                c4Button = new JRadioButton("Out of bounds");

        }

        moveButtons.add(c1Button);
        moveButtons.add(c2Button);
        moveButtons.add(c3Button);
        moveButtons.add(c4Button);


        buttonsPanel.add(c1Button);
        buttonsPanel.add(c2Button);
        buttonsPanel.add(c3Button);
        buttonsPanel.add(c4Button);


        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ButtonListener());
        cancelButton.addActionListener(new ButtonListener());

        downerPanel.add(okButton);
        downerPanel.add(cancelButton);

        add(buttonsPanel, BorderLayout.CENTER);
        add(downerPanel, BorderLayout.PAGE_END);

        setSize(300, 300);
        setResizable(true);
        setVisible(true);

    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            if(choice.equals("Ok")) {
                if (c1Button.isSelected()){
                    parent.MoveCall(c1Button.getText());
                }

            }
            else if(choice.equals("Cancel")) {
                dispose();
            }
        }
    }

}