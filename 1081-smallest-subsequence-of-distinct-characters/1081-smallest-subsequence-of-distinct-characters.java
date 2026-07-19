class Solution {

    public String smallestSubsequence(String s) {

        int[] last = new int[26]; //store the last index of each character from the string wrt to their ASCII value(0-26)
        for(int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(visited[ch - 'a']) continue;

			//Conditn 1: Check if the last char in stack bigger than the curr char if yes remove
			//Conditn 2:  Will this character appear again later
			//Conditn 3: Only remove char if stack is not empty
			// breakdown : while(top > current && top_can_be_found_again)
            
            while(stack.length()>0 && stack.charAt(stack.length()-1)>ch &&  last[stack.charAt(stack.length()-1)-'a']>i){

                visited[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(ch);
            visited[ch - 'a'] = true;
        }
        return stack.toString();
    }
}
// Time: O(n)
// Space: O(26)