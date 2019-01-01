public class Solution {
    public boolean valid(String input) {
      // Write your solution here
      char[] array = input.toCharArray();
      int i = 0;
      int j = array.length - 1;
      while (i < j) {
        if (!Character.isLetterOrDigit(array[i])) {
          i++;
        } else if (!Character.isLetterOrDigit(array[j])) {
          j--;
        } else {
          if (array[i] != array[j]) {
            return false;
          } else {
            i++;
            j--;
          }
        }
      }
      return true;
    }
  }