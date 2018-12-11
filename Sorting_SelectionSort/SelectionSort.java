public class Solution {
    public int[] solve(int[] array) {
      // Write your solution here
      if (array == null || array.length == 1) {
        return array;
      }
      
      int smallest = -1;
      for (int i = 0; i < array.length; i++) {
        smallest = i;
        for (int j = i; j < array.length; j++) {
          if (array[j] < array[smallest]) {
            smallest = j;
          }
        }
        int temp = array[i];
        array[i] = array[smallest];
        array[smallest] = temp;
      }
      return array;
    }
  }