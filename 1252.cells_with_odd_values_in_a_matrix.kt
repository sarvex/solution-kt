internal class Solution {
  fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
    val row = IntArray(m)
    val col = IntArray(n)
    for (e in indices) {
      val r = e[0]
      val c = e[1]
      row[r]++
      col[c]++
    }
    var ans = 0
    for (i in row) {
      for (j in col) {
        ans += (i + j) % 2
      }
    }
    return ans
  }
}
