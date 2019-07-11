import java.util.*;

public class AllValidPermutationOfParenthesis {
    public static List<String> validParentheses(int l, int m, int n) {
      StringBuilder solutionPrefix = new StringBuilder();
      List<String> solution = new ArrayList<>();
      char[] array = new char[]{'(', ')', '<', '>', '{', '}'};
      Deque<Character> stack = new ArrayDeque<>();
      int[] remainder = new int[]{l, l, m, m, n, n};
      int resultLength = (l + m + n) * 2;
      DFS(array, remainder, stack, solutionPrefix, solution, resultLength);
      return solution;
    }
    
    private static void DFS(char[] array, int[] remainder, Deque<Character> stack, 
                     StringBuilder prefix, List<String> solution, int resultLen) {
      if (prefix.length() == resultLen) {
        solution.add(prefix.toString());
        return;
      }
      for (int i = 0; i < array.length; i++) {
        if (i % 2 == 0) {
          // if the character is left parenthesis
          if (remainder[i] > 0) {
            remainder[i]--;
            stack.offerFirst(array[i]);
            prefix.append(array[i]);
            DFS(array, remainder, stack, prefix, solution, resultLen);
            remainder[i]++;
            stack.pollFirst();
            prefix.deleteCharAt(prefix.length() - 1);
          }
        } else {
          // if the character is right parenthesis
          if (!stack.isEmpty() && stack.peekFirst() == array[i - 1]) {
            stack.pollFirst();
            prefix.append(array[i]);
            remainder[i]--;
            DFS(array, remainder, stack, prefix, solution, resultLen);
            prefix.deleteCharAt(prefix.length() - 1);
            stack.offerFirst(array[i - 1]);
            remainder[i]++;
          }
        }
      }
      
    }
    public static void main(String[] args) {
        List<String> result = validParentheses(1,1,1);
        for (String s : result ) {
            System.out.println(s);
        } 
    }
  }