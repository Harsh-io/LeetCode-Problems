class Solution {
    public void rotate(int[] arr, int k) {

        int n = arr.length;
        k = k % n;
        int[] extra = new int[n];
        int j = 0;

        for(int i=n-k; i<n; i++){
            extra[j++] = arr[i]; 
        }
        for(int m=0; m<n-k; m++){
            extra[j++] = arr[m];
        }


        for(int q=0; q<n; q++){
            arr[q] = extra[q];
        }
    }
}
