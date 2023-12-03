import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maxTotalFruits(fruits: Array<IntArray>, startPos: Int, k: Int): Int {
    var ans = 0
    var s = 0
    var i = 0
    var j = 0
    while (j < fruits.size) {
      val pj = fruits[j][0]
      val fj = fruits[j][1]
      s += fj
      while (i <= j
        && pj - fruits[i][0]
        + min(abs((startPos - fruits[i][0]).toDouble()), abs((startPos - pj).toDouble()))
        > k
      ) {
        s -= fruits[i++][1]
      }
      ans = max(ans.toDouble(), s.toDouble()).toInt()
      ++j
    }
    return ans
  }
}
