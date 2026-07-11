class Solution {
    
    boolean[] used;
    Set<List<Integer>> ans = new HashSet<>();
    
    public List<List<Integer>> permuteUnique(int[] arr) {
        if(arr.length == 0) return new ArrayList<>();
        used = new boolean[arr.length];
        generate(arr, new ArrayList<>());
        return new ArrayList<>(ans);
    }

    public void generate(int[] arr, ArrayList<Integer> temp){

        if(temp.size() == arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<arr.length; i++){

            if(used[i]) continue;

            temp.add(arr[i]);
            used[i] = true;
            
            generate(arr, temp);

            //backtrack
            temp.remove(temp.size()-1);
            used[i] = false;

        }
    }
}