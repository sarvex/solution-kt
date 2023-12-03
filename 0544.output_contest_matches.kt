internal class Solution {
  fun findContestMatch(n: Int): String? {
    var n = n
    val team = arrayOfNulls<String>(n)
    for (i in 0 until n) {
      team[i] = "" + (i + 1)
    }
    while (n > 1) {
      for (i in 0 until n / 2) {
        team[i] = "(" + team[i] + "," + team[n - 1 - i] + ")"
      }
      n /= 2
    }
    return team[0]
  }
}
