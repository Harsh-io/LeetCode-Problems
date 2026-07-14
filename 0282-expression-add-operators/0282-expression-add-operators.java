//BODMAS : Multiply opr works from right to left 
//DFS + Backtracking : generate all possible subseq of the num| i.e 1,2,3,12,23,123 
//Keep in mind that leading zero number is not valid | ex:105 : i.e 05 is not a valid number
// if we encounter * we need to do backtracking and re compute the ans

class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> addOperators(String s, int target) {

        helper(s , target, 0, "", 0, 0);
        return ans;
    }

    public void helper(String s, int target, int i, String path, long eval ,long residual){

        if(i == s.length()){
            if(eval == target){
                ans.add(path);
                return;
            }
        }

        String currstr = "";
        long num = 0;

        //backtracking loop -> try all possible combinations
        for(int j=i; j<s.length(); j++){
            
            //handle 0
            if(j > i && s.charAt(i) == '0') return; //j>i means if there is a next element after 0 (eg 05) then invalid
            currstr += s.charAt(j);
            num = num*10 + s.charAt(j) - '0';

            if(i == 0){ // if its the starting element there is nothing to add [eval or residual]
                helper(s, target, j+1, path+currstr, num , num);
            }else{
                helper(s, target, j+1, path + "+" + currstr, eval +  num , num);
                helper(s, target, j+1, path + "-" + currstr, eval - num , -num);//pass -num not num
                helper(s, target, j+1, path + "*" + currstr, eval - residual + residual * num , residual * num);
            }
        }
    }
}