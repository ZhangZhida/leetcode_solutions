public class Solution {
  public String reverseWords(String input) {
    // Write your solution here
    // Assumptions:
    //     1. there is only 1 space between words
    //     2. the head and tail of the sentense has no space
    char[] array = input.toCharArray();
    int length = array.length;
    reverseWordsHelper(array, 0, length - 1);
    
    int left = 0; int right = 0;
    for(int i=0; i<length; i++) {
      // word start
      if(i == 0 || (array[i-1] == ' ' && array[i] != ' ')) {
        left = i;
      }
      if(i == length - 1 || (array[i+1] == ' ' && array[i] != ' ')) {
        right = i;
        reverseWordsHelper(array, left, right);
      }
    }
    return new String(array);
  }
  
  // in-place reverse
  private void reverseWordsHelper(char[] input, int left, int right) {
    // reverse a word without space
    while(left < right) {
      char temp = input[left];
      input[left] = input[right];
      input[right] = temp;
      left++;
      right--;
    }
  }
}
