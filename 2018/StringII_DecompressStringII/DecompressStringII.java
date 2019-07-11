public class Solution {
    public String decompress(String input) {
      if (input.length() == 0) {
        return "";
      }
      
      char[] array = input.toCharArray();
      // count the total characters
      int count = 0;
      for (char c : array) {
        if (Character.isDigit(c)) {
          count += (int)(c - '0');
        }
      }
      char[] result = new char[count];
      int s = count - 1;
      int f = array.length - 1;
      // decompress
      while (f >= 0) {
        if (Character.isDigit(array[f])) {
          int dup = (int)(array[f] - '0');
          for (int i = 0; i < dup; i++) {
            result[s--] = array[f - 1];
          }
          f--;
        } else {
          f--;
        }
      }
      return new String(result);
    }
  }
  