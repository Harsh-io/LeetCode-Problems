class Solution {
    public int[] shuffle(int[] arr, int n) {

        int[] ans = new int[arr.length];

        int i = 0;
        int j = n;
        int cnt = 0;

        while( j < arr.length){
            ans[cnt] = arr[i];
            ans[cnt + 1] = arr[j];
            i++;
            j++;
            cnt += 2;
        }
        return ans;
    }
}