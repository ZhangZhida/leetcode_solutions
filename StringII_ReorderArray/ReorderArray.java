// Time: Time(nlogn)
// Space: O(1)

public class Solution {
    public int[] reorder(int[] array) {
      // Assumptions: input is not null
      if (array.length == 0) {
        return new int[0];
      } 
      if (array.length <= 2) {
        return array;
      }
      if (array.length % 2 != 0) {
        reorder(array, 0, array.length - 1);
      } else {
        reorder(array, 0, array.length);
      }
      return array;
    }
    
    private void reorder(int[] array, int l, int r) {
      if (r - l <= 2) {
        return;
      }
      
      int size = r - l;
      int ml = l + size / 4;
      int m = l + size / 2;
      int mr = m + size / 4;
      
      reverse(array, ml, m - 1);
      reverse(array, m, mr - 1);
      reverse(array, ml, mr - 1);
      
      reorder(array, l, l + 2 * (size / 4) );
      reorder(array, l + 2 * (size / 4) , r);
    }
    
    private void reverse(int[] array, int i, int j) {
      int temp = -1;
      while (i < j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
      }
    }
  }