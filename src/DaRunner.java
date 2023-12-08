
import javax.swing.JFrame;

import advancedGraphics.MissileCommand;

public class DaRunner extends JFrame
{
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 600;

	public DaRunner()
	{
		super("Da Runner");

		setSize(WIDTH,HEIGHT);


		getContentPane().add(new MissileCommand() );

		setVisible(true);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		DaRunner run = new DaRunner();
	}
}