package polygons;

import figures.Figure2D;
import figures.FiguresConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static figures.FiguresConstants.STANDARD_STROKE_WIDTH;

public class Polygon extends Figure2D {

    protected List<Point> points;

    public Polygon() {
        points = new ArrayList<>();
    }

    public Polygon(List<Point> points) {
        super(points.get(0), FiguresConstants.STANDARD_COLOR, FiguresConstants.STANDARD_COLOR);
        this.points = points.subList(1, points.size());
    }

    public Polygon(Point... points) {
        super(points[0], FiguresConstants.STANDARD_COLOR, FiguresConstants.STANDARD_COLOR);
        this.points = new ArrayList<>(Arrays.asList(points).subList(1, points.length));
    }

    public Polygon(List<Point> points, Color borderColor, Color fillColor) {
        super(points.get(0), borderColor, fillColor);
        this.points = points.subList(1, points.size());
    }

    public Polygon(List<Point> points, Color borderColor) {
        super(points.get(0), borderColor, FiguresConstants.STANDARD_COLOR);
        this.points = points.subList(1, points.size());
    }

    public Polygon(Color fillColor, Color borderColor, Point... points) {
        super(points[0], borderColor, fillColor);
        this.points = new ArrayList<>(Arrays.asList(points).subList(1, points.length));
    }

    public Polygon(Color borderColor, Point... points) {
        super(points[0], borderColor, FiguresConstants.STANDARD_COLOR);
        this.points = new ArrayList<>(Arrays.asList(points).subList(1, points.length));
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        points.add(0, location);
        drawPolygon(
                g2d,
                points.stream().mapToInt(point -> point.x).toArray(),
                points.stream().mapToInt(point -> point.y).toArray()
        );
        points.remove(0);
    }

    protected void drawPolygon(Graphics2D g2d, int[] xPoints, int[] yPoints) {
        if(xPoints.length != yPoints.length){
            throw new IllegalArgumentException("dimension of xAxis does not match yAxis");
        }

        g2d.setColor(getFillColor());
        g2d.fillPolygon(xPoints, yPoints, xPoints.length);
        g2d.setColor(getLineColor());
        g2d.setStroke(new BasicStroke(STANDARD_STROKE_WIDTH));
        g2d.drawPolygon(xPoints, yPoints, yPoints.length);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public void move(int offsetX, int offsetY) {
        points.forEach(point -> point.move(offsetX, offsetY));
        location.move(offsetX, offsetY);
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

}