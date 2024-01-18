package advancedGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Toolkit;
public class crosshair extends MissileCommand {
    private int x,y;
    public crosshair(int ex, int ey){
        y= ey;
        x= ex;
    }
    
    public void paint(Graphics window){
        
        window.setColor(Color.RED);
        window.fillRect(x-3, y, 5, 2);
        window.fillRect(x, y-3,2, 5);
        window.fillRect(x+3, y, 5, 2);
        window.fillRect(x, y+3, 2, 5);
    }
}
