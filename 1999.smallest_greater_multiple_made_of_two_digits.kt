import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun findInteger(k: Int, digit1: Int, digit2: Int): Int {
    if (digit1 == 0 && digit2 == 0) {
      return -1
    }
    if (digit1 > digit2) {
      return findInteger(k, digit2, digit1)
    }
    val q: Deque<Long> = ArrayDeque()
    q.offer(0L)
    while (true) {
      val x = q.poll()
      if (x > Int.MAX_VALUE) {
        return -1
      }
      if (x > k && x % k == 0L) {
        return x.toInt()
      }
      q.offer(x * 10 + digit1)
      if (digit1 != digit2) {
        q.offer(x * 10 + digit2)
      }
    }
  }
}
