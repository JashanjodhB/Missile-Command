package advancedGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Plane extends JPanel {
    private int x,y,v;
    public Plane(int xi,int yi,int vi){
        x=xi;
        y=yi;
        v=vi;
    }
    public void move(){
        x+=v;
    }
    public void shoot(ArrayList<missiles> mis){
        mis.add(new missiles(v,x,y+30,2,2,800,800,true));
    }
    public void paint(Graphics window){
        Graphics2D g2= (Graphics2D) window;
        Image plane= Toolkit.getDefaultToolkit().getImage("bommerPlane-removebg-preview.png");
        g2.drawImage(plane,x,y,50,50,this);
    }
}
