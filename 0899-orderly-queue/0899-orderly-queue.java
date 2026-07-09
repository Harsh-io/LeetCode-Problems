import java.util.*;

class Solution {
    public String orderlyQueue(String s, int k) {

        StringBuilder sb = new StringBuilder(s);
        char[] chars = new char[s.length()];

        if (k == 1) {
            String ans = s;

            for (int i = 0; i < s.length(); i++) {
                char ch = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);

                String rotated = sb.toString();

                if (rotated.compareTo(ans) < 0) {
                    ans = rotated;
                }
            }

            return ans;

        } else if (k > 1) {

            // apply sort
            chars = s.toCharArray();
            Arrays.sort(chars);

            sb = new StringBuilder();

            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
//k == 1 -> O(n^2)
//k > 1  -> O(n log n)

// class Solution {
//     public String orderlyQueue(String s, int k) {

//         if (k == 1) {
//             String ans = s;

//             for (int i = 1; i < s.length(); i++) {
//                 String rotated = s.substring(i) + s.substring(0, i);

//                 if (rotated.compareTo(ans) < 0) {
//                     ans = rotated;
//                 }
//             }

//             return ans;
//         } 
        
//         char[] chars = s.toCharArray();
//         Arrays.sort(chars);

//         return new String(chars);
//     }
// }

//Method 2 use Bubble Sort use swap

//Concept is Easy: if k ==1, rotate s until find lexicographically smallest combination, or if k > 1, just sort s lexicographically, but Hard to catch it!