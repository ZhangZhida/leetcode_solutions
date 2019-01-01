// method 1

public class Solution {
    public List<Integer> spiral(int[][] matrix) {
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
  }