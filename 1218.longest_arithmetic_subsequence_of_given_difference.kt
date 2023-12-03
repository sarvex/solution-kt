internal class Solution {
  fun longestSubsequence(arr: IntArray, difference: Int): Int {
    val dp: Map<Int, Int> = HashMap()
    var ans = 1
    for (num in arr) {
      dp.put(num, (dp[num - difference] ?: 0) + 1)
      ans = Math.max(ans, dp[num]!!)
    }
    return ans
  }
}
