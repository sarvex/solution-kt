internal class Solution {
  fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
    val n = 8
    val s = Array(n) { BooleanArray(n) }
    for (q in queens) {
      s[q[0]][q[1]] = true
    }
    val ans: List<List<Int>> = ArrayList()
    for (a in -1..1) {
      for (b in -1..1) {
        if (a != 0 || b != 0) {
          var x = king[0] + a
          var y = king[1] + b
          while (x >= 0 && x < n && y >= 0 && y < n) {
            if (s[x][y]) {
              ans.add(List.of(x, y))
              break
            }
            x += a
            y += b
          }
        }
      }
    }
    return ans
  }
}
