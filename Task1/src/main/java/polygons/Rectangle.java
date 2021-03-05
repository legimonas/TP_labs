package polygons;

import java.awt.*;

public class Rectangle extends Polygon {

	//TODO WHAT??? WHY????
	public Rectangle(Point pointA, Point pointB){
		super(pointA, pointB);
	}
	public Rectangle(Point pointA, Point pointB, Color borderColor){
		super(borderColor, pointA, pointB);
	}
	public Rectangle(Point pointA, Point pointB, Color borderColor, Color fillColor){
		super(fillColor, borderColor, pointA, pointB);
	}


	public void draw(Graphics g){

	}
	@Override
	public Color getFillColor(){
		return super.getFillColor();
	}

	public Point getPointB(){
		return this.points.get(1);
	}
	@Override
	public void move(int offsetX, int offsetY){

	}

	public void setFillColor(Color color){
		super.setFillColor(color);
	}

	public void setPointB(Point pointB) {
		this.points.set(1, pointB);
	}
}