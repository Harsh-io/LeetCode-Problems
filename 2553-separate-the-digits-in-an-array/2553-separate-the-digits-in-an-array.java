class Solution {
    public int[] separateDigits(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr) {
            String s = String.valueOf(num);

            for (char ch : s.toCharArray()) {
                list.add(ch - '0');
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}