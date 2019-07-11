class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            String[] names = email.split("@");
            String local = names[0];
            String trimmedLocal = local.split("\\+")[0];
            trimmedLocal = trimmedLocal.replace(".", "");
            set.add(trimmedLocal + "@" + names[1]);
        }
        return set.size();
    }
}