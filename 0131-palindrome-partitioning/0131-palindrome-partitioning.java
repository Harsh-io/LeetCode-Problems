///CANT USE:  take and NotTake Approach because  we dont need subsequences we need substrings : this appraoch may skip characters 

class Solution {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {

        if(s.length() == 0 ) return ans;
        generate(0, s, new ArrayList<>());
        return ans;
    }

    public void generate(int i, String s, ArrayList<String> arr){

        if(i == s.length()){
            ans.add(new ArrayList<>(arr));
            return;
        }

        for(int j = i; j<s.length(); j++){
            String str = s.substring(i, j+1);

            if(palindrome(str)){
                arr.add(str);

                generate(j+1, s, arr);

                arr.remove(arr.size() - 1);
            }
        }
    }

    public boolean palindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}