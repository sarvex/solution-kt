import kotlin.math.abs

class Solution {
  fun minSteps(s: String, t: String): Int {
    val cnt = IntArray(26)
    for (c in s.toCharArray()) {
      ++cnt[c.code - 'a'.code]
    }
    for (c in t.toCharArray()) {
      --cnt[c.code - 'a'.code]
    }
    var ans = 0
    for (v in cnt) {
      (ans += abs(v.toDouble())).toInt()
    }
    return ans
  }
}
