class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] arr) {
        generate(0, arr);
        return ans;
    }

    public void generate(int idx, int[] arr) {
        
        if (idx == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : arr) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            
            swap(arr, idx, i);
            
            generate(idx + 1, arr);
            
            swap(arr, idx, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}