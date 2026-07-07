class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long ans = 0;
        long r = 0;

        while(n > 0){
            r = n%10;
            n /= 10;

            if(r != 0){
                sum += r;
                ans = ans*10 + r;
            }
        }
        System.out.println(ans);
        System.out.println(sum);

        ans = reverse(ans);
        return ans*sum;
    }
    public long reverse(long n){

        long num = n;
        n = 0;
        long r = 0;
        while(num > 0){
            r = num%10;
            num /= 10;

            n = n*10 + r;
        }
        return n;
    }
}