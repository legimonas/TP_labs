import java.awt.*;

public class Rectangle extends Polygon {

	private Point pointB;

	public Rectangle(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(Graphics g){

	}

	public Color getFillColor(){
		return null;
	}

	public Point getPointB(){
		return pointB;
	}

	public void move(double offsetX, double offsetY){

	}

	public void setFillColor(Color color){
		super.setFillColor(color);
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}
}