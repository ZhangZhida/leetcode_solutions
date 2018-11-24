// Description:
// Given a binary tree in which each node contains an integer number. 
// Determine if there exists a path (the path can only be from one node to itself or to any of its descendants),
// the sum of the numbers on the path is the given target number. 

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
    public boolean exist(TreeNode root, int target) {
      // Write your solution here
      // pre-processing: path prefix sum
      Set<Integer> set = new HashSet<>();
      set.add(0);
      // dfs
      return dfs(root, set, 0, target);
    }
    
    private boolean dfs(TreeNode root, Set<Integer> pathPrefixSum, int prefixSum, int target) {
      if(root == null) {
        return false;
      } 
      prefixSum = prefixSum + root.key;
      if(pathPrefixSum.contains(prefixSum - target)) {
        return true;
      } else {
        boolean needRemove = pathPrefixSum.add(prefixSum);
        if(dfs(root.left, pathPrefixSum, prefixSum, target)) {
          return true;
        }
        if(dfs(root.right, pathPrefixSum, prefixSum, target)) {
          return true;
        }
        if(needRemove) {
          pathPrefixSum.remove(prefixSum);
        }
        return false;
      }
    }
  }