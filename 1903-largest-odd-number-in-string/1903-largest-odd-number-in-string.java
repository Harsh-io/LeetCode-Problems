class Solution {
    public String largestOddNumber(String str) {
        
        String max = "";

        for(int i=0; i<str.length(); i++){

            int n = str.charAt(i) -'0';

            if(n % 2 != 0){
                max = str.substring(0, i+1);
            }
        }
        return max;
    }
}