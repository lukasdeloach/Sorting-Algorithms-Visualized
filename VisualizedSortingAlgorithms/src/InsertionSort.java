/**
 * @author Lukas DeLoach
 * @version 1/8/2022
 * 
 * InsertionSort Class that holds the implemented insertion sort algorithm.
 * Does not sort normally and only swaps one element at a time wihtout being looped. This is to ensure the visual
 * representation of the algorithm shows the elements being sorted one at a time and does not just
 * show the sorted algorithm without visual representation. 
 */
public class InsertionSort {

    private int[] array;
    private int i;
    private int j;
    private int key;
    private boolean iteration = false;

    /**
     * Constructor for insertion sort takes one param and initializes the index variable
     * @param array
     */
    public InsertionSort(int[] array) {
        this.array = array;
        i = 1;
    }

    /**
     * Name: sortOnlyOneItem
     * Sorts only one item at a time to ensure visual representation stepped
     * @return array
     */
    public int[] sortOnlyOneItem() {

        if (iteration == false) {
            key = array[i];
            j = i - 1;
            iteration = true;
        }

        if (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
            return array;
        }
        else {
            array[j + 1] = key;
            i++;
        }

        iteration = false;
        return array;
    }

    /**
     * Name: getArray
     * Getter method of return type int[]
     * @return array
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Name: setArray
     * Mutator method that sets the parameter to the array field
     * @param array
     */
    public void setArray(int[] array) {
        this.array = array;
    }

    /**
    * Name: getArrayIndex
    * Getter method that returns the arrayIndex
    * @return
    */
    public int getArrayIndex() {
        return i;
    }

    /**
     * Name: setArrayIndex
     * Mutator method that sets the arrayIndex field to arrayIndex
     * @param array_index
     */
    public void setArrayIndex(int array_index) {
        this.i = array_index;
    }

    /**
     * Name: getCompareIndex
     * Getter method that returns the value of compareIndex
     * @return compareIndex
     */
    public int getCompareIndex() {
        return j;
    }

    /**
     * Name: setCompareIndex
     * Mutator method that sets the compareIndex field to the value of the parameter
     * @param compareIndex
     */
    public void setCompareIndex(int compare_index) {
        this.j = compare_index;
    }

    /**
     * Name: getStartOfIteration
     * Getter method that returns iteration
     * @return iteration
     */
    public boolean getStartOfIteration() {
        return iteration;
    }

    /**
     * Name: setStartOfIteration
     * Mutator method that sets determines boolean value
     * @param compareIndex
     */
    public void setStartOfIteration(boolean startOfIteration) 
    {
        this.iteration = startOfIteration;
    }
}