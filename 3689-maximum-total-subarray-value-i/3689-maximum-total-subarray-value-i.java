class Solution {
    public long maxTotalValue(int[] arr, int k) {
        int n = arr.length;

        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(min);
        return k * (max - min);
    }
}