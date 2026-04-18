class Solution {
    public void reverseString(char[] arr) {
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}

//option 2
//swap i & n-i (from i = 0 -> n/2)