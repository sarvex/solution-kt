import kotlin.math.min

class Solution {
  fun minimumString(a: String, b: String, c: String): String {
    val s = arrayOf(a, b, c)
    val perm = arrayOf(
      intArrayOf(0, 1, 2),
      intArrayOf(0, 2, 1),
      intArrayOf(1, 0, 2),
      intArrayOf(1, 2, 0),
      intArrayOf(2, 1, 0),
      intArrayOf(2, 0, 1)
    )
    var ans = ""
    for (p in perm) {
      val i = p[0]
      val j = p[1]
      val k = p[2]
      val t = f(f(s[i], s[j]), s[k])
      if ("" == ans || t.length < ans.length || t.length == ans.length && t.compareTo(ans) < 0) {
        ans = t
      }
    }
    return ans
  }

  private fun f(s: String, t: String): String {
    if (s.contains(t)) {
      return s
    }
    if (t.contains(s)) {
      return t
    }
    val m = s.length
    val n = t.length
    for (i in min(m.toDouble(), n.toDouble()) downTo 1) {
      if (s.substring(m - i) == t.substring(0, i)) {
        return s + t.substring(i)
      }
    }
    return s + t
  }
}
