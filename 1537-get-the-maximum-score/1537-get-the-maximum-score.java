class Solution {
    public int maxSum(int[] a, int[] b) {
        int i = 0, j = 0;
        long sum = 0;
        long sumA = 0, sumB = 0;
        long mod = 1000000007;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                sumA += a[i];
                i++;
            } 
            else if (b[j] < a[i]) {
                sumB += b[j];
                j++;
            } 
            else {
                sum += Math.max(sumA, sumB) + a[i];

                sumA = 0;
                sumB = 0;

                i++;
                j++;
            }
        }

        while (i < a.length) {
            sumA += a[i];
            i++;
        }

        while (j < b.length) {
            sumB += b[j];
            j++;
        }

        sum += Math.max(sumA, sumB);

        return (int)(sum % mod);
    }
}