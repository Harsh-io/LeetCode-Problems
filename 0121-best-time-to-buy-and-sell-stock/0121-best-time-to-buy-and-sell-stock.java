
class Solution {
    public static int maxProfit(int[] arr) {

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {min = arr[i];}
            
            int profit = arr[i] - min;

            if(profit > maxProfit){maxProfit = profit;}
        }
        return maxProfit;
    }
}

//BRUTE FORCE 
// class Solution {
//     public static int maxProfit(int[] arr) {
// 		int p = 0;
// 		int maxp = 0;
// 		int tp = 0;
		
// 		for(int i=0; i<arr.length; i++){
// 		    for(int j=i+1; j<arr.length; j++){
// 		        if(arr[i] < arr[j]){
// 		            tp = Math.max(p, (arr[j] - arr[i]));
// 		        }
// 		        maxp = Math.max(tp, maxp);
// 		    }
// 		}
// 		return maxp;
		
// 	}
// }
