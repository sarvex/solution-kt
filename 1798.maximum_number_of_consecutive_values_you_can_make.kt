class Solution {
  fun getMaximumConsecutive(coins: IntArray): Int {
    Arrays.sort(coins)
    var ans = 1
    for (v in coins) {
      if (v > ans) {
        break
      }
      ans += v
    }
    return ans
  }
}
