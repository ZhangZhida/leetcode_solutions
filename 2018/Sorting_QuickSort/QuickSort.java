
// Time: average O(nlogn), worst O(n^2)
// Space: O(1)
public class Solution {
    public int[] quickSort(int[] array) {
      // Write your solution here
      if (array == null) {
        return null;
      }
      quickSort(array, 0, array.length - 1);
      return array;
    }
    
    private void quickSort(int[] array, int left, int right) {
      if (right - left <= 0) {
        return;
      }
      int mid = partition(array, left, right); // all those left numbers are smaller than pivot
      quickSort(array, left, mid -1 );
      quickSort(array, mid + 1, right);
    }
    
    private int partition(int[] array, int left, int right) {
      if (right - left <= 0) {
        return left;
      }
      int i = left;
      int j = right - 1;
      int pivot = array[right];
      while (i <= j) {
        if (array[i] < pivot) {
          i++;
        } else if (array[j] >= pivot) {
          j--;
        } else {
          swap(array, i, j);
          i++;
          j--;
        }
      } 
      swap(array, i, right);
      return i;
    }
    
    private void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
    
  }