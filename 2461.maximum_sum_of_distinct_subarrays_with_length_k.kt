import kotlin.math.max

class Solution {
  fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    val n = nums.size
    val cnt: Map<Int, Int> = HashMap(k)
    var s: Long = 0
    for (i in 0 until k) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      s += nums[i].toLong()
    }
    var ans = if (cnt.size() === k) s else 0
    for (i in k until n) {
      cnt.merge(nums[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      s += nums[i].toLong()
      if (cnt.merge(nums[i - k], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        cnt.remove(nums[i - k])
      }
      s -= nums[i - k].toLong()
      if (cnt.size() === k) {
        ans = max(ans.toDouble(), s.toDouble()).toLong()
      }
    }
    return ans
  }
}
