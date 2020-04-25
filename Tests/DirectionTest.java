import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {

    @Test
    void toUnitVector() {
        assertEquals(Direction.NORTH.toUnitVector(), new Vector2d(0,1));
        assertEquals(Direction.NORTHEAST.toUnitVector(), new Vector2d(1,1));
        assertEquals(Direction.EAST.toUnitVector(), new Vector2d(1,0));
        assertEquals(Direction.SOUTHEAST.toUnitVector(), new Vector2d(1,-1));
        assertEquals(Direction.SOUTH.toUnitVector(), new Vector2d(0,-1));
        assertEquals(Direction.SOUTHWEST.toUnitVector(), new Vector2d(-1,-1));
        assertEquals(Direction.WEST.toUnitVector(), new Vector2d(-1,0));
        assertEquals(Direction.NORTHWEST.toUnitVector(), new Vector2d(-1,1));
    }
}