class Solution {
    public boolean isPowerOfThree(int n) {
        int num = n;
        if(n <= 0){return false;}
        else if(n == 1){return true;}
        else if(n%3 == 0){
            while(n%3 == 0){n = n/3;}
            if(n==1){return true;}
            else{return false;}
        }
        else{return false;}
    }
}


// 3 , 9, 27, 81, 243....

// 1, 3, 9, 27

//45, 15, 135- > 15,  5, 45


//sum of all ele % 3 == 0 then 