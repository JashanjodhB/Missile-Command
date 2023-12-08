package advancedGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Toolkit;
public class cities extends JPanel {
    private int x,y;
    public cities(int ex,int ey){
        x=ex;
        y=ey;
    }
    public void paint(Graphics window){
        Graphics2D g2= (Graphics2D) window;
        Image citi=Toolkit.getDefaultToolkit().getImage("Cities.png"); 
        g2.drawImage(citi,x-50,y,100,50,this);
    }
    
}
