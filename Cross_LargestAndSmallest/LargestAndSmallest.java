public class Solution {
    public int[] largestAndSmallest(int[] array) {
      // Assumption: the given array is not null and has length of at least 1
      if (array.length == 1) {
        return new int[] {array[0], array[0]};
      }
      // Divide the array into the winner group and loser group
      int i = 0;
      int[] winner = new int[array.length / 2];
      int[] loser = new int[array.length / 2];
      while (i < array.length / 2) {
        winner[i] = Math.max(array[i * 2], array[i * 2 + 1]);
        loser[i] = Math.min(array[i * 2], array[i * 2 + 1]);
        i++;
      }
      int largest = Integer.MIN_VALUE;
      int smallest = Integer.MAX_VALUE;
      for (i = 0; i < winner.length; i++) {
        largest = winner[i] > largest ? winner[i] : largest;
      }
      for (i = 0; i < loser.length; i++) {
        smallest = loser[i] < smallest ? loser[i] : smallest;
      }
      if (array.length % 2 != 0) {
        int lastOne = array[array.length - 1];
        largest = lastOne > largest ? lastOne : largest;
        smallest = lastOne < smallest ? lastOne : smallest;
      }
      return new int[] {largest, smallest};
    }
  }