// Time: O(n)
// Space: O(n), HashMap and queue

/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
    public boolean isBipartite(List<GraphNode> graph) {
      // write your solution here
      boolean is = true;
      for (GraphNode node : graph) {
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        is = is && BFS(node, visited);
      }
      return is;
    }
    
    private boolean BFS(GraphNode root, HashMap<GraphNode, Integer> visited) {
      if (visited.containsKey(root)) {
        return true;
      }
      Deque<GraphNode> queue = new ArrayDeque<>();
      queue.offer(root);
      int flag = 0;
      while (!queue.isEmpty()) {
        int count = queue.size();
        flag = (flag == 0) ? 1 : 0;
        for (int i = 0; i < count; i++) {
          GraphNode node = queue.poll();
          if (visited.containsKey(node)) {
            if (visited.get(node) != flag) {
              return false;
            }
          } else {
            visited.put(node, flag);
            for (GraphNode neigh: node.neighbors) {
              if (!visited.containsKey(neigh)) {
                queue.offer(neigh);
              }
            }
          }
        }
      }
      return true;
    }
  }