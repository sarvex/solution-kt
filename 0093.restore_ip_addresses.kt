import kotlin.math.min

internal class Solution {
  private var n = 0
  private var s: String? = null
  private val ans: List<String> = ArrayList()
  private val t: List<String> = ArrayList()
  fun restoreIpAddresses(s: String): List<String> {
    n = s.length
    this.s = s
    dfs(0)
    return ans
  }

  private fun dfs(i: Int) {
    if (i >= n && t.size() === 4) {
      ans.add(java.lang.String.join(".", t))
      return
    }
    if (i >= n || t.size() >= 4) {
      return
    }
    var x = 0
    for (j in i until min((i + 3).toDouble(), n.toDouble()).toInt()) {
      x = x * 10 + s!![j].code - '0'.code
      if (x > 255 || s!![i] == '0' && i != j) {
        break
      }
      t.add(s!!.substring(i, j + 1))
      dfs(j + 1)
      t.remove(t.size() - 1)
    }
  }
}
