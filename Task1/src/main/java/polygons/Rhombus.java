package polygons;

import java.awt.*;

public class Rhombus extends Polygon {

    public Rhombus(Point pointA, Point pointB, Point pointC) {
        super(pointA, pointB, pointC);
    }

    public Rhombus(Color borderColor, Point pointA, Point pointB, Point pointC) {
        super(borderColor, pointA, pointB, pointC);
    }

    public Rhombus(Color borderColor, Color fillColor, Point pointA, Point pointB, Point pointC) {
        super(borderColor, fillColor, pointA, pointB, pointC);
    }

    @Override
    public void draw(Graphics g) {

    }

}