class Solution {
    public int largestInteger(int[] arr, int k) {

        int max = -1;
        int[] freq = new int[51];
        int j = 1;

        if( k == 1){
            
            for(int num : arr){
                freq[num]++;
            }

            for(int x=0; x <= 50; x++){
                if(freq[x] == 1) max = Math.max(max,x);
            }

            return max;
        }

        else if(k == arr.length){
            for(int num : arr){
                max = Math.max(max,num);
            }

            return max;
        }

        else {
            for(int i=0; i<arr.length; i++){

                freq[arr[i]]++;

                if(i-j+1 == k){
                    freq[arr[j]]++;
                    j++;
                }
            }

            //for(int num : freq) System.out.print(num);

            while(j < arr.length-1) freq[arr[j++]]++;

            for(int x=0; x <= 50; x++){
                if(freq[x] == 1) max = Math.max(max,x);
            }
        }
        return max;

    }
}