import kotlin.math.min

class Solution {
  fun minimumRemoval(beans: IntArray): Long {
    Arrays.sort(beans)
    var s: Long = 0
    for (v in beans) {
      s += v.toLong()
    }
    var ans = s
    val n = beans.size
    for (i in 0 until n) {
      ans = min(ans.toDouble(), (s - beans[i].toLong() * (n - i)).toDouble()).toLong()
    }
    return ans
  }
}
