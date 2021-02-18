import java.awt.*;


public abstract class Figure2D extends Figure {
	private Color fillColor;


	public Figure2D(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Color getFillColor(){
		return fillColor;
	}

	public void setFillColor(Color color){
		this.fillColor = color;
	}

}