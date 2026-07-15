class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            if(set.contains(n)) return false;
            set.add(n);
            n = sumSquare(n);
        }
        return true;
    }

    public int sumSquare(int n) {
        int sum = 0;
        
        while(n > 0) {
            int r = n % 10;
            sum += r * r;
            n = n / 10;
        }
        return sum;
    }
}


// import java.util.*;
// class Solution {
//     HashSet<Integer> set = new HashSet<>();
//     public boolean isHappy(int n) {
//         if(n == 1) return true;
//         if(set.contains(n)) return false;
//         set.add(n);
//         return solve(n);
//     }

//     public boolean solve(int n) {
//         int sum = 0;

//         while(n > 0) {
//             int r = n % 10;
//             sum += r * r;
//             n = n / 10;
//         }
//         return isHappy(sum);
//     }
// }