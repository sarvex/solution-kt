internal class Solution {
  fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
    var k = k
    val m = grid.size
    val n = grid[0].size
    k %= m * n
    val ans: List<List<Int>> = ArrayList()
    for (i in 0 until m) {
      val t: List<Int> = ArrayList()
      for (j in 0 until n) {
        t.add(0)
      }
      ans.add(t)
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        val t = (i * n + j + k) % (m * n)
        ans[t / n].set(t % n, grid[i][j])
      }
    }
    return ans
  }
}
