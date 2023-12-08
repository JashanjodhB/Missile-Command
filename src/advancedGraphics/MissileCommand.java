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

public class MissileCommand extends JPanel implements Runnable,MouseListener,MouseMotionListener{
private int mouse_x,mouse_y;

private ArrayList<missiles> ar;
private Satellite woah;
private ArrayList<CounterMissile> cmis;
private ArrayList<cities> cities;	
private int[] houseX,houseY;
	public MissileCommand ()
	{
		mouse_x=0;
		mouse_y=0;
		setBackground(Color.WHITE);
		ar=new ArrayList<missiles>();
		cities=new ArrayList<>();
		houseX= new int[] {200, 350, 450, 750, 900, 1000};
		houseY= new int[] {500, 500, 500, 490, 490, 490};
		for(int x=0;x<6;x++){
			cities.add(new cities(houseX[x], houseY[x],100,50));
		}
		for(int z=0; z<30;z++){
			ar.add(new missiles(0,0,0,2,2,0,0,false));
		}
		cmis=new ArrayList<>();
		woah = new Satellite(20, 70, 50, 50, 6);
		for(int x=0;x<10;x++){
			ar.get(x).setX((int)(Math.random()*1200));
			ar.get(x).setY(100);
			ar.get(x).setShow(true);
			ar.get(x).setHorzVelocity(1);
			ar.get(x).setVertVelocity(5);
		}
		addMouseListener(this);
		addMouseMotionListener(this);
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
		
		crosshair plus=new crosshair(mouse_x,mouse_y);
		plus.paint(window);

		for(int x=0;x<6;x++){
			cities city= new cities(houseX[x], houseY[x]);
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
				
			}
		}
		

			
		
	}

	






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
