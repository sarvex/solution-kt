import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
    val m = box.size
    val n = box[0].size
    val ans = Array(n) { CharArray(m) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        ans[j][m - i - 1] = box[i][j]
      }
    }
    for (j in 0 until m) {
      val q: Deque<Int> = ArrayDeque()
      for (i in n - 1 downTo 0) {
        if (ans[i][j] == '*') {
          q.clear()
        } else if (ans[i][j] == '.') {
          q.offer(i)
        } else if (!q.isEmpty()) {
          ans[q.pollFirst()][j] = '#'
          ans[i][j] = '.'
          q.offer(i)
        }
      }
    }
    return ans
  }
}
