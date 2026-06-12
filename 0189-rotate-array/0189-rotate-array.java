class Solution {
    public void rotate(int[] arr, int k) {

        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n-k-1);
        reverse(arr, n-k, n-1);
        reverse(arr, 0, n-1);

    }
    public void reverse(int[] arr, int s, int e){
        while(s < e){
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;

            s++;
            e--;
        }
    }


}
