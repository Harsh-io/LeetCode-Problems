class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        
        StringBuilder ans = new StringBuilder();

        for(String str : words){
            int sum = 0;

            for (int i = 0; i < str.length(); i++) {
                sum += weights[str.charAt(i) - 'a'];
            }

            sum = sum % 26;
            ans.append((char)('z' - sum));
        }

        return ans.toString();
    }

}