import kotlin.math.max

class Solution {
  fun longestValidSubstring(word: String, forbidden: List<String?>?): Int {
    val s = HashSet(forbidden)
    var ans = 0
    val n = word.length
    var i = 0
    var j = 0
    while (j < n) {
      for (k in j downTo (max((j - 10).toDouble(), (i - 1).toDouble()) + 1).toInt()) {
        if (s.contains(word.substring(k, j + 1))) {
          i = k + 1
          break
        }
      }
      ans = max(ans.toDouble(), (j - i + 1).toDouble()).toInt()
      ++j
    }
    return ans
  }
}
