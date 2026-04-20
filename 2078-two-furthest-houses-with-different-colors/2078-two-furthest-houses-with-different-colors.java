class Solution {
    public int maxDistance(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                if(arr[i] != arr[j]){
                    max = Math.max(max, Math.abs(i-j));
                }
            }
        }
        return max;
    }
}

        // for(int i=1; i<arr.length; i++){
        //     if(arr[0] != arr[i]){
        //         max = Math.max(max, Math.abs(i));
        //     }
        // }