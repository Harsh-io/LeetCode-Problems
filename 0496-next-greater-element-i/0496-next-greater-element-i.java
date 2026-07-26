class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        boolean found = false;

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){

                if(arr1[i] == arr2[j]){
                    int ele = arr2[j];
                    found = false;
                    while(j < arr2.length){
                        if(arr2[j] > ele){
                            ans[i] = arr2[j];
                            found = true;
                            break;
                        }
                        j++;
                    }
                }
                if(!found == true) {ans[i] = -1;}
            }
        }
        return ans;
    }
}