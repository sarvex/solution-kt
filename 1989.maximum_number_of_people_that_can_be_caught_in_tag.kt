import kotlin.math.abs

class Solution {
  fun catchMaximumAmountofPeople(team: IntArray, dist: Int): Int {
    var ans = 0
    val n = team.size
    var i = 0
    var j = 0
    while (i < n) {
      if (team[i] == 1) {
        while (j < n && (team[j] == 1 || i - j > dist)) {
          ++j
        }
        if (j < n && abs((i - j).toDouble()) <= dist) {
          ++ans
          ++j
        }
      }
      ++i
    }
    return ans
  }
}
