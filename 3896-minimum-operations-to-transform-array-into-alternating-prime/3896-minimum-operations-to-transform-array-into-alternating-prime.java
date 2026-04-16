class Solution {
    public int minOperations(int[] arr) {
        int cnt = 0; 
        for(int i=0; i<arr.length; i=i+2){
            int num = arr[i];
            while(!isPrime(num)){
                num = num+1;
                cnt++;
            }
        }
        for(int j=1; j<arr.length; j=j+2){
            int n = arr[j];
            while(isPrime(n)){
                n = n+1;
                cnt++;
            }
        }
        return cnt;
    }
    
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}