/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 * boolean canMove(char direction);
 * int move(char direction);
 * boolean isTarget();
 * }
 */
internal class Solution {
  private var target: IntArray
  fun findShortestPath(master: GridMaster): Int {
    target = intArrayOf(-1, -1)
    for (i in 0 until Solution.Companion.N) {
      Arrays.fill(Solution.Companion.g.get(i), -1)
      Arrays.fill(Solution.Companion.dist.get(i), Solution.Companion.INF)
    }
    dfs(100, 100, master)
    if (target[0] == -1 && target[1] == -1) {
      return -1
    }
    val q: PriorityQueue<IntArray> = PriorityQueue(Comparator.comparingInt { a -> a.get(0) })
    q.offer(intArrayOf(0, 100, 100))
    Solution.Companion.dist.get(100).get(100) = 0
    while (!q.isEmpty()) {
      val p: IntArray = q.poll()
      val w = p[0]
      val i = p[1]
      val j = p[2]
      if (i == target[0] && j == target[1]) {
        return w
      }
      for (k in 0..3) {
        val x: Int = i + Solution.Companion.dirs.get(k)
        val y: Int = j + Solution.Companion.dirs.get(k + 1)
        if (x >= 0 && x < Solution.Companion.N && y >= 0 && y < Solution.Companion.N && Solution.Companion.g.get(x)
            .get(y) != -1 && Solution.Companion.dist.get(x).get(y) > w + Solution.Companion.g.get(x).get(y)
        ) {
          Solution.Companion.dist.get(x).get(y) = w + Solution.Companion.g.get(x).get(y)
          q.offer(intArrayOf(Solution.Companion.dist.get(x).get(y), x, y))
        }
      }
    }
    return 0
  }

  private fun dfs(i: Int, j: Int, master: GridMaster) {
    if (master.isTarget()) {
      target = intArrayOf(i, j)
    }
    for (k in 0..3) {
      val d: Char = Solution.Companion.dir.get(k)
      val nd: Char = Solution.Companion.ndir.get(k)
      val x: Int = i + Solution.Companion.dirs.get(k)
      val y: Int = j + Solution.Companion.dirs.get(k + 1)
      if (x >= 0 && x < Solution.Companion.N && y >= 0 && y < Solution.Companion.N && master.canMove(d) && Solution.Companion.g.get(
          x
        ).get(y) == -1
      ) {
        Solution.Companion.g.get(x).get(y) = master.move(d)
        dfs(x, y, master)
        master.move(nd)
      }
    }
  }

  companion object {
    private val dir = charArrayOf('U', 'R', 'D', 'L')
    private val ndir = charArrayOf('D', 'L', 'U', 'R')
    private val dirs = intArrayOf(-1, 0, 1, 0, -1)
    private const val N = 200
    private const val INF = 0x3f3f3f3f
    private val g = Array<IntArray>(Solution.Companion.N) { IntArray(Solution.Companion.N) }
    private val dist = Array<IntArray>(Solution.Companion.N) { IntArray(Solution.Companion.N) }
  }
}
