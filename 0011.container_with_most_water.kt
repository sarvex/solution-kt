import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maxArea(height: IntArray): Int {
    var i = 0
    var j = height.size - 1
    var ans = 0
    while (i < j) {
      val t = (min(height[i].toDouble(), height[j].toDouble()) * (j - i)).toInt()
      ans = max(ans.toDouble(), t.toDouble()).toInt()
      if (height[i] < height[j]) {
        ++i
      } else {
        --j
      }
    }
    return ans
  }
}
