class Solution {
    public long countSubarrays(int[] arr, long k) {
        
        int left = 0, right = 0;
        long sum = 0;
        int cnt = 0;
        long ans = 0;

        while(right < arr.length){

            sum += arr[right];
            cnt++;
            
            while(sum * cnt >= k){
                sum = sum - arr[left];
                left++;
                cnt--;
            }

            if(sum * cnt < k) ans += right - left + 1;
            System.out.println(ans);
            System.out.println();


            right++;
        }

        return ans;
    }
}