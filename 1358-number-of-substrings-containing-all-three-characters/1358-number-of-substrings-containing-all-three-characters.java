import java.util.*;

class Solution {

    public int numberOfSubstrings(String s) {

        int n = s.length();

        int left = 0;
        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            // add current character
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // window contains a,b,c
            while (map.containsKey('a') &&
                   map.containsKey('b') &&
                   map.containsKey('c')) {

                // all future extensions also valid
                count += (n - right);

                // shrink window
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                // remove if frequency becomes 0
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }
        }

        return count;
    }
}