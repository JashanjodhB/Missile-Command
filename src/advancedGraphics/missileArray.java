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
public class missileArray extends JPanel {
    private ArrayList<missiles> array;
    private int level;
    public missileArray(int l){
        array= new ArrayList<missiles>();
        level=l;
    }
    public missileArray(int l,ArrayList<missiles> a){
        array=a;
        level=l;
    }
   public void addMissile(int v,int x,int y,int w,int h,int tarX,int tarY){
        array.add(new missiles(v,x,y,w,h,tarX,tarY,false));
    }


    public void removeMissile(missiles m){
        array.remove(m);
    }


    public void splitMissile(){
        missiles m=array.get((int)(Math.random()*array.size()));
        if(((int) (Math.random()*100)) >90){
            array.get(array.indexOf(m)).changeAngle(level);
            this.addMissile(1, m.getX(), m.getY(),2,2,(int)(Math.random()*1200),500);
        }
       
    }


    public void Ppaint(Graphics window){
        for(missiles m: array){
            m.paint(window);
        }
    }


    public void Mmove(){
        for(missiles m: array){
            m.move();
        }
    }


    public ArrayList<missiles> returnArray(){
        return array;
    }
}
