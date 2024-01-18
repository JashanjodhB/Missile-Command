package advancedGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;

import javax.management.timer.Timer;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.awt.MouseInfo;
import java.awt.Toolkit;
public class explosion extends JPanel {
    private int x,y;
    boolean show;
    public explosion(int ex,int ey,boolean sh){
        x=ex;
        y=ey;
        show=sh;
    }
    public void setShow(boolean n){
        show=n;
    }
    public void paint(Graphics window){
        if(show){
            window.setColor(Color.ORANGE);
            window.fillOval(x-30,y-30,90,90);
        }
    }
}
