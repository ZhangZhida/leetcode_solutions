public class Solution {
    public long fibonacci(int K) {
      // Write your solution here
      long[] M = new long[K+1];
      return helper(K, M);
    }
    private long helper(int K, long[] M) {
      if (K <= 0) {
        return 0;
      }
      if (K == 1) {
        return 1;
      }
      if (M[K] != 0) {
        return M[K];
      } else {
        long value = helper(K-1, M) + helper(K-2, M);
        M[K] = value;
        return value;
      }
    }
  }