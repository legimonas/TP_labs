package oneD;

import figures.Figure;
import figures.FiguresConstants;

import java.awt.*;


public class Section extends Figure {

    private Point secondPoint;

    public Section() {
        super();
        this.secondPoint = new Point(0, 0);
    }

    public Section(Point secondPoint) {
        super(new Point(0, 0), FiguresConstants.STANDARD_COLOR);
        this.secondPoint = secondPoint;
    }

    public Section(Point firstPoint, Point secondPoint) {
        super(firstPoint, FiguresConstants.STANDARD_COLOR);
        this.secondPoint = secondPoint;
    }

    public Section(Point firstPoint, Point secondPoint, Color lineColor) {
        super(firstPoint, lineColor);
        this.secondPoint = secondPoint;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.lineColor);
        g2d.drawLine(location.x, location.y, secondPoint.x, secondPoint.y);
    }

    @Override
    public void move(int offsetX, int offsetY) {
        super.move(offsetX, offsetY);
        secondPoint.move(offsetX, offsetY);
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point secondPoint) {
        this.secondPoint = secondPoint;
    }
}