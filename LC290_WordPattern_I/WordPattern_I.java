class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> dict = new HashMap<>();
        HashMap<String, Character> dict2 = new HashMap<>();
        char[] charArray = pattern.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            //System.out.println(words[i]);
            if (dict.containsKey(charArray[i]) && dict2.containsKey(words[i])) {
                if (!dict.get(charArray[i]).equals(words[i]) || !dict2.get(words[i]).equals(charArray[i])) {
                    return false;
                }
            } else if (!dict.containsKey(charArray[i]) && !dict2.containsKey(words[i])) {
                dict.put(charArray[i], words[i]);
                dict2.put(words[i], charArray[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}