class Solution {

    public List<String> generateParenthesis(int n) {

        ArrayList<String> arr = new ArrayList<>();
        solve(n, n, arr, "");
        return arr;
    }

    void solve(int open, int close, ArrayList<String> arr, String op) {

        if (open == 0 && close == 0) {
            arr.add(op);
            return;
        }

        if (open != 0) {
            solve(open - 1, close, arr, op + "(");
        }

        if (close > open) {
            solve(open, close - 1, arr, op + ")");
        }
    }
}