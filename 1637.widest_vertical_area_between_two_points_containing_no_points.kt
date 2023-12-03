import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
    val n = points.size
    val nums = IntArray(n)
    for (i in 0 until n) {
      nums[i] = points[i][0]
    }
    val inf = 1 shl 30
    var mi = inf
    var mx = -inf
    for (v in nums) {
      mi = min(mi.toDouble(), v.toDouble()).toInt()
      mx = max(mx.toDouble(), v.toDouble()).toInt()
    }
    val bucketSize = max(1.0, ((mx - mi) / (n - 1)).toDouble()).toInt()
    val bucketCount = (mx - mi) / bucketSize + 1
    val buckets = Array(bucketCount) { IntArray(2) }
    for (bucket in buckets) {
      bucket[0] = inf
      bucket[1] = -inf
    }
    for (v in nums) {
      val i = (v - mi) / bucketSize
      buckets[i][0] = min(buckets[i][0].toDouble(), v.toDouble()).toInt()
      buckets[i][1] = max(buckets[i][1].toDouble(), v.toDouble()).toInt()
    }
    var prev = inf
    var ans = 0
    for (bucket in buckets) {
      if (bucket[0] > bucket[1]) {
        continue
      }
      ans = max(ans.toDouble(), (bucket[0] - prev).toDouble()).toInt()
      prev = bucket[1]
    }
    return ans
  }
}
