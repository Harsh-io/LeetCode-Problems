class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=left; i<=right; i++){

            if(i > 9){
                if(i % 10 == 0) continue;
                int num = i;
                boolean f = false;
                
                while(num >= 1){
                    int r = num % 10;
                    num = num / 10;
                    if(r == 0) {
                        f = true;
                        continue;
                    }
                    if(i % r != 0){
                        f = true;
                        break;
                    }
                }
                if(f == false){
                    arr.add(i);}
            }else{
                arr.add(i);
            }

        }
        return arr;
    }
}