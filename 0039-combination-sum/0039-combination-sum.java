class Solution {

    public List<List<Integer>> combinationSum(int[] arr, int target) {

        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        generate(0, arr, target, 0, combinations, temp);

        return combinations;
    }

    public void generate(int i, int[] arr, int t, int sum, List<List<Integer>> combinations, List<Integer> temp) {

        if (i == arr.length) {
            if (sum == t) {
                combinations.add(new ArrayList<>(temp));
            }
            return;
        }

        if (sum > t) return;

        // pick
        temp.add(arr[i]);
        generate(i, arr, t, sum + arr[i], combinations, temp);

        temp.remove(temp.size() - 1);

        // not pick
        generate(i + 1, arr, t, sum, combinations, temp);
    }
}