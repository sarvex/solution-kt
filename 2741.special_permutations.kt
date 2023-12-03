class Solution {
  fun specialPerm(nums: IntArray): Int {
    val mod = 1e9.toInt() + 7
    val n = nums.size
    val m = 1 shl n
    val f = Array(m) { IntArray(n) }
    for (i in 1 until m) {
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          val ii = i xor (1 shl j)
          if (ii == 0) {
            f[i][j] = 1
            continue
          }
          for (k in 0 until n) {
            if (nums[j] % nums[k] == 0 || nums[k] % nums[j] == 0) {
              f[i][j] = (f[i][j] + f[ii][k]) % mod
            }
          }
        }
      }
    }
    var ans = 0
    for (x in f[m - 1]) {
      ans = (ans + x) % mod
    }
    return ans
  }
}
