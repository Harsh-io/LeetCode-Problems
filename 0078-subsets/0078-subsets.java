class Solution {
    public List<List<Integer>> subsets(int[] arr) {

        ArrayList<List<Integer>> subsets = new ArrayList<>();

        int n = arr.length;
        int t = (int)Math.pow(2,n);

        for(int num=0; num<t; num++){

            ArrayList<Integer> ans = new ArrayList<>();

            for(int i=0; i<n; i++){
                
                if((num &(1 << i)) != 0){
                    ans.add(arr[i]);
                }
            }
            subsets.add(ans);
        }
        return subsets;
    }
}