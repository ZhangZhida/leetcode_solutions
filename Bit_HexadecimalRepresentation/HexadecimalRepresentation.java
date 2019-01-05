public class Solution {
    public String hex(int number) {
      if (number == 0) {
        return "0x0";
      }
      char[] base = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
      int remainder = -1;
      StringBuilder sb = new StringBuilder();
      while (number != 0) {
        remainder = number - number / 16 * 16;
        number = number / 16;
        sb.append(base[remainder]);
      }
      sb.append("x0");
      sb.reverse();
      return sb.toString();
    }
  }