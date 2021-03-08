package oneD;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RayTest extends Ray {

    @Before
    public void setup() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(5, 8);
        this.setSecondPoint(p2);
        this.setLocation(p1);
    }

    @Test
    public void shouldFindIntersection() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(5, 8);
        Point p3 = new Point(0, 0);
        Point p4 = new Point(11, 0);

        Point result = intersectionPoint(p1, p2, p3, p4);

        assertEquals(new Point(2, 0), result);
    }

    @Test
    public void shouldFindIntersectionAnother() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(5, 8);
        Point p3 = new Point(0, 10);
        Point p4 = new Point(11, 10);

        Point result = intersectionPoint(p1, p2, p3, p4);

        assertEquals(new Point(6, 10), result);
    }

    @Test
    public void shouldReturnFourPoints() {
        Point p1 = new Point(3, 3);
        Point p2 = new Point(5, 8);
        List<Point> rect = getUserRect(10, 11);

        List<Point> result = intersectionPoints(rect, p1, p2);

        assertEquals(4, result.size());
    }


    @Test
    public void shouldOneSide() {
        List<Integer> line = createLine(getLocation(), getSecondPoint());

        boolean result = isOneSideLine(line, new Point(3, 5), new Point(2, 8));

        assertTrue(result);
    }

    @Test
    public void shouldOneGetSecondPoint(){
       Point point = getSecondPointForDrawing(10,11);

       assertEquals(new Point(6,10),point);
    }



}