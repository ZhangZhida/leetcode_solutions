public class Solution {
    public int sqrt(int x) {
      // find max boundary
      int i = 1;
      while (true) {
        if (i * i == x) {
          return i;
        } else if (i * i < x) {
          i *= 2;
        } else {
          break;
        }
      }
      int top = i;
      int down = i / 2;
      return binarySearch(x, down, top);
    }
    
    private int binarySearch(int x, int down, int top) {
      if (down >= top - 1) {
        return down;
      } else {
        int mid = down + (top - down) / 2;
        if (mid * mid == x) {
          return mid;
        } else if (mid * mid > x) {
          return binarySearch(x, down, mid);
        } else {
          return binarySearch(x, mid, top);
        }
      }
    }
  }