class Solution {
    public int rotatedDigits(int n) {
        int cnt = 0;
        for(int i=1; i<=n; i++){
            boolean changed = false;
            boolean isvalid = true;
            int temp = i;
            while(temp>0){
                int r = temp%10;
                temp = temp/10;
                if(r ==3 || r == 4 || r==7){
                    isvalid = false;
                    break;
                }else if(r ==2 || r == 5 || r==6 || r==9 ){
                    changed = true;
                }
            }
            if(isvalid == true && changed == true){cnt++;}
        }
        return cnt;
    }
}



///condition 1 : if numer betwen 1-10
// if > 10 - n
// if number contain 3 , 4, 7  dont count 
// if after rotation number > n ..dont count else 
// count






