import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GameBackGround extends JPanel {
	
	
	//记录当前蛋的坐标
	static private Point eggLocation;
	
	private Egg egg;
	
	public Snake snake;
	
	private int mgridSideLength;
	
	static private int mgridNumberPerSide = 50;
	static private int msideLength = 700;
	
	private Yard yard;
	
	
	public GameBackGround() {
		// TODO Auto-generated constructor stub
		mgridSideLength = msideLength/mgridNumberPerSide;
		
		yard = new Yard(msideLength, mgridNumberPerSide);
		this.setLayout(null);
		this.setSize(msideLength,msideLength);
		this.add(yard);
		
		addEgg();
		initSnakeBody();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (snake != null) {
					snake.snakeMove();
				}
				
			}
		}, 70, 70);;
	}
	
	
	private void initSnakeBody() {
		snake = new Snake(mgridSideLength,new Point(10, 10),yard);
		
	}
	
	//内部类方法
	private void addEgg() {
		if (egg == null) {
			int random_X = (int)(Math.random() * mgridNumberPerSide);
			int random_Y = (int)(Math.random() * mgridNumberPerSide);
			eggLocation = new Point(random_X * mgridSideLength, random_Y * mgridSideLength);
			egg = new Egg(mgridSideLength);
			egg.setLocation(eggLocation);
			yard.add(egg);
		}
	}	

}
