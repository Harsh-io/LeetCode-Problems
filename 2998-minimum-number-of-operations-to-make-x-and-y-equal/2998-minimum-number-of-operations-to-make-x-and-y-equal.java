// if x divisible by 5:
//     answer = min(answer, 1 + solve(x/5))

// else:
//     move to nearest multiple of 5
//     then divide

// same for 11
// return answer


class Solution {
    
    HashMap<Integer,Integer> map = new HashMap<>();

    public int minimumOperationsToMakeEqual(int x, int y) {

        if(x < y) return Math.abs(y-x);

        return solve(x, y);
    }

    public int solve(int x , int y){

        if(x <= y) return y-x;

        if(map.containsKey(x)) return map.get(x);

        // use diff + | -
        int ans = x - y;

        // use 5
        int use5 = Integer.MAX_VALUE;

        use5 = Math.min(use5, x % 5 + 1 + solve(x / 5, y));
        use5 = Math.min(use5, 5 - x % 5 + 1 + solve(x / 5 + 1, y));


        // use 11
        int use11 = Integer.MAX_VALUE;

        use11 = Math.min(use11, x % 11 + 1 + solve(x / 11, y));

        use11 = Math.min(use11, 11 - x % 11 + 1 + solve(x / 11 + 1, y));

        ans = Math.min(ans, Math.min(use11, use5));
        map.put(x, ans);

        return ans;
    }
}