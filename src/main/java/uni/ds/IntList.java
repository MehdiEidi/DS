package uni.ds;

import java.util.Arrays;

public class IntList {
    private int[] array;
    private int occupied;

    /**
     * Creates an empty IntList
     */
    public IntList() {
        //Initially the size of array is 2.
        array = new int[2];
        occupied = 0;
    }

    /**
     * Creates an IntList of given size. All elements of the IntList are set to zero initially.
     * @param size size of the IntList that will be Created.
     */
    public IntList(int size) {
        array = new int[size];
        occupied = size;
    }

    /**
     * Creates an IntList of given array.
     * @param inputArray an array representing the elements that the IntList will be created of.
     */
    public IntList(int[] inputArray) {
        array = new int[inputArray.length];
        System.arraycopy(inputArray, 0, array, 0, inputArray.length);
        occupied = inputArray.length;
    }

    /**
     * Factory method for creating an IntList of given elements.
     * @param elements an array of elements that the IntList will be created of.
     * @return the IntList.
     */
    public static IntList of(int... elements) {
        return new IntList(elements);
    }

    /**
     * To convert the IntList to string representation of it.
     * @return the string representation of the IntList.
     */
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, occupied));
    }

    /**
     * To return the size of the IntList.
     * @return size of the IntList.
     */
    public int size() {
        return occupied;
    }

    /**
     * Returns an element from the IntList stored in the given position.
     * @param index index of the element that will be returned.
     * @return the element in the given position.
     */
    public int get(int index) {
        return array[index];
    }

    /**
     * Sets the element of a given index to a given value.
     * @param index the index of the IntList that will be set to given value.
     * @param val the value that will be set in the given index.
     * @return the IntList. For having fluent method chaining.
     */
    public IntList set(int index, int val) {
        array[index] = val;
        return this;
    }

    //For assuring that the array always has some space for adding a new element
    private void assureCapacity() {
        if(occupied < array.length) {
            return;
        }

        //For making the insertion a bit faster, we make a new array with double size.
        array = Arrays.copyOf(array, 2 * array.length);
    }

    //When the 3/4 of the array is empty, we shrink it by making a new array with 1/2 size.
    private void shrinkArray() {
        if(occupied == array.length / 4) {
            array = Arrays.copyOf(array, array.length / 2);
        }
    }

    /**
     * Inserting an element inside of the IntList. The following elements will be pushed.
     * @param index the index in which the element will be inserted in.
     * @param val the value that will be inserted in the given index
     * @return the IntList. For having fluent method chaining.
     */
    public IntList insert(int index, int val) {
        if(index < 0 || index > occupied) {
            throw new IllegalArgumentException("Index is out of bounds: " + index);
        }

        assureCapacity();

        //If the index == occupied, it means we are adding the element to the end of the IntList, so we don't need to push any elements.
        if(index != occupied) {
            System.arraycopy(array, index, array, index + 1, occupied - index);
        }

        set(index, val);
        occupied++;

        return this;
    }

    /**
     * Inserts an element to the end of the IntList.
     * @param val the value that will be inserted in the end of the IntList.
     * @return the IntList. For having fluent method chaining.
     */
    public IntList pushBack(int val) {
        return insert(occupied, val);
    }

    /**
     * Inserts an element to the beginning of the IntList.
     * @param val the value that will be inserted in the beginning of the IntList.
     * @return the IntList. For having fluent method chaining.
     */
    public IntList pushFront(int val) {
        return insert(0, val);
    }

    /**
     * Removes the element from the IntList stored in the given index.
     * @param index the index of the element to be removed.
     * @return the removed element.
     */
    public int remove(int index) {
        if (index < 0 || index > occupied) {
            throw new IllegalArgumentException("index is out of bounds: " + index);
        }

        int val = array[index];

        //If the index is pointing to the last element, then we don't need to shift elements.
        if (occupied - 1 - index >= 0) {
            System.arraycopy(array, index + 1, array, index, occupied - 1 - index);
        }
        occupied--;

        shrinkArray();

        return val;
    }

    /**
     * Removes the first element of the IntList.
     * @return the removed element.
     */
    public int removeFront() {
        return remove(0);
    }

    /**
     * Removes the last element of the IntList.
     * @return the removed element.
     */
    public int removeBack() {
        return remove(occupied - 1);
    }

    /**
     * Sorts the list using bubble sort algorithm.
     */
    public void sort() {
        for(int i = 0; i < occupied - 1; i++) {
            for(int j = 0; j <= occupied - 2; j++) {
                if(array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Merge two IntLists. The result will be a sorted array.
     * @param secondList the second IntList.
     * @return a sorted and merged IntList.
     */
    public IntList merge(IntList secondList) {
        //Making sure that both lists are sorted.
        this.sort();
        secondList.sort();

        //For storing the merged list.
        IntList thirdList = new IntList();

        int firstListIndex = 0;
        int secondListIndex = 0;

        while(firstListIndex < this.size() && secondListIndex < secondList.size()) {
            if(this.get(firstListIndex) < secondList.get(secondListIndex)) {
                thirdList.pushBack(this.get(firstListIndex++));
            } else {
                thirdList.pushBack(secondList.get(secondListIndex++));
            }
        }

        //Storing the remaining elements of the first list(if exist any)
        while(firstListIndex < this.size()) {
            thirdList.pushBack(this.get(firstListIndex++));
        }

        //Storing the remaining elements of the second list(if exist any)
        while(secondListIndex < secondList.size()) {
            thirdList.pushBack(secondList.get(secondListIndex++));
        }

        return thirdList;
    }

    /**
     * This method gets a value and inserts that value to an index in which the list always stays sorted.
     * @param value the value to be stored.
     * @return the IntList.
     */
    public IntList addToProperIndex(int value) {
        for (int i = 0; i < this.size(); i++) {
            if (value < this.get(i)) {
                this.insert(i, value);
                return this;
            }
        }

        this.insert(this.size(), value);

        return this;
    }

    public static void main(String[] args) {
        IntList a = new IntList();
        System.out.println(a);

        a.addToProperIndex(5);
        System.out.println(a);
        a.addToProperIndex(8);
        System.out.println(a);
        a.addToProperIndex(6);
        a.addToProperIndex(2);
        a.addToProperIndex(3);
        a.addToProperIndex(9);
        a.addToProperIndex(7);
        
        System.out.println(a);
    }
}
