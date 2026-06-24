class Solution {
    public int[] leftRightDifference(int[] arr) {
        int n = arr.length;
        int[] answer = new int[n];
        int totalSum = 0;

        for (int num : arr) {
            totalSum += num;
        }
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            answer[i] = Math.abs(leftSum - rightSum);
            leftSum += arr[i];
        }
        return answer;
    }
}