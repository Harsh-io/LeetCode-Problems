class Solution {
    public int maxScore(int[] arr, int k) {

        int l = k-1;
        int max = 0;
        int sum = 0;

        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        max = Math.max(max, sum);
        System.out.println(max);

        int r = arr.length-1;
        while(l >= 0){
            sum -= arr[l];
            l--;
            sum += arr[r];
            r--;
            System.out.println(sum);
            max = Math.max(max, sum);
        }

        return max;
    }
}