class Solution {
    public int longestConsecutive(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for(int num : arr){
            set.add(num);
        }

        int max = 0;

        for(int num : set){

            if(!set.contains(num - 1)){

                int cnt = 1;

                while(set.contains(num + cnt)){
                    cnt++;
                }

                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}