import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> seen = new HashSet<>();

                for (int k = j + 1; k < n; k++) {
                    long required = (long) target - arr[i] - arr[j] - arr[k];

                    if (required < Integer.MIN_VALUE || required > Integer.MAX_VALUE) continue;

                    if (seen.contains((int) required)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], (int) required);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}