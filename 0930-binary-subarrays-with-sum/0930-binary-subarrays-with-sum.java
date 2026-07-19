class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        return atMost(arr, goal) - atMost(arr, goal - 1);
    }

    private int atMost(int[] arr, int goal) {

        if(goal < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        for(int right=0; right<arr.length; right++){
            sum += arr[right];

            while(sum > goal){
                sum -= arr[left];
                left++;
            }

            count += right - left + 1;
        }
        return count;
    }
}