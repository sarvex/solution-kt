import kotlin.math.max

class Solution {
  private var nums: IntArray
  private var x = 0
  private var y = 0
  fun minOperations(nums: IntArray, x: Int, y: Int): Int {
    this.nums = nums
    this.x = x
    this.y = y
    var l = 0
    var r = 0
    for (v in nums) {
      r = max(r.toDouble(), v.toDouble()).toInt()
    }
    while (l < r) {
      val mid = l + r ushr 1
      if (check(mid)) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }

  private fun check(t: Int): Boolean {
    var cnt: Long = 0
    for (v in nums) {
      if (v > t.toLong() * y) {
        cnt += (v - t.toLong() * y + x - y - 1) / (x - y)
      }
    }
    return cnt <= t
  }
}
