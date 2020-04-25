import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    private Vector2d v_1_1 = new Vector2d(1,1);
    private Vector2d v_2_3 = new Vector2d(2,3);
    private Vector2d v_1_4 = new Vector2d(1,4);
    private Vector2d v_0_100 = new Vector2d(0, 100);

    @Test
    void add() {
        assertEquals(new Vector2d(3,7),v_1_4.add(v_2_3));
        assertEquals(new Vector2d(2,5),v_1_4.add(v_1_1));
        assertEquals(new Vector2d(3,4),v_1_1.add(v_2_3));
    }

    @Test
    void checkBounds() {
        assertFalse(v_0_100.checkBounds());
        assertTrue(v_1_1.checkBounds());
    }

    @Test
    void Equals() {
        assertTrue(v_1_1.equals(new Vector2d(1,1)));
        assertTrue(v_2_3.equals(new Vector2d(2,3)));
        assertFalse(v_1_4.equals(new Vector2d(2,3)));
    }

    @Test
    void testHashCode() {
        assertEquals(v_1_1.hashCode(), new Vector2d(1,1).hashCode());
        assertEquals(v_2_3.hashCode(), new Vector2d(2,3).hashCode());
        assertEquals(v_1_4.hashCode(), new Vector2d(1,4).hashCode());
    }
}