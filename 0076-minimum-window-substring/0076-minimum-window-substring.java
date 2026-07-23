import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        int l = 0;
        int r = 0;
        int minLength = Integer.MAX_VALUE;
        int startIdx = -1;
        int cnt = 0;

        Map<Character, Integer> map = new HashMap<>();
        // Build frequency map of t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (r < s.length()) {
            char c = s.charAt(r);
            // Expand window
            if (map.containsKey(c)) {
                if (map.get(c) > 0)cnt++;
                map.put(c, map.get(c) - 1);
            }

            // Shrink window
            while (cnt == t.length()) {
                int len = r - l + 1;
                if (len < minLength) {
                    minLength = len;
                    startIdx = l;
                }
                char leftChar = s.charAt(l);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) cnt--;
                }
                l++;
            }
            r++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);
    }
}