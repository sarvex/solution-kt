import kotlin.math.max

class Solution {
  fun takeCharacters(s: String, k: Int): Int {
    val cnt = IntArray(3)
    val n = s.length
    for (i in 0 until n) {
      ++cnt[s[i].code - 'a'.code]
    }
    if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
      return -1
    }
    var ans = 0
    var j = 0
    for (i in 0 until n) {
      val c = s[i].code - 'a'.code
      --cnt[c]
      while (cnt[c] < k) {
        ++cnt[s[j++].code - 'a'.code]
      }
      ans = max(ans.toDouble(), (i - j + 1).toDouble()).toInt()
    }
    return n - ans
  }
}
