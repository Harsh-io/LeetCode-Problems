class Solution {

    List<String> ans = new ArrayList<>();
    HashMap<Character, String>map = new HashMap<>();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return ans;

            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");

        solve(0, digits, new StringBuilder());
        return ans;
    }


    public void solve(int i, String digits, StringBuilder sb ){

            //base case
            if(i == digits.length()){
                ans.add(sb.toString());
                return;
            }

            //get the set of letters 
            String letters = map.get(digits.charAt(i));

            for(int j=0; j<letters.length(); j++){

                //choose 
                sb.append(letters.charAt(j));

                // move to next digit
                solve(i+1, digits, sb);

                //backtrack
                sb.deleteCharAt(sb.length()-1);
            }
    }
}