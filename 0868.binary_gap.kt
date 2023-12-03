import kotlin.math.max

internal class Solution {
  fun binaryGap(n: Int): Int {
    var n = n
    var ans = 0
    var i = 0
    var j = -1
    while (n != 0) {
      if (n and 1 == 1) {
        if (j != -1) {
          ans = max(ans.toDouble(), (i - j).toDouble()).toInt()
        }
        j = i
      }
      ++i
      n = n shr 1
    }
    return ans
  }
}
