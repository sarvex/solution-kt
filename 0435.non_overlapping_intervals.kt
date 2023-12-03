internal class Solution {
  fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    Arrays.sort(intervals, Comparator.comparingInt { a -> a.get(1) })
    var t = intervals[0][1]
    var ans = 0
    for (i in 1 until intervals.size) {
      if (intervals[i][0] >= t) {
        t = intervals[i][1]
      } else {
        ++ans
      }
    }
    return ans
  }
}
