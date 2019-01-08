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
    public List<Integer> zigZag(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }
      Deque<TreeNode> deque = new ArrayDeque<>();
      deque.offerFirst(root);
      int level = 0;
      while (!deque.isEmpty()) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
          if (level % 2 == 1) {
            TreeNode node = deque.pollLast();
            result.add(node.key);
            if (node.left != null) {
              deque.offerFirst(node.left);
            }
            if (node.right != null) {
              deque.offerFirst(node.right);
            }
          } else {
            TreeNode node = deque.pollFirst();
            result.add(node.key);
            if (node.right != null) {
              deque.offerLast(node.right);
            }
            if (node.left != null) {
              deque.offerLast(node.left);
            }
          }
        }
        level++;
      }
      return result;
    }
  }