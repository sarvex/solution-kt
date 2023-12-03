class Solution {
  fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
    var ans = 0
    for (x in hours) {
      if (x >= target) {
        ++ans
      }
    }
    return ans
  }
}
