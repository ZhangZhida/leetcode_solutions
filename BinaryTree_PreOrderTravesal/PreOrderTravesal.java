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
    public List<Integer> preOrder(TreeNode root) {
      // Write your solution here
      List<Integer> list = new LinkedList<>();
      helper(root, list);
      return list;
    }
    
    private void helper(TreeNode root, List<Integer> list) {
      if (root == null) {
        return;
      }
      list.add(root.key);
      helper(root.left, list);
      helper(root.right, list);
      return;
    }
  }