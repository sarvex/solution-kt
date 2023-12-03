class Solution {
  fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
    var ans = 0
    for (i in startTime.indices) {
      if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
        ++ans
      }
    }
    return ans
  }
}
