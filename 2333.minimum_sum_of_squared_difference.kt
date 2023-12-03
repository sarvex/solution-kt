import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
    val n = nums1.size
    val d = IntArray(n)
    var s: Long = 0
    var mx = 0
    var k = k1 + k2
    for (i in 0 until n) {
      d[i] = abs((nums1[i] - nums2[i]).toDouble()).toInt()
      s += d[i].toLong()
      mx = max(mx.toDouble(), d[i].toDouble()).toInt()
    }
    if (s <= k) {
      return 0
    }
    var left = 0
    var right = mx
    while (left < right) {
      val mid = left + right shr 1
      var t: Long = 0
      for (v in d) {
        (t += max((v - mid).toDouble(), 0.0)).toLong()
      }
      if (t <= k) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    for (i in 0 until n) {
      (k -= max(0.0, (d[i] - left).toDouble())).toInt()
      d[i] = min(d[i].toDouble(), left.toDouble()).toInt()
    }
    var i = 0
    while (i < n && k > 0) {
      if (d[i] == left) {
        --k
        --d[i]
      }
      ++i
    }
    var ans: Long = 0
    for (v in d) {
      ans += v.toLong() * v
    }
    return ans
  }
}
