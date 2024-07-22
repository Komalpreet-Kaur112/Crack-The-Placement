package Arrays;

// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
// Example 1:

// Input: nums = [1,1,2]
// Output: 2, nums = [1,2,_]

// Example 2:

// Input: nums = [0,0,1,1,1,2,2,3,3,4]
// Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int right = 1;
        while(right<nums.length){
            while(right < nums.length && nums[i] == nums[right]){
                    right++;
            }
            if (right < nums.length) {
            i++;
            nums[i] = nums[right];
            }
        }
        return i+1;
    }
}