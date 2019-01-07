public class Solution {
    public int[] dedup(int[] array) {
      // assumptions: input array is not null
      if (array.length <= 1) {
        return array;
      }
      int slow = 1;
      int fast = 1;
      while (fast < array.length) {
        if (array[fast] != array[fast - 1]) {
          array[slow++] = array[fast++];
        } else {
          while (fast < array.length && array[fast] == array[fast - 1]) {
            fast++;
          }
          if (slow > 0) {
            slow--;
          }
        }
      }
      return Arrays.copyOfRange(array, 0, slow);
    }
  }