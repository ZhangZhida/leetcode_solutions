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
    // recursion implementation
    public List<Integer> preOrder1(TreeNode root) {
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

    // iterative implementation
    public List<Integer> preOrder2(TreeNode root) {
        // Write your solution here
        List<Integer> list = new ArrayList<>();
        if (root == null) {
          return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
          TreeNode node = stack.pollFirst();
          if (node.right != null) {
            stack.offerFirst(node.right);
          }
          if (node.left != null) {
            stack.offerFirst(node.left);
          }
          list.add(node.key);
        }
        return list;
      }
  }