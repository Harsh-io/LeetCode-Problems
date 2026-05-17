class Solution {
    public int myAtoi(String s) {

        long ans = 0;
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
            ans = 10 * ans + r;

            if(sign * ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if(sign * ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(sign*ans);
    }
}