class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        
        solve(arr, n, 1, 1, new StringBuilder("("));

        return arr;
    }

    public void solve(List<String> arr, int n, int i, int cnt, StringBuilder sb){

        if( i == 2*n){
            arr.add(sb.toString());
            return;
        }

        if((i + cnt) / 2 < n){
            solve(arr, n, i+1, cnt+1, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }

        if(cnt > 0){
            solve(arr, n, i+1, cnt-1, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}