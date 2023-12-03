internal class Solution {
  private val d = intArrayOf(0, 1, -1, -1, -1, -1, 9, -1, 8, 6)
  private var s: String? = null
  fun confusingNumberII(n: Int): Int {
    s = n.toString()
    return dfs(0, 1, 0)
  }

  private fun dfs(pos: Int, limit: Int, x: Int): Int {
    if (pos >= s!!.length) {
      return if (check(x)) 1 else 0
    }
    val up = if (limit == 1) s!![pos].code - '0'.code else 9
    var ans = 0
    for (i in 0..up) {
      if (d[i] != -1) {
        ans += dfs(pos + 1, if (limit == 1 && i == up) 1 else 0, x * 10 + i)
      }
    }
    return ans
  }

  private fun check(x: Int): Boolean {
    var y = 0
    var t = x
    while (t > 0) {
      val v = t % 10
      y = y * 10 + d[v]
      t /= 10
    }
    return x != y
  }
}
