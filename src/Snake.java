import java.awt.Color;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

interface SnakeActListener{
	public void eatEgg(Point snakeHeadLocation);
	public void snakeMoveState(ArrayList<SnakeBody> snakeBodies);
}

public class Snake extends Panel implements KeyListener {
	
	private int msnakeLength = 5;
	
	public SnakeActListener msnakeActListener;
	
	public enum SnakeMoveDirection{
		South,West,North,East 
	}
	
	private SnakeMoveDirection mcurSnakeMoveDirection = SnakeMoveDirection.East;
	
	//记录蛇体每部分的panel
	private ArrayList<SnakeBody> msnakeBodies = new ArrayList<>();
	
	private int mgridSideLength;
	
	private Yard myard;
	
	public Snake(int gridSideLength,Point coordinate,Yard yard) {
		super();
		myard = yard;
		for(int i = 0;i < msnakeLength; i++ ){
			
			SnakeBody snakeBody = new SnakeBody(gridSideLength);
			snakeBody.setBackground(Color.black);
			
			int snakeBody_X = (coordinate.x + i) * gridSideLength;
			int snakeBody_Y = coordinate.y * gridSideLength;
			snakeBody.setLocation(snakeBody_X, snakeBody_Y);
			yard.add(snakeBody);
			
			msnakeBodies.add(snakeBody);
		}
		mgridSideLength = gridSideLength;
	}
	
	public void setEatListener(SnakeActListener eatingListner) {
		msnakeActListener = eatingListner;
	}
	
	//外部调用控制蛇移动
	public void snakeMove() {
		
		SnakeBody snakeHead = msnakeBodies.get(0);
		Point snakeHeadLocation = snakeHead.getLocation();
		
		switch (mcurSnakeMoveDirection) {
		case South:
			snakeHead.setLocation(snakeHeadLocation.x, snakeHeadLocation.y + mgridSideLength);
			break;
		case North:
			snakeHead.setLocation(snakeHeadLocation.x, snakeHeadLocation.y - mgridSideLength);
			break;
		case East:
			snakeHead.setLocation(snakeHeadLocation.x + mgridSideLength, snakeHeadLocation.y);
			break;
		case West:
			snakeHead.setLocation(snakeHeadLocation.x - mgridSideLength, snakeHeadLocation.y);
			break;
		}

		for(int i = msnakeBodies.size() - 1;i >= 1;i--){
			Point newLocation = msnakeBodies.get(i - 1).getLocation();
			msnakeBodies.get(i).setLocation(newLocation);
		}
		
		if (msnakeActListener != null) {
			msnakeActListener.eatEgg(snakeHeadLocation);
			msnakeActListener.snakeMoveState(msnakeBodies);
		}
	}
	
	//外部调用使蛇长大
	public void growUp() {
		Point snakeTailLocation = msnakeBodies.get(msnakeLength - 1).getLocation();
		
		SnakeBody snakeBody = new SnakeBody(mgridSideLength);
		snakeBody.setLocation(snakeTailLocation);
		msnakeBodies.add(snakeBody);
		myard.add(snakeBody);
		
	}
	
	//键盘事件监听
	public void keyPressed(KeyEvent e){
		System.out.print(e.getKeyCode());
		
		switch (e.getKeyCode()) {
		case 38:		//键盘上
		case 87:		//键盘W
			if(mcurSnakeMoveDirection != SnakeMoveDirection.South)mcurSnakeMoveDirection = SnakeMoveDirection.North;
			break;
		case 40:		//键盘下
		case 83:		//键盘S
			if(mcurSnakeMoveDirection != SnakeMoveDirection.North)mcurSnakeMoveDirection = SnakeMoveDirection.South;
			break;
		case 37:		//键盘左
		case 65:		//键盘A
			if(mcurSnakeMoveDirection != SnakeMoveDirection.East)mcurSnakeMoveDirection = SnakeMoveDirection.West;
			break;
		case 39:		//键盘右
		case 68:		//键盘D
			if(mcurSnakeMoveDirection != SnakeMoveDirection.West)mcurSnakeMoveDirection = SnakeMoveDirection.East;
			break;
		default:
			break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	
	public void keyTyped(KeyEvent e){
	}
}
