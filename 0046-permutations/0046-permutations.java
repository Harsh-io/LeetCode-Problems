class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] arr) {
        boolean[] used = new boolean[arr.length];
        generate(arr, new ArrayList<>(), used);
            return ans;
    }

    public void generate(int[] arr, ArrayList<Integer> temp, boolean[] used){

        if(temp.size() == arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int j=0; j<arr.length; j++){

            // Skip the element if already used
            if(used[j]) continue;
                
            temp.add(arr[j]);
            used[j] = true;

            generate(arr, temp, used);

            temp.remove(temp.size()-1);
            used[j] = false;

        }
    }
}