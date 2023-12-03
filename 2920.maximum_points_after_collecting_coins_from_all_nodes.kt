import kotlin.math.max

class Solution {
  private var k = 0
  private var coins: IntArray
  private var f: Array<Array<Int>>
  private var g: Array<List<Int>?>
  fun maximumPoints(edges: Array<IntArray>, coins: IntArray, k: Int): Int {
    this.k = k
    this.coins = coins
    val n = coins.size
    f = Array(n) { arrayOfNulls(15) }
    g = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    return dfs(0, -1, 0)
  }

  private fun dfs(i: Int, fa: Int, j: Int): Int {
    if (f[i][j] != null) {
      return f[i][j]
    }
    var a = (coins[i] shr j) - k
    var b = coins[i] shr j + 1
    for (c in g[i]!!) {
      if (c != fa) {
        a += dfs(c, i, j)
        if (j < 14) {
          b += dfs(c, i, j + 1)
        }
      }
    }
    return max(a.toDouble(), b.toDouble()).also { f[i][j] = it.toInt() }.toInt().toInt()
  }
}
