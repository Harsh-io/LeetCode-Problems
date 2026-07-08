// class Solution {
//     public String removeDuplicates(String str) {
//         if (str.length() <= 1) return str;

//         StringBuilder sb = new StringBuilder();
//         boolean found = false;

//         int i = 0;

//         while (i < str.length()) {
//             int j = i + 1;

//             while (j < str.length() && str.charAt(i) == str.charAt(j)) {
//                 j++;
//                 found = true;
//             }

//             // odd count means one char will remain
//             if ((j - i) % 2 != 0) {
//                 sb.append(str.charAt(i));
//             }

//             i = j;
//         }

//         String newStr = sb.toString();

//         if (found) {
//             return removeDuplicates(newStr);
//         }

//         return newStr;
//     }
// }

class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && stack.charAt(len - 1) == c) {
                stack.deleteCharAt(len - 1); // remove the top of the stack
            } else {
                stack.append(c); // push current character onto the stack
            }
        }

        return stack.toString();
    }
}