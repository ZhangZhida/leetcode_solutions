public class Solution {
    public int[] dedup(int[] array) {
      if (array.length == 0) {
        return array;
      }
      int fast = 0;
      int slow = 0;
      while (fast < array.length) {
        if (fast == 0 || array[fast] != array[fast - 1]) {
          array[slow++] = array[fast++];
        } else {
          fast++;
        }
      }
      return Arrays.copyOfRange(array, 0, slow);
    }
  }