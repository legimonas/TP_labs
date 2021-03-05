package polygons;

import figures.Figure2D;
import figures.FiguresConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        this.points = Arrays.asList(points).subList(1, points.length);
    }

    public Polygon(Color fillColor, Color borderColor, List<Point> points) {
        super(points.get(0), borderColor, fillColor);
        this.points = points.subList(1, points.size());
    }

    public Polygon(Color borderColor, List<Point> points) {
        super(points.get(0), borderColor, FiguresConstants.STANDARD_COLOR);
        this.points = points.subList(1, points.size());
    }

    public Polygon(Color fillColor, Color borderColor, Point... points) {
        super(points[0], borderColor, fillColor);
        this.points = Arrays.asList(points).subList(1, points.length);
    }

    public Polygon(Color borderColor, Point... points) {
        super(points[0], borderColor, FiguresConstants.STANDARD_COLOR);
        this.points = Arrays.asList(points).subList(1, points.length);
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    @Override
    public void draw(Graphics g) {

    }

    public Color getFillColor() {
        return super.getFillColor();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public void move(int offsetX, int offsetY) {
        points.forEach(point -> point.move(offsetX, offsetY));
    }

    public void setFillColor(Color color) {
        super.setFillColor(color);
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

}