/** 
 * Time:  O(n)
 * Space: O(1)
 */

public class Solution {
    public int longest(String input) {
      if (input.length() == 0) {
        return 0;
      }
      HashSet<Character> distinct = new HashSet<>();
      int fast = 0;
      int slow = 0;
      int maxLength = 1;
      while (fast < input.length()) {
        char c = input.charAt(fast);
        if (!distinct.contains(c)) {
          distinct.add(c);
          fast++;
          maxLength = Math.max(maxLength, fast - slow);
        } else {
          while (!distinct.isEmpty() && distinct.contains(c)) {
            distinct.remove(input.charAt(slow));
            slow++;
          }
          distinct.add(c);
          fast++;
        }
      }
      return maxLength;
    }
  }