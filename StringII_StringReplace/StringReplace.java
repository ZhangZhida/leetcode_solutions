public class Solution {
    public String replace(String input, String source, String target) {
      // Assumption: input, source, target are not null
      StringBuilder sb = new StringBuilder();
      int startIndex = 0;
      int matchIndex = input.indexOf(source, startIndex);
      while (matchIndex != -1) {
        sb.append(input, startIndex, matchIndex);
        sb.append(target);
        startIndex = matchIndex + source.length();
        matchIndex = input.indexOf(source, startIndex);
      }
      sb.append(input, startIndex, input.length());
      return sb.toString();
    }
  }