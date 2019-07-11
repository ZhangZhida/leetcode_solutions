// Time:  O(n)
// Space: O(1)

public class Solution {
    public int largestSum(int[] array) {
      int largest = Integer.MIN_VALUE;
      int curSum = 0;
      for (int i = 0; i < array.length; i++) {
        if (curSum > 0) {
          curSum += array[i];
        } else {
          curSum = array[i];
        }
        largest = Math.max(curSum, largest);
      }
      return largest;
    }
  }