import kotlin.math.max

class Solution {
  fun findMaximalUncoveredRanges(n: Int, ranges: Array<IntArray>): Array<IntArray> {
    Arrays.sort(ranges) { a, b -> a.get(0) - b.get(0) }
    var last = -1
    val ans: List<IntArray> = ArrayList()
    for (range in ranges) {
      val l = range[0]
      val r = range[1]
      if (last + 1 < l) {
        ans.add(intArrayOf(last + 1, l - 1))
      }
      last = max(last.toDouble(), r.toDouble()).toInt()
    }
    if (last + 1 < n) {
      ans.add(intArrayOf(last + 1, n - 1))
    }
    return ans.toArray(arrayOfNulls<IntArray>(0))
  }
}
