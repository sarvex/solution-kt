import kotlin.math.max

internal class Solution {
  fun minSwaps(nums: IntArray): Int {
    var cnt = 0
    for (v in nums) {
      cnt += v
    }
    val n = nums.size
    val s = IntArray((n shl 1) + 1)
    for (i in 0 until (n shl 1)) {
      s[i + 1] = s[i] + nums[i % n]
    }
    var mx = 0
    for (i in 0 until (n shl 1)) {
      val j = i + cnt - 1
      if (j < n shl 1) {
        mx = max(mx.toDouble(), (s[j + 1] - s[i]).toDouble()).toInt()
      }
    }
    return cnt - mx
  }
}
