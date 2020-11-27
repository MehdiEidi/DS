package uni.ds;

import java.util.ArrayList;
import java.util.Arrays;

public class DynamicArray<T> implements List<T> {
    private Object[] array;
    private int occupied;

    public DynamicArray() {
        array = new Object[1];
    }

    @Override
    public int size() {
        return occupied;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public DynamicArray<T> set(int index, T value) {
        array[index] = value;
        return this;
    }

    private void assureCapacity() {
        if(!(occupied < array.length)) {
            //For making the insertion a bit faster, we make a new array with double size when it gets full.
            array = Arrays.copyOf(array, 2 * array.length);
        }
    }

    @Override
    public List<T> add(T value) {
        assureCapacity();
        set(occupied, value);
        occupied++;
        return this;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, occupied));
    }

    public static void main(String[] args) {
        DynamicArray<String> a = new DynamicArray<>();
        System.out.println(a);
        a.add("a");
        System.out.println(a);
        a.add("bc");
        a.add("dfg");
        System.out.println(a);
    }
}