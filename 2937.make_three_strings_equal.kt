import kotlin.math.min

class Solution {
  fun findMinimumOperations(s1: String, s2: String, s3: String): Int {
    val s = s1.length + s2.length + s3.length
    val n = min(min(s1.length.toDouble(), s2.length.toDouble()), s3.length.toDouble())
      .toInt()
    for (i in 0 until n) {
      if (!(s1[i] == s2[i] && s2[i] == s3[i])) {
        return if (i == 0) -1 else s - 3 * i
      }
    }
    return s - 3 * n
  }
}
