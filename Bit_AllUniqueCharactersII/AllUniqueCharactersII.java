// Assumptions: 
//   We are using ASCII charset, the value of valid characters are from 0 to 255
//   The given string is not null

public class Solution {
    public boolean allUnique(String word) {
      // Write your solution here
      char[] array = word.toCharArray();
      boolean[] exist = new boolean[255];
      for (char c : array) {
        if (exist[c]) {
          return false;
        } else {
          exist[c] = true;
        }
      }
      return true;
    }

    public boolean allUnique2(String word) {
        char[] array = word.toCharArray();
        int[] bit_vector = new int[8];
        for (char c : array) {
            int row = c / 32;
            int col = c - c / 32 * 32;
            int test = 1 << col;
            if ((bit_vector[row] & test) != 0) {
                return false;
            } else {
                bit_vector[row] = bit_vector[row] | test;
            }
        }
        return true;
    }
  }