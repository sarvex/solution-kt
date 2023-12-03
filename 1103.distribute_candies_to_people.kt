import kotlin.math.min

internal class Solution {
  fun distributeCandies(candies: Int, num_people: Int): IntArray {
    var candies = candies
    val ans = IntArray(num_people)
    var i = 0
    while (candies > 0) {
      (ans[i % num_people] += min(candies.toDouble(), (i + 1).toDouble())).toInt()
      (candies -= min(candies.toDouble(), (i + 1).toDouble())).toInt()
      ++i
    }
    return ans
  }
}
