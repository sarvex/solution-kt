class Solution {
  private val res: List<List<Int>> = ArrayList()
  private val t: List<Int> = ArrayList()
  private var width = 0
  private var bricks: IntArray
  fun buildWall(height: Int, width: Int, bricks: IntArray): Int {
    this.width = width
    this.bricks = bricks
    dfs(0)
    val n: Int = res.size()
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 0 until n) {
      if (check(res[i], res[i])) {
        g[i].add(i)
      }
      for (j in i + 1 until n) {
        if (check(res[i], res[j])) {
          g[i].add(j)
          g[j].add(i)
        }
      }
    }
    val dp = Array(height) { IntArray(n) }
    for (j in 0 until n) {
      dp[0][j] = 1
    }
    for (i in 1 until height) {
      for (j in 0 until n) {
        for (k in g[j]!!) {
          dp[i][j] = (dp[i][j] + dp[i - 1][k]) % Solution.Companion.MOD
        }
      }
    }
    var ans = 0
    for (j in 0 until n) {
      ans = (ans + dp[height - 1][j]) % Solution.Companion.MOD
    }
    return ans
  }

  private fun check(a: List<Int>, b: List<Int>): Boolean {
    var s1 = a[0]
    var s2 = b[0]
    var i = 1
    var j = 1
    while (i < a.size() && j < b.size()) {
      if (s1 == s2) {
        return false
      }
      if (s1 < s2) {
        s1 += a[i++]
      } else {
        s2 += b[j++]
      }
    }
    return true
  }

  private fun dfs(v: Int) {
    if (v > width) {
      return
    }
    if (v == width) {
      res.add(ArrayList(t))
      return
    }
    for (x in bricks) {
      t.add(x)
      dfs(v + x)
      t.remove(t.size() - 1)
    }
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
