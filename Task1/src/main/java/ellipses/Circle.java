package ellipses;

import java.awt.*;

public class Circle extends Ellipse {

    //Point B is unused
    //Location is center
    //Point A is some point
    public Circle() {

    }

    public Circle(Point location, Color lineColor, Color fillColor, Point pointA, Point pointB) {
        super(location, lineColor, fillColor, pointA, pointB);
    }

    private int calculateRadius(){
        Point p1 = getLocation();
        Point p2 = getPointA();
        return (int) Math.round(Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + p1.y - p2.y)*(p1.y - p2.y));
    }

    @Override
    protected Point getUpLeftCorner(){
        Point upLeftCorner = new Point(0,0);
        upLeftCorner.x = getLocation().x - calculateRadius();
        upLeftCorner.y = getLocation().y - calculateRadius();
        return upLeftCorner;
    }

    public void draw(Graphics g) {

    }

}