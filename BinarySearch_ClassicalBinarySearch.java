public class BinarySearch_ClassicalBinarySearch {

    public int binarySearch(int[] array, int target) {
        // Write your solution here
        // corner case
        if(array == null || array.length == 0) {
            return -1;
        }
        return binarySearchHelper(array, 0, array.length-1, target);
    }

    private int binarySearchHelper(int[] array, int left, int right, int target) {
        if(left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if(target < array[mid]) {
            return binarySearchHelper(array, left, mid-1, target);
        }
        else if(target > array[mid]) {
            return binarySearchHelper(array, mid+1, right, target);
        }
        else {
            return mid;
        }

    }

}
