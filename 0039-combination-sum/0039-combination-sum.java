// class Solution {
//     List<List<Integer>> ans = new ArrayList<>();

//     public List<List<Integer>> combinationSum(int[] arr, int target) {
//         List<Integer> temp = new ArrayList<>();
//         generate(0, target, temp, arr);
//         return ans;
//     }

//     public void generate(int i, int target, List<Integer> temp, int[] arr) {

//         if (target == 0) {
//             ans.add(new ArrayList<>(temp));
//             return;
//         }

//         if (i == arr.length || target < 0) return;

//         // take
//         temp.add(arr[i]);
//         generate(i, target - arr[i], temp, arr);

//         // backtrack
//         temp.remove(temp.size() - 1);

//         // not take
//         generate(i + 1, target, temp, arr);
//     }
// }

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] arr, int target) {

        ArrayList<Integer> sum = new ArrayList<>();
        solve(0, arr, target, sum);

        return ans;
    }

    public void solve(int idx, int[] arr, int t, ArrayList<Integer> sum){

        if(t == 0){
           //ERROR FOR { ans.add(sum);} -> ans.add(sum) stores the same list reference if we change sum : ans also changes 
           ans.add(new ArrayList<>(sum));
            return;
        }

        else if(t < 0 || idx == arr.length){
            return ;
        }

        //take
        sum.add(arr[idx]);
        solve(idx, arr, t-arr[idx], sum);
        sum.remove(sum.size()-1);

        //not take
        solve(idx+1, arr, t, sum);

    }
}


// solve(idx, arr, t - arr[idx], sum.add(arr[idx])); -> here sum.add(arr[idx]) adds the element and returns true  -> But solve() expects an ArrayList<Integer>