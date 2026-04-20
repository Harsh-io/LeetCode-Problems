class Solution {
    public int[] shuffle(int[] arr, int n) {
        int[] ans = new int[arr.length];
        int i = 0;
        int j = n;
        for(int k=0; k<arr.length; k++){
            if(k%2==0){
                ans[k] = arr[i];
                i++;
            }else{
                ans[k] = arr[j];
                j++;
            }
        }
        return ans;
    }
}