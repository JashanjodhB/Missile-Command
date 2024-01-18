package advancedGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Toolkit;
public class cities extends missiles {
    public cities(int ex,int ey,int we,int he){
        super(ex, ey,we,he);
    }

    public void paint(Graphics window){
        Graphics2D g2= (Graphics2D) window;
        Image citi=Toolkit.getDefaultToolkit().getImage("Cities.png"); 
        g2.drawImage(citi,getX()-50,getY(),getW(),getH(),this);
    }
    
}
