// Time: O(nlogn)
// Space: O(1)

public class Solution {
    public boolean existSum(int[] array, int target) {
      // Assumptions: the input array is not null and has length at least 2
      //QuickSort(array, 0, array.length);
      Arrays.sort(array);
      int left = 0;
      int right = array.length - 1;
      while (left < right) {
        if (array[left] + array[right] == target) {
          return true;
        } else if (array[left] + array[right] < target) {
          left++;
        } else {
          right--;
        }
      }
      return false;
    }
    
    /*
    private void QuickSort(int[] array, int left, int right) {
      if (right - left <= 1) {
        return;
      }
      int pivot = array[right - 1];
      int slow = left; 
      int fast = right - 2;
      while (slow < fast) {
        if (array[fast] > pivot) {
          fast--;
        } else if (array[slow] <= pivot) {
          slow++;
        } else {
          swap(array, slow, fast);
        }
      }
      swap(array, fast + 1, right - 1);
      QuickSort(array, left, fast + 1);
      QuickSort(array, fast + 2, right - 1);
    }
    */
    
    private void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }