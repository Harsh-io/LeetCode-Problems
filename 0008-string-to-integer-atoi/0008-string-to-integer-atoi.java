class Solution {
    public int myAtoi(String s) {

        int ans = 0;
        s = s.strip();
        int i = 0;
        int sign = 1;

        if(i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if(i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        // digit parsing
        while(i < s.length() && Character.isDigit(s.charAt(i))) {
            int r = s.charAt(i) - '0';

            if(ans > Integer.MAX_VALUE / 10 ||
            (ans == Integer.MAX_VALUE / 10 && r > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            ans = 10 * ans + r;
            i++;
        }
        return sign * ans;
    }
}