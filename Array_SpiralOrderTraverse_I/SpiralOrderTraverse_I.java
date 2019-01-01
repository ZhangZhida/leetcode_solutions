
public class Solution {
    /**
     *  Method 1: traversal direction control
     */
    public List<Integer> spiralI(int[][] matrix) {
      // Write your solution here
      int rowNum = matrix.length;
      int colNum = matrix[0].length;
      boolean[][] bMatrix = new boolean[rowNum][colNum];
      int[] dir = new int[]{0, 1};
      int i = 0;
      int j = 0;
      // base case
      List<Integer> result = new ArrayList<>();
      if (rowNum == 1 && colNum == 1) {
        result.add(matrix[0][0]);
        return result;
      }
      
      while (bMatrix[i][j] != true) {
        result.add(matrix[i][j]);
        bMatrix[i][j] = true;
        
        if (i + dir[0] >= 0 && i + dir[0] < rowNum && j + dir[1] >= 0 && j + dir[1] < colNum) {
          if (bMatrix[i + dir[0]][j + dir[1]] == true) {
            changeDirection(dir);
          }
        } else {
          changeDirection(dir);
        }
        i = i + dir[0];
        j = j + dir[1];
      }
      return result;
    }
    
    public void changeDirection(int[] dir) {
      if (dir[0] == 1 && dir[1] == 0) {
        dir[0] = 0;
        dir[1] = -1;
      } else if (dir[0] == 0 && dir[1] == 1) {
        dir[0] = 1;
        dir[1] = 0;
      } else if (dir[0] == -1 && dir[1] == 0) {
        dir[0] = 0;
        dir[1] = 1;
      } else {
        dir[0] = -1;
        dir[1] = 0;
      }
    }

    /**
     *  Method 2: recursive 
     */
    public List<Integer> spiralII(int[][] matrix) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        traverse(matrix, 0, matrix.length, result);
        return result;
      }
      
      public void traverse(int[][] matrix, int offset, int size, List<Integer> result) {
        // base case
        if (size == 0) {
          return;
        } 
        if (size == 1) {
          result.add(matrix[offset][offset]);
          return;
        }
        for (int i = 0; i < size; i++) {
          result.add(matrix[offset][offset + i]);
        }
        for (int j = 1; j < size; j++) {
          result.add(matrix[offset + j][offset + size - 1]);
        }
        for (int i = size - 2; i >= 0; i--) {
          result.add(matrix[offset + size - 1][offset + i]);
        }
        for (int j = size - 2; j >= 1; j--) {
          result.add(matrix[offset + j][offset]);
        }
        traverse(matrix, offset + 1, size - 2, result);
      }
  }