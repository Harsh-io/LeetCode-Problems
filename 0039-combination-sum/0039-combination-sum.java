class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<Integer> temp = new ArrayList<>();
        generate(0, target, temp, arr);
        return ans;
    }

    public void generate(int i, int target, List<Integer> temp, int[] arr) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (i == arr.length || target < 0) return;

        // take
        temp.add(arr[i]);
        generate(i, target - arr[i], temp, arr);

        // backtrack
        temp.remove(temp.size() - 1);

        // not take
        generate(i + 1, target, temp, arr);
    }
}