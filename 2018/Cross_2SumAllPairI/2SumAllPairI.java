// Time: average O(n), worst O(n^2)
// Space: O(n)

public class Solution {
    public List<List<Integer>> allPairs(int[] array, int target) {
      // Assumptions: the input array is not null and has length of length of at least 2
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      HashMap<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < array.length; i++) {
        List<Integer> indices = map.get(target - array[i]);
        if (indices != null) {
          for (int index : indices) {
            result.add(Arrays.asList(index, i));
          }
        }
        if (!map.containsKey(array[i])) {
          map.put(array[i], new ArrayList<Integer>());
        }
        map.get(array[i]).add(i);
      }
      return result;
    }
  }