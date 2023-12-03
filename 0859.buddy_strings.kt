internal class Solution {
  fun buddyStrings(s: String, goal: String): Boolean {
    val m = s.length
    val n = goal.length
    if (m != n) {
      return false
    }
    var diff = 0
    val cnt1 = IntArray(26)
    val cnt2 = IntArray(26)
    for (i in 0 until n) {
      val a = s[i].code
      val b = goal[i].code
      ++cnt1[a - 'a'.code]
      ++cnt2[b - 'a'.code]
      if (a != b) {
        ++diff
      }
    }
    var f = false
    for (i in 0..25) {
      if (cnt1[i] != cnt2[i]) {
        return false
      }
      if (cnt1[i] > 1) {
        f = true
      }
    }
    return diff == 2 || diff == 0 && f
  }
}
