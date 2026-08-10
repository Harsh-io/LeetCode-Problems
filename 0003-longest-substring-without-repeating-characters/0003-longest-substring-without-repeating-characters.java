class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int l=0, r=0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(r < s.length()){

            char str = s.charAt(r);
            map.put(str, map.getOrDefault(str, 0)+1);

            while(map.size() < r-l+1){
                
                char ch = s.charAt(l);
                map.put(ch, map.getOrDefault(ch, 0)-1);
                l++;

                if(map.get(ch) == 0) map.remove(ch);

            }

            if(map.size() == r-l+1){
                max = Math.max(max, r-l+1);
            }
            r++;
        }

        return max;
    }
}