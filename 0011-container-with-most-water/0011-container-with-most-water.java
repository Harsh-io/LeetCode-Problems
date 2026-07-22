class Solution {
    public int maxArea(int[] height) {
        
        int l = 0;
        int r = height.length-1;
        int area = 0;
        int min = 0;
        while(l < r){
            
            min = Math.min(height[l], height[r]);
            if((min * (r-l)) > area) {
                area = min*(r-l);
            }
            
            if(height[l] > height[r]) r--;
            else l++;
        }
        
        return area;
    }
}