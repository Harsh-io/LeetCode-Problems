class Solution {
    public int compress(char[] chars) {

        int i = 0;
        int idx = 0;

        while(i < chars.length){

            char ch = chars[i];   // store original char
            int j = i;
            int cnt = 0;

            while(j < chars.length && chars[j] == ch){
                cnt++;
                j++;
            }

            chars[idx++] = ch;

            if(cnt > 1){
                String str = Integer.toString(cnt);

                for(char c : str.toCharArray()){
                    chars[idx++] = c;
                }
            }

            i = j;
        }

        return idx;
    }
}