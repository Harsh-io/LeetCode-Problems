class Solution {
    public int maximizeSum(int[] arr, int k) {
        Arrays.sort(arr);

        int n = arr.length;
        int ans = 0;

        for(int i=0; i<k; i++){
            ans += arr[n-1];
            arr[n-1] = arr[n-1] + 1;
        }
        return ans;
    }
}