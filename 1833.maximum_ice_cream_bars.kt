class Solution {
  fun maxIceCream(costs: IntArray, coins: Int): Int {
    var coins = coins
    Arrays.sort(costs)
    val n = costs.size
    for (i in 0 until n) {
      if (coins < costs[i]) {
        return i
      }
      coins -= costs[i]
    }
    return n
  }
}
