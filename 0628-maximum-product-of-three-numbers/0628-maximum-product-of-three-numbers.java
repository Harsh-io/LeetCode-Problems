class Solution {
    public int maximumProduct(int[] arr) {
        
        Arrays.sort(arr);
        int ans = 0;
        int cnt = 0;
        int newans = 0;

        if(arr[0] < 0 && arr[1] < 0){
            newans = arr[0] * arr[1] * arr[arr.length-1];
        }

        ans = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];

        return Math.max(ans, newans);
    }
}