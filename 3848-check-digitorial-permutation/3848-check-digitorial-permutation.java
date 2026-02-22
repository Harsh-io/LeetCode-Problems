// class Solution {
//     public boolean isDigitorialPermutation(int n) {
//         int num = n;
//         int sum = 0;
//         while (num > 0){
//             int m =  num%10;
//             num = num/10;
            
//             sum += fact(m);
//             }

//         int[] freq1 = new int[10];
//         int temp = n;
//         while(temp > 0){
//             freq1[temp % 10]++;
//             temp /= 10;
//         }

//         int[] freq2 = new int[10];
//         temp = sum;
//         while(temp > 0){
//             freq2[temp % 10]++;
//             temp /= 10;
//         }
//         for(int i = 0; i < 10; i++){
//             if(freq1[i] != freq2[i]){
//             return false;
//             }
//         }
//         return true;
//     }
//     public int fact(int k) {
//         if (k == 0) {
//             return 1;
//         }
//         int fac = k * fact(k - 1);
//         return fac;
//     }
// }



class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] fact = new int[10];
        fact[0] = 1;
        for(int i = 1; i <= 9; i++){
            fact[i] = fact[i-1] * i;
        }
        int sum = 0;
        int num = n;
        while (num > 0){
            int digit = num % 10;
            sum += fact[digit];
            num /= 10;
        }

        int[] freq1 = new int[10];
        int temp = n;
        while(temp > 0){
            freq1[temp % 10]++;
            temp /= 10;
        }

        int[] freq2 = new int[10];
        temp = sum;
        while(temp > 0){
            freq2[temp % 10]++;
            temp /= 10;
        }
        for(int i = 0; i < 10; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
    }
}