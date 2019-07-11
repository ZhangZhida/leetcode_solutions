// Time: O(n)
// Space: O(Height)

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
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
      // Write your solution here
      if (one == null && two == null) {
        return true;
      } else if (one == null || two == null) {
        return false;
      } else {
        if (one.key != two.key) {
          return false;
        }
        boolean match1 = isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
        boolean match2 = isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
        return match1 || match2;
      }
    }
  }