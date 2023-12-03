import kotlin.math.abs

internal class Solution {
  private val dist = IntArray(3600)
  private var forest: List<List<Int>>? = null
  private var m = 0
  private var n = 0
  fun cutOffTree(forest: List<List<Int>>): Int {
    this.forest = forest
    m = forest.size()
    n = forest[0].size()
    val trees: List<IntArray> = ArrayList()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (forest[i][j] > 1) {
          trees.add(intArrayOf(forest[i][j], i * n + j))
        }
      }
    }
    trees.sort(Comparator.comparingInt { a -> a.get(0) })
    var ans = 0
    var start = 0
    for (tree in trees) {
      val end = tree[1]
      val t = bfs(start, end)
      if (t == -1) {
        return -1
      }
      ans += t
      start = end
    }
    return ans
  }

  private fun bfs(start: Int, end: Int): Int {
    val q: PriorityQueue<IntArray> = PriorityQueue(Comparator.comparingInt { a -> a.get(0) })
    q.offer(intArrayOf(f(start, end), start))
    Arrays.fill(dist, Int.MAX_VALUE)
    dist[start] = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val state: Int = q.poll().get(1)
      if (state == end) {
        return dist[state]
      }
      for (k in 0..3) {
        val x = state / n + dirs[k]
        val y = state % n + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && forest!![x][y] > 0) {
          if (dist[x * n + y] > dist[state] + 1) {
            dist[x * n + y] = dist[state] + 1
            q.offer(intArrayOf(dist[x * n + y] + f(x * n + y, end), x * n + y))
          }
        }
      }
    }
    return -1
  }

  private fun f(start: Int, end: Int): Int {
    val a = start / n
    val b = start % n
    val c = end / n
    val d = end % n
    return (abs((a - c).toDouble()) + abs((b - d).toDouble())).toInt()
  }
}
