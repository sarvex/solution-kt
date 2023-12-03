import kotlin.math.max

internal class Solution {
  private var s: String? = null
  private var k = 0
  fun longestSubstring(s: String, k: Int): Int {
    this.s = s
    this.k = k
    return dfs(0, s.length - 1)
  }

  private fun dfs(l: Int, r: Int): Int {
    val cnt = IntArray(26)
    for (i in l..r) {
      ++cnt[s!![i].code - 'a'.code]
    }
    var split = 0.toChar()
    for (i in 0..25) {
      if (cnt[i] > 0 && cnt[i] < k) {
        split = (i + 'a'.code).toChar()
        break
      }
    }
    if (split.code == 0) {
      return r - l + 1
    }
    var i = l
    var ans = 0
    while (i <= r) {
      while (i <= r && s!![i] == split) {
        ++i
      }
      if (i > r) {
        break
      }
      var j = i
      while (j <= r && s!![j] != split) {
        ++j
      }
      val t = dfs(i, j - 1)
      ans = max(ans.toDouble(), t.toDouble()).toInt()
      i = j
    }
    return ans
  }
}
