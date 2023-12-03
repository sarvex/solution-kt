import kotlin.math.min

class Solution {
  private var f: Array<Int>
  private var s: String? = null
  private val ss: Set<Long> = HashSet()
  private var n = 0
  fun minimumBeautifulSubstrings(s: String): Int {
    n = s.length
    this.s = s
    f = arrayOfNulls(n)
    var x: Long = 1
    for (i in 0..n) {
      ss.add(x)
      x *= 5
    }
    val ans = dfs(0)
    return if (ans > n) -1 else ans
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (s!![i] == '0') {
      return n + 1
    }
    if (f[i] != null) {
      return f[i]
    }
    var x: Long = 0
    var ans = n + 1
    for (j in i until n) {
      x = x shl 1 or (s!![j].code - '0'.code).toLong()
      if (ss.contains(x)) {
        ans = min(ans.toDouble(), (1 + dfs(j + 1)).toDouble()).toInt()
      }
    }
    return ans.also { f[i] = it }
  }
}
