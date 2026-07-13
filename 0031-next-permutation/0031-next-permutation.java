class Solution {
    public void nextPermutation(int[] arr) {

        for(int i = arr.length - 1; i > 0; i--){
            if(arr[i - 1] < arr[i]){
                int idx = i - 1; // find the smallest ele wrt to its rightmost ele -> starting from right 
                int j = arr.length - 1;

                while(arr[j] <= arr[idx]) {j--;} // First greater element from right

                int temp = arr[idx];
                arr[idx] = arr[j];
                arr[j] = temp;

                reverse(arr, i, arr.length - 1);
                return;
            }
        }

        // No breaking point
        reverse(arr, 0, arr.length - 1);
    }

    public void reverse(int[] arr, int l, int r){

        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }
    }
}