class Solution {
    public int[] makeParityAlternating(int[] arr) {

        if(arr.length == 0) return new int[]{0,0};
        int max = arr[0];
        int min = arr[0];

        for(int num : arr){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int[] EvenFirst = solve(arr, 0, max, min);
        int[] OddFirst = solve(arr, 1, max, min);

        if(EvenFirst[0] !=  OddFirst[0]){
            return EvenFirst[0] < OddFirst[0] ? EvenFirst : OddFirst;
        }

        return EvenFirst[1] <= OddFirst[1] ? EvenFirst : OddFirst;
    }

    public int[] solve(int[] arr, int start, int max, int min){
        int cnt = 0;
        int max_ = Integer.MIN_VALUE;
        int min_ = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            int num = arr[i];

            int expParity = (start + i)%2;
            if(Math.floorMod(num, 2) != expParity){
                cnt++;

                if(num == max) num--;
                if(num == min) num++;
            }

            min_ = Math.min(num, min_);
            max_ = Math.max(num, max_);
        }

        return new int[]{cnt, max_ - min_};
    }
}