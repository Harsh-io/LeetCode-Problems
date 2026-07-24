class Solution {

    public List<List<Integer>> generate(int N) {

        List<List<Integer>> ans = new ArrayList<>();

        for(int row = 1; row <= N; row++) {
            List<Integer> temp = new ArrayList<>();

            for(int col = 1; col <= row; col++) {
                temp.add((int)findPascalElement(row - 1, col - 1));
            }
            ans.add(temp);
        }
        return ans;
    }


    public long findPascalElement(int r, int c) {
        // Calculate C(r,c)
        long result = 1;
        // Optimization: C(n,r) = C(n,n-r)
        c = Math.min(c, r-c);

        for(int i = 0; i < c; i++) {
            result *= (r - i);
            result /= (i + 1);
        }
        return result;
    }
}