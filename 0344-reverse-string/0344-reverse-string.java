class Solution {
    public void reverseString(char[] arr) {
        int n = arr.length-1;
        for(int i=0; i<=n/2; i++){
            char temp = arr[i];
            arr[i] = arr[n-i];
            arr[n-i] = temp;
        }
        for(int i=0; i<n; i++){
            System.out.print(arr[i]);
        }
    }
}