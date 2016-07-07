import java.awt.Point;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GameBackGround extends JPanel implements SnakeActListener {
	
	
	//记录当前蛋的坐标
	private Point eggLocation;
	
	private Egg egg;
	
	public Snake snake;
	
	private int mgridSideLength;
	
	final static private int mgridNumberPerSide = 50;
	final static private int msideLength = 700;
	final static private int moveSpeed = 100;
	
	Timer timer = new Timer();
	
	private Yard yard;
	
	
	public GameBackGround() {

		mgridSideLength = msideLength/mgridNumberPerSide;
		
		yard = new Yard(msideLength, mgridNumberPerSide);
		this.setLayout(null);
		this.setSize(msideLength,msideLength);
		this.add(yard);
		
		addEgg();
		initSnakeBody();
		
		snake.snakeMove();
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (snake != null) {
					snake.snakeMove();
				}
				
			}
		}, moveSpeed, moveSpeed);
	}
	
	
	private void initSnakeBody() {
		snake = new Snake(mgridSideLength,new Point(10, 10),yard);
		snake.setEatListener(this);
		
	}
	
	public void eatEgg(Point snakeHeadLocation){
		
		if (snakeHeadLocation.equals(eggLocation)) {
			
			addEgg();
			snake.growUp();
		}
	}
	
	@Override
	public void snakeMoveState(ArrayList<SnakeBody> snakeBodies) {
		// TODO Auto-generated method stub
		Point snakeHeadLocation = snakeBodies.get(0).getLocation();
		if (snakeHeadLocation.x < 0 ||snakeHeadLocation.y < 0
				||snakeHeadLocation.x > msideLength || snakeHeadLocation.y > msideLength) {
			gameOver();
		}
		
		for (SnakeBody snakeBody : snakeBodies) {
			if (snakeBody.getLocation().equals(snakeHeadLocation)) {
				//gameOver();
			}
		}
	}
	
	private void gameOver() {
		timer.cancel();
	}
	
	private void addEgg() {
		
		int random_X = (int)(Math.random() * mgridNumberPerSide);
		int random_Y = (int)(Math.random() * mgridNumberPerSide);
		eggLocation = new Point(random_X * mgridSideLength, random_Y * mgridSideLength);
		
		if (egg == null) {	
			
			egg = new Egg(mgridSideLength);
			yard.add(egg);
		}
		egg.setLocation(eggLocation);
	}	
}
