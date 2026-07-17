// solve for maximum length sub array with at most 2 types of numbers

//OPTIMAL : SW
class Solution {
    public int totalFruit(int[] arr) {
        
        int maxlen = 0, r=0, l=0;
        Map<Integer, Integer> map = new HashMap<>();

        while(r < arr.length){
            
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while(map.size() > 2){

                map.put(arr[l] ,  map.getOrDefault(arr[l], 0) - 1);
                if(map.get(arr[l]) ==  0) map.remove(arr[l]); 
                l++;

            }

            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }
        return maxlen;
    }
}

//TC: O(N)
//SC: O(3)