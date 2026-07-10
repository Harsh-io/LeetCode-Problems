class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        
        solve(1, k, n, 0, new ArrayList<>());
        return ans;
    }

    public void solve(int idx, int k, int n, int sum, ArrayList<Integer> arr){
        
        if(arr.size() == k){
            if(sum == n){
                ans.add(new ArrayList<>(arr));
                return;
            }else return;
        }


        for(int i=idx; i<=9; i++){
            //take
            arr.add(i);
            solve(i+1, k, n, sum+i, arr);
            arr.remove(arr.size()-1);
        }
        
    }
}