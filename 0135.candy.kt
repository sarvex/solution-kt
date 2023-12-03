internal class Solution {
  fun candy(ratings: IntArray): Int {
    val n = ratings.size
    var up = 0
    var down = 0
    var peak = 0
    var candies = 1
    for (i in 1 until n) {
      if (ratings[i - 1] < ratings[i]) {
        up++
        peak = up + 1
        down = 0
        candies += peak
      } else if (ratings[i] == ratings[i - 1]) {
        peak = 0
        up = 0
        down = 0
        candies++
      } else {
        down++
        up = 0
        candies += down + if (peak > down) 0 else 1
      }
    }
    return candies
  }
}
