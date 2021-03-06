package polygons;

import java.awt.*;

import static figures.FiguresConstants.STANDARD_STROKE_WIDTH;

public class RegularPolygon extends Polygon {

    private int amountOfSides;

    public RegularPolygon(Point location, Point point, int amountOfSides) {
        super(location, point);
        this.amountOfSides = amountOfSides;
    }

    public RegularPolygon(Point location, Point point, int amountOfSides, Color borderColor) {
        super(borderColor, location, point);
        this.amountOfSides = amountOfSides;
    }

    public RegularPolygon(Point location, Point point, int amountOfSides, Color borderColor, Color fillColor) {
        super(fillColor, borderColor, location);
        this.amountOfSides = amountOfSides;
    }

    @Override
    public void draw(Graphics g) {
        double r = (int) Math.sqrt(Math.pow(getCenter().x - getSidePoint().x, 2) + Math.pow(getCenter().y - getSidePoint().y, 2));
        double phi = Math.acos(Math.abs(getSidePoint().x - getCenter().x) / r);
        int[] xPositions = new int[amountOfSides];
        int[] yPositions = new int[amountOfSides];
        for (int i = 0; i < amountOfSides; i++) {
            xPositions[i] = ((int) (getCenter().x + r * Math.cos(phi + Math.PI * 2 * i / amountOfSides)));
            yPositions[i] = ((int) (getCenter().y + r * Math.sin(phi + Math.PI * 2 * i / amountOfSides)));
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getFillColor());
        g2d.fillPolygon(xPositions, yPositions, xPositions.length);
        g2d.setColor(getLineColor());
        g2d.setStroke(new BasicStroke(STANDARD_STROKE_WIDTH));
        g2d.drawPolygon(xPositions, yPositions, xPositions.length);

    }

    private Point getCenter() {
        return location;
    }

    private Point getSidePoint() {
        return points.get(0);
    }

    public void setAmountOfSides(int amount) {
        this.amountOfSides = amount;
    }

    public int getAmountOfSides() {
        return amountOfSides;
    }

}