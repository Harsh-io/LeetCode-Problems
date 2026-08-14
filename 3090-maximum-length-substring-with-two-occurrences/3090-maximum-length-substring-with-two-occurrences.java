class Solution {
    public int maximumLengthSubstring(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();

        int maxl = 0;
        int l = 0;
        int r = 0;
        int maxf = 0; 

        while(r < s.length()){

            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            maxf = Collections.max(map.values());

            while(maxf > 2){

                char c = s.charAt(l);
                map.put(c, map.get(c)-1);
                maxf = Collections.max(map.values());
                l++;

            }

            maxl = Math.max(maxl, r-l+1);
            r++;

        }

        return maxl;

    }
}