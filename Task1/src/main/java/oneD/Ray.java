package oneD;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Ray extends Section {

    public static final int EPS = 2;
    private static final int A = 0;
    private static final int B = 1;
    private static final int C = 2;

    private int width;
    private int height;

    // Location is origin of ray
    public Ray() {

    }

    public Ray(Point firstPoint, Point secondPoint) {
        super(firstPoint, secondPoint);
    }

    public Ray(Point firstPoint, Point secondPoint, Color lineColor) {
        super(firstPoint, secondPoint, lineColor);
    }

    protected Point getSecondPointForDrawing(int height, int weight) {
        List<Point> rectangle = getUserRect(height, weight);
        List<Integer> normal = getNormal(createLine(getLocation(), getSecondPoint()), getLocation());
        return intersectionPoints(rectangle, location, getSecondPoint())
                .stream()
                .filter(point -> isOneSideLine(normal, getSecondPoint(), point))
                .findAny()
                .orElse(null);
    }

    protected List<Point> getUserRect(int height, int weight) {
        List<Point> rectangle = new ArrayList<>();
        rectangle.add(new Point(0, 0));
        rectangle.add(new Point(weight, 0));
        rectangle.add(new Point(weight, height));
        rectangle.add(new Point(0, height));
        return rectangle;
    }


    List<Integer> createLine(Point p1, Point p2) {
        List<Integer> line = new ArrayList<>();
        line.add(A(p1, p2));
        line.add(B(p1, p2));
        line.add(C(p1, p2));
        return line;
    }

    protected Point intersectionPoint(Point p1, Point p2, Point p3, Point p4) {
        List<Integer> line1 = createLine(p1, p2);
        List<Integer> line2 = createLine(p3, p4);
        int A1 = line1.get(A);
        int B1 = line1.get(B);
        int C1 = line1.get(C);
        int A2 = line2.get(A);
        int B2 = line2.get(B);
        int C2 = line2.get(C);

        int d = A1 * B2 - B1 * A2;
        Point result;
        if (d != 0) {
            double dx = -C1 * B2 + B1 * C2;
            double dy = -A1 * C2 + C1 * A2;
            result = new Point((int) Math.round(dx / d), (int) Math.round(dy / d));
        } else {
            throw new ParallelException();
        }
        return result;
    }


    private int A(Point p1, Point p2) {
        return p2.y - p1.y;
    }

    private int B(Point p1, Point p2) {
        return p1.x - p2.x;
    }

    private int C(Point p1, Point p2) {
        return p1.y * (p2.x - p1.x) - p1.x * (p2.y - p1.y);
    }

    private List<Integer> getNormal(List<Integer> line, Point p1) {
        List<Integer> normal = new ArrayList<>();
        normal.add(-line.get(B));
        normal.add(line.get(A));
        normal.add(line.get(B) * p1.x - line.get(A) * p1.y);
        return normal;
    }

    protected boolean isOneSideLine(List<Integer> line, Point p1, Point p2) {
        return getSignum(line, p1) == getSignum(line, p2);
    }

    private int getSignum(List<Integer> normal, Point p1) {
        return Integer.signum(normal.get(A) * p1.x + normal.get(B) * p1.y + normal.get(C));
    }


    protected List<Point> intersectionPoints(List<Point> rect, Point p1, Point p2) {
        List<Point> result = new ArrayList<>();
        rect.add(rect.get(0));
        for (int i = 0; i < 4; i++) {
            try {
                result.add(intersectionPoint(p1, p2, rect.get(i), rect.get(i + 1)));
            } catch (ParallelException ignored) {

            }
        }
        rect.remove(rect.size() - 1);
        return result;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(lineColor);
        Point secondPoint = getSecondPointForDrawing(height, width);
        if (secondPoint != null) {
            g2d.drawLine(location.x, location.y, secondPoint.x, secondPoint.y);
        }
    }

    @Override
    public void move(int offsetX, int offsetY) {
        super.move(offsetX, offsetY);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}