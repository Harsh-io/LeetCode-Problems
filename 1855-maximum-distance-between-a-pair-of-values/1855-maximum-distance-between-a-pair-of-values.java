class Solution {
    public int maxDistance(int[] arr1, int[] arr2) {
        int result = 0;
        int n = arr1.length;
        for(int i=0; i<n; i++){
            int j=-1;
            int m = arr2.length;
            int s = i;
            int e = m - 1;
            while(s <= e){
                int mid = (s+e)/2;
                if(arr2[mid] >= arr1[i]){
                    j = mid;
                    s = mid+1;
                    }
                else{e = mid-1;}
            }
            if(j != -1){
                result = Math.max(result, j - i);
            } 
        }    
        return result;    
    }
}