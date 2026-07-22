class Solution {
    
    public String countAndSay(int n) {

        return solve(1, n , new StringBuilder("1"));
    }

    public String solve(int i, int n,  StringBuilder sb){

        if(i == n){
            return sb.toString();
        } 

        String str = generate(sb);
        return solve(i+1, n, new StringBuilder(str));
    }

    public String generate(StringBuilder sb){
        StringBuilder ans = new StringBuilder();

        int cnt  = 1;

        for(int i=1; i<sb.length(); i++){
            if(sb.charAt(i) == sb.charAt(i-1)) cnt++;

            else{
                ans.append(cnt);
                ans.append(sb.charAt(i - 1));
                cnt = 1;
            }
        }

        ans.append(cnt);
        ans.append(sb.charAt(sb.length()-1));

        return ans.toString();
    }
}