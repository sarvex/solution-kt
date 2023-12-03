import java.util.*
import kotlin.collections.ArrayDeque

class BrowserHistory(homepage: String?) {
  private val stk1: Deque<String?> = ArrayDeque()
  private val stk2: Deque<String?> = ArrayDeque()

  init {
    visit(homepage)
  }

  fun visit(url: String?) {
    stk1.push(url)
    stk2.clear()
  }

  fun back(steps: Int): String? {
    var steps = steps
    while (steps > 0 && stk1.size() > 1) {
      stk2.push(stk1.pop())
      --steps
    }
    return stk1.peek()
  }

  fun forward(steps: Int): String? {
    var steps = steps
    while (steps > 0 && !stk2.isEmpty()) {
      stk1.push(stk2.pop())
      --steps
    }
    return stk1.peek()
  }
}
