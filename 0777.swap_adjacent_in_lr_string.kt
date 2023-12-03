internal class Solution {
  fun canTransform(start: String, end: String): Boolean {
    val n = start.length
    var i = 0
    var j = 0
    while (true) {
      while (i < n && start[i] == 'X') {
        ++i
      }
      while (j < n && end[j] == 'X') {
        ++j
      }
      if (i == n && j == n) {
        return true
      }
      if (i == n || j == n || start[i] != end[j]) {
        return false
      }
      if (start[i] == 'L' && i < j || start[i] == 'R' && i > j) {
        return false
      }
      ++i
      ++j
    }
  }
}
