class Solution {
    
    ArrayList<String> ans = new ArrayList<>();

    public String getPermutation(int n, int k) {

        boolean[] used = new boolean[n+1];

        generate(n, new StringBuilder(), used);

        // Permutations are already generated in sorted order
        return ans.get(k - 1); // k is 1-indexed

    }

    public void generate(int n, StringBuilder temp, boolean[] used) {

        if(temp.length() == n){
            ans.add(temp.toString());
            return;
        }

        for(int i=1; i<=n; i++){

            if (!used[i]) {
                
                used[i] = true;
                temp.append(i);
                
                generate(n, temp, used);
                temp.deleteCharAt(temp.length()-1);
                used[i] = false;
            }
        }
    }
}