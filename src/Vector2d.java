/**
 * Class which represents position of particular cell on grid.
 */
public class Vector2d {
    /**
     * The x coordinate and y coordinate of cell's position,
     * which is represented by two dimensional vector.
     */
    final public int x;
    final public int y;

    /**
     * Creates new vector with given coordinates.
     * @param x first coordinate
     * @param y second coordinate
     */
    public Vector2d(int x, int y) {
        this.x=x;
        this.y=y;
    }

    /**
     * Displays vector
     * @return vector's coordinates converted to string, which looks like (x,y)
     */
    public String toString(){

        return "(" + this.x + "," + this.y + ")";
    }

    /**
     * Adds two vectors
     * @param vector which will be added
     * @return addition result as vector
     */
    public Vector2d add(Vector2d vector){

        return new Vector2d (this.x + vector.x, this.y + vector.y);
    }

    /**
     * Checks if cell's position is inside grid
     * @return true for position inside grid
     */
    public boolean checkBounds(){
        return (this.x >= 0 && this.x <50 && this.y >= 0 && this.y < 50);
    }

    /**
     * Checks if two vectors are equal
     * @param other vector which will be checked
     * @return true if both objects are instance of Vector2d class and theirs coordinates are equal
     */
    public boolean equals(Object other){
        if (this == other) return true;
        if(!(other instanceof Vector2d)) return false;
        Vector2d that = (Vector2d) other;
        return this.x==that.x && this.y==that.y;
    }

    /**
     * Generates hash code for vector (will be needed in HashMap etc.)
     * @return hash code for vector
     */
    @Override
    public int hashCode(){
        int hash = 13;
        hash += this.x * 31;
        hash += this.y * 17;
        return hash;
    }
}
