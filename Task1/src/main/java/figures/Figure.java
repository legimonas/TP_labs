package figures;

import java.awt.*;

import static figures.FiguresConstants.*;


public abstract class Figure {
    protected Point location;
    protected Color lineColor;

    private boolean isSelected;


    public Figure() {
        this.location = new Point(0, 0);
        this.lineColor = STANDARD_COLOR;
        isSelected = false;
    }

    public Figure(Point location) {
        this.location = location;
        this.lineColor = STANDARD_COLOR;
        isSelected = false;
    }

    public Figure(Point location, Color lineColor) {
        this.location = location;
        this.lineColor = lineColor;
        isSelected = false;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void draw(Graphics g) {
        setStrokeWidth((Graphics2D) g);
    }

    public void setStrokeWidth(Graphics2D g) {
        if (isSelected)
            g.setStroke(new BasicStroke(STANDART_SELECTED_STROKE_WIDTH));
        else
            g.setStroke(new BasicStroke(STANDARD_STROKE_WIDTH));
    }

    public Point getLocation() {
        return location;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void move(int offsetX, int offsetY) {
        location.x += offsetX;
        location.y += offsetY;
    }
}