import java.awt.*;

public class RegularPolygon extends Polygon {

    private int amountOfSides;

    public RegularPolygon() {

    }

    public void draw(Graphics g) {

    }

    public void setAmountOfSides(int amount) {
		this.amountOfSides = amount;
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public int getAmountOfSides() {
        return amountOfSides;
    }

    public Color getFillColor() {
        return super.getFillColor();
    }

    public void setFillColor(Color color) {
        super.setFillColor(color);
    }

}