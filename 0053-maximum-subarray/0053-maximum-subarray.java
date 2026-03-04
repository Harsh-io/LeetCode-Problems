class Solution {
    public int maxSubArray(int[] arr) {
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            maxsum = Math.max(sum, maxsum);

            if(sum < 0){sum=0;}
        }
        return maxsum;
    }
}

//BRUTE FORCE
//  int max = arr[0];
//         int maxsum = arr[0];
//         for(int i=0; i<arr.length; i++){
//             int sum=0;
//             for(int j=i; j<arr.length; j++){
//                 sum += arr[j];
//                 if(sum > maxsum){
//                     maxsum = sum;
//                 }
//             }
//             if(maxsum > max){max = maxsum;}
//         }
//         return max;