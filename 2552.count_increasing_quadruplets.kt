class Solution {
  fun countQuadruplets(nums: IntArray): Long {
    val n = nums.size
    val f = Array(n) { IntArray(n) }
    val g = Array(n) { IntArray(n) }
    for (j in 1 until n - 2) {
      var cnt = 0
      for (l in j + 1 until n) {
        if (nums[l] > nums[j]) {
          ++cnt
        }
      }
      for (k in j + 1 until n - 1) {
        if (nums[j] > nums[k]) {
          f[j][k] = cnt
        } else {
          --cnt
        }
      }
    }
    var ans: Long = 0
    for (k in 2 until n - 1) {
      var cnt = 0
      for (i in 0 until k) {
        if (nums[i] < nums[k]) {
          ++cnt
        }
      }
      for (j in k - 1 downTo 1) {
        if (nums[j] > nums[k]) {
          g[j][k] = cnt
          ans += f[j][k].toLong() * g[j][k]
        } else {
          --cnt
        }
      }
    }
    return ans
  }
}
