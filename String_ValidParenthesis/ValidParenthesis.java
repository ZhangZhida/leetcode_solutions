public class Solution {
    public boolean isValid(String input) {
      // Write your solution here
      if (input == null || input.length() == 0) {
        return false;
      }
      char[] array = input.toCharArray();
      Deque<Character> stack = new ArrayDeque<>();
      int cur = 0;
      while(cur < array.length) {
        if (stack.isEmpty()) {
          stack.offerFirst(array[cur]);
          cur++;
        } else {
          if (isPair(stack.peek(), array[cur])) {
            stack.pollFirst();
            cur++;
          } else {
            stack.offerFirst(array[cur]);
            cur++;
          }
        }
      }
      if (stack.isEmpty()) {
        return true;
      } else {
        return false;
      }
    }
    
    public boolean isPair(char c1, char c2) {
      if (c1 == '(' && c2 == ')') {
        return true;
      } else if (c1 == '[' && c2 == ']') {
        return true;
      } else if (c1 == '{' && c2 == '}') {
        return true;
      } else {
        return false;
      }
    }
  }