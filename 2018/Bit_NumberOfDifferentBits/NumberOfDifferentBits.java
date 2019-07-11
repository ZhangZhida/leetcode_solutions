public class Solution {
    public int diffBits(int a, int b) {
      a = a ^ b;
      int count = 0;
      while (a != 0) {
        count += a & 1;
        a >>>= 1;
      }
      return count;
    }
  }