import kotlin.math.min

class Solution {
  private var f: Array<Int>
  private var n = 0
  private var s: String? = null
  private var k = 0
  private val inf = 1 shl 30
  fun minimumPartition(s: String, k: Int): Int {
    n = s.length
    f = arrayOfNulls(n)
    this.s = s
    this.k = k
    val ans = dfs(0)
    return if (ans < inf) ans else -1
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] != null) {
      return f[i]
    }
    var res = inf
    var v: Long = 0
    for (j in i until n) {
      v = v * 10 + (s!![j].code - '0'.code)
      if (v > k) {
        break
      }
      res = min(res.toDouble(), dfs(j + 1).toDouble()).toInt()
    }
    return (res + 1).also { f[i] = it }
  }
}
