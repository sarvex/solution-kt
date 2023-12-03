internal class Solution {
  fun winnerOfGame(colors: String): Boolean {
    val n = colors.length
    var a = 0
    var b = 0
    var i = 0
    var j = 0
    while (i < n) {
      while (j < n && colors[j] == colors[i]) {
        ++j
      }
      val m = j - i - 2
      if (m > 0) {
        if (colors[i] == 'A') {
          a += m
        } else {
          b += m
        }
      }
      i = j
    }
    return a > b
  }
}
