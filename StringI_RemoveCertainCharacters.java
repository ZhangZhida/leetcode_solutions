//Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
//
//        Assumptions
//
//        The given input string is not null.
//        The characters to be removed is given by another string, it is guaranteed to be not null.
//        Examples
//
//        input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".

public class StringI_RemoveCertainCharacters {

    public String remove(String input, String t) {
        // Write your solution here
        char[] inputChars = input.toCharArray();
        Set<Character> set = buildSet(t);

        int fast = 0;
        int slow = 0;
        while(fast < inputChars.length) {
            if(!set.contains(inputChars[fast])) {
                inputChars[slow] = inputChars[fast];
                slow++;
                fast++;
            }
            else {
                fast++;
            }
        }
        return new String(inputChars, 0, slow);

    }

    private Set<Character> buildSet(String t) {
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        return set;
    }
}
