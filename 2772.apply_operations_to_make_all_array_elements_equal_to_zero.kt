class Solution {
  fun checkArray(nums: IntArray, k: Int): Boolean {
    val n = nums.size
    val d = IntArray(n + 1)
    var s = 0
    for (i in 0 until n) {
      s += d[i]
      nums[i] += s
      if (nums[i] == 0) {
        continue
      }
      if (nums[i] < 0 || i + k > n) {
        return false
      }
      s -= nums[i]
      d[i + k] += nums[i]
    }
    return true
  }
}
