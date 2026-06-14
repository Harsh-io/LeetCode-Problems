class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        generate(0, target, new ArrayList<>(), arr);
        return ans;
    }

    public void generate(int index, int target, List<Integer> temp, int[] arr) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            if (i > index && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            temp.add(arr[i]);
            generate(i + 1, target - arr[i], temp, arr);
            temp.remove(temp.size() - 1);
        }
    }
}