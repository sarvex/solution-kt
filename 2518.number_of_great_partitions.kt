class Solution {
  fun countPartitions(nums: IntArray, k: Int): Int {
    var s: Long = 0
    for (v in nums) {
      s += v.toLong()
    }
    if (s < k * 2) {
      return 0
    }
    val n = nums.size
    val f = Array(n + 1) { LongArray(k) }
    f[0][0] = 1
    var ans: Long = 1
    for (i in 1..n) {
      val v = nums[i - 1]
      ans = ans * 2 % Solution.Companion.MOD
      for (j in 0 until k) {
        f[i][j] = f[i - 1][j]
        if (j >= v) {
          f[i][j] = (f[i][j] + f[i - 1][j - v]) % Solution.Companion.MOD
        }
      }
    }
    for (j in 0 until k) {
      ans = (ans - f[n][j] * 2 % Solution.Companion.MOD + Solution.Companion.MOD) % Solution.Companion.MOD
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
