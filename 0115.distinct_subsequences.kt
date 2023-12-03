internal class Solution {
  fun numDistinct(s: String, t: String): Int {
    val n = t.length
    val f = IntArray(n + 1)
    f[0] = 1
    for (a in s.toCharArray()) {
      for (j in n downTo 1) {
        val b = t[j - 1]
        if (a == b) {
          f[j] += f[j - 1]
        }
      }
    }
    return f[n]
  }
}
