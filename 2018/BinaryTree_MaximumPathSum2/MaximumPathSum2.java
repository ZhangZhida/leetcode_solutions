// Description: 

// Given a binary tree in which each node contains an integer number. 
// Find the maximum possible sum from any node to any node (the start 
// node and the end node can be the same). 



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
      helper(root, max);
      return max[0];
    }
    
    private int helper(TreeNode root, int[] max) {
      if(root == null) {
        return 0;
      }
      int left = helper(root.left, max);
      int right = helper(root.right, max);
      left = left > 0 ? left : 0;
      right = right > 0 ? right : 0;
      max[0] = Math.max(max[0], root.key + left + right);
      
      return root.key + Math.max(left, right);
    }
  }
  