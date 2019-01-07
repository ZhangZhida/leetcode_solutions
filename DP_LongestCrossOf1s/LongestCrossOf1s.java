public class Solution {
    public int largest(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) {
        return 0;
      }
      
      // preprocessing prefix sum
      int row = matrix.length;
      int col = matrix[0].length;
      int[][] leftRight = LeftRight(matrix, row, col);
      int[][] rightLeft = RightLeft(matrix, row, col);
      int[][] topDown = TopDown(matrix, row, col);
      int[][] downTop = DownTop(matrix, row, col);
      
      // 2D scan
      int longest = 0;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          int curLongest = Math.min(rightLeft[i][j], leftRight[i][j]);
          curLongest = Math.min(curLongest, topDown[i][j]);
          curLongest = Math.min(curLongest, downTop[i][j]);
          longest = Math.max(curLongest, longest);
        }
      }
      return longest;
      
    }
    
    private int[][] LeftRight(int[][] matrix, int row, int col) {
      int[][] prefixSum = new int[row][col];
      for (int i = 0; i < row; i++) {
        prefixSum[i][0] = matrix[i][0];
      }
      for (int i = 0; i < row; i++) {
        for (int j = 1; j < col; j++) {
          prefixSum[i][j] = matrix[i][j] == 1 ? prefixSum[i][j-1] + 1 : 0;
        }
      }
      return prefixSum;
    }
    
    private int[][] RightLeft(int[][] matrix, int row, int col) {
      int[][] prefixSum = new int[row][col];
      for (int i = 0; i < row; i++) {
        prefixSum[i][col-1] = matrix[i][col-1];
      }
      for (int i = 0; i < row; i++) {
        for (int j = col-2; j >= 0; j--) {
          prefixSum[i][j] = matrix[i][j] == 1 ? prefixSum[i][j+1] + 1 : 0;
        }
      }
      return prefixSum;
    }
    
    private int[][] TopDown(int[][] matrix, int row, int col) {
      int[][] prefixSum = new int[row][col];
      for (int j = 0; j < col; j++) {
        prefixSum[0][j] = matrix[0][j];
      }
      for (int j = 0; j < col; j++) {
        for (int i = 1; i < row; i++) {
          prefixSum[i][j] = matrix[i][j] == 1 ? prefixSum[i-1][j] + 1 : 0;
        }
      }
      return prefixSum;
    }
    
    private int[][] DownTop(int[][] matrix, int row, int col) {
      int[][] prefixSum = new int[row][col];
      for (int j = 0; j < col; j++) {
        prefixSum[row-1][j] = matrix[row-1][j];
      }
      for (int j = 0; j < col; j++) {
        for (int i = row - 2; i >= 0; i--) {
          prefixSum[i][j] = matrix[i][j] == 1 ? prefixSum[i+1][j] + 1 : 0;
        }
      }
      return prefixSum;
    }
  }