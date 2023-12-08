package advancedGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.*;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Toolkit;
public class Satellite extends JPanel{
    private int x,y,w,h,v;
    public Satellite(int ex,int ey,int ew,int eh, int velocity){
        x=ex;
        y=ey;
        w=ew;
        h=eh;
        v=velocity;
    }
    public void paint(Graphics window){
        Graphics2D g2= (Graphics2D) window;
        Image satellite= Toolkit.getDefaultToolkit().getImage("Satellite.png");
        g2.drawImage(satellite,x,y,w,h,this);
    }
    public void move() {
        x+=v;
    }
}
