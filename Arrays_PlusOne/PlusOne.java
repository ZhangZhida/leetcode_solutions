public class Solution {
    public int[] plus(int[] digits) {
      // Write your solution here
      int carry = 0;
      int len = digits.length;
      digits[len - 1] = digits[len - 1] + 1;
      for (int i = digits.length - 1; i >= 0; i--) {
        int rem = (digits[i] + carry) - (digits[i] + carry) / 10 * 10;
        carry = (digits[i] + carry) / 10;
        digits[i] = rem;
      }
      if (carry == 0) {
        return digits;
      } else {
        int[] newDigits = new int[len + 1];
        newDigits[0] = carry;
        for (int i = 1; i < len + 1; i++) {
          newDigits[i] = digits[i - 1];
        }
        return newDigits;
      }
    }
  }