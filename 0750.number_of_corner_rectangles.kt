internal class Solution {
  fun countCornerRectangles(grid: Array<IntArray>): Int {
    val n = grid[0].size
    var ans = 0
    val cnt: Map<List<Int>, Int> = HashMap()
    for (row in grid) {
      for (i in 0 until n) {
        if (row[i] == 1) {
          for (j in i + 1 until n) {
            if (row[j] == 1) {
              val t: List<Int> = List.of(i, j)
              ans += cnt[t] ?: 0
              cnt.merge(t, 1) { a: Int, b: Int -> Integer.sum(a, b) }
            }
          }
        }
      }
    }
    return ans
  }
}
