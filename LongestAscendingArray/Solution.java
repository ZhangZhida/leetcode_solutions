public class Solution {
    public int longest(int[] array) {
        if (array.length <= 1) {
            return array.length;
        }

        int i = 0; // left pointer
        int j = 1; // right pointer

        int globalMax = 1; // global max length

        while (j < array.length) {
            if (array[j] > array[j - 1]) {
                globalMax = j + 1 - i > globalMax ? j + 1 - i : globalMax;
                j++;
            } else {
                i = j++;
            }
        }
        return globalMax;
    }
}
