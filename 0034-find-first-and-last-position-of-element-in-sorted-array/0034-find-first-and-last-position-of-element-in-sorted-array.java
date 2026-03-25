class Solution {
    public int[] searchRange(int[] arr, int t) {
	    int l = 0;
	    int r = arr.length-1;
	    int[] ans = {-1,-1};
	    
	    
	    while(l<=r){
	        int m = l + (r-l)/2;
	        if(arr[m] == t){
	            ans[0] = m;
	            r = m-1;
	        }
	        else if(arr[m] > t){r = m-1;}
	        else{l=m+1;}
	    }
	    
	    l = 0;
	    r = arr.length-1;
	    
	    while(l<=r){
	        int m = l + (r-l)/2;
	        if(arr[m] == t){
	            ans[1] = m;
	            l = m+1;
	        }
	        else if(arr[m] > t){r = m-1;}
	        else{l=m+1;}
	    }
	    return ans;
	}
}
