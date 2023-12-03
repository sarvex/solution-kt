import java.util.Deque

internal class Solution {
  private var heights: Array<IntArray>
  private var m = 0
  private var n = 0
  fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    m = heights.size
    n = heights[0].size
    this.heights = heights
    val q1: Deque<IntArray> = LinkedList()
    val q2: Deque<IntArray> = LinkedList()
    val vis1: Set<Int> = HashSet()
    val vis2: Set<Int> = HashSet()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (i == 0 || j == 0) {
          vis1.add(i * n + j)
          q1.offer(intArrayOf(i, j))
        }
        if (i == m - 1 || j == n - 1) {
          vis2.add(i * n + j)
          q2.offer(intArrayOf(i, j))
        }
      }
    }
    bfs(q1, vis1)
    bfs(q2, vis2)
    val ans: List<List<Int>> = ArrayList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        val x = i * n + j
        if (vis1.contains(x) && vis2.contains(x)) {
          ans.add(Arrays.asList(i, j))
        }
      }
    }
    return ans
  }

  private fun bfs(q: Deque<IntArray>, vis: Set<Int>) {
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        val p = q.poll()
        for (i in 0..3) {
          val x = p[0] + dirs[i]
          val y = p[1] + dirs[i + 1]
          if (x >= 0 && x < m && y >= 0 && y < n && !vis.contains(x * n + y) && heights[x][y] >= heights[p[0]][p[1]]) {
            vis.add(x * n + y)
            q.offer(intArrayOf(x, y))
          }
        }
      }
    }
  }
}
