class Solution {
  private var nums: IntArray
  fun minimizeArrayValue(nums: IntArray): Int {
    this.nums = nums
    var left = 0
    var right = max(nums)
    while (left < right) {
      val mid = left + right shr 1
      if (check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun check(mx: Int): Boolean {
    var d: Long = 0
    for (i in nums.size - 1 downTo 1) {
      d = kotlin.math.max(0.0, (d + nums[i] - mx).toDouble()).toLong()
    }
    return nums[0] + d <= mx
  }

  private fun max(nums: IntArray): Int {
    var v = nums[0]
    for (x in nums) {
      v = kotlin.math.max(v.toDouble(), x.toDouble()).toInt()
    }
    return v
  }
}
