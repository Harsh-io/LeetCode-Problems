import java.util.*;

class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        List<Character>[] bucket = new ArrayList[s.length()+1];

        for(Map.Entry<Character, Integer> e : map.entrySet()){
            char ch = e.getKey();
            int freq = e.getValue();

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for(int freq = bucket.length-1; freq >=0; freq--){

            if(bucket[freq] != null){

                for(char ch : bucket[freq]){

                    for(int i = 0; i < freq; i++) {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }
}