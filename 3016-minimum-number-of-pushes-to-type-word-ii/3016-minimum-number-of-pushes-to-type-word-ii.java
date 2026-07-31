class Solution {
    public int minimumPushes(String s) {
        Integer [] arr = new Integer[26];
        Arrays.fill(arr, 0);
        int sum = 0;

        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        Arrays.sort(arr, Collections.reverseOrder());
        int push = 1;

        for(int i=0; i<26; i++){

            if(arr[i] == 0) break;

            if(i > 0 && i%8 == 0) push += 1;

            sum += arr[i] * push;
            
        }
        return sum;
    }
}