package advancedGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Toolkit;
public class missiles extends JPanel {
    private int vertVelocity,horzVelocity,x,y,w,h,targetX,targetY;
    boolean show;
    missiles(int velocity, int xe,int ye,int wi,int he, int tarX,int tarY,boolean sh){
        vertVelocity=velocity;
        horzVelocity=velocity;
        y=ye;
        x=xe; 
        w=wi;
        h=he;
        targetX=tarX;
        targetY=tarY;
        show=sh;
    }
   
    public void paint(Graphics window){
        window.setColor(Color.RED);
        window.fillRect(x, y, w, h);
    }
    public void move(){
        y+=vertVelocity;
        x+=horzVelocity;
    }

    public void changeAngle(int level) {
        horzVelocity=(int)(Math.random()*10);
        vertVelocity=(int)(Math.random()*10);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
     public int getW(){
        return w;
    }
    public int getH(){
        return h;
    }
    public void setX(int xe){
        x=xe;
    }
     public void setY(int xe){
        y=xe;
    }
     public void setVertVelocity(int xe){
        vertVelocity=xe;
    }
     public void setHorzVelocity(int xe){
        horzVelocity=xe;
    }
     public void setShow(boolean xe){
        show=xe;
    }
    public boolean isShow(){
        return show;
    }

    
    public boolean intersects( missiles other ) {
        Rectangle one = new Rectangle(x, y, w, h);
        Rectangle two = new Rectangle(other.getX(),other.getY(),other.getW(),other.getH());
        if (one.intersects(two)) {
           return true;
        }
        return false;
      }
      
    public boolean splitMissile(){
        if(((int) (Math.random()*100)) >90){
            return true;
        }
        return false;
    }
    
}
