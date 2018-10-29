public class StringI_DetermineIfOneStringIsAnothersSubstring {

    public int strstr(String large, String small) {
        // Write your solution here
        if(small.isEmpty()) {
            return 0;
        }
        if(large.length() < small.length()) {
            return -1;
        }
        StringBuilder sb = new StringBuilder(large);
        int lenOfSmall = small.length();
        for(int i = 0; i <= large.length() - lenOfSmall ; i++) {
            String substring = sb.substring(i, i + lenOfSmall);
            if(small.equals(substring)) {
                return i;
            }
        }
        return -1;
    }
}
