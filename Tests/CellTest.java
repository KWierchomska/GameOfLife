import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void checkNeighbours() {
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

        Cell c_1_1 = map.getCells().get(new Vector2d(1,1));
        c_1_1.checkNeighbours();
        assertFalse(c_1_1.isChanged());
        Cell c_1_2 = map.getCells().get(new Vector2d(1,2));
        c_1_2.checkNeighbours();
        assertFalse(c_1_1.isChanged());
    }
}