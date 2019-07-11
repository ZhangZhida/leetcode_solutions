// Given a target integer T and an integer array A sorted in ascending order,
//  find the index of the last occurrence of T in A or return -1 if there is no such index.

public class Solution {
    public int lastOccur(int[] array, int target) {
      // Write your solution here
      if (array == null || array.length == 0) {
        return -1;
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
      if (array[right] == target) {
        return right;
      } else if (array[left] == target) {
        return left;
      }
      return -1;
    }
  }