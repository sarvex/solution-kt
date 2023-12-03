import kotlin.math.min

internal class Solution {
  fun flipgame(fronts: IntArray, backs: IntArray): Int {
    val s: Set<Int> = HashSet()
    val n = fronts.size
    for (i in 0 until n) {
      if (fronts[i] == backs[i]) {
        s.add(fronts[i])
      }
    }
    var ans = 9999
    for (v in fronts) {
      if (!s.contains(v)) {
        ans = min(ans.toDouble(), v.toDouble()).toInt()
      }
    }
    for (v in backs) {
      if (!s.contains(v)) {
        ans = min(ans.toDouble(), v.toDouble()).toInt()
      }
    }
    return ans % 9999
  }
}
