internal class Solution {
  fun minKnightMoves(x: Int, y: Int): Int {
    var x = x
    var y = y
    x += 310
    y += 310
    var ans = 0
    val q: Queue<IntArray> = ArrayDeque()
    q.offer(intArrayOf(310, 310))
    val vis = Array(700) { BooleanArray(700) }
    vis[310][310] = true
    val dirs = arrayOf(
      intArrayOf(-2, 1),
      intArrayOf(-1, 2),
      intArrayOf(1, 2),
      intArrayOf(2, 1),
      intArrayOf(2, -1),
      intArrayOf(1, -2),
      intArrayOf(-1, -2),
      intArrayOf(-2, -1)
    )
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        val p: IntArray = q.poll()
        if (p[0] == x && p[1] == y) {
          return ans
        }
        for (dir in dirs) {
          val c = p[0] + dir[0]
          val d = p[1] + dir[1]
          if (!vis[c][d]) {
            vis[c][d] = true
            q.offer(intArrayOf(c, d))
          }
        }
      }
      ++ans
    }
    return -1
  }
}
