class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();

        for(int i=n-1; i>=0; i--){
            char ch = num.charAt(i);

            if((ch -'0') % 2 != 0){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}




//Not Optimal 
        // int n = Integer.parseInt(num);
        // int max = Integer.MIN_VALUE;
        // String s = "";

        // if(n % 2 != 0){
        //     return s = Integer.toString(n);
        // }
        // while(n>0){
        //     int r = n%10;
        //     if(r%2 != 0){max = Math.max(max, n);}
        //     n/= 10;
        // }
        // if(max > 0){s = Integer.toString(max);}
        // return s;