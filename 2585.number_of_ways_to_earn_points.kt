class Solution {
  fun waysToReachTarget(target: Int, types: Array<IntArray>): Int {
    val n = types.size
    val mod = 1e9.toInt() + 7
    val f = Array(n + 1) { IntArray(target + 1) }
    f[0][0] = 1
    for (i in 1..n) {
      val count = types[i - 1][0]
      val marks = types[i - 1][1]
      for (j in 0..target) {
        for (k in 0..count) {
          if (j >= k * marks) {
            f[i][j] = (f[i][j] + f[i - 1][j - k * marks]) % mod
          }
        }
      }
    }
    return f[n][target]
  }
}
