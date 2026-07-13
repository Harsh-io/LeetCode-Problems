//DONT TRY TO REMOVE OR REPLACE CHARACTER AFTER YOU FIND A MISMATCH 
//Simply skip that and move to next : Goal is to check whether all elements of s are in t or not 

class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        int exact = 0;
        int changed = 0;
        int n = s.length();

        for (int j = 0; j < t.length(); j++) {
            int oldExact = exact;
            int oldChanged = changed;
            char ch = t.charAt(j);

            // Match without using replacement
            if (oldExact < n && s.charAt(oldExact) == ch) {
                exact = oldExact + 1;
            }

            // Continue after replacement was already used
            if (oldChanged < n && s.charAt(oldChanged) == ch) {
                changed = oldChanged + 1;
            }

            // Use replacement at the current character
            if (oldExact < n) {
                changed = Math.max(changed, oldExact + 1);
            }

            if (changed == n) return true;
        }

        return changed == n;
    }
}