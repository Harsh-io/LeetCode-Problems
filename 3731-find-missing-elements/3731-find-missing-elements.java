class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);

        for(int i=1; i<arr.length; i++){

            if(arr[i] != arr[i-1]+1) {
                for(int j = arr[i-1]+1 ; j<arr[i]; j++){

                    ans.add(j);
                }
            }
        }

        return ans;
    }
}