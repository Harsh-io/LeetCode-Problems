class Solution {
    public int digitFrequencyScore(int n) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        while (n > 0){
            int r = n % 10;
            n = n / 10;
            map.put(r, map.getOrDefault(r, 0)+1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()){

            sum += e.getKey() * e.getValue();
        }

        return sum;
    }
}