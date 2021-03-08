package ellipses;

import figures.Figure2D;

import java.awt.*;

import static figures.FiguresConstants.STANDARD_STROKE_WIDTH;

public class Ellipse extends Figure2D {

    private Point pointA;
    private Point pointB;

    public Ellipse() {
        super();
        this.pointA = new Point(0, 0);
        this.pointB = new Point(0, 0);
    }

    public Ellipse(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.location = new Point(0, 0);
        location.x = (pointA.x + pointB.x) / 2;
        location.y = (pointA.y + pointB.y) / 2;
    }

    public Ellipse(Point pointA, Point pointB, Color fillColor) {
        super(fillColor);
        this.pointA = pointA;
        this.pointB = pointB;
        this.location = new Point(0, 0);
        location.x = (pointA.x + pointB.x) / 2;
        location.y = (pointA.y + pointB.y) / 2;
    }

    public Ellipse(Point pointA, Point pointB, Color borderColor, Color fillColor) {
        super(new Point((pointA.x + pointB.x) / 2, (pointA.y + pointB.y) / 2), borderColor, fillColor);
        this.pointA = pointA;
        this.pointB = pointB;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getFillColor());
        g2d.fillOval(getPointA().x, getPointA().y, Math.abs(getPointA().x - getPointB().x), Math.abs(getPointA().y - getPointB().y));
        g2d.setColor(getLineColor());
        g2d.drawOval(getPointA().x, getPointA().y, Math.abs(getPointA().x - getPointB().x), Math.abs(getPointA().y - getPointB().y));
    }

    @Override
    public void move(int offsetX, int offsetY) {
        super.move(offsetX, offsetY);
        pointA.x += offsetX;
        pointA.y += offsetY;
        pointB.x += offsetX;
        pointB.y += offsetY;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }
}