import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun maxCandies(
    status: IntArray, candies: IntArray, keys: Array<IntArray>, containedBoxes: Array<IntArray>, initialBoxes: IntArray
  ): Int {
    var ans = 0
    val n = status.size
    val has = BooleanArray(n)
    val took = BooleanArray(n)
    val q: Deque<Int> = ArrayDeque()
    for (i in initialBoxes) {
      has[i] = true
      if (status[i] == 1) {
        ans += candies[i]
        took[i] = true
        q.offer(i)
      }
    }
    while (!q.isEmpty()) {
      val i = q.poll()
      for (k in keys[i]) {
        status[k] = 1
        if (has[k] && !took[k]) {
          ans += candies[k]
          took[k] = true
          q.offer(k)
        }
      }
      for (j in containedBoxes[i]) {
        has[j] = true
        if (status[j] == 1 && !took[j]) {
          ans += candies[j]
          took[j] = true
          q.offer(j)
        }
      }
    }
    return ans
  }
}
