package ellipses;

import java.awt.*;

public class Circle extends Ellipse {

    public Circle(Point location, int radius) {
        super(
                new Point(location.x - radius, location.y - radius),
                new Point(location.x + radius, location.y + radius)
        );
    }

    public Circle(Point location, int radius, Color fillColor) {
        super(
                new Point(location.x - radius, location.y - radius),
                new Point(location.x + radius, location.y + radius),
                fillColor
        );
    }

    public Circle(Point location, int radius, Color borderColor, Color fillColor) {
        super(
                new Point(location.x - radius, location.y - radius),
                new Point(location.x + radius, location.y + radius),
                borderColor,
                fillColor
        );
    }


    public void draw(Graphics g) {

    }

}