package polygons;

import java.awt.*;

public class Rectangle extends Polygon {

	private Point pointB;
	//TODO WHAT??? WHY????
	public Rectangle(){

	}


	public void draw(Graphics g){

	}
	@Override
	public Color getFillColor(){
		return super.getFillColor();
	}

	public Point getPointB(){
		return pointB;
	}
	@Override
	public void move(int offsetX, int offsetY){

	}

	public void setFillColor(Color color){
		super.setFillColor(color);
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
}