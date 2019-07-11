public class Solution {
    public int missing(int[] array) {
      // Write your solution here
      for (int i = 0; i < array.length; i++) {
        while (array[i] != i + 1 && array[i] != array.length + 1) {
          swap(array, i, array[i] - 1);
        }
      }
      for (int i = 0; i < array.length; i++) {
        if (array[i] != i + 1) {
          return i + 1;
        }
      }
      return array.length + 1;
    }
    
    public void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }