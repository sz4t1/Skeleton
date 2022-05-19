package com.company;

import javax.swing.*;
import java.awt.*;

public class DrawField extends JLabel {
    private Field field;
    private int x;

    public DrawField(int _x){
        x=_x;
        setOpaque(true);
        setBackground(Color.lightGray);
    }
    public void paintComponent(Graphics g){
        /*Color[] colors= new Color[4];
        int colorNums=field.getVirologists.getSize();
        for(int i =0; i<colorNums ;i++)
            switch(field.getVirologists.get(i).getName){
                case "Virologist1":{ colors[i]=Color.blue; break;}
                case "Virologist2":{ colors[i]=Color.ORANGE; break;}
                case "Virologist3":{ colors[i]=Color.CYAN; break;}
                case "Virologist4":{ colors[i]=Color.PINK; break;}
            }
            */
        super.paintComponent(g);
        if(/*field.getVirologists.getsize()*/x>=1) {
            g.setColor(Color.black);
            g.drawOval(24, 72, 20, 20);
            g.setColor(/*colors[0]*/Color.blue);
            g.fillOval(24, 72, 20, 20);
        }
        if(/*field.getVirologists.getsize()*/x>=2) {
            g.setColor(Color.black);
            g.drawOval(24, 24, 20, 20);
            g.setColor(/*colors[1]*/Color.ORANGE);
            g.fillOval(24, 24, 20, 20);
        }
        if(/*field.getVirologists.getsize()*/x>=3) {
            g.setColor(Color.black);
            g.drawOval(72, 24, 20, 20);
            g.setColor(/*colors[2]*/Color.CYAN);
            g.fillOval(72, 24, 20, 20);
        }
        if(/*field.getVirologists.getsize()*/x==4) {
            g.setColor(Color.black);
            g.drawOval(72, 72, 20, 20);
            g.setColor(/*colors[3]*/Color.PINK);
            g.fillOval(72, 72, 20, 20);
        }
    }
}
