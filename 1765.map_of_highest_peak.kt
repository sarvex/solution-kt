import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
    val m = isWater.size
    val n = isWater[0].size
    val ans = Array(m) { IntArray(n) }
    val q: Deque<IntArray> = ArrayDeque()
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans[i][j] = isWater[i][j] - 1
        if (ans[i][j] == 0) {
          q.offer(intArrayOf(i, j))
        }
      }
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      val i: Int = p.get(0)
      val j: Int = p.get(1)
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
          ans[x][y] = ans[i][j] + 1
          q.offer(intArrayOf(x, y))
        }
      }
    }
    return ans
  }
}
