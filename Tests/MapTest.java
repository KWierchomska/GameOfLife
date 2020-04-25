import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    private Map map = new Map();

    @Test
    void randomPattern() {
        int aliveCellsCount = 0;
        assertEquals(0, map.getCurrentPattern());
        assertEquals(map.getCells().size(), 2500);
        for(int i=0; i<map.getSize(); i++){
            for(int j=0; j<map.getSize(); j++){
                if(map.getCells().get(new Vector2d(i,j)).isAlive()) aliveCellsCount++;
            }
        }
        assertEquals(aliveCellsCount, 1250);
    }

    @Test
    void theQueenBeeShuttlePattern() {
        int aliveCellsCount = 0;
        map.setPattern();
        assertEquals(1, map.getCurrentPattern());
        for(int i=0; i<map.getSize(); i++){
            for(int j=0; j<map.getSize(); j++){
                if(map.getCells().get(new Vector2d(i,j)).isAlive()) aliveCellsCount++;
            }
        }
        assertEquals(aliveCellsCount, 9);
    }

    @Test
    void tumblerPattern() {
        int aliveCellsCount = 0;
        map.setPattern();
        map.setPattern();
        assertEquals(2, map.getCurrentPattern());
        for(int i=0; i<map.getSize(); i++){
            for(int j=0; j<map.getSize(); j++){
                if(map.getCells().get(new Vector2d(i,j)).isAlive()) aliveCellsCount++;
            }
        }
        assertEquals(aliveCellsCount, 22);
    }


    @Test
    void nextGeneration() {
        Map map = new Map();
        for(int i=0; i<map.getSize(); i++){
            for(int j=0; j<map.getSize(); j++){
                Cell cell = new Cell(new Vector2d(i,j), map);
                cell.setAlive(false);
                map.getCells().put(cell.getPosition(),cell);
            }
        }
        map.getCells().get(new Vector2d(1,1)).setAlive(true);
        map.getCells().get(new Vector2d(1,2)).setAlive(true);
        map.getCells().get(new Vector2d(2,2)).setAlive(true);

        map.nextGeneration();

        int aliveCellsCount = 0;
        for(int i=0; i<map.getSize(); i++){
            for(int j=0; j<map.getSize(); j++){
                if(map.getCells().get(new Vector2d(i,j)).isAlive()) aliveCellsCount++;
            }
        }
        assertEquals(4,aliveCellsCount);
        map.nextGeneration();
        assertEquals(4,aliveCellsCount);
    }
}