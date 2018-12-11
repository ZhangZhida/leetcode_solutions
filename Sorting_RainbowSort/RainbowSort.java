// Time: O(n)
// Space: O(1)

public class Solution {
    public int[] rainbowSort(int[] array) {
      // Write your solution here
      if (array == null || array.length == 0) {
        return array;
      }
      int i = 0; // all elements on the left of i(not included) is -1;
      int j = 0; // all elements between [i, j) is 0;
      int k = array.length - 1; // all elements on the right of k(not included) is 1;
      while (j <= k) {
        if (array[j] == -1) {
          swap(array, i++, j++);
        } else if (array[j] == 0) {
          j++;
        } else {
          swap(array, j, k--);
        }
      }
      return array;
    }
    
    private void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }