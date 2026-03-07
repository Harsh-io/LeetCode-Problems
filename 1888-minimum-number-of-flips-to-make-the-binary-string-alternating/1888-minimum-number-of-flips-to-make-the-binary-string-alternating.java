class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String str = s + s;

        int ans = Integer.MAX_VALUE;
        int f1 = 0, f2 = 0;
        int l = 0;

        for(int r = 0; r < str.length(); r++){

            char exp1 = (r % 2 == 0) ? '0' : '1';
            char exp2 = (r % 2 == 0) ? '1' : '0';

            if(str.charAt(r) != exp1) f1++;
            if(str.charAt(r) != exp2) f2++;

            if(r - l + 1 > n){
                char leftExp1 = (l % 2 == 0) ? '0' : '1';
                char leftExp2 = (l % 2 == 0) ? '1' : '0';

                if(str.charAt(l) != leftExp1) f1--;
                if(str.charAt(l) != leftExp2) f2--;

                l++;
            }

            if(r - l + 1 == n){
                ans = Math.min(ans, Math.min(f1, f2));
            }
        }

        return ans;
    }
}