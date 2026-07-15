class Solution {
    public int gcdOfOddEvenSums(int n) {

        int sumOdd = 0;
        int sumEven = 0;
        int prevOdd = 1;
        int prevEven = 2;
        int cnt = 0;
         
       while(cnt < n){
        sumOdd += prevOdd;
        prevOdd = prevOdd+2;
        sumEven += prevEven;
        prevEven = prevEven+2;
        cnt++; 
        
       }
       System.out.println(sumOdd);
       System.out.println(sumEven);

       return findGCD(sumOdd, sumEven);

    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}