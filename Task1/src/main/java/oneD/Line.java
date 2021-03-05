package oneD;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line extends Ray {


    public Line(Point firstPoint, Point secondPoint) {
        super(firstPoint, secondPoint);
    }

    public Line(Point firstPoint, Point secondPoint, Color lineColor) {
        super(firstPoint, secondPoint, lineColor);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(lineColor);
        List<Point> points = getInRectPointsStream(clipRectToListRect(g2d)).collect(Collectors.toList());
        Point first = points.get(0);
        Point second = points.get(1);
        g2d.drawLine(first.x, first.y, second.x, second.y);
    }

    private List<Point> clipRectToListRect(Graphics g) {
        Rectangle rectangle = g.getClipBounds();
        List<Point> pointRect = new ArrayList<>();
        pointRect.add(new Point(rectangle.x, rectangle.y));
        pointRect.add(new Point(rectangle.x + rectangle.width, rectangle.y));
        pointRect.add(new Point(rectangle.x + rectangle.width, rectangle.y + rectangle.height));
        pointRect.add(new Point(rectangle.x, rectangle.y + rectangle.height));
        return pointRect;
    }
}