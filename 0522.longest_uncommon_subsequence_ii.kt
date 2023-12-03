import kotlin.math.max

internal class Solution {
  fun findLUSlength(strs: Array<String>): Int {
    var ans = -1
    var i = 0
    var j = 0
    val n = strs.size
    while (i < n) {
      j = 0
      while (j < n) {
        if (i == j) {
          ++j
          continue
        }
        if (check(strs[j], strs[i])) {
          break
        }
        ++j
      }
      if (j == n) {
        ans = max(ans.toDouble(), strs[i].length.toDouble()).toInt()
      }
      ++i
    }
    return ans
  }

  private fun check(a: String, b: String): Boolean {
    var j = 0
    var i = 0
    while (i < a.length && j < b.length) {
      if (a[i] == b[j]) {
        ++j
      }
      ++i
    }
    return j == b.length
  }
}
