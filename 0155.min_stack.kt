internal class MinStack {
  private val stk1: Deque<Int> = ArrayDeque()
  private val stk2: Deque<Int> = ArrayDeque()

  init {
    stk2.push(Int.MAX_VALUE)
  }

  fun push(`val`: Int) {
    stk1.push(`val`)
    stk2.push(Math.min(`val`, stk2.peek()))
  }

  fun pop() {
    stk1.pop()
    stk2.pop()
  }

  fun top(): Int {
    return stk1.peek()
  }

  val min: Int
    get() = stk2.peek()
}
