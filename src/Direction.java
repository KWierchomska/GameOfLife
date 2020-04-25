/**
 * Represents all possible directions that need to be checked,
 * when looking for cell's neighbours
 */
public enum Direction {
    /**
     * All 8 directions
     */
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST;

    /**
     * Converts direction to Vector2d class in order to add vector to cell's position and check neighbours
     * @return unit vector representation of direction
     */
    public Vector2d toUnitVector() {
        switch (this) {
            case NORTH:
                return new Vector2d(0, 1);
            case SOUTH:
                return new Vector2d(0, -1);
            case WEST:
                return new Vector2d(-1, 0);
            case EAST:
                return new Vector2d(1, 0);
            case NORTHWEST:
                return new Vector2d(-1, 1);
            case SOUTHWEST:
                return new Vector2d(-1, -1);
            case NORTHEAST:
                return new Vector2d(1, 1);
            case SOUTHEAST:
                return new Vector2d(1, -1);
        }
        return null;
    }
}
