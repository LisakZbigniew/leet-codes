class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int groupIndex = 0;
        int indexInGroup = 0;
        int candidateRestartIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(candidateRestartIndex == -1 && indexInGroup != 0 && nums[i] == groups[groupIndex][0]){
                candidateRestartIndex = i;
            }
            if(nums[i] == groups[groupIndex][indexInGroup]){
                indexInGroup++;
            }else{
                indexInGroup = 0;
                if(candidateRestartIndex != -1) i = candidateRestartIndex -1;
                candidateRestartIndex = -1; 
            }
            if(indexInGroup == groups[groupIndex].length){
                indexInGroup = 0;
                groupIndex++;
            }
            if(groupIndex == groups.length){
                return true;
            }
        }
        return false;
        
    }
}