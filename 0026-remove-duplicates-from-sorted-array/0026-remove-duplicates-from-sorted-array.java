class Solution {
    public int removeDuplicates(int[] arr) {

        int fast=0;
        int slow = 0;

        while(fast < arr.length){
            int x = arr[fast];

            while(fast < arr.length && arr[fast] == x) fast++;

            if(slow < arr.length){
                arr[slow++] = arr[fast-1];
            }
        }

        return slow;
    }
}