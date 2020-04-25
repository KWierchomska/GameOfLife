import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.awt.*;

/**
 * Represents cell on the grid
 */
public class Cell {
    /**
     * Parameters which define if cell is alive,
     * if cell's state needs to be changed in next generation,
     * cell's position,
     * grid on which cell will be displayed
     */
    private boolean alive;
    private boolean changed;
    private Vector2d position;
    private Map map;

    /**
     * Creates new alive cell with given position and grid on which it will be displayed
     * @param position of cell on the map
     * @param map grid with cells
     */
    public Cell (Vector2d position, Map map){
        this.alive = true;
        this.changed = false;
        this.position = position;
        this.map = map;
    }

    /**
     * Changes state of cell if cell was marked to be changed
     */
    public void changeState(){
        this.alive = !this.alive;
        this.changed = false;
    }

    /**
     * Checks Conway's Game of Life rules and marks cells in order to shift theirs state
     */
    public void checkNeighbours(){
        int aliveCellsCount = 0;
        for(Direction direction : Direction.values()){
            Vector2d vector2d = this.position.add(direction.toUnitVector());
            try{
                if(vector2d.checkBounds()){
                    Cell cell = this.map.getCells().get(vector2d);
                    if(cell.isAlive()){
                        aliveCellsCount++;
                    }
                }
            }
            catch (NullPointerException ex){
                System.out.println("Cell does not exist");
            }
        }
        if(this.alive){
            if(aliveCellsCount < 2 || aliveCellsCount > 3) this.changed = true;
        }
        else if (aliveCellsCount == 3) this.changed = true;
    }

    /**
     * Sets color for cell
     * @return color for alive or dead cell
     */
    public Color toColor(){
        if(this.alive) return new Color(96,2,50);
        return new Color(255,255,255);
    }

    /**
     * Gets state of this cell
     * @return this cell's state
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Sets state of this cell
     * @param alive new cell's state
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Gets position of this cell
     * @return this cell's position
     */
    public Vector2d getPosition() {
        return position;
    }

    /**
     * Gets parameter defining necessity for cell's state shift
     * @return true if cell's state need to be changed
     */
    public boolean isChanged() {
        return changed;
    }
}
