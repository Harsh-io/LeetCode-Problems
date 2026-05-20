class Solution {
    public int[] searchRange(int[] arr, int t) {

        int[] ans = {-1, -1};
        int start = 0;
        int end = arr.length - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == t) {
                ans[0] = mid;
                end = mid - 1;
            }
            else if (arr[mid] < t) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        start = 0;
        end = arr.length - 1;

        // Find last occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == t) {
                ans[1] = mid;
                start = mid + 1;
            }
            else if (arr[mid] < t) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
}