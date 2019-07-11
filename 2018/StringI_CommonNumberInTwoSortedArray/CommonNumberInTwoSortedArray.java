public class Solution {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
      // Write your solution here
      int i = 0;
      int j = 0;
      List<Integer> result = new LinkedList<>();
      while (i < A.size() && j < B.size()) {
        if (A.get(i) == B.get(j)) {
          result.add(A.get(i));
          i++;
          j++;
        } else if (A.get(i) < B.get(j)) {
          i++;
        } else {
          j++;
        }
      }
      return result;
    }
  }