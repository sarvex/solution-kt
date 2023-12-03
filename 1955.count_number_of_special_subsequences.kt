class Solution {
  fun countSpecialSubsequences(nums: IntArray): Int {
    val mod = 1e9.toInt() + 7
    val n = nums.size
    val f = IntArray(3)
    f[0] = if (nums[0] == 0) 1 else 0
    for (i in 1 until n) {
      if (nums[i] == 0) {
        f[0] = (2 * f[0] % mod + 1) % mod
      } else if (nums[i] == 1) {
        f[1] = (f[0] + 2 * f[1] % mod) % mod
      } else {
        f[2] = (f[1] + 2 * f[2] % mod) % mod
      }
    }
    return f[2]
  }
}
