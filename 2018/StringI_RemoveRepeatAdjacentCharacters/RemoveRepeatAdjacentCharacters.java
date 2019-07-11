public class Solution {
    public String deDup(String input) {
      // Write your solution here
      StringBuilder sb = new StringBuilder(input);
      return helper(sb).toString();
    }
    
    private StringBuilder helper(StringBuilder sb) {
      if (sb.length() == 1) {
        return sb;
      }
      int start = 0;
      int end = 1;
      for (end = 1; end < sb.length(); end++) {
        if (sb.charAt(end) != sb.charAt(start) && end - start > 1) {
          sb.delete(start, end);
          return helper(sb);
        } else if (sb.charAt(end) != sb.charAt(start) && end - start <= 1) {
          start = end;
        }
      }
      if (start != end && end - start > 1) {
        sb.delete(start, end);
      }
      return sb;
    }
  }