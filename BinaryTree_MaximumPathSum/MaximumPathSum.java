// Description:

// Given a binary tree in which each node contains an integer number.
// Find the maximum possible subpath sum(both the starting and ending node of the 
// subpath should be on the same path from root to one of the leaf nodes, 
// and the subpath is allowed to contain only one node).

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
    public int maxPathSum(TreeNode root) {
      // Write your solution here
      int[] max = new int[1];
      max[0] = root.key;
      int sum = 0;
      helper(root, max, sum);
      return max[0];
    }
     
    private void helper(TreeNode root, int[] max, int sum) {
      if(root == null) {
        return;
      }
      if(sum > 0) {
        sum += root.key;
      } else {
        sum = root.key;
      }
      max[0] = max[0] > sum ? max[0] : sum;
      helper(root.left, max, sum);
      helper(root.right, max, sum);
      return;
    }
  }
  