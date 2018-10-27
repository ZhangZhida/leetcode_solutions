public class BinarySearch_SearchInSortedMatrix {

    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        int rowIndex = getRowIndex(matrix, target);
        int colIndex = getColIndex(matrix, target, rowIndex);
        if(colIndex == -1) {
            return new int[] {-1, -1};
        }
        else {
            return new int[] {rowIndex, colIndex};
        }

    }

    private int getColIndex(int[][] matrix, int target, int rowIndex) {
        return getColIndexHelper(matrix[rowIndex], 0, matrix[rowIndex].length-1, target);
    }

    private int getColIndexHelper(int[] array, int left, int right, int target) {
        // corner case
        if(array == null || array.length == 0) {
            return -1;
        }

        // cannot find
        if(left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if(target < array[mid]) {
            return getColIndexHelper(array, left, mid - 1, target);
        }
        else if(target > array[mid]) {
            return getColIndexHelper(array, mid + 1, right, target);
        }
        else {
            return mid;
        }


    }

    private int getRowIndex(int[][] matrix, int target) {
        return getRowIndexHelper(matrix, 0, matrix.length - 1, target);
    }

    private int getRowIndexHelper(int[][] matrix, int up, int down, int target) {
        // base case
        if(down - up <= 1) {
            if(target > matrix[down][0])
                return down;
            else
                return up;
        }

        int mid = up + (down - up) / 2;
        if(target < matrix[mid][0]) {
            return getRowIndexHelper(matrix, up, mid, target);
        }
        else if(target > matrix[mid][0]) {
            return getRowIndexHelper(matrix, mid, down, target);
        } else {
            return mid;
        }
    }
}
