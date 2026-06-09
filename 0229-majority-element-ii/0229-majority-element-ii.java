class Solution {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : arr){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n / 3){
                list.add(entry.getKey());
            }
        }

        return list; 
    }
}