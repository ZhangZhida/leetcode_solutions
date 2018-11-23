public class Solution {
  public String rightShift(String input, int n) {
    // Write your solution here
    // Assumptions: 
    //   1. the input is not null
    //   2. n >= 0;
    int left = 0;
    int right = n;
    char[] array = input.toCharArray();
    int length = array.length;
    n = n % length;
    
    // 1.reverse the whole char array
    reverse(array, 0, length-1);
    // 2. reverse the part [0, length - n]
    reverse(array, 0, n-1);
    // 3. reverse the part [length - n + 1, length - 1]
    reverse(array, n, length - 1);
    
    return new String(array);
  }
  
  private void reverse(char[] array, int left, int right) {
     while(left < right) {
       char temp = array[left];
       array[left] = array[right];
       array[right] = temp;
       left++;
       right--;
     }
  }
}