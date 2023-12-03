import kotlin.math.max

class Solution {
  private var f: Array<Array<IntArray>>
  private var price: IntArray
  private var tastiness: IntArray
  private var n = 0
  fun maxTastiness(price: IntArray, tastiness: IntArray, maxAmount: Int, maxCoupons: Int): Int {
    n = price.size
    this.price = price
    this.tastiness = tastiness
    f = Array(n) { Array(maxAmount + 1) { IntArray(maxCoupons + 1) } }
    return dfs(0, maxAmount, maxCoupons)
  }

  private fun dfs(i: Int, j: Int, k: Int): Int {
    if (i == n) {
      return 0
    }
    if (f[i][j][k] != 0) {
      return f[i][j][k]
    }
    var ans = dfs(i + 1, j, k)
    if (j >= price[i]) {
      ans = max(ans.toDouble(), (dfs(i + 1, j - price[i], k) + tastiness[i]).toDouble()).toInt()
    }
    if (j >= price[i] / 2 && k > 0) {
      ans = max(ans.toDouble(), (dfs(i + 1, j - price[i] / 2, k - 1) + tastiness[i]).toDouble())
        .toInt()
    }
    f[i][j][k] = ans
    return ans
  }
}
