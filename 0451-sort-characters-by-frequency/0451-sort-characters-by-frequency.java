class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.<Character, Integer>comparingByValue().reversed());

        for(Map.Entry<Character, Integer> entry : list){
            char ch = entry.getKey();
            int freq = entry.getValue();

            for(int i=0; i<freq; i++){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

//M1: Arraylist + sort 
//M2: Bucket Sort
//M3: Priority Queue