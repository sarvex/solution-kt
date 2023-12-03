internal class Solution {
  fun twoCitySchedCost(costs: Array<IntArray>): Int {
    Arrays.sort(costs) { a, b -> a.get(0) - a.get(1) - (b.get(0) - b.get(1)) }
    var ans = 0
    val n = costs.size shr 1
    for (i in 0 until n) {
      ans += costs[i][0] + costs[i + n][1]
    }
    return ans
  }
}
