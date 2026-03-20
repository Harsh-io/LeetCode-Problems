import java.util.HashSet; // Not used in this optimized version, but sometimes useful
import java.util.Map;
import java.util.Set; // Not used in this optimized version, but sometimes useful
import java.util.TreeMap; // TreeMap for sorted keys and counts

class Solution {

    // Helper function to calculate min absolute difference from a TreeMap of counts
    private int calculateMinDiff(TreeMap<Integer, Integer> counts) {
        if (counts.size() <= 1) { // If 0 or 1 distinct elements
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;
        Integer prevVal = null;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int currentVal = entry.getKey();
            if (prevVal != null) {
                minDiff = Math.min(minDiff, currentVal - prevVal);
            }
            prevVal = currentVal;
        }
        return minDiff;
    }

    // Helper to add an element to the TreeMap
    private void addElement(TreeMap<Integer, Integer> counts, int val) {
        counts.put(val, counts.getOrDefault(val, 0) + 1);
    }

    // Helper to remove an element from the TreeMap
    private void removeElement(TreeMap<Integer, Integer> counts, int val) {
        // IMPORTANT: Check if the key exists before getting its value
        // or ensure getOrDefault(val, 0) is used before subtraction
        // and then handle removal if count becomes zero.
        Integer count = counts.get(val);
        if (count != null && count > 0) { // Only decrement if exists and count > 0
            counts.put(val, count - 1);
            if (count - 1 == 0) {
                counts.remove(val);
            }
        }
        // If count is null or 0, it means it's not in the current window's map,
        // so we don't need to do anything. This prevents NPE.
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        // The outer loop iterates through the starting row 'i' of the k x k submatrix
        for (int i = 0; i <= m - k; i++) {
            // For each starting row 'i', we need to manage the elements in a 'k' height strip
            // and then slide this strip horizontally.

            // Initialize/Reset the TreeMap for the first window of the current row 'i'
            // This ensures currentWindowCounts always starts fresh for each new row of results.
            TreeMap<Integer, Integer> currentWindowCounts = new TreeMap<>();

            // Populate the TreeMap for the very first k x k window in this row (i, 0)
            for (int r = i; r < i + k; r++) {
                for (int c = 0; c < k; c++) {
                    addElement(currentWindowCounts, grid[r][c]);
                }
            }
            ans[i][0] = calculateMinDiff(currentWindowCounts);

            // Now, slide horizontally for the rest of the columns in the current row 'i'
            for (int j = 1; j <= n - k; j++) {
                // Remove the elements from the column that is leaving the window (column j-1)
                for (int r = i; r < i + k; r++) {
                    removeElement(currentWindowCounts, grid[r][j - 1]);
                }
                // Add the elements from the column that is entering the window (column j+k-1)
                for (int r = i; r < i + k; r++) {
                    addElement(currentWindowCounts, grid[r][j + k - 1]);
                }
                ans[i][j] = calculateMinDiff(currentWindowCounts);
            }
        }

        return ans;
    }
}