import java.util.*;

class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        List<Integer> pos = new ArrayList<>();
        List<Character> v = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isVowel(arr[i])) {
                pos.add(i);
                v.add(arr[i]);
            }
        }
        int[] freq = new int[26];
        for (char c : v) {
            freq[c - 'a']++;
        }

        int[] first = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < v.size(); i++) {
            int idx = v.get(i) - 'a';
            if (first[idx] == -1) first[idx] = i;
        }

        Collections.sort(v, (a, b) -> {
            if (freq[a - 'a'] != freq[b - 'a']) {
                return freq[b - 'a'] - freq[a - 'a']; 
            }
            return first[a - 'a'] - first[b - 'a']; 
        });

        // Step 5: put back
        for (int i = 0; i < pos.size(); i++) {
            arr[pos.get(i)] = v.get(i);
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}