public class Solution {
    public List<String> subSets(String set) {
      // Write your solution here.
      if (set == null) {
        return Arrays.asList(new String[0]);
      } else if (set.length() == 0) {
        return Arrays.asList("");
      }
      char[] charArray = set.toCharArray();
      StringBuilder solutionPrefix = new StringBuilder();
      List<String> solution = new ArrayList<>();
      DFS(charArray, 0, solutionPrefix, solution);
      return solution;
    }
    
    private void DFS(char[] charArray, int index, StringBuilder solutionPrefix, List<String> solution) {
      // base case:
      if (index >= charArray.length) {
        solution.add(solutionPrefix.toString());
        return;
      }
      
      // case 1: not adding the char at the index
      DFS(charArray, index + 1, solutionPrefix, solution);
      
      // case 2: adding the char into the final result
      solutionPrefix.append(charArray[index]);
      DFS(charArray, index + 1, solutionPrefix, solution);
      solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
    }
  }