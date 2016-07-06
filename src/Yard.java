import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class Yard extends JPanel{
	
	//游戏背景属性
	private int msideLength;
	private int mgridSideLength;
	private int mgridNumberPerSide;
	
	public Yard(int sideLength,int gridNumberPerSide) {
		super();
		
		System.out.println(gridNumberPerSide);
		
		mgridNumberPerSide = gridNumberPerSide;
		msideLength = sideLength;
		
		mgridSideLength = msideLength/gridNumberPerSide;
		
		this.setSize(sideLength,sideLength);
		this.setLayout(null);
	}
	
	
	//外部调用类方法
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawYard(g);
	}
	
	
	private void drawYard(Graphics g) {
		//绘制垂直线
		for(int i = 0;i < mgridNumberPerSide+1;i++){
			g.drawLine(i * mgridSideLength, 0, i * mgridSideLength, msideLength);
			//绘制水平线
			for(int j = 0;j < mgridNumberPerSide+1;j++){
				g.drawLine(0, j * mgridSideLength, msideLength, j * mgridSideLength);
			}
		}
	}
}
