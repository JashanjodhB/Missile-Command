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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
import java.awt.event.KeyListener;

public class MissileCommand extends JPanel implements Runnable,MouseListener,MouseMotionListener,KeyListener{
private int mouse_x,mouse_y;
private ArrayList<missiles> ar;
private Satellite woah;
private Plane plane;
private ArrayList<CounterMissile> cmis;
private ArrayList<cities> cities;	
private ArrayList<Integer> houseX,houseY;
	public MissileCommand ()
	{
		plane=new Plane(20,70,6);
		mouse_x=0;
		mouse_y=0;
		setBackground(Color.WHITE);
		ar=new ArrayList<missiles>();
		cities=new ArrayList<>();
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
		for(int x=0;x<6;x++){
			cities.add(new cities(houseX.get(x), houseY.get(x),100,50));
		}
		for(int z=0; z<30;z++){
			ar.add(new missiles(0,0,0,2,2,0,0,false));
		}
		cmis=new ArrayList<>();
		woah = new Satellite(20, 70, 50, 50, 6);
		for(int x=0;x<10;x++){
			int target=(int)(Math.random()*6);
			ar.get(x).setX((int)(Math.random()*1200));
			ar.get(x).setY(100);
			ar.get(x).setShow(true);
			ar.get(x).setHorzVelocity(2);
			ar.get(x).setVertVelocity(2);
			ar.get(x).setCityX(houseX.get(target));
			ar.get(x).setCityY(houseY.get(target));
		}
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener( this );
		setFocusable( true );
		new Thread(this).start();
	}

	public void paint( Graphics window )
	{
		
		window.setColor(Color.BLACK);
		window.fillRect( 0,0, 1200, 600);
		window.setColor(Color.WHITE);
		Graphics2D g2= (Graphics2D) window;
		Image back= Toolkit.getDefaultToolkit().getImage("background.png");
		g2.drawImage(back,0,0,1200,600,this);
		window.drawString("Mouse  coordinates " + "(" + MouseInfo.getPointerInfo().getLocation().x + "   " + MouseInfo.getPointerInfo().getLocation().y + ")", 250, 30 );	
		plane.paint(window);
		plane.move();
		if(Math.random()>.9){
			plane.shoot(ar);
		}
		crosshair plus=new crosshair(mouse_x,mouse_y);
		plus.paint(window);

		for(cities city:cities){
			city.paint(window);
		}
		for(CounterMissile c:cmis){
			c.paint(window);
			c.move();
		}
		woah.paint(window);
		woah.move();
		for(missiles m: ar){
			if(m.isShow()){
				m.paint(window);
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
					houseX.remove(c);
					houseY.remove(c);
				}
			}
		}
	}
	public void keyTyped(KeyEvent e) {}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 65) {
			cmis.add(new CounterMissile(2,90, 505, 4, 4,mouse_x,mouse_y,true));
		}
		if(e.getKeyCode() == 83) {
			cmis.add(new CounterMissile(2,600, 490, 4, 4,mouse_x,mouse_y,true));
		}
		if(e.getKeyCode() == 68) {
			cmis.add(new CounterMissile(2,1140, 505, 4, 4,mouse_x,mouse_y,true));
		}
	}
	public void keyReleased(KeyEvent e) {}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
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
