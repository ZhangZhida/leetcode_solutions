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

    // -- recursive version -- //
    public List<Integer> preOrder1(TreeNode root) {
      // Write your solution here
      // base case
      if(root == null) {
        List<Integer> result = new LinkedList<>();
        return result;
      }
      if(root.left == null && root.right == null) {
        List<Integer> list = new LinkedList<>();
        list.add(root.key);
        return list;
      }
      
      // pre-order
      List<Integer> result = preOrder2(root.left);
      result.add(0, root.key);
      result.addAll(preOrder2(root.right));
      return result;
    }

    // -- iterative version -- //
    public List<Integer> preOrder2(TreeNode root) {
        // Write your solution here
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
          return list;
        }  
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offerFirst(root);
        while(!stack.isEmpty()) {
          TreeNode cur = stack.pollFirst();
          if(cur.right != null) {
            stack.offerFirst(cur.right);
          }
          if(cur.left != null) {
            stack.offerFirst(cur.left);
          }
          list.add(cur.key);
        }
        return list;
      }
  }