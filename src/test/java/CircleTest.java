import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    @DisplayName("[1] test getLowerBoundingBox")
    void getLowerBoundingBox() {
        Point p = new Point(100,100);
        Circle c = new Circle(p, 10);
        p.translate(-10,0);
        Rectangle r = new Rectangle(p,10,20);
        assertEquals(r,c.getLowerBoundingBox());

        p.translate(10,10);
        Rectangle r2 = new Rectangle(p,20,20);
        assertNotEquals(r2,c.getLowerBoundingBox());
    }
}