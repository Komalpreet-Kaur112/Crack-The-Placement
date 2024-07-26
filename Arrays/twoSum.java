package Arrays;

// Two sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = result[1] = -1;
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int curr = nums[i];
            int needed = target - curr;
            if(map.containsKey(needed)){
                result[0] = i;
                result[1] = map.get(needed);
            }
            map.put(nums[i] , i);
        }
        return result;
    }
}
