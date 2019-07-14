public class Solution {
    public int largestSum(int[] array) {
      // Assumption: the given array is not null and has length of at least 1
      int length = array.length;
      int[] M = new int[length];  // M[i] means the largest subarray sum with the i to be the end index
      M[0] = array[0];
      int globalMax = M[0];
  
      for (int i = 1; i < length; i++) {
        if (M[i-1] <= 0) {
          M[i] = array[i];
        } else {
          M[i] = array[i] + M[i-1];
        }
        globalMax = Math.max(M[i], globalMax);
      }
      return globalMax;
    }
  }