// Time: O(n^2)
// Space: O(1) - extra one stack not included

public class Solution {
    public void sort(LinkedList<Integer> s1) {
      LinkedList<Integer> s2 = new LinkedList<Integer>();
      // Write your solution here.
      if (s1 == null || s1.size() == 0) {
        return;
      }
      int max = Integer.MIN_VALUE;
      int len = s1.size();
      int i = 0;
      while (i < len) {
        max = Integer.MIN_VALUE;
        int count = 0; // # of max value, could be > 1
        while (s1.size() > 0) {
          int elem = s1.pollLast();
          if (elem > max) {
            max = elem;
            count = 1;
          } else if (elem == max) {
            count++;
          }
          s2.offerLast(elem);
        }
        while (s2.size() > i) {
          int elem = s2.pollLast();
          if (elem < max) {
            s1.offerLast(elem);
          }
        }
        for (int j = 0; j < count; j++) {
          s2.offerLast(max);
        }
        i = i + count;
      }
      while (s2.size() > 0) {
        s1.offerLast(s2.pollLast());
      }
    }
  }