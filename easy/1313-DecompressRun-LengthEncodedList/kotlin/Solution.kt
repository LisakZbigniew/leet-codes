class Solution {
    fun Int.repeat(times: Int): IntArray{
        val result: IntArray = IntArray(times)
        for(i in 0..<times){
            result[i] = this
        }
        return result
    }

    fun IntArray.addAll(source: IntArray):IntArray{
        val resultingArray = IntArray(source.size + this.size)
        for(i in 0..this.lastIndex){
            resultingArray[i] = this[i]
        } 
        for(i in 0..source.lastIndex){
            resultingArray[this.size + i] = source[i]
        }
        return resultingArray
    }

    fun decompressRLElist(nums: IntArray): IntArray {
        var decompressed: IntArray = IntArray(0)
        for(i in 0..(nums.size/2-1)){
            decompressed = decompressed.addAll(nums[2*i+1].repeat(nums[2*i]))
        }
        return decompressed
    }
}

