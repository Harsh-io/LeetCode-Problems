class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        String t  =  "1" + s + "1";

        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        int cnt  = 1;

        for(int i=1; i<t.length(); i++){
            
            if(t.charAt(i) == t.charAt(i-1)) cnt++;
            else {
                values.add(t.charAt(i-1) - '0');
                counts.add(cnt);
                cnt  = 1;
            }
        }

        values.add(t.charAt(t.length() - 1) - '0');
        counts.add(cnt);

        //count original one's
        int totalones = 0;
        for(char c : s.toCharArray()){
            if(c == '1') totalones++;
        }

        int maxgain = 0;

        //check every removable 1-block 

        for(int i=1; i<values.size()-1; i++){

            if (values.get(i) == 1 && values.get(i - 1) == 0 && values.get(i + 1) == 0) {
                int gain = counts.get(i-1) + counts.get(i+1);
                maxgain = Math.max(maxgain, gain);
            }
        }

        return totalones + maxgain;
    }
}