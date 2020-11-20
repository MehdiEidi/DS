package uni.ds;

public class BinarySearch {
    public static boolean binarySearch(int[] array, int targetValue, int low, int high) {
        if (low > high) {
            return false;
        } else {
            int median = (low + high) / 2;

            if (median == array.length) {
                return false;
            } else if (targetValue == array[median]) {
                return true;
            } else if (targetValue < array[median]) {
                return binarySearch(array, targetValue, low, median - 1);
            } else {
                return binarySearch(array, targetValue, median + 1, high);
            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{6, 8, 4, 1, 4, 1, 5, 0, 7};
        InsertionSort.insertionSort(array);
        System.out.println(binarySearch(array, 7, 0, array.length));
    }
}
