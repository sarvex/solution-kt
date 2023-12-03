internal class Solution {
  fun findContentChildren(g: IntArray, s: IntArray): Int {
    Arrays.sort(g)
    Arrays.sort(s)
    val m = g.size
    val n = s.size
    var i = 0
    var j = 0
    while (i < m) {
      while (j < n && s[j] < g[i]) {
        ++j
      }
      if (j++ >= n) {
        return i
      }
      ++i
    }
    return m
  }
}
