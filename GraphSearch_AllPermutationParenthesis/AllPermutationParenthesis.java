// Data Structure
// Time: O(2^n)
// Space: O(1)

public class Solution {
    public List<String> validParentheses(int n) {
      // Write your solution here
      List<String> result = new ArrayList<>();
      if (n == 0) {
        return result;
      }
      StringBuilder sb = new StringBuilder();
      DFS(n, 0, 0, sb, result);
      return result;
      
    }
    
    public void DFS(int n, int left, int right, StringBuilder sb, List<String> result) {
      if (left == n && right == n) {
        result.add(sb.toString());
        return;
      }
      if (left < n) {
        sb.append("(");
        DFS(n, left + 1, right, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      }
      if (left > right) {
        sb.append(")");
        DFS(n, left, right + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
  