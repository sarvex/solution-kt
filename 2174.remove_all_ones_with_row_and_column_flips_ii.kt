class Solution {
  fun removeOnes(grid: Array<IntArray>): Int {
    val m = grid.size
    val n = grid[0].size
    var state = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (grid[i][j] == 1) {
          state = state or (1 shl i * n + j)
        }
      }
    }
    val q: Deque<Int> = ArrayDeque()
    q.offer(state)
    val vis: Set<Int> = HashSet()
    vis.add(state)
    var ans = 0
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        state = q.poll()
        if (state == 0) {
          return ans
        }
        for (i in 0 until m) {
          for (j in 0 until n) {
            if (grid[i][j] == 0) {
              continue
            }
            var nxt = state
            for (r in 0 until m) {
              nxt = nxt and (1 shl r * n + j).inv()
            }
            for (c in 0 until n) {
              nxt = nxt and (1 shl i * n + c).inv()
            }
            if (!vis.contains(nxt)) {
              vis.add(nxt)
              q.offer(nxt)
            }
          }
        }
      }
      ++ans
    }
    return -1
  }
}
