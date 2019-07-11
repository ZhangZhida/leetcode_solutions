// Time: O(nlogn)
// Space: O(1)

public class Solution {
    public List<List<Integer>> allPairs(int[] array, int target) {
      // Assumption: the given array is not null and has length of at least 2
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      Arrays.sort(array);
      int left = 0;
      int right = array.length - 1;
      while (left < right) {
        if (left > 0 && array[left] == array[left - 1]) {
          left++;
          continue;
        }
        int sum = array[left] + array[right];
        if (sum == target) {
          result.add(Arrays.asList(array[left], array[right]));
          left++;
          right--;
        } else if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
      return result;
    }
  }