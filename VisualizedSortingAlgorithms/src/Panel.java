import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * 
 * @author Lukas DeLoach
 * @version 1/10/2022
 * 
 * Panel Class which uses JPanel from swing.
 * Functionality, visual representation, interactive interface created in this class
 */
public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Random random;
    private int[] array;
    private BubbleSort bubbleSort;
    private InsertionSort insertionSort;
    private SelectionSort selectionSort;
    
    private boolean isBubble = false;
    private boolean isInsertion = false;
    private boolean isSelection = false;
   
    private JFrame jf;
    private JButton start;
    private JButton reset;
    private JButton bubble;
    private JButton insertion;
    private JButton selection;
    private JButton credit;

    private boolean isRunning;


    /**
     * Constructor that instantiates the buttons and adds functionality to them 
     */
    public Panel() 
    {

        random = new Random();
        array = new int[80];
        this.setArray();

        bubbleSort = new BubbleSort(array);
        insertionSort = new InsertionSort(array);
        selectionSort = new SelectionSort(array);
       
        
        //Creating the buttons
        start = new JButton("Start");
        reset = new JButton("Reset");
        bubble = new JButton("Bubble");
        insertion = new JButton("Insertion");
        selection = new JButton("Selection");
        credit = new JButton("Credit");
        
        this.add(start);
        this.add(bubble);
        this.add(insertion);
        this.add(selection);
        this.add(reset);
        this.add(credit);

        //Setting the button's functions and components up
        start.setBackground(Color.WHITE);
        start.setFocusPainted(true);
        start.setBorderPainted(true);
        start.setOpaque(true);
        start.setBackground(new Color(13, 193, 0));
        start.setFont(new Font("Comic Sans", Font.BOLD, 20));
        start.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                try {
                    start.setBackground(Color.lightGray);
                    if (isRunning == false)
                        isRunning = true;
                        animate();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } 
        });

        bubble.setBackground(Color.WHITE);
        bubble.setFocusPainted(true);
        bubble.setBorderPainted(true);
        bubble.setFont(new Font("Comic Sans", Font.BOLD, 20));
        bubble.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                try {
                    if (isRunning == false) {
                        isInsertion = false;
                        isSelection = false;
                        isBubble = true;
                        //setButtonBackground();
                        selection.setOpaque(false);
                        insertion.setOpaque(false);
                        bubble.setOpaque(true);
                        bubble.setBackground(Color.lightGray);
                    }  
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } 
        });

        insertion.setBackground(Color.WHITE);
        insertion.setFocusPainted(true);
        insertion.setBorderPainted(true);
        insertion.setFont(new Font("Comic Sans", Font.BOLD, 20));
        insertion.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                try {
                    if (isRunning == false) {
                        isBubble = false;
                        isSelection = false;
                        isInsertion = true;
                        //setButtonBackground();
                        selection.setOpaque(false);
                        bubble.setOpaque(false);
                        insertion.setOpaque(true);
                        insertion.setBackground(Color.lightGray);
                    } 
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } 
        });

        selection.setBackground(Color.WHITE);
        selection.setFont(new Font("Comic Sans", Font.BOLD, 20));
        selection.setFocusPainted(true);
        selection.setBorderPainted(true);
        selection.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                try {
                    if (isRunning == false) {
                        isBubble = false;
                        isInsertion = false;
                        isSelection = true;
                        insertion.setOpaque(false);
                        bubble.setOpaque(false);
                        selection.setOpaque(true);
                        selection.setBackground(Color.lightGray);
                    } 
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            } 
        });

       
        reset.setBackground(Color.WHITE);
        reset.setFont(new Font("Comic Sans", Font.BOLD, 20));
        reset.setFocusPainted(true);
        reset.setBorderPainted(true);
        reset.setOpaque(true);
        reset.setBackground(new Color(204, 32, 0));
        reset.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 

                reset.setBackground(Color.lightGray);
                start.setBackground(new Color(13, 193, 0));

                setArray();

                // reset bubbleSort object
                bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                bubbleSort.setArrayIndex(0);
                bubbleSort.setArray(array);

                // reset insertionSort object
                insertionSort.setCompareIndex(Integer.MAX_VALUE);
                insertionSort.setArrayIndex(Integer.MAX_VALUE);
                insertionSort.setArray(array);
                insertionSort.setStartOfIteration(false);
                
                selection.setOpaque(false);
                bubble.setOpaque(false);
                insertion.setOpaque(false);

                isRunning = false;
                
                Timer timer  = new Timer(100, new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	reset.setBackground(new Color(204, 32, 0));
                        ((Timer)e.getSource()).stop();
                    }
                });

                timer.start();
                repaint();
            } 
        });
        
        credit.setFont(new Font("Comic Sans", Font.BOLD, 20));
        credit.setBorderPainted(true);
        credit.setFocusPainted(true);
        credit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(jf, "	                         Sorting Algorithm Visualizer\n"
												+ "                          By Lukas DeLoach\n"
												+ "           Build Date:  January 8, 2022   ", "Credit", JOptionPane.CLOSED_OPTION, new ImageIcon(""));
			}
		});
    }
    
    /**
     * Name: getArray
     * Getter type of int[] that returns the array
     * @return
     */
    public int[] getArray() {
        return this.array;
    }

    /**
     * Name: setArray
     * Sets the array with random numbers
     */
    public void setArray() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(510) + 40;
        }
    }

    /**
     * Name: isSorted
     * Checks if the graph is sorted uses a simple compare algorithm
     * @return true, false
     */
    public boolean isSorted() {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false; 
            }
        }
    
        return true;
    }

    /**
     * Name: animate
     * Controls the functions for when a button is pressed
     * @throws Exception
     */
    public void animate() throws Exception{

        if (isBubble) {

            bubbleSort.setCompareIndex(0);

            Timer bubbleTimer  = new Timer(10, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                        isRunning = false;
                        start.setBackground(new Color(13, 193, 0));
                        ((Timer)e.getSource()).stop();
                    } 
                    else {
                        if (isRunning == true)
                            array = bubbleSort.sortOnlyOneItem();
                    }

                    repaint();
                }
            });

            bubbleTimer.start();
        }
        
        if (isInsertion) {

            insertionSort.setArrayIndex(1);

            Timer insertionTimer  = new Timer(10, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        insertionSort.setCompareIndex(Integer.MAX_VALUE);
                        insertionSort.setArrayIndex(Integer.MAX_VALUE);
                        insertionSort.setStartOfIteration(false);
                        start.setBackground(new Color(13, 193, 0));
                        isRunning = false;
                        ((Timer)e.getSource()).stop();
                    } 
                    else {
                        if (isRunning == true)
                            array = insertionSort.sortOnlyOneItem();
                    }

                    repaint();
                }
            });

            insertionTimer.start();
        }

        if (isSelection) {

            selectionSort.setArrayIndex(0);
            selectionSort.setCompareIndex(1);
            selectionSort.setMinIndex(0);

            Timer selectionTimer  = new Timer(10, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (isSorted() || isRunning == false) {
                        selectionSort.setCompareIndex(Integer.MAX_VALUE);
                        selectionSort.setArrayIndex(Integer.MAX_VALUE);
                        selectionSort.setMinIndex(Integer.MAX_VALUE);
                        start.setBackground(new Color(13, 193, 0));
                        isRunning = false;
                        ((Timer)e.getSource()).stop();
                    } 
                    else {
                        if (isRunning == true)
                            array = selectionSort.sortOnlyOneItem();
                    }

                    repaint();
                }
            });

            selectionTimer.start();
        }
    }
    
    /**
     * Name: paintComponent
     * Uses the Graphics object from swing
     * @param Graphics g
     */
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.setBackground(new Color(111, 162, 251));

        for (int i = 0; i < array.length; i++) {
            
            g.setColor(Color.BLACK);
            g.drawRect(i*15, 600 - array[i], 14, array[i]); 
            
            if (isBubble) 
            {
                if (i == bubbleSort.getCompareIndex() || i == (bubbleSort.getCompareIndex() + 1)) {
                    g.setColor(Color.MAGENTA);
                }

            }

            if (isInsertion) 
            {
                if (i == insertionSort.getCompareIndex() || i == (insertionSort.getCompareIndex() + 1)) 
                {
                    g.setColor(Color.MAGENTA);
                }

                if (i == insertionSort.getArrayIndex()) 
                {
                    g.setColor(Color.GREEN);
                }
            }

            if (isSelection) 
            {
                if (i == selectionSort.getCompareIndex() || i == selectionSort.getMinIndex()) 
                {
                    g.setColor(Color.MAGENTA);
                }

                if (i == selectionSort.getArrayIndex()) 
                {
                    g.setColor(Color.GREEN);
                }
            }
        
            if (g.getColor() != Color.MAGENTA && g.getColor() != Color.GREEN && g.getColor() != Color.BLUE && g.getColor() != Color.RED)
                g.setColor(new Color(255, 213, 39));

            g.fillRect(i*15, 600 - array[i], 14, array[i]);
        }
    }
}