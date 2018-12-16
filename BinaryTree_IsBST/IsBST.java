// Time: O(n)
// Space: O(height)

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
    public boolean isBST(TreeNode root) {
      // Write your solution here
      if (root == null) {
        return true;
      } 
      return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    private boolean isBST(TreeNode root, int large, int small) {
      if (root == null) {
        return true;
      }
      if (root.key < large && root.key > small) {
        return isBST(root.left, root.key, small) && isBST(root.right, large, root.key);
      } else {
        return false;
      }
    }
  }