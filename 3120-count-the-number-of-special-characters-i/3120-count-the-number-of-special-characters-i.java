import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : word.toCharArray()) {
            map.put(ch, 1);
        }

        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            char upper = Character.toUpperCase(ch);

            if (map.containsKey(ch) && map.containsKey(upper)) {
                count++;
            }
        }

        return count;
    }
}