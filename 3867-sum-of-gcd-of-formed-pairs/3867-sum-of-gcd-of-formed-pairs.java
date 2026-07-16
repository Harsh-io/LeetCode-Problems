class Solution {
    public long gcdSum(int[] arr) {
        
        long[] prefixGCD = new long[arr.length];
        int max = 0;

        for(int i=0; i<arr.length; i++){
            max = Math.max(arr[i], max);
            prefixGCD[i] = gcd(arr[i], max);
        }

        Arrays.sort(prefixGCD);

        int l=0;
        int r=arr.length-1;
        long sum = 0;

        // for(int j=0; j<arr.length; j++){
        //     System.out.print(prefixGCD[j]);
        // }
        while(l < r){
            sum += gcd(prefixGCD[l], prefixGCD[r]);
            l++;
            r--;
        }
        return sum;
    }

    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}