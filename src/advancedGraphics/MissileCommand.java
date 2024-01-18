package advancedGraphics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.util.*;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
public class MissileCommand extends JPanel implements Runnable,MouseListener,MouseMotionListener,KeyListener{
private int mouse_x,mouse_y;
private ArrayList<missiles> ar;
private ArrayList<CounterMissile> cAr;
private ArrayList<Integer> houseX,houseY;
private ArrayList<cities> cities;
private int score;
	public MissileCommand ()
	{
		score=0;
		mouse_x=0;
		mouse_y=0;
		setBackground(Color.WHITE);
		int[] xCoord=new int[] {200, 350, 450, 750, 900, 1000};
		int[] yCoord=new int[] {500, 500, 500, 490, 490, 490};
		houseX= new ArrayList<>();
		houseY= new ArrayList<>();
		for(int x=0;x<xCoord.length;x++){
			houseX.add(xCoord[x]);
		}
		for(int y=0;y<yCoord.length;y++){
			houseY.add(yCoord[y]);
		}
		cities = new ArrayList<cities>();
		ar=new ArrayList<missiles>();
		for(int x=0;x<6;x++){
			cities.add(new cities(houseX.get(x), houseY.get(x),100,50));
		}
		for(int z=0; z<100;z++){
			ar.add(new missiles(0,0,0,2,2,0,0,false));
		}
		cAr= new ArrayList<CounterMissile>();
		
		
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
		addMouseMotionListener(this);
		new Thread(this).start();
	}
	
	public void paintComponent( Graphics window )
	{
		window.setColor(Color.BLACK);
		window.fillRect( 0,0, 1200, 600);
		window.setColor(Color.WHITE);
		Graphics2D g2= (Graphics2D) window;
		Image back= Toolkit.getDefaultToolkit().getImage("background.png");
		g2.drawImage(back,0,0,1200,600,this);
		window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );	
		
		crosshair plus=new crosshair(mouse_x,mouse_y);
		plus.paintComponent(window);
		
	
		for(cities c: cities){
			c.paintComponent(window);
		}
		
		
	
			
		for(int m=0;m<cAr.size();m++){
			if(cAr.get(m).isShow()){
				cAr.get(m).move();
				cAr.get(m).IsInBounds(window);
				cAr.get(m).paintComponent(window);
			}
			for(int c=0;c<ar.size();c++){
				if(cAr.get(m).isShow()|| ar.get(c).isShow()){
					if(cAr.get(m).intersects(ar.get(c))){
						score+=25;
						explosion ex = new explosion(cAr.get(m).getX(), cAr.get(m).getY(), true);
						ex.paintComponent(window);
						cAr.remove(m);
						ar.remove(c);
					}
				}
				
			}
		}
		for(missiles m: ar){
			if(m.isShow()){
				m.move();
				m.inBounds(window);
				m.paintComponent(window);
			}
			for(int c=0;c<cities.size();c++){
				if(m.intersects(cities.get(c))){
					m.setShow(false);
					explosion ex = new explosion(m.getX(), m.getY(), true);
            		ex.paintComponent(window);
					cities.remove(c);

				}
			}
			if(score>=1250&&cities.size()<6){
			score-=1250;
			for (int i = 0; i < 6; i++) {
				if(houseX.contains(houseX.get(i))){
				}
				else {
					cities.add(new cities(houseX.get(i),houseY.get(i);
					break;
				}
			}
		}
		splitMissile();
		if((Math.random()*1000)>950){
			int x=(int)(Math.random()*ar.size());
			if(!ar.get(x).isShow()){
				int target=(int)(Math.random()*6);
				ar.get(x).setX((int)(Math.random()*1200));
				ar.get(x).setY(100);
				ar.get(x).setShow(true);
				ar.get(x).setHorzVelocity(1);
				ar.get(x).setVertVelocity(5);
				ar.get(x).setCityX(houseX.get(target));
				ar.get(x).setCityY(houseY.get(target));
				x+=1;
			}
	   }
	}




	public void splitMissile(){
		missiles ah=ar.get((int)(Math.random()*ar.size()));
		if((((int)(Math.random()*1000))>900) && ah.isShow()){
			boolean z=true;
			for(missiles m:ar){
				if(!m.isShow() && z){
					int target=(int)(Math.random()*6);
					m.setX(ah.getX());
					m.setY(ah.getY());
					m.setShow(true);
					m.setHorzVelocity((int)(Math.random()*5));
					m.setVertVelocity((int)(Math.random()*10));
					m.setCityX(houseX.get(target));
					m.setCityY(houseY.get(target));
					z=false;
				}
			}
		}
	}
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 65) {
			cAr.add(new CounterMissile(2,90, 505, 4, 4,mouse_x,mouse_y,true));
		}
		if(e.getKeyCode() == 83) {
			cAr.add(new CounterMissile(2,600, 490, 4, 4,mouse_x,mouse_y,true));
		}
		if(e.getKeyCode() == 68) {
			cAr.add(new CounterMissile(2,1140, 505, 4, 4,mouse_x,mouse_y,true));
		}
	}
	public void keyReleased(KeyEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){
	}
	public void mouseDragged(MouseEvent e){}
	public void mouseMoved(MouseEvent e){
		mouse_x= e.getX();
		mouse_y= e.getY();
	}
	public void run()
	{
		try
		{
			while( true )
			{	
			
			   Thread.sleep(50);
			   repaint();
			}
		}
		catch( Exception e )
		{	
		}
	}

	
}
