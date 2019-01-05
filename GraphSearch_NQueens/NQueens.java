public class Solution {
    public List<List<Integer>> nqueens(int n) {
      List<List<Integer>> solution = new ArrayList<List<Integer>>();
      List<Integer> cur = new ArrayList<>(); // 
      DFS(n, 0, cur, solution);
      return solution;
    }
    
    private void DFS(int n, int row, List<Integer> cur, List<List<Integer>> solution) {
      if (row == n) {
        List<Integer> newList = new ArrayList<>(cur);
        solution.add(newList);
        return;
      }
      
      for (int i = 0; i < n; i++) {
        if (valid(cur, i)) {
          cur.add(i);
          row++;
          DFS(n, row, cur, solution);
          cur.remove(cur.size() - 1);
          row--;
        }
      }
    }
  
    private boolean valid(List<Integer> cur, int col) {
      int row = cur.size();
      for (int i = 0; i < cur.size(); i++) {
        if (cur.get(i) == col || row - i == Math.abs(col - cur.get(i))) {
          return false;
        }
      }
      return true;
    }
  }