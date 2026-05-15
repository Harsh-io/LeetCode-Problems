class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int min = strs[0].length();

        // find minimum length string
        for(int i = 1; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }

        // compare character by character
        for(int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }sb.append(c);
        }
        return sb.toString();
    }
}
//prefix comparison starts from index 0 {prefix != subsequence}
//CREATE A string builder to store and add common characters 
//fetch the i char of each string from the array -> compare if equal add to sb
//return sb