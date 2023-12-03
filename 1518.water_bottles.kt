class Solution {
  fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var numBottles = numBottles
    var ans = numBottles
    while (numBottles >= numExchange) {
      numBottles -= numExchange - 1
      ++ans
    }
    return ans
  }
}
