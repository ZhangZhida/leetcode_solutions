// Time: O(n^2)
// Space: O(n^2)

public class Solution {
    public int largest(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        return 0;
      }
      
      // preprocess, build prefix sum matrix
      int row = matrix.length;
      int col = matrix[0].length;
      int[][] degree45 = Degree45(matrix, row, col);
      int[][] degree135 = Degree135(matrix, row, col);
      int[][] degree225 = Degree225(matrix, row, col);
      int[][] degree315 = Degree315(matrix, row, col);
      
      // 2D scan
      int longest = 0;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          int curLongest = Math.min(degree45[i][j], degree135[i][j]);
          curLongest = Math.min(degree225[i][j], curLongest);
          curLongest = Math.min(degree315[i][j], curLongest);
          longest = Math.max(longest, curLongest);
        }
      }
      return longest;
    }
    
    private int[][] Degree45(int[][] matrix, int row, int col) {
      int[][] prefix = new int[row][col];
      for (int j = 0; j < col; j++) {
        prefix[row-1][j] = matrix[row-1][j];
      }
      for (int i = 0; i < row; i++) {
        prefix[i][0] = matrix[i][0];
      }
      for (int j = 1; j < col; j++) {
        for (int i = row-2; i >= 0; i--) {
          prefix[i][j] = matrix[i][j] == 1 ? prefix[i+1][j-1] + 1 : 0;
        }
      }
      return prefix;
    }
    
    private int[][] Degree135(int[][] matrix, int row, int col) {
      int[][] prefix = new int[row][col];
      for (int j = 0; j < col; j++) {
        prefix[0][j] = matrix[0][j];
      }
      for (int i = 0; i < row; i++) {
        prefix[i][0] = matrix[i][0];
      }
      for (int j = 1; j < col; j++) {
        for (int i = 1; i < row; i++) {
          prefix[i][j] = matrix[i][j] == 1 ? prefix[i-1][j-1] + 1 : 0;
        }
      }
      return prefix;
    }
    
    private int[][] Degree225(int[][] matrix, int row, int col) {
      int[][] prefix = new int[row][col];
      for (int j = 0; j < col; j++) {
        prefix[0][j] = matrix[0][j];
      }
      for (int i = 0; i < row; i++) {
        prefix[i][col-1] = matrix[i][col-1];
      }
      for (int j = col-2; j>=0; j--) {
        for (int i = 1; i < row; i++) {
          prefix[i][j] = matrix[i][j] == 1 ? prefix[i-1][j+1] + 1 : 0;
        }
      }
      return prefix;
    }
    
    private int[][] Degree315(int[][] matrix, int row, int col) {
      int[][] prefix = new int[row][col];
      for (int j = 0; j < col; j++) {
        prefix[row-1][j] = matrix[row-1][j];
      }
      for (int i = 0; i < row; i++) {
        prefix[i][col-1] = matrix[i][col-1];
      }
      for (int j = col-2; j >= 0; j--) {
        for (int i = row-2; i >= 0; i--) {
          prefix[i][j] = matrix[i][j] == 1 ? prefix[i+1][j+1] + 1 : 0;
        }
      }
      return prefix;
    }
  }