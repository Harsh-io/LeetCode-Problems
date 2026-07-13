//generating sequencially will inc TC and also value after 9 -> 10 is not a digit

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String digits = "123456789";

        int minlen = String.valueOf(low).length();
        int maxlen = String.valueOf(high).length();

        for(int len=minlen; len<= maxlen; len++){
            for(int i=0; i+len <= digits.length(); i++){

                int j = i + len;

                int num = Integer.parseInt(digits.substring(i,j));

                if(num >= low && num <= high) ans.add(num);

            }
        }
        return ans;
    }
}

//Time complexity: O(1) because the string always has only 9 digits.
//Space complexity: O(1) excluding the answer list.