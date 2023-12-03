import kotlin.math.min

internal class Solution {
  private var n = 0
  fun snakesAndLadders(board: Array<IntArray>): Int {
    n = board.size
    val q: Deque<Int> = ArrayDeque()
    q.offer(1)
    val vis = BooleanArray(n * n + 1)
    vis[1] = true
    var ans = 0
    while (!q.isEmpty()) {
      for (t in q.size() downTo 1) {
        val curr: Int = q.poll()
        if (curr == n * n) {
          return ans
        }
        for (k in curr + 1..min((curr + 6).toDouble(), (n * n).toDouble()).toInt()) {
          val p = get(k)
          var next = k
          val i = p[0]
          val j = p[1]
          if (board[i][j] != -1) {
            next = board[i][j]
          }
          if (!vis[next]) {
            vis[next] = true
            q.offer(next)
          }
        }
      }
      ++ans
    }
    return -1
  }

  private operator fun get(x: Int): IntArray {
    val i = (x - 1) / n
    var j = (x - 1) % n
    if (i % 2 == 1) {
      j = n - 1 - j
    }
    return intArrayOf(n - 1 - i, j)
  }
}
