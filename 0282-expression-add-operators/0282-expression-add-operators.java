//BODMAS : Multiply opr works from right to left
//DFS + Backtracking : generate all possible subseq of the num| i.e 1,2,3,12,23,123
//Keep in mind that leading zero number is not valid | ex:105 : i.e 05 is not a valid number
//if we encounter * we need to do backtracking and re compute the ans

import java.util.*;

class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String s, int target) {
        helper(s, target, 0, new StringBuilder(), 0, 0);
        return ans;
    }

    public void helper(String s, int target, int i, StringBuilder path, long eval, long residual) {
        if (i == s.length()) {
            if (eval == target)
                ans.add(path.toString());
                return;
        }

        long num = 0;

        // Try parsing numbers of different lengths starting from 'index'
        for (int j = i; j < s.length(); j++) {
            //handle 0
            if (j > i && s.charAt(i) == '0') break; //j>i means if there is a next element after 0 (eg 05) then invalid

            num = num * 10 + (s.charAt(j) - '0');
            String currstr = s.substring(i, j + 1);

            //store current length so that we can backtrack later
            int len = path.length();

            if (i == 0) { //Position 0: The first number in the expression doesn't have a preceding operator
                path.append(currstr);
                helper(s, target, j + 1, path, num, num);
                path.setLength(len); //backtrack

            } else {
                path.append("+").append(currstr);
                helper(s, target, j + 1, path, eval + num, num);
                path.setLength(len); //backtrack

                path.append("-").append(currstr);
                helper(s, target, j + 1, path, eval - num, -num); //pass -num not num
                path.setLength(len); //backtrack

                path.append("*").append(currstr);
                helper(s, target, j + 1, path,eval - residual + residual * num,residual * num);
                path.setLength(len); //backtrack
            }
        }
    }
}