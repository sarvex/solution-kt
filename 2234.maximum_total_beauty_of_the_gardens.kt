import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maximumBeauty(flowers: IntArray, newFlowers: Long, target: Int, full: Int, partial: Int): Long {
    var newFlowers = newFlowers
    Arrays.sort(flowers)
    val n = flowers.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + flowers[i]
    }
    var ans: Long = 0
    var x = 0
    for (v in flowers) {
      if (v >= target) {
        ++x
      }
    }
    while (x <= n) {
      newFlowers -= (if (x == 0) 0 else max((target - flowers[n - x]).toDouble(), 0.0)).toLong()
      if (newFlowers < 0) {
        break
      }
      var l = 0
      var r = n - x - 1
      while (l < r) {
        val mid = l + r + 1 shr 1
        if (flowers[mid].toLong() * (mid + 1) - s[mid + 1] <= newFlowers) {
          l = mid
        } else {
          r = mid - 1
        }
      }
      var y: Long = 0
      if (r != -1) {
        val cost = flowers[l].toLong() * (l + 1) - s[l + 1]
        y = min((flowers[l] + (newFlowers - cost) / (l + 1)).toDouble(), (target - 1).toDouble())
          .toLong()
      }
      ans = max(ans.toDouble(), (x.toLong() * full + y * partial).toDouble()).toLong()
      ++x
    }
    return ans
  }
}
