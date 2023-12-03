import java.util.Deque
import kotlin.collections.ArrayDeque

class Solution {
  fun isTransformable(s: String, t: String): Boolean {
    val pos: Array<Deque<Int>?> = arrayOfNulls(10)
    Arrays.setAll(pos) { k -> ArrayDeque() }
    for (i in 0 until s.length) {
      pos[s[i].code - '0'.code]!!.offer(i)
    }
    for (i in 0 until t.length) {
      val x = t[i].code - '0'.code
      if (pos[x]!!.isEmpty()) {
        return false
      }
      for (j in 0 until x) {
        if (!pos[j]!!.isEmpty() && pos[j]!!.peek() < pos[x]!!.peek()) {
          return false
        }
      }
      pos[x]!!.poll()
    }
    return true
  }
}
