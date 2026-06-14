class Solution {
    public boolean isGood(int[] arr) {

        int max = arr[0];
        for(int num : arr){
            max = Math.max(max,num);
        }

        int[] freq = new int[max + 1];
        if(arr.length != max + 1) return false;

        for(int ele : arr){
            if(ele < 1 || ele > max ) return false;
            freq[ele]++;
        }

        for (int i = 1; i < max; i++) {
            if (freq[i] != 1) return false;
        }

        return freq[max] == 2;
    }
}