internal class Solution {
  fun change(amount: Int, coins: IntArray): Int {
    val dp = IntArray(amount + 1)
    dp[0] = 1
    for (coin in coins) {
      for (j in coin..amount) {
        dp[j] += dp[j - coin]
      }
    }
    return dp[amount]
  }
}
