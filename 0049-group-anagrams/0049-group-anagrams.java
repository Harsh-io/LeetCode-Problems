import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // 1. Count characters
            int[] freq = new int[26];

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            // 2. Convert frequency into a unique key
            StringBuilder key = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                key.append(freq[i]).append('#');
            }

            // 3. Find/create its group and add the string
            if (!map.containsKey(key.toString())) {
                map.put(key.toString(), new ArrayList<>());
            }

            map.get(key.toString()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}