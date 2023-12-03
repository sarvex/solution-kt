class Solution {
  fun minCost(n: Int, cuts: IntArray): Int {
    val nums: List<Int> = ArrayList()
    for (x in cuts) {
      nums.add(x)
    }
    nums.add(0)
    nums.add(n)
    Collections.sort(nums)
    val m: Int = nums.size()
    val f = Array(m) { IntArray(m) }
    for (l in 2 until m) {
      var i = 0
      while (i + l < m) {
        val j = i + l
        f[i][j] = 1 shl 30
        for (k in i + 1 until j) {
          f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j] + nums[j] - nums[i])
        }
        ++i
      }
    }
    return f[0][m - 1]
  }
}
