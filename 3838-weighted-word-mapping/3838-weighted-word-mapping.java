class Solution {
    public String mapWordWeights(String[] words, int[] weights) {

        String ans = "";   //OR use StringBuilder
        // StringBuilder sb = new StringBuilder();

        for(String str : words){
            int sum = 0;
            int i=0;

            while(i < str.length()){
                int w = (int) (str.charAt(i) - 'a');
                sum += weights[w];
                i++;
            }

            sum = sum % 26;
            // sb.insert((char) Math.abs(26-sum)) ;
            ans = ans + (char) ('z' - sum);
        }

        return ans;
    }

}