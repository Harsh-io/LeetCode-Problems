class Solution {
    public String removeDuplicates(String s, int k) {
        StringBuilder st = new StringBuilder();
        int cnt[] = new int[s.length()];

        for(char ch : s.toCharArray()) {
            st.append(ch);

            int top = st.length()-1;

            // increase count  if same char
            if(top > 0 && st.charAt(top) == st.charAt(top-1)){
                cnt[top] = cnt[top-1] + 1;
            }else{
                cnt[top] = 1;
            }

            // if cnt == k remove k elements
            if(cnt[top] == k){
                st.delete(st.length()-k, st.length());
            }
        }
        return st.toString();
    }
}