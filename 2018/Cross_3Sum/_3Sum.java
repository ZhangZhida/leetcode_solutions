// Time: O(n^2)
// Space: O(1)

public class Solution {
  public List<List<Integer>> allTriples(int[] array, int target) {
    // Assumptions: input array has length of at least 3
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Arrays.sort(array);
    for (int i = 0; i < array.length - 2; i++) {
      if (i > 0 && array[i] == array[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = array.length - 1;
      while (left < right) {
        if (left > i + 1 && array[left] == array[left - 1]) {
          left++;
          continue;
        }
        int sum2 = array[left] + array[right];
        if (sum2 + array[i] == target) {
          result.add(Arrays.asList(array[i], array[left], array[right]));
          left++;
          right--;
        } else if (sum2 + array[i] < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return result;
  }
}