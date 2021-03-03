package ellipses;

import figures.Figure2D;

import java.awt.*;

public class Ellipse extends Figure2D {

    private Point pointA;
    private Point pointB;
    //Point A and B MUST have one same coordinates with location
    //Point A and B are points on the ellipse
    //Point A and B must be on the different axes


    protected Point getUpLeftCorner() {
        Point upLeftCorner = new Point(0, 0);
        upLeftCorner.x = getLocation().x - getWidth() / 2;
        upLeftCorner.y = getLocation().y - getHeight() / 2;
        return upLeftCorner;
    }

    private int getHeight() {
        if (2 * Math.abs(pointA.y - getLocation().y) != 0) {
            return 2 * Math.abs(pointA.y - getLocation().y);
        }
        return 2 * Math.abs(pointB.y - getLocation().y);
    }

    private int getWidth() {
        if (2 * Math.abs(pointA.x - getLocation().x) != 0) {
            return 2 * Math.abs(pointA.x - getLocation().x);
        }
        return 2 * Math.abs(pointB.x - getLocation().x);
    }

    public Ellipse() {
        super();
        this.pointA = new Point(0, 0);
        this.pointB = new Point(0, 0);
    }

    public Ellipse(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Ellipse(Color fillColor, Point pointA, Point pointB) {
        super(fillColor);
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Ellipse(Point location, Color lineColor, Color fillColor, Point pointA, Point pointB) {
        super(location, lineColor, fillColor);
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public void draw(Graphics g) {

    }

    @Override
    public void move(int offsetX, int offsetY) {

    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }


}