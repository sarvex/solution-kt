internal class Solution {
  fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
    var s = 0
    val n = calories.size
    for (i in 0 until k) {
      s += calories[i]
    }
    var ans = 0
    if (s < lower) {
      --ans
    } else if (s > upper) {
      ++ans
    }
    for (i in k until n) {
      s += calories[i] - calories[i - k]
      if (s < lower) {
        --ans
      } else if (s > upper) {
        ++ans
      }
    }
    return ans
  }
}
