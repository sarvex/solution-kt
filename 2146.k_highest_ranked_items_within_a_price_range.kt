internal class Solution {
  fun highestRankedKItems(
    grid: Array<IntArray>, pricing: IntArray, start: IntArray, k: Int
  ): List<List<Int>> {
    val m = grid.size
    val n = grid[0].size
    val row = start[0]
    val col = start[1]
    val low = pricing[0]
    val high = pricing[1]
    val items: List<IntArray> = ArrayList()
    if (low <= grid[row][col] && grid[row][col] <= high) {
      items.add(intArrayOf(0, grid[row][col], row, col))
    }
    grid[row][col] = 0
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(row, col, 0))
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val p: IntArray = q.poll()
      val i = p[0]
      val j = p[1]
      val d = p[2]
      for (l in 0..3) {
        val x = i + dirs[l]
        val y = j + dirs[l + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0) {
          if (low <= grid[x][y] && grid[x][y] <= high) {
            items.add(intArrayOf(d + 1, grid[x][y], x, y))
          }
          grid[x][y] = 0
          q.offer(intArrayOf(x, y, d + 1))
        }
      }
    }
    items.sort { a, b ->
      if (a.get(0) !== b.get(0)) {
        return@sort a.get(0) - b.get(0)
      }
      if (a.get(1) !== b.get(1)) {
        return@sort a.get(1) - b.get(1)
      }
      if (a.get(2) !== b.get(2)) {
        return@sort a.get(2) - b.get(2)
      }
      a.get(3) - b.get(3)
    }
    val ans: List<List<Int>> = ArrayList()
    var i = 0
    while (i < items.size() && i < k) {
      val p = items[i]
      ans.add(Arrays.asList(p[2], p[3]))
      ++i
    }
    return ans
  }
}
