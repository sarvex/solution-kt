import kotlin.math.max

internal class Solution {
  private var bombs: Array<IntArray>
  fun maximumDetonation(bombs: Array<IntArray>): Int {
    this.bombs = bombs
    val n = bombs.size
    val g = Array(n) { BooleanArray(n) }
    for (i in 0 until n) {
      for (j in 0 until n) {
        g[i][j] = check(i, j)
      }
    }
    var ans = 0
    for (k in 0 until n) {
      val q: Deque<Int> = ArrayDeque()
      q.offer(k)
      val vis = BooleanArray(n)
      vis[k] = true
      var cnt = 0
      while (!q.isEmpty()) {
        val i: Int = q.poll()
        ++cnt
        for (j in 0 until n) {
          if (g[i][j] && !vis[j]) {
            vis[j] = true
            q.offer(j)
          }
        }
      }
      ans = max(ans.toDouble(), cnt.toDouble()).toInt()
    }
    return ans
  }

  private fun check(i: Int, j: Int): Boolean {
    if (i == j) {
      return false
    }
    val x = (bombs[i][0] - bombs[j][0]).toLong()
    val y = (bombs[i][1] - bombs[j][1]).toLong()
    val r = bombs[i][2].toLong()
    return r * r >= x * x + y * y
  }
}
