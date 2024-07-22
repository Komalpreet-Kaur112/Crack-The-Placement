// Find the Duplicate Number:

// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and uses only constant extra space.

// Example 1:

// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:

// Input: nums = [3,1,3,4,2]
// Output: 3
// Example 3:

// Input: nums = [3,3,3,3,3]
// Output: 3

/* Solution */ 

// Approach 1: Brute Force
// Using for loop inside for loop







// Approach 2: Using hashmap/hashset

class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<len;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }
        return len;
    }
}