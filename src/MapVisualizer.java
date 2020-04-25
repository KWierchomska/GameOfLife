import javax.swing.*;
import java.awt.*;

/**
 * Visualization of the grid with cells
 */

public class MapVisualizer extends JPanel {
    /**
     * Parameters which defines gird,
     * frame in which map will be displayed
     * size of the map,
     * size of cell.
     */
    public Map map;
    public JFrame frame;
    private int size;
    private int sizeScale;

    /**
     * Creates new visualization of the grid with cells.
     * Sets size of grid and cells.
     * @param map grid on which cells  will be displayed
     * @param frame in which gird will be shown
     */
    public MapVisualizer(Map map, JFrame frame){
        this.map=map;
        this.frame=frame;
        this.setBounds(0,0, (int) (1 * frame.getWidth()), (int)(1 * frame.getHeight()));
        this.size = this.getWidth();
        this.sizeScale = (int) (size / this.map.getSize());
    }

    /**
     * Colors the grid and the cells.
     * @param graphics encapsulates state information needed for the basic rendering operations
     */
    protected void paintComponent (java.awt.Graphics graphics){
        super.paintComponent((java.awt.Graphics) graphics);
        ((java.awt.Graphics) graphics).setColor(new Color(0, 0, 0));
        graphics.fillRect(0, 0, this.size, this.size);

        for(int i=0; i<this.map.getSize(); i++){
            for(int j=0; j<this.map.getSize(); j++)
                try{
                    ((java.awt.Graphics) graphics).setColor(this.map.getCells().get(new Vector2d(i, j)).toColor());;
                    ((java.awt.Graphics) graphics).fillRect(i*this.sizeScale,j*this.sizeScale, this.sizeScale, this.sizeScale);
                    ((java.awt.Graphics) graphics).setColor(new Color(150, 150, 150));
                    ((java.awt.Graphics) graphics).drawRect(i*this.sizeScale,j*this.sizeScale, this.sizeScale, this.sizeScale );
                }catch (NullPointerException ex){
                    System.out.println("Can not paint cell which does not exist.");
                }
        }
    }
}
