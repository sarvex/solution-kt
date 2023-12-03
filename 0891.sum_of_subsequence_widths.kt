internal class Solution {
  fun sumSubseqWidths(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans: Long = 0
    var p: Long = 1
    val n = nums.size
    for (i in 0 until n) {
      ans = (ans + (nums[i] - nums[n - i - 1]) * p + Solution.Companion.MOD) % Solution.Companion.MOD
      p = (p shl 1) % Solution.Companion.MOD
    }
    return ans.toInt()
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
