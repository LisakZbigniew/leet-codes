class Solution {

    int mod = 1000000007;

    public int numWays(int steps, int arrLen) {
        int[][] stepsArr = new int[2][arrLen+2];
        stepsArr[0][1] = 1;
        for(int i = 1; i <= steps; i++){
            int limit = Math.min(i+1,arrLen);
            for(int j = 1 ; j<=limit ; j++){
                stepsArr[i%2][j] = ((stepsArr[(i+1)%2][j] + stepsArr[(i+1)%2][j+1])%mod + stepsArr[(i+1)%2][j-1])%mod;
            }
        }
        return stepsArr[steps%2][1];
    }
}