class Solution {
  private var c: Array<IntArray>
  private val mod = 1e9.toInt() + 7
  fun numOfWays(nums: IntArray): Int {
    val n = nums.size
    c = Array(n) { IntArray(n) }
    c[0][0] = 1
    for (i in 1 until n) {
      c[i][0] = 1
      for (j in 1..i) {
        c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % mod
      }
    }
    val list: List<Int> = ArrayList()
    for (x in nums) {
      list.add(x)
    }
    return (dfs(list) - 1 + mod) % mod
  }

  private fun dfs(nums: List<Int>): Int {
    if (nums.size() < 2) {
      return 1
    }
    val left: List<Int> = ArrayList()
    val right: List<Int> = ArrayList()
    for (x in nums) {
      if (x < nums[0]) {
        left.add(x)
      } else if (x > nums[0]) {
        right.add(x)
      }
    }
    val m: Int = left.size()
    val n: Int = right.size()
    val a = dfs(left)
    val b = dfs(right)
    return (a.toLong() * b % mod * c[m + n][n] % mod).toInt()
  }
}
