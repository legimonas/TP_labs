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
		this.location = new Point(0, 0);
		location.x = (pointA.x + pointB.x) / 2;
		location.y = (pointA.y + pointB.y) / 2;
	}

	public Ellipse(Point pointA, Point pointB, Color fillColor) {
		super(fillColor);
		this.pointA = pointA;
		this.pointB = pointB;
		this.location = new Point(0, 0);
		location.x = (pointA.x + pointB.x) / 2;
		location.y = (pointA.y + pointB.y) / 2;
	}

	public Ellipse(Point pointA, Point pointB, Color borderColor, Color fillColor){
		super(new Point((pointA.x + pointB.x) / 2, (pointA.y + pointB.y) / 2),borderColor, fillColor);
		this.pointA = pointA;
		this.pointB = pointB;

	}


	public void draw(Graphics g){
		g.drawOval(pointA.x, pointB.y, pointB.x - pointA.x, pointB.y - pointA.y);
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