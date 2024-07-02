class Solution {
    fun decompressRLElist(nums: IntArray): IntArray {
        var len = 0
        for(i in nums.indices step 2){
            len += nums[i]
        }
        val results = IntArray(len)
        var j = 0
        for(i in nums.indices step 2){
            repeat(nums[i]){
                results[j++] = nums[i+1]
            }
        }
        return results
    }
}