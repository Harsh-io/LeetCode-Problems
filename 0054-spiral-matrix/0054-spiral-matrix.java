class Solution {
    public List<Integer> spiralOrder(int[][] arr) {

        List<Integer> ans = new ArrayList<>();

        int rows = arr.length;
        int cols = arr[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            // Top Row
            for (int j = left; j <= right; j++) {
                if (!visited[top][j]) {
                    ans.add(arr[top][j]);
                    visited[top][j] = true;
                }
            }
            top++;

            // Right Column
            for (int i = top; i <= bottom; i++) {
                if (!visited[i][right]) {
                    ans.add(arr[i][right]);
                    visited[i][right] = true;
                }
            }
            right--;

            // Bottom Row
            for (int j = right; j >= left; j--) {
                if (!visited[bottom][j]) {
                    ans.add(arr[bottom][j]);
                    visited[bottom][j] = true;
                }
            }
            bottom--;

            // Left Column
            for (int i = bottom; i >= top; i--) {
                if (!visited[i][left]) {
                    ans.add(arr[i][left]);
                    visited[i][left] = true;
                }
            }
            left++;
        }

        return ans;
    }
}