import kotlin.math.max

class Solution {
  fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
    var ans = 0
    for (x in left) {
      ans = max(ans.toDouble(), x.toDouble()).toInt()
    }
    for (x in right) {
      ans = max(ans.toDouble(), (n - x).toDouble()).toInt()
    }
    return ans
  }
}
