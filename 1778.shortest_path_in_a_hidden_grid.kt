import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet
import kotlin.collections.Set

/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 * boolean canMove(char direction);
 * void move(char direction);
 * boolean isTarget();
 * }
 */
internal class Solution {
  private var s: Set<Int>? = null
  private var target: IntArray?
  fun findShortestPath(master: GridMaster): Int {
    target = null
    s = HashSet()
    s.add(0)
    dfs(0, 0, master)
    if (target == null) {
      return -1
    }
    s.remove(0)
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 0))
    var ans = -1
    while (!q.isEmpty()) {
      ++ans
      for (n in q.size() downTo 1) {
        val p = q.poll()
        val i = p[0]
        val j = p[1]
        if (target.get(0) == i && target.get(1) == j) {
          return ans
        }
        for (k in 0..3) {
          val x: Int = i + Solution.Companion.dirs.get(k)
          val y: Int = j + Solution.Companion.dirs.get(k + 1)
          if (s.contains(x * Solution.Companion.N + y)) {
            s.remove(x * Solution.Companion.N + y)
            q.offer(intArrayOf(x, y))
          }
        }
      }
    }
    return -1
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
      if (master.canMove(d) && !s!!.contains(x * Solution.Companion.N + y)) {
        s.add(x * Solution.Companion.N + y)
        master.move(d)
        dfs(x, y, master)
        master.move(nd)
      }
    }
  }

  companion object {
    private val dir = charArrayOf('U', 'R', 'D', 'L')
    private val ndir = charArrayOf('D', 'L', 'U', 'R')
    private val dirs = intArrayOf(-1, 0, 1, 0, -1)
    private const val N = 1010
  }
}
