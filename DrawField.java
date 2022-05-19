import javax.swing.*;
import java.awt.*;

public class DrawField extends JLabel {
    private Field field;
    public DrawField(){
        field= null;
        setOpaque(true);
        setBackground(Color.lightGray);
    }
    public void setFieldOnce(Field f){
        if (field==null) field=f;
    }
    public void paintComponent(Graphics g){
        Color[] colors= new Color[4];
        int colorNums=field.getVirologists().size();
        for(int i =0; i<colorNums ;i++)
            switch(field.getVirologists().get(i).GetName()){
                case "Virologist1":{ colors[i]=Color.blue; break;}
                case "Virologist2":{ colors[i]=Color.ORANGE; break;}
                case "Virologist3":{ colors[i]=Color.CYAN; break;}
                case "Virologist4":{ colors[i]=Color.PINK; break;}
            }

        super.paintComponent(g);
        if(field.getVirologists().size()>=1) {
            g.setColor(Color.black);
            g.drawOval(24, 72, 20, 20);
            g.setColor(colors[0]);
            g.fillOval(24, 72, 20, 20);
        }
        if(field.getVirologists().size()>=2) {
            g.setColor(Color.black);
            g.drawOval(24, 24, 20, 20);
            g.setColor(colors[1]);
            g.fillOval(24, 24, 20, 20);
        }
        if(field.getVirologists().size()>=3) {
            g.setColor(Color.black);
            g.drawOval(72, 24, 20, 20);
            g.setColor(colors[2]);
            g.fillOval(72, 24, 20, 20);
        }
        if(field.getVirologists().size()==4) {
            g.setColor(Color.black);
            g.drawOval(72, 72, 20, 20);
            g.setColor(colors[3]);
            g.fillOval(72, 72, 20, 20);
        }
    }
}
