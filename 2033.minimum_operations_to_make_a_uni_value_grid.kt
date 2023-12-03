import kotlin.math.abs

internal class Solution {
  fun minOperations(grid: Array<IntArray>, x: Int): Int {
    val m = grid.size
    val n = grid[0].size
    val nums = IntArray(m * n)
    val mod = grid[0][0] % x
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] % x != mod) {
          return -1
        }
        nums[i * n + j] = grid[i][j]
      }
    }
    Arrays.sort(nums)
    val mid = nums[nums.size shr 1]
    var ans = 0
    for (v in nums) {
      (ans += abs((v - mid).toDouble()) / x).toInt()
    }
    return ans
  }
}
