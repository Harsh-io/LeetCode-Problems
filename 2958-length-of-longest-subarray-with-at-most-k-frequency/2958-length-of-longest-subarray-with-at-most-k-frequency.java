class Solution {
    public int maxSubarrayLength(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int ans = 0;

        for (int r = 0; r < arr.length; r++) {

            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while (map.get(arr[r]) > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}