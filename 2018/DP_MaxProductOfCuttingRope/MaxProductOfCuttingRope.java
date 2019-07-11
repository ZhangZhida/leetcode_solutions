// Time: O(n^2)
// Space: O(n)

public class Solution {
    public int maxProduct(int length) {
      // Assumptions: n >= 2;
      int[] DP = new int[length + 1]; // M[i] is the maxProduct of the rope with length i
      DP[0] = 0;
      DP[1] = 1;
      for (int i = 2; i <= length; i++) {
        int maxProd = 0;
        for (int j = 1; j <= i / 2; j++) {
          maxProd = Math.max(maxProd, Math.max(j, DP[j]) * Math.max(i - j, DP[i - j]));
        }
        DP[i] = maxProd;
      }
      return DP[length];
    }
  }