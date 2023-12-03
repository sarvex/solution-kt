internal class Solution {
  private var vis: Set<String>? = null
  private var d: Map<Char, String>? = null
  private var p: String? = null
  private var s: String? = null
  private var m = 0
  private var n = 0
  fun wordPatternMatch(pattern: String?, s: String): Boolean {
    vis = HashSet()
    d = HashMap()
    p = pattern
    this.s = s
    m = p!!.length
    n = s.length
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Boolean {
    if (i == m && j == n) {
      return true
    }
    if (i == m || j == n || m - i > n - j) {
      return false
    }
    val c = p!![i]
    for (k in j + 1..n) {
      val t = s!!.substring(j, k)
      if ((d!![c] ?: "").equals(t)) {
        if (dfs(i + 1, k)) {
          return true
        }
      }
      if (!d!!.containsKey(c) && !vis!!.contains(t)) {
        d.put(c, t)
        vis.add(t)
        if (dfs(i + 1, k)) {
          return true
        }
        vis.remove(t)
        d.remove(c)
      }
    }
    return false
  }
}
