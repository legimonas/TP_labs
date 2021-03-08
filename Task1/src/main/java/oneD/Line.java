package oneD;

import java.awt.*;
import java.util.List;

public class Line extends Ray {


    public Line(Point firstPoint, Point secondPoint) {
        super(firstPoint, secondPoint);
    }

    public Line(Point firstPoint, Point secondPoint, Color lineColor) {
        super(firstPoint, secondPoint, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(lineColor);
        List<Point> points = intersectionPoints(getUserRect(getHeight(), getWidth()), location, getSecondPoint());
        if (points.size() != 0 && points.size() != 1) {
            Point first = points.get(0);
            Point second = points.get(1);
            if (first != null && second != null) {
                g2d.drawLine(first.x, first.y, second.x, second.y);
            }
        }
    }
}