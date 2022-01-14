import java.awt.*;
import javax.swing.*;
/**
 * 
 * @author Lukas DeLoach 
 * @version 1/8/2022
 * 
 * Frame class extending swing component JFrame. 
 *
 */
public class Frame extends JFrame { 

	private static final long serialVersionUID = 1L;
	private Panel panel = new Panel(); // Panel object

	/**
	 * Constructor for frame that creates the basics of the GUI
	 */
    public Frame() 
    {
        this.getContentPane().setPreferredSize(new Dimension(1200, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Sorting Algorithm Visualizer By Lukas DeLoach");
        this.getContentPane().add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    } 

    /**
     * Name: getPanel
     * Getter method of type Panel that returns the panel
     * @return panel
     */
    public Panel getPanel() {
        return this.panel;
    }
}