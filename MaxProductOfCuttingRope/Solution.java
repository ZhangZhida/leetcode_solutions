// Time: O(n^2)
// Space: O(n)

public class Solution {
    public int maxProduct(int length) {
    /*
      M[1] = 1
      M[i] = max { M[i-1] * 1, M[i-2] * 2, ....., M[1] * (i - 1), i}
    */

        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 1;

        for (int i = 2; i <= length; i++) {
            //int globalMax = 0;
            for (int j = i - 1; j >= 1; j--) {
                M[i] = Math.max(M[i], j * Math.max(i - j, M[i - j]));
            }
        }
        return M[length];
    }
}
