public class StringII_ReverseString {
    public String reverse(String input) {
        // Write your solution here
        if(input == null || input.isEmpty()) {
            return input;
        }
        int left = 0;
        int right = input.length() -1;
        char[] array = input.toCharArray();
        while(left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return new String(array);
    }
}
