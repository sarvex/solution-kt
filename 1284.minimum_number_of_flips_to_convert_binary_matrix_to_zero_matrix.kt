import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet
import kotlin.collections.Set

class Solution {
  fun minFlips(mat: Array<IntArray>): Int {
    val m = mat.size
    val n = mat[0].size
    var state = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (mat[i][j] == 1) {
          state = state or (1 shl i * n + j)
        }
      }
    }
    val q: Deque<Int> = ArrayDeque()
    q.offer(state)
    val vis: Set<Int> = HashSet()
    vis.add(state)
    var ans = 0
    val dirs = intArrayOf(0, -1, 0, 1, 0, 0)
    while (!q.isEmpty()) {
      for (t in q.size() downTo 1) {
        state = q.poll()
        if (state == 0) {
          return ans
        }
        for (i in 0 until m) {
          for (j in 0 until n) {
            var nxt = state
            for (k in 0..4) {
              val x = i + dirs[k]
              val y = j + dirs[k + 1]
              if (x < 0 || x >= m || y < 0 || y >= n) {
                continue
              }
              if (nxt and (1 shl x * n + y) != 0) {
                nxt -= 1 shl x * n + y
              } else {
                nxt = nxt or (1 shl x * n + y)
              }
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
