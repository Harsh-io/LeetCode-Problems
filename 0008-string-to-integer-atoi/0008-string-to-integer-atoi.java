class Solution {
    public int myAtoi(String s) {

        String str = s.trim();
        if(str.length() == 0) return 0;

        long ans = 0;
        int sign = 1;
        int i = 0;

        if(str.charAt(0) == '-'){
            sign = -1;
            i++;
        }
        else if(str.charAt(0) == '+'){
            i++;
        }
        
        while(i < str.length() && Character.isDigit(str.charAt(i))){
            
            int r = str.charAt(i) - '0';

            ans = ans * 10 + r;

            if(sign * ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if(sign * ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            i++;
            }
            return (int)(sign * ans);
    }
}