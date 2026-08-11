class Solution {
    public String decodeString(String s) {
        
        Stack<String> stringstack = new Stack<>();
        Stack<Integer> numstack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        int num = 0;

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){

                num = num * 10 + (ch - '0');
            }

            else if(ch == '['){
                //save curr number and string
                numstack.push(num);
                stringstack.push(curr.toString());

                //start a new string[]
                num = 0;
                curr.setLength(0);

            }else if(ch == ']'){
                int k = numstack.pop();
                String prev = stringstack.pop();

                StringBuilder temp = new StringBuilder(prev);

                while(k-- > 0){
                    temp.append(curr);
                } 

                curr = temp;

            }else{
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}