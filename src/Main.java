import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;


public class Main{
	
	static int WIDTH = 700;
	static int HEIGHT = 750;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		GameBackGround gameBackGround = new  GameBackGround();
		gameBackGround.setSize(WIDTH,HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH,HEIGHT);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(gameBackGround);
		frame.addKeyListener(gameBackGround.snake);
	}	
}
