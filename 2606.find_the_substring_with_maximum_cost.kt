import kotlin.math.max

class Solution {
  fun maximumCostSubstring(s: String, chars: String, vals: IntArray): Int {
    val d = IntArray(26)
    for (i in d.indices) {
      d[i] = i + 1
    }
    val m = chars.length
    for (i in 0 until m) {
      d[chars[i].code - 'a'.code] = vals[i]
    }
    var ans = 0
    var f = 0
    val n = s.length
    for (i in 0 until n) {
      val v = d[s[i].code - 'a'.code]
      f = (max(f.toDouble(), 0.0) + v).toInt()
      ans = max(ans.toDouble(), f.toDouble()).toInt()
    }
    return ans
  }
}
