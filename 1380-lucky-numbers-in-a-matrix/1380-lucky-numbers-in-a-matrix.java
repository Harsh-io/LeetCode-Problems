class Solution {
    public List<Integer> luckyNumbers(int[][] arr) {

        List<Integer> ans = new ArrayList<>();

        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {

            boolean found = true;
            int min = Integer.MAX_VALUE;
            int x = 0;

            // Find min in the row
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] < min) {
                    min = arr[i][j];
                    x = j;
                }
            }

            // Check if it is max in its column
            for (int k = 0; k < rows; k++) {
                if (arr[k][x] > min) {
                    found = false;
                    break;
                }
            }

            if (found) ans.add(min);
        }

        return ans;
    }
}