class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {

        int n = tasks.length;
        int m = shifts.length;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + tasks[i];
        }

        int[] ans = new int[m];

        int idx = 0;                  // current task
        long rem = tasks[0];          // remaining work in current task

        for (int i = 0; i < m; i++) {
            long time = shifts[i];

            // Finish current partially completed task first
            if (time < rem) {
                rem -= time;
                ans[i] = n - idx;
                continue;
            }

            //time > remaining 
            time -= rem;
            idx++;

            // All tasks finished exactly after current task
            if (idx == n) {
                ans[i] = 0;
                idx = 0;
                rem = tasks[0];
                continue;
            }

            //total amount of work completed from the very beginning after using the current shift time.
            long target = pref[idx] + time;

            // Binary Search: largest index with pref[index] <= target
            int l = idx, r = n;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (pref[mid] <= target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }

            int last = r;

            if (last == n) {
                ans[i] = 0;
                idx = 0;
                rem = tasks[0];
            } else {
                idx = last;
                rem = pref[idx + 1] - target;
                ans[i] = n - idx;
            }
        }

        return ans;
    }
}