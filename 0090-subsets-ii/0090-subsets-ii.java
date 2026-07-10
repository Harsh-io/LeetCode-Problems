// class Solution {
//     List<List<Integer>> ans = new ArrayList<>();
//     public List<List<Integer>> subsetsWithDup(int[] arr) {

//         Arrays.sort(arr);
//         solve(0, arr, new ArrayList<>());
//         return ans;
//     }
    
//     public void solve(int i, int[] arr, List<Integer> temp){
        
//         if(i == arr.length){
//             ans.add(new ArrayList<>(temp));
//             return;
//         }

//         //take
//         temp.add(arr[i]);
//         solve(i+1, arr, temp);
//         temp.remove(temp.size()-1);


//         // skip all duplicate elements for not-take
//         int idx = i + 1;

//         while (idx < arr.length && arr[idx] == arr[i]) {
//             idx++;
//         }

//         // not take
//         solve(idx, arr, temp);
        
//     }
// }

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] arr) {

        Arrays.sort(arr);
        solve(0, arr, new ArrayList<>());

        return ans;
    }

    public void solve(int idx, int[] arr, List<Integer> temp) {

        // Every temp is a valid subset
        ans.add(new ArrayList<>(temp));

        for (int i = idx; i < arr.length; i++) {

            // Skip duplicate elements at the same recursion level
            if (i > idx && arr[i] == arr[i - 1]) continue;

            // take
            temp.add(arr[i]);
            solve(i + 1, arr, temp);
            temp.remove(temp.size() - 1);
        }
    }
}