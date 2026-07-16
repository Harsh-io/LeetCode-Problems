// class Solution {

//     HashMap<String, Integer> map = new HashMap<>();
//     public int findTargetSumWays(int[] arr, int target) {
//         return solve(arr, target, 0, 0);
//     }

//     public int solve(int[] arr, int target, int index, int sum){

//         if(index == arr.length){
//             return sum == target ? 1 : 0;
//         }

//         String key = index + "," + sum;
//         if(map.containsKey(key)) return map.get(key);

//         int takep = solve(arr, target, index+1, sum + arr[index]);

//         int takem = solve(arr, target, index+1, sum - arr[index]);

//         map.put(key, takep + takem);
//         return map.get(key);
//     }
// }

class Solution {

    Integer[][] dp = new Integer[21][2001];

    public int findTargetSumWays(int[] arr, int target) {
        return solve(arr, target, 0, 0);
    }

    public int solve(int[] arr, int target, int index, int sum){

        if(index == arr.length){
            return sum == target ? 1 : 0;
        }

        if(dp[index][sum + 1000] != null){
            return dp[index][sum + 1000];
        }

        int takep = solve(arr, target, index + 1, sum + arr[index]);

        int takem = solve(arr, target, index + 1, sum - arr[index]);

        return dp[index][sum + 1000] = takep + takem;
    }
}