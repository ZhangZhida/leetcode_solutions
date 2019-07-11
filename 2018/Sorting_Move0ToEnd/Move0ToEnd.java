
// Time: O(n)
// Space: O(1)

public class Solution {
    public int[] moveZero(int[] array) {
      // Write your solution here
      int i = 0; // all the elements on the left not included of index i is the non-zero.
      int j = 0; // linear scan
      while (j < array.length) {
        if (array[j] != 0) {
          array[i++] = array[j++];
        } else {
          j++;
        }
      }
      while (i < array.length) {
        array[i++] = 0;
      }
      return array;
    }
  }