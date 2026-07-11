class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] arr) {

        if(arr.length == 0) return new ArrayList<>();

        generate(0, arr);

        return ans;
    }

    public void generate(int idx, int[] arr){

        if(idx == arr.length){
            ArrayList<Integer> temp = new ArrayList<>();

            for(int num: arr){
                temp.add(num);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Stores values already placed at the current idx
        HashSet<Integer> used = new HashSet<>();

        for(int i=idx; i<arr.length; i++){

            // Same value has already been placed at idx
            if (used.contains(arr[i])) continue;
            used.add(arr[i]);

            swap(i, idx, arr);

            generate(idx+1, arr);

            swap(i, idx, arr);
        }
    }

    public void swap(int i, int j, int[] arr){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return;
    }
}

