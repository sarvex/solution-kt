import kotlin.math.max

class Solution {
  fun printVertically(s: String): List<String> {
    val words = s.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    var n = 0
    for (w in words) {
      n = max(n.toDouble(), w.length.toDouble()).toInt()
    }
    val ans: List<String> = ArrayList()
    for (j in 0 until n) {
      val t = StringBuilder()
      for (w in words) {
        t.append(if (j < w.length) w[j] else ' ')
      }
      while (t.length > 0 && t[t.length - 1] == ' ') {
        t.deleteCharAt(t.length - 1)
      }
      ans.add(t.toString())
    }
    return ans
  }
}
