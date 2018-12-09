public class Solution {

    //-- Recursion version --//
    public List<Integer> inOrder(TreeNode root) {
      // Write your solution here
      // base case
      List<Integer> list = new LinkedList<>();
      if(root == null) {
        return list;
      }
      // children
      List<Integer> left = inOrder(root.left);
      List<Integer> right = inOrder(root.right);
      left.add(root.key);
      left.addAll(right);
      return left;
    }

    //-- Recursion version --//
    
  }