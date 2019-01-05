public class Solution {
    public boolean isPowerOfTwo(int number) {
      if (number < 0) {
        return false;
      }
      while ((number & 1) == 0) {
        number = number >> 1;
      }
      return number == 1 ? true : false;
    }
  }