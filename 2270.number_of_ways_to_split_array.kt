class Solution {
  fun waysToSplitArray(nums: IntArray): Int {
    var s: Long = 0
    for (v in nums) {
      s += v.toLong()
    }
    var ans = 0
    var t: Long = 0
    for (i in 0 until nums.size - 1) {
      t += nums[i].toLong()
      if (t >= s - t) {
        ++ans
      }
    }
    return ans
  }
}
