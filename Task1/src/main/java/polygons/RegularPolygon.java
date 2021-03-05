package polygons;

import java.awt.*;

public class RegularPolygon extends Polygon {

    private int amountOfSides;

    public RegularPolygon(Point location, int amountOfSides) {
        super(location);
        this.amountOfSides = amountOfSides;
    }

    public RegularPolygon(Point location, int amountOfSides, Color borderColor) {
        super(borderColor, location);
        this.amountOfSides = amountOfSides;
    }

    public RegularPolygon(Point location, int amountOfSides, Color borderColor, Color fillColor) {
        super(fillColor, borderColor, location);
        this.amountOfSides = amountOfSides;
    }

    @Override
    public void draw(Graphics g) {

    }

    public void setAmountOfSides(int amount) {
        this.amountOfSides = amount;
    }


    public int getAmountOfSides() {
        return amountOfSides;
    }

    @Override
    public Color getFillColor() {
        return super.getFillColor();
    }

    @Override
    public void setFillColor(Color color) {
        super.setFillColor(color);
    }

}