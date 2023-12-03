internal class Solution {
  fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
    Arrays.sort(intervals) { a, b -> a.get(0) - b.get(0) }
    for (i in 1 until intervals.size) {
      val a = intervals[i - 1]
      val b = intervals[i]
      if (a[1] > b[0]) {
        return false
      }
    }
    return true
  }
}
