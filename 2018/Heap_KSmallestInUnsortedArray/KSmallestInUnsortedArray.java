// Time: O(nlogk)
// Space: O(k)

public class Solution {
    public int[] kSmallest(int[] array, int k) {
      // Write your solution here
      if (array.length == 0 || k == 0) {
        return new int[0];
      }
      PriorityQueue<Integer> maxHeap = new PriorityQueue(k, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          if (o1.equals(o2)) {
            return 0;
          }
          return o1 < o2 ? 1: -1;
        }
      });
      int i = 0;
      for (i = 0; i < k; i++) {
        maxHeap.offer(array[i]);
      }
      while (i < array.length) {
        if (array[i] < maxHeap.peek()) {
          maxHeap.poll();
          maxHeap.offer(array[i]);
        }
        i++;
      }
      int[] result = new int[k];
      for (i = 0; i < k; i++) {
        result[k-i-1] = maxHeap.poll();
      }
      return result;
    }
  }