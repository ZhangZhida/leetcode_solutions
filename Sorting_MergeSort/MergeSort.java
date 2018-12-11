public class Solution {
    public int[] mergeSort(int[] array) {
      // Write your solution here
      if (array == null || array.length == 0 || array.length == 1) {
        return array;
      }
      int[] helper = new int[array.length];
      mergeSort(array, helper, 0, array.length - 1);
      return helper;
    }
    
    private void mergeSort(int[] array, int[] helper, int left, int right) {
      if (left >= right) {
        helper[left] = array[left];
        return;
      }
      int mid = left + (right - left) / 2;
      mergeSort(array, helper, left, mid);
      mergeSort(array, helper, mid + 1, right);
      merge(array, helper, left, mid, right);
    }
    
    private void merge(int[] array, int[] helper, int left, int mid, int right) {
      for (int i = left; i <= right; i++) {
        array[i] = helper[i];
      }
      int idx = left;
      int curLeft = left;
      int curRight = mid + 1;
      while (curLeft <= mid && curRight <= right) {
        if (array[curLeft] < array[curRight]) {
          helper[idx++] = array[curLeft++];
        } else {
          int value = array[curRight++];
          helper[idx++] = value;
        }
      }
      while (curLeft <= mid) {
        helper[idx++] = array[curLeft++];
      }
      while (curRight <= right) {
        helper[idx++] = array[curRight++]; 
      }
    }
  }