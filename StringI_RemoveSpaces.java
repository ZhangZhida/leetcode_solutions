//Given a string, remove all leading/trailing/duplicated empty spaces.
//
//        Assumptions:
//
//        The given string is not null.
//        Examples:
//
//        “  a” --> “a”
//        “   I     love MTV ” --> “I love MTV”

public class StringI_RemoveSpaces {

    public String removeSpaces(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Write your solution here
        char[] array = input.toCharArray();
        int end = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == ' ' && (i == 0 || array[i-1] == ' ')) {
                continue;
            }
            else {
                array[end++] = array[i];
            }
        }

        // post-processing
        if(end > 0 && array[end-1] == ' ')
            end--;

        return new String(array, 0, end);
    }
}
