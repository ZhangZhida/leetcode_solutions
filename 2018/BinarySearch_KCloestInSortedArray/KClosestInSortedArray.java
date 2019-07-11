// Given a target integer T, a non-negative integer K and an integer array A sorted
//  in ascending order, find the K closest numbers to T in A.

public class Solution {
    public int[] kClosest(int[] array, int target, int k) {
      // Write your solution here
      if (array == null || array.length == 0) {
        return new int[0];
      }
      if (k == 0) {
        return new int[k];
      }
      int left = 0;
      int right = array.length - 1;
      while (left < right - 1) {
        int mid = left + (right - left) / 2;
        if (target >= array[mid]) {
          left = mid;
        } else {
          right = mid;
        }
      }
      int[] res = new int[k];
      for (int i=0; i < k; i++) {
        if(left < 0 || (right <= array.length - 1 && target - array[left] > array[right] - target)) {
          res[i] = array[right++];
        } else {
          res[i] = array[left--];
        }
      }
      return res;
    }
  }
  