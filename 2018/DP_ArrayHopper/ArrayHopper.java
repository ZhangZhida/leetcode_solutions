// Time:  O(n^2)
// Space: O(n)

public class Solution {
    public boolean canJump(int[] array) {
      // Assumptions: the given array is not null and has length of at least 1
      // the ith is true if there's a way to jump from ith element of array to the target
      boolean[] canReach = new boolean[array.length]; 
      
      canReach[array.length - 1] = true;
      for (int i = array.length - 2; i >= 0; i--) {
        int range  = array[i];
        boolean curCanReach = false;
        for (int j = i + 1; j <= i + range; j++) {
          if (canReach[j] == true) {
            curCanReach = true;
            break;
          }
        }
        canReach[i] = curCanReach;
      }
      return canReach[0];
    }
  }