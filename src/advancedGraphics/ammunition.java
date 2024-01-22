package advancedGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Toolkit;
public class ammunition extends JPanel {
    private int x,y,w,h;
    public ammunition(int ex,int ey,int we,int he){
        x=ex;
        y=ey;
        w=we;
        h=he;
    }

    public void paint(Graphics window){
        Graphics2D g2= (Graphics2D) window;
        Image ammunition=Toolkit.getDefaultToolkit().getImage("CM.png"); 
        g2.drawImage(ammunition,x,y,w,h,this);
    }
    
}