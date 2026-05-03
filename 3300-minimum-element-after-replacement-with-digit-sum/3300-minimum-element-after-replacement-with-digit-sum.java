class Solution {
    public int minElement(int[] arr) {
        int ans = Integer.MAX_VALUE;
        int sum=0;
        for(int num:arr){
            int temp=num;
            sum = 0;
            while(temp>0){
                int r = temp%10;
                temp = temp/10;
                sum +=r;
            }
            System.out.println(sum);
            ans = Math.min(sum,ans);
        }
        return ans;
    }
}