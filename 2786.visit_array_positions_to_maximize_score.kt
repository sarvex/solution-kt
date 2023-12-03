import kotlin.math.max

class Solution {
  fun maxScore(nums: IntArray, x: Int): Long {
    val f = LongArray(2)
    Arrays.fill(f, -(1L shl 60))
    f[nums[0] and 1] = nums[0].toLong()
    for (i in 1 until nums.size) {
      f[nums[i] and 1] = max((f[nums[i] and 1] + nums[i]).toDouble(), (f[nums[i] and 1 xor 1] + nums[i] - x).toDouble())
        .toLong()
    }
    return max(f[0].toDouble(), f[1].toDouble()).toLong()
  }
}
