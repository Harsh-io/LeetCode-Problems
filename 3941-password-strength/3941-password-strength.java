class Solution {
    public int passwordStrength(String s) {

        boolean [] lower = new boolean[26];
        boolean [] upper = new boolean[26];
        boolean [] number = new boolean[10];
        boolean [] special = new boolean[4];
        
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);

            if(x >= 'a' && x <= 'z'){

                int idx = x - 'a';
                if(lower[idx] == false){
                   ans += 1; 
                    lower[idx] = true;
                }
            }else if(x >= 'A' && x<= 'Z'){
                
                int idx = x - 'A';
                if(upper[idx] == false){
                   ans += 2; 
                    upper[idx] = true;
                }
            }else if(x >= '0' && x <= '9'){

                int idx = x - '0';
                if(number[idx] == false){
                   ans += 3;
                    number[idx] = true;
                }
            }else{
                int idx = "!@#$".indexOf(x);

                if(idx != -1 && special[idx] == false){
                    ans += 5;
                    special[idx] = true;
                }
            }
        }
        return ans;
    }
}