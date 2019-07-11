/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
    public String[] binaryTreePaths(TreeNode root) {
      // Write your solution here
      if  (root == null) {
        return new String[0];
      }
      List<String> result = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      helper(root, result, sb);
      String[] paths = new String[result.size()];
      paths = result.toArray(paths);
      return paths;
      
    }
    void helper(TreeNode root, List<String> result, StringBuilder sb) {
      if (root.left == null && root.right == null) {
        int len = sb.length();
        sb.append(root.key);
        result.add(sb.toString());
        sb.delete(len, sb.length());
        return;
      } else {
        int len = sb.length();
        sb.append(root.key);
        sb.append("->");
        if (root.left != null) {
          helper(root.left, result, sb);
        }
        if (root.right != null) {
          helper(root.right, result, sb);
        }
        //sb.deleteCharAt(sb.length() - 1);
        sb.delete(len, sb.length());
      }
    }
  }
  