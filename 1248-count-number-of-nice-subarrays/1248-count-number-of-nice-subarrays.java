class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        
        return solve(arr, k) - solve(arr, k-1);
    }

    public int solve(int[] arr, int k){

        if(k < 0) return 0;

        int left = 0;
        int sum = 0;
        int cnt = 0;

        for(int right = 0; right < arr.length; right++){

            if(arr[right] % 2 == 1) sum++;

            while(sum > k){
                if(arr[left] % 2 == 1) sum--;
                left++;
            }

            cnt += right - left + 1; 
        }

        return cnt;
    }
}