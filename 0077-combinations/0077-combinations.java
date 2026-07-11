class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        generate(1, n, k, new ArrayList<>());
        return ans;
    }

    public void generate(int idx, int n, int k, ArrayList<Integer> temp){

        if(temp.size() == k){
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Set<Integer> taken = new HashSet<>();

        for(int i=idx; i<= n; i++){

            // if(taken.contains(i)) continue;
            // else taken.add(i);

            //take 
            temp.add(i);
            generate(i+1, n, k, temp);
            temp.remove(temp.size()-1);

        }
    }
}