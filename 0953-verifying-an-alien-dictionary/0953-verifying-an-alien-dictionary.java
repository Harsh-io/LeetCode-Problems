import java.util.*;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < order.length(); j++) {
            map.put(order.charAt(j), j);
        }

        for (int k = 1; k < words.length; k++) {
            String str1 = words[k - 1];
            String str2 = words[k];

            int i = 0;
            int j = 0;

            while (i < str1.length() && j < str2.length()) {

                char s1 = str1.charAt(i);
                char s2 = str2.charAt(j);

                int v1 = map.get(s1);
                int v2 = map.get(s2);

                if (v1 < v2) {break;}
                if (v1 > v2) {return false; }
                i++;
                j++;
            }
            if (i == str2.length() && str1.length() > str2.length()) {
                return false;
            }
        }
        return true;
    }
}