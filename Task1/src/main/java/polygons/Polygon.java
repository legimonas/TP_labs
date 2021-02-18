package polygons;

import figures.Figure2D;

import java.awt.*;
import java.util.List;

public class Polygon extends Figure2D {

	private List<Point> points;

	public Polygon(){

	}

	public void addPoint(Point point){
		points.add(point);
	}

	public void draw(Graphics g){

	}

	public Color getFillColor(){
		return super.getFillColor();
	}

	public List<Point> getPoints(){
		return points;
	}
	@Override
	public void move(int offsetX, int offsetY){
		points.forEach(point -> point.move(offsetX,offsetY));
	}

	public void setFillColor(Color color){
		super.setFillColor(color);
	}

	public void setPoints(List<Point> points){
		this.points = points;
	}

}