class Solution {
    public String largestNumber(int[] arr) {

        String[] ans = new String[arr.length];

        int i = 0;
        for (int num : arr) {
            ans[i++] = String.valueOf(num);
        }

        Arrays.sort(ans, (a, b) -> (b + a).compareTo(a + b));

        if (ans[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String str : ans) {
            sb.append(str);
        }

        return sb.toString();
    }
}