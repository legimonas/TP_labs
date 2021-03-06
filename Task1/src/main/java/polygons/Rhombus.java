package polygons;

import java.awt.*;

public class Rhombus extends Parallelogram{
    public Rhombus(Point pointA, Point pointB, double relativeCenter) {
        super(getCenterByRelativeAlign(pointA, pointB, relativeCenter), pointA, pointB);
    }

    public Rhombus(Point pointA, Point pointB, double relativeCenter, Color borderColor) {
        super(getCenterByRelativeAlign(pointA, pointB, relativeCenter), pointA, pointB, borderColor);
    }

    public Rhombus(Point pointA, Point pointB, double relativeCenter, Color borderColor, Color fillColor) {
        super(getCenterByRelativeAlign(pointA, pointB, relativeCenter), pointA, pointB, borderColor, fillColor);
    }
    private static Point getCenterByRelativeAlign(Point pointA, Point pointB, double relative){
        if(relative >= 1 || relative <= 0){
            throw new IllegalArgumentException("relative allign should be in range (0, .. 1)");
        }
        double x0 = pointA.x + relative * (pointB.x - pointA.x);
        double y0 = pointA.y + (1 - relative) * (pointA.y - pointB.y);

        double a = (double) (pointB.y - pointA.y) / (pointB.x - pointA.x);
        double b = pointA.y - a * pointA.x;

        double norm = Math.sqrt(a * a + b * b);
        double normalizedA = a / norm;
        double normalizedB = b / norm;

        double gypLengthX = Math.abs(pointB.x - pointA.x);
        double c1X = relative * gypLengthX;
        double c2X = gypLengthX - c1X;

        double gypLengthY = Math.abs(pointB.y - pointA.y);
        double c1Y = relative * gypLengthY;
        double c2Y = gypLengthY - c1Y;

        double c1 = Math.sqrt(c1X * c1X + c1Y * c1Y);
        double c2 = Math.sqrt(c2X * c2X + c2Y * c2Y);
        double height = Math.sqrt(c1 * c2);

        return new Point((int) (height * normalizedA + x0), (int) (height * normalizedB + y0));
    }
}
