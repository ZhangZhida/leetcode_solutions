public class Solution {
    public List<Integer> spiral(int[][] matrix) {
      // Write your solution here
      List<Integer> result = new ArrayList<>();
      traverse(matrix, 0, matrix[0].length, matrix.length, result);
      return result;
    }
    public void traverse(int[][] matrix, int offset, int sizeX, int sizeY, List<Integer> result) {
      if (sizeX == 0 || sizeY == 0) {
        return;
      }
      if (sizeX == 1 || sizeY == 1) {
        for (int i = offset; i < offset + sizeX; i++) {
          for (int j = offset; j < offset + sizeY; j++) {
            result.add(matrix[j][i]);
          }
        }
        return;
      }
      for (int i = offset; i < offset + sizeX; i++) {
        result.add(matrix[offset][i]);
      }
      for (int i = offset + 1; i < offset + sizeY; i++) {
        result.add(matrix[i][offset + sizeX - 1]);
      }
      for (int i = offset + sizeX - 2; i >= offset; i--) {
        result.add(matrix[offset + sizeY - 1][i]);
      }
      for (int i = offset + sizeY - 2; i >= offset + 1; i--) {
        result.add(matrix[i][offset]);
      }
      
      traverse(matrix, offset + 1, sizeX - 2, sizeY - 2, result);
    }
  }