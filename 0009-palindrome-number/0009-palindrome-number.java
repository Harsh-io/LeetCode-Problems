import java.util.*;
class Solution {
    public static boolean isPalindrome(int x) {

		int rev = 0;
		int temp = x;
		while (temp>0)
		{
		    int r = temp % 10;
		    rev = rev * 10 + r;
		    temp = temp/10;
		}
		if(rev == x){
		    return true;
		}
		else{
		    return false;
		}
	}
    public static void main(String args[]){
        int n = 121;
        boolean result = isPalindrome(n);
    }
}
