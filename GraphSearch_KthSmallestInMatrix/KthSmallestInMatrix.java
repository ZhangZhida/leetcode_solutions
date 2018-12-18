// Time: O(n)
// Space: O(n)

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
      // Write your solution here
      PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>() {
        @Override
        public  int compare(Cell c1, Cell c2) {
          if (c1.value == c2.value) {
            return 0;
          }
          return c1.value < c2.value ? -1 : 1;
        }
      });
      int count = 0;
      int width = matrix.length;
      int height = matrix[0].length;
      
      Cell root = new Cell(0, 0, matrix[0][0]);
      pq.offer(root);
      boolean[][] visited = new boolean[width][height];
      int result = root.value;
      while (count < k) {
        Cell cell = pq.poll();
        result = cell.value;
        int m = cell.m;
        int n = cell.n;
        if (m + 1 < width && !visited[m + 1][n]) {
          Cell cellRight = new Cell(m + 1, n, matrix[m+1][n]);
          pq.offer(cellRight);
          visited[m + 1][n] = true;
        }
        if (n + 1 < height && !visited[m][n + 1]) {
          Cell cellDown = new Cell(m, n + 1, matrix[m][n+1]);
          pq.offer(cellDown);
          visited[m][n + 1] = true;
        }
        count++;
      }
      return result;
    }
  }
  
  class Cell{
    int m;
    int n;
    int value;
    public Cell(int m, int n, int value) {
      this.m = m;
      this.n = n;
      this.value = value;
    }
  }