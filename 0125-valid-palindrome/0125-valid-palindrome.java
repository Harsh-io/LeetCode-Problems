class Solution {
    public boolean isPalindrome(String s) {
        
        String str = s.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();

        return str.equals(new StringBuilder(str).reverse().toString());
    }
}