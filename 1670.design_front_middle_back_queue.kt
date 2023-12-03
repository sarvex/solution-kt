import java.util.*
import kotlin.collections.ArrayDeque

class FrontMiddleBackQueue {
  private val q1: Deque<Int> = ArrayDeque()
  private val q2: Deque<Int> = ArrayDeque()
  fun pushFront(`val`: Int) {
    q1.offerFirst(`val`)
    rebalance()
  }

  fun pushMiddle(`val`: Int) {
    q1.offerLast(`val`)
    rebalance()
  }

  fun pushBack(`val`: Int) {
    q2.offerLast(`val`)
    rebalance()
  }

  fun popFront(): Int {
    if (q1.isEmpty() && q2.isEmpty()) {
      return -1
    }
    val `val` = if (q1.isEmpty()) q2.pollFirst() else q1.pollFirst()
    rebalance()
    return `val`
  }

  fun popMiddle(): Int {
    if (q1.isEmpty() && q2.isEmpty()) {
      return -1
    }
    val `val` = if (q1.size() === q2.size()) q1.pollLast() else q2.pollFirst()
    rebalance()
    return `val`
  }

  fun popBack(): Int {
    if (q2.isEmpty()) {
      return -1
    }
    val `val` = q2.pollLast()
    rebalance()
    return `val`
  }

  private fun rebalance() {
    if (q1.size() > q2.size()) {
      q2.offerFirst(q1.pollLast())
    }
    if (q2.size() > q1.size() + 1) {
      q1.offerLast(q2.pollFirst())
    }
  }
}
