class Solution {
  fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
    Arrays.sort(intervals) { a, b -> if (a.get(0) - b.get(0) === 0) b.get(1) - a.get(1) else a.get(0) - b.get(0) }
    var pre = intervals[0]
    var cnt = 1
    for (i in 1 until intervals.size) {
      if (pre[1] < intervals[i][1]) {
        ++cnt
        pre = intervals[i]
      }
    }
    return cnt
  }
}
