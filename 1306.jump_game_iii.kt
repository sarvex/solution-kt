import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.List

class Solution {
  fun canReach(arr: IntArray, start: Int): Boolean {
    val q: Deque<Int> = ArrayDeque()
    q.offer(start)
    while (!q.isEmpty()) {
      val i = q.poll()
      if (arr[i] == 0) {
        return true
      }
      val x = arr[i]
      arr[i] = -1
      for (j in List.of(i + x, i - x)) {
        if (j >= 0 && j < arr.size && arr[j] >= 0) {
          q.offer(j)
        }
      }
    }
    return false
  }
}
