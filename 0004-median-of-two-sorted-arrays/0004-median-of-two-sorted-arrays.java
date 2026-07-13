class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        
        int m = arr1.length + arr2.length;
        int i=0, j=0;
        int cnt = 0;
        int[] res = new int[m];

        while(i < arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                res[cnt++] = arr1[i];
                i++;
            }else{
                res[cnt++] = arr2[j];
                j++;
            }
        }
        while(i<arr1.length){
            res[cnt++] = arr1[i];
            i++;
        }
        while(j<arr2.length){
            res[cnt++] = arr2[j];
            j++;
        }

        for(int k=0; k<m; k++){
            System.out.println(res[k]);
        }
        
        if(m%2 != 0) return res[m/2];
        else {
            double mid1 = res[m/2] ;
            double mid2 = res[(m/2)-1];
            return (mid1 + mid2)/2; 
        }
    }
}












//max path sum