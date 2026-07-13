//calculate total sum/resources consumed by all elements 
//find missing resources if k < total sum -> total operations -> total cost = (n*n+1)/2
class Solution {
    public int minimumCost(int[] nums, int k) {
        long mod = 1_000_000_007L;
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        long operations = 0;

        if (sum > k) {
            long missing = sum - k;
            operations = (missing + k - 1L) / k;
        }

        // Cost = 1 + 2 + ... + operations
        long a = operations;
        long b = operations + 1;

        if (a % 2 == 0) a /= 2;
        else b /= 2;
        //one of them will always be even hence 

        return (int) ((a % mod) * (b % mod) % mod);
        //operations * (operations + 1) / 2
    }
}

//example :
//let a = 4 && b = 5 
//cost = 2 * 5 = 10 && 1 + 2 + 3 + 4 = 10