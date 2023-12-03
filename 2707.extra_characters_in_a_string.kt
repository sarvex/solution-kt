import kotlin.math.min

class Solution {
  fun minExtraChar(s: String, dictionary: Array<String?>): Int {
    val ss: Set<String> = HashSet()
    for (w in dictionary) {
      ss.add(w)
    }
    val n = s.length
    val f = IntArray(n + 1)
    f[0] = 0
    for (i in 1..n) {
      f[i] = f[i - 1] + 1
      for (j in 0 until i) {
        if (ss.contains(s.substring(j, i))) {
          f[i] = min(f[i].toDouble(), f[j].toDouble()).toInt()
        }
      }
    }
    return f[n]
  }
}
