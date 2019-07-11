// Time:  O(n^3)
// Space: O(n)

public class Solution {
    public boolean canBreak(String input, String[] dict) {
      /** Use hashset to store the dict for faster query */
      HashSet<String> set = new HashSet<>();
      for (String word : dict) {
        set.add(word);
      }
      /** M[i] is true if the first i letters could be composed by words,
                  false if not.
      */
      boolean[] M = new boolean[input.length()];
      for (int i = 0; i < input.length(); i++) {
        if (set.contains(input.substring(0, i + 1))) {
          M[i] = true;
        } else {
          for (int j = 0; j < i; j++) {
            if (M[j] && set.contains(input.substring(j + 1, i + 1))) {
              M[i] = true;
              break;
            }
          }
        }    
      }
      return M[M.length - 1];
    }
  }