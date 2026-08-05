class Solution {
    public boolean asteroidsDestroyed(int mass, int[] arr) {
        
        Arrays.sort(arr);
        long ans = mass;

        for(int i=0; i<arr.length; i++){

            if(ans >= arr[i]) ans += arr[i];
            else return false;
        }

        return true;
    }
}