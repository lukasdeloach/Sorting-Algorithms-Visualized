/**
 * 
 * @author Lukas DeLoach
 * @version 1/8/2022
 * 
 * SelectionSort Class that holds the implemented selection sort algorithm.
 * Does not sort normally and only swaps one element at a time. This is to ensure the visual
 * representation of the algorithm shows the elements being sorted one at a time and does not just
 * show the sorted algorithm without visual representation. 
 */
public class SelectionSort {
    
    private int i, j, minIndex;
    private int[] array;
    private boolean findingMin;

    /**
     * Constructor for SelectionSort Class
     * Takes one param int[] array and sets it to the field array
     * Sets the boolean to false and the other index keepers with logical values.
     * @param array
     */
    public SelectionSort(int[] array) {
        this.array = array;
        i = 0;
        j = 1;
        minIndex = 0;
        findingMin = false;
    }
    
    /**
     * Name: sortOnlyOneItem
     * Selection Sort One item at a time.
     * @return array
     */
    public int[] sortOnlyOneItem() {

        if (findingMin == false) {
            minIndex = i;
            findingMin = true;
        }

        if (array[j] < array[minIndex]) {
            minIndex = j;
        }

        j++;

        if (j >= 80) {
            swap(array, minIndex, i);
            i++;
            j = i + 1;
            findingMin = false;
        }

        return array;
    }
    
    /**
     * Name: swap
     * Mutator method that swaps two elements
     * @param arr
     * @param i
     * @param j
     */
    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

    /**
     * Name: getMinIndex
     * @return minIndex
     */
    public int getMinIndex() {
        return minIndex;
    }

    /**
     * Name: setMinIndex
     * @param minIndex
     */
    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    } 
}