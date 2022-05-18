package graphic;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MoveFrame extends JFrame{

    private JButton upButton;
    private JButton downButton;
    private JButton rightButton;
    private JButton leftButton;

    public MoveFrame() {
        super("Move");

        setLayout(new BorderLayout());

        upButton = new JButton("Up");
        downButton = new JButton("Down");
        rightButton = new JButton("Right");
        leftButton = new JButton("Left");

        this.add(upButton, BorderLayout.PAGE_START);
        add(leftButton, BorderLayout.LINE_START);
        add(rightButton, BorderLayout.LINE_END);
        add(downButton, BorderLayout.PAGE_END);


        setSize(300, 300);
        setResizable(false);
        setVisible(true);

    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String choice = e.getActionCommand();
            //todo
        }
    }

}