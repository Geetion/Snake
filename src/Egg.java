import java.awt.Color;
import java.awt.Panel;
import java.awt.Point;

public class Egg extends Panel {

	private Color mcolor = Color.red;
	
	public Egg(int gridSideLength) {
		super();
		this.setBackground(mcolor);
		this.setSize(gridSideLength, gridSideLength);
	}
}
