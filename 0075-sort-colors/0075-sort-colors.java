class Solution {
    public void sortColors(int[] arr) {
        int c0=0, c1=0, c2=0;
        for(int num : arr){
            if(num == 0){c0++;}
            else if(num == 1){c1++;}
            else{c2++;}
        }
        for(int i=0; i<c0; i++){arr[i] = 0;}
        for(int i=c0; i<c0+c1; i++){arr[i] = 1;}
        for(int i=c0+c1; i<arr.length; i++){arr[i] = 2;}
    }
}

//optimal solution
//  int a = 0, b = arr.length - 1;
//         int i = 0;

//         while (i <= b) {
//             if (arr[i] == 0) {
//                 int temp = arr[a];
//                 arr[a] = arr[i];
//                 arr[i] = temp;
//                 a++;
//                 i++;
//             } 
//             else if (arr[i] == 2) {
//                 int temp = arr[b];
//                 arr[b] = arr[i];
//                 arr[i] = temp;
//                 b--;
//             } 
//             else {
//                 i++;
//             }
//         }