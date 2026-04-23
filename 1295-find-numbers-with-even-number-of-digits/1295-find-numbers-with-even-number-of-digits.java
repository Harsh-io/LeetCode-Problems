class Solution {
    public int findNumbers(int[] nums) {

        int even = 0;
        for(int num : nums){
            int count = 0;
            int n = num;

            while (n > 0){
                n = n/10;
                count++;
            }
            if (count%2 ==0){
                even++;
            }
        }
         return even;
  }
}


// ERROR : 
/*
Missing return
Logic Error	% 10 only --> use /
Declare count = 0; inside the loo
r = i % 10;	Variable r is never used, and % 10 doesn’t count digits	Use / 10 in a loop
for i in nums	Invalid Java syntax (this is Python style)	Use for (int i : nums)
        // result = findNumbers(count, nums);


MY CODE 
    //     for i in nums{
    //         if (i>0){                      // used in
    //             r = i % 10;                // used % instead of /
    //             count += 1;
    //         }
    //         if (count%2 == 0){
    //                 even += 1;
    //             }
    //     }
        
    // }
/*
/*
psuedo code 
1) traverse the array
    - check each element
    - divide by 10 and get reminder 
    - store total  no of digits in i 
    if i%2 === 0 
    even +=1
2) repeat until all the ele of array are covered 
*/