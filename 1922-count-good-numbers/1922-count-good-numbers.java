class Solution {
    static final long Mod = 1000000007L;

    public int countGoodNumbers(long n) {

        if(n == 0) return 0;

        long odd = Pow(4, n/2);         //odd
        long even = Pow(5, (n+1)/2);     //for even -> (n/2 + n%2) also works

        return (int)((odd * even) % Mod); 
    }

    public long Pow(long a, long b){

        if(b == 0) return 1;
    
        long half = Pow(a, b/2);
        long result = (half * half) % Mod;   //or half *= half;  

        if(b%2 == 1) return (a * result) % Mod;

    return result; 
    }
}
