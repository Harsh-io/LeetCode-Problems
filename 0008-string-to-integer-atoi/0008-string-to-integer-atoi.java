class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;

        int sign = 1;
        int start = 0;
        long ans = 0;

        if(s.charAt(start) == '-' || s.charAt(start) == '+'){
            sign = (s.charAt(start) == '-') ? -1 : 1;
            start++;
        }

        return solve(s, start, 0, sign);
    }

    private int solve(String s, int i, long ans, int sign){
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (int)(sign * ans);
        }

        int digit = s.charAt(i) - '0';
        ans = ans * 10 + digit;

        if(sign * ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if(sign * ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return solve(s, i+1, ans, sign);
    }
}