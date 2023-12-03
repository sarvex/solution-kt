import java.util.*
import kotlin.collections.ArrayDeque

internal class MyStack {
  private var q1: Deque<Int> = ArrayDeque()
  private var q2: Deque<Int> = ArrayDeque()
  fun push(x: Int) {
    q2.offer(x)
    while (!q1.isEmpty()) {
      q2.offer(q1.poll())
    }
    val q = q1
    q1 = q2
    q2 = q
  }

  fun pop(): Int {
    return q1.poll()
  }

  fun top(): Int {
    return q1.peek()
  }

  fun empty(): Boolean {
    return q1.isEmpty()
  }
}
