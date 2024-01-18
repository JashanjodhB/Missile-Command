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
        y=ye;
        x=xe; 
        w=wi;
        h=he;
        targetX=tarX;
        targetY=tarY;
        show=sh;
        vertVelocity=(int)(targetY-getY())/10;
        horzVelocity=(int)(targetX-getX())/10;
    }
   
    public missiles(int xe, int ye, int we, int he) {
        x=xe;
        y=ye;
        w=we;
        h=he;
    }

    public void paintComponent(Graphics window){
        window.setColor(Color.RED);
        window.fillRect(x, y, w, h);
    }
      public void move(){
        x+=horzVelocity;
        y+=vertVelocity;

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
    public void setCityX(int cx){
        targetX=cx;
    }
    public void setCityY(int cy){
        targetY=cy;
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

    public void inBounds(Graphics window){
        if(x<0 || x>1200 || y<0){
            show=false;
        }
        if(x<40 && x>0 && y>540){
            show= false;
        }
        if(x<150 && x>45 && y>510){
            show= false;
        }
        if(x<525 && x>150 && y>530){
            show= false;
        }
        if(x<680 && x>525 && y>500){
            show= false;
        }
        if(x<1090 && x>680 && y>530){
            show= false;
        }
        if(x<1200 && x>1090 && y>500){
            show= false;
        }
        if(!show){
            explosion ex = new explosion(x, y, true);
            ex.paintComponent(window);
        }
    }
    
}
