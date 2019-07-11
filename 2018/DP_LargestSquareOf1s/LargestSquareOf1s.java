// Time:  O(n^2)
// Space: O(n^2)

public class Solution {
    public int largest(int[][] matrix) {
      // Write your solution here
      int row = matrix.length;
      int col = matrix[0].length;
      int[][] M = new int[row][col];
      for (int i = 0; i < row; i++) {
        M[i][0] = matrix[i][0] == 1 ? 1 : 0;
      }
      for (int j = 0; j < col; j++) {
        M[0][j] = matrix[0][j] == 1 ? 1 : 0;
      }
      
      int max = M[0][0];
      for (int i = 1; i < row; i++) {
        for(int j = 1; j < col; j++) {
          if (matrix[i][j] == 0) {
            M[i][j] = 0;
          } else {
            M[i][j] = Math.min(Math.min(M[i-1][j] + 1, M[i][j-1] + 1), M[i-1][j-1] + 1);
            max = Math.max(max, M[i][j]);
          }
        }
      }
      return max;
    }
  }