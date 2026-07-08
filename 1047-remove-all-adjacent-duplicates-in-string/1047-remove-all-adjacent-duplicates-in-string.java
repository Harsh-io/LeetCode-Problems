class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && stack.charAt(len - 1) == c) {
                stack.deleteCharAt(len - 1); // remove the top of the stack
            } else {
                stack.append(c); // push current character onto the stack
            }
        }

        return stack.toString();
    }
}
