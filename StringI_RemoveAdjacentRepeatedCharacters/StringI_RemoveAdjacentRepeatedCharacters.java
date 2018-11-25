//Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
//
//        Assumptions
//
//        Try to do it in place.
//        Examples
//
//        “aaaabbbc” is transferred to “abc”
//        Corner Cases
//
//        If the given string is null, we do not need to do anything.

public class StringI_RemoveAdjacentRepeatedCharacters {

    public String deDup(String input) {
        // Write your solution here
        if(input == null || input.isEmpty()) {
            return input;
        }

        char[] array = input.toCharArray();
        int end = 0;
        for(int i = 0; i < array.length; i++) {
            if(i > 0 && array[i] == array[i-1]) {
                continue;
            }
            else {
                array[end++] = array[i];
            }
        }

        return new String(array, 0, end);
    }
}
