class Solution {
    public int addDigits(int num) {
    if(num < 10){return num;}
    while(num >= 10){
        num = findsum(num);
    }
    return num;
    }
    public int findsum(int n){
        int sum = 0;
        while(n > 0){
            int r = n%10;
            n = n/10;
            sum = sum + r;
        }
        return sum;
    }
}