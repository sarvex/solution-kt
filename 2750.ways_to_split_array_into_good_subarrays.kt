class Solution {
  fun numberOfGoodSubarraySplits(nums: IntArray): Int {
    val mod = 1e9.toInt() + 7
    var ans = 1
    var j = -1
    for (i in nums.indices) {
      if (nums[i] == 0) {
        continue
      }
      if (j > -1) {
        ans = (ans.toLong() * (i - j) % mod).toInt()
      }
      j = i
    }
    return if (j == -1) 0 else ans
  }
}
