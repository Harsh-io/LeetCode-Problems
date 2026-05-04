class Solution {
    public List<Integer> findValidElements(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if(n==1){
            ans.add(arr[0]);
            return ans;
        }
        int[] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];


        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1],arr[i]);
        }
    
        int leftMax = arr[0];
        ans.add(arr[0]);
        
        for(int i=1; i<n-1; i++){
            if(arr[i] > leftMax || arr[i] > rightMax[i+1]){
                ans.add(arr[i]);
            }
            leftMax = Math.max(leftMax, arr[i]);
        }
        ans.add(arr[n-1]);
        
        return ans;
    }
}