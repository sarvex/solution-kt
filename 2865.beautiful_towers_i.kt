import kotlin.math.max

class Solution {
  fun maximumSumOfHeights(maxHeights: List<Int>): Long {
    var ans: Long = 0
    val n: Int = maxHeights.size()
    for (i in 0 until n) {
      var y = maxHeights[i]
      var t = y.toLong()
      for (j in i - 1 downTo 0) {
        y = Math.min(y, maxHeights[j])
        t += y.toLong()
      }
      y = maxHeights[i]
      for (j in i + 1 until n) {
        y = Math.min(y, maxHeights[j])
        t += y.toLong()
      }
      ans = max(ans.toDouble(), t.toDouble()).toLong()
    }
    return ans
  }
}
