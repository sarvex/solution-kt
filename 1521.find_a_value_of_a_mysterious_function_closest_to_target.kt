import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun closestToTarget(arr: IntArray, target: Int): Int {
    var ans = abs((arr[0] - target).toDouble()).toInt()
    var pre: Set<Int> = HashSet()
    pre.add(arr[0])
    for (x in arr) {
      val cur: Set<Int> = HashSet()
      for (y in pre) {
        cur.add(x and y)
      }
      cur.add(x)
      for (y in cur) {
        ans = min(ans.toDouble(), abs((y - target).toDouble())).toInt()
      }
      pre = cur
    }
    return ans
  }
}
