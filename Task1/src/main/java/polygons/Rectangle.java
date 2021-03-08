package polygons;

import java.awt.*;

import static figures.FiguresConstants.STANDARD_STROKE_WIDTH;

public class Rectangle extends Polygon {

    //PointA -- left and top, PointB -- right and bottom

    public Rectangle(Point pointA, Point pointB) {
        super(pointA, pointB);
    }

    public Rectangle(Point pointA, Point pointB, Color borderColor) {
        super(borderColor, pointA, pointB);
    }

    public Rectangle(Point pointA, Point pointB, Color borderColor, Color fillColor) {
        super(fillColor, borderColor, pointA, pointB);
    }

    @Override
    public void draw(Graphics g) {
        setStrokeWidth((Graphics2D)g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getFillColor());
        g2d.fillRect(getPointA().x, getPointA().y, getWidth(), getHeight());
        g2d.setColor(getLineColor());
        g2d.setStroke(new BasicStroke(STANDARD_STROKE_WIDTH));
        g2d.drawRect(getPointA().x, getPointA().y, getWidth(), getHeight());
    }

    private int getHeight() {
        return Math.abs(getPointA().y - getPointB().y);
    }

    private int getWidth() {
        return Math.abs(getPointA().x - getPointB().x);
    }

    private Point getPointA() {
        return getLocation();
    }

    private Point getPointB() {
        return points.get(0);
    }


}