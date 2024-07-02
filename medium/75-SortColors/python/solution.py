class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        
        #colors = {0:0,1:0,2:0}
        
        #for x in nums:
        #    colors[x] += 1
        
        #print(nums)
        #nums = [0] * colors[0] + [1]*colors[1] + [2] * colors[2]
        #print(nums)
        
        for i in range(len(nums)):
            for j in range(0,len(nums)-1-i):
                if(nums[j]>nums[j+1]):
                    nums[j+1] += nums[j]
                    nums[j] = nums[j+1] - nums[j]
                    nums[j+1] = nums[j+1]- nums[j]