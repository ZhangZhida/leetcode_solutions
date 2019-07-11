public class Solution {
    public int[] dedup(int[] array) {
      if (array.length <= 1) {
        return array;
      }
      int fast = 1;
      int slow = 1;
      while (fast < array.length) {
        if (slow == 0 || array[fast] != array[slow - 1]) {
          array[slow++] = array[fast++];
        } else {
          while (fast < array.length && array[fast] == array[slow - 1]) {
            fast++;
          }
          slow--;
        }
      }
      return Arrays.copyOf(array, slow);
    }
  }