import kotlin.math.max

internal class Solution {
  fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
    val mod = 1e9.toInt() + 7
    val m = group.size
    val f = Array(m + 1) { Array(n + 1) { IntArray(minProfit + 1) } }
    for (j in 0..n) {
      f[0][j][0] = 1
    }
    for (i in 1..m) {
      for (j in 0..n) {
        for (k in 0..minProfit) {
          f[i][j][k] = f[i - 1][j][k]
          if (j >= group[i - 1]) {
            f[i][j][k] = ((f[i][j][k]
                + f[i - 1][j - group[i - 1]][max(0.0, (k - profit[i - 1]).toDouble()).toInt()])
                % mod)
          }
        }
      }
    }
    return f[m][n][minProfit]
  }
}
