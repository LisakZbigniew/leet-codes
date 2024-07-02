class Solution {
    public int minOperations(int[] nums) {
        int operationsCount = 0;
        int lastNum = nums[0];
        for(int i = 1; i < nums.length; i++){
            int diff = (lastNum + 1) - nums[i]; 
            operationsCount += diff > 0 ? diff : 0;
            lastNum = nums[i] + (diff > 0 ? diff : 0);

        }
        return operationsCount;
    }
}