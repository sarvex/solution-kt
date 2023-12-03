import kotlin.math.min

class Solution {
  private var m = 0
  private var n = 0
  private var grid: Array<IntArray>
  fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
    m = grid.size
    n = grid[0].size
    this.grid = grid
    for (p in 0 until (min(m.toDouble(), n.toDouble()) / 2).toInt()) {
      rotate(p, k)
    }
    return grid
  }

  private fun rotate(p: Int, k: Int) {
    var k = k
    val nums: List<Int> = ArrayList()
    for (j in p until n - p - 1) {
      nums.add(grid[p][j])
    }
    for (i in p until m - p - 1) {
      nums.add(grid[i][n - p - 1])
    }
    for (j in n - p - 1 downTo p + 1) {
      nums.add(grid[m - p - 1][j])
    }
    for (i in m - p - 1 downTo p + 1) {
      nums.add(grid[i][p])
    }
    val l: Int = nums.size()
    k %= l
    if (k == 0) {
      return
    }
    for (j in p until n - p - 1) {
      grid[p][j] = nums[k++ % l]
    }
    for (i in p until m - p - 1) {
      grid[i][n - p - 1] = nums[k++ % l]
    }
    for (j in n - p - 1 downTo p + 1) {
      grid[m - p - 1][j] = nums[k++ % l]
    }
    for (i in m - p - 1 downTo p + 1) {
      grid[i][p] = nums[k++ % l]
    }
  }
}
