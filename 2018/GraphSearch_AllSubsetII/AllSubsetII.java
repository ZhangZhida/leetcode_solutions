import java.util.*;

public class AllSubsetII {
    
    public static List<String> subSets(String set) {
      List<String> solution = new ArrayList<>();
      if (set == null) {
        return solution;
      }
      if (set.length() == 0) {
        solution.add("");
        return solution;
      }
      
      StringBuilder solutionPrefix = new StringBuilder();
      char[] array = set.toCharArray();
      Arrays.sort(array);
      DFS(array, 0, solutionPrefix, solution);
      return solution;
    }
    
    private static void DFS(char[] array, int index, StringBuilder sb, List<String> solution) {
      if (index == array.length) {
        solution.add(sb.toString());
        return;
      }
      // case 1: add the character
      sb.append(array[index]);
      DFS(array, index + 1, sb, solution);
      sb.deleteCharAt(sb.length() - 1);
      
      // case 2: not add the character, avoid duplicate
      while (index < array.length - 1 && array[index + 1] == array[index]) {
        index++;
      } 
      DFS(array, index + 1, sb, solution);
    }

    public static void main(String[] args) {
        String set = "abbc";
        List<String> allSubset = subSets(set);
        for (String s : allSubset) {
            System.out.println(s);
            }
        }
    }
  }