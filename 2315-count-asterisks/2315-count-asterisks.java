class Solution {
    public int countAsterisks(String s) {
        int cntstar = 0;
        int cntBar = 0;
        int max = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '|'){
                cntBar++;
            }

            if(cntBar % 2 == 0){
                if(s.charAt(i) == '*'){
                    cntstar++;
                    max++;
                }
            }
        }
        return max;
    }
}