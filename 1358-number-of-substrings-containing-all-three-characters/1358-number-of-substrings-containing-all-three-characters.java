class Solution {
    public static int numberOfSubstrings(String s) {
        int left  = 0;
        int cnt = 0;
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right<n; right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);

            while(map.size() == 3){
                cnt += (n-right);

                char leftc = s.charAt(left);

                map.put(leftc, map.get(leftc)-1);
                if(map.get(leftc) == 0){map.remove(leftc);}

                left++;
            }
        }
        return cnt;
    }
}
