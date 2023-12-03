internal class Solution {
  fun judgeCircle(moves: String): Boolean {
    var x = 0
    var y = 0
    for (i in 0 until moves.length) {
      val c = moves[i]
      if (c == 'R') ++x else if (c == 'L') --x else if (c == 'U') ++y else if (c == 'D') --y
    }
    return x == 0 && y == 0
  }
}
