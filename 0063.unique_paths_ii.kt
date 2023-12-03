internal class Solution {
  fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    val dp = Array(m) { IntArray(n) }
    run {
      var i = 0
      while (i < m && obstacleGrid[i][0] == 0) {
        dp[i][0] = 1
        ++i
      }
    }
    var j = 0
    while (j < n && obstacleGrid[0][j] == 0) {
      dp[0][j] = 1
      ++j
    }
    for (i in 1 until m) {
      for (j in 1 until n) {
        if (obstacleGrid[i][j] == 0) {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
      }
    }
    return dp[m - 1][n - 1]
  }
}
