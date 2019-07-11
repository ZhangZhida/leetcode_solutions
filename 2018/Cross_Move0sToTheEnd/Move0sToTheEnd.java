public class Solution {
    public int[] moveZero(int[] array) {
      if (array.length <= 1) {
        return array;
      }
      int fast = 0; 
      int slow = 0;
      while (fast < array.length) {
        if (array[fast] != 0) {
          array[slow++] = array[fast++];
        } else {
          fast++;
        }
      }
      for (int i = slow; i < array.length; i++) {
        array[i] = 0;
      }
      return array;
    }
    
    private void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }