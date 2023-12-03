import kotlin.math.max

class Solution {
  private var m = 0
  private var n = 0
  private var p = 0
  private val h = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, -60, -10), intArrayOf(0, -10, 40))
  private var memo: Array<Array<Array<Array<Int>>>>
  fun getMaxGridHappiness(m: Int, n: Int, introvertsCount: Int, extrovertsCount: Int): Int {
    this.m = m
    this.n = n
    p = 3.pow((n - 1).toDouble()) as Int
    memo =
      Array(m * n) { Array<Array<Array<Int?>>>(p * 3) { Array(introvertsCount + 1) { arrayOfNulls(extrovertsCount + 1) } } }
    return dfs(0, 0, introvertsCount, extrovertsCount)
  }

  private fun dfs(pos: Int, pre: Int, ic: Int, ec: Int): Int {
    if (pos == m * n || ic == 0 && ec == 0) {
      return 0
    }
    if (memo[pos][pre][ic][ec] != null) {
      return memo[pos][pre][ic][ec]
    }
    var ans = 0
    val up = pre / p
    val left = if (pos % n == 0) 0 else pre % 3
    for (i in 0..2) {
      if (i == 1 && ic == 0 || i == 2 && ec == 0) {
        continue
      }
      val cur = pre % p * 3 + i
      val a = h[up][i] + h[left][i]
      val b = dfs(pos + 1, cur, ic - if (i == 1) 1 else 0, ec - if (i == 2) 1 else 0)
      val c = if (i == 1) 120 else if (i == 2) 40 else 0
      ans = max(ans.toDouble(), (a + b + c).toDouble()).toInt()
    }
    return ans.also { memo[pos][pre][ic][ec] = it }
  }
}
