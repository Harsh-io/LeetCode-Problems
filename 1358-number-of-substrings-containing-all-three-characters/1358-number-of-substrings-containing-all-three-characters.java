//Brute Force
// class Solution {
//     public int numberOfSubstrings(String s) {

//         int n = s.length();
//         int total = 0;

//         for(int i = 0; i < n; i++) {
//             int cntA = 0;
//             int cntB = 0;
//             int cntC = 0;
//             for(int r = i; r < n; r++) {
//                 char ch = s.charAt(r);
//                 if(ch== 'a') cntA++;
//                 else if(ch == 'b') cntB++;
//                 else cntC++;

//                 if(cntA >= 1 && cntB >= 1 && cntC >= 1){
//                     total += n - r;
//                     break;
//                 }
//             }
//         }
//         return total;
//     }
// }
class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int cntA = 0; 
        int cntB = 0; 
        int cntC = 0; 
        int total  = 0;

        while(r < s.length()){
            // add s[r] to count
            char ch = s.charAt(r);
            if(ch == 'a') cntA++;
            else if(ch == 'b') cntB++;
            else cntC++;
             r++;

            while(cntA >= 1 && cntB >= 1 && cntC >= 1) {
            // remove s[l] from count
            total += s.length() - r + 1;

            ch = s.charAt(l);
            if(ch == 'a') cntA--;
            else if(ch == 'b') cntB--;
            else cntC--;
            l++;
            }
        }
        return total;
    }
}        