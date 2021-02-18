package oneD;

import figures.Figure;

import java.awt.*;


public class Section extends Figure {

	private Point secondPoint;

	public Section(){
		super();
		this.secondPoint = new Point(0,0);
	}

	public Section(Point secondPoint) {
		this.secondPoint = secondPoint;
	}

	public Section(Point location, Color lineColor, Point secondPoint) {
		super(location, lineColor);
		this.secondPoint = secondPoint;
	}

	//You can easy draw section
	@Override
	public void draw(Graphics g){

	}

	public Point getSecondPoint(){
		return secondPoint;
	}
	@Override
	public void move(int offsetX, int offsetY){
		super.move(offsetX,offsetY);
		secondPoint.move(offsetX,offsetY);
	}

	public void setSecondPoint(Point secondPoint) {
		this.secondPoint = secondPoint;
	}
}