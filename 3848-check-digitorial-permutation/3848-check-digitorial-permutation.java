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
        int num = n;
        int sum = 0;
        while (num > 0){
            int m =  num%10;
            num = num/10;
            int[] fact = {1,1,2,6,24,120,720,5040,40320,362880};
            sum += fact[m];
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