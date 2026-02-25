class Solution {
    public boolean check(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {

                for (int idx = i + 1; idx < arr.length - 1; idx++) {
                    if (arr[idx] > arr[idx + 1]) {
                        return false;
                    }
                }
                if (arr[arr.length - 1] > arr[0]) {
                    return false;
                }
            }
        }
        return true;
    }
}