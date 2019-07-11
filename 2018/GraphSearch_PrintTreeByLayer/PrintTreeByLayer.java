// Time: O(n)
// Space: O(n)

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
    public List<List<Integer>> layerByLayer(TreeNode root) {
      // Write your solution here
      List<List<Integer>> list = new LinkedList<List<Integer>>();
      if (root == null) {
        return list;
      }
      Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
      queue.offer(root);
      while (queue.size() != 0) {
        List<Integer> sublist = new LinkedList<>();
        int count = queue.size();
        for (int i = 0; i < count; i++) {
          TreeNode node = queue.poll();
          sublist.add(node.key);
          if (node.left != null) {
            queue.offer(node.left);
          }
          if (node.right != null) {
            queue.offer(node.right);
          }
        }
        list.add(sublist);
      }
      return list;
    }
  }

