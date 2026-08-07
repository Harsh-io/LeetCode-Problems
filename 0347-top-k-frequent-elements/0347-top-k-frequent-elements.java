class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        

        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];


        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        int idx=0;
        for (Map.Entry<Integer, Integer> e : list) {
            if (idx >= k)  break;
            ans[idx++] = e.getKey();
        }       

        // for (int idx = 0; idx < k; idx++) {
        //     ans[idx] = list.get(idx).getKey();
        // }
        
        return ans;
    }
}

        
                