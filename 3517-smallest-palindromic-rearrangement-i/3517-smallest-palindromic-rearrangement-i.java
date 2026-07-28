class Solution {
    public String smallestPalindrome(String s) {

        int[] a = new int[26];

        for (char ch : s.toCharArray()) {
            a[ch - 'a']++;
        }

        char[] ans = new char[s.length()];

        int left = 0;
        int right = s.length() - 1;
        char mid = '\0';

        for (int i = 0; i < 26; i++) {

            char ch = (char) ('a' + i);

            while (a[i] >= 2) {
                ans[left++] = ch;
                ans[right--] = ch;
                a[i] -= 2;
            }

            if (a[i] == 1) {
                mid = ch;
            }
        }

        // place middle character
        if (mid != '\0') {
            ans[left] = mid;
        }

        return new String(ans);
    }
}