// Time: O(n)
// Space: O(1)

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
    public boolean isBalanced(TreeNode root) {
      // Write your solution here
      if (helper(root) == -1) {
        return false;
      } else {
        return true;
      }
    }
    
    private int helper(TreeNode root) {
      if (root == null) {
        return 0;
      } 
      int left = helper(root.left);
      if (left == -1) {
        return -1;
      }
      int right = helper(root.right);
      if (right == -1) {
        return -1;
      }
      if (Math.abs(left - right) > 1) {
        return -1;
      }
      return Math.max(left, right) + 1;
    }
  }