import kotlin.math.max

internal class Solution {
  fun maxDistance(colors: IntArray): Int {
    val n = colors.size
    if (colors[0] != colors[n - 1]) {
      return n - 1
    }
    var i = 0
    var j = n - 1
    while (colors[++i] == colors[0]);
    while (colors[--j] == colors[0]);
    return max((n - i - 1).toDouble(), j.toDouble()).toInt()
  }
}
