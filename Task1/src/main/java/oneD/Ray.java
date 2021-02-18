package oneD;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Ray extends Section {

    public static final int EPS = 5;

    // Location is origin of ray
    public Ray() {
        super();
    }

    protected int A(Point p1, Point p2) {
        return p2.y - p1.y;
    }

    protected int B(Point p1, Point p2) {
        return p1.x - p2.x;
    }

    protected int C(Point p1, Point p2) {
        return p1.y * (p2.x - p1.x) - p1.x * (p2.y - p1.y);
    }

    protected Point intersectionPoint(int A1, int B1, int C1, int A2, int B2, int C2) {
        int d = A1 * B2 - B1 * A2;
        Point result = null;
        if (d != 0) {
            int dx = -C1 * B2 + B1 * C2;
            int dy = -A1 * C2 + C1 * A2;
            result = new Point(dx / d, dy / d);
        } else {
            //TODO Exception;
        }
        return result;
    }

    protected Point getSecondPointForDrawing(int height, int weight) {
        Point result = null;
        List<Point> rectangle = getUserRect(height, weight);
        return result;
    }

    private boolean pointInRect(List<Point> rectangle, Point p) {
        return p.y >= rectangle.get(0).y - EPS
                && p.y <= rectangle.get(3).y + EPS
                && p.x >= (rectangle.get(0).x - EPS)
                && p.x <= rectangle.get(3).x + EPS;

    }

    private List<Point> getUserRect(int height, int weight) {
        List<Point> rectangle = new ArrayList<>();
        rectangle.add(new Point(0, 0));
        rectangle.add(new Point(weight, 0));
        rectangle.add(new Point(weight, height));
        rectangle.add(new Point(0, height));
        return rectangle;
    }

    public void draw(Graphics g) {

    }

}