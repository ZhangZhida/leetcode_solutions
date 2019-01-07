// Time: O(n^4)
// Space: O(n^2)

public class Solution {
    public int largest(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        return 0;
      }
      int row = matrix.length;
      int col = matrix[0].length;
      int[][] prefixSum = PrefixSum2D(matrix, row, col);
      
      int largest = Integer.MIN_VALUE;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          for (int l = 0; l <= i; l++) {
            for (int m = 0; m <= j; m++) {
              int left = (m - 1 >= 0) ? prefixSum[i][m-1] : 0;
              int up = (l - 1 >= 0) ? prefixSum[l-1][j] : 0;
              int upLeft = (m - 1 >= 0 && l - 1 >= 0) ? prefixSum[l-1][m-1] : 0;
              largest = Math.max(largest, prefixSum[i][j] - up - left + upLeft);
            }
          }
        }
      }
      return largest;
    }
    
    private int[][] PrefixSum2D(int[][] matrix, int row, int col) {
      int[][] prefix = new int[row][col];
      // 1D prefix sum from left to right
      for (int i = 0; i < row; i++) {
        prefix[i][0] = matrix[i][0];
      }
      for (int i = 0; i < row; i++) {
        for (int j = 1; j < col; j++) {
          prefix[i][j] = prefix[i][j-1] + matrix[i][j];
        }
      }
      // 2D prefix sum from left to right, while from up to down
      for (int j = 0; j < col; j++) {
        for (int i = 1; i < row; i++) {
          prefix[i][j] = prefix[i][j] + prefix[i-1][j];
        }
      }
      return prefix;
    }
  }