class Solution {
    static boolean areanagram(String s1, String s2){
        int[] cnt = new int[26];
        for(int i=0; i<s1.length(); i++){
            cnt[s1.charAt(i) - 'a']++;
        }
        for(int i=0; i<s2.length(); i++){
            cnt[s2.charAt(i) - 'a']--;
        }
        for(int i=0; i<26; i++){
            if(cnt[i] != 0)
            return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<s.length()-p.length()+1; i++){
            if(areanagram(s.substring(i, i+p.length()),p)){
                res.add(i);
            }
        }
        return res;
    }

}