class Solution {

    public int[] sortArray(int[] arr) {

        mergesort(arr, 0, arr.length-1);
        return arr;
    }

    public void mergesort(int[] arr, int l, int r){
        
        if(l >= r) return;

        int mid =  (l + (r-l)/2);
        
        mergesort(arr, l, mid);
        mergesort(arr, mid+1, r);
        merge(arr, l, mid, r);

        return;
    }

    public void merge(int[] arr, int l, int mid, int r){

        int[] temp = new int[r-l+1]; 
        int left = l;
        int right = mid+1;
        int end = r;
        int i = 0;

        while(left <= mid && right <= end){ 

            if(arr[left] <= arr[right]){
                temp[i++] = arr[left++];
            }else{
                temp[i++] = arr[right++];
            }
        }
        
        while(left <= mid){
            temp[i++] = arr[left++];
        }
        
        while(right <= end){
            temp[i++] = arr[right++];
        }
        
        for(int j = l; j <= r; j++){
            arr[j] = temp[j - l];
        }
    }
}
