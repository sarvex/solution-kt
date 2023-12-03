import kotlin.math.abs

class Solution {
  fun furthestDistanceFromOrigin(moves: String): Int {
    return (abs((count(moves, 'L') - count(moves, 'R')).toDouble()) + count(moves, '_')).toInt()
  }

  private fun count(s: String, c: Char): Int {
    var cnt = 0
    for (i in 0 until s.length) {
      if (s[i] == c) {
        ++cnt
      }
    }
    return cnt
  }
}
