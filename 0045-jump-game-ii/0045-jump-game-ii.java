class Solution {
    public int jump(int[] arr) {

        int l = 0, r = 0;
        int jumps = 0;

        while (r < arr.length - 1) {

            int farthest = 0;

            for (int idx = l; idx <= r; idx++) {

                farthest = Math.max(idx + arr[idx], farthest);
            }

            if (farthest == r) return -1; // cannot move further

            l = r + 1;
            r = farthest;
            jumps++;
        }

        return jumps;
    }
}