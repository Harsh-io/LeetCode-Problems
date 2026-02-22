// //BRUTE FORCE
// class Solution {
//     public int scoreDifference(int[] arr) {
//         boolean P1_Active = true;
//         boolean P2_Active = false;
//         int run1 = 0, run2 = 0;

//         for(int i=0; i<arr.length; i++){
            
//             if(arr[i]%2 != 0){
//                 //switch a and b
//                 if(P1_Active){
//                     P1_Active = false;
//                     P2_Active = true;
//                 }
//                 else{
//                     P1_Active = true;
//                     P2_Active = false;
//                 }
//             }
            
//             if((i+1)%6 == 0){
//                 //switch a and b
//                 if(P1_Active){
//                     P1_Active = false;
//                     P2_Active = true;
//                 }
//                 else{
//                     P1_Active = true;
//                     P2_Active = false;
//                 }
//             }
            
//             if(P1_Active){
//                 run1 += arr[i];
//             }
//             else{
//                 run2+= arr[i];
//             }
//         }
//         return run1-run2;
//     }
// }

//OPTIMIZED

class Solution {
    public int scoreDifference(int[] arr) {
        boolean isP1Active = true;
        int diff = 0;

        for(int i=0; i<arr.length; i++){
            
            if((arr[i] & 1) == 1){
                isP1Active = !isP1Active;
                //Takes current value-> Reverse it->Store it back into isP1Active
            }
            if((i+1)%6 == 0){
                isP1Active = !isP1Active;
            }
            if(isP1Active){
                diff += arr[i];
            }
            else{
                diff -= arr[i];
            }
        }
        return diff;
    }
}