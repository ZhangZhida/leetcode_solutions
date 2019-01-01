public class Solution {
    public int[] moveZeroes(int[] nums) {
      // Write your solution here
      int slow = 0; // the left not including slow are non-zeros
      int fast = 0; // the right including fast are the elements to scan
      while (fast < nums.length) {
        if (nums[fast] == 0) {
          fast++;
        } else {
          swap(nums, fast, slow);
          slow++;
          fast++;
        }
      }
      return nums;
    }
    
    public void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }