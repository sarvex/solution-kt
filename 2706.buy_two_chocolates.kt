class Solution {
  fun buyChoco(prices: IntArray, money: Int): Int {
    Arrays.sort(prices)
    val cost = prices[0] + prices[1]
    return if (money < cost) money else money - cost
  }
}
