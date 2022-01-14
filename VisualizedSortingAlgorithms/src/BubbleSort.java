/**
 * @author Lukas DeLoach
 * @version 1/8/2022
 * 
 * BubbleSort Class that holds the implemented bubble sort algorithm.
 * Does not sort normally and only swaps one element at a time without being looped. This is to ensure the visual
 * representation of the algorithm shows the elements being sorted one at a time and does not just
 * show the sorted algorithm without visual representation. 
 */
public class BubbleSort {
    
    private int[] array;
    private int i;
    private int j;

    /**
     * Constructor for BubbleSort class
     * Takes a param int[] array and sets it to the field array
     * @param array
     */
    public BubbleSort(int[] array) {
        this.array = array;
        i = 0;
        j = Integer.MAX_VALUE;
    }

    /**
     * Name: sortOnlyOneItem
     * Getter method of type int[] that sorts one item at in an array at a time.
     * First checks to see if the array at index is compareIndex is bigger than the following index
     * If it is, swaps the two items.
     * Then checks if compare index+1 is greater than or equal to the length of the array -
     * arrayIndex - 1...if it is array index increments and compare index is set to 0;
     * @return array
     */
    public int[] sortOnlyOneItem() {

        if (array[j] > array[j+1]) {
            int temp = array[j];
            array[j] = array[j+1];
            array[j+1] = temp;
        }
        
        if ((j+1) >= (array.length - i - 1)) {
            i++;
            j = 0;
        }
        
        else
        {
        	j++;
        }
       
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
    public void setArrayIndex(int arrayIndex) {
        this.i = arrayIndex;
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
    public void setCompareIndex(int compareIndex) {
        this.j = compareIndex;
    }
}