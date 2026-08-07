class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()){

            if(e.getValue() > arr.length/3 ){
                ans.add(e.getKey());
            }

            if (ans.size() == 2) break;
        }

        return ans;
    }
}