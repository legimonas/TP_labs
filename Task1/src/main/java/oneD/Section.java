package oneD;

import figures.Figure;
import figures.FiguresConstants;

import java.awt.*;


public class Section extends Figure {

	private Point secondPoint;

	public Section(){
		super();
		this.secondPoint = new Point(0,0);
	}

	public Section(Point secondPoint) {
		super(new Point(0, 0), FiguresConstants.STANDARD_COLOR);
		this.secondPoint = secondPoint;
	}

	public Section(Point firstPoint, Point secondPoint) {
		super(firstPoint, FiguresConstants.STANDARD_COLOR);
		this.secondPoint = secondPoint;
	}

	public Section(Point firstPoint, Point secondPoint, Color lineColor) {
		super(firstPoint, lineColor);
		this.secondPoint = secondPoint;
	}


	//You can easy draw section
	@Override
	public void draw(Graphics g){
		g.drawLine(location.x, location.y, secondPoint.x, secondPoint.y);
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