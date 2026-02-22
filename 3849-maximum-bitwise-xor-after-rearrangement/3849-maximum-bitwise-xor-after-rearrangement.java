// class Solution {
//     public String maximumXor(String s, String t) {

//         char[] arr1 = s.toCharArray();
//         char[] arr2 = t.toCharArray();

//         int cnt1 = 0;
//         int cnt0 = 0;

//         // Count bits in t
//         for(int j = 0; j < arr2.length; j++){
//             if(arr2[j] == '1') cnt1++;
//             else cnt0++;
//         }

//         // Rearrange t to maximize XOR
//         for(int i = 0; i < arr1.length; i++){
//             if(arr1[i] == '0'){
//                 if(cnt1 > 0){
//                     arr2[i] = '1';
//                     cnt1--;
//                 } else {
//                     arr2[i] = '0';
//                     cnt0--;
//                 }
//             } 
//             else { // arr1[i] == '1'
//                 if(cnt0 > 0){
//                     arr2[i] = '0';
//                     cnt0--;
//                 } else {
//                     arr2[i] = '1';
//                     cnt1--;
//                 }
//             }
//         }

//         StringBuilder result = new StringBuilder();

//         for(int i = 0; i < arr1.length; i++){
//             int bit1 = arr1[i] - '0';
//             int bit2 = arr2[i] - '0';

//             int xor = bit1 ^ bit2;

//             result.append(xor);
//         }

//         return result.toString();
//     }
// }

class Solution {
    public String maximumXor(String s, String t) {

        int ones = 0;

        // Count 1s in t
        for(char c : t.toCharArray()){
            if(c == '1') ones++;
        }

        int zeros = t.length() - ones;

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '0'){
                if(ones > 0){
                    result.append('1');
                    ones--;
                } else {
                    result.append('0');
                    zeros--;
                }
            }
            else { // s[i] == '1'
                if(zeros > 0){
                    result.append('1');
                    zeros--;
                } else {
                    result.append('0');
                    ones--;
                }
            }
        }

        return result.toString();
    }
}