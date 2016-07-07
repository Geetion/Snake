import java.awt.Color;

import javax.swing.JPanel;

public class SnakeBody extends JPanel {
	
	private Color mcolor = Color.black;
	
	public SnakeBody(int bodySideLength) {
		// TODO Auto-generated constructor stub
		this.setSize(bodySideLength,bodySideLength);
		this.setBackground(mcolor);
	}
}
