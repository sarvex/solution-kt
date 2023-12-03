class Solution {
  private var grid: Array<IntArray>
  private var vis: BooleanArray
  private var match: IntArray
  private var n = 0
  fun maximumInvitations(grid: Array<IntArray>): Int {
    val m = grid.size
    n = grid[0].size
    this.grid = grid
    vis = BooleanArray(n)
    match = IntArray(n)
    Arrays.fill(match, -1)
    var ans = 0
    for (i in 0 until m) {
      Arrays.fill(vis, false)
      if (find(i)) {
        ++ans
      }
    }
    return ans
  }

  private fun find(i: Int): Boolean {
    for (j in 0 until n) {
      if (grid[i][j] == 1 && !vis[j]) {
        vis[j] = true
        if (match[j] == -1 || find(match[j])) {
          match[j] = i
          return true
        }
      }
    }
    return false
  }
}
