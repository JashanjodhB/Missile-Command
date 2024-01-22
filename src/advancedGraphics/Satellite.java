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
public class Satellite extends missiles{
    private int v;
    public Satellite(int ex,int ey,int ew,int eh, int velocity,boolean sh){
        super(ex,ey,ew,eh);
        v=velocity;
        setShow(sh);
    }
    public void paint(Graphics window){
        Graphics2D g2= (Graphics2D) window;
        Image satellite= Toolkit.getDefaultToolkit().getImage("Satellite.png");
        g2.drawImage(satellite,getX(),getY(),getW(),getH(),this);
    }
    public void move() {
        setX(getX()+v);
    }
    public void inBounds(Graphics window){
        if(getX()>1200){
            setShow(false);
        }
    }
}
