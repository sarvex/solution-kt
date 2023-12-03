class Solution {
  fun maxScore(nums: IntArray): Int {
    Arrays.sort(nums)
    val n = nums.size
    var s: Long = 0
    for (i in 0 until n) {
      s += nums[n - i - 1].toLong()
      if (s <= 0) {
        return i
      }
    }
    return n
  }
}
