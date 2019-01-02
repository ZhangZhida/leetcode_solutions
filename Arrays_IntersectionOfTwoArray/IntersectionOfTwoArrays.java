// Time: O(nlogn)
// Space: O(1)

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      // Write your solution here
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int i = 0;
      int j = 0;
      List<Integer> intersect = new ArrayList<>();
      while (i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j]) {
          intersect.add(nums1[i]);
          i++;
          j++;
        } else if (nums1[i] < nums2[j]){
          i++;
        } else {
          j++;
        }
      }
      
      int[] result = new int[intersect.size()];
      for (int k = intersect.size() -1; k >= 0; k--) {
        result[k] = (int)intersect.remove(k);
      }
      return result;
    }
  }