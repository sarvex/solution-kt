class Solution {
  fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
    val left = f(nums, k)
    val right = f(nums, k - 1)
    var ans = 0
    for (i in nums.indices) {
      ans += right[i] - left[i]
    }
    return ans
  }

  private fun f(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    val cnt = IntArray(n + 1)
    val pos = IntArray(n)
    var s = 0
    var i = 0
    var j = 0
    while (i < n) {
      if (++cnt[nums[i]] == 1) {
        ++s
      }
      while (s > k) {
        if (--cnt[nums[j]] == 0) {
          --s
        }
        ++j
      }
      pos[i] = j
      ++i
    }
    return pos
  }
}
