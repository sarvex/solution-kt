class Solution {
  private var grid: Array<IntArray>
  fun matrixMedian(grid: Array<IntArray>): Int {
    this.grid = grid
    val m = grid.size
    val n = grid[0].size
    val target = m * n + 1 shr 1
    var left = 0
    var right = 1000010
    while (left < right) {
      val mid = left + right shr 1
      if (count(mid) >= target) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun count(x: Int): Int {
    var cnt = 0
    for (row in grid) {
      var left = 0
      var right = row.size
      while (left < right) {
        val mid = left + right shr 1
        if (row[mid] > x) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      cnt += left
    }
    return cnt
  }
}
