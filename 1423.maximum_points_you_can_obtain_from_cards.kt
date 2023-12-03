import kotlin.math.min

class Solution {
  fun maxScore(cardPoints: IntArray, k: Int): Int {
    val n = cardPoints.size
    val s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + cardPoints[i]
    }
    var mi = Int.MAX_VALUE
    for (i in 0 until n) {
      val j = i + (n - k) - 1
      if (j < n) {
        mi = min(mi.toDouble(), (s[j + 1] - s[i]).toDouble()).toInt()
      }
    }
    return s[n] - mi
  }
}
