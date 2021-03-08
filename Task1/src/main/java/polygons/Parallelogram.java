package polygons;

import java.awt.*;

public class Parallelogram extends Polygon {

    //PointA is center
    //PointB and PointC have different diagonals

    public Parallelogram(Point pointA, Point pointB, Point pointC) {
        super(pointA, pointB, pointC);
    }

    public Parallelogram(Point pointA, Point pointB, Point pointC, Color borderColor) {
        super(borderColor, pointA, pointB, pointC);
    }

    public Parallelogram(Point pointA, Point pointB, Point pointC, Color borderColor, Color fillColor) {
        super(fillColor, borderColor, pointA, pointB, pointC);
    }

    @Override
    public void draw(Graphics g) {
        setStrokeWidth((Graphics2D)g);
        int[][] vertexes = new int[2][4];
        vertexes[0][0] = getPointA().x;
        vertexes[1][0] = getPointA().y;
        vertexes[0][1] = getPointB().x;
        vertexes[1][1] = getPointB().y;

        int dx = getPointCenter().x - getPointA().x;
        int dy = getPointCenter().y - getPointA().y;
        vertexes[0][2] = getPointCenter().x + dx;
        vertexes[1][2] = getPointCenter().y + dy;

        dx = getPointCenter().x - getPointB().x;
        dy = getPointCenter().y - getPointB().y;
        vertexes[0][3] = getPointCenter().x + dx;
        vertexes[1][3] = getPointCenter().y + dy;

        drawPolygon((Graphics2D) g, vertexes[0], vertexes[1]);
    }


    private int getDy(Point point) {
        return Math.abs(getPointCenter().y - point.y);
    }


    private Point getPointCenter() {
        return location;
    }

    private Point getPointA() {
        return points.get(0);
    }

    private Point getPointB() {
        return points.get(1);
    }
}