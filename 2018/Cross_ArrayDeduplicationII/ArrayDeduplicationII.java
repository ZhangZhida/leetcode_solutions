public class Solution {
    public int[] dedup(int[] array) {
      // Assumptions: array is not null
      if (array.length <= 2) {
        return array;
      }
      int[] head = Arrays.copyOfRange(array, 0, 2);
      int fast = 2;
      int slow = 0;
      while (fast < array.length) {
        if (array[fast] != array[fast - 1]) {
          array[slow++] = array[fast++];
        } else if (array[fast - 1] != array[fast - 2]) {
          array[slow++] = array[fast++];
        } else {
          fast++;
        }
      }
      
      // post-processing
      int[] tail = Arrays.copyOfRange(array, 0, slow);
      int[] result = new int[head.length + tail.length];
      for (int i = 0; i < head.length; i++) {
        result[i] = head[i];
      }
      for (int i = 0; i < tail.length; i++) {
        result[i + head.length] = tail[i];
      }
      return result;
    }
  }