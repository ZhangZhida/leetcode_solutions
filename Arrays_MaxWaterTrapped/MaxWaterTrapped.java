public class Solution {
    public int maxTrapped(int[] array) {
      // Write your solution here
      if (array == null || array.length == 0) {
        return 0;
      }
      int i = 0;
      int j = array.length - 1;
      int maxLeft = array[0];
      int maxRight = array[array.length - 1];
      int maxWater = 0;
      while (i < j) {
        if (maxLeft < maxRight) {
          maxWater += maxLeft - array[i];
          i++;
          maxLeft = Math.max(array[i], maxLeft);
        } else {
          maxWater += maxRight - array[j];
          j--;
          maxRight = Math.max(array[j], maxRight);
        }
      }
      return maxWater;
    }
  }
  