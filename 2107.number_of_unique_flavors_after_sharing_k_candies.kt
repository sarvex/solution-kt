internal class Solution {
  fun shareCandies(candies: IntArray, k: Int): Int {
    val cnt: Map<Int, Int> = HashMap()
    val n = candies.size
    for (i in k until n) {
      cnt.merge(candies[i], 1) { a: Int, b: Int -> Integer.sum(a, b) }
    }
    var ans: Int = cnt.size()
    for (i in k until n) {
      cnt.merge(candies[i - k], 1) { a: Int, b: Int -> Integer.sum(a, b) }
      if (cnt.merge(candies[i], -1) { a: Int, b: Int -> Integer.sum(a, b) } === 0) {
        cnt.remove(candies[i])
      }
      ans = Math.max(ans, cnt.size())
    }
    return ans
  }
}
