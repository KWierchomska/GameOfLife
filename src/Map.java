import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.beans.VetoableChangeListener;
import java.util.*;

/**
 * Represents Conway's Game of Life grid with cells.
 */

public class Map {
    /**
     * Parameters which defines size of the map,
     * currently running initial pattern,
     * Hash Map which stores cells as values and uses theirs positions as keys
     */
    private int size;
    private int currentPattern;
    private LinkedHashMap<Vector2d, Cell> cells = new LinkedHashMap<>();

    /**
     * Creates new map with given size,
     * current pattern with starting value -1, because of setPattern function which adds 1 to currentPatter,
     * runs setPattern function in order to start simulation.
     */
    public Map(){
        this.size = 50;
        this.currentPattern = -1;
        setPattern();
    }

    /**
     * Generates first initial pattern of simulation - Random Pattern.
     * First creates alive cells, then randomly choose half of them to mark them as dead.
     */
    public void randomPattern(){
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                Cell cell = new Cell(new Vector2d(i,j), this);
                this.cells.put(cell.getPosition(), cell);
            }
        }
        int cellsCount = 0;
        while (cellsCount < 1250){
            int x = new Random().nextInt(this.size - 1);
            int y = new Random().nextInt(this.size - 1);
            Cell cell = this.cells.get(new Vector2d(x,y));
            if(cell.isAlive()){
                cell.setAlive(false);
                cellsCount++;
            }
        }
    }

    /**
     * Generates second initial pattern of simulation - The Queen Bee Shuttle Pattern.
     * First marks every cell as dead, then nine of them sets as alive.
     */
    public void theQueenBeeShuttlePattern(){
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                Cell cell = this.cells.get(new Vector2d(i,j));
                if(cell.isAlive()) cell.setAlive(false);
            }
        }
        this.cells.get(new Vector2d(15,20)).setAlive(true);
        this.cells.get(new Vector2d(16,20)).setAlive(true);
        this.cells.get(new Vector2d(17,21)).setAlive(true);
        this.cells.get(new Vector2d(18,22)).setAlive(true);
        this.cells.get(new Vector2d(18,23)).setAlive(true);
        this.cells.get(new Vector2d(18,24)).setAlive(true);
        this.cells.get(new Vector2d(17,25)).setAlive(true);
        this.cells.get(new Vector2d(16,26)).setAlive(true);
        this.cells.get(new Vector2d(15,26)).setAlive(true);
    }

    /**
     * Generates third initial pattern of simulation - Tumbler Pattern.
     * First marks every cell as dead, then twenty two of them sets as alive.
     */
    public void tumblerPattern(){
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                Cell cell = this.cells.get(new Vector2d(i,j));
                if(cell.isAlive()) cell.setAlive(false);
            }
        }
        this.cells.get(new Vector2d(19, 15)).setAlive(true);
        this.cells.get(new Vector2d(19, 14)).setAlive(true);
        this.cells.get(new Vector2d(20, 14)).setAlive(true);
        this.cells.get(new Vector2d(20, 15)).setAlive(true);
        this.cells.get(new Vector2d(20, 16)).setAlive(true);
        this.cells.get(new Vector2d(20, 17)).setAlive(true);
        this.cells.get(new Vector2d(20, 18)).setAlive(true);
        this.cells.get(new Vector2d(19, 19)).setAlive(true);
        this.cells.get(new Vector2d(18, 19)).setAlive(true);
        this.cells.get(new Vector2d(18, 18)).setAlive(true);
        this.cells.get(new Vector2d(18, 17)).setAlive(true);

        this.cells.get(new Vector2d(23, 15)).setAlive(true);
        this.cells.get(new Vector2d(23, 14)).setAlive(true);
        this.cells.get(new Vector2d(22, 14)).setAlive(true);
        this.cells.get(new Vector2d(22, 15)).setAlive(true);
        this.cells.get(new Vector2d(22, 16)).setAlive(true);
        this.cells.get(new Vector2d(22, 17)).setAlive(true);
        this.cells.get(new Vector2d(22, 18)).setAlive(true);
        this.cells.get(new Vector2d(23, 19)).setAlive(true);
        this.cells.get(new Vector2d(24, 19)).setAlive(true);
        this.cells.get(new Vector2d(24, 18)).setAlive(true);
        this.cells.get(new Vector2d(24, 17)).setAlive(true);
    }

    /**
     * Runs adequate pattern after user presses Enter,
     * uses modulo 3 to loop infinitely
     */
    public void setPattern(){
        this.currentPattern = (this.currentPattern + 1) % 3;
        switch (this.currentPattern){
            case 0:
                this.randomPattern();
                return;
            case 1:
                this.theQueenBeeShuttlePattern();
                return;
            case 2:
                this.tumblerPattern();
                return;
        }
    }

    /**
     * Generates next generation of cells.
     * First checks which cells' state need to be changed,
     * then sets adequate state.
     */
    public void nextGeneration(){
        for(Cell cell : cells.values()){
            cell.checkNeighbours();
        }
        for(Cell cell : cells.values()){
            if(cell.isChanged()) cell.changeState();
        }
    }

    /**
     * Gets Hash Map with cells.
     * @return Hash Map with cells as values
     */

    public HashMap<Vector2d, Cell> getCells() {
        return cells;
    }

    /**
     * Gets size of this map.
     * @return map's size
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets current running initial pattern.
     * @return current initial pattern
     */
    public int getCurrentPattern() {
        return currentPattern;
    }
}
