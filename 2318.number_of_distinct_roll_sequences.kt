class Solution {
  fun distinctSequences(n: Int): Int {
    if (n == 1) {
      return 6
    }
    val mod = 1e9.toInt() + 7
    val dp = Array(n + 1) { Array(6) { IntArray(6) } }
    for (i in 0..5) {
      for (j in 0..5) {
        if (gcd(i + 1, j + 1) == 1 && i != j) {
          dp[2][i][j] = 1
        }
      }
    }
    for (k in 3..n) {
      for (i in 0..5) {
        for (j in 0..5) {
          if (gcd(i + 1, j + 1) == 1 && i != j) {
            for (h in 0..5) {
              if (gcd(h + 1, i + 1) == 1 && h != i && h != j) {
                dp[k][i][j] = (dp[k][i][j] + dp[k - 1][h][i]) % mod
              }
            }
          }
        }
      }
    }
    var ans = 0
    for (i in 0..5) {
      for (j in 0..5) {
        ans = (ans + dp[n][i][j]) % mod
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
