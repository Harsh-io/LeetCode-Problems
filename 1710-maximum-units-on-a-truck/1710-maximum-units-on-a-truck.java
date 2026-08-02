class Solution {
    public int maximumUnits(int[][] arr, int truckSize) {
        
        Arrays.sort(arr, (a,b) -> {return b[1] - a[1];});
        int sum = 0;

        for(int i=0; i<arr.length; i++){
            
            if(arr[i][0] < truckSize){
                truckSize -= arr[i][0];
                sum += arr[i][1] * arr[i][0];
            }
            else {
                sum += arr[i][1] * truckSize;
                break;
            }
        }

        return sum;
    }
}