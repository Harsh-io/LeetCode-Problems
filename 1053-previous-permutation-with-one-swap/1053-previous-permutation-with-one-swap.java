/*Failed Test Case:
Input: arr = [3,1,1,3]
Output: [1,1,3,3]
Expected: [1,3,1,3]

Reason: With duplicate smaller elements, we must choose the leftmost occurrence of the largest smaller element to get the maximum permutation smaller than the original.*/

class Solution {
    public int[] prevPermOpt1(int[] arr) {

        int n = arr.length;
        int idx = -1;

        // Find first decreasing element from right
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                idx = i;
                break;
            }
        }

        if (idx == -1) return arr;

        int j = n - 1;

        // Find the largest element smaller than arr[idx]
        while (j > idx && arr[j] >= arr[idx]) {
            j--;
        }

        // Skip duplicate values
        while (j > idx && arr[j] == arr[j - 1]) {
            j--;
        }

        // Swap
        int temp = arr[idx];
        arr[idx] = arr[j];
        arr[j] = temp;

        return arr;
    }
}