class Solution {
    public int passThePillow(int n, int time) {
        int afterPasses = time % (2*n-2);
        return afterPasses <= n-1 ? afterPasses + 1 : 2*n - afterPasses - 1; 
    }
}