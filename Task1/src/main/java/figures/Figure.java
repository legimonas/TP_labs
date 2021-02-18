package figures;

import java.awt.*;

import static figures.FiguresConstants.STANDARD_COLOR;


public abstract class Figure {
	private Point location;
	private Color lineColor;

	public Figure(){
		this.location = new Point(0,0);
		this.lineColor = STANDARD_COLOR;
	}

	public Figure(Point location, Color lineColor) {
		this.location = location;
		this.lineColor = lineColor;
	}

	public abstract void draw(Graphics g);

	public Point getLocation(){
		return location;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public void move(int offsetX, int offsetY){
		location.move(offsetX,offsetY);
	}
}