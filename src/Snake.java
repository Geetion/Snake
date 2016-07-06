import java.awt.Color;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Snake extends Panel implements KeyListener {
	
	private Color mcolor = Color.black;
	
	private int msnakeLength = 3;
	
	public enum SnakeMoveDirection{
		South,West,North,East 
	}
	
	private SnakeMoveDirection mcurSnakeMoveDirection = SnakeMoveDirection.East;
	
	//记录蛇体每部分的panel
	private ArrayList<Panel> msnakeGrids = new ArrayList<>();
	
	private int mgridSideLength;
	
	public Snake(int gridSideLength,Point coordinate,JPanel yard) {
		super();
		for(int i = 0;i < msnakeLength; i++ ){
			
			Panel snakeBody = new Panel();
			snakeBody.setBackground(Color.black);
			snakeBody.setSize(gridSideLength, gridSideLength);
			
			int snakeBody_X = (coordinate.x + i) * gridSideLength;
			int snakeBody_Y = coordinate.y * gridSideLength;
			snakeBody.setLocation(snakeBody_X, snakeBody_Y);
			yard.add(snakeBody);
			
			msnakeGrids.add(snakeBody);
		}
		mgridSideLength = gridSideLength;
	}
	
	public void eatFood(Point curEggCoordinate) {
		
		Point snakeHeadLocation = msnakeGrids.get(0).getLocation();
		if (snakeHeadLocation == curEggCoordinate) {
		}
	}
	
	public void snakeMove() {
		Panel snakeHead = msnakeGrids.get(0);
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
		for(int i = 1;i < msnakeGrids.size();i++){
			Point newLocation = msnakeGrids.get(i - 1).getLocation();
			msnakeGrids.get(i).setLocation(newLocation);
		}
	}
	
	
	public void keyPressed(KeyEvent e){
		System.out.print(e.getKeyCode());
		
		switch (e.getKeyCode()) {
		case 38:		//键盘上
		case 87:		//键盘W
			mcurSnakeMoveDirection = SnakeMoveDirection.North;
			break;
		case 40:		//键盘下
		case 83:		//键盘S
			mcurSnakeMoveDirection = SnakeMoveDirection.South;
			break;
		case 37:		//键盘左
		case 65:		//键盘A
			mcurSnakeMoveDirection = SnakeMoveDirection.West;
			break;
		case 39:		//键盘右
		case 68:		//键盘D
			mcurSnakeMoveDirection = SnakeMoveDirection.East;
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
