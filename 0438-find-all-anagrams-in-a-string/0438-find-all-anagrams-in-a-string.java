class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();

        List<Integer> res =  new ArrayList<>();

        if(n < k) return res;

        HashMap<Character, Integer> map = new HashMap<>();

        // store pattern freq
        for(char ch: p.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }

        int cnt = map.size();
        int i = 0, j = 0;

        // slide window
        while(j < n){
            char ch = s.charAt(j);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);

                if(map.get(ch) == 0) {
                    cnt--;
                }
            }

            if (j - i + 1 < k) {
                j++;
            }

            else if (j - i + 1 == k) {

                if (cnt == 0) {
                    res.add(i);
                }

                // slide window
                char leftChar = s.charAt(i);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) == 1) {
                        cnt++;
                    }
                }

                i++;
                j++;
            }
        }
        return res;
    }
}
