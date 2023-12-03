class Solution {
  fun countSubarrays(nums: IntArray, k: Int): Int {
    val n = nums.size
    var i = 0
    while (nums[i] != k) {
      ++i
    }
    val cnt = IntArray(n shl 1 or 1)
    var ans = 1
    var x = 0
    for (j in i + 1 until n) {
      x += if (nums[j] > k) 1 else -1
      if (x >= 0 && x <= 1) {
        ++ans
      }
      ++cnt[x + n]
    }
    x = 0
    for (j in i - 1 downTo 0) {
      x += if (nums[j] > k) 1 else -1
      if (x >= 0 && x <= 1) {
        ++ans
      }
      ans += cnt[-x + n] + cnt[-x + 1 + n]
    }
    return ans
  }
}
