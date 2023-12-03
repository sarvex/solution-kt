import kotlin.math.min

internal class Solution {
  fun countSubMultisets(nums: List<Int>, l: Int, r: Int): Int {
    var r = r
    val count: Map<Int, Int> = HashMap()
    var total = 0
    for (num in nums) {
      total += num
      if (num <= r) {
        count.merge(num, 1) { a: Int, b: Int -> Integer.sum(a, b) }
      }
    }
    if (total < l) {
      return 0
    }
    r = min(r.toDouble(), total.toDouble()).toInt()
    val dp = IntArray(r + 1)
    dp[0] = (count[0] ?: 0) + 1
    count.remove(0)
    var sum = 0
    for (e in count.entrySet()) {
      val num: Int = e.getKey()
      val c: Int = e.getValue()
      sum = min((sum + c * num).toDouble(), r.toDouble()).toInt()
      // prefix part
      // dp[i] = dp[i] + dp[i - num] + ... + dp[i - c*num] + dp[i-(c+1)*num] + ... + dp[i %
      // num]
      for (i in num..sum) {
        dp[i] = (dp[i] + dp[i - num]) % Solution.Companion.MOD
      }
      val temp = (c + 1) * num
      // correction part
      // subtract dp[i - (freq + 1) * num] to the end part.
      // leves dp[i] = dp[i] + dp[i-num] +...+ dp[i - c*num];
      for (i in sum downTo temp) {
        dp[i] = (dp[i] - dp[i - temp] + Solution.Companion.MOD) % Solution.Companion.MOD
      }
    }
    var ans = 0
    for (i in l..r) {
      ans += dp[i]
      ans %= Solution.Companion.MOD
    }
    return ans
  }

  companion object {
    const val MOD = 1000000007
  }
}
