internal class Solution {
  fun tictactoe(moves: Array<IntArray>): String {
    val n = moves.size
    val cnt = IntArray(8)
    var k = n - 1
    while (k >= 0) {
      val i = moves[k][0]
      val j = moves[k][1]
      cnt[i]++
      cnt[j + 3]++
      if (i == j) {
        cnt[6]++
      }
      if (i + j == 2) {
        cnt[7]++
      }
      if (cnt[i] == 3 || cnt[j + 3] == 3 || cnt[6] == 3 || cnt[7] == 3) {
        return if (k % 2 == 0) "A" else "B"
      }
      k -= 2
    }
    return if (n == 9) "Draw" else "Pending"
  }
}
