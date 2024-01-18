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
public class CounterMissile extends missiles{
    private int vertVelocity,mouseX,mouseY,horzVelocity;
    private boolean left,explo;
    public CounterMissile(int v,int xe, int ye,int we, int he,int mx,int my,boolean tr) {
        super(xe, ye,we,he);
        mouseX=mx;
        mouseY=my;
        vertVelocity=(int)(mouseY-getY())/10;
        horzVelocity=(int)(mouseX-getX())/10;
        left=false;
        if(mouseX<getX()){
            left=true;
        }
        setShow(tr);
        explo=true;

    }
    public void paint(Graphics window){
        window.setColor(Color.BLUE);
        window.fillRect(getX(),getY(), getW(), getW());
    }
    public void move(){
        setX(getX()+horzVelocity);
        setY(getY()+vertVelocity);
    }
    public boolean intersects( missiles other ) {
        if(explo){
            Rectangle one = new Rectangle(getX(), getY() , 90,90);
            Rectangle two = new Rectangle(other.getX(),other.getY(),other.getW(),other.getH());
            if (one.intersects(two)) {
               explo=false;
                return true;
               
            }
            return false;
        }
        return false;
        
      }
      public void expShow(boolean s){
        explo=s;
      }
    public void IsInBounds(Graphics window){
        if(left && getX()<mouseX){
            show=false;
        }
        if(this.getY()<mouseY){
            show=false;
        }
        if(!left && getX()>mouseX){
            show=false;
        }
        if(!show){
            explosion ex = new explosion(getX(), getY(), true);
            ex.paint(window);
        }
        
    }
}
