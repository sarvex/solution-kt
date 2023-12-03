import kotlin.math.max
import kotlin.math.min

class Solution {
  fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
    val ans: List<IntArray> = ArrayList()
    val m = firstList.size
    val n = secondList.size
    var i = 0
    var j = 0
    while (i < m && j < n) {
      val l = max(firstList[i][0].toDouble(), secondList[j][0].toDouble()).toInt()
      val r = min(firstList[i][1].toDouble(), secondList[j][1].toDouble()).toInt()
      if (l <= r) {
        ans.add(intArrayOf(l, r))
      }
      if (firstList[i][1] < secondList[j][1]) {
        ++i
      } else {
        ++j
      }
    }
    return ans.toArray(arrayOfNulls<IntArray>(ans.size()))
  }
}
