package oneD;

import java.awt.*;

public class Line extends Ray {

    public Line(Point secondPoint) {
        super(secondPoint);
    }

    public Line(Point firstPoint, Point secondPoint) {
        super(firstPoint, secondPoint);
    }

    public Line(Point firstPoint, Point secondPoint, Color lineColor) {
        super(firstPoint, secondPoint, lineColor);
    }

    @Override
    public void draw(Graphics g) {

    }

}