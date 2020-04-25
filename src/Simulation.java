import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Represents simulation of Conway's Game of Life.
 */

public class Simulation extends JFrame implements KeyListener {
    /**
     * Grid on which simulation will be displayed
     */
    public Map map;

    /**
     * Creates new simulation on the grid
     * @param map grid with cells
     */
    public Simulation(Map map){
        this.map=map;
    }

    /**
     * Simulation loop.
     */
    public void startSimulation() {
        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setSize(650,650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MapVisualizer mapVisualizer = new MapVisualizer(map, frame);
        frame.setVisible(true);
        frame.setLayout(null);

        frame.add(mapVisualizer);

        frame.addKeyListener(this);

        try {
            while(true) {
                mapVisualizer.repaint();
                map.nextGeneration();
                Thread.sleep(30);
            }
        } catch(InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Invoked when a key has been typed.
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     * After Enter has been pressed new simulation pattern begins.
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER ){
            this.map.setPattern();
        }
    }

    /**
     * Invoked when a key has been released.
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
