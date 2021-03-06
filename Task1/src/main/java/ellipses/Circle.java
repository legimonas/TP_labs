package ellipses;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle(Point location, Point sidePoint) {
        int radius = getRadius(location, sidePoint);
        this.setPointA(new Point(location.x - radius, location.y - radius));
        this.setPointB(new Point(location.x + radius, location.y + radius));
        this.location = location;
    }

    public Circle(Point location, Point sidePoint, Color fillColor) {
        this(location, sidePoint);
        this.setFillColor(fillColor);
    }

    public Circle(Point location, Point sidePoint, Color borderColor, Color fillColor) {
        this(location, sidePoint, fillColor);
        this.setLineColor(borderColor);
    }

    private int getRadius(Point location, Point sidePoint) {
        return (int)Math.sqrt((location.x - sidePoint.x) * (location.x - sidePoint.x) + (location.y - sidePoint.y) * (location.y - sidePoint.y));
    }


}