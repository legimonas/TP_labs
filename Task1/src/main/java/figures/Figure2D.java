package figures;

import java.awt.*;

import static figures.FiguresConstants.STANDARD_COLOR;


public abstract class Figure2D extends Figure {
	private Color fillColor;

	public Figure2D(){
		super();
		this.fillColor = STANDARD_COLOR;
	}

	public Figure2D(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Figure2D(Point location, Color lineColor, Color fillColor) {
		super(location, lineColor);
		this.fillColor = fillColor;
	}

	public Color getFillColor(){
		return fillColor;
	}

	public void setFillColor(Color color){
		this.fillColor = color;
	}

}