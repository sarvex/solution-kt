import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun clumsy(N: Int): Int {
    val s: Deque<Int> = ArrayDeque()
    s.offerLast(N)
    var op = 0
    for (i in N - 1 downTo 1) {
      if (op == 0) {
        s.offerLast(s.pollLast() * i)
      } else if (op == 1) {
        s.offerLast(s.pollLast() / i)
      } else if (op == 2) {
        s.offerLast(i)
      } else {
        s.offerLast(-i)
      }
      op = (op + 1) % 4
    }
    var res = 0
    while (!s.isEmpty()) {
      res += s.pollLast()
    }
    return res
  }
}
