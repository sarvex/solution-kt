import java.util.*
import kotlin.collections.ArrayDeque

internal class MyQueue {
  private val stk1: Deque<Int> = ArrayDeque()
  private val stk2: Deque<Int> = ArrayDeque()
  fun push(x: Int) {
    stk1.push(x)
  }

  fun pop(): Int {
    move()
    return stk2.pop()
  }

  fun peek(): Int {
    move()
    return stk2.peek()
  }

  fun empty(): Boolean {
    return stk1.isEmpty() && stk2.isEmpty()
  }

  private fun move() {
    while (stk2.isEmpty()) {
      while (!stk1.isEmpty()) {
        stk2.push(stk1.pop())
      }
    }
  }
}
