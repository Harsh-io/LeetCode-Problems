class Solution {
    public int longestConsecutive(int[] arr) {

        if(arr.length == 0)
            return 0;

        Arrays.sort(arr);

        int max = 1;
        int cnt = 1;

        for(int i = 1; i < arr.length; i++) {

            if(arr[i] == arr[i - 1]) {
                continue;      // duplicate
            }
            else if(arr[i] == arr[i - 1] + 1) {
                cnt++;
            }
            else {
                max = Math.max(max, cnt);
                cnt = 1;
            }
        }

        return Math.max(max, cnt);
    }
}