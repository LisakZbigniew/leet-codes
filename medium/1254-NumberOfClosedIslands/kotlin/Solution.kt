class Solution {
    fun closedIsland(grid: Array<IntArray>): Int {
        val territorieState = mutableMapOf<Int,Boolean>()
        val width = grid[0].size + 1
        val territories = Array<Array<Int?>>(grid.size+1){_ -> arrayOfNulls<Int>(width)}
        var nextGroup = 0;

        for(i in grid.indices){
            for(j in grid[i].indices){
                if(grid[i][j] == 1) continue

                val leftTerr = territories[i+1][j]
                val upTerr = territories[i][j+1]

                if(leftTerr == null && upTerr == null){
                    val newTerrNo = nextGroup++;
                    territories[i+1][j+1] = newTerrNo
                    territorieState[newTerrNo] = true
                }else if(leftTerr == null || upTerr == null || upTerr == leftTerr){
                    val inheritedTerr = if (leftTerr==null) upTerr else leftTerr
                    territories[i+1][j+1] = inheritedTerr
                }else{
                    for( k in j+1 downTo 0){
                        if(territories[i+1][k] == leftTerr){
                            territories[i+1][k] = upTerr
                        }
                    }

                    if(territorieState[leftTerr] == false){
                        territorieState[upTerr] = false
                    }

                    territorieState.remove(leftTerr)
                    territories[i+1][j+1] = upTerr
                }

                if(i == 0 || i == grid.lastIndex || j == 0 || j == grid[0].lastIndex){
                    territorieState[territories[i+1][j+1]?:-1] = false
                }
            }
        }

        return territorieState.filter{(key,value) -> value}.size

    }
}