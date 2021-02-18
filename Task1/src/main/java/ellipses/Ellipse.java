package ellipses;

import figures.Figure2D;

import java.awt.*;

public class Ellipse extends Figure2D {

	private Point pointA;
	private Point pointB;

	public Ellipse(){
		super();
		this.pointA = new Point(0,0);
		this.pointB = new Point(0,0);
	}

	public Ellipse(Point pointA, Point pointB) {
		this.pointA = pointA;
		this.pointB = pointB;
	}

	public Ellipse(Color fillColor, Point pointA, Point pointB) {
		super(fillColor);
		this.pointA = pointA;
		this.pointB = pointB;
	}

	public Ellipse(Point location, Color lineColor, Color fillColor, Point pointA, Point pointB) {
		super(location, lineColor, fillColor);
		this.pointA = pointA;
		this.pointB = pointB;
	}

	public void draw(Graphics g){

	}

	@Override
	public void move(int offsetX, int offsetY) {

	}

	public Point getPointA(){
		return pointA;
	}

	public Point getPointB(){
		return pointB;
	}

}