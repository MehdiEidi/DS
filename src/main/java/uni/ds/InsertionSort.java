package uni.ds;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    //Swaps two elements in the array.
    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //Sorts an array of numbers using insertion sort.
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j-1] > array[j]; j--) {
                swap(array, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100];

        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt();
        }

        int[] array2 = array.clone();

        insertionSort(array);
        Arrays.sort(array2);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.equals(array, array2));
    }
}