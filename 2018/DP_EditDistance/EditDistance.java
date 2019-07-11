// Time:  O(m*n)
// Space: O(m*n)

public class Solution {
    public int editDistance(String one, String two) {
      // Assumptions: both string are not null
      /** M[i][j] means the minimal distance 
      *   between the first i length of one and the first j length of two
      */
      int[][] M = new int[one.length() + 1][two.length() + 1];
      for (int i = 0; i < one.length() + 1; i++) {
        M[i][0] = i;
      }
      for (int j = 0; j < two.length() + 1; j++) {
        M[0][j] = j;
      }
      for (int i = 1; i < one.length() + 1; i++) {
        for (int j = 1; j < two.length() + 1; j++) {
          if (one.charAt(i - 1) == two.charAt(j - 1)) {
            M[i][j] = M[i - 1][j - 1];
          } else {
            M[i][j] = Math.min(Math.min(M[i - 1][j - 1] + 1, M[i - 1][j] + 1)
                               , M[i][j - 1] + 1);
          }
        }
      }
      return M[one.length()][two.length()];
    }
  }