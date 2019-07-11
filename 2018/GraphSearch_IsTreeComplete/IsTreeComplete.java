// Time: O(n)
// Time: O(n), queue

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
    public boolean isCompleted(TreeNode root) {
      // Write your solution here
      if (root == null) {
        return true;
      }
      Deque<TreeNode> queue = new ArrayDeque<>();
      queue.offer(root);
      boolean flag = false; // shouldn't have child if true;
      while (!queue.isEmpty()) {
        int count = queue.size();
        for (int i = 0; i < count; i++) {
          TreeNode node = queue.poll();
          if (node.left != null) {
            if (flag) {
              return false;
            } else {
              queue.offer(node.left);
            }
          } else {
            flag = true;
          }
          if (node.right != null) {
            if (flag) {
              return false;
            } else {
              queue.offer(node.right);
            }
          } else {
            flag = true;
          }
        }
      }
      return true;
    }
  }
  