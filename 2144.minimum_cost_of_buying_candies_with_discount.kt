class Solution {
  fun minimumCost(cost: IntArray): Int {
    Arrays.sort(cost)
    var ans = 0
    var i = cost.size - 1
    while (i >= 0) {
      ans += cost[i]
      if (i > 0) {
        ans += cost[i - 1]
      }
      i -= 3
    }
    return ans
  }
}
