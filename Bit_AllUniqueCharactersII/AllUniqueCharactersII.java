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
  }