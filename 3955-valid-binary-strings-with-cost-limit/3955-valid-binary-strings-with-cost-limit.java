class Solution {
    public List<String> generateValidStrings(int n, int k) {
        
        ArrayList<String> arr = new ArrayList<>();
        
        if(n == 0) return arr;

        solve(arr, "", n, k) ;

        return arr;
    }

    public void solve(ArrayList<String> arr, String val, int n, int k){
        
        if(val.length() == n){

            int cost = 0;
            for(int i=0; i<val.length(); i++){
                if( val.charAt(i) == '1') cost += i;
            }
            if(cost <= k) arr.add(val);
            return;
        }

        solve(arr, val + "0", n, k);
        
        // add 1 only if previous char is not 1
        if(val.length() == 0 || val.charAt(val.length() - 1) != '1') {
            solve(arr, val + "1" , n, k);
        }

        
    }
}