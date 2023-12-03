internal class Solution {
  fun findRightInterval(intervals: Array<IntArray>): IntArray {
    val n = intervals.size
    val starts: List<IntArray> = ArrayList()
    for (i in 0 until n) {
      starts.add(intArrayOf(intervals[i][0], i))
    }
    starts.sort(Comparator.comparingInt { a -> a.get(0) })
    val res = IntArray(n)
    var i = 0
    for (interval in intervals) {
      var left = 0
      var right = n - 1
      val end = interval[1]
      while (left < right) {
        val mid = left + right shr 1
        if (starts[mid][0] >= end) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      res[i++] = if (starts[left][0] < end) -1 else starts[left][1]
    }
    return res
  }
}
