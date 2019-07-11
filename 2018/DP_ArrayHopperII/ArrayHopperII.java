// Time: O(n^2)
// Space: O(n)

public class Solution {
    public int minJump(int[] array) {
      int[] M = new int[array.length];
      M[array.length - 1] = 0;
      for (int i = array.length - 2; i >= 0; i--) {
        int minJump = Integer.MAX_VALUE;
        for (int j = i + 1; j <= i + array[i] ; j++) {
          if (j <= array.length - 1 && M[j] != -1) {
            minJump = Math.min(minJump, 1 + M[j]);
          }
        }
        M[i] = minJump == Integer.MAX_VALUE ? -1 : minJump;
      }
      return M[0];
    }
  }