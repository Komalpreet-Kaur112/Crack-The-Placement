package Arrays;

// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

 

// Example 1:

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:

// Input: nums = [0]
// Output: [0]

class Solution {
    public void moveZeroes(int[] nums) {
        // int zero = 0;
        int i = 0;
        int right = 0;
        
        while(right < nums.length){
            while(right < nums.length && nums[right] == 0 ){
                // zero++;
                right++;
            }

            if(right < nums.length){
                nums[i] = nums[right];
                i++;
                right++;
            }
        }
        while(i < nums.length){
            nums[i] = 0;
            i++;
        }
    }
}

