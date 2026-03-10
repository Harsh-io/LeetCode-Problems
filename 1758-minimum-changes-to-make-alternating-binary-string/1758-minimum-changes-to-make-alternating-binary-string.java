class Solution {
    public int minOperations(String s) {
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != (i % 2 == 0 ? '0' : '1')) cnt1++;
            if(s.charAt(i) != (i % 2 == 0 ? '1' : '0')) cnt2++;
        }

        return Math.min(cnt1, cnt2);
    }
}