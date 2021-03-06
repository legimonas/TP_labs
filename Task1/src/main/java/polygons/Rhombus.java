package polygons;

import java.awt.*;

public class Rhombus extends Polygon {

    //PointA is center
    //PointB and PointC have different diagonals

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
        int dx = getDx(getPointB());
        int dy = getDy(getPointB());
        points.add(new Point(getPointA().x + dx, getPointA().y + dy));
        dx = getDx(getPointC());
        dy = getDy(getPointC());
        points.add(new Point(getPointA().x + dx, getPointA().y + dy));
        drawPolygon((Graphics2D) g);
    }

    private int getDx(Point point) {
        return Math.abs(getPointA().x - point.x);
    }

    private int getDy(Point point) {
        return Math.abs(getPointA().y - point.y);
    }


    private Point getPointA() {
        return location;
    }

    private Point getPointB() {
        return points.get(0);
    }

    private Point getPointC() {
        return points.get(1);
    }
}