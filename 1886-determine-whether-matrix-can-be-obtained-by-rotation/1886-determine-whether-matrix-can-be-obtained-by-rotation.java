class Solution {
    public boolean findRotation(int[][] arr, int[][] t) {
        for (int k = 0; k < 4; k++) { //maximum 3 rotation required
            if (isEqual(arr, t)) return true;
            arr = rotate(arr);
        }
        return false;
    }

    // two matrices are equal
    private boolean isEqual(int[][] a, int[][] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }

    // Rotate matrix 90 degree
    private int[][] rotate(int[][] arr) {
        int n = arr.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = arr[i][j];
            }
        }
        return res;
    }
}