/* 
    Given a integer dictionary A of unknown size, where the numbers in the dictionary are 
    sorted in ascending order, determine if a given target integer T is in the dictionary.
    Return the index of T in A, return -1 if T is not in A.
*/

/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
    public int search(Dictionary dict, int target) {
      // Write your solution here
      int left = 0;
      int right = 1;
      while(dict.get(right) != null && target > dict.get(right)) {
        left = right;
        right = right * 2;
      }
      return binarySearch(dict, target, left, right);
    }
    private int binarySearch(Dictionary dict, int target, int left, int right) {
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if(dict.get(mid) == null || target < dict.get(mid)) {
          right = mid - 1;
        } else if (target > dict.get(mid)) {
          left = mid + 1;
        } else {
          return mid;
        }
      }
      return -1;
    }
  }